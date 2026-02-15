package com.pioneers.universitysystem.utils;

public final class NameHelper {

    private NameHelper() {
        throw new IllegalStateException("This is a utility class!");
    }
    public static String buildFullName(final String firstName, final String lastName) {
        return firstName.trim() + " " + lastName.trim();
    }
}
