package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public enum zzaex {
    DOUBLE(zzaey.DOUBLE, 1),
    FLOAT(zzaey.FLOAT, 5),
    INT64(zzaey.LONG, 0),
    UINT64(zzaey.LONG, 0),
    INT32(zzaey.INT, 0),
    FIXED64(zzaey.LONG, 1),
    FIXED32(zzaey.INT, 5),
    BOOL(zzaey.BOOLEAN, 0),
    STRING(zzaey.STRING, 2),
    GROUP(zzaey.MESSAGE, 3),
    MESSAGE(zzaey.MESSAGE, 2),
    BYTES(zzaey.BYTE_STRING, 2),
    UINT32(zzaey.INT, 0),
    ENUM(zzaey.ENUM, 0),
    SFIXED32(zzaey.INT, 5),
    SFIXED64(zzaey.LONG, 1),
    SINT32(zzaey.INT, 0),
    SINT64(zzaey.LONG, 0);

    private final zzaey zzt;

    zzaex(zzaey zzaeyVar, int i) {
        this.zzt = zzaeyVar;
    }

    public final zzaey zza() {
        return this.zzt;
    }
}
