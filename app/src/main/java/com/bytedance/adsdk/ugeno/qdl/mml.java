package com.bytedance.adsdk.ugeno.qdl;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import com.bytedance.adsdk.ugeno.qdl.lnr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class mml {
    public static int qdl(int i) {
        if (i < 0) {
            return -1;
        }
        if (i == 0) {
            return Integer.MIN_VALUE;
        }
        return i - 1;
    }

    public static List<lnr> qdl(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 0) {
                return null;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(qdl(jSONObjectOptJSONObject, jSONObject));
                }
            }
            return arrayList;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static lnr qdl(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        lnr lnrVar = new lnr();
        lnrVar.ud(com.bytedance.adsdk.ugeno.wd.lnr.qdl(com.bytedance.adsdk.ugeno.lnr.ud.qdl(jSONObject.optString("delay"), jSONObject2), 0L));
        lnrVar.lnr(com.bytedance.adsdk.ugeno.lnr.ud.qdl(jSONObject.optString("name"), jSONObject2));
        lnrVar.ud(com.bytedance.adsdk.ugeno.wd.lnr.qdl(com.bytedance.adsdk.ugeno.lnr.ud.qdl(jSONObject.optString("playState"), jSONObject2), 1));
        lnrVar.qdl(Math.max(com.bytedance.adsdk.ugeno.wd.lnr.qdl(com.bytedance.adsdk.ugeno.lnr.ud.qdl(jSONObject.optString(TypedValues.TransitionType.S_DURATION), jSONObject2), 0L), 0L));
        lnrVar.qdl(com.bytedance.adsdk.ugeno.wd.lnr.qdl(com.bytedance.adsdk.ugeno.lnr.ud.qdl(jSONObject.optString("playCount"), jSONObject2), 1));
        lnrVar.qdl(com.bytedance.adsdk.ugeno.lnr.ud.qdl(jSONObject.optString("playDirection"), jSONObject2));
        lnrVar.qdl(ud(jSONObject.optString("transformOrigin"), jSONObject2));
        lnrVar.ud(com.bytedance.adsdk.ugeno.lnr.ud.qdl(jSONObject.optString("timingFunction", "linear"), jSONObject2));
        lnrVar.qdl(jSONObject.optJSONObject("effect"));
        lnrVar.qdl(qdl(jSONObject.optJSONArray("keyframes"), jSONObject2));
        return lnrVar;
    }

    public static Map<String, TreeMap<Float, String>> qdl(JSONArray jSONArray, JSONObject jSONObject) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                float fOptDouble = (float) jSONObjectOptJSONObject.optDouble(TypedValues.CycleType.S_WAVE_OFFSET);
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    TreeMap treeMap = (TreeMap) map.get(next);
                    if (!TextUtils.equals(next, TypedValues.CycleType.S_WAVE_OFFSET)) {
                        if (map.containsKey(next) && treeMap != null) {
                            treeMap.put(Float.valueOf(fOptDouble), com.bytedance.adsdk.ugeno.lnr.ud.qdl(jSONObjectOptJSONObject.optString(next), jSONObject));
                        } else {
                            TreeMap treeMap2 = new TreeMap();
                            treeMap2.put(Float.valueOf(fOptDouble), com.bytedance.adsdk.ugeno.lnr.ud.qdl(jSONObjectOptJSONObject.optString(next), jSONObject));
                            map.put(next, treeMap2);
                        }
                    }
                }
            }
        }
        return map;
    }

    public static int qdl(String str) {
        int iHashCode = str.hashCode();
        if (iHashCode == -1408024454) {
            return str.equals("alternate") ? 2 : 1;
        }
        if (iHashCode != -1039745817) {
            return 1;
        }
        str.equals(Constants.NORMAL);
        return 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.view.animation.Interpolator ud(java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            r1 = 2
            r2 = 1
            switch(r0) {
                case -1965072618: goto L28;
                case -1102672091: goto L1e;
                case -787702915: goto L14;
                case 1065009829: goto La;
                default: goto L9;
            }
        L9:
            goto L32
        La:
            java.lang.String r0 = "ease_in_out"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L32
            r3 = r2
            goto L33
        L14:
            java.lang.String r0 = "ease_out"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L32
            r3 = r1
            goto L33
        L1e:
            java.lang.String r0 = "linear"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L32
            r3 = 3
            goto L33
        L28:
            java.lang.String r0 = "ease_in"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L32
            r3 = 0
            goto L33
        L32:
            r3 = -1
        L33:
            if (r3 == 0) goto L4b
            if (r3 == r2) goto L45
            if (r3 == r1) goto L3f
            android.view.animation.LinearInterpolator r3 = new android.view.animation.LinearInterpolator
            r3.<init>()
            return r3
        L3f:
            android.view.animation.DecelerateInterpolator r3 = new android.view.animation.DecelerateInterpolator
            r3.<init>()
            return r3
        L45:
            android.view.animation.AccelerateDecelerateInterpolator r3 = new android.view.animation.AccelerateDecelerateInterpolator
            r3.<init>()
            return r3
        L4b:
            android.view.animation.AccelerateInterpolator r3 = new android.view.animation.AccelerateInterpolator
            r3.<init>()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.qdl.mml.ud(java.lang.String):android.view.animation.Interpolator");
    }

    public static float[] lnr(String str) {
        float[] fArr = {0.0f, 0.0f};
        JSONArray jSONArrayQdl = com.bytedance.adsdk.ugeno.wd.ud.qdl(str, (JSONArray) null);
        if (jSONArrayQdl != null && jSONArrayQdl.length() == 2) {
            fArr[0] = (float) jSONArrayQdl.optDouble(0);
            fArr[1] = (float) jSONArrayQdl.optDouble(1);
        }
        return fArr;
    }

    public static lnr.qdl ud(String str, JSONObject jSONObject) {
        JSONArray jSONArrayQdl;
        if (TextUtils.isEmpty(str) || (jSONArrayQdl = com.bytedance.adsdk.ugeno.wd.ud.qdl(str, (JSONArray) null)) == null || jSONArrayQdl.length() != 2) {
            return null;
        }
        lnr.qdl qdlVar = new lnr.qdl();
        qdlVar.qdl = com.bytedance.adsdk.ugeno.lnr.ud.qdl(jSONArrayQdl.optString(0), jSONObject);
        qdlVar.ud = com.bytedance.adsdk.ugeno.lnr.ud.qdl(jSONArrayQdl.optString(1), jSONObject);
        return qdlVar;
    }

    public static int qdl(String str, int i) {
        int i2 = i / 2;
        if (TextUtils.isEmpty(str)) {
            return i2;
        }
        str.hashCode();
        switch (str) {
            case "bottom":
            case "right":
                return i;
            case "center":
                return i2;
            case "top":
            case "left":
                return 0;
            default:
                if (str.endsWith("%")) {
                    try {
                        return (int) ((i * Float.parseFloat(str.substring(0, str.length() - 1))) / 100.0f);
                    } catch (NumberFormatException unused) {
                        return i2;
                    }
                }
                try {
                    return Integer.parseInt(str);
                } catch (NumberFormatException unused2) {
                    return i2;
                }
        }
    }
}
