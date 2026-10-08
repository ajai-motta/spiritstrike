package com.tnkfactory.ad.pub;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.tnkfactory.ad.AdError;
import com.tnkfactory.ad.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class c {
    public final String A;
    public final ArrayList B;
    public final ArrayList C;
    public boolean D;
    public final int E;
    public final int F;
    public final boolean G;
    public final String H;
    public final String I;
    public final String J;
    public final JSONArray K;
    public final String L;
    public final int M;
    public final int N;
    public final int O;
    public final boolean P;
    public final int Q;
    public final long R;
    public final long S;
    public final long T;
    public final String U;
    public final String V;
    public final int W;
    public final boolean X;
    public final int Y;
    public final int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3114a;
    public final String b;
    public final String c;
    public final String d;
    public final JSONObject d0;
    public final String e;
    public final JSONObject e0;
    public final int f;
    public final int f0;
    public final String g;
    public final int h;
    public final long i;
    public final int i0;
    public String j;
    public final z1 j0;
    public final String k;
    public final ArrayList k0;
    public final String l;
    public final String l0;
    public final int m;
    public final String m0;
    public final int n;
    public final ArrayList n0;
    public final String o;
    public final ArrayList o0;
    public final String p;
    public final a0 p0;
    public final String q;
    public final r4 q0;
    public final String r;
    public final c r0;
    public final String s;
    public final String s0;
    public final String t;
    public final String u;
    public final float v;
    public final String w;
    public final String x;
    public final String y;
    public final String z;
    public int b0 = 0;
    public int c0 = 0;
    public final HashMap g0 = new HashMap();
    public l0 h0 = null;
    public final long a0 = System.currentTimeMillis();

    /* JADX WARN: Can't wrap try/catch for region: R(42:103|(1:105)|106|(1:108)(1:109)|110|(1:112)(2:113|(3:115|(1:117)|391)(2:118|(3:120|(2:123|121)|392)(2:124|(3:126|(1:128)|393)(1:129))))|130|(1:132)(2:134|(3:136|(1:138)|388)(2:139|(3:141|(2:144|142)|389)(2:145|(3:147|(1:149)|390)(34:150|151|(3:153|362|154)|158|(3:160|(6:163|(4:369|165|(2:167|168)|381)|169|(4:367|171|(2:173|174)|380)(1:379)|175|161)|378)|(3:177|365|178)|(2:185|(1:187)(2:188|(3:190|(1:192)|382)(2:193|(3:195|(2:198|196)|383)(2:199|(3:201|(1:203)|384)))))|(2:207|(1:209)(2:210|(3:212|(1:214)|385)(2:215|(3:217|(2:220|218)|386)(2:221|(3:223|(1:225)|387)))))|226|(2:373|230)|375|234|(4:236|(2:238|(2:240|(1:244)(1:243))(1:245))(1:246)|(1:248)(1:249)|(13:251|308|(2:312|(2:314|419)(2:315|(1:317)))|318|(1:322)|323|(1:327)|328|(4:371|330|(1:332)(2:333|(1:335))|338)|339|(1:350)(2:343|(2:345|420)(2:346|(1:348)(1:349)))|351|(2:353|421)(2:354|422))(1:252))(1:253)|360|254|255|376|256|364|259|(4:261|(2:263|(2:265|(1:(2:268|(1:270)(1:(1:275)(1:274)))(1:277))(2:278|(1:283)(1:282)))(2:284|(1:289)(1:288)))(2:290|(1:295)(1:294))|(1:297)(1:298)|(13:300|308|(3:310|312|(0)(0))|318|(2:320|322)|323|(2:325|327)|328|(0)|339|(2:341|350)(0)|351|(0)(0))(1:301))(1:302)|303|308|(0)|318|(0)|323|(0)|328|(0)|339|(0)(0)|351|(0)(0)))))|133|151|(0)|158|(0)|(0)|(3:183|185|(0)(0))|(3:205|207|(0)(0))|226|(3:228|373|230)|375|234|(0)(0)|360|254|255|376|256|364|259|(0)(0)|303|308|(0)|318|(0)|323|(0)|328|(0)|339|(0)(0)|351|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x086f, code lost:
    
        r6 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x08db, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x08dc, code lost:
    
        com.tnkfactory.ad.Logger.e("error #a004 : " + r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x08f2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x08f3, code lost:
    
        r6 = r22;
        com.tnkfactory.ad.Logger.e("error #a002 : " + r0.toString());
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0603  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0622  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x06dd  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x06fd  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x070c  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x077b  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x078a  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x081f A[Catch: Exception -> 0x08f2, TryCatch #8 {Exception -> 0x08f2, blocks: (B:234:0x081a, B:236:0x081f, B:248:0x0837, B:252:0x0843, B:253:0x084b), top: B:375:0x081a }] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x084b A[Catch: Exception -> 0x08f2, TRY_LEAVE, TryCatch #8 {Exception -> 0x08f2, blocks: (B:234:0x081a, B:236:0x081f, B:248:0x0837, B:252:0x0843, B:253:0x084b), top: B:375:0x081a }] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0875 A[Catch: Exception -> 0x08db, TryCatch #2 {Exception -> 0x08db, blocks: (B:259:0x0871, B:261:0x0875, B:297:0x08bd, B:301:0x08c6, B:302:0x08ce), top: B:364:0x0871 }] */
    /* JADX WARN: Removed duplicated region for block: B:302:0x08ce A[Catch: Exception -> 0x08db, TRY_LEAVE, TryCatch #2 {Exception -> 0x08db, blocks: (B:259:0x0871, B:261:0x0875, B:297:0x08bd, B:301:0x08c6, B:302:0x08ce), top: B:364:0x0871 }] */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0910  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0921  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0928  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0954  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x097b  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x09d2  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x09f0  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x09ff  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0a24  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0998 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v53, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v57 */
    /* JADX WARN: Type inference failed for: r3v58 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c(android.content.Context r26, com.tnkfactory.framework.vo.ValueObject r27) {
        /*
            Method dump skipped, instruction units count: 2610
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tnkfactory.ad.pub.c.<init>(android.content.Context, com.tnkfactory.framework.vo.ValueObject):void");
    }

    public final AdError a() {
        String str = this.b;
        str.getClass();
        str.hashCode();
        switch (str) {
            case "S":
                return AdError.NO_ERROR;
            case "C1":
                return AdError.FAIL_NO_IMAGE;
            case "E1":
                return AdError.FAIL_INCORRECT_PLACEMENT;
            case "E2":
                return AdError.FAIL_NO_AD;
            case "E3":
                return AdError.FAIL_SCREEN_ORIENTATION;
            case "E4":
                return AdError.FAIL_TEST_DEVICE_NOT_REGISTERED;
            default:
                return AdError.FAIL_SYSTEM;
        }
    }

    public final void a(Context context) {
        e1 e1Var;
        try {
            String str = this.V;
            if (str != null && str.length() > 0) {
                JSONObject jSONObject = new JSONObject(this.V);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String strOptString = jSONObject.optString(next);
                    if (strOptString.length() > 0) {
                        this.g0.put(next, new e1(context, strOptString));
                    }
                }
            }
        } catch (Exception e) {
            Logger.e("error #a001 : " + e.toString());
        }
        JSONArray jSONArray = this.K;
        int length = jSONArray != null ? jSONArray.length() : 0;
        try {
            String str2 = this.I;
            if (str2 != null && str2.length() > 0) {
                JSONObject jSONObject2 = new JSONObject(this.I);
                Iterator<String> itKeys2 = jSONObject2.keys();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    String strOptString2 = jSONObject2.optString(next2);
                    if (strOptString2.length() > 0) {
                        e1 e1Var2 = new e1(context, strOptString2);
                        this.g0.put(next2, e1Var2);
                        for (int i = 0; i < length; i++) {
                            this.g0.put(next2 + "_" + i, e1Var2);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            Logger.e("error #a003 : " + e2.toString());
        }
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObjectOptJSONObject = this.K.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null) {
                String strOptString3 = jSONObjectOptJSONObject.optString(h1.a("d6710c97ee54"));
                if (strOptString3.length() > 0) {
                    this.g0.put(h1.a("d6710c97ee54") + "_" + Integer.valueOf(i2), new e1(context, strOptString3));
                }
            }
        }
        for (String str3 : this.g0.keySet()) {
            if (str3.contains("close") && ((e1Var = (e1) this.g0.get(str3)) == null || e1Var.f3124a == null)) {
                Drawable drawable = context.getResources().getDrawable(R.drawable.btn_close_shape);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                this.g0.put(str3, new e1(bitmapCreateBitmap));
            }
        }
    }
}
