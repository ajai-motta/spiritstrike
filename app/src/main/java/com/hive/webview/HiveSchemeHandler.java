package com.hive.webview;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebView;
import com.facebook.share.internal.ShareConstants;
import com.hive.core.Logger;
import com.hive.core.Scheme;
import com.hive.core.webview.HiveWebView;
import com.hive.core.webview.SchemeHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/hive/webview/HiveSchemeHandler;", "Lcom/hive/core/webview/SchemeHandler;", "<init>", "()V", "handle", "", "view", "Landroid/webkit/WebView;", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "schemeEvent", "scheme", "Lcom/hive/core/Scheme;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class HiveSchemeHandler implements SchemeHandler {
    @Override // com.hive.core.webview.SchemeHandler
    public final boolean handle(WebView view, Uri uri) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Scheme scheme = new Scheme(uri);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (new CommonSchemeHandler(scheme, context).execute()) {
            Logger.INSTANCE.d("[HiveSchemeHandler] common scheme handling");
            return true;
        }
        Scheme scheme2 = new Scheme(uri);
        Logger.INSTANCE.d("[HiveSchemeHandler] schemeEvent : " + scheme2);
        Unit unit = Unit.INSTANCE;
        boolean zSchemeEvent = schemeEvent(view, scheme2);
        if (!zSchemeEvent && (view instanceof HiveWebView)) {
            HiveWebView.Companion companion = HiveWebView.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(uri.toString(), "toString(...)");
            ((HiveWebView) view).blacklistDomain(!companion.isWhitelistDomain(r7));
        }
        return zSchemeEvent;
    }

    public boolean schemeEvent(WebView view, Scheme scheme) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        return false;
    }
}
