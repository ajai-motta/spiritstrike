package com.hive.module.interfaces;

import android.content.Context;
import com.hive.base.Android;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&JL\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072:\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00050\nH'J$\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H&¨\u0006\u0014"}, d2 = {"Lcom/hive/module/interfaces/GoogleBase;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "installProvider", "", "context", "Landroid/content/Context;", "getAdvertisingClientInfo", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", Android.HW_IDS_ADVERTISING_ID, "", Android.HW_IDS_IS_LIMIT_AD_TRACKING, "isGooglePlayServicesAvailable", "show", "minApkVersion", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface GoogleBase extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(GoogleBase googleBase) {
            return HiveModuleName.INSTANCE.getService_Google_Base();
        }

        public static /* synthetic */ boolean isGooglePlayServicesAvailable$default(GoogleBase googleBase, Context context, boolean z, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isGooglePlayServicesAvailable");
            }
            if ((i2 & 2) != 0) {
                z = false;
            }
            if ((i2 & 4) != 0) {
                i = 0;
            }
            return googleBase.isGooglePlayServicesAvailable(context, z, i);
        }
    }

    void getAdvertisingClientInfo(Context context, Function2<? super String, ? super Boolean, Unit> callback);

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    void installProvider(Context context);

    boolean isGooglePlayServicesAvailable(Context context, boolean show, int minApkVersion);
}
