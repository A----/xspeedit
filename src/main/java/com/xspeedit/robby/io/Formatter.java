package com.xspeedit.robby.io;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.Collection;
import java.util.Iterator;
import java.lang.StringBuilder;

/**
 * Convertit une collection de collections d'entier en chaîne.
 */
public class Formatter
{
    private final String SEPARATOR = "/";

    public String format(Iterable<Iterable<Integer>> collection) {
        StringBuilder builder = new StringBuilder();

        Iterator<Integer> subIterator = null;
        Iterator<Iterable<Integer>> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (subIterator != null) {
                builder.append(SEPARATOR);
            }

            subIterator = iterator.next().iterator();
            while (subIterator.hasNext()) {
                builder.append(subIterator.next());
            }
        }
        return builder.toString();
    }
}
