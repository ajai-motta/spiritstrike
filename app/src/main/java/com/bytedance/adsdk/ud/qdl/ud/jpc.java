package com.bytedance.adsdk.ud.qdl.ud;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class jpc {
    private final List<com.bytedance.adsdk.ud.lnr.ud.jpc> lnr;
    private final List<qdl<com.bytedance.adsdk.ud.lnr.ud.rdp, Path>> qdl;
    private final List<qdl<Integer, Integer>> ud;

    public jpc(List<com.bytedance.adsdk.ud.lnr.ud.jpc> list) {
        this.lnr = list;
        this.qdl = new ArrayList(list.size());
        this.ud = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.qdl.add(list.get(i).ud().qdl());
            this.ud.add(list.get(i).lnr().qdl());
        }
    }

    public List<com.bytedance.adsdk.ud.lnr.ud.jpc> qdl() {
        return this.lnr;
    }

    public List<qdl<com.bytedance.adsdk.ud.lnr.ud.rdp, Path>> ud() {
        return this.qdl;
    }

    public List<qdl<Integer, Integer>> lnr() {
        return this.ud;
    }
}
