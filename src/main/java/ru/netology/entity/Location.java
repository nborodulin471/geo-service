package ru.netology.entity;

public class Location {

    private final String city;

    private final Country country;

    private final String street;

    private final int builing;

    public Location(String city, Country country, String street, int builing) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.builing = builing;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    public int getBuiling() {
        return builing;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == null){
            return false;
        }

        if (obj.getClass() != Location.class) {
            return false;
        }
        Location location = (Location) obj;
        if (location.getCity().equals(this.city) || location.getCity() == this.city &&
                (location.getCountry() == this.country || location.getCountry() == this.country &&
                        ((location.getStreet().equals(this.street) || location.getStreet() == this.street &&
                                ((location.getBuiling() == this.builing) || location.getBuiling() == this.builing))))) {
            return true;
        }
        return false;
    }
}
