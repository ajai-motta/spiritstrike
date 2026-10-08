package com.hive.analytics.logger;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.hive.analytics.AnalyticsLogTransfer;
import com.hive.core.Configuration;
import com.hive.core.HiveCoreInitializer;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.OauthToken;
import com.hive.logger.LoggerImpl;
import com.hive.protocol.Protocol;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.provision.VerifyRemoteLogging;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.Resource;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010#\u001a\u00020$H\u0002J\u0006\u0010%\u001a\u00020\u0011J&\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0011J\u0006\u0010+\u001a\u00020$J\u0006\u0010,\u001a\u00020$J\b\u0010-\u001a\u00020\u0011H\u0002J(\u0010.\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0011H\u0002J\u0006\u00100\u001a\u00020$J\b\u00101\u001a\u00020$H\u0002J\u0010\u00102\u001a\u00020$2\u0006\u00103\u001a\u00020\u001cH\u0002J\u000e\u00104\u001a\u00020$2\u0006\u00105\u001a\u000206J\b\u00107\u001a\u00020$H\u0002J\b\u00108\u001a\u00020$H\u0002J*\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020;2\u0006\u0010\u001f\u001a\u00020\u00052\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020$0=J\u000e\u0010?\u001a\u00020\u00112\u0006\u0010@\u001a\u00020\u0005J\b\u0010A\u001a\u00020!H\u0002J\u0010\u0010B\u001a\u00020$2\u0006\u00105\u001a\u000206H\u0002J\u000e\u0010C\u001a\u00020$2\u0006\u00105\u001a\u000206J\u0018\u0010D\u001a\u00020$2\u0006\u00105\u001a\u0002062\b\u0010E\u001a\u0004\u0018\u00010FR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/hive/analytics/logger/RemoteLoggerV2;", "", "<init>", "()V", "kMessage", "", "kTag", "kLevel", "kTime", "kOrder", "kLaunchOrder", "kIsSDKLog", "kLaunchOrder_StoreKey", "kSESSION_DEFAULT_MINUTES", "", "kSESSION_TIME_INVALIDED", "isTemporaryAllowRemoteLogging", "", "value", "isEnableRemoteLogging", "()Z", "setEnableRemoteLogging", "(Z)V", "logOrder", "", "launchOrder", "logDeque", "", "Lorg/json/JSONObject;", "preferenceName", "logBlockThreadsID", "token", "expiredDate", "Ljava/util/Date;", "tokenCatchTime", "runLogProcess", "", "isActivate", "log", "level", ViewHierarchyConstants.TAG_KEY, NotificationCompat.CATEGORY_MESSAGE, "isSDKLog", "beginRemoteLoggerProcess", "endRemoteLoggerProcess", "isThreadLock", "makeRemoteLog", "message", "discardStackedLog", "sendStackedLog", "pushStackedLog", "jsonObj", "remoteLoggingValidation", "activity", "Landroid/app/Activity;", "remoteLoggingAgreementReject", "remoteLoggingAgreementAccept", "verifyRemoteLogging", "account", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "callback", "Lkotlin/Function1;", "Lcom/hive/protocol/provision/VerifyRemoteLogging;", "saveTokenFromURI", "strUri", "getTokenCatchTime", "showRemoteLogginAgreementAlert", "onResume", "onNewIntent", "intent", "Landroid/content/Intent;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RemoteLoggerV2 {
    public static final RemoteLoggerV2 INSTANCE;
    private static Date expiredDate;
    private static boolean isTemporaryAllowRemoteLogging;
    private static final String kIsSDKLog;
    private static final String kLaunchOrder;
    private static final String kLaunchOrder_StoreKey;
    private static final String kLevel;
    private static final String kMessage;
    private static final String kOrder;
    private static final int kSESSION_DEFAULT_MINUTES;
    private static final int kSESSION_TIME_INVALIDED = 0;
    private static final String kTag;
    private static final String kTime;
    private static long launchOrder;
    private static final List<Long> logBlockThreadsID;
    private static final List<JSONObject> logDeque;
    private static long logOrder;
    private static final String preferenceName;
    private static String token;
    private static Date tokenCatchTime;

    static {
        RemoteLoggerV2 remoteLoggerV2 = new RemoteLoggerV2();
        INSTANCE = remoteLoggerV2;
        kMessage = "baseData";
        kTag = "logTag";
        kLevel = "logLevel";
        kTime = "logTime";
        kOrder = "logOrder";
        kLaunchOrder = "launchOrder";
        kIsSDKLog = "isSDKLog";
        kLaunchOrder_StoreKey = "RemoteLogger_launchOrder";
        kSESSION_DEFAULT_MINUTES = 10;
        isTemporaryAllowRemoteLogging = true;
        logDeque = new ArrayList();
        preferenceName = "hiveLogging";
        logBlockThreadsID = new ArrayList();
        SharedPreferences sharedPreferences = HiveCoreInitializer.INSTANCE.getInitContext().getSharedPreferences("hiveLogging", 0);
        launchOrder = sharedPreferences.getLong("RemoteLogger_launchOrder", 0L);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putLong("RemoteLogger_launchOrder", launchOrder + 1);
        editorEdit.apply();
        remoteLoggerV2.runLogProcess();
    }

    private RemoteLoggerV2() {
    }

    private final Date getTokenCatchTime() {
        Date date = tokenCatchTime;
        if (date != null) {
            return date;
        }
        Date time = Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.US).getTime();
        tokenCatchTime = time;
        Intrinsics.checkNotNullExpressionValue(time, "also(...)");
        return time;
    }

    private final boolean isEnableRemoteLogging() {
        return Logger.INSTANCE.getRemoteLogEnable();
    }

    private final boolean isThreadLock() {
        return logBlockThreadsID.contains(Long.valueOf(Thread.currentThread().getId()));
    }

    private final JSONObject makeRemoteLog(String level, String tag, String message, boolean isSDKLog) {
        Object objM7415constructorimpl;
        if (message.length() > 4096) {
            message = message.substring(0, 4096);
            Intrinsics.checkNotNullExpressionValue(message, "substring(...)");
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Locale locale = Locale.US;
            objM7415constructorimpl = Result.m7415constructorimpl(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", locale).format(Calendar.getInstance(TimeZone.getTimeZone("GMT"), locale).getTime()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", "hive_client_remote_logging_log");
            jSONObject.put(kMessage, message);
            jSONObject.put(kTag, tag);
            jSONObject.put(kLevel, level);
            jSONObject.put(kTime, Result.m7414boximpl(objM7415constructorimpl));
            jSONObject.put(kIsSDKLog, isSDKLog ? 1 : 0);
            jSONObject.put(kOrder, logOrder);
            jSONObject.put(kLaunchOrder, launchOrder);
            logOrder++;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private final synchronized void pushStackedLog(JSONObject jsonObj) {
        logDeque.add(jsonObj);
    }

    private final void remoteLoggingAgreementAccept() {
        String str = token;
        if (str != null) {
            if (StringsKt.isBlank(str)) {
                str = null;
            }
            if (str != null) {
                HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
                HiveLifecycle.HiveAccount recentHiveAccount = hiveLifecycle.getRecentHiveAccount();
                if (recentHiveAccount == null) {
                    recentHiveAccount = hiveLifecycle.getAccount();
                }
                verifyRemoteLogging(recentHiveAccount, str, new Function1() { // from class: com.hive.analytics.logger.RemoteLoggerV2$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RemoteLoggerV2.remoteLoggingAgreementAccept$lambda$9((VerifyRemoteLogging) obj);
                    }
                });
                return;
            }
        }
        LoggerImpl.INSTANCE.e("remoteLoggingValidation token is not exist!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit remoteLoggingAgreementAccept$lambda$9(VerifyRemoteLogging verifyRemoteLogging) {
        Intrinsics.checkNotNullParameter(verifyRemoteLogging, "verifyRemoteLogging");
        if (verifyRemoteLogging.getResponse().isSuccess()) {
            try {
                RemoteLoggerV2 remoteLoggerV2 = INSTANCE;
                remoteLoggerV2.setEnableRemoteLogging(verifyRemoteLogging.getResponse().getVerify());
                Integer numValueOf = Integer.valueOf(verifyRemoteLogging.getResponse().getRemainMinutes());
                if (numValueOf.intValue() <= kSESSION_TIME_INVALIDED) {
                    numValueOf = null;
                }
                int iIntValue = numValueOf != null ? numValueOf.intValue() : kSESSION_DEFAULT_MINUTES;
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.US);
                calendar.setTime(remoteLoggerV2.getTokenCatchTime());
                calendar.add(12, iIntValue);
                expiredDate = calendar.getTime();
            } catch (Exception unused) {
                LoggerImpl.INSTANCE.e("remoteLoggingValidation parsing boolean exception is occurred!");
            }
        }
        RemoteLoggerV2 remoteLoggerV22 = INSTANCE;
        if (!remoteLoggerV22.isEnableRemoteLogging()) {
            remoteLoggerV22.discardStackedLog();
        }
        return Unit.INSTANCE;
    }

    private final void remoteLoggingAgreementReject() {
        discardStackedLog();
    }

    private final void runLogProcess() {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: com.hive.analytics.logger.RemoteLoggerV2$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return RemoteLoggerV2.runLogProcess$lambda$1(runnable);
            }
        });
        Intrinsics.checkNotNullExpressionValue(scheduledExecutorServiceNewSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor(...)");
        scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleAtFixedRate(new Runnable() { // from class: com.hive.analytics.logger.RemoteLoggerV2$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                RemoteLoggerV2.runLogProcess$lambda$2();
            }
        }, 10L, 10L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread runLogProcess$lambda$1(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        return thread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runLogProcess$lambda$2() {
        if (logDeque.isEmpty()) {
            return;
        }
        INSTANCE.sendStackedLog();
    }

    private final synchronized void sendStackedLog() {
        if (isEnableRemoteLogging()) {
            while (true) {
                List<JSONObject> list = logDeque;
                if (list.isEmpty()) {
                    break;
                }
                beginRemoteLoggerProcess();
                AnalyticsLogTransfer.INSTANCE.sendDebugLog((JSONObject) CollectionsKt.last((List) list));
                list.remove(CollectionsKt.getLastIndex(list));
                endRemoteLoggerProcess();
            }
        }
    }

    private final void setEnableRemoteLogging(boolean z) {
        Logger.INSTANCE.setRemoteLogEnable(z);
    }

    private final void showRemoteLogginAgreementAlert(Activity activity) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        Resource resource = Resource.INSTANCE;
        builder.setTitle(resource.getString("hive_remotelogging_validation_title")).setMessage(resource.getString("hive_remotelogging_validation_content"));
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.hive.analytics.logger.RemoteLoggerV2$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                RemoteLoggerV2.showRemoteLogginAgreementAlert$lambda$16$lambda$14(dialogInterface, i);
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.hive.analytics.logger.RemoteLoggerV2$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                RemoteLoggerV2.showRemoteLogginAgreementAlert$lambda$16$lambda$15(dialogInterface, i);
            }
        });
        activity.runOnUiThread(new Runnable() { // from class: com.hive.analytics.logger.RemoteLoggerV2$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                RemoteLoggerV2.showRemoteLogginAgreementAlert$lambda$17(builder);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showRemoteLogginAgreementAlert$lambda$16$lambda$14(DialogInterface dialogInterface, int i) {
        INSTANCE.remoteLoggingAgreementAccept();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showRemoteLogginAgreementAlert$lambda$16$lambda$15(DialogInterface dialogInterface, int i) {
        INSTANCE.remoteLoggingAgreementReject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showRemoteLogginAgreementAlert$lambda$17(AlertDialog.Builder builder) {
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit verifyRemoteLogging$lambda$12(Function1 function1, VerifyRemoteLogging it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    public final void beginRemoteLoggerProcess() {
        logBlockThreadsID.add(Long.valueOf(Thread.currentThread().getId()));
    }

    public final void discardStackedLog() {
        isTemporaryAllowRemoteLogging = false;
        setEnableRemoteLogging(false);
        logDeque.clear();
    }

    public final void endRemoteLoggerProcess() {
        logBlockThreadsID.remove(Long.valueOf(Thread.currentThread().getId()));
    }

    public final boolean isActivate() {
        Date date;
        boolean z = isEnableRemoteLogging() || isTemporaryAllowRemoteLogging;
        if (!z || (date = expiredDate) == null || !date.before(Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.US).getTime())) {
            return z;
        }
        INSTANCE.discardStackedLog();
        return false;
    }

    public final void log(String level, String tag, String msg, boolean isSDKLog) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (!isThreadLock() && isActivate()) {
            pushStackedLog(makeRemoteLog(level, tag, msg, isSDKLog));
        }
    }

    public final void onNewIntent(Activity activity, Intent intent) {
        String stringExtra;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (intent == null || (stringExtra = intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION)) == null) {
            return;
        }
        RemoteLoggerV2 remoteLoggerV2 = INSTANCE;
        if (remoteLoggerV2.saveTokenFromURI(stringExtra)) {
            remoteLoggerV2.remoteLoggingValidation(activity);
            intent.removeExtra(NativeProtocol.WEB_DIALOG_ACTION);
        }
    }

    public final void onResume(Activity activity) {
        String stringExtra;
        Intent intent;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intent2 = activity.getIntent();
        if (intent2 == null || (stringExtra = intent2.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION)) == null || !INSTANCE.saveTokenFromURI(stringExtra) || (intent = activity.getIntent()) == null) {
            return;
        }
        intent.removeExtra(NativeProtocol.WEB_DIALOG_ACTION);
    }

    public final void remoteLoggingValidation(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (token != null && (!StringsKt.isBlank(r0))) {
            showRemoteLogginAgreementAlert(activity);
        } else {
            discardStackedLog();
            LoggerImpl.INSTANCE.w("HiveRemoteLoggerV2's token is empty.");
        }
    }

    public final boolean saveTokenFromURI(String strUri) {
        Intrinsics.checkNotNullParameter(strUri, "strUri");
        Uri uri = Uri.parse(strUri);
        String host = uri.getHost();
        String path = uri.getPath();
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        if (!Intrinsics.areEqual(host, "hive") || !Intrinsics.areEqual(path, "/debug/remoteloging")) {
            return false;
        }
        HashMap map = new HashMap();
        for (String str : queryParameterNames) {
            map.put(str, uri.getQueryParameter(str));
        }
        token = (String) map.get("token");
        isTemporaryAllowRemoteLogging = true;
        tokenCatchTime = Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.US).getTime();
        return true;
    }

    public final void verifyRemoteLogging(HiveLifecycle.HiveAccount account, String token2, final Function1<? super VerifyRemoteLogging, Unit> callback) {
        String vidSession;
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(token2, "token");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<VerifyRemoteLogging>() { // from class: com.hive.analytics.logger.RemoteLoggerV2$verifyRemoteLogging$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.provision.VerifyRemoteLogging] */
            @Override // kotlin.jvm.functions.Function0
            public final VerifyRemoteLogging invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = VerifyRemoteLogging.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        String did = account.getDid();
        if (did == null) {
            did = HiveLifecycle.INSTANCE.getDid();
        }
        try {
            HiveKeys hiveKeys = HiveKeys.KEY_appid;
            Configuration configuration = Configuration.INSTANCE;
            String appId = configuration.getAppId();
            if (appId == null) {
                appId = "";
            }
            protocol.setParam(hiveKeys, appId);
            protocol.setParam(HiveKeys.KEY_token, token2);
            protocol.setParam(HiveKeys.KEY_did, did);
            if (account.getVid() != null && (vidSession = account.getVidSession()) != null) {
                protocol.setParam(HiveKeys.KEY_player_id, account.getVid());
                protocol.setHeader(HiveKeys.KEY_Authorization, vidSession);
            }
            OauthToken oauthToken = account.getOauthToken();
            if (oauthToken != null) {
                protocol.setOauthToken(oauthToken);
            }
            protocol.setParam(HiveKeys.KEY_hive_certification_key, configuration.getHiveCertificationKey());
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("[AuthV4Network] connect Exception: " + e);
        }
        protocol.request(new Function1() { // from class: com.hive.analytics.logger.RemoteLoggerV2$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RemoteLoggerV2.verifyRemoteLogging$lambda$12(callback, (VerifyRemoteLogging) obj);
            }
        });
    }
}
