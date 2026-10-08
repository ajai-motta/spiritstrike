package com.hive.iapv4;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.hive.IAPV4;
import com.hive.ResultAPI;
import com.hive.iapv4.IapWebViewDialog;
import com.hive.ui.OnActivityLifecycle;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IapV4Impl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"com/hive/iapv4/IapV4Impl$showMarketSelection$3$1", "Lcom/hive/ui/OnActivityLifecycle;", "dialog", "Lcom/hive/iapv4/IapWebViewDialog;", "getDialog", "()Lcom/hive/iapv4/IapWebViewDialog;", "setDialog", "(Lcom/hive/iapv4/IapWebViewDialog;)V", "onCreate", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IapV4Impl$showMarketSelection$3$1 extends OnActivityLifecycle {
    final /* synthetic */ String $body;
    final /* synthetic */ Handler $handler;
    final /* synthetic */ IAPV4.IAPV4MarketInfoListener $listener;
    final /* synthetic */ String $selectUrl;
    public IapWebViewDialog dialog;

    IapV4Impl$showMarketSelection$3$1(String str, String str2, Handler handler, IAPV4.IAPV4MarketInfoListener iAPV4MarketInfoListener) {
        this.$selectUrl = str;
        this.$body = str2;
        this.$handler = handler;
        this.$listener = iAPV4MarketInfoListener;
    }

    public final IapWebViewDialog getDialog() {
        IapWebViewDialog iapWebViewDialog = this.dialog;
        if (iapWebViewDialog != null) {
            return iapWebViewDialog;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
        return null;
    }

    public final void setDialog(IapWebViewDialog iapWebViewDialog) {
        Intrinsics.checkNotNullParameter(iapWebViewDialog, "<set-?>");
        this.dialog = iapWebViewDialog;
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onCreate(final Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onCreate(activity, savedInstanceState);
        IapWebViewDialog.ACTION_TYPE action_type = IapWebViewDialog.ACTION_TYPE.ACTION_PAYMENT;
        String str = this.$selectUrl;
        String str2 = this.$body;
        final Handler handler = this.$handler;
        final IAPV4.IAPV4MarketInfoListener iAPV4MarketInfoListener = this.$listener;
        setDialog(new IapWebViewDialog(activity, action_type, str, str2, new Function1() { // from class: com.hive.iapv4.IapV4Impl$showMarketSelection$3$1$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IapV4Impl$showMarketSelection$3$1.onCreate$lambda$3(handler, activity, iAPV4MarketInfoListener, (String) obj);
            }
        }));
        getDialog().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013c A[Catch: Exception -> 0x019d, TryCatch #0 {Exception -> 0x019d, blocks: (B:4:0x000c, B:6:0x001c, B:8:0x0028, B:10:0x0041, B:14:0x004c, B:17:0x0056, B:59:0x0152, B:62:0x015f, B:63:0x0192, B:18:0x0063, B:21:0x006d, B:22:0x007a, B:25:0x0084, B:26:0x0091, B:29:0x009b, B:30:0x00a8, B:33:0x00b2, B:34:0x00bf, B:37:0x00c9, B:38:0x00d6, B:41:0x00df, B:42:0x00ea, B:45:0x00f3, B:46:0x00fd, B:49:0x0106, B:50:0x0112, B:53:0x011b, B:54:0x0127, B:57:0x0130, B:58:0x013c, B:64:0x019a), top: B:71:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.Unit onCreate$lambda$3(android.os.Handler r8, android.app.Activity r9, final com.hive.IAPV4.IAPV4MarketInfoListener r10, java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 506
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.iapv4.IapV4Impl$showMarketSelection$3$1.onCreate$lambda$3(android.os.Handler, android.app.Activity, com.hive.IAPV4$IAPV4MarketInfoListener, java.lang.String):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3$lambda$0(ResultAPI resultAPI, IAPV4.IAPV4MarketInfoListener iAPV4MarketInfoListener, ArrayList arrayList) {
        if (resultAPI.isSuccess()) {
            iAPV4MarketInfoListener.onIAPV4MarketInfo(resultAPI, arrayList);
        } else {
            iAPV4MarketInfoListener.onIAPV4MarketInfo(resultAPI, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3$lambda$1(IAPV4.IAPV4MarketInfoListener iAPV4MarketInfoListener, Exception exc) {
        iAPV4MarketInfoListener.onIAPV4MarketInfo(new ResultAPI(-8, ResultAPI.Code.IAPV4CancelMarketSelect, "[HiveIAP] showPayment scheme fail: " + exc), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3$lambda$2(IAPV4.IAPV4MarketInfoListener iAPV4MarketInfoListener) {
        iAPV4MarketInfoListener.onIAPV4MarketInfo(new ResultAPI(-8, ResultAPI.Code.IAPV4CancelMarketSelect, "[HiveIAP] showPayment scheme is null"), null);
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!getIsCalledFinish()) {
            getDialog().dismiss();
        }
        super.onDestroy(activity);
    }
}
