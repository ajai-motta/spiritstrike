package com.moloco.sdk.acm.db;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b!\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/moloco/sdk/acm/db/MetricsDb;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Lcom/moloco/sdk/acm/db/d;", "b", "()Lcom/moloco/sdk/acm/db/d;", "a", "moloco-android-client-metrics_release"}, k = 1, mv = {2, 0, 0})
public abstract class MetricsDb extends RoomDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static volatile MetricsDb b = null;
    public static final String c = "MetricsDb";

    /* JADX INFO: renamed from: com.moloco.sdk.acm.db.MetricsDb$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MetricsDb a(Context context) {
            try {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                return (MetricsDb) Room.databaseBuilder(applicationContext, MetricsDb.class, "metrics-db").build();
            } catch (Exception e) {
                throw new IllegalStateException("Database creation failed", e);
            }
        }

        public final MetricsDb b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            MetricsDb metricsDb = MetricsDb.b;
            if (metricsDb == null) {
                synchronized (this) {
                    metricsDb = MetricsDb.b;
                    if (metricsDb == null) {
                        MetricsDb metricsDbA = MetricsDb.INSTANCE.a(context);
                        MetricsDb.b = metricsDbA;
                        metricsDb = metricsDbA;
                    }
                }
            }
            return metricsDb;
        }

        public Companion() {
        }
    }

    public abstract d b();
}
