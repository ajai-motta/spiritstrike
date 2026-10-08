package com.hive.core.cache;

import com.hive.core.Logger;
import com.hive.core.Network;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.core.cache.HiveResourceWorker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: HiveResourceWorker.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/hive/core/cache/HiveResourceWorker;", "", "loader", "Lcom/hive/core/cache/HiveResourceLoader;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/hive/core/cache/HiveResourceLoader;Lkotlinx/coroutines/CoroutineDispatcher;)V", "isIdle", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hashCode", "", "work", "", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveResourceWorker {
    private final CoroutineDispatcher dispatcher;
    private final int hashCode;
    private AtomicBoolean isIdle;
    private final HiveResourceLoader loader;

    public HiveResourceWorker(HiveResourceLoader loader, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(loader, "loader");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.loader = loader;
        this.dispatcher = dispatcher;
        this.isIdle = new AtomicBoolean(true);
        this.hashCode = hashCode();
    }

    public final void work() {
        if (this.isIdle.compareAndSet(true, false)) {
            Logger.INSTANCE.d("[HiveResourceWorker](" + this.hashCode + ") worker state: working");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.dispatcher), null, null, new AnonymousClass1(null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.hive.core.cache.HiveResourceWorker$work$1, reason: invalid class name */
    /* JADX INFO: compiled from: HiveResourceWorker.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.core.cache.HiveResourceWorker$work$1", f = "HiveResourceWorker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HiveResourceWorker.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            while (HiveResourceWorker.this.loader.peekTaskQueue$hive_core_release() != null) {
                final HiveResourceRequestData hiveResourceRequestDataPollTaskQueue$hive_core_release = HiveResourceWorker.this.loader.pollTaskQueue$hive_core_release();
                if (hiveResourceRequestDataPollTaskQueue$hive_core_release != null) {
                    final byte[] cache$hive_core_release = HiveResourceWorker.this.loader.readCache$hive_core_release(hiveResourceRequestDataPollTaskQueue$hive_core_release.getUrl());
                    if (cache$hive_core_release == null) {
                        if (HiveResourceWorker.this.loader.isDelayed$hive_core_release()) {
                            Boxing.boxBoolean(arrayList.add(hiveResourceRequestDataPollTaskQueue$hive_core_release));
                        } else {
                            Response responseSync = Network.INSTANCE.sync(new Request(hiveResourceRequestDataPollTaskQueue$hive_core_release.getUrl(), Request.MethodType.GET));
                            final byte[] content = responseSync.getContent();
                            final String message = responseSync.getResult().getMessage();
                            if (responseSync.getResult().isSuccess() && content != null) {
                                if (!(content.length == 0)) {
                                    HiveResourceWorker.this.loader.writeCache$hive_core_release(hiveResourceRequestDataPollTaskQueue$hive_core_release.getUrl(), content);
                                    final HiveResourceLoadingListener listener = hiveResourceRequestDataPollTaskQueue$hive_core_release.getListener();
                                    if (listener != null) {
                                        final HiveResourceWorker hiveResourceWorker = HiveResourceWorker.this;
                                        Boxing.boxBoolean(hiveResourceRequestDataPollTaskQueue$hive_core_release.getHandler().post(new Runnable() { // from class: com.hive.core.cache.HiveResourceWorker$work$1$$ExternalSyntheticLambda1
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                HiveResourceWorker.AnonymousClass1.invokeSuspend$lambda$3$lambda$2(hiveResourceWorker, hiveResourceRequestDataPollTaskQueue$hive_core_release, listener, content);
                                            }
                                        }));
                                    }
                                }
                            }
                            final HiveResourceLoadingListener listener2 = hiveResourceRequestDataPollTaskQueue$hive_core_release.getListener();
                            if (listener2 != null) {
                                final HiveResourceWorker hiveResourceWorker2 = HiveResourceWorker.this;
                                Boxing.boxBoolean(hiveResourceRequestDataPollTaskQueue$hive_core_release.getHandler().post(new Runnable() { // from class: com.hive.core.cache.HiveResourceWorker$work$1$$ExternalSyntheticLambda2
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        HiveResourceWorker.AnonymousClass1.invokeSuspend$lambda$5$lambda$4(hiveResourceWorker2, message, hiveResourceRequestDataPollTaskQueue$hive_core_release, listener2);
                                    }
                                }));
                            }
                        }
                    } else {
                        Logger.INSTANCE.d("[HiveResourceWorker](" + HiveResourceWorker.this.hashCode + ") cache data exist: " + hiveResourceRequestDataPollTaskQueue$hive_core_release.getUrl());
                        final HiveResourceLoadingListener listener3 = hiveResourceRequestDataPollTaskQueue$hive_core_release.getListener();
                        if (listener3 != null) {
                            final HiveResourceWorker hiveResourceWorker3 = HiveResourceWorker.this;
                            Boxing.boxBoolean(hiveResourceRequestDataPollTaskQueue$hive_core_release.getHandler().post(new Runnable() { // from class: com.hive.core.cache.HiveResourceWorker$work$1$$ExternalSyntheticLambda0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    HiveResourceWorker.AnonymousClass1.invokeSuspend$lambda$1$lambda$0(hiveResourceWorker3, hiveResourceRequestDataPollTaskQueue$hive_core_release, listener3, cache$hive_core_release);
                                }
                            }));
                        }
                    }
                }
            }
            Iterator it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                HiveResourceWorker.this.loader.offerTaskQueue$hive_core_release((HiveResourceRequestData) next);
            }
            HiveResourceWorker.this.isIdle.set(true);
            Logger.INSTANCE.d("[HiveResourceWorker](" + HiveResourceWorker.this.hashCode + ") worker state: idle");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$1$lambda$0(HiveResourceWorker hiveResourceWorker, HiveResourceRequestData hiveResourceRequestData, HiveResourceLoadingListener hiveResourceLoadingListener, byte[] bArr) {
            Logger.INSTANCE.d("[HiveResourceWorker](" + hiveResourceWorker.hashCode + ") onLoadingComplete: " + hiveResourceRequestData.getUrl());
            hiveResourceLoadingListener.onLoadingComplete(hiveResourceRequestData.getUrl(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$3$lambda$2(HiveResourceWorker hiveResourceWorker, HiveResourceRequestData hiveResourceRequestData, HiveResourceLoadingListener hiveResourceLoadingListener, byte[] bArr) {
            Logger.INSTANCE.d("[HiveResourceWorker](" + hiveResourceWorker.hashCode + ") onLoadingComplete: " + hiveResourceRequestData.getUrl());
            hiveResourceLoadingListener.onLoadingComplete(hiveResourceRequestData.getUrl(), bArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$5$lambda$4(HiveResourceWorker hiveResourceWorker, String str, HiveResourceRequestData hiveResourceRequestData, HiveResourceLoadingListener hiveResourceLoadingListener) {
            Logger.INSTANCE.w("[HiveResourceWorker](" + hiveResourceWorker.hashCode + ") onLoadingFailed: " + str + ", url: " + hiveResourceRequestData.getUrl());
            hiveResourceLoadingListener.onLoadingFailed(hiveResourceRequestData.getUrl(), str);
        }
    }
}
