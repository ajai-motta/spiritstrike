package com.fyber.inneractive.sdk.network;

import android.content.Context;
import android.content.SharedPreferences;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1195a;
    public final com.fyber.inneractive.sdk.cache.a b;
    public SharedPreferences c;

    public d0(Context context, com.fyber.inneractive.sdk.cache.a aVar) {
        this.f1195a = context;
        this.b = aVar;
    }

    public com.fyber.inneractive.sdk.cache.m a() throws Throwable {
        try {
            if (!this.b.d()) {
                new c0();
                return new com.fyber.inneractive.sdk.cache.m();
            }
            Object objA = this.b.a(a(this.b.c()));
            if (this.c == null) {
                this.c = this.f1195a.getSharedPreferences("IAConfigurationPreferences", 0);
            }
            return new com.fyber.inneractive.sdk.cache.m(objA, this.c.getString(this.b.b(), null));
        } catch (Exception unused) {
            b();
            return new com.fyber.inneractive.sdk.cache.m();
        }
    }

    public final void b(String str) {
        if (this.c == null) {
            this.c = this.f1195a.getSharedPreferences("IAConfigurationPreferences", 0);
        }
        this.c.edit().putString(this.b.b(), str).apply();
    }

    public final void b() {
        if (this.c == null) {
            this.c = this.f1195a.getSharedPreferences("IAConfigurationPreferences", 0);
        }
        this.c.edit().remove(this.b.b()).apply();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public boolean a(String str, String str2) {
        boolean z;
        int i = 1;
        i = 1;
        i = 1;
        IAlog.a("caching file %s", str);
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            try {
                fileOutputStreamOpenFileOutput = this.f1195a.openFileOutput(str, 0);
                fileOutputStreamOpenFileOutput.write(str2.getBytes());
                try {
                    IAlog.a("File cached successfully", new Object[0]);
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (Exception e) {
                        IAlog.f("Failed closing cache file: %s", e.getMessage());
                    }
                } catch (Exception e2) {
                    e = e2;
                    z = true;
                    IAlog.f("Failed caching file: %s", e.getMessage());
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (Exception e3) {
                            IAlog.f("Failed closing cache file: %s", e3.getMessage());
                        }
                    }
                    i = z;
                }
            } catch (Exception e4) {
                e = e4;
                z = false;
            }
            return i;
        } catch (Throwable th) {
            if (fileOutputStreamOpenFileOutput != null) {
                try {
                    fileOutputStreamOpenFileOutput.close();
                } catch (Exception e5) {
                    Object[] objArr = new Object[i];
                    objArr[0] = e5.getMessage();
                    IAlog.f("Failed closing cache file: %s", objArr);
                }
            }
            throw th;
        }
    }

    public final String a(String str) throws Throwable {
        FileInputStream fileInputStreamOpenFileInput;
        IAlog.a("reading local file: %s", str);
        FileInputStream fileInputStream = null;
        str = null;
        str = null;
        String str2 = null;
        try {
            fileInputStreamOpenFileInput = this.f1195a.openFileInput(str);
        } catch (Exception e) {
            e = e;
            fileInputStreamOpenFileInput = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                byte[] bArr = new byte[fileInputStreamOpenFileInput.available()];
                fileInputStreamOpenFileInput.read(bArr);
                String str3 = new String(bArr, "UTF-8");
                try {
                    fileInputStreamOpenFileInput.close();
                } catch (Exception e2) {
                    IAlog.f("Failed closing local file: %s", e2.getMessage());
                }
                str2 = str3;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStreamOpenFileInput;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                        IAlog.f("Failed closing local file: %s", e3.getMessage());
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            if (!(e instanceof FileNotFoundException)) {
                IAlog.a("Failed reading local file: %s", e.getMessage());
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (Exception e5) {
                        IAlog.f("Failed closing local file: %s", e5.getMessage());
                    }
                }
            } else {
                throw new FileNotFoundException();
            }
        }
        IAlog.a("local file %s read successfully", str);
        return str2;
    }
}
