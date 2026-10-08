package com.hive.authv4;

import android.os.Handler;
import com.hive.AuthV4;
import com.hive.ResultAPI;
import com.hive.logger.LoggerImpl;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"com/hive/authv4/AuthV4Impl$internalShowProfile$2$onCreate$1$onWebViewFinish$1", "Lcom/hive/AuthV4$AuthV4GetProfileListener;", "onAuthV4GetProfile", "", "result", "Lcom/hive/ResultAPI;", "profileInfoList", "Ljava/util/ArrayList;", "Lcom/hive/AuthV4$ProfileInfo;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4Impl$internalShowProfile$2$onCreate$1$onWebViewFinish$1 implements AuthV4.AuthV4GetProfileListener {
    final /* synthetic */ String $fApiName;
    final /* synthetic */ AuthV4.AuthV4ShowProfileListener $listener;
    final /* synthetic */ String $logMsg;

    public AuthV4Impl$internalShowProfile$2$onCreate$1$onWebViewFinish$1(String str, String str2, AuthV4.AuthV4ShowProfileListener authV4ShowProfileListener) {
        this.$logMsg = str;
        this.$fApiName = str2;
        this.$listener = authV4ShowProfileListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAuthV4GetProfile$lambda$0(String str, ResultAPI resultAPI, AuthV4.AuthV4ShowProfileListener authV4ShowProfileListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ShowProfileListener.onAuthV4ShowProfile(resultAPI);
    }

    @Override // com.hive.AuthV4.AuthV4GetProfileListener
    public void onAuthV4GetProfile(ResultAPI result, ArrayList<AuthV4.ProfileInfo> profileInfoList) {
        Intrinsics.checkNotNullParameter(result, "result");
        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[showProfile] getProfile me: " + result);
        final ResultAPI resultAPI = new ResultAPI(0, ResultAPI.Code.Success, this.$logMsg);
        Handler handler = AuthV4Impl.mainLooperHandler;
        final String str = this.$fApiName;
        final AuthV4.AuthV4ShowProfileListener authV4ShowProfileListener = this.$listener;
        handler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$internalShowProfile$2$onCreate$1$onWebViewFinish$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4Impl$internalShowProfile$2$onCreate$1$onWebViewFinish$1.onAuthV4GetProfile$lambda$0(str, resultAPI, authV4ShowProfileListener);
            }
        });
    }
}
