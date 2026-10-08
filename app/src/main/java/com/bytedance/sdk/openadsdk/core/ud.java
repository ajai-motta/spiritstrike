package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.fs.qdl.ud;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.facebook.internal.NativeProtocol;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.ContentDisposition;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ud {
    private static boolean qdl(int i) {
        return i == 2 || i == 3 || i == 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public static Pair<com.bytedance.sdk.openadsdk.core.model.qdl, ArrayList<Integer>> qdl(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.bqt bqtVar) {
        com.bytedance.sdk.openadsdk.core.model.ljh ljhVar = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            com.bytedance.sdk.openadsdk.core.model.qdl qdlVar = new com.bytedance.sdk.openadsdk.core.model.qdl();
            qdlVar.qdl(jSONObject.optString("request_id"));
            qdlVar.qdl(jSONObject.optInt("ret"));
            qdlVar.ud(jSONObject.optInt("multi_ad_style", 0));
            qdlVar.ud(jSONObject.optString("message"));
            String strOptString = jSONObject.optString("gdid_encrypted");
            qdlVar.qdl(com.bytedance.sdk.openadsdk.core.model.oth.qdl(jSONObject.optJSONObject("loop_config")));
            String strOptString2 = jSONObject.optString("auction_price");
            if (qdlVar.lnr() != 0) {
                return null;
            }
            qdlVar.qdl(com.bytedance.sdk.openadsdk.core.model.uw.qdl(jSONObject.optString("multi_ad_config")));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                jSONArrayOptJSONArray.length();
                int i = 0;
                ?? arrayList2 = qdlVar.to() ? new ArrayList() : null;
                while (i < jSONArrayOptJSONArray.length()) {
                    com.bytedance.sdk.openadsdk.core.model.ljh ljhVarQdl = qdl(jSONArrayOptJSONArray.optJSONObject(i), adSlot, bqtVar, qdlVar, i);
                    ?? r9 = arrayList2;
                    if (!qdlVar.to()) {
                        r9 = ljhVar;
                    }
                    int iQdl = qdl(ljhVarQdl);
                    if (iQdl != 200) {
                        if (ljhVarQdl != null) {
                            com.bytedance.sdk.openadsdk.mml.lnr.ud(ljhVarQdl, com.bytedance.sdk.openadsdk.utils.gy.lnr(ljhVarQdl.ok()), iQdl);
                        } else {
                            com.bytedance.sdk.openadsdk.mml.lnr.ud(ljhVar, "", iQdl);
                        }
                        arrayList.add(Integer.valueOf(iQdl));
                        if (r9 != 0 && ljhVarQdl != null) {
                            r9.add(new qdl(ljhVarQdl.wc(), iQdl));
                        }
                        if (ljhVarQdl != null && (ljhVarQdl.taz() == 39 || ljhVarQdl.taz() == 41)) {
                            qdlVar.ud(0);
                        }
                        jSONArrayOptJSONArray.remove(i);
                        i--;
                    } else {
                        ljhVarQdl.rdp(strOptString2);
                        if (!TextUtils.isEmpty(strOptString)) {
                            ljhVarQdl.tvp(strOptString);
                        }
                        qdlVar.qdl(ljhVarQdl);
                    }
                    i++;
                    ljhVar = null;
                    arrayList2 = r9;
                }
                List<com.bytedance.sdk.openadsdk.core.model.ljh> listMml = qdlVar.mml();
                qdl(listMml, qdlVar);
                if (listMml != null) {
                    if (qdlVar.to() && listMml.size() == 1) {
                        qdlVar.ud(0);
                        com.bytedance.sdk.openadsdk.core.model.ljh ljhVar2 = listMml.get(0);
                        if (ljhVar2 != null) {
                            ljhVar2.jpc(false);
                        }
                    }
                    int size = listMml.size();
                    jSONObject.put("creatives", jSONArrayOptJSONArray);
                    for (int i2 = 0; i2 < size; i2++) {
                        com.bytedance.sdk.openadsdk.core.model.ljh ljhVar3 = listMml.get(i2);
                        if (ljhVar3 != null) {
                            if (i2 > 0) {
                                ljhVar3.wxg();
                            }
                            ljhVar3.hkc(jSONObject.toString());
                        }
                    }
                }
                if (arrayList2 != 0 && !arrayList2.isEmpty()) {
                    qdl((ArrayList<qdl>) arrayList2);
                }
            }
            return new Pair<>(qdlVar, arrayList);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.lnr("TTAD.AdInfoFactory", th.getMessage());
            return null;
        }
    }

    private static void qdl(List<com.bytedance.sdk.openadsdk.core.model.ljh> list, com.bytedance.sdk.openadsdk.core.model.qdl qdlVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.model.ljh ljhVar = list.get(0);
        if (!qdlVar.to() || ljhVar == null || !ljhVar.qur() || com.bytedance.sdk.openadsdk.utils.gy.rc() == 0) {
            return;
        }
        qdlVar.ud(0);
        ljhVar.jpc(false);
    }

    public static com.bytedance.sdk.openadsdk.core.model.ljh qdl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return qdl(jSONObject, null, null, null, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:173:0x06ab A[PHI: r0
  0x06ab: PHI (r0v86 int) = (r0v85 int), (r0v136 int) binds: [B:166:0x0697, B:171:0x06a8] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.sdk.openadsdk.core.model.ljh qdl(org.json.JSONObject r16, com.bytedance.sdk.openadsdk.AdSlot r17, com.bytedance.sdk.openadsdk.core.model.bqt r18, com.bytedance.sdk.openadsdk.core.model.qdl r19, int r20) {
        /*
            Method dump skipped, instruction units count: 2096
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.ud.qdl(org.json.JSONObject, com.bytedance.sdk.openadsdk.AdSlot, com.bytedance.sdk.openadsdk.core.model.bqt, com.bytedance.sdk.openadsdk.core.model.qdl, int):com.bytedance.sdk.openadsdk.core.model.ljh");
    }

    private static void qdl(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.ljh ljhVar) {
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt("iv_skip_time", -1);
            int iOptInt2 = jSONObject.optInt("rv_skip_time", -1);
            if (iOptInt != -1) {
                ljhVar.jjk(iOptInt);
            }
            if (iOptInt2 != -1) {
                ljhVar.zlt(iOptInt2);
            }
        }
    }

    private static com.bytedance.sdk.openadsdk.core.rq.jpc.qdl lnr(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.rq.jpc.qdl qdlVar = new com.bytedance.sdk.openadsdk.core.rq.jpc.qdl();
        qdlVar.qdl(jSONObject.optString("id"));
        qdlVar.ud(jSONObject.optString("md5"));
        qdlVar.lnr(jSONObject.optString("url"));
        return qdlVar;
    }

    private static void qdl(com.bytedance.sdk.openadsdk.core.model.ljh ljhVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("reason_code", -1);
            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, -1);
            com.bytedance.sdk.openadsdk.mml.lnr.ud(ljhVar, str, "load_vast_fail", jSONObject);
        } catch (Exception unused) {
        }
    }

    private static Pair<com.bytedance.sdk.openadsdk.core.fs.qdl, ud.qdl> qdl(String str, int i, int i2) {
        int iLnr;
        int iMzz;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i2 == 1 || i2 == 5) {
            iLnr = 0;
            iMzz = 0;
        } else {
            iLnr = ax.lnr(yt.qdl());
            iMzz = ax.mzz(yt.qdl());
            if (i == 2) {
                iMzz = iLnr;
                iLnr = iMzz;
            }
        }
        com.bytedance.sdk.openadsdk.core.fs.qdl.qdl.mzz mzzVar = new com.bytedance.sdk.openadsdk.core.fs.qdl.qdl.mzz(yt.qdl(), iLnr, iMzz);
        return new Pair<>(mzzVar.qdl(str, (File) null, new ArrayList()), mzzVar.mo);
    }

    private static void qdl(com.bytedance.sdk.openadsdk.core.fs.qdl qdlVar, com.bytedance.sdk.openadsdk.core.model.ljh ljhVar) {
        qdlVar.qdl(ljhVar);
        if (!qdl(ljhVar.ygv())) {
            ljhVar.xmv(2);
        }
        ljhVar.rq(1);
        ljhVar.qdl(qdlVar);
        if (!TextUtils.isEmpty(qdlVar.mml())) {
            ljhVar.aaj(qdlVar.mml());
        }
        if (!TextUtils.isEmpty(qdlVar.mzz())) {
            ljhVar.jyq(qdlVar.mzz());
        }
        ljhVar.jl(qdlVar.mo());
        ljhVar.qdl((com.bytedance.sdk.openadsdk.core.model.mo) null);
        com.bykv.vk.openvk.qdl.qdl.qdl.lnr.ud udVarTdy = ljhVar.tdy();
        if (udVarTdy == null) {
            udVarTdy = new com.bykv.vk.openvk.qdl.qdl.qdl.lnr.ud();
        }
        udVarTdy.lnr(qdlVar.wd());
        udVarTdy.qdl(qdlVar.jpc());
        udVarTdy.mo((String) null);
        udVarTdy.ud((String) null);
        udVarTdy.mml((String) null);
        ljhVar.qdl(udVarTdy);
        if (qdlVar.ud() != null && !TextUtils.isEmpty(qdlVar.ud().mzz())) {
            com.bytedance.sdk.openadsdk.core.model.jl jlVar = new com.bytedance.sdk.openadsdk.core.model.jl();
            jlVar.qdl(qdlVar.ud().mzz());
            jlVar.qdl(qdlVar.ud().ud());
            jlVar.ud(qdlVar.ud().lnr());
            ljhVar.qdl(jlVar);
            return;
        }
        if (ljhVar.hcs() == null) {
            com.bytedance.sdk.openadsdk.core.model.jl jlVar2 = new com.bytedance.sdk.openadsdk.core.model.jl();
            jlVar2.qdl("https://lf-static.tiktokpangle-cdn-us.com/obj/ad-pattern-tx/static/images/2023620white.jpeg");
            jlVar2.qdl(98);
            jlVar2.ud(98);
            ljhVar.qdl(jlVar2);
        }
    }

    private static com.bytedance.sdk.openadsdk.core.model.wd mml(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt("splash_clickarea", 2);
        int iOptInt2 = jSONObject.optInt("splash_layout_id", 1);
        long jOptLong = jSONObject.optLong("load_wait_time", 0L);
        long j = jOptLong >= 0 ? jOptLong : 0L;
        int iOptInt3 = jSONObject.optInt("skip_time", -1);
        com.bytedance.sdk.openadsdk.core.model.wd wdVar = new com.bytedance.sdk.openadsdk.core.model.wd();
        wdVar.ud(iOptInt);
        wdVar.lnr(iOptInt2);
        wdVar.qdl(j);
        wdVar.qdl(iOptInt3);
        return wdVar;
    }

    public static AdSlot ud(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("mCodeId", "");
        int iOptInt = jSONObject.optInt("mImgAcceptedWidth", 0);
        int iOptInt2 = jSONObject.optInt("mImgAcceptedHeight", 0);
        float fOptDouble = (float) jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d);
        float fOptDouble2 = (float) jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d);
        int iOptInt3 = jSONObject.optInt("mAdCount", 6);
        boolean zOptBoolean = jSONObject.optBoolean("mSupportDeepLink", true);
        String strOptString2 = jSONObject.optString("mRewardName", "");
        int iOptInt4 = jSONObject.optInt("mRewardAmount", 0);
        String strOptString3 = jSONObject.optString("mMediaExtra", "");
        String strOptString4 = jSONObject.optString("mUserID", "");
        jSONObject.optInt("mOrientation", 2);
        int iOptInt5 = jSONObject.optInt("mNativeAdType", 0);
        boolean zOptBoolean2 = jSONObject.optBoolean("mIsAutoPlay", false);
        boolean zOptBoolean3 = jSONObject.optBoolean("mIsExpressAd", false);
        String strOptString5 = jSONObject.optString("mBidAdm", "");
        return new AdSlot.Builder().setCodeId(strOptString).setImageAcceptedSize(iOptInt, iOptInt2).setExpressViewAcceptedSize(fOptDouble, fOptDouble2).setAdCount(iOptInt3).setSupportDeepLink(zOptBoolean).setRewardName(strOptString2).setRewardAmount(iOptInt4).setMediaExtra(strOptString3).setUserID(strOptString4).setNativeAdType(iOptInt5).setIsAutoPlay(zOptBoolean2).isExpressAd(zOptBoolean3).withBid(strOptString5).setDurationSlotType(jSONObject.optInt("mDurationSlotType", 0)).build();
    }

    private static FilterWord mzz(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            FilterWord filterWord = new FilterWord();
            filterWord.setId(jSONObject.optString("id"));
            filterWord.setName(jSONObject.optString("name"));
            filterWord.setIsSelected(jSONObject.optBoolean("is_selected"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("options");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    FilterWord filterWordMzz = mzz(jSONArrayOptJSONArray.optJSONObject(i));
                    if (filterWordMzz != null && filterWordMzz.isValid()) {
                        filterWord.addOption(filterWordMzz);
                    }
                }
            }
            return filterWord;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static com.bytedance.sdk.openadsdk.core.model.mo mo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.model.mo moVar = new com.bytedance.sdk.openadsdk.core.model.mo();
        moVar.ud(jSONObject.optString(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING));
        moVar.lnr(jSONObject.optString("package_name"));
        moVar.qdl(jSONObject.optString("download_url"));
        moVar.qdl(jSONObject.optDouble(FirebaseAnalytics.Param.SCORE, -1.0d));
        moVar.qdl(jSONObject.optInt("comment_num", -1));
        moVar.ud(jSONObject.optInt("app_size", 0));
        moVar.mml(jSONObject.optString("app_category"));
        return moVar;
    }

    private static com.bytedance.sdk.openadsdk.core.model.jyq wd(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.jyq jyqVar = new com.bytedance.sdk.openadsdk.core.model.jyq();
        if (jSONObject == null) {
            jyqVar.qdl(10L);
            jyqVar.ud(20L);
            jyqVar.lnr(10L);
            jyqVar.mml(20L);
            jyqVar.qdl("");
            return jyqVar;
        }
        jyqVar.qdl(jSONObject.optLong("onlylp_loading_maxtime", 10L));
        jyqVar.ud(jSONObject.optLong("straight_lp_showtime", 20L));
        jyqVar.lnr(jSONObject.optLong("onlyagg_loading_maxtime", 10L));
        jyqVar.mml(jSONObject.optLong("straight_agg_showtime", 20L));
        jyqVar.qdl(jSONObject.optString("loading_text", ""));
        return jyqVar;
    }

    private static com.bytedance.sdk.openadsdk.core.model.exc jpc(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.exc excVar = new com.bytedance.sdk.openadsdk.core.model.exc();
        if (jSONObject == null) {
            excVar.mml(5);
            excVar.mzz(30);
            excVar.mo(70);
            excVar.wd(1);
            excVar.jpc(com.bytedance.sdk.openadsdk.core.model.exc.qdl);
            excVar.lnr(0);
            excVar.ud(0);
            excVar.qdl(3);
            return excVar;
        }
        excVar.mml(jSONObject.optInt("ceiling_time", 5));
        excVar.mzz(jSONObject.optInt("ceiling_ratio", 30));
        excVar.mo(jSONObject.optInt("expand_ratio", 70));
        excVar.wd(jSONObject.optInt("back_type", 1));
        excVar.jpc(jSONObject.optInt("boc_return_type", com.bytedance.sdk.openadsdk.core.model.exc.qdl));
        excVar.lnr(jSONObject.optInt("pre_render_status", 0));
        excVar.ud(jSONObject.optInt("pre_render_use_gecko", 0));
        excVar.qdl(jSONObject.optInt("pre_render_add_type", 3));
        return excVar;
    }

    private static com.bytedance.sdk.openadsdk.core.model.jpc tvp(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.jpc jpcVar = new com.bytedance.sdk.openadsdk.core.model.jpc();
        if (jSONObject == null) {
            jpcVar.lnr(0);
            jpcVar.mml(0);
            jpcVar.ud(new ArrayList());
            jpcVar.mzz(0);
            jpcVar.qdl(new ArrayList());
            jpcVar.ud(0);
            jpcVar.qdl(0);
            return jpcVar;
        }
        jpcVar.lnr(jSONObject.optInt("interceptor_x", 0));
        jpcVar.mml(jSONObject.optInt("interceptor_y", 0));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("interceptor_page");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.optInt(i)));
            }
        }
        jpcVar.ud(arrayList);
        jpcVar.mzz(jSONObject.optInt("interceptor_interval_time", 0));
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("url_regular");
        ArrayList arrayList2 = new ArrayList();
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                arrayList2.add(jSONArrayOptJSONArray2.optString(i2));
            }
        }
        jpcVar.qdl(arrayList2);
        jpcVar.ud(jSONObject.optInt("boc_index", 0));
        jpcVar.qdl(jSONObject.optInt("is_act", 0));
        return jpcVar;
    }

    private static com.bytedance.sdk.openadsdk.core.model.rdp to(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.model.rdp rdpVar = new com.bytedance.sdk.openadsdk.core.model.rdp();
        rdpVar.qdl(jSONObject.optInt("if_send_click", 0));
        return rdpVar;
    }

    private static com.bytedance.sdk.openadsdk.core.model.exu rq(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.model.exu exuVar = new com.bytedance.sdk.openadsdk.core.model.exu();
        exuVar.qdl(jSONObject.optString("deeplink_url"));
        exuVar.ud(jSONObject.optString("fallback_url"));
        exuVar.qdl(jSONObject.optInt("fallback_type"));
        return exuVar;
    }

    private static com.bykv.vk.openvk.qdl.qdl.qdl.lnr.ud qdl(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.ljh ljhVar, boolean z) {
        int iOptInt;
        if (jSONObject == null) {
            return null;
        }
        com.bykv.vk.openvk.qdl.qdl.qdl.lnr.ud udVar = new com.bykv.vk.openvk.qdl.qdl.qdl.lnr.ud();
        udVar.ud(jSONObject.optInt("cover_height"));
        udVar.lnr(jSONObject.optInt("cover_width"));
        udVar.qdl(jSONObject.optString("resolution"));
        udVar.qdl(jSONObject.optLong(ContentDisposition.Parameters.Size));
        double dOptDouble = jSONObject.optDouble("video_duration", 0.0d);
        udVar.qdl(dOptDouble);
        int i = 1;
        int iOptInt2 = jSONObject.optInt("replay_time", 1);
        if (dOptDouble <= 15.0d && ljhVar.dk() != 1 && com.bytedance.sdk.openadsdk.core.model.ljh.mzz(ljhVar)) {
            i = iOptInt2;
        }
        udVar.to(i);
        udVar.ud(jSONObject.optString("cover_url"));
        udVar.lnr(jSONObject.optString(InneractiveRichMediaVideoPlayerActivityCore.VIDEO_URL));
        udVar.mml(jSONObject.optString("endcard"));
        udVar.mzz(jSONObject.optString("playable_download_url"));
        udVar.mo(jSONObject.optString("file_hash"));
        udVar.jpc(jSONObject.optInt("if_playable_loading_show", 0));
        udVar.tvp(jSONObject.optInt("remove_loading_page_type", 0));
        udVar.qdl(jSONObject.optInt("fallback_endcard_judge", 0));
        udVar.mzz(jSONObject.optInt("video_preload_size", 307200));
        udVar.mo(jSONObject.optInt("reward_video_cached_type", 0));
        udVar.wd(jSONObject.optInt("execute_cached_type", 0));
        if (z) {
            iOptInt = jSONObject.optInt("endcard_render", 0);
        } else {
            iOptInt = jSONObject.optInt("endcard_render", -1);
        }
        udVar.mml(iOptInt);
        return udVar;
    }

    private static Map<String, Object> fs(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                map.put(next, jSONObject.opt(next));
            }
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int qdl(com.bytedance.sdk.openadsdk.core.model.ljh r5) {
        /*
            r0 = 401(0x191, float:5.62E-43)
            r1 = 0
            if (r5 != 0) goto Lb
            java.lang.String r5 = ""
            com.bytedance.sdk.openadsdk.mml.lnr.lnr(r1, r5, r0)
            return r0
        Lb:
            int r2 = r5.ok()
            java.lang.String r2 = com.bytedance.sdk.openadsdk.utils.gy.lnr(r2)
            java.lang.String r3 = r5.yre()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto Lbd
            java.lang.String r3 = r5.yre()
            int r3 = r3.length()
            r4 = 1
            if (r3 > r4) goto L2a
            goto Lbd
        L2a:
            boolean r3 = r5.vxm()
            if (r3 == 0) goto L64
            int r3 = r5.ok()
            if (r3 >= 0) goto L47
            com.bytedance.sdk.openadsdk.AdSlot r3 = r5.ji()
            if (r3 == 0) goto L44
            com.bytedance.sdk.openadsdk.AdSlot r3 = r5.ji()
            r3.getDurationSlotType()
            goto L47
        L44:
            r5.vz()
        L47:
            boolean r3 = r5.au()
            if (r3 == 0) goto L4f
            java.lang.String r2 = "fullscreen_interstitial_ad"
        L4f:
            java.lang.String r3 = r5.fk()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L5f
            java.lang.String r3 = "load_html_fail"
            com.bytedance.sdk.openadsdk.mml.lnr.ud(r5, r2, r3, r1)
            return r0
        L5f:
            java.lang.String r0 = "load_html_success"
            com.bytedance.sdk.openadsdk.mml.lnr.ud(r5, r2, r0, r1)
        L64:
            int r0 = r5.ikv()
            if (r0 != 0) goto La9
            int r0 = r5.vxg()
            r1 = 2
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 == r1) goto L9b
            r1 = 3
            if (r0 == r1) goto L9b
            r1 = 4
            if (r0 == r1) goto L9b
            r1 = 5
            if (r0 == r1) goto L89
            r1 = 15
            if (r0 == r1) goto L89
            r1 = 16
            if (r0 == r1) goto L9b
            r1 = 50
            if (r0 == r1) goto L89
            goto La9
        L89:
            com.bykv.vk.openvk.qdl.qdl.qdl.lnr.ud r0 = r5.tdy()
            boolean r1 = r5.uj()
            int r0 = qdl(r0, r1)
            if (r0 == r3) goto La9
            com.bytedance.sdk.openadsdk.mml.lnr.lnr(r5, r2, r0)
            return r0
        L9b:
            java.util.List r0 = r5.vm()
            int r0 = qdl(r0)
            if (r0 == r3) goto La9
            com.bytedance.sdk.openadsdk.mml.lnr.lnr(r5, r2, r0)
            return r0
        La9:
            com.bytedance.sdk.openadsdk.core.settings.rq r0 = com.bytedance.sdk.openadsdk.core.settings.rq.lnr()
            boolean r0 = r0.uw()
            if (r0 == 0) goto Lb8
            int r5 = lnr(r5)
            goto Lbc
        Lb8:
            int r5 = ud(r5)
        Lbc:
            return r5
        Lbd:
            r0 = 402(0x192, float:5.63E-43)
            com.bytedance.sdk.openadsdk.mml.lnr.lnr(r5, r2, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.ud.qdl(com.bytedance.sdk.openadsdk.core.model.ljh):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int ud(com.bytedance.sdk.openadsdk.core.model.ljh r8) {
        /*
            int r0 = r8.ok()
            java.lang.String r0 = com.bytedance.sdk.openadsdk.utils.gy.lnr(r0)
            int r1 = r8.ikv()
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != 0) goto L1c
            com.bytedance.sdk.openadsdk.core.model.exu r1 = r8.bo()
            int r1 = qdl(r1)
            com.bytedance.sdk.openadsdk.mml.lnr.lnr(r8, r0, r1)
            goto L1d
        L1c:
            r1 = r2
        L1d:
            int r3 = r8.ygv()
            r4 = 2
            r5 = 406(0x196, float:5.69E-43)
            r6 = 407(0x197, float:5.7E-43)
            r7 = 417(0x1a1, float:5.84E-43)
            if (r3 == r4) goto L79
            r4 = 3
            if (r3 == r4) goto L79
            r4 = 4
            if (r3 == r4) goto L35
            r4 = 8
            if (r3 == r4) goto L79
            goto L8d
        L35:
            com.bytedance.sdk.openadsdk.core.model.mo r3 = r8.fhs()
            if (r3 != 0) goto L40
            com.bytedance.sdk.openadsdk.mml.lnr.lnr(r8, r0, r6)
            r1 = r6
            goto L8d
        L40:
            java.lang.String r4 = r3.lnr()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L59
            java.lang.String r4 = r3.qdl()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L59
            com.bytedance.sdk.openadsdk.mml.lnr.lnr(r8, r0, r7)
            r1 = r7
            goto L8d
        L59:
            java.lang.String r4 = r3.lnr()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L69
            r1 = 416(0x1a0, float:5.83E-43)
            com.bytedance.sdk.openadsdk.mml.lnr.lnr(r8, r0, r1)
            goto L8d
        L69:
            java.lang.String r3 = r3.qdl()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L8d
            r1 = 408(0x198, float:5.72E-43)
            com.bytedance.sdk.openadsdk.mml.lnr.lnr(r8, r0, r1)
            goto L8d
        L79:
            boolean r3 = mml(r8)
            if (r3 == 0) goto L8d
            java.lang.String r3 = r8.od()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L8d
            com.bytedance.sdk.openadsdk.mml.lnr.lnr(r8, r0, r5)
            r1 = r5
        L8d:
            if (r1 == r7) goto L9a
            if (r1 == r6) goto L9a
            if (r1 != r5) goto L94
            goto L9a
        L94:
            if (r1 == r2) goto L99
            com.bytedance.sdk.openadsdk.mml.lnr.ud(r8, r0, r1)
        L99:
            return r2
        L9a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.ud.ud(com.bytedance.sdk.openadsdk.core.model.ljh):int");
    }

    private static int lnr(com.bytedance.sdk.openadsdk.core.model.ljh ljhVar) {
        int iQdl;
        String strLnr = com.bytedance.sdk.openadsdk.utils.gy.lnr(ljhVar.ok());
        if (ljhVar.ikv() == 0) {
            iQdl = qdl(ljhVar.bo());
            if (iQdl != 200) {
                com.bytedance.sdk.openadsdk.mml.lnr.lnr(ljhVar, strLnr, iQdl);
                return iQdl;
            }
        } else {
            iQdl = 200;
        }
        int iYgv = ljhVar.ygv();
        if (iYgv != 2 && iYgv != 3) {
            if (iYgv == 4) {
                int iQdl2 = qdl(ljhVar.fhs());
                if (iQdl2 == 200) {
                    return iQdl2;
                }
                com.bytedance.sdk.openadsdk.mml.lnr.lnr(ljhVar, strLnr, iQdl2);
                return iQdl2;
            }
            if (iYgv != 8) {
                return iQdl;
            }
        }
        if (!mml(ljhVar) || !TextUtils.isEmpty(ljhVar.od())) {
            return iQdl;
        }
        com.bytedance.sdk.openadsdk.mml.lnr.lnr(ljhVar, strLnr, TTAdConstant.LANDING_PAGE_TYPE_CODE);
        return TTAdConstant.LANDING_PAGE_TYPE_CODE;
    }

    private static boolean mml(com.bytedance.sdk.openadsdk.core.model.ljh ljhVar) {
        return (ljhVar.uj() || ljhVar.vxm()) ? false : true;
    }

    private static int qdl(com.bytedance.sdk.openadsdk.core.model.exu exuVar) {
        if (exuVar == null) {
            return 200;
        }
        if (TextUtils.isEmpty(exuVar.qdl())) {
            return 403;
        }
        if (TextUtils.isEmpty(exuVar.ud())) {
            return TTAdConstant.DEEPLINK_FALLBACK_CODE;
        }
        if (exuVar.lnr() == 1 || exuVar.lnr() == 2) {
            return 200;
        }
        return TTAdConstant.DEEPLINK_FALLBACK_TYPE_CODE;
    }

    private static int qdl(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.ud udVar, boolean z) {
        if (udVar == null) {
            return TTAdConstant.VIDEO_INFO_CODE;
        }
        if (TextUtils.isEmpty(udVar.rq())) {
            return TTAdConstant.VIDEO_URL_CODE;
        }
        if (z || !TextUtils.isEmpty(udVar.to())) {
            return 200;
        }
        return TTAdConstant.VIDEO_COVER_URL_CODE;
    }

    private static int qdl(com.bytedance.sdk.openadsdk.core.model.mo moVar) {
        return moVar == null ? TTAdConstant.DOWNLOAD_APP_INFO_CODE : TextUtils.isEmpty(moVar.qdl()) ? TTAdConstant.DOWNLOAD_URL_CODE : TextUtils.isEmpty(moVar.lnr()) ? 416 : 200;
    }

    private static int qdl(List<com.bytedance.sdk.openadsdk.core.model.jl> list) {
        if (list == null) {
            return TTAdConstant.IMAGE_LIST_CODE;
        }
        if (list.size() <= 0) {
            return TTAdConstant.IMAGE_LIST_SIZE_CODE;
        }
        for (com.bytedance.sdk.openadsdk.core.model.jl jlVar : list) {
            if (jlVar == null) {
                return TTAdConstant.IMAGE_CODE;
            }
            if (TextUtils.isEmpty(jlVar.qdl())) {
                return 412;
            }
        }
        return 200;
    }

    private static void qdl(final ArrayList<qdl> arrayList) {
        com.bytedance.sdk.openadsdk.bjy.lnr.qdl("multiple_ads_parsing_error", false, new com.bytedance.sdk.openadsdk.bjy.ud() { // from class: com.bytedance.sdk.openadsdk.core.ud.1
            @Override // com.bytedance.sdk.openadsdk.bjy.ud
            public com.bytedance.sdk.openadsdk.bjy.qdl.lnr getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("material_error", arrayList.size());
                JSONArray jSONArray = new JSONArray();
                for (qdl qdlVar : arrayList) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("cid", qdlVar.qdl);
                    jSONObject2.put("error_msg", qdlVar.ud);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("error_cid_list", jSONArray);
                return com.bytedance.sdk.openadsdk.bjy.qdl.mml.ud().qdl("multiple_ads_parsing_error").ud(jSONObject.toString());
            }
        });
    }

    private static class qdl {
        public String qdl;
        public int ud;

        public qdl(String str, int i) {
            this.qdl = str;
            this.ud = i;
        }
    }
}
