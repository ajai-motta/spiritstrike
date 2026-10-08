package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: AnnotationUseSiteTarget.kt */
/* JADX INFO: loaded from: classes7.dex */
public final class AnnotationUseSiteTarget {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AnnotationUseSiteTarget[] $VALUES;
    public static final AnnotationUseSiteTarget FIELD;
    public static final AnnotationUseSiteTarget PROPERTY;
    private final String renderName;
    public static final AnnotationUseSiteTarget ALL = new AnnotationUseSiteTarget("ALL", 0, null, 1, null);
    public static final AnnotationUseSiteTarget FILE = new AnnotationUseSiteTarget("FILE", 2, null, 1, null);
    public static final AnnotationUseSiteTarget PROPERTY_GETTER = new AnnotationUseSiteTarget("PROPERTY_GETTER", 4, "get");
    public static final AnnotationUseSiteTarget PROPERTY_SETTER = new AnnotationUseSiteTarget("PROPERTY_SETTER", 5, "set");
    public static final AnnotationUseSiteTarget RECEIVER = new AnnotationUseSiteTarget("RECEIVER", 6, null, 1, null);
    public static final AnnotationUseSiteTarget CONSTRUCTOR_PARAMETER = new AnnotationUseSiteTarget("CONSTRUCTOR_PARAMETER", 7, "param");
    public static final AnnotationUseSiteTarget SETTER_PARAMETER = new AnnotationUseSiteTarget("SETTER_PARAMETER", 8, "setparam");
    public static final AnnotationUseSiteTarget PROPERTY_DELEGATE_FIELD = new AnnotationUseSiteTarget("PROPERTY_DELEGATE_FIELD", 9, "delegate");

    private static final /* synthetic */ AnnotationUseSiteTarget[] $values() {
        return new AnnotationUseSiteTarget[]{ALL, FIELD, FILE, PROPERTY, PROPERTY_GETTER, PROPERTY_SETTER, RECEIVER, CONSTRUCTOR_PARAMETER, SETTER_PARAMETER, PROPERTY_DELEGATE_FIELD};
    }

    private AnnotationUseSiteTarget(String str, int i, String str2) {
        this.renderName = str2 == null ? CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(name()) : str2;
    }

    /* synthetic */ AnnotationUseSiteTarget(String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 1) != 0 ? null : str2);
    }

    static {
        int i = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        String str = null;
        FIELD = new AnnotationUseSiteTarget("FIELD", 1, str, i, defaultConstructorMarker);
        PROPERTY = new AnnotationUseSiteTarget("PROPERTY", 3, str, i, defaultConstructorMarker);
        AnnotationUseSiteTarget[] annotationUseSiteTargetArr$values = $values();
        $VALUES = annotationUseSiteTargetArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(annotationUseSiteTargetArr$values);
    }

    public final String getRenderName() {
        return this.renderName;
    }

    public static AnnotationUseSiteTarget valueOf(String str) {
        return (AnnotationUseSiteTarget) Enum.valueOf(AnnotationUseSiteTarget.class, str);
    }

    public static AnnotationUseSiteTarget[] values() {
        return (AnnotationUseSiteTarget[]) $VALUES.clone();
    }
}
