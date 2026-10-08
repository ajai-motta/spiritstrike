package com.pgl.ssdk;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes6.dex */
public class d {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f3081a;
        private final q b;

        public a(long j, q qVar) {
            this.f3081a = j;
            this.b = qVar;
        }

        public q a() {
            return this.b;
        }

        public long b() {
            return this.f3081a;
        }
    }

    public static t a(q qVar) throws IOException, s {
        o<ByteBuffer, Long> oVarA = p.a(qVar);
        if (oVarA == null) {
            throw new s("ZIP End of Central Directory record not found");
        }
        ByteBuffer byteBufferA = oVarA.a();
        long jLongValue = oVarA.b().longValue();
        byteBufferA.order(ByteOrder.LITTLE_ENDIAN);
        long jC = p.c(byteBufferA);
        if (jC > jLongValue) {
            throw new s("ZIP Central Directory start offset out of range: " + jC + ". ZIP End of Central Directory offset: " + jLongValue);
        }
        long jD = p.d(byteBufferA);
        long j = jC + jD;
        if (j <= jLongValue) {
            return new t(jC, jD, p.e(byteBufferA), jLongValue, byteBufferA);
        }
        throw new s("ZIP Central Directory overlaps with End of Central Directory. CD end: " + j + ", EoCD start: " + jLongValue);
    }

    public static a a(q qVar, t tVar) throws b, IOException {
        long jA = tVar.a();
        long jC = tVar.c() + jA;
        long jE = tVar.e();
        if (jC != jE) {
            throw new b("ZIP Central Directory is not immediately followed by End of Central Directory. CD end: " + jC + ", EoCD start: " + jE);
        }
        if (jA >= 32) {
            ByteBuffer byteBufferA = qVar.a(jA - 24, 24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBufferA.order(byteOrder);
            if (byteBufferA.getLong(8) == 2334950737559900225L && byteBufferA.getLong(16) == 3617552046287187010L) {
                long j = byteBufferA.getLong(0);
                if (j < byteBufferA.capacity() || j > 2147483639) {
                    throw new b("APK Signing Block size out of range: ".concat(String.valueOf(j)));
                }
                long j2 = (int) (8 + j);
                long j3 = jA - j2;
                if (j3 >= 0) {
                    ByteBuffer byteBufferA2 = qVar.a(j3, 8);
                    byteBufferA2.order(byteOrder);
                    long j4 = byteBufferA2.getLong(0);
                    if (j4 == j) {
                        return new a(j3, qVar.a(j3, j2));
                    }
                    throw new b("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j);
                }
                throw new b("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
            }
            throw new b("No APK Signing Block before ZIP Central Directory");
        }
        throw new b("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(jA)));
    }
}
