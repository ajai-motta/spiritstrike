package com.moloco.sdk.internal.publisher;

import android.util.Base64;
import com.moloco.sdk.internal.MolocoLogger;
import java.io.ByteArrayInputStream;
import java.util.zip.GZIPInputStream;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
public final class n implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2196a = new a(null);
    public static final int b = 0;
    public static final String c = "Base64GzippedBidProcessor";

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.Base64GzippedBidProcessor$process$2", f = "BidProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2197a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return n.this.new b(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2197a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            MolocoLogger.debug$default(molocoLogger, n.c, "Starting bid response pre-process with base64 decode and gunzip", false, 4, null);
            String strA = n.this.a(this.c);
            MolocoLogger.debug$default(molocoLogger, n.c, "Processed bidresponse: " + strA, false, 4, null);
            return strA;
        }
    }

    @Override // com.moloco.sdk.internal.publisher.p
    public Object a(String str, Continuation<? super String> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getDefault(), new b(str, null), continuation);
    }

    public final String a(String str) {
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
            MolocoLogger.debug$default(MolocoLogger.INSTANCE, c, "Base64 decoded bidresponse: " + bArrDecode, false, 4, null);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrDecode);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream, 2048);
            StringBuilder sb = new StringBuilder();
            byte[] bArr = new byte[2048];
            while (true) {
                try {
                    try {
                        int i = gZIPInputStream.read(bArr);
                        if (i != -1) {
                            sb.append(new String(bArr, 0, i, Charsets.UTF_8));
                        } else {
                            byteArrayInputStream.close();
                            gZIPInputStream.close();
                            return sb.toString();
                        }
                    } catch (Exception unused) {
                        MolocoLogger.warn$default(MolocoLogger.INSTANCE, c, "Failed to unzip bidresponse, perhaps a non-gzipped response", null, false, 12, null);
                        byteArrayInputStream.close();
                        gZIPInputStream.close();
                        return null;
                    }
                } catch (Throwable th) {
                    byteArrayInputStream.close();
                    gZIPInputStream.close();
                    throw th;
                }
            }
        } catch (Exception unused2) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, c, "Failed to base64 decode bidresponse, perhpas a non-base64 encoded response", null, false, 12, null);
            return null;
        }
    }
}
