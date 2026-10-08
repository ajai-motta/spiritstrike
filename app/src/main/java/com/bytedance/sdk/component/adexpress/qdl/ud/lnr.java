package com.bytedance.sdk.component.adexpress.qdl.ud;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.adexpress.qdl.lnr.qdl;
import com.bytedance.sdk.component.utils.kdv;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class lnr {
    public abstract File qdl();

    protected boolean qdl(Map<String, com.bytedance.sdk.component.adexpress.qdl.lnr.qdl> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVar = map.get(it.next());
            if (qdlVar != null && !qdl(qdlVar.mo())) {
                return false;
            }
        }
        return true;
    }

    protected boolean qdl(List<qdl.C0201qdl> list) {
        if (list == null || list.size() <= 0 || qdl() == null) {
            return false;
        }
        for (qdl.C0201qdl c0201qdl : list) {
            String strQdl = com.bytedance.sdk.component.utils.mzz.qdl(c0201qdl.qdl());
            if (TextUtils.isEmpty(strQdl)) {
                return false;
            }
            File file = new File(qdl(), strQdl);
            String strQdl2 = com.bytedance.sdk.component.utils.mzz.qdl(file);
            if (!file.exists() || !file.isFile() || c0201qdl.ud() == null || !c0201qdl.ud().equals(strQdl2)) {
                return false;
            }
        }
        return true;
    }

    protected boolean qdl(qdl.ud udVar) {
        if (udVar == null || qdl() == null) {
            return false;
        }
        List<Pair<String, String>> listUd = udVar.ud();
        if (listUd == null || listUd.size() <= 0) {
            return true;
        }
        Iterator<Pair<String, String>> it = listUd.iterator();
        while (it.hasNext()) {
            File file = new File(qdl(), (String) it.next().first);
            if (!file.exists() || !file.isFile()) {
                return false;
            }
        }
        return true;
    }

    public List<qdl.C0201qdl> qdl(com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVar, com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVar2) {
        Map<String, com.bytedance.sdk.component.adexpress.qdl.lnr.qdl> mapQdl = qdlVar.qdl();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (mapQdl.size() == 0) {
            if (qdlVar2 != null && qdlVar2.qdl().size() != 0) {
                Map<String, com.bytedance.sdk.component.adexpress.qdl.lnr.qdl> mapQdl2 = qdlVar2.qdl();
                Iterator<String> it = mapQdl2.keySet().iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVar3 = mapQdl2.get(it.next());
                    if (qdlVar3 != null) {
                        arrayList.addAll(qdlVar3.mo());
                    }
                }
            }
        } else if (qdlVar2 == null || qdlVar2.qdl().size() == 0) {
            if (mapQdl.size() != 0) {
                Iterator<String> it2 = mapQdl.keySet().iterator();
                while (it2.hasNext()) {
                    com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVar4 = mapQdl.get(it2.next());
                    if (qdlVar4 != null) {
                        arrayList2.addAll(qdlVar4.mo());
                    }
                }
            }
        } else {
            Map<String, com.bytedance.sdk.component.adexpress.qdl.lnr.qdl> mapQdl3 = qdlVar2.qdl();
            for (String str : mapQdl.keySet()) {
                com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVar5 = mapQdl.get(str);
                com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVar6 = mapQdl3.get(str);
                if (qdlVar6 == null && qdlVar5 != null) {
                    arrayList2.addAll(qdlVar5.mo());
                } else if (qdlVar5 == null && qdlVar6 != null) {
                    arrayList.addAll(qdlVar6.mo());
                } else if (qdlVar5 != null) {
                    for (qdl.C0201qdl c0201qdl : qdlVar5.mo()) {
                        if (c0201qdl != null && !qdlVar6.mo().contains(c0201qdl) && c0201qdl.ud() != null && c0201qdl.qdl() != null) {
                            arrayList2.add(c0201qdl);
                        }
                    }
                    for (qdl.C0201qdl c0201qdl2 : qdlVar6.mo()) {
                        if (c0201qdl2 != null && !qdlVar5.mo().contains(c0201qdl2)) {
                            arrayList.add(c0201qdl2);
                        }
                    }
                }
            }
        }
        if (qdl(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    private boolean qdl(List<qdl.C0201qdl> list, List<qdl.C0201qdl> list2) {
        for (qdl.C0201qdl c0201qdl : list) {
            String strQdl = c0201qdl.qdl();
            String strQdl2 = com.bytedance.sdk.component.utils.mzz.qdl(strQdl);
            File file = new File(qdl(), strQdl2);
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
            com.bytedance.sdk.component.wd.ud.qdl qdlVarMo = com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().lnr().mo();
            qdlVarMo.ud(strQdl);
            qdlVarMo.qdl(qdl().getAbsolutePath(), strQdl2);
            com.bytedance.sdk.component.wd.ud udVarQdl = qdlVarMo.qdl();
            list2.add(c0201qdl);
            if (udVarQdl == null || !udVarQdl.mo() || udVarQdl.mzz() == null || !udVarQdl.mzz().exists()) {
                lnr(list2);
                return false;
            }
        }
        return true;
    }

    public List<qdl.C0201qdl> ud(com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVar, com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVar2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (qdlVar2 == null || qdlVar2.mo().isEmpty()) {
            arrayList2.addAll(qdlVar.mo());
        } else if (qdlVar.mo().isEmpty()) {
            arrayList.addAll(qdlVar2.mo());
        } else {
            for (qdl.C0201qdl c0201qdl : qdlVar.mo()) {
                if (!qdlVar2.mo().contains(c0201qdl) && c0201qdl != null && c0201qdl.qdl() != null && c0201qdl.ud() != null) {
                    arrayList2.add(c0201qdl);
                }
            }
            for (qdl.C0201qdl c0201qdl2 : qdlVar2.mo()) {
                if (!qdlVar.mo().contains(c0201qdl2)) {
                    arrayList.add(c0201qdl2);
                }
            }
        }
        if (qdl(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    public void ud(List<qdl.C0201qdl> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<qdl.C0201qdl> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(qdl(), com.bytedance.sdk.component.utils.mzz.qdl(it.next().qdl()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public boolean qdl(String str) {
        String strQdl = com.bytedance.sdk.component.utils.mzz.qdl(str);
        File file = new File(qdl().getAbsoluteFile(), strQdl + ".zip");
        com.bytedance.sdk.component.wd.ud.qdl qdlVarMo = com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().lnr().mo();
        qdlVarMo.ud(str);
        qdlVarMo.qdl(file.getParent(), file.getName());
        com.bytedance.sdk.component.wd.ud udVarQdl = qdlVarMo.qdl();
        if (udVarQdl.mo() && udVarQdl.mzz() != null && udVarQdl.mzz().exists()) {
            File fileMzz = udVarQdl.mzz();
            try {
                kdv.qdl(fileMzz.getAbsolutePath(), file.getParent());
                if (!fileMzz.exists()) {
                    return true;
                }
                fileMzz.delete();
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public void qdl(int i) {
        if (com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().mml() != null) {
            com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().mml().qdl(i);
        }
    }

    public void lnr(List<qdl.C0201qdl> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<qdl.C0201qdl> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(qdl(), com.bytedance.sdk.component.utils.mzz.qdl(it.next().qdl()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public static void qdl(File file, com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVar, String str) {
        FileOutputStream fileOutputStream;
        if (qdlVar == null) {
            return;
        }
        String str2 = qdlVar.to();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        File file2 = new File(file, str);
        File file3 = new File(file2 + ".tmp");
        if (file3.exists()) {
            file3.delete();
        }
        try {
            fileOutputStream = new FileOutputStream(file3);
            try {
                fileOutputStream.write(str2.getBytes("utf-8"));
                if (file2.exists()) {
                    file2.delete();
                }
                file3.renameTo(file2);
                try {
                    fileOutputStream.close();
                } catch (IOException unused) {
                }
            } catch (Throwable unused2) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                    }
                }
            }
        } catch (Throwable unused4) {
            fileOutputStream = null;
        }
    }

    public static boolean lnr(com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVar, com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVar2) {
        if (qdlVar != null) {
            try {
                if (!TextUtils.isEmpty(qdlVar.lnr())) {
                    if (qdlVar2 == null) {
                        return false;
                    }
                    String strWd = qdlVar.wd();
                    String strWd2 = qdlVar2.wd();
                    if ((!TextUtils.isEmpty(strWd2) && !strWd2.equals(strWd)) || qdl(qdlVar.lnr(), qdlVar2.lnr())) {
                        return true;
                    }
                    Map<String, com.bytedance.sdk.component.adexpress.qdl.lnr.qdl> mapQdl = qdlVar.qdl();
                    Map<String, com.bytedance.sdk.component.adexpress.qdl.lnr.qdl> mapQdl2 = qdlVar2.qdl();
                    if (mapQdl.isEmpty()) {
                        return !mapQdl2.isEmpty();
                    }
                    if (mapQdl2.isEmpty()) {
                        return false;
                    }
                    return qdl(mapQdl, mapQdl2);
                }
            } catch (Throwable th) {
                th.getMessage();
                return false;
            }
        }
        return true;
    }

    private static boolean qdl(Map<String, com.bytedance.sdk.component.adexpress.qdl.lnr.qdl> map, Map<String, com.bytedance.sdk.component.adexpress.qdl.lnr.qdl> map2) {
        if (map.size() != map2.size()) {
            return true;
        }
        for (String str : map2.keySet()) {
            com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVar = map.get(str);
            if (qdlVar == null) {
                return true;
            }
            com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVar2 = map2.get(str);
            if (qdlVar2 == null) {
                return false;
            }
            if (qdl(qdlVar.lnr(), qdlVar2.lnr())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean qdl(java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "\\."
            java.lang.String[] r7 = r7.split(r0)
            java.lang.String[] r6 = r6.split(r0)
            int r0 = r7.length
            int r1 = r6.length
            int r0 = java.lang.Math.min(r0, r1)
            r1 = 0
            r2 = r1
        L12:
            if (r2 >= r0) goto L42
            r3 = r7[r2]
            int r3 = r3.length()
            r4 = r6[r2]
            int r4 = r4.length()
            int r3 = r3 - r4
            r4 = 1
            if (r3 != 0) goto L3f
            r3 = r7[r2]
            r5 = r6[r2]
            int r3 = r3.compareTo(r5)
            if (r3 <= 0) goto L2f
            return r4
        L2f:
            if (r3 >= 0) goto L32
            return r1
        L32:
            int r3 = r0 + (-1)
            if (r2 != r3) goto L3c
            int r7 = r7.length
            int r6 = r6.length
            if (r7 <= r6) goto L3b
            return r4
        L3b:
            return r1
        L3c:
            int r2 = r2 + 1
            goto L12
        L3f:
            if (r3 <= 0) goto L42
            return r4
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.qdl.ud.lnr.qdl(java.lang.String, java.lang.String):boolean");
    }

    public static boolean qdl(com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVar, String str) {
        if (qdlVar == null) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(qdlVar.lnr())) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return qdl(qdlVar.lnr(), str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void ud(File file, com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVar, String str) {
        if (qdlVar == null || file == null) {
            return;
        }
        try {
            new File(file, str).delete();
        } catch (Throwable unused) {
        }
        if (qdlVar.mo() != null) {
            Iterator<qdl.C0201qdl> it = qdlVar.mo().iterator();
            while (it.hasNext()) {
                try {
                    new File(file, com.bytedance.sdk.component.utils.mzz.qdl(it.next().qdl())).delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }
}
