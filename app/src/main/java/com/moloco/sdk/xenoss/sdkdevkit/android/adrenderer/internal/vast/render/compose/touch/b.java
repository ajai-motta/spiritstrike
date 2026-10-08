package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.TapKt$detectTapUnconsumed$2", f = "Tap.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2947a;
        public /* synthetic */ Object b;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a c;
        public final /* synthetic */ Function2<Offset, Offset, Unit> d;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.b$a$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.TapKt$detectTapUnconsumed$2$1", f = "Tap.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0510a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2948a;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a b;
            public final /* synthetic */ PointerInputScope c;
            public final /* synthetic */ Function2<Offset, Offset, Unit> d;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.b$a$a$a, reason: collision with other inner class name */
            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.TapKt$detectTapUnconsumed$2$1$1", f = "Tap.kt", i = {0, 1}, l = {45, 48}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "down"}, s = {"L$0", "L$0"})
            public static final class C0511a extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f2949a;
                public /* synthetic */ Object b;
                public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a c;
                public final /* synthetic */ Function2<Offset, Offset, Unit> d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C0511a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a aVar, Function2<? super Offset, ? super Offset, Unit> function2, Continuation<? super C0511a> continuation) {
                    super(2, continuation);
                    this.c = aVar;
                    this.d = function2;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((C0511a) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C0511a c0511a = new C0511a(this.c, this.d, continuation);
                    c0511a.b = obj;
                    return c0511a;
                }

                /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
                /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
                    /*
                        r5 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r5.f2949a
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L26
                        if (r1 == r3) goto L1e
                        if (r1 != r2) goto L16
                        java.lang.Object r0 = r5.b
                        androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.ui.input.pointer.PointerInputChange) r0
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L56
                    L16:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r0)
                        throw r6
                    L1e:
                        java.lang.Object r1 = r5.b
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L3a
                    L26:
                        kotlin.ResultKt.throwOnFailure(r6)
                        java.lang.Object r6 = r5.b
                        r1 = r6
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        r5.b = r1
                        r5.f2949a = r3
                        r6 = 0
                        java.lang.Object r6 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(r1, r6, r5)
                        if (r6 != r0) goto L3a
                        return r0
                    L3a:
                        androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
                        boolean r3 = r6.getPressed()
                        boolean r4 = r6.getPreviousPressed()
                        if (r3 == r4) goto L49
                        r6.consume()
                    L49:
                        r5.b = r6
                        r5.f2949a = r2
                        java.lang.Object r1 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.b.a(r1, r5)
                        if (r1 != r0) goto L54
                        return r0
                    L54:
                        r0 = r6
                        r6 = r1
                    L56:
                        androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
                        if (r6 != 0) goto L60
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a r6 = r5.c
                        r6.a()
                        goto L7a
                    L60:
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a r1 = r5.c
                        r1.b()
                        kotlin.jvm.functions.Function2<androidx.compose.ui.geometry.Offset, androidx.compose.ui.geometry.Offset, kotlin.Unit> r1 = r5.d
                        long r2 = r0.getPosition()
                        androidx.compose.ui.geometry.Offset r0 = androidx.compose.ui.geometry.Offset.m1397boximpl(r2)
                        long r2 = r6.getPosition()
                        androidx.compose.ui.geometry.Offset r6 = androidx.compose.ui.geometry.Offset.m1397boximpl(r2)
                        r1.invoke(r0, r6)
                    L7a:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.b.a.C0510a.C0511a.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0510a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a aVar, PointerInputScope pointerInputScope, Function2<? super Offset, ? super Offset, Unit> function2, Continuation<? super C0510a> continuation) {
                super(2, continuation);
                this.b = aVar;
                this.c = pointerInputScope;
                this.d = function2;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0510a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0510a(this.b, this.c, this.d, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f2948a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.b.c();
                    PointerInputScope pointerInputScope = this.c;
                    C0511a c0511a = new C0511a(this.b, this.d, null);
                    this.f2948a = 1;
                    if (pointerInputScope.awaitPointerEventScope(c0511a, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a aVar, Function2<? super Offset, ? super Offset, Unit> function2, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = aVar;
            this.d = function2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((a) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.c, this.d, continuation);
            aVar.b = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2947a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C0510a c0510a = new C0510a(this.c, (PointerInputScope) this.b, this.d, null);
                this.f2947a = 1;
                if (CoroutineScopeKt.coroutineScope(c0510a, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.b$b, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.TapKt", f = "Tap.kt", i = {0, 1}, l = {62, 77}, m = "waitForUpOrCancellationInitial", n = {"$this$waitForUpOrCancellationInitial", "$this$waitForUpOrCancellationInitial"}, s = {"L$0", "L$0"})
    public static final class C0512b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2950a;
        public /* synthetic */ Object b;
        public int c;

        public C0512b(Continuation<? super C0512b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            return b.b((AwaitPointerEventScope) null, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0095, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0052 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00a0 -> B:36:0x00a3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object b(androidx.compose.ui.input.pointer.AwaitPointerEventScope r13, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.b.b(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final <T> void c(List<? extends T> list, Function1<? super T, Unit> function1) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            function1.invoke(list.get(i));
        }
    }

    public static final Object a(PointerInputScope pointerInputScope, Function2<? super Offset, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) throws Throwable {
        Object objForEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new a(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a(pointerInputScope), function2, null), continuation);
        return objForEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objForEachGesture : Unit.INSTANCE;
    }

    public static final <T> boolean a(List<? extends T> list, Function1<? super T, Boolean> function1) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!function1.invoke(list.get(i)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean b(List<? extends T> list, Function1<? super T, Boolean> function1) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (function1.invoke(list.get(i)).booleanValue()) {
                return true;
            }
        }
        return false;
    }
}
