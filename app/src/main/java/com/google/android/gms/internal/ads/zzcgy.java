package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
@ParametersAreNonnullByDefault
public interface zzcgy extends com.google.android.gms.ads.internal.client.zza, zzdgv, zzcgp, zzbot, zzcif, zzcik, zzbpf, zzbau, zzcio, com.google.android.gms.ads.internal.zzn, zzcir, zzcis, zzcdr, zzcit {
    boolean canGoBack();

    void destroy();

    @Override // com.google.android.gms.internal.ads.zzcik, com.google.android.gms.internal.ads.zzcdr
    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    int getWidth();

    void goBack();

    boolean isAttachedToWindow();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    @Override // com.google.android.gms.internal.ads.zzcdr
    void setBackgroundColor(int i);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    @Override // com.google.android.gms.internal.ads.zzcgp
    zzffu zzC();

    WebView zzD();

    @Override // com.google.android.gms.internal.ads.zzcit
    View zzE();

    List zzF();

    void zzG();

    void zzH(int i);

    void zzI();

    void zzJ();

    Context zzK();

    com.google.android.gms.ads.internal.overlay.zzm zzL();

    com.google.android.gms.ads.internal.overlay.zzm zzM();

    @Override // com.google.android.gms.internal.ads.zzciq
    zzcji zzN();

    String zzO();

    zzciw zzP();

    WebViewClient zzQ();

    boolean zzR();

    @Override // com.google.android.gms.internal.ads.zzcir
    zzaxa zzS();

    zzfgr zzT();

    zzehf zzU();

    zzehd zzV();

    boolean zzW();

    boolean zzX();

    void zzY();

    boolean zzZ();

    boolean zzaA(boolean z, int i);

    boolean zzaB();

    @Override // com.google.android.gms.internal.ads.zzcif
    zzffx zzaC();

    void zzaD(zzffu zzffuVar, zzffx zzffxVar);

    void zzaE(boolean z);

    ListenableFuture zzaF();

    void zzaG(boolean z);

    boolean zzaa();

    void zzab(String str, zzblx zzblxVar);

    void zzac(String str, zzblx zzblxVar);

    void zzad(String str, Predicate predicate);

    void zzae(com.google.android.gms.ads.internal.overlay.zzm zzmVar);

    void zzaf(zzcji zzcjiVar);

    void zzag(boolean z);

    void zzah();

    void zzai(Context context);

    void zzaj(boolean z);

    void zzak(zzehf zzehfVar);

    void zzal(zzehd zzehdVar);

    void zzam(int i);

    void zzan(com.google.android.gms.ads.internal.overlay.zzm zzmVar);

    void zzao(boolean z);

    void zzap();

    void zzaq(zzbhv zzbhvVar);

    zzbhv zzar();

    void zzas(boolean z);

    void zzat();

    void zzau(String str, String str2, String str3);

    void zzav();

    void zzaw(boolean z);

    void zzax(zzbhs zzbhsVar);

    void zzay(zzbch zzbchVar);

    zzbch zzaz();

    @Override // com.google.android.gms.internal.ads.zzcdr
    zzcie zzh();

    @Override // com.google.android.gms.internal.ads.zzcik, com.google.android.gms.internal.ads.zzcdr
    Activity zzj();

    @Override // com.google.android.gms.internal.ads.zzcdr
    com.google.android.gms.ads.internal.zza zzk();

    @Override // com.google.android.gms.internal.ads.zzcdr
    zzbfh zzq();

    @Override // com.google.android.gms.internal.ads.zzcis, com.google.android.gms.internal.ads.zzcdr
    VersionInfoParcel zzs();

    @Override // com.google.android.gms.internal.ads.zzcdr
    void zzt(String str, zzcfe zzcfeVar);

    @Override // com.google.android.gms.internal.ads.zzcdr
    void zzw(zzcie zzcieVar);
}
