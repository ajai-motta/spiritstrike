package com.fyber.inneractive.sdk.util;

import android.graphics.BitmapFactory;
import android.net.Uri;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class u {
    public static Float a(Uri uri) {
        InputStream inputStreamOpenInputStream;
        int i;
        try {
            inputStreamOpenInputStream = IAConfigManager.O.v.f957a.getApplicationContext().getContentResolver().openInputStream(uri);
        } catch (Exception e) {
            IAlog.b("%sFailed to retrieve image aspect ratio. Reason: %s", IAlog.a(u.class), e.getMessage());
        }
        if (inputStreamOpenInputStream == null) {
            if (inputStreamOpenInputStream != null) {
                inputStreamOpenInputStream.close();
            }
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
            int i2 = options.outHeight;
            if (i2 <= 0 || (i = options.outWidth) <= 0) {
                inputStreamOpenInputStream.close();
                return null;
            }
            Float fValueOf = Float.valueOf(i / i2);
            inputStreamOpenInputStream.close();
            return fValueOf;
            return null;
        } finally {
        }
        IAlog.b("%sFailed to retrieve image aspect ratio. Reason: %s", IAlog.a(u.class), e.getMessage());
    }

    public static String b(Uri uri) {
        try {
            InputStream inputStreamOpenInputStream = IAConfigManager.O.v.f957a.getApplicationContext().getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                return null;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                String str = options.outMimeType;
                inputStreamOpenInputStream.close();
                return str;
            } finally {
            }
        } catch (Exception e) {
            IAlog.b("%sFailed to retrieve image mime type. Reason: %s", IAlog.a(u.class), e.getMessage());
            return null;
        }
    }
}
