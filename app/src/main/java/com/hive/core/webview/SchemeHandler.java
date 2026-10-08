package com.hive.core.webview;

import android.net.Uri;
import android.webkit.WebView;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: SchemeHandler.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/core/webview/SchemeHandler;", "", "handle", "", "view", "Landroid/webkit/WebView;", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface SchemeHandler {
    boolean handle(WebView view, Uri uri);
}
