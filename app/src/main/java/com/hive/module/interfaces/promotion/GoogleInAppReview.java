package com.hive.module.interfaces.promotion;

import android.app.Activity;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lcom/hive/module/interfaces/promotion/GoogleInAppReview;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "launchReviewFlow", "", "activity", "Landroid/app/Activity;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface GoogleInAppReview extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(GoogleInAppReview googleInAppReview) {
            return HiveModuleName.INSTANCE.getPromotion_Google_InAppReview();
        }
    }

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    void launchReviewFlow(Activity activity);
}
