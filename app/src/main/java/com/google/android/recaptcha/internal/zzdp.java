package com.google.android.recaptcha.internal;

import android.app.Application;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdp {
    public static final void zza(Application application) {
        int i = zzby.zza;
        Application application2 = application;
        zzbz[] zzbzVarArr = {new zzbz(915034691, new zzcc(null, 1, null)), new zzbz(915034891, new zziq()), new zzbz(915034696, new zzch()), new zzbz(915035000, new zzmb()), new zzbz(915034713, new zzcy("https://www.recaptcha.net/recaptcha/api3")), new zzbz(915034856, new zzhm(null, 1, null)), new zzbz(915034881, new zzig(true)), new zzbz(735120228, application), new zzbz(915034697, new zzci(application2)), new zzbz(915034880, new zzif()), new zzbz(915034677, new zzcq(application2)), new zzbz(915034857, new zzhp()), new zzbz(915034863, new zzht()), new zzbz(915034876, new zzib()), new zzbz(915034720, new zzcz(GoogleApiAvailabilityLight.getInstance())), new zzbz(915034706, new zzcm()), new zzbz(915034844, new zzhc()), new zzbz(915034831, new zzgz(application2)), new zzbz(1931397515, application.getContentResolver()), new zzbz(-800379174, IntegrityManagerFactory.createStandard(application2)), new zzbz(-940314074, new zzi(CollectionsKt.listOf((Object[]) new zzg[]{new zzaj(null, 1, 0 == true ? 1 : 0), new zzu(0 == true ? 1 : 0, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0), new zzly()}))), new zzbz(915034730, new zzdk()), new zzbz(915034820, new zzgh()), new zzbz(-940314066, new zzq()), new zzbz(915034675, new zzbr(new zza())), new zzbz(915034674, new zzbq())};
        for (int i2 = 0; i2 < 26; i2++) {
            zzbz zzbzVar = zzbzVarArr[i2];
            if (!zzby.zzc.containsKey(Integer.valueOf(zzbzVar.zza()))) {
                zzby.zzc.put(Integer.valueOf(zzbzVar.zza()), zzbzVar);
            }
        }
    }
}
