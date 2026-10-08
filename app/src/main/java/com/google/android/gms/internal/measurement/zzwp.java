package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzwp {
    private final int[] zza;
    private final zzwn zzb;
    private zzwn zzc;
    private int zzd;
    private int zze;
    private int zzf;

    private zzwp(int[] iArr) {
        this.zza = iArr;
        zzwn zzwnVar = new zzwn(-1, -1, null);
        this.zzb = zzwnVar;
        this.zzc = zzwnVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        r6 = r0.zzc.zzd;
        r8 = java.lang.Integer.valueOf(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        if (r6.containsKey(r8) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
    
        r0.zzc.zzd.put(r8, new com.google.android.gms.internal.measurement.zzwn(r1, 1073741824, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        if (r5 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
    
        r5.zzc = r0.zzc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
    
        if (r5 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
    
        r5.zzc = r0.zzc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
    
        r0.zzd = r1;
        r0.zze++;
        r0.zzb();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.google.android.gms.internal.measurement.zzwp zza(int[] r12) {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzwp.zza(int[]):com.google.android.gms.internal.measurement.zzwp");
    }

    private final void zze(zzwn zzwnVar, StringBuilder sb) {
        for (zzwn zzwnVar2 : zzwnVar.zzd.values()) {
            sb.append("  ");
            sb.append(zzwnVar);
            sb.append(" -> ");
            sb.append(zzwnVar2);
            sb.append(" [label=\"");
            int[] iArr = this.zza;
            sb.append(Arrays.toString(Arrays.copyOfRange(iArr, zzwnVar2.zza, Math.min(iArr.length, zzwnVar2.zzb + 1))));
            sb.append("\"]\n");
            zze(zzwnVar2, sb);
        }
    }

    private final boolean zzf(int i, int i2, int i3, int i4) {
        if (i >= 0 && i3 >= 0) {
            int[] iArr = this.zza;
            int length = iArr.length;
            int iMin = Math.min(length, i2);
            if (iMin - i == Math.min(length, i4) - i3) {
                for (int i5 = i; i5 <= iMin; i5++) {
                    if (iArr[i5] != iArr[(i3 + i5) - i]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("digraph {\n");
        zze(this.zzb, sb);
        sb.append("}");
        return sb.toString();
    }

    final void zzb() {
        if (this.zze == 0) {
            return;
        }
        Map map = this.zzc.zzd;
        int[] iArr = this.zza;
        zzwn zzwnVar = (zzwn) map.get(Integer.valueOf(iArr[this.zzd]));
        while (true) {
            int i = (zzwnVar.zzb - zzwnVar.zza) + 1;
            int i2 = this.zze;
            if (i > i2) {
                return;
            }
            int i3 = this.zzd + i;
            this.zzd = i3;
            this.zzc = zzwnVar;
            int i4 = i2 - i;
            this.zze = i4;
            if (i4 > 0) {
                zzwnVar = (zzwn) zzwnVar.zzd.get(Integer.valueOf(iArr[i3]));
            }
        }
    }

    final void zzc() {
        zzwn zzwnVar = this.zzc.zzc;
        if (zzwnVar != null) {
            this.zzc = zzwnVar;
        } else {
            this.zzc = this.zzb;
            int i = this.zze;
            if (i > 0) {
                this.zze = i - 1;
            }
            if (this.zzf > 0) {
                this.zzd++;
            }
        }
        zzb();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.measurement.zzwo zzd() {
        /*
            r15 = this;
            java.util.ArrayDeque r0 = new java.util.ArrayDeque
            r0.<init>()
            com.google.android.gms.internal.measurement.zzwm r7 = new com.google.android.gms.internal.measurement.zzwm
            com.google.android.gms.internal.measurement.zzwn r8 = r15.zzb
            r5 = -1
            r6 = 0
            r3 = 0
            r4 = -1
            r1 = r7
            r2 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            r0.push(r7)
        L15:
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L7e
            java.lang.Object r1 = r0.pop()
            com.google.android.gms.internal.measurement.zzwm r1 = (com.google.android.gms.internal.measurement.zzwm) r1
            com.google.android.gms.internal.measurement.zzwn r2 = r1.zzd
            java.util.Map r2 = r2.zzd
            java.util.Collection r2 = r2.values()
            java.util.Iterator r2 = r2.iterator()
        L2d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L15
            java.lang.Object r3 = r2.next()
            r10 = r3
            com.google.android.gms.internal.measurement.zzwn r10 = (com.google.android.gms.internal.measurement.zzwn) r10
            int r12 = r1.zzb
            int r13 = r1.zzc
            int r3 = r10.zza
            int r4 = r10.zzb
            boolean r3 = r15.zzf(r12, r13, r3, r4)
            if (r3 != 0) goto L68
            java.util.Map r3 = r10.zzd
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L5c
            int r3 = r10.zza
            int r5 = r3 + r13
            int r5 = r5 - r12
            boolean r3 = r15.zzf(r12, r13, r3, r5)
            if (r3 == 0) goto L5c
            goto L68
        L5c:
            com.google.android.gms.internal.measurement.zzwm r3 = new com.google.android.gms.internal.measurement.zzwm
            int r12 = r10.zza
            r14 = 0
            r11 = 1
            r9 = r3
            r13 = r4
            r9.<init>(r10, r11, r12, r13, r14)
            goto L73
        L68:
            com.google.android.gms.internal.measurement.zzwm r3 = new com.google.android.gms.internal.measurement.zzwm
            int r4 = r1.zza
            int r11 = r4 + 1
            r14 = 0
            r9 = r3
            r9.<init>(r10, r11, r12, r13, r14)
        L73:
            int r4 = r7.zza
            int r5 = r3.zza
            if (r4 >= r5) goto L7a
            r7 = r3
        L7a:
            r0.push(r3)
            goto L2d
        L7e:
            int[] r0 = r15.zza
            int r1 = r7.zzc
            int r1 = r1 + 1
            int r2 = r0.length
            int r1 = java.lang.Math.min(r2, r1)
            r2 = 0
        L8a:
            int r3 = r7.zzb
            int r4 = r1 - r3
            int r5 = r2 % r4
            int r5 = r5 + r3
            r5 = r0[r5]
            java.util.Map r6 = r8.zzd
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r5 = r6.get(r5)
            r8 = r5
            com.google.android.gms.internal.measurement.zzwn r8 = (com.google.android.gms.internal.measurement.zzwn) r8
            if (r8 != 0) goto La3
            goto Lbc
        La3:
            int r5 = r8.zza
        La5:
            int r6 = r8.zzb
            int r6 = r6 + 1
            if (r5 >= r6) goto L8a
            int r6 = r0.length
            if (r5 >= r6) goto L8a
            int r6 = r2 % r4
            int r6 = r6 + r3
            r6 = r0[r6]
            r9 = r0[r5]
            if (r6 != r9) goto Lbc
            int r2 = r2 + 1
            int r5 = r5 + 1
            goto La5
        Lbc:
            com.google.android.gms.internal.measurement.zzwo r0 = new com.google.android.gms.internal.measurement.zzwo
            int r2 = r2 / r4
            r0.<init>(r3, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzwp.zzd():com.google.android.gms.internal.measurement.zzwo");
    }
}
