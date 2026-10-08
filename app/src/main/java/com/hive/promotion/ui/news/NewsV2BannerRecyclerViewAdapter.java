package com.hive.promotion.ui.news;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.hive.core.Logger;
import com.hive.promotion.R;
import com.hive.promotion.ui.news.BannerList;
import com.hive.promotion.ui.news.NewsV2BannerRecyclerViewAdapter;
import com.hive.ui.Util;
import com.hive.ui.effect.TouchEffectKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: NewsV2BannerRecyclerViewAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001d\u001e\u001fB+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0016J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0006j\b\u0012\u0004\u0012\u00020\f`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2BannerRecyclerViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "activity", "Landroid/app/Activity;", "mItemList", "Ljava/util/ArrayList;", "Lcom/hive/promotion/ui/news/BannerList$Banner;", "Lkotlin/collections/ArrayList;", "<init>", "(Landroid/app/Activity;Ljava/util/ArrayList;)V", "TYPE_ITEM", "", "TYPE_FOOTER", "itemClickListener", "Lcom/hive/promotion/ui/news/NewsV2BannerRecyclerViewAdapter$OnItemClickListener;", "notDownloadIndex", "parentWidth", "setOnItemClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemViewType", "getItemCount", "OnItemClickListener", "ItemHolder", "FooterHolder", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewsV2BannerRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int TYPE_FOOTER;
    private final int TYPE_ITEM;
    private final Activity activity;
    private OnItemClickListener itemClickListener;
    private final ArrayList<BannerList.Banner> mItemList;
    private ArrayList<Integer> notDownloadIndex;
    private int parentWidth;

    /* JADX INFO: compiled from: NewsV2BannerRecyclerViewAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2BannerRecyclerViewAdapter$OnItemClickListener;", "", "onItemClick", "", "v", "Landroid/view/View;", "position", "", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public NewsV2BannerRecyclerViewAdapter(Activity activity, ArrayList<BannerList.Banner> arrayList) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.mItemList = arrayList;
        this.TYPE_FOOTER = 1;
        this.notDownloadIndex = new ArrayList<>();
    }

    public final void setOnItemClickListener(OnItemClickListener itemClickListener) {
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.itemClickListener = itemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.parentWidth = parent.getWidth();
        if (viewType == this.TYPE_ITEM) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.promotion_news_banner_item, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ItemHolder(this, viewInflate);
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.promotion_news_banner_footer_item, parent, false);
        Intrinsics.checkNotNull(viewInflate2);
        return new FooterHolder(this, viewInflate2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof ItemHolder) {
            Point screenSize = Util.INSTANCE.getScreenSize(this.activity);
            ItemHolder itemHolder = (ItemHolder) holder;
            ViewGroup.LayoutParams layoutParams = itemHolder.getLayout().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (position == 0) {
                marginLayoutParams.setMargins(0, (int) (screenSize.y * Util.INSTANCE.getFloat(this.activity, "promotion_news_banner_item_marginTop_percent")), 0, 0);
            } else {
                marginLayoutParams.setMargins(0, 0, 0, 0);
            }
            ArrayList<BannerList.Banner> arrayList = this.mItemList;
            if (arrayList != null) {
                if (!NewsV2Activity.INSTANCE.getDownloadBannerList().containsKey(Integer.valueOf(arrayList.get(position).getPid()))) {
                    this.notDownloadIndex.add(Integer.valueOf(position));
                    marginLayoutParams.height = 0;
                    return;
                }
                itemHolder.getLayout().setVisibility(0);
                if (!StringsKt.isBlank(arrayList.get(position).getImage())) {
                    Glide.with(this.activity).asBitmap().load(arrayList.get(position).getImage()).override(Integer.MIN_VALUE).listener(new RequestListener<Bitmap>() { // from class: com.hive.promotion.ui.news.NewsV2BannerRecyclerViewAdapter$onBindViewHolder$1$1
                        @Override // com.bumptech.glide.request.RequestListener
                        public boolean onLoadFailed(GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                            Intrinsics.checkNotNullParameter(target, "target");
                            Logger logger = Logger.INSTANCE;
                            StringBuilder sb = new StringBuilder("[NewsV2BannerRecyclerViewAdapter] onLoadFailed() GlideException: ");
                            sb.append(e != null ? e.toString() : null);
                            sb.append("\nGlideException.message: ");
                            sb.append(e != null ? e.getMessage() : null);
                            logger.w(sb.toString());
                            return false;
                        }

                        @Override // com.bumptech.glide.request.RequestListener
                        public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                            Intrinsics.checkNotNullParameter(resource, "resource");
                            Intrinsics.checkNotNullParameter(model, "model");
                            Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                            Logger.INSTANCE.d("[NewsV2BannerRecyclerViewAdapter] onResourceReady() height: " + resource.getHeight() + ", width: " + resource.getWidth());
                            marginLayoutParams.height = (int) ((((float) resource.getHeight()) / ((float) resource.getWidth())) * ((float) this.parentWidth));
                            return false;
                        }
                    }).into(itemHolder.getItemImageView());
                }
                ArrayList<Integer> giftPidList = NewsV2Activity.INSTANCE.getGiftPidList();
                if (giftPidList != null) {
                    if (giftPidList.contains(Integer.valueOf(arrayList.get(position).getPid()))) {
                        Navigation navigation = NewsV2Activity.INSTANCE.getNavigation();
                        if (navigation != null && (!StringsKt.isBlank(navigation.getGiftBoxIconUrl()))) {
                            itemHolder.getGiftImageView().setVisibility(0);
                            Glide.with(this.activity).load(navigation.getGiftBoxIconUrl()).override(Integer.MIN_VALUE).into(itemHolder.getGiftImageView());
                        }
                    } else {
                        itemHolder.getGiftImageView().setVisibility(4);
                    }
                }
                ViewTreeObserver.OnPreDrawListener currentOnPreDrawListener = itemHolder.getCurrentOnPreDrawListener();
                if (currentOnPreDrawListener != null) {
                    if (holder.itemView.getViewTreeObserver().isAlive()) {
                        holder.itemView.getViewTreeObserver().removeOnPreDrawListener(currentOnPreDrawListener);
                    }
                    itemHolder.setCurrentOnPreDrawListener(null);
                }
                BannerList.Badge badge = arrayList.get(position).getBadge();
                if (badge != null) {
                    String type = badge.getType();
                    if (!Intrinsics.areEqual(type, "shutdown") && Intrinsics.areEqual(type, "gift")) {
                        itemHolder.getBadgeImageView().setImageResource(R.drawable.promotion_news_v2_badge_gift_icon);
                    } else {
                        itemHolder.getBadgeImageView().setImageResource(R.drawable.promotion_news_v2_badge_time_icon);
                    }
                    itemHolder.getBadgeTextView().setText(badge.getTitle());
                    itemHolder.getBadgeLayout().setVisibility(0);
                    if (itemHolder.getGiftImageView().getMeasuredHeight() == 0) {
                        itemHolder.setCurrentOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.hive.promotion.ui.news.NewsV2BannerRecyclerViewAdapter$onBindViewHolder$1$4$1
                            @Override // android.view.ViewTreeObserver.OnPreDrawListener
                            public boolean onPreDraw() {
                                int bindingAdapterPosition = ((NewsV2BannerRecyclerViewAdapter.ItemHolder) holder).getBindingAdapterPosition();
                                if (bindingAdapterPosition == -1 || bindingAdapterPosition != position) {
                                    if (holder.itemView.getViewTreeObserver().isAlive()) {
                                        holder.itemView.getViewTreeObserver().removeOnPreDrawListener(this);
                                    }
                                    ((NewsV2BannerRecyclerViewAdapter.ItemHolder) holder).setCurrentOnPreDrawListener(null);
                                    return true;
                                }
                                if (((NewsV2BannerRecyclerViewAdapter.ItemHolder) holder).getGiftImageView().getMeasuredHeight() == 0) {
                                    return true;
                                }
                                if (holder.itemView.getViewTreeObserver().isAlive()) {
                                    holder.itemView.getViewTreeObserver().removeOnPreDrawListener(this);
                                }
                                ((NewsV2BannerRecyclerViewAdapter.ItemHolder) holder).setCurrentOnPreDrawListener(null);
                                ((NewsV2BannerRecyclerViewAdapter.ItemHolder) holder).resizeBadgeLayout();
                                return false;
                            }
                        });
                        holder.itemView.getViewTreeObserver().addOnPreDrawListener(itemHolder.getCurrentOnPreDrawListener());
                        return;
                    } else {
                        itemHolder.resizeBadgeLayout();
                        return;
                    }
                }
                itemHolder.getBadgeLayout().setVisibility(4);
                return;
            }
            return;
        }
        if (holder instanceof FooterHolder) {
            Point screenSize2 = Util.INSTANCE.getScreenSize(this.activity);
            FooterHolder footerHolder = (FooterHolder) holder;
            ViewGroup.LayoutParams layoutParams2 = footerHolder.getLayout().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            marginLayoutParams2.height = (int) (screenSize2.y * Util.INSTANCE.getFloat(this.activity, "promotion_news_banner_footer_item_height_percent"));
            marginLayoutParams2.setMargins(0, 0, 0, (int) (screenSize2.y * Util.INSTANCE.getFloat(this.activity, "promotion_news_banner_item_marginTop_percent")));
            Iterator<Map.Entry<Integer, BannerList>> it = NewsV2Activity.INSTANCE.getBannerLists().entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().getBannerList().size();
            }
            footerHolder.getLayout().setVisibility(this.notDownloadIndex.isEmpty() ? 4 : 0);
            TouchEffectKt.setTouchEffect(footerHolder.getRefreshButton(), (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : Color.argb(66, 0, 0, 0), (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.promotion.ui.news.NewsV2BannerRecyclerViewAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NewsV2BannerRecyclerViewAdapter.onBindViewHolder$lambda$9(this.f$0, (View) obj);
                }
            } : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$9(NewsV2BannerRecyclerViewAdapter newsV2BannerRecyclerViewAdapter, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Iterator<T> it2 = newsV2BannerRecyclerViewAdapter.notDownloadIndex.iterator();
        while (it2.hasNext()) {
            final int iIntValue = ((Number) it2.next()).intValue();
            final ArrayList<BannerList.Banner> arrayList = newsV2BannerRecyclerViewAdapter.mItemList;
            if (arrayList != null) {
                Glide.with(newsV2BannerRecyclerViewAdapter.activity).load(arrayList.get(iIntValue).getImage()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.DATA).listener(new RequestListener<Drawable>() { // from class: com.hive.promotion.ui.news.NewsV2BannerRecyclerViewAdapter$onBindViewHolder$3$1$1$1
                    @Override // com.bumptech.glide.request.RequestListener
                    public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        Intrinsics.checkNotNullParameter(target, "target");
                        Logger.INSTANCE.w("[NewsV2BannerRecyclerViewAdapter] load(" + arrayList.get(iIntValue).getImage() + ") onLoadFailed()\nGlideException: " + e);
                        return false;
                    }

                    @Override // com.bumptech.glide.request.RequestListener
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        Intrinsics.checkNotNullParameter(resource, "resource");
                        Intrinsics.checkNotNullParameter(model, "model");
                        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                        Logger.INSTANCE.d("[NewsV2BannerRecyclerViewAdapter] load(" + arrayList.get(iIntValue).getImage() + ") onResourceReady()\n");
                        NewsV2Activity.INSTANCE.getDownloadBannerList().put(Integer.valueOf(arrayList.get(iIntValue).getPid()), arrayList.get(iIntValue).getImage());
                        return false;
                    }
                }).preload();
            }
        }
        newsV2BannerRecyclerViewAdapter.notDownloadIndex.clear();
        newsV2BannerRecyclerViewAdapter.notifyDataSetChanged();
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        ArrayList<BannerList.Banner> arrayList = this.mItemList;
        if (arrayList != null) {
            return position == arrayList.size() ? this.TYPE_FOOTER : this.TYPE_ITEM;
        }
        return this.TYPE_ITEM;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<BannerList.Banner> arrayList = this.mItemList;
        if (arrayList != null) {
            return arrayList.size() + 1;
        }
        return 0;
    }

    /* JADX INFO: compiled from: NewsV2BannerRecyclerViewAdapter.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010+\u001a\u00020,R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0014\u0010\u0012\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0019X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u0019X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001fX\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2BannerRecyclerViewAdapter$ItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/hive/promotion/ui/news/NewsV2BannerRecyclerViewAdapter;Landroid/view/View;)V", TtmlNode.TAG_LAYOUT, "Landroidx/constraintlayout/widget/ConstraintLayout;", "getLayout$hive_promotion_release", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "itemImageView", "Landroidx/appcompat/widget/AppCompatImageView;", "getItemImageView$hive_promotion_release", "()Landroidx/appcompat/widget/AppCompatImageView;", "giftImageView", "getGiftImageView$hive_promotion_release", "badgeLayout", "getBadgeLayout$hive_promotion_release", "badgeImageView", "getBadgeImageView$hive_promotion_release", "badgeTextView", "Landroid/widget/TextView;", "getBadgeTextView$hive_promotion_release", "()Landroid/widget/TextView;", "badgeSpaceLeft", "Landroid/widget/Space;", "getBadgeSpaceLeft$hive_promotion_release", "()Landroid/widget/Space;", "badgeSpaceBottom", "getBadgeSpaceBottom$hive_promotion_release", "TABLET_GIFT_ICON_HEIGHT", "", "TABLET_BADGE_LAYOUT_HEIGHT", "TABLET_BADGE_FONT_HEIGHT", "MOBILE_GIFT_ICON_HEIGHT", "MOBILE_BADGE_LAYOUT_HEIGHT", "MOBILE_BADGE_FONT_HEIGHT", "currentOnPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "getCurrentOnPreDrawListener", "()Landroid/view/ViewTreeObserver$OnPreDrawListener;", "setCurrentOnPreDrawListener", "(Landroid/view/ViewTreeObserver$OnPreDrawListener;)V", "resizeBadgeLayout", "", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ItemHolder extends RecyclerView.ViewHolder {
        private final float MOBILE_BADGE_FONT_HEIGHT;
        private final float MOBILE_BADGE_LAYOUT_HEIGHT;
        private final float MOBILE_GIFT_ICON_HEIGHT;
        private final float TABLET_BADGE_FONT_HEIGHT;
        private final float TABLET_BADGE_LAYOUT_HEIGHT;
        private final float TABLET_GIFT_ICON_HEIGHT;
        private final AppCompatImageView badgeImageView;
        private final ConstraintLayout badgeLayout;
        private final Space badgeSpaceBottom;
        private final Space badgeSpaceLeft;
        private final TextView badgeTextView;
        private ViewTreeObserver.OnPreDrawListener currentOnPreDrawListener;
        private final AppCompatImageView giftImageView;
        private final AppCompatImageView itemImageView;
        private final ConstraintLayout layout;
        final /* synthetic */ NewsV2BannerRecyclerViewAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemHolder(final NewsV2BannerRecyclerViewAdapter newsV2BannerRecyclerViewAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = newsV2BannerRecyclerViewAdapter;
            View viewFindViewById = itemView.findViewById(R.id.bannerItem_layout);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            this.layout = (ConstraintLayout) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.promotion_news_banner_item_imageView);
            Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
            AppCompatImageView appCompatImageView = (AppCompatImageView) viewFindViewById2;
            this.itemImageView = appCompatImageView;
            View viewFindViewById3 = itemView.findViewById(R.id.promotion_news_banner_item_gift_imageView);
            Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
            this.giftImageView = (AppCompatImageView) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(R.id.promotion_news_banner_item_badge_layout);
            Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            this.badgeLayout = (ConstraintLayout) viewFindViewById4;
            View viewFindViewById5 = itemView.findViewById(R.id.promotion_news_banner_item_badge_icon_image);
            Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
            this.badgeImageView = (AppCompatImageView) viewFindViewById5;
            View viewFindViewById6 = itemView.findViewById(R.id.promotion_news_banner_item_badge_text);
            Intrinsics.checkNotNull(viewFindViewById6, "null cannot be cast to non-null type android.widget.TextView");
            this.badgeTextView = (TextView) viewFindViewById6;
            View viewFindViewById7 = itemView.findViewById(R.id.promotion_news_banner_badge_marginLeft);
            Intrinsics.checkNotNull(viewFindViewById7, "null cannot be cast to non-null type android.widget.Space");
            this.badgeSpaceLeft = (Space) viewFindViewById7;
            View viewFindViewById8 = itemView.findViewById(R.id.promotion_news_banner_badge_marginBottom);
            Intrinsics.checkNotNull(viewFindViewById8, "null cannot be cast to non-null type android.widget.Space");
            this.badgeSpaceBottom = (Space) viewFindViewById8;
            this.TABLET_GIFT_ICON_HEIGHT = 52.0f;
            this.TABLET_BADGE_LAYOUT_HEIGHT = 28.0f;
            this.TABLET_BADGE_FONT_HEIGHT = 12.0f;
            this.MOBILE_GIFT_ICON_HEIGHT = 32.0f;
            this.MOBILE_BADGE_LAYOUT_HEIGHT = 20.0f;
            this.MOBILE_BADGE_FONT_HEIGHT = 9.0f;
            TouchEffectKt.setTouchEffect(appCompatImageView, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : Color.argb(66, 0, 0, 0), (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 300L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : PorterDuff.Mode.DARKEN, (63 & 64) == 0 ? new Function1() { // from class: com.hive.promotion.ui.news.NewsV2BannerRecyclerViewAdapter$ItemHolder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NewsV2BannerRecyclerViewAdapter.ItemHolder._init_$lambda$0(this.f$0, newsV2BannerRecyclerViewAdapter, (View) obj);
                }
            } : null);
        }

        /* JADX INFO: renamed from: getLayout$hive_promotion_release, reason: from getter */
        public final ConstraintLayout getLayout() {
            return this.layout;
        }

        /* JADX INFO: renamed from: getItemImageView$hive_promotion_release, reason: from getter */
        public final AppCompatImageView getItemImageView() {
            return this.itemImageView;
        }

        /* JADX INFO: renamed from: getGiftImageView$hive_promotion_release, reason: from getter */
        public final AppCompatImageView getGiftImageView() {
            return this.giftImageView;
        }

        /* JADX INFO: renamed from: getBadgeLayout$hive_promotion_release, reason: from getter */
        public final ConstraintLayout getBadgeLayout() {
            return this.badgeLayout;
        }

        /* JADX INFO: renamed from: getBadgeImageView$hive_promotion_release, reason: from getter */
        public final AppCompatImageView getBadgeImageView() {
            return this.badgeImageView;
        }

        /* JADX INFO: renamed from: getBadgeTextView$hive_promotion_release, reason: from getter */
        public final TextView getBadgeTextView() {
            return this.badgeTextView;
        }

        /* JADX INFO: renamed from: getBadgeSpaceLeft$hive_promotion_release, reason: from getter */
        public final Space getBadgeSpaceLeft() {
            return this.badgeSpaceLeft;
        }

        /* JADX INFO: renamed from: getBadgeSpaceBottom$hive_promotion_release, reason: from getter */
        public final Space getBadgeSpaceBottom() {
            return this.badgeSpaceBottom;
        }

        public final ViewTreeObserver.OnPreDrawListener getCurrentOnPreDrawListener() {
            return this.currentOnPreDrawListener;
        }

        public final void setCurrentOnPreDrawListener(ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
            this.currentOnPreDrawListener = onPreDrawListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit _init_$lambda$0(ItemHolder itemHolder, NewsV2BannerRecyclerViewAdapter newsV2BannerRecyclerViewAdapter, View view) {
            OnItemClickListener onItemClickListener;
            int absoluteAdapterPosition = itemHolder.getAbsoluteAdapterPosition();
            if (absoluteAdapterPosition != -1 && newsV2BannerRecyclerViewAdapter.itemClickListener != null && (onItemClickListener = newsV2BannerRecyclerViewAdapter.itemClickListener) != null) {
                onItemClickListener.onItemClick(view, absoluteAdapterPosition);
            }
            return Unit.INSTANCE;
        }

        public final void resizeBadgeLayout() {
            float f;
            float f2;
            float f3;
            float f4;
            int height = this.giftImageView.getHeight();
            boolean z = this.this$0.activity.getResources().getBoolean(R.bool.com_hive_sdk_ui_is_tablet);
            float f5 = height;
            if (z) {
                f = this.TABLET_BADGE_LAYOUT_HEIGHT;
                f2 = this.TABLET_GIFT_ICON_HEIGHT;
            } else {
                f = this.MOBILE_BADGE_LAYOUT_HEIGHT;
                f2 = this.MOBILE_GIFT_ICON_HEIGHT;
            }
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, (int) (f5 * (f / f2)));
            layoutParams.startToEnd = this.badgeSpaceLeft.getId();
            layoutParams.bottomToTop = this.badgeSpaceBottom.getId();
            this.badgeLayout.setLayoutParams(layoutParams);
            if (z) {
                f3 = this.TABLET_BADGE_FONT_HEIGHT;
                f4 = this.TABLET_GIFT_ICON_HEIGHT;
            } else {
                f3 = this.MOBILE_BADGE_FONT_HEIGHT;
                f4 = this.MOBILE_GIFT_ICON_HEIGHT;
            }
            this.badgeTextView.setTextSize((height * (f3 / f4)) / this.this$0.activity.getResources().getDisplayMetrics().scaledDensity);
        }
    }

    /* JADX INFO: compiled from: NewsV2BannerRecyclerViewAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2BannerRecyclerViewAdapter$FooterHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "footer", "Landroid/view/View;", "<init>", "(Lcom/hive/promotion/ui/news/NewsV2BannerRecyclerViewAdapter;Landroid/view/View;)V", TtmlNode.TAG_LAYOUT, "Landroidx/constraintlayout/widget/ConstraintLayout;", "getLayout$hive_promotion_release", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "refreshButton", "Landroidx/appcompat/widget/AppCompatImageView;", "getRefreshButton$hive_promotion_release", "()Landroidx/appcompat/widget/AppCompatImageView;", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class FooterHolder extends RecyclerView.ViewHolder {
        private final ConstraintLayout layout;
        private final AppCompatImageView refreshButton;
        final /* synthetic */ NewsV2BannerRecyclerViewAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FooterHolder(NewsV2BannerRecyclerViewAdapter newsV2BannerRecyclerViewAdapter, View footer) {
            super(footer);
            Intrinsics.checkNotNullParameter(footer, "footer");
            this.this$0 = newsV2BannerRecyclerViewAdapter;
            View viewFindViewById = footer.findViewById(R.id.footerItem_layout);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            this.layout = (ConstraintLayout) viewFindViewById;
            View viewFindViewById2 = footer.findViewById(R.id.refreshButton);
            Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
            this.refreshButton = (AppCompatImageView) viewFindViewById2;
        }

        /* JADX INFO: renamed from: getLayout$hive_promotion_release, reason: from getter */
        public final ConstraintLayout getLayout() {
            return this.layout;
        }

        /* JADX INFO: renamed from: getRefreshButton$hive_promotion_release, reason: from getter */
        public final AppCompatImageView getRefreshButton() {
            return this.refreshButton;
        }
    }
}
