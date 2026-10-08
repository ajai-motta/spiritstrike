package com.digitalturbine.ignite.authenticator.events;

import com.hive.ResultAPI;

/* JADX INFO: loaded from: classes3.dex */
public enum d {
    ENCRYPTION_EXCEPTION(1100),
    RAW_ONE_DT_ERROR(ResultAPI.PeppermintErrCode.HUB_E_NOT_CONNECT_DB),
    ONE_DT_PARSE_ERROR(1102),
    ONE_DT_AUTHENTICATION_ERROR(1103),
    ONE_DT_BROADCAST_ERROR(1104),
    ONE_DT_REQUEST_ERROR(1105),
    ONE_DT_GENERAL_ERROR(1106);

    int mVal;

    d(int i) {
        this.mVal = i;
    }

    public final int a() {
        return this.mVal;
    }
}
