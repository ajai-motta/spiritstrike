package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzhtn {
    public abstract void zza(zzhun zzhunVar, Object obj) throws IOException;

    public final zzhtn zzc() {
        return !(this instanceof zzhtm) ? new zzhtm(this, null) : this;
    }
}
