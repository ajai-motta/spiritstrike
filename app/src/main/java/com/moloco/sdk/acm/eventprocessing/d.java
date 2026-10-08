package com.moloco.sdk.acm.eventprocessing;

import android.content.Context;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import java.util.concurrent.TimeUnit;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.acm.a f1986a;
    public final Context b;

    public d(com.moloco.sdk.acm.a config, Context context) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f1986a = config;
        this.b = context;
    }

    @Override // com.moloco.sdk.acm.eventprocessing.c
    public void a() {
        Constraints constraintsBuild = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        Data dataA = e.a(MapsKt.mapOf(TuplesKt.to("url", this.f1986a.g()), TuplesKt.to(com.moloco.sdk.acm.b.e, this.f1986a.f().get(com.moloco.sdk.acm.b.e)), TuplesKt.to(com.moloco.sdk.acm.b.f, this.f1986a.f().get(com.moloco.sdk.acm.b.f)), TuplesKt.to(com.moloco.sdk.acm.b.g, this.f1986a.f().get(com.moloco.sdk.acm.b.g)), TuplesKt.to(com.moloco.sdk.acm.b.d, this.f1986a.f().get(com.moloco.sdk.acm.b.d)), TuplesKt.to(com.moloco.sdk.acm.b.c, this.f1986a.f().get(com.moloco.sdk.acm.b.c)), TuplesKt.to(com.moloco.sdk.acm.b.h, this.f1986a.f().get(com.moloco.sdk.acm.b.h)), TuplesKt.to(com.moloco.sdk.acm.b.b, this.f1986a.f().get(com.moloco.sdk.acm.b.b))));
        if (dataA == null) {
            return;
        }
        WorkManager.getInstance(this.b).enqueue(new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) DBRequestWorker.class).setConstraints(constraintsBuild).setInputData(dataA).setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 10000L, TimeUnit.MILLISECONDS).build());
    }
}
