package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhrh implements zzgvm {
    private static final ThreadLocal zza = new zzhrg();
    private final byte[] zzb;
    private final zzhik zzc;
    private final SecretKeySpec zzd;
    private final int zze;

    private zzhrh(byte[] bArr, int i, byte[] bArr2) throws GeneralSecurityException {
        if (!zzhcy.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (i != 12 && i != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.zze = i;
        int length = bArr.length;
        zzhsx.zza(length);
        this.zzd = new SecretKeySpec(bArr, "AES");
        this.zzc = zzhsm.zzb(zzhii.zzc(zzhij.zzb(length), zzhtb.zza(bArr, zzgvr.zza())));
        this.zzb = bArr2;
    }

    public static zzgvm zzb(zzgxr zzgxrVar) throws GeneralSecurityException {
        if (!zzhcy.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        zzgxrVar.zzf();
        return new zzhrh(zzgxrVar.zze().zzc(zzgvr.zza()), zzgxrVar.zzf().zzd(), zzgxrVar.zzc().zzc());
    }

    private final byte[] zzc(int i, byte[] bArr, int i2, int i3) throws GeneralSecurityException {
        byte[] bArr2 = new byte[i3 + 16];
        bArr2[15] = (byte) i;
        System.arraycopy(bArr, i2, bArr2, 16, i3);
        return this.zzc.zza(bArr2, 16);
    }

    @Override // com.google.android.gms.internal.ads.zzgvm
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        int length = bArr.length;
        int length2 = bArr3.length;
        int i = this.zze;
        int i2 = ((length - length2) - i) - 16;
        if (i2 < 0) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!zzhgi.zze(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArrZzc = zzc(0, bArr, length2, i);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArrZzc2 = zzc(1, bArr2, 0, bArr2.length);
        byte[] bArrZzc3 = zzc(2, bArr, length2 + i, i2);
        int i3 = length - 16;
        byte b = 0;
        for (int i4 = 0; i4 < 16; i4++) {
            b = (byte) (b | (((bArr[i3 + i4] ^ bArrZzc2[i4]) ^ bArrZzc[i4]) ^ bArrZzc3[i4]));
        }
        if (b != 0) {
            throw new AEADBadTagException("tag mismatch");
        }
        Cipher cipher = (Cipher) zza.get();
        cipher.init(1, this.zzd, new IvParameterSpec(bArrZzc));
        return cipher.doFinal(bArr, bArr3.length + i, i2);
    }
}
