package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DynamicRootView extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.mml, com.bytedance.sdk.component.adexpress.theme.qdl {
    private String bgColor;
    private Map<Integer, String> bgMaterialCenterCalcColor;
    private mzz dynamicBaseWidget;
    private int logoUnionHeight;
    private Context mContext;
    private com.bytedance.sdk.component.adexpress.dynamic.mo.qdl mDynamicClickListener;
    boolean mIsMute;
    private ThemeStatusBroadcastReceiver mReceiver;
    private com.bytedance.sdk.component.adexpress.ud.rq mRenderListener;
    private com.bytedance.sdk.component.adexpress.ud.exu mRenderRequest;
    private ViewGroup mTimeOut;
    private com.bytedance.sdk.component.adexpress.dynamic.ud muteListener;
    protected final com.bytedance.sdk.component.adexpress.ud.rdp renderResult;
    private int scoreCountWithIcon;
    private List<com.bytedance.sdk.component.adexpress.dynamic.lnr> timeOutListener;
    private int timedown;
    private com.bytedance.sdk.component.adexpress.dynamic.mzz videoListener;
    public View videoView;

    public DynamicRootView(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.bytedance.sdk.component.adexpress.ud.exu exuVar, com.bytedance.sdk.component.adexpress.dynamic.mo.qdl qdlVar) {
        super(context);
        this.mTimeOut = null;
        this.timedown = 0;
        this.timeOutListener = new ArrayList();
        this.logoUnionHeight = 0;
        this.scoreCountWithIcon = 0;
        this.mContext = context;
        com.bytedance.sdk.component.adexpress.ud.rdp rdpVar = new com.bytedance.sdk.component.adexpress.ud.rdp();
        this.renderResult = rdpVar;
        rdpVar.qdl(2);
        this.mDynamicClickListener = qdlVar;
        qdlVar.qdl(this);
        this.mReceiver = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.qdl(this);
        this.mIsMute = z;
        this.mRenderRequest = exuVar;
    }

    public String getBgColor() {
        return this.bgColor;
    }

    public void setBgColor(String str) {
        this.bgColor = str;
    }

    public void setRenderListener(com.bytedance.sdk.component.adexpress.ud.rq rqVar) {
        this.mRenderListener = rqVar;
        this.mDynamicClickListener.qdl(rqVar);
    }

    public void render(com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar, int i) {
        this.dynamicBaseWidget = renderDynamicView(jpcVar, this, i);
        this.renderResult.qdl(true);
        this.renderResult.qdl(this.dynamicBaseWidget.mzz);
        this.renderResult.ud(this.dynamicBaseWidget.mo);
        this.renderResult.qdl(this.videoView);
        this.mRenderListener.qdl(this.renderResult);
    }

    public mzz renderDynamicView(com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar, ViewGroup viewGroup, int i) {
        if (jpcVar == null) {
            return null;
        }
        List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> listRq = jpcVar.rq();
        mzz mzzVarQdl = com.bytedance.sdk.component.adexpress.dynamic.qdl.ud.qdl(this.mContext, this, jpcVar);
        if (mzzVarQdl instanceof rc) {
            callBackRenderFail(i == 3 ? 128 : 118, "unknow widget");
            return null;
        }
        checkCanOpenLandingPage(jpcVar);
        mzzVarQdl.lnr();
        if (viewGroup != null) {
            viewGroup.addView(mzzVarQdl);
            setClipChildren(viewGroup, jpcVar);
        }
        if (listRq == null || listRq.size() <= 0) {
            return null;
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> it = listRq.iterator();
        while (it.hasNext()) {
            renderDynamicView(it.next(), mzzVarQdl, i);
        }
        return mzzVarQdl;
    }

    private void checkCanOpenLandingPage(com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar) {
        com.bytedance.sdk.component.adexpress.dynamic.mml.mo moVarMzz;
        com.bytedance.sdk.component.adexpress.dynamic.mml.mzz mzzVar = jpcVar.to();
        if (mzzVar == null || (moVarMzz = mzzVar.mzz()) == null) {
            return;
        }
        this.renderResult.ud(moVarMzz.fge());
    }

    public Map<Integer, String> getBgMaterialCenterCalcColor() {
        return this.bgMaterialCenterCalcColor;
    }

    public void setBgMaterialCenterCalcColor(Map<Integer, String> map) {
        this.bgMaterialCenterCalcColor = map;
    }

    private void setClipChildren(ViewGroup viewGroup, com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar) {
        ViewGroup viewGroup2;
        if (viewGroup == null || (viewGroup2 = (ViewGroup) viewGroup.getParent()) == null || !jpcVar.bch()) {
            return;
        }
        viewGroup2.setClipChildren(false);
        viewGroup2.setClipToPadding(false);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
        if (viewGroup3 != null) {
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    public void updateRenderInfoForVideo(double d, double d2, double d3, double d4, float f) {
        this.renderResult.lnr(d);
        this.renderResult.mml(d2);
        this.renderResult.mzz(d3);
        this.renderResult.mo(d4);
        this.renderResult.qdl(f);
        this.renderResult.ud(f);
        this.renderResult.lnr(f);
        this.renderResult.mml(f);
    }

    public void callBackRenderFail(int i, String str) {
        this.renderResult.qdl(false);
        this.renderResult.ud(i);
        this.renderResult.qdl(str);
        this.mRenderListener.qdl(this.renderResult);
    }

    public void setMuteListener(com.bytedance.sdk.component.adexpress.dynamic.ud udVar) {
        this.muteListener = udVar;
    }

    public com.bytedance.sdk.component.adexpress.ud.rq getRenderListener() {
        return this.mRenderListener;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.mo.qdl getDynamicClickListener() {
        return this.mDynamicClickListener;
    }

    private boolean checkSizeValid() {
        return this.dynamicBaseWidget.mzz > 0.0f && this.dynamicBaseWidget.mo > 0.0f;
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.qdl
    public void onThemeChanged(int i) {
        mzz mzzVar = this.dynamicBaseWidget;
        if (mzzVar == null) {
            return;
        }
        mzzVar.qdl(i);
    }

    public void beginShowFromInvisible() {
        beginShowFromInvisible(this.dynamicBaseWidget, 0);
    }

    public void beginHideFromVisible() {
        beginShowFromInvisible(this.dynamicBaseWidget, 4);
    }

    public void beginShowFromInvisible(mzz mzzVar, int i) {
        if (mzzVar == null) {
            return;
        }
        if (mzzVar.getBeginInvisibleAndShow()) {
            mzzVar.setVisibility(i);
            if (mzzVar.bjy != null) {
                mzzVar.bjy.setVisibility(i);
            }
        }
        int childCount = mzzVar.getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            if (mzzVar.getChildAt(i2) instanceof mzz) {
                beginShowFromInvisible((mzz) mzzVar.getChildAt(i2), i);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.mml
    public void setTime(CharSequence charSequence, int i, int i2, boolean z) {
        for (int i3 = 0; i3 < this.timeOutListener.size(); i3++) {
            if (this.timeOutListener.get(i3) != null) {
                this.timeOutListener.get(i3).qdl(charSequence, i == 1, i2, z);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.mml
    public void setSoundMute(boolean z) {
        com.bytedance.sdk.component.adexpress.dynamic.ud udVar = this.muteListener;
        if (udVar != null) {
            udVar.setSoundMute(z);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.mml
    public void setTimeUpdate(int i) {
        this.videoListener.setTimeUpdate(i);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.mml
    public void onvideoComplate() {
        try {
            this.videoListener.qdl();
        } catch (Exception unused) {
        }
    }

    public ViewGroup getTimeOut() {
        return this.mTimeOut;
    }

    public void setTimeOut(ViewGroup viewGroup) {
        this.mTimeOut = viewGroup;
    }

    public int getTimedown() {
        return this.timedown;
    }

    public void setTimedown(int i) {
        this.timedown = i;
    }

    public List<com.bytedance.sdk.component.adexpress.dynamic.lnr> getTimeOutListener() {
        return this.timeOutListener;
    }

    public void setTimeOutListener(com.bytedance.sdk.component.adexpress.dynamic.lnr lnrVar) {
        this.timeOutListener.add(lnrVar);
    }

    public void setVideoListener(com.bytedance.sdk.component.adexpress.dynamic.mzz mzzVar) {
        this.videoListener = mzzVar;
    }

    public int getScoreCountWithIcon() {
        return this.scoreCountWithIcon;
    }

    public void setScoreCountWithIcon(int i) {
        this.scoreCountWithIcon = i;
    }

    public int getLogoUnionHeight() {
        return this.logoUnionHeight;
    }

    public void setLogoUnionHeight(int i) {
        this.logoUnionHeight = i;
    }

    public com.bytedance.sdk.component.adexpress.ud.exu getRenderRequest() {
        return this.mRenderRequest;
    }
}
