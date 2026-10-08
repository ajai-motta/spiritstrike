package com.bytedance.sdk.component;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    private static ArrayMap<File, qdl> exu;
    private static ArrayMap<String, File> fs;
    protected static InterfaceC0210qdl qdl;
    private static boolean ud;
    private long jpc;
    private final Object lnr;
    private final Object mml;
    private volatile boolean mo;
    private Properties mzz;
    private final File rq;
    private final File to;
    private long tvp;
    private int wd;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.qdl$qdl, reason: collision with other inner class name */
    public interface InterfaceC0210qdl {
        ExecutorService getExecutorService();

        HandlerThread getSafeHandlerThread(String str, int i);
    }

    static /* synthetic */ long mo(qdl qdlVar) {
        long j = qdlVar.jpc;
        qdlVar.jpc = 1 + j;
        return j;
    }

    static /* synthetic */ int mzz(qdl qdlVar) {
        int i = qdlVar.wd;
        qdlVar.wd = i + 1;
        return i;
    }

    static /* synthetic */ int tvp(qdl qdlVar) {
        int i = qdlVar.wd;
        qdlVar.wd = i - 1;
        return i;
    }

    public static void qdl(InterfaceC0210qdl interfaceC0210qdl) {
        qdl = interfaceC0210qdl;
    }

    public static qdl qdl(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_prop";
        }
        synchronized (qdl.class) {
            if (fs == null) {
                fs = new ArrayMap<>();
            }
            File file = fs.get(str);
            if (file == null) {
                file = new File(context.getFilesDir(), str);
                fs.put(str, file);
            }
            if (exu == null) {
                exu = new ArrayMap<>();
            }
            qdl qdlVar = exu.get(file);
            if (qdlVar != null) {
                return qdlVar;
            }
            qdl qdlVar2 = new qdl(file);
            exu.put(file, qdlVar2);
            return qdlVar2;
        }
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedance.sdk.component.qdl$1] */
    private qdl(File file) {
        Object obj = new Object();
        this.lnr = obj;
        this.mml = new Object();
        this.mzz = new Properties();
        this.mo = false;
        this.wd = 0;
        this.to = file;
        this.rq = qdl(file);
        synchronized (obj) {
            this.mo = false;
        }
        InterfaceC0210qdl interfaceC0210qdl = qdl;
        if (interfaceC0210qdl == null || interfaceC0210qdl.getExecutorService() == null) {
            new Thread("TTPropHelper") { // from class: com.bytedance.sdk.component.qdl.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    qdl.this.qdl();
                }
            }.start();
        } else {
            qdl.getExecutorService().execute(new Runnable() { // from class: com.bytedance.sdk.component.qdl.2
                @Override // java.lang.Runnable
                public void run() {
                    qdl.this.qdl();
                }
            });
        }
    }

    static File qdl(File file) {
        return new File(file.getPath() + ".bak");
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00cd  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00ad -> B:69:0x00b6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void qdl() {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.qdl.qdl():void");
    }

    private void mml() {
        while (!this.mo) {
            try {
                this.lnr.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public String qdl(String str, String str2) {
        String property;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        synchronized (this.lnr) {
            mml();
            property = this.mzz.getProperty(str, str2);
        }
        return property;
    }

    public int qdl(String str, int i) {
        int i2;
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        synchronized (this.lnr) {
            try {
                try {
                    mml();
                    i2 = Integer.parseInt(this.mzz.getProperty(str, String.valueOf(i)));
                } catch (NumberFormatException e) {
                    Log.e("TTPropHelper", e.getMessage());
                    return i;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i2;
    }

    public long qdl(String str, long j) {
        long j2;
        if (TextUtils.isEmpty(str)) {
            return j;
        }
        synchronized (this.lnr) {
            try {
                try {
                    mml();
                    j2 = Long.parseLong(this.mzz.getProperty(str, String.valueOf(j)));
                } catch (NumberFormatException e) {
                    Log.e("TTPropHelper", e.getMessage());
                    return j;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return j2;
    }

    public float qdl(String str, float f) {
        float f2;
        if (TextUtils.isEmpty(str)) {
            return f;
        }
        synchronized (this.lnr) {
            try {
                try {
                    mml();
                    f2 = Float.parseFloat(this.mzz.getProperty(str, String.valueOf(f)));
                } catch (NumberFormatException e) {
                    Log.e("TTPropHelper", e.getMessage());
                    return f;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f2;
    }

    public boolean qdl(String str, boolean z) {
        boolean z2;
        if (TextUtils.isEmpty(str)) {
            return z;
        }
        synchronized (this.lnr) {
            try {
                try {
                    mml();
                    z2 = Boolean.parseBoolean(this.mzz.getProperty(str, String.valueOf(z)));
                } catch (NumberFormatException e) {
                    Log.e("TTPropHelper", e.getMessage());
                    return z;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }

    public boolean qdl(String str) {
        boolean zContainsKey;
        synchronized (this.lnr) {
            try {
                try {
                    mml();
                    zContainsKey = this.mzz.containsKey(str);
                } catch (NumberFormatException e) {
                    Log.e("TTPropHelper", e.getMessage());
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zContainsKey;
    }

    public lnr ud() {
        return new lnr();
    }

    private static class ud {
        final CountDownLatch lnr;
        volatile boolean mml;
        boolean mzz;
        final long qdl;
        final Properties ud;

        private ud(long j, Properties properties) {
            this.lnr = new CountDownLatch(1);
            this.mml = false;
            this.mzz = false;
            this.qdl = j;
            this.ud = properties;
        }

        void qdl(boolean z, boolean z2) {
            this.mzz = z;
            this.mml = z2;
            this.lnr.countDown();
        }
    }

    public class lnr implements SharedPreferences.Editor {
        private final Object ud = new Object();
        private final Map<String, Object> lnr = new HashMap();
        private boolean mml = false;

        public lnr() {
        }

        @Override // android.content.SharedPreferences.Editor
        public /* synthetic */ SharedPreferences.Editor putStringSet(String str, Set set) {
            return qdl(str, (Set<String>) set);
        }

        public lnr qdl(String str, Set<String> set) {
            synchronized (this.ud) {
                this.lnr.put(str, set == null ? null : new HashSet(set));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public lnr putInt(String str, int i) {
            synchronized (this.ud) {
                this.lnr.put(str, Integer.valueOf(i));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public lnr putLong(String str, long j) {
            synchronized (this.ud) {
                this.lnr.put(str, Long.valueOf(j));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public lnr putFloat(String str, float f) {
            synchronized (this.ud) {
                this.lnr.put(str, Float.valueOf(f));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public lnr putString(String str, String str2) {
            synchronized (this.ud) {
                this.lnr.put(str, str2);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public lnr putBoolean(String str, boolean z) {
            synchronized (this.ud) {
                this.lnr.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public lnr remove(String str) {
            synchronized (this.ud) {
                this.lnr.put(str, this);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public lnr clear() {
            synchronized (this.ud) {
                this.mml = true;
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            long jCurrentTimeMillis = qdl.ud ? System.currentTimeMillis() : 0L;
            ud udVarUd = ud();
            qdl.this.qdl(udVarUd, true);
            try {
                udVarUd.lnr.await();
                if (qdl.ud) {
                    Log.d("TTPropHelper", qdl.this.to.getName() + ":" + udVarUd.qdl + " committed after " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
                }
                return udVarUd.mml;
            } catch (InterruptedException unused) {
                if (!qdl.ud) {
                    return false;
                }
                Log.d("TTPropHelper", qdl.this.to.getName() + ":" + udVarUd.qdl + " committed after " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
                return false;
            } catch (Throwable th) {
                if (qdl.ud) {
                    Log.d("TTPropHelper", qdl.this.to.getName() + ":" + udVarUd.qdl + " committed after " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
                }
                throw th;
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            qdl.this.qdl(ud(), false);
        }

        private ud ud() {
            Properties properties;
            long j;
            Object obj;
            boolean z;
            synchronized (qdl.this.lnr) {
                if (qdl.this.wd > 0) {
                    Properties properties2 = new Properties();
                    properties2.putAll(qdl.this.mzz);
                    qdl.this.mzz = properties2;
                }
                properties = qdl.this.mzz;
                qdl.mzz(qdl.this);
                synchronized (this.ud) {
                    boolean z2 = false;
                    if (this.mml) {
                        if (properties.isEmpty()) {
                            z = false;
                        } else {
                            properties.clear();
                            z = true;
                        }
                        this.mml = false;
                        z2 = z;
                    }
                    for (Map.Entry<String, Object> entry : this.lnr.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value == this || value == null) {
                            if (properties.containsKey(key)) {
                                properties.remove(key);
                                z2 = true;
                            }
                        } else if (!properties.containsKey(key) || (obj = properties.get(key)) == null || !obj.equals(String.valueOf(value))) {
                            properties.put(key, String.valueOf(value));
                            z2 = true;
                        }
                    }
                    this.lnr.clear();
                    if (z2) {
                        qdl.mo(qdl.this);
                    }
                    j = qdl.this.jpc;
                }
            }
            return new ud(j, properties);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(final ud udVar, final boolean z) {
        boolean z2;
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.qdl.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (qdl.this.mml) {
                    try {
                        qdl.this.ud(udVar, z);
                    } catch (OutOfMemoryError unused) {
                    }
                }
                synchronized (qdl.this.lnr) {
                    qdl.tvp(qdl.this);
                }
            }
        };
        if (z) {
            synchronized (this.lnr) {
                z2 = this.wd == 1;
            }
            if (z2) {
                runnable.run();
                return;
            }
        }
        com.bytedance.sdk.component.ud.qdl(runnable, true ^ z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
    
        if (r0 == false) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0122 A[Catch: all -> 0x0196, TryCatch #5 {all -> 0x0196, blocks: (B:38:0x008f, B:39:0x0091, B:75:0x011e, B:77:0x0122, B:79:0x0129, B:81:0x0132, B:83:0x013a, B:85:0x0146, B:95:0x0194, B:96:0x0195, B:74:0x011d, B:54:0x00e7, B:55:0x00ed, B:73:0x0116, B:93:0x0192, B:92:0x0189, B:69:0x0110, B:50:0x00e1, B:88:0x0183), top: B:114:0x008f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0132 A[Catch: all -> 0x0196, TryCatch #5 {all -> 0x0196, blocks: (B:38:0x008f, B:39:0x0091, B:75:0x011e, B:77:0x0122, B:79:0x0129, B:81:0x0132, B:83:0x013a, B:85:0x0146, B:95:0x0194, B:96:0x0195, B:74:0x011d, B:54:0x00e7, B:55:0x00ed, B:73:0x0116, B:93:0x0192, B:92:0x0189, B:69:0x0110, B:50:0x00e1, B:88:0x0183), top: B:114:0x008f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0146 A[Catch: all -> 0x0196, TRY_LEAVE, TryCatch #5 {all -> 0x0196, blocks: (B:38:0x008f, B:39:0x0091, B:75:0x011e, B:77:0x0122, B:79:0x0129, B:81:0x0132, B:83:0x013a, B:85:0x0146, B:95:0x0194, B:96:0x0195, B:74:0x011d, B:54:0x00e7, B:55:0x00ed, B:73:0x0116, B:93:0x0192, B:92:0x0189, B:69:0x0110, B:50:0x00e1, B:88:0x0183), top: B:114:0x008f, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void ud(com.bytedance.sdk.component.qdl.ud r18, boolean r19) {
        /*
            Method dump skipped, instruction units count: 457
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.qdl.ud(com.bytedance.sdk.component.qdl$ud, boolean):void");
    }
}
