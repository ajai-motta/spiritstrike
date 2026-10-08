package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzzj implements zzaez {
    private final zzzi zza;

    private zzzj(zzzi zzziVar) {
        byte[] bArr = zzaco.zzb;
        this.zza = zzziVar;
        zzziVar.zze = this;
    }

    public static zzzj zza(zzzi zzziVar) {
        zzzj zzzjVar = zzziVar.zze;
        return zzzjVar != null ? zzzjVar : new zzzj(zzziVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzB(int i, int i2) throws IOException {
        this.zza.zzt(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzD(int i, long j) throws IOException {
        this.zza.zzv(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    @Deprecated
    public final void zzF(int i) throws IOException {
        this.zza.zzs(i, 3);
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzG(int i, String str) throws IOException {
        this.zza.zzq(i, str);
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzI(int i, int i2) throws IOException {
        this.zza.zzt(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzK(int i, long j) throws IOException {
        this.zza.zzv(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzb(int i, boolean z) throws IOException {
        this.zza.zzK(i, z);
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzd(int i, zzyx zzyxVar) throws IOException {
        this.zza.zzL(i, zzyxVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zze(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzL(i, (zzyx) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzf(int i, double d) throws IOException {
        this.zza.zzj(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    @Deprecated
    public final void zzh(int i) throws IOException {
        this.zza.zzs(i, 4);
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzl(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzm(int i, long j) throws IOException {
        this.zza.zzj(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzo(int i, float f) throws IOException {
        this.zza.zzh(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzq(int i, Object obj, zzadx zzadxVar) throws IOException {
        zzzi zzziVar = this.zza;
        zzziVar.zzs(i, 3);
        zzadxVar.zzj((zzadl) obj, zzziVar.zze);
        zzziVar.zzs(i, 4);
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzr(int i, int i2) throws IOException {
        this.zza.zzl(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzt(int i, long j) throws IOException {
        this.zza.zzv(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzv(int i, Object obj, zzadx zzadxVar) throws IOException {
        this.zza.zzn(i, (zzadl) obj, zzadxVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzw(int i, Object obj) throws IOException {
        if (obj instanceof zzyx) {
            this.zza.zzp(i, (zzyx) obj);
        } else {
            this.zza.zzo(i, (zzadl) obj);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzx(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzz(int i, long j) throws IOException {
        this.zza.zzj(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzH(int i, List list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzacx)) {
            while (i2 < list.size()) {
                this.zza.zzq(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzacx zzacxVar = (zzacx) list;
        while (i2 < list.size()) {
            Object objZzb = zzacxVar.zzb();
            if (objZzb instanceof String) {
                this.zza.zzq(i, (String) objZzb);
            } else {
                this.zza.zzL(i, (zzyx) objZzb);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzJ(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzacg)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzt(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int iZzC = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzC += zzzi.zzC(((Integer) list.get(i3)).intValue());
            }
            this.zza.zzu(iZzC);
            while (i2 < list.size()) {
                this.zza.zzu(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzacg zzacgVar = (zzacg) list;
        if (!z) {
            while (i2 < zzacgVar.size()) {
                this.zza.zzt(i, zzacgVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int iZzC2 = 0;
        for (int i4 = 0; i4 < zzacgVar.size(); i4++) {
            iZzC2 += zzzi.zzC(zzacgVar.zze(i4));
        }
        this.zza.zzu(iZzC2);
        while (i2 < zzacgVar.size()) {
            this.zza.zzu(zzacgVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzL(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzada)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzv(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int iZzD = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzD += zzzi.zzD(((Long) list.get(i3)).longValue());
            }
            this.zza.zzu(iZzD);
            while (i2 < list.size()) {
                this.zza.zzw(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzada zzadaVar = (zzada) list;
        if (!z) {
            while (i2 < zzadaVar.size()) {
                this.zza.zzv(i, zzadaVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int iZzD2 = 0;
        for (int i4 = 0; i4 < zzadaVar.size(); i4++) {
            iZzD2 += zzzi.zzD(zzadaVar.zze(i4));
        }
        this.zza.zzu(iZzD2);
        while (i2 < zzadaVar.size()) {
            this.zza.zzw(zzadaVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzl(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzacg)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            this.zza.zzu(i3);
            while (i2 < list.size()) {
                this.zza.zzi(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzacg zzacgVar = (zzacg) list;
        if (!z) {
            while (i2 < zzacgVar.size()) {
                this.zza.zzh(i, zzacgVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzacgVar.size(); i6++) {
            zzacgVar.zze(i6);
            i5 += 4;
        }
        this.zza.zzu(i5);
        while (i2 < zzacgVar.size()) {
            this.zza.zzi(zzacgVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzn(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzada)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            this.zza.zzu(i3);
            while (i2 < list.size()) {
                this.zza.zzk(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzada zzadaVar = (zzada) list;
        if (!z) {
            while (i2 < zzadaVar.size()) {
                this.zza.zzj(i, zzadaVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzadaVar.size(); i6++) {
            zzadaVar.zze(i6);
            i5 += 8;
        }
        this.zza.zzu(i5);
        while (i2 < zzadaVar.size()) {
            this.zza.zzk(zzadaVar.zze(i2));
            i2++;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzc(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzyo)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzK(i, ((Boolean) list.get(i2)).booleanValue());
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Boolean) list.get(i4)).booleanValue();
                i3++;
            }
            this.zza.zzu(i3);
            while (i2 < list.size()) {
                this.zza.zzJ(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        zzyo zzyoVar = (zzyo) list;
        if (!z) {
            while (i2 < zzyoVar.size()) {
                this.zza.zzK(i, zzyoVar.zzf(i2));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzyoVar.size(); i6++) {
            zzyoVar.zzf(i6);
            i5++;
        }
        this.zza.zzu(i5);
        while (i2 < zzyoVar.size()) {
            this.zza.zzJ(zzyoVar.zzf(i2) ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzs(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzacg)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int iZzD = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzD += zzzi.zzD(((Integer) list.get(i3)).intValue());
            }
            this.zza.zzu(iZzD);
            while (i2 < list.size()) {
                this.zza.zzm(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzacg zzacgVar = (zzacg) list;
        if (!z) {
            while (i2 < zzacgVar.size()) {
                this.zza.zzl(i, zzacgVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int iZzD2 = 0;
        for (int i4 = 0; i4 < zzacgVar.size(); i4++) {
            iZzD2 += zzzi.zzD(zzacgVar.zze(i4));
        }
        this.zza.zzu(iZzD2);
        while (i2 < zzacgVar.size()) {
            this.zza.zzm(zzacgVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzA(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzada)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            this.zza.zzu(i3);
            while (i2 < list.size()) {
                this.zza.zzk(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzada zzadaVar = (zzada) list;
        if (!z) {
            while (i2 < zzadaVar.size()) {
                this.zza.zzj(i, zzadaVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzadaVar.size(); i6++) {
            zzadaVar.zze(i6);
            i5 += 8;
        }
        this.zza.zzu(i5);
        while (i2 < zzadaVar.size()) {
            this.zza.zzk(zzadaVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzg(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzabn)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Double) list.get(i4)).doubleValue();
                i3 += 8;
            }
            this.zza.zzu(i3);
            while (i2 < list.size()) {
                this.zza.zzk(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zzabn zzabnVar = (zzabn) list;
        if (!z) {
            while (i2 < zzabnVar.size()) {
                this.zza.zzj(i, Double.doubleToRawLongBits(zzabnVar.zze(i2)));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzabnVar.size(); i6++) {
            zzabnVar.zze(i6);
            i5 += 8;
        }
        this.zza.zzu(i5);
        while (i2 < zzabnVar.size()) {
            this.zza.zzk(Double.doubleToRawLongBits(zzabnVar.zze(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzp(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzabx)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Float) list.get(i4)).floatValue();
                i3 += 4;
            }
            this.zza.zzu(i3);
            while (i2 < list.size()) {
                this.zza.zzi(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zzabx zzabxVar = (zzabx) list;
        if (!z) {
            while (i2 < zzabxVar.size()) {
                this.zza.zzh(i, Float.floatToRawIntBits(zzabxVar.zze(i2)));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzabxVar.size(); i6++) {
            zzabxVar.zze(i6);
            i5 += 4;
        }
        this.zza.zzu(i5);
        while (i2 < zzabxVar.size()) {
            this.zza.zzi(Float.floatToRawIntBits(zzabxVar.zze(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzy(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzacg)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            this.zza.zzu(i3);
            while (i2 < list.size()) {
                this.zza.zzi(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzacg zzacgVar = (zzacg) list;
        if (!z) {
            while (i2 < zzacgVar.size()) {
                this.zza.zzh(i, zzacgVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzacgVar.size(); i6++) {
            zzacgVar.zze(i6);
            i5 += 4;
        }
        this.zza.zzu(i5);
        while (i2 < zzacgVar.size()) {
            this.zza.zzi(zzacgVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzC(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzacg)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzzi zzziVar = this.zza;
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    zzziVar.zzt(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int iZzC = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int iIntValue2 = ((Integer) list.get(i3)).intValue();
                iZzC += zzzi.zzC((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            this.zza.zzu(iZzC);
            while (i2 < list.size()) {
                zzzi zzziVar2 = this.zza;
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                zzziVar2.zzu((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        zzacg zzacgVar = (zzacg) list;
        if (!z) {
            while (i2 < zzacgVar.size()) {
                zzzi zzziVar3 = this.zza;
                int iZze = zzacgVar.zze(i2);
                zzziVar3.zzt(i, (iZze >> 31) ^ (iZze + iZze));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int iZzC2 = 0;
        for (int i4 = 0; i4 < zzacgVar.size(); i4++) {
            int iZze2 = zzacgVar.zze(i4);
            iZzC2 += zzzi.zzC((iZze2 >> 31) ^ (iZze2 + iZze2));
        }
        this.zza.zzu(iZzC2);
        while (i2 < zzacgVar.size()) {
            zzzi zzziVar4 = this.zza;
            int iZze3 = zzacgVar.zze(i2);
            zzziVar4.zzu((iZze3 >> 31) ^ (iZze3 + iZze3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzE(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzada)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzzi zzziVar = this.zza;
                    long jLongValue = ((Long) list.get(i2)).longValue();
                    zzziVar.zzv(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int iZzD = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                long jLongValue2 = ((Long) list.get(i3)).longValue();
                iZzD += zzzi.zzD((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            this.zza.zzu(iZzD);
            while (i2 < list.size()) {
                zzzi zzziVar2 = this.zza;
                long jLongValue3 = ((Long) list.get(i2)).longValue();
                zzziVar2.zzw((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i2++;
            }
            return;
        }
        zzada zzadaVar = (zzada) list;
        if (!z) {
            while (i2 < zzadaVar.size()) {
                zzzi zzziVar3 = this.zza;
                long jZze = zzadaVar.zze(i2);
                zzziVar3.zzv(i, (jZze >> 63) ^ (jZze + jZze));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int iZzD2 = 0;
        for (int i4 = 0; i4 < zzadaVar.size(); i4++) {
            long jZze2 = zzadaVar.zze(i4);
            iZzD2 += zzzi.zzD((jZze2 >> 63) ^ (jZze2 + jZze2));
        }
        this.zza.zzu(iZzD2);
        while (i2 < zzadaVar.size()) {
            zzzi zzziVar4 = this.zza;
            long jZze3 = zzadaVar.zze(i2);
            zzziVar4.zzw((jZze3 >> 63) ^ (jZze3 + jZze3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzj(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzacg)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int iZzD = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzD += zzzi.zzD(((Integer) list.get(i3)).intValue());
            }
            this.zza.zzu(iZzD);
            while (i2 < list.size()) {
                this.zza.zzm(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzacg zzacgVar = (zzacg) list;
        if (!z) {
            while (i2 < zzacgVar.size()) {
                this.zza.zzl(i, zzacgVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int iZzD2 = 0;
        for (int i4 = 0; i4 < zzacgVar.size(); i4++) {
            iZzD2 += zzzi.zzD(zzacgVar.zze(i4));
        }
        this.zza.zzu(iZzD2);
        while (i2 < zzacgVar.size()) {
            this.zza.zzm(zzacgVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzaez
    public final void zzu(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzada)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzv(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzs(i, 2);
            int iZzD = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzD += zzzi.zzD(((Long) list.get(i3)).longValue());
            }
            this.zza.zzu(iZzD);
            while (i2 < list.size()) {
                this.zza.zzw(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzada zzadaVar = (zzada) list;
        if (!z) {
            while (i2 < zzadaVar.size()) {
                this.zza.zzv(i, zzadaVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int iZzD2 = 0;
        for (int i4 = 0; i4 < zzadaVar.size(); i4++) {
            iZzD2 += zzzi.zzD(zzadaVar.zze(i4));
        }
        this.zza.zzu(iZzD2);
        while (i2 < zzadaVar.size()) {
            this.zza.zzw(zzadaVar.zze(i2));
            i2++;
        }
    }
}
