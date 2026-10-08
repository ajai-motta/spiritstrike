package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class rq extends mo {
    private String qdl;

    public rq(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar) {
        super(context, dynamicRootView, jpcVar);
        if (!TextUtils.isEmpty(this.fs.nz()) && jpcVar.exc()) {
            com.bytedance.sdk.component.adexpress.mo.to toVar = new com.bytedance.sdk.component.adexpress.mo.to(context);
            toVar.setAnimationsLoop(this.fs.kab());
            toVar.setImageLottieTosPath(this.fs.nz());
            toVar.setLottieAppNameMaxLength(this.fs.tqd());
            toVar.setLottieAdTitleMaxLength(this.fs.qk());
            toVar.setLottieAdDescMaxLength(this.fs.ra());
            toVar.setData(jpcVar.aaj());
            this.bjy = toVar;
        } else if (this.fs.bjy() > 0.0f) {
            this.bjy = new com.bytedance.sdk.component.adexpress.mo.uw(context);
            ((com.bytedance.sdk.component.adexpress.mo.uw) this.bjy).setXRound((int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(context, this.fs.bjy()));
            ((com.bytedance.sdk.component.adexpress.mo.uw) this.bjy).setYRound((int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(context, this.fs.bjy()));
        } else if (!jpc() && "arrowButton".equals(jpcVar.to().ud())) {
            com.bytedance.sdk.component.adexpress.dynamic.animation.view.ud udVar = new com.bytedance.sdk.component.adexpress.dynamic.animation.view.ud(context);
            udVar.setBrickNativeValue(this.fs);
            this.bjy = udVar;
        } else if (com.bytedance.sdk.component.adexpress.mml.tvp.ud(this.fs.rq())) {
            this.bjy = new com.bytedance.sdk.component.adexpress.mo.exu(context);
        } else {
            this.bjy = new ImageView(context);
        }
        this.qdl = getImageKey();
        this.bjy.setTag(Integer.valueOf(getClickArea()));
        if ("arrowButton".equals(jpcVar.to().ud())) {
            if (this.fs.ud() > 0 || this.fs.qdl() > 0) {
                this.wd = Math.min(this.wd, this.jpc);
                this.jpc = Math.min(this.wd, this.jpc);
                this.tvp = (int) (this.tvp + com.bytedance.sdk.component.adexpress.mml.wd.qdl(context, this.fs.ud() + (this.fs.qdl() / 2) + 0.5f));
            } else {
                this.wd = Math.max(this.wd, this.jpc);
                this.jpc = Math.max(this.wd, this.jpc);
            }
            this.fs.qdl(this.wd / 2);
        }
        addView(this.bjy, new FrameLayout.LayoutParams(this.wd, this.jpc));
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mo, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mzz, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = ((ImageView) this.bjy).getDrawable();
        if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
            return;
        }
        ((AnimatedImageDrawable) drawable).start();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mo, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mzz, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = ((ImageView) this.bjy).getDrawable();
        if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
            return;
        }
        ((AnimatedImageDrawable) drawable).stop();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mo, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.hkc
    public boolean tvp() {
        int iJtx;
        super.tvp();
        if (!TextUtils.isEmpty(this.fs.nz())) {
            ((ImageView) this.bjy).setScaleType(ImageView.ScaleType.CENTER_CROP);
            return true;
        }
        int iBjy = 0;
        if ("arrowButton".equals(this.exu.to().ud())) {
            ((ImageView) this.bjy).setImageResource(com.bytedance.sdk.component.utils.ljh.mml(this.rq, "tt_white_righterbackicon_titlebar"));
            if (((ImageView) this.bjy).getDrawable() != null) {
                ((ImageView) this.bjy).getDrawable().setAutoMirrored(true);
            }
            this.bjy.setPadding(0, 0, 0, 0);
            ((ImageView) this.bjy).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        this.bjy.setBackgroundColor(this.fs.koa());
        String strLnr = this.exu.to().lnr();
        if ("user".equals(strLnr)) {
            ((ImageView) this.bjy).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((ImageView) this.bjy).setColorFilter(this.fs.wd());
            ((ImageView) this.bjy).setImageDrawable(com.bytedance.sdk.component.utils.ljh.lnr(getContext(), "tt_user"));
            ((ImageView) this.bjy).setPadding(this.wd / 10, this.jpc / 5, this.wd / 10, 0);
        } else if (strLnr != null && strLnr.startsWith("@")) {
            try {
                ((ImageView) this.bjy).setImageResource(Integer.parseInt(strLnr.substring(1)));
            } catch (Exception unused) {
            }
        }
        com.bytedance.sdk.component.mzz.bjy bjyVarMzz = com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().mzz();
        String strRq = this.fs.rq();
        if (!TextUtils.isEmpty(strRq) && !strRq.startsWith("http:") && !strRq.startsWith("https:")) {
            strRq = com.bytedance.sdk.component.adexpress.dynamic.mzz.tvp.ud(strRq, (this.rdp == null || this.rdp.getRenderRequest() == null) ? null : this.rdp.getRenderRequest().bch());
        }
        com.bytedance.sdk.component.adexpress.qdl.qdl.lnr lnrVarLnr = com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().lnr();
        if (lnrVarLnr != null) {
            iBjy = lnrVarLnr.bjy();
            iJtx = lnrVarLnr.jtx();
        } else {
            iJtx = 0;
        }
        com.bytedance.sdk.component.mzz.to toVarMzz = bjyVarMzz.qdl(strRq).qdl(this.qdl).qdl(this.wd).ud(this.jpc).mml(iBjy).mzz(iJtx);
        String strRdp = this.rdp.getRenderRequest().rdp();
        if (!TextUtils.isEmpty(strRdp)) {
            toVarMzz.ud(strRdp);
        }
        if (qdl()) {
            ((ImageView) this.bjy).setScaleType(ImageView.ScaleType.FIT_CENTER);
            toVarMzz.qdl(Bitmap.Config.ARGB_4444).lnr(2).qdl(new qdl(this.rq)).qdl(new ud(this.bjy, getResources()));
        } else {
            if (com.bytedance.sdk.component.adexpress.mml.ud()) {
                toVarMzz.lnr(1).qdl((ImageView) this.bjy);
            }
            ((ImageView) this.bjy).setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if ((this.bjy instanceof ImageView) && "cover".equals(getImageObjectFit())) {
            ((ImageView) this.bjy).setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        return true;
    }

    private static class qdl implements com.bytedance.sdk.component.mzz.jpc {
        private final WeakReference<Context> qdl;

        public qdl(Context context) {
            this.qdl = new WeakReference<>(context);
        }

        @Override // com.bytedance.sdk.component.mzz.jpc
        public Bitmap qdl(Bitmap bitmap) {
            Context context = this.qdl.get();
            if (context != null) {
                return com.bytedance.sdk.component.adexpress.mml.qdl.qdl(context, bitmap, 25);
            }
            return null;
        }
    }

    private static class ud implements com.bytedance.sdk.component.mzz.jtx {
        private WeakReference<View> qdl;
        private Resources ud;

        @Override // com.bytedance.sdk.component.mzz.jtx
        public void qdl(int i, String str, Throwable th) {
        }

        public ud(View view, Resources resources) {
            this.qdl = new WeakReference<>(view);
            this.ud = resources;
        }

        @Override // com.bytedance.sdk.component.mzz.jtx
        public void qdl(com.bytedance.sdk.component.mzz.rq rqVar) {
            Object objUd;
            View view = this.qdl.get();
            if (view == null || (objUd = rqVar.ud()) == null || rqVar.lnr() == null) {
                return;
            }
            if (objUd instanceof Bitmap) {
                view.setBackground(new BitmapDrawable(this.ud, (Bitmap) objUd));
            } else if (objUd instanceof Drawable) {
                if (Build.VERSION.SDK_INT >= 28 && (objUd instanceof AnimatedImageDrawable)) {
                    ((AnimatedImageDrawable) objUd).start();
                }
                view.setBackground((Drawable) objUd);
            }
        }
    }

    private boolean qdl() {
        String strFs = this.fs.fs();
        if (this.fs.aaj()) {
            return true;
        }
        if (TextUtils.isEmpty(strFs)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strFs);
            return Math.abs((((float) this.wd) / (((float) this.jpc) * 1.0f)) - (((float) jSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)) / (((float) jSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) * 1.0f))) > 0.01f;
        } catch (JSONException unused) {
            return false;
        }
    }

    private String getImageKey() {
        Map<String, String> mapRq = this.rdp.getRenderRequest().rq();
        if (mapRq == null || mapRq.size() <= 0) {
            return null;
        }
        return mapRq.get(this.fs.rq());
    }
}
