package com.hive;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.common.net.HttpHeaders;
import com.hive.core.Logger;
import com.hive.logger.LoggerImpl;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u001e\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u001e\u0010\u0011\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u001e\u0010\u0012\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u001e\u0010\u0013\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u001e\u0010\u0014\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u001c\u0010\u0015\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J&\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0007R*\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/hive/Logger;", "", "<init>", "()V", "value", "Lcom/hive/Logger$LogFilter;", "logFilter", "getLogFilter$annotations", "getLogFilter", "()Lcom/hive/Logger$LogFilter;", "setLogFilter", "(Lcom/hive/Logger$LogFilter;)V", "v", "", "message", "", ViewHierarchyConstants.TAG_KEY, "d", "i", "w", "e", "apiCalledLog", "log", "type", "Lcom/hive/Logger$LogType;", "isActivateLogging", "", "LogType", "LogFilter", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Logger {
    public static final Logger INSTANCE = new Logger();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/hive/Logger$LogFilter;", "", "<init>", "()V", "coreLog", "Lcom/hive/Logger$LogType;", "getCoreLog", "()Lcom/hive/Logger$LogType;", "setCoreLog", "(Lcom/hive/Logger$LogType;)V", "serviceLog", "getServiceLog", "setServiceLog", "toCoreLogFilter", "Lcom/hive/core/Logger$LogFilter;", "toCoreLogFilter$hive_service_release", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LogFilter {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private LogType coreLog;
        private LogType serviceLog;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/hive/Logger$LogFilter$Companion;", "", "<init>", "()V", "fromCoreLogFilter", "Lcom/hive/Logger$LogFilter;", "coreLogFilter", "Lcom/hive/core/Logger$LogFilter;", "fromCoreLogFilter$hive_service_release", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final LogFilter fromCoreLogFilter$hive_service_release(Logger.LogFilter coreLogFilter) {
                Intrinsics.checkNotNullParameter(coreLogFilter, "coreLogFilter");
                LogFilter logFilter = new LogFilter();
                logFilter.setCoreLog(LogType.valueOf(coreLogFilter.getCoreLog().name()));
                logFilter.setServiceLog(LogType.valueOf(coreLogFilter.getServiceLog().name()));
                return logFilter;
            }

            private Companion() {
            }
        }

        public LogFilter() {
            LogType logType = LogType.Verbose;
            this.coreLog = logType;
            this.serviceLog = logType;
        }

        public final LogType getCoreLog() {
            return this.coreLog;
        }

        public final LogType getServiceLog() {
            return this.serviceLog;
        }

        public final void setCoreLog(LogType logType) {
            Intrinsics.checkNotNullParameter(logType, "<set-?>");
            this.coreLog = logType;
        }

        public final void setServiceLog(LogType logType) {
            Intrinsics.checkNotNullParameter(logType, "<set-?>");
            this.serviceLog = logType;
        }

        public final Logger.LogFilter toCoreLogFilter$hive_service_release() {
            Logger.LogFilter logFilter = new Logger.LogFilter();
            logFilter.setCoreLog(Logger.LogType.valueOf(this.coreLog.name()));
            logFilter.setServiceLog(Logger.LogType.valueOf(this.serviceLog.name()));
            return logFilter;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/hive/Logger$LogType;", "", "<init>", "(Ljava/lang/String;I)V", "Verbose", "Debug", "Info", HttpHeaders.WARNING, k.c, "None", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        static {
            LogType[] logTypeArr$values = $values();
            $VALUES = logTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(logTypeArr$values);
        }

        private LogType(String str, int i) {
        }

        public static EnumEntries<LogType> getEntries() {
            return $ENTRIES;
        }

        public static LogType valueOf(String str) {
            return (LogType) Enum.valueOf(LogType.class, str);
        }

        public static LogType[] values() {
            return (LogType[]) $VALUES.clone();
        }
    }

    private Logger() {
    }

    @JvmStatic
    public static final void apiCalledLog(String message) {
        apiCalledLog(null, message);
    }

    @JvmStatic
    public static final void d(String message) {
        d(null, message);
    }

    public static /* synthetic */ void d$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        d(str, str2);
    }

    @JvmStatic
    public static final void e(String message) {
        e(null, message);
    }

    public static /* synthetic */ void e$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        e(str, str2);
    }

    public static final LogFilter getLogFilter() {
        return LoggerImpl.INSTANCE.getLogFilter();
    }

    @JvmStatic
    public static /* synthetic */ void getLogFilter$annotations() {
    }

    @JvmStatic
    public static final void i(String message) {
        i(null, message);
    }

    public static /* synthetic */ void i$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        i(str, str2);
    }

    @JvmStatic
    public static final boolean isActivateLogging() {
        return com.hive.core.Logger.INSTANCE.getLogEnable();
    }

    private final void log(LogType type, String tag, String message) {
        LoggerImpl.INSTANCE.logBase(type, tag, message, LoggerImpl.HiveLogOutputTargetType.Both, false);
    }

    public static /* synthetic */ void log$default(Logger logger, LogType logType, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            logType = LogType.Verbose;
        }
        logger.log(logType, str, str2);
    }

    public static final void setLogFilter(LogFilter value) {
        Intrinsics.checkNotNullParameter(value, "value");
        LoggerImpl.INSTANCE.setLogFilter(value);
    }

    @JvmStatic
    public static final void v(String message) {
        v(null, message);
    }

    public static /* synthetic */ void v$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        v(str, str2);
    }

    @JvmStatic
    public static final void w(String message) {
        w(null, message);
    }

    public static /* synthetic */ void w$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        w(str, str2);
    }

    @JvmStatic
    public static final void apiCalledLog(String tag, String message) {
        LoggerImpl.INSTANCE.logBase("Trace", tag, message, LoggerImpl.HiveLogOutputTargetType.Both, false);
    }

    @JvmStatic
    public static final void d(String tag, String message) {
        INSTANCE.log(LogType.Debug, tag, message);
    }

    @JvmStatic
    public static final void e(String tag, String message) {
        INSTANCE.log(LogType.Error, tag, message);
    }

    @JvmStatic
    public static final void i(String tag, String message) {
        INSTANCE.log(LogType.Info, tag, message);
    }

    @JvmStatic
    public static final void v(String tag, String message) {
        INSTANCE.log(LogType.Verbose, tag, message);
    }

    @JvmStatic
    public static final void w(String tag, String message) {
        INSTANCE.log(LogType.Warning, tag, message);
    }
}
