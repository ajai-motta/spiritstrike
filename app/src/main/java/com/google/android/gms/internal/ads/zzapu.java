package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import io.ktor.sse.ServerSentEventKt;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzapu implements Comparable {
    private final zzaqf zza;
    private final int zzb;
    private final String zzc;
    private final int zzd;
    private final Object zze;
    private final zzapy zzf;
    private Integer zzg;
    private zzapx zzh;
    private boolean zzi;
    private zzapd zzj;
    private zzapt zzk;
    private final zzapi zzl;

    public zzapu(int i, String str, zzapy zzapyVar) {
        Uri uri;
        String host;
        this.zza = zzaqf.zza ? new zzaqf() : null;
        this.zze = new Object();
        int iHashCode = 0;
        this.zzi = false;
        this.zzj = null;
        this.zzb = i;
        this.zzc = str;
        this.zzf = zzapyVar;
        this.zzl = new zzapi();
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (host = uri.getHost()) != null) {
            iHashCode = host.hashCode();
        }
        this.zzd = iHashCode;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzg.intValue() - ((zzapu) obj).zzg.intValue();
    }

    public final String toString() {
        String hexString = Integer.toHexString(this.zzd);
        String.valueOf(hexString);
        String strValueOf = String.valueOf(hexString);
        zzl();
        Integer num = this.zzg;
        String str = this.zzc;
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(num).length();
        String strConcat = "0x".concat(strValueOf);
        StringBuilder sb = new StringBuilder(length + 5 + strConcat.length() + 8 + length2);
        sb.append("[ ] ");
        sb.append(str);
        sb.append(ServerSentEventKt.SPACE);
        sb.append(strConcat);
        sb.append(" NORMAL ");
        sb.append(num);
        return sb.toString();
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final void zzc(String str) {
        if (zzaqf.zza) {
            this.zza.zza(str, Thread.currentThread().getId());
        }
    }

    final void zzd(String str) {
        zzapx zzapxVar = this.zzh;
        if (zzapxVar != null) {
            zzapxVar.zzc(this);
        }
        if (zzaqf.zza) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzaps(this, str, id));
                return;
            }
            zzaqf zzaqfVar = this.zza;
            zzaqfVar.zza(str, id);
            zzaqfVar.zzb(toString());
        }
    }

    final void zze(int i) {
        zzapx zzapxVar = this.zzh;
        if (zzapxVar != null) {
            zzapxVar.zzd(this, i);
        }
    }

    public final zzapu zzf(zzapx zzapxVar) {
        this.zzh = zzapxVar;
        return this;
    }

    public final zzapu zzg(int i) {
        this.zzg = Integer.valueOf(i);
        return this;
    }

    public final String zzh() {
        return this.zzc;
    }

    public final String zzi() {
        int i = this.zzb;
        String str = this.zzc;
        if (i == 0) {
            return str;
        }
        String string = Integer.toString(1);
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 1 + String.valueOf(str).length());
        sb.append(string);
        sb.append("-");
        sb.append(str);
        return sb.toString();
    }

    public final zzapu zzj(zzapd zzapdVar) {
        this.zzj = zzapdVar;
        return this;
    }

    public final zzapd zzk() {
        return this.zzj;
    }

    public final boolean zzl() {
        synchronized (this.zze) {
        }
        return false;
    }

    public Map zzm() throws zzapc {
        return Collections.emptyMap();
    }

    public byte[] zzn() throws zzapc {
        return null;
    }

    public final int zzo() {
        return this.zzl.zza();
    }

    public final void zzp() {
        synchronized (this.zze) {
            this.zzi = true;
        }
    }

    public final boolean zzq() {
        boolean z;
        synchronized (this.zze) {
            z = this.zzi;
        }
        return z;
    }

    protected abstract zzaqa zzr(zzapq zzapqVar);

    protected abstract void zzs(Object obj);

    public final void zzt(zzaqd zzaqdVar) {
        zzapy zzapyVar;
        synchronized (this.zze) {
            zzapyVar = this.zzf;
        }
        zzapyVar.zza(zzaqdVar);
    }

    final void zzu(zzapt zzaptVar) {
        synchronized (this.zze) {
            this.zzk = zzaptVar;
        }
    }

    final void zzv(zzaqa zzaqaVar) {
        zzapt zzaptVar;
        synchronized (this.zze) {
            zzaptVar = this.zzk;
        }
        if (zzaptVar != null) {
            zzaptVar.zza(this, zzaqaVar);
        }
    }

    final void zzw() {
        zzapt zzaptVar;
        synchronized (this.zze) {
            zzaptVar = this.zzk;
        }
        if (zzaptVar != null) {
            zzaptVar.zzb(this);
        }
    }

    final /* synthetic */ zzaqf zzx() {
        return this.zza;
    }

    public final zzapi zzy() {
        return this.zzl;
    }
}
