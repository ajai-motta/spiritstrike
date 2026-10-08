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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.UIntSerializer;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b!\b\u0001\u0018\u0000 :2\u00020\u0001:\u0002\u001b\"BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000e\u0010\u000fB_\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0014J'\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001b\u0010\u001cR \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001b\u0010\u001d\u0012\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\"\u0010#\u0012\u0004\b&\u0010!\u001a\u0004\b$\u0010%R \u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b'\u0010(\u0012\u0004\b+\u0010!\u001a\u0004\b)\u0010*R \u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b,\u0010-\u0012\u0004\b0\u0010!\u001a\u0004\b.\u0010/R \u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b1\u00102\u0012\u0004\b5\u0010!\u001a\u0004\b3\u00104R\"\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b3\u00106\u0012\u0004\b1\u0010!\u001a\u0004\b,\u00107R\"\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b5\u00108\u0012\u0004\b'\u0010!\u001a\u0004\b\"\u00109¨\u0006;"}, d2 = {"Lcom/moloco/sdk/internal/ortb/model/u;", "", "", "mute", "Lkotlin/UInt;", "padding", "Lcom/moloco/sdk/internal/ortb/model/r;", "horizontalAlignment", "Lcom/moloco/sdk/internal/ortb/model/B;", "verticalAlignment", "Landroidx/compose/ui/graphics/Color;", "foregroundColor", "controlSize", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "<init>", "(ZILcom/moloco/sdk/internal/ortb/model/r;Lcom/moloco/sdk/internal/ortb/model/B;JLkotlin/UInt;Landroidx/compose/ui/graphics/Color;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IZLkotlin/UInt;Lcom/moloco/sdk/internal/ortb/model/r;Lcom/moloco/sdk/internal/ortb/model/B;Landroidx/compose/ui/graphics/Color;Lkotlin/UInt;Landroidx/compose/ui/graphics/Color;Lkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "a", "(Lcom/moloco/sdk/internal/ortb/model/u;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "Z", "j", "()Z", "k", "()V", "b", "I", "l", "()I", InneractiveMediationDefs.GENDER_MALE, "c", "Lcom/moloco/sdk/internal/ortb/model/r;", "h", "()Lcom/moloco/sdk/internal/ortb/model/r;", "i", "d", "Lcom/moloco/sdk/internal/ortb/model/B;", "n", "()Lcom/moloco/sdk/internal/ortb/model/B;", "o", "e", "J", InneractiveMediationDefs.GENDER_FEMALE, "()J", "g", "Lkotlin/UInt;", "()Lkotlin/UInt;", "Landroidx/compose/ui/graphics/Color;", "()Landroidx/compose/ui/graphics/Color;", com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.M, "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
@Serializable
public final class u {
    public static final int h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final boolean mute;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final int padding;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final r horizontalAlignment;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final B verticalAlignment;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final long foregroundColor;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final UInt controlSize;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final Color backgroundColor;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final KSerializer<Object>[] i = {null, null, r.INSTANCE.serializer(), B.INSTANCE.serializer(), null, null, null};

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<u> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2141a;
        public static final int b;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            f2141a = aVar;
            b = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.Mute", aVar, 7);
            pluginGeneratedSerialDescriptor.addElement("mute", false);
            pluginGeneratedSerialDescriptor.addElement("padding", false);
            pluginGeneratedSerialDescriptor.addElement(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT, false);
            pluginGeneratedSerialDescriptor.addElement("vertical_alignment", false);
            pluginGeneratedSerialDescriptor.addElement("foreground_color", false);
            pluginGeneratedSerialDescriptor.addElement("control_size", true);
            pluginGeneratedSerialDescriptor.addElement("background_color", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final u deserialize(Decoder decoder) {
            UInt uInt;
            r rVar;
            B b2;
            Color color;
            Color color2;
            UInt uInt2;
            int i;
            boolean z;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            KSerializer[] kSerializerArr = u.i;
            int i2 = 6;
            int i3 = 5;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 0);
                UIntSerializer uIntSerializer = UIntSerializer.INSTANCE;
                UInt uInt3 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, uIntSerializer, null);
                r rVar2 = (r) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], null);
                B b3 = (B) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, kSerializerArr[3], null);
                h hVar = h.f2116a;
                Color color3 = (Color) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, hVar, null);
                UInt uInt4 = (UInt) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, uIntSerializer, null);
                b2 = b3;
                z = zDecodeBooleanElement;
                color2 = (Color) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, hVar, null);
                uInt2 = uInt4;
                color = color3;
                i = 127;
                rVar = rVar2;
                uInt = uInt3;
            } else {
                boolean z2 = true;
                boolean zDecodeBooleanElement2 = false;
                Color color4 = null;
                uInt = null;
                rVar = null;
                b2 = null;
                color = null;
                UInt uInt5 = null;
                int i4 = 0;
                while (z2) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z2 = false;
                            i2 = 6;
                            break;
                        case 0:
                            zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 0);
                            i4 |= 1;
                            i2 = 6;
                            i3 = 5;
                            break;
                        case 1:
                            uInt = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, UIntSerializer.INSTANCE, uInt);
                            i4 |= 2;
                            i2 = 6;
                            i3 = 5;
                            break;
                        case 2:
                            rVar = (r) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], rVar);
                            i4 |= 4;
                            i2 = 6;
                            break;
                        case 3:
                            b2 = (B) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, kSerializerArr[3], b2);
                            i4 |= 8;
                            break;
                        case 4:
                            color = (Color) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, h.f2116a, color);
                            i4 |= 16;
                            break;
                        case 5:
                            uInt5 = (UInt) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, UIntSerializer.INSTANCE, uInt5);
                            i4 |= 32;
                            break;
                        case 6:
                            color4 = (Color) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, h.f2116a, color4);
                            i4 |= 64;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                color2 = color4;
                uInt2 = uInt5;
                i = i4;
                z = zDecodeBooleanElement2;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new u(i, z, uInt, rVar, b2, color, uInt2, color2, null, null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            KSerializer<?>[] kSerializerArr = u.i;
            UIntSerializer uIntSerializer = UIntSerializer.INSTANCE;
            KSerializer<?> kSerializer = kSerializerArr[2];
            KSerializer<?> kSerializer2 = kSerializerArr[3];
            h hVar = h.f2116a;
            return new KSerializer[]{BooleanSerializer.INSTANCE, uIntSerializer, kSerializer, kSerializer2, hVar, BuiltinSerializersKt.getNullable(uIntSerializer), BuiltinSerializersKt.getNullable(hVar)};
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
        public final void serialize(Encoder encoder, u value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            u.a(value, compositeEncoderBeginStructure, serialDescriptor);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.ortb.model.u$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<u> serializer() {
            return a.f2141a;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ u(int i2, boolean z, UInt uInt, r rVar, B b, Color color, UInt uInt2, Color color2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, z, uInt, rVar, b, color, uInt2, color2, serializationConstructorMarker);
    }

    @SerialName("background_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void c() {
    }

    @SerialName("control_size")
    public static /* synthetic */ void e() {
    }

    @SerialName("foreground_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void g() {
    }

    @SerialName(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT)
    public static /* synthetic */ void i() {
    }

    @SerialName("mute")
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
    public final UInt getControlSize() {
        return this.controlSize;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final long getForegroundColor() {
        return this.foregroundColor;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final r getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final boolean getMute() {
        return this.mute;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final int getPadding() {
        return this.padding;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final B getVerticalAlignment() {
        return this.verticalAlignment;
    }

    public /* synthetic */ u(boolean z, int i2, r rVar, B b, long j, UInt uInt, Color color, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i2, rVar, b, j, uInt, color);
    }

    @JvmStatic
    public static final /* synthetic */ void a(u self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = i;
        output.encodeBooleanElement(serialDesc, 0, self.mute);
        UIntSerializer uIntSerializer = UIntSerializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 1, uIntSerializer, UInt.m7508boximpl(self.padding));
        output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.horizontalAlignment);
        output.encodeSerializableElement(serialDesc, 3, kSerializerArr[3], self.verticalAlignment);
        h hVar = h.f2116a;
        output.encodeSerializableElement(serialDesc, 4, hVar, Color.m1635boximpl(self.foregroundColor));
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.controlSize != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, uIntSerializer, self.controlSize);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && self.backgroundColor == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 6, hVar, self.backgroundColor);
    }

    public /* synthetic */ u(int i2, boolean z, UInt uInt, r rVar, B b, Color color, UInt uInt2, Color color2, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i2 & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i2, 31, a.f2141a.getDescriptor());
        }
        this.mute = z;
        this.padding = uInt.getData();
        this.horizontalAlignment = rVar;
        this.verticalAlignment = b;
        this.foregroundColor = color.m1655unboximpl();
        if ((i2 & 32) == 0) {
            this.controlSize = null;
        } else {
            this.controlSize = uInt2;
        }
        if ((i2 & 64) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = color2;
        }
    }

    public u(boolean z, int i2, r horizontalAlignment, B verticalAlignment, long j, UInt uInt, Color color) {
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
        this.mute = z;
        this.padding = i2;
        this.horizontalAlignment = horizontalAlignment;
        this.verticalAlignment = verticalAlignment;
        this.foregroundColor = j;
        this.controlSize = uInt;
        this.backgroundColor = color;
    }

    public /* synthetic */ u(boolean z, int i2, r rVar, B b, long j, UInt uInt, Color color, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i2, rVar, b, j, (i3 & 32) != 0 ? null : uInt, (i3 & 64) != 0 ? null : color, null);
    }
}
