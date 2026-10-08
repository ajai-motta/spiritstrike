package com.bytedance.sdk.openadsdk.yt;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.component.utils.jpc;
import com.bytedance.sdk.openadsdk.core.rdp;
import com.bytedance.sdk.openadsdk.core.yt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.messaging.Constants;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class lnr {
    private static volatile HandlerThread lnr = jpc.qdl("pag__bus_monitor", 0);
    private static volatile Handler mml;
    private static volatile qdl qdl;
    private static Boolean ud;

    public static qdl qdl() {
        if (qdl == null) {
            synchronized (lnr.class) {
                if (qdl == null) {
                    qdl = qdl.qdl(new ud() { // from class: com.bytedance.sdk.openadsdk.yt.lnr.1
                        @Override // com.bytedance.sdk.openadsdk.yt.ud
                        public Context getContext() {
                            return yt.qdl();
                        }

                        @Override // com.bytedance.sdk.openadsdk.yt.ud
                        public Handler getHandler() {
                            return lnr.mzz();
                        }

                        @Override // com.bytedance.sdk.openadsdk.yt.ud
                        public int getUploadIntervalTime() {
                            int iQdl = com.bytedance.sdk.openadsdk.jyq.qdl.qdl("bus_monitor_config", "interval", 86400000);
                            if (iQdl < 3600000) {
                                return 86400000;
                            }
                            return iQdl;
                        }

                        @Override // com.bytedance.sdk.openadsdk.yt.ud
                        public boolean isMonitorOpen() {
                            if (lnr.ud != null) {
                                return lnr.ud.booleanValue();
                            }
                            Boolean unused = lnr.ud = Boolean.valueOf(com.bytedance.sdk.openadsdk.jyq.qdl.qdl("bus_monitor_config", "enable", 1) == 1);
                            return lnr.ud.booleanValue();
                        }

                        @Override // com.bytedance.sdk.openadsdk.yt.ud
                        public void onMonitorUpload(List<com.bytedance.sdk.openadsdk.yt.ud.qdl> list) {
                            if (list == null || list.isEmpty()) {
                                return;
                            }
                            for (final com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar : list) {
                                com.bytedance.sdk.openadsdk.bjy.lnr.qdl();
                                com.bytedance.sdk.openadsdk.bjy.lnr.qdl("bus_monitor", false, new com.bytedance.sdk.openadsdk.bjy.ud() { // from class: com.bytedance.sdk.openadsdk.yt.lnr.1.1
                                    @Override // com.bytedance.sdk.openadsdk.bjy.ud
                                    public com.bytedance.sdk.openadsdk.bjy.qdl.lnr getLogStats() throws Exception {
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            jSONObject.put("sdk_version", qdlVar.ud());
                                            jSONObject.put("scene", qdlVar.lnr());
                                            jSONObject.put("start_count", qdlVar.mml());
                                            jSONObject.put("success_count", qdlVar.mzz());
                                            jSONObject.put("fail_count", qdlVar.mo());
                                            jSONObject.put("rit", qdlVar.wd());
                                            jSONObject.put(ViewHierarchyConstants.TAG_KEY, qdlVar.jpc());
                                            jSONObject.put(Constants.ScionAnalytics.PARAM_LABEL, qdlVar.tvp());
                                            jSONObject.put("mediation", qdlVar.rq());
                                            jSONObject.put("is_init", qdlVar.fs());
                                            jSONObject.put("extra", qdlVar.exu());
                                            jSONObject.put("date_device", qdlVar.to());
                                            return com.bytedance.sdk.openadsdk.bjy.qdl.mml.ud().qdl("bus_monitor").ud(jSONObject.toString());
                                        } catch (Exception e) {
                                            aaj.qdl("BusMonitorUtils", "onMonitorUpload: ", e);
                                            return null;
                                        }
                                    }
                                });
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.yt.ud
                        public int getOnceLogCount() {
                            int iQdl = com.bytedance.sdk.openadsdk.jyq.qdl.qdl("bus_monitor_config", "once_count", 10);
                            if (iQdl > 100 || iQdl < 5) {
                                return 10;
                            }
                            return iQdl;
                        }

                        @Override // com.bytedance.sdk.openadsdk.yt.ud
                        public int getOnceLogInterval() {
                            int iQdl = com.bytedance.sdk.openadsdk.jyq.qdl.qdl("bus_monitor_config", "once_interval", 10000);
                            if (iQdl < 10000) {
                                return 10000;
                            }
                            return iQdl;
                        }

                        @Override // com.bytedance.sdk.openadsdk.yt.ud
                        public HandlerThread getSafeHandlerThread(String str, int i) {
                            return jpc.qdl(str, i);
                        }
                    });
                }
            }
        }
        return qdl;
    }

    public static void qdl(mml mmlVar) {
        qdl().qdl(new mzz(mmlVar, 1, 0, 0));
    }

    public static void ud(mml mmlVar) {
        qdl().qdl(new mzz(mmlVar, 0, 1, 0));
    }

    public static void lnr(mml mmlVar) {
        qdl().qdl(new mzz(mmlVar, 0, 0, 1));
    }

    public static void ud() {
        qdl().qdl(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Handler mzz() {
        if (lnr == null || !lnr.isAlive()) {
            synchronized (rdp.class) {
                if (lnr == null || !lnr.isAlive()) {
                    lnr = jpc.qdl("csj_init_handle", -1);
                    mml = new Handler(lnr.getLooper());
                }
            }
        } else if (mml == null) {
            synchronized (rdp.class) {
                if (mml == null) {
                    mml = new Handler(lnr.getLooper());
                }
            }
        }
        return mml;
    }
}
