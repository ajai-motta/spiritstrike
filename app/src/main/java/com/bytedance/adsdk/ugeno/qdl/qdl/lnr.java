package com.bytedance.adsdk.ugeno.qdl.qdl;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class lnr extends qdl {
    private Paint jpc;
    private String lnr;
    private float mml;
    private View mo;
    private float mzz;
    private Matrix rq;
    private LinearGradient to;
    private PorterDuffXfermode tvp;
    private Paint wd;

    public lnr(com.bytedance.adsdk.ugeno.ud.lnr lnrVar, JSONObject jSONObject) {
        super(lnrVar, jSONObject);
        this.mo = this.ud.rq();
        Paint paint = new Paint();
        this.wd = paint;
        paint.setAntiAlias(true);
        this.mo.setLayerType(2, null);
        this.tvp = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.jpc = new Paint();
        this.rq = new Matrix();
    }

    @Override // com.bytedance.adsdk.ugeno.qdl.qdl.qdl
    public void ud() {
        this.lnr = this.qdl.optString("direction", "left");
    }

    @Override // com.bytedance.adsdk.ugeno.qdl.qdl.qdl
    public void qdl(Canvas canvas) {
        lnr(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.qdl.qdl.qdl
    public void ud(Canvas canvas) {
        lnr(canvas);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void lnr(android.graphics.Canvas r18) {
        /*
            Method dump skipped, instruction units count: 504
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.qdl.qdl.lnr.lnr(android.graphics.Canvas):void");
    }

    @Override // com.bytedance.adsdk.ugeno.qdl.qdl.qdl
    public void qdl(int i, int i2) {
        this.mml = i;
        this.mzz = i2;
        String str = this.lnr;
        str.hashCode();
        switch (str) {
            case "bottom":
                this.to = new LinearGradient(0.0f, -this.mzz, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "top":
                this.to = new LinearGradient(0.0f, this.mzz, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "left":
                this.to = new LinearGradient(this.mml, 0.0f, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "right":
                this.to = new LinearGradient(-this.mml, 0.0f, 0.0f, this.mzz, 0, -1, Shader.TileMode.CLAMP);
                break;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.qdl.qdl.qdl
    public List<PropertyValuesHolder> lnr() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PropertyValuesHolder.ofFloat("rubIn", 0.0f, 1.0f));
        arrayList.add(PropertyValuesHolder.ofFloat(com.bytedance.adsdk.ugeno.qdl.mzz.ALPHA.ud(), 0.0f, 1.0f));
        return arrayList;
    }
}
