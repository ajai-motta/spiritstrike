package com.applovin.impl;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.d;
import com.applovin.impl.e3;
import com.applovin.impl.g3;
import com.applovin.impl.s2;
import com.applovin.mediation.MaxDebuggerMultiAdActivity;
import com.applovin.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f3 extends n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g3 f383a;
    private ListView b;

    class a implements s2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e3 f384a;

        /* JADX INFO: renamed from: com.applovin.impl.f3$a$a, reason: collision with other inner class name */
        class C0148a implements d.b {
            C0148a() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerMultiAdActivity maxDebuggerMultiAdActivity) {
                maxDebuggerMultiAdActivity.initialize(a.this.f384a);
            }
        }

        a(e3 e3Var) {
            this.f384a = e3Var;
        }

        @Override // com.applovin.impl.s2.a
        public void a(j2 j2Var, r2 r2Var) {
            if (j2Var.b() != g3.a.TEST_ADS.ordinal()) {
                o7.a(r2Var.c(), r2Var.b(), f3.this);
                return;
            }
            com.applovin.impl.sdk.k kVarO = this.f384a.o();
            e3.b bVarY = this.f384a.y();
            if (!f3.this.f383a.a(j2Var)) {
                o7.a(r2Var.c(), r2Var.b(), f3.this);
                return;
            }
            if (e3.b.READY == bVarY) {
                d.a(f3.this, MaxDebuggerMultiAdActivity.class, kVarO.e(), new C0148a());
            } else if (e3.b.DISABLED != bVarY) {
                o7.a(r2Var.c(), r2Var.b(), f3.this);
            } else {
                kVarO.t0().a();
                o7.a(r2Var.c(), r2Var.b(), f3.this);
            }
        }
    }

    public f3() {
        this.communicatorTopics.add("adapter_initialization_status");
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    @Override // com.applovin.impl.n3
    protected com.applovin.impl.sdk.k getSdk() {
        g3 g3Var = this.f383a;
        if (g3Var != null) {
            return g3Var.h().o();
        }
        return null;
    }

    public void initialize(e3 e3Var) {
        setTitle(e3Var.g());
        g3 g3Var = new g3(e3Var, this);
        this.f383a = g3Var;
        g3Var.a(new a(e3Var));
    }

    @Override // com.applovin.impl.n3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.b = listView;
        listView.setAdapter((ListAdapter) this.f383a);
    }

    @Override // com.applovin.impl.n3, com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if (this.f383a.h().b().equals(appLovinCommunicatorMessage.getMessageData().getString("adapter_class", ""))) {
            this.f383a.k();
            this.f383a.c();
        }
    }
}
