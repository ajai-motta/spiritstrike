package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdr implements zzby {
    private static final String zza = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time");
    private final zzdq zzb;
    private volatile zzbf zzc;
    private final Context zzd;
    private final String zze;
    private long zzf;
    private final Clock zzg;
    private final int zzh;
    private final zzeu zzi;

    zzdr(zzeu zzeuVar, Context context) {
        Context applicationContext = context.getApplicationContext();
        this.zzd = applicationContext;
        this.zze = "gtm_urls.db";
        this.zzi = zzeuVar;
        this.zzg = DefaultClock.getInstance();
        this.zzb = new zzdq(this, applicationContext, "gtm_urls.db");
        this.zzc = new zzfd(applicationContext, new zzdp(this));
        this.zzf = 0L;
        this.zzh = 2000;
    }

    static /* synthetic */ void zzi(zzdr zzdrVar, long j, long j2) {
        SQLiteDatabase sQLiteDatabaseZzk = zzdrVar.zzk("Error opening database for getNumStoredHits.");
        if (sQLiteDatabaseZzk == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_first_send_time", Long.valueOf(j2));
        try {
            sQLiteDatabaseZzk.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
        } catch (SQLiteException unused) {
            Log.w("GoogleTagManager", "Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + j);
            zzdrVar.zzl(j);
        }
    }

    private final SQLiteDatabase zzk(String str) {
        try {
            return this.zzb.getWritableDatabase();
        } catch (SQLiteException unused) {
            Log.w("GoogleTagManager", str);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzl(long j) {
        zzj(new String[]{String.valueOf(j)});
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0138 A[Catch: all -> 0x00fc, TryCatch #13 {all -> 0x00fc, blocks: (B:21:0x00ad, B:24:0x00b4, B:26:0x00c1, B:28:0x00ec, B:27:0x00d0, B:47:0x0110, B:48:0x0132, B:50:0x0138, B:55:0x014c), top: B:114:0x00ad }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01a9  */
    @Override // com.google.android.gms.tagmanager.zzby
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 507
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzdr.zza():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bc A[PHI: r2
  0x00bc: PHI (r2v8 android.database.Cursor) = (r2v7 android.database.Cursor), (r2v9 android.database.Cursor) binds: [B:31:0x00ba, B:22:0x0099] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.database.Cursor] */
    @Override // com.google.android.gms.tagmanager.zzby
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzb(long r20, java.lang.String r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzdr.zzb(long, java.lang.String):void");
    }

    final int zzc() {
        SQLiteDatabase sQLiteDatabaseZzk = zzk("Error opening database for getNumStoredHits.");
        int i = 0;
        if (sQLiteDatabaseZzk == null) {
            return 0;
        }
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabaseZzk.rawQuery("SELECT COUNT(*) from gtm_hits", null);
                if (cursorRawQuery.moveToFirst()) {
                    i = (int) cursorRawQuery.getLong(0);
                }
            } catch (SQLiteException unused) {
                Log.w("GoogleTagManager", "Error getting numStoredHits");
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return i;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    final void zzj(String[] strArr) {
        int length;
        SQLiteDatabase sQLiteDatabaseZzk;
        if (strArr == null || (length = strArr.length) == 0 || (sQLiteDatabaseZzk = zzk("Error opening database for deleteHits.")) == null) {
            return;
        }
        boolean z = true;
        try {
            sQLiteDatabaseZzk.delete("gtm_hits", String.format("HIT_ID in (%s)", TextUtils.join(",", Collections.nCopies(length, "?"))), strArr);
            zzeu zzeuVar = this.zzi;
            if (zzc() != 0) {
                z = false;
            }
            zzeuVar.zza(z);
        } catch (SQLiteException unused) {
            Log.w("GoogleTagManager", "Error deleting hits");
        }
    }
}
