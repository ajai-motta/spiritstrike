package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors;

import com.google.common.annotations.VisibleForTesting;
import com.hive.core.Configuration;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.c;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.d;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.e;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.f;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.j;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.k;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes6.dex */
public abstract class g {
    public static final int g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2654a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public static final a f = new a(null);
    public static final Lazy<Map<String, g>> h = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.g$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return g.b();
        }
    });

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void b() {
        }

        public final Map<String, g> a() {
            return (Map) g.h.getValue();
        }

        public a() {
        }

        public final g a(String description) {
            Intrinsics.checkNotNullParameter(description, "description");
            g gVar = a().get(description);
            return gVar == null ? b.i : gVar;
        }
    }

    public static final class b extends g {
        public static final b i = new b();
        public static final int j = 0;

        public b() {
            super(Integer.MIN_VALUE, Configuration.HIVE_COUNTRY_DEFAULT, false, true, false, 16, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -2068672870;
        }

        public String toString() {
            return "UndocumentedTemplateError";
        }
    }

    public /* synthetic */ g(int i, String str, boolean z, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, z, z2, z3);
    }

    public static final Map b() {
        List listListOf = CollectionsKt.listOf((Object[]) new g[]{a.C0462a.k, k.c.l, k.a.l, k.b.l, k.d.l, k.e.l, k.f.l, k.g.l, c.C0464c.k, c.b.k, c.a.k, d.a.k, b.a.k, b.c.k, b.d.k, b.C0463b.k, b.e.k, i.a.k, i.b.k, e.a.k, j.a.k, f.a.k, f.b.k, f.c.k});
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listListOf, 10)), 16));
        for (Object obj : listListOf) {
            linkedHashMap.put(((g) obj).c(), obj);
        }
        return linkedHashMap;
    }

    public String c() {
        return this.b;
    }

    public final int d() {
        return this.f2654a;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.c;
    }

    public boolean g() {
        return this.d;
    }

    public g(int i, String str, boolean z, boolean z2, boolean z3) {
        this.f2654a = i;
        this.b = str;
        this.c = z;
        this.d = z2;
        this.e = z3;
    }

    public /* synthetic */ g(int i, String str, boolean z, boolean z2, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, z, z2, (i2 & 16) != 0 ? false : z3, null);
    }
}
