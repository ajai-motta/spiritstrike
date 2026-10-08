package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzalf {
    public final String zza;
    public final String zzb;
    public final boolean zzc;
    public final long zzd;
    public final long zze;
    public final zzall zzf;
    public final String zzg;
    public final String zzh;
    public final zzalf zzi;
    private final String[] zzj;
    private final HashMap zzk;
    private final HashMap zzl;
    private List zzm;

    public static zzalf zza(String str) {
        return new zzalf(null, str.replaceAll(ServerSentEventKt.END_OF_LINE, "\n").replaceAll(" *\n *", "\n").replaceAll("\n", ServerSentEventKt.SPACE).replaceAll("[ \t\\x0B\f\r]+", ServerSentEventKt.SPACE), C.TIME_UNSET, C.TIME_UNSET, null, null, "", null, null);
    }

    public static zzalf zzb(String str, long j, long j2, zzall zzallVar, String[] strArr, String str2, String str3, zzalf zzalfVar) {
        return new zzalf(str, null, j, j2, zzallVar, strArr, str2, str3, zzalfVar);
    }

    private final void zzi(TreeSet treeSet, boolean z) {
        String str = this.zza;
        boolean zEquals = TtmlNode.TAG_P.equals(str);
        boolean zEquals2 = TtmlNode.TAG_DIV.equals(str);
        if (z || zEquals || (zEquals2 && this.zzh != null)) {
            long j = this.zzd;
            if (j != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.zze;
            if (j2 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.zzm != null) {
            for (int i = 0; i < this.zzm.size(); i++) {
                zzalf zzalfVar = (zzalf) this.zzm.get(i);
                boolean z2 = true;
                if (!z && !zEquals) {
                    z2 = false;
                }
                zzalfVar.zzi(treeSet, z2);
            }
        }
    }

    private final void zzj(long j, String str, List list) {
        String str2;
        String str3 = this.zzg;
        if (true != "".equals(str3)) {
            str = str3;
        }
        if (zzc(j) && TtmlNode.TAG_DIV.equals(this.zza) && (str2 = this.zzh) != null) {
            list.add(new Pair(str, str2));
            return;
        }
        for (int i = 0; i < zzf(); i++) {
            zze(i).zzj(j, str, list);
        }
    }

    private final void zzk(long j, boolean z, String str, Map map) {
        HashMap map2 = this.zzk;
        map2.clear();
        HashMap map3 = this.zzl;
        map3.clear();
        String str2 = this.zza;
        if (TtmlNode.TAG_METADATA.equals(str2)) {
            return;
        }
        String str3 = this.zzg;
        String str4 = true != "".equals(str3) ? str3 : str;
        if (this.zzc && z) {
            SpannableStringBuilder spannableStringBuilderZzl = zzl(str4, map);
            String str5 = this.zzb;
            str5.getClass();
            spannableStringBuilderZzl.append((CharSequence) str5);
            return;
        }
        if (TtmlNode.TAG_BR.equals(str2) && z) {
            zzl(str4, map).append('\n');
            return;
        }
        if (zzc(j)) {
            for (Map.Entry entry : map.entrySet()) {
                String str6 = (String) entry.getKey();
                CharSequence charSequenceZzb = ((zzcl) entry.getValue()).zzb();
                charSequenceZzb.getClass();
                map2.put(str6, Integer.valueOf(charSequenceZzb.length()));
            }
            boolean zEquals = TtmlNode.TAG_P.equals(str2);
            for (int i = 0; i < zzf(); i++) {
                zze(i).zzk(j, z || zEquals, str4, map);
            }
            if (zEquals) {
                SpannableStringBuilder spannableStringBuilderZzl2 = zzl(str4, map);
                int length = spannableStringBuilderZzl2.length();
                do {
                    length--;
                    if (length < 0) {
                        break;
                    }
                } while (spannableStringBuilderZzl2.charAt(length) == ' ');
                if (length >= 0 && spannableStringBuilderZzl2.charAt(length) != '\n') {
                    spannableStringBuilderZzl2.append('\n');
                }
            }
            for (Map.Entry entry2 : map.entrySet()) {
                String str7 = (String) entry2.getKey();
                CharSequence charSequenceZzb2 = ((zzcl) entry2.getValue()).zzb();
                charSequenceZzb2.getClass();
                map3.put(str7, Integer.valueOf(charSequenceZzb2.length()));
            }
        }
    }

    private static SpannableStringBuilder zzl(String str, Map map) {
        if (!map.containsKey(str)) {
            zzcl zzclVar = new zzcl();
            zzclVar.zza(new SpannableStringBuilder());
            map.put(str, zzclVar);
        }
        CharSequence charSequenceZzb = ((zzcl) map.get(str)).zzb();
        charSequenceZzb.getClass();
        return (SpannableStringBuilder) charSequenceZzb;
    }

    private final void zzm(long j, Map map, Map map2, String str, Map map3) {
        Iterator it;
        zzalf zzalfVar;
        zzall zzallVarZza;
        boolean z;
        int i;
        if (zzc(j)) {
            String str2 = this.zzg;
            String str3 = true != "".equals(str2) ? str2 : str;
            Iterator it2 = this.zzl.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                String str4 = (String) entry.getKey();
                HashMap map4 = this.zzk;
                int iIntValue = map4.containsKey(str4) ? ((Integer) map4.get(str4)).intValue() : 0;
                int iIntValue2 = ((Integer) entry.getValue()).intValue();
                if (iIntValue != iIntValue2) {
                    zzcl zzclVar = (zzcl) map3.get(str4);
                    zzclVar.getClass();
                    zzalj zzaljVar = (zzalj) map2.get(str3);
                    zzaljVar.getClass();
                    int i2 = zzaljVar.zzj;
                    zzall zzallVarZza2 = zzalk.zza(this.zzf, this.zzj, map);
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) zzclVar.zzb();
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        zzclVar.zza(spannableStringBuilder);
                    }
                    if (zzallVarZza2 != null) {
                        zzalf zzalfVar2 = this.zzi;
                        if (zzallVarZza2.zza() != -1) {
                            spannableStringBuilder.setSpan(new StyleSpan(zzallVarZza2.zza()), iIntValue, iIntValue2, 33);
                        }
                        if (zzallVarZza2.zzb()) {
                            spannableStringBuilder.setSpan(new StrikethroughSpan(), iIntValue, iIntValue2, 33);
                        }
                        if (zzallVarZza2.zzd()) {
                            spannableStringBuilder.setSpan(new UnderlineSpan(), iIntValue, iIntValue2, 33);
                        }
                        if (zzallVarZza2.zzl()) {
                            zzcs.zza(spannableStringBuilder, new ForegroundColorSpan(zzallVarZza2.zzj()), iIntValue, iIntValue2, 33);
                        }
                        if (zzallVarZza2.zzo()) {
                            zzcs.zza(spannableStringBuilder, new BackgroundColorSpan(zzallVarZza2.zzm()), iIntValue, iIntValue2, 33);
                        }
                        if (zzallVarZza2.zzh() != null) {
                            zzcs.zza(spannableStringBuilder, new TypefaceSpan(zzallVarZza2.zzh()), iIntValue, iIntValue2, 33);
                        }
                        if (zzallVarZza2.zzE() != null) {
                            zzale zzaleVarZzE = zzallVarZza2.zzE();
                            zzaleVarZzE.getClass();
                            int i3 = zzaleVarZzE.zza;
                            it = it2;
                            if (i3 == -1) {
                                i3 = (i2 == 2 || i2 == 1) ? 3 : 1;
                                i = 1;
                            } else {
                                i = zzaleVarZzE.zzb;
                            }
                            int i4 = zzaleVarZzE.zzc;
                            if (i4 == -2) {
                                i4 = 1;
                            }
                            zzcs.zza(spannableStringBuilder, new zzct(i3, i, i4), iIntValue, iIntValue2, 33);
                        } else {
                            it = it2;
                        }
                        int iZzv = zzallVarZza2.zzv();
                        if (iZzv == 2) {
                            while (true) {
                                if (zzalfVar2 == null) {
                                    zzalfVar2 = null;
                                    break;
                                }
                                zzall zzallVarZza3 = zzalk.zza(zzalfVar2.zzf, zzalfVar2.zzj, map);
                                if (zzallVarZza3 != null && zzallVarZza3.zzv() == 1) {
                                    break;
                                } else {
                                    zzalfVar2 = zzalfVar2.zzi;
                                }
                            }
                            if (zzalfVar2 != null) {
                                ArrayDeque arrayDeque = new ArrayDeque();
                                arrayDeque.push(zzalfVar2);
                                while (true) {
                                    if (arrayDeque.isEmpty()) {
                                        zzalfVar = null;
                                        break;
                                    }
                                    zzalf zzalfVar3 = (zzalf) arrayDeque.pop();
                                    zzall zzallVarZza4 = zzalk.zza(zzalfVar3.zzf, zzalfVar3.zzj, map);
                                    if (zzallVarZza4 != null && zzallVarZza4.zzv() == 3) {
                                        zzalfVar = zzalfVar3;
                                        break;
                                    }
                                    for (int iZzf = zzalfVar3.zzf() - 1; iZzf >= 0; iZzf--) {
                                        arrayDeque.push(zzalfVar3.zze(iZzf));
                                    }
                                }
                                if (zzalfVar != null) {
                                    if (zzalfVar.zzf() != 1 || zzalfVar.zze(0).zzb == null) {
                                        zzdt.zzb("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                                    } else {
                                        String str5 = zzalfVar.zze(0).zzb;
                                        String str6 = zzep.zza;
                                        zzall zzallVarZza5 = zzalk.zza(zzalfVar.zzf, zzalfVar.zzj, map);
                                        int iZzx = zzallVarZza5 != null ? zzallVarZza5.zzx() : -1;
                                        if (iZzx == -1 && (zzallVarZza = zzalk.zza(zzalfVar2.zzf, zzalfVar2.zzj, map)) != null) {
                                            iZzx = zzallVarZza.zzx();
                                        }
                                        spannableStringBuilder.setSpan(new zzcr(str5, iZzx), iIntValue, iIntValue2, 33);
                                    }
                                }
                            }
                        } else if (iZzv == 3 || iZzv == 4) {
                            spannableStringBuilder.setSpan(new zzald(), iIntValue, iIntValue2, 33);
                        }
                        if (zzallVarZza2.zzC()) {
                            zzcs.zza(spannableStringBuilder, new zzcq(), iIntValue, iIntValue2, 33);
                        }
                        int iZzI = zzallVarZza2.zzI();
                        if (iZzI != 1) {
                            if (iZzI == 2) {
                                zzcs.zza(spannableStringBuilder, new RelativeSizeSpan(zzallVarZza2.zzJ()), iIntValue, iIntValue2, 33);
                            } else if (iZzI == 3) {
                                zzcs.zzb(spannableStringBuilder, zzallVarZza2.zzJ() / 100.0f, iIntValue, iIntValue2, 33);
                            }
                            z = true;
                        } else {
                            z = true;
                            zzcs.zza(spannableStringBuilder, new AbsoluteSizeSpan((int) zzallVarZza2.zzJ(), true), iIntValue, iIntValue2, 33);
                        }
                        if (TtmlNode.TAG_P.equals(this.zza)) {
                            if (zzallVarZza2.zzq() != Float.MAX_VALUE) {
                                zzclVar.zzp((zzallVarZza2.zzq() * (-90.0f)) / 100.0f);
                            }
                            if (zzallVarZza2.zzy() != null) {
                                zzclVar.zzd(zzallVarZza2.zzy());
                            }
                            if (zzallVarZza2.zzA() != null) {
                                zzclVar.zze(zzallVarZza2.zzA());
                            }
                        }
                        it2 = it;
                    }
                }
            }
            for (int i5 = 0; i5 < zzf(); i5++) {
                zze(i5).zzm(j, map, map2, str3, map3);
            }
        }
    }

    public final boolean zzc(long j) {
        long j2 = this.zzd;
        if (j2 == C.TIME_UNSET) {
            if (this.zze == C.TIME_UNSET) {
                return true;
            }
            j2 = -9223372036854775807L;
        }
        if (j2 <= j && this.zze == C.TIME_UNSET) {
            return true;
        }
        if (j2 != C.TIME_UNSET || j >= this.zze) {
            return j2 <= j && j < this.zze;
        }
        return true;
    }

    public final void zzd(zzalf zzalfVar) {
        if (this.zzm == null) {
            this.zzm = new ArrayList();
        }
        this.zzm.add(zzalfVar);
    }

    public final zzalf zze(int i) {
        List list = this.zzm;
        if (list != null) {
            return (zzalf) list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public final int zzf() {
        List list = this.zzm;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final long[] zzg() {
        TreeSet treeSet = new TreeSet();
        int i = 0;
        zzi(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = ((Long) it.next()).longValue();
            i++;
        }
        return jArr;
    }

    public final List zzh(long j, Map map, Map map2, Map map3) {
        List arrayList = new ArrayList();
        String str = this.zzg;
        zzj(j, str, arrayList);
        TreeMap treeMap = new TreeMap();
        zzk(j, false, str, treeMap);
        zzm(j, map, map2, str, treeMap);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Pair pair = (Pair) arrayList.get(i);
            String str2 = (String) map3.get(pair.second);
            if (str2 != null) {
                byte[] bArrDecode = Base64.decode(str2, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                zzalj zzaljVar = (zzalj) map2.get(pair.first);
                zzaljVar.getClass();
                zzcl zzclVar = new zzcl();
                zzclVar.zzc(bitmapDecodeByteArray);
                zzclVar.zzi(zzaljVar.zzb);
                zzclVar.zzj(0);
                zzclVar.zzf(zzaljVar.zzc, 0);
                zzclVar.zzg(zzaljVar.zze);
                zzclVar.zzm(zzaljVar.zzf);
                zzclVar.zzn(zzaljVar.zzg);
                zzclVar.zzo(zzaljVar.zzj);
                arrayList2.add(zzclVar.zzr());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            zzalj zzaljVar2 = (zzalj) map2.get(entry.getKey());
            zzaljVar2.getClass();
            zzcl zzclVar2 = (zzcl) entry.getValue();
            CharSequence charSequenceZzb = zzclVar2.zzb();
            charSequenceZzb.getClass();
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequenceZzb;
            for (zzald zzaldVar : (zzald[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), zzald.class)) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(zzaldVar), spannableStringBuilder.getSpanEnd(zzaldVar), (CharSequence) "");
            }
            int i2 = 0;
            while (i2 < spannableStringBuilder.length()) {
                int i3 = i2 + 1;
                if (spannableStringBuilder.charAt(i2) == ' ') {
                    int i4 = i3;
                    while (i4 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i4) == ' ') {
                        i4++;
                    }
                    int i5 = i4 - i3;
                    if (i5 > 0) {
                        spannableStringBuilder.delete(i2, i5 + i2);
                    }
                }
                i2 = i3;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
            }
            int i6 = 0;
            while (i6 < spannableStringBuilder.length() - 1) {
                int i7 = i6 + 1;
                if (spannableStringBuilder.charAt(i6) == '\n' && spannableStringBuilder.charAt(i7) == ' ') {
                    spannableStringBuilder.delete(i7, i6 + 2);
                }
                i6 = i7;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            int i8 = 0;
            while (i8 < spannableStringBuilder.length() - 1) {
                int i9 = i8 + 1;
                if (spannableStringBuilder.charAt(i8) == ' ' && spannableStringBuilder.charAt(i9) == '\n') {
                    spannableStringBuilder.delete(i8, i9);
                }
                i8 = i9;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            zzclVar2.zzf(zzaljVar2.zzc, zzaljVar2.zzd);
            zzclVar2.zzg(zzaljVar2.zze);
            zzclVar2.zzi(zzaljVar2.zzb);
            zzclVar2.zzm(zzaljVar2.zzf);
            zzclVar2.zzl(zzaljVar2.zzi, zzaljVar2.zzh);
            zzclVar2.zzo(zzaljVar2.zzj);
            arrayList2.add(zzclVar2.zzr());
        }
        return arrayList2;
    }

    private zzalf(String str, String str2, long j, long j2, zzall zzallVar, String[] strArr, String str3, String str4, zzalf zzalfVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzh = str4;
        this.zzf = zzallVar;
        this.zzj = strArr;
        this.zzc = str2 != null;
        this.zzd = j;
        this.zze = j2;
        str3.getClass();
        this.zzg = str3;
        this.zzi = zzalfVar;
        this.zzk = new HashMap();
        this.zzl = new HashMap();
    }
}
