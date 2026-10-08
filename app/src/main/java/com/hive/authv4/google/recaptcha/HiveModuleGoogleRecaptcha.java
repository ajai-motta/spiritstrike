package com.hive.authv4.google.recaptcha;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.HiveActivity;
import com.hive.logger.LoggerImpl;
import com.hive.module.ModuleCheckName;
import com.hive.module.interfaces.authv4.GoogleRecaptcha;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HiveModuleGoogleRecaptcha.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00050\u0007H\u0017J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/hive/authv4/google/recaptcha/HiveModuleGoogleRecaptcha;", "Lcom/hive/module/interfaces/authv4/GoogleRecaptcha;", "<init>", "()V", "executeRecaptcha", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "", "", "getVersionInfo", "", "hive-authv4-google-recaptcha_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveModuleGoogleRecaptcha implements GoogleRecaptcha {
    @Override // com.hive.module.interfaces.authv4.GoogleRecaptcha, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return GoogleRecaptcha.DefaultImpls.getHiveModuleName(this);
    }

    @Override // com.hive.module.interfaces.authv4.GoogleRecaptcha
    public void executeRecaptcha(final Function2<? super Integer, ? super String, Unit> listener) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(listener, "listener");
        try {
            Result.Companion companion = Result.INSTANCE;
            Class.forName("com.google.android.recaptcha.Recaptcha");
            Recaptcha.INSTANCE.execute(new Function2() { // from class: com.hive.authv4.google.recaptcha.HiveModuleGoogleRecaptcha$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HiveModuleGoogleRecaptcha.executeRecaptcha$lambda$1$lambda$0(listener, ((Integer) obj).intValue(), (String) obj2);
                }
            });
            objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w("Execute Recaptcha failed: " + thM7418exceptionOrNullimpl);
            listener.invoke(-4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit executeRecaptcha$lambda$1$lambda$0(Function2 function2, int i, String str) {
        function2.invoke(Integer.valueOf(i), str);
        return Unit.INSTANCE;
    }

    @Override // com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        HashMap map = new HashMap();
        map.put(ModuleCheckName.INSTANCE.getHive_Authv4_Google_Recaptcha(), "26.2.0");
        try {
            Result.Companion companion = Result.INSTANCE;
            Properties properties = new Properties();
            properties.load(HiveActivity.INSTANCE.getRecentActivity().getClassLoader().getResourceAsStream("recaptcha.properties"));
            map.put(ModuleCheckName.INSTANCE.getPlay_Services_Recaptcha(), properties.getProperty("version"));
            Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        return map;
    }
}
