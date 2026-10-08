package com.hive.authv4.provider.applesignin;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.authv4.provider.applesignin.HiveModuleAppleSignIn;
import com.hive.configuration.ConfigurationImpl;
import com.hive.logger.LoggerImpl;
import com.hive.module.ModuleCheckName;
import com.hive.module.interfaces.authv4.provider.ProviderAppleSignIn;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: HiveModuleAppleSignIn.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0002JL\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142:\u0010\u0015\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00120\u0016H\u0016J \u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0002J\u0014\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050#H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b¨\u0006$"}, d2 = {"Lcom/hive/authv4/provider/applesignin/HiveModuleAppleSignIn;", "Lcom/hive/module/interfaces/authv4/provider/ProviderAppleSignIn;", "<init>", "()V", "keyAppleSignInServiceId", "", "appleSignInServiceId", "getAppleSignInServiceId", "()Ljava/lang/String;", "appleSignInServiceId$delegate", "Lkotlin/Lazy;", "redirectScheme", "redirectHost", "appleSignInUrlDefinedRedirectUri", "getAppleSignInUrlDefinedRedirectUri", "getProviderFromHiveConfig", "Lorg/json/JSONObject;", "login", "", "activity", "Landroid/app/Activity;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "authorizationCode", "message", "getAuthorizeUrl", "clientId", "redirectUrl", "state", "convertBlackNWhite", "Landroid/graphics/Bitmap;", "bitmap", "getVersionInfo", "", "hive-authv4-provider-apple-signin_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveModuleAppleSignIn implements ProviderAppleSignIn {
    private final String keyAppleSignInServiceId = "@serviceid";

    /* JADX INFO: renamed from: appleSignInServiceId$delegate, reason: from kotlin metadata */
    private final Lazy appleSignInServiceId = LazyKt.lazy(new Function0() { // from class: com.hive.authv4.provider.applesignin.HiveModuleAppleSignIn$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return HiveModuleAppleSignIn.appleSignInServiceId_delegate$lambda$0(this.f$0);
        }
    });
    private final String redirectScheme = "https";
    private final String redirectHost = "www.withhive.com";
    private final String appleSignInUrlDefinedRedirectUri = "https://www.withhive.com";

    @Override // com.hive.module.interfaces.authv4.provider.ProviderAppleSignIn, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return ProviderAppleSignIn.DefaultImpls.getHiveModuleName(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String appleSignInServiceId_delegate$lambda$0(HiveModuleAppleSignIn hiveModuleAppleSignIn) {
        return hiveModuleAppleSignIn.getProviderFromHiveConfig().optString(hiveModuleAppleSignIn.keyAppleSignInServiceId, "");
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderAppleSignIn
    public String getAppleSignInServiceId() {
        Object value = this.appleSignInServiceId.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (String) value;
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderAppleSignIn
    public String getAppleSignInUrlDefinedRedirectUri() {
        return this.appleSignInUrlDefinedRedirectUri;
    }

    private final JSONObject getProviderFromHiveConfig() {
        return ConfigurationImpl.INSTANCE.getProviderFromHiveConfig("signinwithapple");
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderAppleSignIn
    public void login(Activity activity, Function2<? super String, ? super String, Unit> listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (StringsKt.isBlank(getAppleSignInServiceId())) {
            LoggerImpl.INSTANCE.w("[HiveModuleAppleSignIn] Provider AppleSignIn 'serviceid' is empty.");
            listener.invoke(null, "Provider AppleSignIn 'serviceid' is empty.");
        } else {
            Intent intent = new Intent();
            intent.putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, true);
            HiveUiActivity.INSTANCE.launch(activity, intent, new AnonymousClass1(listener));
        }
    }

    /* JADX INFO: renamed from: com.hive.authv4.provider.applesignin.HiveModuleAppleSignIn$login$1, reason: invalid class name */
    /* JADX INFO: compiled from: HiveModuleAppleSignIn.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0017J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"com/hive/authv4/provider/applesignin/HiveModuleAppleSignIn$login$1", "Lcom/hive/ui/OnActivityLifecycle;", "state", "", "authorizationCode", "getAuthorizationCode", "()Ljava/lang/String;", "setAuthorizationCode", "(Ljava/lang/String;)V", "onCreate", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "hive-authv4-provider-apple-signin_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 extends OnActivityLifecycle {
        final /* synthetic */ Function2<String, String, Unit> $listener;
        private String authorizationCode;
        private final String state;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function2<? super String, ? super String, Unit> function2) {
            this.$listener = function2;
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            String strSubstring = string.substring(0, 7);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            this.state = strSubstring;
            this.authorizationCode = "";
        }

        public final String getAuthorizationCode() {
            return this.authorizationCode;
        }

        public final void setAuthorizationCode(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.authorizationCode = str;
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onCreate(final Activity activity, Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Activity activity2 = activity;
            ImageView imageView = new ImageView(activity2);
            HiveModuleAppleSignIn hiveModuleAppleSignIn = HiveModuleAppleSignIn.this;
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(activity.getResources(), android.R.drawable.ic_menu_close_clear_cancel);
            Intrinsics.checkNotNullExpressionValue(bitmapDecodeResource, "decodeResource(...)");
            imageView.setImageBitmap(hiveModuleAppleSignIn.convertBlackNWhite(bitmapDecodeResource));
            imageView.setPadding(20, 20, 20, 20);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.hive.authv4.provider.applesignin.HiveModuleAppleSignIn$login$1$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    activity.finish();
                }
            });
            LinearLayout linearLayout = new LinearLayout(activity2);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            linearLayout.setGravity(GravityCompat.END);
            linearLayout.setBackgroundColor(-1);
            linearLayout.addView(imageView);
            WebView webView = new WebView(activity2);
            final HiveModuleAppleSignIn hiveModuleAppleSignIn2 = HiveModuleAppleSignIn.this;
            webView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setDomStorageEnabled(true);
            webView.setWebChromeClient(new WebChromeClient());
            webView.setWebViewClient(new WebViewClient() { // from class: com.hive.authv4.provider.applesignin.HiveModuleAppleSignIn$login$1$onCreate$webView$1$1
                @Override // android.webkit.WebViewClient
                @Deprecated(message = "Deprecated in Java")
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    if (url == null) {
                        return false;
                    }
                    Uri uri = Uri.parse(url);
                    Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
                    return handleRedirectUrlIfValid(uri);
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    Uri url;
                    if (request == null || (url = request.getUrl()) == null) {
                        return false;
                    }
                    return handleRedirectUrlIfValid(url);
                }

                private final boolean handleRedirectUrlIfValid(Uri uri) {
                    LoggerImpl.INSTANCE.dL("[HiveModuleAppleSignIn] shouldOverrideUrlLoading: " + uri);
                    Uri uri2 = Uri.parse(hiveModuleAppleSignIn2.getAppleSignInUrlDefinedRedirectUri());
                    if (Intrinsics.areEqual(uri.getScheme(), uri2.getScheme()) && Intrinsics.areEqual(uri.getHost(), uri2.getHost()) && Intrinsics.areEqual(this.state, uri.getQueryParameter("state"))) {
                        LoggerImpl.INSTANCE.dL("[HiveModuleAppleSignIn] handleRedirectUrl: " + uri);
                        HiveModuleAppleSignIn.AnonymousClass1 anonymousClass1 = this;
                        Activity activity3 = activity;
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            String queryParameter = uri.getQueryParameter("code");
                            if (queryParameter == null) {
                                queryParameter = "";
                            }
                            anonymousClass1.setAuthorizationCode(queryParameter);
                            activity3.finish();
                            return true;
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.INSTANCE;
                            Result.m7418exceptionOrNullimpl(Result.m7415constructorimpl(ResultKt.createFailure(th)));
                        }
                    }
                    return false;
                }
            });
            webView.loadUrl(hiveModuleAppleSignIn2.getAuthorizeUrl(hiveModuleAppleSignIn2.getAppleSignInServiceId(), hiveModuleAppleSignIn2.getAppleSignInUrlDefinedRedirectUri(), this.state));
            LinearLayout linearLayout2 = new LinearLayout(activity2);
            linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            linearLayout2.setOrientation(1);
            linearLayout2.addView(linearLayout);
            linearLayout2.addView(webView);
            activity.setContentView(linearLayout2);
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onDestroy(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (getIsCalledFinish() && (!StringsKt.isBlank(this.authorizationCode))) {
                this.$listener.invoke(this.authorizationCode, "success.");
            } else {
                this.$listener.invoke(null, "Apple Sign-In canceled due to other error.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getAuthorizeUrl(String clientId, String redirectUrl, String state) {
        Object objM7415constructorimpl;
        LoggerImpl.INSTANCE.d("[HiveModuleAppleSignIn] getAuthorizeUrl");
        try {
            Result.Companion companion = Result.INSTANCE;
            HiveModuleAppleSignIn hiveModuleAppleSignIn = this;
            byte[] bArr = new byte[8];
            new SecureRandom().nextBytes(bArr);
            objM7415constructorimpl = Result.m7415constructorimpl(Base64.encodeToString(bArr, 11));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        StringBuilder sb = new StringBuilder("https://appleid.apple.com/auth/authorize?client_id=");
        sb.append(clientId);
        sb.append("&nonce=");
        sb.append((Object) Result.m7423toStringimpl(objM7415constructorimpl));
        sb.append("&redirect_uri=");
        sb.append(URLEncoder.encode(redirectUrl, "UTF-8"));
        sb.append("&response_mode=query&response_type=code");
        String str = "&state=" + state;
        LoggerImpl.INSTANCE.d("[HiveModuleAppleSignIn] AuthorizeUrl: " + str);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap convertBlackNWhite(Bitmap bitmap) {
        Bitmap bitmapCopy = bitmap.isMutable() ? bitmap : bitmap.copy(Bitmap.Config.ARGB_8888, true);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        for (int i = 0; i < width; i++) {
            for (int i2 = 0; i2 < height; i2++) {
                int pixel = bitmapCopy.getPixel(i, i2);
                int iAlpha = Color.alpha(pixel);
                int i3 = 255;
                int i4 = ((int) (((((double) Color.red(pixel)) * 0.2999d) + (((double) Color.green(pixel)) * 0.587d)) + (((double) Color.blue(pixel)) * 0.114d))) < 128 ? 255 : 0;
                int i5 = iAlpha + 200;
                if (i5 <= 255) {
                    i3 = i5;
                }
                bitmapCopy.setPixel(i, i2, Color.argb(i3, i4, i4, i4));
            }
        }
        Intrinsics.checkNotNull(bitmapCopy);
        return bitmapCopy;
    }

    @Override // com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        HashMap map = new HashMap();
        map.put(ModuleCheckName.INSTANCE.getHive_Authv4_Apple_Signin(), "26.2.0");
        return map;
    }
}
