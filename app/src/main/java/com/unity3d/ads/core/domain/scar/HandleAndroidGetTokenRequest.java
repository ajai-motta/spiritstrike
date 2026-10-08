package com.unity3d.ads.core.domain.scar;

import com.unity3d.ads.core.domain.GetRequestPolicy;
import com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad;
import com.unity3d.ads.gatewayclient.GatewayClient;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HandleAndroidGetTokenRequest.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/unity3d/ads/core/domain/scar/HandleAndroidGetTokenRequest;", "Lcom/unity3d/ads/core/domain/scar/HandleGetTokenRequest;", "getUniversalRequestForPayLoad", "Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;", "getHbTokenEventRequest", "Lcom/unity3d/ads/core/domain/scar/GetHbTokenEventRequest;", "getRequestPolicy", "Lcom/unity3d/ads/core/domain/GetRequestPolicy;", "gatewayClient", "Lcom/unity3d/ads/gatewayclient/GatewayClient;", "(Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;Lcom/unity3d/ads/core/domain/scar/GetHbTokenEventRequest;Lcom/unity3d/ads/core/domain/GetRequestPolicy;Lcom/unity3d/ads/gatewayclient/GatewayClient;)V", "invoke", "Lgatewayprotocol/v1/UniversalResponseOuterClass$UniversalResponse;", "tokenId", "Lcom/google/protobuf/ByteString;", "biddingSignals", "Lcom/unity3d/services/ads/gmascar/models/BiddingSignals;", "(Lcom/google/protobuf/ByteString;Lcom/unity3d/services/ads/gmascar/models/BiddingSignals;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HandleAndroidGetTokenRequest implements HandleGetTokenRequest {
    private final GatewayClient gatewayClient;
    private final GetHbTokenEventRequest getHbTokenEventRequest;
    private final GetRequestPolicy getRequestPolicy;
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: HandleAndroidGetTokenRequest.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest", f = "HandleAndroidGetTokenRequest.kt", i = {0, 1}, l = {20, 24, 26}, m = "invoke", n = {"this", "this"}, s = {"L$0", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HandleAndroidGetTokenRequest.this.invoke(null, null, this);
        }
    }

    public HandleAndroidGetTokenRequest(GetUniversalRequestForPayLoad getUniversalRequestForPayLoad, GetHbTokenEventRequest getHbTokenEventRequest, GetRequestPolicy getRequestPolicy, GatewayClient gatewayClient) {
        Intrinsics.checkNotNullParameter(getUniversalRequestForPayLoad, "getUniversalRequestForPayLoad");
        Intrinsics.checkNotNullParameter(getHbTokenEventRequest, "getHbTokenEventRequest");
        Intrinsics.checkNotNullParameter(getRequestPolicy, "getRequestPolicy");
        Intrinsics.checkNotNullParameter(gatewayClient, "gatewayClient");
        this.getUniversalRequestForPayLoad = getUniversalRequestForPayLoad;
        this.getHbTokenEventRequest = getHbTokenEventRequest;
        this.getRequestPolicy = getRequestPolicy;
        this.gatewayClient = gatewayClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009d A[PHI: r12
  0x009d: PHI (r12v10 java.lang.Object) = (r12v9 java.lang.Object), (r12v1 java.lang.Object) binds: [B:26:0x009a, B:13:0x002d] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.unity3d.ads.core.domain.scar.HandleGetTokenRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object invoke(com.google.protobuf.ByteString r10, com.unity3d.services.ads.gmascar.models.BiddingSignals r11, kotlin.coroutines.Continuation<? super gatewayprotocol.v1.UniversalResponseOuterClass.UniversalResponse> r12) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r12
            com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest$invoke$1 r0 = (com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest$invoke$1 r0 = new com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest$invoke$1
            r0.<init>(r12)
        L19:
            r6 = r0
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L49
            if (r1 == r4) goto L41
            if (r1 == r3) goto L39
            if (r1 != r2) goto L31
            kotlin.ResultKt.throwOnFailure(r12)
            goto L9d
        L31:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L39:
            java.lang.Object r10 = r6.L$0
            com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest r10 = (com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest) r10
            kotlin.ResultKt.throwOnFailure(r12)
            goto L81
        L41:
            java.lang.Object r10 = r6.L$0
            com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest r10 = (com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest) r10
            kotlin.ResultKt.throwOnFailure(r12)
            goto L5a
        L49:
            kotlin.ResultKt.throwOnFailure(r12)
            com.unity3d.ads.core.domain.scar.GetHbTokenEventRequest r12 = r9.getHbTokenEventRequest
            r6.L$0 = r9
            r6.label = r4
            java.lang.Object r12 = r12.invoke(r10, r11, r6)
            if (r12 != r0) goto L59
            return r0
        L59:
            r10 = r9
        L5a:
            gatewayprotocol.v1.GetTokenEventRequestOuterClass$GetTokenEventRequest r12 = (gatewayprotocol.v1.GetTokenEventRequestOuterClass.GetTokenEventRequest) r12
            gatewayprotocol.v1.UniversalRequestKt r11 = gatewayprotocol.v1.UniversalRequestKt.INSTANCE
            gatewayprotocol.v1.UniversalRequestKt$PayloadKt$Dsl$Companion r11 = gatewayprotocol.v1.UniversalRequestKt.PayloadKt.Dsl.INSTANCE
            gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest$Payload$Builder r1 = gatewayprotocol.v1.UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder()
            java.lang.String r4 = "newBuilder()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            gatewayprotocol.v1.UniversalRequestKt$PayloadKt$Dsl r11 = r11._create(r1)
            r11.setGetTokenEventRequest(r12)
            gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest$Payload r11 = r11._build()
            com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad r12 = r10.getUniversalRequestForPayLoad
            r6.L$0 = r10
            r6.label = r3
            java.lang.Object r12 = r12.invoke(r11, r6)
            if (r12 != r0) goto L81
            return r0
        L81:
            r3 = r12
            gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest r3 = (gatewayprotocol.v1.UniversalRequestOuterClass.UniversalRequest) r3
            com.unity3d.ads.core.domain.GetRequestPolicy r11 = r10.getRequestPolicy
            com.unity3d.ads.gatewayclient.RequestPolicy r4 = r11.invoke()
            com.unity3d.ads.gatewayclient.GatewayClient r1 = r10.gatewayClient
            com.unity3d.ads.core.data.model.OperationType r5 = com.unity3d.ads.core.data.model.OperationType.GET_TOKEN
            r10 = 0
            r6.L$0 = r10
            r6.label = r2
            r2 = 0
            r7 = 1
            r8 = 0
            java.lang.Object r12 = com.unity3d.ads.gatewayclient.GatewayClient.DefaultImpls.request$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r12 != r0) goto L9d
            return r0
        L9d:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest.invoke(com.google.protobuf.ByteString, com.unity3d.services.ads.gmascar.models.BiddingSignals, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
