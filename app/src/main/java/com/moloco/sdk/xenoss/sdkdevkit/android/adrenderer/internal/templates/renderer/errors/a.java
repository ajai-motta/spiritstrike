package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a extends g {
    public static final int j = 0;
    public final String i;

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a$a, reason: collision with other inner class name */
    public static final class C0462a extends a {
        public static final C0462a k = new C0462a();
        public static final int l = 0;

        public C0462a() {
            super("net::ERR_CERT_AUTHORITY_INVALID", null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof C0462a);
        }

        public int hashCode() {
            return -932810174;
        }

        public String toString() {
            return "ERR_CERT_AUTHORITY_INVALID";
        }
    }

    public /* synthetic */ a(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.g
    public String c() {
        return this.i;
    }

    public a(String str) {
        super(0, str, false, true, false, 16, null);
        this.i = str;
    }
}
