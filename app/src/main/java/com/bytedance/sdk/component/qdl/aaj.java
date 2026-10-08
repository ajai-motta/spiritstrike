package com.bytedance.sdk.component.qdl;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes3.dex */
public class aaj extends qdl {
    static final /* synthetic */ boolean to = true;
    protected String jpc;
    protected WebView tvp;

    @Override // com.bytedance.sdk.component.qdl.qdl
    protected Context qdl(tvp tvpVar) {
        if (tvpVar.mzz != null) {
            return tvpVar.mzz;
        }
        if (tvpVar.qdl != null) {
            return tvpVar.qdl.getContext();
        }
        throw new IllegalStateException("WebView cannot be null!");
    }

    @Override // com.bytedance.sdk.component.qdl.qdl
    protected String qdl() {
        return this.tvp.getUrl();
    }

    @Override // com.bytedance.sdk.component.qdl.qdl
    protected void ud(tvp tvpVar) {
        this.tvp = tvpVar.qdl;
        this.jpc = tvpVar.lnr;
        if (tvpVar.exu) {
            return;
        }
        lnr();
    }

    protected void lnr() {
        if (!to && this.tvp == null) {
            throw new AssertionError();
        }
        this.tvp.addJavascriptInterface(this, this.jpc);
    }

    @Override // com.bytedance.sdk.component.qdl.qdl
    @JavascriptInterface
    public void invokeMethod(String str) {
        super.invokeMethod(str);
    }

    @Override // com.bytedance.sdk.component.qdl.qdl
    protected void ud() {
        super.ud();
        mml();
    }

    protected void mml() {
        this.tvp.removeJavascriptInterface(this.jpc);
    }

    @Override // com.bytedance.sdk.component.qdl.qdl
    protected void qdl(String str, rdp rdpVar) {
        if (rdpVar != null && !TextUtils.isEmpty(rdpVar.jpc)) {
            String str2 = rdpVar.jpc;
            qdl(str, String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Base64.encodeToString(String.format("iframe[src=\"%s\"", str2).getBytes(), 2), str, Base64.encodeToString(str2.getBytes(), 2)));
            return;
        }
        super.qdl(str, rdpVar);
    }

    @Override // com.bytedance.sdk.component.qdl.qdl
    protected void qdl(String str) {
        qdl(str, "javascript:" + this.jpc + "._handleMessageFromToutiao(" + str + ")");
    }

    private void qdl(String str, final String str2) {
        if (this.mo || TextUtils.isEmpty(str2)) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.qdl.aaj.1
            @Override // java.lang.Runnable
            public void run() {
                if (aaj.this.mo) {
                    return;
                }
                try {
                    aaj.this.tvp.evaluateJavascript(str2, null);
                } catch (Throwable unused) {
                }
            }
        };
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mml.post(runnable);
        } else {
            runnable.run();
        }
    }
}
