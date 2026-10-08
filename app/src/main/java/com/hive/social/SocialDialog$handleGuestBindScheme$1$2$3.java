package com.hive.social;

import android.webkit.CookieSyncManager;
import com.hive.auth.AuthImpl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.social.SocialDialog$handleGuestBindScheme$1$2$3", f = "SocialDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SocialDialog$handleGuestBindScheme$1$2$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $sessionToken;
    final /* synthetic */ Ref.ObjectRef<String> $uid;
    int label;
    final /* synthetic */ SocialDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocialDialog$handleGuestBindScheme$1$2$3(Ref.ObjectRef<String> objectRef, Ref.ObjectRef<String> objectRef2, SocialDialog socialDialog, Continuation<? super SocialDialog$handleGuestBindScheme$1$2$3> continuation) {
        super(2, continuation);
        this.$uid = objectRef;
        this.$sessionToken = objectRef2;
        this.this$0 = socialDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SocialDialog$handleGuestBindScheme$1$2$3(this.$uid, this.$sessionToken, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        AuthImpl.onC2SModuleLogin$default(AuthImpl.INSTANCE, this.$uid.element, this.$sessionToken.element, false, 4, null);
        CookieSyncManager.getInstance().sync();
        this.this$0.dismiss();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SocialDialog$handleGuestBindScheme$1$2$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
