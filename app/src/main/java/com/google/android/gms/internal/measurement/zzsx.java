package com.google.android.gms.internal.measurement;

import android.net.Uri;
import io.ktor.sse.ServerSentEventKt;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface zzsx {

    /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzsx$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
    public final /* synthetic */ class CC {
        public static InputStream $default$zzd(zzsx _this, Uri uri) throws IOException {
            String strZzc = _this.zzc();
            String.valueOf(strZzc);
            throw new zzsk("openForRead not supported by ".concat(String.valueOf(strZzc)));
        }

        public static boolean $default$zze(zzsx _this, Uri uri) throws IOException {
            String strZzc = _this.zzc();
            String.valueOf(strZzc);
            throw new zzsk("exists not supported by ".concat(String.valueOf(strZzc)));
        }

        public static File $default$zzg(zzsx _this, Uri uri) throws IOException {
            String strZzc = _this.zzc();
            String strValueOf = String.valueOf(uri);
            StringBuilder sb = new StringBuilder(String.valueOf(strZzc).length() + 28 + String.valueOf(strValueOf).length());
            sb.append("Cannot convert uri to file ");
            sb.append(strZzc);
            sb.append(ServerSentEventKt.SPACE);
            sb.append(strValueOf);
            throw new zzsk(sb.toString());
        }

        public static OutputStream $default$zzj(zzsx _this, Uri uri) throws IOException {
            String strZzc = _this.zzc();
            String.valueOf(strZzc);
            throw new zzsk("openForWrite not supported by ".concat(String.valueOf(strZzc)));
        }

        public static void $default$zzk(zzsx _this, Uri uri) throws IOException {
            String strZzc = _this.zzc();
            String.valueOf(strZzc);
            throw new zzsk("deleteFile not supported by ".concat(String.valueOf(strZzc)));
        }

        public static void $default$zzl(zzsx _this, Uri uri, Uri uri2) throws IOException {
            String strZzc = _this.zzc();
            String.valueOf(strZzc);
            throw new zzsk("rename not supported by ".concat(String.valueOf(strZzc)));
        }
    }

    String zzc();

    InputStream zzd(Uri uri) throws IOException;

    boolean zze(Uri uri) throws IOException;

    File zzg(Uri uri) throws IOException;

    OutputStream zzj(Uri uri) throws IOException;

    void zzk(Uri uri) throws IOException;

    void zzl(Uri uri, Uri uri2) throws IOException;
}
