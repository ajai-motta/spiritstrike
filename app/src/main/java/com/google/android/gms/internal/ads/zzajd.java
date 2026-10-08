package com.google.android.gms.internal.ads;

import io.ktor.util.date.GMTDateParser;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzajd {
    private static final zzgms zza = zzgms.zza(zzglr.zzc(AbstractJsonLexerKt.COLON));
    private static final zzgms zzb = zzgms.zza(zzglr.zzc(GMTDateParser.ANY));
    private final List zzc = new ArrayList();
    private int zzd = 0;
    private int zze;

    public final void zza() {
        this.zzc.clear();
        this.zzd = 0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int zzb(zzadb zzadbVar, zzaea zzaeaVar, List list) throws IOException {
        int i;
        byte b;
        char c;
        int i2 = this.zzd;
        if (i2 == 0) {
            long jZzo = zzadbVar.zzo();
            zzaeaVar.zza = (jZzo == -1 || jZzo < 8) ? 0L : jZzo - 8;
            this.zzd = 1;
            return 1;
        }
        int i3 = 2;
        if (i2 != 1) {
            char c2 = 2819;
            short s = 2817;
            short s2 = 2816;
            short s3 = 2192;
            if (i2 != 2) {
                long jZzn = zzadbVar.zzn();
                int iZzo = (int) ((zzadbVar.zzo() - zzadbVar.zzn()) - ((long) this.zze));
                zzeg zzegVar = new zzeg(iZzo);
                zzadbVar.zzc(zzegVar.zzi(), 0, iZzo);
                int i4 = 0;
                while (true) {
                    List list2 = this.zzc;
                    if (i4 >= list2.size()) {
                        zzaeaVar.zza = 0L;
                        return 1;
                    }
                    zzajc zzajcVar = (zzajc) list2.get(i4);
                    zzegVar.zzh((int) (zzajcVar.zza - jZzn));
                    zzegVar.zzk(4);
                    int iZzC = zzegVar.zzC();
                    String strZzK = zzegVar.zzK(iZzC, StandardCharsets.UTF_8);
                    switch (strZzK.hashCode()) {
                        case -1711564334:
                            b = strZzK.equals("SlowMotion_Data") ? (byte) 0 : (byte) -1;
                            break;
                        case -1332107749:
                            b = strZzK.equals("Super_SlowMotion_Edit_Data") ? (byte) 3 : (byte) -1;
                            break;
                        case -1251387154:
                            b = strZzK.equals("Super_SlowMotion_Data") ? (byte) 1 : (byte) -1;
                            break;
                        case -830665521:
                            b = strZzK.equals("Super_SlowMotion_Deflickering_On") ? (byte) 4 : (byte) -1;
                            break;
                        case 1760745220:
                            b = strZzK.equals("Super_SlowMotion_BGM") ? (byte) 2 : (byte) -1;
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    if (b == 0) {
                        c = 2192;
                    } else if (b == 1) {
                        c = 2816;
                    } else if (b == 2) {
                        c = 2817;
                    } else if (b == 3) {
                        c = c2;
                    } else {
                        if (b != 4) {
                            throw zzat.zzb("Invalid SEF name", null);
                        }
                        c = 2820;
                    }
                    int i5 = zzajcVar.zzb - (iZzC + 8);
                    if (c == 2192) {
                        ArrayList arrayList = new ArrayList();
                        List listZze = zzb.zze(zzegVar.zzK(i5, StandardCharsets.UTF_8));
                        for (int i6 = 0; i6 < listZze.size(); i6++) {
                            List listZze2 = zza.zze((CharSequence) listZze.get(i6));
                            if (listZze2.size() != 3) {
                                throw zzat.zzb(null, null);
                            }
                            try {
                                arrayList.add(new zzagy(Long.parseLong((String) listZze2.get(0)), Long.parseLong((String) listZze2.get(1)), 1 << (Integer.parseInt((String) listZze2.get(2)) - 1)));
                            } catch (NumberFormatException e) {
                                throw zzat.zzb(null, e);
                            }
                        }
                        list.add(new zzagz(arrayList));
                    } else if (c != 2816 && c != 2817 && c != c2 && c != 2820) {
                        throw new IllegalStateException();
                    }
                    i4++;
                    c2 = 2819;
                }
            } else {
                long jZzo2 = zzadbVar.zzo();
                int i7 = this.zze - 20;
                zzeg zzegVar2 = new zzeg(i7);
                zzadbVar.zzc(zzegVar2.zzi(), 0, i7);
                int i8 = 0;
                while (i8 < i7 / 12) {
                    zzegVar2.zzk(i3);
                    short sZzw = zzegVar2.zzw();
                    if (sZzw == s3 || sZzw == s2 || sZzw == s || sZzw == 2819 || sZzw == 2820) {
                        i = i7;
                        this.zzc.add(new zzajc(sZzw, (jZzo2 - ((long) this.zze)) - ((long) zzegVar2.zzC()), zzegVar2.zzC()));
                    } else {
                        zzegVar2.zzk(8);
                        i = i7;
                    }
                    i8++;
                    i7 = i;
                    i3 = 2;
                    s = 2817;
                    s2 = 2816;
                    s3 = 2192;
                }
                List list3 = this.zzc;
                if (list3.isEmpty()) {
                    zzaeaVar.zza = 0L;
                } else {
                    this.zzd = 3;
                    zzaeaVar.zza = ((zzajc) list3.get(0)).zza;
                }
            }
        } else {
            zzeg zzegVar3 = new zzeg(8);
            zzadbVar.zzc(zzegVar3.zzi(), 0, 8);
            this.zze = zzegVar3.zzC() + 8;
            if (zzegVar3.zzB() != 1397048916) {
                zzaeaVar.zza = 0L;
            } else {
                zzaeaVar.zza = zzadbVar.zzn() - ((long) (this.zze - 12));
                this.zzd = 2;
            }
        }
        return 1;
    }
}
