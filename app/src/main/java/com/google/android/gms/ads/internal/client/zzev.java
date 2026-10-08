package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.OnAdInspectorClosedListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzev extends zzdm {
    private zzev() {
        throw null;
    }

    /* synthetic */ zzev(byte[] bArr) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final void zze(zze zzeVar) {
        OnAdInspectorClosedListener onAdInspectorClosedListenerZzz = zzex.zzb().zzz();
        if (onAdInspectorClosedListenerZzz != null) {
            onAdInspectorClosedListenerZzz.onAdInspectorClosed(zzeVar == null ? null : new AdInspectorError(zzeVar.zza, zzeVar.zzb, zzeVar.zzc));
        }
    }
}
