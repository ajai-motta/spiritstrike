package com.unity3d.ads.core.data.datasource;

import android.content.Context;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import com.unity3d.services.core.device.AdvertisingId;
import com.unity3d.services.core.device.OpenAdvertisingId;
import gatewayprotocol.v1.AllowedPiiOuterClass;
import gatewayprotocol.v1.PiiKt;
import gatewayprotocol.v1.PiiOuterClass;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: AndroidPrivacyDeviceInfoDataSource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/unity3d/ads/core/data/datasource/AndroidPrivacyDeviceInfoDataSource;", "Lcom/unity3d/ads/core/data/datasource/PrivacyDeviceInfoDataSource;", "context", "Landroid/content/Context;", "fIdDataSource", "Lcom/unity3d/ads/core/data/datasource/FIdDataSource;", "(Landroid/content/Context;Lcom/unity3d/ads/core/data/datasource/FIdDataSource;)V", "idfaInitialized", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "fetch", "Lgatewayprotocol/v1/PiiOuterClass$Pii;", "allowed", "Lgatewayprotocol/v1/AllowedPiiOuterClass$AllowedPii;", "getAdvertisingTrackingId", "", "getOpenAdvertisingTrackingId", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidPrivacyDeviceInfoDataSource implements PrivacyDeviceInfoDataSource {
    private final Context context;
    private final FIdDataSource fIdDataSource;
    private final MutableStateFlow<Boolean> idfaInitialized;

    public AndroidPrivacyDeviceInfoDataSource(Context context, FIdDataSource fIdDataSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fIdDataSource, "fIdDataSource");
        this.context = context;
        this.fIdDataSource = fIdDataSource;
        this.idfaInitialized = StateFlowKt.MutableStateFlow(false);
    }

    @Override // com.unity3d.ads.core.data.datasource.PrivacyDeviceInfoDataSource
    public PiiOuterClass.Pii fetch(AllowedPiiOuterClass.AllowedPii allowed) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String strInvoke;
        Intrinsics.checkNotNullParameter(allowed, "allowed");
        if (!this.idfaInitialized.getValue().booleanValue()) {
            this.idfaInitialized.setValue(true);
            AdvertisingId.init(this.context);
            OpenAdvertisingId.init(this.context);
        }
        PiiKt.Dsl.Companion companion = PiiKt.Dsl.INSTANCE;
        PiiOuterClass.Pii.Builder builderNewBuilder = PiiOuterClass.Pii.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        final PiiKt.Dsl dsl_create = companion._create(builderNewBuilder);
        if (allowed.getIdfa()) {
            String advertisingTrackingId = getAdvertisingTrackingId();
            if (advertisingTrackingId.length() > 0) {
                UUID uuidFromString = UUID.fromString(advertisingTrackingId);
                Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(adId)");
                dsl_create.setAdvertisingId(ProtobufExtensionsKt.toByteString(uuidFromString));
            }
            String openAdvertisingTrackingId = getOpenAdvertisingTrackingId();
            if (openAdvertisingTrackingId.length() > 0) {
                UUID uuidFromString2 = UUID.fromString(openAdvertisingTrackingId);
                Intrinsics.checkNotNullExpressionValue(uuidFromString2, "fromString(openAdId)");
                dsl_create.setOpenAdvertisingTrackingId(ProtobufExtensionsKt.toByteString(uuidFromString2));
            }
        }
        if (allowed.getFid() && (strInvoke = this.fIdDataSource.invoke()) != null) {
            if (strInvoke.length() <= 0) {
                strInvoke = null;
            }
            if (strInvoke != null) {
                new MutablePropertyReference0Impl(dsl_create) { // from class: com.unity3d.ads.core.data.datasource.AndroidPrivacyDeviceInfoDataSource$fetch$1$3
                    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                    public Object get() {
                        return ((PiiKt.Dsl) this.receiver).getFid();
                    }

                    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                    public void set(Object obj) {
                        ((PiiKt.Dsl) this.receiver).setFid((String) obj);
                    }
                }.set(strInvoke);
            }
        }
        return dsl_create._build();
    }

    private final String getAdvertisingTrackingId() {
        String advertisingTrackingId = AdvertisingId.getAdvertisingTrackingId();
        return advertisingTrackingId == null ? "" : advertisingTrackingId;
    }

    private final String getOpenAdvertisingTrackingId() {
        String openAdvertisingTrackingId = OpenAdvertisingId.getOpenAdvertisingTrackingId();
        return openAdvertisingTrackingId == null ? "" : openAdvertisingTrackingId;
    }
}
