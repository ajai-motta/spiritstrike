package com.hive.promotion;

import android.graphics.Point;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.provider.FontsContractCompat;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.HiveActivity;
import com.hive.Promotion;
import com.hive.analytics.AnalyticsImpl;
import com.hive.analytics.AnalyticsReferrerSender;
import com.hive.analytics.provider.adjust.AnalyticsProviderAdjust;
import com.hive.base.Android;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.Configuration;
import com.hive.core.ExtentionsKt;
import com.hive.core.HiveKeys;
import com.hive.core.OauthToken;
import com.hive.core.Product;
import com.hive.core.configuration.HiveInterfaceType;
import com.hive.logger.LoggerImpl;
import com.hive.protocol.Protocol;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.promotionv2.Badge;
import com.hive.protocol.promotionv2.Banner;
import com.hive.protocol.promotionv2.Cpi;
import com.hive.protocol.promotionv2.IncreaseCount;
import com.hive.protocol.promotionv2.Init;
import com.hive.protocol.promotionv2.Login;
import com.hive.protocol.promotionv2.MoreGames;
import com.hive.protocol.promotionv2.MoreGamesClick;
import com.hive.protocol.promotionv2.NewsLogClickBanner;
import com.hive.protocol.promotionv2.NewsLogOpenBanner;
import com.hive.protocol.promotionv2.Review;
import com.hive.protocol.promotionv2.ReviewClick;
import com.hive.protocol.promotionv2.UaSenderInfo;
import com.hive.protocol.promotionv2.UaUser;
import com.hive.protocol.promotionv2.newsv2.BannerList;
import com.hive.protocol.promotionv2.newsv2.Navigation;
import com.hive.standalone.HiveLifecycle;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PromotionNetwork.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0007XYZ[\\]^B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0089\u0001\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152Q\u0010\u0016\u001aM\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\r0\u0017J)\u0010 \u001a\u00020\r2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\r0!J1\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u00052!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\r0!J)\u0010&\u001a\u00020\r2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110'¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\r0!J1\u0010(\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u00052!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110)¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\r0!JJ\u0010*\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010\u000528\u0010\u0016\u001a4\u0012\u0013\u0012\u00110-¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(*\u0012\u0015\u0012\u0013\u0018\u00010.¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\r0,J@\u00100\u001a\u00020\r28\u0010\u0016\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(0\u0012\u0015\u0012\u0013\u0018\u000102¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\r0,J1\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020\u001e2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u001106¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\r0!J1\u00108\u001a\u00020\r2\u0006\u00105\u001a\u00020\u001e2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u001109¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\r0!J1\u00108\u001a\u00020\r2\u0006\u0010:\u001a\u00020\u001b2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u001109¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\r0!J(\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010AJ\u000e\u0010B\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u0012J\b\u0010C\u001a\u00020DH\u0007J\u0018\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u0005H\u0007JT\u0010I\u001a\u00020\r2\u0006\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u00052<\u0010\u0016\u001a8\u0012\u0013\u0012\u00110L¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(I\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020M0\u001d¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(N\u0012\u0004\u0012\u00020\r0,J)\u0010O\u001a\u00020\r2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110P¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(O\u0012\u0004\u0012\u00020\r0!J\u000e\u0010Q\u001a\u00020\r2\u0006\u0010R\u001a\u00020SJ\u0011\u0010T\u001a\u00020\u0015*\u00020\u0015H\u0000¢\u0006\u0002\bUJ\u0014\u0010V\u001a\u0006\u0012\u0002\b\u00030W*\u0006\u0012\u0002\b\u00030WH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0007\"\u0004\b\n\u0010\u000b¨\u0006_"}, d2 = {"Lcom/hive/promotion/PromotionNetwork;", "", "<init>", "()V", "notDefinedVidValue", "", "getNotDefinedVidValue", "()Ljava/lang/String;", "additionalInfo", "getAdditionalInfo", "setAdditionalInfo", "(Ljava/lang/String;)V", "init", "", "contentKey", "webViewType", "Lcom/hive/Promotion$PromotionWebviewType;", "forced", "", "forPreDownload", "argDeeplinkJsonObj", "Lorg/json/JSONObject;", "callback", "Lkotlin/Function3;", "Lcom/hive/protocol/promotionv2/Init;", "Lkotlin/ParameterName;", "name", "", "count", "Ljava/util/ArrayList;", "Lcom/hive/promotion/PromotionNetwork$WebViewInfo;", "webViewInfoList", "review", "Lkotlin/Function1;", "Lcom/hive/protocol/promotionv2/Review;", "reviewClick", "userSelected", "Lcom/hive/protocol/promotionv2/ReviewClick;", "moreGames", "Lcom/hive/protocol/promotionv2/MoreGames;", "moreGamesClick", "Lcom/hive/protocol/promotionv2/MoreGamesClick;", "uaUser", "inviteUserInfo", "Lkotlin/Function2;", "Lcom/hive/protocol/promotionv2/UaUser;", "Lcom/hive/Promotion$AppInvitationData;", "appInvitationData", "uaSenderInfo", "Lcom/hive/protocol/promotionv2/UaSenderInfo;", "Lcom/hive/Promotion$AppInvitationSenderInfo;", "appInvitationSenderInfo", "newsLogOpenAPI", "webviewInfo", "Lcom/hive/protocol/promotionv2/NewsLogOpenBanner;", "newsLog", "newsLogClickAPI", "Lcom/hive/protocol/promotionv2/NewsLogClickBanner;", AnalyticsProviderAdjust.EventKeys.pid, "cpi", "Lcom/hive/protocol/promotionv2/Cpi;", "authType", "account", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "isAgreementDetermineBaseAccount", "(Ljava/lang/String;Lcom/hive/standalone/HiveLifecycle$HiveAccount;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", NotificationCompat.CATEGORY_NAVIGATION, "Lcom/hive/protocol/promotionv2/newsv2/Navigation;", "bannerList", "Lcom/hive/protocol/promotionv2/newsv2/BannerList;", "campaignType", "bannerType", ReportUtil.INVENTORY_TYPE_BANNER, "typeCamp", "typeBanner", "Lcom/hive/protocol/promotionv2/Banner;", "Lcom/hive/Promotion$PromotionBanner;", "bannerArrayList", "badge", "Lcom/hive/protocol/promotionv2/Badge;", "increaseCount", "supportType", "Lcom/hive/promotion/PromotionNetwork$IncreaseCountSupportType;", "putPromotionBasePostData", "putPromotionBasePostData$hive_promotion_release", "setBasePostBody", "Lcom/hive/protocol/Protocol;", "IncreaseCountSupportType", "Badge", "ViewAppearance", "BannerDetail", "WebBanner", "WebViewInfo", "Menu", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromotionNetwork {
    public static final PromotionNetwork INSTANCE = new PromotionNetwork();
    private static final String notDefinedVidValue = "-703";
    private static String additionalInfo = "";

    /* JADX INFO: compiled from: PromotionNetwork.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Promotion.PromotionWebviewType.values().length];
            try {
                iArr[Promotion.PromotionWebviewType.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Promotion.PromotionWebviewType.BANNER_DETAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Promotion.PromotionWebviewType.SPOT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private PromotionNetwork() {
    }

    public final String getNotDefinedVidValue() {
        return notDefinedVidValue;
    }

    public final String getAdditionalInfo() {
        return additionalInfo;
    }

    public final void setAdditionalInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        additionalInfo = str;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: PromotionNetwork.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/hive/promotion/PromotionNetwork$IncreaseCountSupportType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NEWS", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class IncreaseCountSupportType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ IncreaseCountSupportType[] $VALUES;
        public static final IncreaseCountSupportType NEWS = new IncreaseCountSupportType("NEWS", 0, "news");
        private final String value;

        private static final /* synthetic */ IncreaseCountSupportType[] $values() {
            return new IncreaseCountSupportType[]{NEWS};
        }

        public static EnumEntries<IncreaseCountSupportType> getEntries() {
            return $ENTRIES;
        }

        private IncreaseCountSupportType(String str, int i, String str2) {
            this.value = str2;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            IncreaseCountSupportType[] increaseCountSupportTypeArr$values = $values();
            $VALUES = increaseCountSupportTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(increaseCountSupportTypeArr$values);
        }

        public static IncreaseCountSupportType valueOf(String str) {
            return (IncreaseCountSupportType) Enum.valueOf(IncreaseCountSupportType.class, str);
        }

        public static IncreaseCountSupportType[] values() {
            return (IncreaseCountSupportType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: PromotionNetwork.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/hive/promotion/PromotionNetwork$Badge;", "", "jsonObj", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "typeBadge", "", "getTypeBadge", "()Ljava/lang/String;", "setTypeBadge", "(Ljava/lang/String;)V", "startDate", "", "getStartDate", "()I", "setStartDate", "(I)V", "expire", "getExpire", "setExpire", InAppPurchaseConstants.METHOD_TO_STRING, "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Badge {
        private int expire;
        private final JSONObject jsonObj;
        private int startDate;
        private String typeBadge;

        public Badge(JSONObject jsonObj) {
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            this.jsonObj = jsonObj;
            this.typeBadge = "";
            this.startDate = -1;
            this.expire = -1;
            try {
                String string = jsonObj.getString("type_badge");
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                this.typeBadge = string;
                this.startDate = jsonObj.getInt("startdate");
                this.expire = jsonObj.getInt("expire_second");
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(Promotion.getTAG(), "[PromotionNetwork] Badge Exception: " + e);
            }
        }

        public final String getTypeBadge() {
            return this.typeBadge;
        }

        public final void setTypeBadge(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.typeBadge = str;
        }

        public final int getStartDate() {
            return this.startDate;
        }

        public final void setStartDate(int i) {
            this.startDate = i;
        }

        public final int getExpire() {
            return this.expire;
        }

        public final void setExpire(int i) {
            this.expire = i;
        }

        public String toString() throws JSONException {
            String string = this.jsonObj.toString(4);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }

    /* JADX INFO: compiled from: PromotionNetwork.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/hive/promotion/PromotionNetwork$ViewAppearance;", "", "jsonObj", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "frameColor", "getFrameColor", "setFrameColor", "navbarColor", "getNavbarColor", "setNavbarColor", "navbarButtonInactiveColor", "getNavbarButtonInactiveColor", "setNavbarButtonInactiveColor", InAppPurchaseConstants.METHOD_TO_STRING, "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewAppearance {
        private String frameColor;
        private final JSONObject jsonObj;
        private String navbarButtonInactiveColor;
        private String navbarColor;
        private String type;

        public ViewAppearance(JSONObject jsonObj) {
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            this.jsonObj = jsonObj;
            this.type = "";
            this.frameColor = "#ff9030";
            this.navbarColor = "#ba9d81";
            this.navbarButtonInactiveColor = "#f9f9f9";
            try {
                String string = jsonObj.getString("type");
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                this.type = string;
                String strOptString = jsonObj.optString("frame_color", "#ff9030");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                this.frameColor = strOptString;
                String strOptString2 = jsonObj.optString("navbar_color", "#ba9d81");
                Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                this.navbarColor = strOptString2;
                String strOptString3 = jsonObj.optString("navbar_button_inactive_color", "#f9f9f9");
                Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                this.navbarButtonInactiveColor = strOptString3;
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(Promotion.getTAG(), "[PromotionNetwork] ViewAppearance Exception: " + e);
            }
        }

        public final String getType() {
            return this.type;
        }

        public final void setType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.type = str;
        }

        public final String getFrameColor() {
            return this.frameColor;
        }

        public final void setFrameColor(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.frameColor = str;
        }

        public final String getNavbarColor() {
            return this.navbarColor;
        }

        public final void setNavbarColor(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.navbarColor = str;
        }

        public final String getNavbarButtonInactiveColor() {
            return this.navbarButtonInactiveColor;
        }

        public final void setNavbarButtonInactiveColor(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.navbarButtonInactiveColor = str;
        }

        public String toString() throws JSONException {
            String string = this.jsonObj.toString(4);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }

    /* JADX INFO: compiled from: PromotionNetwork.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010$\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/hive/promotion/PromotionNetwork$BannerDetail;", "", "jsonObj", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "rawdata", "", "getRawdata", "()Ljava/lang/String;", "setRawdata", "(Ljava/lang/String;)V", "bucketNumber", "", "getBucketNumber", "()I", "setBucketNumber", "(I)V", "imageUrl", "getImageUrl", "setImageUrl", "interworkUrl", "getInterworkUrl", "setInterworkUrl", "bannerLink", "getBannerLink", "setBannerLink", "typeLink", "getTypeLink", "setTypeLink", "eventPeriod", "Lcom/hive/promotion/PromotionNetwork$BannerDetail$EventPeriod;", "getEventPeriod", "()Lcom/hive/promotion/PromotionNetwork$BannerDetail$EventPeriod;", "setEventPeriod", "(Lcom/hive/promotion/PromotionNetwork$BannerDetail$EventPeriod;)V", InAppPurchaseConstants.METHOD_TO_STRING, "EventPeriod", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BannerDetail {
        private String bannerLink;
        private int bucketNumber;
        private EventPeriod eventPeriod;
        private String imageUrl;
        private String interworkUrl;
        private final JSONObject jsonObj;
        private String rawdata;
        private String typeLink;

        public BannerDetail(JSONObject jsonObj) {
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            this.jsonObj = jsonObj;
            this.rawdata = jsonObj.toString();
            try {
                this.bucketNumber = jsonObj.optInt("bucket_number");
                this.imageUrl = jsonObj.getString("image");
                this.interworkUrl = jsonObj.getString("interwork_url");
                this.bannerLink = jsonObj.getString("link");
                this.typeLink = jsonObj.getString("type_link");
                JSONObject jSONObjectOptJSONObject = jsonObj.optJSONObject("event_period");
                if (jSONObjectOptJSONObject != null) {
                    this.eventPeriod = new EventPeriod(jSONObjectOptJSONObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public final String getRawdata() {
            return this.rawdata;
        }

        public final void setRawdata(String str) {
            this.rawdata = str;
        }

        public final int getBucketNumber() {
            return this.bucketNumber;
        }

        public final void setBucketNumber(int i) {
            this.bucketNumber = i;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final void setImageUrl(String str) {
            this.imageUrl = str;
        }

        public final String getInterworkUrl() {
            return this.interworkUrl;
        }

        public final void setInterworkUrl(String str) {
            this.interworkUrl = str;
        }

        public final String getBannerLink() {
            return this.bannerLink;
        }

        public final void setBannerLink(String str) {
            this.bannerLink = str;
        }

        public final String getTypeLink() {
            return this.typeLink;
        }

        public final void setTypeLink(String str) {
            this.typeLink = str;
        }

        public final EventPeriod getEventPeriod() {
            return this.eventPeriod;
        }

        public final void setEventPeriod(EventPeriod eventPeriod) {
            this.eventPeriod = eventPeriod;
        }

        /* JADX INFO: compiled from: PromotionNetwork.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/hive/promotion/PromotionNetwork$BannerDetail$EventPeriod;", "", "jsonObj", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "visiable", "", "getVisiable", "()Ljava/lang/String;", "setVisiable", "(Ljava/lang/String;)V", "periodText", "getPeriodText", "setPeriodText", "message", "getMessage", "setMessage", "time", "getTime", "setTime", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class EventPeriod {
            private String message;
            private String periodText;
            private String time;
            private String visiable;

            public EventPeriod(JSONObject jsonObj) {
                Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
                this.visiable = "n";
                try {
                    String strOptString = jsonObj.optString("visiable", "n");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    this.visiable = strOptString;
                    if (Intrinsics.areEqual("y", strOptString)) {
                        this.periodText = jsonObj.optString("text", null);
                        this.message = jsonObj.optString("message");
                        this.time = jsonObj.optString("time");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            public final String getVisiable() {
                return this.visiable;
            }

            public final void setVisiable(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.visiable = str;
            }

            public final String getPeriodText() {
                return this.periodText;
            }

            public final void setPeriodText(String str) {
                this.periodText = str;
            }

            public final String getMessage() {
                return this.message;
            }

            public final void setMessage(String str) {
                this.message = str;
            }

            public final String getTime() {
                return this.time;
            }

            public final void setTime(String str) {
                this.time = str;
            }
        }

        public String toString() throws JSONException {
            String string = this.jsonObj.toString(4);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }

    /* JADX INFO: compiled from: PromotionNetwork.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/hive/promotion/PromotionNetwork$WebBanner;", "", "jsonObj", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "use", "", "getUse", "()I", "setUse", "(I)V", InAppPurchaseConstants.METHOD_TO_STRING, "", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WebBanner {
        private final JSONObject jsonObj;
        private int use;

        public WebBanner(JSONObject jsonObj) {
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            this.jsonObj = jsonObj;
            this.use = jsonObj.optInt("use");
        }

        public final int getUse() {
            return this.use;
        }

        public final void setUse(int i) {
            this.use = i;
        }

        public String toString() throws JSONException {
            String string = this.jsonObj.toString(4);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }

    /* JADX INFO: compiled from: PromotionNetwork.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010C\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\r\"\u0004\b<\u0010\u000fR\u001e\u0010=\u001a\u0004\u0018\u00010>X\u0086\u000e¢\u0006\u0010\n\u0002\u0010B\u001a\u0004\b=\u0010?\"\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/hive/promotion/PromotionNetwork$WebViewInfo;", "", "jsonObj", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "originJson", "getOriginJson", "()Lorg/json/JSONObject;", "setOriginJson", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "typeWebView", "getTypeWebView", "setTypeWebView", "contentKey", "getContentKey", "setContentKey", AnalyticsProviderAdjust.EventKeys.pid, "", "getPid", "()I", "setPid", "(I)V", "state", "getState", "setState", "style", "getStyle", "setStyle", "badge", "Lcom/hive/promotion/PromotionNetwork$Badge;", "getBadge", "()Lcom/hive/promotion/PromotionNetwork$Badge;", "setBadge", "(Lcom/hive/promotion/PromotionNetwork$Badge;)V", "appearance", "Lcom/hive/promotion/PromotionNetwork$ViewAppearance;", "getAppearance", "()Lcom/hive/promotion/PromotionNetwork$ViewAppearance;", "setAppearance", "(Lcom/hive/promotion/PromotionNetwork$ViewAppearance;)V", "bannerDetail", "Lcom/hive/promotion/PromotionNetwork$BannerDetail;", "getBannerDetail", "()Lcom/hive/promotion/PromotionNetwork$BannerDetail;", "setBannerDetail", "(Lcom/hive/promotion/PromotionNetwork$BannerDetail;)V", "webBanner", "Lcom/hive/promotion/PromotionNetwork$WebBanner;", "getWebBanner", "()Lcom/hive/promotion/PromotionNetwork$WebBanner;", "setWebBanner", "(Lcom/hive/promotion/PromotionNetwork$WebBanner;)V", "groupId", "getGroupId", "setGroupId", "isAdvGroup", "", "()Ljava/lang/Boolean;", "setAdvGroup", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", InAppPurchaseConstants.METHOD_TO_STRING, "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WebViewInfo {
        private ViewAppearance appearance;
        private Badge badge;
        private BannerDetail bannerDetail;
        private String contentKey;
        private String groupId;
        private Boolean isAdvGroup;
        private final JSONObject jsonObj;
        private JSONObject originJson;
        private int pid;
        private int state;
        private String style;
        private String typeWebView;
        private String url;
        private WebBanner webBanner;

        public WebViewInfo(JSONObject jsonObj) {
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            this.jsonObj = jsonObj;
            this.originJson = jsonObj;
            this.url = "";
            this.typeWebView = "";
            this.contentKey = "";
            this.style = "";
            String strOptString = jsonObj.optString("url");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            this.url = strOptString;
            String strOptString2 = jsonObj.optString("type_webview");
            Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
            this.typeWebView = strOptString2;
            String strOptString3 = jsonObj.optString("content_key");
            Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
            this.contentKey = strOptString3;
            this.pid = jsonObj.optInt(AnalyticsProviderAdjust.EventKeys.pid);
            this.state = jsonObj.optInt("state");
            String strOptString4 = jsonObj.optString("style");
            Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
            this.style = strOptString4;
            JSONObject jSONObjectOptJSONObject = jsonObj.optJSONObject("badge");
            if (jSONObjectOptJSONObject != null) {
                this.badge = new Badge(jSONObjectOptJSONObject);
            }
            JSONObject jSONObjectOptJSONObject2 = jsonObj.optJSONObject("appearance");
            if (jSONObjectOptJSONObject2 != null) {
                this.appearance = new ViewAppearance(jSONObjectOptJSONObject2);
            }
            JSONObject jSONObjectOptJSONObject3 = jsonObj.optJSONObject("banner_detail");
            if (jSONObjectOptJSONObject3 != null) {
                this.bannerDetail = new BannerDetail(jSONObjectOptJSONObject3);
            }
            JSONObject jSONObjectOptJSONObject4 = jsonObj.optJSONObject("web_banner");
            if (jSONObjectOptJSONObject4 != null) {
                this.webBanner = new WebBanner(jSONObjectOptJSONObject4);
            }
            this.groupId = ExtentionsKt.optStringOrNull(jsonObj, FirebaseAnalytics.Param.GROUP_ID);
            this.isAdvGroup = ExtentionsKt.optBooleanOrNull(jsonObj, "is_adv_group");
        }

        public final JSONObject getOriginJson() {
            return this.originJson;
        }

        public final void setOriginJson(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "<set-?>");
            this.originJson = jSONObject;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.url = str;
        }

        public final String getTypeWebView() {
            return this.typeWebView;
        }

        public final void setTypeWebView(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.typeWebView = str;
        }

        public final String getContentKey() {
            return this.contentKey;
        }

        public final void setContentKey(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.contentKey = str;
        }

        public final int getPid() {
            return this.pid;
        }

        public final void setPid(int i) {
            this.pid = i;
        }

        public final int getState() {
            return this.state;
        }

        public final void setState(int i) {
            this.state = i;
        }

        public final String getStyle() {
            return this.style;
        }

        public final void setStyle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.style = str;
        }

        public final Badge getBadge() {
            return this.badge;
        }

        public final void setBadge(Badge badge) {
            this.badge = badge;
        }

        public final ViewAppearance getAppearance() {
            return this.appearance;
        }

        public final void setAppearance(ViewAppearance viewAppearance) {
            this.appearance = viewAppearance;
        }

        public final BannerDetail getBannerDetail() {
            return this.bannerDetail;
        }

        public final void setBannerDetail(BannerDetail bannerDetail) {
            this.bannerDetail = bannerDetail;
        }

        public final WebBanner getWebBanner() {
            return this.webBanner;
        }

        public final void setWebBanner(WebBanner webBanner) {
            this.webBanner = webBanner;
        }

        public final String getGroupId() {
            return this.groupId;
        }

        public final void setGroupId(String str) {
            this.groupId = str;
        }

        /* JADX INFO: renamed from: isAdvGroup, reason: from getter */
        public final Boolean getIsAdvGroup() {
            return this.isAdvGroup;
        }

        public final void setAdvGroup(Boolean bool) {
            this.isAdvGroup = bool;
        }

        public String toString() throws JSONException {
            String string = this.jsonObj.toString(4);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }

    /* JADX INFO: compiled from: PromotionNetwork.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002+,B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010*\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000b¨\u0006-"}, d2 = {"Lcom/hive/promotion/PromotionNetwork$Menu;", "", "jsonObject", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "id", "", "getId", "()I", "setId", "(I)V", "order", "getOrder", "setOrder", "icon", "Lcom/hive/promotion/PromotionNetwork$Menu$Icon;", "getIcon", "()Lcom/hive/promotion/PromotionNetwork$Menu$Icon;", "setIcon", "(Lcom/hive/promotion/PromotionNetwork$Menu$Icon;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "promotionType", "getPromotionType", "setPromotionType", "bannerType", "getBannerType", "setBannerType", "contents", "Lcom/hive/promotion/PromotionNetwork$Menu$Contents;", "getContents", "()Lcom/hive/promotion/PromotionNetwork$Menu$Contents;", "setContents", "(Lcom/hive/promotion/PromotionNetwork$Menu$Contents;)V", "lastBannerUpdated", "getLastBannerUpdated", "setLastBannerUpdated", InAppPurchaseConstants.METHOD_TO_STRING, k.C, "Contents", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        /* JADX INFO: compiled from: PromotionNetwork.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/hive/promotion/PromotionNetwork$Menu$Icon;", "", "jsonObject", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "onLightDark", "", "getOnLightDark", "()Ljava/lang/String;", "setOnLightDark", "(Ljava/lang/String;)V", "offLight", "getOffLight", "setOffLight", "offDark", "getOffDark", "setOffDark", InAppPurchaseConstants.METHOD_TO_STRING, "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        /* JADX INFO: compiled from: PromotionNetwork.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/hive/promotion/PromotionNetwork$Menu$Contents;", "", "jsonObject", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "area", "", "getArea", "()Ljava/lang/String;", "setArea", "(Ljava/lang/String;)V", "link", "getLink", "setLink", "accept", "getAccept", "setAccept", InAppPurchaseConstants.METHOD_TO_STRING, "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public static /* synthetic */ void init$default(PromotionNetwork promotionNetwork, String str, Promotion.PromotionWebviewType promotionWebviewType, boolean z, boolean z2, JSONObject jSONObject, Function3 function3, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = false;
        }
        boolean z3 = z2;
        if ((i & 16) != 0) {
            jSONObject = null;
        }
        promotionNetwork.init(str, promotionWebviewType, z, z3, jSONObject, function3);
    }

    public final void init(String contentKey, Promotion.PromotionWebviewType webViewType, boolean forced, boolean forPreDownload, JSONObject argDeeplinkJsonObj, final Function3<? super Init, ? super Integer, ? super ArrayList<WebViewInfo>, Unit> callback) {
        Intrinsics.checkNotNullParameter(webViewType, "webViewType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol<?> protocol = new Protocol<>(new Function0<Init>() { // from class: com.hive.promotion.PromotionNetwork$init$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.promotionv2.Init] */
            @Override // kotlin.jvm.functions.Function0
            public final Init invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = Init.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        JSONObject jSONObject = new JSONObject();
        try {
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_content_key, contentKey);
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_pid, 0);
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_type_webview, webViewType.getValue());
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_forced, forced ? DebugKt.DEBUG_PROPERTY_VALUE_ON : DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_is_image_download, Boolean.valueOf(forPreDownload));
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_deeplink, argDeeplinkJsonObj);
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_dont_show_again_click_pid, PromotionDialog.INSTANCE.getDontShowAgainPidListFromType(webViewType.getValue(), contentKey));
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_pid_open_info, PromotionDialog.INSTANCE.getPidOpenInfo());
            int i = WhenMappings.$EnumSwitchMapping$0[webViewType.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_show_cross_promotion, Boolean.valueOf(Configuration.INSTANCE.getCrossPromotionBannerShowing()));
            }
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(Promotion.getTAG(), "[PromotionNetwork] init Exception: " + e);
        }
        setBasePostBody(protocol);
        protocol.setParam(HiveKeys.KEY_promotion, jSONObject);
        protocol.request(new Function1() { // from class: com.hive.promotion.PromotionNetwork$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PromotionNetwork.init$lambda$2(callback, (Init) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$2(Function3 function3, Init it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ArrayList arrayList = new ArrayList();
        JSONArray webViewInfoJsonArray = it.getResponse().getWebViewInfoJsonArray();
        if (webViewInfoJsonArray != null) {
            int length = webViewInfoJsonArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = webViewInfoJsonArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(new WebViewInfo(jSONObjectOptJSONObject));
                }
            }
        }
        function3.invoke(it, Integer.valueOf(it.getResponse().getCount()), arrayList);
        return Unit.INSTANCE;
    }

    public final void review(final Function1<? super Review, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol<?> protocol = new Protocol<>(new Function0<Review>() { // from class: com.hive.promotion.PromotionNetwork$review$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.promotionv2.Review] */
            @Override // kotlin.jvm.functions.Function0
            public final Review invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = Review.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        setBasePostBody(protocol);
        protocol.request(new Function1() { // from class: com.hive.promotion.PromotionNetwork$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PromotionNetwork.review$lambda$3(callback, (Review) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit review$lambda$3(Function1 function1, Review it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    public final void reviewClick(String userSelected, final Function1<? super ReviewClick, Unit> callback) {
        Intrinsics.checkNotNullParameter(userSelected, "userSelected");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol<?> protocol = new Protocol<>(new Function0<ReviewClick>() { // from class: com.hive.promotion.PromotionNetwork$reviewClick$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.promotionv2.ReviewClick] */
            @Override // kotlin.jvm.functions.Function0
            public final ReviewClick invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = ReviewClick.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        JSONObject jSONObject = new JSONObject();
        try {
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_type_button, userSelected);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(Promotion.getTAG(), "[PromotionNetwork] reviewClick Exception: " + e);
        }
        setBasePostBody(protocol);
        protocol.setParam(HiveKeys.KEY_promotion, jSONObject);
        protocol.request(new Function1() { // from class: com.hive.promotion.PromotionNetwork$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PromotionNetwork.reviewClick$lambda$4(callback, (ReviewClick) obj);
            }
        });
        AnalyticsImpl.INSTANCE.sendReviewClick(userSelected);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reviewClick$lambda$4(Function1 function1, ReviewClick it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    public final void moreGames(final Function1<? super MoreGames, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol<?> protocol = new Protocol<>(new Function0<MoreGames>() { // from class: com.hive.promotion.PromotionNetwork$moreGames$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.promotionv2.MoreGames] */
            @Override // kotlin.jvm.functions.Function0
            public final MoreGames invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = MoreGames.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        setBasePostBody(protocol);
        protocol.request(new Function1() { // from class: com.hive.promotion.PromotionNetwork$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PromotionNetwork.moreGames$lambda$5(callback, (MoreGames) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit moreGames$lambda$5(Function1 function1, MoreGames it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    public final void moreGamesClick(String userSelected, final Function1<? super MoreGamesClick, Unit> callback) {
        Intrinsics.checkNotNullParameter(userSelected, "userSelected");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol<?> protocol = new Protocol<>(new Function0<MoreGamesClick>() { // from class: com.hive.promotion.PromotionNetwork$moreGamesClick$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.promotionv2.MoreGamesClick] */
            @Override // kotlin.jvm.functions.Function0
            public final MoreGamesClick invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = MoreGamesClick.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        JSONObject jSONObject = new JSONObject();
        try {
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_type_button, userSelected);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(Promotion.getTAG(), "[PromotionNetwork] moreGamesClick Exception: " + e);
        }
        setBasePostBody(protocol);
        protocol.setParam(HiveKeys.KEY_promotion, jSONObject);
        protocol.request(new Function1() { // from class: com.hive.promotion.PromotionNetwork$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PromotionNetwork.moreGamesClick$lambda$6(callback, (MoreGamesClick) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit moreGamesClick$lambda$6(Function1 function1, MoreGamesClick it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    public final void uaUser(String inviteUserInfo, final Function2<? super UaUser, ? super Promotion.AppInvitationData, Unit> callback) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol<?> protocol = new Protocol<>(new Function0<UaUser>() { // from class: com.hive.promotion.PromotionNetwork$uaUser$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.promotionv2.UaUser] */
            @Override // kotlin.jvm.functions.Function0
            public final UaUser invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = UaUser.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        JSONObject jSONObject = new JSONObject();
        try {
            Result.Companion companion2 = Result.INSTANCE;
            if (inviteUserInfo != null && (!StringsKt.isBlank(inviteUserInfo))) {
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_invite_user_info, inviteUserInfo);
            }
            objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion3 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w(Promotion.getTAG(), "[PromotionNetwork] moreGamesClick Exception: " + thM7418exceptionOrNullimpl);
        }
        setBasePostBody(protocol);
        protocol.setParam(HiveKeys.KEY_promotion, jSONObject);
        protocol.request(new Function1() { // from class: com.hive.promotion.PromotionNetwork$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PromotionNetwork.uaUser$lambda$9(callback, (UaUser) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit uaUser$lambda$9(Function2 function2, UaUser it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Promotion.AppInvitationData appInvitationData = null;
        if (it.getResponse().isSuccess()) {
            try {
                String string = it.getResponse().getContentJSONObject().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                appInvitationData = new Promotion.AppInvitationData(string);
            } catch (Exception e) {
                e.printStackTrace();
                LoggerImpl.INSTANCE.w(Promotion.getTAG(), "[PromotionNetwork] uaUser Exception: " + e);
            }
            function2.invoke(it, appInvitationData);
        } else {
            function2.invoke(it, null);
        }
        return Unit.INSTANCE;
    }

    public final void uaSenderInfo(final Function2<? super UaSenderInfo, ? super Promotion.AppInvitationSenderInfo, Unit> callback) throws JSONException {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol<?> protocol = new Protocol<>(new Function0<UaSenderInfo>() { // from class: com.hive.promotion.PromotionNetwork$uaSenderInfo$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.promotionv2.UaSenderInfo] */
            @Override // kotlin.jvm.functions.Function0
            public final UaSenderInfo invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = UaSenderInfo.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        setBasePostBody(protocol);
        protocol.setParam("appindex", Integer.valueOf(Configuration.INSTANCE.getAppindex()));
        protocol.setParam("receiver_vid", HiveLifecycle.INSTANCE.getAccount().getVid());
        protocol.request(new Function1() { // from class: com.hive.promotion.PromotionNetwork$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PromotionNetwork.uaSenderInfo$lambda$10(callback, (UaSenderInfo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit uaSenderInfo$lambda$10(Function2 function2, UaSenderInfo it) {
        Promotion.AppInvitationSenderInfo appInvitationSenderInfo;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResponse().isSuccess()) {
            try {
                if (it.getResponse().getContentJSONObject().has("result")) {
                    int i = it.getResponse().getContentJSONObject().getInt(FontsContractCompat.Columns.RESULT_CODE);
                    String string = it.getResponse().getContentJSONObject().getJSONObject("result").getString("sender_vid");
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    appInvitationSenderInfo = new Promotion.AppInvitationSenderInfo(i, string);
                } else {
                    appInvitationSenderInfo = new Promotion.AppInvitationSenderInfo(it.getResponse().getContentJSONObject().getInt(FontsContractCompat.Columns.RESULT_CODE));
                }
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(Promotion.getTAG(), "[PromotionNetwork] uaSenderInfo Exception: " + e);
                appInvitationSenderInfo = new Promotion.AppInvitationSenderInfo(-1);
            }
            function2.invoke(it, appInvitationSenderInfo);
        } else {
            function2.invoke(it, new Promotion.AppInvitationSenderInfo(-1));
        }
        return Unit.INSTANCE;
    }

    public final void newsLogOpenAPI(WebViewInfo webviewInfo, final Function1<? super NewsLogOpenBanner, Unit> callback) {
        Intrinsics.checkNotNullParameter(webviewInfo, "webviewInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol<?> protocol = new Protocol<>(new Function0<NewsLogOpenBanner>() { // from class: com.hive.promotion.PromotionNetwork$newsLogOpenAPI$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.promotionv2.NewsLogOpenBanner] */
            @Override // kotlin.jvm.functions.Function0
            public final NewsLogOpenBanner invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = NewsLogOpenBanner.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        JSONObject jSONObject = new JSONObject();
        try {
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_pid, Integer.valueOf(webviewInfo.getPid()));
            HiveKeys hiveKeys = HiveKeys.KEY_bucket_number;
            BannerDetail bannerDetail = webviewInfo.getBannerDetail();
            CommonIdentifierKt.put(jSONObject, hiveKeys, bannerDetail != null ? Integer.valueOf(bannerDetail.getBucketNumber()) : null);
            HiveKeys hiveKeys2 = HiveKeys.KEY_group_id;
            Object groupId = webviewInfo.getGroupId();
            if (groupId == null) {
                groupId = JSONObject.NULL;
            }
            CommonIdentifierKt.put(jSONObject, hiveKeys2, groupId);
            HiveKeys hiveKeys3 = HiveKeys.KEY_is_adv_group;
            Object isAdvGroup = webviewInfo.getIsAdvGroup();
            if (isAdvGroup == null) {
                isAdvGroup = JSONObject.NULL;
            }
            CommonIdentifierKt.put(jSONObject, hiveKeys3, isAdvGroup);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(Promotion.getTAG(), "[PromotionNetwork] newsLogOpenAPI Exception: " + e);
        }
        setBasePostBody(protocol);
        protocol.setParam(HiveKeys.KEY_promotion, jSONObject);
        protocol.request(new Function1() { // from class: com.hive.promotion.PromotionNetwork$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PromotionNetwork.newsLogOpenAPI$lambda$11(callback, (NewsLogOpenBanner) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit newsLogOpenAPI$lambda$11(Function1 function1, NewsLogOpenBanner it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    public final void newsLogClickAPI(WebViewInfo webviewInfo, final Function1<? super NewsLogClickBanner, Unit> callback) {
        Intrinsics.checkNotNullParameter(webviewInfo, "webviewInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol<?> protocol = new Protocol<>(new Function0<NewsLogClickBanner>() { // from class: com.hive.promotion.PromotionNetwork$newsLogClickAPI$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.promotionv2.NewsLogClickBanner] */
            @Override // kotlin.jvm.functions.Function0
            public final NewsLogClickBanner invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = NewsLogClickBanner.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        JSONObject jSONObject = new JSONObject();
        try {
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_pid, Integer.valueOf(webviewInfo.getPid()));
            HiveKeys hiveKeys = HiveKeys.KEY_bucket_number;
            BannerDetail bannerDetail = webviewInfo.getBannerDetail();
            CommonIdentifierKt.put(jSONObject, hiveKeys, bannerDetail != null ? Integer.valueOf(bannerDetail.getBucketNumber()) : null);
            HiveKeys hiveKeys2 = HiveKeys.KEY_group_id;
            Object groupId = webviewInfo.getGroupId();
            if (groupId == null) {
                groupId = JSONObject.NULL;
            }
            CommonIdentifierKt.put(jSONObject, hiveKeys2, groupId);
            HiveKeys hiveKeys3 = HiveKeys.KEY_is_adv_group;
            Object isAdvGroup = webviewInfo.getIsAdvGroup();
            if (isAdvGroup == null) {
                isAdvGroup = JSONObject.NULL;
            }
            CommonIdentifierKt.put(jSONObject, hiveKeys3, isAdvGroup);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(Promotion.getTAG(), "[PromotionNetwork] newsLogClickAPI Exception: " + e);
        }
        setBasePostBody(protocol);
        protocol.setParam(HiveKeys.KEY_promotion, jSONObject);
        protocol.request(new Function1() { // from class: com.hive.promotion.PromotionNetwork$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PromotionNetwork.newsLogClickAPI$lambda$12(callback, (NewsLogClickBanner) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit newsLogClickAPI$lambda$12(Function1 function1, NewsLogClickBanner it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    public final void newsLogClickAPI(int pid, final Function1<? super NewsLogClickBanner, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol<?> protocol = new Protocol<>(new Function0<NewsLogClickBanner>() { // from class: com.hive.promotion.PromotionNetwork$newsLogClickAPI$$inlined$invoke$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.promotionv2.NewsLogClickBanner] */
            @Override // kotlin.jvm.functions.Function0
            public final NewsLogClickBanner invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = NewsLogClickBanner.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        JSONObject jSONObject = new JSONObject();
        try {
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_pid, Integer.valueOf(pid));
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_group_id, JSONObject.NULL);
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_is_adv_group, JSONObject.NULL);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(Promotion.getTAG(), "[PromotionNetwork] newsLogClickAPI Exception: " + e);
        }
        setBasePostBody(protocol);
        protocol.setParam(HiveKeys.KEY_promotion, jSONObject);
        protocol.request(new Function1() { // from class: com.hive.promotion.PromotionNetwork$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PromotionNetwork.newsLogClickAPI$lambda$13(callback, (NewsLogClickBanner) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit newsLogClickAPI$lambda$13(Function1 function1, NewsLogClickBanner it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    public final Object cpi(String str, HiveLifecycle.HiveAccount hiveAccount, boolean z, Continuation<? super Cpi> continuation) {
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<Cpi>() { // from class: com.hive.promotion.PromotionNetwork$cpi$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.promotionv2.Cpi] */
            @Override // kotlin.jvm.functions.Function0
            public final Cpi invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = Cpi.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        if (hiveAccount != null) {
            try {
                OauthToken oauthToken = hiveAccount.getOauthToken();
                if (oauthToken != null) {
                    protocol.setOauthToken(oauthToken);
                }
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(Promotion.getTAG(), "[PromotionNetwork] cpi Exception: " + e);
            }
        }
        protocol.setParam(HiveKeys.KEY_appid, Configuration.INSTANCE.getAppId());
        protocol.setParam(HiveKeys.KEY_did, HiveLifecycle.INSTANCE.getDid());
        protocol.setParam(HiveKeys.KEY_vid_type, str);
        protocol.setParam(HiveKeys.KEY_vid, hiveAccount != null ? hiveAccount.getVid() : null);
        protocol.setParam(HiveKeys.KEY_player_token, hiveAccount != null ? hiveAccount.getVidSession() : null);
        protocol.setParam(HiveKeys.KEY_uid, hiveAccount != null ? hiveAccount.getUid() : null);
        protocol.setParam(HiveKeys.KEY_device, Android.INSTANCE.getDeviceModel());
        protocol.setParam(HiveKeys.KEY_os_version, Android.INSTANCE.getOSVersion());
        protocol.setParam(HiveKeys.KEY_referrer, AnalyticsReferrerSender.INSTANCE.getReferrer());
        protocol.setParam(HiveKeys.KEY_game_language, Configuration.INSTANCE.getGameLanguage());
        protocol.setParam(HiveKeys.KEY_device_language, Android.INSTANCE.getLanguage());
        protocol.setParam(HiveKeys.KEY_hive_country, Configuration.INSTANCE.getHiveCountry());
        protocol.setParam(HiveKeys.KEY_advertising_id, Android.INSTANCE.getAdvertisingId());
        protocol.setParam(HiveKeys.KEY_is_limit_ad_tracking, Boxing.boxInt(Android.INSTANCE.isLimitAdTracking() ? 1 : 0));
        protocol.setParam(HiveKeys.KEY_agreement_determine_base, z ? "account" : DeviceRequestsHelper.DEVICE_INFO_DEVICE);
        try {
            if (!TextUtils.isEmpty(PromotionImpl.INSTANCE.getDeferredDeeplinkInfo$hive_promotion_release())) {
                LoggerImpl.INSTANCE.dL("CPI action, defer : " + PromotionImpl.INSTANCE.getDeferredDeeplinkInfo$hive_promotion_release());
                LoggerImpl.INSTANCE.dR("CPI action, defer");
                protocol.setParam(HiveKeys.KEY_deferred_link, PromotionImpl.INSTANCE.getDeferredDeeplinkInfo$hive_promotion_release());
            } else {
                LoggerImpl.INSTANCE.w("CPI action, defer empty");
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception e2) {
            LoggerImpl.INSTANCE.w("CPI action, exception: " + e2);
            Unit unit2 = Unit.INSTANCE;
        }
        return protocol.request();
    }

    public final void login(boolean isAgreementDetermineBaseAccount) {
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol<?> protocol = new Protocol<>(new Function0<Login>() { // from class: com.hive.promotion.PromotionNetwork$login$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.promotionv2.Login] */
            @Override // kotlin.jvm.functions.Function0
            public final Login invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = Login.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        INSTANCE.setBasePostBody(protocol);
        JSONObject jSONObject = new JSONObject();
        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_agreement_determine_base, isAgreementDetermineBaseAccount ? "account" : DeviceRequestsHelper.DEVICE_INFO_DEVICE);
        protocol.setParam(HiveKeys.KEY_promotion, jSONObject);
        protocol.request(new Function1() { // from class: com.hive.promotion.PromotionNetwork$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PromotionNetwork.login$lambda$17((Login) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit login$lambda$17(Login it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final Navigation navigation() {
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<Navigation>() { // from class: com.hive.promotion.PromotionNetwork$navigation$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.promotionv2.newsv2.Navigation] */
            @Override // kotlin.jvm.functions.Function0
            public final Navigation invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = Navigation.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            HiveLifecycle.HiveAccount account = HiveLifecycle.INSTANCE.getAccount();
            OauthToken oauthToken = account.getOauthToken();
            if (oauthToken != null) {
                protocol.setOauthToken(oauthToken);
            }
            protocol.setParam(HiveKeys.KEY_appid, Configuration.INSTANCE.getAppId());
            protocol.setParam(HiveKeys.KEY_game_language, Configuration.INSTANCE.getGameLanguage());
            protocol.setParam(HiveKeys.KEY_language, Android.INSTANCE.getLanguage());
            protocol.setParam(HiveKeys.KEY_hive_country, Configuration.INSTANCE.getHiveCountry());
            protocol.setParam(HiveKeys.KEY_device_country, Android.INSTANCE.getCountry());
            protocol.setParam(HiveKeys.KEY_server_id, Configuration.INSTANCE.getServerId());
            protocol.setParam(HiveKeys.KEY_analytics_id, Configuration.INSTANCE.getAnalyticsId());
            protocol.setParam(HiveKeys.KEY_sdk_version, Configuration.INSTANCE.getSdkVersion());
            protocol.setParam(HiveKeys.KEY_app_version, Product.INSTANCE.getBuildVersion());
            protocol.setParam(HiveKeys.KEY_app_version_display, Product.INSTANCE.getBuildVersion());
            protocol.setParam(HiveKeys.KEY_age_gate_u13, Boolean.valueOf(Configuration.INSTANCE.getAgeGateU13()));
            HiveKeys hiveKeys = HiveKeys.KEY_hive_theme;
            String value = Configuration.INSTANCE.getHiveTheme().getValue();
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = value.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            protocol.setParam(hiveKeys, lowerCase);
            protocol.setParam(HiveKeys.KEY_timezone, Configuration.INSTANCE.getTimezone());
            protocol.setParam(HiveKeys.KEY_did, account.getDid());
            protocol.setParam(HiveKeys.KEY_vid, account.getVid());
            protocol.setParam(HiveKeys.KEY_vid_type, account.getVidType());
            protocol.setParam(HiveKeys.KEY_player_token, account.getVidSession());
            protocol.setParam(HiveKeys.KEY_uid, account.getUid());
            protocol.setParam(HiveKeys.KEY_additionalinfo, additionalInfo);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(Promotion.getTAG(), "[PromotionNetwork] navigation Exception: " + e);
        }
        return (Navigation) protocol.request();
    }

    public final BannerList bannerList(String campaignType, String bannerType) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(bannerType, "bannerType");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol<?> protocol = new Protocol<>(new Function0<BannerList>() { // from class: com.hive.promotion.PromotionNetwork$bannerList$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.promotionv2.newsv2.BannerList] */
            @Override // kotlin.jvm.functions.Function0
            public final BannerList invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = BannerList.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        JSONObject jSONObject = new JSONObject();
        try {
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_type_camp, campaignType);
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_type_banner, bannerType);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(Promotion.getTAG(), "[PromotionNetwork] bannerList Exception: " + e);
        }
        setBasePostBody(protocol);
        protocol.setParam(HiveKeys.KEY_promotion, jSONObject);
        return (BannerList) protocol.request();
    }

    public final void banner(String typeCamp, String typeBanner, final Function2<? super Banner, ? super ArrayList<Promotion.PromotionBanner>, Unit> callback) {
        Intrinsics.checkNotNullParameter(typeCamp, "typeCamp");
        Intrinsics.checkNotNullParameter(typeBanner, "typeBanner");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol<?> protocol = new Protocol<>(new Function0<Banner>() { // from class: com.hive.promotion.PromotionNetwork$banner$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.promotionv2.Banner] */
            @Override // kotlin.jvm.functions.Function0
            public final Banner invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = Banner.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        JSONObject jSONObject = new JSONObject();
        try {
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_type_camp, typeCamp);
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_type_banner, typeBanner);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(Promotion.getTAG(), "[PromotionNetwork] banner Exception: " + e);
        }
        setBasePostBody(protocol);
        protocol.setParam(HiveKeys.KEY_promotion, jSONObject);
        protocol.request(new Function1() { // from class: com.hive.promotion.PromotionNetwork$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PromotionNetwork.banner$lambda$21(callback, (Banner) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit banner$lambda$21(Function2 function2, Banner it) {
        JSONArray bannerJsonArray;
        Intrinsics.checkNotNullParameter(it, "it");
        ArrayList arrayList = new ArrayList();
        if (it.getResponse().isSuccess() && (bannerJsonArray = it.getResponse().getBannerJsonArray()) != null) {
            int length = bannerJsonArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = bannerJsonArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(new Promotion.PromotionBanner(jSONObjectOptJSONObject));
                }
            }
        }
        function2.invoke(it, arrayList);
        return Unit.INSTANCE;
    }

    public final void badge(final Function1<? super com.hive.protocol.promotionv2.Badge, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol<?> protocol = new Protocol<>(new Function0<com.hive.protocol.promotionv2.Badge>() { // from class: com.hive.promotion.PromotionNetwork$badge$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.promotionv2.Badge] */
            @Override // kotlin.jvm.functions.Function0
            public final Badge invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = Badge.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject timeContentsRequested = PromotionBadgeManager.INSTANCE.getTimeContentsRequested();
            Iterator<String> itKeys = timeContentsRequested.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject = timeContentsRequested.optJSONObject(next);
                if (jSONObjectOptJSONObject != null) {
                    if (Intrinsics.areEqual(jSONObjectOptJSONObject.optString("type_webview"), "news") || Intrinsics.areEqual(jSONObjectOptJSONObject.optString("type_webview"), "notice")) {
                        CommonIdentifierKt.put(jSONObjectOptJSONObject, HiveKeys.KEY_dashboard_nav_id, next);
                        CommonIdentifierKt.put(jSONObjectOptJSONObject, HiveKeys.KEY_content_key, "");
                    } else {
                        CommonIdentifierKt.put(jSONObjectOptJSONObject, HiveKeys.KEY_dashboard_nav_id, "");
                        CommonIdentifierKt.put(jSONObjectOptJSONObject, HiveKeys.KEY_content_key, next);
                    }
                    jSONArray.put(jSONObjectOptJSONObject);
                }
            }
            jSONObject.put("click_info", jSONArray);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(Promotion.getTAG(), "[PromotionNetwork] badge Exception: " + e);
        }
        setBasePostBody(protocol);
        protocol.setParam(HiveKeys.KEY_promotion, jSONObject);
        protocol.request(new Function1() { // from class: com.hive.promotion.PromotionNetwork$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PromotionNetwork.badge$lambda$24(callback, (Badge) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit badge$lambda$24(Function1 function1, com.hive.protocol.promotionv2.Badge it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    public final void increaseCount(IncreaseCountSupportType supportType) {
        Intrinsics.checkNotNullParameter(supportType, "supportType");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<IncreaseCount>() { // from class: com.hive.promotion.PromotionNetwork$increaseCount$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.promotionv2.IncreaseCount] */
            @Override // kotlin.jvm.functions.Function0
            public final IncreaseCount invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = IncreaseCount.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        HiveLifecycle.HiveAccount account = HiveLifecycle.INSTANCE.getAccount();
        if (Configuration.INSTANCE.getHiveInterfaceType() != HiveInterfaceType.V4) {
            LoggerImpl.INSTANCE.d("[PromotionNetwork] increaseCount, request cancelled. (HiveSDK is not v4)");
            return;
        }
        try {
            protocol.setParam(HiveKeys.KEY_api_name, supportType.getValue());
            protocol.setParam(HiveKeys.KEY_appid, Configuration.INSTANCE.getAppId());
            String vid = account.getVid();
            if (vid != null && !StringsKt.isBlank(vid)) {
                protocol.setParam(HiveKeys.KEY_vid, account.getVid());
            }
            String did = HiveLifecycle.INSTANCE.getDid();
            if (did != null && did.length() != 0) {
                protocol.setParam(HiveKeys.KEY_did, HiveLifecycle.INSTANCE.getDid());
            }
            OauthToken oauthToken = account.getOauthToken();
            if (oauthToken != null) {
                protocol.setOauthToken(oauthToken);
            }
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(Promotion.getTAG(), "[PromotionNetwork] increaseCount Exception: " + e);
        }
        protocol.request(new Function1() { // from class: com.hive.promotion.PromotionNetwork$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PromotionNetwork.increaseCount$lambda$26((IncreaseCount) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit increaseCount$lambda$26(IncreaseCount it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResponse().isSuccess()) {
            LoggerImpl.INSTANCE.d("[PromotionNetwork] increaseCount, success");
        } else {
            LoggerImpl.INSTANCE.d("[PromotionNetwork] increaseCount, failed : " + it.getResponse());
        }
        return Unit.INSTANCE;
    }

    public final JSONObject putPromotionBasePostData$hive_promotion_release(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        LoggerImpl.INSTANCE.d("[PromotionNetwork] putPromotionBasePostData");
        try {
            HiveLifecycle.HiveAccount account = HiveLifecycle.INSTANCE.getAccount();
            String vid = account.getVid();
            String vid2 = (vid == null || StringsKt.isBlank(vid)) ? notDefinedVidValue : account.getVid();
            String vidType = account.getVidType();
            String vidSession = account.getVidSession();
            String did = HiveLifecycle.INSTANCE.getDid();
            Point displaySize = Android.INSTANCE.getDisplaySize(HiveActivity.INSTANCE.getRecentActivity());
            JSONObject jSONObjectPutCI = CommonIdentifierKt.putCI(new JSONObject());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_vid, vid2);
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_vid_type, vidType);
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_player_token, vidSession);
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_uid, account.getUid());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_uid_session, HiveLifecycle.INSTANCE.isC2SGuest() ? JSONObject.NULL : account.getUidSession());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_world, Configuration.INSTANCE.getServerId());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_did, did);
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_mac, JSONObject.NULL);
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_advertising_id, Android.INSTANCE.getAdvertisingId());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_is_limit_ad_tracking, Integer.valueOf(Android.INSTANCE.isLimitAdTracking() ? 1 : 0));
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_language, Configuration.INSTANCE.getGameLanguage());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_country, Android.INSTANCE.getCountry());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_width, String.valueOf(displaySize.x));
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_height, String.valueOf(displaySize.y));
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_device, Android.INSTANCE.getDeviceModel());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_os_version, Android.INSTANCE.getOSVersion());
            JSONObject jSONObject2 = new JSONObject();
            CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_appid, Configuration.INSTANCE.getAppId());
            CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_app_version, Android.INSTANCE.getAppVersion());
            CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_app_version_display, Android.INSTANCE.getAppVersion());
            CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_app_versioncode, Long.valueOf(Android.INSTANCE.getAppVersionCode()));
            CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_lib_version, JSONObject.NULL);
            CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_sdk_version, Configuration.INSTANCE.getSdkVersion());
            CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_additionalinfo, additionalInfo);
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_user, jSONObjectPutCI);
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_game, jSONObject2);
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_promotion, JSONObject.NULL);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(Promotion.getTAG(), "[PromotionNetwork] putPromotionBasePostData Exception : " + e);
        }
        return jSONObject;
    }

    private final Protocol<?> setBasePostBody(Protocol<?> protocol) {
        LoggerImpl.INSTANCE.d("[PromotionNetwork] setBasePostBody");
        OauthToken oauthToken = HiveLifecycle.INSTANCE.getAccount().getOauthToken();
        if (oauthToken != null) {
            protocol.setOauthToken(oauthToken);
        }
        JSONObject jSONObjectPutPromotionBasePostData$hive_promotion_release = putPromotionBasePostData$hive_promotion_release(new JSONObject());
        protocol.setParam(HiveKeys.KEY_user, jSONObjectPutPromotionBasePostData$hive_promotion_release.optJSONObject(HiveKeys.KEY_user.getValue()));
        protocol.setParam(HiveKeys.KEY_game, jSONObjectPutPromotionBasePostData$hive_promotion_release.optJSONObject(HiveKeys.KEY_game.getValue()));
        if (protocol.isNull(HiveKeys.KEY_promotion)) {
            protocol.setParam(HiveKeys.KEY_promotion, JSONObject.NULL);
        }
        return protocol;
    }
}
