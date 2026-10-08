package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import java.security.cert.CertificateEncodingException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzazu {
    public static String zza(Context context, String str, List list, Executor executor) throws ExecutionException, InterruptedException, PackageManager.NameNotFoundException, CertificateEncodingException {
        if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals(ExifInterface.LATITUDE_SOUTH)) {
            return null;
        }
        final zzgvb zzgvbVarZze = zzgvb.zze();
        context.getPackageManager().requestChecksums(str, false, 8, list, new PackageManager.OnChecksumsReadyListener() { // from class: com.google.android.gms.internal.ads.zzazt
            @Override // android.content.pm.PackageManager.OnChecksumsReadyListener
            public final /* synthetic */ void onChecksumsReady(List list2) {
                zzgvb zzgvbVar = zzgvbVarZze;
                if (list2 == null) {
                    zzgvbVar.zza((Object) null);
                    return;
                }
                try {
                    int size = list2.size();
                    for (int i = 0; i < size; i++) {
                        ApkChecksum apkChecksum = (ApkChecksum) list2.get(i);
                        if (apkChecksum.getType() == 8) {
                            zzgvbVar.zza(zzayg.zza(apkChecksum.getValue()));
                            return;
                        }
                    }
                    zzgvbVar.zza((Object) null);
                } catch (Throwable unused) {
                    zzgvbVar.zza((Object) null);
                }
            }
        });
        return (String) zzgvbVarZze.get();
    }
}
