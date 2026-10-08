package kotlinx.serialization.json.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.ktor.http.auth.HttpAuthHeader;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CharsetReader.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011J \u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlinx/serialization/json/internal/CharsetReader;", "", "inputStream", "Ljava/io/InputStream;", HttpAuthHeader.Parameters.Charset, "Ljava/nio/charset/Charset;", "<init>", "(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V", "decoder", "Ljava/nio/charset/CharsetDecoder;", "byteBuffer", "Ljava/nio/ByteBuffer;", "hasLeftoverPotentiallySurrogateChar", "", "leftoverChar", "", "read", "", "array", "", TypedValues.CycleType.S_WAVE_OFFSET, "length", "doRead", "fillByteBuffer", "oneShotReadSlowPath", "release", "", "kotlinx-serialization-json"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CharsetReader {
    private final ByteBuffer byteBuffer;
    private final Charset charset;
    private final CharsetDecoder decoder;
    private boolean hasLeftoverPotentiallySurrogateChar;
    private final InputStream inputStream;
    private char leftoverChar;

    public CharsetReader(InputStream inputStream, Charset charset) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(charset, "charset");
        this.inputStream = inputStream;
        this.charset = charset;
        CharsetDecoder charsetDecoderOnUnmappableCharacter = charset.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        Intrinsics.checkNotNullExpressionValue(charsetDecoderOnUnmappableCharacter, "onUnmappableCharacter(...)");
        this.decoder = charsetDecoderOnUnmappableCharacter;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(ByteArrayPool8k.INSTANCE.take());
        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(...)");
        this.byteBuffer = byteBufferWrap;
        byteBufferWrap.flip();
    }

    public final int read(char[] array, int offset, int length) {
        Intrinsics.checkNotNullParameter(array, "array");
        int i = 0;
        if (length == 0) {
            return 0;
        }
        if (offset < 0 || offset >= array.length || length < 0 || offset + length > array.length) {
            throw new IllegalArgumentException(("Unexpected arguments: " + offset + ", " + length + ", " + array.length).toString());
        }
        if (this.hasLeftoverPotentiallySurrogateChar) {
            array[offset] = this.leftoverChar;
            offset++;
            length--;
            this.hasLeftoverPotentiallySurrogateChar = false;
            if (length == 0) {
                return 1;
            }
            i = 1;
        }
        if (length == 1) {
            int iOneShotReadSlowPath = oneShotReadSlowPath();
            if (iOneShotReadSlowPath != -1) {
                array[offset] = (char) iOneShotReadSlowPath;
                return i + 1;
            }
            if (i == 0) {
                return -1;
            }
            return i;
        }
        return doRead(array, offset, length) + i;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0056 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int doRead(char[] r2, int r3, int r4) throws java.nio.charset.CharacterCodingException {
        /*
            r1 = this;
            java.nio.CharBuffer r2 = java.nio.CharBuffer.wrap(r2, r3, r4)
            int r3 = r2.position()
            if (r3 == 0) goto Le
            java.nio.CharBuffer r2 = r2.slice()
        Le:
            r3 = 0
        Lf:
            java.nio.charset.CharsetDecoder r4 = r1.decoder
            java.nio.ByteBuffer r0 = r1.byteBuffer
            java.nio.charset.CoderResult r4 = r4.decode(r0, r2, r3)
            boolean r0 = r4.isUnderflow()
            if (r0 == 0) goto L40
            if (r3 != 0) goto L49
            boolean r4 = r2.hasRemaining()
            if (r4 == 0) goto L49
            int r4 = r1.fillByteBuffer()
            if (r4 >= 0) goto Lf
            int r3 = r2.position()
            if (r3 != 0) goto L39
            java.nio.ByteBuffer r3 = r1.byteBuffer
            boolean r3 = r3.hasRemaining()
            if (r3 == 0) goto L4b
        L39:
            java.nio.charset.CharsetDecoder r3 = r1.decoder
            r3.reset()
            r3 = 1
            goto Lf
        L40:
            boolean r0 = r4.isOverflow()
            if (r0 == 0) goto L5d
            r2.position()
        L49:
            if (r3 == 0) goto L50
        L4b:
            java.nio.charset.CharsetDecoder r3 = r1.decoder
            r3.reset()
        L50:
            int r3 = r2.position()
            if (r3 != 0) goto L58
            r2 = -1
            goto L5c
        L58:
            int r2 = r2.position()
        L5c:
            return r2
        L5d:
            r4.throwException()
            goto Lf
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.CharsetReader.doRead(char[], int, int):int");
    }

    private final int fillByteBuffer() {
        this.byteBuffer.compact();
        try {
            int iLimit = this.byteBuffer.limit();
            int iPosition = this.byteBuffer.position();
            int i = this.inputStream.read(this.byteBuffer.array(), this.byteBuffer.arrayOffset() + iPosition, iPosition <= iLimit ? iLimit - iPosition : 0);
            if (i < 0) {
                return i;
            }
            ByteBuffer byteBuffer = this.byteBuffer;
            Intrinsics.checkNotNull(byteBuffer, "null cannot be cast to non-null type java.nio.Buffer");
            byteBuffer.position(iPosition + i);
            this.byteBuffer.flip();
            return this.byteBuffer.remaining();
        } finally {
            this.byteBuffer.flip();
        }
    }

    private final int oneShotReadSlowPath() {
        if (this.hasLeftoverPotentiallySurrogateChar) {
            this.hasLeftoverPotentiallySurrogateChar = false;
            return this.leftoverChar;
        }
        char[] cArr = new char[2];
        int i = read(cArr, 0, 2);
        if (i == -1) {
            return -1;
        }
        if (i == 1) {
            return cArr[0];
        }
        if (i == 2) {
            this.leftoverChar = cArr[1];
            this.hasLeftoverPotentiallySurrogateChar = true;
            return cArr[0];
        }
        throw new IllegalStateException(("Unreachable state: " + i).toString());
    }

    public final void release() {
        ByteArrayPool8k byteArrayPool8k = ByteArrayPool8k.INSTANCE;
        byte[] bArrArray = this.byteBuffer.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        byteArrayPool8k.release(bArrArray);
    }
}
