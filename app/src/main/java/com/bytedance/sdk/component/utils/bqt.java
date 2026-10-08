package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.autofill.HintConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class bqt {
    private static final Object qdl = new Object();
    private static final Map<qdl, Object> ud = new ConcurrentHashMap();
    private static AtomicBoolean lnr = new AtomicBoolean(false);
    private static volatile int mml = -1;
    private static volatile long mzz = 0;
    private static volatile int mo = 60000;
    private static exc wd = null;
    private static final AtomicBoolean jpc = new AtomicBoolean(false);

    public interface qdl {
        void qdl(Context context, Intent intent, boolean z, int i);
    }

    public static int qdl(Context context, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (mzz + j <= jElapsedRealtime) {
            return ud(context);
        }
        if (mml == -1) {
            return ud(context);
        }
        if (jElapsedRealtime - mzz >= mo) {
            ud(context, (Intent) null, false, false);
        }
        return mml;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ud(final Context context, final Intent intent, final boolean z, final boolean z2) {
        if (!z && z2) {
            mml = 0;
        } else if (jpc.compareAndSet(false, true)) {
            com.bytedance.sdk.component.jpc.mo.ud(new com.bytedance.sdk.component.jpc.jpc("getNetworkType") { // from class: com.bytedance.sdk.component.utils.bqt.1
                @Override // java.lang.Runnable
                public void run() {
                    int unused = bqt.mml = z2 ? 0 : bqt.ud(context);
                    bqt.jpc.set(false);
                    if (z) {
                        bqt.ud(context, intent, bqt.mml, z2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ud(Context context, Intent intent, int i, boolean z) {
        Map<qdl, Object> map = ud;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (qdl qdlVar : map.keySet()) {
            if (qdlVar != null) {
                try {
                    qdlVar.qdl(context, intent, !z, i);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int ud(Context context) {
        mml = lnr(context);
        mzz = SystemClock.elapsedRealtime();
        return mml;
    }

    private static int lnr(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    return type != 1 ? 1 : 4;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return 3;
                    case 13:
                    case 18:
                    case 19:
                        exc excVar = wd;
                        return (excVar == null || !excVar.qdl(context, telephonyManager)) ? 5 : 6;
                    case 20:
                        return 6;
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        return (TextUtils.isEmpty(subtypeName) || !(subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000"))) ? 1 : 3;
                }
            }
            return 0;
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static void qdl(qdl qdlVar, Context context) {
        if (qdlVar == null) {
            return;
        }
        if (!lnr.get()) {
            try {
                context.registerReceiver(new ud(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                lnr.set(true);
            } catch (Throwable unused) {
            }
        }
        ud.put(qdlVar, qdl);
    }

    public static void qdl(qdl qdlVar) {
        if (qdlVar == null) {
            return;
        }
        ud.remove(qdlVar);
    }

    private static class ud extends BroadcastReceiver {
        private ud() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                boolean z = false;
                boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
                if (bqt.ud != null && bqt.ud.size() > 0) {
                    z = true;
                }
                bqt.ud(context, intent, z, booleanExtra);
            } catch (Throwable unused) {
            }
        }
    }
}
