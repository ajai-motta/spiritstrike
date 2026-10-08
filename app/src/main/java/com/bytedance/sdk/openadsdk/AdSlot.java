package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import com.bykv.vk.openvk.qdl.qdl.qdl.wd.ud;
import com.bytedance.sdk.component.utils.bjy;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AdSlot {
    public static final int ANCHORED_BANNER = 2;
    public static final int FIX_BANNER = 1;
    public static final int INLINE_BANNER = 3;
    public static final int TYPE_BANNER = 1;
    public static final int TYPE_CACHED_SPLASH = 4;
    public static final int TYPE_FEED = 5;
    public static final int TYPE_FULL_SCREEN_VIDEO = 8;
    public static final int TYPE_INTERACTION_AD = 2;
    public static final int TYPE_OPEN_AD = 3;
    public static final int TYPE_REWARD_VIDEO = 7;
    private int aaj;
    private int bch;
    private String bjy;
    private String exc;
    private boolean exu;
    private int fs;
    private String jl;
    private String jpc;
    private String jtx;
    private int jyq;
    private int ljh;
    private int lnr;
    private float mml;
    private int mo;
    private float mzz;
    private int oth;
    private String qdl;
    private boolean rdp;
    private String rq;
    private String to;
    private int tvp;
    private int ud;
    private boolean uw;
    private boolean wd;
    private Map<String, Object> xmv;
    private String yt;

    public static int getPosition(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return (i == 3 || i == 4 || i == 7 || i == 8) ? 5 : 3;
        }
        return 4;
    }

    private AdSlot() {
        this.exu = true;
        this.rdp = false;
        this.aaj = 0;
        this.jyq = 0;
        this.oth = 0;
        this.bch = 1;
    }

    public void setUserData(String str) {
        this.exc = str;
    }

    public String getUserData() {
        return this.exc;
    }

    public String getCodeId() {
        return this.qdl;
    }

    public boolean isAutoPlay() {
        return this.exu;
    }

    public boolean isExpressAd() {
        return this.rdp;
    }

    public String getBidAdm() {
        return this.bjy;
    }

    public int getImgAcceptedWidth() {
        return this.ud;
    }

    public int getImgAcceptedHeight() {
        return this.lnr;
    }

    public float getExpressViewAcceptedWidth() {
        return this.mml;
    }

    public float getExpressViewAcceptedHeight() {
        return this.mzz;
    }

    public void setExpressViewAccepted(float f, float f2) {
        this.mml = f;
        this.mzz = f2;
    }

    public boolean isSupportDeepLink() {
        return this.wd;
    }

    public int getAdCount() {
        return this.mo;
    }

    public void setAdCount(int i) {
        this.mo = i;
    }

    public String getRewardName() {
        return this.jpc;
    }

    public int getRewardAmount() {
        return this.tvp;
    }

    public String getMediaExtra() {
        return this.to;
    }

    public String getUserID() {
        return this.rq;
    }

    public String getAdId() {
        return this.jtx;
    }

    public String getCreativeId() {
        return this.yt;
    }

    public String getExt() {
        return this.jl;
    }

    public int getIsRotateBanner() {
        return this.aaj;
    }

    public void setIsRotateBanner(int i) {
        this.aaj = i;
    }

    public int getRotateTime() {
        return this.jyq;
    }

    public void setRotateTime(int i) {
        this.jyq = i;
    }

    public int getRotateOrder() {
        return this.oth;
    }

    public void setRotateOrder(int i) {
        this.oth = i;
    }

    public void setDurationSlotType(int i) {
        this.ljh = i;
    }

    public int getDurationSlotType() {
        return this.ljh;
    }

    public Map<String, Object> getRequestExtraMap() {
        return this.xmv;
    }

    public void setPreload(boolean z) {
        this.uw = z;
    }

    public boolean isPreload() {
        return this.uw;
    }

    public String toString() {
        return super.toString();
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.qdl);
            jSONObject.put("mAdCount", this.mo);
            jSONObject.put("mIsAutoPlay", this.exu);
            jSONObject.put("mImgAcceptedWidth", this.ud);
            jSONObject.put("mImgAcceptedHeight", this.lnr);
            jSONObject.put("mExpressViewAcceptedWidth", this.mml);
            jSONObject.put("mExpressViewAcceptedHeight", this.mzz);
            jSONObject.put("mSupportDeepLink", this.wd);
            jSONObject.put("mRewardName", this.jpc);
            jSONObject.put("mRewardAmount", this.tvp);
            jSONObject.put("mMediaExtra", this.to);
            jSONObject.put("mUserID", this.rq);
            jSONObject.put("mNativeAdType", this.fs);
            jSONObject.put("mIsExpressAd", this.rdp);
            jSONObject.put("mAdId", this.jtx);
            jSONObject.put("mCreativeId", this.yt);
            jSONObject.put("mExt", this.jl);
            jSONObject.put("mBidAdm", this.bjy);
            jSONObject.put("mUserData", this.exc);
            jSONObject.put("mDurationSlotType", this.ljh);
            jSONObject.put("mBannerType", this.bch);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int getBannerType() {
        return this.bch;
    }

    public static AdSlot getSlot(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Builder builder = new Builder();
        try {
            int iOptInt = jSONObject.optInt("mImgAcceptedWidth", 640);
            int iOptInt2 = jSONObject.optInt("mImgAcceptedHeight", 320);
            double dOptDouble = jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d);
            double dOptDouble2 = jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d);
            builder.setCodeId(jSONObject.optString("mCodeId", null));
            builder.setAdCount(jSONObject.optInt("mAdCount", 1));
            builder.setIsAutoPlay(jSONObject.optBoolean("mIsAutoPlay"));
            builder.setImageAcceptedSize(iOptInt, iOptInt2);
            builder.setExpressViewAcceptedSize(Double.valueOf(dOptDouble).floatValue(), Double.valueOf(dOptDouble2).floatValue());
            builder.setSupportDeepLink(jSONObject.optBoolean("mSupportDeepLink", false));
            builder.setRewardName(jSONObject.optString("mRewardName", null));
            builder.setRewardAmount(jSONObject.optInt("mRewardAmount"));
            builder.setMediaExtra(jSONObject.optString("mMediaExtra", null));
            builder.setUserID(jSONObject.optString("mUserID", null));
            builder.setNativeAdType(jSONObject.optInt("mNativeAdType"));
            builder.isExpressAd(jSONObject.optBoolean("mIsExpressAd"));
            builder.withBid(jSONObject.optString("mBidAdm"));
            builder.setAdId(jSONObject.optString("mAdId"));
            builder.setCreativeId(jSONObject.optString("mCreativeId"));
            builder.setExt(jSONObject.optString("mExt"));
            builder.setMediaExtra(jSONObject.optString("mMediaExtra"));
            builder.setBannerType(jSONObject.optInt("mBannerType"));
        } catch (Exception unused) {
        }
        AdSlot adSlotBuild = builder.build();
        adSlotBuild.setDurationSlotType(jSONObject.optInt("mDurationSlotType"));
        return adSlotBuild;
    }

    public static class Builder {
        private String bjy;
        private boolean exu;
        private float fs;
        private String jl;
        private String jpc;
        private String jtx;
        private int jyq;
        private String qdl;
        private String rdp;
        private float rq;
        private int to;
        private String yt;
        private int ud = 640;
        private int lnr = 320;
        private final boolean mml = true;
        private int mzz = 1;
        private final String mo = "";
        private final int wd = 0;
        private String tvp = "defaultUser";
        private boolean exc = true;
        private Map<String, Object> aaj = null;
        private int oth = 1;

        public Builder setRewardAmount(int i) {
            return this;
        }

        public Builder setRewardName(String str) {
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            return this;
        }

        public Builder setAdId(String str) {
            this.bjy = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.jtx = str;
            return this;
        }

        public Builder setExt(String str) {
            this.yt = str;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.exc = z;
            return this;
        }

        public Builder setCodeId(String str) {
            this.qdl = str;
            return this;
        }

        public Builder isExpressAd(boolean z) {
            this.exu = z;
            return this;
        }

        public Builder setImageAcceptedSize(int i, int i2) {
            this.ud = i;
            this.lnr = i2;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f, float f2) {
            this.rq = f;
            this.fs = f2;
            return this;
        }

        public Builder setDurationSlotType(int i) {
            this.jyq = i;
            return this;
        }

        public Builder setAdCount(int i) {
            if (i <= 0) {
                i = 1;
            }
            if (i > 20) {
                i = 20;
            }
            this.mzz = i;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.jpc = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.tvp = str;
            return this;
        }

        public Builder setNativeAdType(int i) {
            this.to = i;
            return this;
        }

        public Builder withBid(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            if (bjy.mml()) {
                ud.qdl(str);
            }
            this.rdp = str;
            return this;
        }

        public Builder setUserData(String str) {
            this.jl = str;
            return this;
        }

        public Builder setRequestExtraMap(Map<String, Object> map) {
            this.aaj = map;
            return this;
        }

        public Builder setBannerType(int i) {
            this.oth = i;
            return this;
        }

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.qdl = this.qdl;
            adSlot.mo = this.mzz;
            adSlot.wd = true;
            adSlot.ud = this.ud;
            adSlot.lnr = this.lnr;
            float f = this.rq;
            if (f <= 0.0f) {
                adSlot.mml = this.ud;
                adSlot.mzz = this.lnr;
            } else {
                adSlot.mml = f;
                adSlot.mzz = this.fs;
            }
            adSlot.jpc = "";
            adSlot.tvp = 0;
            adSlot.to = this.jpc;
            adSlot.rq = this.tvp;
            adSlot.fs = this.to;
            adSlot.exu = this.exc;
            adSlot.rdp = this.exu;
            adSlot.bjy = this.rdp;
            adSlot.jtx = this.bjy;
            adSlot.yt = this.jtx;
            adSlot.jl = this.yt;
            adSlot.exc = this.jl;
            adSlot.xmv = this.aaj;
            adSlot.ljh = this.jyq;
            adSlot.bch = this.oth;
            return adSlot;
        }
    }
}
