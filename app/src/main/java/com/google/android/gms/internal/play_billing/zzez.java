package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.0.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzez {
    private static final zzez zzb = new zzez(true);
    final zzhd zza = new zzgy();
    private boolean zzc;
    private boolean zzd;

    private zzez() {
    }

    static int zza(zzhs zzhsVar, int i, Object obj) {
        int iZzC = zzep.zzC(i << 3);
        if (zzhsVar == zzhs.GROUP) {
            zzfo.zzd((zzgl) obj);
            iZzC += iZzC;
        }
        return iZzC + zzb(zzhsVar, obj);
    }

    static int zzb(zzhs zzhsVar, Object obj) {
        int iZzd;
        int iZzC;
        zzhs zzhsVar2 = zzhs.DOUBLE;
        zzht zzhtVar = zzht.INT;
        switch (zzhsVar) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                int i = zzep.zzb;
                return 8;
            case FLOAT:
                ((Float) obj).floatValue();
                int i2 = zzep.zzb;
                return 4;
            case INT64:
                return zzep.zzD(((Long) obj).longValue());
            case UINT64:
                return zzep.zzD(((Long) obj).longValue());
            case INT32:
                return zzep.zzD(((Integer) obj).intValue());
            case FIXED64:
                ((Long) obj).longValue();
                int i3 = zzep.zzb;
                return 8;
            case FIXED32:
                ((Integer) obj).intValue();
                int i4 = zzep.zzb;
                return 4;
            case BOOL:
                ((Boolean) obj).booleanValue();
                int i5 = zzep.zzb;
                return 1;
            case STRING:
                if (!(obj instanceof zzei)) {
                    return zzep.zzB((String) obj);
                }
                int i6 = zzep.zzb;
                iZzd = ((zzei) obj).zzd();
                iZzC = zzep.zzC(iZzd);
                break;
                break;
            case GROUP:
                return ((zzgl) obj).zzj();
            case MESSAGE:
                if (!(obj instanceof zzfv)) {
                    return zzep.zzz((zzgl) obj);
                }
                int i7 = zzep.zzb;
                iZzd = ((zzfv) obj).zza();
                iZzC = zzep.zzC(iZzd);
                break;
                break;
            case BYTES:
                if (!(obj instanceof zzei)) {
                    int i8 = zzep.zzb;
                    iZzd = ((byte[]) obj).length;
                    iZzC = zzep.zzC(iZzd);
                } else {
                    int i9 = zzep.zzb;
                    iZzd = ((zzei) obj).zzd();
                    iZzC = zzep.zzC(iZzd);
                }
                break;
            case UINT32:
                return zzep.zzC(((Integer) obj).intValue());
            case ENUM:
                return obj instanceof zzfk ? zzep.zzD(((zzfk) obj).zza()) : zzep.zzD(((Integer) obj).intValue());
            case SFIXED32:
                ((Integer) obj).intValue();
                int i10 = zzep.zzb;
                return 4;
            case SFIXED64:
                ((Long) obj).longValue();
                int i11 = zzep.zzb;
                return 8;
            case SINT32:
                int iIntValue = ((Integer) obj).intValue();
                return zzep.zzC((iIntValue >> 31) ^ (iIntValue + iIntValue));
            case SINT64:
                long jLongValue = ((Long) obj).longValue();
                return zzep.zzD((jLongValue >> 63) ^ (jLongValue + jLongValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return iZzC + iZzd;
    }

    public static int zzc(zzey zzeyVar, Object obj) {
        zzhs zzhsVarZzb = zzeyVar.zzb();
        int iZza = zzeyVar.zza();
        if (!zzeyVar.zze()) {
            return zza(zzhsVarZzb, iZza, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i = 0;
        if (!zzeyVar.zzd()) {
            int iZza2 = 0;
            while (i < size) {
                iZza2 += zza(zzhsVarZzb, iZza, list.get(i));
                i++;
            }
            return iZza2;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iZzb = 0;
        while (i < size) {
            iZzb += zzb(zzhsVarZzb, list.get(i));
            i++;
        }
        return zzep.zzC(iZza << 3) + iZzb + zzep.zzC(iZzb);
    }

    public static zzez zze() {
        return zzb;
    }

    private static boolean zzj(Map.Entry entry) {
        zzey zzeyVar = (zzey) entry.getKey();
        if (zzeyVar.zzc() != zzht.MESSAGE) {
            return true;
        }
        if (!zzeyVar.zze()) {
            return zzk(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!zzk(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzk(Object obj) {
        if (obj instanceof zzgm) {
            return ((zzgm) obj).zzk();
        }
        if (obj instanceof zzfv) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzl(Map.Entry entry) {
        int i;
        int iZzC;
        int iZzC2;
        zzey zzeyVar = (zzey) entry.getKey();
        Object value = entry.getValue();
        if (zzeyVar.zzc() != zzht.MESSAGE || zzeyVar.zze() || zzeyVar.zzd()) {
            return zzc(zzeyVar, value);
        }
        if (value instanceof zzfv) {
            int iZza = ((zzey) entry.getKey()).zza();
            int iZzC3 = zzep.zzC(8);
            i = iZzC3 + iZzC3;
            iZzC = zzep.zzC(16) + zzep.zzC(iZza);
            int iZzC4 = zzep.zzC(24);
            int iZza2 = ((zzfv) value).zza();
            iZzC2 = iZzC4 + zzep.zzC(iZza2) + iZza2;
        } else {
            int iZza3 = ((zzey) entry.getKey()).zza();
            int iZzC5 = zzep.zzC(8);
            i = iZzC5 + iZzC5;
            iZzC = zzep.zzC(16) + zzep.zzC(iZza3);
            iZzC2 = zzep.zzC(24) + zzep.zzz((zzgl) value);
        }
        return i + iZzC + iZzC2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void zzm(com.google.android.gms.internal.play_billing.zzey r4, java.lang.Object r5) {
        /*
            com.google.android.gms.internal.play_billing.zzhs r0 = r4.zzb()
            byte[] r1 = com.google.android.gms.internal.play_billing.zzfo.zzb
            r5.getClass()
            com.google.android.gms.internal.play_billing.zzhs r1 = com.google.android.gms.internal.play_billing.zzhs.DOUBLE
            com.google.android.gms.internal.play_billing.zzht r1 = com.google.android.gms.internal.play_billing.zzht.INT
            com.google.android.gms.internal.play_billing.zzht r0 = r0.zza()
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
            boolean r0 = r5 instanceof com.google.android.gms.internal.play_billing.zzgl
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof com.google.android.gms.internal.play_billing.zzfv
            if (r0 == 0) goto L48
            goto L47
        L22:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof com.google.android.gms.internal.play_billing.zzfk
            if (r0 == 0) goto L48
            goto L47
        L2b:
            boolean r0 = r5 instanceof com.google.android.gms.internal.play_billing.zzei
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
            com.google.android.gms.internal.play_billing.zzhs r4 = r4.zzb()
            com.google.android.gms.internal.play_billing.zzht r4 = r4.zza()
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzez.zzm(com.google.android.gms.internal.play_billing.zzey, java.lang.Object):void");
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzez zzezVar = new zzez();
        zzhd zzhdVar = this.zza;
        int iZzc = zzhdVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Map.Entry entryZzg = zzhdVar.zzg(i);
            zzezVar.zzh((zzey) ((zzgz) entryZzg).zza(), entryZzg.getValue());
        }
        for (Map.Entry entry : zzhdVar.zzd()) {
            zzezVar.zzh((zzey) entry.getKey(), entry.getValue());
        }
        zzezVar.zzd = this.zzd;
        return zzezVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzez) {
            return this.zza.equals(((zzez) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzd() {
        zzhd zzhdVar = this.zza;
        int iZzc = zzhdVar.zzc();
        int iZzl = 0;
        for (int i = 0; i < iZzc; i++) {
            iZzl += zzl(zzhdVar.zzg(i));
        }
        Iterator it = zzhdVar.zzd().iterator();
        while (it.hasNext()) {
            iZzl += zzl((Map.Entry) it.next());
        }
        return iZzl;
    }

    public final Iterator zzf() {
        zzhd zzhdVar = this.zza;
        return zzhdVar.isEmpty() ? Collections.emptyIterator() : this.zzd ? new zzft(zzhdVar.entrySet().iterator()) : zzhdVar.entrySet().iterator();
    }

    public final void zzg() {
        if (this.zzc) {
            return;
        }
        zzhd zzhdVar = this.zza;
        int iZzc = zzhdVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Object value = zzhdVar.zzg(i).getValue();
            if (value instanceof zzfi) {
                ((zzfi) value).zzu();
            }
        }
        Iterator it = zzhdVar.zzd().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzfi) {
                ((zzfi) value2).zzu();
            }
        }
        zzhdVar.zza();
        this.zzc = true;
    }

    public final void zzh(zzey zzeyVar, Object obj) {
        if (!zzeyVar.zze()) {
            zzm(zzeyVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzm(zzeyVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzfv) {
            this.zzd = true;
        }
        this.zza.put(zzeyVar, obj);
    }

    public final boolean zzi() {
        zzhd zzhdVar = this.zza;
        int iZzc = zzhdVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            if (!zzj(zzhdVar.zzg(i))) {
                return false;
            }
        }
        Iterator it = zzhdVar.zzd().iterator();
        while (it.hasNext()) {
            if (!zzj((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzez(boolean z) {
        zzg();
        zzg();
    }
}
