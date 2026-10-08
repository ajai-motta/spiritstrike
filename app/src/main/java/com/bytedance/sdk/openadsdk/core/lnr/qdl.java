package com.bytedance.sdk.openadsdk.core.lnr;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.jl;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.tvp.jpc;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.bytedance.sdk.openadsdk.utils.jtx;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class qdl extends ud {
    private int fco;
    private WeakReference<InterfaceC0238qdl> hkc;
    private boolean hzv;
    private boolean lnr;
    private boolean qdl;
    private boolean ud;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.lnr.qdl$qdl, reason: collision with other inner class name */
    public interface InterfaceC0238qdl {
        long getVideoProgress();
    }

    public boolean lnr() {
        return false;
    }

    public boolean ud() {
        return false;
    }

    public qdl(Context context, ljh ljhVar, String str, int i) {
        super(context, ljhVar, str, i);
        this.qdl = true;
        this.ud = false;
        this.lnr = false;
        this.hzv = false;
    }

    public void qdl(boolean z) {
        this.qdl = z;
    }

    public void ud(boolean z) {
        this.ud = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0368 A[Catch: Exception -> 0x037d, TryCatch #0 {Exception -> 0x037d, blocks: (B:190:0x035b, B:192:0x0364, B:196:0x037a, B:194:0x0368), top: B:220:0x035b }] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x037a A[Catch: Exception -> 0x037d, TRY_LEAVE, TryCatch #0 {Exception -> 0x037d, blocks: (B:190:0x035b, B:192:0x0364, B:196:0x037a, B:194:0x0368), top: B:220:0x035b }] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0103  */
    @Override // com.bytedance.sdk.openadsdk.core.lnr.ud, com.bytedance.sdk.openadsdk.core.lnr.lnr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void qdl(android.view.View r31, float r32, float r33, float r34, float r35, android.util.SparseArray<com.bytedance.sdk.openadsdk.core.lnr.lnr.qdl> r36, boolean r37) {
        /*
            Method dump skipped, instruction units count: 972
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.lnr.qdl.qdl(android.view.View, float, float, float, float, android.util.SparseArray, boolean):void");
    }

    protected boolean qdl() {
        ljh ljhVar = this.mo;
        if (ljhVar == null) {
            return true;
        }
        int iUd = yt.mml().ud(ljhVar.fz());
        int iLnr = jl.lnr(yt.qdl());
        if (iUd == 1) {
            return gy.mml(iLnr);
        }
        if (iUd == 2) {
            return gy.mzz(iLnr) || gy.mml(iLnr) || gy.mo(iLnr);
        }
        if (iUd != 3) {
            return iUd != 5 || gy.mml(iLnr) || gy.mo(iLnr);
        }
        return false;
    }

    private boolean wd() {
        ljh ljhVar = this.mo;
        return ljh.mzz(ljhVar) && ljhVar.kab() == 1;
    }

    private boolean lnr(View view) {
        if (view == null) {
            return false;
        }
        if ((view instanceof com.bytedance.sdk.openadsdk.core.exu.ud.mo) || view.getId() == jtx.tdy || view.getId() == jtx.ax || view.getId() == jtx.ag || view.getId() == jtx.wc || view.getId() == jtx.om || view.getId() == 520093726 || view.getId() == jtx.hd) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return false;
            }
            if (lnr(viewGroup.getChildAt(i))) {
                return true;
            }
            i++;
        }
    }

    private boolean jpc() {
        return this instanceof jpc;
    }

    private boolean tvp() {
        ljh ljhVar = this.mo;
        if (ljhVar == null || jpc()) {
            return false;
        }
        if (ljhVar.vxg() != 5 && ljhVar.vxg() != 15) {
            return false;
        }
        if (this.fco == 0) {
            this.fco = ljhVar.vz();
        }
        ud();
        qdl();
        lnr();
        if (this.fco == 5 && wd() && qdl() && !ud() && !lnr()) {
            return false;
        }
        int i = this.fco;
        return i == 1 || i == 2 || i == 5;
    }

    private String ud(String str) {
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return "banner_call";
            case "open_ad":
                return "open_ad";
            case "embeded_ad":
                return "feed_call";
            case "interaction":
                return "interaction_call";
            case "slide_banner_ad":
                return "banner_call";
            default:
                return "";
        }
    }

    public void lnr(boolean z) {
        this.lnr = z;
    }

    public void qdl(InterfaceC0238qdl interfaceC0238qdl) {
        this.hkc = new WeakReference<>(interfaceC0238qdl);
    }

    public void mml(boolean z) {
        this.hzv = z;
    }
}
