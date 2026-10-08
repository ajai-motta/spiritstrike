package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzsf implements zzst {
    private final zzgmv zza;
    private final zzgmv zzb;

    public zzsf(final int i) {
        zzgmv zzgmvVar = new zzgmv() { // from class: com.google.android.gms.internal.ads.zzse
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final /* synthetic */ Object zza() {
                return new HandlerThread(zzsg.zzt(i, "ExoPlayer:MediaCodecAsyncAdapter:"));
            }
        };
        zzgmv zzgmvVar2 = new zzgmv() { // from class: com.google.android.gms.internal.ads.zzsd
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final /* synthetic */ Object zza() {
                return new HandlerThread(zzsg.zzt(i, "ExoPlayer:MediaCodecQueueingThread:"));
            }
        };
        this.zza = zzgmvVar;
        this.zzb = zzgmvVar2;
    }

    public final zzsg zza(zzss zzssVar) throws Exception {
        MediaCodec mediaCodecCreateByCodecName;
        zzsy zzsyVar = zzssVar.zza;
        String str = zzsyVar.zza;
        zzsg zzsgVar = null;
        try {
            StringBuilder sb = new StringBuilder(str.length() + 12);
            sb.append("createCodec:");
            sb.append(str);
            Trace.beginSection(sb.toString());
            mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            try {
                zzsg zzsgVar2 = new zzsg(mediaCodecCreateByCodecName, (HandlerThread) this.zza.zza(), new zzsj(mediaCodecCreateByCodecName, (HandlerThread) this.zzb.zza()), zzssVar.zzf, null);
                try {
                    Trace.endSection();
                    Surface surface = zzssVar.zzd;
                    int i = 0;
                    if (surface == null && zzsyVar.zzh && Build.VERSION.SDK_INT >= 35) {
                        i = 8;
                    }
                    zzsgVar2.zzq(zzssVar.zzb, surface, null, i);
                    return zzsgVar2;
                } catch (Exception e) {
                    e = e;
                    zzsgVar = zzsgVar2;
                    if (zzsgVar != null) {
                        zzsgVar.zzk();
                    } else if (mediaCodecCreateByCodecName != null) {
                        mediaCodecCreateByCodecName.release();
                    }
                    throw e;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            mediaCodecCreateByCodecName = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzst
    public final /* bridge */ /* synthetic */ zzsv zzb(zzss zzssVar) throws IOException {
        throw null;
    }
}
