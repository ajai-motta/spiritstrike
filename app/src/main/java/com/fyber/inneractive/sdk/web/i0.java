package com.fyber.inneractive.sdk.web;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.facebook.internal.NativeProtocol;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.ui.IAcloseButton;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.iab.omid.library.fyber.adsession.AdSession;
import com.iab.omid.library.fyber.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.fyber.adsession.Partner;
import java.net.URI;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i0 extends i1 {
    public static final String[] o0 = {"yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ"};
    public com.fyber.inneractive.sdk.mraid.f0 N;
    public final z O;
    public final d0 P;
    public final c0 Q;
    public ViewGroup R;
    public m S;
    public boolean T;
    public int U;
    public e0 V;
    public IAcloseButton W;
    public boolean X;
    public float Y;
    public int Z;
    public int a0;
    public int b0;
    public int c0;
    public int d0;
    public int e0;
    public Orientation f0;
    public int g0;
    public FrameLayout h0;
    public FrameLayout i0;
    public FrameLayout j0;
    public int k0;
    public int l0;
    public t m0;
    public final p n0;

    public i0(boolean z, c0 c0Var, z zVar, d0 d0Var, com.fyber.inneractive.sdk.measurement.e eVar, com.fyber.inneractive.sdk.config.global.r rVar) {
        super(z, c0Var, rVar);
        this.N = com.fyber.inneractive.sdk.mraid.f0.HIDDEN;
        this.T = false;
        this.Z = -1;
        this.a0 = -1;
        this.b0 = -1;
        this.c0 = -1;
        this.d0 = -1;
        this.e0 = -1;
        this.f0 = Orientation.NONE;
        this.H = eVar;
        this.Q = c0Var;
        this.O = zVar;
        this.P = d0Var;
        this.n0 = new p(this);
    }

    @Override // com.fyber.inneractive.sdk.web.i, com.fyber.inneractive.sdk.web.l
    public void a(boolean z) {
        a(new com.fyber.inneractive.sdk.mraid.g0(z));
        super.a(z);
    }

    @Override // com.fyber.inneractive.sdk.web.l
    public final void b() {
        com.fyber.inneractive.sdk.util.r.b.post(new r(this));
    }

    @Override // com.fyber.inneractive.sdk.web.l
    public final void c() {
        m mVar = this.b;
        if (mVar != null && mVar.getViewTreeObserver() != null) {
            this.b.getViewTreeObserver().removeOnPreDrawListener(this.n0);
        }
        com.fyber.inneractive.sdk.util.r.b.post(new s(this));
    }

    public final void d(boolean z) {
        try {
            Activity activity = (Activity) com.fyber.inneractive.sdk.util.o.a(this.b);
            if (activity != null) {
                if (!z || activity.getResources() == null || activity.getResources().getConfiguration() == null) {
                    activity.setRequestedOrientation(this.U);
                } else {
                    activity.setRequestedOrientation(activity.getResources().getConfiguration().orientation);
                }
            }
        } catch (Exception unused) {
            IAlog.a("Failed to modify the device orientation.", new Object[0]);
        }
    }

    @Override // com.fyber.inneractive.sdk.web.i
    public final com.fyber.inneractive.sdk.util.g1 g() {
        m mVar;
        return (this.N != com.fyber.inneractive.sdk.mraid.f0.EXPANDED || (mVar = this.S) == null) ? super.g() : mVar.getLastClickedLocation();
    }

    @Override // com.fyber.inneractive.sdk.web.i
    public final void h() {
        super.h();
        this.N = com.fyber.inneractive.sdk.mraid.f0.LOADING;
        Context contextA = com.fyber.inneractive.sdk.util.o.a(this.b);
        this.U = contextA instanceof Activity ? ((Activity) contextA).getRequestedOrientation() : -1;
        this.i0 = new FrameLayout(contextA);
        this.j0 = new FrameLayout(contextA);
        FrameLayout frameLayout = new FrameLayout(contextA);
        frameLayout.setBackgroundColor(-858993460);
        this.h0 = frameLayout;
        a(contextA, false);
        this.b.setOnKeyListener(new q(this));
    }

    @Override // com.fyber.inneractive.sdk.web.i1
    public final void j() {
        m mVar = this.b;
        if (mVar != null) {
            mVar.a("window.mraidbridge.fireReadyEvent();");
        }
    }

    @Override // com.fyber.inneractive.sdk.web.i1
    public void k() {
        ArrayList arrayList = new ArrayList();
        m mVar = this.b;
        if (mVar == null || mVar.getScaleX() == 1.0f || this.b.getScaleY() == 1.0f) {
            arrayList.add(new com.fyber.inneractive.sdk.mraid.c0(this.Z, this.a0));
            arrayList.add(new com.fyber.inneractive.sdk.mraid.a0(this.b0, this.c0));
        } else {
            arrayList.add(new com.fyber.inneractive.sdk.mraid.c0(this.b.getWidthDp(), this.b.getHeightDp()));
            arrayList.add(new com.fyber.inneractive.sdk.mraid.a0(this.b.getWidthDp(), this.b.getHeightDp()));
        }
        m mVar2 = this.b;
        int iC = com.fyber.inneractive.sdk.util.o.c(mVar2 != null ? mVar2.getWidth() : this.b0);
        m mVar3 = this.b;
        arrayList.add(new com.fyber.inneractive.sdk.mraid.z(iC, com.fyber.inneractive.sdk.util.o.c(mVar3 != null ? mVar3.getHeight() : this.c0)));
        a(arrayList);
        com.fyber.inneractive.sdk.mraid.f0 f0Var = com.fyber.inneractive.sdk.mraid.f0.DEFAULT;
        this.N = f0Var;
        a(new com.fyber.inneractive.sdk.mraid.d0(f0Var));
    }

    @Override // com.fyber.inneractive.sdk.web.i1
    public final boolean m() {
        c0 c0Var = this.Q;
        return c0Var != null && c0Var.equals(c0.INTERSTITIAL);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void o() {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.web.i0.o():void");
    }

    public final boolean p() {
        return this.N == com.fyber.inneractive.sdk.mraid.f0.EXPANDED;
    }

    public final void q() {
        com.fyber.inneractive.sdk.measurement.tracker.e bVar;
        com.fyber.inneractive.sdk.measurement.e eVar = this.H;
        if (eVar != null) {
            m mVar = this.b;
            com.fyber.inneractive.sdk.flow.x xVar = this.s;
            boolean z = false;
            IAlog.a("omsdk initMraidSession", new Object[0]);
            if (eVar.e == null) {
                IAlog.a("omsdk partner is null", new Object[0]);
                bVar = null;
            } else {
                if (xVar != null && xVar.b() != null && xVar.b().J) {
                    z = true;
                }
                com.fyber.inneractive.sdk.measurement.tracker.f fVar = eVar.f;
                Partner partner = eVar.e;
                fVar.getClass();
                bVar = z ? new com.fyber.inneractive.sdk.measurement.tracker.b(partner, mVar) : new com.fyber.inneractive.sdk.measurement.tracker.a(partner, mVar);
                bVar.a(mVar);
            }
            this.I = bVar;
        }
        g gVar = this.f;
        if (gVar != null) {
            gVar.a(this);
        }
    }

    public final void r() {
        try {
            if (!(com.fyber.inneractive.sdk.util.o.a(this.b) instanceof Activity) || this.m0 == null) {
                return;
            }
            ((Activity) com.fyber.inneractive.sdk.util.o.a(this.b)).getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.m0);
            this.m0 = null;
        } catch (Exception e) {
            IAlog.f("failed to unregisterOnBackInvokedCallback with error: %s", e.getMessage());
        }
    }

    @Override // com.fyber.inneractive.sdk.web.i1
    public void setAdDefaultSize(int i, int i2) {
        this.k0 = i;
        this.l0 = i2;
        this.d0 = i;
        this.e0 = i2;
    }

    public void setOrientationProperties(boolean z, String str) {
        if ("portrait".equals(str)) {
            this.f0 = Orientation.PORTRAIT;
        } else if ("landscape".equals(str)) {
            this.f0 = Orientation.LANDSCAPE;
        } else {
            this.f0 = Orientation.NONE;
        }
        j1 j1Var = this.g;
        if (j1Var != null) {
            ((b0) j1Var).a(z, this.f0);
        }
    }

    public void setResizeProperties() {
    }

    @Override // com.fyber.inneractive.sdk.web.i
    public final void b(boolean z) {
        m mVar = this.b;
        if (mVar != null && mVar.getViewTreeObserver() != null) {
            this.b.getViewTreeObserver().removeOnPreDrawListener(this.n0);
        }
        com.fyber.inneractive.sdk.util.r.b.post(new s(this));
        m mVar2 = this.S;
        if (mVar2 != null && mVar2.getParent() != null && (this.S.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.S.getParent()).removeView(this.S);
            this.S = null;
        }
        FrameLayout frameLayout = this.i0;
        if (frameLayout != null && this.j0 != null) {
            frameLayout.removeAllViewsInLayout();
            this.j0.removeAllViewsInLayout();
            ViewGroup viewGroup = this.R;
            if (viewGroup != null) {
                viewGroup.removeView(this.j0);
            }
        }
        this.f1697a = false;
        if (Build.VERSION.SDK_INT >= 33) {
            r();
        }
        super.b(z);
    }

    @Override // com.fyber.inneractive.sdk.web.i, com.fyber.inneractive.sdk.web.j
    public boolean a(WebView webView, String str) {
        IAlog.a("%shandle url for: %s webView = %s", IAlog.a(this), str, webView);
        if (this.N == com.fyber.inneractive.sdk.mraid.f0.EXPANDED && !TextUtils.isEmpty(str) && webView.equals(this.S) && !this.T) {
            this.T = true;
            return false;
        }
        return super.a(webView, str);
    }

    public final void c(boolean z) {
        if (this.R == null) {
            return;
        }
        if (z) {
            int iB = com.fyber.inneractive.sdk.util.o.b(35);
            if (this.W == null) {
                IAcloseButton iAcloseButton = new IAcloseButton(com.fyber.inneractive.sdk.util.o.a(this.b), iB);
                this.W = iAcloseButton;
                iAcloseButton.setOnClickListener(new o(this));
            }
            com.fyber.inneractive.sdk.util.v.a(this.W);
            this.j0.addView(this.W);
            IAcloseButton iAcloseButton2 = this.W;
            ViewGroup.LayoutParams layoutParams = iAcloseButton2.getLayoutParams();
            layoutParams.width = iB;
            layoutParams.height = iB;
            iAcloseButton2.setLayoutParams(layoutParams);
            com.fyber.inneractive.sdk.util.o.a(this.W, 53);
            IAcloseButton iAcloseButton3 = this.W;
            int iB2 = com.fyber.inneractive.sdk.util.o.b(10);
            int iB3 = com.fyber.inneractive.sdk.util.o.b(10);
            ViewGroup.LayoutParams layoutParams2 = iAcloseButton3.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams.leftMargin = 0;
                marginLayoutParams.topMargin = iB2;
                marginLayoutParams.rightMargin = iB3;
                marginLayoutParams.bottomMargin = 0;
                iAcloseButton3.setLayoutParams(marginLayoutParams);
            }
        } else {
            this.j0.removeView(this.W);
        }
        j1 j1Var = this.g;
        if (j1Var != null) {
            ((b0) j1Var).b(z);
        }
        this.X = !z;
    }

    @Override // com.fyber.inneractive.sdk.web.i1
    public final void a(Context context, boolean z) {
        Window window;
        Window window2;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) IAConfigManager.O.v.a().getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        this.Y = displayMetrics.density;
        Rect rect = new Rect();
        boolean z2 = context instanceof Activity;
        if (z2 && (window2 = ((Activity) context).getWindow()) != null) {
            window2.getDecorView().getWindowVisibleDisplayFrame(rect);
        }
        int i = rect.top;
        View viewFindViewById = (!z2 || (window = ((Activity) context).getWindow()) == null) ? null : window.findViewById(R.id.content);
        int top = viewFindViewById != null ? viewFindViewById.getTop() - i : 0;
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        double d = i2;
        double d2 = 160.0d / ((double) displayMetrics.densityDpi);
        int widthDp = (int) (d2 * d);
        int heightDp = (int) (d2 * ((double) i3));
        int i4 = (i3 - i) - top;
        m mVar = this.b;
        if (mVar != null && mVar.getScaleX() != 1.0f && this.b.getScaleY() != 1.0f) {
            widthDp = this.b.getWidthDp();
            heightDp = this.b.getHeightDp();
            int iB = (com.fyber.inneractive.sdk.util.o.b(this.b.getHeightDp()) - i) - top;
            this.b0 = this.Z;
            this.c0 = (int) ((160.0d / ((double) displayMetrics.densityDpi)) * ((double) iB));
        } else {
            double d3 = 160.0d / ((double) displayMetrics.densityDpi);
            this.b0 = (int) (d * d3);
            this.c0 = (int) (d3 * ((double) i4));
        }
        if (this.Z == widthDp && this.a0 == heightDp) {
            return;
        }
        this.Z = widthDp;
        this.a0 = heightDp;
        if (z) {
            a(new com.fyber.inneractive.sdk.mraid.c0(widthDp, heightDp));
            a(new com.fyber.inneractive.sdk.mraid.a0(this.b0, this.c0));
            a(new com.fyber.inneractive.sdk.mraid.z(this.b0, this.c0));
            int i5 = this.d0;
            if (i5 > 0 && this.e0 > 0) {
                a(new com.fyber.inneractive.sdk.mraid.x(com.fyber.inneractive.sdk.util.o.c(i5), com.fyber.inneractive.sdk.util.o.c(this.e0)));
                return;
            }
            m mVar2 = this.b;
            if (mVar2 == null || mVar2.getWidth() <= 0 || this.b.getHeight() <= 0) {
                return;
            }
            a(new com.fyber.inneractive.sdk.mraid.x(com.fyber.inneractive.sdk.util.o.c(this.b.getWidth()), com.fyber.inneractive.sdk.util.o.c(this.b.getHeight())));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r7, int r8, int r9, boolean r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 583
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.web.i0.a(java.lang.String, int, int, boolean, boolean):void");
    }

    public static HashMap a(Map map) {
        String str;
        HashMap map2 = new HashMap();
        if (map.containsKey("description") && map.containsKey(TtmlNode.START)) {
            map2.put("title", map.get("description"));
            if (map.containsKey(TtmlNode.START) && map.get(TtmlNode.START) != null) {
                Date dateA = a((String) map.get(TtmlNode.START));
                if (dateA != null) {
                    map2.put("beginTime", Long.valueOf(dateA.getTime()));
                    if (map.containsKey(TtmlNode.END) && map.get(TtmlNode.END) != null) {
                        Date dateA2 = a((String) map.get(TtmlNode.END));
                        if (dateA2 != null) {
                            map2.put("endTime", Long.valueOf(dateA2.getTime()));
                        } else {
                            throw new IllegalArgumentException("Invalid calendar event: end time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
                        }
                    }
                    if (map.containsKey(FirebaseAnalytics.Param.LOCATION)) {
                        map2.put("eventLocation", map.get(FirebaseAnalytics.Param.LOCATION));
                    }
                    if (map.containsKey("summary")) {
                        map2.put("description", map.get("summary"));
                    }
                    if (map.containsKey("transparency")) {
                        map2.put("availability", Integer.valueOf("transparent".equals(map.get("transparency")) ? 1 : 0));
                    }
                    StringBuilder sb = new StringBuilder();
                    if (map.containsKey("frequency")) {
                        String str2 = (String) map.get("frequency");
                        int i = map.containsKey("interval") ? Integer.parseInt((String) map.get("interval")) : -1;
                        if ("daily".equals(str2)) {
                            sb.append("FREQ=DAILY;");
                            if (i != -1) {
                                sb.append("INTERVAL=" + i + ";");
                            }
                        } else {
                            if ("weekly".equals(str2)) {
                                sb.append("FREQ=WEEKLY;");
                                if (i != -1) {
                                    sb.append("INTERVAL=" + i + ";");
                                }
                                if (map.containsKey("daysInWeek")) {
                                    String str3 = (String) map.get("daysInWeek");
                                    StringBuilder sb2 = new StringBuilder();
                                    boolean[] zArr = new boolean[7];
                                    String[] strArrSplit = str3.split(",");
                                    for (String str4 : strArrSplit) {
                                        int i2 = Integer.parseInt(str4);
                                        if (i2 == 7) {
                                            i2 = 0;
                                        }
                                        if (!zArr[i2]) {
                                            StringBuilder sb3 = new StringBuilder();
                                            switch (i2) {
                                                case 0:
                                                    str = "SU";
                                                    break;
                                                case 1:
                                                    str = "MO";
                                                    break;
                                                case 2:
                                                    str = "TU";
                                                    break;
                                                case 3:
                                                    str = "WE";
                                                    break;
                                                case 4:
                                                    str = "TH";
                                                    break;
                                                case 5:
                                                    str = "FR";
                                                    break;
                                                case 6:
                                                    str = "SA";
                                                    break;
                                                default:
                                                    throw new IllegalArgumentException(com.fyber.inneractive.sdk.player.exoplayer2.m.a("invalid day of week ", i2));
                                            }
                                            sb3.append(str);
                                            sb3.append(",");
                                            sb2.append(sb3.toString());
                                            zArr[i2] = true;
                                        }
                                    }
                                    if (strArrSplit.length != 0) {
                                        sb2.deleteCharAt(sb2.length() - 1);
                                        String string = sb2.toString();
                                        if (string == null) {
                                            throw new IllegalArgumentException("invalid ");
                                        }
                                        sb.append("BYDAY=" + string + ";");
                                    } else {
                                        throw new IllegalArgumentException("must have at least 1 day of the week if specifying repeating weekly");
                                    }
                                }
                            } else if ("monthly".equals(str2)) {
                                sb.append("FREQ=MONTHLY;");
                                if (i != -1) {
                                    sb.append("INTERVAL=" + i + ";");
                                }
                                if (map.containsKey("daysInMonth")) {
                                    String str5 = (String) map.get("daysInMonth");
                                    StringBuilder sb4 = new StringBuilder();
                                    boolean[] zArr2 = new boolean[63];
                                    String[] strArrSplit2 = str5.split(",");
                                    for (String str6 : strArrSplit2) {
                                        int i3 = Integer.parseInt(str6);
                                        int i4 = i3 + 31;
                                        if (!zArr2[i4]) {
                                            StringBuilder sb5 = new StringBuilder();
                                            if (i3 != 0 && i3 >= -31 && i3 <= 31) {
                                                sb5.append("" + i3);
                                                sb5.append(",");
                                                sb4.append(sb5.toString());
                                                zArr2[i4] = true;
                                            } else {
                                                throw new IllegalArgumentException(com.fyber.inneractive.sdk.player.exoplayer2.m.a("invalid day of month ", i3));
                                            }
                                        }
                                    }
                                    if (strArrSplit2.length != 0) {
                                        sb4.deleteCharAt(sb4.length() - 1);
                                        String string2 = sb4.toString();
                                        if (string2 == null) {
                                            throw new IllegalArgumentException();
                                        }
                                        sb.append("BYMONTHDAY=" + string2 + ";");
                                    } else {
                                        throw new IllegalArgumentException("must have at least 1 day of the month if specifying repeating weekly");
                                    }
                                }
                            } else {
                                throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
                            }
                        }
                    }
                    String string3 = sb.toString();
                    if (!TextUtils.isEmpty(string3)) {
                        map2.put("rrule", string3);
                    }
                    return map2;
                }
                throw new IllegalArgumentException("Invalid calendar event: start time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
            }
            throw new IllegalArgumentException("Invalid calendar event: start is null.");
        }
        throw new IllegalArgumentException("Missing start and description fields");
    }

    public static Date a(String str) {
        Date date = null;
        int i = 0;
        while (true) {
            String[] strArr = o0;
            if (i >= 2) {
                break;
            }
            try {
                date = new SimpleDateFormat(strArr[i], Locale.getDefault()).parse(str);
            } catch (ParseException unused) {
            }
            if (date != null) {
                break;
            }
            i++;
        }
        return date;
    }

    public final void a(com.fyber.inneractive.sdk.mraid.k kVar, String str) {
        String strA = kVar.a();
        m mVar = this.b;
        if (mVar != null) {
            mVar.a("window.mraidbridge.fireErrorEvent('" + strA + "', '" + str + "');");
        }
    }

    public static LinkedHashMap a(URI uri) {
        int i;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && rawQuery.length() > 0) {
            for (String str : rawQuery.split("&")) {
                int iIndexOf = str.indexOf("=");
                linkedHashMap.put(iIndexOf > 0 ? URLDecoder.decode(str.substring(0, iIndexOf), "UTF-8") : str, (iIndexOf <= 0 || str.length() <= (i = iIndexOf + 1)) ? null : URLDecoder.decode(str.substring(i), "UTF-8"));
            }
        }
        return linkedHashMap;
    }

    public final void a(View view, com.fyber.inneractive.sdk.measurement.tracker.d dVar) {
        com.fyber.inneractive.sdk.measurement.tracker.e eVar;
        if (view == null || (eVar = this.I) == null) {
            return;
        }
        eVar.getClass();
        try {
            AdSession adSession = eVar.f1151a;
            if (adSession != null) {
                if (dVar == com.fyber.inneractive.sdk.measurement.tracker.d.CloseButton) {
                    adSession.addFriendlyObstruction(view, FriendlyObstructionPurpose.CLOSE_AD, dVar.name());
                } else {
                    adSession.addFriendlyObstruction(view, FriendlyObstructionPurpose.OTHER, dVar.name());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(com.fyber.inneractive.sdk.mraid.k kVar) {
        com.fyber.inneractive.sdk.config.global.r rVar;
        com.fyber.inneractive.sdk.network.u uVar = com.fyber.inneractive.sdk.network.u.BANNER_RESIZE_EXPAND;
        InneractiveAdRequest inneractiveAdRequest = this.r;
        com.fyber.inneractive.sdk.flow.x xVar = this.s;
        com.fyber.inneractive.sdk.response.e eVarB = xVar != null ? xVar.b() : null;
        com.fyber.inneractive.sdk.flow.x xVar2 = this.s;
        JSONArray jSONArrayB = (xVar2 == null || (rVar = xVar2.c) == null) ? null : rVar.b();
        com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(eVarB);
        wVar.c = uVar;
        wVar.f1220a = inneractiveAdRequest;
        wVar.d = jSONArrayB;
        wVar.a(NativeProtocol.WEB_DIALOG_ACTION, kVar.a()).a((String) null);
    }
}
