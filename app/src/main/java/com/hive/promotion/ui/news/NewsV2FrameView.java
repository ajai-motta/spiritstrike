package com.hive.promotion.ui.news;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.customview.view.AbsSavedState;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.hive.core.webview.HiveWebView;
import com.hive.promotion.R;
import com.hive.promotion.ui.RoundedCornerView;
import com.hive.promotion.ui.news.NewsV2Activity;
import com.hive.promotion.ui.news.NewsV2FrameView;
import com.hive.promotion.ui.news.NewsV2View;
import com.hive.ui.Resource;
import com.hive.ui.Util;
import com.hive.ui.view.HiveAnimationButton;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: NewsV2FrameView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001*B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0003J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\u001a\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u001bH\u0002J\b\u0010%\u001a\u00020\u001bH\u0002J\n\u0010&\u001a\u0004\u0018\u00010'H\u0014J\u0012\u0010(\u001a\u00020\u001b2\b\u0010)\u001a\u0004\u0018\u00010'H\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2FrameView;", "Lcom/hive/promotion/ui/news/NewsV2View;", "activity", "Landroid/app/Activity;", "isForced", "", "url", "", "basePostData", "Lorg/json/JSONObject;", "showBackButton", "<init>", "(Landroid/app/Activity;ZLjava/lang/String;Lorg/json/JSONObject;Z)V", "()Z", "setForced", "(Z)V", "roundedCornerView", "Lcom/hive/promotion/ui/RoundedCornerView;", "isOnForce", "forceTextView", "Landroidx/appcompat/widget/AppCompatTextView;", "forceBtn", "Landroidx/appcompat/widget/AppCompatImageView;", "bottomLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "backBtn", "onCreateView", "", "initBackButton", "initForceLayout", "updateView", "isViewInside", "v", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "startForceOnAnimation", "startForceOffAnimation", "onSaveInstanceState", "Landroid/os/Parcelable;", "onRestoreInstanceState", "state", "SavedState", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewsV2FrameView extends NewsV2View {
    private AppCompatImageView backBtn;
    private ConstraintLayout bottomLayout;
    private AppCompatImageView forceBtn;
    private AppCompatTextView forceTextView;
    private boolean isForced;
    private boolean isOnForce;
    private RoundedCornerView roundedCornerView;

    /* JADX INFO: renamed from: isForced, reason: from getter */
    public final boolean getIsForced() {
        return this.isForced;
    }

    public final void setForced(boolean z) {
        this.isForced = z;
    }

    public /* synthetic */ NewsV2FrameView(Activity activity, boolean z, String str, JSONObject jSONObject, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, (i & 2) != 0 ? true : z, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? null : jSONObject, (i & 16) != 0 ? true : z2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewsV2FrameView(Activity activity, boolean z, String url, JSONObject jSONObject, boolean z2) {
        super(activity, url, jSONObject, z2);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        this.isForced = z;
        setViewType(NewsV2View.ViewType.FrameView);
        initialize();
    }

    @Override // com.hive.promotion.ui.news.NewsV2View
    public void onCreateView() {
        View viewInflate = View.inflate(getActivity(), R.layout.news_frame_view, this);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) viewInflate;
        this.roundedCornerView = (RoundedCornerView) viewGroup.findViewById(R.id.rounded_corner);
        this.bottomLayout = (ConstraintLayout) viewGroup.findViewById(R.id.contentLayout_bottom);
        setWebView((HiveWebView) viewGroup.findViewById(R.id.webView));
        this.forceTextView = (AppCompatTextView) findViewById(R.id.forceTextView);
        this.forceBtn = (AppCompatImageView) findViewById(R.id.forceBtn);
        initBackButton();
        initForceLayout();
        RoundedCornerView roundedCornerView = null;
        if (Util.INSTANCE.isPortrait(getActivity())) {
            RoundedCornerView roundedCornerView2 = this.roundedCornerView;
            if (roundedCornerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roundedCornerView");
            } else {
                roundedCornerView = roundedCornerView2;
            }
            roundedCornerView.setScaledCornerSize(1, 439.0f, 8.5f);
            return;
        }
        RoundedCornerView roundedCornerView3 = this.roundedCornerView;
        if (roundedCornerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roundedCornerView");
        } else {
            roundedCornerView = roundedCornerView3;
        }
        roundedCornerView.setScaledCornerSize(0, 456.0f, 8.5f);
    }

    private final void initBackButton() {
        View viewFindViewById = getRootView().findViewById(R.id.back_imageView);
        HiveAnimationButton hiveAnimationButton = (HiveAnimationButton) viewFindViewById;
        hiveAnimationButton.setOnClickedListener(new HiveAnimationButton.OnClickedListener() { // from class: com.hive.promotion.ui.news.NewsV2FrameView$initBackButton$1$1
            @Override // com.hive.ui.view.HiveAnimationButton.OnClickedListener
            public void onClick() {
                this.this$0.onBackPressed();
            }
        });
        hiveAnimationButton.setVisibility(getShowBackButton() ? 0 : 4);
        this.backBtn = (AppCompatImageView) viewFindViewById;
    }

    private final void initForceLayout() {
        ConstraintLayout constraintLayout = this.bottomLayout;
        AppCompatTextView appCompatTextView = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomLayout");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(this.isForced ? 4 : 0);
        ConstraintLayout constraintLayout2 = this.bottomLayout;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomLayout");
            constraintLayout2 = null;
        }
        final ViewTreeObserver viewTreeObserver = constraintLayout2.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.hive.promotion.ui.news.NewsV2FrameView.initForceLayout.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    }
                    if (this.getIsForced()) {
                        return;
                    }
                    RoundedCornerView roundedCornerView = this.roundedCornerView;
                    ConstraintLayout constraintLayout3 = null;
                    if (roundedCornerView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("roundedCornerView");
                        roundedCornerView = null;
                    }
                    ConstraintLayout constraintLayout4 = this.bottomLayout;
                    if (constraintLayout4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bottomLayout");
                    } else {
                        constraintLayout3 = constraintLayout4;
                    }
                    roundedCornerView.setPadding(0, 0, 0, constraintLayout3.getMeasuredHeight());
                }
            });
        }
        float f = (Util.INSTANCE.getScreenSize(getActivity()).y * Util.INSTANCE.getFloat(getActivity(), "promotion_news_force_textView_height_percent")) / getResources().getDisplayMetrics().scaledDensity;
        AppCompatTextView appCompatTextView2 = this.forceTextView;
        if (appCompatTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forceTextView");
            appCompatTextView2 = null;
        }
        appCompatTextView2.setTextSize(f);
        AppCompatTextView appCompatTextView3 = this.forceTextView;
        if (appCompatTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forceTextView");
        } else {
            appCompatTextView = appCompatTextView3;
        }
        appCompatTextView.setText(Resource.INSTANCE.getString("hive_promotion_style_banner"));
        ((ConstraintLayout) findViewById(R.id.forceLayout)).setOnTouchListener(new View.OnTouchListener() { // from class: com.hive.promotion.ui.news.NewsV2FrameView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return NewsV2FrameView.initForceLayout$lambda$2(this.f$0, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initForceLayout$lambda$2(final NewsV2FrameView newsV2FrameView, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    return false;
                }
                Intrinsics.checkNotNull(motionEvent);
                if (newsV2FrameView.isViewInside(view, motionEvent)) {
                    if (!newsV2FrameView.isOnForce) {
                        newsV2FrameView.isOnForce = true;
                        newsV2FrameView.startForceOnAnimation();
                    }
                } else if (newsV2FrameView.isOnForce) {
                    newsV2FrameView.isOnForce = false;
                    newsV2FrameView.startForceOffAnimation();
                }
            } else if (newsV2FrameView.isOnForce) {
                newsV2FrameView.isOnForce = false;
                newsV2FrameView.startForceOffAnimation();
                Intrinsics.checkNotNull(motionEvent);
                if (newsV2FrameView.isViewInside(view, motionEvent)) {
                    newsV2FrameView.postDelayed(new Runnable() { // from class: com.hive.promotion.ui.news.NewsV2FrameView$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            NewsV2FrameView.initForceLayout$lambda$2$lambda$1(this.f$0);
                        }
                    }, 100L);
                }
            }
        } else if (!newsV2FrameView.isOnForce) {
            newsV2FrameView.isOnForce = true;
            newsV2FrameView.startForceOnAnimation();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initForceLayout$lambda$2$lambda$1(NewsV2FrameView newsV2FrameView) {
        if (newsV2FrameView.getActivity() instanceof NewsV2Activity) {
            NewsV2Activity.ForceListener forceListener = NewsV2Activity.INSTANCE.getForceListener();
            if (forceListener != null) {
                forceListener.onClickedForceButton(((NewsV2Activity) newsV2FrameView.getActivity()).getData().getType());
            }
            Activity activity = newsV2FrameView.getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.hive.promotion.ui.news.NewsV2Activity");
            ((NewsV2Activity) activity).finish();
        }
    }

    private final void updateView() {
        initBackButton();
        initForceLayout();
    }

    private final boolean isViewInside(View v, MotionEvent e) {
        return v != null && e.getX() >= 0.0f && e.getY() >= 0.0f && e.getX() <= ((float) v.getMeasuredWidth()) && e.getY() <= ((float) v.getMeasuredHeight());
    }

    private final void startForceOnAnimation() {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompatCreate = AnimatedVectorDrawableCompat.create(getActivity(), Resource.INSTANCE.getDrawableId(getActivity(), "promotion_news_force_from_off_to_on"));
        AppCompatTextView appCompatTextView = null;
        if (animatedVectorDrawableCompatCreate != null) {
            AppCompatImageView appCompatImageView = this.forceBtn;
            if (appCompatImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forceBtn");
                appCompatImageView = null;
            }
            appCompatImageView.setImageDrawable(animatedVectorDrawableCompatCreate);
            animatedVectorDrawableCompatCreate.start();
        }
        TypedArray typedArrayObtainStyledAttributes = getActivity().getTheme().obtainStyledAttributes(R.styleable.NewsColorStyle);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.NewsColorStyle_newsOnColor, -16777216);
        AppCompatTextView appCompatTextView2 = this.forceTextView;
        if (appCompatTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forceTextView");
        } else {
            appCompatTextView = appCompatTextView2;
        }
        appCompatTextView.setTextColor(color);
    }

    private final void startForceOffAnimation() {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompatCreate = AnimatedVectorDrawableCompat.create(getActivity(), Resource.INSTANCE.getDrawableId(getActivity(), "promotion_news_force_from_on_to_off"));
        AppCompatTextView appCompatTextView = null;
        if (animatedVectorDrawableCompatCreate != null) {
            AppCompatImageView appCompatImageView = this.forceBtn;
            if (appCompatImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forceBtn");
                appCompatImageView = null;
            }
            appCompatImageView.setImageDrawable(animatedVectorDrawableCompatCreate);
            animatedVectorDrawableCompatCreate.start();
        }
        TypedArray typedArrayObtainStyledAttributes = getActivity().getTheme().obtainStyledAttributes(R.styleable.NewsColorStyle);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.NewsColorStyle_newsOffColor, -16777216);
        AppCompatTextView appCompatTextView2 = this.forceTextView;
        if (appCompatTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forceTextView");
        } else {
            appCompatTextView = appCompatTextView2;
        }
        appCompatTextView.setTextColor(color);
    }

    @Override // com.hive.promotion.ui.news.NewsV2View, android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            return parcelableOnSaveInstanceState;
        }
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.setForced(String.valueOf(this.isForced));
        return savedState;
    }

    @Override // com.hive.promotion.ui.news.NewsV2View, android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof SavedState) {
            SavedState savedState = (SavedState) state;
            super.onRestoreInstanceState(savedState.getSuperState());
            String isForced = savedState.getIsForced();
            this.isForced = isForced != null ? Boolean.parseBoolean(isForced) : true;
            updateView();
            return;
        }
        super.onRestoreInstanceState(state);
    }

    /* JADX INFO: compiled from: NewsV2FrameView.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2FrameView$SavedState;", "Landroidx/customview/view/AbsSavedState;", "superState", "Landroid/os/Parcelable;", "<init>", "(Landroid/os/Parcelable;)V", "source", "Landroid/os/Parcel;", "loader", "Ljava/lang/ClassLoader;", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V", "isForced", "", "()Ljava/lang/String;", "setForced", "(Ljava/lang/String;)V", "writeToParcel", "", "dest", "flags", "", k.M, "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SavedState extends AbsSavedState {
        private String isForced;
        public static final Parcelable.ClassLoaderCreator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.hive.promotion.ui.news.NewsV2FrameView$SavedState$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public NewsV2FrameView.SavedState createFromParcel(Parcel source, ClassLoader loader) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(loader, "loader");
                return new NewsV2FrameView.SavedState(source, loader);
            }

            @Override // android.os.Parcelable.Creator
            public NewsV2FrameView.SavedState createFromParcel(Parcel source) {
                Intrinsics.checkNotNullParameter(source, "source");
                return new NewsV2FrameView.SavedState(source, null);
            }

            @Override // android.os.Parcelable.Creator
            public NewsV2FrameView.SavedState[] newArray(int size) {
                return newArray(size);
            }
        };

        /* JADX INFO: renamed from: isForced, reason: from getter */
        public final String getIsForced() {
            return this.isForced;
        }

        public final void setForced(String str) {
            this.isForced = str;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable superState) {
            super(superState);
            Intrinsics.checkNotNullParameter(superState, "superState");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel source, ClassLoader classLoader) {
            super(source, classLoader);
            Intrinsics.checkNotNullParameter(source, "source");
            this.isForced = source.readString();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            super.writeToParcel(dest, flags);
            dest.writeString(this.isForced);
        }
    }
}
