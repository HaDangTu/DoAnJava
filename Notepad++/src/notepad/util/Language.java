package notepad.util;

public class Language {
    private String keyStyle;
    private String fileType;

    public Language(String keyStyle, String fileType){
        this.keyStyle = keyStyle;
        this.fileType = fileType;
    }

    public String getKeyStyle() {
        return keyStyle;
    }

    public String getFileType() {
        return fileType;
    }
}
