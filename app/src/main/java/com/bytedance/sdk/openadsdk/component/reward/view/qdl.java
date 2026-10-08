package com.bytedance.sdk.openadsdk.component.reward.view;

import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

/* JADX INFO: loaded from: classes3.dex */
public class qdl extends SnapHelper {
    private RecyclerView lnr;
    private OrientationHelper qdl;
    private OrientationHelper ud;

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        View viewFindSnapView = findSnapView(layoutManager);
        int i3 = -1;
        if (viewFindSnapView == null) {
            return -1;
        }
        int position = layoutManager.getPosition(viewFindSnapView);
        if (layoutManager.canScrollVertically()) {
            i3 = i2 < 0 ? position - 1 : position + 1;
        }
        return Math.min(layoutManager.getItemCount() - 1, Math.max(i3, 0));
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        this.lnr = recyclerView;
        super.attachToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount() - 1) {
            return null;
        }
        OrientationHelper orientationHelperQdl = qdl(layoutManager);
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = linearLayoutManager.getChildAt(i2);
            int iAbs = Math.abs(orientationHelperQdl.getDecoratedStart(childAt));
            if (iAbs < i) {
                view = childAt;
                i = iAbs;
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = {0, 0};
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = qdl(view, ud(layoutManager));
        } else if (layoutManager.canScrollVertically()) {
            iArr[1] = qdl(view, qdl(layoutManager));
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new LinearSmoothScroller(this.lnr.getContext()) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.qdl.1
                @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
                protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                    qdl qdlVar = qdl.this;
                    int[] iArrCalculateDistanceToFinalSnap = qdlVar.calculateDistanceToFinalSnap(qdlVar.lnr.getLayoutManager(), view);
                    int i = iArrCalculateDistanceToFinalSnap[0];
                    int i2 = iArrCalculateDistanceToFinalSnap[1];
                    int iCalculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                    if (iCalculateTimeForDeceleration > 0) {
                        action.update(i, i2, iCalculateTimeForDeceleration, this.mDecelerateInterpolator);
                    }
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                protected int calculateTimeForScrolling(int i) {
                    return Math.min(100, super.calculateTimeForScrolling(i));
                }
            };
        }
        return null;
    }

    private int qdl(View view, OrientationHelper orientationHelper) {
        int decoratedStart = orientationHelper.getDecoratedStart(view);
        return decoratedStart >= orientationHelper.getStartAfterPadding() / 2 ? decoratedStart - orientationHelper.getStartAfterPadding() : decoratedStart;
    }

    private OrientationHelper qdl(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.qdl;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.qdl = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.qdl;
    }

    private OrientationHelper ud(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.ud;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.ud = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.ud;
    }
}
