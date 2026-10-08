package com.hive.promotion.ui.news;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.ResultAPI;
import com.hive.core.HiveCoreInitializer;
import com.hive.core.Logger;
import com.hive.core.Scheme;
import com.hive.platformhelper.InAppBrowser;
import com.hive.platformhelper.InAppBrowserData;
import com.hive.promotion.R;
import com.hive.promotion.ui.SmoothScrollLinearLayoutManager;
import com.hive.promotion.ui.news.BannerList;
import com.hive.promotion.ui.news.Navigation;
import com.hive.promotion.ui.news.NewsV2TabRecyclerViewAdapter;
import com.hive.promotion.ui.news.NewsV2View;
import com.hive.promotion.ui.util.RecyclerViewDecoration;
import com.hive.ui.Resource;
import com.hive.ui.Util;
import com.hive.ui.common.controller.HiveUiOrientationController;
import com.hive.ui.common.controller.HiveUiOrientationHelper;
import com.hive.ui.view.HiveAnimationButton;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import com.unity3d.services.core.fid.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: NewsV2Activity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0006TUVWXYB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020*H\u0002J\u0010\u0010.\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020,H\u0014J\b\u00101\u001a\u00020*H\u0014J\b\u00102\u001a\u00020*H\u0014J\u0010\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020\u0019H\u0016J\b\u00105\u001a\u00020*H\u0016J\b\u00106\u001a\u00020*H\u0003J\u0010\u00107\u001a\u00020*2\u0006\u00108\u001a\u00020\u001bH\u0002J\u0006\u00109\u001a\u00020\u0019J\u0010\u0010:\u001a\u00020*2\u0006\u00108\u001a\u00020\u001bH\u0002J\b\u0010;\u001a\u00020*H\u0003J4\u0010<\u001a\u00020*2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>2\b\b\u0002\u0010@\u001a\u00020\u00192\b\b\u0002\u0010A\u001a\u00020\u00192\b\b\u0002\u0010B\u001a\u00020>J\u000e\u0010<\u001a\u00020*2\u0006\u0010C\u001a\u00020DJ\u0006\u0010E\u001a\u00020*J\u0006\u0010F\u001a\u00020*J\u000e\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020\u001bJ\u001a\u0010I\u001a\u00020\u00192\b\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010L\u001a\u00020MH\u0002J\b\u0010N\u001a\u00020*H\u0002J\b\u0010O\u001a\u00020*H\u0002J\u000e\u0010P\u001a\u00020*2\u0006\u0010?\u001a\u00020>J\u0010\u0010Q\u001a\u00020*2\u0006\u0010R\u001a\u00020\u001bH\u0016J\b\u0010S\u001a\u00020*H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020$X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006Z"}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2Activity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/hive/ui/common/controller/HiveUiOrientationController;", "<init>", "()V", "data", "Lcom/hive/promotion/ui/news/NewsV2Activity$Data;", "getData", "()Lcom/hive/promotion/ui/news/NewsV2Activity$Data;", "setData", "(Lcom/hive/promotion/ui/news/NewsV2Activity$Data;)V", "frameLayout", "Landroid/widget/FrameLayout;", "fullscreenLayout", "showingView", "Lcom/hive/promotion/ui/news/NewsV2View;", "forceTextView", "Landroidx/appcompat/widget/AppCompatTextView;", "forceBtn", "Landroidx/appcompat/widget/AppCompatImageView;", "closeBtn", "Lcom/hive/ui/view/HiveAnimationButton;", "tabRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isOnForce", "", NewsV2Activity.KEY_PAGE_INDEX, "", "getPageIndex", "()I", "setPageIndex", "(I)V", "currentOrientation", "getCurrentOrientation", "setCurrentOrientation", "orientationHelper", "Lcom/hive/ui/common/controller/HiveUiOrientationHelper;", "getOrientationHelper", "()Lcom/hive/ui/common/controller/HiveUiOrientationHelper;", "setOrientationHelper", "(Lcom/hive/ui/common/controller/HiveUiOrientationHelper;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initState", "restoreState", "onSaveInstanceState", "outState", "onPause", "onDestroy", "onWindowFocusChanged", "hasFocus", "finish", "initForceLayout", "initFragment", FirebaseAnalytics.Param.INDEX, "showOfferwall", "initTabLayout", "initCloseButton", "addView", "viewType", "", "url", "showBackButton", "forced", AdUnitActivity.EXTRA_ORIENTATION, "scheme", "Lcom/hive/core/Scheme;", "removeFrameView", "removeFullscreenView", "changeFragment", "n", "isViewInside", "v", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "startForceOnAnimation", "startForceOffAnimation", "openExternalBrowser", "lockOrientation", "targetOrientation", "unlockOrientation", "Data", k.M, "ForceListener", "ButtonClickedListener", "MenuListener", "OnViewListener", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewsV2Activity extends AppCompatActivity implements HiveUiOrientationController {
    private static final String KEY_ACTIVITY_ORIENTATION = "activityOrientation";
    private static final String KEY_FULLSCREEN_VIEW_ORIENTATION = "fullscreenViewOrientation";
    private static final String KEY_PAGE_INDEX = "pageIndex";
    private static final String KEY_SHOWING_VIEW_TYPE = "showingViewType";
    private static JSONObject basePostData;
    private static ButtonClickedListener buttonClickedListener;
    private static ForceListener forceListener;
    private static ArrayList<Integer> giftPidList;
    private static NewsV2Activity instance;
    private static MenuListener menuListener;
    private static Navigation navigation;
    private static WebChromeClient promotionWebChromeClient;
    public static Function1<? super Scheme, Boolean> schemeEventFunc;
    private static OnViewListener viewListener;
    private HiveAnimationButton closeBtn;
    private int currentOrientation = -99;
    public Data data;
    private AppCompatImageView forceBtn;
    private AppCompatTextView forceTextView;
    private FrameLayout frameLayout;
    private FrameLayout fullscreenLayout;
    private boolean isOnForce;
    public HiveUiOrientationHelper orientationHelper;
    private int pageIndex;
    private NewsV2View showingView;
    private RecyclerView tabRecyclerView;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static ConcurrentHashMap<Integer, BannerList> bannerLists = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Integer, String> downloadBannerList = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: NewsV2Activity.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2Activity$ButtonClickedListener;", "", "onClose", "", "onBanner", ReportUtil.INVENTORY_TYPE_BANNER, "Lcom/hive/promotion/ui/news/BannerList$Banner;", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ButtonClickedListener {
        void onBanner(BannerList.Banner banner);

        void onClose();
    }

    /* JADX INFO: compiled from: NewsV2Activity.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2Activity$ForceListener;", "", "onClickedForceButton", "", "key", "", "getSavedForceTime", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ForceListener {
        String getSavedForceTime(String key);

        void onClickedForceButton(String key);
    }

    /* JADX INFO: compiled from: NewsV2Activity.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2Activity$MenuListener;", "", "getClickedTime", "Lorg/json/JSONObject;", "setClickedTime", "", "data", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface MenuListener {
        JSONObject getClickedTime();

        void setClickedTime(JSONObject data);
    }

    /* JADX INFO: compiled from: NewsV2Activity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2Activity$OnViewListener;", "", "onView", "", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OnViewListener {
        void onView();
    }

    /* JADX INFO: compiled from: NewsV2Activity.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NewsV2View.ViewType.values().length];
            try {
                iArr[NewsV2View.ViewType.FrameView.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NewsV2View.ViewType.FullScreenView.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: compiled from: NewsV2Activity.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2Activity$Data;", "Landroid/os/Parcelable;", "isForced", "", "type", "", "menu", "isPortrait", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Z)V", "()Z", "getType", "()Ljava/lang/String;", "getMenu", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Data implements Parcelable {
        public static final Parcelable.Creator<Data> CREATOR = new Creator();
        private final boolean isForced;
        private final boolean isPortrait;
        private final String menu;
        private final String type;

        /* JADX INFO: compiled from: NewsV2Activity.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Data> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Data createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Data(parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() != 0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Data[] newArray(int i) {
                return new Data[i];
            }
        }

        public static /* synthetic */ Data copy$default(Data data, boolean z, String str, String str2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = data.isForced;
            }
            if ((i & 2) != 0) {
                str = data.type;
            }
            if ((i & 4) != 0) {
                str2 = data.menu;
            }
            if ((i & 8) != 0) {
                z2 = data.isPortrait;
            }
            return data.copy(z, str, str2, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsForced() {
            return this.isForced;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMenu() {
            return this.menu;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsPortrait() {
            return this.isPortrait;
        }

        public final Data copy(boolean isForced, String type, String menu, boolean isPortrait) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new Data(isForced, type, menu, isPortrait);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data)) {
                return false;
            }
            Data data = (Data) other;
            return this.isForced == data.isForced && Intrinsics.areEqual(this.type, data.type) && Intrinsics.areEqual(this.menu, data.menu) && this.isPortrait == data.isPortrait;
        }

        public int hashCode() {
            int iM = ((UByte$$ExternalSyntheticBackport0.m(this.isForced) * 31) + this.type.hashCode()) * 31;
            String str = this.menu;
            return ((iM + (str == null ? 0 : str.hashCode())) * 31) + UByte$$ExternalSyntheticBackport0.m(this.isPortrait);
        }

        public String toString() {
            return "Data(isForced=" + this.isForced + ", type=" + this.type + ", menu=" + this.menu + ", isPortrait=" + this.isPortrait + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(this.isForced ? 1 : 0);
            dest.writeString(this.type);
            dest.writeString(this.menu);
            dest.writeInt(this.isPortrait ? 1 : 0);
        }

        public Data(boolean z, String type, String str, boolean z2) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.isForced = z;
            this.type = type;
            this.menu = str;
            this.isPortrait = z2;
        }

        public final String getMenu() {
            return this.menu;
        }

        public final String getType() {
            return this.type;
        }

        public final boolean isForced() {
            return this.isForced;
        }

        public final boolean isPortrait() {
            return this.isPortrait;
        }
    }

    /* JADX INFO: compiled from: NewsV2Activity.kt */
    @Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010%J\u0010\u00103\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010.J\u0010\u0010:\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u000105J\u0010\u0010A\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010<R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R.\u0010B\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010Cj\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR&\u0010I\u001a\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\n0JX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0011\u0010P\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bP\u0010\u000bR\u001c\u0010Q\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u000e\u0010W\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2Activity$Companion;", "", "<init>", "()V", "value", "Lcom/hive/promotion/ui/news/NewsV2Activity;", "instance", Constants.GET_INSTANCE, "()Lcom/hive/promotion/ui/news/NewsV2Activity;", "isShow", "", "()Z", NotificationCompat.CATEGORY_NAVIGATION, "Lcom/hive/promotion/ui/news/Navigation;", "getNavigation", "()Lcom/hive/promotion/ui/news/Navigation;", "setNavigation", "(Lcom/hive/promotion/ui/news/Navigation;)V", "bannerLists", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/hive/promotion/ui/news/BannerList;", "getBannerLists", "()Ljava/util/concurrent/ConcurrentHashMap;", "setBannerLists", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "downloadBannerList", "", "getDownloadBannerList", "setDownloadBannerList", "basePostData", "Lorg/json/JSONObject;", "getBasePostData", "()Lorg/json/JSONObject;", "setBasePostData", "(Lorg/json/JSONObject;)V", "forceListener", "Lcom/hive/promotion/ui/news/NewsV2Activity$ForceListener;", "getForceListener", "()Lcom/hive/promotion/ui/news/NewsV2Activity$ForceListener;", "setForceListener", "(Lcom/hive/promotion/ui/news/NewsV2Activity$ForceListener;)V", "setOnForceListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "buttonClickedListener", "Lcom/hive/promotion/ui/news/NewsV2Activity$ButtonClickedListener;", "getButtonClickedListener", "()Lcom/hive/promotion/ui/news/NewsV2Activity$ButtonClickedListener;", "setButtonClickedListener", "(Lcom/hive/promotion/ui/news/NewsV2Activity$ButtonClickedListener;)V", "setOnButtonClickedListener", "menuListener", "Lcom/hive/promotion/ui/news/NewsV2Activity$MenuListener;", "getMenuListener", "()Lcom/hive/promotion/ui/news/NewsV2Activity$MenuListener;", "setMenuListener", "(Lcom/hive/promotion/ui/news/NewsV2Activity$MenuListener;)V", "setOnMenuListener", "viewListener", "Lcom/hive/promotion/ui/news/NewsV2Activity$OnViewListener;", "getViewListener", "()Lcom/hive/promotion/ui/news/NewsV2Activity$OnViewListener;", "setViewListener", "(Lcom/hive/promotion/ui/news/NewsV2Activity$OnViewListener;)V", "setOnViewListener", "giftPidList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getGiftPidList", "()Ljava/util/ArrayList;", "setGiftPidList", "(Ljava/util/ArrayList;)V", "schemeEventFunc", "Lkotlin/Function1;", "Lcom/hive/core/Scheme;", "getSchemeEventFunc", "()Lkotlin/jvm/functions/Function1;", "setSchemeEventFunc", "(Lkotlin/jvm/functions/Function1;)V", "isSchemeEventFuncInitialized", "promotionWebChromeClient", "Landroid/webkit/WebChromeClient;", "getPromotionWebChromeClient", "()Landroid/webkit/WebChromeClient;", "setPromotionWebChromeClient", "(Landroid/webkit/WebChromeClient;)V", "KEY_PAGE_INDEX", "KEY_SHOWING_VIEW_TYPE", "KEY_ACTIVITY_ORIENTATION", "KEY_FULLSCREEN_VIEW_ORIENTATION", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NewsV2Activity getInstance() {
            return NewsV2Activity.instance;
        }

        public final boolean isShow() {
            return getInstance() != null;
        }

        public final Navigation getNavigation() {
            return NewsV2Activity.navigation;
        }

        public final void setNavigation(Navigation navigation) {
            NewsV2Activity.navigation = navigation;
        }

        public final ConcurrentHashMap<Integer, BannerList> getBannerLists() {
            return NewsV2Activity.bannerLists;
        }

        public final void setBannerLists(ConcurrentHashMap<Integer, BannerList> concurrentHashMap) {
            Intrinsics.checkNotNullParameter(concurrentHashMap, "<set-?>");
            NewsV2Activity.bannerLists = concurrentHashMap;
        }

        public final ConcurrentHashMap<Integer, String> getDownloadBannerList() {
            return NewsV2Activity.downloadBannerList;
        }

        public final void setDownloadBannerList(ConcurrentHashMap<Integer, String> concurrentHashMap) {
            Intrinsics.checkNotNullParameter(concurrentHashMap, "<set-?>");
            NewsV2Activity.downloadBannerList = concurrentHashMap;
        }

        public final JSONObject getBasePostData() {
            return NewsV2Activity.basePostData;
        }

        public final void setBasePostData(JSONObject jSONObject) {
            NewsV2Activity.basePostData = jSONObject;
        }

        public final ForceListener getForceListener() {
            return NewsV2Activity.forceListener;
        }

        public final void setForceListener(ForceListener forceListener) {
            NewsV2Activity.forceListener = forceListener;
        }

        public final void setOnForceListener(ForceListener listener) {
            if (listener != null) {
                NewsV2Activity.INSTANCE.setForceListener(listener);
            }
        }

        public final ButtonClickedListener getButtonClickedListener() {
            return NewsV2Activity.buttonClickedListener;
        }

        public final void setButtonClickedListener(ButtonClickedListener buttonClickedListener) {
            NewsV2Activity.buttonClickedListener = buttonClickedListener;
        }

        public final void setOnButtonClickedListener(ButtonClickedListener listener) {
            if (listener != null) {
                NewsV2Activity.INSTANCE.setButtonClickedListener(listener);
            }
        }

        public final MenuListener getMenuListener() {
            return NewsV2Activity.menuListener;
        }

        public final void setMenuListener(MenuListener menuListener) {
            NewsV2Activity.menuListener = menuListener;
        }

        public final void setOnMenuListener(MenuListener listener) {
            if (listener != null) {
                NewsV2Activity.INSTANCE.setMenuListener(listener);
            }
        }

        public final OnViewListener getViewListener() {
            return NewsV2Activity.viewListener;
        }

        public final void setViewListener(OnViewListener onViewListener) {
            NewsV2Activity.viewListener = onViewListener;
        }

        public final void setOnViewListener(OnViewListener listener) {
            if (listener != null) {
                NewsV2Activity.INSTANCE.setViewListener(listener);
            }
        }

        public final ArrayList<Integer> getGiftPidList() {
            return NewsV2Activity.giftPidList;
        }

        public final void setGiftPidList(ArrayList<Integer> arrayList) {
            NewsV2Activity.giftPidList = arrayList;
        }

        public final Function1<Scheme, Boolean> getSchemeEventFunc() {
            Function1 function1 = NewsV2Activity.schemeEventFunc;
            if (function1 != null) {
                return function1;
            }
            Intrinsics.throwUninitializedPropertyAccessException("schemeEventFunc");
            return null;
        }

        public final void setSchemeEventFunc(Function1<? super Scheme, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            NewsV2Activity.schemeEventFunc = function1;
        }

        public final boolean isSchemeEventFuncInitialized() {
            return NewsV2Activity.schemeEventFunc != null;
        }

        public final WebChromeClient getPromotionWebChromeClient() {
            return NewsV2Activity.promotionWebChromeClient;
        }

        public final void setPromotionWebChromeClient(WebChromeClient webChromeClient) {
            NewsV2Activity.promotionWebChromeClient = webChromeClient;
        }
    }

    public final Data getData() {
        Data data = this.data;
        if (data != null) {
            return data;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }

    public final void setData(Data data) {
        Intrinsics.checkNotNullParameter(data, "<set-?>");
        this.data = data;
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }

    public final void setPageIndex(int i) {
        this.pageIndex = i;
    }

    public final int getCurrentOrientation() {
        return this.currentOrientation;
    }

    public final void setCurrentOrientation(int i) {
        this.currentOrientation = i;
    }

    public final HiveUiOrientationHelper getOrientationHelper() {
        HiveUiOrientationHelper hiveUiOrientationHelper = this.orientationHelper;
        if (hiveUiOrientationHelper != null) {
            return hiveUiOrientationHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("orientationHelper");
        return null;
    }

    public final void setOrientationHelper(HiveUiOrientationHelper hiveUiOrientationHelper) {
        Intrinsics.checkNotNullParameter(hiveUiOrientationHelper, "<set-?>");
        this.orientationHelper = hiveUiOrientationHelper;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0070  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onCreate(android.os.Bundle r7) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.promotion.ui.news.NewsV2Activity.onCreate(android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$4(NewsV2Activity newsV2Activity, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        NewsV2View newsV2View = newsV2Activity.showingView;
        if (newsV2View == null) {
            List<Fragment> fragments = newsV2Activity.getSupportFragmentManager().getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
            for (Fragment fragment : fragments) {
                if (fragment instanceof NewsV2Fragment) {
                    NewsV2Fragment newsV2Fragment = (NewsV2Fragment) fragment;
                    newsV2Fragment.getBackPressedCallback().setEnabled(newsV2Fragment.isVisible());
                }
            }
            addCallback.setEnabled(false);
            newsV2Activity.getOnBackPressedDispatcher().onBackPressed();
        } else if (newsV2View != null) {
            newsV2View.onBackPressed();
        }
        return Unit.INSTANCE;
    }

    private final void initState() {
        Navigation navigation2;
        ArrayList<Navigation.Menu> menuList;
        String menu = Intrinsics.areEqual(getData().getType(), "notice") ? "fixed_notice" : getData().getMenu();
        if (menu != null && (navigation2 = navigation) != null && (menuList = navigation2.getMenuList()) != null) {
            int size = menuList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (Intrinsics.areEqual(menuList.get(i).getPromotionType(), menu)) {
                    this.pageIndex = i;
                    break;
                }
                i++;
            }
        }
        initFragment(this.pageIndex);
    }

    private final void restoreState(Bundle savedInstanceState) {
        int i = savedInstanceState.getInt(KEY_ACTIVITY_ORIENTATION, -99);
        if (i != -99) {
            lockOrientation(i);
        }
        this.pageIndex = savedInstanceState.getInt(KEY_PAGE_INDEX, 0);
        String string = savedInstanceState.getString(KEY_SHOWING_VIEW_TYPE);
        if (string != null) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[NewsV2View.ViewType.valueOf(string).ordinal()];
            FrameLayout frameLayout = null;
            if (i2 == 1) {
                NewsV2FrameView newsV2FrameView = new NewsV2FrameView(this, false, null, null, false, 30, null);
                newsV2FrameView.setOnButtonClickListener(new NewsV2View.ButtonClickListener() { // from class: com.hive.promotion.ui.news.NewsV2Activity$restoreState$2$frameView$1$1
                    @Override // com.hive.promotion.ui.news.NewsV2View.ButtonClickListener
                    public void onBack() {
                        this.this$0.removeFrameView();
                    }
                });
                newsV2FrameView.onRestoreInstanceState(savedInstanceState);
                this.showingView = newsV2FrameView;
                FrameLayout frameLayout2 = this.frameLayout;
                if (frameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
                } else {
                    frameLayout = frameLayout2;
                }
                frameLayout.addView(newsV2FrameView);
                return;
            }
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            String string2 = savedInstanceState.getString(KEY_FULLSCREEN_VIEW_ORIENTATION);
            if (string2 == null) {
                string2 = "";
            }
            NewsV2FullScreenView newsV2FullScreenView = new NewsV2FullScreenView(this, "", basePostData, true, string2);
            newsV2FullScreenView.setOnButtonClickListener(new NewsV2View.ButtonClickListener() { // from class: com.hive.promotion.ui.news.NewsV2Activity$restoreState$2$fullScreenView$1$1
                @Override // com.hive.promotion.ui.news.NewsV2View.ButtonClickListener
                public void onBack() {
                    this.this$0.removeFullscreenView();
                }
            });
            newsV2FullScreenView.onRestoreInstanceState(savedInstanceState);
            this.showingView = newsV2FullScreenView;
            FrameLayout frameLayout3 = this.fullscreenLayout;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fullscreenLayout");
            } else {
                frameLayout = frameLayout3;
            }
            frameLayout.addView(newsV2FullScreenView);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putInt(KEY_PAGE_INDEX, this.pageIndex);
        NewsV2View newsV2View = this.showingView;
        if (newsV2View != null) {
            newsV2View.onSaveInstanceState(outState);
            outState.putString(KEY_SHOWING_VIEW_TYPE, newsV2View.getViewType().getValue());
            outState.putInt(KEY_ACTIVITY_ORIENTATION, this.currentOrientation);
            if (newsV2View instanceof NewsV2FullScreenView) {
                outState.putString(KEY_FULLSCREEN_VIEW_ORIENTATION, ((NewsV2FullScreenView) newsV2View).getOrientation());
            }
        }
        super.onSaveInstanceState(outState);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        Object objM7415constructorimpl;
        Logger.INSTANCE.i("[NewsV2Activity] onPause()");
        try {
            Result.Companion companion = Result.INSTANCE;
            RecyclerView recyclerView = this.tabRecyclerView;
            Unit unit = null;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabRecyclerView");
                recyclerView = null;
            }
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.hive.promotion.ui.news.NewsV2TabRecyclerViewAdapter");
            JSONObject clickedTimeList = ((NewsV2TabRecyclerViewAdapter) adapter).getClickedTimeList();
            MenuListener menuListener2 = menuListener;
            if (menuListener2 != null) {
                menuListener2.setClickedTime(clickedTimeList);
                unit = Unit.INSTANCE;
            }
            objM7415constructorimpl = Result.m7415constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7418exceptionOrNullimpl(objM7415constructorimpl) != null) {
            Logger.INSTANCE.w("NewsV2Activity", "Failed to save clickedTime");
        }
        super.onPause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        FrameLayout frameLayout = this.frameLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
            frameLayout = null;
        }
        frameLayout.removeAllViews();
        ButtonClickedListener buttonClickedListener2 = buttonClickedListener;
        if (buttonClickedListener2 != null) {
            buttonClickedListener2.onClose();
        }
        instance = null;
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        Window window;
        View decorView;
        super.onWindowFocusChanged(hasFocus);
        if (!hasFocus || (window = getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        Util.INSTANCE.setSystemUiVisibility(decorView);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        getOrientationHelper().destroy();
    }

    private final void initForceLayout() {
        final FrameLayout frameLayout = (FrameLayout) findViewById(R.id.contentViewLayout);
        final ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.tabLayout);
        final ConstraintLayout constraintLayout2 = (ConstraintLayout) findViewById(R.id.contentLayout_bottom);
        constraintLayout2.setVisibility(getData().isForced() ? 4 : 0);
        final ViewTreeObserver viewTreeObserver = constraintLayout2.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.hive.promotion.ui.news.NewsV2Activity.initForceLayout.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    }
                    if (this.getData().isForced()) {
                        return;
                    }
                    frameLayout.setPadding(0, 0, 0, constraintLayout2.getMeasuredHeight());
                    if (Util.INSTANCE.isPortrait(this)) {
                        return;
                    }
                    constraintLayout.setPadding(0, 0, 0, constraintLayout2.getMeasuredHeight());
                }
            });
        }
        float f = (Util.INSTANCE.getScreenSize(this).y * Util.INSTANCE.getFloat(this, "promotion_news_force_textView_height_percent")) / getResources().getDisplayMetrics().scaledDensity;
        AppCompatTextView appCompatTextView = this.forceTextView;
        AppCompatTextView appCompatTextView2 = null;
        if (appCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forceTextView");
            appCompatTextView = null;
        }
        appCompatTextView.setTextSize(f);
        AppCompatTextView appCompatTextView3 = this.forceTextView;
        if (appCompatTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forceTextView");
        } else {
            appCompatTextView2 = appCompatTextView3;
        }
        appCompatTextView2.setText(Resource.INSTANCE.getString("hive_promotion_style_banner"));
        ((ConstraintLayout) findViewById(R.id.forceLayout)).setOnTouchListener(new View.OnTouchListener() { // from class: com.hive.promotion.ui.news.NewsV2Activity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return NewsV2Activity.initForceLayout$lambda$16(this.f$0, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initForceLayout$lambda$16(final NewsV2Activity newsV2Activity, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    return false;
                }
                Intrinsics.checkNotNull(motionEvent);
                if (newsV2Activity.isViewInside(view, motionEvent)) {
                    if (!newsV2Activity.isOnForce) {
                        newsV2Activity.isOnForce = true;
                        newsV2Activity.startForceOnAnimation();
                    }
                } else if (newsV2Activity.isOnForce) {
                    newsV2Activity.isOnForce = false;
                    newsV2Activity.startForceOffAnimation();
                }
            } else if (newsV2Activity.isOnForce) {
                newsV2Activity.isOnForce = false;
                Intrinsics.checkNotNull(motionEvent);
                if (newsV2Activity.isViewInside(view, motionEvent)) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.promotion.ui.news.NewsV2Activity$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            NewsV2Activity.initForceLayout$lambda$16$lambda$15(this.f$0);
                        }
                    });
                }
            }
        } else if (!newsV2Activity.isOnForce) {
            newsV2Activity.isOnForce = true;
            newsV2Activity.startForceOnAnimation();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initForceLayout$lambda$16$lambda$15(NewsV2Activity newsV2Activity) {
        ForceListener forceListener2 = forceListener;
        if (forceListener2 != null) {
            forceListener2.onClickedForceButton(newsV2Activity.getData().getType());
        }
        newsV2Activity.finish();
    }

    private final void initFragment(int index) {
        ArrayList<Navigation.Menu> menuList;
        String str;
        ArrayList<NewsV2Fragment> arrayList = new ArrayList();
        Navigation navigation2 = navigation;
        if (navigation2 != null && (menuList = navigation2.getMenuList()) != null) {
            for (Navigation.Menu menu : menuList) {
                Navigation.Menu.Contents contents = menu.getContents();
                String area = contents != null ? contents.getArea() : null;
                if (Intrinsics.areEqual(area, "native")) {
                    Navigation.Menu.Contents contents2 = menu.getContents();
                    String accept = contents2 != null ? contents2.getAccept() : null;
                    if (accept != null) {
                        int iHashCode = accept.hashCode();
                        if (iHashCode != -1396342996) {
                            if (iHashCode == -1039690024) {
                                str = "notice";
                            } else if (iHashCode == 1945574950) {
                                str = "offerwall";
                            }
                            accept.equals(str);
                        } else if (accept.equals(ReportUtil.INVENTORY_TYPE_BANNER)) {
                            BannerList bannerList = bannerLists.get(Integer.valueOf(menu.getId()));
                            arrayList.add(new NewsV2BannerFragment(menu, bannerList != null ? bannerList.getBannerList() : null));
                        }
                    }
                } else if (Intrinsics.areEqual(area, "webview")) {
                    arrayList.add(new NewsV2WebFragment(menu, basePostData));
                }
            }
        }
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
        for (NewsV2Fragment newsV2Fragment : arrayList) {
            fragmentTransactionBeginTransaction.add(R.id.contentViewLayout, newsV2Fragment);
            fragmentTransactionBeginTransaction.hide(newsV2Fragment);
        }
        fragmentTransactionBeginTransaction.show((Fragment) arrayList.get(index));
        fragmentTransactionBeginTransaction.commit();
    }

    public final boolean showOfferwall() {
        ArrayList<Navigation.Menu> menuList;
        Navigation navigation2 = navigation;
        if (navigation2 != null && (menuList = navigation2.getMenuList()) != null) {
            int size = menuList.size();
            for (int i = 0; i < size; i++) {
                if (Intrinsics.areEqual(menuList.get(i).getPromotionType(), "fixed_offerwall")) {
                    removeFrameView();
                    removeFullscreenView();
                    this.pageIndex = i;
                    changeFragment(i);
                    initTabLayout(this.pageIndex);
                    return true;
                }
            }
        }
        return false;
    }

    private final void initTabLayout(int index) {
        SmoothScrollLinearLayoutManager smoothScrollLinearLayoutManager;
        ArrayList<Navigation.Menu> menuList;
        JSONObject jSONObject;
        this.tabRecyclerView = (RecyclerView) findViewById(R.id.tabList);
        NewsV2Activity newsV2Activity = this;
        if (Util.INSTANCE.isPortrait(newsV2Activity)) {
            smoothScrollLinearLayoutManager = new SmoothScrollLinearLayoutManager(this, 0, false);
        } else {
            smoothScrollLinearLayoutManager = new SmoothScrollLinearLayoutManager(this, 1, false);
        }
        RecyclerView recyclerView = this.tabRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabRecyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(smoothScrollLinearLayoutManager);
        RecyclerView recyclerView3 = this.tabRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabRecyclerView");
            recyclerView3 = null;
        }
        recyclerView3.smoothScrollToPosition(index);
        NewsV2Activity newsV2Activity2 = this;
        float fConvertDpToPx = Util.INSTANCE.convertDpToPx(newsV2Activity2, Util.INSTANCE.isMobile(newsV2Activity2) ? 1 : 2);
        if (Util.INSTANCE.isPortrait(newsV2Activity)) {
            RecyclerView recyclerView4 = this.tabRecyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabRecyclerView");
                recyclerView4 = null;
            }
            recyclerView4.addItemDecoration(new RecyclerViewDecoration((int) fConvertDpToPx, 0, 2, null));
        } else {
            RecyclerView recyclerView5 = this.tabRecyclerView;
            if (recyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabRecyclerView");
                recyclerView5 = null;
            }
            recyclerView5.addItemDecoration(new RecyclerViewDecoration(0, (int) fConvertDpToPx, 1, null));
        }
        Navigation navigation2 = navigation;
        if (navigation2 == null || (menuList = navigation2.getMenuList()) == null) {
            return;
        }
        MenuListener menuListener2 = menuListener;
        if (menuListener2 == null || (jSONObject = menuListener2.getClickedTime()) == null) {
            jSONObject = new JSONObject();
        }
        RecyclerView recyclerView6 = this.tabRecyclerView;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabRecyclerView");
        } else {
            recyclerView2 = recyclerView6;
        }
        NewsV2TabRecyclerViewAdapter newsV2TabRecyclerViewAdapter = new NewsV2TabRecyclerViewAdapter(newsV2Activity, menuList, index, jSONObject);
        newsV2TabRecyclerViewAdapter.setOnItemClickListener(new NewsV2TabRecyclerViewAdapter.OnItemClickListener() { // from class: com.hive.promotion.ui.news.NewsV2Activity$initTabLayout$1$1$1
            @Override // com.hive.promotion.ui.news.NewsV2TabRecyclerViewAdapter.OnItemClickListener
            public void onItemClick(View v, int position) {
                this.this$0.setPageIndex(position);
                this.this$0.changeFragment(position);
                RecyclerView recyclerView7 = this.this$0.tabRecyclerView;
                if (recyclerView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tabRecyclerView");
                    recyclerView7 = null;
                }
                recyclerView7.smoothScrollToPosition(position);
            }
        });
        recyclerView2.setAdapter(newsV2TabRecyclerViewAdapter);
    }

    private final void initCloseButton() {
        HiveAnimationButton hiveAnimationButton = this.closeBtn;
        if (hiveAnimationButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            hiveAnimationButton = null;
        }
        hiveAnimationButton.setOnClickedListener(new HiveAnimationButton.OnClickedListener() { // from class: com.hive.promotion.ui.news.NewsV2Activity.initCloseButton.1
            @Override // com.hive.ui.view.HiveAnimationButton.OnClickedListener
            public void onClick() {
                NewsV2Activity.this.finish();
            }
        });
    }

    public static /* synthetic */ void addView$default(NewsV2Activity newsV2Activity, String str, String str2, boolean z, boolean z2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            z2 = newsV2Activity.getData().isForced();
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            str3 = "";
        }
        newsV2Activity.addView(str, str2, z3, z4, str3);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void addView(String viewType, String url, boolean showBackButton, boolean forced, String orientation) {
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        FrameLayout frameLayout = null;
        switch (viewType.hashCode()) {
            case -1820761141:
                if (viewType.equals("external")) {
                    openExternalBrowser(url);
                    break;
                }
                break;
            case 97692013:
                if (viewType.equals(TypedValues.AttributesType.S_FRAME)) {
                    NewsV2FrameView newsV2FrameView = new NewsV2FrameView(this, forced, url, basePostData, showBackButton);
                    newsV2FrameView.setOnButtonClickListener(new NewsV2View.ButtonClickListener() { // from class: com.hive.promotion.ui.news.NewsV2Activity$addView$frameView$1$1
                        @Override // com.hive.promotion.ui.news.NewsV2View.ButtonClickListener
                        public void onBack() {
                            this.this$0.removeFrameView();
                        }
                    });
                    this.showingView = newsV2FrameView;
                    FrameLayout frameLayout2 = this.frameLayout;
                    if (frameLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
                    } else {
                        frameLayout = frameLayout2;
                    }
                    frameLayout.addView(newsV2FrameView);
                    break;
                }
                break;
            case 110066619:
                if (viewType.equals("fullscreen")) {
                    NewsV2FullScreenView newsV2FullScreenView = new NewsV2FullScreenView(this, url, basePostData, showBackButton, orientation);
                    newsV2FullScreenView.setOnButtonClickListener(new NewsV2View.ButtonClickListener() { // from class: com.hive.promotion.ui.news.NewsV2Activity$addView$fullScreenView$1$1
                        @Override // com.hive.promotion.ui.news.NewsV2View.ButtonClickListener
                        public void onBack() {
                            this.this$0.removeFullscreenView();
                        }
                    });
                    this.showingView = newsV2FullScreenView;
                    FrameLayout frameLayout3 = this.fullscreenLayout;
                    if (frameLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("fullscreenLayout");
                    } else {
                        frameLayout = frameLayout3;
                    }
                    frameLayout.addView(newsV2FullScreenView);
                    break;
                }
                break;
            case 191421644:
                if (viewType.equals("inappbrowser") && url.length() != 0) {
                    InAppBrowser.INSTANCE.show(HiveCoreInitializer.INSTANCE.getInitContext(), new InAppBrowserData(url, true, null, null, null, 28, null), new InAppBrowser.InAppBrowserListener() { // from class: com.hive.promotion.ui.news.NewsV2Activity.addView.1
                        @Override // com.hive.platformhelper.InAppBrowser.InAppBrowserListener
                        public void onInAppBrowser(ResultAPI result) {
                            Intrinsics.checkNotNullParameter(result, "result");
                            Logger.INSTANCE.d("[Promotion] InAppBrowser resultAPI = " + result);
                        }
                    });
                }
                break;
        }
    }

    public final void addView(Scheme scheme) throws UnsupportedEncodingException {
        String str;
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Map<String, String> parameter = scheme.getParameter();
        String str2 = parameter.get("type");
        String str3 = str2 == null ? "" : str2;
        String str4 = parameter.get("back_button");
        if (str4 == null) {
            str4 = "y";
        }
        boolean zAreEqual = Intrinsics.areEqual(str4, "y");
        String str5 = parameter.get("url");
        String str6 = str5 != null ? str5 : "";
        if (!StringsKt.isBlank(str6)) {
            String strDecode = URLDecoder.decode(str6, "UTF-8");
            Intrinsics.checkNotNullExpressionValue(strDecode, "decode(...)");
            str = strDecode;
        } else {
            str = str6;
        }
        addView$default(this, str3, str, zAreEqual, false, null, 24, null);
    }

    public final void removeFrameView() {
        FrameLayout frameLayout = this.frameLayout;
        if (frameLayout != null) {
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
                frameLayout = null;
            }
            if (frameLayout.getChildCount() >= 1) {
                FrameLayout frameLayout2 = this.frameLayout;
                if (frameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
                    frameLayout2 = null;
                }
                frameLayout2.removeView(this.showingView);
                this.showingView = null;
            }
        }
    }

    public final void removeFullscreenView() {
        FrameLayout frameLayout = this.fullscreenLayout;
        if (frameLayout != null) {
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fullscreenLayout");
                frameLayout = null;
            }
            if (frameLayout.getChildCount() >= 1) {
                FrameLayout frameLayout2 = this.fullscreenLayout;
                if (frameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fullscreenLayout");
                    frameLayout2 = null;
                }
                frameLayout2.removeView(this.showingView);
                this.showingView = null;
                unlockOrientation();
            }
        }
    }

    public final void changeFragment(int n) {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        for (Fragment fragment : fragments) {
            if (!fragment.isHidden()) {
                fragmentTransactionBeginTransaction.hide(fragment);
            }
        }
        Fragment fragment2 = getSupportFragmentManager().getFragments().get(n);
        if (fragment2 != null) {
            fragmentTransactionBeginTransaction.show(fragment2);
        }
        fragmentTransactionBeginTransaction.commit();
    }

    private final boolean isViewInside(View v, MotionEvent e) {
        return v != null && e.getX() >= 0.0f && e.getY() >= 0.0f && e.getX() <= ((float) v.getMeasuredWidth()) && e.getY() <= ((float) v.getMeasuredHeight());
    }

    private final void startForceOnAnimation() {
        NewsV2Activity newsV2Activity = this;
        AnimatedVectorDrawableCompat animatedVectorDrawableCompatCreate = AnimatedVectorDrawableCompat.create(newsV2Activity, Resource.INSTANCE.getDrawableId(newsV2Activity, "promotion_news_force_from_off_to_on"));
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
        TypedArray typedArrayObtainStyledAttributes = getTheme().obtainStyledAttributes(R.styleable.NewsColorStyle);
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
        NewsV2Activity newsV2Activity = this;
        AnimatedVectorDrawableCompat animatedVectorDrawableCompatCreate = AnimatedVectorDrawableCompat.create(newsV2Activity, Resource.INSTANCE.getDrawableId(newsV2Activity, "promotion_news_force_from_on_to_off"));
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
        TypedArray typedArrayObtainStyledAttributes = getTheme().obtainStyledAttributes(R.styleable.NewsColorStyle);
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

    public final void openExternalBrowser(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(url));
        try {
            startActivity(intent);
        } catch (Exception e) {
            Logger.INSTANCE.w("[NewsV2Activity] openExternalBrowser() \ne: " + e.getMessage());
        }
    }

    @Override // com.hive.ui.common.controller.HiveUiOrientationController
    public void lockOrientation(int targetOrientation) {
        this.currentOrientation = targetOrientation;
        getOrientationHelper().lock(targetOrientation);
    }

    @Override // com.hive.ui.common.controller.HiveUiOrientationController
    public void unlockOrientation() {
        this.currentOrientation = -99;
        getOrientationHelper().unlock();
    }
}
