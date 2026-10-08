package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes3.dex */
public class mo {
    private static final Object lnr = new Object();
    private lnr qdl;
    private Context ud;

    mo(Context context) {
        try {
            this.ud = context == null ? yt.qdl() : context.getApplicationContext();
            if (this.qdl == null) {
                this.qdl = new lnr();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context lnr() {
        Context context = this.ud;
        return context == null ? yt.qdl() : context;
    }

    public class lnr {
        private SQLiteDatabase ud = null;

        public lnr() {
        }

        private synchronized void mzz() {
            try {
                synchronized (mo.lnr) {
                    SQLiteDatabase sQLiteDatabase = this.ud;
                    if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                        mo moVar = mo.this;
                        SQLiteDatabase writableDatabase = moVar.new qdl(moVar.lnr()).getWritableDatabase();
                        this.ud = writableDatabase;
                        writableDatabase.setLockingEnabled(false);
                    }
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.aaj.lnr("DBHelper", th.getMessage());
                if (mo()) {
                    throw th;
                }
            }
        }

        public SQLiteDatabase qdl() {
            mzz();
            return this.ud;
        }

        public synchronized void qdl(String str) throws SQLException {
            try {
                mzz();
                this.ud.execSQL(str);
            } catch (Throwable th) {
                if (mo()) {
                    throw th;
                }
            }
        }

        public synchronized Cursor qdl(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Cursor cursorQuery;
            try {
                mzz();
                cursorQuery = this.ud.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.aaj.lnr("DBHelper", th.getMessage());
                ud udVar = new ud();
                if (mo()) {
                    throw th;
                }
                cursorQuery = udVar;
            }
            return cursorQuery;
        }

        public synchronized int qdl(String str, ContentValues contentValues, String str2, String[] strArr) {
            int iUpdate;
            try {
                mzz();
                iUpdate = this.ud.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.aaj.lnr("DBHelper", e.getMessage());
                if (mo()) {
                    throw e;
                }
                iUpdate = 0;
            }
            return iUpdate;
        }

        public synchronized long qdl(String str, String str2, ContentValues contentValues) {
            long jReplace;
            try {
                mzz();
                jReplace = this.ud.replace(str, str2, contentValues);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.aaj.lnr("DBHelper", e.getMessage());
                if (mo()) {
                    throw e;
                }
                jReplace = -1;
            }
            return jReplace;
        }

        public synchronized int qdl(String str, String str2, String[] strArr) {
            int iDelete;
            try {
                mzz();
                iDelete = this.ud.delete(str, str2, strArr);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.aaj.lnr("DBHelper", e.getMessage());
                if (mo()) {
                    throw e;
                }
                iDelete = 0;
            }
            return iDelete;
        }

        public synchronized void ud() {
            mzz();
            SQLiteDatabase sQLiteDatabase = this.ud;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.beginTransaction();
        }

        public synchronized void lnr() {
            mzz();
            SQLiteDatabase sQLiteDatabase = this.ud;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.setTransactionSuccessful();
        }

        public synchronized void mml() {
            mzz();
            SQLiteDatabase sQLiteDatabase = this.ud;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.endTransaction();
        }

        private synchronized boolean mo() {
            SQLiteDatabase sQLiteDatabase = this.ud;
            if (sQLiteDatabase != null) {
                if (sQLiteDatabase.inTransaction()) {
                    return true;
                }
            }
            return false;
        }
    }

    private class qdl extends SQLiteOpenHelper {
        final Context qdl;

        public qdl(Context context) {
            super(context, "ttopensdk.db", (SQLiteDatabase.CursorFactory) null, 11);
            this.qdl = context;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                qdl(sQLiteDatabase, this.qdl);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.aaj.lnr("DBHelper", th.getMessage());
            }
        }

        private void qdl(SQLiteDatabase sQLiteDatabase, Context context) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.mml.mml.qdl());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.mml.to.lnr());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.mml.bjy.qdl());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.mml.rdp.qdl());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.bch.ud.qdl());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.mml.yt.lnr());
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.qdl.ud.ud.lnr());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.rq.qdl.lnr.lnr());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.mml.jtx.qdl());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i > i2) {
                try {
                    lnr(sQLiteDatabase);
                    qdl(sQLiteDatabase, mo.this.ud);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.aaj.lnr(th.getMessage(), new Object[0]);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002c A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0002, B:4:0x0005, B:5:0x000e, B:7:0x0012, B:8:0x0016, B:9:0x0021, B:10:0x002c, B:11:0x0037, B:12:0x0040), top: B:21:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0037 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0002, B:4:0x0005, B:5:0x000e, B:7:0x0012, B:8:0x0016, B:9:0x0021, B:10:0x002c, B:11:0x0037, B:12:0x0040), top: B:21:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0040 A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0002, B:4:0x0005, B:5:0x000e, B:7:0x0012, B:8:0x0016, B:9:0x0021, B:10:0x002c, B:11:0x0037, B:12:0x0040), top: B:21:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0011  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0012 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0002, B:4:0x0005, B:5:0x000e, B:7:0x0012, B:8:0x0016, B:9:0x0021, B:10:0x002c, B:11:0x0037, B:12:0x0040), top: B:21:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0016 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0002, B:4:0x0005, B:5:0x000e, B:7:0x0012, B:8:0x0016, B:9:0x0021, B:10:0x002c, B:11:0x0037, B:12:0x0040), top: B:21:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0021 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0002, B:4:0x0005, B:5:0x000e, B:7:0x0012, B:8:0x0016, B:9:0x0021, B:10:0x002c, B:11:0x0037, B:12:0x0040), top: B:21:0x0002 }] */
        @Override // android.database.sqlite.SQLiteOpenHelper
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onUpgrade(android.database.sqlite.SQLiteDatabase r1, int r2, int r3) {
            /*
                r0 = this;
                if (r2 <= r3) goto L5
                r0.lnr(r1)     // Catch: java.lang.Throwable -> L43
            L5:
                com.bytedance.sdk.openadsdk.core.mo r3 = com.bytedance.sdk.openadsdk.core.mo.this     // Catch: java.lang.Throwable -> L43
                android.content.Context r3 = com.bytedance.sdk.openadsdk.core.mo.ud(r3)     // Catch: java.lang.Throwable -> L43
                r0.qdl(r1, r3)     // Catch: java.lang.Throwable -> L43
                switch(r2) {
                    case 1: goto L40;
                    case 2: goto L37;
                    case 3: goto L2c;
                    case 4: goto L21;
                    case 5: goto L16;
                    case 6: goto L12;
                    default: goto L11;
                }     // Catch: java.lang.Throwable -> L43
            L11:
                goto L43
            L12:
                r0.qdl(r1)     // Catch: java.lang.Throwable -> L43
                goto L43
            L16:
                java.lang.String r3 = com.bytedance.sdk.openadsdk.mml.rdp.qdl()     // Catch: java.lang.Throwable -> L43
                r1.execSQL(r3)     // Catch: java.lang.Throwable -> L43
                r0.qdl(r1)     // Catch: java.lang.Throwable -> L43
                goto L43
            L21:
                java.lang.String r3 = com.bytedance.sdk.component.adexpress.qdl.ud.ud.lnr()     // Catch: java.lang.Throwable -> L43
                r1.execSQL(r3)     // Catch: java.lang.Throwable -> L43
                r0.qdl(r1)     // Catch: java.lang.Throwable -> L43
                goto L43
            L2c:
                java.lang.String r3 = com.bytedance.sdk.openadsdk.mml.bjy.qdl()     // Catch: java.lang.Throwable -> L43
                r1.execSQL(r3)     // Catch: java.lang.Throwable -> L43
                r0.qdl(r1)     // Catch: java.lang.Throwable -> L43
                goto L43
            L37:
                java.lang.String r3 = "DROP TABLE IF EXISTS 'ad_video_info';"
                r1.execSQL(r3)     // Catch: java.lang.Throwable -> L43
                r0.qdl(r1)     // Catch: java.lang.Throwable -> L43
                goto L43
            L40:
                r0.qdl(r1)     // Catch: java.lang.Throwable -> L43
            L43:
                r3 = 11
                if (r2 >= r3) goto L58
                r0.ud(r1)     // Catch: java.lang.Throwable -> L4e
                com.bytedance.sdk.openadsdk.bch.ud.qdl(r1)     // Catch: java.lang.Throwable -> L4e
                goto L58
            L4e:
                r1 = move-exception
                java.lang.String r2 = "DBHelper"
                java.lang.String r1 = r1.getMessage()
                com.bytedance.sdk.component.utils.aaj.lnr(r2, r1)
            L58:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.mo.qdl.onUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
        }

        private void qdl(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.mml.mml.ud());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.mml.to.mml());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.mml.bjy.ud());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.mml.rdp.ud());
        }

        private void ud(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.rq.qdl.lnr.mml());
        }

        private void lnr(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> arrayListMml = mml(sQLiteDatabase);
            if (arrayListMml == null || arrayListMml.size() <= 0) {
                return;
            }
            Iterator<String> it = arrayListMml.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0039 A[PHI: r1
  0x0039: PHI (r1v3 android.database.Cursor) = (r1v2 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:19:0x0037, B:13:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.util.ArrayList<java.lang.String> mml(android.database.sqlite.SQLiteDatabase r4) {
            /*
                r3 = this;
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                r1 = 0
                java.lang.String r2 = "select name from sqlite_master where type='table' order by name"
                android.database.Cursor r1 = r4.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L37
                if (r1 == 0) goto L2d
            Le:
                boolean r4 = r1.moveToNext()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L37
                if (r4 == 0) goto L2d
                r4 = 0
                java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L37
                java.lang.String r2 = "android_metadata"
                boolean r2 = r4.equals(r2)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L37
                if (r2 != 0) goto Le
                java.lang.String r2 = "sqlite_sequence"
                boolean r2 = r4.equals(r2)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L37
                if (r2 != 0) goto Le
                r0.add(r4)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L37
                goto Le
            L2d:
                if (r1 == 0) goto L3c
                goto L39
            L30:
                r4 = move-exception
                if (r1 == 0) goto L36
                r1.close()
            L36:
                throw r4
            L37:
                if (r1 == 0) goto L3c
            L39:
                r1.close()
            L3c:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.mo.qdl.mml(android.database.sqlite.SQLiteDatabase):java.util.ArrayList");
        }
    }

    public lnr qdl() {
        return this.qdl;
    }

    private class ud extends AbstractCursor {
        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i) {
            return true;
        }

        private ud() {
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }
    }
}
