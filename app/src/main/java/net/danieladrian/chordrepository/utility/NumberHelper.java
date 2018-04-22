package net.danieladrian.chordrepository.utility;

import java.text.DecimalFormat;

/**
 * Created by Daniel Adrian on 29/01/2018.
 */

public class NumberHelper {
    public final static String convertPrice(Integer price) {
        DecimalFormat formatter = new DecimalFormat("#,###,###,###,###");
        return formatter.format(price);
    }

    public final static String convertPrice(float price) {
        DecimalFormat formatter = new DecimalFormat("#,###,###,###,###");
        return formatter.format(price);
    }
}
