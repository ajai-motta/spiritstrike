package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhq {
    private final zzgmv zza;
    private final Handler zzb;
    private zzhp zzc;
    private zzd zzd;
    private int zzf;
    private zzbz zzh;
    private float zzg = 1.0f;
    private int zze = 0;

    public zzhq(final Context context, Looper looper, zzhp zzhpVar) {
        this.zza = zzgmz.zza(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzho
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final /* synthetic */ Object zza() {
                return zzcb.zza(context);
            }
        });
        this.zzc = zzhpVar;
        this.zzb = new Handler(looper);
    }

    private final void zzf() {
        int i = this.zze;
        if (i == 1 || i == 0 || this.zzh == null) {
            return;
        }
        zzcb.zzc((AudioManager) this.zza.zza(), this.zzh);
    }

    private final void zzg(int i) {
        if (this.zze == i) {
            return;
        }
        this.zze = i;
        float f = i == 4 ? 0.2f : 1.0f;
        if (this.zzg != f) {
            this.zzg = f;
            zzhp zzhpVar = this.zzc;
            if (zzhpVar != null) {
                zzhpVar.zza(f);
            }
        }
    }

    private final void zzh(int i) {
        zzhp zzhpVar = this.zzc;
        if (zzhpVar != null) {
            zzhpVar.zzb(i);
        }
    }

    public final float zza() {
        return this.zzg;
    }

    public final void zzb(zzd zzdVar) {
        if (Objects.equals(this.zzd, zzdVar)) {
            return;
        }
        this.zzd = zzdVar;
        this.zzf = zzdVar == null ? 0 : 1;
    }

    public final void zzd() {
        this.zzc = null;
        zzf();
        zzg(0);
    }

    public final int zzc(boolean z, int i) {
        if (i == 1 || this.zzf != 1) {
            zzf();
            zzg(0);
            return 1;
        }
        if (!z) {
            int i2 = this.zze;
            if (i2 != 1) {
                return i2 != 3 ? 1 : 0;
            }
            return -1;
        }
        if (this.zze == 2) {
            return 1;
        }
        if (this.zzh == null) {
            zzbw zzbwVar = new zzbw(1);
            zzd zzdVar = this.zzd;
            zzdVar.getClass();
            zzbwVar.zzb(zzdVar);
            zzbwVar.zza(new AudioManager.OnAudioFocusChangeListener() { // from class: com.google.android.gms.internal.ads.zzhn
                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public final /* synthetic */ void onAudioFocusChange(int i3) {
                    this.zza.zze(i3);
                }
            }, this.zzb);
            this.zzh = zzbwVar.zzc();
        }
        if (zzcb.zzb((AudioManager) this.zza.zza(), this.zzh) == 1) {
            zzg(2);
            return 1;
        }
        zzg(1);
        return -1;
    }

    final /* synthetic */ void zze(int i) {
        if (i == -3 || i == -2) {
            if (i != -2) {
                zzg(4);
                return;
            } else {
                zzh(0);
                zzg(3);
                return;
            }
        }
        if (i == -1) {
            zzh(-1);
            zzf();
            zzg(1);
        } else if (i == 1) {
            zzg(2);
            zzh(1);
        } else {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 27);
            sb.append("Unknown focus change type: ");
            sb.append(i);
            zzdt.zzc("AudioFocusManager", sb.toString());
        }
    }
}
