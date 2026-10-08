package com.bytedance.adsdk.ud.qdl;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.ud.mo.mzz;

/* JADX INFO: loaded from: classes.dex */
public class qdl extends Paint {
    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList localeList) {
    }

    public qdl() {
    }

    public qdl(int i) {
        super(i);
    }

    public qdl(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public qdl(int i, PorterDuff.Mode mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i) {
        if (Build.VERSION.SDK_INT < 29) {
            setColor((mzz.qdl(i, 0, 255) << 24) | (getColor() & ViewCompat.MEASURED_SIZE_MASK));
        } else {
            super.setAlpha(mzz.qdl(i, 0, 255));
        }
    }
}
