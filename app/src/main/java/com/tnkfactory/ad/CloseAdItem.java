package com.tnkfactory.ad;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.gomfactory.adpie.sdk.common.Constants;

/* JADX INFO: loaded from: classes6.dex */
public class CloseAdItem {
    private InterstitialAdItem interstitialAdItem;
    private Context mContext;
    private String mPlacementId;
    private CloseAdListener userListener;
    private boolean isWaiting = false;
    private long requestShow = 0;
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.tnkfactory.ad.CloseAdItem.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            CloseAdItem closeAdItem = CloseAdItem.this;
            if (closeAdItem.isWaiting) {
                closeAdItem.userListener.onError();
            }
        }
    };
    CloseAdListener defaultUserListener = new CloseAdListener() { // from class: com.tnkfactory.ad.CloseAdItem.3
        @Override // com.tnkfactory.ad.CloseAdItem.CloseAdListener
        public void onConfirm() {
            Context context = CloseAdItem.this.mContext;
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
        }

        @Override // com.tnkfactory.ad.CloseAdItem.CloseAdListener
        public void onError() {
            new AlertDialog.Builder(CloseAdItem.this.mContext).setMessage("앱을 종료하시겠습니까?").setCancelable(false).setNegativeButton(Constants.DEFAULT_DIALOG_FIRST_BUTTON_TEXT, new DialogInterface.OnClickListener() { // from class: com.tnkfactory.ad.CloseAdItem.3.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).setPositiveButton(Constants.DEFAULT_DIALOG_THIRD_BUTTON_TEXT, new DialogInterface.OnClickListener() { // from class: com.tnkfactory.ad.CloseAdItem.3.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    ((Activity) CloseAdItem.this.mContext).finish();
                }
            }).show();
        }
    };
    AdListener adListener = new AdListener() { // from class: com.tnkfactory.ad.CloseAdItem.4
        @Override // com.tnkfactory.ad.AdListener
        public String logTag() {
            return super.logTag();
        }

        @Override // com.tnkfactory.ad.AdListener
        public void onClick(AdItem adItem) {
            super.onClick(adItem);
            CloseAdListener closeAdListener = CloseAdItem.this.userListener;
            if (closeAdListener != null) {
                closeAdListener.onClickAd(adItem);
            }
        }

        @Override // com.tnkfactory.ad.AdListener
        public void onClose(AdItem adItem, int i) {
            super.onClose(adItem, i);
            if (i == AdListener.CLOSE_SIMPLE) {
                CloseAdItem.this.userListener.onCancel();
            } else if (i == AdListener.CLOSE_EXIT) {
                CloseAdItem.this.userListener.onConfirm();
            }
        }

        @Override // com.tnkfactory.ad.AdListener
        public void onError(AdItem adItem, AdError adError) {
            super.onError(adItem, adError);
            CloseAdItem closeAdItem = CloseAdItem.this;
            if (closeAdItem.isWaiting) {
                closeAdItem.userListener.onError();
                CloseAdItem.this.isWaiting = false;
            }
        }

        @Override // com.tnkfactory.ad.AdListener
        public void onLoad(AdItem adItem) {
            super.onLoad(adItem);
            if (CloseAdItem.this.isWaiting) {
                adItem.show();
                CloseAdItem.this.isWaiting = false;
            }
        }

        @Override // com.tnkfactory.ad.AdListener
        public void onShow(AdItem adItem) {
            super.onShow(adItem);
            CloseAdItem closeAdItem = CloseAdItem.this;
            closeAdItem.isWaiting = false;
            CloseAdListener closeAdListener = closeAdItem.userListener;
            if (closeAdListener != null) {
                closeAdListener.onShow(adItem);
            }
            CloseAdItem.this.createAdItem();
            CloseAdItem.this.interstitialAdItem.load();
        }

        @Override // com.tnkfactory.ad.AdListener
        public void onVideoCompletion(AdItem adItem, int i) {
            super.onVideoCompletion(adItem, i);
        }
    };

    public static abstract class CloseAdListener {
        public void onCancel() {
        }

        public void onClickAd(AdItem adItem) {
        }

        public abstract void onConfirm();

        public abstract void onError();

        public void onShow(AdItem adItem) {
        }
    }

    public CloseAdItem(Context context, String str) {
        this.mContext = context;
        this.mPlacementId = str;
        createAdItem();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAdItem() {
        this.interstitialAdItem = new InterstitialAdItem(this.mContext, this.mPlacementId);
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.tnkfactory.ad.CloseAdItem.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                CloseAdItem closeAdItem = CloseAdItem.this;
                if (closeAdItem.isWaiting) {
                    closeAdItem.isWaiting = false;
                    closeAdItem.userListener.onError();
                }
            }
        };
        this.interstitialAdItem.setListener(this.adListener);
    }

    public void load() {
        this.interstitialAdItem.load();
    }

    public void setListener(CloseAdListener closeAdListener) {
        this.userListener = closeAdListener;
    }

    public void show() {
        if (this.requestShow > System.currentTimeMillis() - 200) {
            return;
        }
        this.requestShow = System.currentTimeMillis();
        if (this.userListener == null) {
            this.userListener = this.defaultUserListener;
        }
        if (this.isWaiting) {
            return;
        }
        this.isWaiting = false;
        if (this.interstitialAdItem.isLoaded()) {
            this.interstitialAdItem.show();
        } else {
            this.isWaiting = true;
            this.handler.sendEmptyMessageDelayed(0, 500L);
        }
    }

    public void show(CloseAdListener closeAdListener) {
        this.userListener = closeAdListener;
        show();
    }
}
