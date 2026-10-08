package com.google.android.recaptcha.internal;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzsd {
    private static final zzsd zzb = new zzsd(true);
    final zzuo zza = new zzuj();
    private boolean zzc;
    private boolean zzd;

    private zzsd() {
    }

    public static int zza(zzsc zzscVar, Object obj) {
        int iZzd;
        int iZzA;
        zzvg zzvgVarZzd = zzscVar.zzd();
        int iZza = zzscVar.zza();
        zzscVar.zzg();
        int iZzA2 = zzqv.zzA(iZza << 3);
        if (zzvgVarZzd == zzvg.GROUP) {
            zzts zztsVar = (zzts) obj;
            byte[] bArr = zzsv.zzb;
            if (zztsVar instanceof zzpx) {
                throw null;
            }
            iZzA2 += iZzA2;
        }
        zzvh zzvhVar = zzvh.INT;
        int iZzB = 4;
        switch (zzvgVarZzd.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                iZzB = 8;
                return iZzA2 + iZzB;
            case 1:
                ((Float) obj).floatValue();
                return iZzA2 + iZzB;
            case 2:
                iZzB = zzqv.zzB(((Long) obj).longValue());
                return iZzA2 + iZzB;
            case 3:
                iZzB = zzqv.zzB(((Long) obj).longValue());
                return iZzA2 + iZzB;
            case 4:
                iZzB = zzqv.zzB(((Integer) obj).intValue());
                return iZzA2 + iZzB;
            case 5:
                ((Long) obj).longValue();
                iZzB = 8;
                return iZzA2 + iZzB;
            case 6:
                ((Integer) obj).intValue();
                return iZzA2 + iZzB;
            case 7:
                ((Boolean) obj).booleanValue();
                iZzB = 1;
                return iZzA2 + iZzB;
            case 8:
                if (!(obj instanceof zzqm)) {
                    iZzB = zzqv.zzz((String) obj);
                    return iZzA2 + iZzB;
                }
                iZzd = ((zzqm) obj).zzd();
                iZzA = zzqv.zzA(iZzd);
                iZzB = iZzA + iZzd;
                return iZzA2 + iZzB;
            case 9:
                iZzB = ((zzts) obj).zzo();
                return iZzA2 + iZzB;
            case 10:
                if (!(obj instanceof zztc)) {
                    iZzB = zzqv.zzx((zzts) obj);
                    return iZzA2 + iZzB;
                }
                iZzd = ((zztc) obj).zza();
                iZzA = zzqv.zzA(iZzd);
                iZzB = iZzA + iZzd;
                return iZzA2 + iZzB;
            case 11:
                if (obj instanceof zzqm) {
                    iZzd = ((zzqm) obj).zzd();
                    iZzA = zzqv.zzA(iZzd);
                } else {
                    iZzd = ((byte[]) obj).length;
                    iZzA = zzqv.zzA(iZzd);
                }
                iZzB = iZzA + iZzd;
                return iZzA2 + iZzB;
            case 12:
                iZzB = zzqv.zzA(((Integer) obj).intValue());
                return iZzA2 + iZzB;
            case 13:
                iZzB = obj instanceof zzsp ? zzqv.zzB(((zzsp) obj).zza()) : zzqv.zzB(((Integer) obj).intValue());
                return iZzA2 + iZzB;
            case 14:
                ((Integer) obj).intValue();
                return iZzA2 + iZzB;
            case 15:
                ((Long) obj).longValue();
                iZzB = 8;
                return iZzA2 + iZzB;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                iZzB = zzqv.zzA((iIntValue >> 31) ^ (iIntValue + iIntValue));
                return iZzA2 + iZzB;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                iZzB = zzqv.zzB((jLongValue >> 63) ^ (jLongValue + jLongValue));
                return iZzA2 + iZzB;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static zzsd zzd() {
        return zzb;
    }

    private static Object zzl(Object obj) {
        if (obj instanceof zztx) {
            return ((zztx) obj).zzd();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private final void zzm(Map.Entry entry) {
        zzsc zzscVar = (zzsc) entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zztc;
        zzscVar.zzg();
        if (zzscVar.zze() != zzvh.MESSAGE) {
            if (z) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.zza.put(zzscVar, zzl(value));
            return;
        }
        Object objZze = zze(zzscVar);
        if (objZze == null) {
            this.zza.put(zzscVar, zzl(value));
            if (z) {
                this.zzd = true;
                return;
            }
            return;
        }
        if (z) {
            throw null;
        }
        this.zza.put(zzscVar, objZze instanceof zztx ? zzscVar.zzc((zztx) objZze, (zztx) value) : zzscVar.zzb(((zzts) objZze).zzag(), (zzts) value).zzk());
    }

    private static boolean zzn(Map.Entry entry) {
        zzsc zzscVar = (zzsc) entry.getKey();
        if (zzscVar.zze() != zzvh.MESSAGE) {
            return true;
        }
        zzscVar.zzg();
        Object value = entry.getValue();
        if (value instanceof zztt) {
            return ((zztt) value).zzp();
        }
        if (value instanceof zztc) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzo(Map.Entry entry) {
        int i;
        int iZzA;
        int iZzA2;
        zzsc zzscVar = (zzsc) entry.getKey();
        Object value = entry.getValue();
        if (zzscVar.zze() != zzvh.MESSAGE) {
            return zza(zzscVar, value);
        }
        zzscVar.zzg();
        zzscVar.zzf();
        if (value instanceof zztc) {
            int iZza = ((zzsc) entry.getKey()).zza();
            int iZzA3 = zzqv.zzA(8);
            i = iZzA3 + iZzA3;
            iZzA = zzqv.zzA(16) + zzqv.zzA(iZza);
            int iZzA4 = zzqv.zzA(24);
            int iZza2 = ((zztc) value).zza();
            iZzA2 = iZzA4 + zzqv.zzA(iZza2) + iZza2;
        } else {
            int iZza3 = ((zzsc) entry.getKey()).zza();
            int iZzA5 = zzqv.zzA(8);
            i = iZzA5 + iZzA5;
            iZzA = zzqv.zzA(16) + zzqv.zzA(iZza3);
            iZzA2 = zzqv.zzA(24) + zzqv.zzx((zzts) value);
        }
        return i + iZzA + iZzA2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzsd) {
            return this.zza.equals(((zzsd) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzb() {
        zzuo zzuoVar = this.zza;
        int iZzc = zzuoVar.zzc();
        int iZzo = 0;
        for (int i = 0; i < iZzc; i++) {
            iZzo += zzo(zzuoVar.zzg(i));
        }
        Iterator it = zzuoVar.zzd().iterator();
        while (it.hasNext()) {
            iZzo += zzo((Map.Entry) it.next());
        }
        return iZzo;
    }

    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzsd clone() {
        zzsd zzsdVar = new zzsd();
        zzuo zzuoVar = this.zza;
        int iZzc = zzuoVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Map.Entry entryZzg = zzuoVar.zzg(i);
            zzsdVar.zzi((zzsc) ((zzuk) entryZzg).zza(), entryZzg.getValue());
        }
        for (Map.Entry entry : zzuoVar.zzd()) {
            zzsdVar.zzi((zzsc) entry.getKey(), entry.getValue());
        }
        zzsdVar.zzd = this.zzd;
        return zzsdVar;
    }

    public final Object zze(zzsc zzscVar) {
        Object obj = this.zza.get(zzscVar);
        if (!(obj instanceof zztc)) {
            return obj;
        }
        throw null;
    }

    public final Iterator zzf() {
        zzuo zzuoVar = this.zza;
        return zzuoVar.isEmpty() ? Collections.emptyIterator() : this.zzd ? new zzta(zzuoVar.entrySet().iterator()) : zzuoVar.entrySet().iterator();
    }

    public final void zzg() {
        if (this.zzc) {
            return;
        }
        zzuo zzuoVar = this.zza;
        int iZzc = zzuoVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Object value = zzuoVar.zzg(i).getValue();
            if (value instanceof zzsn) {
                ((zzsn) value).zzG();
            }
        }
        Iterator it = zzuoVar.zzd().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzsn) {
                ((zzsn) value2).zzG();
            }
        }
        zzuoVar.zza();
        this.zzc = true;
    }

    public final void zzh(zzsd zzsdVar) {
        zzuo zzuoVar = zzsdVar.zza;
        int iZzc = zzuoVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            zzm(zzuoVar.zzg(i));
        }
        Iterator it = zzuoVar.zzd().iterator();
        while (it.hasNext()) {
            zzm((Map.Entry) it.next());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
    
        if ((r7 instanceof com.google.android.recaptcha.internal.zzsp) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        if ((r7 instanceof byte[]) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
    
        if (r0 == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
    
        if ((r7 instanceof com.google.android.recaptcha.internal.zztc) == false) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzi(com.google.android.recaptcha.internal.zzsc r6, java.lang.Object r7) {
        /*
            r5 = this;
            r6.zzg()
            com.google.android.recaptcha.internal.zzvg r0 = r6.zzd()
            byte[] r1 = com.google.android.recaptcha.internal.zzsv.zzb
            r7.getClass()
            com.google.android.recaptcha.internal.zzvg r1 = com.google.android.recaptcha.internal.zzvg.DOUBLE
            com.google.android.recaptcha.internal.zzvh r1 = com.google.android.recaptcha.internal.zzvh.INT
            com.google.android.recaptcha.internal.zzvh r0 = r0.zza()
            int r0 = r0.ordinal()
            r1 = 1
            switch(r0) {
                case 0: goto L47;
                case 1: goto L44;
                case 2: goto L41;
                case 3: goto L3e;
                case 4: goto L3b;
                case 5: goto L38;
                case 6: goto L2f;
                case 7: goto L26;
                case 8: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L57
        L1d:
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzts
            if (r0 != 0) goto L4b
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zztc
            if (r0 == 0) goto L57
            goto L4b
        L26:
            boolean r0 = r7 instanceof java.lang.Integer
            if (r0 != 0) goto L4b
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzsp
            if (r0 == 0) goto L57
            goto L4b
        L2f:
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzqm
            if (r0 != 0) goto L4b
            boolean r0 = r7 instanceof byte[]
            if (r0 == 0) goto L57
            goto L4b
        L38:
            boolean r0 = r7 instanceof java.lang.String
            goto L49
        L3b:
            boolean r0 = r7 instanceof java.lang.Boolean
            goto L49
        L3e:
            boolean r0 = r7 instanceof java.lang.Double
            goto L49
        L41:
            boolean r0 = r7 instanceof java.lang.Float
            goto L49
        L44:
            boolean r0 = r7 instanceof java.lang.Long
            goto L49
        L47:
            boolean r0 = r7 instanceof java.lang.Integer
        L49:
            if (r0 == 0) goto L57
        L4b:
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zztc
            if (r0 == 0) goto L51
            r5.zzd = r1
        L51:
            com.google.android.recaptcha.internal.zzuo r0 = r5.zza
            r0.put(r6, r7)
            return
        L57:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r2 = r6.zza()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            com.google.android.recaptcha.internal.zzvg r6 = r6.zzd()
            com.google.android.recaptcha.internal.zzvh r6 = r6.zza()
            java.lang.Class r7 = r7.getClass()
            java.lang.String r7 = r7.getName()
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            r3[r4] = r2
            r3[r1] = r6
            r6 = 2
            r3[r6] = r7
            java.lang.String r6 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r6 = java.lang.String.format(r6, r3)
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzsd.zzi(com.google.android.recaptcha.internal.zzsc, java.lang.Object):void");
    }

    public final boolean zzj() {
        return this.zzc;
    }

    public final boolean zzk() {
        zzuo zzuoVar = this.zza;
        int iZzc = zzuoVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            if (!zzn(zzuoVar.zzg(i))) {
                return false;
            }
        }
        Iterator it = zzuoVar.zzd().iterator();
        while (it.hasNext()) {
            if (!zzn((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzsd(boolean z) {
        zzg();
        zzg();
    }
}
