package com.bytedance.sdk.openadsdk.core.lnr;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.fco;
import com.bytedance.sdk.openadsdk.core.lnr.lnr;
import com.bytedance.sdk.openadsdk.core.model.fs;
import com.bytedance.sdk.openadsdk.core.model.jtx;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.model.vu;
import com.bytedance.sdk.openadsdk.core.tvp;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.gy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ud extends lnr {
    private static int hkc = Integer.MIN_VALUE;
    protected com.bytedance.sdk.openadsdk.exc.qdl.qdl.mo bjy;
    protected int exc;
    protected com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr exu;
    protected PAGNativeAd fs;
    protected com.bytedance.sdk.openadsdk.core.tvp.ud jl;
    protected final int jpc;
    protected Map<String, Object> jtx;
    private boolean lnr;
    protected Context mml;
    protected final ljh mo;
    public jtx mzz;
    private String qdl;
    protected boolean rdp;
    protected qdl rq;
    protected fs to;
    protected WeakReference<View> tvp;
    private WeakReference<Activity> ud;
    protected final String wd;
    protected com.bytedance.sdk.openadsdk.core.mml.qdl yt;

    public interface qdl {
        void qdl(View view, int i);
    }

    public boolean qdl(fs fsVar, Map<String, Object> map) {
        return false;
    }

    public void qdl(com.bytedance.sdk.openadsdk.exc.qdl.qdl.mo moVar) {
        this.bjy = moVar;
    }

    public void qdl(com.bytedance.sdk.openadsdk.core.tvp.ud udVar) {
        this.jl = udVar;
    }

    public void qdl(PAGNativeAd pAGNativeAd) {
        this.fs = pAGNativeAd;
    }

    public void qdl(com.bytedance.sdk.openadsdk.core.mml.qdl qdlVar) {
        this.yt = qdlVar;
    }

    public void mzz(boolean z) {
        this.rdp = z;
    }

    public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar) {
        this.exu = lnrVar;
    }

    public ud(Context context, ljh ljhVar, String str, int i) {
        this.rdp = false;
        this.exc = 0;
        this.lnr = false;
        this.mml = context;
        this.mo = ljhVar;
        this.wd = str;
        this.jpc = i;
    }

    public ud(Context context, ljh ljhVar, String str, int i, boolean z) {
        this(context, ljhVar, str, i);
        this.lnr = z;
    }

    public void qdl(qdl qdlVar) {
        this.rq = qdlVar;
    }

    public void qdl(Activity activity) {
        if (activity == null) {
            return;
        }
        this.ud = new WeakReference<>(activity);
    }

    public void qdl(View view) {
        if (view == null) {
            return;
        }
        this.tvp = new WeakReference<>(view);
    }

    public View mml() {
        WeakReference<Activity> weakReference = this.ud;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.ud.get().findViewById(R.id.content);
    }

    public void qdl(Map<String, Object> map) {
        Map<String, Object> map2 = this.jtx;
        if (map2 != null) {
            map2.putAll(map);
            map.putAll(this.jtx);
        }
        this.jtx = map;
    }

    public void qdl(int i) {
        this.koa = i;
    }

    public void ud(int i) {
        this.bqt = i;
    }

    public void lnr(int i) {
        this.xmv = i;
    }

    public void mml(int i) {
        this.exc = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.lnr.lnr
    public void qdl(View view, float f, float f2, float f3, float f4, SparseArray<lnr.qdl> sparseArray, boolean z) {
        int i;
        boolean z2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        com.bytedance.sdk.openadsdk.core.fs.mml mmlVarQdl;
        if (this.mml == null) {
            this.mml = yt.qdl();
        }
        if ((this.lnr || !qdl(view, 1, f, f2, f3, f4, sparseArray, z)) && this.mml != null) {
            jtx jtxVar = this.mzz;
            if (jtxVar != null) {
                i = jtxVar.jpc;
                jSONObject = this.mzz.tvp;
                jSONObject2 = this.mzz.exu;
                z2 = this.mzz.rdp;
            } else {
                i = -1;
                z2 = false;
                jSONObject = null;
                jSONObject2 = null;
            }
            long j = this.bch;
            long j2 = this.uw;
            WeakReference<View> weakReference = this.tvp;
            fs fsVarQdl = qdl(f, f2, f3, f4, sparseArray, j, j2, weakReference == null ? null : weakReference.get(), mzz(), ax.jpc(this.mml), ax.to(this.mml), ax.tvp(this.mml), i, jSONObject, jSONObject2);
            this.to = fsVarQdl;
            if (qdl(fsVarQdl, this.jtx)) {
                return;
            }
            if (this.exu != null) {
                if (this.jtx == null) {
                    this.jtx = new HashMap();
                }
                this.jtx.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(this.exu.mo()));
            }
            ljh ljhVar = this.mo;
            if (this.lnr || z2) {
                com.bytedance.sdk.openadsdk.mml.lnr.qdl("click", ljhVar, this.to, this.wd, true, this.jtx, z ? 1 : 2);
                com.bytedance.sdk.openadsdk.core.model.mml mmlVarZm = ljhVar.zm();
                if (mmlVarZm == null || ljhVar.uj() || (mmlVarQdl = mmlVarZm.qdl()) == null) {
                    return;
                }
                com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar = this.exu;
                mmlVarQdl.wd(lnrVar != null ? lnrVar.mo() : 0L);
                return;
            }
            qdl qdlVar = this.rq;
            if (qdlVar != null) {
                qdlVar.qdl(view, -1);
            }
            if (qdl(view, z)) {
                boolean zUd = vu.ud(ljhVar);
                String strQdl = zUd ? this.wd : gy.qdl(this.jpc);
                if (view != null) {
                    try {
                        Boolean bool = (Boolean) view.getTag(520093762);
                        if (bool.booleanValue()) {
                            fco.qdl(true);
                        }
                    } catch (Exception unused) {
                    }
                }
                Activity activityQdl = view != null ? com.bytedance.sdk.component.utils.ud.qdl(view) : null;
                boolean zQdl = fco.qdl(activityQdl == null ? this.mml : activityQdl, ljhVar, this.jpc, this.fs, this.yt, strQdl, this.bjy, zUd, 0);
                fco.qdl(false);
                if (zQdl || ljhVar == null || ljhVar.bo() == null || ljhVar.bo().lnr() != 2) {
                    if (ljhVar != null && !zQdl && TextUtils.isEmpty(ljhVar.od()) && com.bytedance.sdk.openadsdk.mml.ud.qdl(this.wd)) {
                        com.bytedance.sdk.openadsdk.exc.qdl.qdl.wd.qdl(this.mml, this.wd).lnr(ljhVar);
                    }
                    com.bytedance.sdk.openadsdk.mml.lnr.qdl("click", ljhVar, this.to, this.wd, zQdl, this.jtx, z ? 1 : 2);
                }
            }
        }
    }

    public boolean qdl(View view, boolean z) {
        return qdl(view, this.mo, z);
    }

    public static boolean qdl(View view, ljh ljhVar, boolean z) {
        if (view != null && ljhVar != null) {
            try {
                String strValueOf = String.valueOf(view.getTag(com.bytedance.sdk.component.adexpress.dynamic.qdl.aaj));
                if (view.getTag(com.bytedance.sdk.component.adexpress.dynamic.qdl.aaj) != null && !TextUtils.isEmpty(strValueOf)) {
                    if ("click".equals(strValueOf)) {
                        return z;
                    }
                    return true;
                }
            } catch (Exception unused) {
            }
            if (ud(view)) {
                return ljhVar.car() != 1 || z;
            }
            if (ljhVar.sy() == 1 && !z) {
                return false;
            }
        }
        return true;
    }

    protected fs qdl(float f, float f2, float f3, float f4, SparseArray<lnr.qdl> sparseArray, long j, long j2, View view, String str, float f5, int i, float f6, int i2, JSONObject jSONObject, JSONObject jSONObject2) {
        return new fs.qdl().mo(f).mzz(f2).mml(f3).lnr(f4).ud(j).qdl(j2).qdl(ax.qdl(view)).ud(ax.lnr(view)).mml(this.xmv).mzz(this.bqt).mo(this.koa).qdl(sparseArray).ud(tvp.ud().qdl() ? 1 : 2).qdl(str).qdl(f5).lnr(i).ud(f6).qdl(i2).qdl(jSONObject).ud(jSONObject2).qdl();
    }

    protected boolean qdl(View view, int i, float f, float f2, float f3, float f4, SparseArray<lnr.qdl> sparseArray, boolean z) {
        if (this.jl == null) {
            return false;
        }
        this.jl.qdl(view, i, new jtx.qdl().mml(f).lnr(f2).ud(f3).qdl(f4).ud(this.bch).qdl(this.uw).qdl(sparseArray).qdl(z).qdl());
        return true;
    }

    public static boolean ud(View view) {
        return 520093705 == view.getId() || 520093707 == view.getId() || 520093703 == view.getId() || qdl(view.getContext()) == view.getId() || com.bytedance.sdk.openadsdk.utils.jtx.jut == view.getId() || com.bytedance.sdk.openadsdk.utils.jtx.vxg == view.getId();
    }

    private static int qdl(Context context) {
        if (hkc == Integer.MIN_VALUE) {
            hkc = com.bytedance.sdk.component.utils.ljh.mzz(context, "btn_native_creative");
        }
        return hkc;
    }

    public String mzz() {
        return this.qdl;
    }

    public void qdl(String str) {
        this.qdl = str;
    }
}
