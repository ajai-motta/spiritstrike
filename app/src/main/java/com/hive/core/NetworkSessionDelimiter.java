package com.hive.core;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkSessionDelimiter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/hive/core/NetworkSessionDelimiter;", "", "<init>", "()V", "sessionGuid", "", "sessionIndex", "Ljava/util/concurrent/atomic/AtomicInteger;", "currentSessionGuid", "incrementAndGetSessionIndex", "", "reset", "", "createGuid", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NetworkSessionDelimiter {
    public static final NetworkSessionDelimiter INSTANCE;
    private static String sessionGuid;
    private static final AtomicInteger sessionIndex;

    private NetworkSessionDelimiter() {
    }

    static {
        NetworkSessionDelimiter networkSessionDelimiter = new NetworkSessionDelimiter();
        INSTANCE = networkSessionDelimiter;
        sessionGuid = networkSessionDelimiter.createGuid();
        sessionIndex = new AtomicInteger(0);
    }

    public final String currentSessionGuid() {
        return sessionGuid;
    }

    public final int incrementAndGetSessionIndex() {
        return sessionIndex.incrementAndGet();
    }

    public final void reset() {
        sessionGuid = createGuid();
        sessionIndex.set(0);
    }

    private final String createGuid() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
