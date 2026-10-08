package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzaif;
import com.google.android.gms.internal.measurement.zzaja;
import com.unity3d.services.core.fid.Constants;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgi extends zzg {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private final long zzg;
    private final long zzh;
    private List zzi;
    private String zzj;
    private final String zzk;
    private int zzl;
    private String zzm;
    private String zzn;
    private long zzo;
    private String zzp;

    zzgi(zzic zzicVar, long j, long j2, String str) {
        super(zzicVar);
        this.zzo = 0L;
        this.zzp = null;
        this.zzg = j;
        this.zzh = j2;
        this.zzk = str;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:0|2|(1:4)(19:85|6|(1:10)(2:11|(1:13))|87|14|(4:16|(1:18)(1:20)|81|21)|26|(2:28|(2:30|(2:32|(2:34|(2:36|(2:38|(1:40)(1:41))(1:42))(1:43))(1:44))(1:45))(1:46))(1:47)|48|83|49|(1:51)(1:52)|53|(1:55)(1:56)|57|(1:59)|63|(2:66|(1:68)(4:69|(3:72|(1:90)(1:91)|70)|89|75))(1:75)|(2:77|78)(2:79|80))|5|26|(0)(0)|48|83|49|(0)(0)|53|(0)(0)|57|(0)|63|(0)(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01a2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01a3, code lost:
    
        r11.zzu.zzaW().zzb().zzc("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.zzgu.zzl(r1), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0176 A[Catch: IllegalStateException -> 0x01a2, TryCatch #1 {IllegalStateException -> 0x01a2, blocks: (B:49:0x016d, B:53:0x0184, B:57:0x018c, B:59:0x0190, B:52:0x0176), top: B:83:0x016d }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0190 A[Catch: IllegalStateException -> 0x01a2, TRY_LEAVE, TryCatch #1 {IllegalStateException -> 0x01a2, blocks: (B:49:0x016d, B:53:0x0184, B:57:0x018c, B:59:0x0190, B:52:0x0176), top: B:83:0x016d }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x020b  */
    @Override // com.google.android.gms.measurement.internal.zzg
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void zzf() {
        /*
            Method dump skipped, instruction units count: 526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgi.zzf():void");
    }

    final zzr zzh(String str) {
        String str2;
        String str3;
        boolean z;
        long j;
        int i;
        List list;
        String str4;
        int i2;
        long j2;
        ApplicationInfo applicationInfo;
        long jZzR;
        zzg();
        String strZzj = zzj();
        String strZzk = zzk();
        zzb();
        String str5 = this.zzb;
        zzb();
        long j3 = this.zzc;
        zzb();
        Preconditions.checkNotNull(this.zzd);
        String str6 = this.zzd;
        zzic zzicVar = this.zzu;
        zzicVar.zzc().zzi();
        zzb();
        zzg();
        long j4 = this.zzf;
        if (j4 == 0) {
            zzpp zzppVarZzk = this.zzu.zzk();
            Context contextZzaZ = zzicVar.zzaZ();
            String packageName = zzicVar.zzaZ().getPackageName();
            zzppVarZzk.zzg();
            Preconditions.checkNotNull(contextZzaZ);
            Preconditions.checkNotEmpty(packageName);
            PackageManager packageManager = contextZzaZ.getPackageManager();
            MessageDigest messageDigestZzQ = zzpp.zzQ();
            if (messageDigestZzQ == null) {
                zzppVarZzk.zzu.zzaW().zzb().zza("Could not get MD5 instance");
                j4 = -1;
            } else if (packageManager != null) {
                try {
                    if (zzppVarZzk.zzag(contextZzaZ, packageName)) {
                        jZzR = 0;
                    } else {
                        PackageManagerWrapper packageManagerWrapperPackageManager = Wrappers.packageManager(contextZzaZ);
                        zzic zzicVar2 = zzppVarZzk.zzu;
                        PackageInfo packageInfo = packageManagerWrapperPackageManager.getPackageInfo(zzicVar2.zzaZ().getPackageName(), 64);
                        if (packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                            zzicVar2.zzaW().zze().zza("Could not get signatures");
                            jZzR = -1;
                        } else {
                            jZzR = zzpp.zzR(messageDigestZzQ.digest(packageInfo.signatures[0].toByteArray()));
                        }
                    }
                    j4 = jZzR;
                } catch (PackageManager.NameNotFoundException e) {
                    zzppVarZzk.zzu.zzaW().zzb().zzb("Package name not found", e);
                    j4 = 0;
                }
            } else {
                j4 = 0;
            }
            this.zzf = j4;
        }
        long j5 = j4;
        zzic zzicVar3 = this.zzu;
        zzic zzicVar4 = this.zzu;
        boolean zZzB = zzicVar3.zzB();
        boolean z2 = !zzicVar4.zzd().zzm;
        zzg();
        if (zzicVar3.zzB()) {
            zzaja.zza();
            if (zzicVar4.zzc().zzp(null, zzfy.zzaH)) {
                this.zzu.zzaW().zzk().zza("Disabled IID for tests.");
            } else {
                try {
                    Class<?> clsLoadClass = zzicVar4.zzaZ().getClassLoader().loadClass(Constants.FID_CLASS);
                    if (clsLoadClass != null) {
                        try {
                            Object objInvoke = clsLoadClass.getDeclaredMethod(Constants.GET_INSTANCE, Context.class).invoke(null, this.zzu.zzaZ());
                            if (objInvoke != null) {
                                try {
                                    str2 = (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(objInvoke, new Object[0]);
                                } catch (Exception unused) {
                                    this.zzu.zzaW().zzh().zza("Failed to retrieve Firebase Instance Id");
                                    str2 = null;
                                }
                            }
                        } catch (Exception unused2) {
                            this.zzu.zzaW().zzf().zza("Failed to obtain Firebase Analytics instance");
                        }
                    }
                } catch (ClassNotFoundException unused3) {
                }
            }
            str2 = null;
        } else {
            str2 = null;
        }
        zzic zzicVar5 = this.zzu;
        long jZza = zzicVar5.zzd().zzc.zza();
        long jMin = jZza == 0 ? zzicVar5.zza : Math.min(zzicVar5.zza, jZza);
        zzb();
        int i3 = this.zzl;
        zzic zzicVar6 = this.zzu;
        boolean zZzu = zzicVar6.zzc().zzu();
        zzhh zzhhVarZzd = zzicVar6.zzd();
        zzhhVarZzd.zzg();
        boolean z3 = zzhhVarZzd.zzd().getBoolean("deferred_analytics_collection", false);
        if (zzicVar6.zzc().zzw("google_analytics_default_allow_ad_personalization_signals", true) != zzji.GRANTED) {
            str3 = "google_analytics_default_allow_ad_personalization_signals";
            z = true;
        } else {
            str3 = "google_analytics_default_allow_ad_personalization_signals";
            z = false;
        }
        long j6 = this.zzg;
        Boolean boolValueOf = Boolean.valueOf(z);
        List list2 = this.zzi;
        String strZzl = zzicVar6.zzd().zzl().zzl();
        if (this.zzj == null) {
            this.zzj = zzicVar6.zzk().zzaz();
        }
        String str7 = this.zzj;
        if (zzicVar6.zzd().zzl().zzo(zzjk.ANALYTICS_STORAGE)) {
            zzg();
            j = 0;
            if (this.zzo == 0) {
                i = i3;
                list = list2;
            } else {
                i = i3;
                list = list2;
                long jCurrentTimeMillis = zzicVar6.zzba().currentTimeMillis() - this.zzo;
                if (this.zzn != null && jCurrentTimeMillis > 86400000 && this.zzp == null) {
                    zzi();
                }
            }
            if (this.zzn == null) {
                zzi();
            }
            str4 = this.zzn;
        } else {
            i = i3;
            list = list2;
            j = 0;
            str4 = null;
        }
        boolean zZzx = zzicVar6.zzc().zzx();
        zzpp zzppVarZzk2 = zzicVar6.zzk();
        String strZzj2 = zzj();
        zzic zzicVar7 = zzppVarZzk2.zzu;
        if (zzicVar7.zzaZ().getPackageManager() == null) {
            j2 = j;
            i2 = 0;
        } else {
            try {
                i2 = 0;
            } catch (PackageManager.NameNotFoundException unused4) {
                i2 = 0;
            }
            try {
                applicationInfo = Wrappers.packageManager(zzicVar7.zzaZ()).getApplicationInfo(strZzj2, 0);
            } catch (PackageManager.NameNotFoundException unused5) {
                zzic zzicVar8 = zzppVarZzk2.zzu;
                zzicVar8.zzaV();
                zzicVar8.zzaW().zzi().zzb("PackageManager failed to find running app: app_id", strZzj2);
            }
            int i4 = applicationInfo != null ? applicationInfo.targetSdkVersion : i2;
            j2 = i4;
        }
        zzic zzicVar9 = this.zzu;
        int iZzb = zzicVar9.zzd().zzl().zzb();
        String strZze = zzicVar9.zzd().zzj().zze();
        zzaif.zza();
        zzal zzalVarZzc = zzicVar9.zzc();
        zzfx zzfxVar = zzfy.zzaP;
        int iZzW = zzalVarZzc.zzp(null, zzfxVar) ? zzicVar9.zzk().zzW() : i2;
        zzaif.zza();
        long jZzX = zzicVar9.zzc().zzp(null, zzfxVar) ? zzicVar9.zzk().zzX() : j;
        String strZzz = zzicVar9.zzc().zzz();
        String strZzb = new zze(zzicVar9.zzc().zzw(str3, true)).zzb();
        zzic zzicVar10 = this.zzu;
        return new zzr(strZzj, strZzk, str5, j3, str6, 161000L, j5, str, zZzB, z2, str2, jMin, i, zZzu, z3, boolValueOf, j6, list, strZzl, str7, str4, zZzx, j2, iZzb, strZze, iZzW, jZzX, strZzz, strZzb, zzicVar10.zza, this.zzu.zzx().zzj().zza(), zzicVar9.zzc().zzp(null, zzfy.zzbe) ? zzicVar10.zzb : j);
    }

    final void zzi() {
        String str;
        zzg();
        zzic zzicVar = this.zzu;
        if (zzicVar.zzd().zzl().zzo(zzjk.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            zzicVar.zzk().zzf().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            zzicVar.zzaW().zzj().zza("Analytics Storage consent is not granted");
            str = null;
        }
        zzgs zzgsVarZzj = zzicVar.zzaW().zzj();
        Object[] objArr = new Object[1];
        objArr[0] = str == null ? AbstractJsonLexerKt.NULL : "not null";
        zzgsVarZzj.zza(String.format("Resetting session stitching token to %s", objArr));
        this.zzn = str;
        this.zzo = zzicVar.zzba().currentTimeMillis();
    }

    final String zzj() {
        zzb();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    final String zzk() {
        zzg();
        zzb();
        Preconditions.checkNotNull(this.zzm);
        return this.zzm;
    }

    final String zzl() {
        zzb();
        Preconditions.checkNotNull(this.zze);
        return this.zze;
    }

    final int zzm() {
        zzb();
        return this.zzc;
    }

    final long zzn() {
        return this.zzh;
    }

    final int zzo() {
        zzb();
        return this.zzl;
    }

    final List zzp() {
        return this.zzi;
    }

    final boolean zzq(String str) {
        String str2 = this.zzp;
        boolean z = false;
        if (str2 != null && !str2.equals(str)) {
            z = true;
        }
        this.zzp = str;
        return z;
    }
}
