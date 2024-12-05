import java.util.Date;

public class TextFile extends File {
    private int lineCount;
    private int wordCount;
    private int characterCount;


    public TextFile(String filename, Date creationTime, Date updateTime,
                    int lineCount, int wordCount, int characterCount) {
        super(filename, "txt", creationTime, updateTime);
        this.lineCount = lineCount;
        this.wordCount = wordCount;
        this.characterCount = characterCount;
    }

    @Override
    public void printInfo() {
        System.out.println("File: " + getFilename());
        System.out.println("Extension: " + getExtension());
        System.out.println("Created: " + getCreationTime());
        System.out.println("Updated: " + getUpdateTime());
        System.out.println("Line count: " + lineCount);
        System.out.println("Word count: " + wordCount);
        System.out.println("Character count: " + characterCount);
    }

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getCharacterCount() {
        return characterCount;
    }

    public void setCharacterCount(int characterCount) {
        this.characterCount = characterCount;
    }
}