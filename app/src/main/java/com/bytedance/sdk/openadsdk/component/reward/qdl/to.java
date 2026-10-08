package com.bytedance.sdk.openadsdk.component.reward.qdl;

import android.R;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.openadsdk.bch.ud.mzz;
import com.bytedance.sdk.openadsdk.component.reward.qdl.mml;
import com.bytedance.sdk.openadsdk.core.lnr.lnr;
import com.bytedance.sdk.openadsdk.core.lnr.qdl;
import com.bytedance.sdk.openadsdk.core.model.fs;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class to {
    private final com.bytedance.sdk.openadsdk.core.lnr.mzz lnr;
    private final qdl qdl;
    private final com.bytedance.sdk.openadsdk.core.lnr.ud ud;

    public to(qdl qdlVar) {
        this.qdl = qdlVar;
        this.lnr = qdl(qdlVar, qdlVar.ud);
        this.ud = new com.bytedance.sdk.openadsdk.core.lnr.ud(qdlVar.ag, qdlVar.ud, qdlVar.mzz, qdlVar.mml ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.component.reward.qdl.to.1
            @Override // com.bytedance.sdk.openadsdk.core.lnr.ud, com.bytedance.sdk.openadsdk.core.lnr.lnr
            public void qdl(View view, float f, float f2, float f3, float f4, SparseArray<lnr.qdl> sparseArray, boolean z) {
                try {
                    to.this.qdl(view, f, f2, f3, f4, sparseArray, this.koa, this.xmv, this.bqt);
                } catch (Exception e) {
                    aaj.lnr("TTAD.RFReportManager", "onClickReport error :" + e.getMessage());
                }
                com.bytedance.sdk.openadsdk.bch.ud.mzz.qdl(to.this.qdl.ud, 9);
                to.this.qdl.bch.ag();
            }
        };
    }

    public void qdl() {
        com.bytedance.sdk.openadsdk.core.fs.mml mmlVarQdl;
        if (this.qdl.exu.get()) {
            return;
        }
        if (this.qdl.lq == null || !this.qdl.lq.cx().bch() || this.qdl.irn || this.qdl.lq.taz()) {
            JSONObject jSONObject = new JSONObject();
            ljh ljhVar = this.qdl.ud;
            JSONObject jSONObjectJpc = jpc();
            if (this.qdl.exu.compareAndSet(false, true)) {
                com.bytedance.sdk.openadsdk.mml.lnr.qdl(ljhVar, this.qdl.mzz, jSONObject, jSONObjectJpc);
                this.qdl.wc.rq();
                mzz.qdl qdlVar = new mzz.qdl(-1);
                qdl(qdlVar);
                com.bytedance.sdk.openadsdk.bch.ud.mzz.qdl(this.qdl.ag.findViewById(R.id.content), ljhVar, qdlVar);
                com.bytedance.sdk.openadsdk.bch.qdl.lnr.qdl(ljhVar);
                com.bytedance.sdk.openadsdk.core.model.mml mmlVarZm = ljhVar.zm();
                if (mmlVarZm == null || (mmlVarQdl = mmlVarZm.qdl()) == null) {
                    return;
                }
                mmlVarQdl.qdl(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject jpc() {
        if (!this.qdl.ra || this.qdl.lq == null) {
            return null;
        }
        try {
            return com.bytedance.sdk.openadsdk.mml.lnr.qdl(this.qdl.lq.rq + 1);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void ud() {
        boolean z;
        if (this.qdl.exu.get()) {
            return;
        }
        if (this.qdl.lq == null || !this.qdl.lq.cx().bch() || this.qdl.irn || this.qdl.lq.taz()) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (this.qdl.ud.mo() && this.qdl.bqt != null && this.qdl.ud.dk() == 2) {
                    jSONObject.put("dynamic_show_type", this.qdl.bqt.rq());
                    this.qdl.bqt.qdl(jSONObject);
                    z = true;
                } else {
                    z = false;
                }
                ljh ljhVar = this.qdl.ud;
                JSONObject jSONObjectJpc = jpc();
                View viewFindViewById = this.qdl.ag.findViewById(R.id.content);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, viewFindViewById.getWidth());
                    jSONObject2.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, viewFindViewById.getHeight());
                    jSONObject2.put("alpha", viewFindViewById.getAlpha());
                } catch (Throwable unused) {
                }
                jSONObject.put("root_view", jSONObject2.toString());
                if (this.qdl.exu.compareAndSet(false, true)) {
                    com.bytedance.sdk.openadsdk.mml.lnr.qdl(ljhVar, this.qdl.mzz, jSONObject, jSONObjectJpc);
                    this.qdl.wc.rq();
                    mzz.qdl qdlVar = new mzz.qdl(z ? this.qdl.bqt.rq() : -1);
                    qdl(qdlVar);
                    com.bytedance.sdk.openadsdk.bch.ud.mzz.qdl(this.qdl.ag.findViewById(R.id.content), ljhVar, qdlVar);
                    com.bytedance.sdk.openadsdk.bch.qdl.lnr.qdl(ljhVar);
                }
            } catch (JSONException e) {
                aaj.qdl("TTAD.RFReportManager", "reportShowWhenBindVideoAd error", e);
            }
        }
    }

    public void qdl(final Map<String, Object> map) {
        if (this.qdl.exu.get()) {
            return;
        }
        if (this.qdl.lq == null || !this.qdl.lq.cx().bch() || this.qdl.irn || this.qdl.lq.taz()) {
            this.qdl.exu.set(true);
            final View viewFindViewById = this.qdl.ag.findViewById(R.id.content);
            if (viewFindViewById == null) {
                viewFindViewById = this.qdl.ag.getWindow().getDecorView();
            }
            viewFindViewById.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.qdl.to.2
                @Override // java.lang.Runnable
                public void run() {
                    Map map2;
                    JSONObject jSONObject;
                    ljh ljhVar = to.this.qdl.ud;
                    JSONObject jSONObject2 = null;
                    try {
                        if (map != null) {
                            jSONObject = new JSONObject(map);
                        } else {
                            jSONObject = new JSONObject();
                        }
                        jSONObject2 = jSONObject;
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, viewFindViewById.getWidth());
                        jSONObject3.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, viewFindViewById.getHeight());
                        jSONObject3.put("alpha", viewFindViewById.getAlpha());
                        jSONObject2.put("root_view", jSONObject3.toString());
                    } catch (Throwable th) {
                        aaj.qdl("TTAD.RFReportManager", "run: ", th);
                    }
                    com.bytedance.sdk.openadsdk.mml.lnr.qdl(ljhVar, to.this.qdl.mzz, jSONObject2, to.this.jpc());
                    to.this.qdl.wc.rq();
                    mzz.qdl qdlVar = new mzz.qdl(to.this.qdl.bqt != null && (map2 = map) != null && map2.containsKey("dynamic_show_type") ? to.this.qdl.bqt.rq() : -1);
                    to.this.qdl(qdlVar);
                    com.bytedance.sdk.openadsdk.bch.ud.mzz.qdl(to.this.qdl.ag.findViewById(R.id.content), ljhVar, qdlVar);
                    com.bytedance.sdk.openadsdk.bch.qdl.lnr.qdl(ljhVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(mzz.qdl qdlVar) {
        if (!this.qdl.ra || this.qdl.lq == null) {
            return;
        }
        qdlVar.ud = this.qdl.lq.rq;
    }

    public void qdl(boolean z) {
        if (this.qdl.ud == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.bjy.qdl.mml mmlVarMzz = com.bytedance.sdk.openadsdk.bjy.qdl.mml.ud().qdl(z ? 7 : 8).lnr(String.valueOf(this.qdl.ud.fz())).mzz(this.qdl.ud.cev());
        mmlVarMzz.ud(this.qdl.hkc.jl()).mo(this.qdl.hkc.exc());
        mmlVarMzz.wd(this.qdl.ud.ir()).mml(this.qdl.ud.yre());
        com.bytedance.sdk.openadsdk.bjy.lnr.qdl().ud(mmlVarMzz);
    }

    public com.bytedance.sdk.openadsdk.core.lnr.mzz lnr() {
        this.lnr.qdl(this.qdl.ag.findViewById(R.id.content));
        if (this.qdl.uw.lnr() != null) {
            this.lnr.qdl(this.qdl.uw.lnr());
        }
        this.qdl.xmv.qdl(this.lnr);
        this.lnr.qdl(new qdl.InterfaceC0238qdl() { // from class: com.bytedance.sdk.openadsdk.component.reward.qdl.to.3
            @Override // com.bytedance.sdk.openadsdk.core.lnr.qdl.InterfaceC0238qdl
            public long getVideoProgress() {
                return to.this.qdl.bch.fs();
            }
        });
        com.bytedance.sdk.openadsdk.component.reward.view.fs fsVar = this.qdl.gy;
        com.bytedance.sdk.openadsdk.core.lnr.mzz mzzVar = this.lnr;
        fsVar.qdl(mzzVar, mzzVar, this.ud);
        this.qdl.mrf.qdl(this.lnr);
        return this.lnr;
    }

    public com.bytedance.sdk.openadsdk.core.lnr.ud mml() {
        return this.ud;
    }

    public com.bytedance.sdk.openadsdk.core.lnr.mzz mzz() {
        return this.lnr;
    }

    public void ud(boolean z) {
        qdl qdlVar = this.qdl;
        if (qdlVar == null) {
            return;
        }
        if (!z && qdlVar.exu.get() && this.qdl.dk > 0) {
            com.bytedance.sdk.openadsdk.mml.lnr.qdl(String.valueOf(SystemClock.elapsedRealtime() - this.qdl.dk), this.qdl.ud, this.qdl.mzz, this.qdl.bch.mzz());
            this.qdl.dk = 0L;
        } else {
            this.qdl.dk = SystemClock.elapsedRealtime();
        }
        com.bytedance.sdk.openadsdk.bch.ud.mzz.qdl(this.qdl.ud, z ? 4 : 8);
        com.bytedance.sdk.openadsdk.bch.qdl.lnr.qdl(this.qdl.ud, z ? 4 : 8);
    }

    public void mo() {
        JSONObject jSONObject = new JSONObject();
        int i = 1;
        try {
            if (this.qdl.to.get()) {
                if (!this.qdl.hkc.lnr()) {
                    if (this.qdl.hzv.mml()) {
                        i = 3;
                    } else {
                        i = this.qdl.hkc.mml() ? 2 : 0;
                    }
                }
                jSONObject.put("endcard_content", i);
            } else {
                jSONObject.put("endCardNotShow", 1);
            }
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.mml.lnr.ud(this.qdl.ud, this.qdl.mzz, "click_close", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(View view, float f, float f2, float f3, float f4, SparseArray<lnr.qdl> sparseArray, int i, int i2, int i3) {
        if (view == null) {
            return;
        }
        if (view.getId() == com.bytedance.sdk.openadsdk.utils.jtx.mzz) {
            qdl("click_play_star_level", (JSONObject) null);
        } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.jtx.mml || view.getId() == com.bytedance.sdk.openadsdk.utils.jtx.wd) {
            qdl("click_play_star_nums", (JSONObject) null);
        } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.jtx.lnr) {
            qdl("click_play_source", (JSONObject) null);
        } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.jtx.ud) {
            qdl("click_play_logo", (JSONObject) null);
        } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.jtx.fs || view.getId() == com.bytedance.sdk.openadsdk.utils.jtx.blf || view.getId() == com.bytedance.sdk.openadsdk.utils.jtx.jtx) {
            qdl("click_start_play_bar", to());
        } else if (view.getId() == 520093705) {
            qdl("click_start_play", to());
        } else if (view.getId() == com.bytedance.sdk.openadsdk.utils.jtx.rq) {
            qdl("click_video", to());
        } else if (view.getId() == 520093707 || view.getId() == com.bytedance.sdk.openadsdk.utils.jtx.jpc) {
            qdl("fallback_endcard_click", to());
        }
        ud(view, f, f2, f3, f4, sparseArray, i, i2, i3);
    }

    private void ud(View view, float f, float f2, float f3, float f4, SparseArray<lnr.qdl> sparseArray, int i, int i2, int i3) {
        if (!tvp() || this.qdl.ud == null || view == null) {
            return;
        }
        int id = view.getId();
        if (id == com.bytedance.sdk.openadsdk.utils.jtx.mzz || id == com.bytedance.sdk.openadsdk.utils.jtx.mml || id == com.bytedance.sdk.openadsdk.utils.jtx.lnr || id == com.bytedance.sdk.openadsdk.utils.jtx.ud || id == com.bytedance.sdk.openadsdk.utils.jtx.fs || id == com.bytedance.sdk.openadsdk.utils.jtx.blf || id == com.bytedance.sdk.openadsdk.utils.jtx.jtx || id == 520093705 || id == com.bytedance.sdk.openadsdk.utils.jtx.rq || id == 520093707 || id == com.bytedance.sdk.openadsdk.utils.jtx.wd) {
            int i4 = ax.to(com.bytedance.sdk.openadsdk.core.yt.qdl());
            com.bytedance.sdk.openadsdk.core.model.fs fsVarQdl = new fs.qdl().mo(f).mzz(f2).mml(f3).lnr(f4).ud(System.currentTimeMillis()).qdl(0L).qdl(ax.qdl(this.qdl.gy.rq())).ud(ax.lnr(this.qdl.gy.rq())).mml(i2).mzz(i3).mo(i).qdl(sparseArray).ud(com.bytedance.sdk.openadsdk.core.tvp.ud().qdl() ? 1 : 2).lnr(i4).qdl(ax.jpc(com.bytedance.sdk.openadsdk.core.yt.qdl())).ud(ax.tvp(com.bytedance.sdk.openadsdk.core.yt.qdl())).qdl();
            HashMap map = new HashMap();
            map.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(this.qdl.bch.fs()));
            com.bytedance.sdk.openadsdk.mml.lnr.qdl("click_other", this.qdl.ud, fsVarQdl, this.qdl.mzz, true, (Map<String, Object>) map, -1);
        }
    }

    private boolean tvp() {
        return this.qdl.ud != null && this.qdl.ud.syy() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(String str, JSONObject jSONObject) {
        ljh ljhVar = this.qdl.ud;
        String str2 = this.qdl.mzz;
        if (!this.qdl.mml) {
            jSONObject = null;
        }
        com.bytedance.sdk.openadsdk.mml.lnr.qdl(ljhVar, str2, str, jSONObject);
    }

    private JSONObject to() {
        try {
            long jOth = this.qdl.bch.oth();
            int iLjh = this.qdl.bch.ljh();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TypedValues.TransitionType.S_DURATION, jOth);
                jSONObject.put("percent", iLjh);
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public void lnr(boolean z) {
        qdl qdlVar = this.qdl;
        if (qdlVar != null && z && qdlVar.ud.jwd() && !this.qdl.ud.ljh()) {
            this.qdl.ud.mo(true);
            com.bytedance.sdk.openadsdk.mml.lnr.qdl(this.qdl.ud, this.qdl.mzz, this.qdl.ud.fo());
        }
    }

    public void wd() {
        com.bytedance.sdk.openadsdk.mml.lnr.ud(this.qdl.ud, this.qdl.mzz, (JSONObject) null, jpc());
    }

    public com.bytedance.sdk.openadsdk.core.lnr.mzz qdl(final qdl qdlVar, final ljh ljhVar) {
        return new com.bytedance.sdk.openadsdk.core.lnr.mzz(qdlVar.ag, ljhVar, qdlVar.mzz, qdlVar.mml ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.component.reward.qdl.to.4
            @Override // com.bytedance.sdk.openadsdk.core.lnr.mzz
            public void qdl(View view, float f, float f2, float f3, float f4, SparseArray<lnr.qdl> sparseArray, int i, int i2, int i3, boolean z) {
                if (ljhVar.uj() && view != null) {
                    Object tag = view.getTag(570425345);
                    if (tag instanceof String) {
                        qdl((String) tag);
                    }
                }
                HashMap map = new HashMap();
                map.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(qdlVar.bch.fs()));
                if (qdlVar.to.get()) {
                    map.put("click_scence", 2);
                } else {
                    map.put("click_scence", 1);
                }
                if (qdlVar.lq != null) {
                    qdlVar.lq.qdl(map, f, f2);
                }
                qdl(map);
                qdlVar.wc.mrf();
                qdlVar.uw.qdl(view, f, f2, f3, f4, sparseArray, i, i2, i3, new mml.qdl() { // from class: com.bytedance.sdk.openadsdk.component.reward.qdl.to.4.1
                    @Override // com.bytedance.sdk.openadsdk.component.reward.qdl.mml.qdl
                    public void qdl(String str, JSONObject jSONObject) {
                        to.this.qdl(str, jSONObject);
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.qdl.mml.qdl
                    public void qdl(View view2, float f5, float f6, float f7, float f8, SparseArray<lnr.qdl> sparseArray2, int i4, int i5, int i6) {
                        to.this.qdl(view2, f5, f6, f7, f8, sparseArray2, i4, i5, i6);
                    }
                });
                com.bytedance.sdk.openadsdk.bch.ud.mzz.qdl(ljhVar, 9);
                qdlVar.bch.ag();
            }
        };
    }
}
