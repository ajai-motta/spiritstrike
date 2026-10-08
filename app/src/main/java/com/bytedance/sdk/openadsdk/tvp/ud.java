package com.bytedance.sdk.openadsdk.tvp;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.component.mzz.jtx;
import com.bytedance.sdk.component.mzz.rq;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ud<T> implements jtx<T> {
    private final jtx<T> lnr;
    private final ljh mml;
    private final long qdl = SystemClock.elapsedRealtime();
    private final String ud;

    public ud(final ljh ljhVar, String str, jtx<T> jtxVar) {
        this.lnr = jtxVar;
        this.mml = ljhVar;
        this.ud = str;
        if (mml.ud()) {
            com.bytedance.sdk.openadsdk.yt.lnr.qdl(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.tvp.ud.1
                @Override // com.bytedance.sdk.openadsdk.yt.mml
                public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                    com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                    qdlVar.ud("load_img");
                    ljh ljhVar2 = ljhVar;
                    if (ljhVar2 != null) {
                        qdlVar.lnr(ljhVar2.kdv("-1"));
                        qdlVar.mml(gy.lnr(ljhVar.ok()));
                    }
                    qdlVar.qdl(BuildConfig.VERSION_NAME);
                    return qdlVar;
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.mzz.jtx
    public void qdl(rq<T> rqVar) {
        jtx<T> jtxVar = this.lnr;
        if (jtxVar != null) {
            jtxVar.qdl(rqVar);
        }
        if (this.mml != null) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime() - this.qdl;
            final int iWd = rqVar.wd() / 1024;
            final int i = rqVar.mo() ? 1 : 0;
            com.bytedance.sdk.openadsdk.bjy.lnr.qdl("load_image_success", false, new com.bytedance.sdk.openadsdk.bjy.ud() { // from class: com.bytedance.sdk.openadsdk.tvp.ud.2
                @Override // com.bytedance.sdk.openadsdk.bjy.ud
                public com.bytedance.sdk.openadsdk.bjy.qdl.lnr getLogStats() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(TypedValues.TransitionType.S_DURATION, jElapsedRealtime);
                    jSONObject.put("url", ud.this.ud);
                    jSONObject.put("preload_size", iWd);
                    jSONObject.put("local_cache", i);
                    jSONObject.put("image_mode", ud.this.mml.vxg());
                    jSONObject.put("use_new_img", mml.ud() ? 1 : 0);
                    return com.bytedance.sdk.openadsdk.bjy.qdl.mml.ud().qdl("load_image_success").qdl(ud.this.mml.ok()).ud(jSONObject.toString());
                }
            });
            if (mml.ud()) {
                com.bytedance.sdk.openadsdk.yt.lnr.ud(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.tvp.ud.3
                    @Override // com.bytedance.sdk.openadsdk.yt.mml
                    public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                        com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                        qdlVar.ud("load_img");
                        if (ud.this.mml != null) {
                            qdlVar.lnr(ud.this.mml.kdv("-1"));
                            qdlVar.mml(gy.lnr(ud.this.mml.ok()));
                        }
                        qdlVar.qdl(BuildConfig.VERSION_NAME);
                        return qdlVar;
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.component.mzz.jtx
    public void qdl(final int i, final String str, final Throwable th) {
        jtx<T> jtxVar = this.lnr;
        if (jtxVar != null) {
            jtxVar.qdl(i, str, th);
        }
        ljh ljhVar = this.mml;
        if (ljhVar != null) {
            if (!TextUtils.isEmpty(gy.qdl(ljhVar))) {
                final long jElapsedRealtime = SystemClock.elapsedRealtime() - this.qdl;
                com.bytedance.sdk.openadsdk.bjy.lnr.qdl("load_image_error", false, new com.bytedance.sdk.openadsdk.bjy.ud() { // from class: com.bytedance.sdk.openadsdk.tvp.ud.4
                    @Override // com.bytedance.sdk.openadsdk.bjy.ud
                    public com.bytedance.sdk.openadsdk.bjy.qdl.lnr getLogStats() throws Exception {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(TypedValues.TransitionType.S_DURATION, jElapsedRealtime);
                        jSONObject.put("url", ud.this.ud);
                        jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, i);
                        Throwable th2 = th;
                        if (th2 instanceof NullPointerException) {
                            ApmHelper.reportCustomError("image load fail", "image_load", th2);
                        }
                        jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str);
                        jSONObject.put("image_mode", ud.this.mml.vxg());
                        jSONObject.put("use_new_img", mml.ud() ? 1 : 0);
                        return com.bytedance.sdk.openadsdk.bjy.qdl.mml.ud().qdl("load_image_error").qdl(ud.this.mml.ok()).ud(jSONObject.toString());
                    }
                });
            }
            if (mml.ud()) {
                com.bytedance.sdk.openadsdk.yt.lnr.lnr(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.tvp.ud.5
                    @Override // com.bytedance.sdk.openadsdk.yt.mml
                    public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                        com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                        qdlVar.ud("load_img");
                        if (ud.this.mml != null) {
                            qdlVar.lnr(ud.this.mml.kdv("-1"));
                            qdlVar.mml(gy.lnr(ud.this.mml.ok()));
                        }
                        qdlVar.qdl(BuildConfig.VERSION_NAME);
                        return qdlVar;
                    }
                });
            }
        }
    }
}
