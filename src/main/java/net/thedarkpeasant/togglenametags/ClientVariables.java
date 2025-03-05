package net.thedarkpeasant.togglenametags;

public class ClientVariables {
    private static boolean showNametags = true;

    public static boolean shouldShowNametags() {
        return showNametags;
    }

    public static void setShowNametags(boolean value) {
        showNametags = value;
    }
}
