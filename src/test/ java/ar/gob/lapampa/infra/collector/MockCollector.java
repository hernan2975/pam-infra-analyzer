public class MockCollector {
    public Host collect(String hostname, String location) {
        Host host = new Host();
        host.setHostname(hostname);
        host.setIp("10.0.1." + (10 + Math.abs(hostname.hashCode()) % 245));
        host.setOs(hostname.contains("srv") ? "Linux/Ubuntu 22.04" : "Windows Server 2022");
        host.setLocation(location);

        List<Metric> metrics = new ArrayList<>();
        metrics.add(new Metric("cpu.load", 15.3, "%", System.currentTimeMillis(), "OK"));
        metrics.add(new Metric("disk.root.used", 72.1, "%", System.currentTimeMillis(), "WARNING"));
        metrics.add(new Metric("ping.latency", 8.4, "ms", System.currentTimeMillis(), "OK"));
        host.setMetrics(metrics);

        return host;
    }
}
