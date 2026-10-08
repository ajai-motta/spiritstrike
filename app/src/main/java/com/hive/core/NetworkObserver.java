package com.hive.core;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkObserver.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u001a\u0010\u0012\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0007H\u0002R \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/hive/core/NetworkObserver;", "", "<init>", "()V", "observers", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lkotlin/Function1;", "Lcom/hive/core/Response;", "", "observerThread", "Landroid/os/HandlerThread;", "getObserverThread", "()Landroid/os/HandlerThread;", "observerThread$delegate", "Lkotlin/Lazy;", "attach", "", "observer", "detach", "notify", "response", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NetworkObserver {
    public static final NetworkObserver INSTANCE = new NetworkObserver();
    private static final CopyOnWriteArraySet<Function1<Response, Unit>> observers = new CopyOnWriteArraySet<>();

    /* JADX INFO: renamed from: observerThread$delegate, reason: from kotlin metadata */
    private static final Lazy observerThread = LazyKt.lazy(new Function0() { // from class: com.hive.core.NetworkObserver$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NetworkObserver.observerThread_delegate$lambda$1();
        }
    });

    private NetworkObserver() {
    }

    static {
        Network.INSTANCE.setObserver$hive_core_release(new Function1() { // from class: com.hive.core.NetworkObserver$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NetworkObserver._init_$lambda$2((Response) obj);
            }
        });
    }

    private final HandlerThread getObserverThread() {
        return (HandlerThread) observerThread.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HandlerThread observerThread_delegate$lambda$1() {
        HandlerThread handlerThread = new HandlerThread("networkObserverThread");
        handlerThread.setDaemon(true);
        handlerThread.start();
        return handlerThread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$2(Response it) {
        Intrinsics.checkNotNullParameter(it, "it");
        INSTANCE.notify(it);
        return Unit.INSTANCE;
    }

    public final boolean attach(Function1<? super Response, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        return observers.add(observer);
    }

    public final boolean detach(Function1<? super Response, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        return observers.remove(observer);
    }

    private final void notify(final Response response) {
        if (observers.isEmpty() || !response.getRequest().getSendObserver()) {
            return;
        }
        new Handler(getObserverThread().getLooper()).post(new Runnable() { // from class: com.hive.core.NetworkObserver$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                NetworkObserver.notify$lambda$8(response);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notify$lambda$8(Response response) {
        Object objM7415constructorimpl;
        Object objM7415constructorimpl2;
        try {
            Result.Companion companion = kotlin.Result.INSTANCE;
            Iterator<T> it = observers.iterator();
            while (it.hasNext()) {
                Function1 function1 = (Function1) it.next();
                try {
                    Result.Companion companion2 = kotlin.Result.INSTANCE;
                    function1.invoke(response);
                    objM7415constructorimpl2 = kotlin.Result.m7415constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion3 = kotlin.Result.INSTANCE;
                    objM7415constructorimpl2 = kotlin.Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM7418exceptionOrNullimpl = kotlin.Result.m7418exceptionOrNullimpl(objM7415constructorimpl2);
                if (thM7418exceptionOrNullimpl != null) {
                    Logger.INSTANCE.w("NetworkObserver observer invoke failed: " + thM7418exceptionOrNullimpl);
                }
            }
            objM7415constructorimpl = kotlin.Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion4 = kotlin.Result.INSTANCE;
            objM7415constructorimpl = kotlin.Result.m7415constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable thM7418exceptionOrNullimpl2 = kotlin.Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl2 != null) {
            Logger.INSTANCE.w("NetworkObserver notify failed: " + thM7418exceptionOrNullimpl2);
        }
    }
}
