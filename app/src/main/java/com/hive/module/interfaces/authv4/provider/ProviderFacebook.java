package com.hive.module.interfaces.authv4.provider;

import android.app.Activity;
import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H'¨\u0006\u000b"}, d2 = {"Lcom/hive/module/interfaces/authv4/provider/ProviderFacebook;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "shareDialog", "", "activity", "Landroid/app/Activity;", "contentUrl", "Landroid/net/Uri;", ShareConstants.WEB_DIALOG_PARAM_HASHTAG, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ProviderFacebook extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(ProviderFacebook providerFacebook) {
            return HiveModuleName.INSTANCE.getAuthV4_Provider_Facebook();
        }
    }

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    void shareDialog(Activity activity, Uri contentUrl, String hashtag);
}
