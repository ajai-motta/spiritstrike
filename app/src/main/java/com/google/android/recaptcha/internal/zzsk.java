package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzsk extends zzsn implements zztt {
    protected zzsd zzb = zzsd.zzd();

    final zzsd zzi() {
        if (this.zzb.zzj()) {
            this.zzb = this.zzb.clone();
        }
        return this.zzb;
    }
}
