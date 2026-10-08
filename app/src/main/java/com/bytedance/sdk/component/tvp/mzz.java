package com.bytedance.sdk.component.tvp;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.tvp.mo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class mzz extends WebView {
    private boolean lnr;
    private boolean mml;
    private lnr mo;
    private boolean mzz;
    public long qdl;
    private final HashSet<String> ud;

    public mzz(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ud = new HashSet<>();
        this.qdl = System.currentTimeMillis();
        ud();
    }

    public mzz(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ud = new HashSet<>();
        this.qdl = System.currentTimeMillis();
        ud();
    }

    public void setTouchListenerProxy(lnr lnrVar) {
        this.mo = lnrVar;
    }

    private void ud() {
        WebSettings settings = getSettings();
        settings.setSupportZoom(false);
        settings.setDisplayZoomControls(false);
        settings.setBuiltInZoomControls(false);
        settings.setSupportMultipleWindows(false);
        settings.setAllowFileAccess(false);
        settings.setSavePassword(false);
        setWebViewClient(new mo.qdl());
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(Object obj, String str) {
        toString();
        if (this.lnr || this.mzz) {
            return;
        }
        super.addJavascriptInterface(obj, str);
        this.ud.add(str);
    }

    @Override // android.webkit.WebView
    public void removeJavascriptInterface(String str) {
        if (this.lnr || this.mzz) {
            return;
        }
        super.removeJavascriptInterface(str);
        this.ud.remove(str);
    }

    @Override // android.webkit.WebView
    public void onPause() {
        if (this.lnr || this.mzz) {
            return;
        }
        try {
            super.onPause();
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void onResume() {
        if (this.lnr || this.mzz) {
            return;
        }
        try {
            super.onResume();
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        if (this.lnr || this.mzz) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void reload() {
        if (this.lnr || this.mzz) {
            return;
        }
        super.reload();
    }

    @Override // android.webkit.WebView
    public void goBack() {
        if (this.lnr || this.mzz) {
            return;
        }
        super.goBack();
    }

    @Override // android.webkit.WebView
    public void goForward() {
        if (this.lnr || this.mzz) {
            return;
        }
        super.goForward();
    }

    @Override // android.webkit.WebView
    public void goBackOrForward(int i) {
        if (this.lnr || this.mzz) {
            return;
        }
        super.goBackOrForward(i);
    }

    @Override // android.webkit.WebView
    public void clearCache(boolean z) {
        if (this.lnr || this.mzz) {
            return;
        }
        super.clearCache(z);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        if (this.lnr || this.mzz) {
            return;
        }
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError unused) {
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        if (this.lnr || this.mzz) {
            return;
        }
        try {
            super.loadUrl(str, map);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError unused) {
        }
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.lnr || this.mzz) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.lnr || this.mzz) {
            return;
        }
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // android.webkit.WebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!this.lnr && !this.mzz) {
            super.evaluateJavascript(str, valueCallback);
        } else if (valueCallback != null) {
            valueCallback.onReceiveValue("");
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        toString();
    }

    public void setDestroyOnDetached(boolean z) {
        this.mml = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        toString();
        if (this.mml) {
            destroy();
        }
    }

    @Override // android.webkit.WebView
    public void resumeTimers() {
        if (this.lnr || this.mzz) {
            return;
        }
        super.resumeTimers();
    }

    @Override // android.webkit.WebView
    public void pauseTimers() {
        if (this.lnr || this.mzz) {
            return;
        }
        super.pauseTimers();
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.lnr || this.mzz) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        toString();
        if (this.lnr) {
            return;
        }
        this.lnr = true;
        qdl();
        super.destroy();
    }

    public void qdl() {
        if (this.lnr) {
            return;
        }
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
        setOnClickListener(null);
        setOnTouchListener(null);
        Iterator<String> it = this.ud.iterator();
        while (it.hasNext()) {
            super.removeJavascriptInterface(it.next());
        }
    }

    public void setRecycler(boolean z) {
        this.mzz = z;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        lnr lnrVar = this.mo;
        if (lnrVar == null) {
            super.setOnTouchListener(onTouchListener);
        } else {
            lnrVar.qdl(onTouchListener);
            super.setOnTouchListener(this.mo);
        }
    }
}
