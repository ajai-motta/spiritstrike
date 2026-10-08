package com.hive.promotion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.hive.Promotion;
import com.hive.ResultAPI;
import com.hive.core.Scheme;
import com.hive.promotion.PromotionDialog;
import com.hive.promotion.PromotionImpl;
import com.hive.promotion.PromotionNetwork;
import com.hive.promotion.ui.PromotionView;
import com.hive.ui.OnActivityLifecycle;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PromotionImpl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J*\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"com/hive/promotion/PromotionImpl$showOfferwall$1$1", "Lcom/hive/ui/OnActivityLifecycle;", "dialog", "Lcom/hive/promotion/PromotionDialog;", "getDialog", "()Lcom/hive/promotion/PromotionDialog;", "setDialog", "(Lcom/hive/promotion/PromotionDialog;)V", "onCreate", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromotionImpl$showOfferwall$1$1 extends OnActivityLifecycle {
    final /* synthetic */ String $fApiName;
    final /* synthetic */ Promotion.PromotionViewListener $listener;
    final /* synthetic */ ArrayList<PromotionNetwork.WebViewInfo> $webViewInfoList;
    public PromotionDialog dialog;

    PromotionImpl$showOfferwall$1$1(ArrayList<PromotionNetwork.WebViewInfo> arrayList, String str, Promotion.PromotionViewListener promotionViewListener) {
        this.$webViewInfoList = arrayList;
        this.$fApiName = str;
        this.$listener = promotionViewListener;
    }

    public final PromotionDialog getDialog() {
        PromotionDialog promotionDialog = this.dialog;
        if (promotionDialog != null) {
            return promotionDialog;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
        return null;
    }

    public final void setDialog(PromotionDialog promotionDialog) {
        Intrinsics.checkNotNullParameter(promotionDialog, "<set-?>");
        this.dialog = promotionDialog;
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onCreate(activity, savedInstanceState);
        PromotionDialog promotionDialog = new PromotionDialog.Builder(activity, PromotionImpl.INSTANCE.convertWebViewInfoList(this.$webViewInfoList), new PromotionImpl$showOfferwall$1$1$onCreate$promotionDialogListener$1(activity, this.$fApiName, this.$listener)).setForced(true).setSchemeEventFunc(new Function1() { // from class: com.hive.promotion.PromotionImpl$showOfferwall$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(PromotionImpl$showOfferwall$1$1.onCreate$lambda$0((Scheme) obj));
            }
        }).setGeneratePostDataFunc(new Function2() { // from class: com.hive.promotion.PromotionImpl$showOfferwall$1$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PromotionImpl$showOfferwall$1$1.onCreate$lambda$1((PromotionView.WebViewInfo) obj, (String) obj2);
            }
        }).setPromotionWebChromeClient(new PromotionImpl.PromotionWebChromeClient()).getPromotionDialog();
        PromotionImpl promotionImpl = PromotionImpl.INSTANCE;
        PromotionImpl.mPromotionDialog = promotionDialog;
        setDialog(promotionDialog);
        getDialog().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$0(Scheme scheme) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        return PromotionImpl.INSTANCE.processPromotionScheme(scheme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onCreate$lambda$1(PromotionView.WebViewInfo webViewInfo, String s) {
        Intrinsics.checkNotNullParameter(webViewInfo, "webViewInfo");
        Intrinsics.checkNotNullParameter(s, "s");
        return PromotionImpl.INSTANCE.generatePromotionViewPostData(webViewInfo, s);
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        PromotionDialog.PromotionDialogListener mPromotionDialogListener = PromotionImpl.INSTANCE.getMPromotionDialogListener();
        if (mPromotionDialogListener != null) {
            mPromotionDialogListener.needDialogClosed(new ResultAPI());
        }
        if (!getIsCalledFinish()) {
            getDialog().dismiss();
        }
        PromotionImpl promotionImpl = PromotionImpl.INSTANCE;
        PromotionImpl.mShowingOfferwall = false;
        super.onDestroy(activity);
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        PromotionImpl.INSTANCE.onActivityResult(activity, requestCode, resultCode, data);
    }
}
