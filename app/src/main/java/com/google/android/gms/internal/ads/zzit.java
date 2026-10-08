package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.TextureView;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzit implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, zzabs, zzqa, zzwy, zzts, zzhl, zzlz {
    public static final /* synthetic */ int zzb = 0;
    final /* synthetic */ zzju zza;

    /* synthetic */ zzit(zzju zzjuVar, byte[] bArr) {
        Objects.requireNonNull(zzjuVar);
        this.zza = zzjuVar;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzju zzjuVar = this.zza;
        zzjuVar.zzQ(surfaceTexture);
        zzjuVar.zzS(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzju zzjuVar = this.zza;
        zzjuVar.zzR(null);
        zzjuVar.zzS(0, 0);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.zza.zzS(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.zza.zzS(i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.zza.zzS(0, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zza(zzhs zzhsVar) {
        this.zza.zzU().zzN(zzhsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzb(String str, long j, long j2) {
        this.zza.zzU().zzO(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzc(zzv zzvVar, zzht zzhtVar) {
        this.zza.zzU().zzP(zzvVar, zzhtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzd(int i, long j) {
        this.zza.zzU().zzQ(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zze(final zzbv zzbvVar) {
        zzdn zzdnVar = new zzdn() { // from class: com.google.android.gms.internal.ads.zzir
            @Override // com.google.android.gms.internal.ads.zzdn
            public final /* synthetic */ void zza(Object obj) {
                int i = zzit.zzb;
                ((zzaz) obj).zzt(zzbvVar);
            }
        };
        zzds zzdsVarZzT = this.zza.zzT();
        zzdsVarZzT.zzd(25, zzdnVar);
        zzdsVarZzT.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzf(Object obj, long j) {
        zzju zzjuVar = this.zza;
        zzjuVar.zzU().zzT(obj, j);
        if (zzjuVar.zzW() == obj) {
            zzds zzdsVarZzT = zzjuVar.zzT();
            zzdsVarZzT.zzd(26, zzis.zza);
            zzdsVarZzT.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzg(String str) {
        this.zza.zzU().zzR(str);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzh(zzhs zzhsVar) {
        this.zza.zzU().zzS(zzhsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzi(long j, int i) {
        this.zza.zzU().zzU(j, i);
    }

    @Override // com.google.android.gms.internal.ads.zzabs
    public final void zzj(Exception exc) {
        this.zza.zzU().zzV(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzk(zzhs zzhsVar) {
        this.zza.zzU().zzC(zzhsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzl(String str, long j, long j2) {
        this.zza.zzU().zzD(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzm(zzv zzvVar, zzht zzhtVar) {
        this.zza.zzU().zzE(zzvVar, zzhtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzn(long j) {
        this.zza.zzU().zzF(j);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzo(int i, long j, long j2) {
        this.zza.zzU().zzG(i, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzp(String str) {
        this.zza.zzU().zzH(str);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzq(zzhs zzhsVar) {
        this.zza.zzU().zzI(zzhsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzr(final boolean z) {
        zzju zzjuVar = this.zza;
        if (zzjuVar.zzX() == z) {
            return;
        }
        zzjuVar.zzY(z);
        zzds zzdsVarZzT = zzjuVar.zzT();
        zzdsVarZzT.zzd(23, new zzdn() { // from class: com.google.android.gms.internal.ads.zzio
            @Override // com.google.android.gms.internal.ads.zzdn
            public final /* synthetic */ void zza(Object obj) {
                int i = zzit.zzb;
                ((zzaz) obj).zzs(z);
            }
        });
        zzdsVarZzT.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzs(Exception exc) {
        this.zza.zzU().zzJ(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzt(Exception exc) {
        this.zza.zzU().zzK(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzu(zzqb zzqbVar) {
        this.zza.zzU().zzL(zzqbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzv(zzqb zzqbVar) {
        this.zza.zzU().zzM(zzqbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqa
    public final void zzw(final int i) {
        this.zza.zzV().zza(new zzglu() { // from class: com.google.android.gms.internal.ads.zzip
            @Override // com.google.android.gms.internal.ads.zzglu
            public final /* synthetic */ Object apply(Object obj) {
                int i2 = zzit.zzb;
                return Integer.valueOf(i);
            }
        }, new zzglu() { // from class: com.google.android.gms.internal.ads.zziq
            @Override // com.google.android.gms.internal.ads.zzglu
            public final /* synthetic */ Object apply(Object obj) {
                int i2 = zzit.zzb;
                return Integer.valueOf(i);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final void zzx(zzmf zzmfVar) {
        this.zza.zzP(zzib.zzc(zzmfVar, 1003));
    }
}
