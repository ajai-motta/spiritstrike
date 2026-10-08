package com.bytedance.sdk.openadsdk.component.reward.top;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.utils.jtx;

/* JADX INFO: loaded from: classes3.dex */
public class lnr extends View implements qdl<lnr> {
    private qdl<lnr> qdl;

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    public lnr(Context context) {
        this(context, null);
    }

    public lnr(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public lnr(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setVisibility(8);
        setWillNotDraw(true);
    }

    public View getITopLayout() {
        Object obj = this.qdl;
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    public lnr qdl(ljh ljhVar) {
        if (this.qdl != null) {
            return this;
        }
        TopLayoutDislike2 topLayoutDislike2Load = new TopLayoutDislike2(getContext()).load(ljhVar);
        this.qdl = topLayoutDislike2Load;
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            qdl(topLayoutDislike2Load, (ViewGroup) parent);
        }
        return this;
    }

    private void qdl(View view, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, iIndexOfChild);
        }
        if (view != null) {
            view.setId(jtx.tvf);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.qdl
    public void setShowSkip(boolean z) {
        qdl<lnr> qdlVar = this.qdl;
        if (qdlVar != null) {
            qdlVar.setShowSkip(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.qdl
    public void setSkipEnable(boolean z) {
        qdl<lnr> qdlVar = this.qdl;
        if (qdlVar != null) {
            qdlVar.setSkipEnable(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.qdl
    public void setSkipInvisiable() {
        qdl<lnr> qdlVar = this.qdl;
        if (qdlVar != null) {
            qdlVar.setSkipInvisiable();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.qdl
    public void setSkipText(CharSequence charSequence) {
        qdl<lnr> qdlVar = this.qdl;
        if (qdlVar != null) {
            qdlVar.setSkipText(charSequence);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.qdl
    public void setCountDownFor1InN(CharSequence charSequence, int i) {
        qdl<lnr> qdlVar = this.qdl;
        if (qdlVar != null) {
            qdlVar.setCountDownFor1InN(charSequence, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.qdl
    public void showCountDownText() {
        qdl<lnr> qdlVar = this.qdl;
        if (qdlVar != null) {
            qdlVar.showCountDownText();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.qdl
    public void showSkipButton() {
        qdl<lnr> qdlVar = this.qdl;
        if (qdlVar != null) {
            qdlVar.showSkipButton();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.qdl
    public void setShowSound(boolean z) {
        qdl<lnr> qdlVar = this.qdl;
        if (qdlVar != null) {
            qdlVar.setShowSound(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.qdl
    public void setSoundMute(boolean z) {
        qdl<lnr> qdlVar = this.qdl;
        if (qdlVar != null) {
            qdlVar.setSoundMute(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.qdl
    public void setTime(CharSequence charSequence, CharSequence charSequence2) {
        qdl<lnr> qdlVar = this.qdl;
        if (qdlVar != null) {
            qdlVar.setTime(charSequence, charSequence2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.qdl
    public void setShowDislike(boolean z) {
        qdl<lnr> qdlVar = this.qdl;
        if (qdlVar != null) {
            qdlVar.setShowDislike(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.qdl
    public void setShowPlayableNextAd(boolean z, ljh ljhVar) {
        qdl<lnr> qdlVar = this.qdl;
        if (qdlVar != null) {
            qdlVar.setShowPlayableNextAd(z, ljhVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.qdl
    public void setShowEndCardNextAd(boolean z, ljh ljhVar) {
        qdl<lnr> qdlVar = this.qdl;
        if (qdlVar != null) {
            qdlVar.setShowEndCardNextAd(z, ljhVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.qdl
    public void setListener(ud udVar) {
        qdl<lnr> qdlVar = this.qdl;
        if (qdlVar != null) {
            qdlVar.setListener(udVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.qdl
    public void clickSkip() {
        qdl<lnr> qdlVar = this.qdl;
        if (qdlVar != null) {
            qdlVar.clickSkip();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.qdl
    public void clickSound(String str) {
        qdl<lnr> qdlVar = this.qdl;
        if (qdlVar != null) {
            qdlVar.clickSound(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.qdl
    public void showCloseButton() {
        qdl<lnr> qdlVar = this.qdl;
        if (qdlVar != null) {
            qdlVar.showCloseButton();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.qdl
    public View getCloseButton() {
        qdl<lnr> qdlVar = this.qdl;
        if (qdlVar != null) {
            return qdlVar.getCloseButton();
        }
        return null;
    }
}
