package com.unity3d.ads.core.domain.events;

import com.unity3d.ads.core.data.repository.CampaignRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.GetByteStringId;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetOperativeEventRequest.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJE\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0086Bø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/unity3d/ads/core/domain/events/GetOperativeEventRequest;", "", "generateByteStringId", "Lcom/unity3d/ads/core/domain/GetByteStringId;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "campaignRepository", "Lcom/unity3d/ads/core/data/repository/CampaignRepository;", "(Lcom/unity3d/ads/core/domain/GetByteStringId;Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/data/repository/CampaignRepository;)V", "invoke", "Lgatewayprotocol/v1/OperativeEventRequestOuterClass$OperativeEventRequest;", "operativeEventType", "Lgatewayprotocol/v1/OperativeEventRequestOuterClass$OperativeEventType;", "loadTrackingToken", "Lcom/google/protobuf/ByteString;", "opportunityId", "additionalEventData", "playerServerId", "", "adFormat", "Lgatewayprotocol/v1/InitializationResponseOuterClass$AdFormat;", "(Lgatewayprotocol/v1/OperativeEventRequestOuterClass$OperativeEventType;Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ByteString;Ljava/lang/String;Lgatewayprotocol/v1/InitializationResponseOuterClass$AdFormat;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GetOperativeEventRequest {
    private final CampaignRepository campaignRepository;
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetByteStringId generateByteStringId;
    private final SessionRepository sessionRepository;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.events.GetOperativeEventRequest$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetOperativeEventRequest.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.events.GetOperativeEventRequest", f = "GetOperativeEventRequest.kt", i = {0, 0, 0}, l = {37}, m = "invoke", n = {"this", "adFormat", "$this$invoke_u24lambda_u242"}, s = {"L$0", "L$1", "L$3"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GetOperativeEventRequest.this.invoke(null, null, null, null, null, null, this);
        }
    }

    public GetOperativeEventRequest(GetByteStringId generateByteStringId, DeviceInfoRepository deviceInfoRepository, SessionRepository sessionRepository, CampaignRepository campaignRepository) {
        Intrinsics.checkNotNullParameter(generateByteStringId, "generateByteStringId");
        Intrinsics.checkNotNullParameter(deviceInfoRepository, "deviceInfoRepository");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(campaignRepository, "campaignRepository");
        this.generateByteStringId = generateByteStringId;
        this.deviceInfoRepository = deviceInfoRepository;
        this.sessionRepository = sessionRepository;
        this.campaignRepository = campaignRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invoke(gatewayprotocol.v1.OperativeEventRequestOuterClass.OperativeEventType r6, com.google.protobuf.ByteString r7, com.google.protobuf.ByteString r8, com.google.protobuf.ByteString r9, java.lang.String r10, gatewayprotocol.v1.InitializationResponseOuterClass.AdFormat r11, kotlin.coroutines.Continuation<? super gatewayprotocol.v1.OperativeEventRequestOuterClass.OperativeEventRequest> r12) {
        /*
            r5 = this;
            boolean r0 = r12 instanceof com.unity3d.ads.core.domain.events.GetOperativeEventRequest.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r12
            com.unity3d.ads.core.domain.events.GetOperativeEventRequest$invoke$1 r0 = (com.unity3d.ads.core.domain.events.GetOperativeEventRequest.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            com.unity3d.ads.core.domain.events.GetOperativeEventRequest$invoke$1 r0 = new com.unity3d.ads.core.domain.events.GetOperativeEventRequest$invoke$1
            r0.<init>(r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L47
            if (r2 != r3) goto L3f
            java.lang.Object r6 = r0.L$4
            gatewayprotocol.v1.OperativeEventRequestKt$Dsl r6 = (gatewayprotocol.v1.OperativeEventRequestKt.Dsl) r6
            java.lang.Object r7 = r0.L$3
            gatewayprotocol.v1.OperativeEventRequestKt$Dsl r7 = (gatewayprotocol.v1.OperativeEventRequestKt.Dsl) r7
            java.lang.Object r8 = r0.L$2
            gatewayprotocol.v1.OperativeEventRequestKt$Dsl r8 = (gatewayprotocol.v1.OperativeEventRequestKt.Dsl) r8
            java.lang.Object r9 = r0.L$1
            r11 = r9
            gatewayprotocol.v1.InitializationResponseOuterClass$AdFormat r11 = (gatewayprotocol.v1.InitializationResponseOuterClass.AdFormat) r11
            java.lang.Object r9 = r0.L$0
            com.unity3d.ads.core.domain.events.GetOperativeEventRequest r9 = (com.unity3d.ads.core.domain.events.GetOperativeEventRequest) r9
            kotlin.ResultKt.throwOnFailure(r12)
            goto L96
        L3f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L47:
            kotlin.ResultKt.throwOnFailure(r12)
            gatewayprotocol.v1.OperativeEventRequestKt$Dsl$Companion r12 = gatewayprotocol.v1.OperativeEventRequestKt.Dsl.INSTANCE
            gatewayprotocol.v1.OperativeEventRequestOuterClass$OperativeEventRequest$Builder r2 = gatewayprotocol.v1.OperativeEventRequestOuterClass.OperativeEventRequest.newBuilder()
            java.lang.String r4 = "newBuilder()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            gatewayprotocol.v1.OperativeEventRequestKt$Dsl r12 = r12._create(r2)
            com.unity3d.ads.core.domain.GetByteStringId r2 = r5.generateByteStringId
            com.google.protobuf.ByteString r2 = r2.invoke()
            r12.setEventId(r2)
            r12.setEventType(r6)
            r12.setImpressionOpportunityId(r8)
            r12.setTrackingToken(r7)
            r12.setAdditionalData(r9)
            if (r10 == 0) goto L73
            r12.setSid(r10)
        L73:
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r6 = r5.deviceInfoRepository
            gatewayprotocol.v1.DynamicDeviceInfoOuterClass$DynamicDeviceInfo r6 = r6.getDynamicDeviceInfo()
            r12.setDynamicDeviceInfo(r6)
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r6 = r5.deviceInfoRepository
            r0.L$0 = r5
            r0.L$1 = r11
            r0.L$2 = r12
            r0.L$3 = r12
            r0.L$4 = r12
            r0.label = r3
            java.lang.Object r6 = r6.staticDeviceInfo(r0)
            if (r6 != r1) goto L91
            return r1
        L91:
            r9 = r5
            r7 = r12
            r8 = r7
            r12 = r6
            r6 = r8
        L96:
            gatewayprotocol.v1.StaticDeviceInfoOuterClass$StaticDeviceInfo r12 = (gatewayprotocol.v1.StaticDeviceInfoOuterClass.StaticDeviceInfo) r12
            r6.setStaticDeviceInfo(r12)
            com.unity3d.ads.core.data.repository.SessionRepository r6 = r9.sessionRepository
            gatewayprotocol.v1.SessionCountersOuterClass$SessionCounters r6 = r6.getSessionCounters()
            r7.setSessionCounters(r6)
            com.unity3d.ads.core.data.repository.CampaignRepository r6 = r9.campaignRepository
            gatewayprotocol.v1.CampaignStateOuterClass$CampaignState r6 = r6.getCampaignState()
            r7.setCampaignState(r6)
            if (r11 == 0) goto Lb2
            r7.setAdFormat(r11)
        Lb2:
            gatewayprotocol.v1.OperativeEventRequestOuterClass$OperativeEventRequest r6 = r8._build()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.events.GetOperativeEventRequest.invoke(gatewayprotocol.v1.OperativeEventRequestOuterClass$OperativeEventType, com.google.protobuf.ByteString, com.google.protobuf.ByteString, com.google.protobuf.ByteString, java.lang.String, gatewayprotocol.v1.InitializationResponseOuterClass$AdFormat, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
