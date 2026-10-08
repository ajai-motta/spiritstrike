package com.hive.promotion.ui.news;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Navigation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001a\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/hive/promotion/ui/news/Navigation;", "", "jsonObject", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "giftBoxIconUrl", "", "getGiftBoxIconUrl", "()Ljava/lang/String;", "setGiftBoxIconUrl", "(Ljava/lang/String;)V", "badgeExpireSecond", "", "getBadgeExpireSecond", "()I", "setBadgeExpireSecond", "(I)V", "menuList", "Ljava/util/ArrayList;", "Lcom/hive/promotion/ui/news/Navigation$Menu;", "Lkotlin/collections/ArrayList;", "getMenuList", "()Ljava/util/ArrayList;", "setMenuList", "(Ljava/util/ArrayList;)V", InAppPurchaseConstants.METHOD_TO_STRING, "Menu", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Navigation {
    private int badgeExpireSecond;
    private String giftBoxIconUrl;
    private final JSONObject jsonObject;
    private ArrayList<Menu> menuList;

    public Navigation(JSONObject jsonObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        this.jsonObject = jsonObject;
        this.giftBoxIconUrl = "";
        this.menuList = new ArrayList<>();
        String strOptString = jsonObject.optString("gift_box_icon_url");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        this.giftBoxIconUrl = strOptString;
        this.badgeExpireSecond = jsonObject.optInt("badge_expire_second");
        JSONArray jSONArrayOptJSONArray = jsonObject.optJSONArray("menu_list");
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i);
                ArrayList<Menu> arrayList = this.menuList;
                Intrinsics.checkNotNull(jSONObject);
                arrayList.add(new Menu(jSONObject));
            }
        }
    }

    public final String getGiftBoxIconUrl() {
        return this.giftBoxIconUrl;
    }

    public final void setGiftBoxIconUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.giftBoxIconUrl = str;
    }

    public final int getBadgeExpireSecond() {
        return this.badgeExpireSecond;
    }

    public final void setBadgeExpireSecond(int i) {
        this.badgeExpireSecond = i;
    }

    public final ArrayList<Menu> getMenuList() {
        return this.menuList;
    }

    public final void setMenuList(ArrayList<Menu> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.menuList = arrayList;
    }

    public String toString() throws JSONException {
        String string = this.jsonObject.toString(4);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: compiled from: Navigation.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002+,B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010*\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000b¨\u0006-"}, d2 = {"Lcom/hive/promotion/ui/news/Navigation$Menu;", "", "jsonObject", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "id", "", "getId", "()I", "setId", "(I)V", "order", "getOrder", "setOrder", "icon", "Lcom/hive/promotion/ui/news/Navigation$Menu$Icon;", "getIcon", "()Lcom/hive/promotion/ui/news/Navigation$Menu$Icon;", "setIcon", "(Lcom/hive/promotion/ui/news/Navigation$Menu$Icon;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "promotionType", "getPromotionType", "setPromotionType", "bannerType", "getBannerType", "setBannerType", "contents", "Lcom/hive/promotion/ui/news/Navigation$Menu$Contents;", "getContents", "()Lcom/hive/promotion/ui/news/Navigation$Menu$Contents;", "setContents", "(Lcom/hive/promotion/ui/news/Navigation$Menu$Contents;)V", "lastBannerUpdated", "getLastBannerUpdated", "setLastBannerUpdated", InAppPurchaseConstants.METHOD_TO_STRING, k.C, "Contents", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Menu {
        private String bannerType;
        private Contents contents;
        private Icon icon;
        private int id;
        private final JSONObject jsonObject;
        private int lastBannerUpdated;
        private int order;
        private String promotionType;
        private String title;

        public Menu(JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            this.jsonObject = jsonObject;
            this.title = "";
            this.promotionType = "";
            this.bannerType = "";
            this.id = jsonObject.optInt("id");
            this.order = jsonObject.optInt("order");
            String strOptString = jsonObject.optString("title");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            this.title = strOptString;
            String strOptString2 = jsonObject.optString("promotion_type");
            Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
            this.promotionType = strOptString2;
            String strOptString3 = jsonObject.optString("banner_type");
            Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
            this.bannerType = strOptString3;
            this.lastBannerUpdated = jsonObject.optInt("last_banner_updated");
            JSONObject jSONObjectOptJSONObject = jsonObject.optJSONObject("icon");
            if (jSONObjectOptJSONObject != null) {
                this.icon = new Icon(jSONObjectOptJSONObject);
            }
            JSONObject jSONObjectOptJSONObject2 = jsonObject.optJSONObject("contents");
            if (jSONObjectOptJSONObject2 != null) {
                this.contents = new Contents(jSONObjectOptJSONObject2);
            }
        }

        public final int getId() {
            return this.id;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final int getOrder() {
            return this.order;
        }

        public final void setOrder(int i) {
            this.order = i;
        }

        public final Icon getIcon() {
            return this.icon;
        }

        public final void setIcon(Icon icon) {
            this.icon = icon;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        public final String getPromotionType() {
            return this.promotionType;
        }

        public final void setPromotionType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.promotionType = str;
        }

        public final String getBannerType() {
            return this.bannerType;
        }

        public final void setBannerType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.bannerType = str;
        }

        public final Contents getContents() {
            return this.contents;
        }

        public final void setContents(Contents contents) {
            this.contents = contents;
        }

        public final int getLastBannerUpdated() {
            return this.lastBannerUpdated;
        }

        public final void setLastBannerUpdated(int i) {
            this.lastBannerUpdated = i;
        }

        public String toString() throws JSONException {
            String string = this.jsonObject.toString(4);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        /* JADX INFO: compiled from: Navigation.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/hive/promotion/ui/news/Navigation$Menu$Icon;", "", "jsonObject", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "onLightDark", "", "getOnLightDark", "()Ljava/lang/String;", "setOnLightDark", "(Ljava/lang/String;)V", "offLight", "getOffLight", "setOffLight", "offDark", "getOffDark", "setOffDark", InAppPurchaseConstants.METHOD_TO_STRING, "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Icon {
            private final JSONObject jsonObject;
            private String offDark;
            private String offLight;
            private String onLightDark;

            public Icon(JSONObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                this.jsonObject = jsonObject;
                this.onLightDark = "";
                this.offLight = "";
                this.offDark = "";
                String strOptString = jsonObject.optString("on_light_dark");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                this.onLightDark = strOptString;
                String strOptString2 = jsonObject.optString("off_light");
                Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                this.offLight = strOptString2;
                String strOptString3 = jsonObject.optString("off_dark");
                Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                this.offDark = strOptString3;
            }

            public final String getOnLightDark() {
                return this.onLightDark;
            }

            public final void setOnLightDark(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.onLightDark = str;
            }

            public final String getOffLight() {
                return this.offLight;
            }

            public final void setOffLight(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.offLight = str;
            }

            public final String getOffDark() {
                return this.offDark;
            }

            public final void setOffDark(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.offDark = str;
            }

            public String toString() throws JSONException {
                String string = this.jsonObject.toString(4);
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        }

        /* JADX INFO: compiled from: Navigation.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/hive/promotion/ui/news/Navigation$Menu$Contents;", "", "jsonObject", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "area", "", "getArea", "()Ljava/lang/String;", "setArea", "(Ljava/lang/String;)V", "link", "getLink", "setLink", "accept", "getAccept", "setAccept", InAppPurchaseConstants.METHOD_TO_STRING, "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Contents {
            private String accept;
            private String area;
            private final JSONObject jsonObject;
            private String link;

            public Contents(JSONObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                this.jsonObject = jsonObject;
                this.area = "";
                this.link = "";
                this.accept = "";
                String strOptString = jsonObject.optString("area");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                this.area = strOptString;
                String strOptString2 = jsonObject.optString("link");
                Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                this.link = strOptString2;
                String strOptString3 = jsonObject.optString("accept");
                Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                this.accept = strOptString3;
            }

            public final String getArea() {
                return this.area;
            }

            public final void setArea(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.area = str;
            }

            public final String getLink() {
                return this.link;
            }

            public final void setLink(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.link = str;
            }

            public final String getAccept() {
                return this.accept;
            }

            public final void setAccept(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.accept = str;
            }

            public String toString() throws JSONException {
                String string = this.jsonObject.toString(4);
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        }
    }
}
