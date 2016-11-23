/*
 *  Copyright (c) Jarek Ratajski, Licensed under the Apache License, Version 2.0   http://www.apache.org/licenses/LICENSE-2.0
 */
package pl.setblack.airomem.core;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jarekr
 */
public class StorableObject implements Serializable {

    public final HashMap<String, String> internalMap;

    private transient Map<String, String> immutable;

    public StorableObject(HashMap<String, String> intenralMap) {
        this.internalMap = intenralMap;
        this.immutable = Collections.unmodifiableMap(intenralMap);
    }


    public synchronized Map<String, String> getImmutable() {
        if (this.immutable == null) {
            this.immutable = Collections.unmodifiableMap(internalMap);
        }
        return immutable;
    }

    public static HashMap createTestHashMap() {
        final HashMap<String, String> result = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            result.put("key:" + i, "val:" + i);
        }
        return result;
    }

    public static StorableObject createTestObject() {
        return new StorableObject(createTestHashMap());
    }
}
