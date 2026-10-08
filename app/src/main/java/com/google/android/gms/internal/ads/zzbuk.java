package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.R;
import com.google.common.net.HttpHeaders;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbuk extends zzbun {
    private final Map zza;
    private final Context zzb;

    public zzbuk(zzcgy zzcgyVar, Map map) {
        super(zzcgyVar, "storePicture");
        this.zza = map;
        this.zzb = zzcgyVar.zzj();
    }

    public final void zza() {
        Context context = this.zzb;
        if (context == null) {
            zzg("Activity context is not available");
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzc();
        if (!new zzbeb(context).zza()) {
            zzg("Feature is not supported by the device.");
            return;
        }
        String str = (String) this.zza.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzg("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(str)) {
            String.valueOf(str);
            zzg("Invalid image url: ".concat(String.valueOf(str)));
            return;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        com.google.android.gms.ads.internal.zzt.zzc();
        if (TextUtils.isEmpty(lastPathSegment) || !lastPathSegment.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)")) {
            String.valueOf(lastPathSegment);
            zzg("Image type not recognized: ".concat(String.valueOf(lastPathSegment)));
            return;
        }
        Resources resourcesZzf = com.google.android.gms.ads.internal.zzt.zzh().zzf();
        com.google.android.gms.ads.internal.zzt.zzc();
        AlertDialog.Builder builderZzO = com.google.android.gms.ads.internal.util.zzs.zzO(context);
        builderZzO.setTitle(resourcesZzf != null ? resourcesZzf.getString(R.string.s1) : "Save image");
        builderZzO.setMessage(resourcesZzf != null ? resourcesZzf.getString(R.string.s2) : "Allow Ad to store image in Picture gallery?");
        builderZzO.setPositiveButton(resourcesZzf != null ? resourcesZzf.getString(R.string.s3) : HttpHeaders.ACCEPT, new zzbui(this, str, lastPathSegment));
        builderZzO.setNegativeButton(resourcesZzf != null ? resourcesZzf.getString(R.string.s4) : "Decline", new zzbuj(this));
        builderZzO.create().show();
    }

    final /* synthetic */ Context zzb() {
        return this.zzb;
    }
}
