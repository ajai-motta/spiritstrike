package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhnc {
    private zzhnf zza = null;
    private zzhta zzb = null;

    private zzhnc() {
    }

    /* synthetic */ zzhnc(byte[] bArr) {
    }

    public final zzhnc zza(zzhnf zzhnfVar) {
        this.zza = zzhnfVar;
        return this;
    }

    public final zzhnc zzb(zzhta zzhtaVar) {
        this.zzb = zzhtaVar;
        return this;
    }

    public final zzhnd zzc() throws GeneralSecurityException {
        zzhnf zzhnfVar = this.zza;
        if (zzhnfVar == null) {
            throw new GeneralSecurityException("Cannot build without a ecdsa public key");
        }
        zzhta zzhtaVar = this.zzb;
        if (zzhtaVar == null) {
            throw new GeneralSecurityException("Cannot build without a private value");
        }
        BigInteger bigIntegerZzb = zzhtaVar.zzb(zzgvr.zza());
        ECPoint eCPointZzd = zzhnfVar.zzd();
        zzhmx zzhmxVarZzd = zzhnfVar.zzf().zzd();
        BigInteger order = zzhmxVarZzd.zza().getOrder();
        if (bigIntegerZzb.signum() <= 0 || bigIntegerZzb.compareTo(order) >= 0) {
            throw new GeneralSecurityException("Invalid private value");
        }
        if (zzhdn.zzd(bigIntegerZzb, zzhmxVarZzd.zza()).equals(eCPointZzd)) {
            return new zzhnd(this.zza, this.zzb, null);
        }
        throw new GeneralSecurityException("Invalid private value");
    }
}
