package com.hive.socialv4.provider;

import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.HiveActivity;
import com.hive.Promotion;
import com.hive.ResultAPI;
import com.hive.SocialV4;
import com.hive.base.HivePicture;
import com.hive.core.Configuration;
import com.hive.core.OauthToken;
import com.hive.core.Scheme;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.HivePromotion;
import com.hive.protocol.UrlManager;
import com.hive.socialv4.provider.SocialV4ProviderAdapter;
import com.hive.standalone.HiveLifecycle;
import com.hive.webview.HiveSchemeHandler;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0002¨\u0006\u0016"}, d2 = {"Lcom/hive/socialv4/provider/SocialV4ProviderHive;", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter;", "<init>", "()V", "showCommunity", "", "viewType", "Lcom/hive/SocialV4$ViewType;", "url", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$ShowCommunityListener;", "isConnected", "", "isAuthorized", "", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialV4RequestListener;", "disconnect", "getServiceName", "getCommunityUrl", "SocialV4SchemeHandler", "SocialV4ChromeClient", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SocialV4ProviderHive extends SocialV4ProviderAdapter {
    public static final SocialV4ProviderHive INSTANCE = new SocialV4ProviderHive();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0014\u0010\b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/hive/socialv4/provider/SocialV4ProviderHive$SocialV4ChromeClient;", "Landroid/webkit/WebChromeClient;", "<init>", "()V", "onShowFileChooser", "", "webView", "Landroid/webkit/WebView;", "filePathCallback", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "fileChooserParams", "Landroid/webkit/WebChromeClient$FileChooserParams;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SocialV4ChromeClient extends WebChromeClient {
        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, final ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            LoggerImpl.INSTANCE.i("[SocialV4ChromeClient] Call SocialV4ChromeClient.onShowFileChooser()");
            HivePicture.INSTANCE.getPictureFromChooser(new HivePicture.ChooserResultListener() { // from class: com.hive.socialv4.provider.SocialV4ProviderHive$SocialV4ChromeClient$onShowFileChooser$1
                @Override // com.hive.base.HivePicture.ChooserResultListener
                public void onChooserResult(ResultAPI result, Uri uri) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    LoggerImpl.INSTANCE.i("[SocialV4ChromeClient] HivePicture.onChooserResult()\nResultAPI: " + result + " Uri: " + uri);
                    if (!result.isSuccess() || uri == null) {
                        ValueCallback<Uri[]> valueCallback = filePathCallback;
                        if (valueCallback != null) {
                            valueCallback.onReceiveValue(null);
                            return;
                        }
                        return;
                    }
                    HiveActivity hiveActivity = HiveActivity.INSTANCE;
                    hiveActivity.getRecentActivity().grantUriPermission(hiveActivity.getRecentActivity().getPackageName(), uri, 1);
                    ValueCallback<Uri[]> valueCallback2 = filePathCallback;
                    if (valueCallback2 != null) {
                        valueCallback2.onReceiveValue(new Uri[]{uri});
                    }
                }
            });
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/hive/socialv4/provider/SocialV4ProviderHive$SocialV4SchemeHandler;", "Lcom/hive/webview/HiveSchemeHandler;", "<init>", "()V", "schemeEvent", "", "view", "Landroid/webkit/WebView;", "scheme", "Lcom/hive/core/Scheme;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SocialV4SchemeHandler extends HiveSchemeHandler {
        @Override // com.hive.webview.HiveSchemeHandler
        public boolean schemeEvent(WebView view, Scheme scheme) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.d("[SocialV4WebViewClient] schemeEvent: " + scheme);
            if (!Intrinsics.areEqual(scheme.getScheme(), "hivesocial") || !Intrinsics.areEqual(scheme.getHost(), "sharesns")) {
                return super.schemeEvent(view, scheme);
            }
            loggerImpl.d("[SocialV4WebViewClient] schemeEvent handle \"sharesns\"");
            String str = scheme.getParameter().get("title");
            String strDecode = "";
            if (str == null) {
                str = "";
            }
            String str2 = scheme.getParameter().get("url");
            if (str2 != null) {
                try {
                    strDecode = URLDecoder.decode(str2, Charsets.UTF_8.name());
                } catch (Exception e) {
                    LoggerImpl.INSTANCE.d("[SocialV4WebViewClient] schemeEvent handle \"sharesns\"\n exception: " + e.getMessage());
                }
            } else {
                loggerImpl.d("[SocialV4WebViewClient] schemeEvent handle url is null");
            }
            HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
            String name = HivePromotion.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
            if (!(hiveModule instanceof HivePromotion)) {
                hiveModule = null;
            }
            HivePromotion hivePromotion = (HivePromotion) (hiveModule instanceof HivePromotion ? hiveModule : null);
            if (hivePromotion == null) {
                return true;
            }
            Intrinsics.checkNotNull(strDecode);
            hivePromotion.showUAShare(str, strDecode, false, new Promotion.PromotionShareListener() { // from class: com.hive.socialv4.provider.SocialV4ProviderHive$SocialV4SchemeHandler$schemeEvent$1
                @Override // com.hive.Promotion.PromotionShareListener
                public void onPromotionShare(ResultAPI result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    LoggerImpl.INSTANCE.d("[SocialV4WebViewClient] schemeEvent showUAShare(result: " + result + ')');
                }
            });
            return true;
        }
    }

    /* JADX INFO: renamed from: com.hive.socialv4.provider.SocialV4ProviderHive$showCommunity$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.socialv4.provider.SocialV4ProviderHive$showCommunity$1", f = "SocialV4ProviderHive.kt", i = {0, 0, 0, 0, 0}, l = {77}, m = "invokeSuspend", n = {"hiveAccount", "activity", "communityUrl", "jsonPostData", "did"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SocialV4ProviderAdapter.ShowCommunityListener $listener;
        final /* synthetic */ String $url;
        final /* synthetic */ SocialV4.ViewType $viewType;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX INFO: renamed from: com.hive.socialv4.provider.SocialV4ProviderHive$showCommunity$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.socialv4.provider.SocialV4ProviderHive$showCommunity$1$1", f = "SocialV4ProviderHive.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C03591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ HiveLifecycle.HiveAccount $hiveAccount;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C03591(HiveLifecycle.HiveAccount hiveAccount, Continuation<? super C03591> continuation) {
                super(2, continuation);
                this.$hiveAccount = hiveAccount;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C03591(this.$hiveAccount, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                OauthToken oauthToken = this.$hiveAccount.getOauthToken();
                if (oauthToken == null) {
                    return null;
                }
                if (oauthToken.isExpire(1800)) {
                    oauthToken.refresh();
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C03591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: renamed from: com.hive.socialv4.provider.SocialV4ProviderHive$showCommunity$1$WhenMappings */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[SocialV4.ViewType.values().length];
                try {
                    iArr[SocialV4.ViewType.FullScreen.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SocialV4.ViewType.Frame.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SocialV4ProviderAdapter.ShowCommunityListener showCommunityListener, String str, SocialV4.ViewType viewType, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$listener = showCommunityListener;
            this.$url = str;
            this.$viewType = viewType;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$listener, this.$url, this.$viewType, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x0170  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x01a5  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 507
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.socialv4.provider.SocialV4ProviderHive.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    private SocialV4ProviderHive() {
        super(SocialV4.ProviderType.HIVE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getCommunityUrl() {
        String string;
        Configuration configuration = Configuration.INSTANCE;
        JSONObject metaData = configuration.getMetaData();
        if (metaData == null) {
            return null;
        }
        try {
            Object objOpt = metaData.opt("community");
            String str = objOpt instanceof String ? (String) objOpt : null;
            Object objOpt2 = metaData.opt("custom_community");
            String str2 = objOpt2 instanceof String ? (String) objOpt2 : null;
            LoggerImpl.INSTANCE.d("[SocialV4ProviderHive] Community communityFlag {" + str + "}, customCommunityFlag {" + str2 + AbstractJsonLexerKt.END_OBJ);
            if (Intrinsics.areEqual(str, "1") || Intrinsics.areEqual(str, "true") || Intrinsics.areEqual(str, "TRUE")) {
                string = metaData.getString("community_url");
            } else if (Intrinsics.areEqual(str2, "1") || Intrinsics.areEqual(str2, "true") || Intrinsics.areEqual(str2, "TRUE")) {
                string = metaData.getString("custom_community_url");
            } else {
                string = configuration.getHiveCommunityUrl();
                if (StringsKt.isBlank(string)) {
                    string = null;
                }
                if (string == null) {
                    string = UrlManager.CommunityWeb.INSTANCE.getView();
                }
            }
            return string;
        } catch (JSONException e) {
            LoggerImpl.INSTANCE.d("[SocialV4ProviderHive] getCommunityUrl exception " + e.getMessage());
            return null;
        }
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void disconnect() {
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public String getServiceName() {
        return getProviderType().name();
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public int isAuthorized(SocialV4ProviderAdapter.SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return 0;
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public boolean isConnected() {
        return true;
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void showCommunity(SocialV4.ViewType viewType, String url, SocialV4ProviderAdapter.ShowCommunityListener listener) {
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(listener, url, viewType, null), 3, null);
    }
}
