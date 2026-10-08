package com.hive.authv4;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u000f\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"getDeviceManagementFlag", "", "()Ljava/lang/Boolean;", "hive-service_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AuthV4DeviceManagementFlagKt {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
    
        if (r0.equals("false") == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
    
        if (r0.equals("FALSE") == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
    
        if (r0.equals("true") == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005f, code lost:
    
        if (r0.equals("TRUE") == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0068, code lost:
    
        if (r0.equals("1") == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006d, code lost:
    
        return java.lang.Boolean.TRUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0074, code lost:
    
        if (r0.equals(com.facebook.appevents.AppEventsConstants.EVENT_PARAM_VALUE_NO) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0079, code lost:
    
        return java.lang.Boolean.FALSE;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Boolean getDeviceManagementFlag() {
        /*
            com.hive.core.Configuration r0 = com.hive.core.Configuration.INSTANCE
            org.json.JSONObject r0 = r0.getMetaData()
            r1 = 0
            if (r0 == 0) goto L23
            java.lang.String r2 = "device_mgt_flag"
            java.lang.Object r0 = r0.opt(r2)
            if (r0 == 0) goto L23
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L23
            java.lang.String r2 = "null"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r2 != 0) goto L20
            goto L21
        L20:
            r0 = r1
        L21:
            if (r0 != 0) goto L25
        L23:
            java.lang.String r0 = ""
        L25:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "[DeviceManagement] getMgtFlag: "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.hive.Logger.v(r2)
            int r2 = r0.hashCode()
            switch(r2) {
                case 48: goto L6e;
                case 49: goto L62;
                case 2583950: goto L59;
                case 3569038: goto L50;
                case 66658563: goto L47;
                case 97196323: goto L3e;
                default: goto L3d;
            }
        L3d:
            goto L7a
        L3e:
            java.lang.String r2 = "false"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L77
            goto L7a
        L47:
            java.lang.String r2 = "FALSE"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L77
            goto L7a
        L50:
            java.lang.String r2 = "true"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L6b
            goto L7a
        L59:
            java.lang.String r2 = "TRUE"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L6b
            goto L7a
        L62:
            java.lang.String r2 = "1"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L6b
            goto L7a
        L6b:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            return r0
        L6e:
            java.lang.String r2 = "0"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L77
            goto L7a
        L77:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            return r0
        L7a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.AuthV4DeviceManagementFlagKt.getDeviceManagementFlag():java.lang.Boolean");
    }
}
