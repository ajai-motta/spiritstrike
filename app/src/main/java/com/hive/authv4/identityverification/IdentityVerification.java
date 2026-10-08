package com.hive.authv4.identityverification;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.provider.FontsContractCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ResultAPI;
import com.hive.authv4.identityverification.databinding.HiveAuthv4IdentityVerificationDialogBinding;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Scheme;
import com.hive.core.configuration.HiveOrientation;
import com.hive.core.webview.HiveWebView;
import com.hive.core.webview.HiveWebViewClient;
import com.hive.core.webview.SchemeHandler;
import com.hive.logger.LoggerImpl;
import com.hive.module.ModuleCheckName;
import com.hive.module.interfaces.authv4.IdentityVerification;
import com.hive.protocol.Protocol;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.UrlManager;
import com.hive.protocol.adultconfirm.DevicesActions;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import com.hive.ui.Util;
import com.hive.ui.view.HiveAnimationButton;
import com.hive.webview.HiveSchemeHandler;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: IdentityVerification.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JT\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b28\u0010\f\u001a4\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00070\rH\u0016J \u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0017JT\u0010\u0018\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a28\u0010\f\u001a4\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00070\rJ\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/hive/authv4/identityverification/IdentityVerification;", "Lcom/hive/module/interfaces/authv4/IdentityVerification;", "<init>", "()V", "inProgress", "Ljava/util/concurrent/atomic/AtomicBoolean;", "show", "", "activity", "Landroid/app/Activity;", "authUrl", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "Lcom/hive/ResultAPI;", "Lkotlin/ParameterName;", "name", "resultAPI", "Lcom/hive/module/interfaces/authv4/IdentityVerification$Identity;", "identity", "exchangeSignature", "account", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "(Lcom/hive/standalone/HiveLifecycle$HiveAccount;Lcom/hive/module/interfaces/authv4/IdentityVerification$Identity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismiss", "scheme", "Lcom/hive/core/Scheme;", "getVersionInfo", "", "WebViewCallBack", "hive-authv4-identity-verification_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IdentityVerification implements com.hive.module.interfaces.authv4.IdentityVerification {
    public static final IdentityVerification INSTANCE = new IdentityVerification();
    private static AtomicBoolean inProgress = new AtomicBoolean(false);

    private IdentityVerification() {
    }

    @Override // com.hive.module.interfaces.authv4.IdentityVerification, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return IdentityVerification.DefaultImpls.getHiveModuleName(this);
    }

    @Override // com.hive.module.interfaces.authv4.IdentityVerification
    public void show(Activity activity, String authUrl, Function2<? super ResultAPI, ? super IdentityVerification.Identity, Unit> listener) throws JSONException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[IdentityVerification] show(" + authUrl + ')');
        if (!inProgress.compareAndSet(false, true)) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C28931(listener, null), 3, null);
            return;
        }
        String str = authUrl;
        if (str == null || StringsKt.isBlank(str)) {
            authUrl = null;
        }
        if (authUrl == null) {
            authUrl = UrlManager.AdultConfirm.INSTANCE.getIdentityMobileRequest();
        }
        JSONObject jSONObjectPutCI = CommonIdentifierKt.putCI(new JSONObject());
        jSONObjectPutCI.put(HiveKeys.KEY_appid.getValue(), ConfigurationImpl.INSTANCE.getAppId());
        jSONObjectPutCI.put(HiveKeys.KEY_vid_type.getValue(), HiveLifecycle.INSTANCE.getAccount().getVidType());
        jSONObjectPutCI.put(HiveKeys.KEY_vid.getValue(), HiveLifecycle.INSTANCE.getAccount().getVid());
        jSONObjectPutCI.put(HiveKeys.KEY_uid.getValue(), HiveLifecycle.INSTANCE.getAccount().getUid());
        jSONObjectPutCI.put(HiveKeys.KEY_vid_sessionkey.getValue(), HiveLifecycle.INSTANCE.getAccount().getVidSession());
        jSONObjectPutCI.put(HiveKeys.KEY_uid_sessionkey.getValue(), HiveLifecycle.INSTANCE.getAccount().getUidSession());
        Intent intent = new Intent();
        intent.putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, true);
        intent.putExtra(HiveUiActivity.HIVE_UI_ACTIVITY_ORIENTATION, Util.INSTANCE.getSystemScreenOrientation(activity, HiveOrientation.PORTRAIT));
        Activity activity2 = activity;
        intent.setClass(activity2, IdentityVerificationActivity.class);
        HiveUiActivity.INSTANCE.launch(activity2, intent, new AnonymousClass2(jSONObjectPutCI, authUrl, listener));
    }

    /* JADX INFO: renamed from: com.hive.authv4.identityverification.IdentityVerification$show$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IdentityVerification.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.authv4.identityverification.IdentityVerification$show$1", f = "IdentityVerification.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C28931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<ResultAPI, IdentityVerification.Identity, Unit> $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C28931(Function2<? super ResultAPI, ? super IdentityVerification.Identity, Unit> function2, Continuation<? super C28931> continuation) {
            super(2, continuation);
            this.$listener = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28931(this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28931) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$listener.invoke(new ResultAPI(-3, ResultAPI.Code.AuthV4InProgress, "IdentityVerification is in progress."), null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.hive.authv4.identityverification.IdentityVerification$show$2, reason: invalid class name */
    /* JADX INFO: compiled from: IdentityVerification.kt */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0017J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"com/hive/authv4/identityverification/IdentityVerification$show$2", "Lcom/hive/ui/OnActivityLifecycle;", "launchActivity", "Landroid/app/Activity;", "getLaunchActivity", "()Landroid/app/Activity;", "setLaunchActivity", "(Landroid/app/Activity;)V", "binding", "Lcom/hive/authv4/identityverification/databinding/HiveAuthv4IdentityVerificationDialogBinding;", "getBinding", "()Lcom/hive/authv4/identityverification/databinding/HiveAuthv4IdentityVerificationDialogBinding;", "setBinding", "(Lcom/hive/authv4/identityverification/databinding/HiveAuthv4IdentityVerificationDialogBinding;)V", "onCreate", "", "activity", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "", "onDestroy", "hive-authv4-identity-verification_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass2 extends OnActivityLifecycle {
        final /* synthetic */ JSONObject $jsonBody;
        final /* synthetic */ Function2<ResultAPI, IdentityVerification.Identity, Unit> $listener;
        final /* synthetic */ String $url;
        public HiveAuthv4IdentityVerificationDialogBinding binding;
        private Activity launchActivity;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(JSONObject jSONObject, String str, Function2<? super ResultAPI, ? super IdentityVerification.Identity, Unit> function2) {
            this.$jsonBody = jSONObject;
            this.$url = str;
            this.$listener = function2;
        }

        public final Activity getLaunchActivity() {
            return this.launchActivity;
        }

        public final void setLaunchActivity(Activity activity) {
            this.launchActivity = activity;
        }

        public final HiveAuthv4IdentityVerificationDialogBinding getBinding() {
            HiveAuthv4IdentityVerificationDialogBinding hiveAuthv4IdentityVerificationDialogBinding = this.binding;
            if (hiveAuthv4IdentityVerificationDialogBinding != null) {
                return hiveAuthv4IdentityVerificationDialogBinding;
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            return null;
        }

        public final void setBinding(HiveAuthv4IdentityVerificationDialogBinding hiveAuthv4IdentityVerificationDialogBinding) {
            Intrinsics.checkNotNullParameter(hiveAuthv4IdentityVerificationDialogBinding, "<set-?>");
            this.binding = hiveAuthv4IdentityVerificationDialogBinding;
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onCreate(final Activity activity, Bundle savedInstanceState) {
            byte[] bytes;
            Intrinsics.checkNotNullParameter(activity, "activity");
            super.onCreate(activity, savedInstanceState);
            LoggerImpl.INSTANCE.d("[IdentityVerification] create view");
            this.launchActivity = activity;
            setBinding(HiveAuthv4IdentityVerificationDialogBinding.inflate(activity.getLayoutInflater()));
            activity.setContentView(getBinding().getRoot());
            HiveWebView hiveWebView = getBinding().hiveIdentityVerificationWebview;
            JSONObject jSONObject = this.$jsonBody;
            String str = this.$url;
            final Function2<ResultAPI, IdentityVerification.Identity, Unit> function2 = this.$listener;
            hiveWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            hiveWebView.setInitialScale(0);
            hiveWebView.setPadding(0, 0, 0, 0);
            hiveWebView.getSettings().setLoadWithOverviewMode(true);
            hiveWebView.getSettings().setBuiltInZoomControls(true);
            hiveWebView.getSettings().setUseWideViewPort(true);
            hiveWebView.getSettings().setJavaScriptEnabled(true);
            hiveWebView.getSettings().setCacheMode(2);
            hiveWebView.setWebViewClient(new WebViewCallBack(activity, getBinding(), new HiveSchemeHandler() { // from class: com.hive.authv4.identityverification.IdentityVerification$show$2$onCreate$1$1
                /* JADX WARN: Code restructure failed: missing block: B:24:0x0065, code lost:
                
                    if (r4.equals("intent") != false) goto L42;
                 */
                @Override // com.hive.webview.HiveSchemeHandler
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public boolean schemeEvent(android.webkit.WebView r9, com.hive.core.Scheme r10) {
                    /*
                        Method dump skipped, instruction units count: 202
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.identityverification.IdentityVerification$show$2$onCreate$1$1.schemeEvent(android.webkit.WebView, com.hive.core.Scheme):boolean");
                }
            }));
            hiveWebView.setWebChromeClient(new IdentityVerification$show$2$onCreate$1$2(activity));
            try {
                String string = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                Charset charsetForName = Charset.forName("UTF-8");
                Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
                bytes = string.getBytes(charsetForName);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            } catch (UnsupportedEncodingException e) {
                LoggerImpl.INSTANCE.w("[IdentityVerification] showWebView error: " + e);
                bytes = null;
            }
            if (bytes != null) {
                hiveWebView.setOauthToken(HiveLifecycle.INSTANCE.getAccount().getOauthToken());
                hiveWebView.postUrl(str, bytes);
            } else {
                hiveWebView.loadUrl(str);
            }
            HiveAnimationButton hiveAnimationButton = getBinding().hiveIdentityVerificationGobackDeactiveBtn;
            Intrinsics.checkNotNull(hiveAnimationButton);
            hiveAnimationButton.setVisibility(0);
            hiveAnimationButton.setEnabled(false);
            HiveAnimationButton hiveAnimationButton2 = getBinding().hiveIdentityVerificationGobackBtn;
            hiveAnimationButton2.setActionUpEventType(HiveAnimationButton.ActionUpAnimationType.USE_OFF_ANIMATION);
            Intrinsics.checkNotNull(hiveAnimationButton2);
            hiveAnimationButton2.setVisibility(8);
            hiveAnimationButton2.setOnClickedListener(new HiveAnimationButton.OnClickedListener() { // from class: com.hive.authv4.identityverification.IdentityVerification$show$2$onCreate$3$1
                @Override // com.hive.ui.view.HiveAnimationButton.OnClickedListener
                public void onClick() {
                    HiveWebView hiveWebView2 = this.this$0.getBinding().hiveIdentityVerificationWebview;
                    if (hiveWebView2.canGoBack()) {
                        hiveWebView2.goBack();
                    }
                }
            });
            HiveAnimationButton hiveAnimationButton3 = getBinding().hiveIdentityVerificationCloseBtn;
            final Function2<ResultAPI, IdentityVerification.Identity, Unit> function22 = this.$listener;
            hiveAnimationButton3.setOnClickedListener(new HiveAnimationButton.OnClickedListener() { // from class: com.hive.authv4.identityverification.IdentityVerification$show$2$onCreate$4$1
                @Override // com.hive.ui.view.HiveAnimationButton.OnClickedListener
                public void onClick() {
                    IdentityVerification.INSTANCE.dismiss(activity, null, function22);
                }
            });
            getBinding().hiveIdentityVerificationWebviewSpinner.hide();
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public boolean onBackPressed() {
            LoggerImpl.INSTANCE.d("[IdentityVerification] onBackPressed");
            HiveWebView hiveWebView = getBinding().hiveIdentityVerificationWebview;
            Function2<ResultAPI, IdentityVerification.Identity, Unit> function2 = this.$listener;
            if (hiveWebView.canGoBack()) {
                hiveWebView.goBack();
                return true;
            }
            IdentityVerification.INSTANCE.dismiss(this.launchActivity, null, function2);
            return true;
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onDestroy(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (!getIsCalledFinish()) {
                IdentityVerification.INSTANCE.dismiss(activity, null, this.$listener);
            }
            super.onDestroy(activity);
        }
    }

    @Override // com.hive.module.interfaces.authv4.IdentityVerification
    public Object exchangeSignature(HiveLifecycle.HiveAccount hiveAccount, IdentityVerification.Identity identity, Continuation<? super IdentityVerification.Identity> continuation) {
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<DevicesActions>() { // from class: com.hive.authv4.identityverification.IdentityVerification$exchangeSignature$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.adultconfirm.DevicesActions] */
            @Override // kotlin.jvm.functions.Function0
            public final DevicesActions invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = DevicesActions.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        protocol.setParam(HiveKeys.KEY_appid, ConfigurationImpl.INSTANCE.getAppId());
        protocol.setParam(HiveKeys.KEY_vid, hiveAccount.getVid());
        protocol.setParam(HiveKeys.KEY_vid_sessionkey, hiveAccount.getVidSession());
        protocol.setParam(HiveKeys.KEY_vid_type, hiveAccount.getVidType());
        protocol.setParam(HiveKeys.KEY_phone_code, identity.getPhoneCode());
        protocol.setParam(HiveKeys.KEY_phone_number, identity.getPhoneNumber());
        DevicesActions.DevicesActionsResponse response = ((DevicesActions) protocol.request()).getResponse();
        if (!response.isSuccess()) {
            return null;
        }
        identity.setSignature(response.getSignature());
        identity.setSignatureResultCode(response.getSignatureResultCode());
        return identity;
    }

    /* JADX INFO: compiled from: IdentityVerification.kt */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\"\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J,\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u0015H\u0016J \u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J \u0010$\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006)"}, d2 = {"Lcom/hive/authv4/identityverification/IdentityVerification$WebViewCallBack;", "Lcom/hive/core/webview/HiveWebViewClient;", "activity", "Landroid/app/Activity;", "binding", "Lcom/hive/authv4/identityverification/databinding/HiveAuthv4IdentityVerificationDialogBinding;", "schemeHandler", "Lcom/hive/core/webview/SchemeHandler;", "<init>", "(Landroid/app/Activity;Lcom/hive/authv4/identityverification/databinding/HiveAuthv4IdentityVerificationDialogBinding;Lcom/hive/core/webview/SchemeHandler;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "getBinding", "()Lcom/hive/authv4/identityverification/databinding/HiveAuthv4IdentityVerificationDialogBinding;", "onLoadResource", "", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPageFinished", "receivedErrorEvent", "errorCode", "", "description", "failingUrl", "onReceivedHttpError", "request", "Landroid/webkit/WebResourceRequest;", "errorResponse", "Landroid/webkit/WebResourceResponse;", "onReceivedSslError", "handler", "Landroid/webkit/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "hive-authv4-identity-verification_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WebViewCallBack extends HiveWebViewClient {
        private Activity activity;
        private final HiveAuthv4IdentityVerificationDialogBinding binding;

        public final Activity getActivity() {
            return this.activity;
        }

        public final void setActivity(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "<set-?>");
            this.activity = activity;
        }

        public final HiveAuthv4IdentityVerificationDialogBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WebViewCallBack(Activity activity, HiveAuthv4IdentityVerificationDialogBinding binding, SchemeHandler schemeHandler) {
            super(schemeHandler);
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(schemeHandler, "schemeHandler");
            this.activity = activity;
            this.binding = binding;
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            LoggerImpl.INSTANCE.d("[IdentityVerification] onLoadResource url : " + url);
            super.onLoadResource(view, url);
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            LoggerImpl.INSTANCE.d("[IdentityVerification] onPageStarted url : " + url);
            this.binding.hiveIdentityVerificationWebviewSpinner.show();
            super.onPageStarted(view, url, favicon);
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageFinished(view, url);
            LoggerImpl.INSTANCE.d("[IdentityVerification] onPageFinished url: " + url);
            if (view.canGoBack()) {
                LoggerImpl.INSTANCE.d("[IdentityVerification] gobackButton set active");
                HiveAnimationButton hiveIdentityVerificationGobackBtn = this.binding.hiveIdentityVerificationGobackBtn;
                Intrinsics.checkNotNullExpressionValue(hiveIdentityVerificationGobackBtn, "hiveIdentityVerificationGobackBtn");
                hiveIdentityVerificationGobackBtn.setVisibility(0);
                HiveAnimationButton hiveIdentityVerificationGobackDeactiveBtn = this.binding.hiveIdentityVerificationGobackDeactiveBtn;
                Intrinsics.checkNotNullExpressionValue(hiveIdentityVerificationGobackDeactiveBtn, "hiveIdentityVerificationGobackDeactiveBtn");
                hiveIdentityVerificationGobackDeactiveBtn.setVisibility(8);
            } else {
                LoggerImpl.INSTANCE.d("[IdentityVerification] gobackButton set deactive");
                HiveAnimationButton hiveIdentityVerificationGobackDeactiveBtn2 = this.binding.hiveIdentityVerificationGobackDeactiveBtn;
                Intrinsics.checkNotNullExpressionValue(hiveIdentityVerificationGobackDeactiveBtn2, "hiveIdentityVerificationGobackDeactiveBtn");
                hiveIdentityVerificationGobackDeactiveBtn2.setVisibility(0);
                HiveAnimationButton hiveIdentityVerificationGobackBtn2 = this.binding.hiveIdentityVerificationGobackBtn;
                Intrinsics.checkNotNullExpressionValue(hiveIdentityVerificationGobackBtn2, "hiveIdentityVerificationGobackBtn");
                hiveIdentityVerificationGobackBtn2.setVisibility(8);
            }
            this.binding.hiveIdentityVerificationWebviewSpinner.hide();
        }

        @Override // com.hive.core.webview.HiveWebViewClient
        public void receivedErrorEvent(WebView view, int errorCode, String description, String failingUrl) {
            Intrinsics.checkNotNullParameter(view, "view");
            LoggerImpl.INSTANCE.w("[IdentityVerification] receivedErrorEvent errorCode: " + errorCode + ", " + description + ", failingUrl: " + failingUrl);
            this.binding.hiveIdentityVerificationWebviewSpinner.hide();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
            if (request.isForMainFrame()) {
                LoggerImpl.INSTANCE.d("[IdentityVerification] onReceivedHttpError statusCode: " + errorResponse.getStatusCode() + ", failingUrl: " + request.getUrl());
                this.binding.hiveIdentityVerificationWebviewSpinner.hide();
            }
            super.onReceivedHttpError(view, request, errorResponse);
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(error, "error");
            LoggerImpl.INSTANCE.d("[IdentityVerification] onReceivedSslError errorCode: " + error.getPrimaryError() + ", failingUrl: " + error.getUrl());
            this.binding.hiveIdentityVerificationWebviewSpinner.hide();
            super.onReceivedSslError(view, handler, error);
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [T, com.hive.module.interfaces.authv4.IdentityVerification$Identity] */
    public final void dismiss(Activity activity, Scheme scheme, Function2<? super ResultAPI, ? super IdentityVerification.Identity, Unit> listener) {
        Object objM7415constructorimpl;
        ResultAPI resultAPI;
        Map<String, String> parameter;
        Map<String, String> parameter2;
        Map<String, String> parameter3;
        Map<String, String> parameter4;
        Map<String, String> parameter5;
        Map<String, String> parameter6;
        String str;
        Map<String, String> parameter7;
        ResultAPI resultAPI2;
        Map<String, String> parameter8;
        Map<String, String> parameter9;
        String str2;
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[IdentityVerification] dismiss");
        int i = (scheme == null || (parameter9 = scheme.getParameter()) == null || (str2 = parameter9.get(FontsContractCompat.Columns.RESULT_CODE)) == null) ? -1 : Integer.parseInt(str2);
        String str3 = null;
        String str4 = (scheme == null || (parameter8 = scheme.getParameter()) == null) ? null : parameter8.get("result_msg");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (i != 0) {
            if (i == 2000008) {
                LoggerImpl.INSTANCE.d("[IdentityVerification] Failed due to age restriction.");
                resultAPI2 = new ResultAPI(-6, ResultAPI.Code.AgeLimit, str4 + '(' + i + ')');
            } else {
                LoggerImpl.INSTANCE.d("[IdentityVerification] authorization failed.");
                String str5 = str4;
                if (str5 == null || StringsKt.isBlank(str5)) {
                    str4 = "user canceled";
                }
                resultAPI2 = new ResultAPI(-6, ResultAPI.Code.AuthV4CancelDialog, str4 + '(' + i + ')');
            }
            resultAPI = resultAPI2;
        } else {
            LoggerImpl.INSTANCE.d("[IdentityVerification] authorization success");
            String str6 = str4;
            if (str6 == null || StringsKt.isBlank(str6)) {
                str4 = "authorization success";
            }
            ResultAPI resultAPI3 = new ResultAPI(0, ResultAPI.Code.Success, str4 + '(' + i + ')');
            String str7 = (scheme == null || (parameter7 = scheme.getParameter()) == null) ? null : parameter7.get("birymd");
            try {
                Result.Companion companion = Result.INSTANCE;
                IdentityVerification identityVerification = this;
                if (str7 != null) {
                    String strSubstring = str7.substring(0, 4);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    String strSubstring2 = str7.substring(4, 6);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                    String strSubstring3 = str7.substring(6, 8);
                    Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                    str = strSubstring + '-' + strSubstring2 + '-' + strSubstring3;
                } else {
                    str = null;
                }
                objM7415constructorimpl = Result.m7415constructorimpl(str);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
                objM7415constructorimpl = null;
            }
            String str8 = (String) objM7415constructorimpl;
            String str9 = (scheme == null || (parameter6 = scheme.getParameter()) == null) ? null : parameter6.get("di_hash");
            String str10 = (scheme == null || (parameter5 = scheme.getParameter()) == null) ? null : parameter5.get("phone_code");
            String str11 = (scheme == null || (parameter4 = scheme.getParameter()) == null) ? null : parameter4.get("phone_number");
            String str12 = (scheme == null || (parameter3 = scheme.getParameter()) == null) ? null : parameter3.get(InAppPurchaseMetaData.KEY_SIGNATURE);
            String str13 = (scheme == null || (parameter2 = scheme.getParameter()) == null) ? null : parameter2.get("signature_result_code");
            if (scheme != null && (parameter = scheme.getParameter()) != null) {
                str3 = parameter.get("identity_signature");
            }
            objectRef.element = new IdentityVerification.Identity(i, str4, scheme, str9, str10, str11, str7, str8, str12, str13, str3);
            resultAPI = resultAPI3;
        }
        inProgress.set(false);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(objectRef, resultAPI, listener, activity, null), 3, null);
    }

    /* JADX INFO: renamed from: com.hive.authv4.identityverification.IdentityVerification$dismiss$1, reason: invalid class name */
    /* JADX INFO: compiled from: IdentityVerification.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.authv4.identityverification.IdentityVerification$dismiss$1", f = "IdentityVerification.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ Ref.ObjectRef<IdentityVerification.Identity> $identity;
        final /* synthetic */ Function2<ResultAPI, IdentityVerification.Identity, Unit> $listener;
        final /* synthetic */ ResultAPI $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Ref.ObjectRef<IdentityVerification.Identity> objectRef, ResultAPI resultAPI, Function2<? super ResultAPI, ? super IdentityVerification.Identity, Unit> function2, Activity activity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$identity = objectRef;
            this.$result = resultAPI;
            this.$listener = function2;
            this.$activity = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$identity, this.$result, this.$listener, this.$activity, continuation);
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
            LoggerImpl.INSTANCE.dL("[IdentityVerification] identity: " + this.$identity.element + '\n');
            LoggerImpl.INSTANCE.dR("[IdentityVerification] identity: " + this.$result + '\n');
            this.$listener.invoke(this.$result, this.$identity.element);
            Activity activity = this.$activity;
            if (activity != null) {
                activity.finish();
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        HashMap map = new HashMap();
        map.put(ModuleCheckName.INSTANCE.getHive_Authv4_Identity_Verification(), "26.2.0");
        return map;
    }
}
