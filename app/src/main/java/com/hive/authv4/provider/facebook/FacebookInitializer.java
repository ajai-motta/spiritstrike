package com.hive.authv4.provider.facebook;

import android.content.Context;
import androidx.startup.Initializer;
import com.facebook.FacebookSdk;
import com.hive.authv4.provider.AuthV4ProviderFacebook;
import com.hive.base.HiveInitializer;
import com.hive.core.Configuration;
import com.hive.core.HiveCoreInitializer;
import com.hive.module.HiveModuleManager;
import com.hive.social.provider.SocialV4ProviderFacebook;
import com.hive.standalone.HiveLifecycle;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FacebookInitializer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\t0\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\f"}, d2 = {"Lcom/hive/authv4/provider/facebook/FacebookInitializer;", "Landroidx/startup/Initializer;", "<init>", "()V", "create", "context", "Landroid/content/Context;", "dependencies", "", "Ljava/lang/Class;", "getProviderFacebook", "", "hive-authv4-provider-facebook_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FacebookInitializer implements Initializer<FacebookInitializer> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public FacebookInitializer create(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        getProviderFacebook();
        HiveModuleManager.INSTANCE.discover(new HiveModuleFacebook());
        HiveLifecycle.registerHiveLifecycleListeners(new HiveLifecycle.HiveLifecycleListener() { // from class: com.hive.authv4.provider.facebook.FacebookInitializer.create.1
            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onAgreement() {
                HiveLifecycle.HiveLifecycleListener.DefaultImpls.onAgreement(this);
            }

            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onNetworkAvailable(boolean z) {
                HiveLifecycle.HiveLifecycleListener.DefaultImpls.onNetworkAvailable(this, z);
            }

            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onProcessUri(String str) {
                HiveLifecycle.HiveLifecycleListener.DefaultImpls.onProcessUri(this, str);
            }

            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onReset() {
                HiveLifecycle.HiveLifecycleListener.DefaultImpls.onReset(this);
            }

            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onSignIn(HiveLifecycle.HiveAccount hiveAccount) {
                HiveLifecycle.HiveLifecycleListener.DefaultImpls.onSignIn(this, hiveAccount);
            }

            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onSignOut() {
                HiveLifecycle.HiveLifecycleListener.DefaultImpls.onSignOut(this);
            }

            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onSetupFinished() {
                AuthV4ProviderFacebook authV4ProviderFacebook = AuthV4ProviderFacebook.INSTANCE;
                SocialV4ProviderFacebook socialV4ProviderFacebook = SocialV4ProviderFacebook.INSTANCE;
                if (Configuration.INSTANCE.getAgeGateU13()) {
                    return;
                }
                if (!FacebookSdk.getAutoLogAppEventsEnabled()) {
                    FacebookSdk.setAutoLogAppEventsEnabled(true);
                }
                if (FacebookSdk.getAdvertiserIDCollectionEnabled()) {
                    return;
                }
                FacebookSdk.setAdvertiserIDCollectionEnabled(true);
            }

            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onInitializeFinished() {
                AuthV4ProviderFacebook authV4ProviderFacebook = AuthV4ProviderFacebook.INSTANCE;
                SocialV4ProviderFacebook socialV4ProviderFacebook = SocialV4ProviderFacebook.INSTANCE;
            }
        });
        return this;
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return CollectionsKt.listOf((Object[]) new Class[]{HiveCoreInitializer.class, HiveInitializer.class});
    }

    private final void getProviderFacebook() {
        AuthV4ProviderFacebook authV4ProviderFacebook = AuthV4ProviderFacebook.INSTANCE;
        SocialV4ProviderFacebook socialV4ProviderFacebook = SocialV4ProviderFacebook.INSTANCE;
    }
}
