package com.bytedance.adsdk.ugeno.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class qdl {
    private List<C0181qdl> lnr;
    private long mml;
    private String mo;
    private long mzz;
    private String qdl;
    private float ud;

    public String qdl() {
        return this.qdl;
    }

    public void qdl(String str) {
        this.qdl = str;
    }

    public void qdl(float f) {
        this.ud = f;
    }

    public float ud() {
        return this.ud;
    }

    public List<C0181qdl> lnr() {
        return this.lnr;
    }

    public void qdl(List<C0181qdl> list) {
        this.lnr = list;
    }

    public long mml() {
        return this.mml;
    }

    public void qdl(long j) {
        this.mml = j;
    }

    public long mzz() {
        return this.mzz;
    }

    public void ud(long j) {
        this.mzz = j;
    }

    public String mo() {
        return this.mo;
    }

    public void ud(String str) {
        this.mo = str;
    }

    public static qdl qdl(String str, com.bytedance.adsdk.ugeno.ud.lnr lnrVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return qdl(new JSONObject(str), lnrVar);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static qdl qdl(JSONObject jSONObject, com.bytedance.adsdk.ugeno.ud.lnr lnrVar) {
        return qdl(jSONObject, null, lnrVar);
    }

    public static qdl qdl(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.adsdk.ugeno.ud.lnr lnrVar) {
        if (jSONObject == null) {
            return null;
        }
        qdl qdlVar = new qdl();
        qdlVar.qdl(jSONObject.optString("ordering"));
        String strOptString = jSONObject.optString("loop");
        if (TextUtils.equals("infinite", strOptString)) {
            qdlVar.qdl(-1.0f);
        } else {
            try {
                qdlVar.qdl(Float.parseFloat(strOptString));
            } catch (NumberFormatException unused) {
                qdlVar.qdl(0.0f);
            }
        }
        qdlVar.qdl(jSONObject.optLong(TypedValues.TransitionType.S_DURATION, 0L));
        qdlVar.ud(com.bytedance.adsdk.ugeno.wd.lnr.qdl(com.bytedance.adsdk.ugeno.lnr.ud.qdl(jSONObject.optString("startDelay"), lnrVar.fs()), 0L));
        qdlVar.ud(jSONObject.optString("loopMode"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("animators");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObject2 != null) {
                    com.bytedance.adsdk.ugeno.wd.ud.qdl(jSONObject2, jSONObjectOptJSONObject);
                }
                arrayList.add(C0181qdl.qdl(jSONObjectOptJSONObject, lnrVar));
            }
            qdlVar.qdl(arrayList);
        }
        return qdlVar;
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.core.qdl$qdl, reason: collision with other inner class name */
    public static class C0181qdl {
        private float[] jpc;
        private String lnr;
        private long mml;
        private float mo;
        private String mzz;
        private long qdl;
        private String to;
        private String tvp;
        private float ud;
        private float wd;

        public long qdl() {
            return this.qdl;
        }

        public void qdl(long j) {
            this.qdl = j;
        }

        public float ud() {
            return this.ud;
        }

        public void qdl(float f) {
            this.ud = f;
        }

        public String lnr() {
            return this.lnr;
        }

        public void qdl(String str) {
            this.lnr = str;
        }

        public long mml() {
            return this.mml;
        }

        public void ud(long j) {
            this.mml = j;
        }

        public String mzz() {
            return this.mzz;
        }

        public void ud(String str) {
            this.mzz = str;
        }

        public float mo() {
            return this.mo;
        }

        public void ud(float f) {
            this.mo = f;
        }

        public float wd() {
            return this.wd;
        }

        public void lnr(float f) {
            this.wd = f;
        }

        public float[] jpc() {
            return this.jpc;
        }

        public void qdl(float[] fArr) {
            this.jpc = fArr;
        }

        public String tvp() {
            return this.tvp;
        }

        public String to() {
            return this.to;
        }

        public void lnr(String str) {
            this.to = str;
        }

        public void mml(String str) {
            this.tvp = str;
        }

        public static C0181qdl qdl(JSONObject jSONObject, com.bytedance.adsdk.ugeno.ud.lnr lnrVar) {
            if (jSONObject == null) {
                return null;
            }
            C0181qdl c0181qdl = new C0181qdl();
            c0181qdl.qdl(jSONObject.optLong(TypedValues.TransitionType.S_DURATION));
            String strOptString = jSONObject.optString("loop");
            if (TextUtils.equals("infinite", strOptString)) {
                c0181qdl.qdl(-1.0f);
            } else {
                try {
                    c0181qdl.qdl(Float.parseFloat(strOptString));
                } catch (NumberFormatException unused) {
                    c0181qdl.qdl(0.0f);
                }
            }
            c0181qdl.qdl(jSONObject.optString("loopMode"));
            c0181qdl.ud(jSONObject.optString("type"));
            if (TextUtils.equals(c0181qdl.mzz(), "ripple")) {
                c0181qdl.lnr(jSONObject.optString("rippleColor"));
            }
            View viewRq = lnrVar.rq();
            Context context = viewRq != null ? viewRq.getContext() : null;
            if (TextUtils.equals(c0181qdl.mzz(), TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                String strQdl = com.bytedance.adsdk.ugeno.lnr.ud.qdl(jSONObject.optString("valueTo"), lnrVar.fs());
                int iQdl = com.bytedance.adsdk.ugeno.wd.qdl.qdl(jSONObject.optString("valueFrom"));
                int iQdl2 = com.bytedance.adsdk.ugeno.wd.qdl.qdl(strQdl);
                c0181qdl.ud(iQdl);
                c0181qdl.lnr(iQdl2);
            } else if ((TextUtils.equals(c0181qdl.mzz(), "translateX") || TextUtils.equals(c0181qdl.mzz(), "translateY")) && context != null) {
                try {
                    float fQdl = com.bytedance.adsdk.ugeno.wd.jpc.qdl(context, (float) jSONObject.optDouble("valueFrom"));
                    float fQdl2 = com.bytedance.adsdk.ugeno.wd.jpc.qdl(context, (float) jSONObject.optDouble("valueTo"));
                    c0181qdl.ud(fQdl);
                    c0181qdl.lnr(fQdl2);
                } catch (Exception unused2) {
                    Log.e("animation", "animation ");
                }
            } else {
                c0181qdl.ud((float) jSONObject.optDouble("valueFrom"));
                c0181qdl.lnr((float) jSONObject.optDouble("valueTo"));
            }
            c0181qdl.mml(jSONObject.optString("interpolator"));
            String strQdl2 = com.bytedance.adsdk.ugeno.lnr.ud.qdl(jSONObject.optString("startDelay"), lnrVar.fs());
            Log.d("TAG", "createAnimationModel: ");
            c0181qdl.ud(com.bytedance.adsdk.ugeno.wd.lnr.qdl(strQdl2, 0L));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("values");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                float[] fArr = new float[jSONArrayOptJSONArray.length()];
                int i = 0;
                if ((TextUtils.equals(c0181qdl.mzz(), "translateX") || TextUtils.equals(c0181qdl.mzz(), "translateY")) && context != null) {
                    while (i < jSONArrayOptJSONArray.length()) {
                        fArr[i] = com.bytedance.adsdk.ugeno.wd.jpc.qdl(context, (float) qdl.qdl(jSONArrayOptJSONArray.optString(i), lnrVar.fs()));
                        i++;
                    }
                } else {
                    while (i < jSONArrayOptJSONArray.length()) {
                        fArr[i] = (float) qdl.qdl(jSONArrayOptJSONArray.optString(i), lnrVar.fs());
                        i++;
                    }
                }
                c0181qdl.qdl(fArr);
            }
            return c0181qdl;
        }
    }

    public static double qdl(Object obj, JSONObject jSONObject) {
        if (obj instanceof String) {
            return com.bytedance.adsdk.ugeno.wd.lnr.qdl(com.bytedance.adsdk.ugeno.lnr.ud.qdl((String) obj, jSONObject), 0.0d);
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Long) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Integer) {
            return ((Double) obj).doubleValue();
        }
        return 0.0d;
    }
}
