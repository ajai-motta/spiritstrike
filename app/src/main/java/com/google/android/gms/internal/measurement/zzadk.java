package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzadk {
    private static final zzadk zzd = new zzadk(true);
    final zzafv zza = new zzafr();
    boolean zzb;
    boolean zzc;

    private zzadk() {
    }

    public static zzadk zza() {
        return zzd;
    }

    static void zzf(zzada zzadaVar, zzagm zzagmVar, int i, Object obj) throws IOException {
        if (zzagmVar == zzagm.GROUP) {
            zzadaVar.zzb(i, 3);
            ((zzafc) obj).zzcH(zzadaVar);
            zzadaVar.zzb(i, 4);
            return;
        }
        zzadaVar.zzb(i, zzagmVar.zzb());
        zzagn zzagnVar = zzagn.INT;
        switch (zzagmVar) {
            case DOUBLE:
                zzadaVar.zzu(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case FLOAT:
                zzadaVar.zzs(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case INT64:
                zzadaVar.zzt(((Long) obj).longValue());
                break;
            case UINT64:
                zzadaVar.zzt(((Long) obj).longValue());
                break;
            case INT32:
                zzadaVar.zzq(((Integer) obj).intValue());
                break;
            case FIXED64:
                zzadaVar.zzu(((Long) obj).longValue());
                break;
            case FIXED32:
                zzadaVar.zzs(((Integer) obj).intValue());
                break;
            case BOOL:
                zzadaVar.zzp(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case STRING:
                if (!(obj instanceof zzacr)) {
                    zzadaVar.zzw((String) obj);
                } else {
                    zzadaVar.zzk((zzacr) obj);
                }
                break;
            case GROUP:
                ((zzafc) obj).zzcH(zzadaVar);
                break;
            case MESSAGE:
                zzadaVar.zzo((zzafc) obj);
                break;
            case BYTES:
                if (!(obj instanceof zzacr)) {
                    byte[] bArr = (byte[]) obj;
                    zzadaVar.zzl(bArr, 0, bArr.length);
                } else {
                    zzadaVar.zzk((zzacr) obj);
                }
                break;
            case UINT32:
                zzadaVar.zzr(((Integer) obj).intValue());
                break;
            case ENUM:
                if (!(obj instanceof zzady)) {
                    zzadaVar.zzq(((Integer) obj).intValue());
                } else {
                    zzadaVar.zzq(((zzady) obj).zza());
                }
                break;
            case SFIXED32:
                zzadaVar.zzs(((Integer) obj).intValue());
                break;
            case SFIXED64:
                zzadaVar.zzu(((Long) obj).longValue());
                break;
            case SINT32:
                int iIntValue = ((Integer) obj).intValue();
                zzadaVar.zzr((iIntValue >> 31) ^ (iIntValue + iIntValue));
                break;
            case SINT64:
                long jLongValue = ((Long) obj).longValue();
                zzadaVar.zzt((jLongValue >> 63) ^ (jLongValue + jLongValue));
                break;
        }
    }

    static int zzh(zzagm zzagmVar, int i, Object obj) {
        int iZzE = zzada.zzE(i << 3);
        if (zzagmVar == zzagm.GROUP) {
            iZzE += iZzE;
        }
        return iZzE + zzi(zzagmVar, obj);
    }

    static int zzi(zzagm zzagmVar, Object obj) {
        int iZzb;
        int iZzE;
        zzagm zzagmVar2 = zzagm.DOUBLE;
        zzagn zzagnVar = zzagn.INT;
        switch (zzagmVar) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                int i = zzada.zzb;
                return 8;
            case FLOAT:
                ((Float) obj).floatValue();
                int i2 = zzada.zzb;
                return 4;
            case INT64:
                return zzada.zzF(((Long) obj).longValue());
            case UINT64:
                return zzada.zzF(((Long) obj).longValue());
            case INT32:
                return zzada.zzF(((Integer) obj).intValue());
            case FIXED64:
                ((Long) obj).longValue();
                int i3 = zzada.zzb;
                return 8;
            case FIXED32:
                ((Integer) obj).intValue();
                int i4 = zzada.zzb;
                return 4;
            case BOOL:
                ((Boolean) obj).booleanValue();
                int i5 = zzada.zzb;
                return 1;
            case STRING:
                if (!(obj instanceof zzacr)) {
                    int i6 = zzada.zzb;
                    iZzb = zzagl.zzb((String) obj);
                    iZzE = zzada.zzE(iZzb);
                } else {
                    int i7 = zzada.zzb;
                    iZzb = ((zzacr) obj).zzb();
                    iZzE = zzada.zzE(iZzb);
                }
                break;
            case GROUP:
                return ((zzafc) obj).zzcq();
            case MESSAGE:
                if (!(obj instanceof zzael)) {
                    return zzada.zzG((zzafc) obj);
                }
                iZzb = ((zzael) obj).zzb();
                iZzE = zzada.zzE(iZzb);
                break;
                break;
            case BYTES:
                if (!(obj instanceof zzacr)) {
                    int i8 = zzada.zzb;
                    iZzb = ((byte[]) obj).length;
                    iZzE = zzada.zzE(iZzb);
                } else {
                    int i9 = zzada.zzb;
                    iZzb = ((zzacr) obj).zzb();
                    iZzE = zzada.zzE(iZzb);
                }
                break;
            case UINT32:
                return zzada.zzE(((Integer) obj).intValue());
            case ENUM:
                return obj instanceof zzady ? zzada.zzF(((zzady) obj).zza()) : zzada.zzF(((Integer) obj).intValue());
            case SFIXED32:
                ((Integer) obj).intValue();
                int i10 = zzada.zzb;
                return 4;
            case SFIXED64:
                ((Long) obj).longValue();
                int i11 = zzada.zzb;
                return 8;
            case SINT32:
                int iIntValue = ((Integer) obj).intValue();
                return zzada.zzE((iIntValue >> 31) ^ (iIntValue + iIntValue));
            case SINT64:
                long jLongValue = ((Long) obj).longValue();
                return zzada.zzF((jLongValue >> 63) ^ (jLongValue + jLongValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return iZzE + iZzb;
    }

    public static int zzj(zzadj zzadjVar, Object obj) {
        zzagm zzagmVarZzb = zzadjVar.zzb();
        int iZza = zzadjVar.zza();
        if (!zzadjVar.zzd()) {
            return zzh(zzagmVarZzb, iZza, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i = 0;
        if (!zzadjVar.zze()) {
            int iZzh = 0;
            while (i < size) {
                iZzh += zzh(zzagmVarZzb, iZza, list.get(i));
                i++;
            }
            return iZzh;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iZzi = 0;
        while (i < size) {
            iZzi += zzi(zzagmVarZzb, list.get(i));
            i++;
        }
        return zzada.zzE(iZza << 3) + iZzi + zzada.zzE(iZzi);
    }

    private static boolean zzk(Map.Entry entry) {
        zzadj zzadjVar = (zzadj) entry.getKey();
        if (zzadjVar.zzc() != zzagn.MESSAGE) {
            return true;
        }
        if (!zzadjVar.zzd()) {
            return zzl(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!zzl(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzl(Object obj) {
        if (obj instanceof zzafd) {
            return ((zzafd) obj).zzcJ();
        }
        if (obj instanceof zzael) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzm(Map.Entry entry) {
        int i;
        int iZzE;
        int iZzE2;
        zzadj zzadjVar = (zzadj) entry.getKey();
        Object value = entry.getValue();
        if (zzadjVar.zzc() != zzagn.MESSAGE || zzadjVar.zzd() || zzadjVar.zze()) {
            return zzj(zzadjVar, value);
        }
        if (value instanceof zzael) {
            int iZza = ((zzadj) entry.getKey()).zza();
            int iZzE3 = zzada.zzE(8);
            i = iZzE3 + iZzE3;
            iZzE = zzada.zzE(16) + zzada.zzE(iZza);
            int iZzE4 = zzada.zzE(24);
            int iZzb = ((zzael) value).zzb();
            iZzE2 = iZzE4 + zzada.zzE(iZzb) + iZzb;
        } else {
            int iZza2 = ((zzadj) entry.getKey()).zza();
            int iZzE5 = zzada.zzE(8);
            i = iZzE5 + iZzE5;
            iZzE = zzada.zzE(16) + zzada.zzE(iZza2);
            iZzE2 = zzada.zzE(24) + zzada.zzG((zzafc) value);
        }
        return i + iZzE + iZzE2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void zzn(com.google.android.gms.internal.measurement.zzadj r4, java.lang.Object r5) {
        /*
            com.google.android.gms.internal.measurement.zzagm r0 = r4.zzb()
            r5.getClass()
            com.google.android.gms.internal.measurement.zzagm r1 = com.google.android.gms.internal.measurement.zzagm.DOUBLE
            com.google.android.gms.internal.measurement.zzagn r1 = com.google.android.gms.internal.measurement.zzagn.INT
            com.google.android.gms.internal.measurement.zzagn r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L41;
                case 1: goto L3e;
                case 2: goto L3b;
                case 3: goto L38;
                case 4: goto L35;
                case 5: goto L32;
                case 6: goto L29;
                case 7: goto L20;
                case 8: goto L17;
                default: goto L16;
            }
        L16:
            goto L46
        L17:
            boolean r0 = r5 instanceof com.google.android.gms.internal.measurement.zzafc
            if (r0 != 0) goto L45
            boolean r0 = r5 instanceof com.google.android.gms.internal.measurement.zzael
            if (r0 == 0) goto L46
            goto L45
        L20:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L45
            boolean r0 = r5 instanceof com.google.android.gms.internal.measurement.zzady
            if (r0 == 0) goto L46
            goto L45
        L29:
            boolean r0 = r5 instanceof com.google.android.gms.internal.measurement.zzacr
            if (r0 != 0) goto L45
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L46
            goto L45
        L32:
            boolean r0 = r5 instanceof java.lang.String
            goto L43
        L35:
            boolean r0 = r5 instanceof java.lang.Boolean
            goto L43
        L38:
            boolean r0 = r5 instanceof java.lang.Double
            goto L43
        L3b:
            boolean r0 = r5 instanceof java.lang.Float
            goto L43
        L3e:
            boolean r0 = r5 instanceof java.lang.Long
            goto L43
        L41:
            boolean r0 = r5 instanceof java.lang.Integer
        L43:
            if (r0 == 0) goto L46
        L45:
            return
        L46:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r4.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.gms.internal.measurement.zzagm r4 = r4.zzb()
            com.google.android.gms.internal.measurement.zzagn r4 = r4.zza()
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzadk.zzn(com.google.android.gms.internal.measurement.zzadj, java.lang.Object):void");
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzadk zzadkVar = new zzadk();
        zzafv zzafvVar = this.zza;
        int iZzc = zzafvVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Map.Entry entryZzd = zzafvVar.zzd(i);
            zzadkVar.zzd((zzadj) ((zzafs) entryZzd).zza(), entryZzd.getValue());
        }
        for (Map.Entry entry : zzafvVar.zze()) {
            zzadkVar.zzd((zzadj) entry.getKey(), entry.getValue());
        }
        zzadkVar.zzc = this.zzc;
        return zzadkVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzadk) {
            return this.zza.equals(((zzadk) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        zzafv zzafvVar = this.zza;
        int iZzc = zzafvVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Object value = zzafvVar.zzd(i).getValue();
            if (value instanceof zzadu) {
                ((zzadu) value).zzcm();
            }
        }
        Iterator it = zzafvVar.zze().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzadu) {
                ((zzadu) value2).zzcm();
            }
        }
        zzafvVar.zza();
        this.zzb = true;
    }

    public final Iterator zzc() {
        zzafv zzafvVar = this.zza;
        return zzafvVar.isEmpty() ? Collections.emptyIterator() : this.zzc ? new zzaek(zzafvVar.entrySet().iterator()) : zzafvVar.entrySet().iterator();
    }

    public final void zzd(zzadj zzadjVar, Object obj) {
        if (!zzadjVar.zzd()) {
            zzn(zzadjVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzn(zzadjVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzael) {
            this.zzc = true;
        }
        this.zza.put(zzadjVar, obj);
    }

    public final boolean zze() {
        zzafv zzafvVar = this.zza;
        int iZzc = zzafvVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            if (!zzk(zzafvVar.zzd(i))) {
                return false;
            }
        }
        Iterator it = zzafvVar.zze().iterator();
        while (it.hasNext()) {
            if (!zzk((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int zzg() {
        zzafv zzafvVar = this.zza;
        int iZzc = zzafvVar.zzc();
        int iZzm = 0;
        for (int i = 0; i < iZzc; i++) {
            iZzm += zzm(zzafvVar.zzd(i));
        }
        Iterator it = zzafvVar.zze().iterator();
        while (it.hasNext()) {
            iZzm += zzm((Map.Entry) it.next());
        }
        return iZzm;
    }

    private zzadk(boolean z) {
        zzb();
        zzb();
    }
}
