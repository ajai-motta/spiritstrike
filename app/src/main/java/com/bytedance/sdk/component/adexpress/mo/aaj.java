package com.bytedance.sdk.component.adexpress.mo;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class aaj extends exc {
    private TextView qdl;

    public aaj(Context context, View view, int i, int i2, int i3, JSONObject jSONObject) {
        super(context, view, i, i2, i3, jSONObject);
    }

    @Override // com.bytedance.sdk.component.adexpress.mo.exc
    protected void qdl(Context context, View view) {
        addView(view);
        this.qdl = (TextView) findViewById(2097610747);
    }

    @Override // com.bytedance.sdk.component.adexpress.mo.exc
    public void setShakeText(String str) {
        if (this.qdl == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            try {
                this.qdl.setText(com.bytedance.sdk.component.utils.ljh.ud(this.qdl.getContext(), "tt_splash_default_click_shake"));
                return;
            } catch (Exception e) {
                e.getMessage();
                return;
            }
        }
        this.qdl.setText(str);
    }
}
