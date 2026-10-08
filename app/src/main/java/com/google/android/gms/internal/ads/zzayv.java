package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzayv extends zzazr {
    private static volatile String zzh;
    private static final Object zzi = new Object();

    public zzayv(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i, int i2) {
        super(zzaydVar, "gyMGe4SoPVIhBgFM+VlZQFWek2IoqCotue6ayBNgVb95WbB68suDu+Zv4jWiM6iG", "etp1batKULd2kwg+5GPfxliTu8RjfdN0zKvZOjQe8mU=", zzaucVar, i, 82);
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        if (zzh == null) {
            synchronized (zzi) {
                if (zzh == null) {
                    zzh = (String) this.zze.invoke(null, new Object[0]);
                }
            }
        }
        zzauc zzaucVar = this.zzd;
        synchronized (zzaucVar) {
            zzaucVar.zzV(zzh);
        }
    }
}
