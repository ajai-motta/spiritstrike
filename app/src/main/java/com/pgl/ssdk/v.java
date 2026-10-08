package com.pgl.ssdk;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f3090a = null;
    private static volatile String b = null;
    private static volatile boolean c = false;
    private static String d = null;
    private static String e = null;
    private static String f = null;
    private static int g = -1;
    private static long h = 0;
    private static long i = 0;
    private static volatile long j = -1;

    public static void a(File file, boolean z) throws Throwable {
        RandomAccessFile randomAccessFile;
        e eVarA;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
            } catch (FileNotFoundException unused) {
            } catch (IOException unused2) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (TextUtils.isEmpty(f3090a) && (eVarA = a(file)) != null) {
                    f3090a = a(eVarA.a());
                    d = eVarA.b();
                    if (z) {
                        a();
                        try {
                            randomAccessFile.close();
                            return;
                        } catch (IOException unused3) {
                            return;
                        }
                    }
                }
                if (TextUtils.isEmpty(e)) {
                    e = a(randomAccessFile);
                }
                if (h == 0) {
                    h = randomAccessFile.length() / 1024;
                }
                if (i == 0) {
                    i = b(file);
                }
                randomAccessFile.close();
            } catch (FileNotFoundException unused4) {
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
            } catch (IOException unused5) {
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException unused6) {
                    }
                }
                throw th;
            }
        } catch (IOException unused7) {
        }
    }

    public static String b() throws Throwable {
        String string;
        String string2;
        String string3;
        String string4;
        int i2;
        long j2;
        long j3;
        if (TextUtils.isEmpty(f3090a) || TextUtils.isEmpty(e) || g == -1) {
            SharedPreferences sharedPreferencesA = ax.a(z.a());
            long j4 = -1;
            if (sharedPreferencesA != null) {
                j4 = sharedPreferencesA.getLong("mt", -1L);
                string2 = sharedPreferencesA.getString("sa", null);
                string3 = sharedPreferencesA.getString("sj", null);
                string4 = sharedPreferencesA.getString("md5", null);
                j2 = sharedPreferencesA.getLong("as", 0L);
                j3 = sharedPreferencesA.getLong("ds", 0L);
                i2 = sharedPreferencesA.getInt("cpc", -1);
                string = sharedPreferencesA.getString("ap", null);
            } else {
                string = null;
                string2 = null;
                string3 = null;
                string4 = null;
                i2 = 0;
                j2 = 0;
                j3 = 0;
            }
            String strC = c();
            if (strC == null) {
                return null;
            }
            File file = new File(strC);
            Object[] objArr = (Object[]) com.pgl.ssdk.ces.a.meta(158, z.a(), strC);
            Integer num = (Integer) objArr[0];
            String str = (String) objArr[1];
            long jLastModified = file.lastModified();
            if (jLastModified != j4 || string2 == null || i2 == -1) {
                j = jLastModified;
                if (str != null) {
                    f = str;
                }
                if (num != null) {
                    g = num.intValue();
                }
                a(file, false);
                a();
            } else {
                f3090a = string2;
                d = string3;
                h = j2;
                i = j3;
                e = string4;
                g = i2;
                f = string;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(f3090a)) {
                jSONObject.put("sign", f3090a);
            }
            if (!TextUtils.isEmpty(d)) {
                jSONObject.put("subject", d);
            }
            if (!TextUtils.isEmpty(e)) {
                jSONObject.put("md5", e);
            }
            if (!TextUtils.isEmpty(f)) {
                jSONObject.put("path", f);
            }
            long j5 = h;
            if (j5 != 0) {
                jSONObject.put("apkSize", j5);
            }
            long j6 = i;
            if (j6 != 0) {
                jSONObject.put("dexSize", j6);
            }
            int i3 = g;
            if (i3 != -1) {
                jSONObject.put("code", i3);
            }
            e();
            jSONObject.put("signpm", b);
            if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(f3090a)) {
                if (!b.equals(f3090a)) {
                    c = true;
                }
                jSONObject.put("rebud", c);
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String c() {
        if (z.a() == null) {
            return null;
        }
        String packageCodePath = z.a().getPackageCodePath();
        if (TextUtils.isEmpty(packageCodePath)) {
            return null;
        }
        File file = new File(packageCodePath);
        if (file.exists() && file.canRead()) {
            return packageCodePath;
        }
        return null;
    }

    public static void d() throws Throwable {
        if (TextUtils.isEmpty(f3090a)) {
            SharedPreferences sharedPreferencesA = ax.a(z.a());
            String string = null;
            long j2 = -1;
            if (sharedPreferencesA != null) {
                j2 = sharedPreferencesA.getLong("mt", -1L);
                string = sharedPreferencesA.getString("sa", null);
            }
            String strC = c();
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            File file = new File(strC);
            long jLastModified = file.lastModified();
            if (jLastModified != j2 || string == null) {
                j = jLastModified;
                a(file, true);
                a();
            } else {
                f3090a = string;
            }
        }
        e();
        if (TextUtils.isEmpty(b) || TextUtils.isEmpty(f3090a) || b.equals(f3090a)) {
            return;
        }
        c = true;
    }

    public static String e() {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        try {
            String strA = a(z.a().getPackageManager().getPackageInfo(z.a().getPackageName(), 64).signatures[0].toByteArray());
            b = strA;
            return strA;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean f() throws Throwable {
        d();
        return c;
    }

    public static void a() {
        SharedPreferences sharedPreferencesA = ax.a(z.a());
        if (sharedPreferencesA != null) {
            if (!TextUtils.isEmpty(f3090a)) {
                sharedPreferencesA.edit().putString("sa", f3090a).apply();
            }
            if (!TextUtils.isEmpty(e)) {
                sharedPreferencesA.edit().putString("md5", e).apply();
            }
            if (!TextUtils.isEmpty(d)) {
                sharedPreferencesA.edit().putString("sj", d).apply();
            }
            if (h != 0) {
                sharedPreferencesA.edit().putLong("as", h).apply();
            }
            if (i != 0) {
                sharedPreferencesA.edit().putLong("ds", i).apply();
            }
            if (j != -1) {
                sharedPreferencesA.edit().putLong("mt", j).apply();
            }
            if (g != -1) {
                sharedPreferencesA.edit().putInt("cpc", g).apply();
            }
            if (TextUtils.isEmpty(f)) {
                return;
            }
            sharedPreferencesA.edit().putString("ap", f).apply();
        }
    }

    public static long b(File file) throws Throwable {
        String str;
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                int i2 = 0;
                int size = 0;
                while (true) {
                    if (i2 == 0) {
                        str = "classes.dex";
                    } else {
                        str = String.format(Locale.getDefault(), "classes%d.dex", Integer.valueOf(i2));
                    }
                    ZipEntry entry = zipFile2.getEntry(str);
                    if (entry == null) {
                        break;
                    }
                    try {
                        size = (int) (((long) size) + entry.getSize());
                        i2++;
                    } catch (ZipException unused) {
                        zipFile = zipFile2;
                        if (zipFile == null) {
                            return 0L;
                        }
                        zipFile.close();
                        return 0L;
                    } catch (IOException unused2) {
                        zipFile = zipFile2;
                        if (zipFile == null) {
                            return 0L;
                        }
                        zipFile.close();
                        return 0L;
                    } catch (Throwable th) {
                        th = th;
                        zipFile = zipFile2;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                }
                long j2 = size / 1000;
                try {
                    zipFile2.close();
                } catch (IOException unused4) {
                }
                return j2;
            } catch (ZipException unused5) {
            } catch (IOException unused6) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused7) {
            return 0L;
        }
    }

    public static String a(byte[] bArr) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    @com.pgl.ssdk.ces.out.DungeonFlag
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.pgl.ssdk.e a(java.io.File r6) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L1e com.pgl.ssdk.g.a -> L25
            java.lang.String r2 = "r"
            r1.<init>(r6, r2)     // Catch: java.lang.Throwable -> L1e com.pgl.ssdk.g.a -> L25
            long r2 = r1.length()     // Catch: java.lang.Throwable -> L1f com.pgl.ssdk.g.a -> L26
            r4 = 0
            com.pgl.ssdk.q r2 = com.pgl.ssdk.r.a(r1, r4, r2)     // Catch: java.lang.Throwable -> L1f com.pgl.ssdk.g.a -> L26
            com.pgl.ssdk.c$a r3 = com.pgl.ssdk.c.a(r2)     // Catch: java.lang.Throwable -> L1f com.pgl.ssdk.g.a -> L26
            java.util.List r2 = com.pgl.ssdk.l.a(r2, r3)     // Catch: java.lang.Throwable -> L1f com.pgl.ssdk.g.a -> L26
            r1.close()     // Catch: java.io.IOException -> L2c
            goto L2c
        L1e:
            r1 = r0
        L1f:
            if (r1 == 0) goto L2b
            r1.close()     // Catch: java.io.IOException -> L2b
            goto L2b
        L25:
            r1 = r0
        L26:
            if (r1 == 0) goto L2b
            r1.close()     // Catch: java.io.IOException -> L2b
        L2b:
            r2 = r0
        L2c:
            if (r2 == 0) goto L34
            boolean r1 = r2.isEmpty()
            if (r1 == 0) goto L38
        L34:
            java.util.List r2 = com.pgl.ssdk.k.a(r6)
        L38:
            if (r2 == 0) goto L48
            boolean r6 = r2.isEmpty()
            if (r6 != 0) goto L48
            r6 = 0
            java.lang.Object r6 = r2.get(r6)
            com.pgl.ssdk.e r6 = (com.pgl.ssdk.e) r6
            return r6
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.v.a(java.io.File):com.pgl.ssdk.e");
    }

    public static String a(RandomAccessFile randomAccessFile) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[1048576];
            while (true) {
                int i2 = randomAccessFile.read(bArr);
                if (i2 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i2);
            }
            String string = new BigInteger(1, messageDigest.digest()).toString(16);
            while (string.length() < 32) {
                string = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(string));
            }
            return string;
        } catch (FileNotFoundException | IOException | NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
