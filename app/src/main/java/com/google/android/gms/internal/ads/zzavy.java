package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzavy implements Runnable {
    private zzavy() {
        throw null;
    }

    /* synthetic */ zzavy(byte[] bArr) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzavz.zzd = MessageDigest.getInstance("MD5");
            countDownLatch = zzavz.zzb;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = zzavz.zzb;
        } catch (Throwable th) {
            zzavz.zzb.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }
}
