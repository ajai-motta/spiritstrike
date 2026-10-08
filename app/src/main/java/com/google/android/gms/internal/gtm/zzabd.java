package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzabd extends zzacc implements zzadm {
    private static final zzabd zzd;
    private boolean zzC;
    private int zzD;
    private zzaae zzE;
    private int zze;
    private int zzf;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private int zzm;
    private int zzo;
    private int zzp;
    private boolean zzr;
    private boolean zzs;
    private boolean zzv;
    private byte zzG = 2;
    private double zzg = -1.0d;
    private int zzk = 256;
    private int zzl = 256;
    private int zzn = 3;
    private String zzq = "";
    private String zzt = "";
    private String zzu = "";
    private long zzw = -1;
    private long zzx = -1;
    private long zzy = 16000000;
    private long zzz = 16000000;
    private int zzA = 1;
    private int zzB = 2;
    private zzacn zzF = zzadu.zze();

    static {
        zzabd zzabdVar = new zzabd();
        zzd = zzabdVar;
        zzacf.zzao(zzabd.class, zzabdVar);
    }

    private zzabd() {
    }

    public static zzabd zze() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzG);
        }
        if (i2 == 2) {
            zzacj zzacjVar = zzabb.zza;
            zzacj zzacjVar2 = zzaax.zza;
            return new zzadv(zzd, "\u0001\u001b\u0000\u0001\u0007ϧ\u001b\u0000\u0001\u0002\u0007᠌\u0000\bက\u0001\tဇ\u0002\nဇ\u0003\u000bဏ\u0005\fဏ\u0006\r᠌\u0007\u000e᠌\b\u000f᠌\t\u0011᠌\n\u0013ဈ\u000b\u0014ဇ\f\u0015ဇ\r\u0016ဈ\u000e\u0017ဈ\u000f\u0018ဂ\u0011\u0019ဂ\u0012\u001aဇ\u0004\u001b᠌\u0016\u001c᠌\u0015\u001dဇ\u0010\u001eဂ\u0013\u001fဂ\u0014!ဇ\u0017\"᠌\u0018#ᐉ\u0019ϧЛ", new Object[]{"zze", "zzf", zzaba.zza, "zzg", "zzh", "zzi", "zzk", "zzl", "zzm", zzacjVar, "zzn", zzacjVar, "zzo", zzacjVar2, "zzp", zzacjVar2, "zzq", "zzr", "zzs", "zzt", "zzu", "zzw", "zzx", "zzj", "zzB", zzaaz.zza, "zzA", zzabc.zza, "zzv", "zzy", "zzz", "zzC", "zzD", zzaay.zza, "zzE", "zzF", zzabl.class});
        }
        if (i2 == 3) {
            return new zzabd();
        }
        zzabm zzabmVar = null;
        if (i2 == 4) {
            return new zzaaw(zzabmVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzG = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
