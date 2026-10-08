package com.hive.authv4;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.net.HttpHeaders;
import com.hive.AuthV4;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.analytics.AnalyticsReferrerSender;
import com.hive.auth.MaintenanceDialog;
import com.hive.authv4.AuthV4Network;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.base.Android;
import com.hive.base.Property;
import com.hive.configuration.ConfigurationImpl;
import com.hive.configuration.ModuleChecker;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.Configuration;
import com.hive.core.HiveKeys;
import com.hive.core.Platform;
import com.hive.core.Result;
import com.hive.logger.LoggerImpl;
import com.hive.protocol.Protocol;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.authv4.AuthIdp;
import com.hive.protocol.authv4.AuthIdpToken;
import com.hive.protocol.authv4.AuthV4;
import com.hive.protocol.authv4.Blacklist;
import com.hive.protocol.authv4.Connect;
import com.hive.protocol.authv4.CustomAuthConnect;
import com.hive.protocol.authv4.CustomAuthSignInIdp;
import com.hive.protocol.authv4.Disconnect;
import com.hive.protocol.authv4.GetIdpUid;
import com.hive.protocol.authv4.GetPolicy;
import com.hive.protocol.authv4.Idp;
import com.hive.protocol.authv4.IsGamerId;
import com.hive.protocol.authv4.OauthToken;
import com.hive.protocol.authv4.PlayerDelete;
import com.hive.protocol.authv4.SelectIdp;
import com.hive.protocol.authv4.SignIn;
import com.hive.protocol.authv4.SignInIdp;
import com.hive.protocol.authv4.SignInPlayer;
import com.hive.protocol.authv4.SignOut;
import com.hive.protocol.membership.Membership;
import com.hive.protocol.profileapi.GetPlayer;
import com.hive.protocol.profileapi.ProfileApi;
import com.hive.protocol.profileapi.Upload;
import com.hive.protocol.profileapi.UploadFile;
import com.hive.protocol.provision.AddDownload;
import com.hive.protocol.provision.AddSetInfo;
import com.hive.protocol.provision.AgreementDetermineBasePlayer;
import com.hive.protocol.provision.GetBlockedCountry;
import com.hive.protocol.provision.GetMaintenance;
import com.hive.protocol.provision.Integration;
import com.hive.protocol.provision.MetadataInitInteraction;
import com.hive.protocol.provision.NoticePopupSettleBill;
import com.hive.protocol.provision.Provision;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¤\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0006\u0083\u0001\u0084\u0001\u0085\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\f\u001a\u00020\r*\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ\u0011\u0010\f\u001a\u00020\r*\u00020\u0010H\u0000¢\u0006\u0002\b\u000fJ\u0011\u0010\f\u001a\u00020\r*\u00020\u0011H\u0000¢\u0006\u0002\b\u000fJ\u0011\u0010\f\u001a\u00020\r*\u00020\u0012H\u0000¢\u0006\u0002\b\u000fJ \u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019*\u00020\u000eH\u0000¢\u0006\u0002\b\u001aJ!\u0010\u001b\u001a\u00020\u001c*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000¢\u0006\u0002\b J\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\"*\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\b%Jf\u0010&\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010(2M\u0010)\u001aI\u0012\u0013\u0012\u00110\r¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110-¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(&\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u001c0*H\u0000¢\u0006\u0002\b/J?\u00100\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(2\u0006\u00101\u001a\u0002022 \u0010)\u001a\u001c\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u000203\u0012\u0006\u0012\u0004\u0018\u00010(\u0012\u0004\u0012\u00020\u001c0*H\u0000¢\u0006\u0002\b4JG\u00105\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(2\u0006\u00106\u001a\u00020\u00172(\u0010)\u001a$\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u000208\u0012\u0006\u0012\u0004\u0018\u00010(\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u001c07H\u0000¢\u0006\u0002\b9J7\u0010:\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0018\u0010)\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\u001c0=H\u0000¢\u0006\u0002\b?J~\u0010@\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00172W\u0010)\u001aS\u0012\u0013\u0012\u00110\r¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110D¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(@\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020F0E¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\u001c0*H\u0000¢\u0006\u0002\bHJU\u0010I\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(2\u0006\u0010J\u001a\u00020\u001726\u0010)\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110K¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(I\u0012\u0004\u0012\u00020\u001c0=H\u0000¢\u0006\u0002\bLJ(\u0010M\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020O\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0\"0NH\u0080@¢\u0006\u0004\bP\u0010QJE\u0010R\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(2\u0006\u0010S\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u001e\u0010)\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001c0*H\u0000¢\u0006\u0002\bUJA\u0010V\u001a\u00020\u001c2\b\u0010W\u001a\u0004\u0018\u00010\u00172(\u0010)\u001a$\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020X\u0012\u0006\u0012\u0004\u0018\u00010(\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u001c07H\u0000¢\u0006\u0002\bYJG\u0010Z\u001a\u00020\u001c2\u0006\u00101\u001a\u0002022\u0006\u0010[\u001a\u00020\u00172(\u0010)\u001a$\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\\\u0012\u0006\u0012\u0004\u0018\u00010(\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u001c07H\u0000¢\u0006\u0002\b]JO\u0010^\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u00172\u0006\u0010[\u001a\u00020\u001720\u0010)\u001a,\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020`\u0012\u0006\u0012\u0004\u0018\u00010(\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u001c0_H\u0000¢\u0006\u0002\baJ3\u0010b\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010(2\u001a\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010c\u0012\u0004\u0012\u00020\u001c0=H\u0000¢\u0006\u0002\bdJw\u0010e\u001a\u00020\u001c2\u0006\u00101\u001a\u0002022`\u0010)\u001a\\\u0012\u0013\u0012\u00110\r¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(f\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(g\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(h\u0012\u0004\u0012\u00020\u001c07H\u0000¢\u0006\u0002\biJw\u0010e\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u00172`\u0010)\u001a\\\u0012\u0013\u0012\u00110\r¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(f\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(g\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(h\u0012\u0004\u0012\u00020\u001c07H\u0000¢\u0006\u0002\biJ\u0088\u0001\u0010e\u001a\u00020\u001c2\b\u0010j\u001a\u0004\u0018\u00010\u00172\b\u0010k\u001a\u0004\u0018\u00010\u00172\b\u00106\u001a\u0004\u0018\u00010\u00172`\u0010)\u001a\\\u0012\u0013\u0012\u00110\r¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(f\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(g\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(h\u0012\u0004\u0012\u00020\u001c07H\u0002Jm\u0010l\u001a\u00020\u001c2\u0006\u0010m\u001a\u00020B2\u0006\u0010n\u001a\u00020\u00172\b\u0010o\u001a\u0004\u0018\u00010\u00172K\u0010)\u001aG\u0012\u0013\u0012\u00110\r¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(p\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(q\u0012\u0004\u0012\u00020\u001c0*J\u0097\u0001\u0010r\u001a\u00020\u001c2\u0006\u0010m\u001a\u00020B2\u0006\u0010p\u001a\u00020\u00172\u0006\u0010q\u001a\u00020\u00172\u0006\u0010[\u001a\u00020\u00172h\u0010)\u001ad\u0012\u0013\u0012\u00110\r¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110F¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(s\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(p\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(j\u0012\u0006\u0012\u0004\u0018\u00010(\u0012\u0004\u0012\u00020\u001c0_H\u0000¢\u0006\u0002\btJ\u001d\u0010u\u001a\u00020v2\u0006\u0010k\u001a\u00020\u00172\u0006\u0010g\u001a\u00020\u0017H\u0000¢\u0006\u0002\bwJ=\u0010x\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(2&\u0010)\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020y\u0012\u0004\u0012\u00020(\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u001c07H\u0000¢\u0006\u0002\bzJ/\u0010{\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(2\u0018\u0010)\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020|\u0012\u0004\u0012\u00020\u001c0=H\u0000¢\u0006\u0002\b}J#\u0010~\u001a\u00020\u007f2\u0006\u0010n\u001a\u00020\u00172\u0007\u0010\u0080\u0001\u001a\u00020\u0017H\u0081@¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0086\u0001"}, d2 = {"Lcom/hive/authv4/AuthV4Network;", "", "<init>", "()V", "noticePopupSettleBillReqResult", "", "", "", "getNoticePopupSettleBillReqResult", "()Ljava/util/Map;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "toResultAPI", "Lcom/hive/ResultAPI;", "Lcom/hive/protocol/authv4/AuthV4$AuthV4Response;", "toResultAPI$hive_service_release", "Lcom/hive/protocol/provision/Provision$ProvisionResponse;", "Lcom/hive/protocol/profileapi/ProfileApi$ProfileApiResponse;", "Lcom/hive/protocol/membership/Membership$MembershipResponse;", "coreResult", "Lcom/hive/core/Result;", "resultCode", "resultMsg", "", "getBlacklistData", "Lcom/hive/AuthV4$AuthV4MaintenanceInfo;", "getBlacklistData$hive_service_release", "showBlacklistDialog", "", "resultApi", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/AuthV4$AuthV4MaintenanceListener;", "showBlacklistDialog$hive_service_release", "getMaintenanceInfoList", "Ljava/util/ArrayList;", "maintenanceInfoJSONArray", "Lorg/json/JSONArray;", "getMaintenanceInfoList$hive_service_release", "blacklist", "playerInfo", "Lcom/hive/AuthV4$PlayerInfo;", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Lcom/hive/protocol/authv4/Blacklist;", "blacklistData", "blacklist$hive_service_release", "connect", "provider", "Lcom/hive/authv4/provider/AuthV4ProviderAdapter;", "Lcom/hive/protocol/authv4/Connect;", "connect$hive_service_release", "customAuthConnect", "authKey", "Lkotlin/Function4;", "Lcom/hive/protocol/authv4/CustomAuthConnect;", "customAuthConnect$hive_service_release", "disconnect", "providerInfo", "Lcom/hive/AuthV4$ProviderInfo;", "Lkotlin/Function2;", "Lcom/hive/protocol/authv4/Disconnect;", "disconnect$hive_service_release", "getIdpUid", "providerType", "Lcom/hive/AuthV4$ProviderType;", "providerUserIds", "Lcom/hive/protocol/authv4/GetIdpUid;", "Ljava/util/HashMap;", "", "mapIdpFromProviderUid", "getIdpUid$hive_service_release", "getPolicy", "policyType", "Lcom/hive/protocol/authv4/GetPolicy;", "getPolicy$hive_service_release", "idp", "Lkotlin/Triple;", "Lcom/hive/protocol/authv4/Idp;", "idp$hive_service_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectIdp", "conflictPlayer", "Lcom/hive/protocol/authv4/SelectIdp;", "selectIdp$hive_service_release", "signIn", "recaptchaToken", "Lcom/hive/protocol/authv4/SignIn;", "signIn$hive_service_release", "signInIdp", "player", "Lcom/hive/protocol/authv4/SignInIdp;", "signInIdp$hive_service_release", "customAuthSignInIdp", "Lkotlin/Function5;", "Lcom/hive/protocol/authv4/CustomAuthSignInIdp;", "customAuthSignInIdp$hive_service_release", "signOut", "Lcom/hive/protocol/authv4/SignOut;", "signOut$hive_service_release", "isGamerId", "shouldShow", InAppPurchaseMetaData.KEY_SIGNATURE, "url", "isGamerId$hive_service_release", "idpId", "idpUserId", "getAuthIdpToken", "idpType", "code", "redirectUri", "userId", "token", "getAuthIdp", "playerId", "getAuthIdp$hive_service_release", "getGamerIdWebViewPostData", "Lorg/json/JSONObject;", "getGamerIdWebViewPostData$hive_service_release", "signInPlayer", "Lcom/hive/protocol/authv4/SignInPlayer;", "signInPlayer$hive_service_release", "playerDelete", "Lcom/hive/protocol/authv4/PlayerDelete;", "playerDelete$hive_service_release", "oauthToken", "Lcom/hive/protocol/authv4/OauthToken$OauthTokenResponse;", "verifier", "oauthToken$hive_service_release", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "GetIdpUidCountDown", "Provision", "ProfileApi", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4Network {
    public static final AuthV4Network INSTANCE = new AuthV4Network();
    private static final CoroutineDispatcher ioDispatcher;
    private static final Map<Integer, Boolean> noticePopupSettleBillReqResult;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/hive/authv4/AuthV4Network$GetIdpUidCountDown;", "", "<init>", "()V", "loopLatch", "Ljava/util/concurrent/CountDownLatch;", "getLoopLatch", "()Ljava/util/concurrent/CountDownLatch;", "setLoopLatch", "(Ljava/util/concurrent/CountDownLatch;)V", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GetIdpUidCountDown {
        public static final GetIdpUidCountDown INSTANCE = new GetIdpUidCountDown();
        private static CountDownLatch loopLatch;

        private GetIdpUidCountDown() {
        }

        public final CountDownLatch getLoopLatch() {
            return loopLatch;
        }

        public final void setLoopLatch(CountDownLatch countDownLatch) {
            loopLatch = countDownLatch;
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00050\nH\u0000¢\u0006\u0002\b\rJe\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u001226\u0010\t\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00050\nH\u0000¢\u0006\u0002\b\u0019Je\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u001226\u0010\t\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00050\nH\u0000¢\u0006\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/hive/authv4/AuthV4Network$ProfileApi;", "", "<init>", "()V", "getPlayer", "", "playerIdList", "Ljava/util/ArrayList;", "", "callback", "Lkotlin/Function2;", "Lcom/hive/ResultAPI;", "Lcom/hive/AuthV4$ProfileInfo;", "getPlayer$hive_service_release", "upload", "playerInfo", "Lcom/hive/AuthV4$PlayerInfo;", "providerName", "", "profileImageUrl", "profileName", "Lkotlin/ParameterName;", "name", "resultApi", "Lcom/hive/protocol/profileapi/Upload;", "upload$hive_service_release", "uploadFile", "profileImageData", "", "Lcom/hive/protocol/profileapi/UploadFile;", "uploadFile$hive_service_release", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ProfileApi {
        public static final ProfileApi INSTANCE = new ProfileApi();

        private ProfileApi() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit getPlayer$lambda$1(Function2 function2, GetPlayer it) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(it, "it");
            if (it.getResponse().isSuccess()) {
                arrayList = new ArrayList();
                JSONArray data = it.getResponse().getData();
                if (data != null) {
                    int length = data.length();
                    for (int i = 0; i < length; i++) {
                        AuthV4.ProfileInfo profileInfo = new AuthV4.ProfileInfo();
                        try {
                            JSONObject jSONObject = data.getJSONObject(i);
                            profileInfo.setPlayerId(jSONObject.getLong("player_id"));
                            String strOptString = jSONObject.optString("profile_name");
                            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                            profileInfo.setPlayerName(strOptString);
                            String strOptString2 = jSONObject.optString("profile_img");
                            Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                            profileInfo.setPlayerImageUrl(strOptString2);
                            arrayList.add(profileInfo);
                        } catch (Exception unused) {
                            LoggerImpl.INSTANCE.w("invalid profile info. : " + data);
                        }
                    }
                }
            } else {
                arrayList = null;
            }
            function2.invoke(AuthV4Network.INSTANCE.toResultAPI$hive_service_release(it.getResponse()), arrayList);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit upload$lambda$2(Function2 function2, Upload it) {
            Intrinsics.checkNotNullParameter(it, "it");
            function2.invoke(AuthV4Network.INSTANCE.toResultAPI$hive_service_release(it.getResponse()), it);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit uploadFile$lambda$3(Function2 function2, UploadFile it) {
            Intrinsics.checkNotNullParameter(it, "it");
            function2.invoke(AuthV4Network.INSTANCE.toResultAPI$hive_service_release(it.getResponse()), it);
            return Unit.INSTANCE;
        }

        public final void getPlayer$hive_service_release(ArrayList<Long> playerIdList, final Function2<? super ResultAPI, ? super ArrayList<AuthV4.ProfileInfo>, Unit> callback) {
            Intrinsics.checkNotNullParameter(playerIdList, "playerIdList");
            Intrinsics.checkNotNullParameter(callback, "callback");
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol protocol = new Protocol(new Function0<GetPlayer>() { // from class: com.hive.authv4.AuthV4Network$ProfileApi$getPlayer$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.profileapi.GetPlayer] */
                @Override // kotlin.jvm.functions.Function0
                public final GetPlayer invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = GetPlayer.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            JSONArray jSONArray = new JSONArray();
            try {
                Iterator<Long> it = playerIdList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    Long next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    jSONArray.put(next.longValue());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                protocol.setParam(HiveKeys.KEY_appid, ConfigurationImpl.INSTANCE.getAppId());
                protocol.setParam(HiveKeys.KEY_country, Android.INSTANCE.getCountry());
                protocol.setParam(HiveKeys.KEY_player_id, jSONArray);
            } catch (Exception e2) {
                LoggerImpl.INSTANCE.w("[ProfileNetwork] getPlayer Exception: " + e2);
            }
            protocol.request(new Function1() { // from class: com.hive.authv4.AuthV4Network$ProfileApi$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthV4Network.ProfileApi.getPlayer$lambda$1(callback, (GetPlayer) obj);
                }
            });
        }

        public final void upload$hive_service_release(AuthV4.PlayerInfo playerInfo, String providerName, String profileImageUrl, String profileName, final Function2<? super ResultAPI, ? super Upload, Unit> callback) {
            Intrinsics.checkNotNullParameter(playerInfo, "playerInfo");
            Intrinsics.checkNotNullParameter(providerName, "providerName");
            Intrinsics.checkNotNullParameter(profileImageUrl, "profileImageUrl");
            Intrinsics.checkNotNullParameter(profileName, "profileName");
            Intrinsics.checkNotNullParameter(callback, "callback");
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol protocol = new Protocol(new Function0<Upload>() { // from class: com.hive.authv4.AuthV4Network$ProfileApi$upload$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.profileapi.Upload] */
                @Override // kotlin.jvm.functions.Function0
                public final Upload invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = Upload.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            String did = HiveLifecycle.INSTANCE.getDid();
            try {
                HiveKeys hiveKeys = HiveKeys.KEY_appid;
                ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
                protocol.setParam(hiveKeys, configurationImpl.getAppId());
                protocol.setParam(HiveKeys.KEY_did, did);
                protocol.setParam(HiveKeys.KEY_sdk_version, "4.26.2.0");
                HiveKeys hiveKeys2 = HiveKeys.KEY_os_version;
                Android android2 = Android.INSTANCE;
                protocol.setParam(hiveKeys2, android2.getOSVersion());
                protocol.setParam(HiveKeys.KEY_os_api_level, Integer.valueOf(android2.getOSVersionCode()));
                protocol.setParam(HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
                protocol.setParam(HiveKeys.KEY_device_model, android2.getDeviceModel());
                protocol.setParam(HiveKeys.KEY_country, android2.getCountry());
                protocol.setParam(HiveKeys.KEY_game_language, configurationImpl.getHiveLanguage());
                protocol.setParam(HiveKeys.KEY_player_id, Long.valueOf(playerInfo.getPlayerId()));
                protocol.setParam(HiveKeys.KEY_idp_id, providerName);
                protocol.setParam(HiveKeys.KEY_profile_img, "");
                protocol.setParam(HiveKeys.KEY_profile_name, "");
                protocol.setHeader(HiveKeys.KEY_Authorization, playerInfo.getPlayerToken());
                protocol.setOauthToken(AuthV4Account.INSTANCE);
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("[ProfileNetwork] upload Exception: " + e);
            }
            protocol.request(new Function1() { // from class: com.hive.authv4.AuthV4Network$ProfileApi$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthV4Network.ProfileApi.upload$lambda$2(callback, (Upload) obj);
                }
            });
        }

        public final void uploadFile$hive_service_release(AuthV4.PlayerInfo playerInfo, String providerName, byte[] profileImageData, String profileName, final Function2<? super ResultAPI, ? super UploadFile, Unit> callback) {
            Intrinsics.checkNotNullParameter(playerInfo, "playerInfo");
            Intrinsics.checkNotNullParameter(providerName, "providerName");
            Intrinsics.checkNotNullParameter(profileImageData, "profileImageData");
            Intrinsics.checkNotNullParameter(profileName, "profileName");
            Intrinsics.checkNotNullParameter(callback, "callback");
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol protocol = new Protocol(new Function0<UploadFile>() { // from class: com.hive.authv4.AuthV4Network$ProfileApi$uploadFile$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.profileapi.UploadFile] */
                @Override // kotlin.jvm.functions.Function0
                public final UploadFile invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = UploadFile.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            String did = HiveLifecycle.INSTANCE.getDid();
            String strEncodeToString = Base64.encodeToString(profileImageData, 4);
            try {
                HiveKeys hiveKeys = HiveKeys.KEY_appid;
                ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
                protocol.setParam(hiveKeys, configurationImpl.getAppId());
                protocol.setParam(HiveKeys.KEY_did, did);
                protocol.setParam(HiveKeys.KEY_sdk_version, "4.26.2.0");
                HiveKeys hiveKeys2 = HiveKeys.KEY_os_version;
                Android android2 = Android.INSTANCE;
                protocol.setParam(hiveKeys2, android2.getOSVersion());
                protocol.setParam(HiveKeys.KEY_os_api_level, Integer.valueOf(android2.getOSVersionCode()));
                protocol.setParam(HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
                protocol.setParam(HiveKeys.KEY_device_model, android2.getDeviceModel());
                protocol.setParam(HiveKeys.KEY_country, android2.getCountry());
                protocol.setParam(HiveKeys.KEY_game_language, configurationImpl.getHiveLanguage());
                protocol.setParam(HiveKeys.KEY_player_id, Long.valueOf(playerInfo.getPlayerId()));
                protocol.setParam(HiveKeys.KEY_idp_id, providerName);
                protocol.setParam(HiveKeys.KEY_image_data, strEncodeToString);
                protocol.setParam(HiveKeys.KEY_profile_name, "");
                protocol.setHeader(HiveKeys.KEY_Authorization, playerInfo.getPlayerToken());
                protocol.setOauthToken(AuthV4Account.INSTANCE);
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("[ProfileNetwork] uploadFile Exception: " + e);
            }
            protocol.request(new Function1() { // from class: com.hive.authv4.AuthV4Network$ProfileApi$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthV4Network.ProfileApi.uploadFile$lambda$3(callback, (UploadFile) obj);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¢\u0006\u0002\b\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b\f\u0010\rJ(\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u000fH\u0080@¢\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\n\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b\u0018\u0010\rJ(\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u000fH\u0080@¢\u0006\u0004\b\u001b\u0010\u0014J`\u0010\u001c\u001a\u00020\u001d2Q\u0010\u001e\u001aM\u0012\u0013\u0012\u00110\t¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110#¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u001c\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u001d0\u001fH\u0000¢\u0006\u0002\b%J(\u0010&\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u000fH\u0080@¢\u0006\u0004\b(\u0010\u0014J2\u0010)\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020*\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u000f2\b\b\u0002\u0010+\u001a\u00020,H\u0080@¢\u0006\u0004\b-\u0010.JH\u0010)\u001a\u00020\u001d2\b\b\u0002\u0010+\u001a\u00020,26\u0010\u001e\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(0\u0012\u0013\u0012\u00110*¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u001d0/J\u0015\u00102\u001a\u00020\t2\u0006\u00103\u001a\u000204H\u0000¢\u0006\u0002\b5¨\u00066"}, d2 = {"Lcom/hive/authv4/AuthV4Network$Provision;", "", "<init>", "()V", "addDownload", "Lcom/hive/protocol/Protocol;", "Lcom/hive/protocol/provision/AddDownload;", "addDownload$hive_service_release", "addSetInfo", "Lcom/hive/ResultAPI;", "playerInfo", "Lcom/hive/AuthV4$PlayerInfo;", "addSetInfo$hive_service_release", "(Lcom/hive/AuthV4$PlayerInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAgreement", "Lkotlin/Triple;", "Lcom/hive/protocol/provision/GetAgreement;", "Ljava/util/ArrayList;", "Lcom/hive/AuthV4$AuthV4MaintenanceInfo;", "getAgreement$hive_service_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "agreementDetermineBasePlayer", "Lkotlin/Pair;", "Lcom/hive/protocol/provision/AgreementDetermineBasePlayer;", "agreementDetermineBasePlayer$hive_service_release", "getBlockedCountry", "Lcom/hive/protocol/provision/GetBlockedCountry;", "getBlockedCountry$hive_service_release", "getMaintenance", "", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "resultApi", "Lcom/hive/protocol/provision/GetMaintenance;", "maintenanceInfoList", "getMaintenance$hive_service_release", "integration", "Lcom/hive/protocol/provision/Integration;", "integration$hive_service_release", "getMetadataInitInteraction", "Lcom/hive/protocol/provision/MetadataInitInteraction;", "forceReload", "", "getMetadataInitInteraction$hive_service_release", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "resultAPI", "metadataInitInteraction", "noticePopupSettleBill", "noticeType", "", "noticePopupSettleBill$hive_service_release", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Provision {
        public static final Provision INSTANCE = new Provision();

        private Provision() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit getMaintenance$lambda$4(Function3 function3, GetMaintenance it) {
            Intrinsics.checkNotNullParameter(it, "it");
            AuthV4Network authV4Network = AuthV4Network.INSTANCE;
            ResultAPI resultAPI$hive_service_release = authV4Network.toResultAPI$hive_service_release(it.getResponse());
            ArrayList<AuthV4.AuthV4MaintenanceInfo> arrayList = new ArrayList<>();
            if (resultAPI$hive_service_release.isSuccess()) {
                try {
                    JSONArray maintenanceInfoJSONArray = it.getResponse().getMaintenanceInfoJSONArray();
                    if (maintenanceInfoJSONArray != null) {
                        arrayList = authV4Network.getMaintenanceInfoList$hive_service_release(it.getResponse(), maintenanceInfoJSONArray);
                    }
                } catch (Exception e) {
                    String str = "ResponseProvisionMaintenance Exception: " + e + ", \n" + INSTANCE;
                    LoggerImpl.INSTANCE.w(str);
                    resultAPI$hive_service_release = new ResultAPI(-8, ResultAPI.Code.AuthV4InvalidResponseData, "invalid Maintenance data: " + str);
                }
            }
            function3.invoke(resultAPI$hive_service_release, it, arrayList);
            return Unit.INSTANCE;
        }

        public static /* synthetic */ void getMetadataInitInteraction$default(Provision provision, boolean z, Function2 function2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            provision.getMetadataInitInteraction(z, function2);
        }

        public static /* synthetic */ Object getMetadataInitInteraction$hive_service_release$default(Provision provision, boolean z, Continuation continuation, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return provision.getMetadataInitInteraction$hive_service_release(z, continuation);
        }

        public final Protocol<AddDownload> addDownload$hive_service_release() {
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol<AddDownload> protocol = new Protocol<>(new Function0<AddDownload>() { // from class: com.hive.authv4.AuthV4Network$Provision$addDownload$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.provision.AddDownload] */
                @Override // kotlin.jvm.functions.Function0
                public final AddDownload invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = AddDownload.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            String did = HiveLifecycle.INSTANCE.getDid();
            String referrer = AnalyticsReferrerSender.INSTANCE.getReferrer();
            try {
                HiveKeys hiveKeys = HiveKeys.KEY_appid;
                ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
                protocol.setParam(hiveKeys, configurationImpl.getAppId());
                protocol.setParam(HiveKeys.KEY_did, did);
                HiveKeys hiveKeys2 = HiveKeys.KEY_app_version;
                Android android2 = Android.INSTANCE;
                protocol.setParam(hiveKeys2, android2.getAppVersion());
                protocol.setParam(HiveKeys.KEY_app_version_display, android2.getAppVersion());
                protocol.setParam(HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
                protocol.setParam(HiveKeys.KEY_os_version, android2.getOSVersion());
                protocol.setParam(HiveKeys.KEY_os_api_level, Integer.valueOf(android2.getOSVersionCode()));
                protocol.setParam(HiveKeys.KEY_device_model, android2.getDeviceModel());
                protocol.setParam(HiveKeys.KEY_country, android2.getCountry());
                protocol.setParam(HiveKeys.KEY_language, android2.getLanguage());
                protocol.setParam(HiveKeys.KEY_game_language, configurationImpl.getHiveLanguage());
                protocol.setParam(HiveKeys.KEY_referrer, referrer);
                JSONObject jSONObject = new JSONObject();
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_hivev4, "4.26.2.0");
                HiveKeys hiveKeys3 = HiveKeys.KEY_interface_version;
                Configuration configuration = Configuration.INSTANCE;
                CommonIdentifierKt.put(jSONObject, hiveKeys3, configuration.getInterfaceVersion());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_build_time, configuration.getSdkBuildTime());
                CommonIdentifierKt.put(jSONObject, HiveKeys.KEY_track, configuration.getTrackVersion());
                ModuleChecker.INSTANCE.includeJsonDataHiveModuleVersionInfo(jSONObject);
                protocol.setParam(HiveKeys.KEY_module_version, jSONObject);
                protocol.setParam(HiveKeys.KEY_hive_certification_key, configurationImpl.getHiveCertificationKey());
                return protocol;
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("[AuthV4Network] addDownload Exception: " + e);
                return protocol;
            }
        }

        public final Object addSetInfo$hive_service_release(AuthV4.PlayerInfo playerInfo, Continuation<? super ResultAPI> continuation) {
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol protocol = new Protocol(new Function0<AddSetInfo>() { // from class: com.hive.authv4.AuthV4Network$Provision$addSetInfo$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.provision.AddSetInfo] */
                @Override // kotlin.jvm.functions.Function0
                public final AddSetInfo invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = AddSetInfo.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            String did = HiveLifecycle.INSTANCE.getDid();
            String value = Property.INSTANCE.getINSTANCE().getValue(AuthV4Keys.AGREEMENT_AGREED_DATA);
            Object jSONArray = null;
            if (value != null) {
                try {
                    if (!StringsKt.isBlank(value)) {
                        jSONArray = new JSONArray(value);
                    }
                } catch (Exception e) {
                    LoggerImpl.INSTANCE.w("agreed data parse exception: " + e);
                }
            }
            try {
                HiveKeys hiveKeys = HiveKeys.KEY_appid;
                ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
                protocol.setParam(hiveKeys, configurationImpl.getAppId());
                protocol.setParam(HiveKeys.KEY_did, did);
                protocol.setParam(HiveKeys.KEY_player_id, Boxing.boxLong(playerInfo.getPlayerId()));
                HiveKeys hiveKeys2 = HiveKeys.KEY_device;
                Object obj = JSONObject.NULL;
                protocol.setParam(hiveKeys2, obj);
                protocol.setParam(HiveKeys.KEY_download, obj);
                HiveKeys hiveKeys3 = HiveKeys.KEY_agreement;
                if (jSONArray == null) {
                    jSONArray = obj;
                }
                protocol.setParam(hiveKeys3, jSONArray);
                protocol.setParam(HiveKeys.KEY_hive_certification_key, configurationImpl.getHiveCertificationKey());
                protocol.setParam(HiveKeys.KEY_hive_theme, Configuration.INSTANCE.getHiveTheme().getLowerCaseValue());
            } catch (Exception e2) {
                LoggerImpl.INSTANCE.w("[AuthV4Network] addSetInfo Exception: " + e2);
            }
            return AuthV4Network.INSTANCE.toResultAPI$hive_service_release(((AddSetInfo) protocol.request()).getResponse());
        }

        public final Object agreementDetermineBasePlayer$hive_service_release(AuthV4.PlayerInfo playerInfo, Continuation<? super Pair<ResultAPI, AgreementDetermineBasePlayer>> continuation) {
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol protocol = new Protocol(new Function0<AgreementDetermineBasePlayer>() { // from class: com.hive.authv4.AuthV4Network$Provision$agreementDetermineBasePlayer$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.provision.AgreementDetermineBasePlayer] */
                @Override // kotlin.jvm.functions.Function0
                public final AgreementDetermineBasePlayer invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = AgreementDetermineBasePlayer.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            String did = HiveLifecycle.INSTANCE.getDid();
            String value = Property.INSTANCE.getINSTANCE().getValue(AuthV4Keys.AGREEMENT_AGREED_DATA);
            Object jSONArray = null;
            if (value != null) {
                try {
                    if (!StringsKt.isBlank(value)) {
                        jSONArray = new JSONArray(value);
                    }
                } catch (Exception e) {
                    LoggerImpl.INSTANCE.w("[AuthV4Network] agreementDetermineBasePlayer agreed data parse exception: " + e);
                }
            }
            try {
                HiveKeys hiveKeys = HiveKeys.KEY_appid;
                ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
                protocol.setParam(hiveKeys, configurationImpl.getAppId());
                protocol.setParam(HiveKeys.KEY_did, did);
                HiveKeys hiveKeys2 = HiveKeys.KEY_agreement;
                if (jSONArray == null) {
                    jSONArray = JSONObject.NULL;
                }
                protocol.setParam(hiveKeys2, jSONArray);
                protocol.setParam(HiveKeys.KEY_hive_certification_key, configurationImpl.getHiveCertificationKey());
                protocol.setParam(HiveKeys.KEY_hive_theme, Configuration.INSTANCE.getHiveTheme().getLowerCaseValue());
                protocol.setParam(HiveKeys.KEY_player_id, Boxing.boxLong(playerInfo.getPlayerId()));
                protocol.setHeader(HiveKeys.KEY_Authorization, playerInfo.getPlayerToken());
                protocol.setOauthToken(AuthV4Account.INSTANCE);
            } catch (Exception e2) {
                LoggerImpl.INSTANCE.w("[AuthV4Network] agreementDetermineBasePlayer Exception: " + e2);
            }
            AgreementDetermineBasePlayer agreementDetermineBasePlayer = (AgreementDetermineBasePlayer) protocol.request();
            return new Pair(AuthV4Network.INSTANCE.toResultAPI$hive_service_release(agreementDetermineBasePlayer.getResponse()), agreementDetermineBasePlayer);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0063  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object getAgreement$hive_service_release(kotlin.coroutines.Continuation<? super kotlin.Triple<com.hive.ResultAPI, com.hive.protocol.provision.GetAgreement, ? extends java.util.ArrayList<com.hive.AuthV4.AuthV4MaintenanceInfo>>> r7) {
            /*
                Method dump skipped, instruction units count: 292
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.AuthV4Network.Provision.getAgreement$hive_service_release(kotlin.coroutines.Continuation):java.lang.Object");
        }

        public final Object getBlockedCountry$hive_service_release(Continuation<? super Triple<ResultAPI, GetBlockedCountry, ? extends ArrayList<AuthV4.AuthV4MaintenanceInfo>>> continuation) {
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol protocol = new Protocol(new Function0<GetBlockedCountry>() { // from class: com.hive.authv4.AuthV4Network$Provision$getBlockedCountry$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.provision.GetBlockedCountry] */
                @Override // kotlin.jvm.functions.Function0
                public final GetBlockedCountry invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = GetBlockedCountry.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            long jCurrentTimeMillis = System.currentTimeMillis();
            int offset = TimeZone.getDefault().getOffset(System.currentTimeMillis());
            long j = jCurrentTimeMillis + ((long) offset);
            try {
                HiveKeys hiveKeys = HiveKeys.KEY_appid;
                ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
                protocol.setParam(hiveKeys, configurationImpl.getAppId());
                protocol.setParam(HiveKeys.KEY_timestamp, Boxing.boxLong(j / ((long) 1000)));
                protocol.setParam(HiveKeys.KEY_timezone_offset, Boxing.boxInt(offset / 1000));
                protocol.setParam(HiveKeys.KEY_hive_certification_key, configurationImpl.getHiveCertificationKey());
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("[AuthV4Network] getMaintenance Exception: " + e);
            }
            GetBlockedCountry getBlockedCountry = (GetBlockedCountry) protocol.request();
            AuthV4Network authV4Network = AuthV4Network.INSTANCE;
            ResultAPI resultAPI$hive_service_release = authV4Network.toResultAPI$hive_service_release(getBlockedCountry.getResponse());
            ArrayList<AuthV4.AuthV4MaintenanceInfo> arrayList = new ArrayList<>();
            if (resultAPI$hive_service_release.isSuccess()) {
                try {
                    JSONArray maintenanceInfoJSONArray = getBlockedCountry.getResponse().getMaintenanceInfoJSONArray();
                    if (maintenanceInfoJSONArray != null) {
                        arrayList = authV4Network.getMaintenanceInfoList$hive_service_release(getBlockedCountry.getResponse(), maintenanceInfoJSONArray);
                    }
                } catch (Exception e2) {
                    String str = "ResponseProvisionGetBlockedCountry Exception: " + e2 + ", \n" + getBlockedCountry.getResponse();
                    LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                    loggerImpl.wL(str);
                    loggerImpl.wR("ResponseProvisionGetBlockedCountry Exception: " + e2);
                    resultAPI$hive_service_release = new ResultAPI(-8, ResultAPI.Code.AuthV4InvalidResponseData, "invalid GetBlockedCountry data: " + str);
                }
            }
            return new Triple(resultAPI$hive_service_release, getBlockedCountry, arrayList);
        }

        public final void getMaintenance$hive_service_release(final Function3<? super ResultAPI, ? super GetMaintenance, ? super ArrayList<AuthV4.AuthV4MaintenanceInfo>, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol protocol = new Protocol(new Function0<GetMaintenance>() { // from class: com.hive.authv4.AuthV4Network$Provision$getMaintenance$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.provision.GetMaintenance] */
                @Override // kotlin.jvm.functions.Function0
                public final GetMaintenance invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = GetMaintenance.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            String did = HiveLifecycle.INSTANCE.getDid();
            long jCurrentTimeMillis = System.currentTimeMillis();
            int offset = TimeZone.getDefault().getOffset(System.currentTimeMillis());
            long j = jCurrentTimeMillis + ((long) offset);
            try {
                HiveKeys hiveKeys = HiveKeys.KEY_appid;
                ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
                protocol.setParam(hiveKeys, configurationImpl.getAppId());
                HiveKeys hiveKeys2 = HiveKeys.KEY_app_version;
                Android android2 = Android.INSTANCE;
                protocol.setParam(hiveKeys2, android2.getAppVersion());
                protocol.setParam(HiveKeys.KEY_app_version_display, android2.getAppVersion());
                protocol.setParam(HiveKeys.KEY_did, did);
                protocol.setParam(HiveKeys.KEY_server_id, configurationImpl.getServerId());
                protocol.setParam(HiveKeys.KEY_country, android2.getCountry());
                protocol.setParam(HiveKeys.KEY_language, android2.getLanguage());
                protocol.setParam(HiveKeys.KEY_game_language, configurationImpl.getHiveLanguage());
                protocol.setParam(HiveKeys.KEY_timestamp, Long.valueOf(j / ((long) 1000)));
                protocol.setParam(HiveKeys.KEY_timezone_offset, Integer.valueOf(offset / 1000));
                protocol.setParam(HiveKeys.KEY_hive_certification_key, configurationImpl.getHiveCertificationKey());
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("[AuthV4Network] getMaintenance Exception: " + e);
            }
            protocol.request(new Function1() { // from class: com.hive.authv4.AuthV4Network$Provision$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthV4Network.Provision.getMaintenance$lambda$4(callback, (GetMaintenance) obj);
                }
            });
        }

        public final void getMetadataInitInteraction(boolean forceReload, Function2<? super ResultAPI, ? super MetadataInitInteraction, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(AuthV4Network.ioDispatcher), null, null, new AuthV4Network$Provision$getMetadataInitInteraction$3(forceReload, callback, null), 3, null);
        }

        public final Object getMetadataInitInteraction$hive_service_release(boolean z, Continuation<? super Triple<ResultAPI, MetadataInitInteraction, ? extends ArrayList<AuthV4.AuthV4MaintenanceInfo>>> continuation) {
            Throwable th;
            ResultAPI resultAPI;
            Unit unit;
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol protocol = new Protocol(new Function0<MetadataInitInteraction>() { // from class: com.hive.authv4.AuthV4Network$Provision$getMetadataInitInteraction$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.provision.MetadataInitInteraction] */
                @Override // kotlin.jvm.functions.Function0
                public final MetadataInitInteraction invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = MetadataInitInteraction.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            long jCurrentTimeMillis = System.currentTimeMillis();
            int offset = TimeZone.getDefault().getOffset(System.currentTimeMillis());
            long j = jCurrentTimeMillis + ((long) offset);
            try {
                HiveKeys hiveKeys = HiveKeys.KEY_appid;
                ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
                protocol.setParam(hiveKeys, configurationImpl.getAppId());
                HiveKeys hiveKeys2 = HiveKeys.KEY_app_version;
                Android android2 = Android.INSTANCE;
                protocol.setParam(hiveKeys2, android2.getAppVersion());
                protocol.setParam(HiveKeys.KEY_app_version_display, android2.getAppVersion());
                protocol.setParam(HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
                protocol.setParam(HiveKeys.KEY_sdk_version, "4.26.2.0");
                protocol.setParam(HiveKeys.KEY_country, android2.getCountry());
                protocol.setParam(HiveKeys.KEY_device_country, android2.getCountry());
                protocol.setParam(HiveKeys.KEY_os_version, android2.getOSVersion());
                protocol.setParam(HiveKeys.KEY_timestamp, Boxing.boxLong(j / ((long) 1000)));
                protocol.setParam(HiveKeys.KEY_timezone_offset, Boxing.boxInt(offset / 1000));
                protocol.setParam(HiveKeys.KEY_hive_certification_key, configurationImpl.getHiveCertificationKey());
                protocol.setParam(HiveKeys.KEY_game_language, Configuration.INSTANCE.getGameLanguage());
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("[AuthV4Network] getMetadataInitInteraction Exception: " + e);
            }
            MetadataInitInteraction metadataInitInteraction = (MetadataInitInteraction) protocol.request();
            ResultAPI resultAPI$hive_service_release = AuthV4Network.INSTANCE.toResultAPI$hive_service_release(metadataInitInteraction.getResponse());
            ArrayList<AuthV4.AuthV4MaintenanceInfo> arrayList = new ArrayList<>();
            if (metadataInitInteraction.getResponse().getResult().getCode() == Result.Code.NotConnected && Configuration.INSTANCE.isOfflineMode() && !z) {
                try {
                    Result.Companion companion2 = kotlin.Result.INSTANCE;
                    String value = Property.INSTANCE.getINSTANCE().getValue(AuthV4Keys.OFFLINE_PROVISION_METADATA);
                    if (value != null) {
                        JSONObject jSONObject = new JSONObject(value);
                        LoggerImpl.INSTANCE.d("[AuthV4Network] getMetadataInitInteraction Activate Offline Mode.");
                        resultAPI = new ResultAPI();
                        try {
                            metadataInitInteraction.getResponse().setData(jSONObject);
                            unit = Unit.INSTANCE;
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion3 = kotlin.Result.INSTANCE;
                            kotlin.Result.m7415constructorimpl(ResultKt.createFailure(th));
                        }
                    } else {
                        unit = null;
                        resultAPI = resultAPI$hive_service_release;
                    }
                    kotlin.Result.m7415constructorimpl(unit);
                } catch (Throwable th3) {
                    th = th3;
                    resultAPI = resultAPI$hive_service_release;
                }
                resultAPI$hive_service_release = resultAPI;
            }
            if (resultAPI$hive_service_release.isSuccess()) {
                try {
                    JSONArray maintenanceInfoJSONArray = metadataInitInteraction.getResponse().getMaintenanceInfoJSONArray();
                    if (maintenanceInfoJSONArray != null) {
                        arrayList = AuthV4Network.INSTANCE.getMaintenanceInfoList$hive_service_release(metadataInitInteraction.getResponse(), maintenanceInfoJSONArray);
                    }
                    JSONObject dataJSONObject = metadataInitInteraction.getResponse().getDataJSONObject();
                    if (dataJSONObject != null) {
                        Property.Companion companion4 = Property.INSTANCE;
                        Property.setValue$default(companion4.getINSTANCE(), AuthV4Keys.OFFLINE_PROVISION_METADATA, dataJSONObject.toString(), null, 4, null);
                        companion4.getINSTANCE().writeProperties();
                        Configuration.INSTANCE.setMetaData(dataJSONObject);
                    }
                } catch (Exception e2) {
                    String str = "ResponseProvisionGetMetaData maintenance Exception: " + e2 + ", \n" + metadataInitInteraction.getResponse();
                    LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                    loggerImpl.wL(str);
                    loggerImpl.wR("ResponseProvisionGetMetaData maintenance Exception: " + e2);
                    resultAPI$hive_service_release = new ResultAPI(-8, ResultAPI.Code.AuthV4InvalidResponseData, "invalid GetMetaData data: " + str);
                }
            }
            return new Triple(resultAPI$hive_service_release, metadataInitInteraction, arrayList);
        }

        public final Object integration$hive_service_release(Continuation<? super Triple<ResultAPI, Integration, ? extends ArrayList<AuthV4.AuthV4MaintenanceInfo>>> continuation) {
            Object jSONArray;
            JSONObject jSONObject;
            ResultAPI resultAPI;
            Throwable th;
            String value;
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol protocol = new Protocol(new Function0<Integration>() { // from class: com.hive.authv4.AuthV4Network$Provision$integration$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.provision.Integration] */
                @Override // kotlin.jvm.functions.Function0
                public final Integration invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = Integration.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            String did = HiveLifecycle.INSTANCE.getDid();
            int offset = TimeZone.getDefault().getOffset(System.currentTimeMillis());
            int oSVersionCode = Android.INSTANCE.getOSVersionCode();
            Property.Companion companion2 = Property.INSTANCE;
            Unit unit = null;
            if (Boolean.valueOf(companion2.getINSTANCE().getValue(AuthV4Keys.AGREEMENT_IS_SENT_BEFORE_LOGIN, "false")).booleanValue() || (value = companion2.getINSTANCE().getValue(AuthV4Keys.AGREEMENT_AGREED_DATA)) == null) {
                jSONArray = null;
            } else {
                try {
                    if (!StringsKt.isBlank(value)) {
                        jSONArray = new JSONArray(value);
                    }
                } catch (Exception e) {
                    LoggerImpl.INSTANCE.w("agreed data parse exception: " + e);
                }
                jSONArray = null;
            }
            String referrer = AnalyticsReferrerSender.INSTANCE.getReferrer();
            JSONObject jSONObject2 = new JSONObject();
            AuthV4Verifier authV4Verifier = AuthV4Verifier.INSTANCE;
            if (authV4Verifier.checkDownload(false)) {
                try {
                    CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_referrer, referrer);
                    CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_is_hack, authV4Verifier.isRooting());
                    CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_emulator, authV4Verifier.getEmulator());
                    JSONObject jSONObject3 = new JSONObject();
                    CommonIdentifierKt.put(jSONObject3, HiveKeys.KEY_hivev4, "4.26.2.0");
                    HiveKeys hiveKeys = HiveKeys.KEY_interface_version;
                    Configuration configuration = Configuration.INSTANCE;
                    CommonIdentifierKt.put(jSONObject3, hiveKeys, configuration.getInterfaceVersion());
                    CommonIdentifierKt.put(jSONObject3, HiveKeys.KEY_build_time, configuration.getSdkBuildTime());
                    CommonIdentifierKt.put(jSONObject3, HiveKeys.KEY_track, configuration.getTrackVersion());
                    ModuleChecker.INSTANCE.includeJsonDataHiveModuleVersionInfo(jSONObject3);
                    CommonIdentifierKt.put(jSONObject2, HiveKeys.KEY_module_version, jSONObject3);
                    jSONObject = jSONObject2;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    Unit unit2 = Unit.INSTANCE;
                    jSONObject = null;
                }
            } else {
                jSONObject = null;
            }
            try {
                HiveKeys hiveKeys2 = HiveKeys.KEY_appid;
                ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
                protocol.setParam(hiveKeys2, configurationImpl.getAppId());
                protocol.setParam(HiveKeys.KEY_did, did);
                HiveKeys hiveKeys3 = HiveKeys.KEY_app_version;
                Android android2 = Android.INSTANCE;
                protocol.setParam(hiveKeys3, android2.getAppVersion());
                protocol.setParam(HiveKeys.KEY_app_version_display, android2.getAppVersion());
                protocol.setParam(HiveKeys.KEY_sdk_version, "4.26.2.0");
                protocol.setParam(HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
                protocol.setParam(HiveKeys.KEY_os_version, android2.getOSVersion());
                protocol.setParam(HiveKeys.KEY_os_api_level, oSVersionCode == 0 ? JSONObject.NULL : Boxing.boxInt(oSVersionCode));
                protocol.setParam(HiveKeys.KEY_device_model, android2.getDeviceModel());
                protocol.setParam(HiveKeys.KEY_advertising_id, android2.getAdvertisingId());
                protocol.setParam(HiveKeys.KEY_is_limit_ad_tracking, Boxing.boxBoolean(android2.isLimitAdTracking()));
                protocol.setParam(HiveKeys.KEY_android_id, android2.getAndroidId());
                protocol.setParam(HiveKeys.KEY_mdn, android2.getMobileDeviceNumber());
                protocol.setParam(HiveKeys.KEY_timezone_offset, Boxing.boxInt(offset / 1000));
                HiveKeys hiveKeys4 = HiveKeys.KEY_agreement;
                if (jSONArray == null) {
                    jSONArray = JSONObject.NULL;
                }
                protocol.setParam(hiveKeys4, jSONArray);
                HiveKeys hiveKeys5 = HiveKeys.KEY_download;
                Object obj = jSONObject;
                if (jSONObject == null) {
                    obj = JSONObject.NULL;
                }
                protocol.setParam(hiveKeys5, obj);
                protocol.setParam(HiveKeys.KEY_hive_certification_key, configurationImpl.getHiveCertificationKey());
                protocol.setParam(HiveKeys.KEY_hive_theme, Configuration.INSTANCE.getHiveTheme().getLowerCaseValue());
            } catch (Exception e3) {
                LoggerImpl.INSTANCE.w("[AuthV4Network] integration Exception: " + e3);
            }
            Integration integration = (Integration) protocol.request();
            ResultAPI resultAPI$hive_service_release = AuthV4Network.INSTANCE.toResultAPI$hive_service_release(integration.getResponse());
            ArrayList<AuthV4.AuthV4MaintenanceInfo> arrayList = new ArrayList<>();
            if (integration.getResponse().getResult().getCode() == Result.Code.NotConnected && Configuration.INSTANCE.isOfflineMode()) {
                try {
                    Result.Companion companion3 = kotlin.Result.INSTANCE;
                    String value2 = Property.INSTANCE.getINSTANCE().getValue(AuthV4Keys.OFFLINE_PROVISION_INTEGRATION_DATA);
                    if (value2 != null) {
                        JSONObject jSONObject4 = new JSONObject(value2);
                        LoggerImpl.INSTANCE.d("[AuthV4Network] integration Activate Offline Mode.");
                        resultAPI = new ResultAPI();
                        try {
                            integration.getResponse().setData(jSONObject4);
                            unit = Unit.INSTANCE;
                            resultAPI$hive_service_release = resultAPI;
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion4 = kotlin.Result.INSTANCE;
                            kotlin.Result.m7415constructorimpl(ResultKt.createFailure(th));
                            resultAPI$hive_service_release = resultAPI;
                        }
                    }
                    kotlin.Result.m7415constructorimpl(unit);
                } catch (Throwable th3) {
                    resultAPI = resultAPI$hive_service_release;
                    th = th3;
                }
            }
            if (resultAPI$hive_service_release.isSuccess()) {
                try {
                    JSONArray maintenanceInfoJSONArray = integration.getResponse().getMaintenanceInfoJSONArray();
                    if (maintenanceInfoJSONArray != null) {
                        arrayList = AuthV4Network.INSTANCE.getMaintenanceInfoList$hive_service_release(integration.getResponse(), maintenanceInfoJSONArray);
                    }
                    JSONObject dataJSONObject = integration.getResponse().getDataJSONObject();
                    if (dataJSONObject != null) {
                        Property.Companion companion5 = Property.INSTANCE;
                        Property.setValue$default(companion5.getINSTANCE(), AuthV4Keys.OFFLINE_PROVISION_INTEGRATION_DATA, dataJSONObject.toString(), null, 4, null);
                        Boxing.boxBoolean(companion5.getINSTANCE().writeProperties());
                    }
                } catch (Exception e4) {
                    String str = "[AuthV4Network] integration response Exception: " + e4 + ", \n" + integration.getResponse();
                    LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                    loggerImpl.wL(str);
                    loggerImpl.wR("[AuthV4Network] integration response Exception: " + e4);
                    resultAPI$hive_service_release = new ResultAPI(-8, ResultAPI.Code.AuthV4InvalidResponseData, "invalid integration data: " + str);
                }
            }
            return new Triple(resultAPI$hive_service_release, integration, arrayList);
        }

        public final ResultAPI noticePopupSettleBill$hive_service_release(int noticeType) {
            if (1 > noticeType || noticeType >= 5) {
                LoggerImpl.INSTANCE.d("[AuthV4Network] noticePopupSettleBill, out of range value(noticeType:" + noticeType);
                return new ResultAPI();
            }
            if (((Boolean) MapsKt.getValue(AuthV4Network.INSTANCE.getNoticePopupSettleBillReqResult(), Integer.valueOf(noticeType))).booleanValue()) {
                LoggerImpl.INSTANCE.d("[AuthV4Network] noticePopupSettleBill, already requested(noticeType:" + noticeType);
                return new ResultAPI();
            }
            Protocol.Companion companion = Protocol.INSTANCE;
            Protocol protocol = new Protocol(new Function0<NoticePopupSettleBill>() { // from class: com.hive.authv4.AuthV4Network$Provision$noticePopupSettleBill$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.provision.NoticePopupSettleBill] */
                @Override // kotlin.jvm.functions.Function0
                public final NoticePopupSettleBill invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = NoticePopupSettleBill.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            protocol.setRetryNetwork(false);
            AuthV4.PlayerInfo playerInfo = AuthV4Account.INSTANCE.readPlayerInfo();
            HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
            String did = hiveLifecycle.getDid();
            String did2 = (did == null || did.length() == 0) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : hiveLifecycle.getDid();
            long jCurrentTimeMillis = System.currentTimeMillis();
            int offset = TimeZone.getDefault().getOffset(System.currentTimeMillis());
            long j = jCurrentTimeMillis + ((long) offset);
            try {
                HiveKeys hiveKeys = HiveKeys.KEY_appid;
                ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
                protocol.setParam(hiveKeys, configurationImpl.getAppId());
                if (playerInfo == null) {
                    protocol.setParam(HiveKeys.KEY_player_id, (Object) 0);
                } else {
                    protocol.setParam(HiveKeys.KEY_player_id, Long.valueOf(playerInfo.getPlayerId()));
                }
                protocol.setParam(HiveKeys.KEY_did, did2);
                protocol.setParam(HiveKeys.KEY_hive_certification_key, configurationImpl.getHiveCertificationKey());
                protocol.setParam(HiveKeys.KEY_notice_type, Integer.valueOf(noticeType));
                protocol.setParam(HiveKeys.KEY_sdk_version, "4.26.2.0");
                HiveKeys hiveKeys2 = HiveKeys.KEY_interface_version;
                Configuration configuration = Configuration.INSTANCE;
                protocol.setParam(hiveKeys2, configuration.getInterfaceVersion());
                HiveKeys hiveKeys3 = HiveKeys.KEY_app_version;
                Android android2 = Android.INSTANCE;
                protocol.setParam(hiveKeys3, android2.getAppVersion());
                protocol.setParam(HiveKeys.KEY_app_version_display, android2.getAppVersion());
                protocol.setParam(HiveKeys.KEY_server_id, configurationImpl.getServerId());
                protocol.setParam(HiveKeys.KEY_hive_country, configurationImpl.getHiveCountry());
                protocol.setParam(HiveKeys.KEY_game_language, configurationImpl.getHiveLanguage());
                protocol.setParam(HiveKeys.KEY_timestamp, Long.valueOf(j / ((long) 1000)));
                protocol.setParam(HiveKeys.KEY_timezone_offset, Integer.valueOf(offset / 1000));
                protocol.setParam(HiveKeys.KEY_analytics_id, configuration.getAnalyticsId());
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("[AuthV4Network] noticePopupSettleBill Exception: " + e);
            }
            AuthV4Network authV4Network = AuthV4Network.INSTANCE;
            ResultAPI resultAPI$hive_service_release = authV4Network.toResultAPI$hive_service_release(((NoticePopupSettleBill) protocol.request()).getResponse());
            if (resultAPI$hive_service_release.isSuccess()) {
                authV4Network.getNoticePopupSettleBillReqResult().put(Integer.valueOf(noticeType), Boolean.TRUE);
                LoggerImpl.INSTANCE.d("[AuthV4Network] noticePopupSettleBill, noticeType(" + noticeType + ") set true");
            }
            return resultAPI$hive_service_release;
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        noticePopupSettleBillReqResult = MapsKt.mutableMapOf(TuplesKt.to(1, bool), TuplesKt.to(2, bool), TuplesKt.to(3, bool), TuplesKt.to(4, bool));
        ioDispatcher = Dispatchers.getIO();
    }

    private AuthV4Network() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit blacklist$lambda$0(Function3 function3, Blacklist it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AuthV4Network authV4Network = INSTANCE;
        function3.invoke(authV4Network.toResultAPI$hive_service_release(it.getResponse()), it, authV4Network.getBlacklistData$hive_service_release(it.getResponse()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, com.hive.AuthV4$PlayerInfo, com.hive.AuthV4$ProfileInfo] */
    public static final Unit customAuthConnect$lambda$3(Function4 function4, CustomAuthConnect it) {
        String string;
        JSONObject data;
        Intrinsics.checkNotNullParameter(it, "it");
        ResultAPI resultAPI$hive_service_release = INSTANCE.toResultAPI$hive_service_release(it.getResponse());
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String str = null;
        if (resultAPI$hive_service_release.getCode() == ResultAPI.Code.AuthV4ConflictPlayer) {
            try {
                data = it.getResponse().getData();
            } catch (Exception e) {
                e = e;
                string = null;
            }
            if (data != null) {
                ?? playerInfo = new AuthV4.PlayerInfo();
                string = data.getString("custom_auth_key");
                try {
                    playerInfo.setPlayerId(data.getLong("player_id"));
                    String string2 = data.getString("idp_user_id");
                    String string3 = data.getString("idp_id");
                    AuthV4.ProviderType.Companion companion = AuthV4.ProviderType.INSTANCE;
                    Intrinsics.checkNotNull(string3);
                    AuthV4.ProviderType providerType = companion.getProviderType(string3);
                    if (providerType != null) {
                        HashMap<AuthV4.ProviderType, AuthV4.ProviderInfo> providerInfoData = playerInfo.getProviderInfoData();
                        Intrinsics.checkNotNull(string2);
                        providerInfoData.put(providerType, new AuthV4.ProviderInfo(providerType, string2));
                    } else if (!StringsKt.isBlank(string3)) {
                        HashMap<String, AuthV4.ProviderInfo> customProviderInfoData = playerInfo.getCustomProviderInfoData();
                        Intrinsics.checkNotNull(string2);
                        customProviderInfoData.put(string3, new AuthV4.ProviderInfo(string3, string2));
                    }
                    objectRef.element = playerInfo;
                } catch (Exception e2) {
                    e = e2;
                    String str2 = "ResponseCustomAuthConnect Exception: " + e + '\n' + it;
                    LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                    loggerImpl.w(str2);
                    loggerImpl.wR("ResponseCustomAuthConnect Exception: " + e);
                    objectRef.element = null;
                    resultAPI$hive_service_release = new ResultAPI(-8, ResultAPI.Code.AuthV4ConflictPlayerHandlingFail, "invalid CONFLICT_PLAYER data: " + str2);
                }
                str = string;
            }
        }
        function4.invoke(resultAPI$hive_service_release, it, objectRef.element, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit disconnect$lambda$4(Function2 function2, Disconnect it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI$hive_service_release(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getAuthIdp$lambda$14(Function5 function5, AuthIdp it) {
        AuthV4.PlayerInfo playerInfo;
        String str;
        String str2;
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(it, "it");
        ResultAPI resultAPI$hive_service_release = INSTANCE.toResultAPI$hive_service_release(it.getResponse());
        long j = 0;
        String str3 = "";
        if (it.getResponse().getResult().isSuccess() && it.getResponse().isSuccess() && it.getResponse().getContentJSONObject().has("data")) {
            AuthV4.PlayerInfo playerInfo2 = new AuthV4.PlayerInfo();
            try {
                LoggerImpl.INSTANCE.i("[AuthV4Network] getAuthIdp, response - set playerId userId idpId");
                JSONObject data = it.getResponse().getData();
                if (data != null) {
                    j = data.getLong(HiveKeys.KEY_player_id.getValue());
                    string2 = data.getString(HiveKeys.KEY_idp_user_id.getValue());
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    try {
                        string = data.getString(HiveKeys.KEY_idp_id.getValue());
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    } catch (Exception e) {
                        e = e;
                        LoggerImpl.INSTANCE.w("[AuthV4Network] getAuthIdp response Exception: " + e);
                        playerInfo = playerInfo2;
                        str = string2;
                        str2 = str3;
                    }
                } else {
                    string = "";
                    string2 = string;
                }
            } catch (Exception e2) {
                e = e2;
                string = "";
            }
            try {
                playerInfo2.setPlayerId(j);
                String str4 = it.getResponse().getHeader().get(HttpHeaders.AUTHORIZATION);
                if (str4 == null) {
                    throw new Exception("player token is empty");
                }
                playerInfo2.setPlayerToken(str4);
                String did = HiveLifecycle.INSTANCE.getDid();
                if (did != null) {
                    str3 = did;
                }
                playerInfo2.setDid(str3);
                AuthV4.ProviderType providerType = AuthV4.ProviderType.INSTANCE.getProviderType(string);
                if (providerType != null) {
                    playerInfo2.getProviderInfoData().put(providerType, new AuthV4.ProviderInfo(providerType, string2));
                } else {
                    playerInfo2.getCustomProviderInfoData().put(string, new AuthV4.ProviderInfo(string, string2));
                }
                playerInfo = playerInfo2;
                String str5 = string2;
                str2 = string;
                str = str5;
            } catch (Exception e3) {
                e = e3;
                str3 = string2;
                string2 = str3;
                str3 = string;
                LoggerImpl.INSTANCE.w("[AuthV4Network] getAuthIdp response Exception: " + e);
                playerInfo = playerInfo2;
                str = string2;
                str2 = str3;
            }
        } else {
            playerInfo = null;
            str = "";
            str2 = str;
        }
        function5.invoke(resultAPI$hive_service_release, Long.valueOf(j), str, str2, playerInfo);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getAuthIdpToken$lambda$12(Function3 function3, AuthIdpToken it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ResultAPI resultAPI$hive_service_release = INSTANCE.toResultAPI$hive_service_release(it.getResponse());
        String idpUserId = it.getResponse().getIdpUserId();
        if (idpUserId == null) {
            idpUserId = "";
        }
        String idpToken = it.getResponse().getIdpToken();
        String str = idpToken != null ? idpToken : "";
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.dL("[AuthV4Network] getAuthIdpToken : " + resultAPI$hive_service_release + "\n    " + idpUserId);
        StringBuilder sb = new StringBuilder("[AuthV4Network] getAuthIdpToken : ");
        sb.append(resultAPI$hive_service_release);
        loggerImpl.dR(sb.toString());
        function3.invoke(resultAPI$hive_service_release, idpUserId, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getIdpUid$lambda$6(Function3 function3, GetIdpUid it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ResultAPI resultAPI$hive_service_release = INSTANCE.toResultAPI$hive_service_release(it.getResponse());
        HashMap map = new HashMap();
        try {
            if (resultAPI$hive_service_release.isSuccess()) {
                try {
                    LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                    loggerImpl.d("ResponseProviderFriendsList  Enter isSuccess");
                    JSONArray data = it.getResponse().getData();
                    if (data != null) {
                        int length = data.length();
                        for (int i = 0; i < length; i++) {
                            try {
                                JSONObject jSONObject = data.getJSONObject(i);
                                LoggerImpl.INSTANCE.dL(AuthV4.getTAG(), "Put Before Map<String, Long> UID-PID . : " + jSONObject);
                                map.put(jSONObject.getString("idp_user_id"), Long.valueOf(jSONObject.getLong("player_id")));
                            } catch (Exception e) {
                                LoggerImpl loggerImpl2 = LoggerImpl.INSTANCE;
                                loggerImpl2.wL(AuthV4.getTAG(), "Fail?? Put Map<String, Long> UID-PID . : " + data);
                                loggerImpl2.w(AuthV4.getTAG(), "agreed data parse exception: " + e);
                            }
                        }
                    } else {
                        loggerImpl.w("ResponseProviderFriendsList  data NULL ......");
                    }
                } catch (Exception e2) {
                    String str = "ResponseProviderFriendsList Exception: " + e2 + '\n' + it.getResponse();
                    LoggerImpl loggerImpl3 = LoggerImpl.INSTANCE;
                    loggerImpl3.wL(str);
                    loggerImpl3.wR(null, "ResponseProviderFriendsList Exception: " + e2);
                    resultAPI$hive_service_release = new ResultAPI(-8, ResultAPI.Code.AuthV4InvalidResponseData, "invalid ProviderFriendsList data: " + str);
                    loggerImpl3.d(AuthV4.getTAG(), "mapIdpFromProviderUid finally Result ::::: " + map);
                }
            }
            function3.invoke(resultAPI$hive_service_release, it, map);
            return Unit.INSTANCE;
        } finally {
            LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "mapIdpFromProviderUid finally Result ::::: " + map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPolicy$lambda$7(Function2 function2, GetPolicy it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI$hive_service_release(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    private final void isGamerId(String idpId, String idpUserId, String authKey, final Function4<? super ResultAPI, ? super Boolean, ? super String, ? super String, Unit> callback) {
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<IsGamerId>() { // from class: com.hive.authv4.AuthV4Network$isGamerId$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.IsGamerId] */
            @Override // kotlin.jvm.functions.Function0
            public final IsGamerId invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = IsGamerId.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            HiveKeys hiveKeys = HiveKeys.KEY_appid;
            ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
            protocol.setParam(hiveKeys, configurationImpl.getAppId());
            protocol.setParam(HiveKeys.KEY_hive_country, configurationImpl.getHiveCountry());
            if (idpId != null && (!StringsKt.isBlank(idpId))) {
                protocol.setParam(HiveKeys.KEY_idp_id, idpId);
            }
            if (idpUserId != null && (!StringsKt.isBlank(idpUserId))) {
                protocol.setParam(HiveKeys.KEY_idp_user_id, idpUserId);
            }
            if (authKey != null && (!StringsKt.isBlank(authKey))) {
                protocol.setParam(HiveKeys.KEY_custom_auth_key, authKey);
            }
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("[AuthV4Network] isGamerId Exception: " + e);
        }
        protocol.request(new Function1() { // from class: com.hive.authv4.AuthV4Network$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AuthV4Network.isGamerId$lambda$11(callback, (IsGamerId) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit isGamerId$lambda$11(Function4 function4, IsGamerId it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ResultAPI resultAPI$hive_service_release = INSTANCE.toResultAPI$hive_service_release(it.getResponse());
        boolean z = false;
        if (it.getResponse().getResult().isSuccess() && it.getResponse().isSuccess()) {
            if (StringsKt.isBlank(it.getResponse().getSignature()) || StringsKt.isBlank(it.getResponse().getUrl())) {
                resultAPI$hive_service_release = new ResultAPI(-8, ResultAPI.Code.AuthV4InvalidResponseData);
            } else {
                z = true;
            }
        }
        function4.invoke(resultAPI$hive_service_release, Boolean.valueOf(z), it.getResponse().getSignature(), it.getResponse().getUrl());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit playerDelete$lambda$17(Function2 function2, PlayerDelete it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI$hive_service_release(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit selectIdp$lambda$9(Function3 function3, AuthV4.PlayerInfo playerInfo, SelectIdp it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function3.invoke(INSTANCE.toResultAPI$hive_service_release(it.getResponse()), it, playerInfo);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit signOut$lambda$10(Function2 function2, SignOut it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI$hive_service_release(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    private final ResultAPI toResultAPI(com.hive.core.Result coreResult, int resultCode, String resultMsg) {
        ResultAPI.Code code;
        if (coreResult.isFailure()) {
            return new ResultAPI(-5, ResultAPI.Code.AuthV4NetworkError, coreResult.getMessage());
        }
        String str = resultMsg + '(' + resultCode + ')';
        int i = -1;
        switch (resultCode / 1000) {
            case 0:
                if (resultCode != 0) {
                    code = ResultAPI.Code.AuthV4ServerResponseError;
                    i = -8;
                } else {
                    code = ResultAPI.Code.Success;
                    i = 0;
                }
                break;
            case 1:
                if (resultCode == 1002) {
                    code = ResultAPI.Code.AuthV4ConflictPlayer;
                    i = -11;
                } else if (resultCode == 1006) {
                    code = ResultAPI.Code.AuthV4SignOutNotAllowGuestLogout;
                    i = -8;
                } else {
                    code = ResultAPI.Code.AuthV4AlreadyAuthorized;
                    i = 20;
                }
                break;
            case 2:
                if (resultCode == 2004) {
                    code = ResultAPI.Code.Success;
                } else if (resultCode == 2100) {
                    code = ResultAPI.Code.RealNameVerification;
                } else if (resultCode != 2300) {
                    switch (resultCode) {
                        case ResultAPI.PeppermintErrCode.HUB_E_PGS_SIGNIN_FAIL /* 2400 */:
                            code = ResultAPI.Code.AuthV4InvalidParam;
                            i = -13;
                            break;
                        case ResultAPI.PeppermintErrCode.HUB_E_PGS_SERVICE_NOT_AVAILABLE /* 2401 */:
                            code = ResultAPI.Code.AuthV4InvalidParam;
                            break;
                        case ResultAPI.PeppermintErrCode.HUB_E_PGS_ALREADY_EXIST_SESSION /* 2402 */:
                            code = ResultAPI.Code.AuthV4InvalidParam;
                            break;
                        case ResultAPI.PeppermintErrCode.HUB_E_PGS_INVALID_JSON /* 2403 */:
                            code = ResultAPI.Code.AuthV4InvalidParam;
                            i = -13;
                            break;
                        case ResultAPI.PeppermintErrCode.HUB_E_PGS_CANNOT_FOUND_CLIENT_ID /* 2404 */:
                            code = ResultAPI.Code.AuthV4InvalidParam;
                            break;
                        case 2405:
                            code = ResultAPI.Code.AuthV4InvalidParam;
                            break;
                        default:
                            code = ResultAPI.Code.AuthV4UserInBlacklist;
                            i = -12;
                            break;
                    }
                } else {
                    code = ResultAPI.Code.RefundUser;
                }
                i = 0;
                break;
            case 3:
            case 5:
            default:
                code = ResultAPI.Code.AuthV4ServerResponseError;
                i = -8;
                break;
            case 4:
                if (resultCode != 4002) {
                    code = ResultAPI.Code.AuthV4ServerResponseError;
                    i = -8;
                } else {
                    code = ResultAPI.Code.AuthV4InvalidCertification;
                }
                break;
            case 6:
                code = resultCode == 6003 ? ResultAPI.Code.AuthV4ServiceShutdown : ResultAPI.Code.AuthV4ServerResponseError;
                i = -8;
                break;
            case 7:
                code = ResultAPI.Code.AuthV4InvalidSession;
                i = -9;
                break;
            case 8:
                if (resultCode != 8005) {
                    code = ResultAPI.Code.AuthV4ServerResponseError;
                    i = -8;
                } else {
                    code = ResultAPI.Code.Success;
                    i = 0;
                }
                break;
            case 9:
                if (resultCode != 9001) {
                    code = ResultAPI.Code.AuthV4ServerResponseError;
                    i = -8;
                } else {
                    code = ResultAPI.Code.Success;
                    i = 0;
                }
                break;
        }
        return new ResultAPI(i, code, str);
    }

    public final void blacklist$hive_service_release(AuthV4.PlayerInfo playerInfo, final Function3<? super ResultAPI, ? super Blacklist, ? super AuthV4.AuthV4MaintenanceInfo, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<Blacklist>() { // from class: com.hive.authv4.AuthV4Network$blacklist$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.Blacklist] */
            @Override // kotlin.jvm.functions.Function0
            public final Blacklist invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = Blacklist.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        String did = HiveLifecycle.INSTANCE.getDid();
        try {
            HiveKeys hiveKeys = HiveKeys.KEY_appid;
            ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
            protocol.setParam(hiveKeys, configurationImpl.getAppId());
            protocol.setParam(HiveKeys.KEY_did, did);
            protocol.setParam(HiveKeys.KEY_sdk_version, "4.26.2.0");
            HiveKeys hiveKeys2 = HiveKeys.KEY_os_version;
            Android android2 = Android.INSTANCE;
            protocol.setParam(hiveKeys2, android2.getOSVersion());
            protocol.setParam(HiveKeys.KEY_os_api_level, Integer.valueOf(android2.getOSVersionCode()));
            protocol.setParam(HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
            protocol.setParam(HiveKeys.KEY_device_model, android2.getDeviceModel());
            protocol.setParam(HiveKeys.KEY_country, android2.getCountry());
            protocol.setParam(HiveKeys.KEY_game_language, configurationImpl.getHiveLanguage());
            if (playerInfo != null) {
                protocol.setParam(HiveKeys.KEY_player_id, Long.valueOf(playerInfo.getPlayerId()));
                protocol.setHeader(HiveKeys.KEY_Authorization, playerInfo.getPlayerToken());
                protocol.setOauthToken(AuthV4Account.INSTANCE);
            }
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("[AuthV4Network] blacklist Exception: " + e);
        }
        protocol.request(new Function1() { // from class: com.hive.authv4.AuthV4Network$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AuthV4Network.blacklist$lambda$0(callback, (Blacklist) obj);
            }
        });
    }

    public final void connect$hive_service_release(AuthV4.PlayerInfo playerInfo, AuthV4ProviderAdapter provider, Function3<? super ResultAPI, ? super Connect, ? super AuthV4.PlayerInfo, Unit> callback) {
        Intrinsics.checkNotNullParameter(playerInfo, "playerInfo");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(ioDispatcher), null, null, new AuthV4Network$connect$1(provider, playerInfo, callback, null), 3, null);
    }

    public final void customAuthConnect$hive_service_release(AuthV4.PlayerInfo playerInfo, String authKey, final Function4<? super ResultAPI, ? super CustomAuthConnect, ? super AuthV4.PlayerInfo, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(playerInfo, "playerInfo");
        Intrinsics.checkNotNullParameter(authKey, "authKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<CustomAuthConnect>() { // from class: com.hive.authv4.AuthV4Network$customAuthConnect$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.CustomAuthConnect] */
            @Override // kotlin.jvm.functions.Function0
            public final CustomAuthConnect invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = CustomAuthConnect.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        String did = HiveLifecycle.INSTANCE.getDid();
        try {
            HiveKeys hiveKeys = HiveKeys.KEY_appid;
            ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
            protocol.setParam(hiveKeys, configurationImpl.getAppId());
            protocol.setParam(HiveKeys.KEY_did, did);
            protocol.setParam(HiveKeys.KEY_sdk_version, "4.26.2.0");
            HiveKeys hiveKeys2 = HiveKeys.KEY_os_version;
            Android android2 = Android.INSTANCE;
            protocol.setParam(hiveKeys2, android2.getOSVersion());
            protocol.setParam(HiveKeys.KEY_os_api_level, Integer.valueOf(android2.getOSVersionCode()));
            protocol.setParam(HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
            protocol.setParam(HiveKeys.KEY_device_model, android2.getDeviceModel());
            protocol.setParam(HiveKeys.KEY_hive_country, configurationImpl.getHiveCountry());
            protocol.setParam(HiveKeys.KEY_game_language, configurationImpl.getHiveLanguage());
            protocol.setParam(HiveKeys.KEY_player_id, Long.valueOf(playerInfo.getPlayerId()));
            protocol.setParam(HiveKeys.KEY_custom_auth_key, authKey);
            protocol.setHeader(HiveKeys.KEY_Authorization, playerInfo.getPlayerToken());
            protocol.setOauthToken(AuthV4Account.INSTANCE);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("[AuthV4Network] customAuthConnect Exception: " + e);
        }
        protocol.request(new Function1() { // from class: com.hive.authv4.AuthV4Network$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AuthV4Network.customAuthConnect$lambda$3(callback, (CustomAuthConnect) obj);
            }
        });
    }

    public final void customAuthSignInIdp$hive_service_release(String authKey, String player, Function5<? super ResultAPI, ? super CustomAuthSignInIdp, ? super AuthV4.PlayerInfo, ? super String, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(authKey, "authKey");
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(ioDispatcher), null, null, new AuthV4Network$customAuthSignInIdp$1(authKey, player, callback, null), 3, null);
    }

    public final void disconnect$hive_service_release(AuthV4.PlayerInfo playerInfo, AuthV4.ProviderInfo providerInfo, final Function2<? super ResultAPI, ? super Disconnect, Unit> callback) {
        Intrinsics.checkNotNullParameter(playerInfo, "playerInfo");
        Intrinsics.checkNotNullParameter(providerInfo, "providerInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<Disconnect>() { // from class: com.hive.authv4.AuthV4Network$disconnect$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.Disconnect] */
            @Override // kotlin.jvm.functions.Function0
            public final Disconnect invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = Disconnect.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        String did = HiveLifecycle.INSTANCE.getDid();
        try {
            HiveKeys hiveKeys = HiveKeys.KEY_appid;
            ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
            protocol.setParam(hiveKeys, configurationImpl.getAppId());
            protocol.setParam(HiveKeys.KEY_did, did);
            protocol.setParam(HiveKeys.KEY_sdk_version, "4.26.2.0");
            HiveKeys hiveKeys2 = HiveKeys.KEY_os_version;
            Android android2 = Android.INSTANCE;
            protocol.setParam(hiveKeys2, android2.getOSVersion());
            protocol.setParam(HiveKeys.KEY_os_api_level, Integer.valueOf(android2.getOSVersionCode()));
            protocol.setParam(HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
            protocol.setParam(HiveKeys.KEY_device_model, android2.getDeviceModel());
            protocol.setParam(HiveKeys.KEY_country, android2.getCountry());
            protocol.setParam(HiveKeys.KEY_game_language, configurationImpl.getHiveLanguage());
            protocol.setParam(HiveKeys.KEY_idp_id, providerInfo.getProviderName());
            protocol.setParam(HiveKeys.KEY_idp_user_id, providerInfo.getProviderUserId());
            protocol.setParam(HiveKeys.KEY_player_id, Long.valueOf(playerInfo.getPlayerId()));
            protocol.setParam(HiveKeys.KEY_idp_appid, providerInfo.getProviderAppId());
            protocol.setHeader(HiveKeys.KEY_Authorization, playerInfo.getPlayerToken());
            protocol.setOauthToken(AuthV4Account.INSTANCE);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("[AuthV4Network] disconnect Exception: " + e);
        }
        protocol.request(new Function1() { // from class: com.hive.authv4.AuthV4Network$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AuthV4Network.disconnect$lambda$4(callback, (Disconnect) obj);
            }
        });
    }

    public final void getAuthIdp$hive_service_release(AuthV4.ProviderType idpType, String userId, String token, String player, final Function5<? super ResultAPI, ? super Long, ? super String, ? super String, ? super AuthV4.PlayerInfo, Unit> callback) {
        Intrinsics.checkNotNullParameter(idpType, "idpType");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<AuthIdp>() { // from class: com.hive.authv4.AuthV4Network$getAuthIdp$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.AuthIdp] */
            @Override // kotlin.jvm.functions.Function0
            public final AuthIdp invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = AuthIdp.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            HiveKeys hiveKeys = HiveKeys.KEY_appid;
            ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
            protocol.setParam(hiveKeys, configurationImpl.getAppId());
            protocol.setParam(HiveKeys.KEY_did, HiveLifecycle.INSTANCE.getDid());
            protocol.setParam(HiveKeys.KEY_sdk_version, Configuration.INSTANCE.getSdkVersion());
            HiveKeys hiveKeys2 = HiveKeys.KEY_os_version;
            Android android2 = Android.INSTANCE;
            protocol.setParam(hiveKeys2, android2.getOSVersion());
            protocol.setParam(HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
            protocol.setParam(HiveKeys.KEY_country, android2.getCountry());
            protocol.setParam(HiveKeys.KEY_gameLanguage, configurationImpl.getHiveLanguage());
            protocol.setParam(HiveKeys.KEY_idp_user_id, userId);
            protocol.setParam(HiveKeys.KEY_idp_id, AuthV4.ProviderType.SIGNIN_APPLE.getValue());
            protocol.setParam(HiveKeys.KEY_idp_token, token);
            protocol.setParam(HiveKeys.KEY_player, player);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("[AuthV4Network] getAuthIdp Exception: " + e);
        }
        protocol.request(new Function1() { // from class: com.hive.authv4.AuthV4Network$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AuthV4Network.getAuthIdp$lambda$14(callback, (AuthIdp) obj);
            }
        });
    }

    public final void getAuthIdpToken(AuthV4.ProviderType idpType, String code, String redirectUri, final Function3<? super ResultAPI, ? super String, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(idpType, "idpType");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<AuthIdpToken>() { // from class: com.hive.authv4.AuthV4Network$getAuthIdpToken$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.AuthIdpToken] */
            @Override // kotlin.jvm.functions.Function0
            public final AuthIdpToken invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = AuthIdpToken.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            HiveKeys hiveKeys = HiveKeys.KEY_appid;
            ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
            protocol.setParam(hiveKeys, configurationImpl.getAppId());
            protocol.setParam(HiveKeys.KEY_did, HiveLifecycle.INSTANCE.getDid());
            protocol.setParam(HiveKeys.KEY_sdk_version, Configuration.INSTANCE.getSdkVersion());
            HiveKeys hiveKeys2 = HiveKeys.KEY_os_version;
            Android android2 = Android.INSTANCE;
            protocol.setParam(hiveKeys2, android2.getOSVersion());
            protocol.setParam(HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
            protocol.setParam(HiveKeys.KEY_country, android2.getCountry());
            protocol.setParam(HiveKeys.KEY_gameLanguage, configurationImpl.getHiveLanguage());
            protocol.setParam(HiveKeys.KEY_idp_code, code);
            protocol.setParam(HiveKeys.KEY_idp_id, idpType.getValue());
            protocol.setParam(HiveKeys.KEY_redirect_uri, redirectUri);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("[AuthV4Network] getAuthIdpToken Exception: " + e);
        }
        protocol.request(new Function1() { // from class: com.hive.authv4.AuthV4Network$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AuthV4Network.getAuthIdpToken$lambda$12(callback, (AuthIdpToken) obj);
            }
        });
    }

    public final AuthV4.AuthV4MaintenanceInfo getBlacklistData$hive_service_release(AuthV4.AuthV4Response authV4Response) {
        Intrinsics.checkNotNullParameter(authV4Response, "<this>");
        if (!authV4Response.setBlacklistData()) {
            return null;
        }
        String blockTitle = authV4Response.getBlockTitle();
        String blockMsg = authV4Response.getBlockMsg();
        String blockButton = authV4Response.getBlockButton();
        AuthV4.AuthV4MaintenanceActionType authV4MaintenanceActionTypeFindValue = AuthV4.AuthV4MaintenanceActionType.INSTANCE.findValue(authV4Response.getBlockAction());
        if (authV4MaintenanceActionTypeFindValue == null) {
            authV4MaintenanceActionTypeFindValue = AuthV4.AuthV4MaintenanceActionType.EXIT;
        }
        return new AuthV4.AuthV4MaintenanceInfo(blockTitle, blockMsg, blockButton, authV4MaintenanceActionTypeFindValue, authV4Response.getBlockUrl(), authV4Response.getRemainingTime(), "", "", authV4Response.getBlockCustomerButton(), authV4Response.getBlockCustomerLink());
    }

    public final JSONObject getGamerIdWebViewPostData$hive_service_release(String idpUserId, String signature) throws JSONException {
        Intrinsics.checkNotNullParameter(idpUserId, "idpUserId");
        Intrinsics.checkNotNullParameter(signature, "signature");
        JSONObject jSONObjectPutCI = CommonIdentifierKt.putCI(new JSONObject());
        String did = HiveLifecycle.INSTANCE.getDid();
        HiveKeys hiveKeys = HiveKeys.KEY_appid;
        ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
        CommonIdentifierKt.put(jSONObjectPutCI, hiveKeys, configurationImpl.getAppId());
        CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_did, did);
        CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_sdk_version, "4.26.2.0");
        HiveKeys hiveKeys2 = HiveKeys.KEY_os_version;
        Android android2 = Android.INSTANCE;
        CommonIdentifierKt.put(jSONObjectPutCI, hiveKeys2, android2.getOSVersion());
        CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_os, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_device_model, android2.getDeviceModel());
        CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_hive_country, configurationImpl.getHiveCountry());
        CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_game_language, configurationImpl.getHiveLanguage());
        if (!StringsKt.isBlank(idpUserId)) {
            CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_idp_user_id, idpUserId);
        }
        CommonIdentifierKt.put(jSONObjectPutCI, HiveKeys.KEY_signature, signature);
        return jSONObjectPutCI;
    }

    public final void getIdpUid$hive_service_release(AuthV4.PlayerInfo playerInfo, AuthV4.ProviderType providerType, String providerUserIds, final Function3<? super ResultAPI, ? super GetIdpUid, ? super HashMap<String, Long>, Unit> callback) {
        Intrinsics.checkNotNullParameter(playerInfo, "playerInfo");
        Intrinsics.checkNotNullParameter(providerType, "providerType");
        Intrinsics.checkNotNullParameter(providerUserIds, "providerUserIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<GetIdpUid>() { // from class: com.hive.authv4.AuthV4Network$getIdpUid$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.GetIdpUid] */
            @Override // kotlin.jvm.functions.Function0
            public final GetIdpUid invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = GetIdpUid.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        String did = HiveLifecycle.INSTANCE.getDid();
        try {
            HiveKeys hiveKeys = HiveKeys.KEY_appid;
            ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
            protocol.setParam(hiveKeys, configurationImpl.getAppId());
            protocol.setParam(HiveKeys.KEY_did, did);
            protocol.setParam(HiveKeys.KEY_sdk_version, "4.26.2.0");
            HiveKeys hiveKeys2 = HiveKeys.KEY_os_version;
            Android android2 = Android.INSTANCE;
            protocol.setParam(hiveKeys2, android2.getOSVersion());
            protocol.setParam(HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
            protocol.setParam(HiveKeys.KEY_device_model, android2.getDeviceModel());
            protocol.setParam(HiveKeys.KEY_country, android2.getCountry());
            protocol.setParam(HiveKeys.KEY_game_language, configurationImpl.getHiveLanguage());
            protocol.setParam(HiveKeys.KEY_player_id, Long.valueOf(playerInfo.getPlayerId()));
            protocol.setParam(HiveKeys.KEY_idp_id, providerType.getValue());
            protocol.setParam(HiveKeys.KEY_idp_user_id, providerUserIds);
            protocol.setHeader(HiveKeys.KEY_Authorization, playerInfo.getPlayerToken());
            protocol.setOauthToken(AuthV4Account.INSTANCE);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("[AuthV4Network] getIdpUid Exception: " + e);
        }
        protocol.request(new Function1() { // from class: com.hive.authv4.AuthV4Network$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AuthV4Network.getIdpUid$lambda$6(callback, (GetIdpUid) obj);
            }
        });
    }

    public final ArrayList<AuthV4.AuthV4MaintenanceInfo> getMaintenanceInfoList$hive_service_release(Provision.ProvisionResponse provisionResponse, JSONArray jSONArray) {
        String str;
        String str2;
        String str3;
        int i;
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArray2;
        String str4;
        JSONArray maintenanceInfoJSONArray = jSONArray;
        String str5 = "button_list";
        String str6 = "url";
        String str7 = "optString(...)";
        Intrinsics.checkNotNullParameter(provisionResponse, "<this>");
        Intrinsics.checkNotNullParameter(maintenanceInfoJSONArray, "maintenanceInfoJSONArray");
        ArrayList<AuthV4.AuthV4MaintenanceInfo> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        int i2 = 0;
        while (i2 < length) {
            JSONObject jSONObjectOptJSONObject = maintenanceInfoJSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null) {
                try {
                    int iOptInt = jSONObjectOptJSONObject.optInt("type");
                    String strOptString = jSONObjectOptJSONObject.optString("title");
                    Intrinsics.checkNotNullExpressionValue(strOptString, str7);
                    String strOptString2 = jSONObjectOptJSONObject.optString("message");
                    Intrinsics.checkNotNullExpressionValue(strOptString2, str7);
                    String strOptString3 = jSONObjectOptJSONObject.optString("button");
                    Intrinsics.checkNotNullExpressionValue(strOptString3, str7);
                    AuthV4.AuthV4MaintenanceActionType authV4MaintenanceActionTypeFindValue = AuthV4.AuthV4MaintenanceActionType.INSTANCE.findValue(jSONObjectOptJSONObject.optInt(NativeProtocol.WEB_DIALOG_ACTION));
                    if (authV4MaintenanceActionTypeFindValue == null) {
                        authV4MaintenanceActionTypeFindValue = AuthV4.AuthV4MaintenanceActionType.DONE;
                    }
                    AuthV4.AuthV4MaintenanceActionType authV4MaintenanceActionType = authV4MaintenanceActionTypeFindValue;
                    String strOptString4 = jSONObjectOptJSONObject.optString(str6);
                    Intrinsics.checkNotNullExpressionValue(strOptString4, str7);
                    int iOptInt2 = jSONObjectOptJSONObject.optInt("remaining_time");
                    String strOptString5 = jSONObjectOptJSONObject.optString("start_date");
                    Intrinsics.checkNotNullExpressionValue(strOptString5, str7);
                    String strOptString6 = jSONObjectOptJSONObject.optString("end_date");
                    Intrinsics.checkNotNullExpressionValue(strOptString6, str7);
                    if (jSONObjectOptJSONObject.isNull(str5) || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(str5)) == null) {
                        str = str5;
                        str2 = str6;
                        str3 = str7;
                    } else {
                        str = str5;
                        try {
                            str3 = str7;
                            if (jSONArrayOptJSONArray.length() >= 1) {
                                try {
                                    ArrayList arrayList2 = new ArrayList();
                                    int length2 = jSONArrayOptJSONArray.length();
                                    i = length;
                                    int i3 = 0;
                                    while (i3 < length2) {
                                        int i4 = length2;
                                        try {
                                            JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i3);
                                            if (jSONObject != null) {
                                                jSONArray2 = jSONArrayOptJSONArray;
                                                str4 = strOptString5;
                                                AuthV4.AuthV4MaintenanceActionType authV4MaintenanceActionTypeFindValue2 = AuthV4.AuthV4MaintenanceActionType.INSTANCE.findValue(jSONObject.optInt(NativeProtocol.WEB_DIALOG_ACTION));
                                                if (authV4MaintenanceActionTypeFindValue2 == null) {
                                                    authV4MaintenanceActionTypeFindValue2 = AuthV4.AuthV4MaintenanceActionType.DONE;
                                                }
                                                String strOptString7 = jSONObject.optString(str6);
                                                String strOptString8 = jSONObject.optString("button");
                                                str2 = str6;
                                                try {
                                                    Intrinsics.checkNotNull(strOptString7);
                                                    Intrinsics.checkNotNull(strOptString8);
                                                    arrayList2.add(new AuthV4.AuthV4MaintenanceExtraButton(authV4MaintenanceActionTypeFindValue2, strOptString7, strOptString8));
                                                } catch (Exception e) {
                                                    e = e;
                                                    LoggerImpl.INSTANCE.w("ResponseProvisionMaintenance data exception: " + e);
                                                    i2++;
                                                    maintenanceInfoJSONArray = jSONArray;
                                                    str5 = str;
                                                    str7 = str3;
                                                    length = i;
                                                    str6 = str2;
                                                }
                                            } else {
                                                jSONArray2 = jSONArrayOptJSONArray;
                                                str2 = str6;
                                                str4 = strOptString5;
                                            }
                                            i3++;
                                            length2 = i4;
                                            jSONArrayOptJSONArray = jSONArray2;
                                            strOptString5 = str4;
                                            str6 = str2;
                                        } catch (Exception e2) {
                                            e = e2;
                                            str2 = str6;
                                        }
                                    }
                                    str2 = str6;
                                    arrayList.add(new AuthV4.AuthV4MaintenanceInfo(iOptInt, strOptString, strOptString2, strOptString3, authV4MaintenanceActionType, strOptString4, iOptInt2, strOptString5, strOptString6, arrayList2));
                                } catch (Exception e3) {
                                    e = e3;
                                    str2 = str6;
                                    i = length;
                                    LoggerImpl.INSTANCE.w("ResponseProvisionMaintenance data exception: " + e);
                                    i2++;
                                    maintenanceInfoJSONArray = jSONArray;
                                    str5 = str;
                                    str7 = str3;
                                    length = i;
                                    str6 = str2;
                                }
                            } else {
                                str2 = str6;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            str2 = str6;
                            str3 = str7;
                            i = length;
                            LoggerImpl.INSTANCE.w("ResponseProvisionMaintenance data exception: " + e);
                            i2++;
                            maintenanceInfoJSONArray = jSONArray;
                            str5 = str;
                            str7 = str3;
                            length = i;
                            str6 = str2;
                        }
                    }
                    i = length;
                    arrayList.add(new AuthV4.AuthV4MaintenanceInfo(iOptInt, strOptString, strOptString2, strOptString3, authV4MaintenanceActionType, strOptString4, iOptInt2, strOptString5, strOptString6));
                } catch (Exception e5) {
                    e = e5;
                    str = str5;
                }
            } else {
                str = str5;
                str2 = str6;
                str3 = str7;
                i = length;
            }
            i2++;
            maintenanceInfoJSONArray = jSONArray;
            str5 = str;
            str7 = str3;
            length = i;
            str6 = str2;
        }
        return arrayList;
    }

    public final Map<Integer, Boolean> getNoticePopupSettleBillReqResult() {
        return noticePopupSettleBillReqResult;
    }

    public final void getPolicy$hive_service_release(AuthV4.PlayerInfo playerInfo, String policyType, final Function2<? super ResultAPI, ? super GetPolicy, Unit> callback) {
        Intrinsics.checkNotNullParameter(playerInfo, "playerInfo");
        Intrinsics.checkNotNullParameter(policyType, "policyType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<GetPolicy>() { // from class: com.hive.authv4.AuthV4Network$getPolicy$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.GetPolicy] */
            @Override // kotlin.jvm.functions.Function0
            public final GetPolicy invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = GetPolicy.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            protocol.setParam(HiveKeys.KEY_appid, ConfigurationImpl.INSTANCE.getAppId());
            protocol.setParam(HiveKeys.KEY_player_id, Long.valueOf(playerInfo.getPlayerId()));
            protocol.setParam(HiveKeys.KEY_policy_type, policyType);
            protocol.setHeader(HiveKeys.KEY_Authorization, playerInfo.getPlayerToken());
            protocol.setOauthToken(AuthV4Account.INSTANCE);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("[AuthV4Network] getPolicy Exception: " + e);
        }
        protocol.request(new Function1() { // from class: com.hive.authv4.AuthV4Network$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AuthV4Network.getPolicy$lambda$7(callback, (GetPolicy) obj);
            }
        });
    }

    public final Object idp$hive_service_release(Continuation<? super Triple<ResultAPI, Idp, ? extends ArrayList<AuthV4.ProviderType>>> continuation) {
        JSONArray data;
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<Idp>() { // from class: com.hive.authv4.AuthV4Network$idp$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.Idp] */
            @Override // kotlin.jvm.functions.Function0
            public final Idp invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = Idp.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        String did = HiveLifecycle.INSTANCE.getDid();
        String value = Property.INSTANCE.getINSTANCE().getValue(AuthV4Keys.AGREEMENT_AGREED_DATA);
        Object jSONArray = null;
        if (value != null) {
            try {
                if (!StringsKt.isBlank(value)) {
                    jSONArray = new JSONArray(value);
                }
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(com.hive.AuthV4.getTAG(), "agreed data parse exception: " + e);
            }
        }
        try {
            HiveKeys hiveKeys = HiveKeys.KEY_appid;
            ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
            protocol.setParam(hiveKeys, configurationImpl.getAppId());
            protocol.setParam(HiveKeys.KEY_did, did);
            protocol.setParam(HiveKeys.KEY_sdk_version, "4.26.2.0");
            HiveKeys hiveKeys2 = HiveKeys.KEY_os_version;
            Android android2 = Android.INSTANCE;
            protocol.setParam(hiveKeys2, android2.getOSVersion());
            protocol.setParam(HiveKeys.KEY_os_api_level, Boxing.boxInt(android2.getOSVersionCode()));
            protocol.setParam(HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
            protocol.setParam(HiveKeys.KEY_device_model, android2.getDeviceModel());
            protocol.setParam(HiveKeys.KEY_country, android2.getCountry());
            protocol.setParam(HiveKeys.KEY_game_language, configurationImpl.getHiveLanguage());
            HiveKeys hiveKeys3 = HiveKeys.KEY_agreement;
            if (jSONArray == null) {
                jSONArray = JSONObject.NULL;
            }
            protocol.setParam(hiveKeys3, jSONArray);
        } catch (Exception e2) {
            LoggerImpl.INSTANCE.w("[AuthV4Network] idp Exception: " + e2);
        }
        Idp idp = (Idp) protocol.request();
        ArrayList arrayList = new ArrayList();
        if (idp.getResponse().isSuccess() && (data = idp.getResponse().getData()) != null) {
            int length = data.length();
            for (int i = 0; i < length; i++) {
                try {
                    String string = data.getJSONObject(i).getString("idp_id");
                    AuthV4.ProviderType.Companion companion2 = AuthV4.ProviderType.INSTANCE;
                    Intrinsics.checkNotNull(string);
                    AuthV4.ProviderType providerType = companion2.getProviderType(string);
                    if (providerType != null) {
                        arrayList.add(providerType);
                    }
                } catch (Exception unused) {
                    LoggerImpl.INSTANCE.w("invalid provider info. : " + data);
                }
            }
        }
        return new Triple(toResultAPI$hive_service_release(idp.getResponse()), idp, arrayList);
    }

    public final void isGamerId$hive_service_release(AuthV4ProviderAdapter provider, Function4<? super ResultAPI, ? super Boolean, ? super String, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(callback, "callback");
        isGamerId(provider.getIdpType().getValue(), provider.getUserId(), null, callback);
    }

    public final Object oauthToken$hive_service_release(String str, String str2, Continuation<? super OauthToken.OauthTokenResponse> continuation) {
        String did = HiveLifecycle.INSTANCE.getDid();
        String primaryClientId = Configuration.INSTANCE.getPrimaryClientId();
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<OauthToken>() { // from class: com.hive.authv4.AuthV4Network$oauthToken$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.OauthToken] */
            @Override // kotlin.jvm.functions.Function0
            public final OauthToken invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = OauthToken.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        protocol.setAutoRefreshOauthToken(false);
        protocol.setParam(HiveKeys.KEY_appid, ConfigurationImpl.INSTANCE.getAppId());
        protocol.setParam(HiveKeys.KEY_grant_type, "authorization_code");
        protocol.setParam(HiveKeys.KEY_idp_code, str);
        protocol.setParam(HiveKeys.KEY_code_verifier, str2);
        protocol.setParam(HiveKeys.KEY_did, did);
        protocol.setParam(HiveKeys.KEY_client_id, primaryClientId);
        return ((OauthToken) protocol.request()).getResponse();
    }

    public final void playerDelete$hive_service_release(AuthV4.PlayerInfo playerInfo, final Function2<? super ResultAPI, ? super PlayerDelete, Unit> callback) {
        Intrinsics.checkNotNullParameter(playerInfo, "playerInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<PlayerDelete>() { // from class: com.hive.authv4.AuthV4Network$playerDelete$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.PlayerDelete] */
            @Override // kotlin.jvm.functions.Function0
            public final PlayerDelete invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = PlayerDelete.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        protocol.setParam(HiveKeys.KEY_appid, Configuration.INSTANCE.getAppId());
        protocol.setParam(HiveKeys.KEY_did, HiveLifecycle.INSTANCE.getDid());
        protocol.setParam(HiveKeys.KEY_player_id, Long.valueOf(playerInfo.getPlayerId()));
        protocol.setHeader(HiveKeys.KEY_Authorization, playerInfo.getPlayerToken());
        protocol.setOauthToken(AuthV4Account.INSTANCE);
        protocol.request(new Function1() { // from class: com.hive.authv4.AuthV4Network$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AuthV4Network.playerDelete$lambda$17(callback, (PlayerDelete) obj);
            }
        });
    }

    public final void selectIdp$hive_service_release(final AuthV4.PlayerInfo playerInfo, AuthV4.PlayerInfo conflictPlayer, AuthV4.ProviderInfo providerInfo, final Function3<? super ResultAPI, ? super SelectIdp, ? super AuthV4.PlayerInfo, Unit> callback) {
        Intrinsics.checkNotNullParameter(playerInfo, "playerInfo");
        Intrinsics.checkNotNullParameter(conflictPlayer, "conflictPlayer");
        Intrinsics.checkNotNullParameter(providerInfo, "providerInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<SelectIdp>() { // from class: com.hive.authv4.AuthV4Network$selectIdp$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.SelectIdp] */
            @Override // kotlin.jvm.functions.Function0
            public final SelectIdp invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = SelectIdp.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        String did = HiveLifecycle.INSTANCE.getDid();
        try {
            HiveKeys hiveKeys = HiveKeys.KEY_appid;
            ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
            protocol.setParam(hiveKeys, configurationImpl.getAppId());
            protocol.setParam(HiveKeys.KEY_did, did);
            protocol.setParam(HiveKeys.KEY_sdk_version, "4.26.2.0");
            HiveKeys hiveKeys2 = HiveKeys.KEY_os_version;
            Android android2 = Android.INSTANCE;
            protocol.setParam(hiveKeys2, android2.getOSVersion());
            protocol.setParam(HiveKeys.KEY_os_api_level, Integer.valueOf(android2.getOSVersionCode()));
            protocol.setParam(HiveKeys.KEY_os, Platform.INSTANCE.getPlatform());
            protocol.setParam(HiveKeys.KEY_device_model, android2.getDeviceModel());
            protocol.setParam(HiveKeys.KEY_country, android2.getCountry());
            protocol.setParam(HiveKeys.KEY_game_language, configurationImpl.getHiveLanguage());
            HiveKeys hiveKeys3 = HiveKeys.KEY_idp_id;
            protocol.setParam(hiveKeys3, providerInfo.getProviderName());
            HiveKeys hiveKeys4 = HiveKeys.KEY_idp_user_id;
            protocol.setParam(hiveKeys4, providerInfo.getProviderUserId());
            HiveKeys hiveKeys5 = HiveKeys.KEY_player_id;
            protocol.setParam(hiveKeys5, Long.valueOf(playerInfo.getPlayerId()));
            JSONObject jSONObject = new JSONObject();
            CommonIdentifierKt.put(jSONObject, hiveKeys5, Long.valueOf(conflictPlayer.getPlayerId()));
            CommonIdentifierKt.put(jSONObject, hiveKeys3, providerInfo.getProviderName());
            CommonIdentifierKt.put(jSONObject, hiveKeys4, providerInfo.getProviderUserId());
            protocol.setParam(HiveKeys.KEY_player, jSONObject);
            protocol.setHeader(HiveKeys.KEY_Authorization, playerInfo.getPlayerToken());
            protocol.setOauthToken(AuthV4Account.INSTANCE);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("[AuthV4Network] selectIdp Exception: " + e);
        }
        protocol.request(new Function1() { // from class: com.hive.authv4.AuthV4Network$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AuthV4Network.selectIdp$lambda$9(callback, playerInfo, (SelectIdp) obj);
            }
        });
    }

    public final void showBlacklistDialog$hive_service_release(AuthV4.AuthV4Response authV4Response, final ResultAPI resultApi, final AuthV4.AuthV4MaintenanceListener listener) {
        Intrinsics.checkNotNullParameter(authV4Response, "<this>");
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final AuthV4.AuthV4MaintenanceInfo blacklistData$hive_service_release = getBlacklistData$hive_service_release(authV4Response);
        if (blacklistData$hive_service_release == null) {
            listener.onAuthV4Maintenance(new ResultAPI(), null);
        } else {
            final MaintenanceDialog.MaintenanceModel maintenanceModel = AuthV4Impl.INSTANCE.getMaintenanceModel(blacklistData$hive_service_release, authV4Response.getBlockHtmlMsg(), MaintenanceDialog.MaintenanceDialogType.BLACKLIST);
            HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new OnActivityLifecycle() { // from class: com.hive.authv4.AuthV4Network$showBlacklistDialog$1
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
                    final AuthV4.AuthV4MaintenanceInfo authV4MaintenanceInfo = blacklistData$hive_service_release;
                    final AuthV4.AuthV4MaintenanceListener authV4MaintenanceListener = listener;
                    final ResultAPI resultAPI = resultApi;
                    setDialog(new MaintenanceDialog(activity, maintenanceModel2, new MaintenanceDialog.OnDismissListener() { // from class: com.hive.authv4.AuthV4Network$showBlacklistDialog$1$onCreate$1

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
                            activity.finish();
                            ArrayList<AuthV4.AuthV4MaintenanceInfo> arrayList = new ArrayList<>();
                            arrayList.add(authV4MaintenanceInfo);
                            authV4MaintenanceListener.onAuthV4Maintenance(resultAPI, arrayList);
                        }

                        @Override // com.hive.auth.MaintenanceDialog.OnDismissListener
                        public void onDismissWithButtonAction(DialogInterface dialog, MaintenanceDialog.MaintenanceActionType buttonAction) {
                            Intrinsics.checkNotNullParameter(dialog, "dialog");
                            Intrinsics.checkNotNullParameter(buttonAction, "buttonAction");
                            activity.finish();
                            int i = WhenMappings.$EnumSwitchMapping$0[buttonAction.ordinal()];
                            authV4MaintenanceListener.onAuthV4Maintenance(i != 1 ? i != 2 ? i != 3 ? i != 4 ? new ResultAPI(-17, ResultAPI.Code.AuthUserInBlacklistActionDefault_DoExit, "") : new ResultAPI(0, ResultAPI.Code.AuthUserInBlacklistActionDone, "") : new ResultAPI(-17, ResultAPI.Code.AuthUserInBlacklistActionExit_DoExit, "") : new ResultAPI(-17, ResultAPI.Code.AuthUserInBlacklistActionOpenURL_DoExit, "") : new ResultAPI(-17, ResultAPI.Code.AuthUserInBlacklistTimeover_DoExit, ""), null);
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
        }
    }

    public final void signIn$hive_service_release(String recaptchaToken, Function4<? super ResultAPI, ? super SignIn, ? super AuthV4.PlayerInfo, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(ioDispatcher), null, null, new AuthV4Network$signIn$1(recaptchaToken, callback, null), 3, null);
    }

    public final void signInIdp$hive_service_release(AuthV4ProviderAdapter provider, String player, Function4<? super ResultAPI, ? super SignInIdp, ? super AuthV4.PlayerInfo, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(ioDispatcher), null, null, new AuthV4Network$signInIdp$1(provider, player, callback, null), 3, null);
    }

    public final void signInPlayer$hive_service_release(AuthV4.PlayerInfo playerInfo, Function4<? super ResultAPI, ? super SignInPlayer, ? super AuthV4.PlayerInfo, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(playerInfo, "playerInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AuthV4Network$signInPlayer$1(playerInfo, callback, null), 3, null);
    }

    public final void signOut$hive_service_release(AuthV4.PlayerInfo playerInfo, final Function2<? super ResultAPI, ? super SignOut, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<SignOut>() { // from class: com.hive.authv4.AuthV4Network$signOut$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.SignOut] */
            @Override // kotlin.jvm.functions.Function0
            public final SignOut invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = SignOut.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        String did = HiveLifecycle.INSTANCE.getDid();
        if (playerInfo == null) {
            LoggerImpl.INSTANCE.d("[AuthV4Network] signOut, playerInfo is null");
            callback.invoke(new ResultAPI(-9, ResultAPI.Code.AuthV4InvalidSession, "playerInfo is null"), null);
            return;
        }
        if (playerInfo.getPlayerToken().length() == 0) {
            LoggerImpl.INSTANCE.d("[AuthV4Network] signOut, playerToken is empty");
            callback.invoke(new ResultAPI(-9, ResultAPI.Code.AuthV4InvalidSession, "playerToken is empty"), null);
            return;
        }
        try {
            protocol.setParam(HiveKeys.KEY_appid, ConfigurationImpl.INSTANCE.getAppId());
            protocol.setParam(HiveKeys.KEY_did, did);
            protocol.setParam(HiveKeys.KEY_player_id, Long.valueOf(playerInfo.getPlayerId()));
            protocol.setHeader(HiveKeys.KEY_Authorization, playerInfo.getPlayerToken());
            protocol.setOauthToken(AuthV4Account.INSTANCE);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("[AuthV4Network] signOut Exception: " + e);
        }
        protocol.request(new Function1() { // from class: com.hive.authv4.AuthV4Network$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AuthV4Network.signOut$lambda$10(callback, (SignOut) obj);
            }
        });
    }

    public final ResultAPI toResultAPI$hive_service_release(AuthV4.AuthV4Response authV4Response) {
        Intrinsics.checkNotNullParameter(authV4Response, "<this>");
        return toResultAPI(authV4Response.getResult(), authV4Response.getResultCode(), authV4Response.getResultMsg());
    }

    public final void isGamerId$hive_service_release(String authKey, Function4<? super ResultAPI, ? super Boolean, ? super String, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(authKey, "authKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        isGamerId(null, null, authKey, callback);
    }

    public final ResultAPI toResultAPI$hive_service_release(Provision.ProvisionResponse provisionResponse) {
        Intrinsics.checkNotNullParameter(provisionResponse, "<this>");
        return toResultAPI(provisionResponse.getResult(), provisionResponse.getResultCode(), provisionResponse.getResultMsg());
    }

    public final ResultAPI toResultAPI$hive_service_release(ProfileApi.ProfileApiResponse profileApiResponse) {
        Intrinsics.checkNotNullParameter(profileApiResponse, "<this>");
        return toResultAPI(profileApiResponse.getResult(), profileApiResponse.getResultCode(), profileApiResponse.getResultMsg());
    }

    public final ResultAPI toResultAPI$hive_service_release(Membership.MembershipResponse membershipResponse) {
        Intrinsics.checkNotNullParameter(membershipResponse, "<this>");
        return toResultAPI(membershipResponse.getResult(), membershipResponse.getResultCode(), membershipResponse.getResultMsg());
    }
}
