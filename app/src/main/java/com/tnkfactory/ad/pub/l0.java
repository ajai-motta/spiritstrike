package com.tnkfactory.ad.pub;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes6.dex */
public class l0 extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f3151a;
    public k0 b;
    public boolean c;
    public final q4 d;
    public boolean e;

    public l0(Context context) {
        super(context);
        this.f3151a = null;
        this.b = null;
        this.c = false;
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDefaultTextEncodingName("utf-8");
        int i = Build.VERSION.SDK_INT;
        getSettings().setMixedContentMode(0);
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        if (i >= 26) {
            getSettings().setSafeBrowsingEnabled(false);
        }
        setFocusableInTouchMode(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setScrollContainer(false);
        setWebChromeClient(new g0());
        setWebViewClient(new j0(this));
        this.d = new q4(context);
        setOnTouchListener(new h0(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPageIndex() {
        String str = (String) getTag();
        if (str == null) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public boolean a(String str) {
        Handler handler;
        if (this.c) {
            return true;
        }
        p4 p4Var = this.d.f3182a;
        p4Var.getClass();
        boolean z = System.currentTimeMillis() - p4Var.f3177a < 500;
        p4Var.f3177a = 0L;
        if (z && (handler = this.f3151a) != null) {
            this.f3151a.sendMessage(handler.obtainMessage(9, getPageIndex(), 0, str));
        }
        return true;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        setLifeCycle(i);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        setLifeCycle(i);
    }

    public void setHandler(Handler handler) {
        this.f3151a = handler;
    }

    public void setLifeCycle(int i) {
        if (i != 0) {
            this.e = true;
            onPause();
        } else if (this.e) {
            this.e = false;
            onResume();
        }
    }

    public void setPageListener(k0 k0Var) {
        this.b = k0Var;
    }
}
