package com.hive.push.local;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.C;
import com.hive.Configuration;
import com.hive.Push;
import com.hive.logger.LoggerImpl;
import com.hive.push.PushConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\"\u0010\u0011\u001a\u00020\n2\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0014J\u0006\u0010\u0015\u001a\u00020\nJ\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/hive/push/local/LocalMessaging;", "", "<init>", "()V", "registerQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/Runnable;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "loadConfig", "", "registerLocalpush", "localPush", "Lcom/hive/Push$LocalPush;", "unRegisterLocalpush", "noticeID", "", "unregisterLocalPushes", "noticeIDs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "unRegisterAllLocalPush", "addRegisterQueue", "runnable", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalMessaging {
    public static final LocalMessaging INSTANCE;
    private static final ConcurrentLinkedQueue<Runnable> registerQueue;
    private static final CoroutineScope scope;

    /* JADX INFO: renamed from: com.hive.push.local.LocalMessaging$addRegisterQueue$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.push.local.LocalMessaging$addRegisterQueue$2", f = "LocalMessaging.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Unit unit;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ConcurrentLinkedQueue concurrentLinkedQueue = LocalMessaging.registerQueue;
            try {
                Result.Companion companion = Result.INSTANCE;
                Runnable runnable = (Runnable) concurrentLinkedQueue.poll();
                if (runnable != null) {
                    runnable.run();
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                Result.m7415constructorimpl(unit);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        LocalMessaging localMessaging = new LocalMessaging();
        INSTANCE = localMessaging;
        registerQueue = new ConcurrentLinkedQueue<>();
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        scope = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(executorServiceNewSingleThreadExecutor));
        localMessaging.loadConfig();
    }

    private LocalMessaging() {
    }

    private final void addRegisterQueue(Runnable runnable) {
        ConcurrentLinkedQueue<Runnable> concurrentLinkedQueue = registerQueue;
        try {
            Result.Companion companion = Result.INSTANCE;
            Result.m7415constructorimpl(Boolean.valueOf(concurrentLinkedQueue.offer(runnable)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass2(null), 3, null);
    }

    private final void loadConfig() {
        LoggerImpl.INSTANCE.d(PushConfig.INSTANCE.getTAG(), "loadConfig");
        Context context = Configuration.getContext();
        Object systemService = context.getApplicationContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager alarmManager = (AlarmManager) systemService;
        for (PushResource pushResource : PushResourceHandler.INSTANCE.getMap().values()) {
            Intrinsics.checkNotNullExpressionValue(pushResource, "next(...)");
            PushResource pushResource2 = pushResource;
            alarmManager.set(2, pushResource2.getElapsedRealtime() + pushResource2.getTriggerAtTime(), PendingIntent.getBroadcast(context.getApplicationContext(), pushResource2.getNoticeID(), PushResourceHandler.INSTANCE.putIntentExtra(new Intent(context.getApplicationContext(), (Class<?>) LocalPushReceiver.class), pushResource2), Build.VERSION.SDK_INT >= 31 ? 201326592 : C.BUFFER_FLAG_FIRST_SAMPLE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerLocalpush$lambda$1(Push.LocalPush localPush) {
        LoggerImpl.INSTANCE.d(Push.getTAG(), "registerLocalPush start : " + localPush.getNoticeID());
        Context context = Configuration.getContext();
        Intent intent = new Intent(context.getApplicationContext(), (Class<?>) LocalPushReceiver.class);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long after = localPush.getAfter() * ((long) 1000);
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        PushResource pushResource = new PushResource(packageName, jElapsedRealtime, jCurrentTimeMillis, after);
        pushResource.setData(localPush);
        PushResourceHandler pushResourceHandler = PushResourceHandler.INSTANCE;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        pushResourceHandler.add(applicationContext, pushResource.getNoticeID(), pushResource);
        PendingIntent broadcast = PendingIntent.getBroadcast(context.getApplicationContext(), pushResource.getNoticeID(), pushResourceHandler.putIntentExtra(intent, pushResource), Build.VERSION.SDK_INT >= 31 ? 201326592 : C.BUFFER_FLAG_FIRST_SAMPLE);
        Object systemService = context.getApplicationContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        ((AlarmManager) systemService).setAndAllowWhileIdle(2, jElapsedRealtime + after, broadcast);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void unRegisterLocalpush$lambda$2(int i) {
        LoggerImpl.INSTANCE.d(Push.getTAG(), "unRegisterLocalPush start : " + i);
        Context context = Configuration.getContext();
        PendingIntent broadcast = PendingIntent.getBroadcast(context.getApplicationContext(), i, new Intent(context.getApplicationContext(), (Class<?>) LocalPushReceiver.class), Build.VERSION.SDK_INT >= 31 ? 201326592 : C.BUFFER_FLAG_FIRST_SAMPLE);
        Object systemService = context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        PushResourceHandler.INSTANCE.remove(context, i);
        ((AlarmManager) systemService).cancel(broadcast);
    }

    public final void registerLocalpush(final Push.LocalPush localPush) {
        Intrinsics.checkNotNullParameter(localPush, "localPush");
        addRegisterQueue(new Runnable() { // from class: com.hive.push.local.LocalMessaging$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LocalMessaging.registerLocalpush$lambda$1(localPush);
            }
        });
    }

    public final void unRegisterAllLocalPush() {
        LoggerImpl.INSTANCE.i(Push.getTAG(), "unRegisterAllLocalPush start");
        Iterator<PushResource> it = PushResourceHandler.INSTANCE.getMap().values().iterator();
        while (it.hasNext()) {
            unRegisterLocalpush(it.next().getNoticeID());
        }
    }

    public final void unRegisterLocalpush(final int noticeID) {
        addRegisterQueue(new Runnable() { // from class: com.hive.push.local.LocalMessaging$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                LocalMessaging.unRegisterLocalpush$lambda$2(noticeID);
            }
        });
    }

    public final void unregisterLocalPushes(ArrayList<Integer> noticeIDs) {
        if (noticeIDs != null) {
            Iterator<T> it = noticeIDs.iterator();
            while (it.hasNext()) {
                INSTANCE.unRegisterLocalpush(((Number) it.next()).intValue());
            }
        }
    }
}
