package com.moloco.sdk.internal.ilrd;

import com.moloco.sdk.IlrdRequest;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes6.dex */
public interface c {

    public interface a {

        /* JADX INFO: renamed from: com.moloco.sdk.internal.ilrd.c$a$a, reason: collision with other inner class name */
        public static final class C0385a implements a {
            public static final int b = 0;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IlrdRequest.LevelPlayImpression f2077a;

            public C0385a(IlrdRequest.LevelPlayImpression impression) {
                Intrinsics.checkNotNullParameter(impression, "impression");
                this.f2077a = impression;
            }

            public final IlrdRequest.LevelPlayImpression a() {
                return this.f2077a;
            }

            public final IlrdRequest.LevelPlayImpression b() {
                return this.f2077a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0385a) && Intrinsics.areEqual(this.f2077a, ((C0385a) obj).f2077a);
            }

            public int hashCode() {
                return this.f2077a.hashCode();
            }

            public String toString() {
                return "LevelPlay(impression=" + this.f2077a + ')';
            }

            public final C0385a a(IlrdRequest.LevelPlayImpression impression) {
                Intrinsics.checkNotNullParameter(impression, "impression");
                return new C0385a(impression);
            }

            public static /* synthetic */ C0385a a(C0385a c0385a, IlrdRequest.LevelPlayImpression levelPlayImpression, int i, Object obj) {
                if ((i & 1) != 0) {
                    levelPlayImpression = c0385a.f2077a;
                }
                return c0385a.a(levelPlayImpression);
            }
        }

        public static final class b implements a {
            public static final int b = 0;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IlrdRequest.MaxImpression f2078a;

            public b(IlrdRequest.MaxImpression impression) {
                Intrinsics.checkNotNullParameter(impression, "impression");
                this.f2078a = impression;
            }

            public final IlrdRequest.MaxImpression a() {
                return this.f2078a;
            }

            public final IlrdRequest.MaxImpression b() {
                return this.f2078a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && Intrinsics.areEqual(this.f2078a, ((b) obj).f2078a);
            }

            public int hashCode() {
                return this.f2078a.hashCode();
            }

            public String toString() {
                return "Max(impression=" + this.f2078a + ')';
            }

            public final b a(IlrdRequest.MaxImpression impression) {
                Intrinsics.checkNotNullParameter(impression, "impression");
                return new b(impression);
            }

            public static /* synthetic */ b a(b bVar, IlrdRequest.MaxImpression maxImpression, int i, Object obj) {
                if ((i & 1) != 0) {
                    maxImpression = bVar.f2078a;
                }
                return bVar.a(maxImpression);
            }
        }
    }

    com.moloco.sdk.internal.ilrd.model.a a();

    Object b();

    SharedFlow<a> c();

    StateFlow<g> getState();
}
