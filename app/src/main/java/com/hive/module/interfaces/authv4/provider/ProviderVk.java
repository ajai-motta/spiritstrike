package com.hive.module.interfaces.authv4.provider;

import android.app.Activity;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0012J\b\u0010\u0002\u001a\u00020\u0003H\u0016JL\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2:\u0010\u000b\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\b0\fH&R\u0012\u0010\u0004\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/hive/module/interfaces/authv4/provider/ProviderVk;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "vkClientId", "getVkClientId", "()Ljava/lang/String;", "login", "", "activity", "Landroid/app/Activity;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "Lcom/hive/module/interfaces/authv4/provider/ProviderVk$VkUser;", "Lkotlin/ParameterName;", "name", "user", "message", "VkUser", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ProviderVk extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(ProviderVk providerVk) {
            return HiveModuleName.INSTANCE.getAuthV4_Provider_Vk();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/hive/module/interfaces/authv4/provider/ProviderVk$VkUser;", "", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "name", "getName", "setName", "avatar", "getAvatar", "setAvatar", "email", "getEmail", "setEmail", "idToken", "getIdToken", "setIdToken", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VkUser {
        private String id = "";
        private String name = "";
        private String avatar = "";
        private String email = "";
        private String idToken = "";

        public final String getAvatar() {
            return this.avatar;
        }

        public final String getEmail() {
            return this.email;
        }

        public final String getId() {
            return this.id;
        }

        public final String getIdToken() {
            return this.idToken;
        }

        public final String getName() {
            return this.name;
        }

        public final void setAvatar(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.avatar = str;
        }

        public final void setEmail(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.email = str;
        }

        public final void setId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.id = str;
        }

        public final void setIdToken(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.idToken = str;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }

        public String toString() {
            return "VK User\n  id: " + this.id + "\n  name: " + this.name + "\n  avatar: " + this.avatar + "\n  email: " + this.email + "\n  idToken: " + this.idToken + '\n';
        }
    }

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    String getVkClientId();

    void login(Activity activity, Function2<? super VkUser, ? super String, Unit> listener);
}
