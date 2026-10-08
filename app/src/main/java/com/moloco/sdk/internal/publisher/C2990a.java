package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.AdFormatType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C2990a implements r {
    public static final C0391a d = new C0391a(null);
    public static final int e = 8;
    public static final String f = "AdCreateLoadTimeoutManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdFormatType f2160a;
    public final long b;
    public long c;

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.a$a, reason: collision with other inner class name */
    public static final class C0391a {
        public /* synthetic */ C0391a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public C0391a() {
        }
    }

    public /* synthetic */ C2990a(AdFormatType adFormatType, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(adFormatType, j);
    }

    public final long a(long j) {
        long createAdObjectStartTime = j - getCreateAdObjectStartTime();
        long duration = DurationKt.toDuration(Duration.m8790getInWholeMillisecondsimpl(this.b) - createAdObjectStartTime, DurationUnit.MILLISECONDS);
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, f, this.f2160a + " timeout: " + ((Object) Duration.m8819toStringimpl(this.b)) + " , create ad duration: " + createAdObjectStartTime + " ms (createTime: " + getCreateAdObjectStartTime() + " ms, loadStartTime: " + j + " ms). Return value: " + ((Object) Duration.m8819toStringimpl(duration)), false, 4, null);
        return duration;
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public long getCreateAdObjectStartTime() {
        return this.c;
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public void setCreateAdObjectStartTime(long j) {
        this.c = j;
    }

    public C2990a(AdFormatType adFormatType, long j) {
        Intrinsics.checkNotNullParameter(adFormatType, "adFormatType");
        this.f2160a = adFormatType;
        this.b = j;
    }
}
