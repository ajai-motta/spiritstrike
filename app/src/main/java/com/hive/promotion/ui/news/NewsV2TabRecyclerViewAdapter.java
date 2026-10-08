package com.hive.promotion.ui.news;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.Configuration;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.configuration.HiveTheme;
import com.hive.promotion.R;
import com.hive.promotion.ui.news.Navigation;
import com.hive.promotion.ui.news.NewsV2TabRecyclerViewAdapter;
import com.hive.ui.Util;
import com.hive.ui.effect.TouchEffectKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: NewsV2TabRecyclerViewAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\n\u0012\b\u0018\u00010\u0002R\u00020\u00000\u0001:\u0002#$B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012J\u001c\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0002J\u0014\u0010\u001d\u001a\u00020\n2\n\u0010\u001e\u001a\u00060\u0002R\u00020\u0000H\u0002J\u001c\u0010\u001f\u001a\u00020\u00172\n\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010 \u001a\u00020\nH\u0016J\b\u0010!\u001a\u00020\nH\u0016J\u001c\u0010\"\u001a\u00020\u00172\n\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010 \u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0018\u00010\u0002R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2TabRecyclerViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/hive/promotion/ui/news/NewsV2TabRecyclerViewAdapter$TabItemHolder;", "activity", "Landroid/app/Activity;", "mItemList", "Ljava/util/ArrayList;", "Lcom/hive/promotion/ui/news/Navigation$Menu;", "Lkotlin/collections/ArrayList;", FirebaseAnalytics.Param.INDEX, "", "clickedTimeList", "Lorg/json/JSONObject;", "<init>", "(Landroid/app/Activity;Ljava/util/ArrayList;ILorg/json/JSONObject;)V", "getClickedTimeList", "()Lorg/json/JSONObject;", "itemClickListener", "Lcom/hive/promotion/ui/news/NewsV2TabRecyclerViewAdapter$OnItemClickListener;", "selectedItemHolder", "isSelectedItem", "parentHeight", "setOnItemClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getTabListMargin", "getHolderHeightInLandScape", "holder", "onBindViewHolder", "position", "getItemCount", "setSelectedItemHolder", "OnItemClickListener", "TabItemHolder", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewsV2TabRecyclerViewAdapter extends RecyclerView.Adapter<TabItemHolder> {
    private final Activity activity;
    private final JSONObject clickedTimeList;
    private int isSelectedItem;
    private OnItemClickListener itemClickListener;
    private final ArrayList<Navigation.Menu> mItemList;
    private int parentHeight;
    private TabItemHolder selectedItemHolder;

    /* JADX INFO: compiled from: NewsV2TabRecyclerViewAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2TabRecyclerViewAdapter$OnItemClickListener;", "", "onItemClick", "", "v", "Landroid/view/View;", "position", "", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public NewsV2TabRecyclerViewAdapter(Activity activity, ArrayList<Navigation.Menu> mItemList, int i, JSONObject clickedTimeList) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(mItemList, "mItemList");
        Intrinsics.checkNotNullParameter(clickedTimeList, "clickedTimeList");
        this.activity = activity;
        this.mItemList = mItemList;
        this.clickedTimeList = clickedTimeList;
        this.isSelectedItem = i;
    }

    public final JSONObject getClickedTimeList() {
        return this.clickedTimeList;
    }

    public final void setOnItemClickListener(OnItemClickListener itemClickListener) {
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.itemClickListener = itemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TabItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.promotion_news_tab_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        if (this.parentHeight == 0 && parent.getHeight() != 0) {
            this.parentHeight = parent.getHeight();
        }
        return new TabItemHolder(this, viewInflate);
    }

    private final int getTabListMargin() {
        double d;
        double d2;
        if (Util.INSTANCE.isTable(this.activity)) {
            d = this.parentHeight;
            d2 = 0.0315d;
        } else {
            d = this.parentHeight;
            d2 = 0.0352d;
        }
        return (int) (d * d2);
    }

    private final int getHolderHeightInLandScape(TabItemHolder holder) {
        double tabListMargin;
        double d;
        if (this.parentHeight != 0) {
            if (Util.INSTANCE.isTable(this.activity)) {
                tabListMargin = this.parentHeight - getTabListMargin();
                d = 6.5d;
            } else {
                tabListMargin = this.parentHeight - getTabListMargin();
                d = 5.5d;
            }
            return (int) (tabListMargin / d);
        }
        Point screenSize = Util.INSTANCE.getScreenSize(this.activity);
        return (int) (screenSize.y * Util.INSTANCE.getFloat(this.activity, "promotion_news_tab_item_height_percent"));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TabItemHolder holder, int position) {
        String onLightDark;
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Point screenSize = Util.INSTANCE.getScreenSize(this.activity);
        ViewGroup.LayoutParams layoutParams = holder.getLayout().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (!Util.INSTANCE.isPortrait(this.activity)) {
            marginLayoutParams.height = getHolderHeightInLandScape(holder);
        }
        Navigation.Menu.Icon icon = this.mItemList.get(position).getIcon();
        if (icon == null || (onLightDark = icon.getOnLightDark()) == null) {
            onLightDark = "";
        }
        holder.setOnIconUrl$hive_promotion_release(onLightDark);
        String offDark = null;
        if (Configuration.INSTANCE.getHiveTheme() == HiveTheme.HiveLight) {
            Navigation.Menu.Icon icon2 = this.mItemList.get(position).getIcon();
            if (icon2 != null) {
                offDark = icon2.getOffLight();
            }
        } else {
            Navigation.Menu.Icon icon3 = this.mItemList.get(position).getIcon();
            if (icon3 != null) {
                offDark = icon3.getOffDark();
            }
        }
        holder.setOffIconUrl$hive_promotion_release(offDark != null ? offDark : "");
        holder.getName().setText(this.mItemList.get(position).getTitle());
        try {
            JSONObject jSONObjectOptJSONObject = this.clickedTimeList.optJSONObject(String.valueOf(this.mItemList.get(position).getId()));
            if (this.mItemList.get(position).getLastBannerUpdated() > (jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optLong("click_time") : 0L)) {
                holder.getBadge().setVisibility(0);
            } else {
                holder.getBadge().setVisibility(4);
            }
        } catch (Exception e) {
            Logger.INSTANCE.w("Set News Badge error: " + e.getMessage());
        }
        holder.offItem();
        if (Util.INSTANCE.isPortrait(this.activity)) {
            holder.getName().setTextSize((screenSize.x * Util.INSTANCE.getFloat(this.activity, "promotion_news_tab_item_text_size_percent")) / this.activity.getResources().getDisplayMetrics().scaledDensity);
            int size = this.mItemList.size() - 1;
            int i = (int) (screenSize.x * Util.INSTANCE.getFloat(this.activity, "promotion_news_tab_list_margin"));
            if (position == 0) {
                marginLayoutParams.setMargins(i, 0, 0, 0);
            } else if (position == size) {
                marginLayoutParams.setMargins(0, 0, i, 0);
            }
        } else {
            float f = (screenSize.y * Util.INSTANCE.getFloat(this.activity, "promotion_news_tab_item_text_size_percent")) / this.activity.getResources().getDisplayMetrics().scaledDensity;
            float f2 = (screenSize.y * Util.INSTANCE.getFloat(this.activity, "promotion_news_tab_item_text_min_size_percent")) / this.activity.getResources().getDisplayMetrics().scaledDensity;
            try {
                Result.Companion companion = Result.INSTANCE;
                TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(holder.getName(), (int) f2, (int) f, 1, 2);
                objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m7418exceptionOrNullimpl(objM7415constructorimpl) != null) {
                Logger.INSTANCE.w("TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration() onFailure");
            }
            holder.getName().setLineSpacing(0.0f, Util.INSTANCE.getFloat(this.activity, "promotion_news_tab_item_text_spacing_percent"));
            int size2 = this.mItemList.size() - 1;
            int i2 = (int) (screenSize.y * Util.INSTANCE.getFloat(this.activity, "promotion_news_tab_list_margin"));
            if (position == 0) {
                marginLayoutParams.setMargins(0, i2, 0, 0);
            } else if (position == size2) {
                marginLayoutParams.setMargins(0, 0, 0, i2);
            }
        }
        if (this.isSelectedItem == position) {
            setSelectedItemHolder(holder, position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mItemList.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSelectedItemHolder(TabItemHolder holder, int position) {
        AppCompatImageView badge;
        TabItemHolder tabItemHolder = this.selectedItemHolder;
        if (tabItemHolder != null) {
            if (tabItemHolder != null) {
                tabItemHolder.offItem();
            }
            TabItemHolder tabItemHolder2 = this.selectedItemHolder;
            if (tabItemHolder2 != null && (badge = tabItemHolder2.getBadge()) != null) {
                badge.setVisibility(4);
            }
        }
        String strValueOf = String.valueOf(this.mItemList.get(position).getId());
        int lastBannerUpdated = this.mItemList.get(position).getLastBannerUpdated();
        String str = Intrinsics.areEqual(this.mItemList.get(position).getPromotionType(), "fixed_notice") ? "notice" : "news";
        JSONObject jSONObject = new JSONObject();
        try {
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_click_time, Integer.valueOf(lastBannerUpdated));
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_type_webview, str);
            this.clickedTimeList.put(strValueOf, jSONObject);
        } catch (Exception e) {
            Logger.INSTANCE.w("[NewsV2TabRecyclerViewAdapter] Failed put to json object (e: " + e.getMessage());
        }
        this.selectedItemHolder = holder;
        if (holder != null) {
            holder.onItem();
        }
    }

    /* JADX INFO: compiled from: NewsV2TabRecyclerViewAdapter.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020&R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\t\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u0019X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!¨\u0006("}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2TabRecyclerViewAdapter$TabItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/hive/promotion/ui/news/NewsV2TabRecyclerViewAdapter;Landroid/view/View;)V", TtmlNode.TAG_LAYOUT, "Landroidx/constraintlayout/widget/ConstraintLayout;", "getLayout$hive_promotion_release", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "textViewLayout", "getTextViewLayout$hive_promotion_release", "setTextViewLayout$hive_promotion_release", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "background", "Landroidx/appcompat/widget/AppCompatImageView;", "getBackground$hive_promotion_release", "()Landroidx/appcompat/widget/AppCompatImageView;", "overlay_background", "getOverlay_background$hive_promotion_release", "icon", "getIcon$hive_promotion_release", "badge", "getBadge$hive_promotion_release", "name", "Landroidx/appcompat/widget/AppCompatTextView;", "getName$hive_promotion_release", "()Landroidx/appcompat/widget/AppCompatTextView;", "onIconUrl", "", "getOnIconUrl$hive_promotion_release", "()Ljava/lang/String;", "setOnIconUrl$hive_promotion_release", "(Ljava/lang/String;)V", "offIconUrl", "getOffIconUrl$hive_promotion_release", "setOffIconUrl$hive_promotion_release", "onItem", "", "offItem", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class TabItemHolder extends RecyclerView.ViewHolder {
        private final AppCompatImageView background;
        private final AppCompatImageView badge;
        private final AppCompatImageView icon;
        private final ConstraintLayout layout;
        private final AppCompatTextView name;
        private String offIconUrl;
        private String onIconUrl;
        private final AppCompatImageView overlay_background;
        private ConstraintLayout textViewLayout;
        final /* synthetic */ NewsV2TabRecyclerViewAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TabItemHolder(final NewsV2TabRecyclerViewAdapter newsV2TabRecyclerViewAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = newsV2TabRecyclerViewAdapter;
            this.onIconUrl = "";
            this.offIconUrl = "";
            View viewFindViewById = itemView.findViewById(R.id.tabItem_layout);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            this.layout = (ConstraintLayout) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.tabItem_background);
            Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
            AppCompatImageView appCompatImageView = (AppCompatImageView) viewFindViewById2;
            this.background = appCompatImageView;
            View viewFindViewById3 = itemView.findViewById(R.id.tabItem_overlay_background);
            Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) viewFindViewById3;
            this.overlay_background = appCompatImageView2;
            View viewFindViewById4 = itemView.findViewById(R.id.tabItem_icon);
            Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
            this.icon = (AppCompatImageView) viewFindViewById4;
            View viewFindViewById5 = itemView.findViewById(R.id.tabItem_badge);
            Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
            this.badge = (AppCompatImageView) viewFindViewById5;
            View viewFindViewById6 = itemView.findViewById(R.id.tabItem_textView);
            Intrinsics.checkNotNull(viewFindViewById6, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatTextView");
            this.name = (AppCompatTextView) viewFindViewById6;
            if (Util.INSTANCE.isPortrait(newsV2TabRecyclerViewAdapter.activity)) {
                View viewFindViewById7 = itemView.findViewById(R.id.tabItem_textView_layout);
                Intrinsics.checkNotNull(viewFindViewById7, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
                this.textViewLayout = (ConstraintLayout) viewFindViewById7;
            }
            TouchEffectKt.setTouchEffect(appCompatImageView, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : Color.argb(66, 0, 0, 0), (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? null : null);
            TouchEffectKt.setTouchEffect(appCompatImageView2, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : Configuration.INSTANCE.getHiveTheme() == HiveTheme.HiveLight ? Color.argb(41, 0, 0, 0) : Color.argb(41, 255, 255, 255), (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : PorterDuff.Mode.OVERLAY, (63 & 64) == 0 ? new Function1() { // from class: com.hive.promotion.ui.news.NewsV2TabRecyclerViewAdapter$TabItemHolder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NewsV2TabRecyclerViewAdapter.TabItemHolder._init_$lambda$0(this.f$0, newsV2TabRecyclerViewAdapter, (View) obj);
                }
            } : null);
        }

        /* JADX INFO: renamed from: getLayout$hive_promotion_release, reason: from getter */
        public final ConstraintLayout getLayout() {
            return this.layout;
        }

        /* JADX INFO: renamed from: getTextViewLayout$hive_promotion_release, reason: from getter */
        public final ConstraintLayout getTextViewLayout() {
            return this.textViewLayout;
        }

        public final void setTextViewLayout$hive_promotion_release(ConstraintLayout constraintLayout) {
            this.textViewLayout = constraintLayout;
        }

        /* JADX INFO: renamed from: getBackground$hive_promotion_release, reason: from getter */
        public final AppCompatImageView getBackground() {
            return this.background;
        }

        /* JADX INFO: renamed from: getOverlay_background$hive_promotion_release, reason: from getter */
        public final AppCompatImageView getOverlay_background() {
            return this.overlay_background;
        }

        /* JADX INFO: renamed from: getIcon$hive_promotion_release, reason: from getter */
        public final AppCompatImageView getIcon() {
            return this.icon;
        }

        /* JADX INFO: renamed from: getBadge$hive_promotion_release, reason: from getter */
        public final AppCompatImageView getBadge() {
            return this.badge;
        }

        /* JADX INFO: renamed from: getName$hive_promotion_release, reason: from getter */
        public final AppCompatTextView getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: getOnIconUrl$hive_promotion_release, reason: from getter */
        public final String getOnIconUrl() {
            return this.onIconUrl;
        }

        public final void setOnIconUrl$hive_promotion_release(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.onIconUrl = str;
        }

        /* JADX INFO: renamed from: getOffIconUrl$hive_promotion_release, reason: from getter */
        public final String getOffIconUrl() {
            return this.offIconUrl;
        }

        public final void setOffIconUrl$hive_promotion_release(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.offIconUrl = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit _init_$lambda$0(TabItemHolder tabItemHolder, NewsV2TabRecyclerViewAdapter newsV2TabRecyclerViewAdapter, View view) {
            int absoluteAdapterPosition = tabItemHolder.getAbsoluteAdapterPosition();
            if (absoluteAdapterPosition != -1 && newsV2TabRecyclerViewAdapter.itemClickListener != null) {
                newsV2TabRecyclerViewAdapter.isSelectedItem = absoluteAdapterPosition;
                newsV2TabRecyclerViewAdapter.setSelectedItemHolder(tabItemHolder, absoluteAdapterPosition);
                OnItemClickListener onItemClickListener = newsV2TabRecyclerViewAdapter.itemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(view, absoluteAdapterPosition);
                }
            }
            return Unit.INSTANCE;
        }

        public final void onItem() {
            ConstraintLayout constraintLayout;
            try {
                this.background.setVisibility(0);
                this.overlay_background.setVisibility(4);
                this.name.setTextColor(this.this$0.activity.getResources().getColor(com.hive.ui.R.color.colorWhite));
                Glide.with(this.this$0.activity).load(this.onIconUrl).into(this.icon);
                if (!Util.INSTANCE.isPortrait(this.this$0.activity) || (constraintLayout = this.textViewLayout) == null) {
                    return;
                }
                constraintLayout.setVisibility(0);
            } catch (Exception e) {
                Logger.INSTANCE.w("[NewsV2TabRecyclerViewAdapter] onItem() \ne: " + e.getMessage());
            }
        }

        public final void offItem() {
            ConstraintLayout constraintLayout;
            try {
                this.background.setVisibility(4);
                this.overlay_background.setVisibility(0);
                TypedArray typedArrayObtainStyledAttributes = this.this$0.activity.getTheme().obtainStyledAttributes(R.styleable.NewsColorStyle);
                Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
                this.name.setTextColor(typedArrayObtainStyledAttributes.getColor(R.styleable.NewsColorStyle_newsOffColor, -16777216));
                Glide.with(this.this$0.activity).load(this.offIconUrl).into(this.icon);
                if (!Util.INSTANCE.isPortrait(this.this$0.activity) || (constraintLayout = this.textViewLayout) == null) {
                    return;
                }
                constraintLayout.setVisibility(8);
            } catch (Exception e) {
                Logger.INSTANCE.w("[NewsV2TabRecyclerViewAdapter] offItem() \ne: " + e.getMessage());
            }
        }
    }
}
