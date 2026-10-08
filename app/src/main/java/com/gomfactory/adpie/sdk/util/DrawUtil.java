package com.gomfactory.adpie.sdk.util;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;

/* JADX INFO: loaded from: classes3.dex */
public class DrawUtil {
    public static ShapeDrawable cornerDrawable(Context context, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4) {
        int iDpToPx = DisplayUtil.dpToPx(context, i2);
        float[] fArr = new float[8];
        if (z) {
            float f = iDpToPx;
            fArr[0] = f;
            fArr[1] = f;
        } else {
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
        }
        if (z2) {
            float f2 = iDpToPx;
            fArr[2] = f2;
            fArr[3] = f2;
        } else {
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
        }
        if (z3) {
            float f3 = iDpToPx;
            fArr[4] = f3;
            fArr[5] = f3;
        } else {
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
        }
        if (z4) {
            float f4 = iDpToPx;
            fArr[6] = f4;
            fArr[7] = f4;
        } else {
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }
}
