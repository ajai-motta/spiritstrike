package com.hive.promotion.ui.news;

import com.adxcorp.ads.mediation.util.ReportUtil;
import com.adxcorp.util.ADXLogUtil;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.hive.analytics.provider.adjust.AnalyticsProviderAdjust;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BannerList.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/hive/promotion/ui/news/BannerList;", "", "jsonObject", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "bannerList", "Ljava/util/ArrayList;", "Lcom/hive/promotion/ui/news/BannerList$Banner;", "Lkotlin/collections/ArrayList;", "getBannerList", "()Ljava/util/ArrayList;", "setBannerList", "(Ljava/util/ArrayList;)V", InAppPurchaseConstants.METHOD_TO_STRING, "", ADXLogUtil.INVENTORY_BANNER, "Badge", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BannerList {
    private ArrayList<Banner> bannerList;
    private final JSONObject jsonObject;

    public BannerList(JSONObject jsonObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        this.jsonObject = jsonObject;
        this.bannerList = new ArrayList<>();
        JSONArray jSONArrayOptJSONArray = jsonObject.optJSONArray(ReportUtil.INVENTORY_TYPE_BANNER);
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i);
                ArrayList<Banner> arrayList = this.bannerList;
                Intrinsics.checkNotNull(jSONObject);
                arrayList.add(new Banner(jSONObject));
            }
        }
    }

    public final ArrayList<Banner> getBannerList() {
        return this.bannerList;
    }

    public final void setBannerList(ArrayList<Banner> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.bannerList = arrayList;
    }

    public String toString() throws JSONException {
        String string = this.jsonObject.toString(4);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: compiled from: BannerList.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010-\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001a\u0010!\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011¨\u0006."}, d2 = {"Lcom/hive/promotion/ui/news/BannerList$Banner;", "", "jsonObject", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", AnalyticsProviderAdjust.EventKeys.pid, "", "getPid", "()I", "setPid", "(I)V", "image", "", "getImage", "()Ljava/lang/String;", "setImage", "(Ljava/lang/String;)V", "link", "getLink", "setLink", "startUnixTime", "", "getStartUnixTime", "()J", "setStartUnixTime", "(J)V", "endUnixTime", "getEndUnixTime", "setEndUnixTime", "campaignType", "getCampaignType", "setCampaignType", "viewType", "getViewType", "setViewType", "badge", "Lcom/hive/promotion/ui/news/BannerList$Badge;", "getBadge", "()Lcom/hive/promotion/ui/news/BannerList$Badge;", "setBadge", "(Lcom/hive/promotion/ui/news/BannerList$Badge;)V", AdUnitActivity.EXTRA_ORIENTATION, "getOrientation", "setOrientation", InAppPurchaseConstants.METHOD_TO_STRING, "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Banner {
        private Badge badge;
        private String campaignType;
        private long endUnixTime;
        private String image;
        private final JSONObject jsonObject;
        private String link;
        private String orientation;
        private int pid;
        private long startUnixTime;
        private String viewType;

        public Banner(JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            this.jsonObject = jsonObject;
            this.image = "";
            this.link = "";
            this.campaignType = "";
            this.viewType = "";
            this.orientation = "";
            this.pid = jsonObject.optInt(AnalyticsProviderAdjust.EventKeys.pid);
            String strOptString = jsonObject.optString("image");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            this.image = strOptString;
            String strOptString2 = jsonObject.optString("link");
            Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
            this.link = strOptString2;
            String strOptString3 = jsonObject.optString("display_orientation");
            Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
            this.orientation = strOptString3;
            Long lValueOf = Long.valueOf(jsonObject.optLong("start_unixtimestamp", 0L));
            lValueOf = lValueOf.longValue() == 0 ? null : lValueOf;
            this.startUnixTime = lValueOf != null ? lValueOf.longValue() : jsonObject.optLong("start_unixtimstamp", 0L);
            Long lValueOf2 = Long.valueOf(jsonObject.optLong("end_unixtimestamp", 0L));
            Long l = lValueOf2.longValue() != 0 ? lValueOf2 : null;
            this.endUnixTime = l != null ? l.longValue() : jsonObject.optLong("start_unixtimstamp", 0L);
            String strOptString4 = jsonObject.optString("type_camp");
            Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
            this.campaignType = strOptString4;
            String strOptString5 = jsonObject.optString("view_type");
            Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
            this.viewType = strOptString5;
            JSONObject jSONObjectOptJSONObject = jsonObject.optJSONObject("badge");
            if (jSONObjectOptJSONObject != null) {
                this.badge = new Badge(jSONObjectOptJSONObject);
            }
        }

        public final int getPid() {
            return this.pid;
        }

        public final void setPid(int i) {
            this.pid = i;
        }

        public final String getImage() {
            return this.image;
        }

        public final void setImage(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.image = str;
        }

        public final String getLink() {
            return this.link;
        }

        public final void setLink(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.link = str;
        }

        public final long getStartUnixTime() {
            return this.startUnixTime;
        }

        public final void setStartUnixTime(long j) {
            this.startUnixTime = j;
        }

        public final long getEndUnixTime() {
            return this.endUnixTime;
        }

        public final void setEndUnixTime(long j) {
            this.endUnixTime = j;
        }

        public final String getCampaignType() {
            return this.campaignType;
        }

        public final void setCampaignType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.campaignType = str;
        }

        public final String getViewType() {
            return this.viewType;
        }

        public final void setViewType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.viewType = str;
        }

        public final Badge getBadge() {
            return this.badge;
        }

        public final void setBadge(Badge badge) {
            this.badge = badge;
        }

        public final String getOrientation() {
            return this.orientation;
        }

        public final void setOrientation(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.orientation = str;
        }

        public String toString() throws JSONException {
            String string = this.jsonObject.toString(4);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }

    /* JADX INFO: compiled from: BannerList.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001e\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/hive/promotion/ui/news/BannerList$Badge;", "", "jsonObject", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "type", "getType", "setType", "startDate", "getStartDate", "setStartDate", "endDate", "getEndDate", "setEndDate", "startUnixTime", "", "getStartUnixTime", "()J", "setStartUnixTime", "(J)V", "endUnixTime", "getEndUnixTime", "setEndUnixTime", InAppPurchaseConstants.METHOD_TO_STRING, "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Badge {
        private String endDate;
        private long endUnixTime;
        private final JSONObject jsonObject;
        private String startDate;
        private long startUnixTime;
        private String title;
        private String type;

        public Badge(JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            this.jsonObject = jsonObject;
            this.title = "";
            this.type = "";
            this.startDate = "";
            this.endDate = "";
            String strOptString = jsonObject.optString("title");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            this.title = strOptString;
            String strOptString2 = jsonObject.optString("type");
            Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
            this.type = strOptString2;
            String strOptString3 = jsonObject.optString("startDate");
            Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
            this.startDate = strOptString3;
            String strOptString4 = jsonObject.optString("endDate");
            Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
            this.endDate = strOptString4;
            this.startUnixTime = jsonObject.optLong("start_unixtimestamp", 0L);
            this.endUnixTime = jsonObject.optLong("end_unixtimestamp", 0L);
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        public final String getType() {
            return this.type;
        }

        public final void setType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.type = str;
        }

        public final String getStartDate() {
            return this.startDate;
        }

        public final void setStartDate(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.startDate = str;
        }

        public final String getEndDate() {
            return this.endDate;
        }

        public final void setEndDate(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.endDate = str;
        }

        public final long getStartUnixTime() {
            return this.startUnixTime;
        }

        public final void setStartUnixTime(long j) {
            this.startUnixTime = j;
        }

        public final long getEndUnixTime() {
            return this.endUnixTime;
        }

        public final void setEndUnixTime(long j) {
            this.endUnixTime = j;
        }

        public String toString() throws JSONException {
            String string = this.jsonObject.toString(4);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }
}
