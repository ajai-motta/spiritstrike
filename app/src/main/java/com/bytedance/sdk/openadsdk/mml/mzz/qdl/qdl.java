package com.bytedance.sdk.openadsdk.mml.mzz.qdl;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr;
import com.bykv.vk.openvk.qdl.qdl.qdl.lnr.ud;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.mml.mzz.ud.bjy;
import com.bytedance.sdk.openadsdk.mml.mzz.ud.exu;
import com.bytedance.sdk.openadsdk.mml.mzz.ud.jpc;
import com.bytedance.sdk.openadsdk.mml.mzz.ud.mml;
import com.bytedance.sdk.openadsdk.mml.mzz.ud.mo;
import com.bytedance.sdk.openadsdk.mml.mzz.ud.mzz;
import com.bytedance.sdk.openadsdk.mml.mzz.ud.rdp;
import com.bytedance.sdk.openadsdk.mml.mzz.ud.to;
import com.bytedance.sdk.openadsdk.mml.mzz.ud.tvp;
import com.bytedance.sdk.openadsdk.mml.wd;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    private static final Map<com.bykv.vk.openvk.qdl.qdl.qdl.ud.qdl, bjy> qdl = Collections.synchronizedMap(new WeakHashMap());

    public static JSONObject qdl(ljh ljhVar, String str, int i, lnr lnrVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("session_id", str);
            }
            if (i > 0) {
                jSONObject.put("play_type", String.valueOf(i));
            }
            if (ljhVar != null) {
                ud udVarTdy = ljhVar.tdy();
                if (udVarTdy != null) {
                    jSONObject.put("video_resolution", udVarTdy.tvp());
                    jSONObject.put("video_size", Long.valueOf(udVarTdy.mzz()));
                    jSONObject.put(InneractiveRichMediaVideoPlayerActivityCore.VIDEO_URL, udVarTdy.rq());
                    jSONObject.put("player_type", lnrVar.jl());
                    jSONObject.put("video_encode_type", lnrVar.rdp() ? 1 : 0);
                }
                if (lnrVar.qdl()) {
                    jSONObject.put("pag_json_data", new JSONObject(lnrVar.lnr().toString()).toString());
                }
                jSONObject.put("dp_creative_type", ljhVar.ikv());
            }
        } catch (JSONException e) {
            aaj.qdl("TTAD.VideoEventManager", "", e);
        }
        return jSONObject;
    }

    public static void qdl(com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl<to> qdlVar) {
        com.bytedance.sdk.openadsdk.bjy.lnr.qdl("load_video_error", qdlVar);
    }

    public static void ud(com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl<tvp> qdlVar) {
        com.bytedance.sdk.openadsdk.bjy.lnr.qdl("load_video_cancel", qdlVar);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:6|(1:8)(2:10|(10:12|14|28|15|(1:17)|18|22|(1:25)|26|27)(1:13))|9|14|28|15|(0)|18|22|(0)|26|27) */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
    
        com.bytedance.sdk.component.utils.aaj.qdl("TTAD.VideoEventManager", "", r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048 A[Catch: JSONException -> 0x0059, TryCatch #0 {JSONException -> 0x0059, blocks: (B:15:0x0044, B:17:0x0048, B:18:0x004f), top: B:28:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void qdl(com.bytedance.sdk.openadsdk.core.model.ljh r11, com.bykv.vk.openvk.qdl.qdl.qdl.ud.qdl r12, com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr r13) {
        /*
            if (r11 == 0) goto L78
            if (r12 == 0) goto L78
            if (r13 != 0) goto L8
            goto L78
        L8:
            java.lang.String r7 = com.bytedance.sdk.openadsdk.utils.uw.qdl()
            boolean r0 = r13.uw()
            r8 = 1
            if (r0 == 0) goto L16
            r0 = 3
        L14:
            r9 = r0
            goto L28
        L16:
            int r0 = r11.lhl()
            com.bykv.vk.openvk.qdl.qdl.qdl.qdl.ud r0 = com.bytedance.sdk.openadsdk.CacheDirFactory.getICacheDir(r0)
            boolean r0 = r0.qdl(r13)
            if (r0 == 0) goto L26
            r9 = r8
            goto L28
        L26:
            r0 = 2
            goto L14
        L28:
            com.bytedance.sdk.openadsdk.mml.mzz.ud.bjy r10 = new com.bytedance.sdk.openadsdk.mml.mzz.ud.bjy
            long r1 = android.os.SystemClock.elapsedRealtime()
            r0 = r10
            r3 = r7
            r4 = r9
            r5 = r13
            r6 = r11
            r0.<init>(r1, r3, r4, r5, r6)
            java.util.Map<com.bykv.vk.openvk.qdl.qdl.qdl.ud.qdl, com.bytedance.sdk.openadsdk.mml.mzz.ud.bjy> r0 = com.bytedance.sdk.openadsdk.mml.mzz.qdl.qdl.qdl
            r0.put(r12, r10)
            org.json.JSONObject r12 = qdl(r11, r7, r9, r13)
            java.lang.String r0 = com.bytedance.sdk.openadsdk.utils.gy.qdl(r11)
            r1 = 0
            int r2 = r13.mzz     // Catch: org.json.JSONException -> L59
            if (r2 <= 0) goto L4f
            java.lang.String r2 = "play_time"
            int r3 = r13.mzz     // Catch: org.json.JSONException -> L59
            r12.put(r2, r3)     // Catch: org.json.JSONException -> L59
        L4f:
            java.lang.String r2 = "is_mute"
            boolean r3 = r13.rq()     // Catch: org.json.JSONException -> L59
            r12.put(r2, r3)     // Catch: org.json.JSONException -> L59
            goto L61
        L59:
            r2 = move-exception
            java.lang.String r3 = "TTAD.VideoEventManager"
            java.lang.String r4 = ""
            com.bytedance.sdk.component.utils.aaj.qdl(r3, r4, r2)
        L61:
            com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl r2 = new com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl
            r3 = 0
            r2.<init>(r11, r0, r12, r3)
            int r11 = r13.jl()
            r12 = -1
            if (r11 != r12) goto L6f
            goto L70
        L6f:
            r8 = r1
        L70:
            r2.qdl(r8)
            java.lang.String r11 = "play_start"
            qdl(r2, r11)
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.mml.mzz.qdl.qdl.qdl(com.bytedance.sdk.openadsdk.core.model.ljh, com.bykv.vk.openvk.qdl.qdl.qdl.ud.qdl, com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr):void");
    }

    public static void qdl(Context context, com.bykv.vk.openvk.qdl.qdl.qdl.ud.qdl qdlVar, bjy.qdl qdlVar2, wd wdVar) {
        bjy bjyVar;
        if (context == null || qdlVar == null || qdlVar2 == null || (bjyVar = qdl.get(qdlVar)) == null) {
            return;
        }
        lnr lnrVarMml = bjyVar.mml();
        ljh ljhVarMzz = bjyVar.mzz();
        if (lnrVarMml == null || ljhVarMzz == null) {
            return;
        }
        if (!qdlVar2.rq()) {
            qdl(ljhVarMzz, lnrVarMml, qdlVar2);
        }
        jpc jpcVar = new jpc();
        jpcVar.qdl(qdlVar2.fs() ? 1 : 0);
        jpcVar.ud(CacheDirFactory.getICacheDir(ljhVarMzz.lhl()).ud(lnrVarMml));
        jpcVar.qdl(SystemClock.elapsedRealtime() - bjyVar.qdl());
        JSONObject jSONObjectQdl = qdl(ljhVarMzz, bjyVar.ud(), bjyVar.lnr(), lnrVarMml);
        if (lnrVarMml.mzz > 0) {
            try {
                jSONObjectQdl.put("play_time", lnrVarMml.mzz);
            } catch (JSONException e) {
                aaj.qdl("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl qdlVar3 = new com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl(ljhVarMzz, gy.qdl(ljhVarMzz), jSONObjectQdl, jpcVar);
        qdlVar3.qdl(qdlVar2.rq());
        qdl(qdlVar3, "feed_play", wdVar);
    }

    public static void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.ud.qdl qdlVar, bjy.qdl qdlVar2) {
        bjy bjyVar;
        if (qdlVar == null || qdlVar2 == null || (bjyVar = qdl.get(qdlVar)) == null) {
            return;
        }
        lnr lnrVarMml = bjyVar.mml();
        ljh ljhVarMzz = bjyVar.mzz();
        if (lnrVarMml == null || ljhVarMzz == null) {
            return;
        }
        long jUd = qdlVar2.ud();
        long jMml = qdlVar2.mml();
        if (jMml <= 0 || jUd <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.mml.mzz.ud.wd wdVar = new com.bytedance.sdk.openadsdk.mml.mzz.ud.wd();
        wdVar.qdl(qdlVar2.lnr());
        wdVar.ud(jMml);
        JSONObject jSONObjectQdl = qdl(ljhVarMzz, bjyVar.ud(), bjyVar.lnr(), lnrVarMml);
        if (lnrVarMml.mzz > 0) {
            try {
                jSONObjectQdl.put("play_time", lnrVarMml.mzz);
            } catch (Throwable th) {
                aaj.qdl("TTAD.VideoEventManager", "", th);
            }
        }
        qdl(qdlVar2, ljhVarMzz, jSONObjectQdl);
        com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl qdlVar3 = new com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl(ljhVarMzz, gy.qdl(ljhVarMzz), jSONObjectQdl, wdVar);
        qdlVar3.qdl(qdlVar2.rq());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TypedValues.TransitionType.S_DURATION, jUd);
            jSONObject.put("percent", qdlVar2.wd());
            qdl(qdlVar3, "feed_pause", jSONObject);
        } catch (JSONException e) {
            aaj.qdl("TTAD.VideoEventManager", "", e);
        }
    }

    private static void qdl(bjy.qdl qdlVar, ljh ljhVar, JSONObject jSONObject) {
        if (ljhVar != null) {
            try {
                if (ljhVar.eu() != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("speed_type", ljhVar.eu().ud());
                    jSONObject2.put("speed", ljhVar.eu().qdl());
                    jSONObject2.put("speed_duration", qdlVar.qdl());
                    jSONObject.put("pag_json_data", jSONObject2.toString());
                }
            } catch (Throwable th) {
                aaj.qdl("TTAD.VideoEventManager", "", th);
            }
        }
    }

    public static void ud(com.bykv.vk.openvk.qdl.qdl.qdl.ud.qdl qdlVar, bjy.qdl qdlVar2) {
        bjy bjyVar;
        if (qdlVar == null || qdlVar2 == null || (bjyVar = qdl.get(qdlVar)) == null) {
            return;
        }
        lnr lnrVarMml = bjyVar.mml();
        ljh ljhVarMzz = bjyVar.mzz();
        if (lnrVarMml == null || ljhVarMzz == null) {
            return;
        }
        long jUd = qdlVar2.ud();
        long jMml = qdlVar2.mml();
        if (jMml <= 0 || jUd <= 0) {
            return;
        }
        mzz mzzVar = new mzz();
        mzzVar.qdl(qdlVar2.lnr());
        mzzVar.ud(jMml);
        JSONObject jSONObjectQdl = qdl(ljhVarMzz, bjyVar.ud(), bjyVar.lnr(), lnrVarMml);
        if (lnrVarMml.mzz > 0) {
            try {
                jSONObjectQdl.put("play_time", lnrVarMml.mzz);
            } catch (JSONException e) {
                aaj.qdl("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl qdlVar3 = new com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl(ljhVarMzz, gy.qdl(ljhVarMzz), jSONObjectQdl, mzzVar);
        qdlVar3.qdl(qdlVar2.rq());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TypedValues.TransitionType.S_DURATION, jUd);
            jSONObject.put("percent", qdlVar2.wd());
            qdl(qdlVar3, "feed_continue", jSONObject);
        } catch (JSONException e2) {
            aaj.qdl("TTAD.VideoEventManager", "", e2);
        }
    }

    public static void lnr(com.bykv.vk.openvk.qdl.qdl.qdl.ud.qdl qdlVar, bjy.qdl qdlVar2) {
        bjy bjyVar;
        if (qdlVar == null || qdlVar2 == null || (bjyVar = qdl.get(qdlVar)) == null) {
            return;
        }
        lnr lnrVarMml = bjyVar.mml();
        ljh ljhVarMzz = bjyVar.mzz();
        if (lnrVarMml == null || ljhVarMzz == null) {
            return;
        }
        long jUd = qdlVar2.ud();
        long jMml = qdlVar2.mml();
        rdp rdpVar = new rdp(qdlVar2.exu());
        rdpVar.qdl(qdlVar2.lnr());
        rdpVar.ud(jMml);
        JSONObject jSONObjectQdl = qdl(ljhVarMzz, bjyVar.ud(), bjyVar.lnr(), lnrVarMml);
        if (lnrVarMml.mzz > 0) {
            try {
                jSONObjectQdl.put("play_time", lnrVarMml.mzz);
            } catch (JSONException e) {
                aaj.qdl("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl qdlVar3 = new com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl(ljhVarMzz, gy.qdl(ljhVarMzz), jSONObjectQdl, rdpVar);
        qdlVar3.qdl(qdlVar2.rq());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TypedValues.TransitionType.S_DURATION, jUd);
            jSONObject.put("percent", qdlVar2.wd());
            qdl(qdlVar3, "play_error", jSONObject);
        } catch (JSONException e2) {
            aaj.qdl("TTAD.VideoEventManager", "", e2);
        }
    }

    public static void mml(com.bykv.vk.openvk.qdl.qdl.qdl.ud.qdl qdlVar, bjy.qdl qdlVar2) {
        bjy bjyVar;
        if (qdlVar == null || qdlVar2 == null || (bjyVar = qdl.get(qdlVar)) == null) {
            return;
        }
        lnr lnrVarMml = bjyVar.mml();
        ljh ljhVarMzz = bjyVar.mzz();
        if (lnrVarMml == null || ljhVarMzz == null) {
            return;
        }
        long jUd = qdlVar2.ud();
        long jMml = qdlVar2.mml();
        com.bytedance.sdk.openadsdk.mml.mzz.ud.ud udVar = new com.bytedance.sdk.openadsdk.mml.mzz.ud.ud();
        udVar.qdl(qdlVar2.lnr());
        udVar.ud(jMml);
        udVar.qdl(qdlVar2.mzz());
        udVar.ud(qdlVar2.mo());
        com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl qdlVar3 = new com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl(ljhVarMzz, gy.qdl(ljhVarMzz), qdl(ljhVarMzz, bjyVar.ud(), bjyVar.lnr(), lnrVarMml), udVar);
        qdlVar3.qdl(qdlVar2.rq());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TypedValues.TransitionType.S_DURATION, jUd);
            jSONObject.put("percent", qdlVar2.wd());
            qdl(qdlVar3, "endcard_skip", jSONObject);
        } catch (JSONException e) {
            aaj.qdl("TTAD.VideoEventManager", "", e);
        }
        qdl.remove(qdlVar);
    }

    public static void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.ud.qdl qdlVar, bjy.qdl qdlVar2, wd wdVar) {
        if (qdlVar == null || qdlVar2 == null) {
            return;
        }
        mzz(qdlVar, qdlVar2);
        bjy bjyVar = qdl.get(qdlVar);
        if (bjyVar == null) {
            return;
        }
        lnr lnrVarMml = bjyVar.mml();
        ljh ljhVarMzz = bjyVar.mzz();
        if (lnrVarMml == null || ljhVarMzz == null) {
            return;
        }
        long jUd = qdlVar2.ud();
        long jMml = qdlVar2.mml();
        mml mmlVar = new mml();
        mmlVar.ud(qdlVar2.lnr());
        mmlVar.qdl(jMml);
        mmlVar.qdl(qdlVar2.jpc());
        mmlVar.ud(qdlVar2.tvp());
        JSONObject jSONObjectQdl = qdl(ljhVarMzz, bjyVar.ud(), bjyVar.lnr(), lnrVarMml);
        if (lnrVarMml.mzz > 0) {
            try {
                jSONObjectQdl.put("play_time", lnrVarMml.mzz);
            } catch (JSONException e) {
                aaj.qdl("TTAD.VideoEventManager", "", e);
            }
        }
        qdl(qdlVar2, ljhVarMzz, jSONObjectQdl);
        com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl qdlVar3 = new com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl(ljhVarMzz, gy.qdl(ljhVarMzz), jSONObjectQdl, mmlVar);
        qdlVar3.qdl(qdlVar2.rq());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TypedValues.TransitionType.S_DURATION, jUd);
            jSONObject.put("percent", qdlVar2.wd());
            qdl(qdlVar3, "feed_break", jSONObject, wdVar);
        } catch (JSONException e2) {
            aaj.qdl("TTAD.VideoEventManager", "", e2);
        }
    }

    public static void ud(com.bykv.vk.openvk.qdl.qdl.qdl.ud.qdl qdlVar, bjy.qdl qdlVar2, wd wdVar) {
        if (qdlVar == null || qdlVar2 == null) {
            return;
        }
        mzz(qdlVar, qdlVar2);
        bjy bjyVar = qdl.get(qdlVar);
        if (bjyVar == null) {
            return;
        }
        lnr lnrVarMml = bjyVar.mml();
        ljh ljhVarMzz = bjyVar.mzz();
        if (lnrVarMml == null || ljhVarMzz == null) {
            return;
        }
        long jUd = qdlVar2.ud();
        long jMml = qdlVar2.mml();
        mo moVar = new mo();
        moVar.ud(qdlVar2.lnr());
        moVar.qdl(jMml);
        moVar.qdl(qdlVar2.tvp());
        JSONObject jSONObjectQdl = qdl(ljhVarMzz, bjyVar.ud(), bjyVar.lnr(), lnrVarMml);
        if (lnrVarMml.mzz > 0) {
            try {
                jSONObjectQdl.put("play_time", lnrVarMml.mzz);
            } catch (JSONException e) {
                aaj.qdl("TTAD.VideoEventManager", "", e);
            }
        }
        qdl(qdlVar2, ljhVarMzz, jSONObjectQdl);
        com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl qdlVar3 = new com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl(ljhVarMzz, gy.qdl(ljhVarMzz), jSONObjectQdl, moVar);
        qdlVar3.qdl(qdlVar2.rq());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TypedValues.TransitionType.S_DURATION, jUd);
            jSONObject.put("percent", qdlVar2.wd());
            qdl(qdlVar3, "feed_over", jSONObject, wdVar);
        } catch (JSONException e2) {
            aaj.qdl("TTAD.VideoEventManager", "", e2);
        }
        qdl.remove(qdlVar);
    }

    public static void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.ud.qdl qdlVar, boolean z, String str) {
        bjy bjyVar;
        if (qdlVar == null || (bjyVar = qdl.get(qdlVar)) == null) {
            return;
        }
        lnr lnrVarMml = bjyVar.mml();
        ljh ljhVarMzz = bjyVar.mzz();
        if (lnrVarMml == null || ljhVarMzz == null) {
            return;
        }
        JSONObject jSONObjectQdl = qdl(ljhVarMzz, bjyVar.ud(), bjyVar.lnr(), lnrVarMml);
        try {
            if (lnrVarMml.mzz > 0) {
                jSONObjectQdl.put("play_time", lnrVarMml.mzz);
            }
            jSONObjectQdl.put("is_mute", z ? 1 : 0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("from", str);
            jSONObjectQdl.put("pag_json_data", jSONObject);
        } catch (JSONException e) {
            aaj.qdl("TTAD.VideoEventManager", "", e);
        }
        qdl(new com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl(ljhVarMzz, gy.qdl(ljhVarMzz), jSONObjectQdl, null), "mute_state_change");
    }

    public static void mzz(com.bykv.vk.openvk.qdl.qdl.qdl.ud.qdl qdlVar, bjy.qdl qdlVar2) {
        bjy bjyVar;
        if (qdlVar == null || qdlVar2 == null || qdlVar2.to() <= 0 || (bjyVar = qdl.get(qdlVar)) == null) {
            return;
        }
        lnr lnrVarMml = bjyVar.mml();
        ljh ljhVarMzz = bjyVar.mzz();
        if (lnrVarMml == null || ljhVarMzz == null) {
            return;
        }
        long jMml = qdlVar2.mml();
        exu exuVar = new exu();
        exuVar.qdl(qdlVar2.lnr());
        exuVar.ud(jMml);
        exuVar.qdl(qdlVar2.to());
        JSONObject jSONObjectQdl = qdl(ljhVarMzz, bjyVar.ud(), bjyVar.lnr(), lnrVarMml);
        if (lnrVarMml.mzz > 0) {
            try {
                jSONObjectQdl.put("play_time", lnrVarMml.mzz);
            } catch (JSONException e) {
                aaj.qdl("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl qdlVar3 = new com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl(ljhVarMzz, gy.qdl(ljhVarMzz), jSONObjectQdl, exuVar);
        qdlVar3.qdl(qdlVar2.rq());
        qdl(qdlVar3, "play_buffer");
    }

    private static void qdl(com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl qdlVar, String str) {
        qdl(qdlVar, str, (JSONObject) null, (wd) null);
    }

    private static void qdl(com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl qdlVar, String str, JSONObject jSONObject) {
        qdl(qdlVar, str, jSONObject, (wd) null);
    }

    private static void qdl(com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl qdlVar, String str, wd wdVar) {
        qdl(qdlVar, str, (JSONObject) null, wdVar);
    }

    private static void qdl(final com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl qdlVar, String str, final JSONObject jSONObject, final wd wdVar) {
        if (qdlVar == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (qdlVar.mzz() && !TextUtils.isEmpty(qdlVar.ud())) {
            String strUd = qdlVar.ud();
            strUd.hashCode();
            if (strUd.equals("stream") || strUd.equals("embeded_ad")) {
                str = "customer_".concat(String.valueOf(str));
            }
        }
        final String str2 = str;
        com.bytedance.sdk.openadsdk.mml.lnr.qdl(System.currentTimeMillis(), qdlVar.qdl(), qdlVar.ud(), str2, new com.bytedance.sdk.openadsdk.bjy.lnr.qdl() { // from class: com.bytedance.sdk.openadsdk.mml.mzz.qdl.qdl.1
            @Override // com.bytedance.sdk.openadsdk.bjy.lnr.qdl, com.bytedance.sdk.openadsdk.bjy.lnr.ud
            public JSONObject lnr() {
                wd wdVar2;
                try {
                    JSONObject jSONObjectLnr = qdlVar.lnr();
                    if (qdlVar.mml() != null) {
                        qdlVar.mml().qdl(jSONObjectLnr);
                    }
                    if (("feed_play".equals(str2) || "feed_over".equals(str2) || "feed_break".equals(str2)) && (wdVar2 = wdVar) != null) {
                        wdVar2.qdl(jSONObjectLnr);
                    }
                    return jSONObjectLnr;
                } catch (Throwable unused) {
                    return null;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.bjy.lnr.qdl, com.bytedance.sdk.openadsdk.bjy.lnr.ud
            public JSONObject ud() {
                return jSONObject;
            }
        });
    }

    private static void qdl(final ljh ljhVar, final lnr lnrVar, final bjy.qdl qdlVar) {
        com.bytedance.sdk.openadsdk.bjy.lnr.qdl();
        com.bytedance.sdk.openadsdk.bjy.lnr.qdl("pangle_video_play_state", false, new com.bytedance.sdk.openadsdk.bjy.ud() { // from class: com.bytedance.sdk.openadsdk.mml.mzz.qdl.qdl.2
            @Override // com.bytedance.sdk.openadsdk.bjy.ud
            public com.bytedance.sdk.openadsdk.bjy.qdl.lnr getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("service_duration", qdl.lnr(lnrVar));
                jSONObject.put("player_duration", qdlVar.mml());
                jSONObject.put("cache_path_type", CacheDirFactory.getCacheType());
                jSONObject.put("url", lnrVar.jtx());
                jSONObject.put("path", qdl.mml(lnrVar));
                jSONObject.put("player_type", lnrVar.jl());
                com.bytedance.sdk.openadsdk.bjy.qdl.mml mmlVarQdl = com.bytedance.sdk.openadsdk.bjy.qdl.mml.ud().qdl("pangle_video_play_state");
                ljh ljhVar2 = ljhVar;
                return mmlVarQdl.qdl(ljhVar2 != null ? ljhVar2.vz() : 0).ud(jSONObject.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long lnr(lnr lnrVar) {
        if (lnrVar == null) {
            return 0L;
        }
        ud udVarBch = lnrVar.rdp() ? lnrVar.bch() : lnrVar.ljh();
        if (udVarBch != null) {
            return Double.valueOf(udVarBch.mo() * 1000.0d).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String mml(lnr lnrVar) {
        return new File(lnrVar.mzz(), lnrVar.yt()).getAbsolutePath();
    }
}
