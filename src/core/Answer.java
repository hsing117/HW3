package core;

import java.util.ArrayList;

public class Answer {
    private String text;
    private String author;
    private ArrayList<String> markedHelpful;

    public Answer(String text, String author) {
        this.text = text;
        this.author = author;
        this.markedHelpful = new ArrayList<>();
    }

    public Answer(String text, String author, String likesCSV) {
        this.text = text;
        this.author = author;
        this.markedHelpful = parseHelpfulCSV(likesCSV);
    }

    public String getText() { return text; }
    public String getAuthor() { return author; }
    public ArrayList<String> getMarkedHelpful() { return markedHelpful; }
    
    public String getHelpfulAsString(int padding) {
        String retStr = "";
        for (int i = 0; i < markedHelpful.size(); i++) {
            if (i == 0) {
                retStr += markedHelpful.get(i);
            } else {
                retStr += ", " + markedHelpful.get(i);
            }
        }
        return retStr;
    }

    private ArrayList<String> parseHelpfulCSV(String csv) {
        ArrayList<String> result = new ArrayList<>();
        if (csv != null && !csv.isEmpty()) {
            String[] users = csv.split(",");
            for (String user : users) {
                result.add(user.trim());
            }
        }
        return result;
    }
}