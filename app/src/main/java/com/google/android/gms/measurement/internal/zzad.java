package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzad extends zzos {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    zzad(zzpg zzpgVar) {
        super(zzpgVar);
    }

    private final zzy zzc(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzy) this.zzc.get(num);
        }
        zzy zzyVar = new zzy(this, this.zza, null);
        this.zzc.put(num, zzyVar);
        return zzyVar;
    }

    private final boolean zzd(int i, int i2) {
        zzy zzyVar = (zzy) this.zzc.get(Integer.valueOf(i));
        if (zzyVar == null) {
            return false;
        }
        return zzyVar.zzc().get(i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:402:0x0962, code lost:
    
        r0 = r11.zzaW().zze();
        r7 = com.google.android.gms.measurement.internal.zzgu.zzl(r30.zza);
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x0974, code lost:
    
        if (r9.zza() == false) goto L405;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x0976, code lost:
    
        r8 = java.lang.Integer.valueOf(r9.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x097f, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x0980, code lost:
    
        r0.zzc("Invalid property filter ID. appId, id", r7, java.lang.String.valueOf(r8));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02bb A[PHI: r0 r5
  0x02bb: PHI (r0v55 java.util.Map) = (r0v40 java.util.Map), (r0v57 java.util.Map), (r0v34 java.util.Map) binds: [B:121:0x02e8, B:110:0x02c3, B:107:0x02b9] A[DONT_GENERATE, DONT_INLINE]
  0x02bb: PHI (r5v14 android.database.Cursor) = (r5v9 android.database.Cursor), (r5v15 android.database.Cursor), (r5v15 android.database.Cursor) binds: [B:121:0x02e8, B:110:0x02c3, B:107:0x02b9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x05ac  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x06e7  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x06f1  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0709  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x078e  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0853 A[PHI: r0 r9
  0x0853: PHI (r0v146 java.util.Map) = (r0v148 java.util.Map), (r0v155 java.util.Map) binds: [B:367:0x087a, B:353:0x0851] A[DONT_GENERATE, DONT_INLINE]
  0x0853: PHI (r9v28 android.database.Cursor) = (r9v29 android.database.Cursor), (r9v33 android.database.Cursor) binds: [B:367:0x087a, B:353:0x0851] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0898  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x0a42  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b7 A[Catch: SQLiteException -> 0x0222, all -> 0x0a48, TRY_LEAVE, TryCatch #9 {SQLiteException -> 0x0222, blocks: (B:61:0x01b1, B:63:0x01b7, B:67:0x01c5, B:68:0x01ca, B:69:0x01d4, B:70:0x01e4, B:72:0x01f1), top: B:448:0x01b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01c5 A[Catch: SQLiteException -> 0x0222, all -> 0x0a48, TRY_ENTER, TryCatch #9 {SQLiteException -> 0x0222, blocks: (B:61:0x01b1, B:63:0x01b7, B:67:0x01c5, B:68:0x01ca, B:69:0x01d4, B:70:0x01e4, B:72:0x01f1), top: B:448:0x01b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0257  */
    /* JADX WARN: Type inference failed for: r0v198, types: [android.content.ContentValues] */
    /* JADX WARN: Type inference failed for: r4v28, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v50 */
    /* JADX WARN: Type inference failed for: r5v52, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v56, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r5v57 */
    /* JADX WARN: Type inference failed for: r5v58, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v59 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v60 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.util.List zzb(java.lang.String r31, java.util.List r32, java.util.List r33, java.lang.Long r34, java.lang.Long r35, boolean r36) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzb(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long, boolean):java.util.List");
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    protected final boolean zzbc() {
        return false;
    }
}
