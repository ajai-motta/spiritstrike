package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzre extends AudioTrack.StreamEventCallback {
    final /* synthetic */ zzrg zza;

    zzre(zzrg zzrgVar) {
        Objects.requireNonNull(zzrgVar);
        this.zza = zzrgVar;
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onDataRequest(AudioTrack audioTrack, int i) {
        zzrh zzrhVar = this.zza.zza;
        if (audioTrack.equals(zzrhVar.zzJ()) && zzrhVar.zzI() != null && zzrhVar.zzL()) {
            zzrhVar.zzI().zza();
        }
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onPresentationEnded(AudioTrack audioTrack) {
        zzrh zzrhVar = this.zza.zza;
        if (audioTrack.equals(zzrhVar.zzJ())) {
            zzrhVar.zzK(true);
        }
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onTearDown(AudioTrack audioTrack) {
        zzrh zzrhVar = this.zza.zza;
        if (audioTrack.equals(zzrhVar.zzJ()) && zzrhVar.zzI() != null && zzrhVar.zzL()) {
            zzrhVar.zzI().zza();
        }
    }
}
