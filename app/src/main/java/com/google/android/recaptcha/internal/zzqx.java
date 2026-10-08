package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzqx implements zzsr {
    static final zzsr zza = new zzqx();

    private zzqx() {
    }

    @Override // com.google.android.recaptcha.internal.zzsr
    public final boolean zza(int i) {
        zzqy zzqyVar;
        zzqy zzqyVar2 = zzqy.EDITION_UNKNOWN;
        if (i == 0) {
            zzqyVar = zzqy.EDITION_UNKNOWN;
        } else if (i == 1) {
            zzqyVar = zzqy.EDITION_1_TEST_ONLY;
        } else if (i == 2) {
            zzqyVar = zzqy.EDITION_2_TEST_ONLY;
        } else if (i == 900) {
            zzqyVar = zzqy.EDITION_LEGACY;
        } else if (i != Integer.MAX_VALUE) {
            switch (i) {
                case EDITION_PROTO2_VALUE:
                    zzqyVar = zzqy.EDITION_PROTO2;
                    break;
                case 999:
                    zzqyVar = zzqy.EDITION_PROTO3;
                    break;
                case 1000:
                    zzqyVar = zzqy.EDITION_2023;
                    break;
                case 1001:
                    zzqyVar = zzqy.EDITION_2024;
                    break;
                default:
                    switch (i) {
                        case EDITION_99997_TEST_ONLY_VALUE:
                            zzqyVar = zzqy.EDITION_99997_TEST_ONLY;
                            break;
                        case EDITION_99998_TEST_ONLY_VALUE:
                            zzqyVar = zzqy.EDITION_99998_TEST_ONLY;
                            break;
                        case EDITION_99999_TEST_ONLY_VALUE:
                            zzqyVar = zzqy.EDITION_99999_TEST_ONLY;
                            break;
                        default:
                            zzqyVar = null;
                            break;
                    }
                    break;
            }
        } else {
            zzqyVar = zzqy.EDITION_MAX;
        }
        return zzqyVar != null;
    }
}
