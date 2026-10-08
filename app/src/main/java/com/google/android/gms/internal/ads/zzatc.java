package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzatc {
    public int zza = 1;
    private Object zzb;
    private long zzc;
    private double zzd;
    private zzasg zze;
    private List zzf;
    private zzasu zzg;

    private zzatc() {
    }

    public static zzatc zza(Object obj) {
        zzatc zzatcVar = new zzatc();
        int[] iArr = {572660336, 1963204074, 810270723, 1168973800, 12304897, -1027511958, 1433925857, 2084420925, 1937477084};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6);
        zzatcVar.zzr();
        zzatcVar.zza = (i8 % 1937477084) ^ i9;
        zzatcVar.zzb = obj;
        return zzatcVar;
    }

    public static zzatc zzb(long j) {
        zzatc zzatcVar = new zzatc();
        int[] iArr = {269455306, 1628467785, 508432336, 1769894153, 149815616, -1737813993, 468055906, 524872353, 327254586};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6);
        zzatcVar.zzr();
        zzatcVar.zza = (i8 % 327254586) ^ i9;
        zzatcVar.zzc = j;
        return zzatcVar;
    }

    public static zzatc zzc(double d) {
        zzatc zzatcVar = new zzatc();
        int[] iArr = {76065818, 1629326670, 912768099, 1092092300, 784816880, -1349977414, 434065736, 1884661237, 1605908235};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6);
        zzatcVar.zzr();
        zzatcVar.zza = (i8 % 1605908235) ^ i9;
        zzatcVar.zzd = d;
        return zzatcVar;
    }

    public static zzatc zzd(zzasg zzasgVar) {
        zzatc zzatcVar = new zzatc();
        int[] iArr = {1143408282, 544368152, 1884037077, 79323401, 1472762119, -801477845, 201305624, 1470503465, 1402586708};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6);
        zzatcVar.zzr();
        zzatcVar.zza = (i8 % 1402586708) ^ i9;
        zzatcVar.zze = zzasgVar;
        return zzatcVar;
    }

    public static zzatc zze(List list) {
        zzatc zzatcVar = new zzatc();
        int[] iArr = {231602422, 370241669, 619070592, 319896591, 694865338, 1425770340, 39950860, 555996658, 324763920};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6);
        zzatcVar.zzr();
        zzatcVar.zza = (i8 % 324763920) ^ i9;
        zzatcVar.zzf = list;
        return zzatcVar;
    }

    public static zzatc zzf(zzasu zzasuVar) {
        zzatc zzatcVar = new zzatc();
        int[] iArr = {1315209188, 67133601, 1612794668, 612376713, 2023183116, -774012042, 5007439, 661761152, 474613996};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6);
        zzatcVar.zzr();
        zzatcVar.zza = (i8 % 474613996) ^ i9;
        zzatcVar.zzg = zzasuVar;
        return zzatcVar;
    }

    public static zzatc zzg(Object obj) {
        if (obj instanceof Long) {
            return zzb(((Long) obj).longValue());
        }
        if (obj instanceof Boolean) {
            return zzb(true != ((Boolean) obj).booleanValue() ? 0L : 1L);
        }
        if (obj instanceof Integer) {
            return zzb(((Integer) obj).intValue());
        }
        if (obj instanceof Double) {
            return zzc(((Double) obj).doubleValue());
        }
        if (obj instanceof Float) {
            return zzc(((Float) obj).floatValue());
        }
        if (obj instanceof Short) {
            return zzb(((Short) obj).shortValue());
        }
        if (obj instanceof Byte) {
            return zzb(((Byte) obj).byteValue());
        }
        if (obj instanceof zzasg) {
            return zzd((zzasg) obj);
        }
        if (obj instanceof String) {
            return zzd(zzasg.zzf((String) obj));
        }
        if (!(obj instanceof ArrayList)) {
            return zza(obj);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) obj;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(zzg(arrayList2.get(i)));
        }
        return zze(arrayList);
    }

    public static zzatc zzj(zzatc zzatcVar) {
        int[] iArr = {1154349542, 1365661854, 772762753, -35647458, -1399059520, 905919471, 65677639, 1759726503, 552812661};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6);
        int i10 = i8 % 552812661;
        try {
            int i11 = zzatcVar.zza;
            int i12 = (i10 ^ i9) + i11;
            if (i11 == 0) {
                throw null;
            }
            switch (i12) {
                case 0:
                    return new zzatc();
                case 1:
                    return zza(zzatcVar.zzl());
                case 2:
                    return zzb(zzatcVar.zzm());
                case 3:
                    return zzd(zzatcVar.zzn());
                case 4:
                    ArrayList arrayList = new ArrayList();
                    Iterator it = zzatcVar.zzo().iterator();
                    while (it.hasNext()) {
                        arrayList.add(zzj((zzatc) it.next()));
                    }
                    return zze(arrayList);
                case 5:
                    return zzf(zzatcVar.zzp());
                case 6:
                    return zzc(zzatcVar.zzq());
                default:
                    throw new AssertionError(zzase.zza("HkezqgQcPni/TE/NwjgYPC5H6Q2JRdEp275wOg=="));
            }
        } catch (zzasz e) {
            throw new AssertionError(zzase.zza("CEiv6BFfPnitUE+D"), e);
        }
    }

    private final void zzr() {
        this.zza = 1;
        this.zzc = 0L;
        this.zzb = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = null;
    }

    private final void zzs(int i) throws zzasz {
        if (i != this.zza) {
            throw new zzasz();
        }
    }

    public final Object zzh() throws zzasz {
        int[] iArr = {172154289, 1050326876, 843682288, -858640882, -228026365, 881347074, 13857144, 514820752, 473891334};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6);
        int i10 = this.zza;
        int i11 = ((i8 % 473891334) ^ i9) + i10;
        if (i10 == 0) {
            throw null;
        }
        switch (i11) {
            case 0:
            case 5:
                throw new zzasz();
            case 1:
                return zzl();
            case 2:
                return Long.valueOf(zzm());
            case 3:
                return zzn().zza();
            case 4:
                ArrayList arrayList = new ArrayList();
                Iterator it = zzo().iterator();
                while (it.hasNext()) {
                    arrayList.add(((zzatc) it.next()).zzh());
                }
                return arrayList;
            case 6:
                return Double.valueOf(zzq());
            default:
                throw new AssertionError(zzase.zza("HkezqgQcPni/TE/NwjgYPC5H6Q2JRdEp275wOg=="));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:138:0x02a8, code lost:
    
        if (r20.equals(java.lang.Object.class) != false) goto L149;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzi(java.lang.Class r20) throws com.google.android.gms.internal.ads.zzasz {
        /*
            Method dump skipped, instruction units count: 792
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzatc.zzi(java.lang.Class):java.lang.Object");
    }

    public final void zzk(OutputStream outputStream) throws zzasz, IOException {
        long[] jArr = {1269833163, 1628598594, 308676977, 1629286434, 15633520, 3337700125L, 1402923307, 613197917, 297598514};
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        long j9 = j7 + (((((~j) & j2) | j3) + ((j & j4) | j5)) - j6);
        long j10 = j8 % 297598514;
        int[] iArr = {1959970879, 1489831444, 1998984087, -1446423480, -182037905, -2025383063, 91654737, 1544048623, 665228399};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        iArr[0] = 136416008;
        iArr[1] = 1315652152;
        iArr[2] = 568681609;
        iArr[3] = 1310591536;
        iArr[4] = 838183178;
        iArr[5] = -759809803;
        iArr[6] = 894617267;
        iArr[7] = 1414460396;
        iArr[8] = 78756298;
        int i9 = (((1315652152 & (~136416008)) | 568681609) + ((136416008 & 1310591536) | 838183178)) - (-1654427070);
        int i10 = 1414460396 % 78756298;
        iArr[0] = 1202640845;
        iArr[1] = 472047875;
        iArr[2] = 1135942642;
        iArr[3] = 1006822481;
        iArr[4] = 585369424;
        iArr[5] = -1988224507;
        iArr[6] = 353828929;
        iArr[7] = 1225708428;
        iArr[8] = 987359759;
        int i11 = (((472047875 & (~1202640845)) | 1135942642) + ((1202640845 & 1006822481) | 585369424)) - 1952913860;
        int i12 = 1225708428 % 987359759;
        int i13 = this.zza;
        int i14 = ((i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6)) ^ (i8 % 665228399)) + i13;
        if (i13 == 0) {
            throw null;
        }
        switch (i14) {
            case 0:
            case 1:
            case 5:
                throw new zzasz();
            case 2:
                zzasc.zzb(zzm(), new zzatb(outputStream, 1), true);
                return;
            case 3:
                byte[] bArr = zzn().zza;
                zzasc.zzb(((long) bArr.length) * (j9 ^ j10), new zzatb(outputStream, 0), true);
                outputStream.write(bArr);
                return;
            case 4:
                List listZzo = zzo();
                zzasc.zzb(listZzo.size(), new zzatb(outputStream, i11 ^ i12), true);
                Iterator it = listZzo.iterator();
                while (it.hasNext()) {
                    ((zzatc) it.next()).zzk(outputStream);
                }
                return;
            case 6:
                double dZzq = zzq();
                zzatb zzatbVar = new zzatb(outputStream, i9 ^ i10);
                iArr[0] = 1470558289;
                iArr[1] = 1721781326;
                iArr[2] = 2037102441;
                iArr[3] = 109139991;
                iArr[4] = 560281113;
                iArr[5] = -1312141122;
                iArr[6] = 663091009;
                iArr[7] = 1043353969;
                iArr[8] = 656635246;
                long jDoubleToRawLongBits = Double.doubleToRawLongBits(dZzq);
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate((((((~1470558289) & 1721781326) | 2037102441) + ((1470558289 & 109139991) | 560281113)) - (-1975232131)) ^ (1043353969 % 656635246));
                byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
                byteBufferAllocate.putLong(jDoubleToRawLongBits);
                for (byte b : byteBufferAllocate.array()) {
                    zzatbVar.zza(b);
                }
                int length = byteBufferAllocate.array().length;
                return;
            default:
                return;
        }
    }

    public final Object zzl() throws zzasz {
        int[] iArr = {427355115, 404248040, 1318670750, 874677346, 1819730563, -970011213, 126401947, 1858504292, 235745791};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        zzs((iArr[7] % 235745791) ^ (i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6)));
        return this.zzb;
    }

    public final long zzm() throws zzasz {
        int[] iArr = {1646478179, 763209928, 1529626135, 609321208, 1403807536, -1382063087, 25624641, 1388803074, 733327814};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        zzs((iArr[7] % 733327814) ^ (i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6)));
        return this.zzc;
    }

    public final zzasg zzn() throws zzasz {
        int[] iArr = {2059344234, 1917530355, 739411611, 1399403104, 95815174, 2094390031, 51245830, 1312994984, 1140384172};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        zzs((iArr[7] % 1140384172) ^ (i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6)));
        return this.zze;
    }

    public final List zzo() throws zzasz {
        int[] iArr = {1435218189, 1093276829, 949583962, 1092752517, 575966040, -2054938211, 262178224, 1891252715, 1250801052};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        zzs((iArr[7] % 1250801052) ^ (i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6)));
        return this.zzf;
    }

    public final zzasu zzp() throws zzasz {
        int[] iArr = {672139932, 1821026951, 1629321417, 214090246, 828986457, -1439766056, 580508860, 1579068977, 395191309};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        zzs((iArr[7] % 395191309) ^ (i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6)));
        return this.zzg;
    }

    public final double zzq() throws zzasz {
        int[] iArr = {1714636915, 1758565445, 174653454, 1653642817, 38095532, -1976041400, 596516649, 1804289383, 846930886};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        zzs((iArr[7] % 846930886) ^ (i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6)));
        return this.zzd;
    }
}
