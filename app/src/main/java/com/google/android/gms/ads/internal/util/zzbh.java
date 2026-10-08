package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzapc;
import com.google.android.gms.internal.ads.zzapy;
import com.google.android.gms.internal.ads.zzapz;
import com.google.android.gms.internal.ads.zzaqx;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbh extends zzaqx {
    final /* synthetic */ byte[] zza;
    final /* synthetic */ Map zzb;
    final /* synthetic */ com.google.android.gms.ads.internal.util.client.zzl zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbh(zzbl zzblVar, int i, String str, zzapz zzapzVar, zzapy zzapyVar, byte[] bArr, Map map, com.google.android.gms.ads.internal.util.client.zzl zzlVar) {
        super(i, str, zzapzVar, zzapyVar);
        this.zza = bArr;
        this.zzb = map;
        this.zzc = zzlVar;
        Objects.requireNonNull(zzblVar);
    }

    @Override // com.google.android.gms.internal.ads.zzapu
    public final Map zzm() throws zzapc {
        Map map = this.zzb;
        return map == null ? Collections.emptyMap() : map;
    }

    @Override // com.google.android.gms.internal.ads.zzapu
    public final byte[] zzn() throws zzapc {
        byte[] bArr = this.zza;
        if (bArr == null) {
            return null;
        }
        return bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzaqx, com.google.android.gms.internal.ads.zzapu
    protected final /* bridge */ /* synthetic */ void zzs(Object obj) {
        zzs((String) obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzaqx
    /* JADX INFO: renamed from: zzz */
    public final void zzs(String str) {
        this.zzc.zze(str);
        super.zzs(str);
    }
}
