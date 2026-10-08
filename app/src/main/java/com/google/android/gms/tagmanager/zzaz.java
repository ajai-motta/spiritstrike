package com.google.android.gms.tagmanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.gtm.zzfx;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaz implements zzas {
    private static final String zza = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", "datalayer", "ID", "key", "value", "expires");
    private final Executor zzb;
    private final Context zzc;
    private final zzax zzd;
    private final Clock zze;

    public zzaz(Context context) {
        Clock defaultClock = DefaultClock.getInstance();
        ExecutorService executorServiceZza = zzfx.zza().zza(2);
        this.zzc = context;
        this.zze = defaultClock;
        this.zzb = executorServiceZza;
        this.zzd = new zzax(this, context, "google_tagmanager.db");
    }

    static /* bridge */ /* synthetic */ List zzf(zzaz zzazVar) {
        ObjectInputStream objectInputStream;
        try {
            zzazVar.zzk(zzazVar.zze.currentTimeMillis());
            SQLiteDatabase sQLiteDatabaseZzi = zzazVar.zzi("Error opening database for loadSerialized.");
            ArrayList<zzay> arrayList = new ArrayList();
            if (sQLiteDatabaseZzi != null) {
                Cursor cursorQuery = sQLiteDatabaseZzi.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
                while (cursorQuery.moveToNext()) {
                    try {
                        arrayList.add(new zzay(cursorQuery.getString(0), cursorQuery.getBlob(1)));
                    } finally {
                        cursorQuery.close();
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (zzay zzayVar : arrayList) {
                String str = zzayVar.zza;
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(zzayVar.zzb);
                ObjectInputStream objectInputStream2 = null;
                object = null;
                object = null;
                object = null;
                Object object = null;
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                } catch (IOException unused) {
                    objectInputStream = null;
                } catch (ClassNotFoundException unused2) {
                    objectInputStream = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    object = objectInputStream.readObject();
                } catch (IOException unused3) {
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                } catch (ClassNotFoundException unused4) {
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    objectInputStream2 = objectInputStream;
                    if (objectInputStream2 != null) {
                        try {
                            objectInputStream2.close();
                        } catch (IOException unused5) {
                            throw th;
                        }
                    }
                    byteArrayInputStream.close();
                    throw th;
                }
                try {
                    objectInputStream.close();
                    byteArrayInputStream.close();
                } catch (IOException unused6) {
                }
                arrayList2.add(new zzap(str, object));
            }
            return arrayList2;
        } finally {
            zzazVar.zzj();
        }
    }

    static /* synthetic */ void zzg(zzaz zzazVar, String str) {
        SQLiteDatabase sQLiteDatabaseZzi = zzazVar.zzi("Error opening database for clearKeysWithPrefix.");
        try {
            if (sQLiteDatabaseZzi == null) {
                return;
            }
            zzdc.zzb.zzd("Cleared " + sQLiteDatabaseZzi.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, str + ".%"}) + " items");
        } catch (SQLiteException e) {
            Log.w("GoogleTagManager", "Error deleting entries with key prefix: " + str + " (" + e.toString() + ").");
        } finally {
            zzazVar.zzj();
        }
    }

    private final SQLiteDatabase zzi(String str) {
        try {
            return this.zzd.getWritableDatabase();
        } catch (SQLiteException unused) {
            Log.w("GoogleTagManager", str);
            return null;
        }
    }

    private final void zzj() {
        try {
            this.zzd.close();
        } catch (SQLiteException unused) {
        }
    }

    private final void zzk(long j) {
        SQLiteDatabase sQLiteDatabaseZzi = zzi("Error opening database for deleteOlderThan.");
        if (sQLiteDatabaseZzi == null) {
            return;
        }
        try {
            zzdc.zzb.zzd("Deleted " + sQLiteDatabaseZzi.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
        } catch (SQLiteException unused) {
            Log.w("GoogleTagManager", "Error deleting old entries.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004b A[Catch: all -> 0x017d, TRY_LEAVE, TryCatch #10 {all -> 0x017d, blocks: (B:4:0x0003, B:23:0x0046, B:25:0x004b, B:51:0x00c1, B:53:0x00ea, B:56:0x00ee, B:58:0x00f6, B:59:0x0111, B:61:0x0117, B:37:0x0096, B:65:0x012f, B:66:0x0132, B:67:0x0133, B:70:0x013e, B:71:0x0142, B:73:0x0148, B:15:0x0031, B:22:0x0042, B:81:0x0179, B:82:0x017c), top: B:92:0x0003, outer: #2, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0096 A[Catch: all -> 0x017d, PHI: r7 r8
  0x0096: PHI (r7v14 char) = (r7v13 char), (r7v15 char) binds: [B:49:0x00be, B:36:0x0094] A[DONT_GENERATE, DONT_INLINE]
  0x0096: PHI (r8v8 android.database.Cursor) = (r8v7 android.database.Cursor), (r8v9 android.database.Cursor) binds: [B:49:0x00be, B:36:0x0094] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #10 {all -> 0x017d, blocks: (B:4:0x0003, B:23:0x0046, B:25:0x004b, B:51:0x00c1, B:53:0x00ea, B:56:0x00ee, B:58:0x00f6, B:59:0x0111, B:61:0x0117, B:37:0x0096, B:65:0x012f, B:66:0x0132, B:67:0x0133, B:70:0x013e, B:71:0x0142, B:73:0x0148, B:15:0x0031, B:22:0x0042, B:81:0x0179, B:82:0x017c), top: B:92:0x0003, outer: #2, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x012f A[Catch: all -> 0x017d, TryCatch #10 {all -> 0x017d, blocks: (B:4:0x0003, B:23:0x0046, B:25:0x004b, B:51:0x00c1, B:53:0x00ea, B:56:0x00ee, B:58:0x00f6, B:59:0x0111, B:61:0x0117, B:37:0x0096, B:65:0x012f, B:66:0x0132, B:67:0x0133, B:70:0x013e, B:71:0x0142, B:73:0x0148, B:15:0x0031, B:22:0x0042, B:81:0x0179, B:82:0x017c), top: B:92:0x0003, outer: #2, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x013e A[Catch: all -> 0x017d, TryCatch #10 {all -> 0x017d, blocks: (B:4:0x0003, B:23:0x0046, B:25:0x004b, B:51:0x00c1, B:53:0x00ea, B:56:0x00ee, B:58:0x00f6, B:59:0x0111, B:61:0x0117, B:37:0x0096, B:65:0x012f, B:66:0x0132, B:67:0x0133, B:70:0x013e, B:71:0x0142, B:73:0x0148, B:15:0x0031, B:22:0x0042, B:81:0x0179, B:82:0x017c), top: B:92:0x0003, outer: #2, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0179 A[Catch: all -> 0x017d, TRY_ENTER, TryCatch #10 {all -> 0x017d, blocks: (B:4:0x0003, B:23:0x0046, B:25:0x004b, B:51:0x00c1, B:53:0x00ea, B:56:0x00ee, B:58:0x00f6, B:59:0x0111, B:61:0x0117, B:37:0x0096, B:65:0x012f, B:66:0x0132, B:67:0x0133, B:70:0x013e, B:71:0x0142, B:73:0x0148, B:15:0x0031, B:22:0x0042, B:81:0x0179, B:82:0x017c), top: B:92:0x0003, outer: #2, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void zzl(java.util.List r18, long r19) {
        /*
            Method dump skipped, instruction units count: 389
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzaz.zzl(java.util.List, long):void");
    }

    @Override // com.google.android.gms.tagmanager.zzas
    public final void zza(String str) {
        this.zzb.execute(new zzaw(this, str));
    }

    @Override // com.google.android.gms.tagmanager.zzas
    public final void zzb(zzar zzarVar) {
        this.zzb.execute(new zzav(this, zzarVar));
    }

    @Override // com.google.android.gms.tagmanager.zzas
    public final void zzc(List list, long j) throws Throwable {
        ObjectOutputStream objectOutputStream;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzap zzapVar = (zzap) it.next();
            String str = zzapVar.zza;
            Object obj = zzapVar.zzb;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream2 = null;
            byteArray = null;
            byte[] byteArray = null;
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (IOException unused) {
                objectOutputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                objectOutputStream.writeObject(obj);
                byteArray = byteArrayOutputStream.toByteArray();
            } catch (IOException unused2) {
                if (objectOutputStream != null) {
                }
                byteArrayOutputStream.close();
                arrayList.add(new zzay(str, byteArray));
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream2 = objectOutputStream;
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (IOException unused3) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
            try {
                objectOutputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException unused4) {
            }
            arrayList.add(new zzay(str, byteArray));
        }
        this.zzb.execute(new zzau(this, arrayList, j));
    }
}
