package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public enum zzse {
    DOUBLE(0, 1, zzsy.DOUBLE),
    FLOAT(1, 1, zzsy.FLOAT),
    INT64(2, 1, zzsy.LONG),
    UINT64(3, 1, zzsy.LONG),
    INT32(4, 1, zzsy.INT),
    FIXED64(5, 1, zzsy.LONG),
    FIXED32(6, 1, zzsy.INT),
    BOOL(7, 1, zzsy.BOOLEAN),
    STRING(8, 1, zzsy.STRING),
    MESSAGE(9, 1, zzsy.MESSAGE),
    BYTES(10, 1, zzsy.BYTE_STRING),
    UINT32(11, 1, zzsy.INT),
    ENUM(12, 1, zzsy.ENUM),
    SFIXED32(13, 1, zzsy.INT),
    SFIXED64(14, 1, zzsy.LONG),
    SINT32(15, 1, zzsy.INT),
    SINT64(16, 1, zzsy.LONG),
    GROUP(17, 1, zzsy.MESSAGE),
    DOUBLE_LIST(18, 2, zzsy.DOUBLE),
    FLOAT_LIST(19, 2, zzsy.FLOAT),
    INT64_LIST(20, 2, zzsy.LONG),
    UINT64_LIST(21, 2, zzsy.LONG),
    INT32_LIST(22, 2, zzsy.INT),
    FIXED64_LIST(23, 2, zzsy.LONG),
    FIXED32_LIST(24, 2, zzsy.INT),
    BOOL_LIST(25, 2, zzsy.BOOLEAN),
    STRING_LIST(26, 2, zzsy.STRING),
    MESSAGE_LIST(27, 2, zzsy.MESSAGE),
    BYTES_LIST(28, 2, zzsy.BYTE_STRING),
    UINT32_LIST(29, 2, zzsy.INT),
    ENUM_LIST(30, 2, zzsy.ENUM),
    SFIXED32_LIST(31, 2, zzsy.INT),
    SFIXED64_LIST(32, 2, zzsy.LONG),
    SINT32_LIST(33, 2, zzsy.INT),
    SINT64_LIST(34, 2, zzsy.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzsy.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzsy.FLOAT),
    INT64_LIST_PACKED(37, 3, zzsy.LONG),
    UINT64_LIST_PACKED(38, 3, zzsy.LONG),
    INT32_LIST_PACKED(39, 3, zzsy.INT),
    FIXED64_LIST_PACKED(40, 3, zzsy.LONG),
    FIXED32_LIST_PACKED(41, 3, zzsy.INT),
    BOOL_LIST_PACKED(42, 3, zzsy.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzsy.INT),
    ENUM_LIST_PACKED(44, 3, zzsy.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzsy.INT),
    SFIXED64_LIST_PACKED(46, 3, zzsy.LONG),
    SINT32_LIST_PACKED(47, 3, zzsy.INT),
    SINT64_LIST_PACKED(48, 3, zzsy.LONG),
    GROUP_LIST(49, 2, zzsy.MESSAGE),
    MAP(50, 4, zzsy.VOID);

    private static final zzse[] zzZ;
    private final int zzab;

    static {
        zzse[] zzseVarArrValues = values();
        zzZ = new zzse[zzseVarArrValues.length];
        for (zzse zzseVar : zzseVarArrValues) {
            zzZ[zzseVar.zzab] = zzseVar;
        }
    }

    zzse(int i, int i2, zzsy zzsyVar) {
        this.zzab = i;
        int i3 = i2 - 1;
        if (i3 == 1 || i3 == 3) {
            zzsyVar.zza();
        }
        if (i2 == 1) {
            zzsy zzsyVar2 = zzsy.VOID;
            zzsyVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzab;
    }
}
