package com.fyber.inneractive.sdk.player.controller;

import android.view.View;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.util.g1;

/* JADX INFO: loaded from: classes3.dex */
public interface g0 extends com.fyber.inneractive.sdk.ui.controller.c {
    com.fyber.inneractive.sdk.util.d0 a(g1 g1Var, com.fyber.inneractive.sdk.util.g gVar);

    com.fyber.inneractive.sdk.util.d0 a(String str, g1 g1Var, boolean z);

    void a(View view);

    void a(View view, String str);

    void a(String str, String str2);

    void a(boolean z);

    void a(boolean z, Orientation orientation);

    void d();

    void f();

    void g();

    void i();

    void j();

    void k();

    void onCompleted();

    void onPlayerError();

    void onProgress(int i, int i2);

    com.fyber.inneractive.sdk.ignite.m p();
}
