package com.tnkfactory.ad.pub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.tnkfactory.ad.Logger;
import java.net.URLEncoder;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c0 {
    public static String a(String str, String str2, String str3, int i, HashMap map) {
        if (str2 == null) {
            return null;
        }
        if (map != null) {
            for (String str4 : map.keySet()) {
                Object obj = map.get(str4);
                String str5 = "${" + str4 + "}";
                if (str2.indexOf(str5) > 0) {
                    str2 = str2.replace(str5, String.valueOf(obj));
                }
                if (str.indexOf(str5) > 0) {
                    str = str.replace(str5, String.valueOf(obj));
                }
            }
        }
        if (str != null) {
            String strReplace = str.replace("${ADV_URL}", str2);
            try {
                str2 = URLEncoder.encode(str2, "utf-8");
            } catch (Exception unused) {
            }
            str2 = strReplace.replace("${ADV_URL:ENC}", str2);
        }
        return str2.replace("${ADV_ID}", str3).replace("${PAGE_INDEX}", String.valueOf(i));
    }

    public static String a(Context context, String str, boolean z) {
        if (str == null) {
            Logger.e("error #f007");
            return null;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.putExtra("com.android.browser.application_id", "com.tnkfactory.ad");
            if (str.startsWith("market://")) {
                intent.setPackage("com.android.vending");
            }
            if (z || !(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            return str;
        } catch (Exception e) {
            if (!z) {
                return a(context, str, true);
            }
            Logger.e("goWebPage error : " + e.toString());
            Toast.makeText(context, r2.a().c, 1).show();
            return null;
        }
    }

    public static boolean a(Context context, String str) {
        if (context != null && str != null && str.length() != 0) {
            try {
                context.getPackageManager().getPackageInfo(str, 128);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean a(Context context) {
        if ((context.getResources().getConfiguration().screenLayout & 15) < 3) {
            return false;
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            float f = displayMetrics.widthPixels / displayMetrics.xdpi;
            float f2 = displayMetrics.heightPixels / displayMetrics.ydpi;
            return Math.sqrt((double) ((f2 * f2) + (f * f))) >= 6.0d;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }
}
