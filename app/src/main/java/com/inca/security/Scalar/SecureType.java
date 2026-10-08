package com.inca.security.Scalar;

import com.inca.security.Interface.ISecureType;

/* JADX INFO: compiled from: za */
/* JADX INFO: loaded from: classes.dex */
public class SecureType implements ISecureType, AutoCloseable {
    private /* synthetic */ long ptr;
    private final /* synthetic */ Type type;

    /* JADX INFO: compiled from: za */
    private enum Type {
        Byte,
        Short,
        Integer,
        Long,
        Float,
        Double
    }

    private native /* synthetic */ long IIIiiiIiII(Object obj, int i);

    private native /* synthetic */ Number IiIiIIIIIi(long j, int i);

    private native /* synthetic */ void IiIiIIiiIi(long j, int i);

    private native /* synthetic */ void IiIiIiIiII(long j, Object obj, int i);

    private native /* synthetic */ void IiIiIiIiIi(long j, Object obj, int i);

    private native /* synthetic */ boolean IiIiiiIIII(long j, Object obj, int i);

    private native /* synthetic */ boolean IiIiiiIiII(long j, Object obj, int i);

    private native /* synthetic */ void IiIiiiIiIi(long j, Object obj, int i);

    private native /* synthetic */ boolean IiIiiiIiiI(long j, Object obj, int i);

    private native /* synthetic */ void iiIiiiIiII(long j, Object obj, int i);

    private native /* synthetic */ void iiIiiiIiIi(long j, Object obj, int i);

    @Override // com.inca.security.Interface.ISecureType
    public void sub(Number number) {
        iiIiiiIiIi(this.ptr, number, this.type.ordinal());
    }

    @Override // com.inca.security.Interface.ISecureType
    public void div(Number number) {
        IiIiIiIiIi(this.ptr, number, this.type.ordinal());
    }

    @Override // com.inca.security.Interface.ISecureType
    public void mul(Number number) {
        IiIiIiIiII(this.ptr, number, this.type.ordinal());
    }

    private /* synthetic */ Type parseType(Number number) {
        if (!(number instanceof Byte)) {
            if (number instanceof Short) {
                return Type.Short;
            }
            if (number instanceof Integer) {
                return Type.Integer;
            }
            if (!(number instanceof Long)) {
                if (number instanceof Float) {
                    return Type.Float;
                }
                if (!(number instanceof Double)) {
                    throw new RuntimeException("parseType is fail...");
                }
                return Type.Double;
            }
            return Type.Long;
        }
        return Type.Byte;
    }

    @Override // com.inca.security.Interface.ISecureType
    public boolean greaterThan(Number number) {
        return IiIiiiIiII(this.ptr, number, this.type.ordinal());
    }

    private /* synthetic */ long makeSecureType(Number number) {
        switch (1.$SwitchMap$com$inca$security$Scalar$SecureType$Type[this.type.ordinal()]) {
            case 1:
                return IIIiiiIiII(Byte.valueOf(number.byteValue()), this.type.ordinal());
            case 2:
                return IIIiiiIiII(Long.valueOf(number.longValue()), this.type.ordinal());
            case 3:
                return IIIiiiIiII(Float.valueOf(number.floatValue()), this.type.ordinal());
            case 4:
                return IIIiiiIiII(Short.valueOf(number.shortValue()), this.type.ordinal());
            case 5:
                return IIIiiiIiII(Double.valueOf(number.doubleValue()), this.type.ordinal());
            case 6:
                return IIIiiiIiII(Integer.valueOf(number.intValue()), this.type.ordinal());
            default:
                throw new RuntimeException("makeSecure is fail...");
        }
    }

    @Override // com.inca.security.Interface.ISecureType
    public boolean lessThan(Number number) {
        return IiIiiiIIII(this.ptr, number, this.type.ordinal());
    }

    @Override // com.inca.security.Interface.ISecureType
    public void set(Number number) {
        IiIiiiIiIi(this.ptr, number, this.type.ordinal());
    }

    @Override // com.inca.security.Interface.ISecureType
    public void free() {
        IiIiIIiiIi(this.ptr, this.type.ordinal());
        this.ptr = 0L;
    }

    public SecureType(Number number) {
        this.type = parseType(number);
        this.ptr = makeSecureType(number);
    }

    @Override // com.inca.security.Interface.ISecureType
    public Number get() {
        return IiIiIIIIIi(this.ptr, this.type.ordinal());
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        free();
    }

    @Override // com.inca.security.Interface.ISecureType
    public void add(Number number) {
        iiIiiiIiII(this.ptr, number, this.type.ordinal());
    }

    static {
        System.loadLibrary("compatible");
    }

    @Override // com.inca.security.Interface.ISecureType
    public boolean compare(Number number) {
        return IiIiiiIiiI(this.ptr, number, this.type.ordinal());
    }
}
