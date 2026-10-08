package com.moloco.sdk.internal.publisher;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C2992c {
    public static final int c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<s, Duration> f2171a;
    public final long b;

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.c$a */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2172a;

        static {
            int[] iArr = new int[s.values().length];
            try {
                iArr[s.f2249a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[s.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[s.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[s.f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[s.g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[s.e.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[s.d.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f2172a = iArr;
        }
    }

    public /* synthetic */ C2992c(Map map, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, j);
    }

    public final Map<s, Duration> a() {
        return this.f2171a;
    }

    public final long b() {
        return this.b;
    }

    public final Map<s, Duration> c() {
        return this.f2171a;
    }

    public final long d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2992c)) {
            return false;
        }
        C2992c c2992c = (C2992c) obj;
        return Intrinsics.areEqual(this.f2171a, c2992c.f2171a) && Duration.m8784equalsimpl0(this.b, c2992c.b);
    }

    public int hashCode() {
        return (this.f2171a.hashCode() * 31) + Duration.m8800hashCodeimpl(this.b);
    }

    public String toString() {
        return "AdCreatorConfiguration(adTimeouts=" + this.f2171a + ", defaultTimeoutDuration=" + ((Object) Duration.m8819toStringimpl(this.b)) + ')';
    }

    public C2992c(Map<s, Duration> adTimeouts, long j) {
        Intrinsics.checkNotNullParameter(adTimeouts, "adTimeouts");
        this.f2171a = adTimeouts;
        this.b = j;
    }

    public final C2992c a(Map<s, Duration> adTimeouts, long j) {
        Intrinsics.checkNotNullParameter(adTimeouts, "adTimeouts");
        return new C2992c(adTimeouts, j, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ C2992c a(C2992c c2992c, Map map, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            map = c2992c.f2171a;
        }
        if ((i & 2) != 0) {
            j = c2992c.b;
        }
        return c2992c.a(map, j);
    }

    public /* synthetic */ C2992c(Map map, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long duration;
        if ((i & 1) != 0) {
            s[] sVarArrValues = s.values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(sVarArrValues.length), 16));
            for (s sVar : sVarArrValues) {
                switch (a.f2172a[sVar.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        duration = DurationKt.toDuration(5, DurationUnit.SECONDS);
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        duration = DurationKt.toDuration(15, DurationUnit.SECONDS);
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                linkedHashMap.put(sVar, Duration.m8777boximpl(duration));
            }
            map = linkedHashMap;
        }
        this(map, (i & 2) != 0 ? DurationKt.toDuration(5, DurationUnit.SECONDS) : j, null);
    }
}
