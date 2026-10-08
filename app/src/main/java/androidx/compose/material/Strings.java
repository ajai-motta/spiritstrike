package androidx.compose.material;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0081@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/material/Strings;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", k.M, "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
public final class Strings {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int NavigationMenu = m1172constructorimpl(0);
    private static final int CloseDrawer = m1172constructorimpl(1);
    private static final int CloseSheet = m1172constructorimpl(2);
    private static final int DefaultErrorMessage = m1172constructorimpl(3);
    private static final int ExposedDropdownMenu = m1172constructorimpl(4);
    private static final int SliderRangeStart = m1172constructorimpl(5);
    private static final int SliderRangeEnd = m1172constructorimpl(6);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Strings m1171boximpl(int i) {
        return new Strings(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m1172constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1173equalsimpl(int i, Object obj) {
        return (obj instanceof Strings) && i == ((Strings) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1174equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1175hashCodeimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1176toStringimpl(int i) {
        return "Strings(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m1173equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1175hashCodeimpl(this.value);
    }

    public String toString() {
        return m1176toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    /* JADX INFO: compiled from: Strings.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Landroidx/compose/material/Strings$Companion;", "", "()V", "CloseDrawer", "Landroidx/compose/material/Strings;", "getCloseDrawer-UdPEhr4", "()I", "I", "CloseSheet", "getCloseSheet-UdPEhr4", "DefaultErrorMessage", "getDefaultErrorMessage-UdPEhr4", "ExposedDropdownMenu", "getExposedDropdownMenu-UdPEhr4", "NavigationMenu", "getNavigationMenu-UdPEhr4", "SliderRangeEnd", "getSliderRangeEnd-UdPEhr4", "SliderRangeStart", "getSliderRangeStart-UdPEhr4", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getNavigationMenu-UdPEhr4, reason: not valid java name */
        public final int m1182getNavigationMenuUdPEhr4() {
            return Strings.NavigationMenu;
        }

        /* JADX INFO: renamed from: getCloseDrawer-UdPEhr4, reason: not valid java name */
        public final int m1178getCloseDrawerUdPEhr4() {
            return Strings.CloseDrawer;
        }

        /* JADX INFO: renamed from: getCloseSheet-UdPEhr4, reason: not valid java name */
        public final int m1179getCloseSheetUdPEhr4() {
            return Strings.CloseSheet;
        }

        /* JADX INFO: renamed from: getDefaultErrorMessage-UdPEhr4, reason: not valid java name */
        public final int m1180getDefaultErrorMessageUdPEhr4() {
            return Strings.DefaultErrorMessage;
        }

        /* JADX INFO: renamed from: getExposedDropdownMenu-UdPEhr4, reason: not valid java name */
        public final int m1181getExposedDropdownMenuUdPEhr4() {
            return Strings.ExposedDropdownMenu;
        }

        /* JADX INFO: renamed from: getSliderRangeStart-UdPEhr4, reason: not valid java name */
        public final int m1184getSliderRangeStartUdPEhr4() {
            return Strings.SliderRangeStart;
        }

        /* JADX INFO: renamed from: getSliderRangeEnd-UdPEhr4, reason: not valid java name */
        public final int m1183getSliderRangeEndUdPEhr4() {
            return Strings.SliderRangeEnd;
        }
    }

    private /* synthetic */ Strings(int i) {
        this.value = i;
    }
}
