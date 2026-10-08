package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhpg {

    @Nullable
    private zzhpj zza = null;

    @Nullable
    private zzhta zzb = null;

    @Nullable
    private zzhta zzc = null;

    @Nullable
    private zzhta zzd = null;

    @Nullable
    private zzhta zze = null;

    @Nullable
    private zzhta zzf = null;

    @Nullable
    private zzhta zzg = null;

    private zzhpg() {
    }

    /* synthetic */ zzhpg(byte[] bArr) {
    }

    public final zzhpg zza(zzhpj zzhpjVar) {
        this.zza = zzhpjVar;
        return this;
    }

    public final zzhpg zzb(zzhta zzhtaVar, zzhta zzhtaVar2) {
        this.zzc = zzhtaVar;
        this.zzd = zzhtaVar2;
        return this;
    }

    public final zzhpg zzc(zzhta zzhtaVar) {
        this.zzb = zzhtaVar;
        return this;
    }

    public final zzhpg zzd(zzhta zzhtaVar, zzhta zzhtaVar2) {
        this.zze = zzhtaVar;
        this.zzf = zzhtaVar2;
        return this;
    }

    public final zzhpg zze(zzhta zzhtaVar) {
        this.zzg = zzhtaVar;
        return this;
    }

    public final zzhph zzf() throws GeneralSecurityException {
        zzhpj zzhpjVar = this.zza;
        if (zzhpjVar == null) {
            throw new GeneralSecurityException("Cannot build without a RSA SSA PKCS1 public key");
        }
        if (this.zzc == null || this.zzd == null) {
            throw new GeneralSecurityException("Cannot build without prime factors");
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("Cannot build without private exponent");
        }
        if (this.zze == null || this.zzf == null) {
            throw new GeneralSecurityException("Cannot build without prime exponents");
        }
        if (this.zzg == null) {
            throw new GeneralSecurityException("Cannot build without CRT coefficient");
        }
        BigInteger bigIntegerZzd = zzhpjVar.zzf().zzd();
        BigInteger bigIntegerZzd2 = this.zza.zzd();
        BigInteger bigIntegerZzb = this.zzc.zzb(zzgvr.zza());
        BigInteger bigIntegerZzb2 = this.zzd.zzb(zzgvr.zza());
        BigInteger bigIntegerZzb3 = this.zzb.zzb(zzgvr.zza());
        BigInteger bigIntegerZzb4 = this.zze.zzb(zzgvr.zza());
        BigInteger bigIntegerZzb5 = this.zzf.zzb(zzgvr.zza());
        BigInteger bigIntegerZzb6 = this.zzg.zzb(zzgvr.zza());
        if (!bigIntegerZzb.isProbablePrime(10)) {
            throw new GeneralSecurityException("p is not a prime");
        }
        if (!bigIntegerZzb2.isProbablePrime(10)) {
            throw new GeneralSecurityException("q is not a prime");
        }
        if (!bigIntegerZzb.multiply(bigIntegerZzb2).equals(bigIntegerZzd2)) {
            throw new GeneralSecurityException("Prime p times prime q is not equal to the public key's modulus");
        }
        BigInteger bigIntegerSubtract = bigIntegerZzb.subtract(BigInteger.ONE);
        BigInteger bigIntegerSubtract2 = bigIntegerZzb2.subtract(BigInteger.ONE);
        if (!bigIntegerZzd.multiply(bigIntegerZzb3).mod(bigIntegerSubtract.divide(bigIntegerSubtract.gcd(bigIntegerSubtract2)).multiply(bigIntegerSubtract2)).equals(BigInteger.ONE)) {
            throw new GeneralSecurityException("D is invalid.");
        }
        if (!bigIntegerZzd.multiply(bigIntegerZzb4).mod(bigIntegerSubtract).equals(BigInteger.ONE)) {
            throw new GeneralSecurityException("dP is invalid.");
        }
        if (!bigIntegerZzd.multiply(bigIntegerZzb5).mod(bigIntegerSubtract2).equals(BigInteger.ONE)) {
            throw new GeneralSecurityException("dQ is invalid.");
        }
        if (bigIntegerZzb2.multiply(bigIntegerZzb6).mod(bigIntegerZzb).equals(BigInteger.ONE)) {
            return new zzhph(this.zza, this.zzc, this.zzd, this.zzb, this.zze, this.zzf, this.zzg, null);
        }
        throw new GeneralSecurityException("qInv is invalid.");
    }
}
