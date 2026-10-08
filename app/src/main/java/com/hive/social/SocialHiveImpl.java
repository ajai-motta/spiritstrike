package com.hive.social;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.adxcorp.util.ADXLogUtil;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.SocialHive;
import com.hive.auth.AuthImpl;
import com.hive.auth.AuthNetwork;
import com.hive.auth.AuthSocialView;
import com.hive.base.Property;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.Crypto;
import com.hive.core.OauthToken;
import com.hive.logger.LoggerImpl;
import com.hive.module.interfaces.HiveSocial;
import com.hive.protocol.UrlManager;
import com.hive.protocol.logincenter.GetUid;
import com.hive.protocol.logincenter.GetVid;
import com.hive.protocol.socialapi.AcaLoginPlayGamesService;
import com.hive.protocol.socialapi.AcaLoginPlayGamesServiceSet;
import com.hive.protocol.socialapi.AcaUserQuitRequest;
import com.hive.protocol.socialapi.DeviceRegistered;
import com.hive.protocol.socialapi.GuestGenerate;
import com.hive.protocol.socialapi.GuestKey;
import com.hive.protocol.socialapi.GuestLogin;
import com.hive.protocol.socialapi.GuestStatusSaveData;
import com.hive.protocol.socialapi.ProfileGetUser;
import com.hive.protocol.socialapi.SocialConnect;
import com.hive.protocol.socialapi.UndefinedRequest;
import com.hive.protocol.socialapi.UserEx;
import com.hive.protocol.socialapi.UserMe;
import com.hive.protocol.socialapi.UserMeEx;
import com.hive.protocol.socialapi.UserMeNotification;
import com.hive.protocol.socialapi.UserModify;
import com.hive.protocol.socialapi.Users;
import com.hive.protocol.socialapi.UsersInfo;
import com.hive.protocol.socialapi.WallWrite;
import com.hive.protocol.socialfriendapi.FriendsFacebookRequest;
import com.hive.protocol.socialfriendapi.FriendsReceiveList;
import com.hive.protocol.socialfriendapi.FriendsRejectRequest;
import com.hive.protocol.socialfriendapi.FriendsRequest;
import com.hive.protocol.socialfriendapi.MessageNotiCount;
import com.hive.protocol.socialfriendapi.MessageWrite;
import com.hive.protocol.socialotherapi.SaveDataDelete;
import com.hive.protocol.socialotherapi.SaveDataDownload;
import com.hive.protocol.socialotherapi.SaveDataUpload;
import com.hive.protocol.socialotherapi.UploadImage;
import com.hive.social.SocialDialog;
import com.hive.social.SocialKeys;
import com.hive.socialv4.provider.SocialV4ProviderAdapter;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.io.files.FileSystemKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0096\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u0007J\b\u0010\u0013\u001a\u00020\u000fH\u0007J\u0006\u0010\u0014\u001a\u00020\u000fJ\u0006\u0010\u0015\u001a\u00020\u0005J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\u001bJ\u001a\u0010\u001e\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0016\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u001bJ\"\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0016\u0010$\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u001bJ\"\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010&\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u001a\u001a\u00020'J%\u0010(\u001a\u00020\u000f2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010*2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010+J\u000e\u0010,\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020'J\u000e\u0010-\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020'J#\u0010.\u001a\u00020\u00072\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010*2\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u00100J%\u00101\u001a\u00020\u00072\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010*2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002¢\u0006\u0002\u00100J\u000e\u00103\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bJ\"\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\n2\b\u00106\u001a\u0004\u0018\u0001072\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J8\u00108\u001a\u0004\u0018\u0001072\u0006\u00109\u001a\u00020\n2\b\u00106\u001a\u0004\u0018\u0001072\u001a\u0010:\u001a\u0016\u0012\u0004\u0012\u00020<\u0018\u00010;j\n\u0012\u0004\u0012\u00020<\u0018\u0001`=H\u0002J=\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\n0;j\b\u0012\u0004\u0012\u00020\n`=2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\n0*2\u0006\u0010@\u001a\u00020\u00072\b\b\u0002\u0010A\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010BJ\u0018\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020E2\u0006\u0010\u001a\u001a\u00020'H\u0002J\u0010\u0010F\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020'H\u0002J\u0010\u0010G\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020'H\u0002J\u0018\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020J2\u0006\u0010\u001a\u001a\u00020'H\u0002J\u0018\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020M2\u0006\u0010\u001a\u001a\u00020'H\u0002J\u0010\u0010N\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020'H\u0002J\u0018\u0010O\u001a\u00020\u00072\u0006\u0010P\u001a\u00020Q2\u0006\u0010\u001a\u001a\u00020'H\u0002J\u0018\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020T2\u0006\u0010\u001a\u001a\u00020'H\u0002J\u0018\u0010U\u001a\u00020\u00072\u0006\u0010V\u001a\u00020W2\u0006\u0010\u001a\u001a\u00020'H\u0002J\u0018\u0010X\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020Z2\u0006\u0010\u001a\u001a\u00020'H\u0002J\u0018\u0010[\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020]2\u0006\u0010\u001a\u001a\u00020'H\u0002J\u0010\u0010^\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020'H\u0002J\u0016\u0010_\u001a\u00020\u000f2\u0006\u0010`\u001a\u00020a2\u0006\u0010\u001a\u001a\u00020bJ\u0016\u0010c\u001a\u00020\u00072\u0006\u0010`\u001a\u00020a2\u0006\u0010\u001a\u001a\u00020dJ\u0018\u0010e\u001a\u00020\u000f2\u0006\u0010`\u001a\u00020a2\u0006\u0010\u001a\u001a\u00020dH\u0002J\u0018\u0010f\u001a\u00020\u00072\u0006\u0010`\u001a\u00020a2\u0006\u0010\u001a\u001a\u00020dH\u0002J\u0018\u0010g\u001a\u00020\u000f2\u0006\u0010`\u001a\u00020a2\u0006\u0010\u001a\u001a\u00020dH\u0002J&\u0010h\u001a\u00020\u000f2\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u00020\n0;j\b\u0012\u0004\u0012\u00020\n`=2\u0006\u0010\u001a\u001a\u00020iJ\u0010\u0010j\u001a\u0004\u0018\u00010\n2\u0006\u0010k\u001a\u00020\nJ\u0016\u0010l\u001a\u00020\u000f2\u0006\u0010`\u001a\u00020a2\u0006\u0010\u001a\u001a\u00020bJ\u0010\u0010m\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020'H\u0002J\u0010\u0010n\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020'H\u0002J \u0010o\u001a\u00020\u00072\u0006\u0010p\u001a\u00020\n2\u0006\u0010q\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020'H\u0002J\u0018\u0010r\u001a\u00020\u000f2\u0006\u0010s\u001a\u00020t2\u0006\u0010\u001a\u001a\u00020'H\u0002J\u0018\u0010u\u001a\u00020\u00072\u0006\u0010v\u001a\u00020w2\u0006\u0010\u001a\u001a\u00020'H\u0002J \u0010x\u001a\u00020\u000f2\u0006\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020'H\u0002J\u001a\u0010|\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u0001072\u0006\u0010\u001a\u001a\u00020'H\u0002J\u001a\u0010}\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u0001072\u0006\u0010\u001a\u001a\u00020'H\u0002J\u001a\u0010~\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u0001072\u0006\u0010\u001a\u001a\u00020'H\u0002J\u0010\u0010\u007f\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020'H\u0002J\u0019\u0010\u0080\u0001\u001a\u00020\u00072\u0006\u00105\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020'H\u0002J!\u0010\u0081\u0001\u001a\u00020\u00072\u0006\u00105\u001a\u00020\n2\b\u00106\u001a\u0004\u0018\u0001072\u0006\u0010\u001a\u001a\u00020'J\u0011\u0010\u0082\u0001\u001a\u00020\u00052\u0006\u00105\u001a\u00020\nH\u0002J\u001d\u0010\u0083\u0001\u001a\u0002072\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\b\u00106\u001a\u0004\u0018\u000107H\u0002J\u001a\u0010\u0086\u0001\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u0001072\u0007\u0010\u001a\u001a\u00030\u0087\u0001J\u0010\u0010\u0088\u0001\u001a\u00020\u00072\u0007\u0010\u001a\u001a\u00030\u0087\u0001J\u0013\u0010\u0089\u0001\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u000107H\u0002J\u0010\u0010\u008a\u0001\u001a\u00020\u00072\u0007\u0010\u001a\u001a\u00030\u0087\u0001J!\u0010\u008b\u0001\u001a\u00020\u00072\u0006\u0010p\u001a\u00020\n2\u0007\u0010\u008c\u0001\u001a\u00020\n2\u0007\u0010\u001a\u001a\u00030\u0087\u0001J\u001b\u0010\u008d\u0001\u001a\u00020\u00072\u0007\u0010\u008e\u0001\u001a\u00020\n2\u0007\u0010\u001a\u001a\u00030\u008f\u0001H\u0016J\u0012\u0010\u0090\u0001\u001a\u00020\n2\u0007\u0010\u008e\u0001\u001a\u00020\nH\u0002J\u001b\u0010\u0091\u0001\u001a\u00020\u000f2\u0007\u0010\u008e\u0001\u001a\u00020\n2\u0007\u0010\u001a\u001a\u00030\u008f\u0001H\u0002J\u001b\u0010\u0092\u0001\u001a\u00020\u000f2\u0007\u0010\u0093\u0001\u001a\u00020\n2\u0007\u0010\u001a\u001a\u00030\u008f\u0001H\u0002J0\u0010\u008d\u0001\u001a\u00020\u000f2\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\u0007\u0010\u0096\u0001\u001a\u00020\n2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\n2\u0007\u0010\u001a\u001a\u00030\u0098\u0001H\u0016J.\u0010\u008d\u0001\u001a\u00020\u000f2\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\u0007\u0010\u0096\u0001\u001a\u00020\n2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\n2\u0007\u0010\u001a\u001a\u00030\u008f\u0001J?\u0010\u0099\u0001\u001a\u00020\u000f2\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\u0007\u0010\u0096\u0001\u001a\u00020\n2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\n2\n\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0098\u00012\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0002J\u001c\u0010\u009c\u0001\u001a\u00020\n2\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\u0007\u0010\u0096\u0001\u001a\u00020\nH\u0002J\u0010\u0010\u009d\u0001\u001a\u00020\u000f2\u0007\u0010\u001a\u001a\u00030\u009e\u0001J\u0007\u0010\u009f\u0001\u001a\u00020\u0007J\u0016\u0010 \u0001\u001a\u000f\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0¡\u0001H\u0002J!\u0010¢\u0001\u001a\u0004\u0018\u0001072\u0014\u0010£\u0001\u001a\u000f\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0¡\u0001H\u0002J\u000f\u0010¤\u0001\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020'J\u0011\u0010¥\u0001\u001a\u00020\u00072\b\u0010k\u001a\u0004\u0018\u00010\nJ\u0013\u0010¦\u0001\u001a\u0004\u0018\u00010\n2\b\u0010k\u001a\u0004\u0018\u00010\nJ\u000f\u0010§\u0001\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020'J\u0007\u0010¨\u0001\u001a\u00020\u0005J\u0007\u0010©\u0001\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006ª\u0001"}, d2 = {"Lcom/hive/social/SocialHiveImpl;", "Lcom/hive/module/interfaces/HiveSocial;", "<init>", "()V", "isAuthHubInProgress", "", "PROFILE_LIST_PAGE_SIZE", "", "uidToVid", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "isClear", "isShowGuestLoginButton", "peppermintInitialize", "", "appId", "gameIndex", "serverType", "peppermintUnInitialize", "setAuthDialogClear", "getAuthDialogClear", "setGuestLoginButton", "isShow", "getGuestLoginButton", "getMyProfile", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/SocialHive$ProfileListener;", "setMyProfile", "displayName", "setMyProfileEx", "getFriends", "friendType", "Lcom/hive/SocialHive$FriendType;", "getFriendsParam", "Lcom/hive/SocialHive$GetFriendsParam;", "getFriendsEx", "friendsType", "getInvitations", "Lcom/hive/SocialHive$AsyncRequestListener;", "getProfiles", "vidLists", "", "([Ljava/lang/String;Lcom/hive/SocialHive$ProfileListener;)V", "getOauthAccessToken", "refreshOauthAccessToken", "requestUsersInfoWithVidList", "vidList", "([Ljava/lang/String;Lcom/hive/SocialHive$ProfileListener;)I", "requestUsersInfoWithUidList", "uidList", "getMyProfileEx", "requestUserProfile", "subPath", "jsonData", "Lorg/json/JSONObject;", "getJSONFromProfileHive", "type", "profileList", "Ljava/util/ArrayList;", "Lcom/hive/SocialHive$ProfileHive;", "Lkotlin/collections/ArrayList;", "getPagedUidList", "fullUidList", "pageNum", "pageSize", "([Ljava/lang/String;II)Ljava/util/ArrayList;", "requestUploadSaveData", "uploadSaveData", "Lcom/hive/SocialHive$UploadSaveDataParam;", "requestDownloadSaveData", "requestDeleteSaveData", "requestUploadImage", "uploadImageParam", "Lcom/hive/SocialHive$UploadImageParam;", "requestWallWrite", "wallWriteParam", "Lcom/hive/SocialHive$WallWriteParam;", "requestMessageNotiCount", "requestFriendsReject", "friendsRejectRequestParam", "Lcom/hive/SocialHive$FriendsRejectRequestParam;", "requestFriends", "friendsRequestParam", "Lcom/hive/SocialHive$FriendsRequestParam;", "requestFriendsFacebook", "friendsFacebookRequestParam", "Lcom/hive/SocialHive$FriendsFacebookRequestParam;", "requestFriendsReceiveList", "friendsReceiveListParam", "Lcom/hive/SocialHive$FriendsReceiveListParam;", "requestGuestStatusSaveData", "guestStatusSaveDataParam", "Lcom/hive/SocialHive$GuestStatusSaveDataParam;", "requestUserMeNotification", "sendMessage", "messageContent", "Lcom/hive/SocialHive$MessageContent;", "Lcom/hive/SocialHive$SendMessageListener;", "sendMessageEx", "Lcom/hive/SocialHive$SendMessageListenerEx;", "sendMessageWithParam", "sendMessageExWithUid", "sendMessageWithUidParam", "getUidFromVid", "Lcom/hive/SocialHive$GetVidListener;", "getVidFromUidWithMap", "uid", "sendInvitationMessage", "getDeviceRegistered", "requestGuestCreate", "requestGuestKey", "guestUid", ClientData.KEY_CHALLENGE, "requestGuestGenerate", "guestGenerateParam", "Lcom/hive/SocialHive$GuestGenerateParam;", "requestGuestAuth", "guestAuthParam", "Lcom/hive/SocialHive$GuestAuthParam;", "requestGuestLogin", "guestLoginParam", "Lcom/hive/SocialHive$GuestLoginParam;", "verifier", "requestSocialConnect", "requestAcaLoginPlayGamesService", "requestAcaLoginPlayGamesServiceSet", "requestUserDelete", "requestUndefinedRequest", "asyncRequest", "isUserHubUidApi", "getSocialDialogResultJson", "result", "Lcom/hive/ResultAPI;", "authHub", "Lcom/hive/SocialHive$ShowPeppermintDialogListener;", "logoutHub", "showTransparentView", "guestAcquireUid", "guestBind", "candidateUid", "showHiveDialog", "subpath", "Lcom/hive/SocialHive$ShowHiveDialogDataListener;", "getUrlWithSubpath", "showHiveSocialDialog", "showGuestApiDialog", "url", "hiveDialogType", "Lcom/hive/SocialHive$HiveDialogType;", "vid", "additionalInfo", "Lcom/hive/SocialHive$ShowHiveDialogListener;", "internalShowHiveDialog", "resultListener", "dataListener", "findShowHiveDialogUrl", "getBadgeInfo", "Lcom/hive/SocialHive$SocialBadgeListener;", "storeCurrentUserId", "loadStoredUserInfoMap", "", "loadStoredUserInfoJson", "mapData", "getStoredUserIdIntoList", "deleteStoredUserId", "searchPeppermintFromUid", "removeServerPeppermintCookie", "isCurrentUserStoredInfo", "processLogoutData", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SocialHiveImpl implements HiveSocial {
    private static final int PROFILE_LIST_PAGE_SIZE = 300;
    private static boolean isAuthHubInProgress;
    private static boolean isClear;
    private static boolean isShowGuestLoginButton;
    public static final SocialHiveImpl INSTANCE = new SocialHiveImpl();
    private static final HashMap<String, String> uidToVid = new HashMap<>();

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SocialHive.HiveRelationRoute.values().length];
            try {
                iArr[SocialHive.HiveRelationRoute.HIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SocialHive.HiveRelationRoute.FACEBOOK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SocialHive.HiveRelationRoute.GAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SocialHive.HiveRelationRoute.CONTACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SocialHive.HiveDialogType.values().length];
            try {
                iArr2[SocialHive.HiveDialogType.HOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[SocialHive.HiveDialogType.INQUIRY.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[SocialHive.HiveDialogType.CHATBOT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[SocialHive.HiveDialogType.GAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[SocialHive.HiveDialogType.USER.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[SocialHive.HiveDialogType.MESSAGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: renamed from: com.hive.social.SocialHiveImpl$refreshOauthAccessToken$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.social.SocialHiveImpl$refreshOauthAccessToken$1", f = "SocialHiveImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C29581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SocialHive.AsyncRequestListener $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29581(SocialHive.AsyncRequestListener asyncRequestListener, Continuation<? super C29581> continuation) {
            super(2, continuation);
            this.$listener = asyncRequestListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29581(this.$listener, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            OauthToken oauthToken = HiveLifecycle.INSTANCE.getAccount().getOauthToken();
            if (oauthToken != null) {
                Boxing.boxBoolean(oauthToken.refresh());
            }
            SocialHiveImpl.INSTANCE.getOauthAccessToken(this.$listener);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    private SocialHiveImpl() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getBadgeInfo$lambda$71(SocialHive.SocialBadgeListener socialBadgeListener, ResultAPI resultApi, MessageNotiCount messageNotiCount, SocialHive.SocialBadge badge) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(messageNotiCount, "messageNotiCount");
        Intrinsics.checkNotNullParameter(badge, "badge");
        if (resultApi.isSuccess()) {
            socialBadgeListener.onSocialBadge(resultApi, badge);
        } else {
            socialBadgeListener.onSocialBadge(new ResultAPI(ResultAPI.Code.SocialHIVEResponseFailGetBadgeInfo, ""), null);
        }
        return Unit.INSTANCE;
    }

    private final int getDeviceRegistered(final SocialHive.AsyncRequestListener listener) {
        HiveGraph.INSTANCE.requestDeviceRegistered(new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SocialHiveImpl.getDeviceRegistered$lambda$53(listener, (ResultAPI) obj, (DeviceRegistered) obj2);
            }
        });
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getDeviceRegistered$lambda$53(SocialHive.AsyncRequestListener asyncRequestListener, ResultAPI resultApi, DeviceRegistered deviceRegistered) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(deviceRegistered, "deviceRegistered");
        if (resultApi.isSuccess()) {
            asyncRequestListener.onComplete(resultApi, deviceRegistered.getResponse().getContentJSONObject());
        } else {
            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorDeviceRegistered, ""), deviceRegistered.getResponse().getContentJSONObject());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getFriends$lambda$4(final SocialHive.ProfileListener profileListener, final ResultAPI resultApi, final ArrayList profileList) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(profileList, "profileList");
        if (resultApi.isSuccess()) {
            try {
                final ArrayList<String> arrayList = new ArrayList<>();
                Iterator it = profileList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    String uid = ((SocialHive.ProfileHive) next).getUid();
                    if (uid == null) {
                        uid = "";
                    }
                    arrayList.add(uid);
                }
                AuthNetwork.LoginCenter.INSTANCE.getVid(arrayList).request(new Function1() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda55
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SocialHiveImpl.getFriends$lambda$4$lambda$3(arrayList, profileList, profileListener, resultApi, (GetVid) obj);
                    }
                });
            } catch (Throwable th) {
                th.printStackTrace();
                profileListener.onProfile(new ResultAPI(-99, ResultAPI.Code.SocialHIVEResponseFailGetFriends, ""), null);
            }
        } else {
            new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorGetFriends, "");
            profileListener.onProfile(resultApi, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getFriends$lambda$4$lambda$3(ArrayList arrayList, ArrayList arrayList2, SocialHive.ProfileListener profileListener, ResultAPI resultAPI, GetVid getVid) {
        Intrinsics.checkNotNullParameter(getVid, "getVid");
        if (getVid.getResponse().isSuccess()) {
            try {
                int size = arrayList.size();
                int size2 = getVid.getResponse().getVidList().size();
                if (size == size2) {
                    for (int i = 0; i < size2; i++) {
                        ((SocialHive.ProfileHive) arrayList2.get(i)).setVid(getVid.getResponse().getVidList().get(i));
                    }
                }
                HiveUserCache.INSTANCE.addProfiles(arrayList2);
                profileListener.onProfile(resultAPI, arrayList2);
            } catch (Exception e) {
                e.printStackTrace();
                profileListener.onProfile(new ResultAPI(-1, ResultAPI.Code.SocialHIVEResponseFailGetFriends, ""), arrayList2);
            }
        } else {
            profileListener.onProfile(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorGetFriends, ""), null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFriendsEx$lambda$9(SocialHive.FriendType friendType, SocialHive.GetFriendsParam getFriendsParam, final SocialHive.ProfileListener profileListener) {
        HiveGraph.INSTANCE.getFriends(true, friendType, getFriendsParam, new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda57
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SocialHiveImpl.getFriendsEx$lambda$9$lambda$8(profileListener, (ResultAPI) obj, (ArrayList) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getFriendsEx$lambda$9$lambda$8(final SocialHive.ProfileListener profileListener, ResultAPI resultApi, final ArrayList profileList) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(profileList, "profileList");
        if (resultApi.isSuccess()) {
            try {
                final ArrayList arrayList = new ArrayList();
                Iterator it = profileList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    String uid = ((SocialHive.ProfileHive) next).getUid();
                    if (uid == null) {
                        uid = "";
                    }
                    arrayList.add(uid);
                }
                new Thread(new Runnable() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda33
                    @Override // java.lang.Runnable
                    public final void run() {
                        SocialHiveImpl.getFriendsEx$lambda$9$lambda$8$lambda$7(profileList, arrayList, profileListener);
                    }
                }).start();
            } catch (Throwable th) {
                th.printStackTrace();
                profileListener.onProfile(new ResultAPI(-99, ResultAPI.Code.SocialHIVEResponseFailGetFriends, ""), null);
            }
        } else {
            profileListener.onProfile(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorGetFriends, ""), null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFriendsEx$lambda$9$lambda$8$lambda$7(final ArrayList arrayList, ArrayList arrayList2, SocialHive.ProfileListener profileListener) {
        int size = arrayList.size() > 300 ? 1 + (arrayList.size() / 300) : 1;
        LoggerImpl.INSTANCE.i("[SocialHiveImpl] getFriendsEx, profileList.size : " + arrayList.size() + ", uidListPages : " + size);
        for (int i = 0; i < size; i++) {
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.i("[SocialHiveImpl] getFriendsEx, pageCnt : " + i);
            ArrayList pagedUidList$default = getPagedUidList$default(INSTANCE, (String[]) arrayList2.toArray(new String[0]), i, 0, 4, null);
            loggerImpl.dL("[SocialHiveImpl] getFriendsEx, targetUidList.size : " + pagedUidList$default.size());
            if (!pagedUidList$default.isEmpty()) {
                HiveGraph.INSTANCE.profileGetUserEx(pagedUidList$default, new Function3() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda50
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SocialHiveImpl.getFriendsEx$lambda$9$lambda$8$lambda$7$lambda$5(arrayList, ((Integer) obj).intValue(), (ProfileGetUser) obj2, (ArrayList) obj3);
                    }
                });
            }
        }
        if (!Intrinsics.areEqual(HiveLifecycle.INSTANCE.getAccount().getVidType(), "v0")) {
            LoggerImpl.INSTANCE.i("[SocialHiveImpl] getFriendsEx, find vid");
            GetVid getVid = (GetVid) AuthNetwork.LoginCenter.INSTANCE.getVid(arrayList2).request();
            if (!getVid.getResponse().isSuccess()) {
                profileListener.onProfile(new ResultAPI(-1, ResultAPI.Code.SocialHIVENetworkErrorGetFriends, ""), null);
                return;
            }
            try {
                int size2 = arrayList2.size();
                int size3 = getVid.getResponse().getVidList().size();
                if (size2 == size3) {
                    for (int i2 = 0; i2 < size3; i2++) {
                        ((SocialHive.ProfileHive) arrayList.get(i2)).setVid(getVid.getResponse().getVidList().get(i2));
                    }
                }
                HiveUserCache.INSTANCE.addProfiles(arrayList);
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("getFriendsEx, Exception : " + e);
                profileListener.onProfile(new ResultAPI(-1, ResultAPI.Code.SocialHIVEResponseFailGetFriends, ""), arrayList);
                return;
            }
        }
        profileListener.onProfile(new ResultAPI(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getFriendsEx$lambda$9$lambda$8$lambda$7$lambda$5(ArrayList arrayList, int i, ProfileGetUser profileGetUser, ArrayList profileGetUserList) {
        Intrinsics.checkNotNullParameter(profileGetUser, "profileGetUser");
        Intrinsics.checkNotNullParameter(profileGetUserList, "profileGetUserList");
        if (i == 0) {
            Iterator it = profileGetUserList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                SocialHive.ProfileGetUser profileGetUser2 = (SocialHive.ProfileGetUser) next;
                Iterator it2 = arrayList.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    SocialHive.ProfileHive profileHive = (SocialHive.ProfileHive) next2;
                    if (StringsKt.equals$default(profileHive.getUid(), profileGetUser2.getUserId(), false, 2, null)) {
                        profileHive.setProfileImageUrl(profileGetUser2.getProfileImg());
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getInvitations$lambda$10(SocialHive.AsyncRequestListener asyncRequestListener, ResultAPI resultApi, JSONObject jsonData) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        if (resultApi.isSuccess()) {
            asyncRequestListener.onComplete(new ResultAPI(), jsonData);
        } else {
            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorGetFriends, ""), null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject getJSONFromProfileHive(String type, JSONObject jsonData, ArrayList<SocialHive.ProfileHive> profileList) {
        String str;
        String str2;
        String str3;
        JSONArray jSONArray;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        JSONArray jSONArray2;
        String str12 = type;
        JSONObject jSONObject = jsonData;
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i("[SocialHiveImpl] getJSONFromProfileHive");
        if (profileList != null) {
            try {
                String str13 = "is_contact";
                String str14 = "is_game";
                String str15 = "is_hive";
                String str16 = "is_facebook";
                String str17 = "picture";
                String str18 = "friend";
                if (profileList.size() > 1 || str12.equals("friend") || str12.equals("users")) {
                    String str19 = "comment";
                    String str20 = "is_test_account";
                    String str21 = "cached";
                    String str22 = "gender";
                    String str23 = "birthday";
                    String str24 = UserDataStore.COUNTRY;
                    try {
                        loggerImpl.i("[SocialHiveImpl] getJSONFromProfileHive, profileList size : " + profileList.size());
                        JSONArray jSONArray3 = new JSONArray();
                        int size = profileList.size();
                        int i = 0;
                        while (i < size) {
                            int i2 = size;
                            JSONObject jSONObject2 = new JSONObject();
                            if (str12.equals(str18)) {
                                jSONObject2.put("uid", profileList.get(i).getUid());
                                jSONObject2.put("id", profileList.get(i).getIdentifier());
                                jSONObject2.put("name", profileList.get(i).getUserName());
                                jSONObject2.put("fbid", profileList.get(i).getFacebookId());
                                jSONObject2.put(str17, profileList.get(i).getProfileImageUrl());
                                jSONObject2.put(str24, profileList.get(i).getCountry());
                                str = str18;
                                jSONObject2.put("game_friend", profileList.get(i).getGameFriend());
                                jSONObject2.put(str20, profileList.get(i).getTestAccount());
                                String str25 = str16;
                                jSONObject2.put(str25, false);
                                jSONArray = jSONArray3;
                                str4 = str15;
                                jSONObject2.put(str4, false);
                                str10 = str20;
                                str3 = str14;
                                jSONObject2.put(str3, false);
                                str7 = str24;
                                str2 = str13;
                                jSONObject2.put(str2, false);
                                SocialHive.HiveRelationRoute relationRoute = profileList.get(i).getRelationRoute();
                                int i3 = relationRoute == null ? -1 : WhenMappings.$EnumSwitchMapping$0[relationRoute.ordinal()];
                                String str26 = str17;
                                if (i3 == 1) {
                                    jSONObject2.put(str4, true);
                                } else if (i3 == 2) {
                                    jSONObject2.put(str25, true);
                                } else if (i3 == 3) {
                                    jSONObject2.put(str3, true);
                                } else if (i3 != 4) {
                                    Unit unit = Unit.INSTANCE;
                                    str5 = str26;
                                    jSONArray2 = jSONArray;
                                    str9 = str21;
                                    str8 = str23;
                                    str6 = str25;
                                    str11 = str19;
                                    jSONArray2.put(jSONObject2);
                                    i++;
                                    str19 = str11;
                                    str15 = str4;
                                    jSONArray3 = jSONArray2;
                                    str17 = str5;
                                    str14 = str3;
                                    str16 = str6;
                                    size = i2;
                                    str20 = str10;
                                    str21 = str9;
                                    str18 = str;
                                    str23 = str8;
                                    str12 = type;
                                    str13 = str2;
                                    str24 = str7;
                                } else {
                                    jSONObject2.put(str2, true);
                                }
                                str5 = str26;
                                str9 = str21;
                                str8 = str23;
                                str6 = str25;
                                str11 = str19;
                            } else {
                                String str27 = str24;
                                str = str18;
                                String str28 = str20;
                                str2 = str13;
                                str3 = str14;
                                String str29 = str16;
                                jSONArray = jSONArray3;
                                str4 = str15;
                                jSONObject2.put("uid", profileList.get(i).getUid());
                                jSONObject2.put("id", profileList.get(i).getIdentifier());
                                jSONObject2.put("name", profileList.get(i).getUserName());
                                jSONObject2.put("fbid", profileList.get(i).getFacebookId());
                                jSONObject2.put("googleplus_id", profileList.get(i).getGoogleplusId());
                                jSONObject2.put("sinaweibo_id", (Object) null);
                                jSONObject2.put("email", profileList.get(i).getEmail());
                                str5 = str17;
                                jSONObject2.put(str5, profileList.get(i).getProfileImageUrl());
                                str6 = str29;
                                jSONObject2.put(str27, profileList.get(i).getCountry());
                                str7 = str27;
                                String str30 = str23;
                                jSONObject2.put(str30, profileList.get(i).getBirthday());
                                str8 = str30;
                                String str31 = str22;
                                jSONObject2.put(str31, profileList.get(i).getGender());
                                str22 = str31;
                                String str32 = str21;
                                jSONObject2.put(str32, profileList.get(i).getCached());
                                str9 = str32;
                                jSONObject2.put(str28, profileList.get(i).getTestAccount());
                                str10 = str28;
                                str11 = str19;
                                jSONObject2.put(str11, profileList.get(i).getComment());
                            }
                            jSONArray2 = jSONArray;
                            jSONArray2.put(jSONObject2);
                            i++;
                            str19 = str11;
                            str15 = str4;
                            jSONArray3 = jSONArray2;
                            str17 = str5;
                            str14 = str3;
                            str16 = str6;
                            size = i2;
                            str20 = str10;
                            str21 = str9;
                            str18 = str;
                            str23 = str8;
                            str12 = type;
                            str13 = str2;
                            str24 = str7;
                        }
                        JSONArray jSONArray4 = jSONArray3;
                        LoggerImpl.INSTANCE.i("[SocialHiveImpl] getJSONFromProfileHive, jsonArr set");
                        if (Intrinsics.areEqual(type, str18)) {
                            jSONObject = jsonData;
                            if (jSONObject != null) {
                                jSONObject.put("friend_list", jSONArray4);
                            }
                        } else {
                            jSONObject = jsonData;
                            if (jSONObject != null) {
                                jSONObject.put("user_list", jSONArray4);
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        jSONObject = jsonData;
                        e.printStackTrace();
                        Unit unit2 = Unit.INSTANCE;
                    }
                } else {
                    loggerImpl.i("[SocialHiveImpl] getJSONFromProfileHive, profileList size is 1");
                    if (jSONObject != null) {
                        jSONObject.put("uid", profileList.get(0).getUid());
                    }
                    if (jSONObject != null) {
                        jSONObject.put("id", profileList.get(0).getIdentifier());
                    }
                    if (jSONObject != null) {
                        jSONObject.put("name", profileList.get(0).getUserName());
                    }
                    if (jSONObject != null) {
                        jSONObject.put("fbid", profileList.get(0).getFacebookId());
                    }
                    if (jSONObject != null) {
                        jSONObject.put("googleplus_id", profileList.get(0).getGoogleplusId());
                    }
                    if (jSONObject != null) {
                        jSONObject.put("sinaweibo_id", (Object) null);
                    }
                    if (jSONObject != null) {
                        jSONObject.put("email", profileList.get(0).getEmail());
                    }
                    if (jSONObject != null) {
                        jSONObject.put("picture", profileList.get(0).getProfileImageUrl());
                    }
                    if (jSONObject != null) {
                        jSONObject.put(UserDataStore.COUNTRY, profileList.get(0).getCountry());
                    }
                    if (jSONObject != null) {
                        jSONObject.put("birthday", profileList.get(0).getBirthday());
                    }
                    if (jSONObject != null) {
                        jSONObject.put("gender", profileList.get(0).getGender());
                    }
                    if (jSONObject != null) {
                        jSONObject.put("cached", profileList.get(0).getCached());
                    }
                    if (jSONObject != null) {
                        jSONObject.put("is_test_account", profileList.get(0).getTestAccount());
                    }
                    if (jSONObject != null) {
                        jSONObject.put("comment", profileList.get(0).getComment());
                    }
                    loggerImpl.i("[SocialHiveImpl] getJSONFromProfileHive, jsonData set");
                    Unit unit3 = Unit.INSTANCE;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMyProfile$lambda$0(SocialHive.ProfileListener profileListener, ResultAPI resultApi, UserMe userMe, SocialHive.ProfileHive profileHive) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(userMe, "userMe");
        if (!resultApi.isSuccess() || profileHive == null) {
            profileListener.onProfile(new ResultAPI(ResultAPI.Code.SocialHIVEResponseFailGetMyProfile, ""), null);
        } else {
            ArrayList<SocialHive.ProfileHive> arrayListArrayListOf = CollectionsKt.arrayListOf(profileHive);
            HiveUserCache.INSTANCE.addProfile(profileHive);
            profileListener.onProfile(resultApi, arrayListArrayListOf);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMyProfileEx$lambda$27(final SocialHive.ProfileListener profileListener) {
        HiveGraph.INSTANCE.userMeEx(new Function3() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SocialHiveImpl.getMyProfileEx$lambda$27$lambda$26(profileListener, (ResultAPI) obj, (UserMeEx) obj2, (SocialHive.ProfileHive) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMyProfileEx$lambda$27$lambda$26(final SocialHive.ProfileListener profileListener, ResultAPI resultApi, UserMeEx userMeEx, final SocialHive.ProfileHive profileHive) {
        String uid;
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(userMeEx, "userMeEx");
        if (resultApi.isFailure()) {
            profileListener.onProfile(new ResultAPI(-8, ResultAPI.Code.SocialHIVEResponseFailGetProfiles, userMeEx.getResponse().getErrorMsg()), null);
            return Unit.INSTANCE;
        }
        if (profileHive == null || (uid = profileHive.getUid()) == null || uid.length() == 0) {
            profileListener.onProfile(new ResultAPI(ResultAPI.Code.SocialHIVEResponseFailGetMyProfile, "My profile info is null or empty."), null);
            return Unit.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(profileHive.getUid());
        HiveGraph.INSTANCE.profileGetUserEx(arrayList, new Function3() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SocialHiveImpl.getMyProfileEx$lambda$27$lambda$26$lambda$25(profileHive, profileListener, ((Integer) obj).intValue(), (ProfileGetUser) obj2, (ArrayList) obj3);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMyProfileEx$lambda$27$lambda$26$lambda$25(SocialHive.ProfileHive profileHive, SocialHive.ProfileListener profileListener, int i, ProfileGetUser profileGetUser, ArrayList profileGetUserList) {
        Intrinsics.checkNotNullParameter(profileGetUser, "profileGetUser");
        Intrinsics.checkNotNullParameter(profileGetUserList, "profileGetUserList");
        if (i == 0) {
            Iterator it = profileGetUserList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                SocialHive.ProfileGetUser profileGetUser2 = (SocialHive.ProfileGetUser) next;
                if (StringsKt.equals$default(profileHive.getUid(), profileGetUser2.getUserId(), false, 2, null)) {
                    profileHive.setProfileImageUrl(profileGetUser2.getProfileImg());
                    profileHive.setUserName(profileGetUser2.getProfileName());
                }
            }
        }
        HiveUserCache.INSTANCE.addProfile(profileHive);
        profileListener.onProfile(new ResultAPI(), CollectionsKt.arrayListOf(profileHive));
        return Unit.INSTANCE;
    }

    private final ArrayList<String> getPagedUidList(String[] fullUidList, int pageNum, int pageSize) {
        LoggerImpl.INSTANCE.i("[SocialHiveImpl] getPageUidList, fullUidList.size : " + fullUidList.length);
        int i = pageNum * pageSize;
        int i2 = ((pageNum + 1) * pageSize) + (-1);
        int length = fullUidList.length - 1;
        if (i2 > length) {
            i2 = length;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (i <= i2) {
            while (true) {
                arrayList.add(fullUidList[i]);
                LoggerImpl.INSTANCE.i("[SocialHiveImpl] getPageUidList, cnt : " + i + ", uid : " + fullUidList[i]);
                if (i == i2) {
                    break;
                }
                i++;
            }
        }
        LoggerImpl.INSTANCE.i("[SocialHiveImpl] getPageUidList, pagedUidList.size : " + arrayList.size());
        return arrayList;
    }

    public static /* synthetic */ ArrayList getPagedUidList$default(SocialHiveImpl socialHiveImpl, String[] strArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 300;
        }
        return socialHiveImpl.getPagedUidList(strArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getProfiles$lambda$13(String[] strArr, final SocialHive.ProfileListener profileListener) {
        final ArrayList<String> arrayList = new ArrayList<>(ArraysKt.toMutableList(strArr));
        final ArrayMap arrayMap = new ArrayMap();
        Iterator it = ArrayIteratorKt.iterator(strArr);
        while (it.hasNext()) {
            String str = (String) it.next();
            SocialHive.ProfileHive profileByVID = HiveUserCache.INSTANCE.getProfileByVID(str);
            if (profileByVID != null) {
                arrayList.remove(str);
                arrayMap.put(profileByVID.getUid(), str);
            }
        }
        if (!arrayList.isEmpty()) {
            GetUid getUid = (GetUid) AuthNetwork.LoginCenter.INSTANCE.getUid(arrayList).request();
            if (!getUid.getResponse().isSuccess()) {
                if (profileListener != null) {
                    profileListener.onProfile(new ResultAPI(-8, ResultAPI.Code.SocialHIVEResponseFailGetProfiles, getUid.getResponse().getError()), null);
                    return;
                }
                return;
            } else {
                if (arrayList.size() != getUid.getResponse().getUidList().size()) {
                    if (profileListener != null) {
                        profileListener.onProfile(new ResultAPI(-1, ResultAPI.Code.SocialHIVEInvalidParamGetProfiles, "Request vidLists has not vaild vid"), null);
                        return;
                    }
                    return;
                }
                int size = getUid.getResponse().getUidList().size();
                for (int i = 0; i < size; i++) {
                    String str2 = getUid.getResponse().getUidList().get(i);
                    String str3 = arrayList.get(i);
                    if (!StringsKt.isBlank(str2) && !Intrinsics.areEqual(str2, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        arrayMap.put(str2, str3);
                    }
                }
            }
        }
        HiveGraph hiveGraph = HiveGraph.INSTANCE;
        Set setKeySet = arrayMap.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        hiveGraph.users(setKeySet, new Function3() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda51
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SocialHiveImpl.getProfiles$lambda$13$lambda$12(profileListener, arrayMap, arrayList, (ResultAPI) obj, (Users) obj2, (ArrayList) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit getProfiles$lambda$13$lambda$12(SocialHive.ProfileListener profileListener, ArrayMap arrayMap, ArrayList arrayList, ResultAPI resultApi, Users users, ArrayList profileList) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(users, "users");
        Intrinsics.checkNotNullParameter(profileList, "profileList");
        if (resultApi.isFailure()) {
            if (profileListener != null) {
                profileListener.onProfile(new ResultAPI(-8, ResultAPI.Code.SocialHIVEResponseFailGetProfiles, users.getResponse().getErrorMsg()), null);
            }
            return Unit.INSTANCE;
        }
        if (profileList.size() != arrayMap.size()) {
            if (profileListener != null) {
                profileListener.onProfile(new ResultAPI(-1, ResultAPI.Code.SocialHIVEResponseFailGetProfiles, "Response profile does not match vid count"), null);
            }
            return Unit.INSTANCE;
        }
        ArrayList<SocialHive.ProfileHive> arrayList2 = new ArrayList<>();
        Iterator it = profileList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SocialHive.ProfileHive profileHive = (SocialHive.ProfileHive) next;
            profileHive.setVid((String) arrayMap.get(profileHive.getUid()));
            arrayList2.add(profileHive);
            arrayList.remove(profileHive.getVid());
        }
        HiveUserCache.INSTANCE.addProfiles(arrayList2);
        if (!arrayList.isEmpty()) {
            Iterator it2 = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
            while (it2.hasNext()) {
                String str = (String) it2.next();
                SocialHive.ProfileHive profileHive2 = new SocialHive.ProfileHive();
                profileHive2.setVid(str);
                profileHive2.setUid(null);
                arrayList2.add(profileHive2);
            }
        }
        if (profileListener != null) {
            profileListener.onProfile(new ResultAPI(), arrayList2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject getSocialDialogResultJson(ResultAPI result, JSONObject jsonData) {
        LoggerImpl.INSTANCE.i("getSocialDialogResultJson");
        JSONObject jSONObject = new JSONObject();
        if (jsonData == null) {
            jsonData = jSONObject;
        }
        try {
            jsonData.put("error_msg", result.getErrorMessage());
            if (!jsonData.has(NativeProtocol.BRIDGE_ARG_ERROR_CODE) || jsonData.optInt(NativeProtocol.BRIDGE_ARG_ERROR_CODE, -1) != 1801) {
                int errorCode = result.getErrorCode();
                if (errorCode == -99) {
                    jsonData.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 1100);
                    return jsonData;
                }
                if (errorCode == -6) {
                    jsonData.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 2001);
                    return jsonData;
                }
                if (errorCode == 0) {
                    jsonData.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
                    return jsonData;
                }
            }
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("getSocialDialogResultJson, exception : " + e);
        }
        return jsonData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getUidFromVid$lambda$51(ArrayList arrayList, SocialHive.GetVidListener getVidListener) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        GetVid getVid = (GetVid) AuthNetwork.LoginCenter.INSTANCE.getVid(arrayList).request();
        if (!getVid.getResponse().isSuccess()) {
            getVidListener.onComplete(new ResultAPI(-1, ResultAPI.Code.SocialHIVEResponseFail, "getVid response fail"), null);
            return;
        }
        if (arrayList.size() != getVid.getResponse().getVidList().size()) {
            getVidListener.onComplete(new ResultAPI(-8, ResultAPI.Code.SocialHIVEResponseFail, "invalid vid included"), null);
            return;
        }
        for (String str : getVid.getResponse().getVidList()) {
            Intrinsics.checkNotNullExpressionValue(str, "next(...)");
            arrayList2.add(str);
        }
        getVidListener.onComplete(new ResultAPI(0, ResultAPI.Code.Success), arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getUrlWithSubpath(String subpath) {
        if (StringsKt.startsWith$default(subpath, "message", false, 2, (Object) null)) {
            return UrlManager.SocialFriendWeb.INSTANCE.getUndefinedRequest() + subpath;
        }
        return UrlManager.SocialWeb.INSTANCE.getUndefinedRequest() + subpath;
    }

    private final void internalShowHiveDialog(final SocialHive.HiveDialogType hiveDialogType, final String vid, final String additionalInfo, final SocialHive.ShowHiveDialogListener resultListener, final SocialHive.ShowHiveDialogDataListener dataListener) {
        if (!AuthImpl.INSTANCE.isInitialize()) {
            LoggerImpl.INSTANCE.d("[SocialHiveImpl] Need Auth initialize first.");
            if (resultListener != null) {
                resultListener.onShowHiveDialog(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""));
            }
            if (dataListener != null) {
                dataListener.onShowHiveDialogWithData(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""), null);
                return;
            }
            return;
        }
        String value = Property.INSTANCE.getINSTANCE().getValue(SocialKeys.INSTANCE.getPEPPERMINT());
        if (hiveDialogType != SocialHive.HiveDialogType.MYINQUIRY || (value != null && !StringsKt.isBlank(value))) {
            new Thread(new Runnable() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda43
                @Override // java.lang.Runnable
                public final void run() {
                    SocialHiveImpl.internalShowHiveDialog$lambda$70(hiveDialogType, vid, additionalInfo, resultListener, dataListener);
                }
            }).start();
            return;
        }
        LoggerImpl.INSTANCE.d("[SocialHiveImpl] Need account log in first.");
        if (resultListener != null) {
            resultListener.onShowHiveDialog(new ResultAPI(-9, ResultAPI.Code.SocialHIVEInvalidSession));
        }
        if (dataListener != null) {
            dataListener.onShowHiveDialogWithData(new ResultAPI(-9, ResultAPI.Code.SocialHIVEInvalidSession), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void internalShowHiveDialog$lambda$70(final SocialHive.HiveDialogType hiveDialogType, String str, final String str2, final SocialHive.ShowHiveDialogListener showHiveDialogListener, final SocialHive.ShowHiveDialogDataListener showHiveDialogDataListener) {
        final String strFindShowHiveDialogUrl = INSTANCE.findShowHiveDialogUrl(hiveDialogType, str);
        Intent intent = new Intent();
        intent.putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, true);
        HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), intent, new OnActivityLifecycle() { // from class: com.hive.social.SocialHiveImpl$internalShowHiveDialog$1$1
            private AuthSocialView authSocialView;
            private SocialDialog dialog;

            public final AuthSocialView getAuthSocialView() {
                return this.authSocialView;
            }

            public final SocialDialog getDialog() {
                return this.dialog;
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public boolean onBackPressed() {
                SocialDialog socialDialog = this.dialog;
                if (socialDialog != null) {
                    return socialDialog.onBackPressed();
                }
                AuthSocialView authSocialView = this.authSocialView;
                if (authSocialView != null) {
                    return authSocialView.onBackPressed();
                }
                return true;
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onCreate(final Activity activity, Bundle savedInstanceState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                super.onCreate(activity, savedInstanceState);
                final SocialHive.ShowHiveDialogListener showHiveDialogListener2 = showHiveDialogListener;
                final SocialHive.ShowHiveDialogDataListener showHiveDialogDataListener2 = showHiveDialogDataListener;
                SocialHive.ShowHiveDialogDataListener showHiveDialogDataListener3 = new SocialHive.ShowHiveDialogDataListener() { // from class: com.hive.social.SocialHiveImpl$internalShowHiveDialog$1$1$onCreate$socialDialogListener$1
                    @Override // com.hive.SocialHive.ShowHiveDialogDataListener
                    public void onShowHiveDialogWithData(ResultAPI result, JSONObject jsonData) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        SocialHive.ShowHiveDialogListener showHiveDialogListener3 = showHiveDialogListener2;
                        if (showHiveDialogListener3 != null) {
                            showHiveDialogListener3.onShowHiveDialog(result);
                        }
                        SocialHive.ShowHiveDialogDataListener showHiveDialogDataListener4 = showHiveDialogDataListener2;
                        if (showHiveDialogDataListener4 != null) {
                            showHiveDialogDataListener4.onShowHiveDialogWithData(result, SocialHiveImpl.INSTANCE.getSocialDialogResultJson(result, jsonData));
                        }
                        activity.finish();
                    }
                };
                SocialHive.HiveDialogType hiveDialogType2 = hiveDialogType;
                if (hiveDialogType2 == SocialHive.HiveDialogType.MYINQUIRY || hiveDialogType2 == SocialHive.HiveDialogType.INQUIRY) {
                    AuthSocialView authSocialView = new AuthSocialView(activity, hiveDialogType2.getValue(), "", showHiveDialogDataListener3);
                    this.authSocialView = authSocialView;
                    authSocialView.show();
                } else {
                    SocialDialog socialDialog = new SocialDialog(activity, strFindShowHiveDialogUrl, hiveDialogType, str2, true, showHiveDialogDataListener3);
                    this.dialog = socialDialog;
                    socialDialog.show();
                }
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onDestroy(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (!getIsCalledFinish()) {
                    SocialDialog socialDialog = this.dialog;
                    if (socialDialog != null) {
                        socialDialog.dismiss();
                    }
                    AuthSocialView authSocialView = this.authSocialView;
                    if (authSocialView != null) {
                        authSocialView.dismiss();
                    }
                }
                super.onDestroy(activity);
            }

            public final void setAuthSocialView(AuthSocialView authSocialView) {
                this.authSocialView = authSocialView;
            }

            public final void setDialog(SocialDialog socialDialog) {
                this.dialog = socialDialog;
            }
        });
    }

    private final boolean isUserHubUidApi(String subPath) {
        LoggerImpl.INSTANCE.i("isUserHubUidApi");
        List listSplit$default = StringsKt.split$default((CharSequence) subPath, new String[]{DomExceptionUtils.SEPARATOR}, false, 0, 6, (Object) null);
        if (listSplit$default.size() < 2 || !Intrinsics.areEqual(listSplit$default.get(0), "user") || StringsKt.toIntOrNull((String) listSplit$default.get(1)) == null) {
            listSplit$default = null;
        }
        return listSplit$default != null;
    }

    private final JSONObject loadStoredUserInfoJson(Map<String, String> mapData) throws JSONException {
        LoggerImpl.INSTANCE.i("loadStoredUserInfoJson");
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, String> entry : mapData.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(key, value);
            jSONArray.put(jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("infoList", jSONArray);
        return jSONObject2;
    }

    private final Map<String, String> loadStoredUserInfoMap() {
        JSONArray jSONArrayOptJSONArray;
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i("loadStoredUserInfoMap");
        String value = Property.INSTANCE.getINSTANCE().getValue(SocialKeys.INSTANCE.getSTORED_USER_INFO(), "");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            JSONObject jSONObject = new JSONObject(value);
            loggerImpl.i("loadStoredUserInfoMap, get data from local : " + jSONObject);
            if (jSONObject.has("infoList") && (jSONArrayOptJSONArray = jSONObject.optJSONArray("infoList")) != null) {
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            linkedHashMap.put(next, jSONObjectOptJSONObject.optString(next, ""));
                        }
                    }
                }
            }
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("loadStoredUserInfoList, get stored data exception : " + e);
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeServerPeppermintCookie$lambda$79(String str, final SocialHive.AsyncRequestListener asyncRequestListener) {
        HiveGraph.INSTANCE.acaDeleteCookies(str, new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda48
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SocialHiveImpl.removeServerPeppermintCookie$lambda$79$lambda$78(asyncRequestListener, (ResultAPI) obj, (JSONObject) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit removeServerPeppermintCookie$lambda$79$lambda$78(SocialHive.AsyncRequestListener asyncRequestListener, ResultAPI resultApi, JSONObject responseJson) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(responseJson, "responseJson");
        if (resultApi.isSuccess()) {
            LoggerImpl.INSTANCE.i("removeServerPeppermintCookie, acaDeleteCookies request success.");
            INSTANCE.processLogoutData();
            HiveLifecycle.INSTANCE.onSignOut();
        } else {
            LoggerImpl.INSTANCE.i("removeServerPeppermintCookie, acaDeleteCookies request failure.");
        }
        asyncRequestListener.onComplete(resultApi, responseJson);
        return Unit.INSTANCE;
    }

    private final int requestAcaLoginPlayGamesService(JSONObject jsonData, final SocialHive.AsyncRequestListener listener) {
        if (AuthImpl.INSTANCE.isInitialize()) {
            HiveGraph.INSTANCE.requestAcaLoginPlayGamesService(jsonData, new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialHiveImpl.requestAcaLoginPlayGamesService$lambda$58(listener, (ResultAPI) obj, (AcaLoginPlayGamesService) obj2);
                }
            });
            return 0;
        }
        listener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized), null);
        return -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestAcaLoginPlayGamesService$lambda$58(SocialHive.AsyncRequestListener asyncRequestListener, ResultAPI resultApi, AcaLoginPlayGamesService AcaLoginPlayGamesService) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(AcaLoginPlayGamesService, "AcaLoginPlayGamesService");
        if (resultApi.isSuccess()) {
            asyncRequestListener.onComplete(resultApi, AcaLoginPlayGamesService.getResponse().getContentJSONObject());
        } else {
            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorGuestStatusSaveData, ""), AcaLoginPlayGamesService.getResponse().getContentJSONObject());
        }
        return Unit.INSTANCE;
    }

    private final int requestAcaLoginPlayGamesServiceSet(JSONObject jsonData, final SocialHive.AsyncRequestListener listener) {
        if (AuthImpl.INSTANCE.isInitialize()) {
            HiveGraph.INSTANCE.requestAcaLoginPlayGamesServiceSet(jsonData, new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialHiveImpl.requestAcaLoginPlayGamesServiceSet$lambda$59(listener, (ResultAPI) obj, (AcaLoginPlayGamesServiceSet) obj2);
                }
            });
            return 0;
        }
        listener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized), null);
        return -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestAcaLoginPlayGamesServiceSet$lambda$59(SocialHive.AsyncRequestListener asyncRequestListener, ResultAPI resultApi, AcaLoginPlayGamesServiceSet AcaLoginPlayGamesServiceSet) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(AcaLoginPlayGamesServiceSet, "AcaLoginPlayGamesServiceSet");
        if (resultApi.isSuccess()) {
            asyncRequestListener.onComplete(resultApi, AcaLoginPlayGamesServiceSet.getResponse().getContentJSONObject());
        } else {
            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorGuestStatusSaveData, ""), AcaLoginPlayGamesServiceSet.getResponse().getContentJSONObject());
        }
        return Unit.INSTANCE;
    }

    private final int requestDeleteSaveData(final SocialHive.AsyncRequestListener listener) {
        if (AuthImpl.INSTANCE.isInitialize()) {
            HiveGraph.INSTANCE.deleteSaveData(new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialHiveImpl.requestDeleteSaveData$lambda$34(listener, (ResultAPI) obj, (SaveDataDelete) obj2);
                }
            });
            return 0;
        }
        listener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized), null);
        return -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestDeleteSaveData$lambda$34(SocialHive.AsyncRequestListener asyncRequestListener, ResultAPI resultApi, SaveDataDelete saveDataDelete) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(saveDataDelete, "saveDataDelete");
        if (resultApi.isSuccess()) {
            asyncRequestListener.onComplete(resultApi, saveDataDelete.getResponse().getContentJSONObject());
        } else {
            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorSaveDataDelete, ""), saveDataDelete.getResponse().getContentJSONObject());
        }
        return Unit.INSTANCE;
    }

    private final int requestDownloadSaveData(final SocialHive.AsyncRequestListener listener) {
        if (AuthImpl.INSTANCE.isInitialize()) {
            HiveGraph.INSTANCE.downloadSaveData(new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda40
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialHiveImpl.requestDownloadSaveData$lambda$33(listener, (ResultAPI) obj, (SaveDataDownload) obj2);
                }
            });
            return 0;
        }
        listener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized), null);
        return -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestDownloadSaveData$lambda$33(SocialHive.AsyncRequestListener asyncRequestListener, ResultAPI resultApi, SaveDataDownload saveDataDownload) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(saveDataDownload, "saveDataDownload");
        if (resultApi.isSuccess()) {
            asyncRequestListener.onComplete(resultApi, saveDataDownload.getResponse().getContentJSONObject());
        } else {
            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorSaveDataDownload, ""), saveDataDownload.getResponse().getContentJSONObject());
        }
        return Unit.INSTANCE;
    }

    private final int requestFriends(SocialHive.FriendsRequestParam friendsRequestParam, final SocialHive.AsyncRequestListener listener) {
        if (AuthImpl.INSTANCE.isInitialize()) {
            HiveGraph.INSTANCE.friendsRequest(friendsRequestParam, new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialHiveImpl.requestFriends$lambda$39(listener, (ResultAPI) obj, (FriendsRequest) obj2);
                }
            });
            return 0;
        }
        listener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized), null);
        return -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestFriends$lambda$39(SocialHive.AsyncRequestListener asyncRequestListener, ResultAPI resultApi, FriendsRequest friendsRequest) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(friendsRequest, "friendsRequest");
        if (resultApi.isSuccess()) {
            asyncRequestListener.onComplete(resultApi, friendsRequest.getResponse().getContentJSONObject());
        } else {
            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorFriendsRequest, ""), friendsRequest.getResponse().getContentJSONObject());
        }
        return Unit.INSTANCE;
    }

    private final int requestFriendsFacebook(SocialHive.FriendsFacebookRequestParam friendsFacebookRequestParam, final SocialHive.AsyncRequestListener listener) {
        if (AuthImpl.INSTANCE.isInitialize()) {
            HiveGraph.INSTANCE.friendsFacebookRequest(friendsFacebookRequestParam, new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda44
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialHiveImpl.requestFriendsFacebook$lambda$40(listener, (ResultAPI) obj, (FriendsFacebookRequest) obj2);
                }
            });
            return 0;
        }
        listener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized), null);
        return -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestFriendsFacebook$lambda$40(SocialHive.AsyncRequestListener asyncRequestListener, ResultAPI resultApi, FriendsFacebookRequest friendsFacebookRequest) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(friendsFacebookRequest, "friendsFacebookRequest");
        if (resultApi.isSuccess()) {
            asyncRequestListener.onComplete(resultApi, friendsFacebookRequest.getResponse().getContentJSONObject());
        } else {
            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorFriendsRequest, ""), friendsFacebookRequest.getResponse().getContentJSONObject());
        }
        return Unit.INSTANCE;
    }

    private final int requestFriendsReceiveList(SocialHive.FriendsReceiveListParam friendsReceiveListParam, final SocialHive.AsyncRequestListener listener) {
        if (AuthImpl.INSTANCE.isInitialize()) {
            HiveGraph.INSTANCE.friendsReceiveList(friendsReceiveListParam, new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialHiveImpl.requestFriendsReceiveList$lambda$41(listener, (ResultAPI) obj, (FriendsReceiveList) obj2);
                }
            });
            return 0;
        }
        listener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized), null);
        return -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestFriendsReceiveList$lambda$41(SocialHive.AsyncRequestListener asyncRequestListener, ResultAPI resultApi, FriendsReceiveList friendsReceiveList) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(friendsReceiveList, "friendsReceiveList");
        if (resultApi.isSuccess()) {
            asyncRequestListener.onComplete(resultApi, friendsReceiveList.getResponse().getContentJSONObject());
        } else {
            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorFriendsReceiveList, ""), friendsReceiveList.getResponse().getContentJSONObject());
        }
        return Unit.INSTANCE;
    }

    private final int requestFriendsReject(SocialHive.FriendsRejectRequestParam friendsRejectRequestParam, final SocialHive.AsyncRequestListener listener) {
        if (AuthImpl.INSTANCE.isInitialize()) {
            HiveGraph.INSTANCE.rejectRequest(friendsRejectRequestParam, new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialHiveImpl.requestFriendsReject$lambda$38(listener, (ResultAPI) obj, (FriendsRejectRequest) obj2);
                }
            });
            return 0;
        }
        listener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized), null);
        return -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestFriendsReject$lambda$38(SocialHive.AsyncRequestListener asyncRequestListener, ResultAPI resultApi, FriendsRejectRequest friendsRejectRequest) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(friendsRejectRequest, "friendsRejectRequest");
        if (resultApi.isSuccess()) {
            asyncRequestListener.onComplete(resultApi, friendsRejectRequest.getResponse().getContentJSONObject());
        } else {
            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorFriendsRejectRequest, ""), friendsRejectRequest.getResponse().getContentJSONObject());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int requestGuestAuth(final SocialHive.GuestAuthParam guestAuthParam, final SocialHive.AsyncRequestListener listener) {
        if (!AuthImpl.INSTANCE.isInitialize()) {
            listener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""), null);
            return -9;
        }
        if (TextUtils.isEmpty(guestAuthParam.getGuestUid())) {
            listener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorGuestAuth, ""), null);
            return -9;
        }
        Crypto crypto = Crypto.INSTANCE;
        final String strGenerateCodeVerifier = crypto.generateCodeVerifier();
        return requestGuestKey(guestAuthParam.getGuestUid(), crypto.generateCodeChallenge(strGenerateCodeVerifier), new SocialHive.AsyncRequestListener() { // from class: com.hive.social.SocialHiveImpl.requestGuestAuth.1
            @Override // com.hive.SocialHive.AsyncRequestListener
            public void onComplete(ResultAPI result, JSONObject responseJsonData) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (responseJsonData != null) {
                    SocialHive.GuestAuthParam guestAuthParam2 = guestAuthParam;
                    String str = strGenerateCodeVerifier;
                    SocialHive.AsyncRequestListener asyncRequestListener = listener;
                    if (!responseJsonData.has("public_key") || !responseJsonData.has(InAppPurchaseMetaData.KEY_SIGNATURE)) {
                        asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorGuestAuth, ""), null);
                        return;
                    }
                    SocialHive.GuestLoginParam guestLoginParam = new SocialHive.GuestLoginParam();
                    try {
                        String string = responseJsonData.getString("public_key");
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        guestLoginParam.setPublicKey(string);
                        String string2 = responseJsonData.getString(InAppPurchaseMetaData.KEY_SIGNATURE);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        guestLoginParam.setSignature(string2);
                        guestLoginParam.setGuestUid(guestAuthParam2.getGuestUid());
                        SocialHiveImpl.INSTANCE.requestGuestLogin(guestLoginParam, str, asyncRequestListener);
                    } catch (Exception e) {
                        e.printStackTrace();
                        asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorGuestAuth, ""), null);
                    }
                }
            }
        });
    }

    private final int requestGuestCreate(final SocialHive.AsyncRequestListener listener) {
        if (AuthImpl.INSTANCE.isInitialize()) {
            return requestGuestKey("", "", new SocialHive.AsyncRequestListener() { // from class: com.hive.social.SocialHiveImpl$requestGuestCreate$ret$1
                @Override // com.hive.SocialHive.AsyncRequestListener
                public void onComplete(ResultAPI result, JSONObject responseJsonData) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (responseJsonData != null) {
                        SocialHive.AsyncRequestListener asyncRequestListener = listener;
                        if (!responseJsonData.has("public_key") || !responseJsonData.has(InAppPurchaseMetaData.KEY_SIGNATURE)) {
                            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorGuestCreate, ""), null);
                            return;
                        }
                        SocialHive.GuestGenerateParam guestGenerateParam = new SocialHive.GuestGenerateParam();
                        try {
                            String string = responseJsonData.getString("public_key");
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            guestGenerateParam.setPublicKey(string);
                            String string2 = responseJsonData.getString(InAppPurchaseMetaData.KEY_SIGNATURE);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                            guestGenerateParam.setSignature(string2);
                            SocialHiveImpl.INSTANCE.requestGuestGenerate(guestGenerateParam, asyncRequestListener);
                        } catch (Exception e) {
                            e.printStackTrace();
                            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorGuestCreate, ""), null);
                        }
                    }
                }
            });
        }
        listener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""), null);
        return -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestGuestGenerate(SocialHive.GuestGenerateParam guestGenerateParam, final SocialHive.AsyncRequestListener listener) {
        if (AuthImpl.INSTANCE.isInitialize()) {
            HiveGraph.INSTANCE.requestGuestGenerate(guestGenerateParam, new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialHiveImpl.requestGuestGenerate$lambda$55(listener, (ResultAPI) obj, (GuestGenerate) obj2);
                }
            });
        } else {
            listener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestGuestGenerate$lambda$55(SocialHive.AsyncRequestListener asyncRequestListener, ResultAPI resultApi, GuestGenerate guestGenerate) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(guestGenerate, "guestGenerate");
        if (resultApi.isSuccess()) {
            asyncRequestListener.onComplete(resultApi, guestGenerate.getResponse().getJsonResponseData());
        } else {
            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorGuestGenerate, ""), guestGenerate.getResponse().getJsonResponseData());
        }
        return Unit.INSTANCE;
    }

    private final int requestGuestKey(String guestUid, String challenge, final SocialHive.AsyncRequestListener listener) {
        if (AuthImpl.INSTANCE.isInitialize()) {
            HiveGraph.INSTANCE.requestGuestKey(guestUid, challenge, new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialHiveImpl.requestGuestKey$lambda$54(listener, (ResultAPI) obj, (GuestKey) obj2);
                }
            });
            return 0;
        }
        listener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""), null);
        return -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestGuestKey$lambda$54(SocialHive.AsyncRequestListener asyncRequestListener, ResultAPI resultApi, GuestKey guestKey) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(guestKey, "guestKey");
        if (resultApi.isSuccess()) {
            asyncRequestListener.onComplete(resultApi, guestKey.getResponse().getJsonResponseData());
        } else {
            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorGuestKey, ""), guestKey.getResponse().getJsonResponseData());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestGuestLogin(final SocialHive.GuestLoginParam guestLoginParam, final String verifier, final SocialHive.AsyncRequestListener listener) {
        if (AuthImpl.INSTANCE.isInitialize()) {
            HiveGraph.INSTANCE.requestGuestLogin(guestLoginParam, new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialHiveImpl.requestGuestLogin$lambda$56(listener, verifier, guestLoginParam, (ResultAPI) obj, (GuestLogin) obj2);
                }
            });
        } else {
            listener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestGuestLogin$lambda$56(SocialHive.AsyncRequestListener asyncRequestListener, String str, SocialHive.GuestLoginParam guestLoginParam, ResultAPI resultApi, GuestLogin guestLogin) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(guestLogin, "guestLogin");
        if (resultApi.isSuccess()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SocialHiveImpl$requestGuestLogin$1$1(guestLogin, resultApi, str, guestLoginParam, asyncRequestListener, null), 3, null);
        } else {
            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorGuestLogin, ""), null);
        }
        return Unit.INSTANCE;
    }

    private final int requestGuestStatusSaveData(SocialHive.GuestStatusSaveDataParam guestStatusSaveDataParam, final SocialHive.AsyncRequestListener listener) {
        if (AuthImpl.INSTANCE.isInitialize()) {
            HiveGraph.INSTANCE.guestStatusSaveData(guestStatusSaveDataParam, new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda39
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialHiveImpl.requestGuestStatusSaveData$lambda$42(listener, (ResultAPI) obj, (GuestStatusSaveData) obj2);
                }
            });
            return 0;
        }
        listener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized), null);
        return -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestGuestStatusSaveData$lambda$42(SocialHive.AsyncRequestListener asyncRequestListener, ResultAPI resultApi, GuestStatusSaveData guestStatusSaveData) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(guestStatusSaveData, "guestStatusSaveData");
        if (resultApi.isSuccess()) {
            asyncRequestListener.onComplete(resultApi, guestStatusSaveData.getResponse().getContentJSONObject());
        } else {
            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorGuestStatusSaveData, ""), guestStatusSaveData.getResponse().getContentJSONObject());
        }
        return Unit.INSTANCE;
    }

    private final int requestMessageNotiCount(final SocialHive.AsyncRequestListener listener) {
        if (AuthImpl.INSTANCE.isInitialize()) {
            HiveGraph.INSTANCE.messageNotiCount(new Function3() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SocialHiveImpl.requestMessageNotiCount$lambda$37(listener, (ResultAPI) obj, (MessageNotiCount) obj2, (SocialHive.SocialBadge) obj3);
                }
            });
            return 0;
        }
        listener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized), null);
        return -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestMessageNotiCount$lambda$37(SocialHive.AsyncRequestListener asyncRequestListener, ResultAPI resultApi, MessageNotiCount messageNotiCount, SocialHive.SocialBadge badge) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(messageNotiCount, "messageNotiCount");
        Intrinsics.checkNotNullParameter(badge, "badge");
        if (resultApi.isSuccess()) {
            asyncRequestListener.onComplete(resultApi, messageNotiCount.getResponse().getContentJSONObject());
        } else {
            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorMessageNotiCount, ""), messageNotiCount.getResponse().getContentJSONObject());
        }
        return Unit.INSTANCE;
    }

    private final int requestSocialConnect(JSONObject jsonData, final SocialHive.AsyncRequestListener listener) {
        if (AuthImpl.INSTANCE.isInitialize()) {
            HiveGraph.INSTANCE.requestSocialConnect(jsonData, new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda42
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialHiveImpl.requestSocialConnect$lambda$57(listener, (ResultAPI) obj, (SocialConnect) obj2);
                }
            });
            return 0;
        }
        listener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""), null);
        return -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestSocialConnect$lambda$57(SocialHive.AsyncRequestListener asyncRequestListener, ResultAPI resultApi, SocialConnect socialConnect) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(socialConnect, "socialConnect");
        if (resultApi.isSuccess()) {
            asyncRequestListener.onComplete(resultApi, socialConnect.getResponse().getContentJSONObject());
        } else {
            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorGuestLogin, ""), socialConnect.getResponse().getContentJSONObject());
        }
        return Unit.INSTANCE;
    }

    private final int requestUndefinedRequest(String subPath, final SocialHive.AsyncRequestListener listener) {
        HiveGraph.INSTANCE.requestUndefinedRequest(subPath, new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SocialHiveImpl.requestUndefinedRequest$lambda$61(listener, (ResultAPI) obj, (UndefinedRequest) obj2);
            }
        });
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestUndefinedRequest$lambda$61(SocialHive.AsyncRequestListener asyncRequestListener, ResultAPI resultApi, UndefinedRequest undefinedRequest) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(undefinedRequest, "undefinedRequest");
        if (resultApi.isSuccess()) {
            asyncRequestListener.onComplete(resultApi, undefinedRequest.getResponse().getContentJSONObject());
        } else {
            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorGuestLogin, ""), undefinedRequest.getResponse().getContentJSONObject());
        }
        return Unit.INSTANCE;
    }

    private final int requestUploadImage(SocialHive.UploadImageParam uploadImageParam, final SocialHive.AsyncRequestListener listener) {
        if (AuthImpl.INSTANCE.isInitialize()) {
            HiveGraph.INSTANCE.uploadImage(uploadImageParam, new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda53
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialHiveImpl.requestUploadImage$lambda$35(listener, (ResultAPI) obj, (UploadImage) obj2);
                }
            });
            return 0;
        }
        listener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized), null);
        return -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestUploadImage$lambda$35(SocialHive.AsyncRequestListener asyncRequestListener, ResultAPI resultApi, UploadImage uploadImage) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(uploadImage, "uploadImage");
        if (resultApi.isSuccess()) {
            asyncRequestListener.onComplete(resultApi, uploadImage.getResponse().getContentJSONObject());
        } else {
            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorUploadImage, ""), uploadImage.getResponse().getContentJSONObject());
        }
        return Unit.INSTANCE;
    }

    private final int requestUploadSaveData(SocialHive.UploadSaveDataParam uploadSaveData, final SocialHive.AsyncRequestListener listener) {
        if (AuthImpl.INSTANCE.isInitialize()) {
            HiveGraph.INSTANCE.uploadSaveData(uploadSaveData, new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialHiveImpl.requestUploadSaveData$lambda$32(listener, (ResultAPI) obj, (SaveDataUpload) obj2);
                }
            });
            return 0;
        }
        listener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized), null);
        return -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestUploadSaveData$lambda$32(SocialHive.AsyncRequestListener asyncRequestListener, ResultAPI resultApi, SaveDataUpload saveDataUpload) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(saveDataUpload, "saveDataUpload");
        if (resultApi.isSuccess()) {
            asyncRequestListener.onComplete(resultApi, saveDataUpload.getResponse().getContentJSONObject());
        } else {
            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorSaveDataUpload, ""), saveDataUpload.getResponse().getContentJSONObject());
        }
        return Unit.INSTANCE;
    }

    private final int requestUserDelete(final SocialHive.AsyncRequestListener listener) {
        LoggerImpl.INSTANCE.i("requestUserDelete");
        if (AuthImpl.INSTANCE.isInitialize()) {
            HiveGraph.INSTANCE.requestUserDelete(new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialHiveImpl.requestUserDelete$lambda$60(listener, (ResultAPI) obj, (AcaUserQuitRequest) obj2);
                }
            });
            return 0;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "user/delete");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        listener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized), jSONObject);
        return -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestUserDelete$lambda$60(SocialHive.AsyncRequestListener asyncRequestListener, ResultAPI resultApi, AcaUserQuitRequest AcaUserQuitRequest) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(AcaUserQuitRequest, "AcaUserQuitRequest");
        if (resultApi.isSuccess()) {
            HiveLifecycle.INSTANCE.onSignOut();
            asyncRequestListener.onComplete(resultApi, AcaUserQuitRequest.getResponse().getContentJSONObject());
        } else {
            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVEResponseFail, ""), AcaUserQuitRequest.getResponse().getContentJSONObject());
        }
        return Unit.INSTANCE;
    }

    private final int requestUserMeNotification(final SocialHive.AsyncRequestListener listener) {
        if (AuthImpl.INSTANCE.isInitialize()) {
            HiveGraph.INSTANCE.userMeNotification(new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda37
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialHiveImpl.requestUserMeNotification$lambda$43(listener, (ResultAPI) obj, (UserMeNotification) obj2);
                }
            });
            return 0;
        }
        listener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized), null);
        return -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestUserMeNotification$lambda$43(SocialHive.AsyncRequestListener asyncRequestListener, ResultAPI resultApi, UserMeNotification userMeNotification) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(userMeNotification, "userMeNotification");
        if (resultApi.isSuccess()) {
            asyncRequestListener.onComplete(resultApi, userMeNotification.getResponse().getContentJSONObject());
        } else {
            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorUserMeNotification, ""), userMeNotification.getResponse().getContentJSONObject());
        }
        return Unit.INSTANCE;
    }

    private final int requestUserProfile(final String subPath, final JSONObject jsonData, final SocialHive.ProfileListener listener) {
        LoggerImpl.INSTANCE.i("requestUserProfile");
        if (AuthImpl.INSTANCE.isInitialize()) {
            new Thread(new Runnable() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    SocialHiveImpl.requestUserProfile$lambda$30(subPath, jsonData, listener);
                }
            }).start();
            return 0;
        }
        listener.onProfile(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""), null);
        return -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestUserProfile$lambda$30(String str, JSONObject jSONObject, final SocialHive.ProfileListener profileListener) {
        HiveGraph.INSTANCE.userEx(str, jSONObject, new Function3() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda47
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SocialHiveImpl.requestUserProfile$lambda$30$lambda$29(profileListener, (ResultAPI) obj, (UserEx) obj2, (SocialHive.ProfileHive) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestUserProfile$lambda$30$lambda$29(final SocialHive.ProfileListener profileListener, final ResultAPI resultAPI, UserEx userEx, final SocialHive.ProfileHive profileHive) {
        String uid;
        Intrinsics.checkNotNullParameter(resultAPI, "resultAPI");
        Intrinsics.checkNotNullParameter(userEx, "userEx");
        if (resultAPI.isFailure()) {
            profileListener.onProfile(new ResultAPI(-8, ResultAPI.Code.SocialHIVEResponseFailGetProfiles, userEx.getResponse().getErrorMsg()), null);
            return Unit.INSTANCE;
        }
        if (profileHive == null || (uid = profileHive.getUid()) == null || uid.length() == 0) {
            profileListener.onProfile(new ResultAPI(ResultAPI.Code.SocialHIVEResponseFailGetProfiles, "User profile info is null or empty."), null);
            return Unit.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(profileHive.getUid());
        HiveGraph.INSTANCE.profileGetUserEx(arrayList, new Function3() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SocialHiveImpl.requestUserProfile$lambda$30$lambda$29$lambda$28(profileHive, profileListener, resultAPI, ((Integer) obj).intValue(), (ProfileGetUser) obj2, (ArrayList) obj3);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestUserProfile$lambda$30$lambda$29$lambda$28(SocialHive.ProfileHive profileHive, SocialHive.ProfileListener profileListener, ResultAPI resultAPI, int i, ProfileGetUser profileGetUser, ArrayList profileGetUserList) {
        Intrinsics.checkNotNullParameter(profileGetUser, "profileGetUser");
        Intrinsics.checkNotNullParameter(profileGetUserList, "profileGetUserList");
        if (i == 0) {
            Iterator it = profileGetUserList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                SocialHive.ProfileGetUser profileGetUser2 = (SocialHive.ProfileGetUser) next;
                if (StringsKt.equals$default(profileHive.getUid(), profileGetUser2.getUserId(), false, 2, null)) {
                    profileHive.setProfileImageUrl(profileGetUser2.getProfileImg());
                    profileHive.setUserName(profileGetUser2.getProfileName());
                }
            }
        }
        HiveUserCache.INSTANCE.addProfile(profileHive);
        profileListener.onProfile(resultAPI, CollectionsKt.arrayListOf(profileHive));
        return Unit.INSTANCE;
    }

    private final int requestUsersInfoWithUidList(final String[] uidList, final SocialHive.ProfileListener listener) {
        LoggerImpl.INSTANCE.i("requestUsersInfoWithUidList");
        if (!AuthImpl.INSTANCE.isInitialize()) {
            listener.onProfile(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""), null);
            return -9;
        }
        if (uidList == null || uidList.length == 0) {
            listener.onProfile(new ResultAPI(-1, ResultAPI.Code.SocialHIVEInvalidParamGetProfiles, "UidList is null or empty"), null);
            return -9;
        }
        new Thread(new Runnable() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda41
            @Override // java.lang.Runnable
            public final void run() {
                SocialHiveImpl.requestUsersInfoWithUidList$lambda$24(uidList, listener);
            }
        }).start();
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestUsersInfoWithUidList$lambda$24(String[] strArr, final SocialHive.ProfileListener profileListener) {
        final ArrayMap arrayMap = new ArrayMap();
        Iterator it = ArrayIteratorKt.iterator(strArr);
        while (it.hasNext()) {
            arrayMap.put((String) it.next(), "");
        }
        HiveGraph hiveGraph = HiveGraph.INSTANCE;
        Set setKeySet = arrayMap.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        hiveGraph.usersInfo(setKeySet, new Function3() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SocialHiveImpl.requestUsersInfoWithUidList$lambda$24$lambda$23(profileListener, arrayMap, (ResultAPI) obj, (UsersInfo) obj2, (ArrayList) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestUsersInfoWithUidList$lambda$24$lambda$23(final SocialHive.ProfileListener profileListener, final ArrayMap arrayMap, ResultAPI resultApi, UsersInfo users, final ArrayList profileList) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(users, "users");
        Intrinsics.checkNotNullParameter(profileList, "profileList");
        if (resultApi.isFailure()) {
            profileListener.onProfile(new ResultAPI(-8, ResultAPI.Code.SocialHIVEResponseFailGetProfiles, users.getResponse().getErrorMsg()), null);
            return Unit.INSTANCE;
        }
        if (profileList.size() == 0) {
            profileListener.onProfile(new ResultAPI(ResultAPI.Code.SocialHIVEResponseFailGetProfiles, "ProfileList is empty."), null);
            return Unit.INSTANCE;
        }
        new Thread(new Runnable() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                SocialHiveImpl.requestUsersInfoWithUidList$lambda$24$lambda$23$lambda$22(arrayMap, profileList, profileListener);
            }
        }).start();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestUsersInfoWithUidList$lambda$24$lambda$23$lambda$22(ArrayMap arrayMap, final ArrayList arrayList, SocialHive.ProfileListener profileListener) {
        int size = arrayMap.size() > 300 ? 1 + (arrayMap.size() / 300) : 1;
        LoggerImpl.INSTANCE.i("[SocialHiveImpl] requestUsersInfoWithUidList, uidToVidMap.size : " + arrayMap.size() + ", uidListPages : " + size);
        for (int i = 0; i < size; i++) {
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.i("[SocialHiveImpl] requestUsersInfoWithUidList, pageCnt : " + i);
            SocialHiveImpl socialHiveImpl = INSTANCE;
            Set setKeySet = arrayMap.keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
            ArrayList<String> pagedUidList = socialHiveImpl.getPagedUidList((String[]) setKeySet.toArray(new String[0]), i, 300);
            loggerImpl.dL("[SocialHiveImpl] requestUsersInfoWithUidList, targetUidList.size : " + pagedUidList.size());
            if (!pagedUidList.isEmpty()) {
                HiveGraph.INSTANCE.profileGetUserEx(pagedUidList, new Function3() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SocialHiveImpl.requestUsersInfoWithUidList$lambda$24$lambda$23$lambda$22$lambda$21(arrayList, ((Integer) obj).intValue(), (ProfileGetUser) obj2, (ArrayList) obj3);
                    }
                });
            }
        }
        HiveUserCache.INSTANCE.addProfiles(arrayList);
        profileListener.onProfile(new ResultAPI(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestUsersInfoWithUidList$lambda$24$lambda$23$lambda$22$lambda$21(ArrayList arrayList, int i, ProfileGetUser profileGetUser, ArrayList profileGetUserList) {
        Intrinsics.checkNotNullParameter(profileGetUser, "profileGetUser");
        Intrinsics.checkNotNullParameter(profileGetUserList, "profileGetUserList");
        if (i == 0) {
            Iterator it = profileGetUserList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                SocialHive.ProfileGetUser profileGetUser2 = (SocialHive.ProfileGetUser) next;
                Iterator it2 = arrayList.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    SocialHive.ProfileHive profileHive = (SocialHive.ProfileHive) next2;
                    if (StringsKt.equals$default(profileHive.getUid(), profileGetUser2.getUserId(), false, 2, null)) {
                        profileHive.setProfileImageUrl(profileGetUser2.getProfileImg());
                        profileHive.setUserName(profileGetUser2.getProfileName());
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestUsersInfoWithVidList$lambda$20(String[] strArr, final SocialHive.ProfileListener profileListener) {
        final ArrayList<String> arrayList = new ArrayList<>(ArraysKt.toMutableList(strArr));
        final ArrayMap arrayMap = new ArrayMap();
        Iterator it = ArrayIteratorKt.iterator(strArr);
        while (it.hasNext()) {
            String str = (String) it.next();
            SocialHive.ProfileHive profileByVID = HiveUserCache.INSTANCE.getProfileByVID(str);
            if (profileByVID != null) {
                arrayList.remove(str);
                arrayMap.put(profileByVID.getUid(), str);
            }
        }
        if (!arrayList.isEmpty()) {
            GetUid getUid = (GetUid) AuthNetwork.LoginCenter.INSTANCE.getUid(arrayList).request();
            if (!getUid.getResponse().isSuccess()) {
                profileListener.onProfile(new ResultAPI(-8, ResultAPI.Code.SocialHIVEResponseFailGetProfiles, getUid.getResponse().getError()), null);
                return;
            }
            if (arrayList.size() != getUid.getResponse().getUidList().size()) {
                profileListener.onProfile(new ResultAPI(-1, ResultAPI.Code.SocialHIVEInvalidParamGetProfiles, "Invalid vidlist"), null);
                return;
            }
            int size = getUid.getResponse().getUidList().size();
            for (int i = 0; i < size; i++) {
                String str2 = getUid.getResponse().getUidList().get(i);
                String str3 = arrayList.get(i);
                if (!StringsKt.isBlank(str2) && !Intrinsics.areEqual(str2, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    arrayMap.put(str2, str3);
                }
            }
        }
        HiveGraph hiveGraph = HiveGraph.INSTANCE;
        Set setKeySet = arrayMap.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        hiveGraph.usersInfo(setKeySet, new Function3() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SocialHiveImpl.requestUsersInfoWithVidList$lambda$20$lambda$19(profileListener, arrayMap, arrayList, (ResultAPI) obj, (UsersInfo) obj2, (ArrayList) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestUsersInfoWithVidList$lambda$20$lambda$19(final SocialHive.ProfileListener profileListener, final ArrayMap arrayMap, final ArrayList arrayList, ResultAPI resultApi, UsersInfo users, final ArrayList profileList) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(users, "users");
        Intrinsics.checkNotNullParameter(profileList, "profileList");
        if (resultApi.isFailure()) {
            profileListener.onProfile(new ResultAPI(-8, ResultAPI.Code.SocialHIVEResponseFailGetProfiles, users.getResponse().getErrorMsg()), null);
            return Unit.INSTANCE;
        }
        if (profileList.size() == 0) {
            profileListener.onProfile(new ResultAPI(ResultAPI.Code.SocialHIVEResponseFailGetProfiles, "ProfileList is empty."), null);
            return Unit.INSTANCE;
        }
        new Thread(new Runnable() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                SocialHiveImpl.requestUsersInfoWithVidList$lambda$20$lambda$19$lambda$18(arrayMap, arrayList, profileListener, profileList);
            }
        }).start();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestUsersInfoWithVidList$lambda$20$lambda$19$lambda$18(final ArrayMap arrayMap, final ArrayList arrayList, SocialHive.ProfileListener profileListener, final ArrayList arrayList2) {
        final ArrayList<SocialHive.ProfileHive> arrayList3 = new ArrayList<>();
        int size = arrayMap.size() > 300 ? 1 + (arrayMap.size() / 300) : 1;
        for (int i = 0; i < size; i++) {
            SocialHiveImpl socialHiveImpl = INSTANCE;
            Set setKeySet = arrayMap.keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
            ArrayList pagedUidList$default = getPagedUidList$default(socialHiveImpl, (String[]) setKeySet.toArray(new String[0]), i, 0, 4, null);
            if (!pagedUidList$default.isEmpty()) {
                HiveGraph.INSTANCE.profileGetUser(pagedUidList$default, new Function3() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda58
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SocialHiveImpl.requestUsersInfoWithVidList$lambda$20$lambda$19$lambda$18$lambda$17(arrayList2, arrayMap, arrayList3, arrayList, (ResultAPI) obj, (ProfileGetUser) obj2, (ArrayList) obj3);
                    }
                });
            }
        }
        HiveUserCache.INSTANCE.addProfiles(arrayList3);
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                String str = (String) it.next();
                SocialHive.ProfileHive profileHive = new SocialHive.ProfileHive();
                profileHive.setVid(str);
                profileHive.setUid(null);
                arrayList3.add(profileHive);
            }
        }
        profileListener.onProfile(new ResultAPI(), arrayList3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit requestUsersInfoWithVidList$lambda$20$lambda$19$lambda$18$lambda$17(ArrayList arrayList, ArrayMap arrayMap, ArrayList arrayList2, ArrayList arrayList3, ResultAPI resultApi, ProfileGetUser profileGetUser, ArrayList profileGetUserList) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(profileGetUser, "profileGetUser");
        Intrinsics.checkNotNullParameter(profileGetUserList, "profileGetUserList");
        if (resultApi.isSuccess()) {
            Iterator it = profileGetUserList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                SocialHive.ProfileGetUser profileGetUser2 = (SocialHive.ProfileGetUser) next;
                Iterator it2 = arrayList.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    SocialHive.ProfileHive profileHive = (SocialHive.ProfileHive) next2;
                    if (StringsKt.equals$default(profileHive.getUid(), profileGetUser2.getUserId(), false, 2, null)) {
                        profileHive.setProfileImageUrl(profileGetUser2.getProfileImg());
                        profileHive.setUserName(profileGetUser2.getProfileName());
                        profileHive.setVid((String) arrayMap.get(profileHive.getUid()));
                        arrayList2.add(profileHive);
                        arrayList3.remove(profileHive.getVid());
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    private final int requestWallWrite(SocialHive.WallWriteParam wallWriteParam, final SocialHive.AsyncRequestListener listener) {
        if (AuthImpl.INSTANCE.isInitialize()) {
            HiveGraph.INSTANCE.wallWrite(wallWriteParam, new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda56
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialHiveImpl.requestWallWrite$lambda$36(listener, (ResultAPI) obj, (WallWrite) obj2);
                }
            });
            return 0;
        }
        listener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized), null);
        return -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestWallWrite$lambda$36(SocialHive.AsyncRequestListener asyncRequestListener, ResultAPI resultApi, WallWrite wallWrite) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(wallWrite, "wallWrite");
        if (resultApi.isSuccess()) {
            asyncRequestListener.onComplete(resultApi, wallWrite.getResponse().getContentJSONObject());
        } else {
            asyncRequestListener.onComplete(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorWallWrite, ""), wallWrite.getResponse().getContentJSONObject());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendInvitationMessage$lambda$52(SocialHive.SendMessageListener sendMessageListener, ResultAPI resultApi, MessageWrite messageWrite) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(messageWrite, "messageWrite");
        if (resultApi.isSuccess()) {
            sendMessageListener.onSendMessage(resultApi);
        } else {
            sendMessageListener.onSendMessage(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorSendInvitationMessage, ""));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendMessage$lambda$46(SocialHive.MessageContent messageContent, final SocialHive.SendMessageListener sendMessageListener) {
        if (StringsKt.isBlank(messageContent.getUid())) {
            if (StringsKt.isBlank(messageContent.getVid())) {
                sendMessageListener.onSendMessage(new ResultAPI(-1, ResultAPI.Code.SocialHIVEInvalidParamSendMessage, "uid or vid must input."));
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>(StringsKt.split$default((CharSequence) messageContent.getVid(), new String[]{","}, false, 0, 6, (Object) null));
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                HiveUserCache hiveUserCache = HiveUserCache.INSTANCE;
                Intrinsics.checkNotNull(next);
                SocialHive.ProfileHive profileByVID = hiveUserCache.getProfileByVID(next);
                if (profileByVID != null) {
                    arrayList.remove(next);
                    String uid = profileByVID.getUid();
                    arrayList2.add(uid != null ? uid : "");
                }
            }
            if (!arrayList.isEmpty()) {
                GetUid getUid = (GetUid) AuthNetwork.LoginCenter.INSTANCE.getUid(arrayList).request();
                if (!getUid.getResponse().isSuccess()) {
                    sendMessageListener.onSendMessage(new ResultAPI(ResultAPI.Code.SocialHIVEResponseFailSendMessage, ""));
                    return;
                } else if (arrayList.size() == getUid.getResponse().getUidList().size()) {
                    for (String str : getUid.getResponse().getUidList()) {
                        Intrinsics.checkNotNullExpressionValue(str, "next(...)");
                        arrayList2.add(str);
                    }
                }
            }
            messageContent.setUid(CollectionsKt.joinToString$default(arrayList2, ",", null, null, 0, null, null, 62, null));
        }
        if (StringsKt.isBlank(messageContent.getUid())) {
            sendMessageListener.onSendMessage(new ResultAPI(-1, ResultAPI.Code.SocialHIVEInvalidParamSendMessage, "uid can not found in cache or at server. you may correct value"));
        } else {
            HiveGraph.INSTANCE.messageWrite(messageContent, false, new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialHiveImpl.sendMessage$lambda$46$lambda$45(sendMessageListener, (ResultAPI) obj, (MessageWrite) obj2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendMessage$lambda$46$lambda$45(SocialHive.SendMessageListener sendMessageListener, ResultAPI resultApi, MessageWrite messageWrite) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(messageWrite, "messageWrite");
        if (resultApi.isSuccess()) {
            sendMessageListener.onSendMessage(resultApi);
        } else {
            sendMessageListener.onSendMessage(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorSendMessage, ""));
        }
        return Unit.INSTANCE;
    }

    private final int sendMessageExWithUid(SocialHive.MessageContent messageContent, SocialHive.SendMessageListenerEx listener) {
        if (!AuthImpl.INSTANCE.isInitialize()) {
            listener.onSendMessage(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""), null);
            return -9;
        }
        if (StringsKt.isBlank(messageContent.getUid()) || StringsKt.isBlank(messageContent.getMessage())) {
            listener.onSendMessage(new ResultAPI(-1, ResultAPI.Code.SocialHIVEInvalidParamSendMessage, "uid and text must input."), null);
            return -9;
        }
        sendMessageWithUidParam(messageContent, listener);
        return 0;
    }

    private final void sendMessageWithParam(final SocialHive.MessageContent messageContent, final SocialHive.SendMessageListenerEx listener) {
        new Thread(new Runnable() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                SocialHiveImpl.sendMessageWithParam$lambda$48(messageContent, listener);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendMessageWithParam$lambda$48(SocialHive.MessageContent messageContent, final SocialHive.SendMessageListenerEx sendMessageListenerEx) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (!StringsKt.isBlank(messageContent.getVid())) {
            ArrayList<String> arrayList2 = new ArrayList<>(StringsKt.split$default((CharSequence) messageContent.getVid(), new String[]{","}, false, 0, 6, (Object) null));
            GetUid getUid = (GetUid) AuthNetwork.LoginCenter.INSTANCE.getUid(arrayList2).request();
            if (!getUid.getResponse().isSuccess()) {
                sendMessageListenerEx.onSendMessage(new ResultAPI(ResultAPI.Code.SocialHIVEResponseFailSendMessage, ""), null);
                return;
            }
            if (getUid.getResponse().getUidList().size() > 0 && getUid.getResponse().getUidList().size() == arrayList2.size()) {
                int size = getUid.getResponse().getUidList().size();
                while (i < size) {
                    arrayList.add(getUid.getResponse().getUidList().get(i));
                    if (!TextUtils.isEmpty(getUid.getResponse().getUidList().get(i)) && !getUid.getResponse().getUidList().get(i).equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        uidToVid.put(getUid.getResponse().getUidList().get(i), arrayList2.get(i));
                    }
                    i++;
                }
            }
        } else if (!StringsKt.isBlank(messageContent.getUid())) {
            ArrayList<String> arrayList3 = new ArrayList<>(StringsKt.split$default((CharSequence) messageContent.getUid(), new String[]{","}, false, 0, 6, (Object) null));
            GetVid getVid = (GetVid) AuthNetwork.LoginCenter.INSTANCE.getVid(arrayList3).request();
            if (!getVid.getResponse().isSuccess()) {
                sendMessageListenerEx.onSendMessage(new ResultAPI(ResultAPI.Code.SocialHIVEResponseFailSendMessage, ""), null);
                return;
            }
            if (getVid.getResponse().getVidList().size() <= 0 || getVid.getResponse().getVidList().size() != arrayList3.size()) {
                Iterator<String> it = arrayList3.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            } else {
                int size2 = getVid.getResponse().getVidList().size();
                while (i < size2) {
                    if (!TextUtils.isEmpty(getVid.getResponse().getVidList().get(i)) && !getVid.getResponse().getVidList().get(i).equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        uidToVid.put(arrayList3.get(i), getVid.getResponse().getVidList().get(i));
                        arrayList.add(arrayList3.get(i));
                    }
                    i++;
                }
            }
        }
        try {
            messageContent.setUid(CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null));
            if (StringsKt.isBlank(messageContent.getUid())) {
                sendMessageListenerEx.onSendMessage(new ResultAPI(-1, ResultAPI.Code.SocialHIVEInvalidParamSendMessage, "uid can not found in cache or at server. you may correct value"), null);
            } else {
                HiveGraph.INSTANCE.messageWrite(messageContent, messageContent.getInvite(), new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda35
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SocialHiveImpl.sendMessageWithParam$lambda$48$lambda$47(sendMessageListenerEx, (ResultAPI) obj, (MessageWrite) obj2);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            sendMessageListenerEx.onSendMessage(new ResultAPI(ResultAPI.Code.SocialHIVEResponseFailSendMessage, "invalid uid list"), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendMessageWithParam$lambda$48$lambda$47(SocialHive.SendMessageListenerEx sendMessageListenerEx, ResultAPI resultApi, MessageWrite messageWrite) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(messageWrite, "messageWrite");
        if (resultApi.isSuccess()) {
            sendMessageListenerEx.onSendMessage(resultApi, messageWrite.getResponse().getContentJSONObject());
        } else {
            sendMessageListenerEx.onSendMessage(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorSendMessage, ""), null);
        }
        return Unit.INSTANCE;
    }

    private final void sendMessageWithUidParam(final SocialHive.MessageContent messageContent, final SocialHive.SendMessageListenerEx listener) {
        new Thread(new Runnable() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SocialHiveImpl.sendMessageWithUidParam$lambda$50(messageContent, listener);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendMessageWithUidParam$lambda$50(SocialHive.MessageContent messageContent, final SocialHive.SendMessageListenerEx sendMessageListenerEx) {
        HiveGraph.INSTANCE.messageWrite(messageContent, messageContent.getInvite(), new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda46
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SocialHiveImpl.sendMessageWithUidParam$lambda$50$lambda$49(sendMessageListenerEx, (ResultAPI) obj, (MessageWrite) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendMessageWithUidParam$lambda$50$lambda$49(SocialHive.SendMessageListenerEx sendMessageListenerEx, ResultAPI resultApi, MessageWrite messageWrite) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(messageWrite, "messageWrite");
        if (resultApi.isSuccess()) {
            sendMessageListenerEx.onSendMessage(resultApi, messageWrite.getResponse().getContentJSONObject());
        } else {
            sendMessageListenerEx.onSendMessage(new ResultAPI(ResultAPI.Code.SocialHIVENetworkErrorSendMessage, ""), null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setMyProfile$lambda$1(SocialHive.ProfileListener profileListener, ResultAPI resultApi, UserModify userModify) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(userModify, "userModify");
        if (resultApi.isSuccess()) {
            profileListener.onProfile(new ResultAPI(0, ResultAPI.Code.Success, ""), null);
        } else {
            profileListener.onProfile(new ResultAPI(ResultAPI.Code.SocialHIVEResponseFailSetMyProfile, resultApi.getMessage()), null);
        }
        return Unit.INSTANCE;
    }

    private final int setMyProfileEx(String displayName, final SocialHive.ProfileListener listener) {
        if (!AuthImpl.INSTANCE.isInitialize()) {
            listener.onProfile(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""), null);
            return -9;
        }
        if (displayName == null || StringsKt.isBlank(displayName)) {
            listener.onProfile(new ResultAPI(-1, ResultAPI.Code.SocialHIVEResponseFailSetMyProfile, ""), null);
            return 0;
        }
        HiveGraph.INSTANCE.userModify(displayName, new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SocialHiveImpl.setMyProfileEx$lambda$2(listener, (ResultAPI) obj, (UserModify) obj2);
            }
        });
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setMyProfileEx$lambda$2(SocialHive.ProfileListener profileListener, ResultAPI resultApi, UserModify userModify) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        Intrinsics.checkNotNullParameter(userModify, "userModify");
        if (resultApi.isSuccess()) {
            profileListener.onProfile(new ResultAPI(0, ResultAPI.Code.Success, ""), null);
        } else {
            profileListener.onProfile(new ResultAPI(ResultAPI.Code.SocialHIVEResponseFailSetMyProfile, resultApi.getMessage()), null);
        }
        return Unit.INSTANCE;
    }

    private final void showGuestApiDialog(final String url, final SocialHive.ShowHiveDialogDataListener listener) {
        Intent intent = new Intent();
        intent.putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, false);
        HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), intent, new OnActivityLifecycle() { // from class: com.hive.social.SocialHiveImpl.showGuestApiDialog.1
            public SocialDialog dialog;

            public final SocialDialog getDialog() {
                SocialDialog socialDialog = this.dialog;
                if (socialDialog != null) {
                    return socialDialog;
                }
                Intrinsics.throwUninitializedPropertyAccessException("dialog");
                return null;
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public boolean onBackPressed() {
                return getDialog().onBackPressed();
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onCreate(final Activity activity, Bundle savedInstanceState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                super.onCreate(activity, savedInstanceState);
                final SocialHive.ShowHiveDialogDataListener showHiveDialogDataListener = listener;
                setDialog(new SocialDialog(activity, url, false, SocialHiveImpl.isClear, new SocialHive.ShowHiveDialogDataListener() { // from class: com.hive.social.SocialHiveImpl$showGuestApiDialog$1$onCreate$socialDialogListener$1
                    @Override // com.hive.SocialHive.ShowHiveDialogDataListener
                    public void onShowHiveDialogWithData(ResultAPI result, JSONObject jsonData) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        showHiveDialogDataListener.onShowHiveDialogWithData(result, SocialHiveImpl.INSTANCE.getSocialDialogResultJson(result, jsonData));
                        activity.finish();
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

            public final void setDialog(SocialDialog socialDialog) {
                Intrinsics.checkNotNullParameter(socialDialog, "<set-?>");
                this.dialog = socialDialog;
            }
        });
    }

    private final void showHiveSocialDialog(final String subpath, final SocialHive.ShowHiveDialogDataListener listener) {
        Intent intent = new Intent();
        intent.putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, true);
        HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), intent, new OnActivityLifecycle() { // from class: com.hive.social.SocialHiveImpl.showHiveSocialDialog.1
            private AuthSocialView authSocialView;
            private SocialDialog dialog;

            public final AuthSocialView getAuthSocialView() {
                return this.authSocialView;
            }

            public final SocialDialog getDialog() {
                return this.dialog;
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public boolean onBackPressed() {
                SocialDialog socialDialog = this.dialog;
                if (socialDialog != null) {
                    return socialDialog.onBackPressed();
                }
                AuthSocialView authSocialView = this.authSocialView;
                if (authSocialView != null) {
                    return authSocialView.onBackPressed();
                }
                return true;
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onCreate(final Activity activity, Bundle savedInstanceState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                super.onCreate(activity, savedInstanceState);
                final SocialHive.ShowHiveDialogDataListener showHiveDialogDataListener = listener;
                SocialHive.ShowHiveDialogDataListener showHiveDialogDataListener2 = new SocialHive.ShowHiveDialogDataListener() { // from class: com.hive.social.SocialHiveImpl$showHiveSocialDialog$1$onCreate$socialDialogListener$1
                    @Override // com.hive.SocialHive.ShowHiveDialogDataListener
                    public void onShowHiveDialogWithData(ResultAPI result, JSONObject jsonData) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        showHiveDialogDataListener.onShowHiveDialogWithData(result, SocialHiveImpl.INSTANCE.getSocialDialogResultJson(result, jsonData));
                        activity.finish();
                    }
                };
                if (Intrinsics.areEqual(subpath, SocialHive.HiveDialogType.MYINQUIRY.getValue()) || Intrinsics.areEqual(subpath, SocialHive.HiveDialogType.INQUIRY.getValue())) {
                    AuthSocialView authSocialView = new AuthSocialView(activity, subpath, showHiveDialogDataListener2);
                    this.authSocialView = authSocialView;
                    authSocialView.show();
                } else {
                    SocialDialog socialDialog = new SocialDialog(activity, SocialHiveImpl.INSTANCE.getUrlWithSubpath(subpath), true, showHiveDialogDataListener2);
                    this.dialog = socialDialog;
                    socialDialog.show();
                }
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onDestroy(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (!getIsCalledFinish()) {
                    SocialDialog socialDialog = this.dialog;
                    if (socialDialog != null) {
                        socialDialog.dismiss();
                    }
                    AuthSocialView authSocialView = this.authSocialView;
                    if (authSocialView != null) {
                        authSocialView.dismiss();
                    }
                }
                super.onDestroy(activity);
            }

            public final void setAuthSocialView(AuthSocialView authSocialView) {
                this.authSocialView = authSocialView;
            }

            public final void setDialog(SocialDialog socialDialog) {
                this.dialog = socialDialog;
            }
        });
    }

    private final boolean showTransparentView(JSONObject jsonData) {
        return jsonData != null && jsonData.has("showGuestLogin");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int asyncRequest(final String subPath, final JSONObject jsonData, final SocialHive.AsyncRequestListener listener) {
        Intrinsics.checkNotNullParameter(subPath, "subPath");
        Intrinsics.checkNotNullParameter(listener, "listener");
        switch (subPath.hashCode()) {
            case -1909095819:
                if (subPath.equals("user/me/notifications")) {
                    return requestUserMeNotification(listener);
                }
                break;
            case -1805839339:
                if (subPath.equals("friends/request")) {
                    if (jsonData == null) {
                        return -9;
                    }
                    SocialHive.FriendsRequestParam friendsRequestParam = new SocialHive.FriendsRequestParam();
                    try {
                        friendsRequestParam.toDataModel(jsonData);
                        return requestFriends(friendsRequestParam, listener);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return -9;
                    }
                }
                break;
            case -1798510721:
                if (subPath.equals("guest/auth")) {
                    if (jsonData == null) {
                        return -9;
                    }
                    SocialHive.GuestAuthParam guestAuthParam = new SocialHive.GuestAuthParam();
                    try {
                        guestAuthParam.toDataModel(jsonData);
                        return requestGuestAuth(guestAuthParam, listener);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return -9;
                    }
                }
                break;
            case -1757494765:
                if (subPath.equals("savedata/delete")) {
                    return requestDeleteSaveData(listener);
                }
                break;
            case -1756750637:
                if (subPath.equals("aca_user_quit_request")) {
                    return requestUserDelete(listener);
                }
                break;
            case -1737912045:
                if (subPath.equals("guest/create")) {
                    return requestGuestCreate(listener);
                }
                break;
            case -1407659311:
                if (subPath.equals("message/noticount")) {
                    return requestMessageNotiCount(listener);
                }
                break;
            case -1260631447:
                if (subPath.equals("savedata/upload")) {
                    if (jsonData == null) {
                        return -9;
                    }
                    SocialHive.UploadSaveDataParam uploadSaveDataParam = new SocialHive.UploadSaveDataParam();
                    try {
                        uploadSaveDataParam.toDataModel(jsonData);
                        return requestUploadSaveData(uploadSaveDataParam, listener);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return -9;
                    }
                }
                break;
            case -1135894565:
                if (subPath.equals("device/registered")) {
                    return getDeviceRegistered(listener);
                }
                break;
            case -637387326:
                if (subPath.equals(SocialKeys.PeppermintRequestUrlPath.PEPPERMINT_ASYNC_API_PGS_SET_AUTO_LOGIN)) {
                    return requestAcaLoginPlayGamesService(jsonData, listener);
                }
                break;
            case -600094315:
                if (subPath.equals(NativeProtocol.AUDIENCE_FRIENDS)) {
                    return getFriendsEx(SocialHive.FriendType.ALL_GAME, null, new SocialHive.ProfileListener() { // from class: com.hive.social.SocialHiveImpl.asyncRequest.4
                        @Override // com.hive.SocialHive.ProfileListener
                        public void onProfile(ResultAPI result, ArrayList<SocialHive.ProfileHive> profileList) throws JSONException {
                            Intrinsics.checkNotNullParameter(result, "result");
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, result.getErrorCode());
                                jSONObject.put("error_msg", result.getErrorMessage());
                                jSONObject.put("type", subPath);
                                jSONObject = SocialHiveImpl.INSTANCE.getJSONFromProfileHive("friend", jSONObject, profileList);
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_INVALID_JSON);
                                jSONObject.put("error_msg", "json parse error");
                                jSONObject.put("type", subPath);
                            }
                            listener.onComplete(result, jSONObject);
                        }
                    });
                }
                break;
            case -422212880:
                if (subPath.equals("savedata/download")) {
                    return requestDownloadSaveData(listener);
                }
                break;
            case -257754929:
                if (subPath.equals("user/modify_info")) {
                    if (jsonData == null) {
                        return -9;
                    }
                    try {
                        if (!jsonData.has("comment") || jsonData.optString("comment") == null) {
                            return -9;
                        }
                        return INSTANCE.setMyProfileEx(jsonData.optString("comment"), new SocialHive.ProfileListener() { // from class: com.hive.social.SocialHiveImpl$asyncRequest$3$1
                            @Override // com.hive.SocialHive.ProfileListener
                            public void onProfile(ResultAPI result, ArrayList<SocialHive.ProfileHive> profileList) throws JSONException {
                                Intrinsics.checkNotNullParameter(result, "result");
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, result.getErrorCode());
                                    jSONObject.put("error_msg", result.getErrorMessage());
                                    jSONObject.put("type", subPath);
                                    jSONObject.put("comment", jsonData.optString("comment"));
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                    jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_INVALID_JSON);
                                    jSONObject.put("error_msg", "json parse error");
                                    jSONObject.put("type", subPath);
                                }
                                listener.onComplete(result, jSONObject);
                            }
                        });
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return -9;
                    }
                }
                break;
            case -147178916:
                if (subPath.equals("user/me")) {
                    return getMyProfileEx(new SocialHive.ProfileListener() { // from class: com.hive.social.SocialHiveImpl.asyncRequest.1
                        @Override // com.hive.SocialHive.ProfileListener
                        public void onProfile(ResultAPI result, ArrayList<SocialHive.ProfileHive> profileList) throws JSONException {
                            Intrinsics.checkNotNullParameter(result, "result");
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, result.getErrorCode());
                                jSONObject.put("error_msg", result.getErrorMessage());
                                jSONObject.put("type", subPath);
                                jSONObject = SocialHiveImpl.INSTANCE.getJSONFromProfileHive("user", jSONObject, profileList);
                            } catch (Exception e5) {
                                e5.printStackTrace();
                                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_INVALID_JSON);
                                jSONObject.put("error_msg", "json parse error");
                                jSONObject.put("type", subPath);
                            }
                            listener.onComplete(result, jSONObject);
                        }
                    });
                }
                break;
            case 111578632:
                if (subPath.equals("users")) {
                    if (jsonData == null) {
                        return -9;
                    }
                    try {
                        if (!jsonData.has("uid_list")) {
                            return -9;
                        }
                        JSONArray jSONArray = jsonData.getJSONArray("uid_list");
                        Intrinsics.checkNotNullExpressionValue(jSONArray, "getJSONArray(...)");
                        int length = jSONArray.length();
                        String[] strArr = new String[length];
                        for (int i = 0; i < length; i++) {
                            strArr[i] = "";
                        }
                        int length2 = jSONArray.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            String strOptString = jSONArray.optString(i2);
                            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                            strArr[i2] = strOptString;
                        }
                        return INSTANCE.requestUsersInfoWithUidList(strArr, new SocialHive.ProfileListener() { // from class: com.hive.social.SocialHiveImpl$asyncRequest$2$1
                            @Override // com.hive.SocialHive.ProfileListener
                            public void onProfile(ResultAPI result, ArrayList<SocialHive.ProfileHive> profileList) throws JSONException {
                                Intrinsics.checkNotNullParameter(result, "result");
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, result.getErrorCode());
                                    jSONObject.put("error_msg", result.getErrorMessage());
                                    jSONObject.put("type", subPath);
                                    jSONObject = SocialHiveImpl.INSTANCE.getJSONFromProfileHive("users", jSONObject, profileList);
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                    jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_INVALID_JSON);
                                    jSONObject.put("error_msg", "json parse error");
                                    jSONObject.put("type", subPath);
                                }
                                listener.onComplete(result, jSONObject);
                            }
                        });
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        return -9;
                    }
                }
                break;
            case 594741292:
                if (subPath.equals("friends/game")) {
                    return getFriendsEx(SocialHive.FriendType.IN_GAME, null, new SocialHive.ProfileListener() { // from class: com.hive.social.SocialHiveImpl.asyncRequest.5
                        @Override // com.hive.SocialHive.ProfileListener
                        public void onProfile(ResultAPI result, ArrayList<SocialHive.ProfileHive> profileList) throws JSONException {
                            Intrinsics.checkNotNullParameter(result, "result");
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, result.getErrorCode());
                                jSONObject.put("error_msg", result.getErrorMessage());
                                jSONObject.put("type", subPath);
                                jSONObject = SocialHiveImpl.INSTANCE.getJSONFromProfileHive("friend", jSONObject, profileList);
                            } catch (Exception e6) {
                                e6.printStackTrace();
                                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_INVALID_JSON);
                                jSONObject.put("error_msg", "json parse error");
                                jSONObject.put("type", subPath);
                            }
                            listener.onComplete(result, jSONObject);
                        }
                    });
                }
                break;
            case 743942656:
                if (subPath.equals("friends/facebook")) {
                    if (jsonData == null) {
                        return -9;
                    }
                    SocialHive.FriendsFacebookRequestParam friendsFacebookRequestParam = new SocialHive.FriendsFacebookRequestParam();
                    try {
                        friendsFacebookRequestParam.toDataModel(jsonData);
                        return requestFriendsFacebook(friendsFacebookRequestParam, listener);
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        return -9;
                    }
                }
                break;
            case 925347674:
                if (subPath.equals("wall/write")) {
                    if (jsonData == null) {
                        return -9;
                    }
                    SocialHive.WallWriteParam wallWriteParam = new SocialHive.WallWriteParam();
                    try {
                        wallWriteParam.toDataModel(jsonData);
                        return requestWallWrite(wallWriteParam, listener);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                        return -9;
                    }
                }
                break;
            case 962476457:
                if (subPath.equals("friends/reject_request")) {
                    if (jsonData == null) {
                        return -9;
                    }
                    SocialHive.FriendsRejectRequestParam friendsRejectRequestParam = new SocialHive.FriendsRejectRequestParam();
                    try {
                        friendsRejectRequestParam.toDataModel(jsonData);
                        return requestFriendsReject(friendsRejectRequestParam, listener);
                    } catch (Exception e8) {
                        e8.printStackTrace();
                        return -9;
                    }
                }
                break;
            case 1016993309:
                if (subPath.equals("guest/status_savedata")) {
                    if (jsonData == null) {
                        return -9;
                    }
                    SocialHive.GuestStatusSaveDataParam guestStatusSaveDataParam = new SocialHive.GuestStatusSaveDataParam();
                    try {
                        guestStatusSaveDataParam.toDataModel(jsonData);
                        return requestGuestStatusSaveData(guestStatusSaveDataParam, listener);
                    } catch (Exception e9) {
                        e9.printStackTrace();
                        return -9;
                    }
                }
                break;
            case 1265060374:
                if (subPath.equals("friends/other")) {
                    return getFriendsEx(SocialHive.FriendType.OUT_GAME, null, new SocialHive.ProfileListener() { // from class: com.hive.social.SocialHiveImpl.asyncRequest.6
                        @Override // com.hive.SocialHive.ProfileListener
                        public void onProfile(ResultAPI result, ArrayList<SocialHive.ProfileHive> profileList) throws JSONException {
                            Intrinsics.checkNotNullParameter(result, "result");
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, result.getErrorCode());
                                jSONObject.put("error_msg", result.getErrorMessage());
                                jSONObject.put("type", subPath);
                                jSONObject = SocialHiveImpl.INSTANCE.getJSONFromProfileHive("friend", jSONObject, profileList);
                            } catch (Exception e10) {
                                e10.printStackTrace();
                                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_INVALID_JSON);
                                jSONObject.put("error_msg", "json parse error");
                                jSONObject.put("type", subPath);
                            }
                            listener.onComplete(result, jSONObject);
                        }
                    });
                }
                break;
            case 1420824648:
                if (subPath.equals(SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_CONNECT)) {
                    return requestSocialConnect(jsonData, listener);
                }
                break;
            case 1694766799:
                if (subPath.equals("upload/image_with_json")) {
                    if (jsonData == null) {
                        return -9;
                    }
                    SocialHive.UploadImageParam uploadImageParam = new SocialHive.UploadImageParam();
                    try {
                        uploadImageParam.toDataModel(jsonData);
                        return requestUploadImage(uploadImageParam, listener);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        return -9;
                    }
                }
                break;
            case 1710013399:
                if (subPath.equals("message/write")) {
                    if (jsonData == null) {
                        return -9;
                    }
                    SocialHive.MessageContent messageContent = new SocialHive.MessageContent();
                    try {
                        messageContent.toDataModel(jsonData);
                        return sendMessageExWithUid(messageContent, new SocialHive.SendMessageListenerEx() { // from class: com.hive.social.SocialHiveImpl.asyncRequest.7
                            @Override // com.hive.SocialHive.SendMessageListenerEx
                            public void onSendMessage(ResultAPI result, JSONObject responseJson) throws JSONException {
                                Intrinsics.checkNotNullParameter(result, "result");
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, result.getErrorCode());
                                    jSONObject.put("error_msg", result.getErrorMessage());
                                    jSONObject.put("type", subPath);
                                    if (responseJson != null) {
                                        if (responseJson.has("uid")) {
                                            jSONObject.put("uid", responseJson.optString("uid"));
                                        }
                                        if (responseJson.has("fbid")) {
                                            jSONObject.put("fbid", responseJson.optString("fbid"));
                                        }
                                        if (responseJson.has("push_result")) {
                                            jSONObject.put("push_result", responseJson.optBoolean("push_result"));
                                        }
                                        if (responseJson.has("invite_result")) {
                                            jSONObject.put("invite_result", responseJson.optBoolean("invite_result"));
                                        }
                                    }
                                } catch (Exception e11) {
                                    e11.printStackTrace();
                                    jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_INVALID_JSON);
                                    jSONObject.put("error_msg", "json parse error");
                                    jSONObject.put("type", subPath);
                                }
                                listener.onComplete(result, jSONObject);
                            }
                        });
                    } catch (Exception e11) {
                        e11.printStackTrace();
                        return -9;
                    }
                }
                break;
            case 1816538804:
                if (subPath.equals("friends/receive_list")) {
                    if (jsonData == null) {
                        return -9;
                    }
                    SocialHive.FriendsReceiveListParam friendsReceiveListParam = new SocialHive.FriendsReceiveListParam();
                    try {
                        friendsReceiveListParam.toDataModel(jsonData);
                        return requestFriendsReceiveList(friendsReceiveListParam, listener);
                    } catch (Exception e12) {
                        e12.printStackTrace();
                        return -9;
                    }
                }
                break;
            case 1870035045:
                if (subPath.equals(SocialKeys.PeppermintRequestUrlPath.PEPPERMINT_ASYNC_API_PGS_UPDATE_PLAYERID)) {
                    return requestAcaLoginPlayGamesServiceSet(jsonData, listener);
                }
                break;
            case 1947920009:
                if (subPath.equals("message/get_invitations")) {
                    if (jsonData == null) {
                        return -9;
                    }
                    SocialHive.GetFriendsParam getFriendsParam = new SocialHive.GetFriendsParam();
                    try {
                        getFriendsParam.toDataModel(jsonData);
                        return getInvitations(getFriendsParam, new SocialHive.AsyncRequestListener() { // from class: com.hive.social.SocialHiveImpl.asyncRequest.8
                            @Override // com.hive.SocialHive.AsyncRequestListener
                            public void onComplete(ResultAPI result, JSONObject responseJsonData) throws JSONException {
                                Intrinsics.checkNotNullParameter(result, "result");
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, result.getErrorCode());
                                    jSONObject.put("error_msg", result.getErrorMessage());
                                    jSONObject.put("type", subPath);
                                    if (responseJsonData != null) {
                                        jSONObject.put("messages", responseJsonData.getJSONArray("messages"));
                                    }
                                } catch (Exception e13) {
                                    e13.printStackTrace();
                                    jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_INVALID_JSON);
                                    jSONObject.put("error_msg", "json parse error");
                                    jSONObject.put("type", subPath);
                                }
                                listener.onComplete(result, jSONObject);
                            }
                        });
                    } catch (Exception e13) {
                        e13.printStackTrace();
                        return -9;
                    }
                }
                break;
        }
        return isUserHubUidApi(subPath) ? requestUserProfile(subPath, jsonData, new SocialHive.ProfileListener() { // from class: com.hive.social.SocialHiveImpl.asyncRequest.9
            @Override // com.hive.SocialHive.ProfileListener
            public void onProfile(ResultAPI result, ArrayList<SocialHive.ProfileHive> profileList) throws JSONException {
                Intrinsics.checkNotNullParameter(result, "result");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, result.getErrorCode());
                    jSONObject.put("error_msg", result.getErrorMessage());
                    jSONObject.put("type", subPath);
                    jSONObject = SocialHiveImpl.INSTANCE.getJSONFromProfileHive("user", jSONObject, profileList);
                } catch (Exception e14) {
                    e14.printStackTrace();
                    jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_INVALID_JSON);
                    jSONObject.put("error_msg", "json parse error");
                    jSONObject.put("type", subPath);
                }
                listener.onComplete(result, jSONObject);
            }
        }) : requestUndefinedRequest(subPath, listener);
    }

    public final int authHub(final JSONObject jsonData, final SocialHive.ShowPeppermintDialogListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (isAuthHubInProgress) {
            LoggerImpl.INSTANCE.i("authHub is already process");
            return -8;
        }
        if (jsonData != null) {
            LoggerImpl.INSTANCE.i("authHub, requested params : " + jsonData);
        }
        isAuthHubInProgress = true;
        boolean zIsEmpty = TextUtils.isEmpty(Property.INSTANCE.getINSTANCE().getValue(SocialKeys.INSTANCE.getPEPPERMINT()));
        Intent intent = new Intent();
        if (!isClear) {
            intent.putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, zIsEmpty);
        }
        HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), intent, new OnActivityLifecycle() { // from class: com.hive.social.SocialHiveImpl.authHub.1
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
            public void onCreate(final Activity activity, Bundle savedInstanceState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                super.onCreate(activity, savedInstanceState);
                SocialDialog.Companion companion = SocialDialog.INSTANCE;
                boolean z = SocialHiveImpl.isClear;
                final SocialHive.ShowPeppermintDialogListener showPeppermintDialogListener = listener;
                setSocialDialog(companion.loginHive(activity, z, new SocialHive.ShowHiveDialogDataListener() { // from class: com.hive.social.SocialHiveImpl$authHub$1$onCreate$1
                    @Override // com.hive.SocialHive.ShowHiveDialogDataListener
                    public void onShowHiveDialogWithData(ResultAPI result, JSONObject jsonData2) throws JSONException {
                        Intrinsics.checkNotNullParameter(result, "result");
                        JSONObject jSONObject = new JSONObject();
                        if (jsonData2 != null) {
                            jsonData2.put("type", SocialKeys.PeppermintRequestUrlPath.PEPPERMINT_AUTH_PATH);
                            if (jsonData2.has("peppermint")) {
                                jsonData2.remove("peppermint");
                            }
                        } else {
                            try {
                                jSONObject.put("type", SocialKeys.PeppermintRequestUrlPath.PEPPERMINT_AUTH_PATH);
                            } catch (Exception e) {
                                LoggerImpl.INSTANCE.i("authHub, socialDialog onShowHiveDialogWithData(HIVE) exception : " + e);
                                Unit unit = Unit.INSTANCE;
                            }
                            jsonData2 = jSONObject;
                        }
                        showPeppermintDialogListener.onPeppermintDialog(result, SocialHiveImpl.INSTANCE.getSocialDialogResultJson(result, jsonData2));
                        SocialHiveImpl.isAuthHubInProgress = false;
                        activity.finish();
                    }
                }));
                getSocialDialog().show(jsonData);
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onDestroy(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", SocialKeys.PeppermintRequestUrlPath.PEPPERMINT_AUTH_PATH);
                } catch (Exception e) {
                    LoggerImpl.INSTANCE.i("authHub, socialDialog onShowHiveDialogWithData(HIVE) onDestroy exception : " + e);
                }
                SocialHiveImpl.isAuthHubInProgress = false;
                ResultAPI resultAPI = new ResultAPI(-6, ResultAPI.Code.SocialHIVESocialDialogClosed, "User Cancel");
                if (!getIsCalledFinish()) {
                    listener.onPeppermintDialog(resultAPI, SocialHiveImpl.INSTANCE.getSocialDialogResultJson(resultAPI, jSONObject));
                }
                super.onDestroy(activity);
            }

            public final void setSocialDialog(SocialDialog socialDialog) {
                Intrinsics.checkNotNullParameter(socialDialog, "<set-?>");
                this.socialDialog = socialDialog;
            }
        });
        LoggerImpl.INSTANCE.i("authHub return ResultAPI.PeppermintErrCode.HUB_E_SUCCESS");
        return 0;
    }

    public final int deleteStoredUserId(String uid) throws JSONException {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i("deleteStoredUserId");
        if (uid == null || uid.length() == 0) {
            loggerImpl.i("deleteStoredUserId, uid is null or empty.");
            return -9;
        }
        Map<String, String> mapLoadStoredUserInfoMap = loadStoredUserInfoMap();
        mapLoadStoredUserInfoMap.remove(uid);
        loggerImpl.i("deleteStoredUserId, removed uid{" + uid + ") info.");
        JSONObject jSONObjectLoadStoredUserInfoJson = loadStoredUserInfoJson(mapLoadStoredUserInfoMap);
        Property.Companion companion = Property.INSTANCE;
        Property.setValue$default(companion.getINSTANCE(), SocialKeys.INSTANCE.getSTORED_USER_INFO(), String.valueOf(jSONObjectLoadStoredUserInfoJson), null, 4, null);
        companion.getINSTANCE().writeProperties();
        loggerImpl.i("deleteStoredUserId, infoList : " + jSONObjectLoadStoredUserInfoJson);
        return 0;
    }

    public final boolean getAuthDialogClear() {
        return isClear;
    }

    public final void getBadgeInfo(final SocialHive.SocialBadgeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        HiveGraph.INSTANCE.messageNotiCount(new Function3() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SocialHiveImpl.getBadgeInfo$lambda$71(listener, (ResultAPI) obj, (MessageNotiCount) obj2, (SocialHive.SocialBadge) obj3);
            }
        });
    }

    public final void getFriends(SocialHive.FriendType friendType, SocialHive.ProfileListener listener) {
        Intrinsics.checkNotNullParameter(friendType, "friendType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        getFriends(friendType, null, listener);
    }

    public final int getFriendsEx(SocialHive.FriendType friendType, SocialHive.ProfileListener listener) {
        Intrinsics.checkNotNullParameter(friendType, "friendType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return getFriendsEx(friendType, null, listener);
    }

    public final boolean getGuestLoginButton() {
        return isShowGuestLoginButton;
    }

    @Override // com.hive.module.interfaces.HiveSocial, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return HiveSocial.DefaultImpls.getHiveModuleName(this);
    }

    public final int getInvitations(SocialHive.GetFriendsParam getFriendsParam, final SocialHive.AsyncRequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (AuthImpl.INSTANCE.isInitialize()) {
            HiveGraph.INSTANCE.getInvitations(getFriendsParam, new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda49
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialHiveImpl.getInvitations$lambda$10(listener, (ResultAPI) obj, (JSONObject) obj2);
                }
            });
            return 0;
        }
        listener.onComplete(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""), null);
        return -9;
    }

    public final void getMyProfile(final SocialHive.ProfileListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (AuthImpl.INSTANCE.isInitialize()) {
            HiveGraph.INSTANCE.userMe(new Function3() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda54
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SocialHiveImpl.getMyProfile$lambda$0(listener, (ResultAPI) obj, (UserMe) obj2, (SocialHive.ProfileHive) obj3);
                }
            });
        } else {
            listener.onProfile(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""), null);
        }
    }

    public final int getMyProfileEx(final SocialHive.ProfileListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i("getMyProfileEx");
        if (AuthImpl.INSTANCE.isInitialize()) {
            new Thread(new Runnable() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda45
                @Override // java.lang.Runnable
                public final void run() {
                    SocialHiveImpl.getMyProfileEx$lambda$27(listener);
                }
            }).start();
            return 0;
        }
        listener.onProfile(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""), null);
        return -9;
    }

    public final int getOauthAccessToken(SocialHive.AsyncRequestListener listener) {
        String accessToken;
        String str;
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(listener, "listener");
        ResultAPI resultAPI = new ResultAPI(-9, ResultAPI.Code.SocialHIVEInvalidSession);
        HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
        OauthToken oauthToken = hiveLifecycle.getAccount().getOauthToken();
        if (oauthToken == null || (accessToken = oauthToken.getAccessToken()) == null) {
            accessToken = "";
        }
        boolean zIsSignIn = hiveLifecycle.isSignIn();
        int i = ResultAPI.PeppermintErrCode.HUB_E_AUTH_FAIL;
        if (!zIsSignIn) {
            str = "Sign-in is required.";
        } else if (StringsKt.isBlank(accessToken)) {
            str = "Access token does not exist.";
        } else {
            resultAPI = new ResultAPI();
            str = ADXLogUtil.EVENT_LOAD_SUCCESS;
            i = 0;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, i);
            jSONObject.put("error_msg", str);
            jSONObject.put("access_token", accessToken);
            objM7415constructorimpl = Result.m7415constructorimpl(jSONObject);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
            objM7415constructorimpl = null;
        }
        listener.onComplete(resultAPI, (JSONObject) objM7415constructorimpl);
        return 0;
    }

    public final void getProfiles(final String[] vidLists, final SocialHive.ProfileListener listener) {
        if (!AuthImpl.INSTANCE.isInitialize()) {
            if (listener != null) {
                listener.onProfile(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""), null);
            }
        } else if (vidLists != null && vidLists.length != 0) {
            new Thread(new Runnable() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    SocialHiveImpl.getProfiles$lambda$13(vidLists, listener);
                }
            }).start();
        } else if (listener != null) {
            listener.onProfile(new ResultAPI(-1, ResultAPI.Code.SocialHIVEInvalidParamGetProfiles, "Request vidLists is null or empty"), null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.ArrayList] */
    public final int getStoredUserIdIntoList(SocialHive.AsyncRequestListener listener) throws JSONException {
        ?? EmptyList;
        JSONArray jSONArray;
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i("getStoredUserIdIntoList");
        JSONObject jSONObjectLoadStoredUserInfoJson = loadStoredUserInfoJson(loadStoredUserInfoMap());
        if (jSONObjectLoadStoredUserInfoJson == null || (jSONArray = jSONObjectLoadStoredUserInfoJson.getJSONArray("infoList")) == null) {
            EmptyList = CollectionsKt.emptyList();
        } else {
            int length = jSONArray.length();
            EmptyList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                EmptyList.add(jSONArray.getJSONObject(i).keys().next());
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uidList", new JSONArray((Collection) EmptyList));
        listener.onComplete(new ResultAPI(), jSONObject);
        LoggerImpl.INSTANCE.i("getStoredUserIdIntoList, json : " + jSONObject);
        return 0;
    }

    public final void getUidFromVid(final ArrayList<String> uidList, final SocialHive.GetVidListener listener) {
        Intrinsics.checkNotNullParameter(uidList, "uidList");
        Intrinsics.checkNotNullParameter(listener, "listener");
        new Thread(new Runnable() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda52
            @Override // java.lang.Runnable
            public final void run() {
                SocialHiveImpl.getUidFromVid$lambda$51(uidList, listener);
            }
        }).start();
    }

    @Override // com.hive.module.interfaces.HiveSocial, com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        return HiveSocial.DefaultImpls.getVersionInfo(this);
    }

    public final String getVidFromUidWithMap(String uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        HashMap<String, String> map = uidToVid;
        return map.containsKey(uid) ? map.get(uid) : AppEventsConstants.EVENT_PARAM_VALUE_NO;
    }

    public final int guestAcquireUid(final SocialHive.ShowPeppermintDialogListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (isAuthHubInProgress) {
            LoggerImpl.INSTANCE.i("guestAcquireUid is already process");
            return -8;
        }
        isAuthHubInProgress = true;
        showGuestApiDialog(UrlManager.SocialWeb.INSTANCE.getGuestAcquire(), new SocialHive.ShowHiveDialogDataListener() { // from class: com.hive.social.SocialHiveImpl.guestAcquireUid.1
            @Override // com.hive.SocialHive.ShowHiveDialogDataListener
            public void onShowHiveDialogWithData(ResultAPI result, JSONObject jsonData) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (jsonData != null) {
                    try {
                        jsonData.put("type", "guest/acquire_uid");
                    } catch (Exception e) {
                        e.printStackTrace();
                        Unit unit = Unit.INSTANCE;
                    }
                }
                listener.onPeppermintDialog(result, SocialHiveImpl.INSTANCE.getSocialDialogResultJson(result, jsonData));
                SocialHiveImpl.isAuthHubInProgress = false;
            }
        });
        LoggerImpl.INSTANCE.i("logoutHub return ResultAPI.PeppermintErrCode.HUB_E_SUCCESS");
        return 0;
    }

    public final int guestBind(String guestUid, String candidateUid, final SocialHive.ShowPeppermintDialogListener listener) {
        Intrinsics.checkNotNullParameter(guestUid, "guestUid");
        Intrinsics.checkNotNullParameter(candidateUid, "candidateUid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (isAuthHubInProgress) {
            LoggerImpl.INSTANCE.i("guestBind is already process");
            return -8;
        }
        isAuthHubInProgress = true;
        showGuestApiDialog(UrlManager.SocialWeb.INSTANCE.getGuestBind() + FileSystemKt.UnixPathSeparator + guestUid + FileSystemKt.UnixPathSeparator + candidateUid, new SocialHive.ShowHiveDialogDataListener() { // from class: com.hive.social.SocialHiveImpl.guestBind.1
            @Override // com.hive.SocialHive.ShowHiveDialogDataListener
            public void onShowHiveDialogWithData(ResultAPI result, JSONObject jsonData) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (jsonData != null) {
                    try {
                        jsonData.put("type", SocialKeys.PeppermintRequestUrlPath.PEPPERMINT_GUEST_BIND_PATH);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Unit unit = Unit.INSTANCE;
                    }
                }
                listener.onPeppermintDialog(result, SocialHiveImpl.INSTANCE.getSocialDialogResultJson(result, jsonData));
                SocialHiveImpl.isAuthHubInProgress = false;
            }
        });
        LoggerImpl.INSTANCE.i("guestBind return ResultAPI.PeppermintErrCode.HUB_E_SUCCESS");
        return 0;
    }

    public final boolean isCurrentUserStoredInfo() {
        LoggerImpl.INSTANCE.i("removeServerPeppermintCookie");
        String strSearchPeppermintFromUid = searchPeppermintFromUid(AuthImpl.INSTANCE.getPeppermintCurrentUid());
        return !(strSearchPeppermintFromUid == null || strSearchPeppermintFromUid.length() == 0);
    }

    public final int logoutHub(final SocialHive.ShowPeppermintDialogListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (isAuthHubInProgress) {
            LoggerImpl.INSTANCE.i("logoutHub is already process");
            return -8;
        }
        isAuthHubInProgress = true;
        boolean zIsEmpty = TextUtils.isEmpty(Property.INSTANCE.getINSTANCE().getValue(SocialKeys.INSTANCE.getPEPPERMINT()));
        Intent intent = new Intent();
        intent.putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, zIsEmpty);
        HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), intent, new OnActivityLifecycle() { // from class: com.hive.social.SocialHiveImpl.logoutHub.1
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
                setSocialDialog(SocialDialog.INSTANCE.logoutHive(activity, new SocialHiveImpl$logoutHub$1$onCreate$1(activity, listener)));
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
        LoggerImpl.INSTANCE.i("logoutHub return ResultAPI.PeppermintErrCode.HUB_E_SUCCESS");
        return 0;
    }

    public final void peppermintInitialize(String appId, String gameIndex, int serverType) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        ConfigurationImpl.INSTANCE.setPeppermintInitAppId(appId);
    }

    @Deprecated(message = "")
    public final void peppermintUnInitialize() {
    }

    public final void processLogoutData() {
        LoggerImpl.INSTANCE.i("processLogoutData");
        Property.Companion companion = Property.INSTANCE;
        Property instance = companion.getINSTANCE();
        SocialKeys socialKeys = SocialKeys.INSTANCE;
        Property.setValue$default(instance, socialKeys.getUID(), "", null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), socialKeys.getUID_SESSION_TOKEN(), "", null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), socialKeys.getPEPPERMINT(), "", null, 4, null);
        Property.setValue$default(companion.getINSTANCE(), socialKeys.getPGS_PLAYERID(), "", null, 4, null);
        companion.getINSTANCE().writeProperties();
        SocialAccount.INSTANCE.removeToken();
        SocialV4ProviderAdapter.INSTANCE.allDisconnect();
    }

    public final int refreshOauthAccessToken(SocialHive.AsyncRequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C29581(listener, null), 3, null);
        return 0;
    }

    public final int removeServerPeppermintCookie(final SocialHive.AsyncRequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i("removeServerPeppermintCookie");
        final String strSearchPeppermintFromUid = searchPeppermintFromUid(AuthImpl.INSTANCE.getPeppermintCurrentUid());
        new Thread(new Runnable() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SocialHiveImpl.removeServerPeppermintCookie$lambda$79(strSearchPeppermintFromUid, listener);
            }
        }).start();
        return 0;
    }

    public final int requestUsersInfoWithVidList(final String[] vidList, final SocialHive.ProfileListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i("requestUsersInfoWithVidList");
        if (!AuthImpl.INSTANCE.isInitialize()) {
            listener.onProfile(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""), null);
            return -9;
        }
        if (vidList == null || vidList.length == 0) {
            listener.onProfile(new ResultAPI(-1, ResultAPI.Code.SocialHIVEInvalidParamGetProfiles, "VidList is null or empty"), null);
            return -9;
        }
        new Thread(new Runnable() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                SocialHiveImpl.requestUsersInfoWithVidList$lambda$20(vidList, listener);
            }
        }).start();
        return 0;
    }

    public final String searchPeppermintFromUid(String uid) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i("searchPeppermintFromUid");
        if (uid == null || uid.length() == 0) {
            loggerImpl.i("searchPeppermintFromUid, uid is null or empty.");
            return null;
        }
        Map<String, String> mapLoadStoredUserInfoMap = loadStoredUserInfoMap();
        if (!mapLoadStoredUserInfoMap.containsKey(uid)) {
            return null;
        }
        loggerImpl.i("searchPeppermintFromUid, return peppermint(" + mapLoadStoredUserInfoMap.get(uid) + ") from uid(" + uid + ')');
        return mapLoadStoredUserInfoMap.get(uid);
    }

    public final void sendInvitationMessage(SocialHive.MessageContent messageContent, final SocialHive.SendMessageListener listener) {
        Intrinsics.checkNotNullParameter(messageContent, "messageContent");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!AuthImpl.INSTANCE.isInitialize()) {
            listener.onSendMessage(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""));
        } else if (StringsKt.isBlank(messageContent.getUid())) {
            listener.onSendMessage(new ResultAPI(-1, ResultAPI.Code.SocialHIVEInvalidParamSendInvitationMessage, "You must input uid value."));
        } else {
            HiveGraph.INSTANCE.messageWrite(messageContent, true, new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialHiveImpl.sendInvitationMessage$lambda$52(listener, (ResultAPI) obj, (MessageWrite) obj2);
                }
            });
        }
    }

    public final void sendMessage(final SocialHive.MessageContent messageContent, final SocialHive.SendMessageListener listener) {
        Intrinsics.checkNotNullParameter(messageContent, "messageContent");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (AuthImpl.INSTANCE.isInitialize()) {
            new Thread(new Runnable() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda16
                @Override // java.lang.Runnable
                public final void run() {
                    SocialHiveImpl.sendMessage$lambda$46(messageContent, listener);
                }
            }).start();
        } else {
            listener.onSendMessage(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""));
        }
    }

    public final int sendMessageEx(SocialHive.MessageContent messageContent, SocialHive.SendMessageListenerEx listener) {
        Intrinsics.checkNotNullParameter(messageContent, "messageContent");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!AuthImpl.INSTANCE.isInitialize()) {
            listener.onSendMessage(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""), null);
            return -9;
        }
        if (StringsKt.isBlank(messageContent.getUid()) && StringsKt.isBlank(messageContent.getVid())) {
            listener.onSendMessage(new ResultAPI(-1, ResultAPI.Code.SocialHIVEInvalidParamSendMessage, "uid or vid must input."), null);
            return -9;
        }
        sendMessageWithParam(messageContent, listener);
        return 0;
    }

    public final void setAuthDialogClear() {
        isClear = true;
    }

    public final void setGuestLoginButton(boolean isShow) {
        isShowGuestLoginButton = isShow;
    }

    public final void setMyProfile(String displayName, final SocialHive.ProfileListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!AuthImpl.INSTANCE.isInitialize()) {
            listener.onProfile(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""), null);
        } else if (displayName == null || StringsKt.isBlank(displayName)) {
            listener.onProfile(new ResultAPI(-1, ResultAPI.Code.SocialHIVEResponseFailSetMyProfile, ""), null);
        } else {
            HiveGraph.INSTANCE.userModify(displayName, new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialHiveImpl.setMyProfile$lambda$1(listener, (ResultAPI) obj, (UserModify) obj2);
                }
            });
        }
    }

    @Override // com.hive.module.interfaces.HiveSocial
    public int showHiveDialog(String subpath, SocialHive.ShowHiveDialogDataListener listener) {
        Intrinsics.checkNotNullParameter(subpath, "subpath");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!AuthImpl.INSTANCE.isInitialize()) {
            listener.onShowHiveDialogWithData(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""), null);
            return -9;
        }
        LoggerImpl.INSTANCE.i("showHiveDialog subpath : " + subpath);
        showHiveSocialDialog(subpath, listener);
        return 0;
    }

    public final int storeCurrentUserId() throws JSONException {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i("storeCurrentUserId");
        AuthImpl authImpl = AuthImpl.INSTANCE;
        if (authImpl.getPeppermintCurrentUid().length() == 0 || authImpl.getPeppermintCurrentPeppermint().length() == 0) {
            loggerImpl.i("storeCurrentUserId, uid or peppermint is empty.");
            return -9;
        }
        Map<String, String> mapLoadStoredUserInfoMap = loadStoredUserInfoMap();
        mapLoadStoredUserInfoMap.put(authImpl.getPeppermintCurrentUid(), authImpl.getPeppermintCurrentPeppermint());
        JSONObject jSONObjectLoadStoredUserInfoJson = loadStoredUserInfoJson(mapLoadStoredUserInfoMap);
        Property.Companion companion = Property.INSTANCE;
        Property.setValue$default(companion.getINSTANCE(), SocialKeys.INSTANCE.getSTORED_USER_INFO(), String.valueOf(jSONObjectLoadStoredUserInfoJson), null, 4, null);
        companion.getINSTANCE().writeProperties();
        loggerImpl.i("storeCurrentUserId, infoList : " + jSONObjectLoadStoredUserInfoJson);
        return 0;
    }

    private final void getFriends(SocialHive.FriendType friendType, SocialHive.GetFriendsParam getFriendsParam, final SocialHive.ProfileListener listener) {
        if (AuthImpl.INSTANCE.isInitialize()) {
            HiveGraph.INSTANCE.getFriends(false, friendType, getFriendsParam, new Function2() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialHiveImpl.getFriends$lambda$4(listener, (ResultAPI) obj, (ArrayList) obj2);
                }
            });
        } else {
            listener.onProfile(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""), null);
        }
    }

    private final int getFriendsEx(final SocialHive.FriendType friendsType, final SocialHive.GetFriendsParam getFriendsParam, final SocialHive.ProfileListener listener) {
        LoggerImpl.INSTANCE.i("getFriendsEx");
        if (AuthImpl.INSTANCE.isInitialize()) {
            new Thread(new Runnable() { // from class: com.hive.social.SocialHiveImpl$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    SocialHiveImpl.getFriendsEx$lambda$9(friendsType, getFriendsParam, listener);
                }
            }).start();
            return 0;
        }
        listener.onProfile(new ResultAPI(-7, ResultAPI.Code.SocialHIVENotInitialized, ""), null);
        return -9;
    }

    private final String findShowHiveDialogUrl(SocialHive.HiveDialogType hiveDialogType, String vid) {
        String home = "";
        switch (WhenMappings.$EnumSwitchMapping$1[hiveDialogType.ordinal()]) {
            case 1:
                home = UrlManager.SocialWeb.INSTANCE.getHome();
                break;
            case 2:
            case 3:
                home = UrlManager.CustomerCenter.INSTANCE.getInquiry();
                break;
            case 4:
                home = UrlManager.SocialWeb.INSTANCE.getGame();
                break;
            case 5:
                home = UrlManager.SocialWeb.INSTANCE.getProfile();
                break;
            case 6:
                String message = UrlManager.SocialFriendWeb.INSTANCE.getMessage();
                if (!StringsKt.isBlank(vid)) {
                    SocialHive.ProfileHive profileByVID = HiveUserCache.INSTANCE.getProfileByVID(vid);
                    if (profileByVID == null) {
                        GetUid.GetUidResponse response = ((GetUid) AuthNetwork.LoginCenter.INSTANCE.getUid(CollectionsKt.arrayListOf(vid)).request()).getResponse();
                        if (response.isSuccess() && response.getUidList().size() == 1) {
                            home = response.getUidList().get(0);
                        }
                    } else {
                        String uid = profileByVID.getUid();
                        if (uid != null) {
                            home = uid;
                        }
                    }
                    if (!StringsKt.isBlank(home)) {
                        message = message + "/view/" + home;
                    }
                    home = message;
                    LoggerImpl.INSTANCE.i("SOCIAL_URL_TEST", home);
                } else {
                    home = message;
                }
                break;
        }
        LoggerImpl.INSTANCE.i("SOCIAL_URL_TEST", home);
        return home;
    }

    @Override // com.hive.module.interfaces.HiveSocial
    public void showHiveDialog(SocialHive.HiveDialogType hiveDialogType, String vid, String additionalInfo, SocialHive.ShowHiveDialogListener listener) {
        Intrinsics.checkNotNullParameter(hiveDialogType, "hiveDialogType");
        Intrinsics.checkNotNullParameter(vid, "vid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        internalShowHiveDialog(hiveDialogType, vid, additionalInfo, listener, null);
    }

    public final void showHiveDialog(SocialHive.HiveDialogType hiveDialogType, String vid, String additionalInfo, SocialHive.ShowHiveDialogDataListener listener) {
        Intrinsics.checkNotNullParameter(hiveDialogType, "hiveDialogType");
        Intrinsics.checkNotNullParameter(vid, "vid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        internalShowHiveDialog(hiveDialogType, vid, additionalInfo, null, listener);
    }
}
