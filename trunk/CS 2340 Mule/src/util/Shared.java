package util;

import java.net.URL;

public class Shared {
    public static enum Color {
        RED("red", Shared.class.getResource("/sprites/tiles/Border-Red.png")),
        YELLOW("yellow", Shared.class.getResource("/sprites/tiles/Border-Yellow.png")),
        GREEN("green", Shared.class.getResource("/sprites/tiles/Border-Green.png")),
        PURPLE("purple", Shared.class.getResource("/sprites/tiles/Border-Purple.png"));

        private String name;
        private URL borderImagePath;

        Color(String name, URL borderImagePath) {
            this.name = name;
            this.borderImagePath = borderImagePath;
        }

        public String toString() {
            return name;
        }

        public URL getBorderImagePath() {
            return borderImagePath;
        }
    }
}
