package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzzk implements zzacj {
    static final zzacj zza = new zzzk();

    private zzzk() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacj
    public final boolean zza(int i) {
        zzzl zzzlVar;
        zzzl zzzlVar2 = zzzl.EDITION_UNKNOWN;
        if (i == 0) {
            zzzlVar = zzzl.EDITION_UNKNOWN;
        } else if (i == 1) {
            zzzlVar = zzzl.EDITION_1_TEST_ONLY;
        } else if (i == 2) {
            zzzlVar = zzzl.EDITION_2_TEST_ONLY;
        } else if (i == 900) {
            zzzlVar = zzzl.EDITION_LEGACY;
        } else if (i != Integer.MAX_VALUE) {
            switch (i) {
                case EDITION_PROTO2_VALUE:
                    zzzlVar = zzzl.EDITION_PROTO2;
                    break;
                case 999:
                    zzzlVar = zzzl.EDITION_PROTO3;
                    break;
                case 1000:
                    zzzlVar = zzzl.EDITION_2023;
                    break;
                case 1001:
                    zzzlVar = zzzl.EDITION_2024;
                    break;
                default:
                    switch (i) {
                        case EDITION_99997_TEST_ONLY_VALUE:
                            zzzlVar = zzzl.EDITION_99997_TEST_ONLY;
                            break;
                        case EDITION_99998_TEST_ONLY_VALUE:
                            zzzlVar = zzzl.EDITION_99998_TEST_ONLY;
                            break;
                        case EDITION_99999_TEST_ONLY_VALUE:
                            zzzlVar = zzzl.EDITION_99999_TEST_ONLY;
                            break;
                        default:
                            zzzlVar = null;
                            break;
                    }
                    break;
            }
        } else {
            zzzlVar = zzzl.EDITION_MAX;
        }
        return zzzlVar != null;
    }
}
