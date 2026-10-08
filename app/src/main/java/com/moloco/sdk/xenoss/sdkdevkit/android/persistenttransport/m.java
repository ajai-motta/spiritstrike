package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import com.google.common.util.concurrent.ListenableFuture;
import com.moloco.sdk.internal.MolocoLogger;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class m implements l {
    public static final int b = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WorkManager f3051a;

    public m(Context context) {
        WorkManager workManagerB;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            workManagerB = a(context);
        } catch (IllegalStateException e) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "MolocoWorkManager", "WorkManager not initialized already, performing initialization", e, false, 8, null);
            workManagerB = b(context);
        }
        this.f3051a = workManagerB;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.l
    public Operation a(WorkRequest workRequest) {
        Intrinsics.checkNotNullParameter(workRequest, "workRequest");
        Operation operationEnqueue = this.f3051a.enqueue(workRequest);
        Intrinsics.checkNotNullExpressionValue(operationEnqueue, "enqueue(...)");
        return operationEnqueue;
    }

    public final WorkManager b(Context context) {
        Configuration configurationBuild = new Configuration.Builder().build();
        Intrinsics.checkNotNullExpressionValue(configurationBuild, "build(...)");
        try {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "MolocoWorkManager", "Trying to initialize work manager as one is not already available", null, false, 12, null);
        } catch (IllegalStateException e) {
            e = e;
        }
        try {
            WorkManager.initialize(context, configurationBuild);
        } catch (IllegalStateException e2) {
            e = e2;
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "MolocoWorkManager", "WorkManager initialized already at this point, retrieving instance", e, false, 8, null);
        }
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "MolocoWorkManager", "Trying to retrieve work manager instance", null, false, 12, null);
        try {
            return a(context);
        } catch (IllegalStateException e3) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "MolocoWorkManager", "WorkManager instance couldn't be re-initialized, cannot provide WorkManager", null, false, 12, null);
            throw new IllegalStateException("Cannot provide MolocoWorkManager. Failed to re-initialize WorkManager", e3);
        }
    }

    public final ListenableFuture<WorkInfo> a(UUID id) {
        Intrinsics.checkNotNullParameter(id, "id");
        ListenableFuture<WorkInfo> workInfoById = this.f3051a.getWorkInfoById(id);
        Intrinsics.checkNotNullExpressionValue(workInfoById, "getWorkInfoById(...)");
        return workInfoById;
    }

    public final WorkManager a(Context context) {
        WorkManager workManager = WorkManager.getInstance(context);
        Intrinsics.checkNotNullExpressionValue(workManager, "getInstance(...)");
        return workManager;
    }
}
