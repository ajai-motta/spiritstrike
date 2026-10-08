package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public enum zzago implements zzach {
    UNKNOWN(0),
    SUCCESS(1),
    FAILURE(2),
    CANCEL(3);

    private static final zzaci zze = new zzaci() { // from class: com.google.android.gms.internal.gtm.zzagn
        @Override // com.google.android.gms.internal.gtm.zzaci
        public final /* synthetic */ zzach zza(int i) {
            if (i == 0) {
                return zzago.UNKNOWN;
            }
            if (i == 1) {
                return zzago.SUCCESS;
            }
            if (i == 2) {
                return zzago.FAILURE;
            }
            if (i != 3) {
                return null;
            }
            return zzago.CANCEL;
        }
    };
    private final int zzg;

    zzago(int i) {
        this.zzg = i;
    }

    public static zzaci zzb() {
        return zze;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzg);
    }

    @Override // com.google.android.gms.internal.gtm.zzach
    public final int zza() {
        return this.zzg;
    }
}
