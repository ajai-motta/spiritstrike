package com.hive.promotion.ui;

import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmoothScrollLinearLayoutManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/hive/promotion/ui/SmoothScrollLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mContext", "Landroid/content/Context;", AdUnitActivity.EXTRA_ORIENTATION, "", "reverseLayout", "", "<init>", "(Landroid/content/Context;IZ)V", "smoothScrollToPosition", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "position", "AnySnappedSmoothScroller", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SmoothScrollLinearLayoutManager extends LinearLayoutManager {
    private final Context mContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmoothScrollLinearLayoutManager(Context mContext, int i, boolean z) {
        super(mContext, i, z);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(state, "state");
        final AnySnappedSmoothScroller anySnappedSmoothScroller = new AnySnappedSmoothScroller(this.mContext);
        anySnappedSmoothScroller.setTargetPosition(position);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.promotion.ui.SmoothScrollLinearLayoutManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SmoothScrollLinearLayoutManager.smoothScrollToPosition$lambda$0(this.f$0, anySnappedSmoothScroller);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void smoothScrollToPosition$lambda$0(SmoothScrollLinearLayoutManager smoothScrollLinearLayoutManager, AnySnappedSmoothScroller anySnappedSmoothScroller) {
        smoothScrollLinearLayoutManager.startSmoothScroll(anySnappedSmoothScroller);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SmoothScrollLinearLayoutManager.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u000f\u001a\u00020\rH\u0014J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/hive/promotion/ui/SmoothScrollLinearLayoutManager$AnySnappedSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "<init>", "(Lcom/hive/promotion/ui/SmoothScrollLinearLayoutManager;Landroid/content/Context;)V", "MILLISECONDS_PER_INCH", "", "getMILLISECONDS_PER_INCH", "()F", "computeScrollVectorForPosition", "Landroid/graphics/PointF;", "targetPosition", "", "getVerticalSnapPreference", "getHorizontalSnapPreference", "calculateSpeedPerPixel", "displayMetrics", "Landroid/util/DisplayMetrics;", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    final class AnySnappedSmoothScroller extends LinearSmoothScroller {
        private final float MILLISECONDS_PER_INCH;

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected int getHorizontalSnapPreference() {
            return 0;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected int getVerticalSnapPreference() {
            return 0;
        }

        public AnySnappedSmoothScroller(Context context) {
            super(context);
            this.MILLISECONDS_PER_INCH = 110.0f;
        }

        public final float getMILLISECONDS_PER_INCH() {
            return this.MILLISECONDS_PER_INCH;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public PointF computeScrollVectorForPosition(int targetPosition) {
            return SmoothScrollLinearLayoutManager.this.computeScrollVectorForPosition(targetPosition);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
            return this.MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
        }
    }
}
