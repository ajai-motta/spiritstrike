package com.hive.configuration;

import com.hive.Configuration;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.HiveModuleName;
import com.hive.module.ModuleCheckName;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bH\u0002J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bH\u0002J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0002¨\u0006\u0010"}, d2 = {"Lcom/hive/configuration/ModuleChecker;", "", "<init>", "()V", "getLogHiveModuleVersionInfo", "", "includeJsonDataHiveModuleVersionInfo", "", "jsonData", "Lorg/json/JSONObject;", "getAppReferLibsVersionInfo", "", "getCoreLevelLibsVersionInfo", "getAndroidSupportLibsVersionInfo", "getMetaInfoFileVersion", "fileName", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModuleChecker {
    public static final ModuleChecker INSTANCE = new ModuleChecker();

    private ModuleChecker() {
    }

    private final Map<String, String> getAndroidSupportLibsVersionInfo() {
        LoggerImpl.INSTANCE.d("ModuleChecker, getAndroidSupportLibsVersionInfo");
        HashMap map = new HashMap();
        String metaInfoFileVersion = getMetaInfoFileVersion("META-INF/androidx.appcompat_appcompat.version");
        if (metaInfoFileVersion != null) {
            map.put(ModuleCheckName.INSTANCE.getAndroidx_Appcompat(), metaInfoFileVersion);
        }
        String metaInfoFileVersion2 = getMetaInfoFileVersion("META-INF/androidx.cardview_cardview.version");
        if (metaInfoFileVersion2 != null) {
            map.put(ModuleCheckName.INSTANCE.getAndroidx_Cardview(), metaInfoFileVersion2);
        }
        String metaInfoFileVersion3 = getMetaInfoFileVersion("META-INF/androidx.browser_browser.version");
        if (metaInfoFileVersion3 != null) {
            map.put(ModuleCheckName.INSTANCE.getAndroidx_Browser(), metaInfoFileVersion3);
        }
        String metaInfoFileVersion4 = getMetaInfoFileVersion("META-INF/androidx.core_core.version");
        if (metaInfoFileVersion4 != null) {
            map.put(ModuleCheckName.INSTANCE.getAndroidx_Core(), metaInfoFileVersion4);
        }
        String metaInfoFileVersion5 = getMetaInfoFileVersion("META-INF/androidx.emoji2_emoji2.version");
        if (metaInfoFileVersion5 != null) {
            map.put(ModuleCheckName.INSTANCE.getAndroidx_Emoji2(), metaInfoFileVersion5);
        }
        String metaInfoFileVersion6 = getMetaInfoFileVersion("META-INF/androidx.startup_startup-runtime.version");
        if (metaInfoFileVersion6 != null) {
            map.put(ModuleCheckName.INSTANCE.getAndroidx_Startup(), metaInfoFileVersion6);
        }
        String metaInfoFileVersion7 = getMetaInfoFileVersion("META-INF/androidx.recyclerview_recyclerview.version");
        if (metaInfoFileVersion7 != null) {
            map.put(ModuleCheckName.INSTANCE.getAndroidx_Recyclerview(), metaInfoFileVersion7);
        }
        String metaInfoFileVersion8 = getMetaInfoFileVersion("META-INF/kotlinx_coroutines_core.version");
        if (metaInfoFileVersion8 != null) {
            map.put(ModuleCheckName.INSTANCE.getKotlinx_Coroutines_Core(), metaInfoFileVersion8);
        }
        String metaInfoFileVersion9 = getMetaInfoFileVersion("META-INF/kotlinx_coroutines_android.version");
        if (metaInfoFileVersion9 != null) {
            map.put(ModuleCheckName.INSTANCE.getKotlinx_Coroutines_Android(), metaInfoFileVersion9);
        }
        String metaInfoFileVersion10 = getMetaInfoFileVersion("META-INF/androidx.lifecycle_lifecycle-runtime-ktx.version");
        if (metaInfoFileVersion10 != null) {
            map.put(ModuleCheckName.INSTANCE.getAndroidx_Lifecycle_Runtime(), metaInfoFileVersion10);
        }
        String metaInfoFileVersion11 = getMetaInfoFileVersion("META-INF/androidx.lifecycle_lifecycle-viewmodel-ktx.version");
        if (metaInfoFileVersion11 != null) {
            map.put(ModuleCheckName.INSTANCE.getAndroidx_Lifecycle_Viewmodel(), metaInfoFileVersion11);
        }
        String metaInfoFileVersion12 = getMetaInfoFileVersion("META-INF/androidx.lifecycle_lifecycle-livedata-ktx.version");
        if (metaInfoFileVersion12 != null) {
            map.put(ModuleCheckName.INSTANCE.getAndroidx_Lifecycle_Livedata(), metaInfoFileVersion12);
        }
        return map;
    }

    private final Map<String, String> getAppReferLibsVersionInfo() {
        Object objM7415constructorimpl;
        Unit unit;
        LoggerImpl.INSTANCE.d("ModuleChecker, getAppReferLibsVersionInfo");
        HashMap map = new HashMap();
        map.putAll(getCoreLevelLibsVersionInfo());
        Field[] declaredFields = HiveModuleName.Companion.class.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
        for (Field field : declaredFields) {
            field.setAccessible(true);
            try {
                Result.Companion companion = Result.INSTANCE;
                Object obj = field.get(HiveModuleName.INSTANCE);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                HiveModule hiveModule = HiveModuleManager.INSTANCE.getHiveModule((String) obj);
                if (hiveModule != null) {
                    map.putAll(hiveModule.getVersionInfo());
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                objM7415constructorimpl = Result.m7415constructorimpl(unit);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
            if (thM7418exceptionOrNullimpl != null) {
                LoggerImpl.INSTANCE.w("ModuleChecker, getAppReferLibsVersionInfo failure: " + thM7418exceptionOrNullimpl);
            }
        }
        map.putAll(getAndroidSupportLibsVersionInfo());
        return map;
    }

    private final Map<String, String> getCoreLevelLibsVersionInfo() {
        ModuleCheckName moduleCheckName = ModuleCheckName.INSTANCE;
        return MapsKt.mutableMapOf(TuplesKt.to(moduleCheckName.getHive_Core(), "26.2.0"), TuplesKt.to(moduleCheckName.getHive_Protocol(), "26.2.0"), TuplesKt.to(moduleCheckName.getHive_Ui(), "26.2.0"));
    }

    private final String getMetaInfoFileVersion(String fileName) {
        Object objM7415constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            InputStream resourceAsStream = Configuration.getContext().getClassLoader().getResourceAsStream(fileName);
            Intrinsics.checkNotNullExpressionValue(resourceAsStream, "getResourceAsStream(...)");
            Reader inputStreamReader = new InputStreamReader(resourceAsStream, Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                String string = StringsKt.trimEnd((CharSequence) TextStreamsKt.readText(bufferedReader)).toString();
                CloseableKt.closeFinally(bufferedReader, null);
                objM7415constructorimpl = Result.m7415constructorimpl(string);
            } finally {
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        return (String) (Result.m7421isFailureimpl(objM7415constructorimpl) ? null : objM7415constructorimpl);
    }

    public final String getLogHiveModuleVersionInfo() {
        LoggerImpl.INSTANCE.d("ModuleChecker, getLogHiveModuleVersionInfo");
        HashMap map = new HashMap();
        map.putAll(getAppReferLibsVersionInfo());
        String str = "=== using HiveSDK module ===\n";
        String str2 = "=== using External Libs ===\n";
        for (Map.Entry entry : MapsKt.toSortedMap(map, new Comparator() { // from class: com.hive.configuration.ModuleChecker$getLogHiveModuleVersionInfo$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((String) t, (String) t2);
            }
        }).entrySet()) {
            String str3 = (String) entry.getKey();
            String str4 = (String) entry.getValue();
            Intrinsics.checkNotNull(str3);
            if (StringsKt.contains$default((CharSequence) str3, (CharSequence) "hive-", false, 2, (Object) null)) {
                str = str + str3 + " : " + str4 + '\n';
            } else {
                str2 = str2 + str3 + " : " + str4 + '\n';
            }
        }
        return str + str2;
    }

    public final void includeJsonDataHiveModuleVersionInfo(JSONObject jsonData) {
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        LoggerImpl.INSTANCE.d("ModuleChecker, includeJsonDataHiveModuleVersionInfo");
        HashMap map = new HashMap();
        map.putAll(getAppReferLibsVersionInfo());
        for (Map.Entry entry : MapsKt.toSortedMap(map, new Comparator() { // from class: com.hive.configuration.ModuleChecker$includeJsonDataHiveModuleVersionInfo$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((String) t, (String) t2);
            }
        }).entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.checkNotNull(str);
                if (StringsKt.contains$default((CharSequence) str, (CharSequence) "hive-", false, 2, (Object) null)) {
                    jsonData.put(str, str2);
                }
                Result.m7415constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
        }
    }
}
