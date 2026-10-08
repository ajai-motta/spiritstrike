package com.bytedance.adsdk.ugeno.qdl;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class mo {
    private Context lnr;
    private com.bytedance.adsdk.ugeno.ud.lnr mml;
    private List<lnr> qdl;
    private List<qdl> ud;

    public mo(Context context, com.bytedance.adsdk.ugeno.ud.lnr lnrVar, List<lnr> list) {
        this.mml = lnrVar;
        this.lnr = context;
        this.qdl = list;
        mml();
    }

    private void mml() {
        this.ud = new ArrayList();
        List<lnr> list = this.qdl;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.qdl.size(); i++) {
            lnr lnrVar = this.qdl.get(i);
            if (lnrVar != null) {
                this.ud.add(new qdl(this.lnr, this.mml, lnrVar));
            }
        }
    }

    public void qdl() {
        List<qdl> list = this.ud;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (qdl qdlVar : this.ud) {
            if (qdlVar != null) {
                qdlVar.mml();
            }
        }
    }

    public void ud() {
        List<qdl> list = this.ud;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (qdl qdlVar : this.ud) {
            if (qdlVar != null) {
                qdlVar.qdl();
            }
        }
    }

    public void lnr() {
        List<qdl> list = this.ud;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (qdl qdlVar : this.ud) {
            if (qdlVar != null) {
                qdlVar.lnr();
            }
        }
    }

    public void qdl(Canvas canvas) {
        List<qdl> list = this.ud;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (qdl qdlVar : this.ud) {
            if (qdlVar != null) {
                qdlVar.qdl(canvas);
            }
        }
    }

    public void ud(Canvas canvas) {
        List<qdl> list = this.ud;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (qdl qdlVar : this.ud) {
            if (qdlVar != null) {
                qdlVar.ud(canvas);
            }
        }
    }

    public void qdl(int i, int i2) {
        List<qdl> list = this.ud;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (qdl qdlVar : this.ud) {
            if (qdlVar != null) {
                qdlVar.qdl(i, i2);
            }
        }
    }

    public qdl qdl(String str) {
        List<qdl> list = this.ud;
        if (list != null && !list.isEmpty()) {
            for (qdl qdlVar : this.ud) {
                if (qdlVar != null && TextUtils.equals(qdlVar.mzz(), str)) {
                    return qdlVar;
                }
            }
        }
        return null;
    }
}
