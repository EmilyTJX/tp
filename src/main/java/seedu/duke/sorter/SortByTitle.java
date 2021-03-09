package seedu.duke.sorter;

import java.util.Comparator;

import seedu.duke.review.Review;

public class SortByTitle implements Comparator<Review> {
    public int compare(Review a, Review b) {
        return a.title.compareTo(b.title);
    }
}