package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzflc;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzebk {
    private static final Pattern zza = Pattern.compile("\\?");
    private final zzcjn zzb;
    private final Context zzc;
    private final VersionInfoParcel zzd;
    private final zzfgn zze;
    private final Executor zzf;
    private final ScheduledExecutorService zzg;
    private final String zzh;
    private final zzflm zzi;
    private final zzdvc zzj;
    private final zzfng zzk;
    private final zzdbs zzl;
    private final Object zzm = new Object();
    private String zzn;
    private List zzo;
    private Bundle zzp;
    private final zzbxr zzq;

    zzebk(zzcjn zzcjnVar, Context context, VersionInfoParcel versionInfoParcel, zzfgn zzfgnVar, Executor executor, String str, zzflm zzflmVar, zzdvc zzdvcVar, zzbxr zzbxrVar, zzeef zzeefVar, ScheduledExecutorService scheduledExecutorService, zzfng zzfngVar, zzdbs zzdbsVar) {
        this.zzb = zzcjnVar;
        this.zzc = context;
        this.zzd = versionInfoParcel;
        this.zze = zzfgnVar;
        this.zzf = executor;
        this.zzh = str;
        this.zzi = zzflmVar;
        zzcjnVar.zzB();
        this.zzj = zzdvcVar;
        this.zzq = zzbxrVar;
        this.zzg = scheduledExecutorService;
        this.zzk = zzfngVar;
        this.zzl = zzdbsVar;
    }

    private final ListenableFuture zzg(String str, final String str2) {
        ListenableFuture listenableFutureZza;
        String str3 = "";
        if (TextUtils.isEmpty(str)) {
            return zzgui.zzc(new zzekz(15, "Invalid ad string."));
        }
        Context context = this.zzc;
        zzflc zzflcVarZzn = zzflc.CC.zzn(context, 11);
        zzflcVarZzn.zza();
        zzbqp zzbqpVarZzb = com.google.android.gms.ads.internal.zzt.zzr().zzb(context, this.zzd, this.zzb.zzx());
        zzbqj zzbqjVar = zzbqm.zza;
        final zzbqf zzbqfVarZza = zzbqpVarZzb.zza("google.afma.response.normalize", zzbqjVar, zzbqjVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhF)).booleanValue()) {
            try {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.zzn = jSONObject.optString("fetch_url", "");
                    this.zzo = com.google.android.gms.ads.internal.util.zzbp.zza(new JSONObject(jSONObject.optString("settings", "")).getJSONArray("nofill_urls"), null);
                } catch (JSONException unused) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Invalid ad response.");
                }
            } catch (JSONException unused2) {
            }
            String string = this.zzn;
            final List list = this.zzo;
            if (TextUtils.isEmpty(string)) {
                listenableFutureZza = zzgui.zza(str);
                this.zzj.zzd("sst", "1");
            } else {
                this.zzj.zzd("sst", "2");
                String str4 = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhH);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhG)).booleanValue()) {
                    List listZze = zzgms.zzb(zza).zze(string);
                    if (listZze.size() < 2) {
                        listenableFutureZza = zzgui.zzc(new zzekz(1, "Invalid fetch URL."));
                    } else {
                        str3 = (String) listZze.get(1);
                        com.google.android.gms.ads.internal.zzt.zzc();
                        string = Uri.parse(string).buildUpon().query(null).build().toString();
                        final zzeec zzeecVar = new zzeec(string, 60000, new HashMap(), str3.getBytes(StandardCharsets.UTF_8), str4, false);
                        listenableFutureZza = (zzgua) zzgui.zzh((zzgua) zzgui.zzi(zzgua.zzw(zzcbv.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzebh
                            @Override // java.util.concurrent.Callable
                            public final /* synthetic */ Object call() {
                                return this.zza.zzd(zzeecVar);
                            }
                        })), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhI)).intValue(), TimeUnit.MILLISECONDS, this.zzg), Exception.class, new zzgtq() { // from class: com.google.android.gms.internal.ads.zzebi
                            @Override // com.google.android.gms.internal.ads.zzgtq
                            public final /* synthetic */ ListenableFuture zza(Object obj) {
                                return this.zza.zze(list, (Exception) obj);
                            }
                        }, this.zzf);
                    }
                } else {
                    final zzeec zzeecVar2 = new zzeec(string, 60000, new HashMap(), str3.getBytes(StandardCharsets.UTF_8), str4, false);
                    listenableFutureZza = (zzgua) zzgui.zzh((zzgua) zzgui.zzi(zzgua.zzw(zzcbv.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzebh
                        @Override // java.util.concurrent.Callable
                        public final /* synthetic */ Object call() {
                            return this.zza.zzd(zzeecVar2);
                        }
                    })), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhI)).intValue(), TimeUnit.MILLISECONDS, this.zzg), Exception.class, new zzgtq() { // from class: com.google.android.gms.internal.ads.zzebi
                        @Override // com.google.android.gms.internal.ads.zzgtq
                        public final /* synthetic */ ListenableFuture zza(Object obj) {
                            return this.zza.zze(list, (Exception) obj);
                        }
                    }, this.zzf);
                }
            }
        } else {
            listenableFutureZza = zzgui.zza(str);
            this.zzj.zzd("sst", "1");
        }
        zzgtq zzgtqVar = new zzgtq(this) { // from class: com.google.android.gms.internal.ads.zzebj
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj) throws JSONException {
                String str5 = (String) obj;
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                String str6 = str2;
                try {
                    jSONObject4.put("headers", new JSONObject());
                    jSONObject4.put(TtmlNode.TAG_BODY, str5);
                    jSONObject3.put("base_url", "");
                    jSONObject3.put("signals", new JSONObject(str6));
                    jSONObject2.put("request", jSONObject3);
                    jSONObject2.put("response", jSONObject4);
                    jSONObject2.put("flags", new JSONObject());
                    return zzgui.zza(jSONObject2);
                } catch (JSONException e) {
                    String strValueOf = String.valueOf(e.getCause());
                    String.valueOf(strValueOf);
                    throw new JSONException("Preloaded loader: ".concat(String.valueOf(strValueOf)));
                }
            }
        };
        Executor executor = this.zzf;
        ListenableFuture listenableFutureZzj = zzgui.zzj(zzgui.zzj(zzgui.zzj(listenableFutureZza, zzgtqVar, executor), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzebf
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzb(zzbqfVarZza, (JSONObject) obj);
            }
        }, executor), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzebg
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzc((JSONObject) obj);
            }
        }, executor);
        zzfll.zzd(listenableFutureZzj, this.zzi, zzflcVarZzn);
        zzgui.zzr(listenableFutureZzj, new zzebe(this), zzcbv.zzg);
        return listenableFutureZzj;
    }

    private final void zzh(zzduq zzduqVar) {
        Bundle bundleZze = this.zzj.zze();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhK)).booleanValue()) {
            bundleZze.putLong(zzduqVar.zza(), com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
        }
    }

    private final String zzi(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("ad_types");
            if (jSONArray != null && "unknown".equals(jSONArray.getString(0))) {
                jSONObject.put("ad_types", new JSONArray().put(this.zzh));
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            String strConcat = "Failed to update the ad types for rendering. ".concat(e.toString());
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi(strConcat);
            return str;
        }
    }

    private static final String zzj(String str) {
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x01f2 A[Catch: all -> 0x024a, TryCatch #3 {, blocks: (B:21:0x0080, B:23:0x009e, B:25:0x00a6, B:27:0x00b3, B:29:0x00cd, B:31:0x00fa, B:34:0x0106, B:36:0x010e, B:38:0x0114, B:42:0x011d, B:49:0x0153, B:45:0x0131, B:48:0x013e, B:54:0x015b, B:30:0x00e4, B:55:0x016f, B:62:0x018c, B:65:0x0194, B:69:0x01b9, B:71:0x01ce, B:75:0x01f2, B:77:0x0207, B:80:0x021b, B:82:0x0221, B:83:0x022e, B:85:0x0230, B:88:0x0239, B:87:0x0236, B:76:0x01fc, B:72:0x01e1, B:68:0x01a2, B:59:0x017c, B:60:0x0181), top: B:117:0x0080, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01fc A[Catch: all -> 0x024a, TryCatch #3 {, blocks: (B:21:0x0080, B:23:0x009e, B:25:0x00a6, B:27:0x00b3, B:29:0x00cd, B:31:0x00fa, B:34:0x0106, B:36:0x010e, B:38:0x0114, B:42:0x011d, B:49:0x0153, B:45:0x0131, B:48:0x013e, B:54:0x015b, B:30:0x00e4, B:55:0x016f, B:62:0x018c, B:65:0x0194, B:69:0x01b9, B:71:0x01ce, B:75:0x01f2, B:77:0x0207, B:80:0x021b, B:82:0x0221, B:83:0x022e, B:85:0x0230, B:88:0x0239, B:87:0x0236, B:76:0x01fc, B:72:0x01e1, B:68:0x01a2, B:59:0x017c, B:60:0x0181), top: B:117:0x0080, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0219 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0236 A[Catch: all -> 0x024a, TryCatch #3 {, blocks: (B:21:0x0080, B:23:0x009e, B:25:0x00a6, B:27:0x00b3, B:29:0x00cd, B:31:0x00fa, B:34:0x0106, B:36:0x010e, B:38:0x0114, B:42:0x011d, B:49:0x0153, B:45:0x0131, B:48:0x013e, B:54:0x015b, B:30:0x00e4, B:55:0x016f, B:62:0x018c, B:65:0x0194, B:69:0x01b9, B:71:0x01ce, B:75:0x01f2, B:77:0x0207, B:80:0x021b, B:82:0x0221, B:83:0x022e, B:85:0x0230, B:88:0x0239, B:87:0x0236, B:76:0x01fc, B:72:0x01e1, B:68:0x01a2, B:59:0x017c, B:60:0x0181), top: B:117:0x0080, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0241  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.common.util.concurrent.ListenableFuture zza() {
        /*
            Method dump skipped, instruction units count: 700
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzebk.zza():com.google.common.util.concurrent.ListenableFuture");
    }

    final /* synthetic */ ListenableFuture zzb(zzbqf zzbqfVar, JSONObject jSONObject) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcx)).booleanValue()) {
            this.zzj.zze().putLong(zzduq.SCAR_PRELOADER_PROCESSING_DONE.zza(), com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
        }
        return zzbqfVar.zzb(jSONObject);
    }

    final /* synthetic */ ListenableFuture zzc(JSONObject jSONObject) {
        zzfgc zzfgcVar = new zzfgc(this.zze);
        String string = jSONObject.toString();
        return zzgui.zza(new zzfgf(zzfgcVar, zzfge.zza(new StringReader(string), this.zzp)));
    }

    final /* synthetic */ String zzd(zzeec zzeecVar) throws zzekz {
        zzh(zzduq.RENDERING_ADSTRING_TYPE2_FETCH_START);
        int i = 0;
        int i2 = -1;
        while (true) {
            try {
                if (i >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhJ)).intValue()) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 40);
                    sb.append("Received HTTP error code from ad server:");
                    sb.append(i2);
                    throw new zzekz(1, sb.toString());
                }
                zzeed zzeedVarZzb = new zzeee(this.zzc, this.zzd.afmaVersion, this.zzq, Binder.getCallingUid(), null).zza(zzeecVar);
                zzeed zzeedVar = zzeedVarZzb;
                int i3 = zzeedVarZzb.zza;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhK)).booleanValue()) {
                    this.zzj.zzd("fr", String.valueOf(i));
                }
                if (i3 == 200) {
                    zzh(zzduq.RENDERING_ADSTRING_TYPE2_FETCH_END);
                    return zzeedVarZzb.zzc;
                }
                i++;
                i2 = i3;
            } catch (Exception e) {
                throw new zzekz(1, e.getMessage() == null ? "Fetch failed." : e.getMessage(), e);
            }
        }
    }

    final /* synthetic */ ListenableFuture zze(List list, Exception exc) {
        zzekz zzekzVar;
        com.google.android.gms.ads.internal.zzt.zzh().zzh(exc, "PreloadedLoader.getTypeTwoAdResponseString");
        if (exc instanceof TimeoutException) {
            zzekzVar = new zzekz(1, "Timed out waiting for ad response.");
        } else if (exc instanceof zzekz) {
            zzekzVar = (zzekz) exc;
        } else {
            zzekzVar = new zzekz(1, exc.getMessage() == null ? "Fetch failed." : exc.getMessage());
        }
        String message = zzekzVar.getMessage() == null ? "" : zzekzVar.getMessage();
        if (list != null && !list.isEmpty()) {
            String str = "0.6.0.0";
            if (!TextUtils.isEmpty(message)) {
                if (message.contains("Timed out waiting for ad response.")) {
                    message = "timeout";
                    str = "0.2.0.0";
                } else if (message.contains("Received HTTP error code from ad server:")) {
                    List listZze = zzgms.zza(zzglr.zzc(AbstractJsonLexerKt.COLON)).zze(message);
                    if (listZze.size() == 2) {
                        message = (String) listZze.get(1);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(zzfnc.zzd(zzfnc.zzd((String) it.next(), "@gw_adnetstatus@", str), "@error_code@", message));
            }
            this.zzk.zza(arrayList, null);
        }
        return zzgui.zzc(zzekzVar);
    }

    final /* synthetic */ zzdbs zzf() {
        return this.zzl;
    }
}
