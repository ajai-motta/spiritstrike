package com.hive.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.net.HttpHeaders;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003BCDB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010,\u001a\u00020#J\u0010\u0010-\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\"J\u0006\u0010.\u001a\u00020*J\u0010\u0010/\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u00010\u001fJ\u001a\u0010/\u001a\u00020*2\b\u00101\u001a\u0004\u0018\u00010\u001f2\b\u00100\u001a\u0004\u0018\u00010\u001fJ\u0010\u00102\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u00010\u001fJ\u001a\u00102\u001a\u00020*2\b\u00101\u001a\u0004\u0018\u00010\u001f2\b\u00100\u001a\u0004\u0018\u00010\u001fJ\u0010\u00103\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u00010\u001fJ\u001a\u00103\u001a\u00020*2\b\u00101\u001a\u0004\u0018\u00010\u001f2\b\u00100\u001a\u0004\u0018\u00010\u001fJ\u0010\u00104\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u00010\u001fJ\u001a\u00104\u001a\u00020*2\b\u00101\u001a\u0004\u0018\u00010\u001f2\b\u00100\u001a\u0004\u0018\u00010\u001fJ\u0010\u00105\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u00010\u001fJ\u001a\u00105\u001a\u00020*2\b\u00101\u001a\u0004\u0018\u00010\u001f2\b\u00100\u001a\u0004\u0018\u00010\u001fJ(\u00106\u001a\u00020*2\b\b\u0002\u00107\u001a\u0002082\b\u00101\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u001fH\u0002J\u001f\u00109\u001a\u00020*2\u0006\u00100\u001a\u00020\u001f2\b\b\u0002\u00107\u001a\u000208H\u0000¢\u0006\u0002\b:J\u0018\u0010;\u001a\u00020*2\u0006\u00100\u001a\u00020\u001f2\b\b\u0002\u00107\u001a\u000208J \u0010<\u001a\u00020*2\u0006\u00107\u001a\u0002082\u0006\u0010=\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u001fH\u0002J \u0010>\u001a\u00020*2\u0006\u00107\u001a\u0002082\u0006\u0010=\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u001fH\u0002J \u0010?\u001a\u00020*2\u0006\u00107\u001a\u0002082\u0006\u00101\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u001fH\u0002J\b\u0010@\u001a\u00020\u0005H\u0003J\b\u0010A\u001a\u00020\u0005H\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\u0010R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\t\u001a\u0004\b&\u0010'¨\u0006E"}, d2 = {"Lcom/hive/core/Logger;", "", "<init>", "()V", "debugEnable", "", "getDebugEnable", "()Z", "debugEnable$delegate", "Lkotlin/Lazy;", "debugNetworkLog", "getDebugNetworkLog", "debugNetworkLog$delegate", "logEnable", "getLogEnable", "setLogEnable", "(Z)V", "coreLogEnable", "getCoreLogEnable", "setCoreLogEnable", "remoteLogEnable", "getRemoteLogEnable", "setRemoteLogEnable", "value", "Lcom/hive/core/Logger$LogFilter;", "logFilter", "getLogFilter", "()Lcom/hive/core/Logger$LogFilter;", "setLogFilter", "(Lcom/hive/core/Logger$LogFilter;)V", "TAG", "", "listenerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/hive/core/Logger$OnLoggerListener;", "Landroid/os/Handler;", "logThread", "Landroid/os/HandlerThread;", "getLogThread", "()Landroid/os/HandlerThread;", "logThread$delegate", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "handler", "removeListener", "removeAllListener", "v", "message", ViewHierarchyConstants.TAG_KEY, "d", "i", "w", "e", "log", "type", "Lcom/hive/core/Logger$LogType;", "coreLog", "coreLog$hive_core_release", "protocolLog", "printLog", "logTag", "outputLog", "sendLogEvent", "isDebugApp", "isDebugNetworkLog", "OnLoggerListener", "LogType", "LogFilter", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Logger {
    private static final String TAG = "Hive";
    private static boolean coreLogEnable;
    private static boolean logEnable;
    private static boolean remoteLogEnable;
    public static final Logger INSTANCE = new Logger();

    /* JADX INFO: renamed from: debugEnable$delegate, reason: from kotlin metadata */
    private static final Lazy debugEnable = LazyKt.lazy(new Function0() { // from class: com.hive.core.Logger$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Boolean.valueOf(Logger.debugEnable_delegate$lambda$0());
        }
    });

    /* JADX INFO: renamed from: debugNetworkLog$delegate, reason: from kotlin metadata */
    private static final Lazy debugNetworkLog = LazyKt.lazy(new Function0() { // from class: com.hive.core.Logger$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Boolean.valueOf(Logger.debugNetworkLog_delegate$lambda$1());
        }
    });
    private static LogFilter logFilter = new LogFilter();
    private static final ConcurrentHashMap<OnLoggerListener, Handler> listenerMap = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: logThread$delegate, reason: from kotlin metadata */
    private static final Lazy logThread = LazyKt.lazy(new Function0() { // from class: com.hive.core.Logger$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Logger.logThread_delegate$lambda$3();
        }
    });

    /* JADX INFO: compiled from: Logger.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/hive/core/Logger$OnLoggerListener;", "", "onLogEvent", "", "type", "Lcom/hive/core/Logger$LogType;", ViewHierarchyConstants.TAG_KEY, "", "message", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OnLoggerListener {
        void onLogEvent(LogType type, String tag, String message);
    }

    /* JADX INFO: compiled from: Logger.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogType.values().length];
            try {
                iArr[LogType.Verbose.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogType.Debug.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LogType.Info.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LogType.Warning.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LogType.Error.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private Logger() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: Logger.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/hive/core/Logger$LogType;", "", "<init>", "(Ljava/lang/String;I)V", "Verbose", "Debug", "Info", HttpHeaders.WARNING, k.c, "None", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LogType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LogType[] $VALUES;
        public static final LogType Verbose = new LogType("Verbose", 0);
        public static final LogType Debug = new LogType("Debug", 1);
        public static final LogType Info = new LogType("Info", 2);
        public static final LogType Warning = new LogType(HttpHeaders.WARNING, 3);
        public static final LogType Error = new LogType(k.c, 4);
        public static final LogType None = new LogType("None", 5);

        private static final /* synthetic */ LogType[] $values() {
            return new LogType[]{Verbose, Debug, Info, Warning, Error, None};
        }

        public static EnumEntries<LogType> getEntries() {
            return $ENTRIES;
        }

        private LogType(String str, int i) {
        }

        static {
            LogType[] logTypeArr$values = $values();
            $VALUES = logTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(logTypeArr$values);
        }

        public static LogType valueOf(String str) {
            return (LogType) Enum.valueOf(LogType.class, str);
        }

        public static LogType[] values() {
            return (LogType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: Logger.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/hive/core/Logger$LogFilter;", "", "<init>", "()V", "coreLog", "Lcom/hive/core/Logger$LogType;", "getCoreLog", "()Lcom/hive/core/Logger$LogType;", "setCoreLog", "(Lcom/hive/core/Logger$LogType;)V", "serviceLog", "getServiceLog", "setServiceLog", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LogFilter {
        private LogType coreLog = LogType.Verbose;
        private LogType serviceLog = LogType.Verbose;

        public final LogType getCoreLog() {
            return this.coreLog;
        }

        public final void setCoreLog(LogType logType) {
            Intrinsics.checkNotNullParameter(logType, "<set-?>");
            this.coreLog = logType;
        }

        public final LogType getServiceLog() {
            return this.serviceLog;
        }

        public final void setServiceLog(LogType logType) {
            Intrinsics.checkNotNullParameter(logType, "<set-?>");
            this.serviceLog = logType;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean debugEnable_delegate$lambda$0() {
        return INSTANCE.isDebugApp();
    }

    public final boolean getDebugEnable() {
        return ((Boolean) debugEnable.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean debugNetworkLog_delegate$lambda$1() {
        return INSTANCE.isDebugNetworkLog();
    }

    public final boolean getDebugNetworkLog() {
        return ((Boolean) debugNetworkLog.getValue()).booleanValue();
    }

    public final boolean getLogEnable() {
        return logEnable;
    }

    public final void setLogEnable(boolean z) {
        logEnable = z;
    }

    public final boolean getCoreLogEnable() {
        return coreLogEnable;
    }

    public final void setCoreLogEnable(boolean z) {
        coreLogEnable = z;
    }

    public final boolean getRemoteLogEnable() {
        return remoteLogEnable;
    }

    public final void setRemoteLogEnable(boolean z) {
        remoteLogEnable = z;
    }

    public final LogFilter getLogFilter() {
        return logFilter;
    }

    public final void setLogFilter(LogFilter value) {
        Intrinsics.checkNotNullParameter(value, "value");
        printLog(LogType.Debug, "HiveCore", "[HiveCore] logFilter core: " + value.getCoreLog() + ", service: " + value.getServiceLog());
        logFilter = value;
    }

    private final HandlerThread getLogThread() {
        return (HandlerThread) logThread.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HandlerThread logThread_delegate$lambda$3() {
        HandlerThread handlerThread = new HandlerThread("logWorkerThread");
        handlerThread.setDaemon(true);
        handlerThread.start();
        return handlerThread;
    }

    public static /* synthetic */ void addListener$default(Logger logger, OnLoggerListener onLoggerListener, Handler handler, int i, Object obj) {
        if ((i & 2) != 0) {
            handler = new Handler(Looper.getMainLooper());
        }
        logger.addListener(onLoggerListener, handler);
    }

    public final void addListener(OnLoggerListener listener, Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (listener != null) {
            listenerMap.put(listener, handler);
        }
    }

    public final void removeListener(OnLoggerListener listener) {
        if (listener != null) {
            listenerMap.remove(listener);
        }
    }

    public final void removeAllListener() {
        listenerMap.clear();
    }

    public final void v(String message) {
        v(null, message);
    }

    public final void v(String tag, String message) {
        log(LogType.Verbose, tag, message);
    }

    public final void d(String message) {
        d(null, message);
    }

    public final void d(String tag, String message) {
        log(LogType.Debug, tag, message);
    }

    public final void i(String message) {
        i(null, message);
    }

    public final void i(String tag, String message) {
        log(LogType.Info, tag, message);
    }

    public final void w(String message) {
        w(null, message);
    }

    public final void w(String tag, String message) {
        log(LogType.Warning, tag, message);
    }

    public final void e(String message) {
        e(null, message);
    }

    public final void e(String tag, String message) {
        log(LogType.Error, tag, message);
    }

    static /* synthetic */ void log$default(Logger logger, LogType logType, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            logType = LogType.Debug;
        }
        if ((i & 4) != 0) {
            str2 = "(null)";
        }
        logger.log(logType, str, str2);
    }

    private final void log(LogType type, String tag, String message) {
        String str;
        String str2 = tag;
        if (str2 == null || StringsKt.isBlank(str2)) {
            str = "Hive";
        } else {
            str = "Hive/" + tag;
        }
        if (message == null) {
            message = "(null)";
        }
        boolean z = (logEnable || coreLogEnable) && type.ordinal() >= logFilter.getServiceLog().ordinal();
        if (getDebugEnable() || remoteLogEnable || z) {
            printLog(type, str, message);
        }
        sendLogEvent(type, str, message);
    }

    public static /* synthetic */ void coreLog$hive_core_release$default(Logger logger, String str, LogType logType, int i, Object obj) {
        if ((i & 2) != 0) {
            logType = LogType.Debug;
        }
        logger.coreLog$hive_core_release(str, logType);
    }

    public final void coreLog$hive_core_release(String message, LogType type) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(type, "type");
        String str = "[HiveCore] " + message;
        boolean z = coreLogEnable && type.ordinal() >= logFilter.getCoreLog().ordinal();
        if (getDebugEnable() || remoteLogEnable || z) {
            printLog(type, "HiveCore", str);
        }
        sendLogEvent(LogType.Verbose, "HiveCore", str);
    }

    public static /* synthetic */ void protocolLog$default(Logger logger, String str, LogType logType, int i, Object obj) {
        if ((i & 2) != 0) {
            logType = LogType.Debug;
        }
        logger.protocolLog(str, logType);
    }

    public final void protocolLog(String message, LogType type) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(type, "type");
        String str = "[HiveProtocol] " + message;
        boolean z = coreLogEnable && type.ordinal() >= logFilter.getCoreLog().ordinal();
        if (getDebugEnable() || remoteLogEnable || z) {
            printLog(type, "HiveProtocol", str);
        }
        sendLogEvent(LogType.Verbose, "HiveProtocol", str);
    }

    private final void printLog(LogType type, String logTag, String message) {
        if (message.length() > 3072) {
            int length = message.length();
            int i = 0;
            while (true) {
                int i2 = i + 3072;
                outputLog(type, logTag, StringsKt.slice(message, RangesKt.until(i, i2 < length ? i2 : length)));
                if (i2 >= length) {
                    return;
                } else {
                    i = i2;
                }
            }
        } else {
            outputLog(type, logTag, message);
        }
    }

    private final void outputLog(LogType type, String logTag, String message) {
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            Log.v(logTag, message);
            return;
        }
        if (i == 2) {
            Log.d(logTag, message);
            return;
        }
        if (i == 3) {
            Log.i(logTag, message);
        } else if (i == 4) {
            Log.w(logTag, message);
        } else {
            if (i != 5) {
                return;
            }
            Log.e(logTag, message);
        }
    }

    private final void sendLogEvent(final LogType type, final String tag, final String message) {
        if (listenerMap.isEmpty()) {
            return;
        }
        new Handler(getLogThread().getLooper()).post(new Runnable() { // from class: com.hive.core.Logger$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                Logger.sendLogEvent$lambda$11(type, tag, message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendLogEvent$lambda$11(final LogType logType, final String str, final String str2) {
        try {
            Result.Companion companion = kotlin.Result.INSTANCE;
            for (final Map.Entry<OnLoggerListener, Handler> entry : listenerMap.entrySet()) {
                try {
                    Result.Companion companion2 = kotlin.Result.INSTANCE;
                    kotlin.Result.m7415constructorimpl(Boolean.valueOf(entry.getValue().post(new Runnable() { // from class: com.hive.core.Logger$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            Logger.sendLogEvent$lambda$11$lambda$10$lambda$9$lambda$8$lambda$7(entry, logType, str, str2);
                        }
                    })));
                } catch (Throwable th) {
                    Result.Companion companion3 = kotlin.Result.INSTANCE;
                    kotlin.Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
            }
            kotlin.Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion4 = kotlin.Result.INSTANCE;
            kotlin.Result.m7415constructorimpl(ResultKt.createFailure(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendLogEvent$lambda$11$lambda$10$lambda$9$lambda$8$lambda$7(Map.Entry entry, LogType logType, String str, String str2) {
        ((OnLoggerListener) entry.getKey()).onLogEvent(logType, str, str2);
    }

    private final boolean isDebugApp() {
        Object objM7415constructorimpl;
        try {
            Result.Companion companion = kotlin.Result.INSTANCE;
            Class<?> cls = Class.forName("android.os.SystemProperties");
            boolean z = true;
            Object objInvoke = cls.getMethod("get", String.class, String.class).invoke(cls, "debug.hive.app", "");
            if (Intrinsics.areEqual(Product.INSTANCE.getAppIdentifier(), objInvoke)) {
                Log.d("Hive", "debug.hive.app: (" + ((String) objInvoke) + ") enabled.");
            } else {
                z = false;
            }
            objM7415constructorimpl = kotlin.Result.m7415constructorimpl(Boolean.valueOf(z));
        } catch (Throwable th) {
            Result.Companion companion2 = kotlin.Result.INSTANCE;
            objM7415constructorimpl = kotlin.Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = kotlin.Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Log.d("Hive", "debug.hive.app: failed : " + thM7418exceptionOrNullimpl);
        }
        if (kotlin.Result.m7421isFailureimpl(objM7415constructorimpl)) {
            objM7415constructorimpl = false;
        }
        return ((Boolean) objM7415constructorimpl).booleanValue();
    }

    private final boolean isDebugNetworkLog() {
        Object objM7415constructorimpl;
        try {
            Result.Companion companion = kotlin.Result.INSTANCE;
            Class<?> cls = Class.forName("android.os.SystemProperties");
            boolean z = true;
            Object objInvoke = cls.getMethod("get", String.class, String.class).invoke(cls, "debug.hive.networklog", "");
            if (StringsKt.equals("true", objInvoke != null ? objInvoke.toString() : null, true)) {
                Log.d("Hive", "debug.hive.networklog enabled.");
            } else {
                z = false;
            }
            objM7415constructorimpl = kotlin.Result.m7415constructorimpl(Boolean.valueOf(z));
        } catch (Throwable th) {
            Result.Companion companion2 = kotlin.Result.INSTANCE;
            objM7415constructorimpl = kotlin.Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = kotlin.Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Log.d("Hive", "debug.hive.networklog: failed : " + thM7418exceptionOrNullimpl);
        }
        if (kotlin.Result.m7421isFailureimpl(objM7415constructorimpl)) {
            objM7415constructorimpl = false;
        }
        return ((Boolean) objM7415constructorimpl).booleanValue();
    }
}
