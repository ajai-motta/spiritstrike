package com.hive.analytics;

import com.google.common.net.HttpHeaders;
import com.hive.core.Configuration;
import com.hive.core.HiveTime;
import com.hive.core.Logger;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.protocol.UrlManager;
import com.hive.standalone.HiveLifecycle;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JI\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00050\f¨\u0006\u0012"}, d2 = {"Lcom/hive/analytics/AnalyticsNetwork;", "", "<init>", "()V", "concurrent", "", "activeTime", "", "playTime", "playOutTime", "prevLatency", "callback", "Lkotlin/Function1;", "Lcom/hive/core/Response;", "Lkotlin/ParameterName;", "name", "res", "CcuRequest", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnalyticsNetwork {
    public static final AnalyticsNetwork INSTANCE = new AnalyticsNetwork();

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020@R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\nR\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\n\"\u0004\b+\u0010\fR\u0011\u0010,\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\nR\u0011\u0010.\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\nR\u0011\u00100\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\"R\u001a\u00102\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010&\"\u0004\b4\u0010(R\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006A"}, d2 = {"Lcom/hive/analytics/AnalyticsNetwork$CcuRequest;", "", "activeTime", "", "playTime", "playOutTime", "prevLatencyTime", "<init>", "(JJJJ)V", "getActiveTime", "()J", "setActiveTime", "(J)V", "getPlayTime", "setPlayTime", "getPlayOutTime", "setPlayOutTime", "getPrevLatencyTime", "setPrevLatencyTime", "request", "Lcom/hive/core/Request;", "getRequest", "()Lcom/hive/core/Request;", "dateTime", "getDateTime", "account", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "getAccount", "()Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "appIndex", "getAppIndex", "serverId", "", "getServerId", "()Ljava/lang/String;", "serverIdSize", "", "getServerIdSize", "()I", "setServerIdSize", "(I)V", "prevLatency", "getPrevLatency", "setPrevLatency", "timestampMillis", "getTimestampMillis", "uid", "getUid", "hiveCountry", "getHiveCountry", "bodyByteLength", "getBodyByteLength", "setBodyByteLength", "byteBuffer", "Ljava/nio/ByteBuffer;", "getByteBuffer", "()Ljava/nio/ByteBuffer;", "setByteBuffer", "(Ljava/nio/ByteBuffer;)V", "setBodyData", "", "timestampMillisStandby", "preLatency", "reloadBody", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CcuRequest {
        private final HiveLifecycle.HiveAccount account;
        private long activeTime;
        private final long appIndex;
        private int bodyByteLength;
        private ByteBuffer byteBuffer;
        private final long dateTime;
        private final String hiveCountry;
        private long playOutTime;
        private long playTime;
        private long prevLatency;
        private long prevLatencyTime;
        private final Request request;
        private final String serverId;
        private int serverIdSize;
        private final long timestampMillis;
        private final long uid;

        public CcuRequest(long j, long j2, long j3, long j4) {
            this.activeTime = j;
            this.playTime = j2;
            this.playOutTime = j3;
            this.prevLatencyTime = j4;
            Request request = new Request();
            this.request = request;
            HiveTime hiveTime = HiveTime.INSTANCE;
            this.dateTime = hiveTime.getHiveTime().getTime() / 1000;
            HiveLifecycle.HiveAccount account = HiveLifecycle.INSTANCE.getAccount();
            this.account = account;
            Configuration configuration = Configuration.INSTANCE;
            this.appIndex = configuration.getAppindex();
            String serverId = configuration.getServerId();
            this.serverId = serverId;
            this.serverIdSize = serverId.length();
            this.prevLatency = this.prevLatencyTime;
            this.timestampMillis = hiveTime.getHiveTimeTimestamp().getTime();
            String uid = account.getUid();
            this.uid = uid != null ? Long.parseLong(uid) : 0L;
            this.hiveCountry = Intrinsics.areEqual(configuration.getHiveCountry(), Configuration.HIVE_COUNTRY_DEFAULT) ? "  " : configuration.getHiveCountry();
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.bodyByteLength);
            Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(...)");
            this.byteBuffer = byteBufferAllocate;
            this.bodyByteLength = this.serverIdSize + 99;
            setBodyData(0L, this.prevLatency, false);
            request.setUrl(UrlManager.ActiveCcu.INSTANCE.getCcu());
            request.setMethod(Request.MethodType.POST);
            request.setContentType(Request.ContentType.OCTET_STREAM);
            request.getHeader().put(HttpHeaders.CONTENT_LENGTH, String.valueOf(this.bodyByteLength));
            byte[] bArrArray = this.byteBuffer.array();
            Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
            request.setBody(bArrArray);
            request.setConnectTimeoutSeconds(15);
            request.setReadTimeoutSeconds(15);
            request.setSendObserver(false);
            request.setPrintNetworkLog(false);
        }

        public final HiveLifecycle.HiveAccount getAccount() {
            return this.account;
        }

        public final long getActiveTime() {
            return this.activeTime;
        }

        public final long getAppIndex() {
            return this.appIndex;
        }

        public final int getBodyByteLength() {
            return this.bodyByteLength;
        }

        public final ByteBuffer getByteBuffer() {
            return this.byteBuffer;
        }

        public final long getDateTime() {
            return this.dateTime;
        }

        public final String getHiveCountry() {
            return this.hiveCountry;
        }

        public final long getPlayOutTime() {
            return this.playOutTime;
        }

        public final long getPlayTime() {
            return this.playTime;
        }

        public final long getPrevLatency() {
            return this.prevLatency;
        }

        public final long getPrevLatencyTime() {
            return this.prevLatencyTime;
        }

        public final Request getRequest() {
            return this.request;
        }

        public final String getServerId() {
            return this.serverId;
        }

        public final int getServerIdSize() {
            return this.serverIdSize;
        }

        public final long getTimestampMillis() {
            return this.timestampMillis;
        }

        public final long getUid() {
            return this.uid;
        }

        public final void setActiveTime(long j) {
            this.activeTime = j;
        }

        public final void setBodyByteLength(int i) {
            this.bodyByteLength = i;
        }

        public final void setBodyData(long timestampMillisStandby, long preLatency, boolean reloadBody) {
            Object objM7415constructorimpl;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.bodyByteLength);
            try {
                Result.Companion companion = Result.INSTANCE;
                byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
                byteBufferAllocate.putLong(this.dateTime);
                byteBufferAllocate.putLong(this.appIndex);
                String vid = this.account.getVid();
                byteBufferAllocate.putLong(vid != null ? Long.parseLong(vid) : 0L);
                String did = this.account.getDid();
                byteBufferAllocate.putLong(did != null ? Long.parseLong(did) : 0L);
                byteBufferAllocate.putLong(Configuration.INSTANCE.getSessionId());
                byteBufferAllocate.putLong(this.playTime);
                byteBufferAllocate.put((byte) this.serverIdSize);
                if (!StringsKt.isBlank(this.serverId)) {
                    byte[] bytes = this.serverId.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                    byteBufferAllocate.put(bytes);
                }
                byteBufferAllocate.putLong(this.playOutTime);
                byteBufferAllocate.putLong(preLatency);
                byteBufferAllocate.putLong(this.timestampMillis);
                byteBufferAllocate.putLong(timestampMillisStandby);
                byteBufferAllocate.putLong(this.uid);
                byteBufferAllocate.putLong(this.activeTime);
                byte[] bytes2 = this.hiveCountry.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                objM7415constructorimpl = Result.m7415constructorimpl(byteBufferAllocate.put(bytes2));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
            if (thM7418exceptionOrNullimpl != null) {
                Logger.INSTANCE.w("[AnalyticsNetwork] CCURequest body configuration failed.\n" + thM7418exceptionOrNullimpl.getMessage());
            }
            Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "apply(...)");
            this.byteBuffer = byteBufferAllocate;
            if (reloadBody) {
                Request request = this.request;
                byte[] bArrArray = byteBufferAllocate.array();
                Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
                request.setBody(bArrArray);
            }
        }

        public final void setByteBuffer(ByteBuffer byteBuffer) {
            Intrinsics.checkNotNullParameter(byteBuffer, "<set-?>");
            this.byteBuffer = byteBuffer;
        }

        public final void setPlayOutTime(long j) {
            this.playOutTime = j;
        }

        public final void setPlayTime(long j) {
            this.playTime = j;
        }

        public final void setPrevLatency(long j) {
            this.prevLatency = j;
        }

        public final void setPrevLatencyTime(long j) {
            this.prevLatencyTime = j;
        }

        public final void setServerIdSize(int i) {
            this.serverIdSize = i;
        }
    }

    private AnalyticsNetwork() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void concurrent$lambda$1(com.hive.analytics.AnalyticsNetwork.CcuRequest r8, long r9, kotlin.jvm.functions.Function1 r11) {
        /*
            com.hive.core.Network r0 = com.hive.core.Network.INSTANCE
            com.hive.core.Request r1 = r8.getRequest()
            com.hive.core.Response r1 = r0.sync(r1)
            boolean r2 = r1.isFailure()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L46
            com.hive.core.Result r2 = r1.getResult()
            com.hive.core.Result$Code r2 = r2.getCode()
            com.hive.core.Result$Code r5 = com.hive.core.Result.Code.Timeout
            if (r2 != r5) goto L21
            java.lang.String r2 = "timeout"
            goto L57
        L21:
            com.hive.core.Result r2 = r1.getResult()
            java.lang.String r2 = r2.getMessage()
            int r5 = r2.length()
            r6 = 255(0xff, float:3.57E-43)
            if (r5 > r6) goto L32
            goto L33
        L32:
            r2 = 0
        L33:
            if (r2 != 0) goto L57
            com.hive.core.Result r2 = r1.getResult()
            java.lang.String r2 = r2.getMessage()
            kotlin.ranges.IntRange r3 = kotlin.ranges.RangesKt.until(r3, r6)
            java.lang.String r2 = kotlin.text.StringsKt.substring(r2, r3)
            goto L57
        L46:
            int r2 = r1.getHttpStatusCode()
            int r2 = r2 / 100
            r5 = 3
            if (r2 < r5) goto L59
            int r2 = r1.getHttpStatusCode()
            java.lang.String r2 = java.lang.String.valueOf(r2)
        L57:
            r3 = r4
            goto L5b
        L59:
            java.lang.String r2 = ""
        L5b:
            if (r3 == 0) goto L8f
            com.hive.core.Request r1 = r8.getRequest()
            java.util.Map r1 = r1.getHeader()
            java.lang.String r3 = "X-Ccu-Active-Status"
            r1.put(r3, r2)
            com.hive.core.Request r1 = r8.getRequest()
            com.hive.protocol.UrlManager$StandByCcu r2 = com.hive.protocol.UrlManager.StandByCcu.INSTANCE
            java.lang.String r2 = r2.getCcu()
            r1.setUrl(r2)
            com.hive.core.HiveTime r1 = com.hive.core.HiveTime.INSTANCE
            java.sql.Timestamp r1 = r1.getHiveTimeTimestamp()
            long r3 = r1.getTime()
            r7 = 1
            r2 = r8
            r5 = r9
            r2.setBodyData(r3, r5, r7)
            com.hive.core.Request r8 = r8.getRequest()
            com.hive.core.Response r1 = r0.sync(r8)
        L8f:
            r11.invoke(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.analytics.AnalyticsNetwork.concurrent$lambda$1(com.hive.analytics.AnalyticsNetwork$CcuRequest, long, kotlin.jvm.functions.Function1):void");
    }

    public final void concurrent(long activeTime, long playTime, long playOutTime, final long prevLatency, final Function1<? super Response, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        final CcuRequest ccuRequest = new CcuRequest(activeTime, playTime, playOutTime, prevLatency);
        new Thread(new Runnable() { // from class: com.hive.analytics.AnalyticsNetwork$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AnalyticsNetwork.concurrent$lambda$1(ccuRequest, prevLatency, callback);
            }
        }).start();
    }
}
