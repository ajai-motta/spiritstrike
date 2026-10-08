package com.hive.logger;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.net.HttpHeaders;
import com.hive.Logger;
import com.hive.core.Logger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001:B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JS\u0010\r\u001a\u00020\u000e2K\u0010\u000f\u001aG\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000e0\u0010J\u0006\u0010\u0018\u001a\u00020\u000eJ\u0010\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u001a\u0010\u0019\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u001a\u0010\u001b\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u001a\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u001d\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u001a\u0010\u001d\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u001a\u0010\u001e\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u001f\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u001a\u0010\u001f\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u0010\u0010 \u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u001a\u0010 \u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u0010\u0010!\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u001a\u0010!\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\"\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u001a\u0010\"\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u0010\u0010#\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u001a\u0010#\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u0010\u0010$\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u001a\u0010$\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u0010\u0010%\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u001a\u0010%\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u0010\u0010&\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u001a\u0010&\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u0010\u0010'\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u001a\u0010'\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u0010\u0010(\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u001a\u0010(\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u001a\u0010)\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010*\u001a\u0004\u0018\u00010\u0015J\u001a\u0010+\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010,\u001a\u0004\u0018\u00010\u0015J \u0010-\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010.\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u0015J\u0010\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u000201H\u0007J\u0006\u00102\u001a\u00020\u0015J2\u00103\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207J2\u00103\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207J\u0010\u00108\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u0015H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006;"}, d2 = {"Lcom/hive/logger/LoggerImpl;", "", "<init>", "()V", "onLoggerListener", "Lcom/hive/core/Logger$OnLoggerListener;", "value", "Lcom/hive/Logger$LogFilter;", "logFilter", "getLogFilter", "()Lcom/hive/Logger$LogFilter;", "setLogFilter", "(Lcom/hive/Logger$LogFilter;)V", "setLoggerListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function3;", "Lcom/hive/Logger$LogType;", "Lkotlin/ParameterName;", "name", "type", "", ViewHierarchyConstants.TAG_KEY, "message", "removeLoggerListener", "vL", NotificationCompat.CATEGORY_MESSAGE, "vR", "v", "dL", "dR", "d", "iL", "iR", "i", "wL", "wR", "w", "eL", "eR", "e", "apiCalledLog", NativeProtocol.WEB_DIALOG_PARAMS, "apiReturnLog", "result", "apiCallbackLog", "apiName", "getCallMethodName", "deep", "", "getCallSourceInfo", "logBase", "targetType", "Lcom/hive/logger/LoggerImpl$HiveLogOutputTargetType;", "isSdkLog", "", "toRemoteLoggerType", "logType", "HiveLogOutputTargetType", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoggerImpl {
    public static final LoggerImpl INSTANCE = new LoggerImpl();
    private static Logger.OnLoggerListener onLoggerListener;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/hive/logger/LoggerImpl$HiveLogOutputTargetType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LocalOnly", "RemoteOnly", "Both", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HiveLogOutputTargetType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ HiveLogOutputTargetType[] $VALUES;
        private final String value;
        public static final HiveLogOutputTargetType LocalOnly = new HiveLogOutputTargetType("LocalOnly", 0, "LocalOnly");
        public static final HiveLogOutputTargetType RemoteOnly = new HiveLogOutputTargetType("RemoteOnly", 1, "RemoteOnly");
        public static final HiveLogOutputTargetType Both = new HiveLogOutputTargetType("Both", 2, "Both");

        private static final /* synthetic */ HiveLogOutputTargetType[] $values() {
            return new HiveLogOutputTargetType[]{LocalOnly, RemoteOnly, Both};
        }

        static {
            HiveLogOutputTargetType[] hiveLogOutputTargetTypeArr$values = $values();
            $VALUES = hiveLogOutputTargetTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(hiveLogOutputTargetTypeArr$values);
        }

        private HiveLogOutputTargetType(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<HiveLogOutputTargetType> getEntries() {
            return $ENTRIES;
        }

        public static HiveLogOutputTargetType valueOf(String str) {
            return (HiveLogOutputTargetType) Enum.valueOf(HiveLogOutputTargetType.class, str);
        }

        public static HiveLogOutputTargetType[] values() {
            return (HiveLogOutputTargetType[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    private LoggerImpl() {
    }

    @JvmStatic
    public static final String getCallMethodName(int deep) {
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        if (stackTrace.length < deep + 1) {
            return "unknown.unknown()";
        }
        String className = stackTrace[deep].getClassName();
        Intrinsics.checkNotNull(className);
        Intrinsics.checkNotNull(className);
        String strSubstring = className.substring(StringsKt.lastIndexOf$default((CharSequence) className, '.', 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring + '.' + stackTrace[deep].getMethodName() + "()";
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final String toRemoteLoggerType(String logType) {
        switch (logType.hashCode()) {
            case -1505867908:
                return !logType.equals(HttpHeaders.WARNING) ? ExifInterface.GPS_MEASUREMENT_INTERRUPTED : ExifInterface.LONGITUDE_WEST;
            case 2283726:
                return !logType.equals("Info") ? ExifInterface.GPS_MEASUREMENT_INTERRUPTED : "I";
            case 65906227:
                return !logType.equals("Debug") ? ExifInterface.GPS_MEASUREMENT_INTERRUPTED : "D";
            case 67232232:
                return !logType.equals(k.c) ? ExifInterface.GPS_MEASUREMENT_INTERRUPTED : ExifInterface.LONGITUDE_EAST;
            case 81068325:
                return !logType.equals("Trace") ? ExifInterface.GPS_MEASUREMENT_INTERRUPTED : "T";
            case 2015760738:
                logType.equals("Verbose");
                return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
            default:
                return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        }
    }

    public final void apiCallbackLog(String tag, String apiName, String result) {
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Intrinsics.checkNotNullParameter(result, "result");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("\n[API_CB] === %s ===\n%s\n\n", Arrays.copyOf(new Object[]{apiName, result}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        logBase("Trace", tag, str, HiveLogOutputTargetType.Both, true);
    }

    public final String apiCalledLog(String tag, String params) {
        String callMethodName = getCallMethodName(2);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("\n[API_CALL] === %s ===\n%s\n\n", Arrays.copyOf(new Object[]{callMethodName, params}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        logBase("Trace", tag, str, HiveLogOutputTargetType.Both, true);
        return callMethodName;
    }

    public final String apiReturnLog(String tag, String result) {
        String callMethodName = getCallMethodName(2);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("\n[API_RET] === %s ===\n%s\n\n", Arrays.copyOf(new Object[]{callMethodName, result}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        logBase("Trace", tag, str, HiveLogOutputTargetType.Both, true);
        return callMethodName;
    }

    public final void d(String msg) {
        d(null, msg);
    }

    public final void dL(String msg) {
        dL(null, msg);
    }

    public final void dR(String msg) {
        dR(null, msg);
    }

    public final void e(String msg) {
        e(null, msg);
    }

    public final void eL(String msg) {
        eL(null, msg);
    }

    public final void eR(String msg) {
        eR(null, msg);
    }

    public final String getCallSourceInfo() {
        StackTraceElement stackTraceElement;
        Iterator it = ArrayIteratorKt.iterator(new Throwable().fillInStackTrace().getStackTrace());
        while (true) {
            if (!it.hasNext()) {
                stackTraceElement = null;
                break;
            }
            stackTraceElement = (StackTraceElement) it.next();
            if (!Intrinsics.areEqual(com.hive.Logger.class.getName(), stackTraceElement.getClassName()) && !Intrinsics.areEqual(LoggerImpl.class.getName(), stackTraceElement.getClassName())) {
                break;
            }
        }
        if (stackTraceElement == null) {
            return " [unknown]";
        }
        String str = "\r at " + stackTraceElement + '\n';
        return str == null ? " [unknown]" : str;
    }

    public final Logger.LogFilter getLogFilter() {
        return Logger.LogFilter.INSTANCE.fromCoreLogFilter$hive_service_release(com.hive.core.Logger.INSTANCE.getLogFilter());
    }

    public final void i(String msg) {
        i(null, msg);
    }

    public final void iL(String msg) {
        iL(null, msg);
    }

    public final void iR(String msg) {
        iR(null, msg);
    }

    public final void logBase(Logger.LogType type, String tag, String message, HiveLogOutputTargetType targetType, boolean isSdkLog) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(targetType, "targetType");
        logBase(type.name(), tag, message, targetType, isSdkLog);
    }

    public final void removeLoggerListener() {
        com.hive.core.Logger.INSTANCE.removeListener(onLoggerListener);
        onLoggerListener = null;
    }

    public final void setLogFilter(Logger.LogFilter value) {
        Intrinsics.checkNotNullParameter(value, "value");
        com.hive.core.Logger.INSTANCE.setLogFilter(value.toCoreLogFilter$hive_service_release());
    }

    public final void setLoggerListener(final Function3<? super Logger.LogType, ? super String, ? super String, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        removeLoggerListener();
        onLoggerListener = new Logger.OnLoggerListener() { // from class: com.hive.logger.LoggerImpl.setLoggerListener.1

            /* JADX INFO: renamed from: com.hive.logger.LoggerImpl$setLoggerListener$1$WhenMappings */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Logger.LogType.values().length];
                    try {
                        iArr[Logger.LogType.Verbose.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Logger.LogType.Debug.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Logger.LogType.Info.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[Logger.LogType.Warning.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[Logger.LogType.Error.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[Logger.LogType.None.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // com.hive.core.Logger.OnLoggerListener
            public void onLogEvent(Logger.LogType type, String tag, String message) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(message, "message");
                switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                    case 1:
                        listener.invoke(Logger.LogType.Verbose, tag, message);
                        return;
                    case 2:
                        listener.invoke(Logger.LogType.Debug, tag, message);
                        return;
                    case 3:
                        listener.invoke(Logger.LogType.Info, tag, message);
                        return;
                    case 4:
                        listener.invoke(Logger.LogType.Warning, tag, message);
                        return;
                    case 5:
                        listener.invoke(Logger.LogType.Error, tag, message);
                        return;
                    case 6:
                        return;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
        };
        com.hive.core.Logger.addListener$default(com.hive.core.Logger.INSTANCE, onLoggerListener, null, 2, null);
    }

    public final void v(String msg) {
        v(null, msg);
    }

    public final void vL(String msg) {
        vL(null, msg);
    }

    public final void vR(String msg) {
        vR(null, msg);
    }

    public final void w(String msg) {
        w(null, msg);
    }

    public final void wL(String msg) {
        wL(null, msg);
    }

    public final void wR(String msg) {
        wR(null, msg);
    }

    public final void d(String tag, String msg) {
        logBase(Logger.LogType.Debug, tag, msg, HiveLogOutputTargetType.Both, true);
    }

    public final void dL(String tag, String msg) {
        logBase(Logger.LogType.Debug, tag, msg, HiveLogOutputTargetType.LocalOnly, true);
    }

    public final void dR(String tag, String msg) {
        logBase(Logger.LogType.Debug, tag, msg, HiveLogOutputTargetType.RemoteOnly, true);
    }

    public final void e(String tag, String msg) {
        logBase(Logger.LogType.Error, tag, msg, HiveLogOutputTargetType.Both, true);
    }

    public final void eL(String tag, String msg) {
        logBase(Logger.LogType.Error, tag, msg, HiveLogOutputTargetType.LocalOnly, true);
    }

    public final void eR(String tag, String msg) {
        logBase(Logger.LogType.Error, tag, msg, HiveLogOutputTargetType.RemoteOnly, true);
    }

    public final void i(String tag, String msg) {
        logBase(Logger.LogType.Info, tag, msg, HiveLogOutputTargetType.Both, true);
    }

    public final void iL(String tag, String msg) {
        logBase(Logger.LogType.Info, tag, msg, HiveLogOutputTargetType.LocalOnly, true);
    }

    public final void iR(String tag, String msg) {
        logBase(Logger.LogType.Info, tag, msg, HiveLogOutputTargetType.RemoteOnly, true);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void logBase(java.lang.String r4, java.lang.String r5, java.lang.String r6, com.hive.logger.LoggerImpl.HiveLogOutputTargetType r7, boolean r8) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.logger.LoggerImpl.logBase(java.lang.String, java.lang.String, java.lang.String, com.hive.logger.LoggerImpl$HiveLogOutputTargetType, boolean):void");
    }

    public final void v(String tag, String msg) {
        logBase(Logger.LogType.Verbose, tag, msg, HiveLogOutputTargetType.Both, true);
    }

    public final void vL(String tag, String msg) {
        logBase(Logger.LogType.Verbose, tag, msg, HiveLogOutputTargetType.LocalOnly, true);
    }

    public final void vR(String tag, String msg) {
        logBase(Logger.LogType.Verbose, tag, msg, HiveLogOutputTargetType.RemoteOnly, true);
    }

    public final void w(String tag, String msg) {
        logBase(Logger.LogType.Warning, tag, msg, HiveLogOutputTargetType.Both, true);
    }

    public final void wL(String tag, String msg) {
        logBase(Logger.LogType.Warning, tag, msg, HiveLogOutputTargetType.LocalOnly, true);
    }

    public final void wR(String tag, String msg) {
        logBase(Logger.LogType.Warning, tag, msg, HiveLogOutputTargetType.RemoteOnly, true);
    }
}
