package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgzm {

    @Nullable
    private zzgzo zza;

    @Nullable
    private String zzb;

    @Nullable
    private zzgzn zzc;

    @Nullable
    private zzgxb zzd;

    private zzgzm() {
        throw null;
    }

    /* synthetic */ zzgzm(byte[] bArr) {
    }

    public final zzgzm zza(zzgzo zzgzoVar) {
        this.zza = zzgzoVar;
        return this;
    }

    public final zzgzm zzb(String str) {
        this.zzb = str;
        return this;
    }

    public final zzgzm zzc(zzgzn zzgznVar) {
        this.zzc = zzgznVar;
        return this;
    }

    public final zzgzm zzd(zzgxb zzgxbVar) {
        this.zzd = zzgxbVar;
        return this;
    }

    public final zzgzp zze() throws GeneralSecurityException {
        if (this.zza == null) {
            this.zza = zzgzo.zzb;
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("kekUri must be set");
        }
        zzgzn zzgznVar = this.zzc;
        if (zzgznVar == null) {
            throw new GeneralSecurityException("dekParsingStrategy must be set");
        }
        zzgxb zzgxbVar = this.zzd;
        if (zzgxbVar == null) {
            throw new GeneralSecurityException("dekParametersForNewKeys must be set");
        }
        if (zzgxbVar.zza()) {
            throw new GeneralSecurityException("dekParametersForNewKeys must not have ID Requirements");
        }
        if ((zzgznVar.equals(zzgzn.zza) && (zzgxbVar instanceof zzgyg)) || ((zzgznVar.equals(zzgzn.zzc) && (zzgxbVar instanceof zzgyv)) || ((zzgznVar.equals(zzgzn.zzb) && (zzgxbVar instanceof zzhar)) || ((zzgznVar.equals(zzgzn.zzd) && (zzgxbVar instanceof zzgxp)) || ((zzgznVar.equals(zzgzn.zze) && (zzgxbVar instanceof zzgxx)) || (zzgznVar.equals(zzgzn.zzf) && (zzgxbVar instanceof zzgyp))))))) {
            return new zzgzp(this.zza, this.zzb, this.zzc, this.zzd, null);
        }
        String string = this.zzc.toString();
        String strValueOf = String.valueOf(this.zzd);
        StringBuilder sb = new StringBuilder(string.length() + 67 + String.valueOf(strValueOf).length() + 1);
        sb.append("Cannot use parsing strategy ");
        sb.append(string);
        sb.append(" when new keys are picked according to ");
        sb.append(strValueOf);
        sb.append(".");
        throw new GeneralSecurityException(sb.toString());
    }
}
