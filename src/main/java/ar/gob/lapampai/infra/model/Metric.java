package ar.gob.lapampa.infra.model;

public class Metric {
    private String name;
    private double value;
    private String unit;
    private long timestamp;
    private String status;

    public Metric() {}

    public Metric(String name, double value, String unit, long timestamp, String status) {
        this.name = name;
        this.value = value;
        this.unit = unit;
        this.timestamp = timestamp;
        this.status = status;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
