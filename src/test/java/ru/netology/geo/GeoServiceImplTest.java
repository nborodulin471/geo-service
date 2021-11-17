package ru.netology.geo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    public static Collection<Object[]> data() {

        Location location_moscow = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Location location_newYork = new Location("New York", Country.USA, " 10th Avenue", 32);
        Location location_rus = new Location("Moscow", Country.RUSSIA, null, 0);
        Location location_usa = new Location("Moscow", Country.RUSSIA, null, 0);

        return Arrays.asList(new Object[][]{
                {"172.0.32.11", location_moscow},
                {"96.44.183.149", location_newYork},
                {"172.123.12.19", location_rus},
                {"96.124.11.01", location_usa}});
    }

    @ParameterizedTest
    @MethodSource("data")
    void byIpTest(String address, Location location) {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location res = geoService.byIp(address);

        assertEquals(res, location);
    }

    @Test
    void byCoordinates() {
        Exception exception = assertThrows(RuntimeException.class, () ->
                new GeoServiceImpl().byCoordinates(0,0));

        String expectedMessage = "Not implemented";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}