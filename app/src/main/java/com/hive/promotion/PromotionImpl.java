package com.hive.promotion;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.compose.animation.core.ComplexDouble$$ExternalSyntheticBackport0;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.provider.FontsContractCompat;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.HiveActivity;
import com.hive.Promotion;
import com.hive.ResultAPI;
import com.hive.analytics.AnalyticsImpl;
import com.hive.analytics.provider.AnalyticsProviderAdapter;
import com.hive.analytics.provider.adjust.AnalyticsProviderAdjust;
import com.hive.base.Android;
import com.hive.base.HivePicture;
import com.hive.base.Property;
import com.hive.base.PropertyKeys;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.ExtentionsKt;
import com.hive.core.HiveCoreInitializer;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Scheme;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.ModuleCheckName;
import com.hive.module.interfaces.HivePromotion;
import com.hive.module.interfaces.HiveUserEngagement;
import com.hive.module.interfaces.promotion.GoogleInAppReview;
import com.hive.platformhelper.InAppBrowser;
import com.hive.platformhelper.InAppBrowserData;
import com.hive.promotion.EngagementErrorDialog;
import com.hive.promotion.PromotionDialog;
import com.hive.promotion.PromotionExitDialog;
import com.hive.promotion.PromotionImpl;
import com.hive.promotion.PromotionNetwork;
import com.hive.promotion.ui.PromotionReviewDialog;
import com.hive.promotion.ui.PromotionView;
import com.hive.promotion.ui.customreview.CustomReview;
import com.hive.promotion.ui.customreview.PromotionCustomReview;
import com.hive.promotion.ui.customreview.PromotionCustomReviewListener;
import com.hive.promotion.ui.news.BannerList;
import com.hive.promotion.ui.news.Navigation;
import com.hive.promotion.ui.news.NewsV2Activity;
import com.hive.protocol.promotionv2.Badge;
import com.hive.protocol.promotionv2.Banner;
import com.hive.protocol.promotionv2.Init;
import com.hive.protocol.promotionv2.MoreGames;
import com.hive.protocol.promotionv2.MoreGamesClick;
import com.hive.protocol.promotionv2.NewsLogClickBanner;
import com.hive.protocol.promotionv2.Review;
import com.hive.protocol.promotionv2.ReviewClick;
import com.hive.protocol.promotionv2.UaSenderInfo;
import com.hive.protocol.promotionv2.UaUser;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import com.hive.ui.Resource;
import com.hive.userengagement.DeferredDeeplinkActivity;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PromotionImpl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Ì\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002É\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u00100\u001a\u000201J\u0010\u00102\u001a\u0002012\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u0002012\u0006\u00106\u001a\u00020-H\u0002J,\u00107\u001a\u0002012\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00142\b\u0010;\u001a\u0004\u0018\u00010-2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J(\u0010>\u001a\u0002012\u0006\u0010;\u001a\u00020-2\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@2\u0006\u0010<\u001a\u00020=H\u0016JC\u00107\u001a\u0002012\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00142\b\u0010;\u001a\u0004\u0018\u00010-2\u0010\b\u0002\u0010?\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@2\b\u0010<\u001a\u0004\u0018\u00010=H\u0000¢\u0006\u0002\bBJ>\u0010C\u001a\u0002012\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00142\b\u0010;\u001a\u0004\u0018\u00010-2\u0010\b\u0002\u0010?\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@2\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J,\u0010D\u001a\u0002012\u0006\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010-2\u0006\u0010H\u001a\u00020\u00142\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0012\u0010I\u001a\u0002012\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0012\u0010J\u001a\u0002012\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u001c\u0010K\u001a\u0002012\u0006\u0010L\u001a\u00020M2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u001c\u0010N\u001a\u0002012\u0006\u0010L\u001a\u00020M2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u001c\u0010O\u001a\u0002012\u0006\u0010L\u001a\u00020M2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=H\u0002J\b\u0010P\u001a\u000201H\u0016J\u0010\u0010Q\u001a\u0002012\u0006\u0010R\u001a\u00020-H\u0002J\u0012\u0010S\u001a\u0002012\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010T\u001a\u0002012\u0006\u0010R\u001a\u00020-H\u0002J\"\u0010U\u001a\u0002012\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020-2\b\u0010<\u001a\u0004\u0018\u00010VH\u0016J(\u0010W\u001a\u0002012\u0006\u0010X\u001a\u00020A2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00142\b\u0010<\u001a\u0004\u0018\u00010YJ(\u0010Z\u001a\u0002012\u0006\u0010X\u001a\u00020A2\u0006\u0010E\u001a\u00020F2\u0006\u0010[\u001a\u00020-2\b\u0010<\u001a\u0004\u0018\u00010YJ6\u0010\\\u001a\u00020]2\u0006\u0010:\u001a\u00020\u00142\u0006\u0010X\u001a\u00020A2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020A2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020b0@H\u0002J\u0012\u0010c\u001a\u0002012\b\u0010<\u001a\u0004\u0018\u00010dH\u0016J\"\u0010e\u001a\u0002012\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020i2\b\u0010<\u001a\u0004\u0018\u00010jH\u0016J\"\u0010k\u001a\u0002012\u0006\u0010f\u001a\u00020-2\u0006\u0010h\u001a\u00020-2\b\u0010<\u001a\u0004\u0018\u00010jH\u0016J\u0012\u0010l\u001a\u0002012\b\u0010<\u001a\u0004\u0018\u00010mH\u0016J\u001c\u0010l\u001a\u0002012\b\u0010n\u001a\u0004\u0018\u00010-2\b\u0010<\u001a\u0004\u0018\u00010mH\u0016J\u0012\u0010o\u001a\u0002012\b\u0010<\u001a\u0004\u0018\u00010pH\u0016J(\u0010q\u001a\u0002012\u0006\u0010r\u001a\u00020-2\u0006\u0010s\u001a\u00020-2\u0006\u0010t\u001a\u00020\u00142\u0006\u0010<\u001a\u00020uH\u0016J\u0010\u0010v\u001a\u0002012\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010w\u001a\u000201H\u0016J\u000e\u0010x\u001a\u0002012\u0006\u0010y\u001a\u00020\u0014J\u0016\u0010z\u001a\u0002012\u0006\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020~J\u0011\u0010\u007f\u001a\u0002012\u0007\u0010<\u001a\u00030\u0080\u0001H\u0016J\u0013\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u0014H\u0016J\u0012\u0010\u0084\u0001\u001a\u00020\u00142\u0007\u0010\u0085\u0001\u001a\u00020-H\u0016J\u0019\u0010\u0086\u0001\u001a\u0002012\u0007\u0010\u0087\u0001\u001a\u00020-2\u0007\u0010<\u001a\u00030\u0088\u0001J\u001b\u0010\u0089\u0001\u001a\u0002012\u0007\u0010\u008a\u0001\u001a\u00020-2\u0007\u0010\u008b\u0001\u001a\u00020\u0014H\u0016J\u0007\u0010\u008c\u0001\u001a\u000201J\t\u0010\u008d\u0001\u001a\u00020\u0014H\u0002J\t\u0010\u008e\u0001\u001a\u000201H\u0002J\u0014\u0010\u008f\u0001\u001a\u00020\u00142\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010-H\u0002J\u0014\u0010\u0091\u0001\u001a\u0002012\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010-H\u0002J\t\u0010\u0092\u0001\u001a\u00020-H\u0002J-\u0010\u0093\u0001\u001a\u0002012\u0006\u0010{\u001a\u00020|2\u0007\u0010\u0094\u0001\u001a\u00020A2\u0007\u0010\u0095\u0001\u001a\u00020A2\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001J\u0011\u0010\u0098\u0001\u001a\u00020\u00142\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001J\u0013\u0010\u009b\u0001\u001a\u0002012\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0002J\u0013\u0010\u009c\u0001\u001a\u00020\u00142\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0002J\u0013\u0010\u009d\u0001\u001a\u00020\u00142\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0002J\t\u0010\u009e\u0001\u001a\u000201H\u0002J\u0013\u0010\u009f\u0001\u001a\u00020\u00142\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0002J\u001d\u0010 \u0001\u001a\t\u0012\u0005\u0012\u00030¡\u00010@2\r\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u00020b0@J\u0019\u0010£\u0001\u001a\u00020-2\b\u0010¤\u0001\u001a\u00030¡\u00012\u0006\u0010:\u001a\u00020-J\t\u0010¥\u0001\u001a\u000201H\u0016J\u0010\u0010¦\u0001\u001a\u000201H\u0083@¢\u0006\u0003\u0010§\u0001J\u0013\u0010¨\u0001\u001a\u0002012\b\u0010©\u0001\u001a\u00030ª\u0001H\u0002J \u0010«\u0001\u001a\u0002012\u000e\u0010¬\u0001\u001a\t\u0012\u0005\u0012\u00030\u00ad\u00010@H\u0083@¢\u0006\u0003\u0010®\u0001J\u001a\u0010¯\u0001\u001a\u00020\u00142\b\u0010°\u0001\u001a\u00030±\u0001H\u0082@¢\u0006\u0003\u0010²\u0001J\u0010\u0010³\u0001\u001a\u0002012\u0007\u0010´\u0001\u001a\u00020-J\u0010\u0010µ\u0001\u001a\u00020-2\u0007\u0010¶\u0001\u001a\u000209J\u0011\u0010·\u0001\u001a\u0004\u0018\u00010-H\u0000¢\u0006\u0003\b¸\u0001J\u000f\u0010¹\u0001\u001a\u000201H\u0000¢\u0006\u0003\bº\u0001J\u0019\u0010»\u0001\u001a\u0002012\b\u0010¼\u0001\u001a\u00030½\u0001H\u0000¢\u0006\u0003\b¾\u0001J\u0013\u0010¿\u0001\u001a\u0002012\b\u0010À\u0001\u001a\u00030\u0082\u0001H\u0016J(\u0010Á\u0001\u001a\u0002012\u0007\u0010Â\u0001\u001a\u00020]2\u0014\u0010<\u001a\u0010\u0012\u0005\u0012\u00030\u0082\u0001\u0012\u0004\u0012\u0002010Ã\u0001H\u0016J\t\u0010Ä\u0001\u001a\u00020\u0014H\u0016J\t\u0010Å\u0001\u001a\u00020\u0014H\u0016J\t\u0010Æ\u0001\u001a\u000201H\u0016J\u0016\u0010Ç\u0001\u001a\u000f\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-0È\u0001H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\"\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u0006Ê\u0001"}, d2 = {"Lcom/hive/promotion/PromotionImpl;", "Lcom/hive/module/interfaces/HivePromotion;", "<init>", "()V", "PROMOTION_DIALOG_FINISH_DELAY", "", "mPromotionDialogListener", "Lcom/hive/promotion/PromotionDialog$PromotionDialogListener;", "getMPromotionDialogListener", "()Lcom/hive/promotion/PromotionDialog$PromotionDialogListener;", "setMPromotionDialogListener", "(Lcom/hive/promotion/PromotionDialog$PromotionDialogListener;)V", "mPromotionDialogOfferwallListener", "getMPromotionDialogOfferwallListener", "setMPromotionDialogOfferwallListener", "mPromotionDialog", "Lcom/hive/promotion/PromotionDialog;", "mShowingPromotion", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mShowingOfferwall", "", "mShowingReview", "mShowingExit", "runningUpdate", "waitingUpdate", "waitingShow", "Ljava/util/concurrent/atomic/AtomicReference;", "Ljava/lang/Runnable;", "userEngagement", "Lcom/hive/module/interfaces/HiveUserEngagement;", "getUserEngagement", "()Lcom/hive/module/interfaces/HiveUserEngagement;", "userEngagement$delegate", "Lkotlin/Lazy;", "progressedCpi", "progressedLogin", "getProgressedLogin$hive_promotion_release", "()Z", "setProgressedLogin$hive_promotion_release", "(Z)V", "offerwallState", "Lcom/hive/Promotion$OfferwallState;", "getOfferwallState", "()Lcom/hive/Promotion$OfferwallState;", "additionalInfo", "", "getAdditionalInfo", "()Ljava/lang/String;", MobileAdsBridgeBase.initializeMethodName, "", "loadImageOnDiskCacheAndSendLog", "jsonArray", "Lorg/json/JSONArray;", "loadImageOnDiskCache", "url", "showPromotion", "promotionViewType", "Lcom/hive/Promotion$PromotionViewType;", "isForced", "menu", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/Promotion$PromotionViewListener;", "showNews", "giftPidList", "Ljava/util/ArrayList;", "", "showPromotion$hive_promotion_release", "internalShowPromotion", "showCustomContents", "promotionCustomType", "Lcom/hive/Promotion$PromotionCustomType;", "contentKey", "isHiveUiActivity", "showOfferwall", "showReview", "internalShowReview", "review", "Lcom/hive/protocol/promotionv2/Review;", "showHiveLegacyReview", "showHiveCustomReview", "showNativeReview", "logReview", "userSelected", "showExit", "logExit", "getViewInfo", "Lcom/hive/Promotion$PromotionViewInfoListener;", "getViewInfoWithViewTypeForMercury", "mercuryViewID", "Lcom/hive/Promotion$PromotionViewInfoWithJSONListener;", "getViewInfoWithCustomTypeForMercury", "content_key", "combineViewInfoForMercury", "Lorg/json/JSONObject;", "init", "Lcom/hive/protocol/promotionv2/Init;", "count", "webViewInfoList", "Lcom/hive/promotion/PromotionNetwork$WebViewInfo;", "getBadgeInfo", "Lcom/hive/Promotion$PromotionBadgeInfoListener;", "getBannerInfo", "campaignType", "Lcom/hive/Promotion$PromotionCampaignType;", "bannerType", "Lcom/hive/Promotion$PromotionBannerType;", "Lcom/hive/Promotion$PromotionBannerInfoListener;", "getBannerInfoString", "getAppInvitationData", "Lcom/hive/Promotion$AppInvitationDataListener;", "inviteUserInfo", "getAppInvitationSenderInfo", "Lcom/hive/Promotion$AppInvitationSenderInfoListener;", "showUAShare", "inviteMessage", "inviteLink", "isIdentifier", "Lcom/hive/Promotion$PromotionShareListener;", "setAdditionalInfo", "setAcquisitionAchieved", "onNetworkAvailable", "isAvailable", "onConfigurationChanged", "activity", "Landroid/app/Activity;", "newConfig", "Landroid/content/res/Configuration;", "setEngagementListener", "Lcom/hive/Promotion$EngagementListener;", "setEngagementReady", "Lcom/hive/ResultAPI;", "bEnabled", "processUri", ShareConstants.MEDIA_URI, "consumeCoupon", "couponCode", "Lcom/hive/module/interfaces/HiveUserEngagement$CouponListener;", "requestDownloadInfo", "authType", "isAgreementDetermineBaseAccount", "requestLogin", "isUpdatedDownloadInfo", "saveDownloadInfoVersion", "isSentCpiPlayerId", "accountId", "saveSentCpiPlayerId", "getTodayYearMonthDate", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "processPromotionScheme", "scheme", "Lcom/hive/core/Scheme;", "processInterworkScheme", "handlePromotionViewNativeScheme", "handleHiveSocialScheme", "showEngagementErrorDialog", "handleNewsNativeScheme", "convertWebViewInfoList", "Lcom/hive/promotion/ui/PromotionView$WebViewInfo;", "arrayList", "generatePromotionViewPostData", "webViewInfo", "updatePromotionData", "requestNavigation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preLoadImageNavigation", NotificationCompat.CATEGORY_NAVIGATION, "Lcom/hive/promotion/ui/news/Navigation;", "requestBannerList", "menuList", "Lcom/hive/promotion/PromotionNetwork$Menu;", "(Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preLoadImageBannerList", "bannerList", "Lcom/hive/promotion/ui/news/BannerList;", "(Lcom/hive/promotion/ui/news/BannerList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveForceTime", "key", "getForceTime", "type", "getDeferredDeeplinkInfo", "getDeferredDeeplinkInfo$hive_promotion_release", "removeDeferredDeeplinkInfo", "removeDeferredDeeplinkInfo$hive_promotion_release", "requestIncreaseCount", "supportType", "Lcom/hive/promotion/PromotionNetwork$IncreaseCountSupportType;", "requestIncreaseCount$hive_promotion_release", "needDialogClosed", "resultAPI", "requestCompanion", "parameterJson", "Lkotlin/Function1;", "newsV2IsShow", "newsV2ShowOfferwall", "newsV2Finish", "getVersionInfo", "", "PromotionWebChromeClient", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromotionImpl implements HivePromotion {
    private static final long PROMOTION_DIALOG_FINISH_DELAY = 100;
    private static PromotionDialog mPromotionDialog;
    private static PromotionDialog.PromotionDialogListener mPromotionDialogListener;
    private static PromotionDialog.PromotionDialogListener mPromotionDialogOfferwallListener;
    private static boolean mShowingExit;
    private static boolean mShowingOfferwall;
    private static boolean mShowingReview;
    private static boolean progressedCpi;
    private static boolean progressedLogin;
    public static final PromotionImpl INSTANCE = new PromotionImpl();
    private static AtomicBoolean mShowingPromotion = new AtomicBoolean(false);
    private static AtomicBoolean runningUpdate = new AtomicBoolean(false);
    private static AtomicBoolean waitingUpdate = new AtomicBoolean(false);
    private static AtomicReference<Runnable> waitingShow = new AtomicReference<>(null);

    /* JADX INFO: renamed from: userEngagement$delegate, reason: from kotlin metadata */
    private static final Lazy userEngagement = LazyKt.lazy(new Function0() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda28
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return PromotionImpl.userEngagement_delegate$lambda$0();
        }
    });

    /* JADX INFO: compiled from: PromotionImpl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[Promotion.PromotionViewType.values().length];
            try {
                iArr[Promotion.PromotionViewType.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Promotion.PromotionViewType.NEWS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Promotion.PromotionViewType.NOTICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Promotion.PromotionViewType.BANNERLEGACY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Promotion.PromotionCustomType.values().length];
            try {
                iArr2[Promotion.PromotionCustomType.BOARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[Promotion.PromotionCustomType.DIRECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[Promotion.PromotionCustomType.SPOT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[Promotion.PromotionCustomType.VIEW.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[HiveUserEngagement.InterworkApi.values().length];
            try {
                iArr3[HiveUserEngagement.InterworkApi.OFFERWALLSHOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[HiveUserEngagement.InterworkApi.PROMOTIONOFFERWALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    /* JADX INFO: renamed from: com.hive.promotion.PromotionImpl$requestBannerList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PromotionImpl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.promotion.PromotionImpl", f = "PromotionImpl.kt", i = {}, l = {2895}, m = "requestBannerList", n = {}, s = {})
    static final class C29381 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C29381(Continuation<? super C29381> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PromotionImpl.this.requestBannerList(null, this);
        }
    }

    /* JADX INFO: renamed from: com.hive.promotion.PromotionImpl$requestNavigation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PromotionImpl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.promotion.PromotionImpl", f = "PromotionImpl.kt", i = {0}, l = {2838, 2842}, m = "requestNavigation", n = {"menuList"}, s = {"L$0"})
    static final class C29401 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C29401(Continuation<? super C29401> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PromotionImpl.this.requestNavigation(this);
        }
    }

    private PromotionImpl() {
    }

    @Override // com.hive.module.interfaces.HivePromotion, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return HivePromotion.DefaultImpls.getHiveModuleName(this);
    }

    public final PromotionDialog.PromotionDialogListener getMPromotionDialogListener() {
        return mPromotionDialogListener;
    }

    public final void setMPromotionDialogListener(PromotionDialog.PromotionDialogListener promotionDialogListener) {
        mPromotionDialogListener = promotionDialogListener;
    }

    public final PromotionDialog.PromotionDialogListener getMPromotionDialogOfferwallListener() {
        return mPromotionDialogOfferwallListener;
    }

    public final void setMPromotionDialogOfferwallListener(PromotionDialog.PromotionDialogListener promotionDialogListener) {
        mPromotionDialogOfferwallListener = promotionDialogListener;
    }

    static {
        new PromotionLifecycle();
    }

    private final HiveUserEngagement getUserEngagement() {
        return (HiveUserEngagement) userEngagement.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HiveUserEngagement userEngagement_delegate$lambda$0() {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = HiveUserEngagement.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof HiveUserEngagement)) {
            hiveModule = null;
        }
        return (HiveUserEngagement) (hiveModule instanceof HiveUserEngagement ? hiveModule : null);
    }

    public final boolean getProgressedLogin$hive_promotion_release() {
        return progressedLogin;
    }

    public final void setProgressedLogin$hive_promotion_release(boolean z) {
        progressedLogin = z;
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public Promotion.OfferwallState getOfferwallState() {
        String value = Property.INSTANCE.getINSTANCE().getValue(PromotionKeys.OFFERWALL_STATE, "");
        return Intrinsics.areEqual(value, AppEventsConstants.EVENT_PARAM_VALUE_NO) ? Promotion.OfferwallState.DISABLED : Intrinsics.areEqual(value, "1") ? Promotion.OfferwallState.ENABLED : Promotion.OfferwallState.UNKNOWN;
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public String getAdditionalInfo() {
        return PromotionNetwork.INSTANCE.getAdditionalInfo();
    }

    public final void initialize() {
        PromotionDialog.INSTANCE.checkSavedToday();
        PromotionNetwork.init$default(PromotionNetwork.INSTANCE, null, Promotion.PromotionWebviewType.OFFERWALL, true, false, null, new Function3() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return PromotionImpl.initialize$lambda$1((Init) obj, ((Integer) obj2).intValue(), (ArrayList) obj3);
            }
        }, 24, null);
        PromotionNetwork.init$default(PromotionNetwork.INSTANCE, null, Promotion.PromotionWebviewType.BANNER_DETAIL, true, true, null, new Function3() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return PromotionImpl.initialize$lambda$6((Init) obj, ((Integer) obj2).intValue(), (ArrayList) obj3);
            }
        }, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialize$lambda$1(Init init, int i, ArrayList webViewInfoList) {
        Intrinsics.checkNotNullParameter(init, "init");
        Intrinsics.checkNotNullParameter(webViewInfoList, "webViewInfoList");
        if (init.getResponse().isFailure()) {
            LoggerImpl.INSTANCE.w("[Promotion::initialize] request failed");
            return Unit.INSTANCE;
        }
        LoggerImpl.INSTANCE.i("[Promotion::initialize] success");
        if (Intrinsics.areEqual(((PromotionNetwork.WebViewInfo) webViewInfoList.get(0)).getTypeWebView(), Promotion.PromotionWebviewType.OFFERWALL.getValue())) {
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), PromotionKeys.OFFERWALL_STATE, String.valueOf(((PromotionNetwork.WebViewInfo) webViewInfoList.get(0)).getState()), null, 4, null);
            Property.INSTANCE.getINSTANCE().writeProperties();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialize$lambda$6(Init init, int i, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(init, "init");
        Intrinsics.checkNotNullParameter(arrayList, "<unused var>");
        if (init.getResponse().isFailure()) {
            LoggerImpl.INSTANCE.wL("[Promotion::initialize] promotion banner detail request failed : " + init.getResponse());
            LoggerImpl.INSTANCE.wR("[Promotion::initialize] promotion banner detail request failed");
            return Unit.INSTANCE;
        }
        LoggerImpl.INSTANCE.i("[Promotion::initialize] promotion banner detail success");
        JSONArray imageList = init.getResponse().getImageList();
        if (imageList != null) {
            INSTANCE.loadImageOnDiskCacheAndSendLog(imageList);
        }
        JSONArray activateCrossPidList = init.getResponse().getActivateCrossPidList();
        if (activateCrossPidList != null) {
            JSONArray jSONArray = new JSONArray();
            int length = activateCrossPidList.length();
            for (int i2 = 0; i2 < length; i2++) {
                String strOptString = activateCrossPidList.optString(i2);
                Intrinsics.checkNotNull(strOptString);
                if (strOptString.length() > 0) {
                    String pidOpenCountString = PromotionDialog.INSTANCE.getPidOpenCountString(strOptString);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(AnalyticsProviderAdjust.EventKeys.pid, strOptString);
                        String str = pidOpenCountString;
                        if (str.length() == 0) {
                            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                        }
                        jSONObject.put("count", str);
                        jSONArray.put(jSONObject);
                    } catch (Exception e) {
                        LoggerImpl.INSTANCE.w("[Promotion::initialize] exception: " + e.getMessage());
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), PromotionKeys.PID_OPEN_INFO, jSONArray.toString(), null, 4, null);
            Property.INSTANCE.getINSTANCE().writeProperties();
        }
        return Unit.INSTANCE;
    }

    private final void loadImageOnDiskCacheAndSendLog(JSONArray jsonArray) {
        if (jsonArray.length() == 0) {
            LoggerImpl.INSTANCE.w("[Promotion::loadImageOnDiskCacheAndSendLog] array is empty.");
            return;
        }
        final long jNanoTime = System.nanoTime();
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        final int length = jsonArray.length();
        final AtomicInteger atomicInteger2 = new AtomicInteger(0);
        for (int i = 0; i < length; i++) {
            final String strOptString = jsonArray.optString(i);
            Glide.with(HiveActivity.INSTANCE.getRecentActivity()).load(strOptString).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.DATA).listener(new RequestListener<Drawable>() { // from class: com.hive.promotion.PromotionImpl.loadImageOnDiskCacheAndSendLog.1
                @Override // com.bumptech.glide.request.RequestListener
                public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                    Intrinsics.checkNotNullParameter(target, "target");
                    LoggerImpl.INSTANCE.w("[Promotion::loadImageOnDiskCache] onLoadFailed(url: " + strOptString + ")\nGlideException: " + e);
                    if (atomicInteger.addAndGet(1) != length) {
                        return false;
                    }
                    AnalyticsImpl.INSTANCE.sendPromotionImageDownloadLog((System.nanoTime() - jNanoTime) / ((long) 1000000), length, atomicInteger2.get());
                    return false;
                }

                @Override // com.bumptech.glide.request.RequestListener
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                    Intrinsics.checkNotNullParameter(resource, "resource");
                    Intrinsics.checkNotNullParameter(model, "model");
                    Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                    LoggerImpl.INSTANCE.d("[Promotion::loadImageOnDiskCache] onResourceReady(url: " + strOptString + ')');
                    atomicInteger2.addAndGet(1);
                    if (atomicInteger.addAndGet(1) != length) {
                        return false;
                    }
                    AnalyticsImpl.INSTANCE.sendPromotionImageDownloadLog((System.nanoTime() - jNanoTime) / ((long) 1000000), length, atomicInteger2.get());
                    return false;
                }
            }).preload();
        }
    }

    private final void loadImageOnDiskCache(final String url) {
        if (StringsKt.isBlank(url)) {
            LoggerImpl.INSTANCE.w("[Promotion::loadImageOnDiskCache] url is empty.");
        } else {
            Glide.with(HiveActivity.INSTANCE.getRecentActivity()).load(url).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.DATA).listener(new RequestListener<Drawable>() { // from class: com.hive.promotion.PromotionImpl.loadImageOnDiskCache.1
                @Override // com.bumptech.glide.request.RequestListener
                public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                    Intrinsics.checkNotNullParameter(target, "target");
                    LoggerImpl.INSTANCE.w("[Promotion::loadImageOnDiskCache] onLoadFailed(url: " + url + ")\nGlideException: " + e);
                    return false;
                }

                @Override // com.bumptech.glide.request.RequestListener
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                    Intrinsics.checkNotNullParameter(resource, "resource");
                    Intrinsics.checkNotNullParameter(model, "model");
                    Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                    LoggerImpl.INSTANCE.d("[Promotion::loadImageOnDiskCache] onResourceReady(url: " + url + ')');
                    return false;
                }
            }).preload();
        }
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public void showPromotion(Promotion.PromotionViewType promotionViewType, boolean isForced, String menu, Promotion.PromotionViewListener listener) {
        Intrinsics.checkNotNullParameter(promotionViewType, "promotionViewType");
        showPromotion$hive_promotion_release(promotionViewType, isForced, menu, null, listener);
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public void showNews(String menu, ArrayList<Integer> giftPidList, Promotion.PromotionViewListener listener) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(listener, "listener");
        showPromotion$hive_promotion_release(Promotion.PromotionViewType.NEWS, true, menu, giftPidList, listener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showPromotion$hive_promotion_release$default(PromotionImpl promotionImpl, Promotion.PromotionViewType promotionViewType, boolean z, String str, ArrayList arrayList, Promotion.PromotionViewListener promotionViewListener, int i, Object obj) {
        if ((i & 8) != 0) {
            arrayList = null;
        }
        promotionImpl.showPromotion$hive_promotion_release(promotionViewType, z, str, arrayList, promotionViewListener);
    }

    public final void showPromotion$hive_promotion_release(final Promotion.PromotionViewType promotionViewType, final boolean isForced, final String menu, final ArrayList<Integer> giftPidList, final Promotion.PromotionViewListener listener) {
        Intrinsics.checkNotNullParameter(promotionViewType, "promotionViewType");
        if (runningUpdate.get()) {
            if (ComplexDouble$$ExternalSyntheticBackport0.m(waitingShow, null, new Runnable() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PromotionImpl.showPromotion$lambda$7(promotionViewType, isForced, menu, giftPidList, listener);
                }
            })) {
                return;
            }
            String str = "Promotion.showPromotion(PromotionViewType: " + promotionViewType.name() + ") has already been called during update data.";
            LoggerImpl.INSTANCE.i(str);
            ResultAPI resultAPI = new ResultAPI(-3, ResultAPI.Code.PromotionAlreadyShowing, str);
            if (listener != null) {
                listener.onPromotionView(resultAPI, Promotion.PromotionViewResultType.CLOSED);
                return;
            }
            return;
        }
        internalShowPromotion(promotionViewType, isForced, menu, giftPidList, listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPromotion$lambda$7(Promotion.PromotionViewType promotionViewType, boolean z, String str, ArrayList arrayList, Promotion.PromotionViewListener promotionViewListener) {
        INSTANCE.internalShowPromotion(promotionViewType, z, str, arrayList, promotionViewListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void internalShowPromotion$default(PromotionImpl promotionImpl, Promotion.PromotionViewType promotionViewType, boolean z, String str, ArrayList arrayList, Promotion.PromotionViewListener promotionViewListener, int i, Object obj) {
        if ((i & 8) != 0) {
            arrayList = null;
        }
        promotionImpl.internalShowPromotion(promotionViewType, z, str, arrayList, promotionViewListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void internalShowPromotion(final com.hive.Promotion.PromotionViewType r19, boolean r20, java.lang.String r21, java.util.ArrayList<java.lang.Integer> r22, final com.hive.Promotion.PromotionViewListener r23) {
        /*
            Method dump skipped, instruction units count: 648
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.promotion.PromotionImpl.internalShowPromotion(com.hive.Promotion$PromotionViewType, boolean, java.lang.String, java.util.ArrayList, com.hive.Promotion$PromotionViewListener):void");
    }

    /* JADX INFO: renamed from: com.hive.promotion.PromotionImpl$internalShowPromotion$3, reason: invalid class name */
    /* JADX INFO: compiled from: PromotionImpl.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/hive/promotion/PromotionImpl$internalShowPromotion$3", "Lcom/hive/promotion/ui/news/NewsV2Activity$ButtonClickedListener;", "onClose", "", "onBanner", ReportUtil.INVENTORY_TYPE_BANNER, "Lcom/hive/promotion/ui/news/BannerList$Banner;", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass3 implements NewsV2Activity.ButtonClickedListener {
        final /* synthetic */ Ref.ObjectRef<Promotion.PromotionViewListener> $showPromotionListener;

        AnonymousClass3(Ref.ObjectRef<Promotion.PromotionViewListener> objectRef) {
            this.$showPromotionListener = objectRef;
        }

        @Override // com.hive.promotion.ui.news.NewsV2Activity.ButtonClickedListener
        public void onClose() {
            PromotionImpl.mShowingPromotion.set(false);
            if (this.$showPromotionListener.element != null) {
                Promotion.PromotionViewListener promotionViewListener = this.$showPromotionListener.element;
                if (promotionViewListener != null) {
                    promotionViewListener.onPromotionView(new ResultAPI(), Promotion.PromotionViewResultType.CLOSED);
                }
                this.$showPromotionListener.element = null;
            }
        }

        @Override // com.hive.promotion.ui.news.NewsV2Activity.ButtonClickedListener
        public void onBanner(BannerList.Banner banner) {
            Intrinsics.checkNotNullParameter(banner, "banner");
            PromotionNetwork.INSTANCE.newsLogClickAPI(banner.getPid(), new Function1() { // from class: com.hive.promotion.PromotionImpl$internalShowPromotion$3$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PromotionImpl.AnonymousClass3.onBanner$lambda$0((NewsLogClickBanner) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onBanner$lambda$0(NewsLogClickBanner it) {
            Intrinsics.checkNotNullParameter(it, "it");
            if (it.getResponse().isSuccess()) {
                LoggerImpl.INSTANCE.dR("[Promotion::newsLogClick] response success");
                LoggerImpl.INSTANCE.dL("[Promotion::newsLogClick] response success : " + it.getResponse());
            } else {
                LoggerImpl.INSTANCE.wR("[Promotion::newsLogClick] request failed");
                LoggerImpl.INSTANCE.wL("[Promotion::newsLogClick] request failed : " + it.getResponse());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean internalShowPromotion$lambda$13(Scheme scheme) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        return INSTANCE.processPromotionScheme(scheme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit internalShowPromotion$lambda$19(String str, Promotion.PromotionViewListener promotionViewListener, boolean z, Promotion.PromotionWebviewType promotionWebviewType, Init init, int i, ArrayList webViewInfoList) {
        Intrinsics.checkNotNullParameter(init, "init");
        Intrinsics.checkNotNullParameter(webViewInfoList, "webViewInfoList");
        if (init.getResponse().getResult().isFailure()) {
            LoggerImpl.INSTANCE.w("[Promotion::showPromotion] request failed");
            LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, init.getResponse().getResult().toString());
            if (promotionViewListener != null) {
                promotionViewListener.onPromotionView(new ResultAPI(-5, ResultAPI.Code.PromotionNetworkError), Promotion.PromotionViewResultType.CLOSED);
            }
        } else if (init.getResponse().isFailure()) {
            LoggerImpl.INSTANCE.w("[Promotion::showPromotion] response failed");
            ResultAPI resultAPI = new ResultAPI(-8, ResultAPI.Code.PromotionServerResponseError, init.getResponse().getResultMessage());
            LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, resultAPI.toString());
            if (promotionViewListener != null) {
                promotionViewListener.onPromotionView(resultAPI, Promotion.PromotionViewResultType.CLOSED);
            }
        } else {
            LoggerImpl.INSTANCE.d("[Promotion::showPromotion] response success");
            if (mShowingPromotion.get()) {
                ResultAPI resultAPI2 = new ResultAPI(-3, ResultAPI.Code.PromotionAlreadyShowing, "Duplicated Call of : " + str);
                if (promotionViewListener != null) {
                    promotionViewListener.onPromotionView(resultAPI2, Promotion.PromotionViewResultType.CLOSED);
                }
                return Unit.INSTANCE;
            }
            if (webViewInfoList.isEmpty()) {
                LoggerImpl.INSTANCE.d("[Promotion::showPromotion] WebViewInfo is null or empty.");
                if (promotionViewListener != null) {
                    promotionViewListener.onPromotionView(new ResultAPI(), Promotion.PromotionViewResultType.CLOSED);
                }
                return Unit.INSTANCE;
            }
            mShowingPromotion.set(true);
            Intent intentPutExtra = new Intent().putExtra(HiveUiActivity.HIVE_UI_ACTIVITY_CHILD_STYLE, "Promotion");
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
            HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), intentPutExtra, new PromotionImpl$internalShowPromotion$11$1(webViewInfoList, z, init, str, promotionWebviewType, promotionViewListener));
        }
        return Unit.INSTANCE;
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public void showCustomContents(final Promotion.PromotionCustomType promotionCustomType, final String contentKey, final boolean isHiveUiActivity, final Promotion.PromotionViewListener listener) {
        Promotion.PromotionWebviewType promotionWebviewType;
        Intrinsics.checkNotNullParameter(promotionCustomType, "promotionCustomType");
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (!HiveLifecycle.INSTANCE.isSdkSetup()) {
            if (listener != null) {
                listener.onPromotionView(new ResultAPI(-7, ResultAPI.Code.PromotionNotInitialized, ""), Promotion.PromotionViewResultType.CLOSED);
                return;
            }
            return;
        }
        String str = contentKey;
        if (str == null || StringsKt.isBlank(str)) {
            LoggerImpl.INSTANCE.w("[Promotion::showCustomContents] request failed : content_key is empty");
            return;
        }
        if (mShowingPromotion.get()) {
            LoggerImpl.INSTANCE.w("[Promotion::showCustomContents] already in progress");
            ResultAPI resultAPI = new ResultAPI(-3, ResultAPI.Code.PromotionAlreadyShowing, "[Promotion::showCustomContents] already in progress");
            if (listener != null) {
                listener.onPromotionView(resultAPI, Promotion.PromotionViewResultType.CLOSED);
                return;
            }
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$1[promotionCustomType.ordinal()];
        if (i == 1) {
            promotionWebviewType = Promotion.PromotionWebviewType.CUSTOM_BOARD;
            PromotionBadgeManager.INSTANCE.memorizeContentsRequest(Promotion.PromotionBadgeTarget.CUSTOMBOARD, contentKey);
        } else if (i == 2) {
            promotionWebviewType = Promotion.PromotionWebviewType.DIRECT;
        } else if (i == 3) {
            promotionWebviewType = Promotion.PromotionWebviewType.SPOT;
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            promotionWebviewType = Promotion.PromotionWebviewType.CUSTOM_VIEW;
            PromotionBadgeManager.INSTANCE.memorizeContentsRequest(Promotion.PromotionBadgeTarget.CUSTOMVIEW, contentKey);
        }
        PromotionNetwork.init$default(PromotionNetwork.INSTANCE, contentKey, promotionWebviewType, true, false, null, new Function3() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return PromotionImpl.showCustomContents$lambda$26(callMethodName, listener, isHiveUiActivity, promotionCustomType, contentKey, (Init) obj, ((Integer) obj2).intValue(), (ArrayList) obj3);
            }
        }, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.hive.promotion.PromotionImpl$showCustomContents$1$promotionDialogListener$1] */
    public static final Unit showCustomContents$lambda$26(final String str, final Promotion.PromotionViewListener promotionViewListener, boolean z, Promotion.PromotionCustomType promotionCustomType, String str2, final Init init, int i, final ArrayList webViewInfoList) {
        Intrinsics.checkNotNullParameter(init, "init");
        Intrinsics.checkNotNullParameter(webViewInfoList, "webViewInfoList");
        if (init.getResponse().getResult().isFailure()) {
            LoggerImpl.INSTANCE.w("[Promotion::showCustomContents] request failed");
            LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, init.getResponse().getResult().toString());
            if (promotionViewListener != null) {
                promotionViewListener.onPromotionView(new ResultAPI(-5, ResultAPI.Code.PromotionNetworkError), Promotion.PromotionViewResultType.CLOSED);
            }
            return Unit.INSTANCE;
        }
        if (init.getResponse().isFailure()) {
            LoggerImpl.INSTANCE.w("[Promotion::showCustomContents] response failed");
            ResultAPI resultAPI = new ResultAPI(-8, ResultAPI.Code.PromotionServerResponseError, init.getResponse().getResultMessage());
            LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, resultAPI.toString());
            if (promotionViewListener != null) {
                promotionViewListener.onPromotionView(resultAPI, Promotion.PromotionViewResultType.CLOSED);
            }
            return Unit.INSTANCE;
        }
        if (webViewInfoList.isEmpty()) {
            LoggerImpl.INSTANCE.i("[Promotion::showCustomContents] response success. WebViewInfo is null or empty.");
            if (promotionViewListener != null) {
                promotionViewListener.onPromotionView(new ResultAPI(), Promotion.PromotionViewResultType.CLOSED);
            }
            return Unit.INSTANCE;
        }
        if (mShowingPromotion.get()) {
            LoggerImpl.INSTANCE.w("[Promotion::showCustomContents] Already showing");
            ResultAPI resultAPI2 = new ResultAPI(-3, ResultAPI.Code.PromotionAlreadyShowing, "API Call Duplicated : " + str);
            if (promotionViewListener != null) {
                promotionViewListener.onPromotionView(resultAPI2, Promotion.PromotionViewResultType.CLOSED);
            }
            return Unit.INSTANCE;
        }
        LoggerImpl.INSTANCE.i("[Promotion::showCustomContents] success");
        mShowingPromotion.set(true);
        boolean z2 = z || promotionCustomType != Promotion.PromotionCustomType.DIRECT;
        if (z2) {
            Intent intent = new Intent();
            PromotionNetwork.ViewAppearance appearance = ((PromotionNetwork.WebViewInfo) webViewInfoList.get(0)).getAppearance();
            String type = appearance != null ? appearance.getType() : null;
            if (Intrinsics.areEqual(type, "fullscreen") || Intrinsics.areEqual(type, "classic")) {
                intent.putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, true);
            }
            intent.putExtra(HiveUiActivity.HIVE_UI_ACTIVITY_CHILD_STYLE, "Promotion");
            HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), intent, new PromotionImpl$showCustomContents$1$1(webViewInfoList, init, str, promotionViewListener, promotionCustomType, str2));
        } else {
            if (z2) {
                throw new NoWhenBranchMatchedException();
            }
            final ?? r0 = new PromotionDialog.PromotionDialogListener() { // from class: com.hive.promotion.PromotionImpl$showCustomContents$1$promotionDialogListener$1
                @Override // com.hive.promotion.PromotionDialog.PromotionDialogListener
                public void needDialogClosed(ResultAPI result, String scheme) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Intrinsics.checkNotNullParameter(scheme, "scheme");
                    PromotionDialog promotionDialog = PromotionImpl.mPromotionDialog;
                    if (promotionDialog != null) {
                        String str3 = str;
                        Promotion.PromotionViewListener promotionViewListener2 = promotionViewListener;
                        promotionDialog.dismissMercury();
                        PromotionImpl.INSTANCE.setMPromotionDialogListener(null);
                        PromotionImpl.mShowingPromotion.set(false);
                        LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str3, result.toString());
                        if (promotionViewListener2 != null) {
                            promotionViewListener2.onPromotionView(result, Promotion.PromotionViewResultType.GOBACK);
                        }
                    }
                    PromotionImpl promotionImpl = PromotionImpl.INSTANCE;
                    PromotionImpl.mPromotionDialog = null;
                }

                @Override // com.hive.promotion.PromotionDialog.PromotionDialogListener
                public void needDialogClosed(ResultAPI result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    PromotionDialog promotionDialog = PromotionImpl.mPromotionDialog;
                    if (promotionDialog != null) {
                        String str3 = str;
                        Promotion.PromotionViewListener promotionViewListener2 = promotionViewListener;
                        promotionDialog.dismissMercury();
                        PromotionImpl.INSTANCE.setMPromotionDialogListener(null);
                        PromotionImpl.mShowingPromotion.set(false);
                        LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str3, result.toString());
                        if (promotionViewListener2 != null) {
                            promotionViewListener2.onPromotionView(result, Promotion.PromotionViewResultType.CLOSED);
                        }
                    }
                    PromotionImpl promotionImpl = PromotionImpl.INSTANCE;
                    PromotionImpl.mPromotionDialog = null;
                }

                @Override // com.hive.promotion.PromotionDialog.PromotionDialogListener
                public void onDialogShow() {
                    ResultAPI resultAPI3 = new ResultAPI();
                    LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, resultAPI3.toString());
                    Promotion.PromotionViewListener promotionViewListener2 = promotionViewListener;
                    if (promotionViewListener2 != null) {
                        promotionViewListener2.onPromotionView(resultAPI3, Promotion.PromotionViewResultType.OPENED);
                    }
                }

                @Override // com.hive.promotion.PromotionDialog.PromotionDialogListener
                public void onPlaybackStart(ResultAPI result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Promotion.PromotionViewListener promotionViewListener2 = promotionViewListener;
                    if (promotionViewListener2 != null) {
                        promotionViewListener2.onPromotionView(result, Promotion.PromotionViewResultType.START_PLAYBACK);
                    }
                }

                @Override // com.hive.promotion.PromotionDialog.PromotionDialogListener
                public void onPlaybackFinish(ResultAPI result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Promotion.PromotionViewListener promotionViewListener2 = promotionViewListener;
                    if (promotionViewListener2 != null) {
                        promotionViewListener2.onPromotionView(result, Promotion.PromotionViewResultType.FINISH_PLAYBACK);
                    }
                }
            };
            mPromotionDialogListener = (PromotionDialog.PromotionDialogListener) r0;
            Android.INSTANCE.runOnMainThread(new Runnable() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda25
                @Override // java.lang.Runnable
                public final void run() {
                    PromotionImpl.showCustomContents$lambda$26$lambda$25(webViewInfoList, r0, init);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCustomContents$lambda$26$lambda$25(ArrayList arrayList, PromotionImpl$showCustomContents$1$promotionDialogListener$1 promotionImpl$showCustomContents$1$promotionDialogListener$1, Init init) {
        HiveActivity.INSTANCE.getRecentActivity().getTheme().applyStyle(Resource.INSTANCE.getHiveStyleId(HiveActivity.INSTANCE.getRecentActivity(), "Promotion"), true);
        PromotionDialog promotionDialog = new PromotionDialog.Builder(HiveActivity.INSTANCE.getRecentActivity(), INSTANCE.convertWebViewInfoList(arrayList), promotionImpl$showCustomContents$1$promotionDialogListener$1).setForced(true).setSchemeEventFunc(new Function1() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(PromotionImpl.showCustomContents$lambda$26$lambda$25$lambda$22((Scheme) obj));
            }
        }).setGeneratePostDataFunc(new Function2() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PromotionImpl.showCustomContents$lambda$26$lambda$25$lambda$23((PromotionView.WebViewInfo) obj, (String) obj2);
            }
        }).setPromotionWebChromeClient(new PromotionWebChromeClient()).setBannerDontShowAgainPeriod(init.getResponse().getDontShowAgainPeriod()).getPromotionDialog();
        mPromotionDialog = promotionDialog;
        promotionDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showCustomContents$lambda$26$lambda$25$lambda$22(Scheme scheme) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        return INSTANCE.processPromotionScheme(scheme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String showCustomContents$lambda$26$lambda$25$lambda$23(PromotionView.WebViewInfo webViewInfo, String s) {
        Intrinsics.checkNotNullParameter(webViewInfo, "webViewInfo");
        Intrinsics.checkNotNullParameter(s, "s");
        return INSTANCE.generatePromotionViewPostData(webViewInfo, s);
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public void showOfferwall(final Promotion.PromotionViewListener listener) {
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (HiveLifecycle.INSTANCE.isSdkSetup()) {
            PromotionNetwork.init$default(PromotionNetwork.INSTANCE, null, Promotion.PromotionWebviewType.OFFERWALL, true, false, null, new Function3() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PromotionImpl.showOfferwall$lambda$28(callMethodName, listener, (Init) obj, ((Integer) obj2).intValue(), (ArrayList) obj3);
                }
            }, 24, null);
        } else if (listener != null) {
            listener.onPromotionView(new ResultAPI(-7, ResultAPI.Code.PromotionNotInitialized, ""), Promotion.PromotionViewResultType.CLOSED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showOfferwall$lambda$28(String str, Promotion.PromotionViewListener promotionViewListener, Init init, int i, ArrayList webViewInfoList) {
        Intrinsics.checkNotNullParameter(init, "init");
        Intrinsics.checkNotNullParameter(webViewInfoList, "webViewInfoList");
        if (init.getResponse().getResult().isFailure()) {
            LoggerImpl.INSTANCE.w("[Promotion::showOfferwall] request failed");
            LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, init.getResponse().getResult().toString());
            if (promotionViewListener != null) {
                promotionViewListener.onPromotionView(new ResultAPI(-5, ResultAPI.Code.PromotionNetworkError), Promotion.PromotionViewResultType.CLOSED);
            }
        } else {
            if (init.getResponse().isFailure()) {
                LoggerImpl.INSTANCE.w("[Promotion::showOfferwall] response failed");
                ResultAPI resultAPI = new ResultAPI(-8, ResultAPI.Code.PromotionServerResponseError, init.getResponse().getResultMessage());
                LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, resultAPI.toString());
                if (promotionViewListener != null) {
                    promotionViewListener.onPromotionView(resultAPI, Promotion.PromotionViewResultType.CLOSED);
                }
                return Unit.INSTANCE;
            }
            LoggerImpl.INSTANCE.i("[Promotion::showOfferwall] success");
            if (mShowingOfferwall) {
                ResultAPI resultAPI2 = new ResultAPI(-3, ResultAPI.Code.PromotionAlreadyShowing, "Duplicated Call of : " + str);
                if (promotionViewListener != null) {
                    promotionViewListener.onPromotionView(resultAPI2, Promotion.PromotionViewResultType.CLOSED);
                }
                return Unit.INSTANCE;
            }
            mShowingOfferwall = true;
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), PromotionKeys.OFFERWALL_STATE, String.valueOf(((PromotionNetwork.WebViewInfo) webViewInfoList.get(0)).getState()), null, 4, null);
            Property.INSTANCE.getINSTANCE().writeProperties();
            Intent intent = new Intent();
            intent.putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, true);
            intent.putExtra(HiveUiActivity.HIVE_UI_ACTIVITY_CHILD_STYLE, "Promotion");
            HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), intent, new PromotionImpl$showOfferwall$1$1(webViewInfoList, str, promotionViewListener));
        }
        return Unit.INSTANCE;
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public void showReview(final Promotion.PromotionViewListener listener) {
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (HiveLifecycle.INSTANCE.isSdkSetup()) {
            PromotionNetwork.INSTANCE.review(new Function1() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PromotionImpl.showReview$lambda$29(callMethodName, listener, (Review) obj);
                }
            });
        } else if (listener != null) {
            listener.onPromotionView(new ResultAPI(-7, ResultAPI.Code.PromotionNotInitialized, ""), Promotion.PromotionViewResultType.CLOSED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showReview$lambda$29(String str, Promotion.PromotionViewListener promotionViewListener, Review review) {
        Intrinsics.checkNotNullParameter(review, "review");
        if (review.getResponse().getResult().isFailure()) {
            LoggerImpl.INSTANCE.w("[Promotion::showReview] request failed");
            LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, review.getResponse().getResult().toString());
            if (promotionViewListener != null) {
                promotionViewListener.onPromotionView(new ResultAPI(-5, ResultAPI.Code.PromotionNetworkError), Promotion.PromotionViewResultType.CLOSED);
            }
        } else {
            LoggerImpl.INSTANCE.i("[Promotion::showReview] request success");
            INSTANCE.internalShowReview(review, promotionViewListener);
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ void internalShowReview$default(PromotionImpl promotionImpl, Review review, Promotion.PromotionViewListener promotionViewListener, int i, Object obj) {
        if ((i & 2) != 0) {
            promotionViewListener = null;
        }
        promotionImpl.internalShowReview(review, promotionViewListener);
    }

    private final void internalShowReview(Review review, Promotion.PromotionViewListener listener) {
        LoggerImpl.INSTANCE.i("[Promotion] Call internalShowReview");
        String callMethodName = LoggerImpl.getCallMethodName(2);
        if (review.getResponse().getState() != 1) {
            LoggerImpl.INSTANCE.w("[Promotion::showReview] response state is not 1(true)");
            ResultAPI resultAPI = new ResultAPI(ResultAPI.Code.Success, "CLOSE");
            LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), callMethodName, resultAPI.toString());
            if (listener != null) {
                listener.onPromotionView(resultAPI, Promotion.PromotionViewResultType.CLOSED);
                return;
            }
            return;
        }
        if (review.getResponse().getUseCustomReview() == 0) {
            showHiveLegacyReview(review, listener);
        } else {
            showHiveCustomReview(review, listener);
        }
    }

    static /* synthetic */ void showHiveLegacyReview$default(PromotionImpl promotionImpl, Review review, Promotion.PromotionViewListener promotionViewListener, int i, Object obj) {
        if ((i & 2) != 0) {
            promotionViewListener = null;
        }
        promotionImpl.showHiveLegacyReview(review, promotionViewListener);
    }

    private final void showHiveLegacyReview(final Review review, final Promotion.PromotionViewListener listener) {
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (StringsKt.isBlank(review.getResponse().getUrl()) || StringsKt.isBlank(review.getResponse().getLabelTitle()) || StringsKt.isBlank(review.getResponse().getLabelMsg())) {
            LoggerImpl.INSTANCE.w("[Promotion::showReview] response data error");
            ResultAPI resultAPI = new ResultAPI(-8, ResultAPI.Code.PromotionInvalidResponseData, review.toString());
            LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), callMethodName, resultAPI.toString());
            if (listener != null) {
                listener.onPromotionView(resultAPI, Promotion.PromotionViewResultType.CLOSED);
                return;
            }
            return;
        }
        if (mShowingReview) {
            ResultAPI resultAPI2 = new ResultAPI(-3, ResultAPI.Code.PromotionAlreadyShowing, "Duplicated Call of : " + callMethodName);
            if (listener != null) {
                listener.onPromotionView(resultAPI2, Promotion.PromotionViewResultType.CLOSED);
                return;
            }
            return;
        }
        mShowingReview = true;
        Intent intentPutExtra = new Intent().putExtra(HiveUiActivity.HIVE_UI_ACTIVITY_CHILD_STYLE, "Promotion");
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
        HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), intentPutExtra, new OnActivityLifecycle() { // from class: com.hive.promotion.PromotionImpl.showHiveLegacyReview.1
            public PromotionReviewDialog promotionReviewDialog;

            public final PromotionReviewDialog getPromotionReviewDialog() {
                PromotionReviewDialog promotionReviewDialog = this.promotionReviewDialog;
                if (promotionReviewDialog != null) {
                    return promotionReviewDialog;
                }
                Intrinsics.throwUninitializedPropertyAccessException("promotionReviewDialog");
                return null;
            }

            public final void setPromotionReviewDialog(PromotionReviewDialog promotionReviewDialog) {
                Intrinsics.checkNotNullParameter(promotionReviewDialog, "<set-?>");
                this.promotionReviewDialog = promotionReviewDialog;
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onCreate(final Activity activity, Bundle savedInstanceState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                super.onCreate(activity, savedInstanceState);
                com.hive.promotion.ui.model.Review review2 = new com.hive.promotion.ui.model.Review(review.getResponse().getLabelTitle(), review.getResponse().getLabelMsg(), review.getResponse().getLabelOk(), review.getResponse().getLabelNo(), review.getResponse().getLabelNext(), review.getResponse().getUrl());
                final Review review3 = review;
                final String str = callMethodName;
                final Promotion.PromotionViewListener promotionViewListener = listener;
                setPromotionReviewDialog(new PromotionReviewDialog(activity, review2, new PromotionReviewDialog.PromotionReviewDialogListener() { // from class: com.hive.promotion.PromotionImpl$showHiveLegacyReview$1$onCreate$1
                    @Override // com.hive.promotion.ui.PromotionReviewDialog.PromotionReviewDialogListener
                    public void onReview() {
                        PromotionImpl promotionImpl = PromotionImpl.INSTANCE;
                        PromotionImpl.mShowingReview = false;
                        PromotionImpl.INSTANCE.logReview(review3.getResponse().getKeyOk());
                        ResultAPI resultAPI3 = new ResultAPI(ResultAPI.Code.Success, "OK");
                        LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, resultAPI3.toString());
                        Promotion.PromotionViewListener promotionViewListener2 = promotionViewListener;
                        if (promotionViewListener2 != null) {
                            promotionViewListener2.onPromotionView(resultAPI3, Promotion.PromotionViewResultType.CLOSED);
                        }
                        activity.finish();
                    }

                    @Override // com.hive.promotion.ui.PromotionReviewDialog.PromotionReviewDialogListener
                    public void onNext() {
                        PromotionImpl promotionImpl = PromotionImpl.INSTANCE;
                        PromotionImpl.mShowingReview = false;
                        PromotionImpl.INSTANCE.logReview(review3.getResponse().getKeyNext());
                        ResultAPI resultAPI3 = new ResultAPI(ResultAPI.Code.Success, "NEXT");
                        LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, resultAPI3.toString());
                        Promotion.PromotionViewListener promotionViewListener2 = promotionViewListener;
                        if (promotionViewListener2 != null) {
                            promotionViewListener2.onPromotionView(resultAPI3, Promotion.PromotionViewResultType.CLOSED);
                        }
                        activity.finish();
                    }

                    @Override // com.hive.promotion.ui.PromotionReviewDialog.PromotionReviewDialogListener
                    public void onCancel() {
                        PromotionImpl promotionImpl = PromotionImpl.INSTANCE;
                        PromotionImpl.mShowingReview = false;
                        PromotionImpl.INSTANCE.logReview(review3.getResponse().getKeyNo());
                        ResultAPI resultAPI3 = new ResultAPI(ResultAPI.Code.Success, "NO");
                        LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, resultAPI3.toString());
                        Promotion.PromotionViewListener promotionViewListener2 = promotionViewListener;
                        if (promotionViewListener2 != null) {
                            promotionViewListener2.onPromotionView(resultAPI3, Promotion.PromotionViewResultType.CLOSED);
                        }
                        activity.finish();
                    }

                    @Override // com.hive.promotion.ui.PromotionReviewDialog.PromotionReviewDialogListener
                    public void onDialogShow() {
                        ResultAPI resultAPI3 = new ResultAPI();
                        LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, resultAPI3.toString());
                        Promotion.PromotionViewListener promotionViewListener2 = promotionViewListener;
                        if (promotionViewListener2 != null) {
                            promotionViewListener2.onPromotionView(resultAPI3, Promotion.PromotionViewResultType.OPENED);
                        }
                    }
                }));
                getPromotionReviewDialog().show();
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onConfigurationChanged(Activity activity, Configuration newConfig) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                Intrinsics.checkNotNullParameter(newConfig, "newConfig");
                getPromotionReviewDialog().onConfigurationChanged(activity, newConfig);
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onDestroy(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (!getIsCalledFinish()) {
                    getPromotionReviewDialog().cancel();
                }
                super.onDestroy(activity);
            }
        });
    }

    static /* synthetic */ void showHiveCustomReview$default(PromotionImpl promotionImpl, Review review, Promotion.PromotionViewListener promotionViewListener, int i, Object obj) {
        if ((i & 2) != 0) {
            promotionViewListener = null;
        }
        promotionImpl.showHiveCustomReview(review, promotionViewListener);
    }

    private final void showHiveCustomReview(final Review review, final Promotion.PromotionViewListener listener) {
        final Review.ReviewResponse.CustomReview customReview = review.getResponse().getCustomReview();
        if ((customReview != null ? customReview.getReviewButtonUrl() : null) == null) {
            LoggerImpl.INSTANCE.w("[Promotion::showReview] showHiveCustomReview response data error");
            ResultAPI resultAPI = new ResultAPI(-8, ResultAPI.Code.PromotionInvalidResponseData, review.toString());
            if (listener != null) {
                listener.onPromotionView(resultAPI, Promotion.PromotionViewResultType.CLOSED);
                return;
            }
            return;
        }
        if (mShowingReview) {
            ResultAPI resultAPI2 = new ResultAPI(-3, ResultAPI.Code.PromotionAlreadyShowing, "Duplicated Call of : " + LoggerImpl.getCallMethodName(2));
            if (listener != null) {
                listener.onPromotionView(resultAPI2, Promotion.PromotionViewResultType.CLOSED);
                return;
            }
            return;
        }
        mShowingReview = true;
        new PromotionCustomReview(HiveActivity.INSTANCE.getRecentActivity(), new CustomReview(customReview.getTitle(), customReview.getMsg(), customReview.getPortImage(), customReview.getLandImage(), customReview.getImageAlignmentRight() == 1, customReview.getCustomButtonMsg(), customReview.getCustomButtonUrl(), customReview.getReviewButtonMsg(), customReview.getReviewButtonUrl())).show(new PromotionCustomReviewListener() { // from class: com.hive.promotion.PromotionImpl$showHiveCustomReview$1$1
            @Override // com.hive.promotion.ui.customreview.PromotionCustomReviewListener
            public void onDialogShow() {
                Logger.INSTANCE.i("[Promotion] onDialogShow()");
                ResultAPI resultAPI3 = new ResultAPI();
                Promotion.PromotionViewListener promotionViewListener = listener;
                if (promotionViewListener != null) {
                    promotionViewListener.onPromotionView(resultAPI3, Promotion.PromotionViewResultType.OPENED);
                }
            }

            @Override // com.hive.promotion.ui.customreview.PromotionCustomReviewListener
            public void onNext() {
                Logger.INSTANCE.i("[Promotion] onNext()");
                PromotionImpl promotionImpl = PromotionImpl.INSTANCE;
                PromotionImpl.mShowingReview = false;
                PromotionImpl.INSTANCE.logReview(review.getResponse().getKeyNext());
                ResultAPI resultAPI3 = new ResultAPI(ResultAPI.Code.Success, "NEXT");
                Promotion.PromotionViewListener promotionViewListener = listener;
                if (promotionViewListener != null) {
                    promotionViewListener.onPromotionView(resultAPI3, Promotion.PromotionViewResultType.CLOSED);
                }
            }

            @Override // com.hive.promotion.ui.customreview.PromotionCustomReviewListener
            public void onReview() {
                Logger.INSTANCE.i("[Promotion] onReview()");
                PromotionImpl promotionImpl = PromotionImpl.INSTANCE;
                PromotionImpl.mShowingReview = false;
                PromotionImpl.INSTANCE.logReview(review.getResponse().getKeyOk());
                ResultAPI resultAPI3 = new ResultAPI(ResultAPI.Code.Success, "OK");
                Promotion.PromotionViewListener promotionViewListener = listener;
                if (promotionViewListener != null) {
                    promotionViewListener.onPromotionView(resultAPI3, Promotion.PromotionViewResultType.CLOSED);
                }
            }

            @Override // com.hive.promotion.ui.customreview.PromotionCustomReviewListener
            public void onCancel() {
                Logger.INSTANCE.i("[Promotion] onCancel()");
                PromotionImpl promotionImpl = PromotionImpl.INSTANCE;
                PromotionImpl.mShowingReview = false;
                PromotionImpl.INSTANCE.logReview(review.getResponse().getKeyNo());
                ResultAPI resultAPI3 = new ResultAPI(ResultAPI.Code.Success, "NO");
                Promotion.PromotionViewListener promotionViewListener = listener;
                if (promotionViewListener != null) {
                    promotionViewListener.onPromotionView(resultAPI3, Promotion.PromotionViewResultType.CLOSED);
                }
            }

            @Override // com.hive.promotion.ui.customreview.PromotionCustomReviewListener
            public void onCustom() {
                Object objM7415constructorimpl;
                Logger.INSTANCE.i("[Promotion] onCustom()");
                PromotionImpl promotionImpl = PromotionImpl.INSTANCE;
                PromotionImpl.mShowingReview = false;
                PromotionImpl.INSTANCE.logReview(customReview.getCustomButtonType());
                if (!StringsKt.isBlank(customReview.getCustomButtonUrl())) {
                    Review.ReviewResponse.CustomReview customReview2 = customReview;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        if (!PromotionImpl.INSTANCE.processPromotionScheme(new Scheme(customReview2.getCustomButtonUrl()))) {
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(Uri.parse(customReview2.getCustomButtonUrl()));
                            ExtentionsKt.startActivityCatching$default(HiveActivity.INSTANCE.getRecentActivity(), intent, null, 2, null);
                        }
                        objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                    }
                    Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
                    if (thM7418exceptionOrNullimpl != null) {
                        thM7418exceptionOrNullimpl.printStackTrace();
                    }
                }
                ResultAPI resultAPI3 = new ResultAPI(ResultAPI.Code.Success, customReview.getCustomButtonType());
                Promotion.PromotionViewListener promotionViewListener = listener;
                if (promotionViewListener != null) {
                    promotionViewListener.onPromotionView(resultAPI3, Promotion.PromotionViewResultType.CLOSED);
                }
            }
        });
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public void showNativeReview() {
        LoggerImpl.INSTANCE.i("[Promotion] Call showNativeReview");
        if (!HiveLifecycle.INSTANCE.isSdkSetup()) {
            LoggerImpl.INSTANCE.d("[Promotion::showNativeReview] is not initialize");
        } else {
            PromotionNetwork.INSTANCE.review(new Function1() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PromotionImpl.showNativeReview$lambda$33((Review) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showNativeReview$lambda$33(Review review) {
        Intrinsics.checkNotNullParameter(review, "review");
        if (review.getResponse().isFailure()) {
            LoggerImpl.INSTANCE.w("[Promotion::showNativeReview] response is failed");
            return Unit.INSTANCE;
        }
        String market = review.getResponse().getMarket();
        boolean z = Intrinsics.areEqual(market, "google") || Intrinsics.areEqual(market, "google_vn");
        boolean zIsGooglePlayServicesAvailable$default = Android.isGooglePlayServicesAvailable$default(Android.INSTANCE, HiveActivity.INSTANCE.getRecentActivity(), false, 0, 4, null);
        if (z && zIsGooglePlayServicesAvailable$default) {
            HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
            String name = GoogleInAppReview.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
            if (!(hiveModule instanceof GoogleInAppReview)) {
                hiveModule = null;
            }
            GoogleInAppReview googleInAppReview = (GoogleInAppReview) (hiveModule instanceof GoogleInAppReview ? hiveModule : null);
            if (googleInAppReview != null) {
                googleInAppReview.launchReviewFlow(HiveActivity.INSTANCE.getRecentActivity());
                AnalyticsImpl.INSTANCE.sendStandardEvent(AnalyticsProviderAdapter.StandardEventType.REVIEW, MapsKt.mapOf(TuplesKt.to(HiveKeys.KEY_category.getValue(), "hive_native_review_request")));
            } else {
                LoggerImpl.INSTANCE.w("[Promotion::showNativeReview] ::Extension_Google_Base is not included.");
            }
        } else {
            internalShowReview$default(INSTANCE, review, null, 2, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logReview(String userSelected) {
        PromotionNetwork.INSTANCE.reviewClick(userSelected, new Function1() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PromotionImpl.logReview$lambda$34((ReviewClick) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit logReview$lambda$34(ReviewClick reviewClick) {
        Intrinsics.checkNotNullParameter(reviewClick, "reviewClick");
        if (reviewClick.getResponse().isFailure()) {
            LoggerImpl.INSTANCE.w("[Promotion::logReview] request failed");
        } else {
            LoggerImpl.INSTANCE.i("[Promotion::logReview] success");
        }
        return Unit.INSTANCE;
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public void showExit(final Promotion.PromotionViewListener listener) {
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        PromotionNetwork.INSTANCE.moreGames(new Function1() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PromotionImpl.showExit$lambda$35(callMethodName, listener, (MoreGames) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showExit$lambda$35(final String str, final Promotion.PromotionViewListener promotionViewListener, final MoreGames moreGames) {
        Intrinsics.checkNotNullParameter(moreGames, "moreGames");
        if (moreGames.getResponse().getResult().isFailure()) {
            LoggerImpl.INSTANCE.w("[Promotion::showExit] request failed");
            ResultAPI resultAPI = new ResultAPI(-5, ResultAPI.Code.PromotionNetworkError, moreGames.toString());
            LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, resultAPI.toString());
            if (promotionViewListener != null) {
                promotionViewListener.onPromotionView(resultAPI, Promotion.PromotionViewResultType.CLOSED);
            }
        } else {
            LoggerImpl.INSTANCE.i("[Promotion::showExit] success");
            if (mShowingExit) {
                ResultAPI resultAPI2 = new ResultAPI(-3, ResultAPI.Code.PromotionAlreadyShowing, "Duplicated Call of : " + str);
                if (promotionViewListener != null) {
                    promotionViewListener.onPromotionView(resultAPI2, Promotion.PromotionViewResultType.CLOSED);
                }
                return Unit.INSTANCE;
            }
            mShowingExit = true;
            Intent intentPutExtra = new Intent().putExtra(HiveUiActivity.HIVE_UI_ACTIVITY_CHILD_STYLE, "Promotion");
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
            HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), intentPutExtra, new OnActivityLifecycle() { // from class: com.hive.promotion.PromotionImpl$showExit$1$1
                public PromotionExitDialog promotionExitDialog;

                public final PromotionExitDialog getPromotionExitDialog() {
                    PromotionExitDialog promotionExitDialog = this.promotionExitDialog;
                    if (promotionExitDialog != null) {
                        return promotionExitDialog;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("promotionExitDialog");
                    return null;
                }

                public final void setPromotionExitDialog(PromotionExitDialog promotionExitDialog) {
                    Intrinsics.checkNotNullParameter(promotionExitDialog, "<set-?>");
                    this.promotionExitDialog = promotionExitDialog;
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onCreate(final Activity activity, Bundle savedInstanceState) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    super.onCreate(activity, savedInstanceState);
                    MoreGames.MoreGamesResponse response = moreGames.getResponse();
                    final MoreGames moreGames2 = moreGames;
                    final String str2 = str;
                    final Promotion.PromotionViewListener promotionViewListener2 = promotionViewListener;
                    setPromotionExitDialog(new PromotionExitDialog(activity, response, new PromotionExitDialog.PromotionExitDialogListener() { // from class: com.hive.promotion.PromotionImpl$showExit$1$1$onCreate$1
                        @Override // com.hive.promotion.PromotionExitDialog.PromotionExitDialogListener
                        public void onMoreGames() {
                            if (PromotionImpl.mShowingExit) {
                                PromotionImpl.INSTANCE.logExit(moreGames2.getResponse().getKeyMore());
                                ResultAPI resultAPI3 = new ResultAPI(ResultAPI.Code.Success, "MORE");
                                LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str2, resultAPI3.toString());
                                Promotion.PromotionViewListener promotionViewListener3 = promotionViewListener2;
                                if (promotionViewListener3 != null) {
                                    promotionViewListener3.onPromotionView(resultAPI3, Promotion.PromotionViewResultType.CLOSED);
                                }
                                PromotionImpl promotionImpl = PromotionImpl.INSTANCE;
                                PromotionImpl.mShowingExit = false;
                                activity.finish();
                            }
                        }

                        @Override // com.hive.promotion.PromotionExitDialog.PromotionExitDialogListener
                        public void onExit() {
                            if (PromotionImpl.mShowingExit) {
                                PromotionImpl.INSTANCE.logExit(moreGames2.getResponse().getKeyClose());
                                ResultAPI resultAPI3 = new ResultAPI(ResultAPI.Code.Success, "CLOSE");
                                LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str2, resultAPI3.toString());
                                Promotion.PromotionViewListener promotionViewListener3 = promotionViewListener2;
                                if (promotionViewListener3 != null) {
                                    promotionViewListener3.onPromotionView(resultAPI3, Promotion.PromotionViewResultType.CLOSED);
                                }
                                if (!com.hive.core.Configuration.INSTANCE.isExitEventEnabled()) {
                                    Android.INSTANCE.finish();
                                } else {
                                    HiveLifecycle.INSTANCE.onReset();
                                }
                                ResultAPI resultAPI4 = new ResultAPI(ResultAPI.Code.Success, "EXIT");
                                LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str2, resultAPI4.toString());
                                Promotion.PromotionViewListener promotionViewListener4 = promotionViewListener2;
                                if (promotionViewListener4 != null) {
                                    promotionViewListener4.onPromotionView(resultAPI4, Promotion.PromotionViewResultType.NEED_TO_EXIT);
                                }
                                PromotionImpl promotionImpl = PromotionImpl.INSTANCE;
                                PromotionImpl.mShowingExit = false;
                                activity.finish();
                            }
                        }

                        @Override // com.hive.promotion.PromotionExitDialog.PromotionExitDialogListener
                        public void onCancel() {
                            if (PromotionImpl.mShowingExit) {
                                PromotionImpl.INSTANCE.logExit(moreGames2.getResponse().getKeyCancel());
                                ResultAPI resultAPI3 = new ResultAPI(ResultAPI.Code.Success, "CANCEL");
                                LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str2, resultAPI3.toString());
                                Promotion.PromotionViewListener promotionViewListener3 = promotionViewListener2;
                                if (promotionViewListener3 != null) {
                                    promotionViewListener3.onPromotionView(resultAPI3, Promotion.PromotionViewResultType.CLOSED);
                                }
                                PromotionImpl promotionImpl = PromotionImpl.INSTANCE;
                                PromotionImpl.mShowingExit = false;
                                activity.finish();
                            }
                        }

                        @Override // com.hive.promotion.PromotionExitDialog.PromotionExitDialogListener
                        public void onDialogShow() {
                            ResultAPI resultAPI3 = new ResultAPI();
                            LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str2, resultAPI3.toString());
                            Promotion.PromotionViewListener promotionViewListener3 = promotionViewListener2;
                            if (promotionViewListener3 != null) {
                                promotionViewListener3.onPromotionView(resultAPI3, Promotion.PromotionViewResultType.OPENED);
                            }
                        }
                    }));
                    getPromotionExitDialog().show();
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onConfigurationChanged(Activity activity, Configuration newConfig) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    Intrinsics.checkNotNullParameter(newConfig, "newConfig");
                    getPromotionExitDialog().onConfigurationChanged(activity, newConfig);
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onDestroy(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    if (!getIsCalledFinish()) {
                        getPromotionExitDialog().cancel();
                    }
                    super.onDestroy(activity);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logExit(String userSelected) {
        PromotionNetwork.INSTANCE.moreGamesClick(userSelected, new Function1() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PromotionImpl.logExit$lambda$36((MoreGamesClick) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit logExit$lambda$36(MoreGamesClick moreGamesClick) {
        Intrinsics.checkNotNullParameter(moreGamesClick, "moreGamesClick");
        if (moreGamesClick.getResponse().isFailure()) {
            LoggerImpl.INSTANCE.w("[Promotion::logExit] request failed");
        } else {
            LoggerImpl.INSTANCE.i("[Promotion::logExit] success");
        }
        return Unit.INSTANCE;
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public void getViewInfo(Promotion.PromotionCustomType promotionCustomType, String contentKey, final Promotion.PromotionViewInfoListener listener) {
        Promotion.PromotionWebviewType promotionWebviewType;
        Intrinsics.checkNotNullParameter(promotionCustomType, "promotionCustomType");
        Intrinsics.checkNotNullParameter(contentKey, "contentKey");
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (!HiveLifecycle.INSTANCE.isSdkSetup()) {
            if (listener != null) {
                listener.onReceiveInfo(new ResultAPI(-7, ResultAPI.Code.PromotionNotInitialized, ""), null);
                return;
            }
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$1[promotionCustomType.ordinal()];
        if (i == 1) {
            promotionWebviewType = Promotion.PromotionWebviewType.CUSTOM_BOARD;
        } else if (i == 2) {
            promotionWebviewType = Promotion.PromotionWebviewType.DIRECT;
        } else if (i == 3) {
            promotionWebviewType = Promotion.PromotionWebviewType.SPOT;
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            promotionWebviewType = Promotion.PromotionWebviewType.CUSTOM_VIEW;
        }
        PromotionNetwork.init$default(PromotionNetwork.INSTANCE, contentKey, promotionWebviewType, true, false, null, new Function3() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return PromotionImpl.getViewInfo$lambda$40(callMethodName, listener, (Init) obj, ((Integer) obj2).intValue(), (ArrayList) obj3);
            }
        }, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getViewInfo$lambda$40(String str, final Promotion.PromotionViewInfoListener promotionViewInfoListener, Init init, int i, ArrayList webViewInfoList) {
        Intrinsics.checkNotNullParameter(init, "init");
        Intrinsics.checkNotNullParameter(webViewInfoList, "webViewInfoList");
        if (init.getResponse().getResult().isFailure()) {
            LoggerImpl.INSTANCE.w("[Promotion::getViewInfo] request failed");
            LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, init.getResponse().getResult().toString());
            if (promotionViewInfoListener != null) {
                promotionViewInfoListener.onReceiveInfo(new ResultAPI(-5, ResultAPI.Code.PromotionNetworkError), null);
            }
        } else {
            if (init.getResponse().isFailure()) {
                LoggerImpl.INSTANCE.w("[Promotion::getViewInfo] response failed");
                ResultAPI resultAPI = new ResultAPI(-8, ResultAPI.Code.PromotionServerResponseError);
                LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, resultAPI.toString());
                if (promotionViewInfoListener != null) {
                    promotionViewInfoListener.onReceiveInfo(resultAPI, null);
                }
                return Unit.INSTANCE;
            }
            LoggerImpl.INSTANCE.i("[Promotion::getViewInfo] success");
            final ArrayList arrayList = new ArrayList();
            Iterator it = webViewInfoList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                PromotionNetwork.WebViewInfo webViewInfo = (PromotionNetwork.WebViewInfo) next;
                JSONObject jSONObject = new JSONObject();
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_content_key, webViewInfo.getContentKey());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_pid, Integer.valueOf(webViewInfo.getPid()));
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_type_webview, webViewInfo.getTypeWebView());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_forced, DebugKt.DEBUG_PROPERTY_VALUE_ON);
                JSONObject jSONObjectPutPromotionBasePostData$hive_promotion_release = PromotionNetwork.INSTANCE.putPromotionBasePostData$hive_promotion_release(new JSONObject());
                CommonIdentifierKt.put(jSONObjectPutPromotionBasePostData$hive_promotion_release, HiveKeys.KEY_promotion, jSONObject);
                String url = webViewInfo.getUrl();
                String string = jSONObjectPutPromotionBasePostData$hive_promotion_release.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                arrayList.add(new Promotion.PromotionViewInfo(url, string));
            }
            final ResultAPI resultAPI2 = new ResultAPI(ResultAPI.Code.Success, init.getResponse().getResultMessage());
            LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, resultAPI2.toString());
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    PromotionImpl.getViewInfo$lambda$40$lambda$39(promotionViewInfoListener, resultAPI2, arrayList);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getViewInfo$lambda$40$lambda$39(Promotion.PromotionViewInfoListener promotionViewInfoListener, ResultAPI resultAPI, ArrayList arrayList) {
        if (promotionViewInfoListener != null) {
            promotionViewInfoListener.onReceiveInfo(resultAPI, arrayList);
        }
    }

    public final void getViewInfoWithViewTypeForMercury(final int mercuryViewID, Promotion.PromotionViewType promotionViewType, final boolean isForced, final Promotion.PromotionViewInfoWithJSONListener listener) {
        Promotion.PromotionWebviewType promotionWebviewType;
        Intrinsics.checkNotNullParameter(promotionViewType, "promotionViewType");
        if (!HiveLifecycle.INSTANCE.isSdkSetup()) {
            if (listener != null) {
                listener.onReceiveInfo(new ResultAPI(-7, ResultAPI.Code.PromotionNotInitialized, ""), null);
                return;
            }
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[promotionViewType.ordinal()];
        if (i == 1) {
            promotionWebviewType = Promotion.PromotionWebviewType.BANNER_DETAIL;
        } else if (i == 2) {
            promotionWebviewType = Promotion.PromotionWebviewType.NEWS;
        } else if (i == 3) {
            promotionWebviewType = Promotion.PromotionWebviewType.NOTICE;
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            promotionWebviewType = Promotion.PromotionWebviewType.BANNER;
        }
        PromotionNetwork.init$default(PromotionNetwork.INSTANCE, null, promotionWebviewType, isForced, false, null, new Function3() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return PromotionImpl.getViewInfoWithViewTypeForMercury$lambda$42(listener, isForced, mercuryViewID, (Init) obj, ((Integer) obj2).intValue(), (ArrayList) obj3);
            }
        }, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getViewInfoWithViewTypeForMercury$lambda$42(final Promotion.PromotionViewInfoWithJSONListener promotionViewInfoWithJSONListener, boolean z, int i, Init init, int i2, ArrayList webViewInfoList) {
        Intrinsics.checkNotNullParameter(init, "init");
        Intrinsics.checkNotNullParameter(webViewInfoList, "webViewInfoList");
        if (init.getResponse().getResult().isFailure()) {
            LoggerImpl.INSTANCE.i("[Promotion::getViewInfoWithViewTypeForMercuryModule] request failed");
            if (promotionViewInfoWithJSONListener != null) {
                promotionViewInfoWithJSONListener.onReceiveInfo(new ResultAPI(-5, ResultAPI.Code.PromotionNetworkError), null);
            }
        } else {
            if (init.getResponse().isFailure()) {
                LoggerImpl.INSTANCE.i("[Promotion::getViewInfoWithViewTypeForMercuryModule] response failed");
                ResultAPI resultAPI = new ResultAPI(-8, ResultAPI.Code.PromotionServerResponseError);
                if (promotionViewInfoWithJSONListener != null) {
                    promotionViewInfoWithJSONListener.onReceiveInfo(resultAPI, null);
                }
                return Unit.INSTANCE;
            }
            LoggerImpl.INSTANCE.i("[Promotion::getViewInfoWithViewTypeForMercuryModule] success");
            final JSONObject jSONObjectCombineViewInfoForMercury = INSTANCE.combineViewInfoForMercury(z, i, init, i2, webViewInfoList);
            final ResultAPI resultAPI2 = new ResultAPI(ResultAPI.Code.Success, init.getResponse().getResultMessage());
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda31
                @Override // java.lang.Runnable
                public final void run() {
                    PromotionImpl.getViewInfoWithViewTypeForMercury$lambda$42$lambda$41(promotionViewInfoWithJSONListener, resultAPI2, jSONObjectCombineViewInfoForMercury);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getViewInfoWithViewTypeForMercury$lambda$42$lambda$41(Promotion.PromotionViewInfoWithJSONListener promotionViewInfoWithJSONListener, ResultAPI resultAPI, JSONObject jSONObject) {
        if (promotionViewInfoWithJSONListener != null) {
            promotionViewInfoWithJSONListener.onReceiveInfo(resultAPI, jSONObject);
        }
    }

    public final void getViewInfoWithCustomTypeForMercury(final int mercuryViewID, Promotion.PromotionCustomType promotionCustomType, String content_key, final Promotion.PromotionViewInfoWithJSONListener listener) {
        Promotion.PromotionWebviewType promotionWebviewType;
        Intrinsics.checkNotNullParameter(promotionCustomType, "promotionCustomType");
        Intrinsics.checkNotNullParameter(content_key, "content_key");
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (!HiveLifecycle.INSTANCE.isSdkSetup()) {
            if (listener != null) {
                listener.onReceiveInfo(new ResultAPI(-7, ResultAPI.Code.PromotionNotInitialized, ""), null);
                return;
            }
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$1[promotionCustomType.ordinal()];
        if (i == 1) {
            promotionWebviewType = Promotion.PromotionWebviewType.CUSTOM_BOARD;
        } else if (i == 2) {
            promotionWebviewType = Promotion.PromotionWebviewType.DIRECT;
        } else if (i == 3) {
            promotionWebviewType = Promotion.PromotionWebviewType.SPOT;
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            promotionWebviewType = Promotion.PromotionWebviewType.CUSTOM_VIEW;
        }
        PromotionNetwork.init$default(PromotionNetwork.INSTANCE, content_key, promotionWebviewType, true, false, null, new Function3() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return PromotionImpl.getViewInfoWithCustomTypeForMercury$lambda$44(callMethodName, listener, mercuryViewID, (Init) obj, ((Integer) obj2).intValue(), (ArrayList) obj3);
            }
        }, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getViewInfoWithCustomTypeForMercury$lambda$44(String str, final Promotion.PromotionViewInfoWithJSONListener promotionViewInfoWithJSONListener, int i, Init init, int i2, ArrayList webViewInfoList) {
        Intrinsics.checkNotNullParameter(init, "init");
        Intrinsics.checkNotNullParameter(webViewInfoList, "webViewInfoList");
        if (init.getResponse().getResult().isFailure()) {
            LoggerImpl.INSTANCE.w("[Promotion::getViewInfoWithCustomTypeForMercuryModule] request failed");
            LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, init.getResponse().getResult().toString());
            if (promotionViewInfoWithJSONListener != null) {
                promotionViewInfoWithJSONListener.onReceiveInfo(new ResultAPI(-5, ResultAPI.Code.PromotionNetworkError), null);
            }
        } else {
            if (init.getResponse().isFailure()) {
                LoggerImpl.INSTANCE.w("[Promotion::getViewInfoWithCustomTypeForMercuryModule] response failed");
                ResultAPI resultAPI = new ResultAPI(-8, ResultAPI.Code.PromotionServerResponseError);
                LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, resultAPI.toString());
                if (promotionViewInfoWithJSONListener != null) {
                    promotionViewInfoWithJSONListener.onReceiveInfo(resultAPI, null);
                }
                return Unit.INSTANCE;
            }
            LoggerImpl.INSTANCE.i("[Promotion::getViewInfoWithCustomTypeForMercuryModule] success");
            final JSONObject jSONObjectCombineViewInfoForMercury = INSTANCE.combineViewInfoForMercury(true, i, init, i2, webViewInfoList);
            final ResultAPI resultAPI2 = new ResultAPI(ResultAPI.Code.Success, init.getResponse().getResultMessage());
            LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, resultAPI2.toString());
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda29
                @Override // java.lang.Runnable
                public final void run() {
                    PromotionImpl.getViewInfoWithCustomTypeForMercury$lambda$44$lambda$43(promotionViewInfoWithJSONListener, resultAPI2, jSONObjectCombineViewInfoForMercury);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getViewInfoWithCustomTypeForMercury$lambda$44$lambda$43(Promotion.PromotionViewInfoWithJSONListener promotionViewInfoWithJSONListener, ResultAPI resultAPI, JSONObject jSONObject) {
        if (promotionViewInfoWithJSONListener != null) {
            promotionViewInfoWithJSONListener.onReceiveInfo(resultAPI, jSONObject);
        }
    }

    private final JSONObject combineViewInfoForMercury(boolean isForced, int mercuryViewID, Init init, int count, ArrayList<PromotionNetwork.WebViewInfo> webViewInfoList) {
        LoggerImpl.INSTANCE.i("[Promotion::combineViewInfoForMercury]");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<PromotionNetwork.WebViewInfo> it = webViewInfoList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            PromotionNetwork.WebViewInfo next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            PromotionNetwork.WebViewInfo webViewInfo = next;
            try {
                jSONArray.put(webViewInfo.getOriginJson());
                if (!jSONObject2.has("url")) {
                    jSONObject2.put("url", webViewInfo.getUrl());
                }
                if (!jSONObject2.has("postString")) {
                    JSONObject jSONObject4 = new JSONObject();
                    CommonIdentifierKt.put(jSONObject4, HiveKeys.KEY_content_key, webViewInfo.getContentKey());
                    CommonIdentifierKt.put(jSONObject4, HiveKeys.KEY_pid, Integer.valueOf(webViewInfo.getPid()));
                    CommonIdentifierKt.put(jSONObject4, HiveKeys.KEY_type_webview, webViewInfo.getTypeWebView());
                    CommonIdentifierKt.put(jSONObject4, HiveKeys.KEY_forced, isForced ? DebugKt.DEBUG_PROPERTY_VALUE_ON : DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                    JSONObject jSONObjectPutPromotionBasePostData$hive_promotion_release = PromotionNetwork.INSTANCE.putPromotionBasePostData$hive_promotion_release(new JSONObject());
                    CommonIdentifierKt.put(jSONObjectPutPromotionBasePostData$hive_promotion_release, HiveKeys.KEY_promotion, jSONObject4);
                    jSONObject2.put("postString", jSONObjectPutPromotionBasePostData$hive_promotion_release.toString());
                }
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("[Promotion::combineViewInfoForMercury] viewInfoJson exception : " + e);
            }
        }
        try {
            jSONObject3.put("webview", jSONArray);
            jSONObject3.put("count", count);
            jSONObject3.put(FontsContractCompat.Columns.RESULT_CODE, init.getResponse().getResultCode());
            jSONObject3.put("result_message", init.getResponse().getResultMessage());
            jSONObject3.put("use_cutout", init.getResponse().getUseCutout());
            jSONObject2.put("origin", jSONObject3);
            jSONObject2.put("showtype", String.valueOf(mercuryViewID));
            jSONObject.put("customviewinfo", jSONObject2);
            LoggerImpl.INSTANCE.iL("[Promotion::combineViewInfoForMercury] resultJson : " + jSONObject);
            LoggerImpl.INSTANCE.iR("[Promotion::combineViewInfoForMercury] resultJson");
        } catch (Exception e2) {
            LoggerImpl.INSTANCE.w("[Promotion::combineViewInfoForMercury] resultJson exception : " + e2);
        }
        return jSONObject;
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public void getBadgeInfo(final Promotion.PromotionBadgeInfoListener listener) {
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (HiveLifecycle.INSTANCE.isSdkSetup()) {
            PromotionNetwork.INSTANCE.badge(new Function1() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PromotionImpl.getBadgeInfo$lambda$51(callMethodName, listener, (Badge) obj);
                }
            });
        } else if (listener != null) {
            listener.onReceiveInfo(new ResultAPI(-7, ResultAPI.Code.PromotionNotInitialized, ""), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0114 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.Unit getBadgeInfo$lambda$51(java.lang.String r8, final com.hive.Promotion.PromotionBadgeInfoListener r9, com.hive.protocol.promotionv2.Badge r10) {
        /*
            Method dump skipped, instruction units count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.promotion.PromotionImpl.getBadgeInfo$lambda$51(java.lang.String, com.hive.Promotion$PromotionBadgeInfoListener, com.hive.protocol.promotionv2.Badge):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getBadgeInfo$lambda$51$lambda$50(Promotion.PromotionBadgeInfoListener promotionBadgeInfoListener, ResultAPI resultAPI, ArrayList arrayList) {
        if (promotionBadgeInfoListener != null) {
            promotionBadgeInfoListener.onReceiveInfo(resultAPI, arrayList);
        }
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public void getBannerInfo(Promotion.PromotionCampaignType campaignType, Promotion.PromotionBannerType bannerType, Promotion.PromotionBannerInfoListener listener) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(bannerType, "bannerType");
        getBannerInfoString(campaignType.getValue(), bannerType.getValue(), listener);
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public void getBannerInfoString(String campaignType, String bannerType, final Promotion.PromotionBannerInfoListener listener) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(bannerType, "bannerType");
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (HiveLifecycle.INSTANCE.isSdkSetup()) {
            PromotionNetwork.INSTANCE.banner(campaignType, bannerType, new Function2() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PromotionImpl.getBannerInfoString$lambda$55(callMethodName, listener, (Banner) obj, (ArrayList) obj2);
                }
            });
        } else if (listener != null) {
            listener.onReceiveInfo(new ResultAPI(-7, ResultAPI.Code.PromotionNotInitialized, ""), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getBannerInfoString$lambda$55(String str, final Promotion.PromotionBannerInfoListener promotionBannerInfoListener, Banner banner, final ArrayList bannerArrayList) {
        final ResultAPI resultAPI;
        Intrinsics.checkNotNullParameter(banner, "banner");
        Intrinsics.checkNotNullParameter(bannerArrayList, "bannerArrayList");
        if (banner.getResponse().getResult().isFailure()) {
            resultAPI = new ResultAPI(-5, ResultAPI.Code.PromotionNetworkError);
            LoggerImpl.INSTANCE.w("[Promotion::banner] request failed : " + banner.getResponse().getResult());
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda17
                @Override // java.lang.Runnable
                public final void run() {
                    PromotionImpl.getBannerInfoString$lambda$55$lambda$52(promotionBannerInfoListener, resultAPI);
                }
            });
        } else if (banner.getResponse().isFailure()) {
            resultAPI = new ResultAPI(-8, ResultAPI.Code.PromotionServerResponseError);
            LoggerImpl.INSTANCE.wL("[Promotion::banner] response failed : " + banner.getResponse());
            LoggerImpl.INSTANCE.wR("[Promotion::banner] response failed");
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda18
                @Override // java.lang.Runnable
                public final void run() {
                    PromotionImpl.getBannerInfoString$lambda$55$lambda$53(promotionBannerInfoListener, resultAPI);
                }
            });
        } else {
            final ResultAPI resultAPI2 = new ResultAPI();
            LoggerImpl.INSTANCE.i("[Promotion::banner] success");
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    PromotionImpl.getBannerInfoString$lambda$55$lambda$54(promotionBannerInfoListener, resultAPI2, bannerArrayList);
                }
            });
            resultAPI = resultAPI2;
        }
        LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, resultAPI.toString());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getBannerInfoString$lambda$55$lambda$52(Promotion.PromotionBannerInfoListener promotionBannerInfoListener, ResultAPI resultAPI) {
        if (promotionBannerInfoListener != null) {
            promotionBannerInfoListener.onReceiveInfo(resultAPI, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getBannerInfoString$lambda$55$lambda$53(Promotion.PromotionBannerInfoListener promotionBannerInfoListener, ResultAPI resultAPI) {
        if (promotionBannerInfoListener != null) {
            promotionBannerInfoListener.onReceiveInfo(resultAPI, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getBannerInfoString$lambda$55$lambda$54(Promotion.PromotionBannerInfoListener promotionBannerInfoListener, ResultAPI resultAPI, ArrayList arrayList) {
        if (promotionBannerInfoListener != null) {
            promotionBannerInfoListener.onReceiveInfo(resultAPI, arrayList);
        }
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public void getAppInvitationData(Promotion.AppInvitationDataListener listener) {
        getAppInvitationData(null, listener);
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public void getAppInvitationData(String inviteUserInfo, final Promotion.AppInvitationDataListener listener) {
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (listener == null) {
            LoggerImpl.INSTANCE.w("[Promotion] getAppInvitationData listener is null");
        } else if (!HiveLifecycle.INSTANCE.isSdkSetup()) {
            listener.onAppInvitationData(new ResultAPI(-7, ResultAPI.Code.PromotionNotInitialized, ""), null);
        } else {
            PromotionNetwork.INSTANCE.uaUser(inviteUserInfo, new Function2() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PromotionImpl.getAppInvitationData$lambda$56(callMethodName, listener, (UaUser) obj, (Promotion.AppInvitationData) obj2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getAppInvitationData$lambda$56(String str, Promotion.AppInvitationDataListener appInvitationDataListener, UaUser uaUser, Promotion.AppInvitationData appInvitationData) {
        Intrinsics.checkNotNullParameter(uaUser, "uaUser");
        if (uaUser.getResponse().isFailure()) {
            LoggerImpl.INSTANCE.w("[Promotion::Promotion] request failed");
            ResultAPI resultAPI = new ResultAPI(-5, ResultAPI.Code.PromotionNetworkError, uaUser.getResponse().toString());
            LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, resultAPI.toString());
            appInvitationDataListener.onAppInvitationData(resultAPI, null);
        } else {
            LoggerImpl.INSTANCE.i("[Promotion::getAppInvitationData] acquisition network success");
            ResultAPI resultAPI2 = new ResultAPI(ResultAPI.Code.Success, uaUser.getResponse().getResultMessage());
            LoggerImpl.INSTANCE.dL("[Promotion::getAppInvitationData] result : " + resultAPI2 + ", AppInvitationData : " + appInvitationData);
            LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, resultAPI2.toString());
            appInvitationDataListener.onAppInvitationData(resultAPI2, appInvitationData);
        }
        return Unit.INSTANCE;
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public void getAppInvitationSenderInfo(final Promotion.AppInvitationSenderInfoListener listener) throws JSONException {
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (listener == null) {
            LoggerImpl.INSTANCE.w("[Promotion::getAppInvitationSenderInfo] listener is null");
        } else if (!HiveLifecycle.INSTANCE.isSdkSetup()) {
            LoggerImpl.INSTANCE.w("[Promotion::getAppInvitationSenderInfo] Setup HIVE module first");
            listener.onAppInvitationSenderInfo(new ResultAPI(-7, ResultAPI.Code.PromotionNotInitialized, ""), null);
        } else {
            PromotionNetwork.INSTANCE.uaSenderInfo(new Function2() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PromotionImpl.getAppInvitationSenderInfo$lambda$57(callMethodName, listener, (UaSenderInfo) obj, (Promotion.AppInvitationSenderInfo) obj2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getAppInvitationSenderInfo$lambda$57(String str, Promotion.AppInvitationSenderInfoListener appInvitationSenderInfoListener, UaSenderInfo uaSenderInfo, Promotion.AppInvitationSenderInfo appInvitationSenderInfo) {
        Intrinsics.checkNotNullParameter(uaSenderInfo, "uaSenderInfo");
        if (uaSenderInfo.getResponse().isFailure()) {
            LoggerImpl.INSTANCE.w("[Promotion::getAppInvitationSenderInfo] request failed");
            ResultAPI resultAPI = new ResultAPI(-8, ResultAPI.Code.PromotionServerResponseError, uaSenderInfo.getResponse().toString());
            LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, resultAPI.toString());
            appInvitationSenderInfoListener.onAppInvitationSenderInfo(resultAPI, appInvitationSenderInfo);
        } else {
            LoggerImpl.INSTANCE.i("[Promotion::getAppInvitationSenderInfo] acquisition network success");
            ResultAPI resultAPI2 = new ResultAPI(ResultAPI.Code.Success, uaSenderInfo.getResponse().getResultMessage());
            LoggerImpl.INSTANCE.dL("[Promotion::getAppInvitationSenderInfo] result : " + resultAPI2 + ", AppInvitationSenderInfo : " + appInvitationSenderInfo);
            LoggerImpl.INSTANCE.apiCallbackLog(Promotion.getTAG(), str, resultAPI2.toString());
            appInvitationSenderInfoListener.onAppInvitationSenderInfo(resultAPI2, appInvitationSenderInfo);
        }
        return Unit.INSTANCE;
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public void showUAShare(String inviteMessage, String inviteLink, boolean isIdentifier, Promotion.PromotionShareListener listener) {
        Intrinsics.checkNotNullParameter(inviteMessage, "inviteMessage");
        Intrinsics.checkNotNullParameter(inviteLink, "inviteLink");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (inviteMessage.length() == 0 && inviteLink.length() == 0) {
            listener.onPromotionShare(new ResultAPI(-1, ResultAPI.Code.PromotionShareFailed));
            return;
        }
        Intent intentPutExtra = new Intent().putExtra(HiveUiActivity.HIVE_UI_ACTIVITY_CHILD_STYLE, "Promotion");
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
        HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), intentPutExtra, new C29441(inviteMessage, inviteLink, isIdentifier, listener));
    }

    /* JADX INFO: renamed from: com.hive.promotion.PromotionImpl$showUAShare$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PromotionImpl.kt */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"com/hive/promotion/PromotionImpl$showUAShare$1", "Lcom/hive/ui/OnActivityLifecycle;", "promotionUAShareDialog", "Lcom/hive/promotion/PromotionUAShareDialog;", "getPromotionUAShareDialog", "()Lcom/hive/promotion/PromotionUAShareDialog;", "setPromotionUAShareDialog", "(Lcom/hive/promotion/PromotionUAShareDialog;)V", "onCreate", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C29441 extends OnActivityLifecycle {
        final /* synthetic */ String $inviteLink;
        final /* synthetic */ String $inviteMessage;
        final /* synthetic */ boolean $isIdentifier;
        final /* synthetic */ Promotion.PromotionShareListener $listener;
        public PromotionUAShareDialog promotionUAShareDialog;

        C29441(String str, String str2, boolean z, Promotion.PromotionShareListener promotionShareListener) {
            this.$inviteMessage = str;
            this.$inviteLink = str2;
            this.$isIdentifier = z;
            this.$listener = promotionShareListener;
        }

        public final PromotionUAShareDialog getPromotionUAShareDialog() {
            PromotionUAShareDialog promotionUAShareDialog = this.promotionUAShareDialog;
            if (promotionUAShareDialog != null) {
                return promotionUAShareDialog;
            }
            Intrinsics.throwUninitializedPropertyAccessException("promotionUAShareDialog");
            return null;
        }

        public final void setPromotionUAShareDialog(PromotionUAShareDialog promotionUAShareDialog) {
            Intrinsics.checkNotNullParameter(promotionUAShareDialog, "<set-?>");
            this.promotionUAShareDialog = promotionUAShareDialog;
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onCreate(final Activity activity, Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            super.onCreate(activity, savedInstanceState);
            PromotionUAShareDialog promotionUAShareDialog = new PromotionUAShareDialog(activity, this.$inviteMessage, this.$inviteLink, this.$isIdentifier);
            final Promotion.PromotionShareListener promotionShareListener = this.$listener;
            promotionUAShareDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.hive.promotion.PromotionImpl$showUAShare$1$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    PromotionImpl.C29441.onCreate$lambda$1$lambda$0(promotionShareListener, activity, dialogInterface);
                }
            });
            setPromotionUAShareDialog(promotionUAShareDialog);
            getPromotionUAShareDialog().show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCreate$lambda$1$lambda$0(Promotion.PromotionShareListener promotionShareListener, Activity activity, DialogInterface dialogInterface) {
            promotionShareListener.onPromotionShare(new ResultAPI());
            activity.finish();
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onConfigurationChanged(final Activity activity, Configuration newConfig) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            super.onConfigurationChanged(activity, newConfig);
            getPromotionUAShareDialog().setOnDismissListener(null);
            getPromotionUAShareDialog().dismiss();
            PromotionUAShareDialog promotionUAShareDialog = new PromotionUAShareDialog(activity, this.$inviteMessage, this.$inviteLink, this.$isIdentifier);
            final Promotion.PromotionShareListener promotionShareListener = this.$listener;
            promotionUAShareDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.hive.promotion.PromotionImpl$showUAShare$1$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    PromotionImpl.C29441.onConfigurationChanged$lambda$3$lambda$2(promotionShareListener, activity, dialogInterface);
                }
            });
            setPromotionUAShareDialog(promotionUAShareDialog);
            getPromotionUAShareDialog().show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onConfigurationChanged$lambda$3$lambda$2(Promotion.PromotionShareListener promotionShareListener, Activity activity, DialogInterface dialogInterface) {
            promotionShareListener.onPromotionShare(new ResultAPI());
            activity.finish();
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onDestroy(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (!getIsCalledFinish()) {
                getPromotionUAShareDialog().dismiss();
            }
            super.onDestroy(activity);
        }
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public void setAdditionalInfo(String additionalInfo) {
        Intrinsics.checkNotNullParameter(additionalInfo, "additionalInfo");
        PromotionNetwork.INSTANCE.setAdditionalInfo(additionalInfo);
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public void setAcquisitionAchieved() {
        if (HiveLifecycle.INSTANCE.isSignOut()) {
            return;
        }
        String value = Property.INSTANCE.getINSTANCE().getValue(PromotionKeys.IS_COMPANION_SENDED);
        if (value != null && Intrinsics.areEqual(value, PromotionKeys.IS_COMPANION_SENDED)) {
            LoggerImpl.INSTANCE.i("[Promotion] sendCompanion log exist : skip sending..");
        } else {
            PromotionNetwork.init$default(PromotionNetwork.INSTANCE, null, Promotion.PromotionWebviewType.COMPANION, true, false, null, new Function3() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PromotionImpl.setAcquisitionAchieved$lambda$58((Init) obj, ((Integer) obj2).intValue(), (ArrayList) obj3);
                }
            }, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setAcquisitionAchieved$lambda$58(Init init, int i, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(init, "init");
        Intrinsics.checkNotNullParameter(arrayList, "<unused var>");
        if (init.getResponse().isFailure()) {
            LoggerImpl.INSTANCE.w("[Promotion::apiInit] request failed");
            return Unit.INSTANCE;
        }
        LoggerImpl.INSTANCE.i("[Promotion::apiInit] response success");
        Property.setValue$default(Property.INSTANCE.getINSTANCE(), PromotionKeys.IS_COMPANION_SENDED, PromotionKeys.IS_COMPANION_SENDED, null, 4, null);
        Property.INSTANCE.getINSTANCE().writeProperties();
        return Unit.INSTANCE;
    }

    public final void onNetworkAvailable(boolean isAvailable) {
        if (isAvailable && NewsV2Activity.INSTANCE.getNavigation() == null) {
            updatePromotionData();
        }
    }

    public final void onConfigurationChanged(Activity activity, Configuration newConfig) {
        Unit unit;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        PromotionDialog promotionDialog = mPromotionDialog;
        if (promotionDialog != null) {
            if (promotionDialog.getActivity() instanceof HiveUiActivity) {
                LoggerImpl.INSTANCE.d("[Promotion] onConfigurationChanged() mPromotionDialog's activity is HiveUiActivity");
                unit = Unit.INSTANCE;
            } else {
                LoggerImpl.INSTANCE.d("[Promotion] onConfigurationChanged() mPromotionDialog's activity is HiveActivity");
                PromotionDialog promotionDialog2 = mPromotionDialog;
                if (promotionDialog2 != null) {
                    promotionDialog2.onConfigurationChanged();
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
            }
            if (unit != null) {
                return;
            }
        }
        LoggerImpl.INSTANCE.d("[Promotion] onConfigurationChanged() mPromotionDialog is null");
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public void setEngagementListener(final Promotion.EngagementListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        HiveUserEngagement userEngagement2 = getUserEngagement();
        if (userEngagement2 != null) {
            userEngagement2.setEngagementListener(new HiveUserEngagement.UserEngagementListener() { // from class: com.hive.promotion.PromotionImpl.setEngagementListener.1
                @Override // com.hive.module.interfaces.HiveUserEngagement.UserEngagementListener
                public void onEngagement(ResultAPI result, HiveUserEngagement.EventType eventType, HiveUserEngagement.EventState eventState, JSONObject param) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Intrinsics.checkNotNullParameter(eventType, "eventType");
                    Intrinsics.checkNotNullParameter(eventState, "eventState");
                    listener.onEngagement(result, Promotion.EngagementEventType.valueOf(eventType.name()), Promotion.EngagementEventState.valueOf(eventState.name()), param);
                }
            });
        }
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public ResultAPI setEngagementReady(boolean bEnabled) {
        ResultAPI engagementReady;
        HiveUserEngagement userEngagement2 = getUserEngagement();
        return (userEngagement2 == null || (engagementReady = userEngagement2.setEngagementReady(bEnabled)) == null) ? new ResultAPI(ResultAPI.Code.CommonUnknown, "UserEngagement NOT Plugged in.") : engagementReady;
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public boolean processUri(String uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        LoggerImpl.INSTANCE.apiCalledLog(Promotion.getTAG(), uri);
        HiveUserEngagement userEngagement2 = getUserEngagement();
        boolean zProcessUri = userEngagement2 != null ? userEngagement2.processUri(uri) : false;
        LoggerImpl.INSTANCE.apiReturnLog(Promotion.getTAG(), Boolean.toString(zProcessUri));
        return zProcessUri;
    }

    public final void consumeCoupon(String couponCode, HiveUserEngagement.CouponListener listener) {
        Intrinsics.checkNotNullParameter(couponCode, "couponCode");
        Intrinsics.checkNotNullParameter(listener, "listener");
        HiveUserEngagement userEngagement2 = getUserEngagement();
        if (userEngagement2 != null) {
            userEngagement2.consumeCoupon(couponCode, getAdditionalInfo(), listener);
        }
    }

    /* JADX INFO: renamed from: com.hive.promotion.PromotionImpl$requestDownloadInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PromotionImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.promotion.PromotionImpl$requestDownloadInfo$1", f = "PromotionImpl.kt", i = {0}, l = {2263, 2272}, m = "invokeSuspend", n = {"account"}, s = {"L$0"})
    static final class C29391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $authType;
        final /* synthetic */ boolean $isAgreementDetermineBaseAccount;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29391(boolean z, String str, Continuation<? super C29391> continuation) {
            super(2, continuation);
            this.$isAgreementDetermineBaseAccount = z;
            this.$authType = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29391(this.$isAgreementDetermineBaseAccount, this.$authType, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0078  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00b2  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 201
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.promotion.PromotionImpl.C29391.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public void requestDownloadInfo(String authType, boolean isAgreementDetermineBaseAccount) {
        Intrinsics.checkNotNullParameter(authType, "authType");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C29391(isAgreementDetermineBaseAccount, authType, null), 3, null);
    }

    public final void requestLogin() {
        if (progressedCpi && progressedLogin) {
            PromotionNetwork.INSTANCE.login(ConfigurationImpl.INSTANCE.isAgreementDetermineBaseAccount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isUpdatedDownloadInfo() {
        if (Property.INSTANCE.getINSTANCE().getValue(PromotionKeys.DOWNLOAD_INFO_VERSION) != null) {
            try {
                return !Intrinsics.areEqual(r0, String.valueOf(Android.INSTANCE.getAppVersionCode()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveDownloadInfoVersion() {
        try {
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), PromotionKeys.DOWNLOAD_INFO_VERSION, String.valueOf(Android.INSTANCE.getAppVersionCode()), null, 4, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Property.INSTANCE.getINSTANCE().writeProperties();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004e A[Catch: all -> 0x0070, TryCatch #0 {all -> 0x0070, blocks: (B:4:0x0005, B:10:0x002c, B:12:0x0032, B:13:0x0043, B:16:0x004a, B:19:0x0053, B:21:0x005a, B:25:0x0066, B:26:0x0069, B:18:0x004e, B:9:0x0022, B:6:0x0015), top: B:32:0x0005, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isSentCpiPlayerId(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "[Promotion] is - load cpi player list failure. : "
            r1 = 0
            if (r7 == 0) goto L7e
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L70
            com.hive.base.Property$Companion r2 = com.hive.base.Property.INSTANCE     // Catch: java.lang.Throwable -> L70
            com.hive.base.Property r2 = r2.getINSTANCE()     // Catch: java.lang.Throwable -> L70
            java.lang.String r3 = "promotion.sent_cpi_player_id_list"
            java.lang.String r2 = r2.getValue(r3)     // Catch: java.lang.Throwable -> L70
            if (r2 == 0) goto L4e
            kotlin.Result$Companion r3 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L21
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L21
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L21
            java.lang.Object r2 = kotlin.Result.m7415constructorimpl(r3)     // Catch: java.lang.Throwable -> L21
            goto L2c
        L21:
            r2 = move-exception
            kotlin.Result$Companion r3 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L70
            java.lang.Object r2 = kotlin.ResultKt.createFailure(r2)     // Catch: java.lang.Throwable -> L70
            java.lang.Object r2 = kotlin.Result.m7415constructorimpl(r2)     // Catch: java.lang.Throwable -> L70
        L2c:
            java.lang.Throwable r3 = kotlin.Result.m7418exceptionOrNullimpl(r2)     // Catch: java.lang.Throwable -> L70
            if (r3 == 0) goto L43
            com.hive.logger.LoggerImpl r4 = com.hive.logger.LoggerImpl.INSTANCE     // Catch: java.lang.Throwable -> L70
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L70
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L70
            r5.append(r3)     // Catch: java.lang.Throwable -> L70
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L70
            r4.w(r0)     // Catch: java.lang.Throwable -> L70
        L43:
            boolean r0 = kotlin.Result.m7421isFailureimpl(r2)     // Catch: java.lang.Throwable -> L70
            if (r0 == 0) goto L4a
            r2 = 0
        L4a:
            org.json.JSONArray r2 = (org.json.JSONArray) r2     // Catch: java.lang.Throwable -> L70
            if (r2 != 0) goto L53
        L4e:
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L70
            r2.<init>()     // Catch: java.lang.Throwable -> L70
        L53:
            int r0 = r2.length()     // Catch: java.lang.Throwable -> L70
            r3 = r1
        L58:
            if (r3 >= r0) goto L69
            java.lang.Object r4 = r2.get(r3)     // Catch: java.lang.Throwable -> L70
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r7)     // Catch: java.lang.Throwable -> L70
            if (r4 == 0) goto L66
            r7 = 1
            return r7
        L66:
            int r3 = r3 + 1
            goto L58
        L69:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L70
            java.lang.Object r7 = kotlin.Result.m7415constructorimpl(r7)     // Catch: java.lang.Throwable -> L70
            goto L7b
        L70:
            r7 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)
            java.lang.Object r7 = kotlin.Result.m7415constructorimpl(r7)
        L7b:
            kotlin.Result.m7414boximpl(r7)
        L7e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.promotion.PromotionImpl.isSentCpiPlayerId(java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d A[Catch: all -> 0x007a, TryCatch #1 {all -> 0x007a, blocks: (B:4:0x0004, B:10:0x002b, B:12:0x0031, B:13:0x0042, B:16:0x0049, B:19:0x0052, B:18:0x004d, B:9:0x0021, B:6:0x0014), top: B:27:0x0004, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void saveSentCpiPlayerId(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "[Promotion] save - load cpi player list failure. : "
            if (r9 == 0) goto L88
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L7a
            com.hive.base.Property$Companion r1 = com.hive.base.Property.INSTANCE     // Catch: java.lang.Throwable -> L7a
            com.hive.base.Property r1 = r1.getINSTANCE()     // Catch: java.lang.Throwable -> L7a
            java.lang.String r2 = "promotion.sent_cpi_player_id_list"
            java.lang.String r1 = r1.getValue(r2)     // Catch: java.lang.Throwable -> L7a
            if (r1 == 0) goto L4d
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L20
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L20
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L20
            java.lang.Object r1 = kotlin.Result.m7415constructorimpl(r2)     // Catch: java.lang.Throwable -> L20
            goto L2b
        L20:
            r1 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L7a
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)     // Catch: java.lang.Throwable -> L7a
            java.lang.Object r1 = kotlin.Result.m7415constructorimpl(r1)     // Catch: java.lang.Throwable -> L7a
        L2b:
            java.lang.Throwable r2 = kotlin.Result.m7418exceptionOrNullimpl(r1)     // Catch: java.lang.Throwable -> L7a
            if (r2 == 0) goto L42
            com.hive.logger.LoggerImpl r3 = com.hive.logger.LoggerImpl.INSTANCE     // Catch: java.lang.Throwable -> L7a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7a
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L7a
            r4.append(r2)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L7a
            r3.w(r0)     // Catch: java.lang.Throwable -> L7a
        L42:
            boolean r0 = kotlin.Result.m7421isFailureimpl(r1)     // Catch: java.lang.Throwable -> L7a
            if (r0 == 0) goto L49
            r1 = 0
        L49:
            org.json.JSONArray r1 = (org.json.JSONArray) r1     // Catch: java.lang.Throwable -> L7a
            if (r1 != 0) goto L52
        L4d:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L7a
            r1.<init>()     // Catch: java.lang.Throwable -> L7a
        L52:
            r1.put(r9)     // Catch: java.lang.Throwable -> L7a
            com.hive.base.Property$Companion r9 = com.hive.base.Property.INSTANCE     // Catch: java.lang.Throwable -> L7a
            com.hive.base.Property r2 = r9.getINSTANCE()     // Catch: java.lang.Throwable -> L7a
            java.lang.String r3 = "promotion.sent_cpi_player_id_list"
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L7a
            r6 = 4
            r7 = 0
            r5 = 0
            com.hive.base.Property.setValue$default(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L7a
            com.hive.base.Property$Companion r9 = com.hive.base.Property.INSTANCE     // Catch: java.lang.Throwable -> L7a
            com.hive.base.Property r9 = r9.getINSTANCE()     // Catch: java.lang.Throwable -> L7a
            boolean r9 = r9.writeProperties()     // Catch: java.lang.Throwable -> L7a
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch: java.lang.Throwable -> L7a
            java.lang.Object r9 = kotlin.Result.m7415constructorimpl(r9)     // Catch: java.lang.Throwable -> L7a
            goto L85
        L7a:
            r9 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m7415constructorimpl(r9)
        L85:
            kotlin.Result.m7414boximpl(r9)
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.promotion.PromotionImpl.saveSentCpiPlayerId(java.lang.String):void");
    }

    private final String getTodayYearMonthDate() {
        StringBuilder sb = new StringBuilder();
        sb.append(Calendar.getInstance().get(1));
        sb.append(Calendar.getInstance().get(2));
        sb.append('1');
        sb.append(Calendar.getInstance().get(5));
        return sb.toString();
    }

    public final void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        LoggerImpl.INSTANCE.i("[PrommotionImple] onActivityResult");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean processPromotionScheme(com.hive.core.Scheme r4) {
        /*
            r3 = this;
            java.lang.String r0 = "scheme"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            com.hive.logger.LoggerImpl r0 = com.hive.logger.LoggerImpl.INSTANCE
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "[Promotion::schemeEvent] url : "
            r1.<init>(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.dL(r1)
            com.hive.logger.LoggerImpl r0 = com.hive.logger.LoggerImpl.INSTANCE
            java.lang.String r1 = "[Promotion::schemeEvent]"
            r0.dR(r1)
            java.lang.String r0 = r4.getScheme()
            if (r0 == 0) goto L76
            int r1 = r0.hashCode()
            switch(r1) {
                case -1727028515: goto L68;
                case -1183762788: goto L5a;
                case -539460813: goto L3f;
                case 503143917: goto L36;
                case 1354859631: goto L2d;
                default: goto L2c;
            }
        L2c:
            goto L76
        L2d:
            java.lang.String r1 = "c2smercury"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L48
            goto L76
        L36:
            java.lang.String r1 = "interwork"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L63
            goto L76
        L3f:
            java.lang.String r1 = "hivepromotion"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L48
            goto L76
        L48:
            com.hive.promotion.ui.news.NewsV2Activity$Companion r0 = com.hive.promotion.ui.news.NewsV2Activity.INSTANCE
            boolean r0 = r0.isShow()
            if (r0 == 0) goto L55
            boolean r4 = r3.handleNewsNativeScheme(r4)
            goto L59
        L55:
            boolean r4 = r3.handlePromotionViewNativeScheme(r4)
        L59:
            return r4
        L5a:
            java.lang.String r1 = "intent"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L63
            goto L76
        L63:
            r3.processInterworkScheme(r4)
            r4 = 1
            return r4
        L68:
            java.lang.String r1 = "hivesocial"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L71
            goto L76
        L71:
            boolean r4 = r3.handleHiveSocialScheme(r4)
            return r4
        L76:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.promotion.PromotionImpl.processPromotionScheme(com.hive.core.Scheme):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void processInterworkScheme(final com.hive.core.Scheme r5) {
        /*
            r4 = this;
            com.hive.logger.LoggerImpl r0 = com.hive.logger.LoggerImpl.INSTANCE
            java.lang.String r1 = "[Promotion] Call processInterworkScheme()"
            r0.i(r1)
            com.hive.module.interfaces.HiveUserEngagement r0 = r4.getUserEngagement()     // Catch: java.lang.Exception -> Laf
            if (r0 == 0) goto La4
            java.lang.String r1 = r5.getUrl()     // Catch: java.lang.Exception -> Laf
            boolean r0 = r0.isEventValid(r1)     // Catch: java.lang.Exception -> Laf
            r1 = 1
            if (r0 != r1) goto La4
            com.hive.module.HiveModuleManager r0 = com.hive.module.HiveModuleManager.INSTANCE
            java.lang.Class<com.hive.module.interfaces.HiveUserEngagement> r2 = com.hive.module.interfaces.HiveUserEngagement.class
            java.lang.String r2 = r2.getName()
            java.lang.String r3 = "getName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            com.hive.module.HiveModule r0 = r0.getHiveModule(r2)
            boolean r2 = r0 instanceof com.hive.module.interfaces.HiveUserEngagement
            r3 = 0
            if (r2 == 0) goto L2f
            goto L30
        L2f:
            r0 = r3
        L30:
            boolean r2 = r0 instanceof com.hive.module.interfaces.HiveUserEngagement
            if (r2 != 0) goto L35
            r0 = r3
        L35:
            com.hive.module.interfaces.HiveUserEngagement r0 = (com.hive.module.interfaces.HiveUserEngagement) r0
            com.hive.module.HiveModule r0 = (com.hive.module.HiveModule) r0
            com.hive.module.interfaces.HiveUserEngagement r0 = (com.hive.module.interfaces.HiveUserEngagement) r0
            if (r0 == 0) goto L9c
            boolean r0 = r0.isReadyToProcess()
            if (r0 != 0) goto L44
            goto L9c
        L44:
            com.hive.promotion.PromotionDialog r0 = com.hive.promotion.PromotionImpl.mPromotionDialog
            if (r0 == 0) goto L4b
            r0.closeViewAll()
        L4b:
            java.lang.String r0 = r5.getPath()
            if (r0 == 0) goto L58
            com.hive.module.interfaces.HiveUserEngagement$InterworkApi$Companion r2 = com.hive.module.interfaces.HiveUserEngagement.InterworkApi.INSTANCE
            com.hive.module.interfaces.HiveUserEngagement$InterworkApi r0 = r2.getInterworkApi(r0)
            goto L59
        L58:
            r0 = r3
        L59:
            if (r0 == 0) goto L7a
            int[] r2 = com.hive.promotion.PromotionImpl.WhenMappings.$EnumSwitchMapping$2
            int r0 = r0.ordinal()
            r0 = r2[r0]
            if (r0 == r1) goto L76
            r1 = 2
            if (r0 == r1) goto L76
            com.hive.promotion.ui.news.NewsV2Activity$Companion r0 = com.hive.promotion.ui.news.NewsV2Activity.INSTANCE
            com.hive.promotion.ui.news.NewsV2Activity r0 = r0.getInstance()
            if (r0 == 0) goto L78
            r0.finish()
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            goto L78
        L76:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L78:
            if (r3 != 0) goto L8a
        L7a:
            r0 = r4
            com.hive.promotion.PromotionImpl r0 = (com.hive.promotion.PromotionImpl) r0
            com.hive.promotion.ui.news.NewsV2Activity$Companion r0 = com.hive.promotion.ui.news.NewsV2Activity.INSTANCE
            com.hive.promotion.ui.news.NewsV2Activity r0 = r0.getInstance()
            if (r0 == 0) goto L8a
            r0.finish()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L8a:
            android.os.Handler r0 = new android.os.Handler
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            r0.<init>(r1)
            com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda7 r1 = new com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda7
            r1.<init>()
            r0.post(r1)
            return
        L9c:
            com.hive.logger.LoggerImpl r5 = com.hive.logger.LoggerImpl.INSTANCE
            java.lang.String r0 = "[Promotion] UserEngagement is not ready"
            r5.d(r0)
            return
        La4:
            com.hive.logger.LoggerImpl r5 = com.hive.logger.LoggerImpl.INSTANCE     // Catch: java.lang.Exception -> Laf
            java.lang.String r0 = "[Promotion] UserEngagementEvent is not valid"
            r5.d(r0)     // Catch: java.lang.Exception -> Laf
            r4.showEngagementErrorDialog()     // Catch: java.lang.Exception -> Laf
            return
        Laf:
            r5 = move-exception
            com.hive.logger.LoggerImpl r0 = com.hive.logger.LoggerImpl.INSTANCE
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "[Promotion] UserEngagementEvent is not valid \n error: "
            r1.<init>(r2)
            java.lang.String r5 = r5.getMessage()
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.d(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.promotion.PromotionImpl.processInterworkScheme(com.hive.core.Scheme):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processInterworkScheme$lambda$70(Scheme scheme) {
        INSTANCE.processUri(scheme.getUrl());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final boolean handlePromotionViewNativeScheme(Scheme scheme) throws UnsupportedEncodingException {
        PromotionDialog promotionDialog;
        Activity activity;
        PromotionDialog promotionDialog2;
        String strDecode;
        PromotionDialog promotionDialog3;
        PromotionDialog promotionDialog4;
        LoggerImpl.INSTANCE.i("[Promotion] Call handlePromotionViewNativeScheme()");
        Uri.parse(scheme.getUrl()).getQuery();
        String host = scheme.getHost();
        if (host != null) {
            switch (host.hashCode()) {
                case -1548928098:
                    if (host.equals("offauto")) {
                        String str = scheme.getParameter().get("type_webview");
                        String str2 = scheme.getParameter().get(AnalyticsProviderAdjust.EventKeys.pid);
                        Integer numValueOf = str2 != null ? Integer.valueOf(Integer.parseInt(str2)) : null;
                        if (str == null || !(!StringsKt.isBlank(str)) || numValueOf == null) {
                            return true;
                        }
                        LoggerImpl.INSTANCE.i("[Promotion] shouldOverrideUrlLoading : host is [offauto]. query is " + str + " & " + numValueOf);
                        try {
                            PromotionDialog.INSTANCE.memorizeOffAutoParams(str, numValueOf.intValue());
                            PromotionDialog promotionDialog5 = mPromotionDialog;
                            if (promotionDialog5 != null) {
                                promotionDialog5.closeView();
                                break;
                            }
                            return true;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return false;
                        }
                    }
                    break;
                case -1240638001:
                    if (host.equals("goback")) {
                        PromotionDialog promotionDialog6 = mPromotionDialog;
                        if (promotionDialog6 != null) {
                            promotionDialog6.closeView(scheme.getHost());
                        }
                        return true;
                    }
                    break;
                case -1154856640:
                    if (host.equals("gobrowser")) {
                        String str3 = scheme.getParameter().get("url");
                        if (str3 != null) {
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(Uri.parse(str3));
                            PromotionDialog promotionDialog7 = mPromotionDialog;
                            if (promotionDialog7 != null && (activity = promotionDialog7.getActivity()) != null) {
                                ExtentionsKt.startActivityCatching$default(activity, intent, null, 2, null);
                            }
                            if (Intrinsics.areEqual(scheme.getParameter().get("close"), "1") && (promotionDialog = mPromotionDialog) != null) {
                                promotionDialog.closeView();
                            }
                        }
                        return true;
                    }
                    break;
                case 94756344:
                    if (host.equals("close")) {
                        PromotionDialog promotionDialog8 = mPromotionDialog;
                        if (promotionDialog8 != null) {
                            promotionDialog8.closeView();
                        }
                        return true;
                    }
                    break;
                case 97692013:
                    if (host.equals(TypedValues.AttributesType.S_FRAME)) {
                        String str4 = scheme.getParameter().get("url");
                        if (str4 != null && (promotionDialog2 = mPromotionDialog) != null) {
                            promotionDialog2.showFrameView(str4);
                        }
                        return true;
                    }
                    break;
                case 110066619:
                    if (host.equals("fullscreen")) {
                        String str5 = scheme.getParameter().get("display_orientation");
                        strDecode = str5 != null ? str5 : "";
                        String str6 = scheme.getParameter().get("url");
                        if (str6 != null && (promotionDialog3 = mPromotionDialog) != null) {
                            promotionDialog3.showNewFullScreenView(str6, strDecode);
                        }
                        return true;
                    }
                    break;
                case 191421644:
                    if (host.equals("inappbrowser")) {
                        String str7 = scheme.getParameter().get("url");
                        strDecode = str7 != null ? str7 : "";
                        if (!(!StringsKt.isBlank(strDecode))) {
                            LoggerImpl.INSTANCE.d("[Promotion] InAppBrowser invalid scheme url");
                            return true;
                        }
                        try {
                            String strDecode2 = URLDecoder.decode(strDecode, "UTF-8");
                            Intrinsics.checkNotNullExpressionValue(strDecode2, "decode(...)");
                            if (Intrinsics.areEqual(scheme.getParameter().get("close"), "1") && (promotionDialog4 = mPromotionDialog) != null) {
                                promotionDialog4.closeView();
                                break;
                            }
                            InAppBrowser.INSTANCE.show(HiveCoreInitializer.INSTANCE.getInitContext(), new InAppBrowserData(strDecode2, true, null, null, null, 28, null), new InAppBrowser.InAppBrowserListener() { // from class: com.hive.promotion.PromotionImpl.handlePromotionViewNativeScheme.5
                                @Override // com.hive.platformhelper.InAppBrowser.InAppBrowserListener
                                public void onInAppBrowser(ResultAPI result) {
                                    Intrinsics.checkNotNullParameter(result, "result");
                                    Logger.INSTANCE.d("[Promotion] InAppBrowser resultAPI = " + result);
                                }
                            });
                            return true;
                        } catch (Exception e2) {
                            LoggerImpl.INSTANCE.e("[Promotion] InAppBrowser URL decode failed: " + e2.getMessage());
                            return true;
                        }
                    }
                    break;
                case 1304260521:
                    if (host.equals("showOfferwall")) {
                        PromotionDialog promotionDialog9 = mPromotionDialog;
                        if (promotionDialog9 != null) {
                            promotionDialog9.closeView();
                        }
                        showOfferwall(new Promotion.PromotionViewListener() { // from class: com.hive.promotion.PromotionImpl.handlePromotionViewNativeScheme.2
                            @Override // com.hive.Promotion.PromotionViewListener
                            public void onPromotionView(ResultAPI result, Promotion.PromotionViewResultType type) {
                                Intrinsics.checkNotNullParameter(result, "result");
                                Intrinsics.checkNotNullParameter(type, "type");
                            }
                        });
                        return true;
                    }
                    break;
                case 1863354938:
                    if (host.equals("windowopen")) {
                        Map<String, String> parameter = scheme.getParameter();
                        String str8 = parameter.get("type");
                        if (str8 == null) {
                            str8 = "";
                        }
                        if (Intrinsics.areEqual(str8, "external")) {
                            String str9 = parameter.get("url");
                            strDecode = str9 != null ? str9 : "";
                            if (!StringsKt.isBlank(strDecode)) {
                                strDecode = URLDecoder.decode(strDecode, "UTF-8");
                                Intrinsics.checkNotNullExpressionValue(strDecode, "decode(...)");
                            }
                            Intent intent2 = new Intent("android.intent.action.VIEW");
                            intent2.setData(Uri.parse(strDecode));
                            ExtentionsKt.startActivityCatching$default(HiveActivity.INSTANCE.getRecentActivity(), intent2, null, 2, null);
                        }
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    private final boolean handleHiveSocialScheme(Scheme scheme) throws UnsupportedEncodingException {
        LoggerImpl.INSTANCE.i("[Promotion] Call handleHiveSocialScheme(host = " + scheme.getHost() + ')');
        if (!Intrinsics.areEqual(scheme.getHost(), "sharesns")) {
            return false;
        }
        String str = scheme.getParameter().get("title");
        String strDecode = "";
        if (str == null) {
            str = "";
        }
        String str2 = scheme.getParameter().get("url");
        if (str2 != null) {
            try {
                strDecode = URLDecoder.decode(str2, Charsets.UTF_8.name());
            } catch (Exception e) {
                LoggerImpl.INSTANCE.d("[Promotion] handleHiveSocialScheme handle \"sharesns\"\n exception: " + e.getMessage());
            }
        } else {
            LoggerImpl.INSTANCE.d("[Promotion] handleHiveSocialScheme handle url is null");
        }
        Intrinsics.checkNotNull(strDecode);
        showUAShare(str, strDecode, false, new Promotion.PromotionShareListener() { // from class: com.hive.promotion.PromotionImpl.handleHiveSocialScheme.1
            @Override // com.hive.Promotion.PromotionShareListener
            public void onPromotionShare(ResultAPI result) {
                Intrinsics.checkNotNullParameter(result, "result");
                LoggerImpl.INSTANCE.i("[Promotion] handleHiveSocialScheme showUAShare(result: " + result + ')');
            }
        });
        return true;
    }

    private final void showEngagementErrorDialog() {
        Intent intentPutExtra = new Intent().putExtra(HiveUiActivity.HIVE_UI_ACTIVITY_CHILD_STYLE, "Promotion");
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
        HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), intentPutExtra, new OnActivityLifecycle() { // from class: com.hive.promotion.PromotionImpl.showEngagementErrorDialog.1
            public EngagementErrorDialog dialog;

            public final EngagementErrorDialog getDialog() {
                EngagementErrorDialog engagementErrorDialog = this.dialog;
                if (engagementErrorDialog != null) {
                    return engagementErrorDialog;
                }
                Intrinsics.throwUninitializedPropertyAccessException("dialog");
                return null;
            }

            public final void setDialog(EngagementErrorDialog engagementErrorDialog) {
                Intrinsics.checkNotNullParameter(engagementErrorDialog, "<set-?>");
                this.dialog = engagementErrorDialog;
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onCreate(final Activity activity, Bundle savedInstanceState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                super.onCreate(activity, savedInstanceState);
                setDialog(new EngagementErrorDialog(activity, new EngagementErrorDialog.EngagementErrorDialogListener() { // from class: com.hive.promotion.PromotionImpl$showEngagementErrorDialog$1$onCreate$1
                    @Override // com.hive.promotion.EngagementErrorDialog.EngagementErrorDialogListener
                    public void onClose() {
                        activity.finish();
                    }
                }));
                getDialog().show();
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onConfigurationChanged(Activity activity, Configuration newConfig) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                Intrinsics.checkNotNullParameter(newConfig, "newConfig");
                super.onConfigurationChanged(activity, newConfig);
                getDialog().onConfigurationChanged(activity, newConfig);
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onDestroy(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (!getIsCalledFinish()) {
                    getDialog().dismiss();
                }
                super.onDestroy(activity);
            }
        });
    }

    private final boolean handleNewsNativeScheme(Scheme scheme) throws UnsupportedEncodingException {
        NewsV2Activity companion;
        LoggerImpl.INSTANCE.i("[Promotion] Call handleNewsNativeScheme()");
        String host = scheme.getHost();
        if (host != null) {
            int iHashCode = host.hashCode();
            if (iHashCode != 94756344) {
                if (iHashCode != 191421644) {
                    if (iHashCode == 1863354938 && host.equals("windowopen")) {
                        NewsV2Activity companion2 = NewsV2Activity.INSTANCE.getInstance();
                        if (companion2 == null) {
                            return true;
                        }
                        companion2.addView(scheme);
                        return true;
                    }
                } else if (host.equals("inappbrowser")) {
                    String str = scheme.getParameter().get("url");
                    if (str == null) {
                        str = "";
                    }
                    if (!StringsKt.isBlank(str)) {
                        try {
                            String strDecode = URLDecoder.decode(str, "UTF-8");
                            Intrinsics.checkNotNullExpressionValue(strDecode, "decode(...)");
                            if (Intrinsics.areEqual(scheme.getParameter().get("close"), "1") && (companion = NewsV2Activity.INSTANCE.getInstance()) != null) {
                                companion.finish();
                            }
                            InAppBrowser.INSTANCE.show(HiveCoreInitializer.INSTANCE.getInitContext(), new InAppBrowserData(strDecode, true, null, null, null, 28, null), new InAppBrowser.InAppBrowserListener() { // from class: com.hive.promotion.PromotionImpl.handleNewsNativeScheme.1
                                @Override // com.hive.platformhelper.InAppBrowser.InAppBrowserListener
                                public void onInAppBrowser(ResultAPI result) {
                                    Intrinsics.checkNotNullParameter(result, "result");
                                    Logger.INSTANCE.d("[Promotion] InAppBrowser resultAPI = " + result);
                                }
                            });
                            return true;
                        } catch (Exception e) {
                            LoggerImpl.INSTANCE.e("[Promotion] InAppBrowser URL decode failed: " + e.getMessage());
                            return true;
                        }
                    }
                    LoggerImpl.INSTANCE.d("[Promotion] InAppBrowser invalid scheme url");
                    return true;
                }
            } else if (host.equals("close")) {
                NewsV2Activity companion3 = NewsV2Activity.INSTANCE.getInstance();
                if (companion3 == null) {
                    return true;
                }
                companion3.finish();
                return true;
            }
        }
        return false;
    }

    public final ArrayList<PromotionView.WebViewInfo> convertWebViewInfoList(ArrayList<PromotionNetwork.WebViewInfo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "arrayList");
        ArrayList<PromotionView.WebViewInfo> arrayList2 = new ArrayList<>();
        Iterator<PromotionNetwork.WebViewInfo> it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            PromotionNetwork.WebViewInfo next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            arrayList2.add(new PromotionView.WebViewInfo(next.getOriginJson()));
        }
        return arrayList2;
    }

    public final String generatePromotionViewPostData(PromotionView.WebViewInfo webViewInfo, String isForced) {
        String string;
        Intrinsics.checkNotNullParameter(webViewInfo, "webViewInfo");
        Intrinsics.checkNotNullParameter(isForced, "isForced");
        JSONObject jSONObjectPutPromotionBasePostData$hive_promotion_release = PromotionNetwork.INSTANCE.putPromotionBasePostData$hive_promotion_release(new JSONObject());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("content_key", webViewInfo.getContentKey());
            jSONObject.put(AnalyticsProviderAdjust.EventKeys.pid, webViewInfo.getPid());
            jSONObject.put("type_webview", webViewInfo.getTypeWebView());
            if (Intrinsics.areEqual(isForced, DebugKt.DEBUG_PROPERTY_VALUE_ON) || Intrinsics.areEqual(isForced, DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                jSONObject.put("forced", isForced);
            } else {
                jSONObject.put("forced", DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            }
            CommonIdentifierKt.put(jSONObjectPutPromotionBasePostData$hive_promotion_release, HiveKeys.KEY_promotion, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HiveUserEngagement userEngagement2 = getUserEngagement();
        JSONObject jSONObjectAppendEventQueryParameters = userEngagement2 != null ? userEngagement2.appendEventQueryParameters(jSONObjectPutPromotionBasePostData$hive_promotion_release) : null;
        if (jSONObjectAppendEventQueryParameters != null && (string = jSONObjectAppendEventQueryParameters.toString()) != null) {
            return string;
        }
        String string2 = PromotionNetwork.INSTANCE.putPromotionBasePostData$hive_promotion_release(new JSONObject()).toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        return string2;
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public void updatePromotionData() {
        if (!HiveLifecycle.INSTANCE.isSdkSetup()) {
            LoggerImpl.INSTANCE.w("[Promotion] updatePromotionData() - SDK is not initialized.");
            return;
        }
        waitingUpdate.set(true);
        if (runningUpdate.compareAndSet(false, true)) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C29451(null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.hive.promotion.PromotionImpl$updatePromotionData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PromotionImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.promotion.PromotionImpl$updatePromotionData$1", f = "PromotionImpl.kt", i = {}, l = {2769, 2772, 2775}, m = "invokeSuspend", n = {}, s = {})
    static final class C29451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C29451(Continuation<? super C29451> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29451(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29451) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004c -> B:26:0x006f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x006c -> B:26:0x006f). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L26
                if (r1 == r5) goto L22
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                kotlin.ResultKt.throwOnFailure(r9)
                goto L6f
            L16:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1e:
                kotlin.ResultKt.throwOnFailure(r9)
                goto L64
            L22:
                kotlin.ResultKt.throwOnFailure(r9)
                goto L41
            L26:
                kotlin.ResultKt.throwOnFailure(r9)
            L29:
                java.util.concurrent.atomic.AtomicBoolean r9 = com.hive.promotion.PromotionImpl.access$getWaitingUpdate$p()
                boolean r9 = r9.getAndSet(r2)
                if (r9 == 0) goto L41
                com.hive.promotion.PromotionImpl r9 = com.hive.promotion.PromotionImpl.INSTANCE
                r1 = r8
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r8.label = r5
                java.lang.Object r9 = com.hive.promotion.PromotionImpl.access$requestNavigation(r9, r1)
                if (r9 != r0) goto L41
                return r0
            L41:
                java.util.concurrent.atomic.AtomicReference r9 = com.hive.promotion.PromotionImpl.access$getWaitingShow$p()
                r1 = 0
                java.lang.Object r9 = r9.getAndSet(r1)
                java.lang.Runnable r9 = (java.lang.Runnable) r9
                if (r9 == 0) goto L6f
                kotlinx.coroutines.MainCoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
                com.hive.promotion.PromotionImpl$updatePromotionData$1$1$1 r7 = new com.hive.promotion.PromotionImpl$updatePromotionData$1$1$1
                r7.<init>(r9, r1)
                kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
                r8.label = r4
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r6, r7, r8)
                if (r9 != r0) goto L64
                return r0
            L64:
                r8.label = r3
                r6 = 500(0x1f4, double:2.47E-321)
                java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r6, r8)
                if (r9 != r0) goto L6f
                return r0
            L6f:
                java.util.concurrent.atomic.AtomicBoolean r9 = com.hive.promotion.PromotionImpl.access$getWaitingUpdate$p()
                boolean r9 = r9.get()
                if (r9 != 0) goto L29
                java.util.concurrent.atomic.AtomicBoolean r9 = com.hive.promotion.PromotionImpl.access$getRunningUpdate$p()
                r9.set(r2)
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.promotion.PromotionImpl.C29451.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object requestNavigation(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.promotion.PromotionImpl.requestNavigation(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void preLoadImageNavigation(Navigation navigation) {
        loadImageOnDiskCache(navigation.getGiftBoxIconUrl());
        Iterator<T> it = navigation.getMenuList().iterator();
        while (it.hasNext()) {
            Navigation.Menu.Icon icon = ((Navigation.Menu) it.next()).getIcon();
            if (icon != null) {
                PromotionImpl promotionImpl = INSTANCE;
                promotionImpl.loadImageOnDiskCache(icon.getOffDark());
                promotionImpl.loadImageOnDiskCache(icon.getOffLight());
                promotionImpl.loadImageOnDiskCache(icon.getOnLightDark());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object requestBannerList(java.util.ArrayList<com.hive.promotion.PromotionNetwork.Menu> r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.promotion.PromotionImpl.requestBannerList(java.util.ArrayList, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void saveForceTime(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String todayYearMonthDate = getTodayYearMonthDate();
        Property.setValue$default(Property.INSTANCE.getINSTANCE(), "offauto" + key, todayYearMonthDate, null, 4, null);
        LoggerImpl.INSTANCE.i("[Promotion] saveForceTime key: offauto" + key + ", value: " + todayYearMonthDate);
        Property.INSTANCE.getINSTANCE().writeProperties();
    }

    public final String getForceTime(Promotion.PromotionViewType type) {
        String str;
        Intrinsics.checkNotNullParameter(type, "type");
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i != 2) {
            str = i != 3 ? "" : "notice";
        } else {
            str = "news";
        }
        String value = Property.INSTANCE.getINSTANCE().getValue("offauto".concat(str), "");
        LoggerImpl.INSTANCE.i("[Promotion] getForceTime value: " + value);
        return value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: PromotionImpl.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0014\u0010\b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/hive/promotion/PromotionImpl$PromotionWebChromeClient;", "Landroid/webkit/WebChromeClient;", "<init>", "()V", "onShowFileChooser", "", "webView", "Landroid/webkit/WebView;", "filePathCallback", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "fileChooserParams", "Landroid/webkit/WebChromeClient$FileChooserParams;", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final class PromotionWebChromeClient extends WebChromeClient {
        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, final ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            LoggerImpl.INSTANCE.d("[PromotionChromeClient] Call PromotionChromeClient.onShowFileChooser()");
            HivePicture.INSTANCE.getPictureFromChooser(new HivePicture.ChooserResultListener() { // from class: com.hive.promotion.PromotionImpl$PromotionWebChromeClient$onShowFileChooser$1
                @Override // com.hive.base.HivePicture.ChooserResultListener
                public void onChooserResult(ResultAPI result, Uri uri) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    LoggerImpl.INSTANCE.d("[PromotionChromeClient] HivePicture.onChooserResult()\nResultAPI: " + result + " Uri: " + uri);
                    if (result.isSuccess() && uri != null) {
                        HiveActivity.INSTANCE.getRecentActivity().grantUriPermission(HiveActivity.INSTANCE.getRecentActivity().getPackageName(), uri, 1);
                        ValueCallback<Uri[]> valueCallback = filePathCallback;
                        if (valueCallback != null) {
                            valueCallback.onReceiveValue(new Uri[]{uri});
                            return;
                        }
                        return;
                    }
                    ValueCallback<Uri[]> valueCallback2 = filePathCallback;
                    if (valueCallback2 != null) {
                        valueCallback2.onReceiveValue(null);
                    }
                }
            });
            return true;
        }
    }

    public final String getDeferredDeeplinkInfo$hive_promotion_release() {
        try {
            LoggerImpl.INSTANCE.d("getDeferredDeeplinkInfo");
            return DeferredDeeplinkActivity.getSharedPreferencesData(HiveCoreInitializer.INSTANCE.getInitContext(), PropertyKeys.DEFERRED_DEEPLINK_INFO);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.d("getDeferredDeeplinkInfo exception : " + e);
            return "";
        }
    }

    public final void removeDeferredDeeplinkInfo$hive_promotion_release() {
        try {
            LoggerImpl.INSTANCE.d("removeDeferredDeeplinkInfo");
            DeferredDeeplinkActivity.removeSharedPreferencesData(HiveCoreInitializer.INSTANCE.getInitContext(), PropertyKeys.DEFERRED_DEEPLINK_INFO);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.d("removeDeferredDeeplinkInfo exception : " + e);
        }
    }

    public final void requestIncreaseCount$hive_promotion_release(PromotionNetwork.IncreaseCountSupportType supportType) {
        Intrinsics.checkNotNullParameter(supportType, "supportType");
        LoggerImpl.INSTANCE.d("requestIncreaseCount, type : " + supportType.getValue());
        PromotionNetwork.INSTANCE.increaseCount(supportType);
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public void needDialogClosed(ResultAPI resultAPI) {
        Intrinsics.checkNotNullParameter(resultAPI, "resultAPI");
        PromotionDialog.PromotionDialogListener promotionDialogListener = mPromotionDialogListener;
        if (promotionDialogListener != null) {
            promotionDialogListener.needDialogClosed(new ResultAPI());
        }
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public void requestCompanion(JSONObject parameterJson, final Function1<? super ResultAPI, Unit> listener) {
        Intrinsics.checkNotNullParameter(parameterJson, "parameterJson");
        Intrinsics.checkNotNullParameter(listener, "listener");
        PromotionNetwork.INSTANCE.init(null, Promotion.PromotionWebviewType.COMPANION, true, false, parameterJson, new Function3() { // from class: com.hive.promotion.PromotionImpl$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return PromotionImpl.requestCompanion$lambda$86(listener, (Init) obj, ((Integer) obj2).intValue(), (ArrayList) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestCompanion$lambda$86(Function1 function1, Init init, int i, ArrayList arrayList) {
        ResultAPI resultAPI;
        ResultAPI resultAPI2;
        Intrinsics.checkNotNullParameter(init, "init");
        Intrinsics.checkNotNullParameter(arrayList, "<unused var>");
        if (init.getResponse().isSuccess()) {
            LoggerImpl.INSTANCE.v("[Promotion::apiInit/userengagement_companion] response success");
            resultAPI2 = new ResultAPI();
        } else {
            if (init.getResponse().getResult().isFailure()) {
                LoggerImpl.INSTANCE.w("[Promotion::apiInit/userengagement_companion] request failed");
                resultAPI = new ResultAPI(-5, ResultAPI.Code.PromotionNetworkError, init.toString());
            } else {
                LoggerImpl.INSTANCE.w("[Promotion::apiInit/userengagement_companion] response failed");
                resultAPI = new ResultAPI(-8, ResultAPI.Code.PromotionServerResponseError, init.getResponse().getResultMessage());
            }
            resultAPI2 = resultAPI;
        }
        function1.invoke(resultAPI2);
        return Unit.INSTANCE;
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public boolean newsV2IsShow() {
        return NewsV2Activity.INSTANCE.isShow();
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public boolean newsV2ShowOfferwall() {
        NewsV2Activity companion = NewsV2Activity.INSTANCE.getInstance();
        if (companion != null) {
            return companion.showOfferwall();
        }
        return false;
    }

    @Override // com.hive.module.interfaces.HivePromotion
    public void newsV2Finish() {
        NewsV2Activity companion = NewsV2Activity.INSTANCE.getInstance();
        if (companion != null) {
            companion.finish();
        }
    }

    @Override // com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        HashMap map = new HashMap();
        map.put(ModuleCheckName.INSTANCE.getHive_Promotion(), "26.2.0");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object preLoadImageBannerList(BannerList bannerList, Continuation<? super Boolean> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final int size = bannerList.getBannerList().size();
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        if (size == 0 && cancellableContinuationImpl2.isActive()) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(Result.m7415constructorimpl(Boxing.boxBoolean(false)));
        }
        for (final BannerList.Banner banner : bannerList.getBannerList()) {
            Glide.with(HiveActivity.INSTANCE.getRecentActivity()).load(banner.getImage()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.DATA).listener(new RequestListener<Drawable>() { // from class: com.hive.promotion.PromotionImpl$preLoadImageBannerList$2$1$1
                @Override // com.bumptech.glide.request.RequestListener
                public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                    Intrinsics.checkNotNullParameter(target, "target");
                    LoggerImpl.INSTANCE.w("[Promotion::preLoadImageBannerList] onLoadFailed(url: " + banner.getImage() + ")\nGlideException: " + e);
                    if (atomicInteger.addAndGet(1) != size || !cancellableContinuationImpl2.isActive()) {
                        return false;
                    }
                    CancellableContinuation<Boolean> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m7415constructorimpl(true));
                    return false;
                }

                @Override // com.bumptech.glide.request.RequestListener
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                    Intrinsics.checkNotNullParameter(resource, "resource");
                    Intrinsics.checkNotNullParameter(model, "model");
                    Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                    LoggerImpl.INSTANCE.d("[Promotion::preLoadImageBannerList] onResourceReady(url: " + banner.getImage() + ')');
                    NewsV2Activity.INSTANCE.getDownloadBannerList().put(Integer.valueOf(banner.getPid()), banner.getImage());
                    if (atomicInteger.addAndGet(1) != size || !cancellableContinuationImpl2.isActive()) {
                        return false;
                    }
                    CancellableContinuation<Boolean> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m7415constructorimpl(true));
                    return false;
                }
            }).preload();
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
