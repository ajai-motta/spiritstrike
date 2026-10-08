package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzekg {
    private final zzgvb zzc;
    private zzekw zzf;
    private final String zzh;
    private final int zzi;
    private final zzekv zzj;
    private zzffu zzk;
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final List zzd = new ArrayList();
    private final Set zze = new HashSet();
    private int zzg = Integer.MAX_VALUE;
    private boolean zzl = false;

    zzekg(zzfgf zzfgfVar, zzekv zzekvVar, zzgvb zzgvbVar) {
        this.zzi = zzfgfVar.zzb.zzb.zzr;
        this.zzj = zzekvVar;
        this.zzc = zzgvbVar;
        this.zzh = zzelc.zzb(zzfgfVar);
        List list = zzfgfVar.zzb.zza;
        for (int i = 0; i < list.size(); i++) {
            this.zza.put((zzffu) list.get(i), Integer.valueOf(i));
        }
        this.zzb.addAll(list);
    }

    private final synchronized boolean zze() {
        if (this.zzl) {
            return false;
        }
        List list = this.zzb;
        if (!list.isEmpty() && ((zzffu) list.get(0)).zzav && !this.zzd.isEmpty()) {
            return false;
        }
        if (!zzd()) {
            List list2 = this.zzd;
            if (list2.size() < this.zzi) {
                if (zzf(false)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final synchronized boolean zzf(boolean z) {
        for (zzffu zzffuVar : this.zzb) {
            Integer num = (Integer) this.zza.get(zzffuVar);
            int iIntValue = num != null ? num.intValue() : Integer.MAX_VALUE;
            Integer numValueOf = Integer.valueOf(iIntValue);
            if (z || !this.zze.contains(zzffuVar.zzat)) {
                numValueOf.getClass();
                if (iIntValue < this.zzg) {
                    return true;
                }
                numValueOf.getClass();
                if (iIntValue > this.zzg) {
                    break;
                }
            }
        }
        return false;
    }

    private final synchronized boolean zzg() {
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) this.zza.get((zzffu) it.next());
            int iIntValue = num != null ? num.intValue() : Integer.MAX_VALUE;
            Integer.valueOf(iIntValue).getClass();
            if (iIntValue < this.zzg) {
                return true;
            }
        }
        return false;
    }

    private final synchronized boolean zzh() {
        if (!zzf(true)) {
            if (!zzg()) {
                return false;
            }
        }
        return true;
    }

    private final synchronized void zzi() {
        this.zzj.zzd(this.zzk);
        zzekw zzekwVar = this.zzf;
        if (zzekwVar != null) {
            this.zzc.zza(zzekwVar);
        } else {
            this.zzc.zzb(new zzekz(3, this.zzh));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r2.zzav == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        r6.zzl = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        r4.add(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        r6.zzd.add(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
    
        return (com.google.android.gms.internal.ads.zzffu) r1.remove(r0);
     */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final synchronized com.google.android.gms.internal.ads.zzffu zza() {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.zze()     // Catch: java.lang.Throwable -> L43
            if (r0 == 0) goto L40
            r0 = 0
        L8:
            java.util.List r1 = r6.zzb     // Catch: java.lang.Throwable -> L43
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L43
            if (r0 >= r2) goto L40
            java.lang.Object r2 = r1.get(r0)     // Catch: java.lang.Throwable -> L43
            com.google.android.gms.internal.ads.zzffu r2 = (com.google.android.gms.internal.ads.zzffu) r2     // Catch: java.lang.Throwable -> L43
            java.lang.String r3 = r2.zzat     // Catch: java.lang.Throwable -> L43
            java.util.Set r4 = r6.zze     // Catch: java.lang.Throwable -> L43
            boolean r5 = r4.contains(r3)     // Catch: java.lang.Throwable -> L43
            if (r5 == 0) goto L23
            int r0 = r0 + 1
            goto L8
        L23:
            boolean r5 = r2.zzav     // Catch: java.lang.Throwable -> L43
            if (r5 == 0) goto L2a
            r5 = 1
            r6.zzl = r5     // Catch: java.lang.Throwable -> L43
        L2a:
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L43
            if (r5 != 0) goto L33
            r4.add(r3)     // Catch: java.lang.Throwable -> L43
        L33:
            java.util.List r3 = r6.zzd     // Catch: java.lang.Throwable -> L43
            r3.add(r2)     // Catch: java.lang.Throwable -> L43
            java.lang.Object r0 = r1.remove(r0)     // Catch: java.lang.Throwable -> L43
            com.google.android.gms.internal.ads.zzffu r0 = (com.google.android.gms.internal.ads.zzffu) r0     // Catch: java.lang.Throwable -> L43
            monitor-exit(r6)
            return r0
        L40:
            monitor-exit(r6)
            r0 = 0
            return r0
        L43:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzekg.zza():com.google.android.gms.internal.ads.zzffu");
    }

    final synchronized void zzb(zzekw zzekwVar, zzffu zzffuVar) {
        this.zzl = false;
        this.zzd.remove(zzffuVar);
        if (zzd()) {
            zzekwVar.zzm();
            return;
        }
        Integer num = (Integer) this.zza.get(zzffuVar);
        int iIntValue = num != null ? num.intValue() : Integer.MAX_VALUE;
        Integer numValueOf = Integer.valueOf(iIntValue);
        numValueOf.getClass();
        if (iIntValue > this.zzg) {
            this.zzj.zzf(zzffuVar);
            return;
        }
        if (this.zzf != null) {
            this.zzj.zzf(this.zzk);
        }
        numValueOf.getClass();
        this.zzg = iIntValue;
        this.zzf = zzekwVar;
        this.zzk = zzffuVar;
        if (zzh()) {
            return;
        }
        zzi();
    }

    final synchronized void zzc(Throwable th, zzffu zzffuVar) {
        this.zzl = false;
        this.zzd.remove(zzffuVar);
        this.zze.remove(zzffuVar.zzat);
        if (zzd() || zzh()) {
            return;
        }
        zzi();
    }

    final synchronized boolean zzd() {
        return this.zzc.isDone();
    }
}
