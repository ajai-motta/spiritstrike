package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import com.apm.insight.AttachUserData;
import com.apm.insight.CrashType;
import com.apm.insight.CustomRequestHeader;
import com.apm.insight.MonitorCrash;
import com.apm.insight.Npth;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.component.jpc.jpc;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.openadsdk.core.bch;
import com.bytedance.sdk.openadsdk.core.fs;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.settings.rq;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.multipro.mml.mml;
import com.bytedance.sdk.openadsdk.utils.fco;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.pgl.ssdk.ces.out.PglSSConfig;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ApmHelper {
    private static String lnr;
    private static boolean mml;
    private static qdl mo;
    private static ud mzz;
    private static volatile boolean qdl;
    private static final AtomicBoolean ud = new AtomicBoolean(false);

    private interface ud {
        void qdl(String str, String str2, Throwable th);
    }

    public static void initApm(final Context context, final InitConfig initConfig) {
        if (ud.compareAndSet(false, true) && !qdl) {
            fco.qdl(new jpc("init-apm") { // from class: com.bytedance.sdk.openadsdk.ApmHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!ApmHelper.qdl) {
                        rq rqVarMml = yt.mml();
                        boolean unused = ApmHelper.mml = rqVarMml.ji();
                        String strJl = gy.jl();
                        if (ApmHelper.mml && !TextUtils.isEmpty(strJl)) {
                            String unused2 = ApmHelper.lnr = initConfig.getAppId();
                            String[] strArr = {"com.bytedance.sdk.component", "com.bytedance.sdk.mediation", BuildConfig.LIBRARY_PACKAGE_NAME, "com.com.bytedance.overseas.sdk", "com.pgl.ssdk", "com.bykv.vk", "com.iab.omid.library.bytedance2", "com.bytedance.adsdk"};
                            String strQdl = fs.qdl(context);
                            try {
                                Npth.setCrashWaitTime(com.bytedance.sdk.openadsdk.jyq.qdl.qdl("apm_crash_wait_time", 10000));
                                Npth.enableLoopMonitor(false);
                                Npth.enableAnrInfo(false);
                                Npth.enableNativeDump(false);
                                Npth.enableActivityDump(false);
                                Npth.enableMessageDump(false);
                                MonitorCrash.setCustomRequestHeaderCallback(new CustomRequestHeader() { // from class: com.bytedance.sdk.openadsdk.ApmHelper.1.1
                                    @Override // com.apm.insight.CustomRequestHeader
                                    public void addRequestHeader(HttpURLConnection httpURLConnection) {
                                        Pair<String, String> pairGenerateRequestHeader = ApmHelper.generateRequestHeader();
                                        httpURLConnection.setRequestProperty("cypher", (String) pairGenerateRequestHeader.first);
                                        httpURLConnection.setRequestProperty("transfer-param", (String) pairGenerateRequestHeader.second);
                                        httpURLConnection.setRequestProperty("x-pangle-target-idc", yt.mml().ca());
                                    }
                                });
                                final MonitorCrash monitorCrashInitSDK = MonitorCrash.initSDK(context, "10000001", 7702L, BuildConfig.VERSION_NAME, strArr);
                                monitorCrashInitSDK.setCustomDataCallback(new AttachUserData() { // from class: com.bytedance.sdk.openadsdk.ApmHelper.1.2
                                    @Override // com.apm.insight.AttachUserData
                                    public Map<? extends String, ? extends String> getUserData(CrashType crashType) {
                                        Map<? extends String, ? extends String> mapJpc = ApmHelper.jpc();
                                        if (mapJpc.containsKey("render_type")) {
                                            monitorCrashInitSDK.addTags("render_type", mapJpc.get("render_type"));
                                        } else {
                                            monitorCrashInitSDK.addTags("render_type", "-2");
                                        }
                                        return mapJpc;
                                    }
                                });
                                if (rqVarMml.taz()) {
                                    monitorCrashInitSDK.config().setSoList(new String[]{"libnms.so", "libtobEmbedPagEncrypt.so", "tt_ugen_layout.so"});
                                }
                                monitorCrashInitSDK.config().setDeviceId(strQdl);
                                monitorCrashInitSDK.setReportUrl(strJl);
                                monitorCrashInitSDK.addTags("host_appid", ApmHelper.lnr);
                                monitorCrashInitSDK.addTags("sdk_version", BuildConfig.VERSION_NAME);
                                ud unused3 = ApmHelper.mzz = new ud() { // from class: com.bytedance.sdk.openadsdk.ApmHelper.1.3
                                    @Override // com.bytedance.sdk.openadsdk.ApmHelper.ud
                                    public void qdl(String str, String str2, Throwable th) {
                                        monitorCrashInitSDK.reportCustomErr(str, str2, th);
                                    }
                                };
                                boolean unused4 = ApmHelper.qdl = true;
                                ApmHelper.lnr(strQdl, strJl);
                                qdl qdlVar = ApmHelper.mo;
                                qdl unused5 = ApmHelper.mo = null;
                                if (qdlVar != null) {
                                    ApmHelper.mzz.qdl(qdlVar.qdl, qdlVar.ud, qdlVar.lnr);
                                }
                            } catch (Throwable unused6) {
                                boolean unused7 = ApmHelper.qdl = false;
                            }
                        }
                    }
                    ApmHelper.ud.set(false);
                }
            });
        }
    }

    public static void reportCustomError(String str, String str2, Throwable th) {
        ud udVar = mzz;
        if (udVar != null) {
            udVar.qdl(str, str2, th);
        } else {
            mo = new qdl(str, str2, th);
        }
    }

    private static class qdl {
        public final Throwable lnr;
        public final String qdl;
        public final String ud;

        public qdl(String str, String str2, Throwable th) {
            this.qdl = str;
            this.ud = str2;
            this.lnr = th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, String> jpc() {
        HashMap map = new HashMap();
        ljh ljhVarUd = com.bytedance.sdk.openadsdk.utils.ud.ud();
        if (ljhVarUd != null) {
            map.put("adType", String.valueOf(ljhVarUd.ok()));
            map.put("aid", String.valueOf(ljhVarUd.uhv()));
            map.put("cid", ljhVarUd.yre());
            map.put("reqId", ljhVarUd.cev());
            map.put("rit", ljhVarUd.kdv("-1"));
            int iRa = ljhVarUd.ra();
            if (ljhVarUd.dk() != 2) {
                iRa = -1;
            }
            map.put("render_type", String.valueOf(iRa));
        }
        return map;
    }

    private static void ud(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        yt.lnr().qdl(ud(str), "https://" + str2 + "/monitor/collect/c/session?version_code=7702&device_platform=android&aid=10000001");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lnr(String str, String str2) {
        ud(str, str2);
    }

    public static void reportPvFromBackGround() {
        if (mml) {
            ud(fs.qdl(yt.qdl()), gy.jl());
        }
    }

    private static JSONObject ud(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("sdk_version", BuildConfig.VERSION_NAME);
            jSONObject3.put("host_app_id", lnr);
            jSONObject2.putOpt("custom", jSONObject3);
            jSONObject2.put("os", "Android");
            jSONObject2.put("os_version", Build.VERSION.RELEASE);
            jSONObject2.put("device_model", Build.MODEL);
            jSONObject2.put("device_brand", Build.BRAND);
            jSONObject2.put("sdk_version_name", "0.0.5");
            jSONObject2.put("aid", "10000001");
            jSONObject2.put("update_version_code", BuildConfig.VERSION_CODE);
            jSONObject2.put("bd_did", str);
            jSONObject.putOpt("apm_id", "20000001");
            jSONObject.putOpt("header", jSONObject2);
            jSONObject.putOpt("local_time", Long.valueOf(System.currentTimeMillis()));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("local_time_ms", System.currentTimeMillis()));
            jSONObject.putOpt("launch", jSONArray);
        } catch (JSONException e) {
            aaj.lnr("ApmHelper", e.getMessage());
        }
        return jSONObject;
    }

    public static boolean isIsInit() {
        return qdl;
    }

    public static Pair<String, String> generateRequestHeader() {
        String string = "";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("gaid", com.bytedance.sdk.openadsdk.exc.qdl.ud.qdl.qdl().ud());
            jSONObject.put("ipv6", mml.ud("ttopenadsdk", PglSSConfig.CUSTOMINFO_KEY_IPV6, ""));
            jSONObject.put(TtmlNode.TAG_REGION, yt.mml().gt());
        } catch (JSONException unused) {
        }
        JSONObject jSONObjectEncryptType4WithNoWrapBase64 = PangleEncryptManager.encryptType4WithNoWrapBase64(jSONObject, new bch(PangleEncryptConstant.CryptDataScene.UNKNOWN));
        String str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        if (jSONObjectEncryptType4WithNoWrapBase64 != null) {
            int iOptInt = jSONObjectEncryptType4WithNoWrapBase64.optInt("cypher");
            if (iOptInt == 4) {
                string = jSONObjectEncryptType4WithNoWrapBase64.optString("message");
                str = "4";
            } else if (iOptInt == 3) {
                string = jSONObjectEncryptType4WithNoWrapBase64.optString("message");
                str = ExifInterface.GPS_MEASUREMENT_3D;
            } else {
                string = jSONObject.toString();
            }
        }
        return new Pair<>(str, string);
    }
}
