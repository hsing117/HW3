package core;

import java.util.ArrayList;

/**
 * <p>Title: HW3 - Automated Question Validation Testing</p>
 * 
 * <p>Description: This standalone Java class implements five automated tests for the
 * Question class based on CSE 360 Team Project 2. Each test validates whether a
 * given Question object is valid or not based on length, duplication, and content rules.</p>
 * 
 * @author Harsh Singh
 * @version 1.0
 */
public class HW3 {

    static int numPassed = 0;
    static int numFailed = 0;
    static Questions questionList = new Questions();

    public static void main(String[] args) {

        ArrayList<String> generalTag = new ArrayList<>();
        generalTag.add("General");

        // Test 1: Empty Question Text
        Question testQ1 = new Question("", "", "testUser", new ArrayList<String>());
        performTestCase(1, testQ1, false);

        // Test 2: Question Text Too Long
        Question testQ2 = new Question(generateString(256), "", "testUser", new ArrayList<String>());
        performTestCase(2, testQ2, false);

        // Test 3: Question Body Too Long
        Question testQ3 = new Question("Valid Title", generateString(2001), "testUser", new ArrayList<String>());
        performTestCase(3, testQ3, false);

        // Test 4: Duplicate Question
        Question testQ4pt1 = new Question("duplicate", "", "testUser", new ArrayList<String>());
        questionList.add(testQ4pt1);
        Question testQ4pt2 = new Question("duplicate", "Some different body", "anotherUser", new ArrayList<String>());
        performTestCase(4, testQ4pt2, false);

        // Test 5: Valid Question
        Question testQ5 = new Question(
            "Week 05 Live Event",
            "Will the Week 05 Live Event get uploaded to canvas?",
            "Anonymous",
            generalTag);
        performTestCase(5, testQ5, true);

        System.out.println("\nAll tests complete.");
        System.out.println("Passed: " + numPassed);
        System.out.println("Failed: " + numFailed);
    }

    /**
     * Performs a single automated test for a Question object.
     * 
     * @param testNum the test case number
     * @param q the Question object being tested
     * @param expectedResult whether the question is expected to be valid or not
     */
    public static void performTestCase(int testNum, Question q, boolean expectedResult) {
        boolean actual = questionList.validateNewQuestion(q);
        System.out.print("Test " + testNum + ": ");
        if (actual == expectedResult) {
            System.out.println("Passed ✅");
            numPassed++;
        } else {
            System.out.println("Failed ❌");
            numFailed++;
        }
    }

    /**
     * Utility function to generate a string of a specific length.
     * 
     * @param length the desired length of the string
     * @return a string composed of repeated 'x' characters
     */
    public static String generateString(int length) {
        return "x".repeat(Math.max(0, length));
    }
}
