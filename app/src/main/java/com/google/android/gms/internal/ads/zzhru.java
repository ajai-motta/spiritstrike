package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhru implements zzgvm {
    private final zzhsk zza;
    private final zzgwi zzb;
    private final int zzc;
    private final byte[] zzd;

    private zzhru(zzhsk zzhskVar, zzgwi zzgwiVar, int i, byte[] bArr) {
        this.zza = zzhskVar;
        this.zzb = zzgwiVar;
        this.zzc = i;
        this.zzd = bArr;
    }

    public static zzgvm zzb(zzgxh zzgxhVar) throws GeneralSecurityException {
        zzhrf zzhrfVar = new zzhrf(zzgxhVar.zze().zzc(zzgvr.zza()), zzgxhVar.zzg().zzf());
        String strValueOf = String.valueOf(zzgxhVar.zzg().zzh());
        String.valueOf(strValueOf);
        String strValueOf2 = String.valueOf(strValueOf);
        return new zzhru(zzhrfVar, new zzhsp(new zzhso("HMAC".concat(strValueOf2), new SecretKeySpec(zzgxhVar.zzf().zzc(zzgvr.zza()), "HMAC")), zzgxhVar.zzg().zze()), zzgxhVar.zzg().zze(), zzgxhVar.zzc().zzc());
    }

    @Override // com.google.android.gms.internal.ads.zzgvm
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzd;
        int length = bArr.length;
        int i = this.zzc;
        int length2 = bArr3.length;
        if (length < i + length2) {
            throw new GeneralSecurityException("Decryption failed (ciphertext too short).");
        }
        if (!zzhgi.zze(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        int i2 = length - i;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, length2, i2);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, i2, length);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        if (MessageDigest.isEqual(((zzhsp) this.zzb).zzc(zzhrm.zza(bArr2, bArrCopyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8))), bArrCopyOfRange2)) {
            return this.zza.zza(bArrCopyOfRange);
        }
        throw new GeneralSecurityException("invalid MAC");
    }
}
