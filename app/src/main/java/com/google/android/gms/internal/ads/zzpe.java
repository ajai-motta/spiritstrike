package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.SparseArray;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzpe {
    static final zzgph zzb;
    private final SparseArray zzd = new SparseArray();
    private final int zze;
    public static final zzpe zza = new zzpe(zzgpe.zzj(zzpd.zza));
    private static final zzgpe zzc = zzgpe.zzl(2, 5, 6);

    static {
        zzgpg zzgpgVar = new zzgpg();
        zzgpgVar.zza(5, 6);
        zzgpgVar.zza(17, 6);
        zzgpgVar.zza(7, 6);
        zzgpgVar.zza(30, 10);
        zzgpgVar.zza(18, 6);
        zzgpgVar.zza(6, 8);
        zzgpgVar.zza(8, 8);
        zzgpgVar.zza(14, 8);
        zzb = zzgpgVar.zzc();
    }

    private zzpe(List list) {
        for (int i = 0; i < list.size(); i++) {
            zzpd zzpdVar = (zzpd) list.get(i);
            this.zzd.put(zzpdVar.zzb, zzpdVar);
        }
        int iMax = 0;
        for (int i2 = 0; i2 < this.zzd.size(); i2++) {
            iMax = Math.max(iMax, ((zzpd) this.zzd.valueAt(i2)).zzc);
        }
        this.zze = iMax;
    }

    static zzpe zza(Context context, zzd zzdVar, AudioDeviceInfo audioDeviceInfo) {
        return zzb(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), zzdVar, audioDeviceInfo);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.google.android.gms.internal.ads.zzpe zzb(android.content.Context r9, android.content.Intent r10, com.google.android.gms.internal.ads.zzd r11, android.media.AudioDeviceInfo r12) {
        /*
            Method dump skipped, instruction units count: 608
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpe.zzb(android.content.Context, android.content.Intent, com.google.android.gms.internal.ads.zzd, android.media.AudioDeviceInfo):com.google.android.gms.internal.ads.zzpe");
    }

    static Uri zzc() {
        if (zze()) {
            return Settings.Global.getUriFor("external_surround_sound_enabled");
        }
        return null;
    }

    private static boolean zze() {
        return Build.MANUFACTURER.equals("Amazon") || Build.MANUFACTURER.equals("Xiaomi");
    }

    private static zzgpe zzf(int[] iArr, int i) {
        int i2 = zzgpe.zzd;
        zzgpb zzgpbVar = new zzgpb();
        for (int i3 : iArr) {
            zzgpbVar.zzf(new zzpd(i3, i));
        }
        return zzgpbVar.zzi();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0047 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r9) {
        /*
            r8 = this;
            r0 = 1
            if (r8 != r9) goto L4
            return r0
        L4:
            boolean r1 = r9 instanceof com.google.android.gms.internal.ads.zzpe
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            com.google.android.gms.internal.ads.zzpe r9 = (com.google.android.gms.internal.ads.zzpe) r9
            android.util.SparseArray r1 = r8.zzd
            android.util.SparseArray r3 = r9.zzd
            java.lang.String r4 = com.google.android.gms.internal.ads.zzep.zza
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 31
            if (r4 < r5) goto L1f
            boolean r1 = r1.contentEquals(r3)
            if (r1 == 0) goto L48
            goto L41
        L1f:
            int r4 = r1.size()
            int r5 = r3.size()
            if (r4 != r5) goto L48
            r5 = r2
        L2a:
            if (r5 >= r4) goto L41
            int r6 = r1.keyAt(r5)
            java.lang.Object r7 = r1.valueAt(r5)
            java.lang.Object r6 = r3.get(r6)
            boolean r6 = java.util.Objects.equals(r7, r6)
            if (r6 == 0) goto L48
            int r5 = r5 + 1
            goto L2a
        L41:
            int r1 = r8.zze
            int r9 = r9.zze
            if (r1 != r9) goto L48
            return r0
        L48:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpe.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int iContentHashCode;
        String str = zzep.zza;
        int i = Build.VERSION.SDK_INT;
        SparseArray sparseArray = this.zzd;
        if (i >= 31) {
            iContentHashCode = sparseArray.contentHashCode();
        } else {
            int iKeyAt = 17;
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                iKeyAt = (((iKeyAt * 31) + sparseArray.keyAt(i2)) * 31) + Objects.hashCode(sparseArray.valueAt(i2));
            }
            iContentHashCode = iKeyAt;
        }
        return this.zze + (iContentHashCode * 31);
    }

    public final String toString() {
        String string = this.zzd.toString();
        int i = this.zze;
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 50 + string.length() + 1);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i);
        sb.append(", audioProfiles=");
        sb.append(string);
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d A[PHI: r1
  0x003d: PHI (r1v5 int) = (r1v4 int), (r1v9 int) binds: [B:11:0x002f, B:14:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.Pair zzd(com.google.android.gms.internal.ads.zzv r10, com.google.android.gms.internal.ads.zzd r11) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpe.zzd(com.google.android.gms.internal.ads.zzv, com.google.android.gms.internal.ads.zzd):android.util.Pair");
    }
}
