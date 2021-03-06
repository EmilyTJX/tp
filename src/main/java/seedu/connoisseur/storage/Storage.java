package seedu.connoisseur.storage;

import seedu.connoisseur.review.Review;
import seedu.connoisseur.ui.Ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Loads reviews from connoisseur.txt or
 * creates and saves new reviews to connoisseur's.txt
 */

public class Storage {
    private static String path;

    public Storage() {
        path = System.getProperty("user.dir") + "/data/connoisseur.txt";
    }

    /**
     * Creates data folder if it does not exist.
     */
    public static void createFolder() {
        Ui.printPresentDirectory();
        String folderPath = System.getProperty("user.dir") + "/data";
        File folder = new File(folderPath);
        boolean isSuccessful = folder.mkdir();
        if (isSuccessful) {
            Ui.printSuccessfulCreateFolderMessage();

        } else {
            Ui.printFolderExistsMessage();
        }
    }

    /**
     * Checks if textfile exists, else create new file.
     *
     * @return True if file exists or text file is created.
     */
    public boolean retrieveTextFile() {
        boolean hasTextFile = false;
        try {
            File data = new File(path);
            if (data.createNewFile()) {
                System.out.println("Text file created: " + data.getName());
            } else {
                hasTextFile = true;
                Ui.printFileExistsMessage();
            }
        } catch (IOException e) { //creating or retrieving data has errors
            Ui.printErrorMessage(e);
        }
        return hasTextFile;
    }

    /**
     * Loads information from data.txt into connoisseur's list without change.
     *
     * @return Loaded review into connoisseur's list unformatted.
     */
    public ArrayList<String> loadData() {
        ArrayList<String> reviewList = new ArrayList<>();
        try {
            File data = new File(path);
            Scanner sc = new Scanner(data);
            String reviewsToLoad;
            while (sc.hasNextLine()) {
                reviewsToLoad = sc.nextLine();
                reviewList.add(reviewsToLoad);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            Ui.printErrorMessage(e);
        }
        return reviewList;
    }

    /**
     * Updates and saves new reviews to connoisseur.txt.
     *
     * @param reviewList Reviews list to be updated.
     */
    public static void saveData(ArrayList<Review> reviewList) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            for (Review review : reviewList) {
                String reviewToWrite = review.reviewToText() + "\n";
                fileWriter.write(reviewToWrite);
            }
            fileWriter.close();
        } catch (IOException e) {
            Ui.printErrorMessage(e);
        }
    }


}