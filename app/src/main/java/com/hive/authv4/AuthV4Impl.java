package com.hive.authv4;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Toast;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.AuthV4;
import com.hive.Configuration;
import com.hive.Const;
import com.hive.HiveActivity;
import com.hive.Permission;
import com.hive.Push;
import com.hive.ResultAPI;
import com.hive.analytics.AnalyticsImpl;
import com.hive.auth.AdultConfirmView;
import com.hive.auth.AuthDataInterface;
import com.hive.auth.MaintenanceDialog;
import com.hive.authv4.AuthV4Impl;
import com.hive.authv4.AuthV4Network;
import com.hive.authv4.agegate.AgeGateCheck;
import com.hive.authv4.appupdate.AppUpdate;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.authv4.provider.AuthV4ProviderHive;
import com.hive.authv4.webviewflow.AuthV4AgreementView;
import com.hive.authv4.webviewflow.AuthV4GamerIdView;
import com.hive.authv4.webviewflow.AuthV4SocialView;
import com.hive.authv4.webviewflow.AuthV4TermsView;
import com.hive.authv4.webviewflow.AuthV4WebView;
import com.hive.base.Android;
import com.hive.base.DataModel;
import com.hive.base.EmulatorDetector;
import com.hive.base.Property;
import com.hive.compliance.AgeRange;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.ExtentionsKt;
import com.hive.core.HiveKeys;
import com.hive.core.Platform;
import com.hive.core.StringUtil;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.HiveAuthV4;
import com.hive.module.interfaces.HivePromotion;
import com.hive.module.interfaces.authv4.AdultConfirm;
import com.hive.module.interfaces.authv4.DeviceManagement;
import com.hive.module.interfaces.authv4.GoogleRecaptcha;
import com.hive.module.interfaces.authv4.IdentityVerification;
import com.hive.module.interfaces.authv4.provider.ProviderFuntap;
import com.hive.permission.PermissionImpl;
import com.hive.protocol.UrlManager;
import com.hive.protocol.authv4.Blacklist;
import com.hive.protocol.authv4.Connect;
import com.hive.protocol.authv4.CustomAuthConnect;
import com.hive.protocol.authv4.CustomAuthSignInIdp;
import com.hive.protocol.authv4.Disconnect;
import com.hive.protocol.authv4.GetIdpUid;
import com.hive.protocol.authv4.GetPolicy;
import com.hive.protocol.authv4.Idp;
import com.hive.protocol.authv4.PlayerDelete;
import com.hive.protocol.authv4.SelectIdp;
import com.hive.protocol.authv4.SignIn;
import com.hive.protocol.authv4.SignInIdp;
import com.hive.protocol.authv4.SignInPlayer;
import com.hive.protocol.authv4.SignOut;
import com.hive.protocol.profileapi.Upload;
import com.hive.protocol.provision.AddDownload;
import com.hive.protocol.provision.GetAgreement;
import com.hive.protocol.provision.GetMaintenance;
import com.hive.protocol.provision.Integration;
import com.hive.protocol.provision.MetadataInitInteraction;
import com.hive.push.PushImpl;
import com.hive.social.HiveGraph;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge;
import io.ktor.http.ContentDisposition;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.io.files.FileSystemKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Ú\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002ú\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0007J\u0010\u0010.\u001a\u00020+2\b\u0010/\u001a\u0004\u0018\u00010\nJ\b\u00100\u001a\u00020+H\u0002J\u000e\u00101\u001a\u00020+H\u0082@¢\u0006\u0002\u00102J\u0010\u00103\u001a\u00020+2\u0006\u00104\u001a\u000205H\u0002J(\u00106\u001a\u00020\f2\u001e\u00107\u001a\u001a\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0\u001508H\u0002J.\u0010<\u001a\u00020\f2\u001e\u00107\u001a\u001a\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0\u001508H\u0082@¢\u0006\u0002\u0010=J8\u0010>\u001a\u00020\f2(\u00107\u001a$\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020?\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020;0\u0015j\b\u0012\u0004\u0012\u00020;`\u001708H\u0082@¢\u0006\u0002\u0010=J0\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u0002052\u0016\u0010C\u001a\u0012\u0012\u0004\u0012\u00020;0\u0015j\b\u0012\u0004\u0012\u00020;`\u00172\u0006\u0010,\u001a\u00020DH\u0002J\u001e\u0010E\u001a\u00020+2\u0006\u0010F\u001a\u00020G2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\f0IH\u0002J.\u0010J\u001a\u00020+2\u0016\u0010K\u001a\u0012\u0012\u0004\u0012\u00020L0\u0015j\b\u0012\u0004\u0012\u00020L`\u00172\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\f0IH\u0002J\u0016\u0010M\u001a\u00020+2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\f0IH\u0002J\u001e\u0010N\u001a\u00020+2\u0006\u0010O\u001a\u00020P2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\f0IH\u0002J(\u0010Q\u001a\u00020+2\u001e\u00107\u001a\u001a\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020R\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0\u001508H\u0002J\u0010\u0010S\u001a\u00020+2\u0006\u0010T\u001a\u00020\fH\u0002J.\u0010U\u001a\u00020\f2\u001e\u00107\u001a\u001a\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020R\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0\u001508H\u0082@¢\u0006\u0002\u0010=J\u0010\u0010V\u001a\u00020+2\u0006\u0010W\u001a\u000209H\u0002J\u0010\u0010X\u001a\u00020+2\u0006\u0010Y\u001a\u00020ZH\u0002J(\u0010[\u001a\u00020\f2\u001e\u00107\u001a\u001a\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\\\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u001508H\u0002J\b\u0010]\u001a\u00020+H\u0002J\u0018\u0010^\u001a\u00020+2\u0006\u0010_\u001a\u00020\u00162\b\u0010,\u001a\u0004\u0018\u00010`J$\u0010^\u001a\u00020+2\u0006\u0010_\u001a\u00020\u00162\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u001e2\b\u0010,\u001a\u0004\u0018\u00010`J.\u0010^\u001a\u00020+2\u0006\u0010_\u001a\u00020\u00162\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010b\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010`J\u001e\u0010c\u001a\u00020+2\u0006\u0010b\u001a\u00020\f2\u0006\u0010d\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010eJ\b\u0010f\u001a\u00020\fH\u0002J\"\u0010g\u001a\u00020+2\u0006\u0010h\u001a\u00020\u001e2\b\u0010i\u001a\u0004\u0018\u00010\u001e2\u0006\u0010,\u001a\u00020`H\u0002J\"\u0010j\u001a\u00020+2\b\u0010k\u001a\u0004\u0018\u00010\u001c2\u0006\u0010h\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020`H\u0002J \u0010l\u001a\u00020+2\u0006\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010`J \u0010p\u001a\u00020+2\u0006\u0010h\u001a\u00020\u001e2\u0006\u0010_\u001a\u00020\u00162\u0006\u0010,\u001a\u00020`H\u0002J \u0010q\u001a\u00020+2\u0006\u0010r\u001a\u00020s2\u0006\u0010h\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020`H\u0002J(\u0010t\u001a\u00020+2\u0006\u0010r\u001a\u00020s2\u0006\u0010u\u001a\u00020\u001e2\u0006\u0010h\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020`H\u0002J\u001a\u0010v\u001a\u00020+2\b\u0010w\u001a\u0004\u0018\u00010\u001e2\b\u0010,\u001a\u0004\u0018\u00010`J \u0010q\u001a\u00020+2\u0006\u0010w\u001a\u00020\u001e2\u0006\u0010h\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020`H\u0002J(\u0010x\u001a\u00020+2\u0006\u0010w\u001a\u00020\u001e2\u0006\u0010u\u001a\u00020\u001e2\u0006\u0010h\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020`H\u0002J\u0010\u0010y\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010zJ\u001a\u0010{\u001a\u00020+2\u0006\u0010h\u001a\u00020\u001e2\b\u0010,\u001a\u0004\u0018\u00010zH\u0002J\u000e\u0010|\u001a\u000205H\u0082@¢\u0006\u0002\u00102J\u0010\u0010}\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010zJ\u001a\u0010~\u001a\u00020+2\b\u0010_\u001a\u0004\u0018\u00010\u00162\b\u0010,\u001a\u0004\u0018\u00010\u007fJ,\u0010\u0080\u0001\u001a\u00020+2\u0007\u0010\u0081\u0001\u001a\u00020\u001c2\u0006\u0010r\u001a\u00020s2\u0006\u0010h\u001a\u00020\u001e2\b\u0010,\u001a\u0004\u0018\u00010\u007fH\u0002J\u001b\u0010\u0082\u0001\u001a\u00020+2\b\u0010w\u001a\u0004\u0018\u00010\u001e2\b\u0010,\u001a\u0004\u0018\u00010\u007fJ,\u0010\u0083\u0001\u001a\u00020+2\u0007\u0010\u0081\u0001\u001a\u00020\u001c2\u0006\u0010w\u001a\u00020\u001e2\u0006\u0010h\u001a\u00020\u001e2\b\u0010,\u001a\u0004\u0018\u00010\u007fH\u0002J\u001c\u0010\u0084\u0001\u001a\u00020+2\b\u0010_\u001a\u0004\u0018\u00010\u00162\t\u0010,\u001a\u0005\u0018\u00010\u0085\u0001J\u001d\u0010\u0084\u0001\u001a\u00020+2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u001e2\t\u0010,\u001a\u0005\u0018\u00010\u0085\u0001J\u001a\u0010\u0087\u0001\u001a\u00020+2\u0007\u0010\u0088\u0001\u001a\u00020n2\b\u0010,\u001a\u0004\u0018\u00010`J5\u0010\u0089\u0001\u001a\u00020+2\u0007\u0010\u0081\u0001\u001a\u00020\u001c2\u0007\u0010\u008a\u0001\u001a\u00020\u001c2\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\u0006\u0010h\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020`H\u0002J7\u0010\u008d\u0001\u001a\u00020+2\u0007\u0010\u0081\u0001\u001a\u00020\u001c2\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u001e2\u0006\u0010h\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020`H\u0002J\u0012\u0010\u008f\u0001\u001a\u00020+2\t\u0010,\u001a\u0005\u0018\u00010\u0090\u0001J/\u0010\u0091\u0001\u001a\u00020+2\u001b\u0010\u0092\u0001\u001a\u0016\u0012\u0004\u0012\u00020n\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020n\u0018\u0001`\u00172\t\u0010,\u001a\u0005\u0018\u00010\u0093\u0001J\u0011\u0010\u0094\u0001\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010`JC\u0010\u0095\u0001\u001a\u00020+2\u0017\u0010\u0096\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u001e\u0012\u0005\u0012\u00030\u0098\u0001\u0018\u00010\u0097\u00012\u0017\u0010\u0099\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u001e\u0012\u0005\u0012\u00030\u0098\u0001\u0018\u00010\u0097\u00012\b\u0010,\u001a\u0004\u0018\u00010`J\u001c\u0010\u009a\u0001\u001a\u00020+2\u0006\u0010m\u001a\u00020n2\t\u0010,\u001a\u0005\u0018\u00010\u009b\u0001H\u0016J5\u0010\u009c\u0001\u001a\u00020+2\u0006\u0010h\u001a\u00020\u001e2\b\u0010\u009d\u0001\u001a\u00030\u009e\u00012\u0006\u0010k\u001a\u00020\u001c2\u0007\u0010\u009f\u0001\u001a\u00020n2\u0007\u0010,\u001a\u00030\u009b\u0001H\u0002J\u0014\u0010 \u0001\u001a\u00020+2\t\u0010,\u001a\u0005\u0018\u00010¡\u0001H\u0016J\u001a\u0010¢\u0001\u001a\u00020+2\u0006\u0010h\u001a\u00020\u001e2\u0007\u0010,\u001a\u00030¡\u0001H\u0002J\u0014\u0010£\u0001\u001a\u00020+2\t\u0010,\u001a\u0005\u0018\u00010¤\u0001H\u0016J\u001a\u0010¥\u0001\u001a\u00020+2\u0006\u0010h\u001a\u00020\u001e2\u0007\u0010,\u001a\u00030¤\u0001H\u0002J\u001b\u0010¦\u0001\u001a\u00020+2\u0007\u0010§\u0001\u001a\u00020\u001e2\t\u0010,\u001a\u0005\u0018\u00010¨\u0001J#\u0010©\u0001\u001a\u00020+2\u0006\u0010h\u001a\u00020\u001e2\u0007\u0010§\u0001\u001a\u00020\u001e2\u0007\u0010,\u001a\u00030¨\u0001H\u0002J\u0012\u0010ª\u0001\u001a\u00020+2\t\u0010,\u001a\u0005\u0018\u00010«\u0001J\u0014\u0010¬\u0001\u001a\u00020+2\t\u0010,\u001a\u0005\u0018\u00010\u00ad\u0001H\u0007J\u0012\u0010®\u0001\u001a\u00020+2\t\u0010,\u001a\u0005\u0018\u00010¯\u0001J\u001b\u0010°\u0001\u001a\u00020+2\b\u0010_\u001a\u0004\u0018\u00010\u00162\b\u0010,\u001a\u0004\u0018\u00010$J\u001b\u0010±\u0001\u001a\u00020+2\u0007\u0010²\u0001\u001a\u00020\f2\t\u0010,\u001a\u0005\u0018\u00010³\u0001J\u001b\u0010´\u0001\u001a\u00020+2\u0007\u0010²\u0001\u001a\u00020\f2\t\u0010,\u001a\u0005\u0018\u00010³\u0001J!\u0010µ\u0001\u001a\u00020+2\u0006\u0010k\u001a\u00020\u001c2\u000e\u0010¶\u0001\u001a\t\u0012\u0004\u0012\u00020+0·\u0001H\u0002J\u0011\u0010¸\u0001\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010$J\u0007\u0010¹\u0001\u001a\u00020+J\u000f\u0010º\u0001\u001a\u00020+H\u0000¢\u0006\u0003\b»\u0001J\u0007\u0010¼\u0001\u001a\u00020+J\u001a\u0010½\u0001\u001a\u00020+2\u0006\u0010_\u001a\u00020\u00162\t\u0010,\u001a\u0005\u0018\u00010¾\u0001J\u0010\u0010¿\u0001\u001a\u00020+2\u0007\u0010,\u001a\u00030À\u0001J\u0012\u0010Á\u0001\u001a\u00020+2\t\u0010,\u001a\u0005\u0018\u00010Â\u0001J\u0012\u0010Ã\u0001\u001a\u00020+2\t\u0010,\u001a\u0005\u0018\u00010Ä\u0001J\u001a\u0010Å\u0001\u001a\u00020+2\u0006\u0010m\u001a\u00020n2\t\u0010,\u001a\u0005\u0018\u00010Æ\u0001J%\u0010Ç\u0001\u001a\u00020+2\u0007\u0010È\u0001\u001a\u0002092\u0006\u0010h\u001a\u00020\u001e2\t\u0010,\u001a\u0005\u0018\u00010Ä\u0001H\u0002JA\u0010É\u0001\u001a\u00020+2\u0006\u0010k\u001a\u00020\u001c2\u0006\u0010r\u001a\u00020s2&\u0010¶\u0001\u001a!\u0012\u0016\u0012\u001409¢\u0006\u000f\bË\u0001\u0012\n\bÌ\u0001\u0012\u0005\b\b(È\u0001\u0012\u0004\u0012\u00020+0Ê\u0001H\u0002J\u0010\u0010Í\u0001\u001a\u00020+2\u0007\u0010,\u001a\u00030Î\u0001J\u0019\u0010Ï\u0001\u001a\u00020+2\u0007\u0010Ð\u0001\u001a\u00020\f2\u0007\u0010,\u001a\u00030Ñ\u0001J\u0019\u0010Ò\u0001\u001a\u00020+2\u0007\u0010Ó\u0001\u001a\u00020\f2\u0007\u0010,\u001a\u00030Ô\u0001J\u0010\u0010Õ\u0001\u001a\u00020+2\u0007\u0010,\u001a\u00030Ö\u0001J\u0019\u0010×\u0001\u001a\u00020+2\u0007\u0010Ø\u0001\u001a\u00020\u001e2\u0007\u0010,\u001a\u00030Ö\u0001JA\u0010Ù\u0001\u001a\u00020+2\u0006\u0010W\u001a\u0002092\u0006\u0010\r\u001a\u00020\f2\t\u0010Ú\u0001\u001a\u0004\u0018\u00010\u001e2\u001b\u0010Û\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0017H\u0002J\u0012\u0010Ü\u0001\u001a\u00020+2\u0007\u0010Ý\u0001\u001a\u000209H\u0002J.\u0010Þ\u0001\u001a\u00020+2\u0007\u0010ß\u0001\u001a\u0002092\b\u0010k\u001a\u0004\u0018\u00010\u001c2\u0006\u0010h\u001a\u00020\u001e2\b\u0010,\u001a\u0004\u0018\u00010`H\u0002J$\u0010à\u0001\u001a\u00020+2\u0007\u0010È\u0001\u001a\u0002092\u0006\u0010h\u001a\u00020\u001e2\b\u0010,\u001a\u0004\u0018\u00010zH\u0002J/\u0010á\u0001\u001a\u00020+2\u0007\u0010â\u0001\u001a\u0002092\t\u0010ã\u0001\u001a\u0004\u0018\u00010\u001c2\u0006\u0010h\u001a\u00020\u001e2\b\u0010,\u001a\u0004\u0018\u00010\u007fH\u0002J%\u0010ä\u0001\u001a\u00020+2\u0007\u0010È\u0001\u001a\u0002092\u0006\u0010h\u001a\u00020\u001e2\t\u0010,\u001a\u0005\u0018\u00010\u0085\u0001H\u0002J0\u0010å\u0001\u001a\u00020+2\u0007\u0010È\u0001\u001a\u0002092\n\u0010æ\u0001\u001a\u0005\u0018\u00010\u008c\u00012\u0006\u0010h\u001a\u00020\u001e2\b\u0010,\u001a\u0004\u0018\u00010$H\u0002J\u0011\u0010ç\u0001\u001a\u00020+2\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001J\u0011\u0010è\u0001\u001a\u00020+2\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001J\u000f\u0010é\u0001\u001a\u00020+2\u0006\u0010k\u001a\u00020\u001cJ\u0019\u0010ê\u0001\u001a\u00020+2\u0010\u0010ë\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u001e\u0018\u00010ì\u0001J\u0007\u0010í\u0001\u001a\u00020+J$\u0010î\u0001\u001a\u00030ï\u00012\u0007\u0010ð\u0001\u001a\u00020;2\u0007\u0010ñ\u0001\u001a\u00020\u001e2\b\u0010ò\u0001\u001a\u00030ó\u0001J\u0013\u0010ô\u0001\u001a\u00020Z2\b\u0010õ\u0001\u001a\u00030ö\u0001H\u0002J\t\u0010÷\u0001\u001a\u00020+H\u0002J\u0018\u0010ø\u0001\u001a\u0002092\u0006\u0010m\u001a\u00020\u001eH\u0082@¢\u0006\u0003\u0010ù\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R>\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u00172\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000¨\u0006û\u0001"}, d2 = {"Lcom/hive/authv4/AuthV4Impl;", "Lcom/hive/module/interfaces/HiveAuthV4;", "<init>", "()V", "defaultDispatcher", "Lkotlin/coroutines/CoroutineContext;", "ioDispatcher", "setupScope", "Lkotlinx/coroutines/CoroutineScope;", "internalAuthV4SetupListener", "Lcom/hive/AuthV4$AuthV4SetupListener;", "value", "", "isAutoSignIn", "()Z", "isSetup", "isInProgressSetup", "isInProgressSign", "isInProgressTerms", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInProgressDeletePlayerId", "Ljava/util/ArrayList;", "Lcom/hive/AuthV4$ProviderType;", "Lkotlin/collections/ArrayList;", "idpList", "getIdpList", "()Ljava/util/ArrayList;", "recentConflictPlayerInfo", "Lcom/hive/AuthV4$PlayerInfo;", "recentCustomSignInAuthKey", "", "recentIdentity", "Lcom/hive/module/interfaces/authv4/IdentityVerification$Identity;", "mainLooperHandler", "Landroid/os/Handler;", "checkProviderListener", "Lcom/hive/AuthV4$AuthV4CheckProviderListener;", "getCheckProviderListener", "()Lcom/hive/AuthV4$AuthV4CheckProviderListener;", "setCheckProviderListener", "(Lcom/hive/AuthV4$AuthV4CheckProviderListener;)V", "AUTHV4_AGREEMENT_ACTION", "requestPermissionViewData", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/Permission$PermissionViewDataListener;", "setup", "setupListener", "checkEmulator", "requestProvisionDownload", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestNoticePopupSettleBill", "noticeType", "", "setMetadataToConfiguration", "triple", "Lkotlin/Triple;", "Lcom/hive/ResultAPI;", "Lcom/hive/protocol/provision/MetadataInitInteraction;", "Lcom/hive/AuthV4$AuthV4MaintenanceInfo;", "processProvisionBlockedCountry", "(Lkotlin/Triple;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processAgreementWithMaintenance", "Lcom/hive/protocol/provision/GetAgreement;", "createMaintenanceRunnable", "Ljava/lang/Runnable;", FirebaseAnalytics.Param.INDEX, "maintenanceInfoList", "Lcom/hive/auth/MaintenanceDialog$OnDismissListener;", "processAgreement", "responseProvisionGetAgreement", "Lcom/hive/protocol/provision/GetAgreement$GetAgreementResponse;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "onAgreementUiResult", "agreementList", "Lcom/hive/authv4/AuthV4Impl$Agreement;", "onAgreementNotShowFinish", "onAgreementFinish", "agreementJsonArray", "Lorg/json/JSONArray;", "processProvisionIntegration", "Lcom/hive/protocol/provision/Integration;", "requestPromotionDownloadInfo", "isAgreementDetermineBaseAccount", "processProvisionIntegrationMaintenance", "onAgreementFail", "resultAPI", "onMaintenanceFail", "buttonAction", "Lcom/hive/auth/MaintenanceDialog$MaintenanceActionType;", "processGetIDPList", "Lcom/hive/protocol/authv4/Idp;", "processSignInType", "signIn", "providerType", "Lcom/hive/AuthV4$AuthV4SignInListener;", "tokenFromWeb", "reSignIn", "handleSignOutNeeded", "prevEnableAutoLogin", "(ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isRecaptchaEnable", "internalSignInGuest", "fApiName", "recaptchaToken", "internalSignInPlayer", "playerInfo", "signInWithStoredPlayerId", "playerId", "", "useAutoSignIn", "signInProvider", "processGamerId", "provider", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter;", "internalSignInProvider", "player", "signInWithAuthKey", "authKey", "internalCustomSignInProvider", "signOut", "Lcom/hive/AuthV4$AuthV4SignOutListener;", "internalSignOut", "internalSignOutAwait", "playerDelete", "connect", "Lcom/hive/AuthV4$AuthV4ConnectListener;", "internalConnect", "localPlayerInfo", "connectWithAuthKey", "internalCustomConnect", "disconnect", "Lcom/hive/AuthV4$AuthV4DisconnectListener;", "providerName", "selectConflict", "selectedPlayerId", "internalSelectConflictBind", "localRecentConflictPlayerInfo", "conflictProviderInfo", "Lcom/hive/AuthV4$ProviderInfo;", "internalSelectConflictSwitch", "customSignInAuthKey", "resolveConflict", "Lcom/hive/AuthV4$AuthV4ResolveConflictListener;", "getProfile", "playerIdList", "Lcom/hive/AuthV4$AuthV4GetProfileListener;", "showSignIn", "showConflictSelection", "currentPlayerData", "", "", "conflictPlayerData", "showProfile", "Lcom/hive/AuthV4$AuthV4ShowProfileListener;", "internalShowProfile", "activity", "Landroid/app/Activity;", "targetPlayerId", "showInquiry", "Lcom/hive/AuthV4$AuthV4ShowInquiryListener;", "internalShowInquiry", "showMyInquiry", "Lcom/hive/AuthV4$AuthV4ShowMyInquiryListener;", "internalShowMyInquiry", "showChatbotInquiry", "additionalInfo", "Lcom/hive/AuthV4$AuthV4ShowChatbotInquiryListener;", "internalShowChatbotInquiry", "showTerms", "Lcom/hive/AuthV4$AuthV4ShowTermsListener;", "showAdultConfirm", "Lcom/hive/AuthV4$AuthV4AdultConfirmListener;", "showIdentityVerification", "Lcom/hive/AuthV4$AuthV4ShowIdentityVerificationListener;", "checkProvider", "checkMaintenance", "isShow", "Lcom/hive/AuthV4$AuthV4MaintenanceListener;", "checkBlacklist", "checkGDPRAgreement", "callback", "Lkotlin/Function0;", "setProviderChangedListener", "reset", "memoryReset", "memoryReset$hive_service_release", "resetAgreement", "getProviderFriendsList", "Lcom/hive/AuthV4$AuthV4ProviderFriendsListener;", "showDeviceManagement", "Lcom/hive/AuthV4$AuthV4ShowDeviceManagementListener;", "getStoredPlayerIdList", "Lcom/hive/AuthV4$AuthV4PlayerIdListListener;", "storeCurrentPlayerId", "Lcom/hive/AuthV4$AuthV4StorePlayerIdListener;", "deleteStoredPlayerId", "Lcom/hive/AuthV4$AuthV4DeletePlayerIdListener;", "internalStorePlayerId", "result", "uploadProfile", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "getHashedDi", "Lcom/hive/AuthV4$AuthV4GetHashedDiListener;", "checkAgeGate", "useCloseButton", "Lcom/hive/AuthV4$AuthV4AgeGateListener;", "setAutoLoginEnabled", "enabled", "Lcom/hive/AuthV4$AuthV4SetAutoLoginEnabledListener;", "getAgeRange", "Lcom/hive/AuthV4$AuthV4GetAgeRangeListener;", "showAgeRangeUpdatePermission", "description", "onSetupFinish", "did", "providerTypeList", "onSetupFail", "resultApi", "onSignInFinish", "signInResult", "onSignOutFinish", "onConnectFinish", "connectResult", "conflictPlayer", "onDisconnectFinish", "onCheckProviderFinish", "providerInfo", "onStart", "onStop", "setRecentConflictPlayerInfo", "setFacebookPermission", "permission", "", "onSetupCanceled", "getMaintenanceModel", "Lcom/hive/auth/MaintenanceDialog$MaintenanceModel;", "authV4MaintenanceInfo", "htmlMessage", "maintenanceDialogType", "Lcom/hive/auth/MaintenanceDialog$MaintenanceDialogType;", "getMaintenanceActionType", "authV4MaintenanceActionType", "Lcom/hive/AuthV4$AuthV4MaintenanceActionType;", "printLogRefSDKVersion", "startFuntapInspection", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Agreement", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4Impl implements HiveAuthV4 {
    public static final String AUTHV4_AGREEMENT_ACTION = "com.hive.authv4.AUTHV4_AGREEMENT";
    public static final AuthV4Impl INSTANCE = new AuthV4Impl();
    private static AuthV4.AuthV4CheckProviderListener checkProviderListener;
    private static final CoroutineContext defaultDispatcher;
    private static ArrayList<AuthV4.ProviderType> idpList;
    private static AuthV4.AuthV4SetupListener internalAuthV4SetupListener;
    private static final CoroutineContext ioDispatcher;
    private static boolean isAutoSignIn;
    private static boolean isInProgressDeletePlayerId;
    private static boolean isInProgressSetup;
    private static boolean isInProgressSign;
    private static AtomicBoolean isInProgressTerms;
    private static boolean isSetup;
    private static final Handler mainLooperHandler;
    private static AuthV4.PlayerInfo recentConflictPlayerInfo;
    private static String recentCustomSignInAuthKey;
    private static IdentityVerification.Identity recentIdentity;
    private static final CoroutineScope setupScope;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

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
            int[] iArr2 = new int[AuthV4.ProviderType.values().length];
            try {
                iArr2[AuthV4.ProviderType.FACEBOOK.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[AuthV4.ProviderType.VK.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ResultAPI.Code.values().length];
            try {
                iArr3[ResultAPI.Code.AuthV4MaintenanceTimeover_DoExit.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[ResultAPI.Code.AuthV4MaintenanceActionOpenURL_DoExit.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[ResultAPI.Code.AuthV4MaintenanceActionExit_DoExit.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[ResultAPI.Code.AuthV4MaintenanceActionDefault_DoExit.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[AuthV4.AuthV4MaintenanceActionType.values().length];
            try {
                iArr4[AuthV4.AuthV4MaintenanceActionType.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr4[AuthV4.AuthV4MaintenanceActionType.TIMEOVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr4[AuthV4.AuthV4MaintenanceActionType.OPEN_URL.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr4[AuthV4.AuthV4MaintenanceActionType.EXIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr4[AuthV4.AuthV4MaintenanceActionType.DONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    /* JADX INFO: renamed from: com.hive.authv4.AuthV4Impl$getAgeRange$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.authv4.AuthV4Impl$getAgeRange$1", f = "AuthV4Impl.kt", i = {}, l = {5994, 5389}, m = "invokeSuspend", n = {}, s = {})
    public static final class C28241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AuthV4.AuthV4GetAgeRangeListener $listener;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: com.hive.authv4.AuthV4Impl$getAgeRange$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.authv4.AuthV4Impl$getAgeRange$1$2", f = "AuthV4Impl.kt", i = {}, l = {5390}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ AuthV4.AuthV4GetAgeRangeListener $listener;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(AuthV4.AuthV4GetAgeRangeListener authV4GetAgeRangeListener, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$listener = authV4GetAgeRangeListener;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$listener, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AgeRange ageRange = AgeRange.INSTANCE;
                    this.label = 1;
                    obj = ageRange.getAgeRange((Continuation<? super Pair<ResultAPI, AuthV4.AgeRange>>) this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Pair pair = (Pair) obj;
                LoggerImpl.INSTANCE.dL("[AuthV4] getAgeRange: " + pair.getFirst() + "                      " + pair.getSecond());
                this.$listener.onAuthV4GetAgeRange((ResultAPI) pair.getFirst(), (AuthV4.AgeRange) pair.getSecond());
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28241(AuthV4.AuthV4GetAgeRangeListener authV4GetAgeRangeListener, Continuation<? super C28241> continuation) {
            super(2, continuation);
            this.$listener = authV4GetAgeRangeListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28241(this.$listener, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0071, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r8, r1, r7) == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r8)
                goto L74
            L12:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1a:
                java.lang.Object r1 = r7.L$0
                com.hive.core.Configuration r1 = (com.hive.core.Configuration) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L54
            L22:
                kotlin.ResultKt.throwOnFailure(r8)
                com.hive.core.Configuration r1 = com.hive.core.Configuration.INSTANCE
                r7.L$0 = r1
                r7.label = r3
                kotlinx.coroutines.CancellableContinuationImpl r8 = new kotlinx.coroutines.CancellableContinuationImpl
                kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r7)
                r8.<init>(r4, r3)
                r8.initCancellability()
                com.hive.configuration.ConfigurationImpl r3 = com.hive.configuration.ConfigurationImpl.INSTANCE
                com.hive.authv4.AuthV4Impl$getAgeRange$1$1$1 r4 = new com.hive.authv4.AuthV4Impl$getAgeRange$1$1$1
                r4.<init>()
                java.lang.String r5 = "app_store_accountability_act"
                r6 = 0
                r3.getMetaData(r5, r6, r4)
                java.lang.Object r8 = r8.getResult()
                java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                if (r8 != r3) goto L51
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r7)
            L51:
                if (r8 != r0) goto L54
                goto L73
            L54:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                r1.setUsedAgeRange(r8)
                kotlinx.coroutines.MainCoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getMain()
                com.hive.authv4.AuthV4Impl$getAgeRange$1$2 r1 = new com.hive.authv4.AuthV4Impl$getAgeRange$1$2
                com.hive.AuthV4$AuthV4GetAgeRangeListener r3 = r7.$listener
                r4 = 0
                r1.<init>(r3, r4)
                r7.L$0 = r4
                r7.label = r2
                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r1, r7)
                if (r8 != r0) goto L74
            L73:
                return r0
            L74:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.AuthV4Impl.C28241.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28241) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.hive.authv4.AuthV4Impl$handleSignOutNeeded$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.authv4.AuthV4Impl", f = "AuthV4Impl.kt", i = {}, l = {1557}, m = "handleSignOutNeeded", n = {}, s = {})
    public static final class C28251 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C28251(Continuation<? super C28251> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AuthV4Impl.this.handleSignOutNeeded(false, false, this);
        }
    }

    /* JADX INFO: renamed from: com.hive.authv4.AuthV4Impl$onConnectFinish$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"com/hive/authv4/AuthV4Impl$onConnectFinish$1", "Lcom/hive/AuthV4$AuthV4GetProfileListener;", "onAuthV4GetProfile", "", "result", "Lcom/hive/ResultAPI;", "profileInfoList", "Ljava/util/ArrayList;", "Lcom/hive/AuthV4$ProfileInfo;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C28311 implements AuthV4.AuthV4GetProfileListener {
        final /* synthetic */ AuthV4.PlayerInfo $conflictPlayer;
        final /* synthetic */ ResultAPI $connectResult;
        final /* synthetic */ String $fApiName;
        final /* synthetic */ AuthV4.AuthV4ConnectListener $listener;
        final /* synthetic */ AuthV4.PlayerInfo $localPlayerInfo;

        public C28311(AuthV4.PlayerInfo playerInfo, String str, ResultAPI resultAPI, AuthV4.AuthV4ConnectListener authV4ConnectListener, AuthV4.PlayerInfo playerInfo2) {
            this.$localPlayerInfo = playerInfo;
            this.$fApiName = str;
            this.$connectResult = resultAPI;
            this.$listener = authV4ConnectListener;
            this.$conflictPlayer = playerInfo2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onAuthV4GetProfile$lambda$0(String str, ResultAPI resultAPI, AuthV4.AuthV4ConnectListener authV4ConnectListener, AuthV4.PlayerInfo playerInfo) {
            LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
            if (authV4ConnectListener != null) {
                authV4ConnectListener.onAuthV4Connect(resultAPI, playerInfo);
            }
        }

        @Override // com.hive.AuthV4.AuthV4GetProfileListener
        public void onAuthV4GetProfile(ResultAPI result, ArrayList<AuthV4.ProfileInfo> profileInfoList) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (result.isSuccess() && profileInfoList != null) {
                AuthV4.ProfileInfo profileInfo = profileInfoList.get(0);
                Intrinsics.checkNotNullExpressionValue(profileInfo, "get(...)");
                AuthV4.ProfileInfo profileInfo2 = profileInfo;
                if (this.$localPlayerInfo.getPlayerId() == profileInfo2.getPlayerId()) {
                    this.$localPlayerInfo.setPlayerName(profileInfo2.getPlayerName());
                    this.$localPlayerInfo.setPlayerImageUrl(profileInfo2.getPlayerImageUrl());
                    AuthV4Account.INSTANCE.writePlayerInfo(this.$localPlayerInfo);
                }
            }
            Handler handler = AuthV4Impl.mainLooperHandler;
            final String str = this.$fApiName;
            final ResultAPI resultAPI = this.$connectResult;
            final AuthV4.AuthV4ConnectListener authV4ConnectListener = this.$listener;
            final AuthV4.PlayerInfo playerInfo = this.$conflictPlayer;
            handler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$onConnectFinish$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.C28311.onAuthV4GetProfile$lambda$0(str, resultAPI, authV4ConnectListener, playerInfo);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.hive.authv4.AuthV4Impl$onSignInFinish$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.authv4.AuthV4Impl$onSignInFinish$1", f = "AuthV4Impl.kt", i = {0, 1, 1, 2, 3, 4, 4, 5, 5, 6}, l = {5505, 5994, 5535, PlaybackException.ERROR_CODE_DRM_DEVICE_REVOKED, 5612, 6022, 6035, 6048, 5742, 5753}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "agreementDetermineBasePlayerCompletion", "$this$launch", "$this$launch", "$this$launch", "identity", "$this$launch", "identity", "$this$launch"}, s = {"L$0", "L$0", "L$1", "L$0", "L$0", "L$0", "L$1", "L$0", "L$1", "L$0"})
    public static final class C28321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $fApiName;
        final /* synthetic */ AuthV4.AuthV4SignInListener $listener;
        final /* synthetic */ AuthV4.PlayerInfo $playerInfo;
        final /* synthetic */ ResultAPI $signInResult;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX INFO: renamed from: com.hive.authv4.AuthV4Impl$onSignInFinish$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.authv4.AuthV4Impl$onSignInFinish$1$1", f = "AuthV4Impl.kt", i = {0}, l = {5536}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"})
        public static final class C03501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ AuthV4.PlayerInfo $playerInfo;
            final /* synthetic */ JSONObject $sentPlayerList;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C03501(AuthV4.PlayerInfo playerInfo, JSONObject jSONObject, Continuation<? super C03501> continuation) {
                super(2, continuation);
                this.$playerInfo = playerInfo;
                this.$sentPlayerList = jSONObject;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C03501 c03501 = new C03501(this.$playerInfo, this.$sentPlayerList, continuation);
                c03501.L$0 = obj;
                return c03501;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    AuthV4Network.Provision provision = AuthV4Network.Provision.INSTANCE;
                    AuthV4.PlayerInfo playerInfo = this.$playerInfo;
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    obj = provision.addSetInfo$hive_service_release(playerInfo, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                JSONObject jSONObject = this.$sentPlayerList;
                AuthV4.PlayerInfo playerInfo2 = this.$playerInfo;
                if (((ResultAPI) obj).isSuccess()) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        jSONObject.put(String.valueOf(playerInfo2.getPlayerId()), "");
                        Property.Companion companion2 = Property.INSTANCE;
                        Property.setValue$default(companion2.getINSTANCE(), AuthV4Keys.AGREEMENT_SENT_PLAYER_LIST, jSONObject.toString(), null, 4, null);
                        Result.m7415constructorimpl(Boxing.boxBoolean(companion2.getINSTANCE().writeProperties()));
                    } catch (Throwable th) {
                        Result.Companion companion3 = Result.INSTANCE;
                        Result.m7415constructorimpl(ResultKt.createFailure(th));
                    }
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C03501) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: renamed from: com.hive.authv4.AuthV4Impl$onSignInFinish$1$11, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.authv4.AuthV4Impl$onSignInFinish$1$11", f = "AuthV4Impl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass11 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $fApiName;
            final /* synthetic */ AuthV4.AuthV4SignInListener $listener;
            final /* synthetic */ AuthV4.PlayerInfo $playerInfo;
            final /* synthetic */ ResultAPI $signInResult;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass11(String str, ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo, AuthV4.AuthV4SignInListener authV4SignInListener, Continuation<? super AnonymousClass11> continuation) {
                super(2, continuation);
                this.$fApiName = str;
                this.$signInResult = resultAPI;
                this.$playerInfo = playerInfo;
                this.$listener = authV4SignInListener;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass11(this.$fApiName, this.$signInResult, this.$playerInfo, this.$listener, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
                AuthV4Account authV4Account = AuthV4Account.INSTANCE;
                hiveLifecycle.onSignIn(authV4Account.toHiveAccount());
                LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), this.$fApiName, this.$signInResult.toString());
                authV4Account.writeOfflineSignInFinish(String.valueOf(this.$playerInfo.getPlayerId()));
                authV4Account.writeAutoLoginEnabled();
                AuthV4.AuthV4SignInListener authV4SignInListener = this.$listener;
                if (authV4SignInListener != null) {
                    authV4SignInListener.onAuthV4SignIn(this.$signInResult, this.$playerInfo);
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass11) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: renamed from: com.hive.authv4.AuthV4Impl$onSignInFinish$1$7, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.authv4.AuthV4Impl$onSignInFinish$1$7", f = "AuthV4Impl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            public AnonymousClass7(Continuation<? super AnonymousClass7> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass7(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                AuthV4Impl.INSTANCE.requestPromotionDownloadInfo(true);
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28321(AuthV4.PlayerInfo playerInfo, AuthV4.AuthV4SignInListener authV4SignInListener, ResultAPI resultAPI, String str, Continuation<? super C28321> continuation) {
            super(2, continuation);
            this.$playerInfo = playerInfo;
            this.$listener = authV4SignInListener;
            this.$signInResult = resultAPI;
            this.$fApiName = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$10(ResultAPI resultAPI) {
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$12(AuthV4.AuthV4SignInListener authV4SignInListener) {
            AuthV4Impl.signIn$default(AuthV4Impl.INSTANCE, AuthV4.ProviderType.AUTO, null, true, authV4SignInListener, 2, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$2(AuthV4.AuthV4SignInListener authV4SignInListener, ResultAPI resultAPI) {
            AuthV4Impl.signIn$default(AuthV4Impl.INSTANCE, AuthV4.ProviderType.AUTO, null, true, authV4SignInListener, 2, null);
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C28321 c28321 = new C28321(this.$playerInfo, this.$listener, this.$signInResult, this.$fApiName, continuation);
            c28321.L$0 = obj;
            return c28321;
        }

        /* JADX WARN: Code restructure failed: missing block: B:165:0x03ec, code lost:
        
            if (r4 == r2) goto L240;
         */
        /* JADX WARN: Code restructure failed: missing block: B:229:0x0570, code lost:
        
            if (r0 == r2) goto L240;
         */
        /* JADX WARN: Code restructure failed: missing block: B:239:0x05ac, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r0, r3, r20) == r2) goto L240;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x00f6, code lost:
        
            if (r8 == r2) goto L240;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x0185, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r9, r10, r20) == r2) goto L240;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x0296, code lost:
        
            if (r8 == r2) goto L240;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:103:0x02c5  */
        /* JADX WARN: Removed duplicated region for block: B:123:0x030c  */
        /* JADX WARN: Removed duplicated region for block: B:124:0x0314  */
        /* JADX WARN: Removed duplicated region for block: B:128:0x032f  */
        /* JADX WARN: Removed duplicated region for block: B:129:0x0336  */
        /* JADX WARN: Removed duplicated region for block: B:170:0x03f8  */
        /* JADX WARN: Removed duplicated region for block: B:175:0x0409  */
        /* JADX WARN: Removed duplicated region for block: B:188:0x047b  */
        /* JADX WARN: Removed duplicated region for block: B:191:0x0494  */
        /* JADX WARN: Removed duplicated region for block: B:206:0x04e5  */
        /* JADX WARN: Removed duplicated region for block: B:220:0x0548  */
        /* JADX WARN: Removed duplicated region for block: B:223:0x054d  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:243:0x05b2  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0106  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x010a  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0194  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x01e5  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x02b4  */
        /* JADX WARN: Type inference failed for: r8v30, types: [T, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 1512
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.AuthV4Impl.C28321.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28321) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.hive.authv4.AuthV4Impl$printLogRefSDKVersion$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.authv4.AuthV4Impl$printLogRefSDKVersion$1", f = "AuthV4Impl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C28341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C28341(Continuation<? super C28341> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28341(continuation);
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
            return ((C28341) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.hive.authv4.AuthV4Impl$resolveConflict$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/hive/authv4/AuthV4Impl$resolveConflict$6", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLogoutListener;", "onProviderLogoutListener", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass6 implements AuthV4ProviderAdapter.ProviderLogoutListener {
        final /* synthetic */ AuthV4.ProviderType $conflictProviderType;
        final /* synthetic */ String $fApiName;
        final /* synthetic */ AuthV4.AuthV4ResolveConflictListener $listener;

        public AnonymousClass6(AuthV4.ProviderType providerType, String str, AuthV4.AuthV4ResolveConflictListener authV4ResolveConflictListener) {
            this.$conflictProviderType = providerType;
            this.$fApiName = str;
            this.$listener = authV4ResolveConflictListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onProviderLogoutListener$lambda$0(String str, ResultAPI resultAPI, AuthV4.AuthV4ResolveConflictListener authV4ResolveConflictListener) {
            LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
            authV4ResolveConflictListener.onAuthV4ResolveConflict(resultAPI);
        }

        @Override // com.hive.authv4.provider.AuthV4ProviderAdapter.ProviderLogoutListener
        public void onProviderLogoutListener(ResultAPI result) {
            Intrinsics.checkNotNullParameter(result, "result");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.w(AuthV4.getTAG(), this.$conflictProviderType + " logout: " + result);
            AuthV4Impl.recentConflictPlayerInfo = null;
            AuthV4Impl.recentCustomSignInAuthKey = null;
            AuthV4Impl.isInProgressSign = false;
            String str = "[resolveConflict] " + this.$conflictProviderType + " Success";
            loggerImpl.w(AuthV4.getTAG(), str);
            final ResultAPI resultAPI = new ResultAPI(0, ResultAPI.Code.Success, str);
            Android android2 = Android.INSTANCE;
            final String str2 = this.$fApiName;
            final AuthV4.AuthV4ResolveConflictListener authV4ResolveConflictListener = this.$listener;
            android2.runOnMainThread(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$resolveConflict$6$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.AnonymousClass6.onProviderLogoutListener$lambda$0(str2, resultAPI, authV4ResolveConflictListener);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.hive.authv4.AuthV4Impl$setup$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.authv4.AuthV4Impl$setup$1", f = "AuthV4Impl.kt", i = {2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9}, l = {319, 330, TTAdConstant.IMAGE_LIST_CODE, 476, 482, 485, 487, 509, 527, 536}, m = "invokeSuspend", n = {"$this$launch", "uiTime", "start$iv", "$this$launch", "uiTime", "getAgreementFlow", "start$iv", "fstStart", "$this$launch", "uiTime", "getAgreementFlow", "start$iv", "fstStart", "$this$launch", "uiTime", "start$iv", "fstStart", "$this$launch", "uiTime", "start$iv", "fstStart", "$this$launch", "uiTime", "idpFlow", "start$iv", "uiTime", "idpFlow", "start$iv", "sndStart", "uiTime", "start$iv"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "J$0", "J$1", "L$0", "L$1", "L$2", "J$0", "J$1", "L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "J$0", "J$1", "L$0", "J$0"})
    public static final class C28381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AuthV4.AuthV4SetupListener $setupListener;
        long J$0;
        long J$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28381(AuthV4.AuthV4SetupListener authV4SetupListener, Continuation<? super C28381> continuation) {
            super(2, continuation);
            this.$setupListener = authV4SetupListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$6$lambda$0() {
            Android.INSTANCE.isEmulator();
            AuthV4Impl.INSTANCE.checkEmulator();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C28381 c28381 = new C28381(this.$setupListener, continuation);
            c28381.L$0 = obj;
            return c28381;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0104, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r2, r4, r23) == r1) goto L81;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0121, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r2, r4, r23) == r1) goto L81;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0241, code lost:
        
            if (r2 == r1) goto L81;
         */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0177  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x017a  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x01ed  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x01f0  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0214  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0217  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0230  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0250 A[PHI: r5 r6 r8 r10
  0x0250: PHI (r5v13 kotlin.jvm.internal.Ref$LongRef) = (r5v11 kotlin.jvm.internal.Ref$LongRef), (r5v14 kotlin.jvm.internal.Ref$LongRef) binds: [B:57:0x022e, B:62:0x024b] A[DONT_GENERATE, DONT_INLINE]
  0x0250: PHI (r6v13 long) = (r6v11 long), (r6v15 long) binds: [B:57:0x022e, B:62:0x024b] A[DONT_GENERATE, DONT_INLINE]
  0x0250: PHI (r8v14 long) = (r8v10 long), (r8v19 long) binds: [B:57:0x022e, B:62:0x024b] A[DONT_GENERATE, DONT_INLINE]
  0x0250: PHI (r10v8 kotlinx.coroutines.CoroutineScope) = (r10v6 kotlinx.coroutines.CoroutineScope), (r10v13 kotlinx.coroutines.CoroutineScope) binds: [B:57:0x022e, B:62:0x024b] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x028e  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x029f  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x02c7 A[PHI: r2 r4 r6 r7 r9
  0x02c7: PHI (r2v47 kotlinx.coroutines.Deferred) = (r2v44 kotlinx.coroutines.Deferred), (r2v50 kotlinx.coroutines.Deferred) binds: [B:73:0x02c4, B:7:0x0022] A[DONT_GENERATE, DONT_INLINE]
  0x02c7: PHI (r4v31 long) = (r4v29 long), (r4v33 long) binds: [B:73:0x02c4, B:7:0x0022] A[DONT_GENERATE, DONT_INLINE]
  0x02c7: PHI (r6v20 kotlin.jvm.internal.Ref$LongRef) = (r6v17 kotlin.jvm.internal.Ref$LongRef), (r6v22 kotlin.jvm.internal.Ref$LongRef) binds: [B:73:0x02c4, B:7:0x0022] A[DONT_GENERATE, DONT_INLINE]
  0x02c7: PHI (r7v12 java.lang.Object) = (r7v9 java.lang.Object), (r7v17 java.lang.Object) binds: [B:73:0x02c4, B:7:0x0022] A[DONT_GENERATE, DONT_INLINE]
  0x02c7: PHI (r9v10 long) = (r9v8 long), (r9v11 long) binds: [B:73:0x02c4, B:7:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:77:0x02d6  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x02d9  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x02ff  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x0302  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 878
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.AuthV4Impl.C28381.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28381) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.hive.authv4.AuthV4Impl$showAgeRangeUpdatePermission$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.authv4.AuthV4Impl$showAgeRangeUpdatePermission$1", f = "AuthV4Impl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C28401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ AuthV4.AuthV4GetAgeRangeListener $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28401(String str, AuthV4.AuthV4GetAgeRangeListener authV4GetAgeRangeListener, Continuation<? super C28401> continuation) {
            super(2, continuation);
            this.$description = str;
            this.$listener = authV4GetAgeRangeListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28401(this.$description, this.$listener, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Pair<ResultAPI, AuthV4.AgeRange> pairShowAgeRangeUpdatePermission = AgeRange.INSTANCE.showAgeRangeUpdatePermission(this.$description);
            LoggerImpl.INSTANCE.d("[AuthV4] showAgeRangeUpdatePermission: " + pairShowAgeRangeUpdatePermission.getFirst() + pairShowAgeRangeUpdatePermission.getSecond());
            this.$listener.onAuthV4GetAgeRange(pairShowAgeRangeUpdatePermission.getFirst(), pairShowAgeRangeUpdatePermission.getSecond());
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28401) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.hive.authv4.AuthV4Impl$signIn$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.authv4.AuthV4Impl$signIn$1", f = "AuthV4Impl.kt", i = {}, l = {1492}, m = "invokeSuspend", n = {}, s = {})
    public static final class C28441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $fApiName;
        final /* synthetic */ AuthV4.AuthV4SignInListener $listener;
        final /* synthetic */ AuthV4.ProviderType $providerType;
        final /* synthetic */ boolean $reSignIn;
        final /* synthetic */ String $tokenFromWeb;
        int label;

        /* JADX INFO: renamed from: com.hive.authv4.AuthV4Impl$signIn$1$WhenMappings */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AuthV4.ProviderType.values().length];
                try {
                    iArr[AuthV4.ProviderType.GUEST.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AuthV4.ProviderType.AUTO.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AuthV4.ProviderType.HIVE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AuthV4.ProviderType.FACEBOOK.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[AuthV4.ProviderType.GOOGLE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[AuthV4.ProviderType.QQ.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[AuthV4.ProviderType.VK.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[AuthV4.ProviderType.WECHAT.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[AuthV4.ProviderType.APPLE.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[AuthV4.ProviderType.SIGNIN_APPLE.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[AuthV4.ProviderType.HUAWEI.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr[AuthV4.ProviderType.FUNTAP.ordinal()] = 12;
                } catch (NoSuchFieldError unused12) {
                }
                try {
                    iArr[AuthV4.ProviderType.STEAM.ordinal()] = 13;
                } catch (NoSuchFieldError unused13) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28441(boolean z, AuthV4.ProviderType providerType, String str, String str2, AuthV4.AuthV4SignInListener authV4SignInListener, Continuation<? super C28441> continuation) {
            super(2, continuation);
            this.$reSignIn = z;
            this.$providerType = providerType;
            this.$tokenFromWeb = str;
            this.$fApiName = str2;
            this.$listener = authV4SignInListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(String str, AuthV4.AuthV4SignInListener authV4SignInListener, int i, String str2) {
            AuthV4Impl.INSTANCE.internalSignInGuest(str, str2, authV4SignInListener);
            Unit unit = Unit.INSTANCE;
            LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[reCAPTCHA] status code: " + i);
            return unit;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28441(this.$reSignIn, this.$providerType, this.$tokenFromWeb, this.$fApiName, this.$listener, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AuthV4Impl authV4Impl = AuthV4Impl.INSTANCE;
                boolean z = this.$reSignIn;
                boolean zSavedAutoLoginEnabled = AuthV4Account.INSTANCE.savedAutoLoginEnabled();
                this.label = 1;
                if (authV4Impl.handleSignOutNeeded(z, zSavedAutoLoginEnabled, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            AuthV4Impl.isInProgressSign = true;
            switch (WhenMappings.$EnumSwitchMapping$0[this.$providerType.ordinal()]) {
                case 1:
                    String str = this.$tokenFromWeb;
                    if (str == null || StringsKt.isBlank(str)) {
                        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
                        String name = GoogleRecaptcha.class.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
                        if (!(hiveModule instanceof GoogleRecaptcha)) {
                            hiveModule = null;
                        }
                        if (!(hiveModule instanceof GoogleRecaptcha)) {
                            hiveModule = null;
                        }
                        GoogleRecaptcha googleRecaptcha = (GoogleRecaptcha) hiveModule;
                        if (googleRecaptcha == null) {
                            AuthV4Impl authV4Impl2 = AuthV4Impl.INSTANCE;
                            if (authV4Impl2.isRecaptchaEnable()) {
                                LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[reCAPTCHA] v3_app enabled, but Hive GoogleBase not contained");
                                AuthV4Impl.isInProgressSign = false;
                                authV4Impl2.onSignInFinish(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveRecaptcha"), null, this.$fApiName, this.$listener);
                                return Unit.INSTANCE;
                            }
                            authV4Impl2.internalSignInGuest(this.$fApiName, null, this.$listener);
                            Unit unit = Unit.INSTANCE;
                            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[reCAPTCHA] Google Provider is null.");
                        } else {
                            final String str2 = this.$fApiName;
                            final AuthV4.AuthV4SignInListener authV4SignInListener = this.$listener;
                            googleRecaptcha.executeRecaptcha(new Function2() { // from class: com.hive.authv4.AuthV4Impl$signIn$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return AuthV4Impl.C28441.invokeSuspend$lambda$1(str2, authV4SignInListener, ((Integer) obj2).intValue(), (String) obj3);
                                }
                            });
                        }
                    } else {
                        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[reCAPTCHA] Exist reCAPTCHA web token.");
                        AuthV4Impl.INSTANCE.internalSignInGuest(this.$fApiName, this.$tokenFromWeb, this.$listener);
                    }
                    break;
                case 2:
                    AuthV4Impl.INSTANCE.internalSignInPlayer(AuthV4Account.INSTANCE.readPlayerInfo(), this.$fApiName, this.$listener);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    AuthV4Impl.INSTANCE.signInProvider(this.$fApiName, this.$providerType, this.$listener);
                    break;
                default:
                    AuthV4Impl.INSTANCE.signInProvider(this.$fApiName, this.$providerType, this.$listener);
                    break;
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28441) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.hive.authv4.AuthV4Impl$signInWithAuthKey$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.authv4.AuthV4Impl$signInWithAuthKey$1", f = "AuthV4Impl.kt", i = {}, l = {2054}, m = "invokeSuspend", n = {}, s = {})
    public static final class C28461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $authKey;
        final /* synthetic */ String $fApiName;
        final /* synthetic */ AuthV4.AuthV4SignInListener $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28461(String str, String str2, AuthV4.AuthV4SignInListener authV4SignInListener, Continuation<? super C28461> continuation) {
            super(2, continuation);
            this.$authKey = str;
            this.$fApiName = str2;
            this.$listener = authV4SignInListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28461(this.$authKey, this.$fApiName, this.$listener, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AuthV4Impl authV4Impl = AuthV4Impl.INSTANCE;
                boolean zSavedAutoLoginEnabled = AuthV4Account.INSTANCE.savedAutoLoginEnabled();
                this.label = 1;
                if (authV4Impl.handleSignOutNeeded(false, zSavedAutoLoginEnabled, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            AuthV4Impl.isInProgressSign = true;
            AuthV4Impl.INSTANCE.processGamerId(this.$authKey, this.$fApiName, this.$listener);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28461) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.hive.authv4.AuthV4Impl$uploadProfile$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/hive/authv4/AuthV4Impl$uploadProfile$1", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderGetProfileListener;", "onProviderGetProfileListener", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C28471 implements AuthV4ProviderAdapter.ProviderGetProfileListener {
        final /* synthetic */ Function1<ResultAPI, Unit> $callback;
        final /* synthetic */ AuthV4.PlayerInfo $playerInfo;
        final /* synthetic */ AuthV4ProviderAdapter $provider;

        /* JADX WARN: Multi-variable type inference failed */
        public C28471(AuthV4ProviderAdapter authV4ProviderAdapter, AuthV4.PlayerInfo playerInfo, Function1<? super ResultAPI, Unit> function1) {
            this.$provider = authV4ProviderAdapter;
            this.$playerInfo = playerInfo;
            this.$callback = function1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onProviderGetProfileListener$lambda$0(AuthV4ProviderAdapter authV4ProviderAdapter, Function1 function1, ResultAPI resultApi, Upload upload) {
            Intrinsics.checkNotNullParameter(resultApi, "resultApi");
            Intrinsics.checkNotNullParameter(upload, "<unused var>");
            LoggerImpl.INSTANCE.d("[" + authV4ProviderAdapter.getIdpType() + "] uploadProfile: " + resultApi);
            function1.invoke(resultApi);
            return Unit.INSTANCE;
        }

        @Override // com.hive.authv4.provider.AuthV4ProviderAdapter.ProviderGetProfileListener
        public void onProviderGetProfileListener(ResultAPI result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (!this.$provider.getIsLogIn()) {
                LoggerImpl.INSTANCE.w("[" + this.$provider.getIdpType() + "] uploadProfile ignored: " + result);
                this.$callback.invoke(result);
                return;
            }
            AuthV4Network.ProfileApi profileApi = AuthV4Network.ProfileApi.INSTANCE;
            AuthV4.PlayerInfo playerInfo = this.$playerInfo;
            String value = this.$provider.getIdpType().getValue();
            String userProfileImage = this.$provider.getUserProfileImage();
            String str = userProfileImage == null ? "" : userProfileImage;
            String userName = this.$provider.getUserName();
            String str2 = userName == null ? "" : userName;
            final AuthV4ProviderAdapter authV4ProviderAdapter = this.$provider;
            final Function1<ResultAPI, Unit> function1 = this.$callback;
            profileApi.upload$hive_service_release(playerInfo, value, str, str2, new Function2() { // from class: com.hive.authv4.AuthV4Impl$uploadProfile$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthV4Impl.C28471.onProviderGetProfileListener$lambda$0(authV4ProviderAdapter, function1, (ResultAPI) obj, (Upload) obj2);
                }
            });
        }
    }

    static {
        CoroutineContext coroutineContextPlus = Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null));
        defaultDispatcher = coroutineContextPlus;
        ioDispatcher = Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null));
        setupScope = CoroutineScopeKt.CoroutineScope(coroutineContextPlus);
        isInProgressTerms = new AtomicBoolean(false);
        idpList = new ArrayList<>();
        mainLooperHandler = new Handler(Looper.getMainLooper());
    }

    private AuthV4Impl() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkBlacklist$lambda$102(String str, ResultAPI resultAPI, AuthV4.AuthV4MaintenanceListener authV4MaintenanceListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4MaintenanceListener.onAuthV4Maintenance(resultAPI, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkBlacklist$lambda$103(String str, String str2, AuthV4.AuthV4MaintenanceListener authV4MaintenanceListener) {
        ResultAPI resultAPI = new ResultAPI(-9, ResultAPI.Code.AuthV4NeedSignIn, str);
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str2, resultAPI.toString());
        authV4MaintenanceListener.onAuthV4Maintenance(resultAPI, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkBlacklist$lambda$108(boolean z, final AuthV4.AuthV4MaintenanceListener authV4MaintenanceListener, final String str, final ResultAPI resultApi, Blacklist blacklist, AuthV4.AuthV4MaintenanceInfo authV4MaintenanceInfo) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(blacklist, "blacklist");
        if (resultApi.isFailure()) {
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda23
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.checkBlacklist$lambda$108$lambda$104(authV4MaintenanceListener);
                }
            });
            return Unit.INSTANCE;
        }
        if (authV4MaintenanceInfo != null) {
            final ArrayList arrayList = new ArrayList();
            arrayList.add(authV4MaintenanceInfo);
            if (z) {
                AuthV4Network.INSTANCE.showBlacklistDialog$hive_service_release(blacklist.getResponse(), resultApi, new AuthV4Impl$checkBlacklist$3$2(str, authV4MaintenanceListener, arrayList));
            } else {
                mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda24
                    @Override // java.lang.Runnable
                    public final void run() {
                        AuthV4Impl.checkBlacklist$lambda$108$lambda$106(str, resultApi, authV4MaintenanceListener, arrayList);
                    }
                });
            }
        } else {
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda25
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.checkBlacklist$lambda$108$lambda$107(str, resultApi, authV4MaintenanceListener);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkBlacklist$lambda$108$lambda$104(AuthV4.AuthV4MaintenanceListener authV4MaintenanceListener) {
        authV4MaintenanceListener.onAuthV4Maintenance(new ResultAPI(-5, ResultAPI.Code.AuthV4NetworkError, ""), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkBlacklist$lambda$108$lambda$106(String str, ResultAPI resultAPI, AuthV4.AuthV4MaintenanceListener authV4MaintenanceListener, ArrayList arrayList) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4MaintenanceListener.onAuthV4Maintenance(resultAPI, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkBlacklist$lambda$108$lambda$107(String str, ResultAPI resultAPI, AuthV4.AuthV4MaintenanceListener authV4MaintenanceListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4MaintenanceListener.onAuthV4Maintenance(resultAPI, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkEmulator() {
        Property.Companion companion = Property.INSTANCE;
        String value = companion.getINSTANCE().getValue("EmulatorDetector", "");
        String value2 = companion.getINSTANCE().getValue("EmulatorCause", "");
        final Activity recentActivity = HiveActivity.INSTANCE.getRecentActivity();
        try {
            final EmulatorDetector.Emulator emulatorCheckEmulator = new EmulatorDetector(recentActivity).checkEmulator();
            if (emulatorCheckEmulator != null && Configuration.getUseLog()) {
                Android.INSTANCE.runOnMainThread(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda19
                    @Override // java.lang.Runnable
                    public final void run() {
                        AuthV4Impl.checkEmulator$lambda$1$lambda$0(recentActivity, emulatorCheckEmulator);
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
            if (value.length() > 0 && emulatorCheckEmulator == null) {
                Property.setValue$default(companion.getINSTANCE(), "EmulatorCause", "", null, 4, null);
                AnalyticsImpl.INSTANCE.sendClientEmulatorBaseDataLog(value, "");
                Property.setValue$default(companion.getINSTANCE(), "EmulatorDetector", value, null, 4, null);
                return;
            }
            if (value.length() <= 0 || emulatorCheckEmulator == null) {
                Unit unit2 = Unit.INSTANCE;
                return;
            }
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
            Unit unit3 = Unit.INSTANCE;
        } catch (Exception e) {
            e.printStackTrace();
            Unit unit4 = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkEmulator$lambda$1$lambda$0(Activity activity, EmulatorDetector.Emulator emulator) {
        Android.INSTANCE.copyToClipboard(activity, "EmulatorDetector", emulator.getCause());
        Toast.makeText(activity, emulator.getEmulatorName(), 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkGDPRAgreement(AuthV4.PlayerInfo playerInfo, final Function0<Unit> callback) {
        AuthV4Network.INSTANCE.getPolicy$hive_service_release(playerInfo, "GDPR", new Function2() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AuthV4Impl.checkGDPRAgreement$lambda$109(callback, (ResultAPI) obj, (GetPolicy) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkGDPRAgreement$lambda$109(final Function0 function0, ResultAPI resultApi, final GetPolicy getPolicy) throws JSONException {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(getPolicy, "getPolicy");
        if (resultApi.isSuccess() && getPolicy.getResponse().getIsPolicy() && !StringsKt.isBlank(getPolicy.getResponse().getUrl())) {
            JSONObject jSONObjectPutCI = CommonIdentifierKt.putCI(new JSONObject());
            try {
                CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_uid, getPolicy.getResponse().getIdpUserId());
                final String string = jSONObjectPutCI.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new OnActivityLifecycle() { // from class: com.hive.authv4.AuthV4Impl$checkGDPRAgreement$1$1
                    public AuthV4WebView authV4WebView;

                    public final AuthV4WebView getAuthV4WebView() {
                        AuthV4WebView authV4WebView = this.authV4WebView;
                        if (authV4WebView != null) {
                            return authV4WebView;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("authV4WebView");
                        return null;
                    }

                    @Override // com.hive.ui.OnActivityLifecycle
                    public boolean onBackPressed() {
                        return getAuthV4WebView().onBackPressed();
                    }

                    @Override // com.hive.ui.OnActivityLifecycle
                    public void onCreate(final Activity activity, Bundle savedInstanceState) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                        super.onCreate(activity, savedInstanceState);
                        String url = getPolicy.getResponse().getUrl();
                        String str = string;
                        AuthV4WebView.CloseButtonType closeButtonType = AuthV4WebView.CloseButtonType.TYPE_THEME;
                        final Function0<Unit> function02 = function0;
                        setAuthV4WebView(new AuthV4WebView(activity, url, str, null, null, closeButtonType, new AuthV4WebView.AuthV4WebViewListener() { // from class: com.hive.authv4.AuthV4Impl$checkGDPRAgreement$1$1$onCreate$1
                            @Override // com.hive.authv4.webviewflow.AuthV4WebView.AuthV4WebViewListener
                            public void onReceivedError(int errorCode, String description, String failingUrl) {
                                LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                                loggerImpl.dL(AuthV4.getTAG(), "[signIn] webView Error : errorCode : " + errorCode + " decsription : " + description + " failingURL : " + failingUrl);
                                loggerImpl.dR(AuthV4.getTAG(), "[signIn] webView Error : errorCode : " + errorCode + " decsription : " + description);
                                function02.invoke();
                                activity.finish();
                            }

                            @Override // com.hive.authv4.webviewflow.AuthV4WebView.AuthV4WebViewListener
                            public void onWebViewFinish(String select) {
                                LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "signIn scheme: " + select);
                                function02.invoke();
                                activity.finish();
                            }
                        }));
                        getAuthV4WebView().show();
                    }

                    @Override // com.hive.ui.OnActivityLifecycle
                    public void onDestroy(Activity activity) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                        if (!getIsCalledFinish()) {
                            getAuthV4WebView().dismiss();
                        }
                        super.onDestroy(activity);
                    }

                    public final void setAuthV4WebView(AuthV4WebView authV4WebView) {
                        Intrinsics.checkNotNullParameter(authV4WebView, "<set-?>");
                        this.authV4WebView = authV4WebView;
                    }
                });
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[signIn] invalid post data. " + e);
                function0.invoke();
                return Unit.INSTANCE;
            }
        } else {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkMaintenance$lambda$101(boolean z, final String str, final AuthV4.AuthV4MaintenanceListener authV4MaintenanceListener, final ResultAPI resultApi, GetMaintenance getMaintenance, final ArrayList maintenanceInfoList) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(getMaintenance, "getMaintenance");
        Intrinsics.checkNotNullParameter(maintenanceInfoList, "maintenanceInfoList");
        AnalyticsImpl.INSTANCE.sendUserEntryFunnelsLogs(AnalyticsImpl.FunnelsTrack.SERVER_MAINTENANCE_POPUP);
        if (!resultApi.isSuccess()) {
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.checkMaintenance$lambda$101$lambda$100(str, resultApi, authV4MaintenanceListener, maintenanceInfoList);
                }
            });
        } else if (!z || maintenanceInfoList.isEmpty()) {
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.checkMaintenance$lambda$101$lambda$99(str, resultApi, authV4MaintenanceListener, maintenanceInfoList);
                }
            });
        } else {
            mainLooperHandler.post(INSTANCE.createMaintenanceRunnable(0, maintenanceInfoList, new AuthV4Impl$checkMaintenance$2$1(str, resultApi, authV4MaintenanceListener, maintenanceInfoList)));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkMaintenance$lambda$101$lambda$100(String str, ResultAPI resultAPI, AuthV4.AuthV4MaintenanceListener authV4MaintenanceListener, ArrayList arrayList) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4MaintenanceListener.onAuthV4Maintenance(resultAPI, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkMaintenance$lambda$101$lambda$99(String str, ResultAPI resultAPI, AuthV4.AuthV4MaintenanceListener authV4MaintenanceListener, ArrayList arrayList) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4MaintenanceListener.onAuthV4Maintenance(resultAPI, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkMaintenance$lambda$98(String str, ResultAPI resultAPI, AuthV4.AuthV4MaintenanceListener authV4MaintenanceListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4MaintenanceListener.onAuthV4Maintenance(resultAPI, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable createMaintenanceRunnable(final int index, final ArrayList<AuthV4.AuthV4MaintenanceInfo> maintenanceInfoList, final MaintenanceDialog.OnDismissListener listener) {
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[Setup : " + index + ". process Maintenance : create Maintenance Runnable]");
        return new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda77
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4Impl.createMaintenanceRunnable$lambda$9(maintenanceInfoList, index, listener);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createMaintenanceRunnable$lambda$9(final ArrayList arrayList, final int i, final MaintenanceDialog.OnDismissListener onDismissListener) {
        AppUpdate appUpdate = AppUpdate.INSTANCE;
        Object obj = arrayList.get(i);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        appUpdate.launchAppUpdateFlow(appUpdate.appUpdateType((AuthV4.AuthV4MaintenanceInfo) obj), new Function1() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda43
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return AuthV4Impl.createMaintenanceRunnable$lambda$9$lambda$8(arrayList, i, onDismissListener, ((Boolean) obj2).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createMaintenanceRunnable$lambda$9$lambda$8(final ArrayList arrayList, final int i, final MaintenanceDialog.OnDismissListener onDismissListener, boolean z) {
        if (z) {
            int i2 = i + 1;
            if (arrayList.size() > i2) {
                mainLooperHandler.post(INSTANCE.createMaintenanceRunnable(i2, arrayList, onDismissListener));
            } else {
                onDismissListener.onDismiss(new DialogInterface() { // from class: com.hive.authv4.AuthV4Impl$createMaintenanceRunnable$1$1$1
                    @Override // android.content.DialogInterface
                    public void cancel() {
                    }

                    @Override // android.content.DialogInterface
                    public void dismiss() {
                    }
                });
            }
        } else {
            HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new OnActivityLifecycle() { // from class: com.hive.authv4.AuthV4Impl$createMaintenanceRunnable$1$1$2
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
                    AuthV4Impl authV4Impl = AuthV4Impl.INSTANCE;
                    AuthV4.AuthV4MaintenanceInfo authV4MaintenanceInfo = arrayList.get(i);
                    Intrinsics.checkNotNullExpressionValue(authV4MaintenanceInfo, "get(...)");
                    MaintenanceDialog.MaintenanceModel maintenanceModel = authV4Impl.getMaintenanceModel(authV4MaintenanceInfo, "", MaintenanceDialog.MaintenanceDialogType.DEFAULT);
                    final ArrayList<AuthV4.AuthV4MaintenanceInfo> arrayList2 = arrayList;
                    final int i3 = i;
                    final MaintenanceDialog.OnDismissListener onDismissListener2 = onDismissListener;
                    setDialog(new MaintenanceDialog(activity, maintenanceModel, new MaintenanceDialog.OnDismissListener() { // from class: com.hive.authv4.AuthV4Impl$createMaintenanceRunnable$1$1$2$onCreate$1
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialog) {
                            Intrinsics.checkNotNullParameter(dialog, "dialog");
                            activity.finish();
                            if (arrayList2.size() > i3 + 1) {
                                AuthV4Impl.mainLooperHandler.post(AuthV4Impl.INSTANCE.createMaintenanceRunnable(i3 + 1, arrayList2, onDismissListener2));
                            } else {
                                onDismissListener2.onDismiss(dialog);
                            }
                        }

                        @Override // com.hive.auth.MaintenanceDialog.OnDismissListener
                        public void onDismissWithButtonAction(DialogInterface dialog, MaintenanceDialog.MaintenanceActionType buttonAction) {
                            Intrinsics.checkNotNullParameter(dialog, "dialog");
                            Intrinsics.checkNotNullParameter(buttonAction, "buttonAction");
                            activity.finish();
                            onDismissListener2.onDismissWithButtonAction(dialog, buttonAction);
                        }
                    }));
                    getDialog().show();
                    authV4Impl.requestNoticePopupSettleBill(arrayList.get(i).getType());
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
    public static final Unit deleteStoredPlayerId$lambda$118(long j, AuthV4.AuthV4DeletePlayerIdListener authV4DeletePlayerIdListener, ResultAPI resultApi, SignOut signOut) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        if (resultApi.getCode() == ResultAPI.Code.Success || resultApi.getCode() == ResultAPI.Code.AuthV4InvalidSession) {
            LoggerImpl.INSTANCE.d("[signOut] resultApi : " + resultApi + ", remove session data");
            AuthV4Account.INSTANCE.removePlayerInfoList(j);
            if (authV4DeletePlayerIdListener != null) {
                authV4DeletePlayerIdListener.onAuthV4DeletePlayerId(new ResultAPI());
            }
        } else if (authV4DeletePlayerIdListener != null) {
            authV4DeletePlayerIdListener.onAuthV4DeletePlayerId(resultApi);
        }
        isInProgressDeletePlayerId = false;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit disconnect$lambda$51(AuthV4.ProviderType providerType, AuthV4.PlayerInfo playerInfo, String str, final String str2, final AuthV4.AuthV4DisconnectListener authV4DisconnectListener, final ResultAPI resultApi, Disconnect disconnect) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(disconnect, "disconnect");
        if (resultApi.isSuccess()) {
            if (providerType != null) {
                playerInfo.getProviderInfoData().remove(providerType);
                AuthV4Account.INSTANCE.writePlayerInfo(playerInfo);
                AuthV4ProviderAdapter companion = AuthV4ProviderAdapter.INSTANCE.getInstance(providerType);
                if (companion == null) {
                    String str3 = "[disconnect] this provider type is invalid. : " + providerType;
                    LoggerImpl.INSTANCE.w(AuthV4.getTAG(), str3);
                    isInProgressSign = false;
                    INSTANCE.onDisconnectFinish(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, str3), str2, authV4DisconnectListener);
                } else {
                    companion.logout(new AuthV4ProviderAdapter.ProviderLogoutListener() { // from class: com.hive.authv4.AuthV4Impl$disconnect$1$1$1
                        @Override // com.hive.authv4.provider.AuthV4ProviderAdapter.ProviderLogoutListener
                        public void onProviderLogoutListener(ResultAPI result) {
                            Intrinsics.checkNotNullParameter(result, "result");
                            AuthV4Impl.isInProgressSign = false;
                            AuthV4Impl.INSTANCE.onDisconnectFinish(resultApi, str2, authV4DisconnectListener);
                        }
                    });
                }
            } else {
                playerInfo.getCustomProviderInfoData().remove(str);
                AuthV4Account.INSTANCE.writePlayerInfo(playerInfo);
                isInProgressSign = false;
                INSTANCE.onDisconnectFinish(resultApi, str2, authV4DisconnectListener);
            }
        } else if (resultApi.getErrorCode() == -12) {
            AuthV4Network.INSTANCE.showBlacklistDialog$hive_service_release(disconnect.getResponse(), resultApi, new AuthV4.AuthV4MaintenanceListener() { // from class: com.hive.authv4.AuthV4Impl$disconnect$1$2
                @Override // com.hive.AuthV4.AuthV4MaintenanceListener
                public void onAuthV4Maintenance(ResultAPI result, ArrayList<AuthV4.AuthV4MaintenanceInfo> maintenanceInfo) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    AuthV4Impl.isInProgressSign = false;
                    AuthV4Impl.INSTANCE.onDisconnectFinish(result, str2, authV4DisconnectListener);
                }
            });
        } else {
            isInProgressSign = false;
            INSTANCE.onDisconnectFinish(resultApi, str2, authV4DisconnectListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getHashedDi$lambda$120(AuthV4.AuthV4GetHashedDiListener authV4GetHashedDiListener, ResultAPI resultApi, String str) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AuthV4Impl$getHashedDi$1$1(resultApi, str, authV4GetHashedDiListener, null), 3, null);
        return Unit.INSTANCE;
    }

    private final MaintenanceDialog.MaintenanceActionType getMaintenanceActionType(AuthV4.AuthV4MaintenanceActionType authV4MaintenanceActionType) {
        int i = WhenMappings.$EnumSwitchMapping$3[authV4MaintenanceActionType.ordinal()];
        if (i == 1) {
            return MaintenanceDialog.MaintenanceActionType.UNDEFINED;
        }
        if (i == 2) {
            return MaintenanceDialog.MaintenanceActionType.TIMEOVER;
        }
        if (i == 3) {
            return MaintenanceDialog.MaintenanceActionType.OPEN_URL;
        }
        if (i == 4) {
            return MaintenanceDialog.MaintenanceActionType.EXIT;
        }
        if (i == 5) {
            return MaintenanceDialog.MaintenanceActionType.DONE;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getProfile$lambda$62(String str, ResultAPI resultAPI, AuthV4.AuthV4GetProfileListener authV4GetProfileListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4GetProfileListener.onAuthV4GetProfile(resultAPI, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getProfile$lambda$63(String str, ResultAPI resultAPI, AuthV4.AuthV4GetProfileListener authV4GetProfileListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4GetProfileListener.onAuthV4GetProfile(resultAPI, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getProfile$lambda$64(String str, ResultAPI resultAPI, AuthV4.AuthV4GetProfileListener authV4GetProfileListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4GetProfileListener.onAuthV4GetProfile(resultAPI, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getProfile$lambda$66(AuthV4.PlayerInfo playerInfo, final String str, final AuthV4.AuthV4GetProfileListener authV4GetProfileListener, final ResultAPI resultApi, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        if (resultApi.isSuccess() && arrayList != null) {
            Iterator it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                AuthV4.ProfileInfo profileInfo = (AuthV4.ProfileInfo) next;
                if (playerInfo.getPlayerId() == profileInfo.getPlayerId()) {
                    playerInfo.setPlayerName(profileInfo.getPlayerName());
                    playerInfo.setPlayerImageUrl(profileInfo.getPlayerImageUrl());
                    AuthV4Account.INSTANCE.writePlayerInfo(playerInfo);
                    break;
                }
            }
        }
        mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda71
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4Impl.getProfile$lambda$66$lambda$65(str, resultApi, authV4GetProfileListener, arrayList);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getProfile$lambda$66$lambda$65(String str, ResultAPI resultAPI, AuthV4.AuthV4GetProfileListener authV4GetProfileListener, ArrayList arrayList) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4GetProfileListener.onAuthV4GetProfile(resultAPI, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getProviderFriendsList$lambda$110(String str, ResultAPI resultAPI, AuthV4.AuthV4ProviderFriendsListener authV4ProviderFriendsListener, AuthV4.ProviderType providerType) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ProviderFriendsListener.onGetProviderFriendsList(resultAPI, providerType, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getProviderFriendsList$lambda$111(String str, ResultAPI resultAPI, AuthV4.AuthV4ProviderFriendsListener authV4ProviderFriendsListener, AuthV4.ProviderType providerType) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ProviderFriendsListener.onGetProviderFriendsList(resultAPI, providerType, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getProviderFriendsList$lambda$112(String str, ResultAPI resultAPI, AuthV4.AuthV4ProviderFriendsListener authV4ProviderFriendsListener, AuthV4.ProviderType providerType) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ProviderFriendsListener.onGetProviderFriendsList(resultAPI, providerType, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void getProviderFriendsList$lambda$114(CountDownLatch countDownLatch, Ref.ObjectRef objectRef, AuthV4.PlayerInfo playerInfo, AuthV4.ProviderType providerType, AuthV4.AuthV4ProviderFriendsListener authV4ProviderFriendsListener, final String str) {
        try {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), " Wait Get Profiles..");
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (((ArrayList) objectRef.element).isEmpty()) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), " Get Profile mUids is empty");
            return;
        }
        final HashMap map = new HashMap();
        final CountDownLatch countDownLatch2 = new CountDownLatch(((ArrayList) objectRef.element).size());
        AuthV4Network.GetIdpUidCountDown.INSTANCE.setLoopLatch(new CountDownLatch(1));
        int size = ((Collection) objectRef.element).size();
        for (int i = 0; i < size; i++) {
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.iL(AuthV4.getTAG(), " RUN Intenal playerGetIdpUid " + i);
            loggerImpl.iR(AuthV4.getTAG(), " RUN Intenal playerGetIdpUid");
            AuthV4Network authV4Network = AuthV4Network.INSTANCE;
            Object obj = ((ArrayList) objectRef.element).get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            authV4Network.getIdpUid$hive_service_release(playerInfo, providerType, (String) obj, new Function3() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return AuthV4Impl.getProviderFriendsList$lambda$114$lambda$113(map, str, countDownLatch2, (ResultAPI) obj2, (GetIdpUid) obj3, (HashMap) obj4);
                }
            });
            try {
                CountDownLatch loopLatch = AuthV4Network.GetIdpUidCountDown.INSTANCE.getLoopLatch();
                if (loopLatch != null) {
                    loopLatch.await();
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (i < ((ArrayList) objectRef.element).size()) {
                AuthV4Network.GetIdpUidCountDown.INSTANCE.setLoopLatch(new CountDownLatch(1));
            }
        }
        try {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), " playerGetIdpUid aWait Global? Latch ");
            countDownLatch2.await();
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
        authV4ProviderFriendsListener.onGetProviderFriendsList(new ResultAPI(), providerType, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getProviderFriendsList$lambda$114$lambda$113(HashMap map, String str, CountDownLatch countDownLatch, ResultAPI resultApi, GetIdpUid getIdpUid, HashMap mapIdpFromProviderUid) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(getIdpUid, "getIdpUid");
        Intrinsics.checkNotNullParameter(mapIdpFromProviderUid, "mapIdpFromProviderUid");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i(AuthV4.getTAG(), " playerGetIdpUid Done will countdown latch");
        if (!mapIdpFromProviderUid.isEmpty()) {
            map.putAll(mapIdpFromProviderUid);
        }
        loggerImpl.apiCallbackLog(AuthV4.getTAG(), str, resultApi.toString());
        countDownLatch.countDown();
        CountDownLatch loopLatch = AuthV4Network.GetIdpUidCountDown.INSTANCE.getLoopLatch();
        if (loopLatch != null) {
            loopLatch.countDown();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getStoredPlayerIdList$lambda$117(ArrayList arrayList, AuthV4.AuthV4PlayerIdListListener authV4PlayerIdListListener) {
        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "getStoredPlayerIdList = " + arrayList);
        if (authV4PlayerIdListListener != null) {
            authV4PlayerIdListListener.onAuthV4GetPlayerIdList(new ResultAPI(), arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object handleSignOutNeeded(boolean r5, boolean r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.hive.authv4.AuthV4Impl.C28251
            if (r0 == 0) goto L13
            r0 = r7
            com.hive.authv4.AuthV4Impl$handleSignOutNeeded$1 r0 = (com.hive.authv4.AuthV4Impl.C28251) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.hive.authv4.AuthV4Impl$handleSignOutNeeded$1 r0 = new com.hive.authv4.AuthV4Impl$handleSignOutNeeded$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L29
            goto L50
        L29:
            r5 = move-exception
            goto L5f
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r7)
            if (r5 != 0) goto L86
            if (r6 != 0) goto L86
            com.hive.logger.LoggerImpl r5 = com.hive.logger.LoggerImpl.INSTANCE
            java.lang.String r6 = com.hive.AuthV4.getTAG()
            java.lang.String r7 = "[handleSignOutNeeded] signOut provider session, before signIn."
            r5.d(r6, r7)
            kotlin.Result$Companion r5 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L29
            r0.label = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r7 = r4.internalSignOutAwait(r0)     // Catch: java.lang.Throwable -> L29
            if (r7 != r1) goto L50
            return r1
        L50:
            java.lang.Number r7 = (java.lang.Number) r7     // Catch: java.lang.Throwable -> L29
            int r5 = r7.intValue()     // Catch: java.lang.Throwable -> L29
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)     // Catch: java.lang.Throwable -> L29
            java.lang.Object r5 = kotlin.Result.m7415constructorimpl(r5)     // Catch: java.lang.Throwable -> L29
            goto L69
        L5f:
            kotlin.Result$Companion r6 = kotlin.Result.INSTANCE
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m7415constructorimpl(r5)
        L69:
            java.lang.Throwable r5 = kotlin.Result.m7418exceptionOrNullimpl(r5)
            if (r5 == 0) goto L86
            com.hive.logger.LoggerImpl r6 = com.hive.logger.LoggerImpl.INSTANCE
            java.lang.String r7 = com.hive.AuthV4.getTAG()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "[handleSignOutNeeded] internalSignOutAwait failure : "
            r0.<init>(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r6.w(r7, r5)
        L86:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.AuthV4Impl.handleSignOutNeeded(boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void internalConnect(final AuthV4.PlayerInfo localPlayerInfo, final AuthV4ProviderAdapter provider, final String fApiName, final AuthV4.AuthV4ConnectListener listener) {
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[internalConnect]");
        AuthV4Network.INSTANCE.connect$hive_service_release(localPlayerInfo, provider, new Function3() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda78
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return AuthV4Impl.internalConnect$lambda$48(localPlayerInfo, provider, fApiName, listener, (ResultAPI) obj, (Connect) obj2, (AuthV4.PlayerInfo) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit internalConnect$lambda$48(AuthV4.PlayerInfo playerInfo, AuthV4ProviderAdapter authV4ProviderAdapter, final String str, final AuthV4.AuthV4ConnectListener authV4ConnectListener, final ResultAPI resultApi, Connect connect, final AuthV4.PlayerInfo playerInfo2) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(connect, "connect");
        if (resultApi.getCode() == ResultAPI.Code.Success) {
            playerInfo.getProviderInfoData().put(authV4ProviderAdapter.getIdpType(), authV4ProviderAdapter.getMyProviderInfo());
            AuthV4Account.INSTANCE.writePlayerInfo(playerInfo);
            INSTANCE.uploadProfile(playerInfo, authV4ProviderAdapter, new Function1() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda70
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthV4Impl.internalConnect$lambda$48$lambda$47(resultApi, playerInfo2, str, authV4ConnectListener, (ResultAPI) obj);
                }
            });
        } else if (resultApi.getCode() == ResultAPI.Code.AuthV4UserInBlacklist) {
            authV4ProviderAdapter.logout(new AuthV4ProviderAdapter.ProviderLogoutListener() { // from class: com.hive.authv4.AuthV4Impl$internalConnect$1$2
                @Override // com.hive.authv4.provider.AuthV4ProviderAdapter.ProviderLogoutListener
                public void onProviderLogoutListener(ResultAPI result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    LoggerImpl.INSTANCE.d("[internalConnect] blacklist error, provider logout result : " + result);
                }
            });
            AuthV4Network.INSTANCE.showBlacklistDialog$hive_service_release(connect.getResponse(), resultApi, new AuthV4.AuthV4MaintenanceListener() { // from class: com.hive.authv4.AuthV4Impl$internalConnect$1$3
                @Override // com.hive.AuthV4.AuthV4MaintenanceListener
                public void onAuthV4Maintenance(ResultAPI result, ArrayList<AuthV4.AuthV4MaintenanceInfo> maintenanceInfo) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    AuthV4Impl.isInProgressSign = false;
                    AuthV4Impl.INSTANCE.onConnectFinish(result, playerInfo2, str, authV4ConnectListener);
                }
            });
        } else if (resultApi.getCode() == ResultAPI.Code.AuthV4ConflictPlayer) {
            recentConflictPlayerInfo = playerInfo2;
            isInProgressSign = false;
            INSTANCE.onConnectFinish(resultApi, playerInfo2, str, authV4ConnectListener);
        } else {
            isInProgressSign = false;
            INSTANCE.onConnectFinish(resultApi, playerInfo2, str, authV4ConnectListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit internalConnect$lambda$48$lambda$47(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo, String str, AuthV4.AuthV4ConnectListener authV4ConnectListener, ResultAPI resultAPI2) {
        Intrinsics.checkNotNullParameter(resultAPI2, "<unused var>");
        isInProgressSign = false;
        INSTANCE.onConnectFinish(resultAPI, playerInfo, str, authV4ConnectListener);
        return Unit.INSTANCE;
    }

    private final void internalCustomConnect(final AuthV4.PlayerInfo localPlayerInfo, String authKey, final String fApiName, final AuthV4.AuthV4ConnectListener listener) {
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[internalCustomConnect]");
        AuthV4Network.INSTANCE.customAuthConnect$hive_service_release(localPlayerInfo, authKey, new Function4() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return AuthV4Impl.internalCustomConnect$lambda$49(localPlayerInfo, fApiName, listener, (ResultAPI) obj, (CustomAuthConnect) obj2, (AuthV4.PlayerInfo) obj3, (String) obj4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit internalCustomConnect$lambda$49(AuthV4.PlayerInfo playerInfo, final String str, final AuthV4.AuthV4ConnectListener authV4ConnectListener, ResultAPI resultApi, CustomAuthConnect customAuthConnect, final AuthV4.PlayerInfo playerInfo2, String str2) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(customAuthConnect, "customAuthConnect");
        if (resultApi.getCode() == ResultAPI.Code.Success) {
            String idpUserId = customAuthConnect.getResponse().getIdpUserId();
            String idpId = customAuthConnect.getResponse().getIdpId();
            playerInfo.getCustomProviderInfoData().put(idpId, new AuthV4.ProviderInfo(idpId, idpUserId));
            AuthV4Account.INSTANCE.writePlayerInfo(playerInfo);
            isInProgressSign = false;
            INSTANCE.onConnectFinish(resultApi, playerInfo2, str, authV4ConnectListener);
        } else if (resultApi.getCode() == ResultAPI.Code.AuthV4UserInBlacklist) {
            AuthV4Network.INSTANCE.showBlacklistDialog$hive_service_release(customAuthConnect.getResponse(), resultApi, new AuthV4.AuthV4MaintenanceListener() { // from class: com.hive.authv4.AuthV4Impl$internalCustomConnect$1$1
                @Override // com.hive.AuthV4.AuthV4MaintenanceListener
                public void onAuthV4Maintenance(ResultAPI result, ArrayList<AuthV4.AuthV4MaintenanceInfo> maintenanceInfo) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    AuthV4Impl.isInProgressSign = false;
                    AuthV4Impl.INSTANCE.onConnectFinish(result, playerInfo2, str, authV4ConnectListener);
                }
            });
        } else if (resultApi.getCode() == ResultAPI.Code.AuthV4ConflictPlayer) {
            recentConflictPlayerInfo = playerInfo2;
            recentCustomSignInAuthKey = str2;
            isInProgressSign = false;
            INSTANCE.onConnectFinish(resultApi, playerInfo2, str, authV4ConnectListener);
        } else {
            isInProgressSign = false;
            INSTANCE.onConnectFinish(resultApi, playerInfo2, str, authV4ConnectListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void internalCustomSignInProvider(String authKey, String player, final String fApiName, final AuthV4.AuthV4SignInListener listener) {
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "internalCustomSignInProvider");
        AuthV4Network.INSTANCE.customAuthSignInIdp$hive_service_release(authKey, player, new Function5() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda72
            @Override // kotlin.jvm.functions.Function5
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                return AuthV4Impl.internalCustomSignInProvider$lambda$42(fApiName, listener, (ResultAPI) obj, (CustomAuthSignInIdp) obj2, (AuthV4.PlayerInfo) obj3, (String) obj4, (String) obj5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit internalCustomSignInProvider$lambda$42(final String str, final AuthV4.AuthV4SignInListener authV4SignInListener, final ResultAPI resultApi, CustomAuthSignInIdp customAuthSignInIdp, final AuthV4.PlayerInfo playerInfo, String str2, final String str3) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(customAuthSignInIdp, "customAuthSignInIdp");
        if (resultApi.isSuccess() && playerInfo != null && str3 != null) {
            AuthV4Account authV4Account = AuthV4Account.INSTANCE;
            authV4Account.writePlayerInfo(playerInfo);
            if (str2 != null) {
                authV4Account.writeToken(playerInfo.getAccessToken(), str2);
            }
            AuthV4Network.ProfileApi.INSTANCE.upload$hive_service_release(playerInfo, str3, "", "", new Function2() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthV4Impl.internalCustomSignInProvider$lambda$42$lambda$41(str3, resultApi, playerInfo, str, authV4SignInListener, (ResultAPI) obj, (Upload) obj2);
                }
            });
        } else if (resultApi.getErrorCode() == -12) {
            AuthV4Network.INSTANCE.showBlacklistDialog$hive_service_release(customAuthSignInIdp.getResponse(), resultApi, new AuthV4.AuthV4MaintenanceListener() { // from class: com.hive.authv4.AuthV4Impl$internalCustomSignInProvider$1$3
                @Override // com.hive.AuthV4.AuthV4MaintenanceListener
                public void onAuthV4Maintenance(ResultAPI result, ArrayList<AuthV4.AuthV4MaintenanceInfo> maintenanceInfo) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    AuthV4Account.INSTANCE.memoryReset();
                    AuthV4Impl.INSTANCE.onSignInFinish(result, playerInfo, str, authV4SignInListener);
                }
            });
        } else if (resultApi.getErrorCode() == -9) {
            isInProgressSign = false;
            INSTANCE.signOut(new AuthV4.AuthV4SignOutListener() { // from class: com.hive.authv4.AuthV4Impl$internalCustomSignInProvider$1$4
                @Override // com.hive.AuthV4.AuthV4SignOutListener
                public void onAuthV4SignOut(ResultAPI result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    authV4SignInListener.onAuthV4SignIn(resultApi, null);
                }
            });
        } else {
            INSTANCE.onSignInFinish(resultApi, playerInfo, str, authV4SignInListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit internalCustomSignInProvider$lambda$42$lambda$41(String str, ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo, String str2, AuthV4.AuthV4SignInListener authV4SignInListener, ResultAPI uploadResultApi, Upload upload) {
        Intrinsics.checkNotNullParameter(uploadResultApi, "uploadResultApi");
        Intrinsics.checkNotNullParameter(upload, "<unused var>");
        LoggerImpl.INSTANCE.d("[" + str + "] uploadProfile: " + uploadResultApi);
        INSTANCE.onSignInFinish(resultAPI, playerInfo, str2, authV4SignInListener);
        return Unit.INSTANCE;
    }

    private final void internalSelectConflictBind(AuthV4.PlayerInfo localPlayerInfo, AuthV4.PlayerInfo localRecentConflictPlayerInfo, final AuthV4.ProviderInfo conflictProviderInfo, final String fApiName, final AuthV4.AuthV4SignInListener listener) {
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "internalSelectConflictBind");
        AuthV4Network.INSTANCE.selectIdp$hive_service_release(localPlayerInfo, localRecentConflictPlayerInfo, conflictProviderInfo, new Function3() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda66
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return AuthV4Impl.internalSelectConflictBind$lambda$54(conflictProviderInfo, fApiName, listener, (ResultAPI) obj, (SelectIdp) obj2, (AuthV4.PlayerInfo) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit internalSelectConflictBind$lambda$54(AuthV4.ProviderInfo providerInfo, final String str, final AuthV4.AuthV4SignInListener authV4SignInListener, final ResultAPI resultApi, SelectIdp selectIdp, final AuthV4.PlayerInfo playerInfo) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(selectIdp, "selectIdp");
        Intrinsics.checkNotNullParameter(playerInfo, "playerInfo");
        if (resultApi.isSuccess()) {
            if (providerInfo.getProviderType() == AuthV4.ProviderType.CUSTOM) {
                playerInfo.getCustomProviderInfoData().put(providerInfo.getProviderName(), providerInfo);
            } else {
                playerInfo.getProviderInfoData().put(providerInfo.getProviderType(), providerInfo);
            }
            AuthV4Account.INSTANCE.writePlayerInfo(playerInfo);
            recentConflictPlayerInfo = null;
            recentCustomSignInAuthKey = null;
            AuthV4ProviderAdapter companion = AuthV4ProviderAdapter.INSTANCE.getInstance(providerInfo.getProviderType());
            if (companion != null) {
                INSTANCE.uploadProfile(playerInfo, companion, new Function1() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda61
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AuthV4Impl.internalSelectConflictBind$lambda$54$lambda$53$lambda$52(resultApi, playerInfo, str, authV4SignInListener, (ResultAPI) obj);
                    }
                });
            } else {
                INSTANCE.onSignInFinish(resultApi, playerInfo, str, authV4SignInListener);
            }
        } else if (resultApi.getErrorCode() == -12) {
            AuthV4Network.INSTANCE.showBlacklistDialog$hive_service_release(selectIdp.getResponse(), resultApi, new AuthV4.AuthV4MaintenanceListener() { // from class: com.hive.authv4.AuthV4Impl$internalSelectConflictBind$1$2
                @Override // com.hive.AuthV4.AuthV4MaintenanceListener
                public void onAuthV4Maintenance(ResultAPI result, ArrayList<AuthV4.AuthV4MaintenanceInfo> maintenanceInfo) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    AuthV4Impl.INSTANCE.onSignInFinish(result, null, str, authV4SignInListener);
                }
            });
        } else {
            INSTANCE.onSignInFinish(resultApi, playerInfo, str, authV4SignInListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit internalSelectConflictBind$lambda$54$lambda$53$lambda$52(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo, String str, AuthV4.AuthV4SignInListener authV4SignInListener, ResultAPI it) {
        Intrinsics.checkNotNullParameter(it, "it");
        INSTANCE.onSignInFinish(resultAPI, playerInfo, str, authV4SignInListener);
        return Unit.INSTANCE;
    }

    private final void internalSelectConflictSwitch(AuthV4.PlayerInfo localPlayerInfo, AuthV4.ProviderInfo conflictProviderInfo, String customSignInAuthKey, String fApiName, AuthV4.AuthV4SignInListener listener) {
        AuthV4ProviderAdapter companion;
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "internalSelectConflictSwitch");
        for (AuthV4.ProviderType providerType : localPlayerInfo.getProviderInfoData().keySet()) {
            Intrinsics.checkNotNullExpressionValue(providerType, "next(...)");
            AuthV4.ProviderType providerType2 = providerType;
            if (providerType2 != conflictProviderInfo.getProviderType() && (companion = AuthV4ProviderAdapter.INSTANCE.getInstance(providerType2)) != null) {
                companion.logout(new AuthV4ProviderAdapter.ProviderLogoutListener() { // from class: com.hive.authv4.AuthV4Impl.internalSelectConflictSwitch.1
                    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter.ProviderLogoutListener
                    public void onProviderLogoutListener(ResultAPI result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                    }
                });
            }
        }
        recentConflictPlayerInfo = null;
        recentCustomSignInAuthKey = null;
        if (customSignInAuthKey == null || StringsKt.isBlank(customSignInAuthKey)) {
            signInProvider(fApiName, conflictProviderInfo.getProviderType(), listener);
        } else {
            internalCustomSignInProvider(customSignInAuthKey, "", fApiName, listener);
        }
    }

    private final void internalShowChatbotInquiry(final String fApiName, final String additionalInfo, final AuthV4.AuthV4ShowChatbotInquiryListener listener) {
        String membershipSession = AuthV4ProviderHive.INSTANCE.getMembershipSession();
        if (membershipSession != null) {
            HiveGraph.INSTANCE.addDefaultData("peppermint", membershipSession);
        }
        Intent intent = new Intent();
        intent.putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, true);
        HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), intent, new OnActivityLifecycle() { // from class: com.hive.authv4.AuthV4Impl.internalShowChatbotInquiry.2
            public AuthV4SocialView authV4SocialDialog;

            public final AuthV4SocialView getAuthV4SocialDialog() {
                AuthV4SocialView authV4SocialView = this.authV4SocialDialog;
                if (authV4SocialView != null) {
                    return authV4SocialView;
                }
                Intrinsics.throwUninitializedPropertyAccessException("authV4SocialDialog");
                return null;
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public boolean onBackPressed() {
                return getAuthV4SocialDialog().onBackPressed();
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onCreate(final Activity activity, Bundle savedInstanceState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                super.onCreate(activity, savedInstanceState);
                AuthV4SocialView.DialogType dialogType = AuthV4SocialView.DialogType.CHATBOT;
                String str = additionalInfo;
                final String str2 = fApiName;
                final AuthV4.AuthV4ShowChatbotInquiryListener authV4ShowChatbotInquiryListener = listener;
                setAuthV4SocialDialog(new AuthV4SocialView(activity, dialogType, str, new AuthV4SocialView.DismissListener() { // from class: com.hive.authv4.AuthV4Impl$internalShowChatbotInquiry$2$onCreate$1
                    @Override // com.hive.authv4.webviewflow.AuthV4SocialView.DismissListener
                    public void onDismiss(ResultAPI result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str2, result.toString());
                        authV4ShowChatbotInquiryListener.onAuthV4ShowChatbotInquiry(new ResultAPI());
                        activity.finish();
                    }
                }));
                getAuthV4SocialDialog().show();
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onDestroy(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (!getIsCalledFinish()) {
                    getAuthV4SocialDialog().dismiss();
                }
                super.onDestroy(activity);
            }

            public final void setAuthV4SocialDialog(AuthV4SocialView authV4SocialView) {
                Intrinsics.checkNotNullParameter(authV4SocialView, "<set-?>");
                this.authV4SocialDialog = authV4SocialView;
            }
        });
    }

    private final void internalShowInquiry(final String fApiName, final AuthV4.AuthV4ShowInquiryListener listener) {
        String membershipSession = AuthV4ProviderHive.INSTANCE.getMembershipSession();
        if (membershipSession != null) {
            HiveGraph.INSTANCE.addDefaultData("peppermint", membershipSession);
        }
        Intent intent = new Intent();
        intent.putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, true);
        HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), intent, new OnActivityLifecycle() { // from class: com.hive.authv4.AuthV4Impl.internalShowInquiry.2
            public AuthV4SocialView authV4SocialDialog;

            public final AuthV4SocialView getAuthV4SocialDialog() {
                AuthV4SocialView authV4SocialView = this.authV4SocialDialog;
                if (authV4SocialView != null) {
                    return authV4SocialView;
                }
                Intrinsics.throwUninitializedPropertyAccessException("authV4SocialDialog");
                return null;
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public boolean onBackPressed() {
                return getAuthV4SocialDialog().onBackPressed();
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onCreate(final Activity activity, Bundle savedInstanceState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                super.onCreate(activity, savedInstanceState);
                AuthV4SocialView.DialogType dialogType = AuthV4SocialView.DialogType.INQUIRY;
                final String str = fApiName;
                final AuthV4.AuthV4ShowInquiryListener authV4ShowInquiryListener = listener;
                setAuthV4SocialDialog(new AuthV4SocialView(activity, dialogType, new AuthV4SocialView.DismissListener() { // from class: com.hive.authv4.AuthV4Impl$internalShowInquiry$2$onCreate$1
                    @Override // com.hive.authv4.webviewflow.AuthV4SocialView.DismissListener
                    public void onDismiss(ResultAPI result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, result.toString());
                        authV4ShowInquiryListener.onAuthV4ShowInquiry(new ResultAPI());
                        activity.finish();
                    }
                }));
                getAuthV4SocialDialog().show();
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onDestroy(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (!getIsCalledFinish()) {
                    getAuthV4SocialDialog().dismiss();
                }
                super.onDestroy(activity);
            }

            public final void setAuthV4SocialDialog(AuthV4SocialView authV4SocialView) {
                Intrinsics.checkNotNullParameter(authV4SocialView, "<set-?>");
                this.authV4SocialDialog = authV4SocialView;
            }
        });
    }

    private final void internalShowMyInquiry(final String fApiName, final AuthV4.AuthV4ShowMyInquiryListener listener) {
        String membershipSession = AuthV4ProviderHive.INSTANCE.getMembershipSession();
        if (membershipSession != null) {
            HiveGraph.INSTANCE.addDefaultData("peppermint", membershipSession);
        }
        Intent intent = new Intent();
        intent.putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, true);
        HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), intent, new OnActivityLifecycle() { // from class: com.hive.authv4.AuthV4Impl.internalShowMyInquiry.2
            public AuthV4SocialView authV4SocialDialog;

            public final AuthV4SocialView getAuthV4SocialDialog() {
                AuthV4SocialView authV4SocialView = this.authV4SocialDialog;
                if (authV4SocialView != null) {
                    return authV4SocialView;
                }
                Intrinsics.throwUninitializedPropertyAccessException("authV4SocialDialog");
                return null;
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public boolean onBackPressed() {
                return getAuthV4SocialDialog().onBackPressed();
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onCreate(final Activity activity, Bundle savedInstanceState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                super.onCreate(activity, savedInstanceState);
                AuthV4SocialView.DialogType dialogType = AuthV4SocialView.DialogType.MYINQUIRY;
                final String str = fApiName;
                final AuthV4.AuthV4ShowMyInquiryListener authV4ShowMyInquiryListener = listener;
                setAuthV4SocialDialog(new AuthV4SocialView(activity, dialogType, new AuthV4SocialView.DismissListener() { // from class: com.hive.authv4.AuthV4Impl$internalShowMyInquiry$2$onCreate$1
                    @Override // com.hive.authv4.webviewflow.AuthV4SocialView.DismissListener
                    public void onDismiss(ResultAPI result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, result.toString());
                        authV4ShowMyInquiryListener.onAuthV4ShowMyInquiry(new ResultAPI());
                        activity.finish();
                    }
                }));
                getAuthV4SocialDialog().show();
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onDestroy(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (!getIsCalledFinish()) {
                    getAuthV4SocialDialog().dismiss();
                }
                super.onDestroy(activity);
            }

            public final void setAuthV4SocialDialog(AuthV4SocialView authV4SocialView) {
                Intrinsics.checkNotNullParameter(authV4SocialView, "<set-?>");
                this.authV4SocialDialog = authV4SocialView;
            }
        });
    }

    private final void internalShowProfile(final String fApiName, Activity activity, final AuthV4.PlayerInfo playerInfo, final long targetPlayerId, final AuthV4.AuthV4ShowProfileListener listener) {
        String did = HiveLifecycle.INSTANCE.getDid();
        AuthV4.ProviderInfo providerInfo = playerInfo.getProviderInfoData().get(AuthV4.ProviderType.HIVE);
        String providerUserId = providerInfo != null ? providerInfo.getProviderUserId() : null;
        String userToken = AuthV4ProviderHive.INSTANCE.getUserToken();
        JSONObject jSONObject = new JSONObject();
        try {
            HiveKeys hiveKeys = HiveKeys.KEY_appid;
            ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
            CommonIdentifierKt.put(jSONObject, hiveKeys, configurationImpl.getAppId());
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_did, did);
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_sdk_version, "4.26.2.0");
            HiveKeys hiveKeys2 = HiveKeys.KEY_os_version;
            Android android2 = Android.INSTANCE;
            CommonIdentifierKt.put(jSONObject, hiveKeys2, android2.getOSVersion());
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_os_api_level, String.valueOf(android2.getOSVersionCode()));
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_device_model, android2.getDeviceModel());
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_country, android2.getCountry());
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_game_language, configurationImpl.getHiveLanguage());
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_player_id, Long.valueOf(playerInfo.getPlayerId()));
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_authorization, playerInfo.getPlayerToken());
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_user_id, providerUserId);
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_session_key, userToken);
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_is_ingame, "Y");
            CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_is_gpg_emulator, Boolean.valueOf(android2.isGPGEmulator()));
            final String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            Intent intent = new Intent();
            intent.putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, true);
            HiveUiActivity.INSTANCE.launch(activity, intent, new OnActivityLifecycle() { // from class: com.hive.authv4.AuthV4Impl.internalShowProfile.2
                public AuthV4WebView authV4WebView;

                public final AuthV4WebView getAuthV4WebView() {
                    AuthV4WebView authV4WebView = this.authV4WebView;
                    if (authV4WebView != null) {
                        return authV4WebView;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("authV4WebView");
                    return null;
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public boolean onBackPressed() {
                    return getAuthV4WebView().onBackPressed();
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onCreate(Activity activity2, Bundle savedInstanceState) {
                    Intrinsics.checkNotNullParameter(activity2, "activity");
                    super.onCreate(activity2, savedInstanceState);
                    setAuthV4WebView(new AuthV4WebView(activity2, UrlManager.ProfileWeb.INSTANCE.getView() + FileSystemKt.UnixPathSeparator + targetPlayerId, string, "", "", AuthV4WebView.CloseButtonType.TYPE_THEME, new AuthV4Impl$internalShowProfile$2$onCreate$1(playerInfo, targetPlayerId, activity2, fApiName, listener)));
                    getAuthV4WebView().show();
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onDestroy(Activity activity2) {
                    Intrinsics.checkNotNullParameter(activity2, "activity");
                    if (!getIsCalledFinish()) {
                        getAuthV4WebView().dismiss();
                    }
                    super.onDestroy(activity2);
                }

                public final void setAuthV4WebView(AuthV4WebView authV4WebView) {
                    Intrinsics.checkNotNullParameter(authV4WebView, "<set-?>");
                    this.authV4WebView = authV4WebView;
                }
            });
        } catch (Exception e) {
            String str = "[showProfile] invalid post data. " + e;
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), str);
            final ResultAPI resultAPI = new ResultAPI(-1, ResultAPI.Code.AuthV4JsonException, str);
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.internalShowProfile$lambda$72(fApiName, resultAPI, listener);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void internalShowProfile$lambda$72(String str, ResultAPI resultAPI, AuthV4.AuthV4ShowProfileListener authV4ShowProfileListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ShowProfileListener.onAuthV4ShowProfile(resultAPI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void internalSignInGuest(final String fApiName, String recaptchaToken, final AuthV4.AuthV4SignInListener listener) {
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "internalSignInGuest");
        AuthV4Network.INSTANCE.signIn$hive_service_release(recaptchaToken, new Function4() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda37
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return AuthV4Impl.internalSignInGuest$lambda$28(fApiName, listener, (ResultAPI) obj, (SignIn) obj2, (AuthV4.PlayerInfo) obj3, (String) obj4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit internalSignInGuest$lambda$28(final String str, final AuthV4.AuthV4SignInListener authV4SignInListener, final ResultAPI resultApi, SignIn signIn, final AuthV4.PlayerInfo playerInfo, String str2) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(signIn, "signIn");
        if (resultApi.isSuccess() && playerInfo != null) {
            AuthV4Account authV4Account = AuthV4Account.INSTANCE;
            authV4Account.writePlayerInfo(playerInfo);
            if (str2 != null) {
                authV4Account.writeToken(playerInfo.getAccessToken(), str2);
            }
            INSTANCE.onSignInFinish(new ResultAPI(), playerInfo, str, authV4SignInListener);
        } else if (resultApi.getErrorCode() == -12) {
            AuthV4Network.INSTANCE.showBlacklistDialog$hive_service_release(signIn.getResponse(), resultApi, new AuthV4.AuthV4MaintenanceListener() { // from class: com.hive.authv4.AuthV4Impl$internalSignInGuest$1$2
                @Override // com.hive.AuthV4.AuthV4MaintenanceListener
                public void onAuthV4Maintenance(ResultAPI result, ArrayList<AuthV4.AuthV4MaintenanceInfo> maintenanceInfo) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultApi.toString());
                    AuthV4Impl.INSTANCE.onSignInFinish(result, playerInfo, str, authV4SignInListener);
                }
            });
        } else if (resultApi.getErrorCode() == -9) {
            isInProgressSign = false;
            INSTANCE.signOut(new AuthV4.AuthV4SignOutListener() { // from class: com.hive.authv4.AuthV4Impl$internalSignInGuest$1$3
                @Override // com.hive.AuthV4.AuthV4SignOutListener
                public void onAuthV4SignOut(ResultAPI result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    authV4SignInListener.onAuthV4SignIn(resultApi, null);
                }
            });
        } else {
            AuthV4Account.INSTANCE.memoryReset();
            INSTANCE.onSignInFinish(resultApi, playerInfo, str, authV4SignInListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void internalSignInPlayer(final AuthV4.PlayerInfo playerInfo, final String fApiName, final AuthV4.AuthV4SignInListener listener) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i(AuthV4.getTAG(), "internalSignInPlayer");
        if (playerInfo == null) {
            onSignInFinish(new ResultAPI(-1, ResultAPI.Code.AuthV4InvalidSavedPlayerInfo, "invalid param (not exist saved player info."), null, fApiName, listener);
            return;
        }
        AuthV4Account authV4Account = AuthV4Account.INSTANCE;
        String offlineSignInFinish = authV4Account.readOfflineSignInFinish();
        HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
        if (hiveLifecycle.getNetworkAvailable() || !com.hive.core.Configuration.INSTANCE.isOfflineMode() || !Intrinsics.areEqual(offlineSignInFinish, String.valueOf(playerInfo.getPlayerId()))) {
            authV4Account.writeOfflineSignInFinish("");
            AuthV4Network.INSTANCE.signInPlayer$hive_service_release(playerInfo, new Function4() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return AuthV4Impl.internalSignInPlayer$lambda$32(playerInfo, fApiName, listener, (ResultAPI) obj, (SignInPlayer) obj2, (AuthV4.PlayerInfo) obj3, (String) obj4);
                }
            });
            return;
        }
        loggerImpl.i(AuthV4.getTAG(), "[onSignInFinish. Activate Offline Mode.");
        authV4Account.writePlayerInfo(playerInfo);
        authV4Account.loadToken();
        isInProgressSign = false;
        isAutoSignIn = true;
        recentIdentity = null;
        hiveLifecycle.onSignIn(authV4Account.toHiveAccount());
        mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4Impl.internalSignInPlayer$lambda$29(fApiName, listener, playerInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void internalSignInPlayer$lambda$29(String str, AuthV4.AuthV4SignInListener authV4SignInListener, AuthV4.PlayerInfo playerInfo) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, new ResultAPI().toString());
        authV4SignInListener.onAuthV4SignIn(new ResultAPI(), playerInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit internalSignInPlayer$lambda$32(final AuthV4.PlayerInfo playerInfo, final String str, final AuthV4.AuthV4SignInListener authV4SignInListener, final ResultAPI resultApi, SignInPlayer signInPlayer, AuthV4.PlayerInfo responsePlayerInfo, String str2) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(signInPlayer, "signInPlayer");
        Intrinsics.checkNotNullParameter(responsePlayerInfo, "responsePlayerInfo");
        if (resultApi.isSuccess()) {
            AuthV4Account authV4Account = AuthV4Account.INSTANCE;
            authV4Account.writePlayerInfo(responsePlayerInfo);
            if (str2 != null) {
                authV4Account.writeToken(responsePlayerInfo.getAccessToken(), str2);
            }
            AuthV4.PlayerInfo playerInfo2 = authV4Account.getPlayerInfo();
            if (playerInfo2 != null) {
                for (AuthV4.ProviderType providerType : playerInfo2.getProviderInfoData().keySet()) {
                    Intrinsics.checkNotNullExpressionValue(providerType, "next(...)");
                    AuthV4ProviderAdapter.INSTANCE.getInstance(providerType);
                }
            }
            INSTANCE.onSignInFinish(resultApi, playerInfo, str, authV4SignInListener);
        } else if (resultApi.getErrorCode() == -12) {
            AuthV4Network.INSTANCE.showBlacklistDialog$hive_service_release(signInPlayer.getResponse(), resultApi, new AuthV4.AuthV4MaintenanceListener() { // from class: com.hive.authv4.AuthV4Impl$internalSignInPlayer$2$3
                @Override // com.hive.AuthV4.AuthV4MaintenanceListener
                public void onAuthV4Maintenance(ResultAPI result, ArrayList<AuthV4.AuthV4MaintenanceInfo> maintenanceInfo) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    AuthV4Impl.INSTANCE.onSignInFinish(result, playerInfo, str, authV4SignInListener);
                }
            });
        } else if (resultApi.getErrorCode() == -9) {
            isInProgressSign = false;
            INSTANCE.signOut(new AuthV4.AuthV4SignOutListener() { // from class: com.hive.authv4.AuthV4Impl$internalSignInPlayer$2$4
                @Override // com.hive.AuthV4.AuthV4SignOutListener
                public void onAuthV4SignOut(ResultAPI result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    authV4SignInListener.onAuthV4SignIn(resultApi, null);
                }
            });
        } else {
            AuthV4Account.INSTANCE.memoryReset();
            INSTANCE.onSignInFinish(resultApi, playerInfo, str, authV4SignInListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void internalSignInProvider(final AuthV4ProviderAdapter provider, String player, final String fApiName, final AuthV4.AuthV4SignInListener listener) {
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "internalSignInProvider");
        AuthV4Network.INSTANCE.signInIdp$hive_service_release(provider, player, new Function4() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return AuthV4Impl.internalSignInProvider$lambda$37(provider, fApiName, listener, (ResultAPI) obj, (SignInIdp) obj2, (AuthV4.PlayerInfo) obj3, (String) obj4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit internalSignInProvider$lambda$37(AuthV4ProviderAdapter authV4ProviderAdapter, final String str, final AuthV4.AuthV4SignInListener authV4SignInListener, final ResultAPI resultApi, SignInIdp signInIdp, final AuthV4.PlayerInfo playerInfo, String str2) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(signInIdp, "signInIdp");
        if (resultApi.isSuccess() && playerInfo != null) {
            AuthV4Account authV4Account = AuthV4Account.INSTANCE;
            authV4Account.writePlayerInfo(playerInfo);
            if (str2 != null) {
                authV4Account.writeToken(playerInfo.getAccessToken(), str2);
            }
            INSTANCE.uploadProfile(playerInfo, authV4ProviderAdapter, new Function1() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthV4Impl.internalSignInProvider$lambda$37$lambda$36(resultApi, playerInfo, str, authV4SignInListener, (ResultAPI) obj);
                }
            });
        } else if (resultApi.getErrorCode() == -12) {
            authV4ProviderAdapter.logout(new AuthV4ProviderAdapter.ProviderLogoutListener() { // from class: com.hive.authv4.AuthV4Impl$internalSignInProvider$1$3
                @Override // com.hive.authv4.provider.AuthV4ProviderAdapter.ProviderLogoutListener
                public void onProviderLogoutListener(ResultAPI result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    LoggerImpl.INSTANCE.d("[internalSignInProvider] blacklist error, provider logout result : " + result);
                }
            });
            AuthV4Network.INSTANCE.showBlacklistDialog$hive_service_release(signInIdp.getResponse(), resultApi, new AuthV4.AuthV4MaintenanceListener() { // from class: com.hive.authv4.AuthV4Impl$internalSignInProvider$1$4
                @Override // com.hive.AuthV4.AuthV4MaintenanceListener
                public void onAuthV4Maintenance(ResultAPI result, ArrayList<AuthV4.AuthV4MaintenanceInfo> maintenanceInfo) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    AuthV4Account.INSTANCE.memoryReset();
                    AuthV4Impl.INSTANCE.onSignInFinish(result, playerInfo, str, authV4SignInListener);
                }
            });
        } else if (resultApi.getErrorCode() == -9) {
            isInProgressSign = false;
            INSTANCE.signOut(new AuthV4.AuthV4SignOutListener() { // from class: com.hive.authv4.AuthV4Impl$internalSignInProvider$1$5
                @Override // com.hive.AuthV4.AuthV4SignOutListener
                public void onAuthV4SignOut(ResultAPI result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    authV4SignInListener.onAuthV4SignIn(resultApi, null);
                }
            });
        } else {
            INSTANCE.onSignInFinish(resultApi, playerInfo, str, authV4SignInListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit internalSignInProvider$lambda$37$lambda$36(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo, String str, AuthV4.AuthV4SignInListener authV4SignInListener, ResultAPI resultAPI2) {
        Intrinsics.checkNotNullParameter(resultAPI2, "<unused var>");
        INSTANCE.onSignInFinish(resultAPI, playerInfo, str, authV4SignInListener);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void internalSignOut(final String fApiName, final AuthV4.AuthV4SignOutListener listener) {
        AuthV4Account authV4Account = AuthV4Account.INSTANCE;
        authV4Account.removePlayerInfo();
        authV4Account.removeToken();
        authV4Account.writeOfflineSignInFinish("");
        AuthV4ProviderAdapter.INSTANCE.allLogout(new AuthV4ProviderAdapter.ProviderLogoutListener() { // from class: com.hive.authv4.AuthV4Impl.internalSignOut.1
            @Override // com.hive.authv4.provider.AuthV4ProviderAdapter.ProviderLogoutListener
            public void onProviderLogoutListener(ResultAPI result) {
                Intrinsics.checkNotNullParameter(result, "result");
                AuthV4Impl.isInProgressSign = false;
                AuthV4Impl.INSTANCE.onSignOutFinish(new ResultAPI(), fApiName, listener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object internalSignOutAwait(Continuation<? super Integer> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        INSTANCE.internalSignOut("internalSignOutAwait", new AuthV4.AuthV4SignOutListener() { // from class: com.hive.authv4.AuthV4Impl$internalSignOutAwait$2$1
            @Override // com.hive.AuthV4.AuthV4SignOutListener
            public void onAuthV4SignOut(ResultAPI result) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (cancellableContinuationImpl.isActive()) {
                    CancellableContinuation<Integer> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m7415constructorimpl(0));
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final void internalStorePlayerId(final ResultAPI result, final String fApiName, final AuthV4.AuthV4StorePlayerIdListener listener) {
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "internalStorePlayerId - \nresult: " + result);
        mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda68
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4Impl.internalStorePlayerId$lambda$119(fApiName, result, listener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void internalStorePlayerId$lambda$119(String str, ResultAPI resultAPI, AuthV4.AuthV4StorePlayerIdListener authV4StorePlayerIdListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        if (authV4StorePlayerIdListener != null) {
            authV4StorePlayerIdListener.onAuthV4StorePlayerId(resultAPI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isRecaptchaEnable() {
        Object objM7415constructorimpl;
        JSONArray jSONArrayOptJSONArray;
        JSONObject metaData = com.hive.core.Configuration.INSTANCE.getMetaData();
        if (metaData != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                if (Intrinsics.areEqual(metaData.optString("is_recaptcha"), "1") && (jSONArrayOptJSONArray = metaData.optJSONArray("recaptcha_info_list")) != null) {
                    int length = jSONArrayOptJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null && Intrinsics.areEqual(jSONObjectOptJSONObject.optString("recaptcha_type"), "v3_app") && Intrinsics.areEqual(jSONObjectOptJSONObject.optString("is_recaptcha"), "1")) {
                            LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "isRecaptchaEnable: true");
                            return true;
                        }
                    }
                }
                objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
            if (thM7418exceptionOrNullimpl != null) {
                LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "isRecaptchaEnable exception: " + thM7418exceptionOrNullimpl);
            }
            Result.m7414boximpl(objM7415constructorimpl);
        }
        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "isRecaptchaEnable: false");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAgreementFail(ResultAPI resultAPI) {
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[Setup 6. Agreement Fail, Skip all processes remained]");
        if (ConfigurationImpl.INSTANCE.isAgreementDetermineBaseAccount()) {
            return;
        }
        onSetupFail(resultAPI);
    }

    private final void onAgreementFinish(JSONArray agreementJsonArray, CancellableContinuation<? super Boolean> cont) {
        String strOptString;
        String str;
        JSONObject jSONObjectOptJSONObject;
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[Setup. save privacy list (age_gate_u13) & initialize 3rd party tracker]");
        HiveLifecycle.INSTANCE.onAgreement();
        String hiveCountry = ConfigurationImpl.INSTANCE.getHiveCountry();
        int length = agreementJsonArray.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                strOptString = null;
                break;
            }
            JSONObject jSONObjectOptJSONObject2 = agreementJsonArray.optJSONObject(i);
            int i2 = length;
            if (jSONObjectOptJSONObject2 != null && Intrinsics.areEqual(jSONObjectOptJSONObject2.optString("type"), "terms") && Intrinsics.areEqual(jSONObjectOptJSONObject2.optString(UserDataStore.COUNTRY), hiveCountry)) {
                strOptString = jSONObjectOptJSONObject2.optString("scheme");
                break;
            } else {
                i++;
                length = i2;
            }
        }
        if (strOptString != null && (!StringsKt.isBlank(strOptString))) {
            try {
                String queryParameter = Uri.parse(strOptString).getQueryParameter("agreement");
                if (queryParameter != null) {
                    StringUtil stringUtil = StringUtil.INSTANCE;
                    Charset charset = Charsets.UTF_8;
                    byte[] bytes = queryParameter.getBytes(charset);
                    str = strOptString;
                    try {
                        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                        byte[] base64Decode = stringUtil.toBase64Decode(bytes, 4);
                        String str2 = base64Decode != null ? new String(base64Decode, charset) : null;
                        if (str2 != null) {
                            JSONObject jSONObject = new JSONObject(str2);
                            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                            loggerImpl.dL(AuthV4.getTAG(), "[Setup. Agreement Scheme (" + hiveCountry + ") ] : \n" + jSONObject.toString(4) + '\n');
                            String tag = AuthV4.getTAG();
                            StringBuilder sb = new StringBuilder();
                            sb.append("[Setup. Agreement Scheme (");
                            sb.append(hiveCountry);
                            sb.append(") ]");
                            loggerImpl.dR(tag, sb.toString());
                            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("item");
                            if (jSONObjectOptJSONObject3 != null && jSONObjectOptJSONObject3.optInt("age_gate_u13") == 1) {
                                ConfigurationImpl.INSTANCE.setAgeGateU13(true);
                            }
                            if (jSONObjectOptJSONObject3 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject3.optJSONObject("privacy_list")) != null) {
                                Android android2 = Android.INSTANCE;
                                android2.getHwIds().put(Android.HW_IDS_ANDROID_ID, Boolean.valueOf(jSONObjectOptJSONObject.optBoolean(Android.HW_IDS_ANDROID_ID, false)));
                                android2.getHwIds().put(Android.HW_IDS_IMEI, Boolean.valueOf(jSONObjectOptJSONObject.optBoolean(Android.HW_IDS_IMEI, false)));
                                android2.getHwIds().put(Android.HW_IDS_ADVERTISING_ID, Boolean.valueOf(jSONObjectOptJSONObject.optBoolean(Android.HW_IDS_ADVERTISING_ID, false)));
                                android2.getHwIds().put(Android.HW_IDS_IS_LIMIT_AD_TRACKING, Boolean.valueOf(jSONObjectOptJSONObject.optBoolean(Android.HW_IDS_IS_LIMIT_AD_TRACKING, false)));
                                android2.getHwIds().put(Android.HW_IDS_VENDOR_ID, Boolean.valueOf(jSONObjectOptJSONObject.optBoolean(Android.HW_IDS_VENDOR_ID, false)));
                                android2.getHwIds().put(Android.HW_IDS_DEVICE_TOKEN, Boolean.valueOf(jSONObjectOptJSONObject.optBoolean(Android.HW_IDS_DEVICE_TOKEN, false)));
                                android2.getHwIds().put(Android.HW_IDS_DEVICE_MODEL, Boolean.valueOf(jSONObjectOptJSONObject.optBoolean(Android.HW_IDS_DEVICE_MODEL, false)));
                                android2.getHwIds().put(Android.HW_IDS_MDN, Boolean.valueOf(jSONObjectOptJSONObject.optBoolean(Android.HW_IDS_MDN, false)));
                                android2.getHwIds().put(Android.HW_IDS_MCC, Boolean.valueOf(jSONObjectOptJSONObject.optBoolean(Android.HW_IDS_MCC, false)));
                                android2.getHwIds().put(Android.HW_IDS_MNC, Boolean.valueOf(jSONObjectOptJSONObject.optBoolean(Android.HW_IDS_MNC, false)));
                                loggerImpl.dL(AuthV4.getTAG(), "Setup. save privacy list : \n" + android2.getHwIds());
                                loggerImpl.dR(AuthV4.getTAG(), "Setup. save privacy list");
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[Setup. onAgreementFinish exception]\n    Target Scheme : " + str + "\n    " + e + '\n');
                    }
                }
                throw new Exception("onAgreementFinish, Query Parameter 'agreement' is empty.");
            } catch (Exception e2) {
                e = e2;
                str = strOptString;
            }
        }
        if (cont.isActive()) {
            Result.Companion companion = Result.INSTANCE;
            cont.resumeWith(Result.m7415constructorimpl(Boolean.TRUE));
        }
    }

    private final void onAgreementNotShowFinish(CancellableContinuation<? super Boolean> cont) {
        JSONArray jSONArray;
        String value = Property.INSTANCE.getINSTANCE().getValue(AuthV4Keys.AGREEMENT_AGREED_DATA);
        if (value == null || StringsKt.isBlank(value)) {
            jSONArray = new JSONArray();
        } else {
            try {
                jSONArray = new JSONArray(value);
            } catch (Exception unused) {
                jSONArray = new JSONArray();
            }
        }
        onAgreementFinish(jSONArray, cont);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAgreementUiResult(ArrayList<Agreement> agreementList, CancellableContinuation<? super Boolean> cont) {
        JSONArray jSONArray;
        String scheme;
        JSONObject jSONObjectOptJSONObject;
        byte[] base64Decode$default;
        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[Setup. on agreement result & finish}");
        String value = Property.INSTANCE.getINSTANCE().getValue(AuthV4Keys.AGREEMENT_AGREED_DATA);
        if (value == null || StringsKt.isBlank(value)) {
            jSONArray = new JSONArray();
        } else {
            try {
                jSONArray = new JSONArray(value);
            } catch (Exception unused) {
                jSONArray = new JSONArray();
            }
        }
        if (agreementList != null) {
            try {
                Iterator<Agreement> it = agreementList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                boolean z = false;
                while (it.hasNext()) {
                    Agreement next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    Agreement agreement = next;
                    LoggerImpl.INSTANCE.dL(AuthV4.getTAG(), "[onAgreementResult] " + agreement);
                    String type = agreement.getType();
                    if ((type != null && !StringsKt.isBlank(type)) || ((scheme = agreement.getScheme()) != null && !StringsKt.isBlank(scheme))) {
                        JSONObject jSONObject = new JSONObject();
                        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_type, agreement.getType());
                        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_scheme, agreement.getScheme());
                        HiveKeys hiveKeys = HiveKeys.KEY_app_version;
                        Android android2 = Android.INSTANCE;
                        CommonIdentifierKt.put(jSONObject, hiveKeys, android2.getAppVersion());
                        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_mdn, android2.getMobileDeviceNumber());
                        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_country, agreement.getCountry());
                        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_language, android2.getLanguage());
                        CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_game_language, ConfigurationImpl.INSTANCE.getHiveLanguage());
                        int length = jSONArray.length();
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                jSONArray.put(jSONObject);
                                break;
                            }
                            JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i);
                            if (jSONObjectOptJSONObject2 != null && Intrinsics.areEqual(jSONObjectOptJSONObject2.optString("type"), agreement.getType())) {
                                if (!Intrinsics.areEqual("terms", agreement.getType())) {
                                    jSONArray.put(i, jSONObject);
                                    break;
                                } else if (Intrinsics.areEqual(jSONObjectOptJSONObject2.optString(UserDataStore.COUNTRY), agreement.getCountry())) {
                                    jSONArray.put(i, jSONObject);
                                    break;
                                }
                            }
                            i++;
                        }
                        try {
                            String queryParameter = Uri.parse(agreement.getScheme()).getQueryParameter("agreement");
                            JSONObject jSONObject2 = null;
                            if (queryParameter != null) {
                                Charset charset = Charsets.UTF_8;
                                byte[] bytes = queryParameter.getBytes(charset);
                                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                                if (bytes != null && (base64Decode$default = StringUtil.toBase64Decode$default(StringUtil.INSTANCE, bytes, 0, 1, null)) != null) {
                                    jSONObject2 = new JSONObject(new String(base64Decode$default, charset));
                                }
                            }
                            if (jSONObject2 != null && (jSONObjectOptJSONObject = jSONObject2.optJSONObject("item")) != null) {
                                if (jSONObjectOptJSONObject.has(Constants.PUSH)) {
                                    PushImpl.INSTANCE.onAgreement(agreement.getShow(), new Push.RemotePush(jSONObjectOptJSONObject.optBoolean(Constants.PUSH, false), jSONObjectOptJSONObject.optBoolean("night_push", false)));
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                        } catch (Exception e) {
                            LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "AUTHV4_AGREEMENT_REQUEST scheme parsing failed. - " + e);
                            Unit unit2 = Unit.INSTANCE;
                        }
                        z = true;
                    }
                }
                if (jSONArray.length() <= 0 || !z) {
                    LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "AUTHV4_AGREEMENT_REQUEST in onAgreementResult, agreement JsonArray length is ZERO");
                } else {
                    Property.Companion companion = Property.INSTANCE;
                    Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.AGREEMENT_AGREED_DATA, jSONArray.toString(), null, 4, null);
                    Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.AGREEMENT_SENT_PLAYER_LIST, "", null, 4, null);
                    Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.AGREEMENT_IS_SENT_BEFORE_LOGIN, "false", null, 4, null);
                    companion.getINSTANCE().writeProperties();
                    LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "AUTHV4_AGREEMENT_REQUEST added.");
                }
            } catch (Exception e2) {
                LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "AUTHV4_AGREEMENT_REQUEST exception in onAgreementResult: " + e2);
            }
        }
        Property.Companion companion2 = Property.INSTANCE;
        Property.setValue$default(companion2.getINSTANCE(), AuthV4Keys.AGREEMENT_AGREED_EVER, "true", null, 4, null);
        companion2.getINSTANCE().writeProperties();
        onAgreementFinish(jSONArray, cont);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCheckProviderFinish(final ResultAPI result, final AuthV4.ProviderInfo providerInfo, final String fApiName, final AuthV4.AuthV4CheckProviderListener listener) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.iL(AuthV4.getTAG(), "onConnectFinish - \nresult: " + result + "\nproviderInfo: " + providerInfo);
        loggerImpl.iL(AuthV4.getTAG(), "onConnectFinish");
        mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda28
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4Impl.onCheckProviderFinish$lambda$128(fApiName, result, listener, providerInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCheckProviderFinish$lambda$128(String str, ResultAPI resultAPI, AuthV4.AuthV4CheckProviderListener authV4CheckProviderListener, AuthV4.ProviderInfo providerInfo) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        if (authV4CheckProviderListener != null) {
            authV4CheckProviderListener.onDeviceProviderInfo(resultAPI, providerInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onConnectFinish(final ResultAPI connectResult, final AuthV4.PlayerInfo conflictPlayer, final String fApiName, final AuthV4.AuthV4ConnectListener listener) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.iL(AuthV4.getTAG(), "onConnectFinish - \nresult: " + connectResult + "\nconflictPlayer: " + conflictPlayer);
        String tag = AuthV4.getTAG();
        StringBuilder sb = new StringBuilder("onConnectFinish - \nresult: ");
        sb.append(connectResult);
        sb.append("\nconflictPlayer: ");
        sb.append(conflictPlayer != null ? Long.valueOf(conflictPlayer.getPlayerId()) : null);
        loggerImpl.iR(tag, sb.toString());
        AuthV4.PlayerInfo playerInfo = AuthV4Account.INSTANCE.getPlayerInfo();
        if (!connectResult.isSuccess() || playerInfo == null) {
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.onConnectFinish$lambda$126(fApiName, connectResult, listener, conflictPlayer);
                }
            });
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(playerInfo.getPlayerId()));
        getProfile(arrayList, new C28311(playerInfo, fApiName, connectResult, listener, conflictPlayer));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onConnectFinish$lambda$126(String str, ResultAPI resultAPI, AuthV4.AuthV4ConnectListener authV4ConnectListener, AuthV4.PlayerInfo playerInfo) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        if (authV4ConnectListener != null) {
            authV4ConnectListener.onAuthV4Connect(resultAPI, playerInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDisconnectFinish(final ResultAPI result, final String fApiName, final AuthV4.AuthV4DisconnectListener listener) {
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "onDisconnectFinish - \nresult: " + result);
        mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda69
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4Impl.onDisconnectFinish$lambda$127(fApiName, result, listener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDisconnectFinish$lambda$127(String str, ResultAPI resultAPI, AuthV4.AuthV4DisconnectListener authV4DisconnectListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        if (authV4DisconnectListener != null) {
            authV4DisconnectListener.onAuthV4Disconnect(resultAPI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onMaintenanceFail(MaintenanceDialog.MaintenanceActionType buttonAction) {
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[Setup 3, 5 or 10. Maintenance Fail, Skip all processes remained]");
        int i = WhenMappings.$EnumSwitchMapping$0[buttonAction.ordinal()];
        onSetupFail(i != 1 ? i != 2 ? i != 3 ? i != 4 ? new ResultAPI(-17, ResultAPI.Code.AuthV4MaintenanceActionDefault_DoExit, "") : new ResultAPI(0, ResultAPI.Code.AuthV4MaintenanceActionDone, "") : new ResultAPI(-17, ResultAPI.Code.AuthV4MaintenanceActionExit_DoExit, "") : new ResultAPI(-17, ResultAPI.Code.AuthV4MaintenanceActionOpenURL_DoExit, "") : new ResultAPI(-17, ResultAPI.Code.AuthV4MaintenanceTimeover_DoExit, ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSetupFail(final ResultAPI resultApi) {
        int i = WhenMappings.$EnumSwitchMapping$2[resultApi.getCode().ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            memoryReset$hive_service_release();
        }
        mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda35
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4Impl.onSetupFail$lambda$123(resultApi);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSetupFail$lambda$123(ResultAPI resultAPI) {
        AuthV4.AuthV4SetupListener authV4SetupListener = internalAuthV4SetupListener;
        if (authV4SetupListener != null) {
            authV4SetupListener.onAuthV4Setup(resultAPI, false, null, null);
        }
    }

    private final void onSetupFinish(final ResultAPI resultAPI, final boolean isAutoSignIn2, final String did, final ArrayList<AuthV4.ProviderType> providerTypeList) {
        StringBuilder sb = new StringBuilder("\n            [Setup. onSetupFinish]\n            resultAPI : ");
        sb.append(resultAPI);
        sb.append("\n            isAutoSignIn : ");
        sb.append(isAutoSignIn2);
        sb.append("\n            did : ");
        sb.append(did);
        sb.append("\n            providerList: ");
        sb.append(providerTypeList != null ? providerTypeList.toString() : null);
        sb.append("\n        ");
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), StringsKt.trimIndent(sb.toString()));
        printLogRefSDKVersion();
        if (resultAPI.isSuccess()) {
            isAutoSignIn = isAutoSignIn2;
            isSetup = true;
            Property.Companion companion = Property.INSTANCE;
            if (companion.getINSTANCE().getValue("FirstInit", "").length() == 0) {
                Property.setValue$default(companion.getINSTANCE(), "FirstInit", "True", null, 4, null);
            } else {
                Property.setValue$default(companion.getINSTANCE(), "FirstInit", "False", null, 4, null);
            }
            companion.getINSTANCE().writeProperties();
            HiveLifecycle.INSTANCE.onSetupFinished();
        }
        mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda42
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4Impl.onSetupFinish$lambda$122(resultAPI, isAutoSignIn2, did, providerTypeList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSetupFinish$lambda$122(ResultAPI resultAPI, boolean z, String str, ArrayList arrayList) {
        AuthV4.AuthV4SetupListener authV4SetupListener = internalAuthV4SetupListener;
        if (authV4SetupListener != null) {
            authV4SetupListener.onAuthV4Setup(resultAPI, z, str, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSignInFinish(final ResultAPI signInResult, final AuthV4.PlayerInfo playerInfo, final String fApiName, final AuthV4.AuthV4SignInListener listener) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.iL(AuthV4.getTAG(), "onSignInFinish - \nresult: " + signInResult + "\nplayerInfo: " + playerInfo);
        String tag = AuthV4.getTAG();
        StringBuilder sb = new StringBuilder("onSignInFinish - \nresult: ");
        sb.append(signInResult);
        sb.append("\nplayerInfo: ");
        sb.append(playerInfo != null ? Long.valueOf(playerInfo.getPlayerId()) : null);
        loggerImpl.iR(tag, sb.toString());
        printLogRefSDKVersion();
        if (signInResult.isSuccess() && playerInfo != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(defaultDispatcher), null, null, new C28321(playerInfo, listener, signInResult, fApiName, null), 3, null);
        } else if (signInResult.getCode() == ResultAPI.Code.AuthV4NeedSignIn) {
            isInProgressSign = false;
            signOut(new AuthV4.AuthV4SignOutListener() { // from class: com.hive.authv4.AuthV4Impl.onSignInFinish.2
                @Override // com.hive.AuthV4.AuthV4SignOutListener
                public void onAuthV4SignOut(ResultAPI result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), fApiName, result.toString());
                    AuthV4.AuthV4SignInListener authV4SignInListener = listener;
                    if (authV4SignInListener != null) {
                        authV4SignInListener.onAuthV4SignIn(signInResult, playerInfo);
                    }
                }
            });
        } else {
            isInProgressSign = false;
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.onSignInFinish$lambda$124(fApiName, signInResult, listener, playerInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSignInFinish$lambda$124(String str, ResultAPI resultAPI, AuthV4.AuthV4SignInListener authV4SignInListener, AuthV4.PlayerInfo playerInfo) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        if (authV4SignInListener != null) {
            authV4SignInListener.onAuthV4SignIn(resultAPI, playerInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSignOutFinish(final ResultAPI result, final String fApiName, final AuthV4.AuthV4SignOutListener listener) {
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "onSignOutFinish - \nresult: " + result);
        if (result.isSuccess()) {
            isAutoSignIn = false;
            AuthV4Account.INSTANCE.resetEnableAutoLogin();
            HiveLifecycle.INSTANCE.onSignOut();
        }
        mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda34
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4Impl.onSignOutFinish$lambda$125(fApiName, result, listener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSignOutFinish$lambda$125(String str, ResultAPI resultAPI, AuthV4.AuthV4SignOutListener authV4SignOutListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        if (authV4SignOutListener != null) {
            authV4SignOutListener.onAuthV4SignOut(resultAPI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit playerDelete$lambda$46(String str, AuthV4.AuthV4SignOutListener authV4SignOutListener, ResultAPI resultAPI, PlayerDelete playerDelete) {
        Intrinsics.checkNotNullParameter(resultAPI, "resultAPI");
        Intrinsics.checkNotNullParameter(playerDelete, "<unused var>");
        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[delete] Result: " + resultAPI);
        isInProgressSign = false;
        if (resultAPI.isFailure()) {
            INSTANCE.onSignOutFinish(resultAPI, str, authV4SignOutListener);
        } else {
            INSTANCE.signOut(authV4SignOutListener);
        }
        return Unit.INSTANCE;
    }

    private final void printLogRefSDKVersion() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C28341(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processAgreement(GetAgreement.GetAgreementResponse responseProvisionGetAgreement, final CancellableContinuation<? super Boolean> cont) {
        String scheme;
        String url;
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[Setup. process Agreement]");
        if (!StringsKt.isBlank(responseProvisionGetAgreement.getReviewUrl())) {
            Property.Companion companion = Property.INSTANCE;
            Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.AGREEMENT_REVIEW_URL, responseProvisionGetAgreement.getReviewUrl(), null, 4, null);
            companion.getINSTANCE().writeProperties();
        }
        Property.Companion companion2 = Property.INSTANCE;
        String value = companion2.getINSTANCE().getValue(AuthV4Keys.AGREEMENT_AGREED_DATA);
        String value2 = companion2.getINSTANCE().getValue(AuthV4Keys.AGREEMENT_AGREED_EVER);
        if (value2 == null) {
            value2 = "false";
        }
        if (value != null) {
            StringsKt.isBlank(value);
        }
        Boolean.parseBoolean(value2);
        if (!responseProvisionGetAgreement.isSuccess()) {
            onAgreementNotShowFinish(cont);
            return;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray agreementJsonArray = responseProvisionGetAgreement.getAgreementJsonArray();
        if (agreementJsonArray != null) {
            int length = agreementJsonArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = agreementJsonArray.optJSONObject(i);
                Agreement.ViewMode.Companion companion3 = Agreement.ViewMode.INSTANCE;
                if (jSONObjectOptJSONObject != null) {
                    try {
                        boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("show");
                        Agreement.ViewMode viewMode = Agreement.ViewMode.INSTANCE.getViewMode(jSONObjectOptJSONObject.optString("view_mode"));
                        if (viewMode == null) {
                            viewMode = Agreement.ViewMode.OPTION;
                        }
                        Agreement.ViewMode viewMode2 = viewMode;
                        String strOptString = jSONObjectOptJSONObject.optString("type");
                        if (strOptString == null || StringsKt.isBlank(strOptString)) {
                            throw new Exception("invalid agreement type: " + strOptString);
                        }
                        arrayList.add(new Agreement("", responseProvisionGetAgreement.getHiveCountry(), zOptBoolean, viewMode2, strOptString, jSONObjectOptJSONObject.optString("url"), jSONObjectOptJSONObject.optString("group_code"), jSONObjectOptJSONObject.optInt("version", -1), jSONObjectOptJSONObject.optString("review_url"), jSONObjectOptJSONObject.optString("scheme")));
                    } catch (Exception e) {
                        LoggerImpl.INSTANCE.w("ResponseProvisionGetAgreement agreement data exception: " + e);
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            onAgreementNotShowFinish(cont);
            return;
        }
        final ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            Agreement agreement = (Agreement) next;
            if ((agreement.getShow() && (url = agreement.getUrl()) != null && (!StringsKt.isBlank(url))) || ((scheme = agreement.getScheme()) != null && (!StringsKt.isBlank(scheme)))) {
                arrayList2.add(agreement);
            }
        }
        if (arrayList2.isEmpty()) {
            onAgreementNotShowFinish(cont);
        } else {
            HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new OnActivityLifecycle() { // from class: com.hive.authv4.AuthV4Impl.processAgreement.2
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
                    ArrayList<Agreement> arrayList3 = arrayList2;
                    final CancellableContinuation<Boolean> cancellableContinuation = cont;
                    setAuthV4AgreementView(new AuthV4AgreementView(activity, arrayList3, new AuthV4AgreementView.AuthV4AgreementDialogListener() { // from class: com.hive.authv4.AuthV4Impl$processAgreement$2$onCreate$1
                        @Override // com.hive.authv4.webviewflow.AuthV4AgreementView.AuthV4AgreementDialogListener
                        public void onAgreementDeny(ResultAPI resultAPI) {
                            Intrinsics.checkNotNullParameter(resultAPI, "resultAPI");
                            if (cancellableContinuation.isActive()) {
                                CancellableContinuation<Boolean> cancellableContinuation2 = cancellableContinuation;
                                Result.Companion companion4 = Result.INSTANCE;
                                cancellableContinuation2.resumeWith(Result.m7415constructorimpl(Boolean.FALSE));
                            }
                            AuthV4Impl.INSTANCE.onAgreementFail(resultAPI);
                            activity.finish();
                        }

                        @Override // com.hive.authv4.webviewflow.AuthV4AgreementView.AuthV4AgreementDialogListener
                        public void onAgreementFinish(ArrayList<AuthV4Impl.Agreement> agreementList, String jsMessage) {
                            Intrinsics.checkNotNullParameter(agreementList, "agreementList");
                            Intrinsics.checkNotNullParameter(jsMessage, "jsMessage");
                            try {
                                if (!StringsKt.isBlank(jsMessage)) {
                                    JSONObject jSONObject = new JSONObject(jsMessage);
                                    LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                                    loggerImpl.iL(AuthV4.getTAG(), "[Setup. JS Interface] : \n" + jSONObject.toString(4));
                                    loggerImpl.iR(AuthV4.getTAG(), "[Setup. JS Interface]");
                                    if (jSONObject.optInt("age_gate_u13") == 1) {
                                        ConfigurationImpl.INSTANCE.setAgeGateU13(true);
                                    }
                                    Android android2 = Android.INSTANCE;
                                    android2.getHwIds().put(Android.HW_IDS_ANDROID_ID, Boolean.valueOf(jSONObject.optBoolean(Android.HW_IDS_ANDROID_ID, false)));
                                    android2.getHwIds().put(Android.HW_IDS_IMEI, Boolean.valueOf(jSONObject.optBoolean(Android.HW_IDS_IMEI, false)));
                                    android2.getHwIds().put(Android.HW_IDS_ADVERTISING_ID, Boolean.valueOf(jSONObject.optBoolean(Android.HW_IDS_ADVERTISING_ID, false)));
                                    android2.getHwIds().put(Android.HW_IDS_IS_LIMIT_AD_TRACKING, Boolean.valueOf(jSONObject.optBoolean(Android.HW_IDS_IS_LIMIT_AD_TRACKING, false)));
                                    android2.getHwIds().put(Android.HW_IDS_VENDOR_ID, Boolean.valueOf(jSONObject.optBoolean(Android.HW_IDS_VENDOR_ID, false)));
                                    android2.getHwIds().put(Android.HW_IDS_DEVICE_TOKEN, Boolean.valueOf(jSONObject.optBoolean(Android.HW_IDS_DEVICE_TOKEN, false)));
                                    android2.getHwIds().put(Android.HW_IDS_DEVICE_MODEL, Boolean.valueOf(jSONObject.optBoolean(Android.HW_IDS_DEVICE_MODEL, false)));
                                    android2.getHwIds().put(Android.HW_IDS_MDN, Boolean.valueOf(jSONObject.optBoolean(Android.HW_IDS_MDN, false)));
                                    android2.getHwIds().put(Android.HW_IDS_MCC, Boolean.valueOf(jSONObject.optBoolean(Android.HW_IDS_MCC, false)));
                                    android2.getHwIds().put(Android.HW_IDS_MNC, Boolean.valueOf(jSONObject.optBoolean(Android.HW_IDS_MNC, false)));
                                }
                            } catch (Exception e2) {
                                LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[Setup. JS Interface Exception] : " + e2);
                            }
                            AuthV4Impl.INSTANCE.onAgreementUiResult(agreementList, cancellableContinuation);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processAgreementWithMaintenance(Triple<ResultAPI, GetAgreement, ? extends ArrayList<AuthV4.AuthV4MaintenanceInfo>> triple, Continuation<? super Boolean> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[Setup. process agreement maintenance]");
        triple.getFirst();
        final GetAgreement.GetAgreementResponse response = triple.getSecond().getResponse();
        ArrayList<AuthV4.AuthV4MaintenanceInfo> third = triple.getThird();
        if (!response.isSuccess() || third.isEmpty()) {
            INSTANCE.processAgreement(response, cancellableContinuationImpl);
        } else {
            Boxing.boxBoolean(mainLooperHandler.post(INSTANCE.createMaintenanceRunnable(0, third, new MaintenanceDialog.OnDismissListener() { // from class: com.hive.authv4.AuthV4Impl$processAgreementWithMaintenance$2$1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialog) {
                    Intrinsics.checkNotNullParameter(dialog, "dialog");
                    AuthV4Impl.INSTANCE.processAgreement(response, cancellableContinuationImpl);
                }

                @Override // com.hive.auth.MaintenanceDialog.OnDismissListener
                public void onDismissWithButtonAction(DialogInterface dialog, MaintenanceDialog.MaintenanceActionType buttonAction) {
                    Intrinsics.checkNotNullParameter(dialog, "dialog");
                    Intrinsics.checkNotNullParameter(buttonAction, "buttonAction");
                    AuthV4Impl.INSTANCE.onMaintenanceFail(buttonAction);
                    if (cancellableContinuationImpl.isActive()) {
                        CancellableContinuation<Boolean> cancellableContinuation = cancellableContinuationImpl;
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m7415constructorimpl(Boolean.FALSE));
                    }
                }
            })));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processGamerId(final AuthV4ProviderAdapter provider, final String fApiName, final AuthV4.AuthV4SignInListener listener) {
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "processGamerId()");
        AuthV4Network.INSTANCE.isGamerId$hive_service_release(provider, new Function4() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda76
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return AuthV4Impl.processGamerId$lambda$34(provider, fApiName, listener, (ResultAPI) obj, ((Boolean) obj2).booleanValue(), (String) obj3, (String) obj4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processGamerId$lambda$34(final AuthV4ProviderAdapter authV4ProviderAdapter, final String str, final AuthV4.AuthV4SignInListener authV4SignInListener, ResultAPI resultApi, boolean z, final String signature, final String url) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(url, "url");
        if (!resultApi.isSuccess()) {
            INSTANCE.onSignInFinish(resultApi, null, str, authV4SignInListener);
        } else if (z) {
            Intent intent = new Intent();
            intent.putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, true);
            HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), intent, new OnActivityLifecycle() { // from class: com.hive.authv4.AuthV4Impl$processGamerId$1$1
                public AuthV4GamerIdView authV4GamerIdView;

                public final AuthV4GamerIdView getAuthV4GamerIdView() {
                    AuthV4GamerIdView authV4GamerIdView = this.authV4GamerIdView;
                    if (authV4GamerIdView != null) {
                        return authV4GamerIdView;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("authV4GamerIdView");
                    return null;
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public boolean onBackPressed() {
                    return getAuthV4GamerIdView().onBackPressed();
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onCreate(final Activity activity, Bundle savedInstanceState) throws JSONException {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    super.onCreate(activity, savedInstanceState);
                    JSONObject gamerIdWebViewPostData$hive_service_release = AuthV4Network.INSTANCE.getGamerIdWebViewPostData$hive_service_release(authV4ProviderAdapter.getUserId(), signature);
                    String str2 = url;
                    final AuthV4ProviderAdapter authV4ProviderAdapter2 = authV4ProviderAdapter;
                    final String str3 = str;
                    final AuthV4.AuthV4SignInListener authV4SignInListener2 = authV4SignInListener;
                    setAuthV4GamerIdView(new AuthV4GamerIdView(activity, str2, gamerIdWebViewPostData$hive_service_release, new AuthV4GamerIdView.DismissListener() { // from class: com.hive.authv4.AuthV4Impl$processGamerId$1$1$onCreate$1
                        @Override // com.hive.authv4.webviewflow.AuthV4GamerIdView.DismissListener
                        public void onDismiss(ResultAPI resultAPI, String player) {
                            Intrinsics.checkNotNullParameter(resultAPI, "resultAPI");
                            Intrinsics.checkNotNullParameter(player, "player");
                            ResultAPI resultAPI2 = new ResultAPI(resultAPI.getErrorCode(), resultAPI.getCode(), resultAPI.getMessage());
                            if (resultAPI.isSuccess()) {
                                AuthV4Impl.INSTANCE.internalSignInProvider(authV4ProviderAdapter2, player, str3, authV4SignInListener2);
                            } else {
                                AuthV4Impl.INSTANCE.onSignInFinish(resultAPI2, null, str3, authV4SignInListener2);
                            }
                            activity.finish();
                        }
                    }));
                    getAuthV4GamerIdView().show();
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onDestroy(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    if (!getIsCalledFinish()) {
                        getAuthV4GamerIdView().dismiss();
                    }
                    super.onDestroy(activity);
                }

                public final void setAuthV4GamerIdView(AuthV4GamerIdView authV4GamerIdView) {
                    Intrinsics.checkNotNullParameter(authV4GamerIdView, "<set-?>");
                    this.authV4GamerIdView = authV4GamerIdView;
                }
            });
        } else {
            INSTANCE.internalSignInProvider(authV4ProviderAdapter, "", str, authV4SignInListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processGamerId$lambda$39(final String str, final String str2, final AuthV4.AuthV4SignInListener authV4SignInListener, ResultAPI resultApi, boolean z, final String signature, final String url) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(url, "url");
        if (!resultApi.isSuccess()) {
            INSTANCE.onSignInFinish(resultApi, null, str2, authV4SignInListener);
        } else if (z) {
            Intent intent = new Intent();
            intent.putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, true);
            HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), intent, new OnActivityLifecycle() { // from class: com.hive.authv4.AuthV4Impl$processGamerId$2$1
                public AuthV4GamerIdView authV4GamerIdView;

                public final AuthV4GamerIdView getAuthV4GamerIdView() {
                    AuthV4GamerIdView authV4GamerIdView = this.authV4GamerIdView;
                    if (authV4GamerIdView != null) {
                        return authV4GamerIdView;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("authV4GamerIdView");
                    return null;
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public boolean onBackPressed() {
                    return getAuthV4GamerIdView().onBackPressed();
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onCreate(final Activity activity, Bundle savedInstanceState) throws JSONException {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    super.onCreate(activity, savedInstanceState);
                    JSONObject gamerIdWebViewPostData$hive_service_release = AuthV4Network.INSTANCE.getGamerIdWebViewPostData$hive_service_release("", signature);
                    String str3 = url;
                    final String str4 = str;
                    final String str5 = str2;
                    final AuthV4.AuthV4SignInListener authV4SignInListener2 = authV4SignInListener;
                    setAuthV4GamerIdView(new AuthV4GamerIdView(activity, str3, gamerIdWebViewPostData$hive_service_release, new AuthV4GamerIdView.DismissListener() { // from class: com.hive.authv4.AuthV4Impl$processGamerId$2$1$onCreate$1
                        @Override // com.hive.authv4.webviewflow.AuthV4GamerIdView.DismissListener
                        public void onDismiss(ResultAPI resultAPI, String player) {
                            Intrinsics.checkNotNullParameter(resultAPI, "resultAPI");
                            Intrinsics.checkNotNullParameter(player, "player");
                            ResultAPI resultAPI2 = new ResultAPI(resultAPI.getErrorCode(), resultAPI.getCode(), resultAPI.getMessage());
                            if (resultAPI.isSuccess()) {
                                AuthV4Impl.INSTANCE.internalCustomSignInProvider(str4, player, str5, authV4SignInListener2);
                            } else {
                                AuthV4Impl.INSTANCE.onSignInFinish(resultAPI2, null, str5, authV4SignInListener2);
                            }
                            activity.finish();
                        }
                    }));
                    getAuthV4GamerIdView().show();
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onDestroy(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    if (!getIsCalledFinish()) {
                        getAuthV4GamerIdView().dismiss();
                    }
                    super.onDestroy(activity);
                }

                public final void setAuthV4GamerIdView(AuthV4GamerIdView authV4GamerIdView) {
                    Intrinsics.checkNotNullParameter(authV4GamerIdView, "<set-?>");
                    this.authV4GamerIdView = authV4GamerIdView;
                }
            });
        } else {
            INSTANCE.internalCustomSignInProvider(str, "", str2, authV4SignInListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean processGetIDPList(Triple<ResultAPI, Idp, ? extends ArrayList<AuthV4.ProviderType>> triple) {
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[Setup. request Get IDP List]");
        ResultAPI first = triple.getFirst();
        triple.getSecond();
        ArrayList<AuthV4.ProviderType> third = triple.getThird();
        if (first.isSuccess()) {
            idpList = third;
            return true;
        }
        if (first.getCode() != ResultAPI.Code.AuthV4ServiceShutdown) {
            return true;
        }
        onSetupFail(first);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processProvisionBlockedCountry(Triple<ResultAPI, MetadataInitInteraction, ? extends ArrayList<AuthV4.AuthV4MaintenanceInfo>> triple, Continuation<? super Boolean> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        ResultAPI first = triple.getFirst();
        MetadataInitInteraction second = triple.getSecond();
        ArrayList<AuthV4.AuthV4MaintenanceInfo> third = triple.getThird();
        if (first.isSuccess()) {
            LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[Setup. ProvisionBlockedCountry] success");
            if (!third.isEmpty()) {
                Boxing.boxBoolean(mainLooperHandler.post(INSTANCE.createMaintenanceRunnable(0, third, new MaintenanceDialog.OnDismissListener() { // from class: com.hive.authv4.AuthV4Impl$processProvisionBlockedCountry$2$1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialog) {
                        Intrinsics.checkNotNullParameter(dialog, "dialog");
                        if (cancellableContinuationImpl.isActive()) {
                            CancellableContinuation<Boolean> cancellableContinuation = cancellableContinuationImpl;
                            Result.Companion companion = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m7415constructorimpl(Boolean.TRUE));
                        }
                    }

                    @Override // com.hive.auth.MaintenanceDialog.OnDismissListener
                    public void onDismissWithButtonAction(DialogInterface dialog, MaintenanceDialog.MaintenanceActionType buttonAction) {
                        Intrinsics.checkNotNullParameter(dialog, "dialog");
                        Intrinsics.checkNotNullParameter(buttonAction, "buttonAction");
                        AuthV4Impl.INSTANCE.onMaintenanceFail(buttonAction);
                        if (cancellableContinuationImpl.isActive()) {
                            CancellableContinuation<Boolean> cancellableContinuation = cancellableContinuationImpl;
                            Result.Companion companion = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m7415constructorimpl(Boolean.FALSE));
                        }
                    }
                })));
            } else if (cancellableContinuationImpl.isActive()) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m7415constructorimpl(Boxing.boxBoolean(true)));
            }
        } else {
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.wL(AuthV4.getTAG(), "[Setup. ProvisionBlockedCountry] request failed : " + second.getResponse());
            loggerImpl.wR(AuthV4.getTAG(), "[Setup. ProvisionBlockedCountry] request failed");
            INSTANCE.onSetupFail(first);
            if (cancellableContinuationImpl.isActive()) {
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m7415constructorimpl(Boxing.boxBoolean(false)));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processProvisionIntegration(Triple<ResultAPI, Integration, ? extends ArrayList<AuthV4.AuthV4MaintenanceInfo>> triple) {
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[Setup. request Provision Integration]");
        ResultAPI first = triple.getFirst();
        Integration second = triple.getSecond();
        if (first.isSuccess()) {
            if (!StringsKt.isBlank(second.getResponse().getDid()) && second.getResponse().isSuccess()) {
                HiveLifecycle.INSTANCE.setDid(second.getResponse().getDid());
            }
            JSONObject mirrorDomainJSONObject = second.getResponse().getMirrorDomainJSONObject();
            if (mirrorDomainJSONObject != null) {
                UrlManager.INSTANCE.setMirrorUrl(mirrorDomainJSONObject);
            }
            AuthV4Verifier.INSTANCE.saveCheckDownloadResult(false);
            Property.Companion companion = Property.INSTANCE;
            Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.AGREEMENT_IS_SENT_BEFORE_LOGIN, "true", null, 4, null);
            companion.getINSTANCE().writeProperties();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processProvisionIntegrationMaintenance(Triple<ResultAPI, Integration, ? extends ArrayList<AuthV4.AuthV4MaintenanceInfo>> triple, Continuation<? super Boolean> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[Setup. Provision Integration Maintenance]");
        ResultAPI first = triple.getFirst();
        ArrayList<AuthV4.AuthV4MaintenanceInfo> third = triple.getThird();
        if (first.isFailure()) {
            INSTANCE.onSetupFail(first);
            if (cancellableContinuationImpl.isActive()) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m7415constructorimpl(Boxing.boxBoolean(false)));
            }
        } else if (!third.isEmpty()) {
            Boxing.boxBoolean(mainLooperHandler.post(INSTANCE.createMaintenanceRunnable(0, third, new MaintenanceDialog.OnDismissListener() { // from class: com.hive.authv4.AuthV4Impl$processProvisionIntegrationMaintenance$2$1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialog) {
                    Intrinsics.checkNotNullParameter(dialog, "dialog");
                    if (cancellableContinuationImpl.isActive()) {
                        CancellableContinuation<Boolean> cancellableContinuation = cancellableContinuationImpl;
                        Result.Companion companion2 = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m7415constructorimpl(Boolean.TRUE));
                    }
                }

                @Override // com.hive.auth.MaintenanceDialog.OnDismissListener
                public void onDismissWithButtonAction(DialogInterface dialog, MaintenanceDialog.MaintenanceActionType buttonAction) {
                    Intrinsics.checkNotNullParameter(dialog, "dialog");
                    Intrinsics.checkNotNullParameter(buttonAction, "buttonAction");
                    AuthV4Impl.INSTANCE.onMaintenanceFail(buttonAction);
                    if (cancellableContinuationImpl.isActive()) {
                        CancellableContinuation<Boolean> cancellableContinuation = cancellableContinuationImpl;
                        Result.Companion companion2 = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m7415constructorimpl(Boolean.FALSE));
                    }
                }
            })));
        } else if (cancellableContinuationImpl.isActive()) {
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m7415constructorimpl(Boxing.boxBoolean(true)));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processSignInType() {
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[Setup. processSignInType]");
        ResultAPI resultAPI = new ResultAPI();
        String did = HiveLifecycle.INSTANCE.getDid();
        if (did == null || StringsKt.isBlank(did)) {
            resultAPI = new ResultAPI(-5, ResultAPI.Code.AuthV4InvalidParamDid, "did is null");
        }
        boolean z = AuthV4Account.INSTANCE.readPlayerInfo() != null;
        if (!z && idpList.isEmpty()) {
            resultAPI = new ResultAPI(-8, ResultAPI.Code.AuthV4InvalidResponseData);
        }
        onSetupFinish(resultAPI, z, did, idpList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestNoticePopupSettleBill(final int noticeType) {
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[Setup. requestNoticePopupSettleBill]");
        new Thread(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda55
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4Impl.requestNoticePopupSettleBill$lambda$3(noticeType);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestNoticePopupSettleBill$lambda$3(int i) {
        ResultAPI resultAPINoticePopupSettleBill$hive_service_release = AuthV4Network.Provision.INSTANCE.noticePopupSettleBill$hive_service_release(i);
        if (resultAPINoticePopupSettleBill$hive_service_release.isSuccess()) {
            LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[Setup. requestNoticePopupSettleBill] success");
            return;
        }
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[Setup. requestNoticePopupSettleBill] failed, " + resultAPINoticePopupSettleBill$hive_service_release);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestPromotionDownloadInfo(boolean isAgreementDetermineBaseAccount) {
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[Setup. request promotion download info, for CPI");
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = HivePromotion.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof HivePromotion)) {
            hiveModule = null;
        }
        HivePromotion hivePromotion = (HivePromotion) (hiveModule instanceof HivePromotion ? hiveModule : null);
        if (hivePromotion != null) {
            hivePromotion.requestDownloadInfo("v4", isAgreementDetermineBaseAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestProvisionDownload(Continuation<? super Unit> continuation) {
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[Setup. requestProvisionDownload]");
        AuthV4Verifier authV4Verifier = AuthV4Verifier.INSTANCE;
        if (authV4Verifier.checkDownload(true) && ((AddDownload) AuthV4Network.Provision.INSTANCE.addDownload$hive_service_release().request()).getResponse().isSuccess()) {
            authV4Verifier.saveCheckDownloadResult(true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resolveConflict$lambda$55(String str, ResultAPI resultAPI, AuthV4.AuthV4ResolveConflictListener authV4ResolveConflictListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ResolveConflictListener.onAuthV4ResolveConflict(resultAPI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resolveConflict$lambda$56(String str, ResultAPI resultAPI, AuthV4.AuthV4ResolveConflictListener authV4ResolveConflictListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ResolveConflictListener.onAuthV4ResolveConflict(resultAPI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resolveConflict$lambda$57(String str, ResultAPI resultAPI, AuthV4.AuthV4ResolveConflictListener authV4ResolveConflictListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ResolveConflictListener.onAuthV4ResolveConflict(resultAPI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resolveConflict$lambda$58(String str, ResultAPI resultAPI, AuthV4.AuthV4ResolveConflictListener authV4ResolveConflictListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ResolveConflictListener.onAuthV4ResolveConflict(resultAPI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resolveConflict$lambda$59(String str, ResultAPI resultAPI, AuthV4.AuthV4ResolveConflictListener authV4ResolveConflictListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ResolveConflictListener.onAuthV4ResolveConflict(resultAPI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resolveConflict$lambda$61$lambda$60(String str, ResultAPI resultAPI, AuthV4.AuthV4ResolveConflictListener authV4ResolveConflictListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ResolveConflictListener.onAuthV4ResolveConflict(resultAPI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean setMetadataToConfiguration(Triple<ResultAPI, MetadataInitInteraction, ? extends ArrayList<AuthV4.AuthV4MaintenanceInfo>> triple) {
        ResultAPI first = triple.getFirst();
        MetadataInitInteraction.MetadataInitInteractionResponse response = triple.getSecond().getResponse();
        if (first.isSuccess()) {
            com.hive.core.Configuration configuration = com.hive.core.Configuration.INSTANCE;
            configuration.setHiveCountry(response.getHiveCountry());
            JSONObject timezone = response.getTimezone();
            if (timezone == null) {
                timezone = new JSONObject();
            }
            configuration.setTimezone(timezone);
            JSONArray whiteListDomains = response.getWhiteListDomains();
            configuration.setWhiteListDomains(whiteListDomains != null ? whiteListDomains.toString() : null);
            configuration.setMinGooglePlayServices(response.getMinGooglePlayServices());
            configuration.setGoogleLegacySupport(response.getGoogleLegacySupport());
            configuration.setCompany(response.getCompany());
            configuration.setCompanyName(response.getCompanyName());
            configuration.setCompanyIndex(response.getCompanyIndex());
            configuration.setAppindex(response.getAppindex());
            configuration.setGameId(response.getGameId());
            configuration.setGameIndex(response.getGameIndex());
            configuration.setOfflineMode(response.getIsOfflineMode());
            configuration.setCcuDeactivate(response.getIsCcuDeactivate());
            configuration.setEEACountry(response.getIsEEACountry());
            configuration.setPrimaryClientId(response.getPrimaryClientId());
            configuration.setVerificationMode(response.getVerificationMode());
            configuration.setUsedAgeRange(response.getIsUsedAppStoreAccountability());
            configuration.setEffectiveStatusAgeRange(response.getEffectiveStatusAppStoreAccountability());
            configuration.setFunTapUnderGovernmentReview(response.getIsFunTapUnderGovernmentReview());
        }
        boolean zIsBlank = StringsKt.isBlank(response.getPrimaryClientId());
        boolean z = !zIsBlank;
        if (zIsBlank) {
            INSTANCE.onSetupFail(new ResultAPI(-13, ResultAPI.Code.AuthV4InvalidParam, "Client authentication failed: unknown client."));
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAdultConfirm$lambda$90(String str, ResultAPI resultAPI, AuthV4.AuthV4AdultConfirmListener authV4AdultConfirmListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4AdultConfirmListener.onAuthV4AdultConfirm(resultAPI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAdultConfirm$lambda$91(String str, ResultAPI resultAPI, AuthV4.AuthV4AdultConfirmListener authV4AdultConfirmListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4AdultConfirmListener.onAuthV4AdultConfirm(resultAPI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAdultConfirm$lambda$92(String str, ResultAPI resultAPI, AuthV4.AuthV4AdultConfirmListener authV4AdultConfirmListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4AdultConfirmListener.onAuthV4AdultConfirm(resultAPI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showChatbotInquiry$lambda$83(String str, ResultAPI resultAPI, AuthV4.AuthV4ShowChatbotInquiryListener authV4ShowChatbotInquiryListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ShowChatbotInquiryListener.onAuthV4ShowChatbotInquiry(resultAPI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showChatbotInquiry$lambda$85(final String str, String str2, final AuthV4.AuthV4ShowChatbotInquiryListener authV4ShowChatbotInquiryListener, final ResultAPI resultApi) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        if (resultApi.isFailure()) {
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda74
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.showChatbotInquiry$lambda$85$lambda$84(str, resultApi, authV4ShowChatbotInquiryListener);
                }
            });
        } else {
            INSTANCE.internalShowChatbotInquiry(str, str2, authV4ShowChatbotInquiryListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showChatbotInquiry$lambda$85$lambda$84(String str, ResultAPI resultAPI, AuthV4.AuthV4ShowChatbotInquiryListener authV4ShowChatbotInquiryListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ShowChatbotInquiryListener.onAuthV4ShowChatbotInquiry(resultAPI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showDeviceManagement$lambda$115(AuthV4.AuthV4ShowDeviceManagementListener authV4ShowDeviceManagementListener, ResultAPI it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LoggerImpl.INSTANCE.i("[showDeviceManagement] show: " + it);
        authV4ShowDeviceManagementListener.onAuthV4ShowDeviceManagement(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showIdentityVerification$lambda$93(String str, ResultAPI resultAPI, AuthV4.AuthV4ShowIdentityVerificationListener authV4ShowIdentityVerificationListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ShowIdentityVerificationListener.onAuthV4ShowIdentityVerification(resultAPI, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showIdentityVerification$lambda$96(String str, AuthV4.AuthV4ShowIdentityVerificationListener authV4ShowIdentityVerificationListener, ResultAPI resultApi, IdentityVerification.Identity identity) {
        AuthV4.Identity identity2;
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultApi.toString());
        if (identity != null) {
            if (!HiveLifecycle.INSTANCE.isSignIn()) {
                recentIdentity = identity;
            }
            identity2 = new AuthV4.Identity();
            String phoneCode = identity.getPhoneCode();
            if (phoneCode == null) {
                phoneCode = "";
            }
            identity2.setPhoneCode(phoneCode);
            String phoneNumber = identity.getPhoneNumber();
            if (phoneNumber == null) {
                phoneNumber = "";
            }
            identity2.setPhoneNumber(phoneNumber);
            String dateOfBirth = identity.getDateOfBirth();
            if (dateOfBirth == null) {
                dateOfBirth = "";
            }
            identity2.setDateOfBirth(dateOfBirth);
            String hashedDi = identity.getHashedDi();
            identity2.setHashedDi(hashedDi != null ? hashedDi : "");
        } else {
            identity2 = null;
        }
        authV4ShowIdentityVerificationListener.onAuthV4ShowIdentityVerification(resultApi, identity2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showInquiry$lambda$73(String str, ResultAPI resultAPI, AuthV4.AuthV4ShowInquiryListener authV4ShowInquiryListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ShowInquiryListener.onAuthV4ShowInquiry(resultAPI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showInquiry$lambda$75(final String str, final AuthV4.AuthV4ShowInquiryListener authV4ShowInquiryListener, final ResultAPI resultApi) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        if (resultApi.isFailure()) {
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda27
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.showInquiry$lambda$75$lambda$74(str, resultApi, authV4ShowInquiryListener);
                }
            });
        } else {
            INSTANCE.internalShowInquiry(str, authV4ShowInquiryListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showInquiry$lambda$75$lambda$74(String str, ResultAPI resultAPI, AuthV4.AuthV4ShowInquiryListener authV4ShowInquiryListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ShowInquiryListener.onAuthV4ShowInquiry(resultAPI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMyInquiry$lambda$78(String str, ResultAPI resultAPI, AuthV4.AuthV4ShowMyInquiryListener authV4ShowMyInquiryListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ShowMyInquiryListener.onAuthV4ShowMyInquiry(resultAPI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showMyInquiry$lambda$80(final String str, final AuthV4.AuthV4ShowMyInquiryListener authV4ShowMyInquiryListener, final ResultAPI resultApi) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        if (resultApi.isFailure()) {
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda73
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.showMyInquiry$lambda$80$lambda$79(str, resultApi, authV4ShowMyInquiryListener);
                }
            });
        } else {
            INSTANCE.internalShowMyInquiry(str, authV4ShowMyInquiryListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMyInquiry$lambda$80$lambda$79(String str, ResultAPI resultAPI, AuthV4.AuthV4ShowMyInquiryListener authV4ShowMyInquiryListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ShowMyInquiryListener.onAuthV4ShowMyInquiry(resultAPI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showProfile$lambda$67(String str, ResultAPI resultAPI, AuthV4.AuthV4ShowProfileListener authV4ShowProfileListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ShowProfileListener.onAuthV4ShowProfile(resultAPI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showProfile$lambda$68(String str, ResultAPI resultAPI, AuthV4.AuthV4ShowProfileListener authV4ShowProfileListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ShowProfileListener.onAuthV4ShowProfile(resultAPI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showProfile$lambda$69(String str, ResultAPI resultAPI, AuthV4.AuthV4ShowProfileListener authV4ShowProfileListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ShowProfileListener.onAuthV4ShowProfile(resultAPI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showProfile$lambda$71(final String str, AuthV4.PlayerInfo playerInfo, long j, final AuthV4.AuthV4ShowProfileListener authV4ShowProfileListener, final ResultAPI resultApi) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        if (resultApi.isFailure()) {
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda60
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.showProfile$lambda$71$lambda$70(str, resultApi, authV4ShowProfileListener);
                }
            });
        } else {
            INSTANCE.internalShowProfile(str, HiveActivity.INSTANCE.getRecentActivity(), playerInfo, j, authV4ShowProfileListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showProfile$lambda$71$lambda$70(String str, ResultAPI resultAPI, AuthV4.AuthV4ShowProfileListener authV4ShowProfileListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ShowProfileListener.onAuthV4ShowProfile(resultAPI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTerms$lambda$88(String str, ResultAPI resultAPI, AuthV4.AuthV4ShowTermsListener authV4ShowTermsListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ShowTermsListener.onAuthV4ShowTerms(resultAPI);
    }

    public static /* synthetic */ void signIn$default(AuthV4Impl authV4Impl, AuthV4.ProviderType providerType, String str, AuthV4.AuthV4SignInListener authV4SignInListener, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        authV4Impl.signIn(providerType, str, authV4SignInListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void signInProvider(final String fApiName, final AuthV4.ProviderType providerType, final AuthV4.AuthV4SignInListener listener) {
        final AuthV4ProviderAdapter companion = AuthV4ProviderAdapter.INSTANCE.getInstance(providerType);
        if (companion != null) {
            companion.login(new AuthV4ProviderAdapter.ProviderLoginListener() { // from class: com.hive.authv4.AuthV4Impl.signInProvider.1
                @Override // com.hive.authv4.provider.AuthV4ProviderAdapter.ProviderLoginListener
                public void onProviderLoginListener(ResultAPI resultAPI) {
                    Intrinsics.checkNotNullParameter(resultAPI, "resultAPI");
                    if (!resultAPI.isSuccess()) {
                        AuthV4Impl.INSTANCE.onSignInFinish(resultAPI, null, fApiName, listener);
                        return;
                    }
                    if (StringsKt.isBlank(companion.getUserId())) {
                        AuthV4Impl.INSTANCE.onSignInFinish(new ResultAPI(-8, ResultAPI.Code.AuthV4ResponseFailProviderUserID, "idp user id is empty."), null, fApiName, listener);
                        return;
                    }
                    if (!com.hive.core.Configuration.INSTANCE.getGoogleLegacySupport() || providerType != AuthV4.ProviderType.GOOGLE) {
                        AuthV4Impl.INSTANCE.processGamerId(companion, fApiName, listener);
                        return;
                    }
                    AuthV4ProviderAdapter companion2 = AuthV4ProviderAdapter.INSTANCE.getInstance(AuthV4.ProviderType.GOOGLE_PLAY_GAMES);
                    if (companion2 == null) {
                        AuthV4Impl.INSTANCE.processGamerId(companion, fApiName, listener);
                        return;
                    }
                    final AuthV4ProviderAdapter authV4ProviderAdapter = companion;
                    final String str = fApiName;
                    final AuthV4.AuthV4SignInListener authV4SignInListener = listener;
                    companion2.login(new AuthV4ProviderAdapter.ProviderLoginListener() { // from class: com.hive.authv4.AuthV4Impl$signInProvider$1$onProviderLoginListener$1
                        @Override // com.hive.authv4.provider.AuthV4ProviderAdapter.ProviderLoginListener
                        public void onProviderLoginListener(ResultAPI result) {
                            Intrinsics.checkNotNullParameter(result, "result");
                            LoggerImpl.INSTANCE.d("[AuthV4] connect - Google Legacy Support : " + result);
                            AuthV4Impl.INSTANCE.processGamerId(authV4ProviderAdapter, str, authV4SignInListener);
                        }
                    });
                }
            });
            return;
        }
        String str = "[SignInProvider] this provider type is invalid. : " + providerType;
        LoggerImpl.INSTANCE.w(AuthV4.getTAG(), str);
        onSignInFinish(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, str), null, fApiName, listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit signOut$lambda$44(String str, AuthV4.AuthV4SignOutListener authV4SignOutListener, ResultAPI resultApi, SignOut signOut) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        if (resultApi.getCode() == ResultAPI.Code.Success || resultApi.getCode() == ResultAPI.Code.AuthV4InvalidSession) {
            LoggerImpl.INSTANCE.d("[signOut] resultApi : " + resultApi + ", remove session data");
            INSTANCE.internalSignOut(str, authV4SignOutListener);
        } else {
            isInProgressSign = false;
            INSTANCE.onSignOutFinish(resultApi, str, authV4SignOutListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object startFuntapInspection(final String str, Continuation<? super ResultAPI> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = ProviderFuntap.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof ProviderFuntap)) {
            hiveModule = null;
        }
        final ProviderFuntap providerFuntap = (ProviderFuntap) (hiveModule instanceof ProviderFuntap ? hiveModule : null);
        if (providerFuntap == null) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "startFuntapInspection() library missing");
            ExtentionsKt.resumeIfActive(cancellableContinuationImpl, new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "Funtap library missing."));
        } else {
            providerFuntap.checkUserInfoComplete(str, new Function2<Boolean, Boolean, Unit>() { // from class: com.hive.authv4.AuthV4Impl$startFuntapInspection$2$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
                    invoke(bool.booleanValue(), bool2.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z, boolean z2) {
                    if (!z) {
                        LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "startFuntapInspection() Funtap server error");
                        ExtentionsKt.resumeIfActive(cancellableContinuationImpl, new ResultAPI(-99, ResultAPI.Code.CommonUnknown, "Funtap server error"));
                    } else {
                        if (z2) {
                            LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "startFuntapInspection() Success. User is completed");
                            ExtentionsKt.resumeIfActive(cancellableContinuationImpl, new ResultAPI());
                            return;
                        }
                        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "startFuntapInspection() Success. User is not completed");
                        ProviderFuntap providerFuntap2 = providerFuntap;
                        Activity recentActivity = HiveActivity.INSTANCE.getRecentActivity();
                        String str2 = str;
                        final CancellableContinuation<ResultAPI> cancellableContinuation = cancellableContinuationImpl;
                        providerFuntap2.showUpdateUserInfo(recentActivity, str2, new Function1<Boolean, Unit>() { // from class: com.hive.authv4.AuthV4Impl$startFuntapInspection$2$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z3) {
                                LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "startFuntapInspection() showUpdateUserInfo is completed(" + z3 + ')');
                                if (z3) {
                                    ExtentionsKt.resumeIfActive(cancellableContinuation, new ResultAPI());
                                } else {
                                    ExtentionsKt.resumeIfActive(cancellableContinuation, new ResultAPI(-99, ResultAPI.Code.CommonUnknown, "Identity info not completed"));
                                }
                            }
                        });
                    }
                }
            });
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final void uploadProfile(AuthV4.PlayerInfo playerInfo, AuthV4ProviderAdapter provider, Function1<? super ResultAPI, Unit> callback) {
        provider.getProfile(new C28471(provider, playerInfo, callback));
    }

    public final void checkAgeGate(boolean useCloseButton, AuthV4.AuthV4AgeGateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("[AuthV4] checkAgeGate");
        if (isSetup) {
            AgeGateCheck.INSTANCE.show(HiveActivity.INSTANCE.getRecentActivity(), useCloseButton, listener);
        } else {
            loggerImpl.w(AuthV4.getTAG(), "[checkAgeGate] Need AuthV4 setup first");
            listener.onAuthV4AgeGate(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[checkAgeGate] Need AuthV4 setup first"), null);
        }
    }

    public final void checkBlacklist(final boolean isShow, final AuthV4.AuthV4MaintenanceListener listener) {
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        AuthV4Account authV4Account = AuthV4Account.INSTANCE;
        AuthV4.PlayerInfo playerInfo = authV4Account.getPlayerInfo();
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthV4.getTAG(), "[checkBlacklist] AuthV4SignInListener is null");
            return;
        }
        if (!isSetup) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[checkBlacklist] Need AuthV4 setup first");
            final ResultAPI resultAPI = new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[checkBlacklist] Need AuthV4 setup first");
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda30
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.checkBlacklist$lambda$102(callMethodName, resultAPI, listener);
                }
            });
        } else {
            if (playerInfo != null) {
                AuthV4Network.INSTANCE.blacklist$hive_service_release(authV4Account.getPlayerInfo(), new Function3() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda32
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return AuthV4Impl.checkBlacklist$lambda$108(isShow, listener, callMethodName, (ResultAPI) obj, (Blacklist) obj2, (AuthV4.AuthV4MaintenanceInfo) obj3);
                    }
                });
                return;
            }
            final String str = "[checkBlacklist] Need AuthV4 signIn first";
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[checkBlacklist] Need AuthV4 signIn first");
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda31
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.checkBlacklist$lambda$103(str, callMethodName, listener);
                }
            });
        }
    }

    public final void checkMaintenance(final boolean isShow, final AuthV4.AuthV4MaintenanceListener listener) {
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthV4.getTAG(), "[checkMaintenance] AuthV4MaintenanceListener is null.");
        } else {
            if (isSetup) {
                AuthV4Network.Provision.INSTANCE.getMaintenance$hive_service_release(new Function3() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda52
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return AuthV4Impl.checkMaintenance$lambda$101(isShow, callMethodName, listener, (ResultAPI) obj, (GetMaintenance) obj2, (ArrayList) obj3);
                    }
                });
                return;
            }
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[checkMaintenance] Need AuthV4 setup first.");
            final ResultAPI resultAPI = new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[checkMaintenance] Need AuthV4 setup first.");
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda51
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.checkMaintenance$lambda$98(callMethodName, resultAPI, listener);
                }
            });
        }
    }

    public final void checkProvider(AuthV4.ProviderType providerType, final AuthV4.AuthV4CheckProviderListener listener) {
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthV4.getTAG(), "[checkProvider] AuthV4CheckProviderListener is null.");
            return;
        }
        if (!isSetup) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[checkProvider] Need AuthV4 setup first.");
            onCheckProviderFinish(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[checkProvider] Need AuthV4 setup first."), null, callMethodName, listener);
            return;
        }
        if (providerType == null) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[checkProvider] ProviderType is null.");
            onCheckProviderFinish(new ResultAPI(-1, ResultAPI.Code.AuthV4InvalidProviderType, "[checkProvider] ProviderType is null."), null, callMethodName, listener);
            return;
        }
        final AuthV4ProviderAdapter companion = AuthV4ProviderAdapter.INSTANCE.getInstance(providerType);
        if (companion != null) {
            companion.login(new AuthV4ProviderAdapter.ProviderLoginListener() { // from class: com.hive.authv4.AuthV4Impl.checkProvider.1
                @Override // com.hive.authv4.provider.AuthV4ProviderAdapter.ProviderLoginListener
                public void onProviderLoginListener(ResultAPI result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (result.isFailure()) {
                        AuthV4Impl.INSTANCE.onCheckProviderFinish(new ResultAPI(ResultAPI.Code.AuthV4ResponseFailCheckProvider, result.getMessage()), companion.getMyProviderInfo(), callMethodName, listener);
                    } else {
                        AuthV4Impl.INSTANCE.onCheckProviderFinish(result, companion.getMyProviderInfo(), callMethodName, listener);
                    }
                }
            });
            return;
        }
        String str = "[checkProvider] this provider type is invalid. : " + providerType;
        LoggerImpl.INSTANCE.w(AuthV4.getTAG(), str);
        onCheckProviderFinish(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, str), null, callMethodName, listener);
    }

    public final synchronized void connect(final AuthV4.ProviderType providerType, final AuthV4.AuthV4ConnectListener listener) {
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        final AuthV4.PlayerInfo playerInfo = AuthV4Account.INSTANCE.getPlayerInfo();
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthV4.getTAG(), "[connect] AuthV4ConnectListener is null.");
            return;
        }
        if (!isSetup) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[connect] Need AuthV4 setup first.");
            onConnectFinish(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[connect] Need AuthV4 setup first."), null, callMethodName, listener);
            return;
        }
        if (providerType == null) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[connect] ProviderType is null.");
            onConnectFinish(new ResultAPI(-1, ResultAPI.Code.AuthV4InvalidProviderType, "[connect] ProviderType is null."), null, callMethodName, listener);
            return;
        }
        if (isInProgressSign) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[connect] Sign is already in progress.");
            onConnectFinish(new ResultAPI(-3, ResultAPI.Code.AuthV4InProgress, "[connect] Sign is already in progress."), null, callMethodName, listener);
            return;
        }
        if (playerInfo == null) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[connect] Need sign in first.");
            onConnectFinish(new ResultAPI(-9, ResultAPI.Code.AuthV4NeedSignIn, "[connect] Need sign in first."), null, callMethodName, listener);
            return;
        }
        if (playerInfo.getProviderInfoData().get(providerType) != null) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[connect] this provider type is already connected, disconnect first.");
            onConnectFinish(new ResultAPI(-1, ResultAPI.Code.AuthV4ProviderAlreadyConnected, "[connect] this provider type is already connected, disconnect first."), null, callMethodName, listener);
            return;
        }
        final AuthV4ProviderAdapter companion = AuthV4ProviderAdapter.INSTANCE.getInstance(providerType);
        if (companion != null) {
            isInProgressSign = true;
            companion.login(new AuthV4ProviderAdapter.ProviderLoginListener() { // from class: com.hive.authv4.AuthV4Impl.connect.1
                @Override // com.hive.authv4.provider.AuthV4ProviderAdapter.ProviderLoginListener
                public void onProviderLoginListener(ResultAPI result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (!result.isSuccess()) {
                        AuthV4Impl.isInProgressSign = false;
                        AuthV4Impl.INSTANCE.onConnectFinish(new ResultAPI(result.getErrorCode(), result.getCode(), result.getMessage()), null, callMethodName, listener);
                    } else {
                        if (!com.hive.core.Configuration.INSTANCE.getGoogleLegacySupport() || providerType != AuthV4.ProviderType.GOOGLE) {
                            AuthV4Impl.INSTANCE.internalConnect(playerInfo, companion, callMethodName, listener);
                            return;
                        }
                        AuthV4ProviderAdapter companion2 = AuthV4ProviderAdapter.INSTANCE.getInstance(AuthV4.ProviderType.GOOGLE_PLAY_GAMES);
                        if (companion2 == null) {
                            AuthV4Impl.INSTANCE.internalConnect(playerInfo, companion, callMethodName, listener);
                            return;
                        }
                        final AuthV4.PlayerInfo playerInfo2 = playerInfo;
                        final AuthV4ProviderAdapter authV4ProviderAdapter = companion;
                        final String str = callMethodName;
                        final AuthV4.AuthV4ConnectListener authV4ConnectListener = listener;
                        companion2.login(new AuthV4ProviderAdapter.ProviderLoginListener() { // from class: com.hive.authv4.AuthV4Impl$connect$1$onProviderLoginListener$1
                            @Override // com.hive.authv4.provider.AuthV4ProviderAdapter.ProviderLoginListener
                            public void onProviderLoginListener(ResultAPI result2) {
                                Intrinsics.checkNotNullParameter(result2, "result");
                                LoggerImpl.INSTANCE.d("[AuthV4] connect - Google Legacy Support : " + result2);
                                AuthV4Impl.INSTANCE.internalConnect(playerInfo2, authV4ProviderAdapter, str, authV4ConnectListener);
                            }
                        });
                    }
                }
            });
            return;
        }
        String str = "[connect] this provider type is invalid. : " + providerType;
        LoggerImpl.INSTANCE.w(AuthV4.getTAG(), str);
        isInProgressSign = false;
        onConnectFinish(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, str), null, callMethodName, listener);
    }

    public final synchronized void connectWithAuthKey(String authKey, AuthV4.AuthV4ConnectListener listener) {
        String callMethodName = LoggerImpl.getCallMethodName(2);
        AuthV4.PlayerInfo playerInfo = AuthV4Account.INSTANCE.getPlayerInfo();
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthV4.getTAG(), "[connectWithAuthKey] AuthV4ConnectListener is null.");
            return;
        }
        if (!isSetup) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[connectWithAuthKey] Need AuthV4 setup first.");
            onConnectFinish(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[connectWithAuthKey] Need AuthV4 setup first."), null, callMethodName, listener);
            return;
        }
        if (authKey != null && !StringsKt.isBlank(authKey)) {
            if (isInProgressSign) {
                LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[connectWithAuthKey] Sign is already in progress.");
                onConnectFinish(new ResultAPI(-3, ResultAPI.Code.AuthV4InProgress, "[connectWithAuthKey] Sign is already in progress."), null, callMethodName, listener);
                return;
            } else if (playerInfo == null) {
                LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[connectWithAuthKey] Need sign in first.");
                onConnectFinish(new ResultAPI(-9, ResultAPI.Code.AuthV4NeedSignIn, "[connectWithAuthKey] Need sign in first."), null, callMethodName, listener);
                return;
            } else {
                isInProgressSign = true;
                internalCustomConnect(playerInfo, authKey, callMethodName, listener);
                return;
            }
        }
        String str = "[connectWithAuthKey] this AUTH KEY is invalid. : " + authKey;
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.wL(AuthV4.getTAG(), str);
        loggerImpl.wR(AuthV4.getTAG(), "[connectWithAuthKey] this AUTH KEY is invalid.");
        onConnectFinish(new ResultAPI(-1, ResultAPI.Code.AuthV4InvalidParam, str), null, callMethodName, listener);
    }

    public final synchronized void deleteStoredPlayerId(final long playerId, final AuthV4.AuthV4DeletePlayerIdListener listener) {
        if (!isSetup) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[deleteStoredPlayerId] Need AuthV4 setup first");
            ResultAPI resultAPI = new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[deleteStoredPlayerId] Need AuthV4 setup first");
            if (listener != null) {
                listener.onAuthV4DeletePlayerId(resultAPI);
            }
        } else if (isInProgressDeletePlayerId) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[deleteStoredPlayerId] Sign is already in progress");
            ResultAPI resultAPI2 = new ResultAPI(-3, ResultAPI.Code.AuthV4InProgress, "[deleteStoredPlayerId] Sign is already in progress");
            if (listener != null) {
                listener.onAuthV4DeletePlayerId(resultAPI2);
            }
        } else {
            AuthV4Account authV4Account = AuthV4Account.INSTANCE;
            AuthV4.PlayerInfo playerInfoList = authV4Account.readPlayerInfoList(playerId);
            if (playerInfoList == null) {
                LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[deleteStoredPlayerId] Invalid account session.");
                ResultAPI resultAPI3 = new ResultAPI(-9, ResultAPI.Code.AuthV4SessionProcessingFail, "[deleteStoredPlayerId] Invalid account session.");
                if (listener != null) {
                    listener.onAuthV4DeletePlayerId(resultAPI3);
                }
            } else {
                AuthV4.PlayerInfo playerInfo = authV4Account.readPlayerInfo();
                if (playerInfo == null || playerInfo.getPlayerId() != playerId) {
                    isInProgressDeletePlayerId = true;
                    AuthV4Network.INSTANCE.signOut$hive_service_release(playerInfoList, new Function2() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda79
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AuthV4Impl.deleteStoredPlayerId$lambda$118(playerId, listener, (ResultAPI) obj, (SignOut) obj2);
                        }
                    });
                } else {
                    LoggerImpl.INSTANCE.d("[deleteStoredPlayerId] isCurrentPlayer : true");
                    authV4Account.removePlayerInfoList(playerId);
                    if (listener != null) {
                        listener.onAuthV4DeletePlayerId(new ResultAPI());
                    }
                }
            }
        }
    }

    public final synchronized void disconnect(AuthV4.ProviderType providerType, AuthV4.AuthV4DisconnectListener listener) {
        String value;
        if (providerType != null) {
            try {
                value = providerType.getValue();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            value = null;
        }
        disconnect(value, listener);
    }

    public final void getAgeRange(AuthV4.AuthV4GetAgeRangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[AuthV4] getAgeRange");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C28241(listener, null), 3, null);
    }

    public final AuthV4.AuthV4CheckProviderListener getCheckProviderListener() {
        return checkProviderListener;
    }

    public final void getHashedDi(final AuthV4.AuthV4GetHashedDiListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("[AuthV4] getHashedDi");
        HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
        ResultAPI resultAPI = !hiveLifecycle.isSetup() ? new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "Need AuthV4 setup first.") : !hiveLifecycle.isSignIn() ? new ResultAPI(-9, ResultAPI.Code.AuthV4InvalidSession, "Need AuthV4 signIn first.") : null;
        if (resultAPI != null) {
            loggerImpl.w("[AuthV4] getHashedDi: " + resultAPI.getErrorMessage());
            listener.onAuthV4GetHashedDi(resultAPI, null);
            return;
        }
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = AdultConfirm.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof AdultConfirm)) {
            hiveModule = null;
        }
        if (!(hiveModule instanceof AdultConfirm)) {
            hiveModule = null;
        }
        AdultConfirm adultConfirm = (AdultConfirm) hiveModule;
        if (adultConfirm != null) {
            adultConfirm.getHashedDi(new Function2() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthV4Impl.getHashedDi$lambda$120(listener, (ResultAPI) obj, (String) obj2);
                }
            });
        } else {
            loggerImpl.w("[AuthV4] getHashedDi: HiveAdultConfirm library missing.");
            listener.onAuthV4GetHashedDi(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveAdultConfirm library missing."), null);
        }
    }

    @Override // com.hive.module.interfaces.HiveAuthV4, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return HiveAuthV4.DefaultImpls.getHiveModuleName(this);
    }

    public final ArrayList<AuthV4.ProviderType> getIdpList() {
        return idpList;
    }

    public final MaintenanceDialog.MaintenanceModel getMaintenanceModel(AuthV4.AuthV4MaintenanceInfo authV4MaintenanceInfo, String htmlMessage, MaintenanceDialog.MaintenanceDialogType maintenanceDialogType) {
        Intrinsics.checkNotNullParameter(authV4MaintenanceInfo, "authV4MaintenanceInfo");
        Intrinsics.checkNotNullParameter(htmlMessage, "htmlMessage");
        Intrinsics.checkNotNullParameter(maintenanceDialogType, "maintenanceDialogType");
        MaintenanceDialog.MaintenanceActionType maintenanceActionType = getMaintenanceActionType(authV4MaintenanceInfo.getAction());
        ArrayList arrayList = new ArrayList();
        List<AuthV4.AuthV4MaintenanceExtraButton> exButtons = authV4MaintenanceInfo.getExButtons();
        if (exButtons != null) {
            for (AuthV4.AuthV4MaintenanceExtraButton authV4MaintenanceExtraButton : exButtons) {
                arrayList.add(new MaintenanceDialog.MaintenanceExtraButton(INSTANCE.getMaintenanceActionType(authV4MaintenanceExtraButton.getAction()), authV4MaintenanceExtraButton.getUrl(), authV4MaintenanceExtraButton.getButton()));
            }
        }
        String title = authV4MaintenanceInfo.getTitle();
        String message = authV4MaintenanceInfo.getMessage();
        String button = authV4MaintenanceInfo.getButton();
        String url = authV4MaintenanceInfo.getUrl();
        int remainingTime = authV4MaintenanceInfo.getRemainingTime();
        String customerButton = authV4MaintenanceInfo.getCustomerButton();
        String customerLink = authV4MaintenanceInfo.getCustomerLink();
        String startDate = authV4MaintenanceInfo.getStartDate();
        String endDate = authV4MaintenanceInfo.getEndDate();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new MaintenanceDialog.MaintenanceModel(title, message, htmlMessage, button, maintenanceActionType, url, remainingTime, customerButton, customerLink, startDate, endDate, arrayList, maintenanceDialogType);
    }

    public final void getProfile(ArrayList<Long> playerIdList, final AuthV4.AuthV4GetProfileListener listener) {
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        final AuthV4.PlayerInfo playerInfo = AuthV4Account.INSTANCE.getPlayerInfo();
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthV4.getTAG(), "[getProfile] AuthV4GetProfileListener is null");
            return;
        }
        if (!isSetup) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[getProfile] Need AuthV4 setup first");
            final ResultAPI resultAPI = new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[getProfile] Need AuthV4 setup first");
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda80
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.getProfile$lambda$62(callMethodName, resultAPI, listener);
                }
            });
        } else if (playerInfo == null) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[connect] Need sign in first.");
            final ResultAPI resultAPI2 = new ResultAPI(-9, ResultAPI.Code.AuthV4NeedSignIn, "[connect] Need sign in first.");
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.getProfile$lambda$63(callMethodName, resultAPI2, listener);
                }
            });
        } else {
            if (playerIdList != null) {
                AuthV4Network.ProfileApi.INSTANCE.getPlayer$hive_service_release(playerIdList, new Function2() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AuthV4Impl.getProfile$lambda$66(playerInfo, callMethodName, listener, (ResultAPI) obj, (ArrayList) obj2);
                    }
                });
                return;
            }
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[getProfile] player id list is null.");
            final ResultAPI resultAPI3 = new ResultAPI(-1, ResultAPI.Code.AuthV4InvalidPlayeridList, "[getProfile] player id list is null.");
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.getProfile$lambda$64(callMethodName, resultAPI3, listener);
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.ArrayList] */
    public final void getProviderFriendsList(final AuthV4.ProviderType providerType, final AuthV4.AuthV4ProviderFriendsListener listener) {
        Intrinsics.checkNotNullParameter(providerType, "providerType");
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        final AuthV4.PlayerInfo playerInfo = AuthV4Account.INSTANCE.getPlayerInfo();
        AuthV4ProviderAdapter companion = AuthV4ProviderAdapter.INSTANCE.getInstance(providerType);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new ArrayList();
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthV4.getTAG(), "[getProviderFriendsList] AuthV4ProfileProviderFriendsListener is null.");
            return;
        }
        if (!isSetup) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[getProviderFriendsList] Need AuthV4 setup first.");
            final ResultAPI resultAPI = new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[getProviderFriendsList] Need AuthV4 setup first.");
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.getProviderFriendsList$lambda$110(callMethodName, resultAPI, listener, providerType);
                }
            });
            return;
        }
        if (companion == null) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[getProviderFriendsList] invalid ProviderType.");
            final ResultAPI resultAPI2 = new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "[getProviderFriendsList] invalid ProviderType.");
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda16
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.getProviderFriendsList$lambda$111(callMethodName, resultAPI2, listener, providerType);
                }
            });
            return;
        }
        if (playerInfo == null) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[getProviderFriendsList] Need sign in first.");
            final ResultAPI resultAPI3 = new ResultAPI(-9, ResultAPI.Code.AuthV4NeedSignIn, "[getProviderFriendsList] Need sign in first.");
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda17
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.getProviderFriendsList$lambda$112(callMethodName, resultAPI3, listener, providerType);
                }
            });
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        int i = WhenMappings.$EnumSwitchMapping$1[providerType.ordinal()];
        if (i == 1 || i == 2) {
            companion.getFriends(new AuthV4ProviderAdapter.ProviderFriendsListener() { // from class: com.hive.authv4.AuthV4Impl.getProviderFriendsList.4
                /* JADX WARN: Type inference failed for: r10v11, types: [T, java.util.ArrayList] */
                @Override // com.hive.authv4.provider.AuthV4ProviderAdapter.ProviderFriendsListener
                public void onProviderFriendsListener(ResultAPI result, ArrayList<String> providerUserIdList) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (!result.isSuccess()) {
                        objectRef.element.clear();
                        countDownLatch.countDown();
                        LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[getProviderFriendsList] provider getFriend Fail.");
                        listener.onGetProviderFriendsList(new ResultAPI(-8, ResultAPI.Code.AuthV4ResponseFailGetFriendList, "[getProviderFriendsList] provider getFriend Fail."), providerType, null);
                        return;
                    }
                    LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                    String tag = AuthV4.getTAG();
                    StringBuilder sb = new StringBuilder("Result Success........... + ");
                    sb.append(providerUserIdList != null ? Integer.valueOf(providerUserIdList.size()) : null);
                    loggerImpl.i(tag, sb.toString());
                    objectRef.element.clear();
                    int i2 = 0;
                    if (providerUserIdList == null || !(!providerUserIdList.isEmpty())) {
                        loggerImpl.i(AuthV4.getTAG(), "[getProviderFriendsList] provider getFriend Friend : 0.");
                        listener.onGetProviderFriendsList(new ResultAPI(0, ResultAPI.Code.Success, "[getProviderFriendsList] provider getFriend Friend : 0."), providerType, new HashMap());
                    } else {
                        ?? arrayList = new ArrayList();
                        StringBuffer stringBuffer = new StringBuffer();
                        int size = providerUserIdList.size();
                        StringBuffer stringBuffer2 = stringBuffer;
                        int i3 = 0;
                        while (i2 < size) {
                            stringBuffer2.append(providerUserIdList.get(i2));
                            i2++;
                            int i4 = i2 % 100;
                            if (i4 != 0 && i2 != providerUserIdList.size()) {
                                stringBuffer2.append(",");
                            }
                            LoggerImpl loggerImpl2 = LoggerImpl.INSTANCE;
                            loggerImpl2.dL(AuthV4.getTAG(), " check Buffer " + ((Object) stringBuffer2));
                            if (i4 == 0 || i2 == providerUserIdList.size()) {
                                arrayList.add(stringBuffer2.toString());
                                loggerImpl2.dL(AuthV4.getTAG(), " complete uids " + i3 + " = " + ((String) arrayList.get(i3)));
                                if (i2 != providerUserIdList.size()) {
                                    i3++;
                                    stringBuffer2 = new StringBuffer();
                                }
                            }
                        }
                        objectRef.element = arrayList;
                    }
                    countDownLatch.countDown();
                }
            });
            new Thread(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda18
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.getProviderFriendsList$lambda$114(countDownLatch, objectRef, playerInfo, providerType, listener, callMethodName);
                }
            }).start();
        } else {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[getProviderFriendsList] try Other provider : Fail.");
            new ResultAPI(-2, ResultAPI.Code.AuthV4NotSupportedProviderType, "[getProviderFriendsList] try Other provider : Fail.");
            listener.onGetProviderFriendsList(new ResultAPI(), providerType, null);
        }
    }

    public final void getStoredPlayerIdList(final AuthV4.AuthV4PlayerIdListListener listener) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d(AuthV4.getTAG(), "getAccountPlayerIdList");
        if (isSetup) {
            final ArrayList<Long> accountPlayerIdList = AuthV4Account.INSTANCE.getAccountPlayerIdList();
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda33
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.getStoredPlayerIdList$lambda$117(accountPlayerIdList, listener);
                }
            });
            return;
        }
        loggerImpl.w(AuthV4.getTAG(), "[getStoredPlayerIdList] Need AuthV4 setup first");
        ResultAPI resultAPI = new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[getStoredPlayerIdList] Need AuthV4 setup first");
        if (listener != null) {
            listener.onAuthV4GetPlayerIdList(resultAPI, new ArrayList<>());
        }
    }

    @Override // com.hive.module.interfaces.HiveAuthV4, com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        return HiveAuthV4.DefaultImpls.getVersionInfo(this);
    }

    public final boolean isAutoSignIn() {
        return isAutoSignIn;
    }

    public final boolean isSetup() {
        return isSetup;
    }

    public final void memoryReset$hive_service_release() {
        isAutoSignIn = false;
        isInProgressSign = false;
        recentConflictPlayerInfo = null;
        AuthV4Account.INSTANCE.memoryReset();
    }

    public final void onSetupCanceled() {
        onSetupFail(new ResultAPI(-6, ResultAPI.Code.AuthV4CancelDialog, ""));
    }

    public final void onStart(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public final void onStop(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public final synchronized void playerDelete(final AuthV4.AuthV4SignOutListener listener) {
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        AuthV4.PlayerInfo playerInfo = AuthV4Account.INSTANCE.getPlayerInfo();
        if (!isSetup) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[delete] Need AuthV4 setup first");
            onSignOutFinish(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[delete] Need AuthV4 setup first"), callMethodName, listener);
        } else if (isInProgressSign) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[delete] Sign is already in progress");
            onSignOutFinish(new ResultAPI(-3, ResultAPI.Code.AuthV4InProgress, "[delete] Sign is already in progress"), callMethodName, listener);
        } else if (playerInfo == null) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[delete] Need sign in first.");
            onSignOutFinish(new ResultAPI(-9, ResultAPI.Code.AuthV4NeedSignIn, "[delete] Need sign in first."), callMethodName, listener);
        } else {
            isInProgressSign = true;
            AuthV4Network.INSTANCE.playerDelete$hive_service_release(playerInfo, new Function2() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthV4Impl.playerDelete$lambda$46(callMethodName, listener, (ResultAPI) obj, (PlayerDelete) obj2);
                }
            });
        }
    }

    @Deprecated(message = "kotlin version")
    public final void requestPermissionViewData(final Permission.PermissionViewDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        PermissionImpl.INSTANCE.requestPermissionViewData(new Permission.PermissionViewDataListener() { // from class: com.hive.authv4.AuthV4Impl.requestPermissionViewData.1

            /* JADX INFO: renamed from: com.hive.authv4.AuthV4Impl$requestPermissionViewData$1$WhenMappings */
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
                    result = new ResultAPI(0, ResultAPI.Code.AuthV4SkipPermissionView);
                } else if (i == 3 || i == 4) {
                    result = new ResultAPI(0, ResultAPI.Code.AuthV4InProgress);
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

    public final void reset() {
        signOut(new AuthV4.AuthV4SignOutListener() { // from class: com.hive.authv4.AuthV4Impl.reset.1
            @Override // com.hive.AuthV4.AuthV4SignOutListener
            public void onAuthV4SignOut(ResultAPI result) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (result.isFailure()) {
                    AuthV4ProviderAdapter.INSTANCE.allLogout(new AuthV4ProviderAdapter.ProviderLogoutListener() { // from class: com.hive.authv4.AuthV4Impl$reset$1$onAuthV4SignOut$1
                        @Override // com.hive.authv4.provider.AuthV4ProviderAdapter.ProviderLogoutListener
                        public void onProviderLogoutListener(ResultAPI result2) {
                            Intrinsics.checkNotNullParameter(result2, "result");
                        }
                    });
                }
                HiveLifecycle.INSTANCE.onReset();
                Property.INSTANCE.getINSTANCE().deletePropertyFile();
                AuthV4Impl.isSetup = false;
                AuthV4Impl.isInProgressSetup = false;
                AuthV4Impl authV4Impl = AuthV4Impl.INSTANCE;
                authV4Impl.getIdpList().clear();
                authV4Impl.memoryReset$hive_service_release();
            }
        });
    }

    public final void resetAgreement() {
        Property.Companion companion = Property.INSTANCE;
        companion.getINSTANCE().removeValue(AuthV4Keys.AGREEMENT_REVIEW_URL);
        companion.getINSTANCE().removeValue(AuthV4Keys.AGREEMENT_AGREED_DATA);
        companion.getINSTANCE().removeValue(AuthV4Keys.AGREEMENT_AGREED_EVER);
        companion.getINSTANCE().removeValue(AuthV4Keys.AGREEMENT_SENT_PLAYER_LIST);
        companion.getINSTANCE().removeValue(AuthV4Keys.AGREEMENT_IS_SENT_BEFORE_LOGIN);
        companion.getINSTANCE().writeProperties();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void resolveConflict(final com.hive.AuthV4.AuthV4ResolveConflictListener r8) {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.AuthV4Impl.resolveConflict(com.hive.AuthV4$AuthV4ResolveConflictListener):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void selectConflict(long r10, com.hive.AuthV4.AuthV4SignInListener r12) {
        /*
            Method dump skipped, instruction units count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.AuthV4Impl.selectConflict(long, com.hive.AuthV4$AuthV4SignInListener):void");
    }

    public final void setAutoLoginEnabled(boolean enabled, AuthV4.AuthV4SetAutoLoginEnabledListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("[AuthV4] setAutoLoginEnabled");
        if (!isSetup) {
            loggerImpl.w(AuthV4.getTAG(), "[setAutoLoginEnabled] Need AuthV4 setup first");
            listener.onAuthV4SetAutoLoginEnabled(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[setAutoLoginEnabled] Need AuthV4 setup first"), AuthV4Account.INSTANCE.getEnableAutoLogin());
            return;
        }
        AuthV4Account authV4Account = AuthV4Account.INSTANCE;
        if (authV4Account.getPlayerInfo() != null) {
            loggerImpl.w(AuthV4.getTAG(), "[setAutoLoginEnabled] Already session exist. Not set setAutoLoginEnabled value.");
            listener.onAuthV4SetAutoLoginEnabled(new ResultAPI(20, ResultAPI.Code.AuthV4SessionExist, "[setAutoLoginEnabled] Already session exist. Not set setAutoLoginEnabled value."), authV4Account.getEnableAutoLogin());
        } else {
            if (isAutoSignIn) {
                loggerImpl.w(AuthV4.getTAG(), "[setAutoLoginEnabled] Saved session exist. Need to auto signIn.");
                listener.onAuthV4SetAutoLoginEnabled(new ResultAPI(-8, ResultAPI.Code.AuthV4SessionExist, "[setAutoLoginEnabled] Saved session exist. Need to auto signIn."), authV4Account.getEnableAutoLogin());
                return;
            }
            loggerImpl.d("[setAutoLoginEnabled] set enabled: " + enabled);
            authV4Account.setEnableAutoLogin(enabled);
            listener.onAuthV4SetAutoLoginEnabled(new ResultAPI(), authV4Account.getEnableAutoLogin());
        }
    }

    public final void setCheckProviderListener(AuthV4.AuthV4CheckProviderListener authV4CheckProviderListener) {
        checkProviderListener = authV4CheckProviderListener;
    }

    public final void setFacebookPermission(List<String> permission) {
        if (permission != null) {
            com.hive.core.Configuration.INSTANCE.setFacebookPermissionList(permission);
        }
    }

    public final void setProviderChangedListener(AuthV4.AuthV4CheckProviderListener listener) {
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthV4.getTAG(), "[setProviderChangedListener] AuthV4SignInListener is null");
        } else {
            checkProviderListener = listener;
        }
    }

    public final void setRecentConflictPlayerInfo(AuthV4.PlayerInfo playerInfo) {
        Intrinsics.checkNotNullParameter(playerInfo, "playerInfo");
        recentConflictPlayerInfo = playerInfo;
    }

    public final void setup(AuthV4.AuthV4SetupListener setupListener) {
        BuildersKt__Builders_commonKt.launch$default(setupScope, null, null, new C28381(setupListener, null), 3, null);
    }

    @Deprecated(message = "25.7.0")
    public final void showAdultConfirm(final AuthV4.AuthV4AdultConfirmListener listener) {
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthV4.getTAG(), "[showAdultConfirm] AuthV4AdultConfirmListener is null");
            return;
        }
        if (!isSetup) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[showAdultConfirm] need setup first");
            final ResultAPI resultAPI = new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[showAdultConfirm] need setup first");
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda62
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.showAdultConfirm$lambda$90(callMethodName, resultAPI, listener);
                }
            });
        } else if (isInProgressSign) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[selectConflict] Sign is already in progress.");
            final ResultAPI resultAPI2 = new ResultAPI(-3, ResultAPI.Code.AuthV4InProgress, "[selectConflict] Sign is already in progress.");
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda63
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.showAdultConfirm$lambda$91(callMethodName, resultAPI2, listener);
                }
            });
        } else {
            if (AuthV4Account.INSTANCE.getPlayerInfo() != null) {
                new AdultConfirmView(HiveActivity.INSTANCE.getRecentActivity(), new AuthDataInterface.AuthAdultConfirmListener() { // from class: com.hive.authv4.AuthV4Impl.showAdultConfirm.4
                    @Override // com.hive.auth.AuthDataInterface.AuthAdultConfirmListener
                    public void onAuthAdultConfirm(ResultAPI result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), callMethodName, result.toString());
                        listener.onAuthV4AdultConfirm(result);
                    }
                }).show();
                return;
            }
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[selectConflict] Need sign in first.");
            final ResultAPI resultAPI3 = new ResultAPI(-9, ResultAPI.Code.AuthV4NeedSignIn, "[selectConflict] Need sign in first.");
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda64
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.showAdultConfirm$lambda$92(callMethodName, resultAPI3, listener);
                }
            });
        }
    }

    public final void showAgeRangeUpdatePermission(String description, AuthV4.AuthV4GetAgeRangeListener listener) {
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[AuthV4] showAgeRangeUpdatePermission");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C28401(description, listener, null), 3, null);
    }

    public final void showChatbotInquiry(final String additionalInfo, final AuthV4.AuthV4ShowChatbotInquiryListener listener) {
        HashMap<AuthV4.ProviderType, AuthV4.ProviderInfo> providerInfoData;
        Intrinsics.checkNotNullParameter(additionalInfo, "additionalInfo");
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        AuthV4.PlayerInfo playerInfo = AuthV4Account.INSTANCE.getPlayerInfo();
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthV4.getTAG(), "[showChatbotInquiry] AuthV4ShowChatbotInquiryListener is null");
            return;
        }
        if (!isSetup) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[showChatbotInquiry] Need AuthV4 setup first.");
            final ResultAPI resultAPI = new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[showChatbotInquiry] Need AuthV4 setup first.");
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda65
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.showChatbotInquiry$lambda$83(callMethodName, resultAPI, listener);
                }
            });
            return;
        }
        AuthV4.ProviderInfo providerInfo = (playerInfo == null || (providerInfoData = playerInfo.getProviderInfoData()) == null) ? null : providerInfoData.get(AuthV4.ProviderType.HIVE);
        AuthV4ProviderHive authV4ProviderHive = AuthV4ProviderHive.INSTANCE;
        String membershipSession = authV4ProviderHive.getMembershipSession();
        if (providerInfo == null || !(membershipSession == null || StringsKt.isBlank(membershipSession))) {
            internalShowChatbotInquiry(callMethodName, additionalInfo, listener);
        } else {
            authV4ProviderHive.getMembershipSessionFromPlayerInfo(playerInfo, new Function1() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda67
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthV4Impl.showChatbotInquiry$lambda$85(callMethodName, additionalInfo, listener, (ResultAPI) obj);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x015b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void showConflictSelection(java.util.Map<java.lang.String, ? extends java.lang.Object> r20, java.util.Map<java.lang.String, ? extends java.lang.Object> r21, final com.hive.AuthV4.AuthV4SignInListener r22) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 622
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.AuthV4Impl.showConflictSelection(java.util.Map, java.util.Map, com.hive.AuthV4$AuthV4SignInListener):void");
    }

    public final void showDeviceManagement(final AuthV4.AuthV4ShowDeviceManagementListener listener) {
        AuthV4.PlayerInfo playerInfo;
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i("[showDeviceManagement] show");
        boolean z = com.hive.core.Configuration.INSTANCE.getAgeGateU13() || (playerInfo = AuthV4Account.INSTANCE.getPlayerInfo()) == null || playerInfo.isGuest();
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = DeviceManagement.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof DeviceManagement)) {
            hiveModule = null;
        }
        DeviceManagement deviceManagement = (DeviceManagement) (hiveModule instanceof DeviceManagement ? hiveModule : null);
        if (deviceManagement != null) {
            deviceManagement.show(HiveActivity.INSTANCE.getRecentActivity(), HiveLifecycle.INSTANCE.getAccount(), z, new Function1() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthV4Impl.showDeviceManagement$lambda$115(listener, (ResultAPI) obj);
                }
            });
        } else {
            listener.onAuthV4ShowDeviceManagement(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveDeviceManagement"));
        }
    }

    public final void showIdentityVerification(final AuthV4.AuthV4ShowIdentityVerificationListener listener) {
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthV4.getTAG(), "[showIdentityVerification] AuthV4ShowIdentityVerificationListener is null.");
            return;
        }
        if (!isSetup) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[showIdentityVerification] need setup first.");
            final ResultAPI resultAPI = new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[showIdentityVerification] need setup first.");
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda58
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.showIdentityVerification$lambda$93(callMethodName, resultAPI, listener);
                }
            });
            return;
        }
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = IdentityVerification.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof IdentityVerification)) {
            hiveModule = null;
        }
        if (!(hiveModule instanceof IdentityVerification)) {
            hiveModule = null;
        }
        IdentityVerification identityVerification = (IdentityVerification) hiveModule;
        if (identityVerification != null) {
            identityVerification.show(HiveActivity.INSTANCE.getRecentActivity(), null, new Function2() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda59
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthV4Impl.showIdentityVerification$lambda$96(callMethodName, listener, (ResultAPI) obj, (IdentityVerification.Identity) obj2);
                }
            });
            return;
        }
        ResultAPI resultAPI2 = new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIdentityVerification");
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), callMethodName, resultAPI2.toString());
        listener.onAuthV4ShowIdentityVerification(resultAPI2, null);
    }

    @Override // com.hive.module.interfaces.HiveAuthV4
    public void showInquiry(final AuthV4.AuthV4ShowInquiryListener listener) {
        HashMap<AuthV4.ProviderType, AuthV4.ProviderInfo> providerInfoData;
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        AuthV4.PlayerInfo playerInfo = AuthV4Account.INSTANCE.getPlayerInfo();
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthV4.getTAG(), "[showInquiry] AuthV4ShowInquiryListener is null");
            return;
        }
        if (!isSetup) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[showInquiry] Need AuthV4 setup first.");
            final ResultAPI resultAPI = new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[showInquiry] Need AuthV4 setup first.");
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda40
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.showInquiry$lambda$73(callMethodName, resultAPI, listener);
                }
            });
            return;
        }
        AuthV4.ProviderInfo providerInfo = (playerInfo == null || (providerInfoData = playerInfo.getProviderInfoData()) == null) ? null : providerInfoData.get(AuthV4.ProviderType.HIVE);
        AuthV4ProviderHive authV4ProviderHive = AuthV4ProviderHive.INSTANCE;
        String membershipSession = authV4ProviderHive.getMembershipSession();
        if (providerInfo == null || !(membershipSession == null || StringsKt.isBlank(membershipSession))) {
            internalShowInquiry(callMethodName, listener);
        } else {
            authV4ProviderHive.getMembershipSessionFromPlayerInfo(playerInfo, new Function1() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda41
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthV4Impl.showInquiry$lambda$75(callMethodName, listener, (ResultAPI) obj);
                }
            });
        }
    }

    @Override // com.hive.module.interfaces.HiveAuthV4
    public void showMyInquiry(final AuthV4.AuthV4ShowMyInquiryListener listener) {
        HashMap<AuthV4.ProviderType, AuthV4.ProviderInfo> providerInfoData;
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        AuthV4.PlayerInfo playerInfo = AuthV4Account.INSTANCE.getPlayerInfo();
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthV4.getTAG(), "[showMyInquiry] AuthV4ShowMyInquiryListener is null");
            return;
        }
        if (!isSetup) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[showMyInquiry] Need AuthV4 setup first.");
            final ResultAPI resultAPI = new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[showMyInquiry] Need AuthV4 setup first.");
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda38
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.showMyInquiry$lambda$78(callMethodName, resultAPI, listener);
                }
            });
            return;
        }
        AuthV4.ProviderInfo providerInfo = (playerInfo == null || (providerInfoData = playerInfo.getProviderInfoData()) == null) ? null : providerInfoData.get(AuthV4.ProviderType.HIVE);
        AuthV4ProviderHive authV4ProviderHive = AuthV4ProviderHive.INSTANCE;
        String membershipSession = authV4ProviderHive.getMembershipSession();
        if (providerInfo == null || !(membershipSession == null || StringsKt.isBlank(membershipSession))) {
            internalShowMyInquiry(callMethodName, listener);
        } else {
            authV4ProviderHive.getMembershipSessionFromPlayerInfo(playerInfo, new Function1() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda39
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthV4Impl.showMyInquiry$lambda$80(callMethodName, listener, (ResultAPI) obj);
                }
            });
        }
    }

    @Override // com.hive.module.interfaces.HiveAuthV4
    public void showProfile(final long playerId, final AuthV4.AuthV4ShowProfileListener listener) {
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        final AuthV4.PlayerInfo playerInfo = AuthV4Account.INSTANCE.getPlayerInfo();
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthV4.getTAG(), "[showProfile] AuthV4SignInListener is null");
            return;
        }
        if (!isSetup) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[showProfile] Need AuthV4 setup first");
            final ResultAPI resultAPI = new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[showProfile] Need AuthV4 setup first");
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda53
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.showProfile$lambda$67(callMethodName, resultAPI, listener);
                }
            });
            return;
        }
        if (playerInfo == null) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[connect] Need sign in first.");
            final ResultAPI resultAPI2 = new ResultAPI(-9, ResultAPI.Code.AuthV4NeedSignIn, "[connect] Need sign in first.");
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda54
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.showProfile$lambda$68(callMethodName, resultAPI2, listener);
                }
            });
            return;
        }
        if (playerId <= 0) {
            String str = "[showProfile] invalid player id - " + playerId;
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), str);
            final ResultAPI resultAPI3 = new ResultAPI(-1, ResultAPI.Code.AuthV4InvalidParamPlayerID, str);
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda56
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.showProfile$lambda$69(callMethodName, resultAPI3, listener);
                }
            });
            return;
        }
        AuthV4.ProviderInfo providerInfo = playerInfo.getProviderInfoData().get(AuthV4.ProviderType.HIVE);
        AuthV4ProviderHive authV4ProviderHive = AuthV4ProviderHive.INSTANCE;
        String userToken = authV4ProviderHive.getUserToken();
        if (providerInfo == null || !(userToken == null || StringsKt.isBlank(userToken))) {
            internalShowProfile(callMethodName, HiveActivity.INSTANCE.getRecentActivity(), playerInfo, playerId, listener);
        } else {
            authV4ProviderHive.getMembershipSessionFromPlayerInfo(playerInfo, new Function1() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda57
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthV4Impl.showProfile$lambda$71(callMethodName, playerInfo, playerId, listener, (ResultAPI) obj);
                }
            });
        }
    }

    public final void showSignIn(final AuthV4.AuthV4SignInListener listener) throws JSONException {
        Object jSONArray;
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthV4.getTAG(), "[showSignIn] AuthV4SignInListener is null");
            return;
        }
        if (!isSetup) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[showSignIn] Need AuthV4 setup first");
            onSignInFinish(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[showSignIn] Need AuthV4 setup first"), null, callMethodName, listener);
            return;
        }
        if (isInProgressSign) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[showSignIn] Sign is already in progress");
            onSignInFinish(new ResultAPI(-3, ResultAPI.Code.AuthV4InProgress, "[showSignIn] Sign is already in progress"), null, callMethodName, listener);
            return;
        }
        AuthV4Account authV4Account = AuthV4Account.INSTANCE;
        if (authV4Account.readPlayerInfo() != null || authV4Account.getPlayerInfo() != null) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[showSignIn] Already sign in or Exist remain session. please SignOut or SignIn first.");
            onSignInFinish(new ResultAPI(-8, ResultAPI.Code.AuthV4SessionExist, "[showSignIn] Already sign in or Exist remain session. please SignOut or SignIn first."), null, callMethodName, listener);
            return;
        }
        isInProgressSign = true;
        String did = HiveLifecycle.INSTANCE.getDid();
        JSONObject jSONObjectPutCI = CommonIdentifierKt.putCI(new JSONObject());
        String value = Property.INSTANCE.getINSTANCE().getValue(AuthV4Keys.AGREEMENT_AGREED_DATA);
        if (value != null) {
            try {
                if (!StringsKt.isBlank(value)) {
                    jSONArray = new JSONArray(value);
                }
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "agreed data parse exception: " + e);
            }
            jSONArray = null;
        } else {
            jSONArray = null;
        }
        try {
            HiveKeys hiveKeys = HiveKeys.KEY_appid;
            ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
            CommonIdentifierKt.put(jSONObjectPutCI, hiveKeys, configurationImpl.getAppId());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_did, did);
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_sdk_version, "4.26.2.0");
            HiveKeys hiveKeys2 = HiveKeys.KEY_os_version;
            Android android2 = Android.INSTANCE;
            CommonIdentifierKt.put(jSONObjectPutCI, hiveKeys2, android2.getOSVersion());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_os_api_level, String.valueOf(android2.getOSVersionCode()));
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_device_model, android2.getDeviceModel());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_country, android2.getCountry());
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_game_language, configurationImpl.getHiveLanguage());
            HiveKeys hiveKeys3 = HiveKeys.KEY_agreement;
            if (jSONArray == null) {
                jSONArray = JSONObject.NULL;
            }
            CommonIdentifierKt.put(jSONObjectPutCI, hiveKeys3, jSONArray);
            final String string = jSONObjectPutCI.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new OnActivityLifecycle() { // from class: com.hive.authv4.AuthV4Impl.showSignIn.1
                public AuthV4WebView authV4WebView;

                public final AuthV4WebView getAuthV4WebView() {
                    AuthV4WebView authV4WebView = this.authV4WebView;
                    if (authV4WebView != null) {
                        return authV4WebView;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("authV4WebView");
                    return null;
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public boolean onBackPressed() {
                    return getAuthV4WebView().onBackPressed();
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onCreate(Activity activity, Bundle savedInstanceState) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    super.onCreate(activity, savedInstanceState);
                    setAuthV4WebView(new AuthV4WebView(activity, UrlManager.AuthV4.INSTANCE.getViewIdp(), string, "hive", "signin", AuthV4WebView.CloseButtonType.TYPE_NORMAL, new AuthV4Impl$showSignIn$1$onCreate$1(callMethodName, listener, activity)));
                    getAuthV4WebView().show();
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onDestroy(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    if (!getIsCalledFinish()) {
                        getAuthV4WebView().dismiss();
                    }
                    super.onDestroy(activity);
                }

                public final void setAuthV4WebView(AuthV4WebView authV4WebView) {
                    Intrinsics.checkNotNullParameter(authV4WebView, "<set-?>");
                    this.authV4WebView = authV4WebView;
                }
            });
        } catch (Exception e2) {
            String str = "[showSignIn] invalid post data. " + e2;
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), str);
            onSignInFinish(new ResultAPI(-1, ResultAPI.Code.AuthV4JsonException, str), null, callMethodName, listener);
        }
    }

    public final void showTerms(final AuthV4.AuthV4ShowTermsListener listener) {
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthV4.getTAG(), "[showTerms] AuthV4ShowTermsListener is null");
            return;
        }
        if (!isSetup) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[showTerms] Need AuthV4 setup first.");
            final ResultAPI resultAPI = new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[showTerms] Need AuthV4 setup first.");
            mainLooperHandler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda75
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl.showTerms$lambda$88(callMethodName, resultAPI, listener);
                }
            });
            return;
        }
        if (!isInProgressTerms.compareAndSet(false, true)) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[showTerms] is in progress.");
            listener.onAuthV4ShowTerms(new ResultAPI(-3, ResultAPI.Code.AuthV4InProgress, "[showTerms] is in progress."));
            return;
        }
        final String value = Property.INSTANCE.getINSTANCE().getValue(AuthV4Keys.AGREEMENT_REVIEW_URL);
        if (value == null) {
            value = null;
        }
        if (value == null) {
            value = "";
        }
        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[showTerms] reviewUrl: " + value);
        HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new OnActivityLifecycle() { // from class: com.hive.authv4.AuthV4Impl.showTerms.2
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
            public void onCreate(Activity activity, Bundle savedInstanceState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                super.onCreate(activity, savedInstanceState);
                setAuthV4TermsView(new AuthV4TermsView(activity, value, new AuthV4Impl$showTerms$2$onCreate$1(listener, activity, callMethodName)));
                getAuthV4TermsView().show();
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onDestroy(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (!getIsCalledFinish()) {
                    getAuthV4TermsView().dismiss();
                }
                AuthV4Impl.isInProgressTerms.set(false);
                super.onDestroy(activity);
            }

            public final void setAuthV4TermsView(AuthV4TermsView authV4TermsView) {
                Intrinsics.checkNotNullParameter(authV4TermsView, "<set-?>");
                this.authV4TermsView = authV4TermsView;
            }
        });
    }

    public final synchronized void signIn(AuthV4.ProviderType providerType, AuthV4.AuthV4SignInListener listener) {
        Intrinsics.checkNotNullParameter(providerType, "providerType");
        signIn(providerType, null, false, listener);
    }

    public final synchronized void signInWithAuthKey(String authKey, AuthV4.AuthV4SignInListener listener) {
        String callMethodName = LoggerImpl.getCallMethodName(2);
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthV4.getTAG(), "[signInWithAuthKey] AuthV4SignInListener is null");
            return;
        }
        if (!isSetup) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[signInWithAuthKey] Need AuthV4 setup first");
            onSignInFinish(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[signInWithAuthKey] Need AuthV4 setup first"), null, callMethodName, listener);
            return;
        }
        if (isInProgressSign) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[signInWithAuthKey] Sign is already in progress");
            onSignInFinish(new ResultAPI(-3, ResultAPI.Code.AuthV4InProgress, "[signInWithAuthKey] Sign is already in progress"), null, callMethodName, listener);
            return;
        }
        if (authKey != null && !StringsKt.isBlank(authKey)) {
            if (AuthV4Account.INSTANCE.readPlayerInfo() == null) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C28461(authKey, callMethodName, listener, null), 3, null);
                return;
            } else {
                LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[signInWithAuthKey] Exist remain session. please SignOut first.");
                onSignInFinish(new ResultAPI(-1, ResultAPI.Code.AuthV4SessionExist, "[signInWithAuthKey] Exist remain session. please SignOut first."), null, callMethodName, listener);
                return;
            }
        }
        String str = "[signInWithAuthKey] this AUTH KEY is invalid. : " + authKey;
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.wL(AuthV4.getTAG(), str);
        loggerImpl.wR(AuthV4.getTAG(), "[signInWithAuthKey] this AUTH KEY is invalid.");
        onSignInFinish(new ResultAPI(-1, ResultAPI.Code.AuthV4InvalidParam, str), null, callMethodName, listener);
    }

    public final synchronized void signInWithStoredPlayerId(long playerId, boolean useAutoSignIn, AuthV4.AuthV4SignInListener listener) {
        String callMethodName = LoggerImpl.getCallMethodName(2);
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthV4.getTAG(), "[signInWithStoredPlayerId] AuthV4SignInListener is null");
            return;
        }
        if (!isSetup) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[signInWithStoredPlayerId] Need AuthV4 setup first");
            onSignInFinish(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[signInWithStoredPlayerId] Need AuthV4 setup first"), null, callMethodName, listener);
            return;
        }
        if (isInProgressSign) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[signInWithStoredPlayerId] Sign is already in progress");
            onSignInFinish(new ResultAPI(-3, ResultAPI.Code.AuthV4InProgress, "[signInWithStoredPlayerId] Sign is already in progress"), null, callMethodName, listener);
            return;
        }
        AuthV4Account authV4Account = AuthV4Account.INSTANCE;
        if (authV4Account.readPlayerInfo() != null) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[signInWithStoredPlayerId] Exist remain session. please SignOut first.");
            onSignInFinish(new ResultAPI(-1, ResultAPI.Code.AuthV4SessionExist, "[signInWithStoredPlayerId] Exist remain session. please SignOut first."), null, callMethodName, listener);
            return;
        }
        AuthV4.PlayerInfo playerInfoList = authV4Account.readPlayerInfoList(playerId);
        if (playerInfoList == null) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[signInWithStoredPlayerId] Not exist saved session.");
            onSignInFinish(new ResultAPI(-1, ResultAPI.Code.AuthV4SessionNotExist, "[signInWithStoredPlayerId] Not exist saved session."), null, callMethodName, listener);
            return;
        }
        isInProgressSign = true;
        LoggerImpl.INSTANCE.d("[signInWithStoredPlayerId] set AuthV4Account.enableAutoLogin from useAutoSignIn : " + useAutoSignIn);
        authV4Account.setEnableAutoLogin(useAutoSignIn);
        internalSignInPlayer(playerInfoList, callMethodName, listener);
    }

    public final synchronized void signOut(final AuthV4.AuthV4SignOutListener listener) {
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthV4.getTAG(), "[signOut] AuthV4SignOutListener is null");
            return;
        }
        if (!isSetup) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[signOut] Need AuthV4 setup first");
            onSignOutFinish(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[signOut] Need AuthV4 setup first"), callMethodName, listener);
            return;
        }
        if (isInProgressSign) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[signOut] Sign is already in progress");
            onSignOutFinish(new ResultAPI(-3, ResultAPI.Code.AuthV4InProgress, "[signOut] Sign is already in progress"), callMethodName, listener);
            return;
        }
        isInProgressSign = true;
        AuthV4Account authV4Account = AuthV4Account.INSTANCE;
        AuthV4.PlayerInfo playerInfo = authV4Account.readPlayerInfo();
        boolean zContains = playerInfo != null ? authV4Account.getAccountPlayerIdList().contains(Long.valueOf(playerInfo.getPlayerId())) : false;
        if (!zContains) {
            AuthV4Network.INSTANCE.signOut$hive_service_release(authV4Account.readPlayerInfo(), new Function2() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda44
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthV4Impl.signOut$lambda$44(callMethodName, listener, (ResultAPI) obj, (SignOut) obj2);
                }
            });
            return;
        }
        LoggerImpl.INSTANCE.d("[signOut] isCurrentPlayer : " + zContains);
        internalSignOut(callMethodName, listener);
    }

    public final void storeCurrentPlayerId(AuthV4.AuthV4StorePlayerIdListener listener) {
        String callMethodName = LoggerImpl.getCallMethodName(2);
        if (!isSetup) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[storeCurrentPlayerId] Need AuthV4 setup first");
            internalStorePlayerId(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[storeCurrentPlayerId] Need AuthV4 setup first"), callMethodName, listener);
            return;
        }
        AuthV4Account authV4Account = AuthV4Account.INSTANCE;
        if (authV4Account.readPlayerInfo() == null || authV4Account.getPlayerInfo() == null) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[storeCurrentPlayerId] Need sign in first.");
            internalStorePlayerId(new ResultAPI(-9, ResultAPI.Code.AuthV4NeedSignIn, "[storeCurrentPlayerId] Need sign in first."), callMethodName, listener);
        } else if (authV4Account.getAccountPlayerIdList().size() >= 50) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[storeCurrentPlayerId] Can't save session more than 50.");
            internalStorePlayerId(new ResultAPI(-9, ResultAPI.Code.AuthV4SessionProcessingFail, "[storeCurrentPlayerId] Can't save session more than 50."), callMethodName, listener);
        } else if (authV4Account.writePlayerInfoList()) {
            internalStorePlayerId(new ResultAPI(), callMethodName, listener);
        } else {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[storeCurrentPlayerId] Save session failed.");
            internalStorePlayerId(new ResultAPI(-8, ResultAPI.Code.AuthV4SessionProcessingFail, "[storeCurrentPlayerId] Save session failed."), callMethodName, listener);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0002CDB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006Bg\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\u0015Bq\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\u0017J\b\u0010<\u001a\u00020\u0012H\u0016J\u0018\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0012H\u0016J\u0010\u0010A\u001a\u00020>2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010B\u001a\u00020\bH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010\u001bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0019\"\u0004\b+\u0010\u001bR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0019\"\u0004\b1\u0010\u001bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0019\"\u0004\b3\u0010\u001bR*\u00104\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0019\"\u0004\b;\u0010\u001b¨\u0006E"}, d2 = {"Lcom/hive/authv4/AuthV4Impl$Agreement;", "Lcom/hive/base/DataModel;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "<init>", "(Landroid/os/Parcel;)V", "did", "", UserDataStore.COUNTRY, "show", "", "VIEWMODE", "Lcom/hive/authv4/AuthV4Impl$Agreement$ViewMode;", "type", "url", "groupCode", "version", "", "reviewUrl", "scheme", "(Ljava/lang/String;Ljava/lang/String;ZLcom/hive/authv4/AuthV4Impl$Agreement$ViewMode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "agreementExUrl", "(Ljava/lang/String;Ljava/lang/String;ZLcom/hive/authv4/AuthV4Impl$Agreement$ViewMode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDid", "()Ljava/lang/String;", "setDid", "(Ljava/lang/String;)V", "getCountry", "setCountry", "getShow", "()Z", "setShow", "(Z)V", "getVIEWMODE", "()Lcom/hive/authv4/AuthV4Impl$Agreement$ViewMode;", "setVIEWMODE", "(Lcom/hive/authv4/AuthV4Impl$Agreement$ViewMode;)V", "getType", "setType", "getUrl", "setUrl", "getGroupCode", "setGroupCode", MobileAdsBridge.versionMethodName, "()I", "setVersion", "(I)V", "getReviewUrl", "setReviewUrl", "getScheme", "setScheme", MediationConfiguration.CUSTOM_EVENT_SERVER_PARAMETER_FIELD, "", "getParameter", "()Ljava/util/Map;", "setParameter", "(Ljava/util/Map;)V", "getAgreementExUrl", "setAgreementExUrl", "describeContents", "writeToParcel", "", "dest", "flags", "readFromParcel", InAppPurchaseConstants.METHOD_TO_STRING, "ViewMode", "CREATOR", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Agreement extends DataModel implements Parcelable {

        /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private ViewMode VIEWMODE;
        private String agreementExUrl;
        private String country;
        private String did;
        private String groupCode;
        private Map<String, String> parameter;
        private String reviewUrl;
        private String scheme;
        private boolean show;
        private String type;
        private String url;
        private int version;

        /* JADX INFO: renamed from: com.hive.authv4.AuthV4Impl$Agreement$CREATOR, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/hive/authv4/AuthV4Impl$Agreement$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/hive/authv4/AuthV4Impl$Agreement;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", ContentDisposition.Parameters.Size, "", "(I)[Lcom/hive/authv4/AuthV4Impl$Agreement;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion implements Parcelable.Creator<Agreement> {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Agreement createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Agreement(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Agreement[] newArray(int size) {
                return new Agreement[size];
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/hive/authv4/AuthV4Impl$Agreement$ViewMode;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "REQUIRE", "OPTION", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class ViewMode {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ ViewMode[] $VALUES;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE;
            private static final HashMap<String, ViewMode> map;
            private final String value;
            public static final ViewMode REQUIRE = new ViewMode("REQUIRE", 0, "require");
            public static final ViewMode OPTION = new ViewMode("OPTION", 1, "option");

            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0006R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/hive/authv4/AuthV4Impl$Agreement$ViewMode$Companion;", "", "<init>", "()V", "map", "Ljava/util/HashMap;", "", "Lcom/hive/authv4/AuthV4Impl$Agreement$ViewMode;", "Lkotlin/collections/HashMap;", "getViewMode", "key", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final ViewMode getViewMode(String key) {
                    return (ViewMode) ViewMode.map.get(key);
                }

                private Companion() {
                }
            }

            private static final /* synthetic */ ViewMode[] $values() {
                return new ViewMode[]{REQUIRE, OPTION};
            }

            static {
                ViewMode[] viewModeArr$values = $values();
                $VALUES = viewModeArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(viewModeArr$values);
                INSTANCE = new Companion(null);
                map = new HashMap<>();
                for (ViewMode viewMode : values()) {
                    map.put(viewMode.value, viewMode);
                }
            }

            private ViewMode(String str, int i, String str2) {
                this.value = str2;
            }

            public static EnumEntries<ViewMode> getEntries() {
                return $ENTRIES;
            }

            public static ViewMode valueOf(String str) {
                return (ViewMode) Enum.valueOf(ViewMode.class, str);
            }

            public static ViewMode[] values() {
                return (ViewMode[]) $VALUES.clone();
            }

            public final String getValue() {
                return this.value;
            }
        }

        public Agreement(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            readFromParcel(source);
        }

        private final void readFromParcel(Parcel source) {
            this.did = source.readString();
            this.country = source.readString();
            this.show = source.readInt() == 1;
            this.VIEWMODE = ViewMode.INSTANCE.getViewMode(source.readString());
            this.type = source.readString();
            this.url = source.readString();
            this.groupCode = source.readString();
            this.version = source.readInt();
            this.reviewUrl = source.readString();
            this.scheme = source.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final String getAgreementExUrl() {
            return this.agreementExUrl;
        }

        public final String getCountry() {
            return this.country;
        }

        public final String getDid() {
            return this.did;
        }

        public final String getGroupCode() {
            return this.groupCode;
        }

        public final Map<String, String> getParameter() {
            return this.parameter;
        }

        public final String getReviewUrl() {
            return this.reviewUrl;
        }

        public final String getScheme() {
            return this.scheme;
        }

        public final boolean getShow() {
            return this.show;
        }

        public final String getType() {
            return this.type;
        }

        public final String getUrl() {
            return this.url;
        }

        public final ViewMode getVIEWMODE() {
            return this.VIEWMODE;
        }

        public final int getVersion() {
            return this.version;
        }

        public final void setAgreementExUrl(String str) {
            this.agreementExUrl = str;
        }

        public final void setCountry(String str) {
            this.country = str;
        }

        public final void setDid(String str) {
            this.did = str;
        }

        public final void setGroupCode(String str) {
            this.groupCode = str;
        }

        public final void setParameter(Map<String, String> map) {
            this.parameter = map;
        }

        public final void setReviewUrl(String str) {
            this.reviewUrl = str;
        }

        public final void setScheme(String str) {
            this.scheme = str;
        }

        public final void setShow(boolean z) {
            this.show = z;
        }

        public final void setType(String str) {
            this.type = str;
        }

        public final void setUrl(String str) {
            this.url = str;
        }

        public final void setVIEWMODE(ViewMode viewMode) {
            this.VIEWMODE = viewMode;
        }

        public final void setVersion(int i) {
            this.version = i;
        }

        @Override // com.hive.base.DataModel
        public String toString() {
            String str = "Agreement : \n  did: " + this.did + "\n  country: " + this.country + "\n  show: " + this.show + "\n  VIEWMODE: " + this.VIEWMODE + "\n  type: " + this.type + "\n  url: " + this.url + "\n  groupCode: " + this.groupCode + "\n  version: " + this.version + "\n  reviewUrl: " + this.reviewUrl + "\n  scheme: " + this.scheme + "\n";
            Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.did);
            dest.writeString(this.country);
            dest.writeInt(this.show ? 1 : 0);
            ViewMode viewMode = this.VIEWMODE;
            dest.writeString(viewMode != null ? viewMode.getValue() : null);
            dest.writeString(this.type);
            dest.writeString(this.url);
            dest.writeString(this.groupCode);
            dest.writeInt(this.version);
            dest.writeString(this.reviewUrl);
            dest.writeString(this.scheme);
        }

        public Agreement(String str, String str2, boolean z, ViewMode VIEWMODE, String str3, String str4, String str5, int i, String str6, String str7) {
            Intrinsics.checkNotNullParameter(VIEWMODE, "VIEWMODE");
            this.did = str;
            this.country = str2;
            this.show = z;
            this.VIEWMODE = VIEWMODE;
            this.type = str3;
            this.url = str4;
            this.groupCode = str5;
            this.version = i;
            this.reviewUrl = str6;
            this.scheme = str7;
        }

        public Agreement(String str, String str2, boolean z, ViewMode VIEWMODE, String str3, String str4, String str5, int i, String str6, String str7, String str8) {
            Intrinsics.checkNotNullParameter(VIEWMODE, "VIEWMODE");
            this.did = str;
            this.country = str2;
            this.show = z;
            this.VIEWMODE = VIEWMODE;
            this.type = str3;
            this.url = str4;
            this.groupCode = str5;
            this.version = i;
            this.reviewUrl = str6;
            this.scheme = str7;
            this.agreementExUrl = str8;
        }
    }

    public static /* synthetic */ void signIn$default(AuthV4Impl authV4Impl, AuthV4.ProviderType providerType, String str, boolean z, AuthV4.AuthV4SignInListener authV4SignInListener, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        authV4Impl.signIn(providerType, str, z, authV4SignInListener);
    }

    public final synchronized void disconnect(final String providerName, final AuthV4.AuthV4DisconnectListener listener) {
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        final AuthV4.PlayerInfo playerInfo = AuthV4Account.INSTANCE.getPlayerInfo();
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthV4.getTAG(), "[disconnect] AuthV4DisconnectListener is null.");
            return;
        }
        if (!isSetup) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[disconnect] Need AuthV4 setup first.");
            onDisconnectFinish(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[disconnect] Need AuthV4 setup first."), callMethodName, listener);
            return;
        }
        if (providerName != null && !StringsKt.isBlank(providerName)) {
            if (isInProgressSign) {
                LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[disconnect] Sign is already in progress.");
                onDisconnectFinish(new ResultAPI(-3, ResultAPI.Code.AuthV4InProgress, "[disconnect] Sign is already in progress."), callMethodName, listener);
                return;
            }
            if (playerInfo == null) {
                LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[disconnect] Need sign in first.");
                onDisconnectFinish(new ResultAPI(-9, ResultAPI.Code.AuthV4NeedSignIn, "[disconnect] Need sign in first."), callMethodName, listener);
                return;
            }
            final AuthV4.ProviderType providerType = AuthV4.ProviderType.INSTANCE.getProviderType(providerName);
            AuthV4.ProviderInfo providerInfo = providerType != null ? playerInfo.getProviderInfoData().get(providerType) : playerInfo.getCustomProviderInfoData().get(providerName);
            if (providerInfo == null) {
                LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[disconnect] this provider type is already disconnected, connect first.");
                onDisconnectFinish(new ResultAPI(-1, ResultAPI.Code.AuthV4ProviderAlreadyDisconnected, "[disconnect] this provider type is already disconnected, connect first."), callMethodName, listener);
                return;
            } else {
                isInProgressSign = true;
                AuthV4Network.INSTANCE.disconnect$hive_service_release(playerInfo, providerInfo, new Function2() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda36
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AuthV4Impl.disconnect$lambda$51(providerType, playerInfo, providerName, callMethodName, listener, (ResultAPI) obj, (Disconnect) obj2);
                    }
                });
                return;
            }
        }
        LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[disconnect] ProviderType is null.");
        onDisconnectFinish(new ResultAPI(-1, ResultAPI.Code.AuthV4InvalidProviderType, "[disconnect] ProviderType is null."), callMethodName, listener);
    }

    public final synchronized void signIn(AuthV4.ProviderType providerType, String tokenFromWeb, AuthV4.AuthV4SignInListener listener) {
        Intrinsics.checkNotNullParameter(providerType, "providerType");
        signIn(providerType, tokenFromWeb, false, listener);
    }

    public final synchronized void signIn(AuthV4.ProviderType providerType, String tokenFromWeb, boolean reSignIn, AuthV4.AuthV4SignInListener listener) {
        Intrinsics.checkNotNullParameter(providerType, "providerType");
        String callMethodName = LoggerImpl.getCallMethodName(2);
        if (listener == null) {
            LoggerImpl.INSTANCE.e(AuthV4.getTAG(), "[SignIn] AuthV4SignInListener is null");
            return;
        }
        if (!isSetup) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[SignIn] Need AuthV4 setup first");
            onSignInFinish(new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[SignIn] Need AuthV4 setup first"), null, callMethodName, listener);
            return;
        }
        if (isInProgressSign) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[SignIn] Sign is already in progress");
            onSignInFinish(new ResultAPI(-3, ResultAPI.Code.AuthV4InProgress, "[SignIn] Sign is already in progress"), null, callMethodName, listener);
            return;
        }
        AuthV4.PlayerInfo playerInfo = AuthV4Account.INSTANCE.readPlayerInfo();
        if (playerInfo != null && providerType != AuthV4.ProviderType.AUTO) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[SignIn] Exist remain session. please SignOut first.");
            onSignInFinish(new ResultAPI(-1, ResultAPI.Code.AuthV4SessionExist, "[SignIn] Exist remain session. please SignOut first."), null, callMethodName, listener);
        } else if (playerInfo != null || providerType != AuthV4.ProviderType.AUTO) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C28441(reSignIn, providerType, tokenFromWeb, callMethodName, listener, null), 3, null);
        } else {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "[SignIn] Does not exist remain session. please SignIn Provider.");
            onSignInFinish(new ResultAPI(-1, ResultAPI.Code.AuthV4SessionNotExist, "[SignIn] Does not exist remain session. please SignIn Provider."), null, callMethodName, listener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processGamerId(final String authKey, final String fApiName, final AuthV4.AuthV4SignInListener listener) {
        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "processGamerId(authKey)");
        AuthV4Network.INSTANCE.isGamerId$hive_service_release(authKey, new Function4() { // from class: com.hive.authv4.AuthV4Impl$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return AuthV4Impl.processGamerId$lambda$39(authKey, fApiName, listener, (ResultAPI) obj, ((Boolean) obj2).booleanValue(), (String) obj3, (String) obj4);
            }
        });
    }
}
