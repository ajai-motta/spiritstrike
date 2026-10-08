package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.preload.PreloadCallback;
import com.google.android.gms.ads.preload.PreloadConfiguration;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbeu;
import com.google.android.gms.internal.ads.zzbnw;
import com.google.android.gms.internal.ads.zzboe;
import com.google.android.gms.internal.ads.zzbof;
import com.google.android.gms.internal.ads.zzgmu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzex {
    public static final Set zza = new HashSet(Arrays.asList(AdFormat.APP_OPEN_AD, AdFormat.INTERSTITIAL, AdFormat.REWARDED));
    private static zzex zze;
    private zzep zzb;
    private zzfb zzc;
    private zzeo zzd;
    private zzdb zzl;
    private final Object zzf = new Object();
    private final Object zzg = new Object();
    private boolean zzi = false;
    private boolean zzj = false;
    private final Object zzk = new Object();
    private OnAdInspectorClosedListener zzm = null;
    private RequestConfiguration zzn = new RequestConfiguration.Builder().build();
    private final ArrayList zzh = new ArrayList();

    private zzex() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InitializationStatus zzA(List list) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzbnw zzbnwVar = (zzbnw) it.next();
            map.put(zzbnwVar.zza, new zzboe(zzbnwVar.zzb ? AdapterStatus.State.READY : AdapterStatus.State.NOT_READY, zzbnwVar.zzd, zzbnwVar.zzc));
        }
        return new zzbof(map);
    }

    private final void zzB(RequestConfiguration requestConfiguration) {
        try {
            this.zzl.zzr(new zzfv(requestConfiguration));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to set request configuration parcel.", e);
        }
    }

    private final void zzC(Context context) {
        if (this.zzl == null) {
            this.zzl = (zzdb) new zzau(zzbb.zzb(), context).zzd(context, false);
        }
    }

    private final void zzD(String str) {
        try {
            this.zzl.zze();
            this.zzl.zzj(null, ObjectWrapper.wrap(null));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj("MobileAdsSettingManager initialization failed", e);
        }
    }

    public static zzex zzb() {
        zzex zzexVar;
        synchronized (zzex.class) {
            if (zze == null) {
                zze = new zzex();
            }
            zzexVar = zze;
        }
        return zzexVar;
    }

    public final com.google.android.gms.ads.preload.zzb zza(AdFormat adFormat) {
        AdFormat adFormat2 = AdFormat.BANNER;
        int iOrdinal = adFormat.ordinal();
        if (iOrdinal == 1) {
            return this.zzb;
        }
        if (iOrdinal == 2) {
            return this.zzc;
        }
        if (iOrdinal != 5) {
            return null;
        }
        return this.zzd;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0078 A[Catch: all -> 0x005e, TryCatch #1 {, blocks: (B:24:0x0030, B:26:0x0050, B:34:0x0067, B:36:0x0078, B:38:0x008a, B:45:0x00cd, B:46:0x00e2, B:39:0x009a, B:41:0x00a8, B:43:0x00ba, B:44:0x00c5, B:28:0x0058, B:33:0x0062), top: B:55:0x0030, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009a A[Catch: all -> 0x005e, TryCatch #1 {, blocks: (B:24:0x0030, B:26:0x0050, B:34:0x0067, B:36:0x0078, B:38:0x008a, B:45:0x00cd, B:46:0x00e2, B:39:0x009a, B:41:0x00a8, B:43:0x00ba, B:44:0x00c5, B:28:0x0058, B:33:0x0062), top: B:55:0x0030, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c5 A[Catch: all -> 0x005e, TryCatch #1 {, blocks: (B:24:0x0030, B:26:0x0050, B:34:0x0067, B:36:0x0078, B:38:0x008a, B:45:0x00cd, B:46:0x00e2, B:39:0x009a, B:41:0x00a8, B:43:0x00ba, B:44:0x00c5, B:28:0x0058, B:33:0x0062), top: B:55:0x0030, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzc(android.content.Context r3, java.lang.String r4, com.google.android.gms.ads.initialization.OnInitializationCompleteListener r5) {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzex.zzc(android.content.Context, java.lang.String, com.google.android.gms.ads.initialization.OnInitializationCompleteListener):void");
    }

    public final Status zzd(Context context, List list, PreloadCallback preloadCallback) {
        boolean z;
        Status status;
        zzbeu.zza(context);
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PreloadConfiguration preloadConfiguration = (PreloadConfiguration) it.next();
            String strValueOf = String.valueOf(preloadConfiguration.getAdFormat());
            String adUnitId = preloadConfiguration.getAdUnitId();
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 1 + String.valueOf(adUnitId).length());
            sb.append(strValueOf);
            sb.append("#");
            sb.append(adUnitId);
            String string = sb.toString();
            map.put(string, Integer.valueOf(((Integer) com.google.android.gms.ads.internal.util.client.zzf.zzd(map, string, 0)).intValue() + 1));
        }
        Iterator it2 = map.entrySet().iterator();
        while (true) {
            if (!it2.hasNext()) {
                z = false;
                break;
            }
            if (((Integer) ((Map.Entry) it2.next()).getValue()).intValue() > 1) {
                hashSet.add("Preload configurations include duplicated ad unit IDs and ad format combinations");
                z = true;
                break;
            }
        }
        HashMap map2 = new HashMap();
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            PreloadConfiguration preloadConfiguration2 = (PreloadConfiguration) it3.next();
            AdFormat adFormat = preloadConfiguration2.getAdFormat();
            if (zza.contains(preloadConfiguration2.getAdFormat())) {
                map2.put(adFormat, Integer.valueOf(((Integer) com.google.android.gms.ads.internal.util.client.zzf.zzd(map2, adFormat, 0)).intValue() + 1));
                if (preloadConfiguration2.getBufferSize() > 15) {
                    hashSet.add(String.format(Locale.US, "Preload configurations' buffer size exceeds the maximum limit %d for %s", 15, adFormat.name()));
                } else if (preloadConfiguration2.getBufferSize() < 0) {
                    hashSet.add(String.format(Locale.US, "Preload configurations' buffer size less than 0 for %s", adFormat.name()));
                }
            } else {
                String strValueOf2 = String.valueOf(preloadConfiguration2.getAdFormat());
                String.valueOf(strValueOf2);
                hashSet.add("PreloadConfiguration ad format is not supported:".concat(String.valueOf(strValueOf2)));
            }
            z = true;
        }
        EnumMap enumMap = new EnumMap(AdFormat.class);
        enumMap.put(AdFormat.APP_OPEN_AD, (Integer) zzbd.zzc().zzd(zzbeu.zzfd));
        enumMap.put(AdFormat.INTERSTITIAL, (Integer) zzbd.zzc().zzd(zzbeu.zzfb));
        enumMap.put(AdFormat.REWARDED, (Integer) zzbd.zzc().zzd(zzbeu.zzfc));
        for (Map.Entry entry : map2.entrySet()) {
            AdFormat adFormat2 = (AdFormat) entry.getKey();
            int iIntValue = ((Integer) entry.getValue()).intValue();
            Integer num = (Integer) com.google.android.gms.ads.internal.util.client.zzf.zzd(enumMap, adFormat2, 0);
            if (iIntValue > num.intValue()) {
                hashSet.add(String.format(Locale.US, "Preload configurations' size exceeds the maximum limit %d for %s", num, adFormat2.name()));
                z = true;
            }
        }
        if (z) {
            StringBuilder sb2 = new StringBuilder();
            Iterator it4 = hashSet.iterator();
            while (it4.hasNext()) {
                sb2.append((String) it4.next());
                if (it4.hasNext()) {
                    sb2.append(", ");
                }
            }
            String string2 = sb2.toString();
            com.google.android.gms.ads.internal.util.client.zzo.zzf(string2);
            status = new Status(13, string2);
        } else {
            status = Status.RESULT_SUCCESS;
        }
        String statusMessage = status.getStatusMessage();
        if (statusMessage == null) {
            statusMessage = "";
        }
        Preconditions.checkArgument(status.isSuccess(), statusMessage);
        synchronized (this.zzg) {
            ArrayList arrayList = new ArrayList();
            Iterator it5 = list.iterator();
            while (it5.hasNext()) {
                arrayList.add(com.google.android.gms.ads.internal.util.client.zzf.zzt(context, (PreloadConfiguration) it5.next(), 1));
            }
            try {
                com.google.android.gms.ads.zzb.zza(context).zze(arrayList, new zzeq(this, preloadCallback));
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to start preload.", e);
                return Status.RESULT_INTERNAL_ERROR;
            }
        }
        return Status.RESULT_SUCCESS;
    }

    public final void zze(float f) {
        boolean z = true;
        Preconditions.checkArgument(f >= 0.0f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        synchronized (this.zzk) {
            if (this.zzl == null) {
                z = false;
            }
            Preconditions.checkState(z, "MobileAds.initialize() must be called prior to setting the app volume.");
            try {
                this.zzl.zzf(f);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to set app volume.", e);
            }
        }
    }

    public final void zzg(boolean z) {
        synchronized (this.zzk) {
            Preconditions.checkState(this.zzl != null, "MobileAds.initialize() must be called prior to setting app muted state.");
            try {
                this.zzl.zzh(z);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to set app mute state.", e);
            }
        }
    }

    public final void zzi(Context context, String str) {
        synchronized (this.zzk) {
            Preconditions.checkState(this.zzl != null, "MobileAds.initialize() must be called prior to opening debug menu.");
            try {
                this.zzl.zzi(ObjectWrapper.wrap(context), str);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to open debug menu.", e);
            }
        }
    }

    public final void zzj(Class cls) {
        synchronized (this.zzk) {
            try {
                this.zzl.zzn(cls.getCanonicalName());
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to register RtbAdapter", e);
            }
        }
    }

    public final InitializationStatus zzk() {
        InitializationStatus initializationStatusZzA;
        synchronized (this.zzk) {
            Preconditions.checkState(this.zzl != null, "MobileAds.initialize() must be called prior to getting initialization status.");
            try {
                initializationStatusZzA = zzA(this.zzl.zzq());
            } catch (RemoteException unused) {
                com.google.android.gms.ads.internal.util.client.zzo.zzf("Unable to get Initialization status.");
                return new InitializationStatus() { // from class: com.google.android.gms.ads.internal.client.zzet
                    @Override // com.google.android.gms.ads.initialization.InitializationStatus
                    public final /* synthetic */ Map getAdapterStatusMap() {
                        HashMap map = new HashMap();
                        map.put("com.google.android.gms.ads.MobileAds", new zzer(this.zza));
                        return map;
                    }
                };
            }
        }
        return initializationStatusZzA;
    }

    public final void zzl(Context context) {
        synchronized (this.zzk) {
            zzC(context);
            try {
                this.zzl.zzs();
            } catch (RemoteException unused) {
                com.google.android.gms.ads.internal.util.client.zzo.zzf("Unable to disable mediation adapter initialization.");
            }
        }
    }

    public final void zzm(Context context, OnAdInspectorClosedListener onAdInspectorClosedListener) {
        synchronized (this.zzk) {
            zzC(context);
            this.zzm = onAdInspectorClosedListener;
            try {
                this.zzl.zzt(new zzev(null));
            } catch (RemoteException unused) {
                com.google.android.gms.ads.internal.util.client.zzo.zzf("Unable to open the ad inspector.");
                if (onAdInspectorClosedListener != null) {
                    onAdInspectorClosedListener.onAdInspectorClosed(new AdInspectorError(0, "Ad inspector had an internal error.", MobileAds.ERROR_DOMAIN));
                }
            }
        }
    }

    public final String zzn() {
        String strZza;
        synchronized (this.zzk) {
            Preconditions.checkState(this.zzl != null, "MobileAds.initialize() must be called prior to getting version string.");
            try {
                strZza = zzgmu.zza(this.zzl.zzm());
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to get internal version.", e);
                return "";
            }
        }
        return strZza;
    }

    public final RequestConfiguration zzo() {
        return this.zzn;
    }

    public final void zzp(RequestConfiguration requestConfiguration) {
        Preconditions.checkArgument(requestConfiguration != null, "Null passed to setRequestConfiguration.");
        synchronized (this.zzk) {
            RequestConfiguration requestConfiguration2 = this.zzn;
            this.zzn = requestConfiguration;
            if (this.zzl == null) {
                return;
            }
            if (requestConfiguration2.getTagForChildDirectedTreatment() != requestConfiguration.getTagForChildDirectedTreatment() || requestConfiguration2.getTagForUnderAgeOfConsent() != requestConfiguration.getTagForUnderAgeOfConsent()) {
                zzB(requestConfiguration);
            }
        }
    }

    public final boolean zzq(boolean z) {
        synchronized (this.zzk) {
            Preconditions.checkState(this.zzl != null, "MobileAds.initialize() must be called prior to enable/disable the publisher first-party ID.");
            try {
                this.zzl.zzu(z);
            } catch (RemoteException e) {
                String str = z ? "enable" : "disable";
                StringBuilder sb = new StringBuilder(str.length() + 40);
                sb.append("Unable to ");
                sb.append(str);
                sb.append(" the publisher first-party ID.");
                com.google.android.gms.ads.internal.util.client.zzo.zzg(sb.toString(), e);
                return false;
            }
        }
        return true;
    }

    public final void zzr(String str) {
        synchronized (this.zzk) {
            Preconditions.checkState(this.zzl != null, "MobileAds.initialize() must be called prior to setting the plugin.");
            try {
                this.zzl.zzv(str);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to set plugin.", e);
            }
        }
    }

    final /* synthetic */ void zzs(String str) {
        synchronized (this.zzk) {
            zzD(null);
        }
    }

    final /* synthetic */ void zzt(String str) {
        synchronized (this.zzk) {
            zzD(null);
        }
    }

    final /* synthetic */ Object zzv() {
        return this.zzf;
    }

    final /* synthetic */ ArrayList zzw() {
        return this.zzh;
    }

    final /* synthetic */ void zzx(boolean z) {
        this.zzi = false;
    }

    final /* synthetic */ void zzy(boolean z) {
        this.zzj = true;
    }

    final /* synthetic */ OnAdInspectorClosedListener zzz() {
        return this.zzm;
    }

    public final float zzf() {
        synchronized (this.zzk) {
            zzdb zzdbVar = this.zzl;
            float fZzk = 1.0f;
            if (zzdbVar == null) {
                return 1.0f;
            }
            try {
                fZzk = zzdbVar.zzk();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to get app volume.", e);
            }
            return fZzk;
        }
    }

    public final boolean zzh() {
        synchronized (this.zzk) {
            zzdb zzdbVar = this.zzl;
            boolean zZzl = false;
            if (zzdbVar == null) {
                return false;
            }
            try {
                zZzl = zzdbVar.zzl();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to get app mute state.", e);
            }
            return zZzl;
        }
    }
}
