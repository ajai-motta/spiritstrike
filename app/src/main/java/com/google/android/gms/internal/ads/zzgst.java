package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgst extends zzgsu {
    public static int zza(long j) {
        int i = (int) j;
        zzgmd.zze(((long) i) == j, "Out of range: %s", j);
        return i;
    }

    public static int zzb(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static int zzc(int i, int i2, int i3) {
        zzgmd.zzg(true, "min (%s) must be less than or equal to max (%s)", i2, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
        return Math.min(Math.max(i, i2), LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }

    public static int zzd(byte[] bArr) {
        int length = bArr.length;
        zzgmd.zzg(length >= 4, "array too small: %s < %s", length, 4);
        return zze(bArr[0], bArr[1], bArr[2], bArr[3]);
    }

    public static int zze(byte b, byte b2, byte b3, byte b4) {
        return (b << Ascii.CAN) | ((b2 & 255) << 16) | ((b3 & 255) << 8) | (b4 & 255);
    }

    public static int[] zzf(Collection collection) {
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            Object obj = array[i];
            obj.getClass();
            iArr[i] = ((Number) obj).intValue();
        }
        return iArr;
    }

    public static List zzg(int... iArr) {
        int length = iArr.length;
        return length == 0 ? Collections.emptyList() : new zzgss(iArr, 0, length);
    }

    static /* synthetic */ int zzi(int[] iArr, int i, int i2, int i3) {
        while (i2 < i3) {
            if (iArr[i2] == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Integer zzh(java.lang.String r11, int r12) {
        /*
            r11.getClass()
            r12 = r11
            java.lang.String r12 = (java.lang.String) r12
            boolean r12 = r11.isEmpty()
            r0 = 0
            if (r12 == 0) goto L10
        Ld:
            r11 = r0
            goto L72
        L10:
            r12 = 0
            char r1 = r11.charAt(r12)
            r2 = 45
            if (r1 != r2) goto L1a
            r12 = 1
        L1a:
            int r3 = r11.length()
            if (r12 != r3) goto L21
            goto Ld
        L21:
            int r3 = r12 + 1
            char r12 = r11.charAt(r12)
            int r12 = com.google.android.gms.internal.ads.zzgsv.zza(r12)
            if (r12 < 0) goto Ld
            r4 = 10
            if (r12 < r4) goto L32
            goto Ld
        L32:
            int r12 = -r12
            long r5 = (long) r12
        L34:
            int r12 = r11.length()
            r7 = -9223372036854775808
            if (r3 >= r12) goto L61
            int r12 = r3 + 1
            char r3 = r11.charAt(r3)
            int r3 = com.google.android.gms.internal.ads.zzgsv.zza(r3)
            if (r3 < 0) goto Ld
            if (r3 >= r4) goto Ld
            r9 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r9 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r9 >= 0) goto L54
            goto Ld
        L54:
            r9 = 10
            long r5 = r5 * r9
            long r9 = (long) r3
            long r7 = r7 + r9
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 >= 0) goto L5e
            goto Ld
        L5e:
            long r5 = r5 - r9
            r3 = r12
            goto L34
        L61:
            if (r1 != r2) goto L68
            java.lang.Long r11 = java.lang.Long.valueOf(r5)
            goto L72
        L68:
            int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r11 != 0) goto L6d
            goto Ld
        L6d:
            long r11 = -r5
            java.lang.Long r11 = java.lang.Long.valueOf(r11)
        L72:
            if (r11 == 0) goto L8b
            long r1 = r11.longValue()
            int r12 = r11.intValue()
            long r3 = (long) r12
            int r12 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r12 == 0) goto L82
            goto L8b
        L82:
            int r11 = r11.intValue()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            return r11
        L8b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgst.zzh(java.lang.String, int):java.lang.Integer");
    }
}
