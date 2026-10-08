package com.hive.social;

import android.R;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ConsoleMessage;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.adjust.sdk.Constants;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.IAPV4;
import com.hive.ResultAPI;
import com.hive.SocialHive;
import com.hive.SocialV4;
import com.hive.base.Android;
import com.hive.base.HivePicture;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.Crypto;
import com.hive.core.ExtentionsKt;
import com.hive.core.HiveKeys;
import com.hive.core.webview.HiveWebView;
import com.hive.core.webview.HiveWebViewClient;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.HiveIapV4;
import com.hive.module.interfaces.HiveUserEngagement;
import com.hive.module.interfaces.iapv4.market.MarketLebi;
import com.hive.protocol.UrlManager;
import com.hive.social.CheckNamePopupDialog;
import com.hive.social.SocialKeys;
import com.hive.socialv4.provider.SocialV4ProviderAdapter;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import com.hive.ui.Resource;
import com.hive.ui.effect.ColorAnimation;
import com.hive.webview.HiveSchemeHandler;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.io.files.FileSystemKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 `2\u00020\u0001:\u0004]^_`B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\fB3\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\u000eB=\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\u0012J\b\u0010+\u001a\u00020,H\u0002J\u0018\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\u0006\u00102\u001a\u00020\u0005J\u0010\u00103\u001a\u00020,2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001a\u00103\u001a\u00020,2\u0006\u0010\n\u001a\u00020\u000b2\b\u00104\u001a\u0004\u0018\u00010&H\u0002J\u001a\u00105\u001a\u00020,2\u0006\u00106\u001a\u00020&2\b\u00104\u001a\u0004\u0018\u00010&H\u0002J\u0010\u00107\u001a\u00020,2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0006\u00108\u001a\u00020,J\u0010\u00108\u001a\u00020,2\b\u00104\u001a\u0004\u0018\u00010&J\b\u00109\u001a\u00020,H\u0002J\u0012\u00109\u001a\u00020,2\b\u00104\u001a\u0004\u0018\u00010&H\u0002J\b\u0010:\u001a\u00020,H\u0002J\u0006\u0010;\u001a\u00020,J\u0018\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020\u0005H\u0002J\b\u0010?\u001a\u00020,H\u0002J\u0010\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020&H\u0002J\u0010\u0010B\u001a\u00020,2\u0006\u0010A\u001a\u00020&H\u0002J\u0010\u0010C\u001a\u00020,2\u0006\u0010A\u001a\u00020&H\u0003J\u0010\u0010D\u001a\u00020,2\u0006\u0010A\u001a\u00020&H\u0002J\u0010\u0010E\u001a\u00020,2\u0006\u0010A\u001a\u00020&H\u0002J\u0010\u0010F\u001a\u00020,2\u0006\u0010A\u001a\u00020&H\u0002J\u0010\u0010G\u001a\u00020,2\u0006\u0010A\u001a\u00020&H\u0002J \u0010H\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020&H\u0002J\b\u0010J\u001a\u00020,H\u0002J\u0010\u0010K\u001a\u00020,2\u0006\u0010A\u001a\u00020&H\u0002J\u0010\u0010L\u001a\u00020,2\u0006\u0010A\u001a\u00020&H\u0002J\u0010\u0010M\u001a\u00020,2\u0006\u0010A\u001a\u00020&H\u0002J\u0010\u0010N\u001a\u00020,2\u0006\u0010A\u001a\u00020&H\u0002J\u0010\u0010O\u001a\u00020,2\u0006\u0010A\u001a\u00020&H\u0002J\u0010\u0010P\u001a\u00020,2\u0006\u0010A\u001a\u00020&H\u0002J\u0010\u0010Q\u001a\u00020,2\u0006\u0010A\u001a\u00020&H\u0002J\u0010\u0010R\u001a\u00020,2\u0006\u0010A\u001a\u00020&H\u0002J\u0010\u0010S\u001a\u00020,2\u0006\u0010T\u001a\u00020&H\u0002J\u0010\u0010U\u001a\u00020\u00052\u0006\u0010V\u001a\u00020\u000bH\u0002J\u0010\u0010W\u001a\u00020,2\u0006\u0010A\u001a\u00020&H\u0002J\u0012\u0010X\u001a\u00020,2\b\u0010Y\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u00020\u000bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Lcom/hive/social/SocialDialog;", "", "activity", "Landroid/app/Activity;", "shouldShow", "", "closeHandler", "Lcom/hive/SocialHive$ShowHiveDialogDataListener;", "<init>", "(Landroid/app/Activity;ZLcom/hive/SocialHive$ShowHiveDialogDataListener;)V", "url", "", "(Landroid/app/Activity;Ljava/lang/String;ZLcom/hive/SocialHive$ShowHiveDialogDataListener;)V", "isClear", "(Landroid/app/Activity;Ljava/lang/String;ZZLcom/hive/SocialHive$ShowHiveDialogDataListener;)V", "hiveDialogType", "Lcom/hive/SocialHive$HiveDialogType;", "additionalInfo", "(Landroid/app/Activity;Ljava/lang/String;Lcom/hive/SocialHive$HiveDialogType;Ljava/lang/String;ZLcom/hive/SocialHive$ShowHiveDialogDataListener;)V", "getActivity", "()Landroid/app/Activity;", "socialRootView", "Landroid/widget/LinearLayout;", "topLayout", "Landroid/widget/RelativeLayout;", "bottomLayout", "spinner", "Landroid/widget/ProgressBar;", "webView", "Lcom/hive/core/webview/HiveWebView;", "closeButtonText", "Landroid/widget/TextView;", "closeButton", "Landroid/widget/ImageView;", "closeButtonTextAnimation", "Lcom/hive/ui/effect/ColorAnimation;", "closeButtonAnimation", "closeParam", "Lorg/json/JSONObject;", "isDismissing", "originOrientation", "", "codeVerifier", "setTransparentUI", "", "onCloseButtonTouch", "event", "Landroid/view/MotionEvent;", "delayMillis", "", "onBackPressed", "loadUrlCI", "hiveOptionalData", "processHiveOptionalData", "json", "loadUrl", "show", "internalShow", "showWebView", "dismiss", "setTopBarSize", ContentDisposition.Parameters.Size, "isText", "updateNativeTopBar", "handleLaunchAppScheme", NativeProtocol.WEB_DIALOG_PARAMS, "handleSendSMSScheme", "handleLoginScheme", "handleLogoutScheme", "handleCloseScheme", "handleOpenBrowserScheme", "handleGetPictureScheme", "handleLinkDownload", "path", "handleCallAppSetting", "handleSocialIsAuthorizedScheme", "handleSocialLogoutScheme", "handleSocialRequestUserTokenScheme", "handleSocialRequestUserProfileScheme", "handleSocialRequestFriendsScheme", "handleGuestAcquireUidScheme", "handleGuestBindScheme", "handleGuestRequestLoginScheme", "handleSocialRequestCheckRealNameScheme", "optionJsonData", "checkApplicationInstalled", "packageName", "checkServerToast", "showToast", "message", "getSocialV4ProviderType", "Lcom/hive/SocialV4$ProviderType;", "serviceName", "DummyView", "SocialWebSchemeHandler", "SocialWebViewClient", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SocialDialog {
    private final Activity activity;
    private String additionalInfo;
    private RelativeLayout bottomLayout;
    private ImageView closeButton;
    private ColorAnimation closeButtonAnimation;
    private TextView closeButtonText;
    private ColorAnimation closeButtonTextAnimation;
    private final SocialHive.ShowHiveDialogDataListener closeHandler;
    private JSONObject closeParam;
    private String codeVerifier;
    private SocialHive.HiveDialogType hiveDialogType;
    private boolean isClear;
    private boolean isDismissing;
    private int originOrientation;
    private final boolean shouldShow;
    private LinearLayout socialRootView;
    private ProgressBar spinner;
    private RelativeLayout topLayout;
    private String url;
    private HiveWebView webView;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int REQUEST_PERMISSIONS = 583286;
    private static final int NATIVE_BAR = 1109826;
    private static final int CLOSE_BUTTON = 1108829;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/hive/social/SocialDialog$Companion;", "", "<init>", "()V", "REQUEST_PERMISSIONS", "", "NATIVE_BAR", "CLOSE_BUTTON", "loginHive", "Lcom/hive/social/SocialDialog;", "activity", "Landroid/app/Activity;", "isClear", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/SocialHive$ShowHiveDialogDataListener;", "logoutHive", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SocialDialog loginHive(Activity activity, boolean isClear, SocialHive.ShowHiveDialogDataListener listener) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(listener, "listener");
            String login = UrlManager.SocialWeb.INSTANCE.getLogin();
            LoggerImpl.INSTANCE.i("SOCIAL_URL_TEST", login);
            return new SocialDialog(activity, login, false, isClear, listener);
        }

        public final SocialDialog logoutHive(Activity activity, SocialHive.ShowHiveDialogDataListener listener) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(listener, "listener");
            String logout = UrlManager.SocialWeb.INSTANCE.getLogout();
            LoggerImpl.INSTANCE.d("SOCIAL_URL_TEST", logout);
            return new SocialDialog(activity, logout, false, listener);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/hive/social/SocialDialog$DummyView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Lcom/hive/social/SocialDialog;Landroid/content/Context;)V", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DummyView extends View {
        final /* synthetic */ SocialDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DummyView(SocialDialog socialDialog, Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = socialDialog;
        }

        @Override // android.view.View
        public void onConfigurationChanged(Configuration newConfig) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            super.onConfigurationChanged(newConfig);
            LoggerImpl.INSTANCE.d("DummyView onConfigurationChanged");
            this.this$0.updateNativeTopBar();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/hive/social/SocialDialog$SocialWebSchemeHandler;", "Lcom/hive/webview/HiveSchemeHandler;", "<init>", "(Lcom/hive/social/SocialDialog;)V", "schemeEvent", "", "view", "Landroid/webkit/WebView;", "schemeObj", "Lcom/hive/core/Scheme;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SocialWebSchemeHandler extends HiveSchemeHandler {
        public SocialWebSchemeHandler() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00ab A[Catch: Exception -> 0x02dc, TryCatch #0 {Exception -> 0x02dc, blocks: (B:3:0x0013, B:5:0x005e, B:7:0x0065, B:9:0x0076, B:10:0x007e, B:12:0x0084, B:15:0x0091, B:17:0x009f, B:19:0x00ab, B:21:0x00c4, B:22:0x00cb, B:16:0x009b, B:24:0x00d0, B:34:0x00f0, B:44:0x010f, B:48:0x011b, B:37:0x00fa, B:41:0x0105, B:50:0x014c, B:53:0x0156, B:57:0x0162, B:59:0x018a, B:60:0x018e, B:62:0x0193, B:65:0x019d, B:67:0x01a3, B:70:0x01ad, B:72:0x01b3, B:75:0x01bd, B:82:0x01d2, B:84:0x01da, B:86:0x01e0, B:89:0x01ea, B:91:0x01f0, B:94:0x01fa, B:96:0x0200, B:99:0x020a, B:101:0x0210, B:104:0x021a, B:106:0x0220, B:109:0x022a, B:110:0x022e, B:112:0x0233, B:115:0x023d, B:117:0x0243, B:120:0x024d, B:122:0x0253, B:125:0x025c, B:127:0x0262, B:130:0x026b, B:132:0x0271, B:135:0x027a, B:137:0x0280, B:140:0x0289, B:142:0x028f, B:145:0x0298, B:147:0x029e, B:150:0x02a7, B:152:0x02ad, B:155:0x02b6, B:157:0x02bc, B:160:0x02d1), top: B:163:0x0013, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0119  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x011a  */
        @Override // com.hive.webview.HiveSchemeHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean schemeEvent(android.webkit.WebView r12, com.hive.core.Scheme r13) {
            /*
                Method dump skipped, instruction units count: 798
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.social.SocialDialog.SocialWebSchemeHandler.schemeEvent(android.webkit.WebView, com.hive.core.Scheme):boolean");
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J,\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\u0013"}, d2 = {"Lcom/hive/social/SocialDialog$SocialWebViewClient;", "Lcom/hive/core/webview/HiveWebViewClient;", "<init>", "(Lcom/hive/social/SocialDialog;)V", "onPageStarted", "", "view", "Landroid/webkit/WebView;", "url", "", "favicon", "Landroid/graphics/Bitmap;", "onPageFinished", "receivedErrorEvent", "errorCode", "", "description", "failingUrl", "getUrlWithoutParameters", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SocialWebViewClient extends HiveWebViewClient {
        public SocialWebViewClient() {
            super(SocialDialog.this.new SocialWebSchemeHandler());
        }

        private final String getUrlWithoutParameters(String url) {
            Uri uri = Uri.parse(url);
            String string = new Uri.Builder().scheme(uri.getScheme()).authority(uri.getAuthority()).path(uri.getPath()).build().toString();
            Intrinsics.checkNotNullExpressionValue(string, "run(...)");
            return string;
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            LoggerImpl.INSTANCE.d("SocialWebviewClient onPageFinished url=" + url);
            SocialDialog.this.spinner.setVisibility(8);
            if (SocialDialog.this.shouldShow) {
                return;
            }
            SocialDialog.this.showWebView();
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            LoggerImpl.INSTANCE.d("SocialWebviewClient onPageStarted url=" + url);
            SocialDialog.this.spinner.setVisibility(0);
            if (StringsKt.contains$default((CharSequence) getUrlWithoutParameters(url), (CharSequence) UrlManager.Chatbot.INSTANCE.getChat(), false, 2, (Object) null)) {
                SocialDialog.this.getActivity().setRequestedOrientation(1);
            } else if (SocialDialog.this.getActivity().getRequestedOrientation() == 1) {
                SocialDialog.this.getActivity().setRequestedOrientation(SocialDialog.this.originOrientation);
            }
        }

        @Override // com.hive.core.webview.HiveWebViewClient
        public void receivedErrorEvent(WebView view, int errorCode, String description, String failingUrl) {
            Intrinsics.checkNotNullParameter(view, "view");
            LoggerImpl.INSTANCE.d("SocialWebviewClient receivedErrorEvent error(" + errorCode + "):" + description);
            SocialDialog socialDialog = SocialDialog.this;
            StringBuilder sb = new StringBuilder("Error : ");
            sb.append(description);
            socialDialog.showToast(sb.toString());
            if (SocialDialog.this.shouldShow) {
                return;
            }
            SocialDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.hive.social.SocialDialog$handleGuestBindScheme$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.social.SocialDialog$handleGuestBindScheme$1", f = "SocialDialog.kt", i = {}, l = {1558, 1568}, m = "invokeSuspend", n = {}, s = {})
    public static final class C29511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $authorizationCode;
        final /* synthetic */ String $did;
        final /* synthetic */ String $errorCode;
        final /* synthetic */ String $peppermint;
        final /* synthetic */ Ref.ObjectRef<String> $sessionToken;
        final /* synthetic */ Ref.ObjectRef<String> $uid;
        int label;
        final /* synthetic */ SocialDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29511(String str, SocialDialog socialDialog, Ref.ObjectRef<String> objectRef, Ref.ObjectRef<String> objectRef2, String str2, String str3, String str4, Continuation<? super C29511> continuation) {
            super(2, continuation);
            this.$authorizationCode = str;
            this.this$0 = socialDialog;
            this.$uid = objectRef;
            this.$sessionToken = objectRef2;
            this.$peppermint = str2;
            this.$did = str3;
            this.$errorCode = str4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29511(this.$authorizationCode, this.this$0, this.$uid, this.$sessionToken, this.$peppermint, this.$did, this.$errorCode, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x019f, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r0, r5, r29) == r2) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x01b1, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r0, r4, r29) == r2) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x01b3, code lost:
        
            return r2;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r30) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 439
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.social.SocialDialog.C29511.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29511) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.hive.social.SocialDialog$handleLoginScheme$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.social.SocialDialog$handleLoginScheme$1", f = "SocialDialog.kt", i = {}, l = {878, 889}, m = "invokeSuspend", n = {}, s = {})
    public static final class C29521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $authorizationCode;
        final /* synthetic */ String $errorCode;
        final /* synthetic */ JSONObject $params;
        final /* synthetic */ String $peppermint;
        final /* synthetic */ Ref.ObjectRef<String> $sessionToken;
        final /* synthetic */ Ref.ObjectRef<String> $uid;
        int label;
        final /* synthetic */ SocialDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29521(String str, SocialDialog socialDialog, Ref.ObjectRef<String> objectRef, Ref.ObjectRef<String> objectRef2, String str2, String str3, JSONObject jSONObject, Continuation<? super C29521> continuation) {
            super(2, continuation);
            this.$authorizationCode = str;
            this.this$0 = socialDialog;
            this.$uid = objectRef;
            this.$sessionToken = objectRef2;
            this.$peppermint = str2;
            this.$errorCode = str3;
            this.$params = jSONObject;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29521(this.$authorizationCode, this.this$0, this.$uid, this.$sessionToken, this.$peppermint, this.$errorCode, this.$params, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x01d4, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r0, r6, r29) == r2) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x01eb, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r0, r4, r29) == r2) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x01ed, code lost:
        
            return r2;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r30) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 497
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.social.SocialDialog.C29521.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29521) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public SocialDialog(Activity activity, boolean z, SocialHive.ShowHiveDialogDataListener showHiveDialogDataListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.shouldShow = z;
        this.closeHandler = showHiveDialogDataListener;
        this.originOrientation = 4;
        this.hiveDialogType = SocialHive.HiveDialogType.HOME;
        Resource resource = Resource.INSTANCE;
        activity.setContentView(resource.getLayoutId(activity, "social_dialog"));
        this.socialRootView = (LinearLayout) activity.findViewById(resource.getViewId(activity, "social_dialog_root"));
        View viewFindViewById = activity.findViewById(resource.getViewId(activity, "social_DialogTopBar"));
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.topLayout = (RelativeLayout) viewFindViewById;
        View viewFindViewById2 = activity.findViewById(resource.getViewId(activity, "social_DialogBottomWebview"));
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.bottomLayout = (RelativeLayout) viewFindViewById2;
        View viewFindViewById3 = activity.findViewById(resource.getViewId(activity, "social_HiveSpinner"));
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.ProgressBar");
        this.spinner = (ProgressBar) viewFindViewById3;
        View viewFindViewById4 = activity.findViewById(resource.getViewId(activity, "social_HiveWebview"));
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type com.hive.core.webview.HiveWebView");
        this.webView = (HiveWebView) viewFindViewById4;
        View viewFindViewById5 = activity.findViewById(resource.getViewId(activity, "social_BackToGameArrow"));
        Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type android.widget.ImageView");
        this.closeButton = (ImageView) viewFindViewById5;
        View viewFindViewById6 = activity.findViewById(resource.getViewId(activity, "social_BackToGame"));
        Intrinsics.checkNotNull(viewFindViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.closeButtonText = (TextView) viewFindViewById6;
        updateNativeTopBar();
        activity.addContentView(new DummyView(this, activity), new RelativeLayout.LayoutParams(-2, -2));
        this.originOrientation = activity.getRequestedOrientation();
        int iArgb = Color.argb(117, 255, 255, 255);
        int iArgb2 = Color.argb(117, 0, 0, 0);
        final long j = 150;
        this.closeButtonTextAnimation = new ColorAnimation(this.closeButtonText, -1, iArgb, 150L, null, 16, null);
        this.closeButtonAnimation = new ColorAnimation(this.closeButton, 0, iArgb2, 150L, null, 16, null);
        this.closeButtonText.setOnTouchListener(new View.OnTouchListener() { // from class: com.hive.social.SocialDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return SocialDialog._init_$lambda$0(this.f$0, j, view, motionEvent);
            }
        });
        this.closeButton.setOnTouchListener(new View.OnTouchListener() { // from class: com.hive.social.SocialDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return SocialDialog._init_$lambda$1(this.f$0, j, view, motionEvent);
            }
        });
        this.webView.setWebViewClient(new SocialWebViewClient());
        this.webView.setWebChromeClient(new WebChromeClient() { // from class: com.hive.social.SocialDialog.3
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                Intrinsics.checkNotNullParameter(consoleMessage, "consoleMessage");
                super.onConsoleMessage(consoleMessage);
                LoggerImpl.INSTANCE.d("SocialDialog consoleMessage message=" + consoleMessage.message() + " line=" + consoleMessage.lineNumber());
                return true;
            }
        });
        this.webView.setVerticalScrollbarOverlay(true);
        WebSettings settings = this.webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setSaveFormData(false);
        settings.setCacheMode(2);
        Window window = activity.getWindow();
        if (window != null) {
            window.getAttributes().windowAnimations = R.style.Animation.Dialog;
            window.getDecorView().setVisibility(8);
            window.setSoftInputMode(16);
            LinearLayout linearLayout = this.socialRootView;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        }
        LoggerImpl.INSTANCE.i("SocialDialog setTransparentUI() call");
        setTransparentUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(SocialDialog socialDialog, long j, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNull(motionEvent);
        return socialDialog.onCloseButtonTouch(motionEvent, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$1(SocialDialog socialDialog, long j, View view, MotionEvent motionEvent) {
        motionEvent.setLocation(motionEvent.getX() + (socialDialog.closeButton.getLeft() - socialDialog.closeButtonText.getLeft()), motionEvent.getY());
        Intrinsics.checkNotNull(motionEvent);
        return socialDialog.onCloseButtonTouch(motionEvent, j);
    }

    private final boolean checkApplicationInstalled(String packageName) {
        PackageManager packageManager = this.activity.getPackageManager();
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(packageName);
        if (launchIntentForPackage == null) {
            return false;
        }
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(launchIntentForPackage, 65536);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
        return listQueryIntentActivities.size() > 0;
    }

    private final void checkServerToast(JSONObject params) {
        showToast(params.optString("servertoast", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismiss$lambda$15(SocialDialog socialDialog) {
        SocialHive.ShowHiveDialogDataListener showHiveDialogDataListener = socialDialog.closeHandler;
        if (showHiveDialogDataListener != null) {
            JSONObject jSONObject = socialDialog.closeParam;
            if (jSONObject == null) {
                showHiveDialogDataListener.onShowHiveDialogWithData(new ResultAPI(-6, ResultAPI.Code.SocialHIVESocialDialogClosed, "User Cancel"), null);
                return;
            }
            Integer numValueOf = jSONObject != null ? Integer.valueOf(jSONObject.optInt(NativeProtocol.BRIDGE_ARG_ERROR_CODE, -1)) : null;
            if (numValueOf != null && numValueOf.intValue() == 0) {
                socialDialog.closeHandler.onShowHiveDialogWithData(new ResultAPI(0, ResultAPI.Code.Success, ""), socialDialog.closeParam);
                return;
            }
            ResultAPI.Code code = ResultAPI.Code.RefundUser;
            int value = code.getValue();
            if (numValueOf != null && numValueOf.intValue() == value) {
                socialDialog.closeHandler.onShowHiveDialogWithData(new ResultAPI(0, code, ""), socialDialog.closeParam);
                return;
            }
            if (numValueOf != null && numValueOf.intValue() == 1801) {
                socialDialog.closeHandler.onShowHiveDialogWithData(new ResultAPI(-16, ResultAPI.Code.AuthInvalidUser, ""), socialDialog.closeParam);
            } else if (numValueOf != null && numValueOf.intValue() == -12000) {
                socialDialog.closeHandler.onShowHiveDialogWithData(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIapV4:Repayment"), socialDialog.closeParam);
            } else {
                socialDialog.closeHandler.onShowHiveDialogWithData(new ResultAPI(-99, ResultAPI.Code.SocialResponseFailDismissDialog, ""), socialDialog.closeParam);
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final SocialV4.ProviderType getSocialV4ProviderType(String serviceName) {
        switch (serviceName.hashCode()) {
            case -1534318765:
                if (serviceName.equals("googleplus")) {
                    return SocialV4.ProviderType.GOOGLE;
                }
                return null;
            case -1206476313:
                if (serviceName.equals("huawei")) {
                    return SocialV4.ProviderType.HUAWEI;
                }
                return null;
            case -759499589:
                if (serviceName.equals(Constants.REFERRER_API_XIAOMI)) {
                    return SocialV4.ProviderType.XIAOMI;
                }
                return null;
            case 3616:
                if (serviceName.equals("qq")) {
                    return SocialV4.ProviderType.QQ;
                }
                return null;
            case 3418016:
                if (serviceName.equals("oppo")) {
                    return SocialV4.ProviderType.OPPO;
                }
                return null;
            case 3620012:
                if (serviceName.equals(Constants.REFERRER_API_VIVO)) {
                    return SocialV4.ProviderType.VIVO;
                }
                return null;
            case 497130182:
                if (serviceName.equals("facebook")) {
                    return SocialV4.ProviderType.FACEBOOK;
                }
                return null;
            case 1474526339:
                if (serviceName.equals("googlepgs")) {
                    return SocialV4.ProviderType.GOOGLE_PLAY_GAMES;
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleCallAppSetting() {
        Uri uri = Uri.parse("package:" + this.activity.getPackageName());
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Intent intent = StringsKt.isBlank(string) ? new Intent("android.settings.SETTINGS") : new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", uri);
        intent.setFlags(268435456);
        ExtentionsKt.startActivityCatching(this.activity, intent, new Function1() { // from class: com.hive.social.SocialDialog$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SocialDialog.handleCallAppSetting$lambda$19((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleCallAppSetting$lambda$19(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.printStackTrace();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleCloseScheme(JSONObject params) {
        LoggerImpl.INSTANCE.d("handleCloseScheme params=" + params);
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleGetPictureScheme(JSONObject params) {
        LoggerImpl.INSTANCE.d("handleGetPictureScheme [" + params + AbstractJsonLexerKt.END_LIST);
        String strOptString = params.optString("type", "gallery");
        int iOptInt = params.optInt("maxLongSize", 500);
        String strOptString2 = params.optString("outputFileType", "JPEG");
        int iOptInt2 = params.optInt("quality", 100);
        if (Intrinsics.areEqual(strOptString, "camera")) {
            HivePicture hivePicture = HivePicture.INSTANCE;
            Intrinsics.checkNotNull(strOptString2);
            hivePicture.getPictureFromCamera(iOptInt, strOptString2, iOptInt2, new HivePicture.HivePictureResultListener() { // from class: com.hive.social.SocialDialog.handleGetPictureScheme.1
                @Override // com.hive.base.HivePicture.HivePictureResultListener
                public void onHivePictureResult(ResultAPI result, String base64encodeString) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    boolean z = base64encodeString == null || StringsKt.isBlank(base64encodeString);
                    boolean z2 = !z;
                    if (result.isSuccess() && !z) {
                        SocialDialog.this.loadUrl("javascript:window['native'].getPictureCallback('" + base64encodeString + "')");
                        return;
                    }
                    LoggerImpl.INSTANCE.d("SocialDialog Fail handleGetPictureScheme \n result: " + result + " isData: " + z2);
                }
            });
        } else if (Intrinsics.areEqual(strOptString, "gallery")) {
            HivePicture hivePicture2 = HivePicture.INSTANCE;
            Intrinsics.checkNotNull(strOptString2);
            hivePicture2.getPictureFromPhotoPicker(iOptInt, strOptString2, iOptInt2, new HivePicture.HivePictureResultListener() { // from class: com.hive.social.SocialDialog.handleGetPictureScheme.2
                @Override // com.hive.base.HivePicture.HivePictureResultListener
                public void onHivePictureResult(ResultAPI result, String base64encodeString) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    boolean z = base64encodeString == null || StringsKt.isBlank(base64encodeString);
                    boolean z2 = !z;
                    if (result.isSuccess() && !z) {
                        SocialDialog.this.loadUrl("javascript:window['native'].getPictureCallback('" + base64encodeString + "')");
                        return;
                    }
                    LoggerImpl.INSTANCE.d("SocialDialog Fail handleGetPictureScheme \n result: " + result + " isData: " + z2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleGuestAcquireUidScheme(JSONObject params) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("handleGuestAcquireUidScheme [" + params + AbstractJsonLexerKt.END_LIST);
        this.closeParam = params;
        WebView.setWebContentsDebuggingEnabled(true);
        String strOptString = params.optString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, null);
        if (strOptString == null) {
            CookieSyncManager.getInstance().sync();
            dismiss();
            return;
        }
        String str = UrlManager.SocialWeb.INSTANCE.getServer() + FileSystemKt.UnixPathSeparator + strOptString;
        loggerImpl.d("SOCIAL_URL_TEST", str);
        loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.String] */
    public final void handleGuestBindScheme(JSONObject params) {
        LoggerImpl.INSTANCE.d("handleGuestBindScheme [" + params + AbstractJsonLexerKt.END_LIST);
        this.closeParam = params;
        WebView.setWebContentsDebuggingEnabled(true);
        String strOptString = params.optString(NativeProtocol.BRIDGE_ARG_ERROR_CODE, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.isDismissing = true;
        if (!params.has("uid") || !params.has("did") || !params.has("sessionkey")) {
            dismiss();
            return;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = params.optString("uid");
        String strOptString2 = params.optString("did");
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = params.optString("sessionkey");
        String strOptString3 = params.optString("peppermint");
        String strOptString4 = params.optString("authorization_code");
        JSONObject jSONObject = this.closeParam;
        if (jSONObject != null) {
            jSONObject.remove(SocialKeys.INSTANCE.getAUTHORIZATION_CODE());
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C29511(strOptString4, this, objectRef, objectRef2, strOptString3, strOptString2, strOptString, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleGuestRequestLoginScheme(JSONObject params) throws JSONException {
        LoggerImpl.INSTANCE.d("handleGuestRequestLoginScheme [" + params + AbstractJsonLexerKt.END_LIST);
        this.closeParam = params;
        if (params != null) {
            params.put("needGuestLogin", true);
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleLaunchAppScheme(JSONObject params) {
        LoggerImpl.INSTANCE.d("handleLaunchAppScheme params=" + params);
        String strOptString = params.optString(PangleConstants.APP_ID, null);
        if (strOptString != null) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(strOptString + "://"));
                this.activity.startActivity(intent);
                Unit unit = Unit.INSTANCE;
            } catch (ActivityNotFoundException unused) {
                String strOptString2 = params.optString("downloadurl", null);
                if (strOptString2 != null) {
                    try {
                        Intent intent2 = new Intent("android.intent.action.VIEW");
                        intent2.setData(Uri.parse(strOptString2));
                        this.activity.startActivity(intent2);
                    } catch (ActivityNotFoundException unused2) {
                        showToast("Application does not exist.");
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean handleLinkDownload(String url, String path, JSONObject params) {
        checkApplicationInstalled("");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) url, "link/download?url=", 0, false, 6, (Object) null);
        if (iIndexOf$default != -1) {
            String strSubstring = url.substring(iIndexOf$default + 18);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            boolean zContains$default = StringsKt.contains$default((CharSequence) strSubstring, (CharSequence) "m.com2us.com/r?c=", false, 2, (Object) null);
            boolean zContains$default2 = StringsKt.contains$default((CharSequence) strSubstring, (CharSequence) "m.withhive.com/link/s", false, 2, (Object) null);
            boolean zContains$default3 = StringsKt.contains$default((CharSequence) strSubstring, (CharSequence) "m.com2us.com/b?", false, 2, (Object) null);
            if (!zContains$default && !zContains$default2 && !zContains$default3) {
                LoggerImpl.INSTANCE.d("handleLinkDownload shouldOverrideUrlLoading downloadURL=" + strSubstring);
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(strSubstring));
                    this.activity.startActivity(intent);
                    return true;
                } catch (ActivityNotFoundException unused) {
                    showToast("URL does not exist.");
                }
            }
        }
        int iIndexOf$default2 = StringsKt.indexOf$default((CharSequence) url, "play.google.com/store/apps", 0, false, 6, (Object) null);
        int iIndexOf$default3 = StringsKt.indexOf$default((CharSequence) url, ".apk", 0, false, 6, (Object) null);
        if (iIndexOf$default2 == -1 && iIndexOf$default3 == -1) {
            return false;
        }
        try {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(url));
            this.activity.startActivity(intent2);
            return true;
        } catch (ActivityNotFoundException unused2) {
            showToast("GooglePlay does not exist.");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, java.lang.String] */
    public final void handleLoginScheme(JSONObject params) {
        LoggerImpl.INSTANCE.d("handleLoginScheme [" + params + AbstractJsonLexerKt.END_LIST);
        this.closeParam = params;
        checkServerToast(params);
        WebView.setWebContentsDebuggingEnabled(true);
        String strOptString = params.optString(NativeProtocol.BRIDGE_ARG_ERROR_CODE, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = params.optString("uid");
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = params.optString("sessionkey");
        String strOptString2 = params.optString("peppermint");
        String strOptString3 = params.optString("authorization_code");
        JSONObject jSONObject = this.closeParam;
        if (jSONObject != null) {
            jSONObject.remove(SocialKeys.INSTANCE.getAUTHORIZATION_CODE());
        }
        this.isDismissing = true;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C29521(strOptString3, this, objectRef, objectRef2, strOptString2, strOptString, params, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleLogoutScheme(JSONObject params) {
        LoggerImpl.INSTANCE.d("handleLogoutScheme [" + params + AbstractJsonLexerKt.END_LIST);
        this.closeParam = params;
        SocialHiveImpl.INSTANCE.processLogoutData();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleOpenBrowserScheme(JSONObject params) {
        LoggerImpl.INSTANCE.d("handleOpenBrowserScheme params=" + params);
        String strOptString = params.optString("url", null);
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(strOptString));
            this.activity.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            showToast("Browser does not exist.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSendSMSScheme(JSONObject params) {
        LoggerImpl.INSTANCE.d("handleSendSMSScheme params=" + params);
        String strOptString = params.optString(TtmlNode.TAG_BODY);
        try {
            Intent intent = new Intent("android.intent.action.SENDTO");
            intent.setData(Uri.parse("sms:"));
            intent.putExtra("sms_body", strOptString);
            this.activity.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            showToast("Application does not exist.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSocialIsAuthorizedScheme(JSONObject params) {
        SocialV4ProviderAdapter companion;
        LoggerImpl.INSTANCE.d("handleSocialIsAuthorizedScheme [" + params + AbstractJsonLexerKt.END_LIST);
        String strOptString = params.optString(NotificationCompat.CATEGORY_SERVICE);
        if (Intrinsics.areEqual(strOptString, "facebook") || Intrinsics.areEqual(strOptString, "googleplus")) {
            SocialV4.ProviderType socialV4ProviderType = getSocialV4ProviderType(strOptString);
            if (socialV4ProviderType == null || (companion = SocialV4ProviderAdapter.INSTANCE.getInstance(socialV4ProviderType)) == null) {
                return;
            }
            companion.handleSocialIsAuthorizedScheme(new SocialV4ProviderAdapter.SocialSchemeListener() { // from class: com.hive.social.SocialDialog$handleSocialIsAuthorizedScheme$1$1
                @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SocialSchemeListener
                public void onResult(JSONObject jsonObject) {
                    Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                    this.this$0.loadUrl("javascript:window['native'].socialIsAuthorizedResult(eval(" + jsonObject + "))");
                }
            });
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_SERVICE, strOptString);
            jSONObject.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_IS_AUTHORIZED);
            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_SOCIAL_NOTSUP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadUrl("javascript:window['native'].socialIsAuthorizedResult(eval(" + jSONObject + "))");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSocialLogoutScheme(JSONObject params) {
        int iHashCode;
        SocialV4ProviderAdapter companion;
        LoggerImpl.INSTANCE.d("handleSocialLogoutScheme [" + params + AbstractJsonLexerKt.END_LIST);
        String strOptString = params.optString(NotificationCompat.CATEGORY_SERVICE);
        if (strOptString != null && ((iHashCode = strOptString.hashCode()) == -1534318765 ? strOptString.equals("googleplus") : !(iHashCode == -1206476313 ? !strOptString.equals("huawei") : !(iHashCode == 3616 ? strOptString.equals("qq") : iHashCode == 497130182 && strOptString.equals("facebook"))))) {
            SocialV4.ProviderType socialV4ProviderType = getSocialV4ProviderType(strOptString);
            if (socialV4ProviderType == null || (companion = SocialV4ProviderAdapter.INSTANCE.getInstance(socialV4ProviderType)) == null) {
                return;
            }
            companion.handleSocialLogoutScheme(new SocialV4ProviderAdapter.SocialSchemeListener() { // from class: com.hive.social.SocialDialog$handleSocialLogoutScheme$1$1
                @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SocialSchemeListener
                public void onResult(JSONObject jsonObject) {
                    Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                    this.this$0.loadUrl("javascript:window['native'].socialLogoutResultCallback(eval(" + jsonObject + "))");
                }
            });
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_SERVICE, strOptString);
            jSONObject.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_LOGOUT);
            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_SOCIAL_NOTSUP);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        loadUrl("javascript:window['native'].socialLogoutResultCallback(eval(" + jSONObject + "))");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSocialRequestCheckRealNameScheme(final JSONObject optionJsonData) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.dL("handleSocialRequestCheckRealNameScheme [" + optionJsonData + AbstractJsonLexerKt.END_LIST);
        loggerImpl.dR("handleSocialRequestCheckRealNameScheme");
        final SocialV4ProviderAdapter addedChinaProvider = SocialV4ProviderAdapter.INSTANCE.getAddedChinaProvider();
        if (addedChinaProvider != null) {
            addedChinaProvider.handleSocialRequestCheckRealName(optionJsonData, new SocialV4ProviderAdapter.SocialSchemeListener() { // from class: com.hive.social.SocialDialog.handleSocialRequestCheckRealNameScheme.1
                @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SocialSchemeListener
                public void onResult(JSONObject jsonObject) {
                    int iOptInt;
                    Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                    if (jsonObject.length() == 0) {
                        LoggerImpl.INSTANCE.d("handleSocialRequestCheckRealNameScheme, result data is empty");
                        SocialDialog.this.dismiss();
                        return;
                    }
                    LoggerImpl loggerImpl2 = LoggerImpl.INSTANCE;
                    loggerImpl2.d("handleSocialRequestCheckRealNameScheme, result data is exist");
                    try {
                        if (jsonObject.getInt(NativeProtocol.BRIDGE_ARG_ERROR_CODE) == 0) {
                            loggerImpl2.d("handleSocialRequestCheckRealNameScheme, success");
                            if (SocialDialog.this.closeParam == null) {
                                SocialDialog.this.closeParam = new JSONObject();
                            }
                            JSONObject jSONObject = SocialDialog.this.closeParam;
                            if (jSONObject != null) {
                                jSONObject.put("checkRealName", 1);
                            }
                            SocialDialog.this.dismiss();
                            return;
                        }
                        loggerImpl2.d("handleSocialRequestCheckRealNameScheme, failed");
                        if (Intrinsics.areEqual(addedChinaProvider.getServiceName(), Constants.REFERRER_API_VIVO) && ((iOptInt = jsonObject.optInt("VivoRealNameStatus")) == 4 || iOptInt == 5)) {
                            loggerImpl2.d("handleSocialRequestCheckRealNameScheme, failed special case with vivo");
                            if (SocialDialog.this.closeParam == null) {
                                SocialDialog.this.closeParam = new JSONObject();
                            }
                            JSONObject jSONObject2 = SocialDialog.this.closeParam;
                            if (jSONObject2 != null) {
                                jSONObject2.put("vivoStatusCode", iOptInt);
                            }
                            SocialDialog.this.dismiss();
                            return;
                        }
                        HiveUiActivity.Companion companion = HiveUiActivity.INSTANCE;
                        Activity activity = SocialDialog.this.getActivity();
                        final SocialDialog socialDialog = SocialDialog.this;
                        final JSONObject jSONObject3 = optionJsonData;
                        companion.launch(activity, new OnActivityLifecycle() { // from class: com.hive.social.SocialDialog$handleSocialRequestCheckRealNameScheme$1$onResult$1
                            public CheckNamePopupDialog checkNamePopupDialog;

                            public final CheckNamePopupDialog getCheckNamePopupDialog() {
                                CheckNamePopupDialog checkNamePopupDialog = this.checkNamePopupDialog;
                                if (checkNamePopupDialog != null) {
                                    return checkNamePopupDialog;
                                }
                                Intrinsics.throwUninitializedPropertyAccessException("checkNamePopupDialog");
                                return null;
                            }

                            @Override // com.hive.ui.OnActivityLifecycle
                            public void onCreate(final Activity activity2, Bundle savedInstanceState) {
                                Intrinsics.checkNotNullParameter(activity2, "activity");
                                super.onCreate(activity2, savedInstanceState);
                                final SocialDialog socialDialog2 = socialDialog;
                                final JSONObject jSONObject4 = jSONObject3;
                                setCheckNamePopupDialog(new CheckNamePopupDialog(activity2, new CheckNamePopupDialog.CheckNameListener() { // from class: com.hive.social.SocialDialog$handleSocialRequestCheckRealNameScheme$1$onResult$1$onCreate$1
                                    @Override // com.hive.social.CheckNamePopupDialog.CheckNameListener
                                    public void onExit() {
                                        LoggerImpl.INSTANCE.d("handleSocialRequestCheckRealNameScheme, onExit()");
                                        socialDialog2.dismiss();
                                        activity2.finish();
                                        Android.INSTANCE.finish();
                                    }

                                    @Override // com.hive.social.CheckNamePopupDialog.CheckNameListener
                                    public void onRetry() {
                                        LoggerImpl.INSTANCE.d("handleSocialRequestCheckRealNameScheme, onRetry()");
                                        activity2.finish();
                                        socialDialog2.handleSocialRequestCheckRealNameScheme(jSONObject4);
                                    }
                                }));
                                getCheckNamePopupDialog().show();
                            }

                            @Override // com.hive.ui.OnActivityLifecycle
                            public void onDestroy(Activity activity2) {
                                Intrinsics.checkNotNullParameter(activity2, "activity");
                                if (!getIsCalledFinish()) {
                                    getCheckNamePopupDialog().cancel();
                                }
                                super.onDestroy(activity2);
                            }

                            public final void setCheckNamePopupDialog(CheckNamePopupDialog checkNamePopupDialog) {
                                Intrinsics.checkNotNullParameter(checkNamePopupDialog, "<set-?>");
                                this.checkNamePopupDialog = checkNamePopupDialog;
                            }
                        });
                    } catch (Exception e) {
                        LoggerImpl.INSTANCE.w("handleSocialRequestCheckRealNameScheme, exception: " + e.getMessage());
                        SocialDialog.this.dismiss();
                    }
                }
            });
            return;
        }
        loggerImpl.d("handleSocialRequestCheckRealNameScheme, provider is null");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 2003);
            jSONObject.put("error_msg", "ChinaMarket Check RealName Failed.(socialPlugin error)");
            jSONObject.put("type", SocialKeys.PeppermintRequestUrlPath.PEPPERMINT_AUTH_PATH);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("handleSocialRequestCheckRealNameScheme, exception(provider is null): " + e.getMessage());
        }
        this.closeParam = jSONObject;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSocialRequestFriendsScheme(JSONObject params) {
        SocialV4ProviderAdapter companion;
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.dL("handleSocialRequestFriendsScheme [" + params + AbstractJsonLexerKt.END_LIST);
        loggerImpl.dR("handleSocialRequestFriendsScheme");
        String strOptString = params.optString(NotificationCompat.CATEGORY_SERVICE);
        if (Intrinsics.areEqual(strOptString, "facebook") || Intrinsics.areEqual(strOptString, "googleplus")) {
            SocialV4.ProviderType socialV4ProviderType = getSocialV4ProviderType(strOptString);
            if (socialV4ProviderType == null || (companion = SocialV4ProviderAdapter.INSTANCE.getInstance(socialV4ProviderType)) == null) {
                return;
            }
            companion.handleSocialRequestFriendsScheme(new SocialV4ProviderAdapter.SocialSchemeListener() { // from class: com.hive.social.SocialDialog$handleSocialRequestFriendsScheme$1$1
                @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SocialSchemeListener
                public void onResult(JSONObject jsonObject) {
                    Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                    this.this$0.loadUrl("javascript:window['native'].putSocialFriendList(eval(" + jsonObject + "))");
                }
            });
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_SERVICE, strOptString);
            jSONObject.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_FRIENDS);
            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_SOCIAL_NOTSUP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadUrl("javascript:window['native'].putSocialFriendList(eval(" + jSONObject + "))");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSocialRequestUserProfileScheme(JSONObject params) {
        SocialV4ProviderAdapter companion;
        SocialV4ProviderAdapter companion2;
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.dL("handleSocialRequestUserProfileScheme [" + params + AbstractJsonLexerKt.END_LIST);
        loggerImpl.dR("handleSocialRequestUserProfileScheme");
        String strOptString = params.optString(NotificationCompat.CATEGORY_SERVICE);
        if (Intrinsics.areEqual(strOptString, "googleplus")) {
            if (Android.INSTANCE.isGooglePlayServicesAvailable(this.activity, true, com.hive.core.Configuration.INSTANCE.getMinGooglePlayServices())) {
                SocialV4.ProviderType socialV4ProviderType = getSocialV4ProviderType(strOptString);
                if (socialV4ProviderType == null || (companion2 = SocialV4ProviderAdapter.INSTANCE.getInstance(socialV4ProviderType)) == null) {
                    return;
                }
                companion2.handleSocialRequestUserProfileScheme(new SocialV4ProviderAdapter.SocialSchemeListener() { // from class: com.hive.social.SocialDialog$handleSocialRequestUserProfileScheme$1$1
                    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SocialSchemeListener
                    public void onResult(JSONObject jsonObject) {
                        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                        this.this$0.loadUrl("javascript:window['native'].putSocialUserData(eval(" + jsonObject + "))");
                    }
                });
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(NotificationCompat.CATEGORY_SERVICE, strOptString);
                jSONObject.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_USER_PROFILE);
                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_SOCIAL_NOTSUP);
            } catch (Exception e) {
                e.printStackTrace();
            }
            loadUrl("javascript:window['native'].putSocialUserData(eval(" + jSONObject + "))");
            return;
        }
        if (Intrinsics.areEqual(strOptString, "facebook")) {
            SocialV4.ProviderType socialV4ProviderType2 = getSocialV4ProviderType(strOptString);
            if (socialV4ProviderType2 == null || (companion = SocialV4ProviderAdapter.INSTANCE.getInstance(socialV4ProviderType2)) == null) {
                return;
            }
            companion.handleSocialRequestUserProfileScheme(new SocialV4ProviderAdapter.SocialSchemeListener() { // from class: com.hive.social.SocialDialog$handleSocialRequestUserProfileScheme$2$1
                @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SocialSchemeListener
                public void onResult(JSONObject jsonObject) {
                    Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                    this.this$0.loadUrl("javascript:window['native'].putSocialUserData(eval(" + jsonObject + "))");
                }
            });
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(NotificationCompat.CATEGORY_SERVICE, strOptString);
            jSONObject2.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_USER_PROFILE);
            jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_SOCIAL_NOTSUP);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        loadUrl("javascript:window['native'].putSocialUserData(eval(" + jSONObject2 + "))");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0098, code lost:
    
        if (r12.equals("facebook") == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a1, code lost:
    
        if (r12.equals(com.adjust.sdk.Constants.REFERRER_API_VIVO) == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00aa, code lost:
    
        if (r12.equals("oppo") == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b3, code lost:
    
        if (r12.equals("qq") == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00bc, code lost:
    
        if (r12.equals(com.adjust.sdk.Constants.REFERRER_API_XIAOMI) == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00bf, code lost:
    
        r12 = getSocialV4ProviderType(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c3, code lost:
    
        if (r12 == null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c5, code lost:
    
        r12 = com.hive.socialv4.provider.SocialV4ProviderAdapter.INSTANCE.getInstance(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00cb, code lost:
    
        if (r12 == null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00cd, code lost:
    
        r12.handleSocialRequestUserTokenScheme(new com.hive.social.SocialDialog$handleSocialRequestUserTokenScheme$3$1(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00dc, code lost:
    
        if (r12.equals("huawei") == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e5, code lost:
    
        if (r12.equals("googleplus") == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e8, code lost:
    
        r12 = getSocialV4ProviderType(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ec, code lost:
    
        if (r12 == null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ee, code lost:
    
        r12 = com.hive.socialv4.provider.SocialV4ProviderAdapter.INSTANCE.getInstance(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f4, code lost:
    
        if (r12 == null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00f6, code lost:
    
        r12.handleSocialRequestUserTokenScheme(new com.hive.social.SocialDialog$handleSocialRequestUserTokenScheme$2$1(r11));
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void handleSocialRequestUserTokenScheme(org.json.JSONObject r12) {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.social.SocialDialog.handleSocialRequestUserTokenScheme(org.json.JSONObject):void");
    }

    private final void internalShow() {
        internalShow(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadUrl(final String url) {
        LoggerImpl.INSTANCE.d("loadUrl [" + url + AbstractJsonLexerKt.END_LIST);
        this.webView.setOauthToken(HiveLifecycle.INSTANCE.getAccount().getOauthToken());
        this.webView.post(new Runnable() { // from class: com.hive.social.SocialDialog$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                SocialDialog.loadUrl$lambda$13(this.f$0, url);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadUrl$lambda$13(SocialDialog socialDialog, String str) {
        socialDialog.webView.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadUrlCI(String url) {
        loadUrlCI(url, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadUrlCI$lambda$12(SocialDialog socialDialog, String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        HiveKeys hiveKeys = HiveKeys.KEY_vid;
        HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
        CommonIdentifierKt.put(jSONObject2, hiveKeys, hiveLifecycle.getAccount().getVid());
        CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_vid_type, hiveLifecycle.getAccount().getVidType());
        CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_cookies, new JSONObject(HiveGraph.INSTANCE.getDefaultData()));
        CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_game_language, ConfigurationImpl.INSTANCE.getHiveLanguage());
        CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_is_gpg_emulator, Boolean.valueOf(Android.INSTANCE.isGPGEmulator()));
        String str2 = socialDialog.additionalInfo;
        if (str2 != null) {
            if (socialDialog.hiveDialogType == SocialHive.HiveDialogType.CHATBOT) {
                JSONObject jSONObject3 = new JSONObject();
                CommonIdentifierKt.put(jSONObject3, HiveKeys.KEY_action, "click_chatbot");
                if (str2.length() == 0) {
                    CommonIdentifierKt.put(jSONObject3, HiveKeys.KEY_param, str2);
                } else {
                    CommonIdentifierKt.put(jSONObject3, HiveKeys.KEY_param, new JSONObject(str2));
                }
                CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_chatbot, jSONObject3.toString());
            } else if (str2.length() > 0) {
                CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_additionalInfo, str2);
            }
        }
        UrlManager.SocialWeb socialWeb = UrlManager.SocialWeb.INSTANCE;
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) socialWeb.getLogin(), false, 2, (Object) null)) {
            socialDialog.processHiveOptionalData(jSONObject2, jSONObject);
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) socialWeb.getLogin(), false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) socialWeb.getGuestBind(), false, 2, (Object) null)) {
            Crypto crypto = Crypto.INSTANCE;
            String strGenerateCodeVerifier = crypto.generateCodeVerifier();
            socialDialog.codeVerifier = strGenerateCodeVerifier;
            String strGenerateCodeChallenge = crypto.generateCodeChallenge(strGenerateCodeVerifier);
            CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_client_id, com.hive.core.Configuration.INSTANCE.getPrimaryClientId());
            CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_code_challenge, strGenerateCodeChallenge);
            CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_code_challenge_method, "S256");
        }
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = HiveIapV4.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof HiveIapV4)) {
            hiveModule = null;
        }
        if (!(hiveModule instanceof HiveIapV4)) {
            hiveModule = null;
        }
        HiveIapV4 hiveIapV4 = (HiveIapV4) hiveModule;
        if (hiveIapV4 != null) {
            if (hiveIapV4.mo5533getSelectedMarket() != IAPV4.IAPV4Type.HIVE_LEBI) {
                hiveIapV4 = null;
            }
            if (hiveIapV4 != null) {
                String name2 = MarketLebi.class.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                HiveModule hiveModule2 = hiveModuleManager.getHiveModule(name2);
                if (!(hiveModule2 instanceof MarketLebi)) {
                    hiveModule2 = null;
                }
                if (!(hiveModule2 instanceof MarketLebi)) {
                    hiveModule2 = null;
                }
                MarketLebi marketLebi = (MarketLebi) hiveModule2;
                if (marketLebi != null) {
                    if (!marketLebi.canUseWechatPay()) {
                        marketLebi = null;
                    }
                    if (marketLebi != null) {
                        CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_is_wechat, "Y");
                        CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_wid, marketLebi.getWechatAppId());
                    }
                }
            }
        }
        String name3 = HiveUserEngagement.class.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
        HiveModule hiveModule3 = hiveModuleManager.getHiveModule(name3);
        if (!(hiveModule3 instanceof HiveUserEngagement)) {
            hiveModule3 = null;
        }
        HiveUserEngagement hiveUserEngagement = (HiveUserEngagement) (hiveModule3 instanceof HiveUserEngagement ? hiveModule3 : null);
        if (hiveUserEngagement != null) {
            hiveUserEngagement.appendEventQueryParameters(jSONObject2);
        }
        socialDialog.webView.setOauthToken(hiveLifecycle.getAccount().getOauthToken());
        HiveWebView hiveWebView = socialDialog.webView;
        String string = jSONObject2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        hiveWebView.postUrlCI(str, bytes);
    }

    private final boolean onCloseButtonTouch(MotionEvent event, long delayMillis) {
        Rect rect = new Rect(this.closeButtonText.getLeft(), this.closeButtonText.getTop(), this.closeButton.getRight(), this.closeButton.getBottom());
        int action = event.getAction();
        if (action == 0) {
            ColorAnimation.startChangeAnimation$default(this.closeButtonTextAnimation, null, null, 3, null);
            ColorAnimation.startChangeAnimation$default(this.closeButtonAnimation, null, null, 3, null);
        } else if (action == 1) {
            ColorAnimation.startReverseAnimation$default(this.closeButtonTextAnimation, null, null, 3, null);
            ColorAnimation.startReverseAnimation$default(this.closeButtonAnimation, null, null, 3, null);
            if (rect.contains(rect.left + ((int) event.getX()), rect.top + ((int) event.getY()))) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.hive.social.SocialDialog$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.dismiss();
                    }
                }, delayMillis);
            }
        } else {
            if (action != 2) {
                return false;
            }
            if (rect.contains(rect.left + ((int) event.getX()), rect.top + ((int) event.getY()))) {
                ColorAnimation.startChangeAnimation$default(this.closeButtonTextAnimation, null, null, 3, null);
                ColorAnimation.startChangeAnimation$default(this.closeButtonAnimation, null, null, 3, null);
            } else {
                ColorAnimation.startReverseAnimation$default(this.closeButtonTextAnimation, null, null, 3, null);
                ColorAnimation.startReverseAnimation$default(this.closeButtonAnimation, null, null, 3, null);
            }
        }
        return true;
    }

    private final void processHiveOptionalData(JSONObject json, JSONObject hiveOptionalData) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i("processHiveOptionalData");
        if (hiveOptionalData != null) {
            if (hiveOptionalData.has("showGuestLogin")) {
                loggerImpl.i("processHiveOptionalData, find showGuestLogin key");
                SocialHiveImpl.INSTANCE.setGuestLoginButton(hiveOptionalData.optBoolean("showGuestLogin"));
            }
            if (hiveOptionalData.has("peppermint")) {
                loggerImpl.i("processHiveOptionalData, find peppermint key");
                try {
                    json.getJSONObject("cookies").put("peppermint", hiveOptionalData.optString("peppermint"));
                } catch (Exception e) {
                    LoggerImpl.INSTANCE.w("processHiveOptionalData, about needStoredUserIdLogin exception : " + e);
                }
            }
        }
        try {
            json.put("is_show_guest", SocialHiveImpl.INSTANCE.getGuestLoginButton());
        } catch (Exception e2) {
            LoggerImpl.INSTANCE.w("processHiveOptionalData, about is_show_guest exception : " + e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int setTopBarSize(int r5, boolean r6) {
        /*
            r4 = this;
            android.app.Activity r0 = r4.activity
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 24
            if (r1 < r2) goto L21
            android.app.Activity r1 = r4.activity
            boolean r1 = r1.isInMultiWindowMode()
            if (r1 == 0) goto L21
            com.hive.base.Android r1 = com.hive.base.Android.INSTANCE
            android.app.Activity r2 = r4.activity
            android.graphics.Point r1 = r1.getDisplaySize(r2)
            goto L29
        L21:
            com.hive.base.Android r1 = com.hive.base.Android.INSTANCE
            android.app.Activity r2 = r4.activity
            android.graphics.Point r1 = r1.getRealDisplaySize(r2)
        L29:
            int r2 = r1.x
            float r2 = (float) r2
            float r3 = r0.density
            float r2 = r2 / r3
            int r1 = r1.y
            float r1 = (float) r1
            float r1 = r1 / r3
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            r3 = 1142947840(0x44200000, float:640.0)
            if (r1 <= 0) goto L68
            r1 = 1149239296(0x44800000, float:1024.0)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L40
            goto L6c
        L40:
            r1 = 1145044992(0x44400000, float:768.0)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L4a
            float r5 = (float) r5
            r1 = 1067450368(0x3fa00000, float:1.25)
            goto L6f
        L4a:
            r1 = 1144520704(0x44380000, float:736.0)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L55
            float r5 = (float) r5
            r1 = 1067906271(0x3fa6f4df, float:1.3043479)
            goto L6f
        L55:
            int r1 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r1 < 0) goto L5d
            float r5 = (float) r5
            r1 = 1069547520(0x3fc00000, float:1.5)
            goto L6f
        L5d:
            r1 = 1141768192(0x440e0000, float:568.0)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L9d
            float r5 = (float) r5
            r1 = 1071142537(0x3fd85689, float:1.6901408)
            goto L6f
        L68:
            int r1 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r1 < 0) goto L71
        L6c:
            float r5 = (float) r5
            r1 = 1065353216(0x3f800000, float:1.0)
        L6f:
            float r5 = r5 / r1
            goto La1
        L71:
            r1 = 1142292480(0x44160000, float:600.0)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L7c
            float r5 = (float) r5
            r1 = 1065912457(0x3f888889, float:1.0666667)
            goto L6f
        L7c:
            r1 = 1139802112(0x43f00000, float:480.0)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L87
            float r5 = (float) r5
            r1 = 1068149419(0x3faaaaab, float:1.3333334)
            goto L6f
        L87:
            r1 = 1137639424(0x43cf0000, float:414.0)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L92
            float r5 = (float) r5
            r1 = 1069932504(0x3fc5dfd8, float:1.5458937)
            goto L6f
        L92:
            r1 = 1135869952(0x43b40000, float:360.0)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L9d
            float r5 = (float) r5
            r1 = 1071877689(0x3fe38e39, float:1.7777778)
            goto L6f
        L9d:
            float r5 = (float) r5
            r1 = 1073741824(0x40000000, float:2.0)
            goto L6f
        La1:
            if (r6 != 0) goto Laf
            double r5 = (double) r5
            double r5 = java.lang.Math.floor(r5)
            int r5 = (int) r5
            float r5 = (float) r5
            r6 = 1
            float r5 = android.util.TypedValue.applyDimension(r6, r5, r0)
        Laf:
            int r5 = java.lang.Math.round(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.social.SocialDialog.setTopBarSize(int, boolean):int");
    }

    private final void setTransparentUI() {
        if (!this.isClear) {
            LoggerImpl.INSTANCE.i("SocialDialog, set alpha (login page) isClear false");
            return;
        }
        LoggerImpl.INSTANCE.i("SocialDialog, set alpha (login page)");
        RelativeLayout relativeLayout = this.topLayout;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(-16777216);
            this.topLayout.getBackground().setAlpha(204);
        }
        HiveWebView hiveWebView = this.webView;
        if (hiveWebView != null) {
            hiveWebView.setBackgroundColor(0);
        }
        RelativeLayout relativeLayout2 = this.bottomLayout;
        if (relativeLayout2 != null) {
            relativeLayout2.setBackgroundColor(-16777216);
            this.bottomLayout.getBackground().setAlpha(204);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(final String message) {
        if (message == null || !(!StringsKt.isBlank(message))) {
            return;
        }
        this.activity.runOnUiThread(new Runnable() { // from class: com.hive.social.SocialDialog$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                SocialDialog.showToast$lambda$39(this.f$0, message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showToast$lambda$39(SocialDialog socialDialog, String str) {
        Toast.makeText(socialDialog.activity, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showWebView() {
        View decorView;
        if (this.isDismissing) {
            return;
        }
        Window window = this.activity.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            decorView.setVisibility(0);
        }
        LinearLayout linearLayout = this.socialRootView;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateNativeTopBar() {
        this.topLayout.getLayoutParams().height = setTopBarSize(68, false);
        ViewGroup.LayoutParams layoutParams = this.closeButton.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.width = setTopBarSize(16, false);
        layoutParams2.height = setTopBarSize(26, false);
        layoutParams2.rightMargin = setTopBarSize(20, false);
        ViewGroup.LayoutParams layoutParams3 = this.closeButtonText.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) layoutParams3).rightMargin = setTopBarSize(10, false);
        this.closeButtonText.setTextSize(setTopBarSize(28, true));
        this.topLayout.invalidate();
    }

    public final void dismiss() {
        this.isDismissing = true;
        this.webView.stopLoading();
        LoggerImpl.INSTANCE.d("runCloseCallback");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.social.SocialDialog$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                SocialDialog.dismiss$lambda$15(this.f$0);
            }
        });
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final boolean onBackPressed() {
        if (this.webView.canGoBackOrForward(-1)) {
            this.webView.goBackOrForward(-1);
            return true;
        }
        dismiss();
        return true;
    }

    public final void show() {
        show(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void internalShow(JSONObject hiveOptionalData) {
        String str = this.url;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("url");
            str = null;
        }
        loadUrlCI(str, hiveOptionalData);
        if (this.shouldShow) {
            showWebView();
        }
    }

    private final void loadUrlCI(final String url, final JSONObject hiveOptionalData) {
        LoggerImpl.INSTANCE.d("loadUrl [" + url + AbstractJsonLexerKt.END_LIST);
        this.webView.post(new Runnable() { // from class: com.hive.social.SocialDialog$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                SocialDialog.loadUrlCI$lambda$12(this.f$0, url, hiveOptionalData);
            }
        });
    }

    public final void show(final JSONObject hiveOptionalData) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.social.SocialDialog$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.internalShow(hiveOptionalData);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SocialDialog(Activity activity, String url, boolean z, SocialHive.ShowHiveDialogDataListener showHiveDialogDataListener) {
        this(activity, z, showHiveDialogDataListener);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SocialDialog(Activity activity, String url, boolean z, boolean z2, SocialHive.ShowHiveDialogDataListener showHiveDialogDataListener) {
        this(activity, z, showHiveDialogDataListener);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.isClear = z2;
        setTransparentUI();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SocialDialog(Activity activity, String url, SocialHive.HiveDialogType hiveDialogType, String str, boolean z, SocialHive.ShowHiveDialogDataListener showHiveDialogDataListener) {
        this(activity, url, z, showHiveDialogDataListener);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(hiveDialogType, "hiveDialogType");
        this.hiveDialogType = hiveDialogType;
        this.additionalInfo = str;
    }
}
