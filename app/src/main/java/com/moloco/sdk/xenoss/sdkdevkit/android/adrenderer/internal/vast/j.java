package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes6.dex */
public final class j implements i {

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserImpl", f = "VastParser.kt", i = {}, l = {65}, m = "invoke", n = {}, s = {})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2761a;
        public /* synthetic */ Object b;
        public int d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return j.this.a(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0061 A[Catch: all -> 0x002d, TryCatch #3 {all -> 0x002d, blocks: (B:12:0x0029, B:24:0x005d, B:26:0x0061, B:27:0x0067), top: B:44:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0067 A[Catch: all -> 0x002d, TRY_LEAVE, TryCatch #3 {all -> 0x002d, blocks: (B:12:0x0029, B:24:0x005d, B:26:0x0061, B:27:0x0067), top: B:44:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(java.lang.String r7, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.j.a
            if (r0 == 0) goto L13
            r0 = r8
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.j$a r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.j.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.j$a r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.j$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r7 = r0.f2761a
            java.io.Closeable r7 = (java.io.Closeable) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L2d
            goto L5d
        L2d:
            r8 = move-exception
            goto L77
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            kotlin.ResultKt.throwOnFailure(r8)
            java.io.StringReader r8 = new java.io.StringReader     // Catch: java.lang.Exception -> L7d
            r8.<init>(r7)     // Catch: java.lang.Exception -> L7d
            org.xmlpull.v1.XmlPullParser r7 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L73
            java.lang.String r2 = "http://xmlpull.org/v1/doc/features.html#process-namespaces"
            r4 = 0
            r7.setFeature(r2, r4)     // Catch: java.lang.Throwable -> L73
            r7.setInput(r8)     // Catch: java.lang.Throwable -> L73
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch: java.lang.Throwable -> L73
            r0.f2761a = r8     // Catch: java.lang.Throwable -> L73
            r0.d = r3     // Catch: java.lang.Throwable -> L73
            java.lang.Object r7 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.u(r7, r0)     // Catch: java.lang.Throwable -> L73
            if (r7 != r1) goto L5a
            return r1
        L5a:
            r5 = r8
            r8 = r7
            r7 = r5
        L5d:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w r8 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w) r8     // Catch: java.lang.Throwable -> L2d
            if (r8 == 0) goto L67
            com.moloco.sdk.internal.v$b r0 = new com.moloco.sdk.internal.v$b     // Catch: java.lang.Throwable -> L2d
            r0.<init>(r8)     // Catch: java.lang.Throwable -> L2d
            goto L6e
        L67:
            com.moloco.sdk.internal.v$a r0 = new com.moloco.sdk.internal.v$a     // Catch: java.lang.Throwable -> L2d
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k r8 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.c     // Catch: java.lang.Throwable -> L2d
            r0.<init>(r8)     // Catch: java.lang.Throwable -> L2d
        L6e:
            r8 = 0
            kotlin.io.CloseableKt.closeFinally(r7, r8)     // Catch: java.lang.Exception -> L7d
            goto L84
        L73:
            r7 = move-exception
            r5 = r8
            r8 = r7
            r7 = r5
        L77:
            throw r8     // Catch: java.lang.Throwable -> L78
        L78:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r7, r8)     // Catch: java.lang.Exception -> L7d
            throw r0     // Catch: java.lang.Exception -> L7d
        L7d:
            com.moloco.sdk.internal.v$a r0 = new com.moloco.sdk.internal.v$a
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k r7 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.b
            r0.<init>(r7)
        L84:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.j.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
