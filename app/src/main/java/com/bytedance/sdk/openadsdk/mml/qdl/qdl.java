package com.bytedance.sdk.openadsdk.mml.qdl;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.autofill.HintConstants;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.fs;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.bch;
import com.bytedance.sdk.openadsdk.utils.bqt;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.bytedance.sdk.openadsdk.utils.vu;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.messaging.Constants;
import com.hive.base.Android;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    private final Context lnr;
    private final boolean mml;
    private final String mzz;
    private long qdl;
    private int ud;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.mml.qdl.qdl$qdl, reason: collision with other inner class name */
    private static class C0266qdl {
        private static final qdl qdl = new qdl();
    }

    public static qdl qdl() {
        return C0266qdl.qdl;
    }

    private qdl() {
        this.mml = lnr();
        this.lnr = yt.qdl().getApplicationContext();
        this.mzz = mzz();
    }

    public String qdl(List<com.bytedance.sdk.openadsdk.mml.qdl> list) {
        String strOptString;
        if (list.size() > 0 && list.get(0) != null && list.get(0).lnr() != null) {
            strOptString = list.get(0).lnr().optString("app_log_url");
        } else {
            strOptString = "";
        }
        return gy.mzz(strOptString);
    }

    private void qdl(com.bytedance.sdk.openadsdk.mml.qdl qdlVar, boolean z) {
        if (qdlVar == null) {
            return;
        }
        try {
            String strOptString = z ? qdlVar.lnr().optJSONObject(NativeProtocol.WEB_DIALOG_PARAMS).optString("log_extra", "") : qdlVar.lnr().optString("log_extra", "");
            long jQdl = ljh.qdl(strOptString);
            int iMml = ljh.mml(strOptString);
            if (jQdl == 0) {
                jQdl = this.qdl;
            }
            this.qdl = jQdl;
            if (iMml == 0) {
                iMml = this.ud;
            }
            this.ud = iMml;
        } catch (Exception e) {
            aaj.lnr("AdLogParamsGenerate", "getInfoFromLogExtra exception", e.getMessage());
        }
    }

    public JSONObject qdl(List<com.bytedance.sdk.openadsdk.mml.qdl> list, long j, JSONObject jSONObject, boolean z) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            qdl(list.get(0), z);
            jSONObject2.put("header", jSONObject);
            JSONArray jSONArray = new JSONArray();
            Iterator<com.bytedance.sdk.openadsdk.mml.qdl> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().qdl(z));
            }
            if (z) {
                jSONObject2.put("event_v3", jSONArray);
                jSONObject2.put("magic_tag", "ss_app_log");
            } else {
                jSONObject2.put("event", jSONArray);
            }
            jSONObject2.put("_gen_time", j);
            jSONObject2.put("local_time", j / 1000);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public List<com.bytedance.sdk.openadsdk.mml.qdl> qdl(List<com.bytedance.sdk.openadsdk.mml.qdl> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.sdk.openadsdk.mml.qdl qdlVar : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObjectLnr = qdlVar.lnr();
                jSONObject.putOpt("event", jSONObjectLnr.optString(Constants.ScionAnalytics.PARAM_LABEL));
                long jOptLong = jSONObjectLnr.optLong("event_ts", System.currentTimeMillis());
                jSONObject.putOpt("local_time_ms", Long.valueOf(jOptLong));
                jSONObject.putOpt("datetime", com.bytedance.sdk.openadsdk.mml.mo.lnr.format(new Date(jOptLong)));
                JSONObject jSONObject2 = new JSONObject();
                Iterator<String> itKeys = jSONObjectLnr.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!TextUtils.equals(next, Constants.ScionAnalytics.PARAM_LABEL)) {
                        jSONObject2.putOpt(next, jSONObjectLnr.opt(next));
                    }
                }
                if (z) {
                    jSONObject2.putOpt("_ad_staging_flag", 3);
                }
                jSONObject.putOpt(NativeProtocol.WEB_DIALOG_PARAMS, jSONObject2);
                arrayList.add(new com.bytedance.sdk.openadsdk.mml.mo(qdlVar.qdl, jSONObject));
            } catch (Exception e) {
                aaj.lnr("AdLogParamsGenerate", e.getMessage());
            }
        }
        return arrayList;
    }

    public List<com.bytedance.sdk.openadsdk.mml.qdl> ud(List<com.bytedance.sdk.openadsdk.mml.qdl> list) {
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.sdk.openadsdk.mml.qdl qdlVar : list) {
            try {
                JSONObject jSONObjectLnr = qdlVar.lnr();
                jSONObjectLnr.putOpt("_ad_staging_flag", 1);
                arrayList.add(new com.bytedance.sdk.openadsdk.mml.qdl(qdlVar.qdl, jSONObjectLnr));
            } catch (Exception e) {
                aaj.lnr("AdLogParamsGenerate", e.getMessage());
            }
        }
        return arrayList;
    }

    public JSONObject ud() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ua", gy.mml());
            jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put("app_version", gy.jpc());
            jSONObject.put("sim_op", qdl(this.lnr));
            jSONObject.put("root", this.mml ? 1 : 0);
            jSONObject.put("timezone", mml());
            jSONObject.put("access", bch.qdl(this.lnr));
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("device_type", this.mzz);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("resolution", ax.mzz(this.lnr) + "x" + ax.lnr(this.lnr));
            jSONObject.put("display_density", qdl(ax.to(this.lnr)));
            jSONObject.put("density_dpi", ax.to(this.lnr));
            jSONObject.put("aid", "1371");
            jSONObject.put("device_id", fs.qdl(this.lnr));
            jSONObject.put("rom", mo());
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("ut", this.ud);
            jSONObject.put("uid", this.qdl);
            jSONObject.put("google_aid", com.bytedance.sdk.openadsdk.exc.qdl.ud.qdl.qdl().ud());
            jSONObject.put("locale_language", DeviceUtils.mml());
            jSONObject.put("screen_bright", Math.ceil(DeviceUtils.mzz() * 10.0f) / 10.0d);
            jSONObject.put("is_screen_off", !DeviceUtils.ud() ? 1 : 0);
            com.bytedance.sdk.openadsdk.core.settings.rq rqVarMml = yt.mml();
            jSONObject.put("force_language", com.bytedance.sdk.component.utils.ljh.qdl(this.lnr, "tt_choose_language"));
            if (rqVarMml.bqt(Android.HW_IDS_MNC)) {
                jSONObject.put(Android.HW_IDS_MNC, vu.lnr());
            }
            if (rqVarMml.bqt(Android.HW_IDS_MCC)) {
                jSONObject.put(Android.HW_IDS_MCC, vu.ud());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private String qdl(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            if (telephonyManager == null) {
                return "";
            }
            return telephonyManager.getSimOperator();
        } catch (Throwable unused) {
            return "";
        }
    }

    private boolean lnr() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private int mml() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / com.adjust.sdk.Constants.ONE_HOUR;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    private String mzz() {
        if (DeviceUtils.lnr(this.lnr)) {
            return "tv";
        }
        if (DeviceUtils.ud(this.lnr)) {
            return "android_pad";
        }
        return "android";
    }

    private String qdl(int i) {
        if (i == 120) {
            return "ldpi";
        }
        if (i == 160) {
            return "mdpi";
        }
        if (i == 240) {
            return "hdpi";
        }
        if (i == 320) {
            return "xhdpi";
        }
        if (i == 480) {
            return "xxhdpi";
        }
        if (i != 640) {
            return "mdpi";
        }
        return "xxxhdpi";
    }

    private String mo() {
        StringBuilder sb = new StringBuilder();
        try {
            if (bqt.mzz()) {
                sb.append("MIUI-");
            } else if (bqt.ud()) {
                sb.append("FLYME-");
            } else {
                String strRdp = bqt.rdp();
                if (bqt.qdl(strRdp)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strRdp)) {
                    sb.append(strRdp);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }
}
