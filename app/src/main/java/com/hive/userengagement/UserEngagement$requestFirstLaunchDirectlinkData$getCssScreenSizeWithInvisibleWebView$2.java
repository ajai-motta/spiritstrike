package com.hive.userengagement;

import android.R;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.hive.HiveActivity;
import com.hive.logger.LoggerImpl;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.userengagement.UserEngagement$requestFirstLaunchDirectlinkData$getCssScreenSizeWithInvisibleWebView$2", f = "UserEngagement.kt", i = {}, l = {1233}, m = "invokeSuspend", n = {}, s = {})
public final class UserEngagement$requestFirstLaunchDirectlinkData$getCssScreenSizeWithInvisibleWebView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Integer, ? extends Integer>>, Object> {
    int label;

    public UserEngagement$requestFirstLaunchDirectlinkData$getCssScreenSizeWithInvisibleWebView$2(Continuation<? super UserEngagement$requestFirstLaunchDirectlinkData$getCssScreenSizeWithInvisibleWebView$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserEngagement$requestFirstLaunchDirectlinkData$getCssScreenSizeWithInvisibleWebView$2(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends Integer, ? extends Integer>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Pair<Integer, Integer>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
        cancellableContinuationImpl.initCancellability();
        LoggerImpl.INSTANCE.d("[UserEngagement] getCssScreenSizeWithInvisibleWebView");
        HiveActivity hiveActivity = HiveActivity.INSTANCE;
        final WebView webView = new WebView(hiveActivity.getRecentActivity());
        webView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        webView.setVisibility(4);
        webView.getSettings().setJavaScriptEnabled(true);
        final ViewGroup viewGroup = (ViewGroup) hiveActivity.getRecentActivity().getWindow().getDecorView().findViewById(R.id.content);
        viewGroup.addView(webView);
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.hive.userengagement.UserEngagement$requestFirstLaunchDirectlinkData$getCssScreenSizeWithInvisibleWebView$2$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                viewGroup.removeView(webView);
            }
        });
        webView.setWebViewClient(new WebViewClient() { // from class: com.hive.userengagement.UserEngagement$requestFirstLaunchDirectlinkData$getCssScreenSizeWithInvisibleWebView$2$1$2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                final WebView webView2 = webView;
                final ViewGroup viewGroup2 = viewGroup;
                final CancellableContinuation<Pair<Integer, Integer>> cancellableContinuation = cancellableContinuationImpl;
                webView2.evaluateJavascript("(function() { return JSON.stringify({width: window.screen.width, height: window.screen.height}); })();", new ValueCallback() { // from class: com.hive.userengagement.UserEngagement$requestFirstLaunchDirectlinkData$getCssScreenSizeWithInvisibleWebView$2$1$2$onPageFinished$1
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(String str) {
                        try {
                            Intrinsics.checkNotNull(str);
                            JSONObject jSONObject = new JSONObject(StringsKt.replace$default(StringsKt.trim(str, '\"'), "\\", "", false, 4, (Object) null));
                            int i2 = jSONObject.getInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                            int i3 = jSONObject.getInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                            viewGroup2.removeView(webView2);
                            if (cancellableContinuation.isActive()) {
                                CancellableContinuation<Pair<Integer, Integer>> cancellableContinuation2 = cancellableContinuation;
                                Result.Companion companion = Result.INSTANCE;
                                cancellableContinuation2.resumeWith(Result.m7415constructorimpl(new Pair(Integer.valueOf(i2), Integer.valueOf(i3))));
                            }
                        } catch (Exception e) {
                            LoggerImpl.INSTANCE.w("[UserEngagement] getCssScreenSizeWithInvisibleWebView, exception : " + e);
                            viewGroup2.removeView(webView2);
                            if (cancellableContinuation.isActive()) {
                                Pair pairRequestFirstLaunchDirectlinkData$getCssScreenSize = UserEngagement.requestFirstLaunchDirectlinkData$getCssScreenSize(HiveActivity.INSTANCE.getRecentActivity());
                                CancellableContinuation<Pair<Integer, Integer>> cancellableContinuation3 = cancellableContinuation;
                                Result.Companion companion2 = Result.INSTANCE;
                                cancellableContinuation3.resumeWith(Result.m7415constructorimpl(new Pair(pairRequestFirstLaunchDirectlinkData$getCssScreenSize.getFirst(), pairRequestFirstLaunchDirectlinkData$getCssScreenSize.getSecond())));
                            }
                        }
                    }
                });
            }
        });
        webView.loadData("<html><body></body></html>", "text/html", "UTF-8");
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(this);
        }
        return result == coroutine_suspended ? coroutine_suspended : result;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<Integer, Integer>> continuation) {
        return ((UserEngagement$requestFirstLaunchDirectlinkData$getCssScreenSizeWithInvisibleWebView$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
