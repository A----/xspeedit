package com.xspeedit.robby.io;

import java.util.Collection;
import java.util.Iterator;
import java.lang.StringBuilder;

/**
 * Convertit une collection de collections d'entier en chaîne.
 */
public class Formatter
{
    private final String SEPARATOR = "/";

    public String format(Collection<Collection<Integer>> collection) {
        StringBuilder builder = new StringBuilder();

        Collection<Integer> subCollection = null;
        Iterator<Collection<Integer>> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (subCollection != null) {
                builder.append(SEPARATOR);
            }

            subCollection = iterator.next();
            for (Integer i : subCollection) {
                builder.append(i);
            }
        }
        return builder.toString();
    }
}
