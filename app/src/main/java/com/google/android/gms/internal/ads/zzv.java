package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.C;
import com.google.android.gms.ads.AdError;
import com.unity3d.ads.core.data.model.exception.GatewayException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzv {
    public static final /* synthetic */ int zzO = 0;
    public final int zzA;
    public final float zzB;
    public final byte[] zzC;
    public final int zzD;
    public final zzi zzE;
    public final int zzF;
    public final int zzG;
    public final int zzH;
    public final int zzI;
    public final int zzJ;
    public final int zzK;
    public final int zzL;
    public final int zzM;
    public final int zzN;
    private int zzP;
    public final String zza;
    public final String zzb;
    public final List zzc;
    public final String zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final String zzk;
    public final zzap zzl;
    public final Object zzm;
    public final String zzn;
    public final String zzo;
    public final int zzp;
    public final int zzq;
    public final List zzr;
    public final zzq zzs;
    public final long zzt;
    public final boolean zzu;
    public final int zzv;
    public final int zzw;
    public final int zzx;
    public final int zzy;
    public final float zzz;

    static {
        new zzv(new zzt());
        String str = zzep.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
        Integer.toString(8, 36);
        Integer.toString(9, 36);
        Integer.toString(10, 36);
        Integer.toString(11, 36);
        Integer.toString(12, 36);
        Integer.toString(13, 36);
        Integer.toString(14, 36);
        Integer.toString(15, 36);
        Integer.toString(16, 36);
        Integer.toString(17, 36);
        Integer.toString(18, 36);
        Integer.toString(19, 36);
        Integer.toString(20, 36);
        Integer.toString(21, 36);
        Integer.toString(22, 36);
        Integer.toString(23, 36);
        Integer.toString(24, 36);
        Integer.toString(25, 36);
        Integer.toString(26, 36);
        Integer.toString(27, 36);
        Integer.toString(28, 36);
        Integer.toString(29, 36);
        Integer.toString(30, 36);
        Integer.toString(31, 36);
        Integer.toString(32, 36);
        Integer.toString(33, 36);
        Integer.toString(34, 36);
        Integer.toString(35, 36);
        Integer.toString(36, 36);
    }

    private zzv(zzt zztVar) {
        boolean z;
        String str;
        this.zza = zztVar.zzN();
        String strZzh = zzep.zzh(zztVar.zzQ());
        this.zzd = strZzh;
        if (zztVar.zzP().isEmpty() && zztVar.zzO() != null) {
            this.zzc = zzgpe.zzj(new zzx(strZzh, zztVar.zzO()));
            this.zzb = zztVar.zzO();
        } else if (!zztVar.zzP().isEmpty() && zztVar.zzO() == null) {
            this.zzc = zztVar.zzP();
            List listZzP = zztVar.zzP();
            Iterator it = listZzP.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = ((zzx) listZzP.get(0)).zzb;
                    break;
                }
                zzx zzxVar = (zzx) it.next();
                if (TextUtils.equals(zzxVar.zza, strZzh)) {
                    str = zzxVar.zzb;
                    break;
                }
            }
            this.zzb = str;
        } else if (zztVar.zzP().isEmpty() && zztVar.zzO() == null) {
            z = true;
            zzgmd.zzh(z);
            this.zzc = zztVar.zzP();
            this.zzb = zztVar.zzO();
        } else {
            for (int i = 0; i < zztVar.zzP().size(); i++) {
                if (((zzx) zztVar.zzP().get(i)).zzb.equals(zztVar.zzO())) {
                    z = true;
                    break;
                }
            }
            z = false;
            zzgmd.zzh(z);
            this.zzc = zztVar.zzP();
            this.zzb = zztVar.zzO();
        }
        this.zze = zztVar.zzR();
        zzgmd.zzi(zztVar.zzT() == 0 || (zztVar.zzS() & 32768) != 0, "Auxiliary track type must only be set to a value other than AUXILIARY_TRACK_TYPE_UNDEFINED only when ROLE_FLAG_AUXILIARY is set");
        this.zzf = zztVar.zzS();
        this.zzg = zztVar.zzT();
        int iZzU = zztVar.zzU();
        this.zzh = iZzU;
        int iZzV = zztVar.zzV();
        this.zzi = iZzV;
        this.zzj = iZzV != -1 ? iZzV : iZzU;
        this.zzk = zztVar.zzW();
        this.zzl = zztVar.zzX();
        this.zzm = null;
        this.zzn = zztVar.zzY();
        this.zzo = zztVar.zzZ();
        this.zzp = zztVar.zzaa();
        this.zzq = zztVar.zzab();
        this.zzr = zztVar.zzac() == null ? Collections.emptyList() : zztVar.zzac();
        zzq zzqVarZzad = zztVar.zzad();
        this.zzs = zzqVarZzad;
        this.zzt = zztVar.zzae();
        this.zzu = zztVar.zzaf();
        this.zzv = zztVar.zzag();
        this.zzw = zztVar.zzah();
        this.zzx = zztVar.zzai();
        this.zzy = zztVar.zzaj();
        this.zzz = zztVar.zzak();
        this.zzA = zztVar.zzal() == -1 ? 0 : zztVar.zzal();
        this.zzB = zztVar.zzam() == -1.0f ? 1.0f : zztVar.zzam();
        this.zzC = zztVar.zzan();
        this.zzD = zztVar.zzao();
        this.zzE = zztVar.zzap();
        this.zzF = zztVar.zzaq();
        this.zzG = zztVar.zzar();
        this.zzH = zztVar.zzas();
        this.zzI = zztVar.zzat();
        this.zzJ = zztVar.zzau() == -1 ? 0 : zztVar.zzau();
        this.zzK = zztVar.zzav() != -1 ? zztVar.zzav() : 0;
        this.zzL = zztVar.zzaw();
        this.zzM = zztVar.zzax();
        if (zztVar.zzay() != 0 || zzqVarZzad == null) {
            this.zzN = zztVar.zzay();
        } else {
            this.zzN = 1;
        }
    }

    /* synthetic */ zzv(zzt zztVar, byte[] bArr) {
        this(zztVar);
    }

    public static String zze(zzv zzvVar) {
        String str;
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append(zzvVar.zza);
        sb.append(", mimeType=");
        sb.append(zzvVar.zzo);
        String str2 = zzvVar.zzn;
        if (str2 != null) {
            sb.append(", container=");
            sb.append(str2);
        }
        int i3 = zzvVar.zzj;
        if (i3 != -1) {
            sb.append(", bitrate=");
            sb.append(i3);
        }
        String str3 = zzvVar.zzk;
        if (str3 != null) {
            sb.append(", codecs=");
            sb.append(str3);
        }
        zzq zzqVar = zzvVar.zzs;
        if (zzqVar != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (int i4 = 0; i4 < zzqVar.zzb; i4++) {
                UUID uuid = zzqVar.zza(i4).zza;
                if (uuid.equals(zzg.zzb)) {
                    linkedHashSet.add(C.CENC_TYPE_cenc);
                } else if (uuid.equals(zzg.zzc)) {
                    linkedHashSet.add("clearkey");
                } else if (uuid.equals(zzg.zze)) {
                    linkedHashSet.add("playready");
                } else if (uuid.equals(zzg.zzd)) {
                    linkedHashSet.add("widevine");
                } else if (uuid.equals(zzg.zza)) {
                    linkedHashSet.add(GatewayException.GATEWAY_RESPONSE_DEPTH_UNIVERSAL);
                } else {
                    String string = uuid.toString();
                    StringBuilder sb2 = new StringBuilder(string.length() + 10);
                    sb2.append("unknown (");
                    sb2.append(string);
                    sb2.append(")");
                    linkedHashSet.add(sb2.toString());
                }
            }
            sb.append(", drm=[");
            zzglx.zzb(sb, linkedHashSet, ",");
            sb.append(AbstractJsonLexerKt.END_LIST);
        }
        int i5 = zzvVar.zzv;
        if (i5 != -1 && (i2 = zzvVar.zzw) != -1) {
            sb.append(", res=");
            sb.append(i5);
            sb.append("x");
            sb.append(i2);
        }
        int i6 = zzvVar.zzx;
        if (i6 != -1 && (i = zzvVar.zzy) != -1) {
            sb.append(", decRes=");
            sb.append(i6);
            sb.append("x");
            sb.append(i);
        }
        float f = zzvVar.zzB;
        int i7 = zzgsj.zza;
        double d = f;
        if (Math.copySign((-1.0d) + d, 1.0d) > 0.001d && d != 1.0d && (!Double.isNaN(d) || !Double.isNaN(1.0d))) {
            sb.append(", par=");
            Object[] objArr = {Float.valueOf(f)};
            String str4 = zzep.zza;
            sb.append(String.format(Locale.US, "%.3f", objArr));
        }
        zzi zziVar = zzvVar.zzE;
        if (zziVar != null && (zziVar.zze() || zziVar.zzf())) {
            sb.append(", color=");
            sb.append(zziVar.zzg());
        }
        float f2 = zzvVar.zzz;
        if (f2 != -1.0f) {
            sb.append(", fps=");
            sb.append(f2);
        }
        int i8 = zzvVar.zzF;
        if (i8 != -1) {
            sb.append(", maxSubLayers=");
            sb.append(i8);
        }
        int i9 = zzvVar.zzG;
        if (i9 != -1) {
            sb.append(", channels=");
            sb.append(i9);
        }
        int i10 = zzvVar.zzH;
        if (i10 != -1) {
            sb.append(", sample_rate=");
            sb.append(i10);
        }
        String str5 = zzvVar.zzd;
        if (str5 != null) {
            sb.append(", language=");
            sb.append(str5);
        }
        List list = zzvVar.zzc;
        if (!list.isEmpty()) {
            sb.append(", labels=[");
            zzglx.zzb(sb, zzgqe.zzc(list, zzu.zza), ",");
            sb.append("]");
        }
        int i11 = zzvVar.zze;
        if (i11 != 0) {
            sb.append(", selectionFlags=[");
            String str6 = zzep.zza;
            ArrayList arrayList = new ArrayList();
            if ((i11 & 1) != 0) {
                arrayList.add("default");
            }
            if ((i11 & 2) != 0) {
                arrayList.add("forced");
            }
            zzglx.zzb(sb, arrayList, ",");
            sb.append("]");
        }
        int i12 = zzvVar.zzf;
        if (i12 != 0) {
            sb.append(", roleFlags=[");
            int i13 = i12 & 32768;
            String str7 = zzep.zza;
            ArrayList arrayList2 = new ArrayList();
            if ((i12 & 1) != 0) {
                arrayList2.add("main");
            }
            if ((i12 & 2) != 0) {
                arrayList2.add("alt");
            }
            if ((i12 & 4) != 0) {
                arrayList2.add("supplementary");
            }
            if ((i12 & 8) != 0) {
                arrayList2.add("commentary");
            }
            if ((i12 & 16) != 0) {
                arrayList2.add("dub");
            }
            if ((i12 & 32) != 0) {
                arrayList2.add("emergency");
            }
            if ((i12 & 64) != 0) {
                arrayList2.add(ShareConstants.FEED_CAPTION_PARAM);
            }
            if ((i12 & 128) != 0) {
                arrayList2.add("subtitle");
            }
            if ((i12 & 256) != 0) {
                arrayList2.add("sign");
            }
            if ((i12 & 512) != 0) {
                arrayList2.add("describes-video");
            }
            if ((i12 & 1024) != 0) {
                arrayList2.add("describes-music");
            }
            if ((i12 & 2048) != 0) {
                arrayList2.add("enhanced-intelligibility");
            }
            if ((i12 & 4096) != 0) {
                arrayList2.add("transcribes-dialog");
            }
            if ((i12 & 8192) != 0) {
                arrayList2.add("easy-read");
            }
            if ((i12 & 16384) != 0) {
                arrayList2.add("trick-play");
            }
            if (i13 != 0) {
                arrayList2.add("auxiliary");
            }
            zzglx.zzb(sb, arrayList2, ",");
            sb.append("]");
        }
        if ((i12 & 32768) != 0) {
            sb.append(", auxiliaryTrackType=");
            int i14 = zzvVar.zzg;
            String str8 = zzep.zza;
            if (i14 == 0) {
                str = AdError.UNDEFINED_DOMAIN;
            } else if (i14 == 1) {
                str = "original";
            } else if (i14 == 2) {
                str = "depth-linear";
            } else if (i14 == 3) {
                str = "depth-inverse";
            } else {
                if (i14 != 4) {
                    throw new IllegalStateException("Unsupported auxiliary track type");
                }
                str = "depth metadata";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzv zzvVar = (zzv) obj;
            int i2 = this.zzP;
            if ((i2 == 0 || (i = zzvVar.zzP) == 0 || i2 == i) && this.zze == zzvVar.zze && this.zzf == zzvVar.zzf && this.zzg == zzvVar.zzg && this.zzh == zzvVar.zzh && this.zzi == zzvVar.zzi && this.zzp == zzvVar.zzp && this.zzt == zzvVar.zzt && this.zzv == zzvVar.zzv && this.zzw == zzvVar.zzw && this.zzx == zzvVar.zzx && this.zzy == zzvVar.zzy && this.zzA == zzvVar.zzA && this.zzD == zzvVar.zzD && this.zzF == zzvVar.zzF && this.zzG == zzvVar.zzG && this.zzH == zzvVar.zzH && this.zzI == zzvVar.zzI && this.zzJ == zzvVar.zzJ && this.zzK == zzvVar.zzK && this.zzL == zzvVar.zzL && this.zzN == zzvVar.zzN && Float.compare(this.zzz, zzvVar.zzz) == 0 && Float.compare(this.zzB, zzvVar.zzB) == 0 && Objects.equals(this.zza, zzvVar.zza) && Objects.equals(this.zzb, zzvVar.zzb) && this.zzc.equals(zzvVar.zzc) && Objects.equals(this.zzk, zzvVar.zzk) && Objects.equals(this.zzn, zzvVar.zzn) && Objects.equals(this.zzo, zzvVar.zzo) && Objects.equals(this.zzd, zzvVar.zzd) && Arrays.equals(this.zzC, zzvVar.zzC) && Objects.equals(this.zzl, zzvVar.zzl) && Objects.equals(this.zzE, zzvVar.zzE) && Objects.equals(this.zzs, zzvVar.zzs) && zzd(zzvVar)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzE);
        String str = this.zza;
        int length = String.valueOf(str).length();
        String str2 = this.zzb;
        int length2 = String.valueOf(str2).length();
        String str3 = this.zzn;
        int length3 = String.valueOf(str3).length();
        String str4 = this.zzo;
        int length4 = String.valueOf(str4).length();
        String str5 = this.zzk;
        int length5 = String.valueOf(str5).length();
        int i = this.zzj;
        int length6 = String.valueOf(i).length();
        String str6 = this.zzd;
        int length7 = String.valueOf(str6).length();
        int i2 = this.zzv;
        int length8 = String.valueOf(i2).length();
        int i3 = this.zzw;
        int length9 = String.valueOf(i3).length();
        float f = this.zzz;
        int length10 = String.valueOf(f).length();
        int length11 = String.valueOf(strValueOf).length();
        int i4 = this.zzG;
        int length12 = String.valueOf(i4).length();
        int i5 = this.zzH;
        StringBuilder sb = new StringBuilder(length + 9 + length2 + 2 + length3 + 2 + length4 + 2 + length5 + 2 + length6 + 2 + length7 + 3 + length8 + 2 + length9 + 2 + length10 + 2 + length11 + 4 + length12 + 2 + String.valueOf(i5).length() + 2);
        sb.append("Format(");
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(str4);
        sb.append(", ");
        sb.append(str5);
        sb.append(", ");
        sb.append(i);
        sb.append(", ");
        sb.append(str6);
        sb.append(", [");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(f);
        sb.append(", ");
        sb.append(strValueOf);
        sb.append("], [");
        sb.append(i4);
        sb.append(", ");
        sb.append(i5);
        sb.append("])");
        return sb.toString();
    }

    public final zzt zza() {
        return new zzt(this, null);
    }

    public final zzv zzb(int i) {
        zzt zztVar = new zzt(this, null);
        zztVar.zzL(i);
        return new zzv(zztVar);
    }

    public final int zzc() {
        int i;
        int i2 = this.zzv;
        if (i2 == -1 || (i = this.zzw) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public final boolean zzd(zzv zzvVar) {
        List list = this.zzr;
        int size = list.size();
        List list2 = zzvVar.zzr;
        if (size != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals((byte[]) list.get(i), (byte[]) list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = this.zzP;
        if (i != 0) {
            return i;
        }
        String str = this.zza;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.zzb;
        int iHashCode2 = ((((iHashCode + 527) * 31) + (str2 == null ? 0 : str2.hashCode())) * 31) + this.zzc.hashCode();
        String str3 = this.zzd;
        int iHashCode3 = ((((((((((((iHashCode2 * 31) + (str3 == null ? 0 : str3.hashCode())) * 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31) + this.zzh) * 31) + this.zzi) * 31;
        String str4 = this.zzk;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        zzap zzapVar = this.zzl;
        int iHashCode5 = iHashCode4 + (zzapVar == null ? 0 : zzapVar.hashCode());
        String str5 = this.zzn;
        int iHashCode6 = ((iHashCode5 * 961) + (str5 == null ? 0 : str5.hashCode())) * 31;
        int iHashCode7 = ((((((((((((((((((((((((((((((((((((((((iHashCode6 + (this.zzo != null ? r2.hashCode() : 0)) * 31) + this.zzp) * 31) + ((int) this.zzt)) * 31) + this.zzv) * 31) + this.zzw) * 31) + this.zzx) * 31) + this.zzy) * 31) + Float.floatToIntBits(this.zzz)) * 31) + this.zzA) * 31) + Float.floatToIntBits(this.zzB)) * 31) + this.zzD) * 31) + this.zzF) * 31) + this.zzG) * 31) + this.zzH) * 31) + this.zzI) * 31) + this.zzJ) * 31) + this.zzK) * 31) + this.zzL) * 31) - 1) * 31) - 1) * 31) + this.zzN;
        this.zzP = iHashCode7;
        return iHashCode7;
    }
}
