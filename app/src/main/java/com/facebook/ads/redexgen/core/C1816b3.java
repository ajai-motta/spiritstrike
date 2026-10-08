package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.compose.runtime.ComposerKt;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.ByteArrayInputStream;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.io.encoding.Base64;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.b3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1816b3 extends WebViewClient {
    public static byte[] A0B;
    public static String[] A0C = {"zsPwasR1y7408", "ZGgsKLkccpHpwEVEMRkr0P5MO", "FzTF8imkK53ZXE3O7c0sd3pyoR5CtRCL", "JPkvHHHSAaAEWhLae7UVRehZAXg5QbZs", "c", "Jl8ZDZjQ485DOmiNP3uI8E", "DJVtCfMEOJ4BXbKH6y5pb3wK31xmWsao", "K"};
    public Date A00;
    public boolean A01 = false;
    public final C2165gi A02;
    public final WeakReference<LV> A03;
    public final WeakReference<InterfaceC1814b1> A04;
    public final WeakReference<AtomicBoolean> A05;
    public final WeakReference<Y2> A06;
    public final WeakReference<C2110fp> A07;
    public final AtomicInteger A08;
    public final AtomicReference<String> A09;
    public final boolean A0A;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 118);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        byte[] bArr = {8, 38, 40, 45, 42, -14, 8, 52, 51, 57, 55, 52, 49, -69, -36, -27, -32, -36, -37, Ascii.FS, 77, 56, 67, 76, 56, 75, SignedBytes.MAX_POWER_OF_TWO, 69, 62, -9, 44, 41, 32, -9, 39, 56, 75, 63, -9, Base64.padSymbol, 70, 73, -9, Ascii.GS, SignedBytes.MAX_POWER_OF_TWO, 67, 60, -9, Ascii.CAN, 58, 58, 60, 74, 74, -9, -46, 5, 1, -1, -18, -83, -15, -18, 1, -18, -57, -83, 60, 72, 72, 68, Ascii.DC4, 57, 102, 102, 99, 102, 59, 84, 89, 71, 76, 75, 6, 56, 75, 87, 91, 75, 89, 90, 6, 76, 85, 88, 6, 44, 79, 82, 75, 6, 39, 73, 73, 75, 89, 89, 6, 34, 59, SignedBytes.MAX_POWER_OF_TWO, 46, 51, 50, -19, Ascii.US, 50, 62, 66, 50, SignedBytes.MAX_POWER_OF_TWO, 65, -19, 51, 60, 63, -19, 19, 54, 57, 50, -19, Ascii.SO, 48, 48, 50, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, -19, 49, 50, 59, 54, 50, 49, 67, 68, 77, 72, 68, 67, 62, 84, 81, 72, 62, 79, SignedBytes.MAX_POWER_OF_TWO, 83, 71, SignedBytes.MAX_POWER_OF_TWO, 59, 80, 67, Base64.padSymbol, 73, 72, 8, 67, Base64.padSymbol, 73, 41, 44, 47, 40, Ascii.ETB, Ascii.SO, Ascii.GS, -29, -29, -18, -5, -5, 8, -18, -10, -7, -3, 2, 8, -5, -18, -4, -7, -8, -9, -4, -18, Ascii.ESC, Ascii.FS, -38, 32, 33, Ascii.FS, Ascii.US, Ascii.DC2, 98, 85, 97, 101, 85, 99, 100, 79, 89, 84, 78, 63, 82, 78, 9, 74, 70, 59, 67, 72, 5, -16, -5, -8, -13, -18, -1, -16, 3, -9, 55, 37, 34, Ascii.US, 54, 41, 37, 55};
        String[] strArr = A0C;
        if (strArr[0].length() == strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0C;
        strArr2[3] = "rhE0g4ovzatryzU62WuE8blUNequGZ6x";
        strArr2[6] = "8iaaY9YuVC21lqcoOxYFj2DPKFldlJdP";
        A0B = bArr;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static boolean A09(String str, List<String> list) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (lowerCase.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    static {
        A02();
    }

    public C1816b3(C2165gi c2165gi, WeakReference<InterfaceC1814b1> weakReference, WeakReference<C2110fp> weakReference2, WeakReference<Y2> weakReference3, WeakReference<AtomicBoolean> checkAssetsByJavascriptBridge, WeakReference<LV> weakReference4, AtomicInteger atomicInteger, AtomicReference<String> requestId, boolean z) {
        this.A02 = c2165gi;
        this.A04 = weakReference;
        this.A07 = weakReference2;
        this.A06 = weakReference3;
        this.A05 = checkAssetsByJavascriptBridge;
        this.A03 = weakReference4;
        this.A08 = atomicInteger;
        this.A09 = requestId;
        this.A0A = z;
    }

    private WebResourceResponse A00() {
        return new WebResourceResponse(A01(216, 10, 100), StandardCharsets.UTF_8.name(), 403, A01(13, 6, 1), Collections.singletonMap(A01(0, 13, 79), A01(198, 8, 55)), new ByteArrayInputStream(A01(13, 6, 1).getBytes()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03(int i, String str) {
        if (A01(175, 23, 51).equals(str)) {
            this.A02.A0F().AKx();
            return;
        }
        this.A02.A0F().AKy(i, str);
        if (this.A04.get() != null) {
            this.A04.get().ADu(i, str);
        }
    }

    private final void A04(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        if (webResourceRequest.getUrl().toString().toLowerCase(Locale.US).contains(A01(160, 11, 100))) {
            return;
        }
        this.A02.A0F().AL2(webResourceResponse.getStatusCode(), AbstractC1674Xb.A01(webResourceResponse.getStatusCode(), A01(67, 10, 126), A01(0, 0, 53) + webResourceRequest.getUrl()));
    }

    private void A06(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A01(145, 15, 105), str);
            jSONObject.put(A01(226, 10, 25), str2);
            jSONObject.put(A01(ComposerKt.referenceKey, 10, 122), this.A09.get());
        } catch (JSONException unused) {
        }
        if (this.A02 != null) {
            this.A02.A08().ABC(A01(236, 8, 74), AbstractC1577Td.A2c, new C1578Te(AdErrorType.WEB_VIEW_CACHE_FILE_WAS_DENIED.getDefaultErrorMessage(), A01(55, 12, 23) + jSONObject.toString()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A07(android.net.Uri r8) {
        /*
            r7 = this;
            java.lang.String r3 = r8.getPath()
            java.lang.String r4 = r8.getScheme()
            if (r3 == 0) goto Lbb
            if (r4 == 0) goto Lbb
            r5 = 171(0xab, float:2.4E-43)
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1816b3.A0C
            r0 = 3
            r1 = r2[r0]
            r0 = 6
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L26
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L26:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1816b3.A0C
            java.lang.String r1 = "5na5yijD7UxFpHVkXXcSH2RW6Zg"
            r0 = 5
            r2[r0] = r1
            r1 = 4
            r0 = 77
            java.lang.String r0 = A01(r5, r1, r0)
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lbb
            boolean r4 = com.facebook.ads.internal.api.BuildConfigApi.isDebug()
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1816b3.A0C
            r0 = 3
            r1 = r2[r0]
            r0 = 6
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto Lb1
            if (r4 == 0) goto L6c
        L52:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r2 = 19
            r1 = 36
            r0 = 97
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.StringBuilder r0 = r0.append(r3)
            r0.toString()
        L6c:
            com.facebook.ads.redexgen.X.gi r0 = r7.A02
            java.util.List r5 = com.facebook.ads.redexgen.core.C1571Sx.A09(r0)
            boolean r6 = A09(r3, r5)
            if (r6 != 0) goto Lb0
            boolean r0 = com.facebook.ads.internal.api.BuildConfigApi.isDebug()
            if (r0 == 0) goto L98
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r2 = 77
            r1 = 31
            r0 = 112(0x70, float:1.57E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.StringBuilder r0 = r0.append(r3)
            r0.toString()
        L98:
            java.lang.String r4 = com.facebook.ads.redexgen.core.LV.A01()
            r2 = 108(0x6c, float:1.51E-43)
            r1 = 37
            r0 = 87
            java.lang.String r0 = A01(r2, r1, r0)
            android.util.Log.w(r4, r0)
            java.lang.String r0 = r5.toString()
            r7.A06(r3, r0)
        Lb0:
            return r6
        Lb1:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1816b3.A0C
            java.lang.String r1 = "2SO0ZWlaSU1SnxqLnXbiPhTsGSHCmzPH"
            r0 = 5
            r2[r0] = r1
            if (r4 == 0) goto L6c
            goto L52
        Lbb:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1816b3.A07(android.net.Uri):boolean");
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        this.A02.A0F().AKz(this.A03.get() != null);
        if (this.A03.get() != null) {
            AtomicBoolean atomicBoolean = this.A05.get();
            String[] strArr = A0C;
            if (strArr[7].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[3] = "U2DnXjrenRRLx1oMUBfcSIJQu5ANNJpT";
            strArr2[6] = "L4ZmgD3GCXt8DfDAt3P3IJDf6GSeHMJn";
            if (atomicBoolean != null && !this.A05.get().get()) {
                this.A03.get().A0K();
            }
        }
        if (this.A04.get() != null) {
            this.A04.get().AF8();
        }
        this.A01 = true;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.A02.A0F().AL0();
        this.A00 = new Date();
        new Handler().postDelayed(new LW(this), this.A08.get());
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.A01 = true;
        A03(i, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        boolean zA12 = C1615Up.A12(this.A02);
        String strA01 = A01(0, 0, 53);
        if (zA12 || webResourceRequest.isForMainFrame()) {
            this.A01 = true;
            A03(webResourceError.getErrorCode(), strA01 + ((Object) webResourceError.getDescription()));
        } else {
            this.A02.A0F().AL1(AbstractC1674Xb.A01(webResourceError.getErrorCode(), strA01 + ((Object) webResourceError.getDescription()), strA01 + webResourceRequest.getUrl()));
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        A04(webResourceRequest, webResourceResponse);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.A02.A0F().AL3();
        sslErrorHandler.cancel();
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        AbstractC1811ay.A0D(AbstractC1577Td.A2b);
        InterfaceC1814b1 adWebViewListener = this.A04.get();
        if (adWebViewListener != null) {
            adWebViewListener.AGg();
            return true;
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url = webResourceRequest.getUrl();
        if (this.A0A && !A07(url)) {
            WebResourceResponse webResourceResponseA00 = A00();
            A04(webResourceRequest, webResourceResponseA00);
            return webResourceResponseA00;
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.A04.get() != null) {
            this.A04.get().ADN(str, new C1822b9().A03(this.A07.get()).A02(this.A06.get()).A05());
        }
        if (A0C[2].charAt(27) != 'C') {
            throw new RuntimeException();
        }
        A0C[5] = "jV60qdj1rgKoRn";
        return true;
    }
}
