package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.PatternSyntaxException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdzt {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final Executor zzc;
    private final AtomicReference zzd = new AtomicReference("");

    zzdzt(Context context, VersionInfoParcel versionInfoParcel, Executor executor) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = executor;
    }

    private final String zzc() {
        String name;
        VersionInfoParcel versionInfoParcel = this.zzb;
        String strZzd = null;
        if (versionInfoParcel.isClientJar) {
            name = zzchj.class.getName();
        } else {
            try {
                name = (String) new JSONObject(zzd((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzpc))).get(Integer.toString(versionInfoParcel.clientJarVersion));
            } catch (ClassCastException | IllegalArgumentException | NullPointerException | JSONException e) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzpb)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "SdkIE");
                }
                name = null;
            }
        }
        if (TextUtils.isEmpty(name)) {
            return "2";
        }
        try {
            strZzd = zzd((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzpd));
        } catch (IllegalArgumentException e2) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzpb)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zzh().zzg(e2, "SdkIE");
            }
        }
        if (TextUtils.isEmpty(strZzd)) {
            return ExifInterface.GPS_MEASUREMENT_3D;
        }
        try {
            for (Method method : this.zza.getClassLoader().loadClass(name).getDeclaredMethods()) {
                if (method.getName().matches(strZzd)) {
                    return "1";
                }
            }
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } catch (ClassNotFoundException unused) {
            return "4";
        } catch (NoClassDefFoundError unused2) {
            return "6";
        } catch (SecurityException unused3) {
            return "7";
        } catch (PatternSyntaxException unused4) {
            return "5";
        }
    }

    private static final String zzd(String str) throws IllegalArgumentException {
        return com.google.android.gms.ads.internal.util.zzs.zzl(new String(Base64.decode(str, 0)), new String(Base64.decode((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzpe), 10), StandardCharsets.UTF_8));
    }

    public final String zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzpa)).booleanValue()) {
            if (!((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzpc)).isEmpty()) {
                if (!((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzpd)).isEmpty()) {
                    if (!((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzpe)).isEmpty()) {
                        String str = (String) this.zzd.get();
                        if (!str.isEmpty()) {
                            return str;
                        }
                        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdzs
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                this.zza.zzb();
                            }
                        });
                        return null;
                    }
                }
            }
        }
        return null;
    }

    final /* synthetic */ void zzb() {
        AtomicReference atomicReference = this.zzd;
        synchronized (atomicReference) {
            if (((String) atomicReference.get()).isEmpty()) {
                atomicReference.set(zzc());
            }
        }
    }
}
