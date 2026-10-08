package com.bytedance.sdk.openadsdk.yt;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.bytedance.sdk.openadsdk.BusMonitorDependWrapper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    private static Context mzz;
    private com.bytedance.sdk.openadsdk.yt.lnr.qdl lnr;
    private Boolean mml;
    private ud ud;
    private static final long mo = System.currentTimeMillis();
    public static final long qdl = com.bytedance.sdk.openadsdk.yt.mml.qdl.qdl();
    private int wd = 0;
    private final ArrayList<mml> jpc = new ArrayList<>();
    private Runnable tvp = new Runnable() { // from class: com.bytedance.sdk.openadsdk.yt.qdl.2
        @Override // java.lang.Runnable
        public void run() {
            qdl qdlVar = qdl.this;
            qdlVar.mml = Boolean.valueOf(qdlVar.ud.isMonitorOpen());
            if (qdl.this.mml.booleanValue()) {
                qdl qdlVar2 = qdl.this;
                qdlVar2.qdl(qdlVar2.jpc);
                qdl.this.jpc.clear();
            }
        }
    };
    private Runnable to = new Runnable() { // from class: com.bytedance.sdk.openadsdk.yt.qdl.4
        @Override // java.lang.Runnable
        public void run() {
            String str;
            ArrayList arrayList;
            String str2 = "BusMonitorCenter";
            String str3 = "_id";
            try {
                SQLiteDatabase sQLiteDatabaseUd = com.bytedance.sdk.openadsdk.yt.qdl.qdl.ud();
                if (sQLiteDatabaseUd == null) {
                    return;
                }
                try {
                    String[] strArr = {"_id", "sdk_version", "scene", "start_count", "success_count", "fail_count", "rit", ViewHierarchyConstants.TAG_KEY, Constants.ScionAnalytics.PARAM_LABEL, "timestamp", "mediation", "is_init", "extra"};
                    String str4 = "extra";
                    String[] strArr2 = {String.valueOf(qdl.this.ud.getOnceLogInterval() < 86400000 ? qdl.mo : qdl.qdl)};
                    int iMax = Math.max(10, qdl.this.ud.getOnceLogCount());
                    if (iMax > 100) {
                        iMax = 10;
                    }
                    int i = iMax;
                    Cursor cursorQuery = sQLiteDatabaseUd.query("monitor_table", strArr, "timestamp < ?", strArr2, null, null, null, String.valueOf(iMax));
                    if (cursorQuery == null) {
                        return;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    while (cursorQuery.moveToNext()) {
                        try {
                            com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                            if (cursorQuery.getColumnIndex(str3) >= 0) {
                                arrayList = arrayList2;
                                str = str3;
                                long j = cursorQuery.getLong(cursorQuery.getColumnIndex(str3));
                                qdlVar.qdl(j);
                                arrayList3.add(String.valueOf(j));
                            } else {
                                str = str3;
                                arrayList = arrayList2;
                            }
                            if (cursorQuery.getColumnIndex("sdk_version") >= 0) {
                                qdlVar.qdl(cursorQuery.getString(cursorQuery.getColumnIndex("sdk_version")));
                            }
                            if (cursorQuery.getColumnIndex("scene") >= 0) {
                                qdlVar.ud(cursorQuery.getString(cursorQuery.getColumnIndex("scene")));
                            }
                            if (cursorQuery.getColumnIndex("start_count") >= 0) {
                                qdlVar.qdl(cursorQuery.getInt(cursorQuery.getColumnIndex("start_count")));
                            }
                            if (cursorQuery.getColumnIndex("success_count") >= 0) {
                                qdlVar.ud(cursorQuery.getInt(cursorQuery.getColumnIndex("success_count")));
                            }
                            if (cursorQuery.getColumnIndex("fail_count") >= 0) {
                                qdlVar.lnr(cursorQuery.getInt(cursorQuery.getColumnIndex("fail_count")));
                            }
                            if (cursorQuery.getColumnIndex("rit") >= 0) {
                                qdlVar.lnr(cursorQuery.getString(cursorQuery.getColumnIndex("rit")));
                            }
                            if (cursorQuery.getColumnIndex(ViewHierarchyConstants.TAG_KEY) >= 0) {
                                qdlVar.mml(cursorQuery.getString(cursorQuery.getColumnIndex(ViewHierarchyConstants.TAG_KEY)));
                            }
                            if (cursorQuery.getColumnIndex(Constants.ScionAnalytics.PARAM_LABEL) >= 0) {
                                qdlVar.mzz(cursorQuery.getString(cursorQuery.getColumnIndex(Constants.ScionAnalytics.PARAM_LABEL)));
                            }
                            if (cursorQuery.getColumnIndex("timestamp") >= 0) {
                                qdlVar.ud(cursorQuery.getLong(cursorQuery.getColumnIndex("timestamp")));
                            }
                            if (cursorQuery.getColumnIndex("mediation") >= 0) {
                                qdlVar.mo(cursorQuery.getString(cursorQuery.getColumnIndex("mediation")));
                            }
                            if (cursorQuery.getColumnIndex("is_init") >= 0) {
                                qdlVar.mml(cursorQuery.getInt(cursorQuery.getColumnIndex("is_init")));
                            }
                            String str5 = str4;
                            if (cursorQuery.getColumnIndex(str5) >= 0) {
                                qdlVar.wd(cursorQuery.getString(cursorQuery.getColumnIndex(str5)));
                            }
                            arrayList2 = arrayList;
                            arrayList2.add(qdlVar);
                            str4 = str5;
                            str3 = str;
                        } catch (Throwable th) {
                            th = th;
                        }
                    }
                    cursorQuery.close();
                    str2 = "BusMonitorCenter";
                    try {
                        Log.i(str2, "exec upload ...");
                        if (arrayList2.isEmpty()) {
                            return;
                        }
                        qdl.this.ud.onMonitorUpload(arrayList2);
                        SQLiteDatabase sQLiteDatabaseQdl = com.bytedance.sdk.openadsdk.yt.qdl.qdl.qdl();
                        if (sQLiteDatabaseQdl != null && sQLiteDatabaseQdl.isOpen()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("_id IN (");
                            for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                                sb.append("?");
                                if (i2 < arrayList3.size() - 1) {
                                    sb.append(",");
                                }
                            }
                            sb.append(")");
                            sQLiteDatabaseQdl.delete("monitor_table", sb.toString(), (String[]) arrayList3.toArray(new String[0]));
                            if (qdl.this.lnr != null) {
                                qdl.this.lnr.qdl(qdl.mo);
                            }
                        }
                        if (arrayList2.size() < i || qdl.this.wd > 1000) {
                            return;
                        }
                        qdl.this.qdl(false);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
                str2 = "BusMonitorCenter";
            } catch (Throwable th4) {
                th = th4;
            }
            Log.e(str2, th.getMessage());
        }
    };

    static /* synthetic */ int mml(qdl qdlVar) {
        int i = qdlVar.wd;
        qdlVar.wd = i + 1;
        return i;
    }

    private qdl(ud udVar) {
        try {
            this.ud = new BusMonitorDependWrapper(udVar);
            this.lnr = new com.bytedance.sdk.openadsdk.yt.lnr.qdl(udVar.getContext());
            mzz = udVar.getContext();
        } catch (Throwable th) {
            Log.e("BusMonitorCenter", th.getMessage());
        }
    }

    public static qdl qdl(ud udVar) {
        return new qdl(udVar);
    }

    public static Context qdl() {
        Context context = mzz;
        return context != null ? context : BusMonitorDependWrapper.getReflectContext();
    }

    public void qdl(final mml mmlVar) {
        if (mmlVar == null || !lnr()) {
            return;
        }
        this.ud.getHandler().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.yt.qdl.1
            @Override // java.lang.Runnable
            public void run() {
                qdl qdlVar = qdl.this;
                qdlVar.mml = Boolean.valueOf(qdlVar.ud.isMonitorOpen());
                if (qdl.this.mml.booleanValue()) {
                    qdl.this.jpc.add(mmlVar);
                    if (qdl.this.jpc.size() >= 10) {
                        qdl qdlVar2 = qdl.this;
                        qdlVar2.qdl(qdlVar2.jpc);
                        qdl.this.jpc.clear();
                    }
                }
            }
        });
        this.ud.getHandler().removeCallbacks(this.tvp);
        this.ud.getHandler().postDelayed(this.tvp, 5000L);
    }

    private boolean lnr() {
        if (this.mml == null) {
            ud udVar = this.ud;
            if (udVar != null && udVar.getContext() != null && this.ud.getHandler() != null) {
                return true;
            }
        } else {
            ud udVar2 = this.ud;
            if (udVar2 != null && udVar2.getContext() != null && this.ud.isMonitorOpen() && this.ud.getHandler() != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0212 A[Catch: all -> 0x0216, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x0216, blocks: (B:64:0x0212, B:79:0x0237), top: B:89:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0232  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void qdl(java.util.List<com.bytedance.sdk.openadsdk.yt.mml> r27) {
        /*
            Method dump skipped, instruction units count: 571
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.yt.qdl.qdl(java.util.List):void");
    }

    public void qdl(final boolean z) {
        ud udVar = this.ud;
        if (udVar == null || udVar.getHandler() == null || this.ud.getContext() == null || this.lnr == null || !this.ud.isMonitorOpen()) {
            return;
        }
        this.ud.getHandler().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.yt.qdl.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    qdl.mml(qdl.this);
                    if (z) {
                        long jQdl = qdl.this.lnr.qdl();
                        if (jQdl == 0) {
                            qdl.this.lnr.qdl(System.currentTimeMillis());
                            return;
                        } else if (com.bytedance.sdk.openadsdk.yt.mml.qdl.qdl(jQdl) && System.currentTimeMillis() - jQdl < qdl.this.ud.getUploadIntervalTime()) {
                            return;
                        }
                    }
                    if (qdl.this.ud.getHandler() != null) {
                        qdl.this.ud.getHandler().post(qdl.this.to);
                    }
                } catch (Throwable th) {
                    Log.e("BusMonitorCenter", th.getMessage());
                }
            }
        }, Math.max(this.ud.getOnceLogInterval(), 10000));
    }
}
