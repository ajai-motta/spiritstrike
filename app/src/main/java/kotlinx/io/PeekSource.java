package kotlinx.io;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PeekSource.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkotlinx/io/PeekSource;", "Lkotlinx/io/RawSource;", "upstream", "Lkotlinx/io/Source;", "<init>", "(Lkotlinx/io/Source;)V", "buffer", "Lkotlinx/io/Buffer;", "getBuffer$annotations", "()V", "expectedSegment", "Lkotlinx/io/Segment;", "expectedPos", "", "closed", "", "pos", "", "readAtMostTo", "sink", "byteCount", "close", "", "kotlinx-io-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PeekSource implements RawSource {
    private final Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private Segment expectedSegment;
    private long pos;
    private final Source upstream;

    private static /* synthetic */ void getBuffer$annotations() {
    }

    public PeekSource(Source upstream) {
        Intrinsics.checkNotNullParameter(upstream, "upstream");
        this.upstream = upstream;
        Buffer buffer = upstream.getBufferField();
        this.buffer = buffer;
        this.expectedSegment = buffer.getHead();
        Segment head = buffer.getHead();
        this.expectedPos = head != null ? head.getPos() : -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002c, code lost:
    
        if (r3 == r4.getPos()) goto L15;
     */
    @Override // kotlinx.io.RawSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readAtMostTo(kotlinx.io.Buffer r7, long r8) {
        /*
            r6 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            boolean r0 = r6.closed
            r0 = r0 ^ 1
            if (r0 == 0) goto Lab
            r0 = 0
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 < 0) goto L8e
            kotlinx.io.Segment r3 = r6.expectedSegment
            if (r3 == 0) goto L3b
            kotlinx.io.Buffer r4 = r6.buffer
            kotlinx.io.Segment r4 = r4.getHead()
            if (r3 != r4) goto L2f
            int r3 = r6.expectedPos
            kotlinx.io.Buffer r4 = r6.buffer
            kotlinx.io.Segment r4 = r4.getHead()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r4 = r4.getPos()
            if (r3 != r4) goto L2f
            goto L3b
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Peek source is invalid because upstream source was used"
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L3b:
            if (r2 != 0) goto L3e
            return r0
        L3e:
            kotlinx.io.Source r0 = r6.upstream
            long r1 = r6.pos
            r3 = 1
            long r1 = r1 + r3
            boolean r0 = r0.request(r1)
            if (r0 != 0) goto L4e
            r7 = -1
            return r7
        L4e:
            kotlinx.io.Segment r0 = r6.expectedSegment
            if (r0 != 0) goto L71
            kotlinx.io.Buffer r0 = r6.buffer
            kotlinx.io.Segment r0 = r0.getHead()
            if (r0 == 0) goto L71
            kotlinx.io.Buffer r0 = r6.buffer
            kotlinx.io.Segment r0 = r0.getHead()
            r6.expectedSegment = r0
            kotlinx.io.Buffer r0 = r6.buffer
            kotlinx.io.Segment r0 = r0.getHead()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.getPos()
            r6.expectedPos = r0
        L71:
            kotlinx.io.Buffer r0 = r6.buffer
            long r0 = r0.getSizeMut()
            long r2 = r6.pos
            long r0 = r0 - r2
            long r8 = java.lang.Math.min(r8, r0)
            kotlinx.io.Buffer r0 = r6.buffer
            long r2 = r6.pos
            long r4 = r2 + r8
            r1 = r7
            r0.copyTo(r1, r2, r4)
            long r0 = r6.pos
            long r0 = r0 + r8
            r6.pos = r0
            return r8
        L8e:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "byteCount ("
            r7.<init>(r0)
            r7.append(r8)
            java.lang.String r8 = ") < 0"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        Lab:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Source is closed."
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.io.PeekSource.readAtMostTo(kotlinx.io.Buffer, long):long");
    }

    @Override // kotlinx.io.RawSource, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
    }
}
