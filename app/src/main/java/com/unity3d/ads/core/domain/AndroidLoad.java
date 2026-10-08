package com.unity3d.ads.core.domain;

import android.content.Context;
import com.google.protobuf.ByteString;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.LoadResult;
import com.unity3d.ads.core.data.model.exception.GatewayException;
import com.unity3d.ads.core.data.model.exception.NetworkTimeoutException;
import com.unity3d.ads.core.data.model.exception.UnityAdsNetworkException;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.gatewayclient.GatewayClient;
import gatewayprotocol.v1.AdRequestOuterClass;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import gatewayprotocol.v1.HeaderBiddingAdMarkupOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AndroidLoad.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J0\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cH\u0002J\u0010\u0010(\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cH\u0002JC\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010\u001f\u001a\u00020 H\u0096Bø\u0001\u0000¢\u0006\u0002\u00101R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidLoad;", "Lcom/unity3d/ads/core/domain/Load;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getAdRequest", "Lcom/unity3d/ads/core/domain/GetAdRequest;", "getAdPlayerConfigRequest", "Lcom/unity3d/ads/core/domain/GetAdPlayerConfigRequest;", "getRequestPolicy", "Lcom/unity3d/ads/core/domain/GetRequestPolicy;", "handleGatewayAdResponse", "Lcom/unity3d/ads/core/domain/HandleGatewayAdResponse;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "gatewayClient", "Lcom/unity3d/ads/gatewayclient/GatewayClient;", "adRepository", "Lcom/unity3d/ads/core/data/repository/AdRepository;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/unity3d/ads/core/domain/GetAdRequest;Lcom/unity3d/ads/core/domain/GetAdPlayerConfigRequest;Lcom/unity3d/ads/core/domain/GetRequestPolicy;Lcom/unity3d/ads/core/domain/HandleGatewayAdResponse;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/gatewayclient/GatewayClient;Lcom/unity3d/ads/core/data/repository/AdRepository;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;)V", "getTmpAdObject", "Lcom/unity3d/ads/core/data/model/AdObject;", "opportunityId", "Lcom/google/protobuf/ByteString;", "placement", "", HandleInvocationsFromAdViewer.KEY_IS_HEADER_BIDDING, "", "adType", "Lgatewayprotocol/v1/DiagnosticEventRequestOuterClass$DiagnosticAdType;", HandleInvocationsFromAdViewer.KEY_LOAD_OPTIONS, "Lcom/unity3d/ads/UnityAdsLoadOptions;", "handleGatewayException", "Lcom/unity3d/ads/core/data/model/LoadResult$Failure;", "e", "Lcom/unity3d/ads/core/data/model/exception/UnityAdsNetworkException;", "incrementLoadRequestAdmCount", "", "isBanner", "incrementLoadRequestCount", "invoke", "Lcom/unity3d/ads/core/data/model/LoadResult;", "context", "Landroid/content/Context;", "headerBiddingAdMarkup", "Lgatewayprotocol/v1/HeaderBiddingAdMarkupOuterClass$HeaderBiddingAdMarkup;", "bannerSize", "Lgatewayprotocol/v1/AdRequestOuterClass$BannerSize;", "(Landroid/content/Context;Ljava/lang/String;Lcom/google/protobuf/ByteString;Lgatewayprotocol/v1/HeaderBiddingAdMarkupOuterClass$HeaderBiddingAdMarkup;Lgatewayprotocol/v1/AdRequestOuterClass$BannerSize;Lcom/unity3d/ads/UnityAdsLoadOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidLoad implements Load {
    private final AdRepository adRepository;
    private final CoroutineDispatcher defaultDispatcher;
    private final GatewayClient gatewayClient;
    private final GetAdPlayerConfigRequest getAdPlayerConfigRequest;
    private final GetAdRequest getAdRequest;
    private final GetRequestPolicy getRequestPolicy;
    private final HandleGatewayAdResponse handleGatewayAdResponse;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;

    public AndroidLoad(CoroutineDispatcher defaultDispatcher, GetAdRequest getAdRequest, GetAdPlayerConfigRequest getAdPlayerConfigRequest, GetRequestPolicy getRequestPolicy, HandleGatewayAdResponse handleGatewayAdResponse, SessionRepository sessionRepository, GatewayClient gatewayClient, AdRepository adRepository, SendDiagnosticEvent sendDiagnosticEvent) {
        Intrinsics.checkNotNullParameter(defaultDispatcher, "defaultDispatcher");
        Intrinsics.checkNotNullParameter(getAdRequest, "getAdRequest");
        Intrinsics.checkNotNullParameter(getAdPlayerConfigRequest, "getAdPlayerConfigRequest");
        Intrinsics.checkNotNullParameter(getRequestPolicy, "getRequestPolicy");
        Intrinsics.checkNotNullParameter(handleGatewayAdResponse, "handleGatewayAdResponse");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(gatewayClient, "gatewayClient");
        Intrinsics.checkNotNullParameter(adRepository, "adRepository");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.defaultDispatcher = defaultDispatcher;
        this.getAdRequest = getAdRequest;
        this.getAdPlayerConfigRequest = getAdPlayerConfigRequest;
        this.getRequestPolicy = getRequestPolicy;
        this.handleGatewayAdResponse = handleGatewayAdResponse;
        this.sessionRepository = sessionRepository;
        this.gatewayClient = gatewayClient;
        this.adRepository = adRepository;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidLoad$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidLoad.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/unity3d/ads/core/data/model/LoadResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidLoad$invoke$2", f = "AndroidLoad.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3}, l = {72, 76, 93, 97, 136}, m = "invokeSuspend", n = {"$this$withContext", "adType", "tmpAdObject", HandleInvocationsFromAdViewer.KEY_IS_HEADER_BIDDING, "adType", "tmpAdObject", HandleInvocationsFromAdViewer.KEY_IS_HEADER_BIDDING, "mark$iv$iv", "$this$withContext", "adType", "tmpAdObject", HandleInvocationsFromAdViewer.KEY_IS_HEADER_BIDDING, "adType", "tmpAdObject", HandleInvocationsFromAdViewer.KEY_IS_HEADER_BIDDING, "mark$iv$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0", "J$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0", "J$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super LoadResult>, Object> {
        final /* synthetic */ AdRequestOuterClass.BannerSize $bannerSize;
        final /* synthetic */ Context $context;
        final /* synthetic */ HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup $headerBiddingAdMarkup;
        final /* synthetic */ UnityAdsLoadOptions $loadOptions;
        final /* synthetic */ ByteString $opportunityId;
        final /* synthetic */ String $placement;
        int I$0;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(AdRequestOuterClass.BannerSize bannerSize, HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup headerBiddingAdMarkup, ByteString byteString, String str, UnityAdsLoadOptions unityAdsLoadOptions, Context context, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$bannerSize = bannerSize;
            this.$headerBiddingAdMarkup = headerBiddingAdMarkup;
            this.$opportunityId = byteString;
            this.$placement = str;
            this.$loadOptions = unityAdsLoadOptions;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = AndroidLoad.this.new AnonymousClass2(this.$bannerSize, this.$headerBiddingAdMarkup, this.$opportunityId, this.$placement, this.$loadOptions, this.$context, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super LoadResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x02d5  */
        /* JADX WARN: Removed duplicated region for block: B:103:0x0303 A[Catch: UnityAdsNetworkException -> 0x0027, TryCatch #8 {UnityAdsNetworkException -> 0x0027, blocks: (B:9:0x0020, B:119:0x03f2, B:121:0x03f8, B:123:0x0406, B:124:0x041d, B:125:0x0426, B:128:0x042b, B:129:0x0430, B:97:0x02a9, B:101:0x02d7, B:103:0x0303, B:105:0x0321, B:107:0x038a, B:108:0x0396, B:110:0x03a3, B:111:0x03b4, B:112:0x03ba, B:116:0x03d4, B:96:0x029f, B:21:0x0062, B:80:0x0245, B:66:0x019c, B:70:0x01ca, B:65:0x0192, B:29:0x00a1, B:49:0x0131, B:32:0x00b2, B:34:0x00be, B:36:0x00d6, B:41:0x00df, B:43:0x00e4, B:45:0x0109, B:72:0x01fc, B:74:0x021f, B:76:0x0226, B:42:0x00e2), top: B:148:0x0014 }] */
        /* JADX WARN: Removed duplicated region for block: B:105:0x0321 A[Catch: UnityAdsNetworkException -> 0x0027, TryCatch #8 {UnityAdsNetworkException -> 0x0027, blocks: (B:9:0x0020, B:119:0x03f2, B:121:0x03f8, B:123:0x0406, B:124:0x041d, B:125:0x0426, B:128:0x042b, B:129:0x0430, B:97:0x02a9, B:101:0x02d7, B:103:0x0303, B:105:0x0321, B:107:0x038a, B:108:0x0396, B:110:0x03a3, B:111:0x03b4, B:112:0x03ba, B:116:0x03d4, B:96:0x029f, B:21:0x0062, B:80:0x0245, B:66:0x019c, B:70:0x01ca, B:65:0x0192, B:29:0x00a1, B:49:0x0131, B:32:0x00b2, B:34:0x00be, B:36:0x00d6, B:41:0x00df, B:43:0x00e4, B:45:0x0109, B:72:0x01fc, B:74:0x021f, B:76:0x0226, B:42:0x00e2), top: B:148:0x0014 }] */
        /* JADX WARN: Removed duplicated region for block: B:114:0x03cf  */
        /* JADX WARN: Removed duplicated region for block: B:115:0x03d2  */
        /* JADX WARN: Removed duplicated region for block: B:118:0x03f1 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:121:0x03f8 A[Catch: UnityAdsNetworkException -> 0x0027, TryCatch #8 {UnityAdsNetworkException -> 0x0027, blocks: (B:9:0x0020, B:119:0x03f2, B:121:0x03f8, B:123:0x0406, B:124:0x041d, B:125:0x0426, B:128:0x042b, B:129:0x0430, B:97:0x02a9, B:101:0x02d7, B:103:0x0303, B:105:0x0321, B:107:0x038a, B:108:0x0396, B:110:0x03a3, B:111:0x03b4, B:112:0x03ba, B:116:0x03d4, B:96:0x029f, B:21:0x0062, B:80:0x0245, B:66:0x019c, B:70:0x01ca, B:65:0x0192, B:29:0x00a1, B:49:0x0131, B:32:0x00b2, B:34:0x00be, B:36:0x00d6, B:41:0x00df, B:43:0x00e4, B:45:0x0109, B:72:0x01fc, B:74:0x021f, B:76:0x0226, B:42:0x00e2), top: B:148:0x0014 }] */
        /* JADX WARN: Removed duplicated region for block: B:125:0x0426 A[Catch: UnityAdsNetworkException -> 0x0027, TryCatch #8 {UnityAdsNetworkException -> 0x0027, blocks: (B:9:0x0020, B:119:0x03f2, B:121:0x03f8, B:123:0x0406, B:124:0x041d, B:125:0x0426, B:128:0x042b, B:129:0x0430, B:97:0x02a9, B:101:0x02d7, B:103:0x0303, B:105:0x0321, B:107:0x038a, B:108:0x0396, B:110:0x03a3, B:111:0x03b4, B:112:0x03ba, B:116:0x03d4, B:96:0x029f, B:21:0x0062, B:80:0x0245, B:66:0x019c, B:70:0x01ca, B:65:0x0192, B:29:0x00a1, B:49:0x0131, B:32:0x00b2, B:34:0x00be, B:36:0x00d6, B:41:0x00df, B:43:0x00e4, B:45:0x0109, B:72:0x01fc, B:74:0x021f, B:76:0x0226, B:42:0x00e2), top: B:148:0x0014 }] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0174 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0175  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x01c5  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x01c8  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0282 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0283  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x02d2  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r34) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 1082
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.AndroidLoad.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.unity3d.ads.core.domain.Load
    public Object invoke(Context context, String str, ByteString byteString, HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup headerBiddingAdMarkup, AdRequestOuterClass.BannerSize bannerSize, UnityAdsLoadOptions unityAdsLoadOptions, Continuation<? super LoadResult> continuation) {
        return BuildersKt.withContext(this.defaultDispatcher, new AnonymousClass2(bannerSize, headerBiddingAdMarkup, byteString, str, unityAdsLoadOptions, context, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LoadResult.Failure handleGatewayException(UnityAdsNetworkException e) {
        String message;
        String str;
        boolean z = e instanceof NetworkTimeoutException;
        UnityAds.UnityAdsLoadError unityAdsLoadError = z ? UnityAds.UnityAdsLoadError.TIMEOUT : UnityAds.UnityAdsLoadError.INTERNAL_ERROR;
        if (z) {
            message = LoadResult.MSG_TIMEOUT;
        } else {
            message = e instanceof GatewayException ? e.getMessage() : LoadResult.MSG_COMMUNICATION_FAILURE;
        }
        String str2 = message;
        if (z) {
            str = "timeout";
        } else {
            str = "gateway";
        }
        return new LoadResult.Failure(unityAdsLoadError, str2, e, str, e.getMessage(), false, 32, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void incrementLoadRequestCount(boolean isBanner) {
        if (isBanner) {
            this.sessionRepository.incrementBannerLoadRequestCount();
        } else {
            this.sessionRepository.incrementLoadRequestCount();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void incrementLoadRequestAdmCount(boolean isBanner) {
        if (isBanner) {
            this.sessionRepository.incrementBannerLoadRequestAdmCount();
        } else {
            this.sessionRepository.incrementLoadRequestAdmCount();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdObject getTmpAdObject(ByteString opportunityId, String placement, boolean isHeaderBidding, DiagnosticEventRequestOuterClass.DiagnosticAdType adType, UnityAdsLoadOptions loadOptions) {
        ByteString EMPTY = ByteString.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        return new AdObject(opportunityId, placement, EMPTY, false, null, null, null, false, null, null, null, loadOptions, isHeaderBidding, adType, null, null, 50680, null);
    }
}
