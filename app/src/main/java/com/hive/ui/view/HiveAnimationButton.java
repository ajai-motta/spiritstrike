package com.hive.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.core.Logger;
import com.hive.ui.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HiveAnimationButton.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002*+B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0003J\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0010J\u001a\u0010!\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u001eH\u0002J\b\u0010'\u001a\u00020\u001eH\u0002J\u000e\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0005R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006,"}, d2 = {"Lcom/hive/ui/view/HiveAnimationButton;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getContext$hive_ui_release", "()Landroid/content/Context;", "setContext$hive_ui_release", "onClickedListener", "Lcom/hive/ui/view/HiveAnimationButton$OnClickedListener;", "isOnClicked", "", "actionUpEventType", "Lcom/hive/ui/view/HiveAnimationButton$ActionUpAnimationType;", "onAnimationResourcesId", "getOnAnimationResourcesId", "()I", "setOnAnimationResourcesId", "(I)V", "offAnimationResourcesId", "getOffAnimationResourcesId", "setOffAnimationResourcesId", "onCreateView", "", "setOnClickedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "isViewInside", "v", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "onAnimation", "offAnimation", "setActionUpEventType", "type", "ActionUpAnimationType", "OnClickedListener", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveAnimationButton extends AppCompatImageView {
    private ActionUpAnimationType actionUpEventType;
    private Context context;
    private boolean isOnClicked;
    private int offAnimationResourcesId;
    private int onAnimationResourcesId;
    private OnClickedListener onClickedListener;

    /* JADX INFO: compiled from: HiveAnimationButton.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/hive/ui/view/HiveAnimationButton$OnClickedListener;", "", "onClick", "", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OnClickedListener {
        void onClick();
    }

    /* JADX INFO: renamed from: getContext$hive_ui_release, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    public final void setContext$hive_ui_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: HiveAnimationButton.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/hive/ui/view/HiveAnimationButton$ActionUpAnimationType;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_USE_OFF_ANIMATION", "USE_OFF_ANIMATION", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ActionUpAnimationType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ActionUpAnimationType[] $VALUES;
        public static final ActionUpAnimationType NOT_USE_OFF_ANIMATION = new ActionUpAnimationType("NOT_USE_OFF_ANIMATION", 0);
        public static final ActionUpAnimationType USE_OFF_ANIMATION = new ActionUpAnimationType("USE_OFF_ANIMATION", 1);

        private static final /* synthetic */ ActionUpAnimationType[] $values() {
            return new ActionUpAnimationType[]{NOT_USE_OFF_ANIMATION, USE_OFF_ANIMATION};
        }

        public static EnumEntries<ActionUpAnimationType> getEntries() {
            return $ENTRIES;
        }

        private ActionUpAnimationType(String str, int i) {
        }

        static {
            ActionUpAnimationType[] actionUpAnimationTypeArr$values = $values();
            $VALUES = actionUpAnimationTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(actionUpAnimationTypeArr$values);
        }

        public static ActionUpAnimationType valueOf(String str) {
            return (ActionUpAnimationType) Enum.valueOf(ActionUpAnimationType.class, str);
        }

        public static ActionUpAnimationType[] values() {
            return (ActionUpAnimationType[]) $VALUES.clone();
        }
    }

    public final int getOnAnimationResourcesId() {
        return this.onAnimationResourcesId;
    }

    public final void setOnAnimationResourcesId(int i) {
        this.onAnimationResourcesId = i;
    }

    public final int getOffAnimationResourcesId() {
        return this.offAnimationResourcesId;
    }

    public final void setOffAnimationResourcesId(int i) {
        this.offAnimationResourcesId = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiveAnimationButton(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.actionUpEventType = ActionUpAnimationType.NOT_USE_OFF_ANIMATION;
        this.context = context;
        onCreateView(null, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiveAnimationButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.actionUpEventType = ActionUpAnimationType.NOT_USE_OFF_ANIMATION;
        this.context = context;
        onCreateView(attrs, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiveAnimationButton(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.actionUpEventType = ActionUpAnimationType.NOT_USE_OFF_ANIMATION;
        this.context = context;
        onCreateView(attrs, i);
    }

    private final void onCreateView(AttributeSet attrs, int defStyleAttr) {
        try {
            TypedArray typedArrayObtainStyledAttributes = this.context.obtainStyledAttributes(attrs, R.styleable.HiveAnimationButton, defStyleAttr, 0);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            this.onAnimationResourcesId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.HiveAnimationButton_OnAnimation, R.drawable.hive_default_popup_btn_close_up_dark);
            this.offAnimationResourcesId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.HiveAnimationButton_OffAnimation, R.drawable.hive_default_popup_btn_close_down_dark);
            typedArrayObtainStyledAttributes.recycle();
        } catch (Exception e) {
            Logger.INSTANCE.w("[HiveAnimationButton] onCreateView() \ne: " + e.getMessage());
        }
        offAnimation();
        setOnTouchListener(new View.OnTouchListener() { // from class: com.hive.ui.view.HiveAnimationButton$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return HiveAnimationButton.onCreateView$lambda$0(this.f$0, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$0(HiveAnimationButton hiveAnimationButton, View view, MotionEvent event) {
        OnClickedListener onClickedListener;
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    return false;
                }
                if (hiveAnimationButton.isViewInside(view, event)) {
                    if (!hiveAnimationButton.isOnClicked) {
                        hiveAnimationButton.isOnClicked = true;
                        hiveAnimationButton.onAnimation();
                    }
                } else if (hiveAnimationButton.isOnClicked) {
                    hiveAnimationButton.isOnClicked = false;
                    hiveAnimationButton.offAnimation();
                }
            } else if (hiveAnimationButton.isOnClicked) {
                hiveAnimationButton.isOnClicked = false;
                if (hiveAnimationButton.actionUpEventType == ActionUpAnimationType.USE_OFF_ANIMATION) {
                    hiveAnimationButton.offAnimation();
                }
                if (hiveAnimationButton.isViewInside(view, event) && (onClickedListener = hiveAnimationButton.onClickedListener) != null) {
                    onClickedListener.onClick();
                }
            }
        } else if (!hiveAnimationButton.isOnClicked) {
            hiveAnimationButton.isOnClicked = true;
            hiveAnimationButton.onAnimation();
        }
        return true;
    }

    public final void setOnClickedListener(OnClickedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onClickedListener = listener;
    }

    private final boolean isViewInside(View v, MotionEvent e) {
        return v != null && e.getX() >= 0.0f && e.getY() >= 0.0f && e.getX() <= ((float) v.getMeasuredWidth()) && e.getY() <= ((float) v.getMeasuredHeight());
    }

    private final void onAnimation() {
        int i = this.onAnimationResourcesId;
        if (i == 0) {
            Logger.INSTANCE.d("OnAnimation attribute is not set");
            return;
        }
        AnimatedVectorDrawableCompat animatedVectorDrawableCompatCreate = AnimatedVectorDrawableCompat.create(this.context, i);
        if (animatedVectorDrawableCompatCreate != null) {
            setImageDrawable(animatedVectorDrawableCompatCreate);
            animatedVectorDrawableCompatCreate.start();
        }
    }

    private final void offAnimation() {
        int i = this.offAnimationResourcesId;
        if (i == 0) {
            Logger.INSTANCE.d("OffAnimation attribute is not set");
            return;
        }
        AnimatedVectorDrawableCompat animatedVectorDrawableCompatCreate = AnimatedVectorDrawableCompat.create(this.context, i);
        if (animatedVectorDrawableCompatCreate != null) {
            setImageDrawable(animatedVectorDrawableCompatCreate);
            animatedVectorDrawableCompatCreate.start();
        }
    }

    public final void setActionUpEventType(ActionUpAnimationType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.actionUpEventType = type;
    }
}
