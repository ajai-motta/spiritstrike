package com.google.android.play.core.integrity;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.4.0 */
/* JADX INFO: loaded from: classes5.dex */
final class ao extends IntegrityTokenRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1751a;
    private final Long b;
    private final Object c = null;

    /* synthetic */ ao(String str, Long l, Object obj, an anVar) {
        this.f1751a = str;
        this.b = l;
    }

    private static boolean a() {
        return true;
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenRequest
    public final Long cloudProjectNumber() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 != r5) goto L4
            return r0
        L4:
            boolean r1 = r6 instanceof com.google.android.play.core.integrity.IntegrityTokenRequest
            r2 = 0
            if (r1 == 0) goto L2f
            r1 = r6
            com.google.android.play.core.integrity.IntegrityTokenRequest r1 = (com.google.android.play.core.integrity.IntegrityTokenRequest) r1
            java.lang.String r3 = r5.f1751a
            java.lang.String r4 = r1.nonce()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L2f
            java.lang.Long r3 = r5.b
            if (r3 != 0) goto L23
            java.lang.Long r1 = r1.cloudProjectNumber()
            if (r1 != 0) goto L2f
            goto L2d
        L23:
            java.lang.Long r1 = r1.cloudProjectNumber()
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L2f
        L2d:
            r1 = r0
            goto L30
        L2f:
            r1 = r2
        L30:
            boolean r3 = r6 instanceof com.google.android.play.core.integrity.ao
            if (r3 == 0) goto L43
            boolean r3 = a()
            if (r3 == 0) goto L43
            com.google.android.play.core.integrity.ao r6 = (com.google.android.play.core.integrity.ao) r6
            if (r1 == 0) goto L41
            java.lang.Object r6 = r6.c
            goto L44
        L41:
            r0 = r2
            goto L44
        L43:
            r0 = r1
        L44:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.integrity.ao.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int iHashCode = this.f1751a.hashCode() ^ 1000003;
        Long l = this.b;
        int iHashCode2 = (iHashCode * 1000003) ^ (l == null ? 0 : l.hashCode());
        return a() ? iHashCode2 * 1000003 : iHashCode2;
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenRequest
    public final String nonce() {
        return this.f1751a;
    }

    public final String toString() {
        String strConcat = "IntegrityTokenRequest{nonce=" + this.f1751a + ", cloudProjectNumber=" + this.b;
        if (a()) {
            strConcat = strConcat.concat(", network=null");
        }
        return strConcat.concat("}");
    }
}
