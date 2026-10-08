package com.hive.social;

import android.app.Activity;
import com.facebook.internal.NativeProtocol;
import com.hive.HiveActivity;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.iapv4.Repayment;
import com.hive.standalone.HiveLifecycle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.social.SocialDialog$handleLoginScheme$1$2$2", f = "SocialDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SocialDialog$handleLoginScheme$1$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HiveLifecycle.HiveAccount $account;
    int label;
    final /* synthetic */ SocialDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocialDialog$handleLoginScheme$1$2$2(HiveLifecycle.HiveAccount hiveAccount, SocialDialog socialDialog, Continuation<? super SocialDialog$handleLoginScheme$1$2$2> continuation) {
        super(2, continuation);
        this.$account = hiveAccount;
        this.this$0 = socialDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(SocialDialog socialDialog) {
        String str = socialDialog.url;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("url");
            str = null;
        }
        socialDialog.loadUrlCI(str);
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SocialDialog$handleLoginScheme$1$2$2(this.$account, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = Repayment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof Repayment)) {
            hiveModule = null;
        }
        Repayment repayment = (Repayment) (hiveModule instanceof Repayment ? hiveModule : null);
        if (repayment != null) {
            Activity recentActivity = HiveActivity.INSTANCE.getRecentActivity();
            HiveLifecycle.HiveAccount hiveAccount = this.$account;
            final SocialDialog socialDialog = this.this$0;
            repayment.showRepayment(recentActivity, hiveAccount, new Function0() { // from class: com.hive.social.SocialDialog$handleLoginScheme$1$2$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SocialDialog$handleLoginScheme$1$2$2.invokeSuspend$lambda$0(socialDialog);
                }
            });
        } else {
            SocialDialog socialDialog2 = this.this$0;
            JSONObject jSONObject = socialDialog2.closeParam;
            if (jSONObject != null) {
                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, -12000);
            }
            socialDialog2.dismiss();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SocialDialog$handleLoginScheme$1$2$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
