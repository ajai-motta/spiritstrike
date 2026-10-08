package com.google.android.gms.internal.ads;

import java.math.BigDecimal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhdu extends Number {
    private final String zza;

    public zzhdu(String str) {
        this.zza = str;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.zza);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzhdu) {
            return this.zza.equals(((zzhdu) obj).zza);
        }
        return false;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        try {
            try {
                return Integer.parseInt(this.zza);
            } catch (NumberFormatException unused) {
                return new BigDecimal(this.zza).intValue();
            }
        } catch (NumberFormatException unused2) {
            return (int) Long.parseLong(this.zza);
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        try {
            return Long.parseLong(this.zza);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.zza).longValue();
        }
    }

    public final String toString() {
        return this.zza;
    }
}
