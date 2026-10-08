package com.bytedance.sdk.openadsdk.core.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.component.utils.jyq;
import com.bytedance.sdk.openadsdk.core.settings.mzz;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.utils.exu;
import com.bytedance.sdk.openadsdk.utils.fco;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class to implements mzz {
    private boolean rq;
    private final qdl to;
    private final String wd;
    private final ConcurrentHashMap<String, Object> lnr = new ConcurrentHashMap<>();
    private final Object mml = new Object();
    private final Object mzz = new Object();
    private final CountDownLatch mo = new CountDownLatch(1);
    private Properties jpc = new Properties();
    private volatile boolean tvp = false;

    public interface qdl {
        void qdl();

        void ud();
    }

    public to(String str, qdl qdlVar) {
        this.wd = str;
        this.to = qdlVar;
        fco.qdl(new com.bytedance.sdk.component.jpc.jpc("SetL_".concat(String.valueOf(str))) { // from class: com.bytedance.sdk.openadsdk.core.settings.to.1
            @Override // java.lang.Runnable
            public void run() {
                to.this.qdl(false);
            }
        });
    }

    public String qdl(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return str2;
        }
        mzz();
        return this.jpc.getProperty(str, str2);
    }

    private void mzz() {
        if (this.rq && yt.qdl() != null) {
            qdl(true);
        }
        if (this.tvp) {
            return;
        }
        try {
            SystemClock.elapsedRealtime();
            this.mo.await(fco.mo() ? 4 : 8, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            aaj.qdl("SdkSettings.Prop", "awaitLoadedLocked: ", e);
        }
    }

    public int qdl(String str, int i) {
        if (str != null && !str.isEmpty()) {
            mzz();
            try {
                return Integer.parseInt(this.jpc.getProperty(str, String.valueOf(i)));
            } catch (NumberFormatException e) {
                aaj.qdl("SdkSettings.Prop", "", e);
            }
        }
        return i;
    }

    public long qdl(String str, long j) {
        if (str != null && !str.isEmpty()) {
            mzz();
            try {
                return Long.parseLong(this.jpc.getProperty(str, String.valueOf(j)));
            } catch (NumberFormatException e) {
                aaj.qdl("SdkSettings.Prop", "", e);
            }
        }
        return j;
    }

    public float qdl(String str, float f) {
        if (str != null && !str.isEmpty()) {
            mzz();
            try {
                return Float.parseFloat(this.jpc.getProperty(str, String.valueOf(f)));
            } catch (NumberFormatException e) {
                aaj.qdl("SdkSettings.Prop", "", e);
            }
        }
        return f;
    }

    public boolean qdl(String str, boolean z) {
        if (str != null && !str.isEmpty()) {
            mzz();
            try {
                return Boolean.parseBoolean(this.jpc.getProperty(str, String.valueOf(z)));
            } catch (Exception e) {
                aaj.qdl("SdkSettings.Prop", "", e);
            }
        }
        return z;
    }

    public void qdl(boolean z) {
        qdl qdlVar;
        Object obj;
        synchronized (this.mml) {
            if (!this.tvp || z) {
                if (yt.qdl() != null) {
                    boolean z2 = false;
                    this.rq = false;
                    File fileMo = mo();
                    if (fileMo != null && fileMo.exists()) {
                        Properties properties = new Properties();
                        FileInputStream fileInputStream = null;
                        try {
                            try {
                                FileInputStream fileInputStream2 = new FileInputStream(fileMo);
                                try {
                                    properties.load(fileInputStream2);
                                    Integer.valueOf(properties.size());
                                    new StringBuilder("items from ").append(fileMo.getAbsolutePath());
                                    if (!properties.isEmpty()) {
                                        this.jpc = properties;
                                        this.lnr.clear();
                                    }
                                    exu.qdl(fileInputStream2);
                                    obj = this.mml;
                                } catch (OutOfMemoryError unused) {
                                    fileInputStream = fileInputStream2;
                                    try {
                                        com.bytedance.sdk.component.utils.wd.lnr(fileMo);
                                    } catch (Throwable th) {
                                        aaj.qdl("SdkSettings.Prop", "delete: ", th);
                                    }
                                    if (fileInputStream != null) {
                                        exu.qdl(fileInputStream);
                                    }
                                    obj = this.mml;
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileInputStream = fileInputStream2;
                                    aaj.qdl("SdkSettings.Prop", "reload: ", th);
                                    if (fileInputStream != null) {
                                        exu.qdl(fileInputStream);
                                    }
                                    obj = this.mml;
                                }
                            } catch (OutOfMemoryError unused2) {
                            } catch (Throwable th3) {
                                th = th3;
                            }
                            obj.notifyAll();
                        } catch (Throwable th4) {
                            if (fileInputStream != null) {
                                exu.qdl(fileInputStream);
                            }
                            this.mml.notifyAll();
                            throw th4;
                        }
                    } else if (jyq.qdl(yt.qdl()) && "tt_sdk_settings.prop".equals(this.wd)) {
                        try {
                            SharedPreferences sharedPreferences = yt.qdl().getSharedPreferences("tt_sdk_settings", 0);
                            if (!sharedPreferences.getAll().isEmpty()) {
                                mzz.qdl qdlVarQdl = qdl();
                                for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                                    String key = entry.getKey();
                                    Object value = entry.getValue();
                                    if (key != null && !key.isEmpty() && value != null) {
                                        qdlVarQdl.qdl(key, value.toString());
                                        z2 = true;
                                    }
                                }
                                if (z2) {
                                    qdlVarQdl.qdl();
                                }
                                sharedPreferences.edit().clear().commit();
                            }
                        } catch (Exception unused3) {
                        }
                    }
                } else {
                    this.rq = true;
                }
                if (!this.tvp && (qdlVar = this.to) != null) {
                    qdlVar.qdl();
                }
                this.tvp = true;
                this.mo.countDown();
            }
        }
    }

    private File mo() {
        Context contextQdl = yt.qdl();
        if (contextQdl != null) {
            return new File(contextQdl.getFilesDir(), this.wd);
        }
        return null;
    }

    public mzz.qdl qdl() {
        return new ud();
    }

    public <T> T qdl(String str, T t, mzz.ud<T> udVar) {
        T tUd;
        if (str != null && !str.isEmpty()) {
            T t2 = (T) this.lnr.get(str);
            if (t2 != null) {
                return t2;
            }
            mzz();
            String property = this.jpc.getProperty(str, null);
            if (property != null && udVar != null && (tUd = udVar.ud(property)) != null) {
                this.lnr.put(str, tUd);
                return tUd;
            }
        }
        return t;
    }

    public boolean ud() {
        return this.tvp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(Properties properties) {
        synchronized (this.mzz) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(mo());
                    try {
                        properties.store(fileOutputStream2, (String) null);
                        exu.qdl(fileOutputStream2);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        aaj.qdl("SdkSettings.Prop", "saveToLocal: ", e);
                        if (fileOutputStream != null) {
                            exu.qdl(fileOutputStream);
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            exu.qdl(fileOutputStream);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        rq.ud();
    }

    public void lnr() {
        File fileMo = mo();
        if (fileMo == null || !fileMo.exists()) {
            return;
        }
        fileMo.delete();
    }

    public class ud implements mzz.qdl {
        private final Map<String, Object> ud = new HashMap();
        private final Object lnr = new Object();

        public ud() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.mzz.qdl
        public void qdl() {
            Object obj;
            Properties properties = new Properties();
            synchronized (this.lnr) {
                properties.putAll(to.this.jpc);
                boolean z = false;
                for (Map.Entry<String, Object> entry : this.ud.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (value == this || value == null) {
                        if (properties.containsKey(key)) {
                            properties.remove(key);
                            z = true;
                        }
                    } else if (!properties.containsKey(key) || (obj = properties.get(key)) == null || !obj.equals(value)) {
                        properties.put(key, String.valueOf(value));
                        z = true;
                    }
                }
                this.ud.clear();
                if (z) {
                    to.this.qdl(properties);
                    to.this.jpc = properties;
                    to.this.lnr.clear();
                    to.this.rq = false;
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.mzz.qdl
        public mzz.qdl qdl(String str, String str2) {
            synchronized (this.lnr) {
                this.ud.put(str, str2);
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.mzz.qdl
        public mzz.qdl qdl(String str, int i) {
            synchronized (this.lnr) {
                this.ud.put(str, Integer.valueOf(i));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.mzz.qdl
        public mzz.qdl qdl(String str, long j) {
            synchronized (this.lnr) {
                this.ud.put(str, Long.valueOf(j));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.mzz.qdl
        public mzz.qdl qdl(String str) {
            synchronized (this.lnr) {
                this.ud.put(str, this);
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.mzz.qdl
        public mzz.qdl qdl(String str, float f) {
            synchronized (this.lnr) {
                this.ud.put(str, Float.valueOf(f));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.mzz.qdl
        public mzz.qdl qdl(String str, boolean z) {
            synchronized (this.lnr) {
                this.ud.put(str, Boolean.valueOf(z));
            }
            return this;
        }
    }

    protected void mml() {
        qdl qdlVar = this.to;
        if (qdlVar != null) {
            qdlVar.ud();
        }
    }
}
