package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.component.utils.bqt;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class rq {
    private static final AtomicInteger qdl = new AtomicInteger(0);
    private static final AtomicBoolean ud = new AtomicBoolean(false);

    public static void qdl(String str) {
        AtomicBoolean atomicBoolean = ud;
        if (atomicBoolean.compareAndSet(false, true)) {
            if (!com.bytedance.sdk.component.utils.jl.jpc(yt.qdl())) {
                atomicBoolean.set(false);
            } else {
                qdl.qdl();
                ud(str);
            }
        }
    }

    public static void ud(final String str) {
        com.bytedance.sdk.openadsdk.utils.fco.lnr(new com.bytedance.sdk.component.jpc.jpc("ipv6") { // from class: com.bytedance.sdk.openadsdk.core.rq.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectQdl;
                final String strExc = com.bytedance.sdk.openadsdk.utils.gy.exc();
                com.bytedance.sdk.openadsdk.bjy.lnr.qdl(0, strExc);
                com.bytedance.sdk.openadsdk.yt.lnr.qdl(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.rq.1.1
                    @Override // com.bytedance.sdk.openadsdk.yt.mml
                    public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                        com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                        qdlVar.ud("ipv6");
                        return qdlVar;
                    }
                });
                if (TextUtils.isEmpty(strExc)) {
                    com.bytedance.sdk.openadsdk.bjy.lnr.qdl(-1, strExc, -1, "url is null");
                    com.bytedance.sdk.openadsdk.bjy.qdl.mzz.qdl("ipv6", "", -2, "url is null");
                    com.bytedance.sdk.openadsdk.yt.lnr.lnr(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.rq.1.2
                        @Override // com.bytedance.sdk.openadsdk.yt.mml
                        public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                            com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                            qdlVar.ud("ipv6");
                            return qdlVar;
                        }
                    });
                    return;
                }
                com.bytedance.sdk.component.wd.ud.mml mmlVarUd = com.bytedance.sdk.openadsdk.jl.ud.ud().lnr().ud();
                try {
                    mmlVarUd.ud(strExc);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("connect_type", com.bytedance.sdk.component.utils.bqt.qdl(yt.qdl(), 0L));
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("device_id", Long.parseLong(str));
                    }
                    jSONObject.put("header", com.bytedance.sdk.openadsdk.mml.qdl.qdl.qdl().ud());
                    if (com.bytedance.sdk.openadsdk.core.settings.rq.lnr().qdl(PangleEncryptConstant.CryptDataScene.APP_LOG)) {
                        jSONObjectQdl = PangleEncryptManager.encryptType4(jSONObject, new bch(PangleEncryptConstant.CryptDataScene.DUAL_EVENT));
                        if (jSONObjectQdl != null && jSONObjectQdl.optInt("cypher") == 4) {
                            uw.ud(true);
                            mmlVarUd.ud("x-pgli18n", "4");
                            mmlVarUd.ud("Content-Type", "application/json; charset=utf-8");
                        } else {
                            uw.ud(false);
                        }
                    } else {
                        jSONObjectQdl = com.bytedance.sdk.component.utils.qdl.qdl(jSONObject);
                        if (rq.ud(jSONObjectQdl)) {
                            mmlVarUd.ud(HttpHeaders.CONTENT_ENCODING, "union_sdk_encode");
                        }
                    }
                    if (rq.ud(jSONObjectQdl)) {
                        jSONObject = jSONObjectQdl;
                    }
                    mmlVarUd.ud("Content-Type", "application/json; charset=utf-8");
                    mmlVarUd.ud(HttpHeaders.USER_AGENT, com.bytedance.sdk.openadsdk.utils.gy.mml());
                    mmlVarUd.qdl(jSONObject);
                    mmlVarUd.qdl(6);
                    mmlVarUd.qdl("send_i_p_v6");
                    mmlVarUd.qdl(new com.bytedance.sdk.component.wd.qdl.qdl() { // from class: com.bytedance.sdk.openadsdk.core.rq.1.3
                        @Override // com.bytedance.sdk.component.wd.qdl.qdl
                        public void qdl(com.bytedance.sdk.component.wd.ud.lnr lnrVar, com.bytedance.sdk.component.wd.ud udVar) {
                            if (udVar.mo()) {
                                rq.ud(udVar.mml(), strExc);
                                return;
                            }
                            com.bytedance.sdk.openadsdk.bjy.lnr.qdl(-1, strExc, udVar.qdl(), udVar.ud());
                            com.bytedance.sdk.openadsdk.bjy.qdl.mzz.qdl("ipv6", strExc, udVar.qdl(), udVar.ud());
                            com.bytedance.sdk.openadsdk.yt.lnr.lnr(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.rq.1.3.1
                                @Override // com.bytedance.sdk.openadsdk.yt.mml
                                public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                                    com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                                    qdlVar.ud("ipv6");
                                    return qdlVar;
                                }
                            });
                            rq.mml();
                        }

                        @Override // com.bytedance.sdk.component.wd.qdl.qdl
                        public void qdl(com.bytedance.sdk.component.wd.ud.lnr lnrVar, IOException iOException) {
                            if (iOException != null) {
                                com.bytedance.sdk.openadsdk.bjy.lnr.qdl(-1, strExc, 1, iOException.getMessage());
                                com.bytedance.sdk.openadsdk.bjy.qdl.mzz.qdl("ipv6", strExc, -1, iOException.getMessage());
                                com.bytedance.sdk.openadsdk.yt.lnr.lnr(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.rq.1.3.2
                                    @Override // com.bytedance.sdk.openadsdk.yt.mml
                                    public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                                        com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                                        qdlVar.ud("ipv6");
                                        return qdlVar;
                                    }
                                });
                            }
                            rq.mml();
                        }
                    });
                } catch (Exception e) {
                    com.bytedance.sdk.openadsdk.bjy.lnr.qdl(-1, strExc, -2, e.getMessage());
                    com.bytedance.sdk.openadsdk.bjy.qdl.mzz.qdl("ipv6", strExc, -3, e.getMessage());
                    com.bytedance.sdk.openadsdk.yt.lnr.lnr(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.rq.1.4
                        @Override // com.bytedance.sdk.openadsdk.yt.mml
                        public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                            com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                            qdlVar.ud("ipv6");
                            return qdlVar;
                        }
                    });
                    com.bytedance.sdk.component.utils.aaj.lnr("build ipv6 request failed:" + e.getMessage(), new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void ud(java.lang.String r13, java.lang.String r14) {
        /*
            Method dump skipped, instruction units count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.rq.ud(java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean ud(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lnr() {
        qdl.set(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mml() {
        if (qdl.getAndIncrement() <= 0) {
            com.bytedance.sdk.openadsdk.utils.fco.qdl().schedule(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rq.2
                @Override // java.lang.Runnable
                public void run() {
                    rq.ud(fs.qdl(yt.qdl()));
                }
            }, 10000L, TimeUnit.MILLISECONDS);
        }
    }

    private static class qdl implements bqt.qdl {
        private static final AtomicBoolean qdl = new AtomicBoolean(false);
        private static volatile long ud = -1;

        private qdl() {
        }

        public static void qdl() {
            if (qdl.compareAndSet(false, true)) {
                ud = System.currentTimeMillis();
                com.bytedance.sdk.component.utils.bqt.qdl(new qdl(), yt.qdl());
            }
        }

        public void ud() {
            com.bytedance.sdk.component.utils.bqt.qdl(this);
        }

        @Override // com.bytedance.sdk.component.utils.bqt.qdl
        public void qdl(Context context, Intent intent, boolean z, int i) {
            if (System.currentTimeMillis() - ud >= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS && i != 0) {
                rq.lnr();
                rq.ud(fs.qdl(yt.qdl()));
                ud();
            }
        }
    }
}
