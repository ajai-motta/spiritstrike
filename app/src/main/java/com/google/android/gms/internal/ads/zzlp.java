package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface zzlp {

    /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzlp$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
    public final /* synthetic */ class CC {
        public static void $default$zzv(zzlp _this, zzlo zzloVar) {
        }

        public static void $default$zzw(zzlp _this) {
        }

        public static boolean zzaa(int i, boolean z) {
            int i2 = i & 7;
            if (i2 != 4) {
                return z && i2 == 3;
            }
            return true;
        }
    }

    String zzS();

    int zza();

    int zzab(zzv zzvVar) throws zzib;

    int zzu() throws zzib;

    void zzv(zzlo zzloVar);

    void zzw();
}
