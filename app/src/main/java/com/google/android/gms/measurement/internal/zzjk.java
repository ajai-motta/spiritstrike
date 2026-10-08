package com.google.android.gms.measurement.internal;

import com.hive.Analytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public enum zzjk {
    AD_STORAGE(Analytics.CONSENT_TYPE_AD_STORAGE),
    ANALYTICS_STORAGE(Analytics.CONSENT_TYPE_ANALYTICS_STORAGE),
    AD_USER_DATA(Analytics.CONSENT_TYPE_AD_USER_DATA),
    AD_PERSONALIZATION(Analytics.CONSENT_TYPE_AD_PERSONALIZATION);

    public final String zze;

    zzjk(String str) {
        this.zze = str;
    }
}
