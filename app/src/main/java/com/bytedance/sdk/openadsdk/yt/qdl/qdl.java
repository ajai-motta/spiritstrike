package com.bytedance.sdk.openadsdk.yt.qdl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.bytedance.sdk.component.utils.aaj;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class qdl extends SQLiteOpenHelper {
    private static volatile qdl ud;
    final Context qdl;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private static qdl lnr() {
        if (ud == null) {
            synchronized (qdl.class) {
                if (ud == null) {
                    ud = new qdl(com.bytedance.sdk.openadsdk.yt.qdl.qdl());
                }
            }
        }
        return ud;
    }

    public static SQLiteDatabase qdl() {
        try {
            qdl qdlVarLnr = lnr();
            if (qdlVarLnr == null) {
                return null;
            }
            SQLiteDatabase writableDatabase = qdlVarLnr.getWritableDatabase();
            if (writableDatabase.isOpen()) {
                return writableDatabase;
            }
            return null;
        } catch (Throwable th) {
            Log.i("MonitorSQLiteOpenHelper", th.getMessage());
            return null;
        }
    }

    public static SQLiteDatabase ud() {
        try {
            qdl qdlVarLnr = lnr();
            if (qdlVarLnr == null) {
                return null;
            }
            SQLiteDatabase readableDatabase = qdlVarLnr.getReadableDatabase();
            if (readableDatabase.isOpen()) {
                return readableDatabase;
            }
            return null;
        } catch (Throwable th) {
            Log.i("MonitorSQLiteOpenHelper", th.getMessage());
            return null;
        }
    }

    private qdl(Context context) {
        super(context, "pag_monitor.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.qdl = context;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS monitor_table (_id INTEGER PRIMARY KEY AUTOINCREMENT,sdk_version TEXT ,scene TEXT ,start_count INTEGER default 0 , success_count INTEGER default 0  , fail_count INTEGER default 0  , rit TEXT  , tag TEXT  , label TEXT  , timestamp INTEGER default 0 ,mediation TEXT  , is_init INTEGER , extra TEXT )");
        } catch (Throwable th) {
            Log.e("MonitorSQLiteOpenHelper", th.getMessage());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            if (i > i2) {
                qdl(sQLiteDatabase);
                onCreate(sQLiteDatabase);
            } else {
                onCreate(sQLiteDatabase);
            }
        } catch (Throwable unused) {
        }
    }

    private void qdl(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayListUd = ud(sQLiteDatabase);
        if (arrayListUd == null || arrayListUd.size() <= 0) {
            return;
        }
        Iterator<String> it = arrayListUd.iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
        }
    }

    private ArrayList<String> ud(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
            if (cursorRawQuery != null) {
                while (cursorRawQuery.moveToNext()) {
                    String string = cursorRawQuery.getString(0);
                    if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                        arrayList.add(string);
                    }
                }
                cursorRawQuery.close();
            }
        } catch (Exception e) {
            aaj.lnr("MonitorSQLiteOpenHelper", e.getMessage());
        }
        return arrayList;
    }
}
