package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FilterWord {
    private boolean lnr;
    private List<FilterWord> mml;
    private String qdl;
    private String ud;

    public FilterWord(String str, String str2) {
        this.qdl = str;
        this.ud = str2;
    }

    public FilterWord() {
    }

    public String getId() {
        return this.qdl;
    }

    public void setId(String str) {
        this.qdl = str;
    }

    public String getName() {
        return this.ud;
    }

    public void setName(String str) {
        this.ud = str;
    }

    public boolean getIsSelected() {
        return this.lnr;
    }

    public void setIsSelected(boolean z) {
        this.lnr = z;
    }

    public List<FilterWord> getOptions() {
        return this.mml;
    }

    public void addOption(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        if (this.mml == null) {
            this.mml = new ArrayList();
        }
        this.mml.add(filterWord);
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.qdl) || TextUtils.isEmpty(this.ud)) ? false : true;
    }

    public boolean hasSecondOptions() {
        List<FilterWord> list = this.mml;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FilterWord)) {
            return false;
        }
        FilterWord filterWord = (FilterWord) obj;
        return filterWord.getId().equals(getId()) && filterWord.getName().equals(getName());
    }
}
