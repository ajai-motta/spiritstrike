package com.gomfactory.adpie.sdk;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.gomfactory.adpie.sdk.AdView;
import com.gomfactory.adpie.sdk.common.Constants;
import com.gomfactory.adpie.sdk.dialog.DialogStyle;
import com.gomfactory.adpie.sdk.dialog.RoundedRelativeLayout;
import com.gomfactory.adpie.sdk.ui.progressbar.SpinningLoaderView;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import com.gomfactory.adpie.sdk.util.ClickThroughUtil;
import com.gomfactory.adpie.sdk.util.DisplayUtil;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class DialogAd extends Dialog {
    public static final String TAG = "DialogAd";
    private ImageView defaultImageView;
    private FrameLayout mAdFrameLayout;
    private int mAdHeight;
    private AdView mAdView;
    private int mAdWidth;
    private int mBackgroundColor;
    public int mButtonCount;
    public int mButtonTextSize;
    private String mClickUrl;
    private LinearLayout mContentLayout;
    private Context mContext;
    private int mDefaultImageResId;
    private DialogAdListener mDialogAdListener;
    private RoundedRelativeLayout mDialogLayout;
    private int mFirstButtonColor;
    private String mFirstButtonText;
    private int mFirstButtonTextColor;
    private boolean mIsLoadingBar;
    private String mMessageText;
    private int mMessageTextColor;
    private int mMessageTextSize;
    private SpinningLoaderView mProgressbar;
    private int mRadius;
    private int mSecondButtonColor;
    private String mSecondButtonText;
    private int mSecondButtonTextColor;
    private String mSlotId;
    private int mThirdButtonColor;
    private String mThirdButtonText;
    private int mThirdButtonTextColor;
    private TextView messageTextView;

    public interface DialogAdListener {
        void onAdClicked();

        void onAdFailedToLoad(int i);

        void onAdLoaded();

        void onFirstButtonClicked();

        void onSecondButtonClicked();

        void onThirdButtonClicked();
    }

    public DialogAd(Context context, DialogStyle dialogStyle) {
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
        this.mIsLoadingBar = true;
        this.mContext = context;
        setDialogStyle(dialogStyle);
    }

    public DialogAd(Context context, DialogStyle dialogStyle, String str) {
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
        this.mIsLoadingBar = true;
        this.mContext = context;
        this.mSlotId = str;
        setDialogStyle(dialogStyle);
    }

    protected DialogAd(Context context, int i) {
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
        this.mIsLoadingBar = true;
        this.mContext = context;
    }

    protected DialogAd(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
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
        this.mIsLoadingBar = true;
        this.mContext = context;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
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
        this.mAdView = new AdView(this.mContext);
        this.mAdFrameLayout = new FrameLayout(this.mContext);
        this.mAdFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DisplayUtil.dpToPx(this.mContext, this.mAdWidth), DisplayUtil.dpToPx(this.mContext, this.mAdHeight));
        layoutParams.gravity = 1;
        if (this.mDefaultImageResId > 0) {
            ImageView imageView = new ImageView(this.mContext);
            this.defaultImageView = imageView;
            imageView.setLayoutParams(layoutParams);
            this.defaultImageView.setAdjustViewBounds(true);
            this.defaultImageView.setVisibility(8);
            this.defaultImageView.setImageResource(this.mDefaultImageResId);
            this.defaultImageView.setOnClickListener(new View.OnClickListener() { // from class: com.gomfactory.adpie.sdk.DialogAd.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!ClickThroughUtil.isValidClick()) {
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.d(DialogAd.TAG, ":::clickEvent::: " + DialogAd.this.mClickUrl + " -> block");
                            return;
                        }
                        return;
                    }
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(DialogAd.TAG, ":::clickEvent::: " + DialogAd.this.mClickUrl);
                    }
                    ClickThroughUtil.goToBrowser(DialogAd.this.mContext, DialogAd.this.mClickUrl);
                }
            });
            this.mAdFrameLayout.addView(this.defaultImageView);
        }
        this.mAdView.setLayoutParams(layoutParams);
        this.mAdFrameLayout.addView(this.mAdView);
        if (this.mIsLoadingBar) {
            this.mProgressbar = new SpinningLoaderView(this.mContext);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(DisplayUtil.dpToPx(this.mContext, 48), DisplayUtil.dpToPx(this.mContext, 48));
            layoutParams2.gravity = 17;
            this.mProgressbar.setLayoutParams(layoutParams2);
            this.mProgressbar.setVisibility(8);
            this.mAdFrameLayout.addView(this.mProgressbar);
        }
        linearLayout.addView(this.mAdFrameLayout);
        this.mAdView.setAdListener(new AdView.AdListener() { // from class: com.gomfactory.adpie.sdk.DialogAd.2
            @Override // com.gomfactory.adpie.sdk.AdView.AdListener
            public void onAdLoaded() {
                AdPieLog.d(DialogAd.TAG, DialogAd.this.mSlotId + ":::onAdLoaded");
                if (DialogAd.this.mDialogAdListener != null) {
                    DialogAd.this.mDialogAdListener.onAdLoaded();
                }
                if (DialogAd.this.mProgressbar != null) {
                    DialogAd.this.mProgressbar.setVisibility(8);
                }
            }

            @Override // com.gomfactory.adpie.sdk.AdView.AdListener
            public void onAdFailedToLoad(int i) {
                AdPieLog.d(DialogAd.TAG, DialogAd.this.mSlotId + ":::onAdFailedToLoad:::" + i);
                if (DialogAd.this.mDialogAdListener != null) {
                    DialogAd.this.mDialogAdListener.onAdFailedToLoad(i);
                }
                if (DialogAd.this.mProgressbar != null) {
                    DialogAd.this.mProgressbar.setVisibility(8);
                }
                if (DialogAd.this.defaultImageView != null) {
                    DialogAd.this.defaultImageView.setVisibility(0);
                }
            }

            @Override // com.gomfactory.adpie.sdk.AdView.AdListener
            public void onAdClicked() {
                AdPieLog.d(DialogAd.TAG, DialogAd.this.mSlotId + ":::onAdClicked");
                if (DialogAd.this.mDialogAdListener != null) {
                    DialogAd.this.mDialogAdListener.onAdClicked();
                }
            }
        });
        LinearLayout linearLayout2 = new LinearLayout(this.mContext);
        this.mContentLayout = linearLayout2;
        linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mContentLayout.setBackgroundColor(this.mBackgroundColor);
        this.messageTextView = new TextView(this.mContext);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(-1, -2));
        layoutParams3.topMargin = DisplayUtil.dpToPx(this.mContext, 20);
        layoutParams3.bottomMargin = DisplayUtil.dpToPx(this.mContext, 20);
        this.messageTextView.setGravity(17);
        this.messageTextView.setLayoutParams(layoutParams3);
        this.messageTextView.setTextSize(1, this.mMessageTextSize);
        this.messageTextView.setTextColor(this.mMessageTextColor);
        this.messageTextView.setText(this.mMessageText);
        this.mContentLayout.addView(this.messageTextView);
        linearLayout.addView(this.mContentLayout);
        LinearLayout linearLayout3 = new LinearLayout(this.mContext);
        linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout3.setOrientation(0);
        linearLayout3.setWeightSum(this.mButtonCount);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.weight = 1.0f;
        for (int i = 0; i < this.mButtonCount; i++) {
            if (i > 0) {
                View view = new View(this.mContext);
                view.setLayoutParams(new ViewGroup.LayoutParams(DisplayUtil.dpToPx(this.mContext, 2), -1));
                view.setBackgroundColor(this.mBackgroundColor);
                linearLayout3.addView(view);
            }
            if (i == 0) {
                Button button = new Button(this.mContext);
                button.setLayoutParams(layoutParams4);
                button.setOnClickListener(new View.OnClickListener() { // from class: com.gomfactory.adpie.sdk.DialogAd.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        DialogAd.this.dismiss();
                        if (DialogAd.this.mDialogAdListener != null) {
                            DialogAd.this.mDialogAdListener.onFirstButtonClicked();
                        }
                    }
                });
                button.setText(this.mFirstButtonText);
                button.setTextSize(1, this.mButtonTextSize);
                button.setBackgroundColor(this.mFirstButtonColor);
                button.setTextColor(this.mFirstButtonTextColor);
                linearLayout3.addView(button);
            } else if (i == 1) {
                Button button2 = new Button(this.mContext);
                button2.setLayoutParams(layoutParams4);
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.gomfactory.adpie.sdk.DialogAd.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        DialogAd.this.dismiss();
                        if (DialogAd.this.mDialogAdListener != null) {
                            DialogAd.this.mDialogAdListener.onSecondButtonClicked();
                        }
                    }
                });
                button2.setText(this.mSecondButtonText);
                button2.setTextSize(1, this.mButtonTextSize);
                button2.setBackgroundColor(this.mSecondButtonColor);
                button2.setTextColor(this.mSecondButtonTextColor);
                linearLayout3.addView(button2);
            } else if (i == 2) {
                Button button3 = new Button(this.mContext);
                button3.setLayoutParams(layoutParams4);
                button3.setOnClickListener(new View.OnClickListener() { // from class: com.gomfactory.adpie.sdk.DialogAd.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        DialogAd.this.dismiss();
                        if (DialogAd.this.mDialogAdListener != null) {
                            DialogAd.this.mDialogAdListener.onThirdButtonClicked();
                        }
                    }
                });
                button3.setText(this.mThirdButtonText);
                button3.setTextSize(1, this.mButtonTextSize);
                button3.setBackgroundColor(this.mThirdButtonColor);
                button3.setTextColor(this.mThirdButtonTextColor);
                linearLayout3.addView(button3);
            }
        }
        linearLayout.addView(linearLayout3);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        AdPieLog.d(TAG, this.mSlotId + ":::show");
        if (this.mAdWidth > 0 && this.mAdHeight > 0) {
            if (getContext().getResources().getConfiguration().orientation == 1) {
                FrameLayout frameLayout = this.mAdFrameLayout;
                if (frameLayout != null) {
                    frameLayout.setVisibility(0);
                }
                if (this.mIsLoadingBar) {
                    SpinningLoaderView spinningLoaderView = this.mProgressbar;
                    if (spinningLoaderView != null) {
                        spinningLoaderView.setVisibility(0);
                    }
                    ImageView imageView = this.defaultImageView;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                } else {
                    SpinningLoaderView spinningLoaderView2 = this.mProgressbar;
                    if (spinningLoaderView2 != null) {
                        spinningLoaderView2.setVisibility(8);
                    }
                    ImageView imageView2 = this.defaultImageView;
                    if (imageView2 != null) {
                        imageView2.setVisibility(0);
                    }
                }
                AdView adView = this.mAdView;
                if (adView != null) {
                    adView.setSlotId(this.mSlotId);
                    this.mAdView.load();
                }
            } else {
                FrameLayout frameLayout2 = this.mAdFrameLayout;
                if (frameLayout2 != null) {
                    frameLayout2.setVisibility(8);
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
        super.dismiss();
        AdPieLog.d(TAG, this.mSlotId + ":::dismiss");
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

    private void setDialogStyle(DialogStyle dialogStyle) {
        if (dialogStyle != null) {
            AdPieLog.d(TAG, "dialogStyle : " + dialogStyle.toString());
            if (dialogStyle.getAdSize() != 0 && dialogStyle.getAdSize() == 1) {
                setAdSize(AnimationConstants.DefaultDurationMillis, 250, dialogStyle.getDefaultImageResId(), dialogStyle.getDefaultImageClickUrl());
            } else {
                setAdSize(250, 250, dialogStyle.getDefaultImageResId(), dialogStyle.getDefaultImageClickUrl());
            }
            if (dialogStyle.getButtonCount() == 1 || dialogStyle.getButtonCount() == 2 || dialogStyle.getButtonCount() == 3) {
                this.mButtonCount = dialogStyle.getButtonCount();
            }
            if (dialogStyle.getButtonTextSize() > 0) {
                this.mButtonTextSize = dialogStyle.getButtonTextSize();
            }
            if (!TextUtils.isEmpty(dialogStyle.getMessageText())) {
                this.mMessageText = dialogStyle.getMessageText();
            }
            if (dialogStyle.getMessageTextColor() != 0) {
                this.mMessageTextColor = dialogStyle.getMessageTextColor();
            }
            if (dialogStyle.getMessageTextSize() > 0) {
                this.mMessageTextSize = dialogStyle.getMessageTextSize();
            }
            if (!TextUtils.isEmpty(dialogStyle.getFirstButtonText())) {
                this.mFirstButtonText = dialogStyle.getFirstButtonText();
            }
            if (!TextUtils.isEmpty(dialogStyle.getSecondButtonText())) {
                this.mSecondButtonText = dialogStyle.getSecondButtonText();
            }
            if (!TextUtils.isEmpty(dialogStyle.getThirdButtonText())) {
                this.mThirdButtonText = dialogStyle.getThirdButtonText();
            }
            if (dialogStyle.getBackgroundColor() != 0) {
                this.mBackgroundColor = dialogStyle.getBackgroundColor();
            }
            if (dialogStyle.getFirstButtonColor() != 0) {
                this.mFirstButtonColor = dialogStyle.getFirstButtonColor();
            }
            if (dialogStyle.getFirstButtonTextColor() != 0) {
                this.mFirstButtonTextColor = dialogStyle.getFirstButtonTextColor();
            }
            if (dialogStyle.getSecondButtonColor() != 0) {
                this.mSecondButtonColor = dialogStyle.getSecondButtonColor();
            }
            if (dialogStyle.getSecondButtonTextColor() != 0) {
                this.mSecondButtonTextColor = dialogStyle.getSecondButtonTextColor();
            }
            if (dialogStyle.getThirdButtonColor() != 0) {
                this.mThirdButtonColor = dialogStyle.getThirdButtonColor();
            }
            if (dialogStyle.getThirdButtonTextColor() != 0) {
                this.mThirdButtonTextColor = dialogStyle.getThirdButtonTextColor();
            }
            if (dialogStyle.getRadius() >= 0) {
                this.mRadius = dialogStyle.getRadius();
                return;
            }
            return;
        }
        setAdSize(250, 0, 0, null);
    }

    public void setMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mMessageText = str;
        TextView textView = this.messageTextView;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
