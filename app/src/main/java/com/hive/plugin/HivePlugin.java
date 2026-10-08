package com.hive.plugin;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.ResultAPI;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public abstract class HivePlugin implements ICallEngine {
    private Configuration configuration = new Configuration(this);
    private Analytics analytics = new Analytics(this);
    private SocialHive socialHive = new SocialHive(this);
    private SocialFacebook socialFacebook = new SocialFacebook(this);
    private SocialGoogle socialGoogle = new SocialGoogle(this);
    private Promotion promotion = new Promotion(this);
    private Push push = new Push(this);
    private Logger logger = new Logger(this);
    private PlatformHelper platforHelper = new PlatformHelper(this);
    private AuthV4 authV4 = new AuthV4(this);
    private ProviderFuntap providerFuntap = new ProviderFuntap(this);
    private ProviderGoogle providerGoogle = new ProviderGoogle(this);
    private IAPV4 iapV4 = new IAPV4(this);
    private SocialV4 socialV4 = new SocialV4(this);
    private DataStore dataStore = new DataStore(this);
    private MatchMaking matchMaking = new MatchMaking(this);
    private Chat chat = new Chat(this);

    public String executeNative(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("class");
            String strOptString2 = jSONObject.optString(FirebaseAnalytics.Param.METHOD);
            String strOptString3 = jSONObject.optString("targetObject");
            if ("Logger".equals(strOptString)) {
                return (String) invokeMethod(this.logger, strOptString2, new Object[]{strOptString3, jSONObject});
            }
            if ("Configuration".equals(strOptString)) {
                return (String) invokeMethod(this.configuration, strOptString2, new Object[]{strOptString3, jSONObject});
            }
            if ("Analytics".equals(strOptString)) {
                return (String) invokeMethod(this.analytics, strOptString2, new Object[]{strOptString3, jSONObject});
            }
            if ("SocialHive".equals(strOptString)) {
                return this.socialHive.executeNative(strOptString2, strOptString3, jSONObject);
            }
            if ("SocialFacebook".equals(strOptString)) {
                return this.socialFacebook.executeNative(strOptString2, strOptString3, jSONObject);
            }
            if (com.hive.SocialGoogle.TAG.equals(strOptString)) {
                return this.socialGoogle.executeNative(strOptString2, strOptString3, jSONObject);
            }
            if ("Promotion".equals(strOptString)) {
                return this.promotion.executeNative(strOptString2, strOptString3, jSONObject);
            }
            if ("Push".equals(strOptString)) {
                return this.push.executeNative(strOptString2, strOptString3, jSONObject);
            }
            if ("PlatformHelper".equals(strOptString)) {
                return this.platforHelper.executeNative(strOptString2, strOptString3, jSONObject);
            }
            if ("AuthV4".equals(strOptString)) {
                return this.authV4.executeNative(strOptString2, strOptString3, jSONObject);
            }
            if ("ProviderFuntap".equals(strOptString)) {
                return this.providerFuntap.executeNative(strOptString2, strOptString3, jSONObject);
            }
            if ("ProviderGoogle".equals(strOptString)) {
                return this.providerGoogle.executeNative(strOptString2, strOptString3, jSONObject);
            }
            if ("IAPV4".equals(strOptString)) {
                return this.iapV4.executeNative(strOptString2, strOptString3, jSONObject);
            }
            if ("AuthV4Helper".equals(strOptString)) {
                return this.authV4.helper.executeNative(strOptString2, strOptString3, jSONObject);
            }
            if ("SocialV4".equals(strOptString)) {
                return this.socialV4.executeNative(strOptString2, strOptString3, jSONObject);
            }
            if ("DataStore".equals(strOptString)) {
                return this.dataStore.executeNative(strOptString2, strOptString3, jSONObject);
            }
            if ("MatchMaking".equals(strOptString)) {
                return this.matchMaking.executeNative(strOptString2, strOptString3, jSONObject);
            }
            if ("Chat".equals(strOptString)) {
                return this.chat.executeNative(strOptString2, strOptString3, jSONObject);
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static JSONObject createResponse(ResultAPI resultAPI, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("class", jSONObject.optString("class"));
            jSONObject2.put(FirebaseAnalytics.Param.METHOD, jSONObject.optString(FirebaseAnalytics.Param.METHOD));
            jSONObject2.put("handler", jSONObject.opt("handler"));
            if (resultAPI != null) {
                jSONObject2.put("resultAPI", resultAPI.toJson());
            }
        } catch (Exception unused) {
        }
        return jSONObject2;
    }

    public static Object invokeMethod(String str, String str2, Object[] objArr) {
        try {
            Method[] methods = Class.forName(str).getMethods();
            for (int i = 0; i < methods.length; i++) {
                if (methods[i].getName().equals(str2)) {
                    if (methods[i].getReturnType().getName().equals("void")) {
                        methods[i].invoke(null, objArr);
                        return null;
                    }
                    return methods[i].invoke(null, objArr);
                }
            }
            return "";
        } catch (IllegalAccessException | InvocationTargetException | Exception unused) {
            return "";
        }
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr) {
        try {
            Method[] methods = obj.getClass().getMethods();
            for (int i = 0; i < methods.length; i++) {
                if (methods[i].getName().equals(str)) {
                    if (methods[i].getReturnType().getName().equals("void")) {
                        methods[i].invoke(obj, objArr);
                        return null;
                    }
                    return methods[i].invoke(obj, objArr);
                }
            }
            return "";
        } catch (IllegalAccessException | InvocationTargetException | Exception unused) {
            return "";
        }
    }
}
