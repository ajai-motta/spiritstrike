package com.moloco.sdk.internal.ilrd;

import com.adxcorp.ads.mediation.util.ReportUtil;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.ilrd.c;
import com.moloco.sdk.internal.services.I;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    public static final C0381a g = new C0381a(null);
    public static final int h = 8;
    public static final String i = "IlrdActiveSession";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f2071a;
    public final c b;
    public final Lazy c;
    public final long d;
    public final AtomicReference<b> e;
    public boolean f;

    /* JADX INFO: renamed from: com.moloco.sdk.internal.ilrd.a$a, reason: collision with other inner class name */
    public static final class C0381a {
        public /* synthetic */ C0381a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public C0381a() {
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0002\u0016\u0019B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bBK\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\n\u0010\u000fJ'\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001aJ\u0010\u0010\u001d\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001aJ\u0010\u0010\u001e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001aJL\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004HÇ\u0001¢\u0006\u0004\b\u0016\u0010\u001fJ\u0010\u0010!\u001a\u00020 H×\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b#\u0010\u001aJ\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010\u0001H×\u0003¢\u0006\u0004\b&\u0010'R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b)\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010*\u001a\u0004\b+\u0010\u001aR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001b\u0010*\u001a\u0004\b,\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010*\u001a\u0004\b-\u0010\u001aR\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001d\u0010*\u001a\u0004\b.\u0010\u001aR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010*\u001a\u0004\b/\u0010\u001a¨\u00061"}, d2 = {"Lcom/moloco/sdk/internal/ilrd/a$b;", "", "", "lastEventReceivedTs", "", ReportUtil.INVENTORY_TYPE_BANNER, "mrec", "native", ReportUtil.INVENTORY_TYPE_INTERSTITIAL, "rewarded", "<init>", "(JIIIII)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IJIIIIILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "a", "(Lcom/moloco/sdk/internal/ilrd/a$b;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "()J", "b", "()I", "c", "d", "e", InneractiveMediationDefs.GENDER_FEMALE, "(JIIIII)Lcom/moloco/sdk/internal/ilrd/a$b;", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "i", "I", "g", "j", "k", "h", "l", k.M, "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
    @Serializable
    public static final /* data */ class b {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int g = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final long lastEventReceivedTs;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final int banner;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public final int mrec;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        public final int native;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        public final int interstitial;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        public final int rewarded;

        /* JADX INFO: renamed from: com.moloco.sdk.internal.ilrd.a$b$a, reason: collision with other inner class name */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class C0382a implements GeneratedSerializer<b> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0382a f2073a;
            public static final int b;
            private static final SerialDescriptor descriptor;

            static {
                C0382a c0382a = new C0382a();
                f2073a = c0382a;
                b = 8;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ilrd.IlrdActiveSession.ImpressionCounts", c0382a, 6);
                pluginGeneratedSerialDescriptor.addElement("lastEventReceivedTs", false);
                pluginGeneratedSerialDescriptor.addElement(ReportUtil.INVENTORY_TYPE_BANNER, false);
                pluginGeneratedSerialDescriptor.addElement("mrec", false);
                pluginGeneratedSerialDescriptor.addElement("native", false);
                pluginGeneratedSerialDescriptor.addElement(ReportUtil.INVENTORY_TYPE_INTERSTITIAL, false);
                pluginGeneratedSerialDescriptor.addElement("rewarded", false);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            @Override // kotlinx.serialization.DeserializationStrategy
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final b deserialize(Decoder decoder) {
                int iDecodeIntElement;
                int i;
                int i2;
                int i3;
                int i4;
                int i5;
                long j;
                Intrinsics.checkNotNullParameter(decoder, "decoder");
                SerialDescriptor serialDescriptor = descriptor;
                CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
                if (compositeDecoderBeginStructure.decodeSequentially()) {
                    long jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 0);
                    int iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 1);
                    int iDecodeIntElement3 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 2);
                    int iDecodeIntElement4 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 3);
                    int iDecodeIntElement5 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 4);
                    i2 = iDecodeIntElement2;
                    iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 5);
                    i3 = iDecodeIntElement4;
                    i = iDecodeIntElement5;
                    i4 = iDecodeIntElement3;
                    i5 = 63;
                    j = jDecodeLongElement;
                } else {
                    boolean z = true;
                    int iDecodeIntElement6 = 0;
                    int iDecodeIntElement7 = 0;
                    int iDecodeIntElement8 = 0;
                    int i6 = 0;
                    long jDecodeLongElement2 = 0;
                    int iDecodeIntElement9 = 0;
                    int iDecodeIntElement10 = 0;
                    while (z) {
                        int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                        switch (iDecodeElementIndex) {
                            case -1:
                                z = false;
                                continue;
                            case 0:
                                jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 0);
                                i6 |= 1;
                                continue;
                            case 1:
                                iDecodeIntElement6 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 1);
                                i6 |= 2;
                                break;
                            case 2:
                                iDecodeIntElement8 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 2);
                                i6 |= 4;
                                break;
                            case 3:
                                iDecodeIntElement10 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 3);
                                i6 |= 8;
                                break;
                            case 4:
                                iDecodeIntElement7 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 4);
                                i6 |= 16;
                                break;
                            case 5:
                                iDecodeIntElement9 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 5);
                                i6 |= 32;
                                break;
                            default:
                                throw new UnknownFieldException(iDecodeElementIndex);
                        }
                    }
                    iDecodeIntElement = iDecodeIntElement9;
                    i = iDecodeIntElement7;
                    int i7 = i6;
                    i2 = iDecodeIntElement6;
                    long j2 = jDecodeLongElement2;
                    i3 = iDecodeIntElement10;
                    i4 = iDecodeIntElement8;
                    i5 = i7;
                    j = j2;
                }
                compositeDecoderBeginStructure.endStructure(serialDescriptor);
                return new b(i5, j, i2, i4, i3, i, iDecodeIntElement, null);
            }

            @Override // kotlinx.serialization.internal.GeneratedSerializer
            public final KSerializer<?>[] childSerializers() {
                IntSerializer intSerializer = IntSerializer.INSTANCE;
                return new KSerializer[]{LongSerializer.INSTANCE, intSerializer, intSerializer, intSerializer, intSerializer, intSerializer};
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
            public final void serialize(Encoder encoder, b value) {
                Intrinsics.checkNotNullParameter(encoder, "encoder");
                Intrinsics.checkNotNullParameter(value, "value");
                SerialDescriptor serialDescriptor = descriptor;
                CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
                b.a(value, compositeEncoderBeginStructure, serialDescriptor);
                compositeEncoderBeginStructure.endStructure(serialDescriptor);
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.internal.ilrd.a$b$b, reason: collision with other inner class name and from kotlin metadata */
        public static final class Companion {
            public Companion() {
            }

            public final KSerializer<b> serializer() {
                return C0382a.f2073a;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ b(int i, long j, int i2, int i3, int i4, int i5, int i6, SerializationConstructorMarker serializationConstructorMarker) {
            if (63 != (i & 63)) {
                PluginExceptionsKt.throwMissingFieldException(i, 63, C0382a.f2073a.getDescriptor());
            }
            this.lastEventReceivedTs = j;
            this.banner = i2;
            this.mrec = i3;
            this.native = i4;
            this.interstitial = i5;
            this.rewarded = i6;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final long getLastEventReceivedTs() {
            return this.lastEventReceivedTs;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final int getBanner() {
            return this.banner;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final int getMrec() {
            return this.mrec;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final int getNative() {
            return this.native;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final int getInterstitial() {
            return this.interstitial;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            return this.lastEventReceivedTs == bVar.lastEventReceivedTs && this.banner == bVar.banner && this.mrec == bVar.mrec && this.native == bVar.native && this.interstitial == bVar.interstitial && this.rewarded == bVar.rewarded;
        }

        /* JADX INFO: renamed from: f, reason: from getter */
        public final int getRewarded() {
            return this.rewarded;
        }

        public final int g() {
            return this.banner;
        }

        public final int h() {
            return this.interstitial;
        }

        public int hashCode() {
            return (((((((((UByte$$ExternalSyntheticBackport0.m(this.lastEventReceivedTs) * 31) + this.banner) * 31) + this.mrec) * 31) + this.native) * 31) + this.interstitial) * 31) + this.rewarded;
        }

        public final long i() {
            return this.lastEventReceivedTs;
        }

        public final int j() {
            return this.mrec;
        }

        public final int k() {
            return this.native;
        }

        public final int l() {
            return this.rewarded;
        }

        public String toString() {
            return "ImpressionCounts(lastEventReceivedTs=" + this.lastEventReceivedTs + ", banner=" + this.banner + ", mrec=" + this.mrec + ", native=" + this.native + ", interstitial=" + this.interstitial + ", rewarded=" + this.rewarded + ')';
        }

        public b(long j, int i, int i2, int i3, int i4, int i5) {
            this.lastEventReceivedTs = j;
            this.banner = i;
            this.mrec = i2;
            this.native = i3;
            this.interstitial = i4;
            this.rewarded = i5;
        }

        public final b a(long lastEventReceivedTs, int banner, int mrec, int i, int interstitial, int rewarded) {
            return new b(lastEventReceivedTs, banner, mrec, i, interstitial, rewarded);
        }

        public static /* synthetic */ b a(b bVar, long j, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
            return bVar.a((i6 & 1) != 0 ? bVar.lastEventReceivedTs : j, (i6 & 2) != 0 ? bVar.banner : i, (i6 & 4) != 0 ? bVar.mrec : i2, (i6 & 8) != 0 ? bVar.native : i3, (i6 & 16) != 0 ? bVar.interstitial : i4, (i6 & 32) != 0 ? bVar.rewarded : i5);
        }

        @JvmStatic
        public static final /* synthetic */ void a(b self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeLongElement(serialDesc, 0, self.lastEventReceivedTs);
            output.encodeIntElement(serialDesc, 1, self.banner);
            output.encodeIntElement(serialDesc, 2, self.mrec);
            output.encodeIntElement(serialDesc, 3, self.native);
            output.encodeIntElement(serialDesc, 4, self.interstitial);
            output.encodeIntElement(serialDesc, 5, self.rewarded);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001a\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0002\u0017\u001aB'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB?\b\u0010\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u0010J'\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ8\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bHÇ\u0001¢\u0006\u0004\b\u0017\u0010 J\u0010\u0010!\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b!\u0010\u0019J\u0010\u0010\"\u001a\u00020\fH×\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010%\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0001H×\u0003¢\u0006\u0004\b%\u0010&R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b(\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001a\u0010)\u001a\u0004\b*\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001c\u0010+\u001a\u0004\b,\u0010\u001dR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001e\u0010-\u001a\u0004\b.\u0010\u001f¨\u00060"}, d2 = {"Lcom/moloco/sdk/internal/ilrd/a$c;", "", "", JsonStorageKeyNames.SESSION_ID_KEY, "Lcom/moloco/sdk/internal/ilrd/a$b;", "impressionCounts", "", "isExpired", "", "sessionStartTs", "<init>", "(Ljava/lang/String;Lcom/moloco/sdk/internal/ilrd/a$b;ZJ)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Lcom/moloco/sdk/internal/ilrd/a$b;ZJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "a", "(Lcom/moloco/sdk/internal/ilrd/a$c;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "()Ljava/lang/String;", "b", "()Lcom/moloco/sdk/internal/ilrd/a$b;", "c", "()Z", "d", "()J", "(Ljava/lang/String;Lcom/moloco/sdk/internal/ilrd/a$b;ZJ)Lcom/moloco/sdk/internal/ilrd/a$c;", InAppPurchaseConstants.METHOD_TO_STRING, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/moloco/sdk/internal/ilrd/a$b;", "e", "Z", "h", "J", "g", k.M, "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
    @Serializable
    public static final /* data */ class c {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int e = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final String sessionId;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final b impressionCounts;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public final boolean isExpired;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        public final long sessionStartTs;

        /* JADX INFO: renamed from: com.moloco.sdk.internal.ilrd.a$c$a, reason: collision with other inner class name */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class C0384a implements GeneratedSerializer<c> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0384a f2075a;
            public static final int b;
            private static final SerialDescriptor descriptor;

            static {
                C0384a c0384a = new C0384a();
                f2075a = c0384a;
                b = 8;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ilrd.IlrdActiveSession.SessionData", c0384a, 4);
                pluginGeneratedSerialDescriptor.addElement(JsonStorageKeyNames.SESSION_ID_KEY, false);
                pluginGeneratedSerialDescriptor.addElement("impressionCounts", false);
                pluginGeneratedSerialDescriptor.addElement("isExpired", false);
                pluginGeneratedSerialDescriptor.addElement("sessionStartTs", false);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            @Override // kotlinx.serialization.DeserializationStrategy
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final c deserialize(Decoder decoder) {
                int i;
                boolean zDecodeBooleanElement;
                long jDecodeLongElement;
                String str;
                b bVar;
                Intrinsics.checkNotNullParameter(decoder, "decoder");
                SerialDescriptor serialDescriptor = descriptor;
                CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
                if (compositeDecoderBeginStructure.decodeSequentially()) {
                    String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    b bVar2 = (b) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, b.C0382a.f2073a, null);
                    str = strDecodeStringElement;
                    i = 15;
                    zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 2);
                    bVar = bVar2;
                    jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 3);
                } else {
                    long jDecodeLongElement2 = 0;
                    boolean z = true;
                    int i2 = 0;
                    String strDecodeStringElement2 = null;
                    b bVar3 = null;
                    boolean zDecodeBooleanElement2 = false;
                    while (z) {
                        int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                        if (iDecodeElementIndex == -1) {
                            z = false;
                        } else if (iDecodeElementIndex == 0) {
                            strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                            i2 |= 1;
                        } else if (iDecodeElementIndex == 1) {
                            bVar3 = (b) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, b.C0382a.f2073a, bVar3);
                            i2 |= 2;
                        } else if (iDecodeElementIndex == 2) {
                            zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 2);
                            i2 |= 4;
                        } else {
                            if (iDecodeElementIndex != 3) {
                                throw new UnknownFieldException(iDecodeElementIndex);
                            }
                            jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 3);
                            i2 |= 8;
                        }
                    }
                    i = i2;
                    zDecodeBooleanElement = zDecodeBooleanElement2;
                    jDecodeLongElement = jDecodeLongElement2;
                    str = strDecodeStringElement2;
                    bVar = bVar3;
                }
                compositeDecoderBeginStructure.endStructure(serialDescriptor);
                return new c(i, str, bVar, zDecodeBooleanElement, jDecodeLongElement, null);
            }

            @Override // kotlinx.serialization.internal.GeneratedSerializer
            public final KSerializer<?>[] childSerializers() {
                return new KSerializer[]{StringSerializer.INSTANCE, b.C0382a.f2073a, BooleanSerializer.INSTANCE, LongSerializer.INSTANCE};
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

        /* JADX INFO: renamed from: com.moloco.sdk.internal.ilrd.a$c$b, reason: from kotlin metadata */
        public static final class Companion {
            public Companion() {
            }

            public final KSerializer<c> serializer() {
                return C0384a.f2075a;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ c(int i, String str, b bVar, boolean z, long j, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i, 15, C0384a.f2075a.getDescriptor());
            }
            this.sessionId = str;
            this.impressionCounts = bVar;
            this.isExpired = z;
            this.sessionStartTs = j;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final b getImpressionCounts() {
            return this.impressionCounts;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final boolean getIsExpired() {
            return this.isExpired;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final long getSessionStartTs() {
            return this.sessionStartTs;
        }

        public final b e() {
            return this.impressionCounts;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            return Intrinsics.areEqual(this.sessionId, cVar.sessionId) && Intrinsics.areEqual(this.impressionCounts, cVar.impressionCounts) && this.isExpired == cVar.isExpired && this.sessionStartTs == cVar.sessionStartTs;
        }

        public final String f() {
            return this.sessionId;
        }

        public final long g() {
            return this.sessionStartTs;
        }

        public final boolean h() {
            return this.isExpired;
        }

        public int hashCode() {
            return (((((this.sessionId.hashCode() * 31) + this.impressionCounts.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.isExpired)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.sessionStartTs);
        }

        public String toString() {
            return "SessionData(sessionId=" + this.sessionId + ", impressionCounts=" + this.impressionCounts + ", isExpired=" + this.isExpired + ", sessionStartTs=" + this.sessionStartTs + ')';
        }

        public c(String sessionId, b impressionCounts, boolean z, long j) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(impressionCounts, "impressionCounts");
            this.sessionId = sessionId;
            this.impressionCounts = impressionCounts;
            this.isExpired = z;
            this.sessionStartTs = j;
        }

        public final c a(String sessionId, b impressionCounts, boolean isExpired, long sessionStartTs) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(impressionCounts, "impressionCounts");
            return new c(sessionId, impressionCounts, isExpired, sessionStartTs);
        }

        public static /* synthetic */ c a(c cVar, String str, b bVar, boolean z, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cVar.sessionId;
            }
            if ((i & 2) != 0) {
                bVar = cVar.impressionCounts;
            }
            b bVar2 = bVar;
            if ((i & 4) != 0) {
                z = cVar.isExpired;
            }
            boolean z2 = z;
            if ((i & 8) != 0) {
                j = cVar.sessionStartTs;
            }
            return cVar.a(str, bVar2, z2, j);
        }

        @JvmStatic
        public static final /* synthetic */ void a(c self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.sessionId);
            output.encodeSerializableElement(serialDesc, 1, b.C0382a.f2073a, self.impressionCounts);
            output.encodeBooleanElement(serialDesc, 2, self.isExpired);
            output.encodeLongElement(serialDesc, 3, self.sessionStartTs);
        }
    }

    public a(I timeProvider, String str) {
        b bVarE;
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this.f2071a = timeProvider;
        c cVar = null;
        if (str != null) {
            try {
                Json.Companion companion = Json.INSTANCE;
                companion.getSerializersModule();
                cVar = (c) companion.decodeFromString(c.INSTANCE.serializer(), str);
            } catch (Exception e) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, i, "Error deserializing session data", e, false, 8, null);
            }
        }
        this.b = cVar;
        this.c = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.ilrd.a$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.a(this.f$0);
            }
        });
        this.d = cVar != null ? cVar.g() : this.f2071a.a();
        this.e = new AtomicReference<>((cVar == null || (bVarE = cVar.e()) == null) ? new b(-1L, 0, 0, 0, 0, 0) : bVarE);
        this.f = cVar != null ? cVar.h() : false;
    }

    public static final String a(a aVar) {
        String strF;
        c cVar = aVar.b;
        if (cVar != null && (strF = cVar.f()) != null) {
            return strF;
        }
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final b b() {
        b bVar = this.e.get();
        Intrinsics.checkNotNullExpressionValue(bVar, "get(...)");
        return bVar;
    }

    public final String c() {
        return (String) this.c.getValue();
    }

    public final long d() {
        return this.d;
    }

    public final boolean e() {
        return this.f;
    }

    public final String f() {
        return Json.INSTANCE.encodeToString(c.INSTANCE.serializer(), new c(c(), b(), e(), this.d));
    }

    public String toString() {
        b bVarB = b();
        return "IlrdActiveSession(id=" + c() + ", startTs=" + this.d + ", expired=" + e() + ", impressions=" + (bVarB.g() + bVarB.j() + bVarB.k() + bVarB.h() + bVarB.l()) + " [banner=" + bVarB.g() + ", mrec=" + bVarB.j() + ", native=" + bVarB.k() + ", interstitial=" + bVarB.h() + ", rewarded=" + bVarB.l() + "])";
    }

    public final void a(c.a ilrdData) {
        Intrinsics.checkNotNullParameter(ilrdData, "ilrdData");
        if (ilrdData instanceof c.a.b) {
            String adFormat = ((c.a.b) ilrdData).b().getAdFormat();
            Intrinsics.checkNotNullExpressionValue(adFormat, "getAdFormat(...)");
            String upperCase = adFormat.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            a(upperCase, "Applovin");
            return;
        }
        if (!(ilrdData instanceof c.a.C0385a)) {
            throw new NoWhenBranchMatchedException();
        }
        String adFormat2 = ((c.a.C0385a) ilrdData).b().getAdFormat();
        Intrinsics.checkNotNullExpressionValue(adFormat2, "getAdFormat(...)");
        String upperCase2 = adFormat2.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
        a(upperCase2, "Ironsource");
    }

    public final boolean a(String str, String str2) {
        b bVarA;
        long jA = this.f2071a.a();
        b bVar = this.e.get();
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "BANNER", false, 2, (Object) null)) {
            bVarA = b.a(bVar, jA, bVar.g() + 1, 0, 0, 0, 0, 60, null);
        } else if (StringsKt.contains$default((CharSequence) str, (CharSequence) "MREC", false, 2, (Object) null)) {
            bVarA = b.a(bVar, jA, 0, bVar.j() + 1, 0, 0, 0, 58, null);
        } else if (StringsKt.contains$default((CharSequence) str, (CharSequence) "NATIVE", false, 2, (Object) null)) {
            bVarA = b.a(bVar, jA, 0, 0, bVar.k() + 1, 0, 0, 54, null);
        } else if (StringsKt.contains$default((CharSequence) str, (CharSequence) "INTER", false, 2, (Object) null)) {
            bVarA = b.a(bVar, jA, 0, 0, 0, bVar.h() + 1, 0, 46, null);
        } else if (StringsKt.contains$default((CharSequence) str, (CharSequence) "REWARD", false, 2, (Object) null)) {
            bVarA = b.a(bVar, jA, 0, 0, 0, 0, bVar.l() + 1, 30, null);
        } else {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, i, "Unknown ad format for " + str2 + ": " + str, null, false, 12, null);
            return false;
        }
        this.e.set(bVarA);
        return true;
    }

    public final void a() {
        this.f = true;
    }

    public /* synthetic */ a(I i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, (i3 & 2) != 0 ? null : str);
    }
}
