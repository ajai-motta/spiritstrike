package com.bytedance.sdk.component.jpc;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.utils.bjy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class mml {
    private static AtomicInteger lnr = new AtomicInteger(0);
    public static final String[] qdl = {"com.bytedance.sdk", "com.bykv.vk", "com.ss", "tt_pangle"};
    public static final String[] ud = {"tt_pangle", "bd_tracker"};
    private static int mml = 0;
    private static int mzz = 0;

    public static void qdl() {
        try {
            ud();
        } catch (Throwable unused) {
        }
    }

    private static void ud() {
        int i;
        String str;
        lnr lnrVarTvp = mo.tvp();
        if (lnrVarTvp == null) {
            return;
        }
        int i2 = 1;
        int iAddAndGet = lnr.addAndGet(1);
        if (mo.lnr < 0 || iAddAndGet % mo.lnr != 0 || Looper.getMainLooper() == Looper.myLooper()) {
            return;
        }
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        HashMap map = new HashMap();
        if (allStackTraces == null) {
            return;
        }
        boolean zQdl = bjy.qdl();
        int size = allStackTraces.size();
        if (size > mzz) {
            mzz = size;
        }
        Iterator<Map.Entry<Thread, StackTraceElement[]>> it = allStackTraces.entrySet().iterator();
        int i3 = 0;
        int i4 = 0;
        while (it.hasNext()) {
            Map.Entry<Thread, StackTraceElement[]> next = it.next();
            i4 += i2;
            Thread key = next.getKey();
            StackTraceElement[] value = next.getValue();
            StringBuilder sb = new StringBuilder("\n");
            if (zQdl) {
                sb.append("Thread Name is : " + key.getName());
                sb.append("\n");
            }
            int length = value.length;
            String str2 = null;
            int i5 = 0;
            while (i5 < length) {
                String string = value[i5].toString();
                Iterator<Map.Entry<Thread, StackTraceElement[]>> it2 = it;
                if (zQdl) {
                    sb.append(string + "\n");
                }
                if (TextUtils.isEmpty(str2)) {
                    if (qdl(string, qdl)) {
                        str = string;
                    } else {
                        str = string;
                        if (qdl(key.getName(), ud)) {
                        }
                    }
                    i3++;
                    str2 = str;
                }
                i5++;
                it = it2;
            }
            Iterator<Map.Entry<Thread, StackTraceElement[]>> it3 = it;
            if (zQdl) {
                if (TextUtils.isEmpty(str2)) {
                    i = 1;
                } else {
                    String str3 = str2 + "&" + key.getName();
                    qdl qdlVar = (qdl) map.get(str3);
                    if (qdlVar != null) {
                        i = 1;
                        qdlVar.qdl(qdlVar.qdl() + 1);
                    } else {
                        i = 1;
                        qdlVar = new qdl(str3, 1, sb.toString(), key.getName());
                    }
                    map.put(str3, qdlVar);
                }
                if (!TextUtils.isEmpty(sb.toString())) {
                    Log.e("PoolTaskStatistics", "Thread index = " + i4 + "   &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    Log.w("PoolTaskStatistics", sb.toString());
                }
            } else {
                i = 1;
            }
            i2 = i;
            it = it3;
        }
        if (i3 > mml) {
            mml = i3;
        }
        if (zQdl) {
            Log.e("PoolTaskStatistics", "SDK current threads=" + i3 + ", SDK Max threads=" + mml + ", Application threads = " + size + ", Application max threads = " + mzz);
            Iterator it4 = map.entrySet().iterator();
            while (it4.hasNext()) {
                Log.i("PoolTaskStatistics", ((qdl) ((Map.Entry) it4.next()).getValue()).toString());
            }
        }
        lnrVarTvp.qdl(new com.bytedance.sdk.component.jpc.ud.qdl(i3, mml, size, mzz));
    }

    private static boolean qdl(String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null) {
            for (String str2 : strArr) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static class qdl {
        public String lnr;
        public String mml;
        public int qdl;
        public String ud;

        public qdl(String str, int i, String str2, String str3) {
            this.lnr = str;
            this.qdl = i;
            this.mml = str2;
            this.ud = str3;
        }

        public void qdl(int i) {
            this.qdl = i;
        }

        public int qdl() {
            return this.qdl;
        }

        public String toString() {
            return "ThreadModel{times=" + this.qdl + ", name='" + this.ud + "', lastStackStack='" + this.lnr + "'}";
        }
    }
}
