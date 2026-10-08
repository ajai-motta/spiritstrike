package com.google.android.recaptcha.internal;

import android.app.Application;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.recaptchabase.RecaptchaBaseClient;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzu extends zzg {
    private final zzcz zza;
    private String zzb;
    private Deferred zzc;
    private final Lazy zzd;

    public zzu() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public zzu(zzcz zzczVar, RecaptchaBaseClient recaptchaBaseClient) {
        this.zza = zzczVar;
        int i = zzby.zza;
        this.zzd = LazyKt.lazy(zzt.zza);
    }

    public static final /* synthetic */ Application zzl(zzu zzuVar) {
        return (Application) zzuVar.zzd.getValue();
    }

    @Override // com.google.android.recaptcha.internal.zzg
    protected final Object zza(String str, Continuation continuation) {
        zzxw zzxwVarZzf = zzxx.zzf();
        zzxwVarZzf.zze(str);
        return zzxwVarZzf.zzk();
    }

    @Override // com.google.android.recaptcha.internal.zzg
    protected final Object zzb(String str, Continuation continuation) {
        return new zzhg(new zzr(this, str, null));
    }

    @Override // com.google.android.recaptcha.internal.zzg
    protected final Object zzd(zzxn zzxnVar, Continuation continuation) {
        return new zzhg(new zzs(this, zzxnVar, null));
    }

    @Override // com.google.android.recaptcha.internal.zzg
    protected final int zzj() {
        return 40;
    }

    @Override // com.google.android.recaptcha.internal.zzg
    protected final int zzk() {
        return 39;
    }

    public /* synthetic */ zzu(zzcz zzczVar, RecaptchaBaseClient recaptchaBaseClient, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(new zzcz(GoogleApiAvailabilityLight.getInstance()), null);
    }
}
