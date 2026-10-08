package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.os.Build;
import android.os.Trace;
import android.view.Surface;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzsn implements zzst {
    private final Context zza;

    @Deprecated
    public zzsn() {
        this.zza = null;
    }

    public zzsn(Context context, zzgmv zzgmvVar, zzgmv zzgmvVar2) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzst
    public final zzsv zzb(zzss zzssVar) throws Throwable {
        Context context;
        zzsy zzsyVar;
        MediaCodec mediaCodecCreateByCodecName;
        if (Build.VERSION.SDK_INT >= 31 || ((context = this.zza) != null && Build.VERSION.SDK_INT >= 28 && context.getPackageManager().hasSystemFeature("com.amazon.hardware.tv_screen"))) {
            int iZzg = zzas.zzg(zzssVar.zzc.zzo);
            zzdt.zzb("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type ".concat(zzep.zzQ(iZzg)));
            return new zzsf(iZzg).zza(zzssVar);
        }
        MediaCodec mediaCodec = null;
        try {
            zzsyVar = zzssVar.zza;
            String str = zzsyVar.zza;
            Trace.beginSection("createCodec:".concat(str));
            mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            Trace.endSection();
        } catch (IOException e) {
            e = e;
        } catch (RuntimeException e2) {
            e = e2;
        }
        try {
            Trace.beginSection("configureCodec");
            Surface surface = zzssVar.zzd;
            int i = 0;
            if (surface == null && zzsyVar.zzh && Build.VERSION.SDK_INT >= 35) {
                i = 8;
            }
            mediaCodecCreateByCodecName.configure(zzssVar.zzb, surface, (MediaCrypto) null, i);
            Trace.endSection();
            Trace.beginSection("startCodec");
            mediaCodecCreateByCodecName.start();
            Trace.endSection();
            return new zztr(mediaCodecCreateByCodecName, zzssVar.zzf, null);
        } catch (IOException | RuntimeException e3) {
            e = e3;
            mediaCodec = mediaCodecCreateByCodecName;
            if (mediaCodec != null) {
                mediaCodec.release();
            }
            throw e;
        }
    }
}
