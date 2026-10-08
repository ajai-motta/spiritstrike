package com.moloco.sdk.internal.services.encryption;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes6.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0408a f2344a = C0408a.f2345a;

    /* JADX INFO: renamed from: com.moloco.sdk.internal.services.encryption.a$a, reason: collision with other inner class name */
    public static final class C0408a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C0408a f2345a = new C0408a();

        public final a a() {
            return new com.moloco.sdk.internal.services.encryption.b();
        }
    }

    public static final class b {
        public static /* synthetic */ void a() {
        }

        public static /* synthetic */ void b() {
        }
    }

    String a(byte[] bArr, byte[] bArr2);

    IvParameterSpec a();

    byte[] a(String str);

    byte[] a(byte[] bArr);

    byte[] a(byte[] bArr, String str);

    String b(byte[] bArr);

    SecretKeySpec b();

    byte[] b(byte[] bArr, String str);
}
