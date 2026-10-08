package com.inca.security.Proxy;

import android.app.ZygotePreload;
import android.content.pm.ApplicationInfo;

/* JADX INFO: loaded from: classes.dex */
public class AppGuardPreload implements ZygotePreload {
    @Override // android.app.ZygotePreload
    public void doPreload(ApplicationInfo appInfo) {
        try {
            System.loadLibrary("compatible");
        } catch (UnsatisfiedLinkError unused) {
        }
    }
}
