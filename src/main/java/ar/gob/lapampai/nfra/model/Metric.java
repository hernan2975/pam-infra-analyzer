public class Metric {
    private String name;         // "cpu.load", "disk.root.used", "ping.latency"
    private double value;
    private String unit;         // "%", "ms", "GB"
    private long timestamp;
    private String status;       // "OK", "WARNING", "CRITICAL"
}
