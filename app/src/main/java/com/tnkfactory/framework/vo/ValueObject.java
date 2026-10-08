package com.tnkfactory.framework.vo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class ValueObject implements List<Map<String, Object>>, Externalizable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3240a;
    public List<Map<String, Object>> b;

    public ValueObject() {
        this.f3240a = "";
        this.b = new ArrayList();
    }

    public ValueObject(String str) {
        this.f3240a = "";
        this.b = new ArrayList();
        this.f3240a = str;
    }

    public ValueObject(String str, Map<String, Object> map) {
        this.f3240a = "";
        this.b = new ArrayList();
        this.f3240a = str;
        if (map != null) {
            add(map);
        }
    }

    public ValueObject(Map<String, Object> map) {
        this.f3240a = "";
        this.b = new ArrayList();
        if (map != null) {
            add(map);
        }
    }

    @Override // java.util.List
    public void add(int i, Map<String, Object> map) {
        this.b.add(i, map);
    }

    public void add(ValueObject valueObject) {
        if (valueObject != null) {
            for (int i = 0; i < valueObject.size(); i++) {
                this.b.add(valueObject.get(i));
            }
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Map<String, Object> map) {
        return this.b.add(map);
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends Map<String, Object>> collection) {
        return this.b.addAll(i, collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Map<String, Object>> collection) {
        return this.b.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.b.clear();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.b.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.b.containsAll(collection);
    }

    public Object get(int i, String str) {
        return this.b.get(i).get(str);
    }

    public Object get(int i, String str, Object obj) {
        Object obj2 = this.b.get(i).get(str);
        return obj2 == null ? obj : obj2;
    }

    public Object get(String str) {
        return this.b.get(0).get(str);
    }

    @Override // java.util.List
    public Map<String, Object> get(int i) {
        return this.b.get(i);
    }

    public boolean getBoolean(int i, String str) {
        return getBoolean(i, str, false);
    }

    public boolean getBoolean(int i, String str, boolean z) {
        Object obj = this.b.get(i).get(str);
        return obj == null ? z : obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(String.valueOf(obj));
    }

    public boolean getBoolean(String str) {
        return getBoolean(0, str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        return getBoolean(0, str, z);
    }

    public double getDouble(int i, String str) {
        return getDouble(i, str, 0.0d);
    }

    public double getDouble(int i, String str, double d) {
        Object obj = this.b.get(i).get(str);
        if (obj == null) {
            return d;
        }
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        String strValueOf = String.valueOf(obj);
        return strValueOf.length() == 0 ? d : Double.parseDouble(strValueOf);
    }

    public double getDouble(String str) {
        return getDouble(0, str, 0.0d);
    }

    public double getDouble(String str, double d) {
        return getDouble(0, str, d);
    }

    public float getFloat(int i, String str) {
        return getFloat(i, str, 0.0f);
    }

    public float getFloat(int i, String str, float f) {
        Object obj = this.b.get(i).get(str);
        if (obj == null) {
            return f;
        }
        if (obj instanceof Number) {
            return ((Number) obj).floatValue();
        }
        String strValueOf = String.valueOf(obj);
        return strValueOf.length() == 0 ? f : Float.parseFloat(strValueOf);
    }

    public float getFloat(String str) {
        return getFloat(0, str, 0.0f);
    }

    public float getFloat(String str, float f) {
        return getFloat(0, str, f);
    }

    public int getInt(int i, String str) {
        return getInt(i, str, 0);
    }

    public int getInt(int i, String str, int i2) {
        Object obj = this.b.get(i).get(str);
        if (obj == null) {
            return i2;
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        String strValueOf = String.valueOf(obj);
        return strValueOf.length() == 0 ? i2 : Integer.parseInt(strValueOf);
    }

    public int getInt(String str) {
        return getInt(0, str, 0);
    }

    public int getInt(String str, int i) {
        return getInt(0, str, i);
    }

    public long getLong(int i, String str) {
        return getLong(i, str, 0L);
    }

    public long getLong(int i, String str, long j) {
        Object obj = this.b.get(i).get(str);
        if (obj == null) {
            return j;
        }
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        String strValueOf = String.valueOf(obj);
        return strValueOf.length() == 0 ? j : Long.parseLong(strValueOf);
    }

    public long getLong(String str) {
        return getLong(0, str, 0L);
    }

    public long getLong(String str, long j) {
        return getLong(0, str, j);
    }

    public String getName() {
        return this.f3240a;
    }

    public ValueObject getRowAsVo(int i) {
        ValueObject valueObject = new ValueObject();
        valueObject.add(get(i));
        return valueObject;
    }

    public String getString(int i, String str) {
        return getString(i, str, null);
    }

    public String getString(int i, String str, String str2) {
        BigDecimal bigDecimalValueOf;
        Object obj = this.b.get(i).get(str);
        if (obj == null) {
            return str2;
        }
        if ((obj instanceof Double) || (obj instanceof Float)) {
            bigDecimalValueOf = BigDecimal.valueOf(((Number) obj).doubleValue());
        } else {
            if (!(obj instanceof Long) && !(obj instanceof Integer)) {
                return String.valueOf(obj);
            }
            bigDecimalValueOf = BigDecimal.valueOf(((Number) obj).longValue());
        }
        return bigDecimalValueOf.toString();
    }

    public String getString(String str) {
        return getString(0, str, null);
    }

    public String getString(String str, String str2) {
        return getString(0, str, str2);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.b.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<Map<String, Object>> iterator() {
        return this.b.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.b.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<Map<String, Object>> listIterator() {
        return this.b.listIterator();
    }

    @Override // java.util.List
    public ListIterator<Map<String, Object>> listIterator(int i) {
        return this.b.listIterator(i);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        this.f3240a = objectInput.readUTF();
        Object[] objArr = (Object[]) objectInput.readObject();
        this.b.clear();
        for (Object obj : objArr) {
            this.b.add((Map) obj);
        }
    }

    @Override // java.util.List
    public Map<String, Object> remove(int i) {
        return this.b.remove(i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        return this.b.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return this.b.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return this.b.retainAll(collection);
    }

    @Override // java.util.List
    public Map<String, Object> set(int i, Map<String, Object> map) {
        return this.b.set(i, map);
    }

    public void set(int i, String str, double d) {
        set(i, str, Double.valueOf(d));
    }

    public void set(int i, String str, float f) {
        set(i, str, Float.valueOf(f));
    }

    public void set(int i, String str, int i2) {
        set(i, str, Integer.valueOf(i2));
    }

    public void set(int i, String str, long j) {
        set(i, str, Long.valueOf(j));
    }

    public void set(int i, String str, Object obj) {
        Map<String, Object> map;
        if (i >= this.b.size() || this.b.get(i) == null) {
            HashMap map2 = new HashMap();
            add(i, (Map<String, Object>) map2);
            map = map2;
        } else {
            map = this.b.get(i);
        }
        map.put(str, obj);
    }

    public void set(int i, String str, boolean z) {
        set(i, str, Boolean.valueOf(z));
    }

    public void set(String str, double d) {
        set(0, str, Double.valueOf(d));
    }

    public void set(String str, float f) {
        set(0, str, Float.valueOf(f));
    }

    public void set(String str, int i) {
        set(0, str, Integer.valueOf(i));
    }

    public void set(String str, long j) {
        set(0, str, Long.valueOf(j));
    }

    public void set(String str, Object obj) {
        set(0, str, obj);
    }

    public void set(String str, boolean z) {
        set(0, str, Boolean.valueOf(z));
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.b.size();
    }

    @Override // java.util.List
    public List<Map<String, Object>> subList(int i, int i2) {
        return this.b.subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.b.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.b.toArray(tArr);
    }

    public String toString() {
        return this.b.toString();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeUTF(this.f3240a);
        List<Map<String, Object>> list = this.b;
        objectOutput.writeObject(list.toArray(new Object[list.size()]));
    }
}
