package com.hive.analytics;

import com.hive.base.Android;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.Configuration;
import com.hive.core.HiveKeys;
import com.hive.core.HiveTime;
import com.hive.standalone.HiveLifecycle;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013J\u001a\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u0010J\u0006\u0010 \u001a\u00020\u0010J\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013J\u000e\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006$"}, d2 = {"Lcom/hive/analytics/AnalyticsLogTransfer;", "", "<init>", "()V", "DEBUG_MAX_SEND_LOG_COUNT", "", "DEBUG_MAX_SAVE_COUNT", "DEBUG_DEFAULT_TIMER_SECONDS", "", "analyticsSender", "Lcom/hive/analytics/AnalyticsLogSender;", "getAnalyticsSender$hive_service_release", "()Lcom/hive/analytics/AnalyticsLogSender;", "debugLogSender", "getDebugLogSender$hive_service_release", MobileAdsBridgeBase.initializeMethodName, "", "addLogBody", "loggingData", "Lorg/json/JSONObject;", "sendAnalyticsLog", "", "jsonLogData", "logData", "", "", "sendAnalyticsHiveLog", "isHiveLog", "logPersister", "Lcom/hive/analytics/AnalyticsLogPersisterV2;", "remainLogCount", "saveAndClearLog", "loadSavedLog", "sendDebugLog", "setSenderReadyState", "readyFlag", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnalyticsLogTransfer {
    private static final float DEBUG_DEFAULT_TIMER_SECONDS = 1.0f;
    private static final int DEBUG_MAX_SAVE_COUNT = 10000;
    private static final int DEBUG_MAX_SEND_LOG_COUNT = 1000;
    public static final AnalyticsLogTransfer INSTANCE = new AnalyticsLogTransfer();
    private static final AnalyticsLogSender analyticsSender;
    private static final AnalyticsLogSender debugLogSender;

    static {
        AnalyticsImpl analyticsImpl = AnalyticsImpl.INSTANCE;
        analyticsSender = new AnalyticsLogSender("/hive_analytics/", analyticsImpl.getAnalyticsSendLimit(), analyticsImpl.getAnalyticsQueueLimit(), analyticsImpl.getAnalyticsSendCycleSeconds(), false);
        debugLogSender = new AnalyticsLogSender("/hive_log/", 1000, 10000, 1.0f, true);
    }

    private AnalyticsLogTransfer() {
    }

    private final void addLogBody(JSONObject loggingData) {
        try {
            Locale locale = Locale.US;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", locale);
            Date time = Calendar.getInstance(TimeZone.getTimeZone("GMT"), locale).getTime();
            HiveTime hiveTime = HiveTime.INSTANCE;
            Date hiveTime2 = hiveTime.isSetBaseTime() ? hiveTime.getHiveTime() : time;
            CommonIdentifierKt.put(loggingData, HiveKeys.KEY_dateTime, simpleDateFormat.format(hiveTime2));
            CommonIdentifierKt.put(loggingData, HiveKeys.KEY_device_dateTime, simpleDateFormat.format(time));
            String str = new SimpleDateFormat("Z", locale).format(hiveTime2);
            StringBuilder sb = new StringBuilder("GMT");
            Intrinsics.checkNotNull(str);
            String strSubstring = str.substring(0, 3);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            sb.append(strSubstring);
            sb.append(AbstractJsonLexerKt.COLON);
            String strSubstring2 = str.substring(3, 5);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            sb.append(strSubstring2);
            CommonIdentifierKt.put(loggingData, HiveKeys.KEY_timezone, sb.toString());
            CommonIdentifierKt.put(loggingData, HiveKeys.KEY_is_hive_time, hiveTime.isSetBaseTime() ? "Y" : "N");
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            loggingData.put(HiveKeys.KEY_guid.getValue(), StringsKt.replace$default(string, "-", "", false, 4, (Object) null));
            HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
            HiveLifecycle.HiveAccount account = hiveLifecycle.getAccount();
            String vid = account.getVid();
            String str2 = "";
            if (vid == null) {
                vid = "";
            }
            String uid = account.getUid();
            if (uid == null) {
                uid = "";
            }
            String did = account.getDid();
            if (did == null) {
                did = "";
            }
            if (StringsKt.isBlank(did)) {
                String did2 = hiveLifecycle.getDid();
                if (did2 != null) {
                    str2 = did2;
                }
                did = str2;
            }
            CommonIdentifierKt.put(loggingData, HiveKeys.KEY_vid, vid);
            CommonIdentifierKt.put(loggingData, HiveKeys.KEY_vid_type, account.getVidType());
            CommonIdentifierKt.put(loggingData, HiveKeys.KEY_uid, uid);
            CommonIdentifierKt.put(loggingData, HiveKeys.KEY_did, did);
            if (!loggingData.has("category")) {
                CommonIdentifierKt.put(loggingData, HiveKeys.KEY_category, "test");
            }
            CommonIdentifierKt.put(loggingData, HiveKeys.KEY_server_id, Configuration.INSTANCE.getServerId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final AnalyticsLogSender getAnalyticsSender$hive_service_release() {
        return analyticsSender;
    }

    public final AnalyticsLogSender getDebugLogSender$hive_service_release() {
        return debugLogSender;
    }

    public final void initialize() {
    }

    public final void loadSavedLog() {
        analyticsSender.getLogPersister().loadLogFile(true);
    }

    public final int remainLogCount() {
        return analyticsSender.getLogPersister().getLogCount();
    }

    public final void saveAndClearLog() {
        AnalyticsLogPersisterV2 logPersister$hive_service_release = analyticsSender.getLogPersister();
        if (logPersister$hive_service_release.getLogCount() > 0) {
            logPersister$hive_service_release.saveLogFile(true);
        }
    }

    public final boolean sendAnalyticsHiveLog(JSONObject jsonLogData) {
        Intrinsics.checkNotNullParameter(jsonLogData, "jsonLogData");
        return sendAnalyticsLog(jsonLogData, true, analyticsSender.getLogPersister());
    }

    public final boolean sendAnalyticsLog(JSONObject jsonLogData) {
        Intrinsics.checkNotNullParameter(jsonLogData, "jsonLogData");
        AnalyticsLogSender analyticsLogSender = analyticsSender;
        if (analyticsLogSender.getCurrentSendingCount() + analyticsLogSender.getLogPersister().getLogCount() >= AnalyticsImpl.INSTANCE.getAnalyticsQueueLimit()) {
            return false;
        }
        return sendAnalyticsLog(jsonLogData, false, analyticsLogSender.getLogPersister());
    }

    public final boolean sendDebugLog(JSONObject jsonLogData) {
        Intrinsics.checkNotNullParameter(jsonLogData, "jsonLogData");
        return sendAnalyticsLog(jsonLogData, true, debugLogSender.getLogPersister());
    }

    public final void setSenderReadyState(boolean readyFlag) {
        analyticsSender.setIsReadyToSending(readyFlag);
        debugLogSender.setIsReadyToSending(readyFlag);
    }

    public final boolean sendAnalyticsLog(Map<String, ? extends Object> logData) {
        Intrinsics.checkNotNullParameter(logData, "logData");
        Object objMapToJSON = Android.INSTANCE.mapToJSON(logData);
        Intrinsics.checkNotNull(objMapToJSON, "null cannot be cast to non-null type org.json.JSONObject");
        return sendAnalyticsLog((JSONObject) objMapToJSON);
    }

    public final boolean sendAnalyticsLog(JSONObject jsonLogData, boolean isHiveLog, AnalyticsLogPersisterV2 logPersister) {
        Intrinsics.checkNotNullParameter(jsonLogData, "jsonLogData");
        Intrinsics.checkNotNullParameter(logPersister, "logPersister");
        addLogBody(jsonLogData);
        if (isHiveLog) {
            return logPersister.pushFrontLogs(jsonLogData);
        }
        return logPersister.pushBackLogs(jsonLogData);
    }
}
