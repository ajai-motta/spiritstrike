package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.facebook.internal.NativeProtocol;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcej extends zzccx implements TextureView.SurfaceTextureListener, zzcdh {
    private final zzcdr zzc;
    private final zzcds zzd;
    private final zzcdq zze;
    private final zzdvi zzf;
    private zzccw zzg;
    private Surface zzh;
    private zzcdi zzi;
    private String zzj;
    private String[] zzk;
    private boolean zzl;
    private int zzm;
    private zzcdp zzn;
    private final boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private int zzr;
    private int zzs;
    private float zzt;

    public zzcej(Context context, zzcds zzcdsVar, zzcdr zzcdrVar, boolean z, boolean z2, zzcdq zzcdqVar, zzdvi zzdviVar) {
        super(context);
        this.zzm = 1;
        this.zzc = zzcdrVar;
        this.zzd = zzcdsVar;
        this.zzo = z;
        this.zze = zzcdqVar;
        zzcdsVar.zza(this);
        this.zzf = zzdviVar;
    }

    private final boolean zzT() {
        zzcdi zzcdiVar = this.zzi;
        return (zzcdiVar == null || !zzcdiVar.zzB() || this.zzl) ? false : true;
    }

    private final boolean zzU() {
        return zzT() && this.zzm != 1;
    }

    private final void zzV(boolean z, Integer num) {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null && !z) {
            zzcdiVar.zzn(num);
            return;
        }
        if (this.zzj == null || this.zzh == null) {
            return;
        }
        if (z) {
            if (!zzT()) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("No valid ExoPlayerAdapter exists when switch source.");
                return;
            } else {
                zzcdiVar.zzw();
                zzW();
            }
        }
        if (this.zzj.startsWith("cache:")) {
            zzcfe zzcfeVarZzr = this.zzc.zzr(this.zzj);
            if (zzcfeVarZzr instanceof zzcfn) {
                zzcdi zzcdiVarZza = ((zzcfn) zzcfeVarZzr).zza();
                this.zzi = zzcdiVarZza;
                zzcdiVarZza.zzn(num);
                if (!this.zzi.zzB()) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Precached video player has been released.");
                    return;
                }
            } else {
                if (!(zzcfeVarZzr instanceof zzcfk)) {
                    String str = this.zzj;
                    String.valueOf(str);
                    String strValueOf = String.valueOf(str);
                    int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Stream cache miss: ".concat(strValueOf));
                    return;
                }
                zzcfk zzcfkVar = (zzcfk) zzcfeVarZzr;
                String strZzF = zzF();
                ByteBuffer byteBufferZzu = zzcfkVar.zzu();
                boolean zZzt = zzcfkVar.zzt();
                String strZzs = zzcfkVar.zzs();
                if (strZzs == null) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Stream cache URL is null.");
                    return;
                } else {
                    zzcdi zzcdiVarZzE = zzE(num);
                    this.zzi = zzcdiVarZzE;
                    zzcdiVarZzE.zzr(new Uri[]{Uri.parse(strZzs)}, strZzF, byteBufferZzu, zZzt);
                }
            }
        } else {
            this.zzi = zzE(num);
            String strZzF2 = zzF();
            Uri[] uriArr = new Uri[this.zzk.length];
            int i5 = 0;
            while (true) {
                String[] strArr = this.zzk;
                if (i5 >= strArr.length) {
                    break;
                }
                uriArr[i5] = Uri.parse(strArr[i5]);
                i5++;
            }
            this.zzi.zzq(uriArr, strZzF2);
        }
        this.zzi.zzs(this);
        zzX(this.zzh, false);
        if (this.zzi.zzB()) {
            int iZzC = this.zzi.zzC();
            this.zzm = iZzC;
            if (iZzC == 3) {
                zzY();
            }
        }
    }

    private final void zzW() {
        if (this.zzi != null) {
            zzX(null, true);
            zzcdi zzcdiVar = this.zzi;
            if (zzcdiVar != null) {
                zzcdiVar.zzs(null);
                this.zzi.zzt();
                this.zzi = null;
            }
            this.zzm = 1;
            this.zzl = false;
            this.zzp = false;
            this.zzq = false;
        }
    }

    private final void zzX(Surface surface, boolean z) {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Trying to set surface before player is initialized.");
            return;
        }
        try {
            zzcdiVar.zzu(surface, z);
        } catch (IOException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("", e);
        }
    }

    private final void zzY() {
        if (this.zzp) {
            return;
        }
        this.zzp = true;
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdw
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzH();
            }
        });
        zzq();
        this.zzd.zzb();
        if (this.zzq) {
            zze();
        }
    }

    private static String zzZ(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        int length = String.valueOf(canonicalName).length();
        StringBuilder sb = new StringBuilder(str.length() + 1 + length + 1 + String.valueOf(message).length());
        sb.append(str);
        sb.append(DomExceptionUtils.SEPARATOR);
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        return sb.toString();
    }

    private final void zzaa() {
        zzab(this.zzr, this.zzs);
    }

    private final void zzab(int i, int i2) {
        float f = i2 > 0 ? i / i2 : 1.0f;
        if (this.zzt != f) {
            this.zzt = f;
            requestLayout();
        }
    }

    private final void zzac() {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            zzcdiVar.zzM(true);
        }
    }

    private final void zzad() {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            zzcdiVar.zzM(false);
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setSurfaceTextureListener(this);
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = this.zzt;
        if (f != 0.0f && this.zzn == null) {
            float f2 = measuredWidth;
            float f3 = f2 / measuredHeight;
            if (f > f3) {
                measuredHeight = (int) (f2 / f);
            }
            if (f < f3) {
                measuredWidth = (int) (measuredHeight * f);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzcdp zzcdpVar = this.zzn;
        if (zzcdpVar != null) {
            zzcdpVar.zzc(measuredWidth, measuredHeight);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzdvi zzdviVar;
        if (this.zzo) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzon)).booleanValue() && (zzdviVar = this.zzf) != null) {
                zzdvh zzdvhVarZza = zzdviVar.zza();
                zzdvhVarZza.zzc(NativeProtocol.WEB_DIALOG_ACTION, "svp_aepv");
                zzdvhVarZza.zzd();
            }
            zzcdp zzcdpVar = new zzcdp(getContext());
            this.zzn = zzcdpVar;
            zzcdpVar.zzb(surfaceTexture, i, i2);
            zzcdp zzcdpVar2 = this.zzn;
            zzcdpVar2.start();
            SurfaceTexture surfaceTextureZze = zzcdpVar2.zze();
            if (surfaceTextureZze != null) {
                surfaceTexture = surfaceTextureZze;
            } else {
                this.zzn.zzd();
                this.zzn = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzh = surface;
        if (this.zzi == null) {
            zzV(false, null);
        } else {
            zzX(surface, true);
            if (!this.zze.zza) {
                zzac();
            }
        }
        if (this.zzr == 0 || this.zzs == 0) {
            zzab(i, i2);
        } else {
            zzaa();
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzced
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzM();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzf();
        zzcdp zzcdpVar = this.zzn;
        if (zzcdpVar != null) {
            zzcdpVar.zzd();
            this.zzn = null;
        }
        if (this.zzi != null) {
            zzad();
            Surface surface = this.zzh;
            if (surface != null) {
                surface.release();
            }
            this.zzh = null;
            zzX(null, true);
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcef
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzO();
            }
        });
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, final int i, final int i2) {
        zzcdp zzcdpVar = this.zzn;
        if (zzcdpVar != null) {
            zzcdpVar.zzc(i, i2);
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcee
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzN(i, i2);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzd.zzd(this);
        this.zza.zzb(surfaceTexture, this.zzg);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(final int i) {
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 46);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i);
        com.google.android.gms.ads.internal.util.zze.zza(sb.toString());
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzceg
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzP(i);
            }
        });
        super.onWindowVisibilityChanged(i);
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzA(int i) {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            zzcdiVar.zzy(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzB(int i) {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            zzcdiVar.zzz(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzC(int i) {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            zzcdiVar.zzA(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzD() {
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdy
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzS();
            }
        });
    }

    final zzcdi zzE(Integer num) {
        zzcdq zzcdqVar = this.zze;
        zzcdr zzcdrVar = this.zzc;
        zzcgg zzcggVar = new zzcgg(zzcdrVar.getContext(), zzcdqVar, zzcdrVar, num);
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzh("ExoPlayerAdapter initialized.");
        return zzcggVar;
    }

    final String zzF() {
        zzcdr zzcdrVar = this.zzc;
        return com.google.android.gms.ads.internal.zzt.zzc().zze(zzcdrVar.getContext(), zzcdrVar.zzs().afmaVersion);
    }

    final /* synthetic */ void zzG() {
        float fZzc = this.zzb.zzc();
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Trying to set volume before player is initialized.");
            return;
        }
        try {
            zzcdiVar.zzv(fZzc, false);
        } catch (IOException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("", e);
        }
    }

    final /* synthetic */ void zzH() {
        zzccw zzccwVar = this.zzg;
        if (zzccwVar != null) {
            zzccwVar.zzb();
        }
    }

    final /* synthetic */ void zzI() {
        zzccw zzccwVar = this.zzg;
        if (zzccwVar != null) {
            zzccwVar.zze();
        }
    }

    final /* synthetic */ void zzJ(String str) {
        zzccw zzccwVar = this.zzg;
        if (zzccwVar != null) {
            zzccwVar.zzf("ExoPlayerAdapter error", str);
        }
    }

    final /* synthetic */ void zzK() {
        zzccw zzccwVar = this.zzg;
        if (zzccwVar != null) {
            zzccwVar.zzc();
        }
    }

    final /* synthetic */ void zzL() {
        zzccw zzccwVar = this.zzg;
        if (zzccwVar != null) {
            zzccwVar.zzd();
        }
    }

    final /* synthetic */ void zzM() {
        zzccw zzccwVar = this.zzg;
        if (zzccwVar != null) {
            zzccwVar.zza();
        }
    }

    final /* synthetic */ void zzN(int i, int i2) {
        zzccw zzccwVar = this.zzg;
        if (zzccwVar != null) {
            zzccwVar.zzj(i, i2);
        }
    }

    final /* synthetic */ void zzO() {
        zzccw zzccwVar = this.zzg;
        if (zzccwVar != null) {
            zzccwVar.zzh();
        }
    }

    final /* synthetic */ void zzP(int i) {
        zzccw zzccwVar = this.zzg;
        if (zzccwVar != null) {
            zzccwVar.onWindowVisibilityChanged(i);
        }
    }

    final /* synthetic */ void zzQ(boolean z, long j) {
        this.zzc.zzu(z, j);
    }

    final /* synthetic */ void zzR(String str) {
        zzccw zzccwVar = this.zzg;
        if (zzccwVar != null) {
            zzccwVar.zzg("ExoPlayerAdapter exception", str);
        }
    }

    final /* synthetic */ void zzS() {
        zzccw zzccwVar = this.zzg;
        if (zzccwVar != null) {
            zzccwVar.zzk();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final String zza() {
        return "ExoPlayer/2".concat(true != this.zzo ? "" : " spherical");
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzb(zzccw zzccwVar) {
        this.zzg = zzccwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzc(String str) {
        if (str != null) {
            zzx(str, null, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzd() {
        if (zzT()) {
            this.zzi.zzw();
            zzW();
        }
        zzcds zzcdsVar = this.zzd;
        zzcdsVar.zzf();
        this.zzb.zze();
        zzcdsVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zze() {
        if (!zzU()) {
            this.zzq = true;
            return;
        }
        if (this.zze.zza) {
            zzac();
        }
        this.zzi.zzE(true);
        this.zzd.zze();
        this.zzb.zzd();
        this.zza.zza();
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzceb
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzK();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzf() {
        if (zzU()) {
            if (this.zze.zza) {
                zzad();
            }
            this.zzi.zzE(false);
            this.zzd.zzf();
            this.zzb.zze();
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcec
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzL();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final int zzg() {
        if (zzU()) {
            return (int) this.zzi.zzH();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final int zzh() {
        if (zzU()) {
            return (int) this.zzi.zzD();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzi(int i) {
        if (zzU()) {
            this.zzi.zzx(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzj(float f, float f2) {
        zzcdp zzcdpVar = this.zzn;
        if (zzcdpVar != null) {
            zzcdpVar.zzf(f, f2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final int zzk() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final int zzl() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final long zzm() {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            return zzcdiVar.zzI();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final long zzn() {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            return zzcdiVar.zzJ();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final long zzo() {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            return zzcdiVar.zzK();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final int zzp() {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            return zzcdiVar.zzL();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzccx, com.google.android.gms.internal.ads.zzcdu
    public final void zzq() {
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcei
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzG();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzr(final boolean z, final long j) {
        if (this.zzc != null) {
            zzcbv.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzceh
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzQ(z, j);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzs(int i) {
        if (this.zzm != i) {
            this.zzm = i;
            if (i == 3) {
                zzY();
                return;
            }
            if (i != 4) {
                return;
            }
            if (this.zze.zza) {
                zzad();
            }
            this.zzd.zzf();
            this.zzb.zze();
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdz
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzI();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzt(int i, int i2) {
        this.zzr = i;
        this.zzs = i2;
        zzaa();
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzu(String str, Exception exc) {
        final String strZzZ = zzZ(str, exc);
        String strConcat = "ExoPlayerAdapter error: ".concat(strZzZ);
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi(strConcat);
        this.zzl = true;
        if (this.zze.zza) {
            zzad();
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcea
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzJ(strZzZ);
            }
        });
        com.google.android.gms.ads.internal.zzt.zzh().zzh(exc, "AdExoPlayerView.onError");
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzv(String str, Exception exc) {
        final String strZzZ = zzZ("onLoadException", exc);
        String strConcat = "ExoPlayerAdapter exception: ".concat(strZzZ);
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi(strConcat);
        com.google.android.gms.ads.internal.zzt.zzh().zzh(exc, "AdExoPlayerView.onException");
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdx
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzR(strZzZ);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final Integer zzw() {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            return zzcdiVar.zzj();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzy(int i) {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            zzcdiVar.zzF(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzz(int i) {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            zzcdiVar.zzG(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzx(String str, String[] strArr, Integer num) {
        if (str == null) {
            return;
        }
        if (strArr == null) {
            this.zzk = new String[]{str};
        } else {
            this.zzk = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        String str2 = this.zzj;
        boolean z = false;
        if (this.zze.zzk && str2 != null && !str.equals(str2) && this.zzm == 4) {
            z = true;
        }
        this.zzj = str;
        zzV(z, num);
    }
}
