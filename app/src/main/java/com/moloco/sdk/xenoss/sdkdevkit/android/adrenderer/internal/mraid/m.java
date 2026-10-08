package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.content.Context;
import android.webkit.WebView;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class m extends e implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g {
    public static final int q = 8;
    public final Function0<Unit> n;
    public final Function0<Unit> o;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h p;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidInline", f = "MraidInline.kt", i = {0}, l = {41}, m = "load", n = {"this"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2586a;
        public /* synthetic */ Object b;
        public int d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return m.this.c(this);
        }
    }

    public /* synthetic */ m(Context context, String str, Function0 function0, Function0 function02, Function0 function03, Function1 function1, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r rVar, f fVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h hVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, function0, function02, function03, function1, z, rVar, fVar, (i & 512) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.j.a() : hVar);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e
    public void T() {
        super.T();
        this.n.invoke();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(a.AbstractC0526a.c button) {
        Intrinsics.checkNotNullParameter(button, "button");
        this.p.a(button);
    }

    public final WebView c() {
        return H().c();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e
    public void s() {
        super.s();
        this.o.invoke();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(a.AbstractC0526a.c.EnumC0528a buttonType) {
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        this.p.a(buttonType);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(kotlin.coroutines.Continuation<? super android.webkit.WebView> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m.a
            if (r0 == 0) goto L13
            r0 = r5
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m$a r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m$a r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.f2586a
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L44
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.f2586a = r4
            r0.d = r3
            java.lang.Object r5 = r4.b(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            r0 = r4
        L44:
            boolean r5 = r5 instanceof com.moloco.sdk.internal.v.b
            if (r5 == 0) goto L51
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f r5 = r0.H()
            android.webkit.WebView r5 = r5.c()
            goto L52
        L51:
            r5 = 0
        L52:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m.c(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Context context, String adm, Function0<Unit> onNeedToDetachAdViewBeforeExpand, Function0<Unit> onExpandAdViewClosed, Function0<Unit> onClick, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, Unit> onError, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r externalLinkHandler, f mraidBridge, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h buttonTracker) {
        super(context, adm, r.b, onClick, onError, externalLinkHandler, z, mraidBridge);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adm, "adm");
        Intrinsics.checkNotNullParameter(onNeedToDetachAdViewBeforeExpand, "onNeedToDetachAdViewBeforeExpand");
        Intrinsics.checkNotNullParameter(onExpandAdViewClosed, "onExpandAdViewClosed");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(mraidBridge, "mraidBridge");
        Intrinsics.checkNotNullParameter(buttonTracker, "buttonTracker");
        this.n = onNeedToDetachAdViewBeforeExpand;
        this.o = onExpandAdViewClosed;
        this.p = buttonTracker;
    }
}
