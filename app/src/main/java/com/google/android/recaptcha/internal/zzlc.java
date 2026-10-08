package com.google.android.recaptcha.internal;

import android.content.Context;
import androidx.autofill.HintConstants;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzlc implements zzlb {
    private final Context zza;
    private final Map zzb = MapsKt.mapOf(TuplesKt.to(2, "activity"), TuplesKt.to(3, HintConstants.AUTOFILL_HINT_PHONE), TuplesKt.to(4, "input_method"), TuplesKt.to(5, "audio"));

    public zzlc(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.recaptcha.internal.zzlb
    public final /* synthetic */ Object cs(Object[] objArr) {
        return zzla.zza(this, objArr);
    }

    @Override // com.google.android.recaptcha.internal.zzlb
    public final Object zza(Object... objArr) throws zzdm {
        Object obj = objArr[0];
        if (true != (obj instanceof Integer)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        if (num == null) {
            throw new zzdm(4, 5, null);
        }
        Object obj2 = this.zzb.get(Integer.valueOf(num.intValue()));
        if (obj2 != null) {
            return this.zza.getSystemService((String) obj2);
        }
        throw new zzdm(4, 4, null);
    }
}
