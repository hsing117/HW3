package core;

import java.util.ArrayList;

public class Answers extends ArrayList<Answer> {
    public void sortAnswers() {
        // Sort answers by number of helpful marks
        this.sort((a1, a2) -> 
            Integer.compare(a2.getMarkedHelpful().size(), a1.getMarkedHelpful().size()));
    }
}