package com.applovin.impl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.vending.licensing.ILicensingService;
import com.android.vending.licensing.a;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes2.dex */
public class o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f533a;
    private final com.applovin.impl.sdk.o b;

    private static class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.applovin.impl.sdk.o f534a;
        private final t4 b;

        /* JADX INFO: renamed from: com.applovin.impl.o2$a$a, reason: collision with other inner class name */
        class BinderC0154a extends a.AbstractBinderC0137a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f535a;

            BinderC0154a(int i) {
                this.f535a = i;
            }

            @Override // com.android.vending.licensing.a
            public void a(int i, String str, String str2) {
                com.applovin.impl.sdk.o unused = a.this.f534a;
                if (com.applovin.impl.sdk.o.a()) {
                    a.this.f534a.a("LicenseVerificationManager", "Verified with code " + i);
                }
                a.this.a();
                a.this.b.b(p2.a().b(str).a(str2).b(i).a(this.f535a).a());
            }
        }

        public a(com.applovin.impl.sdk.o oVar, t4 t4Var) {
            this.f534a = oVar;
            this.b = t4Var;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (com.applovin.impl.sdk.o.a()) {
                this.f534a.a("LicenseVerificationManager", "License service connected: " + componentName);
            }
            ILicensingService iLicensingServiceA = ILicensingService.a.a(iBinder);
            try {
                int iNextInt = new SecureRandom().nextInt();
                iLicensingServiceA.a(iNextInt, com.applovin.impl.sdk.k.o().getPackageName(), new BinderC0154a(iNextInt));
            } catch (RemoteException e) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.f534a.a("LicenseVerificationManager", "Failed to check license", e);
                }
                a();
                this.b.a((Object) e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (com.applovin.impl.sdk.o.a()) {
                this.f534a.k("LicenseVerificationManager", "License service disconnected");
            }
            if (this.b.c()) {
                return;
            }
            this.b.a((Object) new IllegalStateException("License service disconnected"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            try {
                com.applovin.impl.sdk.k.o().unbindService(this);
            } catch (Exception e) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.f534a.d("LicenseVerificationManager", "Failed to unbind license service", e);
                }
            }
        }
    }

    public o2(com.applovin.impl.sdk.k kVar) {
        this.f533a = kVar;
        this.b = kVar.O();
    }

    public t4 a(long j) {
        t4 t4Var = new t4("verify_license");
        if (j > 0) {
            j6.a(j, t4Var, new Exception("License Verification Timed Out"), "verify_license_timeout", this.f533a);
        }
        try {
            Intent intent = new Intent(ILicensingService.class.getName());
            intent.setPackage("com.android.vending");
            if (!com.applovin.impl.sdk.k.o().bindService(intent, new a(this.b, t4Var), 1)) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.b.k("LicenseVerificationManager", "Failed to bind to the license service");
                }
                t4Var.a((Object) new Exception("Failed to bind to license service"));
            }
        } catch (Exception e) {
            if (com.applovin.impl.sdk.o.a()) {
                this.b.a("LicenseVerificationManager", "Failed to verify license", e);
            }
            t4Var.a((Object) e);
        }
        return t4Var;
    }
}
