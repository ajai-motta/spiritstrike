package com.hive.authv4;

import android.os.Handler;
import com.hive.AuthV4;
import com.hive.ResultAPI;
import com.hive.logger.LoggerImpl;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rH\u0016¨\u0006\u000e"}, d2 = {"com/hive/authv4/AuthV4Impl$setup$1$1$3", "Lcom/hive/AuthV4$AuthV4SetupListener;", "onAuthV4Setup", "", "result", "Lcom/hive/ResultAPI;", "isAutoSignIn", "", "did", "", "providerTypeList", "Ljava/util/ArrayList;", "Lcom/hive/AuthV4$ProviderType;", "Lkotlin/collections/ArrayList;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4Impl$setup$1$1$3 implements AuthV4.AuthV4SetupListener {
    final /* synthetic */ String $fApiName;
    final /* synthetic */ AuthV4.AuthV4SetupListener $setupListener;

    public AuthV4Impl$setup$1$1$3(String str, AuthV4.AuthV4SetupListener authV4SetupListener) {
        this.$fApiName = str;
        this.$setupListener = authV4SetupListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAuthV4Setup$lambda$0(String str, ResultAPI resultAPI, AuthV4.AuthV4SetupListener authV4SetupListener, boolean z, String str2, ArrayList arrayList) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        if (authV4SetupListener != null) {
            authV4SetupListener.onAuthV4Setup(resultAPI, z, str2, arrayList);
        }
    }

    @Override // com.hive.AuthV4.AuthV4SetupListener
    public void onAuthV4Setup(final ResultAPI result, final boolean isAutoSignIn, final String did, final ArrayList<AuthV4.ProviderType> providerTypeList) {
        Intrinsics.checkNotNullParameter(result, "result");
        AuthV4Impl.isInProgressSetup = false;
        Handler handler = AuthV4Impl.mainLooperHandler;
        final String str = this.$fApiName;
        final AuthV4.AuthV4SetupListener authV4SetupListener = this.$setupListener;
        handler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$setup$1$1$3$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4Impl$setup$1$1$3.onAuthV4Setup$lambda$0(str, result, authV4SetupListener, isAutoSignIn, did, providerTypeList);
            }
        });
    }
}
