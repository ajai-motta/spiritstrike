package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcfn extends zzcfe implements zzcdh {
    public static final /* synthetic */ int zzd = 0;
    private zzcdi zze;
    private String zzf;
    private boolean zzg;
    private boolean zzh;
    private zzcew zzi;
    private long zzj;
    private long zzk;

    public zzcfn(zzcdr zzcdrVar, zzcdq zzcdqVar) {
        super(zzcdrVar);
        zzcgg zzcggVar = new zzcgg(zzcdrVar.getContext(), zzcdqVar, (zzcdr) this.zzc.get(), null);
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzh("ExoPlayerAdapter initialized.");
        this.zze = zzcggVar;
        zzcggVar.zzs(this);
    }

    protected static final String zzc(String str) {
        String strZzf = com.google.android.gms.ads.internal.util.client.zzf.zzf(str);
        String.valueOf(strZzf);
        return "cache:".concat(String.valueOf(strZzf));
    }

    private final void zzd(long j) {
        com.google.android.gms.ads.internal.util.zzs.zza.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfl
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() throws Throwable {
                this.zza.zzb();
            }
        }, j);
    }

    private static String zzx(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        int length = String.valueOf(canonicalName).length();
        StringBuilder sb = new StringBuilder(str.length() + 1 + length + 1 + String.valueOf(message).length());
        sb.append(str);
        sb.append(DomExceptionUtils.SEPARATOR);
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzcfe, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzcdi zzcdiVar = this.zze;
        if (zzcdiVar != null) {
            zzcdiVar.zzs(null);
            this.zze.zzt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzD() {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Precache onRenderedFirstFrame");
    }

    public final zzcdi zza() {
        synchronized (this) {
            this.zzh = true;
            notify();
        }
        this.zze.zzs(null);
        zzcdi zzcdiVar = this.zze;
        this.zze = null;
        return zzcdiVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22, types: [com.google.android.gms.internal.ads.zzcfe, com.google.android.gms.internal.ads.zzcfn] */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26, types: [com.google.android.gms.internal.ads.zzcfn] */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.google.android.gms.internal.ads.zzbes] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v9, types: [int] */
    final /* synthetic */ void zzb() throws Throwable {
        String strZzc;
        zzcfn zzcfnVarBooleanValue;
        zzcfn zzcfnVar;
        long jLongValue;
        long jIntValue;
        zzcfn zzcfnVar2;
        long j;
        long j2;
        String str;
        long j3;
        String strZzc2 = zzc(this.zzf);
        String str2 = "error";
        try {
            jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzS)).longValue() * 1000;
            jIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzv)).intValue();
            zzbel zzbelVar = zzbeu.zzch;
            strZzc = com.google.android.gms.ads.internal.client.zzbd.zzc();
            zzcfnVarBooleanValue = ((Boolean) strZzc.zzd(zzbelVar)).booleanValue();
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
            strZzc = strZzc2;
            zzcfnVarBooleanValue = this;
        }
        synchronized (this) {
            try {
                strZzc = ((com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis() - this.zzj) > jLongValue ? 1 : ((com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis() - this.zzj) == jLongValue ? 0 : -1));
                if (strZzc <= 0) {
                    try {
                        if (this.zzg) {
                            throw new IOException("Abort requested before buffering finished. ");
                        }
                        if (!this.zzh) {
                            if (!this.zze.zzB()) {
                                throw new IOException("ExoPlayer was released during preloading.");
                            }
                            long jZzH = this.zze.zzH();
                            if (jZzH > 0) {
                                long jZzN = this.zze.zzN();
                                if (jZzN != this.zzk) {
                                    try {
                                        j2 = jIntValue;
                                        str = strZzc2;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        str = strZzc2;
                                        zzcfnVarBooleanValue = this;
                                    }
                                    try {
                                        zzm(this.zzf, strZzc2, jZzN, jZzH, jZzN > 0, zzcfnVarBooleanValue != 0 ? this.zze.zzI() : -1L, zzcfnVarBooleanValue != 0 ? this.zze.zzJ() : -1L, zzcfnVarBooleanValue != 0 ? this.zze.zzK() : -1L, zzcdi.zzP(), zzcdi.zzQ());
                                        zzcfnVarBooleanValue = this;
                                        j = jZzN;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        zzcfnVarBooleanValue = this;
                                        strZzc = str;
                                        throw th;
                                    }
                                    try {
                                        zzcfnVarBooleanValue.zzk = j;
                                        j3 = jZzH;
                                        zzcfnVarBooleanValue = zzcfnVarBooleanValue;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        strZzc = str;
                                        throw th;
                                    }
                                } else {
                                    j = jZzN;
                                    j2 = jIntValue;
                                    str = strZzc2;
                                    zzcfnVarBooleanValue = this;
                                    j3 = jZzH;
                                }
                                if (j >= j3) {
                                    zzcfnVarBooleanValue.zzp(zzcfnVarBooleanValue.zzf, str, j3);
                                    zzcfnVar = zzcfnVarBooleanValue;
                                } else {
                                    long jZzO = zzcfnVarBooleanValue.zze.zzO();
                                    zzcfnVar2 = zzcfnVarBooleanValue;
                                    if (jZzO >= j2) {
                                        zzcfnVar2 = zzcfnVarBooleanValue;
                                        if (j > 0) {
                                            zzcfnVar = zzcfnVarBooleanValue;
                                        }
                                    }
                                }
                            } else {
                                zzcfnVar2 = this;
                            }
                            zzcfnVar2.zzd(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzT)).longValue());
                            return;
                        }
                        zzcfnVar = this;
                        com.google.android.gms.ads.internal.zzt.zzB().zzd(zzcfnVar.zzi);
                    } catch (Throwable th5) {
                        th = th5;
                        str2 = "Timeout reached. Limit: ";
                    }
                } else {
                    strZzc = strZzc2;
                    zzcfnVarBooleanValue = this;
                    try {
                        StringBuilder sb = new StringBuilder(String.valueOf(jLongValue).length() + 27);
                        sb.append("Timeout reached. Limit: ");
                        sb.append(jLongValue);
                        sb.append(" ms");
                        throw new IOException(sb.toString());
                    } catch (Throwable th6) {
                        th = th6;
                        str2 = "downloadTimeout";
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                strZzc = strZzc2;
                zzcfnVarBooleanValue = this;
            }
            try {
                throw th;
            } catch (Exception e2) {
                e = e2;
                String str3 = str2;
                String str4 = zzcfnVarBooleanValue.zzf;
                String message = e.getMessage();
                StringBuilder sb2 = new StringBuilder(String.valueOf(str4).length() + 34 + String.valueOf(message).length());
                sb2.append("Failed to preload url ");
                sb2.append(str4);
                sb2.append(" Exception: ");
                sb2.append(message);
                String string = sb2.toString();
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi(string);
                com.google.android.gms.ads.internal.zzt.zzh().zzh(e, "VideoStreamExoPlayerCache.preload");
                release();
                zzcfnVarBooleanValue.zzq(zzcfnVarBooleanValue.zzf, strZzc, str3, zzx(str3, e));
                zzcfnVar = zzcfnVarBooleanValue;
                com.google.android.gms.ads.internal.zzt.zzB().zzd(zzcfnVar.zzi);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfe
    public final boolean zze(String str) {
        return zzf(str, new String[]{str});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.google.android.gms.internal.ads.zzcdr] */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.google.android.gms.internal.ads.zzcfe, com.google.android.gms.internal.ads.zzcfn] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [com.google.android.gms.internal.ads.zzcfn] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r17v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18, types: [long] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.android.gms.internal.ads.zzcfe] */
    /* JADX WARN: Type inference failed for: r5v10, types: [int] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.StringBuilder] */
    @Override // com.google.android.gms.internal.ads.zzcfe
    public final boolean zzf(String str, String[] strArr) throws Throwable {
        ?? r6;
        String str2;
        ?? r5;
        Clock clock;
        long j;
        long j2;
        String str3;
        String str4;
        long j3;
        ?? r1;
        long j4;
        long j5;
        String str5;
        long j6;
        ?? r12;
        long j7;
        ?? r15 = this;
        ?? r13 = str;
        r15.zzf = r13;
        ?? r17 = "error";
        String strZzc = zzc(str);
        String str6 = " ms";
        String str7 = "Timeout reached. Limit: ";
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                uriArr[i] = Uri.parse(strArr[i]);
            }
            r15.zze.zzq(uriArr, r15.zzb);
            ?? r0 = (zzcdr) r15.zzc.get();
            if (r0 != 0) {
                r0.zzt(strZzc, r15);
            }
            Clock clockZzk = com.google.android.gms.ads.internal.zzt.zzk();
            long jCurrentTimeMillis = clockZzk.currentTimeMillis();
            long jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzT)).longValue();
            long jLongValue2 = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzS)).longValue() * 1000;
            long jIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzv)).intValue();
            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzch)).booleanValue();
            ?? r14 = -1;
            long j8 = jLongValue2;
            r13 = r13;
            r15 = r15;
            while (true) {
                synchronized (this) {
                    try {
                        if (clockZzk.currentTimeMillis() - jCurrentTimeMillis > j8) {
                            long j9 = j8;
                            String str8 = str6;
                            String str9 = str7;
                            StringBuilder sb = new StringBuilder(String.valueOf(j9).length() + 27);
                            sb.append(str9);
                            sb.append(j9);
                            sb.append(str8);
                            throw new IOException(sb.toString());
                        }
                        if (r15.zzg) {
                            throw new IOException("Abort requested before buffering finished. ");
                        }
                        if (r15.zzh) {
                            break;
                        }
                        if (!r15.zze.zzB()) {
                            throw new IOException("ExoPlayer was released during preloading.");
                        }
                        String str10 = str6;
                        String str11 = str7;
                        long jZzH = r15.zze.zzH();
                        if (jZzH > 0) {
                            long jZzN = r15.zze.zzN();
                            if (jZzN != r14) {
                                try {
                                    j = jIntValue;
                                    j4 = j8;
                                    j7 = jZzH;
                                    j5 = jLongValue;
                                    clock = clockZzk;
                                    str3 = str11;
                                    str4 = str10;
                                    str5 = strZzc;
                                } catch (Throwable th) {
                                    th = th;
                                    str5 = strZzc;
                                }
                                try {
                                    zzm(str, strZzc, jZzN, j7, jZzN > 0, zBooleanValue ? r15.zze.zzI() : -1L, zBooleanValue ? r15.zze.zzJ() : -1L, zBooleanValue ? r15.zze.zzK() : -1L, zzcdi.zzP(), zzcdi.zzQ());
                                    r12 = jZzN;
                                    j6 = jZzH;
                                    r6 = j7;
                                } catch (Throwable th2) {
                                    th = th2;
                                    r5 = this;
                                    r6 = str;
                                    str2 = str5;
                                    try {
                                        throw th;
                                    } catch (Exception e) {
                                        e = e;
                                        ?? r16 = r17;
                                        String message = e.getMessage();
                                        ?? sb2 = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(message).length());
                                        sb2.append("Failed to preload url ");
                                        sb2.append(r6);
                                        sb2.append(" Exception: ");
                                        sb2.append(message);
                                        String string = sb2.toString();
                                        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                                        com.google.android.gms.ads.internal.util.client.zzo.zzi(string);
                                        com.google.android.gms.ads.internal.zzt.zzh().zzh(e, "VideoStreamExoPlayerCache.preload");
                                        release();
                                        r5.zzq(r6, str2, r16, zzx(r16, e));
                                        return false;
                                    }
                                }
                            } else {
                                clock = clockZzk;
                                j = jIntValue;
                                j4 = j8;
                                j5 = jLongValue;
                                str5 = strZzc;
                                str3 = str11;
                                str4 = str10;
                                j6 = jZzH;
                                r12 = r14;
                                r6 = j8;
                            }
                            r5 = (jZzN > j6 ? 1 : (jZzN == j6 ? 0 : -1));
                            if (r5 >= 0) {
                                zzp(str, str5, j6);
                            } else {
                                try {
                                    zzcfn zzcfnVar = this;
                                    r6 = str;
                                    str2 = str5;
                                    if (zzcfnVar.zze.zzO() < j || jZzN <= 0) {
                                        j3 = j5;
                                        r1 = r12;
                                        r5 = zzcfnVar;
                                        j2 = j4;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    throw th;
                                }
                            }
                        } else {
                            clock = clockZzk;
                            j = jIntValue;
                            j2 = j8;
                            r6 = r13;
                            str2 = strZzc;
                            r5 = r15;
                            str3 = str11;
                            str4 = str10;
                            j3 = jLongValue;
                            r1 = r14;
                        }
                        try {
                            try {
                                r5.wait(j3);
                            } catch (InterruptedException unused) {
                                throw new IOException("Wait interrupted.");
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            r17 = r1;
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        r6 = r13;
                        str2 = strZzc;
                        r5 = r15;
                    }
                }
                str7 = str3;
                jLongValue = j3;
                r15 = r5;
                r13 = r6;
                strZzc = str2;
                str6 = str4;
                jIntValue = j;
                j8 = j2;
                clockZzk = clock;
                r14 = r1;
            }
            return true;
        } catch (Exception e2) {
            e = e2;
            r6 = r13;
            str2 = strZzc;
            r5 = r15;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfe
    public final boolean zzg(String str, String[] strArr, zzcew zzcewVar) {
        this.zzf = str;
        this.zzi = zzcewVar;
        String strZzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                uriArr[i] = Uri.parse(strArr[i]);
            }
            this.zze.zzq(uriArr, this.zzb);
            zzcdr zzcdrVar = (zzcdr) this.zzc.get();
            if (zzcdrVar != null) {
                zzcdrVar.zzt(strZzc, this);
            }
            this.zzj = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
            this.zzk = -1L;
            zzd(0L);
            return true;
        } catch (Exception e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(message).length());
            sb.append("Failed to preload url ");
            sb.append(str);
            sb.append(" Exception: ");
            sb.append(message);
            String string = sb.toString();
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi(string);
            com.google.android.gms.ads.internal.zzt.zzh().zzh(e, "VideoStreamExoPlayerCache.preload");
            release();
            zzq(str, strZzc, "error", zzx("error", e));
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfe
    public final void zzh(int i) {
        this.zze.zzG(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcfe
    public final void zzi(int i) {
        this.zze.zzF(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcfe
    public final void zzj(int i) {
        this.zze.zzy(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcfe
    public final void zzk(int i) {
        this.zze.zzz(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcfe
    public final void zzl() {
        synchronized (this) {
            this.zzg = true;
            notify();
            release();
        }
        String str = this.zzf;
        if (str != null) {
            zzq(this.zzf, zzc(str), "externalAbort", "Programmatic precache abort.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzr(final boolean z, final long j) {
        final zzcdr zzcdrVar = (zzcdr) this.zzc.get();
        if (zzcdrVar != null) {
            zzcbv.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfm
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    int i = zzcfn.zzd;
                    zzcdrVar.zzu(z, j);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzs(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzt(int i, int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzu(String str, Exception exc) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Precache error", exc);
        com.google.android.gms.ads.internal.zzt.zzh().zzh(exc, "VideoStreamExoPlayerCache.onError");
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzv(String str, Exception exc) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Precache exception", exc);
        com.google.android.gms.ads.internal.zzt.zzh().zzh(exc, "VideoStreamExoPlayerCache.onException");
    }
}
