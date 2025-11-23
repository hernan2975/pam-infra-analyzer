package ar.gob.lapampa.infra.model;

import java.util.ArrayList;
import java.util.List;

public class Report {
    private List<Host> hosts = new ArrayList<>();

    public List<Host> getHosts() { return hosts; }
    public void setHosts(List<Host> hosts) { this.hosts = hosts; }
}
