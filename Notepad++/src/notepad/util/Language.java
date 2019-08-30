package notepad.util;

public class Language {
    private String keyStyle;
    private String extension;

    public Language(String keyStyle, String extension){
        this.keyStyle = keyStyle;
        this.extension = extension;
    }

    public String getKeyStyle() {
        return keyStyle;
    }

    public String getExtension() {
        return extension;
    }
}
