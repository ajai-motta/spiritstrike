package com.hive.auth;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.adjust.sdk.Constants;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.AuthV4;
import com.hive.Configuration;
import com.hive.Const;
import com.hive.HiveActivity;
import com.hive.Permission;
import com.hive.PlatformHelper;
import com.hive.Push;
import com.hive.ResultAPI;
import com.hive.SocialHive;
import com.hive.SocialV4;
import com.hive.analytics.AnalyticsImpl;
import com.hive.analytics.logger.RemoteLoggerV2;
import com.hive.auth.AuthDataInterface;
import com.hive.auth.AuthImpl;
import com.hive.auth.AuthNetwork;
import com.hive.auth.LoginCenterSelectDialog;
import com.hive.auth.MaintenanceDialog;
import com.hive.authv4.AuthV4Impl;
import com.hive.authv4.appupdate.AppUpdate;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.authv4.webviewflow.AuthV4AgreementView;
import com.hive.authv4.webviewflow.AuthV4TermsView;
import com.hive.authv4.webviewflow.AuthV4WebView;
import com.hive.base.Android;
import com.hive.base.EmulatorDetector;
import com.hive.base.Property;
import com.hive.base.PropertyKeys;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.Crypto;
import com.hive.core.ExtentionsKt;
import com.hive.core.NetworkSessionDelimiter;
import com.hive.core.StringUtil;
import com.hive.core.configuration.HiveZoneType;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.HiveAuth;
import com.hive.module.interfaces.HivePromotion;
import com.hive.module.interfaces.HiveUserEngagement;
import com.hive.module.interfaces.iapv4.Repayment;
import com.hive.permission.CheckPermission;
import com.hive.permission.PermissionImpl;
import com.hive.platformhelper.PlatformHelperImpl;
import com.hive.protocol.Protocol;
import com.hive.protocol.activeuser.Agreement;
import com.hive.protocol.activeuser.GetAgreement;
import com.hive.protocol.activeuser.GetNotice;
import com.hive.protocol.activeuser.GetWhiteListDomainByActiveUser;
import com.hive.protocol.activeuser.Referrer;
import com.hive.protocol.logincenter.GuestLogin;
import com.hive.protocol.logincenter.Logout;
import com.hive.protocol.logincenter.PreLogin;
import com.hive.protocol.logincenter.SignOut;
import com.hive.protocol.logincenter.Update;
import com.hive.push.PushImpl;
import com.hive.social.SocialAccount;
import com.hive.social.SocialDialog;
import com.hive.social.SocialHiveImpl;
import com.hive.social.SocialKeys;
import com.hive.socialv4.provider.SocialV4ProviderAdapter;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import com.moloco.sdk.internal.services.init.i;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0098\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\bÝ\u0001Þ\u0001ß\u0001à\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010>\u001a\u0004\u0018\u00010.J\u0006\u0010?\u001a\u00020.J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0007J\u000e\u0010D\u001a\u00020A2\u0006\u0010E\u001a\u00020\u0011J\b\u0010F\u001a\u0004\u0018\u00010\u0011J\b\u0010G\u001a\u0004\u0018\u00010\u0017J\u000e\u0010H\u001a\u00020A2\u0006\u0010I\u001a\u00020\u0015J\u001a\u0010J\u001a\u00020A2\b\u0010K\u001a\u0004\u0018\u00010\n2\b\u0010L\u001a\u0004\u0018\u00010MJ\"\u0010N\u001a\u00020A2\u0006\u0010O\u001a\u00020P2\b\u0010K\u001a\u0004\u0018\u00010\n2\b\u0010L\u001a\u0004\u0018\u00010MJ2\u0010Q\u001a\u00020A2\u001a\u0010R\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010T\u0012\u0004\u0012\u00020\u00150S2\u0006\u0010U\u001a\u00020VH\u0082@¢\u0006\u0002\u0010WJ\u0016\u0010X\u001a\u00020A2\u0006\u0010U\u001a\u00020VH\u0082@¢\u0006\u0002\u0010YJ\b\u0010Z\u001a\u00020AH\u0002J\"\u0010[\u001a\u00020\u000e2\b\u0010K\u001a\u0004\u0018\u00010\n2\b\u0010L\u001a\u0004\u0018\u00010MH\u0082@¢\u0006\u0002\u0010\\J\b\u0010]\u001a\u00020AH\u0002J\u000e\u0010^\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010_J\u0010\u0010`\u001a\u0004\u0018\u00010TH\u0082@¢\u0006\u0002\u0010_J\u0012\u0010a\u001a\u00020A2\b\u0010b\u001a\u0004\u0018\u00010TH\u0002J\u0010\u0010c\u001a\u00020A2\u0006\u0010b\u001a\u00020TH\u0002J \u0010d\u001a\u00020A2\u0016\u0010e\u001a\u0012\u0012\u0004\u0012\u00020g0fj\b\u0012\u0004\u0012\u00020g`hH\u0002J\b\u0010i\u001a\u00020AH\u0002J\u0010\u0010j\u001a\u00020\u000e2\u0006\u0010k\u001a\u00020\u0017H\u0002J\"\u0010l\u001a\u00020\u00152\b\u0010m\u001a\u0004\u0018\u00010n2\u0006\u0010o\u001a\u00020\u000e2\u0006\u0010k\u001a\u00020\u0017H\u0002J\u0018\u0010p\u001a\u00020A2\u0006\u0010k\u001a\u00020\u00172\u0006\u0010o\u001a\u00020\u000eH\u0002J\u001a\u0010q\u001a\u00020A2\b\u0010b\u001a\u0004\u0018\u00010T2\u0006\u0010r\u001a\u00020\u0015H\u0002J\b\u0010s\u001a\u00020AH\u0002J\b\u0010t\u001a\u00020AH\u0002J,\u0010u\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010T\u0012\u0004\u0012\u00020\u00150S2\b\u0010b\u001a\u0004\u0018\u00010TH\u0082@¢\u0006\u0002\u0010vJ\u0016\u0010w\u001a\u00020\u000e2\u0006\u0010x\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010yJ\b\u0010z\u001a\u00020AH\u0002J\b\u0010{\u001a\u00020AH\u0002J$\u0010|\u001a\u00020A2\u0006\u0010}\u001a\u00020\u00152\b\u0010~\u001a\u0004\u0018\u00010\u00172\b\u0010\u007f\u001a\u0004\u0018\u00010\u0017H\u0002J,\u0010\u0080\u0001\u001a\u00020A2\u0006\u0010}\u001a\u00020\u00152\b\u0010~\u001a\u0004\u0018\u00010\u00172\b\u0010\u007f\u001a\u0004\u0018\u00010\u00172\u0007\u0010B\u001a\u00030\u0081\u0001J\u001e\u0010\u0082\u0001\u001a\u00020A2\b\u0010$\u001a\u0004\u0018\u00010#2\t\u0010B\u001a\u0005\u0018\u00010\u0083\u0001H\u0016J\u001b\u0010\u0084\u0001\u001a\u00020A2\u0007\u0010\u0085\u0001\u001a\u00020\u00172\u0007\u0010B\u001a\u00030\u0083\u0001H\u0002J\u001b\u0010\u0086\u0001\u001a\u00020A2\u0007\u0010\u0085\u0001\u001a\u00020\u00172\u0007\u0010B\u001a\u00030\u0083\u0001H\u0002J\u001e\u0010\u0087\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0005\u0012\u00030\u0089\u00010\u0088\u00012\u0007\u0010\u008a\u0001\u001a\u00020nJ\u0007\u0010\u008b\u0001\u001a\u00020\u0015JD\u0010\u008c\u0001\u001a\u00020A2\u0017\u0010\u008d\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0005\u0012\u00030\u0089\u0001\u0018\u00010\u0088\u00012\u0017\u0010\u008e\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0005\u0012\u00030\u0089\u0001\u0018\u00010\u0088\u00012\t\u0010B\u001a\u0005\u0018\u00010\u0083\u0001J\u001b\u0010\u008f\u0001\u001a\u00020A2\u0007\u0010\u0090\u0001\u001a\u00020\u00172\t\u0010B\u001a\u0005\u0018\u00010\u0083\u0001J$\u0010\u0091\u0001\u001a\u00020A2\u0007\u0010\u0092\u0001\u001a\u00020\u00172\t\u0010B\u001a\u0005\u0018\u00010\u0083\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u0017J\u0012\u0010\u0093\u0001\u001a\u00020A2\t\u0010B\u001a\u0005\u0018\u00010\u0094\u0001J\u0017\u0010\u0095\u0001\u001a\u00020A2\u000e\u0010\u0096\u0001\u001a\t\u0012\u0004\u0012\u00020A0\u0097\u0001J\u0010\u0010\u0098\u0001\u001a\u00020A2\u0007\u0010B\u001a\u00030\u0094\u0001J\u0012\u0010\u0099\u0001\u001a\u00020A2\t\u0010B\u001a\u0005\u0018\u00010\u0094\u0001J\u0012\u0010\u009a\u0001\u001a\u00020A2\t\u0010B\u001a\u0005\u0018\u00010\u009b\u0001J\u001d\u0010\u009a\u0001\u001a\u00020A2\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u00172\t\u0010B\u001a\u0005\u0018\u00010\u009b\u0001J\u0012\u0010\u009d\u0001\u001a\u00020A2\t\u0010B\u001a\u0005\u0018\u00010\u009e\u0001J\u001a\u0010\u009f\u0001\u001a\u00020A2\u0007\u0010 \u0001\u001a\u00020\u00152\b\u0010¡\u0001\u001a\u00030¢\u0001J\u0007\u0010£\u0001\u001a\u00020\u0015J\u0012\u0010¤\u0001\u001a\u00020\u00152\t\u0010¥\u0001\u001a\u0004\u0018\u00010\u0017J\u0014\u0010¦\u0001\u001a\u00020A2\t\b\u0002\u0010§\u0001\u001a\u00020\u0015H\u0002J\u0007\u0010¨\u0001\u001a\u00020AJ(\u0010©\u0001\u001a\u00020\u00152\t\u0010¥\u0001\u001a\u0004\u0018\u00010\u00172\t\u0010ª\u0001\u001a\u0004\u0018\u00010\u00172\t\b\u0002\u0010«\u0001\u001a\u00020\u0015J\u0011\u0010¬\u0001\u001a\u00020A2\u0006\u0010B\u001a\u00020\fH\u0002J\u0011\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0003\b®\u0001J\u000f\u0010¯\u0001\u001a\u00020AH\u0000¢\u0006\u0003\b°\u0001J\u001e\u0010±\u0001\u001a\u00020A2\b\u0010²\u0001\u001a\u00030³\u00012\t\b\u0002\u0010´\u0001\u001a\u00020\u0015H\u0002J\u0013\u0010µ\u0001\u001a\u00020A2\b\u0010¶\u0001\u001a\u00030·\u0001H\u0002J\t\u0010¸\u0001\u001a\u00020AH\u0002J\t\u0010¹\u0001\u001a\u00020AH\u0007J\u0012\u0010º\u0001\u001a\u00020A2\u0007\u0010»\u0001\u001a\u00020\u0015H\u0007J\u001b\u0010¼\u0001\u001a\u00020A2\u0007\u0010½\u0001\u001a\u00020\u00172\t\u0010¾\u0001\u001a\u0004\u0018\u00010\u0017J \u0010¿\u0001\u001a\u00020A2\u000e\u0010À\u0001\u001a\t\u0012\u0004\u0012\u00020\u00170Á\u00012\u0007\u0010B\u001a\u00030Â\u0001J\u0012\u0010Ã\u0001\u001a\u00020\u00152\u0007\u0010Ä\u0001\u001a\u00020\u0017H\u0002J\u0012\u0010Å\u0001\u001a\u00020A2\u0007\u0010Ä\u0001\u001a\u00020\u0017H\u0002J\u0012\u0010Æ\u0001\u001a\u00020A2\u0007\u0010Ä\u0001\u001a\u00020\u0017H\u0002JF\u0010Ç\u0001\u001a\u00020A2\b\u0010È\u0001\u001a\u00030·\u00012\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010/\u001a\u0004\u0018\u00010.2\t\u0010É\u0001\u001a\u0004\u0018\u00010.2\u0007\u0010\u0085\u0001\u001a\u00020\u00172\t\u0010B\u001a\u0005\u0018\u00010\u0083\u0001H\u0002J-\u0010Ê\u0001\u001a\u00020A2\b\u0010È\u0001\u001a\u00030·\u00012\u0006\u0010$\u001a\u00020#2\u0007\u0010\u0085\u0001\u001a\u00020\u00172\u0007\u0010B\u001a\u00030\u0083\u0001H\u0002J'\u0010Ë\u0001\u001a\u00020A2\b\u0010È\u0001\u001a\u00030·\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u00172\t\u0010B\u001a\u0005\u0018\u00010\u0094\u0001H\u0002J\u0011\u0010Ì\u0001\u001a\u00020A2\b\u0010Í\u0001\u001a\u00030Î\u0001J\u0011\u0010Ï\u0001\u001a\u00020A2\b\u0010Í\u0001\u001a\u00030Î\u0001J/\u0010Ð\u0001\u001a\u00020A2\b\u0010Í\u0001\u001a\u00030Î\u00012\u0007\u0010Ñ\u0001\u001a\u00020\u000e2\u0007\u0010Ò\u0001\u001a\u00020\u000e2\n\u0010Ó\u0001\u001a\u0005\u0018\u00010Ô\u0001J:\u0010Õ\u0001\u001a\u00020A2\b\u0010Í\u0001\u001a\u00030Î\u00012\u0007\u0010Ñ\u0001\u001a\u00020\u000e2\u000e\u0010Ö\u0001\u001a\t\u0012\u0004\u0012\u00020\u00170×\u00012\b\u0010Ø\u0001\u001a\u00030Ù\u0001¢\u0006\u0003\u0010Ú\u0001J\u0019\u0010Û\u0001\u001a\u00020A2\u0010\u0010Ü\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0017\u0018\u00010Á\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\"\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\"\u001a\u0004\u0018\u00010#@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001bR\u001e\u0010+\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010/\u001a\u0004\u0018\u00010.2\b\u0010\"\u001a\u0004\u0018\u00010.@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b0\u00101R\u0010\u00102\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010,¨\u0006á\u0001"}, d2 = {"Lcom/hive/auth/AuthImpl;", "Lcom/hive/module/interfaces/HiveAuth;", "<init>", "()V", "defaultDispatcher", "Lkotlin/coroutines/CoroutineContext;", "ioDispatcher", "initializeScope", "Lkotlinx/coroutines/CoroutineScope;", "internalAuthInitializeListener", "Lcom/hive/auth/AuthDataInterface$AuthInitializeListener;", "internalAfterAgreementListener", "Lcom/hive/auth/AuthImpl$AfterAgreementListener;", "INITIALIZE_FLOW_PROCESS_SUCCESS", "", "INITIALIZE_FLOW_PROCESS_FAILED", "userAgreeListener", "Lcom/hive/auth/AuthImpl$UserAgreeListener;", "USER_AGREE_SUCCESS", "USER_AGREE_PRIVACY_SUCCESS", "showsNoticePopup", "", "peppermintCurrentUid", "", "getPeppermintCurrentUid", "()Ljava/lang/String;", "setPeppermintCurrentUid", "(Ljava/lang/String;)V", "peppermintCurrentSession", "getPeppermintCurrentSession", "setPeppermintCurrentSession", "peppermintCurrentPeppermint", "getPeppermintCurrentPeppermint", "setPeppermintCurrentPeppermint", "value", "Lcom/hive/auth/AuthDataInterface$LoginType;", "loginType", "getLoginType", "()Lcom/hive/auth/AuthDataInterface$LoginType;", "checkedAgreementVersion", "currentLoginVid", "getCurrentLoginVid$hive_service_release", "setCurrentLoginVid$hive_service_release", "isInitialize", "()Z", "isLoginInProgress", "Lcom/hive/auth/AuthDataInterface$Account;", "currentAccount", "setCurrentAccount", "(Lcom/hive/auth/AuthDataInterface$Account;)V", "recentSelectAccountUrl", "isInProgressInitialize", "isInProgressInitializeV1", "isEmergencyMode", "isInProgressTerms", "PROCESS_AGREEMENT_SHOW_AGREEMENT", "PROCESS_AGREEMENT_IGNORE_SHOW_AGREEMENT", "PROCESS_AGREEMENT_RESPONSE_ERROR", "ON_AGREEMENT_UI_FINISH", "ON_AGREEMENT_UI_FINISH_DO_PGS_LOGIN_PROC", "agreementShowValue", "isCheckedAgreement", "getAccountV1", "getAccount", "requestPermissionViewData", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/Permission$PermissionViewDataListener;", "setUserAgreeListener", "callback", "getUserAgreeListener", "getDID", "setShowsNoticePopup", "showsPopup", MobileAdsBridgeBase.initializeMethodName, "initializeListener", "engagementListener", "Lcom/hive/module/interfaces/HiveUserEngagement$UserEngagementListener;", "initializeSDKV1", "zone", "Lcom/hive/core/configuration/HiveZoneType;", "showAgreement", "triple", "Lkotlin/Triple;", "Lcom/hive/protocol/activeuser/GetAgreement$GetAgreementResponse;", "hiveSDKType", "Lcom/hive/auth/AuthImpl$AuthInitHiveType;", "(Lkotlin/Triple;Lcom/hive/auth/AuthImpl$AuthInitHiveType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAfterShowAgreementListener", "(Lcom/hive/auth/AuthImpl$AuthInitHiveType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkMaintenancePopupAndFinishInitialize", "initializeSettings", "(Lcom/hive/auth/AuthDataInterface$AuthInitializeListener;Lcom/hive/module/interfaces/HiveUserEngagement$UserEngagementListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectEmulator", "requestGetWhiteListDomain", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestGetAgreement", "needAgreementShowing", "responseGetAgreementData", "processAgreementShowing", "onAgreementUiResult", "agreementList", "Ljava/util/ArrayList;", "Lcom/hive/authv4/AuthV4Impl$Agreement;", "Lkotlin/collections/ArrayList;", "onAgreementFinish", "getAgreementVersionWithCountry", "countryCode", "createAgreementCountryVersionInfo", "jsonInfo", "Lorg/json/JSONObject;", "agreementVersion", "setAgreementCountryAndVersionInfo", "ignoreAgreementShowing", "needToSave", "executeModules", "processGetAgreementResponseError", "determineAgreementShowing", "(Lcom/hive/protocol/activeuser/GetAgreement$GetAgreementResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestDidAndSendAgreement", "isAgreementSuccess", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestPromotionDownloadInfo", "pgsLoginProc", "processLoginType", "isPGSLogin", "playerId", "playerName", "processLoginTypeSDKV1", "Lcom/hive/auth/AuthImpl$PreLoginListener;", "login", "Lcom/hive/auth/AuthDataInterface$AuthLoginListener;", "internalGuestLogin", "fApiName", "internalAccountLogin", "convertJsonToMap", "", "", "jsonData", "selectionSessionCheck", "showLoginSelection", "currentVidData", "usedVidData", "bindLogin", "selectedVid", "requestUpdate", "select", "logout", "Lcom/hive/auth/AuthDataInterface$AuthLogoutListener;", "disconnectGoogleProviderAfterLogout", "onComplete", "Lkotlin/Function0;", "logoutForHiveUserExit", "signOut", "showTerms", "Lcom/hive/auth/AuthDataInterface$AuthShowTermsListener;", "url", "showAdultConfirm", "Lcom/hive/auth/AuthDataInterface$AuthAdultConfirmListener;", "checkMaintenance", "isShow", "authMaintenanceListener", "Lcom/hive/auth/AuthDataInterface$AuthMaintenanceListener;", "setEmergencyMode", "setEmergencyModeWithUid", "uid", "onEmergencyMode", "isC2SModule", "reset", "onC2SModuleLogin", "uidSession", "isGuest", "setInternalAfterAgreementListener", "getInternalAfterAgreementListener", "getInternalAfterAgreementListener$hive_service_release", "memoryReset", "memoryReset$hive_service_release", "onInitializeSuccess", "authInitResult", "Lcom/hive/auth/AuthDataInterface$AuthInitResult;", "isSdkV1", "onInitializeFail", "resultAPI", "Lcom/hive/ResultAPI;", "printLogRefSDKVersion", "setEnableRequestStoragePermission", "setPermissionViewState", "isOn", "sendFunnelsLogs", "funnelTrack", "optionTag", "requestUserPermissions", "request", "", "Lcom/hive/PlatformHelper$RequestUserPermissionsListener;", "isNeedToSendLogWithVid", "vid", "setAgreementVidInfo", "sendAgreementLogWithVid", "onLoginFinish", "result", "usedAccount", "onLoginFail", "onLogoutFinish", "onStart", "activity", "Landroid/app/Activity;", "onStop", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(Landroid/app/Activity;I[Ljava/lang/String;[I)V", "setFacebookPermission", "permission", "AuthInitHiveType", "PreLoginListener", "AfterAgreementListener", "UserAgreeListener", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthImpl implements HiveAuth {
    private static final int INITIALIZE_FLOW_PROCESS_FAILED = -99;
    private static final int INITIALIZE_FLOW_PROCESS_SUCCESS = 0;
    public static final AuthImpl INSTANCE = new AuthImpl();
    private static final int ON_AGREEMENT_UI_FINISH = 0;
    private static final int ON_AGREEMENT_UI_FINISH_DO_PGS_LOGIN_PROC = 1;
    private static final int PROCESS_AGREEMENT_IGNORE_SHOW_AGREEMENT = 1;
    private static final int PROCESS_AGREEMENT_RESPONSE_ERROR = 2;
    private static final int PROCESS_AGREEMENT_SHOW_AGREEMENT = 0;
    public static final int USER_AGREE_PRIVACY_SUCCESS = 1000;
    public static final int USER_AGREE_SUCCESS = 0;
    private static int agreementShowValue;
    private static int checkedAgreementVersion;
    private static AuthDataInterface.Account currentAccount;
    private static String currentLoginVid;
    private static final CoroutineContext defaultDispatcher;
    private static final CoroutineScope initializeScope;
    private static AfterAgreementListener internalAfterAgreementListener;
    private static AuthDataInterface.AuthInitializeListener internalAuthInitializeListener;
    private static final CoroutineContext ioDispatcher;
    private static boolean isEmergencyMode;
    private static boolean isInProgressInitialize;
    private static boolean isInProgressInitializeV1;
    private static boolean isInProgressTerms;
    private static boolean isInitialize;
    private static boolean isLoginInProgress;
    private static AuthDataInterface.LoginType loginType;
    private static String peppermintCurrentPeppermint;
    private static String peppermintCurrentSession;
    private static String peppermintCurrentUid;
    private static String recentSelectAccountUrl;
    private static boolean showsNoticePopup;
    private static UserAgreeListener userAgreeListener;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/auth/AuthImpl$AfterAgreementListener;", "", "onAgreementUIFinish", "", "resultCode", "", "isAgreementSuccess", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AfterAgreementListener {
        void onAgreementUIFinish(int resultCode, boolean isAgreementSuccess);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/hive/auth/AuthImpl$AuthInitHiveType;", "", "<init>", "(Ljava/lang/String;I)V", "SDKV4", "SDKV1", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AuthInitHiveType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AuthInitHiveType[] $VALUES;
        public static final AuthInitHiveType SDKV4 = new AuthInitHiveType("SDKV4", 0);
        public static final AuthInitHiveType SDKV1 = new AuthInitHiveType("SDKV1", 1);

        private static final /* synthetic */ AuthInitHiveType[] $values() {
            return new AuthInitHiveType[]{SDKV4, SDKV1};
        }

        static {
            AuthInitHiveType[] authInitHiveTypeArr$values = $values();
            $VALUES = authInitHiveTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(authInitHiveTypeArr$values);
        }

        private AuthInitHiveType(String str, int i) {
        }

        public static EnumEntries<AuthInitHiveType> getEntries() {
            return $ENTRIES;
        }

        public static AuthInitHiveType valueOf(String str) {
            return (AuthInitHiveType) Enum.valueOf(AuthInitHiveType.class, str);
        }

        public static AuthInitHiveType[] values() {
            return (AuthInitHiveType[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/auth/AuthImpl$PreLoginListener;", "", "onPreLoginFinish", "", "result", "Lcom/hive/ResultAPI;", "jsonData", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface PreLoginListener {
        void onPreLoginFinish(ResultAPI result, JSONObject jsonData);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/auth/AuthImpl$UserAgreeListener;", "", "onUserAgreeResult", "", "callbackMsg", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface UserAgreeListener {
        void onUserAgreeResult(int callbackMsg);
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[AuthInitHiveType.values().length];
            try {
                iArr[AuthInitHiveType.SDKV4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AuthInitHiveType.SDKV1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[AuthDataInterface.LoginType.values().length];
            try {
                iArr2[AuthDataInterface.LoginType.GUEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[AuthDataInterface.LoginType.ACCOUNT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[AuthDataInterface.LoginType.AUTO.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[AuthDataInterface.LoginType.SELECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: renamed from: com.hive.auth.AuthImpl$determineAgreementShowing$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "", "Lcom/hive/protocol/activeuser/GetAgreement$GetAgreementResponse;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.auth.AuthImpl$determineAgreementShowing$2", f = "AuthImpl.kt", i = {}, l = {3753}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Triple<? extends Integer, ? extends GetAgreement.GetAgreementResponse, ? extends Boolean>>, Object> {
        final /* synthetic */ GetAgreement.GetAgreementResponse $responseGetAgreementData;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(GetAgreement.GetAgreementResponse getAgreementResponse, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$responseGetAgreementData = getAgreementResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$responseGetAgreementData, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Triple<? extends Integer, ? extends GetAgreement.GetAgreementResponse, ? extends Boolean>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Triple<Integer, GetAgreement.GetAgreementResponse, Boolean>>) continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            byte[] base64Decode$default;
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
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.i(AuthDataInterface.getTAG(), "[determinAgreementShowing (initialize flow 4). 약관 노출 여부 판단]");
            GetAgreement.GetAgreementResponse getAgreementResponse = this.$responseGetAgreementData;
            this.L$0 = getAgreementResponse;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.initCancellability();
            if (getAgreementResponse != null) {
                AuthImpl authImpl = AuthImpl.INSTANCE;
                AuthImpl.agreementShowValue = getAgreementResponse.getAgreement_show();
                if (getAgreementResponse.getErrno() != 0) {
                    loggerImpl.i(AuthDataInterface.getTAG(), "processAgreement, error (get_agreement response)");
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(Result.m7415constructorimpl(new Triple(Boxing.boxInt(2), getAgreementResponse, Boxing.boxBoolean(false))));
                } else if (getAgreementResponse.getAgreement_show() == 0 && getAgreementResponse.getAgreement_ex_show() == 0) {
                    loggerImpl.i(AuthDataInterface.getTAG(), "processAgreement, case 2");
                    if (!StringsKt.isBlank(getAgreementResponse.getAgreement_scheme())) {
                        try {
                            String queryParameter = Uri.parse(getAgreementResponse.getAgreement_scheme()).getQueryParameter("agreement");
                            if (queryParameter != null) {
                                Charset charset = Charsets.UTF_8;
                                byte[] bytes = queryParameter.getBytes(charset);
                                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                                if (bytes != null && (base64Decode$default = StringUtil.toBase64Decode$default(StringUtil.INSTANCE, bytes, 0, 1, null)) != null) {
                                    JSONObject jSONObjectOptJSONObject = new JSONObject(new String(base64Decode$default, charset)).optJSONObject("item");
                                    if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has(Constants.PUSH)) {
                                        PushImpl.INSTANCE.onAgreement(false, new Push.RemotePush(jSONObjectOptJSONObject.optBoolean(Constants.PUSH, false), jSONObjectOptJSONObject.optBoolean("night_push", false)));
                                    }
                                }
                            }
                            throw new Exception("agreement is null");
                        } catch (Exception e) {
                            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[initialize 3. processAgreement] agreement_scheme parsing failed. - " + e);
                        }
                    }
                    getAgreementResponse.setAgreement_version(0);
                    if (getAgreementResponse.getAgreement_ex_show() != 1 || StringsKt.isBlank(getAgreementResponse.getAgreement_ex_url())) {
                        LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "processAgreement, case 2-2 (IGNORE SHOW AGREE)");
                        Result.Companion companion2 = Result.INSTANCE;
                        cancellableContinuationImpl.resumeWith(Result.m7415constructorimpl(new Triple(Boxing.boxInt(1), getAgreementResponse, Boxing.boxBoolean(true))));
                    } else {
                        LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "processAgreement, case 2-1");
                        getAgreementResponse.setAgreement_url("");
                        Result.Companion companion3 = Result.INSTANCE;
                        cancellableContinuationImpl.resumeWith(Result.m7415constructorimpl(new Triple(Boxing.boxInt(0), getAgreementResponse, Boxing.boxBoolean(true))));
                    }
                } else {
                    loggerImpl.i(AuthDataInterface.getTAG(), "processAgreement, case 1");
                    AuthImpl authImpl2 = AuthImpl.INSTANCE;
                    if (authImpl2.isCheckedAgreement()) {
                        loggerImpl.i(AuthDataInterface.getTAG(), "processAgreement, case 1-1");
                        int agreementVersionWithCountry = authImpl2.getAgreementVersionWithCountry(ConfigurationImpl.INSTANCE.getHiveCountry());
                        if (agreementVersionWithCountry != -1) {
                            if (getAgreementResponse.getAgreement_version() > agreementVersionWithCountry) {
                                loggerImpl.i(AuthDataInterface.getTAG(), "processAgreement, case 1-1-1-1");
                                AuthImpl.checkedAgreementVersion = getAgreementResponse.getAgreement_version();
                                Result.Companion companion4 = Result.INSTANCE;
                                cancellableContinuationImpl.resumeWith(Result.m7415constructorimpl(new Triple(Boxing.boxInt(0), getAgreementResponse, Boxing.boxBoolean(false))));
                            } else if (getAgreementResponse.getAgreement_ex_show() != 1 || StringsKt.isBlank(getAgreementResponse.getAgreement_ex_url())) {
                                loggerImpl.i(AuthDataInterface.getTAG(), "processAgreement, case 1-1-1-2-2");
                                Result.Companion companion5 = Result.INSTANCE;
                                cancellableContinuationImpl.resumeWith(Result.m7415constructorimpl(new Triple(Boxing.boxInt(1), getAgreementResponse, Boxing.boxBoolean(false))));
                            } else {
                                loggerImpl.i(AuthDataInterface.getTAG(), "processAgreement, case 1-1-1-2-1");
                                getAgreementResponse.setAgreement_url("");
                                Result.Companion companion6 = Result.INSTANCE;
                                cancellableContinuationImpl.resumeWith(Result.m7415constructorimpl(new Triple(Boxing.boxInt(0), getAgreementResponse, Boxing.boxBoolean(true))));
                            }
                        } else if (getAgreementResponse.getAgreement_ex_show() != 1 || StringsKt.isBlank(getAgreementResponse.getAgreement_ex_url())) {
                            loggerImpl.i(AuthDataInterface.getTAG(), "processAgreement, case 1-1-2-2");
                            Property.setValue$default(Property.INSTANCE.getINSTANCE(), AuthKeys.INSTANCE.getAGREEMENT_LOG_PROPERTY(), "", null, 4, null);
                            Result.Companion companion7 = Result.INSTANCE;
                            cancellableContinuationImpl.resumeWith(Result.m7415constructorimpl(new Triple(Boxing.boxInt(1), getAgreementResponse, Boxing.boxBoolean(true))));
                        } else {
                            loggerImpl.i(AuthDataInterface.getTAG(), "processAgreement, case 1-1-2-1");
                            getAgreementResponse.setAgreement_url("");
                            Result.Companion companion8 = Result.INSTANCE;
                            cancellableContinuationImpl.resumeWith(Result.m7415constructorimpl(new Triple(Boxing.boxInt(0), getAgreementResponse, Boxing.boxBoolean(true))));
                        }
                    } else {
                        loggerImpl.i(AuthDataInterface.getTAG(), "processAgreement, case 1-2");
                        AuthImpl.checkedAgreementVersion = getAgreementResponse.getAgreement_version();
                        Result.Companion companion9 = Result.INSTANCE;
                        cancellableContinuationImpl.resumeWith(Result.m7415constructorimpl(new Triple(Boxing.boxInt(0), getAgreementResponse, Boxing.boxBoolean(false))));
                    }
                }
            }
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            return result == coroutine_suspended ? coroutine_suspended : result;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Triple<Integer, GetAgreement.GetAgreementResponse, Boolean>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.hive.auth.AuthImpl$initialize$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.auth.AuthImpl$initialize$1", f = "AuthImpl.kt", i = {}, l = {248, 260, 263, 265, 268}, m = "invokeSuspend", n = {}, s = {})
    public static final class C28031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HiveUserEngagement.UserEngagementListener $engagementListener;
        final /* synthetic */ AuthDataInterface.AuthInitializeListener $initializeListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28031(AuthDataInterface.AuthInitializeListener authInitializeListener, HiveUserEngagement.UserEngagementListener userEngagementListener, Continuation<? super C28031> continuation) {
            super(2, continuation);
            this.$initializeListener = authInitializeListener;
            this.$engagementListener = userEngagementListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0() {
            AuthImpl.INSTANCE.detectEmulator();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28031(this.$initializeListener, this.$engagementListener, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x0099, code lost:
        
            if (r1.showAgreement((kotlin.Triple) r9, r3, r8) != r0) goto L40;
         */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0075 A[Catch: Exception -> 0x0034, TryCatch #0 {Exception -> 0x0034, blocks: (B:9:0x0017, B:13:0x0024, B:37:0x008d, B:14:0x0028, B:34:0x0080, B:15:0x002c, B:29:0x006d, B:31:0x0075, B:42:0x009f, B:16:0x0030, B:24:0x0049, B:26:0x0051, B:44:0x00ad, B:21:0x003a), top: B:48:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x008d A[Catch: Exception -> 0x0034, PHI: r9
  0x008d: PHI (r9v24 java.lang.Object) = (r9v23 java.lang.Object), (r9v0 java.lang.Object) binds: [B:35:0x008a, B:13:0x0024] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {Exception -> 0x0034, blocks: (B:9:0x0017, B:13:0x0024, B:37:0x008d, B:14:0x0028, B:34:0x0080, B:15:0x002c, B:29:0x006d, B:31:0x0075, B:42:0x009f, B:16:0x0030, B:24:0x0049, B:26:0x0051, B:44:0x00ad, B:21:0x003a), top: B:48:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x009f A[Catch: Exception -> 0x0034, TRY_ENTER, TryCatch #0 {Exception -> 0x0034, blocks: (B:9:0x0017, B:13:0x0024, B:37:0x008d, B:14:0x0028, B:34:0x0080, B:15:0x002c, B:29:0x006d, B:31:0x0075, B:42:0x009f, B:16:0x0030, B:24:0x0049, B:26:0x0051, B:44:0x00ad, B:21:0x003a), top: B:48:0x000b }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 213
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.auth.AuthImpl.C28031.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28031) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.hive.auth.AuthImpl$initializeSDKV1$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.auth.AuthImpl$initializeSDKV1$1", f = "AuthImpl.kt", i = {}, l = {320, 332, 335, 337, 340}, m = "invokeSuspend", n = {}, s = {})
    public static final class C28041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HiveUserEngagement.UserEngagementListener $engagementListener;
        final /* synthetic */ AuthDataInterface.AuthInitializeListener $initializeListener;
        final /* synthetic */ HiveZoneType $zone;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28041(HiveZoneType hiveZoneType, AuthDataInterface.AuthInitializeListener authInitializeListener, HiveUserEngagement.UserEngagementListener userEngagementListener, Continuation<? super C28041> continuation) {
            super(2, continuation);
            this.$zone = hiveZoneType;
            this.$initializeListener = authInitializeListener;
            this.$engagementListener = userEngagementListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0() {
            AuthImpl.INSTANCE.detectEmulator();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28041(this.$zone, this.$initializeListener, this.$engagementListener, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x00d2, code lost:
        
            if (r1.showAgreement((kotlin.Triple) r10, r3, r9) != r0) goto L44;
         */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00ae A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:9:0x0017, B:13:0x0024, B:41:0x00c6, B:14:0x0029, B:38:0x00b9, B:15:0x002e, B:33:0x00a6, B:35:0x00ae, B:46:0x00d8, B:16:0x0033, B:28:0x0082, B:30:0x008a, B:48:0x00e6, B:25:0x0073), top: B:52:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00c6 A[Catch: Exception -> 0x0037, PHI: r10
  0x00c6: PHI (r10v28 java.lang.Object) = (r10v27 java.lang.Object), (r10v0 java.lang.Object) binds: [B:39:0x00c3, B:13:0x0024] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {Exception -> 0x0037, blocks: (B:9:0x0017, B:13:0x0024, B:41:0x00c6, B:14:0x0029, B:38:0x00b9, B:15:0x002e, B:33:0x00a6, B:35:0x00ae, B:46:0x00d8, B:16:0x0033, B:28:0x0082, B:30:0x008a, B:48:0x00e6, B:25:0x0073), top: B:52:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00d8 A[Catch: Exception -> 0x0037, TRY_ENTER, TryCatch #0 {Exception -> 0x0037, blocks: (B:9:0x0017, B:13:0x0024, B:41:0x00c6, B:14:0x0029, B:38:0x00b9, B:15:0x002e, B:33:0x00a6, B:35:0x00ae, B:46:0x00d8, B:16:0x0033, B:28:0x0082, B:30:0x008a, B:48:0x00e6, B:25:0x0073), top: B:52:0x000b }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 270
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.auth.AuthImpl.C28041.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.hive.auth.AuthImpl$initializeSettings$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.auth.AuthImpl$initializeSettings$2", f = "AuthImpl.kt", i = {}, l = {3753}, m = "invokeSuspend", n = {}, s = {})
    public static final class C28052 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ HiveUserEngagement.UserEngagementListener $engagementListener;
        final /* synthetic */ AuthDataInterface.AuthInitializeListener $initializeListener;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28052(HiveUserEngagement.UserEngagementListener userEngagementListener, AuthDataInterface.AuthInitializeListener authInitializeListener, Continuation<? super C28052> continuation) {
            super(2, continuation);
            this.$engagementListener = userEngagementListener;
            this.$initializeListener = authInitializeListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28052(this.$engagementListener, this.$initializeListener, continuation);
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
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.i(AuthDataInterface.getTAG(), "initializeSettings");
            HiveUserEngagement.UserEngagementListener userEngagementListener = this.$engagementListener;
            final AuthDataInterface.AuthInitializeListener authInitializeListener = this.$initializeListener;
            this.L$0 = userEngagementListener;
            this.L$1 = authInitializeListener;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.initCancellability();
            if (AuthV4Impl.INSTANCE.isSetup()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.AuthImpl$initializeSettings$2$1$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "AuthV4 is already setup. Please use AuthV4 class.");
                        AuthDataInterface.AuthInitializeListener authInitializeListener2 = authInitializeListener;
                        if (authInitializeListener2 != null) {
                            authInitializeListener2.onAuthInitialize(new ResultAPI(-2, ResultAPI.Code.AuthOnRunningV4, "AuthV4 is already setup. Please use AuthV4 class."), null);
                        }
                    }
                });
                if (cancellableContinuationImpl.isActive()) {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(Result.m7415constructorimpl(Boxing.boxInt(-99)));
                }
            } else if (AuthImpl.isInProgressInitialize) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.AuthImpl$initializeSettings$2$1$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "AuthV4 Setup is already in progress!");
                        AuthDataInterface.AuthInitializeListener authInitializeListener2 = authInitializeListener;
                        if (authInitializeListener2 != null) {
                            authInitializeListener2.onAuthInitialize(new ResultAPI(-3, ResultAPI.Code.AuthInProgressInitialize, "AuthV4 Setup is already in progress!"), null);
                        }
                    }
                });
                if (cancellableContinuationImpl.isActive()) {
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(Result.m7415constructorimpl(Boxing.boxInt(-99)));
                }
            } else {
                AuthImpl.isInProgressInitialize = true;
                NetworkSessionDelimiter.INSTANCE.reset();
                final String callMethodName = LoggerImpl.getCallMethodName(2);
                StringBuffer stringBuffer = new StringBuffer("\n=== SDK Version ===\nHIVE SDK=");
                stringBuffer.append(Configuration.getHiveSDKVersion());
                stringBuffer.append("\n=== SDK Version ===\n\n\n");
                loggerImpl.d(AuthDataInterface.getTAG(), stringBuffer.toString());
                if (userEngagementListener != null) {
                    HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
                    String name = HiveUserEngagement.class.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
                    if (!(hiveModule instanceof HiveUserEngagement)) {
                        hiveModule = null;
                    }
                    HiveUserEngagement hiveUserEngagement = (HiveUserEngagement) (hiveModule instanceof HiveUserEngagement ? hiveModule : null);
                    if (hiveUserEngagement != null) {
                        hiveUserEngagement.setEngagementListener(userEngagementListener);
                    }
                }
                if (ConfigurationImpl.INSTANCE.parseXmlConfigurationFile()) {
                    Android android2 = Android.INSTANCE;
                    String advertisingId = android2.getAdvertisingId();
                    StringBuffer stringBuffer2 = new StringBuffer("\n=== Advertising ID in initialize ===\n");
                    if (advertisingId != null) {
                        stringBuffer2.append(advertisingId);
                    } else {
                        stringBuffer2.append("It could not obtained Advertising Id from com.hive.base.Android.getAdvertisingId()");
                    }
                    stringBuffer2.append("\n=== Advertising ID ===\n\n");
                    loggerImpl.dL(stringBuffer2.toString());
                    android2.isEmulator();
                    RemoteLoggerV2.INSTANCE.discardStackedLog();
                    AuthImpl.internalAuthInitializeListener = new AuthDataInterface.AuthInitializeListener() { // from class: com.hive.auth.AuthImpl$initializeSettings$2$1$5
                        @Override // com.hive.auth.AuthDataInterface.AuthInitializeListener
                        public void onAuthInitialize(final ResultAPI result, final AuthDataInterface.AuthInitResult authInitResult) {
                            Intrinsics.checkNotNullParameter(result, "result");
                            AuthImpl.isInProgressInitialize = false;
                            AuthImpl.isInProgressInitializeV1 = false;
                            Handler handler = new Handler(Looper.getMainLooper());
                            final String str = callMethodName;
                            final AuthDataInterface.AuthInitializeListener authInitializeListener2 = authInitializeListener;
                            handler.post(new Runnable() { // from class: com.hive.auth.AuthImpl$initializeSettings$2$1$5$onAuthInitialize$1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    LoggerImpl.INSTANCE.apiCallbackLog(AuthDataInterface.getTAG(), str, result.toString());
                                    AuthDataInterface.AuthInitializeListener authInitializeListener3 = authInitializeListener2;
                                    if (authInitializeListener3 != null) {
                                        authInitializeListener3.onAuthInitialize(result, authInitResult);
                                    }
                                }
                            });
                        }
                    };
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str = String.format("[API_CALL] ===  %s() ===\nlistener = %s", Arrays.copyOf(new Object[]{"AuthSupport.initialize()", authInitializeListener}, 2));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    loggerImpl.i(AuthDataInterface.getTAG(), str);
                    if (Intrinsics.areEqual(Property.INSTANCE.getINSTANCE().getValue(PropertyKeys.IS_SENT_REFERRER), "false")) {
                        AuthNetwork.ActiveUser.INSTANCE.referrer(new Function1<Referrer, Unit>() { // from class: com.hive.auth.AuthImpl$initializeSettings$2$1$6
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Referrer referrer) {
                                invoke2(referrer);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Referrer it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                if (it.getResponse().isSuccess()) {
                                    LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "[initialize] Call referrer API success");
                                    Property.Companion companion3 = Property.INSTANCE;
                                    Property.setValue$default(companion3.getINSTANCE(), PropertyKeys.IS_SENT_REFERRER, "true", null, 4, null);
                                    companion3.getINSTANCE().writeProperties();
                                }
                            }
                        });
                    }
                    if (cancellableContinuationImpl.isActive()) {
                        Result.Companion companion3 = Result.INSTANCE;
                        cancellableContinuationImpl.resumeWith(Result.m7415constructorimpl(Boxing.boxInt(0)));
                    }
                } else {
                    AuthImpl.isInProgressInitialize = false;
                    AuthImpl.isInProgressInitializeV1 = false;
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.AuthImpl$initializeSettings$2$1$4
                        @Override // java.lang.Runnable
                        public final void run() {
                            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "parse error - check configuration xml file");
                            AuthDataInterface.AuthInitializeListener authInitializeListener2 = authInitializeListener;
                            if (authInitializeListener2 != null) {
                                authInitializeListener2.onAuthInitialize(new ResultAPI(-1, ResultAPI.Code.AuthInvalidConfigurationXml, "parse error - check configuration xml file"), null);
                            }
                        }
                    });
                    if (cancellableContinuationImpl.isActive()) {
                        Result.Companion companion4 = Result.INSTANCE;
                        cancellableContinuationImpl.resumeWith(Result.m7415constructorimpl(Boxing.boxInt(-99)));
                    }
                }
            }
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            return result == coroutine_suspended ? coroutine_suspended : result;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C28052) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.hive.auth.AuthImpl$printLogRefSDKVersion$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.auth.AuthImpl$printLogRefSDKVersion$1", f = "AuthImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C28071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C28071(Continuation<? super C28071> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28071(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String referenceSDKVersion = ConfigurationImpl.INSTANCE.getReferenceSDKVersion();
            if (referenceSDKVersion.length() > 0) {
                LoggerImpl.INSTANCE.i(Const.TAG, referenceSDKVersion);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28071) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.hive.auth.AuthImpl$requestDidAndSendAgreement$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.auth.AuthImpl$requestDidAndSendAgreement$2", f = "AuthImpl.kt", i = {}, l = {3753}, m = "invokeSuspend", n = {}, s = {})
    public static final class C28092 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ boolean $isAgreementSuccess;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28092(boolean z, Continuation<? super C28092> continuation) {
            super(2, continuation);
            this.$isAgreementSuccess = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28092(this.$isAgreementSuccess, continuation);
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
            LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "requestDidAndSendAgreement");
            boolean z = this.$isAgreementSuccess;
            this.Z$0 = z;
            this.label = 1;
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.initCancellability();
            HiveLifecycle.INSTANCE.onAgreement();
            AuthImpl authImpl = AuthImpl.INSTANCE;
            UserAgreeListener userAgreeListener = authImpl.getUserAgreeListener();
            if (userAgreeListener != null) {
                userAgreeListener.onUserAgreeResult(0);
            }
            if (!ConfigurationImpl.INSTANCE.getExitEventEnabled() || z) {
                AuthVerifier.INSTANCE.verifier(new Function0<Unit>() { // from class: com.hive.auth.AuthImpl$requestDidAndSendAgreement$2$1$1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Property instance = Property.INSTANCE.getINSTANCE();
                        AuthKeys authKeys = AuthKeys.INSTANCE;
                        String value = instance.getValue(authKeys.getAGREEMENT_LOG_PROPERTY());
                        if (Intrinsics.areEqual(value, authKeys.getAGREEMENT_LOG_VALUE_COMPLETED()) || Intrinsics.areEqual(value, authKeys.getAGREEMENT_LOG_VALUE_HOLD())) {
                            CancellableContinuation<Integer> cancellableContinuation = cancellableContinuationImpl;
                            Result.Companion companion = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m7415constructorimpl(1));
                        } else {
                            Protocol<Agreement> protocolAgreement = AuthNetwork.ActiveUser.INSTANCE.agreement();
                            final CancellableContinuation<Integer> cancellableContinuation2 = cancellableContinuationImpl;
                            protocolAgreement.request(new Function1<Agreement, Unit>() { // from class: com.hive.auth.AuthImpl$requestDidAndSendAgreement$2$1$1.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Agreement agreement) {
                                    invoke2(agreement);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Agreement it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    if (it.getResponse().isSuccess()) {
                                        Property.Companion companion2 = Property.INSTANCE;
                                        Property instance2 = companion2.getINSTANCE();
                                        AuthKeys authKeys2 = AuthKeys.INSTANCE;
                                        Property.setValue$default(instance2, authKeys2.getAGREEMENT_PRIVACY_STATE(), authKeys2.getAGREEMENT_PRIVACY_VALUE_COMPLETED(), null, 4, null);
                                        Property.setValue$default(companion2.getINSTANCE(), authKeys2.getAGREEMENT_LOG_PROPERTY(), authKeys2.getAGREEMENT_LOG_VALUE_COMPLETED(), null, 4, null);
                                        companion2.getINSTANCE().writeProperties();
                                    }
                                    CancellableContinuation<Integer> cancellableContinuation3 = cancellableContinuation2;
                                    Result.Companion companion3 = Result.INSTANCE;
                                    cancellableContinuation3.resumeWith(Result.m7415constructorimpl(0));
                                }
                            });
                        }
                    }
                });
            } else {
                authImpl.memoryReset$hive_service_release();
                authImpl.onInitializeFail(new ResultAPI(-17, ResultAPI.Code.AuthAgreementFail_DoExit, ""));
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m7415constructorimpl(Boxing.boxInt(-99)));
            }
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            return result == coroutine_suspended ? coroutine_suspended : result;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C28092) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.hive.auth.AuthImpl$requestGetAgreement$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/hive/protocol/activeuser/GetAgreement$GetAgreementResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.auth.AuthImpl$requestGetAgreement$2", f = "AuthImpl.kt", i = {}, l = {3753}, m = "invokeSuspend", n = {}, s = {})
    public static final class C28102 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GetAgreement.GetAgreementResponse>, Object> {
        int label;

        public C28102(Continuation<? super C28102> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28102(continuation);
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
            LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "[requestGetAgreement (initialize flow 3). 약관 정보 요청]");
            this.label = 1;
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.initCancellability();
            AuthNetwork.ActiveUser.INSTANCE.getAgreement().request(new Function1<GetAgreement, Unit>() { // from class: com.hive.auth.AuthImpl$requestGetAgreement$2$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GetAgreement getAgreement) {
                    invoke2(getAgreement);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(GetAgreement it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    AnalyticsImpl.INSTANCE.sendUserEntryFunnelsLogs(AnalyticsImpl.FunnelsTrack.SDK_BEGIN);
                    if (!StringsKt.isBlank(it.getResponse().getAgreement_review_url())) {
                        Property.Companion companion = Property.INSTANCE;
                        Property.setValue$default(companion.getINSTANCE(), AuthKeys.INSTANCE.getAGREEMENT_REVIEW_URL(), it.getResponse().getAgreement_review_url(), null, 4, null);
                        companion.getINSTANCE().writeProperties();
                    }
                    CancellableContinuation<GetAgreement.GetAgreementResponse> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m7415constructorimpl(it.getResponse()));
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            return result == coroutine_suspended ? coroutine_suspended : result;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super GetAgreement.GetAgreementResponse> continuation) {
            return ((C28102) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.hive.auth.AuthImpl$requestGetWhiteListDomain$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.auth.AuthImpl$requestGetWhiteListDomain$2", f = "AuthImpl.kt", i = {}, l = {3753}, m = "invokeSuspend", n = {}, s = {})
    public static final class C28112 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;

        public C28112(Continuation<? super C28112> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28112(continuation);
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
            LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[requestGetWhiteListDomain (initialize flow 2). provision/get-whitelist-domain 통신]");
            this.label = 1;
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.initCancellability();
            AuthNetwork.ActiveUser.INSTANCE.getWhiteListDomainByActiveUser(new Function2<Integer, GetWhiteListDomainByActiveUser, Unit>() { // from class: com.hive.auth.AuthImpl$requestGetWhiteListDomain$2$1$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, GetWhiteListDomainByActiveUser getWhiteListDomainByActiveUser) {
                    invoke(num.intValue(), getWhiteListDomainByActiveUser);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2, GetWhiteListDomainByActiveUser getWhitelistDomain) {
                    Intrinsics.checkNotNullParameter(getWhitelistDomain, "getWhitelistDomain");
                    CancellableContinuation<Boolean> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m7415constructorimpl(Boolean.TRUE));
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            return result == coroutine_suspended ? coroutine_suspended : result;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C28112) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.hive.auth.AuthImpl$showAgreement$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.auth.AuthImpl", f = "AuthImpl.kt", i = {0}, l = {360}, m = "showAgreement", n = {"triple"}, s = {"L$0"})
    public static final class C28151 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C28151(Continuation<? super C28151> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AuthImpl.this.showAgreement(null, null, this);
        }
    }

    static {
        CoroutineContext coroutineContextPlus = Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null));
        defaultDispatcher = coroutineContextPlus;
        ioDispatcher = Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null));
        initializeScope = CoroutineScopeKt.CoroutineScope(coroutineContextPlus);
        showsNoticePopup = true;
        peppermintCurrentUid = "";
        peppermintCurrentSession = "";
        peppermintCurrentPeppermint = "";
        currentLoginVid = "";
    }

    private AuthImpl() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkMaintenance$lambda$34(boolean z, final String str, final AuthDataInterface.AuthMaintenanceListener authMaintenanceListener, final GetNotice it, final AuthDataInterface.AuthMaintenanceInfo authMaintenanceInfo) {
        Intrinsics.checkNotNullParameter(it, "it");
        AnalyticsImpl.INSTANCE.sendUserEntryFunnelsLogs(AnalyticsImpl.FunnelsTrack.SERVER_MAINTENANCE_POPUP);
        if (!it.getResponse().getResult().isSuccess()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.AuthImpl$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    AuthImpl.checkMaintenance$lambda$34$lambda$33(it, str, authMaintenanceListener);
                }
            });
        } else if (!it.getResponse().isSuccess()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.AuthImpl$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    AuthImpl.checkMaintenance$lambda$34$lambda$32(it, str, authMaintenanceListener);
                }
            });
        } else if (it.getResponse().getNotice_show() == 1) {
            int notice_action = it.getResponse().getNotice_action();
            MaintenanceDialog.MaintenanceActionType maintenanceActionType = notice_action != 1 ? (notice_action == 2 || notice_action != 3) ? MaintenanceDialog.MaintenanceActionType.EXIT : MaintenanceDialog.MaintenanceActionType.DONE : MaintenanceDialog.MaintenanceActionType.OPEN_URL;
            MaintenanceDialog.MaintenanceActionType maintenanceActionType2 = maintenanceActionType;
            ArrayList arrayList = new ArrayList();
            JSONArray button_list = it.getResponse().getButton_list();
            if (button_list != null) {
                int length = button_list.length();
                for (int i = 0; i < length; i++) {
                    try {
                        JSONObject jSONObjectOptJSONObject = button_list.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null) {
                            MaintenanceDialog.MaintenanceActionType maintenanceActionTypeFindValue = MaintenanceDialog.MaintenanceActionType.INSTANCE.findValue(jSONObjectOptJSONObject.optInt(NativeProtocol.WEB_DIALOG_ACTION));
                            if (maintenanceActionTypeFindValue == null) {
                                maintenanceActionTypeFindValue = MaintenanceDialog.MaintenanceActionType.DONE;
                            }
                            String strOptString = jSONObjectOptJSONObject.optString("url");
                            String strOptString2 = jSONObjectOptJSONObject.optString("button");
                            Intrinsics.checkNotNull(strOptString);
                            Intrinsics.checkNotNull(strOptString2);
                            arrayList.add(new MaintenanceDialog.MaintenanceExtraButton(maintenanceActionTypeFindValue, strOptString, strOptString2));
                        }
                    } catch (Exception e) {
                        LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[checkMaintenance] exButtons parse Exception: " + e);
                    }
                }
            }
            final MaintenanceDialog.MaintenanceModel maintenanceModel = new MaintenanceDialog.MaintenanceModel(it.getResponse().getNotice_title(), it.getResponse().getNotice_message(), null, it.getResponse().getNotice_button(), maintenanceActionType2, it.getResponse().getNotice_url(), it.getResponse().getRemaining_time(), null, null, null, null, arrayList, null, 6020, null);
            if (z) {
                AppUpdate appUpdate = AppUpdate.INSTANCE;
                appUpdate.launchAppUpdateFlow(appUpdate.appUpdateType(authMaintenanceInfo), new Function1() { // from class: com.hive.auth.AuthImpl$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AuthImpl.checkMaintenance$lambda$34$lambda$29(it, str, authMaintenanceListener, authMaintenanceInfo, maintenanceModel, ((Boolean) obj).booleanValue());
                    }
                });
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.AuthImpl$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        AuthImpl.checkMaintenance$lambda$34$lambda$30(it, str, authMaintenanceListener, authMaintenanceInfo);
                    }
                });
            }
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.AuthImpl$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    AuthImpl.checkMaintenance$lambda$34$lambda$31(it, str, authMaintenanceListener);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkMaintenance$lambda$34$lambda$29(final GetNotice getNotice, final String str, final AuthDataInterface.AuthMaintenanceListener authMaintenanceListener, final AuthDataInterface.AuthMaintenanceInfo authMaintenanceInfo, final MaintenanceDialog.MaintenanceModel maintenanceModel, boolean z) {
        if (z) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.AuthImpl$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    AuthImpl.checkMaintenance$lambda$34$lambda$29$lambda$28(getNotice, str, authMaintenanceListener, authMaintenanceInfo);
                }
            });
        } else {
            HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new OnActivityLifecycle() { // from class: com.hive.auth.AuthImpl$checkMaintenance$1$2$2
                public MaintenanceDialog dialog;

                public final MaintenanceDialog getDialog() {
                    MaintenanceDialog maintenanceDialog = this.dialog;
                    if (maintenanceDialog != null) {
                        return maintenanceDialog;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("dialog");
                    return null;
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onConfigurationChanged(Activity activity, android.content.res.Configuration newConfig) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    Intrinsics.checkNotNullParameter(newConfig, "newConfig");
                    super.onConfigurationChanged(activity, newConfig);
                    getDialog().onConfigurationChanged(activity, newConfig);
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onCreate(Activity activity, Bundle savedInstanceState) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    super.onCreate(activity, savedInstanceState);
                    setDialog(new MaintenanceDialog(activity, maintenanceModel, new AuthImpl$checkMaintenance$1$2$2$onCreate$1(activity, getNotice, str, authMaintenanceListener, authMaintenanceInfo)));
                    getDialog().show();
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onDestroy(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    if (!getIsCalledFinish()) {
                        getDialog().dismiss();
                    }
                    super.onDestroy(activity);
                }

                public final void setDialog(MaintenanceDialog maintenanceDialog) {
                    Intrinsics.checkNotNullParameter(maintenanceDialog, "<set-?>");
                    this.dialog = maintenanceDialog;
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkMaintenance$lambda$34$lambda$29$lambda$28(GetNotice getNotice, String str, AuthDataInterface.AuthMaintenanceListener authMaintenanceListener, AuthDataInterface.AuthMaintenanceInfo authMaintenanceInfo) {
        ResultAPI resultAPI = new ResultAPI(0, ResultAPI.Code.Success, "checkMaintenance success : " + getNotice);
        LoggerImpl.INSTANCE.apiCallbackLog(AuthDataInterface.getTAG(), str, resultAPI.toString());
        authMaintenanceListener.onAuthMaintenance(resultAPI, authMaintenanceInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkMaintenance$lambda$34$lambda$30(GetNotice getNotice, String str, AuthDataInterface.AuthMaintenanceListener authMaintenanceListener, AuthDataInterface.AuthMaintenanceInfo authMaintenanceInfo) {
        ResultAPI resultAPI = new ResultAPI(0, ResultAPI.Code.Success, "checkMaintenance success : " + getNotice);
        LoggerImpl.INSTANCE.apiCallbackLog(AuthDataInterface.getTAG(), str, resultAPI.toString());
        authMaintenanceListener.onAuthMaintenance(resultAPI, authMaintenanceInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkMaintenance$lambda$34$lambda$31(GetNotice getNotice, String str, AuthDataInterface.AuthMaintenanceListener authMaintenanceListener) {
        ResultAPI resultAPI = new ResultAPI(0, ResultAPI.Code.Success, "checkMaintenance success : " + getNotice);
        LoggerImpl.INSTANCE.apiCallbackLog(AuthDataInterface.getTAG(), str, resultAPI.toString());
        authMaintenanceListener.onAuthMaintenance(resultAPI, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkMaintenance$lambda$34$lambda$32(GetNotice getNotice, String str, AuthDataInterface.AuthMaintenanceListener authMaintenanceListener) {
        ResultAPI resultAPI = new ResultAPI(-8, ResultAPI.Code.AuthResponseFailCheckMaintenance, "checkMaintenance server error : " + getNotice);
        LoggerImpl.INSTANCE.apiCallbackLog(AuthDataInterface.getTAG(), str, resultAPI.toString());
        authMaintenanceListener.onAuthMaintenance(resultAPI, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkMaintenance$lambda$34$lambda$33(GetNotice getNotice, String str, AuthDataInterface.AuthMaintenanceListener authMaintenanceListener) {
        ResultAPI resultAPI = new ResultAPI(-98, ResultAPI.Code.AuthNetworkErrorCheckMaintenance, String.valueOf(getNotice.getResponse().getResult()));
        LoggerImpl.INSTANCE.apiCallbackLog(AuthDataInterface.getTAG(), str, resultAPI.toString());
        authMaintenanceListener.onAuthMaintenance(resultAPI, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkMaintenancePopupAndFinishInitialize() {
        LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "checkMaintenancePopupAndFinishInitialize, showNoticePopup : " + showsNoticePopup);
        final AuthDataInterface.AuthInitResult authInitResult = new AuthDataInterface.AuthInitResult(HiveLifecycle.INSTANCE.getDid());
        if (showsNoticePopup) {
            checkMaintenance(true, new AuthDataInterface.AuthMaintenanceListener() { // from class: com.hive.auth.AuthImpl.checkMaintenancePopupAndFinishInitialize.1
                @Override // com.hive.auth.AuthDataInterface.AuthMaintenanceListener
                public void onAuthMaintenance(ResultAPI result, AuthDataInterface.AuthMaintenanceInfo authMaintenanceInfo) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (result.isSuccess()) {
                        AuthImpl.INSTANCE.onInitializeSuccess(authInitResult, true);
                    } else {
                        AuthImpl.INSTANCE.onInitializeFail(result);
                    }
                }
            });
        } else {
            onInitializeSuccess(authInitResult, true);
        }
    }

    private final boolean createAgreementCountryVersionInfo(JSONObject jsonInfo, int agreementVersion, String countryCode) {
        if (jsonInfo == null) {
            try {
                jsonInfo = new JSONObject();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", agreementVersion);
        jSONObject.put("vid", new JSONArray());
        jsonInfo.put(countryCode, jSONObject);
        Property.Companion companion = Property.INSTANCE;
        Property.setValue$default(companion.getINSTANCE(), AuthKeys.INSTANCE.getAGREEMENT_COUNTRY_VERSION_WITH_VID(), jsonInfo.toString(), null, 4, null);
        companion.getINSTANCE().writeProperties();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void detectEmulator() {
        LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "detectEmulator");
        Property.Companion companion = Property.INSTANCE;
        String value = companion.getINSTANCE().getValue("EmulatorDetector", "");
        String value2 = companion.getINSTANCE().getValue("EmulatorCause", "");
        final Activity recentActivity = HiveActivity.INSTANCE.getRecentActivity();
        try {
            final EmulatorDetector.Emulator emulatorCheckEmulator = new EmulatorDetector(recentActivity).checkEmulator();
            if (emulatorCheckEmulator != null && Configuration.getUseLog()) {
                Android.INSTANCE.runOnMainThread(new Runnable() { // from class: com.hive.auth.AuthImpl$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        AuthImpl.detectEmulator$lambda$1$lambda$0(recentActivity, emulatorCheckEmulator);
                    }
                });
            }
            if (value.length() == 0 && emulatorCheckEmulator != null) {
                String emulatorName = emulatorCheckEmulator.getEmulatorName();
                String cause = emulatorCheckEmulator.getCause();
                Property.setValue$default(companion.getINSTANCE(), "EmulatorDetector", emulatorName, null, 4, null);
                Property.setValue$default(companion.getINSTANCE(), "EmulatorCause", cause, null, 4, null);
                AnalyticsImpl.INSTANCE.sendClientEmulatorBaseDataLog(emulatorName, cause);
                Unit unit = Unit.INSTANCE;
                return;
            }
            if (value.length() != 0 && emulatorCheckEmulator == null) {
                Property.setValue$default(companion.getINSTANCE(), "EmulatorCause", "", null, 4, null);
                AnalyticsImpl.INSTANCE.sendClientEmulatorBaseDataLog(value, "");
                Property.setValue$default(companion.getINSTANCE(), "EmulatorDetector", value, null, 4, null);
                return;
            }
            if (value.length() != 0 && emulatorCheckEmulator != null) {
                if (!Intrinsics.areEqual(value, emulatorCheckEmulator.getEmulatorName())) {
                    String emulatorName2 = emulatorCheckEmulator.getEmulatorName();
                    String cause2 = emulatorCheckEmulator.getCause();
                    Property.setValue$default(companion.getINSTANCE(), "EmulatorDetector", emulatorName2, null, 4, null);
                    Property.setValue$default(companion.getINSTANCE(), "EmulatorCause", cause2, null, 4, null);
                    AnalyticsImpl.INSTANCE.sendClientEmulatorBaseDataLog(emulatorName2, cause2);
                } else if (!Intrinsics.areEqual(value2, emulatorCheckEmulator.getCause())) {
                    String cause3 = emulatorCheckEmulator.getCause();
                    Property.setValue$default(companion.getINSTANCE(), "EmulatorCause", cause3, null, 4, null);
                    AnalyticsImpl.INSTANCE.sendClientEmulatorBaseDataLog(value, cause3);
                }
                Unit unit2 = Unit.INSTANCE;
                return;
            }
            Unit unit3 = Unit.INSTANCE;
        } catch (Exception e) {
            e.printStackTrace();
            Unit unit4 = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detectEmulator$lambda$1$lambda$0(Activity activity, EmulatorDetector.Emulator emulator) {
        Android.INSTANCE.copyToClipboard(activity, "EmulatorDetector", emulator.getCause());
        Toast.makeText(HiveActivity.INSTANCE.getRecentActivity(), emulator.getEmulatorName(), 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object determineAgreementShowing(GetAgreement.GetAgreementResponse getAgreementResponse, Continuation<? super Triple<Integer, GetAgreement.GetAgreementResponse, Boolean>> continuation) {
        return BuildersKt.withContext(ioDispatcher, new AnonymousClass2(getAgreementResponse, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void disconnectGoogleProviderAfterLogout$lambda$23(final Function0 function0) {
        AuthV4ProviderAdapter companion = AuthV4ProviderAdapter.INSTANCE.getInstance(AuthV4.ProviderType.GOOGLE);
        if (companion != null) {
            companion.logout(new AuthV4ProviderAdapter.ProviderLogoutListener() { // from class: com.hive.auth.AuthImpl$disconnectGoogleProviderAfterLogout$1$1
                @Override // com.hive.authv4.provider.AuthV4ProviderAdapter.ProviderLogoutListener
                public void onProviderLogoutListener(ResultAPI result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "[disconnectGoogleProviderAfterLogout] disconnect Google provider session");
                    SocialV4ProviderAdapter companion2 = SocialV4ProviderAdapter.INSTANCE.getInstance(SocialV4.ProviderType.GOOGLE);
                    if (companion2 != null) {
                        companion2.resetGoogleLoginType();
                    }
                    function0.invoke();
                }
            });
        } else {
            LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "[disconnectGoogleProviderAfterLogout] not exist Google provider session");
            function0.invoke();
        }
    }

    private final void executeModules() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i(AuthDataInterface.getTAG(), "executeModules");
        Property.Companion companion = Property.INSTANCE;
        Property instance = companion.getINSTANCE();
        AuthKeys authKeys = AuthKeys.INSTANCE;
        if (!Intrinsics.areEqual(instance.getValue(authKeys.getAGREEMENT_PRIVACY_STATE()), authKeys.getAGREEMENT_PRIVACY_VALUE_HOLD())) {
            loggerImpl.i(AuthDataInterface.getTAG(), "executeModules, set agreement privacy : completed");
            Property.setValue$default(companion.getINSTANCE(), authKeys.getAGREEMENT_PRIVACY_STATE(), authKeys.getAGREEMENT_PRIVACY_VALUE_COMPLETED(), null, 4, null);
            companion.getINSTANCE().writeProperties();
        }
        AfterAgreementListener internalAfterAgreementListener$hive_service_release = getInternalAfterAgreementListener$hive_service_release();
        if (internalAfterAgreementListener$hive_service_release != null) {
            internalAfterAgreementListener$hive_service_release.onAgreementUIFinish(0, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getAgreementVersionWithCountry(String countryCode) {
        String value = Property.INSTANCE.getINSTANCE().getValue(AuthKeys.INSTANCE.getAGREEMENT_COUNTRY_VERSION_WITH_VID());
        if (value == null) {
            return -1;
        }
        try {
            JSONObject jSONObject = new JSONObject(value);
            if (jSONObject.has(countryCode)) {
                return jSONObject.getJSONObject(countryCode).getInt("version");
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private final void ignoreAgreementShowing(GetAgreement.GetAgreementResponse responseGetAgreementData, boolean needToSave) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i(AuthDataInterface.getTAG(), "ignoreAgreementShowing");
        if (needToSave && responseGetAgreementData != null) {
            INSTANCE.setAgreementCountryAndVersionInfo(ConfigurationImpl.INSTANCE.getHiveCountry(), responseGetAgreementData.getAgreement_version());
        }
        Property.Companion companion = Property.INSTANCE;
        Property instance = companion.getINSTANCE();
        AuthKeys authKeys = AuthKeys.INSTANCE;
        if (Intrinsics.areEqual(instance.getValue(authKeys.getAGREEMENT_LOG_PROPERTY()), authKeys.getAGREEMENT_LOG_VALUE_HOLD())) {
            loggerImpl.i(AuthDataInterface.getTAG(), "ignoreAgreementShowing, reset agreement log");
            Property.setValue$default(companion.getINSTANCE(), authKeys.getAGREEMENT_LOG_PROPERTY(), "", null, 4, null);
            companion.getINSTANCE().writeProperties();
        }
        executeModules();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object initializeSettings(AuthDataInterface.AuthInitializeListener authInitializeListener, HiveUserEngagement.UserEngagementListener userEngagementListener, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(defaultDispatcher, new C28052(userEngagementListener, authInitializeListener, null), continuation);
    }

    private final void internalAccountLogin(final String fApiName, final AuthDataInterface.AuthLoginListener listener) {
        LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "[Login] [internalAccountLogin]");
        final Intent intent = new Intent();
        String value = Property.INSTANCE.getINSTANCE().getValue(AuthKeys.ACCOUNT_SESSION_KEY);
        if (!SocialHiveImpl.INSTANCE.getAuthDialogClear() && (value == null || StringsKt.isBlank(value))) {
            intent.putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, true);
        }
        HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), intent, new OnActivityLifecycle() { // from class: com.hive.auth.AuthImpl.internalAccountLogin.1
            public SocialDialog socialDialog;

            public final SocialDialog getSocialDialog() {
                SocialDialog socialDialog = this.socialDialog;
                if (socialDialog != null) {
                    return socialDialog;
                }
                Intrinsics.throwUninitializedPropertyAccessException("socialDialog");
                return null;
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public boolean onBackPressed() {
                return getSocialDialog().onBackPressed();
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onCreate(Activity activity, Bundle savedInstanceState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                super.onCreate(activity, savedInstanceState);
                setSocialDialog(SocialDialog.INSTANCE.loginHive(activity, SocialHiveImpl.INSTANCE.getAuthDialogClear(), new AuthImpl$internalAccountLogin$1$onCreate$1(fApiName, listener, activity, intent)));
                getSocialDialog().show();
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onDestroy(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (!getIsCalledFinish()) {
                    getSocialDialog().dismiss();
                }
                super.onDestroy(activity);
            }

            public final void setSocialDialog(SocialDialog socialDialog) {
                Intrinsics.checkNotNullParameter(socialDialog, "<set-?>");
                this.socialDialog = socialDialog;
            }
        });
    }

    private final void internalGuestLogin(final String fApiName, final AuthDataInterface.AuthLoginListener listener) {
        LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "[Login] [internalGuestLogin]");
        Crypto crypto = Crypto.INSTANCE;
        final String strGenerateCodeVerifier = crypto.generateCodeVerifier();
        AuthNetwork.LoginCenter.INSTANCE.guestLogin(crypto.generateCodeChallenge(strGenerateCodeVerifier)).request(new Function1() { // from class: com.hive.auth.AuthImpl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AuthImpl.internalGuestLogin$lambda$18(fApiName, listener, strGenerateCodeVerifier, (GuestLogin) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit internalGuestLogin$lambda$18(final String str, final AuthDataInterface.AuthLoginListener authLoginListener, String str2, final GuestLogin it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResponse().getResult().isSuccess()) {
            final String did = HiveLifecycle.INSTANCE.getDid();
            if (it.getResponse().isSuccess()) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AuthImpl$internalGuestLogin$1$1(it, str2, did, str, authLoginListener, null), 3, null);
            } else if (it.getResponse().getErrno() == 10) {
                Property.Companion companion = Property.INSTANCE;
                Property.setValue$default(companion.getINSTANCE(), AuthKeys.GUEST_VID, "", null, 4, null);
                Property.setValue$default(companion.getINSTANCE(), AuthKeys.INSTANCE.getGUEST_VID_TYPE(), "", null, 4, null);
                Property.setValue$default(companion.getINSTANCE(), AuthKeys.GUEST_SESSION_KEY, "", null, 4, null);
                companion.getINSTANCE().writeProperties();
                LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[Login] [internalGuestLogin] invalid session");
                loginType = AuthDataInterface.LoginType.ACCOUNT;
                AuthImpl authImpl = INSTANCE;
                authImpl.setCurrentAccount(new AuthDataInterface.Account(it.getResponse().getGuestVid(), null, did, null));
                isLoginInProgress = false;
                authImpl.onLoginFinish(new ResultAPI(-9, ResultAPI.Code.AuthInvalidGuestSession, "[Login] [internalGuestLogin] invalid session"), AuthDataInterface.LoginType.GUEST, currentAccount, null, str, authLoginListener);
            } else if (it.getResponse().getErrno() == 2000) {
                final String str3 = "[Login] [internalGuestLogin] black list user : " + it.getResponse().getBlock_message();
                LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), str3);
                int block_action = it.getResponse().getBlock_action();
                final MaintenanceDialog.MaintenanceModel maintenanceModel = new MaintenanceDialog.MaintenanceModel(it.getResponse().getBlock_title(), it.getResponse().getBlock_message(), it.getResponse().getBlock_html_message(), it.getResponse().getBlock_button(), block_action != 1 ? block_action != 2 ? MaintenanceDialog.MaintenanceActionType.DONE : MaintenanceDialog.MaintenanceActionType.DONE : MaintenanceDialog.MaintenanceActionType.EXIT, "", -1, it.getResponse().getBlock_customerButton(), it.getResponse().getBlock_customerLink(), null, null, null, MaintenanceDialog.MaintenanceDialogType.BLACKLIST, 3584, null);
                HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new OnActivityLifecycle() { // from class: com.hive.auth.AuthImpl$internalGuestLogin$1$2
                    public MaintenanceDialog dialog;

                    public final MaintenanceDialog getDialog() {
                        MaintenanceDialog maintenanceDialog = this.dialog;
                        if (maintenanceDialog != null) {
                            return maintenanceDialog;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("dialog");
                        return null;
                    }

                    @Override // com.hive.ui.OnActivityLifecycle
                    public void onConfigurationChanged(Activity activity, android.content.res.Configuration newConfig) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
                        super.onConfigurationChanged(activity, newConfig);
                        getDialog().onConfigurationChanged(activity, newConfig);
                    }

                    @Override // com.hive.ui.OnActivityLifecycle
                    public void onCreate(final Activity activity, Bundle savedInstanceState) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                        super.onCreate(activity, savedInstanceState);
                        MaintenanceDialog.MaintenanceModel maintenanceModel2 = maintenanceModel;
                        final GuestLogin guestLogin = it;
                        final String str4 = did;
                        final String str5 = str3;
                        final String str6 = str;
                        final AuthDataInterface.AuthLoginListener authLoginListener2 = authLoginListener;
                        setDialog(new MaintenanceDialog(activity, maintenanceModel2, new MaintenanceDialog.OnDismissListener() { // from class: com.hive.auth.AuthImpl$internalGuestLogin$1$2$onCreate$1

                            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                            public /* synthetic */ class WhenMappings {
                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                static {
                                    int[] iArr = new int[MaintenanceDialog.MaintenanceActionType.values().length];
                                    try {
                                        iArr[MaintenanceDialog.MaintenanceActionType.TIMEOVER.ordinal()] = 1;
                                    } catch (NoSuchFieldError unused) {
                                    }
                                    try {
                                        iArr[MaintenanceDialog.MaintenanceActionType.OPEN_URL.ordinal()] = 2;
                                    } catch (NoSuchFieldError unused2) {
                                    }
                                    try {
                                        iArr[MaintenanceDialog.MaintenanceActionType.EXIT.ordinal()] = 3;
                                    } catch (NoSuchFieldError unused3) {
                                    }
                                    try {
                                        iArr[MaintenanceDialog.MaintenanceActionType.DONE.ordinal()] = 4;
                                    } catch (NoSuchFieldError unused4) {
                                    }
                                    $EnumSwitchMapping$0 = iArr;
                                }
                            }

                            @Override // android.content.DialogInterface.OnDismissListener
                            public void onDismiss(DialogInterface dialog) {
                                Intrinsics.checkNotNullParameter(dialog, "dialog");
                                AuthImpl authImpl2 = AuthImpl.INSTANCE;
                                AuthImpl.loginType = AuthDataInterface.LoginType.AUTO;
                                AuthImpl authImpl3 = AuthImpl.INSTANCE;
                                authImpl3.setCurrentAccount(new AuthDataInterface.Account(guestLogin.getResponse().getGuestVid(), null, str4, guestLogin.getResponse().getGuestSessionkey()));
                                AuthImpl.isLoginInProgress = false;
                                activity.finish();
                                authImpl3.onLoginFinish(new ResultAPI(-8, ResultAPI.Code.AuthUserInBlacklist, str5), AuthDataInterface.LoginType.GUEST, AuthImpl.currentAccount, null, str6, authLoginListener2);
                            }

                            @Override // com.hive.auth.MaintenanceDialog.OnDismissListener
                            public void onDismissWithButtonAction(DialogInterface dialog, MaintenanceDialog.MaintenanceActionType buttonAction) {
                                Intrinsics.checkNotNullParameter(dialog, "dialog");
                                Intrinsics.checkNotNullParameter(buttonAction, "buttonAction");
                                AuthImpl.isLoginInProgress = false;
                                activity.finish();
                                int i = WhenMappings.$EnumSwitchMapping$0[buttonAction.ordinal()];
                                AuthImpl.INSTANCE.onLoginFail(i != 1 ? i != 2 ? i != 3 ? i != 4 ? new ResultAPI(-17, ResultAPI.Code.AuthUserInBlacklistActionDefault_DoExit, str5) : new ResultAPI(0, ResultAPI.Code.AuthUserInBlacklistActionDone, str5) : new ResultAPI(-17, ResultAPI.Code.AuthUserInBlacklistActionExit_DoExit, str5) : new ResultAPI(-17, ResultAPI.Code.AuthUserInBlacklistActionOpenURL_DoExit, str5) : new ResultAPI(-17, ResultAPI.Code.AuthUserInBlacklistTimeover_DoExit, str5), AuthDataInterface.LoginType.GUEST, str6, authLoginListener2);
                            }
                        }));
                        getDialog().show();
                    }

                    @Override // com.hive.ui.OnActivityLifecycle
                    public void onDestroy(Activity activity) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                        if (!getIsCalledFinish()) {
                            getDialog().dismiss();
                        }
                        super.onDestroy(activity);
                    }

                    public final void setDialog(MaintenanceDialog maintenanceDialog) {
                        Intrinsics.checkNotNullParameter(maintenanceDialog, "<set-?>");
                        this.dialog = maintenanceDialog;
                    }
                });
            } else {
                LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[Login] [internalGuestLogin] guest login developer error.");
                isLoginInProgress = false;
                INSTANCE.onLoginFinish(new ResultAPI(-8, ResultAPI.Code.AuthServerResponseNotSuccessful, "[Login] [internalGuestLogin] guest login developer error."), AuthDataInterface.LoginType.GUEST, null, null, str, authLoginListener);
            }
        } else {
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[Login] [internalGuestLogin] network error.");
            isLoginInProgress = false;
            INSTANCE.onLoginFinish(new ResultAPI(-5, ResultAPI.Code.AuthNetworkErrorGuestLogin, "[Login] [internalGuestLogin] network error."), AuthDataInterface.LoginType.GUEST, null, null, str, authLoginListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCheckedAgreement() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d(AuthDataInterface.getTAG(), "isCheckedAgreement");
        Property instance = Property.INSTANCE.getINSTANCE();
        AuthKeys authKeys = AuthKeys.INSTANCE;
        String value = instance.getValue(authKeys.getAGREEMENT_PRIVACY_STATE());
        if (value == null || !Intrinsics.areEqual(value, authKeys.getAGREEMENT_PRIVACY_VALUE_COMPLETED())) {
            return false;
        }
        loggerImpl.d(AuthDataInterface.getTAG(), "user already saw agreement (agreementSavedState)");
        return true;
    }

    private final boolean isNeedToSendLogWithVid(String vid) {
        String upperCase;
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i(AuthDataInterface.getTAG(), "isNeedToSendLogWithVid");
        String hiveCountry = ConfigurationImpl.INSTANCE.getHiveCountry();
        if (hiveCountry != null) {
            upperCase = hiveCountry.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        } else {
            upperCase = null;
        }
        String value = Property.INSTANCE.getINSTANCE().getValue(AuthKeys.INSTANCE.getAGREEMENT_COUNTRY_VERSION_WITH_VID());
        if (upperCase == null || value == null || !(!StringsKt.isBlank(value))) {
            loggerImpl.i(AuthDataInterface.getTAG(), "isNeedToSendLogWithVid, not need to process");
            return false;
        }
        try {
            loggerImpl.i(AuthDataInterface.getTAG(), "isNeedToSendLogWithVid, need to process");
            JSONArray jSONArray = new JSONObject(value).getJSONObject(upperCase).getJSONArray("vid");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (Intrinsics.areEqual(jSONArray.getString(i), vid)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "isNeedToSendLogWithVid, exception : " + e);
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit logout$lambda$21(final String str, final AuthDataInterface.AuthLogoutListener authLogoutListener, Logout it) {
        String uid;
        Intrinsics.checkNotNullParameter(it, "it");
        Property.Companion companion = Property.INSTANCE;
        Property.setValue$default(companion.getINSTANCE(), AuthKeys.GUEST_VID, "", null, 4, null);
        Property instance = companion.getINSTANCE();
        AuthKeys authKeys = AuthKeys.INSTANCE;
        Property.setValue$default(instance, authKeys.getGUEST_VID_TYPE(), "", null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), AuthKeys.GUEST_SESSION_KEY, "", null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), AuthKeys.ACCOUNT_VID, "", null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), authKeys.getACCOUNT_VID_TYPE(), "", null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), AuthKeys.ACCOUNT_SESSION_KEY, "", null, 4, null);
        companion.getINSTANCE().writeProperties();
        AuthAccount.INSTANCE.removeToken();
        AuthDataInterface.Account account = currentAccount;
        if (account == null || (uid = account.getUid()) == null || !(!StringsKt.isBlank(uid))) {
            AuthImpl authImpl = INSTANCE;
            authImpl.setCurrentAccount(null);
            loginType = AuthDataInterface.LoginType.ACCOUNT;
            authImpl.onLogoutFinish(new ResultAPI(0, ResultAPI.Code.Success, "[logout] success"), str, authLogoutListener);
        } else {
            HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new Intent(), new OnActivityLifecycle() { // from class: com.hive.auth.AuthImpl$logout$1$1$1
                public SocialDialog socialDialog;

                public final SocialDialog getSocialDialog() {
                    SocialDialog socialDialog = this.socialDialog;
                    if (socialDialog != null) {
                        return socialDialog;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("socialDialog");
                    return null;
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public boolean onBackPressed() {
                    return getSocialDialog().onBackPressed();
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onCreate(Activity activity, Bundle savedInstanceState) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    super.onCreate(activity, savedInstanceState);
                    setSocialDialog(SocialDialog.INSTANCE.logoutHive(activity, new AuthImpl$logout$1$1$1$onCreate$1(activity, str, authLogoutListener)));
                    getSocialDialog().show();
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onDestroy(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    if (!getIsCalledFinish()) {
                        getSocialDialog().dismiss();
                    }
                    super.onDestroy(activity);
                }

                public final void setSocialDialog(SocialDialog socialDialog) {
                    Intrinsics.checkNotNullParameter(socialDialog, "<set-?>");
                    this.socialDialog = socialDialog;
                }
            });
        }
        return Unit.INSTANCE;
    }

    private final void needAgreementShowing(final GetAgreement.GetAgreementResponse responseGetAgreementData) {
        Property.Companion companion = Property.INSTANCE;
        Property instance = companion.getINSTANCE();
        AuthKeys authKeys = AuthKeys.INSTANCE;
        Property.setValue$default(instance, authKeys.getAGREEMENT_LOG_PROPERTY(), authKeys.getAGREEMENT_LOG_VALUE_SENDING(), null, 4, null);
        companion.getINSTANCE().writeProperties();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.AuthImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AuthImpl.needAgreementShowing$lambda$3(responseGetAgreementData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void needAgreementShowing$lambda$3(GetAgreement.GetAgreementResponse getAgreementResponse) {
        if (getAgreementResponse != null) {
            if (!ConfigurationImpl.INSTANCE.getAuthV1Agreement()) {
                LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[needAgreementShowing] set auth v4 style agreement");
                INSTANCE.processAgreementShowing(getAgreementResponse);
                return;
            }
            LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[needAgreementShowing] set auth v1 style agreement");
            Intent intent = new Intent(Configuration.getContext(), (Class<?>) UserAgreeDialog.class);
            intent.putExtra("agreement_version", getAgreementResponse.getAgreement_version());
            intent.putExtra("url", getAgreementResponse.getAgreement_url());
            intent.putExtra("agreement_ex_url", getAgreementResponse.getAgreement_ex_url());
            ExtentionsKt.startActivityCatching$default(Configuration.getContext(), intent, null, 2, null);
        }
    }

    private final void onAgreementFinish() {
        HiveLifecycle.INSTANCE.onAgreement();
        AfterAgreementListener internalAfterAgreementListener$hive_service_release = getInternalAfterAgreementListener$hive_service_release();
        if (internalAfterAgreementListener$hive_service_release != null) {
            internalAfterAgreementListener$hive_service_release.onAgreementUIFinish(0, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAgreementUiResult(ArrayList<AuthV4Impl.Agreement> agreementList) {
        AuthV4Impl.Agreement agreement;
        String str;
        String str2;
        byte[] base64Decode$default;
        if (agreementList != null && agreementList.size() == 1 && (agreement = agreementList.get(0)) != null) {
            Map<String, String> parameter = agreement.getParameter();
            JSONObject jSONObject = null;
            if (parameter != null) {
                str = !TextUtils.isEmpty(parameter.get("agreement")) ? "agreement" : !TextUtils.isEmpty(parameter.get("agreement_ex")) ? "agreement_ex" : null;
            } else {
                parameter = null;
                str = null;
            }
            if (TextUtils.equals("agreement", str)) {
                Property.Companion companion = Property.INSTANCE;
                Property instance = companion.getINSTANCE();
                AuthKeys authKeys = AuthKeys.INSTANCE;
                Property.setValue$default(instance, authKeys.getAGREEMENT_VERSION(), String.valueOf(agreement.getVersion()), null, 4, null);
                Property.setValue$default(companion.getINSTANCE(), authKeys.getAGREEMENT_SCHEME_DATA(), agreement.getScheme(), null, 4, null);
                Property.setValue$default(companion.getINSTANCE(), authKeys.getAGREEMENT_PRIVACY_STATE(), authKeys.getAGREEMENT_PRIVACY_VALUE_AGREE(), null, 4, null);
                Property.setValue$default(companion.getINSTANCE(), authKeys.getAGREEMENT_AGREED_EVER(), "true", null, 4, null);
                companion.getINSTANCE().writeProperties();
                if (parameter != null && (str2 = parameter.get(str)) != null) {
                    Charset charset = Charsets.UTF_8;
                    byte[] bytes = str2.getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                    if (bytes != null && (base64Decode$default = StringUtil.toBase64Decode$default(StringUtil.INSTANCE, bytes, 0, 1, null)) != null) {
                        try {
                            JSONObject jSONObjectOptJSONObject = new JSONObject(new String(base64Decode$default, charset)).optJSONObject("item");
                            if (jSONObjectOptJSONObject != null) {
                                if (jSONObjectOptJSONObject.has(Constants.PUSH)) {
                                    PushImpl.INSTANCE.onAgreement(true, new Push.RemotePush(jSONObjectOptJSONObject.optBoolean(Constants.PUSH, false), jSONObjectOptJSONObject.optBoolean("night_push", false)));
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                        } catch (Exception unused) {
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                }
            } else if (TextUtils.equals("agreement_ex", str) && parameter != null) {
                try {
                    byte[] bArrDecode = Base64.decode(URLDecoder.decode(parameter.get(str), "UTF-8"), 4);
                    Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
                    jSONObject = new JSONObject(new String(bArrDecode, Charsets.UTF_8));
                } catch (Exception unused2) {
                }
                if (jSONObject != null) {
                    int iOptInt = jSONObject.optInt("sms");
                    Property.Companion companion2 = Property.INSTANCE;
                    Property instance2 = companion2.getINSTANCE();
                    AuthKeys authKeys2 = AuthKeys.INSTANCE;
                    Property.setValue$default(instance2, authKeys2.getAGREEMENT_EX_STATE(), iOptInt == 1 ? "1" : iOptInt == 0 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AbstractJsonLexerKt.NULL, null, 4, null);
                    Property.setValue$default(companion2.getINSTANCE(), authKeys2.getAGREEMENT_EX_SCHEME_DATA(), agreement.getUrl(), null, 4, null);
                } else {
                    Property.setValue$default(Property.INSTANCE.getINSTANCE(), AuthKeys.INSTANCE.getAGREEMENT_EX_STATE(), AbstractJsonLexerKt.NULL, null, 4, null);
                }
                Property.Companion companion3 = Property.INSTANCE;
                Property.setValue$default(companion3.getINSTANCE(), AuthKeys.INSTANCE.getAGREEMENT_AGREED_EVER(), "true", null, 4, null);
                companion3.getINSTANCE().writeProperties();
            }
        }
        onAgreementFinish();
    }

    public static /* synthetic */ boolean onC2SModuleLogin$default(AuthImpl authImpl, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return authImpl.onC2SModuleLogin(str, str2, z);
    }

    private final void onEmergencyMode(boolean isC2SModule) {
        LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "Did call onEmergencyMode");
        isEmergencyMode = true;
        AuthDataInterface.Account account = currentAccount;
        if (account != null) {
            HiveLifecycle.INSTANCE.onSignIn(account);
        }
    }

    public static /* synthetic */ void onEmergencyMode$default(AuthImpl authImpl, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        authImpl.onEmergencyMode(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onInitializeFail(final ResultAPI resultAPI) {
        printLogRefSDKVersion();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.AuthImpl$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                AuthImpl.onInitializeFail$lambda$40(resultAPI);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitializeFail$lambda$40(ResultAPI resultAPI) {
        AuthDataInterface.AuthInitializeListener authInitializeListener = internalAuthInitializeListener;
        if (authInitializeListener != null) {
            authInitializeListener.onAuthInitialize(resultAPI, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onInitializeSuccess(AuthDataInterface.AuthInitResult authInitResult, boolean isSdkV1) {
        printLogRefSDKVersion();
        INSTANCE.setAgreementCountryAndVersionInfo(ConfigurationImpl.INSTANCE.getHiveCountry(), checkedAgreementVersion);
        loginType = authInitResult.getLoginType();
        isInitialize = true;
        Property.Companion companion = Property.INSTANCE;
        if (companion.getINSTANCE().getValue("FirstInit", "").length() == 0) {
            Property.setValue$default(companion.getINSTANCE(), "FirstInit", "True", null, 4, null);
        } else {
            Property.setValue$default(companion.getINSTANCE(), "FirstInit", "False", null, 4, null);
        }
        companion.getINSTANCE().writeProperties();
        HiveLifecycle.INSTANCE.onInitializeFinished(isSdkV1);
        AuthDataInterface.AuthInitializeListener authInitializeListener = internalAuthInitializeListener;
        if (authInitializeListener != null) {
            authInitializeListener.onAuthInitialize(new ResultAPI(), authInitResult);
        }
    }

    public static /* synthetic */ void onInitializeSuccess$default(AuthImpl authImpl, AuthDataInterface.AuthInitResult authInitResult, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        authImpl.onInitializeSuccess(authInitResult, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLoginFail(final ResultAPI result, final AuthDataInterface.LoginType loginType2, final String fApiName, final AuthDataInterface.AuthLoginListener listener) {
        LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[AuthImpl] onLoginFail : " + result);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.AuthImpl$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                AuthImpl.onLoginFail$lambda$47(fApiName, result, listener, loginType2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLoginFail$lambda$47(String str, ResultAPI resultAPI, AuthDataInterface.AuthLoginListener authLoginListener, AuthDataInterface.LoginType loginType2) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthDataInterface.getTAG(), str, resultAPI.toString());
        authLoginListener.onAuthLogin(resultAPI, loginType2, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLoginFinish(final ResultAPI result, final AuthDataInterface.LoginType loginType2, final AuthDataInterface.Account currentAccount2, final AuthDataInterface.Account usedAccount, final String fApiName, final AuthDataInterface.AuthLoginListener listener) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.w(AuthDataInterface.getTAG(), "[AuthImpl] onLoginFinish : " + result);
        printLogRefSDKVersion();
        if (!result.isSuccess() || currentAccount2 == null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.AuthImpl$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    AuthImpl.onLoginFinish$lambda$46(fApiName, result, listener, loginType2, currentAccount2, usedAccount);
                }
            });
            return;
        }
        currentAccount2.setVidType(i.f2373a);
        currentAccount2.setUidSession(Property.INSTANCE.getINSTANCE().getValue(SocialKeys.INSTANCE.getUID_SESSION_TOKEN(), ""));
        String vid = currentAccount2.getVid();
        if (vid != null) {
            INSTANCE.sendAgreementLogWithVid(vid);
        }
        if (result.getCode() != ResultAPI.Code.RefundUser) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.AuthImpl$$ExternalSyntheticLambda18
                @Override // java.lang.Runnable
                public final void run() {
                    AuthImpl.onLoginFinish$lambda$45(currentAccount2, fApiName, result, listener, loginType2, usedAccount);
                }
            });
            return;
        }
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = Repayment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof Repayment)) {
            hiveModule = null;
        }
        if (!(hiveModule instanceof Repayment)) {
            hiveModule = null;
        }
        Repayment repayment = (Repayment) hiveModule;
        if (repayment != null) {
            repayment.showRepayment(HiveActivity.INSTANCE.getRecentActivity(), currentAccount2, new Function0() { // from class: com.hive.auth.AuthImpl$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AuthImpl.onLoginFinish$lambda$43(loginType2, listener);
                }
            });
            return;
        }
        ResultAPI resultAPI = new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIapV4:Repayment");
        loggerImpl.apiCallbackLog(AuthDataInterface.getTAG(), fApiName, resultAPI.toString());
        if (listener != null) {
            listener.onAuthLogin(resultAPI, loginType2, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onLoginFinish$lambda$43(AuthDataInterface.LoginType loginType2, AuthDataInterface.AuthLoginListener authLoginListener) {
        INSTANCE.login(loginType2, authLoginListener);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLoginFinish$lambda$45(AuthDataInterface.Account account, String str, ResultAPI resultAPI, AuthDataInterface.AuthLoginListener authLoginListener, AuthDataInterface.LoginType loginType2, AuthDataInterface.Account account2) {
        HiveLifecycle.INSTANCE.onSignIn(account);
        LoggerImpl.INSTANCE.apiCallbackLog(AuthDataInterface.getTAG(), str, resultAPI.toString());
        if (authLoginListener != null) {
            authLoginListener.onAuthLogin(resultAPI, loginType2, account, account2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLoginFinish$lambda$46(String str, ResultAPI resultAPI, AuthDataInterface.AuthLoginListener authLoginListener, AuthDataInterface.LoginType loginType2, AuthDataInterface.Account account, AuthDataInterface.Account account2) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthDataInterface.getTAG(), str, resultAPI.toString());
        if (authLoginListener != null) {
            authLoginListener.onAuthLogin(resultAPI, loginType2, account, account2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLogoutFinish(final ResultAPI result, final String fApiName, final AuthDataInterface.AuthLogoutListener listener) {
        if (result.isSuccess()) {
            HiveLifecycle.INSTANCE.onSignOut();
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.AuthImpl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AuthImpl.onLogoutFinish$lambda$48(fApiName, result, listener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLogoutFinish$lambda$48(String str, ResultAPI resultAPI, AuthDataInterface.AuthLogoutListener authLogoutListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthDataInterface.getTAG(), str, resultAPI.toString());
        if (authLogoutListener != null) {
            authLogoutListener.onAuthLogout(resultAPI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pgsLoginProc() {
        LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "pgsLoginProc");
        processLoginType(false, null, null);
    }

    private final void printLogRefSDKVersion() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C28071(null), 3, null);
    }

    private final void processAgreementShowing(GetAgreement.GetAgreementResponse responseGetAgreementData) {
        String scheme;
        String url;
        boolean zOptBoolean;
        AuthV4Impl.Agreement.ViewMode viewMode;
        String strOptString;
        LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "[processAgreementShowing]");
        AnalyticsImpl.INSTANCE.sendUserEntryFunnelsLogs(AnalyticsImpl.FunnelsTrack.NOTICE_POPUP);
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("show", responseGetAgreementData.getAgreement_show() == 1);
            jSONObject.put("view_mode", "require");
            jSONObject.put("type", responseGetAgreementData.getTypeTerms() ? "terms" : "sms");
            jSONObject.put("scheme", responseGetAgreementData.getAgreement_scheme());
            jSONObject.put("terms_id", "");
            jSONObject.put("version", String.valueOf(responseGetAgreementData.getAgreement_version()));
            jSONObject.put("template", "");
            jSONObject.put("url", responseGetAgreementData.getAgreement_url());
            jSONObject.put("review_url", responseGetAgreementData.getAgreement_review_url());
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("[processAgreementShowing] agreementJson put exception: " + e);
        }
        AuthV4Impl.Agreement.ViewMode.Companion companion = AuthV4Impl.Agreement.ViewMode.INSTANCE;
        try {
            zOptBoolean = jSONObject.optBoolean("show");
            AuthV4Impl.Agreement.ViewMode viewMode2 = AuthV4Impl.Agreement.ViewMode.INSTANCE.getViewMode(jSONObject.optString("view_mode"));
            if (viewMode2 == null) {
                viewMode2 = AuthV4Impl.Agreement.ViewMode.OPTION;
            }
            viewMode = viewMode2;
            strOptString = jSONObject.optString("type");
        } catch (Exception e2) {
            LoggerImpl.INSTANCE.w("[processAgreementShowing] ResponseGetAgreementData agreement data exception: " + e2);
        }
        if (strOptString == null || StringsKt.isBlank(strOptString)) {
            throw new Exception("invalid agreement type: " + strOptString);
        }
        arrayList.add(new AuthV4Impl.Agreement("", responseGetAgreementData.getHive_country(), zOptBoolean, viewMode, strOptString, jSONObject.optString("url"), jSONObject.optString("group_code"), jSONObject.optInt("version", -1), jSONObject.optString("review_url"), jSONObject.optString("scheme"), null));
        if (arrayList.isEmpty()) {
            onAgreementFinish();
            return;
        }
        final ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            AuthV4Impl.Agreement agreement = (AuthV4Impl.Agreement) next;
            if ((agreement.getShow() && (url = agreement.getUrl()) != null && (!StringsKt.isBlank(url))) || ((scheme = agreement.getScheme()) != null && (!StringsKt.isBlank(scheme)))) {
                arrayList2.add(agreement);
            }
        }
        if (arrayList2.isEmpty()) {
            onAgreementFinish();
        } else {
            HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new OnActivityLifecycle() { // from class: com.hive.auth.AuthImpl.processAgreementShowing.1
                public AuthV4AgreementView authV4AgreementView;

                public final AuthV4AgreementView getAuthV4AgreementView() {
                    AuthV4AgreementView authV4AgreementView = this.authV4AgreementView;
                    if (authV4AgreementView != null) {
                        return authV4AgreementView;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("authV4AgreementView");
                    return null;
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public boolean onBackPressed() {
                    return getAuthV4AgreementView().onBackPressed();
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onCreate(final Activity activity, Bundle savedInstanceState) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    super.onCreate(activity, savedInstanceState);
                    setAuthV4AgreementView(new AuthV4AgreementView(activity, arrayList2, new AuthV4AgreementView.AuthV4AgreementDialogListener() { // from class: com.hive.auth.AuthImpl$processAgreementShowing$1$onCreate$1
                        @Override // com.hive.authv4.webviewflow.AuthV4AgreementView.AuthV4AgreementDialogListener
                        public void onAgreementDeny(ResultAPI resultAPI) {
                            Intrinsics.checkNotNullParameter(resultAPI, "resultAPI");
                            AuthImpl.AfterAgreementListener internalAfterAgreementListener$hive_service_release = AuthImpl.INSTANCE.getInternalAfterAgreementListener$hive_service_release();
                            if (internalAfterAgreementListener$hive_service_release != null) {
                                internalAfterAgreementListener$hive_service_release.onAgreementUIFinish(0, false);
                            }
                            activity.finish();
                        }

                        @Override // com.hive.authv4.webviewflow.AuthV4AgreementView.AuthV4AgreementDialogListener
                        public void onAgreementFinish(ArrayList<AuthV4Impl.Agreement> agreementList, String jsMessage) {
                            Intrinsics.checkNotNullParameter(agreementList, "agreementList");
                            Intrinsics.checkNotNullParameter(jsMessage, "jsMessage");
                            AuthImpl authImpl = AuthImpl.INSTANCE;
                            authImpl.onAgreementUiResult(agreementList);
                            AuthImpl.UserAgreeListener userAgreeListener2 = authImpl.getUserAgreeListener();
                            if (userAgreeListener2 != null) {
                                userAgreeListener2.onUserAgreeResult(1000);
                            }
                            activity.finish();
                        }
                    }));
                    getAuthV4AgreementView().show();
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onDestroy(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    if (!getIsCalledFinish()) {
                        getAuthV4AgreementView().dismiss();
                    }
                    super.onDestroy(activity);
                }

                public final void setAuthV4AgreementView(AuthV4AgreementView authV4AgreementView) {
                    Intrinsics.checkNotNullParameter(authV4AgreementView, "<set-?>");
                    this.authV4AgreementView = authV4AgreementView;
                }
            });
        }
    }

    private final void processGetAgreementResponseError() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i(AuthDataInterface.getTAG(), "processGetAgreementResponseError");
        Property.Companion companion = Property.INSTANCE;
        Property instance = companion.getINSTANCE();
        AuthKeys authKeys = AuthKeys.INSTANCE;
        String value = instance.getValue(authKeys.getAGREEMENT_PRIVACY_STATE());
        String value2 = companion.getINSTANCE().getValue(authKeys.getAGREEMENT_LOG_PROPERTY());
        if (!Intrinsics.areEqual(value, authKeys.getAGREEMENT_PRIVACY_VALUE_COMPLETED())) {
            loggerImpl.i(AuthDataInterface.getTAG(), "processGetAgreementResponseError, set agreement privacy : hold");
            Property.setValue$default(companion.getINSTANCE(), authKeys.getAGREEMENT_PRIVACY_STATE(), authKeys.getAGREEMENT_PRIVACY_VALUE_HOLD(), null, 4, null);
            companion.getINSTANCE().writeProperties();
        }
        if (!Intrinsics.areEqual(value2, authKeys.getAGREEMENT_LOG_VALUE_COMPLETED())) {
            loggerImpl.i(AuthDataInterface.getTAG(), "processGetAgreementResponseError, set agreement log : hold");
            Property.setValue$default(companion.getINSTANCE(), authKeys.getAGREEMENT_LOG_PROPERTY(), authKeys.getAGREEMENT_LOG_VALUE_HOLD(), null, 4, null);
            companion.getINSTANCE().writeProperties();
        }
        executeModules();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void processLoginType(final boolean r12, final java.lang.String r13, final java.lang.String r14) {
        /*
            r11 = this;
            com.hive.logger.LoggerImpl r0 = com.hive.logger.LoggerImpl.INSTANCE
            java.lang.String r1 = com.hive.auth.AuthDataInterface.getTAG()
            java.lang.String r2 = "processLoginType"
            r0.i(r1, r2)
            com.hive.base.Property$Companion r1 = com.hive.base.Property.INSTANCE
            com.hive.base.Property r2 = r1.getINSTANCE()
            java.lang.String r3 = com.hive.auth.AuthKeys.IS_AUTHORIZED
            java.lang.String r4 = "false"
            java.lang.String r2 = r2.getValue(r3, r4)
            boolean r4 = java.lang.Boolean.parseBoolean(r2)
            com.hive.standalone.HiveLifecycle r2 = com.hive.standalone.HiveLifecycle.INSTANCE
            java.lang.String r6 = r2.getDid()
            com.hive.auth.AuthDataInterface$LoginType r2 = com.hive.auth.AuthDataInterface.LoginType.GUEST
            com.hive.base.Property r3 = r1.getINSTANCE()
            java.lang.String r5 = com.hive.auth.AuthKeys.GUEST_VID
            java.lang.String r3 = r3.getValue(r5)
            com.hive.base.Property r5 = r1.getINSTANCE()
            java.lang.String r7 = com.hive.auth.AuthKeys.ACCOUNT_VID
            java.lang.String r5 = r5.getValue(r7)
            if (r5 == 0) goto L41
            boolean r5 = kotlin.text.StringsKt.isBlank(r5)
            if (r5 == 0) goto L46
        L41:
            if (r3 == 0) goto L46
            kotlin.text.StringsKt.isBlank(r3)
        L46:
            com.hive.base.Property r3 = r1.getINSTANCE()
            java.lang.String r5 = com.hive.auth.AuthKeys.GUEST_SESSION_KEY
            java.lang.String r3 = r3.getValue(r5)
            com.hive.base.Property r1 = r1.getINSTANCE()
            java.lang.String r5 = com.hive.auth.AuthKeys.ACCOUNT_SESSION_KEY
            java.lang.String r1 = r1.getValue(r5)
            r10 = 0
            if (r1 == 0) goto L66
            boolean r5 = kotlin.text.StringsKt.isBlank(r1)
            if (r5 == 0) goto L64
            goto L66
        L64:
            r3 = r1
            goto L6f
        L66:
            if (r3 == 0) goto L6e
            boolean r1 = kotlin.text.StringsKt.isBlank(r3)
            if (r1 == 0) goto L6f
        L6e:
            r3 = r10
        L6f:
            if (r3 == 0) goto L7c
            boolean r1 = kotlin.text.StringsKt.isBlank(r3)
            r3 = 1
            r1 = r1 ^ r3
            if (r1 != r3) goto L7c
            com.hive.auth.AuthDataInterface$LoginType r1 = com.hive.auth.AuthDataInterface.LoginType.AUTO
            goto L80
        L7c:
            if (r12 == 0) goto L82
            com.hive.auth.AuthDataInterface$LoginType r1 = com.hive.auth.AuthDataInterface.LoginType.AUTO
        L80:
            r5 = r1
            goto L88
        L82:
            if (r4 == 0) goto L87
            com.hive.auth.AuthDataInterface$LoginType r1 = com.hive.auth.AuthDataInterface.LoginType.ACCOUNT
            goto L80
        L87:
            r5 = r2
        L88:
            if (r5 != r2) goto La7
            java.lang.String r1 = com.hive.auth.AuthDataInterface.getTAG()
            java.lang.String r2 = "[processLoginType] request LoginCenter - preLogin"
            r0.i(r1, r2)
            com.hive.auth.AuthNetwork$LoginCenter r0 = com.hive.auth.AuthNetwork.LoginCenter.INSTANCE
            com.hive.protocol.Protocol r0 = r0.preLogin()
            com.hive.auth.AuthImpl$$ExternalSyntheticLambda21 r1 = new com.hive.auth.AuthImpl$$ExternalSyntheticLambda21
            r3 = r1
            r5 = r6
            r6 = r12
            r7 = r14
            r8 = r13
            r3.<init>()
            r0.request(r1)
            return
        La7:
            com.hive.auth.AuthDataInterface$AuthInitResult r0 = new com.hive.auth.AuthDataInterface$AuthInitResult
            r3 = r0
            r7 = r12
            r8 = r14
            r9 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r12 = 0
            r13 = 2
            onInitializeSuccess$default(r11, r0, r12, r13, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.auth.AuthImpl.processLoginType(boolean, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processLoginType$lambda$16(boolean z, String str, boolean z2, String str2, String str3, PreLogin it) {
        boolean z3;
        AuthDataInterface.LoginType loginType2;
        Intrinsics.checkNotNullParameter(it, "it");
        if (!it.getResponse().getResult().isSuccess()) {
            INSTANCE.onInitializeFail(new ResultAPI(-98, ResultAPI.Code.AuthNetworkErrorProcessLoginType, ""));
            return Unit.INSTANCE;
        }
        AuthDataInterface.LoginType.Companion companion = AuthDataInterface.LoginType.INSTANCE;
        if (!it.getResponse().isSuccess() || StringsKt.isBlank(it.getResponse().getVid()) || StringsKt.isBlank(it.getResponse().getPlatform()) || StringsKt.isBlank(it.getResponse().getUid())) {
            AuthDataInterface.LoginType loginType3 = AuthDataInterface.LoginType.GUEST;
            z3 = z;
            loginType2 = loginType3;
            onInitializeSuccess$default(INSTANCE, new AuthDataInterface.AuthInitResult(z3, loginType2, str, z2, str2, str3), false, 2, null);
            return Unit.INSTANCE;
        }
        Property.Companion companion2 = Property.INSTANCE;
        Property.setValue$default(companion2.getINSTANCE(), AuthKeys.IS_AUTHORIZED, "true", null, 4, null);
        companion2.getINSTANCE().writeProperties();
        loginType2 = AuthDataInterface.LoginType.ACCOUNT;
        z3 = true;
        onInitializeSuccess$default(INSTANCE, new AuthDataInterface.AuthInitResult(z3, loginType2, str, z2, str2, str3), false, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processLoginTypeSDKV1$lambda$17(PreLoginListener preLoginListener, boolean z, String str, String str2, PreLogin it) {
        AuthDataInterface.LoginType loginType2;
        Intrinsics.checkNotNullParameter(it, "it");
        if (!it.getResponse().getResult().isSuccess()) {
            preLoginListener.onPreLoginFinish(new ResultAPI(-98, ResultAPI.Code.AuthNetworkErrorProcessLoginType, ""), null);
            return Unit.INSTANCE;
        }
        AuthDataInterface.LoginType.Companion companion = AuthDataInterface.LoginType.INSTANCE;
        if (!it.getResponse().isSuccess() || StringsKt.isBlank(it.getResponse().getVid()) || StringsKt.isBlank(it.getResponse().getPlatform()) || StringsKt.isBlank(it.getResponse().getUid())) {
            loginType2 = AuthDataInterface.LoginType.GUEST;
        } else {
            Property.Companion companion2 = Property.INSTANCE;
            Property.setValue$default(companion2.getINSTANCE(), AuthKeys.IS_AUTHORIZED, "true", null, 4, null);
            companion2.getINSTANCE().writeProperties();
            loginType2 = AuthDataInterface.LoginType.ACCOUNT;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vid", it.getResponse().getVid());
            jSONObject.put("uid", it.getResponse().getUid());
            jSONObject.put("platform", it.getResponse().getPlatform());
            jSONObject.put("loginType", loginType2.getValue());
            jSONObject.put("guestSession", str);
            jSONObject.put("authSession", str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        preLoginListener.onPreLoginFinish(new ResultAPI(0, ResultAPI.Code.Success, ""), jSONObject);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestDidAndSendAgreement(boolean z, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(defaultDispatcher, new C28092(z, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestGetAgreement(Continuation<? super GetAgreement.GetAgreementResponse> continuation) {
        return BuildersKt.withContext(ioDispatcher, new C28102(null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestGetWhiteListDomain(Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(ioDispatcher, new C28112(null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestPromotionDownloadInfo() {
        LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "requestPromotionDownloadInfo: request promotion download info, CPI]");
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = HivePromotion.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof HivePromotion)) {
            hiveModule = null;
        }
        if (!(hiveModule instanceof HivePromotion)) {
            hiveModule = null;
        }
        HivePromotion hivePromotion = (HivePromotion) hiveModule;
        if (hivePromotion != null) {
            HivePromotion.DefaultImpls.requestDownloadInfo$default(hivePromotion, i.f2373a, false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestUpdate$lambda$19(final String str, final AuthDataInterface.AuthLoginListener authLoginListener, String str2, final Update it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResponse().getResult().isSuccess()) {
            final String did = HiveLifecycle.INSTANCE.getDid();
            final String value = Property.INSTANCE.getINSTANCE().getValue(SocialKeys.INSTANCE.getUID(), "uid");
            if (it.getResponse().isSuccess()) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AuthImpl$requestUpdate$1$1(it, str2, value, did, str, authLoginListener, null), 3, null);
            } else if (it.getResponse().getErrno() == 2000) {
                final String str3 = "[Login] [selectLogin] black list user : " + it.getResponse().getBlock_message();
                LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), str3);
                int block_action = it.getResponse().getBlock_action();
                final MaintenanceDialog.MaintenanceModel maintenanceModel = new MaintenanceDialog.MaintenanceModel(it.getResponse().getBlock_title(), it.getResponse().getBlock_message(), it.getResponse().getBlock_html_message(), it.getResponse().getBlock_button(), block_action != 1 ? block_action != 2 ? MaintenanceDialog.MaintenanceActionType.DONE : MaintenanceDialog.MaintenanceActionType.DONE : MaintenanceDialog.MaintenanceActionType.EXIT, "", -1, it.getResponse().getBlock_customerButton(), it.getResponse().getBlock_customerLink(), null, null, null, MaintenanceDialog.MaintenanceDialogType.BLACKLIST, 3584, null);
                HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new OnActivityLifecycle() { // from class: com.hive.auth.AuthImpl$requestUpdate$1$2
                    public MaintenanceDialog dialog;

                    public final MaintenanceDialog getDialog() {
                        MaintenanceDialog maintenanceDialog = this.dialog;
                        if (maintenanceDialog != null) {
                            return maintenanceDialog;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("dialog");
                        return null;
                    }

                    @Override // com.hive.ui.OnActivityLifecycle
                    public void onConfigurationChanged(Activity activity, android.content.res.Configuration newConfig) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
                        super.onConfigurationChanged(activity, newConfig);
                        getDialog().onConfigurationChanged(activity, newConfig);
                    }

                    @Override // com.hive.ui.OnActivityLifecycle
                    public void onCreate(final Activity activity, Bundle savedInstanceState) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                        super.onCreate(activity, savedInstanceState);
                        MaintenanceDialog.MaintenanceModel maintenanceModel2 = maintenanceModel;
                        final Update update = it;
                        final String str4 = value;
                        final String str5 = did;
                        final String str6 = str3;
                        final String str7 = str;
                        final AuthDataInterface.AuthLoginListener authLoginListener2 = authLoginListener;
                        setDialog(new MaintenanceDialog(activity, maintenanceModel2, new MaintenanceDialog.OnDismissListener() { // from class: com.hive.auth.AuthImpl$requestUpdate$1$2$onCreate$1

                            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                            public /* synthetic */ class WhenMappings {
                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                static {
                                    int[] iArr = new int[MaintenanceDialog.MaintenanceActionType.values().length];
                                    try {
                                        iArr[MaintenanceDialog.MaintenanceActionType.TIMEOVER.ordinal()] = 1;
                                    } catch (NoSuchFieldError unused) {
                                    }
                                    try {
                                        iArr[MaintenanceDialog.MaintenanceActionType.OPEN_URL.ordinal()] = 2;
                                    } catch (NoSuchFieldError unused2) {
                                    }
                                    try {
                                        iArr[MaintenanceDialog.MaintenanceActionType.EXIT.ordinal()] = 3;
                                    } catch (NoSuchFieldError unused3) {
                                    }
                                    try {
                                        iArr[MaintenanceDialog.MaintenanceActionType.DONE.ordinal()] = 4;
                                    } catch (NoSuchFieldError unused4) {
                                    }
                                    $EnumSwitchMapping$0 = iArr;
                                }
                            }

                            @Override // android.content.DialogInterface.OnDismissListener
                            public void onDismiss(DialogInterface dialog) {
                                Intrinsics.checkNotNullParameter(dialog, "dialog");
                                AuthImpl authImpl = AuthImpl.INSTANCE;
                                AuthImpl.loginType = AuthDataInterface.LoginType.AUTO;
                                AuthImpl authImpl2 = AuthImpl.INSTANCE;
                                authImpl2.setCurrentAccount(new AuthDataInterface.Account(update.getResponse().getAccountVid(), str4, str5, update.getResponse().getAccountSessionkey()));
                                AuthImpl.isLoginInProgress = false;
                                activity.finish();
                                authImpl2.onLoginFinish(new ResultAPI(-8, ResultAPI.Code.AuthUserInBlacklist, str6), AuthDataInterface.LoginType.ACCOUNT, AuthImpl.currentAccount, null, str7, authLoginListener2);
                            }

                            @Override // com.hive.auth.MaintenanceDialog.OnDismissListener
                            public void onDismissWithButtonAction(DialogInterface dialog, MaintenanceDialog.MaintenanceActionType buttonAction) {
                                Intrinsics.checkNotNullParameter(dialog, "dialog");
                                Intrinsics.checkNotNullParameter(buttonAction, "buttonAction");
                                AuthImpl.isLoginInProgress = false;
                                activity.finish();
                                int i = WhenMappings.$EnumSwitchMapping$0[buttonAction.ordinal()];
                                AuthImpl.INSTANCE.onLoginFail(i != 1 ? i != 2 ? i != 3 ? i != 4 ? new ResultAPI(-17, ResultAPI.Code.AuthUserInBlacklistActionDefault_DoExit, str6) : new ResultAPI(0, ResultAPI.Code.AuthUserInBlacklistActionDone, str6) : new ResultAPI(-17, ResultAPI.Code.AuthUserInBlacklistActionExit_DoExit, str6) : new ResultAPI(-17, ResultAPI.Code.AuthUserInBlacklistActionOpenURL_DoExit, str6) : new ResultAPI(-17, ResultAPI.Code.AuthUserInBlacklistTimeover_DoExit, str6), AuthDataInterface.LoginType.ACCOUNT, str7, authLoginListener2);
                            }
                        }));
                        getDialog().show();
                    }

                    @Override // com.hive.ui.OnActivityLifecycle
                    public void onDestroy(Activity activity) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                        if (!getIsCalledFinish()) {
                            getDialog().dismiss();
                        }
                        super.onDestroy(activity);
                    }

                    public final void setDialog(MaintenanceDialog maintenanceDialog) {
                        Intrinsics.checkNotNullParameter(maintenanceDialog, "<set-?>");
                        this.dialog = maintenanceDialog;
                    }
                });
            } else {
                LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "[selectLogin] UpdateUser error.");
                loginType = AuthDataInterface.LoginType.AUTO;
                isLoginInProgress = false;
                INSTANCE.onLoginFinish(new ResultAPI(-8, ResultAPI.Code.AuthServerResponseNotSuccessful, "[selectLogin] UpdateUser error."), AuthDataInterface.LoginType.ACCOUNT, null, null, str, authLoginListener);
            }
        } else {
            String str4 = "[selectLogin] UpdateUser network error : " + it.getResponse().getResult();
            LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), str4);
            loginType = AuthDataInterface.LoginType.AUTO;
            isLoginInProgress = false;
            INSTANCE.onLoginFinish(new ResultAPI(-5, ResultAPI.Code.AuthNetworkErrorRequestUpdate, str4), AuthDataInterface.LoginType.ACCOUNT, null, null, str, authLoginListener);
        }
        return Unit.INSTANCE;
    }

    private final void sendAgreementLogWithVid(String vid) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i(AuthDataInterface.getTAG(), "sendAgreementLogWithVid");
        if (agreementShowValue == 0 || Property.INSTANCE.getINSTANCE().getValue(AuthKeys.INSTANCE.getAGREEMENT_SCHEME_DATA()) == null) {
            loggerImpl.i(AuthDataInterface.getTAG(), "sendAgreementLogWithVid, not need to process");
        } else if (!isNeedToSendLogWithVid(vid)) {
            loggerImpl.i(AuthDataInterface.getTAG(), "sendAgreementLogWithVid, not need to process with vid");
        } else {
            currentLoginVid = vid;
            AuthNetwork.ActiveUser.INSTANCE.agreement().request(new Function1() { // from class: com.hive.auth.AuthImpl$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthImpl.sendAgreementLogWithVid$lambda$41((Agreement) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendAgreementLogWithVid$lambda$41(Agreement it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResponse().isSuccess()) {
            INSTANCE.setAgreementVidInfo(currentLoginVid);
        } else {
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[Agreement] request failed : " + it.getResponse().getResult());
        }
        currentLoginVid = "";
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object setAfterShowAgreementListener(AuthInitHiveType authInitHiveType, Continuation<? super Unit> continuation) {
        int i = WhenMappings.$EnumSwitchMapping$0[authInitHiveType.ordinal()];
        if (i == 1) {
            LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "setAfterShowAgreementListener, SDKV4");
            setInternalAfterAgreementListener(new AfterAgreementListener() { // from class: com.hive.auth.AuthImpl$setAfterShowAgreementListener$afterAgreementListener$1
                @Override // com.hive.auth.AuthImpl.AfterAgreementListener
                public void onAgreementUIFinish(int resultCode, boolean isAgreementSuccess) {
                    BuildersKt__Builders_commonKt.launch$default(AuthImpl.initializeScope, null, null, new AuthImpl$setAfterShowAgreementListener$afterAgreementListener$1$onAgreementUIFinish$1(resultCode, isAgreementSuccess, null), 3, null);
                }
            });
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "setAfterShowAgreementListener, SDKV1");
            setInternalAfterAgreementListener(new AfterAgreementListener() { // from class: com.hive.auth.AuthImpl$setAfterShowAgreementListener$afterAgreementListener$2
                @Override // com.hive.auth.AuthImpl.AfterAgreementListener
                public void onAgreementUIFinish(int resultCode, boolean isAgreementSuccess) {
                    BuildersKt__Builders_commonKt.launch$default(AuthImpl.initializeScope, null, null, new AuthImpl$setAfterShowAgreementListener$afterAgreementListener$2$onAgreementUIFinish$1(resultCode, isAgreementSuccess, null), 3, null);
                }
            });
        }
        return Unit.INSTANCE;
    }

    private final void setAgreementCountryAndVersionInfo(String countryCode, int agreementVersion) {
        String str;
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d(AuthDataInterface.getTAG(), "setAgreementCountryAndVersionInfo");
        Property.Companion companion = Property.INSTANCE;
        Property instance = companion.getINSTANCE();
        AuthKeys authKeys = AuthKeys.INSTANCE;
        String value = instance.getValue(authKeys.getAGREEMENT_COUNTRY_VERSION_WITH_VID());
        String upperCase = countryCode.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        str = "success";
        if (value == null) {
            loggerImpl.d(AuthDataInterface.getTAG(), "setAgreementCountryAndVersionInfo, createAgreementCountryVersionInfo(2) ".concat(createAgreementCountryVersionInfo(null, agreementVersion, upperCase) ? "success" : "failed"));
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(value);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(upperCase);
            if (jSONObjectOptJSONObject == null) {
                boolean zCreateAgreementCountryVersionInfo = INSTANCE.createAgreementCountryVersionInfo(jSONObject, agreementVersion, upperCase);
                String tag = AuthDataInterface.getTAG();
                if (!zCreateAgreementCountryVersionInfo) {
                    str = "failed";
                }
                loggerImpl.d(tag, "setAgreementCountryAndVersionInfo, createAgreementCountryVersionInfo(1) ".concat(str));
                return;
            }
            if (agreementVersion > jSONObjectOptJSONObject.getInt("version")) {
                jSONObjectOptJSONObject.remove("version");
                jSONObjectOptJSONObject.put("version", agreementVersion);
                if (jSONObjectOptJSONObject.has("vid")) {
                    jSONObjectOptJSONObject.remove("vid");
                }
                jSONObjectOptJSONObject.put("vid", new JSONArray());
                Property.setValue$default(companion.getINSTANCE(), authKeys.getAGREEMENT_COUNTRY_VERSION_WITH_VID(), jSONObject.toString(), null, 4, null);
                companion.getINSTANCE().writeProperties();
            }
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "setAgreementCountryAndVersionInfo, exception : " + e);
            e.printStackTrace();
        }
    }

    private final void setAgreementVidInfo(String vid) {
        String upperCase;
        LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "setAgreementVidInfo");
        String hiveCountry = ConfigurationImpl.INSTANCE.getHiveCountry();
        if (hiveCountry != null) {
            upperCase = hiveCountry.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        } else {
            upperCase = null;
        }
        Property.Companion companion = Property.INSTANCE;
        Property instance = companion.getINSTANCE();
        AuthKeys authKeys = AuthKeys.INSTANCE;
        String value = instance.getValue(authKeys.getAGREEMENT_COUNTRY_VERSION_WITH_VID());
        if (upperCase == null || value == null || !(!StringsKt.isBlank(value))) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(value);
            JSONArray jSONArray = jSONObject.getJSONObject(upperCase).getJSONArray("vid");
            jSONArray.put(vid);
            jSONObject.getJSONObject(upperCase).put("vid", jSONArray);
            Property.setValue$default(companion.getINSTANCE(), authKeys.getAGREEMENT_COUNTRY_VERSION_WITH_VID(), jSONObject.toString(), null, 4, null);
            companion.getINSTANCE().writeProperties();
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "setAgreementVidInfo, exception : " + e);
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void setCurrentAccount(AuthDataInterface.Account account) {
        currentAccount = account;
        HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
        HiveLifecycle.HiveAccount hiveAccount = account;
        if (account == null) {
            hiveAccount = new HiveLifecycle.HiveAccount();
        }
        hiveLifecycle.setAccount(hiveAccount);
    }

    private final void setInternalAfterAgreementListener(AfterAgreementListener listener) {
        internalAfterAgreementListener = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object showAgreement(kotlin.Triple<java.lang.Integer, com.hive.protocol.activeuser.GetAgreement.GetAgreementResponse, java.lang.Boolean> r6, com.hive.auth.AuthImpl.AuthInitHiveType r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.hive.auth.AuthImpl.C28151
            if (r0 == 0) goto L13
            r0 = r8
            com.hive.auth.AuthImpl$showAgreement$1 r0 = (com.hive.auth.AuthImpl.C28151) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.hive.auth.AuthImpl$showAgreement$1 r0 = new com.hive.auth.AuthImpl$showAgreement$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r6 = r0.L$0
            kotlin.Triple r6 = (kotlin.Triple) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L4e
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.ResultKt.throwOnFailure(r8)
            com.hive.logger.LoggerImpl r8 = com.hive.logger.LoggerImpl.INSTANCE
            java.lang.String r2 = com.hive.auth.AuthDataInterface.getTAG()
            java.lang.String r4 = "showAgreement"
            r8.i(r2, r4)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r5.setAfterShowAgreementListener(r7, r0)
            if (r7 != r1) goto L4e
            return r1
        L4e:
            java.lang.Object r7 = r6.getFirst()
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            if (r7 == 0) goto L8e
            if (r7 == r3) goto L6f
            r6 = 2
            if (r7 == r6) goto L60
            goto La2
        L60:
            com.hive.logger.LoggerImpl r6 = com.hive.logger.LoggerImpl.INSTANCE
            java.lang.String r7 = com.hive.auth.AuthDataInterface.getTAG()
            java.lang.String r8 = "showAgreement, PROCESS_AGREEMENT_NOT_TO_DO_ANYTHING"
            r6.i(r7, r8)
            r5.processGetAgreementResponseError()
            goto La2
        L6f:
            com.hive.logger.LoggerImpl r7 = com.hive.logger.LoggerImpl.INSTANCE
            java.lang.String r8 = com.hive.auth.AuthDataInterface.getTAG()
            java.lang.String r0 = "showAgreement, PROCESS_AGREEMENT_IGNORE_SHOW_AGREEMENT"
            r7.i(r8, r0)
            java.lang.Object r7 = r6.getSecond()
            com.hive.protocol.activeuser.GetAgreement$GetAgreementResponse r7 = (com.hive.protocol.activeuser.GetAgreement.GetAgreementResponse) r7
            java.lang.Object r6 = r6.getThird()
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            r5.ignoreAgreementShowing(r7, r6)
            goto La2
        L8e:
            com.hive.logger.LoggerImpl r7 = com.hive.logger.LoggerImpl.INSTANCE
            java.lang.String r8 = com.hive.auth.AuthDataInterface.getTAG()
            java.lang.String r0 = "showAgreement, PROCESS_AGREEMENT_SHOW_AGREEMENT"
            r7.i(r8, r0)
            java.lang.Object r6 = r6.getSecond()
            com.hive.protocol.activeuser.GetAgreement$GetAgreementResponse r6 = (com.hive.protocol.activeuser.GetAgreement.GetAgreementResponse) r6
            r5.needAgreementShowing(r6)
        La2:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.auth.AuthImpl.showAgreement(kotlin.Triple, com.hive.auth.AuthImpl$AuthInitHiveType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit signOut$lambda$25(final String str, final AuthDataInterface.AuthLogoutListener authLogoutListener, SignOut it) {
        String uid;
        Intrinsics.checkNotNullParameter(it, "it");
        if (!it.getResponse().getResult().isSuccess()) {
            INSTANCE.onLogoutFinish(new ResultAPI(-5, ResultAPI.Code.AuthNetworkErrorLoginCenterSignOut, "(errno: null, error: Network error)"), str, authLogoutListener);
        } else if (it.getResponse().isSuccess()) {
            Property.Companion companion = Property.INSTANCE;
            Property instance = companion.getINSTANCE();
            String str2 = AuthKeys.ACCOUNT_SESSION_KEY;
            String value = instance.getValue(str2);
            boolean z = value == null || StringsKt.isBlank(value);
            Property.setValue$default(companion.getINSTANCE(), AuthKeys.GUEST_VID, "", null, 4, null);
            Property instance2 = companion.getINSTANCE();
            AuthKeys authKeys = AuthKeys.INSTANCE;
            Property.setValue$default(instance2, authKeys.getGUEST_VID_TYPE(), "", null, 4, null);
            Property.setValue$default(companion.getINSTANCE(), AuthKeys.GUEST_SESSION_KEY, "", null, 4, null);
            Property.setValue$default(companion.getINSTANCE(), AuthKeys.ACCOUNT_VID, "", null, 4, null);
            Property.setValue$default(companion.getINSTANCE(), authKeys.getACCOUNT_VID_TYPE(), "", null, 4, null);
            Property.setValue$default(companion.getINSTANCE(), str2, "", null, 4, null);
            companion.getINSTANCE().writeProperties();
            AuthAccount.INSTANCE.removeToken();
            AuthDataInterface.Account account = currentAccount;
            if (account == null || (uid = account.getUid()) == null || !(!StringsKt.isBlank(uid)) || z) {
                AuthImpl authImpl = INSTANCE;
                authImpl.setCurrentAccount(null);
                loginType = z ? AuthDataInterface.LoginType.GUEST : AuthDataInterface.LoginType.ACCOUNT;
                authImpl.onLogoutFinish(new ResultAPI(0, ResultAPI.Code.Success, "[signOut] success"), str, authLogoutListener);
            } else {
                HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new OnActivityLifecycle() { // from class: com.hive.auth.AuthImpl$signOut$1$1$1
                    public SocialDialog socialDialog;

                    public final SocialDialog getSocialDialog() {
                        SocialDialog socialDialog = this.socialDialog;
                        if (socialDialog != null) {
                            return socialDialog;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("socialDialog");
                        return null;
                    }

                    @Override // com.hive.ui.OnActivityLifecycle
                    public boolean onBackPressed() {
                        return getSocialDialog().onBackPressed();
                    }

                    @Override // com.hive.ui.OnActivityLifecycle
                    public void onCreate(Activity activity, Bundle savedInstanceState) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                        super.onCreate(activity, savedInstanceState);
                        setSocialDialog(SocialDialog.INSTANCE.logoutHive(activity, new AuthImpl$signOut$1$1$1$onCreate$1(activity, str, authLogoutListener)));
                        getSocialDialog().show();
                    }

                    @Override // com.hive.ui.OnActivityLifecycle
                    public void onDestroy(Activity activity) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                        if (!getIsCalledFinish()) {
                            getSocialDialog().dismiss();
                        }
                        super.onDestroy(activity);
                    }

                    public final void setSocialDialog(SocialDialog socialDialog) {
                        Intrinsics.checkNotNullParameter(socialDialog, "<set-?>");
                        this.socialDialog = socialDialog;
                    }
                });
            }
        } else {
            INSTANCE.onLogoutFinish(new ResultAPI(-8, ResultAPI.Code.AuthNetworkErrorLoginCenterSignOut, "(errno: " + it.getResponse().getErrno() + ", error: " + it.getResponse().getError() + ')'), str, authLogoutListener);
        }
        return Unit.INSTANCE;
    }

    public final void bindLogin(String selectedVid, AuthDataInterface.AuthLoginListener listener) {
        Intrinsics.checkNotNullParameter(selectedVid, "selectedVid");
        String callMethodName = LoggerImpl.getCallMethodName(2);
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthDataInterface.getTAG(), "[" + callMethodName + "] AuthLoginListener is null");
            return;
        }
        if (!isInitialize) {
            String str = "[" + callMethodName + "] need initialize first";
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), str);
            onLoginFinish(new ResultAPI(-7, ResultAPI.Code.AuthNotInitialized, str), AuthDataInterface.LoginType.ACCOUNT, null, null, callMethodName, listener);
            return;
        }
        if (isLoginInProgress) {
            String str2 = "[" + callMethodName + "] login is already in progress";
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), str2);
            onLoginFinish(new ResultAPI(-3, ResultAPI.Code.AuthInProgressLoginLogout, str2), AuthDataInterface.LoginType.ACCOUNT, null, null, callMethodName, listener);
            return;
        }
        String str3 = recentSelectAccountUrl;
        if (str3 == null || StringsKt.isBlank(str3)) {
            String str4 = "[" + callMethodName + "] select web url is empty. Please try login first";
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), str4);
            onLoginFinish(new ResultAPI(-1, ResultAPI.Code.AuthInvalidSelectedAccountURL, str4), AuthDataInterface.LoginType.ACCOUNT, null, null, callMethodName, listener);
            return;
        }
        if (!StringsKt.isBlank(selectedVid)) {
            requestUpdate(selectedVid, listener, callMethodName);
            return;
        }
        String str5 = "[" + callMethodName + "] selected vid is empty or null.";
        LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), str5);
        onLoginFinish(new ResultAPI(-1, ResultAPI.Code.AuthInvalidSelectedVID, str5), AuthDataInterface.LoginType.ACCOUNT, null, null, callMethodName, listener);
    }

    public final void checkMaintenance(final boolean isShow, final AuthDataInterface.AuthMaintenanceListener authMaintenanceListener) {
        Intrinsics.checkNotNullParameter(authMaintenanceListener, "authMaintenanceListener");
        LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "checkMaintenance");
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        AuthNetwork.ActiveUser.INSTANCE.getNotice(new Function2() { // from class: com.hive.auth.AuthImpl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AuthImpl.checkMaintenance$lambda$34(isShow, callMethodName, authMaintenanceListener, (GetNotice) obj, (AuthDataInterface.AuthMaintenanceInfo) obj2);
            }
        });
    }

    public final Map<String, Object> convertJsonToMap(JSONObject jsonData) {
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jsonData.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            String str = next;
            Object objOpt = jsonData.opt(str);
            Intrinsics.checkNotNullExpressionValue(objOpt, "opt(...)");
            linkedHashMap.put(str, objOpt);
        }
        return MapsKt.toMap(linkedHashMap);
    }

    public final void disconnectGoogleProviderAfterLogout(final Function0<Unit> onComplete) {
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.AuthImpl$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                AuthImpl.disconnectGoogleProviderAfterLogout$lambda$23(onComplete);
            }
        });
    }

    public final AuthDataInterface.Account getAccount() {
        AuthDataInterface.Account accountV1 = getAccountV1();
        return accountV1 == null ? new AuthDataInterface.Account() : accountV1;
    }

    public final AuthDataInterface.Account getAccountV1() {
        if (!isInitialize) {
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[getAccount] need initialize first");
            return null;
        }
        if (isLoginInProgress) {
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[getAccount] login is already in progress");
            return null;
        }
        LoggerImpl.INSTANCE.iL(AuthDataInterface.getTAG(), "[getAccount] : " + currentAccount);
        return currentAccount;
    }

    public final String getCurrentLoginVid$hive_service_release() {
        return currentLoginVid;
    }

    public final String getDID() {
        return HiveLifecycle.INSTANCE.getDid();
    }

    @Override // com.hive.module.interfaces.HiveAuth, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return HiveAuth.DefaultImpls.getHiveModuleName(this);
    }

    public final AfterAgreementListener getInternalAfterAgreementListener$hive_service_release() {
        return internalAfterAgreementListener;
    }

    public final AuthDataInterface.LoginType getLoginType() {
        return loginType;
    }

    public final String getPeppermintCurrentPeppermint() {
        return peppermintCurrentPeppermint;
    }

    public final String getPeppermintCurrentSession() {
        return peppermintCurrentSession;
    }

    public final String getPeppermintCurrentUid() {
        return peppermintCurrentUid;
    }

    public final UserAgreeListener getUserAgreeListener() {
        return userAgreeListener;
    }

    @Override // com.hive.module.interfaces.HiveAuth, com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        return HiveAuth.DefaultImpls.getVersionInfo(this);
    }

    public final void initialize(AuthDataInterface.AuthInitializeListener initializeListener, HiveUserEngagement.UserEngagementListener engagementListener) {
        LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), MobileAdsBridgeBase.initializeMethodName);
        HiveLifecycle.INSTANCE.setStandAlone(false);
        BuildersKt__Builders_commonKt.launch$default(initializeScope, null, null, new C28031(initializeListener, engagementListener, null), 3, null);
    }

    public final void initializeSDKV1(HiveZoneType zone, AuthDataInterface.AuthInitializeListener initializeListener, HiveUserEngagement.UserEngagementListener engagementListener) {
        Intrinsics.checkNotNullParameter(zone, "zone");
        BuildersKt__Builders_commonKt.launch$default(initializeScope, null, null, new C28041(zone, initializeListener, engagementListener, null), 3, null);
    }

    public final boolean isInitialize() {
        return isInitialize;
    }

    @Override // com.hive.module.interfaces.HiveAuth
    public void login(AuthDataInterface.LoginType loginType2, AuthDataInterface.AuthLoginListener listener) {
        String callMethodName = LoggerImpl.getCallMethodName(2);
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthDataInterface.getTAG(), "[Login] AuthLoginListener is null");
            return;
        }
        if (!isInitialize) {
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[Login] need initialize first");
            onLoginFinish(new ResultAPI(-7, ResultAPI.Code.AuthNotInitialized, "[Login] need initialize first"), loginType2, null, null, callMethodName, listener);
            return;
        }
        if (isLoginInProgress) {
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[Login] login is already in progress");
            onLoginFinish(new ResultAPI(-3, ResultAPI.Code.AuthInProgressLoginLogout, "[Login] login is already in progress"), loginType2, null, null, callMethodName, listener);
            return;
        }
        if (loginType2 == null) {
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[Login] invalid loginType param (null)");
            onLoginFinish(new ResultAPI(-1, ResultAPI.Code.AuthInvalidParamLoginType, "[Login] invalid loginType param (null)"), loginType2, null, null, callMethodName, listener);
            return;
        }
        isLoginInProgress = true;
        Property.Companion companion = Property.INSTANCE;
        String value = companion.getINSTANCE().getValue(AuthKeys.GUEST_VID);
        companion.getINSTANCE().getValue(AuthKeys.INSTANCE.getGUEST_VID_TYPE());
        String value2 = companion.getINSTANCE().getValue(AuthKeys.GUEST_SESSION_KEY);
        String value3 = companion.getINSTANCE().getValue(AuthKeys.ACCOUNT_SESSION_KEY);
        int i = WhenMappings.$EnumSwitchMapping$1[loginType2.ordinal()];
        if (i == 1) {
            if (value == null || !(!StringsKt.isBlank(value))) {
                internalGuestLogin(callMethodName, listener);
                return;
            }
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[Login] invalid loginType param (GUEST). Guest vid is exist. Please use the AUTO or ACCOUNT login type.");
            isLoginInProgress = false;
            onLoginFinish(new ResultAPI(-1, ResultAPI.Code.AuthInvalidParamVID, "[Login] invalid loginType param (GUEST). Guest vid is exist. Please use the AUTO or ACCOUNT login type."), loginType2, null, null, callMethodName, listener);
            return;
        }
        if (i == 2) {
            internalAccountLogin(callMethodName, listener);
            return;
        }
        if (i == 3) {
            if ((value2 == null || StringsKt.isBlank(value2)) && (value3 == null || StringsKt.isBlank(value3))) {
                LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[Login] invalid loginType param (AUTO). not found session key. Please use the GUEST or ACCOUNT login type.");
                isLoginInProgress = false;
                onLoginFinish(new ResultAPI(-1, ResultAPI.Code.AuthInvalidParamSessionKey, "[Login] invalid loginType param (AUTO). not found session key. Please use the GUEST or ACCOUNT login type."), loginType2, null, null, callMethodName, listener);
                return;
            } else if (value == null || !(!StringsKt.isBlank(value))) {
                internalAccountLogin(callMethodName, listener);
                return;
            } else {
                internalGuestLogin(callMethodName, listener);
                return;
            }
        }
        if (i != 4) {
            String str = "[Login] invalid loginType param " + loginType2;
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), str);
            isLoginInProgress = false;
            onLoginFinish(new ResultAPI(-1, ResultAPI.Code.AuthInvalidParamLoginType, str), loginType2, null, null, callMethodName, listener);
            return;
        }
        String str2 = "[Login] invalid loginType param " + loginType2;
        LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), str2);
        isLoginInProgress = false;
        onLoginFinish(new ResultAPI(-1, ResultAPI.Code.AuthInvalidParamLoginType, str2), loginType2, null, null, callMethodName, listener);
    }

    public final void logout(final AuthDataInterface.AuthLogoutListener listener) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i(AuthDataInterface.getTAG(), "[logout]");
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (listener == null) {
            loggerImpl.e(AuthDataInterface.getTAG(), "[logout] AuthLogoutListener is null");
            return;
        }
        if (!isInitialize) {
            loggerImpl.w(AuthDataInterface.getTAG(), "[logout] need initialize first");
            onLogoutFinish(new ResultAPI(-7, ResultAPI.Code.AuthNotInitialized, "[logout] need initialize first"), callMethodName, listener);
        } else if (!isLoginInProgress) {
            AuthNetwork.LoginCenter.INSTANCE.logout().request(new Function1() { // from class: com.hive.auth.AuthImpl$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthImpl.logout$lambda$21(callMethodName, listener, (Logout) obj);
                }
            });
        } else {
            loggerImpl.w(AuthDataInterface.getTAG(), "[logout] login is already in progress");
            onLogoutFinish(new ResultAPI(-3, ResultAPI.Code.AuthInProgressLoginLogout, "[logout] login is already in progress"), callMethodName, listener);
        }
    }

    public final void logoutForHiveUserExit(AuthDataInterface.AuthLogoutListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "[logoutForHiveUserExit]");
        String callMethodName = LoggerImpl.getCallMethodName(2);
        loginType = null;
        Property.Companion companion = Property.INSTANCE;
        Property.setValue$default(companion.getINSTANCE(), AuthKeys.GUEST_VID, "", null, 4, null);
        Property instance = companion.getINSTANCE();
        AuthKeys authKeys = AuthKeys.INSTANCE;
        Property.setValue$default(instance, authKeys.getGUEST_VID_TYPE(), "", null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), AuthKeys.GUEST_SESSION_KEY, "", null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), AuthKeys.ACCOUNT_VID, "", null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), authKeys.getACCOUNT_VID_TYPE(), "", null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), AuthKeys.ACCOUNT_SESSION_KEY, "", null, 4, null);
        Property instance2 = companion.getINSTANCE();
        SocialKeys socialKeys = SocialKeys.INSTANCE;
        Property.setValue$default(instance2, socialKeys.getUID(), "", null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), socialKeys.getUID_SESSION_TOKEN(), "", null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), socialKeys.getPEPPERMINT(), "", null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), socialKeys.getPGS_PLAYERID(), "", null, 4, null);
        companion.getINSTANCE().removeValue(AuthKeys.IS_AUTHORIZED);
        companion.getINSTANCE().writeProperties();
        AuthAccount.INSTANCE.removeToken();
        SocialAccount.INSTANCE.removeToken();
        onLogoutFinish(new ResultAPI(0, ResultAPI.Code.Success, "[logoutForHiveUserExit] success"), callMethodName, listener);
    }

    public final void memoryReset$hive_service_release() {
        loginType = null;
        setCurrentAccount(null);
        recentSelectAccountUrl = null;
        isLoginInProgress = false;
    }

    public final void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public final boolean onC2SModuleLogin(String uid, String uidSession, boolean isGuest) {
        HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
        if (!hiveLifecycle.isStandAlone()) {
            return false;
        }
        if (uid != null && (!StringsKt.isBlank(uid)) && uidSession != null && (!StringsKt.isBlank(uidSession))) {
            HiveLifecycle.HiveAccount hiveAccount = new HiveLifecycle.HiveAccount();
            hiveAccount.setVid(null);
            hiveAccount.setUid(uid);
            hiveAccount.setDid(hiveLifecycle.getDid());
            hiveAccount.setVidSession(null);
            hiveAccount.setOauthToken(SocialAccount.INSTANCE);
            hiveAccount.setUidSession(uidSession);
            hiveLifecycle.onSignIn(hiveAccount);
            hiveLifecycle.setC2SGuest(isGuest);
        }
        return true;
    }

    public final void onRequestPermissionsResult(Activity activity, int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
    }

    public final void onStart(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AuthVerifier.INSTANCE.onActivityStarted();
    }

    public final void onStop(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AuthVerifier.INSTANCE.onActivityStoped();
    }

    public final void processLoginTypeSDKV1(boolean isPGSLogin, String playerId, String playerName, final PreLoginListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i(AuthDataInterface.getTAG(), "processLoginTypeSDKV1");
        Property.Companion companion = Property.INSTANCE;
        final boolean z = Boolean.parseBoolean(companion.getINSTANCE().getValue(AuthKeys.IS_AUTHORIZED, "false"));
        HiveLifecycle.INSTANCE.getDid();
        AuthDataInterface.LoginType loginType2 = AuthDataInterface.LoginType.GUEST;
        String value = companion.getINSTANCE().getValue(AuthKeys.GUEST_VID);
        String value2 = companion.getINSTANCE().getValue(AuthKeys.ACCOUNT_VID);
        String str = null;
        if (value2 != null && !StringsKt.isBlank(value2)) {
            value = value2;
        } else if (value == null || StringsKt.isBlank(value)) {
            value = null;
        }
        final String value3 = companion.getINSTANCE().getValue(AuthKeys.GUEST_SESSION_KEY);
        final String value4 = companion.getINSTANCE().getValue(AuthKeys.ACCOUNT_SESSION_KEY);
        if (value4 != null && !StringsKt.isBlank(value4)) {
            str = value4;
        } else if (value3 != null && !StringsKt.isBlank(value3)) {
            str = value3;
        }
        AuthDataInterface.LoginType loginType3 = ((str == null || !(StringsKt.isBlank(str) ^ true)) && !isPGSLogin) ? z ? AuthDataInterface.LoginType.ACCOUNT : loginType2 : AuthDataInterface.LoginType.AUTO;
        if (loginType3 == loginType2) {
            loggerImpl.i(AuthDataInterface.getTAG(), "[processLoginType] request LoginCenter - preLogin");
            AuthNetwork.LoginCenter.INSTANCE.preLogin().request(new Function1() { // from class: com.hive.auth.AuthImpl$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthImpl.processLoginTypeSDKV1$lambda$17(listener, z, value3, value4, (PreLogin) obj);
                }
            });
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vid", value);
            jSONObject.put("uid", "");
            jSONObject.put("platform", "");
            jSONObject.put("loginType", loginType3.getValue());
            jSONObject.put("guestSession", value3);
            jSONObject.put("authSession", value4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        listener.onPreLoginFinish(new ResultAPI(0, ResultAPI.Code.Success, ""), jSONObject);
    }

    @Deprecated(message = "kotlin version")
    public final void requestPermissionViewData(final Permission.PermissionViewDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        PermissionImpl.INSTANCE.requestPermissionViewData(new Permission.PermissionViewDataListener() { // from class: com.hive.auth.AuthImpl.requestPermissionViewData.1

            /* JADX INFO: renamed from: com.hive.auth.AuthImpl$requestPermissionViewData$1$WhenMappings */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ResultAPI.Code.values().length];
                    try {
                        iArr[ResultAPI.Code.AuthSkipPermissionView.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ResultAPI.Code.AuthV4SkipPermissionView.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[ResultAPI.Code.AuthInProgressRequestPermissionViewData.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[ResultAPI.Code.AuthV4InProgress.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // com.hive.Permission.PermissionViewDataListener
            public void onPermissionViewData(ResultAPI result, Permission.PermissionViewData data) {
                String string;
                Intrinsics.checkNotNullParameter(result, "result");
                int i = WhenMappings.$EnumSwitchMapping$0[result.getCode().ordinal()];
                if (i == 1 || i == 2) {
                    result = new ResultAPI(0, ResultAPI.Code.AuthSkipPermissionView);
                } else if (i == 3 || i == 4) {
                    result = new ResultAPI(0, ResultAPI.Code.AuthInProgressRequestPermissionViewData);
                }
                LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                String tag = AuthV4.getTAG();
                String str = callMethodName;
                StringBuilder sb = new StringBuilder();
                sb.append(result);
                if (data == null || (string = data.toString()) == null) {
                    string = "";
                }
                sb.append(string);
                loggerImpl.apiCallbackLog(tag, str, sb.toString());
                listener.onPermissionViewData(result, data);
            }
        });
    }

    public final void requestUpdate(String select, final AuthDataInterface.AuthLoginListener listener, final String fApiName) {
        Intrinsics.checkNotNullParameter(select, "select");
        Intrinsics.checkNotNullParameter(fApiName, "fApiName");
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthDataInterface.getTAG(), "[" + fApiName + "] AuthLoginListener is null");
            return;
        }
        if (loginType == AuthDataInterface.LoginType.SELECT) {
            Crypto crypto = Crypto.INSTANCE;
            final String strGenerateCodeVerifier = crypto.generateCodeVerifier();
            AuthNetwork.LoginCenter.INSTANCE.update(select, crypto.generateCodeChallenge(strGenerateCodeVerifier)).request(new Function1() { // from class: com.hive.auth.AuthImpl$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthImpl.requestUpdate$lambda$19(fApiName, listener, strGenerateCodeVerifier, (Update) obj);
                }
            });
            return;
        }
        String str = "[" + fApiName + "] LoginType is not SELECT. current is " + loginType;
        LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), str);
        onLoginFinish(new ResultAPI(-9, ResultAPI.Code.AuthInvalidParamLoginType, str), AuthDataInterface.LoginType.ACCOUNT, null, null, fApiName, listener);
    }

    public final void requestUserPermissions(List<String> request, PlatformHelper.RequestUserPermissionsListener listener) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(listener, "listener");
        PlatformHelperImpl.INSTANCE.requestUserPermissions(request, listener);
    }

    public final void reset() {
        LoggerImpl.INSTANCE.e(AuthDataInterface.getTAG(), "reset");
        logout(new AuthDataInterface.AuthLogoutListener() { // from class: com.hive.auth.AuthImpl.reset.1
            @Override // com.hive.auth.AuthDataInterface.AuthLogoutListener
            public void onAuthLogout(ResultAPI result) {
                Intrinsics.checkNotNullParameter(result, "result");
                HiveLifecycle.INSTANCE.onReset();
                Property.INSTANCE.getINSTANCE().deletePropertyFile();
                AuthImpl.isInitialize = false;
                AuthImpl.INSTANCE.memoryReset$hive_service_release();
            }
        });
    }

    public final boolean selectionSessionCheck() {
        Property.Companion companion = Property.INSTANCE;
        String value = companion.getINSTANCE().getValue(AuthKeys.GUEST_VID);
        String value2 = companion.getINSTANCE().getValue(AuthKeys.GUEST_SESSION_KEY);
        Property instance = companion.getINSTANCE();
        SocialKeys socialKeys = SocialKeys.INSTANCE;
        String value3 = instance.getValue(socialKeys.getUID());
        String value4 = companion.getINSTANCE().getValue(socialKeys.getUID_SESSION_TOKEN());
        return (value == null || StringsKt.isBlank(value) || value2 == null || StringsKt.isBlank(value2) || value3 == null || StringsKt.isBlank(value3) || value4 == null || StringsKt.isBlank(value4)) ? false : true;
    }

    public final void sendFunnelsLogs(String funnelTrack, String optionTag) {
        Intrinsics.checkNotNullParameter(funnelTrack, "funnelTrack");
        AnalyticsImpl.INSTANCE.sendUserEntryFunnelsLogs(funnelTrack, optionTag);
    }

    public final void setCurrentLoginVid$hive_service_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        currentLoginVid = str;
    }

    public final boolean setEmergencyMode() {
        String did = HiveLifecycle.INSTANCE.getDid();
        Property.Companion companion = Property.INSTANCE;
        String value = companion.getINSTANCE().getValue(AuthKeys.GUEST_VID);
        String value2 = companion.getINSTANCE().getValue(AuthKeys.GUEST_SESSION_KEY);
        String value3 = companion.getINSTANCE().getValue(AuthKeys.ACCOUNT_VID);
        String value4 = companion.getINSTANCE().getValue(AuthKeys.ACCOUNT_SESSION_KEY);
        if (value3 != null && !StringsKt.isBlank(value3)) {
            value = value3;
        } else if (value == null || StringsKt.isBlank(value)) {
            value = null;
        }
        if (value4 != null && !StringsKt.isBlank(value4)) {
            value2 = value4;
        } else if (value2 == null || StringsKt.isBlank(value2)) {
            value2 = null;
        }
        if (value == null || StringsKt.isBlank(value) || value2 == null || StringsKt.isBlank(value2)) {
            return false;
        }
        AuthDataInterface.Account account = new AuthDataInterface.Account(value, null, did, value2);
        account.setVidType(i.f2373a);
        setCurrentAccount(account);
        onEmergencyMode$default(this, false, 1, null);
        return true;
    }

    public final boolean setEmergencyModeWithUid(String uid) {
        String did = HiveLifecycle.INSTANCE.getDid();
        if (uid == null || uid.length() == 0 || did == null || did.length() == 0) {
            LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "uid or did is null or empty");
            return false;
        }
        AuthDataInterface.Account account = new AuthDataInterface.Account(null, uid, did, null, Property.INSTANCE.getINSTANCE().getValue(SocialKeys.INSTANCE.getUID_SESSION_TOKEN()));
        account.setVidType("v0");
        setCurrentAccount(account);
        onEmergencyMode(true);
        return true;
    }

    @Deprecated(message = "4.16.2, GCPSDK4-906")
    public final void setEnableRequestStoragePermission() {
        LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "AuthImpl setEnableRequestStoragePermission");
        CheckPermission.INSTANCE.setEnableRequestStoragePermission();
    }

    public final void setFacebookPermission(List<String> permission) {
        if (permission != null) {
            com.hive.core.Configuration.INSTANCE.setFacebookPermissionList(permission);
        }
    }

    public final void setPeppermintCurrentPeppermint(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        peppermintCurrentPeppermint = str;
    }

    public final void setPeppermintCurrentSession(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        peppermintCurrentSession = str;
    }

    public final void setPeppermintCurrentUid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        peppermintCurrentUid = str;
    }

    @Deprecated(message = "4.16.2, GCPSDK4-906")
    public final void setPermissionViewState(boolean isOn) {
        ConfigurationImpl.INSTANCE.setHivePermissionViewOn(isOn);
    }

    public final void setShowsNoticePopup(boolean showsPopup) {
        showsNoticePopup = showsPopup;
    }

    public final void setUserAgreeListener(UserAgreeListener callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        userAgreeListener = callback;
    }

    public final void showAdultConfirm(final AuthDataInterface.AuthAdultConfirmListener listener) {
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthDataInterface.getTAG(), "[showAdultConfirm] AuthAdultConfirmListener is null");
            return;
        }
        if (isInitialize) {
            new AdultConfirmView(HiveActivity.INSTANCE.getRecentActivity(), new AuthDataInterface.AuthAdultConfirmListener() { // from class: com.hive.auth.AuthImpl.showAdultConfirm.1
                @Override // com.hive.auth.AuthDataInterface.AuthAdultConfirmListener
                public void onAuthAdultConfirm(ResultAPI result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), callMethodName, result.toString());
                    listener.onAuthAdultConfirm(result);
                }
            }).show();
            return;
        }
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.w(AuthDataInterface.getTAG(), "[showAdultConfirm] need initialize first");
        ResultAPI resultAPI = new ResultAPI(-7, ResultAPI.Code.AuthNotInitialized, "[showAdultConfirm] need initialize first");
        loggerImpl.apiCallbackLog(AuthDataInterface.getTAG(), callMethodName, resultAPI.toString());
        listener.onAuthAdultConfirm(resultAPI);
    }

    public final void showLoginSelection(final Map<String, ? extends Object> currentVidData, final Map<String, ? extends Object> usedVidData, final AuthDataInterface.AuthLoginListener listener) {
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthDataInterface.getTAG(), "[selectLogin] AuthLoginListener is null");
            return;
        }
        if (!isInitialize) {
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[selectLogin] need initialize first");
            onLoginFinish(new ResultAPI(-7, ResultAPI.Code.AuthNotInitialized, "[selectLogin] need initialize first"), AuthDataInterface.LoginType.ACCOUNT, null, null, callMethodName, listener);
            return;
        }
        if (isLoginInProgress) {
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[selectLogin] login is already in progress");
            onLoginFinish(new ResultAPI(-3, ResultAPI.Code.AuthInProgressLoginLogout, "[selectLogin] login is already in progress"), AuthDataInterface.LoginType.ACCOUNT, null, null, callMethodName, listener);
            return;
        }
        String str = recentSelectAccountUrl;
        if (str == null || StringsKt.isBlank(str)) {
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[selectLogin] select web url is empty. Please try login first");
            onLoginFinish(new ResultAPI(-1, ResultAPI.Code.AuthInvalidSelectedAccountURL, "[selectLogin] select web url is empty. Please try login first"), AuthDataInterface.LoginType.ACCOUNT, null, null, callMethodName, listener);
            return;
        }
        if (currentVidData == null || usedVidData == null) {
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[selectLogin] invalid vid data (null)");
            onLoginFinish(new ResultAPI(-1, ResultAPI.Code.AuthInvalidParamVID, "[selectLogin] invalid vid data (null)"), AuthDataInterface.LoginType.ACCOUNT, null, null, callMethodName, listener);
            return;
        }
        Property.Companion companion = Property.INSTANCE;
        String value = companion.getINSTANCE().getValue(AuthKeys.GUEST_VID);
        companion.getINSTANCE().getValue(AuthKeys.INSTANCE.getGUEST_VID_TYPE());
        String value2 = companion.getINSTANCE().getValue(AuthKeys.GUEST_SESSION_KEY);
        Property instance = companion.getINSTANCE();
        SocialKeys socialKeys = SocialKeys.INSTANCE;
        String value3 = instance.getValue(socialKeys.getUID());
        String value4 = companion.getINSTANCE().getValue(socialKeys.getUID_SESSION_TOKEN());
        if (value == null || StringsKt.isBlank(value) || value2 == null || StringsKt.isBlank(value2) || value3 == null || StringsKt.isBlank(value3) || value4 == null || StringsKt.isBlank(value4)) {
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[selectLogin] invalid account session");
            onLoginFinish(new ResultAPI(-9, ResultAPI.Code.AuthInvalidAccountSession, "[selectLogin] invalid account session"), AuthDataInterface.LoginType.ACCOUNT, null, null, callMethodName, listener);
        } else {
            isLoginInProgress = true;
            SocialHiveImpl.INSTANCE.getMyProfile(new SocialHive.ProfileListener() { // from class: com.hive.auth.AuthImpl.showLoginSelection.1
                @Override // com.hive.SocialHive.ProfileListener
                public void onProfile(ResultAPI hiveProfileResult, ArrayList<SocialHive.ProfileHive> profileList) {
                    String identifier;
                    Intrinsics.checkNotNullParameter(hiveProfileResult, "hiveProfileResult");
                    if (hiveProfileResult.isFailure()) {
                        new ResultAPI(-98, ResultAPI.Code.AuthNetworkErrorShowLoginSelection, "");
                    }
                    if (profileList == null || profileList.size() < 0) {
                        identifier = null;
                    } else {
                        SocialHive.ProfileHive profileHive = profileList.get(0);
                        Intrinsics.checkNotNullExpressionValue(profileHive, "get(...)");
                        identifier = profileHive.getIdentifier();
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        Android android2 = Android.INSTANCE;
                        Object objMapToJSON = android2.mapToJSON(currentVidData);
                        Intrinsics.checkNotNull(objMapToJSON, "null cannot be cast to non-null type org.json.JSONObject");
                        Object objMapToJSON2 = android2.mapToJSON(usedVidData);
                        Intrinsics.checkNotNull(objMapToJSON2, "null cannot be cast to non-null type org.json.JSONObject");
                        JSONObject jSONObject2 = (JSONObject) objMapToJSON2;
                        jSONObject2.put("userid", identifier);
                        jSONObject.put("ui_ver", 1);
                        jSONObject.put(PangleConstants.APP_ID, ConfigurationImpl.INSTANCE.getAppId());
                        jSONObject.put("guest_account", (JSONObject) objMapToJSON);
                        jSONObject.put("official_account", jSONObject2);
                        final String string = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                        final String str2 = AuthImpl.recentSelectAccountUrl;
                        final String str3 = callMethodName;
                        final AuthDataInterface.AuthLoginListener authLoginListener = listener;
                        if (str2 != null) {
                            HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new OnActivityLifecycle() { // from class: com.hive.auth.AuthImpl$showLoginSelection$1$onProfile$1$1
                                public LoginCenterSelectDialog dialog;

                                public final LoginCenterSelectDialog getDialog() {
                                    LoginCenterSelectDialog loginCenterSelectDialog = this.dialog;
                                    if (loginCenterSelectDialog != null) {
                                        return loginCenterSelectDialog;
                                    }
                                    Intrinsics.throwUninitializedPropertyAccessException("dialog");
                                    return null;
                                }

                                @Override // com.hive.ui.OnActivityLifecycle
                                public void onCreate(final Activity activity, Bundle savedInstanceState) {
                                    Intrinsics.checkNotNullParameter(activity, "activity");
                                    super.onCreate(activity, savedInstanceState);
                                    String str4 = str2;
                                    String str5 = string;
                                    final AuthDataInterface.AuthLoginListener authLoginListener2 = authLoginListener;
                                    final String str6 = str3;
                                    setDialog(new LoginCenterSelectDialog(activity, str4, str5, new LoginCenterSelectDialog.AuthLoginCenterSelectDialogListener() { // from class: com.hive.auth.AuthImpl$showLoginSelection$1$onProfile$1$1$onCreate$1
                                        @Override // com.hive.auth.LoginCenterSelectDialog.AuthLoginCenterSelectDialogListener
                                        public void onWebViewFinish(String select) {
                                            if (select == null || StringsKt.isBlank(select)) {
                                                Intent intent = new Intent();
                                                if (!SocialHiveImpl.INSTANCE.getAuthDialogClear()) {
                                                    intent.putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, true);
                                                }
                                                HiveUiActivity.Companion companion2 = HiveUiActivity.INSTANCE;
                                                Activity recentActivity = HiveActivity.INSTANCE.getRecentActivity();
                                                final String str7 = str6;
                                                final AuthDataInterface.AuthLoginListener authLoginListener3 = authLoginListener2;
                                                companion2.launch(recentActivity, intent, new OnActivityLifecycle() { // from class: com.hive.auth.AuthImpl$showLoginSelection$1$onProfile$1$1$onCreate$1$onWebViewFinish$1
                                                    @Override // com.hive.ui.OnActivityLifecycle
                                                    public void onCreate(Activity activity2, Bundle savedInstanceState2) {
                                                        Intrinsics.checkNotNullParameter(activity2, "activity");
                                                        super.onCreate(activity2, savedInstanceState2);
                                                        SocialDialog.INSTANCE.logoutHive(activity2, new AuthImpl$showLoginSelection$1$onProfile$1$1$onCreate$1$onWebViewFinish$1$onCreate$1(activity2, str7, authLoginListener3)).show();
                                                    }
                                                });
                                            } else {
                                                AuthImpl.INSTANCE.requestUpdate(select, authLoginListener2, str6);
                                            }
                                            activity.finish();
                                        }
                                    }));
                                    getDialog().show();
                                }

                                @Override // com.hive.ui.OnActivityLifecycle
                                public void onDestroy(Activity activity) {
                                    Intrinsics.checkNotNullParameter(activity, "activity");
                                    if (!getIsCalledFinish()) {
                                        getDialog().dismiss$hive_service_release();
                                    }
                                    super.onDestroy(activity);
                                }

                                public final void setDialog(LoginCenterSelectDialog loginCenterSelectDialog) {
                                    Intrinsics.checkNotNullParameter(loginCenterSelectDialog, "<set-?>");
                                    this.dialog = loginCenterSelectDialog;
                                }
                            });
                            return;
                        }
                        AuthImpl.isLoginInProgress = false;
                        LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[selectLogin] select web url is empty. Please try login first");
                        AuthImpl.INSTANCE.onLoginFinish(new ResultAPI(-1, ResultAPI.Code.AuthInvalidSelectedAccountURL, "[selectLogin] select web url is empty. Please try login first"), AuthDataInterface.LoginType.ACCOUNT, null, null, str3, authLoginListener);
                    } catch (Exception unused) {
                        AuthImpl.isLoginInProgress = false;
                        LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[selectLogin] invalid post data");
                        AuthImpl.INSTANCE.onLoginFinish(new ResultAPI(-1, ResultAPI.Code.AuthJsonException, "[selectLogin] invalid post data"), AuthDataInterface.LoginType.ACCOUNT, null, null, callMethodName, listener);
                    }
                }
            });
        }
    }

    public final void showTerms(AuthDataInterface.AuthShowTermsListener listener) {
        showTerms(Property.INSTANCE.getINSTANCE().getValue(AuthKeys.INSTANCE.getAGREEMENT_REVIEW_URL()), listener);
    }

    public final void signOut(final AuthDataInterface.AuthLogoutListener listener) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i(AuthDataInterface.getTAG(), "[signOut]");
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (listener == null) {
            loggerImpl.e(AuthDataInterface.getTAG(), "[signOut] AuthLogoutListener is null");
            return;
        }
        if (!isInitialize) {
            loggerImpl.w(AuthDataInterface.getTAG(), "[signOut] need initialize first");
            onLogoutFinish(new ResultAPI(-7, ResultAPI.Code.AuthNotInitialized, "[signOut] need initialize first"), callMethodName, listener);
        } else if (isLoginInProgress) {
            loggerImpl.w(AuthDataInterface.getTAG(), "[signOut] login is already in progress");
            onLogoutFinish(new ResultAPI(-3, ResultAPI.Code.AuthInProgressLoginLogout, "[signOut] login is already in progress"), callMethodName, listener);
        } else if (!isEmergencyMode) {
            AuthNetwork.LoginCenter.INSTANCE.signOut().request(new Function1() { // from class: com.hive.auth.AuthImpl$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthImpl.signOut$lambda$25(callMethodName, listener, (SignOut) obj);
                }
            });
        } else {
            loggerImpl.w(AuthDataInterface.getTAG(), "[signOut] Not supported in emergencyMode");
            onLogoutFinish(new ResultAPI(-2, ResultAPI.Code.AuthInvalidUser, "[signOut] Not supported in emergencyMode"), callMethodName, listener);
        }
    }

    public final void showTerms(final String url, final AuthDataInterface.AuthShowTermsListener listener) {
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthDataInterface.getTAG(), "[showTerms] AuthShowTermsListener is null");
            return;
        }
        if (!isInitialize) {
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.w(AuthDataInterface.getTAG(), "[showTerms] need initialize first");
            ResultAPI resultAPI = new ResultAPI(-7, ResultAPI.Code.AuthNotInitialized, "[showTerms] need initialize first");
            loggerImpl.apiCallbackLog(AuthDataInterface.getTAG(), callMethodName, resultAPI.toString());
            listener.onAuthShowTerms(resultAPI);
            return;
        }
        if (isInProgressTerms) {
            LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[showTerms] is in progress.");
            listener.onAuthShowTerms(new ResultAPI(-3, ResultAPI.Code.AuthCanceled, "[showTerms] is in progress."));
            return;
        }
        isInProgressTerms = true;
        if (url == null || url.length() == 0) {
            url = "";
        }
        LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[showTerms] reviewUrl: " + url);
        HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new OnActivityLifecycle() { // from class: com.hive.auth.AuthImpl.showTerms.1
            public AuthV4TermsView authV4TermsView;

            public final AuthV4TermsView getAuthV4TermsView() {
                AuthV4TermsView authV4TermsView = this.authV4TermsView;
                if (authV4TermsView != null) {
                    return authV4TermsView;
                }
                Intrinsics.throwUninitializedPropertyAccessException("authV4TermsView");
                return null;
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public boolean onBackPressed() {
                return getAuthV4TermsView().onBackPressed();
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onCreate(final Activity activity, Bundle savedInstanceState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                super.onCreate(activity, savedInstanceState);
                String str = url;
                final AuthDataInterface.AuthShowTermsListener authShowTermsListener = listener;
                final String str2 = callMethodName;
                setAuthV4TermsView(new AuthV4TermsView(activity, str, new AuthV4WebView.AuthV4WebViewListener() { // from class: com.hive.auth.AuthImpl$showTerms$1$onCreate$1
                    @Override // com.hive.authv4.webviewflow.AuthV4WebView.AuthV4WebViewListener
                    public void onReceivedError(int errorCode, String description, String failingUrl) {
                        String str3 = "[showTerms] webView Error : errorCode : " + errorCode + " decsription : " + description + " failingURL : " + failingUrl;
                        LoggerImpl loggerImpl2 = LoggerImpl.INSTANCE;
                        loggerImpl2.dL(AuthDataInterface.getTAG(), str3);
                        loggerImpl2.dR(AuthDataInterface.getTAG(), "[showTerms] webView Error : errorCode : " + errorCode + " decsription : " + description + " failingURL");
                        ResultAPI resultAPI2 = new ResultAPI(-5, ResultAPI.Code.AuthV4WebviewDialogError, str3);
                        loggerImpl2.apiCallbackLog(AuthDataInterface.getTAG(), str2, resultAPI2.toString());
                        authShowTermsListener.onAuthShowTerms(resultAPI2);
                        activity.finish();
                    }

                    @Override // com.hive.authv4.webviewflow.AuthV4WebView.AuthV4WebViewListener
                    public void onWebViewFinish(String select) {
                        LoggerImpl.INSTANCE.d(AuthDataInterface.getTAG(), "[showTerms] webView finish: " + select);
                        authShowTermsListener.onAuthShowTerms(new ResultAPI());
                        activity.finish();
                    }
                }));
                getAuthV4TermsView().show();
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onDestroy(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (!getIsCalledFinish()) {
                    getAuthV4TermsView().dismiss();
                }
                AuthImpl.isInProgressTerms = false;
                super.onDestroy(activity);
            }

            public final void setAuthV4TermsView(AuthV4TermsView authV4TermsView) {
                Intrinsics.checkNotNullParameter(authV4TermsView, "<set-?>");
                this.authV4TermsView = authV4TermsView;
            }
        });
    }
}
