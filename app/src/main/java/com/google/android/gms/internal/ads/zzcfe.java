package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.api.Releasable;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
@ParametersAreNonnullByDefault
public abstract class zzcfe implements Releasable {
    protected final Context zza;
    protected final String zzb;
    protected final WeakReference zzc;

    public zzcfe(zzcdr zzcdrVar) {
        Context context = zzcdrVar.getContext();
        this.zza = context;
        this.zzb = com.google.android.gms.ads.internal.zzt.zzc().zze(context, zzcdrVar.zzs().afmaVersion);
        this.zzc = new WeakReference(zzcdrVar);
    }

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
    }

    public abstract boolean zze(String str);

    public boolean zzf(String str, String[] strArr) {
        return zze(str);
    }

    public boolean zzg(String str, String[] strArr, zzcew zzcewVar) {
        return zze(str);
    }

    protected void zzh(int i) {
    }

    protected void zzi(int i) {
    }

    protected void zzj(int i) {
    }

    protected void zzk(int i) {
    }

    public abstract void zzl();

    public final void zzm(String str, String str2, long j, long j2, boolean z, long j3, long j4, long j5, int i, int i2) {
        com.google.android.gms.ads.internal.util.client.zzf.zza.post(new zzcez(this, str, str2, j, j2, j3, j4, j5, z, i, i2));
    }

    public final void zzn(String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        com.google.android.gms.ads.internal.util.client.zzf.zza.post(new zzcfa(this, str, str2, i, i2, j, j2, z, i3, i4));
    }

    protected final void zzo(String str, String str2, int i) {
        com.google.android.gms.ads.internal.util.client.zzf.zza.post(new zzcfb(this, str, str2, i));
    }

    public final void zzp(String str, String str2, long j) {
        com.google.android.gms.ads.internal.util.client.zzf.zza.post(new zzcfc(this, str, str2, j));
    }

    public final void zzq(String str, String str2, String str3, String str4) {
        com.google.android.gms.ads.internal.util.client.zzf.zza.post(new zzcfd(this, str, str2, str3, str4));
    }

    final /* synthetic */ void zzw(String str, Map map) {
        zzcdr zzcdrVar = (zzcdr) this.zzc.get();
        if (zzcdrVar != null) {
            zzcdrVar.zze("onPrecacheEvent", map);
        }
    }
}
