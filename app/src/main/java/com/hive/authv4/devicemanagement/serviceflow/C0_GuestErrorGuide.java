package com.hive.authv4.devicemanagement.serviceflow;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.authv4.devicemanagement.ui.C0_GuestErrorGuideUi;
import com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: C0_GuestErrorGuide.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/hive/authv4/devicemanagement/serviceflow/C0_GuestErrorGuide;", "", "activity", "Landroid/app/Activity;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function0;", "", "<init>", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function0;)V", "callback", TtmlNode.START, "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class C0_GuestErrorGuide {
    private final Activity activity;
    private Function0<Unit> listener;

    public C0_GuestErrorGuide(Activity activity, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.listener = function0;
    }

    public final void callback() {
        Function0<Unit> function0 = this.listener;
        if (function0 != null) {
            function0.invoke();
        }
        this.listener = null;
    }

    public final void start() {
        final C0_GuestErrorGuideUi c0_GuestErrorGuideUi = new C0_GuestErrorGuideUi(this.activity);
        c0_GuestErrorGuideUi.show(new OnBaseButtonListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.C0_GuestErrorGuide$start$1$1
            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onActive(Bundle summit) {
                this.this$0.callback();
                c0_GuestErrorGuideUi.finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onCancel() {
                this.this$0.callback();
                c0_GuestErrorGuideUi.finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onClose() {
                this.this$0.callback();
                c0_GuestErrorGuideUi.finish();
            }
        });
    }
}
