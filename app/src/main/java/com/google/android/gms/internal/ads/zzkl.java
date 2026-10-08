package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface zzkl {

    /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzkl$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
    public final /* synthetic */ class CC {
        public static void $default$zza(zzkl _this, zzpc zzpcVar) {
            throw new IllegalStateException("onPrepared not implemented");
        }

        public static void $default$zzb(zzkl _this, zzkk zzkkVar, zzwv zzwvVar, zzyk[] zzykVarArr) {
            throw new IllegalStateException("onTracksSelected not implemented");
        }

        public static void $default$zzc(zzkl _this, zzpc zzpcVar) {
            throw new IllegalStateException("onStopped not implemented");
        }

        public static void $default$zzd(zzkl _this, zzpc zzpcVar) {
            throw new IllegalStateException("onReleased not implemented");
        }

        public static long $default$zzf(zzkl _this, zzpc zzpcVar) {
            throw new IllegalStateException("getBackBufferDurationUs not implemented");
        }

        public static boolean $default$zzg(zzkl _this, zzpc zzpcVar) {
            throw new IllegalStateException("retainBackBufferFromKeyframe not implemented");
        }

        public static boolean $default$zzh(zzkl _this, zzkk zzkkVar) {
            long j = zzkkVar.zzd;
            throw null;
        }

        public static boolean $default$zzi(zzkl _this, zzkk zzkkVar) {
            zzbf zzbfVar = zzkkVar.zzb;
            throw null;
        }

        public static boolean $default$zzj(zzkl _this, zzpc zzpcVar, zzbf zzbfVar, zzuu zzuuVar, long j) {
            zzdt.zzc("LoadControl", "shouldContinuePreloading needs to be implemented when playlist preloading is enabled");
            return false;
        }
    }

    void zza(zzpc zzpcVar);

    void zzb(zzkk zzkkVar, zzwv zzwvVar, zzyk[] zzykVarArr);

    void zzc(zzpc zzpcVar);

    void zzd(zzpc zzpcVar);

    zzyv zze(zzpc zzpcVar);

    long zzf(zzpc zzpcVar);

    boolean zzg(zzpc zzpcVar);

    boolean zzh(zzkk zzkkVar);

    boolean zzi(zzkk zzkkVar);

    boolean zzj(zzpc zzpcVar, zzbf zzbfVar, zzuu zzuuVar, long j);
}
