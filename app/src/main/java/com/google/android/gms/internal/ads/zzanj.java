package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzanj implements zzaof {
    private final zzamq zza;
    private final zzef zzb = new zzef(new byte[10], 10);
    private int zzc = 0;
    private int zzd;
    private zzem zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    public zzanj(zzamq zzamqVar) {
        this.zza = zzamqVar;
    }

    private final void zze(int i) {
        this.zzc = i;
        this.zzd = 0;
    }

    private final boolean zzf(zzeg zzegVar, byte[] bArr, int i) {
        int iMin = Math.min(zzegVar.zzd(), i - this.zzd);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            zzegVar.zzk(iMin);
        } else {
            zzegVar.zzm(bArr, this.zzd, iMin);
        }
        int i2 = this.zzd + iMin;
        this.zzd = i2;
        return i2 == i;
    }

    @Override // com.google.android.gms.internal.ads.zzaof
    public final void zza(zzem zzemVar, zzadd zzaddVar, zzaoe zzaoeVar) {
        this.zze = zzemVar;
        this.zza.zzb(zzaddVar, zzaoeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaof
    public final void zzb() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = false;
        this.zza.zza();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3, types: [com.google.android.gms.internal.ads.zzef] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v6, types: [int] */
    /* JADX WARN: Type inference failed for: r9v7, types: [com.google.android.gms.internal.ads.zzamq] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzaof
    public final void zzc(zzeg zzegVar, int i) throws zzat {
        int i2;
        int i3;
        ?? r2;
        zzeg zzegVar2;
        int i4;
        int i5;
        int i6;
        long jZze;
        char c;
        zzeg zzegVar3 = zzegVar;
        this.zze.getClass();
        int i7 = -1;
        int i8 = 2;
        ?? r6 = 0;
        if ((i & 1) != 0) {
            int i9 = this.zzc;
            if (i9 != 0 && i9 != 1) {
                if (i9 != 2) {
                    int i10 = this.zzj;
                    if (i10 != -1) {
                        StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + 48);
                        sb.append("Unexpected start indicator: expected ");
                        sb.append(i10);
                        sb.append(" more bytes");
                        zzdt.zzc("PesReader", sb.toString());
                    }
                    this.zza.zze(zzegVar.zze() == 0);
                } else {
                    zzdt.zzc("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            zze(1);
        }
        int i11 = i;
        while (zzegVar.zzd() > 0) {
            int i12 = this.zzc;
            if (i12 == 0) {
                i2 = i11;
                i3 = i8;
                r2 = r6;
                zzegVar2 = zzegVar3;
                i4 = i7;
                zzegVar2.zzk(zzegVar.zzd());
            } else if (i12 == 1) {
                i2 = i11;
                zzef zzefVar = this.zzb;
                zzegVar2 = zzegVar;
                if (zzf(zzegVar2, zzefVar.zza, 9)) {
                    r2 = 0;
                    zzefVar.zzf(0);
                    int iZzj = zzefVar.zzj(24);
                    if (iZzj != 1) {
                        StringBuilder sb2 = new StringBuilder(String.valueOf(iZzj).length() + 30);
                        sb2.append("Unexpected start code prefix: ");
                        sb2.append(iZzj);
                        zzdt.zzc("PesReader", sb2.toString());
                        i4 = -1;
                        this.zzj = -1;
                        i5 = 0;
                        i3 = 2;
                    } else {
                        zzefVar.zzh(8);
                        int iZzj2 = zzefVar.zzj(16);
                        zzefVar.zzh(5);
                        this.zzk = zzefVar.zzi();
                        i3 = 2;
                        zzefVar.zzh(2);
                        this.zzf = zzefVar.zzi();
                        this.zzg = zzefVar.zzi();
                        zzefVar.zzh(6);
                        int iZzj3 = zzefVar.zzj(8);
                        this.zzi = iZzj3;
                        if (iZzj2 == 0) {
                            this.zzj = -1;
                            i4 = -1;
                        } else {
                            int i13 = (iZzj2 - 3) - iZzj3;
                            this.zzj = i13;
                            if (i13 < 0) {
                                StringBuilder sb3 = new StringBuilder(String.valueOf(i13).length() + 36);
                                sb3.append("Found negative packet payload size: ");
                                sb3.append(i13);
                                zzdt.zzc("PesReader", sb3.toString());
                                i4 = -1;
                                this.zzj = -1;
                            } else {
                                i4 = -1;
                            }
                        }
                        i5 = 2;
                    }
                    zze(i5);
                } else {
                    i4 = -1;
                    r2 = 0;
                    i3 = 2;
                }
            } else if (i12 != i8) {
                int iZzd = zzegVar.zzd();
                int i14 = this.zzj;
                ?? r9 = i14 == i7 ? r6 : iZzd - i14;
                if (r9 > 0) {
                    iZzd -= r9;
                    zzegVar3.zzf(zzegVar.zzg() + iZzd);
                }
                ?? r92 = this.zza;
                r92.zzd(zzegVar3);
                int i15 = this.zzj;
                if (i15 != i7) {
                    int i16 = i15 - iZzd;
                    this.zzj = i16;
                    if (i16 == 0) {
                        r92.zze(r6);
                        zze(1);
                    }
                }
                i2 = i11;
                i3 = i8;
                r2 = r6;
                zzegVar2 = zzegVar3;
                i4 = i7;
            } else {
                int iMin = Math.min(10, this.zzi);
                ?? r10 = this.zzb;
                if (zzf(zzegVar3, r10.zza, iMin) && zzf(zzegVar3, null, this.zzi)) {
                    r10.zzf(r6);
                    if (this.zzf) {
                        r10.zzh(4);
                        long jZzj = r10.zzj(3);
                        r10.zzh(1);
                        int iZzj4 = r10.zzj(15) << 15;
                        r10.zzh(1);
                        long jZzj2 = r10.zzj(15);
                        r10.zzh(1);
                        if (this.zzh || !this.zzg) {
                            i6 = i11;
                            c = 30;
                        } else {
                            r10.zzh(4);
                            long jZzj3 = ((long) r10.zzj(3)) << 30;
                            r10.zzh(1);
                            int iZzj5 = r10.zzj(15) << 15;
                            r10.zzh(1);
                            i6 = i11;
                            long jZzj4 = r10.zzj(15);
                            r10.zzh(1);
                            this.zze.zze(jZzj4 | ((long) iZzj5) | jZzj3);
                            this.zzh = true;
                            c = 30;
                        }
                        jZze = this.zze.zze((jZzj << c) | ((long) iZzj4) | jZzj2);
                    } else {
                        i6 = i11;
                        jZze = C.TIME_UNSET;
                    }
                    int i17 = i6 | (true != this.zzk ? 0 : 4);
                    this.zza.zzc(jZze, i17);
                    zze(3);
                    zzegVar3 = zzegVar;
                    i11 = i17;
                    i7 = -1;
                    i8 = 2;
                    r6 = 0;
                } else {
                    i2 = i11;
                    i4 = i7;
                    i3 = i8;
                    r2 = r6;
                    zzegVar2 = zzegVar;
                }
            }
            i7 = i4;
            r6 = r2;
            zzegVar3 = zzegVar2;
            i8 = i3;
            i11 = i2;
        }
    }

    public final boolean zzd(boolean z) {
        return this.zzc == 3 && this.zzj == -1;
    }
}
