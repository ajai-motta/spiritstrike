package com.hive.core;

import android.content.Context;
import android.os.Build;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HiveContext.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/hive/core/HiveContext;", "", "<init>", "()V", "resourceContextField", "Landroid/content/Context;", "value", "resourceContext", "getResourceContext", "()Landroid/content/Context;", "setResourceContext", "(Landroid/content/Context;)V", "updateLocale", "language", "", "wrap", "context", "locale", "Ljava/util/Locale;", "getSystemLocale", "config", "Landroid/content/res/Configuration;", "setSystemLocale", "", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveContext {
    public static final HiveContext INSTANCE = new HiveContext();
    private static Context resourceContextField;

    private HiveContext() {
    }

    public final Context getResourceContext() {
        Context context = resourceContextField;
        return context == null ? HiveCoreInitializer.INSTANCE.getInitContext() : context;
    }

    public final void setResourceContext(Context value) {
        Intrinsics.checkNotNullParameter(value, "value");
        resourceContextField = value;
        if (HiveCoreInitializer.INSTANCE.isInitContextInitialized()) {
            return;
        }
        HiveCoreInitializer.INSTANCE.setInitContext(value.getApplicationContext());
    }

    public final Context updateLocale(String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        if (language.length() == 0) {
            Logger.coreLog$hive_core_release$default(Logger.INSTANCE, "language is empty", null, 2, null);
        } else {
            setResourceContext(wrap(getResourceContext(), language));
        }
        return getResourceContext();
    }

    public final Context wrap(Context context, Locale locale) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(locale, "locale");
        android.content.res.Configuration configuration = new android.content.res.Configuration(context.getResources().getConfiguration());
        if (Intrinsics.areEqual(getSystemLocale(configuration), locale)) {
            return context;
        }
        setSystemLocale(configuration, locale);
        Context contextCreateConfigurationContext = context.createConfigurationContext(configuration);
        Intrinsics.checkNotNullExpressionValue(contextCreateConfigurationContext, "createConfigurationContext(...)");
        return contextCreateConfigurationContext;
    }

    public final Context wrap(Context context, String language) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(language, "language");
        if (Intrinsics.areEqual(language, "zh-hans")) {
            Locale SIMPLIFIED_CHINESE = Locale.SIMPLIFIED_CHINESE;
            Intrinsics.checkNotNullExpressionValue(SIMPLIFIED_CHINESE, "SIMPLIFIED_CHINESE");
            return wrap(context, SIMPLIFIED_CHINESE);
        }
        if (!Intrinsics.areEqual(language, "zh-hant")) {
            return wrap(context, new Locale(language));
        }
        Locale TRADITIONAL_CHINESE = Locale.TRADITIONAL_CHINESE;
        Intrinsics.checkNotNullExpressionValue(TRADITIONAL_CHINESE, "TRADITIONAL_CHINESE");
        return wrap(context, TRADITIONAL_CHINESE);
    }

    private final Locale getSystemLocale(android.content.res.Configuration config) {
        if (Build.VERSION.SDK_INT >= 24) {
            Locale locale = config.getLocales().get(0);
            Intrinsics.checkNotNull(locale);
            return locale;
        }
        Locale locale2 = config.locale;
        Intrinsics.checkNotNull(locale2);
        return locale2;
    }

    private final void setSystemLocale(android.content.res.Configuration config, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            config.setLocale(locale);
        } else {
            config.locale = locale;
        }
    }
}
