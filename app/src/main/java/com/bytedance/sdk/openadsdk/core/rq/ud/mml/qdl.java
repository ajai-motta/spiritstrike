package com.bytedance.sdk.openadsdk.core.rq.ud.mml;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.adsdk.ugeno.mml;
import com.bytedance.adsdk.ugeno.ud.lnr;
import com.bytedance.adsdk.ugeno.yoga.ud.lnr;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class qdl extends FrameLayout {
    private final C0250qdl lnr;
    private mml mml;
    private final RecyclerView qdl;
    private final List<lnr> ud;

    public qdl(Context context) {
        super(context);
        this.ud = new CopyOnWriteArrayList();
        C0250qdl c0250qdl = new C0250qdl();
        this.lnr = c0250qdl;
        RecyclerView recyclerView = new RecyclerView(context);
        this.qdl = recyclerView;
        addView(recyclerView);
        recyclerView.setAdapter(c0250qdl);
    }

    public void setOrientation(int i) {
        if (i == 1) {
            this.qdl.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        } else {
            this.qdl.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        mml mmlVar = this.mml;
        if (mmlVar != null) {
            int[] iArrQdl = mmlVar.qdl(i, i2);
            super.onMeasure(iArrQdl[0], iArrQdl[1]);
        } else {
            super.onMeasure(i, i2);
        }
        mml mmlVar2 = this.mml;
        if (mmlVar2 != null) {
            mmlVar2.mzz();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        mml mmlVar = this.mml;
        if (mmlVar != null) {
            mmlVar.mo();
        }
        super.onLayout(z, i, i2, i3, i4);
        mml mmlVar2 = this.mml;
        if (mmlVar2 != null) {
            mmlVar2.qdl(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mml mmlVar = this.mml;
        if (mmlVar != null) {
            mmlVar.wd();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mml mmlVar = this.mml;
        if (mmlVar != null) {
            mmlVar.jpc();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        mml mmlVar = this.mml;
        if (mmlVar != null) {
            mmlVar.ud(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void qdl(lnr<View> lnrVar) {
        if (lnrVar == null) {
            return;
        }
        this.ud.add(lnrVar);
        C0250qdl c0250qdl = this.lnr;
        if (c0250qdl != null) {
            c0250qdl.notifyDataSetChanged();
        }
    }

    public void qdl(mml mmlVar) {
        this.mml = mmlVar;
    }

    public void qdl(com.bytedance.sdk.openadsdk.core.rq.ud.mml.ud udVar) {
        ViewGroup.LayoutParams layoutParams = this.qdl.getLayoutParams();
        layoutParams.width = udVar.fco();
        layoutParams.height = udVar.mrf();
        this.qdl.setLayoutParams(layoutParams);
    }

    private static class ud extends RecyclerView.ViewHolder {
        private final ViewGroup qdl;

        public ud(View view) {
            super(view);
            this.qdl = (ViewGroup) view;
        }

        public void qdl(lnr lnrVar) {
            View viewRq = lnrVar.rq();
            ViewParent parent = viewRq.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(viewRq);
            }
            this.qdl.removeAllViews();
            this.qdl.addView(viewRq, new lnr.qdl(lnrVar.fco(), lnrVar.mrf()));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.rq.ud.mml.qdl$qdl, reason: collision with other inner class name */
    private class C0250qdl extends RecyclerView.Adapter<ud> {
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i;
        }

        private C0250qdl() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public ud onCreateViewHolder(ViewGroup viewGroup, int i) {
            com.bytedance.adsdk.ugeno.yoga.ud.lnr lnrVar = new com.bytedance.adsdk.ugeno.yoga.ud.lnr(viewGroup.getContext());
            com.bytedance.adsdk.ugeno.ud.lnr lnrVar2 = (com.bytedance.adsdk.ugeno.ud.lnr) qdl.this.ud.get(i);
            lnrVar.setLayoutParams(new ViewGroup.LayoutParams(lnrVar2.fco(), lnrVar2.mrf()));
            return new ud(lnrVar);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(ud udVar, int i) {
            udVar.qdl((com.bytedance.adsdk.ugeno.ud.lnr) qdl.this.ud.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return qdl.this.ud.size();
        }
    }
}
