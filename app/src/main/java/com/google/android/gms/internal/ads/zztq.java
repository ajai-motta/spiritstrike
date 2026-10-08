package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Pair;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zztq {
    public static final /* synthetic */ int zza = 0;
    private static final HashMap zzb = new HashMap();

    public static zzsy zza() throws zzti {
        List listZzb = zzb(MimeTypes.AUDIO_RAW, false, false);
        if (listZzb.isEmpty()) {
            return null;
        }
        return (zzsy) listZzb.get(0);
    }

    public static synchronized List zzb(String str, boolean z, boolean z2) throws zzti {
        zzth zzthVar = new zzth(str, z, z2);
        HashMap map = zzb;
        List list = (List) map.get(zzthVar);
        if (list != null) {
            return list;
        }
        ArrayList arrayListZzh = zzh(zzthVar, new zztl(z, z2, str.equals("video/mv-hevc")));
        if (z && arrayListZzh.isEmpty() && Build.VERSION.SDK_INT == 23) {
            arrayListZzh = zzh(zzthVar, new zztk(null));
            if (!arrayListZzh.isEmpty()) {
                String str2 = ((zzsy) arrayListZzh.get(0)).zza;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + str2.length());
                sb.append("MediaCodecList API didn't list secure decoder for: ");
                sb.append(str);
                sb.append(". Assuming: ");
                sb.append(str2);
                zzdt.zzc("MediaCodecUtil", sb.toString());
            }
        }
        if (MimeTypes.AUDIO_RAW.equals(str)) {
            if (Build.VERSION.SDK_INT < 26 && Build.DEVICE.equals("R9") && arrayListZzh.size() == 1 && ((zzsy) arrayListZzh.get(0)).zza.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                arrayListZzh.add(zzsy.zza("OMX.google.raw.decoder", MimeTypes.AUDIO_RAW, MimeTypes.AUDIO_RAW, null, false, true, false, false, false));
            }
            zzj(arrayListZzh, zztm.zza);
        }
        if (Build.VERSION.SDK_INT < 32 && arrayListZzh.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((zzsy) arrayListZzh.get(0)).zza)) {
            arrayListZzh.add((zzsy) arrayListZzh.remove(0));
        }
        zzgpe zzgpeVarZzq = zzgpe.zzq(arrayListZzh);
        map.put(zzthVar, zzgpeVarZzq);
        return zzgpeVarZzq;
    }

    @RequiresNonNull({"#2.sampleMimeType"})
    public static List zzc(zztg zztgVar, zzv zzvVar, boolean z, boolean z2) throws zzti {
        List listZza = zztgVar.zza(zzvVar.zzo, z, z2);
        List listZzd = zzd(zztgVar, zzvVar, z, z2);
        int i = zzgpe.zzd;
        zzgpb zzgpbVar = new zzgpb();
        zzgpbVar.zzh(listZza);
        zzgpbVar.zzh(listZzd);
        return zzgpbVar.zzi();
    }

    public static List zzd(zztg zztgVar, zzv zzvVar, boolean z, boolean z2) throws zzti {
        String strZzg = zzg(zzvVar);
        return strZzg == null ? zzgpe.zzi() : zztgVar.zza(strZzg, z, z2);
    }

    public static List zze(List list, final zzv zzvVar) {
        ArrayList arrayList = new ArrayList(list);
        zzj(arrayList, new zztp() { // from class: com.google.android.gms.internal.ads.zzto
            @Override // com.google.android.gms.internal.ads.zztp
            public final /* synthetic */ int zza(Object obj) {
                int i = zztq.zza;
                return ((zzsy) obj).zzd(zzvVar) ? 1 : 0;
            }
        });
        return arrayList;
    }

    public static MediaCodecInfo.CodecProfileLevel zzf(int i, int i2) {
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = i;
        codecProfileLevel.level = i2;
        return codecProfileLevel;
    }

    public static String zzg(zzv zzvVar) {
        Pair pairZzd;
        String str = zzvVar.zzo;
        if (MimeTypes.AUDIO_E_AC3_JOC.equals(str)) {
            return MimeTypes.AUDIO_E_AC3;
        }
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(str) && (pairZzd = zzdd.zzd(zzvVar)) != null) {
            int iIntValue = ((Integer) pairZzd.first).intValue();
            if (iIntValue == 16 || iIntValue == 256) {
                return "video/hevc";
            }
            if (iIntValue == 512) {
                return "video/avc";
            }
            if (iIntValue == 1024) {
                return "video/av01";
            }
        }
        if ("video/mv-hevc".equals(str)) {
            return "video/hevc";
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01c6 A[Catch: Exception -> 0x0283, TryCatch #4 {Exception -> 0x0283, blocks: (B:94:0x019e, B:101:0x01ac, B:107:0x01c0, B:109:0x01c6, B:114:0x01d6, B:110:0x01cb), top: B:173:0x019e }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01cb A[Catch: Exception -> 0x0283, TryCatch #4 {Exception -> 0x0283, blocks: (B:94:0x019e, B:101:0x01ac, B:107:0x01c0, B:109:0x01c6, B:114:0x01d6, B:110:0x01cb), top: B:173:0x019e }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01e7 A[Catch: Exception -> 0x0281, TryCatch #5 {Exception -> 0x0281, blocks: (B:117:0x01e2, B:118:0x01e7, B:120:0x01f7, B:122:0x01ff), top: B:175:0x01e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0212 A[PHI: r4
  0x0212: PHI (r4v6 boolean) = (r4v5 boolean), (r4v12 boolean) binds: [B:126:0x020c, B:128:0x0210] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x029b A[Catch: Exception -> 0x0310, TRY_ENTER, TryCatch #0 {Exception -> 0x0310, blocks: (B:3:0x0012, B:5:0x0027, B:7:0x0031, B:10:0x0044, B:14:0x0052, B:16:0x0058, B:18:0x0062, B:20:0x006a, B:22:0x0072, B:24:0x007c, B:26:0x0086, B:28:0x0090, B:30:0x009a, B:32:0x00a4, B:34:0x00ae, B:36:0x00b8, B:38:0x00c2, B:40:0x00cc, B:42:0x00d2, B:44:0x00da, B:49:0x00f1, B:51:0x00fc, B:150:0x0295, B:153:0x029b, B:155:0x02a1, B:156:0x02c2, B:157:0x02f1, B:54:0x0109, B:55:0x010e, B:57:0x0116, B:60:0x0121, B:62:0x0129, B:65:0x0134, B:67:0x013c, B:69:0x0144, B:74:0x0152, B:76:0x015a, B:79:0x0165, B:81:0x016d, B:84:0x0178, B:86:0x0180), top: B:165:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x01e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02c2 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.ArrayList zzh(com.google.android.gms.internal.ads.zzth r30, com.google.android.gms.internal.ads.zztj r31) throws com.google.android.gms.internal.ads.zzti {
        /*
            Method dump skipped, instruction units count: 792
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztq.zzh(com.google.android.gms.internal.ads.zzth, com.google.android.gms.internal.ads.zztj):java.util.ArrayList");
    }

    private static boolean zzi(MediaCodecInfo mediaCodecInfo, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (zzas.zza(str)) {
            return true;
        }
        String strZza = zzglm.zza(mediaCodecInfo.getName());
        if (strZza.startsWith("arc.")) {
            return false;
        }
        if (strZza.startsWith("omx.google.") || strZza.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((strZza.startsWith("omx.sec.") && strZza.contains(".sw.")) || strZza.equals("omx.qcom.video.decoder.hevcswvdec") || strZza.startsWith("c2.android.") || strZza.startsWith("c2.google.")) {
            return true;
        }
        return (strZza.startsWith("omx.") || strZza.startsWith("c2.")) ? false : true;
    }

    private static void zzj(List list, final zztp zztpVar) {
        Collections.sort(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zztn
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                int i = zztq.zza;
                zztp zztpVar2 = zztpVar;
                return zztpVar2.zza(obj2) - zztpVar2.zza(obj);
            }
        });
    }
}
