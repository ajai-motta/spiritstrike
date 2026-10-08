package com.hive.auth;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.analytics.AnalyticsImpl;
import com.hive.auth.AuthNetwork;
import com.hive.base.Android;
import com.hive.base.Property;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.logger.LoggerImpl;
import com.hive.protocol.activeuser.Download;
import com.hive.protocol.activeuser.SessionLog;
import com.hive.protocol.activeuser.UpdateDid;
import com.hive.standalone.HiveLifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\u001c\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\r\u0010\u001f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010 J\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\u0016J\u0006\u0010#\u001a\u00020\u0016J\b\u0010$\u001a\u00020\u0010H\u0002J\b\u0010%\u001a\u00020\u0016H\u0002J\b\u0010&\u001a\u00020\u0016H\u0002J\b\u0010'\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Lcom/hive/auth/AuthVerifier;", "", "<init>", "()V", "SESSION_DEFAULT_ONE_LIMIT_TIME", "", "sessions", "Lorg/json/JSONArray;", "lastSession", "Lorg/json/JSONObject;", "lastStopTime", "", "lastSendTime", "session_max_num", "session_max_time", "isSessionExecuted", "", "isAuthV4", "currentTime", "getCurrentTime", "()J", "verifier", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function0;", "checkDownload", "checkDID", "isEquals", "a", "", "b", "startSession", "()Ljava/lang/Boolean;", "(Z)Ljava/lang/Boolean;", "onActivityStarted", "onActivityStoped", "lastSendSessionTimeCheck", "sendSessions", "loadSessions", "saveSessions", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthVerifier {
    private static boolean isAuthV4;
    private static boolean isSessionExecuted;
    private static int session_max_time;
    public static final AuthVerifier INSTANCE = new AuthVerifier();
    private static final int SESSION_DEFAULT_ONE_LIMIT_TIME = 10;
    private static JSONArray sessions = new JSONArray();
    private static JSONObject lastSession = new JSONObject();
    private static long lastStopTime = -1;
    private static long lastSendTime = -1;
    private static int session_max_num = 1;

    private AuthVerifier() {
    }

    private final boolean checkDID() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d(AuthDataInterface.getTAG(), "[AuthVerifier] checkDID()");
        Android android2 = Android.INSTANCE;
        String mobileDeviceNumber = android2.getMobileDeviceNumber();
        String androidId = android2.getAndroidId();
        String oSVersion = android2.getOSVersion();
        String strValueOf = String.valueOf(android2.isRooting());
        ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
        String strName = configurationImpl.getZone().name();
        String did = HiveLifecycle.INSTANCE.getDid();
        String country = android2.getCountry();
        String language = android2.getLanguage();
        String hiveLanguage = configurationImpl.getHiveLanguage();
        String deviceModel = android2.getDeviceModel();
        String strValueOf2 = String.valueOf(android2.getOSVersionCode());
        String strIsEmulator = android2.isEmulator();
        String advertisingId = android2.getAdvertisingId();
        String appVersion = android2.getAppVersion();
        Property.Companion companion = Property.INSTANCE;
        Property instance = companion.getINSTANCE();
        AuthKeys authKeys = AuthKeys.INSTANCE;
        String value = instance.getValue(authKeys.getDIDCHECK_MDN());
        companion.getINSTANCE().getValue(authKeys.getDIDCHECK_DEVICE_ID());
        String value2 = companion.getINSTANCE().getValue(authKeys.getDIDCHECK_ANDROID_ID());
        String value3 = companion.getINSTANCE().getValue(authKeys.getDIDCHECK_OS_VERSION());
        String value4 = companion.getINSTANCE().getValue(authKeys.getDIDCHECK_DID());
        String value5 = companion.getINSTANCE().getValue(authKeys.getDIDCHECK_IS_ROOTING());
        String value6 = companion.getINSTANCE().getValue(authKeys.getDIDCHECK_ZONE());
        String value7 = companion.getINSTANCE().getValue(authKeys.getDIDCHECK_COUNTRY());
        String value8 = companion.getINSTANCE().getValue(authKeys.getDIDCHECK_LANGUAGE());
        String value9 = companion.getINSTANCE().getValue(authKeys.getDIDCHECK_GAME_LANGUAGE());
        String value10 = companion.getINSTANCE().getValue(authKeys.getDIDCHECK_DEVICE_MODEL());
        String value11 = companion.getINSTANCE().getValue(authKeys.getDIDCHECK_OS_API_LEVEL());
        String value12 = companion.getINSTANCE().getValue(authKeys.getDIDCHECK_EMULATOR());
        String value13 = companion.getINSTANCE().getValue(authKeys.getDIDCHECK_ADVERTISING_ID());
        String value14 = companion.getINSTANCE().getValue(authKeys.getDIDCHECK_APP_VERSION());
        boolean z = !isEquals(mobileDeviceNumber, value);
        if (!isEquals(androidId, value2)) {
            z = true;
        }
        if (!isEquals(oSVersion, value3)) {
            z = true;
        }
        if (!isEquals(strValueOf, value5)) {
            z = true;
        }
        if (!isEquals(strName, value6)) {
            z = true;
        }
        if (!isEquals(did, value4)) {
            z = true;
        }
        if (!isEquals(country, value7)) {
            z = true;
        }
        if (!isEquals(language, value8)) {
            z = true;
        }
        if (!isEquals(hiveLanguage, value9)) {
            z = true;
        }
        if (!isEquals(deviceModel, value10)) {
            z = true;
        }
        if (!isEquals(strValueOf2, value11)) {
            z = true;
        }
        if (!isEquals(strIsEmulator, value12)) {
            z = true;
        }
        if (!isEquals(advertisingId, value13)) {
            z = true;
        }
        boolean z2 = isEquals(appVersion, value14) ? z : true;
        loggerImpl.d(AuthDataInterface.getTAG(), "[AuthVerifier] checkDID() : " + z2);
        return z2;
    }

    private final boolean checkDownload() {
        LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[AuthVerifier] checkDownload()");
        String value = Property.INSTANCE.getINSTANCE().getValue(AuthKeys.INSTANCE.getDOWNLOAD_CHECK_APP_VERSION());
        String appVersion = Android.INSTANCE.getAppVersion();
        if (appVersion == null) {
            appVersion = "";
        }
        boolean zEquals = true;
        if (value != null) {
            try {
                zEquals = true ^ TextUtils.equals(StringsKt.trim((CharSequence) value).toString(), StringsKt.trim((CharSequence) appVersion).toString());
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[AuthVerifier] checkDownload() Exception : " + e);
                zEquals = false;
            }
        } else {
            AnalyticsImpl.INSTANCE.sendUserEntryFunnelsLogs(AnalyticsImpl.FunnelsTrack.NEW_INSTALL);
        }
        if (zEquals) {
            LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[AuthVerifier][checkDownload] isUpdatedVersion true : updated app had been installed");
        } else {
            LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[AuthVerifier][checkDownload] isUpdatedVersion false : current version is " + appVersion);
        }
        return zEquals;
    }

    private final long getCurrentTime() {
        return System.currentTimeMillis() / 1000;
    }

    private final boolean isEquals(String a2, String b) {
        if (TextUtils.isEmpty(a2)) {
            a2 = "";
        }
        if (TextUtils.isEmpty(b)) {
            b = "";
        }
        return TextUtils.equals(a2, b);
    }

    private final boolean lastSendSessionTimeCheck() {
        boolean z;
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d(AuthDataInterface.getTAG(), "lastSendSessionTimeCheck");
        if (lastSession.length() > 0) {
            long currentTime = getCurrentTime() - lastStopTime;
            int i = SESSION_DEFAULT_ONE_LIMIT_TIME;
            if (currentTime > i) {
                loggerImpl.d(AuthDataInterface.getTAG(), "after one session limit time (" + i + "sec)");
                sessions.put(lastSession);
                JSONObject jSONObject = new JSONObject();
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_start, Long.valueOf(INSTANCE.getCurrentTime()));
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_length, 0);
                lastSession = jSONObject;
                lastStopTime = -1L;
                Property.Companion companion = Property.INSTANCE;
                Property instance = companion.getINSTANCE();
                AuthKeys authKeys = AuthKeys.INSTANCE;
                Property.setValue$default(instance, authKeys.getSESSION_DATA(), sessions.toString(), null, 4, null);
                Property.setValue$default(companion.getINSTANCE(), authKeys.getSESSION_LAST_SESSION(), "", null, 4, null);
                Property.setValue$default(companion.getINSTANCE(), authKeys.getSESSION_LAST_STOP_TIME(), "", null, 4, null);
                companion.getINSTANCE().writeProperties();
            } else {
                loggerImpl.d(AuthDataInterface.getTAG(), "before one session limit time (" + i + "sec)");
            }
        }
        boolean z2 = true;
        if (getCurrentTime() - lastSendTime > session_max_time) {
            loggerImpl.d(AuthDataInterface.getTAG(), "after interval time (" + session_max_time + "sec)");
            z = true;
        } else {
            loggerImpl.d(AuthDataInterface.getTAG(), "before interval time (" + session_max_time + "sec)");
            z = false;
        }
        if (sessions.length() >= session_max_num) {
            loggerImpl.d(AuthDataInterface.getTAG(), "sessions over : " + sessions.length() + " / " + session_max_num);
        } else {
            loggerImpl.d(AuthDataInterface.getTAG(), "sessions not over : " + sessions.length() + " / " + session_max_num);
            z2 = z;
        }
        if (!TextUtils.isEmpty(HiveLifecycle.INSTANCE.getDid())) {
            return z2;
        }
        loggerImpl.d(AuthDataInterface.getTAG(), "DID is Empty");
        return false;
    }

    private final void loadSessions() {
        JSONObject jSONObject;
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d(AuthDataInterface.getTAG(), "loadSessions");
        try {
            if (sessions.length() <= 0) {
                String value = Property.INSTANCE.getINSTANCE().getValue(AuthKeys.INSTANCE.getSESSION_DATA());
                sessions = TextUtils.isEmpty(value) ? new JSONArray() : new JSONArray(value);
            }
            loggerImpl.d(AuthDataInterface.getTAG(), "loaded Sessions : " + sessions);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "load Sessions failed " + e.getMessage());
            sessions = new JSONArray();
        }
        try {
            try {
                if (lastSession.length() <= 0) {
                    String value2 = Property.INSTANCE.getINSTANCE().getValue(AuthKeys.INSTANCE.getSESSION_LAST_SESSION());
                    if (TextUtils.isEmpty(value2)) {
                        jSONObject = new JSONObject();
                        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_start, Long.valueOf(INSTANCE.getCurrentTime()));
                        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_length, 0);
                    } else {
                        jSONObject = new JSONObject(value2);
                    }
                    lastSession = jSONObject;
                }
                LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "loaded lastSession : " + lastSession);
            } catch (Exception unused) {
                LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "load lastSession create");
                JSONObject jSONObject2 = new JSONObject();
                CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_start, Long.valueOf(INSTANCE.getCurrentTime()));
                CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_length, 0);
                lastSession = jSONObject2;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "load lastSession failed");
        }
        try {
            if (lastStopTime == -1) {
                Property.Companion companion = Property.INSTANCE;
                Property instance = companion.getINSTANCE();
                AuthKeys authKeys = AuthKeys.INSTANCE;
                String value3 = instance.getValue(authKeys.getSESSION_LAST_STOP_TIME());
                if (value3 == null || StringsKt.isBlank(value3)) {
                    lastStopTime = getCurrentTime();
                    Property.setValue$default(companion.getINSTANCE(), authKeys.getSESSION_LAST_STOP_TIME(), String.valueOf(getCurrentTime()), null, 4, null);
                    companion.getINSTANCE().writeProperties();
                } else {
                    lastStopTime = Long.parseLong(value3);
                }
            }
            LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "loaded lastStopTime : " + lastStopTime);
        } catch (Exception e3) {
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "load lastStopTime failed : " + e3);
            lastStopTime = getCurrentTime();
            Property.Companion companion2 = Property.INSTANCE;
            Property.setValue$default(companion2.getINSTANCE(), AuthKeys.INSTANCE.getSESSION_LAST_STOP_TIME(), String.valueOf(lastStopTime), null, 4, null);
            companion2.getINSTANCE().writeProperties();
        }
        try {
            if (lastSendTime == -1) {
                Property.Companion companion3 = Property.INSTANCE;
                Property instance2 = companion3.getINSTANCE();
                AuthKeys authKeys2 = AuthKeys.INSTANCE;
                String value4 = instance2.getValue(authKeys2.getSESSION_LAST_SEND_TIME());
                if (value4 == null || StringsKt.isBlank(value4)) {
                    lastSendTime = getCurrentTime();
                    Property.setValue$default(companion3.getINSTANCE(), authKeys2.getSESSION_LAST_SEND_TIME(), String.valueOf(getCurrentTime()), null, 4, null);
                    companion3.getINSTANCE().writeProperties();
                } else {
                    lastSendTime = Long.parseLong(value4);
                }
            }
            LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "loaded lastSendTime : " + lastSendTime);
        } catch (Exception e4) {
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "load lastSendTime failed : " + e4);
            lastSendTime = getCurrentTime();
            Property.Companion companion4 = Property.INSTANCE;
            Property.setValue$default(companion4.getINSTANCE(), AuthKeys.INSTANCE.getSESSION_LAST_SEND_TIME(), String.valueOf(lastSendTime), null, 4, null);
            companion4.getINSTANCE().writeProperties();
        }
    }

    private final void saveSessions() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d(AuthDataInterface.getTAG(), "[AuthVerifier] saveSessions");
        lastStopTime = getCurrentTime();
        try {
            CommonIdentifierKt.put(lastSession, HiveKeys.KEY_length, Long.valueOf(lastStopTime - lastSession.getLong(TtmlNode.START)));
            loggerImpl.d(AuthDataInterface.getTAG(), "saved last session : " + lastSession);
            Property.Companion companion = Property.INSTANCE;
            Property instance = companion.getINSTANCE();
            AuthKeys authKeys = AuthKeys.INSTANCE;
            Property.setValue$default(instance, authKeys.getSESSION_LAST_SESSION(), lastSession.toString(), null, 4, null);
            Property.setValue$default(companion.getINSTANCE(), authKeys.getSESSION_LAST_STOP_TIME(), lastSession.toString(), null, 4, null);
            companion.getINSTANCE().writeProperties();
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[AuthVerifier] save Sessions failed : " + e);
        }
    }

    private final void sendSessions() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d(AuthDataInterface.getTAG(), "sendSessions");
        if (sessions.length() <= 0) {
            loggerImpl.d(AuthDataInterface.getTAG(), "non-exist session data");
            return;
        }
        int length = sessions.length();
        for (int i = 0; i < length; i++) {
            try {
                JSONObject jSONObjectOptJSONObject = sessions.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    AnalyticsImpl.INSTANCE.sendSessionTimespan(jSONObjectOptJSONObject.getLong(TtmlNode.START), jSONObjectOptJSONObject.getLong("length"));
                }
            } catch (JSONException e) {
                LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "sendSessions Exception: " + e);
            }
        }
        if (!isAuthV4) {
            AuthNetwork.ActiveUser.INSTANCE.sessionLog().request(new Function1() { // from class: com.hive.auth.AuthVerifier$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthVerifier.sendSessions$lambda$8((SessionLog) obj);
                }
            });
            return;
        }
        sessions = new JSONArray();
        lastSendTime = getCurrentTime();
        Property.Companion companion = Property.INSTANCE;
        Property instance = companion.getINSTANCE();
        AuthKeys authKeys = AuthKeys.INSTANCE;
        Property.setValue$default(instance, authKeys.getSESSION_DATA(), "", null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), authKeys.getSESSION_LAST_SEND_TIME(), String.valueOf(lastSendTime), null, 4, null);
        companion.getINSTANCE().writeProperties();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendSessions$lambda$8(SessionLog it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResponse().getResult().isSuccess()) {
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[AuthVerifier] [sendSessions] request success.");
            if (it.getResponse().isSuccess()) {
                sessions = new JSONArray();
                lastSendTime = INSTANCE.getCurrentTime();
                session_max_num = it.getResponse().getSession_max_num();
                session_max_time = it.getResponse().getSession_max_time();
                Property.Companion companion = Property.INSTANCE;
                Property instance = companion.getINSTANCE();
                AuthKeys authKeys = AuthKeys.INSTANCE;
                Property.setValue$default(instance, authKeys.getSESSION_DATA(), "", null, 4, null);
                Property.setValue$default(companion.getINSTANCE(), authKeys.getSESSION_LAST_SEND_TIME(), String.valueOf(lastSendTime), null, 4, null);
                Property.setValue$default(companion.getINSTANCE(), authKeys.getSESSION_LIMIT_NUM(), String.valueOf(session_max_num), null, 4, null);
                Property.setValue$default(companion.getINSTANCE(), authKeys.getSESSION_LIMIT_TIME(), String.valueOf(session_max_time), null, 4, null);
                companion.getINSTANCE().writeProperties();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit verifier$lambda$1(final Function0 function0, Download it) {
        HiveLifecycle hiveLifecycle;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResponse().isSuccess()) {
            Property.Companion companion = Property.INSTANCE;
            Property instance = companion.getINSTANCE();
            AuthKeys authKeys = AuthKeys.INSTANCE;
            String download_check_app_version = authKeys.getDOWNLOAD_CHECK_APP_VERSION();
            Android android2 = Android.INSTANCE;
            Property.setValue$default(instance, download_check_app_version, android2.getAppVersion(), null, 4, null);
            String mobileDeviceNumber = android2.getMobileDeviceNumber();
            String androidId = android2.getAndroidId();
            String oSVersion = android2.getOSVersion();
            String strValueOf = String.valueOf(android2.isRooting());
            HiveLifecycle hiveLifecycle2 = HiveLifecycle.INSTANCE;
            String did = hiveLifecycle2.getDid();
            ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
            String strName = configurationImpl.getZone().name();
            String country = android2.getCountry();
            String language = android2.getLanguage();
            String hiveLanguage = configurationImpl.getHiveLanguage();
            String deviceModel = android2.getDeviceModel();
            String strValueOf2 = String.valueOf(android2.getOSVersionCode());
            String strIsEmulator = android2.isEmulator();
            String advertisingId = android2.getAdvertisingId();
            String appVersion = android2.getAppVersion();
            if (!TextUtils.isEmpty(mobileDeviceNumber)) {
                Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_MDN(), mobileDeviceNumber, null, 4, null);
            }
            if (TextUtils.isEmpty(androidId)) {
                hiveLifecycle = hiveLifecycle2;
            } else {
                hiveLifecycle = hiveLifecycle2;
                Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_ANDROID_ID(), androidId, null, 4, null);
            }
            if (!TextUtils.isEmpty(oSVersion)) {
                Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_OS_VERSION(), oSVersion, null, 4, null);
            }
            if (!TextUtils.isEmpty(strValueOf)) {
                Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_IS_ROOTING(), strValueOf, null, 4, null);
            }
            if (!TextUtils.isEmpty(did)) {
                Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_DID(), did, null, 4, null);
            }
            if (!TextUtils.isEmpty(strName)) {
                Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_ZONE(), strName, null, 4, null);
            }
            if (!TextUtils.isEmpty(country)) {
                Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_COUNTRY(), country, null, 4, null);
            }
            if (!TextUtils.isEmpty(language)) {
                Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_LANGUAGE(), language, null, 4, null);
            }
            if (!TextUtils.isEmpty(hiveLanguage)) {
                Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_GAME_LANGUAGE(), hiveLanguage, null, 4, null);
            }
            if (!TextUtils.isEmpty(deviceModel)) {
                Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_DEVICE_MODEL(), deviceModel, null, 4, null);
            }
            if (!TextUtils.isEmpty(strValueOf2)) {
                Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_OS_API_LEVEL(), strValueOf2, null, 4, null);
            }
            if (!TextUtils.isEmpty(strIsEmulator)) {
                Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_EMULATOR(), strIsEmulator, null, 4, null);
            }
            if (!TextUtils.isEmpty(advertisingId)) {
                Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_ADVERTISING_ID(), advertisingId, null, 4, null);
            }
            if (!TextUtils.isEmpty(appVersion)) {
                Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_APP_VERSION(), appVersion, null, 4, null);
            }
            Property.setValue$default(companion.getINSTANCE(), authKeys.getSESSION_LIMIT_NUM(), String.valueOf(it.getResponse().getSession_max_num()), null, 4, null);
            Property.setValue$default(companion.getINSTANCE(), authKeys.getSESSION_LIMIT_TIME(), String.valueOf(it.getResponse().getSession_max_time()), null, 4, null);
            companion.getINSTANCE().writeProperties();
            if (!StringsKt.isBlank(it.getResponse().getDid())) {
                hiveLifecycle.setDid(it.getResponse().getDid());
            }
        }
        INSTANCE.startSession();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.AuthVerifier$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                function0.invoke();
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit verifier$lambda$3(final Function0 function0, UpdateDid it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResponse().isSuccess()) {
            Android android2 = Android.INSTANCE;
            String mobileDeviceNumber = android2.getMobileDeviceNumber();
            String androidId = android2.getAndroidId();
            String oSVersion = android2.getOSVersion();
            String strValueOf = String.valueOf(android2.isRooting());
            ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
            String strName = configurationImpl.getZone().name();
            HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
            String did = hiveLifecycle.getDid();
            String country = android2.getCountry();
            String language = android2.getLanguage();
            String hiveLanguage = configurationImpl.getHiveLanguage();
            String deviceModel = android2.getDeviceModel();
            String strValueOf2 = String.valueOf(android2.getOSVersionCode());
            String strIsEmulator = android2.isEmulator();
            String advertisingId = android2.getAdvertisingId();
            String appVersion = android2.getAppVersion();
            Property.Companion companion = Property.INSTANCE;
            Property instance = companion.getINSTANCE();
            AuthKeys authKeys = AuthKeys.INSTANCE;
            Property.setValue$default(instance, authKeys.getDIDCHECK_MDN(), TextUtils.isEmpty(mobileDeviceNumber) ? "" : mobileDeviceNumber, null, 4, null);
            Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_ANDROID_ID(), TextUtils.isEmpty(androidId) ? "" : androidId, null, 4, null);
            Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_OS_VERSION(), TextUtils.isEmpty(oSVersion) ? "" : oSVersion, null, 4, null);
            Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_IS_ROOTING(), TextUtils.isEmpty(strValueOf) ? "" : strValueOf, null, 4, null);
            Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_ZONE(), TextUtils.isEmpty(strName) ? "" : strName, null, 4, null);
            Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_DID(), TextUtils.isEmpty(did) ? "" : did, null, 4, null);
            Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_COUNTRY(), TextUtils.isEmpty(country) ? "" : country, null, 4, null);
            Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_LANGUAGE(), TextUtils.isEmpty(language) ? "" : language, null, 4, null);
            Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_GAME_LANGUAGE(), TextUtils.isEmpty(hiveLanguage) ? "" : hiveLanguage, null, 4, null);
            Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_DEVICE_MODEL(), TextUtils.isEmpty(deviceModel) ? "" : deviceModel, null, 4, null);
            Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_OS_API_LEVEL(), TextUtils.isEmpty(strValueOf2) ? "" : strValueOf2, null, 4, null);
            Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_EMULATOR(), TextUtils.isEmpty(strIsEmulator) ? "" : strIsEmulator, null, 4, null);
            Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_ADVERTISING_ID(), TextUtils.isEmpty(advertisingId) ? "" : advertisingId, null, 4, null);
            Property.setValue$default(companion.getINSTANCE(), authKeys.getDIDCHECK_APP_VERSION(), TextUtils.isEmpty(appVersion) ? "" : appVersion, null, 4, null);
            companion.getINSTANCE().writeProperties();
            if (!StringsKt.isBlank(it.getResponse().getDid())) {
                hiveLifecycle.setDid(it.getResponse().getDid());
            }
        }
        INSTANCE.startSession();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.AuthVerifier$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                function0.invoke();
            }
        });
        return Unit.INSTANCE;
    }

    public final void onActivityStarted() {
        if (!isSessionExecuted) {
            LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "SessionCheck not Started : isExecuted false");
            return;
        }
        LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "SessionCheck Started");
        loadSessions();
        if (lastSendSessionTimeCheck()) {
            sendSessions();
        }
    }

    public final void onActivityStoped() {
        if (!isSessionExecuted) {
            LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "SessionCheck not Stoped : isExecuted false");
        } else {
            LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "SessionCheck Stoped");
            saveSessions();
        }
    }

    public final Boolean startSession() {
        startSession(false);
        return Boolean.TRUE;
    }

    public final void verifier(final Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[AuthVerifier] verifier()");
        if (checkDownload()) {
            AuthNetwork.ActiveUser.INSTANCE.download().request(new Function1() { // from class: com.hive.auth.AuthVerifier$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthVerifier.verifier$lambda$1(listener, (Download) obj);
                }
            });
        } else if (checkDID()) {
            AuthNetwork.ActiveUser.INSTANCE.updateDid().request(new Function1() { // from class: com.hive.auth.AuthVerifier$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthVerifier.verifier$lambda$3(listener, (UpdateDid) obj);
                }
            });
        } else {
            startSession();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.AuthVerifier$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    listener.invoke();
                }
            });
        }
    }

    public final Boolean startSession(boolean isAuthV42) {
        isAuthV4 = isAuthV42;
        try {
            String value = Property.INSTANCE.getINSTANCE().getValue(AuthKeys.INSTANCE.getSESSION_LIMIT_NUM());
            if (value == null) {
                value = "1";
            }
            session_max_num = Integer.parseInt(value);
        } catch (Exception unused) {
            session_max_num = 1;
        }
        try {
            String value2 = Property.INSTANCE.getINSTANCE().getValue(AuthKeys.INSTANCE.getSESSION_LIMIT_TIME());
            if (value2 == null) {
                value2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            session_max_time = Integer.parseInt(value2);
        } catch (Exception unused2) {
            session_max_time = 0;
        }
        LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "SessionCheck initialize");
        isSessionExecuted = true;
        onActivityStarted();
        return Boolean.TRUE;
    }
}
