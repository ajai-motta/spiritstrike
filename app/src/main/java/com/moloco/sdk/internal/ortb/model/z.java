package com.moloco.sdk.internal.ortb.model;

import androidx.compose.ui.graphics.Color;
import com.facebook.internal.AnalyticsEvents;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
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
import kotlinx.serialization.builtins.BuiltinSerializersKt;
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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001d\b\u0001\u0018\u0000 52\u00020\u0001:\u0002\u001a!BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eBa\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0013J'\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001a\u0010\u001bR \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001a\u0010\u001c\u0012\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR \u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b!\u0010\u001c\u0012\u0004\b#\u0010 \u001a\u0004\b\"\u0010\u001eR \u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b$\u0010\u001c\u0012\u0004\b&\u0010 \u001a\u0004\b%\u0010\u001eR \u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b%\u0010'\u0012\u0004\b*\u0010 \u001a\u0004\b(\u0010)R \u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b&\u0010+\u0012\u0004\b.\u0010 \u001a\u0004\b,\u0010-R \u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001d\u0010/\u0012\u0004\b2\u0010 \u001a\u0004\b0\u00101R\"\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001f\u00103\u0012\u0004\b$\u0010 \u001a\u0004\b!\u00104¨\u00066"}, d2 = {"Lcom/moloco/sdk/internal/ortb/model/z;", "", "Lkotlin/UInt;", "delaySeconds", "padding", "controlSize", "Lcom/moloco/sdk/internal/ortb/model/r;", "horizontalAlignment", "Lcom/moloco/sdk/internal/ortb/model/B;", "verticalAlignment", "Landroidx/compose/ui/graphics/Color;", "foregroundColor", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "<init>", "(IIILcom/moloco/sdk/internal/ortb/model/r;Lcom/moloco/sdk/internal/ortb/model/B;JLandroidx/compose/ui/graphics/Color;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILkotlin/UInt;Lkotlin/UInt;Lkotlin/UInt;Lcom/moloco/sdk/internal/ortb/model/r;Lcom/moloco/sdk/internal/ortb/model/B;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Lkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "a", "(Lcom/moloco/sdk/internal/ortb/model/z;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "I", InneractiveMediationDefs.GENDER_FEMALE, "()I", "g", "()V", "b", "l", InneractiveMediationDefs.GENDER_MALE, "c", "d", "e", "Lcom/moloco/sdk/internal/ortb/model/r;", "j", "()Lcom/moloco/sdk/internal/ortb/model/r;", "k", "Lcom/moloco/sdk/internal/ortb/model/B;", "n", "()Lcom/moloco/sdk/internal/ortb/model/B;", "o", "J", "h", "()J", "i", "Landroidx/compose/ui/graphics/Color;", "()Landroidx/compose/ui/graphics/Color;", com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.M, "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
@Serializable
public final class z {
    public static final int h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int delaySeconds;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final int padding;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final int controlSize;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final r horizontalAlignment;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final B verticalAlignment;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final long foregroundColor;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final Color backgroundColor;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final KSerializer<Object>[] i = {null, null, null, r.INSTANCE.serializer(), B.INSTANCE.serializer(), null, null};

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2151a;
        public static final int b;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            f2151a = aVar;
            b = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.SkipClose", aVar, 7);
            pluginGeneratedSerialDescriptor.addElement("delay_seconds", false);
            pluginGeneratedSerialDescriptor.addElement("padding", false);
            pluginGeneratedSerialDescriptor.addElement("control_size", false);
            pluginGeneratedSerialDescriptor.addElement(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT, false);
            pluginGeneratedSerialDescriptor.addElement("vertical_alignment", false);
            pluginGeneratedSerialDescriptor.addElement("foreground_color", false);
            pluginGeneratedSerialDescriptor.addElement("background_color", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final z deserialize(Decoder decoder) {
            int i;
            Color color;
            UInt uInt;
            UInt uInt2;
            B b2;
            Color color2;
            UInt uInt3;
            r rVar;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            KSerializer[] kSerializerArr = z.i;
            int i2 = 6;
            UInt uInt4 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                UIntSerializer uIntSerializer = UIntSerializer.INSTANCE;
                UInt uInt5 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, uIntSerializer, null);
                UInt uInt6 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, uIntSerializer, null);
                UInt uInt7 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, uIntSerializer, null);
                r rVar2 = (r) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, kSerializerArr[3], null);
                B b3 = (B) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
                h hVar = h.f2116a;
                Color color3 = (Color) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 5, hVar, null);
                b2 = b3;
                uInt2 = uInt7;
                color = (Color) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, hVar, null);
                color2 = color3;
                rVar = rVar2;
                i = 127;
                uInt3 = uInt6;
                uInt = uInt5;
            } else {
                boolean z = true;
                int i3 = 0;
                Color color4 = null;
                Color color5 = null;
                UInt uInt8 = null;
                UInt uInt9 = null;
                r rVar3 = null;
                B b4 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z = false;
                            i2 = 6;
                            break;
                        case 0:
                            uInt4 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, UIntSerializer.INSTANCE, uInt4);
                            i3 |= 1;
                            i2 = 6;
                            break;
                        case 1:
                            uInt8 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, UIntSerializer.INSTANCE, uInt8);
                            i3 |= 2;
                            i2 = 6;
                            break;
                        case 2:
                            uInt9 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, UIntSerializer.INSTANCE, uInt9);
                            i3 |= 4;
                            i2 = 6;
                            break;
                        case 3:
                            rVar3 = (r) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, kSerializerArr[3], rVar3);
                            i3 |= 8;
                            break;
                        case 4:
                            b4 = (B) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], b4);
                            i3 |= 16;
                            break;
                        case 5:
                            color5 = (Color) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 5, h.f2116a, color5);
                            i3 |= 32;
                            break;
                        case 6:
                            color4 = (Color) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, h.f2116a, color4);
                            i3 |= 64;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                i = i3;
                B b5 = b4;
                color = color4;
                uInt = uInt4;
                uInt2 = uInt9;
                b2 = b5;
                r rVar4 = rVar3;
                color2 = color5;
                uInt3 = uInt8;
                rVar = rVar4;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new z(i, uInt, uInt3, uInt2, rVar, b2, color2, color, null, null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            KSerializer<?>[] kSerializerArr = z.i;
            KSerializer<?> kSerializer = kSerializerArr[3];
            KSerializer<?> kSerializer2 = kSerializerArr[4];
            h hVar = h.f2116a;
            KSerializer<?> nullable = BuiltinSerializersKt.getNullable(hVar);
            UIntSerializer uIntSerializer = UIntSerializer.INSTANCE;
            return new KSerializer[]{uIntSerializer, uIntSerializer, uIntSerializer, kSerializer, kSerializer2, hVar, nullable};
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
        public final void serialize(Encoder encoder, z value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            z.a(value, compositeEncoderBeginStructure, serialDescriptor);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.ortb.model.z$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<z> serializer() {
            return a.f2151a;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ z(int i2, int i3, int i4, r rVar, B b, long j, Color color, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, i3, i4, rVar, b, j, color);
    }

    @SerialName("background_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void c() {
    }

    @SerialName("control_size")
    public static /* synthetic */ void e() {
    }

    @SerialName("delay_seconds")
    public static /* synthetic */ void g() {
    }

    @SerialName("foreground_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void i() {
    }

    @SerialName(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT)
    public static /* synthetic */ void k() {
    }

    @SerialName("padding")
    public static /* synthetic */ void m() {
    }

    @SerialName("vertical_alignment")
    public static /* synthetic */ void o() {
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Color getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getControlSize() {
        return this.controlSize;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getDelaySeconds() {
        return this.delaySeconds;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final long getForegroundColor() {
        return this.foregroundColor;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final r getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final int getPadding() {
        return this.padding;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final B getVerticalAlignment() {
        return this.verticalAlignment;
    }

    public /* synthetic */ z(int i2, UInt uInt, UInt uInt2, UInt uInt3, r rVar, B b, Color color, Color color2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, uInt, uInt2, uInt3, rVar, b, color, color2, serializationConstructorMarker);
    }

    @JvmStatic
    public static final /* synthetic */ void a(z self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = i;
        UIntSerializer uIntSerializer = UIntSerializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 0, uIntSerializer, UInt.m7508boximpl(self.delaySeconds));
        output.encodeSerializableElement(serialDesc, 1, uIntSerializer, UInt.m7508boximpl(self.padding));
        output.encodeSerializableElement(serialDesc, 2, uIntSerializer, UInt.m7508boximpl(self.controlSize));
        output.encodeSerializableElement(serialDesc, 3, kSerializerArr[3], self.horizontalAlignment);
        output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.verticalAlignment);
        h hVar = h.f2116a;
        output.encodeSerializableElement(serialDesc, 5, hVar, Color.m1635boximpl(self.foregroundColor));
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && self.backgroundColor == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 6, hVar, self.backgroundColor);
    }

    public /* synthetic */ z(int i2, UInt uInt, UInt uInt2, UInt uInt3, r rVar, B b, Color color, Color color2, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i2 & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i2, 63, a.f2151a.getDescriptor());
        }
        this.delaySeconds = uInt.getData();
        this.padding = uInt2.getData();
        this.controlSize = uInt3.getData();
        this.horizontalAlignment = rVar;
        this.verticalAlignment = b;
        this.foregroundColor = color.m1655unboximpl();
        if ((i2 & 64) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = color2;
        }
    }

    public z(int i2, int i3, int i4, r horizontalAlignment, B verticalAlignment, long j, Color color) {
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
        this.delaySeconds = i2;
        this.padding = i3;
        this.controlSize = i4;
        this.horizontalAlignment = horizontalAlignment;
        this.verticalAlignment = verticalAlignment;
        this.foregroundColor = j;
        this.backgroundColor = color;
    }

    public /* synthetic */ z(int i2, int i3, int i4, r rVar, B b, long j, Color color, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, i3, i4, rVar, b, j, (i5 & 64) != 0 ? null : color, null);
    }
}
