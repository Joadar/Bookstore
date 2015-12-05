package com.exemple.bookstore.Bus;

import com.squareup.otto.Bus;

/**
 * Created by Jonathan on 20/10/2015.
 */
public final class BusProvider {
    private static final Bus BUS = new Bus();

    public static Bus getInstance() {
        return BUS;
    }

    private BusProvider() {
        // No instances.
    }
}