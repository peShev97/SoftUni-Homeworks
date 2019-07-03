package Articles;

public class Articles {
    private String title;
    private String content;
    private String author;

    public Articles(String title, String content, String author) {
        this.content = content;
        this.author = author;
        this.title = title;
    }

    public void editContent(String newContent) {
        this.content = newContent;
    }

    public void changeAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    public void renameTitle(String newTitle) {
        this.title = newTitle;
    }

    public String toString() {
        return String.format("%s - %s: %s", this.title, this.content, this.author);
    }
}