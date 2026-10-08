package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes3.dex */
public class mml {
    public static void qdl(ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.model.ljh ljhVar) {
        if (viewGroup == null || ljhVar == null || TextUtils.isEmpty(ljhVar.uw())) {
            return;
        }
        try {
            if (viewGroup.getTag(jtx.rdz) != null) {
                return;
            }
            int i = jtx.rdz;
            viewGroup.setTag(i, Integer.valueOf(i));
            Drawable drawableQdl = qdl(viewGroup.getResources(), ljhVar);
            if (drawableQdl == null) {
                return;
            }
            viewGroup.setForeground(drawableQdl);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.lnr("add overlay fail", th.getMessage());
        }
    }

    public static void qdl(Activity activity, com.bytedance.sdk.openadsdk.core.model.ljh ljhVar) {
        if (activity == null || ljhVar == null || TextUtils.isEmpty(ljhVar.uw())) {
            return;
        }
        try {
            if (activity.getWindow().getDecorView().getTag(jtx.rdz) != null) {
                return;
            }
            View decorView = activity.getWindow().getDecorView();
            int i = jtx.rdz;
            decorView.setTag(i, Integer.valueOf(i));
            Drawable drawableQdl = qdl(activity.getResources(), ljhVar);
            if (drawableQdl == null) {
                return;
            }
            activity.getWindow().getDecorView().setForeground(drawableQdl);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.lnr("add overlay fail", th.getMessage());
        }
    }

    private static Drawable qdl(Resources resources, com.bytedance.sdk.openadsdk.core.model.ljh ljhVar) {
        try {
            String strUw = ljhVar.uw();
            if (TextUtils.isEmpty(strUw)) {
                return null;
            }
            byte[] bArrDecode = Base64.decode(strUw, 0);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            bitmapDrawable.setTileModeXY(tileMode, tileMode);
            bitmapDrawable.setTargetDensity(resources.getDisplayMetrics());
            return bitmapDrawable;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static class qdl implements View.OnLayoutChangeListener {
        private int lnr;
        private final Drawable qdl;
        private int ud;

        public qdl(Drawable drawable) {
            this.qdl = drawable;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9 = i3 - i;
            int i10 = i4 - i2;
            if (i9 == this.ud && i10 == this.lnr) {
                return;
            }
            this.ud = i9;
            this.lnr = i10;
            this.qdl.setBounds(0, 0, i9, i10);
        }
    }
}
