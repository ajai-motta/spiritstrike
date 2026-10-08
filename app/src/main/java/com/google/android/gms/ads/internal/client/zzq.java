package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzq {
    public static final zzq zza = new zzq();

    protected zzq() {
    }

    public final zzm zza(Context context, zzek zzekVar) {
        Context context2;
        List listUnmodifiableList;
        String strZzv;
        String strZza = zzekVar.zza();
        Set setZzc = zzekVar.zzc();
        if (setZzc.isEmpty()) {
            context2 = context;
            listUnmodifiableList = null;
        } else {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(setZzc));
            context2 = context;
        }
        boolean zZzh = zzekVar.zzh(context2);
        Bundle bundleZzd = zzekVar.zzd(AdMobAdapter.class);
        String strZzf = zzekVar.zzf();
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzbb.zza();
            strZzv = com.google.android.gms.ads.internal.util.client.zzf.zzv(Thread.currentThread().getStackTrace(), packageName);
        } else {
            strZzv = null;
        }
        boolean zZzm = zzekVar.zzm();
        RequestConfiguration requestConfigurationZzo = zzex.zzb().zzo();
        return new zzm(8, -1L, bundleZzd, -1, listUnmodifiableList, zZzh, Math.max(zzekVar.zzj(), requestConfigurationZzo.getTagForChildDirectedTreatment()), false, strZzf, null, null, strZza, zzekVar.zzi(), zzekVar.zzk(), Collections.unmodifiableList(new ArrayList(zzekVar.zzl())), zzekVar.zzg(), strZzv, zZzm, null, requestConfigurationZzo.getTagForUnderAgeOfConsent(), (String) Collections.max(Arrays.asList(null, requestConfigurationZzo.getMaxAdContentRating()), zzp.zza), zzekVar.zzb(), zzekVar.zzo(), zzekVar.zzn(), requestConfigurationZzo.getPublisherPrivacyPersonalizationState().getValue(), zzekVar.zzq(), zzekVar.zzr());
    }
}
