package com.digitalturbine.ignite.authenticator.decorator;

import android.content.ComponentName;
import android.content.Context;
import android.os.IBinder;
import com.digitalturbine.ignite.authenticator.listeners.api.AuthenticationServiceListener;
import com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f850a;
    public AuthenticationServiceListener b;

    public f(a aVar, AuthenticationServiceListener authenticationServiceListener) {
        this.f850a = aVar;
        this.b = authenticationServiceListener;
        aVar.b(this);
        aVar.a(this);
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public boolean a() {
        return this.f850a.a();
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public void b() {
        this.f850a.b();
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public boolean c() {
        return this.f850a.c();
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public String d() {
        return null;
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public void destroy() {
        this.b = null;
        this.f850a.destroy();
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final String e() {
        return this.f850a.e();
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public boolean f() {
        return this.f850a.f();
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public Context g() {
        return this.f850a.g();
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public boolean h() {
        return this.f850a.h();
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public String i() {
        return null;
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public boolean j() {
        return false;
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public IIgniteServiceAPI k() {
        return this.f850a.k();
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public void l() {
        this.f850a.l();
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.api.a
    public void onCredentialsRequestFailed(String str) {
        this.f850a.onCredentialsRequestFailed(str);
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.api.a
    public void onCredentialsRequestSuccess(String str, String str2) {
        this.f850a.onCredentialsRequestSuccess(str, str2);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f850a.onServiceConnected(componentName, iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f850a.onServiceDisconnected(componentName);
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public void a(String str) {
        AuthenticationServiceListener authenticationServiceListener = this.b;
        if (authenticationServiceListener != null) {
            authenticationServiceListener.onIgniteServiceAuthenticationFailed(str);
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public void b(String str) {
        AuthenticationServiceListener authenticationServiceListener = this.b;
        if (authenticationServiceListener != null) {
            authenticationServiceListener.onIgniteServiceConnectionFailed(str);
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public void c(String str) {
        AuthenticationServiceListener authenticationServiceListener = this.b;
        if (authenticationServiceListener != null) {
            authenticationServiceListener.onIgniteServiceAuthenticated(str);
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public void a(ComponentName componentName, IBinder iBinder) {
        AuthenticationServiceListener authenticationServiceListener = this.b;
        if (authenticationServiceListener != null) {
            authenticationServiceListener.onIgniteServiceConnected(componentName, iBinder);
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final void b(a aVar) {
        this.f850a.b(aVar);
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final void a(a aVar) {
        this.f850a.a(aVar);
    }
}
