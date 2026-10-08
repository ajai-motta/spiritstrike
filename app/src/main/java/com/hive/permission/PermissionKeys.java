package com.hive.permission;

import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated(message = "4.16.2, GCPSDK4-906")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/hive/permission/PermissionKeys;", "", "<init>", "()V", "OS_PERMISSION_REQUESTED_WHILE_SETUP", "", "getOS_PERMISSION_REQUESTED_WHILE_SETUP", "()Ljava/lang/String;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermissionKeys {
    public static final PermissionKeys INSTANCE = new PermissionKeys();
    private static final String OS_PERMISSION_REQUESTED_WHILE_SETUP = "permission.os_permission_requested_while_setup";

    private PermissionKeys() {
    }

    public final String getOS_PERMISSION_REQUESTED_WHILE_SETUP() {
        return OS_PERMISSION_REQUESTED_WHILE_SETUP;
    }
}
