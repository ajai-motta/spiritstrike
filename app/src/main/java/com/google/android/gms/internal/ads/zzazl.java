package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzazl extends zzazr {
    private final zzayk zzh;
    private long zzi;

    public zzazl(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i, int i2, zzayk zzaykVar) {
        super(zzaydVar, "7i2iPrjrwVOXQymI9kbzBw+Saen0JiBKsL25H084g9vqkkZvrS3PC/gXCAaliMdd", "jjLuguQ1TtUBIYvLkWHGRHLEQB49t1f8VaYjdD5pX6Q=", zzaucVar, i, 53);
        this.zzh = zzaykVar;
        if (zzaykVar != null) {
            this.zzi = zzaykVar.zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzh != null) {
            this.zzd.zzH(((Long) this.zze.invoke(null, Long.valueOf(this.zzi))).longValue());
        }
    }
}
