package com.google.android.recaptcha.internal;

import android.content.ContentValues;
import com.applovin.sdk.AppLovinErrorCodes;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgy extends SuspendLambda implements Function2 {
    final /* synthetic */ zzgz zza;
    final /* synthetic */ zzzm zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgy(zzgz zzgzVar, zzzm zzzmVar, Continuation continuation) {
        super(2, continuation);
        this.zza = zzgzVar;
        this.zzb = zzzmVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzgy(this.zza, this.zzb, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzgy) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        zzzm zzzmVar = this.zzb;
        zzgz zzgzVar = this.zza;
        synchronized (zzgs.class) {
            if (zzgzVar.zzc != null) {
                byte[] bArrZzd = zzzmVar.zzd();
                zzgp zzgpVar = new zzgp(zzpp.zzg().zzi(bArrZzd, 0, bArrZzd.length), System.currentTimeMillis(), 0);
                zzgo zzgoVar = zzgzVar.zzc;
                ContentValues contentValues = new ContentValues();
                contentValues.put("ss", zzgpVar.zzc());
                contentValues.put("ts", Long.valueOf(zzgpVar.zzb()));
                zzgoVar.getWritableDatabase().insert("ce", null, contentValues);
                int iZzb = zzgzVar.zzc.zzb() + AppLovinErrorCodes.INCENTIVIZED_SERVER_TIMEOUT;
                if (iZzb > 0) {
                    zzgzVar.zzc.zza(CollectionsKt.take(zzgzVar.zzc.zzd(), iZzb));
                }
                if (zzgzVar.zzc.zzb() >= 20) {
                    zzgzVar.zzf();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
