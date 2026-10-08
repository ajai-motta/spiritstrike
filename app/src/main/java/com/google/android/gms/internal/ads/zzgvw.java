package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgvw {
    static final zzhla zza(zzgwj zzgwjVar) {
        try {
            return ((zzhfx) zzhfb.zza().zzk(null, zzhfx.class)).zzc();
        } catch (GeneralSecurityException e) {
            throw new zzhgh("Parsing parameters failed in getProto(). You probably want to call some Tink register function for ".concat(AbstractJsonLexerKt.NULL), e);
        }
    }

    public static final zzgwj zzb(zzgwj zzgwjVar) throws GeneralSecurityException {
        return zzgwjVar != null ? zzgwjVar : zzgwp.zzb(zza(null).zzaN());
    }
}
