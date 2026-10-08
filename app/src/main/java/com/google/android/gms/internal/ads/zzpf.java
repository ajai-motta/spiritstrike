package com.google.android.gms.internal.ads;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzpf extends AudioDeviceCallback {
    final /* synthetic */ zzpj zza;

    /* synthetic */ zzpf(zzpj zzpjVar, byte[] bArr) {
        Objects.requireNonNull(zzpjVar);
        this.zza = zzpjVar;
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
        zzpj zzpjVar = this.zza;
        zzpjVar.zzf(zzpe.zza(zzpjVar.zzg(), zzpjVar.zzj(), zzpjVar.zzh()));
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
        String str = zzep.zza;
        int length = audioDeviceInfoArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            zzpj zzpjVar = this.zza;
            if (Objects.equals(audioDeviceInfoArr[i], zzpjVar.zzh())) {
                zzpjVar.zzi(null);
                break;
            }
            i++;
        }
        zzpj zzpjVar2 = this.zza;
        zzpjVar2.zzf(zzpe.zza(zzpjVar2.zzg(), zzpjVar2.zzj(), zzpjVar2.zzh()));
    }
}
