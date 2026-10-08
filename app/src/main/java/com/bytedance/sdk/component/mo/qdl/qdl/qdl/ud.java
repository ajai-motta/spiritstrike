package com.bytedance.sdk.component.mo.qdl.qdl.qdl;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.component.mo.qdl.jpc;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class ud {
    private C0206ud qdl;
    private Context ud;

    ud(Context context) {
        try {
            this.ud = context.getApplicationContext();
            if (this.qdl == null) {
                this.qdl = new C0206ud();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.mo.qdl.qdl.qdl.ud$ud, reason: collision with other inner class name */
    public class C0206ud {
        private volatile SQLiteDatabase ud = null;

        public C0206ud() {
        }

        private void qdl() {
            try {
                if (this.ud != null && this.ud.isOpen()) {
                    return;
                }
                synchronized (this) {
                    if (this.ud == null || !this.ud.isOpen()) {
                        this.ud = jpc.wd().mml().qdl(jpc.wd().mo());
                        this.ud.setLockingEnabled(false);
                    }
                }
            } catch (Throwable th) {
                if (ud()) {
                    throw th;
                }
            }
        }

        public void qdl(String str) throws SQLException {
            try {
                qdl();
                this.ud.execSQL(str);
            } catch (Throwable th) {
                if (ud()) {
                    throw th;
                }
            }
        }

        public Cursor qdl(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            try {
                qdl();
                return this.ud.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                qdl qdlVar = new qdl();
                if (ud()) {
                    throw th;
                }
                return qdlVar;
            }
        }

        public int qdl(String str, ContentValues contentValues, String str2, String[] strArr) throws Exception {
            try {
                qdl();
                return this.ud.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                if (ud()) {
                    throw e;
                }
                return 0;
            }
        }

        public long qdl(String str, String str2, ContentValues contentValues) throws Exception {
            try {
                qdl();
                return this.ud.insert(str, str2, contentValues);
            } catch (Exception e) {
                if (ud()) {
                    throw e;
                }
                return -1L;
            }
        }

        public synchronized void qdl(String str, String str2, List<com.bytedance.sdk.component.mo.qdl.mml.qdl> list) {
            JSONObject jSONObjectWd;
            try {
                try {
                    qdl();
                    this.ud.beginTransaction();
                    ContentValues contentValues = new ContentValues();
                    for (int i = 0; i < list.size(); i++) {
                        com.bytedance.sdk.component.mo.qdl.mml.qdl qdlVar = list.get(i);
                        if (qdlVar != null && (jSONObjectWd = qdlVar.wd()) != null) {
                            contentValues.put("id", qdlVar.lnr());
                            String strUd = jpc.wd().jtx().ud(jSONObjectWd.toString());
                            if (!TextUtils.isEmpty(strUd)) {
                                contentValues.put("value", strUd);
                                contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
                                contentValues.put("retry", (Integer) 0);
                                contentValues.put("encrypt", (Integer) 1);
                                if (com.bytedance.sdk.component.mo.qdl.lnr.qdl.mml() && qdlVar.to() > 0 && (qdlVar.mml() == 0 || qdlVar.mml() == 3)) {
                                    contentValues.put("channel", Integer.valueOf(qdlVar.to()));
                                }
                                this.ud.insert(str, str2, contentValues);
                            }
                            contentValues.clear();
                        }
                    }
                    this.ud.setTransactionSuccessful();
                    list.size();
                } finally {
                    if (this.ud != null) {
                        this.ud.endTransaction();
                    }
                }
            } catch (Exception e) {
                list.size();
                if (ud()) {
                    throw e;
                }
                if (this.ud != null) {
                    this.ud.endTransaction();
                }
            }
        }

        public int qdl(String str, String str2, String[] strArr) throws Exception {
            try {
                qdl();
                return this.ud.delete(str, str2, strArr);
            } catch (Exception e) {
                if (ud()) {
                    throw e;
                }
                return 0;
            }
        }

        private boolean ud() {
            SQLiteDatabase sQLiteDatabase = this.ud;
            return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
        }
    }

    public C0206ud qdl() {
        return this.qdl;
    }

    private class qdl extends AbstractCursor {
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

        private qdl() {
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }
    }
}
