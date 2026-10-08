package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public enum zzhwe {
    DOUBLE(0, 1, zzhxf.DOUBLE),
    FLOAT(1, 1, zzhxf.FLOAT),
    INT64(2, 1, zzhxf.LONG),
    UINT64(3, 1, zzhxf.LONG),
    INT32(4, 1, zzhxf.INT),
    FIXED64(5, 1, zzhxf.LONG),
    FIXED32(6, 1, zzhxf.INT),
    BOOL(7, 1, zzhxf.BOOLEAN),
    STRING(8, 1, zzhxf.STRING),
    MESSAGE(9, 1, zzhxf.MESSAGE),
    BYTES(10, 1, zzhxf.BYTE_STRING),
    UINT32(11, 1, zzhxf.INT),
    ENUM(12, 1, zzhxf.ENUM),
    SFIXED32(13, 1, zzhxf.INT),
    SFIXED64(14, 1, zzhxf.LONG),
    SINT32(15, 1, zzhxf.INT),
    SINT64(16, 1, zzhxf.LONG),
    GROUP(17, 1, zzhxf.MESSAGE),
    DOUBLE_LIST(18, 2, zzhxf.DOUBLE),
    FLOAT_LIST(19, 2, zzhxf.FLOAT),
    INT64_LIST(20, 2, zzhxf.LONG),
    UINT64_LIST(21, 2, zzhxf.LONG),
    INT32_LIST(22, 2, zzhxf.INT),
    FIXED64_LIST(23, 2, zzhxf.LONG),
    FIXED32_LIST(24, 2, zzhxf.INT),
    BOOL_LIST(25, 2, zzhxf.BOOLEAN),
    STRING_LIST(26, 2, zzhxf.STRING),
    MESSAGE_LIST(27, 2, zzhxf.MESSAGE),
    BYTES_LIST(28, 2, zzhxf.BYTE_STRING),
    UINT32_LIST(29, 2, zzhxf.INT),
    ENUM_LIST(30, 2, zzhxf.ENUM),
    SFIXED32_LIST(31, 2, zzhxf.INT),
    SFIXED64_LIST(32, 2, zzhxf.LONG),
    SINT32_LIST(33, 2, zzhxf.INT),
    SINT64_LIST(34, 2, zzhxf.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzhxf.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzhxf.FLOAT),
    INT64_LIST_PACKED(37, 3, zzhxf.LONG),
    UINT64_LIST_PACKED(38, 3, zzhxf.LONG),
    INT32_LIST_PACKED(39, 3, zzhxf.INT),
    FIXED64_LIST_PACKED(40, 3, zzhxf.LONG),
    FIXED32_LIST_PACKED(41, 3, zzhxf.INT),
    BOOL_LIST_PACKED(42, 3, zzhxf.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzhxf.INT),
    ENUM_LIST_PACKED(44, 3, zzhxf.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzhxf.INT),
    SFIXED64_LIST_PACKED(46, 3, zzhxf.LONG),
    SINT32_LIST_PACKED(47, 3, zzhxf.INT),
    SINT64_LIST_PACKED(48, 3, zzhxf.LONG),
    GROUP_LIST(49, 2, zzhxf.MESSAGE),
    MAP(50, 4, zzhxf.VOID);

    private static final zzhwe[] zzaa;
    private final int zzZ;

    static {
        zzhwe[] zzhweVarArrValues = values();
        zzaa = new zzhwe[zzhweVarArrValues.length];
        for (zzhwe zzhweVar : zzhweVarArrValues) {
            zzaa[zzhweVar.zzZ] = zzhweVar;
        }
    }

    zzhwe(int i, int i2, zzhxf zzhxfVar) {
        this.zzZ = i;
        int i3 = i2 - 1;
        if (i3 == 1 || i3 == 3) {
            zzhxfVar.zza();
        }
        if (i2 == 1) {
            zzhxf zzhxfVar2 = zzhxf.VOID;
            zzhxfVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzZ;
    }
}
