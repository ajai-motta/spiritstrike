package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzazq {
    private final zzayd zza;
    private final String zzb;
    private final String zzc;
    private final Class[] zze;
    private volatile Method zzd = null;
    private final CountDownLatch zzf = new CountDownLatch(1);

    public zzazq(zzayd zzaydVar, String str, String str2, Class... clsArr) {
        this.zza = zzaydVar;
        this.zzb = str;
        this.zzc = str2;
        this.zze = clsArr;
        zzaydVar.zzd().submit(new zzazp(this));
    }

    private final String zzc(byte[] bArr, String str) throws zzaxh, UnsupportedEncodingException {
        return new String(this.zza.zzf().zzb(bArr, str), "UTF-8");
    }

    public final Method zza() {
        if (this.zzd != null) {
            return this.zzd;
        }
        try {
            if (this.zzf.await(2L, TimeUnit.SECONDS)) {
                return this.zzd;
            }
            return null;
        } catch (InterruptedException unused) {
            return null;
        }
    }

    final /* synthetic */ void zzb() {
        try {
            zzayd zzaydVar = this.zza;
            Class clsLoadClass = zzaydVar.zze().loadClass(zzc(zzaydVar.zzg(), this.zzb));
            if (clsLoadClass != null) {
                this.zzd = clsLoadClass.getMethod(zzc(zzaydVar.zzg(), this.zzc), this.zze);
            }
        } catch (zzaxh | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException | NullPointerException unused) {
        } catch (Throwable th) {
            this.zzf.countDown();
            throw th;
        }
        this.zzf.countDown();
    }
}
