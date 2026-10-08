package com.moloco.sdk.internal.ortb.model;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.moloco.sdk.internal.ortb.model.A;
import com.moloco.sdk.internal.ortb.model.C2988a;
import com.moloco.sdk.internal.ortb.model.g;
import com.moloco.sdk.internal.ortb.model.i;
import com.moloco.sdk.internal.ortb.model.j;
import com.moloco.sdk.internal.ortb.model.u;
import com.moloco.sdk.internal.ortb.model.w;
import com.moloco.sdk.internal.ortb.model.z;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b*\b\u0001\u0018\u0000 J2\u00020\u0001:\u0002\")Bs\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016B}\b\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0015\u0010\u001bJ'\u0010\"\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0001¢\u0006\u0004\b\"\u0010#R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\"\u0010$\u0012\u0004\b'\u0010(\u001a\u0004\b%\u0010&R \u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b)\u0010$\u0012\u0004\b+\u0010(\u001a\u0004\b*\u0010&R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b*\u0010,\u0012\u0004\b/\u0010(\u001a\u0004\b-\u0010.R \u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b+\u00100\u0012\u0004\b3\u0010(\u001a\u0004\b1\u00102R\"\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b4\u00105\u0012\u0004\b8\u0010(\u001a\u0004\b6\u00107R \u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b9\u0010:\u0012\u0004\b=\u0010(\u001a\u0004\b;\u0010<R\"\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b6\u0010>\u0012\u0004\b)\u0010(\u001a\u0004\b\"\u0010?R\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b8\u0010@\u0012\u0004\bC\u0010(\u001a\u0004\bA\u0010BR\"\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bD\u0010E\u0012\u0004\bG\u0010(\u001a\u0004\bD\u0010FR\"\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bG\u0010H\u0012\u0004\b9\u0010(\u001a\u0004\b4\u0010I¨\u0006K"}, d2 = {"Lcom/moloco/sdk/internal/ortb/model/v;", "", "Lcom/moloco/sdk/internal/ortb/model/z;", "skip", "close", "Lcom/moloco/sdk/internal/ortb/model/w;", "progressBar", "Lcom/moloco/sdk/internal/ortb/model/u;", "mute", "Lcom/moloco/sdk/internal/ortb/model/g;", "cta", "", "isAllAreaClickable", "Lcom/moloco/sdk/internal/ortb/model/a;", "autoStore", "Lcom/moloco/sdk/internal/ortb/model/A;", "vastPrivacyIcon", "Lcom/moloco/sdk/internal/ortb/model/j;", "dec", "Lcom/moloco/sdk/internal/ortb/model/i;", "countDownTimer", "<init>", "(Lcom/moloco/sdk/internal/ortb/model/z;Lcom/moloco/sdk/internal/ortb/model/z;Lcom/moloco/sdk/internal/ortb/model/w;Lcom/moloco/sdk/internal/ortb/model/u;Lcom/moloco/sdk/internal/ortb/model/g;ZLcom/moloco/sdk/internal/ortb/model/a;Lcom/moloco/sdk/internal/ortb/model/A;Lcom/moloco/sdk/internal/ortb/model/j;Lcom/moloco/sdk/internal/ortb/model/i;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILcom/moloco/sdk/internal/ortb/model/z;Lcom/moloco/sdk/internal/ortb/model/z;Lcom/moloco/sdk/internal/ortb/model/w;Lcom/moloco/sdk/internal/ortb/model/u;Lcom/moloco/sdk/internal/ortb/model/g;ZLcom/moloco/sdk/internal/ortb/model/a;Lcom/moloco/sdk/internal/ortb/model/A;Lcom/moloco/sdk/internal/ortb/model/j;Lcom/moloco/sdk/internal/ortb/model/i;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "a", "(Lcom/moloco/sdk/internal/ortb/model/v;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "Lcom/moloco/sdk/internal/ortb/model/z;", "o", "()Lcom/moloco/sdk/internal/ortb/model/z;", TtmlNode.TAG_P, "()V", "b", "c", "d", "Lcom/moloco/sdk/internal/ortb/model/w;", InneractiveMediationDefs.GENDER_MALE, "()Lcom/moloco/sdk/internal/ortb/model/w;", "n", "Lcom/moloco/sdk/internal/ortb/model/u;", "k", "()Lcom/moloco/sdk/internal/ortb/model/u;", "l", "e", "Lcom/moloco/sdk/internal/ortb/model/g;", "g", "()Lcom/moloco/sdk/internal/ortb/model/g;", "h", InneractiveMediationDefs.GENDER_FEMALE, "Z", "s", "()Z", "t", "Lcom/moloco/sdk/internal/ortb/model/a;", "()Lcom/moloco/sdk/internal/ortb/model/a;", "Lcom/moloco/sdk/internal/ortb/model/A;", "q", "()Lcom/moloco/sdk/internal/ortb/model/A;", AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ, "i", "Lcom/moloco/sdk/internal/ortb/model/j;", "()Lcom/moloco/sdk/internal/ortb/model/j;", "j", "Lcom/moloco/sdk/internal/ortb/model/i;", "()Lcom/moloco/sdk/internal/ortb/model/i;", com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.M, "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
@Serializable
public final class v {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int k = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final z skip;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final z close;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final w progressBar;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final u mute;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final g cta;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final boolean isAllAreaClickable;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final C2988a autoStore;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final A vastPrivacyIcon;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final j dec;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final i countDownTimer;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<v> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2143a;
        public static final int b;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            f2143a = aVar;
            b = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.Player", aVar, 10);
            pluginGeneratedSerialDescriptor.addElement("skip", true);
            pluginGeneratedSerialDescriptor.addElement("close", false);
            pluginGeneratedSerialDescriptor.addElement("progress_bar", true);
            pluginGeneratedSerialDescriptor.addElement("mute", false);
            pluginGeneratedSerialDescriptor.addElement("cta", true);
            pluginGeneratedSerialDescriptor.addElement("is_all_area_clickable", false);
            pluginGeneratedSerialDescriptor.addElement("auto_store", true);
            pluginGeneratedSerialDescriptor.addElement("vast_privacy_icon", true);
            pluginGeneratedSerialDescriptor.addElement("dec", true);
            pluginGeneratedSerialDescriptor.addElement("countdown_timer", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final v deserialize(Decoder decoder) {
            i iVar;
            z zVar;
            j jVar;
            int i;
            C2988a c2988a;
            z zVar2;
            A a2;
            w wVar;
            boolean z;
            g gVar;
            u uVar;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            int i2 = 9;
            int i3 = 8;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                z.a aVar = z.a.f2151a;
                z zVar3 = (z) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, aVar, null);
                z zVar4 = (z) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, aVar, null);
                w wVar2 = (w) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, w.a.f2145a, null);
                u uVar2 = (u) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, u.a.f2141a, null);
                g gVar2 = (g) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, g.a.f2115a, null);
                boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 5);
                C2988a c2988a2 = (C2988a) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, C2988a.C0389a.f2105a, null);
                A a3 = (A) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, A.a.f2102a, null);
                j jVar2 = (j) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, j.a.f2120a, null);
                iVar = (i) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, i.a.f2118a, null);
                a2 = a3;
                c2988a = c2988a2;
                jVar = jVar2;
                zVar = zVar4;
                z = zDecodeBooleanElement;
                i = 1023;
                gVar = gVar2;
                wVar = wVar2;
                uVar = uVar2;
                zVar2 = zVar3;
            } else {
                boolean z2 = true;
                boolean zDecodeBooleanElement2 = false;
                i iVar2 = null;
                j jVar3 = null;
                C2988a c2988a3 = null;
                A a4 = null;
                g gVar3 = null;
                u uVar3 = null;
                z zVar5 = null;
                z zVar6 = null;
                w wVar3 = null;
                int i4 = 0;
                while (z2) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z2 = false;
                            i3 = 8;
                            break;
                        case 0:
                            zVar5 = (z) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, z.a.f2151a, zVar5);
                            i4 |= 1;
                            i2 = 9;
                            i3 = 8;
                            break;
                        case 1:
                            zVar6 = (z) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, z.a.f2151a, zVar6);
                            i4 |= 2;
                            i2 = 9;
                            i3 = 8;
                            break;
                        case 2:
                            wVar3 = (w) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, w.a.f2145a, wVar3);
                            i4 |= 4;
                            i2 = 9;
                            i3 = 8;
                            break;
                        case 3:
                            uVar3 = (u) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, u.a.f2141a, uVar3);
                            i4 |= 8;
                            i2 = 9;
                            i3 = 8;
                            break;
                        case 4:
                            gVar3 = (g) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, g.a.f2115a, gVar3);
                            i4 |= 16;
                            i2 = 9;
                            i3 = 8;
                            break;
                        case 5:
                            zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 5);
                            i4 |= 32;
                            i2 = 9;
                            break;
                        case 6:
                            c2988a3 = (C2988a) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, C2988a.C0389a.f2105a, c2988a3);
                            i4 |= 64;
                            i2 = 9;
                            break;
                        case 7:
                            a4 = (A) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, A.a.f2102a, a4);
                            i4 |= 128;
                            i2 = 9;
                            break;
                        case 8:
                            jVar3 = (j) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, j.a.f2120a, jVar3);
                            i4 |= 256;
                            break;
                        case 9:
                            iVar2 = (i) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, i.a.f2118a, iVar2);
                            i4 |= 512;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                iVar = iVar2;
                zVar = zVar6;
                jVar = jVar3;
                i = i4;
                c2988a = c2988a3;
                zVar2 = zVar5;
                a2 = a4;
                wVar = wVar3;
                z = zDecodeBooleanElement2;
                u uVar4 = uVar3;
                gVar = gVar3;
                uVar = uVar4;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new v(i, zVar2, zVar, wVar, uVar, gVar, z, c2988a, a2, jVar, iVar, (SerializationConstructorMarker) null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            z.a aVar = z.a.f2151a;
            return new KSerializer[]{BuiltinSerializersKt.getNullable(aVar), aVar, BuiltinSerializersKt.getNullable(w.a.f2145a), u.a.f2141a, BuiltinSerializersKt.getNullable(g.a.f2115a), BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(C2988a.C0389a.f2105a), BuiltinSerializersKt.getNullable(A.a.f2102a), BuiltinSerializersKt.getNullable(j.a.f2120a), BuiltinSerializersKt.getNullable(i.a.f2118a)};
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
        public final void serialize(Encoder encoder, v value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            v.a(value, compositeEncoderBeginStructure, serialDescriptor);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.ortb.model.v$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<v> serializer() {
            return a.f2143a;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ v(int i, z zVar, z zVar2, w wVar, u uVar, g gVar, boolean z, C2988a c2988a, A a2, j jVar, i iVar, SerializationConstructorMarker serializationConstructorMarker) {
        if (42 != (i & 42)) {
            PluginExceptionsKt.throwMissingFieldException(i, 42, a.f2143a.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.skip = null;
        } else {
            this.skip = zVar;
        }
        this.close = zVar2;
        if ((i & 4) == 0) {
            this.progressBar = null;
        } else {
            this.progressBar = wVar;
        }
        this.mute = uVar;
        if ((i & 16) == 0) {
            this.cta = null;
        } else {
            this.cta = gVar;
        }
        this.isAllAreaClickable = z;
        if ((i & 64) == 0) {
            this.autoStore = null;
        } else {
            this.autoStore = c2988a;
        }
        if ((i & 128) == 0) {
            this.vastPrivacyIcon = null;
        } else {
            this.vastPrivacyIcon = a2;
        }
        if ((i & 256) == 0) {
            this.dec = null;
        } else {
            this.dec = jVar;
        }
        if ((i & 512) == 0) {
            this.countDownTimer = null;
        } else {
            this.countDownTimer = iVar;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void a(v self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.skip != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, z.a.f2151a, self.skip);
        }
        output.encodeSerializableElement(serialDesc, 1, z.a.f2151a, self.close);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.progressBar != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, w.a.f2145a, self.progressBar);
        }
        output.encodeSerializableElement(serialDesc, 3, u.a.f2141a, self.mute);
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.cta != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, g.a.f2115a, self.cta);
        }
        output.encodeBooleanElement(serialDesc, 5, self.isAllAreaClickable);
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.autoStore != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, C2988a.C0389a.f2105a, self.autoStore);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.vastPrivacyIcon != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, A.a.f2102a, self.vastPrivacyIcon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.dec != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, j.a.f2120a, self.dec);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 9) && self.countDownTimer == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 9, i.a.f2118a, self.countDownTimer);
    }

    @SerialName("auto_store")
    public static /* synthetic */ void b() {
    }

    @SerialName("close")
    public static /* synthetic */ void d() {
    }

    @SerialName("countdown_timer")
    public static /* synthetic */ void f() {
    }

    @SerialName("cta")
    public static /* synthetic */ void h() {
    }

    @SerialName("dec")
    public static /* synthetic */ void j() {
    }

    @SerialName("mute")
    public static /* synthetic */ void l() {
    }

    @SerialName("progress_bar")
    public static /* synthetic */ void n() {
    }

    @SerialName("skip")
    public static /* synthetic */ void p() {
    }

    @SerialName("vast_privacy_icon")
    public static /* synthetic */ void r() {
    }

    @SerialName("is_all_area_clickable")
    public static /* synthetic */ void t() {
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final z getClose() {
        return this.close;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final i getCountDownTimer() {
        return this.countDownTimer;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final g getCta() {
        return this.cta;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final j getDec() {
        return this.dec;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final u getMute() {
        return this.mute;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final w getProgressBar() {
        return this.progressBar;
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public final z getSkip() {
        return this.skip;
    }

    /* JADX INFO: renamed from: q, reason: from getter */
    public final A getVastPrivacyIcon() {
        return this.vastPrivacyIcon;
    }

    /* JADX INFO: renamed from: s, reason: from getter */
    public final boolean getIsAllAreaClickable() {
        return this.isAllAreaClickable;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final C2988a getAutoStore() {
        return this.autoStore;
    }

    public v(z zVar, z close, w wVar, u mute, g gVar, boolean z, C2988a c2988a, A a2, j jVar, i iVar) {
        Intrinsics.checkNotNullParameter(close, "close");
        Intrinsics.checkNotNullParameter(mute, "mute");
        this.skip = zVar;
        this.close = close;
        this.progressBar = wVar;
        this.mute = mute;
        this.cta = gVar;
        this.isAllAreaClickable = z;
        this.autoStore = c2988a;
        this.vastPrivacyIcon = a2;
        this.dec = jVar;
        this.countDownTimer = iVar;
    }

    public /* synthetic */ v(z zVar, z zVar2, w wVar, u uVar, g gVar, boolean z, C2988a c2988a, A a2, j jVar, i iVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : zVar, zVar2, (i & 4) != 0 ? null : wVar, uVar, (i & 16) != 0 ? null : gVar, z, (i & 64) != 0 ? null : c2988a, (i & 128) != 0 ? null : a2, (i & 256) != 0 ? null : jVar, (i & 512) != 0 ? null : iVar);
    }
}
