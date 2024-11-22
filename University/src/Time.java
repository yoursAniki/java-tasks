public class Time {
    private int seconds;

    public Time(int seconds) {
        if(seconds<0) {
            throw new Error("Секунд должно быть больше 0");
        }
        this.seconds = seconds % 86400;
    }

    public Time(int hours, int minutes, int seconds) {
        this.seconds = ((hours * 3600) + (minutes * 60) + seconds) % 86400;
    }

    public int getCurrentHour() {
        return seconds / 3600;
    }

    public int getMinutesPastHour() {
        return (seconds % 3600) / 60;
    }

    public int getSecondsPastMinute() {
        return seconds % 60;
    }

    public String toString() {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int remainingSeconds = seconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds);
    }
}
