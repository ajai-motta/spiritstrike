package com.hive.authv4.devicemanagement.serviceflow;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.hive.authv4.devicemanagement.serviceflow.A1_SubscriptionGuide;
import com.hive.authv4.devicemanagement.ui.model.OnPersonalInfoListener;
import com.hive.core.Configuration;
import com.hive.core.ExtentionsKt;
import com.hive.protocol.UrlManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.io.files.FileSystemKt;

/* JADX INFO: compiled from: A1_SubscriptionGuide.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/hive/authv4/devicemanagement/serviceflow/A1_SubscriptionGuide$start$1$onActive$1", "Lcom/hive/authv4/devicemanagement/ui/model/OnPersonalInfoListener;", "onMore", "", "onActive", "summit", "Landroid/os/Bundle;", "onCancel", "onClose", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class A1_SubscriptionGuide$start$1$onActive$1 implements OnPersonalInfoListener {
    final /* synthetic */ A1_SubscriptionGuide this$0;

    /* JADX INFO: compiled from: A1_SubscriptionGuide.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[A1_SubscriptionGuide.Button.values().length];
            try {
                iArr[A1_SubscriptionGuide.Button.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[A1_SubscriptionGuide.Button.Cancel.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[A1_SubscriptionGuide.Button.Close.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    A1_SubscriptionGuide$start$1$onActive$1(A1_SubscriptionGuide a1_SubscriptionGuide) {
        this.this$0 = a1_SubscriptionGuide;
    }

    @Override // com.hive.authv4.devicemanagement.ui.model.OnPersonalInfoListener
    public void onMore() {
        String company = Configuration.INSTANCE.getCompany();
        if (!(!StringsKt.isBlank(company))) {
            company = null;
        }
        if (company == null) {
            company = "Com2uS%20Platform";
        }
        Integer numValueOf = Integer.valueOf(Configuration.INSTANCE.getCompanyIndex());
        if (numValueOf.intValue() == -1) {
            numValueOf = null;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(UrlManager.Terms.INSTANCE.getDeviceManagement() + FileSystemKt.UnixPathSeparator + (company + FileSystemKt.UnixPathSeparator + (numValueOf != null ? numValueOf.intValue() : 3))));
        A1_SubscriptionGuide a1_SubscriptionGuide = this.this$0;
        intent.setFlags(268435456);
        ExtentionsKt.startActivityCatching$default(a1_SubscriptionGuide.activity, intent, null, 2, null);
    }

    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
    public void onActive(Bundle summit) {
        String str;
        String str2;
        String str3 = this.this$0.inputPhoneCode;
        if (str3 == null || StringsKt.isBlank(str3) || (str = this.this$0.inputPhoneNumber) == null || StringsKt.isBlank(str) || (str2 = this.this$0.signature) == null || StringsKt.isBlank(str2)) {
            this.this$0.a3();
            this.this$0.getA2().finish();
        } else {
            A1_SubscriptionGuide a1_SubscriptionGuide = this.this$0;
            String str4 = a1_SubscriptionGuide.signature;
            final A1_SubscriptionGuide a1_SubscriptionGuide2 = this.this$0;
            a1_SubscriptionGuide.deviceSetUser(str4, new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.A1_SubscriptionGuide$start$1$onActive$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return A1_SubscriptionGuide$start$1$onActive$1.onActive$lambda$3(a1_SubscriptionGuide2, (A1_SubscriptionGuide.Button) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onActive$lambda$3(A1_SubscriptionGuide a1_SubscriptionGuide, A1_SubscriptionGuide.Button b) {
        Intrinsics.checkNotNullParameter(b, "b");
        int i = WhenMappings.$EnumSwitchMapping$0[b.ordinal()];
        if (i == 1) {
            a1_SubscriptionGuide.callback(true);
        } else if (i == 2) {
            a1_SubscriptionGuide.a3();
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            a1_SubscriptionGuide.callback(false);
        }
        a1_SubscriptionGuide.getA2().finish();
        return Unit.INSTANCE;
    }

    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
    public void onCancel() {
        this.this$0.callback(false);
        this.this$0.getA2().finish();
    }

    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
    public void onClose() {
        this.this$0.callback(false);
        this.this$0.getA2().finish();
    }
}
