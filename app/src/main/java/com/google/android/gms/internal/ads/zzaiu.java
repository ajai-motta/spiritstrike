package com.google.android.gms.internal.ads;

import coil.util.Utils;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaiu {
    public static String zza(List list) {
        Iterator it = list.iterator();
        String str = null;
        boolean z = false;
        while (it.hasNext()) {
            String str2 = ((zzaji) it.next()).zza.zzg.zzo;
            if (zzas.zzb(str2)) {
                return MimeTypes.VIDEO_MP4;
            }
            if (zzas.zza(str2)) {
                z = true;
            } else if (zzas.zzc(str2)) {
                if (Objects.equals(str2, Utils.MIME_TYPE_HEIC)) {
                    str = Utils.MIME_TYPE_HEIF;
                } else if (Objects.equals(str2, "image/avif")) {
                    str = "image/avif";
                }
            }
        }
        return z ? MimeTypes.AUDIO_MP4 : str != null ? str : MimeTypes.APPLICATION_MP4;
    }
}
