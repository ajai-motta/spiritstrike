package com.google.android.gms.tagmanager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfo extends Number implements Comparable {
    private double zza;
    private long zzb;
    private final boolean zzc = false;

    private zzfo(double d) {
        this.zza = d;
    }

    public static zzfo zzc(Double d) {
        return new zzfo(d.doubleValue());
    }

    public static zzfo zzd(long j) {
        return new zzfo(j);
    }

    public static zzfo zze(String str) throws NumberFormatException {
        try {
            try {
                return new zzfo(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                return new zzfo(Double.parseDouble(str));
            }
        } catch (NumberFormatException unused2) {
            throw new NumberFormatException(String.valueOf(str).concat(" is not a valid TypedNumber"));
        }
    }

    @Override // java.lang.Number
    public final byte byteValue() {
        return (byte) zzb();
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return this.zzc ? this.zzb : this.zza;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzfo) && compareTo((zzfo) obj) == 0;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return (float) doubleValue();
    }

    public final int hashCode() {
        long jZzb = zzb();
        return (int) (jZzb ^ (jZzb >>> 32));
    }

    @Override // java.lang.Number
    public final int intValue() {
        return (int) zzb();
    }

    @Override // java.lang.Number
    public final long longValue() {
        return zzb();
    }

    @Override // java.lang.Number
    public final short shortValue() {
        return (short) zzb();
    }

    public final String toString() {
        return this.zzc ? Long.toString(this.zzb) : Double.toString(this.zza);
    }

    public final long zzb() {
        return this.zzc ? this.zzb : (long) this.zza;
    }

    public final boolean zzf() {
        return !this.zzc;
    }

    public final boolean zzg() {
        return this.zzc;
    }

    private zzfo(long j) {
        this.zzb = j;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzfo zzfoVar) {
        return (this.zzc && zzfoVar.zzc) ? Long.compare(this.zzb, zzfoVar.zzb) : Double.compare(doubleValue(), zzfoVar.doubleValue());
    }
}
