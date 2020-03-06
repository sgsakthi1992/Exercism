public class BeerSong {
    private String ON_WALL = "%d bottles of beer on the wall, %d bottles of beer.";
    private final String ON_WALL_ONE = "1 bottle of beer on the wall, 1 bottle of beer." +
            "\nTake it down and pass it around, no more bottles of beer on the wall.\n\n";
    private final String PASS = "Take one down and pass it around, %d %s of beer on the wall.";
    private final String PASS_END = "No more bottles of beer on the wall, no more bottles of beer." +
            "\nGo to the store and buy some more, 99 bottles of beer on the wall.\n\n";
    private final int FULL_BOTTLE = 99;
    private final int FULL_SONG_COUNT = 100;
    private StringBuilder result = new StringBuilder();

    public String sing(int bottles, int count) {
        if (count != 0) {
            if (bottles > 1) {
                result.append(String.format(ON_WALL, bottles, bottles));
                result.append("\n");
                --bottles;
                result.append(String.format(PASS, bottles, bottles > 1 ? "bottles" : "bottle"));
                result.append("\n\n");
                return sing(bottles, --count);
            } else if (bottles == 1) {
                result.append(ON_WALL_ONE);
                return sing(--bottles, --count);
            } else {
                result.append(PASS_END);
            }
        }
        System.out.println("result = " + result);
        return result.toString();
    }

    public String singSong() {
        return sing(FULL_BOTTLE, FULL_SONG_COUNT);
    }
}