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
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.internal.UIntSerializer;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001f\b\u0001\u0018\u0000 82\u00020\u0001:\u0002\u001b\"BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fBa\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0014J'\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001b\u0010\u001cR \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001b\u0010\u001d\u0012\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u0012\u0004\b$\u0010!\u001a\u0004\b#\u0010\u001fR \u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b%\u0010&\u0012\u0004\b)\u0010!\u001a\u0004\b'\u0010(R \u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b*\u0010+\u0012\u0004\b.\u0010!\u001a\u0004\b,\u0010-R \u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b/\u00100\u0012\u0004\b3\u0010!\u001a\u0004\b1\u00102R \u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b,\u00104\u0012\u0004\b/\u0010!\u001a\u0004\b*\u00105R\"\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b.\u00106\u0012\u0004\b%\u0010!\u001a\u0004\b\"\u00107¨\u00069"}, d2 = {"Lcom/moloco/sdk/internal/ortb/model/g;", "", "", "text", "imageUrl", "Lkotlin/UInt;", "padding", "Lcom/moloco/sdk/internal/ortb/model/r;", "horizontalAlignment", "Lcom/moloco/sdk/internal/ortb/model/B;", "verticalAlignment", "Landroidx/compose/ui/graphics/Color;", "foregroundColor", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/moloco/sdk/internal/ortb/model/r;Lcom/moloco/sdk/internal/ortb/model/B;JLandroidx/compose/ui/graphics/Color;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/UInt;Lcom/moloco/sdk/internal/ortb/model/r;Lcom/moloco/sdk/internal/ortb/model/B;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Lkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "a", "(Lcom/moloco/sdk/internal/ortb/model/g;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "Ljava/lang/String;", "l", "()Ljava/lang/String;", InneractiveMediationDefs.GENDER_MALE, "()V", "b", "h", "i", "c", "I", "j", "()I", "k", "d", "Lcom/moloco/sdk/internal/ortb/model/r;", InneractiveMediationDefs.GENDER_FEMALE, "()Lcom/moloco/sdk/internal/ortb/model/r;", "g", "e", "Lcom/moloco/sdk/internal/ortb/model/B;", "n", "()Lcom/moloco/sdk/internal/ortb/model/B;", "o", "J", "()J", "Landroidx/compose/ui/graphics/Color;", "()Landroidx/compose/ui/graphics/Color;", com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.M, "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
@Serializable
public final class g {
    public static final int h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String text;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String imageUrl;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final int padding;

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
    public /* synthetic */ class a implements GeneratedSerializer<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2115a;
        public static final int b;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            f2115a = aVar;
            b = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.CTA", aVar, 7);
            pluginGeneratedSerialDescriptor.addElement("text", false);
            pluginGeneratedSerialDescriptor.addElement("image_url", true);
            pluginGeneratedSerialDescriptor.addElement("padding", false);
            pluginGeneratedSerialDescriptor.addElement(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT, false);
            pluginGeneratedSerialDescriptor.addElement("vertical_alignment", false);
            pluginGeneratedSerialDescriptor.addElement("foreground_color", false);
            pluginGeneratedSerialDescriptor.addElement("background_color", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g deserialize(Decoder decoder) {
            int i;
            Color color;
            String str;
            UInt uInt;
            B b2;
            Color color2;
            String str2;
            r rVar;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            KSerializer[] kSerializerArr = g.i;
            int i2 = 6;
            String strDecodeStringElement = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                String str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
                UInt uInt2 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, UIntSerializer.INSTANCE, null);
                r rVar2 = (r) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, kSerializerArr[3], null);
                B b3 = (B) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
                h hVar = h.f2116a;
                Color color3 = (Color) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 5, hVar, null);
                Color color4 = (Color) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, hVar, null);
                i = 127;
                b2 = b3;
                color = color4;
                color2 = color3;
                uInt = uInt2;
                rVar = rVar2;
                str2 = str3;
                str = strDecodeStringElement2;
            } else {
                boolean z = true;
                int i3 = 0;
                Color color5 = null;
                Color color6 = null;
                String str4 = null;
                UInt uInt3 = null;
                r rVar3 = null;
                B b4 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z = false;
                            break;
                        case 0:
                            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                            i3 |= 1;
                            i2 = 6;
                            break;
                        case 1:
                            str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str4);
                            i3 |= 2;
                            i2 = 6;
                            break;
                        case 2:
                            uInt3 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, UIntSerializer.INSTANCE, uInt3);
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
                            color6 = (Color) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 5, h.f2116a, color6);
                            i3 |= 32;
                            break;
                        case 6:
                            color5 = (Color) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, h.f2116a, color5);
                            i3 |= 64;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                i = i3;
                B b5 = b4;
                color = color5;
                str = strDecodeStringElement;
                uInt = uInt3;
                b2 = b5;
                r rVar4 = rVar3;
                color2 = color6;
                str2 = str4;
                rVar = rVar4;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new g(i, str, str2, uInt, rVar, b2, color2, color, null, null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            KSerializer<?>[] kSerializerArr = g.i;
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            KSerializer<?> nullable = BuiltinSerializersKt.getNullable(stringSerializer);
            KSerializer<?> kSerializer = kSerializerArr[3];
            KSerializer<?> kSerializer2 = kSerializerArr[4];
            h hVar = h.f2116a;
            return new KSerializer[]{stringSerializer, nullable, UIntSerializer.INSTANCE, kSerializer, kSerializer2, hVar, BuiltinSerializersKt.getNullable(hVar)};
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
        public final void serialize(Encoder encoder, g value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            g.a(value, compositeEncoderBeginStructure, serialDescriptor);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.ortb.model.g$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<g> serializer() {
            return a.f2115a;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ g(int i2, String str, String str2, UInt uInt, r rVar, B b, Color color, Color color2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, str, str2, uInt, rVar, b, color, color2, serializationConstructorMarker);
    }

    @SerialName("background_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void c() {
    }

    @SerialName("foreground_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void e() {
    }

    @SerialName(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT)
    public static /* synthetic */ void g() {
    }

    @SerialName("image_url")
    public static /* synthetic */ void i() {
    }

    @SerialName("padding")
    public static /* synthetic */ void k() {
    }

    @SerialName("text")
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
    public final long getForegroundColor() {
        return this.foregroundColor;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final r getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final int getPadding() {
        return this.padding;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final B getVerticalAlignment() {
        return this.verticalAlignment;
    }

    public /* synthetic */ g(String str, String str2, int i2, r rVar, B b, long j, Color color, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i2, rVar, b, j, color);
    }

    @JvmStatic
    public static final /* synthetic */ void a(g self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = i;
        output.encodeStringElement(serialDesc, 0, self.text);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.imageUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.imageUrl);
        }
        output.encodeSerializableElement(serialDesc, 2, UIntSerializer.INSTANCE, UInt.m7508boximpl(self.padding));
        output.encodeSerializableElement(serialDesc, 3, kSerializerArr[3], self.horizontalAlignment);
        output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.verticalAlignment);
        h hVar = h.f2116a;
        output.encodeSerializableElement(serialDesc, 5, hVar, Color.m1635boximpl(self.foregroundColor));
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && self.backgroundColor == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 6, hVar, self.backgroundColor);
    }

    public /* synthetic */ g(int i2, String str, String str2, UInt uInt, r rVar, B b, Color color, Color color2, SerializationConstructorMarker serializationConstructorMarker) {
        if (61 != (i2 & 61)) {
            PluginExceptionsKt.throwMissingFieldException(i2, 61, a.f2115a.getDescriptor());
        }
        this.text = str;
        if ((i2 & 2) == 0) {
            this.imageUrl = null;
        } else {
            this.imageUrl = str2;
        }
        this.padding = uInt.getData();
        this.horizontalAlignment = rVar;
        this.verticalAlignment = b;
        this.foregroundColor = color.m1655unboximpl();
        if ((i2 & 64) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = color2;
        }
    }

    public g(String text, String str, int i2, r horizontalAlignment, B verticalAlignment, long j, Color color) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
        this.text = text;
        this.imageUrl = str;
        this.padding = i2;
        this.horizontalAlignment = horizontalAlignment;
        this.verticalAlignment = verticalAlignment;
        this.foregroundColor = j;
        this.backgroundColor = color;
    }

    public /* synthetic */ g(String str, String str2, int i2, r rVar, B b, long j, Color color, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : str2, i2, rVar, b, j, (i3 & 64) != 0 ? null : color, null);
    }
}
