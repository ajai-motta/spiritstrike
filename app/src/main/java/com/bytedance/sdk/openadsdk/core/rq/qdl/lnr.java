package com.bytedance.sdk.openadsdk.core.rq.qdl;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.openadsdk.core.yt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class lnr {
    public static int qdl = 20;
    private static volatile lnr ud;
    private final Object lnr = new Object();
    private final LruCache<String, qdl> mml = new LruCache<String, qdl>(qdl) { // from class: com.bytedance.sdk.openadsdk.core.rq.qdl.lnr.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, qdl qdlVar) {
            return 1;
        }
    };

    private lnr() {
    }

    public static lnr qdl() {
        if (ud == null) {
            synchronized (lnr.class) {
                if (ud == null) {
                    ud = new lnr();
                }
            }
        }
        return ud;
    }

    qdl qdl(String str, String str2) {
        qdl qdlVar;
        qdl qdlVarQdl;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.lnr) {
            qdlVar = this.mml.get(str);
        }
        if (qdlVar != null) {
            if (TextUtils.equals(str2, qdlVar.ud())) {
                return qdlVar;
            }
            ud(str2);
            return null;
        }
        com.bytedance.sdk.openadsdk.multipro.aidl.lnr lnrVar = new com.bytedance.sdk.openadsdk.multipro.aidl.lnr(com.bytedance.sdk.openadsdk.multipro.qdl.qdl.qdl(yt.qdl(), "ugen_template", null, "id=? AND md5=?", new String[]{str, str2}, null, null, null));
        try {
            if (lnrVar.moveToFirst()) {
                do {
                    int columnIndex = lnrVar.getColumnIndex("id");
                    int columnIndex2 = lnrVar.getColumnIndex("md5");
                    int columnIndex3 = lnrVar.getColumnIndex("url");
                    int columnIndex4 = lnrVar.getColumnIndex("data");
                    int columnIndex5 = lnrVar.getColumnIndex("update_time");
                    if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                        int columnIndex6 = lnrVar.getColumnIndex("rit");
                        String string = lnrVar.getString(columnIndex);
                        String string2 = lnrVar.getString(columnIndex2);
                        String string3 = lnrVar.getString(columnIndex3);
                        String string4 = lnrVar.getString(columnIndex4);
                        if (TextUtils.isEmpty(string4)) {
                            return null;
                        }
                        qdlVarQdl = new qdl().qdl(string).ud(string2).mml(string4).lnr(string3).mzz(columnIndex6 != -1 ? lnrVar.getString(columnIndex6) : null).qdl(Long.valueOf(lnrVar.getLong(columnIndex5)));
                        synchronized (this.lnr) {
                            this.mml.put(string, qdlVarQdl);
                        }
                    }
                    return null;
                } while (lnrVar.moveToNext());
                return qdlVarQdl;
            }
        } finally {
            try {
                return null;
            } finally {
            }
        }
        return null;
    }

    void qdl(qdl qdlVar) {
        if (qdlVar == null || TextUtils.isEmpty(qdlVar.qdl())) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.aidl.lnr lnrVar = new com.bytedance.sdk.openadsdk.multipro.aidl.lnr(com.bytedance.sdk.openadsdk.multipro.qdl.qdl.qdl(yt.qdl(), "ugen_template", null, "id=?", new String[]{qdlVar.qdl()}, null, null, null));
        boolean z = lnrVar.getCount() > 0;
        try {
            lnrVar.close();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", qdlVar.qdl());
            contentValues.put("md5", qdlVar.ud());
            contentValues.put("url", qdlVar.lnr());
            contentValues.put("data", qdlVar.mzz());
            contentValues.put("rit", qdlVar.mo());
            contentValues.put("update_time", qdlVar.mml());
            if (z) {
                com.bytedance.sdk.openadsdk.multipro.qdl.qdl.qdl(yt.qdl(), "ugen_template", contentValues, "id=?", new String[]{qdlVar.qdl()});
            } else {
                com.bytedance.sdk.openadsdk.multipro.qdl.qdl.qdl(yt.qdl(), "ugen_template", contentValues);
            }
            synchronized (this.lnr) {
                this.mml.put(qdlVar.qdl(), qdlVar);
            }
        } catch (Throwable unused) {
        }
    }

    List<qdl> ud() {
        ArrayList arrayList = new ArrayList();
        com.bytedance.sdk.openadsdk.multipro.aidl.lnr lnrVar = new com.bytedance.sdk.openadsdk.multipro.aidl.lnr(com.bytedance.sdk.openadsdk.multipro.qdl.qdl.qdl(yt.qdl(), "ugen_template", null, null, null, null, null, null));
        try {
            if (lnrVar.moveToFirst()) {
                do {
                    int columnIndex = lnrVar.getColumnIndex("id");
                    int columnIndex2 = lnrVar.getColumnIndex("md5");
                    int columnIndex3 = lnrVar.getColumnIndex("url");
                    int columnIndex4 = lnrVar.getColumnIndex("data");
                    int columnIndex5 = lnrVar.getColumnIndex("update_time");
                    if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                        int columnIndex6 = lnrVar.getColumnIndex("rit");
                        String string = columnIndex6 != -1 ? lnrVar.getString(columnIndex6) : null;
                        String string2 = lnrVar.getString(columnIndex);
                        String string3 = lnrVar.getString(columnIndex2);
                        String string4 = lnrVar.getString(columnIndex3);
                        qdl qdlVarQdl = new qdl().qdl(string2).ud(string3).lnr(string4).mml(lnrVar.getString(columnIndex4)).mzz(string).qdl(Long.valueOf(lnrVar.getLong(columnIndex5)));
                        arrayList.add(qdlVarQdl);
                        synchronized (this.lnr) {
                            this.mml.put(string2, qdlVarQdl);
                        }
                    }
                } while (lnrVar.moveToNext());
            }
        } finally {
            try {
            } finally {
            }
        }
        return arrayList;
    }

    Set<qdl> qdl(String str) {
        qdl qdlVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        com.bytedance.sdk.openadsdk.multipro.aidl.lnr lnrVar = new com.bytedance.sdk.openadsdk.multipro.aidl.lnr(com.bytedance.sdk.openadsdk.multipro.qdl.qdl.qdl(yt.qdl(), "ugen_template", null, "rit=?", new String[]{str}, null, null, null));
        try {
            if (lnrVar.moveToFirst()) {
                do {
                    int columnIndex = lnrVar.getColumnIndex("id");
                    if (columnIndex != -1) {
                        String string = lnrVar.getString(columnIndex);
                        if (!TextUtils.isEmpty(string)) {
                            synchronized (this.lnr) {
                                qdlVar = this.mml.get(string);
                            }
                            if (qdlVar != null) {
                                hashSet.add(qdlVar);
                            } else {
                                qdl qdlVar2 = new qdl();
                                int columnIndex2 = lnrVar.getColumnIndex("data");
                                if (columnIndex2 != -1) {
                                    String string2 = lnrVar.getString(columnIndex2);
                                    if (!TextUtils.isEmpty(string2)) {
                                        qdlVar2.mml(string2);
                                        qdlVar2.qdl(string);
                                        qdlVar2.mzz(str);
                                        int columnIndex3 = lnrVar.getColumnIndex("md5");
                                        int columnIndex4 = lnrVar.getColumnIndex("url");
                                        int columnIndex5 = lnrVar.getColumnIndex("update_time");
                                        if (columnIndex3 != -1) {
                                            qdlVar2.ud(lnrVar.getString(columnIndex3));
                                        }
                                        if (columnIndex4 != -1) {
                                            qdlVar2.lnr(lnrVar.getString(columnIndex4));
                                        }
                                        if (columnIndex5 != -1) {
                                            qdlVar2.qdl(Long.valueOf(lnrVar.getLong(columnIndex5)));
                                        }
                                        hashSet.add(qdlVar2);
                                        synchronized (this.lnr) {
                                            this.mml.put(string, qdlVar2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } while (lnrVar.moveToNext());
            }
        } finally {
            try {
            } finally {
            }
        }
        return hashSet;
    }

    void qdl(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (String str : strArr) {
                ud(str);
                com.bytedance.sdk.openadsdk.multipro.qdl.qdl.qdl(yt.qdl(), "ugen_template", "id=?", new String[]{str});
            }
        }
    }

    private void ud(String str) {
        if (!TextUtils.isEmpty(str) && this.mml.size() > 0) {
            synchronized (this.lnr) {
                this.mml.remove(str);
            }
        }
    }

    public static String lnr() {
        return "CREATE TABLE IF NOT EXISTS ugen_template (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , rit TEXT , update_time TEXT)";
    }

    public static String mml() {
        return "ALTER TABLE ugen_template ADD COLUMN rit TEXT ";
    }
}
