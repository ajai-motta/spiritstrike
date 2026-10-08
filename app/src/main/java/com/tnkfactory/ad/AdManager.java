package com.tnkfactory.ad;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tnkfactory.ad.pub.a;
import com.tnkfactory.ad.pub.d4;
import com.tnkfactory.ad.pub.h1;
import com.tnkfactory.ad.pub.l4;
import com.tnkfactory.ad.pub.m4;
import com.tnkfactory.ad.pub.s0;
import com.tnkfactory.ad.pub.w;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge;
import com.unity3d.services.core.fid.Constants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u001f B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\r\u0010\u000fJ+\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\u0010\u0010\u000eJ\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0016\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0018\u0010\u0019R0\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00110\u001aj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0011`\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR4\u0010\u001e\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u001aj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\n`\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001d¨\u0006!"}, d2 = {"Lcom/tnkfactory/ad/AdManager;", "", "<init>", "()V", Constants.GET_INSTANCE, "()Lcom/tnkfactory/ad/AdManager;", "Landroid/content/Context;", "context", "", HandleInvocationsFromAdViewer.KEY_PLACEMENT_ID, "Lcom/tnkfactory/ad/AdListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "loadInterstitialAd", "(Landroid/content/Context;Ljava/lang/String;Lcom/tnkfactory/ad/AdListener;)V", "(Landroid/content/Context;Ljava/lang/String;)V", "showInterstitialAd", "Lcom/tnkfactory/ad/InterstitialAdItem;", "getInterstitialAdItem", "(Ljava/lang/String;)Lcom/tnkfactory/ad/InterstitialAdItem;", "Lcom/tnkfactory/ad/pub/l4;", "callback", "publishStatus", "(Ljava/lang/String;Landroid/content/Context;Lcom/tnkfactory/ad/pub/l4;)V", MobileAdsBridge.versionMethodName, "()Ljava/lang/String;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "interstitialAdItemHashMap", "Ljava/util/HashMap;", "adListenerHashMap", "ShowInterstitialAdRunnable", "CustomCloseAdListener", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AdManager {
    public static final AdManager INSTANCE = new AdManager();
    private static final HashMap<String, InterstitialAdItem> interstitialAdItemHashMap = new HashMap<>();
    private static final HashMap<String, AdListener> adListenerHashMap = new HashMap<>();

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/tnkfactory/ad/AdManager$CustomCloseAdListener;", "Lcom/tnkfactory/ad/AdListener;", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Landroid/content/Context;Lcom/tnkfactory/ad/AdListener;)V", "getContext", "()Landroid/content/Context;", "getListener", "()Lcom/tnkfactory/ad/AdListener;", "onClose", "", "adItem", "Lcom/tnkfactory/ad/AdItem;", "type", "", "onClick", "onLoad", "onShow", "onError", "error", "Lcom/tnkfactory/ad/AdError;", "onVideoCompletion", "verifyCode", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CustomCloseAdListener extends AdListener {
        private final Context context;
        private final AdListener listener;

        public CustomCloseAdListener(Context context, AdListener listener) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.context = context;
            this.listener = listener;
        }

        public final Context getContext() {
            return this.context;
        }

        public final AdListener getListener() {
            return this.listener;
        }

        @Override // com.tnkfactory.ad.AdListener
        public void onClick(AdItem adItem) {
            Intrinsics.checkNotNullParameter(adItem, "adItem");
            AdListener adListener = this.listener;
            if (adListener != null) {
                adListener.onClick(adItem);
            }
        }

        @Override // com.tnkfactory.ad.AdListener
        public void onClose(AdItem adItem, int type) {
            Intrinsics.checkNotNullParameter(adItem, "adItem");
            AdListener adListener = this.listener;
            if (adListener != null) {
                adListener.onClose(adItem, type);
            }
        }

        @Override // com.tnkfactory.ad.AdListener
        public void onError(AdItem adItem, AdError error) {
            Intrinsics.checkNotNullParameter(adItem, "adItem");
            Intrinsics.checkNotNullParameter(error, "error");
            AdListener adListener = this.listener;
            if (adListener != null) {
                adListener.onError(adItem, error);
            }
        }

        @Override // com.tnkfactory.ad.AdListener
        public void onLoad(AdItem adItem) {
            Intrinsics.checkNotNullParameter(adItem, "adItem");
            AdListener adListener = this.listener;
            if (adListener != null) {
                adListener.onLoad(adItem);
            }
            adItem.show(this.context);
        }

        @Override // com.tnkfactory.ad.AdListener
        public void onShow(AdItem adItem) {
            Intrinsics.checkNotNullParameter(adItem, "adItem");
            AdListener adListener = this.listener;
            if (adListener != null) {
                adListener.onShow(adItem);
            }
        }

        @Override // com.tnkfactory.ad.AdListener
        public void onVideoCompletion(AdItem adItem, int verifyCode) {
            Intrinsics.checkNotNullParameter(adItem, "adItem");
            AdListener adListener = this.listener;
            if (adListener != null) {
                adListener.onVideoCompletion(adItem, verifyCode);
            }
        }
    }

    private AdManager() {
    }

    @JvmStatic
    public static final AdManager getInstance() {
        return INSTANCE;
    }

    @JvmStatic
    public static final InterstitialAdItem getInterstitialAdItem(String placementId) {
        return interstitialAdItemHashMap.get(placementId);
    }

    @JvmStatic
    public static final String getVersion() {
        return "7.23.85";
    }

    @JvmStatic
    public static final void loadInterstitialAd(Context context, String placementId, AdListener listener) {
        Intrinsics.checkNotNullParameter(placementId, "placementId");
        if (context == null || TextUtils.isEmpty(placementId)) {
            return;
        }
        InterstitialAdItem interstitialAdItem = new InterstitialAdItem(context, placementId);
        if (listener != null) {
            interstitialAdItem.setListener(listener);
            adListenerHashMap.put(placementId, listener);
        }
        interstitialAdItem.load();
        interstitialAdItemHashMap.put(placementId, interstitialAdItem);
    }

    public static /* synthetic */ void loadInterstitialAd$default(Context context, String str, AdListener adListener, int i, Object obj) {
        if ((i & 4) != 0) {
            adListener = null;
        }
        loadInterstitialAd(context, str, adListener);
    }

    @JvmStatic
    public static final void publishStatus(String placementId, Context context, l4 callback) {
        Intrinsics.checkNotNullParameter(placementId, "placementId");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        d4 d4Var = new d4(context);
        String strTrim = m4.a(context).f3161a.getSharedPreferences("__tnk_pub__", 0).getString("__tnk_202301_", "").replaceAll("-", "").trim();
        String strA = h1.a("d66d03d8f9");
        String strA2 = h1.a("getPublishState");
        Object[] objArr = {strTrim, placementId};
        w wVar = new w(d4Var);
        s0 s0Var = new s0(d4Var.b, d4Var.f3109a, strA, strA2, objArr, null);
        s0Var.j = wVar;
        s0Var.h = true;
        if (callback != null) {
            s0Var.g = new a(callback);
        }
        s0Var.start();
    }

    @JvmStatic
    public static final void showInterstitialAd(Context context, String placementId, AdListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(placementId, "placementId");
        if (TextUtils.isEmpty(placementId)) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new ShowInterstitialAdRunnable(context, placementId, listener));
    }

    public static /* synthetic */ void showInterstitialAd$default(Context context, String str, AdListener adListener, int i, Object obj) {
        if ((i & 4) != 0) {
            adListener = null;
        }
        showInterstitialAd(context, str, adListener);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/tnkfactory/ad/AdManager$ShowInterstitialAdRunnable;", "Ljava/lang/Runnable;", "context", "Landroid/content/Context;", HandleInvocationsFromAdViewer.KEY_PLACEMENT_ID, "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tnkfactory/ad/AdListener;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/tnkfactory/ad/AdListener;)V", "run", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ShowInterstitialAdRunnable implements Runnable {
        private final Context context;
        private final AdListener listener;
        private final String placementId;

        public ShowInterstitialAdRunnable(Context context, String placementId, AdListener adListener) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(placementId, "placementId");
            this.context = context;
            this.placementId = placementId;
            this.listener = adListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterstitialAdItem interstitialAdItem = (InterstitialAdItem) AdManager.interstitialAdItemHashMap.get(this.placementId);
            if (interstitialAdItem == null) {
                return;
            }
            AdListener adListener = this.listener;
            if (adListener != null) {
                interstitialAdItem.setListener(adListener);
                AdManager.adListenerHashMap.put(this.placementId, this.listener);
            }
            if (interstitialAdItem.isLoaded()) {
                interstitialAdItem.show(this.context);
                Unit unit = Unit.INSTANCE;
            } else {
                AdListener adListener2 = (AdListener) AdManager.adListenerHashMap.get(this.placementId);
                if (adListener2 != null) {
                    new CustomCloseAdListener(this.context, adListener2);
                }
            }
        }

        public /* synthetic */ ShowInterstitialAdRunnable(Context context, String str, AdListener adListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, str, (i & 4) != 0 ? null : adListener);
        }
    }

    @JvmStatic
    public static final void loadInterstitialAd(Context context, String placementId) {
        Intrinsics.checkNotNull(placementId);
        loadInterstitialAd(context, placementId, null);
    }
}
