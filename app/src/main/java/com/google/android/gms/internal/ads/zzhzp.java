package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public enum zzhzp {
    DOUBLE(zzhzq.DOUBLE, 1),
    FLOAT(zzhzq.FLOAT, 5),
    INT64(zzhzq.LONG, 0),
    UINT64(zzhzq.LONG, 0),
    INT32(zzhzq.INT, 0),
    FIXED64(zzhzq.LONG, 1),
    FIXED32(zzhzq.INT, 5),
    BOOL(zzhzq.BOOLEAN, 0),
    STRING(zzhzq.STRING, 2),
    GROUP(zzhzq.MESSAGE, 3),
    MESSAGE(zzhzq.MESSAGE, 2),
    BYTES(zzhzq.BYTE_STRING, 2),
    UINT32(zzhzq.INT, 0),
    ENUM(zzhzq.ENUM, 0),
    SFIXED32(zzhzq.INT, 5),
    SFIXED64(zzhzq.LONG, 1),
    SINT32(zzhzq.INT, 0),
    SINT64(zzhzq.LONG, 0);

    private final zzhzq zzs;
    private final int zzt;

    zzhzp(zzhzq zzhzqVar, int i) {
        this.zzs = zzhzqVar;
        this.zzt = i;
    }

    public final zzhzq zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }
}
