package ar.gob.lapampa.infra.model;

import java.util.ArrayList;
import java.util.List;

public class Host {
    private String hostname;
    private String ip;
    private String os;
    private String location;
    private List<Metric> metrics;

    public Host() {
        this.metrics = new ArrayList<>();
    }

    public String getHostname() { return hostname; }
    public void setHostname(String hostname) { this.hostname = hostname; }

    public String getIp() { return ip; }
    public void setIp(String ip) { this.ip = ip; }

    public String getOs() { return os; }
    public void setOs(String os) { this.os = os; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public List<Metric> getMetrics() { return metrics; }
    public void setMetrics(List<Metric> metrics) { this.metrics = metrics; }
}
