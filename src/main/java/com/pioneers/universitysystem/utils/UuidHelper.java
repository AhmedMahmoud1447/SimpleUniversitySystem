package com.pioneers.universitysystem.utils;

import java.util.UUID;

public final class UuidHelper {

    private UuidHelper() {
        throw new IllegalStateException("This is a utility class!");
    }

    public static String generateRandomId() {
        return UUID.randomUUID().toString();
    }
}
