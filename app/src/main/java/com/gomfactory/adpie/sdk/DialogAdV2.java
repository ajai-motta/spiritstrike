package com.gomfactory.adpie.sdk;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.gomfactory.adpie.sdk.NativeAd;
import com.gomfactory.adpie.sdk.common.Constants;
import com.gomfactory.adpie.sdk.dialog.DialogStyleV2;
import com.gomfactory.adpie.sdk.dialog.RoundedRelativeLayout;
import com.gomfactory.adpie.sdk.nativeads.NativeAdData;
import com.gomfactory.adpie.sdk.nativeads.NativeAdView;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import com.gomfactory.adpie.sdk.util.DisplayUtil;
import io.ktor.sse.ServerSentEventKt;

/* JADX INFO: loaded from: classes3.dex */
public class DialogAdV2 extends Dialog {
    public static final String TAG = "DialogAdV2";
    private int[] mAdContentsPadding;
    private FrameLayout mAdFrameLayout;
    private int mBackgroundColor;
    private LinearLayout mButtonContainer;
    public int mButtonCount;
    public int mButtonTextSize;
    private LinearLayout mContentLayout;
    private Context mContext;
    private NativeAdData mDefaultNativeAdData;
    private DialogAdListener mDialogAdListener;
    private RoundedRelativeLayout mDialogLayout;
    private DialogStyleV2 mDialogStyle;
    private int mFirstButtonColor;
    private String mFirstButtonText;
    private int mFirstButtonTextColor;
    private View mLine;
    private String mMessageText;
    private int mMessageTextColor;
    private int mMessageTextSize;
    private TextView mMessageTextView;
    private NativeAd mNativeAd;
    private NativeAdView mNativeAdView;
    private int mRadius;
    private int mSecondButtonColor;
    private String mSecondButtonText;
    private int mSecondButtonTextColor;
    private String mSlotId;
    private int mThirdButtonColor;
    private String mThirdButtonText;
    private int mThirdButtonTextColor;

    public interface DialogAdListener {
        void onAdClicked();

        void onAdFailedToLoad(int i);

        void onAdLoaded();

        void onFirstButtonClicked();

        void onSecondButtonClicked();

        void onThirdButtonClicked();
    }

    public DialogAdV2(Context context, DialogStyleV2 dialogStyleV2) {
        super(context);
        this.mButtonCount = 2;
        this.mButtonTextSize = 15;
        this.mBackgroundColor = -1;
        this.mMessageText = Constants.DEFAULT_DIALOG_MESSAGE_TEXT;
        this.mMessageTextColor = -16777216;
        this.mMessageTextSize = 15;
        this.mFirstButtonText = Constants.DEFAULT_DIALOG_FIRST_BUTTON_TEXT;
        this.mFirstButtonColor = Constants.DEFAULT_DIALOG_BUTTON_COLOR;
        this.mFirstButtonTextColor = -1;
        this.mSecondButtonText = Constants.DEFAULT_DIALOG_SECOND_BUTTON_TEXT;
        this.mSecondButtonColor = Constants.DEFAULT_DIALOG_BUTTON_COLOR;
        this.mSecondButtonTextColor = -1;
        this.mThirdButtonText = Constants.DEFAULT_DIALOG_THIRD_BUTTON_TEXT;
        this.mThirdButtonColor = Constants.DEFAULT_DIALOG_BUTTON_COLOR;
        this.mThirdButtonTextColor = -1;
        this.mRadius = 10;
        this.mContext = context;
        setDialogStyle(dialogStyleV2);
    }

    public DialogAdV2(Context context, DialogStyleV2 dialogStyleV2, String str) {
        super(context);
        this.mButtonCount = 2;
        this.mButtonTextSize = 15;
        this.mBackgroundColor = -1;
        this.mMessageText = Constants.DEFAULT_DIALOG_MESSAGE_TEXT;
        this.mMessageTextColor = -16777216;
        this.mMessageTextSize = 15;
        this.mFirstButtonText = Constants.DEFAULT_DIALOG_FIRST_BUTTON_TEXT;
        this.mFirstButtonColor = Constants.DEFAULT_DIALOG_BUTTON_COLOR;
        this.mFirstButtonTextColor = -1;
        this.mSecondButtonText = Constants.DEFAULT_DIALOG_SECOND_BUTTON_TEXT;
        this.mSecondButtonColor = Constants.DEFAULT_DIALOG_BUTTON_COLOR;
        this.mSecondButtonTextColor = -1;
        this.mThirdButtonText = Constants.DEFAULT_DIALOG_THIRD_BUTTON_TEXT;
        this.mThirdButtonColor = Constants.DEFAULT_DIALOG_BUTTON_COLOR;
        this.mThirdButtonTextColor = -1;
        this.mRadius = 10;
        this.mContext = context;
        this.mSlotId = str;
        setDialogStyle(dialogStyleV2);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String str = TAG;
        AdPieLog.d(str, this.mSlotId + ":::onCreate");
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        int iDpToPx = DisplayUtil.dpToPx(this.mContext, 15);
        int iDpToPx2 = DisplayUtil.dpToPx(this.mContext, 20);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setPadding(iDpToPx2, iDpToPx2, iDpToPx2, iDpToPx2);
        addContentView(linearLayout, layoutParams);
        float fMin = Math.min(DisplayUtil.getDeviceWidth(this.mContext), DisplayUtil.getDeviceHeight(this.mContext));
        float fMax = Math.max(DisplayUtil.getDeviceWidth(this.mContext), DisplayUtil.getDeviceHeight(this.mContext));
        int i = (int) ((2.0f * fMin) / 3.0f);
        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
            AdPieLog.d(str, "deviceWidth : " + fMin + ", deviceHeight : " + fMax + ", dialogWidth : " + i);
        }
        RoundedRelativeLayout roundedRelativeLayout = new RoundedRelativeLayout(this.mContext);
        this.mDialogLayout = roundedRelativeLayout;
        roundedRelativeLayout.setCornerRadius(DisplayUtil.dpToPx(this.mContext, this.mRadius));
        this.mDialogLayout.setBackgroundColor(this.mBackgroundColor);
        this.mDialogLayout.setLayoutParams(new RelativeLayout.LayoutParams(i, -2));
        linearLayout.addView(this.mDialogLayout);
        LinearLayout linearLayout2 = new LinearLayout(this.mContext);
        linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout2.setOrientation(1);
        this.mDialogLayout.addView(linearLayout2);
        this.mAdFrameLayout = new FrameLayout(this.mContext);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        int[] iArr = this.mAdContentsPadding;
        if (iArr != null && iArr.length == 4) {
            this.mAdFrameLayout.setPadding(DisplayUtil.dpToPx(this.mContext, iArr[0]), DisplayUtil.dpToPx(this.mContext, this.mAdContentsPadding[1]), DisplayUtil.dpToPx(this.mContext, this.mAdContentsPadding[2]), DisplayUtil.dpToPx(this.mContext, this.mAdContentsPadding[3]));
        }
        this.mAdFrameLayout.setLayoutParams(layoutParams2);
        linearLayout2.addView(this.mAdFrameLayout);
        View view = new View(this.mContext);
        this.mLine = view;
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, DisplayUtil.dpToPx(this.mContext, 2)));
        this.mLine.setBackgroundColor(Color.parseColor("#eeeeee"));
        linearLayout2.addView(this.mLine);
        this.mLine.setVisibility(8);
        LinearLayout linearLayout3 = new LinearLayout(this.mContext);
        this.mContentLayout = linearLayout3;
        linearLayout3.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mContentLayout.setGravity(17);
        this.mContentLayout.setBackgroundColor(this.mBackgroundColor);
        TextView textView = new TextView(this.mContext);
        this.mMessageTextView = textView;
        textView.setPadding(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
        this.mMessageTextView.setLayoutParams(new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(-2, -2)));
        this.mMessageTextView.setTextSize(1, this.mMessageTextSize);
        this.mMessageTextView.setTextColor(this.mMessageTextColor);
        if (!TextUtils.isEmpty(this.mMessageText)) {
            this.mMessageTextView.setText(this.mMessageText.replace(ServerSentEventKt.SPACE, " "));
        } else {
            this.mMessageTextView.setText("");
        }
        this.mContentLayout.addView(this.mMessageTextView);
        linearLayout2.addView(this.mContentLayout);
        this.mButtonContainer = new LinearLayout(this.mContext);
        this.mButtonContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.mButtonContainer.setOrientation(0);
        linearLayout2.addView(this.mButtonContainer);
        addButton();
    }

    @Override // android.app.Dialog
    public void show() {
        ImageView mainImageView;
        ImageView iconImageView;
        ImageView mainImageView2;
        ImageView iconImageView2;
        super.show();
        AdPieLog.d(TAG, this.mSlotId + ":::show");
        if (AdPieSDK.getInstance().getNetworkConnectionType() == 0) {
            if (this.mDefaultNativeAdData != null) {
                NativeAdView nativeAdView = new NativeAdView(this.mContext, null, null);
                nativeAdView.fillAd(this.mDefaultNativeAdData);
                DialogStyleV2 dialogStyleV2 = this.mDialogStyle;
                if (dialogStyleV2 != null && dialogStyleV2.getIconImageResId() > 0 && (iconImageView2 = nativeAdView.getIconImageView()) != null) {
                    iconImageView2.setImageResource(this.mDialogStyle.getIconImageResId());
                }
                DialogStyleV2 dialogStyleV22 = this.mDialogStyle;
                if (dialogStyleV22 != null && dialogStyleV22.getMainImageResId() > 0 && (mainImageView2 = nativeAdView.getMainImageView()) != null) {
                    mainImageView2.setImageResource(this.mDialogStyle.getMainImageResId());
                }
                this.mAdFrameLayout.addView(nativeAdView);
                FrameLayout frameLayout = this.mAdFrameLayout;
                if (frameLayout != null) {
                    frameLayout.setVisibility(0);
                }
                View view = this.mLine;
                if (view != null) {
                    view.setVisibility(0);
                    return;
                }
                return;
            }
            FrameLayout frameLayout2 = this.mAdFrameLayout;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
            View view2 = this.mLine;
            if (view2 != null) {
                view2.setVisibility(8);
                return;
            }
            return;
        }
        NativeAdView nativeAdView2 = this.mNativeAdView;
        if (nativeAdView2 != null && nativeAdView2.isResourceLoaded()) {
            FrameLayout frameLayout3 = this.mAdFrameLayout;
            if (frameLayout3 != null) {
                frameLayout3.addView(this.mNativeAdView);
                this.mAdFrameLayout.setVisibility(0);
                View view3 = this.mLine;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
                this.mNativeAdView = null;
                return;
            }
            return;
        }
        if (this.mDefaultNativeAdData != null) {
            NativeAdView nativeAdView3 = new NativeAdView(this.mContext, null, null);
            nativeAdView3.fillAd(this.mDefaultNativeAdData);
            DialogStyleV2 dialogStyleV23 = this.mDialogStyle;
            if (dialogStyleV23 != null && dialogStyleV23.getIconImageResId() > 0 && (iconImageView = nativeAdView3.getIconImageView()) != null) {
                iconImageView.setImageResource(this.mDialogStyle.getIconImageResId());
            }
            DialogStyleV2 dialogStyleV24 = this.mDialogStyle;
            if (dialogStyleV24 != null && dialogStyleV24.getMainImageResId() > 0 && (mainImageView = nativeAdView3.getMainImageView()) != null) {
                mainImageView.setImageResource(this.mDialogStyle.getMainImageResId());
            }
            this.mAdFrameLayout.addView(nativeAdView3);
            FrameLayout frameLayout4 = this.mAdFrameLayout;
            if (frameLayout4 != null) {
                frameLayout4.setVisibility(0);
            }
            View view4 = this.mLine;
            if (view4 != null) {
                view4.setVisibility(0);
                return;
            }
            return;
        }
        FrameLayout frameLayout5 = this.mAdFrameLayout;
        if (frameLayout5 != null) {
            frameLayout5.setVisibility(8);
        }
        View view5 = this.mLine;
        if (view5 != null) {
            view5.setVisibility(8);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
        AdPieLog.d(TAG, this.mSlotId + ":::cancel");
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        AdPieLog.d(TAG, this.mSlotId + ":::dismiss");
        super.dismiss();
        releaseAdView();
    }

    public void setSlotId(String str) {
        this.mSlotId = str;
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            nativeAd.setSlotId(str);
        }
    }

    public void setDialogAdListenr(DialogAdListener dialogAdListener) {
        this.mDialogAdListener = dialogAdListener;
    }

    public DialogStyleV2 getDialogStyle() {
        return this.mDialogStyle;
    }

    public void setDialogStyle(DialogStyleV2 dialogStyleV2) {
        this.mDialogStyle = dialogStyleV2;
        if (dialogStyleV2 != null) {
            AdPieLog.d(TAG, "dialogStyle : " + dialogStyleV2.toString());
            if (dialogStyleV2.getButtonCount() == 1 || dialogStyleV2.getButtonCount() == 2 || dialogStyleV2.getButtonCount() == 3) {
                this.mButtonCount = dialogStyleV2.getButtonCount();
            }
            if (dialogStyleV2.getButtonTextSize() > 0) {
                this.mButtonTextSize = dialogStyleV2.getButtonTextSize();
            }
            if (!TextUtils.isEmpty(dialogStyleV2.getMessageText())) {
                String messageText = dialogStyleV2.getMessageText();
                this.mMessageText = messageText;
                TextView textView = this.mMessageTextView;
                if (textView != null) {
                    textView.setText(messageText.replace(ServerSentEventKt.SPACE, " "));
                }
            } else {
                this.mMessageText = "";
                TextView textView2 = this.mMessageTextView;
                if (textView2 != null) {
                    textView2.setText("");
                }
            }
            if (dialogStyleV2.getMessageTextColor() != 0) {
                int messageTextColor = dialogStyleV2.getMessageTextColor();
                this.mMessageTextColor = messageTextColor;
                TextView textView3 = this.mMessageTextView;
                if (textView3 != null) {
                    textView3.setTextColor(messageTextColor);
                }
            }
            if (dialogStyleV2.getMessageTextSize() > 0) {
                int messageTextSize = dialogStyleV2.getMessageTextSize();
                this.mMessageTextSize = messageTextSize;
                TextView textView4 = this.mMessageTextView;
                if (textView4 != null) {
                    textView4.setTextSize(1, messageTextSize);
                }
            }
            if (!TextUtils.isEmpty(dialogStyleV2.getFirstButtonText())) {
                this.mFirstButtonText = dialogStyleV2.getFirstButtonText();
            }
            if (!TextUtils.isEmpty(dialogStyleV2.getSecondButtonText())) {
                this.mSecondButtonText = dialogStyleV2.getSecondButtonText();
            }
            if (!TextUtils.isEmpty(dialogStyleV2.getThirdButtonText())) {
                this.mThirdButtonText = dialogStyleV2.getThirdButtonText();
            }
            if (dialogStyleV2.getBackgroundColor() != 0) {
                int backgroundColor = dialogStyleV2.getBackgroundColor();
                this.mBackgroundColor = backgroundColor;
                RoundedRelativeLayout roundedRelativeLayout = this.mDialogLayout;
                if (roundedRelativeLayout != null) {
                    roundedRelativeLayout.setBackgroundColor(backgroundColor);
                }
                LinearLayout linearLayout = this.mContentLayout;
                if (linearLayout != null) {
                    linearLayout.setBackgroundColor(this.mBackgroundColor);
                }
            }
            if (dialogStyleV2.getFirstButtonColor() != 0) {
                this.mFirstButtonColor = dialogStyleV2.getFirstButtonColor();
            }
            if (dialogStyleV2.getFirstButtonTextColor() != 0) {
                this.mFirstButtonTextColor = dialogStyleV2.getFirstButtonTextColor();
            }
            if (dialogStyleV2.getSecondButtonColor() != 0) {
                this.mSecondButtonColor = dialogStyleV2.getSecondButtonColor();
            }
            if (dialogStyleV2.getSecondButtonTextColor() != 0) {
                this.mSecondButtonTextColor = dialogStyleV2.getSecondButtonTextColor();
            }
            if (dialogStyleV2.getThirdButtonColor() != 0) {
                this.mThirdButtonColor = dialogStyleV2.getThirdButtonColor();
            }
            if (dialogStyleV2.getThirdButtonTextColor() != 0) {
                this.mThirdButtonTextColor = dialogStyleV2.getThirdButtonTextColor();
            }
            addButton();
            if (dialogStyleV2.getRadius() >= 0) {
                int radius = dialogStyleV2.getRadius();
                this.mRadius = radius;
                RoundedRelativeLayout roundedRelativeLayout2 = this.mDialogLayout;
                if (roundedRelativeLayout2 != null) {
                    roundedRelativeLayout2.setCornerRadius(DisplayUtil.dpToPx(this.mContext, radius));
                }
            }
            int[] adContentsPadding = dialogStyleV2.getAdContentsPadding();
            if (adContentsPadding != null && adContentsPadding.length == 4) {
                this.mAdContentsPadding = adContentsPadding;
                FrameLayout frameLayout = this.mAdFrameLayout;
                if (frameLayout != null) {
                    frameLayout.setPadding(DisplayUtil.dpToPx(this.mContext, adContentsPadding[0]), DisplayUtil.dpToPx(this.mContext, this.mAdContentsPadding[1]), DisplayUtil.dpToPx(this.mContext, this.mAdContentsPadding[2]), DisplayUtil.dpToPx(this.mContext, this.mAdContentsPadding[3]));
                }
            }
            if (!TextUtils.isEmpty(dialogStyleV2.getTitle()) || !TextUtils.isEmpty(dialogStyleV2.getDescription()) || dialogStyleV2.getIconImageResId() > 0 || dialogStyleV2.getMainImageResId() > 0) {
                if (this.mDefaultNativeAdData == null) {
                    this.mDefaultNativeAdData = new NativeAdData();
                }
                this.mDefaultNativeAdData.setTitle(dialogStyleV2.getTitle());
                this.mDefaultNativeAdData.setDescription(dialogStyleV2.getDescription());
                if (dialogStyleV2.getIconImageResId() > 0) {
                    this.mDefaultNativeAdData.setIconImageUrl("" + dialogStyleV2.getIconImageResId());
                }
                if (dialogStyleV2.getMainImageResId() > 0) {
                    this.mDefaultNativeAdData.setMainImageUrl("" + dialogStyleV2.getMainImageResId());
                }
                this.mDefaultNativeAdData.setCallToAction(dialogStyleV2.getCtaButtonText());
                this.mDefaultNativeAdData.setLink(dialogStyleV2.getClickUrl());
            }
        }
    }

    public void setMessage(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mMessageText = str;
            TextView textView = this.mMessageTextView;
            if (textView != null) {
                textView.setText(str.replace(ServerSentEventKt.SPACE, " "));
                return;
            }
            return;
        }
        this.mMessageText = "";
        TextView textView2 = this.mMessageTextView;
        if (textView2 != null) {
            textView2.setText("");
        }
    }

    private void initAdView() {
        try {
            if (this.mNativeAd != null) {
                return;
            }
            NativeAd nativeAd = new NativeAd(this.mContext, null);
            this.mNativeAd = nativeAd;
            nativeAd.setSlotId(this.mSlotId);
            this.mNativeAd.setAdListener(new NativeAd.AdListener() { // from class: com.gomfactory.adpie.sdk.DialogAdV2.1
                @Override // com.gomfactory.adpie.sdk.NativeAd.AdListener
                public void onAdShown() {
                }

                @Override // com.gomfactory.adpie.sdk.NativeAd.AdListener
                public void onAdLoaded(NativeAdView nativeAdView) {
                    AdPieLog.d(DialogAdV2.TAG, DialogAdV2.this.mSlotId + ":::onAdLoaded");
                    DialogAdV2.this.mNativeAdView = nativeAdView;
                    if (DialogAdV2.this.mDialogAdListener != null) {
                        DialogAdV2.this.mDialogAdListener.onAdLoaded();
                    }
                }

                @Override // com.gomfactory.adpie.sdk.NativeAd.AdListener
                public void onAdFailedToLoad(int i) {
                    AdPieLog.d(DialogAdV2.TAG, DialogAdV2.this.mSlotId + ":::onAdFailedToLoad:::" + i);
                    if (DialogAdV2.this.mDialogAdListener != null) {
                        DialogAdV2.this.mDialogAdListener.onAdFailedToLoad(i);
                    }
                }

                @Override // com.gomfactory.adpie.sdk.NativeAd.AdListener
                public void onAdClicked() {
                    AdPieLog.d(DialogAdV2.TAG, DialogAdV2.this.mSlotId + ":::onAdClicked");
                    if (DialogAdV2.this.mDialogAdListener != null) {
                        DialogAdV2.this.mDialogAdListener.onAdClicked();
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    private void releaseAdView() {
        try {
            this.mAdFrameLayout.removeAllViews();
            NativeAd nativeAd = this.mNativeAd;
            if (nativeAd != null) {
                nativeAd.destroy();
                this.mNativeAd = null;
            }
        } catch (Exception unused) {
        }
    }

    public void loadAd() {
        initAdView();
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd == null || this.mNativeAdView != null) {
            return;
        }
        nativeAd.loadAd();
    }

    public void loadAd(TargetingData targetingData) {
        initAdView();
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd == null || this.mNativeAdView != null) {
            return;
        }
        nativeAd.loadAd(targetingData);
    }

    public void destroy() {
        dismiss();
        this.mNativeAdView = null;
    }

    private void addButton() {
        LinearLayout linearLayout = this.mButtonContainer;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            this.mButtonContainer.setWeightSum(this.mButtonCount);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            for (int i = 0; i < this.mButtonCount; i++) {
                if (i > 0) {
                    View view = new View(this.mContext);
                    view.setLayoutParams(new ViewGroup.LayoutParams(DisplayUtil.dpToPx(this.mContext, 2), -1));
                    view.setBackgroundColor(this.mBackgroundColor);
                    this.mButtonContainer.addView(view);
                }
                if (i == 0) {
                    Button button = new Button(this.mContext);
                    button.setLayoutParams(layoutParams);
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.gomfactory.adpie.sdk.DialogAdV2.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            DialogAdV2.this.dismiss();
                            if (DialogAdV2.this.mDialogAdListener != null) {
                                DialogAdV2.this.mDialogAdListener.onFirstButtonClicked();
                            }
                        }
                    });
                    button.setText(this.mFirstButtonText);
                    button.setTextSize(1, this.mButtonTextSize);
                    button.setBackgroundColor(this.mFirstButtonColor);
                    button.setTextColor(this.mFirstButtonTextColor);
                    this.mButtonContainer.addView(button);
                } else if (i == 1) {
                    Button button2 = new Button(this.mContext);
                    button2.setLayoutParams(layoutParams);
                    button2.setOnClickListener(new View.OnClickListener() { // from class: com.gomfactory.adpie.sdk.DialogAdV2.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            DialogAdV2.this.dismiss();
                            if (DialogAdV2.this.mDialogAdListener != null) {
                                DialogAdV2.this.mDialogAdListener.onSecondButtonClicked();
                            }
                        }
                    });
                    button2.setText(this.mSecondButtonText);
                    button2.setTextSize(1, this.mButtonTextSize);
                    button2.setBackgroundColor(this.mSecondButtonColor);
                    button2.setTextColor(this.mSecondButtonTextColor);
                    this.mButtonContainer.addView(button2);
                } else if (i == 2) {
                    Button button3 = new Button(this.mContext);
                    button3.setLayoutParams(layoutParams);
                    button3.setOnClickListener(new View.OnClickListener() { // from class: com.gomfactory.adpie.sdk.DialogAdV2.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            DialogAdV2.this.dismiss();
                            if (DialogAdV2.this.mDialogAdListener != null) {
                                DialogAdV2.this.mDialogAdListener.onThirdButtonClicked();
                            }
                        }
                    });
                    button3.setText(this.mThirdButtonText);
                    button3.setTextSize(1, this.mButtonTextSize);
                    button3.setBackgroundColor(this.mThirdButtonColor);
                    button3.setTextColor(this.mThirdButtonTextColor);
                    this.mButtonContainer.addView(button3);
                }
            }
        }
    }
}
