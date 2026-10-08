package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface zzada {

    /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzada$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
    public final /* synthetic */ class CC {
        @SideEffectFree
        public static zzada $default$zzf(zzada _this) {
            return _this;
        }
    }

    boolean zza(zzadb zzadbVar) throws IOException;

    List zzb();

    void zzc(zzadd zzaddVar);

    int zzd(zzadb zzadbVar, zzaea zzaeaVar) throws IOException;

    void zze(long j, long j2);

    @SideEffectFree
    zzada zzf();
}
