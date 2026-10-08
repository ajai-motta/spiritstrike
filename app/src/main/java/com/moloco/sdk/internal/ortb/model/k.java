package com.moloco.sdk.internal.ortb.model;

import androidx.compose.material.OutlinedTextFieldKt;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.moloco.sdk.internal.ortb.model.m;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0081\b\u0018\u0000 -2\u00020\u0001:\u0002\u0014\u0017B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\b\u0010\rJ'\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ4\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÇ\u0001¢\u0006\u0004\b\u0014\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u001c\u0010\u0018J\u0010\u0010\u001d\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H×\u0003¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0014\u0010#\u0012\u0004\b%\u0010&\u001a\u0004\b$\u0010\u0016R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0017\u0010'\u0012\u0004\b)\u0010&\u001a\u0004\b(\u0010\u0018R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0019\u0010*\u0012\u0004\b,\u0010&\u001a\u0004\b+\u0010\u001a¨\u0006."}, d2 = {"Lcom/moloco/sdk/internal/ortb/model/k;", "", "", ContentDisposition.Parameters.Size, "", "appIconUri", "Lcom/moloco/sdk/internal/ortb/model/m;", OutlinedTextFieldKt.BorderId, "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/moloco/sdk/internal/ortb/model/m;)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/Integer;Ljava/lang/String;Lcom/moloco/sdk/internal/ortb/model/m;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "a", "(Lcom/moloco/sdk/internal/ortb/model/k;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "()Ljava/lang/Integer;", "b", "()Ljava/lang/String;", "c", "()Lcom/moloco/sdk/internal/ortb/model/m;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/moloco/sdk/internal/ortb/model/m;)Lcom/moloco/sdk/internal/ortb/model/k;", InAppPurchaseConstants.METHOD_TO_STRING, "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "h", "i", "()V", "Ljava/lang/String;", "d", "e", "Lcom/moloco/sdk/internal/ortb/model/m;", InneractiveMediationDefs.GENDER_FEMALE, "g", com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.M, "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
@Serializable
public final /* data */ class k {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Integer size;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String appIconUri;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final m border;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<k> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2122a;
        public static final int b;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            f2122a = aVar;
            b = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.DECAppIconSerializable", aVar, 3);
            pluginGeneratedSerialDescriptor.addElement(ContentDisposition.Parameters.Size, true);
            pluginGeneratedSerialDescriptor.addElement("app_icon_url", true);
            pluginGeneratedSerialDescriptor.addElement(OutlinedTextFieldKt.BorderId, true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final k deserialize(Decoder decoder) {
            int i;
            Integer num;
            String str;
            m mVar;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            Integer num2 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                Integer num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, IntSerializer.INSTANCE, null);
                String str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
                num = num3;
                mVar = (m) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, m.a.f2126a, null);
                str = str2;
                i = 7;
            } else {
                boolean z = true;
                int i2 = 0;
                String str3 = null;
                m mVar2 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, IntSerializer.INSTANCE, num2);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str3);
                        i2 |= 2;
                    } else {
                        if (iDecodeElementIndex != 2) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        mVar2 = (m) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, m.a.f2126a, mVar2);
                        i2 |= 4;
                    }
                }
                i = i2;
                num = num2;
                str = str3;
                mVar = mVar2;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new k(i, num, str, mVar, (SerializationConstructorMarker) null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(m.a.f2126a)};
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
        public final void serialize(Encoder encoder, k value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            k.a(value, compositeEncoderBeginStructure, serialDescriptor);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.ortb.model.k$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<k> serializer() {
            return a.f2122a;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public k() {
        this((Integer) null, (String) null, (m) null, 7, (DefaultConstructorMarker) null);
    }

    @SerialName("app_icon_url")
    public static /* synthetic */ void e() {
    }

    @SerialName(OutlinedTextFieldKt.BorderId)
    public static /* synthetic */ void g() {
    }

    @SerialName(ContentDisposition.Parameters.Size)
    public static /* synthetic */ void i() {
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Integer getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getAppIconUri() {
        return this.appIconUri;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final m getBorder() {
        return this.border;
    }

    public final String d() {
        return this.appIconUri;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof k)) {
            return false;
        }
        k kVar = (k) other;
        return Intrinsics.areEqual(this.size, kVar.size) && Intrinsics.areEqual(this.appIconUri, kVar.appIconUri) && Intrinsics.areEqual(this.border, kVar.border);
    }

    public final m f() {
        return this.border;
    }

    public final Integer h() {
        return this.size;
    }

    public int hashCode() {
        Integer num = this.size;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.appIconUri;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        m mVar = this.border;
        return iHashCode2 + (mVar != null ? mVar.hashCode() : 0);
    }

    public String toString() {
        return "DECAppIconSerializable(size=" + this.size + ", appIconUri=" + this.appIconUri + ", border=" + this.border + ')';
    }

    public /* synthetic */ k(int i, Integer num, String str, m mVar, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.size = null;
        } else {
            this.size = num;
        }
        if ((i & 2) == 0) {
            this.appIconUri = null;
        } else {
            this.appIconUri = str;
        }
        if ((i & 4) == 0) {
            this.border = null;
        } else {
            this.border = mVar;
        }
    }

    public final k a(Integer size, String appIconUri, m border) {
        return new k(size, appIconUri, border);
    }

    public static /* synthetic */ k a(k kVar, Integer num, String str, m mVar, int i, Object obj) {
        if ((i & 1) != 0) {
            num = kVar.size;
        }
        if ((i & 2) != 0) {
            str = kVar.appIconUri;
        }
        if ((i & 4) != 0) {
            mVar = kVar.border;
        }
        return kVar.a(num, str, mVar);
    }

    @JvmStatic
    public static final /* synthetic */ void a(k self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.size != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.size);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.appIconUri != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.appIconUri);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.border == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, m.a.f2126a, self.border);
    }

    public k(Integer num, String str, m mVar) {
        this.size = num;
        this.appIconUri = str;
        this.border = mVar;
    }

    public /* synthetic */ k(Integer num, String str, m mVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : mVar);
    }
}
