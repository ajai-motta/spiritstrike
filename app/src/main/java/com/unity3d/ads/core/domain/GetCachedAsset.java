package com.unity3d.ads.core.domain;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.facebook.share.internal.ShareConstants;
import com.unity3d.ads.core.data.model.CacheResult;
import com.unity3d.ads.core.data.repository.CacheRepository;
import com.unity3d.ads.core.extensions.StringExtensionsKt;
import com.unity3d.services.UnityAdsConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.io.files.FileSystemKt;

/* JADX INFO: compiled from: GetCachedAsset.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001d\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/unity3d/ads/core/domain/GetCachedAsset;", "", "cacheRepository", "Lcom/unity3d/ads/core/data/repository/CacheRepository;", "context", "Landroid/content/Context;", "cacheWebViewAssets", "Lcom/unity3d/ads/core/domain/CacheWebViewAssets;", "(Lcom/unity3d/ads/core/data/repository/CacheRepository;Landroid/content/Context;Lcom/unity3d/ads/core/domain/CacheWebViewAssets;)V", "getBundledAsset", "Landroid/webkit/WebResourceResponse;", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "getCachedAsset", "invoke", "webviewType", "", "tryGetWebViewAsset", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GetCachedAsset {
    private final CacheRepository cacheRepository;
    private final CacheWebViewAssets cacheWebViewAssets;
    private final Context context;

    public GetCachedAsset(CacheRepository cacheRepository, Context context, CacheWebViewAssets cacheWebViewAssets) {
        Intrinsics.checkNotNullParameter(cacheRepository, "cacheRepository");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cacheWebViewAssets, "cacheWebViewAssets");
        this.cacheRepository = cacheRepository;
        this.context = context;
        this.cacheWebViewAssets = cacheWebViewAssets;
    }

    public static /* synthetic */ WebResourceResponse invoke$default(GetCachedAsset getCachedAsset, Uri uri, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        return getCachedAsset.invoke(uri, str);
    }

    public final WebResourceResponse invoke(Uri uri, String webviewType) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(webviewType, "webviewType");
        String host = uri.getHost();
        if (host != null) {
            int iHashCode = host.hashCode();
            if (iHashCode != -1921537799) {
                if (iHashCode == -1920242293 && host.equals(UnityAdsConstants.DefaultUrls.AD_CACHE_DOMAIN)) {
                    return getCachedAsset(uri);
                }
            } else if (host.equals(UnityAdsConstants.DefaultUrls.AD_ASSET_DOMAIN)) {
                return getBundledAsset(uri);
            }
        }
        return tryGetWebViewAsset(uri, webviewType);
    }

    private final WebResourceResponse getBundledAsset(Uri uri) {
        String strSubstringAfter$default = StringsKt.substringAfter$default(String.valueOf(uri.getPath()), DomExceptionUtils.SEPARATOR, (String) null, 2, (Object) null);
        try {
            InputStream inputStreamOpen = this.context.getAssets().open(strSubstringAfter$default);
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "context.assets.open(fileName)");
            return new WebResourceResponse(StringExtensionsKt.guessMimeType(strSubstringAfter$default), null, inputStreamOpen);
        } catch (Exception unused) {
            return null;
        }
    }

    private final WebResourceResponse getCachedAsset(Uri uri) {
        File file;
        Object objM7415constructorimpl;
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "uri.toString()");
        CacheResult cacheResult = (CacheResult) BuildersKt__BuildersKt.runBlocking$default(null, new GetCachedAsset$getCachedAsset$result$1(this, StringsKt.substringAfterLast$default(string, DomExceptionUtils.SEPARATOR, (String) null, 2, (Object) null), null), 1, null);
        if (!(cacheResult instanceof CacheResult.Success) || (file = ((CacheResult.Success) cacheResult).getCachedFile().getFile()) == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            GetCachedAsset getCachedAsset = this;
            objM7415constructorimpl = Result.m7415constructorimpl(new FileInputStream(file));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
            objM7415constructorimpl = null;
        }
        FileInputStream fileInputStream = (FileInputStream) objM7415constructorimpl;
        if (fileInputStream == null) {
            return null;
        }
        String filePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(filePath, "filePath");
        String strGuessMimeType = StringExtensionsKt.guessMimeType(filePath);
        String str = strGuessMimeType;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        return new WebResourceResponse(strGuessMimeType, null, fileInputStream);
    }

    private final WebResourceResponse tryGetWebViewAsset(Uri uri, String webviewType) {
        Object objM7415constructorimpl;
        StringBuilder sb = new StringBuilder();
        sb.append(webviewType);
        sb.append(FileSystemKt.UnixPathSeparator);
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "uri.toString()");
        sb.append(StringsKt.substringAfterLast$default(StringsKt.substringBefore$default(string, "?", (String) null, 2, (Object) null), DomExceptionUtils.SEPARATOR, (String) null, 2, (Object) null));
        String string2 = sb.toString();
        File file = this.cacheWebViewAssets.getCached().get(string2);
        if (file == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            GetCachedAsset getCachedAsset = this;
            objM7415constructorimpl = Result.m7415constructorimpl(new FileInputStream(file));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
            objM7415constructorimpl = null;
        }
        FileInputStream fileInputStream = (FileInputStream) objM7415constructorimpl;
        if (fileInputStream == null) {
            return null;
        }
        String strGuessMimeType = StringExtensionsKt.guessMimeType(string2);
        String str = strGuessMimeType;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        return new WebResourceResponse(strGuessMimeType, null, fileInputStream);
    }
}
