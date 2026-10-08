package com.hive.authv4;

import com.facebook.appevents.UserDataStore;
import com.hive.AuthV4;
import com.hive.analytics.AnalyticsImpl;
import com.hive.auth.AuthVerifier;
import com.hive.base.Android;
import com.hive.base.Property;
import com.hive.configuration.ConfigurationImpl;
import com.hive.logger.LoggerImpl;
import com.hive.standalone.HiveLifecycle;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005J\b\u0010,\u001a\u00020\u0005H\u0007J\b\u0010-\u001a\u00020(H\u0007J\u001c\u0010.\u001a\u00020\u00052\b\u0010/\u001a\u0004\u0018\u00010\b2\b\u00100\u001a\u0004\u0018\u00010\bH\u0002R\u0018\u0010\u0004\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\"\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\"\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\"\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\"\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\"\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\"\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\"\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000bR\"\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000bR\"\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000bR\"\u0010\u001d\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000bR\"\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000bR\"\u0010!\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000bR\"\u0010#\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u000bR\"\u0010%\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000b¨\u00061"}, d2 = {"Lcom/hive/authv4/AuthV4Verifier;", "", "<init>", "()V", "isCheckDeviceChangedExecuted", "", "isCheckDeviceChangedExecuted$annotations", "value", "", "curVersion", "getCurVersion", "()Ljava/lang/String;", UserDataStore.COUNTRY, "getCountry", "language", "getLanguage", "gameLanguage", "getGameLanguage", Android.HW_IDS_DEVICE_MODEL, "getDeviceModel", "osVersion", "getOsVersion", "osApiLevel", "getOsApiLevel", "isRooting", Android.HW_IDS_ADVERTISING_ID, "getAdvertisingId", "deviceId", "getDeviceId", Android.HW_IDS_ANDROID_ID, "getAndroidId", Android.HW_IDS_MDN, "getMdn", "emulator", "getEmulator", "zone", "getZone", "did", "getDid", "startSession", "", "checkDownload", "isPrepare", "saveCheckDownloadResult", "checkDeviceChanged", "saveDeviceInfo", "isNotEquals", "a", "b", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4Verifier {
    public static final AuthV4Verifier INSTANCE = new AuthV4Verifier();
    private static String advertisingId;
    private static String androidId;
    private static String country;
    private static String curVersion;
    private static String deviceId;
    private static String deviceModel;
    private static String did;
    private static String emulator;
    private static String gameLanguage;
    private static boolean isCheckDeviceChangedExecuted;
    private static String isRooting;
    private static String language;
    private static String mdn;
    private static String osApiLevel;
    private static String osVersion;
    private static String zone;

    private AuthV4Verifier() {
    }

    @Deprecated(message = "")
    private static /* synthetic */ void isCheckDeviceChangedExecuted$annotations() {
    }

    private final boolean isNotEquals(String a2, String b) {
        if (a2 == null) {
            a2 = "";
        }
        if (b == null) {
            b = "";
        }
        return !Intrinsics.areEqual(a2, b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveDeviceInfo$lambda$0() {
        if (!isCheckDeviceChangedExecuted) {
            INSTANCE.checkDeviceChanged();
        }
        Property.Companion companion = Property.INSTANCE;
        Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.DEVICECHECK_COUNTRY, country, null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.DEVICECHECK_LANGUAGE, language, null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.DEVICECHECK_GAME_LANGUAGE, gameLanguage, null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.DEVICECHECK_DEVICE_MODEL, deviceModel, null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.DEVICECHECK_OS_VERSION, osVersion, null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.DEVICECHECK_OS_API_LEVEL, osApiLevel, null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.DEVICECHECK_IS_ROOTING, isRooting, null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.DEVICECHECK_ADVERTISING_ID, advertisingId, null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.DEVICECHECK_ANDROID_ID, androidId, null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.DEVICECHECK_MDN, mdn, null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.DEVICECHECK_EMULATOR, emulator, null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.DEVICECHECK_DID, did, null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.DEVICECHECK_ZONE, zone, null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.DEVICECHECK_APP_VERSION, curVersion, null, 4, null);
        companion.getINSTANCE().writeProperties();
    }

    @Deprecated(message = "")
    public final synchronized boolean checkDeviceChanged() {
        boolean z;
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d(AuthV4.getTAG(), "[AuthV4Verifier] checkDeviceChanged()");
        Android android2 = Android.INSTANCE;
        country = android2.getCountry();
        language = android2.getLanguage();
        ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
        gameLanguage = configurationImpl.getHiveLanguage();
        deviceModel = android2.getDeviceModel();
        osVersion = android2.getOSVersion();
        osApiLevel = String.valueOf(android2.getOSVersionCode());
        isRooting = String.valueOf(android2.isRooting());
        advertisingId = android2.getAdvertisingId();
        androidId = android2.getAndroidId();
        mdn = android2.getMobileDeviceNumber();
        emulator = android2.isEmulator();
        zone = configurationImpl.getZone().name();
        did = HiveLifecycle.INSTANCE.getDid();
        curVersion = android2.getAppVersion();
        isCheckDeviceChangedExecuted = true;
        Property.Companion companion = Property.INSTANCE;
        String value = companion.getINSTANCE().getValue(AuthV4Keys.DEVICECHECK_COUNTRY);
        String value2 = companion.getINSTANCE().getValue(AuthV4Keys.DEVICECHECK_LANGUAGE);
        String value3 = companion.getINSTANCE().getValue(AuthV4Keys.DEVICECHECK_GAME_LANGUAGE);
        String value4 = companion.getINSTANCE().getValue(AuthV4Keys.DEVICECHECK_DEVICE_MODEL);
        String value5 = companion.getINSTANCE().getValue(AuthV4Keys.DEVICECHECK_OS_VERSION);
        String value6 = companion.getINSTANCE().getValue(AuthV4Keys.DEVICECHECK_OS_API_LEVEL);
        String value7 = companion.getINSTANCE().getValue(AuthV4Keys.DEVICECHECK_IS_ROOTING);
        String value8 = companion.getINSTANCE().getValue(AuthV4Keys.DEVICECHECK_ADVERTISING_ID);
        String value9 = companion.getINSTANCE().getValue(AuthV4Keys.DEVICECHECK_ANDROID_ID);
        String value10 = companion.getINSTANCE().getValue(AuthV4Keys.DEVICECHECK_MDN);
        String value11 = companion.getINSTANCE().getValue(AuthV4Keys.DEVICECHECK_EMULATOR);
        String value12 = companion.getINSTANCE().getValue(AuthV4Keys.DEVICECHECK_ZONE);
        String value13 = companion.getINSTANCE().getValue(AuthV4Keys.DEVICECHECK_DID);
        String value14 = companion.getINSTANCE().getValue(AuthV4Keys.DEVICECHECK_APP_VERSION);
        boolean zCheckDownload = isNotEquals(country, value) ? true : checkDownload(false);
        if (isNotEquals(language, value2)) {
            zCheckDownload = true;
        }
        if (isNotEquals(gameLanguage, value3)) {
            zCheckDownload = true;
        }
        if (isNotEquals(deviceModel, value4)) {
            zCheckDownload = true;
        }
        if (isNotEquals(osVersion, value5)) {
            zCheckDownload = true;
        }
        if (isNotEquals(osApiLevel, value6)) {
            zCheckDownload = true;
        }
        if (isNotEquals(isRooting, value7)) {
            zCheckDownload = true;
        }
        if (isNotEquals(advertisingId, value8)) {
            zCheckDownload = true;
        }
        if (isNotEquals(androidId, value9)) {
            zCheckDownload = true;
        }
        if (isNotEquals(mdn, value10)) {
            zCheckDownload = true;
        }
        if (isNotEquals(emulator, value11)) {
            zCheckDownload = true;
        }
        if (isNotEquals(zone, value12)) {
            zCheckDownload = true;
        }
        if (isNotEquals(did, value13)) {
            zCheckDownload = true;
        }
        z = isNotEquals(curVersion, value14) ? true : zCheckDownload;
        loggerImpl.d(AuthV4.getTAG(), "[AuthV4Verifier] checkDeviceChanged() : " + z);
        return z;
    }

    public final boolean checkDownload(boolean isPrepare) {
        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[AuthV4Verifier] checkDownload(), isPrepare: " + isPrepare);
        String value = isPrepare ? Property.INSTANCE.getINSTANCE().getValue(AuthV4Keys.PREPARE_DOWNLOAD_CHECK_APP_VERSION) : Property.INSTANCE.getINSTANCE().getValue(AuthV4Keys.DOWNLOAD_CHECK_APP_VERSION);
        curVersion = Android.INSTANCE.getAppVersion();
        boolean zAreEqual = true;
        if (value != null) {
            try {
                String string = StringsKt.trim((CharSequence) value).toString();
                String str = curVersion;
                zAreEqual = true ^ Intrinsics.areEqual(string, str != null ? StringsKt.trim((CharSequence) str).toString() : null);
            } catch (Exception e) {
                e.printStackTrace();
                zAreEqual = false;
            }
        } else if (isPrepare) {
            AnalyticsImpl.INSTANCE.sendUserEntryFunnelsLogs(AnalyticsImpl.FunnelsTrack.NEW_INSTALL);
        }
        if (zAreEqual) {
            LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[AuthV4Verifier][checkDownload] isUpdatedVersion true : updated app had been installed. " + curVersion);
        } else {
            LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[AuthV4Verifier][checkDownload] isUpdatedVersion false : current version is " + curVersion);
        }
        return zAreEqual;
    }

    public final String getAdvertisingId() {
        return advertisingId;
    }

    public final String getAndroidId() {
        return androidId;
    }

    public final String getCountry() {
        return country;
    }

    public final String getCurVersion() {
        return curVersion;
    }

    public final String getDeviceId() {
        return deviceId;
    }

    public final String getDeviceModel() {
        return deviceModel;
    }

    public final String getDid() {
        return did;
    }

    public final String getEmulator() {
        return emulator;
    }

    public final String getGameLanguage() {
        return gameLanguage;
    }

    public final String getLanguage() {
        return language;
    }

    public final String getMdn() {
        return mdn;
    }

    public final String getOsApiLevel() {
        return osApiLevel;
    }

    public final String getOsVersion() {
        return osVersion;
    }

    public final String getZone() {
        return zone;
    }

    public final String isRooting() {
        return isRooting;
    }

    public final synchronized boolean saveCheckDownloadResult(boolean isPrepare) {
        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[AuthV4Verifier] saveCheckDownloadResult(), isPrepare: " + isPrepare);
        if (isPrepare) {
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), AuthV4Keys.PREPARE_DOWNLOAD_CHECK_APP_VERSION, curVersion, null, 4, null);
        } else {
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), AuthV4Keys.DOWNLOAD_CHECK_APP_VERSION, curVersion, null, 4, null);
        }
        return Property.INSTANCE.getINSTANCE().writeProperties();
    }

    @Deprecated(message = "")
    public final synchronized void saveDeviceInfo() {
        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[AuthV4Verifier] saveDeviceInfo()");
        new Thread(new Runnable() { // from class: com.hive.authv4.AuthV4Verifier$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4Verifier.saveDeviceInfo$lambda$0();
            }
        }).start();
    }

    public final void startSession() {
        AuthVerifier.INSTANCE.startSession(true);
    }
}
