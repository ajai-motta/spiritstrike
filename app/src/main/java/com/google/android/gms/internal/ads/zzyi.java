package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.internal.ads.zzlp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzyi extends zzyo implements zzlo {
    public static final /* synthetic */ int zzb = 0;
    private static final zzgqy zzc = zzgqy.zzc(zzxo.zza);
    public final Context zza;
    private final Object zzd;
    private zzxt zze;
    private Thread zzf;
    private zzxx zzg;
    private zzd zzh;
    private Boolean zzi;
    private final zzxb zzj;

    public zzyi(Context context) {
        zzxb zzxbVar = new zzxb();
        zzxt zzxtVar = zzxt.zzJ;
        this.zzd = new Object();
        byte[] bArr = null;
        this.zza = context != null ? context.getApplicationContext() : null;
        this.zzj = zzxbVar;
        if (zzxtVar instanceof zzxt) {
            this.zze = zzxtVar;
        } else {
            zzxs zzxsVar = new zzxs(zzxtVar, bArr);
            zzxsVar.zzx((zzbl) zzxtVar);
            this.zze = new zzxt(zzxsVar, bArr);
        }
        this.zzh = zzd.zza;
        if (this.zze.zzU && context == null) {
            zzdt.zzc("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    protected static String zzi(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, C.LANGUAGE_UNDETERMINED)) {
            return null;
        }
        return str;
    }

    protected static int zzj(zzv zzvVar, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(zzvVar.zzd)) {
            return 4;
        }
        String strZzi = zzi(str);
        String strZzi2 = zzi(zzvVar.zzd);
        if (strZzi2 == null || strZzi == null) {
            return (z && strZzi2 == null) ? 1 : 0;
        }
        if (strZzi2.startsWith(strZzi) || strZzi.startsWith(strZzi2)) {
            return 3;
        }
        String str2 = zzep.zza;
        return strZzi2.split("-", 2)[0].equals(strZzi.split("-", 2)[0]) ? 2 : 0;
    }

    static /* synthetic */ int zzm(int i, int i2) {
        if (i == 0 || i != i2) {
            return Integer.bitCount(i & i2);
        }
        return Integer.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        r1 = r1 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ int zzn(com.google.android.gms.internal.ads.zzv r5, com.google.android.gms.internal.ads.zzgpe r6) {
        /*
            r0 = 0
            r1 = r0
        L2:
            int r2 = r6.size()
            if (r1 >= r2) goto L2a
            r2 = r0
        L9:
            java.util.List r3 = r5.zzc
            int r4 = r3.size()
            if (r2 >= r4) goto L27
            java.lang.Object r3 = r3.get(r2)
            com.google.android.gms.internal.ads.zzx r3 = (com.google.android.gms.internal.ads.zzx) r3
            java.lang.String r3 = r3.zzb
            java.lang.Object r4 = r6.get(r1)
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L24
            goto L2d
        L24:
            int r2 = r2 + 1
            goto L9
        L27:
            int r1 = r1 + 1
            goto L2
        L2a:
            r1 = 2147483647(0x7fffffff, float:NaN)
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyi.zzn(com.google.android.gms.internal.ads.zzv, com.google.android.gms.internal.ads.zzgpe):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzu, reason: merged with bridge method [inline-methods] */
    public final void zzl() {
        boolean z;
        zzxx zzxxVar;
        synchronized (this.zzd) {
            z = false;
            if (this.zze.zzU && Build.VERSION.SDK_INT >= 32 && (zzxxVar = this.zzg) != null && zzxxVar.zza()) {
                z = true;
            }
        }
        if (z) {
            zzs();
        }
    }

    private static void zzv(zzwv zzwvVar, zzbl zzblVar, Map map) {
        for (int i = 0; i < zzwvVar.zzb; i++) {
            if (((zzbh) zzblVar.zzH.get(zzwvVar.zza(i))) != null) {
                throw null;
            }
        }
    }

    private static final Pair zzw(int i, zzyn zzynVar, int[][][] iArr, zzxz zzxzVar, Comparator comparator) {
        RandomAccess randomAccessZzj;
        boolean z;
        zzyn zzynVar2 = zzynVar;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < 2) {
            if (i == zzynVar2.zza(i2)) {
                zzwv zzwvVarZzb = zzynVar2.zzb(i2);
                for (int i3 = 0; i3 < zzwvVarZzb.zzb; i3++) {
                    zzbg zzbgVarZza = zzwvVarZzb.zza(i3);
                    List listZza = zzxzVar.zza(i2, zzbgVarZza, iArr[i2][i3]);
                    int i4 = zzbgVarZza.zza;
                    boolean[] zArr = new boolean[i4];
                    int i5 = 0;
                    while (i5 < i4) {
                        int i6 = i5 + 1;
                        zzya zzyaVar = (zzya) listZza.get(i5);
                        int iZza = zzyaVar.zza();
                        if (!zArr[i5] && iZza != 0) {
                            if (iZza == 1) {
                                randomAccessZzj = zzgpe.zzj(zzyaVar);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(zzyaVar);
                                for (int i7 = i6; i7 < i4; i7++) {
                                    zzya zzyaVar2 = (zzya) listZza.get(i7);
                                    if (zzyaVar2.zza() == 2 && zzyaVar.zzc(zzyaVar2)) {
                                        arrayList2.add(zzyaVar2);
                                        z = true;
                                        zArr[i7] = true;
                                    } else {
                                        z = true;
                                    }
                                }
                                randomAccessZzj = arrayList2;
                            }
                            arrayList.add(randomAccessZzj);
                        }
                        i5 = i6;
                    }
                }
            }
            i2++;
            zzynVar2 = zzynVar;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i8 = 0; i8 < list.size(); i8++) {
            iArr2[i8] = ((zzya) list.get(i8)).zzc;
        }
        zzya zzyaVar3 = (zzya) list.get(0);
        return Pair.create(new zzyj(zzyaVar3.zzb, iArr2, 0), Integer.valueOf(zzyaVar3.zza));
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void zza(zzln zzlnVar) {
        synchronized (this.zzd) {
            boolean z = this.zze.zzY;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyr
    public final void zzb() {
        zzxx zzxxVar;
        synchronized (this.zzd) {
            Thread thread = this.zzf;
            if (thread != null) {
                zzgmd.zzi(thread == Thread.currentThread(), "DefaultTrackSelector is accessed on the wrong thread.");
            }
        }
        if (Build.VERSION.SDK_INT >= 32 && (zzxxVar = this.zzg) != null) {
            zzxxVar.zze();
            this.zzg = null;
        }
        super.zzb();
    }

    public final zzxt zzc() {
        zzxt zzxtVar;
        synchronized (this.zzd) {
            zzxtVar = this.zze;
        }
        return zzxtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyr
    public final boolean zzd() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzyr
    public final void zze(zzd zzdVar) {
        if (this.zzh.equals(zzdVar)) {
            return;
        }
        this.zzh = zzdVar;
        zzl();
    }

    public final void zzf(zzxs zzxsVar) {
        boolean z;
        zzxt zzxtVar = new zzxt(zzxsVar, null);
        synchronized (this.zzd) {
            z = !this.zze.equals(zzxtVar);
            this.zze = zzxtVar;
        }
        if (z) {
            if (zzxtVar.zzU && this.zza == null) {
                zzdt.zzc("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            zzs();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyr
    public final zzlo zzg() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    protected final Pair zzh(zzyn zzynVar, int[][][] iArr, final int[] iArr2, zzuu zzuuVar, zzbf zzbfVar) throws zzib {
        final zzxt zzxtVar;
        int i;
        final boolean z;
        final String languageTag;
        int i2;
        int[] iArr3;
        int length;
        zzyk zzykVarZza;
        Context context;
        CaptioningManager captioningManager;
        Locale locale;
        Context context2;
        Context context3;
        synchronized (this.zzd) {
            this.zzf = Thread.currentThread();
            zzxtVar = this.zze;
        }
        if (this.zzi == null && (context3 = this.zza) != null) {
            this.zzi = Boolean.valueOf(zzep.zzN(context3));
        }
        if (zzxtVar.zzU && Build.VERSION.SDK_INT >= 32 && this.zzg == null) {
            this.zzg = new zzxx(this.zza, this, this.zzi);
        }
        int i3 = 2;
        zzyj[] zzyjVarArr = new zzyj[2];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i = 1;
            if (i5 >= 2) {
                z = false;
                break;
            }
            if (zzynVar.zza(i5) == 2 && zzynVar.zzb(i5).zzb > 0) {
                z = true;
                break;
            }
            i5++;
        }
        Pair pairZzw = zzw(1, zzynVar, iArr, new zzxz() { // from class: com.google.android.gms.internal.ads.zzxk
            @Override // com.google.android.gms.internal.ads.zzxz
            public final /* synthetic */ List zza(int i6, zzbg zzbgVar, int[] iArr4) {
                zzxk zzxkVar = this;
                final zzyi zzyiVar = zzxkVar.zza;
                final zzxt zzxtVar2 = zzxtVar;
                zzgme zzgmeVar = new zzgme() { // from class: com.google.android.gms.internal.ads.zzxn
                    @Override // com.google.android.gms.internal.ads.zzgme
                    public final /* synthetic */ boolean zza(Object obj) {
                        return zzyiVar.zzk(zzxtVar2, (zzv) obj);
                    }
                };
                int i7 = iArr2[i6];
                int i8 = zzgpe.zzd;
                zzgpb zzgpbVar = new zzgpb();
                int i9 = 0;
                while (i9 < zzbgVar.zza) {
                    zzgpbVar.zzf(new zzxf(i6, zzbgVar, i9, zzxtVar2, iArr4[i9], z, zzgmeVar, i7));
                    i9++;
                    zzxkVar = this;
                }
                return zzgpbVar.zzi();
            }
        }, zzxg.zza);
        if (pairZzw != null) {
            zzyjVarArr[((Integer) pairZzw.second).intValue()] = (zzyj) pairZzw.first;
        }
        final String str = pairZzw == null ? null : ((zzyj) pairZzw.first).zza.zza(((zzyj) pairZzw.first).zzb[0]).zzd;
        int i6 = zzxtVar.zzw.zzb;
        final Point pointZzP = (!zzxtVar.zzk || (context2 = this.zza) == null) ? null : zzep.zzP(context2);
        Pair pairZzw2 = zzw(2, zzynVar, iArr, new zzxz() { // from class: com.google.android.gms.internal.ads.zzxp
            /* JADX WARN: Removed duplicated region for block: B:29:0x004c  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x0054  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
            @Override // com.google.android.gms.internal.ads.zzxz
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final /* synthetic */ java.util.List zza(int r20, com.google.android.gms.internal.ads.zzbg r21, int[] r22) {
                /*
                    Method dump skipped, instruction units count: 214
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxp.zza(int, com.google.android.gms.internal.ads.zzbg, int[]):java.util.List");
            }
        }, zzxj.zza);
        boolean z2 = zzxtVar.zzE;
        int i7 = 4;
        Pair pairZzw3 = pairZzw2 == null ? zzw(4, zzynVar, iArr, new zzxz() { // from class: com.google.android.gms.internal.ads.zzxm
            @Override // com.google.android.gms.internal.ads.zzxz
            public final /* synthetic */ List zza(int i8, zzbg zzbgVar, int[] iArr4) {
                int i9 = zzyi.zzb;
                int i10 = zzgpe.zzd;
                zzgpb zzgpbVar = new zzgpb();
                for (int i11 = 0; i11 < zzbgVar.zza; i11++) {
                    zzgpbVar.zzf(new zzxq(i8, zzbgVar, i11, zzxtVar, iArr4[i11]));
                }
                return zzgpbVar.zzi();
            }
        }, zzxh.zza) : null;
        if (pairZzw3 != null) {
            zzyjVarArr[((Integer) pairZzw3.second).intValue()] = (zzyj) pairZzw3.first;
        } else if (pairZzw2 != null) {
            zzyjVarArr[((Integer) pairZzw2.second).intValue()] = (zzyj) pairZzw2.first;
        }
        if (!zzxtVar.zzB || (context = this.zza) == null || (captioningManager = (CaptioningManager) context.getSystemService("captioning")) == null || !captioningManager.isEnabled() || (locale = captioningManager.getLocale()) == null) {
            languageTag = null;
        } else {
            String str2 = zzep.zza;
            languageTag = locale.toLanguageTag();
        }
        int i8 = 3;
        Pair pairZzw4 = zzw(3, zzynVar, iArr, new zzxz() { // from class: com.google.android.gms.internal.ads.zzxl
            @Override // com.google.android.gms.internal.ads.zzxz
            public final /* synthetic */ List zza(int i9, zzbg zzbgVar, int[] iArr4) {
                int i10 = zzyi.zzb;
                int i11 = zzgpe.zzd;
                zzgpb zzgpbVar = new zzgpb();
                for (int i12 = 0; i12 < zzbgVar.zza; i12++) {
                    String str3 = languageTag;
                    int i13 = i12;
                    zzgpbVar.zzf(new zzxy(i9, zzbgVar, i13, zzxtVar, iArr4[i12], str, str3));
                }
                return zzgpbVar.zzi();
            }
        }, zzxi.zza);
        if (pairZzw4 != null) {
            zzyjVarArr[((Integer) pairZzw4.second).intValue()] = (zzyj) pairZzw4.first;
        }
        int i9 = 0;
        while (i9 < i3) {
            int iZza = zzynVar.zza(i9);
            if (iZza != i3 && iZza != i && iZza != i8 && iZza != i7) {
                zzwv zzwvVarZzb = zzynVar.zzb(i9);
                int[][] iArr4 = iArr[i9];
                int i10 = i4;
                int i11 = i10;
                zzbg zzbgVar = null;
                zzxr zzxrVar = null;
                while (i10 < zzwvVarZzb.zzb) {
                    zzbg zzbgVarZza = zzwvVarZzb.zza(i10);
                    int[] iArr5 = iArr4[i10];
                    zzxr zzxrVar2 = zzxrVar;
                    for (int i12 = i4; i12 < zzbgVarZza.zza; i12++) {
                        if (zzlp.CC.zzaa(iArr5[i12], zzxtVar.zzV)) {
                            zzxr zzxrVar3 = new zzxr(zzbgVarZza.zza(i12), iArr5[i12]);
                            if (zzxrVar2 == null || zzxrVar3.compareTo(zzxrVar2) > 0) {
                                zzbgVar = zzbgVarZza;
                                i11 = i12;
                                zzxrVar2 = zzxrVar3;
                            }
                        }
                    }
                    i10++;
                    zzxrVar = zzxrVar2;
                    i4 = 0;
                }
                zzyjVarArr[i9] = zzbgVar == null ? null : new zzyj(zzbgVar, new int[]{i11}, 0);
            }
            i9++;
            i3 = 2;
            i4 = 0;
            i8 = 3;
            i = 1;
            i7 = 4;
        }
        HashMap map = new HashMap();
        int i13 = 2;
        for (int i14 = 0; i14 < 2; i14++) {
            zzv(zzynVar.zzb(i14), zzxtVar, map);
        }
        zzv(zzynVar.zze(), zzxtVar, map);
        for (int i15 = 0; i15 < 2; i15++) {
            if (((zzbh) map.get(Integer.valueOf(zzynVar.zza(i15)))) != null) {
                throw null;
            }
        }
        int i16 = 0;
        while (i16 < i13) {
            zzwv zzwvVarZzb2 = zzynVar.zzb(i16);
            if (zzxtVar.zzb(i16, zzwvVarZzb2)) {
                if (zzxtVar.zzc(i16, zzwvVarZzb2) != null) {
                    throw null;
                }
                zzyjVarArr[i16] = null;
            }
            i16++;
            i13 = 2;
        }
        int i17 = 0;
        for (int i18 = i13; i17 < i18; i18 = 2) {
            int iZza2 = zzynVar.zza(i17);
            if (zzxtVar.zza(i17) || zzxtVar.zzI.contains(Integer.valueOf(iZza2))) {
                zzyjVarArr[i17] = null;
            }
            i17++;
        }
        zzxb zzxbVar = this.zzj;
        zzza zzzaVarZzt = zzt();
        zzgpe zzgpeVarZzd = zzxc.zzd(zzyjVarArr);
        int i19 = 2;
        zzyk[] zzykVarArr = new zzyk[2];
        int i20 = 0;
        while (i20 < i19) {
            zzyj zzyjVar = zzyjVarArr[i20];
            if (zzyjVar == null || (length = (iArr3 = zzyjVar.zzb).length) == 0) {
                i2 = i20;
            } else {
                if (length == 1) {
                    zzykVarZza = new zzyl(zzyjVar.zza, iArr3[0], 0, 0, null);
                    i2 = i20;
                } else {
                    i2 = i20;
                    zzykVarZza = zzxbVar.zza(zzyjVar.zza, iArr3, 0, zzzaVarZzt, (zzgpe) zzgpeVarZzd.get(i20));
                }
                zzykVarArr[i2] = zzykVarZza;
            }
            i20 = i2 + 1;
            i19 = 2;
        }
        zzlq[] zzlqVarArr = new zzlq[i19];
        for (int i21 = 0; i21 < i19; i21++) {
            zzlqVarArr[i21] = (zzxtVar.zza(i21) || zzxtVar.zzI.contains(Integer.valueOf(zzynVar.zza(i21))) || (zzynVar.zza(i21) != -2 && zzykVarArr[i21] == null)) ? null : zzlq.zza;
        }
        boolean z3 = zzxtVar.zzW;
        return Pair.create(zzlqVarArr, zzykVarArr);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    final /* synthetic */ boolean zzk(zzxt zzxtVar, zzv zzvVar) {
        zzxx zzxxVar;
        zzxx zzxxVar2;
        if (!zzxtVar.zzU) {
            return true;
        }
        Boolean bool = this.zzi;
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        int i = zzvVar.zzG;
        byte b = -1;
        if (i == -1 || i <= 2) {
            return true;
        }
        String str = zzvVar.zzo;
        if (str != null) {
            switch (str.hashCode()) {
                case -2123537834:
                    if (str.equals(MimeTypes.AUDIO_E_AC3_JOC)) {
                        b = 2;
                    }
                    break;
                case 187078296:
                    if (str.equals(MimeTypes.AUDIO_AC3)) {
                        b = 0;
                    }
                    break;
                case 187078297:
                    if (str.equals(MimeTypes.AUDIO_AC4)) {
                        b = 3;
                    }
                    break;
                case 1504578661:
                    if (str.equals(MimeTypes.AUDIO_E_AC3)) {
                        b = 1;
                    }
                    break;
            }
            if ((b == 0 || b == 1 || b == 2 || b == 3) && (Build.VERSION.SDK_INT < 32 || (zzxxVar2 = this.zzg) == null || !zzxxVar2.zza())) {
                return true;
            }
        }
        if (Build.VERSION.SDK_INT >= 32 && (zzxxVar = this.zzg) != null && zzxxVar.zza() && zzxxVar.zzb() && this.zzg.zzc()) {
            return this.zzg.zzd(this.zzh, zzvVar);
        }
        return false;
    }
}
