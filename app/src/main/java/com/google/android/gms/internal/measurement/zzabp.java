package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzabp extends zzabn {
    private static final String zza;

    static {
        String property;
        try {
            property = System.getProperty("line.separator");
        } catch (SecurityException unused) {
        }
        if (!property.matches("\\n|\\r(?:\\n)?")) {
            property = "\n";
        }
        zza = property;
    }

    static int zze(String str, int i) throws zzabo {
        while (i < str.length()) {
            int i2 = i + 1;
            if (str.charAt(i) != '%') {
                i = i2;
            } else {
                if (i2 >= str.length()) {
                    throw zzabo.zzc("trailing unquoted '%' character", str, i);
                }
                char cCharAt = str.charAt(i2);
                if (cCharAt != '%' && cCharAt != 'n') {
                    return i;
                }
                i += 2;
            }
        }
        return -1;
    }

    abstract int zzb(zzabm zzabmVar, int i, String str, int i2, int i3, int i4) throws zzabo;

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a7, code lost:
    
        r4 = zze(r7, zzb(r15, r12, r7, r4, r5, r6));
        r0 = r11;
        r1 = r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009a  */
    @Override // com.google.android.gms.internal.measurement.zzabn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void zzc(com.google.android.gms.internal.measurement.zzabm r15) throws com.google.android.gms.internal.measurement.zzabo {
        /*
            r14 = this;
            java.lang.String r7 = r15.zzi()
            r8 = 0
            int r0 = zze(r7, r8)
            r9 = -1
            r4 = r0
            r0 = r8
            r1 = r9
        Ld:
            if (r4 < 0) goto Lc4
            int r2 = r4 + 1
            r3 = r2
            r5 = r8
        L13:
            int r6 = r7.length()
            java.lang.String r10 = "unterminated parameter"
            if (r3 >= r6) goto Lbf
            int r6 = r3 + 1
            char r11 = r7.charAt(r3)
            int r12 = r11 + (-48)
            char r12 = (char) r12
            r13 = 10
            if (r12 >= r13) goto L39
            int r5 = r5 * 10
            int r5 = r5 + r12
            r3 = 1000000(0xf4240, float:1.401298E-39)
            if (r5 >= r3) goto L32
            r3 = r6
            goto L13
        L32:
            java.lang.String r15 = "index too large"
            com.google.android.gms.internal.measurement.zzabo r15 = com.google.android.gms.internal.measurement.zzabo.zza(r15, r7, r4, r6)
            throw r15
        L39:
            r12 = 36
            if (r11 != r12) goto L6c
            int r1 = r3 - r2
            if (r1 == 0) goto L65
            char r1 = r7.charAt(r2)
            r2 = 48
            if (r1 == r2) goto L5e
            int r5 = r5 + (-1)
            int r1 = r7.length()
            if (r6 == r1) goto L59
            int r3 = r3 + 2
            r7.charAt(r6)
            r11 = r0
            r12 = r5
            goto L7f
        L59:
            com.google.android.gms.internal.measurement.zzabo r15 = com.google.android.gms.internal.measurement.zzabo.zzc(r10, r7, r4)
            throw r15
        L5e:
            java.lang.String r15 = "index has leading zero"
            com.google.android.gms.internal.measurement.zzabo r15 = com.google.android.gms.internal.measurement.zzabo.zza(r15, r7, r4, r6)
            throw r15
        L65:
            java.lang.String r15 = "missing index"
            com.google.android.gms.internal.measurement.zzabo r15 = com.google.android.gms.internal.measurement.zzabo.zza(r15, r7, r4, r6)
            throw r15
        L6c:
            r5 = 60
            if (r11 != r5) goto L8e
            if (r1 == r9) goto L87
            int r2 = r7.length()
            if (r6 == r2) goto L82
            int r3 = r3 + 2
            r7.charAt(r6)
            r11 = r0
            r12 = r1
        L7f:
            r5 = r6
            r6 = r3
            goto L93
        L82:
            com.google.android.gms.internal.measurement.zzabo r15 = com.google.android.gms.internal.measurement.zzabo.zzc(r10, r7, r4)
            throw r15
        L87:
            java.lang.String r15 = "invalid relative parameter"
            com.google.android.gms.internal.measurement.zzabo r15 = com.google.android.gms.internal.measurement.zzabo.zza(r15, r7, r4, r6)
            throw r15
        L8e:
            int r1 = r0 + 1
            r12 = r0
            r11 = r1
            r5 = r2
        L93:
            int r6 = r6 + r9
        L94:
            int r0 = r7.length()
            if (r6 >= r0) goto Lba
            char r0 = r7.charAt(r6)
            r0 = r0 & (-33)
            int r0 = r0 + (-65)
            char r0 = (char) r0
            r1 = 26
            if (r0 >= r1) goto Lb7
            r0 = r14
            r1 = r15
            r2 = r12
            r3 = r7
            int r0 = r0.zzb(r1, r2, r3, r4, r5, r6)
            int r4 = zze(r7, r0)
            r0 = r11
            r1 = r12
            goto Ld
        Lb7:
            int r6 = r6 + 1
            goto L94
        Lba:
            com.google.android.gms.internal.measurement.zzabo r15 = com.google.android.gms.internal.measurement.zzabo.zzc(r10, r7, r4)
            throw r15
        Lbf:
            com.google.android.gms.internal.measurement.zzabo r15 = com.google.android.gms.internal.measurement.zzabo.zzc(r10, r7, r4)
            throw r15
        Lc4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzabp.zzc(com.google.android.gms.internal.measurement.zzabm):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzabn
    public final void zzd(StringBuilder sb, String str, int i, int i2) {
        int i3 = i;
        while (i < i2) {
            int i4 = i + 1;
            if (str.charAt(i) == '%') {
                if (i4 == i2) {
                    break;
                }
                char cCharAt = str.charAt(i4);
                if (cCharAt == '%') {
                    sb.append((CharSequence) str, i3, i4);
                } else if (cCharAt == 'n') {
                    sb.append((CharSequence) str, i3, i);
                    sb.append(zza);
                }
                i3 = i + 2;
                i = i3;
            }
            i = i4;
        }
        if (i3 < i2) {
            sb.append((CharSequence) str, i3, i2);
        }
    }
}
