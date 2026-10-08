package com.moloco.sdk.internal.ortb.model;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.internal.UIntSerializer;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b#\b\u0001\u0018\u0000 >2\u00020\u0001:\u0002\u001d$B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012Bi\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0011\u0010\u0016J'\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001d\u0010\u001f\u0012\u0004\b\"\u0010#\u001a\u0004\b \u0010!R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b$\u0010%\u0012\u0004\b(\u0010#\u001a\u0004\b&\u0010'R \u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b)\u0010*\u0012\u0004\b-\u0010#\u001a\u0004\b+\u0010,R\"\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b+\u0010.\u0012\u0004\b1\u0010#\u001a\u0004\b/\u00100R \u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b-\u00102\u0012\u0004\b5\u0010#\u001a\u0004\b3\u00104R \u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b \u00106\u0012\u0004\b9\u0010#\u001a\u0004\b7\u00108R \u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\"\u0010:\u0012\u0004\b=\u0010#\u001a\u0004\b;\u0010<R \u0010\u0010\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b;\u0010:\u0012\u0004\b)\u0010#\u001a\u0004\b$\u0010<¨\u0006?"}, d2 = {"Lcom/moloco/sdk/internal/ortb/model/i;", "", "", "customTimerDesc", "", "isDefaultTimer", "Lkotlin/UInt;", "circleSize", "", "padding", "Lcom/moloco/sdk/internal/ortb/model/r;", "horizontalAlignment", "Lcom/moloco/sdk/internal/ortb/model/B;", "verticalAlignment", "Landroidx/compose/ui/graphics/Color;", "foregroundColor", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "<init>", "(Ljava/lang/String;ZILjava/lang/Integer;Lcom/moloco/sdk/internal/ortb/model/r;Lcom/moloco/sdk/internal/ortb/model/B;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;ZLkotlin/UInt;Ljava/lang/Integer;Lcom/moloco/sdk/internal/ortb/model/r;Lcom/moloco/sdk/internal/ortb/model/B;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Lkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "a", "(Lcom/moloco/sdk/internal/ortb/model/i;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "Ljava/lang/String;", InneractiveMediationDefs.GENDER_FEMALE, "()Ljava/lang/String;", "g", "()V", "b", "Z", TtmlNode.TAG_P, "()Z", "q", "c", "I", "d", "()I", "e", "Ljava/lang/Integer;", "l", "()Ljava/lang/Integer;", InneractiveMediationDefs.GENDER_MALE, "Lcom/moloco/sdk/internal/ortb/model/r;", "j", "()Lcom/moloco/sdk/internal/ortb/model/r;", "k", "Lcom/moloco/sdk/internal/ortb/model/B;", "n", "()Lcom/moloco/sdk/internal/ortb/model/B;", "o", "J", "h", "()J", "i", com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.M, "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
@Serializable
public final class i {
    public static final int i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String customTimerDesc;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final boolean isDefaultTimer;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final int circleSize;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Integer padding;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final r horizontalAlignment;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final B verticalAlignment;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final long foregroundColor;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final long backgroundColor;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final KSerializer<Object>[] j = {null, null, null, null, r.INSTANCE.serializer(), B.INSTANCE.serializer(), null, null};

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2118a;
        public static final int b;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            f2118a = aVar;
            b = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.CountDownTimer", aVar, 8);
            pluginGeneratedSerialDescriptor.addElement("custom_timer_desc", true);
            pluginGeneratedSerialDescriptor.addElement("is_default_timer", true);
            pluginGeneratedSerialDescriptor.addElement("control_size", true);
            pluginGeneratedSerialDescriptor.addElement("padding", true);
            pluginGeneratedSerialDescriptor.addElement(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT, true);
            pluginGeneratedSerialDescriptor.addElement("vertical_alignment", true);
            pluginGeneratedSerialDescriptor.addElement("foreground_color", true);
            pluginGeneratedSerialDescriptor.addElement("background_color", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i deserialize(Decoder decoder) {
            UInt uInt;
            Integer num;
            Color color;
            Color color2;
            B b2;
            r rVar;
            int i;
            boolean z;
            String str;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            KSerializer[] kSerializerArr = i.j;
            int i2 = 7;
            int i3 = 6;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                String str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, null);
                boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 1);
                UInt uInt2 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, UIntSerializer.INSTANCE, null);
                Integer num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, null);
                r rVar2 = (r) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
                B b3 = (B) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], null);
                h hVar = h.f2116a;
                Color color3 = (Color) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 6, hVar, null);
                b2 = b3;
                str = str2;
                color = (Color) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 7, hVar, null);
                color2 = color3;
                num = num2;
                uInt = uInt2;
                i = 255;
                rVar = rVar2;
                z = zDecodeBooleanElement;
            } else {
                boolean z2 = true;
                int i4 = 0;
                Color color4 = null;
                Color color5 = null;
                B b4 = null;
                String str3 = null;
                uInt = null;
                num = null;
                r rVar3 = null;
                boolean zDecodeBooleanElement2 = false;
                while (z2) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z2 = false;
                            i3 = 6;
                            break;
                        case 0:
                            str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str3);
                            i4 |= 1;
                            i2 = 7;
                            i3 = 6;
                            break;
                        case 1:
                            zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 1);
                            i4 |= 2;
                            i2 = 7;
                            i3 = 6;
                            break;
                        case 2:
                            uInt = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, UIntSerializer.INSTANCE, uInt);
                            i4 |= 4;
                            i2 = 7;
                            i3 = 6;
                            break;
                        case 3:
                            num = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, num);
                            i4 |= 8;
                            i2 = 7;
                            i3 = 6;
                            break;
                        case 4:
                            rVar3 = (r) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], rVar3);
                            i4 |= 16;
                            i2 = 7;
                            break;
                        case 5:
                            b4 = (B) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], b4);
                            i4 |= 32;
                            break;
                        case 6:
                            color5 = (Color) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i3, h.f2116a, color5);
                            i4 |= 64;
                            break;
                        case 7:
                            color4 = (Color) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i2, h.f2116a, color4);
                            i4 |= 128;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                color = color4;
                color2 = color5;
                b2 = b4;
                rVar = rVar3;
                i = i4;
                String str4 = str3;
                z = zDecodeBooleanElement2;
                str = str4;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new i(i, str, z, uInt, num, rVar, b2, color2, color, null, null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            KSerializer<?>[] kSerializerArr = i.j;
            KSerializer<?> nullable = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE);
            KSerializer<?> kSerializer = kSerializerArr[4];
            KSerializer<?> kSerializer2 = kSerializerArr[5];
            h hVar = h.f2116a;
            return new KSerializer[]{nullable, BooleanSerializer.INSTANCE, UIntSerializer.INSTANCE, nullable2, kSerializer, kSerializer2, hVar, hVar};
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
        public final void serialize(Encoder encoder, i value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            i.a(value, compositeEncoderBeginStructure, serialDescriptor);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.ortb.model.i$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<i> serializer() {
            return a.f2118a;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ i(int i2, String str, boolean z, UInt uInt, Integer num, r rVar, B b, Color color, Color color2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, str, z, uInt, num, rVar, b, color, color2, serializationConstructorMarker);
    }

    @SerialName("background_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void c() {
    }

    @SerialName("control_size")
    public static /* synthetic */ void e() {
    }

    @SerialName("custom_timer_desc")
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

    @SerialName("is_default_timer")
    public static /* synthetic */ void q() {
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getCircleSize() {
        return this.circleSize;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getCustomTimerDesc() {
        return this.customTimerDesc;
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
    public final Integer getPadding() {
        return this.padding;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final B getVerticalAlignment() {
        return this.verticalAlignment;
    }

    /* JADX INFO: renamed from: p, reason: from getter */
    public final boolean getIsDefaultTimer() {
        return this.isDefaultTimer;
    }

    public /* synthetic */ i(String str, boolean z, int i2, Integer num, r rVar, B b, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, i2, num, rVar, b, j2, j3);
    }

    @JvmStatic
    public static final /* synthetic */ void a(i self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = j;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.customTimerDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.customTimerDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !self.isDefaultTimer) {
            output.encodeBooleanElement(serialDesc, 1, self.isDefaultTimer);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.circleSize != 30) {
            output.encodeSerializableElement(serialDesc, 2, UIntSerializer.INSTANCE, UInt.m7508boximpl(self.circleSize));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.padding != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.padding);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.horizontalAlignment != r.f) {
            output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.horizontalAlignment);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.verticalAlignment != B.b) {
            output.encodeSerializableElement(serialDesc, 5, kSerializerArr[5], self.verticalAlignment);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Color.m1646equalsimpl0(self.foregroundColor, ColorKt.Color(android.graphics.Color.parseColor("#FF4285f4")))) {
            output.encodeSerializableElement(serialDesc, 6, h.f2116a, Color.m1635boximpl(self.foregroundColor));
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 7) && Color.m1646equalsimpl0(self.backgroundColor, ColorKt.Color(android.graphics.Color.parseColor("#FFFFFFFF")))) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 7, h.f2116a, Color.m1635boximpl(self.backgroundColor));
    }

    public /* synthetic */ i(int i2, String str, boolean z, UInt uInt, Integer num, r rVar, B b, Color color, Color color2, SerializationConstructorMarker serializationConstructorMarker) {
        long jM1655unboximpl;
        long jM1655unboximpl2;
        if ((i2 & 1) == 0) {
            this.customTimerDesc = null;
        } else {
            this.customTimerDesc = str;
        }
        if ((i2 & 2) == 0) {
            this.isDefaultTimer = true;
        } else {
            this.isDefaultTimer = z;
        }
        this.circleSize = (i2 & 4) == 0 ? 30 : uInt.getData();
        if ((i2 & 8) == 0) {
            this.padding = null;
        } else {
            this.padding = num;
        }
        if ((i2 & 16) == 0) {
            this.horizontalAlignment = r.f;
        } else {
            this.horizontalAlignment = rVar;
        }
        if ((i2 & 32) == 0) {
            this.verticalAlignment = B.b;
        } else {
            this.verticalAlignment = b;
        }
        if ((i2 & 64) == 0) {
            jM1655unboximpl = ColorKt.Color(android.graphics.Color.parseColor("#FF4285f4"));
        } else {
            jM1655unboximpl = color.m1655unboximpl();
        }
        this.foregroundColor = jM1655unboximpl;
        if ((i2 & 128) == 0) {
            jM1655unboximpl2 = ColorKt.Color(android.graphics.Color.parseColor("#FFFFFFFF"));
        } else {
            jM1655unboximpl2 = color2.m1655unboximpl();
        }
        this.backgroundColor = jM1655unboximpl2;
    }

    public i(String str, boolean z, int i2, Integer num, r horizontalAlignment, B verticalAlignment, long j2, long j3) {
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
        this.customTimerDesc = str;
        this.isDefaultTimer = z;
        this.circleSize = i2;
        this.padding = num;
        this.horizontalAlignment = horizontalAlignment;
        this.verticalAlignment = verticalAlignment;
        this.foregroundColor = j2;
        this.backgroundColor = j3;
    }

    public /* synthetic */ i(String str, boolean z, int i2, Integer num, r rVar, B b, long j2, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? true : z, (i3 & 4) != 0 ? 30 : i2, (i3 & 8) == 0 ? num : null, (i3 & 16) != 0 ? r.f : rVar, (i3 & 32) != 0 ? B.b : b, (i3 & 64) != 0 ? ColorKt.Color(android.graphics.Color.parseColor("#FF4285f4")) : j2, (i3 & 128) != 0 ? ColorKt.Color(android.graphics.Color.parseColor("#FFFFFFFF")) : j3, null);
    }
}
