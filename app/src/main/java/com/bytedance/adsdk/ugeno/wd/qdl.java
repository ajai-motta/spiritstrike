package com.bytedance.adsdk.ugeno.wd;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.ViewCompat;
import io.ktor.sse.ServerSentEventKt;

/* JADX INFO: loaded from: classes2.dex */
public class qdl {

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.wd.qdl$qdl, reason: collision with other inner class name */
    public static class C0191qdl {
        public float[] lnr;
        public GradientDrawable.Orientation qdl;
        public int[] ud;
    }

    public static int qdl(String str) {
        return qdl(str, -16777216);
    }

    public static int qdl(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        if (str.equals("transparent")) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 4) {
            StringBuilder sb = new StringBuilder("#");
            char[] charArray = str.toCharArray();
            for (int i2 = 1; i2 < charArray.length; i2++) {
                sb.append(charArray[i2]);
                sb.append(charArray[i2]);
            }
            return Color.parseColor(sb.toString());
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (!str.startsWith("rgba")) {
            return -16777216;
        }
        String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        if (strArrSplit == null || strArrSplit.length != 4) {
            return i;
        }
        return (((int) ((Float.parseFloat(strArrSplit[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(strArrSplit[0])) << 16) | (((int) Float.parseFloat(strArrSplit[1])) << 8) | ((int) Float.parseFloat(strArrSplit[2]));
    }

    public static C0191qdl ud(String str) {
        int iIndexOf;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String strSubstring = str.substring(str.indexOf("(") + 1, str.lastIndexOf(")"));
            if (TextUtils.isEmpty(strSubstring)) {
                return null;
            }
            int iQdl = qdl(strSubstring, '%');
            int iIndexOf2 = strSubstring.indexOf(",");
            String strSubstring2 = strSubstring.substring(0, iIndexOf2);
            C0191qdl c0191qdl = new C0191qdl();
            c0191qdl.qdl = mml(strSubstring2);
            String strSubstring3 = strSubstring.substring(iIndexOf2 + 1);
            int[] iArr = new int[iQdl];
            float[] fArr = new float[iQdl];
            for (int i = 0; i < iQdl; i++) {
                int iIndexOf3 = strSubstring3.indexOf("%");
                String strTrim = strSubstring3.substring(0, iIndexOf3 + 1).trim();
                if (strTrim.contains("rgba")) {
                    iIndexOf = strTrim.indexOf(")");
                } else {
                    iIndexOf = strTrim.indexOf(ServerSentEventKt.SPACE);
                }
                int i2 = iIndexOf + 1;
                iArr[i] = qdl(strTrim.substring(0, i2).trim());
                fArr[i] = lnr.qdl(strTrim.substring(i2, strTrim.indexOf("%")).trim(), 0.0f) / 100.0f;
                int i3 = iIndexOf3 + 2;
                if (strSubstring3.length() <= i3) {
                    break;
                }
                strSubstring3 = strSubstring3.substring(i3);
            }
            if (iQdl < 2) {
                return null;
            }
            c0191qdl.ud = iArr;
            c0191qdl.lnr = fArr;
            return c0191qdl;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int qdl(String str, char c) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == c) {
                i++;
            }
        }
        return i;
    }

    public static boolean lnr(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("linear-gradient");
    }

    public static GradientDrawable.Orientation mml(String str) {
        int i;
        try {
            if (str.contains("deg")) {
                i = Integer.parseInt(str.substring(0, str.length() - 3).trim());
            } else {
                i = Integer.parseInt(str);
            }
            if (i == 90) {
                return GradientDrawable.Orientation.LEFT_RIGHT;
            }
            if (i == 180) {
                return GradientDrawable.Orientation.TOP_BOTTOM;
            }
            if (i == 270) {
                return GradientDrawable.Orientation.RIGHT_LEFT;
            }
            if (i == 135) {
                return GradientDrawable.Orientation.TL_BR;
            }
            if (i == 45) {
                return GradientDrawable.Orientation.BL_TR;
            }
            return GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }

    public static int qdl(int i, int i2) {
        if (i2 < 0 || i2 > 255) {
            Log.e("ColorUtils", "alpha must be between 0 and 255. ");
            i2 = 255;
        }
        return (i & ViewCompat.MEASURED_SIZE_MASK) | (i2 << 24);
    }
}
