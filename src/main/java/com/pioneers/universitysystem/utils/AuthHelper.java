package com.pioneers.universitysystem.utils;

public class AuthHelper {

    public static boolean isPasswordMatched(final String sourcePassword, final String targetPassword) {
        return sourcePassword.equals(targetPassword);
    }
}
