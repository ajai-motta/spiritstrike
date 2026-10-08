package com.gomfactory.adpie.sdk;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
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
import android.widget.TextView;
import androidx.compose.animation.core.AnimationConstants;
import com.gomfactory.adpie.sdk.common.Constants;
import com.gomfactory.adpie.sdk.dialog.DialogAdView;
import com.gomfactory.adpie.sdk.dialog.DialogStyleV1;
import com.gomfactory.adpie.sdk.dialog.RoundedRelativeLayout;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import com.gomfactory.adpie.sdk.util.ClickThroughUtil;
import com.gomfactory.adpie.sdk.util.DisplayUtil;

/* JADX INFO: loaded from: classes3.dex */
public class DialogAdV1 extends Dialog {
    public static final String TAG = "DialogAdV1";
    private ImageView defaultImageView;
    private FrameLayout mAdFrameLayout;
    private int mAdHeight;
    private DialogAdView mAdView;
    private int mAdWidth;
    private int mBackgroundColor;
    private LinearLayout mButtonContainer;
    public int mButtonCount;
    public int mButtonTextSize;
    private String mClickUrl;
    private LinearLayout mContentLayout;
    private Context mContext;
    private int mDefaultImageResId;
    private DialogAdListener mDialogAdListener;
    private RoundedRelativeLayout mDialogLayout;
    private DialogStyleV1 mDialogStyle;
    private int mFirstButtonColor;
    private String mFirstButtonText;
    private int mFirstButtonTextColor;
    private View mLine;
    private String mMessageText;
    private int mMessageTextColor;
    private int mMessageTextSize;
    private TextView mMessageTextView;
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

    public DialogAdV1(Context context, DialogStyleV1 dialogStyleV1) {
        super(context);
        this.mButtonCount = 2;
        this.mButtonTextSize = 15;
        this.mAdWidth = 250;
        this.mAdHeight = 250;
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
        setDialogStyle(dialogStyleV1);
    }

    public DialogAdV1(Context context, DialogStyleV1 dialogStyleV1, String str) {
        super(context);
        this.mButtonCount = 2;
        this.mButtonTextSize = 15;
        this.mAdWidth = 250;
        this.mAdHeight = 250;
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
        setDialogStyle(dialogStyleV1);
    }

    protected DialogAdV1(Context context, int i) {
        super(context, i);
        this.mButtonCount = 2;
        this.mButtonTextSize = 15;
        this.mAdWidth = 250;
        this.mAdHeight = 250;
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
    }

    protected DialogAdV1(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.mButtonCount = 2;
        this.mButtonTextSize = 15;
        this.mAdWidth = 250;
        this.mAdHeight = 250;
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
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AdPieLog.d(TAG, this.mSlotId + ":::onCreate");
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        RoundedRelativeLayout roundedRelativeLayout = new RoundedRelativeLayout(this.mContext);
        this.mDialogLayout = roundedRelativeLayout;
        roundedRelativeLayout.setCornerRadius(DisplayUtil.dpToPx(this.mContext, this.mRadius));
        this.mDialogLayout.setBackgroundColor(this.mBackgroundColor);
        addContentView(this.mDialogLayout, new ViewGroup.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        this.mDialogLayout.addView(linearLayout);
        if (this.mAdFrameLayout == null) {
            this.mAdFrameLayout = new FrameLayout(this.mContext);
            this.mAdFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DisplayUtil.dpToPx(this.mContext, this.mAdWidth), DisplayUtil.dpToPx(this.mContext, this.mAdHeight));
        layoutParams.gravity = 1;
        if (this.mDefaultImageResId > 0) {
            ImageView imageView = new ImageView(this.mContext);
            this.defaultImageView = imageView;
            imageView.setLayoutParams(layoutParams);
            this.defaultImageView.setAdjustViewBounds(true);
            this.defaultImageView.setVisibility(8);
            this.defaultImageView.setImageResource(this.mDefaultImageResId);
            this.defaultImageView.setOnClickListener(new View.OnClickListener() { // from class: com.gomfactory.adpie.sdk.DialogAdV1.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!ClickThroughUtil.isValidClick()) {
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.d(DialogAdV1.TAG, ":::clickEvent::: " + DialogAdV1.this.mClickUrl + " -> block");
                            return;
                        }
                        return;
                    }
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(DialogAdV1.TAG, ":::clickEvent::: " + DialogAdV1.this.mClickUrl);
                    }
                    ClickThroughUtil.goToBrowser(DialogAdV1.this.mContext, DialogAdV1.this.mClickUrl);
                }
            });
            this.mAdFrameLayout.addView(this.defaultImageView);
        }
        linearLayout.addView(this.mAdFrameLayout);
        View view = new View(this.mContext);
        this.mLine = view;
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, DisplayUtil.dpToPx(this.mContext, 2)));
        this.mLine.setBackgroundColor(Color.parseColor("#eeeeee"));
        linearLayout.addView(this.mLine);
        this.mLine.setVisibility(8);
        LinearLayout linearLayout2 = new LinearLayout(this.mContext);
        this.mContentLayout = linearLayout2;
        linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mContentLayout.setBackgroundColor(this.mBackgroundColor);
        this.mMessageTextView = new TextView(this.mContext);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(-1, -2));
        layoutParams2.topMargin = DisplayUtil.dpToPx(this.mContext, 20);
        layoutParams2.bottomMargin = DisplayUtil.dpToPx(this.mContext, 20);
        this.mMessageTextView.setGravity(17);
        this.mMessageTextView.setLayoutParams(layoutParams2);
        this.mMessageTextView.setTextSize(1, this.mMessageTextSize);
        this.mMessageTextView.setTextColor(this.mMessageTextColor);
        this.mMessageTextView.setText(this.mMessageText);
        this.mContentLayout.addView(this.mMessageTextView);
        linearLayout.addView(this.mContentLayout);
        this.mButtonContainer = new LinearLayout(this.mContext);
        this.mButtonContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.mButtonContainer.setOrientation(0);
        linearLayout.addView(this.mButtonContainer);
        addButton();
    }

    @Override // android.app.Dialog
    public void show() {
        ImageView imageView;
        DialogAdView dialogAdView;
        super.show();
        AdPieLog.d(TAG, this.mSlotId + ":::show");
        ImageView imageView2 = this.defaultImageView;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        Configuration configuration = getContext().getResources().getConfiguration();
        if (this.mAdWidth > 0 && this.mAdHeight > 0 && configuration.orientation == 1 && (dialogAdView = this.mAdView) != null && dialogAdView.isLoaded() && this.mAdView.show()) {
            FrameLayout frameLayout = this.mAdFrameLayout;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            View view = this.mLine;
            if (view != null) {
                view.setVisibility(0);
            }
        } else {
            View view2 = this.mLine;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            if (configuration.orientation == 1 && (imageView = this.defaultImageView) != null) {
                imageView.setVisibility(0);
                FrameLayout frameLayout2 = this.mAdFrameLayout;
                if (frameLayout2 != null) {
                    frameLayout2.setVisibility(0);
                }
            } else {
                FrameLayout frameLayout3 = this.mAdFrameLayout;
                if (frameLayout3 != null) {
                    frameLayout3.setVisibility(8);
                }
            }
        }
        if (this.mAdWidth > 0) {
            getWindow().setLayout(DisplayUtil.dpToPx(this.mContext, this.mAdWidth), -2);
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
    }

    public void setSlotId(String str) {
        this.mSlotId = str;
    }

    private void setAdSize(int i, int i2) {
        try {
            if (i > 320) {
                this.mAdWidth = 320;
                this.mAdHeight = (320 * i2) / i;
            } else if (i < 250) {
                this.mAdWidth = 250;
                this.mAdHeight = (250 * i2) / i;
            } else {
                this.mAdWidth = i;
                this.mAdHeight = i2;
            }
        } catch (Exception unused) {
            this.mAdWidth = i;
            this.mAdHeight = 0;
        }
    }

    private void setAdSize(int i, int i2, int i3) {
        setAdSize(i, i2);
        this.mDefaultImageResId = i3;
    }

    private void setAdSize(int i, int i2, int i3, String str) {
        setAdSize(i, i2, i3);
        this.mClickUrl = str;
    }

    public void setDialogAdListenr(DialogAdListener dialogAdListener) {
        this.mDialogAdListener = dialogAdListener;
    }

    public DialogStyleV1 getDialogStyle() {
        return this.mDialogStyle;
    }

    public void setDialogStyle(DialogStyleV1 dialogStyleV1) {
        this.mDialogStyle = dialogStyleV1;
        if (dialogStyleV1 != null) {
            AdPieLog.d(TAG, "dialogStyle : " + dialogStyleV1.toString());
            if (dialogStyleV1.getAdSize() != 0 && dialogStyleV1.getAdSize() == 1) {
                setAdSize(AnimationConstants.DefaultDurationMillis, 250, dialogStyleV1.getDefaultImageResId(), dialogStyleV1.getDefaultImageClickUrl());
            } else {
                setAdSize(250, 250, dialogStyleV1.getDefaultImageResId(), dialogStyleV1.getDefaultImageClickUrl());
            }
            if (dialogStyleV1.getButtonCount() == 1 || dialogStyleV1.getButtonCount() == 2 || dialogStyleV1.getButtonCount() == 3) {
                this.mButtonCount = dialogStyleV1.getButtonCount();
            }
            if (dialogStyleV1.getButtonTextSize() > 0) {
                this.mButtonTextSize = dialogStyleV1.getButtonTextSize();
            }
            if (!TextUtils.isEmpty(dialogStyleV1.getMessageText())) {
                String messageText = dialogStyleV1.getMessageText();
                this.mMessageText = messageText;
                TextView textView = this.mMessageTextView;
                if (textView != null) {
                    textView.setText(messageText);
                }
            }
            if (dialogStyleV1.getMessageTextColor() != 0) {
                int messageTextColor = dialogStyleV1.getMessageTextColor();
                this.mMessageTextColor = messageTextColor;
                TextView textView2 = this.mMessageTextView;
                if (textView2 != null) {
                    textView2.setTextColor(messageTextColor);
                }
            }
            if (dialogStyleV1.getMessageTextSize() > 0) {
                int messageTextSize = dialogStyleV1.getMessageTextSize();
                this.mMessageTextSize = messageTextSize;
                TextView textView3 = this.mMessageTextView;
                if (textView3 != null) {
                    textView3.setTextSize(1, messageTextSize);
                }
            }
            if (!TextUtils.isEmpty(dialogStyleV1.getFirstButtonText())) {
                this.mFirstButtonText = dialogStyleV1.getFirstButtonText();
            }
            if (!TextUtils.isEmpty(dialogStyleV1.getSecondButtonText())) {
                this.mSecondButtonText = dialogStyleV1.getSecondButtonText();
            }
            if (!TextUtils.isEmpty(dialogStyleV1.getThirdButtonText())) {
                this.mThirdButtonText = dialogStyleV1.getThirdButtonText();
            }
            if (dialogStyleV1.getBackgroundColor() != 0) {
                int backgroundColor = dialogStyleV1.getBackgroundColor();
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
            if (dialogStyleV1.getFirstButtonColor() != 0) {
                this.mFirstButtonColor = dialogStyleV1.getFirstButtonColor();
            }
            if (dialogStyleV1.getFirstButtonTextColor() != 0) {
                this.mFirstButtonTextColor = dialogStyleV1.getFirstButtonTextColor();
            }
            if (dialogStyleV1.getSecondButtonColor() != 0) {
                this.mSecondButtonColor = dialogStyleV1.getSecondButtonColor();
            }
            if (dialogStyleV1.getSecondButtonTextColor() != 0) {
                this.mSecondButtonTextColor = dialogStyleV1.getSecondButtonTextColor();
            }
            if (dialogStyleV1.getThirdButtonColor() != 0) {
                this.mThirdButtonColor = dialogStyleV1.getThirdButtonColor();
            }
            if (dialogStyleV1.getThirdButtonTextColor() != 0) {
                this.mThirdButtonTextColor = dialogStyleV1.getThirdButtonTextColor();
            }
            addButton();
            if (dialogStyleV1.getRadius() >= 0) {
                int radius = dialogStyleV1.getRadius();
                this.mRadius = radius;
                RoundedRelativeLayout roundedRelativeLayout2 = this.mDialogLayout;
                if (roundedRelativeLayout2 != null) {
                    roundedRelativeLayout2.setCornerRadius(DisplayUtil.dpToPx(this.mContext, radius));
                    return;
                }
                return;
            }
            return;
        }
        setAdSize(250, 0);
    }

    public void setMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mMessageText = str;
        TextView textView = this.mMessageTextView;
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void initAdView() {
        try {
            if (this.mAdView != null) {
                return;
            }
            if (this.mAdFrameLayout == null) {
                this.mAdFrameLayout = new FrameLayout(this.mContext);
                this.mAdFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            }
            this.mAdView = new DialogAdView(this.mContext, this.mSlotId);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DisplayUtil.dpToPx(this.mContext, this.mAdWidth), DisplayUtil.dpToPx(this.mContext, this.mAdHeight));
            layoutParams.gravity = 1;
            this.mAdView.setLayoutParams(layoutParams);
            this.mAdFrameLayout.addView(this.mAdView);
            this.mAdView.setAdListener(new DialogAdView.AdListener() { // from class: com.gomfactory.adpie.sdk.DialogAdV1.2
                @Override // com.gomfactory.adpie.sdk.dialog.DialogAdView.AdListener
                public void onAdShown() {
                }

                @Override // com.gomfactory.adpie.sdk.dialog.DialogAdView.AdListener
                public void onAdLoaded() {
                    AdPieLog.d(DialogAdV1.TAG, DialogAdV1.this.mSlotId + ":::onAdLoaded");
                    if (DialogAdV1.this.mDialogAdListener != null) {
                        DialogAdV1.this.mDialogAdListener.onAdLoaded();
                    }
                }

                @Override // com.gomfactory.adpie.sdk.dialog.DialogAdView.AdListener
                public void onAdFailedToLoad(int i) {
                    AdPieLog.d(DialogAdV1.TAG, DialogAdV1.this.mSlotId + ":::onAdFailedToLoad:::" + i);
                    if (DialogAdV1.this.mDialogAdListener != null) {
                        DialogAdV1.this.mDialogAdListener.onAdFailedToLoad(i);
                    }
                    if (DialogAdV1.this.mAdFrameLayout != null) {
                        DialogAdV1.this.mAdFrameLayout.setVisibility(8);
                    }
                }

                @Override // com.gomfactory.adpie.sdk.dialog.DialogAdView.AdListener
                public void onAdClicked() {
                    AdPieLog.d(DialogAdV1.TAG, DialogAdV1.this.mSlotId + ":::onAdClicked");
                    if (DialogAdV1.this.mDialogAdListener != null) {
                        DialogAdV1.this.mDialogAdListener.onAdClicked();
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    private void releaseAdView() {
        try {
            DialogAdView dialogAdView = this.mAdView;
            if (dialogAdView != null) {
                this.mAdFrameLayout.removeView(dialogAdView);
                this.mAdView.destroy();
                this.mAdView = null;
            }
        } catch (Exception unused) {
        }
    }

    public void loadAd() {
        if (this.mAdView == null) {
            initAdView();
        }
        DialogAdView dialogAdView = this.mAdView;
        if (dialogAdView == null || dialogAdView.isLoaded()) {
            return;
        }
        this.mAdView.load();
    }

    public void loadAd(TargetingData targetingData) {
        if (this.mAdView == null) {
            initAdView();
        }
        DialogAdView dialogAdView = this.mAdView;
        if (dialogAdView == null || dialogAdView.isLoaded()) {
            return;
        }
        this.mAdView.load(targetingData);
    }

    public void destroy() {
        dismiss();
        releaseAdView();
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
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.gomfactory.adpie.sdk.DialogAdV1.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            DialogAdV1.this.dismiss();
                            if (DialogAdV1.this.mDialogAdListener != null) {
                                DialogAdV1.this.mDialogAdListener.onFirstButtonClicked();
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
                    button2.setOnClickListener(new View.OnClickListener() { // from class: com.gomfactory.adpie.sdk.DialogAdV1.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            DialogAdV1.this.dismiss();
                            if (DialogAdV1.this.mDialogAdListener != null) {
                                DialogAdV1.this.mDialogAdListener.onSecondButtonClicked();
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
                    button3.setOnClickListener(new View.OnClickListener() { // from class: com.gomfactory.adpie.sdk.DialogAdV1.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            DialogAdV1.this.dismiss();
                            if (DialogAdV1.this.mDialogAdListener != null) {
                                DialogAdV1.this.mDialogAdListener.onThirdButtonClicked();
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
