package io.ktor.websocket;

import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.websocket.CloseReason;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineName;
import org.slf4j.Logger;

/* JADX INFO: compiled from: DefaultWebSocketSession.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a)\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007\"\u001e\u0010\n\u001a\u00060\bj\u0002`\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\"\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012\"\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\".\u0010\u001d\u001a\u0004\u0018\u00010\u0017*\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00178Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\"*\u0010\"\u001a\u00020\u0017*\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00178Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, d2 = {"Lio/ktor/websocket/WebSocketSession;", "session", "", "pingIntervalMillis", "timeoutMillis", "Lio/ktor/websocket/DefaultWebSocketSession;", "DefaultWebSocketSession", "(Lio/ktor/websocket/WebSocketSession;JJ)Lio/ktor/websocket/DefaultWebSocketSession;", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "getLOGGER", "()Lorg/slf4j/Logger;", "PINGER_DISABLED", "J", "Lkotlinx/coroutines/CoroutineName;", "IncomingProcessorCoroutineName", "Lkotlinx/coroutines/CoroutineName;", "OutgoingProcessorCoroutineName", "Lio/ktor/websocket/CloseReason;", "NORMAL_CLOSE", "Lio/ktor/websocket/CloseReason;", "Lkotlin/time/Duration;", "newDuration", "getPingInterval", "(Lio/ktor/websocket/DefaultWebSocketSession;)Lkotlin/time/Duration;", "setPingInterval-6Au4x4Y", "(Lio/ktor/websocket/DefaultWebSocketSession;Lkotlin/time/Duration;)V", "pingInterval", "getTimeout", "(Lio/ktor/websocket/DefaultWebSocketSession;)J", "setTimeout-HG0u8IE", "(Lio/ktor/websocket/DefaultWebSocketSession;J)V", "timeout", "ktor-websockets"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DefaultWebSocketSessionKt {
    public static final long PINGER_DISABLED = 0;
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.websocket.WebSocket");
    private static final CoroutineName IncomingProcessorCoroutineName = new CoroutineName("ws-incoming-processor");
    private static final CoroutineName OutgoingProcessorCoroutineName = new CoroutineName("ws-outgoing-processor");
    private static final CloseReason NORMAL_CLOSE = new CloseReason(CloseReason.Codes.NORMAL, "OK");

    public static final Logger getLOGGER() {
        return LOGGER;
    }

    public static /* synthetic */ DefaultWebSocketSession DefaultWebSocketSession$default(WebSocketSession webSocketSession, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        if ((i & 4) != 0) {
            j2 = 15000;
        }
        return DefaultWebSocketSession(webSocketSession, j, j2);
    }

    public static final DefaultWebSocketSession DefaultWebSocketSession(WebSocketSession session, long j, long j2) {
        Intrinsics.checkNotNullParameter(session, "session");
        if (!(!(session instanceof DefaultWebSocketSession))) {
            throw new IllegalArgumentException("Cannot wrap other DefaultWebSocketSession".toString());
        }
        return new DefaultWebSocketSessionImpl(session, j, j2);
    }

    public static final Duration getPingInterval(DefaultWebSocketSession defaultWebSocketSession) {
        Intrinsics.checkNotNullParameter(defaultWebSocketSession, "<this>");
        Long lValueOf = Long.valueOf(defaultWebSocketSession.getPingIntervalMillis());
        if (lValueOf.longValue() <= 0) {
            lValueOf = null;
        }
        if (lValueOf == null) {
            return null;
        }
        Duration.Companion companion = Duration.INSTANCE;
        return Duration.m8777boximpl(DurationKt.toDuration(lValueOf.longValue(), DurationUnit.MILLISECONDS));
    }

    /* JADX INFO: renamed from: setPingInterval-6Au4x4Y, reason: not valid java name */
    public static final void m7405setPingInterval6Au4x4Y(DefaultWebSocketSession pingInterval, Duration duration) {
        Intrinsics.checkNotNullParameter(pingInterval, "$this$pingInterval");
        pingInterval.setPingIntervalMillis(duration != null ? Duration.m8790getInWholeMillisecondsimpl(duration.getRawValue()) : 0L);
    }

    public static final long getTimeout(DefaultWebSocketSession defaultWebSocketSession) {
        Intrinsics.checkNotNullParameter(defaultWebSocketSession, "<this>");
        Duration.Companion companion = Duration.INSTANCE;
        return DurationKt.toDuration(defaultWebSocketSession.getTimeoutMillis(), DurationUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: setTimeout-HG0u8IE, reason: not valid java name */
    public static final void m7406setTimeoutHG0u8IE(DefaultWebSocketSession timeout, long j) {
        Intrinsics.checkNotNullParameter(timeout, "$this$timeout");
        timeout.setTimeoutMillis(Duration.m8790getInWholeMillisecondsimpl(j));
    }
}
