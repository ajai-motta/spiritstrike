package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.applovin.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o1 extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private q1 f532a;
    private com.applovin.impl.sdk.k b;
    private TextView c;
    private Button d;

    private void b() {
        v2 v2Var = new v2();
        v2Var.a(this.b.y().a(this.f532a));
        String strB = this.b.y().b(this.f532a);
        if (strB != null) {
            v2Var.a("\nBid Response Preview:\n");
            v2Var.a(strB);
        }
        TextView textView = (TextView) findViewById(R.id.email_report_tv);
        this.c = textView;
        textView.setText(v2Var.toString());
        this.c.setTextColor(-16777216);
    }

    public void a(q1 q1Var, com.applovin.impl.sdk.k kVar) {
        this.f532a = q1Var;
        this.b = kVar;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!a()) {
            finish();
            return;
        }
        setTitle(this.f532a.d() + " - " + this.f532a.f());
        setContentView(R.layout.creative_debugger_displayed_ad_detail_activity);
        b();
        f8.a(findViewById(android.R.id.content), this.b);
        Button button = (Button) findViewById(R.id.report_ad_button);
        this.d = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.o1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.creative_debugger_displayed_ad_activity_menu, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (!a()) {
            finish();
            return false;
        }
        if (R.id.action_share != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.b.y().a(this.f532a, (Context) this, false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.b.y().a(this.f532a, (Context) this, true);
    }

    private boolean a() {
        return (this.f532a == null || this.b == null) ? false : true;
    }
}
