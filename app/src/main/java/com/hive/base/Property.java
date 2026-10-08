package com.hive.base;

import android.content.Context;
import com.hive.core.Configuration;
import com.hive.core.Crypto;
import com.hive.core.HiveCoreInitializer;
import com.hive.core.Logger;
import com.hive.core.PropertyManager;
import com.hive.core.configuration.HiveZoneType;
import com.hive.ui.Resource;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Properties;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 $2\u00020\u0001:\u0002$%B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0012\u001a\u00020\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u0003J\u0016\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003J\"\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0003J\u0006\u0010\u001f\u001a\u00020\u000bJ\u0006\u0010 \u001a\u00020\u000bJ\u0018\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\f\u0010#\u001a\u00020\t*\u00020\tH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u0011¨\u0006&"}, d2 = {"Lcom/hive/base/Property;", "", "propertiesFileName", "", "<init>", "(Ljava/lang/String;)V", "getPropertiesFileName", "()Ljava/lang/String;", "properties", "Lcom/hive/core/Property;", "isPropertiesInitialized", "", "()Z", "lastZoneType", "Lcom/hive/core/configuration/HiveZoneType;", "isPrefixFileName", "setPrefixFileName", "(Z)V", "loadProperties", "context", "Landroid/content/Context;", "checkZoneAndLoad", "", "getValue", "name", "defValue", "setValue", "value", "saveOption", "Lcom/hive/base/Property$PropertySaveOption;", "removeValue", "writeProperties", "deletePropertyFile", "migration", "property", "migrationDid", k.M, "PropertySaveOption", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class Property {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<Property> INSTANCE$delegate = LazyKt.lazy(new Function0() { // from class: com.hive.base.Property$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Property.INSTANCE_delegate$lambda$3();
        }
    });
    private static final String sdkFileName = "hivesdkv4config.dat";
    private boolean isPrefixFileName;
    private HiveZoneType lastZoneType;
    private com.hive.core.Property properties;
    private final String propertiesFileName;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/hive/base/Property$Companion;", "", "<init>", "()V", "sdkFileName", "", "INSTANCE", "Lcom/hive/base/Property;", "getINSTANCE", "()Lcom/hive/base/Property;", "INSTANCE$delegate", "Lkotlin/Lazy;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Property getINSTANCE() {
            return (Property) Property.INSTANCE$delegate.getValue();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/hive/base/Property$PropertySaveOption;", "", "<init>", "(Ljava/lang/String;I)V", "NotSave", "SaveEmptyString", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PropertySaveOption {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PropertySaveOption[] $VALUES;
        public static final PropertySaveOption NotSave = new PropertySaveOption("NotSave", 0);
        public static final PropertySaveOption SaveEmptyString = new PropertySaveOption("SaveEmptyString", 1);

        private static final /* synthetic */ PropertySaveOption[] $values() {
            return new PropertySaveOption[]{NotSave, SaveEmptyString};
        }

        static {
            PropertySaveOption[] propertySaveOptionArr$values = $values();
            $VALUES = propertySaveOptionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(propertySaveOptionArr$values);
        }

        private PropertySaveOption(String str, int i) {
        }

        public static EnumEntries<PropertySaveOption> getEntries() {
            return $ENTRIES;
        }

        public static PropertySaveOption valueOf(String str) {
            return (PropertySaveOption) Enum.valueOf(PropertySaveOption.class, str);
        }

        public static PropertySaveOption[] values() {
            return (PropertySaveOption[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PropertySaveOption.values().length];
            try {
                iArr[PropertySaveOption.NotSave.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PropertySaveOption.SaveEmptyString.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Property(String propertiesFileName) {
        Intrinsics.checkNotNullParameter(propertiesFileName, "propertiesFileName");
        this.propertiesFileName = propertiesFileName;
        this.isPrefixFileName = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Property INSTANCE_delegate$lambda$3() {
        return new Property(sdkFileName);
    }

    private final void checkZoneAndLoad() {
        if (isPropertiesInitialized() && this.lastZoneType == Configuration.INSTANCE.getZone()) {
            return;
        }
        this.lastZoneType = Configuration.INSTANCE.getZone();
        this.properties = loadProperties$default(this, null, 1, null);
    }

    private final boolean isPropertiesInitialized() {
        return this.properties != null;
    }

    public static /* synthetic */ com.hive.core.Property loadProperties$default(Property property, Context context, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadProperties");
        }
        if ((i & 1) != 0) {
            context = null;
        }
        return property.loadProperties(context);
    }

    private final com.hive.core.Property migration(com.hive.core.Property property, String propertiesFileName) {
        Context initContext = HiveCoreInitializer.INSTANCE.getInitContext();
        if (StringsKt.endsWith$default(propertiesFileName, sdkFileName, false, 2, (Object) null)) {
            propertiesFileName = Configuration.INSTANCE.getZone().getValue() + "_Hivev2Prop.dat";
        }
        Resource resource = Resource.INSTANCE;
        if (resource.isExistFile(initContext, propertiesFileName)) {
            Properties properties = new Properties();
            try {
                File file = new File(initContext.getFilesDir(), propertiesFileName);
                byte[] file2 = resource.readFile(file);
                String str = file2 != null ? new String(file2, Charsets.UTF_8) : null;
                if (str != null && !StringsKt.isBlank(str)) {
                    Logger.INSTANCE.d("[Property Migration] : " + propertiesFileName);
                    String strInternalGetAndroidId$hive_service_release = Android.INSTANCE.internalGetAndroidId$hive_service_release();
                    if (strInternalGetAndroidId$hive_service_release == null) {
                        strInternalGetAndroidId$hive_service_release = propertiesFileName;
                    }
                    Crypto crypto = Crypto.INSTANCE;
                    Crypto.HashType hashType = Crypto.HashType.MD5;
                    Charset charset = Charsets.UTF_8;
                    byte[] bytes = strInternalGetAndroidId$hive_service_release.getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                    byte[] bytes2 = crypto.decryptAES(hashType, crypto.createHash(hashType, bytes), str).getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                    properties.load(new ByteArrayInputStream(bytes2));
                    for (String str2 : properties.stringPropertyNames()) {
                        String property2 = properties.getProperty(str2);
                        if (property2 != null && !StringsKt.isBlank(property2)) {
                            Intrinsics.checkNotNull(str2);
                            property.set(str2, property2);
                            Unit unit = Unit.INSTANCE;
                            Logger.INSTANCE.d("[Property Migration] [" + propertiesFileName + "]: " + str2 + ", " + property2);
                        }
                    }
                    if (property.write()) {
                        properties.clear();
                        file.delete();
                        Logger.INSTANCE.d("[Property Migration] Complete.");
                        return property;
                    }
                    Logger.INSTANCE.e("[Property Migration] Failed.");
                }
                return property;
            } catch (Exception e) {
                Logger.INSTANCE.w("[Property] migration() \ne: " + e.getMessage());
            }
        }
        return property;
    }

    public static /* synthetic */ boolean setValue$default(Property property, String str, String str2, PropertySaveOption propertySaveOption, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setValue");
        }
        if ((i & 4) != 0) {
            propertySaveOption = PropertySaveOption.SaveEmptyString;
        }
        return property.setValue(str, str2, propertySaveOption);
    }

    public final synchronized boolean deletePropertyFile() {
        checkZoneAndLoad();
        com.hive.core.Property property = this.properties;
        if (property == null) {
            Intrinsics.throwUninitializedPropertyAccessException("properties");
            property = null;
        }
        if (!property.delete()) {
            return false;
        }
        this.lastZoneType = null;
        return true;
    }

    public final String getPropertiesFileName() {
        return this.propertiesFileName;
    }

    public final synchronized String getValue(String name) {
        com.hive.core.Property property;
        Intrinsics.checkNotNullParameter(name, "name");
        checkZoneAndLoad();
        property = this.properties;
        if (property == null) {
            Intrinsics.throwUninitializedPropertyAccessException("properties");
            property = null;
        }
        return property.get(name);
    }

    /* JADX INFO: renamed from: isPrefixFileName, reason: from getter */
    public final boolean getIsPrefixFileName() {
        return this.isPrefixFileName;
    }

    public synchronized com.hive.core.Property loadProperties(Context context) {
        String str;
        com.hive.core.Property propertyManager;
        if (this.isPrefixFileName) {
            str = Configuration.INSTANCE.getZone().getValue() + '_' + this.propertiesFileName;
        } else {
            str = this.propertiesFileName;
        }
        if (context == null) {
            propertyManager = PropertyManager.INSTANCE.getInstance(str);
        } else {
            HiveCoreInitializer.INSTANCE.setInitContext(context.getApplicationContext());
            propertyManager = PropertyManager.INSTANCE.getInstance(context, str);
        }
        return migrationDid(migration(propertyManager, str));
    }

    public final synchronized boolean removeValue(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        checkZoneAndLoad();
        com.hive.core.Property property = this.properties;
        if (property == null) {
            Intrinsics.throwUninitializedPropertyAccessException("properties");
            property = null;
        }
        property.remove(name);
        return true;
    }

    public final void setPrefixFileName(boolean z) {
        this.isPrefixFileName = z;
    }

    public final synchronized boolean setValue(String name, String value, PropertySaveOption saveOption) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(saveOption, "saveOption");
        checkZoneAndLoad();
        com.hive.core.Property property = null;
        if (value != null) {
            com.hive.core.Property property2 = this.properties;
            if (property2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("properties");
            } else {
                property = property2;
            }
            property.set(name, value);
            return true;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[saveOption.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        com.hive.core.Property property3 = this.properties;
        if (property3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("properties");
        } else {
            property = property3;
        }
        property.set(name, "");
        return true;
    }

    public final synchronized boolean writeProperties() {
        com.hive.core.Property property;
        checkZoneAndLoad();
        property = this.properties;
        if (property == null) {
            Intrinsics.throwUninitializedPropertyAccessException("properties");
            property = null;
        }
        return property.write();
    }

    public final synchronized String getValue(String name, String defValue) {
        String str;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(defValue, "defValue");
        checkZoneAndLoad();
        com.hive.core.Property property = this.properties;
        if (property == null) {
            Intrinsics.throwUninitializedPropertyAccessException("properties");
            property = null;
        }
        str = property.get(name);
        return str == null ? defValue : str;
    }

    private final com.hive.core.Property migrationDid(com.hive.core.Property property) {
        String str;
        if (!StringsKt.endsWith$default(property.getFileName(), sdkFileName, false, 2, (Object) null) || ((str = property.get("hlc.did")) != null && !StringsKt.isBlank(str))) {
            return property;
        }
        Logger.INSTANCE.d("[Property] migrationDid");
        String str2 = property.get("authv4.did");
        String str3 = property.get("auth.did");
        if (str2 != null && (!StringsKt.isBlank(str2))) {
            property.set("hlc.did", str2);
            property.remove("authv4.did");
            property.write();
            return property;
        }
        if (str3 != null && (!StringsKt.isBlank(str3))) {
            property.set("hlc.did", str3);
            property.remove("auth.did");
            property.write();
        }
        return property;
    }
}
