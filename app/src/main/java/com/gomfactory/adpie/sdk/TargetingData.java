package com.gomfactory.adpie.sdk;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TargetingData {
    private final int age;
    private final JSONObject customTargeting;
    private final Gender gender;
    private final int yearOfBirthday;

    public enum Gender {
        FEMALE,
        MALE,
        UNKNOWN
    }

    private TargetingData(Builder builder) {
        this.gender = builder.gender;
        this.yearOfBirthday = builder.yearOfBirthday;
        this.age = builder.age;
        this.customTargeting = builder.customTargeting;
    }

    public Gender getGender() {
        return this.gender;
    }

    public int getYearOfBirthday() {
        return this.yearOfBirthday;
    }

    public int getAge() {
        return this.age;
    }

    public JSONObject getCustomTargeting() {
        return this.customTargeting;
    }

    public static class Builder {
        private int age;
        private JSONObject customTargeting;
        private Gender gender;
        private int yearOfBirthday;

        public Builder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder setYearOfBirthday(int i) {
            this.yearOfBirthday = i;
            return this;
        }

        public Builder setAge(int i) {
            this.age = i;
            return this;
        }

        public Builder setCustomTargeting(JSONObject jSONObject) {
            this.customTargeting = jSONObject;
            return this;
        }

        public TargetingData build() {
            return new TargetingData(this);
        }
    }
}
