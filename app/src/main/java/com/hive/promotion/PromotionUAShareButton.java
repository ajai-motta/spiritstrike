package com.hive.promotion;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageButton;
import com.hive.promotion.PromotionUAShareDialog;
import com.hive.ui.Resource;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PromotionUAShareButton.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0005R\u001a\u0010\u000f\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/hive/promotion/PromotionUAShareButton;", "Landroidx/appcompat/widget/AppCompatImageButton;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getContext$hive_promotion_release", "()Landroid/content/Context;", "setContext$hive_promotion_release", "type", "Lcom/hive/promotion/PromotionUAShareDialog$SnsType;", "getType$hive_promotion_release", "()Lcom/hive/promotion/PromotionUAShareDialog$SnsType;", "setType$hive_promotion_release", "(Lcom/hive/promotion/PromotionUAShareDialog$SnsType;)V", "buttonSNSType", "getButtonSNSType", "setButtonSNSType", "getSNSDrawable", "Landroid/graphics/drawable/Drawable;", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromotionUAShareButton extends AppCompatImageButton {
    private Context context;
    private PromotionUAShareDialog.SnsType type;

    /* JADX INFO: compiled from: PromotionUAShareButton.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PromotionUAShareDialog.SnsType.values().length];
            try {
                iArr[PromotionUAShareDialog.SnsType.KAKAO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PromotionUAShareDialog.SnsType.LINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PromotionUAShareDialog.SnsType.FACEBOOK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PromotionUAShareDialog.SnsType.WHATSAPP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PromotionUAShareDialog.SnsType.MESSENGER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PromotionUAShareDialog.SnsType.WECHAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PromotionUAShareDialog.SnsType.URL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PromotionUAShareDialog.SnsType.SMS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PromotionUAShareDialog.SnsType.X.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[PromotionUAShareDialog.SnsType.TELEGRAM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[PromotionUAShareDialog.SnsType.DEFAULT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: getContext$hive_promotion_release, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    public final void setContext$hive_promotion_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public final PromotionUAShareDialog.SnsType getType$hive_promotion_release() {
        return this.type;
    }

    public final void setType$hive_promotion_release(PromotionUAShareDialog.SnsType snsType) {
        Intrinsics.checkNotNullParameter(snsType, "<set-?>");
        this.type = snsType;
    }

    /* JADX INFO: renamed from: getButtonSNSType, reason: from getter */
    public final PromotionUAShareDialog.SnsType getType() {
        return this.type;
    }

    public final void setButtonSNSType(PromotionUAShareDialog.SnsType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        setImageDrawable(getSNSDrawable(type));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionUAShareButton(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.type = PromotionUAShareDialog.SnsType.URL;
        this.context = context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionUAShareButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.type = PromotionUAShareDialog.SnsType.URL;
        this.context = context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionUAShareButton(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.type = PromotionUAShareDialog.SnsType.URL;
        this.context = context;
    }

    private final Drawable getSNSDrawable(PromotionUAShareDialog.SnsType type) {
        int drawableId;
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                drawableId = Resource.INSTANCE.getDrawableId(this.context, "promotion_ua_share_btn_kakao");
                break;
            case 2:
                drawableId = Resource.INSTANCE.getDrawableId(this.context, "promotion_ua_share_btn_line");
                break;
            case 3:
                drawableId = Resource.INSTANCE.getDrawableId(this.context, "promotion_ua_share_btn_facebook");
                break;
            case 4:
                drawableId = Resource.INSTANCE.getDrawableId(this.context, "promotion_ua_share_btn_whatsapp");
                break;
            case 5:
                drawableId = Resource.INSTANCE.getDrawableId(this.context, "promotion_ua_share_btn_messenger");
                break;
            case 6:
                drawableId = Resource.INSTANCE.getDrawableId(this.context, "promotion_ua_share_btn_wechat");
                break;
            case 7:
                drawableId = Resource.INSTANCE.getDrawableId(this.context, "promotion_ua_share_btn_url");
                break;
            case 8:
                drawableId = Resource.INSTANCE.getDrawableId(this.context, "promotion_ua_share_btn_sms");
                break;
            case 9:
                drawableId = Resource.INSTANCE.getDrawableId(this.context, "promotion_ua_share_btn_x");
                break;
            case 10:
                drawableId = Resource.INSTANCE.getDrawableId(this.context, "promotion_ua_share_btn_telegram");
                break;
            case 11:
                drawableId = -1;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (drawableId > 0) {
            return AppCompatResources.getDrawable(this.context, drawableId);
        }
        return null;
    }
}
