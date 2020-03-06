import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private static final Long GIGASECOND = 1000000000L;
    private LocalDateTime moment;
    Gigasecond(LocalDate moment) {
        this.moment = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return moment.plusSeconds(GIGASECOND);
    }

}
