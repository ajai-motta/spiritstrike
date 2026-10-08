package com.hive.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.hive.ResultAPI;
import com.hive.core.ExtentionsKt;
import com.hive.core.Logger;
import com.hive.core.Scheme;
import com.hive.platformhelper.InAppBrowser;
import com.hive.platformhelper.InAppBrowserData;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/hive/webview/CommonSchemeHandler;", "Lcom/hive/webview/CommonScheme;", "scheme", "Lcom/hive/core/Scheme;", "context", "Landroid/content/Context;", "<init>", "(Lcom/hive/core/Scheme;Landroid/content/Context;)V", "getScheme", "()Lcom/hive/core/Scheme;", "getContext", "()Landroid/content/Context;", "execute", "", "gobrowser", "", "inappbrowser", "sendsms", "sharesns", "getpicture", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonSchemeHandler implements CommonScheme {
    private static final String COMMON_SCHEME = "hiveclient";
    private final Context context;
    private final Scheme scheme;

    public CommonSchemeHandler(Scheme scheme, Context context) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(context, "context");
        this.scheme = scheme;
        this.context = context;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final boolean execute() {
        try {
            String scheme = this.scheme.getScheme();
            if (scheme == null) {
                throw new IllegalStateException("scheme is null.");
            }
            String host = this.scheme.getHost();
            if (host == null) {
                throw new IllegalStateException("host is null.");
            }
            if (!Intrinsics.areEqual(scheme, COMMON_SCHEME)) {
                return false;
            }
            switch (host.hashCode()) {
                case -1205534488:
                    if (host.equals("getpicture")) {
                        getpicture();
                        return true;
                    }
                    break;
                case -1154856640:
                    if (host.equals("gobrowser")) {
                        gobrowser();
                        return true;
                    }
                    break;
                case -743740103:
                    if (host.equals("sharesns")) {
                        sharesns();
                        return true;
                    }
                    break;
                case 191421644:
                    if (host.equals("inappbrowser")) {
                        inappbrowser();
                        return true;
                    }
                    break;
                case 1979932881:
                    if (host.equals("sendsms")) {
                        sendsms();
                        return true;
                    }
                    break;
            }
            Logger.INSTANCE.d("[SchemeController] This host(" + host + ") is not supported.");
            return true;
        } catch (Exception e) {
            Logger.INSTANCE.w("[SchemeController] execute() Exception.\nMessage: " + e.getMessage());
            return false;
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final Scheme getScheme() {
        return this.scheme;
    }

    @Override // com.hive.webview.CommonScheme
    public void getpicture() {
        Logger.INSTANCE.d("[SchemeController] getpicture(). This is not yet supported.");
    }

    @Override // com.hive.webview.CommonScheme
    public void gobrowser() {
        Logger.INSTANCE.d("[SchemeController] gobrowser().");
        try {
            String str = this.scheme.getParameter().get("url");
            if (str == null) {
                throw new IllegalStateException("url is null.");
            }
            String strDecode = URLDecoder.decode(str, Charsets.UTF_8.name());
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(strDecode));
            ExtentionsKt.startActivityCatching$default(this.context, intent, null, 2, null);
        } catch (Exception e) {
            Logger.INSTANCE.w("[SchemeController] gobrowser()\nException: " + e.getMessage());
        }
    }

    @Override // com.hive.webview.CommonScheme
    public void inappbrowser() {
        Logger.INSTANCE.d("[SchemeController] inappbrowser().");
        try {
            String str = this.scheme.getParameter().get("url");
            if (str == null) {
                throw new IllegalStateException("url is null.");
            }
            Charset charset = Charsets.UTF_8;
            String strDecode = URLDecoder.decode(str, charset.name());
            String strDecode2 = null;
            try {
                String str2 = this.scheme.getParameter().get("navigation_color");
                if (str2 != null) {
                    strDecode2 = URLDecoder.decode(str2, charset.name());
                }
            } catch (Exception e) {
                Logger.INSTANCE.w("[SchemeController] inappbrowser() decodedColor parse\nException: " + e.getMessage());
            }
            Intrinsics.checkNotNull(strDecode);
            InAppBrowser.INSTANCE.show(this.context, new InAppBrowserData(strDecode, true, strDecode2, null, null, 24, null), new InAppBrowser.InAppBrowserListener() { // from class: com.hive.webview.CommonSchemeHandler.inappbrowser.1
                @Override // com.hive.platformhelper.InAppBrowser.InAppBrowserListener
                public void onInAppBrowser(ResultAPI result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Logger.INSTANCE.d("[SchemeController] inappbrowser resultAPI = " + result);
                }
            });
        } catch (Exception e2) {
            Logger.INSTANCE.w("[SchemeController] inappbrowser() decodedUrl parse\nException: " + e2.getMessage());
        }
    }

    @Override // com.hive.webview.CommonScheme
    public void sendsms() {
        Logger.INSTANCE.d("[SchemeController] sendsms(). This is not yet supported.");
    }

    @Override // com.hive.webview.CommonScheme
    public void sharesns() {
        Logger.INSTANCE.d("[SchemeController] sharesns(). This is not yet supported.");
    }
}
