package com.hive.configuration;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.Configuration;
import com.hive.Const;
import com.hive.HiveActivity;
import com.hive.Permission;
import com.hive.ResultAPI;
import com.hive.analytics.AnalyticsImpl;
import com.hive.auth.AuthImpl;
import com.hive.auth.AuthKeys;
import com.hive.authv4.AuthV4Keys;
import com.hive.base.Android;
import com.hive.base.Property;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.StringUtil;
import com.hive.core.configuration.HiveLanguage;
import com.hive.core.configuration.HiveOrientation;
import com.hive.core.configuration.HiveTheme;
import com.hive.core.configuration.HiveZoneType;
import com.hive.logger.LoggerImpl;
import com.hive.permission.PermissionImpl;
import com.hive.protocol.provision.MetadataInitInteraction;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.Resource;
import com.hive.ui.Util;
import io.ktor.http.ContentDisposition;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b<\n\u0002\u0010 \n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002ë\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0006J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0006\u0010\u001d\u001a\u00020\u0006J\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010%\u001a\u00020\u001fJ\u000e\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u001fJ\u0006\u0010(\u001a\u00020\u0013J\u0006\u0010)\u001a\u00020\u0007J\u0006\u0010-\u001a\u00020\u0006J\u000e\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u0006J\u0006\u00101\u001a\u00020\u0006J\u0006\u00103\u001a\u00020\u0006J\u000e\u00104\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u00106\u001a\u00020\u0006J\u000e\u00107\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u00109\u001a\u00020\u0006J\u000e\u0010:\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010<\u001a\u00020\u0006J\u000e\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\u0006J\u0006\u0010@\u001a\u00020\u0006J\u000e\u0010A\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0006J\u0018\u0010B\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\u00062\b\u0010D\u001a\u0004\u0018\u00010\u0006J\u0006\u0010F\u001a\u00020\u0006J\u000e\u0010G\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010J\u001a\u00020\u0006J\u0006\u0010N\u001a\u00020\u0006J\u000e\u0010O\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010U\u001a\u00020\u0007J\u000e\u0010V\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010Z\u001a\u00020\u0006J\u000e\u0010[\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010b\u001a\u00020\u0007J\u0006\u0010c\u001a\u00020\tJ\u000e\u0010d\u001a\u00020\t2\u0006\u0010e\u001a\u00020\u0006J\u0006\u0010i\u001a\u00020\u0007J\u000e\u0010j\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010n\u001a\u00020\u0007J\u0010\u0010n\u001a\u00020\u00072\b\u0010o\u001a\u0004\u0018\u00010\u0006J\u0006\u0010s\u001a\u00020\u0007J\u0006\u0010t\u001a\u00020\u0007J\u0010\u0010u\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0006H\u0002J\u000e\u0010v\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010w\u001a\u00020\u0007J\u0006\u0010x\u001a\u00020yJ\u000e\u0010z\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020yJ\u0012\u0010~\u001a\u000e\u0012\u0004\u0012\u00020}\u0012\u0004\u0012\u00020\u00010|J\u001c\u0010\u007f\u001a\u00020\u00132\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020}\u0012\u0004\u0012\u00020\u00010|J\u0007\u0010\u0083\u0001\u001a\u00020\u0006J\u000f\u0010\u0084\u0001\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0006J\u0007\u0010\u008a\u0001\u001a\u00020yJ\u000f\u0010\u008b\u0001\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020yJ\u0007\u0010\u008f\u0001\u001a\u00020\u0006J\u000f\u0010\u0090\u0001\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0006J\u0007\u0010\u0094\u0001\u001a\u00020\u0006J\u000f\u0010\u0095\u0001\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0006J\u0007\u0010\u0099\u0001\u001a\u00020yJ\u000f\u0010\u009a\u0001\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020yJ\u0007\u0010\u009e\u0001\u001a\u00020yJ\u000f\u0010\u009f\u0001\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020yJ\u0007\u0010¡\u0001\u001a\u00020yJ\u000f\u0010¢\u0001\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020yJ\b\u0010¥\u0001\u001a\u00030¤\u0001J\u0010\u0010¦\u0001\u001a\u00020\u00132\u0007\u0010\u0017\u001a\u00030¤\u0001J\u000f\u0010¨\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\\J\u0017\u0010©\u0001\u001a\u00020\u00132\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\\J\u0007\u0010ª\u0001\u001a\u00020\u0006J\u0007\u0010«\u0001\u001a\u00020\tJ\u000f\u0010¬\u0001\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\tJ\u0007\u0010\u00ad\u0001\u001a\u00020\u0006J\u0007\u0010®\u0001\u001a\u00020yJ\u000f\u0010¯\u0001\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020yJ\u0007\u0010°\u0001\u001a\u00020yJ\u000f\u0010±\u0001\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020yJ\b\u0010²\u0001\u001a\u00030³\u0001J\u0010\u0010´\u0001\u001a\u00020\u00132\u0007\u0010\u0017\u001a\u00030³\u0001J\u0007\u0010µ\u0001\u001a\u00020yJ\u000f\u0010¶\u0001\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020yJ\b\u0010½\u0001\u001a\u00030·\u0001J\u0010\u0010¾\u0001\u001a\u00020\u00132\u0007\u0010\u0017\u001a\u00030·\u0001J\u0007\u0010À\u0001\u001a\u00020\u0007J\u000f\u0010Á\u0001\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0007J\u0007\u0010Ã\u0001\u001a\u00020\u0007J\u0011\u0010Ä\u0001\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0007H\u0007J\u0014\u0010Å\u0001\u001a\u00030Æ\u00012\b\u0010Ç\u0001\u001a\u00030È\u0001H\u0007J\u0007\u0010É\u0001\u001a\u00020\u0006J\u001b\u0010Ê\u0001\u001a\u00020\u00132\t\u0010Ë\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010Ì\u0001\u001a\u00020\u0007J\u0007\u0010Í\u0001\u001a\u00020\u0006J\u000f\u0010Î\u0001\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0006J\b\u0010Ï\u0001\u001a\u00030Ð\u0001J\u0010\u0010Ñ\u0001\u001a\u00020\u00132\u0007\u0010\u0017\u001a\u00030Ð\u0001J\u0007\u0010Õ\u0001\u001a\u00020\u0007J\u000f\u0010Ö\u0001\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0007J\u0007\u0010Ø\u0001\u001a\u00020\u0007J\u0010\u0010Ù\u0001\u001a\u00020\u00132\u0007\u0010Ú\u0001\u001a\u00020\u0007J\u0007\u0010Û\u0001\u001a\u00020\u0007J\u0007\u0010Ü\u0001\u001a\u00020\u0007J\u0019\u0010Ý\u0001\u001a\u00020\u00132\b\u0010Þ\u0001\u001a\u00030ß\u00012\u0006\u0010\u0017\u001a\u00020\u0006J\"\u0010à\u0001\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\u00062\u0007\u0010á\u0001\u001a\u00020\u00072\b\u0010â\u0001\u001a\u00030ã\u0001J\u0007\u0010ä\u0001\u001a\u00020\u0007J\u001e\u0010ä\u0001\u001a\u00020\u00072\n\u0010å\u0001\u001a\u0005\u0018\u00010æ\u00012\u0007\u0010ç\u0001\u001a\u00020\u0006H\u0002J\u001c\u0010è\u0001\u001a\u00020\u00072\n\u0010å\u0001\u001a\u0005\u0018\u00010æ\u00012\u0007\u0010é\u0001\u001a\u00020\tJ\u0015\u0010ê\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00068B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010 \u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u001f8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010*\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00068B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010\u001cR\u000e\u00100\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010H\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\u001aR$\u0010K\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00068B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bL\u0010\u001a\"\u0004\bM\u0010\u001cR$\u0010P\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00078B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR$\u0010W\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00068B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bX\u0010\u001a\"\u0004\bY\u0010\u001cR4\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\\2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\\8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR$\u0010f\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00078B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bg\u0010R\"\u0004\bh\u0010TR$\u0010k\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00078B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bl\u0010R\"\u0004\bm\u0010TR\u001b\u0010p\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\br\u0010\u000e\u001a\u0004\bq\u0010RR\u001a\u0010{\u001a\u000e\u0012\u0004\u0012\u00020}\u0012\u0004\u0012\u00020\u00010|X\u0082\u000e¢\u0006\u0002\n\u0000R'\u0010\u0080\u0001\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00068B@BX\u0082\u000e¢\u0006\u000e\u001a\u0005\b\u0081\u0001\u0010\u001a\"\u0005\b\u0082\u0001\u0010\u001cR)\u0010\u0085\u0001\u001a\u00020y2\u0006\u0010\u0017\u001a\u00020y8B@BX\u0082\u000e¢\u0006\u0010\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R'\u0010\u008c\u0001\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00068B@BX\u0082\u000e¢\u0006\u000e\u001a\u0005\b\u008d\u0001\u0010\u001a\"\u0005\b\u008e\u0001\u0010\u001cR'\u0010\u0091\u0001\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00068B@BX\u0082\u000e¢\u0006\u000e\u001a\u0005\b\u0092\u0001\u0010\u001a\"\u0005\b\u0093\u0001\u0010\u001cR)\u0010\u0096\u0001\u001a\u00020y2\u0006\u0010\u0017\u001a\u00020y8B@BX\u0082\u000e¢\u0006\u0010\u001a\u0006\b\u0097\u0001\u0010\u0087\u0001\"\u0006\b\u0098\u0001\u0010\u0089\u0001R)\u0010\u009b\u0001\u001a\u00020y2\u0006\u0010\u0017\u001a\u00020y8B@BX\u0082\u000e¢\u0006\u0010\u001a\u0006\b\u009c\u0001\u0010\u0087\u0001\"\u0006\b\u009d\u0001\u0010\u0089\u0001R\u000f\u0010 \u0001\u001a\u00020yX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010£\u0001\u001a\u00030¤\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010§\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010¸\u0001\u001a\u00030·\u00012\u0007\u0010\u0017\u001a\u00030·\u00018B@BX\u0082\u000e¢\u0006\u0010\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R\u000f\u0010¿\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Â\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R'\u0010Ò\u0001\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00078B@BX\u0082\u000e¢\u0006\u000e\u001a\u0005\bÓ\u0001\u0010R\"\u0005\bÔ\u0001\u0010TR\u000f\u0010×\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006ì\u0001"}, d2 = {"Lcom/hive/configuration/ConfigurationImpl;", "", "<init>", "()V", "mapChangedByAPI", "", "", "", "hiveConfigProperties", "Lorg/json/JSONObject;", "hiveConfigProviders", "getHiveConfigProviders", "()Lorg/json/JSONObject;", "hiveConfigProviders$delegate", "Lkotlin/Lazy;", "getReferenceSDKVersion", "peppermintInitAppId", "getPeppermintNativeVersion", "setPeppermintInitAppId", "", "appId", "getPeppermintInitAppId", "resetTableForChangedValueByAPI", "value", "_appId", "get_appId", "()Ljava/lang/String;", "set_appId", "(Ljava/lang/String;)V", "getAppId", "setAppId", "Lcom/hive/core/configuration/HiveZoneType;", "_zone", "get_zone", "()Lcom/hive/core/configuration/HiveZoneType;", "set_zone", "(Lcom/hive/core/configuration/HiveZoneType;)V", "getZone", "setZone", "zoneType", "setTestZone", "isTestZone", "_serverId", "get_serverId", "set_serverId", "getServerId", "setServerId", "serverId", "_qqAppId", "getQQAppId", "_vkAppId", "getVKAppId", "setVKAppId", "_wechatAppId", "getWechatAppId", "setWechatAppId", "_wechatAppSecret", "getWechatAppSecret", "setWechatAppSecret", "_wechatPaymentKey", "getWechatPaymentKey", "setWechatPaymentKey", "key", "_googleServerClientId", "getGoogleServerClientId", "setGoogleServerClientId", "setProvidersWithTracker", "serviceName", "trackerData", "_signInAppleServiceId", "getSignInAppleServiceId", "setSignInAppleServiceId", "_gameId", "get_gameId", "getGameId", "_hiveCommunityUrl", "get_hiveCommunityUrl", "set_hiveCommunityUrl", "getHiveCommunityUrl", "setHiveCommunityUrl", "_useHercules", "get_useHercules", "()Z", "set_useHercules", "(Z)V", "getUseHercules", "setUseHercules", "_agreementDetermineBase", "get_agreementDetermineBase", "set_agreementDetermineBase", "getAgreementDetermineBase", "setAgreementDetermineBase", "", "_unsupportedUAShareType", "get_unsupportedUAShareType", "()Ljava/util/List;", "set_unsupportedUAShareType", "(Ljava/util/List;)V", "isAgreementDetermineBaseAccount", "getProvidersFromHiveConfig", "getProviderFromHiveConfig", "providerName", "_useLog", "get_useLog", "set_useLog", "getUseLog", "setUseLog", "_ageGateU13", "get_ageGateU13", "set_ageGateU13", "getAgeGateU13", "hwIdsKey", "ageGateU13BeforeCallingSetup", "getAgeGateU13BeforeCallingSetup", "ageGateU13BeforeCallingSetup$delegate", "getAgeGateU16Agree", "getLegalGuardianConsentAgree", "findValueInAgreementScheme", "setAgeGateU13", "getExitEventEnabled", "getSystemUI", "", "setSystemUI", "_permissions", "", "Lcom/hive/Configuration$HIVEPermissionType;", "getPermissions", "setPermissions", "_company", "get_company", "set_company", "getCompany", "setCompany", "_companyIndex", "get_companyIndex", "()I", "set_companyIndex", "(I)V", "getCompanyIndex", "setCompanyIndex", "_channel", "get_channel", "set_channel", "getChannel", "setChannel", "_market", "get_market", "set_market", "getMarket", "setMarket", "_httpConnectTimeout", "get_httpConnectTimeout", "set_httpConnectTimeout", "getHttpConnectTimeout", "setHttpConnectTimeout", "_httpReadTimeout", "get_httpReadTimeout", "set_httpReadTimeout", "getHttpReadTimeout", "setHttpReadTimeout", "_maxGameLogSize", "getMaxGameLogSize", "setMaxGameLogSize", "trackersJsonArray", "Lorg/json/JSONArray;", "getTrackers", "setTrackers", "_facebookPermissions", "getFacebookPermissions", "setFacebookPermissions", "getHiveCountry", "getHiveTimeZone", "setHiveTimeZone", "getModuleVersion", "getAnalyticsSendLimit", "setAnalyticsSendLimit", "getAnalyticsQueueLimit", "setAnalyticsQueueLimit", "getAnalyticsSendCycleSeconds", "", "setAnalyticsSendCycleSeconds", "getChatConnectionTimeout", "setChatConnectionTimeout", "Lcom/hive/core/configuration/HiveOrientation;", "_hiveOrientation", "get_hiveOrientation", "()Lcom/hive/core/configuration/HiveOrientation;", "set_hiveOrientation", "(Lcom/hive/core/configuration/HiveOrientation;)V", "getHiveOrientation", "setHiveOrientation", "_authV1Agreement", "getAuthV1Agreement", "setAuthV1Agreement", "_hivePermissionViewOn", "getHivePermissionViewOn", "setHivePermissionViewOn", "getPermissionViewData", "Lcom/hive/Permission$PermissionViewData;", "language", "Lcom/hive/core/configuration/HiveLanguage;", "getHiveLanguage", "setHiveLanguage", "gameLanguage", "internalCalled", "getHiveCertificationKey", "setHiveCertificationKey", "getHiveTheme", "Lcom/hive/core/configuration/HiveTheme;", "setHiveTheme", "_crossPromotionBannerShowing", "get_crossPromotionBannerShowing", "set_crossPromotionBannerShowing", "getCrossPromotionBannerShowing", "setCrossPromotionBannerShowing", "useGoogleCredentialSignIn", "getUseGoogleCredentialSignIn", "setUseGoogleCredentialSignIn", "enable", "getIsEEACountry", "getIsGDPRCountry", "setConfigurations", "configType", "Lcom/hive/Configuration$HiveConfigType;", "getMetaData", "forceReload", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/Configuration$GetMetaDataListener;", "parseXmlConfigurationFile", "context", "Landroid/content/Context;", ContentDisposition.Parameters.FileName, "parseArgConfigurationData", "argJsonData", "toMap", "ConfigKeys", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConfigurationImpl {
    public static final ConfigurationImpl INSTANCE;
    private static boolean _authV1Agreement;
    private static List<String> _facebookPermissions;
    private static String _googleServerClientId;
    private static boolean _hivePermissionViewOn;
    private static int _maxGameLogSize;
    private static Map<Configuration.HIVEPermissionType, ? extends Object> _permissions;
    private static String _qqAppId;
    private static String _signInAppleServiceId;
    private static String _vkAppId;
    private static String _wechatAppId;
    private static String _wechatAppSecret;
    private static String _wechatPaymentKey;

    /* JADX INFO: renamed from: ageGateU13BeforeCallingSetup$delegate, reason: from kotlin metadata */
    private static final Lazy ageGateU13BeforeCallingSetup;
    private static JSONObject hiveConfigProperties;

    /* JADX INFO: renamed from: hiveConfigProviders$delegate, reason: from kotlin metadata */
    private static final Lazy hiveConfigProviders;
    private static Map<String, Boolean> mapChangedByAPI;
    private static String peppermintInitAppId;
    private static JSONArray trackersJsonArray;
    private static boolean useGoogleCredentialSignIn;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b%\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'¨\u0006("}, d2 = {"Lcom/hive/configuration/ConfigurationImpl$ConfigKeys;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AGE_GATE_U13", "APP_ID", "COMPANY", "COMPANY_INDEX", "CHANNEL", "CROSS_PROMOTION_BANNER_SHOWING", "FACEBOOK_PERMISSIONS", "GAME_LANGUAGE", "GOOGLE_SERVER_CLIENT_ID", "HIVE_COMMUNITY_URL", "HIVE_ORIENTATION", "HIVE_PERMISSSION_VIEW_ON", "HTTP_CONNECT_TIMEOUT", "HTTP_READ_TIMEOUT", "MARKET", "MAX_GAMELOG_SIZE", "PERMISSIONS", "QQAPP_ID", "SERVER_ID", "SYSTEM_UI", "TRACKER", "TRACKERS", "UNSUPPORTED_UA_SHARE_TYPE", "USE_LOG", "VKAPP_ID", "WECHATAPP_ID", "WECHATAPP_SECRET", "WECHATPAYMENT_KEY", "ZONE", "SIGN_IN_APPLE_SERVICE_ID", "AUTH_V1_AGREEMENT", "AGREEMENT_DETERMINE_BASE", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ConfigKeys {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ConfigKeys[] $VALUES;
        private final String value;
        public static final ConfigKeys AGE_GATE_U13 = new ConfigKeys("AGE_GATE_U13", 0, "ageGateU13");
        public static final ConfigKeys APP_ID = new ConfigKeys("APP_ID", 1, "appId");
        public static final ConfigKeys COMPANY = new ConfigKeys("COMPANY", 2, "company");
        public static final ConfigKeys COMPANY_INDEX = new ConfigKeys("COMPANY_INDEX", 3, "companyIndex");
        public static final ConfigKeys CHANNEL = new ConfigKeys("CHANNEL", 4, "channel");
        public static final ConfigKeys CROSS_PROMOTION_BANNER_SHOWING = new ConfigKeys("CROSS_PROMOTION_BANNER_SHOWING", 5, "crossPromotionBannerShowing");
        public static final ConfigKeys FACEBOOK_PERMISSIONS = new ConfigKeys("FACEBOOK_PERMISSIONS", 6, "facebookPermissions");
        public static final ConfigKeys GAME_LANGUAGE = new ConfigKeys("GAME_LANGUAGE", 7, "gameLanguage");
        public static final ConfigKeys GOOGLE_SERVER_CLIENT_ID = new ConfigKeys("GOOGLE_SERVER_CLIENT_ID", 8, "googleServerClientId");
        public static final ConfigKeys HIVE_COMMUNITY_URL = new ConfigKeys("HIVE_COMMUNITY_URL", 9, "hiveCommunityUrl");
        public static final ConfigKeys HIVE_ORIENTATION = new ConfigKeys("HIVE_ORIENTATION", 10, "hiveOrientation");
        public static final ConfigKeys HIVE_PERMISSSION_VIEW_ON = new ConfigKeys("HIVE_PERMISSSION_VIEW_ON", 11, "hivePermissionViewOn");
        public static final ConfigKeys HTTP_CONNECT_TIMEOUT = new ConfigKeys("HTTP_CONNECT_TIMEOUT", 12, "httpConnectTimeout");
        public static final ConfigKeys HTTP_READ_TIMEOUT = new ConfigKeys("HTTP_READ_TIMEOUT", 13, "httpReadTimeout");
        public static final ConfigKeys MARKET = new ConfigKeys("MARKET", 14, "market");
        public static final ConfigKeys MAX_GAMELOG_SIZE = new ConfigKeys("MAX_GAMELOG_SIZE", 15, "maxGameLogSize");
        public static final ConfigKeys PERMISSIONS = new ConfigKeys("PERMISSIONS", 16, "permissions");
        public static final ConfigKeys QQAPP_ID = new ConfigKeys("QQAPP_ID", 17, "qqAppId");
        public static final ConfigKeys SERVER_ID = new ConfigKeys("SERVER_ID", 18, "_serverId");
        public static final ConfigKeys SYSTEM_UI = new ConfigKeys("SYSTEM_UI", 19, "systemUI");
        public static final ConfigKeys TRACKER = new ConfigKeys("TRACKER", 20, "tracker");
        public static final ConfigKeys TRACKERS = new ConfigKeys("TRACKERS", 21, Constants.ADJUST_PREINSTALL_CONTENT_URI_PATH);
        public static final ConfigKeys UNSUPPORTED_UA_SHARE_TYPE = new ConfigKeys("UNSUPPORTED_UA_SHARE_TYPE", 22, "unsupportedUAShareType");
        public static final ConfigKeys USE_LOG = new ConfigKeys("USE_LOG", 23, "useLog");
        public static final ConfigKeys VKAPP_ID = new ConfigKeys("VKAPP_ID", 24, "vkAppId");
        public static final ConfigKeys WECHATAPP_ID = new ConfigKeys("WECHATAPP_ID", 25, "wechatAppId");
        public static final ConfigKeys WECHATAPP_SECRET = new ConfigKeys("WECHATAPP_SECRET", 26, "wechatAppSecret");
        public static final ConfigKeys WECHATPAYMENT_KEY = new ConfigKeys("WECHATPAYMENT_KEY", 27, "wechatPaymentKey");
        public static final ConfigKeys ZONE = new ConfigKeys("ZONE", 28, "zone");
        public static final ConfigKeys SIGN_IN_APPLE_SERVICE_ID = new ConfigKeys("SIGN_IN_APPLE_SERVICE_ID", 29, "signInAppleServiceId");
        public static final ConfigKeys AUTH_V1_AGREEMENT = new ConfigKeys("AUTH_V1_AGREEMENT", 30, "authV1Agreement");
        public static final ConfigKeys AGREEMENT_DETERMINE_BASE = new ConfigKeys("AGREEMENT_DETERMINE_BASE", 31, "agreementDetermineBase");

        private static final /* synthetic */ ConfigKeys[] $values() {
            return new ConfigKeys[]{AGE_GATE_U13, APP_ID, COMPANY, COMPANY_INDEX, CHANNEL, CROSS_PROMOTION_BANNER_SHOWING, FACEBOOK_PERMISSIONS, GAME_LANGUAGE, GOOGLE_SERVER_CLIENT_ID, HIVE_COMMUNITY_URL, HIVE_ORIENTATION, HIVE_PERMISSSION_VIEW_ON, HTTP_CONNECT_TIMEOUT, HTTP_READ_TIMEOUT, MARKET, MAX_GAMELOG_SIZE, PERMISSIONS, QQAPP_ID, SERVER_ID, SYSTEM_UI, TRACKER, TRACKERS, UNSUPPORTED_UA_SHARE_TYPE, USE_LOG, VKAPP_ID, WECHATAPP_ID, WECHATAPP_SECRET, WECHATPAYMENT_KEY, ZONE, SIGN_IN_APPLE_SERVICE_ID, AUTH_V1_AGREEMENT, AGREEMENT_DETERMINE_BASE};
        }

        static {
            ConfigKeys[] configKeysArr$values = $values();
            $VALUES = configKeysArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(configKeysArr$values);
        }

        private ConfigKeys(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<ConfigKeys> getEntries() {
            return $ENTRIES;
        }

        public static ConfigKeys valueOf(String str) {
            return (ConfigKeys) Enum.valueOf(ConfigKeys.class, str);
        }

        public static ConfigKeys[] values() {
            return (ConfigKeys[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Configuration.HiveConfigType.values().length];
            try {
                iArr[Configuration.HiveConfigType.googleServerClientId.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Configuration.HiveConfigType.googlePlayGamesServerClientId.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Configuration.HiveConfigType.wechatSecret.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Configuration.HiveConfigType.wechatPaymentKey.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Configuration.HiveConfigType.adjustKey.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Configuration.HiveConfigType.singularKey.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Configuration.HiveConfigType.appsflyerKey.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Configuration.HiveConfigType.airbridgeKey.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[Configuration.HiveConfigType.airbridgeAppName.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[Configuration.HiveConfigType.airbridgeSecretId.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[Configuration.HiveConfigType.airbridgeSecret.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        ConfigurationImpl configurationImpl = new ConfigurationImpl();
        INSTANCE = configurationImpl;
        mapChangedByAPI = new LinkedHashMap();
        hiveConfigProperties = new JSONObject();
        hiveConfigProviders = LazyKt.lazy(new Function0() { // from class: com.hive.configuration.ConfigurationImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ConfigurationImpl.hiveConfigProviders_delegate$lambda$0();
            }
        });
        peppermintInitAppId = "";
        _qqAppId = "";
        _vkAppId = "";
        _wechatAppId = "";
        _wechatAppSecret = "";
        _wechatPaymentKey = "";
        _googleServerClientId = "";
        _signInAppleServiceId = "";
        ageGateU13BeforeCallingSetup = LazyKt.lazy(new Function0() { // from class: com.hive.configuration.ConfigurationImpl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ConfigurationImpl.ageGateU13BeforeCallingSetup_delegate$lambda$15());
            }
        });
        _permissions = new LinkedHashMap();
        _maxGameLogSize = 50;
        trackersJsonArray = new JSONArray();
        _authV1Agreement = true;
        _hivePermissionViewOn = true;
        configurationImpl.resetTableForChangedValueByAPI();
        configurationImpl.parseXmlConfigurationFile();
    }

    private ConfigurationImpl() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ageGateU13BeforeCallingSetup_delegate$lambda$15() {
        return INSTANCE.get_ageGateU13();
    }

    private final boolean findValueInAgreementScheme(String key) {
        JSONArray jSONArray;
        int length;
        int i;
        String strOptString;
        byte[] base64Decode$default;
        try {
            jSONArray = new JSONArray(Property.INSTANCE.getINSTANCE().getValue(AuthV4Keys.AGREEMENT_AGREED_DATA));
            length = jSONArray.length();
        } catch (Exception e) {
            LoggerImpl.INSTANCE.d("[findValueInAgreementScheme] exception : " + e);
        }
        for (i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && (strOptString = jSONObjectOptJSONObject.optString("scheme")) != null) {
                String queryParameter = Uri.parse(strOptString).getQueryParameter("agreement");
                JSONObject jSONObject = null;
                if (queryParameter != null) {
                    Charset charset = Charsets.UTF_8;
                    byte[] bytes = queryParameter.getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                    if (bytes != null && (base64Decode$default = StringUtil.toBase64Decode$default(StringUtil.INSTANCE, bytes, 0, 1, null)) != null) {
                        jSONObject = new JSONObject(new String(base64Decode$default, charset));
                    }
                }
                if (jSONObject != null && jSONObject.has(key)) {
                    return jSONObject.optBoolean(key);
                }
                return false;
            }
        }
        return false;
    }

    private final boolean getAgeGateU13BeforeCallingSetup() {
        return ((Boolean) ageGateU13BeforeCallingSetup.getValue()).booleanValue();
    }

    private final JSONObject getHiveConfigProviders() {
        return (JSONObject) hiveConfigProviders.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMetaData$lambda$21(String str, Configuration.GetMetaDataListener getMetaDataListener, ResultAPI resultAPI, MetadataInitInteraction metadataInitInteraction) {
        Intrinsics.checkNotNullParameter(resultAPI, "resultAPI");
        Intrinsics.checkNotNullParameter(metadataInitInteraction, "metadataInitInteraction");
        if (resultAPI.isSuccess()) {
            LoggerImpl.INSTANCE.d("ConfigurationImpl.getMetaData() call server API : Success");
            JSONObject dataJSONObject = metadataInitInteraction.getResponse().getDataJSONObject();
            String strValueOf = String.valueOf(dataJSONObject != null ? dataJSONObject.opt(str) : null);
            String str2 = Intrinsics.areEqual(strValueOf, AbstractJsonLexerKt.NULL) ? null : strValueOf;
            getMetaDataListener.onGetMetaData(resultAPI, str2 != null ? str2 : "");
        } else {
            LoggerImpl.INSTANCE.d("ConfigurationImpl.getMetaData() call server API : Failed");
            getMetaDataListener.onGetMetaData(new ResultAPI(-8, ResultAPI.Code.AuthV4InvalidResponseData), "");
        }
        return Unit.INSTANCE;
    }

    private final boolean get_ageGateU13() {
        return com.hive.core.Configuration.INSTANCE.getAgeGateU13();
    }

    private final String get_agreementDetermineBase() {
        return com.hive.core.Configuration.INSTANCE.getAgreementDetermineBase();
    }

    private final String get_appId() {
        return com.hive.core.Configuration.INSTANCE.getAppId();
    }

    private final String get_channel() {
        return com.hive.core.Configuration.INSTANCE.getChannel();
    }

    private final String get_company() {
        return com.hive.core.Configuration.INSTANCE.getCompany();
    }

    private final int get_companyIndex() {
        return com.hive.core.Configuration.INSTANCE.getCompanyIndex();
    }

    private final boolean get_crossPromotionBannerShowing() {
        return com.hive.core.Configuration.INSTANCE.getCrossPromotionBannerShowing();
    }

    private final String get_gameId() {
        return com.hive.core.Configuration.INSTANCE.getGameId();
    }

    private final String get_hiveCommunityUrl() {
        return com.hive.core.Configuration.INSTANCE.getHiveCommunityUrl();
    }

    private final HiveOrientation get_hiveOrientation() {
        return com.hive.core.Configuration.INSTANCE.getHiveOrientation();
    }

    private final int get_httpConnectTimeout() {
        return com.hive.core.Configuration.INSTANCE.getConnectTimeoutSeconds();
    }

    private final int get_httpReadTimeout() {
        return com.hive.core.Configuration.INSTANCE.getReadTimeoutSeconds();
    }

    private final String get_market() {
        return com.hive.core.Configuration.INSTANCE.getMarket();
    }

    private final String get_serverId() {
        return com.hive.core.Configuration.INSTANCE.getServerId();
    }

    private final List<String> get_unsupportedUAShareType() {
        return com.hive.core.Configuration.INSTANCE.getUnsupportedUAShareType();
    }

    private final boolean get_useHercules() {
        return com.hive.core.Configuration.INSTANCE.getUseHercules();
    }

    private final boolean get_useLog() {
        return Logger.INSTANCE.getLogEnable();
    }

    private final HiveZoneType get_zone() {
        return com.hive.core.Configuration.INSTANCE.getZone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject hiveConfigProviders_delegate$lambda$0() {
        return INSTANCE.getProvidersFromHiveConfig();
    }

    private final void resetTableForChangedValueByAPI() {
        mapChangedByAPI.clear();
        for (ConfigKeys configKeys : ConfigKeys.values()) {
            mapChangedByAPI.put(configKeys.getValue(), Boolean.FALSE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setPermissions$default(ConfigurationImpl configurationImpl, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = new LinkedHashMap();
        }
        configurationImpl.setPermissions(map);
    }

    private final void set_ageGateU13(boolean z) {
        com.hive.core.Configuration.INSTANCE.setAgeGateU13(z);
    }

    private final void set_agreementDetermineBase(String str) {
        com.hive.core.Configuration.INSTANCE.setAgreementDetermineBase(str);
    }

    private final void set_appId(String str) {
        com.hive.core.Configuration.INSTANCE.setAppId(str);
    }

    private final void set_channel(String str) {
        com.hive.core.Configuration.INSTANCE.setChannel(str);
    }

    private final void set_company(String str) {
        com.hive.core.Configuration.INSTANCE.setCompany(str);
    }

    private final void set_companyIndex(int i) {
        com.hive.core.Configuration.INSTANCE.setCompanyIndex(i);
    }

    private final void set_crossPromotionBannerShowing(boolean z) {
        com.hive.core.Configuration.INSTANCE.setCrossPromotionBannerShowing(z);
    }

    private final void set_hiveCommunityUrl(String str) {
        com.hive.core.Configuration.INSTANCE.setHiveCommunityUrl(str);
    }

    private final void set_hiveOrientation(HiveOrientation hiveOrientation) {
        com.hive.core.Configuration.INSTANCE.setHiveOrientation(hiveOrientation);
    }

    private final void set_httpConnectTimeout(int i) {
        com.hive.core.Configuration.INSTANCE.setConnectTimeoutSeconds(i);
    }

    private final void set_httpReadTimeout(int i) {
        com.hive.core.Configuration.INSTANCE.setReadTimeoutSeconds(i);
    }

    private final void set_market(String str) {
        com.hive.core.Configuration.INSTANCE.setMarket(str);
    }

    private final void set_serverId(String str) {
        com.hive.core.Configuration.INSTANCE.setServerId(str);
    }

    private final void set_unsupportedUAShareType(List<String> list) {
        com.hive.core.Configuration.INSTANCE.setUnsupportedUAShareType(list);
    }

    private final void set_useHercules(boolean z) {
        com.hive.core.Configuration.INSTANCE.setUseHercules(z);
    }

    private final void set_useLog(boolean z) {
        Logger logger = Logger.INSTANCE;
        logger.setCoreLogEnable(z);
        logger.setLogEnable(z);
    }

    private final void set_zone(HiveZoneType hiveZoneType) {
        com.hive.core.Configuration.INSTANCE.setZone(hiveZoneType);
    }

    public final boolean getAgeGateU13() {
        return get_ageGateU13();
    }

    public final boolean getAgeGateU16Agree() {
        return findValueInAgreementScheme("age_gate_u16_gdpr");
    }

    public final String getAgreementDetermineBase() {
        return get_agreementDetermineBase();
    }

    public final int getAnalyticsQueueLimit() {
        return AnalyticsImpl.INSTANCE.getAnalyticsQueueLimit();
    }

    public final float getAnalyticsSendCycleSeconds() {
        return AnalyticsImpl.INSTANCE.getAnalyticsSendCycleSeconds();
    }

    public final int getAnalyticsSendLimit() {
        return AnalyticsImpl.INSTANCE.getAnalyticsSendLimit();
    }

    public final String getAppId() {
        return get_appId();
    }

    public final boolean getAuthV1Agreement() {
        return _authV1Agreement;
    }

    public final String getChannel() {
        return get_channel();
    }

    public final int getChatConnectionTimeout() {
        return com.hive.core.Configuration.INSTANCE.getChatConnectionTimeout();
    }

    public final String getCompany() {
        return get_company();
    }

    public final int getCompanyIndex() {
        return get_companyIndex();
    }

    public final boolean getCrossPromotionBannerShowing() {
        return get_crossPromotionBannerShowing();
    }

    public final boolean getExitEventEnabled() {
        return com.hive.core.Configuration.INSTANCE.isExitEventEnabled();
    }

    public final List<String> getFacebookPermissions() {
        return _facebookPermissions;
    }

    public final String getGameId() {
        return get_gameId();
    }

    public final String getGoogleServerClientId() {
        return _googleServerClientId;
    }

    public final String getHiveCertificationKey() {
        return com.hive.core.Configuration.INSTANCE.getHiveCertificationKey();
    }

    public final String getHiveCommunityUrl() {
        return get_hiveCommunityUrl();
    }

    public final String getHiveCountry() {
        return com.hive.core.Configuration.INSTANCE.getHiveCountry();
    }

    public final String getHiveLanguage() {
        return com.hive.core.Configuration.INSTANCE.getGameLanguage();
    }

    public final HiveOrientation getHiveOrientation() {
        return get_hiveOrientation();
    }

    public final boolean getHivePermissionViewOn() {
        return _hivePermissionViewOn;
    }

    public final HiveTheme getHiveTheme() {
        return com.hive.core.Configuration.INSTANCE.getHiveTheme();
    }

    public final JSONObject getHiveTimeZone() {
        return com.hive.core.Configuration.INSTANCE.getTimezone();
    }

    public final int getHttpConnectTimeout() {
        return get_httpConnectTimeout();
    }

    public final int getHttpReadTimeout() {
        return get_httpReadTimeout();
    }

    public final boolean getIsEEACountry() {
        return com.hive.core.Configuration.INSTANCE.isEEACountry();
    }

    public final boolean getIsGDPRCountry() {
        return com.hive.core.Configuration.INSTANCE.isGDPRCountry();
    }

    public final boolean getLegalGuardianConsentAgree() {
        return findValueInAgreementScheme("age_gate_threshold_consent");
    }

    public final String getMarket() {
        return get_market();
    }

    public final int getMaxGameLogSize() {
        return _maxGameLogSize;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getMetaData(final java.lang.String r3, boolean r4, final com.hive.Configuration.GetMetaDataListener r5) {
        /*
            r2 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "listener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            com.hive.core.Configuration r0 = com.hive.core.Configuration.INSTANCE
            org.json.JSONObject r0 = r0.getMetaData()
            if (r4 != 0) goto L3f
            if (r0 != 0) goto L15
            goto L3f
        L15:
            com.hive.logger.LoggerImpl r4 = com.hive.logger.LoggerImpl.INSTANCE
            java.lang.String r1 = "ConfigurationImpl.getMetaData() not call server API"
            r4.i(r1)
            java.lang.Object r3 = r0.opt(r3)
            if (r3 == 0) goto L34
            java.lang.String r3 = r3.toString()
            if (r3 == 0) goto L34
            java.lang.String r4 = "null"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r4 != 0) goto L31
            goto L32
        L31:
            r3 = 0
        L32:
            if (r3 != 0) goto L36
        L34:
            java.lang.String r3 = ""
        L36:
            com.hive.ResultAPI r4 = new com.hive.ResultAPI
            r4.<init>()
            r5.onGetMetaData(r4, r3)
            return
        L3f:
            com.hive.logger.LoggerImpl r0 = com.hive.logger.LoggerImpl.INSTANCE
            java.lang.String r1 = "ConfigurationImpl.getMetaData() call server API"
            r0.i(r1)
            com.hive.authv4.AuthV4Network$Provision r0 = com.hive.authv4.AuthV4Network.Provision.INSTANCE
            com.hive.configuration.ConfigurationImpl$$ExternalSyntheticLambda0 r1 = new com.hive.configuration.ConfigurationImpl$$ExternalSyntheticLambda0
            r1.<init>()
            r0.getMetadataInitInteraction(r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.configuration.ConfigurationImpl.getMetaData(java.lang.String, boolean, com.hive.Configuration$GetMetaDataListener):void");
    }

    public final String getModuleVersion() {
        return com.hive.core.Configuration.INSTANCE.getInterfaceVersion();
    }

    public final String getPeppermintInitAppId() {
        return peppermintInitAppId;
    }

    public final String getPeppermintNativeVersion() {
        return "Hive v." + com.hive.core.Configuration.INSTANCE.getSdkVersion();
    }

    @Deprecated(message = "4.16.2, GCPSDK4-906")
    public final Permission.PermissionViewData getPermissionViewData(HiveLanguage language) {
        Intrinsics.checkNotNullParameter(language, "language");
        return PermissionImpl.INSTANCE.getPermissionViewData(language);
    }

    public final Map<Configuration.HIVEPermissionType, Object> getPermissions() {
        return _permissions;
    }

    public final JSONObject getProviderFromHiveConfig(String providerName) {
        Iterator<String> itKeys;
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        JSONObject hiveConfigProviders2 = getHiveConfigProviders();
        try {
            itKeys = hiveConfigProviders2.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
        } catch (Exception unused) {
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (StringsKt.equals(next, providerName, true)) {
                JSONObject jSONObject = hiveConfigProviders2.getJSONObject(next);
                LoggerImpl.INSTANCE.iL("[getProviderFromHiveConfig] - " + next + " : \n" + jSONObject.toString(4));
                Intrinsics.checkNotNullExpressionValue(jSONObject, "also(...)");
                return jSONObject;
            }
            LoggerImpl.INSTANCE.e("[getProviderFromHiveConfig] - not exist '" + providerName + '\'');
            return new JSONObject();
        }
        LoggerImpl.INSTANCE.e("[getProviderFromHiveConfig] - not exist '" + providerName + '\'');
        return new JSONObject();
    }

    public final JSONObject getProvidersFromHiveConfig() {
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject = hiveConfigProperties.optJSONObject("providers");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
            try {
                JSONObject jSONObject = new JSONObject();
                List<String> facebookPermissions = INSTANCE.getFacebookPermissions();
                if (facebookPermissions != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str : facebookPermissions) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("@name", str);
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("permissions", new JSONObject().put("permission", jSONArray));
                }
                jSONObjectOptJSONObject.put("facebook", jSONObject);
            } catch (Exception unused) {
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("@serverClientId", INSTANCE.getGoogleServerClientId());
                jSONObjectOptJSONObject.put("google", jSONObject3);
            } catch (Exception unused2) {
            }
            try {
                JSONObject jSONObject4 = new JSONObject();
                ConfigurationImpl configurationImpl = INSTANCE;
                jSONObject4.put("@id", configurationImpl.getWechatAppId());
                jSONObject4.put("@secret", configurationImpl.getWechatAppSecret());
                jSONObject4.put("@paymentKey", configurationImpl.getWechatPaymentKey());
                jSONObjectOptJSONObject.put("wechat", jSONObject4);
            } catch (Exception unused3) {
            }
            try {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("@id", INSTANCE.getQQAppId());
                jSONObjectOptJSONObject.put("qq", jSONObject5);
            } catch (Exception unused4) {
            }
            try {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("@id", INSTANCE.getVKAppId());
                jSONObjectOptJSONObject.put("vk", jSONObject6);
            } catch (Exception unused5) {
            }
            try {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("@serviceid", INSTANCE.getSignInAppleServiceId());
                jSONObjectOptJSONObject.put("signinwithapple", jSONObject7);
            } catch (Exception unused6) {
            }
            JSONObject jSONObjectOptJSONObject2 = hiveConfigProperties.optJSONObject(Constants.ADJUST_PREINSTALL_CONTENT_URI_PATH);
            if (jSONObjectOptJSONObject2 != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("tracker")) != null) {
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    try {
                        JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject3 != null) {
                            try {
                                jSONObjectOptJSONObject.put(jSONObjectOptJSONObject3.getString("@name"), jSONObjectOptJSONObject3);
                            } catch (Exception unused7) {
                                Unit unit = Unit.INSTANCE;
                            }
                        }
                    } catch (Exception unused8) {
                    }
                }
            }
            LoggerImpl.INSTANCE.iL("getProvidersFromHiveConfig migration : \n" + jSONObjectOptJSONObject.toString(4));
        }
        return jSONObjectOptJSONObject;
    }

    public final String getQQAppId() {
        return _qqAppId;
    }

    public final String getReferenceSDKVersion() {
        return ModuleChecker.INSTANCE.getLogHiveModuleVersionInfo();
    }

    public final String getServerId() {
        return get_serverId();
    }

    public final String getSignInAppleServiceId() {
        return _signInAppleServiceId;
    }

    public final int getSystemUI() {
        Util util = Util.INSTANCE;
        if (util.getSystemUI() < 0) {
            return 0;
        }
        return util.getSystemUI();
    }

    public final JSONArray getTrackers() {
        return trackersJsonArray;
    }

    public final boolean getUseGoogleCredentialSignIn() {
        return useGoogleCredentialSignIn;
    }

    public final boolean getUseHercules() {
        return get_useHercules();
    }

    public final boolean getUseLog() {
        return get_useLog();
    }

    public final String getVKAppId() {
        return _vkAppId;
    }

    public final String getWechatAppId() {
        return _wechatAppId;
    }

    public final String getWechatAppSecret() {
        return _wechatAppSecret;
    }

    public final String getWechatPaymentKey() {
        return _wechatPaymentKey;
    }

    public final HiveZoneType getZone() {
        return get_zone();
    }

    public final boolean isAgreementDetermineBaseAccount() {
        if (getAgeGateU13BeforeCallingSetup()) {
            return false;
        }
        String lowerCase = getAgreementDetermineBase().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return Intrinsics.areEqual(lowerCase, "account");
    }

    public final boolean isTestZone() {
        return get_zone() == HiveZoneType.TEST;
    }

    public final boolean parseArgConfigurationData(Context context, JSONObject argJsonData) {
        String strOptString;
        String strOptString2;
        String strOptString3;
        String strOptString4;
        Intrinsics.checkNotNullParameter(argJsonData, "argJsonData");
        Log.e(Const.TAG, "ConfigurationImpl parseArgConfigurationData");
        if (context == null) {
            Log.e(Const.TAG, "context is null, Call to com.hive.Configuration.setContext() on Activity.onCreate()");
            return false;
        }
        try {
            Log.i(Const.TAG, "ConfigurationImpl parseArgConfigurationData, parse data start");
            if (argJsonData.has("showLog") && argJsonData.optBoolean("showLog")) {
                Log.i(Const.TAG, "ConfigurationImpl parseArgConfigurationData, showLog true");
                Logger.INSTANCE.setLogEnable(true);
            }
            if (argJsonData.has("useSandbox")) {
                if (argJsonData.optBoolean("useSandbox")) {
                    Log.i(Const.TAG, "ConfigurationImpl parseArgConfigurationData, useSandbox");
                    setZone(HiveZoneType.SANDBOX);
                } else {
                    Log.i(Const.TAG, "ConfigurationImpl parseArgConfigurationData, useLive");
                    setZone(HiveZoneType.REAL);
                }
            }
            if (argJsonData.has("appId") && (strOptString4 = argJsonData.optString("appId")) != null && strOptString4.length() != 0) {
                Log.i(Const.TAG, "ConfigurationImpl parseArgConfigurationData, appId");
                String strOptString5 = argJsonData.optString("appId");
                Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
                setAppId(strOptString5);
            }
            if (argJsonData.has("permissionWriteExternalStorage")) {
                HashMap map = new HashMap();
                if (argJsonData.optBoolean("permissionWriteExternalStorage")) {
                    Log.i(Const.TAG, "ConfigurationImpl parseArgConfigurationData, permissionWriteExternalStorage true");
                    map.put(Configuration.HIVEPermissionType.SDWRITE, "true");
                } else {
                    Log.i(Const.TAG, "ConfigurationImpl parseArgConfigurationData, permissionWriteExternalStorage false");
                    map.put(Configuration.HIVEPermissionType.SDWRITE, "false");
                }
            }
            if (argJsonData.has("serverId") && (strOptString3 = argJsonData.optString("serverId")) != null && strOptString3.length() != 0) {
                Log.i(Const.TAG, "ConfigurationImpl parseArgConfigurationData, serverId : " + argJsonData.optString("serverId"));
                String strOptString6 = argJsonData.optString("serverId");
                Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
                setServerId(strOptString6);
            }
            if (argJsonData.has("gameLanguage") && (strOptString2 = argJsonData.optString("gameLanguage")) != null && strOptString2.length() != 0) {
                Log.i(Const.TAG, "ConfigurationImpl parseArgConfigurationData, gameLanguage : " + argJsonData.optString("gameLanguage"));
                setHiveLanguage(argJsonData.optString("gameLanguage"), false);
            }
            if (argJsonData.has("showNotice")) {
                if (argJsonData.optBoolean("showNotice")) {
                    Log.i(Const.TAG, "ConfigurationImpl parseArgConfigurationData, showNotice true");
                    AuthImpl.INSTANCE.setShowsNoticePopup(true);
                } else {
                    Log.i(Const.TAG, "ConfigurationImpl parseArgConfigurationData, showNotice false");
                    AuthImpl.INSTANCE.setShowsNoticePopup(false);
                }
            }
            if (argJsonData.has("channel") && (strOptString = argJsonData.optString("channel")) != null && strOptString.length() != 0) {
                Log.i(Const.TAG, "ConfigurationImpl parseArgConfigurationData, channel : " + argJsonData.optString("channel"));
                String strOptString7 = argJsonData.optString("channel", "C2S");
                Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
                setChannel(strOptString7);
            }
            if (argJsonData.has("timeoutSeconds") && argJsonData.optInt("timeoutSeconds") > 0) {
                Log.i(Const.TAG, "ConfigurationImpl parseArgConfigurationData, timeoutSeconds : " + argJsonData.optInt("timeoutSeconds"));
                setHttpConnectTimeout(argJsonData.optInt("timeoutSeconds"));
            }
            if (argJsonData.has("showHivePermissionView")) {
                if (argJsonData.optBoolean("showHivePermissionView")) {
                    Log.i(Const.TAG, "ConfigurationImpl parseArgConfigurationData, showHivePermissionView true");
                    setHivePermissionViewOn(true);
                } else {
                    Log.i(Const.TAG, "ConfigurationImpl parseArgConfigurationData, showHivePermissionView false");
                    setHivePermissionViewOn(false);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean parseXmlConfigurationFile() {
        boolean xmlConfigurationFile = parseXmlConfigurationFile(Configuration.getContext(), "hive_config");
        if (xmlConfigurationFile) {
            HiveLifecycle.INSTANCE.setHiveConfigProviders(INSTANCE.getProvidersFromHiveConfig());
        }
        return xmlConfigurationFile;
    }

    public final void setAgeGateU13(boolean value) {
        set_ageGateU13(value);
        mapChangedByAPI.put(ConfigKeys.AGE_GATE_U13.getValue(), Boolean.TRUE);
    }

    public final void setAgreementDetermineBase(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        set_agreementDetermineBase(value);
    }

    public final void setAnalyticsQueueLimit(int value) {
        AnalyticsImpl.INSTANCE.setAnalyticsQueueLimit(value);
    }

    public final void setAnalyticsSendCycleSeconds(float value) {
        AnalyticsImpl.INSTANCE.setAnalyticsSendCycleSeconds(value);
    }

    public final void setAnalyticsSendLimit(int value) {
        AnalyticsImpl.INSTANCE.setAnalyticsSendLimit(value);
    }

    public final void setAppId(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        set_appId(appId);
        mapChangedByAPI.put(ConfigKeys.APP_ID.getValue(), Boolean.TRUE);
    }

    public final void setAuthV1Agreement(boolean value) {
        _authV1Agreement = value;
        mapChangedByAPI.put(ConfigKeys.AUTH_V1_AGREEMENT.getValue(), Boolean.TRUE);
    }

    public final void setChannel(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        set_channel(value);
        mapChangedByAPI.put(ConfigKeys.CHANNEL.getValue(), Boolean.TRUE);
    }

    public final void setChatConnectionTimeout(int value) {
        com.hive.core.Configuration.INSTANCE.setChatConnectionTimeout(value);
    }

    public final void setCompany(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        set_company(value);
        mapChangedByAPI.put(ConfigKeys.COMPANY.getValue(), Boolean.TRUE);
    }

    public final void setCompanyIndex(int value) {
        set_companyIndex(value);
        mapChangedByAPI.put(ConfigKeys.COMPANY_INDEX.getValue(), Boolean.TRUE);
    }

    public final void setConfigurations(Configuration.HiveConfigType configType, String value) {
        Intrinsics.checkNotNullParameter(configType, "configType");
        Intrinsics.checkNotNullParameter(value, "value");
        switch (WhenMappings.$EnumSwitchMapping$0[configType.ordinal()]) {
            case 1:
                com.hive.core.Configuration.INSTANCE.setGoogleServerClientId(value);
                return;
            case 2:
                com.hive.core.Configuration.INSTANCE.setGooglePlayGamesServerClientId(value);
                return;
            case 3:
                com.hive.core.Configuration.INSTANCE.setWechatSecret(value);
                return;
            case 4:
                com.hive.core.Configuration.INSTANCE.setWechatPaymentKey(value);
                return;
            case 5:
                com.hive.core.Configuration.INSTANCE.setAdjustKey(value);
                return;
            case 6:
                com.hive.core.Configuration.INSTANCE.setSingularKey(value);
                return;
            case 7:
                com.hive.core.Configuration.INSTANCE.setAppsflyerKey(value);
                return;
            case 8:
                com.hive.core.Configuration.INSTANCE.setAirbridgeKey(value);
                return;
            case 9:
                com.hive.core.Configuration.INSTANCE.setAirbridgeAppName(value);
                return;
            case 10:
                com.hive.core.Configuration.INSTANCE.setAirbridgeSecretId(value);
                return;
            case 11:
                com.hive.core.Configuration.INSTANCE.setAirbridgeSecret(value);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void setCrossPromotionBannerShowing(boolean value) {
        set_crossPromotionBannerShowing(value);
        mapChangedByAPI.put(ConfigKeys.CROSS_PROMOTION_BANNER_SHOWING.getValue(), Boolean.TRUE);
    }

    public final void setFacebookPermissions(List<String> value) {
        _facebookPermissions = value;
        mapChangedByAPI.put(ConfigKeys.FACEBOOK_PERMISSIONS.getValue(), Boolean.TRUE);
    }

    public final void setGoogleServerClientId(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        _googleServerClientId = value;
        mapChangedByAPI.put(ConfigKeys.GOOGLE_SERVER_CLIENT_ID.getValue(), Boolean.TRUE);
    }

    public final void setHiveCertificationKey(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        com.hive.core.Configuration.INSTANCE.setHiveCertificationKey(value);
    }

    public final void setHiveCommunityUrl(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        set_hiveCommunityUrl(value);
        mapChangedByAPI.put(ConfigKeys.HIVE_COMMUNITY_URL.getValue(), Boolean.TRUE);
    }

    public final void setHiveLanguage(String gameLanguage, boolean internalCalled) {
        if (!internalCalled) {
            mapChangedByAPI.put(ConfigKeys.GAME_LANGUAGE.getValue(), Boolean.TRUE);
        }
        com.hive.core.Configuration configuration = com.hive.core.Configuration.INSTANCE;
        if (gameLanguage == null) {
            gameLanguage = "";
        }
        configuration.setGameLanguage(gameLanguage);
    }

    public final void setHiveOrientation(HiveOrientation value) {
        Intrinsics.checkNotNullParameter(value, "value");
        set_hiveOrientation(value);
        mapChangedByAPI.put(ConfigKeys.HIVE_ORIENTATION.getValue(), Boolean.TRUE);
    }

    @Deprecated(message = "4.16.2, GCPSDK4-906")
    public final void setHivePermissionViewOn(boolean value) {
        _hivePermissionViewOn = value;
        if (!TextUtils.isEmpty(Property.INSTANCE.getINSTANCE().getValue(AuthKeys.INSTANCE.getPERMISSION_VIEW_PAGE_SHOWN()))) {
            _hivePermissionViewOn = true;
        }
        mapChangedByAPI.put(ConfigKeys.HIVE_PERMISSSION_VIEW_ON.getValue(), Boolean.TRUE);
    }

    public final void setHiveTheme(HiveTheme value) {
        Intrinsics.checkNotNullParameter(value, "value");
        com.hive.core.Configuration.INSTANCE.setHiveTheme(value);
        if (HiveActivity.isActivityInitialized()) {
            Resource resource = Resource.INSTANCE;
            HiveActivity hiveActivity = HiveActivity.INSTANCE;
            hiveActivity.getRecentActivity().getTheme().applyStyle(Resource.getHiveStyleId$default(resource, hiveActivity.getRecentActivity(), null, 2, null), true);
        }
    }

    public final void setHiveTimeZone(JSONObject value) {
        Intrinsics.checkNotNullParameter(value, "value");
        com.hive.core.Configuration.INSTANCE.setTimezone(value);
    }

    public final void setHttpConnectTimeout(int value) {
        set_httpConnectTimeout(value);
        mapChangedByAPI.put(ConfigKeys.HTTP_CONNECT_TIMEOUT.getValue(), Boolean.TRUE);
    }

    public final void setHttpReadTimeout(int value) {
        set_httpReadTimeout(value);
        mapChangedByAPI.put(ConfigKeys.HTTP_READ_TIMEOUT.getValue(), Boolean.TRUE);
    }

    public final void setMarket(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        set_market(value);
        mapChangedByAPI.put(ConfigKeys.MARKET.getValue(), Boolean.TRUE);
    }

    public final void setMaxGameLogSize(int value) {
        _maxGameLogSize = value;
        mapChangedByAPI.put(ConfigKeys.MAX_GAMELOG_SIZE.getValue(), Boolean.TRUE);
    }

    public final void setPeppermintInitAppId(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        peppermintInitAppId = appId;
    }

    public final void setPermissions(Map<Configuration.HIVEPermissionType, ? extends Object> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        _permissions = value;
        mapChangedByAPI.put(ConfigKeys.PERMISSIONS.getValue(), Boolean.TRUE);
    }

    public final void setProvidersWithTracker(String serviceName, String trackerData) {
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        if (trackerData == null || StringsKt.isBlank(trackerData)) {
            LoggerImpl.INSTANCE.d("setProvidersWithTracker, data is empty");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = new JSONObject(trackerData);
        } catch (Exception e) {
            LoggerImpl.INSTANCE.d("setProvidersWithTracker, json parse exception : " + e);
        }
        try {
            JSONObject jSONObjectOptJSONObject = hiveConfigProperties.optJSONObject("providers");
            Intrinsics.checkNotNull(jSONObjectOptJSONObject);
            jSONObjectOptJSONObject.put(serviceName, jSONObject);
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.dL("setProvidersWithTracker, rewrite tracker settings(" + serviceName + ") : " + jSONObject);
            StringBuilder sb = new StringBuilder("setProvidersWithTracker, rewrite tracker settings(");
            sb.append(serviceName);
            sb.append(')');
            loggerImpl.dR(sb.toString());
        } catch (Exception e2) {
            LoggerImpl.INSTANCE.d("setProvidersWithTracker, set rewrite tracker exception : " + e2);
        }
    }

    public final void setServerId(String serverId) {
        Intrinsics.checkNotNullParameter(serverId, "serverId");
        set_serverId(serverId);
        mapChangedByAPI.put(ConfigKeys.SERVER_ID.getValue(), Boolean.TRUE);
        HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
        if (hiveLifecycle.isSdkSetup()) {
            AnalyticsImpl analyticsImpl = AnalyticsImpl.INSTANCE;
            analyticsImpl.sendUserEntryFunnelsLogs(AnalyticsImpl.FunnelsTrack.SELECT_SERVER);
            analyticsImpl.onChangeProperty(HiveKeys.KEY_serverId.getValue(), serverId);
        }
        String vid = hiveLifecycle.getAccount().getVid();
        if (vid == null || vid.length() <= 0) {
            return;
        }
        AnalyticsImpl.INSTANCE.sendLoginServerSelectLog();
    }

    public final void setSignInAppleServiceId(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        _signInAppleServiceId = value;
        mapChangedByAPI.put(ConfigKeys.SIGN_IN_APPLE_SERVICE_ID.getValue(), Boolean.TRUE);
    }

    public final void setSystemUI(int value) {
        Util.INSTANCE.setSystemUI(value);
        mapChangedByAPI.put(ConfigKeys.SYSTEM_UI.getValue(), Boolean.TRUE);
    }

    public final void setTestZone() {
        if (HiveLifecycle.INSTANCE.isSdkSetup()) {
            LoggerImpl.INSTANCE.w("[Configuration] SDK has already been initialized. Zone can no longer be set.");
        } else {
            set_zone(HiveZoneType.TEST);
            mapChangedByAPI.put(ConfigKeys.ZONE.getValue(), Boolean.TRUE);
        }
    }

    public final void setTrackers(JSONArray value) {
        Intrinsics.checkNotNullParameter(value, "value");
        trackersJsonArray = value;
        mapChangedByAPI.put(ConfigKeys.TRACKERS.getValue(), Boolean.TRUE);
    }

    public final void setUseGoogleCredentialSignIn(boolean enable) {
        useGoogleCredentialSignIn = enable;
    }

    public final void setUseHercules(boolean value) {
        set_useHercules(value);
    }

    public final void setUseLog(boolean value) {
        set_useLog(value);
        mapChangedByAPI.put(ConfigKeys.USE_LOG.getValue(), Boolean.TRUE);
    }

    public final void setVKAppId(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        _vkAppId = appId;
        mapChangedByAPI.put(ConfigKeys.VKAPP_ID.getValue(), Boolean.TRUE);
    }

    public final void setWechatAppId(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        _wechatAppId = appId;
        mapChangedByAPI.put(ConfigKeys.WECHATAPP_ID.getValue(), Boolean.TRUE);
    }

    public final void setWechatAppSecret(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        _wechatAppSecret = value;
        mapChangedByAPI.put(ConfigKeys.WECHATAPP_SECRET.getValue(), Boolean.TRUE);
    }

    public final void setWechatPaymentKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        _wechatPaymentKey = key;
        mapChangedByAPI.put(ConfigKeys.WECHATPAYMENT_KEY.getValue(), Boolean.TRUE);
    }

    public final void setZone(HiveZoneType zoneType) {
        Intrinsics.checkNotNullParameter(zoneType, "zoneType");
        if (HiveLifecycle.INSTANCE.isSdkSetup()) {
            LoggerImpl.INSTANCE.w("[Configuration] SDK has already been initialized. Zone can no longer be set.");
        } else {
            set_zone(zoneType);
            mapChangedByAPI.put(ConfigKeys.ZONE.getValue(), Boolean.TRUE);
        }
    }

    public final Map<String, Object> toMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String value = ConfigKeys.AGE_GATE_U13.getValue();
        ConfigurationImpl configurationImpl = INSTANCE;
        linkedHashMap.put(value, String.valueOf(configurationImpl.get_ageGateU13()));
        linkedHashMap.put(ConfigKeys.APP_ID.getValue(), configurationImpl.getAppId());
        linkedHashMap.put(ConfigKeys.COMPANY.getValue(), configurationImpl.get_company());
        linkedHashMap.put(ConfigKeys.COMPANY_INDEX.getValue(), Integer.valueOf(configurationImpl.get_companyIndex()));
        linkedHashMap.put(ConfigKeys.CHANNEL.getValue(), configurationImpl.get_channel());
        linkedHashMap.put(ConfigKeys.CROSS_PROMOTION_BANNER_SHOWING.getValue(), Boolean.valueOf(configurationImpl.get_crossPromotionBannerShowing()));
        linkedHashMap.put(ConfigKeys.FACEBOOK_PERMISSIONS.getValue(), _facebookPermissions);
        linkedHashMap.put(ConfigKeys.GAME_LANGUAGE.getValue(), configurationImpl.getHiveLanguage());
        linkedHashMap.put(ConfigKeys.GOOGLE_SERVER_CLIENT_ID.getValue(), _googleServerClientId);
        linkedHashMap.put(ConfigKeys.HIVE_ORIENTATION.getValue(), configurationImpl.get_hiveOrientation());
        linkedHashMap.put(ConfigKeys.HIVE_PERMISSSION_VIEW_ON.getValue(), Boolean.valueOf(_hivePermissionViewOn));
        linkedHashMap.put(ConfigKeys.HTTP_CONNECT_TIMEOUT.getValue(), String.valueOf(configurationImpl.get_httpConnectTimeout()));
        linkedHashMap.put(ConfigKeys.HTTP_READ_TIMEOUT.getValue(), String.valueOf(configurationImpl.get_httpReadTimeout()));
        linkedHashMap.put(ConfigKeys.MARKET.getValue(), configurationImpl.get_market());
        linkedHashMap.put(ConfigKeys.MAX_GAMELOG_SIZE.getValue(), String.valueOf(_maxGameLogSize));
        linkedHashMap.put(ConfigKeys.PERMISSIONS.getValue(), configurationImpl.getPermissions());
        linkedHashMap.put(ConfigKeys.QQAPP_ID.getValue(), _qqAppId);
        linkedHashMap.put(ConfigKeys.SERVER_ID.getValue(), configurationImpl.get_serverId());
        linkedHashMap.put(ConfigKeys.SYSTEM_UI.getValue(), String.valueOf(Util.INSTANCE.getSystemUI()));
        linkedHashMap.put(ConfigKeys.TRACKERS.getValue(), trackersJsonArray);
        linkedHashMap.put(ConfigKeys.USE_LOG.getValue(), String.valueOf(configurationImpl.get_useLog()));
        linkedHashMap.put(ConfigKeys.VKAPP_ID.getValue(), _vkAppId);
        linkedHashMap.put(ConfigKeys.WECHATAPP_ID.getValue(), _wechatAppId);
        linkedHashMap.put(ConfigKeys.WECHATAPP_SECRET.getValue(), _wechatAppSecret);
        linkedHashMap.put(ConfigKeys.WECHATPAYMENT_KEY.getValue(), _wechatPaymentKey);
        linkedHashMap.put(ConfigKeys.ZONE.getValue(), configurationImpl.get_zone().name());
        linkedHashMap.put(ConfigKeys.SIGN_IN_APPLE_SERVICE_ID.getValue(), _signInAppleServiceId);
        linkedHashMap.put(ConfigKeys.AUTH_V1_AGREEMENT.getValue(), Boolean.valueOf(_authV1Agreement));
        linkedHashMap.put(ConfigKeys.HIVE_COMMUNITY_URL.getValue(), configurationImpl.get_hiveCommunityUrl());
        linkedHashMap.put(ConfigKeys.AGREEMENT_DETERMINE_BASE.getValue(), configurationImpl.get_agreementDetermineBase());
        return linkedHashMap;
    }

    public final boolean getAgeGateU13(String hwIdsKey) {
        HashMap<String, Boolean> hwIds = Android.INSTANCE.getHwIds();
        if (getAgeGateU13()) {
            return true;
        }
        if (hwIdsKey == null || StringsKt.isBlank(hwIdsKey) || !hwIds.containsKey(hwIdsKey)) {
            return false;
        }
        Boolean bool = hwIds.get(hwIdsKey);
        return bool == null || !bool.booleanValue();
    }

    private final boolean parseXmlConfigurationFile(Context context, String filename) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        if (context == null) {
            Log.e(Const.TAG, "context is null, Call to com.hive.Configuration.setContext() on Activity.onCreate()");
            return false;
        }
        Resource resource = Resource.INSTANCE;
        InputStream inputStreamOpenRawResource$default = Resource.openRawResource$default(resource, context, filename, null, 4, null);
        if (inputStreamOpenRawResource$default == null) {
            Log.e(Const.TAG, filename + " file not found!");
            return false;
        }
        JSONObject xmlToJSON = resource.readXmlToJSON(inputStreamOpenRawResource$default);
        if (xmlToJSON == null) {
            Log.e(Const.TAG, "hive_config.xml file is invalid format!");
            return false;
        }
        try {
            JSONObject jSONObject = xmlToJSON.getJSONObject("properties");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.dL(Const.TAG, "[hiveConfigProperties] : \n" + jSONObject.toString(4));
            Intrinsics.checkNotNullExpressionValue(jSONObject, "also(...)");
            hiveConfigProperties = jSONObject;
            Property.Companion companion = Property.INSTANCE;
            setProvidersWithTracker("Singular", companion.getINSTANCE().getValue("trackerSDKV1Singular"));
            setProvidersWithTracker(Constants.LOGTAG, companion.getINSTANCE().getValue("trackerSDKV1Adjust"));
            setProvidersWithTracker("AppsFlyer", companion.getINSTANCE().getValue("trackerSDKV1AppsFlyer"));
            Map<String, Boolean> map = mapChangedByAPI;
            ConfigKeys configKeys = ConfigKeys.APP_ID;
            Boolean bool = map.get(configKeys.getValue());
            Boolean bool2 = Boolean.FALSE;
            if (Intrinsics.areEqual(bool, bool2)) {
                String strOptString = jSONObject.optString(configKeys.getValue(), com.hive.core.Configuration.INSTANCE.getAppId());
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                set_appId(strOptString);
            }
            Map<String, Boolean> map2 = mapChangedByAPI;
            ConfigKeys configKeys2 = ConfigKeys.ZONE;
            if (Intrinsics.areEqual(map2.get(configKeys2.getValue()), bool2)) {
                loggerImpl.w("[Configuration] From version 26.0.0, <zone> in hive_config.xml is no longer supported. Use Configuration.class setZone() API instead.");
                String strOptString2 = jSONObject.optString(configKeys2.getValue(), HiveZoneType.REAL.getValue());
                Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String upperCase = strOptString2.toUpperCase(US);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                set_zone(HiveZoneType.valueOf(upperCase));
            }
            Map<String, Boolean> map3 = mapChangedByAPI;
            ConfigKeys configKeys3 = ConfigKeys.USE_LOG;
            if (Intrinsics.areEqual(map3.get(configKeys3.getValue()), bool2)) {
                set_useLog(jSONObject.optBoolean(configKeys3.getValue(), false));
            }
            Map<String, Boolean> map4 = mapChangedByAPI;
            ConfigKeys configKeys4 = ConfigKeys.AGE_GATE_U13;
            if (Intrinsics.areEqual(map4.get(configKeys4.getValue()), bool2) && com.hive.core.Configuration.INSTANCE.getRawValueAgeGateU13() == null) {
                set_ageGateU13(jSONObject.optBoolean(configKeys4.getValue(), false));
            }
            Map<String, Boolean> map5 = mapChangedByAPI;
            ConfigKeys configKeys5 = ConfigKeys.SERVER_ID;
            if (Intrinsics.areEqual(map5.get(configKeys5.getValue()), bool2)) {
                String strOptString3 = jSONObject.optString(configKeys5.getValue(), "");
                Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                set_serverId(strOptString3);
            }
            Map<String, Boolean> map6 = mapChangedByAPI;
            ConfigKeys configKeys6 = ConfigKeys.PERMISSIONS;
            if (Intrinsics.areEqual(map6.get(configKeys6.getValue()), bool2)) {
                HashMap map7 = new HashMap();
                _permissions = map7;
                Configuration.HIVEPermissionType hIVEPermissionType = Configuration.HIVEPermissionType.SDWRITE;
                map7.put(hIVEPermissionType, bool2);
                JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject(configKeys6.getValue());
                if (jSONObjectOptJSONObject3 != null) {
                    map7.put(hIVEPermissionType, Boolean.valueOf(Intrinsics.areEqual("true", jSONObjectOptJSONObject3.optString(hIVEPermissionType.getValue(), "false"))));
                }
            }
            Map<String, Boolean> map8 = mapChangedByAPI;
            ConfigKeys configKeys7 = ConfigKeys.COMPANY;
            if (Intrinsics.areEqual(map8.get(configKeys7.getValue()), bool2)) {
                String strOptString4 = jSONObject.optString(configKeys7.getValue(), "C2S");
                Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                set_company(strOptString4);
            }
            Map<String, Boolean> map9 = mapChangedByAPI;
            ConfigKeys configKeys8 = ConfigKeys.COMPANY_INDEX;
            if (Intrinsics.areEqual(map9.get(configKeys8.getValue()), bool2)) {
                set_companyIndex(jSONObject.optInt(configKeys8.getValue(), 1));
            }
            Map<String, Boolean> map10 = mapChangedByAPI;
            ConfigKeys configKeys9 = ConfigKeys.CHANNEL;
            if (Intrinsics.areEqual(map10.get(configKeys9.getValue()), bool2)) {
                String strOptString5 = jSONObject.optString(configKeys9.getValue(), "C2S");
                Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
                set_channel(strOptString5);
            }
            Map<String, Boolean> map11 = mapChangedByAPI;
            ConfigKeys configKeys10 = ConfigKeys.MARKET;
            if (Intrinsics.areEqual(map11.get(configKeys10.getValue()), bool2)) {
                String strOptString6 = jSONObject.optString(configKeys10.getValue(), "");
                Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
                set_market(strOptString6);
            }
            Map<String, Boolean> map12 = mapChangedByAPI;
            ConfigKeys configKeys11 = ConfigKeys.HIVE_ORIENTATION;
            if (Intrinsics.areEqual(map12.get(configKeys11.getValue()), bool2)) {
                String strOptString7 = jSONObject.optString(configKeys11.getValue());
                HiveOrientation.Companion companion2 = HiveOrientation.INSTANCE;
                Intrinsics.checkNotNull(strOptString7);
                set_hiveOrientation(companion2.getEnum(strOptString7));
            }
            Map<String, Boolean> map13 = mapChangedByAPI;
            ConfigKeys configKeys12 = ConfigKeys.AUTH_V1_AGREEMENT;
            if (Intrinsics.areEqual(map13.get(configKeys12.getValue()), bool2)) {
                _authV1Agreement = jSONObject.optBoolean(configKeys12.getValue(), true);
            }
            Map<String, Boolean> map14 = mapChangedByAPI;
            ConfigKeys configKeys13 = ConfigKeys.HTTP_CONNECT_TIMEOUT;
            if (Intrinsics.areEqual(map14.get(configKeys13.getValue()), bool2)) {
                set_httpConnectTimeout(jSONObject.optInt(configKeys13.getValue(), 8));
            }
            Map<String, Boolean> map15 = mapChangedByAPI;
            ConfigKeys configKeys14 = ConfigKeys.HTTP_READ_TIMEOUT;
            if (Intrinsics.areEqual(map15.get(configKeys14.getValue()), bool2)) {
                set_httpReadTimeout(jSONObject.optInt(configKeys14.getValue(), 8));
            }
            Map<String, Boolean> map16 = mapChangedByAPI;
            ConfigKeys configKeys15 = ConfigKeys.MAX_GAMELOG_SIZE;
            if (Intrinsics.areEqual(map16.get(configKeys15.getValue()), bool2)) {
                _maxGameLogSize = jSONObject.optInt(configKeys15.getValue(), 50);
            }
            Map<String, Boolean> map17 = mapChangedByAPI;
            ConfigKeys configKeys16 = ConfigKeys.FACEBOOK_PERMISSIONS;
            if (Intrinsics.areEqual(map17.get(configKeys16.getValue()), bool2)) {
                JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject(configKeys16.getValue());
                if (!jSONObject.has(configKeys16.getValue())) {
                    _facebookPermissions = null;
                } else {
                    ArrayList arrayList = new ArrayList();
                    if (jSONObjectOptJSONObject4 != null) {
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject4.optJSONArray("value");
                        if (jSONArrayOptJSONArray == null) {
                            jSONArrayOptJSONArray = new JSONArray();
                            if (jSONObjectOptJSONObject4.has("value")) {
                                jSONArrayOptJSONArray.put(jSONObjectOptJSONObject4.optString("value"));
                            }
                        }
                        int length = jSONArrayOptJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            arrayList.add(jSONArrayOptJSONArray.optString(i));
                        }
                    }
                    _facebookPermissions = arrayList;
                }
            }
            Map<String, Boolean> map18 = mapChangedByAPI;
            ConfigKeys configKeys17 = ConfigKeys.TRACKERS;
            Boolean bool3 = map18.get(configKeys17.getValue());
            Boolean bool4 = Boolean.FALSE;
            if (Intrinsics.areEqual(bool3, bool4) && (jSONObjectOptJSONObject2 = jSONObject.optJSONObject(configKeys17.getValue())) != null) {
                ConfigKeys configKeys18 = ConfigKeys.TRACKER;
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray(configKeys18.getValue());
                if (jSONArrayOptJSONArray2 != null) {
                    trackersJsonArray = jSONArrayOptJSONArray2;
                } else if (jSONObjectOptJSONObject2.has(configKeys18.getValue())) {
                    JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject2.optJSONObject(configKeys18.getValue());
                    JSONArray jSONArray = new JSONArray();
                    trackersJsonArray = jSONArray;
                    jSONArray.put(jSONObjectOptJSONObject5);
                }
            }
            Map<String, Boolean> map19 = mapChangedByAPI;
            ConfigKeys configKeys19 = ConfigKeys.QQAPP_ID;
            if (Intrinsics.areEqual(map19.get(configKeys19.getValue()), bool4)) {
                _qqAppId = Android.INSTANCE.jsonOptString(jSONObject, configKeys19.getValue(), getQQAppId());
            }
            Map<String, Boolean> map20 = mapChangedByAPI;
            ConfigKeys configKeys20 = ConfigKeys.VKAPP_ID;
            if (Intrinsics.areEqual(map20.get(configKeys20.getValue()), bool4)) {
                _vkAppId = Android.INSTANCE.jsonOptString(jSONObject, configKeys20.getValue(), getVKAppId());
            }
            Map<String, Boolean> map21 = mapChangedByAPI;
            ConfigKeys configKeys21 = ConfigKeys.WECHATAPP_ID;
            if (Intrinsics.areEqual(map21.get(configKeys21.getValue()), bool4)) {
                _wechatAppId = Android.INSTANCE.jsonOptString(jSONObject, configKeys21.getValue(), getWechatAppId());
            }
            Map<String, Boolean> map22 = mapChangedByAPI;
            ConfigKeys configKeys22 = ConfigKeys.WECHATAPP_SECRET;
            if (Intrinsics.areEqual(map22.get(configKeys22.getValue()), bool4)) {
                _wechatAppSecret = Android.INSTANCE.jsonOptString(jSONObject, configKeys22.getValue(), getWechatAppSecret());
            }
            Map<String, Boolean> map23 = mapChangedByAPI;
            ConfigKeys configKeys23 = ConfigKeys.WECHATPAYMENT_KEY;
            if (Intrinsics.areEqual(map23.get(configKeys23.getValue()), bool4)) {
                _wechatPaymentKey = Android.INSTANCE.jsonOptString(jSONObject, configKeys23.getValue(), getWechatPaymentKey());
            }
            Map<String, Boolean> map24 = mapChangedByAPI;
            ConfigKeys configKeys24 = ConfigKeys.GOOGLE_SERVER_CLIENT_ID;
            if (Intrinsics.areEqual(map24.get(configKeys24.getValue()), bool4)) {
                _googleServerClientId = Android.INSTANCE.jsonOptString(jSONObject, configKeys24.getValue(), getGoogleServerClientId());
            }
            Map<String, Boolean> map25 = mapChangedByAPI;
            ConfigKeys configKeys25 = ConfigKeys.SIGN_IN_APPLE_SERVICE_ID;
            if (Intrinsics.areEqual(map25.get(configKeys25.getValue()), bool4)) {
                _signInAppleServiceId = Android.INSTANCE.jsonOptString(jSONObject, configKeys25.getValue(), getSignInAppleServiceId());
            }
            Map<String, Boolean> map26 = mapChangedByAPI;
            ConfigKeys configKeys26 = ConfigKeys.SYSTEM_UI;
            if (Intrinsics.areEqual(map26.get(configKeys26.getValue()), bool4)) {
                Util.INSTANCE.setSystemUI(jSONObject.optInt(configKeys26.getValue(), 0));
            }
            Map<String, Boolean> map27 = mapChangedByAPI;
            ConfigKeys configKeys27 = ConfigKeys.HIVE_PERMISSSION_VIEW_ON;
            if (Intrinsics.areEqual(map27.get(configKeys27.getValue()), bool4)) {
                _hivePermissionViewOn = jSONObject.optBoolean(configKeys27.getValue(), true);
            }
            Map<String, Boolean> map28 = mapChangedByAPI;
            ConfigKeys configKeys28 = ConfigKeys.HIVE_COMMUNITY_URL;
            if (Intrinsics.areEqual(map28.get(configKeys28.getValue()), bool4)) {
                set_hiveCommunityUrl(Android.INSTANCE.jsonOptString(jSONObject, configKeys28.getValue(), getHiveCommunityUrl()));
            }
            Map<String, Boolean> map29 = mapChangedByAPI;
            ConfigKeys configKeys29 = ConfigKeys.AGREEMENT_DETERMINE_BASE;
            if (Intrinsics.areEqual(map29.get(configKeys29.getValue()), bool4)) {
                set_agreementDetermineBase(Android.INSTANCE.jsonOptString(jSONObject, configKeys29.getValue(), getAgreementDetermineBase()));
            }
            Map<String, Boolean> map30 = mapChangedByAPI;
            ConfigKeys configKeys30 = ConfigKeys.UNSUPPORTED_UA_SHARE_TYPE;
            if (Intrinsics.areEqual(map30.get(configKeys30.getValue()), bool4) && (jSONObjectOptJSONObject = jSONObject.optJSONObject(configKeys30.getValue())) != null) {
                JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("value");
                if (jSONArrayOptJSONArray3 == null) {
                    jSONArrayOptJSONArray3 = new JSONArray();
                    String strOptString8 = jSONObjectOptJSONObject.optString("value");
                    Intrinsics.checkNotNull(strOptString8);
                    if (!StringsKt.isBlank(strOptString8)) {
                        jSONArrayOptJSONArray3.put(strOptString8);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                int length2 = jSONArrayOptJSONArray3.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String strOptString9 = jSONArrayOptJSONArray3.optString(i2);
                    Intrinsics.checkNotNullExpressionValue(strOptString9, "optString(...)");
                    String upperCase2 = strOptString9.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                    arrayList2.add(upperCase2);
                }
                INSTANCE.set_unsupportedUAShareType(arrayList2);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
