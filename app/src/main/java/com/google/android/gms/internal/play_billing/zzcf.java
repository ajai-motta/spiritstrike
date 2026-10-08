package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.0.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzcf extends zzbw {
    static final zzbw zza = new zzcf(null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient Object zzc;
    private final transient int zzd;

    private zzcf(Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    static zzcf zzg(int i, Object[] objArr, zzbv zzbvVar) {
        int iHighestOneBit;
        char c;
        char c2;
        int[] iArr;
        Object obj;
        int i2 = i;
        Object[] objArrCopyOf = objArr;
        if (i2 == 0) {
            return (zzcf) zza;
        }
        zzbu zzbuVar = null;
        Object obj2 = null;
        zzbu zzbuVar2 = null;
        zzbu zzbuVar3 = null;
        int i3 = 1;
        if (i2 == 1) {
            zzbo.zza(Objects.requireNonNull(objArrCopyOf[0]), Objects.requireNonNull(objArrCopyOf[1]));
            return new zzcf(null, objArrCopyOf, 1);
        }
        zzbg.zzb(i2, objArrCopyOf.length >> 1, FirebaseAnalytics.Param.INDEX);
        int iMax = Math.max(i2, 2);
        if (iMax < 751619276) {
            iHighestOneBit = Integer.highestOneBit(iMax - 1);
            do {
                iHighestOneBit += iHighestOneBit;
            } while (((double) iHighestOneBit) * 0.7d < iMax);
        } else {
            iHighestOneBit = 1073741824;
            if (iMax >= 1073741824) {
                throw new IllegalArgumentException("collection too large");
            }
        }
        if (i2 == 1) {
            zzbo.zza(Objects.requireNonNull(objArrCopyOf[0]), Objects.requireNonNull(objArrCopyOf[1]));
            i2 = 1;
            c2 = 2;
            c = 1;
        } else {
            int i4 = iHighestOneBit - 1;
            int i5 = -1;
            if (iHighestOneBit <= 128) {
                byte[] bArr = new byte[iHighestOneBit];
                Arrays.fill(bArr, (byte) -1);
                int i6 = 0;
                int i7 = 0;
                while (i6 < i2) {
                    int i8 = i7 + i7;
                    int i9 = i6 + i6;
                    Object objRequireNonNull = Objects.requireNonNull(objArrCopyOf[i9]);
                    Object objRequireNonNull2 = Objects.requireNonNull(objArrCopyOf[i9 ^ i3]);
                    zzbo.zza(objRequireNonNull, objRequireNonNull2);
                    int iZza = zzbp.zza(objRequireNonNull.hashCode());
                    while (true) {
                        int i10 = iZza & i4;
                        int i11 = bArr[i10] & 255;
                        if (i11 == 255) {
                            bArr[i10] = (byte) i8;
                            if (i7 < i6) {
                                objArrCopyOf[i8] = objRequireNonNull;
                                objArrCopyOf[i8 ^ 1] = objRequireNonNull2;
                            }
                            i7++;
                        } else {
                            if (objRequireNonNull.equals(objArrCopyOf[i11 == true ? 1 : 0])) {
                                int i12 = ~i11;
                                zzbu zzbuVar4 = new zzbu(objRequireNonNull, objRequireNonNull2, Objects.requireNonNull(objArrCopyOf[i12 == true ? 1 : 0]));
                                objArrCopyOf[i12 == true ? 1 : 0] = objRequireNonNull2;
                                zzbuVar2 = zzbuVar4;
                                break;
                            }
                            iZza = i10 + 1;
                        }
                    }
                    i6++;
                    i3 = 1;
                }
                if (i7 == i2) {
                    iArr = bArr;
                } else {
                    c2 = 2;
                    obj = new Object[]{bArr, Integer.valueOf(i7), zzbuVar2};
                    c = 1;
                    obj2 = obj;
                }
            } else {
                if (iHighestOneBit <= 32768) {
                    short[] sArr = new short[iHighestOneBit];
                    Arrays.fill(sArr, (short) -1);
                    int i13 = 0;
                    for (int i14 = 0; i14 < i2; i14++) {
                        int i15 = i13 + i13;
                        int i16 = i14 + i14;
                        Object objRequireNonNull3 = Objects.requireNonNull(objArrCopyOf[i16]);
                        Object objRequireNonNull4 = Objects.requireNonNull(objArrCopyOf[i16 ^ 1]);
                        zzbo.zza(objRequireNonNull3, objRequireNonNull4);
                        int iZza2 = zzbp.zza(objRequireNonNull3.hashCode());
                        while (true) {
                            int i17 = iZza2 & i4;
                            char c3 = (char) sArr[i17];
                            if (c3 == 65535) {
                                sArr[i17] = (short) i15;
                                if (i13 < i14) {
                                    objArrCopyOf[i15] = objRequireNonNull3;
                                    objArrCopyOf[i15 ^ 1] = objRequireNonNull4;
                                }
                                i13++;
                            } else {
                                if (objRequireNonNull3.equals(objArrCopyOf[c3])) {
                                    int i18 = c3 ^ 1;
                                    zzbu zzbuVar5 = new zzbu(objRequireNonNull3, objRequireNonNull4, Objects.requireNonNull(objArrCopyOf[i18 == true ? 1 : 0]));
                                    objArrCopyOf[i18 == true ? 1 : 0] = objRequireNonNull4;
                                    zzbuVar3 = zzbuVar5;
                                    break;
                                }
                                iZza2 = i17 + 1;
                            }
                        }
                    }
                    if (i13 == i2) {
                        iArr = sArr;
                    } else {
                        obj2 = new Object[]{sArr, Integer.valueOf(i13), zzbuVar3};
                        c = 1;
                        c2 = 2;
                    }
                } else {
                    int i19 = 1;
                    int[] iArr2 = new int[iHighestOneBit];
                    Arrays.fill(iArr2, -1);
                    int i20 = 0;
                    int i21 = 0;
                    while (i20 < i2) {
                        int i22 = i21 + i21;
                        int i23 = i20 + i20;
                        Object objRequireNonNull5 = Objects.requireNonNull(objArrCopyOf[i23]);
                        Object objRequireNonNull6 = Objects.requireNonNull(objArrCopyOf[i23 ^ i19]);
                        zzbo.zza(objRequireNonNull5, objRequireNonNull6);
                        int iZza3 = zzbp.zza(objRequireNonNull5.hashCode());
                        while (true) {
                            int i24 = iZza3 & i4;
                            int i25 = iArr2[i24];
                            if (i25 == i5) {
                                iArr2[i24] = i22;
                                if (i21 < i20) {
                                    objArrCopyOf[i22] = objRequireNonNull5;
                                    objArrCopyOf[i22 ^ 1] = objRequireNonNull6;
                                }
                                i21++;
                            } else {
                                if (objRequireNonNull5.equals(objArrCopyOf[i25])) {
                                    int i26 = i25 ^ 1;
                                    zzbu zzbuVar6 = new zzbu(objRequireNonNull5, objRequireNonNull6, Objects.requireNonNull(objArrCopyOf[i26]));
                                    objArrCopyOf[i26] = objRequireNonNull6;
                                    zzbuVar = zzbuVar6;
                                    break;
                                }
                                iZza3 = i24 + 1;
                                i5 = -1;
                            }
                        }
                        i20++;
                        i19 = 1;
                        i5 = -1;
                    }
                    if (i21 == i2) {
                        iArr = iArr2;
                    } else {
                        c = 1;
                        c2 = 2;
                        obj2 = new Object[]{iArr2, Integer.valueOf(i21), zzbuVar};
                    }
                }
                c = 1;
                obj2 = obj;
            }
            c2 = 2;
            obj = iArr;
            c = 1;
            obj2 = obj;
        }
        boolean z = obj2 instanceof Object[];
        Object obj3 = obj2;
        if (z) {
            Object[] objArr2 = (Object[]) obj2;
            zzbu zzbuVar7 = (zzbu) objArr2[c2];
            if (zzbvVar == null) {
                throw zzbuVar7.zza();
            }
            zzbvVar.zzc = zzbuVar7;
            Object obj4 = objArr2[0];
            int iIntValue = ((Integer) objArr2[c]).intValue();
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue + iIntValue);
            obj3 = obj4;
            i2 = iIntValue;
        }
        return new zzcf(obj3, objArrCopyOf, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0003  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0003 A[EDGE_INSN: B:44:0x0003->B:4:0x0003 BREAK  A[LOOP:0: B:16:0x003a->B:22:0x0050], EDGE_INSN: B:46:0x0003->B:4:0x0003 BREAK  A[LOOP:1: B:26:0x0065->B:32:0x007c], EDGE_INSN: B:48:0x0003->B:4:0x0003 BREAK  A[LOOP:2: B:34:0x008b->B:43:0x00a2]] */
    @Override // com.google.android.gms.internal.play_billing.zzbw, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object get(java.lang.Object r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L6
        L3:
            r10 = r0
            goto L9e
        L6:
            int r1 = r9.zzd
            java.lang.Object[] r2 = r9.zzb
            r3 = 1
            if (r1 != r3) goto L22
            r1 = 0
            r1 = r2[r1]
            java.lang.Object r1 = java.util.Objects.requireNonNull(r1)
            boolean r10 = r1.equals(r10)
            if (r10 == 0) goto L3
            r10 = r2[r3]
            java.lang.Object r10 = java.util.Objects.requireNonNull(r10)
            goto L9e
        L22:
            java.lang.Object r1 = r9.zzc
            if (r1 != 0) goto L27
            goto L3
        L27:
            boolean r4 = r1 instanceof byte[]
            r5 = -1
            if (r4 == 0) goto L53
            r4 = r1
            byte[] r4 = (byte[]) r4
            int r1 = r4.length
            int r6 = r1 + (-1)
            int r1 = r10.hashCode()
            int r1 = com.google.android.gms.internal.play_billing.zzbp.zza(r1)
        L3a:
            r1 = r1 & r6
            r5 = r4[r1]
            r7 = 255(0xff, float:3.57E-43)
            r5 = r5 & r7
            if (r5 != r7) goto L43
            goto L3
        L43:
            r7 = r2[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L50
            r10 = r5 ^ 1
            r10 = r2[r10]
            goto L9e
        L50:
            int r1 = r1 + 1
            goto L3a
        L53:
            boolean r4 = r1 instanceof short[]
            if (r4 == 0) goto L7f
            r4 = r1
            short[] r4 = (short[]) r4
            int r1 = r4.length
            int r6 = r1 + (-1)
            int r1 = r10.hashCode()
            int r1 = com.google.android.gms.internal.play_billing.zzbp.zza(r1)
        L65:
            r1 = r1 & r6
            short r5 = r4[r1]
            char r5 = (char) r5
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r5 != r7) goto L6f
            goto L3
        L6f:
            r7 = r2[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L7c
            r10 = r5 ^ 1
            r10 = r2[r10]
            goto L9e
        L7c:
            int r1 = r1 + 1
            goto L65
        L7f:
            int[] r1 = (int[]) r1
            int r4 = r1.length
            int r4 = r4 + r5
            int r6 = r10.hashCode()
            int r6 = com.google.android.gms.internal.play_billing.zzbp.zza(r6)
        L8b:
            r6 = r6 & r4
            r7 = r1[r6]
            if (r7 != r5) goto L92
            goto L3
        L92:
            r8 = r2[r7]
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto La2
            r10 = r7 ^ 1
            r10 = r2[r10]
        L9e:
            if (r10 != 0) goto La1
            return r0
        La1:
            return r10
        La2:
            int r6 = r6 + 1
            goto L8b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzcf.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw
    final zzbq zza() {
        return new zzce(this.zzb, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw
    final zzbx zzd() {
        return new zzcc(this, this.zzb, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw
    final zzbx zze() {
        return new zzcd(this, new zzce(this.zzb, 0, this.zzd));
    }
}
