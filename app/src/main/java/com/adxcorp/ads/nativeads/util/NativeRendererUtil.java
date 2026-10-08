package com.adxcorp.ads.nativeads.util;

import android.widget.TextView;
import com.adxcorp.util.ADXLogUtil;

/* JADX INFO: loaded from: classes2.dex */
public class NativeRendererUtil {
    private static final String TAG = "NativeRendererUtil";

    public static void addTextView(TextView textView, String str) {
        if (textView == null) {
            ADXLogUtil.d(TAG, "Attempted to add text (" + str + ") to null TextView.");
            return;
        }
        textView.setText((CharSequence) null);
        if (str == null) {
            ADXLogUtil.d(TAG, "Attempted to set TextView contents to null.");
        } else {
            textView.setText(str);
        }
    }
}
