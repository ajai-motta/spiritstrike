package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcbd {
    private final Clock zza;
    private final zzcbn zzb;
    private final String zze;
    private final String zzf;
    private final Object zzd = new Object();
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = 0;
    private long zzj = -1;
    private long zzk = -1;
    private final LinkedList zzc = new LinkedList();

    zzcbd(Clock clock, zzcbn zzcbnVar, String str, String str2) {
        this.zza = clock;
        this.zzb = zzcbnVar;
        this.zze = str;
        this.zzf = str2;
    }

    public final void zza(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        synchronized (this.zzd) {
            long jElapsedRealtime = this.zza.elapsedRealtime();
            this.zzj = jElapsedRealtime;
            this.zzb.zzf(zzmVar, jElapsedRealtime);
        }
    }

    public final void zzb() {
        synchronized (this.zzd) {
            this.zzb.zzg();
        }
    }

    public final void zzc() {
        synchronized (this.zzd) {
            this.zzb.zzh();
        }
    }

    public final void zzd(long j) {
        synchronized (this.zzd) {
            this.zzk = j;
            if (j != -1) {
                this.zzb.zzb(this);
            }
        }
    }

    public final void zze() {
        synchronized (this.zzd) {
            if (this.zzk != -1 && this.zzg == -1) {
                this.zzg = this.zza.elapsedRealtime();
                this.zzb.zzb(this);
            }
            this.zzb.zze();
        }
    }

    public final void zzf() {
        synchronized (this.zzd) {
            if (this.zzk != -1) {
                zzcbc zzcbcVar = new zzcbc(this);
                zzcbcVar.zzc();
                this.zzc.add(zzcbcVar);
                this.zzi++;
                zzcbn zzcbnVar = this.zzb;
                zzcbnVar.zzd();
                zzcbnVar.zzb(this);
            }
        }
    }

    public final void zzg() {
        synchronized (this.zzd) {
            if (this.zzk != -1) {
                LinkedList linkedList = this.zzc;
                if (!linkedList.isEmpty()) {
                    zzcbc zzcbcVar = (zzcbc) linkedList.getLast();
                    if (zzcbcVar.zza() == -1) {
                        zzcbcVar.zzb();
                        this.zzb.zzb(this);
                    }
                }
            }
        }
    }

    public final void zzh(boolean z) {
        synchronized (this.zzd) {
            if (this.zzk != -1) {
                this.zzh = this.zza.elapsedRealtime();
            }
        }
    }

    public final Bundle zzi() {
        Bundle bundle;
        synchronized (this.zzd) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zze);
            bundle.putString("slotid", this.zzf);
            bundle.putBoolean("ismediation", false);
            bundle.putLong("treq", this.zzj);
            bundle.putLong("tresponse", this.zzk);
            bundle.putLong("timp", this.zzg);
            bundle.putLong("tload", this.zzh);
            bundle.putLong("pcc", this.zzi);
            bundle.putLong("tfetch", -1L);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator it = this.zzc.iterator();
            while (it.hasNext()) {
                arrayList.add(((zzcbc) it.next()).zzd());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public final String zzj() {
        return this.zze;
    }

    final /* synthetic */ Clock zzk() {
        return this.zza;
    }
}
