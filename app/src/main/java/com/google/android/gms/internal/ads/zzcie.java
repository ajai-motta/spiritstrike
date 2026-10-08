package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcie extends com.google.android.gms.ads.internal.client.zzec {
    private final zzcdr zza;
    private final boolean zzc;
    private final boolean zzd;
    private int zze;
    private com.google.android.gms.ads.internal.client.zzeg zzf;
    private boolean zzg;
    private float zzi;
    private float zzj;
    private float zzk;
    private boolean zzl;
    private boolean zzm;
    private zzbjq zzn;
    private final Object zzb = new Object();
    private boolean zzh = true;

    public zzcie(zzcdr zzcdrVar, float f, boolean z, boolean z2) {
        this.zza = zzcdrVar;
        this.zzi = f;
        this.zzc = z;
        this.zzd = z2;
    }

    private final void zzw(String str, Map map) {
        final HashMap map2 = map == null ? new HashMap() : new HashMap(map);
        map2.put(NativeProtocol.WEB_DIALOG_ACTION, str);
        zzcbv.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcid
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzt(map2);
            }
        });
    }

    private final void zzx(final int i, final int i2, final boolean z, final boolean z2) {
        zzcbv.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcic
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzu(i, i2, z, z2);
            }
        });
    }

    public final void zzc(com.google.android.gms.ads.internal.client.zzga zzgaVar) {
        Object obj = this.zzb;
        boolean z = zzgaVar.zzb;
        boolean z2 = zzgaVar.zzc;
        synchronized (obj) {
            this.zzl = z;
            this.zzm = z2;
        }
        boolean z3 = zzgaVar.zza;
        zzw("initialState", CollectionUtils.mapOf("muteStart", true != z3 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1", "customControlsRequested", true != z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1", "clickToExpandRequested", true != z2 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1"));
    }

    public final void zzd(float f) {
        synchronized (this.zzb) {
            this.zzj = f;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zze() {
        zzw("play", null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzf() {
        zzw("pause", null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzg(boolean z) {
        zzw(true != z ? "unmute" : "mute", null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzh() {
        boolean z;
        synchronized (this.zzb) {
            z = this.zzh;
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final int zzi() {
        int i;
        synchronized (this.zzb) {
            i = this.zze;
        }
        return i;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzj() {
        float f;
        synchronized (this.zzb) {
            f = this.zzi;
        }
        return f;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzk() {
        float f;
        synchronized (this.zzb) {
            f = this.zzj;
        }
        return f;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzl(com.google.android.gms.ads.internal.client.zzeg zzegVar) {
        synchronized (this.zzb) {
            this.zzf = zzegVar;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzm() {
        float f;
        synchronized (this.zzb) {
            f = this.zzk;
        }
        return f;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzn() {
        boolean z;
        synchronized (this.zzb) {
            z = false;
            if (this.zzc && this.zzl) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final com.google.android.gms.ads.internal.client.zzeg zzo() throws RemoteException {
        com.google.android.gms.ads.internal.client.zzeg zzegVar;
        synchronized (this.zzb) {
            zzegVar = this.zzf;
        }
        return zzegVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzp() {
        boolean z;
        Object obj = this.zzb;
        boolean zZzn = zzn();
        synchronized (obj) {
            z = false;
            if (!zZzn) {
                try {
                    if (this.zzm && this.zzd) {
                        z = true;
                    }
                } finally {
                }
            }
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzq() {
        zzw("stop", null);
    }

    public final void zzr() {
        boolean z;
        int i;
        synchronized (this.zzb) {
            z = this.zzh;
            i = this.zze;
            this.zze = 3;
        }
        zzx(i, 3, z, z);
    }

    public final void zzs(float f, float f2, int i, boolean z, float f3) {
        boolean z2;
        boolean z3;
        int i2;
        synchronized (this.zzb) {
            z2 = true;
            if (f2 == this.zzi && f3 == this.zzk) {
                z2 = false;
            }
            this.zzi = f2;
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zznO)).booleanValue()) {
                this.zzj = f;
            }
            z3 = this.zzh;
            this.zzh = z;
            i2 = this.zze;
            this.zze = i;
            float f4 = this.zzk;
            this.zzk = f3;
            if (Math.abs(f3 - f4) > 1.0E-4f) {
                this.zza.zzE().invalidate();
            }
        }
        if (z2) {
            try {
                zzbjq zzbjqVar = this.zzn;
                if (zzbjqVar != null) {
                    zzbjqVar.zze();
                }
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            }
        }
        zzx(i2, i, z3, z);
    }

    final /* synthetic */ void zzt(Map map) {
        this.zza.zze("pubVideoCmd", map);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0055 A[Catch: RemoteException -> 0x003f, all -> 0x0072, TryCatch #1 {RemoteException -> 0x003f, blocks: (B:31:0x0037, B:33:0x003b, B:37:0x0043, B:39:0x0047, B:41:0x004c, B:43:0x0050, B:45:0x0055, B:47:0x0059, B:48:0x005c, B:50:0x0063, B:52:0x0067), top: B:62:0x0037, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0070 A[Catch: all -> 0x0072, DONT_GENERATE, TryCatch #0 {, blocks: (B:4:0x0003, B:29:0x0033, B:31:0x0037, B:33:0x003b, B:37:0x0043, B:39:0x0047, B:41:0x004c, B:43:0x0050, B:45:0x0055, B:47:0x0059, B:48:0x005c, B:50:0x0063, B:52:0x0067, B:55:0x0070, B:54:0x006b), top: B:60:0x0003, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final /* synthetic */ void zzu(int r8, int r9, boolean r10, boolean r11) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.zzb
            monitor-enter(r0)
            boolean r1 = r7.zzg     // Catch: java.lang.Throwable -> L72
            r2 = 0
            r3 = 1
            if (r1 != 0) goto Lf
            if (r9 != r3) goto Lf
            r9 = r3
            r4 = r9
            r5 = r4
            goto L11
        Lf:
            r4 = r9
            r5 = r2
        L11:
            if (r8 == r9) goto L15
            r8 = r3
            goto L16
        L15:
            r8 = r2
        L16:
            if (r8 == 0) goto L1d
            if (r4 != r3) goto L1d
            r9 = r3
            r4 = r9
            goto L1e
        L1d:
            r9 = r2
        L1e:
            if (r8 == 0) goto L25
            r6 = 2
            if (r4 != r6) goto L25
            r6 = r3
            goto L26
        L25:
            r6 = r2
        L26:
            if (r8 == 0) goto L2d
            r8 = 3
            if (r4 != r8) goto L2d
            r8 = r3
            goto L2e
        L2d:
            r8 = r2
        L2e:
            if (r1 != 0) goto L32
            if (r5 == 0) goto L33
        L32:
            r2 = r3
        L33:
            r7.zzg = r2     // Catch: java.lang.Throwable -> L72
            if (r5 == 0) goto L41
            com.google.android.gms.ads.internal.client.zzeg r1 = r7.zzf     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L72
            if (r1 == 0) goto L41
            r1.zze()     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L72
            goto L41
        L3f:
            r8 = move-exception
            goto L6b
        L41:
            if (r9 == 0) goto L4a
            com.google.android.gms.ads.internal.client.zzeg r9 = r7.zzf     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L72
            if (r9 == 0) goto L4a
            r9.zzf()     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L72
        L4a:
            if (r6 == 0) goto L53
            com.google.android.gms.ads.internal.client.zzeg r9 = r7.zzf     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L72
            if (r9 == 0) goto L53
            r9.zzg()     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L72
        L53:
            if (r8 == 0) goto L61
            com.google.android.gms.ads.internal.client.zzeg r8 = r7.zzf     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L72
            if (r8 == 0) goto L5c
            r8.zzh()     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L72
        L5c:
            com.google.android.gms.internal.ads.zzcdr r8 = r7.zza     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L72
            r8.zzz()     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L72
        L61:
            if (r10 == r11) goto L70
            com.google.android.gms.ads.internal.client.zzeg r8 = r7.zzf     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L72
            if (r8 == 0) goto L70
            r8.zzi(r11)     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L72
            goto L70
        L6b:
            java.lang.String r9 = "#007 Could not call remote method."
            com.google.android.gms.ads.internal.util.client.zzo.zzl(r9, r8)     // Catch: java.lang.Throwable -> L72
        L70:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L72
            return
        L72:
            r8 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L72
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcie.zzu(int, int, boolean, boolean):void");
    }

    public final void zzv(zzbjq zzbjqVar) {
        synchronized (this.zzb) {
            this.zzn = zzbjqVar;
        }
    }
}
