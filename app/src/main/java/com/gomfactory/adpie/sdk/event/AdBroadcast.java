package com.gomfactory.adpie.sdk.event;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.util.AdPieLog;

/* JADX INFO: loaded from: classes3.dex */
public class AdBroadcast extends BroadcastReceiver {
    public static final String ACTION_INTERSTITIAL_CLICK = "com.gomfactory.adpie.action.interstitial.click";
    public static final String ACTION_INTERSTITIAL_DISMISS = "com.gomfactory.adpie.action.interstitial.dismiss";
    public static final String ACTION_INTERSTITIAL_SHOW = "com.gomfactory.adpie.action.interstitial.show";
    public static final String ACTION_INTERSTITIAL_VIDEO_COMPLETED = "com.gomfactory.adpie.action.interstitial.video_completed";
    public static final String ACTION_INTERSTITIAL_VIDEO_ERROR = "com.gomfactory.adpie.action.interstitial.video_error";
    public static final String ACTION_INTERSTITIAL_VIDEO_PAUSED = "com.gomfactory.adpie.action.interstitial.video_paused";
    public static final String ACTION_INTERSTITIAL_VIDEO_SKIPPED = "com.gomfactory.adpie.action.interstitial.video_skipped";
    public static final String ACTION_INTERSTITIAL_VIDEO_STARTED = "com.gomfactory.adpie.action.interstitial.video_started";
    public static final String ACTION_INTERSTITIAL_VIDEO_STOPPED = "com.gomfactory.adpie.action.interstitial.video_stopped";
    public static final String BROADCAST_IDENTIFIER_KEY = "broadcast_identifier";
    public static final String TAG = "AdBroadcast";
    private AdEventListener mAdEventListener;
    private long mBroadcastIdentifier;
    private Context mContext;
    private IntentFilter mIntentFilter;

    public AdBroadcast(AdEventListener adEventListener, long j) {
        this.mAdEventListener = adEventListener;
        this.mBroadcastIdentifier = j;
    }

    public static void sendBroadCast(Context context, long j, String str) {
        Intent intent = new Intent(str);
        intent.putExtra("broadcast_identifier", j);
        LocalBroadcastManager.getInstance(context.getApplicationContext()).sendBroadcast(intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.mAdEventListener == null) {
            return;
        }
        if (this.mBroadcastIdentifier != intent.getLongExtra("broadcast_identifier", -1L)) {
            return;
        }
        String action = intent.getAction();
        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
            AdPieLog.d(TAG, "action : " + action);
        }
        if (action.equals(ACTION_INTERSTITIAL_SHOW)) {
            this.mAdEventListener.notifyAdShown();
            return;
        }
        if (action.equals(ACTION_INTERSTITIAL_DISMISS)) {
            this.mAdEventListener.notifyAdDismissed();
            unregister();
            return;
        }
        if (action.equals(ACTION_INTERSTITIAL_CLICK)) {
            this.mAdEventListener.notifyAdClicked();
            return;
        }
        if (action.equals(ACTION_INTERSTITIAL_VIDEO_STARTED)) {
            this.mAdEventListener.notifyVideoAdStarted();
            return;
        }
        if (action.equals(ACTION_INTERSTITIAL_VIDEO_ERROR)) {
            this.mAdEventListener.notifyVideoAdError();
            return;
        }
        if (action.equals(ACTION_INTERSTITIAL_VIDEO_SKIPPED)) {
            this.mAdEventListener.notifyVideoAdSkipped();
            return;
        }
        if (action.equals(ACTION_INTERSTITIAL_VIDEO_COMPLETED)) {
            this.mAdEventListener.notifyVideoAdCompleted();
        } else if (action.equals(ACTION_INTERSTITIAL_VIDEO_STOPPED)) {
            this.mAdEventListener.notifyVideoAdStopped();
        } else if (action.equals(ACTION_INTERSTITIAL_VIDEO_PAUSED)) {
            this.mAdEventListener.notifyVideoAdPaused();
        }
    }

    public void register(Context context) {
        this.mContext = context;
        if (this.mIntentFilter == null) {
            IntentFilter intentFilter = new IntentFilter();
            this.mIntentFilter = intentFilter;
            intentFilter.addAction(ACTION_INTERSTITIAL_SHOW);
            this.mIntentFilter.addAction(ACTION_INTERSTITIAL_DISMISS);
            this.mIntentFilter.addAction(ACTION_INTERSTITIAL_CLICK);
            this.mIntentFilter.addAction(ACTION_INTERSTITIAL_VIDEO_STARTED);
            this.mIntentFilter.addAction(ACTION_INTERSTITIAL_VIDEO_ERROR);
            this.mIntentFilter.addAction(ACTION_INTERSTITIAL_VIDEO_SKIPPED);
            this.mIntentFilter.addAction(ACTION_INTERSTITIAL_VIDEO_COMPLETED);
            this.mIntentFilter.addAction(ACTION_INTERSTITIAL_VIDEO_STOPPED);
            this.mIntentFilter.addAction(ACTION_INTERSTITIAL_VIDEO_PAUSED);
        }
        LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this, this.mIntentFilter);
    }

    public void unregister() {
        Context context = this.mContext;
        if (context != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
        }
    }
}
