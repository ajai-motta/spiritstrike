package com.hive.module.interfaces.authv4.provider;

import android.app.Activity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.AuthV4;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import com.hive.protocol.membership.GetSession;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016Jw\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032Q\u0010\u0016\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0004\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00100\u0017H&J\b\u0010\u001a\u001a\u00020\u001bH&J]\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142K\u0010\u001d\u001aG\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00100\u0017H&R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/hive/module/interfaces/authv4/provider/ProviderHiveMembership;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "uid", "getUid", "()Ljava/lang/String;", "hiveSession", "getHiveSession", "memberSession", "getMemberSession", "profileName", "getProfileName", "profileImg", "getProfileImg", "login", "", "activity", "Landroid/app/Activity;", "playerInfo", "Lcom/hive/AuthV4$PlayerInfo;", "did", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "logout", "", "getSession", "callback", "Lcom/hive/protocol/membership/GetSession;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ProviderHiveMembership extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(ProviderHiveMembership providerHiveMembership) {
            return HiveModuleName.INSTANCE.getAuthV4_Provider_Hive_Membership();
        }
    }

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    String getHiveSession();

    String getMemberSession();

    String getProfileImg();

    String getProfileName();

    void getSession(AuthV4.PlayerInfo playerInfo, Function3<? super GetSession, ? super String, ? super String, Unit> callback);

    String getUid();

    void login(Activity activity, AuthV4.PlayerInfo playerInfo, String did, Function3<? super String, ? super String, ? super String, Unit> listener);

    boolean logout();
}
