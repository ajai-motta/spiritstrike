package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.WindowManager;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.oth;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.android.exoplayer2.PlaybackException;
import com.google.common.net.HttpHeaders;
import com.pgl.ssdk.ces.out.DungeonFlag;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ljh implements oth<com.bytedance.sdk.openadsdk.mml.qdl> {
    private final Context qdl;

    ljh(Context context) {
        this.qdl = context;
    }

    @DungeonFlag
    private JSONObject qdl(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.bqt bqtVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            String strMzz = (bqtVar == null || TextUtils.isEmpty(bqtVar.qdl)) ? com.bytedance.sdk.openadsdk.utils.gy.mzz() : bqtVar.qdl;
            if (i == 7) {
                if (bqtVar != null && bqtVar.ud > 0) {
                    jSONObject2.put("req_type", bqtVar.ud);
                }
            } else if (i == 8) {
                if (bqtVar != null && bqtVar.lnr > 0) {
                    jSONObject2.put("req_type", bqtVar.lnr);
                }
            } else if (i == 3 && bqtVar != null && bqtVar.mml > 0) {
                jSONObject2.put("req_type", bqtVar.mml);
            }
            try {
                String strRq = yt.mml().rq();
                String strRc = yt.mml().rc();
                if (strRq != null && strRc != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("version", strRq);
                    jSONObject3.put("param", strRc);
                    jSONObject2.put("abtest", jSONObject3);
                }
            } catch (Throwable unused) {
            }
            jSONObject2.put("request_id", strMzz);
            com.bytedance.sdk.openadsdk.utils.gy.qdl(jSONObject2);
            jSONObject2.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject2.put("js_render_ver", com.bytedance.sdk.openadsdk.core.tvp.fs.ud());
            jSONObject2.put("js_render_v3_ver", com.bytedance.sdk.openadsdk.core.tvp.fs.lnr());
            jSONObject2.put("source_type", "app");
            jSONObject2.put("app", ud());
            jSONObject2.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, DeviceUtils.qdl(this.qdl, true));
            jSONObject2.put("user", qdl(adSlot));
            jSONObject2.put("ua", com.bytedance.sdk.openadsdk.utils.gy.mml());
            jSONObject2.put("channel", "main");
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(qdl(adSlot, i, bqtVar));
            jSONObject2.put("adslots", jSONArray);
            qdl(jSONObject2, bqtVar);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject2.put("ts", jCurrentTimeMillis);
            String strConcat = "";
            if (adSlot.getCodeId() != null && strMzz != null) {
                strConcat = String.valueOf(jCurrentTimeMillis).concat(adSlot.getCodeId()).concat(strMzz);
            }
            jSONObject2.put("req_sign", com.bytedance.sdk.component.utils.mzz.qdl(strConcat));
            if (com.bytedance.sdk.openadsdk.core.to.lnr.mzz() != 0) {
                jSONObject2.put("pglx", String.valueOf(com.bytedance.sdk.openadsdk.core.to.lnr.mzz()));
            }
            jSONObject2.put("adx_id", tvp.ud().bch());
            com.bytedance.sdk.openadsdk.mo.ud.qdl().qdl(jSONObject2);
            jSONObject = qdl(PangleEncryptConstant.CryptDataScene.GET_ADS, jSONObject2);
            if (jSONObject != null) {
                jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
                jSONObject.put("oversea_version_type", 1);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.lnr("body data exception", th);
        }
        return jSONObject;
    }

    private void qdl(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.bqt bqtVar) {
        if (bqtVar == null || bqtVar.mzz == null) {
            return;
        }
        try {
            jSONObject.put("source_temai_product_ids", bqtVar.mzz);
        } catch (Exception unused) {
        }
    }

    private boolean mml(String str) {
        if (com.bytedance.sdk.openadsdk.core.jpc.ud.qdl()) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.jpc.ud.qdl(str)) {
            return false;
        }
        String strUd = com.bytedance.sdk.openadsdk.core.jpc.ud.ud();
        if (!TextUtils.isEmpty(strUd)) {
            com.bytedance.sdk.openadsdk.mml.lnr.qdl(strUd, System.currentTimeMillis());
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.oth
    public void qdl(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.bqt bqtVar, int i, aaj aajVar) {
        if (bqtVar.mo || !TextUtils.isEmpty(adSlot.getBidAdm())) {
            qdl(adSlot, bqtVar, i, (oth.qdl) aajVar);
            return;
        }
        if (!qdl(bqtVar) && aajVar != null) {
            String strQdl = aajVar.qdl();
            if (!TextUtils.isEmpty(strQdl)) {
                bqtVar.fs = strQdl;
                bqtVar.exu = aajVar;
            }
        }
        qdl(adSlot, bqtVar, i, (oth.qdl) aajVar);
    }

    private boolean qdl(com.bytedance.sdk.openadsdk.core.model.bqt bqtVar) {
        if (bqtVar != null) {
            return bqtVar.ud == 2 || bqtVar.lnr == 2 || bqtVar.mml == 2;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.oth
    public void qdl(final AdSlot adSlot, final com.bytedance.sdk.openadsdk.core.model.bqt bqtVar, final int i, oth.qdl qdlVar) {
        if (bqtVar != null && (bqtVar.ud == 2 || bqtVar.lnr == 2 || bqtVar.mml == 2)) {
            adSlot.setPreload(true);
        }
        final com.bytedance.sdk.openadsdk.core.ud.qdl qdlVar2 = new com.bytedance.sdk.openadsdk.core.ud.qdl(qdlVar, adSlot, (adSlot.isPreload() || bqtVar == null || bqtVar.mo) ? false : true);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            rdp.ud().post(new com.bytedance.sdk.component.jpc.jpc("getAd") { // from class: com.bytedance.sdk.openadsdk.core.ljh.1
                @Override // java.lang.Runnable
                public void run() {
                    ljh.this.ud(adSlot, bqtVar, i, qdlVar2);
                }
            });
        } else {
            ud(adSlot, bqtVar, i, qdlVar2);
        }
        if (com.bytedance.sdk.openadsdk.jyq.qdl.lnr()) {
            rdp.wd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v29, types: [com.bytedance.sdk.openadsdk.exc.qdl.ud.qdl] */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.bytedance.sdk.openadsdk.core.ljh] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r28v0, types: [com.bytedance.sdk.openadsdk.core.ljh] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.Map] */
    public void ud(final AdSlot adSlot, final com.bytedance.sdk.openadsdk.core.model.bqt bqtVar, final int i, final oth.qdl qdlVar) {
        Object udVar;
        com.bytedance.sdk.openadsdk.core.model.qdl qdlVar2;
        ?? r12 = this;
        if (!yt.mml().mlb()) {
            qdlVar.qdl(40060, jpc.qdl(40060));
            return;
        }
        boolean zLnr = com.bytedance.sdk.openadsdk.jyq.qdl.lnr();
        if (!zLnr) {
            rdp.mo();
        }
        final com.bytedance.sdk.openadsdk.core.model.lnr lnrVar = new com.bytedance.sdk.openadsdk.core.model.lnr();
        lnrVar.qdl(adSlot);
        if (!com.bytedance.sdk.openadsdk.core.settings.wd.qdl()) {
            if (qdlVar != null) {
                qdlVar.qdl(1000, "Ad request is temporarily paused, Please contact your AM");
                lnrVar.qdl(1000);
                com.bytedance.sdk.openadsdk.core.model.lnr.qdl(lnrVar);
                return;
            }
            return;
        }
        if (!yt.mml().jjk()) {
            if (qdlVar != null) {
                qdlVar.qdl(-16, jpc.qdl(-16));
                lnrVar.qdl(1001);
                com.bytedance.sdk.openadsdk.core.model.lnr.qdl(lnrVar);
                return;
            }
            return;
        }
        if (qdlVar == null) {
            return;
        }
        if (r12.mml(adSlot.getCodeId())) {
            qdlVar.qdl(-8, jpc.qdl(-8));
            return;
        }
        if (!TextUtils.isEmpty(adSlot.getBidAdm()) && !bqtVar.mo) {
            lnrVar.ud(2);
            lnrVar.qdl(adSlot.getBidAdm());
            if (com.bytedance.sdk.component.utils.bjy.mml()) {
                com.bykv.vk.openvk.qdl.qdl.qdl.wd.ud.qdl(adSlot.getBidAdm());
            }
            if (yt.mml().car() && kdv.qdl().mml() == 1) {
                com.bytedance.sdk.openadsdk.utils.gy.qdl("Pangle_Debug_Mode", adSlot.getBidAdm(), r12.qdl);
            }
            try {
                JSONObject jSONObjectQdl = r12.qdl(new JSONObject(adSlot.getBidAdm()));
                if (jSONObjectQdl == null) {
                    lnrVar.lnr(12);
                    r12.qdl(qdlVar, lnrVar);
                    return;
                }
                qdl qdlVarQdl = qdl.qdl(jSONObjectQdl, adSlot, bqtVar);
                lnrVar.qdl(qdlVarQdl.to);
                fs.qdl(qdlVarQdl.tvp);
                if (qdlVarQdl.mml != 20000) {
                    qdlVar.qdl(qdlVarQdl.mml, qdlVarQdl.mzz);
                    lnrVar.qdl(qdlVarQdl.mml);
                    lnrVar.lnr(9);
                    com.bytedance.sdk.openadsdk.core.model.lnr.qdl(lnrVar);
                    return;
                }
                if (qdlVarQdl.jpc == null) {
                    lnrVar.lnr(13);
                    r12.qdl(qdlVar, lnrVar);
                    return;
                }
                if (qdlVarQdl.jpc.mml() != null && !qdlVarQdl.jpc.mml().isEmpty()) {
                    com.bytedance.sdk.openadsdk.bjy.lnr.qdl(qdlVarQdl.jpc.mml().get(0));
                }
                r12.qdl(qdlVarQdl.jpc);
                if (r12.qdl(qdlVarQdl.jpc, qdlVar)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.fs.lnr.mml.qdl(qdlVarQdl.jpc);
                qdlVar.qdl(qdlVarQdl.jpc, lnrVar);
                Map<String, com.bytedance.sdk.openadsdk.core.model.ljh> mapQdl = com.bytedance.sdk.openadsdk.core.model.qdl.qdl(qdlVarQdl.jpc);
                if (mapQdl != null) {
                    com.bytedance.sdk.openadsdk.wd.ud.qdl().qdl(mapQdl);
                }
                r12.ud(qdlVarQdl.jpc);
                com.bytedance.sdk.openadsdk.core.mzz.qdl.qdl().qdl(qdlVarQdl.jpc);
                return;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.aaj.qdl("NetApiImpl", "get ad error: ", th);
                lnrVar.lnr(14);
                lnrVar.ud(th.getMessage());
                r12.qdl(qdlVar, lnrVar);
                return;
            }
        }
        if (bqtVar != null && !TextUtils.isEmpty(bqtVar.fs)) {
            try {
                JSONObject jSONObjectQdl2 = r12.qdl(new JSONObject(bqtVar.fs));
                if (jSONObjectQdl2 != null) {
                    qdl qdlVarQdl2 = qdl.qdl(jSONObjectQdl2, adSlot, bqtVar);
                    if (bqtVar.exu != null && (qdlVar2 = qdlVarQdl2.jpc) != null && bqtVar.exu.qdl(qdlVar2)) {
                        com.bytedance.sdk.openadsdk.core.fs.lnr.mml.qdl(qdlVar2);
                        qdlVar.qdl(qdlVar2, lnrVar);
                        return;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        JSONObject jSONObjectQdl3 = qdl(adSlot, bqtVar, i);
        if (jSONObjectQdl3 == null) {
            qdlVar.qdl(-9, jpc.qdl(-9));
            lnrVar.qdl(-9);
            com.bytedance.sdk.openadsdk.core.model.lnr.qdl(lnrVar);
            return;
        }
        if (yt.mml().car() && kdv.qdl().mml() == 1) {
            com.bytedance.sdk.openadsdk.utils.gy.qdl("Pangle_Debug_Mode", jSONObjectQdl3.toString(), r12.qdl);
        }
        String strQdl = com.bytedance.sdk.openadsdk.utils.gy.qdl("/api/ad/union/sdk/get_ads/", true, false);
        final com.bytedance.sdk.component.wd.ud.mml mmlVarUd = com.bytedance.sdk.openadsdk.jl.ud.ud().lnr().ud();
        try {
            mmlVarUd.ud(com.bytedance.sdk.openadsdk.jpc.mml.qdl(mmlVarUd, strQdl));
        } catch (Exception unused2) {
        }
        mmlVarUd.qdl(jSONObjectQdl3.toString(), yt.mml().jl());
        Map<String, String> mapQdl2 = com.bytedance.sdk.openadsdk.core.to.lnr.qdl(strQdl, jSONObjectQdl3.toString());
        if (mapQdl2 != null && mapQdl2.size() > 0) {
            for (String str : mapQdl2.keySet()) {
                try {
                    mmlVarUd.ud(str, mapQdl2.get(str));
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.aaj.lnr("NetApiImpl", e.getMessage());
                }
            }
        }
        try {
            mmlVarUd.ud(HttpHeaders.USER_AGENT, com.bytedance.sdk.openadsdk.utils.gy.mml());
            r12.qdl(mmlVarUd, jSONObjectQdl3);
        } catch (Exception unused3) {
        }
        final com.bytedance.sdk.openadsdk.utils.mrf mrfVarUd = com.bytedance.sdk.openadsdk.utils.mrf.ud();
        final Map<String, Object> requestExtraMap = adSlot.getRequestExtraMap();
        boolean z = tvp.ud().yt() && requestExtraMap != null;
        if (z) {
            requestExtraMap.put("pgad_start", mrfVarUd);
        }
        mmlVarUd.qdl(10);
        mmlVarUd.qdl("get_ad");
        com.bytedance.sdk.openadsdk.yt.lnr.qdl(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.ljh.8
            @Override // com.bytedance.sdk.openadsdk.yt.mml
            public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar3 = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                qdlVar3.ud("get_ad");
                qdlVar3.lnr(adSlot.getCodeId());
                qdlVar3.mml(com.bytedance.sdk.openadsdk.utils.gy.lnr(adSlot.getDurationSlotType()));
                return qdlVar3;
            }
        });
        if (com.bytedance.sdk.component.utils.bjy.mml()) {
            Thread.currentThread().getName();
        }
        if (!zLnr) {
            final boolean z2 = z;
            mmlVarUd.qdl(new com.bytedance.sdk.component.wd.qdl.ud() { // from class: com.bytedance.sdk.openadsdk.core.ljh.9
                @Override // com.bytedance.sdk.component.wd.qdl.qdl
                public void qdl(com.bytedance.sdk.component.wd.ud.lnr lnrVar2, com.bytedance.sdk.component.wd.ud udVar2) {
                    ljh.this.qdl(lnrVar2, udVar2, z2, (Map<String, Object>) requestExtraMap, mrfVarUd, adSlot, lnrVar, qdlVar, bqtVar, i);
                }

                @Override // com.bytedance.sdk.component.wd.qdl.ud
                public void qdl(com.bytedance.sdk.component.wd.ud.lnr lnrVar2, IOException iOException, com.bytedance.sdk.component.wd.ud udVar2) {
                    ljh.this.qdl(mmlVarUd, iOException, udVar2, adSlot, z2, (Map<String, Object>) requestExtraMap, qdlVar, lnrVar);
                    if (lnrVar2 != null) {
                        com.bytedance.sdk.openadsdk.utils.jyq.qdl(lnrVar2.mml());
                    }
                }
            });
            r12 = 0;
        } else {
            try {
                com.bytedance.sdk.component.wd.ud udVarQdl = mmlVarUd.qdl();
                if (udVarQdl == null) {
                    udVar = new com.bytedance.sdk.component.wd.ud(false, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED, "response is null, content type is not support!!", null, "REQUEST_BODY_NULL", 1L, 1L);
                }
                com.bytedance.sdk.component.wd.ud udVar2 = udVarQdl;
                try {
                    if (udVar2.mo()) {
                        udVar = requestExtraMap;
                        r12 = 0;
                        qdl(mmlVarUd, udVar2, z, requestExtraMap, mrfVarUd, adSlot, lnrVar, qdlVar, bqtVar, i);
                    } else {
                        Map<String, Object> map = requestExtraMap;
                        boolean z3 = false;
                        qdl(mmlVarUd, new IOException(udVar2.ud()), udVar2, adSlot, z, map, qdlVar, lnrVar);
                        r12 = z3;
                        udVar = map;
                        if (mmlVarUd != null) {
                            com.bytedance.sdk.openadsdk.utils.jyq.qdl(mmlVarUd.mml());
                            r12 = z3;
                            udVar = map;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    qdl(mmlVarUd, new IOException(th.getMessage()), new com.bytedance.sdk.component.wd.ud(false, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED, "execute method throw exception", null, "REQUEST_BODY_EXCEPTION", 1L, 1L), adSlot, z, udVar, qdlVar, lnrVar);
                }
            } catch (Throwable th3) {
                th = th3;
                udVar = requestExtraMap;
                r12 = 0;
            }
        }
        com.bytedance.sdk.openadsdk.exc.qdl.ud.qdl.qdl().qdl(r12);
    }

    private void qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar) {
        com.bytedance.sdk.openadsdk.core.model.ljh ljhVarMo;
        if (qdlVar == null || (ljhVarMo = qdlVar.mo()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.settings.rq.vu(ljhVarMo.az());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(com.bytedance.sdk.component.wd.ud.mml mmlVar, IOException iOException, com.bytedance.sdk.component.wd.ud udVar, final AdSlot adSlot, boolean z, Map<String, Object> map, oth.qdl qdlVar, com.bytedance.sdk.openadsdk.core.model.lnr lnrVar) {
        String message;
        int iQdl;
        com.bytedance.sdk.openadsdk.yt.lnr.lnr(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.ljh.10
            @Override // com.bytedance.sdk.openadsdk.yt.mml
            public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar2 = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                qdlVar2.ud("get_ad");
                qdlVar2.lnr(adSlot.getCodeId());
                qdlVar2.mml(com.bytedance.sdk.openadsdk.utils.gy.lnr(adSlot.getDurationSlotType()));
                qdlVar2.qdl(BuildConfig.VERSION_NAME);
                return qdlVar2;
            }
        });
        if (udVar != null) {
            message = udVar.ud();
        } else if (iOException == null) {
            message = "";
        } else {
            message = iOException.getMessage();
        }
        com.bytedance.sdk.openadsdk.utils.mrf mrfVarUd = com.bytedance.sdk.openadsdk.utils.mrf.ud();
        if (z) {
            map.put("pgad_end", Long.valueOf(mrfVarUd.qdl));
        }
        if (yt.mml().car() && kdv.qdl().mml() == 1) {
            com.bytedance.sdk.openadsdk.utils.gy.qdl("Pangle_Debug_Mode", iOException != null ? iOException.getMessage() : null, this.qdl);
        }
        if (udVar != null) {
            iQdl = udVar.qdl();
        } else {
            iQdl = (iOException == null || !(iOException instanceof SocketTimeoutException)) ? 601 : TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE;
        }
        if (qdlVar != null) {
            qdlVar.qdl(iQdl, message);
        }
        Integer.valueOf(iQdl);
        lnrVar.qdl(iQdl);
        lnrVar.lnr(10);
        lnrVar.ud(message);
        com.bytedance.sdk.openadsdk.core.model.lnr.qdl(lnrVar);
        com.bytedance.sdk.openadsdk.bjy.qdl.mzz.qdl("get_ad", mmlVar.mml(), iQdl, message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void qdl(com.bytedance.sdk.component.wd.ud.lnr lnrVar, com.bytedance.sdk.component.wd.ud udVar, boolean z, Map<String, Object> map, com.bytedance.sdk.openadsdk.utils.mrf mrfVar, final AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.lnr lnrVar2, oth.qdl qdlVar, com.bytedance.sdk.openadsdk.core.model.bqt bqtVar, int i) {
        String str;
        oth.qdl qdlVar2;
        com.bytedance.sdk.openadsdk.core.model.lnr lnrVar3;
        JSONObject jSONObject;
        String str2;
        if (z) {
            map.put("pgad_end", mrfVar);
        }
        if (udVar == null) {
            return;
        }
        if (udVar.mo()) {
            com.bytedance.sdk.openadsdk.yt.lnr.ud(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.ljh.11
                @Override // com.bytedance.sdk.openadsdk.yt.mml
                public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                    com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar3 = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                    qdlVar3.ud("get_ad");
                    qdlVar3.lnr(adSlot.getCodeId());
                    qdlVar3.mml(com.bytedance.sdk.openadsdk.utils.gy.lnr(adSlot.getDurationSlotType()));
                    qdlVar3.qdl(BuildConfig.VERSION_NAME);
                    return qdlVar3;
                }
            });
            try {
                com.bytedance.sdk.openadsdk.utils.mrf mrfVarUd = com.bytedance.sdk.openadsdk.utils.mrf.ud();
                String strMml = udVar.mml();
                lnrVar2.qdl(strMml);
                JSONObject jSONObject2 = new JSONObject(strMml);
                if (yt.mml().car() && kdv.qdl().mml() == 1) {
                    com.bytedance.sdk.openadsdk.utils.gy.qdl("Pangle_Debug_Mode", jSONObject2.toString(), this.qdl);
                }
                JSONObject jSONObjectQdl = qdl(jSONObject2);
                if (jSONObjectQdl == null) {
                    lnrVar2.lnr(12);
                    qdl(qdlVar, lnrVar2);
                    return;
                }
                qdl qdlVarQdl = qdl.qdl(jSONObjectQdl, adSlot, bqtVar);
                lnrVar2.qdl(qdlVarQdl.to);
                fs.qdl(qdlVarQdl.tvp);
                if (qdlVarQdl.mml != 20000) {
                    lnrVar2.qdl(qdlVarQdl.mml);
                    if (!yt.mml().ax() && qdlVarQdl.mml == 40029) {
                        qdlVar.qdl(-100, jpc.qdl(-100));
                    } else {
                        qdlVar.qdl(qdlVarQdl.mml, qdlVarQdl.mzz);
                    }
                    lnrVar2.lnr(9);
                    com.bytedance.sdk.openadsdk.core.model.lnr.qdl(lnrVar2);
                    return;
                }
                if (qdlVarQdl.jpc == null) {
                    lnrVar2.lnr(13);
                    qdl(qdlVar, lnrVar2);
                    return;
                }
                if (qdl(qdlVarQdl.jpc, qdlVar)) {
                    return;
                }
                qdlVarQdl.jpc.lnr(strMml);
                com.bytedance.sdk.openadsdk.utils.mrf mrfVarUd2 = com.bytedance.sdk.openadsdk.utils.mrf.ud();
                if (bqtVar != null && bqtVar.rq != null) {
                    bqtVar.rq.qdl(mrfVar, mrfVarUd, qdlVarQdl.qdl, mrfVarUd2);
                }
                byte b = com.bytedance.sdk.openadsdk.jyq.qdl.mml() && i == 1;
                if (b != false && qdlVarQdl.jpc.mml() != null && !qdlVarQdl.jpc.mml().isEmpty()) {
                    com.bytedance.sdk.openadsdk.core.model.ljh ljhVar = qdlVarQdl.jpc.mml().get(0);
                    String strLnr = com.bytedance.sdk.openadsdk.utils.gy.lnr(i);
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    long jQdl = 0;
                    if (bqtVar != null) {
                        try {
                            jSONObject = jSONObject3;
                            str2 = strLnr;
                            if (bqtVar.to.qdl > 0) {
                                jQdl = mrfVarUd2.qdl(bqtVar.to);
                            }
                        } catch (Exception unused) {
                        }
                    } else {
                        jSONObject = jSONObject3;
                        str2 = strLnr;
                    }
                    long j = jQdl;
                    if (ljhVar != null) {
                        boolean zDps = ljhVar.dps();
                        jSONObject4.put("is_new_engine", zDps ? 1 : 0);
                        jSONObject4.put("webview_cache_size", zDps ? com.bytedance.sdk.component.adexpress.mzz.mzz.qdl().mml() : com.bytedance.sdk.component.adexpress.mzz.mzz.qdl().lnr());
                    }
                    JSONObject jSONObject5 = jSONObject;
                    String str3 = str2;
                    qdl(udVar.wd(), bqtVar, mrfVar, mrfVarUd, qdlVarQdl.qdl, mrfVarUd2, ljhVar, str3, jSONObject4, true);
                    jSONObject5.put(TypedValues.TransitionType.S_DURATION, j);
                    jSONObject5.put("extra_data", jSONObject4);
                    jSONObject5.put(ViewHierarchyConstants.TAG_KEY, str3);
                    jSONObject5.put("callback_start", mrfVarUd2.qdl());
                    qdlVarQdl.jpc.qdl(jSONObject5);
                }
                com.bytedance.sdk.openadsdk.core.fs.lnr.mml.qdl(qdlVarQdl.jpc);
                qdlVar.qdl(qdlVarQdl.jpc, lnrVar2);
                ud(qdlVarQdl.jpc);
                com.bytedance.sdk.openadsdk.core.mzz.qdl.qdl().qdl(qdlVarQdl.jpc);
                Map<String, com.bytedance.sdk.openadsdk.core.model.ljh> mapQdl = com.bytedance.sdk.openadsdk.core.model.qdl.qdl(qdlVarQdl.jpc);
                if (mapQdl != null) {
                    com.bytedance.sdk.openadsdk.wd.ud.qdl().qdl(mapQdl);
                }
                if (qdlVarQdl.jpc.mml() == null || qdlVarQdl.jpc.mml().isEmpty() || b == true) {
                    return;
                }
                str = "get_ad";
                qdlVar2 = qdlVar;
                lnrVar3 = lnrVar2;
                try {
                    qdl(udVar.wd(), bqtVar, mrfVar, mrfVarUd, qdlVarQdl.qdl, mrfVarUd2, qdlVarQdl.jpc.mml().get(0), com.bytedance.sdk.openadsdk.utils.gy.lnr(i));
                } catch (Throwable th) {
                    th = th;
                    com.bytedance.sdk.component.utils.aaj.qdl("NetApiImpl", "get ad error: ", th);
                    lnrVar3.ud(th.getMessage());
                    lnrVar3.lnr(14);
                    qdl(qdlVar2, lnrVar3);
                    com.bytedance.sdk.openadsdk.bjy.qdl.mzz.qdl(str, lnrVar.mml(), -9, th.getMessage());
                    ApmHelper.reportCustomError("", "parse_error", th);
                }
            } catch (Throwable th2) {
                th = th2;
                str = "get_ad";
                qdlVar2 = qdlVar;
                lnrVar3 = lnrVar2;
            }
        } else {
            com.bytedance.sdk.openadsdk.yt.lnr.lnr(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.ljh.12
                @Override // com.bytedance.sdk.openadsdk.yt.mml
                public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                    com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar3 = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                    qdlVar3.ud("get_ad");
                    qdlVar3.lnr(adSlot.getCodeId());
                    qdlVar3.mml(com.bytedance.sdk.openadsdk.utils.gy.lnr(adSlot.getDurationSlotType()));
                    qdlVar3.qdl(BuildConfig.VERSION_NAME);
                    return qdlVar3;
                }
            });
            int iQdl = udVar.qdl();
            String strUd = udVar.ud();
            qdlVar.qdl(iQdl, strUd);
            lnrVar2.qdl(iQdl);
            lnrVar2.lnr(11);
            lnrVar2.ud(strUd);
            com.bytedance.sdk.openadsdk.core.model.lnr.qdl(lnrVar2);
            com.bytedance.sdk.openadsdk.bjy.qdl.mzz.qdl("get_ad", lnrVar.mml(), iQdl, strUd);
        }
    }

    private boolean qdl(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, oth.qdl qdlVar2) {
        if (qdlVar == null) {
            qdlVar2.qdl(40053, jpc.qdl(40053));
            return true;
        }
        List<com.bytedance.sdk.openadsdk.core.model.ljh> listMml = qdlVar.mml();
        if (listMml.isEmpty()) {
            return false;
        }
        for (final com.bytedance.sdk.openadsdk.core.model.ljh ljhVar : listMml) {
            if (TextUtils.isEmpty(ljhVar.rjh().ud()) || TextUtils.isEmpty(ljhVar.rjh().lnr())) {
                qdlVar2.qdl(40053, jpc.qdl(40053));
                com.bytedance.sdk.openadsdk.mml.lnr.qdl(System.currentTimeMillis(), ljhVar, com.bytedance.sdk.openadsdk.utils.gy.qdl(ljhVar), "material_error", new com.bytedance.sdk.openadsdk.bjy.lnr.qdl() { // from class: com.bytedance.sdk.openadsdk.core.ljh.13
                    @Override // com.bytedance.sdk.openadsdk.bjy.lnr.qdl, com.bytedance.sdk.openadsdk.bjy.lnr.ud
                    public JSONObject qdl() {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("ad_label", ljhVar.rjh().mo());
                            return jSONObject;
                        } catch (Throwable unused) {
                            return null;
                        }
                    }
                });
                return true;
            }
        }
        return false;
    }

    private void ud(com.bytedance.sdk.openadsdk.core.model.qdl qdlVar) {
        List<com.bytedance.sdk.openadsdk.core.model.ljh> listMml = qdlVar.mml();
        if (listMml == null || listMml.size() == 0) {
            return;
        }
        for (int i = 0; i < listMml.size(); i++) {
            com.bytedance.sdk.openadsdk.core.model.ljh ljhVar = listMml.get(i);
            if (ljhVar != null && ljhVar.gt() == null) {
                qdl("", 0, 0, ljhVar.hcs(), ljhVar);
                qdl("", 0, 0, ljhVar.kj(), ljhVar);
                List<com.bytedance.sdk.openadsdk.core.model.jl> listVm = ljhVar.vm();
                if (listVm != null && listVm.size() > 0) {
                    for (int i2 = 0; i2 < listVm.size(); i2++) {
                        qdl(ljhVar, listVm.get(i2));
                    }
                }
                if (ljhVar.tdy() != null) {
                    qdl(ljhVar.tdy().to(), ljhVar.tdy().lnr(), ljhVar.tdy().ud(), (com.bytedance.sdk.openadsdk.core.model.jl) null, ljhVar);
                }
            }
        }
    }

    private void qdl(String str, int i, int i2, com.bytedance.sdk.openadsdk.core.model.jl jlVar, com.bytedance.sdk.openadsdk.core.model.ljh ljhVar) {
        if (!TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.tvp.mml.qdl(str).qdl(i).ud(i2).mzz(ax.mzz(yt.qdl())).mml(ax.lnr(yt.qdl())).lnr(1).qdl(new com.bytedance.sdk.openadsdk.tvp.ud(ljhVar, str, null), 4);
        } else {
            if (jlVar == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.tvp.mml.qdl(jlVar).lnr(1).qdl(new com.bytedance.sdk.openadsdk.tvp.ud(ljhVar, jlVar.qdl(), null), 4);
        }
    }

    private void qdl(com.bytedance.sdk.openadsdk.core.model.ljh ljhVar, com.bytedance.sdk.openadsdk.core.model.jl jlVar) {
        if (jlVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.tvp.mml.qdl(jlVar).lnr(1).qdl(new com.bytedance.sdk.openadsdk.tvp.ud(ljhVar, jlVar.qdl(), new com.bytedance.sdk.component.mzz.jtx() { // from class: com.bytedance.sdk.openadsdk.core.ljh.14
            @Override // com.bytedance.sdk.component.mzz.jtx
            public void qdl(int i, String str, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.mzz.jtx
            public void qdl(com.bytedance.sdk.component.mzz.rq rqVar) {
            }
        }), 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void qdl(com.bytedance.sdk.component.ud.qdl.to r14, com.bytedance.sdk.openadsdk.core.model.bqt r15, com.bytedance.sdk.openadsdk.utils.mrf r16, com.bytedance.sdk.openadsdk.utils.mrf r17, int r18, com.bytedance.sdk.openadsdk.utils.mrf r19, com.bytedance.sdk.openadsdk.core.model.ljh r20, java.lang.String r21) {
        /*
            r13 = this;
            r1 = r15
            com.bytedance.sdk.openadsdk.core.settings.rq r0 = com.bytedance.sdk.openadsdk.core.yt.mml()
            boolean r0 = r0.dk()
            if (r0 != 0) goto Lc
            return
        Lc:
            org.json.JSONObject r10 = new org.json.JSONObject
            r10.<init>()
            r2 = 0
            if (r1 == 0) goto L26
            com.bytedance.sdk.openadsdk.utils.mrf r0 = r1.to     // Catch: java.lang.Exception -> L4b
            long r4 = r0.qdl     // Catch: java.lang.Exception -> L4b
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 <= 0) goto L26
            com.bytedance.sdk.openadsdk.utils.mrf r0 = r1.to     // Catch: java.lang.Exception -> L4b
            r5 = r19
            long r2 = r5.qdl(r0)     // Catch: java.lang.Exception -> L4b
            goto L28
        L26:
            r5 = r19
        L28:
            r11 = r2
            r9 = 0
            r0 = r14
            r1 = r15
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r10
            qdl(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L4b
            java.lang.String r0 = "load_ad_time"
            r14 = r20
            r15 = r21
            r16 = r0
            r17 = r11
            r19 = r10
            com.bytedance.sdk.openadsdk.mml.lnr.qdl(r14, r15, r16, r17, r19)     // Catch: java.lang.Exception -> L4b
        L4b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.ljh.qdl(com.bytedance.sdk.component.ud.qdl.to, com.bytedance.sdk.openadsdk.core.model.bqt, com.bytedance.sdk.openadsdk.utils.mrf, com.bytedance.sdk.openadsdk.utils.mrf, int, com.bytedance.sdk.openadsdk.utils.mrf, com.bytedance.sdk.openadsdk.core.model.ljh, java.lang.String):void");
    }

    private static void qdl(com.bytedance.sdk.component.ud.qdl.to toVar, com.bytedance.sdk.openadsdk.core.model.bqt bqtVar, com.bytedance.sdk.openadsdk.utils.mrf mrfVar, com.bytedance.sdk.openadsdk.utils.mrf mrfVar2, int i, com.bytedance.sdk.openadsdk.utils.mrf mrfVar3, com.bytedance.sdk.openadsdk.core.model.ljh ljhVar, String str, JSONObject jSONObject, boolean z) throws JSONException {
        if (bqtVar != null && bqtVar.to.qdl > 0) {
            jSONObject.put("client_start_time", mrfVar.qdl(bqtVar.to));
        }
        jSONObject.put("network_time", mrfVar2.qdl(mrfVar));
        jSONObject.put("sever_time", i);
        jSONObject.put("client_end_time", mrfVar3.qdl(mrfVar2));
        if (str.equals("open_ad")) {
            jSONObject.put("is_icon_only", ljhVar.xmv() ? 1 : 0);
        }
        if (ljhVar != null) {
            jSONObject.put("render_control_type", ljhVar.dk());
        }
        jSONObject.put("webview_cache_size", com.bytedance.sdk.component.adexpress.mzz.mzz.qdl().lnr());
        jSONObject.put("sync_barrier_open", z ? 1 : 0);
        if (toVar.ud > 0) {
            jSONObject.put("enqueue_2_run_ts", toVar.lnr - toVar.ud);
            jSONObject.put("run_2_connect_end_ts", toVar.mzz - toVar.ud);
            jSONObject.put("connect_end_2_response_end_ts", toVar.mo - toVar.mzz);
            jSONObject.put("response_end_2_callback_end_ts", SystemClock.elapsedRealtime() - toVar.mo);
        }
    }

    private boolean lnr(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.oth
    @DungeonFlag
    public com.bytedance.sdk.openadsdk.mml.mzz qdl(JSONObject jSONObject, String str, boolean z) {
        try {
            System.currentTimeMillis();
            byte[] bArr = null;
            if (!com.bytedance.sdk.openadsdk.core.settings.wd.qdl()) {
                return null;
            }
            com.bytedance.sdk.component.wd.ud.mml mmlVarUd = com.bytedance.sdk.openadsdk.jl.ud.ud().lnr().ud();
            mmlVarUd.ud(str);
            if (com.bytedance.sdk.openadsdk.core.settings.rq.lnr().jut()) {
                mmlVarUd.ud("_disable_retry", "1");
            }
            boolean z2 = true;
            if (z) {
                boolean zQdl = com.bytedance.sdk.openadsdk.core.settings.rq.lnr().qdl(PangleEncryptConstant.CryptDataScene.APP_LOG);
                byte[] bArrMzz = mzz(jSONObject.toString());
                if (zQdl) {
                    Pair<Integer, byte[]> pairEncryptType4WithoutBase64 = PangleEncryptManager.encryptType4WithoutBase64(bArrMzz);
                    if (pairEncryptType4WithoutBase64 != null && pairEncryptType4WithoutBase64.second != null && ((byte[]) pairEncryptType4WithoutBase64.second).length > 0) {
                        bArr = (byte[]) pairEncryptType4WithoutBase64.second;
                        uw.ud(true);
                    } else {
                        int iIntValue = pairEncryptType4WithoutBase64 != null ? ((Integer) pairEncryptType4WithoutBase64.first).intValue() : 0;
                        uw.ud(false);
                        uw.qdl(1, PangleEncryptConstant.CryptDataScene.APP_LOG, iIntValue);
                    }
                }
                if (bArr != null) {
                    mmlVarUd.ud(HttpHeaders.CONTENT_ENCODING, "union_sdk_encode");
                    mmlVarUd.ud("x-pgli18n", "4");
                    mmlVarUd.qdl("application/octet-stream;tt-data=a", bArr);
                }
            }
            if (bArr == null) {
                try {
                    JSONObject jSONObjectQdl = com.bytedance.sdk.component.utils.qdl.qdl(jSONObject);
                    if (!lnr(jSONObjectQdl)) {
                        jSONObjectQdl = jSONObject;
                    }
                    qdl(mml(jSONObjectQdl), mmlVarUd);
                    mmlVarUd.qdl(jSONObjectQdl.toString(), yt.mml().jl());
                } catch (OutOfMemoryError e) {
                    com.bytedance.sdk.component.utils.aaj.lnr("NetApiImpl", e.toString());
                    return new com.bytedance.sdk.openadsdk.mml.mzz(false, -2, "encrypt_error", false);
                }
            }
            com.bytedance.sdk.component.wd.ud udVarQdl = mmlVarUd.qdl();
            boolean zMzz = (udVarQdl == null || !udVarQdl.mo() || TextUtils.isEmpty(udVarQdl.mml())) ? false : mzz(new JSONObject(udVarQdl.mml()));
            String strUd = "error unknown";
            int iQdl = udVarQdl != null ? udVarQdl.qdl() : 0;
            if (!zMzz && iQdl == 200) {
                strUd = "server say not success";
            } else {
                if (udVarQdl != null && udVarQdl.ud() != null) {
                    strUd = udVarQdl.ud();
                }
                z2 = false;
            }
            if (udVarQdl == null) {
                com.bytedance.sdk.openadsdk.bjy.qdl.mzz.qdl("applog", str, -1, "response is null");
            } else if (!udVarQdl.mo()) {
                com.bytedance.sdk.openadsdk.bjy.qdl.mzz.qdl("applog", str, iQdl, udVarQdl.ud());
            }
            qdl(jSONObject, z);
            return new com.bytedance.sdk.openadsdk.mml.mzz(zMzz, iQdl, strUd, z2);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.qdl("NetApiImpl", "uploadEvent error", th);
            return new com.bytedance.sdk.openadsdk.mml.mzz(false, 509, "service_busy", false);
        }
    }

    private void qdl(Map<String, String> map, com.bytedance.sdk.component.wd.ud.mml mmlVar) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                try {
                    mmlVar.ud(entry.getKey(), entry.getValue());
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.aaj.lnr("NetApiImpl", "ADD header exceptopn", e.getMessage());
                }
            }
        }
        try {
            mmlVar.ud(HttpHeaders.USER_AGENT, com.bytedance.sdk.openadsdk.utils.gy.mml());
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.aaj.lnr("NetApiImpl", "ADD header exceptopn", e2.getMessage());
        }
    }

    private void qdl(JSONObject jSONObject, boolean z) throws Throwable {
        if (tvp.ud().jl()) {
            try {
                jSONObject.getJSONObject("header").put("aid", "4562");
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.aaj.lnr("NetApiImpl", "reportETEvent error", e.getMessage());
            }
            com.bytedance.sdk.component.wd.ud.mml mmlVarUd = com.bytedance.sdk.openadsdk.jl.ud.ud().lnr().ud();
            mmlVarUd.ud(com.bytedance.sdk.openadsdk.utils.gy.jyq());
            byte[] bArr = null;
            if (z) {
                boolean zQdl = com.bytedance.sdk.openadsdk.core.settings.rq.lnr().qdl(PangleEncryptConstant.CryptDataScene.APP_LOG);
                byte[] bArrMzz = mzz(jSONObject.toString());
                if (zQdl) {
                    Pair<Integer, byte[]> pairEncryptType4WithoutBase64 = PangleEncryptManager.encryptType4WithoutBase64(bArrMzz);
                    if (pairEncryptType4WithoutBase64 != null && pairEncryptType4WithoutBase64.second != null && ((byte[]) pairEncryptType4WithoutBase64.second).length > 0) {
                        byte[] bArr2 = (byte[]) pairEncryptType4WithoutBase64.second;
                        uw.ud(true);
                        bArr = bArr2;
                    } else {
                        int iIntValue = pairEncryptType4WithoutBase64 != null ? ((Integer) pairEncryptType4WithoutBase64.first).intValue() : 0;
                        uw.ud(false);
                        uw.qdl(1, PangleEncryptConstant.CryptDataScene.APP_LOG, iIntValue);
                    }
                }
                if (bArr != null) {
                    mmlVarUd.ud(HttpHeaders.CONTENT_ENCODING, "union_sdk_encode");
                    mmlVarUd.ud("x-pgli18n", "4");
                    mmlVarUd.qdl("application/octet-stream;tt-data=a", bArr);
                }
            }
            if (bArr == null) {
                JSONObject jSONObjectQdl = com.bytedance.sdk.component.utils.qdl.qdl(jSONObject);
                if (lnr(jSONObjectQdl)) {
                    jSONObject = jSONObjectQdl;
                }
                qdl(mml(jSONObject), mmlVarUd);
                mmlVarUd.qdl(jSONObject.toString(), yt.mml().jl());
            }
            mmlVarUd.qdl(7);
            mmlVarUd.qdl("et_applog");
            mmlVarUd.qdl(new com.bytedance.sdk.component.wd.qdl.qdl() { // from class: com.bytedance.sdk.openadsdk.core.ljh.15
                @Override // com.bytedance.sdk.component.wd.qdl.qdl
                public void qdl(com.bytedance.sdk.component.wd.ud.lnr lnrVar, com.bytedance.sdk.component.wd.ud udVar) {
                    if (udVar == null || !udVar.mo()) {
                        return;
                    }
                    udVar.mml();
                }

                @Override // com.bytedance.sdk.component.wd.qdl.qdl
                public void qdl(com.bytedance.sdk.component.wd.ud.lnr lnrVar, IOException iOException) {
                    iOException.getMessage();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.oth
    public void qdl(String str, List<FilterWord> list, JSONObject jSONObject, String str2, String str3) {
        JSONObject jSONObjectUd;
        if (com.bytedance.sdk.openadsdk.core.settings.wd.qdl() && (jSONObjectUd = ud(str, list, jSONObject, str2, str3)) != null) {
            com.bytedance.sdk.component.wd.ud.mml mmlVarUd = com.bytedance.sdk.openadsdk.jl.ud.ud().lnr().ud();
            final String strMml = com.bytedance.sdk.openadsdk.utils.gy.mml("/api/ad/union/dislike_event/");
            JSONObject jSONObjectQdl = qdl(PangleEncryptConstant.CryptDataScene.DISLIKE, jSONObjectUd);
            String string = jSONObjectQdl != null ? jSONObjectQdl.toString() : null;
            qdl(mmlVarUd, jSONObjectQdl);
            mmlVarUd.ud(strMml);
            mmlVarUd.mml(string);
            mmlVarUd.qdl(7);
            mmlVarUd.qdl("dislike");
            com.bytedance.sdk.openadsdk.yt.lnr.qdl(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.ljh.2
                @Override // com.bytedance.sdk.openadsdk.yt.mml
                public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                    com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                    qdlVar.ud("dislike");
                    return qdlVar;
                }
            });
            mmlVarUd.qdl(new com.bytedance.sdk.component.wd.qdl.qdl() { // from class: com.bytedance.sdk.openadsdk.core.ljh.3
                @Override // com.bytedance.sdk.component.wd.qdl.qdl
                public void qdl(com.bytedance.sdk.component.wd.ud.lnr lnrVar, com.bytedance.sdk.component.wd.ud udVar) {
                    if (udVar == null) {
                        com.bytedance.sdk.openadsdk.bjy.qdl.mzz.qdl("dislike", strMml, -1, "response is null");
                        com.bytedance.sdk.openadsdk.yt.lnr.lnr(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.ljh.3.3
                            @Override // com.bytedance.sdk.openadsdk.yt.mml
                            public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                                com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                                qdlVar.ud("dislike");
                                return qdlVar;
                            }
                        });
                    } else if (udVar.mo()) {
                        com.bytedance.sdk.openadsdk.yt.lnr.ud(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.ljh.3.1
                            @Override // com.bytedance.sdk.openadsdk.yt.mml
                            public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                                com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                                qdlVar.ud("dislike");
                                return qdlVar;
                            }
                        });
                    } else {
                        com.bytedance.sdk.openadsdk.yt.lnr.lnr(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.ljh.3.2
                            @Override // com.bytedance.sdk.openadsdk.yt.mml
                            public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                                com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                                qdlVar.ud("dislike");
                                return qdlVar;
                            }
                        });
                        com.bytedance.sdk.openadsdk.bjy.qdl.mzz.qdl("dislike", strMml, udVar.qdl(), udVar.ud());
                    }
                }

                @Override // com.bytedance.sdk.component.wd.qdl.qdl
                public void qdl(com.bytedance.sdk.component.wd.ud.lnr lnrVar, IOException iOException) {
                    com.bytedance.sdk.openadsdk.bjy.qdl.mzz.qdl("dislike", strMml, -1, iOException != null ? iOException.getMessage() : AbstractJsonLexerKt.NULL);
                    if (lnrVar != null) {
                        com.bytedance.sdk.openadsdk.utils.jyq.qdl(lnrVar.mml());
                    }
                    com.bytedance.sdk.openadsdk.yt.lnr.lnr(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.ljh.3.4
                        @Override // com.bytedance.sdk.openadsdk.yt.mml
                        public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                            com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                            qdlVar.ud("dislike");
                            return qdlVar;
                        }
                    });
                }
            });
            try {
                String strOptString = new JSONObject(str).optString("cid", "");
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.mo.ud.qdl().qdl("dislike", strOptString, (String) null, (String) null);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.aaj.lnr(e.getMessage(), new Object[0]);
            }
        }
    }

    private static JSONObject qdl(PangleEncryptConstant.CryptDataScene cryptDataScene, JSONObject jSONObject) {
        if (com.bytedance.sdk.openadsdk.core.settings.rq.lnr().qdl(cryptDataScene)) {
            JSONObject jSONObjectEncryptType4 = PangleEncryptManager.encryptType4(jSONObject, new bch(cryptDataScene));
            uw.qdl(jSONObjectEncryptType4);
            return jSONObjectEncryptType4;
        }
        return com.bytedance.sdk.component.utils.qdl.qdl(jSONObject);
    }

    @DungeonFlag
    private JSONObject ud(String str, List<FilterWord> list, JSONObject jSONObject, String str2, String str3) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("timestamp", System.currentTimeMillis());
            jSONObject3.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            JSONObject jSONObject4 = new JSONObject(str);
            jSONObject4.put("gaid", com.bytedance.sdk.openadsdk.exc.qdl.ud.qdl.qdl().ud());
            jSONObject3.put("extra", jSONObject4.toString());
            jSONObject3.put("filter_words", qdl(list));
            jSONObject3.put("dislike_source", str3);
            if (com.bytedance.sdk.openadsdk.core.settings.rq.lnr().sy() && jSONObject != null && !TextUtils.isEmpty(str2)) {
                jSONObject3.put("creative_info", com.bytedance.sdk.component.utils.qdl.qdl(jSONObject).toString());
                jSONObject3.put("feedback_type", 1);
                jSONObject3.put("user_description", str2);
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject3);
            jSONObject2.put("actions", jSONArray);
        } catch (Exception unused) {
        }
        return jSONObject2;
    }

    private JSONArray qdl(List<FilterWord> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<FilterWord> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().getId());
        }
        return jSONArray;
    }

    private Map<String, String> mml(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/json; charset=utf-8");
        if (lnr(jSONObject)) {
            map.put(HttpHeaders.CONTENT_ENCODING, "union_sdk_encode");
        }
        return map;
    }

    private boolean mzz(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.optString("message").equalsIgnoreCase("success");
        } catch (Throwable unused) {
            return false;
        }
    }

    private void qdl(oth.qdl qdlVar, com.bytedance.sdk.openadsdk.core.model.lnr lnrVar) {
        qdlVar.qdl(-1, jpc.qdl(-1));
        lnrVar.qdl(-1);
        com.bytedance.sdk.openadsdk.core.model.lnr.qdl(lnrVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(oth.ud udVar) {
        udVar.qdl(-1, jpc.qdl(-1));
    }

    @DungeonFlag
    private JSONObject ud() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PangleConstants.APP_ID, tvp.ud().mml());
            jSONObject.put("name", tvp.ud().jpc());
            mo(jSONObject);
            Context contextQdl = yt.qdl();
            String packageResourcePath = "";
            if (contextQdl != null) {
                try {
                    packageResourcePath = contextQdl.getPackageResourcePath();
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.aaj.lnr("NetApiImpl", "failed to get the application installation package path. error: " + th.getMessage());
                }
            }
            jSONObject.put("package_install_path", packageResourcePath);
            int i = 0;
            jSONObject.put("is_paid_app", false);
            jSONObject.put("apk_sign", com.bytedance.sdk.openadsdk.common.ud.wd());
            jSONObject.put("app_running_time", (System.currentTimeMillis() - rdp.qdl()) / 1000);
            jSONObject.put("fmwname", DeviceUtils.to());
            jSONObject.put("is_init", rdp.mzz() ? 1 : 0);
            if (contextQdl != null) {
                int rotation = ((WindowManager) contextQdl.getSystemService("window")).getDefaultDisplay().getRotation();
                if (rotation == 0) {
                    i = 1;
                } else if (rotation == 1) {
                    i = 3;
                } else if (rotation == 2) {
                    i = 2;
                } else if (rotation == 3) {
                    i = 4;
                }
                jSONObject.put("orientation_support", new JSONArray().put(i));
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static JSONObject qdl(AdSlot adSlot) {
        bqt bqtVar;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("personalized_ad", yt.mml().zlt());
            jSONObject.put("lmt", DeviceUtils.lnr());
            jSONObject.put("gdpr", tvp.ud().to());
            jSONObject.put("pa_consent", tvp.ud().rq());
            jSONObject.put("is_gdpr_user", yt.mml().irn());
            if (adSlot != null && bqt.qdl.containsKey(Integer.valueOf(adSlot.getCodeId())) && (bqtVar = bqt.qdl.get(Integer.valueOf(adSlot.getCodeId()))) != null) {
                jSONObject.put("lastadomain", bqtVar.ud());
                jSONObject.put("lastbundle", bqtVar.lnr());
                jSONObject.put("lastclick", bqtVar.mml());
                jSONObject.put("lastskip", bqtVar.mzz());
            }
            qdl(jSONObject, "data", ud(adSlot));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static String ud(AdSlot adSlot) {
        String strExu = tvp.ud().exu();
        if (adSlot == null) {
            return TextUtils.isEmpty(strExu) ? "" : strExu;
        }
        String userData = adSlot.getUserData();
        if (TextUtils.isEmpty(strExu)) {
            return userData;
        }
        if (TextUtils.isEmpty(userData)) {
            return strExu;
        }
        HashSet hashSet = new HashSet();
        try {
            JSONArray jSONArray = new JSONArray(userData);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    hashSet.add(jSONObject.optString("name", null));
                }
            }
            try {
                JSONArray jSONArray2 = new JSONArray(strExu);
                int length2 = jSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                    if (jSONObject2 != null && !hashSet.contains(jSONObject2.optString("name", null))) {
                        jSONArray.put(jSONObject2);
                    }
                }
                return jSONArray.toString();
            } catch (Throwable unused) {
                return userData;
            }
        } catch (Throwable unused2) {
            return strExu;
        }
    }

    private static void qdl(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    @DungeonFlag
    private void mo(JSONObject jSONObject) {
        try {
            jSONObject.put("package_name", com.bytedance.sdk.openadsdk.utils.gy.mo());
            jSONObject.put("version_code", com.bytedance.sdk.openadsdk.utils.gy.wd());
            jSONObject.put("version", com.bytedance.sdk.openadsdk.utils.gy.jpc());
        } catch (Exception unused) {
        }
    }

    private JSONObject qdl(AdSlot adSlot, int i, com.bytedance.sdk.openadsdk.core.model.bqt bqtVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", adSlot.getCodeId());
            jSONObject.put("adtype", i);
            if (!TextUtils.isEmpty(adSlot.getAdId()) || !TextUtils.isEmpty(adSlot.getCreativeId()) || !TextUtils.isEmpty(adSlot.getExt())) {
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(adSlot.getAdId())) {
                    jSONObject2.put("ad_id", adSlot.getAdId());
                }
                if (!TextUtils.isEmpty(adSlot.getCreativeId())) {
                    jSONObject2.put("creative_id", adSlot.getCreativeId());
                }
                if (adSlot.getExt() != null) {
                    jSONObject2.put("ext", adSlot.getExt());
                }
                jSONObject.put("preview_ads", jSONObject2);
            }
            if (bqtVar != null) {
                jSONObject.put("render_method", bqtVar.tvp);
                if (bqtVar.tvp == 1) {
                    qdl(jSONObject, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
                } else if (bqtVar.tvp == 2) {
                    qdl(jSONObject, "accepted_size", adSlot.getExpressViewAcceptedWidth(), adSlot.getExpressViewAcceptedHeight());
                }
            } else {
                jSONObject.put("render_method", 1);
                qdl(jSONObject, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
            }
            jSONObject.put("ptpl_ids", ud(adSlot.getCodeId()));
            jSONObject.put("ugen_ptpl_ids", lnr(adSlot.getCodeId()));
            jSONObject.put("ptpl_ids_v3", lnr(adSlot.getCodeId() + "_v3"));
            jSONObject.put("pos", AdSlot.getPosition(i));
            jSONObject.put("is_support_dpl", adSlot.isSupportDeepLink());
            if (i == 1 || i == 5) {
                jSONObject.put("is_origin_ad", true);
            }
            if (bqtVar != null && bqtVar.wd != null) {
                jSONObject.put("session_params", bqtVar.wd);
            }
            if (bqtVar != null && bqtVar.jpc != null) {
                jSONObject.put("common_params", bqtVar.jpc);
            }
            int adCount = adSlot.getAdCount();
            if (adCount <= 0) {
                adCount = 1;
            }
            if (adCount > 3) {
                adCount = 3;
            }
            if (i == 7 || i == 8) {
                adCount = 1;
            }
            if (bqtVar != null && bqtVar.mzz != null) {
                adCount = adSlot.getAdCount();
            }
            jSONObject.put("ad_count", adCount);
            if (i == 1) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("is_rotate_banner", adSlot.getIsRotateBanner());
                jSONObject3.put("rotate_time", adSlot.getRotateTime());
                jSONObject3.put("rotate_order", adSlot.getRotateOrder());
                jSONObject3.put("type", adSlot.getBannerType());
                jSONObject.put(ReportUtil.INVENTORY_TYPE_BANNER, jSONObject3);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void qdl(JSONObject jSONObject, String str, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i);
            jSONObject2.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, i2);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private void qdl(JSONObject jSONObject, String str, float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, (int) f);
            jSONObject2.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, (int) f2);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    public static class qdl {
        public final com.bytedance.sdk.openadsdk.core.model.qdl jpc;
        final long lnr;
        final int mml;
        final int mo;
        final String mzz;
        final int qdl;
        final ArrayList<Integer> to;
        final String tvp;
        final long ud;
        final String wd;

        private qdl(String str, int i, int i2, String str2, int i3, String str3, com.bytedance.sdk.openadsdk.core.model.qdl qdlVar, long j, long j2, ArrayList<Integer> arrayList) {
            this.qdl = i;
            this.mml = i2;
            this.mzz = str2;
            this.wd = str3;
            this.jpc = qdlVar;
            this.tvp = str;
            this.mo = i3;
            this.ud = j;
            this.lnr = j2;
            this.to = arrayList;
        }

        public static qdl qdl(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.bqt bqtVar) {
            String strOptString = jSONObject.optString("did");
            int iOptInt = jSONObject.optInt("processing_time_ms");
            long jOptLong = jSONObject.optLong("s_receive_ts");
            long jOptLong2 = jSONObject.optLong("s_send_ts");
            int iOptInt2 = jSONObject.optInt("status_code");
            String strOptString2 = jSONObject.optString("desc");
            String strOptString3 = jSONObject.optString("request_id");
            int iOptInt3 = jSONObject.optInt("reason");
            Pair<com.bytedance.sdk.openadsdk.core.model.qdl, ArrayList<Integer>> pairQdl = com.bytedance.sdk.openadsdk.core.ud.qdl(jSONObject, adSlot, bqtVar);
            if (pairQdl == null) {
                return new qdl(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, null, jOptLong, jOptLong2, null);
            }
            return new qdl(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, (com.bytedance.sdk.openadsdk.core.model.qdl) pairQdl.first, jOptLong, jOptLong2, (ArrayList) pairQdl.second);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.oth
    public void qdl(JSONObject jSONObject, final oth.ud udVar) {
        if (!com.bytedance.sdk.openadsdk.core.settings.wd.qdl()) {
            if (udVar != null) {
                udVar.qdl(1000, "Ad request is temporarily paused, Please contact your AM");
            }
        } else {
            if (jSONObject == null || udVar == null) {
                return;
            }
            JSONObject jSONObjectQdl = qdl(PangleEncryptConstant.CryptDataScene.REWARD_VERIFY, jSONObject);
            com.bytedance.sdk.component.wd.ud.mml mmlVarUd = com.bytedance.sdk.openadsdk.jl.ud.ud().lnr().ud();
            try {
                mmlVarUd.ud(com.bytedance.sdk.openadsdk.jpc.mml.qdl(mmlVarUd, com.bytedance.sdk.openadsdk.utils.gy.mml("/api/ad/union/sdk/reward_video/reward/")));
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.aaj.lnr("NetApiImpl", e.getMessage());
            }
            qdl(mmlVarUd, jSONObjectQdl);
            mmlVarUd.mml(jSONObjectQdl != null ? jSONObjectQdl.toString() : "");
            mmlVarUd.qdl(10);
            mmlVarUd.qdl(ReportUtil.EVENT_TYPE_REWARD);
            com.bytedance.sdk.openadsdk.yt.lnr.qdl(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.ljh.4
                @Override // com.bytedance.sdk.openadsdk.yt.mml
                public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                    com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                    qdlVar.ud(ReportUtil.EVENT_TYPE_REWARD);
                    return qdlVar;
                }
            });
            mmlVarUd.qdl(new com.bytedance.sdk.component.wd.qdl.qdl() { // from class: com.bytedance.sdk.openadsdk.core.ljh.5
                @Override // com.bytedance.sdk.component.wd.qdl.qdl
                public void qdl(com.bytedance.sdk.component.wd.ud.lnr lnrVar, com.bytedance.sdk.component.wd.ud udVar2) {
                    ud udVarQdl;
                    if (udVar2 != null) {
                        if (udVar2.mo() && !TextUtils.isEmpty(udVar2.mml())) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(udVar2.mml());
                                String strUd = ljh.ud(jSONObject2.optInt("cypher", -1), jSONObject2.optString("message"));
                                if (!TextUtils.isEmpty(strUd)) {
                                    try {
                                        jSONObject2 = new JSONObject(strUd);
                                    } catch (Throwable unused) {
                                    }
                                }
                                udVarQdl = ud.qdl(jSONObject2);
                            } catch (JSONException e2) {
                                com.bytedance.sdk.component.utils.aaj.lnr("NetApiImpl", e2.getMessage());
                                ljh.this.qdl(udVar);
                            }
                            if (udVarQdl.qdl != 20000) {
                                udVar.qdl(udVarQdl.qdl, jpc.qdl(udVarQdl.qdl));
                                return;
                            } else if (udVarQdl.lnr == null) {
                                ljh.this.qdl(udVar);
                                return;
                            } else {
                                udVar.qdl(udVarQdl);
                                com.bytedance.sdk.openadsdk.yt.lnr.ud(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.ljh.5.1
                                    @Override // com.bytedance.sdk.openadsdk.yt.mml
                                    public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                                        com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                                        qdlVar.ud(ReportUtil.EVENT_TYPE_REWARD);
                                        return qdlVar;
                                    }
                                });
                                return;
                            }
                        }
                        String strQdl = jpc.qdl(-2);
                        int iQdl = udVar2.qdl();
                        if (!udVar2.mo() && !TextUtils.isEmpty(udVar2.ud())) {
                            strQdl = udVar2.ud();
                        }
                        udVar.qdl(iQdl, strQdl);
                        com.bytedance.sdk.openadsdk.yt.lnr.lnr(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.ljh.5.2
                            @Override // com.bytedance.sdk.openadsdk.yt.mml
                            public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                                com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                                qdlVar.ud(ReportUtil.EVENT_TYPE_REWARD);
                                return qdlVar;
                            }
                        });
                        if (udVar2.mo()) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.bjy.qdl.mzz.qdl(ReportUtil.EVENT_TYPE_REWARD, lnrVar.mml(), iQdl, strQdl);
                        return;
                    }
                    com.bytedance.sdk.openadsdk.yt.lnr.lnr(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.ljh.5.3
                        @Override // com.bytedance.sdk.openadsdk.yt.mml
                        public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                            com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                            qdlVar.ud(ReportUtil.EVENT_TYPE_REWARD);
                            return qdlVar;
                        }
                    });
                    com.bytedance.sdk.openadsdk.bjy.qdl.mzz.qdl(ReportUtil.EVENT_TYPE_REWARD, lnrVar.mml(), -1, "response is null");
                    ljh.this.qdl(udVar);
                }

                @Override // com.bytedance.sdk.component.wd.qdl.qdl
                public void qdl(com.bytedance.sdk.component.wd.ud.lnr lnrVar, IOException iOException) {
                    String message;
                    if (iOException == null) {
                        message = "";
                    } else {
                        message = iOException.getMessage();
                    }
                    udVar.qdl(-2, message);
                    if (lnrVar != null) {
                        String strMml = lnrVar.mml();
                        com.bytedance.sdk.openadsdk.utils.jyq.qdl(strMml);
                        com.bytedance.sdk.openadsdk.bjy.qdl.mzz.qdl(ReportUtil.EVENT_TYPE_REWARD, strMml, -1, message);
                    }
                    com.bytedance.sdk.openadsdk.yt.lnr.lnr(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.ljh.5.4
                        @Override // com.bytedance.sdk.openadsdk.yt.mml
                        public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                            com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                            qdlVar.ud(ReportUtil.EVENT_TYPE_REWARD);
                            return qdlVar;
                        }
                    });
                }
            });
        }
    }

    public static class ud {
        public final com.bytedance.sdk.openadsdk.core.model.hkc lnr;
        public final int qdl;
        public final boolean ud;

        private ud(int i, boolean z, com.bytedance.sdk.openadsdk.core.model.hkc hkcVar) {
            this.qdl = i;
            this.ud = z;
            this.lnr = hkcVar;
        }

        public static ud qdl(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int iOptInt = jSONObject.optInt("code");
            boolean zOptBoolean = jSONObject.optBoolean("verify");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            com.bytedance.sdk.openadsdk.core.model.hkc hkcVar = new com.bytedance.sdk.openadsdk.core.model.hkc();
            if (jSONObjectOptJSONObject != null) {
                try {
                    hkcVar.qdl(jSONObjectOptJSONObject.optInt("reason"));
                    hkcVar.ud(jSONObjectOptJSONObject.optInt("corp_type"));
                    hkcVar.lnr(jSONObjectOptJSONObject.optInt("reward_amount"));
                    hkcVar.qdl(jSONObjectOptJSONObject.optString("reward_name"));
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.aaj.lnr("NetApiImpl", th.getMessage());
                }
            }
            return new ud(iOptInt, zOptBoolean, hkcVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.oth
    public JSONObject qdl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return jSONObject;
        }
        try {
            int iOptInt = jSONObject.optInt("cypher", -1);
            String strOptString = jSONObject.optString("message");
            String strOptString2 = jSONObject.optString("auction_price", "");
            String strUd = ud(iOptInt, strOptString);
            if (TextUtils.isEmpty(strUd)) {
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject(strUd);
            try {
                jSONObject2.put("auction_price", strOptString2);
            } catch (Throwable unused) {
            }
            return jSONObject2;
        } catch (Throwable unused2) {
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String ud(int i, String str) {
        if (i == 3) {
            return com.bytedance.sdk.component.utils.qdl.lnr(str);
        }
        if (i == 4) {
            Pair<Integer, String> pairDecryptType4 = PangleEncryptManager.decryptType4(str);
            if (pairDecryptType4 != null && pairDecryptType4.second != null) {
                String str2 = (String) pairDecryptType4.second;
                uw.qdl(true);
                return str2;
            }
            uw.qdl(false);
            uw.qdl(2, PangleEncryptConstant.CryptDataScene.GET_ADS, pairDecryptType4 != null ? ((Integer) pairDecryptType4.first).intValue() : 0);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.oth
    public com.bytedance.sdk.openadsdk.mml.mzz ud(JSONObject jSONObject) {
        int i;
        boolean z;
        boolean z2;
        String strUd = "error unknown";
        System.currentTimeMillis();
        if (!com.bytedance.sdk.openadsdk.core.settings.wd.qdl() || !yt.mml().mlb() || jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        com.bytedance.sdk.component.wd.ud.mml mmlVarUd = com.bytedance.sdk.openadsdk.jl.ud.ud().lnr().ud();
        boolean z3 = false;
        int iQdl = 0;
        try {
            JSONObject jSONObjectQdl = qdl(PangleEncryptConstant.CryptDataScene.STATS_LOG, jSONObject);
            mmlVarUd.qdl(jSONObjectQdl.toString(), yt.mml().jl());
            mmlVarUd.ud(com.bytedance.sdk.openadsdk.utils.gy.mml("/api/ad/union/sdk/stats/batch/"));
            qdl(mmlVarUd, jSONObjectQdl);
            mmlVarUd.ud(HttpHeaders.USER_AGENT, com.bytedance.sdk.openadsdk.utils.gy.mml());
            if (com.bytedance.sdk.openadsdk.core.settings.rq.lnr().jnw()) {
                mmlVarUd.ud("_disable_retry", "1");
            }
            com.bytedance.sdk.component.wd.ud udVarQdl = mmlVarUd.qdl();
            try {
            } catch (Throwable unused) {
                i = 0;
                z = false;
            }
            if (udVarQdl == null) {
                return new com.bytedance.sdk.openadsdk.mml.mzz(false, 0, "error unknown", false);
            }
            if (!udVarQdl.mo() || TextUtils.isEmpty(udVarQdl.mml())) {
                z2 = false;
                z = false;
            } else {
                JSONObject jSONObject2 = new JSONObject(udVarQdl.mml());
                int iOptInt = jSONObject2.optInt("code", -1);
                strUd = jSONObject2.optString("data", "");
                z = true;
                z2 = iOptInt == 20000;
                if (iOptInt != 60005) {
                    z = false;
                }
            }
            try {
                iQdl = udVarQdl.qdl();
                if (!udVarQdl.mo()) {
                    strUd = udVarQdl.ud();
                    com.bytedance.sdk.openadsdk.utils.jyq.qdl(mmlVarUd.mml());
                }
            } catch (Throwable unused2) {
                i = iQdl;
                z3 = z2;
                z2 = z3;
                iQdl = i;
            }
            return new com.bytedance.sdk.openadsdk.mml.mzz(z2, iQdl, strUd, z);
        } catch (Throwable unused3) {
            return new com.bytedance.sdk.openadsdk.mml.mzz(false, 0, "error unknown", false);
        }
    }

    private void qdl(com.bytedance.sdk.component.wd.ud.mml mmlVar, JSONObject jSONObject) {
        try {
            if (lnr(jSONObject) && jSONObject.optInt("cypher") == 4) {
                mmlVar.ud("x-pgli18n", "4");
                mmlVar.ud("Content-Type", "application/json; charset=utf-8");
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.oth
    public com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdl() {
        com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVarQdl = null;
        if (!com.bytedance.sdk.openadsdk.core.settings.wd.qdl()) {
            return null;
        }
        long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) - com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("tpl_fetch_model", "date", 0L);
        String strWak = yt.mml().wak();
        String strUd = com.bytedance.sdk.openadsdk.multipro.mml.mml.ud("tpl_fetch_model", "last_url", "");
        if (jCurrentTimeMillis <= yt.mml().mrf() && jCurrentTimeMillis >= 0 && TextUtils.equals(strWak, strUd)) {
            String strUd2 = com.bytedance.sdk.openadsdk.multipro.mml.mml.ud("tpl_fetch_model", DeviceRequestsHelper.DEVICE_INFO_MODEL, "");
            try {
                if (!TextUtils.isEmpty(strUd2)) {
                    return com.bytedance.sdk.component.adexpress.qdl.lnr.qdl.mzz(strUd2);
                }
            } catch (Exception unused) {
            }
        }
        try {
            com.bytedance.sdk.component.wd.ud.ud udVarLnr = com.bytedance.sdk.openadsdk.jl.ud.ud().lnr().lnr();
            String strQdl = com.bytedance.sdk.openadsdk.jpc.mml.qdl(udVarLnr, strWak);
            udVarLnr.ud(strQdl);
            com.bytedance.sdk.component.wd.ud udVarQdl = udVarLnr.qdl();
            if (udVarQdl == null || !udVarQdl.mo()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(udVarQdl.mml());
            jSONObject.put("template_fetch_url", strQdl);
            qdlVarQdl = com.bytedance.sdk.component.adexpress.qdl.lnr.qdl.qdl(jSONObject);
            com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("tpl_fetch_model", "date", Long.valueOf(System.currentTimeMillis() / 1000));
            com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("tpl_fetch_model", DeviceRequestsHelper.DEVICE_INFO_MODEL, jSONObject.toString());
            com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("tpl_fetch_model", "last_url", strWak);
            return qdlVarQdl;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.lnr("NetApiImpl", th.getMessage());
            return qdlVarQdl;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.oth
    public void qdl(String str) {
        com.bytedance.sdk.component.wd.ud.ud udVarLnr = com.bytedance.sdk.openadsdk.jl.ud.ud().lnr().lnr();
        udVarLnr.ud(str);
        udVarLnr.qdl("upload_bidding");
        udVarLnr.qdl(7);
        udVarLnr.qdl(new com.bytedance.sdk.component.wd.qdl.qdl() { // from class: com.bytedance.sdk.openadsdk.core.ljh.6
            @Override // com.bytedance.sdk.component.wd.qdl.qdl
            public void qdl(com.bytedance.sdk.component.wd.ud.lnr lnrVar, IOException iOException) {
            }

            @Override // com.bytedance.sdk.component.wd.qdl.qdl
            public void qdl(com.bytedance.sdk.component.wd.ud.lnr lnrVar, com.bytedance.sdk.component.wd.ud udVar) {
                udVar.mml();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.oth
    public void qdl(JSONObject jSONObject, String str) {
        com.bytedance.sdk.component.wd.ud.mml mmlVarUd = com.bytedance.sdk.openadsdk.jl.ud.ud().lnr().ud();
        mmlVarUd.ud(str);
        Pair<String, String> pairGenerateRequestHeader = ApmHelper.generateRequestHeader();
        mmlVarUd.ud("cypher", (String) pairGenerateRequestHeader.first);
        mmlVarUd.ud("transfer-param", (String) pairGenerateRequestHeader.second);
        mmlVarUd.ud("x-pangle-target-idc", yt.mml().ca());
        mmlVarUd.qdl(jSONObject);
        mmlVarUd.qdl(5);
        mmlVarUd.qdl("apm_pv");
        mmlVarUd.qdl(new com.bytedance.sdk.component.wd.qdl.qdl() { // from class: com.bytedance.sdk.openadsdk.core.ljh.7
            @Override // com.bytedance.sdk.component.wd.qdl.qdl
            public void qdl(com.bytedance.sdk.component.wd.ud.lnr lnrVar, IOException iOException) {
            }

            @Override // com.bytedance.sdk.component.wd.qdl.qdl
            public void qdl(com.bytedance.sdk.component.wd.ud.lnr lnrVar, com.bytedance.sdk.component.wd.ud udVar) {
                udVar.mml();
            }
        });
    }

    public static JSONArray ud(String str) {
        try {
            Set<String> setUd = com.bytedance.sdk.component.adexpress.qdl.ud.ud.ud(str);
            if (setUd != null && setUd.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = setUd.iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.adexpress.qdl.lnr.ud udVarQdl = com.bytedance.sdk.component.adexpress.qdl.ud.ud.qdl(it.next());
                    if (udVarQdl != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", udVarQdl.ud());
                        jSONObject.put("md5", udVarQdl.lnr());
                        jSONArray.put(jSONObject);
                    }
                }
                return jSONArray;
            }
            return null;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.aaj.qdl("NetApiImpl", "getParentTplIds: ", e);
            return null;
        }
    }

    public static JSONArray lnr(String str) {
        try {
            Set<com.bytedance.sdk.openadsdk.core.rq.qdl.qdl> setQdl = com.bytedance.sdk.openadsdk.core.rq.qdl.ud.qdl().qdl(str);
            if (setQdl != null && setQdl.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.bytedance.sdk.openadsdk.core.rq.qdl.qdl qdlVar : setQdl) {
                    if (qdlVar != null && !TextUtils.isEmpty(qdlVar.mzz())) {
                        JSONObject jSONObject = new JSONObject();
                        String[] strArrSplit = qdlVar.qdl().split("_");
                        if (strArrSplit.length == 2) {
                            jSONObject.put("id", strArrSplit[1]);
                            jSONObject.put("md5", qdlVar.ud());
                            jSONArray.put(jSONObject);
                        }
                    }
                }
                return jSONArray;
            }
            return null;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.aaj.qdl("NetApiImpl", "getUgenParentTplIds: ", e);
            return null;
        }
    }

    private byte[] mzz(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        byte[] byteArray = new byte[0];
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                        try {
                            gZIPOutputStream2.write(str.getBytes("utf-8"));
                            try {
                                gZIPOutputStream2.close();
                            } catch (IOException e) {
                                com.bytedance.sdk.component.utils.aaj.lnr("NetApiImpl", e.toString());
                            }
                            byteArray = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            gZIPOutputStream = gZIPOutputStream2;
                            com.bytedance.sdk.component.utils.aaj.lnr("NetApiImpl", e.toString());
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (IOException e3) {
                                    com.bytedance.sdk.component.utils.aaj.lnr("NetApiImpl", e3.toString());
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                byteArray = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                            }
                            return byteArray;
                        } catch (Throwable th) {
                            th = th;
                            gZIPOutputStream = gZIPOutputStream2;
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (IOException e4) {
                                    com.bytedance.sdk.component.utils.aaj.lnr("NetApiImpl", e4.toString());
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.toByteArray();
                                try {
                                    byteArrayOutputStream.close();
                                    throw th;
                                } catch (IOException e5) {
                                    com.bytedance.sdk.component.utils.aaj.lnr("NetApiImpl", e5.toString());
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e6) {
                    e = e6;
                }
            } catch (IOException e7) {
                e = e7;
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (IOException e8) {
            com.bytedance.sdk.component.utils.aaj.lnr("NetApiImpl", e8.toString());
        }
        return byteArray;
    }
}
