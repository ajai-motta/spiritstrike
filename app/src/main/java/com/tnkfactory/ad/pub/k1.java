package com.tnkfactory.ad.pub;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f3147a = new HashMap();
    public int b = 1;
    public final HashSet c = new HashSet();
    public final HashSet d = new HashSet();
    public final HashSet e = new HashSet();
    public final HashSet f = new HashSet();
    public final HashSet g = new HashSet();
    public final HashMap h = new HashMap();
    public final HashSet i = new HashSet();
    public final HashMap j = new HashMap();
    public final JSONObject k;
    public final JSONObject l;
    public final JSONArray m;

    public k1(JSONObject jSONObject, JSONObject jSONObject2, JSONArray jSONArray) {
        this.k = jSONObject;
        this.l = jSONObject2;
        this.m = jSONArray;
    }

    public static x1 a(Context context, int i, int i2, JSONObject jSONObject, JSONObject jSONObject2, JSONArray jSONArray, boolean z, c cVar) {
        View viewA;
        if (jSONObject == null || jSONObject2 == null) {
            return null;
        }
        k1 k1Var = new k1(jSONObject, jSONObject2, jSONArray);
        JSONObject jSONObject3 = k1Var.k;
        x1 x1Var = (jSONObject3 == null || (viewA = k1Var.a(context, i, i2, jSONObject3, -1)) == null) ? null : new x1(context, viewA, k1Var.d, k1Var.g, k1Var.c, k1Var.e, k1Var.f, k1Var.i, k1Var.h, k1Var.f3147a, k1Var.j, cVar);
        if (x1Var == null) {
            return null;
        }
        x1Var.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        return x1Var;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0376  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View a(android.content.Context r22, int r23, int r24, org.json.JSONObject r25, int r26) {
        /*
            Method dump skipped, instruction units count: 1668
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tnkfactory.ad.pub.k1.a(android.content.Context, int, int, org.json.JSONObject, int):android.view.View");
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0294  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(android.view.View r19, int r20, int r21, org.json.JSONObject r22, int r23) {
        /*
            Method dump skipped, instruction units count: 1025
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tnkfactory.ad.pub.k1.a(android.view.View, int, int, org.json.JSONObject, int):java.lang.String");
    }

    public static void a(String str, RelativeLayout.LayoutParams layoutParams) {
        if (str.length() > 0) {
            for (String str2 : str.split(",")) {
                if (str2.startsWith("c")) {
                    layoutParams.addRule(13);
                } else if (str2.endsWith("v")) {
                    layoutParams.addRule(15);
                } else if (str2.endsWith("h")) {
                    layoutParams.addRule(14);
                } else if (str2.startsWith("t")) {
                    layoutParams.addRule(10);
                } else if (str2.startsWith("l")) {
                    layoutParams.addRule(9);
                } else if (str2.startsWith(AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ)) {
                    layoutParams.addRule(11);
                } else if (str2.startsWith("b")) {
                    layoutParams.addRule(12);
                }
            }
        }
    }

    public final int a(String str) {
        Integer num = (Integer) this.f3147a.get(str);
        if (num == null) {
            this.f3147a.put(str, Integer.valueOf(this.b));
            int i = this.b;
            this.b = i + 1;
            return i;
        }
        return num.intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(String str, TextView textView, JSONObject jSONObject, int i) {
        String actionButtonLabel;
        JSONArray jSONArray;
        if (h1.a("c07b0d99fa54").equals(str)) {
            actionButtonLabel = b0.instance().getCloseButtonLabel();
        } else if (h1.a("c07d199ffd").equals(str)) {
            actionButtonLabel = b0.instance().getExitButtonLabel();
        } else if (h1.a("c06c0882e554").equals(str)) {
            actionButtonLabel = b0.instance().getFrameTitle();
        } else {
            actionButtonLabel = h1.a("c0790282e05e9f").equals(str) ? b0.instance().getActionButtonLabel() : null;
        }
        if (actionButtonLabel == null) {
            Object objOpt = jSONObject.opt(h1.a("d27d1982"));
            if (objOpt instanceof String) {
                actionButtonLabel = (String) objOpt;
            } else if (objOpt instanceof JSONObject) {
                JSONObject jSONObject2 = (JSONObject) objOpt;
                String strOptString = jSONObject2.optString(Locale.getDefault().getLanguage());
                actionButtonLabel = strOptString.length() > 0 ? strOptString : jSONObject2.optString("*");
            } else {
                actionButtonLabel = "";
            }
        }
        if (actionButtonLabel.length() > 0) {
            textView.setText(actionButtonLabel);
        } else {
            textView.setText((CharSequence) null);
        }
        if (textView instanceof ToggleButton) {
            ToggleButton toggleButton = (ToggleButton) textView;
            toggleButton.setTextOn(null);
            toggleButton.setTextOff(null);
        }
        String strOptString2 = jSONObject.optString(h1.a("d27d1982d6529e67fc6d"));
        int i2 = 1;
        if (strOptString2.length() > 0) {
            String[] strArrSplit = strOptString2.split(",");
            String str2 = strArrSplit[0];
            textView.setTextColor(n2.a(str2, strArrSplit.length >= 2 ? strArrSplit[1] : str2));
        }
        String strOptString3 = jSONObject.optString(h1.a("d27d1982d6429871f6"));
        if (strOptString3.length() > 0) {
            if (strOptString3.endsWith("dp")) {
                strOptString3 = strOptString3.substring(0, strOptString3.length() - 2);
            } else if (strOptString3.endsWith("sp")) {
                strOptString3 = strOptString3.substring(0, strOptString3.length() - 2);
                i2 = 2;
            } else if (strOptString3.endsWith("px")) {
                strOptString3 = strOptString3.substring(0, strOptString3.length() - 2);
                i2 = 0;
            }
            textView.setTextSize(i2, Integer.parseInt(strOptString3));
        }
        String strOptString4 = jSONObject.optString(h1.a("d27d1982d645887bf6"));
        if (strOptString4.length() > 0) {
            boolean zContains = strOptString4.contains("b");
            int i3 = zContains;
            if (strOptString4.contains("i")) {
                i3 = (zContains ? 1 : 0) | 2;
            }
            textView.setTypeface(null, i3);
        }
        textView.setSingleLine(jSONObject.optBoolean(h1.a("d5710f91e554ae67fa7161"), false));
        textView.setGravity(jSONObject.optInt(h1.a("c16a0080e04588"), 17));
        if (i <= -1 || (jSONArray = this.m) == null) {
            return;
        }
        textView.setText(jSONArray.optJSONObject(i).optString(str));
    }
}
