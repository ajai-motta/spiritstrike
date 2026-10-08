package com.google.android.gms.tagmanager;

import android.content.Context;
import com.adjust.sdk.Constants;
import com.google.android.gms.analytics.CampaignTrackingReceiver;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class InstallReferrerReceiver extends CampaignTrackingReceiver {
    @Override // com.google.android.gms.analytics.CampaignTrackingReceiver
    protected final void zza(Context context, String str) {
        zzcs.zzd(str);
        zzfb.zza(context, "gtm_install_referrer", Constants.REFERRER, str);
        zzcs.zzc(context, str);
    }
}
