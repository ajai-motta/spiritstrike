package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.compose.runtime.ComposerKt;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgbk {
    private MessageDigest zza;
    private final zzgjd zzb;
    private final Object zzc = new Object();
    private boolean zzd = false;
    private SecureRandom zze;

    public zzgbk(zzgjd zzgjdVar) {
        this.zzb = zzgjdVar;
    }

    public final void zza() {
        if (zzc()) {
            return;
        }
        zzb(new SecureRandom());
    }

    final synchronized void zzb(SecureRandom secureRandom) {
        zzgjb zzgjbVarZza = this.zzb.zza(ComposerKt.compositionLocalMapKey);
        try {
            try {
                try {
                    zzgjbVarZza.zza();
                    this.zze = secureRandom;
                    this.zza = MessageDigest.getInstance("MD5");
                    this.zzd = true;
                } catch (NoSuchAlgorithmException e) {
                    zzgjbVarZza.zzb(e);
                }
                zzgjbVarZza.zzc();
            } catch (Throwable th) {
                zzgjbVarZza.zzb(th);
                throw th;
            }
        } catch (Throwable th2) {
            zzgjbVarZza.zzc();
            throw th2;
        }
    }

    public final synchronized boolean zzc() {
        return this.zzd;
    }

    final byte[] zzd(byte[] bArr, String str, boolean z) throws UnsupportedEncodingException {
        int length = bArr.length;
        int i = true != z ? 255 : 239;
        zzgmd.zza(length <= i);
        ByteBuffer byteBufferPut = ByteBuffer.allocate(i + 1).put((byte) length);
        if (length < i) {
            int i2 = i - length;
            byte[] bArr2 = new byte[i2];
            this.zze.nextBytes(bArr2);
            bArr = Arrays.copyOf(bArr, length + i2);
            System.arraycopy(bArr2, 0, bArr, length, i2);
        }
        byte[] bArrArray = byteBufferPut.put(bArr).array();
        if (z) {
            bArrArray = ByteBuffer.allocate(256).put(zze(bArrArray)).put(bArrArray).array();
        }
        byte[] bArr3 = new byte[256];
        zzgbn[] zzgbnVarArr = new zzgca().zzcG;
        int length2 = zzgbnVarArr.length;
        for (int i3 = 0; i3 < 12; i3++) {
            zzgbnVarArr[i3].zza(bArrArray, bArr3);
        }
        if (!zzgmu.zzc(str)) {
            new zzgbm(str.length() > 32 ? str.substring(0, 32).getBytes(StandardCharsets.UTF_8) : str.getBytes(StandardCharsets.UTF_8)).zza(bArr3);
        }
        return bArr3;
    }

    public final byte[] zze(byte[] bArr) {
        byte[] bArrDigest;
        synchronized (this.zzc) {
            this.zza.reset();
            this.zza.update(bArr);
            bArrDigest = this.zza.digest();
        }
        return bArrDigest;
    }

    public final zzavp zzf(byte[] bArr, String str) throws UnsupportedEncodingException {
        zzavp zzavpVarZza = zzavq.zza();
        byte[] bArrZze = zze(bArr);
        zzhvi zzhviVar = zzhvi.zzb;
        zzavpVarZza.zzb(zzhvi.zzr(bArrZze, 0, bArrZze.length));
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int length = bArr.length;
            if (i >= ((length - 1) / 255) + 1) {
                break;
            }
            int i2 = i * 255;
            int i3 = i2 + 255;
            if (length > i3) {
                length = i3;
            }
            arrayList.add(Arrays.copyOfRange(bArr, i2, length));
            i++;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            zzavpVarZza.zza(zzhvi.zzr(zzd((byte[]) it.next(), str, false), 0, 256));
        }
        return zzavpVarZza;
    }

    public final String zzg(int i, String str) throws UnsupportedEncodingException {
        zzauc zzaucVarZzj = zzauz.zzj();
        zzaucVarZzj.zzl(i);
        return Base64.encodeToString(zzd(((zzauz) zzaucVarZzj.zzbu()).zzaN(), str, true), 11);
    }
}
