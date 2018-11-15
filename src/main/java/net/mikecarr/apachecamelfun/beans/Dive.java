package net.mikecarr.apachecamelfun.beans;

import java.util.Date;

public class Dive {
    private Long id;
    private String location;
    private int depth;
    private Date startTime;
    private Date endTime;

    public Dive() {
        super();
    }

    public Dive(Long id, String location) {
        super();
        this.id = id;
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format("Dive [id=%s, location=%s]", id, location);
    }
}
