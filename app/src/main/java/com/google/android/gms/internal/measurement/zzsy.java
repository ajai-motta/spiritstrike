package com.google.android.gms.internal.measurement;

import android.net.Uri;
import com.google.android.gms.internal.measurement.zzsx;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzsy implements zzsx {
    protected abstract zzsx zzb();

    @Override // com.google.android.gms.internal.measurement.zzsx
    public /* synthetic */ InputStream zzd(Uri uri) {
        return zzsx.CC.$default$zzd(this, uri);
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public /* synthetic */ boolean zze(Uri uri) {
        return zzsx.CC.$default$zze(this, uri);
    }

    protected Uri zzf(Uri uri) throws IOException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public /* synthetic */ File zzg(Uri uri) {
        return zzsx.CC.$default$zzg(this, uri);
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final OutputStream zzj(Uri uri) throws IOException {
        return zzb().zzj(zzf(uri));
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final void zzk(Uri uri) throws IOException {
        zzb().zzk(zzf(uri));
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final void zzl(Uri uri, Uri uri2) throws IOException {
        zzb().zzl(zzf(uri), zzf(uri2));
    }
}
