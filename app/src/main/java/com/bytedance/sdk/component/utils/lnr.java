package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class lnr {
    private static HashMap<String, ArrayList<String>> qdl = new HashMap<>();

    public static ArrayList<String> qdl(Context context, String str) {
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (qdl.get(str) != null) {
                return qdl.get(str);
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : ud(context, packageName)) {
                    String strQdl = "error!";
                    if ("MD5".equals(str)) {
                        strQdl = qdl(signature, "MD5");
                    } else if ("SHA1".equals(str)) {
                        strQdl = qdl(signature, "SHA1");
                    } else if ("SHA256".equals(str)) {
                        strQdl = qdl(signature, "SHA256");
                    }
                    arrayList.add(strQdl);
                }
            } catch (Exception unused) {
            }
            qdl.put(str, arrayList);
        }
        return arrayList;
    }

    public static String qdl(Context context) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayListQdl = qdl(context, "SHA1");
        if (arrayListQdl != null && arrayListQdl.size() != 0) {
            for (int i = 0; i < arrayListQdl.size(); i++) {
                sb.append(arrayListQdl.get(i));
                if (i < arrayListQdl.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    private static Signature[] ud(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception unused) {
            return null;
        }
    }

    private static String qdl(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest == null) {
                return "error!";
            }
            byte[] bArrDigest = messageDigest.digest(byteArray);
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1).toString();
        } catch (Exception unused) {
            return "error!";
        }
    }
}
