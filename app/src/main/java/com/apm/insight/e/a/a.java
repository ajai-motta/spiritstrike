package com.apm.insight.e.a;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.apm.insight.c;
import com.apm.insight.runtime.j;
import io.ktor.sse.ServerSentEventKt;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f159a;
    private String b = "_id";

    protected abstract ContentValues a(T t);

    protected abstract HashMap<String, String> a();

    protected a(String str) {
        this.f159a = str;
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ");
            sb.append(this.f159a);
            sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap<String, String> mapA = a();
            for (String str : mapA.keySet()) {
                sb.append(str);
                sb.append(ServerSentEventKt.SPACE);
                sb.append(mapA.get(str));
                sb.append(",");
            }
            sb.delete(sb.length() - 1, sb.length());
            sb.append(")");
            sQLiteDatabase.execSQL(sb.toString());
        } catch (Throwable th) {
            c.a();
            j.a(th, "NPTH_CATCH");
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase, T t) {
        if (sQLiteDatabase == null || t == null) {
            return;
        }
        try {
            sQLiteDatabase.insert(this.f159a, null, a(t));
        } catch (Throwable th) {
            com.apm.insight.a.b(th);
        }
    }
}
