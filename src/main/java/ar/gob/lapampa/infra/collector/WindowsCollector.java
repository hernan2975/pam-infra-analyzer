package ar.gob.lapampa.infra.collector;

import ar.gob.lapampa.infra.model.Host;
import ar.gob.lapampa.infra.model.Metric;

import java.util.Collections;

public class WindowsCollector {
    public Host collect(String hostname, String location) {
        // Placeholder — implementar con WMI o PowerShell
        Host host = new Host();
        host.setHostname(hostname);
        host.setIp("127.0.0.1");
        host.setOs("Windows");
        host.setLocation(location);
        host.setMetrics(Collections.emptyList());
        return host;
    }
}
