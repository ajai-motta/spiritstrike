package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzayr extends zzazr {
    private static final zzazs zzh = new zzazs();
    private final zzatv zzi;
    private final Context zzj;
    private final zzavx zzk;

    public zzayr(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i, int i2, Context context, zzato zzatoVar, zzatv zzatvVar, zzavx zzavxVar) {
        super(zzaydVar, "yYlfo3JOLIfvdgBq3U3deu0pC6YiXdEdqGnVULE/KCllAkaO/XSsVQU+sKDN/uG0", "5ZNtOO3srzHnbl5PLlxEIuHlg0l+6HDun864hT7P5ko=", zzaucVar, i, 27);
        this.zzj = context;
        this.zzi = zzatvVar;
        this.zzk = zzavxVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final zzavu zzc() throws IllegalAccessException, InvocationTargetException {
        String str;
        int iIntValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdc)).booleanValue() ? ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdi)).intValue() : this.zzi.zzb();
        zzavu zzavuVar = new zzavu((String) this.zze.invoke(null, this.zzj, false, ""));
        zzavx zzavxVar = this.zzk;
        if (zzavxVar == null || zzavxVar.zza() == null) {
            str = ExifInterface.LONGITUDE_EAST;
        } else {
            try {
                str = (String) zzavxVar.zza().get(iIntValue, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException unused) {
                str = ExifInterface.LONGITUDE_EAST;
            }
        }
        zzavuVar.zza = str;
        return zzavuVar;
    }

    private final String zzd() {
        try {
            zzayd zzaydVar = this.zza;
            if (zzaydVar.zzm() != null) {
                zzaydVar.zzm().get();
            }
            zzauz zzauzVarZzl = zzaydVar.zzl();
            if (zzauzVarZzl == null || !zzauzVarZzl.zza()) {
                return null;
            }
            return zzauzVarZzl.zzb();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        int i;
        zzavu zzavuVarZzc;
        zzavu zzavuVar;
        zzazs zzazsVar = zzh;
        Context context = this.zzj;
        AtomicReference atomicReferenceZza = zzazsVar.zza(context.getPackageName());
        synchronized (atomicReferenceZza) {
            zzavu zzavuVar2 = (zzavu) atomicReferenceZza.get();
            if (zzavuVar2 == null || zzayg.zzc(zzavuVar2.zza) || zzavuVar2.zza.equals(ExifInterface.LONGITUDE_EAST) || zzavuVar2.zza.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                if (zzayg.zzc(null)) {
                    (!zzayg.zzc(null) ? false : false).booleanValue();
                    i = 3;
                } else {
                    i = 5;
                }
                if (this.zzk != null) {
                    zzavuVarZzc = zzc();
                } else {
                    Boolean boolValueOf = Boolean.valueOf(i == 3 && !this.zzi.zza());
                    Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcQ);
                    String strZzb = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcP)).booleanValue() ? zzb() : null;
                    if (bool.booleanValue() && this.zza.zzi() && zzayg.zzc(strZzb)) {
                        strZzb = zzd();
                    }
                    zzavu zzavuVar3 = new zzavu((String) this.zze.invoke(null, context, boolValueOf, strZzb));
                    if (zzayg.zzc(zzavuVar3.zza) || zzavuVar3.zza.equals(ExifInterface.LONGITUDE_EAST)) {
                        int i2 = i - 1;
                        if (i2 == 3) {
                            String strZzd = zzd();
                            if (!zzayg.zzc(strZzd)) {
                                zzavuVar3.zza = strZzd;
                            }
                        } else if (i2 == 4) {
                            throw null;
                        }
                    }
                    zzavuVarZzc = zzavuVar3;
                }
                atomicReferenceZza.set(zzavuVarZzc);
            }
            zzavuVar = (zzavu) atomicReferenceZza.get();
        }
        zzauc zzaucVar = this.zzd;
        synchronized (zzaucVar) {
            if (zzavuVar != null) {
                zzaucVar.zzo(zzavuVar.zza);
                zzaucVar.zzu(zzavuVar.zzb);
                zzaucVar.zzt(zzavuVar.zzc);
                zzaucVar.zzD(zzavuVar.zzd);
                zzaucVar.zzE(zzavuVar.zze);
            }
        }
    }

    protected final String zzb() {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance(AndroidStaticDeviceInfoDataSource.CERTIFICATE_TYPE_X509);
            byte[] bArrZzb = zzayg.zzb((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcR));
            ArrayList arrayList = new ArrayList();
            arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(bArrZzb)));
            if (!Build.TYPE.equals("user")) {
                arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(zzayg.zzb((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcS)))));
            }
            Context context = this.zzj;
            return zzazu.zza(context, context.getPackageName(), arrayList, this.zza.zzd());
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
            return null;
        }
    }
}
