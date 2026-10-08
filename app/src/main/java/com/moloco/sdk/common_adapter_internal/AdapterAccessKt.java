package com.moloco.sdk.common_adapter_internal;

import com.moloco.sdk.Init;
import com.moloco.sdk.publisher.bidrequest.Geo;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\"\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/moloco/sdk/Init$SDKInitResponse;", "", HandleInvocationsFromAdViewer.KEY_AD_UNIT_ID, "Lcom/moloco/sdk/common_adapter_internal/AdapterSessionData;", "a", "(Lcom/moloco/sdk/Init$SDKInitResponse;Ljava/lang/String;)Lcom/moloco/sdk/common_adapter_internal/AdapterSessionData;", "Lcom/moloco/sdk/publisher/bidrequest/Geo;", "Lcom/moloco/sdk/publisher/bidrequest/Geo;", "DefaultGeo", "moloco-sdk_release"}, k = 2, mv = {2, 0, 0})
public final class AdapterAccessKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Geo f2017a = new Geo(null, null, null, null, null, null);

    public static final AdapterSessionData a(Init.SDKInitResponse sDKInitResponse, String str) {
        Geo geo;
        Init.SDKInitResponse.Geo geo2 = sDKInitResponse.getGeo();
        if (geo2 != null) {
            geo = new Geo(geo2.getCity(), geo2.getCountryIso3Code(), geo2.getCountryIso2Code(), geo2.getZipCode(), Float.valueOf(geo2.getLatitude()), Float.valueOf(geo2.getLongitude()));
        } else {
            geo = f2017a;
        }
        Geo geo3 = geo;
        Init.SDKInitResponse.DirectAdsConfig directAdsConfig = sDKInitResponse.getDirectAdsConfig();
        return new AdapterSessionData(geo3, directAdsConfig != null ? directAdsConfig.getUrl() : null, sDKInitResponse.getAppId(), sDKInitResponse.getPublisherId(), sDKInitResponse.getPlatformId());
    }
}
