package com.pgl.ssdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.camera2.CameraManager;

/* JADX INFO: loaded from: classes6.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f3092a = -1;

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x.f3092a = x.b(z.a());
            SharedPreferences sharedPreferencesA = ax.a(z.a());
            if (sharedPreferencesA != null) {
                sharedPreferencesA.edit().putInt("camera_count", x.f3092a).apply();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(Context context) {
        int i = f3092a;
        if (i != -1) {
            return i;
        }
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        if (cameraManager != null) {
            try {
                f3092a = cameraManager.getCameraIdList().length;
            } catch (Throwable unused) {
                f3092a = -1;
            }
        } else {
            f3092a = -2;
        }
        return f3092a;
    }

    public static int a() {
        int i;
        int i2 = f3092a;
        if (i2 != -1) {
            return i2;
        }
        SharedPreferences sharedPreferencesA = ax.a(z.a());
        if (sharedPreferencesA == null || (i = sharedPreferencesA.getInt("camera_count", -1)) == -1) {
            ar.b(new a());
            return -1;
        }
        f3092a = i;
        return i;
    }
}
