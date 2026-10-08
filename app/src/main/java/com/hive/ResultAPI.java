package com.hive;

import androidx.compose.animation.core.AnimationConstants;
import androidx.compose.material.TextFieldImplKt;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.InputDeviceCompat;
import com.adxcorp.ads.mediation.common.Constants;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.sdk.AppLovinErrorCodes;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.hive.ui.Resource;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u0001:\u0003,-.B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\bB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0002\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0002\u0010\fJ\u0006\u0010(\u001a\u00020\u001eJ\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020\nH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u0011\u0010 \u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b \u0010\u001fR$\u0010!\u001a\u00020\n2\u0006\u0010!\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b'\u0010#¨\u0006/"}, d2 = {"Lcom/hive/ResultAPI;", "", "<init>", "()V", "errorCode", "", "code", "Lcom/hive/ResultAPI$Code;", "(ILcom/hive/ResultAPI$Code;)V", "additionalMessage", "", "(ILcom/hive/ResultAPI$Code;Ljava/lang/String;)V", "(Lcom/hive/ResultAPI$Code;Ljava/lang/String;)V", "getErrorCode", "()I", "setErrorCode", "(I)V", "getCode", "()Lcom/hive/ResultAPI$Code;", "setCode", "(Lcom/hive/ResultAPI$Code;)V", "errorMessageFormat", "messageFormat", "latencyMs", "", "getLatencyMs", "()J", "setLatencyMs", "(J)V", "isSuccess", "", "()Z", "isFailure", "message", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "errorMessage", "getErrorMessage", "needExit", "toJson", "Lorg/json/JSONObject;", InAppPurchaseConstants.METHOD_TO_STRING, k.M, "Code", "PeppermintErrCode", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResultAPI {
    public static final int AUTHORIZED = 20;
    public static final int BLACKLIST = -12;
    public static final int CANCELED = -6;
    public static final int CONFLICT_PLAYER = -11;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int DEVELOPER_ERROR = -13;
    public static final int DUPLICATED_PROMOTION_CODE = -14;
    public static final int IAPSUCCESS = 90;
    public static final int INVALID_PARAM = -1;
    public static final int INVALID_SESSION = -9;
    public static final int IN_PROGRESS = -3;
    public static final int ITEM_DELIVERY_DELAYED = 11;
    public static final int ITEM_PENDING = 12;
    public static final int NEED_EXIT = -17;
    public static final int NEED_INITIALIZE = -7;
    public static final int NEED_RESTORE = -10;
    public static final int NETWORK = -5;
    public static final int NOT_OWNED = 10;
    public static final int NOT_SUPPORTED = -2;
    public static final int PLAYER_CHANGE = -15;
    public static final int RESPONSE_FAIL = -8;
    public static final int RESTORE_NOT_OWNED = 10;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = -4;
    public static final int UNDEFINED = -98;
    public static final int UNKNOWN = -99;
    public static final int USER_OUT = -16;
    private String additionalMessage;
    private Code code;
    private int errorCode;
    private String errorMessageFormat;
    private long latencyMs;
    private String messageFormat;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0019\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0003\b\u00ad\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQj\u0002\bRj\u0002\bSj\u0002\bTj\u0002\bUj\u0002\bVj\u0002\bWj\u0002\bXj\u0002\bYj\u0002\bZj\u0002\b[j\u0002\b\\j\u0002\b]j\u0002\b^j\u0002\b_j\u0002\b`j\u0002\baj\u0002\bbj\u0002\bcj\u0002\bdj\u0002\bej\u0002\bfj\u0002\bgj\u0002\bhj\u0002\bij\u0002\bjj\u0002\bkj\u0002\blj\u0002\bmj\u0002\bnj\u0002\boj\u0002\bpj\u0002\bqj\u0002\brj\u0002\bsj\u0002\btj\u0002\buj\u0002\bvj\u0002\bwj\u0002\bxj\u0002\byj\u0002\bzj\u0002\b{j\u0002\b|j\u0002\b}j\u0002\b~j\u0002\b\u007fj\u0003\b\u0080\u0001j\u0003\b\u0081\u0001j\u0003\b\u0082\u0001j\u0003\b\u0083\u0001j\u0003\b\u0084\u0001j\u0003\b\u0085\u0001j\u0003\b\u0086\u0001j\u0003\b\u0087\u0001j\u0003\b\u0088\u0001j\u0003\b\u0089\u0001j\u0003\b\u008a\u0001j\u0003\b\u008b\u0001j\u0003\b\u008c\u0001j\u0003\b\u008d\u0001j\u0003\b\u008e\u0001j\u0003\b\u008f\u0001j\u0003\b\u0090\u0001j\u0003\b\u0091\u0001j\u0003\b\u0092\u0001j\u0003\b\u0093\u0001j\u0003\b\u0094\u0001j\u0003\b\u0095\u0001j\u0003\b\u0096\u0001j\u0003\b\u0097\u0001j\u0003\b\u0098\u0001j\u0003\b\u0099\u0001j\u0003\b\u009a\u0001j\u0003\b\u009b\u0001j\u0003\b\u009c\u0001j\u0003\b\u009d\u0001j\u0003\b\u009e\u0001j\u0003\b\u009f\u0001j\u0003\b \u0001j\u0003\b¡\u0001j\u0003\b¢\u0001j\u0003\b£\u0001j\u0003\b¤\u0001j\u0003\b¥\u0001j\u0003\b¦\u0001j\u0003\b§\u0001j\u0003\b¨\u0001j\u0003\b©\u0001j\u0003\bª\u0001j\u0003\b«\u0001j\u0003\b¬\u0001j\u0003\b\u00ad\u0001j\u0003\b®\u0001j\u0003\b¯\u0001j\u0003\b°\u0001j\u0003\b±\u0001j\u0003\b²\u0001j\u0003\b³\u0001j\u0003\b´\u0001j\u0003\bµ\u0001j\u0003\b¶\u0001j\u0003\b·\u0001j\u0003\b¸\u0001j\u0003\b¹\u0001j\u0003\bº\u0001j\u0003\b»\u0001j\u0003\b¼\u0001j\u0003\b½\u0001j\u0003\b¾\u0001j\u0003\b¿\u0001j\u0003\bÀ\u0001j\u0003\bÁ\u0001j\u0003\bÂ\u0001j\u0003\bÃ\u0001j\u0003\bÄ\u0001j\u0003\bÅ\u0001j\u0003\bÆ\u0001j\u0003\bÇ\u0001j\u0003\bÈ\u0001j\u0003\bÉ\u0001j\u0003\bÊ\u0001j\u0003\bË\u0001j\u0003\bÌ\u0001j\u0003\bÍ\u0001j\u0003\bÎ\u0001j\u0003\bÏ\u0001j\u0003\bÐ\u0001j\u0003\bÑ\u0001j\u0003\bÒ\u0001j\u0003\bÓ\u0001j\u0003\bÔ\u0001j\u0003\bÕ\u0001j\u0003\bÖ\u0001j\u0003\b×\u0001j\u0003\bØ\u0001j\u0003\bÙ\u0001j\u0003\bÚ\u0001j\u0003\bÛ\u0001j\u0003\bÜ\u0001j\u0003\bÝ\u0001j\u0003\bÞ\u0001j\u0003\bß\u0001j\u0003\bà\u0001j\u0003\bá\u0001j\u0003\bâ\u0001j\u0003\bã\u0001j\u0003\bä\u0001j\u0003\bå\u0001j\u0003\bæ\u0001j\u0003\bç\u0001j\u0003\bè\u0001j\u0003\bé\u0001j\u0003\bê\u0001j\u0003\bë\u0001j\u0003\bì\u0001j\u0003\bí\u0001j\u0003\bî\u0001j\u0003\bï\u0001j\u0003\bð\u0001j\u0003\bñ\u0001j\u0003\bò\u0001j\u0003\bó\u0001j\u0003\bô\u0001j\u0003\bõ\u0001j\u0003\bö\u0001j\u0003\b÷\u0001j\u0003\bø\u0001j\u0003\bù\u0001j\u0003\bú\u0001j\u0003\bû\u0001j\u0003\bü\u0001j\u0003\bý\u0001j\u0003\bþ\u0001j\u0003\bÿ\u0001j\u0003\b\u0080\u0002j\u0003\b\u0081\u0002j\u0003\b\u0082\u0002j\u0003\b\u0083\u0002j\u0003\b\u0084\u0002j\u0003\b\u0085\u0002j\u0003\b\u0086\u0002j\u0003\b\u0087\u0002j\u0003\b\u0088\u0002j\u0003\b\u0089\u0002j\u0003\b\u008a\u0002j\u0003\b\u008b\u0002j\u0003\b\u008c\u0002j\u0003\b\u008d\u0002j\u0003\b\u008e\u0002j\u0003\b\u008f\u0002j\u0003\b\u0090\u0002j\u0003\b\u0091\u0002j\u0003\b\u0092\u0002j\u0003\b\u0093\u0002j\u0003\b\u0094\u0002j\u0003\b\u0095\u0002j\u0003\b\u0096\u0002j\u0003\b\u0097\u0002j\u0003\b\u0098\u0002j\u0003\b\u0099\u0002j\u0003\b\u009a\u0002j\u0003\b\u009b\u0002j\u0003\b\u009c\u0002j\u0003\b\u009d\u0002j\u0003\b\u009e\u0002j\u0003\b\u009f\u0002j\u0003\b \u0002j\u0003\b¡\u0002j\u0003\b¢\u0002j\u0003\b£\u0002j\u0003\b¤\u0002j\u0003\b¥\u0002j\u0003\b¦\u0002j\u0003\b§\u0002j\u0003\b¨\u0002j\u0003\b©\u0002j\u0003\bª\u0002j\u0003\b«\u0002j\u0003\b¬\u0002j\u0003\b\u00ad\u0002j\u0003\b®\u0002j\u0003\b¯\u0002j\u0003\b°\u0002j\u0003\b±\u0002j\u0003\b²\u0002j\u0003\b³\u0002j\u0003\b´\u0002j\u0003\bµ\u0002j\u0003\b¶\u0002j\u0003\b·\u0002j\u0003\b¸\u0002j\u0003\b¹\u0002j\u0003\bº\u0002j\u0003\b»\u0002j\u0003\b¼\u0002j\u0003\b½\u0002j\u0003\b¾\u0002j\u0003\b¿\u0002j\u0003\bÀ\u0002j\u0003\bÁ\u0002j\u0003\bÂ\u0002j\u0003\bÃ\u0002j\u0003\bÄ\u0002j\u0003\bÅ\u0002j\u0003\bÆ\u0002j\u0003\bÇ\u0002j\u0003\bÈ\u0002j\u0003\bÉ\u0002j\u0003\bÊ\u0002j\u0003\bË\u0002j\u0003\bÌ\u0002j\u0003\bÍ\u0002j\u0003\bÎ\u0002j\u0003\bÏ\u0002j\u0003\bÐ\u0002j\u0003\bÑ\u0002j\u0003\bÒ\u0002j\u0003\bÓ\u0002j\u0003\bÔ\u0002j\u0003\bÕ\u0002j\u0003\bÖ\u0002j\u0003\b×\u0002j\u0003\bØ\u0002j\u0003\bÙ\u0002j\u0003\bÚ\u0002j\u0003\bÛ\u0002j\u0003\bÜ\u0002j\u0003\bÝ\u0002j\u0003\bÞ\u0002j\u0003\bß\u0002j\u0003\bà\u0002j\u0003\bá\u0002j\u0003\bâ\u0002j\u0003\bã\u0002j\u0003\bä\u0002j\u0003\bå\u0002j\u0003\bæ\u0002j\u0003\bç\u0002j\u0003\bè\u0002j\u0003\bé\u0002j\u0003\bê\u0002j\u0003\bë\u0002j\u0003\bì\u0002j\u0003\bí\u0002j\u0003\bî\u0002j\u0003\bï\u0002j\u0003\bð\u0002j\u0003\bñ\u0002j\u0003\bò\u0002j\u0003\bó\u0002j\u0003\bô\u0002j\u0003\bõ\u0002j\u0003\bö\u0002j\u0003\b÷\u0002j\u0003\bø\u0002j\u0003\bù\u0002j\u0003\bú\u0002j\u0003\bû\u0002j\u0003\bü\u0002j\u0003\bý\u0002j\u0003\bþ\u0002j\u0003\bÿ\u0002j\u0003\b\u0080\u0003j\u0003\b\u0081\u0003j\u0003\b\u0082\u0003j\u0003\b\u0083\u0003j\u0003\b\u0084\u0003j\u0003\b\u0085\u0003j\u0003\b\u0086\u0003j\u0003\b\u0087\u0003j\u0003\b\u0088\u0003j\u0003\b\u0089\u0003j\u0003\b\u008a\u0003j\u0003\b\u008b\u0003j\u0003\b\u008c\u0003j\u0003\b\u008d\u0003j\u0003\b\u008e\u0003j\u0003\b\u008f\u0003j\u0003\b\u0090\u0003j\u0003\b\u0091\u0003j\u0003\b\u0092\u0003j\u0003\b\u0093\u0003j\u0003\b\u0094\u0003j\u0003\b\u0095\u0003j\u0003\b\u0096\u0003j\u0003\b\u0097\u0003j\u0003\b\u0098\u0003j\u0003\b\u0099\u0003j\u0003\b\u009a\u0003j\u0003\b\u009b\u0003j\u0003\b\u009c\u0003j\u0003\b\u009d\u0003j\u0003\b\u009e\u0003j\u0003\b\u009f\u0003j\u0003\b \u0003j\u0003\b¡\u0003j\u0003\b¢\u0003j\u0003\b£\u0003j\u0003\b¤\u0003j\u0003\b¥\u0003j\u0003\b¦\u0003j\u0003\b§\u0003j\u0003\b¨\u0003j\u0003\b©\u0003j\u0003\bª\u0003j\u0003\b«\u0003j\u0003\b¬\u0003j\u0003\b\u00ad\u0003j\u0003\b®\u0003j\u0003\b¯\u0003j\u0003\b°\u0003j\u0003\b±\u0003j\u0003\b²\u0003j\u0003\b³\u0003j\u0003\b´\u0003j\u0003\bµ\u0003j\u0003\b¶\u0003j\u0003\b·\u0003j\u0003\b¸\u0003j\u0003\b¹\u0003j\u0003\bº\u0003j\u0003\b»\u0003j\u0003\b¼\u0003j\u0003\b½\u0003j\u0003\b¾\u0003j\u0003\b¿\u0003j\u0003\bÀ\u0003j\u0003\bÁ\u0003j\u0003\bÂ\u0003j\u0003\bÃ\u0003j\u0003\bÄ\u0003j\u0003\bÅ\u0003j\u0003\bÆ\u0003j\u0003\bÇ\u0003j\u0003\bÈ\u0003j\u0003\bÉ\u0003j\u0003\bÊ\u0003j\u0003\bË\u0003j\u0003\bÌ\u0003j\u0003\bÍ\u0003j\u0003\bÎ\u0003j\u0003\bÏ\u0003j\u0003\bÐ\u0003j\u0003\bÑ\u0003j\u0003\bÒ\u0003j\u0003\bÓ\u0003j\u0003\bÔ\u0003j\u0003\bÕ\u0003j\u0003\bÖ\u0003j\u0003\b×\u0003j\u0003\bØ\u0003j\u0003\bÙ\u0003j\u0003\bÚ\u0003j\u0003\bÛ\u0003j\u0003\bÜ\u0003j\u0003\bÝ\u0003j\u0003\bÞ\u0003j\u0003\bß\u0003j\u0003\bà\u0003j\u0003\bá\u0003j\u0003\bâ\u0003j\u0003\bã\u0003j\u0003\bä\u0003j\u0003\bå\u0003j\u0003\bæ\u0003j\u0003\bç\u0003j\u0003\bè\u0003j\u0003\bé\u0003j\u0003\bê\u0003j\u0003\bë\u0003j\u0003\bì\u0003j\u0003\bí\u0003j\u0003\bî\u0003j\u0003\bï\u0003j\u0003\bð\u0003j\u0003\bñ\u0003j\u0003\bò\u0003j\u0003\bó\u0003j\u0003\bô\u0003j\u0003\bõ\u0003j\u0003\bö\u0003j\u0003\b÷\u0003j\u0003\bø\u0003j\u0003\bù\u0003j\u0003\bú\u0003j\u0003\bû\u0003j\u0003\bü\u0003j\u0003\bý\u0003j\u0003\bþ\u0003j\u0003\bÿ\u0003j\u0003\b\u0080\u0004j\u0003\b\u0081\u0004j\u0003\b\u0082\u0004j\u0003\b\u0083\u0004j\u0003\b\u0084\u0004j\u0003\b\u0085\u0004j\u0003\b\u0086\u0004j\u0003\b\u0087\u0004j\u0003\b\u0088\u0004j\u0003\b\u0089\u0004j\u0003\b\u008a\u0004j\u0003\b\u008b\u0004j\u0003\b\u008c\u0004j\u0003\b\u008d\u0004j\u0003\b\u008e\u0004j\u0003\b\u008f\u0004j\u0003\b\u0090\u0004j\u0003\b\u0091\u0004j\u0003\b\u0092\u0004j\u0003\b\u0093\u0004j\u0003\b\u0094\u0004j\u0003\b\u0095\u0004j\u0003\b\u0096\u0004j\u0003\b\u0097\u0004j\u0003\b\u0098\u0004j\u0003\b\u0099\u0004j\u0003\b\u009a\u0004j\u0003\b\u009b\u0004j\u0003\b\u009c\u0004j\u0003\b\u009d\u0004j\u0003\b\u009e\u0004j\u0003\b\u009f\u0004j\u0003\b \u0004j\u0003\b¡\u0004j\u0003\b¢\u0004j\u0003\b£\u0004j\u0003\b¤\u0004j\u0003\b¥\u0004j\u0003\b¦\u0004j\u0003\b§\u0004j\u0003\b¨\u0004j\u0003\b©\u0004j\u0003\bª\u0004j\u0003\b«\u0004j\u0003\b¬\u0004j\u0003\b\u00ad\u0004j\u0003\b®\u0004j\u0003\b¯\u0004j\u0003\b°\u0004j\u0003\b±\u0004¨\u0006²\u0004"}, d2 = {"Lcom/hive/ResultAPI$Code;", "", "value", "", "key", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getValue", "()I", "getKey", "()Ljava/lang/String;", ADXLogUtil.EVENT_LOAD_SUCCESS, "RealNameVerification", "RefundUser", "CommonHTTPConnectionException", "CommonHTTPConnectionOpenException", "CommonHTTPContentEncodingNotSupported", "CommonHTTPDecryptionFailed", "CommonHTTPResponseException", "CommonHTTPInvalidBody", "CommonHTTPInvalidJSON", "CommonHTTPInvalidURLRequest", "CommonHTTPInvalidURL", "CommonHTTPGzipDecodeFailed", "CommonHTTPNetworkError", "CommonLibraryMissing", "CommonNotSupported", "CommonInProgress", "TestError", "TestWithNSError", "TestWithNSString", "TestWithNSDictionary", "CommonUnknown", "AuthNotInitialized", "AuthInvalidServerResponse", "AuthServerResponseNotSuccessful", "AuthInvalidUser", "AuthUserCanceled", "AuthInProgressLoginLogout", "AuthInvalidSelectedAccountURL", "AuthInvalidSelectedVID", "AuthOnRunningV4", "AuthInvalidConfigurationXml", "AuthInvalidParamLoginType", "AuthInvalidParamVID", "AuthInvalidParamSessionKey", "AuthInvalidGuestSession", "AuthUserInBlacklist", "AuthInvalidAccountSession", "AuthJsonException", "AuthCanceled", "AuthDialogAlreadyUsing", "AuthNetworkErrorShowLoginSelection", "AuthNetworkErrorCheckMaintenance", "AuthResponseFailCheckMaintenance", "AuthResponseFailMaintenanceDialog", "AuthNetworkErrorProcessLoginType", "AuthNetworkErrorGuestLogin", "AuthHIVESocialLoginCancelled", "AuthNetworkErrorLoginCenterLogin", "AuthNetworkErrorRequestUpdate", "AuthNetworkErrorRequestAdultConfirm", "AuthInvalidParamVIDList", "AuthAgreementFail_DoExit", "AuthMaintenanceActionDefault_DoExit", "AuthMaintenanceActionOpenURL_DoExit", "AuthMaintenanceActionExit_DoExit", "AuthMaintenanceActionDone", "AuthMaintenanceTimeover_DoExit", "AuthUserInBlacklistActionDefault_DoExit", "AuthUserInBlacklistActionOpenURL_DoExit", "AuthUserInBlacklistActionExit_DoExit", "AuthUserInBlacklistActionDone", "AuthUserInBlacklistTimeover_DoExit", "AuthInProgressInitialize", "AuthSkipPermissionView", "AuthInProgressRequestPermissionViewData", "AuthNetworkErrorRequestPermissionViewData", "AuthProviderMissingKey", "AuthResponseFailLogoutOnlyPGSConnectedUser", "AuthNetworkErrorLoginCenterSignOut", "AuthV4InvalidServerResponse", "AuthV4OnRunningV1", "AuthV4InProgressSignIn", "AuthV4InvalidConfigurationXml", "AuthV4InvalidSavedPlayerInfo", "AuthV4AlreadyAuthorized", "AuthV4ConflictPlayer", "AuthV4UserInBlacklist", "AuthV4InvalidSession", "AuthV4ConflictPlayerHandlingFail", "AuthV4InvalidParamDid", "AuthV4NotInitialized", "AuthV4SessionExist", "AuthV4SessionNotExist", "AuthV4InvalidProviderType", "AuthV4SigninFirst", "AuthV4ProviderAlreadyConnected", "AuthV4ProviderAlreadyDisconnected", "AuthV4InvalidParamSelectedPlayerid", "AuthV4InvalidConflictInfo", "AuthV4InvalidPlayeridList", "AuthV4JsonException", "AuthV4InvalidSigninSelection", "AuthV4NotSupportedProviderType", "AuthV4WebviewDialogError", "AuthV4InProgressAuthDialog", "AuthV4InvalidParamViewID", "AuthV4InvalidParamPlayerID", "AuthV4NetworkErrorSigninGuest", "AuthV4ResponseFailProviderUserID", "AuthV4ResponseFailSelectedPlayerID", "AuthV4CancelDialog", "AuthV4ResponseFailSocialDialog", "AuthV4ProfileNetworkError", "AuthV4ProfileResponseFail", "AuthV4MembershipNetworkError", "AuthV4MembershipResponseFail", "AuthV4ResponseFailSigninProvider", "AuthV4ResponseFailCheckProvider", "AuthV4ResponseFailGetFriendList", "AuthV4ResponseFailSigninGuest", "AuthV4InProgressConnect", "AuthV4InProgressShowLeaderboard", "AuthV4InProgressShowAchievements", "AuthV4PlayerChange", "AuthV4HelperImplifiedLoginFail", "AuthV4PlayerResolved", "AuthV4AgreementFail_DoExit", "AuthV4AgreementFailWithWebviewError_DoExit", "AuthV4MaintenanceActionDefault_DoExit", "AuthV4MaintenanceActionOpenURL_DoExit", "AuthV4MaintenanceActionExit_DoExit", "AuthV4MaintenanceActionDone", "AuthV4MaintenanceTimeover_DoExit", "AuthV4NetworkError", "AuthV4InvalidResponseData", "AuthV4ServerResponseError", "AuthV4NeedSignIn", "AuthV4InProgress", "AuthV4InvalidParam", "AuthV4SkipPermissionView", "AuthV4InvalidCertification", "AuthV4LastProviderCantDisconnect", "AuthV4ServiceShutdown", "AuthV4SignOutNotAllowGuestLogout", "AuthV4SessionProcessingFail", "AgeLimit", "AuthV4ProviderLoginError", "AuthV4ProviderLogoutError", "AuthV4ProviderNotSupportGetFriends", "AuthV4ProviderLoginCancel", "AuthV4ProviderMissingKey", "AuthV4ProviderNotSupportedMyInquiry", "AuthV4FacebookUserCanceled", "AuthV4FacebookResponseFailGetFriends", "AuthV4FacebookNetworkErrorUploadProfile", "AuthV4FacebookResponseFailUploadProfile", "AuthV4FacebookResponseError", "AuthV4FacebookInvalidResponseData", "AuthV4FacebookNetworkError", "AuthV4FacebookCancel", "AuthV4GoogleResponseFailLogin", "AuthV4GoogleResponseFailLogout", "AuthV4GoogleNetworkErrorUploadProfile", "AuthV4GoogleResponseFailUploadProfile", "AuthV4GoogleResponseFailShowAchievements", "AuthV4GoogleResponseFailShowLeaderboards", "AuthV4GoogleNotSupported", "AuthV4GoogleLoginCancel", "AuthV4GoogleNetworkError", "AuthV4GoogleLogout", "AuthV4GoogleResponseFailAchievementsReveal", "AuthV4GoogleResponseFailAchievementsUnlock", "AuthV4GoogleResponseFailAchievementsIncrement", "AuthV4GoogleResponseFailLeaderboardsSubmitScore", "AuthV4GoogleNeedSignIn", "AuthV4GoogleNeedSettingOption", "AuthV4GoogleResponseFailPGSGetServerAccessToken", "AuthV4GoogleResponseFailPGSGetPlayerId", "AuthV4GoogleObjectNotReady", "AuthV4AppleLoginCancel", "AuthV4AppleResponseFailLogin", "AuthV4AppleTimeOut", "AuthV4AppleResponseFailReportScore", "AuthV4AppleInProgressGameCenterVC", "AuthV4AppleResponseFailLoadAchievements", "AuthV4AppleResponseFailReportAchievements", "AuthV4AppleResponseFailResetAchievements", "AuthV4AppleNotSupported", "AuthV4AppleInProgress", "AuthV4AppleResponseError", "AuthV4AppleCancel", "AuthV4VKResponseFailLogin", "AuthV4VKInvalidParamSDK", "AuthV4VKNotInitialized", "AuthV4VKCancelLogin", "AuthV4VKInvalidSession", "AuthV4VKResponseFailGetFriends", "AuthV4VKResponseFailLogout", "AuthV4VKResponseFailUploadProfile", "AuthV4VKNetworkErrorUploadProfile", "AuthV4VKInProgress", "AuthV4VKResponseError", "AuthV4VKNetworkError", "AuthV4VKInvalidParam", "AuthV4VKCancel", "AuthV4VKTokenResponseError", "AuthV4WechatInProgressLoginLogout", "AuthV4WechatResponseFailLogin", "AuthV4WechatNotSupportedRequest", "AuthV4WechatResponseFailUserInfo", "AuthV4WechatNetworkErrorUserInfo", "AuthV4WechatNetworkError", "AuthV4WechatResponseFail", "AuthV4WechatNetworkErrorLogin", "AuthV4WechatLoginCancel", "AuthV4WechatInProgress", "AuthV4WechatResponseError", "AuthV4WechatInvalidResponseData", "AuthV4WechatInvalidAppKey", "AuthV4HIVEDialogCancel", "AuthV4HIVENetworkErrorUploadProfile", "AuthV4HIVEResponseFailUploadProfile", "AuthV4HIVEInProgress", "AuthV4HIVEResponseError", "AuthV4HIVENetworkError", "AuthV4HIVEInvalidParam", "AuthV4HIVECancel", "AuthV4QQInProgressLoginLogout", "AuthV4QQResponseFailLogin", "AuthV4QQCancelLogin", "AuthV4QQNetworkError", "AuthV4QQNetworkErrorUploadProfile", "AuthV4QQResponseFailUploadProfile", "AuthV4QQCancelUploadProfile", "AuthV4QQResponseFailLogout", "AuthV4QQNotInitialized", "AuthV4QQInProgress", "AuthV4QQResponseError", "AuthV4QQInvalidResponseData", "AuthV4QQInvalidParam", "AuthV4QQCancel", "AuthV4LineInvalidParam", "AuthV4LineCancel", "AuthV4LineResponseError", "AuthV4LineNetworkError", "AuthV4TwitterResponseError", "AuthV4TwitterInvalidParam", "AuthV4WeverseInProgressLoginLogout", "AuthV4WeverseResponseFailLogin", "AuthV4WeverseNotSupported", "AuthV4WeverseNetworkError", "AuthV4WeverseLoginCancel", "AuthV4WeverseResponseError", "AuthV4NotRegisteredDevice", "AuthV4HuaweiNotInitialized", "AuthV4HuaweiInProgress", "AuthV4HuaweiInvalidParam", "AuthV4HuaweiLoginCancel", "AuthV4HuaweiNetworkError", "AuthV4HuaweiResponseError", "SocialResponseFailDismissDialog", "SocialCancelDismissDialog", "SocialCancelConnect", "SocialResponseFailConnect", "SocialCancelGetPictureFromGallery", "SocialResponseFailGetPictureFromGallery", "SocialCancelSharePhoto", "SocialResponseFailSharePhoto", "SocialInvalidParam", "SocialProviderNotInitialized", "SocialNeedSignIn", "SocialGoogleNotInitialized", "SocialGoogleResponseFailGetProfile", "SocialGoogleInProgressConnect", "SocialGoogleResponseFailConnect", "SocialGoogleCancelGetProfile", "SocialGoogleCancelConnect", "SocialGoogleNetworkErrorUpdateServerFlag", "SocialGoogleResponseFailUpdateServerFlag", "SocialGoogleCancelGetFriends", "SocialFacebookNotInitialized", "SocialFacebookResponseFailGetProfile", "SocialFacebookCancelGetProfile", "SocialFacebookResponseFailGetFriends", "SocialFacebookCancelGetFriends", "SocialFacebookResponseFailSendMessage", "SocialFacebookCancelSendMessage", "SocialFacebookMessageDialogShowFail", "SocialFacebookResponseFailShowInvitation", "SocialFacebookCancelShowInvitation", "SocialFacebookInvalidParamPost", "SocialFacebookPostDialogShowFail", "SocialFacebookShareFail", "SocialFacebookShareCancelled", "SocialFacebookSendInvitationFail", "SocialFacebookSendInvitationCancelled", "SocialFacebookCancelPost", "SocialFacebookResponseFailPost", "SocialFacebookOperationException", "SocialFacebookServiceException", "SocialFacebookException", "SocialHIVENotInitialized", "SocialHIVENetworkErrorGetMyProfile", "SocialHIVEInvalidParamSetMyProfile", "SocialHIVENetworkErrorSetMyProfile", "SocialHIVENetworkErrorGetFriends", "SocialHIVEInvalidSession", "SocialHIVEInvalidParamVID", "SocialHIVENetworkErrorGetVIDByUIDList", "SocialHIVENetworkErrorGetUIDByVIDList", "SocialHIVEInvalidParamContentSendMessage", "SocialHIVENetworkErrorSendMessage", "SocialHIVEInvalidParamReceiptSendMessage", "SocialHIVEInvalidParamUID", "SocialHIVEInProgressSocialDialog", "SocialHIVESocialDialogClosed", "SocialHIVENetworkErrorGetBadgeInfo", "SocialHIVEResponseFailGetMyProfile", "SocialHIVEResponseFailSetMyProfile", "SocialHIVEResponseFailGetFriends", "SocialHIVEResponseFailGetVID", "SocialHIVEResponseFailInvalidVIDList", "SocialHIVEResponseFailGetUID", "SocialHIVEResponseFailInvalidUIDList", "SocialHIVEResponseFailSendMessage", "SocialHIVEResponseFailGetBadgeInfo", "SocialHIVEResponseFailDialogWebView", "SocialHIVEResponseFailSocialDialog", "SocialHIVEInvalidParamFriendType", "SocialHIVEResponseFailGetProfiles", "SocialHIVEInvalidParamGetProfiles", "SocialHIVEResponseFail", "SocialHIVEInvalidParamSendMessage", "SocialHIVEInvalidParamSendInvitationMessage", "SocialHIVEResponseFailGetPictureFromGallery", "SocialHIVEResponseFailGetPictureFromCamera", "SocialHIVENetworkErrorSendInvitationMessage", "SocialHIVENetworkErrorDeviceRegistered", "SocialHIVENetworkErrorGuestKey", "SocialHIVENetworkErrorGuestGenerate", "SocialHIVENetworkErrorGuestCreate", "SocialHIVENetworkErrorGuestLogin", "SocialHIVENetworkErrorGuestAuth", "SocialHIVENetworkErrorSaveDataUpload", "SocialHIVENetworkErrorSaveDataDownload", "SocialHIVENetworkErrorSaveDataDelete", "SocialHIVENetworkErrorUploadImage", "SocialHIVENetworkErrorWallWrite", "SocialHIVENetworkErrorFriendsRejectRequest", "SocialHIVENetworkErrorFriendsRequest", "SocialHIVENetworkErrorFriendsReceiveList", "SocialHIVENetworkErrorGuestStatusSaveData", "SocialHIVENetworkErrorUserMeNotification", "SocialHIVESocialRequestError", "SocialHIVENetworkErrorMessageNotiCount", "SocialHIVEResponseFailGetPictureFromChooser", "PromotionNotInitialized", "PromotionAlreadyShowing", "PromotionNetworkErrorShowCustomContents", "PromotionNetworkErrorShowOfferwall", "PromotionShowDialogFail", "PromotionResponseFailGetViewInfo", "PromotionNetworkError", "PromotionServerResponseError", "PromotionInvalidResponseData", "PromotionShareFailed", "UserEngagementResponseFail", "UserEngagementAlreadySetReady", "UserEngagementHandlerNotRegistered", "UserEngagementNotLogined", "UserEngagementEmptyCouponId", "UserEngagementEmptyMarketPid", "UserEngagementListenerNotRegistered", "PromotionStartPlayback", "PromotionFinishPlayback", "PromotionYTPlayerError", "PromotionCancelPlayback", "PushNotInitialized", "PushInvalidParamLocalPush", "PushInvalidParamRemotePush", "PushNetworkError", "PushAgeGateUnder13", "PushInvalidResponseData", "PushServerResponseError", "PushNeedSignIn", "IAPNotInitialize", "IAPAlreadyInInitialize", "IAPNetworkError", "IAPNotSupportedMarket", "IAPNeedLogin", "IAPNeedShopInitialize", "IAPNotSupportedOSVersion", "IAPNeedRestore", "IAPNothingToRestore", "IAPFailRestore", "IAPRestrictPayments", "IAPNetworkJsonException", "IAPMarketNotSupportedAPI", "IAPFailMarketInitialize", "IAPResponseError", "IAPDialogActionDefault_DoExit", "IAPDialogActionOpenURL_DoExit", "IAPDialogActionExit_DoExit", "IAPDialogActionDone", "IAPDialogTimeover_DoExit", "IAPInProgressPurchasing", "IAPInProgressRestoring", "IAPInProgressCheckPromotePurchase", "IAPInProgressConnectingAppStore", "IAPInProgressMarketSelection", "IAPAppStoreError", "IAPAppStoreResponseEmpty", "IAPCannotFindGamePID", "IAPProductNotExist", "IAPEmptyMarketPID", "IAPFailCreateSKPayment", "IAPEmptyTransaction", "IAPEmptyProduct", "IAPCancelPayment", "IAPFailPayment", "IAPInvalidMarketPID", "IAPPurchaseParamJsonException", "IAPShopInfoParamJsonException", "IAPBadgeParamJsonException", "IAPInvalidParamEmptyMarketPID", "IAPInvalidParamLocationCode", "IAPBlockedUser", "IAPPromoCodeMatchMultiMarketPID", "IAPPromoCodeNotMatchMarketPID", "IAPPromoCodeAlreadyUsed", "IAPAppleReceiptNotConnected", "IAPServerDefaultError", "IAPInitializeMarketListIsEmpty", "IAPInitializeMarketURLISEmpty", "IAPEmptyMarketURL", "IAPNotSelectedMarket", "IAPPlayStoreLaunchPurchaseFlowException", "IAPPlayStoreSetupFail", "IAPPlayStoreQueryInventoryFail", "IAPPlayStorePending", "IAPOneStoreProductListEmpty", "IAPOneStoreProductNetworkError", "IAPOneStoreProductInfoError", "IAPOneStoreInvalidRequestID", "IAPOneStorePurchaseError", "IAPOneStoreNetworkNullError", "IAPOneStoreNetworkInvalidError", "IAPLebiInitializeNetworkError", "IAPLebiInitializeJsonException", "IAPLebiPurchaseNetworkError", "IAPLebiPurchaseJsonException", "IAPLebiVerifyOrderNetworkError", "IAPLebiVerifyOrderJsonException", "IAPLebiBalanceNetworkError", "IAPLebiBalanceParamJsonException", "IAPLebiPostException", "IAPLebiInternalRequestException", "IAPLebiRestoreNetworkError", "IAPV4NotInitialize", "IAPV4NetworkError", "IAPV4NotSupportedMarket", "IAPV4NeedSignIn", "IAPV4NeedMarketConnect", "IAPV4NeedRestore", "IAPV4NothingToRestore", "IAPV4FailToRestore", "IAPV4RestrictPayments", "IAPV4FailMarketConnect", "IAPV4ResponseError", "IAPV4MarketNotSupportedAPI", "IAPV4PendingPurchase", "IAPV4InProgressMarketConnect", "IAPV4InProgressPurchasing", "IAPV4InProgressRestoring", "IAPV4InProgressCheckPromote", "IAPV4InProgressConnectAppStore", "IAPV4InProgressMarketSelect", "IAPV4AppStoreError", "IAPV4AppStoreResponseEmpty", "IAPV4ProductNotExsitInAppStore", "IAPV4FinishMarketPidEmpty", "IAPV4PromoteMarketPidEmpty", "IAPV4FailCreateSKPayment", "IAPV4FailToConvertNSSet", "IAPV4InvalidLogType", "IAPV4ProductNotExist", "IAPV4RequestProductJsonException", "IAPV4PurchaseParamJsonException", "IAPV4RequestMarketJsonException", "IAPV4ProductInfoJsonException", "IAPV4CancelPayment", "IAPV4FailPayment", "IAPV4EmptyParamMarketPID", "IAPV4EmptyMarketList", "IAPV4EmptyMarketURL", "IAPV4MarketPidListEmptyInIAPServer", "IAPV4EmptyProductList", "IAPV4ProductNotExistInIAPServer", "IAPV4PlayStoreLaunchPurchaseFlowException", "IAPV4PlayStoreSetupFail", "IAPV4PlayStoreQueryInventoryFail", "IAPV4PlayStoreFinishFail", "IAPV4PlayStorePending", "IAPV4OneStoreV5RemoteException", "IAPV4OneStoreV5SecurityException", "IAPV4OneStoreV5NeedUpdateException", "IAPV4OneStoreCancelPayment", "IAPV4OneStoreNetworkError", "IAPV4OneStoreResponseError", "IAPV4OneStoreProductNotExist", "IAPV4OneStoreFailPayment", "IAPV4OneStoreError", "IAPV4OneStoreNeedRestore", "IAPV4OneStoreNothingToRestore", "IAPV4OneStoreUnablePayment", "IAPV4OneStoreNeedSignIn", "IAPV4OneStoreException", "IAPV4OneStoreInvalidResponseData", "IAPV4OneStoreInvalidParam", "IAPV4OneStoreFinishFail", "IAPV4OneStoreRefund", "IAPV4LebiInitializeNetworkError", "IAPV4LebiInitializeJsonException", "IAPV4LebiPurchaseNetworkError", "IAPV4LebiPurchaseJsonException", "IAPV4LebiVerifyOrderNetworkError", "IAPV4LebiVerifyOrderJsonException", "IAPV4LebiBalanceNetworkError", "IAPV4LebiBalanceParamJsonException", "IAPV4LebiPostException", "IAPV4LebiInternalRequestException", "IAPV4LebiRestoreNetworkError", "IAPV4LebiCancel", "IAPV4LebiFinishFail", "IAPV4CancelMarketSelect", "IAPV4ServerResponseError", "IAPV4HiveStoreSuccess", "PlatformHelperOSNotSupported", "PlatformHelperOSVersionNotSupported", "PlatformHelperEmptyPermissions", "PlatformHelperNotSupported", "PlatformHelperInvalidParam", "DataStoreNotExistKey", "DataStoreNotExistColumn", "DataStoreNotExistPublicKey", "DataStoreNotInitialized", "DataStoreNeedSignIn", "DataStoreDisabled", "DataStoreResponseError", "DataStoreInvalidParam", "DataStoreGameIsBeingInspected", "AnalyticsConsentModeCanceled", "MatchMakingNotInitialized", "MatchMakingNeedSignIn", "MatchMakingResponseError", "ChatNotConnected", "ChatNeedSignIn", "ChatInvalidParam", "ChatResponseError", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Code {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Code[] $VALUES;
        private final String key;
        private final int value;
        public static final Code Success = new Code(ADXLogUtil.EVENT_LOAD_SUCCESS, 0, 0, ADXLogUtil.EVENT_LOAD_SUCCESS);
        public static final Code RealNameVerification = new Code("RealNameVerification", 1, 2100, "Real Name Verification");
        public static final Code RefundUser = new Code("RefundUser", 2, 2300, "Refund User");
        public static final Code CommonHTTPConnectionException = new Code("CommonHTTPConnectionException", 3, -1, "CommonHTTPConnectionException");
        public static final Code CommonHTTPConnectionOpenException = new Code("CommonHTTPConnectionOpenException", 4, -2, "CommonHTTPConnectionOpenException");
        public static final Code CommonHTTPContentEncodingNotSupported = new Code("CommonHTTPContentEncodingNotSupported", 5, -3, "CommonHTTPContentEncodingNotSupported");
        public static final Code CommonHTTPDecryptionFailed = new Code("CommonHTTPDecryptionFailed", 6, -4, "CommonHTTPDecryptionFailed");
        public static final Code CommonHTTPResponseException = new Code("CommonHTTPResponseException", 7, -5, "CommonHTTPResponseException");
        public static final Code CommonHTTPInvalidBody = new Code("CommonHTTPInvalidBody", 8, -6, "CommonHTTPInvalidBody");
        public static final Code CommonHTTPInvalidJSON = new Code("CommonHTTPInvalidJSON", 9, -7, "CommonHTTPInvalidJSON");
        public static final Code CommonHTTPInvalidURLRequest = new Code("CommonHTTPInvalidURLRequest", 10, -8, "CommonHTTPInvalidURLRequest");
        public static final Code CommonHTTPInvalidURL = new Code("CommonHTTPInvalidURL", 11, -9, "CommonHTTPInvalidURL");
        public static final Code CommonHTTPGzipDecodeFailed = new Code("CommonHTTPGzipDecodeFailed", 12, -10, "CommonHTTPGzipDecodeFailed");
        public static final Code CommonHTTPNetworkError = new Code("CommonHTTPNetworkError", 13, -11, "CommonHTTPNetworkError");
        public static final Code CommonLibraryMissing = new Code("CommonLibraryMissing", 14, -12, "CommonLibraryMissing");
        public static final Code CommonNotSupported = new Code("CommonNotSupported", 15, -13, "CommonNotSupported");
        public static final Code CommonInProgress = new Code("CommonInProgress", 16, -14, "CommonInProgress");
        public static final Code TestError = new Code("TestError", 17, AppLovinErrorCodes.INVALID_RESPONSE, "TestError");
        public static final Code TestWithNSError = new Code("TestWithNSError", 18, -801, "TestWithNSError");
        public static final Code TestWithNSString = new Code("TestWithNSString", 19, -802, "TestWithNSString");
        public static final Code TestWithNSDictionary = new Code("TestWithNSDictionary", 20, -803, "TestWithNSDictionary");
        public static final Code CommonUnknown = new Code("CommonUnknown", 21, -999, "CommonUnknown");
        public static final Code AuthNotInitialized = new Code("AuthNotInitialized", 22, -1100001, "AuthNotInitialized");
        public static final Code AuthInvalidServerResponse = new Code("AuthInvalidServerResponse", 23, -1100002, "AuthInvalidServerResponse");
        public static final Code AuthServerResponseNotSuccessful = new Code("AuthServerResponseNotSuccessful", 24, -1100003, "AuthServerResponseNotSuccessful");
        public static final Code AuthInvalidUser = new Code("AuthInvalidUser", 25, -1100004, "AuthInvalidUser");
        public static final Code AuthUserCanceled = new Code("AuthUserCanceled", 26, -1100005, "AuthUserCanceled");
        public static final Code AuthInProgressLoginLogout = new Code("AuthInProgressLoginLogout", 27, -1100006, "AuthInProgressLoginLogout");
        public static final Code AuthInvalidSelectedAccountURL = new Code("AuthInvalidSelectedAccountURL", 28, -1100007, "AuthInvalidSelectedAccountURL");
        public static final Code AuthInvalidSelectedVID = new Code("AuthInvalidSelectedVID", 29, -1100008, "AuthInvalidSelectedVID");
        public static final Code AuthOnRunningV4 = new Code("AuthOnRunningV4", 30, -1100009, "AuthOnRunningV4");
        public static final Code AuthInvalidConfigurationXml = new Code("AuthInvalidConfigurationXml", 31, -1100010, "AuthInvalidConfigurationXml");
        public static final Code AuthInvalidParamLoginType = new Code("AuthInvalidParamLoginType", 32, -1100011, "AuthInvalidParamLoginType");
        public static final Code AuthInvalidParamVID = new Code("AuthInvalidParamVID", 33, -1100012, "AuthInvalidParamVID");
        public static final Code AuthInvalidParamSessionKey = new Code("AuthInvalidParamSessionKey", 34, -1100013, "AuthInvalidParamSessionKey");
        public static final Code AuthInvalidGuestSession = new Code("AuthInvalidGuestSession", 35, -1100014, "AuthInvalidGuestSession");
        public static final Code AuthUserInBlacklist = new Code("AuthUserInBlacklist", 36, -1100015, "AuthUserInBlacklist");
        public static final Code AuthInvalidAccountSession = new Code("AuthInvalidAccountSession", 37, -1100016, "AuthInvalidAccountSession");
        public static final Code AuthJsonException = new Code("AuthJsonException", 38, -1100017, "AuthJsonException");
        public static final Code AuthCanceled = new Code("AuthCanceled", 39, -1100018, "AuthCanceled");
        public static final Code AuthDialogAlreadyUsing = new Code("AuthDialogAlreadyUsing", 40, -1100019, "AuthDialogAlreadyUsing");
        public static final Code AuthNetworkErrorShowLoginSelection = new Code("AuthNetworkErrorShowLoginSelection", 41, -1100020, "AuthNetworkErrorShowLoginSelection");
        public static final Code AuthNetworkErrorCheckMaintenance = new Code("AuthNetworkErrorCheckMaintenance", 42, -1100021, "AuthNetworkErrorCheckMaintenance");
        public static final Code AuthResponseFailCheckMaintenance = new Code("AuthResponseFailCheckMaintenance", 43, -1100022, "AuthResponseFailCheckMaintenance");
        public static final Code AuthResponseFailMaintenanceDialog = new Code("AuthResponseFailMaintenanceDialog", 44, -1100023, "AuthResponseFailMaintenanceDialog");
        public static final Code AuthNetworkErrorProcessLoginType = new Code("AuthNetworkErrorProcessLoginType", 45, -1100024, "AuthNetworkErrorProcessLoginType");
        public static final Code AuthNetworkErrorGuestLogin = new Code("AuthNetworkErrorGuestLogin", 46, -1100025, "AuthNetworkErrorGuestLogin");
        public static final Code AuthHIVESocialLoginCancelled = new Code("AuthHIVESocialLoginCancelled", 47, -1100026, "AuthHIVESocialLoginCancelled");
        public static final Code AuthNetworkErrorLoginCenterLogin = new Code("AuthNetworkErrorLoginCenterLogin", 48, -1100027, "AuthNetworkErrorLoginCenterLogin");
        public static final Code AuthNetworkErrorRequestUpdate = new Code("AuthNetworkErrorRequestUpdate", 49, -1100028, "AuthNetworkErrorRequestUpdate");
        public static final Code AuthNetworkErrorRequestAdultConfirm = new Code("AuthNetworkErrorRequestAdultConfirm", 50, -1100029, "AuthNetworkErrorRequestAdultConfirm");
        public static final Code AuthInvalidParamVIDList = new Code("AuthInvalidParamVIDList", 51, -1100030, "AuthInvalidParamVIDList");
        public static final Code AuthAgreementFail_DoExit = new Code("AuthAgreementFail_DoExit", 52, -1100031, "AuthAgreementFail_DoExit");
        public static final Code AuthMaintenanceActionDefault_DoExit = new Code("AuthMaintenanceActionDefault_DoExit", 53, -1100032, "AuthMaintenanceActionDefault_DoExit");
        public static final Code AuthMaintenanceActionOpenURL_DoExit = new Code("AuthMaintenanceActionOpenURL_DoExit", 54, -1100033, "AuthMaintenanceActionOpenURL_DoExit");
        public static final Code AuthMaintenanceActionExit_DoExit = new Code("AuthMaintenanceActionExit_DoExit", 55, -1100034, "AuthMaintenanceActionExit_DoExit");
        public static final Code AuthMaintenanceActionDone = new Code("AuthMaintenanceActionDone", 56, -1100035, "AuthMaintenanceActionDone");
        public static final Code AuthMaintenanceTimeover_DoExit = new Code("AuthMaintenanceTimeover_DoExit", 57, -1100036, "AuthMaintenanceTimeover_DoExit");
        public static final Code AuthUserInBlacklistActionDefault_DoExit = new Code("AuthUserInBlacklistActionDefault_DoExit", 58, -1100037, "AuthUserInBlacklistActionDefault_DoExit");
        public static final Code AuthUserInBlacklistActionOpenURL_DoExit = new Code("AuthUserInBlacklistActionOpenURL_DoExit", 59, -1100038, "AuthUserInBlacklistActionOpenURL_DoExit");
        public static final Code AuthUserInBlacklistActionExit_DoExit = new Code("AuthUserInBlacklistActionExit_DoExit", 60, -1100039, "AuthUserInBlacklistActionExit_DoExit");
        public static final Code AuthUserInBlacklistActionDone = new Code("AuthUserInBlacklistActionDone", 61, -1100040, "AuthUserInBlacklistActionDone");
        public static final Code AuthUserInBlacklistTimeover_DoExit = new Code("AuthUserInBlacklistTimeover_DoExit", 62, -1100041, "AuthUserInBlacklistTimeover_DoExit");
        public static final Code AuthInProgressInitialize = new Code("AuthInProgressInitialize", 63, -1100042, "AuthInProgressInitialize");
        public static final Code AuthSkipPermissionView = new Code("AuthSkipPermissionView", 64, -1100043, "AuthSkipPermissionView");
        public static final Code AuthInProgressRequestPermissionViewData = new Code("AuthInProgressRequestPermissionViewData", 65, -1100044, "AuthInProgressRequestPermissionViewData");
        public static final Code AuthNetworkErrorRequestPermissionViewData = new Code("AuthNetworkErrorRequestPermissionViewData", 66, -1100045, "AuthNetworkErrorRequestPermissionViewData");
        public static final Code AuthProviderMissingKey = new Code("AuthProviderMissingKey", 67, -1100046, "AuthProviderMissingKey");
        public static final Code AuthResponseFailLogoutOnlyPGSConnectedUser = new Code("AuthResponseFailLogoutOnlyPGSConnectedUser", 68, -1100047, "AuthResponseFailLogoutOnlyPGSConnectedUser");
        public static final Code AuthNetworkErrorLoginCenterSignOut = new Code("AuthNetworkErrorLoginCenterSignOut", 69, -1100048, "AuthNetworkErrorLoginCenterSignOut");
        public static final Code AuthV4InvalidServerResponse = new Code("AuthV4InvalidServerResponse", 70, -1200001, "AuthV4InvalidServerResponse");
        public static final Code AuthV4OnRunningV1 = new Code("AuthV4OnRunningV1", 71, -1200002, "AuthV4OnRunningV1");
        public static final Code AuthV4InProgressSignIn = new Code("AuthV4InProgressSignIn", 72, -1200003, "AuthV4InProgressSignIn");
        public static final Code AuthV4InvalidConfigurationXml = new Code("AuthV4InvalidConfigurationXml", 73, -1200004, "AuthV4InvalidConfigurationXml");
        public static final Code AuthV4InvalidSavedPlayerInfo = new Code("AuthV4InvalidSavedPlayerInfo", 74, -1200005, "AuthV4InvalidSavedPlayerInfo");
        public static final Code AuthV4AlreadyAuthorized = new Code("AuthV4AlreadyAuthorized", 75, -1200006, "AuthV4AlreadyAuthorized");
        public static final Code AuthV4ConflictPlayer = new Code("AuthV4ConflictPlayer", 76, -1200007, "AuthV4ConflictPlayer");
        public static final Code AuthV4UserInBlacklist = new Code("AuthV4UserInBlacklist", 77, -1200008, "AuthV4UserInBlacklist");
        public static final Code AuthV4InvalidSession = new Code("AuthV4InvalidSession", 78, -1200009, "AuthV4InvalidSession");
        public static final Code AuthV4ConflictPlayerHandlingFail = new Code("AuthV4ConflictPlayerHandlingFail", 79, -1200010, "AuthV4ConflictPlayerHandlingFail");
        public static final Code AuthV4InvalidParamDid = new Code("AuthV4InvalidParamDid", 80, -1200011, "AuthV4InvalidParamDid");
        public static final Code AuthV4NotInitialized = new Code("AuthV4NotInitialized", 81, -1200012, "AuthV4NotInitialized");
        public static final Code AuthV4SessionExist = new Code("AuthV4SessionExist", 82, -1200013, "AuthV4SessionExist");
        public static final Code AuthV4SessionNotExist = new Code("AuthV4SessionNotExist", 83, -1200014, "AuthV4SessionNotExist");
        public static final Code AuthV4InvalidProviderType = new Code("AuthV4InvalidProviderType", 84, -1200015, "AuthV4InvalidProviderType");
        public static final Code AuthV4SigninFirst = new Code("AuthV4SigninFirst", 85, -1200016, "AuthV4SigninFirst");
        public static final Code AuthV4ProviderAlreadyConnected = new Code("AuthV4ProviderAlreadyConnected", 86, -1200017, "AuthV4ProviderAlreadyConnected");
        public static final Code AuthV4ProviderAlreadyDisconnected = new Code("AuthV4ProviderAlreadyDisconnected", 87, -1200018, "AuthV4ProviderAlreadyDisconnected");
        public static final Code AuthV4InvalidParamSelectedPlayerid = new Code("AuthV4InvalidParamSelectedPlayerid", 88, -1200019, "AuthV4InvalidParamSelectedPlayerid");
        public static final Code AuthV4InvalidConflictInfo = new Code("AuthV4InvalidConflictInfo", 89, -1200020, "AuthV4InvalidConflictInfo");
        public static final Code AuthV4InvalidPlayeridList = new Code("AuthV4InvalidPlayeridList", 90, -1200021, "AuthV4InvalidPlayeridList");
        public static final Code AuthV4JsonException = new Code("AuthV4JsonException", 91, -1200022, "AuthV4JsonException");
        public static final Code AuthV4InvalidSigninSelection = new Code("AuthV4InvalidSigninSelection", 92, -1200023, "AuthV4InvalidSigninSelection");
        public static final Code AuthV4NotSupportedProviderType = new Code("AuthV4NotSupportedProviderType", 93, -1200024, "AuthV4NotSupportedProviderType");
        public static final Code AuthV4WebviewDialogError = new Code("AuthV4WebviewDialogError", 94, -1200025, "AuthV4WebviewDialogError");
        public static final Code AuthV4InProgressAuthDialog = new Code("AuthV4InProgressAuthDialog", 95, -1200026, "AuthV4InProgressAuthDialog");
        public static final Code AuthV4InvalidParamViewID = new Code("AuthV4InvalidParamViewID", 96, -1200027, "AuthV4InvalidParamViewID");
        public static final Code AuthV4InvalidParamPlayerID = new Code("AuthV4InvalidParamPlayerID", 97, -1200028, "AuthV4InvalidParamPlayerID");
        public static final Code AuthV4NetworkErrorSigninGuest = new Code("AuthV4NetworkErrorSigninGuest", 98, -1200029, "AuthV4NetworkErrorSigninGuest");
        public static final Code AuthV4ResponseFailProviderUserID = new Code("AuthV4ResponseFailProviderUserID", 99, -1200030, "AuthV4ResponseFailProviderUserID");
        public static final Code AuthV4ResponseFailSelectedPlayerID = new Code("AuthV4ResponseFailSelectedPlayerID", 100, -1200031, "AuthV4ResponseFailSelectedPlayerID");
        public static final Code AuthV4CancelDialog = new Code("AuthV4CancelDialog", 101, -1200032, "AuthV4CancelDialog");
        public static final Code AuthV4ResponseFailSocialDialog = new Code("AuthV4ResponseFailSocialDialog", 102, -1200033, "AuthV4ResponseFailSocialDialog");
        public static final Code AuthV4ProfileNetworkError = new Code("AuthV4ProfileNetworkError", 103, -1200034, "AuthV4ProfileNetworkError");
        public static final Code AuthV4ProfileResponseFail = new Code("AuthV4ProfileResponseFail", 104, -1200035, "AuthV4ProfileResponseFail");
        public static final Code AuthV4MembershipNetworkError = new Code("AuthV4MembershipNetworkError", 105, -1200036, "AuthV4MembershipNetworkError");
        public static final Code AuthV4MembershipResponseFail = new Code("AuthV4MembershipResponseFail", 106, -1200037, "AuthV4MembershipResponseFail");
        public static final Code AuthV4ResponseFailSigninProvider = new Code("AuthV4ResponseFailSigninProvider", 107, -1200038, "AuthV4ResponseFailSigninProvider");
        public static final Code AuthV4ResponseFailCheckProvider = new Code("AuthV4ResponseFailCheckProvider", 108, -1200039, "AuthV4ResponseFailCheckProvider");
        public static final Code AuthV4ResponseFailGetFriendList = new Code("AuthV4ResponseFailGetFriendList", 109, -1200040, "AuthV4ResponseFailGetFriendList");
        public static final Code AuthV4ResponseFailSigninGuest = new Code("AuthV4ResponseFailSigninGuest", 110, -1200041, "AuthV4ResponseFailSigninGuest");
        public static final Code AuthV4InProgressConnect = new Code("AuthV4InProgressConnect", 111, -1200042, "AuthV4InProgressConnect");
        public static final Code AuthV4InProgressShowLeaderboard = new Code("AuthV4InProgressShowLeaderboard", 112, -1200043, "AuthV4InProgressShowLeaderboard");
        public static final Code AuthV4InProgressShowAchievements = new Code("AuthV4InProgressShowAchievements", 113, -1200044, "AuthV4InProgressShowAchievements");
        public static final Code AuthV4PlayerChange = new Code("AuthV4PlayerChange", 114, -1200045, "AuthV4PlayerChange");
        public static final Code AuthV4HelperImplifiedLoginFail = new Code("AuthV4HelperImplifiedLoginFail", 115, -1200046, "AuthV4HelperImplifiedLoginFail");
        public static final Code AuthV4PlayerResolved = new Code("AuthV4PlayerResolved", 116, -1200047, "AuthV4PlayerResolved");
        public static final Code AuthV4AgreementFail_DoExit = new Code("AuthV4AgreementFail_DoExit", 117, -1200048, "AuthV4AgreementFail_DoExit");
        public static final Code AuthV4AgreementFailWithWebviewError_DoExit = new Code("AuthV4AgreementFailWithWebviewError_DoExit", 118, -1200049, "AuthV4AgreementFailWithWebviewError_DoExit");
        public static final Code AuthV4MaintenanceActionDefault_DoExit = new Code("AuthV4MaintenanceActionDefault_DoExit", 119, -1200050, "AuthV4MaintenanceActionDefault_DoExit");
        public static final Code AuthV4MaintenanceActionOpenURL_DoExit = new Code("AuthV4MaintenanceActionOpenURL_DoExit", 120, -1200051, "AuthV4MaintenanceActionOpenURL_DoExit");
        public static final Code AuthV4MaintenanceActionExit_DoExit = new Code("AuthV4MaintenanceActionExit_DoExit", 121, -1200052, "AuthV4MaintenanceActionExit_DoExit");
        public static final Code AuthV4MaintenanceActionDone = new Code("AuthV4MaintenanceActionDone", 122, -1200053, "AuthV4MaintenanceActionDone");
        public static final Code AuthV4MaintenanceTimeover_DoExit = new Code("AuthV4MaintenanceTimeover_DoExit", 123, -1200054, "AuthV4MaintenanceTimeover_DoExit");
        public static final Code AuthV4NetworkError = new Code("AuthV4NetworkError", 124, -1200055, "AuthV4NetworkError");
        public static final Code AuthV4InvalidResponseData = new Code("AuthV4InvalidResponseData", 125, -1200056, "AuthV4InvalidResponseData");
        public static final Code AuthV4ServerResponseError = new Code("AuthV4ServerResponseError", 126, -1200057, "AuthV4ServerResponseError");
        public static final Code AuthV4NeedSignIn = new Code("AuthV4NeedSignIn", 127, -1200058, "AuthV4NeedSignIn");
        public static final Code AuthV4InProgress = new Code("AuthV4InProgress", 128, -1200059, "AuthV4InProgress");
        public static final Code AuthV4InvalidParam = new Code("AuthV4InvalidParam", TsExtractor.TS_STREAM_TYPE_AC3, -1200060, "AuthV4InvalidParam");
        public static final Code AuthV4SkipPermissionView = new Code("AuthV4SkipPermissionView", TsExtractor.TS_STREAM_TYPE_HDMV_DTS, -1200061, "AuthV4SkipPermissionView");
        public static final Code AuthV4InvalidCertification = new Code("AuthV4InvalidCertification", 131, -1200062, "AuthV4InvalidCertification");
        public static final Code AuthV4LastProviderCantDisconnect = new Code("AuthV4LastProviderCantDisconnect", 132, -1200063, "AuthV4LastProviderCantDisconnect");
        public static final Code AuthV4ServiceShutdown = new Code("AuthV4ServiceShutdown", 133, -1200064, "AuthV4ServiceShutdown");
        public static final Code AuthV4SignOutNotAllowGuestLogout = new Code("AuthV4SignOutNotAllowGuestLogout", TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, -1200065, "AuthV4SignOutNotAllowGuestLogout");
        public static final Code AuthV4SessionProcessingFail = new Code("AuthV4SessionProcessingFail", TsExtractor.TS_STREAM_TYPE_E_AC3, -1200066, "AuthV4SessionProcessingFail");
        public static final Code AgeLimit = new Code("AgeLimit", 136, -1200067, "AgeLimit");
        public static final Code AuthV4ProviderLoginError = new Code("AuthV4ProviderLoginError", 137, -1200101, "AuthV4ProviderLoginError");
        public static final Code AuthV4ProviderLogoutError = new Code("AuthV4ProviderLogoutError", TsExtractor.TS_STREAM_TYPE_DTS, -1200102, "AuthV4ProviderLogoutError");
        public static final Code AuthV4ProviderNotSupportGetFriends = new Code("AuthV4ProviderNotSupportGetFriends", 139, -1200103, "AuthV4ProviderNotSupportGetFriends");
        public static final Code AuthV4ProviderLoginCancel = new Code("AuthV4ProviderLoginCancel", 140, -1200104, "AuthV4ProviderLoginCancel");
        public static final Code AuthV4ProviderMissingKey = new Code("AuthV4ProviderMissingKey", 141, -1200105, "AuthV4ProviderMissingKey");
        public static final Code AuthV4ProviderNotSupportedMyInquiry = new Code("AuthV4ProviderNotSupportedMyInquiry", 142, -1200106, "AuthV4ProviderNotSupportedMyInquiry");
        public static final Code AuthV4FacebookUserCanceled = new Code("AuthV4FacebookUserCanceled", 143, -1200201, "AuthV4FacebookUserCanceled");
        public static final Code AuthV4FacebookResponseFailGetFriends = new Code("AuthV4FacebookResponseFailGetFriends", 144, -1200202, "AuthV4FacebookResponseFailGetFriends");
        public static final Code AuthV4FacebookNetworkErrorUploadProfile = new Code("AuthV4FacebookNetworkErrorUploadProfile", 145, -1200203, "AuthV4FacebookNetworkErrorUploadProfile");
        public static final Code AuthV4FacebookResponseFailUploadProfile = new Code("AuthV4FacebookResponseFailUploadProfile", 146, -1200204, "AuthV4FacebookResponseFailUploadProfile");
        public static final Code AuthV4FacebookResponseError = new Code("AuthV4FacebookResponseError", 147, -1200205, "AuthV4FacebookResponseError");
        public static final Code AuthV4FacebookInvalidResponseData = new Code("AuthV4FacebookInvalidResponseData", 148, -1200206, "AuthV4FacebookInvalidResponseData");
        public static final Code AuthV4FacebookNetworkError = new Code("AuthV4FacebookNetworkError", 149, -1200207, "AuthV4FacebookNetworkError");
        public static final Code AuthV4FacebookCancel = new Code("AuthV4FacebookCancel", TextFieldImplKt.AnimationDuration, -1200208, "AuthV4FacebookCancel");
        public static final Code AuthV4GoogleResponseFailLogin = new Code("AuthV4GoogleResponseFailLogin", 151, -1200301, "AuthV4GoogleResponseFailLogin");
        public static final Code AuthV4GoogleResponseFailLogout = new Code("AuthV4GoogleResponseFailLogout", 152, -1200302, "AuthV4GoogleResponseFailLogout");
        public static final Code AuthV4GoogleNetworkErrorUploadProfile = new Code("AuthV4GoogleNetworkErrorUploadProfile", 153, -1200303, "AuthV4GoogleNetworkErrorUploadProfile");
        public static final Code AuthV4GoogleResponseFailUploadProfile = new Code("AuthV4GoogleResponseFailUploadProfile", 154, -1200304, "AuthV4GoogleResponseFailUploadProfile");
        public static final Code AuthV4GoogleResponseFailShowAchievements = new Code("AuthV4GoogleResponseFailShowAchievements", 155, -1200305, "AuthV4GoogleResponseFailShowAchievements");
        public static final Code AuthV4GoogleResponseFailShowLeaderboards = new Code("AuthV4GoogleResponseFailShowLeaderboards", 156, -1200306, "AuthV4GoogleResponseFailShowLeaderboards");
        public static final Code AuthV4GoogleNotSupported = new Code("AuthV4GoogleNotSupported", 157, -1200307, "AuthV4GoogleNotSupported");
        public static final Code AuthV4GoogleLoginCancel = new Code("AuthV4GoogleLoginCancel", 158, -1200308, "AuthV4GoogleLoginCancel");
        public static final Code AuthV4GoogleNetworkError = new Code("AuthV4GoogleNetworkError", 159, -1200309, "AuthV4GoogleNetworkError");
        public static final Code AuthV4GoogleLogout = new Code("AuthV4GoogleLogout", 160, -1200310, "AuthV4GoogleLogout");
        public static final Code AuthV4GoogleResponseFailAchievementsReveal = new Code("AuthV4GoogleResponseFailAchievementsReveal", 161, -1200311, "AuthV4GoogleResponseFailAchievementsReveal");
        public static final Code AuthV4GoogleResponseFailAchievementsUnlock = new Code("AuthV4GoogleResponseFailAchievementsUnlock", 162, -1200312, "AuthV4GoogleResponseFailAchievementsUnlock");
        public static final Code AuthV4GoogleResponseFailAchievementsIncrement = new Code("AuthV4GoogleResponseFailAchievementsIncrement", 163, -1200313, "AuthV4GoogleResponseFailAchievementsIncrement");
        public static final Code AuthV4GoogleResponseFailLeaderboardsSubmitScore = new Code("AuthV4GoogleResponseFailLeaderboardsSubmitScore", 164, -1200314, "AuthV4GoogleResponseFailLeaderboardsSubmitScore");
        public static final Code AuthV4GoogleNeedSignIn = new Code("AuthV4GoogleNeedSignIn", 165, -1200315, "AuthV4GoogleNeedSignIn");
        public static final Code AuthV4GoogleNeedSettingOption = new Code("AuthV4GoogleNeedSettingOption", 166, -1200316, "AuthV4GoogleNeedSettingOption");
        public static final Code AuthV4GoogleResponseFailPGSGetServerAccessToken = new Code("AuthV4GoogleResponseFailPGSGetServerAccessToken", 167, -1200317, "AuthV4GoogleResponseFailPGSGetServerAccessToken");
        public static final Code AuthV4GoogleResponseFailPGSGetPlayerId = new Code("AuthV4GoogleResponseFailPGSGetPlayerId", 168, -1200318, "AuthV4GoogleResponseFailPGSGetPlayerId");
        public static final Code AuthV4GoogleObjectNotReady = new Code("AuthV4GoogleObjectNotReady", 169, -1200319, "AuthV4GoogleObjectNotReady");
        public static final Code AuthV4AppleLoginCancel = new Code("AuthV4AppleLoginCancel", 170, -1200401, "AuthV4AppleLoginCancel");
        public static final Code AuthV4AppleResponseFailLogin = new Code("AuthV4AppleResponseFailLogin", 171, -1200402, "AuthV4AppleResponseFailLogin");
        public static final Code AuthV4AppleTimeOut = new Code("AuthV4AppleTimeOut", TsExtractor.TS_STREAM_TYPE_AC4, -1200403, "AuthV4AppleTimeOut");
        public static final Code AuthV4AppleResponseFailReportScore = new Code("AuthV4AppleResponseFailReportScore", TTAdConstant.IMAGE_MODE_VERTICAL_IMG_173, -1200404, "AuthV4AppleResponseFailReportScore");
        public static final Code AuthV4AppleInProgressGameCenterVC = new Code("AuthV4AppleInProgressGameCenterVC", 174, -1200405, "AuthV4AppleInProgressGameCenterVC");
        public static final Code AuthV4AppleResponseFailLoadAchievements = new Code("AuthV4AppleResponseFailLoadAchievements", 175, -1200406, "AuthV4AppleResponseFailLoadAchievements");
        public static final Code AuthV4AppleResponseFailReportAchievements = new Code("AuthV4AppleResponseFailReportAchievements", 176, -1200407, "AuthV4AppleResponseFailReportAchievements");
        public static final Code AuthV4AppleResponseFailResetAchievements = new Code("AuthV4AppleResponseFailResetAchievements", 177, -1200408, "AuthV4AppleResponseFailResetAchievements");
        public static final Code AuthV4AppleNotSupported = new Code("AuthV4AppleNotSupported", 178, -1200409, "AuthV4AppleNotSupported");
        public static final Code AuthV4AppleInProgress = new Code("AuthV4AppleInProgress", 179, -1200410, "AuthV4AppleInProgress");
        public static final Code AuthV4AppleResponseError = new Code("AuthV4AppleResponseError", 180, -1200411, "AuthV4AppleResponseError");
        public static final Code AuthV4AppleCancel = new Code("AuthV4AppleCancel", 181, -1200412, "AuthV4AppleCancel");
        public static final Code AuthV4VKResponseFailLogin = new Code("AuthV4VKResponseFailLogin", 182, -1200501, "AuthV4VKResponseFailLogin");
        public static final Code AuthV4VKInvalidParamSDK = new Code("AuthV4VKInvalidParamSDK", 183, -1200502, "AuthV4VKInvalidParamSDK");
        public static final Code AuthV4VKNotInitialized = new Code("AuthV4VKNotInitialized", 184, -1200503, "AuthV4VKNotInitialized");
        public static final Code AuthV4VKCancelLogin = new Code("AuthV4VKCancelLogin", ModuleDescriptor.MODULE_VERSION, -1200504, "AuthV4VKCancelLogin");
        public static final Code AuthV4VKInvalidSession = new Code("AuthV4VKInvalidSession", 186, -1200505, "AuthV4VKInvalidSession");
        public static final Code AuthV4VKResponseFailGetFriends = new Code("AuthV4VKResponseFailGetFriends", 187, -1200506, "AuthV4VKResponseFailGetFriends");
        public static final Code AuthV4VKResponseFailLogout = new Code("AuthV4VKResponseFailLogout", TsExtractor.TS_PACKET_SIZE, -1200507, "AuthV4VKResponseFailLogout");
        public static final Code AuthV4VKResponseFailUploadProfile = new Code("AuthV4VKResponseFailUploadProfile", PsExtractor.PRIVATE_STREAM_1, -1200508, "AuthV4VKResponseFailUploadProfile");
        public static final Code AuthV4VKNetworkErrorUploadProfile = new Code("AuthV4VKNetworkErrorUploadProfile", FacebookRequestErrorClassification.EC_INVALID_TOKEN, -1200509, "AuthV4VKNetworkErrorUploadProfile");
        public static final Code AuthV4VKInProgress = new Code("AuthV4VKInProgress", 191, -1200510, "AuthV4VKInProgress");
        public static final Code AuthV4VKResponseError = new Code("AuthV4VKResponseError", PsExtractor.AUDIO_STREAM, -1200511, "AuthV4VKResponseError");
        public static final Code AuthV4VKNetworkError = new Code("AuthV4VKNetworkError", 193, -1200512, "AuthV4VKNetworkError");
        public static final Code AuthV4VKInvalidParam = new Code("AuthV4VKInvalidParam", 194, -1200513, "AuthV4VKInvalidParam");
        public static final Code AuthV4VKCancel = new Code("AuthV4VKCancel", 195, -1200514, "AuthV4VKCancel");
        public static final Code AuthV4VKTokenResponseError = new Code("AuthV4VKTokenResponseError", 196, -1200515, "AuthV4VKTokenResponseError");
        public static final Code AuthV4WechatInProgressLoginLogout = new Code("AuthV4WechatInProgressLoginLogout", 197, -1200601, "AuthV4WechatInProgressLoginLogout");
        public static final Code AuthV4WechatResponseFailLogin = new Code("AuthV4WechatResponseFailLogin", 198, -1200602, "AuthV4WechatResponseFailLogin");
        public static final Code AuthV4WechatNotSupportedRequest = new Code("AuthV4WechatNotSupportedRequest", 199, -1200603, "AuthV4WechatNotSupportedRequest");
        public static final Code AuthV4WechatResponseFailUserInfo = new Code("AuthV4WechatResponseFailUserInfo", 200, -1200604, "AuthV4WechatResponseFailUserInfo");
        public static final Code AuthV4WechatNetworkErrorUserInfo = new Code("AuthV4WechatNetworkErrorUserInfo", ComposerKt.providerKey, -1200605, "AuthV4WechatNetworkErrorUserInfo");
        public static final Code AuthV4WechatNetworkError = new Code("AuthV4WechatNetworkError", ComposerKt.compositionLocalMapKey, -1200606, "AuthV4WechatNetworkError");
        public static final Code AuthV4WechatResponseFail = new Code("AuthV4WechatResponseFail", ComposerKt.providerValuesKey, -1200607, "AuthV4WechatResponseFail");
        public static final Code AuthV4WechatNetworkErrorLogin = new Code("AuthV4WechatNetworkErrorLogin", 204, -1200608, "AuthV4WechatNetworkErrorLogin");
        public static final Code AuthV4WechatLoginCancel = new Code("AuthV4WechatLoginCancel", Constants.NEXT_STEP, -1200609, "AuthV4WechatLoginCancel");
        public static final Code AuthV4WechatInProgress = new Code("AuthV4WechatInProgress", ComposerKt.referenceKey, -1200610, "AuthV4WechatInProgress");
        public static final Code AuthV4WechatResponseError = new Code("AuthV4WechatResponseError", ComposerKt.reuseKey, -1200611, "AuthV4WechatResponseError");
        public static final Code AuthV4WechatInvalidResponseData = new Code("AuthV4WechatInvalidResponseData", 208, -1200612, "AuthV4WechatInvalidResponseData");
        public static final Code AuthV4WechatInvalidAppKey = new Code("AuthV4WechatInvalidAppKey", 209, -1200613, "AuthV4WechatInvalidAppKey");
        public static final Code AuthV4HIVEDialogCancel = new Code("AuthV4HIVEDialogCancel", 210, -1200701, "AuthV4HIVEDialogCancel");
        public static final Code AuthV4HIVENetworkErrorUploadProfile = new Code("AuthV4HIVENetworkErrorUploadProfile", 211, -1200702, "AuthV4HIVENetworkErrorUploadProfile");
        public static final Code AuthV4HIVEResponseFailUploadProfile = new Code("AuthV4HIVEResponseFailUploadProfile", 212, -1200703, "AuthV4HIVEResponseFailUploadProfile");
        public static final Code AuthV4HIVEInProgress = new Code("AuthV4HIVEInProgress", 213, -1200704, "AuthV4HIVEInProgress");
        public static final Code AuthV4HIVEResponseError = new Code("AuthV4HIVEResponseError", 214, -1200705, "AuthV4HIVEResponseError");
        public static final Code AuthV4HIVENetworkError = new Code("AuthV4HIVENetworkError", 215, -1200706, "AuthV4HIVENetworkError");
        public static final Code AuthV4HIVEInvalidParam = new Code("AuthV4HIVEInvalidParam", 216, -1200707, "AuthV4HIVEInvalidParam");
        public static final Code AuthV4HIVECancel = new Code("AuthV4HIVECancel", 217, -1200708, "AuthV4HIVECancel");
        public static final Code AuthV4QQInProgressLoginLogout = new Code("AuthV4QQInProgressLoginLogout", 218, -1200801, "AuthV4QQInProgressLoginLogout");
        public static final Code AuthV4QQResponseFailLogin = new Code("AuthV4QQResponseFailLogin", 219, -1200802, "AuthV4QQResponseFailLogin");
        public static final Code AuthV4QQCancelLogin = new Code("AuthV4QQCancelLogin", 220, -1200803, "AuthV4QQCancelLogin");
        public static final Code AuthV4QQNetworkError = new Code("AuthV4QQNetworkError", 221, -1200804, "AuthV4QQNetworkError");
        public static final Code AuthV4QQNetworkErrorUploadProfile = new Code("AuthV4QQNetworkErrorUploadProfile", 222, -1200805, "AuthV4QQNetworkErrorUploadProfile");
        public static final Code AuthV4QQResponseFailUploadProfile = new Code("AuthV4QQResponseFailUploadProfile", 223, -1200806, "AuthV4QQResponseFailUploadProfile");
        public static final Code AuthV4QQCancelUploadProfile = new Code("AuthV4QQCancelUploadProfile", 224, -1200807, "AuthV4QQCancelUploadProfile");
        public static final Code AuthV4QQResponseFailLogout = new Code("AuthV4QQResponseFailLogout", 225, -1200808, "AuthV4QQResponseFailLogout");
        public static final Code AuthV4QQNotInitialized = new Code("AuthV4QQNotInitialized", 226, -1200809, "AuthV4QQNotInitialized");
        public static final Code AuthV4QQInProgress = new Code("AuthV4QQInProgress", 227, -1200810, "AuthV4QQInProgress");
        public static final Code AuthV4QQResponseError = new Code("AuthV4QQResponseError", 228, -1200811, "AuthV4QQResponseError");
        public static final Code AuthV4QQInvalidResponseData = new Code("AuthV4QQInvalidResponseData", 229, -1200812, "AuthV4QQInvalidResponseData");
        public static final Code AuthV4QQInvalidParam = new Code("AuthV4QQInvalidParam", 230, -1200813, "AuthV4QQInvalidParam");
        public static final Code AuthV4QQCancel = new Code("AuthV4QQCancel", 231, -1200814, "AuthV4QQCancel");
        public static final Code AuthV4LineInvalidParam = new Code("AuthV4LineInvalidParam", 232, -1201001, "AuthV4LineInvalidParam");
        public static final Code AuthV4LineCancel = new Code("AuthV4LineCancel", 233, -1201002, "AuthV4LineCancel");
        public static final Code AuthV4LineResponseError = new Code("AuthV4LineResponseError", 234, -1201003, "AuthV4LineResponseError");
        public static final Code AuthV4LineNetworkError = new Code("AuthV4LineNetworkError", 235, -1201004, "AuthV4LineNetworkError");
        public static final Code AuthV4TwitterResponseError = new Code("AuthV4TwitterResponseError", 236, -1201101, "AuthV4TwitterResponseError");
        public static final Code AuthV4TwitterInvalidParam = new Code("AuthV4TwitterInvalidParam", 237, -1201102, "AuthV4TwitterInvalidParam");
        public static final Code AuthV4WeverseInProgressLoginLogout = new Code("AuthV4WeverseInProgressLoginLogout", 238, -1201201, "AuthV4WeverseInProgressLoginLogout");
        public static final Code AuthV4WeverseResponseFailLogin = new Code("AuthV4WeverseResponseFailLogin", 239, -1201202, "AuthV4WeverseResponseFailLogin");
        public static final Code AuthV4WeverseNotSupported = new Code("AuthV4WeverseNotSupported", PsExtractor.VIDEO_STREAM_MASK, -1201203, "AuthV4WeverseNotSupported");
        public static final Code AuthV4WeverseNetworkError = new Code("AuthV4WeverseNetworkError", 241, -1201204, "AuthV4WeverseNetworkError");
        public static final Code AuthV4WeverseLoginCancel = new Code("AuthV4WeverseLoginCancel", 242, -1201205, "AuthV4WeverseLoginCancel");
        public static final Code AuthV4WeverseResponseError = new Code("AuthV4WeverseResponseError", 243, -1201206, "AuthV4WeverseResponseError");
        public static final Code AuthV4NotRegisteredDevice = new Code("AuthV4NotRegisteredDevice", 244, -1201300, "AuthV4NotRegisteredDevice");
        public static final Code AuthV4HuaweiNotInitialized = new Code("AuthV4HuaweiNotInitialized", 245, -1201401, "AuthV4HuaweiNotInitialized");
        public static final Code AuthV4HuaweiInProgress = new Code("AuthV4HuaweiInProgress", 246, -1201402, "AuthV4HuaweiInProgress");
        public static final Code AuthV4HuaweiInvalidParam = new Code("AuthV4HuaweiInvalidParam", 247, -1201403, "AuthV4HuaweiInvalidParam");
        public static final Code AuthV4HuaweiLoginCancel = new Code("AuthV4HuaweiLoginCancel", 248, -1201404, "AuthV4HuaweiLoginCancel");
        public static final Code AuthV4HuaweiNetworkError = new Code("AuthV4HuaweiNetworkError", 249, -1201405, "AuthV4HuaweiNetworkError");
        public static final Code AuthV4HuaweiResponseError = new Code("AuthV4HuaweiResponseError", 250, -1201406, "AuthV4HuaweiResponseError");
        public static final Code SocialResponseFailDismissDialog = new Code("SocialResponseFailDismissDialog", 251, -2000001, "SocialResponseFailDismissDialog");
        public static final Code SocialCancelDismissDialog = new Code("SocialCancelDismissDialog", 252, -2000002, "SocialCancelDismissDialog");
        public static final Code SocialCancelConnect = new Code("SocialCancelConnect", 253, -2000003, "SocialCancelConnect");
        public static final Code SocialResponseFailConnect = new Code("SocialResponseFailConnect", 254, -2000004, "SocialResponseFailConnect");
        public static final Code SocialCancelGetPictureFromGallery = new Code("SocialCancelGetPictureFromGallery", 255, -2000005, "SocialCancelGetPictureFromGallery");
        public static final Code SocialResponseFailGetPictureFromGallery = new Code("SocialResponseFailGetPictureFromGallery", 256, -2000006, "SocialResponseFailGetPictureFromGallery");
        public static final Code SocialCancelSharePhoto = new Code("SocialCancelSharePhoto", 257, -2000007, "SocialCancelSharePhoto");
        public static final Code SocialResponseFailSharePhoto = new Code("SocialResponseFailSharePhoto", 258, -2000008, "SocialResponseFailSharePhoto");
        public static final Code SocialInvalidParam = new Code("SocialInvalidParam", 259, -2000009, "SocialInvalidParam");
        public static final Code SocialProviderNotInitialized = new Code("SocialProviderNotInitialized", 260, -2000010, "SocialProviderNotInitialized");
        public static final Code SocialNeedSignIn = new Code("SocialNeedSignIn", 261, -2000011, "SocialNeedSignIn");
        public static final Code SocialGoogleNotInitialized = new Code("SocialGoogleNotInitialized", 262, -2000101, "SocialGoogleNotInitialized");
        public static final Code SocialGoogleResponseFailGetProfile = new Code("SocialGoogleResponseFailGetProfile", 263, -2000102, "SocialGoogleResponseFailGetProfile");
        public static final Code SocialGoogleInProgressConnect = new Code("SocialGoogleInProgressConnect", 264, -2000103, "SocialGoogleInProgressConnect");
        public static final Code SocialGoogleResponseFailConnect = new Code("SocialGoogleResponseFailConnect", 265, -2000104, "SocialGoogleResponseFailConnect");
        public static final Code SocialGoogleCancelGetProfile = new Code("SocialGoogleCancelGetProfile", 266, -2000105, "SocialGoogleCancelGetProfile");
        public static final Code SocialGoogleCancelConnect = new Code("SocialGoogleCancelConnect", 267, -2000106, "SocialGoogleCancelConnect");
        public static final Code SocialGoogleNetworkErrorUpdateServerFlag = new Code("SocialGoogleNetworkErrorUpdateServerFlag", 268, -2000107, "SocialGoogleNetworkErrorUpdateServerFlag");
        public static final Code SocialGoogleResponseFailUpdateServerFlag = new Code("SocialGoogleResponseFailUpdateServerFlag", 269, -2000108, "SocialGoogleResponseFailUpdateServerFlag");
        public static final Code SocialGoogleCancelGetFriends = new Code("SocialGoogleCancelGetFriends", 270, -2000109, "SocialGoogleCancelGetFriends");
        public static final Code SocialFacebookNotInitialized = new Code("SocialFacebookNotInitialized", 271, -2000201, "SocialFacebookNotInitialized");
        public static final Code SocialFacebookResponseFailGetProfile = new Code("SocialFacebookResponseFailGetProfile", 272, -2000202, "SocialFacebookResponseFailGetProfile");
        public static final Code SocialFacebookCancelGetProfile = new Code("SocialFacebookCancelGetProfile", 273, -2000203, "SocialFacebookCancelGetProfile");
        public static final Code SocialFacebookResponseFailGetFriends = new Code("SocialFacebookResponseFailGetFriends", 274, -2000204, "SocialFacebookResponseFailGetFriends");
        public static final Code SocialFacebookCancelGetFriends = new Code("SocialFacebookCancelGetFriends", 275, -2000205, "SocialFacebookCancelGetFriends");
        public static final Code SocialFacebookResponseFailSendMessage = new Code("SocialFacebookResponseFailSendMessage", 276, -2000206, "SocialFacebookResponseFailSendMessage");
        public static final Code SocialFacebookCancelSendMessage = new Code("SocialFacebookCancelSendMessage", 277, -2000207, "SocialFacebookCancelSendMessage");
        public static final Code SocialFacebookMessageDialogShowFail = new Code("SocialFacebookMessageDialogShowFail", 278, -2000208, "SocialFacebookMessageDialogShowFail");
        public static final Code SocialFacebookResponseFailShowInvitation = new Code("SocialFacebookResponseFailShowInvitation", 279, -2000209, "SocialFacebookResponseFailShowInvitation");
        public static final Code SocialFacebookCancelShowInvitation = new Code("SocialFacebookCancelShowInvitation", 280, -2000210, "SocialFacebookCancelShowInvitation");
        public static final Code SocialFacebookInvalidParamPost = new Code("SocialFacebookInvalidParamPost", 281, -2000211, "SocialFacebookInvalidParamPost");
        public static final Code SocialFacebookPostDialogShowFail = new Code("SocialFacebookPostDialogShowFail", 282, -2000212, "SocialFacebookPostDialogShowFail");
        public static final Code SocialFacebookShareFail = new Code("SocialFacebookShareFail", 283, -2000213, "SocialFacebookShareFail");
        public static final Code SocialFacebookShareCancelled = new Code("SocialFacebookShareCancelled", 284, -2000214, "SocialFacebookShareCancelled");
        public static final Code SocialFacebookSendInvitationFail = new Code("SocialFacebookSendInvitationFail", 285, -2000215, "SocialFacebookSendInvitationFail");
        public static final Code SocialFacebookSendInvitationCancelled = new Code("SocialFacebookSendInvitationCancelled", 286, -2000216, "SocialFacebookSendInvitationCancelled");
        public static final Code SocialFacebookCancelPost = new Code("SocialFacebookCancelPost", 287, -2000217, "SocialFacebookCancelPost");
        public static final Code SocialFacebookResponseFailPost = new Code("SocialFacebookResponseFailPost", 288, -2000218, "SocialFacebookResponseFailPost");
        public static final Code SocialFacebookOperationException = new Code("SocialFacebookOperationException", 289, -2000219, "SocialFacebookOperationException");
        public static final Code SocialFacebookServiceException = new Code("SocialFacebookServiceException", 290, -2000220, "SocialFacebookServiceException");
        public static final Code SocialFacebookException = new Code("SocialFacebookException", 291, -2000221, "SocialFacebookException");
        public static final Code SocialHIVENotInitialized = new Code("SocialHIVENotInitialized", 292, -2000301, "SocialHIVENotInitialized");
        public static final Code SocialHIVENetworkErrorGetMyProfile = new Code("SocialHIVENetworkErrorGetMyProfile", 293, -2000302, "SocialHIVENetworkErrorGetMyProfile");
        public static final Code SocialHIVEInvalidParamSetMyProfile = new Code("SocialHIVEInvalidParamSetMyProfile", 294, -2000303, "SocialHIVEInvalidParamSetMyProfile");
        public static final Code SocialHIVENetworkErrorSetMyProfile = new Code("SocialHIVENetworkErrorSetMyProfile", 295, -2000304, "SocialHIVENetworkErrorSetMyProfile");
        public static final Code SocialHIVENetworkErrorGetFriends = new Code("SocialHIVENetworkErrorGetFriends", 296, -2000305, "SocialHIVENetworkErrorGetFriends");
        public static final Code SocialHIVEInvalidSession = new Code("SocialHIVEInvalidSession", 297, -2000306, "SocialHIVEInvalidSession");
        public static final Code SocialHIVEInvalidParamVID = new Code("SocialHIVEInvalidParamVID", 298, -2000307, "SocialHIVEInvalidParamVID");
        public static final Code SocialHIVENetworkErrorGetVIDByUIDList = new Code("SocialHIVENetworkErrorGetVIDByUIDList", 299, -2000308, "SocialHIVENetworkErrorGetVIDByUIDList");
        public static final Code SocialHIVENetworkErrorGetUIDByVIDList = new Code("SocialHIVENetworkErrorGetUIDByVIDList", AnimationConstants.DefaultDurationMillis, -2000309, "SocialHIVENetworkErrorGetUIDByVIDList");
        public static final Code SocialHIVEInvalidParamContentSendMessage = new Code("SocialHIVEInvalidParamContentSendMessage", 301, -2000310, "SocialHIVEInvalidParamContentSendMessage");
        public static final Code SocialHIVENetworkErrorSendMessage = new Code("SocialHIVENetworkErrorSendMessage", 302, -2000311, "SocialHIVENetworkErrorSendMessage");
        public static final Code SocialHIVEInvalidParamReceiptSendMessage = new Code("SocialHIVEInvalidParamReceiptSendMessage", 303, -2000312, "SocialHIVEInvalidParamReceiptSendMessage");
        public static final Code SocialHIVEInvalidParamUID = new Code("SocialHIVEInvalidParamUID", 304, -2000313, "SocialHIVEInvalidParamUID");
        public static final Code SocialHIVEInProgressSocialDialog = new Code("SocialHIVEInProgressSocialDialog", 305, -2000314, "SocialHIVEInProgressSocialDialog");
        public static final Code SocialHIVESocialDialogClosed = new Code("SocialHIVESocialDialogClosed", 306, -2000315, "SocialHIVESocialDialogClosed");
        public static final Code SocialHIVENetworkErrorGetBadgeInfo = new Code("SocialHIVENetworkErrorGetBadgeInfo", 307, -2000316, "SocialHIVENetworkErrorGetBadgeInfo");
        public static final Code SocialHIVEResponseFailGetMyProfile = new Code("SocialHIVEResponseFailGetMyProfile", 308, -2000317, "SocialHIVEResponseFailGetMyProfile");
        public static final Code SocialHIVEResponseFailSetMyProfile = new Code("SocialHIVEResponseFailSetMyProfile", 309, -2000318, "SocialHIVEResponseFailSetMyProfile");
        public static final Code SocialHIVEResponseFailGetFriends = new Code("SocialHIVEResponseFailGetFriends", 310, -2000319, "SocialHIVEResponseFailGetFriends");
        public static final Code SocialHIVEResponseFailGetVID = new Code("SocialHIVEResponseFailGetVID", 311, -2000320, "SocialHIVEResponseFailGetVID");
        public static final Code SocialHIVEResponseFailInvalidVIDList = new Code("SocialHIVEResponseFailInvalidVIDList", 312, -2000321, "SocialHIVEResponseFailInvalidVIDList");
        public static final Code SocialHIVEResponseFailGetUID = new Code("SocialHIVEResponseFailGetUID", 313, -2000322, "SocialHIVEResponseFailGetUID");
        public static final Code SocialHIVEResponseFailInvalidUIDList = new Code("SocialHIVEResponseFailInvalidUIDList", 314, -2000323, "SocialHIVEResponseFailInvalidUIDList");
        public static final Code SocialHIVEResponseFailSendMessage = new Code("SocialHIVEResponseFailSendMessage", 315, -2000324, "SocialHIVEResponseFailSendMessage");
        public static final Code SocialHIVEResponseFailGetBadgeInfo = new Code("SocialHIVEResponseFailGetBadgeInfo", TypedValues.AttributesType.TYPE_PATH_ROTATE, -2000325, "SocialHIVEResponseFailGetBadgeInfo");
        public static final Code SocialHIVEResponseFailDialogWebView = new Code("SocialHIVEResponseFailDialogWebView", TypedValues.AttributesType.TYPE_EASING, -2000326, "SocialHIVEResponseFailDialogWebView");
        public static final Code SocialHIVEResponseFailSocialDialog = new Code("SocialHIVEResponseFailSocialDialog", TypedValues.AttributesType.TYPE_PIVOT_TARGET, -2000327, "SocialHIVEResponseFailSocialDialog");
        public static final Code SocialHIVEInvalidParamFriendType = new Code("SocialHIVEInvalidParamFriendType", 319, -2000328, "SocialHIVEInvalidParamFriendType");
        public static final Code SocialHIVEResponseFailGetProfiles = new Code("SocialHIVEResponseFailGetProfiles", 320, -2000329, "SocialHIVEResponseFailGetProfiles");
        public static final Code SocialHIVEInvalidParamGetProfiles = new Code("SocialHIVEInvalidParamGetProfiles", 321, -2000330, "SocialHIVEInvalidParamGetProfiles");
        public static final Code SocialHIVEResponseFail = new Code("SocialHIVEResponseFail", 322, -2000331, "SocialHIVEResponseFail");
        public static final Code SocialHIVEInvalidParamSendMessage = new Code("SocialHIVEInvalidParamSendMessage", 323, -2000332, "SocialHIVEInvalidParamSendMessage");
        public static final Code SocialHIVEInvalidParamSendInvitationMessage = new Code("SocialHIVEInvalidParamSendInvitationMessage", 324, -2000333, "SocialHIVEInvalidParamSendInvitationMessage");
        public static final Code SocialHIVEResponseFailGetPictureFromGallery = new Code("SocialHIVEResponseFailGetPictureFromGallery", 325, -2000334, "SocialHIVEResponseFailGetPictureFromGallery");
        public static final Code SocialHIVEResponseFailGetPictureFromCamera = new Code("SocialHIVEResponseFailGetPictureFromCamera", 326, -2000335, "SocialHIVEResponseFailGetPictureFromCamera");
        public static final Code SocialHIVENetworkErrorSendInvitationMessage = new Code("SocialHIVENetworkErrorSendInvitationMessage", 327, -2000336, "SocialHIVENetworkErrorSendInvitationMessage");
        public static final Code SocialHIVENetworkErrorDeviceRegistered = new Code("SocialHIVENetworkErrorDeviceRegistered", 328, -2000337, "SocialHIVENetworkErrorDeviceRegistered");
        public static final Code SocialHIVENetworkErrorGuestKey = new Code("SocialHIVENetworkErrorGuestKey", 329, -2000338, "SocialHIVENetworkErrorGuestKey");
        public static final Code SocialHIVENetworkErrorGuestGenerate = new Code("SocialHIVENetworkErrorGuestGenerate", 330, -2000339, "SocialHIVENetworkErrorGuestGenerate");
        public static final Code SocialHIVENetworkErrorGuestCreate = new Code("SocialHIVENetworkErrorGuestCreate", 331, -2000340, "SocialHIVENetworkErrorGuestCreate");
        public static final Code SocialHIVENetworkErrorGuestLogin = new Code("SocialHIVENetworkErrorGuestLogin", 332, -2000341, "SocialHIVENetworkErrorGuestLogin");
        public static final Code SocialHIVENetworkErrorGuestAuth = new Code("SocialHIVENetworkErrorGuestAuth", 333, -2000342, "SocialHIVENetworkErrorGuestAuth");
        public static final Code SocialHIVENetworkErrorSaveDataUpload = new Code("SocialHIVENetworkErrorSaveDataUpload", 334, -2000343, "SocialHIVENetworkErrorSaveDataUpload");
        public static final Code SocialHIVENetworkErrorSaveDataDownload = new Code("SocialHIVENetworkErrorSaveDataDownload", 335, -2000344, "SocialHIVENetworkErrorSaveDataDownload");
        public static final Code SocialHIVENetworkErrorSaveDataDelete = new Code("SocialHIVENetworkErrorSaveDataDelete", 336, -2000345, "SocialHIVENetworkErrorSaveDataDelete");
        public static final Code SocialHIVENetworkErrorUploadImage = new Code("SocialHIVENetworkErrorUploadImage", 337, -2000346, "SocialHIVENetworkErrorUploadImage");
        public static final Code SocialHIVENetworkErrorWallWrite = new Code("SocialHIVENetworkErrorWallWrite", 338, -2000347, "SocialHIVENetworkErrorWallWrite");
        public static final Code SocialHIVENetworkErrorFriendsRejectRequest = new Code("SocialHIVENetworkErrorFriendsRejectRequest", 339, -2000348, "SocialHIVENetworkErrorFriendsRejectRequest");
        public static final Code SocialHIVENetworkErrorFriendsRequest = new Code("SocialHIVENetworkErrorFriendsRequest", 340, -2000349, "SocialHIVENetworkErrorFriendsRequest");
        public static final Code SocialHIVENetworkErrorFriendsReceiveList = new Code("SocialHIVENetworkErrorFriendsReceiveList", FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, -2000350, "SocialHIVENetworkErrorFriendsReceiveList");
        public static final Code SocialHIVENetworkErrorGuestStatusSaveData = new Code("SocialHIVENetworkErrorGuestStatusSaveData", 342, -2000351, "SocialHIVENetworkErrorGuestStatusSaveData");
        public static final Code SocialHIVENetworkErrorUserMeNotification = new Code("SocialHIVENetworkErrorUserMeNotification", 343, -2000352, "SocialHIVENetworkErrorUserMeNotification");
        public static final Code SocialHIVESocialRequestError = new Code("SocialHIVESocialRequestError", 344, -2000353, "SocialHIVESocialRequestError");
        public static final Code SocialHIVENetworkErrorMessageNotiCount = new Code("SocialHIVENetworkErrorMessageNotiCount", 345, -2000354, "SocialHIVENetworkErrorMessageNotiCount");
        public static final Code SocialHIVEResponseFailGetPictureFromChooser = new Code("SocialHIVEResponseFailGetPictureFromChooser", 346, -2000355, "SocialHIVEResponseFailGetPictureFromChooser");
        public static final Code PromotionNotInitialized = new Code("PromotionNotInitialized", 347, -3000001, "PromotionNotInitialized");
        public static final Code PromotionAlreadyShowing = new Code("PromotionAlreadyShowing", 348, -3000002, "PromotionAlreadyShowing");
        public static final Code PromotionNetworkErrorShowCustomContents = new Code("PromotionNetworkErrorShowCustomContents", 349, -3000003, "PromotionNetworkErrorShowCustomContents");
        public static final Code PromotionNetworkErrorShowOfferwall = new Code("PromotionNetworkErrorShowOfferwall", 350, -3000004, "PromotionNetworkErrorShowOfferwall");
        public static final Code PromotionShowDialogFail = new Code("PromotionShowDialogFail", 351, -3000005, "PromotionShowDialogFail");
        public static final Code PromotionResponseFailGetViewInfo = new Code("PromotionResponseFailGetViewInfo", 352, -3000006, "PromotionResponseFailGetViewInfo");
        public static final Code PromotionNetworkError = new Code("PromotionNetworkError", 353, -3000007, "PromotionNetworkError");
        public static final Code PromotionServerResponseError = new Code("PromotionServerResponseError", 354, -3000008, "PromotionServerResponseError");
        public static final Code PromotionInvalidResponseData = new Code("PromotionInvalidResponseData", 355, -3000009, "PromotionInvalidResponseData");
        public static final Code PromotionShareFailed = new Code("PromotionShareFailed", 356, -3000010, "PromotionShareFailed");
        public static final Code UserEngagementResponseFail = new Code("UserEngagementResponseFail", 357, -3200001, "UserEngagementResponseFail");
        public static final Code UserEngagementAlreadySetReady = new Code("UserEngagementAlreadySetReady", 358, -3200002, "UserEngagementAlreadySetReady");
        public static final Code UserEngagementHandlerNotRegistered = new Code("UserEngagementHandlerNotRegistered", 359, -3200003, "UserEngagementHandlerNotRegistered");
        public static final Code UserEngagementNotLogined = new Code("UserEngagementNotLogined", 360, -3200004, "UserEngagementNotLogined");
        public static final Code UserEngagementEmptyCouponId = new Code("UserEngagementEmptyCouponId", 361, -3200005, "UserEngagementEmptyCouponId");
        public static final Code UserEngagementEmptyMarketPid = new Code("UserEngagementEmptyMarketPid", 362, -3200006, "UserEngagementEmptyMarketPid");
        public static final Code UserEngagementListenerNotRegistered = new Code("UserEngagementListenerNotRegistered", 363, -3200007, "UserEngagementListenerNotRegistered");
        public static final Code PromotionStartPlayback = new Code("PromotionStartPlayback", 364, -3300001, "PromotionStartPlayback");
        public static final Code PromotionFinishPlayback = new Code("PromotionFinishPlayback", 365, -3300002, "PromotionFinishPlayback");
        public static final Code PromotionYTPlayerError = new Code("PromotionYTPlayerError", 366, -3300003, "PromotionYTPlayerError");
        public static final Code PromotionCancelPlayback = new Code("PromotionCancelPlayback", 367, -3300004, "PromotionCancelPlayback");
        public static final Code PushNotInitialized = new Code("PushNotInitialized", 368, -4000001, "PushNotInitialized");
        public static final Code PushInvalidParamLocalPush = new Code("PushInvalidParamLocalPush", 369, -4000002, "PushInvalidParamLocalPush");
        public static final Code PushInvalidParamRemotePush = new Code("PushInvalidParamRemotePush", 370, -4000003, "PushInvalidParamRemotePush");
        public static final Code PushNetworkError = new Code("PushNetworkError", 371, -4000004, "PushNetworkError");
        public static final Code PushAgeGateUnder13 = new Code("PushAgeGateUnder13", 372, -4000005, "PushAgeGateUnder13");
        public static final Code PushInvalidResponseData = new Code("PushInvalidResponseData", 373, -4000006, "PushInvalidResponseData");
        public static final Code PushServerResponseError = new Code("PushServerResponseError", 374, -4000007, "PushServerResponseError");
        public static final Code PushNeedSignIn = new Code("PushNeedSignIn", 375, -4000008, "PushNeedSignIn");
        public static final Code IAPNotInitialize = new Code("IAPNotInitialize", 376, -6000001, "IAPNotInitialize");
        public static final Code IAPAlreadyInInitialize = new Code("IAPAlreadyInInitialize", 377, -6000002, "IAPAlreadyInInitialize");
        public static final Code IAPNetworkError = new Code("IAPNetworkError", 378, -6000003, "IAPNetworkError");
        public static final Code IAPNotSupportedMarket = new Code("IAPNotSupportedMarket", 379, -6000004, "IAPNotSupportedMarket");
        public static final Code IAPNeedLogin = new Code("IAPNeedLogin", 380, -6000005, "IAPNeedLogin");
        public static final Code IAPNeedShopInitialize = new Code("IAPNeedShopInitialize", 381, -6000006, "IAPNeedShopInitialize");
        public static final Code IAPNotSupportedOSVersion = new Code("IAPNotSupportedOSVersion", 382, -6000007, "IAPNotSupportedOSVersion");
        public static final Code IAPNeedRestore = new Code("IAPNeedRestore", 383, -6000008, "IAPNeedRestore");
        public static final Code IAPNothingToRestore = new Code("IAPNothingToRestore", RendererCapabilities.MODE_SUPPORT_MASK, -6000010, "IAPNothingToRestore");
        public static final Code IAPFailRestore = new Code("IAPFailRestore", 385, -6000011, "IAPFailRestore");
        public static final Code IAPRestrictPayments = new Code("IAPRestrictPayments", 386, -6000012, "IAPRestrictPayments");
        public static final Code IAPNetworkJsonException = new Code("IAPNetworkJsonException", 387, -6000013, "IAPNetworkJsonException");
        public static final Code IAPMarketNotSupportedAPI = new Code("IAPMarketNotSupportedAPI", 388, -6000014, "IAPMarketNotSupportedAPI");
        public static final Code IAPFailMarketInitialize = new Code("IAPFailMarketInitialize", 389, -6000015, "IAPFailMarketInitialize");
        public static final Code IAPResponseError = new Code("IAPResponseError", 390, -6000016, "IAPResponseError");
        public static final Code IAPDialogActionDefault_DoExit = new Code("IAPDialogActionDefault_DoExit", 391, -6000017, "IAPDialogActionDefault_DoExit");
        public static final Code IAPDialogActionOpenURL_DoExit = new Code("IAPDialogActionOpenURL_DoExit", 392, -6000018, "IAPDialogActionOpenURL_DoExit");
        public static final Code IAPDialogActionExit_DoExit = new Code("IAPDialogActionExit_DoExit", 393, -6000019, "IAPDialogActionExit_DoExit");
        public static final Code IAPDialogActionDone = new Code("IAPDialogActionDone", 394, -6000020, "IAPDialogActionDone");
        public static final Code IAPDialogTimeover_DoExit = new Code("IAPDialogTimeover_DoExit", 395, -6000021, "IAPDialogTimeover_DoExit");
        public static final Code IAPInProgressPurchasing = new Code("IAPInProgressPurchasing", 396, -6000101, "IAPInProgressPurchasing");
        public static final Code IAPInProgressRestoring = new Code("IAPInProgressRestoring", 397, -6000102, "IAPInProgressRestoring");
        public static final Code IAPInProgressCheckPromotePurchase = new Code("IAPInProgressCheckPromotePurchase", 398, -6000103, "IAPInProgressCheckPromotePurchase");
        public static final Code IAPInProgressConnectingAppStore = new Code("IAPInProgressConnectingAppStore", 399, -6000104, "IAPInProgressConnectingAppStore");
        public static final Code IAPInProgressMarketSelection = new Code("IAPInProgressMarketSelection", 400, -6000105, "IAPInProgressMarketSelection");
        public static final Code IAPAppStoreError = new Code("IAPAppStoreError", 401, -6000201, "IAPAppStoreError");
        public static final Code IAPAppStoreResponseEmpty = new Code("IAPAppStoreResponseEmpty", 402, -6000202, "IAPAppStoreResponseEmpty");
        public static final Code IAPCannotFindGamePID = new Code("IAPCannotFindGamePID", 403, -6000301, "IAPCannotFindGamePID");
        public static final Code IAPProductNotExist = new Code("IAPProductNotExist", TTAdConstant.DEEPLINK_FALLBACK_CODE, -6000302, "IAPProductNotExist");
        public static final Code IAPEmptyMarketPID = new Code("IAPEmptyMarketPID", TTAdConstant.DEEPLINK_FALLBACK_TYPE_CODE, -6000303, "IAPEmptyMarketPID");
        public static final Code IAPFailCreateSKPayment = new Code("IAPFailCreateSKPayment", TTAdConstant.LANDING_PAGE_TYPE_CODE, -6000304, "IAPFailCreateSKPayment");
        public static final Code IAPEmptyTransaction = new Code("IAPEmptyTransaction", TTAdConstant.DOWNLOAD_APP_INFO_CODE, -6000305, "IAPEmptyTransaction");
        public static final Code IAPEmptyProduct = new Code("IAPEmptyProduct", TTAdConstant.DOWNLOAD_URL_CODE, -6000306, "IAPEmptyProduct");
        public static final Code IAPCancelPayment = new Code("IAPCancelPayment", TTAdConstant.IMAGE_LIST_CODE, -6000307, "IAPCancelPayment");
        public static final Code IAPFailPayment = new Code("IAPFailPayment", TTAdConstant.IMAGE_LIST_SIZE_CODE, -6000308, "IAPFailPayment");
        public static final Code IAPInvalidMarketPID = new Code("IAPInvalidMarketPID", TTAdConstant.IMAGE_CODE, -6000309, "IAPInvalidMarketPID");
        public static final Code IAPPurchaseParamJsonException = new Code("IAPPurchaseParamJsonException", 412, -6000310, "IAPPurchaseParamJsonException");
        public static final Code IAPShopInfoParamJsonException = new Code("IAPShopInfoParamJsonException", TTAdConstant.VIDEO_INFO_CODE, -6000311, "IAPShopInfoParamJsonException");
        public static final Code IAPBadgeParamJsonException = new Code("IAPBadgeParamJsonException", TTAdConstant.VIDEO_URL_CODE, -6000312, "IAPBadgeParamJsonException");
        public static final Code IAPInvalidParamEmptyMarketPID = new Code("IAPInvalidParamEmptyMarketPID", TTAdConstant.VIDEO_COVER_URL_CODE, -6000401, "IAPInvalidParamEmptyMarketPID");
        public static final Code IAPInvalidParamLocationCode = new Code("IAPInvalidParamLocationCode", 416, -6000402, "IAPInvalidParamLocationCode");
        public static final Code IAPBlockedUser = new Code("IAPBlockedUser", TTAdConstant.DOWNLOAD_URL_AND_PACKAGE_NAME, -6000501, "IAPBlockedUser");
        public static final Code IAPPromoCodeMatchMultiMarketPID = new Code("IAPPromoCodeMatchMultiMarketPID", 418, -6000502, "IAPPromoCodeMatchMultiMarketPID");
        public static final Code IAPPromoCodeNotMatchMarketPID = new Code("IAPPromoCodeNotMatchMarketPID", 419, -6000503, "IAPPromoCodeNotMatchMarketPID");
        public static final Code IAPPromoCodeAlreadyUsed = new Code("IAPPromoCodeAlreadyUsed", TypedValues.CycleType.TYPE_EASING, -6000504, "IAPPromoCodeAlreadyUsed");
        public static final Code IAPAppleReceiptNotConnected = new Code("IAPAppleReceiptNotConnected", 421, -6000505, "IAPAppleReceiptNotConnected");
        public static final Code IAPServerDefaultError = new Code("IAPServerDefaultError", TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, -6000506, "IAPServerDefaultError");
        public static final Code IAPInitializeMarketListIsEmpty = new Code("IAPInitializeMarketListIsEmpty", TypedValues.CycleType.TYPE_WAVE_PERIOD, -6000601, "IAPInitializeMarketListIsEmpty");
        public static final Code IAPInitializeMarketURLISEmpty = new Code("IAPInitializeMarketURLISEmpty", TypedValues.CycleType.TYPE_WAVE_OFFSET, -6000602, "IAPInitializeMarketURLISEmpty");
        public static final Code IAPEmptyMarketURL = new Code("IAPEmptyMarketURL", TypedValues.CycleType.TYPE_WAVE_PHASE, -6000603, "IAPEmptyMarketURL");
        public static final Code IAPNotSelectedMarket = new Code("IAPNotSelectedMarket", 426, -6000604, "IAPNotSelectedMarket");
        public static final Code IAPPlayStoreLaunchPurchaseFlowException = new Code("IAPPlayStoreLaunchPurchaseFlowException", 427, -6000701, "IAPPlayStoreLaunchPurchaseFlowException");
        public static final Code IAPPlayStoreSetupFail = new Code("IAPPlayStoreSetupFail", 428, -6000702, "IAPPlayStoreSetupFail");
        public static final Code IAPPlayStoreQueryInventoryFail = new Code("IAPPlayStoreQueryInventoryFail", CommonGatewayClient.CODE_TOO_MANY_REQUESTS, -6000703, "IAPPlayStoreQueryInventoryFail");
        public static final Code IAPPlayStorePending = new Code("IAPPlayStorePending", 430, -6000704, "IAPPlayStorePending");
        public static final Code IAPOneStoreProductListEmpty = new Code("IAPOneStoreProductListEmpty", 431, -6000801, "IAPOneStoreProductListEmpty");
        public static final Code IAPOneStoreProductNetworkError = new Code("IAPOneStoreProductNetworkError", 432, -6000802, "IAPOneStoreProductNetworkError");
        public static final Code IAPOneStoreProductInfoError = new Code("IAPOneStoreProductInfoError", 433, -6000803, "IAPOneStoreProductInfoError");
        public static final Code IAPOneStoreInvalidRequestID = new Code("IAPOneStoreInvalidRequestID", 434, -6000804, "IAPOneStoreInvalidRequestID");
        public static final Code IAPOneStorePurchaseError = new Code("IAPOneStorePurchaseError", 435, -6000805, "IAPOneStorePurchaseError");
        public static final Code IAPOneStoreNetworkNullError = new Code("IAPOneStoreNetworkNullError", 436, -6000806, "IAPOneStoreNetworkNullError");
        public static final Code IAPOneStoreNetworkInvalidError = new Code("IAPOneStoreNetworkInvalidError", 437, -6000807, "IAPOneStoreNetworkInvalidError");
        public static final Code IAPLebiInitializeNetworkError = new Code("IAPLebiInitializeNetworkError", 438, -6000901, "IAPLebiInitializeNetworkError");
        public static final Code IAPLebiInitializeJsonException = new Code("IAPLebiInitializeJsonException", 439, -6000902, "IAPLebiInitializeJsonException");
        public static final Code IAPLebiPurchaseNetworkError = new Code("IAPLebiPurchaseNetworkError", 440, -6000903, "IAPLebiPurchaseNetworkError");
        public static final Code IAPLebiPurchaseJsonException = new Code("IAPLebiPurchaseJsonException", 441, -6000904, "IAPLebiPurchaseJsonException");
        public static final Code IAPLebiVerifyOrderNetworkError = new Code("IAPLebiVerifyOrderNetworkError", 442, -6000905, "IAPLebiVerifyOrderNetworkError");
        public static final Code IAPLebiVerifyOrderJsonException = new Code("IAPLebiVerifyOrderJsonException", 443, -6000906, "IAPLebiVerifyOrderJsonException");
        public static final Code IAPLebiBalanceNetworkError = new Code("IAPLebiBalanceNetworkError", 444, -6000907, "IAPLebiBalanceNetworkError");
        public static final Code IAPLebiBalanceParamJsonException = new Code("IAPLebiBalanceParamJsonException", 445, -6000908, "IAPLebiBalanceParamJsonException");
        public static final Code IAPLebiPostException = new Code("IAPLebiPostException", 446, -6000909, "IAPLebiPostException");
        public static final Code IAPLebiInternalRequestException = new Code("IAPLebiInternalRequestException", 447, -6000910, "IAPLebiInternalRequestException");
        public static final Code IAPLebiRestoreNetworkError = new Code("IAPLebiRestoreNetworkError", 448, -6000911, "IAPLebiRestoreNetworkError");
        public static final Code IAPV4NotInitialize = new Code("IAPV4NotInitialize", 449, -6100001, "IAPV4NotInitialize");
        public static final Code IAPV4NetworkError = new Code("IAPV4NetworkError", 450, -6100002, "IAPV4NetworkError");
        public static final Code IAPV4NotSupportedMarket = new Code("IAPV4NotSupportedMarket", 451, -6100003, "IAPV4NotSupportedMarket");
        public static final Code IAPV4NeedSignIn = new Code("IAPV4NeedSignIn", 452, -6100004, "IAPV4NeedSignIn");
        public static final Code IAPV4NeedMarketConnect = new Code("IAPV4NeedMarketConnect", 453, -6100005, "IAPV4NeedMarketConnect");
        public static final Code IAPV4NeedRestore = new Code("IAPV4NeedRestore", 454, -6100006, "IAPV4NeedRestore");
        public static final Code IAPV4NothingToRestore = new Code("IAPV4NothingToRestore", 455, -6100007, "IAPV4NothingToRestore");
        public static final Code IAPV4FailToRestore = new Code("IAPV4FailToRestore", 456, -6100008, "IAPV4FailToRestore");
        public static final Code IAPV4RestrictPayments = new Code("IAPV4RestrictPayments", 457, -6100009, "IAPV4RestrictPayments");
        public static final Code IAPV4FailMarketConnect = new Code("IAPV4FailMarketConnect", FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, -6100010, "IAPV4FailMarketConnect");
        public static final Code IAPV4ResponseError = new Code("IAPV4ResponseError", 459, -6100011, "IAPV4ResponseError");
        public static final Code IAPV4MarketNotSupportedAPI = new Code("IAPV4MarketNotSupportedAPI", 460, -6100012, "IAPV4MarketNotSupportedAPI");
        public static final Code IAPV4PendingPurchase = new Code("IAPV4PendingPurchase", 461, -6100013, "IAPV4PendingPurchase");
        public static final Code IAPV4InProgressMarketConnect = new Code("IAPV4InProgressMarketConnect", 462, -6100101, "IAPV4InProgressMarketConnect");
        public static final Code IAPV4InProgressPurchasing = new Code("IAPV4InProgressPurchasing", 463, -6100102, "IAPV4InProgressPurchasing");
        public static final Code IAPV4InProgressRestoring = new Code("IAPV4InProgressRestoring", 464, -6100103, "IAPV4InProgressRestoring");
        public static final Code IAPV4InProgressCheckPromote = new Code("IAPV4InProgressCheckPromote", 465, -6100104, "IAPV4InProgressCheckPromote");
        public static final Code IAPV4InProgressConnectAppStore = new Code("IAPV4InProgressConnectAppStore", 466, -6100105, "IAPV4InProgressConnectAppStore");
        public static final Code IAPV4InProgressMarketSelect = new Code("IAPV4InProgressMarketSelect", 467, -6100106, "IAPV4InProgressMarketSelect");
        public static final Code IAPV4AppStoreError = new Code("IAPV4AppStoreError", 468, -6100201, "IAPV4AppStoreError");
        public static final Code IAPV4AppStoreResponseEmpty = new Code("IAPV4AppStoreResponseEmpty", 469, -6100202, "IAPV4AppStoreResponseEmpty");
        public static final Code IAPV4ProductNotExsitInAppStore = new Code("IAPV4ProductNotExsitInAppStore", 470, -6100203, "IAPV4ProductNotExsitInAppStore");
        public static final Code IAPV4FinishMarketPidEmpty = new Code("IAPV4FinishMarketPidEmpty", 471, -6100301, "IAPV4FinishMarketPidEmpty");
        public static final Code IAPV4PromoteMarketPidEmpty = new Code("IAPV4PromoteMarketPidEmpty", 472, -6100302, "IAPV4PromoteMarketPidEmpty");
        public static final Code IAPV4FailCreateSKPayment = new Code("IAPV4FailCreateSKPayment", 473, -6100303, "IAPV4FailCreateSKPayment");
        public static final Code IAPV4FailToConvertNSSet = new Code("IAPV4FailToConvertNSSet", 474, -6100304, "IAPV4FailToConvertNSSet");
        public static final Code IAPV4InvalidLogType = new Code("IAPV4InvalidLogType", 475, -6100305, "IAPV4InvalidLogType");
        public static final Code IAPV4ProductNotExist = new Code("IAPV4ProductNotExist", 476, -6100306, "IAPV4ProductNotExist");
        public static final Code IAPV4RequestProductJsonException = new Code("IAPV4RequestProductJsonException", 477, -6100307, "IAPV4RequestProductJsonException");
        public static final Code IAPV4PurchaseParamJsonException = new Code("IAPV4PurchaseParamJsonException", 478, -6100308, "IAPV4PurchaseParamJsonException");
        public static final Code IAPV4RequestMarketJsonException = new Code("IAPV4RequestMarketJsonException", 479, -6100309, "IAPV4RequestMarketJsonException");
        public static final Code IAPV4ProductInfoJsonException = new Code("IAPV4ProductInfoJsonException", 480, -6100310, "IAPV4ProductInfoJsonException");
        public static final Code IAPV4CancelPayment = new Code("IAPV4CancelPayment", 481, -6100311, "IAPV4CancelPayment");
        public static final Code IAPV4FailPayment = new Code("IAPV4FailPayment", 482, -6100312, "IAPV4FailPayment");
        public static final Code IAPV4EmptyParamMarketPID = new Code("IAPV4EmptyParamMarketPID", 483, -6100401, "IAPV4EmptyParamMarketPID");
        public static final Code IAPV4EmptyMarketList = new Code("IAPV4EmptyMarketList", 484, -6100501, "IAPV4EmptyMarketList");
        public static final Code IAPV4EmptyMarketURL = new Code("IAPV4EmptyMarketURL", 485, -6100502, "IAPV4EmptyMarketURL");
        public static final Code IAPV4MarketPidListEmptyInIAPServer = new Code("IAPV4MarketPidListEmptyInIAPServer", 486, -6100503, "IAPV4MarketPidListEmptyInIAPServer");
        public static final Code IAPV4EmptyProductList = new Code("IAPV4EmptyProductList", 487, -6100504, "IAPV4EmptyProductList");
        public static final Code IAPV4ProductNotExistInIAPServer = new Code("IAPV4ProductNotExistInIAPServer", 488, -6100505, "IAPV4ProductNotExistInIAPServer");
        public static final Code IAPV4PlayStoreLaunchPurchaseFlowException = new Code("IAPV4PlayStoreLaunchPurchaseFlowException", 489, -6100701, "IAPV4PlayStoreLaunchPurchaseFlowException");
        public static final Code IAPV4PlayStoreSetupFail = new Code("IAPV4PlayStoreSetupFail", 490, -6100702, "IAPV4PlayStoreSetupFail");
        public static final Code IAPV4PlayStoreQueryInventoryFail = new Code("IAPV4PlayStoreQueryInventoryFail", 491, -6100703, "IAPV4PlayStoreQueryInventoryFail");
        public static final Code IAPV4PlayStoreFinishFail = new Code("IAPV4PlayStoreFinishFail", 492, -6100704, "IAPV4PlayStoreFinishFail");
        public static final Code IAPV4PlayStorePending = new Code("IAPV4PlayStorePending", FacebookRequestErrorClassification.ESC_APP_INACTIVE, -6100705, "IAPV4PlayStorePending");
        public static final Code IAPV4OneStoreV5RemoteException = new Code("IAPV4OneStoreV5RemoteException", 494, -6100801, "IAPV4OneStoreV5RemoteException");
        public static final Code IAPV4OneStoreV5SecurityException = new Code("IAPV4OneStoreV5SecurityException", 495, -6100802, "IAPV4OneStoreV5SecurityException");
        public static final Code IAPV4OneStoreV5NeedUpdateException = new Code("IAPV4OneStoreV5NeedUpdateException", 496, -6100803, "IAPV4OneStoreV5NeedUpdateException");
        public static final Code IAPV4OneStoreCancelPayment = new Code("IAPV4OneStoreCancelPayment", 497, -6100804, "IAPV4OneStoreCancelPayment");
        public static final Code IAPV4OneStoreNetworkError = new Code("IAPV4OneStoreNetworkError", 498, -6100805, "IAPV4OneStoreNetworkError");
        public static final Code IAPV4OneStoreResponseError = new Code("IAPV4OneStoreResponseError", 499, -6100806, "IAPV4OneStoreResponseError");
        public static final Code IAPV4OneStoreProductNotExist = new Code("IAPV4OneStoreProductNotExist", 500, -6100807, "IAPV4OneStoreProductNotExist");
        public static final Code IAPV4OneStoreFailPayment = new Code("IAPV4OneStoreFailPayment", 501, -6100808, "IAPV4OneStoreFailPayment");
        public static final Code IAPV4OneStoreError = new Code("IAPV4OneStoreError", 502, -6100809, "IAPV4OneStoreError");
        public static final Code IAPV4OneStoreNeedRestore = new Code("IAPV4OneStoreNeedRestore", 503, -6100810, "IAPV4OneStoreNeedRestore");
        public static final Code IAPV4OneStoreNothingToRestore = new Code("IAPV4OneStoreNothingToRestore", 504, -6100811, "IAPV4OneStoreNothingToRestore");
        public static final Code IAPV4OneStoreUnablePayment = new Code("IAPV4OneStoreUnablePayment", 505, -6100812, "IAPV4OneStoreUnablePayment");
        public static final Code IAPV4OneStoreNeedSignIn = new Code("IAPV4OneStoreNeedSignIn", 506, -6100813, "IAPV4OneStoreNeedSignIn");
        public static final Code IAPV4OneStoreException = new Code("IAPV4OneStoreException", 507, -6100814, "IAPV4OneStoreException");
        public static final Code IAPV4OneStoreInvalidResponseData = new Code("IAPV4OneStoreInvalidResponseData", TypedValues.PositionType.TYPE_CURVE_FIT, -6100815, "IAPV4OneStoreInvalidResponseData");
        public static final Code IAPV4OneStoreInvalidParam = new Code("IAPV4OneStoreInvalidParam", 509, -6100816, "IAPV4OneStoreInvalidParam");
        public static final Code IAPV4OneStoreFinishFail = new Code("IAPV4OneStoreFinishFail", TypedValues.PositionType.TYPE_POSITION_TYPE, -6100817, "IAPV4OneStoreFinishFail");
        public static final Code IAPV4OneStoreRefund = new Code("IAPV4OneStoreRefund", FrameMetricsAggregator.EVERY_DURATION, -6100818, "IAPV4OneStoreRefund");
        public static final Code IAPV4LebiInitializeNetworkError = new Code("IAPV4LebiInitializeNetworkError", 512, -6100901, "IAPV4LebiInitializeNetworkError");
        public static final Code IAPV4LebiInitializeJsonException = new Code("IAPV4LebiInitializeJsonException", InputDeviceCompat.SOURCE_DPAD, -6100902, "IAPV4LebiInitializeJsonException");
        public static final Code IAPV4LebiPurchaseNetworkError = new Code("IAPV4LebiPurchaseNetworkError", 514, -6100903, "IAPV4LebiPurchaseNetworkError");
        public static final Code IAPV4LebiPurchaseJsonException = new Code("IAPV4LebiPurchaseJsonException", 515, -6100904, "IAPV4LebiPurchaseJsonException");
        public static final Code IAPV4LebiVerifyOrderNetworkError = new Code("IAPV4LebiVerifyOrderNetworkError", 516, -6100905, "IAPV4LebiVerifyOrderNetworkError");
        public static final Code IAPV4LebiVerifyOrderJsonException = new Code("IAPV4LebiVerifyOrderJsonException", 517, -6100906, "IAPV4LebiVerifyOrderJsonException");
        public static final Code IAPV4LebiBalanceNetworkError = new Code("IAPV4LebiBalanceNetworkError", 518, -6100907, "IAPV4LebiBalanceNetworkError");
        public static final Code IAPV4LebiBalanceParamJsonException = new Code("IAPV4LebiBalanceParamJsonException", 519, -6100908, "IAPV4LebiBalanceParamJsonException");
        public static final Code IAPV4LebiPostException = new Code("IAPV4LebiPostException", 520, -6100909, "IAPV4LebiPostException");
        public static final Code IAPV4LebiInternalRequestException = new Code("IAPV4LebiInternalRequestException", 521, -6100910, "IAPV4LebiInternalRequestException");
        public static final Code IAPV4LebiRestoreNetworkError = new Code("IAPV4LebiRestoreNetworkError", 522, -6100911, "IAPV4LebiRestoreNetworkError");
        public static final Code IAPV4LebiCancel = new Code("IAPV4LebiCancel", 523, -6100912, "IAPV4LebiCancel");
        public static final Code IAPV4LebiFinishFail = new Code("IAPV4LebiFinishFail", 524, -6100913, "IAPV4LebiFinishFail");
        public static final Code IAPV4CancelMarketSelect = new Code("IAPV4CancelMarketSelect", 525, -6100914, "IAPV4CancelMarketSelect");
        public static final Code IAPV4ServerResponseError = new Code("IAPV4ServerResponseError", 526, -6100915, "IAPV4ServerResponseError");
        public static final Code IAPV4HiveStoreSuccess = new Code("IAPV4HiveStoreSuccess", 527, -6110000, "IAPV4HiveStoreSuccess");
        public static final Code PlatformHelperOSNotSupported = new Code("PlatformHelperOSNotSupported", 528, -7000001, "PlatformHelperOSNotSupported");
        public static final Code PlatformHelperOSVersionNotSupported = new Code("PlatformHelperOSVersionNotSupported", 529, -7000002, "PlatformHelperOSVersionNotSupported");
        public static final Code PlatformHelperEmptyPermissions = new Code("PlatformHelperEmptyPermissions", 530, -7000003, "PlatformHelperEmptyPermissions");
        public static final Code PlatformHelperNotSupported = new Code("PlatformHelperNotSupported", 531, -7000004, "PlatformHelperNotSupported");
        public static final Code PlatformHelperInvalidParam = new Code("PlatformHelperInvalidParam", 532, -7000005, "PlatformHelperInvalidParam");
        public static final Code DataStoreNotExistKey = new Code("DataStoreNotExistKey", 533, -8000001, "DataStoreNotExistKey");
        public static final Code DataStoreNotExistColumn = new Code("DataStoreNotExistColumn", 534, -8000002, "DataStoreNotExistColumn");
        public static final Code DataStoreNotExistPublicKey = new Code("DataStoreNotExistPublicKey", 535, -8000003, "DataStoreNotExistPublicKey");
        public static final Code DataStoreNotInitialized = new Code("DataStoreNotInitialized", 536, -8000004, "DataStoreNotInitialized");
        public static final Code DataStoreNeedSignIn = new Code("DataStoreNeedSignIn", 537, -8000005, "DataStoreNeedSignIn");
        public static final Code DataStoreDisabled = new Code("DataStoreDisabled", 538, -8000006, "DataStoreDisabled");
        public static final Code DataStoreResponseError = new Code("DataStoreResponseError", 539, -8000007, "DataStoreResponseError");
        public static final Code DataStoreInvalidParam = new Code("DataStoreInvalidParam", 540, -8000008, "DataStoreInvalidParam");
        public static final Code DataStoreGameIsBeingInspected = new Code("DataStoreGameIsBeingInspected", 541, -8000009, "DataStoreGameIsBeingInspected");
        public static final Code AnalyticsConsentModeCanceled = new Code("AnalyticsConsentModeCanceled", 542, -9000001, "AnalyticsConsentModeCanceled");
        public static final Code MatchMakingNotInitialized = new Code("MatchMakingNotInitialized", 543, -10000001, "MatchMakingNotInitialized");
        public static final Code MatchMakingNeedSignIn = new Code("MatchMakingNeedSignIn", 544, -10000002, "MatchMakingNeedSignIn");
        public static final Code MatchMakingResponseError = new Code("MatchMakingResponseError", 545, -10000003, "MatchMakingResponseError");
        public static final Code ChatNotConnected = new Code("ChatNotConnected", 546, -11000001, "ChatNotConnected");
        public static final Code ChatNeedSignIn = new Code("ChatNeedSignIn", 547, -11000002, "ChatNeedSignIn");
        public static final Code ChatInvalidParam = new Code("ChatInvalidParam", 548, -11000003, "ChatInvalidParam");
        public static final Code ChatResponseError = new Code("ChatResponseError", 549, -11000004, "ChatResponseError");

        private static final /* synthetic */ Code[] $values() {
            return new Code[]{Success, RealNameVerification, RefundUser, CommonHTTPConnectionException, CommonHTTPConnectionOpenException, CommonHTTPContentEncodingNotSupported, CommonHTTPDecryptionFailed, CommonHTTPResponseException, CommonHTTPInvalidBody, CommonHTTPInvalidJSON, CommonHTTPInvalidURLRequest, CommonHTTPInvalidURL, CommonHTTPGzipDecodeFailed, CommonHTTPNetworkError, CommonLibraryMissing, CommonNotSupported, CommonInProgress, TestError, TestWithNSError, TestWithNSString, TestWithNSDictionary, CommonUnknown, AuthNotInitialized, AuthInvalidServerResponse, AuthServerResponseNotSuccessful, AuthInvalidUser, AuthUserCanceled, AuthInProgressLoginLogout, AuthInvalidSelectedAccountURL, AuthInvalidSelectedVID, AuthOnRunningV4, AuthInvalidConfigurationXml, AuthInvalidParamLoginType, AuthInvalidParamVID, AuthInvalidParamSessionKey, AuthInvalidGuestSession, AuthUserInBlacklist, AuthInvalidAccountSession, AuthJsonException, AuthCanceled, AuthDialogAlreadyUsing, AuthNetworkErrorShowLoginSelection, AuthNetworkErrorCheckMaintenance, AuthResponseFailCheckMaintenance, AuthResponseFailMaintenanceDialog, AuthNetworkErrorProcessLoginType, AuthNetworkErrorGuestLogin, AuthHIVESocialLoginCancelled, AuthNetworkErrorLoginCenterLogin, AuthNetworkErrorRequestUpdate, AuthNetworkErrorRequestAdultConfirm, AuthInvalidParamVIDList, AuthAgreementFail_DoExit, AuthMaintenanceActionDefault_DoExit, AuthMaintenanceActionOpenURL_DoExit, AuthMaintenanceActionExit_DoExit, AuthMaintenanceActionDone, AuthMaintenanceTimeover_DoExit, AuthUserInBlacklistActionDefault_DoExit, AuthUserInBlacklistActionOpenURL_DoExit, AuthUserInBlacklistActionExit_DoExit, AuthUserInBlacklistActionDone, AuthUserInBlacklistTimeover_DoExit, AuthInProgressInitialize, AuthSkipPermissionView, AuthInProgressRequestPermissionViewData, AuthNetworkErrorRequestPermissionViewData, AuthProviderMissingKey, AuthResponseFailLogoutOnlyPGSConnectedUser, AuthNetworkErrorLoginCenterSignOut, AuthV4InvalidServerResponse, AuthV4OnRunningV1, AuthV4InProgressSignIn, AuthV4InvalidConfigurationXml, AuthV4InvalidSavedPlayerInfo, AuthV4AlreadyAuthorized, AuthV4ConflictPlayer, AuthV4UserInBlacklist, AuthV4InvalidSession, AuthV4ConflictPlayerHandlingFail, AuthV4InvalidParamDid, AuthV4NotInitialized, AuthV4SessionExist, AuthV4SessionNotExist, AuthV4InvalidProviderType, AuthV4SigninFirst, AuthV4ProviderAlreadyConnected, AuthV4ProviderAlreadyDisconnected, AuthV4InvalidParamSelectedPlayerid, AuthV4InvalidConflictInfo, AuthV4InvalidPlayeridList, AuthV4JsonException, AuthV4InvalidSigninSelection, AuthV4NotSupportedProviderType, AuthV4WebviewDialogError, AuthV4InProgressAuthDialog, AuthV4InvalidParamViewID, AuthV4InvalidParamPlayerID, AuthV4NetworkErrorSigninGuest, AuthV4ResponseFailProviderUserID, AuthV4ResponseFailSelectedPlayerID, AuthV4CancelDialog, AuthV4ResponseFailSocialDialog, AuthV4ProfileNetworkError, AuthV4ProfileResponseFail, AuthV4MembershipNetworkError, AuthV4MembershipResponseFail, AuthV4ResponseFailSigninProvider, AuthV4ResponseFailCheckProvider, AuthV4ResponseFailGetFriendList, AuthV4ResponseFailSigninGuest, AuthV4InProgressConnect, AuthV4InProgressShowLeaderboard, AuthV4InProgressShowAchievements, AuthV4PlayerChange, AuthV4HelperImplifiedLoginFail, AuthV4PlayerResolved, AuthV4AgreementFail_DoExit, AuthV4AgreementFailWithWebviewError_DoExit, AuthV4MaintenanceActionDefault_DoExit, AuthV4MaintenanceActionOpenURL_DoExit, AuthV4MaintenanceActionExit_DoExit, AuthV4MaintenanceActionDone, AuthV4MaintenanceTimeover_DoExit, AuthV4NetworkError, AuthV4InvalidResponseData, AuthV4ServerResponseError, AuthV4NeedSignIn, AuthV4InProgress, AuthV4InvalidParam, AuthV4SkipPermissionView, AuthV4InvalidCertification, AuthV4LastProviderCantDisconnect, AuthV4ServiceShutdown, AuthV4SignOutNotAllowGuestLogout, AuthV4SessionProcessingFail, AgeLimit, AuthV4ProviderLoginError, AuthV4ProviderLogoutError, AuthV4ProviderNotSupportGetFriends, AuthV4ProviderLoginCancel, AuthV4ProviderMissingKey, AuthV4ProviderNotSupportedMyInquiry, AuthV4FacebookUserCanceled, AuthV4FacebookResponseFailGetFriends, AuthV4FacebookNetworkErrorUploadProfile, AuthV4FacebookResponseFailUploadProfile, AuthV4FacebookResponseError, AuthV4FacebookInvalidResponseData, AuthV4FacebookNetworkError, AuthV4FacebookCancel, AuthV4GoogleResponseFailLogin, AuthV4GoogleResponseFailLogout, AuthV4GoogleNetworkErrorUploadProfile, AuthV4GoogleResponseFailUploadProfile, AuthV4GoogleResponseFailShowAchievements, AuthV4GoogleResponseFailShowLeaderboards, AuthV4GoogleNotSupported, AuthV4GoogleLoginCancel, AuthV4GoogleNetworkError, AuthV4GoogleLogout, AuthV4GoogleResponseFailAchievementsReveal, AuthV4GoogleResponseFailAchievementsUnlock, AuthV4GoogleResponseFailAchievementsIncrement, AuthV4GoogleResponseFailLeaderboardsSubmitScore, AuthV4GoogleNeedSignIn, AuthV4GoogleNeedSettingOption, AuthV4GoogleResponseFailPGSGetServerAccessToken, AuthV4GoogleResponseFailPGSGetPlayerId, AuthV4GoogleObjectNotReady, AuthV4AppleLoginCancel, AuthV4AppleResponseFailLogin, AuthV4AppleTimeOut, AuthV4AppleResponseFailReportScore, AuthV4AppleInProgressGameCenterVC, AuthV4AppleResponseFailLoadAchievements, AuthV4AppleResponseFailReportAchievements, AuthV4AppleResponseFailResetAchievements, AuthV4AppleNotSupported, AuthV4AppleInProgress, AuthV4AppleResponseError, AuthV4AppleCancel, AuthV4VKResponseFailLogin, AuthV4VKInvalidParamSDK, AuthV4VKNotInitialized, AuthV4VKCancelLogin, AuthV4VKInvalidSession, AuthV4VKResponseFailGetFriends, AuthV4VKResponseFailLogout, AuthV4VKResponseFailUploadProfile, AuthV4VKNetworkErrorUploadProfile, AuthV4VKInProgress, AuthV4VKResponseError, AuthV4VKNetworkError, AuthV4VKInvalidParam, AuthV4VKCancel, AuthV4VKTokenResponseError, AuthV4WechatInProgressLoginLogout, AuthV4WechatResponseFailLogin, AuthV4WechatNotSupportedRequest, AuthV4WechatResponseFailUserInfo, AuthV4WechatNetworkErrorUserInfo, AuthV4WechatNetworkError, AuthV4WechatResponseFail, AuthV4WechatNetworkErrorLogin, AuthV4WechatLoginCancel, AuthV4WechatInProgress, AuthV4WechatResponseError, AuthV4WechatInvalidResponseData, AuthV4WechatInvalidAppKey, AuthV4HIVEDialogCancel, AuthV4HIVENetworkErrorUploadProfile, AuthV4HIVEResponseFailUploadProfile, AuthV4HIVEInProgress, AuthV4HIVEResponseError, AuthV4HIVENetworkError, AuthV4HIVEInvalidParam, AuthV4HIVECancel, AuthV4QQInProgressLoginLogout, AuthV4QQResponseFailLogin, AuthV4QQCancelLogin, AuthV4QQNetworkError, AuthV4QQNetworkErrorUploadProfile, AuthV4QQResponseFailUploadProfile, AuthV4QQCancelUploadProfile, AuthV4QQResponseFailLogout, AuthV4QQNotInitialized, AuthV4QQInProgress, AuthV4QQResponseError, AuthV4QQInvalidResponseData, AuthV4QQInvalidParam, AuthV4QQCancel, AuthV4LineInvalidParam, AuthV4LineCancel, AuthV4LineResponseError, AuthV4LineNetworkError, AuthV4TwitterResponseError, AuthV4TwitterInvalidParam, AuthV4WeverseInProgressLoginLogout, AuthV4WeverseResponseFailLogin, AuthV4WeverseNotSupported, AuthV4WeverseNetworkError, AuthV4WeverseLoginCancel, AuthV4WeverseResponseError, AuthV4NotRegisteredDevice, AuthV4HuaweiNotInitialized, AuthV4HuaweiInProgress, AuthV4HuaweiInvalidParam, AuthV4HuaweiLoginCancel, AuthV4HuaweiNetworkError, AuthV4HuaweiResponseError, SocialResponseFailDismissDialog, SocialCancelDismissDialog, SocialCancelConnect, SocialResponseFailConnect, SocialCancelGetPictureFromGallery, SocialResponseFailGetPictureFromGallery, SocialCancelSharePhoto, SocialResponseFailSharePhoto, SocialInvalidParam, SocialProviderNotInitialized, SocialNeedSignIn, SocialGoogleNotInitialized, SocialGoogleResponseFailGetProfile, SocialGoogleInProgressConnect, SocialGoogleResponseFailConnect, SocialGoogleCancelGetProfile, SocialGoogleCancelConnect, SocialGoogleNetworkErrorUpdateServerFlag, SocialGoogleResponseFailUpdateServerFlag, SocialGoogleCancelGetFriends, SocialFacebookNotInitialized, SocialFacebookResponseFailGetProfile, SocialFacebookCancelGetProfile, SocialFacebookResponseFailGetFriends, SocialFacebookCancelGetFriends, SocialFacebookResponseFailSendMessage, SocialFacebookCancelSendMessage, SocialFacebookMessageDialogShowFail, SocialFacebookResponseFailShowInvitation, SocialFacebookCancelShowInvitation, SocialFacebookInvalidParamPost, SocialFacebookPostDialogShowFail, SocialFacebookShareFail, SocialFacebookShareCancelled, SocialFacebookSendInvitationFail, SocialFacebookSendInvitationCancelled, SocialFacebookCancelPost, SocialFacebookResponseFailPost, SocialFacebookOperationException, SocialFacebookServiceException, SocialFacebookException, SocialHIVENotInitialized, SocialHIVENetworkErrorGetMyProfile, SocialHIVEInvalidParamSetMyProfile, SocialHIVENetworkErrorSetMyProfile, SocialHIVENetworkErrorGetFriends, SocialHIVEInvalidSession, SocialHIVEInvalidParamVID, SocialHIVENetworkErrorGetVIDByUIDList, SocialHIVENetworkErrorGetUIDByVIDList, SocialHIVEInvalidParamContentSendMessage, SocialHIVENetworkErrorSendMessage, SocialHIVEInvalidParamReceiptSendMessage, SocialHIVEInvalidParamUID, SocialHIVEInProgressSocialDialog, SocialHIVESocialDialogClosed, SocialHIVENetworkErrorGetBadgeInfo, SocialHIVEResponseFailGetMyProfile, SocialHIVEResponseFailSetMyProfile, SocialHIVEResponseFailGetFriends, SocialHIVEResponseFailGetVID, SocialHIVEResponseFailInvalidVIDList, SocialHIVEResponseFailGetUID, SocialHIVEResponseFailInvalidUIDList, SocialHIVEResponseFailSendMessage, SocialHIVEResponseFailGetBadgeInfo, SocialHIVEResponseFailDialogWebView, SocialHIVEResponseFailSocialDialog, SocialHIVEInvalidParamFriendType, SocialHIVEResponseFailGetProfiles, SocialHIVEInvalidParamGetProfiles, SocialHIVEResponseFail, SocialHIVEInvalidParamSendMessage, SocialHIVEInvalidParamSendInvitationMessage, SocialHIVEResponseFailGetPictureFromGallery, SocialHIVEResponseFailGetPictureFromCamera, SocialHIVENetworkErrorSendInvitationMessage, SocialHIVENetworkErrorDeviceRegistered, SocialHIVENetworkErrorGuestKey, SocialHIVENetworkErrorGuestGenerate, SocialHIVENetworkErrorGuestCreate, SocialHIVENetworkErrorGuestLogin, SocialHIVENetworkErrorGuestAuth, SocialHIVENetworkErrorSaveDataUpload, SocialHIVENetworkErrorSaveDataDownload, SocialHIVENetworkErrorSaveDataDelete, SocialHIVENetworkErrorUploadImage, SocialHIVENetworkErrorWallWrite, SocialHIVENetworkErrorFriendsRejectRequest, SocialHIVENetworkErrorFriendsRequest, SocialHIVENetworkErrorFriendsReceiveList, SocialHIVENetworkErrorGuestStatusSaveData, SocialHIVENetworkErrorUserMeNotification, SocialHIVESocialRequestError, SocialHIVENetworkErrorMessageNotiCount, SocialHIVEResponseFailGetPictureFromChooser, PromotionNotInitialized, PromotionAlreadyShowing, PromotionNetworkErrorShowCustomContents, PromotionNetworkErrorShowOfferwall, PromotionShowDialogFail, PromotionResponseFailGetViewInfo, PromotionNetworkError, PromotionServerResponseError, PromotionInvalidResponseData, PromotionShareFailed, UserEngagementResponseFail, UserEngagementAlreadySetReady, UserEngagementHandlerNotRegistered, UserEngagementNotLogined, UserEngagementEmptyCouponId, UserEngagementEmptyMarketPid, UserEngagementListenerNotRegistered, PromotionStartPlayback, PromotionFinishPlayback, PromotionYTPlayerError, PromotionCancelPlayback, PushNotInitialized, PushInvalidParamLocalPush, PushInvalidParamRemotePush, PushNetworkError, PushAgeGateUnder13, PushInvalidResponseData, PushServerResponseError, PushNeedSignIn, IAPNotInitialize, IAPAlreadyInInitialize, IAPNetworkError, IAPNotSupportedMarket, IAPNeedLogin, IAPNeedShopInitialize, IAPNotSupportedOSVersion, IAPNeedRestore, IAPNothingToRestore, IAPFailRestore, IAPRestrictPayments, IAPNetworkJsonException, IAPMarketNotSupportedAPI, IAPFailMarketInitialize, IAPResponseError, IAPDialogActionDefault_DoExit, IAPDialogActionOpenURL_DoExit, IAPDialogActionExit_DoExit, IAPDialogActionDone, IAPDialogTimeover_DoExit, IAPInProgressPurchasing, IAPInProgressRestoring, IAPInProgressCheckPromotePurchase, IAPInProgressConnectingAppStore, IAPInProgressMarketSelection, IAPAppStoreError, IAPAppStoreResponseEmpty, IAPCannotFindGamePID, IAPProductNotExist, IAPEmptyMarketPID, IAPFailCreateSKPayment, IAPEmptyTransaction, IAPEmptyProduct, IAPCancelPayment, IAPFailPayment, IAPInvalidMarketPID, IAPPurchaseParamJsonException, IAPShopInfoParamJsonException, IAPBadgeParamJsonException, IAPInvalidParamEmptyMarketPID, IAPInvalidParamLocationCode, IAPBlockedUser, IAPPromoCodeMatchMultiMarketPID, IAPPromoCodeNotMatchMarketPID, IAPPromoCodeAlreadyUsed, IAPAppleReceiptNotConnected, IAPServerDefaultError, IAPInitializeMarketListIsEmpty, IAPInitializeMarketURLISEmpty, IAPEmptyMarketURL, IAPNotSelectedMarket, IAPPlayStoreLaunchPurchaseFlowException, IAPPlayStoreSetupFail, IAPPlayStoreQueryInventoryFail, IAPPlayStorePending, IAPOneStoreProductListEmpty, IAPOneStoreProductNetworkError, IAPOneStoreProductInfoError, IAPOneStoreInvalidRequestID, IAPOneStorePurchaseError, IAPOneStoreNetworkNullError, IAPOneStoreNetworkInvalidError, IAPLebiInitializeNetworkError, IAPLebiInitializeJsonException, IAPLebiPurchaseNetworkError, IAPLebiPurchaseJsonException, IAPLebiVerifyOrderNetworkError, IAPLebiVerifyOrderJsonException, IAPLebiBalanceNetworkError, IAPLebiBalanceParamJsonException, IAPLebiPostException, IAPLebiInternalRequestException, IAPLebiRestoreNetworkError, IAPV4NotInitialize, IAPV4NetworkError, IAPV4NotSupportedMarket, IAPV4NeedSignIn, IAPV4NeedMarketConnect, IAPV4NeedRestore, IAPV4NothingToRestore, IAPV4FailToRestore, IAPV4RestrictPayments, IAPV4FailMarketConnect, IAPV4ResponseError, IAPV4MarketNotSupportedAPI, IAPV4PendingPurchase, IAPV4InProgressMarketConnect, IAPV4InProgressPurchasing, IAPV4InProgressRestoring, IAPV4InProgressCheckPromote, IAPV4InProgressConnectAppStore, IAPV4InProgressMarketSelect, IAPV4AppStoreError, IAPV4AppStoreResponseEmpty, IAPV4ProductNotExsitInAppStore, IAPV4FinishMarketPidEmpty, IAPV4PromoteMarketPidEmpty, IAPV4FailCreateSKPayment, IAPV4FailToConvertNSSet, IAPV4InvalidLogType, IAPV4ProductNotExist, IAPV4RequestProductJsonException, IAPV4PurchaseParamJsonException, IAPV4RequestMarketJsonException, IAPV4ProductInfoJsonException, IAPV4CancelPayment, IAPV4FailPayment, IAPV4EmptyParamMarketPID, IAPV4EmptyMarketList, IAPV4EmptyMarketURL, IAPV4MarketPidListEmptyInIAPServer, IAPV4EmptyProductList, IAPV4ProductNotExistInIAPServer, IAPV4PlayStoreLaunchPurchaseFlowException, IAPV4PlayStoreSetupFail, IAPV4PlayStoreQueryInventoryFail, IAPV4PlayStoreFinishFail, IAPV4PlayStorePending, IAPV4OneStoreV5RemoteException, IAPV4OneStoreV5SecurityException, IAPV4OneStoreV5NeedUpdateException, IAPV4OneStoreCancelPayment, IAPV4OneStoreNetworkError, IAPV4OneStoreResponseError, IAPV4OneStoreProductNotExist, IAPV4OneStoreFailPayment, IAPV4OneStoreError, IAPV4OneStoreNeedRestore, IAPV4OneStoreNothingToRestore, IAPV4OneStoreUnablePayment, IAPV4OneStoreNeedSignIn, IAPV4OneStoreException, IAPV4OneStoreInvalidResponseData, IAPV4OneStoreInvalidParam, IAPV4OneStoreFinishFail, IAPV4OneStoreRefund, IAPV4LebiInitializeNetworkError, IAPV4LebiInitializeJsonException, IAPV4LebiPurchaseNetworkError, IAPV4LebiPurchaseJsonException, IAPV4LebiVerifyOrderNetworkError, IAPV4LebiVerifyOrderJsonException, IAPV4LebiBalanceNetworkError, IAPV4LebiBalanceParamJsonException, IAPV4LebiPostException, IAPV4LebiInternalRequestException, IAPV4LebiRestoreNetworkError, IAPV4LebiCancel, IAPV4LebiFinishFail, IAPV4CancelMarketSelect, IAPV4ServerResponseError, IAPV4HiveStoreSuccess, PlatformHelperOSNotSupported, PlatformHelperOSVersionNotSupported, PlatformHelperEmptyPermissions, PlatformHelperNotSupported, PlatformHelperInvalidParam, DataStoreNotExistKey, DataStoreNotExistColumn, DataStoreNotExistPublicKey, DataStoreNotInitialized, DataStoreNeedSignIn, DataStoreDisabled, DataStoreResponseError, DataStoreInvalidParam, DataStoreGameIsBeingInspected, AnalyticsConsentModeCanceled, MatchMakingNotInitialized, MatchMakingNeedSignIn, MatchMakingResponseError, ChatNotConnected, ChatNeedSignIn, ChatInvalidParam, ChatResponseError};
        }

        static {
            Code[] codeArr$values = $values();
            $VALUES = codeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(codeArr$values);
        }

        private Code(String str, int i, int i2, String str2) {
            this.value = i2;
            this.key = str2;
        }

        public static EnumEntries<Code> getEntries() {
            return $ENTRIES;
        }

        public static Code valueOf(String str) {
            return (Code) Enum.valueOf(Code.class, str);
        }

        public static Code[] values() {
            return (Code[]) $VALUES.clone();
        }

        public final String getKey() {
            return this.key;
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/hive/ResultAPI$Companion;", "", "<init>", "()V", "SUCCESS", "", "RESTORE_NOT_OWNED", "NOT_OWNED", "ITEM_DELIVERY_DELAYED", "ITEM_PENDING", "AUTHORIZED", "IAPSUCCESS", "INVALID_PARAM", "NOT_SUPPORTED", "IN_PROGRESS", "TIMEOUT", "NETWORK", "CANCELED", "NEED_INITIALIZE", "RESPONSE_FAIL", "INVALID_SESSION", "NEED_RESTORE", "CONFLICT_PLAYER", "BLACKLIST", "DEVELOPER_ERROR", "DUPLICATED_PROMOTION_CODE", "PLAYER_CHANGE", "USER_OUT", "NEED_EXIT", "UNDEFINED", com.hive.core.Configuration.HIVE_COUNTRY_DEFAULT, "isCommonError", "", "code", "Lcom/hive/ResultAPI$Code;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean isCommonError(Code code) {
            Intrinsics.checkNotNullParameter(code, "code");
            int value = code.getValue();
            return Code.CommonUnknown.getValue() < value && value < Code.Success.getValue();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/hive/ResultAPI$PeppermintErrCode;", "", "<init>", "()V", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PeppermintErrCode {
        public static final int HUB_E_AUTH_FAIL = 1300;
        public static final int HUB_E_DEVICE_DENIED = 1400;
        public static final int HUB_E_DIALOG_CLOSE = 2001;
        public static final int HUB_E_FBNOTOPEN = -100;
        public static final int HUB_E_GATEWAY_BAD_RESPONSE = 1501;
        public static final int HUB_E_GATEWAY_TIMEOUT = 1500;
        public static final int HUB_E_GUEST_API_DENIED = 1402;
        public static final int HUB_E_HIVE_USER_EXIT = 1801;
        public static final int HUB_E_INUSE = -8;
        public static final int HUB_E_INVALID = -9;
        public static final int HUB_E_INVALID_JSON = 1201;
        public static final int HUB_E_INVALID_URL = 1200;
        public static final int HUB_E_NETWORK_BAD_RESPONSE = 2101;
        public static final int HUB_E_NETWORK_TIMEOUT = 2100;
        public static final int HUB_E_NOMEMORY = -17;
        public static final int HUB_E_NOTEXIS = -28;
        public static final int HUB_E_NOTSUP = -16;
        public static final int HUB_E_NOT_CONNECT_DB = 1101;
        public static final int HUB_E_PGS_ALREADY_EXIST_SESSION = 2402;
        public static final int HUB_E_PGS_CANNOT_FOUND_CLIENT_ID = 2404;
        public static final int HUB_E_PGS_INVALID_JSON = 2403;
        public static final int HUB_E_PGS_SERVICE_NOT_AVAILABLE = 2401;
        public static final int HUB_E_PGS_SIGNIN_FAIL = 2400;
        public static final int HUB_E_SOCIAL_AUTH_CANCEL = 3000;
        public static final int HUB_E_SOCIAL_AUTH_FAIL = 2002;
        public static final int HUB_E_SOCIAL_DIALOG_CLOSE = 2004;
        public static final int HUB_E_SOCIAL_NOTSUP = -101;
        public static final int HUB_E_SOCIAL_PGS_FALSE = 0;
        public static final int HUB_E_SOCIAL_PGS_TRUE = 1;
        public static final int HUB_E_SOCIAL_REQUEST_FAIL = 2003;
        public static final int HUB_E_SSL_ERROR = 2102;
        public static final int HUB_E_SUCCESS = 0;
        public static final int HUB_E_SYSTEM_ERROR = 2000;
        public static final int HUB_E_UNKNOWN = 1100;
        public static final int HUB_E_USER_DENIED = 1401;
    }

    public ResultAPI() {
        Code code = Code.Success;
        this.code = code;
        Resource resource = Resource.INSTANCE;
        String string = resource.getString(code.getKey());
        this.errorMessageFormat = string == null ? "" : string;
        String string2 = resource.getString(code.getKey());
        this.messageFormat = string2 != null ? string2 : "";
    }

    @JvmStatic
    public static final boolean isCommonError(Code code) {
        return INSTANCE.isCommonError(code);
    }

    public final Code getCode() {
        return this.code;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(this.errorMessageFormat, Arrays.copyOf(new Object[]{this.additionalMessage}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final long getLatencyMs() {
        return this.latencyMs;
    }

    public final String getMessage() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(this.messageFormat, Arrays.copyOf(new Object[]{this.additionalMessage}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final boolean isFailure() {
        return !isSuccess();
    }

    public final boolean isSuccess() {
        return this.code.getValue() >= 0 || this.errorCode >= 0;
    }

    public final boolean needExit() {
        return this.errorCode == -17;
    }

    public final void setCode(Code code) {
        Intrinsics.checkNotNullParameter(code, "<set-?>");
        this.code = code;
    }

    public final void setErrorCode(int i) {
        this.errorCode = i;
    }

    public final void setLatencyMs(long j) {
        this.latencyMs = j;
    }

    public final void setMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.errorMessageFormat = message;
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", this.errorCode);
            jSONObject.put("code", this.code.getValue());
            jSONObject.put("errorMessage", getErrorMessage());
            jSONObject.put("message", getMessage());
            jSONObject.put("latencyMs", this.latencyMs);
            return jSONObject;
        } catch (JSONException e) {
            com.hive.core.Logger.INSTANCE.w("[ResultAPI] toJson()\ne: " + e.getMessage());
            return jSONObject;
        }
    }

    public String toString() {
        String message = getMessage();
        String strValueOf = this.code.getValue() == 0 ? ADXLogUtil.EVENT_LOAD_SUCCESS : String.valueOf(this.code.getValue());
        if (this.latencyMs == 0) {
            return "ResultAPI { code = " + this.code + '(' + strValueOf + "), msg = " + message + " }\n";
        }
        return "ResultAPI { code = " + this.code + '(' + strValueOf + "), msg = " + message + ", latency = " + this.latencyMs + " }\n";
    }

    public ResultAPI(int i, Code code) {
        Intrinsics.checkNotNullParameter(code, "code");
        Code code2 = Code.Success;
        this.code = code2;
        Resource resource = Resource.INSTANCE;
        String string = resource.getString(code2.getKey());
        this.errorMessageFormat = string == null ? "" : string;
        String string2 = resource.getString(code2.getKey());
        this.messageFormat = string2 == null ? "" : string2;
        this.errorCode = i;
        this.code = code;
        String string3 = resource.getString(code.getKey());
        this.errorMessageFormat = string3 == null ? "" : string3;
        String string4 = resource.getString(code.getKey());
        this.messageFormat = string4 != null ? string4 : "";
    }

    public ResultAPI(int i, Code code, String str) {
        Intrinsics.checkNotNullParameter(code, "code");
        Code code2 = Code.Success;
        this.code = code2;
        Resource resource = Resource.INSTANCE;
        String string = resource.getString(code2.getKey());
        this.errorMessageFormat = string == null ? "" : string;
        String string2 = resource.getString(code2.getKey());
        this.messageFormat = string2 == null ? "" : string2;
        this.errorCode = i;
        this.code = code;
        String string3 = resource.getString(code.getKey());
        this.errorMessageFormat = string3 == null ? "" : string3;
        String string4 = resource.getString(code.getKey());
        this.messageFormat = string4 != null ? string4 : "";
        this.additionalMessage = str;
    }

    public ResultAPI(Code code, String str) {
        Intrinsics.checkNotNullParameter(code, "code");
        Code code2 = Code.Success;
        this.code = code2;
        Resource resource = Resource.INSTANCE;
        String string = resource.getString(code2.getKey());
        this.errorMessageFormat = string == null ? "" : string;
        String string2 = resource.getString(code2.getKey());
        this.messageFormat = string2 == null ? "" : string2;
        this.errorCode = code == code2 ? 0 : -98;
        this.code = code;
        String string3 = resource.getString(code.getKey());
        this.errorMessageFormat = string3 == null ? "" : string3;
        String string4 = resource.getString(code.getKey());
        this.messageFormat = string4 != null ? string4 : "";
        this.additionalMessage = str;
    }
}
