package com.moloco.sdk.internal.ortb.model;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import io.ktor.http.ContentDisposition;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
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
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0081\b\u0018\u0000 52\u00020\u0001:\u0002\u0016\u0019BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\n\u0010\u000fJ'\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJL\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÇ\u0001¢\u0006\u0004\b\u0016\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004H×\u0001¢\u0006\u0004\b \u0010\u001aJ\u0010\u0010!\u001a\u00020\u0007H×\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\u0001H×\u0003¢\u0006\u0004\b%\u0010&R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010'\u0012\u0004\b)\u0010*\u001a\u0004\b(\u0010\u0018R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0019\u0010+\u0012\u0004\b-\u0010*\u001a\u0004\b,\u0010\u001aR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001b\u0010+\u0012\u0004\b/\u0010*\u001a\u0004\b.\u0010\u001aR\"\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001c\u00100\u0012\u0004\b2\u0010*\u001a\u0004\b1\u0010\u001dR\"\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001e\u00100\u0012\u0004\b4\u0010*\u001a\u0004\b3\u0010\u001d¨\u00066"}, d2 = {"Lcom/moloco/sdk/internal/ortb/model/o;", "", "", "ratingValue", "", "foregroundColor", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "", ContentDisposition.Parameters.Size, TtmlNode.ATTR_TTS_FONT_SIZE, "<init>", "(Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "a", "(Lcom/moloco/sdk/internal/ortb/model/o;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "()Ljava/lang/Float;", "b", "()Ljava/lang/String;", "c", "d", "()Ljava/lang/Integer;", "e", "(Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/moloco/sdk/internal/ortb/model/o;", InAppPurchaseConstants.METHOD_TO_STRING, "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Float;", "l", InneractiveMediationDefs.GENDER_MALE, "()V", "Ljava/lang/String;", "j", "k", InneractiveMediationDefs.GENDER_FEMALE, "g", "Ljava/lang/Integer;", "n", "o", "h", "i", com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.M, "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
@Serializable
public final /* data */ class o {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Float ratingValue;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String foregroundColor;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String backgroundColor;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Integer size;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Integer fontSize;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<o> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2130a;
        public static final int b;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            f2130a = aVar;
            b = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.DECRatingSerializable", aVar, 5);
            pluginGeneratedSerialDescriptor.addElement("rating_value", true);
            pluginGeneratedSerialDescriptor.addElement("foreground_color", true);
            pluginGeneratedSerialDescriptor.addElement("background_color", true);
            pluginGeneratedSerialDescriptor.addElement("rating_size", true);
            pluginGeneratedSerialDescriptor.addElement(ViewHierarchyConstants.TEXT_SIZE, true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final o deserialize(Decoder decoder) {
            int i;
            Float f;
            String str;
            String str2;
            Integer num;
            Integer num2;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            Float f2 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                Float f3 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, FloatSerializer.INSTANCE, null);
                StringSerializer stringSerializer = StringSerializer.INSTANCE;
                String str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
                String str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
                IntSerializer intSerializer = IntSerializer.INSTANCE;
                f = f3;
                num = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, intSerializer, null);
                num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, intSerializer, null);
                str2 = str4;
                str = str3;
                i = 31;
            } else {
                boolean z = true;
                int i2 = 0;
                String str5 = null;
                String str6 = null;
                Integer num3 = null;
                Integer num4 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        f2 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, FloatSerializer.INSTANCE, f2);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str5);
                        i2 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str6);
                        i2 |= 4;
                    } else if (iDecodeElementIndex == 3) {
                        num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, num3);
                        i2 |= 8;
                    } else {
                        if (iDecodeElementIndex != 4) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        num4 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, num4);
                        i2 |= 16;
                    }
                }
                i = i2;
                f = f2;
                str = str5;
                str2 = str6;
                num = num3;
                num2 = num4;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new o(i, f, str, str2, num, num2, (SerializationConstructorMarker) null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            KSerializer<?> nullable = BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(stringSerializer);
            KSerializer<?> nullable3 = BuiltinSerializersKt.getNullable(stringSerializer);
            IntSerializer intSerializer = IntSerializer.INSTANCE;
            return new KSerializer[]{nullable, nullable2, nullable3, BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(intSerializer)};
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
        public final void serialize(Encoder encoder, o value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            o.a(value, compositeEncoderBeginStructure, serialDescriptor);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.ortb.model.o$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<o> serializer() {
            return a.f2130a;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public o() {
        this((Float) null, (String) null, (String) null, (Integer) null, (Integer) null, 31, (DefaultConstructorMarker) null);
    }

    @SerialName("background_color")
    public static /* synthetic */ void g() {
    }

    @SerialName(ViewHierarchyConstants.TEXT_SIZE)
    public static /* synthetic */ void i() {
    }

    @SerialName("foreground_color")
    public static /* synthetic */ void k() {
    }

    @SerialName("rating_value")
    public static /* synthetic */ void m() {
    }

    @SerialName("rating_size")
    public static /* synthetic */ void o() {
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Float getRatingValue() {
        return this.ratingValue;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getForegroundColor() {
        return this.foregroundColor;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final Integer getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final Integer getFontSize() {
        return this.fontSize;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof o)) {
            return false;
        }
        o oVar = (o) other;
        return Intrinsics.areEqual((Object) this.ratingValue, (Object) oVar.ratingValue) && Intrinsics.areEqual(this.foregroundColor, oVar.foregroundColor) && Intrinsics.areEqual(this.backgroundColor, oVar.backgroundColor) && Intrinsics.areEqual(this.size, oVar.size) && Intrinsics.areEqual(this.fontSize, oVar.fontSize);
    }

    public final String f() {
        return this.backgroundColor;
    }

    public final Integer h() {
        return this.fontSize;
    }

    public int hashCode() {
        Float f2 = this.ratingValue;
        int iHashCode = (f2 == null ? 0 : f2.hashCode()) * 31;
        String str = this.foregroundColor;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.backgroundColor;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.size;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.fontSize;
        return iHashCode4 + (num2 != null ? num2.hashCode() : 0);
    }

    public final String j() {
        return this.foregroundColor;
    }

    public final Float l() {
        return this.ratingValue;
    }

    public final Integer n() {
        return this.size;
    }

    public String toString() {
        return "DECRatingSerializable(ratingValue=" + this.ratingValue + ", foregroundColor=" + this.foregroundColor + ", backgroundColor=" + this.backgroundColor + ", size=" + this.size + ", fontSize=" + this.fontSize + ')';
    }

    public /* synthetic */ o(int i, Float f2, String str, String str2, Integer num, Integer num2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.ratingValue = null;
        } else {
            this.ratingValue = f2;
        }
        if ((i & 2) == 0) {
            this.foregroundColor = null;
        } else {
            this.foregroundColor = str;
        }
        if ((i & 4) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = str2;
        }
        if ((i & 8) == 0) {
            this.size = null;
        } else {
            this.size = num;
        }
        if ((i & 16) == 0) {
            this.fontSize = null;
        } else {
            this.fontSize = num2;
        }
    }

    public final o a(Float ratingValue, String foregroundColor, String backgroundColor, Integer size, Integer fontSize) {
        return new o(ratingValue, foregroundColor, backgroundColor, size, fontSize);
    }

    public static /* synthetic */ o a(o oVar, Float f2, String str, String str2, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = oVar.ratingValue;
        }
        if ((i & 2) != 0) {
            str = oVar.foregroundColor;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = oVar.backgroundColor;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            num = oVar.size;
        }
        Integer num3 = num;
        if ((i & 16) != 0) {
            num2 = oVar.fontSize;
        }
        return oVar.a(f2, str3, str4, num3, num2);
    }

    @JvmStatic
    public static final /* synthetic */ void a(o self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.ratingValue != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, FloatSerializer.INSTANCE, self.ratingValue);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.foregroundColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.foregroundColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.backgroundColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.backgroundColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.size != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.size);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.fontSize == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.fontSize);
    }

    public o(Float f2, String str, String str2, Integer num, Integer num2) {
        this.ratingValue = f2;
        this.foregroundColor = str;
        this.backgroundColor = str2;
        this.size = num;
        this.fontSize = num2;
    }

    public /* synthetic */ o(Float f2, String str, String str2, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : f2, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2);
    }
}
