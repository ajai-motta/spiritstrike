package com.bytedance.sdk.component.utils;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class jyq {
    private static String qdl;

    public static boolean qdl(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return false;
        }
        return TextUtils.equals(context.getApplicationContext().getPackageName(), ud(context));
    }

    public static String ud(Context context) {
        if (!TextUtils.isEmpty(qdl)) {
            return qdl;
        }
        String strQdl = qdl();
        qdl = strQdl;
        if (!TextUtils.isEmpty(strQdl)) {
            return qdl;
        }
        String strUd = ud();
        qdl = strUd;
        if (!TextUtils.isEmpty(strUd)) {
            return qdl;
        }
        return qdl;
    }

    private static String qdl() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            return Application.getProcessName();
        } catch (Exception unused) {
            return null;
        }
    }

    private static String ud() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
