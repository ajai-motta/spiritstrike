package com.fyber.inneractive.sdk.config.global;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f946a;
    public final boolean b;

    public f(boolean z, String str) {
        this.f946a = str;
        this.b = z;
    }

    @Override // com.fyber.inneractive.sdk.config.global.d
    public final boolean a(e eVar) {
        String str = this.f946a;
        if (str != null) {
            return str.equalsIgnoreCase("android") ? !this.b : this.b;
        }
        return false;
    }

    public final String toString() {
        return "os - " + this.f946a + " include: " + this.b;
    }
}
