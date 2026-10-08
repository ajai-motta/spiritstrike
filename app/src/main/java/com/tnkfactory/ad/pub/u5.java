package com.tnkfactory.ad.pub;

import android.graphics.Bitmap;
import android.webkit.WebChromeClient;

/* JADX INFO: loaded from: classes6.dex */
public final class u5 extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    public final Bitmap getDefaultVideoPoster() {
        Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
        return defaultVideoPoster == null ? Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565) : defaultVideoPoster;
    }
}
