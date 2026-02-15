package com.pioneers.universitysystem.utils;

public final class AuthHelper {

    private AuthHelper() {
        throw new IllegalStateException("This is a utility class!");
    }

    public static boolean isPasswordMatched(final String sourcePassword, final String targetPassword) {
        return sourcePassword.equals(targetPassword);
    }
}
