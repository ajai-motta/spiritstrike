package com.moloco.sdk.internal.ortb.model;

import androidx.core.app.FrameMetricsAggregator;
import com.facebook.internal.NativeProtocol;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.moloco.sdk.internal.ortb.model.k;
import com.moloco.sdk.internal.ortb.model.l;
import com.moloco.sdk.internal.ortb.model.n;
import com.moloco.sdk.internal.ortb.model.o;
import com.moloco.sdk.internal.ortb.model.p;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\"\b\u0001\u0018\u0000 >2\u00020\u0001:\u0002\u001e%Bs\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012Bu\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0011\u0010\u0017J'\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001e\u0010 \u0012\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b%\u0010 \u0012\u0004\b'\u0010$\u001a\u0004\b&\u0010\"R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b(\u0010 \u0012\u0004\b*\u0010$\u001a\u0004\b)\u0010\"R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b+\u0010 \u0012\u0004\b-\u0010$\u001a\u0004\b,\u0010\"R\"\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b)\u0010.\u0012\u0004\b+\u0010$\u001a\u0004\b(\u0010/R\"\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b*\u00100\u0012\u0004\b3\u0010$\u001a\u0004\b1\u00102R\"\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b&\u00104\u0012\u0004\b7\u0010$\u001a\u0004\b5\u00106R\"\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b'\u00108\u0012\u0004\b;\u0010$\u001a\u0004\b9\u0010:R\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b5\u0010<\u0012\u0004\b%\u0010$\u001a\u0004\b\u001e\u0010=¨\u0006?"}, d2 = {"Lcom/moloco/sdk/internal/ortb/model/j;", "", "", "impressionTrackingUrl", "ctaUrl", "ctaTrackingUrl", "skipToDecTrackingUrl", "Lcom/moloco/sdk/internal/ortb/model/p;", "close", "Lcom/moloco/sdk/internal/ortb/model/n;", "decCta", "Lcom/moloco/sdk/internal/ortb/model/k;", "decAppIcon", "Lcom/moloco/sdk/internal/ortb/model/o;", "decRating", "Lcom/moloco/sdk/internal/ortb/model/l;", "appName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/moloco/sdk/internal/ortb/model/p;Lcom/moloco/sdk/internal/ortb/model/n;Lcom/moloco/sdk/internal/ortb/model/k;Lcom/moloco/sdk/internal/ortb/model/o;Lcom/moloco/sdk/internal/ortb/model/l;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/moloco/sdk/internal/ortb/model/p;Lcom/moloco/sdk/internal/ortb/model/n;Lcom/moloco/sdk/internal/ortb/model/k;Lcom/moloco/sdk/internal/ortb/model/o;Lcom/moloco/sdk/internal/ortb/model/l;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "a", "(Lcom/moloco/sdk/internal/ortb/model/j;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "Ljava/lang/String;", "o", "()Ljava/lang/String;", TtmlNode.TAG_P, "()V", "b", "g", "h", "c", "e", InneractiveMediationDefs.GENDER_FEMALE, "d", "q", AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ, "Lcom/moloco/sdk/internal/ortb/model/p;", "()Lcom/moloco/sdk/internal/ortb/model/p;", "Lcom/moloco/sdk/internal/ortb/model/n;", "k", "()Lcom/moloco/sdk/internal/ortb/model/n;", "l", "Lcom/moloco/sdk/internal/ortb/model/k;", "i", "()Lcom/moloco/sdk/internal/ortb/model/k;", "j", "Lcom/moloco/sdk/internal/ortb/model/o;", InneractiveMediationDefs.GENDER_MALE, "()Lcom/moloco/sdk/internal/ortb/model/o;", "n", "Lcom/moloco/sdk/internal/ortb/model/l;", "()Lcom/moloco/sdk/internal/ortb/model/l;", com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.M, "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
@Serializable
public final class j {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int j = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String impressionTrackingUrl;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String ctaUrl;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String ctaTrackingUrl;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final String skipToDecTrackingUrl;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final p close;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final n decCta;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final k decAppIcon;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final o decRating;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final l appName;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2120a;
        public static final int b;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            f2120a = aVar;
            b = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.DEC", aVar, 9);
            pluginGeneratedSerialDescriptor.addElement("imp_link", true);
            pluginGeneratedSerialDescriptor.addElement("click_through", true);
            pluginGeneratedSerialDescriptor.addElement("click_tracking", true);
            pluginGeneratedSerialDescriptor.addElement("skip_event", true);
            pluginGeneratedSerialDescriptor.addElement("close", true);
            pluginGeneratedSerialDescriptor.addElement("cta", true);
            pluginGeneratedSerialDescriptor.addElement("app_icon", true);
            pluginGeneratedSerialDescriptor.addElement("rating", true);
            pluginGeneratedSerialDescriptor.addElement(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final j deserialize(Decoder decoder) {
            int i;
            l lVar;
            String str;
            p pVar;
            String str2;
            o oVar;
            k kVar;
            String str3;
            n nVar;
            String str4;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            int i2 = 7;
            String str5 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                StringSerializer stringSerializer = StringSerializer.INSTANCE;
                String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
                String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
                String str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
                String str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
                p pVar2 = (p) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, p.a.f2132a, null);
                n nVar2 = (n) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, n.a.f2128a, null);
                k kVar2 = (k) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, k.a.f2122a, null);
                oVar = (o) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, o.a.f2130a, null);
                kVar = kVar2;
                nVar = nVar2;
                pVar = pVar2;
                lVar = (l) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, l.a.f2124a, null);
                i = 511;
                str = str6;
                str2 = str9;
                str4 = str8;
                str3 = str7;
            } else {
                boolean z = true;
                int i3 = 0;
                o oVar2 = null;
                l lVar2 = null;
                k kVar3 = null;
                n nVar3 = null;
                p pVar3 = null;
                String str10 = null;
                String str11 = null;
                String str12 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z = false;
                            i2 = 7;
                            break;
                        case 0:
                            str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str5);
                            i3 |= 1;
                            i2 = 7;
                            break;
                        case 1:
                            str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str10);
                            i3 |= 2;
                            i2 = 7;
                            break;
                        case 2:
                            str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str11);
                            i3 |= 4;
                            i2 = 7;
                            break;
                        case 3:
                            str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str12);
                            i3 |= 8;
                            i2 = 7;
                            break;
                        case 4:
                            pVar3 = (p) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, p.a.f2132a, pVar3);
                            i3 |= 16;
                            i2 = 7;
                            break;
                        case 5:
                            nVar3 = (n) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, n.a.f2128a, nVar3);
                            i3 |= 32;
                            i2 = 7;
                            break;
                        case 6:
                            kVar3 = (k) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, k.a.f2122a, kVar3);
                            i3 |= 64;
                            break;
                        case 7:
                            oVar2 = (o) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, o.a.f2130a, oVar2);
                            i3 |= 128;
                            break;
                        case 8:
                            lVar2 = (l) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, l.a.f2124a, lVar2);
                            i3 |= 256;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                i = i3;
                lVar = lVar2;
                str = str5;
                pVar = pVar3;
                str2 = str12;
                oVar = oVar2;
                String str13 = str11;
                kVar = kVar3;
                str3 = str10;
                nVar = nVar3;
                str4 = str13;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new j(i, str, str3, str4, str2, pVar, nVar, kVar, oVar, lVar, (SerializationConstructorMarker) null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            return new KSerializer[]{BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(p.a.f2132a), BuiltinSerializersKt.getNullable(n.a.f2128a), BuiltinSerializersKt.getNullable(k.a.f2122a), BuiltinSerializersKt.getNullable(o.a.f2130a), BuiltinSerializersKt.getNullable(l.a.f2124a)};
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
        public final void serialize(Encoder encoder, j value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            j.a(value, compositeEncoderBeginStructure, serialDescriptor);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.ortb.model.j$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<j> serializer() {
            return a.f2120a;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public j() {
        this((String) null, (String) null, (String) null, (String) null, (p) null, (n) null, (k) null, (o) null, (l) null, FrameMetricsAggregator.EVERY_DURATION, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final /* synthetic */ void a(j self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.impressionTrackingUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.impressionTrackingUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.ctaUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.ctaUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.ctaTrackingUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.ctaTrackingUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.skipToDecTrackingUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.skipToDecTrackingUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.close != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, p.a.f2132a, self.close);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.decCta != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, n.a.f2128a, self.decCta);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.decAppIcon != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, k.a.f2122a, self.decAppIcon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.decRating != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, o.a.f2130a, self.decRating);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 8) && self.appName == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 8, l.a.f2124a, self.appName);
    }

    @SerialName(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING)
    public static /* synthetic */ void b() {
    }

    @SerialName("close")
    public static /* synthetic */ void d() {
    }

    @SerialName("click_tracking")
    public static /* synthetic */ void f() {
    }

    @SerialName("click_through")
    public static /* synthetic */ void h() {
    }

    @SerialName("app_icon")
    public static /* synthetic */ void j() {
    }

    @SerialName("cta")
    public static /* synthetic */ void l() {
    }

    @SerialName("rating")
    public static /* synthetic */ void n() {
    }

    @SerialName("imp_link")
    public static /* synthetic */ void p() {
    }

    @SerialName("skip_event")
    public static /* synthetic */ void r() {
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final p getClose() {
        return this.close;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getCtaTrackingUrl() {
        return this.ctaTrackingUrl;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getCtaUrl() {
        return this.ctaUrl;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final k getDecAppIcon() {
        return this.decAppIcon;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final n getDecCta() {
        return this.decCta;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final o getDecRating() {
        return this.decRating;
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public final String getImpressionTrackingUrl() {
        return this.impressionTrackingUrl;
    }

    /* JADX INFO: renamed from: q, reason: from getter */
    public final String getSkipToDecTrackingUrl() {
        return this.skipToDecTrackingUrl;
    }

    public /* synthetic */ j(int i, String str, String str2, String str3, String str4, p pVar, n nVar, k kVar, o oVar, l lVar, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.impressionTrackingUrl = null;
        } else {
            this.impressionTrackingUrl = str;
        }
        if ((i & 2) == 0) {
            this.ctaUrl = null;
        } else {
            this.ctaUrl = str2;
        }
        if ((i & 4) == 0) {
            this.ctaTrackingUrl = null;
        } else {
            this.ctaTrackingUrl = str3;
        }
        if ((i & 8) == 0) {
            this.skipToDecTrackingUrl = null;
        } else {
            this.skipToDecTrackingUrl = str4;
        }
        if ((i & 16) == 0) {
            this.close = null;
        } else {
            this.close = pVar;
        }
        if ((i & 32) == 0) {
            this.decCta = null;
        } else {
            this.decCta = nVar;
        }
        if ((i & 64) == 0) {
            this.decAppIcon = null;
        } else {
            this.decAppIcon = kVar;
        }
        if ((i & 128) == 0) {
            this.decRating = null;
        } else {
            this.decRating = oVar;
        }
        if ((i & 256) == 0) {
            this.appName = null;
        } else {
            this.appName = lVar;
        }
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final l getAppName() {
        return this.appName;
    }

    public j(String str, String str2, String str3, String str4, p pVar, n nVar, k kVar, o oVar, l lVar) {
        this.impressionTrackingUrl = str;
        this.ctaUrl = str2;
        this.ctaTrackingUrl = str3;
        this.skipToDecTrackingUrl = str4;
        this.close = pVar;
        this.decCta = nVar;
        this.decAppIcon = kVar;
        this.decRating = oVar;
        this.appName = lVar;
    }

    public /* synthetic */ j(String str, String str2, String str3, String str4, p pVar, n nVar, k kVar, o oVar, l lVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : pVar, (i & 32) != 0 ? null : nVar, (i & 64) != 0 ? null : kVar, (i & 128) != 0 ? null : oVar, (i & 256) == 0 ? lVar : null);
    }
}
