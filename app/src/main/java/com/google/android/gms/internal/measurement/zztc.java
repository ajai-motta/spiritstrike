package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface zztc {

    /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zztc$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
    public final /* synthetic */ class CC {
        public static InputStream $default$zzb(zztc _this, Uri uri, InputStream inputStream) throws IOException {
            if (inputStream != null) {
                inputStream.close();
            }
            String strZza = _this.zza();
            String.valueOf(strZza);
            throw new zzsk("wrapForRead not supported by ".concat(String.valueOf(strZza)));
        }

        public static OutputStream $default$zzc(zztc _this, Uri uri, OutputStream outputStream) throws IOException {
            if (outputStream != null) {
                outputStream.close();
            }
            String strZza = _this.zza();
            String.valueOf(strZza);
            throw new zzsk("wrapForWrite not supported by ".concat(String.valueOf(strZza)));
        }
    }

    String zza();

    InputStream zzb(Uri uri, InputStream inputStream) throws IOException;

    OutputStream zzc(Uri uri, OutputStream outputStream) throws IOException;
}
