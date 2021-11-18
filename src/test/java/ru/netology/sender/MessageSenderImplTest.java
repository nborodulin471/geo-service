package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MessageSenderImplTest {

    public static Collection<Object[]> data() {
        Location location_rus = new Location("Moscow", Country.RUSSIA, null, 0);
        Location location_usa = new Location("Moscow", Country.RUSSIA, null, 0);

        return Arrays.asList(new Object[][]{
                {"Добро пожаловать", "172.123.12.19", location_rus},
                {"Welcome", "96.124.11.01", location_usa}});
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testLanguage(String value, String address, Location location) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("x-real-ip", address);

        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(address))
                .thenReturn(location);

        LocalizationServiceImpl localizationService = Mockito.spy(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(location.getCountry()))
                .thenReturn(value);

        MessageSenderImpl sender = new MessageSenderImpl(geoService, localizationService);
        assertThat(sender.send(map), is(value));
    }
}