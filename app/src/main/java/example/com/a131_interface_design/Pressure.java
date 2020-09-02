package example.com.a131_interface_design;

public class Pressure {
    int highPressure;
    int lowerPressure;
    int pulse;
    boolean tachicardia;
    String dateTime;

    public Pressure(int highPressure, int lowerPressure, int pulse, boolean tachicardia, String dateTime) {
        this.highPressure = highPressure;
        this.lowerPressure = lowerPressure;
        this.pulse = pulse;
        this.tachicardia = tachicardia;
        this.dateTime = dateTime;
    }
}
