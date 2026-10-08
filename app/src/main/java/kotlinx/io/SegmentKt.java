package kotlinx.io;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Segment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\u0002H\u0001¨\u0006\r"}, d2 = {"indexOf", "", "Lkotlinx/io/Segment;", "byte", "", "startOffset", "endOffset", "indexOfBytesInbound", "bytes", "", "indexOfBytesOutbound", "isEmpty", "", "kotlinx-io-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SegmentKt {
    public static final int indexOf(Segment segment, byte b, int i, int i2) {
        Intrinsics.checkNotNullParameter(segment, "<this>");
        if (i < 0 || i >= segment.getSize()) {
            throw new IllegalArgumentException(String.valueOf(i).toString());
        }
        if (i > i2 || i2 > segment.getSize()) {
            throw new IllegalArgumentException(String.valueOf(i2).toString());
        }
        int pos = segment.getPos();
        byte[] bArrDataAsByteArray = segment.dataAsByteArray(true);
        while (i < i2) {
            if (bArrDataAsByteArray[pos + i] == b) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
    
        r11 = r11 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int indexOfBytesInbound(kotlinx.io.Segment r9, byte[] r10, int r11) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "bytes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            int r0 = r9.getSize()
            int r1 = r10.length
            int r0 = r0 - r1
            r1 = 1
            int r0 = r0 + r1
            r2 = 0
            r2 = r10[r2]
            byte[] r3 = r9.dataAsByteArray(r1)
        L19:
            r4 = -1
            if (r11 >= r0) goto L3a
            int r5 = indexOf(r9, r2, r11, r0)
            if (r5 >= 0) goto L23
            return r4
        L23:
            int r4 = r10.length
            r6 = r1
        L25:
            if (r6 >= r4) goto L39
            int r7 = r9.getPos()
            int r7 = r7 + r5
            int r7 = r7 + r6
            r7 = r3[r7]
            r8 = r10[r6]
            if (r7 == r8) goto L36
            int r11 = r11 + 1
            goto L19
        L36:
            int r6 = r6 + 1
            goto L25
        L39:
            return r5
        L3a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.io.SegmentKt.indexOfBytesInbound(kotlinx.io.Segment, byte[], int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        r13 = r13 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int indexOfBytesOutbound(kotlinx.io.Segment r11, byte[] r12, int r13) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "bytes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 0
            r1 = r12[r0]
        Ld:
            r2 = -1
            if (r13 < 0) goto L52
            int r3 = r11.getSize()
            if (r13 >= r3) goto L52
            int r3 = r11.getSize()
            int r3 = indexOf(r11, r1, r13, r3)
            if (r3 >= 0) goto L21
            return r2
        L21:
            r3 = 1
            byte[] r4 = r11.dataAsByteArray(r3)
            int r5 = r12.length
            r8 = r11
            r7 = r13
            r6 = r0
        L2a:
            if (r6 >= r5) goto L51
            r9 = r12[r6]
            int r10 = r8.getSize()
            if (r7 != r10) goto L40
            kotlinx.io.Segment r8 = r8.getNext()
            if (r8 != 0) goto L3b
            return r2
        L3b:
            byte[] r4 = r8.dataAsByteArray(r3)
            r7 = r0
        L40:
            int r10 = r8.getPos()
            int r10 = r10 + r7
            r10 = r4[r10]
            if (r9 == r10) goto L4c
            int r13 = r13 + 1
            goto Ld
        L4c:
            int r7 = r7 + 1
            int r6 = r6 + 1
            goto L2a
        L51:
            return r13
        L52:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.io.SegmentKt.indexOfBytesOutbound(kotlinx.io.Segment, byte[], int):int");
    }

    public static final boolean isEmpty(Segment segment) {
        Intrinsics.checkNotNullParameter(segment, "<this>");
        return segment.getSize() == 0;
    }
}
