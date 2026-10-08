package com.hive.platformhelper;

import android.app.Activity;
import android.content.DialogInterface;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.HiveActivity;
import com.hive.PlatformHelper;
import com.hive.Promotion;
import com.hive.ResultAPI;
import com.hive.base.Android;
import com.hive.base.HivePicture;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.CookieManager;
import com.hive.core.HiveKeys;
import com.hive.core.OauthToken;
import com.hive.core.Platform;
import com.hive.core.Scheme;
import com.hive.core.webview.HiveWebView;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.HivePromotion;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.common.HiveUi;
import com.hive.ui.common.model.HiveFullscreenViewData;
import com.hive.webview.HiveSchemeHandler;
import java.net.URLDecoder;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/hive/platformhelper/InAppWebView;", "", "activity", "Landroid/app/Activity;", "param", "Lcom/hive/PlatformHelper$InAppWebViewParam;", "<init>", "(Landroid/app/Activity;Lcom/hive/PlatformHelper$InAppWebViewParam;)V", "getActivity", "()Landroid/app/Activity;", "getParam", "()Lcom/hive/PlatformHelper$InAppWebViewParam;", "resultApi", "Lcom/hive/ResultAPI;", "show", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/PlatformHelper$InAppWebViewListener;", "makePostData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "InAppWebViewSchemeHandler", "InAppWebViewChromeClient", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InAppWebView {
    private final Activity activity;
    private final PlatformHelper.InAppWebViewParam param;
    private ResultAPI resultApi;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0014\u0010\b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/hive/platformhelper/InAppWebView$InAppWebViewChromeClient;", "Landroid/webkit/WebChromeClient;", "<init>", "()V", "onShowFileChooser", "", "webView", "Landroid/webkit/WebView;", "filePathCallback", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "fileChooserParams", "Landroid/webkit/WebChromeClient$FileChooserParams;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InAppWebViewChromeClient extends WebChromeClient {
        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, final ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            LoggerImpl.INSTANCE.i("[InAppWebViewChromeClient] Call InAppWebViewChromeClient.onShowFileChooser()");
            HivePicture.INSTANCE.getPictureFromChooser(new HivePicture.ChooserResultListener() { // from class: com.hive.platformhelper.InAppWebView$InAppWebViewChromeClient$onShowFileChooser$1
                @Override // com.hive.base.HivePicture.ChooserResultListener
                public void onChooserResult(ResultAPI result, Uri uri) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    LoggerImpl.INSTANCE.i("[InAppWebViewChromeClient] HivePicture.onChooserResult()\nResultAPI: " + result + " Uri: " + uri);
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

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/hive/platformhelper/InAppWebView$InAppWebViewSchemeHandler;", "Lcom/hive/webview/HiveSchemeHandler;", "<init>", "()V", "schemeEvent", "", "view", "Landroid/webkit/WebView;", "scheme", "Lcom/hive/core/Scheme;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InAppWebViewSchemeHandler extends HiveSchemeHandler {
        @Override // com.hive.webview.HiveSchemeHandler
        public boolean schemeEvent(WebView view, Scheme scheme) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.d("[InAppWebViewClient] schemeEvent: " + scheme);
            if (!Intrinsics.areEqual(scheme.getScheme(), "hivesocial") || !Intrinsics.areEqual(scheme.getHost(), "sharesns")) {
                return super.schemeEvent(view, scheme);
            }
            loggerImpl.d("[InAppWebViewClient] schemeEvent handle \"sharesns\"");
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
                    LoggerImpl.INSTANCE.d("[InAppWebViewClient] schemeEvent handle \"sharesns\"\n exception: " + e.getMessage());
                }
            } else {
                loggerImpl.d("[InAppWebViewClient] schemeEvent handle url is null");
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
            hivePromotion.showUAShare(str, strDecode, false, new Promotion.PromotionShareListener() { // from class: com.hive.platformhelper.InAppWebView$InAppWebViewSchemeHandler$schemeEvent$1
                @Override // com.hive.Promotion.PromotionShareListener
                public void onPromotionShare(ResultAPI result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    LoggerImpl.INSTANCE.d("[InAppWebViewClient] schemeEvent showUAShare(result: " + result + ')');
                }
            });
            return true;
        }
    }

    /* JADX INFO: renamed from: com.hive.platformhelper.InAppWebView$makePostData$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.platformhelper.InAppWebView", f = "InAppWebView.kt", i = {0}, l = {89}, m = "makePostData", n = {"postData"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppWebView.this.makePostData(this);
        }
    }

    /* JADX INFO: renamed from: com.hive.platformhelper.InAppWebView$makePostData$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.platformhelper.InAppWebView$makePostData$2", f = "InAppWebView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<String> $postData;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Ref.ObjectRef<String> objectRef, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$postData = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return InAppWebView.this.new AnonymousClass2(this.$postData, continuation);
        }

        /* JADX WARN: Type inference failed for: r0v11, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r7v24, types: [T, java.lang.Object, java.lang.String] */
        /* JADX WARN: Type inference failed for: r7v33, types: [T, java.lang.Object, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM7415constructorimpl;
            Object objM7415constructorimpl2;
            String accessToken;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (HiveWebView.INSTANCE.isWhitelistDomain(InAppWebView.this.getParam().getUrl()) && InAppWebView.this.getParam().getUseUserSession()) {
                JSONObject jSONObjectPutCI = CommonIdentifierKt.putCI(new JSONObject());
                HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
                String did = hiveLifecycle.getDid();
                HiveLifecycle.HiveAccount account = hiveLifecycle.getAccount();
                OauthToken oauthToken = account.getOauthToken();
                if (oauthToken != null && oauthToken.isExpire(1800)) {
                    oauthToken.refresh();
                }
                try {
                    Result.Companion companion = Result.INSTANCE;
                    HiveKeys hiveKeys = HiveKeys.KEY_appid;
                    ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
                    CommonIdentifierKt.put(jSONObjectPutCI, hiveKeys, configurationImpl.getAppId());
                    CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_did, did);
                    CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_sdk_version, "4.26.2.0");
                    HiveKeys hiveKeys2 = HiveKeys.KEY_os_version;
                    Android android2 = Android.INSTANCE;
                    CommonIdentifierKt.put(jSONObjectPutCI, hiveKeys2, android2.getOSVersion());
                    CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_os_api_level, String.valueOf(android2.getOSVersionCode()));
                    CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
                    CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_device_model, android2.getDeviceModel());
                    CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_country, android2.getCountry());
                    CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_game_language, configurationImpl.getHiveLanguage());
                    CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_player_id, account.getVid());
                    CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_player_token, account.getVidSession());
                    OauthToken oauthToken2 = account.getOauthToken();
                    objM7415constructorimpl2 = Result.m7415constructorimpl((oauthToken2 == null || (accessToken = oauthToken2.getAccessToken()) == null) ? null : CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_X_Access_Token, accessToken));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7415constructorimpl2 = Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
                InAppWebView inAppWebView = InAppWebView.this;
                Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl2);
                if (thM7418exceptionOrNullimpl != null) {
                    LoggerImpl.INSTANCE.w("InAppWebView() useUserSession Invalid post data. " + thM7418exceptionOrNullimpl);
                    inAppWebView.resultApi = new ResultAPI(-1, ResultAPI.Code.SocialInvalidParam);
                }
                Ref.ObjectRef<String> objectRef = this.$postData;
                ?? string = jSONObjectPutCI.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                objectRef.element = string;
            } else {
                CookieManager.INSTANCE.removeCookie(InAppWebView.this.getParam().getUrl());
                WebStorage.getInstance().deleteAllData();
            }
            if (InAppWebView.this.getParam().getPostData() != null && (!StringsKt.isBlank(r7))) {
                if (StringsKt.isBlank(this.$postData.element)) {
                    this.$postData.element = InAppWebView.this.getParam().getPostData();
                } else {
                    InAppWebView inAppWebView2 = InAppWebView.this;
                    Ref.ObjectRef<String> objectRef2 = this.$postData;
                    try {
                        Result.Companion companion3 = Result.INSTANCE;
                        JSONObject jSONObject = new JSONObject(inAppWebView2.getParam().getPostData());
                        JSONObject jSONObject2 = new JSONObject(objectRef2.element);
                        Iterator<String> itKeys = jSONObject.keys();
                        Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            jSONObject2.put(next, jSONObject.get(next));
                        }
                        ?? string2 = jSONObject2.toString();
                        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                        objectRef2.element = string2;
                        objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.INSTANCE;
                        objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th2));
                    }
                    Throwable thM7418exceptionOrNullimpl2 = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
                    if (thM7418exceptionOrNullimpl2 != null) {
                        LoggerImpl.INSTANCE.w("InAppWebView() param.PostData Invalid post data. " + thM7418exceptionOrNullimpl2);
                    }
                    Result.m7414boximpl(objM7415constructorimpl);
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.hive.platformhelper.InAppWebView$show$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.platformhelper.InAppWebView$show$1", f = "InAppWebView.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
    public static final class C29321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PlatformHelper.InAppWebViewListener $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29321(PlatformHelper.InAppWebViewListener inAppWebViewListener, Continuation<? super C29321> continuation) {
            super(2, continuation);
            this.$listener = inAppWebViewListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return InAppWebView.this.new C29321(this.$listener, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                InAppWebView inAppWebView = InAppWebView.this;
                this.label = 1;
                obj = inAppWebView.makePostData(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            String str = (String) obj;
            InAppWebViewSchemeHandler inAppWebViewSchemeHandler = new InAppWebViewSchemeHandler();
            InAppWebViewChromeClient inAppWebViewChromeClient = new InAppWebViewChromeClient();
            final InAppWebView$show$1$onClosedListener$1 inAppWebView$show$1$onClosedListener$1 = new InAppWebView$show$1$onClosedListener$1(this.$listener);
            HiveFullscreenViewData hiveFullscreenViewData = new HiveFullscreenViewData(InAppWebView.this.getParam().getUrl(), str, null, inAppWebViewSchemeHandler, inAppWebViewChromeClient);
            if (InAppWebView.this.getParam().getUseGameWindow()) {
                InAppWebViewDialog inAppWebViewDialog = new InAppWebViewDialog(InAppWebView.this.getActivity(), hiveFullscreenViewData);
                inAppWebViewDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.hive.platformhelper.InAppWebView$show$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        inAppWebView$show$1$onClosedListener$1.onClosed();
                    }
                });
                inAppWebViewDialog.show();
            } else {
                new HiveUi(InAppWebView.this.getActivity(), hiveFullscreenViewData).addOnClosedListener(inAppWebView$show$1$onClosedListener$1).show();
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29321) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public InAppWebView(Activity activity, PlatformHelper.InAppWebViewParam param) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(param, "param");
        this.activity = activity;
        this.param = param;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object makePostData(kotlin.coroutines.Continuation<? super java.lang.String> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.hive.platformhelper.InAppWebView.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.hive.platformhelper.InAppWebView$makePostData$1 r0 = (com.hive.platformhelper.InAppWebView.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.hive.platformhelper.InAppWebView$makePostData$1 r0 = new com.hive.platformhelper.InAppWebView$makePostData$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L57
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L35:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            java.lang.String r2 = ""
            r7.element = r2
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            com.hive.platformhelper.InAppWebView$makePostData$2 r4 = new com.hive.platformhelper.InAppWebView$makePostData$2
            r5 = 0
            r4.<init>(r7, r5)
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r0)
            if (r0 != r1) goto L56
            return r1
        L56:
            r0 = r7
        L57:
            T r7 = r0.element
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.platformhelper.InAppWebView.makePostData(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final PlatformHelper.InAppWebViewParam getParam() {
        return this.param;
    }

    public final void show(PlatformHelper.InAppWebViewListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("InAppWebView show()");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C29321(listener, null), 3, null);
    }
}
