package ru.netology.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    void testEquals_null() {
        Location location = new Location(null, null, null, 0);
        assertFalse(location.equals(null));
    }
}