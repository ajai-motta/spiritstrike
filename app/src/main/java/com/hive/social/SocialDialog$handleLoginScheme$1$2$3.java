package com.hive.social;

import android.webkit.CookieSyncManager;
import com.adjust.sdk.Constants;
import com.facebook.internal.ServerProtocol;
import com.hive.auth.AuthImpl;
import com.hive.logger.LoggerImpl;
import com.hive.protocol.UrlManager;
import com.hive.socialv4.provider.SocialV4ProviderAdapter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.io.files.FileSystemKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.social.SocialDialog$handleLoginScheme$1$2$3", f = "SocialDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SocialDialog$handleLoginScheme$1$2$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $params;
    final /* synthetic */ Ref.ObjectRef<String> $sessionToken;
    final /* synthetic */ Ref.ObjectRef<String> $uid;
    int label;
    final /* synthetic */ SocialDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocialDialog$handleLoginScheme$1$2$3(Ref.ObjectRef<String> objectRef, Ref.ObjectRef<String> objectRef2, JSONObject jSONObject, SocialDialog socialDialog, Continuation<? super SocialDialog$handleLoginScheme$1$2$3> continuation) {
        super(2, continuation);
        this.$uid = objectRef;
        this.$sessionToken = objectRef2;
        this.$params = jSONObject;
        this.this$0 = socialDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SocialDialog$handleLoginScheme$1$2$3(this.$uid, this.$sessionToken, this.$params, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String serviceName;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        AuthImpl.onC2SModuleLogin$default(AuthImpl.INSTANCE, this.$uid.element, this.$sessionToken.element, false, 4, null);
        String strOptString = this.$params.optString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI);
        Intrinsics.checkNotNull(strOptString);
        if (strOptString.length() <= 0) {
            strOptString = null;
        }
        if (strOptString != null) {
            SocialDialog socialDialog = this.this$0;
            String str = UrlManager.SocialWeb.INSTANCE.getServer() + FileSystemKt.UnixPathSeparator + strOptString;
            LoggerImpl.INSTANCE.d("SOCIAL_URL_TEST", str);
            socialDialog.loadUrl(str);
        } else {
            SocialDialog socialDialog2 = this.this$0;
            JSONObject jSONObject = this.$params;
            SocialV4ProviderAdapter addedChinaProvider = SocialV4ProviderAdapter.INSTANCE.getAddedChinaProvider();
            if (addedChinaProvider == null || (serviceName = addedChinaProvider.getServiceName()) == null) {
                serviceName = "";
            }
            int iHashCode = serviceName.hashCode();
            if (iHashCode == -1206476313 ? serviceName.equals("huawei") : iHashCode == 3418016 ? serviceName.equals("oppo") : iHashCode == 3620012 && serviceName.equals(Constants.REFERRER_API_VIVO)) {
                JSONObject jSONObject2 = socialDialog2.closeParam;
                if (jSONObject2 != null) {
                    jSONObject2.put("checkRealName", 0);
                }
                socialDialog2.handleSocialRequestCheckRealNameScheme(jSONObject);
            } else {
                CookieSyncManager.getInstance().sync();
                socialDialog2.dismiss();
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SocialDialog$handleLoginScheme$1$2$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
