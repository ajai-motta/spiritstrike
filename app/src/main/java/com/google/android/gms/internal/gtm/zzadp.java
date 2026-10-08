package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzadp implements zzadx {
    private final zzadl zza;
    private final zzaem zzb;
    private final boolean zzc;
    private final zzabr zzd;

    private zzadp(zzaem zzaemVar, zzabr zzabrVar, zzadl zzadlVar) {
        this.zzb = zzaemVar;
        this.zzc = zzadlVar instanceof zzacc;
        this.zzd = zzabrVar;
        this.zza = zzadlVar;
    }

    static zzadp zzc(zzaem zzaemVar, zzabr zzabrVar, zzadl zzadlVar) {
        return new zzadp(zzaemVar, zzabrVar, zzadlVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzadx
    public final int zza(Object obj) {
        int iZzb = ((zzacf) obj).zzc.zzb();
        return this.zzc ? iZzb + ((zzacc) obj).zza.zzc() : iZzb;
    }

    @Override // com.google.android.gms.internal.gtm.zzadx
    public final int zzb(Object obj) {
        int iHashCode = ((zzacf) obj).zzc.hashCode();
        return this.zzc ? (iHashCode * 53) + ((zzacc) obj).zza.zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.gtm.zzadx
    public final Object zze() {
        zzadl zzadlVar = this.zza;
        return zzadlVar instanceof zzacf ? ((zzacf) zzadlVar).zzae() : zzadlVar.zzav().zzE();
    }

    @Override // com.google.android.gms.internal.gtm.zzadx
    public final void zzf(Object obj) {
        this.zzb.zzi(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.gtm.zzadx
    public final void zzg(Object obj, Object obj2) {
        zzadz.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            zzadz.zzp(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzadx
    public final void zzh(Object obj, zzadw zzadwVar, zzabq zzabqVar) throws IOException {
        boolean zZzQ;
        zzaem zzaemVar = this.zzb;
        Object objZza = zzaemVar.zza(obj);
        zzabv zzabvVarZzU = ((zzacc) obj).zzU();
        while (zzadwVar.zzc() != Integer.MAX_VALUE) {
            try {
                int iZzd = zzadwVar.zzd();
                zzabr zzabrVar = this.zzd;
                if (iZzd != 11) {
                    if ((iZzd & 7) == 2) {
                        zzace zzaceVarZzb = zzabqVar.zzb(this.zza, iZzd >>> 3);
                        if (zzaceVarZzb != null) {
                            zzabrVar.zzb(zzadwVar, zzaceVarZzb, zzabqVar, zzabvVarZzU);
                        } else {
                            zZzQ = zzaemVar.zzk(objZza, zzadwVar, 0);
                        }
                    } else {
                        zZzQ = zzadwVar.zzQ();
                    }
                    if (!zZzQ) {
                        break;
                    }
                } else {
                    zzace zzaceVarZzb2 = null;
                    zzyx zzyxVarZzp = null;
                    int iZzj = 0;
                    while (zzadwVar.zzc() != Integer.MAX_VALUE) {
                        int iZzd2 = zzadwVar.zzd();
                        if (iZzd2 == 16) {
                            iZzj = zzadwVar.zzj();
                            zzaceVarZzb2 = zzabqVar.zzb(this.zza, iZzj);
                        } else if (iZzd2 == 26) {
                            if (zzaceVarZzb2 != null) {
                                zzabrVar.zzb(zzadwVar, zzaceVarZzb2, zzabqVar, zzabvVarZzU);
                            } else {
                                zzyxVarZzp = zzadwVar.zzp();
                            }
                        } else if (!zzadwVar.zzQ()) {
                            break;
                        }
                    }
                    if (zzadwVar.zzd() != 12) {
                        throw new zzacq("Protocol message end-group tag did not match expected tag.");
                    }
                    if (zzyxVarZzp != null) {
                        if (zzaceVarZzb2 != null) {
                            zzace zzaceVar = zzaceVarZzb2;
                            zzadk zzadkVarZzav = zzaceVarZzb2.zzc.zzav();
                            zzzb zzzbVarZzH = zzzb.zzH(((zzyv) zzyxVarZzp).zza, 0, ((zzyv) zzyxVarZzp).zzd(), true);
                            zzadkVarZzav.zzy(zzzbVarZzH, zzabqVar);
                            zzabvVarZzU.zzk(zzaceVarZzb2.zzd, zzadkVarZzav.zzE());
                            zzzbVarZzH.zzz(0);
                        } else {
                            zzaemVar.zzg(objZza, iZzj, zzyxVarZzp);
                        }
                    }
                }
            } finally {
                zzaemVar.zzj(obj, objZza);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bb A[EDGE_INSN: B:57:0x00bb->B:33:0x00bb BREAK  A[LOOP:1: B:18:0x0065->B:60:0x0065], SYNTHETIC] */
    @Override // com.google.android.gms.internal.gtm.zzadx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzi(java.lang.Object r11, byte[] r12, int r13, int r14, com.google.android.gms.internal.gtm.zzyl r15) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzadp.zzi(java.lang.Object, byte[], int, int, com.google.android.gms.internal.gtm.zzyl):void");
    }

    @Override // com.google.android.gms.internal.gtm.zzadx
    public final void zzj(Object obj, zzaez zzaezVar) throws IOException {
        Iterator itZzg = ((zzacc) obj).zza.zzg();
        while (itZzg.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzg.next();
            zzabu zzabuVar = (zzabu) entry.getKey();
            if (zzabuVar.zze() != zzaey.MESSAGE || zzabuVar.zzg()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzabuVar.zzf();
            if (entry instanceof zzacs) {
                zzaezVar.zzw(zzabuVar.zza(), ((zzacs) entry).zza().zzb());
            } else {
                zzaezVar.zzw(zzabuVar.zza(), entry.getValue());
            }
        }
        ((zzacf) obj).zzc.zzk(zzaezVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzadx
    public final boolean zzk(Object obj, Object obj2) {
        if (!((zzacf) obj).zzc.equals(((zzacf) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzacc) obj).zza.equals(((zzacc) obj2).zza);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.gtm.zzadx
    public final boolean zzl(Object obj) {
        return ((zzacc) obj).zza.zzm();
    }
}
