package com.google.android.gms.internal.measurement;

import java.util.Calendar;
import java.util.Date;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzyy extends zzabm implements zzabi {
    protected final Object[] zza;
    protected final StringBuilder zzb;
    private int zzc;

    protected zzyy(zzaaf zzaafVar, Object[] objArr, StringBuilder sb) {
        super(zzaafVar);
        this.zzc = 0;
        this.zza = objArr;
        this.zzb = sb;
    }

    public static StringBuilder zza(zzzd zzzdVar, StringBuilder sb) {
        if (zzzdVar.zzh() != null) {
            zzyy zzyyVar = new zzyy(zzzdVar.zzh(), zzzdVar.zzi(), sb);
            sb = (StringBuilder) zzyyVar.zzl();
            if (zzzdVar.zzi().length > zzyyVar.zzj()) {
                sb.append(" [ERROR: UNUSED LOG ARGUMENTS]");
                return sb;
            }
        } else {
            sb.append(zzzh.zza(zzzdVar.zzj()));
        }
        return sb;
    }

    private static void zzm(StringBuilder sb, Object obj, String str) {
        sb.append("[INVALID: format=");
        sb.append(str);
        sb.append(", type=");
        sb.append(obj.getClass().getCanonicalName());
        sb.append(", value=");
        sb.append(zzzh.zza(obj));
        sb.append("]");
    }

    @Override // com.google.android.gms.internal.measurement.zzabm
    public final void zzb(int i, int i2, zzabh zzabhVar) {
        zzh().zzd(this.zzb, zzi(), this.zzc, i);
        zzabhVar.zze(this, this.zza);
        this.zzc = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
    
        if ((r7 instanceof java.math.BigDecimal) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0037, code lost:
    
        if ((r7 instanceof java.math.BigInteger) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0059, code lost:
    
        if (r0 != false) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b0  */
    @Override // com.google.android.gms.internal.measurement.zzabi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzc(java.lang.Object r7, com.google.android.gms.internal.measurement.zzyz r8, com.google.android.gms.internal.measurement.zzza r9) {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzyy.zzc(java.lang.Object, com.google.android.gms.internal.measurement.zzyz, com.google.android.gms.internal.measurement.zzza):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzabi
    public final void zzd(Object obj, zzabf zzabfVar, zzza zzzaVar) {
        if ((obj instanceof Date) || (obj instanceof Calendar) || (obj instanceof Long)) {
            StringBuilder sb = new StringBuilder("%");
            zzzaVar.zzl(sb);
            sb.append(true != zzzaVar.zzk() ? 't' : 'T');
            sb.append(zzabfVar.zzb());
            this.zzb.append(String.format(zzzh.zza, sb.toString(), obj));
            return;
        }
        StringBuilder sb2 = this.zzb;
        char cZzb = zzabfVar.zzb();
        StringBuilder sb3 = new StringBuilder(String.valueOf(cZzb).length() + 2);
        sb3.append("%t");
        sb3.append(cZzb);
        zzm(sb2, obj, sb3.toString());
    }

    @Override // com.google.android.gms.internal.measurement.zzabi
    public final void zze() {
        this.zzb.append("[ERROR: MISSING LOG ARGUMENT]");
    }

    @Override // com.google.android.gms.internal.measurement.zzabi
    public final void zzf() {
        this.zzb.append(AbstractJsonLexerKt.NULL);
    }

    @Override // com.google.android.gms.internal.measurement.zzabm
    public final /* bridge */ /* synthetic */ Object zzg() {
        zzabn zzabnVarZzh = zzh();
        String strZzi = zzi();
        int i = this.zzc;
        int length = zzi().length();
        StringBuilder sb = this.zzb;
        zzabnVarZzh.zzd(sb, strZzi, i, length);
        return sb;
    }
}
