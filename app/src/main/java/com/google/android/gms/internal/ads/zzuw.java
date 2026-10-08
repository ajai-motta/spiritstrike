package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface zzuw {

    /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzuw$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
    public final /* synthetic */ class CC {
        public static void $default$zzA(zzuw _this, zzak zzakVar) {
        }

        public static zzbf $default$zzH(zzuw _this) {
            return null;
        }

        public static boolean $default$zzI(zzuw _this) {
            return true;
        }
    }

    void zzA(zzak zzakVar);

    void zzD(zzus zzusVar);

    zzus zzG(zzuu zzuuVar, zzyv zzyvVar, long j);

    zzbf zzH();

    boolean zzI();

    zzak zzJ();

    void zzl(Handler handler, zzvf zzvfVar);

    void zzm(zzvf zzvfVar);

    void zzn(Handler handler, zzrv zzrvVar);

    void zzo(zzrv zzrvVar);

    void zzp(zzuv zzuvVar, zzgz zzgzVar, zzpc zzpcVar);

    void zzq(zzuv zzuvVar);

    void zzr(zzuv zzuvVar);

    void zzs(zzuv zzuvVar);

    void zzt() throws IOException;
}
