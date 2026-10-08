package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zztw implements zzug {
    private final zzts zza;
    private final zzuv zzb;
    private final boolean zzc;
    private final zzrz zzd;

    private zztw(zzuv zzuvVar, zzrz zzrzVar, zzts zztsVar) {
        this.zzb = zzuvVar;
        this.zzc = zztsVar instanceof zzsk;
        this.zzd = zzrzVar;
        this.zza = zztsVar;
    }

    static zztw zzc(zzuv zzuvVar, zzrz zzrzVar, zzts zztsVar) {
        return new zztw(zzuvVar, zzrzVar, zztsVar);
    }

    @Override // com.google.android.recaptcha.internal.zzug
    public final int zza(Object obj) {
        int iZzb = ((zzsn) obj).zzc.zzb();
        return this.zzc ? iZzb + ((zzsk) obj).zzb.zzb() : iZzb;
    }

    @Override // com.google.android.recaptcha.internal.zzug
    public final int zzb(Object obj) {
        int iHashCode = ((zzsn) obj).zzc.hashCode();
        return this.zzc ? (iHashCode * 53) + ((zzsk) obj).zzb.zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.recaptcha.internal.zzug
    public final Object zze() {
        zzts zztsVar = this.zza;
        return zztsVar instanceof zzsn ? ((zzsn) zztsVar).zzv() : zztsVar.zzaf().zzl();
    }

    @Override // com.google.android.recaptcha.internal.zzug
    public final void zzf(Object obj) {
        this.zzb.zzi(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.recaptcha.internal.zzug
    public final void zzg(Object obj, Object obj2) {
        zzui.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            zzui.zzp(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzug
    public final void zzh(Object obj, zzuf zzufVar, zzry zzryVar) throws IOException {
        boolean zZzO;
        zzuv zzuvVar = this.zzb;
        Object objZza = zzuvVar.zza(obj);
        ((zzsk) obj).zzi();
        while (zzufVar.zzc() != Integer.MAX_VALUE) {
            try {
                int iZzd = zzufVar.zzd();
                int iZzj = 0;
                if (iZzd != 11) {
                    if ((iZzd & 7) == 2) {
                        zzsm zzsmVarZza = zzryVar.zza(this.zza, iZzd >>> 3);
                        if (zzsmVarZza != null) {
                            zzsm zzsmVar = zzsmVarZza;
                            throw null;
                        }
                        zZzO = zzuvVar.zzk(objZza, zzufVar, 0);
                    } else {
                        zZzO = zzufVar.zzO();
                    }
                    if (!zZzO) {
                        break;
                    }
                } else {
                    zzsm zzsmVarZza2 = null;
                    zzqm zzqmVarZzp = null;
                    while (zzufVar.zzc() != Integer.MAX_VALUE) {
                        int iZzd2 = zzufVar.zzd();
                        if (iZzd2 == 16) {
                            iZzj = zzufVar.zzj();
                            zzsmVarZza2 = zzryVar.zza(this.zza, iZzj);
                        } else if (iZzd2 == 26) {
                            if (zzsmVarZza2 != null) {
                                zzsm zzsmVar2 = zzsmVarZza2;
                                throw null;
                            }
                            zzqmVarZzp = zzufVar.zzp();
                        } else if (iZzd2 == 12 || !zzufVar.zzO()) {
                            break;
                        }
                    }
                    if (zzufVar.zzd() != 12) {
                        throw new zzsx("Protocol message end-group tag did not match expected tag.");
                    }
                    if (zzqmVarZzp == null) {
                        continue;
                    } else {
                        if (zzsmVarZza2 != null) {
                            zzsm zzsmVar3 = zzsmVarZza2;
                            throw null;
                        }
                        zzuvVar.zzg(objZza, iZzj, zzqmVarZzp);
                    }
                }
            } finally {
                zzuvVar.zzj(obj, objZza);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x008a A[EDGE_INSN: B:56:0x008a->B:34:0x008a BREAK  A[LOOP:1: B:18:0x004b->B:61:0x004b], SYNTHETIC] */
    @Override // com.google.android.recaptcha.internal.zzug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzi(java.lang.Object r10, byte[] r11, int r12, int r13, com.google.android.recaptcha.internal.zzqb r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.recaptcha.internal.zzsn r0 = (com.google.android.recaptcha.internal.zzsn) r0
            com.google.android.recaptcha.internal.zzuw r1 = r0.zzc
            com.google.android.recaptcha.internal.zzuw r2 = com.google.android.recaptcha.internal.zzuw.zzc()
            if (r1 != r2) goto L11
            com.google.android.recaptcha.internal.zzuw r1 = com.google.android.recaptcha.internal.zzuw.zzf()
            r0.zzc = r1
        L11:
            com.google.android.recaptcha.internal.zzsk r10 = (com.google.android.recaptcha.internal.zzsk) r10
            r10.zzi()
            r10 = 0
            r0 = r10
        L18:
            if (r12 >= r13) goto L94
            int r4 = com.google.android.recaptcha.internal.zzqc.zzi(r11, r12, r14)
            int r2 = r14.zza
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L49
            r12 = r2 & 7
            if (r12 != r3) goto L44
            com.google.android.recaptcha.internal.zzry r12 = r14.zzd
            com.google.android.recaptcha.internal.zzts r0 = r9.zza
            int r3 = r2 >>> 3
            com.google.android.recaptcha.internal.zzsm r0 = r12.zza(r0, r3)
            r12 = r0
            com.google.android.recaptcha.internal.zzsm r12 = (com.google.android.recaptcha.internal.zzsm) r12
            if (r0 != 0) goto L41
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.recaptcha.internal.zzqc.zzh(r2, r3, r4, r5, r6, r7)
            goto L18
        L41:
            int r11 = com.google.android.recaptcha.internal.zzuc.zza
            throw r10
        L44:
            int r12 = com.google.android.recaptcha.internal.zzqc.zzo(r2, r11, r4, r13, r14)
            goto L18
        L49:
            r12 = 0
            r2 = r10
        L4b:
            if (r4 >= r13) goto L8a
            int r4 = com.google.android.recaptcha.internal.zzqc.zzi(r11, r4, r14)
            int r5 = r14.zza
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L6d
            r8 = 3
            if (r6 == r8) goto L5d
            goto L81
        L5d:
            if (r0 != 0) goto L6a
            if (r7 != r3) goto L81
            int r4 = com.google.android.recaptcha.internal.zzqc.zza(r11, r4, r14)
            java.lang.Object r2 = r14.zzc
            com.google.android.recaptcha.internal.zzqm r2 = (com.google.android.recaptcha.internal.zzqm) r2
            goto L4b
        L6a:
            int r11 = com.google.android.recaptcha.internal.zzuc.zza
            throw r10
        L6d:
            if (r7 != 0) goto L81
            int r4 = com.google.android.recaptcha.internal.zzqc.zzi(r11, r4, r14)
            int r12 = r14.zza
            com.google.android.recaptcha.internal.zzry r0 = r14.zzd
            com.google.android.recaptcha.internal.zzts r5 = r9.zza
            com.google.android.recaptcha.internal.zzsm r0 = r0.zza(r5, r12)
            r5 = r0
            com.google.android.recaptcha.internal.zzsm r5 = (com.google.android.recaptcha.internal.zzsm) r5
            goto L4b
        L81:
            r6 = 12
            if (r5 == r6) goto L8a
            int r4 = com.google.android.recaptcha.internal.zzqc.zzo(r5, r11, r4, r13, r14)
            goto L4b
        L8a:
            if (r2 == 0) goto L92
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zzj(r12, r2)
        L92:
            r12 = r4
            goto L18
        L94:
            if (r12 != r13) goto L97
            return
        L97:
            com.google.android.recaptcha.internal.zzsx r10 = new com.google.android.recaptcha.internal.zzsx
            java.lang.String r11 = "Failed to parse the message."
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zztw.zzi(java.lang.Object, byte[], int, int, com.google.android.recaptcha.internal.zzqb):void");
    }

    @Override // com.google.android.recaptcha.internal.zzug
    public final void zzj(Object obj, zzvi zzviVar) throws IOException {
        Iterator itZzf = ((zzsk) obj).zzb.zzf();
        while (itZzf.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzf.next();
            zzsc zzscVar = (zzsc) entry.getKey();
            if (zzscVar.zze() != zzvh.MESSAGE) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzscVar.zzg();
            zzscVar.zzf();
            if (entry instanceof zzsz) {
                zzviVar.zzw(zzscVar.zza(), ((zzsz) entry).zza().zzb());
            } else {
                zzviVar.zzw(zzscVar.zza(), entry.getValue());
            }
        }
        ((zzsn) obj).zzc.zzk(zzviVar);
    }

    @Override // com.google.android.recaptcha.internal.zzug
    public final boolean zzk(Object obj, Object obj2) {
        if (!((zzsn) obj).zzc.equals(((zzsn) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzsk) obj).zzb.equals(((zzsk) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.recaptcha.internal.zzug
    public final boolean zzl(Object obj) {
        return ((zzsk) obj).zzb.zzk();
    }
}
