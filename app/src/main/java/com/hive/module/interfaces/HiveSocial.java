package com.hive.module.interfaces;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.SocialHive;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\u0004\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000eH&J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/hive/module/interfaces/HiveSocial;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "showHiveDialog", "", "hiveDialogType", "Lcom/hive/SocialHive$HiveDialogType;", "vid", "additionalInfo", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/SocialHive$ShowHiveDialogListener;", "", "subpath", "Lcom/hive/SocialHive$ShowHiveDialogDataListener;", "getVersionInfo", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface HiveSocial extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(HiveSocial hiveSocial) {
            return HiveModuleName.INSTANCE.getSocial();
        }

        public static Map<String, String> getVersionInfo(HiveSocial hiveSocial) {
            return new HashMap();
        }
    }

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    @Override // com.hive.module.HiveModule
    Map<String, String> getVersionInfo();

    int showHiveDialog(String subpath, SocialHive.ShowHiveDialogDataListener listener);

    void showHiveDialog(SocialHive.HiveDialogType hiveDialogType, String vid, String additionalInfo, SocialHive.ShowHiveDialogListener listener);
}
