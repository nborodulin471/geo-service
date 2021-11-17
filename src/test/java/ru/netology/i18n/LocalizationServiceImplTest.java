package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Добро пожаловать", Country.RUSSIA},
                {"Welcome", Country.USA}});
    }

    @ParameterizedTest
    @MethodSource("data")
    void locale(String expected, Country country) {
        LocalizationServiceImpl service = new LocalizationServiceImpl();
        String res = service.locale(country);
        assertEquals(expected, res);
    }
}