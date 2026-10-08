package com.moloco.sdk.internal.ortb.model;

import androidx.compose.ui.graphics.Color;
import com.facebook.internal.AnalyticsEvents;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.UIntSerializer;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\b\u0001\u0018\u0000 *2\u00020\u0001:\u0002\u0017\u001eB'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bBC\b\u0010\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u0010J'\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018R \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0017\u0010\u0019\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u0012\u0004\b\"\u0010\u001d\u001a\u0004\b \u0010!R \u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b#\u0010$\u0012\u0004\b'\u0010\u001d\u001a\u0004\b%\u0010&R \u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b \u0010(\u0012\u0004\b#\u0010\u001d\u001a\u0004\b\u001e\u0010)¨\u0006+"}, d2 = {"Lcom/moloco/sdk/internal/ortb/model/w;", "", "Lkotlin/UInt;", "padding", "Lcom/moloco/sdk/internal/ortb/model/r;", "horizontalAlignment", "Lcom/moloco/sdk/internal/ortb/model/B;", "verticalAlignment", "Landroidx/compose/ui/graphics/Color;", "foregroundColor", "<init>", "(ILcom/moloco/sdk/internal/ortb/model/r;Lcom/moloco/sdk/internal/ortb/model/B;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILkotlin/UInt;Lcom/moloco/sdk/internal/ortb/model/r;Lcom/moloco/sdk/internal/ortb/model/B;Landroidx/compose/ui/graphics/Color;Lkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "a", "(Lcom/moloco/sdk/internal/ortb/model/w;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "I", InneractiveMediationDefs.GENDER_FEMALE, "()I", "g", "()V", "b", "Lcom/moloco/sdk/internal/ortb/model/r;", "d", "()Lcom/moloco/sdk/internal/ortb/model/r;", "e", "c", "Lcom/moloco/sdk/internal/ortb/model/B;", "h", "()Lcom/moloco/sdk/internal/ortb/model/B;", "i", "J", "()J", com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.M, "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
@Serializable
public final class w {
    public static final int e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int padding;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final r horizontalAlignment;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final B verticalAlignment;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final long foregroundColor;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final KSerializer<Object>[] f = {null, r.INSTANCE.serializer(), B.INSTANCE.serializer(), null};

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<w> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2145a;
        public static final int b;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            f2145a = aVar;
            b = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.ProgressBar", aVar, 4);
            pluginGeneratedSerialDescriptor.addElement("padding", false);
            pluginGeneratedSerialDescriptor.addElement(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT, false);
            pluginGeneratedSerialDescriptor.addElement("vertical_alignment", false);
            pluginGeneratedSerialDescriptor.addElement("foreground_color", false);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final w deserialize(Decoder decoder) {
            int i;
            UInt uInt;
            r rVar;
            B b2;
            Color color;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            KSerializer[] kSerializerArr = w.f;
            UInt uInt2 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                UInt uInt3 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, UIntSerializer.INSTANCE, null);
                r rVar2 = (r) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], null);
                b2 = (B) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], null);
                uInt = uInt3;
                color = (Color) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, h.f2116a, null);
                i = 15;
                rVar = rVar2;
            } else {
                boolean z = true;
                int i2 = 0;
                r rVar3 = null;
                B b3 = null;
                Color color2 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        uInt2 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, UIntSerializer.INSTANCE, uInt2);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        rVar3 = (r) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], rVar3);
                        i2 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        b3 = (B) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], b3);
                        i2 |= 4;
                    } else {
                        if (iDecodeElementIndex != 3) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        color2 = (Color) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, h.f2116a, color2);
                        i2 |= 8;
                    }
                }
                i = i2;
                uInt = uInt2;
                rVar = rVar3;
                b2 = b3;
                color = color2;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new w(i, uInt, rVar, b2, color, null, null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            KSerializer<?>[] kSerializerArr = w.f;
            return new KSerializer[]{UIntSerializer.INSTANCE, kSerializerArr[1], kSerializerArr[2], h.f2116a};
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public /* synthetic */ KSerializer[] typeParametersSerializers() {
            return GeneratedSerializer.CC.$default$typeParametersSerializers(this);
        }

        @Override // kotlinx.serialization.SerializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, w value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            w.a(value, compositeEncoderBeginStructure, serialDescriptor);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.ortb.model.w$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<w> serializer() {
            return a.f2145a;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ w(int i, r rVar, B b, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, rVar, b, j);
    }

    @SerialName("foreground_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void c() {
    }

    @SerialName(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT)
    public static /* synthetic */ void e() {
    }

    @SerialName("padding")
    public static /* synthetic */ void g() {
    }

    @SerialName("vertical_alignment")
    public static /* synthetic */ void i() {
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getForegroundColor() {
        return this.foregroundColor;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final r getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getPadding() {
        return this.padding;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final B getVerticalAlignment() {
        return this.verticalAlignment;
    }

    public /* synthetic */ w(int i, UInt uInt, r rVar, B b, Color color, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, uInt, rVar, b, color, serializationConstructorMarker);
    }

    @JvmStatic
    public static final /* synthetic */ void a(w self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = f;
        output.encodeSerializableElement(serialDesc, 0, UIntSerializer.INSTANCE, UInt.m7508boximpl(self.padding));
        output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.horizontalAlignment);
        output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.verticalAlignment);
        output.encodeSerializableElement(serialDesc, 3, h.f2116a, Color.m1635boximpl(self.foregroundColor));
    }

    public /* synthetic */ w(int i, UInt uInt, r rVar, B b, Color color, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, a.f2145a.getDescriptor());
        }
        this.padding = uInt.getData();
        this.horizontalAlignment = rVar;
        this.verticalAlignment = b;
        this.foregroundColor = color.m1655unboximpl();
    }

    public w(int i, r horizontalAlignment, B verticalAlignment, long j) {
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
        this.padding = i;
        this.horizontalAlignment = horizontalAlignment;
        this.verticalAlignment = verticalAlignment;
        this.foregroundColor = j;
    }
}
