package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public class uw extends mo {
    public uw(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar) {
        super(context, dynamicRootView, jpcVar);
        this.jpc += 6;
        if (this.fs.gy()) {
            this.bjy = new com.bytedance.sdk.component.adexpress.mo.qdl(context, this.fs.wd(), this.fs.mzz(), 1, this.fs.jpc());
            ((com.bytedance.sdk.component.adexpress.mo.qdl) this.bjy).setMaxLines(1);
        } else {
            this.bjy = new TextView(context);
            ((TextView) this.bjy).setIncludeFontPadding(false);
        }
        this.bjy.setTag(Integer.valueOf(getClickArea()));
        addView(this.bjy, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mo, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.hkc
    public boolean tvp() {
        int i;
        double d;
        super.tvp();
        if (TextUtils.isEmpty(getText())) {
            this.bjy.setVisibility(4);
            return true;
        }
        if (this.fs.gy()) {
            rq();
            return true;
        }
        ((TextView) this.bjy).setText(this.fs.mo());
        ((TextView) this.bjy).setTextDirection(5);
        this.bjy.setTextAlignment(this.fs.jpc());
        ((TextView) this.bjy).setTextColor(this.fs.wd());
        ((TextView) this.bjy).setTextSize(this.fs.mzz());
        if (!this.fs.oth()) {
            ((TextView) this.bjy).setMaxLines(1);
            ((TextView) this.bjy).setGravity(17);
            ((TextView) this.bjy).setEllipsize(TextUtils.TruncateAt.END);
        } else {
            int iLjh = this.fs.ljh();
            if (iLjh > 0) {
                ((TextView) this.bjy).setLines(iLjh);
                ((TextView) this.bjy).setEllipsize(TextUtils.TruncateAt.END);
            }
        }
        if (this.exu != null && this.exu.to() != null) {
            if (com.bytedance.sdk.component.adexpress.mml.ud() && qdl() && (TextUtils.equals(this.exu.to().ud(), "text_star") || TextUtils.equals(this.exu.to().ud(), "score-count") || TextUtils.equals(this.exu.to().ud(), "score-count-type-1") || TextUtils.equals(this.exu.to().ud(), "score-count-type-2"))) {
                setVisibility(8);
                return true;
            }
            if (TextUtils.equals(this.exu.to().ud(), "score-count") || TextUtils.equals(this.exu.to().ud(), "score-count-type-2")) {
                try {
                    try {
                        i = Integer.parseInt(getText());
                    } catch (Exception unused) {
                    }
                } catch (NumberFormatException unused2) {
                    i = -1;
                }
                if (i < 0) {
                    if (com.bytedance.sdk.component.adexpress.mml.ud()) {
                        setVisibility(8);
                        return true;
                    }
                    this.bjy.setVisibility(0);
                }
                if (TextUtils.equals(this.exu.to().ud(), "score-count-type-2")) {
                    ((TextView) this.bjy).setText(String.format(new DecimalFormat("(###,###,###)").format(i), Integer.valueOf(i)));
                    ((TextView) this.bjy).setGravity(17);
                    return true;
                }
                qdl((TextView) this.bjy, i, getContext(), "tt_comment_num");
            } else if (TextUtils.equals(this.exu.to().ud(), "text_star")) {
                try {
                    d = Double.parseDouble(getText());
                } catch (Exception unused3) {
                    d = -1.0d;
                }
                if (d < 0.0d || d > 5.0d) {
                    if (com.bytedance.sdk.component.adexpress.mml.ud()) {
                        setVisibility(8);
                        return true;
                    }
                    this.bjy.setVisibility(0);
                }
                ((TextView) this.bjy).setIncludeFontPadding(false);
                ((TextView) this.bjy).setText(String.format("%.1f", Double.valueOf(d)));
            } else if (TextUtils.equals("privacy-detail", this.exu.to().ud())) {
                ((TextView) this.bjy).setText("Permission list | Privacy policy");
            } else if (TextUtils.equals(this.exu.to().ud(), "development-name")) {
                ((TextView) this.bjy).setText(com.bytedance.sdk.component.utils.ljh.qdl(com.bytedance.sdk.component.adexpress.mml.qdl(), "tt_text_privacy_development") + getText());
            } else if (TextUtils.equals(this.exu.to().ud(), "app-version")) {
                ((TextView) this.bjy).setText(com.bytedance.sdk.component.utils.ljh.qdl(com.bytedance.sdk.component.adexpress.mml.qdl(), "tt_text_privacy_app_version") + getText());
            } else {
                ((TextView) this.bjy).setText(getText());
            }
            this.bjy.setTextAlignment(this.fs.jpc());
            ((TextView) this.bjy).setGravity(this.fs.tvp());
            if (com.bytedance.sdk.component.adexpress.mml.ud()) {
                to();
            }
        }
        return true;
    }

    private boolean qdl() {
        return (this.rdp == null || this.rdp.getRenderRequest() == null || this.rdp.getRenderRequest().to() == 4) ? false : true;
    }

    private void to() {
        int iQdl;
        if (TextUtils.equals(this.exu.to().ud(), "source") || TextUtils.equals(this.exu.to().ud(), "title") || TextUtils.equals(this.exu.to().ud(), "text_star")) {
            int[] iArrUd = com.bytedance.sdk.component.adexpress.dynamic.mzz.rq.ud(this.fs.mo(), this.fs.mzz(), true);
            int iQdl2 = (int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(getContext(), this.fs.ud());
            int iQdl3 = (int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(getContext(), this.fs.lnr());
            int iQdl4 = (int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(getContext(), this.fs.mml());
            int iQdl5 = (int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(getContext(), this.fs.qdl());
            int iMin = Math.min(iQdl2, iQdl5);
            if (TextUtils.equals(this.exu.to().ud(), "source") && (iQdl = ((this.jpc - ((int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(getContext(), this.fs.mzz()))) - iQdl2) - iQdl5) > 1 && iQdl <= iMin * 2) {
                int i = iQdl / 2;
                this.bjy.setPadding(iQdl3, iQdl2 - i, iQdl4, iQdl5 - (iQdl - i));
                return;
            }
            int i2 = (((iArrUd[1] + iQdl2) + iQdl5) - this.jpc) - 2;
            if (i2 <= 1) {
                return;
            }
            if (i2 <= iMin * 2) {
                int i3 = i2 / 2;
                this.bjy.setPadding(iQdl3, iQdl2 - i3, iQdl4, iQdl5 - (i2 - i3));
            } else if (i2 > iQdl2 + iQdl5) {
                final int i4 = (i2 - iQdl2) - iQdl5;
                this.bjy.setPadding(iQdl3, 0, iQdl4, 0);
                if (i4 <= ((int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(getContext(), 1.0f)) + 1) {
                    ((TextView) this.bjy).setTextSize(this.fs.mzz() - 1.0f);
                } else if (i4 <= (((int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(getContext(), 1.0f)) + 1) * 2) {
                    ((TextView) this.bjy).setTextSize(this.fs.mzz() - 2.0f);
                } else {
                    post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.uw.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ViewGroup.LayoutParams layoutParams = uw.this.bjy.getLayoutParams();
                                layoutParams.height = uw.this.jpc + i4;
                                uw.this.bjy.setLayoutParams(layoutParams);
                                uw.this.bjy.setTranslationY(-i4);
                                ViewGroup viewGroup = (ViewGroup) uw.this.bjy.getParent();
                                viewGroup.setClipChildren(false);
                                ViewGroup viewGroup2 = (ViewGroup) uw.this.bjy.getParent().getParent();
                                viewGroup2.setClipChildren(false);
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } else if (iQdl2 > iQdl5) {
                this.bjy.setPadding(iQdl3, iQdl2 - (i2 - iMin), iQdl4, iQdl5 - iMin);
            } else {
                this.bjy.setPadding(iQdl3, iQdl2 - iMin, iQdl4, iQdl5 - (i2 - iMin));
            }
        }
        if (TextUtils.equals(this.exu.to().ud(), "fillButton")) {
            this.bjy.setTextAlignment(2);
            ((TextView) this.bjy).setGravity(17);
        }
    }

    public String getText() {
        String strMo = this.fs.mo();
        if (TextUtils.isEmpty(strMo)) {
            if (!com.bytedance.sdk.component.adexpress.mml.ud() && TextUtils.equals(this.exu.to().ud(), "text_star")) {
                strMo = "5";
            }
            if (!com.bytedance.sdk.component.adexpress.mml.ud() && TextUtils.equals(this.exu.to().ud(), "score-count")) {
                strMo = "6870";
            }
        }
        return (TextUtils.equals(this.exu.to().ud(), "title") || TextUtils.equals(this.exu.to().ud(), "subtitle")) ? strMo.replace("\n", "") : strMo;
    }

    public void qdl(TextView textView, int i, Context context, String str) {
        textView.setText("(" + String.format(com.bytedance.sdk.component.utils.ljh.qdl(context, str), Integer.valueOf(i)) + ")");
        if (i == -1) {
            textView.setVisibility(8);
        }
    }

    private void rq() {
        if (this.bjy instanceof com.bytedance.sdk.component.adexpress.mo.qdl) {
            String text = getText();
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(text);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.optString(i));
                }
            } catch (JSONException unused) {
                arrayList.add(text);
            }
            ((com.bytedance.sdk.component.adexpress.mo.qdl) this.bjy).setMaxLines(1);
            ((com.bytedance.sdk.component.adexpress.mo.qdl) this.bjy).setTextColor(this.fs.wd());
            ((com.bytedance.sdk.component.adexpress.mo.qdl) this.bjy).setTextSize(this.fs.mzz());
            ((com.bytedance.sdk.component.adexpress.mo.qdl) this.bjy).setAnimationText(arrayList);
            ((com.bytedance.sdk.component.adexpress.mo.qdl) this.bjy).setAnimationType(this.fs.ag());
            ((com.bytedance.sdk.component.adexpress.mo.qdl) this.bjy).setAnimationDuration(this.fs.ax() * 1000);
            ((com.bytedance.sdk.component.adexpress.mo.qdl) this.bjy).qdl();
        }
    }
}
