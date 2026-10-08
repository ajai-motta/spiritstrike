package com.fyber.inneractive.sdk.config;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n {
    public static void a(Context context, w wVar) {
        String string = null;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            z = Settings.Secure.getInt(contentResolver, "limit_ad_tracking") != 0;
            if (!z) {
                string = Settings.Secure.getString(contentResolver, "advertising_id");
            }
        } catch (Settings.SettingNotFoundException unused) {
        }
        if (string != null) {
            synchronized (wVar) {
                v vVar = wVar.b;
                vVar.f984a = string;
                vVar.b = z;
                vVar.c = true;
            }
        }
    }
}
