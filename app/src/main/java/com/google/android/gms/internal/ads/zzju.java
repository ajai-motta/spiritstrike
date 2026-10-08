package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzju extends zzf implements zzim {
    public static final /* synthetic */ int zzd = 0;
    private final long zzA;
    private final zzdb zzB;
    private final zzme zzC;
    private int zzD;
    private int zzE;
    private boolean zzF;
    private zzlu zzG;
    private zzlv zzH;
    private zzil zzI;
    private zzax zzJ;
    private zzan zzK;
    private Object zzL;
    private Surface zzM;
    private int zzN;
    private zzeh zzO;
    private zzd zzP;
    private float zzQ;
    private boolean zzR;
    private boolean zzS;
    private boolean zzT;
    private int zzU;
    private zzan zzV;
    private zzlf zzW;
    private int zzX;
    private long zzY;
    private zzwn zzZ;
    final zzys zzb;
    final zzax zzc;
    private final zzdf zze = new zzdf(zzdc.zza);
    private final Context zzf;
    private final zzbb zzg;
    private final zzln[] zzh;
    private final zzln[] zzi;
    private final zzyr zzj;
    private final zzdm zzk;
    private final zzkf zzl;
    private final zzkh zzm;
    private final zzds zzn;
    private final CopyOnWriteArraySet zzo;
    private final zzbd zzp;
    private final List zzq;
    private final boolean zzr;
    private final zzmi zzs;
    private final Looper zzt;
    private final zzza zzu;
    private final zzdc zzv;
    private final zzit zzw;
    private final zzjs zzx;
    private final zzmg zzy;
    private final zzmh zzz;

    static {
        zzal.zzb("media3.exoplayer");
    }

    public zzju(zzik zzikVar, zzbb zzbbVar) {
        zzik zzikVar2;
        zzdc zzdcVar;
        try {
            String hexString = Integer.toHexString(System.identityHashCode(this));
            String str = zzep.zza;
            StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 30 + String.valueOf(str).length() + 1);
            sb.append("Init ");
            sb.append(hexString);
            sb.append(" [AndroidXMedia3/1.8.0] [");
            sb.append(str);
            sb.append("]");
            zzdt.zzb("ExoPlayerImpl", sb.toString());
            this.zzf = zzikVar.zza.getApplicationContext();
            this.zzs = (zzmi) zzikVar.zzh.apply(zzikVar.zzb);
            this.zzU = zzikVar.zzj;
            this.zzP = zzikVar.zzk;
            this.zzN = zzikVar.zzl;
            this.zzR = false;
            this.zzA = zzikVar.zzq;
            zzit zzitVar = new zzit(this, null);
            this.zzw = zzitVar;
            this.zzx = new zzjs(null);
            zzln[] zzlnVarArrZza = ((zzls) zzikVar.zzc.zza()).zza(new Handler(zzikVar.zzi), zzitVar, zzitVar, zzitVar, zzitVar);
            this.zzh = zzlnVarArrZza;
            int length = zzlnVarArrZza.length;
            this.zzi = new zzln[2];
            int i = 0;
            while (true) {
                zzln[] zzlnVarArr = this.zzi;
                int length2 = zzlnVarArr.length;
                if (i >= 2) {
                    break;
                }
                zzln zzlnVar = this.zzh[i];
                zzlnVarArr[i] = null;
                i++;
            }
            zzyr zzyrVar = (zzyr) zzikVar.zze.zza();
            this.zzj = zzyrVar;
            zzza zzzaVar = (zzza) zzikVar.zzg.zza();
            this.zzu = zzzaVar;
            this.zzr = zzikVar.zzm;
            this.zzH = zzikVar.zzn;
            this.zzG = zzikVar.zzo;
            Looper looper = zzikVar.zzi;
            this.zzt = looper;
            zzdc zzdcVar2 = zzikVar.zzb;
            this.zzv = zzdcVar2;
            this.zzg = zzbbVar;
            this.zzn = new zzds(looper, zzdcVar2, new zzdo() { // from class: com.google.android.gms.internal.ads.zzjr
                @Override // com.google.android.gms.internal.ads.zzdo
                public final /* synthetic */ void zza(Object obj, zzs zzsVar) {
                    this.zza.zzJ((zzaz) obj, zzsVar);
                }
            });
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.zzo = copyOnWriteArraySet;
            this.zzq = new ArrayList();
            this.zzZ = new zzwn(0);
            this.zzI = zzil.zza;
            int length3 = this.zzh.length;
            zzys zzysVar = new zzys(new zzlq[2], new zzyk[2], zzbn.zza, null);
            this.zzb = zzysVar;
            this.zzp = new zzbd();
            zzaw zzawVar = new zzaw();
            zzawVar.zzc(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32);
            zzyrVar.zzd();
            zzawVar.zzb(29, true);
            zzawVar.zzb(23, false);
            zzawVar.zzb(25, false);
            zzawVar.zzb(33, false);
            zzawVar.zzb(26, false);
            zzawVar.zzb(34, false);
            zzax zzaxVarZze = zzawVar.zze();
            this.zzc = zzaxVarZze;
            zzaw zzawVar2 = new zzaw();
            zzawVar2.zzd(zzaxVarZze);
            zzawVar2.zza(4);
            zzawVar2.zza(10);
            this.zzJ = zzawVar2.zze();
            this.zzk = zzdcVar2.zzd(looper, null);
            zzkf zzkfVar = new zzkf() { // from class: com.google.android.gms.internal.ads.zziu
                @Override // com.google.android.gms.internal.ads.zzkf
                public final /* synthetic */ void zza(zzke zzkeVar) {
                    this.zza.zzK(zzkeVar);
                }
            };
            this.zzl = zzkfVar;
            this.zzW = zzlf.zza(zzysVar);
            this.zzs.zzx(zzbbVar, looper);
            final zzpc zzpcVar = new zzpc(zzikVar.zzx);
            zzkh zzkhVar = new zzkh(this.zzf, this.zzh, this.zzi, zzyrVar, zzysVar, (zzkl) zzikVar.zzf.zza(), zzzaVar, 0, false, this.zzs, this.zzH, zzikVar.zzy, zzikVar.zzp, false, false, looper, zzdcVar2, zzkfVar, zzpcVar, null, this.zzI, this.zzx);
            this.zzm = zzkhVar;
            Looper looperZzn = zzkhVar.zzn();
            this.zzQ = 1.0f;
            zzan zzanVar = zzan.zza;
            this.zzK = zzanVar;
            this.zzV = zzanVar;
            this.zzX = -1;
            int i2 = zzco.zza;
            this.zzS = true;
            zze(this.zzs);
            zzzaVar.zzf(new Handler(looper), this.zzs);
            copyOnWriteArraySet.add(this.zzw);
            if (Build.VERSION.SDK_INT >= 31) {
                final Context context = this.zzf;
                zzikVar2 = zzikVar;
                final boolean z = zzikVar2.zzv;
                zzdcVar = zzdcVar2;
                zzdcVar.zzd(zzkhVar.zzn(), null).zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzin
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzoy zzoyVarZza = zzoy.zza(context);
                        if (zzoyVarZza == null) {
                            zzdt.zzc("ExoPlayerImpl", "MediaMetricsService unavailable.");
                            return;
                        }
                        if (z) {
                            this.zzD(zzoyVarZza);
                        }
                        zzpcVar.zzb(zzoyVarZza.zzb());
                    }
                });
            } else {
                zzikVar2 = zzikVar;
                zzdcVar = zzdcVar2;
            }
            zzdb zzdbVar = new zzdb(0, looperZzn, looper, zzdcVar, new zzda() { // from class: com.google.android.gms.internal.ads.zzjf
                @Override // com.google.android.gms.internal.ads.zzda
                public final /* synthetic */ void zza(Object obj, Object obj2) {
                    int iIntValue = ((Integer) obj2).intValue();
                    this.zza.zzL(((Integer) obj).intValue(), iIntValue);
                }
            });
            this.zzB = zzdbVar;
            zzdbVar.zzc(new Runnable() { // from class: com.google.android.gms.internal.ads.zzjk
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzM();
                }
            });
            new zzhm(zzikVar2.zza, looperZzn, zzikVar2.zzi, this.zzw, zzdcVar);
            this.zzy = new zzmg(zzikVar2.zza, looperZzn, zzdcVar);
            this.zzz = new zzmh(zzikVar2.zza, looperZzn, zzdcVar);
            int i3 = zzm.zza;
            zzbv zzbvVar = zzbv.zza;
            this.zzO = zzeh.zza;
            this.zzC = new zzme(this, this.zzw, zzdcVar, zzikVar2.zzr, zzikVar2.zzs, zzikVar2.zzt, zzikVar2.zzu);
            zzkhVar.zzg(this.zzG);
            zzkhVar.zzi(this.zzP, false);
            zzao(1, 3, this.zzP);
            zzao(2, 4, Integer.valueOf(this.zzN));
            zzao(2, 5, 0);
            zzao(1, 9, Boolean.valueOf(this.zzR));
            zzao(6, 8, this.zzx);
            zzao(-1, 16, Integer.valueOf(this.zzU));
        } finally {
            this.zze.zza();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzZ, reason: merged with bridge method [inline-methods] */
    public final void zzP(zzib zzibVar) {
        zzlf zzlfVar = this.zzW;
        zzlf zzlfVarZzh = zzlfVar.zzh(zzlfVar.zzb);
        zzlfVarZzh.zzq = zzlfVarZzh.zzs;
        zzlfVarZzh.zzr = 0L;
        zzlf zzlfVarZzag = zzag(zzlfVarZzh, 1);
        if (zzibVar != null) {
            zzlfVarZzag = zzlfVarZzag.zzf(zzibVar);
        }
        this.zzD++;
        this.zzm.zzh();
        zzad(zzlfVarZzag, 0, false, 5, C.TIME_UNSET, -1, false);
    }

    private final int zzaa(zzlf zzlfVar) {
        zzbf zzbfVar = zzlfVar.zza;
        return zzbfVar.zzg() ? this.zzX : zzbfVar.zzo(zzlfVar.zzb.zza, this.zzp).zzc;
    }

    private final long zzab(zzlf zzlfVar) {
        zzuu zzuuVar = zzlfVar.zzb;
        if (!zzuuVar.zzb()) {
            return zzep.zzp(zzac(zzlfVar));
        }
        zzbf zzbfVar = zzlfVar.zza;
        zzbfVar.zzo(zzuuVar.zza, this.zzp);
        long j = zzlfVar.zzc;
        if (j != C.TIME_UNSET) {
            return zzep.zzp(0L) + zzep.zzp(j);
        }
        long j2 = zzbfVar.zzb(zzaa(zzlfVar), this.zza, 0L).zzl;
        return zzep.zzp(0L);
    }

    private final long zzac(zzlf zzlfVar) {
        zzbf zzbfVar = zzlfVar.zza;
        if (zzbfVar.zzg()) {
            return zzep.zzq(this.zzY);
        }
        boolean z = zzlfVar.zzp;
        long j = zzlfVar.zzs;
        zzuu zzuuVar = zzlfVar.zzb;
        if (zzuuVar.zzb()) {
            return j;
        }
        zzai(zzbfVar, zzuuVar, j);
        return j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x046e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0478 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x047c  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0483 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0493 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x049f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x04b6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x04c2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0288  */
    /* JADX WARN: Type inference failed for: r4v16, types: [com.google.android.gms.internal.ads.zzbf] */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzad(final com.google.android.gms.internal.ads.zzlf r44, final int r45, boolean r46, int r47, long r48, int r50, boolean r51) {
        /*
            Method dump skipped, instruction units count: 1268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzju.zzad(com.google.android.gms.internal.ads.zzlf, int, boolean, int, long, int, boolean):void");
    }

    private static long zzae(zzlf zzlfVar) {
        zzbe zzbeVar = new zzbe();
        zzbd zzbdVar = new zzbd();
        zzbf zzbfVar = zzlfVar.zza;
        zzbfVar.zzo(zzlfVar.zzb.zza, zzbdVar);
        long j = zzlfVar.zzc;
        if (j != C.TIME_UNSET) {
            return j;
        }
        long j2 = zzbfVar.zzb(zzbdVar.zzc, zzbeVar, 0L).zzl;
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.android.gms.internal.ads.zzlf zzaf(com.google.android.gms.internal.ads.zzlf r23, com.google.android.gms.internal.ads.zzbf r24, android.util.Pair r25) {
        /*
            Method dump skipped, instruction units count: 365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzju.zzaf(com.google.android.gms.internal.ads.zzlf, com.google.android.gms.internal.ads.zzbf, android.util.Pair):com.google.android.gms.internal.ads.zzlf");
    }

    private static zzlf zzag(zzlf zzlfVar, int i) {
        zzlf zzlfVarZze = zzlfVar.zze(i);
        return (i == 1 || i == 4) ? zzlfVarZze.zzg(false) : zzlfVarZze;
    }

    private final Pair zzah(zzbf zzbfVar, int i, long j) {
        if (zzbfVar.zzg()) {
            this.zzX = i;
            if (j == C.TIME_UNSET) {
                j = 0;
            }
            this.zzY = j;
            return null;
        }
        if (i == -1 || i >= zzbfVar.zza()) {
            i = zzbfVar.zzk(false);
            long j2 = zzbfVar.zzb(i, this.zza, 0L).zzl;
            j = zzep.zzp(0L);
        }
        return zzbfVar.zzm(this.zza, this.zzp, i, zzep.zzq(j));
    }

    private final long zzai(zzbf zzbfVar, zzuu zzuuVar, long j) {
        zzbfVar.zzo(zzuuVar.zza, this.zzp);
        return j;
    }

    private final zzlj zzaj(zzli zzliVar) {
        int iZzaa = zzaa(this.zzW);
        zzbf zzbfVar = this.zzW.zza;
        if (iZzaa == -1) {
            iZzaa = 0;
        }
        zzdc zzdcVar = this.zzv;
        zzkh zzkhVar = this.zzm;
        return new zzlj(zzkhVar, zzliVar, zzbfVar, iZzaa, zzdcVar, zzkhVar.zzn());
    }

    private final void zzak(Object obj) {
        Object obj2 = this.zzL;
        boolean z = false;
        if (obj2 != null && obj2 != obj) {
            z = true;
        }
        boolean zZzl = this.zzm.zzl(obj, z ? this.zzA : C.TIME_UNSET);
        if (z) {
            Object obj3 = this.zzL;
            Surface surface = this.zzM;
            if (obj3 == surface) {
                surface.release();
                this.zzM = null;
            }
        }
        this.zzL = obj;
        if (zZzl) {
            return;
        }
        zzP(zzib.zzc(new zzki(3), 1003));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzal, reason: merged with bridge method [inline-methods] */
    public final void zzS(final int i, final int i2) {
        if (i == this.zzO.zza() && i2 == this.zzO.zzb()) {
            return;
        }
        this.zzO = new zzeh(i, i2);
        zzds zzdsVar = this.zzn;
        zzdsVar.zzd(24, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjh
            @Override // com.google.android.gms.internal.ads.zzdn
            public final /* synthetic */ void zza(Object obj) {
                int i3 = zzju.zzd;
                ((zzaz) obj).zzu(i, i2);
            }
        });
        zzdsVar.zze();
        zzao(2, 14, new zzeh(i, i2));
    }

    private final void zzam() {
        int iZzh = zzh();
        if (iZzh != 2 && iZzh != 3) {
            this.zzy.zza(false);
            this.zzz.zza(false);
        } else {
            zzan();
            boolean z = this.zzW.zzp;
            this.zzy.zza(zzk());
            this.zzz.zza(zzk());
        }
    }

    private final void zzan() {
        this.zze.zzd();
        Looper looper = this.zzt;
        if (Thread.currentThread() != looper.getThread()) {
            Object[] objArr = {Thread.currentThread().getName(), looper.getThread().getName()};
            String str = zzep.zza;
            String str2 = String.format(Locale.US, "Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", objArr);
            if (this.zzS) {
                throw new IllegalStateException(str2);
            }
            zzdt.zzd("ExoPlayerImpl", str2, this.zzT ? null : new IllegalStateException());
            this.zzT = true;
        }
    }

    private final void zzao(int i, int i2, Object obj) {
        zzln[] zzlnVarArr = this.zzh;
        int length = zzlnVarArr.length;
        for (int i3 = 0; i3 < 2; i3++) {
            zzln zzlnVar = zzlnVarArr[i3];
            if (i == -1 || zzlnVar.zza() == i) {
                zzlj zzljVarZzaj = zzaj(zzlnVar);
                zzljVarZzaj.zzb(i2);
                zzljVarZzaj.zzd(obj);
                zzljVarZzaj.zzg();
            }
        }
        zzln[] zzlnVarArr2 = this.zzi;
        int length2 = zzlnVarArr2.length;
        for (int i4 = 0; i4 < 2; i4++) {
            zzln zzlnVar2 = zzlnVarArr2[i4];
            if (zzlnVar2 != null && (i == -1 || zzlnVar2.zza() == i)) {
                zzlj zzljVarZzaj2 = zzaj(zzlnVar2);
                zzljVarZzaj2.zzb(i2);
                zzljVarZzaj2.zzd(obj);
                zzljVarZzaj2.zzg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzA() {
        zzan();
        return zzab(this.zzW);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzB(float f) {
        zzan();
        String str = zzep.zza;
        final float fMax = Math.max(0.0f, Math.min(f, 1.0f));
        if (this.zzQ == fMax) {
            return;
        }
        this.zzQ = fMax;
        this.zzm.zzj(fMax);
        zzds zzdsVar = this.zzn;
        zzdsVar.zzd(22, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjm
            @Override // com.google.android.gms.internal.ads.zzdn
            public final /* synthetic */ void zza(Object obj) {
                int i = zzju.zzd;
                ((zzaz) obj).zzr(fMax);
            }
        });
        zzdsVar.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzC(Surface surface) {
        zzan();
        zzak(surface);
        int i = surface == null ? 0 : -1;
        zzS(i, i);
    }

    @Override // com.google.android.gms.internal.ads.zzim
    public final void zzD(zzml zzmlVar) {
        this.zzs.zzv(zzmlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzim
    public final void zzE(zzml zzmlVar) {
        zzan();
        this.zzs.zzw(zzmlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzim
    public final int zzF() {
        zzan();
        int length = this.zzh.length;
        return 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ae  */
    @Override // com.google.android.gms.internal.ads.zzim
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzG(com.google.android.gms.internal.ads.zzuw r17) {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzju.zzG(com.google.android.gms.internal.ads.zzuw):void");
    }

    @Override // com.google.android.gms.internal.ads.zzim
    public final void zzH() {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = zzep.zza;
        String strZza = zzal.zza();
        int length = String.valueOf(hexString).length();
        StringBuilder sb = new StringBuilder(length + 33 + String.valueOf(str).length() + 3 + String.valueOf(strZza).length() + 1);
        sb.append("Release ");
        sb.append(hexString);
        sb.append(" [AndroidXMedia3/1.8.0] [");
        sb.append(str);
        sb.append("] [");
        sb.append(strZza);
        sb.append("]");
        zzdt.zzb("ExoPlayerImpl", sb.toString());
        zzan();
        this.zzy.zza(false);
        this.zzz.zza(false);
        this.zzC.zzv();
        if (!this.zzm.zzm()) {
            zzds zzdsVar = this.zzn;
            zzdsVar.zzd(10, zzjl.zza);
            zzdsVar.zze();
        }
        this.zzn.zzf();
        this.zzk.zzl(null);
        zzza zzzaVar = this.zzu;
        zzmi zzmiVar = this.zzs;
        zzzaVar.zzg(zzmiVar);
        boolean z = this.zzW.zzp;
        zzlf zzlfVarZzag = zzag(this.zzW, 1);
        this.zzW = zzlfVarZzag;
        zzlf zzlfVarZzh = zzlfVarZzag.zzh(zzlfVarZzag.zzb);
        this.zzW = zzlfVarZzh;
        zzlfVarZzh.zzq = zzlfVarZzh.zzs;
        this.zzW.zzr = 0L;
        zzmiVar.zzy();
        Surface surface = this.zzM;
        if (surface != null) {
            surface.release();
            this.zzM = null;
        }
        int i = zzco.zza;
    }

    public final zzib zzI() {
        zzan();
        return this.zzW.zzf;
    }

    final /* synthetic */ void zzJ(zzaz zzazVar, zzs zzsVar) {
        zzazVar.zza(this.zzg, new zzay(zzsVar));
    }

    final /* synthetic */ void zzK(final zzke zzkeVar) {
        this.zzk.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzjj
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzO(zzkeVar);
            }
        });
    }

    final /* synthetic */ void zzL(int i, final int i2) {
        zzan();
        Integer numValueOf = Integer.valueOf(i2);
        zzao(1, 10, numValueOf);
        zzao(2, 10, numValueOf);
        zzdn zzdnVar = new zzdn() { // from class: com.google.android.gms.internal.ads.zzji
            @Override // com.google.android.gms.internal.ads.zzdn
            public final /* synthetic */ void zza(Object obj) {
                int i3 = zzju.zzd;
                ((zzaz) obj).zzq(i2);
            }
        };
        zzds zzdsVar = this.zzn;
        zzdsVar.zzd(21, zzdnVar);
        zzdsVar.zze();
    }

    final /* synthetic */ void zzM() {
        String str = zzep.zza;
        int iGenerateAudioSessionId = zzcb.zza(this.zzf).generateAudioSessionId();
        if (iGenerateAudioSessionId == -1) {
            iGenerateAudioSessionId = 0;
        }
        this.zzB.zzb(Integer.valueOf(iGenerateAudioSessionId));
    }

    final /* synthetic */ void zzN(zzaz zzazVar) {
        zzazVar.zzg(this.zzJ);
    }

    final /* synthetic */ void zzO(zzke zzkeVar) {
        long j;
        int i = this.zzD - zzkeVar.zzb;
        this.zzD = i;
        boolean z = true;
        if (zzkeVar.zzc) {
            this.zzE = zzkeVar.zzd;
            this.zzF = true;
        }
        if (i == 0) {
            zzbf zzbfVar = zzkeVar.zza.zza;
            if (!this.zzW.zza.zzg() && zzbfVar.zzg()) {
                this.zzX = -1;
                this.zzY = 0L;
            }
            if (!zzbfVar.zzg()) {
                List listZzw = ((zzll) zzbfVar).zzw();
                int size = listZzw.size();
                List list = this.zzq;
                zzgmd.zzh(size == list.size());
                for (int i2 = 0; i2 < listZzw.size(); i2++) {
                    ((zzjt) list.get(i2)).zzc((zzbf) listZzw.get(i2));
                }
            }
            boolean z2 = this.zzF;
            long j2 = C.TIME_UNSET;
            if (z2) {
                if (zzkeVar.zza.zzb.equals(this.zzW.zzb) && zzkeVar.zza.zzd == this.zzW.zzs) {
                    z = false;
                }
                if (z) {
                    if (zzbfVar.zzg() || zzkeVar.zza.zzb.zzb()) {
                        j = zzkeVar.zza.zzd;
                    } else {
                        zzlf zzlfVar = zzkeVar.zza;
                        zzuu zzuuVar = zzlfVar.zzb;
                        j = zzlfVar.zzd;
                        zzai(zzbfVar, zzuuVar, j);
                    }
                    j2 = j;
                }
            } else {
                z = false;
            }
            this.zzF = false;
            zzad(zzkeVar.zza, 1, z, this.zzE, j2, -1, false);
        }
    }

    final /* synthetic */ void zzQ(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        zzak(surface);
        this.zzM = surface;
    }

    final /* synthetic */ void zzR(Object obj) {
        zzak(null);
    }

    final /* synthetic */ zzds zzT() {
        return this.zzn;
    }

    final /* synthetic */ zzmi zzU() {
        return this.zzs;
    }

    final /* synthetic */ zzdb zzV() {
        return this.zzB;
    }

    final /* synthetic */ Object zzW() {
        return this.zzL;
    }

    final /* synthetic */ boolean zzX() {
        return this.zzR;
    }

    final /* synthetic */ void zzY(boolean z) {
        this.zzR = z;
    }

    @Override // com.google.android.gms.internal.ads.zzf
    protected final void zzc(int i, long j, int i2, boolean z) {
        zzan();
        if (i == -1) {
            return;
        }
        zzgmd.zza(i >= 0);
        zzbf zzbfVar = this.zzW.zza;
        if (zzbfVar.zzg() || i < zzbfVar.zza()) {
            this.zzs.zzA();
            this.zzD++;
            if (zzx()) {
                zzdt.zzc("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                zzke zzkeVar = new zzke(this.zzW);
                zzkeVar.zza(1);
                this.zzl.zza(zzkeVar);
                return;
            }
            zzlf zzlfVarZzag = this.zzW;
            int i3 = zzlfVarZzag.zze;
            if (i3 == 3 || (i3 == 4 && !zzbfVar.zzg())) {
                zzlfVarZzag = zzag(this.zzW, 2);
            }
            int iZzs = zzs();
            zzlf zzlfVarZzaf = zzaf(zzlfVarZzag, zzbfVar, zzah(zzbfVar, i, j));
            this.zzm.zzf(zzbfVar, i, zzep.zzq(j));
            zzad(zzlfVarZzaf, 0, true, 1, zzac(zzlfVarZzaf), iZzs, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final Looper zzd() {
        return this.zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzf(zzaz zzazVar) {
        zzan();
        this.zzn.zzc(zzazVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzg() {
        zzan();
        zzlf zzlfVar = this.zzW;
        if (zzlfVar.zze != 1) {
            return;
        }
        zzlf zzlfVarZzf = zzlfVar.zzf(null);
        zzlf zzlfVarZzag = zzag(zzlfVarZzf, true != zzlfVarZzf.zza.zzg() ? 2 : 4);
        this.zzD++;
        this.zzm.zzd();
        zzad(zzlfVarZzag, 1, false, 5, C.TIME_UNSET, -1, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzh() {
        zzan();
        return this.zzW.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzi() {
        zzan();
        return this.zzW.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzj(boolean z) {
        zzan();
        zzlf zzlfVar = this.zzW;
        int i = zzlfVar.zzn;
        int i2 = 0;
        if (i == 1) {
            if (z) {
                i = 1;
            } else {
                i = 1;
                i2 = 1;
            }
        }
        if (zzlfVar.zzl == z && i == i2 && zzlfVar.zzm == 1) {
            return;
        }
        this.zzD++;
        boolean z2 = zzlfVar.zzp;
        zzlf zzlfVarZzi = zzlfVar.zzi(z, 1, i2);
        this.zzm.zze(z, 1, i2);
        zzad(zzlfVarZzi, 0, false, 5, C.TIME_UNSET, -1, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final boolean zzk() {
        zzan();
        return this.zzW.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzl() {
        zzan();
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final boolean zzm() {
        zzan();
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final zzav zzn() {
        zzan();
        return this.zzW.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzo() {
        zzan();
        zzP(null);
        new zzco(zzgpe.zzi(), this.zzW.zzs);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final zzbn zzp() {
        zzan();
        return this.zzW.zzi.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final zzbf zzq() {
        zzan();
        return this.zzW.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzr() {
        zzan();
        if (this.zzW.zza.zzg()) {
            return 0;
        }
        zzlf zzlfVar = this.zzW;
        return zzlfVar.zza.zze(zzlfVar.zzb.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzs() {
        zzan();
        int iZzaa = zzaa(this.zzW);
        if (iZzaa == -1) {
            return 0;
        }
        return iZzaa;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzt() {
        zzan();
        if (!zzx()) {
            zzbf zzbfVarZzq = zzq();
            return zzbfVarZzq.zzg() ? C.TIME_UNSET : zzep.zzp(zzbfVarZzq.zzb(zzs(), this.zza, 0L).zzm);
        }
        zzlf zzlfVar = this.zzW;
        zzuu zzuuVar = zzlfVar.zzb;
        zzbf zzbfVar = zzlfVar.zza;
        Object obj = zzuuVar.zza;
        zzbd zzbdVar = this.zzp;
        zzbfVar.zzo(obj, zzbdVar);
        return zzep.zzp(zzbdVar.zzh(zzuuVar.zzb, zzuuVar.zzc));
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzu() {
        zzan();
        return zzep.zzp(zzac(this.zzW));
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzv() {
        zzan();
        if (zzx()) {
            zzlf zzlfVar = this.zzW;
            return zzlfVar.zzk.equals(zzlfVar.zzb) ? zzep.zzp(this.zzW.zzq) : zzt();
        }
        zzan();
        if (this.zzW.zza.zzg()) {
            return this.zzY;
        }
        zzlf zzlfVar2 = this.zzW;
        long j = 0;
        if (zzlfVar2.zzk.zzd != zzlfVar2.zzb.zzd) {
            return zzep.zzp(zzlfVar2.zza.zzb(zzs(), this.zza, 0L).zzm);
        }
        long j2 = zzlfVar2.zzq;
        if (this.zzW.zzk.zzb()) {
            zzlf zzlfVar3 = this.zzW;
            zzlfVar3.zza.zzo(zzlfVar3.zzk.zza, this.zzp).zzc(this.zzW.zzk.zzb);
        } else {
            j = j2;
        }
        zzlf zzlfVar4 = this.zzW;
        zzai(zzlfVar4.zza, zzlfVar4.zzk, j);
        return zzep.zzp(j);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzw() {
        zzan();
        return zzep.zzp(this.zzW.zzr);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final boolean zzx() {
        zzan();
        return this.zzW.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzy() {
        zzan();
        if (zzx()) {
            return this.zzW.zzb.zzb;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzz() {
        zzan();
        if (zzx()) {
            return this.zzW.zzb.zzc;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zze(zzaz zzazVar) {
        zzazVar.getClass();
        this.zzn.zzb(zzazVar);
    }
}
