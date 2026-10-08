package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public enum zzsk implements zzach {
    INT52(0),
    NUMBER(1),
    STRING(2);

    private static final zzaci zzd = new zzaci() { // from class: com.google.android.gms.internal.gtm.zzsj
        @Override // com.google.android.gms.internal.gtm.zzaci
        public final /* synthetic */ zzach zza(int i) {
            if (i == 0) {
                return zzsk.INT52;
            }
            if (i == 1) {
                return zzsk.NUMBER;
            }
            if (i != 2) {
                return null;
            }
            return zzsk.STRING;
        }
    };
    private final int zzf;

    zzsk(int i) {
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
