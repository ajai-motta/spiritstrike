package com.unity3d.services.ads.webplayer;

import android.webkit.JavascriptInterface;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes6.dex */
public class WebPlayerBridgeInterface {
    private final String viewId;

    public WebPlayerBridgeInterface(String str) {
        this.viewId = str;
    }

    @JavascriptInterface
    public void handleEvent(String str) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (WebViewApp.getCurrentApp() != null) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.WEBPLAYER_EVENT, str, this.viewId);
        }
    }
}
