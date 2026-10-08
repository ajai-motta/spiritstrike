package com.hive.plugin;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.AuthV4;
import com.hive.HiveActivity;
import com.hive.Permission;
import com.hive.ResultAPI;
import com.hive.base.Android;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class AuthV4 {
    private ICallEngine callEngine;
    public Helper helper;

    public AuthV4(ICallEngine iCallEngine) {
        this.helper = new Helper(iCallEngine);
        this.callEngine = iCallEngine;
    }

    public String setup(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.setup(new AuthV4.AuthV4SetupListener() { // from class: com.hive.plugin.AuthV4.1
            @Override // com.hive.AuthV4.AuthV4SetupListener
            public void onAuthV4Setup(ResultAPI resultAPI, boolean z, String str2, ArrayList<AuthV4.ProviderType> arrayList) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("isAutoSignIn", z);
                    jSONObjectCreateResponse.put("did", str2);
                    JSONArray jSONArray = new JSONArray();
                    for (AuthV4.ProviderType providerType : arrayList) {
                        new JSONObject();
                        jSONArray.put(providerType);
                    }
                    jSONObjectCreateResponse.put("providerTypeList", jSONArray);
                } catch (Exception unused) {
                }
                AuthV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String signIn(final String str, final JSONObject jSONObject) {
        String strOptString = jSONObject.optString("providerType");
        if (!"".equals(strOptString) && strOptString != null) {
            String upperCase = strOptString.toUpperCase(Locale.US);
            if (!"".equals(upperCase) && upperCase != null) {
                com.hive.AuthV4.signIn(AuthV4.ProviderType.valueOf(upperCase), new AuthV4.AuthV4SignInListener() { // from class: com.hive.plugin.AuthV4.2
                    @Override // com.hive.AuthV4.AuthV4SignInListener
                    public void onAuthV4SignIn(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo) {
                        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                        try {
                            jSONObjectCreateResponse.put("playerInfo", AuthV4.this.playerInfoToJson(playerInfo));
                        } catch (Exception unused) {
                        }
                        AuthV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
                    }
                });
            }
        }
        return "";
    }

    public String signInWithAuthKey(final String str, final JSONObject jSONObject) {
        String strOptString = jSONObject.optString("authKey");
        if (!"".equals(strOptString) && strOptString != null) {
            com.hive.AuthV4.signInWithAuthKey(strOptString, new AuthV4.AuthV4SignInListener() { // from class: com.hive.plugin.AuthV4.3
                @Override // com.hive.AuthV4.AuthV4SignInListener
                public void onAuthV4SignIn(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo) {
                    JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                    try {
                        jSONObjectCreateResponse.put("playerInfo", AuthV4.this.playerInfoToJson(playerInfo));
                    } catch (Exception unused) {
                    }
                    AuthV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
                }
            });
        }
        return "";
    }

    public String signOut(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.signOut(new AuthV4.AuthV4SignOutListener() { // from class: com.hive.plugin.AuthV4.4
            @Override // com.hive.AuthV4.AuthV4SignOutListener
            public void onAuthV4SignOut(ResultAPI resultAPI) {
                AuthV4.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String playerDelete(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.playerDelete(new AuthV4.AuthV4SignOutListener() { // from class: com.hive.plugin.AuthV4.5
            @Override // com.hive.AuthV4.AuthV4SignOutListener
            public void onAuthV4SignOut(ResultAPI resultAPI) {
                AuthV4.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String connect(final String str, final JSONObject jSONObject) {
        String strOptString = jSONObject.optString("providerType");
        if (!"".equals(strOptString) && strOptString != null) {
            String upperCase = strOptString.toUpperCase(Locale.US);
            if (!"".equals(upperCase) && upperCase != null) {
                com.hive.AuthV4.connect(AuthV4.ProviderType.valueOf(upperCase), new AuthV4.AuthV4ConnectListener() { // from class: com.hive.plugin.AuthV4.6
                    @Override // com.hive.AuthV4.AuthV4ConnectListener
                    public void onAuthV4Connect(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo) {
                        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                        try {
                            jSONObjectCreateResponse.put("conflictPlayer", AuthV4.this.playerInfoToJson(playerInfo));
                        } catch (Exception unused) {
                        }
                        AuthV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
                    }
                });
            }
        }
        return "";
    }

    public String connectWithAuthKey(final String str, final JSONObject jSONObject) {
        String strOptString = jSONObject.optString("authKey");
        if (!"".equals(strOptString) && strOptString != null) {
            com.hive.AuthV4.connectWithAuthKey(strOptString, new AuthV4.AuthV4ConnectListener() { // from class: com.hive.plugin.AuthV4.7
                @Override // com.hive.AuthV4.AuthV4ConnectListener
                public void onAuthV4Connect(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo) {
                    JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                    try {
                        jSONObjectCreateResponse.put("conflictPlayer", AuthV4.this.playerInfoToJson(playerInfo));
                    } catch (Exception unused) {
                    }
                    AuthV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
                }
            });
        }
        return "";
    }

    public String disconnect(final String str, final JSONObject jSONObject) {
        String strOptString = jSONObject.optString("providerType");
        if (!"".equals(strOptString) && strOptString != null) {
            String upperCase = strOptString.toUpperCase(Locale.US);
            if (!"".equals(upperCase) && upperCase != null) {
                com.hive.AuthV4.disconnect(AuthV4.ProviderType.valueOf(upperCase), new AuthV4.AuthV4DisconnectListener() { // from class: com.hive.plugin.AuthV4.8
                    @Override // com.hive.AuthV4.AuthV4DisconnectListener
                    public void onAuthV4Disconnect(ResultAPI resultAPI) {
                        AuthV4.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
                    }
                });
            }
        }
        return "";
    }

    public String disconnectWithName(final String str, final JSONObject jSONObject) {
        String strOptString = jSONObject.optString("providerName");
        if (!"".equals(strOptString) && strOptString != null) {
            com.hive.AuthV4.disconnectWithName(strOptString, new AuthV4.AuthV4DisconnectListener() { // from class: com.hive.plugin.AuthV4.9
                @Override // com.hive.AuthV4.AuthV4DisconnectListener
                public void onAuthV4Disconnect(ResultAPI resultAPI) {
                    AuthV4.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
                }
            });
        }
        return "";
    }

    public String selectConflict(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.selectConflict(jSONObject.optLong("selectedPlayerId"), new AuthV4.AuthV4SignInListener() { // from class: com.hive.plugin.AuthV4.10
            @Override // com.hive.AuthV4.AuthV4SignInListener
            public void onAuthV4SignIn(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("playerInfo", AuthV4.this.playerInfoToJson(playerInfo));
                } catch (Exception unused) {
                }
                AuthV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String isAutoSignIn(String str, JSONObject jSONObject) {
        boolean zIsAutoSignIn = com.hive.AuthV4.isAutoSignIn();
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("isAutoSignIn", zIsAutoSignIn);
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String getAgeGateU13(String str, JSONObject jSONObject) {
        boolean ageGateU13 = com.hive.AuthV4.INSTANCE.getAgeGateU13();
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("ageGateU13", ageGateU13);
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String getPlayerInfo(String str, JSONObject jSONObject) {
        AuthV4.PlayerInfo playerInfo = com.hive.AuthV4.getPlayerInfo();
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("getPlayerInfo", playerInfoToJson(playerInfo));
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String getProfile(final String str, final JSONObject jSONObject) {
        List<Object> listJsonToList = Android.INSTANCE.jsonToList(jSONObject.optJSONArray("playerIdList"));
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = listJsonToList.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(Long.parseLong((String) it.next())));
        }
        com.hive.AuthV4.getProfile(arrayList, new AuthV4.AuthV4GetProfileListener() { // from class: com.hive.plugin.AuthV4.11
            @Override // com.hive.AuthV4.AuthV4GetProfileListener
            public void onAuthV4GetProfile(ResultAPI resultAPI, ArrayList<AuthV4.ProfileInfo> arrayList2) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                JSONArray jSONArray = new JSONArray();
                try {
                    Iterator<AuthV4.ProfileInfo> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        jSONArray.put(AuthV4.this.profileInfoToJson(it2.next()));
                    }
                    jSONObjectCreateResponse.put("profileInfoList", jSONArray);
                } catch (Exception unused) {
                }
                AuthV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String showSignIn(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.showSignIn(new AuthV4.AuthV4SignInListener() { // from class: com.hive.plugin.AuthV4.12
            @Override // com.hive.AuthV4.AuthV4SignInListener
            public void onAuthV4SignIn(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("playerInfo", AuthV4.this.playerInfoToJson(playerInfo));
                } catch (Exception unused) {
                }
                AuthV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String showConflictSelection(final String str, final JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("currentPlayerData");
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("conflictPlayerData");
        Map<String, Object> mapJsonToMap = null;
        Map<String, Object> mapJsonToMap2 = (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() <= 0) ? null : Android.INSTANCE.jsonToMap(jSONObjectOptJSONObject);
        if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
            mapJsonToMap = Android.INSTANCE.jsonToMap(jSONObjectOptJSONObject2);
        }
        com.hive.AuthV4.showConflictSelection(mapJsonToMap2, mapJsonToMap, new AuthV4.AuthV4SignInListener() { // from class: com.hive.plugin.AuthV4.13
            @Override // com.hive.AuthV4.AuthV4SignInListener
            public void onAuthV4SignIn(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("playerInfo", AuthV4.this.playerInfoToJson(playerInfo));
                } catch (Exception unused) {
                }
                AuthV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String showProfile(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.showProfile(jSONObject.optLong("playerId"), new AuthV4.AuthV4ShowProfileListener() { // from class: com.hive.plugin.AuthV4.14
            @Override // com.hive.AuthV4.AuthV4ShowProfileListener
            public void onAuthV4ShowProfile(ResultAPI resultAPI) {
                AuthV4.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String showInquiry(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.showInquiry(new AuthV4.AuthV4ShowInquiryListener() { // from class: com.hive.plugin.AuthV4.15
            @Override // com.hive.AuthV4.AuthV4ShowInquiryListener
            public void onAuthV4ShowInquiry(ResultAPI resultAPI) {
                AuthV4.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String showMyInquiry(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.showMyInquiry(new AuthV4.AuthV4ShowMyInquiryListener() { // from class: com.hive.plugin.AuthV4.16
            @Override // com.hive.AuthV4.AuthV4ShowMyInquiryListener
            public void onAuthV4ShowMyInquiry(ResultAPI resultAPI) {
                AuthV4.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String showChatbotInquiry(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.showChatbotInquiry(jSONObject.optString("additionalInfo"), new AuthV4.AuthV4ShowChatbotInquiryListener() { // from class: com.hive.plugin.AuthV4.17
            @Override // com.hive.AuthV4.AuthV4ShowChatbotInquiryListener
            public void onAuthV4ShowChatbotInquiry(ResultAPI resultAPI) {
                AuthV4.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String showTerms(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.showTerms(new AuthV4.AuthV4ShowTermsListener() { // from class: com.hive.plugin.AuthV4.18
            @Override // com.hive.AuthV4.AuthV4ShowTermsListener
            public void onAuthV4ShowTerms(ResultAPI resultAPI) {
                AuthV4.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String showAdultConfirm(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.showAdultConfirm(new AuthV4.AuthV4AdultConfirmListener() { // from class: com.hive.plugin.AuthV4.19
            @Override // com.hive.AuthV4.AuthV4AdultConfirmListener
            public void onAuthV4AdultConfirm(ResultAPI resultAPI) {
                AuthV4.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String showIdentityVerification(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.showIdentityVerification(new AuthV4.AuthV4ShowIdentityVerificationListener() { // from class: com.hive.plugin.AuthV4.20
            @Override // com.hive.AuthV4.AuthV4ShowIdentityVerificationListener
            public void onAuthV4ShowIdentityVerification(ResultAPI resultAPI, AuthV4.Identity identity) {
                JSONObject jSONObject2;
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    if (identity != null) {
                        jSONObject2 = identity.toJSON();
                    } else {
                        jSONObject2 = new JSONObject();
                    }
                    jSONObjectCreateResponse.put("identity", jSONObject2);
                } catch (Exception unused) {
                }
                AuthV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String checkProvider(final String str, final JSONObject jSONObject) {
        String strOptString = jSONObject.optString("providerType");
        if (!"".equals(strOptString) && strOptString != null) {
            String upperCase = strOptString.toUpperCase(Locale.US);
            if (!"".equals(upperCase) && upperCase != null) {
                com.hive.AuthV4.checkProvider(AuthV4.ProviderType.valueOf(upperCase), new AuthV4.AuthV4CheckProviderListener() { // from class: com.hive.plugin.AuthV4.21
                    @Override // com.hive.AuthV4.AuthV4CheckProviderListener
                    public void onDeviceProviderInfo(ResultAPI resultAPI, AuthV4.ProviderInfo providerInfo) {
                        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                        try {
                            jSONObjectCreateResponse.put("providerInfo", AuthV4.this.providerInfoToJson(providerInfo));
                        } catch (Exception unused) {
                        }
                        AuthV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
                    }
                });
            }
        }
        return "";
    }

    public String checkMaintenance(final String str, final JSONObject jSONObject) {
        boolean zOptBoolean = jSONObject.optBoolean("isShow");
        Boolean.valueOf(zOptBoolean).getClass();
        com.hive.AuthV4.checkMaintenance(zOptBoolean, new AuthV4.AuthV4MaintenanceListener() { // from class: com.hive.plugin.AuthV4.22
            @Override // com.hive.AuthV4.AuthV4MaintenanceListener
            public void onAuthV4Maintenance(ResultAPI resultAPI, ArrayList<AuthV4.AuthV4MaintenanceInfo> arrayList) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<AuthV4.AuthV4MaintenanceInfo> it = arrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(AuthV4.this.maintenanceInfoToJson(it.next()));
                    }
                    jSONObjectCreateResponse.put("AuthV4MaintenanceInfoList", jSONArray);
                } catch (Exception unused) {
                }
                AuthV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String checkBlacklist(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.checkBlacklist(jSONObject.optBoolean("isShow"), new AuthV4.AuthV4MaintenanceListener() { // from class: com.hive.plugin.AuthV4.23
            @Override // com.hive.AuthV4.AuthV4MaintenanceListener
            public void onAuthV4Maintenance(ResultAPI resultAPI, ArrayList<AuthV4.AuthV4MaintenanceInfo> arrayList) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    JSONArray jSONArray = new JSONArray();
                    if (arrayList != null) {
                        Iterator<AuthV4.AuthV4MaintenanceInfo> it = arrayList.iterator();
                        while (it.hasNext()) {
                            jSONArray.put(AuthV4.this.maintenanceInfoToJson(it.next()));
                        }
                    }
                    jSONObjectCreateResponse.put("AuthV4MaintenanceInfoList", jSONArray);
                } catch (Exception unused) {
                }
                AuthV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String setProviderChangedListener(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.setProviderChangedListener(new AuthV4.AuthV4CheckProviderListener() { // from class: com.hive.plugin.AuthV4.24
            @Override // com.hive.AuthV4.AuthV4CheckProviderListener
            public void onDeviceProviderInfo(ResultAPI resultAPI, AuthV4.ProviderInfo providerInfo) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("providerInfo", AuthV4.this.providerInfoToJson(providerInfo));
                } catch (Exception unused) {
                }
                AuthV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String resetAgreement(String str, JSONObject jSONObject) {
        com.hive.AuthV4.resetAgreement();
        return "";
    }

    public String getProviderFriendsList(final String str, final JSONObject jSONObject) {
        String strOptString = jSONObject.optString("providerType");
        if (!"".equals(strOptString) && strOptString != null) {
            String upperCase = strOptString.toUpperCase(Locale.US);
            if (!"".equals(upperCase) && upperCase != null) {
                com.hive.AuthV4.getProviderFriendsList(AuthV4.ProviderType.valueOf(upperCase), new AuthV4.AuthV4ProviderFriendsListener() { // from class: com.hive.plugin.AuthV4.25
                    @Override // com.hive.AuthV4.AuthV4ProviderFriendsListener
                    public void onGetProviderFriendsList(ResultAPI resultAPI, AuthV4.ProviderType providerType, Map<String, Long> map) {
                        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObjectCreateResponse.put("providerType", providerType.name());
                            for (String str2 : map.keySet()) {
                                jSONObject2.put(str2, map.get(str2));
                            }
                            jSONObjectCreateResponse.put("providerUserIdList", jSONObject2);
                        } catch (Exception unused) {
                        }
                        AuthV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
                    }
                });
            }
        }
        return "";
    }

    public String resolveConflict(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.resolveConflict(new AuthV4.AuthV4ResolveConflictListener() { // from class: com.hive.plugin.AuthV4.26
            @Override // com.hive.AuthV4.AuthV4ResolveConflictListener
            public void onAuthV4ResolveConflict(ResultAPI resultAPI) {
                AuthV4.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String showDeviceManagement(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.showDeviceManagement(new AuthV4.AuthV4ShowDeviceManagementListener() { // from class: com.hive.plugin.AuthV4.27
            @Override // com.hive.AuthV4.AuthV4ShowDeviceManagementListener
            public void onAuthV4ShowDeviceManagement(ResultAPI resultAPI) {
                AuthV4.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String requestPermissionViewData(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.INSTANCE.requestPermissionViewData(new Permission.PermissionViewDataListener() { // from class: com.hive.plugin.AuthV4.28
            @Override // com.hive.Permission.PermissionViewDataListener
            public void onPermissionViewData(ResultAPI resultAPI, Permission.PermissionViewData permissionViewData) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                if (permissionViewData != null) {
                    try {
                        jSONObject2.put("contents", permissionViewData.getContents());
                        JSONArray jSONArray = new JSONArray();
                        for (Permission.PermissionViewUnitData permissionViewUnitData : permissionViewData.getPermissions()) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("contents", permissionViewUnitData.getContents());
                            jSONObject3.put("nativePermissionName", permissionViewUnitData.getNativePermissionName());
                            jSONObject3.put("permissionCategory", permissionViewUnitData.getPermissionCategory().getId());
                            jSONObject3.put("title", permissionViewUnitData.getTitle());
                            jSONArray.put(jSONObject3);
                        }
                        jSONObject2.put("permissions", jSONArray);
                        JSONArray jSONArray2 = new JSONArray();
                        for (Permission.PermissionViewUnitData permissionViewUnitData2 : permissionViewData.getCommons()) {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("contents", permissionViewUnitData2.getContents());
                            jSONObject4.put("nativePermissionName", permissionViewUnitData2.getNativePermissionName());
                            jSONObject4.put("permissionCategory", permissionViewUnitData2.getPermissionCategory().getId());
                            jSONObject4.put("title", permissionViewUnitData2.getTitle());
                            jSONArray2.put(jSONObject4);
                        }
                        jSONObject2.put("commons", jSONArray2);
                        jSONObjectCreateResponse.put("data", jSONObject2);
                    } catch (Exception unused) {
                    }
                }
                AuthV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String refreshAccessToken(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.refreshAccessToken(new AuthV4.AuthV4RefreshAccessTokenListener() { // from class: com.hive.plugin.AuthV4$$ExternalSyntheticLambda5
            @Override // com.hive.AuthV4.AuthV4RefreshAccessTokenListener
            public final void onAuthV4RefreshAccessToken(ResultAPI resultAPI, String str2) {
                this.f$0.m5560lambda$refreshAccessToken$0$comhivepluginAuthV4(jSONObject, str, resultAPI, str2);
            }
        });
        return "";
    }

    /* JADX INFO: renamed from: lambda$refreshAccessToken$0$com-hive-plugin-AuthV4, reason: not valid java name */
    /* synthetic */ void m5560lambda$refreshAccessToken$0$comhivepluginAuthV4(JSONObject jSONObject, String str, ResultAPI resultAPI, String str2) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
        try {
            jSONObjectCreateResponse.put("accessToken", str2);
        } catch (Exception unused) {
        }
        this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
    }

    public String signInWithStoredPlayerId(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.signInWithStoredPlayerId(jSONObject.optLong("playerId"), jSONObject.optBoolean("useAutoSignIn"), new AuthV4.AuthV4SignInListener() { // from class: com.hive.plugin.AuthV4.29
            @Override // com.hive.AuthV4.AuthV4SignInListener
            public void onAuthV4SignIn(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("playerInfo", AuthV4.this.playerInfoToJson(playerInfo));
                } catch (Exception unused) {
                }
                AuthV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String getStoredPlayerIdList(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.getStoredPlayerIdList(new AuthV4.AuthV4PlayerIdListListener() { // from class: com.hive.plugin.AuthV4.30
            @Override // com.hive.AuthV4.AuthV4PlayerIdListListener
            public void onAuthV4GetPlayerIdList(ResultAPI resultAPI, ArrayList<Long> arrayList) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                JSONArray jSONArray = new JSONArray();
                try {
                    Iterator<Long> it = arrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next());
                    }
                    jSONObjectCreateResponse.put("playerIdList", jSONArray);
                } catch (Exception unused) {
                }
                AuthV4.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String storeCurrentPlayerId(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.storeCurrentPlayerId(new AuthV4.AuthV4StorePlayerIdListener() { // from class: com.hive.plugin.AuthV4.31
            @Override // com.hive.AuthV4.AuthV4StorePlayerIdListener
            public void onAuthV4StorePlayerId(ResultAPI resultAPI) {
                AuthV4.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String deleteStoredPlayerId(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.deleteStoredPlayerId(jSONObject.optLong("playerId"), new AuthV4.AuthV4DeletePlayerIdListener() { // from class: com.hive.plugin.AuthV4.32
            @Override // com.hive.AuthV4.AuthV4DeletePlayerIdListener
            public void onAuthV4DeletePlayerId(ResultAPI resultAPI) {
                AuthV4.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String getHashedDi(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.getHashedDi(new AuthV4.AuthV4GetHashedDiListener() { // from class: com.hive.plugin.AuthV4$$ExternalSyntheticLambda2
            @Override // com.hive.AuthV4.AuthV4GetHashedDiListener
            public final void onAuthV4GetHashedDi(ResultAPI resultAPI, String str2) {
                this.f$0.m5559lambda$getHashedDi$1$comhivepluginAuthV4(jSONObject, str, resultAPI, str2);
            }
        });
        return "";
    }

    /* JADX INFO: renamed from: lambda$getHashedDi$1$com-hive-plugin-AuthV4, reason: not valid java name */
    /* synthetic */ void m5559lambda$getHashedDi$1$comhivepluginAuthV4(JSONObject jSONObject, String str, ResultAPI resultAPI, String str2) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
        try {
            jSONObjectCreateResponse.put("hashedDi", str2);
        } catch (Exception unused) {
        }
        this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
    }

    public String checkAgeGate(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.checkAgeGate(jSONObject.optBoolean("useCloseButton"), new AuthV4.AuthV4AgeGateListener() { // from class: com.hive.plugin.AuthV4$$ExternalSyntheticLambda4
            @Override // com.hive.AuthV4.AuthV4AgeGateListener
            public final void onAuthV4AgeGate(ResultAPI resultAPI, String str2) {
                this.f$0.m5557lambda$checkAgeGate$2$comhivepluginAuthV4(jSONObject, str, resultAPI, str2);
            }
        });
        return "";
    }

    /* JADX INFO: renamed from: lambda$checkAgeGate$2$com-hive-plugin-AuthV4, reason: not valid java name */
    /* synthetic */ void m5557lambda$checkAgeGate$2$comhivepluginAuthV4(JSONObject jSONObject, String str, ResultAPI resultAPI, String str2) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
        try {
            jSONObjectCreateResponse.put("dateOfBirth", str2);
        } catch (Exception unused) {
        }
        this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
    }

    public String setAutoLoginEnabled(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.setAutoLoginEnabled(jSONObject.optBoolean("enabled"), new AuthV4.AuthV4SetAutoLoginEnabledListener() { // from class: com.hive.plugin.AuthV4$$ExternalSyntheticLambda1
            @Override // com.hive.AuthV4.AuthV4SetAutoLoginEnabledListener
            public final void onAuthV4SetAutoLoginEnabled(ResultAPI resultAPI, boolean z) {
                this.f$0.m5561lambda$setAutoLoginEnabled$3$comhivepluginAuthV4(jSONObject, str, resultAPI, z);
            }
        });
        return "";
    }

    /* JADX INFO: renamed from: lambda$setAutoLoginEnabled$3$com-hive-plugin-AuthV4, reason: not valid java name */
    /* synthetic */ void m5561lambda$setAutoLoginEnabled$3$comhivepluginAuthV4(JSONObject jSONObject, String str, ResultAPI resultAPI, boolean z) {
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
        try {
            jSONObjectCreateResponse.put("enabled", z);
        } catch (Exception unused) {
        }
        this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
    }

    public String getAgeRange(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.getAgeRange(new AuthV4.AuthV4GetAgeRangeListener() { // from class: com.hive.plugin.AuthV4$$ExternalSyntheticLambda3
            @Override // com.hive.AuthV4.AuthV4GetAgeRangeListener
            public final void onAuthV4GetAgeRange(ResultAPI resultAPI, AuthV4.AgeRange ageRange) {
                this.f$0.m5558lambda$getAgeRange$4$comhivepluginAuthV4(jSONObject, str, resultAPI, ageRange);
            }
        });
        return "";
    }

    /* JADX INFO: renamed from: lambda$getAgeRange$4$com-hive-plugin-AuthV4, reason: not valid java name */
    /* synthetic */ void m5558lambda$getAgeRange$4$comhivepluginAuthV4(JSONObject jSONObject, String str, ResultAPI resultAPI, AuthV4.AgeRange ageRange) {
        JSONObject json;
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
        try {
            if (ageRange == null) {
                json = new JSONObject();
            } else {
                json = ageRange.toJSON();
            }
            jSONObjectCreateResponse.put("ageRange", json);
        } catch (Exception unused) {
        }
        this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
    }

    public String showAgeRangeUpdatePermission(final String str, final JSONObject jSONObject) {
        com.hive.AuthV4.showAgeRangeUpdatePermission(jSONObject.optString("description"), new AuthV4.AuthV4GetAgeRangeListener() { // from class: com.hive.plugin.AuthV4$$ExternalSyntheticLambda0
            @Override // com.hive.AuthV4.AuthV4GetAgeRangeListener
            public final void onAuthV4GetAgeRange(ResultAPI resultAPI, AuthV4.AgeRange ageRange) {
                this.f$0.m5562lambda$showAgeRangeUpdatePermission$5$comhivepluginAuthV4(jSONObject, str, resultAPI, ageRange);
            }
        });
        return "";
    }

    /* JADX INFO: renamed from: lambda$showAgeRangeUpdatePermission$5$com-hive-plugin-AuthV4, reason: not valid java name */
    /* synthetic */ void m5562lambda$showAgeRangeUpdatePermission$5$comhivepluginAuthV4(JSONObject jSONObject, String str, ResultAPI resultAPI, AuthV4.AgeRange ageRange) {
        JSONObject json;
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
        try {
            if (ageRange == null) {
                json = new JSONObject();
            } else {
                json = ageRange.toJSON();
            }
            jSONObjectCreateResponse.put("ageRange", json);
        } catch (Exception unused) {
        }
        this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
    }

    private int getAuthV4MaintenanceActionTypeInt(AuthV4.AuthV4MaintenanceActionType authV4MaintenanceActionType) {
        if (authV4MaintenanceActionType == AuthV4.AuthV4MaintenanceActionType.OPEN_URL) {
            return 1;
        }
        if (authV4MaintenanceActionType == AuthV4.AuthV4MaintenanceActionType.EXIT) {
            return 2;
        }
        return authV4MaintenanceActionType == AuthV4.AuthV4MaintenanceActionType.DONE ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject providerInfoToJson(AuthV4.ProviderInfo providerInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            AuthV4.ProviderType providerType = providerInfo.getProviderType();
            jSONObject.put("providerName", providerInfo.getProviderName());
            jSONObject.put("providerType", providerType.getIndex());
            jSONObject.put("providerUserId", providerInfo.getProviderUserId());
            jSONObject.put("providerAppId", providerInfo.getProviderAppId());
            jSONObject.put("providerEmail", providerInfo.getProviderEmail());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject maintenanceInfoToJson(AuthV4.AuthV4MaintenanceInfo authV4MaintenanceInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("title", authV4MaintenanceInfo.getTitle());
            jSONObject.put("message", authV4MaintenanceInfo.getMessage());
            jSONObject.put("button", authV4MaintenanceInfo.getButton());
            jSONObject.put(NativeProtocol.WEB_DIALOG_ACTION, getAuthV4MaintenanceActionTypeInt(authV4MaintenanceInfo.getAction()));
            jSONObject.put("url", authV4MaintenanceInfo.getUrl());
            jSONObject.put("remainingTime", authV4MaintenanceInfo.getRemainingTime());
            jSONObject.put("startDate", authV4MaintenanceInfo.getStartDate());
            jSONObject.put("endDate", authV4MaintenanceInfo.getEndDate());
            jSONObject.put("customerButton", authV4MaintenanceInfo.getCustomerButton());
            jSONObject.put("customerLink", authV4MaintenanceInfo.getCustomerLink());
            jSONObject.put("exButtons", exButtonsToJSONArray(authV4MaintenanceInfo.getExButtons()));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject playerInfoToJson(AuthV4.PlayerInfo playerInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playerId", playerInfo.getPlayerId());
            jSONObject.put("playerName", playerInfo.getPlayerName());
            jSONObject.put("playerImageUrl", playerInfo.getPlayerImageUrl());
            jSONObject.put("playerToken", playerInfo.getPlayerToken());
            jSONObject.put("did", playerInfo.getDid());
            jSONObject.put("accessToken", playerInfo.getAccessToken());
            JSONObject jSONObject2 = new JSONObject();
            for (AuthV4.ProviderType providerType : playerInfo.getProviderInfoData().keySet()) {
                jSONObject2.put(providerType.toString(), providerInfoToJson(playerInfo.getProviderInfoData().get(providerType)));
            }
            jSONObject.put("providerInfoData", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (String str : playerInfo.getCustomProviderInfoData().keySet()) {
                jSONObject3.put(str, providerInfoToJson(playerInfo.getCustomProviderInfoData().get(str)));
            }
            jSONObject.put("customProviderInfoData", jSONObject3);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject profileInfoToJson(AuthV4.ProfileInfo profileInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playerId", profileInfo.getPlayerId());
            jSONObject.put("playerName", profileInfo.getPlayerName());
            jSONObject.put("playerImageUrl", profileInfo.getPlayerImageUrl());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray idpListToJSONArray(ArrayList<AuthV4.ProviderType> arrayList) {
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<AuthV4.ProviderType> it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            return jSONArray;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONArray exButtonsToJSONArray(List<AuthV4.AuthV4MaintenanceExtraButton> list) {
        if (list == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (AuthV4.AuthV4MaintenanceExtraButton authV4MaintenanceExtraButton : list) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(NativeProtocol.WEB_DIALOG_ACTION, getAuthV4MaintenanceActionTypeInt(authV4MaintenanceExtraButton.getAction()));
                    String button = "";
                    jSONObject.put("url", TextUtils.isEmpty(authV4MaintenanceExtraButton.getUrl()) ? "" : authV4MaintenanceExtraButton.getUrl());
                    if (!TextUtils.isEmpty(authV4MaintenanceExtraButton.getButton())) {
                        button = authV4MaintenanceExtraButton.getButton();
                    }
                    jSONObject.put("button", button);
                } catch (Exception unused) {
                }
                jSONArray.put(jSONObject);
            }
            return jSONArray;
        } catch (Exception unused2) {
            return null;
        }
    }

    public String executeNative(final String str, final String str2, final JSONObject jSONObject) {
        if ("isAutoSignIn".equals(str)) {
            return isAutoSignIn(str2, jSONObject);
        }
        if ("getAgeGateU13".equals(str)) {
            return getAgeGateU13(str2, jSONObject);
        }
        if ("getPlayerInfo".equals(str)) {
            return getPlayerInfo(str2, jSONObject);
        }
        HiveActivity hiveActivity = HiveActivity.INSTANCE;
        if (!HiveActivity.isActivityInitialized()) {
            com.hive.Logger logger = com.hive.Logger.INSTANCE;
            com.hive.Logger.e("Plugin", "HiveActivity.getRecentActivity() == null");
            return "";
        }
        HiveActivity.INSTANCE.getRecentActivity().runOnUiThread(new Runnable() { // from class: com.hive.plugin.AuthV4.33
            @Override // java.lang.Runnable
            public void run() {
                if ("setup".equals(str)) {
                    AuthV4.this.setup(str2, jSONObject);
                    return;
                }
                if ("signIn".equals(str)) {
                    AuthV4.this.signIn(str2, jSONObject);
                    return;
                }
                if ("signInWithAuthKey".equals(str)) {
                    AuthV4.this.signInWithAuthKey(str2, jSONObject);
                    return;
                }
                if ("signOut".equals(str)) {
                    AuthV4.this.signOut(str2, jSONObject);
                    return;
                }
                if ("playerDelete".equals(str)) {
                    AuthV4.this.playerDelete(str2, jSONObject);
                    return;
                }
                if ("connect".equals(str)) {
                    AuthV4.this.connect(str2, jSONObject);
                    return;
                }
                if ("connectWithAuthKey".equals(str)) {
                    AuthV4.this.connectWithAuthKey(str2, jSONObject);
                    return;
                }
                if ("disconnect".equals(str)) {
                    AuthV4.this.disconnect(str2, jSONObject);
                    return;
                }
                if ("disconnectWithName".equals(str)) {
                    AuthV4.this.disconnectWithName(str2, jSONObject);
                    return;
                }
                if ("selectConflict".equals(str)) {
                    AuthV4.this.selectConflict(str2, jSONObject);
                    return;
                }
                if ("getProfile".equals(str)) {
                    AuthV4.this.getProfile(str2, jSONObject);
                    return;
                }
                if ("showSignIn".equals(str)) {
                    AuthV4.this.showSignIn(str2, jSONObject);
                    return;
                }
                if ("showConflictSelection".equals(str)) {
                    AuthV4.this.showConflictSelection(str2, jSONObject);
                    return;
                }
                if ("showProfile".equals(str)) {
                    AuthV4.this.showProfile(str2, jSONObject);
                    return;
                }
                if ("showInquiry".equals(str)) {
                    AuthV4.this.showInquiry(str2, jSONObject);
                    return;
                }
                if ("showMyInquiry".equals(str)) {
                    AuthV4.this.showMyInquiry(str2, jSONObject);
                    return;
                }
                if ("showChatbotInquiry".equals(str)) {
                    AuthV4.this.showChatbotInquiry(str2, jSONObject);
                    return;
                }
                if ("showTerms".equals(str)) {
                    AuthV4.this.showTerms(str2, jSONObject);
                    return;
                }
                if ("showAdultConfirm".equals(str)) {
                    AuthV4.this.showAdultConfirm(str2, jSONObject);
                    return;
                }
                if ("showIdentityVerification".equals(str)) {
                    AuthV4.this.showIdentityVerification(str2, jSONObject);
                    return;
                }
                if ("checkProvider".equals(str)) {
                    AuthV4.this.checkProvider(str2, jSONObject);
                    return;
                }
                if ("checkMaintenance".equals(str)) {
                    AuthV4.this.checkMaintenance(str2, jSONObject);
                    return;
                }
                if ("checkBlacklist".equals(str)) {
                    AuthV4.this.checkBlacklist(str2, jSONObject);
                    return;
                }
                if ("setProviderChangedListener".equals(str)) {
                    AuthV4.this.setProviderChangedListener(str2, jSONObject);
                    return;
                }
                if ("resetAgreement".equals(str)) {
                    AuthV4.this.resetAgreement(str2, jSONObject);
                    return;
                }
                if ("getProviderFriendsList".equals(str)) {
                    AuthV4.this.getProviderFriendsList(str2, jSONObject);
                    return;
                }
                if ("resolveConflict".equals(str)) {
                    AuthV4.this.resolveConflict(str2, jSONObject);
                    return;
                }
                if ("showDeviceManagement".equals(str)) {
                    AuthV4.this.showDeviceManagement(str2, jSONObject);
                    return;
                }
                if ("requestPermissionViewData".equals(str)) {
                    AuthV4.this.requestPermissionViewData(str2, jSONObject);
                    return;
                }
                if ("refreshAccessToken".equals(str)) {
                    AuthV4.this.refreshAccessToken(str2, jSONObject);
                    return;
                }
                if ("signInWithStoredPlayerId".equals(str)) {
                    AuthV4.this.signInWithStoredPlayerId(str2, jSONObject);
                    return;
                }
                if ("getStoredPlayerIdList".equals(str)) {
                    AuthV4.this.getStoredPlayerIdList(str2, jSONObject);
                    return;
                }
                if ("storeCurrentPlayerId".equals(str)) {
                    AuthV4.this.storeCurrentPlayerId(str2, jSONObject);
                    return;
                }
                if ("deleteStoredPlayerId".equals(str)) {
                    AuthV4.this.deleteStoredPlayerId(str2, jSONObject);
                    return;
                }
                if ("getHashedDi".equals(str)) {
                    AuthV4.this.getHashedDi(str2, jSONObject);
                    return;
                }
                if ("checkAgeGate".equals(str)) {
                    AuthV4.this.checkAgeGate(str2, jSONObject);
                    return;
                }
                if ("setAutoLoginEnabled".equals(str)) {
                    AuthV4.this.setAutoLoginEnabled(str2, jSONObject);
                } else if ("getAgeRange".equals(str)) {
                    AuthV4.this.getAgeRange(str2, jSONObject);
                } else if ("showAgeRangeUpdatePermission".equals(str)) {
                    AuthV4.this.showAgeRangeUpdatePermission(str2, jSONObject);
                }
            }
        });
        return "";
    }

    public class Helper {
        private ICallEngine callEngine;

        public Helper(ICallEngine iCallEngine) {
            this.callEngine = iCallEngine;
        }

        public String syncAccount(final String str, final JSONObject jSONObject) {
            String strOptString = jSONObject.optString("providerType");
            if (!"".equals(strOptString) && strOptString != null) {
                String upperCase = strOptString.toUpperCase(Locale.US);
                if (!"".equals(upperCase) && upperCase != null) {
                    AuthV4.ProviderType providerTypeValueOf = AuthV4.ProviderType.valueOf(upperCase);
                    AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
                    AuthV4.Helper.syncAccount(providerTypeValueOf, new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.plugin.AuthV4.Helper.1
                        @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                        public void onAuthV4Helper(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo) {
                            JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                            try {
                                jSONObjectCreateResponse.put("playerInfo", AuthV4.this.playerInfoToJson(playerInfo));
                            } catch (Exception unused) {
                            }
                            Helper.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
                        }
                    });
                }
            }
            return "";
        }

        public String signIn(final String str, final JSONObject jSONObject) {
            AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
            AuthV4.Helper.signIn(new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.plugin.AuthV4.Helper.2
                @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                public void onAuthV4Helper(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo) {
                    JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                    try {
                        jSONObjectCreateResponse.put("playerInfo", AuthV4.this.playerInfoToJson(playerInfo));
                    } catch (Exception unused) {
                    }
                    Helper.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
                }
            });
            return "";
        }

        public String signOut(final String str, final JSONObject jSONObject) {
            AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
            AuthV4.Helper.signOut(new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.plugin.AuthV4.Helper.3
                @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                public void onAuthV4Helper(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo) {
                    JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                    try {
                        jSONObjectCreateResponse.put("playerInfo", AuthV4.this.playerInfoToJson(playerInfo));
                    } catch (Exception unused) {
                    }
                    Helper.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
                }
            });
            return "";
        }

        public String playerDelete(final String str, final JSONObject jSONObject) {
            AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
            AuthV4.Helper.playerDelete(new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.plugin.AuthV4.Helper.4
                @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                public void onAuthV4Helper(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo) {
                    JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                    try {
                        jSONObjectCreateResponse.put("playerInfo", AuthV4.this.playerInfoToJson(playerInfo));
                    } catch (Exception unused) {
                    }
                    Helper.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
                }
            });
            return "";
        }

        public String connect(final String str, final JSONObject jSONObject) {
            String strOptString = jSONObject.optString("providerType");
            if (!"".equals(strOptString) && strOptString != null) {
                String upperCase = strOptString.toUpperCase(Locale.US);
                if (!"".equals(upperCase) && upperCase != null) {
                    AuthV4.ProviderType providerTypeValueOf = AuthV4.ProviderType.valueOf(upperCase);
                    AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
                    AuthV4.Helper.connect(providerTypeValueOf, new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.plugin.AuthV4.Helper.5
                        @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                        public void onAuthV4Helper(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo) {
                            JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                            try {
                                jSONObjectCreateResponse.put("playerInfo", AuthV4.this.playerInfoToJson(playerInfo));
                            } catch (Exception unused) {
                            }
                            Helper.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
                        }
                    });
                }
            }
            return "";
        }

        public String disconnect(final String str, final JSONObject jSONObject) {
            String strOptString = jSONObject.optString("providerType");
            if (!"".equals(strOptString) && strOptString != null) {
                String upperCase = strOptString.toUpperCase(Locale.US);
                if (!"".equals(upperCase) && upperCase != null) {
                    AuthV4.ProviderType providerTypeValueOf = AuthV4.ProviderType.valueOf(upperCase);
                    AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
                    AuthV4.Helper.disconnect(providerTypeValueOf, new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.plugin.AuthV4.Helper.6
                        @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                        public void onAuthV4Helper(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo) {
                            JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                            try {
                                jSONObjectCreateResponse.put("playerInfo", AuthV4.this.playerInfoToJson(playerInfo));
                            } catch (Exception unused) {
                            }
                            Helper.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
                        }
                    });
                }
            }
            return "";
        }

        public String showLeaderboard(final String str, final JSONObject jSONObject) {
            AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
            AuthV4.Helper.showLeaderboard(new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.plugin.AuthV4.Helper.7
                @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                public void onAuthV4Helper(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo) {
                    JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                    try {
                        jSONObjectCreateResponse.put("playerInfo", AuthV4.this.playerInfoToJson(playerInfo));
                    } catch (Exception unused) {
                    }
                    Helper.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
                }
            });
            return "";
        }

        public String showAchievements(final String str, final JSONObject jSONObject) {
            AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
            AuthV4.Helper.showAchievements(new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.plugin.AuthV4.Helper.8
                @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                public void onAuthV4Helper(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo) {
                    JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                    try {
                        jSONObjectCreateResponse.put("playerInfo", AuthV4.this.playerInfoToJson(playerInfo));
                    } catch (Exception unused) {
                    }
                    Helper.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
                }
            });
            return "";
        }

        public String showConflict(final String str, final JSONObject jSONObject) {
            AuthV4.Helper.AuthV4HelperListener authV4HelperListener = new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.plugin.AuthV4.Helper.9
                @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                public void onAuthV4Helper(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo) {
                    JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                    try {
                        jSONObjectCreateResponse.put("playerInfo", AuthV4.this.playerInfoToJson(playerInfo));
                    } catch (Exception unused) {
                    }
                    Helper.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
                }
            };
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("playerData");
            if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() == 0) {
                AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
                AuthV4.Helper.showConflict(authV4HelperListener);
                return "";
            }
            AuthV4.Helper.ConflictSingleViewInfo conflictSingleViewInfo = new AuthV4.Helper.ConflictSingleViewInfo(((Number) Android.INSTANCE.jsonToMap(jSONObjectOptJSONObject).get("player_id")).longValue());
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("game_data");
            if (jSONObjectOptJSONObject2 != null) {
                conflictSingleViewInfo.setGameData(Android.INSTANCE.jsonToMap(jSONObjectOptJSONObject2));
            }
            AuthV4.Helper helper2 = AuthV4.Helper.INSTANCE;
            AuthV4.Helper.showConflict(conflictSingleViewInfo, authV4HelperListener);
            return "";
        }

        public String switchAccount(final String str, final JSONObject jSONObject) {
            AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
            AuthV4.Helper.switchAccount(new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.plugin.AuthV4.Helper.10
                @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                public void onAuthV4Helper(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo) {
                    JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                    try {
                        jSONObjectCreateResponse.put("playerInfo", AuthV4.this.playerInfoToJson(playerInfo));
                    } catch (Exception unused) {
                    }
                    Helper.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
                }
            });
            return "";
        }

        public String helperResolveConflict(final String str, final JSONObject jSONObject) {
            AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
            AuthV4.Helper.resolveConflict(new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.plugin.AuthV4.Helper.11
                @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                public void onAuthV4Helper(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo) {
                    JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                    try {
                        jSONObjectCreateResponse.put("playerInfo", AuthV4.this.playerInfoToJson(playerInfo));
                    } catch (Exception unused) {
                    }
                    Helper.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
                }
            });
            return "";
        }

        public String getIDPList(String str, JSONObject jSONObject) {
            AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
            ArrayList<AuthV4.ProviderType> idpList = AuthV4.Helper.getIdpList();
            JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
            try {
                jSONObjectCreateResponse.put("idpList", AuthV4.this.idpListToJSONArray(idpList));
            } catch (Exception unused) {
            }
            return jSONObjectCreateResponse.toString();
        }

        public String leaderboardsSubmitScore(final String str, final JSONObject jSONObject) {
            String strOptString = jSONObject.optString("leaderboardId");
            long jOptLong = jSONObject.optLong(FirebaseAnalytics.Param.SCORE);
            if (TextUtils.isEmpty(strOptString)) {
                return "";
            }
            if (TextUtils.isEmpty(jSONObject.optString("handler"))) {
                AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
                AuthV4.Helper.leaderboardsSubmitScore(strOptString, jOptLong);
            } else {
                AuthV4.Helper helper2 = AuthV4.Helper.INSTANCE;
                AuthV4.Helper.leaderboardsSubmitScore(strOptString, jOptLong, new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.plugin.AuthV4.Helper.12
                    @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                    public void onAuthV4Helper(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo) {
                        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                        try {
                            jSONObjectCreateResponse.put("playerInfo", AuthV4.this.playerInfoToJson(playerInfo));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Helper.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
                    }
                });
            }
            return "";
        }

        public String achievementsReveal(final String str, final JSONObject jSONObject) {
            String strOptString = jSONObject.optString("achievementId");
            if (TextUtils.isEmpty(strOptString)) {
                return "";
            }
            if (TextUtils.isEmpty(jSONObject.optString("handler"))) {
                AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
                AuthV4.Helper.achievementsReveal(strOptString);
            } else {
                AuthV4.Helper helper2 = AuthV4.Helper.INSTANCE;
                AuthV4.Helper.achievementsReveal(strOptString, new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.plugin.AuthV4.Helper.13
                    @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                    public void onAuthV4Helper(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo) {
                        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                        try {
                            jSONObjectCreateResponse.put("playerInfo", AuthV4.this.playerInfoToJson(playerInfo));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Helper.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
                    }
                });
            }
            return "";
        }

        public String achievementsUnlock(final String str, final JSONObject jSONObject) {
            String strOptString = jSONObject.optString("achievementId");
            if (TextUtils.isEmpty(strOptString)) {
                return "";
            }
            if (TextUtils.isEmpty(jSONObject.optString("handler"))) {
                AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
                AuthV4.Helper.achievementsUnlock(strOptString);
            } else {
                AuthV4.Helper helper2 = AuthV4.Helper.INSTANCE;
                AuthV4.Helper.achievementsUnlock(strOptString, new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.plugin.AuthV4.Helper.14
                    @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                    public void onAuthV4Helper(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo) {
                        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                        try {
                            jSONObjectCreateResponse.put("playerInfo", AuthV4.this.playerInfoToJson(playerInfo));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Helper.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
                    }
                });
            }
            return "";
        }

        public String achievementsIncrement(final String str, final JSONObject jSONObject) {
            String strOptString = jSONObject.optString("achievementId");
            int iOptInt = jSONObject.optInt("value");
            if (TextUtils.isEmpty(strOptString)) {
                return "";
            }
            if (TextUtils.isEmpty(jSONObject.optString("handler"))) {
                AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
                AuthV4.Helper.achievementsIncrement(strOptString, iOptInt);
            } else {
                AuthV4.Helper helper2 = AuthV4.Helper.INSTANCE;
                AuthV4.Helper.achievementsIncrement(strOptString, iOptInt, new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.plugin.AuthV4.Helper.15
                    @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                    public void onAuthV4Helper(ResultAPI resultAPI, AuthV4.PlayerInfo playerInfo) {
                        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                        try {
                            jSONObjectCreateResponse.put("playerInfo", AuthV4.this.playerInfoToJson(playerInfo));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Helper.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
                    }
                });
            }
            return "";
        }

        public String executeNative(final String str, final String str2, final JSONObject jSONObject) {
            if ("getIDPList".equals(str)) {
                return getIDPList(str2, jSONObject);
            }
            HiveActivity hiveActivity = HiveActivity.INSTANCE;
            if (!HiveActivity.isActivityInitialized()) {
                com.hive.Logger logger = com.hive.Logger.INSTANCE;
                com.hive.Logger.e("Plugin", "HiveActivity.getRecentActivity() == null");
                return "";
            }
            HiveActivity.INSTANCE.getRecentActivity().runOnUiThread(new Runnable() { // from class: com.hive.plugin.AuthV4.Helper.16
                @Override // java.lang.Runnable
                public void run() {
                    if ("syncAccount".equals(str)) {
                        Helper.this.syncAccount(str2, jSONObject);
                        return;
                    }
                    if ("signIn".equals(str)) {
                        Helper.this.signIn(str2, jSONObject);
                        return;
                    }
                    if ("signOut".equals(str)) {
                        Helper.this.signOut(str2, jSONObject);
                        return;
                    }
                    if ("playerDelete".equals(str)) {
                        Helper.this.playerDelete(str2, jSONObject);
                        return;
                    }
                    if ("connect".equals(str)) {
                        Helper.this.connect(str2, jSONObject);
                        return;
                    }
                    if ("disconnect".equals(str)) {
                        Helper.this.disconnect(str2, jSONObject);
                        return;
                    }
                    if ("leaderboardsSubmitScore".equals(str)) {
                        Helper.this.leaderboardsSubmitScore(str2, jSONObject);
                        return;
                    }
                    if ("showLeaderboard".equals(str)) {
                        Helper.this.showLeaderboard(str2, jSONObject);
                        return;
                    }
                    if ("achievementsReveal".equals(str)) {
                        Helper.this.achievementsReveal(str2, jSONObject);
                        return;
                    }
                    if ("achievementsUnlock".equals(str)) {
                        Helper.this.achievementsUnlock(str2, jSONObject);
                        return;
                    }
                    if ("achievementsIncrement".equals(str)) {
                        Helper.this.achievementsIncrement(str2, jSONObject);
                        return;
                    }
                    if ("showAchievements".equals(str)) {
                        Helper.this.showAchievements(str2, jSONObject);
                        return;
                    }
                    if ("showConflict".equals(str)) {
                        Helper.this.showConflict(str2, jSONObject);
                        return;
                    }
                    if ("switchAccount".equals(str)) {
                        Helper.this.switchAccount(str2, jSONObject);
                    } else if ("resolveConflict".equals(str)) {
                        Helper.this.helperResolveConflict(str2, jSONObject);
                    } else if ("getAgeGateU13".equals(str)) {
                        AuthV4.this.getAgeGateU13(str2, jSONObject);
                    }
                }
            });
            return "";
        }
    }
}
