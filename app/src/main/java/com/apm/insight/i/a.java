package com.apm.insight.i;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.apm.insight.runtime.o;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile UUID f180a = null;
    private static String b = "";

    public static synchronized String a(Context context) {
        if (TextUtils.isEmpty(b)) {
            new a(context);
            UUID uuid = f180a;
            if (uuid != null) {
                b = uuid.toString();
            }
        }
        return b;
    }

    private a(Context context) {
        String string;
        if (f180a == null) {
            synchronized (a.class) {
                if (f180a == null) {
                    String strC = o.a().c();
                    if (strC != null) {
                        f180a = UUID.fromString(strC);
                    } else {
                        try {
                            string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                        } catch (Throwable unused) {
                            string = null;
                        }
                        try {
                            if (string != null) {
                                f180a = UUID.nameUUIDFromBytes(string.getBytes("utf8"));
                            } else {
                                f180a = UUID.randomUUID();
                            }
                        } catch (Throwable unused2) {
                        }
                        try {
                            o.a().b(f180a.toString());
                        } catch (Throwable unused3) {
                        }
                    }
                }
            }
        }
    }
}
