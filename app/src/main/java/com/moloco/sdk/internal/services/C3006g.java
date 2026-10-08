package com.moloco.sdk.internal.services;

import androidx.lifecycle.Lifecycle;
import com.moloco.sdk.internal.MolocoLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: renamed from: com.moloco.sdk.internal.services.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3006g implements InterfaceC3005f {
    public static final a e = new a(null);
    public static final int f = 8;
    public static final String g = "AnalyticsApplicationLifecycleTrackerImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lifecycle f2354a;
    public final SingleObserverBackgroundThenForegroundAnalyticsListener b;
    public final CoroutineScope c;
    public boolean d;

    /* JADX INFO: renamed from: com.moloco.sdk.internal.services.g$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.services.g$b */
    @DebugMetadata(c = "com.moloco.sdk.internal.services.AnalyticsApplicationLifecycleTrackerImpl$startObserving$1", f = "AnalyticsApplicationLifecycleTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2355a;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return C3006g.this.new b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2355a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            C3006g.this.c();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.services.g$c */
    @DebugMetadata(c = "com.moloco.sdk.internal.services.AnalyticsApplicationLifecycleTrackerImpl$trackNextBackgroundForeground$1", f = "AnalyticsApplicationLifecycleTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2356a;

        public c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return C3006g.this.new c(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2356a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            MolocoLogger.debug$default(MolocoLogger.INSTANCE, C3006g.g, "Tracking next bg / fg of the application", false, 4, null);
            C3006g.this.c();
            C3006g.this.b.a();
            return Unit.INSTANCE;
        }
    }

    public C3006g(Lifecycle lifecycle, SingleObserverBackgroundThenForegroundAnalyticsListener fgBgListener) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(fgBgListener, "fgBgListener");
        this.f2354a = lifecycle;
        this.b = fgBgListener;
        this.c = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMainImmediate());
    }

    public final void c() {
        if (this.d) {
            return;
        }
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, g, "Observing application lifecycle events", false, 4, null);
        this.f2354a.addObserver(this.b);
        this.d = true;
    }

    @Override // com.moloco.sdk.internal.services.InterfaceC3005f
    public void a() {
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, g, "Start observing application lifecycle events", false, 4, null);
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new b(null), 3, null);
    }

    @Override // com.moloco.sdk.internal.services.InterfaceC3005f
    public void b() {
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new c(null), 3, null);
    }
}
