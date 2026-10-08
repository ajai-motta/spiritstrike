package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public enum zzahl implements zzach {
    TOMBSTONE_UNSPECIFIED(0),
    TOMBSTONE_RETAIN(1),
    TOMBSTONE_DROP(2);

    private static final zzaci zzd = new zzaci() { // from class: com.google.android.gms.internal.gtm.zzahk
        @Override // com.google.android.gms.internal.gtm.zzaci
        public final /* synthetic */ zzach zza(int i) {
            if (i == 0) {
                return zzahl.TOMBSTONE_UNSPECIFIED;
            }
            if (i == 1) {
                return zzahl.TOMBSTONE_RETAIN;
            }
            if (i != 2) {
                return null;
            }
            return zzahl.TOMBSTONE_DROP;
        }
    };
    private final int zzf;

    zzahl(int i) {
        this.zzf = i;
    }

    public static zzaci zzb() {
        return zzd;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzf);
    }

    @Override // com.google.android.gms.internal.gtm.zzach
    public final int zza() {
        return this.zzf;
    }
}
