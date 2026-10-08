package kotlinx.serialization.encoding;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: Encoding.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0017J\b\u0010\b\u001a\u00020\u0007H'J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u001bH&J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0013H&J\u0010\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u001eH&J\u0010\u0010\"\u001a\u00020#2\u0006\u0010!\u001a\u00020\u001eH&J\u0018\u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0013H\u0016J/\u0010&\u001a\u00020\u0007\"\n\b\u0000\u0010'*\u0004\u0018\u00010\u00012\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\u0006\u0010\n\u001a\u0002H'H\u0016¢\u0006\u0002\u0010*J/\u0010+\u001a\u00020\u0007\"\b\b\u0000\u0010'*\u00020\u00012\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\b\u0010\n\u001a\u0004\u0018\u0001H'H\u0017¢\u0006\u0002\u0010*R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006,À\u0006\u0003"}, d2 = {"Lkotlinx/serialization/encoding/Encoder;", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "encodeNotNullMark", "", "encodeNull", "encodeBoolean", "value", "", "encodeByte", "", "encodeShort", "", "encodeChar", "", "encodeInt", "", "encodeLong", "", "encodeFloat", "", "encodeDouble", "", "encodeString", "", "encodeEnum", "enumDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", FirebaseAnalytics.Param.INDEX, "encodeInline", "descriptor", "beginStructure", "Lkotlinx/serialization/encoding/CompositeEncoder;", "beginCollection", "collectionSize", "encodeSerializableValue", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeNullableSerializableValue", "kotlinx-serialization-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface Encoder {
    CompositeEncoder beginCollection(SerialDescriptor descriptor, int collectionSize);

    CompositeEncoder beginStructure(SerialDescriptor descriptor);

    void encodeBoolean(boolean value);

    void encodeByte(byte value);

    void encodeChar(char value);

    void encodeDouble(double value);

    void encodeEnum(SerialDescriptor enumDescriptor, int index);

    void encodeFloat(float value);

    Encoder encodeInline(SerialDescriptor descriptor);

    void encodeInt(int value);

    void encodeLong(long value);

    @ExperimentalSerializationApi
    void encodeNotNullMark();

    @ExperimentalSerializationApi
    void encodeNull();

    @ExperimentalSerializationApi
    <T> void encodeNullableSerializableValue(SerializationStrategy<? super T> serializer, T value);

    <T> void encodeSerializableValue(SerializationStrategy<? super T> serializer, T value);

    void encodeShort(short value);

    void encodeString(String value);

    SerializersModule getSerializersModule();

    /* JADX INFO: renamed from: kotlinx.serialization.encoding.Encoder$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: Encoding.kt */
    public final /* synthetic */ class CC {
        @ExperimentalSerializationApi
        public static void $default$encodeNotNullMark(Encoder _this) {
        }

        public static CompositeEncoder $default$beginCollection(Encoder _this, SerialDescriptor descriptor, int i) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return _this.beginStructure(descriptor);
        }

        public static void $default$encodeSerializableValue(Encoder _this, SerializationStrategy serializer, Object obj) {
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            serializer.serialize(_this, obj);
        }

        @ExperimentalSerializationApi
        public static void $default$encodeNullableSerializableValue(Encoder _this, SerializationStrategy serializer, Object obj) {
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            if (serializer.getDescriptor().isNullable()) {
                _this.encodeSerializableValue(serializer, obj);
            } else if (obj == null) {
                _this.encodeNull();
            } else {
                _this.encodeNotNullMark();
                _this.encodeSerializableValue(serializer, obj);
            }
        }
    }

    /* JADX INFO: compiled from: Encoding.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        @ExperimentalSerializationApi
        @Deprecated
        public static void encodeNotNullMark(Encoder encoder) {
            CC.$default$encodeNotNullMark(encoder);
        }

        @Deprecated
        public static CompositeEncoder beginCollection(Encoder encoder, SerialDescriptor descriptor, int i) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return CC.$default$beginCollection(encoder, descriptor, i);
        }

        @Deprecated
        public static <T> void encodeSerializableValue(Encoder encoder, SerializationStrategy<? super T> serializer, T t) {
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            CC.$default$encodeSerializableValue(encoder, serializer, t);
        }

        @ExperimentalSerializationApi
        @Deprecated
        public static <T> void encodeNullableSerializableValue(Encoder encoder, SerializationStrategy<? super T> serializer, T t) {
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            CC.$default$encodeNullableSerializableValue(encoder, serializer, t);
        }
    }
}
