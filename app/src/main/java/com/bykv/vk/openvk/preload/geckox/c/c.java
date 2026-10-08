package com.bykv.vk.openvk.preload.geckox.c;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.openvk.preload.geckox.model.CheckRequestBodyModel;
import com.bykv.vk.openvk.preload.geckox.model.Common;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import com.bykv.vk.openvk.preload.geckox.net.Response;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.bykv.vk.openvk.preload.a.d<Map<String, List<Pair<String, Long>>>, List<UpdatePackage>> {
    private com.bykv.vk.openvk.preload.geckox.b d;
    private Map<String, Map<String, Object>> e;
    private Map<String, List<CheckRequestBodyModel.TargetChannel>> f;
    private com.bykv.vk.openvk.preload.geckox.d.a g;
    private String h;
    private com.bykv.vk.openvk.preload.geckox.buffer.a.a i = new com.bykv.vk.openvk.preload.geckox.buffer.a.a();

    @Override // com.bykv.vk.openvk.preload.a.d
    protected final void a(Object... objArr) {
        super.a(objArr);
        this.d = (com.bykv.vk.openvk.preload.geckox.b) objArr[0];
        this.e = (Map) objArr[1];
        this.f = (Map) objArr[2];
        this.g = (com.bykv.vk.openvk.preload.geckox.d.a) objArr[3];
        this.h = (String) objArr[4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.bykv.vk.openvk.preload.a.d
    public Object a(com.bykv.vk.openvk.preload.a.b<List<UpdatePackage>> bVar, Map<String, List<Pair<String, Long>>> map) throws Exception {
        List<Pair<String, com.bykv.vk.openvk.preload.geckox.f.a>> listC;
        Map<String, List<UpdatePackage>> mapA = a(map);
        com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.d, this.i);
        Iterator<Map.Entry<String, List<UpdatePackage>>> it = mapA.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<UpdatePackage> it2 = it.next().getValue().iterator();
            while (it2.hasNext()) {
                UpdatePackage next = it2.next();
                long localVersion = next.getLocalVersion();
                long version = next.getVersion();
                if (version < localVersion) {
                    next.getChannel();
                    Long.valueOf(localVersion);
                    Long.valueOf(version);
                    File[] fileArrListFiles = new File(this.d.n(), next.getAccessKey() + File.separator + next.getChannel()).listFiles(new FileFilter() { // from class: com.bykv.vk.openvk.preload.geckox.c.c.1
                        @Override // java.io.FileFilter
                        public final boolean accept(File file) {
                            return file.isDirectory();
                        }
                    });
                    if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                        for (File file : fileArrListFiles) {
                            try {
                                long j = Long.parseLong(file.getName());
                                if (j > version) {
                                    final File file2 = new File(file.getParent(), file.getName() + "--pending-delete");
                                    file.renameTo(file2);
                                    com.bykv.vk.openvk.preload.geckox.utils.c.a().execute(new Runnable() { // from class: com.bykv.vk.openvk.preload.geckox.c.c.2
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            com.bykv.vk.openvk.preload.geckox.utils.b.a(file2);
                                        }
                                    });
                                } else if (j == version) {
                                    it2.remove();
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, List<UpdatePackage>>> it3 = mapA.entrySet().iterator();
        while (it3.hasNext()) {
            arrayList.addAll(it3.next().getValue());
        }
        Object objA = null;
        try {
            listC = c(arrayList);
            try {
                objA = bVar.a(arrayList);
            } catch (Throwable unused2) {
            }
        } catch (Throwable unused3) {
            listC = null;
        }
        b(listC);
        a(arrayList);
        return objA;
    }

    private void a(List<UpdatePackage> list) {
        if (list.isEmpty()) {
            return;
        }
        for (UpdatePackage updatePackage : list) {
            com.bykv.vk.openvk.preload.geckox.a.c.a(new File(new File(this.d.n(), updatePackage.getAccessKey()), updatePackage.getChannel()).getAbsolutePath());
        }
    }

    private static void b(List<Pair<String, com.bykv.vk.openvk.preload.geckox.f.a>> list) {
        if (list == null) {
            return;
        }
        Iterator<Pair<String, com.bykv.vk.openvk.preload.geckox.f.a>> it = list.iterator();
        while (it.hasNext()) {
            try {
                ((com.bykv.vk.openvk.preload.geckox.f.a) it.next().second).a();
            } catch (Exception unused) {
            }
        }
    }

    private List<Pair<String, com.bykv.vk.openvk.preload.geckox.f.a>> c(List<UpdatePackage> list) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (UpdatePackage updatePackage : list) {
            try {
                File file = new File(new File(this.d.n(), updatePackage.getAccessKey()), updatePackage.getChannel());
                if (file.isFile()) {
                    com.bykv.vk.openvk.preload.geckox.utils.b.a(file);
                }
                if (!file.mkdirs() && !file.isDirectory()) {
                    file.getAbsolutePath();
                    throw new RuntimeException("can not create channel dir:" + file.getAbsolutePath());
                }
                com.bykv.vk.openvk.preload.geckox.f.a aVarA = com.bykv.vk.openvk.preload.geckox.f.a.a(file.getAbsolutePath() + File.separator + "update.lock");
                if (aVarA != null) {
                    arrayList.add(new Pair(updatePackage.getChannel(), aVarA));
                    arrayList2.add(updatePackage);
                } else {
                    com.bykv.vk.openvk.preload.geckox.d.a aVar = this.g;
                    updatePackage.getChannel();
                }
            } catch (Exception unused) {
                updatePackage.getChannel();
                com.bykv.vk.openvk.preload.geckox.d.a aVar2 = this.g;
            }
        }
        list.clear();
        list.addAll(arrayList2);
        return arrayList;
    }

    private Map<String, List<UpdatePackage>> a(Map<String, List<Pair<String, Long>>> map) throws Exception {
        String strB = b(map);
        String str = "https://" + this.d.j() + "/gecko/server/v3/package";
        try {
            this.i.f = com.bykv.vk.openvk.preload.geckox.utils.e.a(this.d.a());
            Response responseDoPost = this.d.i().doPost(str, strB);
            this.i.g = responseDoPost.code;
            this.i.d = responseDoPost.msg;
            com.bykv.vk.openvk.preload.geckox.buffer.a.a aVar = this.i;
            Map<String, String> map2 = responseDoPost.headers;
            String str2 = "";
            if (map2 != null && !map2.isEmpty()) {
                String str3 = map2.get("x-tt-logid");
                if (TextUtils.isEmpty(str3)) {
                    str3 = map2.get("X-Tt-Logid");
                    if (TextUtils.isEmpty(str3)) {
                        String str4 = map2.get("X-TT-LOGID");
                        if (!TextUtils.isEmpty(str4)) {
                            str2 = str4;
                        }
                    } else {
                        str2 = str3;
                    }
                } else {
                    str2 = str3;
                }
            }
            aVar.e = str2;
            if (responseDoPost.code == 200) {
                String str5 = responseDoPost.body;
                try {
                    com.bykv.vk.openvk.preload.geckox.model.Response response = new com.bykv.vk.openvk.preload.geckox.model.Response();
                    response.fromJson(str5);
                    if (response.status == 0) {
                        if (response.data == null) {
                            this.i.d = "check update error：response.data==null";
                            com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.d, this.i);
                            throw new a("check update error：response.data==null");
                        }
                        com.bykv.vk.openvk.preload.geckox.a.a.a(this.d.a(), response.data.getUniversalStrategies(), this.d.n(), this.g);
                        Map<String, List<UpdatePackage>> packages = response.data.getPackages();
                        if (packages == null || packages.isEmpty()) {
                            com.bykv.vk.openvk.preload.geckox.a.a.a(this.d);
                            return new HashMap();
                        }
                        for (String str6 : this.d.e()) {
                            List<UpdatePackage> list = packages.get(str6);
                            if (list != null && !list.isEmpty()) {
                                for (UpdatePackage updatePackage : list) {
                                    updatePackage.setAccessKey(str6);
                                    updatePackage.setLocalVersion(a(map.get(str6), updatePackage.getChannel()));
                                }
                            }
                        }
                        return packages;
                    }
                    if (response.status == 2000) {
                        com.bykv.vk.openvk.preload.geckox.a.a.a(this.d);
                        return new HashMap();
                    }
                    String str7 = "check update error，unknow status code，response.status：" + response.status;
                    this.i.d = str7;
                    com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.d, this.i);
                    throw new a(str7);
                } catch (Throwable th) {
                    this.i.d = "json parse failed：" + th.getMessage();
                    com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.d, this.i);
                    throw new b("json parse failed：" + str5 + " caused by:" + th.getMessage(), th);
                }
            }
            throw new NetworkErrorException("net work get failed, code: " + responseDoPost.code + ", url:" + str);
        } catch (Exception e) {
            com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.d, this.i);
            throw new C0174c("request failed：url:" + str + ", caused by:" + e.getMessage(), e);
        }
    }

    private static long a(List<Pair<String, Long>> list, String str) {
        for (Pair<String, Long> pair : list) {
            if (((String) pair.first).equals(str)) {
                return ((Long) pair.second).longValue();
            }
        }
        return 0L;
    }

    private String b(Map<String, List<Pair<String, Long>>> map) {
        List<CheckRequestBodyModel.TargetChannel> list;
        CheckRequestBodyModel checkRequestBodyModel = new CheckRequestBodyModel();
        Context contextA = this.d.a();
        checkRequestBodyModel.setCommon(new Common(this.d.k(), this.d.o(), this.d.r(), com.bykv.vk.openvk.preload.geckox.utils.a.b(contextA), com.bykv.vk.openvk.preload.geckox.utils.e.a(contextA), this.d.l(), this.d.m()));
        HashMap map2 = new HashMap();
        for (Map.Entry<String, List<Pair<String, Long>>> entry : map.entrySet()) {
            HashMap map3 = new HashMap();
            for (Pair<String, Long> pair : entry.getValue()) {
                CheckRequestBodyModel.LocalChannel localChannel = new CheckRequestBodyModel.LocalChannel();
                localChannel.localVersion = (Long) pair.second;
                map3.put(pair.first, localChannel);
            }
            map2.put(entry.getKey(), map3);
        }
        try {
            if (!map2.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry2 : map2.entrySet()) {
                    String str = (String) entry2.getKey();
                    Map map4 = (Map) entry2.getValue();
                    if (map4 != null && !map4.isEmpty()) {
                        JSONObject jSONObject2 = new JSONObject();
                        for (Map.Entry entry3 : map4.entrySet()) {
                            jSONObject2.put((String) entry3.getKey(), ((CheckRequestBodyModel.LocalChannel) entry3.getValue()).toJson());
                        }
                        jSONObject.put(str, jSONObject2);
                    }
                }
                this.i.f805a = jSONObject.toString();
            }
            checkRequestBodyModel.setLocal(map2);
            HashMap map5 = new HashMap();
            for (String str2 : this.d.e()) {
                CheckRequestBodyModel.Group group = new CheckRequestBodyModel.Group();
                group.groupName = this.h;
                Map<String, List<CheckRequestBodyModel.TargetChannel>> map6 = this.f;
                if (map6 != null && !map6.isEmpty() && (list = this.f.get(str2)) != null && !list.isEmpty()) {
                    group.targetChannels = new ArrayList();
                    group.targetChannels.addAll(list);
                }
                map5.put(str2, group);
            }
            if (!map5.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                for (Map.Entry entry4 : map5.entrySet()) {
                    Object value = entry4.getValue();
                    if (value != null && (value instanceof CheckRequestBodyModel.Group)) {
                        jSONObject3.put((String) entry4.getKey(), ((CheckRequestBodyModel.Group) value).toJson());
                    }
                }
                this.i.b = jSONObject3.toString();
            }
            checkRequestBodyModel.setDeployments(map5);
            Map<String, Map<String, Object>> map7 = this.e;
            if (map7 != null) {
                if (!map7.isEmpty()) {
                    JSONObject jSONObject4 = new JSONObject();
                    for (Map.Entry<String, Map<String, Object>> entry5 : this.e.entrySet()) {
                        String key = entry5.getKey();
                        Map<String, Object> value2 = entry5.getValue();
                        if (value2 != null && !value2.isEmpty()) {
                            JSONObject jSONObject5 = new JSONObject();
                            for (Map.Entry<String, Object> entry6 : value2.entrySet()) {
                                Object value3 = entry6.getValue();
                                if (value3 instanceof String) {
                                    jSONObject5.put(entry6.getKey(), value3);
                                }
                            }
                            jSONObject4.put(key, jSONObject5);
                        }
                    }
                    this.i.c = jSONObject4.toString();
                }
                checkRequestBodyModel.setCustom(this.e);
            }
            return checkRequestBodyModel.toJson();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: renamed from: com.bykv.vk.openvk.preload.geckox.c.c$c, reason: collision with other inner class name */
    public static class C0174c extends RuntimeException {
        C0174c(String str, Throwable th) {
            super(str, th);
        }
    }

    public static class b extends RuntimeException {
        b(String str, Throwable th) {
            super(str, th);
        }
    }

    public static class a extends RuntimeException {
        a(String str) {
            super(str);
        }
    }
}
