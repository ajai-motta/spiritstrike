package com.bytedance.sdk.openadsdk.core.to;

import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.component.utils.mzz;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.yt;
import com.facebook.appevents.AppEventsConstants;
import com.pgl.ssdk.ces.out.PglSSManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class lnr {
    private static boolean qdl;

    public static void qdl() {
        if (!qdl && yt.mml().tid()) {
            ud.ud();
            qdl = ud.ud().lnr();
        }
    }

    public static void qdl(String str) {
        if (yt.mml().tid()) {
            ud.ud().qdl(str);
        }
    }

    public static void ud(String str) {
        if (TextUtils.isEmpty(str) || !yt.mml().tid()) {
            return;
        }
        ud.ud().ud(str);
    }

    public static void ud() {
        if (yt.mml().tid()) {
            ud.ud().qdl();
        }
    }

    public static void qdl(ljh ljhVar, String str) {
        long jOptLong;
        long jOptLong2;
        long jOptLong3;
        Object obj;
        if (yt.mml().tid()) {
            HashMap map = new HashMap();
            map.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            map.put("au_show", str);
            if (ljhVar != null) {
                String strCev = ljhVar.cev();
                String strOptString = "-1";
                if (!TextUtils.isEmpty(strCev)) {
                    map.put("request_id", strCev);
                } else {
                    map.put("request_id", "-1");
                }
                try {
                    long j = -1;
                    if (ljhVar.uzn() != null) {
                        jOptLong = ljhVar.uzn().optLong("ad_id", -1L);
                        jOptLong2 = ljhVar.uzn().optLong("rit", -1L);
                        jOptLong3 = ljhVar.uzn().optLong("ad_slot_type", -1L);
                        strOptString = ljhVar.uzn().optString(AppEventsConstants.EVENT_PARAM_AD_TYPE, "-1");
                    } else {
                        jOptLong = -1;
                        jOptLong2 = -1;
                        jOptLong3 = -1;
                    }
                    map.put("ad_id", Long.valueOf(jOptLong));
                    map.put("rit", Long.valueOf(jOptLong2));
                    map.put("ad_slot_type", Long.valueOf(jOptLong3));
                    map.put(AppEventsConstants.EVENT_PARAM_AD_TYPE, strOptString);
                    Map<String, Object> mapDsy = ljhVar.dsy();
                    if (mapDsy != null && (obj = mapDsy.get(TTAdConstant.SDK_BIDDING_TYPE)) != null) {
                        j = Long.parseLong(obj.toString());
                    }
                    map.put(TTAdConstant.SDK_BIDDING_TYPE, Long.valueOf(j));
                    ud.ud().qdl(PglSSManager.REPORT_SCENE_ADSHOW, map);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static Map<String, String> qdl(String str, String str2) {
        if (yt.mml().tid()) {
            return ud.ud().qdl(str, str2 != null ? str2.getBytes() : new byte[0]);
        }
        return new HashMap();
    }

    public static String lnr() {
        if (yt.mml().tid()) {
            return ud.ud().mzz();
        }
        return "";
    }

    public static long mml() {
        if (yt.mml().tid()) {
            return ud.ud().mo();
        }
        return 0L;
    }

    public static int mzz() {
        if (yt.mml().tid()) {
            return ud.ud().wd();
        }
        return 6;
    }

    public static void qdl(MotionEvent motionEvent) {
        if (yt.mml().tid()) {
            ud.ud().qdl(motionEvent);
        }
    }

    public static void qdl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (yt.mml().tid()) {
                qdl();
                if (mzz() == 0) {
                    jSONObject.put("sec_did", ud.ud().mml());
                    String strQdl = mzz.qdl(jSONObject.toString());
                    Map<String, String> mapQdl = ud.ud().qdl("https://api16-access-sg.pangle.io/api/ad/union/sdk/get_ads/?aid=1371&device_platform=android&version_code=4250", strQdl != null ? strQdl.getBytes() : new byte[0]);
                    if (mapQdl != null && mapQdl.size() > 0) {
                        for (String str : mapQdl.keySet()) {
                            jSONObject.put(str, mapQdl.get(str));
                        }
                        jSONObject.put("url", "https://api16-access-sg.pangle.io/api/ad/union/sdk/get_ads/?aid=1371&device_platform=android&version_code=4250");
                        jSONObject.put("pangle_m", strQdl);
                    } else {
                        jSONObject.put("pglx", "8");
                    }
                    jSONObject.put("ec", ud.ud().mo());
                    return;
                }
                jSONObject.put("pglx", String.valueOf(mzz()));
                return;
            }
            jSONObject.put("pglx", "6");
        } catch (Throwable th) {
            aaj.lnr("SecSdkHelperUtil", th.getMessage());
            try {
                jSONObject.put("pglx", "7");
            } catch (JSONException unused) {
            }
        }
    }

    public static String mo() {
        if (yt.mml().tid()) {
            return ud.ud().mml();
        }
        return null;
    }
}
