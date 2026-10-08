package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mo extends mzz {
    private static String aaj = "";
    protected com.bytedance.sdk.component.adexpress.dynamic.lnr.tvp exc;
    private volatile boolean jyq;
    private Runnable qdl;
    private Runnable ud;

    public mo(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar) {
        super(context, dynamicRootView, jpcVar);
        this.jyq = true;
        setTag(Integer.valueOf(getClickArea()));
        String strUd = jpcVar.to().ud();
        if ("logo-union".equals(strUd)) {
            dynamicRootView.setLogoUnionHeight(this.jpc - ((int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(context, this.fs.ud() + this.fs.qdl())));
        } else if ("scoreCountWithIcon".equals(strUd)) {
            dynamicRootView.setScoreCountWithIcon(this.jpc - ((int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(context, this.fs.ud() + this.fs.qdl())));
        }
    }

    private String ud(String str) {
        try {
            Map<String, String> mapRq = this.rdp.getRenderRequest().rq();
            if (mapRq != null && mapRq.size() > 0) {
                return mapRq.get(str);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.wd, this.jpc);
    }

    public boolean tvp() {
        int iBjy;
        int iJtx;
        Drawable backgroundDrawable;
        JSONObject jSONObjectOptJSONObject;
        final View view = this.bjy == null ? this : this.bjy;
        setContentDescription(this.exu.qdl(this.fs.bqt()));
        String strLq = this.fs.lq();
        String strBch = null;
        String strQdl = (TextUtils.isEmpty(strLq) || this.rdp == null || this.rdp.getRenderRequest() == null || this.rdp.getRenderRequest().lnr() == null || (jSONObjectOptJSONObject = this.rdp.getRenderRequest().lnr().optJSONObject("creative")) == null) ? null : qdl(jSONObjectOptJSONObject.opt(strLq));
        if (TextUtils.isEmpty(strQdl)) {
            strQdl = this.fs.jyq();
        }
        com.bytedance.sdk.component.adexpress.qdl.qdl.lnr lnrVarLnr = com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().lnr();
        if (lnrVarLnr != null) {
            iBjy = lnrVarLnr.bjy();
            iJtx = lnrVarLnr.jtx();
        } else {
            iBjy = 0;
            iJtx = 0;
        }
        if (this.fs.aaj()) {
            int iExc = this.fs.exc();
            String str = this.fs.ud;
            com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().mzz().qdl(str).qdl(this.wd).ud(this.jpc).mml(iBjy).mzz(iJtx).qdl(ud(str)).lnr(2).qdl(new lnr(this.rq, iExc)).qdl(new ud(view, this));
        } else if (!TextUtils.isEmpty(strQdl)) {
            if (!strQdl.startsWith("http:") && !strQdl.startsWith("https:")) {
                if (this.rdp != null && this.rdp.getRenderRequest() != null) {
                    strBch = this.rdp.getRenderRequest().bch();
                }
                strQdl = com.bytedance.sdk.component.adexpress.dynamic.mzz.tvp.ud(strQdl, strBch);
            }
            com.bytedance.sdk.component.mzz.to toVarLnr = com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().mzz().qdl(strQdl).qdl(this.wd).ud(this.jpc).mml(iBjy).mzz(iJtx).qdl(ud(strQdl)).lnr(1);
            qdl(toVarLnr);
            toVarLnr.qdl(new qdl(view, this.rdp, this.exu));
        }
        if (getBackground() == null && (backgroundDrawable = getBackgroundDrawable()) != null) {
            view.setBackground(backgroundDrawable);
        }
        if (this.fs.vu() > 0.0d) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mo.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (mo.this.fs.hzv() > 0) {
                            mo moVar = mo.this;
                            Drawable drawableLnr = moVar.lnr(moVar.rdp.getBgMaterialCenterCalcColor().get(Integer.valueOf(mo.this.fs.hzv())));
                            if (drawableLnr == null) {
                                mo moVar2 = mo.this;
                                drawableLnr = moVar2.qdl(true, moVar2.rdp.getBgMaterialCenterCalcColor().get(Integer.valueOf(mo.this.fs.hzv())));
                            }
                            if (drawableLnr != null) {
                                view.setBackground(drawableLnr);
                                return;
                            }
                            View view2 = view;
                            mo moVar3 = mo.this;
                            view2.setBackground(moVar3.qdl(true, moVar3.rdp.getBgColor()));
                        }
                    } catch (Exception unused) {
                    }
                }
            }, (long) (this.fs.vu() * 1000.0d));
        }
        if (this.bjy != null) {
            this.bjy.setPadding((int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(this.rq, this.fs.lnr()), (int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(this.rq, this.fs.ud()), (int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(this.rq, this.fs.mml()), (int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(this.rq, this.fs.qdl()));
        }
        if (this.jtx || this.fs.rdp() > 0.0d) {
            setShouldInvisible(true);
            view.setVisibility(4);
            setVisibility(4);
        }
        return true;
    }

    private static class lnr implements com.bytedance.sdk.component.mzz.jpc {
        private final WeakReference<Context> qdl;
        private final int ud;

        public lnr(Context context, int i) {
            this.qdl = new WeakReference<>(context);
            this.ud = i;
        }

        @Override // com.bytedance.sdk.component.mzz.jpc
        public Bitmap qdl(Bitmap bitmap) {
            Context context = this.qdl.get();
            if (context != null) {
                return com.bytedance.sdk.component.adexpress.mml.qdl.qdl(context, bitmap, this.ud);
            }
            return null;
        }
    }

    private static class ud implements com.bytedance.sdk.component.mzz.jtx {
        private final WeakReference<View> qdl;
        private final WeakReference<mzz> ud;

        @Override // com.bytedance.sdk.component.mzz.jtx
        public void qdl(int i, String str, Throwable th) {
        }

        public ud(View view, mzz mzzVar) {
            this.qdl = new WeakReference<>(view);
            this.ud = new WeakReference<>(mzzVar);
        }

        @Override // com.bytedance.sdk.component.mzz.jtx
        public void qdl(com.bytedance.sdk.component.mzz.rq rqVar) {
            Object objUd;
            mzz mzzVar;
            View view = this.qdl.get();
            if (view == null || (objUd = rqVar.ud()) == null || rqVar.lnr() == null || (mzzVar = this.ud.get()) == null || !(objUd instanceof Bitmap)) {
                return;
            }
            view.setBackground(mzzVar.qdl((Bitmap) objUd));
        }
    }

    private static class qdl implements com.bytedance.sdk.component.mzz.jtx {
        private final com.bytedance.sdk.component.adexpress.dynamic.mml.jpc lnr;
        private final WeakReference<View> qdl;
        private final WeakReference<DynamicRootView> ud;

        @Override // com.bytedance.sdk.component.mzz.jtx
        public void qdl(int i, String str, Throwable th) {
        }

        public qdl(View view, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar) {
            this.qdl = new WeakReference<>(view);
            this.ud = new WeakReference<>(dynamicRootView);
            this.lnr = jpcVar;
        }

        @Override // com.bytedance.sdk.component.mzz.jtx
        public void qdl(com.bytedance.sdk.component.mzz.rq rqVar) {
            Drawable bitmapDrawable;
            View view = this.qdl.get();
            Object objUd = rqVar.ud();
            if (objUd instanceof Bitmap) {
                bitmapDrawable = new BitmapDrawable((Bitmap) objUd);
            } else if (objUd instanceof Drawable) {
                if (Build.VERSION.SDK_INT >= 28 && (objUd instanceof AnimatedImageDrawable)) {
                    ((AnimatedImageDrawable) objUd).start();
                }
                bitmapDrawable = (Drawable) objUd;
            } else {
                bitmapDrawable = null;
            }
            if (!com.bytedance.sdk.component.adexpress.mml.ud()) {
                DynamicRootView dynamicRootView = this.ud.get();
                if (dynamicRootView == null) {
                    return;
                }
                if (!"open_ad".equals(dynamicRootView.getRenderRequest().mml()) && !"splash_ad".equals(dynamicRootView.getRenderRequest().mml())) {
                    view.setBackground(bitmapDrawable);
                    return;
                } else {
                    view.setBackground(bitmapDrawable);
                    return;
                }
            }
            if (view == null) {
                return;
            }
            view.setBackground(bitmapDrawable);
            com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar = this.lnr;
            if (jpcVar == null || jpcVar.to() == null || 6 != this.lnr.to().qdl() || view.getBackground() == null) {
                return;
            }
            view.getBackground().setAutoMirrored(true);
        }
    }

    private String qdl(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof JSONArray) {
            return qdl(((JSONArray) obj).opt(0));
        }
        if (obj instanceof JSONObject) {
            return qdl((Object) ((JSONObject) obj).optString("url"));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable lnr(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            String string = "";
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.getString(i).startsWith("#")) {
                    arrayList.add(jSONArray.getString(i));
                } else if (jSONArray.getString(i).endsWith("deg")) {
                    string = jSONArray.getString(i);
                }
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = com.bytedance.sdk.component.adexpress.dynamic.mml.wd.qdl(((String) arrayList.get(i2)).substring(0, 7));
            }
            GradientDrawable gradientDrawableQdl = qdl(qdl(string), iArr);
            gradientDrawableQdl.setShape(0);
            gradientDrawableQdl.setCornerRadius(com.bytedance.sdk.component.adexpress.mml.wd.qdl(this.rq, this.fs.bjy()));
            return gradientDrawableQdl;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void qdl(com.bytedance.sdk.component.mzz.to toVar) {
        if ("SMARTISAN".equals(Build.BRAND) && "SM901".equals(getBuildModel())) {
            toVar.qdl(Bitmap.Config.ARGB_8888);
        }
    }

    private static String getBuildModel() {
        try {
            aaj = com.bytedance.sdk.component.utils.xmv.qdl();
        } catch (Throwable unused) {
            aaj = Build.MODEL;
        }
        if (TextUtils.isEmpty(aaj)) {
            aaj = Build.MODEL;
        }
        return aaj;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mzz, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        View view = this.bjy == null ? this : this.bjy;
        double dAaj = this.exu.to().mzz().aaj();
        if (dAaj < 90.0d && dAaj > 0.0d) {
            com.bytedance.sdk.component.utils.tvp.ud().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mo.2
                @Override // java.lang.Runnable
                public void run() {
                    mo.this.setVisibility(8);
                }
            }, (long) (dAaj * 1000.0d));
        }
        qdl(this.exu.to().mzz().exc(), view);
        if (!TextUtils.isEmpty(this.fs.wc())) {
            qdl();
        }
        super.onAttachedToWindow();
    }

    private void qdl(double d, final View view) {
        if (d > 0.0d) {
            com.bytedance.sdk.component.utils.tvp.ud().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mo.3
                @Override // java.lang.Runnable
                public void run() {
                    if (mo.this.exu.to().mzz().kr() != null) {
                        return;
                    }
                    view.setVisibility(0);
                    mo.this.setVisibility(0);
                }
            }, (long) (d * 1000.0d));
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mzz, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            removeCallbacks(this.qdl);
            removeCallbacks(this.ud);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (viewGroup.getChildAt(i) instanceof com.bytedance.sdk.component.adexpress.dynamic.lnr.tvp) {
                viewGroup.removeViewAt(i);
            }
        }
    }

    private void qdl() {
        if (this.jyq) {
            int iGt = this.fs.gt();
            int iIrn = this.fs.irn();
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mo.4
                @Override // java.lang.Runnable
                public void run() {
                    if (mo.this.rdp != null && mo.this.rdp.getRenderRequest() != null) {
                        com.bytedance.sdk.component.adexpress.ud.exu renderRequest = mo.this.rdp.getRenderRequest();
                        com.bytedance.sdk.component.adexpress.dynamic.mml.to toVar = new com.bytedance.sdk.component.adexpress.dynamic.mml.to();
                        toVar.qdl(renderRequest.bjy());
                        toVar.ud(renderRequest.jtx());
                        toVar.lnr(renderRequest.yt());
                        toVar.qdl(renderRequest.jl());
                        toVar.ud(renderRequest.exc());
                        toVar.lnr(renderRequest.aaj());
                        toVar.mml(renderRequest.jyq());
                        toVar.mzz(renderRequest.oth());
                        mo moVar = mo.this;
                        Context context = mo.this.rq;
                        mo moVar2 = mo.this;
                        moVar.exc = new com.bytedance.sdk.component.adexpress.dynamic.lnr.tvp(context, moVar2, moVar2.fs, toVar, renderRequest);
                    } else {
                        mo moVar3 = mo.this;
                        Context context2 = mo.this.rq;
                        mo moVar4 = mo.this;
                        moVar3.exc = new com.bytedance.sdk.component.adexpress.dynamic.lnr.tvp(context2, moVar4, moVar4.fs);
                    }
                    mo moVar5 = mo.this;
                    moVar5.ud(moVar5.exc);
                    if (mo.this.getParent() instanceof ViewGroup) {
                        ((ViewGroup) mo.this.getParent()).setClipChildren(false);
                    }
                    mo.this.setClipChildren(false);
                    mo.this.exc.setTag(2);
                    mo moVar6 = mo.this;
                    moVar6.qdl((ViewGroup) moVar6);
                    mo moVar7 = mo.this;
                    moVar7.addView(moVar7.exc, new FrameLayout.LayoutParams(-1, -1));
                    mo.this.exc.lnr();
                }
            };
            this.qdl = runnable;
            postDelayed(runnable, ((long) iGt) * 1000);
            if (this.fs.xi() || iIrn >= Integer.MAX_VALUE || iGt >= iIrn) {
                return;
            }
            Runnable runnable2 = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mo.5
                @Override // java.lang.Runnable
                public void run() {
                    if (mo.this.exc != null) {
                        mo.this.jyq = false;
                        mo.this.exc.mml();
                        mo.this.exc.setVisibility(4);
                        mo moVar = mo.this;
                        moVar.removeView(moVar.exc);
                    }
                }
            };
            this.ud = runnable2;
            postDelayed(runnable2, ((long) iIrn) * 1000);
        }
    }
}
