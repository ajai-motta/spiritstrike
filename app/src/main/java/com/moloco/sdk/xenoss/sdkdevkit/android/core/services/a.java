package com.moloco.sdk.xenoss.sdkdevkit.android.core.services;

import com.fyber.inneractive.sdk.external.NativeAdContent;
import java.util.List;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public interface a {

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0526a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f3031a = 0;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$a, reason: collision with other inner class name */
        public static final class C0527a extends AbstractC0526a {
            public static final C0527a b = new C0527a();
            public static final int c = 0;

            public C0527a() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$b */
        public static final class b extends AbstractC0526a {
            public static final int c = 0;
            public final long b;

            public b(long j) {
                super(null);
                this.b = j;
            }

            public final long a() {
                return this.b;
            }

            public final long b() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && this.b == ((b) obj).b;
            }

            public int hashCode() {
                return UByte$$ExternalSyntheticBackport0.m(this.b);
            }

            public String toString() {
                return "AppForeground(lastBgTimestamp=" + this.b + ')';
            }

            public final b a(long j) {
                return new b(j);
            }

            public static /* synthetic */ b a(b bVar, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = bVar.b;
                }
                return bVar.a(j);
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$c */
        public static final class c {
            public static final int d = 0;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final EnumC0528a f3032a;
            public final f b;
            public final g c;

            /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
            /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$c$a, reason: collision with other inner class name */
            public static final class EnumC0528a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final EnumC0528a f3033a = new EnumC0528a("NONE", 0);
                public static final EnumC0528a b = new EnumC0528a("CLOSE", 1);
                public static final EnumC0528a c = new EnumC0528a("SKIP", 2);
                public static final EnumC0528a d = new EnumC0528a("SKIP_DEC", 3);
                public static final EnumC0528a e = new EnumC0528a("MUTE", 4);
                public static final EnumC0528a f = new EnumC0528a("UNMUTE", 5);
                public static final EnumC0528a g = new EnumC0528a(NativeAdContent.ViewTag.CTA, 6);
                public static final EnumC0528a h = new EnumC0528a("REPLAY", 7);
                public static final EnumC0528a i = new EnumC0528a("AD_BADGE", 8);
                public static final /* synthetic */ EnumC0528a[] j;
                public static final /* synthetic */ EnumEntries k;

                static {
                    EnumC0528a[] enumC0528aArrA = a();
                    j = enumC0528aArrA;
                    k = EnumEntriesKt.enumEntries(enumC0528aArrA);
                }

                public EnumC0528a(String str, int i2) {
                }

                public static final /* synthetic */ EnumC0528a[] a() {
                    return new EnumC0528a[]{f3033a, b, c, d, e, f, g, h, i};
                }

                public static EnumEntries<EnumC0528a> b() {
                    return k;
                }

                public static EnumC0528a valueOf(String str) {
                    return (EnumC0528a) Enum.valueOf(EnumC0528a.class, str);
                }

                public static EnumC0528a[] values() {
                    return (EnumC0528a[]) j.clone();
                }
            }

            public c(EnumC0528a buttonType, f position, g size) {
                Intrinsics.checkNotNullParameter(buttonType, "buttonType");
                Intrinsics.checkNotNullParameter(position, "position");
                Intrinsics.checkNotNullParameter(size, "size");
                this.f3032a = buttonType;
                this.b = position;
                this.c = size;
            }

            public final EnumC0528a a() {
                return this.f3032a;
            }

            public final f b() {
                return this.b;
            }

            public final g c() {
                return this.c;
            }

            public final EnumC0528a d() {
                return this.f3032a;
            }

            public final f e() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                return this.f3032a == cVar.f3032a && Intrinsics.areEqual(this.b, cVar.b) && Intrinsics.areEqual(this.c, cVar.c);
            }

            public final g f() {
                return this.c;
            }

            public int hashCode() {
                return (((this.f3032a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
            }

            public String toString() {
                return "Button(buttonType=" + this.f3032a + ", position=" + this.b + ", size=" + this.c + ')';
            }

            public final c a(EnumC0528a buttonType, f position, g size) {
                Intrinsics.checkNotNullParameter(buttonType, "buttonType");
                Intrinsics.checkNotNullParameter(position, "position");
                Intrinsics.checkNotNullParameter(size, "size");
                return new c(buttonType, position, size);
            }

            public static /* synthetic */ c a(c cVar, EnumC0528a enumC0528a, f fVar, g gVar, int i, Object obj) {
                if ((i & 1) != 0) {
                    enumC0528a = cVar.f3032a;
                }
                if ((i & 2) != 0) {
                    fVar = cVar.b;
                }
                if ((i & 4) != 0) {
                    gVar = cVar.c;
                }
                return cVar.a(enumC0528a, fVar, gVar);
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$e */
        public static final class e extends AbstractC0526a {
            public static final e b = new e();
            public static final int c = 0;

            public e() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$f */
        public static final class f {
            public static final int c = 0;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final float f3034a;
            public final float b;

            public f(float f, float f2) {
                this.f3034a = f;
                this.b = f2;
            }

            public final float a() {
                return this.f3034a;
            }

            public final float b() {
                return this.b;
            }

            public final float c() {
                return this.f3034a;
            }

            public final float d() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof f)) {
                    return false;
                }
                f fVar = (f) obj;
                return Float.compare(this.f3034a, fVar.f3034a) == 0 && Float.compare(this.b, fVar.b) == 0;
            }

            public int hashCode() {
                return (Float.floatToIntBits(this.f3034a) * 31) + Float.floatToIntBits(this.b);
            }

            public String toString() {
                return "Position(topLeftXDp=" + this.f3034a + ", topLeftYDp=" + this.b + ')';
            }

            public final f a(float f, float f2) {
                return new f(f, f2);
            }

            public static /* synthetic */ f a(f fVar, float f, float f2, int i, Object obj) {
                if ((i & 1) != 0) {
                    f = fVar.f3034a;
                }
                if ((i & 2) != 0) {
                    f2 = fVar.b;
                }
                return fVar.a(f, f2);
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$g */
        public static final class g {
            public static final int c = 0;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final float f3035a;
            public final float b;

            public g(float f, float f2) {
                this.f3035a = f;
                this.b = f2;
            }

            public final float a() {
                return this.f3035a;
            }

            public final float b() {
                return this.b;
            }

            public final float c() {
                return this.b;
            }

            public final float d() {
                return this.f3035a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof g)) {
                    return false;
                }
                g gVar = (g) obj;
                return Float.compare(this.f3035a, gVar.f3035a) == 0 && Float.compare(this.b, gVar.b) == 0;
            }

            public int hashCode() {
                return (Float.floatToIntBits(this.f3035a) * 31) + Float.floatToIntBits(this.b);
            }

            public String toString() {
                return "Size(widthDp=" + this.f3035a + ", heightDp=" + this.b + ')';
            }

            public final g a(float f, float f2) {
                return new g(f, f2);
            }

            public static /* synthetic */ g a(g gVar, float f, float f2, int i, Object obj) {
                if ((i & 1) != 0) {
                    f = gVar.f3035a;
                }
                if ((i & 2) != 0) {
                    f2 = gVar.b;
                }
                return gVar.a(f, f2);
            }
        }

        public /* synthetic */ AbstractC0526a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$d */
        public static final class d extends AbstractC0526a {
            public static final int f = 8;
            public final f b;
            public final f c;
            public final g d;
            public final List<c> e;

            public /* synthetic */ d(f fVar, f fVar2, g gVar, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(fVar, (i & 2) != 0 ? null : fVar2, (i & 4) != 0 ? null : gVar, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
            }

            public final List<c> a() {
                return this.e;
            }

            public final f b() {
                return this.b;
            }

            public final f c() {
                return this.c;
            }

            public final g d() {
                return this.d;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(f clickPosition, f fVar, g gVar, List<c> buttonLayout) {
                super(null);
                Intrinsics.checkNotNullParameter(clickPosition, "clickPosition");
                Intrinsics.checkNotNullParameter(buttonLayout, "buttonLayout");
                this.b = clickPosition;
                this.c = fVar;
                this.d = gVar;
                this.e = buttonLayout;
            }
        }

        public AbstractC0526a() {
        }
    }

    Object a(long j, AbstractC0526a abstractC0526a, String str, Continuation<? super String> continuation);
}
