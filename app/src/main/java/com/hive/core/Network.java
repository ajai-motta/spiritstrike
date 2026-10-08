package com.hive.core;

import com.hive.core.Logger;
import com.hive.core.Request;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Network.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0010H\u0002R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/hive/core/Network;", "", "<init>", "()V", "observer", "Lkotlin/Function1;", "Lcom/hive/core/Response;", "", "getObserver$hive_core_release", "()Lkotlin/jvm/functions/Function1;", "setObserver$hive_core_release", "(Lkotlin/jvm/functions/Function1;)V", "sync", "request", "Lcom/hive/core/Request;", "elapsedMilliTime", "", "t0", "t1", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Network {
    public static final Network INSTANCE = new Network();
    private static Function1<? super Response, Unit> observer;

    /* JADX INFO: compiled from: Network.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Request.MethodType.values().length];
            try {
                iArr[Request.MethodType.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private Network() {
    }

    public final Function1<Response, Unit> getObserver$hive_core_release() {
        return observer;
    }

    public final void setObserver$hive_core_release(Function1<? super Response, Unit> function1) {
        observer = function1;
    }

    static /* synthetic */ void sync$log$default(Request request, String str, Logger.LogType logType, int i, Object obj) {
        if ((i & 4) != 0) {
            logType = Logger.LogType.Debug;
        }
        sync$log(request, str, logType);
    }

    private static final void sync$log(Request request, String str, Logger.LogType logType) {
        if (request.getPrintNetworkLog()) {
            Logger.INSTANCE.coreLog$hive_core_release(str, logType);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x04d4 A[Catch: Exception -> 0x03ab, TRY_LEAVE, TryCatch #27 {Exception -> 0x03ab, blocks: (B:119:0x03a4, B:120:0x03a7, B:202:0x04cf, B:204:0x04d4, B:215:0x0563, B:217:0x0568, B:228:0x05df, B:230:0x05e4, B:241:0x065b, B:243:0x0660, B:254:0x06d7, B:256:0x06dc), top: B:279:0x0057 }] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0568 A[Catch: Exception -> 0x03ab, TRY_LEAVE, TryCatch #27 {Exception -> 0x03ab, blocks: (B:119:0x03a4, B:120:0x03a7, B:202:0x04cf, B:204:0x04d4, B:215:0x0563, B:217:0x0568, B:228:0x05df, B:230:0x05e4, B:241:0x065b, B:243:0x0660, B:254:0x06d7, B:256:0x06dc), top: B:279:0x0057 }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x05e4 A[Catch: Exception -> 0x03ab, TRY_LEAVE, TryCatch #27 {Exception -> 0x03ab, blocks: (B:119:0x03a4, B:120:0x03a7, B:202:0x04cf, B:204:0x04d4, B:215:0x0563, B:217:0x0568, B:228:0x05df, B:230:0x05e4, B:241:0x065b, B:243:0x0660, B:254:0x06d7, B:256:0x06dc), top: B:279:0x0057 }] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x063a  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0660 A[Catch: Exception -> 0x03ab, TRY_LEAVE, TryCatch #27 {Exception -> 0x03ab, blocks: (B:119:0x03a4, B:120:0x03a7, B:202:0x04cf, B:204:0x04d4, B:215:0x0563, B:217:0x0568, B:228:0x05df, B:230:0x05e4, B:241:0x065b, B:243:0x0660, B:254:0x06d7, B:256:0x06dc), top: B:279:0x0057 }] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x06b6  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x06dc A[Catch: Exception -> 0x03ab, TRY_LEAVE, TryCatch #27 {Exception -> 0x03ab, blocks: (B:119:0x03a4, B:120:0x03a7, B:202:0x04cf, B:204:0x04d4, B:215:0x0563, B:217:0x0568, B:228:0x05df, B:230:0x05e4, B:241:0x065b, B:243:0x0660, B:254:0x06d7, B:256:0x06dc), top: B:279:0x0057 }] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0743  */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.hive.core.Network] */
    /* JADX WARN: Type inference failed for: r3v1, types: [long] */
    /* JADX WARN: Type inference failed for: r3v2, types: [long] */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v46 */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v50 */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r5v36 */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.hive.core.Response sync(final com.hive.core.Request r20) {
        /*
            Method dump skipped, instruction units count: 1924
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.core.Network.sync(com.hive.core.Request):com.hive.core.Response");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean sync$lambda$1(Response response, int i, Request request, String str, SSLSession sSLSession) {
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            protocol = "unknown";
        }
        response.setTlsProtocol(protocol);
        String cipherSuite = sSLSession.getCipherSuite();
        response.setTlsNote(cipherSuite != null ? cipherSuite : "unknown");
        sync$log$default(request, "Network [" + i + "] (" + str + ") host verifier: " + sSLSession.isValid(), null, 4, null);
        return sSLSession.isValid();
    }

    static /* synthetic */ long elapsedMilliTime$default(Network network, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = System.nanoTime();
        }
        return network.elapsedMilliTime(j, j2);
    }

    private final long elapsedMilliTime(long t0, long t1) {
        return Math.abs(t1 - t0) / 1000000;
    }
}
