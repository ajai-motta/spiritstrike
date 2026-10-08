package com.hive.authv4.provider.facebook;

import android.app.Activity;
import android.net.Uri;
import com.facebook.FacebookSdk;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.hive.module.ModuleCheckName;
import com.hive.module.interfaces.authv4.provider.ProviderFacebook;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HiveModuleFacebook.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/hive/authv4/provider/facebook/HiveModuleFacebook;", "Lcom/hive/module/interfaces/authv4/provider/ProviderFacebook;", "<init>", "()V", "shareDialog", "", "activity", "Landroid/app/Activity;", "contentUrl", "Landroid/net/Uri;", ShareConstants.WEB_DIALOG_PARAM_HASHTAG, "", "getVersionInfo", "", "hive-authv4-provider-facebook_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveModuleFacebook implements ProviderFacebook {
    @Override // com.hive.module.interfaces.authv4.provider.ProviderFacebook, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return ProviderFacebook.DefaultImpls.getHiveModuleName(this);
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderFacebook
    public void shareDialog(Activity activity, Uri contentUrl, String hashtag) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(contentUrl, "contentUrl");
        Intrinsics.checkNotNullParameter(hashtag, "hashtag");
        if (ShareDialog.INSTANCE.canShow(ShareLinkContent.class)) {
            new ShareDialog(activity).show(new ShareLinkContent.Builder().setShareHashtag(new ShareHashtag.Builder().setHashtag(hashtag).build()).setContentUrl(contentUrl).build());
        }
    }

    @Override // com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        HashMap map = new HashMap();
        map.put(ModuleCheckName.INSTANCE.getHive_Authv4_Facebook(), "26.2.0");
        try {
            Result.Companion companion = Result.INSTANCE;
            map.put(ModuleCheckName.INSTANCE.getFacebook_Core(), FacebookSdk.getSdkVersion());
            Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            map.put(ModuleCheckName.INSTANCE.getFacebook_Common(), FacebookSdk.getSdkVersion());
            Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.m7415constructorimpl(ResultKt.createFailure(th2));
        }
        try {
            Result.Companion companion5 = Result.INSTANCE;
            map.put(ModuleCheckName.INSTANCE.getFacebook_Login(), FacebookSdk.getSdkVersion());
            Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th3) {
            Result.Companion companion6 = Result.INSTANCE;
            Result.m7415constructorimpl(ResultKt.createFailure(th3));
        }
        try {
            Result.Companion companion7 = Result.INSTANCE;
            map.put(ModuleCheckName.INSTANCE.getFacebook_Share(), FacebookSdk.getSdkVersion());
            Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th4) {
            Result.Companion companion8 = Result.INSTANCE;
            Result.m7415constructorimpl(ResultKt.createFailure(th4));
        }
        try {
            Result.Companion companion9 = Result.INSTANCE;
            map.put(ModuleCheckName.INSTANCE.getFacebook_Graphapi(), FacebookSdk.getGraphApiVersion());
            Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion10 = Result.INSTANCE;
            Result.m7415constructorimpl(ResultKt.createFailure(th5));
        }
        return map;
    }
}
