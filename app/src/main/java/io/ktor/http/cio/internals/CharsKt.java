package io.ktor.http.cio.internals;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import io.ktor.http.HttpMethod;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Chars.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\u001a'\u0010\u0004\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a/\u0010\b\u001a\u00020\u0007*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u0001H\u0082\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0013\u0010\r\u001a\u00020\f*\u00020\u0000H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0011\u0010\u000f\u001a\u00020\f*\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u000e\u001a\u0013\u0010\u0010\u001a\u00020\f*\u00020\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u001c\u0010\u0014\u001a\u00020\u0013*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0001H\u0080@¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001f\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0017\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u001c\u0010\u001e\"\u0014\u0010 \u001a\u00020\u001f8\u0000X\u0080T¢\u0006\u0006\n\u0004\b \u0010!\" \u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*\"\u001a\u0010,\u001a\u00020+8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00060"}, d2 = {"", "", TtmlNode.START, TtmlNode.END, "hashCodeLowerCase", "(Ljava/lang/CharSequence;II)I", "other", "", "equalsLowerCase", "(Ljava/lang/CharSequence;IILjava/lang/CharSequence;)Z", "toLowerCase", "(I)I", "", "parseHexLong", "(Ljava/lang/CharSequence;)J", "parseDecLong", "parseDecLongWithCheck", "Lio/ktor/utils/io/ByteWriteChannel;", "value", "", "writeIntHex", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s", "idx", "", "hexNumberFormatException", "(Ljava/lang/CharSequence;I)Ljava/lang/Void;", "cs", "numberFormatException", "(Ljava/lang/CharSequence;I)V", "(Ljava/lang/CharSequence;)V", "", "HTAB", "C", "Lio/ktor/http/cio/internals/AsciiCharTree;", "Lio/ktor/http/HttpMethod;", "DefaultHttpMethods", "Lio/ktor/http/cio/internals/AsciiCharTree;", "getDefaultHttpMethods", "()Lio/ktor/http/cio/internals/AsciiCharTree;", "", "HexTable", "[J", "", "HexLetterTable", "[B", "getHexLetterTable", "()[B", "ktor-http-cio"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CharsKt {
    private static final AsciiCharTree<HttpMethod> DefaultHttpMethods = AsciiCharTree.INSTANCE.build(HttpMethod.INSTANCE.getDefaultMethods(), new Function1() { // from class: io.ktor.http.cio.internals.CharsKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return Integer.valueOf(CharsKt.DefaultHttpMethods$lambda$0((HttpMethod) obj));
        }
    }, new Function2() { // from class: io.ktor.http.cio.internals.CharsKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return Character.valueOf(CharsKt.DefaultHttpMethods$lambda$1((HttpMethod) obj, ((Integer) obj2).intValue()));
        }
    });
    public static final char HTAB = '\t';
    private static final byte[] HexLetterTable;
    private static final long[] HexTable;

    /* JADX INFO: renamed from: io.ktor.http.cio.internals.CharsKt$writeIntHex$1, reason: invalid class name */
    /* JADX INFO: compiled from: Chars.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.internals.CharsKt", f = "Chars.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {110, 118}, m = "writeIntHex", n = {"$this$writeIntHex", "table", "current", "digits", "$this$writeIntHex", "table", "current", "digits"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CharsKt.writeIntHex(null, 0, this);
        }
    }

    private static final int toLowerCase(int i) {
        return (65 > i || i >= 91) ? i : i + 32;
    }

    public static /* synthetic */ int hashCodeLowerCase$default(CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = charSequence.length();
        }
        return hashCodeLowerCase(charSequence, i, i2);
    }

    public static final int hashCodeLowerCase(CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int i3 = 0;
        while (i < i2) {
            int iCharAt = charSequence.charAt(i);
            if (65 <= iCharAt && iCharAt < 91) {
                iCharAt += 32;
            }
            i3 = (i3 * 31) + iCharAt;
            i++;
        }
        return i3;
    }

    public static /* synthetic */ boolean equalsLowerCase$default(CharSequence charSequence, int i, int i2, CharSequence charSequence2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = charSequence.length();
        }
        return equalsLowerCase(charSequence, i, i2, charSequence2);
    }

    public static final boolean equalsLowerCase(CharSequence charSequence, int i, int i2, CharSequence other) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (i2 - i != other.length()) {
            return false;
        }
        for (int i3 = i; i3 < i2; i3++) {
            int iCharAt = charSequence.charAt(i3);
            if (65 <= iCharAt && iCharAt < 91) {
                iCharAt += 32;
            }
            int iCharAt2 = other.charAt(i3 - i);
            if (65 <= iCharAt2 && iCharAt2 < 91) {
                iCharAt2 += 32;
            }
            if (iCharAt != iCharAt2) {
                return false;
            }
        }
        return true;
    }

    public static final AsciiCharTree<HttpMethod> getDefaultHttpMethods() {
        return DefaultHttpMethods;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005a A[PHI: r6
  0x005a: PHI (r6v2 long) = (r6v1 long), (r6v0 long) binds: [B:18:0x0068, B:13:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
    static {
        /*
            io.ktor.http.cio.internals.AsciiCharTree$Companion r0 = io.ktor.http.cio.internals.AsciiCharTree.INSTANCE
            io.ktor.http.HttpMethod$Companion r1 = io.ktor.http.HttpMethod.INSTANCE
            java.util.List r1 = r1.getDefaultMethods()
            io.ktor.http.cio.internals.CharsKt$$ExternalSyntheticLambda0 r2 = new io.ktor.http.cio.internals.CharsKt$$ExternalSyntheticLambda0
            r2.<init>()
            io.ktor.http.cio.internals.CharsKt$$ExternalSyntheticLambda1 r3 = new io.ktor.http.cio.internals.CharsKt$$ExternalSyntheticLambda1
            r3.<init>()
            io.ktor.http.cio.internals.AsciiCharTree r0 = r0.build(r1, r2, r3)
            io.ktor.http.cio.internals.CharsKt.DefaultHttpMethods = r0
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            r1 = 255(0xff, float:3.57E-43)
            r2 = 0
            r0.<init>(r2, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r3 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r3)
            r1.<init>(r4)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L33:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L75
            r4 = r0
            kotlin.collections.IntIterator r4 = (kotlin.collections.IntIterator) r4
            int r4 = r4.nextInt()
            r5 = 48
            if (r5 > r4) goto L4d
            r5 = 58
            if (r4 >= r5) goto L4d
            long r4 = (long) r4
            r6 = 48
            long r4 = r4 - r6
            goto L6d
        L4d:
            long r4 = (long) r4
            r6 = 97
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L5e
            r8 = 102(0x66, double:5.04E-322)
            int r8 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r8 > 0) goto L5e
        L5a:
            long r4 = r4 - r6
            long r6 = (long) r3
            long r4 = r4 + r6
            goto L6d
        L5e:
            r6 = 65
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L6b
            r8 = 70
            int r8 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r8 > 0) goto L6b
            goto L5a
        L6b:
            r4 = -1
        L6d:
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.add(r4)
            goto L33
        L75:
            java.util.List r1 = (java.util.List) r1
            java.util.Collection r1 = (java.util.Collection) r1
            long[] r0 = kotlin.collections.CollectionsKt.toLongArray(r1)
            io.ktor.http.cio.internals.CharsKt.HexTable = r0
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            r1 = 15
            r0.<init>(r2, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r3)
            r1.<init>(r2)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L97:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto Lb7
            r2 = r0
            kotlin.collections.IntIterator r2 = (kotlin.collections.IntIterator) r2
            int r2 = r2.nextInt()
            if (r2 >= r3) goto La9
            int r2 = r2 + 48
            goto Lae
        La9:
            int r2 = r2 + 97
            char r2 = (char) r2
            int r2 = r2 - r3
            char r2 = (char) r2
        Lae:
            byte r2 = (byte) r2
            java.lang.Byte r2 = java.lang.Byte.valueOf(r2)
            r1.add(r2)
            goto L97
        Lb7:
            java.util.List r1 = (java.util.List) r1
            java.util.Collection r1 = (java.util.Collection) r1
            byte[] r0 = kotlin.collections.CollectionsKt.toByteArray(r1)
            io.ktor.http.cio.internals.CharsKt.HexLetterTable = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.internals.CharsKt.<clinit>():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int DefaultHttpMethods$lambda$0(HttpMethod it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getValue().length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final char DefaultHttpMethods$lambda$1(HttpMethod m, int i) {
        Intrinsics.checkNotNullParameter(m, "m");
        return m.getValue().charAt(i);
    }

    public static final byte[] getHexLetterTable() {
        return HexLetterTable;
    }

    public static final long parseHexLong(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        long[] jArr = HexTable;
        int length = charSequence.length();
        long j = 0;
        for (int i = 0; i < length; i++) {
            int iCharAt = charSequence.charAt(i) & CharCompanionObject.MAX_VALUE;
            long j2 = iCharAt < 255 ? jArr[iCharAt] : -1L;
            if (j2 == -1) {
                hexNumberFormatException(charSequence, i);
                throw new KotlinNothingValueException();
            }
            j = (j << 4) | j2;
        }
        return j;
    }

    public static final long parseDecLong(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length();
        if (length > 19) {
            numberFormatException(charSequence);
        }
        if (length == 19) {
            return parseDecLongWithCheck(charSequence);
        }
        long j = 0;
        for (int i = 0; i < length; i++) {
            long jCharAt = ((long) charSequence.charAt(i)) - 48;
            if (jCharAt < 0 || jCharAt > 9) {
                numberFormatException(charSequence, i);
            }
            j = (j << 3) + (j << 1) + jCharAt;
        }
        return j;
    }

    private static final long parseDecLongWithCheck(CharSequence charSequence) {
        int length = charSequence.length();
        long j = 0;
        for (int i = 0; i < length; i++) {
            long jCharAt = ((long) charSequence.charAt(i)) - 48;
            if (jCharAt < 0 || jCharAt > 9) {
                numberFormatException(charSequence, i);
            }
            j = (j << 3) + (j << 1) + jCharAt;
            if (j < 0) {
                numberFormatException(charSequence);
            }
        }
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object writeIntHex(io.ktor.utils.io.ByteWriteChannel r7, int r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.http.cio.internals.CharsKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.http.cio.internals.CharsKt$writeIntHex$1 r0 = (io.ktor.http.cio.internals.CharsKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.http.cio.internals.CharsKt$writeIntHex$1 r0 = new io.ktor.http.cio.internals.CharsKt$writeIntHex$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 8
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L46
            if (r2 == r5) goto L34
            if (r2 != r4) goto L2c
            goto L34
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            int r7 = r0.I$1
            int r8 = r0.I$0
            java.lang.Object r2 = r0.L$1
            byte[] r2 = (byte[]) r2
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r5 = (io.ktor.utils.io.ByteWriteChannel) r5
            kotlin.ResultKt.throwOnFailure(r9)
            r6 = r7
            r7 = r5
            goto L6d
        L46:
            kotlin.ResultKt.throwOnFailure(r9)
            if (r8 <= 0) goto L8d
            byte[] r2 = io.ktor.http.cio.internals.CharsKt.HexLetterTable
            r9 = 0
        L4e:
            int r6 = r9 + 1
            if (r9 >= r3) goto L6d
            int r9 = r8 >>> 28
            int r8 = r8 << 4
            if (r9 == 0) goto L6b
            r9 = r2[r9]
            r0.L$0 = r7
            r0.L$1 = r2
            r0.I$0 = r8
            r0.I$1 = r6
            r0.label = r5
            java.lang.Object r9 = io.ktor.utils.io.ByteWriteChannelOperationsKt.writeByte(r7, r9, r0)
            if (r9 != r1) goto L6d
            return r1
        L6b:
            r9 = r6
            goto L4e
        L6d:
            int r9 = r6 + 1
            if (r6 >= r3) goto L8a
            int r5 = r8 >>> 28
            int r8 = r8 << 4
            r5 = r2[r5]
            r0.L$0 = r7
            r0.L$1 = r2
            r0.I$0 = r8
            r0.I$1 = r9
            r0.label = r4
            java.lang.Object r5 = io.ktor.utils.io.ByteWriteChannelOperationsKt.writeByte(r7, r5, r0)
            if (r5 != r1) goto L88
            return r1
        L88:
            r6 = r9
            goto L6d
        L8a:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L8d:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Does only work for positive numbers"
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.internals.CharsKt.writeIntHex(io.ktor.utils.io.ByteWriteChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Void hexNumberFormatException(CharSequence charSequence, int i) {
        throw new NumberFormatException("Invalid HEX number: " + ((Object) charSequence) + ", wrong digit: " + charSequence.charAt(i));
    }

    private static final void numberFormatException(CharSequence charSequence, int i) {
        throw new NumberFormatException("Invalid number: " + ((Object) charSequence) + ", wrong digit: " + charSequence.charAt(i) + " at position " + i);
    }

    private static final void numberFormatException(CharSequence charSequence) {
        throw new NumberFormatException("Invalid number " + ((Object) charSequence) + ": too large for Long type");
    }
}
