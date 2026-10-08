package com.hive.promotion.ui.news;

import android.os.Bundle;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.hive.core.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewsV2Fragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2Fragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "backPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "getBackPressedCallback", "()Landroidx/activity/OnBackPressedCallback;", "setBackPressedCallback", "(Landroidx/activity/OnBackPressedCallback;)V", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class NewsV2Fragment extends Fragment {
    public OnBackPressedCallback backPressedCallback;

    public void onBackPressed() {
    }

    public final OnBackPressedCallback getBackPressedCallback() {
        OnBackPressedCallback onBackPressedCallback = this.backPressedCallback;
        if (onBackPressedCallback != null) {
            return onBackPressedCallback;
        }
        Intrinsics.throwUninitializedPropertyAccessException("backPressedCallback");
        return null;
    }

    public final void setBackPressedCallback(OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "<set-?>");
        this.backPressedCallback = onBackPressedCallback;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setBackPressedCallback(new OnBackPressedCallback() { // from class: com.hive.promotion.ui.news.NewsV2Fragment.onCreate.1
            {
                super(false);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                NewsV2Fragment.this.onBackPressed();
            }
        });
        try {
            OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            onBackPressedDispatcher.addCallback(fragmentActivityRequireActivity, getBackPressedCallback());
        } catch (Exception e) {
            Logger.INSTANCE.w("NewsV2Fragment requireActivity is null \ne: " + e.getMessage());
        }
    }
}
