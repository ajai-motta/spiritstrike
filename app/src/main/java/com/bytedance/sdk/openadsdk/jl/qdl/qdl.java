package com.bytedance.sdk.openadsdk.jl.qdl;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.mzz.jpc;
import com.bytedance.sdk.component.mzz.jtx;
import com.bytedance.sdk.component.mzz.rq;
import com.bytedance.sdk.component.mzz.to;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.tvp.mml;
import com.bytedance.sdk.openadsdk.utils.ax;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.jl.qdl.qdl$qdl, reason: collision with other inner class name */
    public interface InterfaceC0261qdl {
        void qdl(int i, String str, Throwable th);

        void qdl(String str, ud udVar);
    }

    public void qdl(com.bytedance.sdk.openadsdk.jl.qdl qdlVar, final InterfaceC0261qdl interfaceC0261qdl, int i, int i2, ImageView.ScaleType scaleType, String str, final int i3, ljh ljhVar) {
        to toVarQdl = mml.qdl(qdlVar.qdl).qdl(qdlVar.ud).qdl(i).ud(i2).mzz(ax.mzz(yt.qdl())).mml(ax.lnr(yt.qdl())).ud(str).qdl(scaleType).qdl(!TextUtils.isEmpty(str));
        if (i3 > 0 && Build.VERSION.SDK_INT >= 26) {
            toVarQdl.lnr(2).qdl(new jpc() { // from class: com.bytedance.sdk.openadsdk.jl.qdl.qdl.1
                @Override // com.bytedance.sdk.component.mzz.jpc
                public Bitmap qdl(Bitmap bitmap) {
                    return com.bytedance.sdk.component.adexpress.mml.qdl.qdl(yt.qdl(), bitmap, i3);
                }
            });
        } else {
            toVarQdl.lnr(1);
        }
        toVarQdl.qdl(new com.bytedance.sdk.openadsdk.tvp.ud(ljhVar, qdlVar.qdl, new jtx() { // from class: com.bytedance.sdk.openadsdk.jl.qdl.qdl.2
            @Override // com.bytedance.sdk.component.mzz.jtx
            public void qdl(rq rqVar) {
                qdl.this.qdl(rqVar, interfaceC0261qdl);
            }

            @Override // com.bytedance.sdk.component.mzz.jtx
            public void qdl(int i4, String str2, Throwable th) {
                qdl.this.qdl(i4, str2, th, interfaceC0261qdl);
            }
        }));
    }

    protected void qdl(rq rqVar, InterfaceC0261qdl interfaceC0261qdl) {
        if (interfaceC0261qdl != null) {
            Object objUd = rqVar.ud();
            int iQdl = qdl(rqVar);
            if (objUd instanceof Drawable) {
                interfaceC0261qdl.qdl(rqVar.qdl(), new ud((Drawable) objUd, iQdl));
                return;
            }
            if (objUd instanceof byte[]) {
                interfaceC0261qdl.qdl(rqVar.qdl(), new ud((byte[]) objUd, iQdl));
                return;
            }
            if (objUd instanceof Bitmap) {
                interfaceC0261qdl.qdl(rqVar.qdl(), new ud((Bitmap) objUd, rqVar.lnr() instanceof Bitmap ? (Bitmap) rqVar.lnr() : null, iQdl));
            } else {
                interfaceC0261qdl.qdl(0, "not bitmap or gif result!", null);
            }
        }
    }

    private int qdl(rq rqVar) {
        Object obj;
        Map<String, String> mapMml = rqVar.mml();
        if (mapMml == null || (obj = mapMml.get("image_size")) == null || !(obj instanceof Integer)) {
            return 0;
        }
        return ((Integer) obj).intValue();
    }

    protected void qdl(int i, String str, Throwable th, InterfaceC0261qdl interfaceC0261qdl) {
        if (interfaceC0261qdl != null) {
            interfaceC0261qdl.qdl(i, str, th);
        }
    }
}
