package com.pioneers.universitysystem.utils;

import java.util.UUID;

public class UuidHelper {

    public static String generateRandomId() {
        return UUID.randomUUID().toString();
    }
}
