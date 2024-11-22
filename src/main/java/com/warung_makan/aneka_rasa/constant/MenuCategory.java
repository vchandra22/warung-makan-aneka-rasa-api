package com.warung_makan.aneka_rasa.constant;

public enum MenuCategory {
    FOOD("Makanan"),
    BEVERAGE("Minuman");

    private String value;

    MenuCategory(String value) {
        this.value = value;
    }

    public static MenuCategory fromValue(String value) {
        for (MenuCategory menuCategory : values()) {
            if (menuCategory.value.equalsIgnoreCase(value)) {
                return menuCategory;
            }
        }
    }
}
