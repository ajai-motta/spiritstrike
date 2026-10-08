package com.google.android.gms.internal.ads;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzagv extends zzagq {
    public final String zza;
    public final zzgpe zzb;

    public zzagv(String str, String str2, List list) {
        super(str);
        zzgmd.zza(!list.isEmpty());
        this.zza = str2;
        zzgpe zzgpeVarZzq = zzgpe.zzq(list);
        this.zzb = zzgpeVarZzq;
    }

    private static List zzb(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
            } else if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzagv zzagvVar = (zzagv) obj;
            if (Objects.equals(this.zzf, zzagvVar.zzf) && Objects.equals(this.zza, zzagvVar.zza) && this.zzb.equals(zzagvVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzf.hashCode() + 527;
        String str = this.zza;
        return (((iHashCode * 31) + (str != null ? str.hashCode() : 0)) * 31) + this.zzb.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzagq
    public final String toString() {
        String strValueOf = String.valueOf(this.zzb);
        String str = this.zzf;
        int length = String.valueOf(str).length();
        String str2 = this.zza;
        StringBuilder sb = new StringBuilder(length + 14 + String.valueOf(str2).length() + 9 + String.valueOf(strValueOf).length());
        sb.append(str);
        sb.append(": description=");
        sb.append(str2);
        sb.append(": values=");
        sb.append(strValueOf);
        return sb.toString();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.gms.internal.ads.zzagq, com.google.android.gms.internal.ads.zzao
    public final void zza(zzam zzamVar) {
        byte b;
        String str = this.zzf;
        switch (str.hashCode()) {
            case 82815:
                b = !str.equals("TAL") ? (byte) -1 : (byte) 6;
                break;
            case 82878:
                b = !str.equals("TCM") ? (byte) -1 : Ascii.DLE;
                break;
            case 82897:
                b = !str.equals("TDA") ? (byte) -1 : Ascii.FF;
                break;
            case 83253:
                b = !str.equals("TP1") ? (byte) -1 : (byte) 2;
                break;
            case 83254:
                b = !str.equals("TP2") ? (byte) -1 : (byte) 4;
                break;
            case 83255:
                b = !str.equals("TP3") ? (byte) -1 : Ascii.DC2;
                break;
            case 83341:
                b = !str.equals("TRK") ? (byte) -1 : (byte) 8;
                break;
            case 83378:
                b = !str.equals("TT2") ? (byte) -1 : (byte) 0;
                break;
            case 83536:
                b = !str.equals("TXT") ? (byte) -1 : Ascii.DC4;
                break;
            case 83552:
                b = !str.equals("TYE") ? (byte) -1 : (byte) 10;
                break;
            case 2567331:
                b = !str.equals("TALB") ? (byte) -1 : (byte) 7;
                break;
            case 2569357:
                b = !str.equals("TCOM") ? (byte) -1 : (byte) 17;
                break;
            case 2569358:
                b = !str.equals("TCON") ? (byte) -1 : Ascii.SYN;
                break;
            case 2569891:
                b = !str.equals("TDAT") ? (byte) -1 : Ascii.CR;
                break;
            case 2570401:
                b = !str.equals("TDRC") ? (byte) -1 : Ascii.SO;
                break;
            case 2570410:
                b = !str.equals("TDRL") ? (byte) -1 : Ascii.SI;
                break;
            case 2571565:
                b = !str.equals("TEXT") ? (byte) -1 : Ascii.NAK;
                break;
            case 2575251:
                b = !str.equals("TIT2") ? (byte) -1 : (byte) 1;
                break;
            case 2581512:
                b = !str.equals("TPE1") ? (byte) -1 : (byte) 3;
                break;
            case 2581513:
                b = !str.equals("TPE2") ? (byte) -1 : (byte) 5;
                break;
            case 2581514:
                b = !str.equals("TPE3") ? (byte) -1 : (byte) 19;
                break;
            case 2583398:
                b = !str.equals("TRCK") ? (byte) -1 : (byte) 9;
                break;
            case 2590194:
                b = !str.equals("TYER") ? (byte) -1 : Ascii.VT;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
            case 1:
                zzamVar.zza((CharSequence) this.zzb.get(0));
                break;
            case 2:
            case 3:
                zzamVar.zzb((CharSequence) this.zzb.get(0));
                break;
            case 4:
            case 5:
                zzamVar.zzd((CharSequence) this.zzb.get(0));
                break;
            case 6:
            case 7:
                zzamVar.zzc((CharSequence) this.zzb.get(0));
                break;
            case 8:
            case 9:
                String str2 = (String) this.zzb.get(0);
                String str3 = zzep.zza;
                String[] strArrSplit = str2.split(DomExceptionUtils.SEPARATOR, -1);
                try {
                    int i = Integer.parseInt(strArrSplit[0]);
                    Integer numValueOf = strArrSplit.length > 1 ? Integer.valueOf(Integer.parseInt(strArrSplit[1])) : null;
                    zzamVar.zzg(Integer.valueOf(i));
                    zzamVar.zzh(numValueOf);
                } catch (NumberFormatException unused) {
                    return;
                }
                break;
            case 10:
            case 11:
                try {
                    zzamVar.zzi(Integer.valueOf(Integer.parseInt((String) this.zzb.get(0))));
                } catch (NumberFormatException unused2) {
                    return;
                }
                break;
            case 12:
            case 13:
                try {
                    String str4 = (String) this.zzb.get(0);
                    int i2 = Integer.parseInt(str4.substring(2, 4));
                    int i3 = Integer.parseInt(str4.substring(0, 2));
                    zzamVar.zzj(Integer.valueOf(i2));
                    zzamVar.zzk(Integer.valueOf(i3));
                } catch (NumberFormatException | StringIndexOutOfBoundsException unused3) {
                    return;
                }
                break;
            case 14:
                List listZzb = zzb((String) this.zzb.get(0));
                int size = listZzb.size();
                if (size != 1) {
                    if (size != 2) {
                        if (size == 3) {
                            zzamVar.zzk((Integer) listZzb.get(2));
                        }
                    }
                    zzamVar.zzj((Integer) listZzb.get(1));
                }
                zzamVar.zzi((Integer) listZzb.get(0));
                break;
            case 15:
                List listZzb2 = zzb((String) this.zzb.get(0));
                int size2 = listZzb2.size();
                if (size2 != 1) {
                    if (size2 != 2) {
                        if (size2 == 3) {
                            zzamVar.zzn((Integer) listZzb2.get(2));
                        }
                    }
                    zzamVar.zzm((Integer) listZzb2.get(1));
                }
                zzamVar.zzl((Integer) listZzb2.get(0));
                break;
            case 16:
            case 17:
                zzamVar.zzp((CharSequence) this.zzb.get(0));
                break;
            case 18:
            case 19:
                zzamVar.zzq((CharSequence) this.zzb.get(0));
                break;
            case 20:
            case 21:
                zzamVar.zzo((CharSequence) this.zzb.get(0));
                break;
            case 22:
                zzgpe zzgpeVar = this.zzb;
                Integer numZzh = zzgst.zzh((String) zzgpeVar.get(0), 10);
                if (numZzh != null) {
                    String strZza = zzagr.zza(numZzh.intValue());
                    if (strZza != null) {
                        zzamVar.zzt(strZza);
                    }
                } else {
                    zzamVar.zzt((CharSequence) zzgpeVar.get(0));
                }
                break;
        }
    }
}
