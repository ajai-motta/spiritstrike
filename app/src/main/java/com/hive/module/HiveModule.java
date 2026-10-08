package com.hive.module;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/hive/module/HiveModule;", "", "getHiveModuleName", "", "getVersionInfo", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface HiveModule {
    String getHiveModuleName();

    Map<String, String> getVersionInfo();
}
