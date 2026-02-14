package com.pioneers.universitysystem.utils;

public class NameHelper {

    public static String buildFullName(final String firstName, final String lastName) {
        return firstName.trim() + " " + lastName.trim();
    }
}
