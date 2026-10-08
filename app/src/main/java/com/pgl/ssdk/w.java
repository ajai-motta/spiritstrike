package com.pgl.ssdk;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f3091a;
    private static String b;

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(w.b)) {
                String unused = w.b = w.d();
                ax.b(z.a(), "romtype", w.b);
            }
        }
    }

    private static boolean c(String str) {
        try {
            return new File(str).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d() {
        return (b("com.samsung.android.knox.SemPersonaManager") || b("com.samsung.android.knoxguard.KnoxGuardManager")) ? Constants.REFERRER_API_SAMSUNG : (b("androidhnext.Manifest") || b("androidhnext.R")) ? "honor" : (b("androidhwext.Manifest") || b("androidhwext.R")) ? "huawei" : (b("oppo.Manifest") || b("oppo.R") || b("oplus.Manifest") || b("oplus.R") || b("com.oneplus.Manifest") || b("com.oneplus.R")) ? "oppo" : (b("vivo.Manifest") || b("vivo.R")) ? Constants.REFERRER_API_VIVO : (b("miui.Manifest") || b("miui.R") || b("miui.os.Build")) ? Constants.REFERRER_API_XIAOMI : (b("lineageos.platform.Manifest") || b("lineageos.platform.R")) ? "lineage" : c("/system/framework/com.motorola.motosignature.jar") ? "moto" : (c("/system/framework/transsion-framework.jar") || c("/system/framework/transsion-services.jar")) ? "transsion" : "other";
    }

    private static boolean b(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String c() {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        String strA = ax.a(z.a(), "romtype", (String) null);
        b = strA;
        if (!TextUtils.isEmpty(strA)) {
            return b;
        }
        ar.b(new a());
        return "";
    }

    public static String a(Context context) {
        String str = f3091a;
        if (str != null) {
            return str;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            f3091a = Settings.Global.getString(context.getContentResolver(), "boot_count");
        } else {
            f3091a = "lowapi";
        }
        return f3091a;
    }
}
