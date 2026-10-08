package com.bytedance.sdk.openadsdk.jl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.component.mzz.jtx;
import com.bytedance.sdk.component.ud.qdl.fs;
import com.bytedance.sdk.component.ud.qdl.jpc;
import com.bytedance.sdk.component.ud.qdl.mml;
import com.bytedance.sdk.component.ud.qdl.qdl.qdl.mzz;
import com.bytedance.sdk.component.ud.qdl.qdl.qdl.to;
import com.bytedance.sdk.component.ud.qdl.rdp;
import com.bytedance.sdk.component.wd.qdl;
import com.bytedance.sdk.openadsdk.core.bch;
import com.bytedance.sdk.openadsdk.core.model.jl;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.settings.rq;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.jl.qdl.lnr;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.fco;
import com.pgl.ssdk.ces.out.PglSSConfig;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ud {
    private static volatile ud qdl;
    private lnr lnr;
    private final Map<String, JSONObject> mml = new HashMap();
    private final com.bytedance.sdk.component.wd.qdl ud;

    public int qdl() {
        try {
            return com.bytedance.sdk.openadsdk.jyq.qdl.qdl("net_time_out", 10000);
        } catch (Throwable unused) {
            return 10000;
        }
    }

    public static ud ud() {
        if (qdl == null) {
            synchronized (ud.class) {
                if (qdl == null) {
                    qdl = new ud(yt.qdl());
                }
            }
        }
        return qdl;
    }

    private ud(Context context) {
        long jQdl = qdl();
        com.bytedance.sdk.component.wd.qdl qdlVarQdl = new qdl.C0217qdl().qdl(jQdl, TimeUnit.MILLISECONDS).ud(jQdl, TimeUnit.MILLISECONDS).lnr(jQdl, TimeUnit.MILLISECONDS).qdl(new qdl()).qdl(true).qdl();
        this.ud = qdlVarQdl;
        com.bytedance.sdk.component.ud.qdl.qdl.qdl.qdl.qdl(new to() { // from class: com.bytedance.sdk.openadsdk.jl.ud.1
            @Override // com.bytedance.sdk.component.ud.qdl.qdl.qdl.to
            public ExecutorService qdl() {
                if (rq.lnr().zvv()) {
                    return fco.rq();
                }
                return null;
            }

            @Override // com.bytedance.sdk.component.ud.qdl.qdl.qdl.to
            public boolean ud() {
                return rq.lnr().zvv();
            }
        });
        com.bytedance.sdk.component.wd.qdl.qdl(new mzz() { // from class: com.bytedance.sdk.openadsdk.jl.ud.2
            @Override // com.bytedance.sdk.component.ud.qdl.qdl.qdl.mzz
            public boolean qdl() {
                return com.bytedance.sdk.openadsdk.jyq.qdl.qdl("net_http_protocol", 0) == 1;
            }
        });
        mml mmlVarQdl = qdlVarQdl.mo().qdl();
        if (mmlVarQdl != null) {
            mmlVarQdl.qdl(32);
        }
    }

    public class qdl implements jpc {
        public qdl() {
        }

        @Override // com.bytedance.sdk.component.ud.qdl.jpc
        public rdp qdl(jpc.qdl qdlVar) throws IOException {
            JSONObject jSONObjectQdl;
            fs fsVarQdl = qdlVar.qdl();
            if (fsVarQdl.ud() != null && !fsVarQdl.ud().mml().isEmpty()) {
                List<String> listMml = fsVarQdl.ud().mml();
                StringBuilder sb = new StringBuilder();
                for (String str : listMml) {
                    sb.append(DomExceptionUtils.SEPARATOR);
                    sb.append(str);
                }
                String string = sb.toString();
                if (!TextUtils.isEmpty(string) && string.equals("/monitor/collect/c/session")) {
                    return qdlVar.qdl(fsVarQdl);
                }
            }
            fs.qdl qdlVarTvp = fsVarQdl.tvp();
            String strUd = com.bytedance.sdk.openadsdk.multipro.mml.mml.ud("ttopenadsdk", PglSSConfig.CUSTOMINFO_KEY_IPV6, "");
            if (!TextUtils.isEmpty(strUd) && (jSONObjectQdl = ud.this.qdl(strUd)) != null) {
                qdlVarTvp.ud("transfer-param", jSONObjectQdl.optString("message"));
                if (jSONObjectQdl.optInt("cypher") == 4) {
                    qdlVarTvp.ud("cypher", "4");
                } else {
                    qdlVarTvp.ud("cypher", ExifInterface.GPS_MEASUREMENT_3D);
                }
            }
            try {
                qdlVarTvp.ud("x-pangle-target-idc", rq.lnr().ca());
            } catch (Throwable unused) {
            }
            return qdlVar.qdl(qdlVarTvp.ud());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject qdl(String str) {
        JSONObject jSONObject = this.mml.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("ipv6", str);
        } catch (JSONException unused) {
        }
        JSONObject jSONObjectEncryptType4 = PangleEncryptManager.encryptType4(jSONObject2, new bch(PangleEncryptConstant.CryptDataScene.UNKNOWN));
        this.mml.put(str, jSONObjectEncryptType4);
        return jSONObjectEncryptType4;
    }

    public com.bytedance.sdk.component.wd.qdl lnr() {
        return this.ud;
    }

    public lnr mml() {
        mzz();
        return this.lnr;
    }

    public void qdl(String str, int i, int i2, ImageView imageView, ljh ljhVar) {
        com.bytedance.sdk.openadsdk.tvp.mml.qdl(str).qdl(i).ud(i2).mzz(ax.mzz(yt.qdl())).mml(ax.lnr(yt.qdl())).lnr(1).qdl(com.bytedance.sdk.openadsdk.tvp.lnr.qdl(ljhVar, str, imageView));
    }

    public void qdl(int i, final ImageView imageView, final ljh ljhVar) {
        if (ljhVar == null || !TextUtils.isEmpty(ljhVar.yt())) {
            com.bytedance.sdk.openadsdk.tvp.mml.qdl(ljhVar.yt()).qdl(i).ud(i).mzz(ax.mzz(yt.qdl())).mml(ax.lnr(yt.qdl())).lnr(1).qdl(com.bytedance.sdk.openadsdk.tvp.lnr.qdl(ljhVar, ljhVar.yt(), imageView));
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.jl.ud.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (imageView.getDrawable() != null) {
                            Intent intent = new Intent();
                            String strJl = ljhVar.jl();
                            intent.setAction("android.intent.action.VIEW");
                            intent.setData(Uri.parse(strJl));
                            try {
                                com.bytedance.sdk.component.utils.ud.qdl(yt.qdl(), intent, null);
                            } catch (Exception unused) {
                            }
                        }
                    }
                });
            }
        }
    }

    public void qdl(jl jlVar, ImageView imageView, ljh ljhVar) {
        if (jlVar == null || TextUtils.isEmpty(jlVar.qdl()) || imageView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.tvp.mml.qdl(jlVar).lnr(1).qdl(com.bytedance.sdk.openadsdk.tvp.lnr.qdl(ljhVar, jlVar.qdl(), imageView));
    }

    public void qdl(jl jlVar, ImageView imageView, ljh ljhVar, jtx jtxVar) {
        if (jlVar == null || TextUtils.isEmpty(jlVar.qdl()) || imageView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.tvp.mml.qdl(jlVar).lnr(1).qdl(com.bytedance.sdk.openadsdk.tvp.lnr.qdl(ljhVar, jlVar.qdl(), imageView, jtxVar));
    }

    public void qdl(String str, View view) {
        if (view == null || TextUtils.isEmpty(str)) {
            return;
        }
        final WeakReference weakReference = new WeakReference(view);
        com.bytedance.sdk.openadsdk.tvp.mml.qdl(str).lnr(2).qdl(new com.bytedance.sdk.component.mzz.jpc() { // from class: com.bytedance.sdk.openadsdk.jl.ud.5
            @Override // com.bytedance.sdk.component.mzz.jpc
            public Bitmap qdl(Bitmap bitmap) {
                View view2 = (View) weakReference.get();
                if (view2 == null) {
                    return null;
                }
                return com.bytedance.sdk.component.adexpress.mml.qdl.qdl(view2.getContext(), bitmap, 10);
            }
        }).qdl(new jtx() { // from class: com.bytedance.sdk.openadsdk.jl.ud.4
            @Override // com.bytedance.sdk.component.mzz.jtx
            public void qdl(int i, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.mzz.jtx
            public void qdl(com.bytedance.sdk.component.mzz.rq rqVar) {
                final View view2;
                if (rqVar == null) {
                    return;
                }
                final Object objUd = rqVar.ud();
                if (!(objUd instanceof Bitmap) || (view2 = (View) weakReference.get()) == null) {
                    return;
                }
                if (fco.mo()) {
                    if (view2 instanceof ImageView) {
                        ((ImageView) view2).setImageDrawable(new BitmapDrawable(view2.getResources(), (Bitmap) objUd));
                        return;
                    } else {
                        view2.setBackground(new BitmapDrawable(view2.getResources(), (Bitmap) objUd));
                        return;
                    }
                }
                view2.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.jl.ud.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        View view3 = view2;
                        if (view3 instanceof ImageView) {
                            ((ImageView) view3).setImageDrawable(new BitmapDrawable(view2.getResources(), (Bitmap) objUd));
                        } else {
                            view3.setBackground(new BitmapDrawable(view2.getResources(), (Bitmap) objUd));
                        }
                    }
                });
            }
        });
    }

    private void mzz() {
        if (this.lnr == null) {
            this.lnr = new lnr();
        }
    }
}
