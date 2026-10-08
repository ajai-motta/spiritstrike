package com.hive.promotion;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.hive.core.Scheme;
import com.hive.logger.LoggerImpl;
import com.hive.promotion.PromotionNetwork;
import com.hive.promotion.ui.PromotionView;
import com.hive.promotion.ui.PromotionViewImageBanner;
import com.hive.protocol.promotionv2.NewsLogClickBanner;
import com.hive.protocol.promotionv2.NewsLogOpenBanner;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: PromotionImpl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/hive/promotion/PromotionImpl$showCustomContents$1$1$onCreate$3$1", "Lcom/hive/promotion/ui/PromotionViewImageBanner$PromotionViewImageBannerListener;", "onTouch", "", "webViewInfo", "Lcom/hive/promotion/ui/PromotionView$WebViewInfo;", "onLoadingComplete", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromotionImpl$showCustomContents$1$1$onCreate$3$1 implements PromotionViewImageBanner.PromotionViewImageBannerListener {
    PromotionImpl$showCustomContents$1$1$onCreate$3$1() {
    }

    @Override // com.hive.promotion.ui.PromotionViewImageBanner.PromotionViewImageBannerListener
    public void onTouch(final PromotionView.WebViewInfo webViewInfo) {
        Intrinsics.checkNotNullParameter(webViewInfo, "webViewInfo");
        PromotionNetwork.INSTANCE.newsLogClickAPI(new PromotionNetwork.WebViewInfo(new JSONObject(webViewInfo.toString())), new Function1() { // from class: com.hive.promotion.PromotionImpl$showCustomContents$1$1$onCreate$3$1$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PromotionImpl$showCustomContents$1$1$onCreate$3$1.onTouch$lambda$2(webViewInfo, (NewsLogClickBanner) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onTouch$lambda$2(PromotionView.WebViewInfo webViewInfo, NewsLogClickBanner it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (!it.getResponse().isSuccess()) {
            LoggerImpl.INSTANCE.wL("[Promotion::newsLogClick(spotCrossPromotionClick)] request failed : " + it.getResponse());
        } else {
            if (it.getResponse().getResultCode() != 200) {
                LoggerImpl.INSTANCE.wL("[Promotion::newsLogClick(spotCrossPromotionClick)] response failed : " + it.getResponse());
                return Unit.INSTANCE;
            }
            PromotionView.WebViewInfo.BannerDetail bannerDetail = webViewInfo.getBannerDetail();
            String interworkUrl = bannerDetail != null ? bannerDetail.getInterworkUrl() : null;
            if (interworkUrl == null || StringsKt.isBlank(interworkUrl)) {
                StringBuilder sb = new StringBuilder();
                PromotionView.WebViewInfo.BannerDetail bannerDetail2 = webViewInfo.getBannerDetail();
                sb.append(bannerDetail2 != null ? bannerDetail2.getBannerLink() : null);
                if (!StringsKt.isBlank(it.getResponse().getTail())) {
                    sb.append("&cid=");
                    sb.append(it.getResponse().getId());
                    sb.append("&tid=");
                    sb.append(it.getResponse().getTail());
                }
                string = sb.toString();
            } else {
                PromotionView.WebViewInfo.BannerDetail bannerDetail3 = webViewInfo.getBannerDetail();
                if (bannerDetail3 != null) {
                    string = bannerDetail3.getInterworkUrl();
                }
            }
            Uri uri = Uri.parse(string);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            Intrinsics.checkNotNullExpressionValue(queryParameterNames, "getQueryParameterNames(...)");
            for (String str : queryParameterNames) {
                try {
                    linkedHashMap.put(str, uri.getQueryParameter(str));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            String scheme = uri.getScheme();
            String host = uri.getHost();
            String path = uri.getPath();
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            final Scheme scheme2 = new Scheme(scheme, host, path, linkedHashMap, string);
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.promotion.PromotionImpl$showCustomContents$1$1$onCreate$3$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PromotionImpl$showCustomContents$1$1$onCreate$3$1.onTouch$lambda$2$lambda$1(scheme2);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTouch$lambda$2$lambda$1(Scheme scheme) {
        PromotionImpl.INSTANCE.processPromotionScheme(scheme);
    }

    @Override // com.hive.promotion.ui.PromotionViewImageBanner.PromotionViewImageBannerListener
    public void onLoadingComplete(PromotionView.WebViewInfo webViewInfo) {
        Intrinsics.checkNotNullParameter(webViewInfo, "webViewInfo");
        PromotionNetwork.INSTANCE.newsLogOpenAPI(new PromotionNetwork.WebViewInfo(new JSONObject(webViewInfo.toString())), new Function1() { // from class: com.hive.promotion.PromotionImpl$showCustomContents$1$1$onCreate$3$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PromotionImpl$showCustomContents$1$1$onCreate$3$1.onLoadingComplete$lambda$3((NewsLogOpenBanner) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onLoadingComplete$lambda$3(NewsLogOpenBanner it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}
