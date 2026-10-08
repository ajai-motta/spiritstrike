package com.bytedance.sdk.openadsdk.qdl.ud;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.bch.ud.mzz;
import com.bytedance.sdk.openadsdk.core.jtx;
import com.bytedance.sdk.openadsdk.core.mml.wd;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.tvp;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.bytedance.sdk.openadsdk.utils.rc;
import com.bytedance.sdk.openadsdk.utils.uw;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class jpc extends PAGNativeAd {
    private boolean jpc;
    protected final Context lnr;
    protected qdl mml;
    protected int mo;
    protected int mzz;
    protected jtx qdl;
    private boolean tvp;
    protected final ljh ud;
    protected String wd;

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public void showPrivacyActivity() {
    }

    public jpc(Context context, ljh ljhVar, int i, boolean z) {
        this.ud = ljhVar;
        this.lnr = context;
        this.mzz = i;
        this.mo = ljhVar.fz();
        String strLnr = gy.lnr(i);
        this.wd = strLnr;
        if (z) {
            this.mml = new qdl(context, ljhVar, strLnr);
            this.qdl = new jtx(context, this, ljhVar, qdl(i), this.mml);
        }
    }

    private List<View> qdl(List<View> list, List<View> list2) {
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                linkedList.add(list.get(i));
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                linkedList.add(list2.get(i2));
            }
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Map<String, Object> getMediaExtraInfo() {
        ljh ljhVar = this.ud;
        if (ljhVar != null) {
            return ljhVar.dsy();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Object getExtraInfo(String str) {
        ljh ljhVar = this.ud;
        if (ljhVar == null || ljhVar.dsy() == null) {
            return null;
        }
        try {
            return this.ud.dsy().get(str);
        } catch (Throwable th) {
            aaj.lnr("TTNativeAdImpl", th.getMessage());
            return null;
        }
    }

    private String qdl(int i) {
        if (i == 1) {
            return "banner_ad";
        }
        if (i != 2) {
            return "embeded_ad";
        }
        return "interaction";
    }

    protected boolean wd() {
        ljh ljhVar = this.ud;
        return (ljhVar == null || ljhVar.ygv() == 5 || yt.mml().lnr(this.mo) != 1) ? false : true;
    }

    protected void qdl(String str) {
        this.wd = str;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d) {
        if (this.jpc) {
            return;
        }
        rc.qdl(this.ud, d);
        this.jpc = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void loss(Double d, String str, String str2) {
        if (this.tvp) {
            return;
        }
        rc.qdl(this.ud, d, str, str2);
        this.tvp = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, PAGNativeAdInteractionListener pAGNativeAdInteractionListener) {
        if (viewGroup == null || list == null || list.size() <= 0) {
            return;
        }
        qdl(viewGroup, null, list, list2, view, new wd(pAGNativeAdInteractionListener));
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, PAGNativeAdInteractionCallback pAGNativeAdInteractionCallback) {
        registerViewForInteraction(viewGroup, list, list2, view, (PAGNativeAdInteractionListener) pAGNativeAdInteractionCallback);
    }

    public void qdl(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, final mo moVar) {
        if (viewGroup == null || list2 == null || list2.size() <= 0) {
            return;
        }
        if (wd()) {
            list3 = qdl(list2, list3);
        }
        List<View> list4 = list3;
        if (view != null && moVar != null && moVar.ud()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.qdl.ud.jpc.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    final String strQdl = uw.qdl();
                    TTDelegateActivity.qdl(jpc.this.ud, strQdl, new wd.qdl() { // from class: com.bytedance.sdk.openadsdk.qdl.ud.jpc.1.1
                        @Override // com.bytedance.sdk.openadsdk.core.mml.wd.qdl
                        public void qdl() {
                            moVar.qdl();
                            tvp.ud().mo(strQdl);
                            PAGMediaView pAGMediaViewQdl = jpc.this.jpc().qdl();
                            if (pAGMediaViewQdl != null) {
                                pAGMediaViewQdl.close();
                            }
                        }
                    });
                }
            });
        }
        this.qdl.qdl(viewGroup, list, list2, list4, moVar);
        ljh ljhVar = this.ud;
        com.bytedance.sdk.openadsdk.bch.ud.mzz.qdl(viewGroup, this.ud, (ljhVar == null || ljhVar.dk() != 2) ? null : new mzz.qdl(this.ud.ra()));
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public PAGNativeAdData getNativeAdData() {
        return new mml(jpc());
    }

    public qdl jpc() {
        return this.mml;
    }
}
