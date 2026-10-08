package com.hive.core;

import android.content.Context;
import androidx.startup.Initializer;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HiveCoreInitializer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\t0\bH\u0016¨\u0006\u000b"}, d2 = {"Lcom/hive/core/HiveCoreInitializer;", "Landroidx/startup/Initializer;", "<init>", "()V", "create", "context", "Landroid/content/Context;", "dependencies", "", "Ljava/lang/Class;", k.M, "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveCoreInitializer implements Initializer<HiveCoreInitializer> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static Context initContext;

    /* JADX INFO: compiled from: HiveCoreInitializer.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\f¨\u0006\r"}, d2 = {"Lcom/hive/core/HiveCoreInitializer$Companion;", "", "<init>", "()V", "initContext", "Landroid/content/Context;", "getInitContext", "()Landroid/content/Context;", "setInitContext", "(Landroid/content/Context;)V", "isInitContextInitialized", "", "()Z", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Context getInitContext() {
            Context context = HiveCoreInitializer.initContext;
            if (context != null) {
                return context;
            }
            Intrinsics.throwUninitializedPropertyAccessException("initContext");
            return null;
        }

        public final void setInitContext(Context context) {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            HiveCoreInitializer.initContext = context;
        }

        public final boolean isInitContextInitialized() {
            return HiveCoreInitializer.initContext != null;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public HiveCoreInitializer create(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        INSTANCE.setInitContext(context.getApplicationContext());
        Logger.coreLog$hive_core_release$default(Logger.INSTANCE, "HiveCoreInitializer created.", null, 2, null);
        return this;
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return CollectionsKt.emptyList();
    }
}
