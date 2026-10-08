package com.hive.analytics;

import android.os.Build;
import android.util.Log;
import com.google.common.net.HttpHeaders;
import com.hive.analytics.AnalyticsLogPersisterV2;
import com.hive.analytics.logger.RemoteLoggerV2;
import com.hive.base.Android;
import com.hive.core.Configuration;
import com.hive.core.HiveKeys;
import com.hive.core.Platform;
import com.hive.core.Request;
import com.hive.protocol.Protocol;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.analytics.AnalyticsLog;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0016\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\u000e\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/hive/analytics/AnalyticsLogSender;", "", "path", "", "maxSendLogCount", "", "maxSaveLogCount", "sendingCycleSecond", "", "isBlockLog", "", "<init>", "(Ljava/lang/String;IIFZ)V", "isReadyToSending", "logPersister", "Lcom/hive/analytics/AnalyticsLogPersisterV2;", "getLogPersister$hive_service_release", "()Lcom/hive/analytics/AnalyticsLogPersisterV2;", "value", "currentSendingCount", "getCurrentSendingCount$hive_service_release", "()I", "LIMIT_FREEMEM_SIZE", "", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "future", "Ljava/util/concurrent/ScheduledFuture;", "execute", "", "addLogHeader", "analyticsLog", "Lcom/hive/protocol/Protocol;", "Lcom/hive/protocol/analytics/AnalyticsLog;", "sendingLog", "setIsReadyToSending", "readyFlag", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnalyticsLogSender {
    private static volatile AtomicBoolean isSending = new AtomicBoolean(false);
    private final long LIMIT_FREEMEM_SIZE;
    private int currentSendingCount;
    private final ScheduledExecutorService executor;
    private ScheduledFuture<?> future;
    private final boolean isBlockLog;
    private boolean isReadyToSending;
    private final AnalyticsLogPersisterV2 logPersister;
    private final int maxSaveLogCount;
    private final int maxSendLogCount;
    private float sendingCycleSecond;

    public AnalyticsLogSender(String path, int i, int i2, float f, boolean z) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.maxSendLogCount = i;
        this.maxSaveLogCount = i2;
        this.sendingCycleSecond = f;
        this.isBlockLog = z;
        this.logPersister = new AnalyticsLogPersisterV2(path);
        this.LIMIT_FREEMEM_SIZE = 2L;
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: com.hive.analytics.AnalyticsLogSender$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return AnalyticsLogSender.executor$lambda$1(runnable);
            }
        });
        Intrinsics.checkNotNullExpressionValue(scheduledExecutorServiceNewSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor(...)");
        this.executor = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        execute();
    }

    private final void addLogHeader(Protocol<AnalyticsLog> analyticsLog) {
        try {
            HiveKeys hiveKeys = HiveKeys.KEY_appId;
            Configuration configuration = Configuration.INSTANCE;
            analyticsLog.setParam(hiveKeys, configuration.getAppId());
            HiveKeys hiveKeys2 = HiveKeys.KEY_app_version;
            Android android2 = Android.INSTANCE;
            analyticsLog.setParam(hiveKeys2, android2.getAppVersion());
            analyticsLog.setParam(HiveKeys.KEY_app_version_display, android2.getAppVersion());
            analyticsLog.setParam(HiveKeys.KEY_company, configuration.getCompany());
            analyticsLog.setParam(HiveKeys.KEY_companyIndex, Integer.valueOf(configuration.getCompanyIndex()));
            analyticsLog.setParam(HiveKeys.KEY_channel, configuration.getChannel());
            analyticsLog.setParam(HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
            analyticsLog.setParam(HiveKeys.KEY_os_version, Build.VERSION.RELEASE);
            analyticsLog.setParam(HiveKeys.KEY_sdk_version, configuration.getSdkVersion());
            analyticsLog.setParam(HiveKeys.KEY_interface_version, configuration.getInterfaceVersion());
            analyticsLog.setParam(HiveKeys.KEY_device_language, android2.getLanguageCode());
            analyticsLog.setParam(HiveKeys.KEY_model, android2.getDeviceModel());
            analyticsLog.setParam(HiveKeys.KEY_cpu, android2.getCPUType());
            analyticsLog.setParam(HiveKeys.KEY_market, configuration.getMarket());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void execute() {
        ScheduledFuture<?> scheduledFuture = this.future;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        Runnable runnable = new Runnable() { // from class: com.hive.analytics.AnalyticsLogSender$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AnalyticsLogSender.execute$lambda$2(this.f$0);
            }
        };
        long j = (long) (this.sendingCycleSecond * 1000);
        this.future = this.executor.scheduleAtFixedRate(runnable, j, j, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execute$lambda$2(AnalyticsLogSender analyticsLogSender) {
        if (analyticsLogSender.isReadyToSending) {
            analyticsLogSender.sendingLog();
            if (analyticsLogSender == AnalyticsLogTransfer.INSTANCE.getAnalyticsSender$hive_service_release()) {
                float f = analyticsLogSender.sendingCycleSecond;
                AnalyticsImpl analyticsImpl = AnalyticsImpl.INSTANCE;
                if (f == analyticsImpl.getAnalyticsSendCycleSeconds()) {
                    return;
                }
                analyticsLogSender.sendingCycleSecond = analyticsImpl.getAnalyticsSendCycleSeconds();
                analyticsLogSender.execute();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread executor$lambda$1(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        return thread;
    }

    private final void sendingLog() {
        if (isSending.compareAndSet(false, true)) {
            if (this.isBlockLog) {
                RemoteLoggerV2.INSTANCE.beginRemoteLoggerProcess();
            }
            Runtime runtime = Runtime.getRuntime();
            long jMaxMemory = ((runtime.maxMemory() - runtime.totalMemory()) + runtime.freeMemory()) / ((long) 1048576);
            long j = this.LIMIT_FREEMEM_SIZE;
            if (j > jMaxMemory) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format("Analytics Log Send Error : Limit Memory = %d MB, Free Memory = %d MB", Arrays.copyOf(new Object[]{Long.valueOf(j), Long.valueOf(jMaxMemory)}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                Log.w("HIVE", str);
                isSending.set(false);
                if (this.isBlockLog) {
                    RemoteLoggerV2.INSTANCE.endRemoteLoggerProcess();
                    return;
                }
                return;
            }
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol<AnalyticsLog> protocol = new Protocol<>(new Function0<AnalyticsLog>() { // from class: com.hive.analytics.AnalyticsLogSender$sendingLog$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.analytics.AnalyticsLog] */
                @Override // kotlin.jvm.functions.Function0
                public final AnalyticsLog invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = AnalyticsLog.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            protocol.setRetryNetwork(false);
            addLogHeader(protocol);
            AnalyticsLogPersisterV2.HiveLogTransaction logTransaction = this.logPersister.getLogTransaction(this.maxSendLogCount < this.logPersister.getLogCount() ? this.maxSendLogCount : this.logPersister.getLogCount());
            if (logTransaction.getLogs().size() == 0) {
                isSending.set(false);
                if (this.isBlockLog) {
                    RemoteLoggerV2.INSTANCE.endRemoteLoggerProcess();
                    return;
                }
                return;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<JSONObject> it = logTransaction.getLogs().iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            if (jSONArray.length() == 0) {
                isSending.set(false);
                if (this.isBlockLog) {
                    RemoteLoggerV2.INSTANCE.endRemoteLoggerProcess();
                    return;
                }
                return;
            }
            try {
                protocol.setParam(HiveKeys.KEY_logBody, jSONArray);
                this.currentSendingCount = jSONArray.length();
                protocol.setHeader(HttpHeaders.ACCEPT, Request.ContentType.JSON.getValue());
                AnalyticsLog analyticsLog = (AnalyticsLog) protocol.request();
                try {
                    if (analyticsLog.getResponse().isSuccess()) {
                        logTransaction.commit();
                    } else {
                        logTransaction.rollback();
                        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                        String str2 = String.format("Analytics Log Send Error : " + analyticsLog.getResponse(), Arrays.copyOf(new Object[0], 0));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        Log.e("HIVE", str2);
                    }
                    this.currentSendingCount = 0;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                isSending.set(false);
                if (this.isBlockLog) {
                    RemoteLoggerV2.INSTANCE.endRemoteLoggerProcess();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                isSending.set(false);
                if (this.isBlockLog) {
                    RemoteLoggerV2.INSTANCE.endRemoteLoggerProcess();
                }
            }
        }
    }

    /* JADX INFO: renamed from: getCurrentSendingCount$hive_service_release, reason: from getter */
    public final int getCurrentSendingCount() {
        return this.currentSendingCount;
    }

    /* JADX INFO: renamed from: getLogPersister$hive_service_release, reason: from getter */
    public final AnalyticsLogPersisterV2 getLogPersister() {
        return this.logPersister;
    }

    public final void setIsReadyToSending(boolean readyFlag) {
        this.isReadyToSending = readyFlag;
    }
}
