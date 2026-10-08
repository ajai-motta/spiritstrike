package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.publisher.AdShowListener;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes6.dex */
public final class t<T extends AdShowListener> {
    public static final int f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> f2250a;
    public com.moloco.sdk.internal.ortb.model.x b;
    public j c;
    public Job d;
    public y e;

    public t() {
        this(null, null, null, null, null, 31, null);
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> a() {
        return this.f2250a;
    }

    public final Job b() {
        return this.d;
    }

    public final j c() {
        return this.c;
    }

    public final y d() {
        return this.e;
    }

    public final com.moloco.sdk.internal.ortb.model.x e() {
        return this.b;
    }

    public t(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> lVar, com.moloco.sdk.internal.ortb.model.x xVar, j jVar, Job job, y yVar) {
        this.f2250a = lVar;
        this.b = xVar;
        this.c = jVar;
        this.d = job;
        this.e = yVar;
    }

    public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> lVar) {
        this.f2250a = lVar;
    }

    public final void a(com.moloco.sdk.internal.ortb.model.x xVar) {
        this.b = xVar;
    }

    public final void a(j jVar) {
        this.c = jVar;
    }

    public final void a(Job job) {
        this.d = job;
    }

    public final void a(y yVar) {
        this.e = yVar;
    }

    public /* synthetic */ t(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l lVar, com.moloco.sdk.internal.ortb.model.x xVar, j jVar, Job job, y yVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : lVar, (i & 2) != 0 ? null : xVar, (i & 4) != 0 ? null : jVar, (i & 8) != 0 ? null : job, (i & 16) != 0 ? null : yVar);
    }
}
