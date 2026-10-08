package com.apm.insight.e.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends a<com.apm.insight.d.a> {
    @Override // com.apm.insight.e.a.a
    protected final /* synthetic */ ContentValues a(com.apm.insight.d.a aVar) {
        com.apm.insight.d.a aVar2 = aVar;
        ContentValues contentValues = new ContentValues();
        contentValues.put("path", aVar2.f155a);
        contentValues.put("insert_time", Long.valueOf(aVar2.b));
        return contentValues;
    }

    public b() {
        super("duplicatelog");
    }

    public final boolean a(SQLiteDatabase sQLiteDatabase, String str) {
        int count;
        Cursor cursorQuery;
        if (sQLiteDatabase != null && !TextUtils.isEmpty(str)) {
            try {
                cursorQuery = sQLiteDatabase.query(this.f159a, null, "path=?", new String[]{str}, null, null, null);
                count = cursorQuery.getCount();
            } catch (Throwable th) {
                th = th;
                count = 0;
            }
            try {
                cursorQuery.close();
            } catch (Throwable th2) {
                th = th2;
                com.apm.insight.a.b(th);
            }
            if (count > 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.apm.insight.e.a.a
    public final void a(SQLiteDatabase sQLiteDatabase, com.apm.insight.d.a aVar) {
        if (aVar == null || a(sQLiteDatabase, aVar.f155a)) {
            return;
        }
        super.a(sQLiteDatabase, aVar);
        try {
            sQLiteDatabase.execSQL("delete from " + this.f159a + " where _id in (select _id from " + this.f159a + " order by insert_time desc limit 1000 offset 500)");
        } catch (Exception e) {
            com.apm.insight.a.b((Throwable) e);
        }
    }

    @Override // com.apm.insight.e.a.a
    protected final HashMap<String, String> a() {
        HashMap<String, String> map = new HashMap<>();
        map.put("path", "TEXT");
        map.put("insert_time", "INTEGER");
        map.put("ext1", "TEXT");
        map.put("ext2", "TEXT");
        return map;
    }
}
