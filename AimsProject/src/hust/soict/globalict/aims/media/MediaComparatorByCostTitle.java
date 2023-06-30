package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

    @Override
    public int compare(Media m1, Media m2) {
        int result = Float.compare(m1.getCost(), m2.getCost());
        if (result != 0) {
            return result;
        }
        return m1.getTitle().compareTo(m2.getTitle());
    }
}
