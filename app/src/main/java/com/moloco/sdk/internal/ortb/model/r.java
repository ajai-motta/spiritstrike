package com.moloco.sdk.internal.ortb.model;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0081\u0081\u0002\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/moloco/sdk/internal/ortb/model/r;", "", "<init>", "(Ljava/lang/String;I)V", com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.M, "a", "b", "c", "d", "e", InneractiveMediationDefs.GENDER_FEMALE, "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
@Serializable
public final class r {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<KSerializer<Object>> f2135a;

    @SerialName(TtmlNode.START)
    public static final r b = new r("Start", 0);

    @SerialName(TtmlNode.CENTER)
    public static final r c = new r("Center", 1);

    @SerialName(TtmlNode.END)
    public static final r d = new r("End", 2);

    @SerialName("left")
    public static final r e = new r("Left", 3);

    @SerialName(TtmlNode.RIGHT)
    public static final r f = new r("Right", 4);
    public static final /* synthetic */ r[] g;
    public static final /* synthetic */ EnumEntries h;

    /* JADX INFO: renamed from: com.moloco.sdk.internal.ortb.model.r$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final /* synthetic */ KSerializer a() {
            return (KSerializer) r.f2135a.getValue();
        }

        public final KSerializer<r> serializer() {
            return a();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        r[] rVarArrA = a();
        g = rVarArrA;
        h = EnumEntriesKt.enumEntries(rVarArrA);
        INSTANCE = new Companion(null);
        f2135a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.moloco.sdk.internal.ortb.model.r$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EnumsKt.createAnnotatedEnumSerializer("com.moloco.sdk.internal.ortb.model.HorizontalAlignment", r.values(), new String[]{TtmlNode.START, TtmlNode.CENTER, TtmlNode.END, "left", TtmlNode.RIGHT}, new Annotation[][]{null, null, null, null, null}, null);
            }
        });
    }

    public r(String str, int i) {
    }

    public static final /* synthetic */ r[] a() {
        return new r[]{b, c, d, e, f};
    }

    public static EnumEntries<r> d() {
        return h;
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) g.clone();
    }
}
