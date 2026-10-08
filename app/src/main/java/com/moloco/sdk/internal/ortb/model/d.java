package com.moloco.sdk.internal.ortb.model;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.moloco.sdk.internal.ortb.model.s;
import com.moloco.sdk.internal.ortb.model.t;
import com.moloco.sdk.internal.ortb.model.v;
import com.moloco.sdk.internal.ortb.model.x;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0018\b\u0001\u0018\u0000 /2\u00020\u0001:\u0002\u0019 BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rBM\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0012J'\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0019\u0010\u001b\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b \u0010!\u0012\u0004\b$\u0010\u001f\u001a\u0004\b\"\u0010#R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b%\u0010&\u0012\u0004\b \u0010\u001f\u001a\u0004\b\u0019\u0010'R\"\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b(\u0010)\u0012\u0004\b,\u0010\u001f\u001a\u0004\b*\u0010+R\"\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\"\u0010-\u0012\u0004\b(\u0010\u001f\u001a\u0004\b%\u0010.¨\u00060"}, d2 = {"Lcom/moloco/sdk/internal/ortb/model/d;", "", "Lcom/moloco/sdk/internal/ortb/model/v;", "player", "", "mtid", "Lcom/moloco/sdk/internal/ortb/model/t;", "configs", "Lcom/moloco/sdk/internal/ortb/model/x;", "sdkEvents", "Lcom/moloco/sdk/internal/ortb/model/s;", "molocoSdkClickMetaData", "<init>", "(Lcom/moloco/sdk/internal/ortb/model/v;Ljava/lang/String;Lcom/moloco/sdk/internal/ortb/model/t;Lcom/moloco/sdk/internal/ortb/model/x;Lcom/moloco/sdk/internal/ortb/model/s;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILcom/moloco/sdk/internal/ortb/model/v;Ljava/lang/String;Lcom/moloco/sdk/internal/ortb/model/t;Lcom/moloco/sdk/internal/ortb/model/x;Lcom/moloco/sdk/internal/ortb/model/s;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "a", "(Lcom/moloco/sdk/internal/ortb/model/d;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "Lcom/moloco/sdk/internal/ortb/model/v;", "g", "()Lcom/moloco/sdk/internal/ortb/model/v;", "h", "()V", "b", "Ljava/lang/String;", "e", "()Ljava/lang/String;", InneractiveMediationDefs.GENDER_FEMALE, "c", "Lcom/moloco/sdk/internal/ortb/model/t;", "()Lcom/moloco/sdk/internal/ortb/model/t;", "d", "Lcom/moloco/sdk/internal/ortb/model/x;", "i", "()Lcom/moloco/sdk/internal/ortb/model/x;", "j", "Lcom/moloco/sdk/internal/ortb/model/s;", "()Lcom/moloco/sdk/internal/ortb/model/s;", com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.M, "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
@Serializable
public final class d {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final v player;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String mtid;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final t configs;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final x sdkEvents;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final s molocoSdkClickMetaData;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2111a;
        public static final int b;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            f2111a = aVar;
            b = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.BidExt", aVar, 5);
            pluginGeneratedSerialDescriptor.addElement("player", true);
            pluginGeneratedSerialDescriptor.addElement("mtid", true);
            pluginGeneratedSerialDescriptor.addElement("moloco_sdk_configs", true);
            pluginGeneratedSerialDescriptor.addElement("moloco_sdk_events", true);
            pluginGeneratedSerialDescriptor.addElement("moloco_sdk_click_metadata", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d deserialize(Decoder decoder) {
            int i;
            v vVar;
            String str;
            t tVar;
            x xVar;
            s sVar;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            v vVar2 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                v vVar3 = (v) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, v.a.f2143a, null);
                String str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
                t tVar2 = (t) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, t.a.f2139a, null);
                vVar = vVar3;
                xVar = (x) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, x.a.f2147a, null);
                sVar = (s) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, s.a.f2137a, null);
                tVar = tVar2;
                str = str2;
                i = 31;
            } else {
                boolean z = true;
                int i2 = 0;
                String str3 = null;
                t tVar3 = null;
                x xVar2 = null;
                s sVar2 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        vVar2 = (v) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, v.a.f2143a, vVar2);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str3);
                        i2 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        tVar3 = (t) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, t.a.f2139a, tVar3);
                        i2 |= 4;
                    } else if (iDecodeElementIndex == 3) {
                        xVar2 = (x) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, x.a.f2147a, xVar2);
                        i2 |= 8;
                    } else {
                        if (iDecodeElementIndex != 4) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        sVar2 = (s) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, s.a.f2137a, sVar2);
                        i2 |= 16;
                    }
                }
                i = i2;
                vVar = vVar2;
                str = str3;
                tVar = tVar3;
                xVar = xVar2;
                sVar = sVar2;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new d(i, vVar, str, tVar, xVar, sVar, (SerializationConstructorMarker) null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{BuiltinSerializersKt.getNullable(v.a.f2143a), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(t.a.f2139a), BuiltinSerializersKt.getNullable(x.a.f2147a), BuiltinSerializersKt.getNullable(s.a.f2137a)};
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
        public final void serialize(Encoder encoder, d value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            d.a(value, compositeEncoderBeginStructure, serialDescriptor);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.ortb.model.d$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<d> serializer() {
            return a.f2111a;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d() {
        this((v) null, (String) null, (t) null, (x) null, (s) null, 31, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final /* synthetic */ void a(d self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.player != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, v.a.f2143a, self.player);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.mtid != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.mtid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.configs != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, t.a.f2139a, self.configs);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.sdkEvents != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, x.a.f2147a, self.sdkEvents);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.molocoSdkClickMetaData == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, s.a.f2137a, self.molocoSdkClickMetaData);
    }

    @SerialName("moloco_sdk_configs")
    public static /* synthetic */ void b() {
    }

    @SerialName("moloco_sdk_click_metadata")
    public static /* synthetic */ void d() {
    }

    @SerialName("mtid")
    public static /* synthetic */ void f() {
    }

    @SerialName("player")
    public static /* synthetic */ void h() {
    }

    @SerialName("moloco_sdk_events")
    public static /* synthetic */ void j() {
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final s getMolocoSdkClickMetaData() {
        return this.molocoSdkClickMetaData;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getMtid() {
        return this.mtid;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final v getPlayer() {
        return this.player;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final x getSdkEvents() {
        return this.sdkEvents;
    }

    public /* synthetic */ d(int i, v vVar, String str, t tVar, x xVar, s sVar, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.player = null;
        } else {
            this.player = vVar;
        }
        if ((i & 2) == 0) {
            this.mtid = null;
        } else {
            this.mtid = str;
        }
        if ((i & 4) == 0) {
            this.configs = null;
        } else {
            this.configs = tVar;
        }
        if ((i & 8) == 0) {
            this.sdkEvents = null;
        } else {
            this.sdkEvents = xVar;
        }
        if ((i & 16) == 0) {
            this.molocoSdkClickMetaData = null;
        } else {
            this.molocoSdkClickMetaData = sVar;
        }
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final t getConfigs() {
        return this.configs;
    }

    public d(v vVar, String str, t tVar, x xVar, s sVar) {
        this.player = vVar;
        this.mtid = str;
        this.configs = tVar;
        this.sdkEvents = xVar;
        this.molocoSdkClickMetaData = sVar;
    }

    public /* synthetic */ d(v vVar, String str, t tVar, x xVar, s sVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : vVar, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : tVar, (i & 8) != 0 ? null : xVar, (i & 16) != 0 ? null : sVar);
    }
}
