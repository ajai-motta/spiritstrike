package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.exoplayer2.PlaybackException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfta implements zzfrv {
    private final Object zza;
    private final zzftb zzb;
    private final zzftm zzc;
    private final zzfrs zzd;
    private final boolean zze;

    zzfta(Object obj, zzftb zzftbVar, zzftm zzftmVar, zzfrs zzfrsVar, boolean z) {
        this.zza = obj;
        this.zzb = zzftbVar;
        this.zzc = zzftmVar;
        this.zzd = zzfrsVar;
        this.zze = z;
    }

    private static String zzi(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        zzavp zzavpVarZza = zzavq.zza();
        zzavpVarZza.zzd(5);
        zzavpVarZza.zza(zzhvi.zzr(bArr, 0, bArr.length));
        return Base64.encodeToString(((zzavq) zzavpVarZza.zzbu()).zzaN(), 11);
    }

    private final synchronized byte[] zzj(Map map, Map map2) {
        Object obj;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            obj = this.zza;
        } catch (Exception e) {
            this.zzd.zzc(PlaybackException.ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED, System.currentTimeMillis() - jCurrentTimeMillis, e);
            return null;
        }
        return (byte[]) obj.getClass().getDeclaredMethod("xss", Map.class, Map.class).invoke(obj, null, map2);
    }

    @Override // com.google.android.gms.internal.ads.zzfrv
    public final synchronized String zza(Context context, String str) {
        byte[] bArrZzj;
        Map mapZzb = this.zzc.zzb();
        mapZzb.put(InneractiveMediationDefs.GENDER_FEMALE, "q");
        mapZzb.put("ctx", context);
        mapZzb.put("aid", null);
        bArrZzj = zzj(null, mapZzb);
        if (this.zze) {
            mapZzb.clear();
        }
        return zzi(bArrZzj);
    }

    @Override // com.google.android.gms.internal.ads.zzfrv
    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        byte[] bArrZzj;
        Map mapZzc = this.zzc.zzc();
        mapZzc.put(InneractiveMediationDefs.GENDER_FEMALE, "v");
        mapZzc.put("ctx", context);
        mapZzc.put("aid", null);
        mapZzc.put("view", view);
        mapZzc.put("act", activity);
        bArrZzj = zzj(null, mapZzc);
        if (this.zze) {
            mapZzc.clear();
        }
        return zzi(bArrZzj);
    }

    @Override // com.google.android.gms.internal.ads.zzfrv
    public final synchronized String zzc(Context context, String str, String str2, View view, Activity activity) {
        byte[] bArrZzj;
        Map mapZzd = this.zzc.zzd();
        mapZzd.put(InneractiveMediationDefs.GENDER_FEMALE, "c");
        mapZzd.put("ctx", context);
        mapZzd.put("cs", str2);
        mapZzd.put("aid", null);
        mapZzd.put("view", view);
        mapZzd.put("act", activity);
        bArrZzj = zzj(null, mapZzd);
        if (this.zze) {
            mapZzd.clear();
        }
        return zzi(bArrZzj);
    }

    @Override // com.google.android.gms.internal.ads.zzfrv
    public final synchronized void zzd(String str, MotionEvent motionEvent) throws zzftk {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Map mapZze = this.zzc.zze();
            mapZze.put("aid", null);
            mapZze.put("evt", motionEvent);
            Object obj = this.zza;
            obj.getClass().getDeclaredMethod("he", Map.class).invoke(obj, mapZze);
            this.zzd.zzb(3003, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (Exception e) {
            throw new zzftk(PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND, e);
        }
    }

    final zzftb zze() {
        return this.zzb;
    }

    final synchronized boolean zzf() throws zzftk {
        Object obj;
        try {
            obj = this.zza;
        } catch (Exception e) {
            throw new zzftk(2001, e);
        }
        return ((Boolean) obj.getClass().getDeclaredMethod("init", new Class[0]).invoke(obj, new Object[0])).booleanValue();
    }

    public final synchronized void zzg() throws zzftk {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Object obj = this.zza;
            obj.getClass().getDeclaredMethod("close", new Class[0]).invoke(obj, new Object[0]);
            this.zzd.zzb(3001, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (Exception e) {
            throw new zzftk(2003, e);
        }
    }

    public final synchronized int zzh() throws zzftk {
        Object obj;
        try {
            obj = this.zza;
        } catch (Exception e) {
            throw new zzftk(2006, e);
        }
        return ((Integer) obj.getClass().getDeclaredMethod("lcs", new Class[0]).invoke(obj, new Object[0])).intValue();
    }
}
