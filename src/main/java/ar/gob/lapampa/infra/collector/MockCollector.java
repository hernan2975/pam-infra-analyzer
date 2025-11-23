package ar.gob.lapampa.infra.collector;

import ar.gob.lapampa.infra.model.Host;
import ar.gob.lapampa.infra.model.Metric;

import java.util.Arrays;
import java.util.List;

public class MockCollector {
    public Host collect(String hostname, String location) {
        Host host = new Host();
        host.setHostname(hostname);
        host.setIp("10.0.1." + (10 + Math.abs(hostname.hashCode()) % 245));
        host.setOs(hostname.contains("srv") ? "Linux/Ubuntu 22.04" : "Windows Server 2022");
        host.setLocation(location);

        List<Metric> metrics = Arrays.asList(
            new Metric("cpu.load", 15.3, "%", System.currentTimeMillis(), "OK"),
            new Metric("disk.root.used", 72.1, "%", System.currentTimeMillis(), "WARNING"),
            new Metric("ping.latency", 8.4, "ms", System.currentTimeMillis(), "OK")
        );
        host.setMetrics(metrics);

        return host;
    }
}
