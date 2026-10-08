package com.hive.promotion;

import com.hive.Promotion;
import com.hive.base.Property;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.logger.LoggerImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: PromotionBadgeManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000b¨\u0006\r"}, d2 = {"Lcom/hive/promotion/PromotionBadgeManager;", "", "<init>", "()V", "memorizeContentsRequest", "", "promotionBadgeTarget", "Lcom/hive/Promotion$PromotionBadgeTarget;", "id", "", "jsonObject", "Lorg/json/JSONObject;", "getTimeContentsRequested", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromotionBadgeManager {
    public static final PromotionBadgeManager INSTANCE = new PromotionBadgeManager();

    private PromotionBadgeManager() {
    }

    public final void memorizeContentsRequest(Promotion.PromotionBadgeTarget promotionBadgeTarget, String id) {
        Intrinsics.checkNotNullParameter(promotionBadgeTarget, "promotionBadgeTarget");
        Intrinsics.checkNotNullParameter(id, "id");
        JSONObject timeContentsRequested = getTimeContentsRequested();
        JSONObject jSONObject = new JSONObject();
        long jCurrentTimeMillis = System.currentTimeMillis() / ((long) 1000);
        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_type_webview, promotionBadgeTarget.getValue());
        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_click_time, Long.valueOf(jCurrentTimeMillis));
        try {
            LoggerImpl.INSTANCE.d(Promotion.getTAG(), "[PromotionBadgeManager] Save key:" + id + ", value: " + jSONObject);
            timeContentsRequested.put(id, jSONObject);
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), PromotionKeys.TIME_REQUESTED, timeContentsRequested.toString(), null, 4, null);
            Property.INSTANCE.getINSTANCE().writeProperties();
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(Promotion.getTAG(), "[PromotionBadgeManager] Failed put to json object (e: " + e.getMessage() + ')');
        }
    }

    public final void memorizeContentsRequest(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Property.setValue$default(Property.INSTANCE.getINSTANCE(), PromotionKeys.TIME_REQUESTED, jsonObject.toString(), null, 4, null);
        Property.INSTANCE.getINSTANCE().writeProperties();
    }

    public final JSONObject getTimeContentsRequested() {
        LoggerImpl.INSTANCE.d(Promotion.getTAG(), "[PromotionBadgeManager] getTimeContentsRequested()");
        String value = Property.INSTANCE.getINSTANCE().getValue(PromotionKeys.TIME_REQUESTED);
        if (value != null) {
            try {
                return new JSONObject(value);
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(Promotion.getTAG(), "[PromotionBadgeManager] Failed to create a new json object (e: " + e.getMessage() + ')');
                return new JSONObject();
            }
        }
        return new JSONObject();
    }
}
