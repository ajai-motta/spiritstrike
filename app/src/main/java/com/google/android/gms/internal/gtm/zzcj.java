package com.google.android.gms.internal.gtm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzcj extends zzbr {
    private boolean zza;
    private final zzcd zzb;
    private final zzer zzc;
    private final zzep zzd;
    private final zzcb zze;
    private long zzf;
    private final zzcv zzg;
    private final zzcv zzh;
    private final zzfb zzi;
    private long zzj;
    private boolean zzk;

    protected zzcj(zzbu zzbuVar, zzbv zzbvVar) {
        super(zzbuVar);
        Preconditions.checkNotNull(zzbvVar);
        this.zzf = Long.MIN_VALUE;
        this.zzd = new zzep(zzbuVar);
        this.zzb = new zzcd(zzbuVar);
        this.zzc = new zzer(zzbuVar);
        this.zze = new zzcb(zzbuVar);
        this.zzi = new zzfb(zzC());
        this.zzg = new zzcf(this, zzbuVar);
        this.zzh = new zzcg(this, zzbuVar);
    }

    private final void zzaf() {
        zzcx zzcxVarZzy = zzy();
        if (zzcxVarZzy.zze()) {
            zzcxVarZzy.zza();
        }
    }

    private final void zzag() {
        if (this.zzg.zzh()) {
            zzN("All hits dispatched or no network/service. Going to power save mode");
        }
        this.zzg.zzf();
    }

    private final void zzah() {
        long jZzc;
        zzcx zzcxVarZzy = zzy();
        if (zzcxVarZzy.zzc() && !zzcxVarZzy.zze()) {
            com.google.android.gms.analytics.zzr.zzh();
            zzV();
            try {
                jZzc = this.zzb.zzc();
            } catch (SQLiteException e) {
                zzJ("Failed to get min/max hit times from local store", e);
                jZzc = 0;
            }
            if (jZzc != 0) {
                long jAbs = Math.abs(zzC().currentTimeMillis() - jZzc);
                zzw();
                if (jAbs <= ((Long) zzeh.zzh.zzb()).longValue()) {
                    zzw();
                    zzO("Dispatch alarm scheduled (ms)", Long.valueOf(zzcs.zzd()));
                    zzcxVarZzy.zzb();
                }
            }
        }
    }

    private final void zzai(zzbw zzbwVar, zzav zzavVar) {
        Preconditions.checkNotNull(zzbwVar);
        Preconditions.checkNotNull(zzavVar);
        com.google.android.gms.analytics.zza zzaVar = new com.google.android.gms.analytics.zza(zzt());
        zzaVar.zzc(zzbwVar.zzc());
        zzaVar.zzd(zzbwVar.zzf());
        com.google.android.gms.analytics.zzh zzhVarZza = zzaVar.zza();
        zzbd zzbdVar = (zzbd) zzhVarZza.zzb(zzbd.class);
        zzbdVar.zzk("data");
        zzbdVar.zzl(true);
        zzhVarZza.zzg(zzavVar);
        zzay zzayVar = (zzay) zzhVarZza.zzb(zzay.class);
        zzau zzauVar = (zzau) zzhVarZza.zzb(zzau.class);
        for (Map.Entry entry : zzbwVar.zzd().entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if ("an".equals(str)) {
                zzauVar.zzk(str2);
            } else if ("av".equals(str)) {
                zzauVar.zzl(str2);
            } else if ("aid".equals(str)) {
                zzauVar.zzi(str2);
            } else if ("aiid".equals(str)) {
                zzauVar.zzj(str2);
            } else if ("uid".equals(str)) {
                zzbdVar.zzm(str2);
            } else {
                zzayVar.zze(str, str2);
            }
        }
        zzG("Sending installation campaign to", zzbwVar.zzc(), zzavVar);
        zzhVarZza.zzj(zzA().zza());
        zzhVarZza.zzk();
    }

    private final boolean zzaj(String str) {
        return Wrappers.packageManager(zzo()).checkCallingOrSelfPermission(str) == 0;
    }

    static /* bridge */ /* synthetic */ void zzc(zzcj zzcjVar) {
        try {
            zzcjVar.zzb.zza();
            zzcjVar.zzad();
        } catch (SQLiteException e) {
            zzcjVar.zzR("Failed to delete stale hits", e);
        }
        zzcv zzcvVar = zzcjVar.zzh;
        zzcjVar.zzw();
        zzcvVar.zzg(86400000L);
    }

    public final void zzY(long j) {
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        if (j < 0) {
            j = 0;
        }
        this.zzf = j;
        zzad();
    }

    final void zzZ() {
        zzV();
        Preconditions.checkState(!this.zza, "Analytics backend already started");
        this.zza = true;
        zzq().zzi(new zzch(this));
    }

    public final long zza() {
        long j = this.zzf;
        if (j != Long.MIN_VALUE) {
            return j;
        }
        zzw();
        long jLongValue = ((Long) zzeh.zze.zzb()).longValue();
        zzfg zzfgVarZzB = zzB();
        zzfgVarZzB.zzV();
        if (!zzfgVarZzB.zzc) {
            return jLongValue;
        }
        zzfg zzfgVarZzB2 = zzB();
        zzfgVarZzB2.zzV();
        return ((long) zzfgVarZzB2.zzd) * 1000;
    }

    protected final void zzaa() {
        zzV();
        zzw();
        com.google.android.gms.analytics.zzr.zzh();
        Context contextZza = zzt().zza();
        if (!zzev.zzb(contextZza)) {
            zzQ("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!zzfa.zzh(contextZza)) {
            zzI("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.zzb(contextZza)) {
            zzQ("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        zzA().zza();
        if (!zzaj("android.permission.ACCESS_NETWORK_STATE")) {
            zzI("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzac();
        }
        if (!zzaj("android.permission.INTERNET")) {
            zzI("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzac();
        }
        if (zzfa.zzh(zzo())) {
            zzN("AnalyticsService registered in the app manifest and enabled");
        } else {
            zzw();
            zzQ("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!this.zzk) {
            zzw();
            if (!this.zzb.zzab()) {
                zzi();
            }
        }
        zzad();
    }

    public final void zzab() {
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        zzE("Sync dispatching local hits");
        long j = this.zzj;
        zzw();
        zzi();
        try {
            zzae();
            zzA().zzi();
            zzad();
            if (this.zzj != j) {
                this.zzd.zzb();
            }
        } catch (Exception e) {
            zzJ("Sync local dispatch failed", e);
            zzad();
        }
    }

    public final void zzac() {
        zzV();
        com.google.android.gms.analytics.zzr.zzh();
        this.zzk = true;
        this.zze.zzc();
        zzad();
    }

    public final void zzad() {
        long jMin;
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        if (!this.zzk) {
            zzw();
            if (zza() > 0) {
                if (this.zzb.zzab()) {
                    this.zzd.zzc();
                    zzag();
                    zzaf();
                    return;
                }
                if (!((Boolean) zzeh.zzz.zzb()).booleanValue()) {
                    this.zzd.zza();
                    if (!this.zzd.zzd()) {
                        zzag();
                        zzaf();
                        zzah();
                        return;
                    }
                }
                zzah();
                long jZza = zza();
                long jZzb = zzA().zzb();
                if (jZzb != 0) {
                    jMin = jZza - Math.abs(zzC().currentTimeMillis() - jZzb);
                    if (jMin <= 0) {
                        zzw();
                        jMin = Math.min(zzcs.zze(), jZza);
                    }
                } else {
                    zzw();
                    jMin = Math.min(zzcs.zze(), jZza);
                }
                zzO("Dispatch scheduled (ms)", Long.valueOf(jMin));
                if (!this.zzg.zzh()) {
                    this.zzg.zzg(jMin);
                    return;
                } else {
                    this.zzg.zze(Math.max(1L, jMin + this.zzg.zzb()));
                    return;
                }
            }
        }
        this.zzd.zzc();
        zzag();
        zzaf();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005b, code lost:
    
        zzN("Store is empty, nothing to dispatch");
        zzag();
        zzaf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ac, code lost:
    
        if (r11.zze.zzg() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ae, code lost:
    
        zzw();
        zzN("Service connected, sending hits to the service");
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ba, code lost:
    
        if (r6.isEmpty() != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00bc, code lost:
    
        r7 = (com.google.android.gms.internal.gtm.zzek) r6.get(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c8, code lost:
    
        if (r11.zze.zzh(r7) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00cb, code lost:
    
        r4 = java.lang.Math.max(r4, r7.zzb());
        r6.remove(r7);
        zzF("Hit sent do device AnalyticsService for delivery", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00db, code lost:
    
        r11.zzb.zzn(r7.zzb());
        r3.add(java.lang.Long.valueOf(r7.zzb()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f1, code lost:
    
        zzJ("Failed to remove hit that was send for delivery", r0);
        zzag();
        zzaf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0103, code lost:
    
        if (r11.zzc.zze() == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0105, code lost:
    
        r6 = r11.zzc.zzc(r6);
        r7 = r6.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0113, code lost:
    
        if (r7.hasNext() == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0115, code lost:
    
        r4 = java.lang.Math.max(r4, ((java.lang.Long) r7.next()).longValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0124, code lost:
    
        r11.zzb.zzY(r6);
        r3.addAll(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x012d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x012e, code lost:
    
        zzJ("Failed to remove successfully uploaded hits", r0);
        zzag();
        zzaf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x013e, code lost:
    
        if (r3.isEmpty() != false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x014c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0171, code lost:
    
        zzJ("Failed to commit local dispatch transaction", r0);
        zzag();
        zzaf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x017c, code lost:
    
        return false;
     */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final boolean zzae() {
        /*
            Method dump skipped, instruction units count: 381
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzcj.zzae():boolean");
    }

    public final long zzb(zzbw zzbwVar, boolean z) {
        Preconditions.checkNotNull(zzbwVar);
        zzV();
        com.google.android.gms.analytics.zzr.zzh();
        long j = -1;
        try {
            try {
                this.zzb.zzm();
                zzcd zzcdVar = this.zzb;
                String strZzb = zzbwVar.zzb();
                Preconditions.checkNotEmpty(strZzb);
                zzcdVar.zzV();
                com.google.android.gms.analytics.zzr.zzh();
                int iDelete = zzcdVar.zzf().delete("properties", "app_uid=? AND cid<>?", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, strZzb});
                if (iDelete > 0) {
                    zzcdVar.zzO("Deleted property records", Integer.valueOf(iDelete));
                }
                long jZze = this.zzb.zze(0L, zzbwVar.zzb(), zzbwVar.zzc());
                zzbwVar.zze(1 + jZze);
                zzcd zzcdVar2 = this.zzb;
                Preconditions.checkNotNull(zzbwVar);
                zzcdVar2.zzV();
                com.google.android.gms.analytics.zzr.zzh();
                SQLiteDatabase sQLiteDatabaseZzf = zzcdVar2.zzf();
                Map mapZzd = zzbwVar.zzd();
                Preconditions.checkNotNull(mapZzd);
                Uri.Builder builder = new Uri.Builder();
                for (Map.Entry entry : mapZzd.entrySet()) {
                    builder.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
                }
                String encodedQuery = builder.build().getEncodedQuery();
                if (encodedQuery == null) {
                    encodedQuery = "";
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_uid", (Long) 0L);
                contentValues.put("cid", zzbwVar.zzb());
                contentValues.put(ScarConstants.TOKEN_ID_KEY, zzbwVar.zzc());
                contentValues.put("adid", Integer.valueOf(zzbwVar.zzf() ? 1 : 0));
                contentValues.put("hits_count", Long.valueOf(zzbwVar.zza()));
                contentValues.put(NativeProtocol.WEB_DIALOG_PARAMS, encodedQuery);
                try {
                    if (sQLiteDatabaseZzf.insertWithOnConflict("properties", null, contentValues, 5) == -1) {
                        zzcdVar2.zzI("Failed to insert/update a property (got -1)");
                    }
                } catch (SQLiteException e) {
                    zzcdVar2.zzJ("Error storing a property", e);
                }
                this.zzb.zzaa();
                j = jZze;
            } catch (SQLiteException e2) {
                zzJ("Failed to update Analytics property", e2);
            }
            return j;
        } finally {
            try {
                this.zzb.zzZ();
            } catch (SQLiteException e3) {
                zzJ("Failed to end transaction", e3);
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbr
    protected final void zzd() {
        this.zzb.zzW();
        this.zzc.zzW();
        this.zze.zzW();
    }

    public final void zzf(zzcy zzcyVar) {
        zzg(zzcyVar, this.zzj);
    }

    public final void zzg(zzcy zzcyVar, long j) {
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        long jZzb = zzA().zzb();
        zzF("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(jZzb != 0 ? Math.abs(zzC().currentTimeMillis() - jZzb) : -1L));
        zzw();
        zzi();
        try {
            zzae();
            zzA().zzi();
            zzad();
            if (zzcyVar != null) {
                zzcyVar.zza(null);
            }
            if (this.zzj != j) {
                this.zzd.zzb();
            }
        } catch (Exception e) {
            zzJ("Local dispatch failed", e);
            zzA().zzi();
            zzad();
            if (zzcyVar != null) {
                zzcyVar.zza(e);
            }
        }
    }

    public final void zzh() {
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        zzw();
        zzN("Delete all hits from local store");
        try {
            zzcd zzcdVar = this.zzb;
            com.google.android.gms.analytics.zzr.zzh();
            zzcdVar.zzV();
            zzcdVar.zzf().delete("hits2", null, null);
            zzcd zzcdVar2 = this.zzb;
            com.google.android.gms.analytics.zzr.zzh();
            zzcdVar2.zzV();
            zzcdVar2.zzf().delete("properties", null, null);
            zzad();
        } catch (SQLiteException e) {
            zzR("Failed to delete hits from store", e);
        }
        zzi();
        if (this.zze.zze()) {
            zzN("Device service unavailable. Can't clear hits stored on the device service.");
        }
    }

    protected final void zzi() {
        if (this.zzk) {
            return;
        }
        zzw();
        if (!zzcs.zzl() || this.zze.zzg()) {
            return;
        }
        zzw();
        if (this.zzi.zzc(((Long) zzeh.zzC.zzb()).longValue())) {
            this.zzi.zzb();
            zzN("Connecting to service");
            if (this.zze.zzf()) {
                zzN("Connected to service");
                this.zzi.zza();
                zzm();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ba A[Catch: SQLiteException -> 0x01f4, TryCatch #4 {SQLiteException -> 0x01f4, blocks: (B:16:0x0079, B:17:0x0098, B:19:0x009e, B:21:0x00b2, B:23:0x00ba, B:25:0x00c2, B:26:0x00cc, B:29:0x00d8, B:31:0x00e1, B:74:0x01f0, B:32:0x00ec, B:34:0x0107, B:36:0x0118, B:56:0x0173, B:37:0x011d, B:44:0x0160, B:60:0x0188, B:61:0x018b, B:62:0x018c, B:64:0x01ba, B:66:0x01c9, B:73:0x01eb, B:65:0x01c2, B:67:0x01ce, B:69:0x01da, B:70:0x01e0), top: B:85:0x0079, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c2 A[Catch: SQLiteException -> 0x01f4, TryCatch #4 {SQLiteException -> 0x01f4, blocks: (B:16:0x0079, B:17:0x0098, B:19:0x009e, B:21:0x00b2, B:23:0x00ba, B:25:0x00c2, B:26:0x00cc, B:29:0x00d8, B:31:0x00e1, B:74:0x01f0, B:32:0x00ec, B:34:0x0107, B:36:0x0118, B:56:0x0173, B:37:0x011d, B:44:0x0160, B:60:0x0188, B:61:0x018b, B:62:0x018c, B:64:0x01ba, B:66:0x01c9, B:73:0x01eb, B:65:0x01c2, B:67:0x01ce, B:69:0x01da, B:70:0x01e0), top: B:85:0x0079, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01da A[Catch: SQLiteException -> 0x01ea, TryCatch #1 {SQLiteException -> 0x01ea, blocks: (B:67:0x01ce, B:69:0x01da, B:70:0x01e0), top: B:80:0x01ce, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01e0 A[Catch: SQLiteException -> 0x01ea, TRY_LEAVE, TryCatch #1 {SQLiteException -> 0x01ea, blocks: (B:67:0x01ce, B:69:0x01da, B:70:0x01e0), top: B:80:0x01ce, outer: #4 }] */
    /* JADX WARN: Type inference failed for: r6v8, types: [long] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzj(com.google.android.gms.internal.gtm.zzek r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 516
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzcj.zzj(com.google.android.gms.internal.gtm.zzek):void");
    }

    protected final void zzk(zzbw zzbwVar) {
        com.google.android.gms.analytics.zzr.zzh();
        zzF("Sending first hit to property", zzbwVar.zzc());
        zzfb zzfbVarZzf = zzA().zzf();
        zzw();
        if (zzfbVarZzf.zzc(zzcs.zzc())) {
            return;
        }
        String strZzg = zzA().zzg();
        if (TextUtils.isEmpty(strZzg)) {
            return;
        }
        zzav zzavVarZzb = zzff.zzb(zzz(), strZzg);
        zzF("Found relevant installation campaign", zzavVarZzb);
        zzai(zzbwVar, zzavVarZzb);
    }

    final void zzl() {
        com.google.android.gms.analytics.zzr.zzh();
        this.zzj = zzC().currentTimeMillis();
    }

    protected final void zzm() {
        com.google.android.gms.analytics.zzr.zzh();
        zzw();
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        zzw();
        zzw();
        if (!zzcs.zzl()) {
            zzQ("Service client disabled. Can't dispatch local hits to device AnalyticsService");
        }
        if (!this.zze.zzg()) {
            zzN("Service not connected");
            return;
        }
        if (this.zzb.zzab()) {
            return;
        }
        zzN("Dispatching local hits to device AnalyticsService");
        while (true) {
            try {
                zzcd zzcdVar = this.zzb;
                zzw();
                List listZzj = zzcdVar.zzj(zzcs.zzh());
                if (listZzj.isEmpty()) {
                    zzad();
                    return;
                }
                while (!listZzj.isEmpty()) {
                    zzek zzekVar = (zzek) listZzj.get(0);
                    if (!this.zze.zzh(zzekVar)) {
                        zzad();
                        return;
                    }
                    listZzj.remove(zzekVar);
                    try {
                        this.zzb.zzn(zzekVar.zzb());
                    } catch (SQLiteException e) {
                        zzJ("Failed to remove hit that was send for delivery", e);
                        zzag();
                        zzaf();
                        return;
                    }
                }
            } catch (SQLiteException e2) {
                zzJ("Failed to read hits from store", e2);
                zzag();
                zzaf();
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzn(java.lang.String r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzcj.zzn(java.lang.String):void");
    }
}
