package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.net.Uri;
import android.text.TextUtils;
import com.moloco.sdk.internal.v;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
public abstract class n {
    public static final b b = new b(null);
    public static final int c = 0;
    public static final String d = "close";
    public static final String e = "expand";
    public static final String f = "open";
    public static final String g = "resize";
    public static final String h = "setOrientationProperties";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2587a;

    public static final class a extends n {
        public static final a i = new a();
        public static final int j = 0;

        public a() {
            super("close", null);
        }
    }

    public static final class b {

        public static final class a {
            public static final int c = 0;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final boolean f2588a;
            public final String b;

            public a(boolean z, String description) {
                Intrinsics.checkNotNullParameter(description, "description");
                this.f2588a = z;
                this.b = description;
            }

            public final String a() {
                return this.b;
            }

            public final boolean b() {
                return this.f2588a;
            }
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a() {
            return null;
        }

        public final d b(Map<String, String> map) {
            Object objM7415constructorimpl;
            String str = map.get("url");
            if (str == null) {
                return null;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                Uri uri = Uri.parse(str);
                Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
                objM7415constructorimpl = Result.m7415constructorimpl(new d(uri));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            return (d) (Result.m7421isFailureimpl(objM7415constructorimpl) ? null : objM7415constructorimpl);
        }

        public final f c(Map<String, String> map) {
            Boolean booleanStrictOrNull;
            String str = map.get("allowOrientationChange");
            if (str == null || (booleanStrictOrNull = StringsKt.toBooleanStrictOrNull(str)) == null) {
                return null;
            }
            boolean zBooleanValue = booleanStrictOrNull.booleanValue();
            p pVarA = p.f2589a.a(map.get("forceOrientation"));
            if (pVarA == null) {
                return null;
            }
            return new f(zBooleanValue, pVarA);
        }

        public b() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final com.moloco.sdk.internal.v<n, a> a(String str) {
            Object objM7415constructorimpl;
            try {
                Result.Companion companion = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(Uri.parse(str));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            Object objA = null;
            if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
                objM7415constructorimpl = null;
            }
            Uri uri = (Uri) objM7415constructorimpl;
            if (uri == null) {
                return new v.a(new a(false, "Invalid url: " + str));
            }
            if (!Intrinsics.areEqual(uri.getScheme(), "mraid")) {
                return new v.a(new a(false, "Non-mraid url scheme: " + str));
            }
            Map<String, String> mapA = a(uri);
            String host = uri.getHost();
            if (host != null) {
                switch (host.hashCode()) {
                    case -1289167206:
                        if (host.equals(n.e)) {
                            objA = a(mapA);
                        }
                        break;
                    case -934437708:
                        if (host.equals(n.g)) {
                            objA = a();
                        }
                        break;
                    case 3417674:
                        if (host.equals("open")) {
                            objA = b(mapA);
                        }
                        break;
                    case 94756344:
                        if (host.equals("close")) {
                            objA = a.i;
                        }
                        break;
                    case 133423073:
                        if (host.equals(n.h)) {
                            objA = c(mapA);
                        }
                        break;
                }
            }
            if (objA != null) {
                return new v.b(objA);
            }
            return new v.a(new a(true, "Unknown/unsupported mraid command " + uri.getHost()));
        }

        public final c a(Map<String, String> map) {
            Object objM7415constructorimpl;
            String str = map.get("url");
            Uri uri = null;
            if (str != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM7415constructorimpl = Result.m7415constructorimpl(Uri.parse(str));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
                uri = (Uri) (Result.m7421isFailureimpl(objM7415constructorimpl) ? null : objM7415constructorimpl);
            }
            return new c(uri);
        }

        public final Map<String, String> a(Uri uri) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : uri.getQueryParameterNames()) {
                linkedHashMap.put(str, TextUtils.join(",", uri.getQueryParameters(str)));
            }
            return linkedHashMap;
        }
    }

    public static final class c extends n {
        public static final int j = 8;
        public final Uri i;

        public c(Uri uri) {
            super(n.e, null);
            this.i = uri;
        }

        public final Uri b() {
            return this.i;
        }
    }

    public static final class d extends n {
        public static final int j = 8;
        public final Uri i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Uri uri) {
            super("open", null);
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.i = uri;
        }

        public final Uri b() {
            return this.i;
        }
    }

    public static final class e extends n {
        public static final int n = 0;
        public final int i;
        public final int j;
        public final int k;
        public final int l;
        public final boolean m;

        public e(int i, int i2, int i3, int i4, boolean z) {
            super(n.g, null);
            this.i = i;
            this.j = i2;
            this.k = i3;
            this.l = i4;
            this.m = z;
        }

        public final boolean b() {
            return this.m;
        }

        public final int c() {
            return this.j;
        }

        public final int d() {
            return this.k;
        }

        public final int e() {
            return this.l;
        }

        public final int f() {
            return this.i;
        }
    }

    public static final class f extends n {
        public static final int k = 0;
        public final boolean i;
        public final p j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(boolean z, p forceOrientation) {
            super(n.h, null);
            Intrinsics.checkNotNullParameter(forceOrientation, "forceOrientation");
            this.i = z;
            this.j = forceOrientation;
        }

        public final boolean b() {
            return this.i;
        }

        public final p c() {
            return this.j;
        }
    }

    public /* synthetic */ n(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public final String a() {
        return this.f2587a;
    }

    public n(String str) {
        this.f2587a = str;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.b a(f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.b(q.a(fVar.c()), fVar.b());
    }
}
