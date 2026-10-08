package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzqw implements zzvi {
    private final zzqv zza;

    private zzqw(zzqv zzqvVar) {
        byte[] bArr = zzsv.zzb;
        this.zza = zzqvVar;
        zzqvVar.zza = this;
    }

    public static zzqw zza(zzqv zzqvVar) {
        zzqw zzqwVar = zzqvVar.zza;
        return zzqwVar != null ? zzqwVar : new zzqw(zzqvVar);
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzB(int i, int i2) throws IOException {
        this.zza.zzs(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzD(int i, long j) throws IOException {
        this.zza.zzu(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    @Deprecated
    public final void zzF(int i) throws IOException {
        this.zza.zzr(i, 3);
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzG(int i, String str) throws IOException {
        this.zza.zzp(i, str);
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzI(int i, int i2) throws IOException {
        this.zza.zzs(i, i2);
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzK(int i, long j) throws IOException {
        this.zza.zzu(i, j);
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzb(int i, boolean z) throws IOException {
        this.zza.zzd(i, z);
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzd(int i, zzqm zzqmVar) throws IOException {
        this.zza.zze(i, zzqmVar);
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zze(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zze(i, (zzqm) list.get(i2));
        }
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzf(int i, double d) throws IOException {
        this.zza.zzh(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    @Deprecated
    public final void zzh(int i) throws IOException {
        this.zza.zzr(i, 4);
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzj(i, i2);
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzf(i, i2);
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzm(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzo(int i, float f) throws IOException {
        this.zza.zzf(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzq(int i, Object obj, zzug zzugVar) throws IOException {
        zzqv zzqvVar = this.zza;
        zzqvVar.zzr(i, 3);
        zzugVar.zzj((zzts) obj, zzqvVar.zza);
        zzqvVar.zzr(i, 4);
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzr(int i, int i2) throws IOException {
        this.zza.zzj(i, i2);
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzt(int i, long j) throws IOException {
        this.zza.zzu(i, j);
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzv(int i, Object obj, zzug zzugVar) throws IOException {
        this.zza.zzm(i, (zzts) obj, zzugVar);
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzw(int i, Object obj) throws IOException {
        if (obj instanceof zzqm) {
            this.zza.zzo(i, (zzqm) obj);
        } else {
            this.zza.zzn(i, (zzts) obj);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzx(int i, int i2) throws IOException {
        this.zza.zzf(i, i2);
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzz(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzH(int i, List list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzte)) {
            while (i2 < list.size()) {
                this.zza.zzp(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzte zzteVar = (zzte) list;
        while (i2 < list.size()) {
            Object objZzc = zzteVar.zzc();
            if (objZzc instanceof String) {
                this.zza.zzp(i, (String) objZzc);
            } else {
                this.zza.zze(i, (zzqm) objZzc);
            }
            i2++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzJ(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzso)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzs(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzqv zzqvVar = this.zza;
            zzqvVar.zzr(i, 2);
            int iZzA = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzA += zzqv.zzA(((Integer) list.get(i3)).intValue());
            }
            zzqvVar.zzt(iZzA);
            while (i2 < list.size()) {
                zzqvVar.zzt(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzso zzsoVar = (zzso) list;
        if (!z) {
            while (i2 < zzsoVar.size()) {
                this.zza.zzs(i, zzsoVar.zze(i2));
                i2++;
            }
            return;
        }
        zzqv zzqvVar2 = this.zza;
        zzqvVar2.zzr(i, 2);
        int iZzA2 = 0;
        for (int i4 = 0; i4 < zzsoVar.size(); i4++) {
            iZzA2 += zzqv.zzA(zzsoVar.zze(i4));
        }
        zzqvVar2.zzt(iZzA2);
        while (i2 < zzsoVar.size()) {
            zzqvVar2.zzt(zzsoVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzL(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzth)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzu(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzqv zzqvVar = this.zza;
            zzqvVar.zzr(i, 2);
            int iZzB = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzB += zzqv.zzB(((Long) list.get(i3)).longValue());
            }
            zzqvVar.zzt(iZzB);
            while (i2 < list.size()) {
                zzqvVar.zzv(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzth zzthVar = (zzth) list;
        if (!z) {
            while (i2 < zzthVar.size()) {
                this.zza.zzu(i, zzthVar.zze(i2));
                i2++;
            }
            return;
        }
        zzqv zzqvVar2 = this.zza;
        zzqvVar2.zzr(i, 2);
        int iZzB2 = 0;
        for (int i4 = 0; i4 < zzthVar.size(); i4++) {
            iZzB2 += zzqv.zzB(zzthVar.zze(i4));
        }
        zzqvVar2.zzt(iZzB2);
        while (i2 < zzthVar.size()) {
            zzqvVar2.zzv(zzthVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzl(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzso)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzqv zzqvVar = this.zza;
            zzqvVar.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            zzqvVar.zzt(i3);
            while (i2 < list.size()) {
                zzqvVar.zzg(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzso zzsoVar = (zzso) list;
        if (!z) {
            while (i2 < zzsoVar.size()) {
                this.zza.zzf(i, zzsoVar.zze(i2));
                i2++;
            }
            return;
        }
        zzqv zzqvVar2 = this.zza;
        zzqvVar2.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzsoVar.size(); i6++) {
            zzsoVar.zze(i6);
            i5 += 4;
        }
        zzqvVar2.zzt(i5);
        while (i2 < zzsoVar.size()) {
            zzqvVar2.zzg(zzsoVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzn(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzth)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzqv zzqvVar = this.zza;
            zzqvVar.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            zzqvVar.zzt(i3);
            while (i2 < list.size()) {
                zzqvVar.zzi(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzth zzthVar = (zzth) list;
        if (!z) {
            while (i2 < zzthVar.size()) {
                this.zza.zzh(i, zzthVar.zze(i2));
                i2++;
            }
            return;
        }
        zzqv zzqvVar2 = this.zza;
        zzqvVar2.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzthVar.size(); i6++) {
            zzthVar.zze(i6);
            i5 += 8;
        }
        zzqvVar2.zzt(i5);
        while (i2 < zzthVar.size()) {
            zzqvVar2.zzi(zzthVar.zze(i2));
            i2++;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzc(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzqd)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzd(i, ((Boolean) list.get(i2)).booleanValue());
                    i2++;
                }
                return;
            }
            zzqv zzqvVar = this.zza;
            zzqvVar.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Boolean) list.get(i4)).booleanValue();
                i3++;
            }
            zzqvVar.zzt(i3);
            while (i2 < list.size()) {
                zzqvVar.zzb(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        zzqd zzqdVar = (zzqd) list;
        if (!z) {
            while (i2 < zzqdVar.size()) {
                this.zza.zzd(i, zzqdVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzqv zzqvVar2 = this.zza;
        zzqvVar2.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzqdVar.size(); i6++) {
            zzqdVar.zzf(i6);
            i5++;
        }
        zzqvVar2.zzt(i5);
        while (i2 < zzqdVar.size()) {
            zzqvVar2.zzb(zzqdVar.zzf(i2) ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzs(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzso)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzqv zzqvVar = this.zza;
            zzqvVar.zzr(i, 2);
            int iZzB = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzB += zzqv.zzB(((Integer) list.get(i3)).intValue());
            }
            zzqvVar.zzt(iZzB);
            while (i2 < list.size()) {
                zzqvVar.zzk(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzso zzsoVar = (zzso) list;
        if (!z) {
            while (i2 < zzsoVar.size()) {
                this.zza.zzj(i, zzsoVar.zze(i2));
                i2++;
            }
            return;
        }
        zzqv zzqvVar2 = this.zza;
        zzqvVar2.zzr(i, 2);
        int iZzB2 = 0;
        for (int i4 = 0; i4 < zzsoVar.size(); i4++) {
            iZzB2 += zzqv.zzB(zzsoVar.zze(i4));
        }
        zzqvVar2.zzt(iZzB2);
        while (i2 < zzsoVar.size()) {
            zzqvVar2.zzk(zzsoVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzA(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzth)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzqv zzqvVar = this.zza;
            zzqvVar.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            zzqvVar.zzt(i3);
            while (i2 < list.size()) {
                zzqvVar.zzi(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzth zzthVar = (zzth) list;
        if (!z) {
            while (i2 < zzthVar.size()) {
                this.zza.zzh(i, zzthVar.zze(i2));
                i2++;
            }
            return;
        }
        zzqv zzqvVar2 = this.zza;
        zzqvVar2.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzthVar.size(); i6++) {
            zzthVar.zze(i6);
            i5 += 8;
        }
        zzqvVar2.zzt(i5);
        while (i2 < zzthVar.size()) {
            zzqvVar2.zzi(zzthVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzg(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzrs)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                    i2++;
                }
                return;
            }
            zzqv zzqvVar = this.zza;
            zzqvVar.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Double) list.get(i4)).doubleValue();
                i3 += 8;
            }
            zzqvVar.zzt(i3);
            while (i2 < list.size()) {
                zzqvVar.zzi(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zzrs zzrsVar = (zzrs) list;
        if (!z) {
            while (i2 < zzrsVar.size()) {
                this.zza.zzh(i, Double.doubleToRawLongBits(zzrsVar.zze(i2)));
                i2++;
            }
            return;
        }
        zzqv zzqvVar2 = this.zza;
        zzqvVar2.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzrsVar.size(); i6++) {
            zzrsVar.zze(i6);
            i5 += 8;
        }
        zzqvVar2.zzt(i5);
        while (i2 < zzrsVar.size()) {
            zzqvVar2.zzi(Double.doubleToRawLongBits(zzrsVar.zze(i2)));
            i2++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzp(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzsf)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            zzqv zzqvVar = this.zza;
            zzqvVar.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Float) list.get(i4)).floatValue();
                i3 += 4;
            }
            zzqvVar.zzt(i3);
            while (i2 < list.size()) {
                zzqvVar.zzg(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zzsf zzsfVar = (zzsf) list;
        if (!z) {
            while (i2 < zzsfVar.size()) {
                this.zza.zzf(i, Float.floatToRawIntBits(zzsfVar.zze(i2)));
                i2++;
            }
            return;
        }
        zzqv zzqvVar2 = this.zza;
        zzqvVar2.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzsfVar.size(); i6++) {
            zzsfVar.zze(i6);
            i5 += 4;
        }
        zzqvVar2.zzt(i5);
        while (i2 < zzsfVar.size()) {
            zzqvVar2.zzg(Float.floatToRawIntBits(zzsfVar.zze(i2)));
            i2++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzy(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzso)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzqv zzqvVar = this.zza;
            zzqvVar.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            zzqvVar.zzt(i3);
            while (i2 < list.size()) {
                zzqvVar.zzg(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzso zzsoVar = (zzso) list;
        if (!z) {
            while (i2 < zzsoVar.size()) {
                this.zza.zzf(i, zzsoVar.zze(i2));
                i2++;
            }
            return;
        }
        zzqv zzqvVar2 = this.zza;
        zzqvVar2.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzsoVar.size(); i6++) {
            zzsoVar.zze(i6);
            i5 += 4;
        }
        zzqvVar2.zzt(i5);
        while (i2 < zzsoVar.size()) {
            zzqvVar2.zzg(zzsoVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzC(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzso)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzqv zzqvVar = this.zza;
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    zzqvVar.zzs(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            zzqv zzqvVar2 = this.zza;
            zzqvVar2.zzr(i, 2);
            int iZzA = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int iIntValue2 = ((Integer) list.get(i3)).intValue();
                iZzA += zzqv.zzA((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzqvVar2.zzt(iZzA);
            while (i2 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                zzqvVar2.zzt((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        zzso zzsoVar = (zzso) list;
        if (!z) {
            while (i2 < zzsoVar.size()) {
                zzqv zzqvVar3 = this.zza;
                int iZze = zzsoVar.zze(i2);
                zzqvVar3.zzs(i, (iZze >> 31) ^ (iZze + iZze));
                i2++;
            }
            return;
        }
        zzqv zzqvVar4 = this.zza;
        zzqvVar4.zzr(i, 2);
        int iZzA2 = 0;
        for (int i4 = 0; i4 < zzsoVar.size(); i4++) {
            int iZze2 = zzsoVar.zze(i4);
            iZzA2 += zzqv.zzA((iZze2 >> 31) ^ (iZze2 + iZze2));
        }
        zzqvVar4.zzt(iZzA2);
        while (i2 < zzsoVar.size()) {
            int iZze3 = zzsoVar.zze(i2);
            zzqvVar4.zzt((iZze3 >> 31) ^ (iZze3 + iZze3));
            i2++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzE(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzth)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzqv zzqvVar = this.zza;
                    long jLongValue = ((Long) list.get(i2)).longValue();
                    zzqvVar.zzu(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i2++;
                }
                return;
            }
            zzqv zzqvVar2 = this.zza;
            zzqvVar2.zzr(i, 2);
            int iZzB = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                long jLongValue2 = ((Long) list.get(i3)).longValue();
                iZzB += zzqv.zzB((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            zzqvVar2.zzt(iZzB);
            while (i2 < list.size()) {
                long jLongValue3 = ((Long) list.get(i2)).longValue();
                zzqvVar2.zzv((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i2++;
            }
            return;
        }
        zzth zzthVar = (zzth) list;
        if (!z) {
            while (i2 < zzthVar.size()) {
                zzqv zzqvVar3 = this.zza;
                long jZze = zzthVar.zze(i2);
                zzqvVar3.zzu(i, (jZze >> 63) ^ (jZze + jZze));
                i2++;
            }
            return;
        }
        zzqv zzqvVar4 = this.zza;
        zzqvVar4.zzr(i, 2);
        int iZzB2 = 0;
        for (int i4 = 0; i4 < zzthVar.size(); i4++) {
            long jZze2 = zzthVar.zze(i4);
            iZzB2 += zzqv.zzB((jZze2 >> 63) ^ (jZze2 + jZze2));
        }
        zzqvVar4.zzt(iZzB2);
        while (i2 < zzthVar.size()) {
            long jZze3 = zzthVar.zze(i2);
            zzqvVar4.zzv((jZze3 >> 63) ^ (jZze3 + jZze3));
            i2++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzj(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzso)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzqv zzqvVar = this.zza;
            zzqvVar.zzr(i, 2);
            int iZzB = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzB += zzqv.zzB(((Integer) list.get(i3)).intValue());
            }
            zzqvVar.zzt(iZzB);
            while (i2 < list.size()) {
                zzqvVar.zzk(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzso zzsoVar = (zzso) list;
        if (!z) {
            while (i2 < zzsoVar.size()) {
                this.zza.zzj(i, zzsoVar.zze(i2));
                i2++;
            }
            return;
        }
        zzqv zzqvVar2 = this.zza;
        zzqvVar2.zzr(i, 2);
        int iZzB2 = 0;
        for (int i4 = 0; i4 < zzsoVar.size(); i4++) {
            iZzB2 += zzqv.zzB(zzsoVar.zze(i4));
        }
        zzqvVar2.zzt(iZzB2);
        while (i2 < zzsoVar.size()) {
            zzqvVar2.zzk(zzsoVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzvi
    public final void zzu(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzth)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzu(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzqv zzqvVar = this.zza;
            zzqvVar.zzr(i, 2);
            int iZzB = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzB += zzqv.zzB(((Long) list.get(i3)).longValue());
            }
            zzqvVar.zzt(iZzB);
            while (i2 < list.size()) {
                zzqvVar.zzv(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzth zzthVar = (zzth) list;
        if (!z) {
            while (i2 < zzthVar.size()) {
                this.zza.zzu(i, zzthVar.zze(i2));
                i2++;
            }
            return;
        }
        zzqv zzqvVar2 = this.zza;
        zzqvVar2.zzr(i, 2);
        int iZzB2 = 0;
        for (int i4 = 0; i4 < zzthVar.size(); i4++) {
            iZzB2 += zzqv.zzB(zzthVar.zze(i4));
        }
        zzqvVar2.zzt(iZzB2);
        while (i2 < zzthVar.size()) {
            zzqvVar2.zzv(zzthVar.zze(i2));
            i2++;
        }
    }
}
