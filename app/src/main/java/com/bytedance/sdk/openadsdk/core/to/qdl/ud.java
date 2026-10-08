package com.bytedance.sdk.openadsdk.core.to.qdl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.util.ArrayMap;
import androidx.core.app.NotificationCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ud {
    private static volatile ud qdl;
    private final ArrayList<String> ud = new ArrayList<>();
    private final AtomicBoolean lnr = new AtomicBoolean(false);
    private long mml = System.currentTimeMillis();
    private long mzz = 0;
    private long mo = 0;
    private String wd = "";
    private String jpc = "";
    private String tvp = "";
    private boolean to = false;
    private boolean rq = false;

    public static ud qdl(Application application) {
        if (qdl == null) {
            synchronized (ud.class) {
                if (qdl == null) {
                    ud udVar = new ud();
                    qdl = udVar;
                    udVar.to = qdl((Context) application);
                    qdl.rq = qdl(application.getApplicationContext(), "android.permission.SYSTEM_ALERT_WINDOW") == 0;
                    qdl.qdl();
                }
            }
        }
        return qdl;
    }

    private static int qdl(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static boolean qdl(Context context) {
        ApplicationInfo applicationInfo;
        return (context == null || (applicationInfo = context.getApplicationInfo()) == null || (applicationInfo.flags & 1) <= 0) ? false : true;
    }

    public void qdl(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.ud.size() == 0) {
            this.wd = localClassName;
            this.mzz = System.currentTimeMillis();
            this.mo = System.currentTimeMillis() - this.mml;
            this.lnr.set(false);
        }
        if (!this.ud.contains(localClassName)) {
            this.ud.add(localClassName);
        }
        if (localClassName.contains("com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity") || localClassName.contains("com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity")) {
            return;
        }
        this.tvp = localClassName;
    }

    public void ud(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.ud.contains(localClassName)) {
            this.ud.remove(localClassName);
        }
        if (this.ud.size() == 0) {
            this.mml = System.currentTimeMillis();
            this.lnr.set(true);
            this.jpc = localClassName;
        }
    }

    private void qdl() {
        int size;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
            if (arrayMap != null && (size = arrayMap.size()) > 0) {
                Class<?> cls2 = Class.forName("android.app.ActivityThread$ActivityClientRecord");
                Field declaredField2 = cls2.getDeclaredField("stopped");
                declaredField2.setAccessible(true);
                Field declaredField3 = cls2.getDeclaredField("activity");
                declaredField3.setAccessible(true);
                for (int i = 0; i < size; i++) {
                    Object objValueAt = arrayMap.valueAt(i);
                    if (!((Boolean) declaredField2.get(objValueAt)).booleanValue()) {
                        String localClassName = ((Activity) declaredField3.get(objValueAt)).getLocalClassName();
                        if (!this.ud.contains(localClassName)) {
                            this.ud.add(localClassName);
                        }
                    }
                }
                this.lnr.set(this.ud.size() <= 0);
            }
        } catch (Throwable unused) {
        }
    }

    public String qdl(String str, long j, int i) {
        String string;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - this.mzz;
        long j3 = jCurrentTimeMillis - j;
        int i2 = j3 < 500 ? 1 : 0;
        if (this.lnr.get() && this.rq) {
            i2 |= 2;
        }
        if (!this.lnr.get() && this.mo >= 5000 && j2 < 1000) {
            i2 = this.jpc.equals(this.tvp) ? i2 | 4 : i2 | 8;
        }
        try {
            string = new JSONObject().put("rst", i2).put("adtag", str).put("bakdur", this.mo).put("rit", i).put("poptime", j2).put("unlocktime", j3).put("bakground", this.lnr).put("alert", this.rq).put(NotificationCompat.CATEGORY_SYSTEM, this.to).put("actsize", this.ud.size()).put("mutiproc", com.bytedance.sdk.openadsdk.multipro.ud.lnr()).toString();
        } catch (JSONException unused) {
            string = "";
        }
        this.wd = "";
        this.mo = 0L;
        this.mzz = 0L;
        this.mml = System.currentTimeMillis();
        return string;
    }
}
