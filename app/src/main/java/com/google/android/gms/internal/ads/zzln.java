package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface zzln extends zzli {

    /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzln$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
    public final /* synthetic */ class CC {
        public static long $default$zzT(zzln _this, long j, long j2) {
            if (_this.zze() == 1) {
                return (_this.zzY() || _this.zzZ()) ? 1000000L : 10000L;
            }
            return 10000L;
        }

        public static boolean $default$zzU(zzln _this, long j) {
            return false;
        }

        public static void $default$zzV(zzln _this, float f, float f2) throws zzib {
        }

        public static void $default$zzW(zzln _this) {
        }

        public static void $default$zzt(zzln _this) {
        }
    }

    String zzS();

    long zzT(long j, long j2);

    boolean zzU(long j);

    void zzV(float f, float f2) throws zzib;

    void zzW();

    void zzX(long j, long j2) throws zzib;

    boolean zzY();

    boolean zzZ();

    int zza();

    zzlp zzb();

    void zzc(int i, zzpc zzpcVar, zzdc zzdcVar);

    void zzcY() throws zzib;

    void zzcZ(zzv[] zzvVarArr, zzwk zzwkVar, long j, long j2, zzuu zzuuVar) throws zzib;

    zzko zzd();

    zzwk zzda();

    boolean zzdb();

    int zze();

    void zzf(zzlq zzlqVar, zzv[] zzvVarArr, zzwk zzwkVar, long j, boolean z, boolean z2, long j2, long j3, zzuu zzuuVar) throws zzib;

    long zzk();

    void zzl();

    boolean zzm();

    void zzn() throws IOException;

    void zzo(zzbf zzbfVar);

    void zzp(long j, boolean z) throws zzib;

    void zzq();

    void zzr();

    void zzs();

    void zzt();
}
