package io.ktor.client.plugins.sse;

import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.URLParserKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: compiled from: builders.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0010\u001a.\u0010\u0006\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001aQ\u0010\u0013\u001a\u00020\u0010*\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0083\u0001\u0010\u0013\u001a\u00020\u0010*\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b\u001a\u0010\u001b\u001a[\u0010\u0013\u001a\u00020\u0010*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00142\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b\u001d\u0010\u001e\u001az\u0010%\u001a\u00020\u0003*\u00020\b2\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b#\u0010$\u001a¬\u0001\u0010%\u001a\u00020\u0003*\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b&\u0010'\u001a\u0084\u0001\u0010%\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00142\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b(\u0010)\u001aQ\u0010+\u001a\u00020\u0010*\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b*\u0010\u0012\u001a\u0083\u0001\u0010+\u001a\u00020\u0010*\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b,\u0010\u001b\u001a[\u0010+\u001a\u00020\u0010*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00142\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b-\u0010\u001e\u001az\u0010/\u001a\u00020\u0003*\u00020\b2\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b.\u0010$\u001a¬\u0001\u0010/\u001a\u00020\u0003*\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b0\u00101\u001a\u0084\u0001\u0010/\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00142\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b2\u00103\u001am\u0010\u0013\u001a\u000206*\u00020\b2\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b\u001d\u00107\u001a\u009f\u0001\u0010\u0013\u001a\u000206*\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b8\u00109\u001aw\u0010\u0013\u001a\u000206*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00142\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b:\u0010;\u001a\u0096\u0001\u0010%\u001a\u00020\u0003*\u00020\b2\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u000206\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b<\u0010=\u001aÈ\u0001\u0010%\u001a\u00020\u0003*\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u000206\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b>\u0010?\u001a \u0001\u0010%\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00142\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u000206\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b@\u0010A\u001am\u0010+\u001a\u000206*\u00020\b2\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b-\u00107\u001a\u009f\u0001\u0010+\u001a\u000206*\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\bB\u00109\u001aw\u0010+\u001a\u000206*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00142\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\bC\u0010;\u001a\u0096\u0001\u0010/\u001a\u00020\u0003*\u00020\b2\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u000206\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b2\u0010=\u001aÈ\u0001\u0010/\u001a\u00020\u0003*\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u000206\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\bD\u0010E\u001a \u0001\u0010/\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00142\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\u001a\u00105\u001a\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u000206\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\bF\u0010G\u001al\u0010L\u001a\u00028\u0000\"\u0006\b\u0000\u0010H\u0018\u0001*\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\u0017\u0010I\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0082H¢\u0006\u0004\bJ\u0010K\u001a5\u0010P\u001a\u00020\u0003\"\b\b\u0000\u0010H*\u00020\"*\u00020\u000e2\f\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000M2\b\u0010O\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\bP\u0010Q\u001a!\u0010V\u001a\u00020T2\b\u0010S\u001a\u0004\u0018\u00010R2\u0006\u0010U\u001a\u00020TH\u0002¢\u0006\u0004\bV\u0010W\" \u0010X\u001a\b\u0012\u0004\u0012\u00020\u000b0M8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\" \u0010\\\u001a\b\u0012\u0004\u0012\u00020\t0M8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\\\u0010Y\u001a\u0004\b]\u0010[\" \u0010^\u001a\b\u0012\u0004\u0012\u00020\u000b0M8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b^\u0010Y\u001a\u0004\b_\u0010[\" \u0010`\u001a\b\u0012\u0004\u0012\u00020\u000b0M8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b`\u0010Y\u001a\u0004\ba\u0010[\"4\u0010b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\"0 0M8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bb\u0010Y\u001a\u0004\bc\u0010[¨\u0006d"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/sse/SSEConfig;", "", "Lkotlin/ExtensionFunctionType;", "config", "SSE", "(Lio/ktor/client/HttpClientConfig;Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/client/HttpClient;", "Lkotlin/time/Duration;", "reconnectionTime", "", "showCommentEvents", "showRetryEvents", "Lio/ktor/client/request/HttpRequestBuilder;", "block", "Lio/ktor/client/plugins/sse/ClientSSESession;", "serverSentEventsSession-i8z2VEo", "(Lio/ktor/client/HttpClient;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEventsSession", "", "scheme", "host", "", "port", "path", "serverSentEventsSession-xEWcMm4", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urlString", "serverSentEventsSession-mY9Nd3A", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "request", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "serverSentEvents-mY9Nd3A", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEvents", "serverSentEvents-1wIb-0I", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEvents-3bFjkrY", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sseSession-i8z2VEo", "sseSession", "sseSession-xEWcMm4", "sseSession-mY9Nd3A", "sse-mY9Nd3A", "sse", "sse-tL6_L-A", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sse-Mswn-_c", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/util/reflect/TypeInfo;", "deserialize", "Lio/ktor/client/plugins/sse/ClientSSESessionWithDeserialization;", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEventsSession-tL6_L-A", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEventsSession-Mswn-_c", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEvents-Mswn-_c", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEvents-BqdlHlk", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEvents-pTj2aPc", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sseSession-tL6_L-A", "sseSession-Mswn-_c", "sse-BAHpl2s", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sse-Q9yt8Vw", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "additionalAttributes", "processSession-rp2poPw", "(Lio/ktor/client/HttpClient;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processSession", "Lio/ktor/util/AttributeKey;", "attributeKey", "value", "addAttribute", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/util/AttributeKey;Ljava/lang/Object;)V", "Lio/ktor/client/statement/HttpResponse;", "response", "", "cause", "mapToSSEException", "(Lio/ktor/client/statement/HttpResponse;Ljava/lang/Throwable;)Ljava/lang/Throwable;", "sseRequestAttr", "Lio/ktor/util/AttributeKey;", "getSseRequestAttr", "()Lio/ktor/util/AttributeKey;", "reconnectionTimeAttr", "getReconnectionTimeAttr", "showCommentEventsAttr", "getShowCommentEventsAttr", "showRetryEventsAttr", "getShowRetryEventsAttr", "deserializerAttr", "getDeserializerAttr", "ktor-client-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class BuildersKt {
    private static final AttributeKey<Function2<TypeInfo, String, Object>> deserializerAttr;
    private static final AttributeKey<Duration> reconnectionTimeAttr;
    private static final AttributeKey<Boolean> showCommentEventsAttr;
    private static final AttributeKey<Boolean> showRetryEventsAttr;
    private static final AttributeKey<Boolean> sseRequestAttr;

    public static final AttributeKey<Boolean> getSseRequestAttr() {
        return sseRequestAttr;
    }

    public static final AttributeKey<Duration> getReconnectionTimeAttr() {
        return reconnectionTimeAttr;
    }

    public static final AttributeKey<Boolean> getShowCommentEventsAttr() {
        return showCommentEventsAttr;
    }

    public static final AttributeKey<Boolean> getShowRetryEventsAttr() {
        return showRetryEventsAttr;
    }

    public static final AttributeKey<Function2<TypeInfo, String, Object>> getDeserializerAttr() {
        return deserializerAttr;
    }

    public static final void SSE(HttpClientConfig<?> httpClientConfig, final Function1<? super SSEConfig, Unit> config) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        Intrinsics.checkNotNullParameter(config, "config");
        httpClientConfig.install(SSEKt.getSSE(), new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BuildersKt.SSE$lambda$0(config, (SSEConfig) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SSE$lambda$0(Function1 function1, SSEConfig install) {
        Intrinsics.checkNotNullParameter(install, "$this$install");
        function1.invoke(install);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEventsSession_xEWcMm4$lambda$2(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEventsSession-xEWcMm4, reason: not valid java name */
    public static final Object m7261serverSentEventsSessionxEWcMm4(HttpClient httpClient, final String str, final String str2, final Integer num, final String str3, Duration duration, Boolean bool, Boolean bool2, final Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESession> continuation) {
        return m7253serverSentEventsSessioni8z2VEo(httpClient, duration, bool, bool2, new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEventsSession_xEWcMm4$lambda$3(str, str2, num, str3, function1, (HttpRequestBuilder) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEventsSession_xEWcMm4$lambda$3(String str, String str2, Integer num, String str3, Function1 function1, HttpRequestBuilder serverSentEventsSession) {
        Intrinsics.checkNotNullParameter(serverSentEventsSession, "$this$serverSentEventsSession");
        HttpRequestKt.url$default(serverSentEventsSession, str, str2, num, str3, null, 16, null);
        function1.invoke(serverSentEventsSession);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEventsSession_mY9Nd3A$lambda$4(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEventsSession-mY9Nd3A, reason: not valid java name */
    public static final Object m7255serverSentEventsSessionmY9Nd3A(HttpClient httpClient, final String str, Duration duration, Boolean bool, Boolean bool2, final Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESession> continuation) {
        return m7253serverSentEventsSessioni8z2VEo(httpClient, duration, bool, bool2, new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEventsSession_mY9Nd3A$lambda$5(str, function1, (HttpRequestBuilder) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEventsSession_mY9Nd3A$lambda$5(String str, Function1 function1, HttpRequestBuilder serverSentEventsSession) {
        Intrinsics.checkNotNullParameter(serverSentEventsSession, "$this$serverSentEventsSession");
        URLParserKt.takeFrom(serverSentEventsSession.getUrl(), str);
        function1.invoke(serverSentEventsSession);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX INFO: renamed from: serverSentEvents-mY9Nd3A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m7247serverSentEventsmY9Nd3A(io.ktor.client.HttpClient r13, kotlin.jvm.functions.Function1<? super io.ktor.client.request.HttpRequestBuilder, kotlin.Unit> r14, kotlin.time.Duration r15, java.lang.Boolean r16, java.lang.Boolean r17, kotlin.jvm.functions.Function2<? super io.ktor.client.plugins.sse.ClientSSESession, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) throws java.lang.Throwable {
        /*
            r0 = r19
            boolean r1 = r0 instanceof io.ktor.client.plugins.sse.BuildersKt$serverSentEvents$1
            if (r1 == 0) goto L16
            r1 = r0
            io.ktor.client.plugins.sse.BuildersKt$serverSentEvents$1 r1 = (io.ktor.client.plugins.sse.BuildersKt$serverSentEvents$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L16
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L1b
        L16:
            io.ktor.client.plugins.sse.BuildersKt$serverSentEvents$1 r1 = new io.ktor.client.plugins.sse.BuildersKt$serverSentEvents$1
            r1.<init>(r0)
        L1b:
            java.lang.Object r0 = r1.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r9 = 2
            r10 = 0
            r11 = 1
            if (r2 == 0) goto L4b
            if (r2 == r11) goto L40
            if (r2 != r9) goto L38
            java.lang.Object r1 = r1.L$0
            io.ktor.client.plugins.sse.ClientSSESession r1 = (io.ktor.client.plugins.sse.ClientSSESession) r1
            kotlin.ResultKt.throwOnFailure(r0)     // Catch: java.lang.Throwable -> L34 java.util.concurrent.CancellationException -> L36
            goto L71
        L34:
            r0 = move-exception
            goto L7b
        L36:
            r0 = move-exception
            goto L8a
        L38:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L40:
            java.lang.Object r2 = r1.L$0
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            kotlin.ResultKt.throwOnFailure(r0)
            r12 = r2
            r2 = r0
            r0 = r12
            goto L63
        L4b:
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = r18
            r1.L$0 = r0
            r1.label = r11
            r2 = r13
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r14
            r7 = r1
            java.lang.Object r2 = m7253serverSentEventsSessioni8z2VEo(r2, r3, r4, r5, r6, r7)
            if (r2 != r8) goto L63
            return r8
        L63:
            io.ktor.client.plugins.sse.ClientSSESession r2 = (io.ktor.client.plugins.sse.ClientSSESession) r2
            r1.L$0 = r2     // Catch: java.lang.Throwable -> L79 java.util.concurrent.CancellationException -> L88
            r1.label = r9     // Catch: java.lang.Throwable -> L79 java.util.concurrent.CancellationException -> L88
            java.lang.Object r0 = r0.invoke(r2, r1)     // Catch: java.lang.Throwable -> L79 java.util.concurrent.CancellationException -> L88
            if (r0 != r8) goto L70
            return r8
        L70:
            r1 = r2
        L71:
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlinx.coroutines.CoroutineScopeKt.cancel$default(r1, r10, r11, r10)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L79:
            r0 = move-exception
            r1 = r2
        L7b:
            io.ktor.client.call.HttpClientCall r2 = r1.getCall()     // Catch: java.lang.Throwable -> L8b
            io.ktor.client.statement.HttpResponse r2 = r2.getResponse()     // Catch: java.lang.Throwable -> L8b
            java.lang.Throwable r0 = mapToSSEException(r2, r0)     // Catch: java.lang.Throwable -> L8b
            throw r0     // Catch: java.lang.Throwable -> L8b
        L88:
            r0 = move-exception
            r1 = r2
        L8a:
            throw r0     // Catch: java.lang.Throwable -> L8b
        L8b:
            r0 = move-exception
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlinx.coroutines.CoroutineScopeKt.cancel$default(r1, r10, r11, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.sse.BuildersKt.m7247serverSentEventsmY9Nd3A(io.ktor.client.HttpClient, kotlin.jvm.functions.Function1, kotlin.time.Duration, java.lang.Boolean, java.lang.Boolean, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEvents_1wIb_0I$lambda$6(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEvents-1wIb-0I, reason: not valid java name */
    public static final Object m7239serverSentEvents1wIb0I(HttpClient httpClient, final String str, final String str2, final Integer num, final String str3, Duration duration, Boolean bool, Boolean bool2, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super ClientSSESession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        Object objM7247serverSentEventsmY9Nd3A = m7247serverSentEventsmY9Nd3A(httpClient, new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEvents_1wIb_0I$lambda$7(str, str2, num, str3, function1, (HttpRequestBuilder) obj);
            }
        }, duration, bool, bool2, function2, continuation);
        return objM7247serverSentEventsmY9Nd3A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM7247serverSentEventsmY9Nd3A : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEvents_1wIb_0I$lambda$7(String str, String str2, Integer num, String str3, Function1 function1, HttpRequestBuilder serverSentEvents) {
        Intrinsics.checkNotNullParameter(serverSentEvents, "$this$serverSentEvents");
        HttpRequestKt.url$default(serverSentEvents, str, str2, num, str3, null, 16, null);
        function1.invoke(serverSentEvents);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEvents_3bFjkrY$lambda$8(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEvents-3bFjkrY, reason: not valid java name */
    public static final Object m7241serverSentEvents3bFjkrY(HttpClient httpClient, final String str, Duration duration, Boolean bool, Boolean bool2, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super ClientSSESession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        Object objM7247serverSentEventsmY9Nd3A = m7247serverSentEventsmY9Nd3A(httpClient, new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEvents_3bFjkrY$lambda$9(str, function1, (HttpRequestBuilder) obj);
            }
        }, duration, bool, bool2, function2, continuation);
        return objM7247serverSentEventsmY9Nd3A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM7247serverSentEventsmY9Nd3A : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEvents_3bFjkrY$lambda$9(String str, Function1 function1, HttpRequestBuilder serverSentEvents) {
        Intrinsics.checkNotNullParameter(serverSentEvents, "$this$serverSentEvents");
        URLParserKt.takeFrom(serverSentEvents.getUrl(), str);
        function1.invoke(serverSentEvents);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sseSession-i8z2VEo, reason: not valid java name */
    public static final Object m7277sseSessioni8z2VEo(HttpClient httpClient, Duration duration, Boolean bool, Boolean bool2, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESession> continuation) {
        return m7253serverSentEventsSessioni8z2VEo(httpClient, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sseSession_xEWcMm4$lambda$10(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sseSession-xEWcMm4, reason: not valid java name */
    public static final Object m7285sseSessionxEWcMm4(HttpClient httpClient, String str, String str2, Integer num, String str3, Duration duration, Boolean bool, Boolean bool2, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESession> continuation) {
        return m7261serverSentEventsSessionxEWcMm4(httpClient, str, str2, num, str3, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sseSession_mY9Nd3A$lambda$11(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sseSession-mY9Nd3A, reason: not valid java name */
    public static final Object m7279sseSessionmY9Nd3A(HttpClient httpClient, String str, Duration duration, Boolean bool, Boolean bool2, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESession> continuation) {
        return m7255serverSentEventsSessionmY9Nd3A(httpClient, str, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: sse-mY9Nd3A, reason: not valid java name */
    public static final Object m7271ssemY9Nd3A(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Duration duration, Boolean bool, Boolean bool2, Function2<? super ClientSSESession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        Object objM7247serverSentEventsmY9Nd3A = m7247serverSentEventsmY9Nd3A(httpClient, function1, duration, bool, bool2, function2, continuation);
        return objM7247serverSentEventsmY9Nd3A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM7247serverSentEventsmY9Nd3A : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sse_tL6_L_A$lambda$12(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sse-tL6_L-A, reason: not valid java name */
    public static final Object m7273ssetL6_LA(HttpClient httpClient, String str, String str2, Integer num, String str3, Function1<? super HttpRequestBuilder, Unit> function1, Duration duration, Boolean bool, Boolean bool2, Function2<? super ClientSSESession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        Object objM7239serverSentEvents1wIb0I = m7239serverSentEvents1wIb0I(httpClient, str, str2, num, str3, duration, bool, bool2, function1, function2, continuation);
        return objM7239serverSentEvents1wIb0I == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM7239serverSentEvents1wIb0I : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sse_Mswn__c$lambda$13(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sse-Mswn-_c, reason: not valid java name */
    public static final Object m7265sseMswn_c(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Duration duration, Boolean bool, Boolean bool2, Function2<? super ClientSSESession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        Object objM7241serverSentEvents3bFjkrY = m7241serverSentEvents3bFjkrY(httpClient, str, duration, bool, bool2, function1, function2, continuation);
        return objM7241serverSentEvents3bFjkrY == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM7241serverSentEvents3bFjkrY : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEventsSession_tL6_L_A$lambda$15(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEventsSession-tL6_L-A, reason: not valid java name */
    public static final Object m7259serverSentEventsSessiontL6_LA(HttpClient httpClient, final String str, final String str2, final Integer num, final String str3, Function2<? super TypeInfo, ? super String, ? extends Object> function2, Duration duration, Boolean bool, Boolean bool2, final Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESessionWithDeserialization> continuation) {
        return m7256serverSentEventsSessionmY9Nd3A(httpClient, function2, duration, bool, bool2, (Function1<? super HttpRequestBuilder, Unit>) new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEventsSession_tL6_L_A$lambda$16(str, str2, num, str3, function1, (HttpRequestBuilder) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEventsSession_tL6_L_A$lambda$16(String str, String str2, Integer num, String str3, Function1 function1, HttpRequestBuilder serverSentEventsSession) {
        Intrinsics.checkNotNullParameter(serverSentEventsSession, "$this$serverSentEventsSession");
        HttpRequestKt.url$default(serverSentEventsSession, str, str2, num, str3, null, 16, null);
        function1.invoke(serverSentEventsSession);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEventsSession_Mswn__c$lambda$17(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEventsSession-Mswn-_c, reason: not valid java name */
    public static final Object m7251serverSentEventsSessionMswn_c(HttpClient httpClient, final String str, Function2<? super TypeInfo, ? super String, ? extends Object> function2, Duration duration, Boolean bool, Boolean bool2, final Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESessionWithDeserialization> continuation) {
        return m7256serverSentEventsSessionmY9Nd3A(httpClient, function2, duration, bool, bool2, (Function1<? super HttpRequestBuilder, Unit>) new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEventsSession_Mswn__c$lambda$18(str, function1, (HttpRequestBuilder) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEventsSession_Mswn__c$lambda$18(String str, Function1 function1, HttpRequestBuilder serverSentEventsSession) {
        Intrinsics.checkNotNullParameter(serverSentEventsSession, "$this$serverSentEventsSession");
        URLParserKt.takeFrom(serverSentEventsSession.getUrl(), str);
        function1.invoke(serverSentEventsSession);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX INFO: renamed from: serverSentEvents-Mswn-_c, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m7245serverSentEventsMswn_c(io.ktor.client.HttpClient r14, kotlin.jvm.functions.Function1<? super io.ktor.client.request.HttpRequestBuilder, kotlin.Unit> r15, kotlin.jvm.functions.Function2<? super io.ktor.util.reflect.TypeInfo, ? super java.lang.String, ? extends java.lang.Object> r16, kotlin.time.Duration r17, java.lang.Boolean r18, java.lang.Boolean r19, kotlin.jvm.functions.Function2<? super io.ktor.client.plugins.sse.ClientSSESessionWithDeserialization, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) throws java.lang.Throwable {
        /*
            r0 = r21
            boolean r1 = r0 instanceof io.ktor.client.plugins.sse.BuildersKt$serverSentEvents$8
            if (r1 == 0) goto L16
            r1 = r0
            io.ktor.client.plugins.sse.BuildersKt$serverSentEvents$8 r1 = (io.ktor.client.plugins.sse.BuildersKt$serverSentEvents$8) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L16
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L1b
        L16:
            io.ktor.client.plugins.sse.BuildersKt$serverSentEvents$8 r1 = new io.ktor.client.plugins.sse.BuildersKt$serverSentEvents$8
            r1.<init>(r0)
        L1b:
            java.lang.Object r0 = r1.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r10 = 2
            r11 = 0
            r12 = 1
            if (r2 == 0) goto L4b
            if (r2 == r12) goto L40
            if (r2 != r10) goto L38
            java.lang.Object r1 = r1.L$0
            io.ktor.client.plugins.sse.ClientSSESessionWithDeserialization r1 = (io.ktor.client.plugins.sse.ClientSSESessionWithDeserialization) r1
            kotlin.ResultKt.throwOnFailure(r0)     // Catch: java.lang.Throwable -> L34 java.util.concurrent.CancellationException -> L36
            goto L74
        L34:
            r0 = move-exception
            goto L7e
        L36:
            r0 = move-exception
            goto L8d
        L38:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L40:
            java.lang.Object r2 = r1.L$0
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            kotlin.ResultKt.throwOnFailure(r0)
            r13 = r2
            r2 = r0
            r0 = r13
            goto L66
        L4b:
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = r20
            r1.L$0 = r0
            r1.label = r12
            r2 = r14
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r15
            r8 = r1
            java.lang.Object r2 = m7256serverSentEventsSessionmY9Nd3A(r2, r3, r4, r5, r6, r7, r8)
            if (r2 != r9) goto L66
            return r9
        L66:
            io.ktor.client.plugins.sse.ClientSSESessionWithDeserialization r2 = (io.ktor.client.plugins.sse.ClientSSESessionWithDeserialization) r2
            r1.L$0 = r2     // Catch: java.lang.Throwable -> L7c java.util.concurrent.CancellationException -> L8b
            r1.label = r10     // Catch: java.lang.Throwable -> L7c java.util.concurrent.CancellationException -> L8b
            java.lang.Object r0 = r0.invoke(r2, r1)     // Catch: java.lang.Throwable -> L7c java.util.concurrent.CancellationException -> L8b
            if (r0 != r9) goto L73
            return r9
        L73:
            r1 = r2
        L74:
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlinx.coroutines.CoroutineScopeKt.cancel$default(r1, r11, r12, r11)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L7c:
            r0 = move-exception
            r1 = r2
        L7e:
            io.ktor.client.call.HttpClientCall r2 = r1.getCall()     // Catch: java.lang.Throwable -> L8e
            io.ktor.client.statement.HttpResponse r2 = r2.getResponse()     // Catch: java.lang.Throwable -> L8e
            java.lang.Throwable r0 = mapToSSEException(r2, r0)     // Catch: java.lang.Throwable -> L8e
            throw r0     // Catch: java.lang.Throwable -> L8e
        L8b:
            r0 = move-exception
            r1 = r2
        L8d:
            throw r0     // Catch: java.lang.Throwable -> L8e
        L8e:
            r0 = move-exception
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlinx.coroutines.CoroutineScopeKt.cancel$default(r1, r11, r12, r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.sse.BuildersKt.m7245serverSentEventsMswn_c(io.ktor.client.HttpClient, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, kotlin.time.Duration, java.lang.Boolean, java.lang.Boolean, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEvents_BqdlHlk$lambda$19(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEvents-BqdlHlk, reason: not valid java name */
    public static final Object m7243serverSentEventsBqdlHlk(HttpClient httpClient, final String str, final String str2, final Integer num, final String str3, Function2<? super TypeInfo, ? super String, ? extends Object> function2, Duration duration, Boolean bool, Boolean bool2, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super ClientSSESessionWithDeserialization, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super Unit> continuation) throws Throwable {
        Object objM7245serverSentEventsMswn_c = m7245serverSentEventsMswn_c(httpClient, new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEvents_BqdlHlk$lambda$20(str, str2, num, str3, function1, (HttpRequestBuilder) obj);
            }
        }, function2, duration, bool, bool2, function22, continuation);
        return objM7245serverSentEventsMswn_c == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM7245serverSentEventsMswn_c : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEvents_BqdlHlk$lambda$20(String str, String str2, Integer num, String str3, Function1 function1, HttpRequestBuilder serverSentEvents) {
        Intrinsics.checkNotNullParameter(serverSentEvents, "$this$serverSentEvents");
        HttpRequestKt.url$default(serverSentEvents, str, str2, num, str3, null, 16, null);
        function1.invoke(serverSentEvents);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEvents_pTj2aPc$lambda$21(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: serverSentEvents-pTj2aPc, reason: not valid java name */
    public static final Object m7249serverSentEventspTj2aPc(HttpClient httpClient, final String str, Function2<? super TypeInfo, ? super String, ? extends Object> function2, Duration duration, Boolean bool, Boolean bool2, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super ClientSSESessionWithDeserialization, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super Unit> continuation) throws Throwable {
        Object objM7245serverSentEventsMswn_c = m7245serverSentEventsMswn_c(httpClient, new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEvents_pTj2aPc$lambda$22(str, function1, (HttpRequestBuilder) obj);
            }
        }, function2, duration, bool, bool2, function22, continuation);
        return objM7245serverSentEventsMswn_c == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM7245serverSentEventsMswn_c : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEvents_pTj2aPc$lambda$22(String str, Function1 function1, HttpRequestBuilder serverSentEvents) {
        Intrinsics.checkNotNullParameter(serverSentEvents, "$this$serverSentEvents");
        URLParserKt.takeFrom(serverSentEvents.getUrl(), str);
        function1.invoke(serverSentEvents);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sseSession-mY9Nd3A, reason: not valid java name */
    public static final Object m7280sseSessionmY9Nd3A(HttpClient httpClient, Function2<? super TypeInfo, ? super String, ? extends Object> function2, Duration duration, Boolean bool, Boolean bool2, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESessionWithDeserialization> continuation) {
        return m7256serverSentEventsSessionmY9Nd3A(httpClient, function2, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sseSession_tL6_L_A$lambda$23(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sseSession-tL6_L-A, reason: not valid java name */
    public static final Object m7283sseSessiontL6_LA(HttpClient httpClient, String str, String str2, Integer num, String str3, Function2<? super TypeInfo, ? super String, ? extends Object> function2, Duration duration, Boolean bool, Boolean bool2, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESessionWithDeserialization> continuation) {
        return m7259serverSentEventsSessiontL6_LA(httpClient, str, str2, num, str3, function2, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sseSession_Mswn__c$lambda$24(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sseSession-Mswn-_c, reason: not valid java name */
    public static final Object m7275sseSessionMswn_c(HttpClient httpClient, String str, Function2<? super TypeInfo, ? super String, ? extends Object> function2, Duration duration, Boolean bool, Boolean bool2, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESessionWithDeserialization> continuation) {
        return m7251serverSentEventsSessionMswn_c(httpClient, str, function2, duration, bool, bool2, function1, continuation);
    }

    /* JADX INFO: renamed from: sse-Mswn-_c, reason: not valid java name */
    public static final Object m7266sseMswn_c(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super TypeInfo, ? super String, ? extends Object> function2, Duration duration, Boolean bool, Boolean bool2, Function2<? super ClientSSESessionWithDeserialization, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super Unit> continuation) throws Throwable {
        Object objM7245serverSentEventsMswn_c = m7245serverSentEventsMswn_c(httpClient, function1, function2, duration, bool, bool2, function22, continuation);
        return objM7245serverSentEventsMswn_c == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM7245serverSentEventsMswn_c : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sse_BAHpl2s$lambda$25(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sse-BAHpl2s, reason: not valid java name */
    public static final Object m7263sseBAHpl2s(HttpClient httpClient, String str, String str2, Integer num, String str3, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super TypeInfo, ? super String, ? extends Object> function2, Duration duration, Boolean bool, Boolean bool2, Function2<? super ClientSSESessionWithDeserialization, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super Unit> continuation) throws Throwable {
        Object objM7243serverSentEventsBqdlHlk = m7243serverSentEventsBqdlHlk(httpClient, str, str2, num, str3, function2, duration, bool, bool2, function1, function22, continuation);
        return objM7243serverSentEventsBqdlHlk == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM7243serverSentEventsBqdlHlk : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sse_Q9yt8Vw$lambda$26(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sse-Q9yt8Vw, reason: not valid java name */
    public static final Object m7269sseQ9yt8Vw(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super TypeInfo, ? super String, ? extends Object> function2, Duration duration, Boolean bool, Boolean bool2, Function2<? super ClientSSESessionWithDeserialization, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super Unit> continuation) throws Throwable {
        Object objM7249serverSentEventspTj2aPc = m7249serverSentEventspTj2aPc(httpClient, str, function2, duration, bool, bool2, function1, function22, continuation);
        return objM7249serverSentEventspTj2aPc == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM7249serverSentEventspTj2aPc : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: processSession-rp2poPw, reason: not valid java name */
    private static final /* synthetic */ <T> Object m7238processSessionrp2poPw(HttpClient httpClient, Duration duration, Boolean bool, Boolean bool2, Function1<? super HttpRequestBuilder, Unit> function1, Function1<? super HttpRequestBuilder, Unit> function12, Continuation<? super T> continuation) {
        HttpClientPluginKt.plugin(httpClient, SSEKt.getSSE());
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        addAttribute(httpRequestBuilder, sseRequestAttr, true);
        addAttribute(httpRequestBuilder, reconnectionTimeAttr, duration);
        addAttribute(httpRequestBuilder, showCommentEventsAttr, bool);
        addAttribute(httpRequestBuilder, showRetryEventsAttr, bool2);
        function12.invoke(httpRequestBuilder);
        Unit unit = Unit.INSTANCE;
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        Intrinsics.needClassReification();
        BuildersKt__Builders_commonKt.launch$default(httpClient, null, null, new BuildersKt$processSession$2(httpStatement, completableDeferredCompletableDeferred$default, null), 3, null);
        InlineMarker.mark(0);
        Object objAwait = completableDeferredCompletableDeferred$default.await(continuation);
        InlineMarker.mark(1);
        return objAwait;
    }

    private static final <T> void addAttribute(HttpRequestBuilder httpRequestBuilder, AttributeKey<T> attributeKey, T t) {
        if (t != null) {
            httpRequestBuilder.getAttributes().put(attributeKey, t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable mapToSSEException(HttpResponse httpResponse, Throwable th) {
        return (!(th instanceof SSEClientException) || ((SSEClientException) th).getResponse() == null) ? new SSEClientException(httpResponse, th, th.getMessage()) : th;
    }

    /* JADX INFO: renamed from: serverSentEventsSession-i8z2VEo, reason: not valid java name */
    public static final Object m7253serverSentEventsSessioni8z2VEo(HttpClient httpClient, Duration duration, Boolean bool, Boolean bool2, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESession> continuation) {
        HttpClientPluginKt.plugin(httpClient, SSEKt.getSSE());
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        addAttribute(httpRequestBuilder, sseRequestAttr, Boxing.boxBoolean(true));
        addAttribute(httpRequestBuilder, reconnectionTimeAttr, duration);
        addAttribute(httpRequestBuilder, showCommentEventsAttr, bool);
        addAttribute(httpRequestBuilder, showRetryEventsAttr, bool2);
        BuildersKt__Builders_commonKt.launch$default(httpClient, null, null, new BuildersKt$serverSentEventsSessioni8z2VEo$$inlined$processSessionrp2poPw$1(new HttpStatement(httpRequestBuilder, httpClient), completableDeferredCompletableDeferred$default, null), 3, null);
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    /* JADX INFO: renamed from: serverSentEventsSession-mY9Nd3A, reason: not valid java name */
    public static final Object m7256serverSentEventsSessionmY9Nd3A(HttpClient httpClient, Function2<? super TypeInfo, ? super String, ? extends Object> function2, Duration duration, Boolean bool, Boolean bool2, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESessionWithDeserialization> continuation) {
        HttpClientPluginKt.plugin(httpClient, SSEKt.getSSE());
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        addAttribute(httpRequestBuilder, sseRequestAttr, Boxing.boxBoolean(true));
        addAttribute(httpRequestBuilder, reconnectionTimeAttr, duration);
        addAttribute(httpRequestBuilder, showCommentEventsAttr, bool);
        addAttribute(httpRequestBuilder, showRetryEventsAttr, bool2);
        addAttribute(httpRequestBuilder, deserializerAttr, function2);
        BuildersKt__Builders_commonKt.launch$default(httpClient, null, null, new BuildersKt$serverSentEventsSessionmY9Nd3A$$inlined$processSessionrp2poPw$1(new HttpStatement(httpRequestBuilder, httpClient), completableDeferredCompletableDeferred$default, null), 3, null);
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    static {
        KType kTypeTypeOf;
        KType kTypeTypeOf2;
        KType kTypeTypeOf3;
        KType kTypeTypeOf4;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
        KType kTypeTypeOf5 = null;
        try {
            kTypeTypeOf = Reflection.typeOf(Boolean.TYPE);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        sseRequestAttr = new AttributeKey<>("SSERequestFlag", new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Duration.class);
        try {
            kTypeTypeOf2 = Reflection.typeOf(Duration.class);
        } catch (Throwable unused2) {
            kTypeTypeOf2 = null;
        }
        reconnectionTimeAttr = new AttributeKey<>("SSEReconnectionTime", new TypeInfo(orCreateKotlinClass2, kTypeTypeOf2));
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Boolean.class);
        try {
            kTypeTypeOf3 = Reflection.typeOf(Boolean.TYPE);
        } catch (Throwable unused3) {
            kTypeTypeOf3 = null;
        }
        showCommentEventsAttr = new AttributeKey<>("SSEShowCommentEvents", new TypeInfo(orCreateKotlinClass3, kTypeTypeOf3));
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Boolean.class);
        try {
            kTypeTypeOf4 = Reflection.typeOf(Boolean.TYPE);
        } catch (Throwable unused4) {
            kTypeTypeOf4 = null;
        }
        showRetryEventsAttr = new AttributeKey<>("SSEShowRetryEvents", new TypeInfo(orCreateKotlinClass4, kTypeTypeOf4));
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Function2.class);
        try {
            kTypeTypeOf5 = Reflection.typeOf(Function2.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(TypeInfo.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(Object.class)));
        } catch (Throwable unused5) {
        }
        deserializerAttr = new AttributeKey<>("SSEDeserializer", new TypeInfo(orCreateKotlinClass5, kTypeTypeOf5));
    }
}
