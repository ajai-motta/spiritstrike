package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.google.android.gms.internal.gtm.zzabq;
import com.google.android.gms.internal.gtm.zzacq;
import com.google.android.gms.internal.gtm.zzfx;
import com.google.android.gms.internal.gtm.zzrc;
import com.google.android.gms.internal.gtm.zzre;
import com.google.android.gms.internal.gtm.zzrf;
import com.google.android.gms.internal.gtm.zzrg;
import com.google.android.gms.internal.gtm.zzrh;
import com.google.android.gms.internal.gtm.zzrk;
import com.google.android.gms.internal.gtm.zzrm;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzeh implements zzae {
    private final Context zza;
    private final String zzb;
    private final ExecutorService zzc = zzfx.zza().zza(2);
    private zzdb zzd;

    zzeh(Context context, String str) {
        this.zza = context;
        this.zzb = str;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final synchronized void release() {
        this.zzc.shutdown();
    }

    @Override // com.google.android.gms.tagmanager.zzae
    public final zzrg zza(int i) {
        zzrg zzrgVarZza;
        try {
            InputStream inputStreamOpenRawResource = this.zza.getResources().openRawResource(i);
            zzdc.zzb.zzd("Attempting to load a container from the resource ID " + i + " (" + this.zza.getResources().getResourceName(i) + ")");
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzrm.zzc(inputStreamOpenRawResource, byteArrayOutputStream);
                try {
                    com.google.android.gms.internal.gtm.zzap zzapVarZzb = zzfp.zzb(zzcu.zza(new JSONObject(byteArrayOutputStream.toString("UTF-8"))));
                    zzrh zzrhVarZza = zzrg.zza();
                    for (int i2 = 0; i2 < zzapVarZzb.zzc(); i2++) {
                        zzrf zzrfVarZzb = zzre.zzb();
                        zzrfVarZzb.zzb(com.google.android.gms.internal.gtm.zzb.INSTANCE_NAME.toString(), zzapVarZzb.zzk(i2));
                        String string = com.google.android.gms.internal.gtm.zzb.FUNCTION.toString();
                        String strZzc = zzr.zzc();
                        com.google.android.gms.internal.gtm.zzak zzakVarZzg = com.google.android.gms.internal.gtm.zzap.zzg();
                        zzakVarZzg.zzt(1);
                        zzakVarZzg.zzt(5);
                        zzakVarZzg.zzp(strZzc);
                        zzakVarZzg.zzo(false);
                        zzrfVarZzb.zzb(string, (com.google.android.gms.internal.gtm.zzap) zzakVarZzg.zzD());
                        zzrfVarZzb.zzb(zzr.zzd(), zzapVarZzb.zzl(i2));
                        zzrhVarZza.zzb(zzrfVarZzb.zza());
                    }
                    zzrgVarZza = zzrhVarZza.zza();
                } catch (UnsupportedEncodingException unused) {
                    zzdc.zzb.zza("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
                    zzrgVarZza = null;
                } catch (JSONException unused2) {
                    Log.w("GoogleTagManager", "Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
                    zzrgVarZza = null;
                }
                if (zzrgVarZza != null) {
                    zzdc.zzb.zzd("The container was successfully loaded from the resource (using JSON file format)");
                    return zzrgVarZza;
                }
                try {
                    zzrg zzrgVarZzb = zzrm.zzb(com.google.android.gms.internal.gtm.zzz.zzl(byteArrayOutputStream.toByteArray(), zzabq.zza()));
                    zzdc.zzb.zzd("The container was successfully loaded from the resource (using binary file)");
                    return zzrgVarZzb;
                } catch (zzacq unused3) {
                    Log.e("GoogleTagManager", "The resource file is corrupted. The container cannot be extracted from the binary file");
                    return null;
                } catch (zzrk unused4) {
                    Log.w("GoogleTagManager", "The resource file is invalid. The container from the binary file is invalid");
                    return null;
                }
            } catch (IOException unused5) {
                Log.w("GoogleTagManager", "Error reading the default container with resource ID " + i + " (" + this.zza.getResources().getResourceName(i) + ")");
                return null;
            }
        } catch (Resources.NotFoundException unused6) {
            Log.w("GoogleTagManager", "Failed to load the container. No default container resource found with the resource ID " + i);
            return null;
        }
    }

    @Override // com.google.android.gms.tagmanager.zzae
    public final void zzb() {
        this.zzc.execute(new zzef(this));
    }

    @Override // com.google.android.gms.tagmanager.zzae
    public final void zzc(zzrc zzrcVar) {
        this.zzc.execute(new zzeg(this, zzrcVar));
    }

    @Override // com.google.android.gms.tagmanager.zzae
    public final void zzd(zzdb zzdbVar) {
        this.zzd = zzdbVar;
    }

    final File zze() {
        File dir = this.zza.getDir("google_tagmanager", 0);
        com.google.android.gms.internal.gtm.zzfm.zza();
        int i = com.google.android.gms.internal.gtm.zzfr.zza;
        return new File(new File(dir, "resource_".concat(String.valueOf(this.zzb))).getPath());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void zzf() {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzeh.zzf():void");
    }
}
