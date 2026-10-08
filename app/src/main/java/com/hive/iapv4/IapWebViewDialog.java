package com.hive.iapv4;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.core.Scheme;
import com.hive.core.webview.HiveWebView;
import com.hive.core.webview.HiveWebViewClient;
import com.hive.iapv4.IapWebViewDialog;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.iapv4.market.MarketLebi;
import com.hive.protocol.UrlManager;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.Resource;
import com.hive.ui.Util;
import com.hive.ui.effect.TouchEffectKt;
import com.hive.webview.HiveSchemeHandler;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: IapWebViewDialog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004JKLMBL\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012#\u0010\t\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\r0\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u00109\u001a\u00020\rJ\u0006\u0010:\u001a\u00020\rJ(\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020BH\u0002J\b\u0010D\u001a\u00020*H\u0003J\u0018\u0010E\u001a\u00020B2\u0006\u0010F\u001a\u00020B2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u00020B2\u0006\u0010F\u001a\u00020BH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R.\u0010\t\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\r0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u00060\u001aR\u00020\u0000X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u001a\u0010#\u001a\u00020$X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u000100X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00102\"\u0004\b7\u00104R\u0010\u00108\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/hive/iapv4/IapWebViewDialog;", "", "activity", "Landroid/app/Activity;", "actionType", "Lcom/hive/iapv4/IapWebViewDialog$ACTION_TYPE;", "url", "", "postString", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "<init>", "(Landroid/app/Activity;Lcom/hive/iapv4/IapWebViewDialog$ACTION_TYPE;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getActivity", "()Landroid/app/Activity;", "getActionType", "()Lcom/hive/iapv4/IapWebViewDialog$ACTION_TYPE;", "getUrl", "()Ljava/lang/String;", "getPostString", "getListener", "()Lkotlin/jvm/functions/Function1;", "iapDialog", "Lcom/hive/iapv4/IapWebViewDialog$IAPDialog;", "getIapDialog$hive_iapv4_base_release", "()Lcom/hive/iapv4/IapWebViewDialog$IAPDialog;", "mHandler", "Landroid/os/Handler;", "getMHandler$hive_iapv4_base_release", "()Landroid/os/Handler;", "loadingText", "getLoadingText$hive_iapv4_base_release", "isCancelable", "", "isCancelable$hive_iapv4_base_release", "()Z", "setCancelable$hive_iapv4_base_release", "(Z)V", "mWebView", "Lcom/hive/core/webview/HiveWebView;", "getMWebView$hive_iapv4_base_release", "()Lcom/hive/core/webview/HiveWebView;", "setMWebView$hive_iapv4_base_release", "(Lcom/hive/core/webview/HiveWebView;)V", "mBackButton", "Landroid/widget/ImageView;", "getMBackButton$hive_iapv4_base_release", "()Landroid/widget/ImageView;", "setMBackButton$hive_iapv4_base_release", "(Landroid/widget/ImageView;)V", "mCloseButton", "getMCloseButton$hive_iapv4_base_release", "setMCloseButton$hive_iapv4_base_release", "scheme", "show", "dismiss", "createBaseView", "Landroid/view/View;", "context", "Landroid/content/Context;", "webView", "Landroid/webkit/WebView;", "backImg", "Landroid/graphics/Bitmap;", "closeImg", "createWebView", "adjustOpacity", "bitmap", "opacity", "", "convertBlackNWhite", ShareConstants.ACTION_TYPE, "IAPDialog", "IapSchemeHandler", "WebViewCallBack", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IapWebViewDialog {
    private final ACTION_TYPE actionType;
    private final Activity activity;
    private final IAPDialog iapDialog;
    private boolean isCancelable;
    private final Function1<String, Unit> listener;
    private final String loadingText;
    private ImageView mBackButton;
    private ImageView mCloseButton;
    private final Handler mHandler;
    public HiveWebView mWebView;
    private final String postString;
    private String scheme;
    private final String url;

    /* JADX INFO: compiled from: IapWebViewDialog.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ACTION_TYPE.values().length];
            try {
                iArr[ACTION_TYPE.ACTION_PAYMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ACTION_TYPE.ACTION_LEBISTORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IapWebViewDialog(Activity activity, ACTION_TYPE actionType, String url, String postString, Function1<? super String, Unit> listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(postString, "postString");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.activity = activity;
        this.actionType = actionType;
        this.url = url;
        this.postString = postString;
        this.listener = listener;
        IAPDialog iAPDialog = new IAPDialog(this, activity, android.R.style.Theme.Translucent.NoTitleBar.Fullscreen);
        this.iapDialog = iAPDialog;
        this.mHandler = new Handler(activity.getMainLooper());
        String string = Resource.INSTANCE.getString("hive_iapv4_dialog_loading");
        this.loadingText = string == null ? "Loading..." : string;
        this.isCancelable = true;
        int i = WhenMappings.$EnumSwitchMapping$0[actionType.ordinal()];
        if (i == 1) {
            this.isCancelable = false;
            setMWebView$hive_iapv4_base_release(createWebView());
            iAPDialog.setContentView(getMWebView$hive_iapv4_base_release());
        } else if (i == 2) {
            this.isCancelable = true;
            setMWebView$hive_iapv4_base_release(createWebView());
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(activity.getResources(), android.R.drawable.ic_media_rew);
            Bitmap bitmapDecodeResource2 = BitmapFactory.decodeResource(activity.getResources(), android.R.drawable.ic_menu_close_clear_cancel);
            Intrinsics.checkNotNullExpressionValue(bitmapDecodeResource2, "decodeResource(...)");
            Bitmap bitmapConvertBlackNWhite = convertBlackNWhite(bitmapDecodeResource2);
            HiveWebView mWebView$hive_iapv4_base_release = getMWebView$hive_iapv4_base_release();
            Intrinsics.checkNotNull(bitmapDecodeResource);
            iAPDialog.setContentView(createBaseView(activity, mWebView$hive_iapv4_base_release, bitmapDecodeResource, bitmapConvertBlackNWhite));
        } else {
            iAPDialog.dismiss();
        }
        iAPDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.hive.iapv4.IapWebViewDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                IapWebViewDialog._init_$lambda$0(this.f$0, dialogInterface);
            }
        });
    }

    public final ACTION_TYPE getActionType() {
        return this.actionType;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final Function1<String, Unit> getListener() {
        return this.listener;
    }

    public final String getPostString() {
        return this.postString;
    }

    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: getIapDialog$hive_iapv4_base_release, reason: from getter */
    public final IAPDialog getIapDialog() {
        return this.iapDialog;
    }

    /* JADX INFO: renamed from: getMHandler$hive_iapv4_base_release, reason: from getter */
    public final Handler getMHandler() {
        return this.mHandler;
    }

    /* JADX INFO: renamed from: getLoadingText$hive_iapv4_base_release, reason: from getter */
    public final String getLoadingText() {
        return this.loadingText;
    }

    /* JADX INFO: renamed from: isCancelable$hive_iapv4_base_release, reason: from getter */
    public final boolean getIsCancelable() {
        return this.isCancelable;
    }

    public final void setCancelable$hive_iapv4_base_release(boolean z) {
        this.isCancelable = z;
    }

    public final HiveWebView getMWebView$hive_iapv4_base_release() {
        HiveWebView hiveWebView = this.mWebView;
        if (hiveWebView != null) {
            return hiveWebView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mWebView");
        return null;
    }

    public final void setMWebView$hive_iapv4_base_release(HiveWebView hiveWebView) {
        Intrinsics.checkNotNullParameter(hiveWebView, "<set-?>");
        this.mWebView = hiveWebView;
    }

    /* JADX INFO: renamed from: getMBackButton$hive_iapv4_base_release, reason: from getter */
    public final ImageView getMBackButton() {
        return this.mBackButton;
    }

    public final void setMBackButton$hive_iapv4_base_release(ImageView imageView) {
        this.mBackButton = imageView;
    }

    /* JADX INFO: renamed from: getMCloseButton$hive_iapv4_base_release, reason: from getter */
    public final ImageView getMCloseButton() {
        return this.mCloseButton;
    }

    public final void setMCloseButton$hive_iapv4_base_release(ImageView imageView) {
        this.mCloseButton = imageView;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: IapWebViewDialog.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/hive/iapv4/IapWebViewDialog$ACTION_TYPE;", "", "<init>", "(Ljava/lang/String;I)V", "ACTION_PAYMENT", "ACTION_LEBISTORE", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ACTION_TYPE {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ACTION_TYPE[] $VALUES;
        public static final ACTION_TYPE ACTION_PAYMENT = new ACTION_TYPE("ACTION_PAYMENT", 0);
        public static final ACTION_TYPE ACTION_LEBISTORE = new ACTION_TYPE("ACTION_LEBISTORE", 1);

        private static final /* synthetic */ ACTION_TYPE[] $values() {
            return new ACTION_TYPE[]{ACTION_PAYMENT, ACTION_LEBISTORE};
        }

        public static EnumEntries<ACTION_TYPE> getEntries() {
            return $ENTRIES;
        }

        private ACTION_TYPE(String str, int i) {
        }

        static {
            ACTION_TYPE[] action_typeArr$values = $values();
            $VALUES = action_typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(action_typeArr$values);
        }

        public static ACTION_TYPE valueOf(String str) {
            return (ACTION_TYPE) Enum.valueOf(ACTION_TYPE.class, str);
        }

        public static ACTION_TYPE[] values() {
            return (ACTION_TYPE[]) $VALUES.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(IapWebViewDialog iapWebViewDialog, DialogInterface dialogInterface) {
        iapWebViewDialog.listener.invoke(iapWebViewDialog.scheme);
    }

    public final void show() {
        byte[] bytes;
        getMWebView$hive_iapv4_base_release().setOauthToken(HiveLifecycle.INSTANCE.getAccount().getOauthToken());
        if (StringsKt.isBlank(this.url) && this.actionType == ACTION_TYPE.ACTION_PAYMENT) {
            LoggerImpl.INSTANCE.d("[HiveIAP] IAPWebViewDialog webview local loadData");
            getMWebView$hive_iapv4_base_release().loadData(IapWardCatalog.getShowPaymentLocalHTMLSource(this.activity), "text/html;charset=UTF-8", "UTF-8");
        } else if (!StringsKt.isBlank(this.postString)) {
            try {
                bytes = this.postString.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            } catch (UnsupportedEncodingException e) {
                LoggerImpl.INSTANCE.w("[HiveIAP] IAPWebViewDialog showWebView error: " + e);
                bytes = null;
            }
            LoggerImpl.INSTANCE.dL("[HiveIAP] IAPWebViewDialog webview postUrl: " + this.url + ", postData: " + this.postString);
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            StringBuilder sb = new StringBuilder("[HiveIAP] IAPWebViewDialog webview postUrl: ");
            sb.append(this.url);
            loggerImpl.dR(sb.toString());
            getMWebView$hive_iapv4_base_release().postUrlCI(this.url, bytes);
        } else {
            LoggerImpl.INSTANCE.d("[HiveIAP] IAPWebViewDialog webview loadUrl: " + this.url);
            getMWebView$hive_iapv4_base_release().loadUrlCI(this.url);
        }
        this.activity.runOnUiThread(new Runnable() { // from class: com.hive.iapv4.IapWebViewDialog$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                IapWebViewDialog.show$lambda$1(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$1(IapWebViewDialog iapWebViewDialog) {
        iapWebViewDialog.iapDialog.show();
    }

    public final void dismiss() {
        this.iapDialog.dismiss();
    }

    /* JADX INFO: compiled from: IapWebViewDialog.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/hive/iapv4/IapWebViewDialog$IAPDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "themeResId", "", "<init>", "(Lcom/hive/iapv4/IapWebViewDialog;Landroid/content/Context;I)V", "onBackPressed", "", "onWindowFocusChanged", "hasFocus", "", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class IAPDialog extends Dialog {
        final /* synthetic */ IapWebViewDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IAPDialog(IapWebViewDialog iapWebViewDialog, Context context, int i) {
            super(context, i);
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = iapWebViewDialog;
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            if (this.this$0.getMWebView$hive_iapv4_base_release().canGoBack()) {
                this.this$0.getMWebView$hive_iapv4_base_release().goBack();
                return;
            }
            if (this.this$0.getIsCancelable()) {
                dismiss();
            }
            super.onBackPressed();
        }

        @Override // android.app.Dialog, android.view.Window.Callback
        public void onWindowFocusChanged(boolean hasFocus) {
            super.onWindowFocusChanged(hasFocus);
            if (hasFocus) {
                Util.INSTANCE.hideSystemUI(getWindow());
            }
        }
    }

    private final View createBaseView(Context context, final WebView webView, Bitmap backImg, Bitmap closeImg) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        linearLayout.setGravity(48);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 1.0f));
        imageView.setImageBitmap(backImg);
        TouchEffectKt.setTouchEffect(imageView, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.iapv4.IapWebViewDialog$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IapWebViewDialog.createBaseView$lambda$5$lambda$4(webView, (View) obj);
            }
        } : null);
        this.mBackButton = imageView;
        ImageView imageView2 = new ImageView(context);
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 1.0f));
        imageView2.setImageBitmap(closeImg);
        TouchEffectKt.setTouchEffect(imageView2, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.iapv4.IapWebViewDialog$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IapWebViewDialog.createBaseView$lambda$7$lambda$6(this.f$0, (View) obj);
            }
        } : null);
        this.mCloseButton = imageView2;
        linearLayout2.addView(this.mBackButton);
        linearLayout2.addView(this.mCloseButton);
        linearLayout.addView(linearLayout2);
        linearLayout.addView(webView);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createBaseView$lambda$5$lambda$4(WebView webView, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (webView.canGoBack()) {
            webView.goBack();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createBaseView$lambda$7$lambda$6(IapWebViewDialog iapWebViewDialog, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        iapWebViewDialog.iapDialog.dismiss();
        return Unit.INSTANCE;
    }

    private final HiveWebView createWebView() {
        HiveWebView hiveWebView = new HiveWebView(this.activity);
        hiveWebView.getRequestOptions().setSupportHiveTheme(false);
        hiveWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        hiveWebView.setInitialScale(0);
        hiveWebView.setPadding(0, 0, 0, 0);
        hiveWebView.setWebViewClient(new WebViewCallBack());
        hiveWebView.getSettings().setBuiltInZoomControls(true);
        hiveWebView.getSettings().setJavaScriptEnabled(true);
        hiveWebView.getSettings().setCacheMode(2);
        hiveWebView.setWebChromeClient(new IapWebViewDialog$createWebView$1$1(this));
        return hiveWebView;
    }

    /* JADX INFO: compiled from: IapWebViewDialog.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/hive/iapv4/IapWebViewDialog$IapSchemeHandler;", "Lcom/hive/webview/HiveSchemeHandler;", "<init>", "(Lcom/hive/iapv4/IapWebViewDialog;)V", "schemeEvent", "", "view", "Landroid/webkit/WebView;", "scheme", "Lcom/hive/core/Scheme;", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class IapSchemeHandler extends HiveSchemeHandler {
        public IapSchemeHandler() {
        }

        @Override // com.hive.webview.HiveSchemeHandler
        public boolean schemeEvent(final WebView view, Scheme scheme) {
            ArrayList<String> lebiBlackListUrl;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            LoggerImpl.INSTANCE.d("[HiveIAP] IAPWebViewDialog schemeEvent url : " + scheme);
            try {
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("[HiveIAP] IAPWebViewDialog url scheme error: " + e);
            }
            if (Intrinsics.areEqual("c2s", scheme.getScheme()) && Intrinsics.areEqual("marketSelectResult", scheme.getHost())) {
                IapWebViewDialog.this.scheme = scheme.getUrl();
                IapWebViewDialog.this.getIapDialog().dismiss();
                return true;
            }
            HiveModule hiveModule = null;
            if (Intrinsics.areEqual("gcp", scheme.getScheme()) && Intrinsics.areEqual("purchaseRequest", scheme.getHost())) {
                HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
                String name = MarketLebi.class.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                HiveModule hiveModule2 = hiveModuleManager.getHiveModule(name);
                if (!(hiveModule2 instanceof MarketLebi)) {
                    hiveModule2 = null;
                }
                if (hiveModule2 instanceof MarketLebi) {
                    hiveModule = hiveModule2;
                }
                MarketLebi marketLebi = (MarketLebi) hiveModule;
                if (marketLebi != null) {
                    Activity activity = IapWebViewDialog.this.getActivity();
                    Uri uri = Uri.parse(scheme.getUrl());
                    Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
                    marketLebi.purchaseLebiOnWechat(activity, uri, new MarketLebi.OnWXPayListener() { // from class: com.hive.iapv4.IapWebViewDialog$IapSchemeHandler$schemeEvent$1
                        @Override // com.hive.module.interfaces.iapv4.market.MarketLebi.OnWXPayListener
                        public void onPurchaseSuccess(JSONObject data) {
                            sendResults(data);
                        }

                        @Override // com.hive.module.interfaces.iapv4.market.MarketLebi.OnWXPayListener
                        public void onPurchaseFail(JSONObject data) {
                            sendResults(data);
                        }

                        @Override // com.hive.module.interfaces.iapv4.market.MarketLebi.OnWXPayListener
                        public void onPurchaseCancel(JSONObject data) {
                            sendResults(data);
                        }

                        public final void sendResults(JSONObject data) {
                            try {
                                if (data == null) {
                                    throw new JSONException("json data is null");
                                }
                                String str = ((("wid=" + data.getString("appId")) + "&orderid=" + data.getString("orderId")) + "&isSvc=" + data.getString("isSvc")) + "&errCode=" + data.optString("errCode");
                                Uri uri2 = Uri.parse(UrlManager.LebiWeb.INSTANCE.getCharge());
                                String str2 = (uri2.getScheme() + "://" + uri2.getHost()) + "/cn/cash/wechatpay/callBack.jsp";
                                try {
                                    WebView webView = view;
                                    byte[] bytes = str.getBytes(Charsets.UTF_8);
                                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                                    webView.postUrl(str2, bytes);
                                } catch (UnsupportedEncodingException e2) {
                                    e2.printStackTrace();
                                }
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                        }
                    });
                } else {
                    LoggerImpl.INSTANCE.e("MarketLebi Library Missing.");
                }
                return true;
            }
            HiveModuleManager hiveModuleManager2 = HiveModuleManager.INSTANCE;
            String name2 = MarketLebi.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            HiveModule hiveModule3 = hiveModuleManager2.getHiveModule(name2);
            if (!(hiveModule3 instanceof MarketLebi)) {
                hiveModule3 = null;
            }
            if (!(hiveModule3 instanceof MarketLebi)) {
                hiveModule3 = null;
            }
            MarketLebi marketLebi2 = (MarketLebi) hiveModule3;
            if (marketLebi2 != null && (lebiBlackListUrl = marketLebi2.getLebiBlackListUrl()) != null) {
                int size = lebiBlackListUrl.size();
                for (int i = 0; i < size; i++) {
                    String url = scheme.getUrl();
                    String str = lebiBlackListUrl.get(i);
                    Intrinsics.checkNotNullExpressionValue(str, "get(...)");
                    if (StringsKt.startsWith$default(url, str, false, 2, (Object) null)) {
                        return true;
                    }
                }
            }
            HiveModuleManager hiveModuleManager3 = HiveModuleManager.INSTANCE;
            String name3 = MarketLebi.class.getName();
            Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
            HiveModule hiveModule4 = hiveModuleManager3.getHiveModule(name3);
            if (!(hiveModule4 instanceof MarketLebi)) {
                hiveModule4 = null;
            }
            if (hiveModule4 instanceof MarketLebi) {
                hiveModule = hiveModule4;
            }
            MarketLebi marketLebi3 = (MarketLebi) hiveModule;
            if (marketLebi3 != null) {
                return marketLebi3.alipayInterceptorWithUrl(IapWebViewDialog.this.getActivity(), view, scheme.getUrl(), true);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: IapWebViewDialog.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J,\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0016J \u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0017J\u0018\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0013H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006#"}, d2 = {"Lcom/hive/iapv4/IapWebViewDialog$WebViewCallBack;", "Lcom/hive/core/webview/HiveWebViewClient;", "<init>", "(Lcom/hive/iapv4/IapWebViewDialog;)V", "webProgressDialog", "Landroid/app/ProgressDialog;", "getWebProgressDialog", "()Landroid/app/ProgressDialog;", "webViewTimeoutFlag", "", "getWebViewTimeoutFlag", "()Z", "setWebViewTimeoutFlag", "(Z)V", "onPageStarted", "", "view", "Landroid/webkit/WebView;", "url", "", "favicon", "Landroid/graphics/Bitmap;", "receivedErrorEvent", "errorCode", "", "description", "failingUrl", "onReceivedHttpError", "request", "Landroid/webkit/WebResourceRequest;", "errorResponse", "Landroid/webkit/WebResourceResponse;", "onPageFinished", "findClassForName", "name", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class WebViewCallBack extends HiveWebViewClient {
        private final ProgressDialog webProgressDialog;
        private boolean webViewTimeoutFlag;

        public WebViewCallBack() {
            super(IapWebViewDialog.this.new IapSchemeHandler());
            this.webProgressDialog = new ProgressDialog(IapWebViewDialog.this.getActivity());
        }

        public final ProgressDialog getWebProgressDialog() {
            return this.webProgressDialog;
        }

        public final boolean getWebViewTimeoutFlag() {
            return this.webViewTimeoutFlag;
        }

        public final void setWebViewTimeoutFlag(boolean z) {
            this.webViewTimeoutFlag = z;
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            LoggerImpl.INSTANCE.d("[HiveIAP] IAPWebViewDialog onPageStarted url : " + url);
            this.webViewTimeoutFlag = true;
            final IapWebViewDialog iapWebViewDialog = IapWebViewDialog.this;
            IapWebViewDialog.this.getMHandler().postDelayed(new Runnable() { // from class: com.hive.iapv4.IapWebViewDialog$WebViewCallBack$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    IapWebViewDialog.WebViewCallBack.onPageStarted$lambda$0(this.f$0, iapWebViewDialog);
                }
            }, 10000L);
            this.webProgressDialog.setMessage(IapWebViewDialog.this.getLoadingText());
            this.webProgressDialog.setCancelable(true);
            if (!IapWebViewDialog.this.getActivity().isFinishing() && !this.webProgressDialog.isShowing()) {
                IapWebViewDialog.this.getActivity().runOnUiThread(new Runnable() { // from class: com.hive.iapv4.IapWebViewDialog$WebViewCallBack$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        IapWebViewDialog.WebViewCallBack.onPageStarted$lambda$1(this.f$0);
                    }
                });
            }
            super.onPageStarted(view, url, favicon);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onPageStarted$lambda$0(WebViewCallBack webViewCallBack, IapWebViewDialog iapWebViewDialog) {
            if (webViewCallBack.webViewTimeoutFlag && iapWebViewDialog.getActionType() == ACTION_TYPE.ACTION_PAYMENT) {
                iapWebViewDialog.getMWebView$hive_iapv4_base_release().loadData(IapWardCatalog.getShowPaymentLocalHTMLSource(iapWebViewDialog.getActivity()), "text/html;charset=UTF-8", "UTF-8");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onPageStarted$lambda$1(WebViewCallBack webViewCallBack) {
            webViewCallBack.webProgressDialog.show();
        }

        @Override // com.hive.core.webview.HiveWebViewClient
        public void receivedErrorEvent(WebView view, int errorCode, String description, String failingUrl) {
            Intrinsics.checkNotNullParameter(view, "view");
            LoggerImpl.INSTANCE.w("[HiveIAP] IAPWebViewDialog receivedErrorEvent errorCode: " + errorCode + ", " + description + ", failingUrl: " + failingUrl);
            if (IapWebViewDialog.this.getActionType() == ACTION_TYPE.ACTION_PAYMENT) {
                view.loadData(IapWardCatalog.getShowPaymentLocalHTMLSource(IapWebViewDialog.this.getActivity()), "text/html;charset=UTF-8", "UTF-8");
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
            LoggerImpl.INSTANCE.d("[HiveIAP] IAPWebViewDialog onReceivedHttpError statusCode: " + errorResponse.getStatusCode() + ", failingUrl: " + request.getUrl());
            super.onReceivedHttpError(view, request, errorResponse);
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            Drawable drawable;
            Drawable drawable2;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageFinished(view, url);
            LoggerImpl.INSTANCE.d("[HiveIAP] IAPWebViewDialog WebViewCallBack onPageFinished url: " + url);
            this.webViewTimeoutFlag = false;
            if (this.webProgressDialog.isShowing()) {
                this.webProgressDialog.dismiss();
            }
            if (IapWebViewDialog.this.getMWebView$hive_iapv4_base_release().canGoBack()) {
                if (IapWebViewDialog.this.getMBackButton() != null) {
                    ImageView mBackButton = IapWebViewDialog.this.getMBackButton();
                    if (mBackButton != null) {
                        mBackButton.setEnabled(true);
                    }
                    ImageView mBackButton2 = IapWebViewDialog.this.getMBackButton();
                    if (mBackButton2 == null || (drawable2 = mBackButton2.getDrawable()) == null) {
                        return;
                    }
                    drawable2.clearColorFilter();
                    return;
                }
                return;
            }
            if (IapWebViewDialog.this.getMBackButton() != null) {
                ImageView mBackButton3 = IapWebViewDialog.this.getMBackButton();
                if (mBackButton3 != null) {
                    mBackButton3.setEnabled(false);
                }
                ImageView mBackButton4 = IapWebViewDialog.this.getMBackButton();
                if (mBackButton4 == null || (drawable = mBackButton4.getDrawable()) == null) {
                    return;
                }
                drawable.setColorFilter(-12303292, PorterDuff.Mode.SRC_ATOP);
            }
        }

        private final boolean findClassForName(String name) {
            try {
                Class.forName(name);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    private final Bitmap adjustOpacity(Bitmap bitmap, int opacity) {
        if (!bitmap.isMutable()) {
            bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        }
        new Canvas(bitmap).drawColor((opacity & 255) << 24, PorterDuff.Mode.DST_IN);
        Intrinsics.checkNotNull(bitmap);
        return bitmap;
    }

    private final Bitmap convertBlackNWhite(Bitmap bitmap) {
        Bitmap bitmapCopy = bitmap.isMutable() ? bitmap : bitmap.copy(Bitmap.Config.ARGB_8888, true);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        for (int i = 0; i < width; i++) {
            for (int i2 = 0; i2 < height; i2++) {
                int pixel = bitmapCopy.getPixel(i, i2);
                int iAlpha = Color.alpha(pixel);
                int i3 = 255;
                int i4 = ((int) (((((double) Color.red(pixel)) * 0.2999d) + (((double) Color.green(pixel)) * 0.587d)) + (((double) Color.blue(pixel)) * 0.114d))) > 128 ? 255 : 0;
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
}
