package com.bytedance.sdk.component.adexpress.mzz;

import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class lnr {
    private WeakReference<ud> qdl;

    public lnr(ud udVar) {
        this.qdl = new WeakReference<>(udVar);
    }

    public void qdl(ud udVar) {
        this.qdl = new WeakReference<>(udVar);
    }

    @JavascriptInterface
    public String adInfo() {
        WeakReference<ud> weakReference = this.qdl;
        if (weakReference != null && weakReference.get() != null) {
            return this.qdl.get().adInfo();
        }
        return "";
    }

    @JavascriptInterface
    public String appInfo() {
        WeakReference<ud> weakReference = this.qdl;
        if (weakReference != null && weakReference.get() != null) {
            return this.qdl.get().appInfo();
        }
        return "";
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        WeakReference<ud> weakReference = this.qdl;
        if (weakReference != null && weakReference.get() != null) {
            return this.qdl.get().getTemplateInfo();
        }
        return "";
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        WeakReference<ud> weakReference = this.qdl;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.qdl.get().renderDidFinish(str);
    }

    @JavascriptInterface
    public void adAnalysisData(String str) {
        WeakReference<ud> weakReference = this.qdl;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.qdl.get();
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        WeakReference<ud> weakReference = this.qdl;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.qdl.get().muteVideo(str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        WeakReference<ud> weakReference = this.qdl;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.qdl.get().dynamicTrack(str);
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        WeakReference<ud> weakReference = this.qdl;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.qdl.get().changeVideoState(str);
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        WeakReference<ud> weakReference = this.qdl;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.qdl.get().clickEvent(str);
    }

    @JavascriptInterface
    public void skipVideo() {
        WeakReference<ud> weakReference = this.qdl;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.qdl.get().skipVideo();
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        WeakReference<ud> weakReference = this.qdl;
        if (weakReference != null && weakReference.get() != null) {
            return this.qdl.get().getCurrentVideoState();
        }
        return "";
    }

    @JavascriptInterface
    public void initRenderFinish() {
        WeakReference<ud> weakReference = this.qdl;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.qdl.get().initRenderFinish();
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        WeakReference<ud> weakReference = this.qdl;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.qdl.get().qdl(str);
    }

    @JavascriptInterface
    public String getData(String str) {
        WeakReference<ud> weakReference = this.qdl;
        if (weakReference != null && weakReference.get() != null) {
            return this.qdl.get().getData(str);
        }
        return "";
    }

    @JavascriptInterface
    public void videoFrameChanged(String str) {
        WeakReference<ud> weakReference = this.qdl;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.qdl.get().videoFrameChanged(str);
    }
}
