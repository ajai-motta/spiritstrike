package com.hive.analytics;

import com.hive.core.HiveTime;
import com.hive.core.Response;
import com.hive.logger.LoggerImpl;
import com.hive.standalone.HiveLifecycle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/hive/analytics/AnalyticsCCUSender;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "future", "Ljava/util/concurrent/ScheduledFuture;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "periodTime", "", "lastTaskTime", "stopTime", "playTime", "playOutTime", "prevLatency", "beforeVid", "beforeUid", "isStarted", "", "startTime", "onStart", "", "onStop", "reset", "getCurrentTime", "checkChangedVid", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnalyticsCCUSender {
    public static final AnalyticsCCUSender INSTANCE = new AnalyticsCCUSender();
    private static final String TAG = AnalyticsCCUSender.class.getName();
    private static String beforeUid = null;
    private static String beforeVid = null;
    private static final ScheduledExecutorService executor;
    private static ScheduledFuture<?> future = null;
    private static boolean isStarted = false;
    private static long lastTaskTime = 0;
    private static final ReentrantLock lock;
    private static final long periodTime = 120000;
    private static long playOutTime;
    private static long playTime;
    private static long prevLatency;
    private static long startTime;
    private static long stopTime;

    static {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: com.hive.analytics.AnalyticsCCUSender$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return AnalyticsCCUSender.executor$lambda$1(runnable);
            }
        });
        Intrinsics.checkNotNullExpressionValue(scheduledExecutorServiceNewSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor(...)");
        executor = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        lock = new ReentrantLock(true);
        lastTaskTime = 0L;
        stopTime = 0L;
        playTime = 0L;
        playOutTime = 0L;
        prevLatency = 0L;
        beforeVid = "";
        beforeUid = "";
        isStarted = false;
        startTime = 0L;
    }

    private AnalyticsCCUSender() {
    }

    private final void checkChangedVid() {
        String str;
        String vid = HiveLifecycle.INSTANCE.getAccount().getVid();
        if (vid == null || (str = beforeVid) == null || str.length() == 0 || Intrinsics.areEqual(vid, beforeVid)) {
            return;
        }
        playOutTime = 0L;
        Long lValueOf = Long.valueOf((INSTANCE.getCurrentTime() - startTime) / ((long) 1000));
        if (lValueOf.longValue() >= 120) {
            lValueOf = null;
        }
        playTime = lValueOf != null ? lValueOf.longValue() : 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread executor$lambda$1(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        return thread;
    }

    private final long getCurrentTime() {
        return HiveTime.INSTANCE.getHiveTimeTimestamp().getTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$8(Ref.LongRef longRef) {
        Long lValueOf = Long.valueOf((120000 - longRef.element) / 1000);
        long jLongValue = lValueOf.longValue();
        if (0 > jLongValue || jLongValue >= 121) {
            lValueOf = null;
        }
        long jLongValue2 = lValueOf != null ? lValueOf.longValue() : 0L;
        playTime += jLongValue2;
        longRef.element = 0L;
        AnalyticsCCUSender analyticsCCUSender = INSTANCE;
        analyticsCCUSender.checkChangedVid();
        AnalyticsNetwork.INSTANCE.concurrent(jLongValue2, playTime, playOutTime, prevLatency, new Function1() { // from class: com.hive.analytics.AnalyticsCCUSender$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AnalyticsCCUSender.onStart$lambda$8$lambda$7((Response) obj);
            }
        });
        lastTaskTime = analyticsCCUSender.getCurrentTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onStart$lambda$8$lambda$7(Response it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isSuccess()) {
            HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
            if (hiveLifecycle.getAccount().getVid() != null) {
                beforeVid = hiveLifecycle.getAccount().getVid();
            } else if (hiveLifecycle.getAccount().getUid() != null) {
                beforeUid = hiveLifecycle.getAccount().getUid();
            }
            prevLatency = it.getResponseLatency();
        } else {
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            String str = TAG;
            loggerImpl.wL(str, "AnalyticsNetwork.concurrent is failed. " + it.getLogContent());
            loggerImpl.wR(str, "AnalyticsNetwork.concurrent is failed.");
        }
        return Unit.INSTANCE;
    }

    private final void reset() {
        lastTaskTime = 0L;
        stopTime = 0L;
        playTime = 0L;
        playOutTime = 0L;
        beforeVid = "";
        beforeUid = "";
    }

    public final void onStart() {
        try {
            try {
                ReentrantLock reentrantLock = lock;
                reentrantLock.lock();
                LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                String str = TAG;
                loggerImpl.d(str, "onStart()");
                startTime = getCurrentTime();
                if (isStarted) {
                    loggerImpl.d(str, "already onStart()");
                    reentrantLock.unlock();
                    return;
                }
                isStarted = true;
                HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
                if (hiveLifecycle.getAccount().getVid() != null) {
                    if (!Intrinsics.areEqual(beforeVid, hiveLifecycle.getAccount().getVid())) {
                        INSTANCE.reset();
                    }
                } else if (hiveLifecycle.getAccount().getUid() != null && !Intrinsics.areEqual(beforeUid, hiveLifecycle.getAccount().getUid())) {
                    INSTANCE.reset();
                }
                long currentTime = (lastTaskTime + 120000) - getCurrentTime();
                long j = currentTime < 0 ? 0L : currentTime;
                final Ref.LongRef longRef = new Ref.LongRef();
                long currentTime2 = getCurrentTime();
                long j2 = stopTime;
                long j3 = currentTime2 - j2;
                longRef.element = j3;
                if (j2 != 0) {
                    playOutTime += j3 / 1000;
                }
                if (j3 > 120000) {
                    longRef.element = 120000 - (j2 - lastTaskTime);
                }
                Runnable runnable = new Runnable() { // from class: com.hive.analytics.AnalyticsCCUSender$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnalyticsCCUSender.onStart$lambda$8(longRef);
                    }
                };
                ScheduledFuture<?> scheduledFuture = future;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                }
                future = executor.scheduleAtFixedRate(runnable, j, 120000L, TimeUnit.MILLISECONDS);
                reentrantLock.unlock();
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(TAG, "AnalyticsCCUSender.onStart() exception: " + e.getMessage());
                lock.unlock();
            }
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    public final void onStop() {
        try {
            try {
                ReentrantLock reentrantLock = lock;
                reentrantLock.lock();
                LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                String str = TAG;
                loggerImpl.d(str, "onStop()");
                if (!isStarted) {
                    loggerImpl.d(str, "already onStop()");
                    reentrantLock.unlock();
                    return;
                }
                isStarted = false;
                ScheduledFuture<?> scheduledFuture = future;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                }
                stopTime = getCurrentTime();
                reentrantLock.unlock();
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(TAG, "AnalyticsCCUSender.onStop() exception: " + e.getMessage());
                lock.unlock();
            }
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }
}
