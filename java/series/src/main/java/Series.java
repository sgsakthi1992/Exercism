import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Series {
    private String series;

    private final Consumer<String> exception = s -> {
        throw new IllegalArgumentException(s);
    };

    public Series(String series) {
        this.series = series;
    }

    public List<String> slices(int slice) {
        if (slice <= 0)
            exception.accept("Slice size is too small.");

        if (series.length() < slice)
            exception.accept("Slice size is too big.");

        return IntStream.rangeClosed(0, series.length() - slice)
                .mapToObj(i -> series.substring(i, i + slice))
                .collect(Collectors.toList());
    }
}