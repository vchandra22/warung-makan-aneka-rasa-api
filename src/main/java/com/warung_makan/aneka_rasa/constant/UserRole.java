package com.warung_makan.aneka_rasa.constant;

public enum UserRole {
    CUSTOMER("PELANGGAN"),
    ADMIN("KARYAWAN");

    private String value;

    UserRole(String value) {
        this.value = value;
    }

    public static UserRole fromValue(String value) {
        for (UserRole userRole : values()) {
            if (userRole.value.equalsIgnoreCase(value)) {
                return userRole;
            }
        }
        return null;
    }


}
