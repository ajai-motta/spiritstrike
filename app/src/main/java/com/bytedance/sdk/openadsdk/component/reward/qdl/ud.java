package com.bytedance.sdk.openadsdk.component.reward.qdl;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.koa;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ud {
    public static void qdl(qdl qdlVar, Intent intent, Bundle bundle) {
        qdl(intent, qdlVar);
        qdl(bundle, qdlVar);
    }

    public static ljh qdl(Intent intent, Bundle bundle, com.bytedance.sdk.openadsdk.core.exu.mml.ud udVar) {
        if (!com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            com.bytedance.sdk.openadsdk.core.model.qdl qdlVarUd = koa.qdl().ud(koa.qdl(intent));
            ljhVarRq = qdlVarUd != null ? qdlVarUd.rq() : null;
            if (udVar != null) {
                udVar.qdl(bundle);
            }
            koa.qdl().mzz();
        } else if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_AD_INFO);
                if (stringExtra != null) {
                    ljhVarRq = com.bytedance.sdk.openadsdk.core.model.qdl.ud(new JSONObject(stringExtra)).rq();
                }
            } catch (Exception e) {
                aaj.qdl("TTAD.RFDM", "", e);
            }
        }
        if (bundle != null) {
            try {
                ljhVarRq = koa.qdl().qdl(bundle.getInt("meta_index", -1));
                Objects.toString(ljhVarRq);
            } catch (Throwable th) {
                aaj.qdl("TTAD.RFDM", "", th);
            }
        }
        if (ljhVarRq != null) {
            ljhVarRq.qdl(ljhVarRq.tid(), 7);
        }
        return ljhVarRq;
    }

    public static void qdl(Intent intent, qdl qdlVar) {
        if (intent == null) {
            return;
        }
        qdlVar.bch.lnr(intent.getBooleanExtra("video_is_cached", false));
        qdlVar.wak = intent.getStringExtra("multi_process_listener_key");
        qdlVar.car = intent.getIntExtra("orientation_angle", 0) == 3;
    }

    public static void qdl(Bundle bundle, qdl qdlVar) {
        if (bundle == null) {
            return;
        }
        qdlVar.wak = bundle.getString("multi_process_listener_key");
        qdlVar.bch.lnr(bundle.getBoolean("video_is_cached", false));
        qdlVar.gt = bundle.getBoolean("is_mute");
        if (bundle.getLong("video_current") > 0) {
            qdlVar.bch.ud(bundle.getLong("video_current", 0L));
        }
        qdlVar.qdl(bundle.getBoolean("has_show_skip_btn"));
    }

    public static void qdl(qdl qdlVar, Bundle bundle, int i) {
        if (bundle == null) {
            return;
        }
        try {
            bundle.putInt("meta_index", i);
            bundle.putString("multi_process_listener_key", qdlVar.wak);
            bundle.putBoolean("video_is_cached", qdlVar.bch.kdv());
            bundle.putLong("video_current", qdlVar.bch.fs());
            bundle.putBoolean("is_mute", qdlVar.gt);
            bundle.putBoolean("has_show_skip_btn", qdlVar.mlb);
        } catch (Throwable th) {
            aaj.qdl("TTAD.RFDM", "onSaveInstanceState: ", th);
        }
    }

    public static void qdl(ljh ljhVar, Intent intent, Bundle bundle, int i) {
        if (bundle == null || ljhVar == null) {
            return;
        }
        try {
            bundle.putInt("meta_index", i);
            Objects.toString(ljhVar);
            if (intent != null) {
                bundle.putString("multi_process_listener_key", intent.getStringExtra("multi_process_listener_key"));
                bundle.putBoolean("video_is_cached", intent.getBooleanExtra("video_is_cached", false));
            }
        } catch (Throwable th) {
            aaj.qdl("TTAD.RFDM", "onSaveInstanceState: ", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void qdl(android.content.Intent r2, android.app.Activity r3, boolean r4, com.bytedance.sdk.openadsdk.core.model.qdl r5, java.lang.String r6) {
        /*
            if (r3 != 0) goto L8
            r3 = 268435456(0x10000000, float:2.524355E-29)
            r2.addFlags(r3)
            goto L1d
        L8:
            android.view.WindowManager r3 = r3.getWindowManager()     // Catch: java.lang.Exception -> L15
            android.view.Display r3 = r3.getDefaultDisplay()     // Catch: java.lang.Exception -> L15
            int r3 = r3.getRotation()     // Catch: java.lang.Exception -> L15
            goto L1e
        L15:
            r3 = move-exception
            java.lang.String r0 = "TTAD.RFDM"
            java.lang.String r1 = ""
            com.bytedance.sdk.component.utils.aaj.qdl(r0, r1, r3)
        L1d:
            r3 = 0
        L1e:
            java.lang.String r0 = "orientation_angle"
            r2.putExtra(r0, r3)
            java.lang.String r3 = "video_is_cached"
            r2.putExtra(r3, r4)
            boolean r3 = com.bytedance.sdk.openadsdk.multipro.ud.lnr()
            if (r3 == 0) goto L45
            org.json.JSONObject r3 = r5.exu()
            if (r3 != 0) goto L36
            return
        L36:
            java.lang.String r4 = "multi_process_ad_info"
            java.lang.String r3 = r3.toString()
            r2.putExtra(r4, r3)
            java.lang.String r3 = "multi_process_listener_key"
            r2.putExtra(r3, r6)
            return
        L45:
            com.bytedance.sdk.openadsdk.core.koa r3 = com.bytedance.sdk.openadsdk.core.koa.qdl()
            r3.mzz()
            com.bytedance.sdk.openadsdk.core.koa r3 = com.bytedance.sdk.openadsdk.core.koa.qdl()
            int r3 = r3.qdl(r5)
            java.lang.String r4 = "meta_index"
            r2.putExtra(r4, r3)
            java.lang.String r3 = "single_process_listener_key"
            r2.putExtra(r3, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.qdl.ud.qdl(android.content.Intent, android.app.Activity, boolean, com.bytedance.sdk.openadsdk.core.model.qdl, java.lang.String):void");
    }
}
