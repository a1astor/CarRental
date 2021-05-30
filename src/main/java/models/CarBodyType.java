package models;

public enum CarBodyType {
    SEDAN("SEDAN"),
    COUPE("COUPE"),
    SPORTS_CAR("SPORTS_CAR"),
    STATION_WAGON("STATION_WAGON"),
    HATCHBACK("HATCHBACK"),
    CONVERTIBLE("CONVERTIBLE"),
    SPORT_UTILITY_VEHICLE("SUV"),
    MINIVAN("MINIVAN"),
    PICKUP_TRUCK("PICKUP_TRUCK");

    private String name;

    CarBodyType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
