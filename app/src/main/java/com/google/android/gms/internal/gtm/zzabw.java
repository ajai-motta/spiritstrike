package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public enum zzabw {
    DOUBLE(0, 1, zzacr.DOUBLE),
    FLOAT(1, 1, zzacr.FLOAT),
    INT64(2, 1, zzacr.LONG),
    UINT64(3, 1, zzacr.LONG),
    INT32(4, 1, zzacr.INT),
    FIXED64(5, 1, zzacr.LONG),
    FIXED32(6, 1, zzacr.INT),
    BOOL(7, 1, zzacr.BOOLEAN),
    STRING(8, 1, zzacr.STRING),
    MESSAGE(9, 1, zzacr.MESSAGE),
    BYTES(10, 1, zzacr.BYTE_STRING),
    UINT32(11, 1, zzacr.INT),
    ENUM(12, 1, zzacr.ENUM),
    SFIXED32(13, 1, zzacr.INT),
    SFIXED64(14, 1, zzacr.LONG),
    SINT32(15, 1, zzacr.INT),
    SINT64(16, 1, zzacr.LONG),
    GROUP(17, 1, zzacr.MESSAGE),
    DOUBLE_LIST(18, 2, zzacr.DOUBLE),
    FLOAT_LIST(19, 2, zzacr.FLOAT),
    INT64_LIST(20, 2, zzacr.LONG),
    UINT64_LIST(21, 2, zzacr.LONG),
    INT32_LIST(22, 2, zzacr.INT),
    FIXED64_LIST(23, 2, zzacr.LONG),
    FIXED32_LIST(24, 2, zzacr.INT),
    BOOL_LIST(25, 2, zzacr.BOOLEAN),
    STRING_LIST(26, 2, zzacr.STRING),
    MESSAGE_LIST(27, 2, zzacr.MESSAGE),
    BYTES_LIST(28, 2, zzacr.BYTE_STRING),
    UINT32_LIST(29, 2, zzacr.INT),
    ENUM_LIST(30, 2, zzacr.ENUM),
    SFIXED32_LIST(31, 2, zzacr.INT),
    SFIXED64_LIST(32, 2, zzacr.LONG),
    SINT32_LIST(33, 2, zzacr.INT),
    SINT64_LIST(34, 2, zzacr.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzacr.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzacr.FLOAT),
    INT64_LIST_PACKED(37, 3, zzacr.LONG),
    UINT64_LIST_PACKED(38, 3, zzacr.LONG),
    INT32_LIST_PACKED(39, 3, zzacr.INT),
    FIXED64_LIST_PACKED(40, 3, zzacr.LONG),
    FIXED32_LIST_PACKED(41, 3, zzacr.INT),
    BOOL_LIST_PACKED(42, 3, zzacr.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzacr.INT),
    ENUM_LIST_PACKED(44, 3, zzacr.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzacr.INT),
    SFIXED64_LIST_PACKED(46, 3, zzacr.LONG),
    SINT32_LIST_PACKED(47, 3, zzacr.INT),
    SINT64_LIST_PACKED(48, 3, zzacr.LONG),
    GROUP_LIST(49, 2, zzacr.MESSAGE),
    MAP(50, 4, zzacr.VOID);

    private static final zzabw[] zzZ;
    private final int zzab;

    static {
        zzabw[] zzabwVarArrValues = values();
        zzZ = new zzabw[zzabwVarArrValues.length];
        for (zzabw zzabwVar : zzabwVarArrValues) {
            zzZ[zzabwVar.zzab] = zzabwVar;
        }
    }

    zzabw(int i, int i2, zzacr zzacrVar) {
        this.zzab = i;
        int i3 = i2 - 1;
        if (i3 == 1 || i3 == 3) {
            zzacrVar.zza();
        }
        if (i2 == 1) {
            zzacr zzacrVar2 = zzacr.VOID;
            zzacrVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzab;
    }
}
