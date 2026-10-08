package com.hive.module;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u001aJ\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&JY\u0010\u000f\u001a\u00020\u000b2O\u0010\u0010\u001aK\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000b0\u0011H&JY\u0010\u0017\u001a\u00020\u000b2O\u0010\u0010\u001aK\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000b0\u0011H&JB\u0010\u0018\u001a\u00020\u000b28\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000b0\u0019H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u001b"}, d2 = {"Lcom/hive/module/GoogleSignInModule;", "Lcom/hive/module/HiveModule;", "googleAppId", "", "getGoogleAppId", "()Ljava/lang/String;", "googleServerClientId", "getGoogleServerClientId", "getCurrentAccount", "Lcom/hive/module/GoogleSignInModule$GoogleAccount;", "setRequestEmail", "", TypedValues.Custom.S_BOOLEAN, "", "setRequestServerAuthCode", "silentSignIn", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isSuccessful", "failReason", "account", "signIn", "signOut", "Lkotlin/Function2;", "GoogleAccount", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface GoogleSignInModule extends HiveModule {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/hive/module/GoogleSignInModule$GoogleAccount;", "", "openId", "", "getOpenId", "()Ljava/lang/String;", "openIdToken", "getOpenIdToken", "displayName", "getDisplayName", "photoUrl", "getPhotoUrl", "email", "getEmail", "serverAuthCode", "getServerAuthCode", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface GoogleAccount {
        String getDisplayName();

        String getEmail();

        String getOpenId();

        String getOpenIdToken();

        String getPhotoUrl();

        String getServerAuthCode();
    }

    GoogleAccount getCurrentAccount();

    String getGoogleAppId();

    String getGoogleServerClientId();

    void setRequestEmail(boolean z);

    void setRequestServerAuthCode(boolean z);

    void signIn(Function3<? super Boolean, ? super String, ? super GoogleAccount, Unit> listener);

    void signOut(Function2<? super Boolean, ? super String, Unit> listener);

    void silentSignIn(Function3<? super Boolean, ? super String, ? super GoogleAccount, Unit> listener);
}
