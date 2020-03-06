import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Meetup {

    private final LocalDate date;

    public Meetup(int month, int year) {
        this.date = LocalDate.of(year, month, 12);
    }

    public LocalDate day(DayOfWeek dayOfWeek, MeetupSchedule meetupSchedule) {
        switch (meetupSchedule) {
            case TEENTH:
                return date.with(TemporalAdjusters.next(dayOfWeek));
            case LAST:
                return date.with(TemporalAdjusters.lastInMonth(dayOfWeek));
            default:
                return date.with(TemporalAdjusters.dayOfWeekInMonth(meetupSchedule.ordinal() + 1, dayOfWeek));
        }
    }
}