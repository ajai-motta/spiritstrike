package com.hive.social;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.facebook.AccessToken;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.UserDataStore;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.hive.Configuration;
import com.hive.ResultAPI;
import com.hive.SocialHive;
import com.hive.auth.AuthImpl;
import com.hive.auth.AuthKeys;
import com.hive.base.Android;
import com.hive.base.Crypto;
import com.hive.base.Property;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.Crypto;
import com.hive.core.HiveKeys;
import com.hive.core.Result;
import com.hive.logger.LoggerImpl;
import com.hive.protocol.Protocol;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.socialapi.AcaDeleteCookies;
import com.hive.protocol.socialapi.AcaLoginPlayGamesService;
import com.hive.protocol.socialapi.AcaLoginPlayGamesServiceSet;
import com.hive.protocol.socialapi.AcaUserQuitRequest;
import com.hive.protocol.socialapi.DeviceRegistered;
import com.hive.protocol.socialapi.DeviceUsePgs;
import com.hive.protocol.socialapi.GuestGenerate;
import com.hive.protocol.socialapi.GuestKey;
import com.hive.protocol.socialapi.GuestLogin;
import com.hive.protocol.socialapi.GuestStatusSaveData;
import com.hive.protocol.socialapi.ProfileGetUser;
import com.hive.protocol.socialapi.SocialApi;
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
import com.hive.protocol.socialfriendapi.FriendsAll;
import com.hive.protocol.socialfriendapi.FriendsAllEx;
import com.hive.protocol.socialfriendapi.FriendsFacebookRequest;
import com.hive.protocol.socialfriendapi.FriendsInGame;
import com.hive.protocol.socialfriendapi.FriendsInGameEx;
import com.hive.protocol.socialfriendapi.FriendsInvite;
import com.hive.protocol.socialfriendapi.FriendsOutGame;
import com.hive.protocol.socialfriendapi.FriendsOutGameEx;
import com.hive.protocol.socialfriendapi.FriendsReceiveList;
import com.hive.protocol.socialfriendapi.FriendsRejectRequest;
import com.hive.protocol.socialfriendapi.FriendsRequest;
import com.hive.protocol.socialfriendapi.MessageNotiCount;
import com.hive.protocol.socialfriendapi.MessageWrite;
import com.hive.protocol.socialfriendapi.SocialFriendApi;
import com.hive.protocol.socialotherapi.SaveDataDelete;
import com.hive.protocol.socialotherapi.SaveDataDownload;
import com.hive.protocol.socialotherapi.SaveDataUpload;
import com.hive.protocol.socialotherapi.SocialOtherApi;
import com.hive.protocol.socialotherapi.UploadImage;
import com.hive.standalone.HiveLifecycle;
import com.hive.userengagement.UserEngagementEventKt;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u000e\u001a\u00020\u000f*\u00020\u0010J\n\u0010\u000e\u001a\u00020\u000f*\u00020\u0011J\n\u0010\u000e\u001a\u00020\u000f*\u00020\u0012J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\f\u0010\u0018\u001a\u00020\u0019*\u00020\u001aH\u0002J\f\u0010\u001b\u001a\u00020\u001c*\u00020\u001aH\u0002Jh\u0010\u001d\u001a\u00020\u001e2`\u0010\u001f\u001a\\\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u001e0 JU\u0010(\u001a\u00020\u001e2M\u0010\u001f\u001aI\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110*¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b((\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u001e0)JU\u0010,\u001a\u00020\u001e2M\u0010\u001f\u001aI\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110-¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(,\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u001e0)Jg\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010\u001a2M\u0010\u001f\u001aI\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u001101¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(.\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u001e0)Jg\u00102\u001a\u00020\u001e2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u0005042Q\u0010\u001f\u001aM\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u001105¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(2\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001906¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u001e0)Jg\u00108\u001a\u00020\u001e2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u0005042Q\u0010\u001f\u001aM\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u001109¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(8\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001906¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u001e0)Jg\u0010:\u001a\u00020\u001e2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u0005042Q\u0010\u001f\u001aM\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110;¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(:\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001c06¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e0)Ji\u0010=\u001a\u00020\u001e2\u000e\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005042Q\u0010\u001f\u001aM\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(>\u0012\u0013\u0012\u00110;¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(:\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001c06¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e0)JH\u0010?\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020A26\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110C¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020\u001e0BH\u0007J@\u0010E\u001a\u00020\u001e26\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110F¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\u001e0BH\u0007J@\u0010H\u001a\u00020\u001e26\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110I¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020\u001e0BH\u0007JF\u0010K\u001a\u00020\u001e2\u0006\u0010L\u001a\u00020M26\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110N¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u001e0BJH\u0010O\u001a\u00020\u001e2\u0006\u0010P\u001a\u00020Q26\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110R¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(O\u0012\u0004\u0012\u00020\u001e0BH\u0007JF\u0010S\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020U26\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110V¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(W\u0012\u0004\u0012\u00020\u001e0BJF\u0010X\u001a\u00020\u001e2\u0006\u0010Y\u001a\u00020Z26\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110[¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(X\u0012\u0004\u0012\u00020\u001e0BJF\u0010\\\u001a\u00020\u001e2\u0006\u0010]\u001a\u00020^26\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110_¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\\\u0012\u0004\u0012\u00020\u001e0BJF\u0010`\u001a\u00020\u001e2\u0006\u0010a\u001a\u00020b26\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(`\u0012\u0004\u0012\u00020\u001e0BJH\u0010d\u001a\u00020\u001e2\u0006\u0010e\u001a\u00020f26\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110g¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(d\u0012\u0004\u0012\u00020\u001e0BH\u0007J>\u0010h\u001a\u00020\u001e26\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110i¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(h\u0012\u0004\u0012\u00020\u001e0BJF\u0010j\u001a\u00020\u001e2\u0006\u0010k\u001a\u00020\u000526\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110l¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(j\u0012\u0004\u0012\u00020\u001e0BJ^\u0010m\u001a\u00020\u001e2\u0006\u0010n\u001a\u00020%2\u0006\u0010o\u001a\u00020p2\b\u0010q\u001a\u0004\u0018\u00010r2<\u0010\u001f\u001a8\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001906¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u001e0BJH\u0010s\u001a\u00020\u001e2\b\u0010q\u001a\u0004\u0018\u00010r26\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u001e0BJN\u0010t\u001a\u00020\u001e2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020%26\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110x¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(t\u0012\u0004\u0012\u00020\u001e0BJ>\u0010y\u001a\u00020\u001e26\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110z¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b({\u0012\u0004\u0012\u00020\u001e0BJH\u0010|\u001a\u00020\u001e2\b\u00100\u001a\u0004\u0018\u00010\u001a26\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(}\u0012\u0013\u0012\u00110~¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u007f\u0012\u0004\u0012\u00020\u001e0BJJ\u0010\u0080\u0001\u001a\u00020\u001e2\b\u00100\u001a\u0004\u0018\u00010\u001a27\u0010\u001f\u001a3\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(}\u0012\u0014\u0012\u00120\u0081\u0001¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u007f\u0012\u0004\u0012\u00020\u001e0BJA\u0010\u0082\u0001\u001a\u00020\u001e28\u0010\u001f\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u00130\u0083\u0001¢\u0006\r\b!\u0012\t\b\"\u0012\u0005\b\b(\u0084\u0001\u0012\u0004\u0012\u00020\u001e0BJS\u0010\u0085\u0001\u001a\u00020\u001e2\u0007\u0010\u0086\u0001\u001a\u00020\u00052\u0007\u0010\u0087\u0001\u001a\u00020\u000528\u0010\u001f\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u00130\u0088\u0001¢\u0006\r\b!\u0012\t\b\"\u0012\u0005\b\b(\u0089\u0001\u0012\u0004\u0012\u00020\u001e0BJK\u0010\u008a\u0001\u001a\u00020\u001e2\b\u0010\u008b\u0001\u001a\u00030\u008c\u000128\u0010\u001f\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u00130\u008d\u0001¢\u0006\r\b!\u0012\t\b\"\u0012\u0005\b\b(\u008e\u0001\u0012\u0004\u0012\u00020\u001e0BJK\u0010\u008f\u0001\u001a\u00020\u001e2\b\u0010\u0090\u0001\u001a\u00030\u0091\u000128\u0010\u001f\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u00130\u0092\u0001¢\u0006\r\b!\u0012\t\b\"\u0012\u0005\b\b(\u0093\u0001\u0012\u0004\u0012\u00020\u001e0BJK\u0010\u0094\u0001\u001a\u00020\u001e2\b\u00100\u001a\u0004\u0018\u00010\u001a28\u0010\u001f\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u00130\u0095\u0001¢\u0006\r\b!\u0012\t\b\"\u0012\u0005\b\b(\u0096\u0001\u0012\u0004\u0012\u00020\u001e0BJI\u0010\u0097\u0001\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u000528\u0010\u001f\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u00130\u0098\u0001¢\u0006\r\b!\u0012\t\b\"\u0012\u0005\b\b(\u0099\u0001\u0012\u0004\u0012\u00020\u001e0BJX\u0010\u009a\u0001\u001a\u00020\u001e2O\u0010\u001f\u001aK\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u00130\u009b\u0001¢\u0006\r\b!\u0012\t\b\"\u0012\u0005\b\b(\u009a\u0001\u0012\u0015\u0012\u00130\u009c\u0001¢\u0006\r\b!\u0012\t\b\"\u0012\u0005\b\b(\u009d\u0001\u0012\u0004\u0012\u00020\u001e0)JK\u0010\u009e\u0001\u001a\u00020\u001e2\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u000527\u0010\u001f\u001a3\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0014\u0012\u00120\u001a¢\u0006\r\b!\u0012\t\b\"\u0012\u0005\b\b( \u0001\u0012\u0004\u0012\u00020\u001e0BJ\u0019\u0010¡\u0001\u001a\u00020\u00052\u0007\u0010¢\u0001\u001a\u00020\u00052\u0007\u0010£\u0001\u001a\u00020\u0005J\u001b\u0010¤\u0001\u001a\u00020\u001e2\t\u0010¥\u0001\u001a\u0004\u0018\u00010\u00052\u0007\u0010¦\u0001\u001a\u00020\u0005J\u0012\u0010§\u0001\u001a\u00020\u001e2\t\u0010¥\u0001\u001a\u0004\u0018\u00010\u0005J\u0014\u0010¨\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050©\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006ª\u0001"}, d2 = {"Lcom/hive/social/HiveGraph;", "", "<init>", "()V", "PEPPERMINT_QPYOU_COOKIE_URL", "", "getPEPPERMINT_QPYOU_COOKIE_URL", "()Ljava/lang/String;", "additionalDefaultData", "Ljava/util/HashMap;", "getAdditionalDefaultData", "()Ljava/util/HashMap;", "setAdditionalDefaultData", "(Ljava/util/HashMap;)V", "toResultAPI", "Lcom/hive/ResultAPI;", "Lcom/hive/protocol/socialapi/SocialApi$SocialApiResponse;", "Lcom/hive/protocol/socialotherapi/SocialOtherApi$SocialOtherApiResponse;", "Lcom/hive/protocol/socialfriendapi/SocialFriendApi$SocialFriendApiResponse;", "coreResult", "Lcom/hive/core/Result;", "responseCode", "", "responseMsg", "toProfileHive", "Lcom/hive/SocialHive$ProfileHive;", "Lorg/json/JSONObject;", "toProfileGetUser", "Lcom/hive/SocialHive$ProfileGetUser;", "deviceUsePgs", "", "callback", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "resultApi", "Lcom/hive/protocol/socialapi/DeviceUsePgs;", "", "usePgs", "maxRetryPgs", "userMe", "Lkotlin/Function3;", "Lcom/hive/protocol/socialapi/UserMe;", Scopes.PROFILE, "userMeEx", "Lcom/hive/protocol/socialapi/UserMeEx;", "userEx", "subPath", "jsonData", "Lcom/hive/protocol/socialapi/UserEx;", "users", "uidList", "", "Lcom/hive/protocol/socialapi/Users;", "Ljava/util/ArrayList;", "profileList", "usersInfo", "Lcom/hive/protocol/socialapi/UsersInfo;", "profileGetUser", "Lcom/hive/protocol/socialapi/ProfileGetUser;", "profileGetUserList", "profileGetUserEx", "resultCode", "uploadSaveData", "uploadSaveDataParam", "Lcom/hive/SocialHive$UploadSaveDataParam;", "Lkotlin/Function2;", "Lcom/hive/protocol/socialotherapi/SaveDataUpload;", "saveDataUpdate", "downloadSaveData", "Lcom/hive/protocol/socialotherapi/SaveDataDownload;", "saveDataDownload", "deleteSaveData", "Lcom/hive/protocol/socialotherapi/SaveDataDelete;", "saveDataDelete", "uploadImage", "uploadImageParam", "Lcom/hive/SocialHive$UploadImageParam;", "Lcom/hive/protocol/socialotherapi/UploadImage;", "wallWrite", "wallWriteParam", "Lcom/hive/SocialHive$WallWriteParam;", "Lcom/hive/protocol/socialapi/WallWrite;", "rejectRequest", "friendsRejectRequestParam", "Lcom/hive/SocialHive$FriendsRejectRequestParam;", "Lcom/hive/protocol/socialfriendapi/FriendsRejectRequest;", "friendsRejectRequest", "friendsRequest", "friendsRequestParam", "Lcom/hive/SocialHive$FriendsRequestParam;", "Lcom/hive/protocol/socialfriendapi/FriendsRequest;", "friendsFacebookRequest", "friendsFacebookRequestParam", "Lcom/hive/SocialHive$FriendsFacebookRequestParam;", "Lcom/hive/protocol/socialfriendapi/FriendsFacebookRequest;", "friendsReceiveList", "friendsReceiveListParam", "Lcom/hive/SocialHive$FriendsReceiveListParam;", "Lcom/hive/protocol/socialfriendapi/FriendsReceiveList;", "guestStatusSaveData", "guestStatusSaveDataParam", "Lcom/hive/SocialHive$GuestStatusSaveDataParam;", "Lcom/hive/protocol/socialapi/GuestStatusSaveData;", "userMeNotification", "Lcom/hive/protocol/socialapi/UserMeNotification;", "userModify", "comment", "Lcom/hive/protocol/socialapi/UserModify;", "getFriends", "isV2Request", "friendType", "Lcom/hive/SocialHive$FriendType;", "getFriendsParam", "Lcom/hive/SocialHive$GetFriendsParam;", "getInvitations", "messageWrite", "messageContent", "Lcom/hive/SocialHive$MessageContent;", "isInvite", "Lcom/hive/protocol/socialfriendapi/MessageWrite;", "requestDeviceRegistered", "Lcom/hive/protocol/socialapi/DeviceRegistered;", "registered", "requestAcaLoginPlayGamesService", "resultAPI", "Lcom/hive/protocol/socialapi/AcaLoginPlayGamesService;", "loginPGS", "requestAcaLoginPlayGamesServiceSet", "Lcom/hive/protocol/socialapi/AcaLoginPlayGamesServiceSet;", "requestUserDelete", "Lcom/hive/protocol/socialapi/AcaUserQuitRequest;", "userDelete", "requestGuestKey", "guestUid", ClientData.KEY_CHALLENGE, "Lcom/hive/protocol/socialapi/GuestKey;", "guestKey", "requestGuestGenerate", "guestGenerateParam", "Lcom/hive/SocialHive$GuestGenerateParam;", "Lcom/hive/protocol/socialapi/GuestGenerate;", "guestGenerate", "requestGuestLogin", "guestLoginParam", "Lcom/hive/SocialHive$GuestLoginParam;", "Lcom/hive/protocol/socialapi/GuestLogin;", "guestLogin", "requestSocialConnect", "Lcom/hive/protocol/socialapi/SocialConnect;", "socialConnect", "requestUndefinedRequest", "Lcom/hive/protocol/socialapi/UndefinedRequest;", "undefinedRequest", "messageNotiCount", "Lcom/hive/protocol/socialfriendapi/MessageNotiCount;", "Lcom/hive/SocialHive$SocialBadge;", "badge", "acaDeleteCookies", "peppermint", "responseJson", "encodeHashAES", "enKey", "plainText", "addDefaultData", "key", "value", "removeDefaultData", "getDefaultData", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveGraph {
    public static final HiveGraph INSTANCE = new HiveGraph();
    private static final String PEPPERMINT_QPYOU_COOKIE_URL = ".qpyou.cn";
    private static HashMap<String, String> additionalDefaultData = new HashMap<>();

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SocialHive.FriendType.values().length];
            try {
                iArr[SocialHive.FriendType.ALL_GAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SocialHive.FriendType.IN_GAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SocialHive.FriendType.OUT_GAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SocialHive.FriendType.INVITED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private HiveGraph() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit acaDeleteCookies$lambda$59(Function2 function2, AcaDeleteCookies it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResponse().isSuccess()) {
            function2.invoke(new ResultAPI(), it.getResponse().getPeppermintResult());
        } else {
            function2.invoke(new ResultAPI(-8, ResultAPI.Code.AuthServerResponseNotSuccessful), it.getResponse().getPeppermintResult());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteSaveData$lambda$19(Function2 function2, SaveDataDelete it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deviceUsePgs$lambda$0(Function4 function4, DeviceUsePgs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function4.invoke(INSTANCE.toResultAPI(it.getResponse()), it, Boolean.valueOf(it.getResponse().getUsePgs()), Integer.valueOf(it.getResponse().getMaxRetryPgs()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit downloadSaveData$lambda$18(Function2 function2, SaveDataDownload it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit friendsFacebookRequest$lambda$24(Function2 function2, FriendsFacebookRequest it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit friendsReceiveList$lambda$25(Function2 function2, FriendsReceiveList it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit friendsRequest$lambda$23(Function2 function2, FriendsRequest it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFriends$lambda$40(SocialHive.FriendType friendType, boolean z, SocialHive.GetFriendsParam getFriendsParam, Function2 function2) throws JSONException {
        ResultAPI resultAPI;
        JSONArray friendJsonArray;
        ArrayList arrayList = new ArrayList();
        int i = WhenMappings.$EnumSwitchMapping$0[friendType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Protocol.Companion companion = Protocol.INSTANCE;
                    Protocol protocol = new Protocol(new Function0<FriendsInvite>() { // from class: com.hive.social.HiveGraph$getFriends$lambda$40$$inlined$invoke$7
                        /* JADX WARN: Can't rename method to resolve collision */
                        /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialfriendapi.FriendsInvite] */
                        @Override // kotlin.jvm.functions.Function0
                        public final FriendsInvite invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                            Object objNewInstance = FriendsInvite.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                            Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                            return (ProtocolRequest) objNewInstance;
                        }
                    });
                    if (getFriendsParam != null) {
                        if (getFriendsParam.getLimit() < 0) {
                            protocol.setParam("limit", (Object) 50);
                        } else {
                            protocol.setParam("limit", Integer.valueOf(getFriendsParam.getLimit()));
                        }
                    }
                    protocol.setParam(HiveKeys.KEY_vid_type, HiveLifecycle.INSTANCE.getAccount().getVidType());
                    try {
                        protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(INSTANCE.getDefaultData()));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    FriendsInvite.FriendsInviteResponse response = ((FriendsInvite) protocol.request()).getResponse();
                    resultAPI = INSTANCE.toResultAPI(response);
                    friendJsonArray = response.getFriendJsonArray();
                } else if (z) {
                    Protocol.Companion companion2 = Protocol.INSTANCE;
                    Protocol protocol2 = new Protocol(new Function0<FriendsOutGameEx>() { // from class: com.hive.social.HiveGraph$getFriends$lambda$40$$inlined$invoke$6
                        /* JADX WARN: Can't rename method to resolve collision */
                        /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialfriendapi.FriendsOutGameEx] */
                        @Override // kotlin.jvm.functions.Function0
                        public final FriendsOutGameEx invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                            Object objNewInstance = FriendsOutGameEx.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                            Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                            return (ProtocolRequest) objNewInstance;
                        }
                    });
                    protocol2.setParam(HiveKeys.KEY_vid_type, HiveLifecycle.INSTANCE.getAccount().getVidType());
                    try {
                        protocol2.setParam(HiveKeys.KEY_cookies, new JSONObject(INSTANCE.getDefaultData()));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    FriendsOutGameEx.FriendsOutGameExResponse response2 = ((FriendsOutGameEx) protocol2.request()).getResponse();
                    resultAPI = INSTANCE.toResultAPI(response2);
                    friendJsonArray = response2.getFriendJsonArray();
                } else {
                    Protocol.Companion companion3 = Protocol.INSTANCE;
                    Protocol protocol3 = new Protocol(new Function0<FriendsOutGame>() { // from class: com.hive.social.HiveGraph$getFriends$lambda$40$$inlined$invoke$5
                        /* JADX WARN: Can't rename method to resolve collision */
                        /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialfriendapi.FriendsOutGame] */
                        @Override // kotlin.jvm.functions.Function0
                        public final FriendsOutGame invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                            Object objNewInstance = FriendsOutGame.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                            Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                            return (ProtocolRequest) objNewInstance;
                        }
                    });
                    protocol3.setParam(HiveKeys.KEY_vid_type, HiveLifecycle.INSTANCE.getAccount().getVidType());
                    try {
                        protocol3.setParam(HiveKeys.KEY_cookies, new JSONObject(INSTANCE.getDefaultData()));
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    FriendsOutGame.FriendsOutGameResponse response3 = ((FriendsOutGame) protocol3.request()).getResponse();
                    resultAPI = INSTANCE.toResultAPI(response3);
                    friendJsonArray = response3.getFriendJsonArray();
                }
            } else if (z) {
                Protocol.Companion companion4 = Protocol.INSTANCE;
                Protocol protocol4 = new Protocol(new Function0<FriendsInGameEx>() { // from class: com.hive.social.HiveGraph$getFriends$lambda$40$$inlined$invoke$4
                    /* JADX WARN: Can't rename method to resolve collision */
                    /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialfriendapi.FriendsInGameEx] */
                    @Override // kotlin.jvm.functions.Function0
                    public final FriendsInGameEx invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                        Object objNewInstance = FriendsInGameEx.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                        return (ProtocolRequest) objNewInstance;
                    }
                });
                protocol4.setParam(HiveKeys.KEY_vid_type, HiveLifecycle.INSTANCE.getAccount().getVidType());
                try {
                    protocol4.setParam(HiveKeys.KEY_cookies, new JSONObject(INSTANCE.getDefaultData()));
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
                FriendsInGameEx.FriendsInGameExResponse response4 = ((FriendsInGameEx) protocol4.request()).getResponse();
                resultAPI = INSTANCE.toResultAPI(response4);
                friendJsonArray = response4.getFriendJsonArray();
            } else {
                Protocol.Companion companion5 = Protocol.INSTANCE;
                Protocol protocol5 = new Protocol(new Function0<FriendsInGame>() { // from class: com.hive.social.HiveGraph$getFriends$lambda$40$$inlined$invoke$3
                    /* JADX WARN: Can't rename method to resolve collision */
                    /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialfriendapi.FriendsInGame] */
                    @Override // kotlin.jvm.functions.Function0
                    public final FriendsInGame invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                        Object objNewInstance = FriendsInGame.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                        return (ProtocolRequest) objNewInstance;
                    }
                });
                protocol5.setParam(HiveKeys.KEY_vid_type, HiveLifecycle.INSTANCE.getAccount().getVidType());
                try {
                    protocol5.setParam(HiveKeys.KEY_cookies, new JSONObject(INSTANCE.getDefaultData()));
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
                FriendsInGame.FriendsInGameResponse response5 = ((FriendsInGame) protocol5.request()).getResponse();
                resultAPI = INSTANCE.toResultAPI(response5);
                friendJsonArray = response5.getFriendJsonArray();
            }
        } else if (z) {
            Protocol.Companion companion6 = Protocol.INSTANCE;
            Protocol protocol6 = new Protocol(new Function0<FriendsAllEx>() { // from class: com.hive.social.HiveGraph$getFriends$lambda$40$$inlined$invoke$2
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialfriendapi.FriendsAllEx] */
                @Override // kotlin.jvm.functions.Function0
                public final FriendsAllEx invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = FriendsAllEx.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            protocol6.setParam(HiveKeys.KEY_vid_type, HiveLifecycle.INSTANCE.getAccount().getVidType());
            try {
                protocol6.setParam(HiveKeys.KEY_cookies, new JSONObject(INSTANCE.getDefaultData()));
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
            FriendsAllEx.FriendsAllExResponse response6 = ((FriendsAllEx) protocol6.request()).getResponse();
            resultAPI = INSTANCE.toResultAPI(response6);
            friendJsonArray = response6.getFriendJsonArray();
        } else {
            Protocol.Companion companion7 = Protocol.INSTANCE;
            Protocol protocol7 = new Protocol(new Function0<FriendsAll>() { // from class: com.hive.social.HiveGraph$getFriends$lambda$40$$inlined$invoke$1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialfriendapi.FriendsAll] */
                @Override // kotlin.jvm.functions.Function0
                public final FriendsAll invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                    Object objNewInstance = FriendsAll.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                    return (ProtocolRequest) objNewInstance;
                }
            });
            protocol7.setParam(HiveKeys.KEY_vid_type, HiveLifecycle.INSTANCE.getAccount().getVidType());
            try {
                protocol7.setParam(HiveKeys.KEY_cookies, new JSONObject(INSTANCE.getDefaultData()));
            } catch (JSONException e7) {
                e7.printStackTrace();
            }
            FriendsAll.FriendsAllResponse response7 = ((FriendsAll) protocol7.request()).getResponse();
            resultAPI = INSTANCE.toResultAPI(response7);
            friendJsonArray = response7.getFriendJsonArray();
        }
        if (friendJsonArray != null) {
            int length = friendJsonArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObjectOptJSONObject = friendJsonArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null) {
                    boolean z2 = friendType == SocialHive.FriendType.IN_GAME;
                    SocialHive.ProfileHive profileHive = INSTANCE.toProfileHive(jSONObjectOptJSONObject);
                    if (profileHive.getGameFriend() == null) {
                        profileHive.setGameFriend(Boolean.valueOf(z2));
                    }
                    arrayList.add(profileHive);
                }
            }
        }
        function2.invoke(resultAPI, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getInvitations$lambda$43(SocialHive.GetFriendsParam getFriendsParam, Function2 function2) throws JSONException {
        new JSONObject();
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<FriendsInvite>() { // from class: com.hive.social.HiveGraph$getInvitations$lambda$43$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialfriendapi.FriendsInvite] */
            @Override // kotlin.jvm.functions.Function0
            public final FriendsInvite invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = FriendsInvite.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        if (getFriendsParam != null && getFriendsParam.getLimit() > 0) {
            protocol.setParam("limit", Integer.valueOf(getFriendsParam.getLimit()));
        }
        try {
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(INSTANCE.getDefaultData()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        FriendsInvite.FriendsInviteResponse response = ((FriendsInvite) protocol.request()).getResponse();
        function2.invoke(INSTANCE.toResultAPI(response), response.getContentJSONObject());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit guestStatusSaveData$lambda$26(Function2 function2, GuestStatusSaveData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit messageNotiCount$lambda$58(Function3 function3, MessageNotiCount it) {
        Intrinsics.checkNotNullParameter(it, "it");
        SocialHive.SocialBadge socialBadge = new SocialHive.SocialBadge();
        socialBadge.setMessageCount(it.getResponse().getMessageCount());
        function3.invoke(INSTANCE.toResultAPI(it.getResponse()), it, socialBadge);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit messageWrite$lambda$44(Function2 function2, MessageWrite it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rejectRequest$lambda$22(Function2 function2, FriendsRejectRequest it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestAcaLoginPlayGamesService$lambda$46(Function2 function2, AcaLoginPlayGamesService it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestAcaLoginPlayGamesServiceSet$lambda$47(Function2 function2, AcaLoginPlayGamesServiceSet it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestDeviceRegistered$lambda$45(Function2 function2, DeviceRegistered it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestGuestGenerate$lambda$51(Function2 function2, GuestGenerate it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestGuestKey$lambda$49(Function2 function2, GuestKey it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestGuestLogin$lambda$53(Function2 function2, GuestLogin it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestSocialConnect$lambda$54(Function2 function2, SocialConnect it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestUndefinedRequest$lambda$56(Function2 function2, UndefinedRequest it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestUserDelete$lambda$48(Function2 function2, AcaUserQuitRequest it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    private final SocialHive.ProfileGetUser toProfileGetUser(JSONObject jSONObject) {
        SocialHive.ProfileGetUser profileGetUser = new SocialHive.ProfileGetUser();
        profileGetUser.setPlayerId(jSONObject.optString("player_id", null));
        profileGetUser.setUserId(jSONObject.optString(AccessToken.USER_ID_KEY, null));
        profileGetUser.setPublisherId(jSONObject.optString("publisher_id", null));
        profileGetUser.setIdpIndex(jSONObject.optString("idp_index", null));
        profileGetUser.setProfileName(jSONObject.optString("profile_name", null));
        profileGetUser.setDefaultImg(jSONObject.optString("default_img", null));
        profileGetUser.setProfileImg(jSONObject.optString("profile_img", null));
        profileGetUser.setImageType(jSONObject.optString("image_type", null));
        profileGetUser.setStatus(jSONObject.optString("status", null));
        profileGetUser.setAdddate(jSONObject.optString("adddate", null));
        profileGetUser.setModdate(jSONObject.optString("moddate", null));
        profileGetUser.setIdpId(jSONObject.optString("idp_id", null));
        return profileGetUser;
    }

    private final SocialHive.ProfileHive toProfileHive(JSONObject jSONObject) {
        SocialHive.ProfileHive profileHive = new SocialHive.ProfileHive();
        profileHive.setUid(jSONObject.optString("uid"));
        profileHive.setIdentifier(jSONObject.optString("id"));
        profileHive.setUserName(jSONObject.optString("name", null));
        profileHive.setEmail(jSONObject.optString("email", null));
        profileHive.setFacebookId(jSONObject.optString("fbid", null));
        profileHive.setProfileImageUrl(jSONObject.optString("picture", null));
        profileHive.setCountry(jSONObject.optString(UserDataStore.COUNTRY, null));
        profileHive.setBirthday(jSONObject.optString("birthday", null));
        profileHive.setGender(jSONObject.optString("gender", null));
        profileHive.setComment(jSONObject.optString("comment", null));
        profileHive.setTestAccount(Boolean.valueOf(jSONObject.optInt("is_test_account") != 0));
        profileHive.setCached(Boolean.valueOf(jSONObject.optBoolean("cached")));
        profileHive.setAssnet(jSONObject.optString("assnet"));
        if (jSONObject.has("game_friend")) {
            profileHive.setGameFriend(Boolean.valueOf(jSONObject.optBoolean("game_friend")));
        }
        profileHive.setRelationRoute(jSONObject.optBoolean("is_hive") ? SocialHive.HiveRelationRoute.HIVE : jSONObject.optBoolean("is_facebook") ? SocialHive.HiveRelationRoute.FACEBOOK : jSONObject.optBoolean("is_game") ? SocialHive.HiveRelationRoute.GAME : jSONObject.optBoolean("is_contact") ? SocialHive.HiveRelationRoute.CONTACT : SocialHive.HiveRelationRoute.DEFAULT);
        return profileHive;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit uploadImage$lambda$20(Function2 function2, UploadImage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit uploadSaveData$lambda$17(Function2 function2, SaveDataUpload it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit userEx$lambda$4(Function3 function3, UserEx it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function3.invoke(INSTANCE.toResultAPI(it.getResponse()), it, it.getResponse().isSuccess() ? INSTANCE.toProfileHive(it.getResponse().getContentJSONObject()) : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit userMe$lambda$1(Function3 function3, UserMe it) {
        SocialHive.ProfileHive profileHive;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResponse().isSuccess()) {
            profileHive = INSTANCE.toProfileHive(it.getResponse().getContentJSONObject());
            profileHive.setVid(Property.INSTANCE.getINSTANCE().getValue(AuthKeys.ACCOUNT_VID));
        } else {
            profileHive = null;
        }
        function3.invoke(INSTANCE.toResultAPI(it.getResponse()), it, profileHive);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit userMeEx$lambda$2(Function3 function3, UserMeEx it) {
        SocialHive.ProfileHive profileHive;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResponse().isSuccess()) {
            profileHive = INSTANCE.toProfileHive(it.getResponse().getContentJSONObject());
            profileHive.setVid(Property.INSTANCE.getINSTANCE().getValue(AuthKeys.ACCOUNT_VID));
        } else {
            profileHive = null;
        }
        function3.invoke(INSTANCE.toResultAPI(it.getResponse()), it, profileHive);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit userMeNotification$lambda$27(Function2 function2, UserMeNotification it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit userModify$lambda$28(Function2 function2, UserModify it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit users$lambda$7(Function3 function3, Users it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ArrayList arrayList = new ArrayList();
        JSONArray uidListJsonArray = it.getResponse().getUidListJsonArray();
        if (uidListJsonArray != null) {
            int length = uidListJsonArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = uidListJsonArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(INSTANCE.toProfileHive(jSONObjectOptJSONObject));
                }
            }
        }
        function3.invoke(INSTANCE.toResultAPI(it.getResponse()), it, arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit usersInfo$lambda$10(Function3 function3, UsersInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ArrayList arrayList = new ArrayList();
        JSONArray uidListJsonArray = it.getResponse().getUidListJsonArray();
        if (uidListJsonArray != null) {
            int length = uidListJsonArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = uidListJsonArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(INSTANCE.toProfileHive(jSONObjectOptJSONObject));
                }
            }
        }
        function3.invoke(INSTANCE.toResultAPI(it.getResponse()), it, arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit wallWrite$lambda$21(Function2 function2, WallWrite it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(INSTANCE.toResultAPI(it.getResponse()), it);
        return Unit.INSTANCE;
    }

    public final void acaDeleteCookies(String peppermint, final Function2<? super ResultAPI, ? super JSONObject, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<AcaDeleteCookies>() { // from class: com.hive.social.HiveGraph$acaDeleteCookies$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialapi.AcaDeleteCookies] */
            @Override // kotlin.jvm.functions.Function0
            public final AcaDeleteCookies invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = AcaDeleteCookies.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            protocol.setParam(HiveKeys.KEY_appid, ConfigurationImpl.INSTANCE.getAppId());
            protocol.setParam(HiveKeys.KEY_peppermint, peppermint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.acaDeleteCookies$lambda$59(callback, (AcaDeleteCookies) obj);
            }
        });
    }

    public final synchronized void addDefaultData(String key, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (key != null) {
            additionalDefaultData.put(key, value);
        }
    }

    @Deprecated(message = "")
    public final void deleteSaveData(final Function2<? super ResultAPI, ? super SaveDataDelete, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<SaveDataDelete>() { // from class: com.hive.social.HiveGraph$deleteSaveData$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialotherapi.SaveDataDelete] */
            @Override // kotlin.jvm.functions.Function0
            public final SaveDataDelete invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = SaveDataDelete.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.deleteSaveData$lambda$19(callback, (SaveDataDelete) obj);
            }
        });
    }

    public final void deviceUsePgs(final Function4<? super ResultAPI, ? super DeviceUsePgs, ? super Boolean, ? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<DeviceUsePgs>() { // from class: com.hive.social.HiveGraph$deviceUsePgs$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialapi.DeviceUsePgs] */
            @Override // kotlin.jvm.functions.Function0
            public final DeviceUsePgs invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = DeviceUsePgs.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        int i = Integer.parseInt(Property.INSTANCE.getINSTANCE().getValue(SocialKeys.INSTANCE.getRETRY_PGS(), AppEventsConstants.EVENT_PARAM_VALUE_NO));
        protocol.setParam(HiveKeys.KEY_vid_type, HiveLifecycle.INSTANCE.getAccount().getVidType());
        protocol.setParam(HiveKeys.KEY_appid, ConfigurationImpl.INSTANCE.getAppId());
        protocol.setParam(HiveKeys.KEY_retrypgs, Integer.valueOf(i));
        try {
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.deviceUsePgs$lambda$0(callback, (DeviceUsePgs) obj);
            }
        });
    }

    @Deprecated(message = "")
    public final void downloadSaveData(final Function2<? super ResultAPI, ? super SaveDataDownload, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<SaveDataDownload>() { // from class: com.hive.social.HiveGraph$downloadSaveData$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialotherapi.SaveDataDownload] */
            @Override // kotlin.jvm.functions.Function0
            public final SaveDataDownload invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = SaveDataDownload.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.downloadSaveData$lambda$18(callback, (SaveDataDownload) obj);
            }
        });
    }

    public final String encodeHashAES(String enKey, String plainText) {
        Intrinsics.checkNotNullParameter(enKey, "enKey");
        Intrinsics.checkNotNullParameter(plainText, "plainText");
        Crypto crypto = Crypto.INSTANCE;
        Crypto.HashType hashType = Crypto.HashType.MD5;
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
        byte[] bytes = enKey.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String strCreateHash = crypto.createHash(hashType, bytes);
        Charset charsetForName2 = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName2, "forName(...)");
        byte[] bytes2 = plainText.getBytes(charsetForName2);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        String strCreateHash2 = crypto.createHash(hashType, bytes2);
        Charset charsetForName3 = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName3, "forName(...)");
        byte[] bytes3 = plainText.getBytes(charsetForName3);
        Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
        byte[] bArrEncryptAES = crypto.encryptAES(hashType, enKey, bytes3, 2);
        if (bArrEncryptAES == null) {
            return strCreateHash + strCreateHash2;
        }
        return strCreateHash + strCreateHash2 + new String(bArrEncryptAES, Charsets.UTF_8);
    }

    public final void friendsFacebookRequest(SocialHive.FriendsFacebookRequestParam friendsFacebookRequestParam, final Function2<? super ResultAPI, ? super FriendsFacebookRequest, Unit> callback) {
        Intrinsics.checkNotNullParameter(friendsFacebookRequestParam, "friendsFacebookRequestParam");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<FriendsFacebookRequest>() { // from class: com.hive.social.HiveGraph$friendsFacebookRequest$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialfriendapi.FriendsFacebookRequest] */
            @Override // kotlin.jvm.functions.Function0
            public final FriendsFacebookRequest invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = FriendsFacebookRequest.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            protocol.setParam("token", friendsFacebookRequestParam.getToken());
            protocol.setParam(PangleConstants.APP_ID, friendsFacebookRequestParam.getFacebookAppId());
            protocol.setParam(NotificationCompat.CATEGORY_SERVICE, friendsFacebookRequestParam.getService());
            protocol.setParam("type", friendsFacebookRequestParam.getType());
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.friendsFacebookRequest$lambda$24(callback, (FriendsFacebookRequest) obj);
            }
        });
    }

    public final void friendsReceiveList(SocialHive.FriendsReceiveListParam friendsReceiveListParam, final Function2<? super ResultAPI, ? super FriendsReceiveList, Unit> callback) {
        Intrinsics.checkNotNullParameter(friendsReceiveListParam, "friendsReceiveListParam");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<FriendsReceiveList>() { // from class: com.hive.social.HiveGraph$friendsReceiveList$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialfriendapi.FriendsReceiveList] */
            @Override // kotlin.jvm.functions.Function0
            public final FriendsReceiveList invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = FriendsReceiveList.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            protocol.setParam("count", Integer.valueOf(friendsReceiveListParam.getCount()));
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.friendsReceiveList$lambda$25(callback, (FriendsReceiveList) obj);
            }
        });
    }

    public final void friendsRequest(SocialHive.FriendsRequestParam friendsRequestParam, final Function2<? super ResultAPI, ? super FriendsRequest, Unit> callback) {
        Intrinsics.checkNotNullParameter(friendsRequestParam, "friendsRequestParam");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<FriendsRequest>() { // from class: com.hive.social.HiveGraph$friendsRequest$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialfriendapi.FriendsRequest] */
            @Override // kotlin.jvm.functions.Function0
            public final FriendsRequest invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = FriendsRequest.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            protocol.setParam("friend_uid", friendsRequestParam.getFriendUid());
            protocol.setParam("show_status", Boolean.valueOf(friendsRequestParam.getShowStatus()));
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.friendsRequest$lambda$23(callback, (FriendsRequest) obj);
            }
        });
    }

    public final HashMap<String, String> getAdditionalDefaultData() {
        return additionalDefaultData;
    }

    public final synchronized Map<String, String> getDefaultData() {
        HashMap map;
        map = new HashMap(additionalDefaultData);
        ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
        map.put("peppermint_version", configurationImpl.getPeppermintNativeVersion());
        String peppermintInitAppId = configurationImpl.getPeppermintInitAppId();
        if (TextUtils.isEmpty(peppermintInitAppId)) {
            peppermintInitAppId = null;
        }
        if (peppermintInitAppId == null) {
            peppermintInitAppId = Configuration.getAppId();
        }
        map.put(PangleConstants.APP_ID, peppermintInitAppId);
        Android android2 = Android.INSTANCE;
        String deviceModel = android2.getDeviceModel();
        if (deviceModel == null) {
            deviceModel = "";
        }
        map.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, deviceModel);
        map.put("platform", "android");
        map.put("os_version", Build.VERSION.RELEASE);
        String did = HiveLifecycle.INSTANCE.getDid();
        if (did == null) {
            did = "";
        }
        map.put("did", did);
        map.put("enable_cookie", "no");
        Property.Companion companion = Property.INSTANCE;
        Property instance = companion.getINSTANCE();
        SocialKeys socialKeys = SocialKeys.INSTANCE;
        String value = instance.getValue(socialKeys.getPEPPERMINT());
        if (value != null && !StringsKt.isBlank(value)) {
            map.put("peppermint", value);
        }
        String value2 = companion.getINSTANCE().getValue(socialKeys.getPEPPERMINT_GUEST());
        if (value2 != null && !StringsKt.isBlank(value2)) {
            map.put("peppermint_guest", value2);
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        String androidId = android2.getAndroidId();
        String advertisingId = android2.getAdvertisingId();
        try {
            String strEncodeHashAES = encodeHashAES(strValueOf, androidId == null ? AbstractJsonLexerKt.NULL : androidId);
            if (advertisingId == null) {
                advertisingId = AbstractJsonLexerKt.NULL;
            }
            String strEncodeHashAES2 = encodeHashAES(strValueOf, advertisingId);
            map.put("hub_ck3", strEncodeHashAES);
            map.put("hub_ck4", strEncodeHashAES2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            map.put("android_id", encodeHashAES(strValueOf, androidId == null ? AbstractJsonLexerKt.NULL : androidId));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        HiveLifecycle.HiveAccount account = HiveLifecycle.INSTANCE.getAccount();
        String vidType = account.getVidType();
        if (vidType != null) {
            map.put("vid_type", vidType);
        }
        String vid = account.getVid();
        if (vid != null) {
            map.put("vid", vid);
        }
        LoggerImpl.INSTANCE.dL("androidId=" + androidId);
        return map;
    }

    public final void getFriends(final boolean isV2Request, final SocialHive.FriendType friendType, final SocialHive.GetFriendsParam getFriendsParam, final Function2<? super ResultAPI, ? super ArrayList<SocialHive.ProfileHive>, Unit> callback) {
        Intrinsics.checkNotNullParameter(friendType, "friendType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        new Thread(new Runnable() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda26
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                HiveGraph.getFriends$lambda$40(friendType, isV2Request, getFriendsParam, callback);
            }
        }).start();
    }

    public final void getInvitations(final SocialHive.GetFriendsParam getFriendsParam, final Function2<? super ResultAPI, ? super JSONObject, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        new Thread(new Runnable() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                HiveGraph.getInvitations$lambda$43(getFriendsParam, callback);
            }
        }).start();
    }

    public final String getPEPPERMINT_QPYOU_COOKIE_URL() {
        return PEPPERMINT_QPYOU_COOKIE_URL;
    }

    @Deprecated(message = "")
    public final void guestStatusSaveData(SocialHive.GuestStatusSaveDataParam guestStatusSaveDataParam, final Function2<? super ResultAPI, ? super GuestStatusSaveData, Unit> callback) {
        Intrinsics.checkNotNullParameter(guestStatusSaveDataParam, "guestStatusSaveDataParam");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<GuestStatusSaveData>() { // from class: com.hive.social.HiveGraph$guestStatusSaveData$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialapi.GuestStatusSaveData] */
            @Override // kotlin.jvm.functions.Function0
            public final GuestStatusSaveData invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = GuestStatusSaveData.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            protocol.setParam("uid", guestStatusSaveDataParam.getUid());
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.guestStatusSaveData$lambda$26(callback, (GuestStatusSaveData) obj);
            }
        });
    }

    public final void messageNotiCount(final Function3<? super ResultAPI, ? super MessageNotiCount, ? super SocialHive.SocialBadge, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<MessageNotiCount>() { // from class: com.hive.social.HiveGraph$messageNotiCount$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialfriendapi.MessageNotiCount] */
            @Override // kotlin.jvm.functions.Function0
            public final MessageNotiCount invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = MessageNotiCount.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        protocol.setParam(HiveKeys.KEY_vid_type, HiveLifecycle.INSTANCE.getAccount().getVidType());
        try {
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.messageNotiCount$lambda$58(callback, (MessageNotiCount) obj);
            }
        });
    }

    public final void messageWrite(SocialHive.MessageContent messageContent, boolean isInvite, final Function2<? super ResultAPI, ? super MessageWrite, Unit> callback) {
        Intrinsics.checkNotNullParameter(messageContent, "messageContent");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<MessageWrite>() { // from class: com.hive.social.HiveGraph$messageWrite$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialfriendapi.MessageWrite] */
            @Override // kotlin.jvm.functions.Function0
            public final MessageWrite invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = MessageWrite.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        protocol.setRetryNetwork(false);
        protocol.setParam(HiveKeys.KEY_vid_type, HiveLifecycle.INSTANCE.getAccount().getVidType());
        protocol.setParam(HiveKeys.KEY_uid, messageContent.getUid());
        protocol.setParam(HiveKeys.KEY_text, messageContent.getMessage());
        protocol.setParam(HiveKeys.KEY_picture, messageContent.getImageUrl());
        protocol.setParam(HiveKeys.KEY_thumbnail, messageContent.getThumbnailUrl());
        protocol.setParam(HiveKeys.KEY_push, Boolean.valueOf(messageContent.getUsePush()));
        protocol.setParam(HiveKeys.KEY_invite, Boolean.valueOf(isInvite));
        try {
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UserEngagementEventKt.appendQueryParameters(protocol, protocol);
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.messageWrite$lambda$44(callback, (MessageWrite) obj);
            }
        });
    }

    public final void profileGetUser(Collection<String> uidList, Function3<? super ResultAPI, ? super ProfileGetUser, ? super ArrayList<SocialHive.ProfileGetUser>, Unit> callback) {
        Intrinsics.checkNotNullParameter(uidList, "uidList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<ProfileGetUser>() { // from class: com.hive.social.HiveGraph$profileGetUser$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialapi.ProfileGetUser] */
            @Override // kotlin.jvm.functions.Function0
            public final ProfileGetUser invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = ProfileGetUser.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            protocol.setParam(AccessToken.USER_ID_KEY, new JSONArray((Collection) uidList));
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
            ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
            if (configurationImpl.getPeppermintInitAppId().length() > 0) {
                protocol.setParam(HiveKeys.KEY_appid, configurationImpl.getPeppermintInitAppId());
            } else {
                protocol.setParam(HiveKeys.KEY_appid, configurationImpl.getAppId());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        ProfileGetUser profileGetUser = (ProfileGetUser) protocol.request();
        ArrayList arrayList = new ArrayList();
        JSONArray dataListJsonArray = profileGetUser.getResponse().getDataListJsonArray();
        if (dataListJsonArray != null) {
            int length = dataListJsonArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = dataListJsonArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(INSTANCE.toProfileGetUser(jSONObjectOptJSONObject));
                }
            }
        }
        callback.invoke(INSTANCE.toResultAPI(profileGetUser.getResponse()), profileGetUser, arrayList);
    }

    public final void profileGetUserEx(Collection<String> uidList, Function3<? super Integer, ? super ProfileGetUser, ? super ArrayList<SocialHive.ProfileGetUser>, Unit> callback) {
        Intrinsics.checkNotNullParameter(uidList, "uidList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<ProfileGetUser>() { // from class: com.hive.social.HiveGraph$profileGetUserEx$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialapi.ProfileGetUser] */
            @Override // kotlin.jvm.functions.Function0
            public final ProfileGetUser invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = ProfileGetUser.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            if (uidList.size() == 1) {
                protocol.setParam(AccessToken.USER_ID_KEY, new JSONArray((Collection) uidList).get(0));
            } else {
                protocol.setParam(AccessToken.USER_ID_KEY, new JSONArray((Collection) uidList));
            }
            ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
            if (configurationImpl.getPeppermintInitAppId().length() > 0) {
                protocol.setParam(HiveKeys.KEY_appid, configurationImpl.getPeppermintInitAppId());
            } else {
                protocol.setParam(HiveKeys.KEY_appid, configurationImpl.getAppId());
            }
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
        } catch (JSONException e) {
            LoggerImpl.INSTANCE.w("profileGetUserEx, JSONException : " + e);
        } catch (Exception e2) {
            LoggerImpl.INSTANCE.w("profileGetUserEx, Exception : " + e2);
        }
        ProfileGetUser profileGetUser = (ProfileGetUser) protocol.request();
        ArrayList arrayList = new ArrayList();
        JSONArray dataListJsonArray = profileGetUser.getResponse().getDataListJsonArray();
        if (dataListJsonArray != null) {
            int length = dataListJsonArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = dataListJsonArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(INSTANCE.toProfileGetUser(jSONObjectOptJSONObject));
                }
            }
        }
        callback.invoke(Integer.valueOf(profileGetUser.getResponse().getResultCode()), profileGetUser, arrayList);
    }

    public final void rejectRequest(SocialHive.FriendsRejectRequestParam friendsRejectRequestParam, final Function2<? super ResultAPI, ? super FriendsRejectRequest, Unit> callback) {
        Intrinsics.checkNotNullParameter(friendsRejectRequestParam, "friendsRejectRequestParam");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<FriendsRejectRequest>() { // from class: com.hive.social.HiveGraph$rejectRequest$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialfriendapi.FriendsRejectRequest] */
            @Override // kotlin.jvm.functions.Function0
            public final FriendsRejectRequest invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = FriendsRejectRequest.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            protocol.setParam("uid", friendsRejectRequestParam.getUid());
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.rejectRequest$lambda$22(callback, (FriendsRejectRequest) obj);
            }
        });
    }

    public final synchronized void removeDefaultData(String key) {
        if (key != null) {
            additionalDefaultData.remove(key);
        }
    }

    public final void requestAcaLoginPlayGamesService(JSONObject jsonData, final Function2<? super ResultAPI, ? super AcaLoginPlayGamesService, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<AcaLoginPlayGamesService>() { // from class: com.hive.social.HiveGraph$requestAcaLoginPlayGamesService$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialapi.AcaLoginPlayGamesService] */
            @Override // kotlin.jvm.functions.Function0
            public final AcaLoginPlayGamesService invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = AcaLoginPlayGamesService.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        if (jsonData != null) {
            Iterator<String> itKeys = jsonData.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                String str = next;
                protocol.setParam(str, jsonData.opt(str));
            }
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.requestAcaLoginPlayGamesService$lambda$46(callback, (AcaLoginPlayGamesService) obj);
            }
        });
    }

    public final void requestAcaLoginPlayGamesServiceSet(JSONObject jsonData, final Function2<? super ResultAPI, ? super AcaLoginPlayGamesServiceSet, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<AcaLoginPlayGamesServiceSet>() { // from class: com.hive.social.HiveGraph$requestAcaLoginPlayGamesServiceSet$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialapi.AcaLoginPlayGamesServiceSet] */
            @Override // kotlin.jvm.functions.Function0
            public final AcaLoginPlayGamesServiceSet invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = AcaLoginPlayGamesServiceSet.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        if (jsonData != null) {
            Iterator<String> itKeys = jsonData.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                String str = next;
                protocol.setParam(str, jsonData.opt(str));
            }
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.requestAcaLoginPlayGamesServiceSet$lambda$47(callback, (AcaLoginPlayGamesServiceSet) obj);
            }
        });
    }

    public final void requestDeviceRegistered(final Function2<? super ResultAPI, ? super DeviceRegistered, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<DeviceRegistered>() { // from class: com.hive.social.HiveGraph$requestDeviceRegistered$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialapi.DeviceRegistered] */
            @Override // kotlin.jvm.functions.Function0
            public final DeviceRegistered invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = DeviceRegistered.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.requestDeviceRegistered$lambda$45(callback, (DeviceRegistered) obj);
            }
        });
    }

    public final void requestGuestGenerate(SocialHive.GuestGenerateParam guestGenerateParam, final Function2<? super ResultAPI, ? super GuestGenerate, Unit> callback) {
        Intrinsics.checkNotNullParameter(guestGenerateParam, "guestGenerateParam");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<GuestGenerate>() { // from class: com.hive.social.HiveGraph$requestGuestGenerate$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialapi.GuestGenerate] */
            @Override // kotlin.jvm.functions.Function0
            public final GuestGenerate invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = GuestGenerate.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        GuestGenerate guestGenerate = (GuestGenerate) protocol.getProtocol();
        guestGenerate.setRequestType(1);
        guestGenerate.setSubPath("");
        guestGenerate.setPublicKey(guestGenerateParam.getPublicKey());
        protocol.setParam(InAppPurchaseMetaData.KEY_SIGNATURE, guestGenerateParam.getSignature());
        ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
        protocol.setParam(PangleConstants.APP_ID, configurationImpl.getPeppermintInitAppId());
        protocol.setParam("did", AuthImpl.INSTANCE.getDID());
        protocol.setParam("native_version", configurationImpl.getPeppermintNativeVersion());
        protocol.setParam("hive_country", configurationImpl.getHiveCountry());
        protocol.setParam("expire_time", String.valueOf(System.currentTimeMillis() / ((long) 1000)));
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.requestGuestGenerate$lambda$51(callback, (GuestGenerate) obj);
            }
        });
    }

    public final void requestGuestKey(String guestUid, String challenge, final Function2<? super ResultAPI, ? super GuestKey, Unit> callback) {
        Intrinsics.checkNotNullParameter(guestUid, "guestUid");
        Intrinsics.checkNotNullParameter(challenge, "challenge");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<GuestKey>() { // from class: com.hive.social.HiveGraph$requestGuestKey$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialapi.GuestKey] */
            @Override // kotlin.jvm.functions.Function0
            public final GuestKey invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = GuestKey.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        if (!TextUtils.isEmpty(guestUid)) {
            protocol.setParam("guest_uid", guestUid);
            protocol.setParam(HiveKeys.KEY_client_id, com.hive.core.Configuration.INSTANCE.getPrimaryClientId());
            protocol.setParam(HiveKeys.KEY_code_challenge, challenge);
            protocol.setParam(HiveKeys.KEY_code_challenge_method, "S256");
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.requestGuestKey$lambda$49(callback, (GuestKey) obj);
            }
        });
    }

    public final void requestGuestLogin(SocialHive.GuestLoginParam guestLoginParam, final Function2<? super ResultAPI, ? super GuestLogin, Unit> callback) {
        Intrinsics.checkNotNullParameter(guestLoginParam, "guestLoginParam");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<GuestLogin>() { // from class: com.hive.social.HiveGraph$requestGuestLogin$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialapi.GuestLogin] */
            @Override // kotlin.jvm.functions.Function0
            public final GuestLogin invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = GuestLogin.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        GuestLogin guestLogin = (GuestLogin) protocol.getProtocol();
        guestLogin.setRequestType(1);
        guestLogin.setSubPath("");
        guestLogin.setPublicKey(guestLoginParam.getPublicKey());
        protocol.setParam(InAppPurchaseMetaData.KEY_SIGNATURE, guestLoginParam.getSignature());
        ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
        protocol.setParam(PangleConstants.APP_ID, configurationImpl.getPeppermintInitAppId());
        AuthImpl authImpl = AuthImpl.INSTANCE;
        protocol.setParam("did", authImpl.getDID());
        protocol.setParam("native_version", configurationImpl.getPeppermintNativeVersion());
        protocol.setParam("hive_country", configurationImpl.getHiveCountry());
        protocol.setParam("expire_time", String.valueOf(System.currentTimeMillis() / ((long) 1000)));
        protocol.setParam("guest_uid", guestLoginParam.getGuestUid());
        authImpl.setPeppermintCurrentUid(guestLoginParam.getGuestUid());
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.requestGuestLogin$lambda$53(callback, (GuestLogin) obj);
            }
        });
    }

    public final void requestSocialConnect(JSONObject jsonData, final Function2<? super ResultAPI, ? super SocialConnect, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<SocialConnect>() { // from class: com.hive.social.HiveGraph$requestSocialConnect$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialapi.SocialConnect] */
            @Override // kotlin.jvm.functions.Function0
            public final SocialConnect invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = SocialConnect.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        if (jsonData != null) {
            Iterator<String> itKeys = jsonData.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                String str = next;
                protocol.setParam(str, jsonData.opt(str));
            }
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.requestSocialConnect$lambda$54(callback, (SocialConnect) obj);
            }
        });
    }

    public final void requestUndefinedRequest(String subPath, final Function2<? super ResultAPI, ? super UndefinedRequest, Unit> callback) {
        Intrinsics.checkNotNullParameter(subPath, "subPath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<UndefinedRequest>() { // from class: com.hive.social.HiveGraph$requestUndefinedRequest$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialapi.UndefinedRequest] */
            @Override // kotlin.jvm.functions.Function0
            public final UndefinedRequest invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = UndefinedRequest.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        UndefinedRequest undefinedRequest = (UndefinedRequest) protocol.getProtocol();
        undefinedRequest.setRequestType(2);
        undefinedRequest.setSubPath(subPath);
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.requestUndefinedRequest$lambda$56(callback, (UndefinedRequest) obj);
            }
        });
    }

    public final void requestUserDelete(final Function2<? super ResultAPI, ? super AcaUserQuitRequest, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<AcaUserQuitRequest>() { // from class: com.hive.social.HiveGraph$requestUserDelete$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialapi.AcaUserQuitRequest] */
            @Override // kotlin.jvm.functions.Function0
            public final AcaUserQuitRequest invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = AcaUserQuitRequest.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            protocol.setParam(HiveKeys.KEY_appid, ConfigurationImpl.INSTANCE.getPeppermintInitAppId());
            HiveKeys hiveKeys = HiveKeys.KEY_did;
            HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
            protocol.setParam(hiveKeys, hiveLifecycle.getAccount().getDid());
            protocol.setParam(HiveKeys.KEY_uid, hiveLifecycle.getAccount().getUid());
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.requestUserDelete$lambda$48(callback, (AcaUserQuitRequest) obj);
            }
        });
    }

    public final void setAdditionalDefaultData(HashMap<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        additionalDefaultData = map;
    }

    public final ResultAPI toResultAPI(SocialApi.SocialApiResponse socialApiResponse) {
        Intrinsics.checkNotNullParameter(socialApiResponse, "<this>");
        return INSTANCE.toResultAPI(socialApiResponse.getResult(), socialApiResponse.getErrorCode(), socialApiResponse.getErrorMsg());
    }

    public final void uploadImage(SocialHive.UploadImageParam uploadImageParam, final Function2<? super ResultAPI, ? super UploadImage, Unit> callback) {
        Intrinsics.checkNotNullParameter(uploadImageParam, "uploadImageParam");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<UploadImage>() { // from class: com.hive.social.HiveGraph$uploadImage$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialotherapi.UploadImage] */
            @Override // kotlin.jvm.functions.Function0
            public final UploadImage invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = UploadImage.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            protocol.setParam("image", uploadImageParam.getImage());
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.uploadImage$lambda$20(callback, (UploadImage) obj);
            }
        });
    }

    @Deprecated(message = "")
    public final void uploadSaveData(SocialHive.UploadSaveDataParam uploadSaveDataParam, final Function2<? super ResultAPI, ? super SaveDataUpload, Unit> callback) {
        Intrinsics.checkNotNullParameter(uploadSaveDataParam, "uploadSaveDataParam");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<SaveDataUpload>() { // from class: com.hive.social.HiveGraph$uploadSaveData$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialotherapi.SaveDataUpload] */
            @Override // kotlin.jvm.functions.Function0
            public final SaveDataUpload invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = SaveDataUpload.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            protocol.setParam("data", uploadSaveDataParam.getData());
            protocol.setParam("hash", uploadSaveDataParam.getHash());
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.uploadSaveData$lambda$17(callback, (SaveDataUpload) obj);
            }
        });
    }

    public final void userEx(String subPath, JSONObject jsonData, final Function3<? super ResultAPI, ? super UserEx, ? super SocialHive.ProfileHive, Unit> callback) {
        Intrinsics.checkNotNullParameter(subPath, "subPath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<UserEx>() { // from class: com.hive.social.HiveGraph$userEx$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialapi.UserEx] */
            @Override // kotlin.jvm.functions.Function0
            public final UserEx invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = UserEx.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        ((UserEx) protocol.getProtocol()).setSubPath((String) StringsKt.split$default((CharSequence) subPath, new String[]{DomExceptionUtils.SEPARATOR}, false, 0, 6, (Object) null).get(r9.size() - 1));
        try {
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
            if (jsonData != null) {
                protocol.setParam(HiveKeys.KEY_guest_uid, jsonData.optString("guest_uid"));
                protocol.setParam(HiveKeys.KEY_did, jsonData.optString("did"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.userEx$lambda$4(callback, (UserEx) obj);
            }
        });
    }

    public final void userMe(final Function3<? super ResultAPI, ? super UserMe, ? super SocialHive.ProfileHive, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<UserMe>() { // from class: com.hive.social.HiveGraph$userMe$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialapi.UserMe] */
            @Override // kotlin.jvm.functions.Function0
            public final UserMe invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = UserMe.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        protocol.setParam(HiveKeys.KEY_vid_type, HiveLifecycle.INSTANCE.getAccount().getVidType());
        try {
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.userMe$lambda$1(callback, (UserMe) obj);
            }
        });
    }

    public final void userMeEx(final Function3<? super ResultAPI, ? super UserMeEx, ? super SocialHive.ProfileHive, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<UserMeEx>() { // from class: com.hive.social.HiveGraph$userMeEx$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialapi.UserMeEx] */
            @Override // kotlin.jvm.functions.Function0
            public final UserMeEx invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = UserMeEx.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.userMeEx$lambda$2(callback, (UserMeEx) obj);
            }
        });
    }

    public final void userMeNotification(final Function2<? super ResultAPI, ? super UserMeNotification, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<UserMeNotification>() { // from class: com.hive.social.HiveGraph$userMeNotification$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialapi.UserMeNotification] */
            @Override // kotlin.jvm.functions.Function0
            public final UserMeNotification invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = UserMeNotification.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.userMeNotification$lambda$27(callback, (UserMeNotification) obj);
            }
        });
    }

    public final void userModify(String comment, final Function2<? super ResultAPI, ? super UserModify, Unit> callback) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<UserModify>() { // from class: com.hive.social.HiveGraph$userModify$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialapi.UserModify] */
            @Override // kotlin.jvm.functions.Function0
            public final UserModify invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = UserModify.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        protocol.setParam(HiveKeys.KEY_vid_type, HiveLifecycle.INSTANCE.getAccount().getVidType());
        protocol.setParam(HiveKeys.KEY_comment, comment);
        try {
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.userModify$lambda$28(callback, (UserModify) obj);
            }
        });
    }

    public final void users(Collection<String> uidList, final Function3<? super ResultAPI, ? super Users, ? super ArrayList<SocialHive.ProfileHive>, Unit> callback) {
        Intrinsics.checkNotNullParameter(uidList, "uidList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<Users>() { // from class: com.hive.social.HiveGraph$users$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialapi.Users] */
            @Override // kotlin.jvm.functions.Function0
            public final Users invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = Users.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            protocol.setParam(HiveKeys.KEY_vid_type, HiveLifecycle.INSTANCE.getAccount().getVidType());
            protocol.setParam(HiveKeys.KEY_uid_list, new JSONArray((Collection) uidList));
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.users$lambda$7(callback, (Users) obj);
            }
        });
    }

    public final void usersInfo(Collection<String> uidList, final Function3<? super ResultAPI, ? super UsersInfo, ? super ArrayList<SocialHive.ProfileHive>, Unit> callback) {
        Intrinsics.checkNotNullParameter(uidList, "uidList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<UsersInfo>() { // from class: com.hive.social.HiveGraph$usersInfo$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialapi.UsersInfo] */
            @Override // kotlin.jvm.functions.Function0
            public final UsersInfo invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = UsersInfo.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            protocol.setParam(HiveKeys.KEY_uid_list, new JSONArray((Collection) uidList));
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.usersInfo$lambda$10(callback, (UsersInfo) obj);
            }
        });
    }

    @Deprecated(message = "")
    public final void wallWrite(SocialHive.WallWriteParam wallWriteParam, final Function2<? super ResultAPI, ? super WallWrite, Unit> callback) {
        Intrinsics.checkNotNullParameter(wallWriteParam, "wallWriteParam");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<WallWrite>() { // from class: com.hive.social.HiveGraph$wallWrite$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.socialapi.WallWrite] */
            @Override // kotlin.jvm.functions.Function0
            public final WallWrite invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = WallWrite.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        try {
            protocol.setParam("text", wallWriteParam.getText());
            protocol.setParam("picture", wallWriteParam.getPicture());
            protocol.setParam("video_link", wallWriteParam.getVideoLink());
            protocol.setParam(HiveKeys.KEY_cookies, new JSONObject(getDefaultData()));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        protocol.request(new Function1() { // from class: com.hive.social.HiveGraph$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveGraph.wallWrite$lambda$21(callback, (WallWrite) obj);
            }
        });
    }

    public final ResultAPI toResultAPI(SocialOtherApi.SocialOtherApiResponse socialOtherApiResponse) {
        Intrinsics.checkNotNullParameter(socialOtherApiResponse, "<this>");
        return INSTANCE.toResultAPI(socialOtherApiResponse.getResult(), socialOtherApiResponse.getErrorCode(), socialOtherApiResponse.getErrorMsg());
    }

    public final ResultAPI toResultAPI(SocialFriendApi.SocialFriendApiResponse socialFriendApiResponse) {
        Intrinsics.checkNotNullParameter(socialFriendApiResponse, "<this>");
        return INSTANCE.toResultAPI(socialFriendApiResponse.getResult(), socialFriendApiResponse.getErrorCode(), socialFriendApiResponse.getErrorMsg());
    }

    private final ResultAPI toResultAPI(Result coreResult, int responseCode, String responseMsg) {
        ResultAPI.Code code;
        ResultAPI.Code code2;
        if (coreResult.isFailure()) {
            return new ResultAPI(-5, ResultAPI.Code.SocialHIVEResponseFail, coreResult.getMessage());
        }
        int i = 0;
        if (responseCode != 0) {
            if (responseCode == 1101) {
                code2 = ResultAPI.Code.SocialHIVEResponseFail;
                responseMsg = "hive-DB ERROR Failed";
            } else if (responseCode == 1201) {
                code2 = ResultAPI.Code.SocialHIVEResponseFail;
                responseMsg = "hive-Server ERROR failed";
            } else if (responseCode == 1300) {
                code2 = ResultAPI.Code.SocialHIVEResponseFail;
                responseMsg = "hive-Authorization Failed";
            } else if (responseCode != 2300) {
                code2 = ResultAPI.Code.SocialHIVEResponseFail;
            } else {
                code = ResultAPI.Code.RefundUser;
            }
            code = code2;
            i = -8;
        } else {
            code = ResultAPI.Code.Success;
        }
        return new ResultAPI(i, code, responseMsg);
    }
}
