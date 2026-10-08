package com.hive.core.webview;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.hive.core.Logger;
import com.hive.core.OauthToken;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: HiveWebView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010!\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0017R\u001e\u0010\f\u001a\u00060\rR\u00020\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lcom/hive/core/webview/HiveWebView;", "Landroid/webkit/WebView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "requestOptions", "Lcom/hive/core/webview/HiveWebView$RequestOptions;", "getRequestOptions", "()Lcom/hive/core/webview/HiveWebView$RequestOptions;", "setRequestOptions", "(Lcom/hive/core/webview/HiveWebView$RequestOptions;)V", "oauthToken", "Lcom/hive/core/OauthToken;", "getOauthToken", "()Lcom/hive/core/OauthToken;", "setOauthToken", "(Lcom/hive/core/OauthToken;)V", "setInitialScaleWhenDifferentDensity", "", "postUrl", "url", "", "postData", "", "loadUrl", "loadUrlCI", "postUrlCI", "blacklistDomain", "b", "", k.M, "RequestOptions", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class HiveWebView extends WebView {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private OauthToken oauthToken;
    private RequestOptions requestOptions;

    /* JADX INFO: compiled from: HiveWebView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/hive/core/webview/HiveWebView$Companion;", "", "<init>", "()V", "isWhitelistDomain", "", "inputUrl", "", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x00dd A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:63:0x00f7 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean isWhitelistDomain(java.lang.String r12) {
            /*
                Method dump skipped, instruction units count: 299
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.core.webview.HiveWebView.Companion.isWhitelistDomain(java.lang.String):boolean");
        }
    }

    public final RequestOptions getRequestOptions() {
        return this.requestOptions;
    }

    public final void setRequestOptions(RequestOptions requestOptions) {
        Intrinsics.checkNotNullParameter(requestOptions, "<set-?>");
        this.requestOptions = requestOptions;
    }

    public final OauthToken getOauthToken() {
        return this.oauthToken;
    }

    public final void setOauthToken(OauthToken oauthToken) {
        this.oauthToken = oauthToken;
    }

    private final void setInitialScaleWhenDifferentDensity() {
        Object objM7415constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            float f = getContext().getResources().getDisplayMetrics().density;
            int i = getContext().getResources().getDisplayMetrics().densityDpi;
            if (Math.abs(f - getScale()) > 1.0E-4f) {
                getSettings().setLoadWithOverviewMode(false);
                getSettings().setUseWideViewPort(false);
                setInitialScale((int) ((i / 160.0f) * 100));
            }
            objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Logger.INSTANCE.w("[HiveWebView] Failed setWebViewScale.\nmessage: " + thM7418exceptionOrNullimpl.getMessage());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiveWebView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.requestOptions = new RequestOptions(this, false, 1, null);
        this.oauthToken = OauthToken.INSTANCE.getCurrentOauthToken();
        getSettings().setCacheMode(-1);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setUseWideViewPort(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setDefaultTextEncodingName(Charsets.UTF_8.name());
        getSettings().setTextZoom(100);
        setInitialScaleWhenDifferentDensity();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiveWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.requestOptions = new RequestOptions(this, false, 1, null);
        this.oauthToken = OauthToken.INSTANCE.getCurrentOauthToken();
        getSettings().setCacheMode(-1);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setUseWideViewPort(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setDefaultTextEncodingName(Charsets.UTF_8.name());
        getSettings().setTextZoom(100);
        setInitialScaleWhenDifferentDensity();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiveWebView(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.requestOptions = new RequestOptions(this, false, 1, null);
        this.oauthToken = OauthToken.INSTANCE.getCurrentOauthToken();
        getSettings().setCacheMode(-1);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setUseWideViewPort(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setDefaultTextEncodingName(Charsets.UTF_8.name());
        getSettings().setTextZoom(100);
        setInitialScaleWhenDifferentDensity();
    }

    @Override // android.webkit.WebView
    public void postUrl(String url, byte[] postData) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(postData, "postData");
        Logger.INSTANCE.d("[HiveWebView - POST] url: " + url + "\ndata: " + new String(postData, Charsets.UTF_8));
        boolean zIsWhitelistDomain = INSTANCE.isWhitelistDomain(url);
        blacklistDomain(zIsWhitelistDomain ^ true);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C29031(postData, this, zIsWhitelistDomain, url, null), 3, null);
    }

    /* JADX INFO: renamed from: com.hive.core.webview.HiveWebView$postUrl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HiveWebView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.core.webview.HiveWebView$postUrl$1", f = "HiveWebView.kt", i = {0}, l = {168, ModuleDescriptor.MODULE_VERSION}, m = "invokeSuspend", n = {"requestJson"}, s = {"L$0"})
    static final class C29031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isWhitelistDomain;
        final /* synthetic */ byte[] $postData;
        final /* synthetic */ String $url;
        Object L$0;
        boolean Z$0;
        int label;
        final /* synthetic */ HiveWebView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29031(byte[] bArr, HiveWebView hiveWebView, boolean z, String str, Continuation<? super C29031> continuation) {
            super(2, continuation);
            this.$postData = bArr;
            this.this$0 = hiveWebView;
            this.$isWhitelistDomain = z;
            this.$url = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29031(this.$postData, this.this$0, this.$isWhitelistDomain, this.$url, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29031) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00e4 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 232
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.core.webview.HiveWebView.C29031.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.hive.core.webview.HiveWebView$postUrl$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: HiveWebView.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.core.webview.HiveWebView$postUrl$1$1", f = "HiveWebView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C03551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ byte[] $requestPostData;
            final /* synthetic */ String $url;
            int label;
            final /* synthetic */ HiveWebView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03551(HiveWebView hiveWebView, String str, byte[] bArr, Continuation<? super C03551> continuation) {
                super(2, continuation);
                this.this$0 = hiveWebView;
                this.$url = str;
                this.$requestPostData = bArr;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C03551(this.this$0, this.$url, this.$requestPostData, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C03551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    HiveWebView.super.postUrl(this.$url, this.$requestPostData);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebView
    public void loadUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Logger.INSTANCE.d("[HiveWebView - GET] " + url);
        boolean zIsWhitelistDomain = INSTANCE.isWhitelistDomain(url);
        blacklistDomain(zIsWhitelistDomain ^ true);
        Uri uri = Uri.parse(url);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = url;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnonymousClass1(uri, objectRef, zIsWhitelistDomain, new LinkedHashMap(), null), 3, null);
    }

    /* JADX INFO: renamed from: com.hive.core.webview.HiveWebView$loadUrl$1, reason: invalid class name */
    /* JADX INFO: compiled from: HiveWebView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.core.webview.HiveWebView$loadUrl$1", f = "HiveWebView.kt", i = {}, l = {213, 226}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $additionalHttpHeaders;
        final /* synthetic */ boolean $isWhitelistDomain;
        final /* synthetic */ Ref.ObjectRef<String> $loadUrl;
        final /* synthetic */ Uri $uri;
        Object L$0;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Uri uri, Ref.ObjectRef<String> objectRef, boolean z, Map<String, String> map, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$uri = uri;
            this.$loadUrl = objectRef;
            this.$isWhitelistDomain = z;
            this.$additionalHttpHeaders = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HiveWebView.this.new AnonymousClass1(this.$uri, this.$loadUrl, this.$isWhitelistDomain, this.$additionalHttpHeaders, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x00c9  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00fc A[RETURN] */
        /* JADX WARN: Type inference failed for: r1v11, types: [T, java.lang.Object, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 256
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.core.webview.HiveWebView.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.hive.core.webview.HiveWebView$loadUrl$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: HiveWebView.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.core.webview.HiveWebView$loadUrl$1$3", f = "HiveWebView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Map<String, String> $additionalHttpHeaders;
            final /* synthetic */ Ref.ObjectRef<String> $loadUrl;
            int label;
            final /* synthetic */ HiveWebView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(Map<String, String> map, HiveWebView hiveWebView, Ref.ObjectRef<String> objectRef, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$additionalHttpHeaders = map;
                this.this$0 = hiveWebView;
                this.$loadUrl = objectRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.$additionalHttpHeaders, this.this$0, this.$loadUrl, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (this.$additionalHttpHeaders.isEmpty()) {
                    HiveWebView.super.loadUrl(this.$loadUrl.element);
                } else {
                    HiveWebView.super.loadUrl(this.$loadUrl.element, this.$additionalHttpHeaders);
                }
                return Unit.INSTANCE;
            }
        }
    }

    public void loadUrlCI(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        postUrlCI(url, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0019 A[Catch: Exception -> 0x0038, TryCatch #0 {Exception -> 0x0038, blocks: (B:4:0x0007, B:7:0x0022, B:6:0x0019), top: B:15:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void postUrlCI(java.lang.String r4, byte[] r5) {
        /*
            r3 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            if (r5 == 0) goto L19
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L38
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Exception -> L38
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8     // Catch: java.lang.Exception -> L38
            r1.<init>(r5, r2)     // Catch: java.lang.Exception -> L38
            r0.<init>(r1)     // Catch: java.lang.Exception -> L38
            org.json.JSONObject r0 = com.hive.core.CommonIdentifierKt.putCI(r0)     // Catch: java.lang.Exception -> L38
            if (r0 != 0) goto L22
        L19:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L38
            r0.<init>()     // Catch: java.lang.Exception -> L38
            org.json.JSONObject r0 = com.hive.core.CommonIdentifierKt.putCI(r0)     // Catch: java.lang.Exception -> L38
        L22:
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L38
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Exception -> L38
            java.nio.charset.Charset r1 = kotlin.text.Charsets.UTF_8     // Catch: java.lang.Exception -> L38
            byte[] r0 = r0.getBytes(r1)     // Catch: java.lang.Exception -> L38
            java.lang.String r1 = "getBytes(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Exception -> L38
            r5 = r0
            goto L42
        L38:
            r0 = move-exception
            com.hive.core.Logger r1 = com.hive.core.Logger.INSTANCE
            java.lang.String r0 = r0.toString()
            r1.w(r0)
        L42:
            if (r5 == 0) goto L48
            r3.postUrl(r4, r5)
            goto L4b
        L48:
            r3.loadUrl(r4)
        L4b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.core.webview.HiveWebView.postUrlCI(java.lang.String, byte[]):void");
    }

    public void blacklistDomain(boolean b) {
        Logger.INSTANCE.w("[HiveWebView - blacklistDomain(" + b + ')');
        boolean javaScriptEnabled = getSettings().getJavaScriptEnabled();
        if (b) {
            getSettings().setJavaScriptEnabled(false);
            getSettings().setMixedContentMode(1);
            return;
        }
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMixedContentMode(0);
        if (javaScriptEnabled) {
            return;
        }
        reload();
    }

    /* JADX INFO: compiled from: HiveWebView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/hive/core/webview/HiveWebView$RequestOptions;", "", "supportHiveTheme", "", "<init>", "(Lcom/hive/core/webview/HiveWebView;Z)V", "getSupportHiveTheme", "()Z", "setSupportHiveTheme", "(Z)V", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class RequestOptions {
        private boolean supportHiveTheme;

        public RequestOptions(boolean z) {
            this.supportHiveTheme = z;
        }

        public /* synthetic */ RequestOptions(HiveWebView hiveWebView, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z);
        }

        public final boolean getSupportHiveTheme() {
            return this.supportHiveTheme;
        }

        public final void setSupportHiveTheme(boolean z) {
            this.supportHiveTheme = z;
        }
    }
}
