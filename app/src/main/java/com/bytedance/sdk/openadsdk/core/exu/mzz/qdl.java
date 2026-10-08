package com.bytedance.sdk.openadsdk.core.exu.mzz;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr;
import com.bykv.vk.openvk.qdl.qdl.qdl.mzz.qdl;
import com.bytedance.sdk.component.jpc.jpc;
import com.bytedance.sdk.component.ud.qdl.wd;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.mml.mzz.ud.fs;
import com.bytedance.sdk.openadsdk.mml.mzz.ud.rq;
import com.bytedance.sdk.openadsdk.mml.mzz.ud.to;
import com.bytedance.sdk.openadsdk.mml.mzz.ud.tvp;
import com.bytedance.sdk.openadsdk.utils.fco;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.google.android.exoplayer2.PlaybackException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    public static final com.bykv.vk.openvk.qdl.qdl.qdl.mzz.qdl qdl = new com.bykv.vk.openvk.qdl.qdl.ud.qdl.ud.qdl();

    private static boolean qdl(lnr lnrVar) {
        return true;
    }

    public static void qdl(final lnr lnrVar, final qdl.InterfaceC0176qdl interfaceC0176qdl) {
        ljh ljhVar;
        AdSlot adSlot;
        if ((lnrVar.mo() > 0 || lnrVar.exu()) && lnrVar.jl() != -2) {
            if (lnrVar.jl() != 1) {
                lnrVar.mzz(PlaybackException.ERROR_CODE_DRM_UNSPECIFIED);
                lnrVar.mo(PlaybackException.ERROR_CODE_DRM_UNSPECIFIED);
                lnrVar.wd(PlaybackException.ERROR_CODE_DRM_UNSPECIFIED);
                boolean z = lnrVar.mzz("material_meta") != null && (lnrVar.mzz("material_meta") instanceof ljh);
                boolean z2 = lnrVar.mzz("ad_slot") != null && (lnrVar.mzz("ad_slot") instanceof AdSlot);
                if (z && z2) {
                    ljhVar = (ljh) lnrVar.mzz("material_meta");
                    AdSlot adSlot2 = (AdSlot) lnrVar.mzz("ad_slot");
                    ud(lnrVar, ljhVar, adSlot2);
                    adSlot = adSlot2;
                } else {
                    ljhVar = null;
                    adSlot = null;
                }
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                final ljh ljhVar2 = ljhVar;
                final AdSlot adSlot3 = adSlot;
                final qdl.InterfaceC0176qdl interfaceC0176qdl2 = new qdl.InterfaceC0176qdl() { // from class: com.bytedance.sdk.openadsdk.core.exu.mzz.qdl.1
                    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mzz.qdl.InterfaceC0176qdl
                    public void qdl(lnr lnrVar2, int i) {
                        qdl.InterfaceC0176qdl interfaceC0176qdl3 = interfaceC0176qdl;
                        if (interfaceC0176qdl3 != null) {
                            interfaceC0176qdl3.qdl(lnrVar2, i);
                        }
                        if (ljhVar2 == null || adSlot3 == null) {
                            return;
                        }
                        qdl.ud(lnrVar, ljhVar2, adSlot3, SystemClock.elapsedRealtime() - jElapsedRealtime);
                    }

                    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mzz.qdl.InterfaceC0176qdl
                    public void qdl(lnr lnrVar2, int i, String str) {
                        qdl.InterfaceC0176qdl interfaceC0176qdl3 = interfaceC0176qdl;
                        if (interfaceC0176qdl3 != null) {
                            interfaceC0176qdl3.qdl(lnrVar2, i, str);
                        }
                        if (ljhVar2 == null || adSlot3 == null) {
                            return;
                        }
                        qdl.ud(lnrVar, ljhVar2, adSlot3, SystemClock.elapsedRealtime() - jElapsedRealtime, i, str);
                    }

                    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mzz.qdl.InterfaceC0176qdl
                    public void ud(lnr lnrVar2, int i) {
                        AdSlot adSlot4;
                        qdl.InterfaceC0176qdl interfaceC0176qdl3 = interfaceC0176qdl;
                        if (interfaceC0176qdl3 != null) {
                            interfaceC0176qdl3.qdl(lnrVar2, i);
                        }
                        ljh ljhVar3 = ljhVar2;
                        if (ljhVar3 != null && (adSlot4 = adSlot3) != null) {
                            qdl.lnr(lnrVar, ljhVar3, adSlot4);
                        }
                        lnrVar.yt();
                    }
                };
                if (!qdl(lnrVar.jtx())) {
                    if (interfaceC0176qdl != null) {
                        interfaceC0176qdl.qdl(lnrVar, TTAdConstant.DEEPLINK_FALLBACK_CODE, "unexpected url: " + lnrVar.jtx());
                    }
                    ud(lnrVar, ljhVar, adSlot, SystemClock.elapsedRealtime() - jElapsedRealtime, -1, "video url is invalid");
                    return;
                }
                jpc jpcVar = new jpc("VideoPreload") { // from class: com.bytedance.sdk.openadsdk.core.exu.mzz.qdl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            qdl.qdl.qdl(yt.qdl(), lnrVar, interfaceC0176qdl2);
                        } catch (Throwable th) {
                            th.getMessage();
                        }
                    }
                };
                if (fco.mo()) {
                    fco.ud(jpcVar);
                    return;
                } else {
                    jpcVar.run();
                    return;
                }
            }
        }
        if (interfaceC0176qdl != null) {
            interfaceC0176qdl.qdl(lnrVar, 100);
        }
    }

    private static void ud(lnr lnrVar, ljh ljhVar, AdSlot adSlot) {
        if (qdl(lnrVar)) {
            com.bytedance.sdk.openadsdk.bjy.lnr.qdl("load_video_start", new com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl(ljhVar, gy.lnr(adSlot.getDurationSlotType()), com.bytedance.sdk.openadsdk.mml.mzz.qdl.qdl.qdl(ljhVar, (String) null, -1, lnrVar), new rq(lnrVar.jtx(), lnrVar.exu() ? lnrVar.fs() : lnrVar.mo())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ud(lnr lnrVar, ljh ljhVar, AdSlot adSlot, long j, int i, String str) {
        if (qdl(lnrVar)) {
            String strLnr = gy.lnr(adSlot.getDurationSlotType());
            JSONObject jSONObjectQdl = com.bytedance.sdk.openadsdk.mml.mzz.qdl.qdl.qdl(ljhVar, (String) null, -1, lnrVar);
            to toVar = new to();
            toVar.qdl(lnrVar.jtx());
            toVar.qdl(lnrVar.mo());
            toVar.ud(j);
            toVar.qdl(i);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            toVar.ud(str);
            toVar.lnr("");
            com.bytedance.sdk.openadsdk.mml.mzz.qdl.qdl.qdl((com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl<to>) new com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl(ljhVar, strLnr, jSONObjectQdl, toVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ud(lnr lnrVar, ljh ljhVar, AdSlot adSlot, long j) {
        if (qdl(lnrVar)) {
            String strLnr = gy.lnr(adSlot.getDurationSlotType());
            JSONObject jSONObjectQdl = com.bytedance.sdk.openadsdk.mml.mzz.qdl.qdl.qdl(ljhVar, (String) null, -1, lnrVar);
            fs fsVar = new fs();
            fsVar.qdl(lnrVar.jtx());
            fsVar.qdl(lnrVar.mo());
            fsVar.ud(j);
            if (lnrVar.oth() == 1) {
                fsVar.lnr(1L);
            } else {
                fsVar.lnr(0L);
            }
            com.bytedance.sdk.openadsdk.bjy.lnr.qdl("load_video_success", new com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl(ljhVar, strLnr, jSONObjectQdl, fsVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lnr(lnr lnrVar, ljh ljhVar, AdSlot adSlot) {
        if (qdl(lnrVar)) {
            com.bytedance.sdk.openadsdk.mml.mzz.qdl.qdl.ud((com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl<tvp>) new com.bytedance.sdk.openadsdk.mml.mzz.ud.qdl(ljhVar, gy.lnr(adSlot.getDurationSlotType()), com.bytedance.sdk.openadsdk.mml.mzz.qdl.qdl.qdl(ljhVar, (String) null, -1, lnrVar), new tvp(lnrVar.jtx(), lnrVar.mo())));
        }
    }

    public static boolean qdl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.regionMatches(true, 0, "ws:", 0, 3)) {
            str = "http:" + str.substring(3);
        } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
            str = "https:" + str.substring(4);
        }
        return wd.lnr(str) != null;
    }
}
