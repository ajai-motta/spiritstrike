package com.hive.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkFailureAnalyzer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/hive/core/NetworkFailureAnalyzer;", "", "<init>", "()V", "detectNetworkFailure", "", "t", "", "NetworkFailureCase", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NetworkFailureAnalyzer {
    public static final NetworkFailureAnalyzer INSTANCE = new NetworkFailureAnalyzer();

    private NetworkFailureAnalyzer() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: NetworkFailureAnalyzer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/hive/core/NetworkFailureAnalyzer$NetworkFailureCase;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "INVALID_URL", "DNS_FAILED", "TIMEOUT", "CONNECTION_REJECTED", "CERTIFICATE_INVALID", "SSL_HANDSHAKE_FAILED", Configuration.HIVE_COUNTRY_DEFAULT, "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NetworkFailureCase {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ NetworkFailureCase[] $VALUES;
        private final String value;
        public static final NetworkFailureCase INVALID_URL = new NetworkFailureCase("INVALID_URL", 0, "INVALID_URL");
        public static final NetworkFailureCase DNS_FAILED = new NetworkFailureCase("DNS_FAILED", 1, "DNS_FAILED");
        public static final NetworkFailureCase TIMEOUT = new NetworkFailureCase("TIMEOUT", 2, "TIMEOUT");
        public static final NetworkFailureCase CONNECTION_REJECTED = new NetworkFailureCase("CONNECTION_REJECTED", 3, "CONNECTION_REJECTED");
        public static final NetworkFailureCase CERTIFICATE_INVALID = new NetworkFailureCase("CERTIFICATE_INVALID", 4, "CERTIFICATE_INVALID");
        public static final NetworkFailureCase SSL_HANDSHAKE_FAILED = new NetworkFailureCase("SSL_HANDSHAKE_FAILED", 5, "SSL_HANDSHAKE_FAILED");
        public static final NetworkFailureCase UNKNOWN = new NetworkFailureCase(Configuration.HIVE_COUNTRY_DEFAULT, 6, Configuration.HIVE_COUNTRY_DEFAULT);

        private static final /* synthetic */ NetworkFailureCase[] $values() {
            return new NetworkFailureCase[]{INVALID_URL, DNS_FAILED, TIMEOUT, CONNECTION_REJECTED, CERTIFICATE_INVALID, SSL_HANDSHAKE_FAILED, UNKNOWN};
        }

        public static EnumEntries<NetworkFailureCase> getEntries() {
            return $ENTRIES;
        }

        private NetworkFailureCase(String str, int i, String str2) {
            this.value = str2;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            NetworkFailureCase[] networkFailureCaseArr$values = $values();
            $VALUES = networkFailureCaseArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(networkFailureCaseArr$values);
        }

        public static NetworkFailureCase valueOf(String str) {
            return (NetworkFailureCase) Enum.valueOf(NetworkFailureCase.class, str);
        }

        public static NetworkFailureCase[] values() {
            return (NetworkFailureCase[]) $VALUES.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable detectNetworkFailure$lambda$0(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getCause();
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b5, code lost:
    
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r1, (java.lang.CharSequence) "protocol", false, 2, (java.lang.Object) null) == false) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String detectNetworkFailure(java.lang.Throwable r8) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.core.NetworkFailureAnalyzer.detectNetworkFailure(java.lang.Throwable):java.lang.String");
    }
}
