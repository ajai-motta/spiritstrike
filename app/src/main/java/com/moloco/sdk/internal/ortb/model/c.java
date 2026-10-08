package com.moloco.sdk.internal.ortb.model;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.moloco.sdk.internal.ortb.model.d;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0001\u0018\u0000 )2\u00020\u0001:\u0002\u0017\u001bB7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bBK\b\u0010\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u0010J'\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018R \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0017\u0010\u0019\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u001aR \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001b\u0010\u001d\u0012\u0004\b \u0010\u001c\u001a\u0004\b\u001e\u0010\u001fR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b!\u0010\u0019\u0012\u0004\b\"\u0010\u001c\u001a\u0004\b!\u0010\u001aR \u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\"\u0010#\u0012\u0004\b&\u0010\u001c\u001a\u0004\b$\u0010%R\"\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b'\u0010\u0019\u0012\u0004\b(\u0010\u001c\u001a\u0004\b'\u0010\u001a¨\u0006*"}, d2 = {"Lcom/moloco/sdk/internal/ortb/model/c;", "", "", "adm", "", "price", "burl", "Lcom/moloco/sdk/internal/ortb/model/d;", "ext", "crid", "<init>", "(Ljava/lang/String;FLjava/lang/String;Lcom/moloco/sdk/internal/ortb/model/d;Ljava/lang/String;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;FLjava/lang/String;Lcom/moloco/sdk/internal/ortb/model/d;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "a", "(Lcom/moloco/sdk/internal/ortb/model/c;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "Ljava/lang/String;", "()Ljava/lang/String;", "b", "()V", "F", "i", "()F", "j", "c", "d", "Lcom/moloco/sdk/internal/ortb/model/d;", "g", "()Lcom/moloco/sdk/internal/ortb/model/d;", "h", "e", InneractiveMediationDefs.GENDER_FEMALE, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.M, "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
@Serializable
public final class c {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String adm;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final float price;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String burl;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final d ext;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final String crid;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2109a;
        public static final int b;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            f2109a = aVar;
            b = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.Bid", aVar, 5);
            pluginGeneratedSerialDescriptor.addElement("adm", false);
            pluginGeneratedSerialDescriptor.addElement("price", false);
            pluginGeneratedSerialDescriptor.addElement("burl", true);
            pluginGeneratedSerialDescriptor.addElement("ext", false);
            pluginGeneratedSerialDescriptor.addElement("crid", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c deserialize(Decoder decoder) {
            float f;
            int i;
            String str;
            String str2;
            d dVar;
            String str3;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                float fDecodeFloatElement = compositeDecoderBeginStructure.decodeFloatElement(serialDescriptor, 1);
                StringSerializer stringSerializer = StringSerializer.INSTANCE;
                String str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
                str = strDecodeStringElement;
                dVar = (d) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, d.a.f2111a, null);
                str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
                str2 = str4;
                f = fDecodeFloatElement;
                i = 31;
            } else {
                float fDecodeFloatElement2 = 0.0f;
                boolean z = true;
                String strDecodeStringElement2 = null;
                String str5 = null;
                d dVar2 = null;
                String str6 = null;
                int i2 = 0;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        fDecodeFloatElement2 = compositeDecoderBeginStructure.decodeFloatElement(serialDescriptor, 1);
                        i2 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str5);
                        i2 |= 4;
                    } else if (iDecodeElementIndex == 3) {
                        dVar2 = (d) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, d.a.f2111a, dVar2);
                        i2 |= 8;
                    } else {
                        if (iDecodeElementIndex != 4) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str6);
                        i2 |= 16;
                    }
                }
                f = fDecodeFloatElement2;
                i = i2;
                str = strDecodeStringElement2;
                str2 = str5;
                dVar = dVar2;
                str3 = str6;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new c(i, str, f, str2, dVar, str3, (SerializationConstructorMarker) null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            return new KSerializer[]{stringSerializer, FloatSerializer.INSTANCE, BuiltinSerializersKt.getNullable(stringSerializer), d.a.f2111a, BuiltinSerializersKt.getNullable(stringSerializer)};
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
        public final void serialize(Encoder encoder, c value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            c.a(value, compositeEncoderBeginStructure, serialDescriptor);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.ortb.model.c$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<c> serializer() {
            return a.f2109a;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ c(int i, String str, float f2, String str2, d dVar, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (11 != (i & 11)) {
            PluginExceptionsKt.throwMissingFieldException(i, 11, a.f2109a.getDescriptor());
        }
        this.adm = str;
        this.price = f2;
        if ((i & 4) == 0) {
            this.burl = null;
        } else {
            this.burl = str2;
        }
        this.ext = dVar;
        if ((i & 16) == 0) {
            this.crid = null;
        } else {
            this.crid = str3;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void a(c self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.adm);
        output.encodeFloatElement(serialDesc, 1, self.price);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.burl != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.burl);
        }
        output.encodeSerializableElement(serialDesc, 3, d.a.f2111a, self.ext);
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.crid == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.crid);
    }

    @SerialName("adm")
    public static /* synthetic */ void b() {
    }

    @SerialName("burl")
    public static /* synthetic */ void d() {
    }

    @SerialName("crid")
    public static /* synthetic */ void f() {
    }

    @SerialName("ext")
    public static /* synthetic */ void h() {
    }

    @SerialName("price")
    public static /* synthetic */ void j() {
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getBurl() {
        return this.burl;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getCrid() {
        return this.crid;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final d getExt() {
        return this.ext;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final float getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getAdm() {
        return this.adm;
    }

    public c(String adm, float f2, String str, d ext, String str2) {
        Intrinsics.checkNotNullParameter(adm, "adm");
        Intrinsics.checkNotNullParameter(ext, "ext");
        this.adm = adm;
        this.price = f2;
        this.burl = str;
        this.ext = ext;
        this.crid = str2;
    }

    public /* synthetic */ c(String str, float f2, String str2, d dVar, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, f2, (i & 4) != 0 ? null : str2, dVar, (i & 16) != 0 ? null : str3);
    }
}
