package com.hive.auth;

import android.R;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.NotificationCompat;
import com.adjust.sdk.Constants;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.exoplayer2.ExoPlayer;
import com.hive.AuthV4;
import com.hive.Configuration;
import com.hive.Push;
import com.hive.ResultAPI;
import com.hive.auth.AuthImpl;
import com.hive.auth.UserAgreeDialog;
import com.hive.authv4.AuthV4Impl;
import com.hive.authv4.AuthV4Keys;
import com.hive.base.Android;
import com.hive.base.Property;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.ExtentionsKt;
import com.hive.core.HiveContext;
import com.hive.core.Scheme;
import com.hive.core.StringUtil;
import com.hive.core.webview.HiveWebView;
import com.hive.core.webview.HiveWebViewClient;
import com.hive.logger.LoggerImpl;
import com.hive.permission.CheckPermission;
import com.hive.permission.CheckPermissionLayoutV2;
import com.hive.push.PushImpl;
import com.hive.ui.Resource;
import com.hive.ui.Util;
import com.hive.webview.HiveSchemeHandler;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 l2\u00020\u0001:\u0005lmnopB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010EH\u0014J\u0012\u0010F\u001a\u00020C2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\b\u0010I\u001a\u00020CH\u0014J\u0018\u0010J\u001a\u00020\u00162\u0006\u0010K\u001a\u00020\f2\u0006\u0010L\u001a\u00020MH\u0016J\u0010\u0010\b\u001a\u00020\f2\u0006\u0010N\u001a\u00020\fH\u0002J\u0010\u0010\t\u001a\u00020\f2\u0006\u0010N\u001a\u00020\fH\u0002J\b\u0010O\u001a\u00020\u001cH\u0003J\b\u0010P\u001a\u00020\u001cH\u0003J\b\u0010Q\u001a\u00020\u001cH\u0003J\b\u0010R\u001a\u00020#H\u0003J\"\u0010S\u001a\u00020-2\u0006\u0010T\u001a\u00020E2\u0006\u0010\"\u001a\u00020U2\b\u0010V\u001a\u0004\u0018\u00010WH\u0002J\n\u0010X\u001a\u0004\u0018\u000109H\u0002J\u001a\u0010Y\u001a\u00020C2\b\u0010\"\u001a\u0004\u0018\u00010U2\u0006\u0010Z\u001a\u00020\fH\u0002J\b\u0010[\u001a\u00020CH\u0016J\u0010\u0010\\\u001a\u00020C2\u0006\u0010]\u001a\u00020^H\u0016J\u000e\u0010_\u001a\u00020C2\u0006\u0010T\u001a\u00020EJ\b\u0010`\u001a\u00020CH\u0003J+\u0010a\u001a\u00020C2\u0006\u0010b\u001a\u00020\f2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00050d2\u0006\u0010e\u001a\u00020fH\u0016¢\u0006\u0002\u0010gJ\"\u0010h\u001a\u00020C2\u0006\u0010b\u001a\u00020\f2\u0006\u0010i\u001a\u00020\f2\b\u0010j\u001a\u0004\u0018\u00010kH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00107\u001a\u0016\u0012\u0004\u0012\u000209\u0018\u000108j\n\u0012\u0004\u0012\u000209\u0018\u0001`:X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010;\u001a\u0012\u0012\u0004\u0012\u00020908j\b\u0012\u0004\u0012\u000209`:X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u000e\u0010A\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006q"}, d2 = {"Lcom/hive/auth/UserAgreeDialog;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "ACTION_STATE", "", "DP", "", "xDP", "yDP", "fontDP", "displayWidth", "", "displayHeight", "agreement_version", "url", "agreement_ex_url", "FILL_PARAMS", "Landroid/widget/LinearLayout$LayoutParams;", "bodyBackgroundColor", "innerTextboxBackgroundColor", "destroyParentActivity", "", "getDestroyParentActivity$hive_service_release", "()Z", "setDestroyParentActivity$hive_service_release", "(Z)V", "mainLayout", "Landroid/view/ViewGroup;", "bodyLayout", "verticalScrollView", "Landroid/widget/ScrollView;", "horizontalScrollView", "Landroid/widget/HorizontalScrollView;", "webView", "Lcom/hive/core/webview/HiveWebView;", "userAgreeAnimation", "Lcom/hive/auth/UserAgreeAnimation;", "mHandler", "Landroid/os/Handler;", "mBackKeyHandler", "backKeyFlag", "webViewTimeoutFlag", "webViewErrorFlag", "webViewRetryDialog", "Landroid/app/AlertDialog;", "errorTitleText", "errorMsgText", "retryText", "quitText", "backKeyText", "loadingText", "useCheckPermissionUI", "newPermissionUILayout", "Lcom/hive/permission/CheckPermissionLayoutV2;", "agreementList", "Ljava/util/ArrayList;", "Lcom/hive/authv4/AuthV4Impl$Agreement;", "Lkotlin/collections/ArrayList;", "agreedList", "currentAgreement", "agreementCount", "density", "getDensity$hive_service_release", "()F", "boardHeight", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "num", "createUI", "createBoardTop", "createBoardDown", "createWebView", "getRetryAgreementVersionDialog", "context", "Landroid/webkit/WebView;", "progressDialog", "Landroid/app/ProgressDialog;", "nextAgreement", "closeAgreementUI", NotificationCompat.CATEGORY_MESSAGE, "onDestroy", "onConfigurationChanged", "paramConfiguration", "Landroid/content/res/Configuration;", "setAgreementText", "requestPermission", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", k.M, "WebViewState", "UserAgreeSchemeHandler", "WebViewCallBack", "TextFitTextView", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserAgreeDialog extends AppCompatActivity {
    public static final String THIRD_PARTY_COPYRIGHT_NAME = "auth_copyright";
    public static final String THIRD_PARTY_LOGO_NAME = "auth_logo";
    private String ACTION_STATE;
    private float DP;
    private int agreementCount;
    private ArrayList<AuthV4Impl.Agreement> agreementList;
    private String agreement_ex_url;
    private boolean backKeyFlag;
    private final int boardHeight;
    private ViewGroup bodyLayout;
    private AuthV4Impl.Agreement currentAgreement;
    private final float density;
    private int displayHeight;
    private int displayWidth;
    private float fontDP;
    private HorizontalScrollView horizontalScrollView;
    private Handler mBackKeyHandler;
    private Handler mHandler;
    private ViewGroup mainLayout;
    private CheckPermissionLayoutV2 newPermissionUILayout;
    private String url;
    private UserAgreeAnimation userAgreeAnimation;
    private ScrollView verticalScrollView;
    private HiveWebView webView;
    private boolean webViewErrorFlag;
    private AlertDialog webViewRetryDialog;
    private float xDP;
    private float yDP;
    private int agreement_version = -1;
    private final LinearLayout.LayoutParams FILL_PARAMS = new LinearLayout.LayoutParams(-1, -1);
    private int bodyBackgroundColor = Color.rgb(232, 232, 232);
    private int innerTextboxBackgroundColor = Color.rgb(216, 216, 216);
    private boolean destroyParentActivity = true;
    private boolean webViewTimeoutFlag = true;
    private String errorTitleText = "Privacy Policy";
    private String errorMsgText = "Network connection is unstable.Please try again after checking your network status.";
    private String retryText = "Retry";
    private String quitText = "Quit";
    private String backKeyText = "Tap the Back Button again to exit.";
    private String loadingText = "Loading...";
    private boolean useCheckPermissionUI = true;
    private final ArrayList<AuthV4Impl.Agreement> agreedList = new ArrayList<>();

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\nH\u0007J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0010H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/hive/auth/UserAgreeDialog$TextFitTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "<init>", "(Lcom/hive/auth/UserAgreeDialog;Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Lcom/hive/auth/UserAgreeDialog;Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Lcom/hive/auth/UserAgreeDialog;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_fit", "", "_maxHeight", "setFitTextToBox", "", "fit", "maxHeight", "onDraw", "canvas", "Landroid/graphics/Canvas;", "_shrinkToFit", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class TextFitTextView extends AppCompatTextView {
        private boolean _fit;
        private int _maxHeight;
        final /* synthetic */ UserAgreeDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextFitTextView(UserAgreeDialog userAgreeDialog, Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = userAgreeDialog;
            this._maxHeight = -1;
        }

        private final void _shrinkToFit() {
            int lineBounds = getLineBounds(0, new Rect());
            float textSize = getTextSize();
            int i = this._maxHeight;
            if (i <= 0 || lineBounds <= i) {
                return;
            }
            setTextSize(0, textSize - 2.0f);
            _shrinkToFit();
        }

        public static /* synthetic */ void setFitTextToBox$default(TextFitTextView textFitTextView, boolean z, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = -1;
            }
            textFitTextView.setFitTextToBox(z, i);
        }

        @Override // android.widget.TextView, android.view.View
        public void onDraw(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            super.onDraw(canvas);
            if (this._fit) {
                _shrinkToFit();
            }
        }

        public final void setFitTextToBox(boolean z) {
            setFitTextToBox$default(this, z, 0, 2, null);
        }

        public final void setFitTextToBox(boolean fit, int maxHeight) {
            this._fit = fit;
            this._maxHeight = maxHeight;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextFitTextView(UserAgreeDialog userAgreeDialog, Context context, AttributeSet attrs) {
            super(context, attrs);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attrs, "attrs");
            this.this$0 = userAgreeDialog;
            this._maxHeight = -1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextFitTextView(UserAgreeDialog userAgreeDialog, Context context, AttributeSet attrs, int i) {
            super(context, attrs, i);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attrs, "attrs");
            this.this$0 = userAgreeDialog;
            this._maxHeight = -1;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/hive/auth/UserAgreeDialog$UserAgreeSchemeHandler;", "Lcom/hive/webview/HiveSchemeHandler;", "<init>", "(Lcom/hive/auth/UserAgreeDialog;)V", "isProgressingScheme", "", "()Z", "setProgressingScheme", "(Z)V", "schemeEvent", "view", "Landroid/webkit/WebView;", "scheme", "Lcom/hive/core/Scheme;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class UserAgreeSchemeHandler extends HiveSchemeHandler {
        private boolean isProgressingScheme;

        public UserAgreeSchemeHandler() {
        }

        /* JADX INFO: renamed from: isProgressingScheme, reason: from getter */
        public final boolean getIsProgressingScheme() {
            return this.isProgressingScheme;
        }

        @Override // com.hive.webview.HiveSchemeHandler
        public boolean schemeEvent(WebView view, Scheme scheme) {
            byte[] base64Decode$default;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.dL(AuthDataInterface.getTAG(), "[AuthUIActivity] schemeEvent : " + scheme);
            loggerImpl.dR(AuthDataInterface.getTAG(), "[AuthUIActivity] schemeEvent");
            JSONObject jSONObject = null;
            if (TextUtils.equals("c2s", scheme.getScheme()) && TextUtils.equals("activeuser", scheme.getHost()) && !this.isProgressingScheme) {
                this.isProgressingScheme = true;
                if (TextUtils.equals(UserAgreeDialog.this.ACTION_STATE, AuthV4Impl.AUTHV4_AGREEMENT_ACTION)) {
                    this.isProgressingScheme = false;
                    UserAgreeDialog.this.setDestroyParentActivity$hive_service_release(false);
                    AuthV4Impl.Agreement agreement = UserAgreeDialog.this.currentAgreement;
                    if (agreement != null) {
                        agreement.setScheme(scheme.getUrl());
                    }
                    UserAgreeDialog.this.closeAgreementUI(view, 1);
                    return true;
                }
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String str = !TextUtils.isEmpty(scheme.getParameter().get("agreement")) ? "agreement" : !TextUtils.isEmpty(scheme.getParameter().get("agreement_ex")) ? "agreement_ex" : null;
                LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[AuthUIActivity] queryParameterName : " + str);
                if (TextUtils.equals("agreement", str)) {
                    Property.Companion companion = Property.INSTANCE;
                    Property instance = companion.getINSTANCE();
                    AuthKeys authKeys = AuthKeys.INSTANCE;
                    Property.setValue$default(instance, authKeys.getAGREEMENT_VERSION(), String.valueOf(UserAgreeDialog.this.agreement_version), null, 4, null);
                    Property.setValue$default(companion.getINSTANCE(), authKeys.getAGREEMENT_SCHEME_DATA(), scheme.getUrl(), null, 4, null);
                    Property.setValue$default(companion.getINSTANCE(), authKeys.getAGREEMENT_PRIVACY_STATE(), authKeys.getAGREEMENT_PRIVACY_VALUE_AGREE(), null, 4, null);
                    Property.setValue$default(companion.getINSTANCE(), authKeys.getAGREEMENT_AGREED_EVER(), "true", null, 4, null);
                    companion.getINSTANCE().writeProperties();
                    String str2 = scheme.getParameter().get(str);
                    if (str2 != null) {
                        Charset charset = Charsets.UTF_8;
                        byte[] bytes = str2.getBytes(charset);
                        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                        if (bytes != null && (base64Decode$default = StringUtil.toBase64Decode$default(StringUtil.INSTANCE, bytes, 0, 1, null)) != null) {
                            try {
                                JSONObject jSONObjectOptJSONObject = new JSONObject(new String(base64Decode$default, charset)).optJSONObject("item");
                                if (jSONObjectOptJSONObject != null) {
                                    if (jSONObjectOptJSONObject.has(Constants.PUSH)) {
                                        PushImpl.INSTANCE.onAgreement(true, new Push.RemotePush(jSONObjectOptJSONObject.optBoolean(Constants.PUSH, false), jSONObjectOptJSONObject.optBoolean("night_push", false)));
                                    }
                                    Unit unit = Unit.INSTANCE;
                                }
                            } catch (Exception unused) {
                                Unit unit2 = Unit.INSTANCE;
                            }
                        }
                    }
                    String str3 = UserAgreeDialog.this.agreement_ex_url;
                    if (str3 == null || StringsKt.isBlank(str3)) {
                        UserAgreeDialog.this.setDestroyParentActivity$hive_service_release(false);
                        UserAgreeDialog.this.closeAgreementUI(view, 0);
                        return true;
                    }
                    this.isProgressingScheme = false;
                    view.loadUrl(str3);
                    return true;
                }
                if (TextUtils.equals("agreement_ex", str)) {
                    try {
                        try {
                            byte[] bArrDecode = Base64.decode(URLDecoder.decode(scheme.getParameter().get(str), "UTF-8"), 4);
                            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
                            jSONObject = new JSONObject(new String(bArrDecode, Charsets.UTF_8));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        if (jSONObject != null) {
                            int iOptInt = jSONObject.optInt("sms");
                            Property.Companion companion2 = Property.INSTANCE;
                            Property instance2 = companion2.getINSTANCE();
                            AuthKeys authKeys2 = AuthKeys.INSTANCE;
                            Property.setValue$default(instance2, authKeys2.getAGREEMENT_EX_STATE(), iOptInt != 0 ? iOptInt != 1 ? AbstractJsonLexerKt.NULL : "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO, null, 4, null);
                            Property.setValue$default(companion2.getINSTANCE(), authKeys2.getAGREEMENT_EX_SCHEME_DATA(), UserAgreeDialog.this.url, null, 4, null);
                        } else {
                            Property.setValue$default(Property.INSTANCE.getINSTANCE(), AuthKeys.INSTANCE.getAGREEMENT_EX_STATE(), AbstractJsonLexerKt.NULL, null, 4, null);
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        Property.setValue$default(Property.INSTANCE.getINSTANCE(), AuthKeys.INSTANCE.getAGREEMENT_EX_STATE(), AbstractJsonLexerKt.NULL, null, 4, null);
                    }
                    Property.Companion companion3 = Property.INSTANCE;
                    Property.setValue$default(companion3.getINSTANCE(), AuthKeys.INSTANCE.getAGREEMENT_AGREED_EVER(), "true", null, 4, null);
                    companion3.getINSTANCE().writeProperties();
                    UserAgreeDialog.this.setDestroyParentActivity$hive_service_release(false);
                    UserAgreeDialog.this.closeAgreementUI(view, 0);
                    return true;
                }
            } else {
                UserAgreeDialog userAgreeDialog = UserAgreeDialog.this;
                try {
                    Result.Companion companion4 = Result.INSTANCE;
                    if (Intrinsics.areEqual(Uri.parse(userAgreeDialog.url).getHost(), scheme.getHost())) {
                        return false;
                    }
                    if (view instanceof HiveWebView) {
                        ((HiveWebView) view).blacklistDomain(false);
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(scheme.getUrl()));
                    intent.setFlags(268435456);
                    ExtentionsKt.startActivityCatching$default(userAgreeDialog, intent, null, 2, null);
                    return true;
                } catch (Throwable th) {
                    Result.Companion companion5 = Result.INSTANCE;
                    Result.m7414boximpl(Result.m7415constructorimpl(ResultKt.createFailure(th)));
                }
            }
            return super.schemeEvent(view, scheme);
        }

        public final void setProgressingScheme(boolean z) {
            this.isProgressingScheme = z;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J,\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u0016H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n0\u000bR\u00060\u0000R\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006!"}, d2 = {"Lcom/hive/auth/UserAgreeDialog$WebViewCallBack;", "Lcom/hive/core/webview/HiveWebViewClient;", "<init>", "(Lcom/hive/auth/UserAgreeDialog;)V", "webProgressDialog", "Landroid/app/ProgressDialog;", "getWebProgressDialog", "()Landroid/app/ProgressDialog;", "setWebProgressDialog", "(Landroid/app/ProgressDialog;)V", "localDataRunnable", "Lcom/hive/auth/UserAgreeDialog$WebViewCallBack$LocalDataRunnable;", "Lcom/hive/auth/UserAgreeDialog;", "getLocalDataRunnable", "()Lcom/hive/auth/UserAgreeDialog$WebViewCallBack$LocalDataRunnable;", "setLocalDataRunnable", "(Lcom/hive/auth/UserAgreeDialog$WebViewCallBack$LocalDataRunnable;)V", "onPageStarted", "", "view", "Landroid/webkit/WebView;", "url", "", "favicon", "Landroid/graphics/Bitmap;", "onLoadResource", "onPageFinished", "receivedErrorEvent", "errorCode", "", "description", "failingUrl", "LocalDataRunnable", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class WebViewCallBack extends HiveWebViewClient {
        private LocalDataRunnable localDataRunnable;
        private ProgressDialog webProgressDialog;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\f\u001a\u00020\u000bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/hive/auth/UserAgreeDialog$WebViewCallBack$LocalDataRunnable;", "Ljava/lang/Runnable;", "<init>", "(Lcom/hive/auth/UserAgreeDialog$WebViewCallBack;)V", "webView", "Landroid/webkit/WebView;", "getWebView", "()Landroid/webkit/WebView;", "setWebView", "(Landroid/webkit/WebView;)V", "setHiveWebView", "", "run", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class LocalDataRunnable implements Runnable {
            private WebView webView;

            public LocalDataRunnable() {
            }

            public final WebView getWebView() {
                return this.webView;
            }

            @Override // java.lang.Runnable
            public void run() {
                Integer numValueOf;
                String value;
                String str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                if (UserAgreeDialog.this.webViewTimeoutFlag || UserAgreeDialog.this.webViewErrorFlag) {
                    LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                    loggerImpl.d(AuthDataInterface.getTAG(), "[AuthUIActivity] webViewTimeoutFlag : " + UserAgreeDialog.this.webViewTimeoutFlag);
                    loggerImpl.d(AuthDataInterface.getTAG(), "[AuthUIActivity] webViewErrorFlag : " + UserAgreeDialog.this.webViewErrorFlag);
                    try {
                        String value2 = Property.INSTANCE.getINSTANCE().getValue(AuthKeys.INSTANCE.getAGREEMENT_LOCAL_VERSION());
                        if (value2 == null) {
                            value2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                        }
                        numValueOf = Integer.valueOf(value2);
                    } catch (Exception unused) {
                        numValueOf = 0;
                    }
                    if (TextUtils.equals(UserAgreeDialog.this.ACTION_STATE, AuthV4Impl.AUTHV4_AGREEMENT_ACTION)) {
                        AuthV4Impl.Agreement agreement = UserAgreeDialog.this.currentAgreement;
                        UserAgreeDialog userAgreeDialog = UserAgreeDialog.this;
                        if (agreement == null) {
                            AuthV4Impl.Agreement.ViewMode viewMode = AuthV4Impl.Agreement.ViewMode.REQUIRE;
                            String value3 = Property.INSTANCE.getINSTANCE().getValue(AuthKeys.INSTANCE.getAGREEMENT_LOCAL_FILE_NAME());
                            Intrinsics.checkNotNull(numValueOf);
                            userAgreeDialog.currentAgreement = new AuthV4Impl.Agreement(null, null, true, viewMode, "terms", value3, null, numValueOf.intValue(), null, null);
                        } else {
                            userAgreeDialog.agreement_version = agreement.getVersion();
                        }
                    }
                    if (UserAgreeDialog.this.ACTION_STATE != null ? !(!TextUtils.equals(UserAgreeDialog.this.ACTION_STATE, AuthV4Impl.AUTHV4_AGREEMENT_ACTION) || (value = Property.INSTANCE.getINSTANCE().getValue(AuthV4Keys.AGREEMENT_VERSION_TERMS)) == null) : (value = Property.INSTANCE.getINSTANCE().getValue(AuthKeys.INSTANCE.getAGREEMENT_VERSION())) != null) {
                        str = value;
                    }
                    try {
                        Integer.parseInt(str);
                    } catch (Exception unused2) {
                    }
                    LoggerImpl loggerImpl2 = LoggerImpl.INSTANCE;
                    loggerImpl2.d(AuthDataInterface.getTAG(), "[AuthUIActivity] webViewTimeout runnable agreement_version : " + UserAgreeDialog.this.agreement_version);
                    loggerImpl2.d(AuthDataInterface.getTAG(), "[AuthUIActivity] webViewTimeout runnable localVersion : " + numValueOf);
                    loggerImpl2.d(AuthDataInterface.getTAG(), "[AuthUIActivity] webViewTimeout runnable storedAgreementVersion : 0");
                    if (numValueOf.intValue() < 0) {
                        loggerImpl2.d(AuthDataInterface.getTAG(), "[AuthUIActivity] Stored agreement version is higher than local version. pass Agreement UI");
                        ProgressDialog webProgressDialog = WebViewCallBack.this.getWebProgressDialog();
                        if (webProgressDialog != null && webProgressDialog.isShowing()) {
                            webProgressDialog.dismiss();
                        }
                        UserAgreeDialog.this.setDestroyParentActivity$hive_service_release(false);
                        UserAgreeDialog.this.closeAgreementUI(this.webView, 0);
                        return;
                    }
                    Property.Companion companion = Property.INSTANCE;
                    Property instance = companion.getINSTANCE();
                    AuthKeys authKeys = AuthKeys.INSTANCE;
                    if (TextUtils.isEmpty(instance.getValue(authKeys.getAGREEMENT_LOCAL_FILE_NAME()))) {
                        loggerImpl2.d(AuthDataInterface.getTAG(), "[AuthUIActivity] Local Data is Empty.");
                        ProgressDialog webProgressDialog2 = WebViewCallBack.this.getWebProgressDialog();
                        if (webProgressDialog2 != null && webProgressDialog2.isShowing()) {
                            webProgressDialog2.dismiss();
                        }
                        loggerImpl2.d(AuthDataInterface.getTAG(), "[AuthUIActivity] AGREEMENT_VERSION_PROPERTY - ZERO, close Agreement UI");
                        UserAgreeDialog.this.closeAgreementUI(this.webView, -1);
                        return;
                    }
                    loggerImpl2.d(AuthDataInterface.getTAG(), "[AuthUIActivity] loading Local Data.");
                    WebView webView = this.webView;
                    if (webView != null) {
                        webView.loadUrl("file:///android_res/raw/" + companion.getINSTANCE().getValue(authKeys.getAGREEMENT_LOCAL_FILE_NAME()));
                    }
                }
            }

            public final void setHiveWebView(WebView webView) {
                Intrinsics.checkNotNullParameter(webView, "webView");
                this.webView = webView;
            }

            public final void setWebView(WebView webView) {
                this.webView = webView;
            }
        }

        public WebViewCallBack() {
            super(UserAgreeDialog.this.new UserAgreeSchemeHandler());
            this.localDataRunnable = new LocalDataRunnable();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onPageStarted$lambda$1(UserAgreeDialog userAgreeDialog, WebViewCallBack webViewCallBack) {
            if (userAgreeDialog.webViewTimeoutFlag) {
                ProgressDialog progressDialog = webViewCallBack.webProgressDialog;
                if (progressDialog == null || progressDialog == null || !progressDialog.isShowing()) {
                    ProgressDialog progressDialog2 = new ProgressDialog(userAgreeDialog, R.style.Theme.DeviceDefault.Dialog);
                    progressDialog2.requestWindowFeature(1);
                    progressDialog2.setMessage(userAgreeDialog.loadingText);
                    progressDialog2.setCancelable(true);
                    progressDialog2.show();
                    webViewCallBack.webProgressDialog = progressDialog2;
                }
            }
        }

        public final LocalDataRunnable getLocalDataRunnable() {
            return this.localDataRunnable;
        }

        public final ProgressDialog getWebProgressDialog() {
            return this.webProgressDialog;
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[AuthUIActivity] onLoadResource url : " + url);
            super.onLoadResource(view, url);
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.d(AuthDataInterface.getTAG(), "[AuthUIActivity] onPageFinished url : " + url);
            UserAgreeDialog.this.webViewTimeoutFlag = false;
            UserAgreeDialog.this.webViewErrorFlag = false;
            AlertDialog alertDialog = UserAgreeDialog.this.webViewRetryDialog;
            if (alertDialog != null) {
                UserAgreeDialog userAgreeDialog = UserAgreeDialog.this;
                if (alertDialog.isShowing()) {
                    alertDialog.dismiss();
                    userAgreeDialog.webViewRetryDialog = null;
                }
            }
            ProgressDialog progressDialog = this.webProgressDialog;
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
                this.webProgressDialog = null;
            }
            super.onPageFinished(view, url);
            if (TextUtils.equals(url, AndroidWebViewClient.BLANK_PAGE)) {
                loggerImpl.d(AuthDataInterface.getTAG(), "[AuthUIActivity] url is blank. try local view.\n");
                UserAgreeDialog.this.webViewErrorFlag = true;
                this.localDataRunnable.setHiveWebView(view);
                Handler handler = UserAgreeDialog.this.mHandler;
                if (handler != null) {
                    handler.postDelayed(this.localDataRunnable, 0L);
                }
            }
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[AuthUIActivity] onPageStarted url : " + url);
            final UserAgreeDialog userAgreeDialog = UserAgreeDialog.this;
            Runnable runnable = new Runnable() { // from class: com.hive.auth.UserAgreeDialog$WebViewCallBack$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    UserAgreeDialog.WebViewCallBack.onPageStarted$lambda$1(userAgreeDialog, this);
                }
            };
            Handler handler = UserAgreeDialog.this.mHandler;
            if (handler != null) {
                handler.postDelayed(runnable, 1300L);
            }
            this.localDataRunnable.setHiveWebView(view);
            Handler handler2 = UserAgreeDialog.this.mHandler;
            if (handler2 != null) {
                handler2.postDelayed(this.localDataRunnable, 10000L);
            }
            super.onPageStarted(view, url, favicon);
        }

        @Override // com.hive.core.webview.HiveWebViewClient
        public void receivedErrorEvent(WebView view, int errorCode, String description, String failingUrl) {
            Intrinsics.checkNotNullParameter(view, "view");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.w(AuthDataInterface.getTAG(), "[AuthUIActivity] receivedErrorEvent url : " + failingUrl);
            loggerImpl.w(AuthDataInterface.getTAG(), "[AuthUIActivity] receivedErrorEvent errorCode : " + errorCode);
            loggerImpl.w(AuthDataInterface.getTAG(), "[AuthUIActivity] receivedErrorEvent description : " + description);
            UserAgreeDialog.this.webViewErrorFlag = true;
            this.localDataRunnable.setHiveWebView(view);
            Handler handler = UserAgreeDialog.this.mHandler;
            if (handler != null) {
                handler.postDelayed(this.localDataRunnable, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            }
        }

        public final void setLocalDataRunnable(LocalDataRunnable localDataRunnable) {
            Intrinsics.checkNotNullParameter(localDataRunnable, "<set-?>");
            this.localDataRunnable = localDataRunnable;
        }

        public final void setWebProgressDialog(ProgressDialog progressDialog) {
            this.webProgressDialog = progressDialog;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/hive/auth/UserAgreeDialog$WebViewState;", "", "<init>", "(Ljava/lang/String;I)V", "AGREEMENT", "AGREEMENT_EX", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WebViewState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ WebViewState[] $VALUES;
        public static final WebViewState AGREEMENT = new WebViewState("AGREEMENT", 0);
        public static final WebViewState AGREEMENT_EX = new WebViewState("AGREEMENT_EX", 1);

        private static final /* synthetic */ WebViewState[] $values() {
            return new WebViewState[]{AGREEMENT, AGREEMENT_EX};
        }

        static {
            WebViewState[] webViewStateArr$values = $values();
            $VALUES = webViewStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(webViewStateArr$values);
        }

        private WebViewState(String str, int i) {
        }

        public static EnumEntries<WebViewState> getEntries() {
            return $ENTRIES;
        }

        public static WebViewState valueOf(String str) {
            return (WebViewState) Enum.valueOf(WebViewState.class, str);
        }

        public static WebViewState[] values() {
            return (WebViewState[]) $VALUES.clone();
        }
    }

    public UserAgreeDialog() {
        float f = Configuration.getContext().getResources().getDisplayMetrics().density;
        this.density = f;
        this.boardHeight = (int) (35 * f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeAgreementUI(WebView webView, int msg) {
        if (this.ACTION_STATE == null) {
            UserAgreeAnimation userAgreeAnimation = this.userAgreeAnimation;
            if (userAgreeAnimation != null) {
                userAgreeAnimation.closeAgreementUI(msg);
                return;
            }
            return;
        }
        if (this.destroyParentActivity) {
            UserAgreeAnimation userAgreeAnimation2 = this.userAgreeAnimation;
            if (userAgreeAnimation2 != null) {
                userAgreeAnimation2.closeAgreementUI(1);
                return;
            }
            return;
        }
        AuthV4Impl.Agreement agreement = this.currentAgreement;
        if (agreement != null) {
            this.agreedList.add(agreement);
        }
        AuthV4Impl.Agreement agreementNextAgreement = nextAgreement();
        this.currentAgreement = agreementNextAgreement;
        String url = agreementNextAgreement != null ? agreementNextAgreement.getUrl() : null;
        if (agreementNextAgreement != null && url != null && (!StringsKt.isBlank(url))) {
            this.destroyParentActivity = agreementNextAgreement.getVIEWMODE() == AuthV4Impl.Agreement.ViewMode.REQUIRE;
            if (webView != null) {
                webView.loadUrl(url);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("agreementList", this.agreedList);
        setResult(-1, intent);
        UserAgreeAnimation userAgreeAnimation3 = this.userAgreeAnimation;
        if (userAgreeAnimation3 != null) {
            userAgreeAnimation3.closeAgreementUI(1);
        }
    }

    private final ViewGroup createBoardDown() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setId(1100);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.boardHeight);
        layoutParams2.addRule(9);
        layoutParams2.addRule(11);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(layoutParams2);
        Resource resource = Resource.INSTANCE;
        imageView.setImageResource(resource.getDrawableId(this, "hive_round_bottom_10_rad"));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout.addView(imageView, layoutParams2);
        ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
        String appId = configurationImpl.getAppId();
        if (StringsKt.endsWith(appId, "huawei", true) || StringsKt.endsWith(appId, "gamecenter", true) || StringsKt.endsWith(appId, Constants.REFERRER_API_VIVO, true) || StringsKt.endsWith(appId, "mi", true)) {
            LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "Remove CI for china module");
            return relativeLayout;
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        AppCompatImageView appCompatImageView = new AppCompatImageView(this);
        int companyIndex = configurationImpl.getCompanyIndex();
        int drawableId = resource.getDrawableId(this, companyIndex != 1 ? companyIndex != 2 ? THIRD_PARTY_COPYRIGHT_NAME : "auth_copyright_com2us_holdings" : "auth_copyright_com2us");
        if (drawableId != 0) {
            appCompatImageView.setImageResource(drawableId);
        } else {
            LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "[AuthUIActivity] can't board down res-id.");
        }
        appCompatImageView.setLayoutParams(layoutParams3);
        relativeLayout.addView(appCompatImageView);
        return relativeLayout;
    }

    private final ViewGroup createBoardTop() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setId(1000);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.boardHeight);
        layoutParams2.addRule(9);
        layoutParams2.addRule(11);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(layoutParams2);
        Resource resource = Resource.INSTANCE;
        imageView.setImageResource(resource.getDrawableId(this, "hive_round_top_10_rad"));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout.addView(imageView, layoutParams2);
        ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
        String appId = configurationImpl.getAppId();
        if (StringsKt.endsWith(appId, "huawei", true) || StringsKt.endsWith(appId, "gamecenter", true) || StringsKt.endsWith(appId, Constants.REFERRER_API_VIVO, true) || StringsKt.endsWith(appId, "mi", true)) {
            LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "Remove CI for china module");
            return relativeLayout;
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        AppCompatImageView appCompatImageView = new AppCompatImageView(this);
        int companyIndex = configurationImpl.getCompanyIndex();
        int drawableId = resource.getDrawableId(this, companyIndex != 1 ? companyIndex != 2 ? THIRD_PARTY_LOGO_NAME : "auth_logo_com2us_holdings" : "auth_logo_com2us");
        if (drawableId != 0) {
            appCompatImageView.setImageResource(drawableId);
        } else {
            LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "[AuthUIActivity] can't board top res-id.");
        }
        appCompatImageView.setLayoutParams(layoutParams3);
        relativeLayout.addView(appCompatImageView);
        return relativeLayout;
    }

    private final ViewGroup createUI() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setPadding(xDP(10), yDP(10), xDP(10), yDP(10));
        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(this.FILL_PARAMS);
        scrollView.setSmoothScrollingEnabled(true);
        this.verticalScrollView = scrollView;
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this);
        horizontalScrollView.setLayoutParams(this.FILL_PARAMS);
        horizontalScrollView.setSmoothScrollingEnabled(true);
        this.horizontalScrollView = horizontalScrollView;
        View viewCreateBoardTop = createBoardTop();
        View viewCreateBoardDown = createBoardDown();
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.setMargins(xDP(10), -yDP(5), xDP(10), -yDP(5));
        layoutParams2.addRule(3, viewCreateBoardTop.getId());
        layoutParams2.addRule(2, viewCreateBoardDown.getId());
        relativeLayout2.setId(ResultAPI.PeppermintErrCode.HUB_E_INVALID_URL);
        relativeLayout2.setLayoutParams(layoutParams2);
        relativeLayout2.setBackgroundColor(this.bodyBackgroundColor);
        HiveWebView hiveWebViewCreateWebView = createWebView();
        this.webView = hiveWebViewCreateWebView;
        relativeLayout2.addView(hiveWebViewCreateWebView);
        this.bodyLayout = relativeLayout2;
        relativeLayout.addView(relativeLayout2);
        relativeLayout.addView(viewCreateBoardTop);
        relativeLayout.addView(viewCreateBoardDown);
        return relativeLayout;
    }

    private final HiveWebView createWebView() {
        final HiveWebView hiveWebView = new HiveWebView(this);
        hiveWebView.setLayoutParams(this.FILL_PARAMS);
        hiveWebView.getSettings().setJavaScriptEnabled(true);
        hiveWebView.setWebViewClient(new WebViewCallBack());
        hiveWebView.getSettings().setDefaultTextEncodingName("UTF-8");
        hiveWebView.getSettings().setCacheMode(2);
        hiveWebView.setBackgroundColor(this.innerTextboxBackgroundColor);
        if (TextUtils.isEmpty(this.url) && TextUtils.isEmpty(this.agreement_ex_url) && this.ACTION_STATE == null) {
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.d(AuthDataInterface.getTAG(), "[AuthUIActivity] url is empty, loading Local Data");
            Property.Companion companion = Property.INSTANCE;
            Property instance = companion.getINSTANCE();
            AuthKeys authKeys = AuthKeys.INSTANCE;
            if (TextUtils.isEmpty(instance.getValue(authKeys.getAGREEMENT_LOCAL_FILE_NAME()))) {
                loggerImpl.d(AuthDataInterface.getTAG(), "[AuthUIActivity] loading Local Data failed, Local Data is empty.");
                if (TextUtils.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO, companion.getINSTANCE().getValue(authKeys.getAGREEMENT_VERSION()))) {
                    loggerImpl.d(AuthDataInterface.getTAG(), "[AuthUIActivity] AGREEMENT_VERSION_PROPERTY - ZERO, close Agreement UI");
                    if (this.userAgreeAnimation != null) {
                        closeAgreementUI(hiveWebView, -1);
                        return hiveWebView;
                    }
                    finish();
                    return hiveWebView;
                }
                loggerImpl.d(AuthDataInterface.getTAG(), "[AuthUIActivity] AGREEMENT_VERSION_PROPERTY - Exist, pass Agreement UI");
                this.destroyParentActivity = false;
                if (this.userAgreeAnimation != null) {
                    closeAgreementUI(hiveWebView, 0);
                    return hiveWebView;
                }
                finish();
                return hiveWebView;
            }
            Runnable runnable = new Runnable() { // from class: com.hive.auth.UserAgreeDialog$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    UserAgreeDialog.createWebView$lambda$6(hiveWebView);
                }
            };
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.postDelayed(runnable, 0L);
                return hiveWebView;
            }
        } else if (TextUtils.equals(this.ACTION_STATE, AuthV4Impl.AUTHV4_AGREEMENT_ACTION)) {
            this.currentAgreement = nextAgreement();
            Handler handler2 = this.mHandler;
            if (handler2 != null) {
                handler2.postDelayed(new Runnable() { // from class: com.hive.auth.UserAgreeDialog$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        UserAgreeDialog.createWebView$lambda$8(this.f$0, hiveWebView);
                    }
                }, 0L);
                return hiveWebView;
            }
        } else {
            Runnable runnable2 = new Runnable() { // from class: com.hive.auth.UserAgreeDialog$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    UserAgreeDialog.createWebView$lambda$9(this.f$0, hiveWebView);
                }
            };
            Handler handler3 = this.mHandler;
            if (handler3 != null) {
                handler3.postDelayed(runnable2, 0L);
            }
        }
        return hiveWebView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createWebView$lambda$6(HiveWebView hiveWebView) {
        hiveWebView.loadUrl("file:///android_res/raw/" + Property.INSTANCE.getINSTANCE().getValue(AuthKeys.INSTANCE.getAGREEMENT_LOCAL_FILE_NAME()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createWebView$lambda$8(UserAgreeDialog userAgreeDialog, HiveWebView hiveWebView) {
        AuthV4Impl.Agreement agreement = userAgreeDialog.currentAgreement;
        String url = agreement != null ? agreement.getUrl() : null;
        if (agreement == null || url == null || !(!StringsKt.isBlank(url))) {
            userAgreeDialog.destroyParentActivity = false;
            userAgreeDialog.closeAgreementUI(hiveWebView, 1);
        } else {
            userAgreeDialog.destroyParentActivity = agreement.getVIEWMODE() == AuthV4Impl.Agreement.ViewMode.REQUIRE;
            hiveWebView.loadUrl(url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createWebView$lambda$9(UserAgreeDialog userAgreeDialog, HiveWebView hiveWebView) {
        String str = userAgreeDialog.url;
        String str2 = userAgreeDialog.agreement_ex_url;
        if (str != null && (!StringsKt.isBlank(str))) {
            hiveWebView.loadUrl(str);
        } else {
            if (str2 == null || !(!StringsKt.isBlank(str2))) {
                return;
            }
            hiveWebView.loadUrl(str2);
        }
    }

    private final AlertDialog getRetryAgreementVersionDialog(Context context, final WebView webView, final ProgressDialog progressDialog) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setTitle(this.errorTitleText);
        builder.setMessage(this.errorMsgText);
        builder.setPositiveButton(this.retryText, new DialogInterface.OnClickListener() { // from class: com.hive.auth.UserAgreeDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                UserAgreeDialog.getRetryAgreementVersionDialog$lambda$11(this.f$0, webView, progressDialog, dialogInterface, i);
            }
        });
        builder.setNegativeButton(this.quitText, new DialogInterface.OnClickListener() { // from class: com.hive.auth.UserAgreeDialog$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                UserAgreeDialog.getRetryAgreementVersionDialog$lambda$12(progressDialog, this, webView, dialogInterface, i);
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        return alertDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRetryAgreementVersionDialog$lambda$11(final UserAgreeDialog userAgreeDialog, final WebView webView, final ProgressDialog progressDialog, DialogInterface dialogInterface, int i) {
        LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[AuthUIActivity] getRetryAgreementVersionDialog : retry");
        Runnable runnable = new Runnable() { // from class: com.hive.auth.UserAgreeDialog$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                UserAgreeDialog.getRetryAgreementVersionDialog$lambda$11$lambda$10(this.f$0, webView, progressDialog);
            }
        };
        Handler handler = userAgreeDialog.mHandler;
        if (handler != null) {
            handler.postDelayed(runnable, 10000L);
        }
        webView.reload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRetryAgreementVersionDialog$lambda$11$lambda$10(UserAgreeDialog userAgreeDialog, WebView webView, ProgressDialog progressDialog) {
        if (userAgreeDialog.webViewTimeoutFlag) {
            AlertDialog retryAgreementVersionDialog = userAgreeDialog.getRetryAgreementVersionDialog(userAgreeDialog, webView, progressDialog);
            userAgreeDialog.webViewRetryDialog = retryAgreementVersionDialog;
            if (retryAgreementVersionDialog != null) {
                retryAgreementVersionDialog.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRetryAgreementVersionDialog$lambda$12(ProgressDialog progressDialog, UserAgreeDialog userAgreeDialog, WebView webView, DialogInterface dialogInterface, int i) {
        LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[AuthUIActivity] getRetryAgreementVersionDialog : quit");
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        userAgreeDialog.closeAgreementUI(webView, -1);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.hive.authv4.AuthV4Impl.Agreement nextAgreement() {
        /*
            r5 = this;
            com.hive.logger.LoggerImpl r0 = com.hive.logger.LoggerImpl.INSTANCE
            java.lang.String r1 = com.hive.AuthV4.getTAG()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "[PlayerUIActivity] nextAgreement: "
            r2.<init>(r3)
            int r3 = r5.agreementCount
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.d(r1, r2)
            java.util.ArrayList<com.hive.authv4.AuthV4Impl$Agreement> r0 = r5.agreementList     // Catch: java.lang.Exception -> L2e
            if (r0 == 0) goto L46
            int r1 = r0.size()     // Catch: java.lang.Exception -> L2e
            int r2 = r5.agreementCount     // Catch: java.lang.Exception -> L2e
            if (r1 <= r2) goto L46
            int r1 = r2 + 1
            r5.agreementCount = r1     // Catch: java.lang.Exception -> L2e
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Exception -> L2e
            goto L47
        L2e:
            r0 = move-exception
            com.hive.logger.LoggerImpl r1 = com.hive.logger.LoggerImpl.INSTANCE
            java.lang.String r2 = com.hive.AuthV4.getTAG()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "nextAgreement exception: "
            r3.<init>(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.w(r2, r0)
        L46:
            r0 = 0
        L47:
            com.hive.logger.LoggerImpl r1 = com.hive.logger.LoggerImpl.INSTANCE
            java.lang.String r2 = com.hive.AuthV4.getTAG()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "\n"
            r3.<init>(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            r1.dL(r2, r3)
            com.hive.authv4.AuthV4Impl$Agreement r0 = (com.hive.authv4.AuthV4Impl.Agreement) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.auth.UserAgreeDialog.nextAgreement():com.hive.authv4.AuthV4Impl$Agreement");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1(UserAgreeDialog userAgreeDialog, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        userAgreeDialog.onKeyDown(4, new KeyEvent(0, 4));
        return Unit.INSTANCE;
    }

    private final void requestPermission() {
        CheckPermission checkPermission = CheckPermission.INSTANCE;
        final String[] strArr = (String[]) checkPermission.getShouldRequestPermissions().toArray(new String[0]);
        if (this.useCheckPermissionUI) {
            this.newPermissionUILayout = new CheckPermissionLayoutV2(this, new CheckPermissionLayoutV2.OnFinishedListener() { // from class: com.hive.auth.UserAgreeDialog.requestPermission.1
                private boolean isFinished;

                /* JADX INFO: renamed from: isFinished, reason: from getter */
                public final boolean getIsFinished() {
                    return this.isFinished;
                }

                @Override // com.hive.permission.CheckPermissionLayoutV2.OnFinishedListener
                public void onFinished() {
                    if (this.isFinished) {
                        return;
                    }
                    String[] strArr2 = strArr;
                    if (strArr2.length > 0) {
                        this.requestPermissions(strArr2, CheckPermission.CHECK_PERMISSION_REQUEST_CODE);
                    } else {
                        this.setDestroyParentActivity$hive_service_release(false);
                        CheckPermission.OnAuthCheckPermissionListener listener = CheckPermission.INSTANCE.getListener();
                        if (listener != null) {
                            listener.onAuthCheckPermissionListener();
                        }
                        this.finish();
                    }
                    this.isFinished = true;
                }

                public final void setFinished(boolean z) {
                    this.isFinished = z;
                }
            });
            return;
        }
        if (strArr.length > 0) {
            requestPermissions(strArr, CheckPermission.CHECK_PERMISSION_REQUEST_CODE);
            return;
        }
        this.destroyParentActivity = false;
        CheckPermission.OnAuthCheckPermissionListener listener = checkPermission.getListener();
        if (listener != null) {
            listener.onAuthCheckPermissionListener();
        }
        finish();
    }

    private final int xDP(int num) {
        return (int) (num * this.xDP);
    }

    private final int yDP(int num) {
        return (int) (num * this.yDP);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context newBase) {
        if (newBase != null) {
            super.attachBaseContext(HiveContext.INSTANCE.wrap(newBase, com.hive.core.Configuration.INSTANCE.getGameLanguage()));
        }
    }

    /* JADX INFO: renamed from: getDensity$hive_service_release, reason: from getter */
    public final float getDensity() {
        return this.density;
    }

    /* JADX INFO: renamed from: getDestroyParentActivity$hive_service_release, reason: from getter */
    public final boolean getDestroyParentActivity() {
        return this.destroyParentActivity;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[AuthUIActivity] onActivityResult - " + requestCode);
        if (requestCode == 31112) {
            requestPermission();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration paramConfiguration) {
        UserAgreeAnimation userAgreeAnimation;
        Intrinsics.checkNotNullParameter(paramConfiguration, "paramConfiguration");
        super.onConfigurationChanged(paramConfiguration);
        if (this.ACTION_STATE == null) {
            int i = paramConfiguration.orientation;
            if (i == 1) {
                UserAgreeAnimation userAgreeAnimation2 = this.userAgreeAnimation;
                if (userAgreeAnimation2 != null) {
                    userAgreeAnimation2.configurationChanged();
                    return;
                }
                return;
            }
            if (i != 2 || (userAgreeAnimation = this.userAgreeAnimation) == null) {
                return;
            }
            userAgreeAnimation.configurationChanged();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(com.hive.ui.R.style.Theme_Hive_AppCompat_Translucent);
        ViewGroup viewGroup = null;
        getTheme().applyStyle(Resource.getHiveStyleId$default(Resource.INSTANCE, this, null, 2, null), true);
        Util util = Util.INSTANCE;
        util.hideSystemUI(getWindow());
        getWindow().addFlags(2);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.dimAmount = 0.8f;
        getWindow().setAttributes(attributes);
        this.mBackKeyHandler = new Handler() { // from class: com.hive.auth.UserAgreeDialog.onCreate.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (msg.what == 0) {
                    UserAgreeDialog.this.backKeyFlag = false;
                }
                super.handleMessage(msg);
            }
        };
        this.useCheckPermissionUI = getIntent().getBooleanExtra("useUI", true);
        setRequestedOrientation(util.getSystemScreenOrientation(this, com.hive.core.Configuration.INSTANCE.getHiveOrientation()));
        if (TextUtils.equals(getIntent().getAction(), CheckPermission.CHECK_PERMISSION_ACTION)) {
            this.ACTION_STATE = getIntent().getAction();
            LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[AuthUIActivity] AuthUIActivity onCreate - Action: " + this.ACTION_STATE);
            requestPermission();
        } else {
            setAgreementText(this);
            this.mHandler = new Handler();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            this.displayWidth = i;
            int i2 = displayMetrics.heightPixels;
            this.displayHeight = i2;
            this.DP = displayMetrics.density;
            float f = displayMetrics.xdpi;
            float f2 = displayMetrics.ydpi;
            float f3 = 160;
            this.xDP = f / f3;
            this.yDP = f2 / f3;
            float f4 = i / f;
            float f5 = i2 / f2;
            double dSqrt = Math.sqrt((f4 * f4) + (f5 * f5));
            float f6 = this.DP;
            this.fontDP = f6;
            if (this.displayHeight < 500 && this.displayWidth < 500) {
                this.fontDP = 1.7f;
            } else if (f6 > 1.5f) {
                this.fontDP = 1.5f;
            }
            if (dSqrt > 10.0d) {
                this.xDP *= 0.85f;
                this.yDP *= 0.85f;
                this.fontDP *= 0.85f;
            } else if (dSqrt > 7.0d) {
                this.xDP *= 0.8f;
                this.yDP *= 0.8f;
                this.fontDP *= 0.9f;
            } else if (dSqrt > 6.0d) {
                this.xDP *= 0.75f;
                this.yDP *= 0.75f;
                this.fontDP *= 0.95f;
            } else if (dSqrt > 5.0d) {
                this.xDP *= 0.7f;
                this.yDP *= 0.7f;
                this.fontDP *= 1.0f;
            } else if (dSqrt > 4.75d) {
                this.xDP *= 0.65f;
                this.yDP *= 0.65f;
                this.fontDP *= 1.15f;
            } else if (dSqrt > 4.5d) {
                this.xDP *= 0.6f;
                this.yDP *= 0.6f;
                this.fontDP *= 1.2f;
            } else if (dSqrt > 4.0d) {
                this.xDP *= 0.55f;
                this.yDP *= 0.55f;
                this.fontDP *= 1.3f;
            } else {
                this.xDP *= 0.5f;
                this.yDP *= 0.5f;
                this.fontDP *= 1.35f;
            }
            if (TextUtils.equals(getIntent().getAction(), AuthV4Impl.AUTHV4_AGREEMENT_ACTION)) {
                this.ACTION_STATE = getIntent().getAction();
                LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[PlayerUIActivity] PlayerUIActivity onCreate - Action: " + this.ACTION_STATE);
                this.agreementList = getIntent().getParcelableArrayListExtra("agreementList");
            } else {
                this.ACTION_STATE = null;
                this.agreement_version = getIntent().getIntExtra("agreement_version", -1);
                this.url = getIntent().getStringExtra("url");
                this.agreement_ex_url = getIntent().getStringExtra("agreement_ex_url");
            }
            this.bodyBackgroundColor = Color.rgb(232, 232, 232);
            this.innerTextboxBackgroundColor = Color.rgb(216, 216, 216);
            ViewGroup viewGroupCreateUI = createUI();
            this.mainLayout = viewGroupCreateUI;
            if (viewGroupCreateUI == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainLayout");
            } else {
                viewGroup = viewGroupCreateUI;
            }
            setContentView(viewGroup);
        }
        OnBackPressedDispatcherKt.addCallback$default(getOnBackPressedDispatcher(), this, false, new Function1() { // from class: com.hive.auth.UserAgreeDialog$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserAgreeDialog.onCreate$lambda$1(this.f$0, (OnBackPressedCallback) obj);
            }
        }, 2, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[AuthUIActivity] onDestroy");
        if (this.ACTION_STATE == null) {
            this.mHandler = null;
            this.mBackKeyHandler = null;
        }
        if (this.destroyParentActivity) {
            if (ConfigurationImpl.INSTANCE.getExitEventEnabled()) {
                AuthImpl.AfterAgreementListener internalAfterAgreementListener$hive_service_release = AuthImpl.INSTANCE.getInternalAfterAgreementListener$hive_service_release();
                if (internalAfterAgreementListener$hive_service_release != null) {
                    internalAfterAgreementListener$hive_service_release.onAgreementUIFinish(0, false);
                }
                AuthV4Impl.INSTANCE.onSetupCanceled();
            } else {
                Android.INSTANCE.finish();
            }
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        LoggerImpl.INSTANCE.i("[AuthUIActivity] onKeyDown: " + keyCode + ", " + event);
        if (keyCode == 4) {
            HiveWebView hiveWebView = this.webView;
            if (hiveWebView != null) {
                hiveWebView.loadUrl("javascript:backKeyPressed();");
            }
            String str = this.ACTION_STATE;
            if (str == null || TextUtils.equals(str, AuthV4Impl.AUTHV4_AGREEMENT_ACTION)) {
                if (this.backKeyFlag) {
                    if (this.userAgreeAnimation != null) {
                        closeAgreementUI(null, this.destroyParentActivity ? -1 : 0);
                    } else {
                        finish();
                    }
                    return false;
                }
                Toast.makeText(this, this.backKeyText, 0).show();
                this.backKeyFlag = true;
                Handler handler = this.mBackKeyHandler;
                if (handler != null) {
                    handler.sendEmptyMessageDelayed(0, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                }
                return false;
            }
            if (TextUtils.equals(this.ACTION_STATE, CheckPermission.CHECK_PERMISSION_ACTION)) {
                CheckPermissionLayoutV2 checkPermissionLayoutV2 = this.newPermissionUILayout;
                if (checkPermissionLayoutV2 != null) {
                    checkPermissionLayoutV2.onBackKeyDown();
                }
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d(AuthDataInterface.getTAG(), "[AuthUIActivity] onRequestPermissionsResult - " + requestCode);
        if (requestCode != 29512) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            return;
        }
        loggerImpl.d(AuthDataInterface.getTAG(), "[AuthUIActivity] onRequestPermissionsResult");
        int length = permissions.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = permissions[i];
            int i3 = i2 + 1;
            LoggerImpl loggerImpl2 = LoggerImpl.INSTANCE;
            String tag = AuthDataInterface.getTAG();
            StringBuilder sb = new StringBuilder("[AuthUIActivity] ");
            sb.append(str);
            sb.append(" : (");
            sb.append(grantResults[i2]);
            sb.append("), ");
            sb.append(grantResults[i2] == 0 ? "granted." : "denied.");
            loggerImpl2.d(tag, sb.toString());
            i++;
            i2 = i3;
        }
        this.destroyParentActivity = false;
        CheckPermission.OnAuthCheckPermissionListener listener = CheckPermission.INSTANCE.getListener();
        if (listener != null) {
            listener.onAuthCheckPermissionListener();
        }
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        String str = this.ACTION_STATE;
        if (str == null || TextUtils.equals(str, AuthV4Impl.AUTHV4_AGREEMENT_ACTION)) {
            if (this.userAgreeAnimation == null) {
                ViewGroup viewGroup = this.mainLayout;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mainLayout");
                    viewGroup = null;
                }
                this.userAgreeAnimation = new UserAgreeAnimation(this, viewGroup, this.xDP, this.yDP, this.displayWidth, this.displayHeight, this.boardHeight);
            }
            UserAgreeAnimation userAgreeAnimation = this.userAgreeAnimation;
            if (userAgreeAnimation != null) {
                userAgreeAnimation.openAgreementUI();
            }
        }
    }

    public final void setAgreementText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resource resource = Resource.INSTANCE;
        this.errorTitleText = resource.getString("hive_useragree_dialog_title");
        this.errorMsgText = resource.getString("hive_useragree_dialog_msg");
        this.retryText = resource.getString("hive_useragree_dialog_retry");
        this.quitText = resource.getString("hive_useragree_dialog_quit");
        this.backKeyText = resource.getString("hive_useragree_dialog_backkey");
        this.loadingText = resource.getString("hive_useragree_dialog_loading");
    }

    public final void setDestroyParentActivity$hive_service_release(boolean z) {
        this.destroyParentActivity = z;
    }
}
