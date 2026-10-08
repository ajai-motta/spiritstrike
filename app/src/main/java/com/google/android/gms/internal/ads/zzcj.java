package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcg;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcj implements zzcg {
    private int zzb;
    private float zzc = 1.0f;
    private float zzd = 1.0f;
    private zzcd zze;
    private zzcd zzf;
    private zzcd zzg;
    private zzcd zzh;
    private boolean zzi;
    private zzci zzj;
    private ByteBuffer zzk;
    private ShortBuffer zzl;
    private ByteBuffer zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;

    public zzcj() {
        zzcd zzcdVar = zzcd.zza;
        this.zze = zzcdVar;
        this.zzf = zzcdVar;
        this.zzg = zzcdVar;
        this.zzh = zzcdVar;
        ByteBuffer byteBuffer = zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = byteBuffer;
        this.zzb = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcg
    public final long zza(long j) {
        long j2 = this.zzo;
        if (j2 < 1024) {
            return (long) (j / ((double) this.zzc));
        }
        long j3 = this.zzn;
        zzci zzciVar = this.zzj;
        zzciVar.getClass();
        long jZza = j3 - ((long) zzciVar.zza());
        int i = this.zzh.zzb;
        int i2 = this.zzg.zzb;
        return i == i2 ? zzep.zzt(j, j2, jZza, RoundingMode.DOWN) : zzep.zzt(j, j2 * ((long) i2), jZza * ((long) i), RoundingMode.DOWN);
    }

    @Override // com.google.android.gms.internal.ads.zzcg
    public final zzcd zzb(zzcd zzcdVar) throws zzcf {
        if (zzcdVar.zzd != 2) {
            throw new zzcf("Unhandled input format:", zzcdVar);
        }
        int i = this.zzb;
        if (i == -1) {
            i = zzcdVar.zzb;
        }
        this.zze = zzcdVar;
        zzcd zzcdVar2 = new zzcd(i, zzcdVar.zzc, 2);
        this.zzf = zzcdVar2;
        this.zzi = true;
        return zzcdVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzcg
    public final boolean zzc() {
        if (this.zzf.zzb != -1) {
            return Math.abs(this.zzc + (-1.0f)) >= 1.0E-4f || Math.abs(this.zzd + (-1.0f)) >= 1.0E-4f || this.zzf.zzb != this.zze.zzb;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcg
    public final void zzd(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            zzci zzciVar = this.zzj;
            zzciVar.getClass();
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.zzn += (long) iRemaining;
            zzciVar.zzb(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcg
    public final void zze() {
        zzci zzciVar = this.zzj;
        if (zzciVar != null) {
            zzciVar.zzd();
        }
        this.zzp = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcg
    public final ByteBuffer zzf() {
        int iZzf;
        zzci zzciVar = this.zzj;
        if (zzciVar != null && (iZzf = zzciVar.zzf()) > 0) {
            if (this.zzk.capacity() < iZzf) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iZzf).order(ByteOrder.nativeOrder());
                this.zzk = byteBufferOrder;
                this.zzl = byteBufferOrder.asShortBuffer();
            } else {
                this.zzk.clear();
                this.zzl.clear();
            }
            zzciVar.zzc(this.zzl);
            this.zzo += (long) iZzf;
            this.zzk.limit(iZzf);
            this.zzm = this.zzk;
        }
        ByteBuffer byteBuffer = this.zzm;
        this.zzm = zza;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzcg
    public final boolean zzg() {
        if (!this.zzp) {
            return false;
        }
        zzci zzciVar = this.zzj;
        return zzciVar == null || zzciVar.zzf() == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcg
    public /* synthetic */ void zzh() {
        zzcg.CC.$default$zzh(this);
    }

    @Override // com.google.android.gms.internal.ads.zzcg
    public final void zzi(zzce zzceVar) {
        if (zzc()) {
            zzcd zzcdVar = this.zze;
            this.zzg = zzcdVar;
            this.zzh = this.zzf;
            if (this.zzi) {
                this.zzj = new zzci(zzcdVar.zzb, zzcdVar.zzc, this.zzc, this.zzd, this.zzh.zzb);
            } else {
                zzci zzciVar = this.zzj;
                if (zzciVar != null) {
                    zzciVar.zze();
                }
            }
        }
        this.zzm = zza;
        this.zzn = 0L;
        this.zzo = 0L;
        this.zzp = false;
    }

    @Override // com.google.android.gms.internal.ads.zzcg
    public final void zzj() {
        this.zzc = 1.0f;
        this.zzd = 1.0f;
        zzcd zzcdVar = zzcd.zza;
        this.zze = zzcdVar;
        this.zzf = zzcdVar;
        this.zzg = zzcdVar;
        this.zzh = zzcdVar;
        ByteBuffer byteBuffer = zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = byteBuffer;
        this.zzb = -1;
        this.zzi = false;
        this.zzj = null;
        this.zzn = 0L;
        this.zzo = 0L;
        this.zzp = false;
    }

    public final void zzk(float f) {
        zzgmd.zza(f > 0.0f);
        if (this.zzc != f) {
            this.zzc = f;
            this.zzi = true;
        }
    }

    public final void zzl(float f) {
        zzgmd.zza(f > 0.0f);
        if (this.zzd != f) {
            this.zzd = f;
            this.zzi = true;
        }
    }

    public final long zzm(long j) {
        long j2 = this.zzo;
        if (j2 < 1024) {
            return (long) (((double) this.zzc) * j);
        }
        long j3 = this.zzn;
        zzci zzciVar = this.zzj;
        zzciVar.getClass();
        long jZza = j3 - ((long) zzciVar.zza());
        int i = this.zzh.zzb;
        int i2 = this.zzg.zzb;
        return i == i2 ? zzep.zzt(j, jZza, j2, RoundingMode.DOWN) : zzep.zzt(j, jZza * ((long) i), j2 * ((long) i2), RoundingMode.DOWN);
    }
}
