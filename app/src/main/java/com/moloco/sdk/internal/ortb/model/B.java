package com.moloco.sdk.internal.ortb.model;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0081\u0081\u0002\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/moloco/sdk/internal/ortb/model/B;", "", "<init>", "(Ljava/lang/String;I)V", com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.M, "a", "b", "c", "d", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
@Serializable
public final class B {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<KSerializer<Object>> f2103a;

    @SerialName(ViewHierarchyConstants.DIMENSION_TOP_KEY)
    public static final B b = new B("Top", 0);

    @SerialName(TtmlNode.CENTER)
    public static final B c = new B("Center", 1);

    @SerialName("bottom")
    public static final B d = new B("Bottom", 2);
    public static final /* synthetic */ B[] e;
    public static final /* synthetic */ EnumEntries f;

    /* JADX INFO: renamed from: com.moloco.sdk.internal.ortb.model.B$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final /* synthetic */ KSerializer a() {
            return (KSerializer) B.f2103a.getValue();
        }

        public final KSerializer<B> serializer() {
            return a();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        B[] bArrA = a();
        e = bArrA;
        f = EnumEntriesKt.enumEntries(bArrA);
        INSTANCE = new Companion(null);
        f2103a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.moloco.sdk.internal.ortb.model.B$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EnumsKt.createAnnotatedEnumSerializer("com.moloco.sdk.internal.ortb.model.VerticalAlignment", B.values(), new String[]{ViewHierarchyConstants.DIMENSION_TOP_KEY, TtmlNode.CENTER, "bottom"}, new Annotation[][]{null, null, null}, null);
            }
        });
    }

    public B(String str, int i) {
    }

    public static final /* synthetic */ B[] a() {
        return new B[]{b, c, d};
    }

    public static EnumEntries<B> d() {
        return f;
    }

    public static B valueOf(String str) {
        return (B) Enum.valueOf(B.class, str);
    }

    public static B[] values() {
        return (B[]) e.clone();
    }
}
