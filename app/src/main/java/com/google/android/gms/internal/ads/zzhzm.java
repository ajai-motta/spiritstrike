package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhzm extends zzhzl {
    zzhzm() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if (r13[r14] <= (-65)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0047, code lost:
    
        if (r13[r14] <= (-65)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0080, code lost:
    
        if (r13[r14] <= (-65)) goto L11;
     */
    @Override // com.google.android.gms.internal.ads.zzhzl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zza(int r12, byte[] r13, int r14, int r15) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhzm.zza(int, byte[], int, int):int");
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    final String zzb(byte[] bArr, int i, int i2) throws zzhxd {
        int i3;
        int length = bArr.length;
        if ((((length - i) - i2) | i | i2) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i4 = i + i2;
        char[] cArr = new char[i2];
        int i5 = 0;
        while (i < i4) {
            byte b = bArr[i];
            if (!zzhzk.zza(b)) {
                break;
            }
            i++;
            cArr[i5] = (char) b;
            i5++;
        }
        while (i < i4) {
            int i6 = i + 1;
            byte b2 = bArr[i];
            if (zzhzk.zza(b2)) {
                cArr[i5] = (char) b2;
                i5++;
                i = i6;
                while (i < i4) {
                    byte b3 = bArr[i];
                    if (zzhzk.zza(b3)) {
                        i++;
                        cArr[i5] = (char) b3;
                        i5++;
                    }
                }
            } else {
                if (zzhzk.zzb(b2)) {
                    if (i6 >= i4) {
                        throw new zzhxd("Protocol message had invalid UTF-8.");
                    }
                    i3 = i5 + 1;
                    i += 2;
                    zzhzk.zzd(b2, bArr[i6], cArr, i5);
                } else if (zzhzk.zzc(b2)) {
                    if (i6 >= i4 - 1) {
                        throw new zzhxd("Protocol message had invalid UTF-8.");
                    }
                    i3 = i5 + 1;
                    int i7 = i + 2;
                    i += 3;
                    zzhzk.zze(b2, bArr[i6], bArr[i7], cArr, i5);
                } else {
                    if (i6 >= i4 - 2) {
                        throw new zzhxd("Protocol message had invalid UTF-8.");
                    }
                    byte b4 = bArr[i6];
                    int i8 = i + 3;
                    byte b5 = bArr[i + 2];
                    i += 4;
                    zzhzk.zzf(b2, b4, b5, bArr[i8], cArr, i5);
                    i5 += 2;
                }
                i5 = i3;
            }
        }
        return new String(cArr, 0, i5);
    }
}
