package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Display;
import android.view.Surface;
import com.google.android.exoplayer2.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzabf {
    private final zzaad zza = new zzaad();
    private final zzabd zzb;
    private final zzabe zzc;
    private boolean zzd;
    private Surface zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private float zzi;
    private int zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;

    private final void zzk() {
        this.zzm = 0L;
        this.zzp = -1L;
        this.zzn = -1L;
    }

    private final void zzl() {
        if (Build.VERSION.SDK_INT < 30 || this.zze == null) {
            return;
        }
        zzaad zzaadVar = this.zza;
        float fZzg = zzaadVar.zzc() ? zzaadVar.zzg() : this.zzf;
        float f = this.zzg;
        if (fZzg != f) {
            if (fZzg != -1.0f && f != -1.0f) {
                float f2 = 1.0f;
                if (zzaadVar.zzc() && zzaadVar.zze() >= 5000000000L) {
                    f2 = 0.1f;
                }
                if (Math.abs(fZzg - this.zzg) < f2) {
                    return;
                }
            } else if (fZzg == -1.0f && zzaadVar.zzd() < 30) {
                return;
            }
            this.zzg = fZzg;
            zzm(false);
        }
    }

    private final void zzm(boolean z) {
        Surface surface;
        if (Build.VERSION.SDK_INT < 30 || (surface = this.zze) == null || this.zzj == Integer.MIN_VALUE) {
            return;
        }
        float f = 0.0f;
        if (this.zzd) {
            float f2 = this.zzg;
            if (f2 != -1.0f) {
                f = this.zzi * f2;
            }
        }
        if (z || this.zzh != f) {
            this.zzh = f;
            zzabc.zza(surface, f);
        }
    }

    private final void zzn() {
        Surface surface;
        if (Build.VERSION.SDK_INT < 30 || (surface = this.zze) == null || this.zzj == Integer.MIN_VALUE || this.zzh == 0.0f) {
            return;
        }
        this.zzh = 0.0f;
        zzabc.zza(surface, 0.0f);
    }

    public final void zza(int i) {
        if (this.zzj == i) {
            return;
        }
        this.zzj = i;
        zzm(true);
    }

    public final void zzb() {
        this.zzd = true;
        zzk();
        zzabd zzabdVar = this.zzb;
        if (zzabdVar != null) {
            zzabe zzabeVar = this.zzc;
            zzabeVar.getClass();
            zzabeVar.zzb();
            zzabdVar.zza();
        }
        zzm(false);
    }

    public final void zzc(Surface surface) {
        if (this.zze == surface) {
            return;
        }
        zzn();
        this.zze = surface;
        zzm(true);
    }

    public final void zzd() {
        zzk();
    }

    public final void zze(float f) {
        this.zzi = f;
        zzk();
        zzm(false);
    }

    public final void zzf(float f) {
        this.zzf = f;
        this.zza.zza();
        zzl();
    }

    public final void zzg(long j) {
        long j2 = this.zzn;
        if (j2 != -1) {
            this.zzp = j2;
            this.zzq = this.zzo;
        }
        this.zzm++;
        this.zza.zzb(j * 1000);
        zzl();
    }

    public final void zzh() {
        this.zzd = false;
        zzabd zzabdVar = this.zzb;
        if (zzabdVar != null) {
            zzabdVar.zzb();
            zzabe zzabeVar = this.zzc;
            zzabeVar.getClass();
            zzabeVar.zzc();
        }
        zzn();
    }

    public final long zzi(long j) {
        long j2;
        if (this.zzp != -1) {
            zzaad zzaadVar = this.zza;
            if (zzaadVar.zzc()) {
                long jZzf = zzaadVar.zzf();
                long j3 = this.zzq + ((long) ((jZzf * (this.zzm - this.zzp)) / this.zzi));
                if (Math.abs(j - j3) > 20000000) {
                    zzk();
                } else {
                    j = j3;
                }
            }
        }
        this.zzn = this.zzm;
        this.zzo = j;
        zzabe zzabeVar = this.zzc;
        if (zzabeVar != null && this.zzk != C.TIME_UNSET) {
            long j4 = zzabeVar.zza;
            if (j4 != C.TIME_UNSET) {
                long j5 = this.zzk;
                long j6 = j4 + (((j - j4) / j5) * j5);
                if (j <= j6) {
                    j2 = j6 - j5;
                } else {
                    j6 = j5 + j6;
                    j2 = j6;
                }
                long j7 = this.zzl;
                if (j6 - j >= j - j2) {
                    j6 = j2;
                }
                return j6 - j7;
            }
        }
        return j;
    }

    final /* synthetic */ void zzj(Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            this.zzk = refreshRate;
            this.zzl = (refreshRate * 80) / 100;
        } else {
            zzdt.zzc("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            this.zzk = C.TIME_UNSET;
            this.zzl = C.TIME_UNSET;
        }
    }

    public zzabf(Context context) {
        DisplayManager displayManager;
        zzabd zzabdVar = (context == null || (displayManager = (DisplayManager) context.getSystemService("display")) == null) ? null : new zzabd(this, displayManager);
        this.zzb = zzabdVar;
        this.zzc = zzabdVar != null ? zzabe.zza() : null;
        this.zzk = C.TIME_UNSET;
        this.zzl = C.TIME_UNSET;
        this.zzf = -1.0f;
        this.zzi = 1.0f;
        this.zzj = 0;
    }
}
