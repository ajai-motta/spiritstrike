package com.bytedance.adsdk.ud.lnr.lnr;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.adsdk.ud.aaj;
import com.bytedance.adsdk.ud.to;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class lnr extends mml {
    private String fs;
    private LinearLayout jpc;
    private final List<TextView> rq;
    private final List<String> to;
    private final LinearLayout.LayoutParams tvp;

    public lnr(com.bytedance.adsdk.ud.tvp tvpVar, mzz mzzVar, Context context) {
        List<to.qdl> listLnr;
        super(tvpVar, mzzVar);
        this.tvp = new LinearLayout.LayoutParams(-2, -2);
        this.to = new ArrayList();
        this.rq = new ArrayList();
        if (this.wd == null || (listLnr = this.wd.lnr()) == null || listLnr.size() <= 0) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.jpc = linearLayout;
        int i = 0;
        linearLayout.setOrientation(0);
        ud(listLnr.get(0).wd);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(80);
        this.jpc.addView(linearLayout2);
        List<String> listFs = fs();
        while (i < listLnr.size()) {
            to.qdl qdlVar = listLnr.get(i);
            TextView textView = new TextView(context);
            qdl(textView, qdlVar, (listFs == null || i >= listFs.size()) ? "" : listFs.get(i));
            if (qdlVar.mo != 0) {
                this.tvp.bottomMargin = (int) (qdlVar.mo * com.bytedance.adsdk.ud.mo.mo.qdl());
                linearLayout2.addView(textView, this.tvp);
            } else {
                linearLayout2.addView(textView);
            }
            i++;
        }
        float fQdl = com.bytedance.adsdk.ud.mo.mo.qdl();
        qdl(this.jpc, (int) (this.wd.qdl() * fQdl), (int) (this.wd.ud() * fQdl));
    }

    private void ud(String str) {
        if (TextUtils.isEmpty(str)) {
            this.jpc.setGravity(17);
            return;
        }
        str.hashCode();
        if (str.equals("left")) {
            this.jpc.setGravity(3);
        } else if (str.equals(TtmlNode.RIGHT)) {
            this.jpc.setGravity(5);
        } else {
            this.jpc.setGravity(17);
        }
    }

    private void qdl(TextView textView, to.qdl qdlVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            textView.setText("");
        }
        if (!TextUtils.isEmpty(qdlVar.lnr)) {
            textView.setTextColor(Color.parseColor(qdlVar.lnr));
        }
        if (!TextUtils.isEmpty(qdlVar.mml)) {
            textView.setBackgroundColor(Color.parseColor(qdlVar.mml));
        }
        textView.setGravity(17);
        textView.setTextSize(qdlVar.mzz);
    }

    @Override // com.bytedance.adsdk.ud.lnr.lnr.mml, com.bytedance.adsdk.ud.lnr.lnr.qdl
    public void ud(Canvas canvas, Matrix matrix, int i) {
        if (this.jpc != null) {
            canvas.save();
            canvas.concat(matrix);
            qdl(i);
            lnr(mo());
            this.jpc.draw(canvas);
            canvas.restore();
            return;
        }
        super.ud(canvas, matrix, i);
    }

    private void lnr(float f) {
        List<to.qdl> listLnr;
        if (this.wd == null || (listLnr = this.wd.lnr()) == null || listLnr.size() <= 0) {
            return;
        }
        this.jpc.setOrientation(0);
        this.jpc.setGravity(17);
        if (this.jpc.getChildCount() <= 0) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) this.jpc.getChildAt(0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(80);
        this.jpc.removeAllViews();
        if (linearLayout.getChildCount() != listLnr.size()) {
            return;
        }
        List<String> listFs = fs();
        this.rq.clear();
        int i = 0;
        while (i < listLnr.size()) {
            to.qdl qdlVar = listLnr.get(i);
            TextView textView = (TextView) linearLayout.getChildAt(i);
            this.rq.add(textView);
            qdl(textView, qdlVar, (listFs == null || i >= listFs.size()) ? "" : listFs.get(i));
            i++;
        }
        linearLayout.removeAllViews();
        for (int i2 = 0; i2 < listLnr.size(); i2++) {
            to.qdl qdlVar2 = listLnr.get(i2);
            TextView textView2 = this.rq.get(i2);
            textView2.setAlpha(f);
            linearLayout.setAlpha(f);
            if (qdlVar2.mo != 0) {
                this.tvp.bottomMargin = (int) (qdlVar2.mo * com.bytedance.adsdk.ud.mo.mo.qdl());
                linearLayout.addView(textView2, this.tvp);
            } else {
                linearLayout.addView(textView2);
            }
        }
        this.jpc.setAlpha(f);
        this.jpc.addView(linearLayout);
        float fQdl = com.bytedance.adsdk.ud.mo.mo.qdl();
        qdl(this.jpc, (int) (this.wd.qdl() * fQdl), (int) (this.wd.ud() * fQdl));
    }

    private List<String> fs() {
        aaj aajVarBch;
        List<to.qdl> listLnr;
        if (this.wd == null || this.ud == null || (aajVarBch = this.ud.bch()) == null) {
            return null;
        }
        String strMml = this.wd.mml();
        if ((!TextUtils.isEmpty(strMml) || !TextUtils.isEmpty(this.fs)) && (listLnr = this.wd.lnr()) != null) {
            String strQdl = this.fs;
            if (TextUtils.isEmpty(strQdl)) {
                strQdl = aajVarBch.qdl(strMml);
            }
            if (!TextUtils.isEmpty(strQdl)) {
                int length = strQdl.length();
                this.to.clear();
                for (int i = 0; i < listLnr.size(); i++) {
                    to.qdl qdlVar = listLnr.get(i);
                    int iMax = qdlVar.qdl;
                    int iMax2 = qdlVar.ud;
                    if (iMax < 0) {
                        iMax = Math.max(iMax + length, 0);
                    }
                    if (iMax2 < 0) {
                        iMax2 = Math.max(iMax2 + length, 0);
                    }
                    if (iMax + iMax2 > length) {
                        this.to.add("");
                    } else {
                        if (listLnr.size() == 1 && iMax == 0 && iMax2 == 0) {
                            iMax2 = length;
                        }
                        this.to.add(strQdl.substring(iMax, iMax2 + iMax));
                    }
                }
                return this.to;
            }
        }
        return null;
    }

    private static void qdl(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void qdl(String str) {
        this.fs = str;
    }
}
