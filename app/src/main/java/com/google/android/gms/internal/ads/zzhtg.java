package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzhtg {
    @Deprecated
    public zzhtg() {
    }

    public final String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            zzhun zzhunVar = new zzhun(zzhub.zza(sb));
            zzhunVar.zza(zzhtl.LENIENT);
            zzhuj.zza.zza(zzhunVar, this);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public String zzd() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final zzhti zze() {
        if (this instanceof zzhti) {
            return (zzhti) this;
        }
        throw new IllegalStateException("Not a JSON Object: ".concat(toString()));
    }

    public final zzhtf zzf() {
        if (this instanceof zzhtf) {
            return (zzhtf) this;
        }
        throw new IllegalStateException("Not a JSON Array: ".concat(toString()));
    }

    public final zzhtk zzg() {
        if (this instanceof zzhtk) {
            return (zzhtk) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: ".concat(toString()));
    }
}
