package com.adxcorp.ads.common;

import android.content.Context;
import android.text.TextUtils;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.util.ADXLogUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CustomEvent {
    protected CustomEventListener mAdCustomEventListener;
    protected CustomEvent mCustomEvent;
    protected MediationData mMediationData;
    protected Timer mTimer;
    private String TAG = "CustomEvent";
    protected boolean mIsFinished = false;
    protected String mAdxUnitId = null;

    public abstract void internalLoadAd(Context context, MediationData mediationData, long j, CustomEventListener customEventListener);

    public Map convertJsonToMap(MediationData mediationData) {
        HashMap map = new HashMap();
        try {
            map.put("ecpm", String.valueOf(mediationData.getEcpm()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (mediationData != null && !TextUtils.isEmpty(mediationData.getCustomEventParams())) {
            try {
                JSONObject jSONObject = new JSONObject(mediationData.getCustomEventParams());
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.getString(next));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return map;
    }

    public void setCustomEventListener(CustomEventListener customEventListener) {
        this.mAdCustomEventListener = customEventListener;
    }

    public void destroy() {
        stopTimer();
        this.mAdCustomEventListener = null;
        CustomEvent customEvent = this.mCustomEvent;
        if (customEvent != null) {
            customEvent.destroy();
            this.mCustomEvent = null;
        }
    }

    public MediationData getMediationData() {
        return this.mMediationData;
    }

    public void setCustomEvent(CustomEvent customEvent) {
        this.mCustomEvent = customEvent;
    }

    public CustomEvent getCustomEvent() {
        return this.mCustomEvent;
    }

    public void setAdxUnitId(String str) {
        this.mAdxUnitId = str;
    }

    protected void startTimer(long j) {
        this.mTimer = new Timer();
        this.mTimer.schedule(new AdCheckTimerTask(), j);
    }

    protected void stopTimer() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
    }

    class AdCheckTimerTask extends TimerTask {
        AdCheckTimerTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (CustomEvent.this.mIsFinished) {
                return;
            }
            CustomEvent.this.mIsFinished = true;
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                if (CustomEvent.this.mMediationData != null) {
                    ADXLogUtil.d(CustomEvent.this.TAG, "CustomEvent loading time is delayed.(" + CustomEvent.this.mMediationData.getAdNetworkName() + "," + CustomEvent.this.mMediationData.getMediationId() + "," + CustomEvent.this.mMediationData.getCustomEventParams() + ")");
                } else {
                    ADXLogUtil.d(CustomEvent.this.TAG, "CustomEvent loading time is delayed.");
                }
            }
            if (CustomEvent.this.mAdCustomEventListener != null) {
                CustomEvent.this.mAdCustomEventListener.onAdError();
            }
        }
    }
}
