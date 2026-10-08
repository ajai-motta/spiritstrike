package com.hive.userengagement;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ResultAPI;
import com.hive.module.interfaces.HiveUserEngagement;
import com.hive.userengagement.UserEngagementCoupon;
import com.hive.userengagement.UserEngagementEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\rH\u0016¨\u0006\u001a"}, d2 = {"Lcom/hive/userengagement/UserEngagementModular;", "Lcom/hive/module/interfaces/HiveUserEngagement;", "<init>", "()V", "isReadyToProcess", "", "isRunningHandleEvent", "setEngagementListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/module/interfaces/HiveUserEngagement$UserEngagementListener;", "consumeCoupon", "couponCode", "", "additionalInfo", "Lcom/hive/module/interfaces/HiveUserEngagement$CouponListener;", "isEventValid", "eventUrl", "appendEventQueryParameters", "Lorg/json/JSONObject;", "jsonObject", "setEngagementReady", "Lcom/hive/ResultAPI;", "isReady", "processUri", ShareConstants.MEDIA_URI, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserEngagementModular implements HiveUserEngagement {
    public UserEngagementModular() {
        new UserEngagementLifecycle();
    }

    @Override // com.hive.module.interfaces.HiveUserEngagement
    public JSONObject appendEventQueryParameters(JSONObject jsonObject) {
        return UserEngagementEvent.INSTANCE.appendQueryParameters(jsonObject);
    }

    @Override // com.hive.module.interfaces.HiveUserEngagement
    public void consumeCoupon(String couponCode, String additionalInfo, final HiveUserEngagement.CouponListener listener) {
        Intrinsics.checkNotNullParameter(couponCode, "couponCode");
        Intrinsics.checkNotNullParameter(additionalInfo, "additionalInfo");
        Intrinsics.checkNotNullParameter(listener, "listener");
        UserEngagement.INSTANCE.consumeCoupon(couponCode, additionalInfo, new UserEngagementCoupon.CouponListener() { // from class: com.hive.userengagement.UserEngagementModular.consumeCoupon.1
            @Override // com.hive.userengagement.UserEngagementCoupon.CouponListener
            public void onCouponConsume(ResultAPI result, int resultCode, String resultMessage) {
                Intrinsics.checkNotNullParameter(result, "result");
                Intrinsics.checkNotNullParameter(resultMessage, "resultMessage");
                listener.onCouponConsume(result, resultCode, resultMessage);
            }
        });
    }

    @Override // com.hive.module.interfaces.HiveUserEngagement, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return HiveUserEngagement.DefaultImpls.getHiveModuleName(this);
    }

    @Override // com.hive.module.interfaces.HiveUserEngagement, com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        return HiveUserEngagement.DefaultImpls.getVersionInfo(this);
    }

    @Override // com.hive.module.interfaces.HiveUserEngagement
    public boolean isEventValid(String eventUrl) {
        Intrinsics.checkNotNullParameter(eventUrl, "eventUrl");
        return new UserEngagementEvent(eventUrl).getValidationResult() == UserEngagementEvent.ValidationResult.OK;
    }

    @Override // com.hive.module.interfaces.HiveUserEngagement
    public boolean isReadyToProcess() {
        return UserEngagement.INSTANCE.isReadyToProcess$hive_service_release();
    }

    @Override // com.hive.module.interfaces.HiveUserEngagement
    public boolean isRunningHandleEvent() {
        return UserEngagement.INSTANCE.isRunningHandleEvent$hive_service_release();
    }

    @Override // com.hive.module.interfaces.HiveUserEngagement
    public boolean processUri(String uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return UserEngagement.INSTANCE.processUri(uri);
    }

    @Override // com.hive.module.interfaces.HiveUserEngagement
    public void setEngagementListener(HiveUserEngagement.UserEngagementListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        UserEngagement.INSTANCE.setEngagementListener(listener);
    }

    @Override // com.hive.module.interfaces.HiveUserEngagement
    public ResultAPI setEngagementReady(boolean isReady) {
        return UserEngagement.INSTANCE.setEngagementReady(isReady);
    }
}
