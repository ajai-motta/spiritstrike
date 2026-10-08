package com.adxcorp.ads.nativeads.util;

import android.text.TextUtils;
import android.widget.ImageView;
import com.adxcorp.ads.mediation.nativeads.NativeAdImageHelper;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class NativeImageUtil {
    private static final String TAG = "NativeImageUtil";

    public interface ImageLoadEventListener {
        void onError();

        void onSuccess();
    }

    public static void loadImage(String str, ImageView imageView) {
        loadImage(str, imageView, null);
    }

    public static void loadImage(String str, ImageView imageView, final ImageLoadEventListener imageLoadEventListener) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        HashMap<String, ImageView> map = new HashMap<>();
        map.put(str, imageView);
        new NativeAdImageHelper(imageView.getContext()).load(map, new NativeAdImageHelper.ImageLoadEventListener() { // from class: com.adxcorp.ads.nativeads.util.NativeImageUtil.1
            @Override // com.adxcorp.ads.mediation.nativeads.NativeAdImageHelper.ImageLoadEventListener
            public void onSuccess() {
                ImageLoadEventListener imageLoadEventListener2 = imageLoadEventListener;
                if (imageLoadEventListener2 != null) {
                    imageLoadEventListener2.onSuccess();
                }
            }

            @Override // com.adxcorp.ads.mediation.nativeads.NativeAdImageHelper.ImageLoadEventListener
            public void onError() {
                ImageLoadEventListener imageLoadEventListener2 = imageLoadEventListener;
                if (imageLoadEventListener2 != null) {
                    imageLoadEventListener2.onError();
                }
            }
        });
    }
}
