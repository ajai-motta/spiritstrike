package com.bytedance.sdk.openadsdk.mml;

import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class tvp {
    private final WebView jpc;
    private int mo;
    private final boolean mzz;
    private final ljh qdl;
    private long to;
    private int wd;
    private String tvp = "landingpage";
    private final Map<Integer, Long> ud = new HashMap();
    private final List<Integer> lnr = new ArrayList();
    private final Map<Integer, String> mml = new HashMap();

    public tvp(ljh ljhVar, WebView webView, boolean z) {
        this.qdl = ljhVar;
        this.jpc = webView;
        this.mzz = z;
    }

    public void qdl(String str, int i) {
        if (this.mzz) {
            i++;
        }
        if (qdl(true)) {
            lnr.qdl(this.qdl, this.tvp, this.mo, str, i);
            this.mml.put(Integer.valueOf(this.mo), str);
            this.to = SystemClock.elapsedRealtime();
        }
    }

    public void qdl(String str) {
        if (qdl(false)) {
            lnr.qdl(this.qdl, this.tvp, this.mo, str, SystemClock.elapsedRealtime() - this.to);
        }
    }

    public void qdl(WebView webView, String str) {
        ljh ljhVar = this.qdl;
        if (ljhVar == null || !com.bytedance.sdk.component.tvp.ud.qdl(ljhVar.jyq().lnr(), str)) {
            return;
        }
        String str2 = this.mml.get(Integer.valueOf(this.mo));
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        lnr.qdl(this.qdl, this.tvp, this.mo, str2, str, 2);
    }

    public void ud(String str) {
        String str2 = this.mml.get(Integer.valueOf(this.mo));
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        String str3 = str2;
        int i = this.mo;
        if (i > 0) {
            lnr.qdl(this.qdl, this.tvp, i, str3, str, 1);
        }
    }

    private boolean qdl(boolean z) {
        int i = z ? this.mo : this.wd;
        ud(z);
        int i2 = z ? this.mo : this.wd;
        return i2 > 0 && i2 != i;
    }

    private void ud(boolean z) {
        try {
            WebBackForwardList webBackForwardListCopyBackForwardList = this.jpc.copyBackForwardList();
            if (webBackForwardListCopyBackForwardList != null) {
                if (z) {
                    int currentIndex = webBackForwardListCopyBackForwardList.getCurrentIndex();
                    this.mo = currentIndex + 1;
                    if (this.mzz) {
                        this.mo = currentIndex + 2;
                        return;
                    }
                    return;
                }
                int currentIndex2 = webBackForwardListCopyBackForwardList.getCurrentIndex();
                this.wd = currentIndex2 + 1;
                if (this.mzz) {
                    this.wd = currentIndex2 + 2;
                }
            }
        } catch (Throwable th) {
            aaj.lnr("ArbitrageLandingLog", th.toString());
        }
    }

    public void lnr(String str) {
        this.tvp = str;
    }
}
