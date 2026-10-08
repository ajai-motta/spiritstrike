package com.bytedance.sdk.component.adexpress.qdl.ud;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class mo {
    public static int qdl = 20;
    private static volatile mo ud;
    private volatile ConcurrentHashMap<String, com.bytedance.sdk.component.adexpress.qdl.lnr.lnr> mzz;
    private final Object mml = new Object();
    private AtomicBoolean mo = new AtomicBoolean(false);
    private LruCache<String, com.bytedance.sdk.component.adexpress.qdl.lnr.ud> wd = new LruCache<String, com.bytedance.sdk.component.adexpress.qdl.lnr.ud>(qdl) { // from class: com.bytedance.sdk.component.adexpress.qdl.ud.mo.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, com.bytedance.sdk.component.adexpress.qdl.lnr.ud udVar) {
            return 1;
        }
    };
    private Set<String> lnr = Collections.synchronizedSet(new HashSet());

    public static void qdl(int i) {
        qdl = i;
    }

    public static mo qdl() {
        if (ud == null) {
            synchronized (mo.class) {
                if (ud == null) {
                    ud = new mo();
                }
            }
        }
        return ud;
    }

    private mo() {
    }

    com.bytedance.sdk.component.adexpress.qdl.lnr.ud qdl(String str) {
        com.bytedance.sdk.component.adexpress.qdl.lnr.ud udVar;
        com.bytedance.sdk.component.adexpress.qdl.lnr.ud udVarQdl;
        if (TextUtils.isEmpty(str) || com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().ud() == null) {
            return null;
        }
        synchronized (this.mml) {
            udVar = this.wd.get(String.valueOf(str));
        }
        if (udVar != null) {
            return udVar;
        }
        Cursor cursorQdl = com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().ud().qdl("template_diff_new", null, "id=?", new String[]{str}, null, null, null);
        if (cursorQdl != null) {
            try {
                if (cursorQdl.moveToFirst()) {
                    do {
                        String string = cursorQdl.getString(cursorQdl.getColumnIndex("rit"));
                        String string2 = cursorQdl.getString(cursorQdl.getColumnIndex("id"));
                        String string3 = cursorQdl.getString(cursorQdl.getColumnIndex("md5"));
                        String string4 = cursorQdl.getString(cursorQdl.getColumnIndex("url"));
                        String string5 = cursorQdl.getString(cursorQdl.getColumnIndex("data"));
                        String string6 = cursorQdl.getString(cursorQdl.getColumnIndex("version"));
                        udVarQdl = new com.bytedance.sdk.component.adexpress.qdl.lnr.ud().qdl(string).ud(string2).lnr(string3).mml(string4).mzz(string5).mo(string6).qdl(Long.valueOf(cursorQdl.getLong(cursorQdl.getColumnIndex("update_time"))));
                        synchronized (this.mml) {
                            this.wd.put(string2, udVarQdl);
                        }
                        this.lnr.add(string2);
                    } while (cursorQdl.moveToNext());
                    cursorQdl.close();
                    return udVarQdl;
                }
            } catch (Throwable unused) {
            }
            cursorQdl.close();
        }
        return null;
    }

    Set<String> ud(String str) {
        if (!TextUtils.isEmpty(str) && com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().ud() != null) {
            HashSet hashSet = new HashSet();
            Cursor cursorQdl = com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().ud().qdl("template_diff_new", null, "rit=?", new String[]{str}, null, null, null);
            try {
                if (cursorQdl != null) {
                    try {
                        if (cursorQdl.moveToFirst()) {
                            do {
                                hashSet.add(cursorQdl.getString(cursorQdl.getColumnIndex("id")));
                            } while (cursorQdl.moveToNext());
                            return hashSet;
                        }
                    } catch (Exception e) {
                        Log.e("TmplDbHelper", "", e);
                    }
                }
            } finally {
                cursorQdl.close();
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.util.List<com.bytedance.sdk.component.adexpress.qdl.lnr.ud> ud() {
        /*
            Method dump skipped, instruction units count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.qdl.ud.mo.ud():java.util.List");
    }

    void qdl(com.bytedance.sdk.component.adexpress.qdl.lnr.ud udVar, boolean z) {
        if (udVar == null || com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().ud() == null || TextUtils.isEmpty(udVar.ud())) {
            return;
        }
        Cursor cursorQdl = com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().ud().qdl("template_diff_new", null, "id=?", new String[]{udVar.ud()}, null, null, null);
        boolean z2 = cursorQdl != null && cursorQdl.getCount() > 0;
        if (cursorQdl != null) {
            try {
                string = cursorQdl.moveToFirst() ? cursorQdl.getString(cursorQdl.getColumnIndex("rit")) : null;
                cursorQdl.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", udVar.qdl());
        contentValues.put("id", udVar.ud());
        contentValues.put("md5", udVar.lnr());
        contentValues.put("url", udVar.mml());
        contentValues.put("data", udVar.mzz());
        contentValues.put("version", udVar.mo());
        contentValues.put("update_time", udVar.wd());
        if (z2) {
            com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().ud().qdl("template_diff_new", contentValues, "id=?", new String[]{udVar.ud()});
        } else {
            com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().ud().qdl("template_diff_new", contentValues);
        }
        synchronized (this.mml) {
            this.wd.put(udVar.ud(), udVar);
        }
        this.lnr.add(udVar.ud());
        if (z) {
            return;
        }
        try {
            if (com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().mo() == null) {
                return;
            }
            if (this.mzz == null) {
                this.mzz = new ConcurrentHashMap<>();
            }
            com.bytedance.sdk.component.adexpress.qdl.lnr.lnr lnrVar = new com.bytedance.sdk.component.adexpress.qdl.lnr.lnr(udVar.qdl(), udVar.ud(), udVar.lnr());
            this.mzz.put(udVar.ud(), lnrVar);
            if (string != null) {
                com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().mo();
                lnrVar.ud();
            }
            com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().mo();
            udVar.qdl();
        } catch (Throwable unused2) {
        }
    }

    void qdl(Set<String> set) {
        if (set == null || set.isEmpty() || com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().ud() == null) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                mml(strArr[i]);
                com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().ud().qdl("template_diff_new", "id=?", new String[]{strArr[i]});
                lnr(strArr[i]);
            }
        }
    }

    void lnr(String str) {
        com.bytedance.sdk.component.adexpress.qdl.lnr.lnr lnrVar;
        try {
            if (this.mzz == null || this.mzz.isEmpty() || (lnrVar = this.mzz.get(str)) == null) {
                return;
            }
            if (!TextUtils.isEmpty(lnrVar.qdl()) && com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().mo() != null) {
                com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().mo();
            }
            this.mzz.remove(str);
        } catch (Throwable unused) {
        }
    }

    private void mml(String str) {
        LruCache<String, com.bytedance.sdk.component.adexpress.qdl.lnr.ud> lruCache;
        if (TextUtils.isEmpty(str) || (lruCache = this.wd) == null || lruCache.size() <= 0) {
            return;
        }
        synchronized (this.mml) {
            this.wd.remove(str);
        }
    }

    public static String lnr() {
        return "CREATE TABLE IF NOT EXISTS template_diff_new (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , version TEXT , update_time TEXT)";
    }
}
