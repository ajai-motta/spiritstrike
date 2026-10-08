package com.moloco.sdk.internal.services;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes6.dex */
public final class t implements s {
    public static final a c = new a(null);
    public static final int d = 0;
    public static final String e = "ClickthroughService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r f2390a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.ClickthroughServiceImpl", f = "ClickthroughService.kt", i = {0, 0}, l = {73, 77}, m = "runClickThrough", n = {"this", "clickthroughEvent"}, s = {"L$0", "L$1"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2391a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return t.this.a(null, null, null, null, this);
        }
    }

    public t(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService) {
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        this.f2390a = externalLinkHandler;
        this.b = customUserEventBuilderService;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.moloco.sdk.internal.services.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(java.lang.String r19, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a r20, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h r21, kotlinx.coroutines.flow.MutableSharedFlow<kotlin.Unit> r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.t.a(java.lang.String, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h, kotlinx.coroutines.flow.MutableSharedFlow, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.moloco.sdk.internal.services.s
    public Object a(String str, MutableSharedFlow<Unit> mutableSharedFlow, Continuation<? super Unit> continuation) {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r rVar = this.f2390a;
        if (str == null) {
            str = "";
        }
        if (rVar.a(str) && mutableSharedFlow != null) {
            Unit unit = Unit.INSTANCE;
            Object objEmit = mutableSharedFlow.emit(unit, continuation);
            return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : unit;
        }
        return Unit.INSTANCE;
    }
}
