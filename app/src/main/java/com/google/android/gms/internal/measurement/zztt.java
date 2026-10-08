package com.google.android.gms.internal.measurement;

import android.net.Uri;
import android.util.Pair;
import com.facebook.share.internal.ShareConstants;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zztt {
    private final ConcurrentMap zza = new ConcurrentHashMap();
    private final Executor zzb;
    private final zzru zzc;
    private final AsyncFunction zzd;
    private final Map zze;
    private final zzvc zzf;

    zztt(Executor executor, zzru zzruVar, zzvc zzvcVar, Map map, @Nullable zzvf zzvfVar) {
        this.zzb = (Executor) Preconditions.checkNotNull(executor);
        this.zzc = (zzru) Preconditions.checkNotNull(zzruVar);
        this.zzf = (zzvc) Preconditions.checkNotNull(zzvcVar);
        this.zze = (Map) Preconditions.checkNotNull(map);
        Preconditions.checkArgument(!r1.isEmpty());
        this.zzd = zzts.zza;
    }

    public final zztp zza(zztr zztrVar) {
        ConcurrentMap concurrentMap = this.zza;
        Uri uriZza = zztrVar.zza();
        Pair pairCreate = (Pair) concurrentMap.get(uriZza);
        if (pairCreate == null) {
            Uri uriZza2 = zztrVar.zza();
            Preconditions.checkArgument(uriZza2.isHierarchical(), "Uri must be hierarchical: %s", uriZza2);
            String strNullToEmpty = Strings.nullToEmpty(uriZza2.getLastPathSegment());
            int iLastIndexOf = strNullToEmpty.lastIndexOf(46);
            Preconditions.checkArgument((iLastIndexOf == -1 ? "" : strNullToEmpty.substring(iLastIndexOf + 1)).equals("pb"), "Uri extension must be .pb: %s", uriZza2);
            Preconditions.checkArgument(true, "Proto schema cannot be null");
            Preconditions.checkArgument(zztrVar.zzc() != null, "Handler cannot be null");
            zzuw zzuwVar = (zzuw) this.zze.get("singleproc");
            Preconditions.checkArgument(zzuwVar != null, "No XDataStoreVariantFactory registered for ID %s", "singleproc");
            String strNullToEmpty2 = Strings.nullToEmpty(zztrVar.zza().getLastPathSegment());
            int iLastIndexOf2 = strNullToEmpty2.lastIndexOf(46);
            if (iLastIndexOf2 != -1) {
                strNullToEmpty2 = strNullToEmpty2.substring(0, iLastIndexOf2);
            }
            ListenableFuture listenableFutureTransformAsync = Futures.transformAsync(Futures.immediateFuture(zztrVar.zza()), this.zzd, MoreExecutors.directExecutor());
            Executor executor = this.zzb;
            zzru zzruVar = this.zzc;
            zzti zztiVar = zzti.ALLOWED;
            zztp zztpVar = new zztp(zzuwVar.zzb(zztrVar, strNullToEmpty2, executor, zzruVar, zztiVar), this.zzf, listenableFutureTransformAsync, false, zzuwVar.zza(zztiVar));
            ImmutableList immutableListZzd = zztrVar.zzd();
            if (!immutableListZzd.isEmpty()) {
                zztpVar.zza(zzto.zza(immutableListZzd, executor));
            }
            pairCreate = Pair.create(zztpVar, zztrVar);
            Pair pair = (Pair) concurrentMap.putIfAbsent(uriZza, pairCreate);
            if (pair != null) {
                pairCreate = pair;
            }
        }
        zztp zztpVar2 = (zztp) pairCreate.first;
        zztr zztrVar2 = (zztr) pairCreate.second;
        if (zztrVar.equals(zztrVar2)) {
            return zztpVar2;
        }
        String strLenientFormat = Strings.lenientFormat("ProtoDataStoreConfig<%s> doesn't match previous call [uri=%s] [%s]", zztrVar.zzb().getClass().getSimpleName(), zztrVar.zza());
        Preconditions.checkArgument(zztrVar.zza().equals(zztrVar2.zza()), strLenientFormat, ShareConstants.MEDIA_URI);
        Preconditions.checkArgument(zztrVar.zzb().equals(zztrVar2.zzb()), strLenientFormat, "schema");
        Preconditions.checkArgument(zztrVar.zzc().equals(zztrVar2.zzc()), strLenientFormat, "handler");
        Preconditions.checkArgument(zztrVar.zzd().equals(zztrVar2.zzd()), strLenientFormat, "migrations");
        Preconditions.checkArgument(zztrVar.zze().equals(zztrVar2.zze()), strLenientFormat, "variantConfig");
        Preconditions.checkArgument(zztrVar.zzf() == zztrVar2.zzf(), strLenientFormat, "useGeneratedExtensionRegistry");
        zztrVar2.zzg();
        Preconditions.checkArgument(true, strLenientFormat, (Object) "enableTracing");
        throw new IllegalArgumentException(Strings.lenientFormat(strLenientFormat, "unknown"));
    }
}
