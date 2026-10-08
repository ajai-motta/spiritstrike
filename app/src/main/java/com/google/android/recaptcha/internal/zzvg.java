package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public enum zzvg {
    DOUBLE(zzvh.DOUBLE, 1),
    FLOAT(zzvh.FLOAT, 5),
    INT64(zzvh.LONG, 0),
    UINT64(zzvh.LONG, 0),
    INT32(zzvh.INT, 0),
    FIXED64(zzvh.LONG, 1),
    FIXED32(zzvh.INT, 5),
    BOOL(zzvh.BOOLEAN, 0),
    STRING(zzvh.STRING, 2),
    GROUP(zzvh.MESSAGE, 3),
    MESSAGE(zzvh.MESSAGE, 2),
    BYTES(zzvh.BYTE_STRING, 2),
    UINT32(zzvh.INT, 0),
    ENUM(zzvh.ENUM, 0),
    SFIXED32(zzvh.INT, 5),
    SFIXED64(zzvh.LONG, 1),
    SINT32(zzvh.INT, 0),
    SINT64(zzvh.LONG, 0);

    private final zzvh zzt;

    zzvg(zzvh zzvhVar, int i) {
        this.zzt = zzvhVar;
    }

    public final zzvh zza() {
        return this.zzt;
    }
}
