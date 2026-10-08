package com.hive.promotion;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.webkit.internal.AssetHelper;
import com.facebook.appevents.UserDataStore;
import com.google.firebase.messaging.Constants;
import com.hive.HiveActivity;
import com.hive.analytics.AnalyticsImpl;
import com.hive.analytics.provider.AnalyticsProviderAdapter;
import com.hive.core.Configuration;
import com.hive.core.ExtentionsKt;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.authv4.provider.ProviderFacebook;
import com.hive.ui.Resource;
import com.hive.ui.Util;
import com.hive.ui.effect.TouchEffectKt;
import com.hive.ui.view.HiveAnimationButton;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PromotionUAShareDialog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 12\u00020\u00012\u00020\u0002:\u000201B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u001dH\u0002J\u0018\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0002J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u000eH\u0002J\b\u0010*\u001a\u00020\u001dH\u0002J\b\u0010+\u001a\u00020\u001dH\u0002J\b\u0010,\u001a\u00020\u001dH\u0002J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u000eH\u0002J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u000eH\u0002J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001a\u0010\u0011¨\u00062"}, d2 = {"Lcom/hive/promotion/PromotionUAShareDialog;", "Landroid/app/Dialog;", "Landroid/view/View$OnClickListener;", "activity", "Landroid/app/Activity;", "inviteMessage", "", "inviteLink", "isIdentifier", "", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Z)V", "snsTypeQueue", "Ljava/util/Queue;", "Lcom/hive/promotion/PromotionUAShareDialog$SnsType;", "installSnsTypeList", "getInstallSnsTypeList", "()Ljava/util/Queue;", "installSnsTypeList$delegate", "Lkotlin/Lazy;", "unsupportedUAShareTypeList", "Ljava/util/ArrayList;", "getUnsupportedUAShareTypeList", "()Ljava/util/ArrayList;", "unsupportedUAShareTypeList$delegate", "filteredInstallSnsTypeList", "getFilteredInstallSnsTypeList", "filteredInstallSnsTypeList$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "init", "setBottomBodyMargin", "targetTopMarginSize", "", "targetLeftMarginSize", "onClick", "v", "Landroid/view/View;", "sendText", "snsType", "shareFacebook", "copyClipBoard", "sendSms", "getInviteLink", "getInviteLinkAppendIdentifier", "getInviteString", "SnsType", k.M, "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromotionUAShareDialog extends Dialog implements View.OnClickListener {
    private final Activity activity;

    /* JADX INFO: renamed from: filteredInstallSnsTypeList$delegate, reason: from kotlin metadata */
    private final Lazy filteredInstallSnsTypeList;

    /* JADX INFO: renamed from: installSnsTypeList$delegate, reason: from kotlin metadata */
    private final Lazy installSnsTypeList;
    private final String inviteLink;
    private final String inviteMessage;
    private final boolean isIdentifier;
    private Queue<SnsType> snsTypeQueue;

    /* JADX INFO: renamed from: unsupportedUAShareTypeList$delegate, reason: from kotlin metadata */
    private final Lazy unsupportedUAShareTypeList;
    private static final int REQUEST_CODE_SEND_TEXT = 1626;
    private static final int REQUEST_CODE_SEND_SMS = 1627;

    /* JADX INFO: compiled from: PromotionUAShareDialog.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SnsType.values().length];
            try {
                iArr[SnsType.KAKAO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SnsType.LINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SnsType.WHATSAPP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SnsType.MESSENGER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SnsType.WECHAT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SnsType.X.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SnsType.TELEGRAM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SnsType.FACEBOOK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[SnsType.URL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[SnsType.SMS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[SnsType.DEFAULT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ PromotionUAShareDialog(Activity activity, String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, str, str2, (i & 8) != 0 ? true : z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionUAShareDialog(Activity activity, String inviteMessage, String inviteLink, boolean z) {
        super(activity, android.R.style.Theme.Translucent.NoTitleBar.Fullscreen);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(inviteMessage, "inviteMessage");
        Intrinsics.checkNotNullParameter(inviteLink, "inviteLink");
        this.activity = activity;
        this.inviteMessage = inviteMessage;
        this.inviteLink = inviteLink;
        this.isIdentifier = z;
        this.installSnsTypeList = LazyKt.lazy(new Function0() { // from class: com.hive.promotion.PromotionUAShareDialog$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PromotionUAShareDialog.installSnsTypeList_delegate$lambda$2(this.f$0);
            }
        });
        this.unsupportedUAShareTypeList = LazyKt.lazy(new Function0() { // from class: com.hive.promotion.PromotionUAShareDialog$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PromotionUAShareDialog.unsupportedUAShareTypeList_delegate$lambda$7();
            }
        });
        this.filteredInstallSnsTypeList = LazyKt.lazy(new Function0() { // from class: com.hive.promotion.PromotionUAShareDialog$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PromotionUAShareDialog.filteredInstallSnsTypeList_delegate$lambda$10(this.f$0);
            }
        });
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.addFlags(2);
        }
        Window window3 = getWindow();
        WindowManager.LayoutParams attributes = window3 != null ? window3.getAttributes() : null;
        if (attributes != null) {
            attributes.dimAmount = 0.8f;
        }
        Window window4 = getWindow();
        if (window4 != null) {
            window4.setAttributes(attributes);
        }
    }

    private final Queue<SnsType> getInstallSnsTypeList() {
        return (Queue) this.installSnsTypeList.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PriorityQueue installSnsTypeList_delegate$lambda$2(PromotionUAShareDialog promotionUAShareDialog) {
        PriorityQueue priorityQueue = new PriorityQueue();
        PackageManager packageManager = promotionUAShareDialog.activity.getPackageManager();
        for (SnsType snsType : SnsType.values()) {
            try {
                if (packageManager.getLaunchIntentForPackage(snsType.getPackage()) != null) {
                    priorityQueue.add(snsType);
                }
            } catch (Exception unused) {
            }
        }
        priorityQueue.add(SnsType.URL);
        priorityQueue.add(SnsType.SMS);
        return priorityQueue;
    }

    private final ArrayList<SnsType> getUnsupportedUAShareTypeList() {
        return (ArrayList) this.unsupportedUAShareTypeList.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList unsupportedUAShareTypeList_delegate$lambda$7() {
        Object objM7415constructorimpl;
        ArrayList arrayList = new ArrayList();
        List<String> unsupportedUAShareType = Configuration.INSTANCE.getUnsupportedUAShareType();
        if (unsupportedUAShareType != null) {
            for (String str : unsupportedUAShareType) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM7415constructorimpl = Result.m7415constructorimpl(Boolean.valueOf(arrayList.add(SnsType.valueOf(str))));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
                if (thM7418exceptionOrNullimpl != null) {
                    LoggerImpl.INSTANCE.d("[PromotionUAShareDialog] Failed enumValueOf(" + str + ")\n" + thM7418exceptionOrNullimpl.getMessage());
                }
            }
        }
        return arrayList;
    }

    private final Queue<SnsType> getFilteredInstallSnsTypeList() {
        return (Queue) this.filteredInstallSnsTypeList.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinkedList filteredInstallSnsTypeList_delegate$lambda$10(PromotionUAShareDialog promotionUAShareDialog) {
        LinkedList linkedList = new LinkedList();
        for (SnsType snsType : promotionUAShareDialog.getInstallSnsTypeList()) {
            if (!promotionUAShareDialog.getUnsupportedUAShareTypeList().contains(snsType)) {
                linkedList.offer(snsType);
            }
        }
        return linkedList;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: PromotionUAShareDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u001d\b\u0002\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0005R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0018"}, d2 = {"Lcom/hive/promotion/PromotionUAShareDialog$SnsType;", "", "value", "Lkotlin/Pair;", "", "", "<init>", "(Ljava/lang/String;ILkotlin/Pair;)V", "getValue", "()Lkotlin/Pair;", "DEFAULT", "SMS", "URL", "KAKAO", "LINE", "WHATSAPP", "FACEBOOK", "MESSENGER", "WECHAT", "X", "TELEGRAM", "getPackage", "getIdentifier", k.M, "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SnsType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SnsType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final Pair<String, Integer> value;
        public static final SnsType DEFAULT = new SnsType("DEFAULT", 0, new Pair("DEFAULT", 10));
        public static final SnsType SMS = new SnsType("SMS", 1, new Pair("SMS", 13));
        public static final SnsType URL = new SnsType("URL", 2, new Pair("URL", 14));
        public static final SnsType KAKAO = new SnsType("KAKAO", 3, new Pair("com.kakao.talk", 20));
        public static final SnsType LINE = new SnsType("LINE", 4, new Pair("jp.naver.line.android", 21));
        public static final SnsType WHATSAPP = new SnsType("WHATSAPP", 5, new Pair("com.whatsapp", 22));
        public static final SnsType FACEBOOK = new SnsType("FACEBOOK", 6, new Pair("com.facebook.katana", 23));
        public static final SnsType MESSENGER = new SnsType("MESSENGER", 7, new Pair("com.facebook.orca", 24));
        public static final SnsType WECHAT = new SnsType("WECHAT", 8, new Pair("com.tencent.mm", 25));
        public static final SnsType X = new SnsType("X", 9, new Pair("com.twitter.android", 26));
        public static final SnsType TELEGRAM = new SnsType("TELEGRAM", 10, new Pair("org.telegram.messenger", 27));

        private static final /* synthetic */ SnsType[] $values() {
            return new SnsType[]{DEFAULT, SMS, URL, KAKAO, LINE, WHATSAPP, FACEBOOK, MESSENGER, WECHAT, X, TELEGRAM};
        }

        public static EnumEntries<SnsType> getEntries() {
            return $ENTRIES;
        }

        private SnsType(String str, int i, Pair pair) {
            this.value = pair;
        }

        public final Pair<String, Integer> getValue() {
            return this.value;
        }

        static {
            SnsType[] snsTypeArr$values = $values();
            $VALUES = snsTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(snsTypeArr$values);
            INSTANCE = new Companion(null);
        }

        /* JADX INFO: compiled from: PromotionUAShareDialog.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/hive/promotion/PromotionUAShareDialog$SnsType$Companion;", "", "<init>", "()V", "getEnum", "Lcom/hive/promotion/PromotionUAShareDialog$SnsType;", "value", "", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final SnsType getEnum(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                for (SnsType snsType : SnsType.values()) {
                    if (Intrinsics.areEqual(value, snsType.getPackage())) {
                        return snsType;
                    }
                }
                return SnsType.URL;
            }
        }

        public final String getPackage() {
            return this.value.getFirst();
        }

        public final int getIdentifier() {
            return this.value.getSecond().intValue();
        }

        public static SnsType valueOf(String str) {
            return (SnsType) Enum.valueOf(SnsType.class, str);
        }

        public static SnsType[] values() {
            return (SnsType[]) $VALUES.clone();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        Util.INSTANCE.hideSystemUI(getWindow());
    }

    private final void init() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        SnsType snsTypeRemove;
        Queue<SnsType> filteredInstallSnsTypeList = getFilteredInstallSnsTypeList();
        this.snsTypeQueue = filteredInstallSnsTypeList;
        int size = filteredInstallSnsTypeList != null ? filteredInstallSnsTypeList.size() : 0;
        boolean z = this.activity.getResources().getBoolean(R.bool.com_hive_sdk_ui_is_tablet);
        boolean z2 = this.activity.getResources().getBoolean(R.bool.com_hive_sdk_ui_is_portrait);
        setContentView(Resource.INSTANCE.getLayoutId(this.activity, "promotion_ua_dialog"));
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(Resource.INSTANCE.getViewId(this.activity, "promotion_ua_root"));
        ((TextView) findViewById(Resource.INSTANCE.getViewId(this.activity, "promotion_ua_share_textview_share"))).setText(Resource.INSTANCE.getString("hive_promotion_share_title"));
        ((HiveAnimationButton) findViewById(Resource.INSTANCE.getViewId(this.activity, "promotion_ua_share_btn_close_image"))).setOnClickedListener(new HiveAnimationButton.OnClickedListener() { // from class: com.hive.promotion.PromotionUAShareDialog.init.1
            @Override // com.hive.ui.view.HiveAnimationButton.OnClickedListener
            public void onClick() {
                PromotionUAShareDialog.this.dismiss();
            }
        });
        LinearLayout linearLayout = (LinearLayout) findViewById(Resource.INSTANCE.getViewId(this.activity, "promotion_ua_share_bottom_body_row1"));
        linearLayout.removeAllViews();
        LinearLayout linearLayout2 = (LinearLayout) findViewById(Resource.INSTANCE.getViewId(this.activity, "promotion_ua_share_bottom_body_row2"));
        linearLayout2.removeAllViews();
        LinearLayout linearLayout3 = (LinearLayout) findViewById(Resource.INSTANCE.getViewId(this.activity, "promotion_ua_share_bottom_body_row3"));
        linearLayout3.removeAllViews();
        for (int i6 = 0; i6 < size; i6++) {
            View viewInflate = View.inflate(this.activity, R.layout.promotion_ua_dialog_btn, null);
            Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.FrameLayout");
            FrameLayout frameLayout = (FrameLayout) viewInflate;
            PromotionUAShareButton promotionUAShareButton = (PromotionUAShareButton) frameLayout.findViewById(Resource.INSTANCE.getViewId(this.activity, "promotion_ua_share_button"));
            Queue<SnsType> queue = this.snsTypeQueue;
            if (queue != null && (snsTypeRemove = queue.remove()) != null) {
                promotionUAShareButton.setButtonSNSType(snsTypeRemove);
            }
            Intrinsics.checkNotNull(promotionUAShareButton);
            TouchEffectKt.setTouchEffect(promotionUAShareButton, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.promotion.PromotionUAShareDialog$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PromotionUAShareDialog.init$lambda$12(this.f$0, (View) obj);
                }
            } : null);
            if (z) {
                if (i6 >= 4) {
                    linearLayout2.addView(frameLayout);
                    linearLayout2.setVisibility(0);
                } else {
                    linearLayout.addView(frameLayout);
                }
                i3 = 4;
            } else if (z2) {
                if (i6 >= 6) {
                    linearLayout3.addView(frameLayout);
                    linearLayout3.setVisibility(0);
                } else if (i6 >= 3) {
                    linearLayout2.addView(frameLayout);
                    linearLayout2.setVisibility(0);
                } else {
                    linearLayout.addView(frameLayout);
                }
                i3 = 3;
            } else {
                if (i6 >= 5) {
                    linearLayout2.addView(frameLayout);
                    linearLayout2.setVisibility(0);
                } else {
                    linearLayout.addView(frameLayout);
                }
                i3 = 5;
            }
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            if (size >= 3) {
                if (i6 % i3 != 0 && (i5 = R.dimen.com_hive_sdk_ua_share_3btn_left_margin) > 0) {
                    layoutParams2.setMargins(this.activity.getResources().getDimensionPixelSize(i5), 0, 0, 0);
                }
            } else if (i6 % 2 != 0 && (i4 = R.dimen.com_hive_sdk_ua_share_2btn_left_margin) > 0) {
                layoutParams2.setMargins(this.activity.getResources().getDimensionPixelSize(i4), 0, 0, 0);
            }
        }
        ViewGroup.LayoutParams layoutParams3 = constraintLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        int i7 = R.dimen.com_hive_sdk_ua_share_btn_area_top_margin;
        int dimensionPixelSize = i7 > 0 ? this.activity.getResources().getDimensionPixelSize(i7) : 0;
        if (size >= 3 && (i2 = R.dimen.com_hive_sdk_ua_share_3btn_area_left_margin) > 0) {
            setBottomBodyMargin(dimensionPixelSize, this.activity.getResources().getDimensionPixelSize(i2));
        }
        if (size < 5 || z) {
            if (size < 4 || (i = R.dimen.com_hive_sdk_ua_share_popup_4btn_width) <= 0) {
                return;
            }
            layoutParams4.width = this.activity.getResources().getDimensionPixelSize(i);
            return;
        }
        int i8 = R.dimen.com_hive_sdk_ua_share_popup_5btn_width;
        if (i8 > 0) {
            layoutParams4.width = this.activity.getResources().getDimensionPixelSize(i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$12(PromotionUAShareDialog promotionUAShareDialog, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        promotionUAShareDialog.onClick(it);
        return Unit.INSTANCE;
    }

    private final void setBottomBodyMargin(int targetTopMarginSize, int targetLeftMarginSize) {
        int i = 1;
        while (i < 4) {
            ViewGroup.LayoutParams layoutParams = ((LinearLayout) findViewById(Resource.INSTANCE.getViewId(this.activity, "promotion_ua_share_bottom_body_row" + i))).getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams).setMargins(targetLeftMarginSize, i == 1 ? 0 : targetTopMarginSize, 0, 0);
            i++;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        SnsType type = ((PromotionUAShareButton) v).getType();
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                sendText(type);
                break;
            case 8:
                shareFacebook();
                break;
            case 9:
                copyClipBoard();
                break;
            case 10:
                sendSms();
                break;
            case 11:
                break;
            default:
                sendText(type);
                break;
        }
        if (type != SnsType.DEFAULT) {
            AnalyticsImpl.INSTANCE.sendStandardEvent(AnalyticsProviderAdapter.StandardEventType.SHARE, MapsKt.mapOf(TuplesKt.to("sns_type", type.getValue().getSecond())));
        }
    }

    private final void sendText(SnsType snsType) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", getInviteString(snsType));
        intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
        String str = snsType.getPackage();
        if (str.length() != 0) {
            intent.setPackage(str);
        }
        String string = Resource.INSTANCE.getString("hive_promotion_share_selectapp");
        Activity recentActivity = HiveActivity.INSTANCE.getRecentActivity();
        Intent intentCreateChooser = Intent.createChooser(intent, string);
        Intrinsics.checkNotNullExpressionValue(intentCreateChooser, "createChooser(...)");
        ExtentionsKt.startActivityForResultCatching$default(recentActivity, intentCreateChooser, REQUEST_CODE_SEND_TEXT, null, 4, null);
    }

    private final void shareFacebook() {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = ProviderFacebook.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof ProviderFacebook)) {
            hiveModule = null;
        }
        ProviderFacebook providerFacebook = (ProviderFacebook) (hiveModule instanceof ProviderFacebook ? hiveModule : null);
        if (providerFacebook != null) {
            Activity activity = this.activity;
            Uri uri = Uri.parse(getInviteLink(SnsType.FACEBOOK));
            Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
            providerFacebook.shareDialog(activity, uri, this.inviteMessage);
        }
    }

    private final void copyClipBoard() {
        Object systemService = this.activity.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(Constants.ScionAnalytics.PARAM_LABEL, getInviteString(SnsType.URL)));
        Toast.makeText(this.activity, Resource.INSTANCE.getString("hive_promotion_share_clipboard"), 0).show();
    }

    private final void sendSms() {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("sms:"));
        intent.putExtra("sms_body", getInviteString(SnsType.SMS));
        ExtentionsKt.startActivityForResultCatching$default(HiveActivity.INSTANCE.getRecentActivity(), intent, REQUEST_CODE_SEND_SMS, null, 4, null);
    }

    private final String getInviteLink(SnsType snsType) {
        return this.isIdentifier ? getInviteLinkAppendIdentifier(snsType) : this.inviteLink;
    }

    private final String getInviteLinkAppendIdentifier(SnsType snsType) {
        Uri.Builder builderBuildUpon = Uri.parse(this.inviteLink).buildUpon();
        builderBuildUpon.appendQueryParameter(UserDataStore.STATE, String.valueOf(snsType.getIdentifier()));
        String string = builderBuildUpon.build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final String getInviteString(SnsType snsType) {
        StringBuilder sb = new StringBuilder();
        if (this.inviteMessage.length() == 0) {
            sb.append(getInviteLink(snsType));
        } else {
            sb.append(this.inviteMessage);
            sb.append("\n");
            sb.append(getInviteLink(snsType));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
