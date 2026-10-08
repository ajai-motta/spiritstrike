package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzabv {
    private static final zzabv zzb = new zzabv(true);
    final zzaef zza = new zzaea();
    private boolean zzc;
    private boolean zzd;

    private zzabv() {
    }

    static int zza(zzaex zzaexVar, int i, Object obj) {
        int iZzd;
        int iZzC;
        int iZzC2 = zzzi.zzC(i << 3);
        if (zzaexVar == zzaex.GROUP) {
            zzadl zzadlVar = (zzadl) obj;
            byte[] bArr = zzaco.zzb;
            if (zzadlVar instanceof zzyi) {
                throw null;
            }
            iZzC2 += iZzC2;
        }
        zzaey zzaeyVar = zzaey.INT;
        int iZzD = 4;
        switch (zzaexVar) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                iZzD = 8;
                return iZzC2 + iZzD;
            case FLOAT:
                ((Float) obj).floatValue();
                return iZzC2 + iZzD;
            case INT64:
                iZzD = zzzi.zzD(((Long) obj).longValue());
                return iZzC2 + iZzD;
            case UINT64:
                iZzD = zzzi.zzD(((Long) obj).longValue());
                return iZzC2 + iZzD;
            case INT32:
                iZzD = zzzi.zzD(((Integer) obj).intValue());
                return iZzC2 + iZzD;
            case FIXED64:
                ((Long) obj).longValue();
                iZzD = 8;
                return iZzC2 + iZzD;
            case FIXED32:
                ((Integer) obj).intValue();
                return iZzC2 + iZzD;
            case BOOL:
                ((Boolean) obj).booleanValue();
                iZzD = 1;
                return iZzC2 + iZzD;
            case STRING:
                if (!(obj instanceof zzyx)) {
                    iZzD = zzzi.zzB((String) obj);
                    return iZzC2 + iZzD;
                }
                iZzd = ((zzyx) obj).zzd();
                iZzC = zzzi.zzC(iZzd);
                iZzD = iZzC + iZzd;
                return iZzC2 + iZzD;
            case GROUP:
                iZzD = ((zzadl) obj).zzY();
                return iZzC2 + iZzD;
            case MESSAGE:
                if (!(obj instanceof zzacv)) {
                    iZzD = zzzi.zzz((zzadl) obj);
                    return iZzC2 + iZzD;
                }
                iZzd = ((zzacv) obj).zza();
                iZzC = zzzi.zzC(iZzd);
                iZzD = iZzC + iZzd;
                return iZzC2 + iZzD;
            case BYTES:
                if (obj instanceof zzyx) {
                    iZzd = ((zzyx) obj).zzd();
                    iZzC = zzzi.zzC(iZzd);
                } else {
                    iZzd = ((byte[]) obj).length;
                    iZzC = zzzi.zzC(iZzd);
                }
                iZzD = iZzC + iZzd;
                return iZzC2 + iZzD;
            case UINT32:
                iZzD = zzzi.zzC(((Integer) obj).intValue());
                return iZzC2 + iZzD;
            case ENUM:
                iZzD = obj instanceof zzach ? zzzi.zzD(((zzach) obj).zza()) : zzzi.zzD(((Integer) obj).intValue());
                return iZzC2 + iZzD;
            case SFIXED32:
                ((Integer) obj).intValue();
                return iZzC2 + iZzD;
            case SFIXED64:
                ((Long) obj).longValue();
                iZzD = 8;
                return iZzC2 + iZzD;
            case SINT32:
                int iIntValue = ((Integer) obj).intValue();
                iZzD = zzzi.zzC((iIntValue >> 31) ^ (iIntValue + iIntValue));
                return iZzC2 + iZzD;
            case SINT64:
                long jLongValue = ((Long) obj).longValue();
                iZzD = zzzi.zzD((jLongValue >> 63) ^ (jLongValue + jLongValue));
                return iZzC2 + iZzD;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzb(zzabu zzabuVar, Object obj) {
        zzaex zzaexVarZzd = zzabuVar.zzd();
        int iZza = zzabuVar.zza();
        if (!zzabuVar.zzg()) {
            return zza(zzaexVarZzd, iZza, obj);
        }
        List list = (List) obj;
        int size = list.size();
        zzabuVar.zzf();
        int iZza2 = 0;
        for (int i = 0; i < size; i++) {
            iZza2 += zza(zzaexVarZzd, iZza, list.get(i));
        }
        return iZza2;
    }

    public static zzabv zze() {
        return zzb;
    }

    private static Object zzn(Object obj) {
        if (obj instanceof zzadq) {
            return ((zzadq) obj).zzc();
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

    private final void zzo(Map.Entry entry) {
        zzabu zzabuVar = (zzabu) entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zzacv;
        if (zzabuVar.zzg()) {
            if (z) {
                throw new IllegalStateException("Lazy fields can not be repeated");
            }
            Object objZzf = zzf(zzabuVar);
            List list = (List) value;
            int size = list.size();
            if (objZzf == null) {
                objZzf = new ArrayList(size);
            }
            List list2 = (List) objZzf;
            for (int i = 0; i < size; i++) {
                list2.add(zzn(list.get(i)));
            }
            this.zza.put(zzabuVar, objZzf);
            return;
        }
        if (zzabuVar.zze() != zzaey.MESSAGE) {
            if (z) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.zza.put(zzabuVar, zzn(value));
            return;
        }
        Object objZzf2 = zzf(zzabuVar);
        if (objZzf2 == null) {
            this.zza.put(zzabuVar, zzn(value));
            if (z) {
                this.zzd = true;
                return;
            }
            return;
        }
        if (z) {
            throw null;
        }
        this.zza.put(zzabuVar, objZzf2 instanceof zzadq ? zzabuVar.zzc((zzadq) objZzf2, (zzadq) value) : zzabuVar.zzb(((zzadl) objZzf2).zzaw(), (zzadl) value).zzD());
    }

    private static boolean zzp(Map.Entry entry) {
        zzabu zzabuVar = (zzabu) entry.getKey();
        if (zzabuVar.zze() != zzaey.MESSAGE) {
            return true;
        }
        if (!zzabuVar.zzg()) {
            return zzq(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!zzq(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzq(Object obj) {
        if (obj instanceof zzadm) {
            return ((zzadm) obj).zzaz();
        }
        if (obj instanceof zzacv) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzr(Map.Entry entry) {
        int i;
        int iZzC;
        int iZzC2;
        zzabu zzabuVar = (zzabu) entry.getKey();
        Object value = entry.getValue();
        if (zzabuVar.zze() != zzaey.MESSAGE || zzabuVar.zzg()) {
            return zzb(zzabuVar, value);
        }
        zzabuVar.zzf();
        if (value instanceof zzacv) {
            int iZza = ((zzabu) entry.getKey()).zza();
            int iZzC3 = zzzi.zzC(8);
            i = iZzC3 + iZzC3;
            iZzC = zzzi.zzC(16) + zzzi.zzC(iZza);
            int iZzC4 = zzzi.zzC(24);
            int iZza2 = ((zzacv) value).zza();
            iZzC2 = iZzC4 + zzzi.zzC(iZza2) + iZza2;
        } else {
            int iZza3 = ((zzabu) entry.getKey()).zza();
            int iZzC5 = zzzi.zzC(8);
            i = iZzC5 + iZzC5;
            iZzC = zzzi.zzC(16) + zzzi.zzC(iZza3);
            iZzC2 = zzzi.zzC(24) + zzzi.zzz((zzadl) value);
        }
        return i + iZzC + iZzC2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void zzs(com.google.android.gms.internal.gtm.zzabu r4, java.lang.Object r5) {
        /*
            com.google.android.gms.internal.gtm.zzaex r0 = r4.zzd()
            byte[] r1 = com.google.android.gms.internal.gtm.zzaco.zzb
            r5.getClass()
            com.google.android.gms.internal.gtm.zzaex r1 = com.google.android.gms.internal.gtm.zzaex.DOUBLE
            com.google.android.gms.internal.gtm.zzaey r1 = com.google.android.gms.internal.gtm.zzaey.INT
            com.google.android.gms.internal.gtm.zzaey r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L43;
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L2b;
                case 7: goto L22;
                case 8: goto L19;
                default: goto L18;
            }
        L18:
            goto L48
        L19:
            boolean r0 = r5 instanceof com.google.android.gms.internal.gtm.zzadl
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof com.google.android.gms.internal.gtm.zzacv
            if (r0 == 0) goto L48
            goto L47
        L22:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof com.google.android.gms.internal.gtm.zzach
            if (r0 == 0) goto L48
            goto L47
        L2b:
            boolean r0 = r5 instanceof com.google.android.gms.internal.gtm.zzyx
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L48
            goto L47
        L34:
            boolean r0 = r5 instanceof java.lang.String
            goto L45
        L37:
            boolean r0 = r5 instanceof java.lang.Boolean
            goto L45
        L3a:
            boolean r0 = r5 instanceof java.lang.Double
            goto L45
        L3d:
            boolean r0 = r5 instanceof java.lang.Float
            goto L45
        L40:
            boolean r0 = r5 instanceof java.lang.Long
            goto L45
        L43:
            boolean r0 = r5 instanceof java.lang.Integer
        L45:
            if (r0 == 0) goto L48
        L47:
            return
        L48:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r4.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.gms.internal.gtm.zzaex r4 = r4.zzd()
            com.google.android.gms.internal.gtm.zzaey r4 = r4.zza()
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getName()
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r1
            r1 = 1
            r2[r1] = r4
            r4 = 2
            r2[r4] = r5
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r4 = java.lang.String.format(r4, r2)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzabv.zzs(com.google.android.gms.internal.gtm.zzabu, java.lang.Object):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzabv) {
            return this.zza.equals(((zzabv) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzc() {
        int iZzc = this.zza.zzc();
        int iZzr = 0;
        for (int i = 0; i < iZzc; i++) {
            iZzr += zzr(this.zza.zzg(i));
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            iZzr += zzr((Map.Entry) it.next());
        }
        return iZzr;
    }

    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzabv clone() {
        zzabv zzabvVar = new zzabv();
        int iZzc = this.zza.zzc();
        for (int i = 0; i < iZzc; i++) {
            Map.Entry entryZzg = this.zza.zzg(i);
            zzabvVar.zzk((zzabu) ((zzaeb) entryZzg).zza(), entryZzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzd()) {
            zzabvVar.zzk((zzabu) entry.getKey(), entry.getValue());
        }
        zzabvVar.zzd = this.zzd;
        return zzabvVar;
    }

    public final Object zzf(zzabu zzabuVar) {
        Object obj = this.zza.get(zzabuVar);
        if (!(obj instanceof zzacv)) {
            return obj;
        }
        throw null;
    }

    public final Iterator zzg() {
        return this.zza.isEmpty() ? Collections.emptyIterator() : this.zzd ? new zzact(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zzh(zzabu zzabuVar, Object obj) {
        List arrayList;
        if (!((zzacd) zzabuVar).zzd) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        zzs(zzabuVar, obj);
        Object objZzf = zzf(zzabuVar);
        if (objZzf == null) {
            arrayList = new ArrayList();
            this.zza.put(zzabuVar, arrayList);
        } else {
            arrayList = (List) objZzf;
        }
        arrayList.add(obj);
    }

    public final void zzi() {
        if (this.zzc) {
            return;
        }
        int iZzc = this.zza.zzc();
        for (int i = 0; i < iZzc; i++) {
            Object value = this.zza.zzg(i).getValue();
            if (value instanceof zzacf) {
                ((zzacf) value).zzam();
            }
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzacf) {
                ((zzacf) value2).zzam();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzj(zzabv zzabvVar) {
        int iZzc = zzabvVar.zza.zzc();
        for (int i = 0; i < iZzc; i++) {
            zzo(zzabvVar.zza.zzg(i));
        }
        Iterator it = zzabvVar.zza.zzd().iterator();
        while (it.hasNext()) {
            zzo((Map.Entry) it.next());
        }
    }

    public final void zzk(zzabu zzabuVar, Object obj) {
        if (!zzabuVar.zzg()) {
            zzs(zzabuVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzs(zzabuVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzacv) {
            this.zzd = true;
        }
        this.zza.put(zzabuVar, obj);
    }

    public final boolean zzl() {
        return this.zzc;
    }

    public final boolean zzm() {
        int iZzc = this.zza.zzc();
        for (int i = 0; i < iZzc; i++) {
            if (!zzp(this.zza.zzg(i))) {
                return false;
            }
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            if (!zzp((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzabv(boolean z) {
        zzi();
        zzi();
    }
}
