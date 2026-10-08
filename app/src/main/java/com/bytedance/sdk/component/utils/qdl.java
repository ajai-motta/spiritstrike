package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {

    /* JADX INFO: renamed from: com.bytedance.sdk.component.utils.qdl$qdl, reason: collision with other inner class name */
    static class C0214qdl {
        static final Random qdl = qdl.lnr();
    }

    public static JSONObject qdl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        return qdl(jSONObject.toString());
    }

    public static JSONObject qdl(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            try {
                String strUd = ud(str);
                if (!TextUtils.isEmpty(strUd)) {
                    jSONObject.put("message", strUd);
                    jSONObject.put("cypher", 3);
                } else {
                    jSONObject.put("message", str);
                    jSONObject.put("cypher", 0);
                }
            } catch (Throwable unused) {
                jSONObject.put("message", str);
                jSONObject.put("cypher", 0);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        return jSONObject;
    }

    public static String ud(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strQdl = qdl();
        String strQdl2 = qdl(strQdl, 32);
        String strUd = ud();
        return ExifInterface.GPS_MEASUREMENT_3D + strQdl + strUd + ((strQdl2 == null || strUd == null) ? null : com.bytedance.sdk.component.mml.qdl.qdl(str, strUd, strQdl2));
    }

    public static String lnr(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String strQdl = qdl(str.substring(1, 33), 32);
        String strSubstring = str.substring(33, 49);
        return (strSubstring == null || strQdl == null) ? str : com.bytedance.sdk.component.mml.qdl.ud(str.substring(49), strSubstring, strQdl);
    }

    public static String qdl() {
        String strQdl = qdl(16);
        if (strQdl == null || strQdl.length() != 32) {
            return null;
        }
        return strQdl;
    }

    public static String qdl(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    public static String ud() {
        String strQdl = qdl(8);
        if (strQdl == null || strQdl.length() != 16) {
            return null;
        }
        return strQdl;
    }

    public static String qdl(int i) {
        try {
            byte[] bArr = new byte[i];
            C0214qdl.qdl.nextBytes(bArr);
            return mzz.qdl(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Random lnr() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return SecureRandom.getInstanceStrong();
            } catch (Throwable unused) {
                return new SecureRandom();
            }
        }
        return new SecureRandom();
    }
}
