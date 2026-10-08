package io.ktor.http.cio;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: HttpHeadersMap.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0003R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/http/cio/HeadersData;", "", "<init>", "()V", "", "arraysCount", "()I", "subArraysCount", "", "prepare", "(I)V", FirebaseAnalytics.Param.INDEX, "at", "(I)I", "value", "set", "(II)V", "Lkotlin/sequences/Sequence;", "headersStarts", "()Lkotlin/sequences/Sequence;", "release", "", "", "arrays", "Ljava/util/List;", "ktor-http-cio"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class HeadersData {
    private List<int[]> arrays = new ArrayList();

    public final int arraysCount() {
        return this.arrays.size();
    }

    public final void prepare(int subArraysCount) {
        for (int i = 0; i < subArraysCount; i++) {
            this.arrays.add((int[]) HttpHeadersMapKt.IntArrayPool.borrow());
        }
    }

    public final int at(int index) {
        return this.arrays.get(index / 768)[index % 768];
    }

    public final void set(int index, int value) {
        this.arrays.get(index / 768)[index % 768] = value;
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.HeadersData$headersStarts$1, reason: invalid class name */
    /* JADX INFO: compiled from: HttpHeadersMap.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.HeadersData$headersStarts$1", f = "HttpHeadersMap.kt", i = {0, 0, 0, 0}, l = {264}, m = "invokeSuspend", n = {"$this$sequence", "arr", "joinedIndex", "localIndex"}, s = {"L$0", "L$2", "I$0", "I$1"})
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = HeadersData.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super Integer> sequenceScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0082  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0040 -> B:12:0x004a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0054 -> B:21:0x007a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0070 -> B:20:0x0075). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r10.label
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L28
                if (r1 != r3) goto L20
                int r1 = r10.I$1
                int r4 = r10.I$0
                java.lang.Object r5 = r10.L$2
                int[] r5 = (int[]) r5
                java.lang.Object r6 = r10.L$1
                java.util.Iterator r6 = (java.util.Iterator) r6
                java.lang.Object r7 = r10.L$0
                kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
                kotlin.ResultKt.throwOnFailure(r11)
                goto L75
            L20:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L28:
                kotlin.ResultKt.throwOnFailure(r11)
                java.lang.Object r11 = r10.L$0
                kotlin.sequences.SequenceScope r11 = (kotlin.sequences.SequenceScope) r11
                io.ktor.http.cio.HeadersData r1 = io.ktor.http.cio.HeadersData.this
                java.util.List r1 = io.ktor.http.cio.HeadersData.access$getArrays$p(r1)
                java.util.Iterator r1 = r1.iterator()
                r4 = r2
            L3a:
                boolean r5 = r1.hasNext()
                if (r5 == 0) goto L82
                java.lang.Object r5 = r1.next()
                int[] r5 = (int[]) r5
                r6 = r5
                r5 = r4
                r4 = r1
                r1 = r2
            L4a:
                int r7 = r6.length
                if (r1 >= r7) goto L7f
                io.ktor.http.cio.HeadersData r7 = io.ktor.http.cio.HeadersData.this
                int r7 = r7.at(r5)
                r8 = -1
                if (r7 == r8) goto L7a
                java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
                r8 = r10
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r10.L$0 = r11
                r10.L$1 = r4
                r10.L$2 = r6
                r10.I$0 = r5
                r10.I$1 = r1
                r10.label = r3
                java.lang.Object r7 = r11.yield(r7, r8)
                if (r7 != r0) goto L70
                return r0
            L70:
                r7 = r11
                r9 = r6
                r6 = r4
                r4 = r5
                r5 = r9
            L75:
                r11 = r7
                r9 = r5
                r5 = r4
                r4 = r6
                r6 = r9
            L7a:
                int r1 = r1 + 6
                int r5 = r5 + 6
                goto L4a
            L7f:
                r1 = r4
                r4 = r5
                goto L3a
            L82:
                kotlin.Unit r11 = kotlin.Unit.INSTANCE
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.HeadersData.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Sequence<Integer> headersStarts() {
        return SequencesKt.sequence(new AnonymousClass1(null));
    }

    public final void release() {
        Iterator<int[]> it = this.arrays.iterator();
        while (it.hasNext()) {
            HttpHeadersMapKt.IntArrayPool.recycle(it.next());
        }
        this.arrays.clear();
    }
}
