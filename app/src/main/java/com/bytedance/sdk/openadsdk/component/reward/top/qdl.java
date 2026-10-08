package com.bytedance.sdk.openadsdk.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.ljh;

/* JADX INFO: loaded from: classes3.dex */
public interface qdl<T extends View> {
    void clickSkip();

    void clickSound(String str);

    View getCloseButton();

    void setCountDownFor1InN(CharSequence charSequence, int i);

    void setListener(ud udVar);

    void setShowDislike(boolean z);

    void setShowEndCardNextAd(boolean z, ljh ljhVar);

    void setShowPlayableNextAd(boolean z, ljh ljhVar);

    void setShowSkip(boolean z);

    void setShowSound(boolean z);

    void setSkipEnable(boolean z);

    void setSkipInvisiable();

    void setSkipText(CharSequence charSequence);

    void setSoundMute(boolean z);

    void setTime(CharSequence charSequence, CharSequence charSequence2);

    void showCloseButton();

    void showCountDownText();

    void showSkipButton();
}
