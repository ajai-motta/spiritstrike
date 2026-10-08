package com.tnkfactory.framework.vo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class ValueObjectAssembler implements Map<String, ValueObject>, Externalizable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, ValueObject> f3241a = new HashMap();

    @Override // java.util.Map
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ValueObject put(String str, ValueObject valueObject) {
        return this.f3241a.put(str, valueObject);
    }

    @Override // java.util.Map
    public void clear() {
        this.f3241a.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f3241a.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f3241a.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, ValueObject>> entrySet() {
        return this.f3241a.entrySet();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Map
    public ValueObject get(Object obj) {
        return this.f3241a.get(obj);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f3241a.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.f3241a.keySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends ValueObject> map) {
        this.f3241a.putAll(map);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        this.f3241a = (Map) objectInput.readObject();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Map
    public ValueObject remove(Object obj) {
        return this.f3241a.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.f3241a.size();
    }

    public String toString() {
        return this.f3241a.toString();
    }

    @Override // java.util.Map
    public Collection<ValueObject> values() {
        return this.f3241a.values();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this.f3241a);
    }
}
