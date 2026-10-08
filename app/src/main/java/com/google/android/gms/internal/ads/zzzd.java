package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzzd implements zzza, zzgz {
    public static final zzgpe zza = zzgpe.zzm(4300000L, 3200000L, 2400000L, 1700000L, 860000L);
    public static final zzgpe zzb = zzgpe.zzm(1500000L, 980000L, 750000L, 520000L, 290000L);
    public static final zzgpe zzc = zzgpe.zzm(2000000L, 1300000L, 1000000L, 860000L, 610000L);
    public static final zzgpe zzd = zzgpe.zzm(2500000L, 1700000L, 1200000L, 970000L, 680000L);
    public static final zzgpe zze = zzgpe.zzm(4700000L, 2800000L, 2100000L, 1700000L, 980000L);
    public static final zzgpe zzf = zzgpe.zzm(2700000L, 2000000L, 1600000L, 1300000L, 1000000L);
    private static zzzd zzg;
    private final Context zzh;
    private final zzgph zzi;
    private final zzyy zzj;
    private final zzzr zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    private long zzr;
    private int zzs;
    private String zzt;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0038 A[Catch: all -> 0x0077, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x0009, B:13:0x0015, B:15:0x0019, B:17:0x001f, B:19:0x0029, B:21:0x0033, B:23:0x0044, B:22:0x0038, B:24:0x0046, B:26:0x0054, B:28:0x005b), top: B:36:0x0001 }] */
    /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void zzi(int r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.zzs     // Catch: java.lang.Throwable -> L77
            if (r0 != r9) goto L9
            java.lang.String r0 = r8.zzt     // Catch: java.lang.Throwable -> L77
            if (r0 != 0) goto L75
        L9:
            r8.zzs = r9     // Catch: java.lang.Throwable -> L77
            r0 = 1
            if (r9 == r0) goto L75
            if (r9 == 0) goto L75
            r0 = 8
            if (r9 != r0) goto L15
            goto L75
        L15:
            java.lang.String r0 = r8.zzt     // Catch: java.lang.Throwable -> L77
            if (r0 != 0) goto L46
            android.content.Context r0 = r8.zzh     // Catch: java.lang.Throwable -> L77
            java.lang.String r1 = com.google.android.gms.internal.ads.zzep.zza     // Catch: java.lang.Throwable -> L77
            if (r0 == 0) goto L38
            java.lang.String r1 = "phone"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Throwable -> L77
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch: java.lang.Throwable -> L77
            if (r0 == 0) goto L38
            java.lang.String r0 = r0.getNetworkCountryIso()     // Catch: java.lang.Throwable -> L77
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L77
            if (r1 != 0) goto L38
            java.lang.String r0 = com.google.android.gms.internal.ads.zzglm.zzb(r0)     // Catch: java.lang.Throwable -> L77
            goto L44
        L38:
            java.util.Locale r0 = java.util.Locale.getDefault()     // Catch: java.lang.Throwable -> L77
            java.lang.String r0 = r0.getCountry()     // Catch: java.lang.Throwable -> L77
            java.lang.String r0 = com.google.android.gms.internal.ads.zzglm.zzb(r0)     // Catch: java.lang.Throwable -> L77
        L44:
            r8.zzt = r0     // Catch: java.lang.Throwable -> L77
        L46:
            long r0 = r8.zzl(r9)     // Catch: java.lang.Throwable -> L77
            r8.zzq = r0     // Catch: java.lang.Throwable -> L77
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L77
            int r9 = r8.zzl     // Catch: java.lang.Throwable -> L77
            if (r9 <= 0) goto L5a
            long r2 = r8.zzm     // Catch: java.lang.Throwable -> L77
            long r2 = r0 - r2
            int r9 = (int) r2     // Catch: java.lang.Throwable -> L77
            goto L5b
        L5a:
            r9 = 0
        L5b:
            r3 = r9
            long r4 = r8.zzn     // Catch: java.lang.Throwable -> L77
            long r6 = r8.zzq     // Catch: java.lang.Throwable -> L77
            r2 = r8
            r2.zzk(r3, r4, r6)     // Catch: java.lang.Throwable -> L77
            r8.zzm = r0     // Catch: java.lang.Throwable -> L77
            r0 = 0
            r8.zzn = r0     // Catch: java.lang.Throwable -> L77
            r8.zzp = r0     // Catch: java.lang.Throwable -> L77
            r8.zzo = r0     // Catch: java.lang.Throwable -> L77
            com.google.android.gms.internal.ads.zzzr r9 = r8.zzk     // Catch: java.lang.Throwable -> L77
            r9.zza()     // Catch: java.lang.Throwable -> L77
            monitor-exit(r8)
            return
        L75:
            monitor-exit(r8)
            return
        L77:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzd.zzi(int):void");
    }

    private final void zzk(int i, long j, long j2) {
        int i2;
        long j3;
        if (i == 0) {
            if (j != 0) {
                j3 = j;
            } else if (j2 == this.zzr) {
                return;
            } else {
                j3 = 0;
            }
            i2 = 0;
        } else {
            i2 = i;
            j3 = j;
        }
        this.zzr = j2;
        this.zzj.zzc(i2, j3, j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final long zzl(int r10) {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.zzgph r0 = r9.zzi
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)
            java.lang.Object r1 = r0.get(r1)
            java.lang.Long r1 = (java.lang.Long) r1
            r2 = 1000000(0xf4240, double:4.940656E-318)
            r4 = 0
            if (r1 != 0) goto L1f
            java.lang.Integer r10 = java.lang.Integer.valueOf(r4)
            java.lang.Object r10 = r0.get(r10)
            r1 = r10
            java.lang.Long r1 = (java.lang.Long) r1
            goto Lad
        L1f:
            long r5 = r1.longValue()
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 != 0) goto Lad
            java.lang.String r0 = r9.zzt
            java.lang.String r0 = com.google.android.gms.internal.ads.zzgmu.zza(r0)
            int[] r0 = zzn(r0)
            r1 = 2
            if (r10 == r1) goto L9b
            r5 = 3
            if (r10 == r5) goto L8b
            r6 = 4
            if (r10 == r6) goto L7c
            r1 = 5
            if (r10 == r1) goto L6d
            r5 = 7
            if (r10 == r5) goto L9b
            r4 = 9
            if (r10 == r4) goto L5e
            r1 = 10
            if (r10 == r1) goto L4f
            r0 = r2
            goto La9
        L4f:
            com.google.android.gms.internal.ads.zzgpe r10 = com.google.android.gms.internal.ads.zzzd.zze
            r0 = r0[r6]
            java.lang.Object r10 = r10.get(r0)
            java.lang.Long r10 = (java.lang.Long) r10
            long r0 = r10.longValue()
            goto La9
        L5e:
            com.google.android.gms.internal.ads.zzgpe r10 = com.google.android.gms.internal.ads.zzzd.zzf
            r0 = r0[r1]
            java.lang.Object r10 = r10.get(r0)
            java.lang.Long r10 = (java.lang.Long) r10
            long r0 = r10.longValue()
            goto La9
        L6d:
            com.google.android.gms.internal.ads.zzgpe r10 = com.google.android.gms.internal.ads.zzzd.zzd
            r0 = r0[r5]
            java.lang.Object r10 = r10.get(r0)
            java.lang.Long r10 = (java.lang.Long) r10
            long r0 = r10.longValue()
            goto La9
        L7c:
            com.google.android.gms.internal.ads.zzgpe r10 = com.google.android.gms.internal.ads.zzzd.zzc
            r0 = r0[r1]
            java.lang.Object r10 = r10.get(r0)
            java.lang.Long r10 = (java.lang.Long) r10
            long r0 = r10.longValue()
            goto La9
        L8b:
            com.google.android.gms.internal.ads.zzgpe r10 = com.google.android.gms.internal.ads.zzzd.zzb
            r1 = 1
            r0 = r0[r1]
            java.lang.Object r10 = r10.get(r0)
            java.lang.Long r10 = (java.lang.Long) r10
            long r0 = r10.longValue()
            goto La9
        L9b:
            com.google.android.gms.internal.ads.zzgpe r10 = com.google.android.gms.internal.ads.zzzd.zza
            r0 = r0[r4]
            java.lang.Object r10 = r10.get(r0)
            java.lang.Long r10 = (java.lang.Long) r10
            long r0 = r10.longValue()
        La9:
            java.lang.Long r1 = java.lang.Long.valueOf(r0)
        Lad:
            if (r1 != 0) goto Lb3
            java.lang.Long r1 = java.lang.Long.valueOf(r2)
        Lb3:
            long r0 = r1.longValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzd.zzl(int):long");
    }

    private static boolean zzm(zzgf zzgfVar, boolean z) {
        return z && !zzgfVar.zza(8);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0145, code lost:
    
        if (r3.equals("YE") != false) goto L827;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x015d, code lost:
    
        if (r3.equals("WS") != false) goto L398;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0167, code lost:
    
        if (r3.equals("WF") != false) goto L457;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0171, code lost:
    
        if (r3.equals("VU") != false) goto L540;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x01a5, code lost:
    
        if (r3.equals("VE") != false) goto L827;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x01af, code lost:
    
        if (r3.equals("VC") != false) goto L885;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01b9, code lost:
    
        if (r3.equals("VA") != false) goto L893;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x01fb, code lost:
    
        if (r3.equals("UA") != false) goto L815;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0221, code lost:
    
        if (r3.equals("TV") != false) goto L457;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0239, code lost:
    
        if (r3.equals("TR") != false) goto L889;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x025f, code lost:
    
        if (r3.equals("TM") != false) goto L457;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0269, code lost:
    
        if (r3.equals("TL") != false) goto L784;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0273, code lost:
    
        if (r3.equals("TJ") != false) goto L744;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x027d, code lost:
    
        if (r3.equals("TH") != false) goto L804;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0295, code lost:
    
        if (r3.equals("TD") != false) goto L839;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x02ad, code lost:
    
        if (r3.equals("SZ") != false) goto L866;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x02b7, code lost:
    
        if (r3.equals("SY") != false) goto L839;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x02c1, code lost:
    
        if (r3.equals("SX") != false) goto L885;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x02e7, code lost:
    
        if (r3.equals("SS") != false) goto L656;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x031b, code lost:
    
        if (r3.equals("SM") != false) goto L893;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0325, code lost:
    
        if (r3.equals("SL") != false) goto L851;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x033d, code lost:
    
        if (r3.equals("SJ") != false) goto L708;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x0347, code lost:
    
        if (r3.equals("SI") != false) goto L835;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0351, code lost:
    
        if (r3.equals("SH") != false) goto L728;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x0369, code lost:
    
        if (r3.equals("SE") != false) goto L736;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0373, code lost:
    
        if (r3.equals("SD") != false) goto L839;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x037d, code lost:
    
        if (r3.equals("SC") != false) goto L728;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:
    
        if (r3.equals("CI") != false) goto L862;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x0387, code lost:
    
        if (r3.equals("SB") != false) goto L272;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x038e, code lost:
    
        return new int[]{4, 2, 4, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x03f7, code lost:
    
        if (r3.equals("PY") != false) goto L435;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x040f, code lost:
    
        if (r3.equals("PT") != false) goto L835;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x0435, code lost:
    
        if (r3.equals("PM") != false) goto L893;
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x0469, code lost:
    
        if (r3.equals(com.google.android.gms.ads.RequestConfiguration.MAX_AD_CONTENT_RATING_PG) != false) goto L497;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0057, code lost:
    
        if (r3.equals("CG") != false) goto L732;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x048f, code lost:
    
        if (r3.equals("PA") != false) goto L901;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x04b5, code lost:
    
        if (r3.equals("NU") != false) goto L728;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x04bf, code lost:
    
        if (r3.equals("NR") != false) goto L784;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x04f3, code lost:
    
        if (r3.equals("NI") != false) goto L788;
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x050b, code lost:
    
        if (r3.equals("NF") != false) goto L708;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x0515, code lost:
    
        if (r3.equals("NE") != false) goto L827;
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x051f, code lost:
    
        if (r3.equals("NC") != false) goto L390;
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x0526, code lost:
    
        return new int[]{2, 3, 3, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x053b, code lost:
    
        if (r3.equals("MZ") != false) goto L398;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x0542, code lost:
    
        return new int[]{3, 1, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x058f, code lost:
    
        if (r3.equals("MT") != false) goto L736;
     */
    /* JADX WARN: Code restructure failed: missing block: B:424:0x0599, code lost:
    
        if (r3.equals("MS") != false) goto L893;
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x05a3, code lost:
    
        if (r3.equals("MR") != false) goto L800;
     */
    /* JADX WARN: Code restructure failed: missing block: B:434:0x05bb, code lost:
    
        if (r3.equals("MP") != false) goto L435;
     */
    /* JADX WARN: Code restructure failed: missing block: B:436:0x05c2, code lost:
    
        return new int[]{1, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:446:0x05e5, code lost:
    
        if (r3.equals("MM") != false) goto L504;
     */
    /* JADX WARN: Code restructure failed: missing block: B:449:0x05ef, code lost:
    
        if (r3.equals("ML") != false) goto L811;
     */
    /* JADX WARN: Code restructure failed: missing block: B:456:0x0607, code lost:
    
        if (r3.equals("MH") != false) goto L457;
     */
    /* JADX WARN: Code restructure failed: missing block: B:458:0x060e, code lost:
    
        return new int[]{4, 2, 2, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:460:0x0615, code lost:
    
        if (r3.equals("MG") != false) goto L732;
     */
    /* JADX WARN: Code restructure failed: missing block: B:475:0x0649, code lost:
    
        if (r3.equals("MC") != false) goto L660;
     */
    /* JADX WARN: Code restructure failed: missing block: B:482:0x0661, code lost:
    
        if (r3.equals("LY") != false) goto L851;
     */
    /* JADX WARN: Code restructure failed: missing block: B:485:0x066b, code lost:
    
        if (r3.equals("LV") != false) goto L736;
     */
    /* JADX WARN: Code restructure failed: missing block: B:496:0x0691, code lost:
    
        if (r3.equals("LS") != false) goto L497;
     */
    /* JADX WARN: Code restructure failed: missing block: B:498:0x0698, code lost:
    
        return new int[]{4, 3, 3, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:500:0x069f, code lost:
    
        if (r3.equals("LR") != false) goto L748;
     */
    /* JADX WARN: Code restructure failed: missing block: B:503:0x06a9, code lost:
    
        if (r3.equals("LK") != false) goto L504;
     */
    /* JADX WARN: Code restructure failed: missing block: B:505:0x06b0, code lost:
    
        return new int[]{3, 2, 3, 3, 4, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:507:0x06b7, code lost:
    
        if (r3.equals("LI") != false) goto L893;
     */
    /* JADX WARN: Code restructure failed: missing block: B:526:0x06f9, code lost:
    
        if (r3.equals("KY") != false) goto L885;
     */
    /* JADX WARN: Code restructure failed: missing block: B:529:0x0703, code lost:
    
        if (r3.equals("KW") != false) goto L617;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0099, code lost:
    
        if (r3.equals("BQ") != false) goto L885;
     */
    /* JADX WARN: Code restructure failed: missing block: B:536:0x071b, code lost:
    
        if (r3.equals("KN") != false) goto L885;
     */
    /* JADX WARN: Code restructure failed: missing block: B:539:0x0725, code lost:
    
        if (r3.equals("KM") != false) goto L540;
     */
    /* JADX WARN: Code restructure failed: missing block: B:541:0x072c, code lost:
    
        return new int[]{4, 3, 3, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:543:0x0733, code lost:
    
        if (r3.equals("KI") != false) goto L784;
     */
    /* JADX WARN: Code restructure failed: missing block: B:562:0x0775, code lost:
    
        if (r3.equals("JO") != false) goto L889;
     */
    /* JADX WARN: Code restructure failed: missing block: B:569:0x078d, code lost:
    
        if (r3.equals("JE") != false) goto L664;
     */
    /* JADX WARN: Code restructure failed: missing block: B:576:0x07a5, code lost:
    
        if (r3.equals("IS") != false) goto L736;
     */
    /* JADX WARN: Code restructure failed: missing block: B:595:0x07e7, code lost:
    
        if (r3.equals("IM") != false) goto L664;
     */
    /* JADX WARN: Code restructure failed: missing block: B:610:0x081b, code lost:
    
        if (r3.equals("HU") != false) goto L736;
     */
    /* JADX WARN: Code restructure failed: missing block: B:613:0x0825, code lost:
    
        if (r3.equals("HT") != false) goto L827;
     */
    /* JADX WARN: Code restructure failed: missing block: B:616:0x082f, code lost:
    
        if (r3.equals("HR") != false) goto L617;
     */
    /* JADX WARN: Code restructure failed: missing block: B:618:0x0836, code lost:
    
        return new int[]{1, 0, 0, 0, 0, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:644:0x0891, code lost:
    
        if (r3.equals("GQ") != false) goto L827;
     */
    /* JADX WARN: Code restructure failed: missing block: B:655:0x08b7, code lost:
    
        if (r3.equals("GM") != false) goto L656;
     */
    /* JADX WARN: Code restructure failed: missing block: B:657:0x08be, code lost:
    
        return new int[]{4, 3, 2, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:659:0x08c5, code lost:
    
        if (r3.equals("GL") != false) goto L660;
     */
    /* JADX WARN: Code restructure failed: missing block: B:661:0x08cc, code lost:
    
        return new int[]{1, 2, 2, 0, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:663:0x08d3, code lost:
    
        if (r3.equals("GI") != false) goto L664;
     */
    /* JADX WARN: Code restructure failed: missing block: B:665:0x08da, code lost:
    
        return new int[]{0, 2, 0, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00cd, code lost:
    
        if (r3.equals("BL") != false) goto L435;
     */
    /* JADX WARN: Code restructure failed: missing block: B:707:0x096d, code lost:
    
        if (r3.equals("FK") != false) goto L708;
     */
    /* JADX WARN: Code restructure failed: missing block: B:709:0x0974, code lost:
    
        return new int[]{3, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:727:0x09b3, code lost:
    
        if (r3.equals("ER") != false) goto L728;
     */
    /* JADX WARN: Code restructure failed: missing block: B:729:0x09ba, code lost:
    
        return new int[]{4, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:731:0x09c1, code lost:
    
        if (r3.equals("EG") != false) goto L732;
     */
    /* JADX WARN: Code restructure failed: missing block: B:733:0x09c8, code lost:
    
        return new int[]{3, 4, 3, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:735:0x09cf, code lost:
    
        if (r3.equals("EE") != false) goto L736;
     */
    /* JADX WARN: Code restructure failed: missing block: B:737:0x09d6, code lost:
    
        return new int[]{0, 0, 0, 0, 0, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:743:0x09eb, code lost:
    
        if (r3.equals("DZ") != false) goto L744;
     */
    /* JADX WARN: Code restructure failed: missing block: B:745:0x09f2, code lost:
    
        return new int[]{3, 3, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:747:0x09f9, code lost:
    
        if (r3.equals("DO") != false) goto L748;
     */
    /* JADX WARN: Code restructure failed: missing block: B:749:0x0a00, code lost:
    
        return new int[]{3, 4, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00e5, code lost:
    
        if (r3.equals("AT") != false) goto L736;
     */
    /* JADX WARN: Code restructure failed: missing block: B:751:0x0a07, code lost:
    
        if (r3.equals("DM") != false) goto L885;
     */
    /* JADX WARN: Code restructure failed: missing block: B:758:0x0a1f, code lost:
    
        if (r3.equals("DJ") != false) goto L851;
     */
    /* JADX WARN: Code restructure failed: missing block: B:773:0x0a53, code lost:
    
        if (r3.equals("CX") != false) goto L893;
     */
    /* JADX WARN: Code restructure failed: missing block: B:776:0x0a5d, code lost:
    
        if (r3.equals("CW") != false) goto L885;
     */
    /* JADX WARN: Code restructure failed: missing block: B:783:0x0a75, code lost:
    
        if (r3.equals("CU") != false) goto L784;
     */
    /* JADX WARN: Code restructure failed: missing block: B:785:0x0a7c, code lost:
    
        return new int[]{4, 2, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:787:0x0a83, code lost:
    
        if (r3.equals("CR") != false) goto L788;
     */
    /* JADX WARN: Code restructure failed: missing block: B:789:0x0a8a, code lost:
    
        return new int[]{2, 4, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:799:0x0aad, code lost:
    
        if (r3.equals("CM") != false) goto L800;
     */
    /* JADX WARN: Code restructure failed: missing block: B:801:0x0ab4, code lost:
    
        return new int[]{4, 3, 3, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:803:0x0abb, code lost:
    
        if (r3.equals("CL") != false) goto L804;
     */
    /* JADX WARN: Code restructure failed: missing block: B:805:0x0ac2, code lost:
    
        return new int[]{0, 1, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:807:0x0ac9, code lost:
    
        if (r3.equals("CK") != false) goto L877;
     */
    /* JADX WARN: Code restructure failed: missing block: B:810:0x0ad3, code lost:
    
        if (r3.equals("CD") != false) goto L811;
     */
    /* JADX WARN: Code restructure failed: missing block: B:812:0x0ada, code lost:
    
        return new int[]{3, 3, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:814:0x0ae1, code lost:
    
        if (r3.equals("CA") != false) goto L815;
     */
    /* JADX WARN: Code restructure failed: missing block: B:816:0x0ae8, code lost:
    
        return new int[]{0, 2, 1, 2, 3, 3};
     */
    /* JADX WARN: Code restructure failed: missing block: B:826:0x0b0b, code lost:
    
        if (r3.equals("BI") != false) goto L827;
     */
    /* JADX WARN: Code restructure failed: missing block: B:828:0x0b12, code lost:
    
        return new int[]{4, 4, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:834:0x0b27, code lost:
    
        if (r3.equals("BG") != false) goto L835;
     */
    /* JADX WARN: Code restructure failed: missing block: B:836:0x0b2e, code lost:
    
        return new int[]{0, 0, 0, 0, 1, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:838:0x0b35, code lost:
    
        if (r3.equals("BF") != false) goto L839;
     */
    /* JADX WARN: Code restructure failed: missing block: B:840:0x0b3c, code lost:
    
        return new int[]{4, 3, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:850:0x0b5f, code lost:
    
        if (r3.equals("AZ") != false) goto L851;
     */
    /* JADX WARN: Code restructure failed: missing block: B:852:0x0b66, code lost:
    
        return new int[]{4, 2, 3, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:858:0x0b7b, code lost:
    
        if (r3.equals("AI") != false) goto L885;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x010b, code lost:
    
        if (r3.equals("AQ") != false) goto L728;
     */
    /* JADX WARN: Code restructure failed: missing block: B:861:0x0b84, code lost:
    
        if (r3.equals("AG") != false) goto L862;
     */
    /* JADX WARN: Code restructure failed: missing block: B:863:0x0b8b, code lost:
    
        return new int[]{2, 4, 3, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:865:0x0b92, code lost:
    
        if (r3.equals("AF") != false) goto L866;
     */
    /* JADX WARN: Code restructure failed: missing block: B:867:0x0b99, code lost:
    
        return new int[]{4, 4, 3, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:873:0x0bae, code lost:
    
        if (r3.equals("AD") != false) goto L885;
     */
    /* JADX WARN: Code restructure failed: missing block: B:876:0x0bb7, code lost:
    
        if (r3.equals("BZ") != false) goto L877;
     */
    /* JADX WARN: Code restructure failed: missing block: B:878:0x0bbe, code lost:
    
        return new int[]{2, 2, 2, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:884:0x0bd3, code lost:
    
        if (r3.equals("BB") != false) goto L885;
     */
    /* JADX WARN: Code restructure failed: missing block: B:886:0x0bda, code lost:
    
        return new int[]{1, 2, 0, 0, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:888:0x0be1, code lost:
    
        if (r3.equals("BA") != false) goto L889;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0115, code lost:
    
        if (r3.equals("ZW") != false) goto L272;
     */
    /* JADX WARN: Code restructure failed: missing block: B:890:0x0be8, code lost:
    
        return new int[]{1, 1, 1, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:892:0x0bef, code lost:
    
        if (r3.equals("AX") != false) goto L893;
     */
    /* JADX WARN: Code restructure failed: missing block: B:894:0x0bf6, code lost:
    
        return new int[]{0, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:900:0x0c0b, code lost:
    
        if (r3.equals("AM") != false) goto L901;
     */
    /* JADX WARN: Code restructure failed: missing block: B:902:0x0c12, code lost:
    
        return new int[]{2, 3, 2, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x013b, code lost:
    
        if (r3.equals("YT") != false) goto L390;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int[] zzn(java.lang.String r3) {
        /*
            Method dump skipped, instruction units count: 6672
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzd.zzn(java.lang.String):int[]");
    }

    @Override // com.google.android.gms.internal.ads.zzgz
    public final void zza(zzgb zzgbVar, zzgf zzgfVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzgz
    public final synchronized void zzb(zzgb zzgbVar, zzgf zzgfVar, boolean z) {
        if (zzm(zzgfVar, z)) {
            if (this.zzl == 0) {
                this.zzm = SystemClock.elapsedRealtime();
            }
            this.zzl++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgz
    public final synchronized void zzc(zzgb zzgbVar, zzgf zzgfVar, boolean z, int i) {
        if (zzm(zzgfVar, z)) {
            this.zzn += (long) i;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgz
    public final synchronized void zzd(zzgb zzgbVar, zzgf zzgfVar, boolean z) {
        if (zzm(zzgfVar, z)) {
            zzgmd.zzh(this.zzl > 0);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            int i = (int) (jElapsedRealtime - this.zzm);
            this.zzo += (long) i;
            long j = this.zzp;
            long j2 = this.zzn;
            this.zzp = j + j2;
            if (i > 0) {
                zzzr zzzrVar = this.zzk;
                zzzrVar.zzb((int) Math.sqrt(j2), (j2 * 8000.0f) / i);
                if (this.zzo >= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS || this.zzp >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                    this.zzq = (long) zzzrVar.zzc(0.5f);
                }
                zzk(i, this.zzn, this.zzq);
                this.zzm = jElapsedRealtime;
                this.zzn = 0L;
            }
            this.zzl--;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzza
    public final zzgz zze() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzza
    public final void zzg(zzyz zzyzVar) {
        this.zzj.zzb(zzyzVar);
    }

    /* synthetic */ zzzd(Context context, Map map, int i, zzdc zzdcVar, boolean z, byte[] bArr) {
        this.zzh = context == null ? null : context.getApplicationContext();
        this.zzi = zzgph.zzc(map);
        this.zzj = new zzyy();
        this.zzk = new zzzr(2000);
        if (context == null) {
            this.zzs = 0;
            this.zzq = 1000000L;
            return;
        }
        zzee zzeeVarZza = zzee.zza(context);
        int iZzc = zzeeVarZza.zzc();
        this.zzs = iZzc;
        this.zzq = zzl(iZzc);
        zzeeVarZza.zzb(new zzdy() { // from class: com.google.android.gms.internal.ads.zzzc
            @Override // com.google.android.gms.internal.ads.zzdy
            public final /* synthetic */ void zza(int i2) {
                this.zza.zzi(i2);
            }
        }, zzcw.zza());
    }

    public static synchronized zzzd zzh(Context context) {
        if (zzg == null) {
            Context applicationContext = context == null ? null : context.getApplicationContext();
            zzdc zzdcVar = zzdc.zza;
            HashMap map = new HashMap(8);
            map.put(0, 1000000L);
            Long lValueOf = Long.valueOf(C.TIME_UNSET);
            map.put(2, lValueOf);
            map.put(3, lValueOf);
            map.put(4, lValueOf);
            map.put(5, lValueOf);
            map.put(10, lValueOf);
            map.put(9, lValueOf);
            map.put(7, lValueOf);
            zzg = new zzzd(applicationContext, map, 2000, zzdcVar, true, null);
        }
        return zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzza
    public final void zzf(Handler handler, zzyz zzyzVar) {
        zzyzVar.getClass();
        this.zzj.zza(handler, zzyzVar);
    }
}
