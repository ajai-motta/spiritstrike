package com.hive.promotion.ui.news;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.hive.core.Scheme;
import com.hive.promotion.R;
import com.hive.promotion.ui.news.BannerList;
import com.hive.promotion.ui.news.Navigation;
import com.hive.promotion.ui.news.NewsV2Activity;
import com.hive.promotion.ui.news.NewsV2BannerRecyclerViewAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewsV2BannerFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B-\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t¢\u0006\u0004\b\u0002\u0010\nJ&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2BannerFragment;", "Lcom/hive/promotion/ui/news/NewsV2Fragment;", "<init>", "()V", "menu", "Lcom/hive/promotion/ui/news/Navigation$Menu;", "bannerList", "Ljava/util/ArrayList;", "Lcom/hive/promotion/ui/news/BannerList$Banner;", "Lkotlin/collections/ArrayList;", "(Lcom/hive/promotion/ui/news/Navigation$Menu;Ljava/util/ArrayList;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewsV2BannerFragment extends NewsV2Fragment {
    private ArrayList<BannerList.Banner> bannerList;
    private Navigation.Menu menu;

    public NewsV2BannerFragment() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewsV2BannerFragment(Navigation.Menu menu, ArrayList<BannerList.Banner> arrayList) {
        this();
        Intrinsics.checkNotNullParameter(menu, "menu");
        this.menu = menu;
        this.bannerList = arrayList;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final FragmentActivity activity = getActivity();
        if (activity != null) {
            View viewInflate = inflater.inflate(R.layout.news_banner_fragment, container, false);
            Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) viewInflate;
            View viewFindViewById = viewGroup.findViewById(R.id.promotion_news_banner_listView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            RecyclerView recyclerView = (RecyclerView) viewFindViewById;
            recyclerView.setLayoutManager(new LinearLayoutManager(activity));
            NewsV2BannerRecyclerViewAdapter newsV2BannerRecyclerViewAdapter = new NewsV2BannerRecyclerViewAdapter(activity, this.bannerList);
            newsV2BannerRecyclerViewAdapter.setOnItemClickListener(new NewsV2BannerRecyclerViewAdapter.OnItemClickListener() { // from class: com.hive.promotion.ui.news.NewsV2BannerFragment$onCreateView$1$adapter$1$1
                @Override // com.hive.promotion.ui.news.NewsV2BannerRecyclerViewAdapter.OnItemClickListener
                public void onItemClick(View v, int position) {
                    int iHashCode;
                    ArrayList arrayList = this.this$0.bannerList;
                    if (arrayList != null) {
                        FragmentActivity fragmentActivity = activity;
                        Object obj = arrayList.get(position);
                        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                        BannerList.Banner banner = (BannerList.Banner) obj;
                        NewsV2Activity.ButtonClickedListener buttonClickedListener = NewsV2Activity.INSTANCE.getButtonClickedListener();
                        if (buttonClickedListener != null) {
                            buttonClickedListener.onBanner(banner);
                        }
                        String scheme = Uri.parse(banner.getLink()).getScheme();
                        if (scheme != null && ((iHashCode = scheme.hashCode()) == -1183762788 ? scheme.equals("intent") : !(iHashCode != 503143917 || !scheme.equals("interwork")))) {
                            NewsV2Activity.INSTANCE.getSchemeEventFunc().invoke(new Scheme(banner.getLink()));
                        } else {
                            Intrinsics.checkNotNull(fragmentActivity, "null cannot be cast to non-null type com.hive.promotion.ui.news.NewsV2Activity");
                            NewsV2Activity.addView$default((NewsV2Activity) fragmentActivity, banner.getViewType(), banner.getLink(), false, false, banner.getOrientation(), 12, null);
                        }
                    }
                }
            });
            recyclerView.setAdapter(newsV2BannerRecyclerViewAdapter);
            if (viewGroup != null) {
                return viewGroup;
            }
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // com.hive.promotion.ui.news.NewsV2Fragment
    public void onBackPressed() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
