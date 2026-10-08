package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhsu implements zzgwm {
    private final RSAPublicKey zza;
    private final zzhsi zzb;
    private final zzhsi zzc;
    private final int zzd;
    private final byte[] zze;
    private final byte[] zzf;

    /* synthetic */ zzhsu(RSAPublicKey rSAPublicKey, zzhsi zzhsiVar, zzhsi zzhsiVar2, int i, byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (zzhcz.zza()) {
            throw new GeneralSecurityException("Can not use RSA PSS in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzhsx.zzb(zzhsiVar);
        if (!zzhsiVar.equals(zzhsiVar2)) {
            throw new GeneralSecurityException("sigHash and mgf1Hash must be the same");
        }
        zzhsx.zzc(rSAPublicKey.getModulus().bitLength());
        zzhsx.zzd(rSAPublicKey.getPublicExponent());
        this.zza = rSAPublicKey;
        this.zzb = zzhsiVar;
        this.zzc = zzhsiVar2;
        this.zzd = i;
        this.zze = bArr;
        this.zzf = bArr2;
    }

    private final void zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        RSAPublicKey rSAPublicKey = this.zza;
        BigInteger publicExponent = rSAPublicKey.getPublicExponent();
        BigInteger modulus = rSAPublicKey.getModulus();
        int iBitLength = modulus.bitLength() + 7;
        int iBitLength2 = modulus.bitLength() + 6;
        if (iBitLength / 8 != bArr.length) {
            throw new GeneralSecurityException("invalid signature's length");
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (bigInteger.compareTo(modulus) >= 0) {
            throw new GeneralSecurityException("signature out of range");
        }
        byte[] bArrZzb = zzhdb.zzb(bigInteger.modPow(publicExponent, modulus), iBitLength2 / 8);
        int iBitLength3 = modulus.bitLength() - 1;
        zzhsi zzhsiVar = this.zzb;
        zzhsx.zzb(zzhsiVar);
        zzhrz zzhrzVar = zzhrz.zzd;
        MessageDigest messageDigest = (MessageDigest) zzhrzVar.zzb(zzhsw.zzb(zzhsiVar));
        messageDigest.update(bArr2);
        byte[] bArr3 = this.zzf;
        if (bArr3.length != 0) {
            messageDigest.update(bArr3);
        }
        byte[] bArrDigest = messageDigest.digest();
        int digestLength = messageDigest.getDigestLength();
        int length = bArrZzb.length;
        int i = this.zzd;
        if (length < digestLength + i + 2) {
            throw new GeneralSecurityException("inconsistent");
        }
        if (bArrZzb[length - 1] != -68) {
            throw new GeneralSecurityException("inconsistent");
        }
        int i2 = length - digestLength;
        int i3 = i2 - 1;
        byte[] bArrCopyOf = Arrays.copyOf(bArrZzb, i3);
        int length2 = bArrCopyOf.length;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrZzb, length2, length2 + digestLength);
        int i4 = 0;
        while (true) {
            int i5 = digestLength;
            int i6 = length;
            int i7 = iBitLength3;
            MessageDigest messageDigest2 = messageDigest;
            long j = (((long) length) * 8) - ((long) iBitLength3);
            if (i4 < j) {
                if (((bArrCopyOf[i4 / 8] >> (7 - (i4 % 8))) & 1) != 0) {
                    throw new GeneralSecurityException("inconsistent");
                }
                i4++;
                digestLength = i5;
                length = i6;
                iBitLength3 = i7;
                messageDigest = messageDigest2;
            } else {
                MessageDigest messageDigest3 = (MessageDigest) zzhrzVar.zzb(zzhsw.zzb(this.zzc));
                byte[] bArr4 = new byte[i3];
                int i8 = 0;
                int i9 = 0;
                for (int digestLength2 = messageDigest3.getDigestLength(); i8 <= (i2 - 2) / digestLength2; digestLength2 = digestLength2) {
                    messageDigest3.reset();
                    messageDigest3.update(bArrCopyOfRange);
                    byte[] bArr5 = bArrCopyOfRange;
                    messageDigest3.update(zzhdb.zzb(BigInteger.valueOf(i8), 4));
                    byte[] bArrDigest2 = messageDigest3.digest();
                    int length3 = bArrDigest2.length;
                    System.arraycopy(bArrDigest2, 0, bArr4, i9, Math.min(length3, i3 - i9));
                    i9 += length3;
                    i8++;
                    bArrCopyOfRange = bArr5;
                    messageDigest3 = messageDigest3;
                }
                byte[] bArr6 = bArrCopyOfRange;
                byte[] bArr7 = new byte[i3];
                for (int i10 = 0; i10 < i3; i10++) {
                    bArr7[i10] = (byte) (bArr4[i10] ^ bArrCopyOf[i10]);
                }
                for (int i11 = 0; i11 <= j; i11++) {
                    int i12 = i11 / 8;
                    bArr7[i12] = (byte) ((~(1 << (7 - (i11 % 8)))) & bArr7[i12]);
                }
                int i13 = 0;
                while (true) {
                    int i14 = (i2 - i) - 2;
                    if (i13 >= i14) {
                        if (bArr7[i14] != 1) {
                            throw new GeneralSecurityException("inconsistent");
                        }
                        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr7, i3 - i, i3);
                        int i15 = i5 + 8;
                        byte[] bArr8 = new byte[i + i15];
                        System.arraycopy(bArrDigest, 0, bArr8, 8, bArrDigest.length);
                        System.arraycopy(bArrCopyOfRange2, 0, bArr8, i15, bArrCopyOfRange2.length);
                        if (!MessageDigest.isEqual(messageDigest2.digest(bArr8), bArr6)) {
                            throw new GeneralSecurityException("inconsistent");
                        }
                        return;
                    }
                    if (bArr7[i13] != 0) {
                        throw new GeneralSecurityException("inconsistent");
                    }
                    i13++;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zze;
        int length = bArr3.length;
        if (length == 0) {
            zzb(bArr, bArr2);
        } else {
            if (!zzhgi.zze(bArr3, bArr)) {
                throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
            }
            zzb(Arrays.copyOfRange(bArr, length, bArr.length), bArr2);
        }
    }
}
