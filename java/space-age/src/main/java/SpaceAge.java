class SpaceAge {

    private static final double EARTH_PERIOD = 31557600;
    private static final double MERCURY = 0.2408467;
    private static final double VENUS = 0.61519726;
    private static final double MARS = 1.8808158;
    private static final double JUPITER = 11.862615;
    private static final double SATURN = 29.447498;
    private static final double URANUS = 84.016846;
    private static final double NEPTUNE = 164.79132;
    private double seconds;

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double getSeconds() {
        return seconds;
    }

    double onEarth() {
        return getSeconds() / EARTH_PERIOD;
    }

    double onMercury() {
        return onEarth() / MERCURY;
    }

    double onVenus() {
        return onEarth() / VENUS;
    }

    double onMars() {
        return onEarth() / MARS;
    }

    double onJupiter() {
        return onEarth() / JUPITER;
    }

    double onSaturn() {
        return onEarth() / SATURN;
    }

    double onUranus() {
        return onEarth() / URANUS;
    }

    double onNeptune() {
        return onEarth() / NEPTUNE;
    }

}
