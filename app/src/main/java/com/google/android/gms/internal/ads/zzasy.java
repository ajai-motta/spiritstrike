package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzasy implements Comparator {
    private final boolean zza;

    public zzasy(boolean z) {
        this.zza = z;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Comparator comparatorZza;
        Object objZzn;
        Object objZzn2;
        int[] iArr = {446703183, 1862618146, 1081639777, -1087935358, -803036955, 1104011716, 5522510, 2017461929, 496612959};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6);
        int i10 = i8 % 496612959;
        zzatc zzatcVar = (zzatc) obj;
        zzatc zzatcVar2 = (zzatc) obj2;
        int i11 = zzatcVar.zza;
        if (i11 != zzatcVar2.zza) {
            throw new IllegalArgumentException();
        }
        int i12 = i10 ^ i9;
        try {
            if (i11 == 0) {
                throw null;
            }
            switch (i11 + i12) {
                case 0:
                default:
                    return 0;
                case 1:
                    if (!this.zza) {
                        throw new IllegalArgumentException();
                    }
                    if (zzatcVar.zzl() == zzatcVar2.zzl()) {
                        return 0;
                    }
                case 2:
                    return Long.compare(zzatcVar.zzm(), zzatcVar2.zzm());
                case 3:
                    comparatorZza = zzasg.zzc;
                    objZzn = zzatcVar.zzn();
                    objZzn2 = zzatcVar2.zzn();
                    return comparatorZza.compare(objZzn, objZzn2);
                case 4:
                    objZzn = zzatcVar.zzo();
                    objZzn2 = zzatcVar2.zzo();
                    comparatorZza = zzgoq.zza(this);
                    return comparatorZza.compare(objZzn, objZzn2);
                case 5:
                    if (this.zza) {
                        return zzatcVar.zzp() != zzatcVar2.zzp() ? 1 : 0;
                    }
                    throw new IllegalArgumentException();
                case 6:
                    return Double.compare(zzatcVar.zzq(), zzatcVar2.zzq());
            }
        } catch (zzasz e) {
            throw new AssertionError(zzase.zza("CEiv6BFfPnitUE+D"), e);
        }
    }
}
