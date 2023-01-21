public enum MenuChoice {
    GO_SELLER(1, "1. К торговцу"),
    GO_FOREST(2, "2. В тёмный лес"),
    GO_AWAY(3, "3. На выход");

    private final int code;

    private final String displayName;

    MenuChoice(int code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }

    public int getCode() {
        return code;
    }

    public String getDisplayName() {
        return displayName;
    }
}
