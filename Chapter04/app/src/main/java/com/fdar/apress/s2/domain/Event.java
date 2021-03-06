/**
 * Copyright:	Copyright (c) From Down & Around, Inc.
 */

package com.fdar.apress.s2.domain;

import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.*;
import java.io.Serializable;

@Entity @Table( name="EVENT", schema="S2APP" )
public class Event  implements Serializable {

    private long id;
    private String name;
    private Date startTime;
    private int duration;
    private int timeZoneOffset;
    private Date votingStartTime;
    private Date lastUpdateTime;
    private Set<Voter> voters = new HashSet<Voter>();
    private Location location;
    private List<Contestant> options = new ArrayList<Contestant>();
    private Progress status;

    @Id @GeneratedValue(strategy=GenerationType.AUTO) @Column(name="ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="START_TIME") @Temporal(TemporalType.TIMESTAMP)
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Column(name="DURATION")
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Column(name="TZ_OFFSET")
    public int getTimeZoneOffset() {
        return timeZoneOffset;
    }

    public void setTimeZoneOffset(int timeZoneOffset) {
        this.timeZoneOffset = timeZoneOffset;
    }

    @Column(name="VOTING_STARTS") @Temporal(TemporalType.TIMESTAMP)
    public Date getVotingStartTime() {
        return votingStartTime;
    }

    public void setVotingStartTime(Date votingStartTime) {
        this.votingStartTime = votingStartTime;
    }

    @Column(name="LAST_UPDATE") @Temporal(TemporalType.TIMESTAMP)
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @OneToMany(mappedBy="event",cascade=CascadeType.ALL)
    public Set<Voter> getVoters() {
        return voters;
    }

    public void setVoters(Set<Voter> voters) {
        this.voters = voters;
    }

    public void addVoter( Voter v ) {
        v.setEvent(this);
        voters.add(v);
    }

    @ManyToOne(cascade=CascadeType.ALL) @JoinColumn(name="LOCATION_FK")
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @OneToMany(mappedBy="event",cascade=CascadeType.ALL)
    public List<Contestant> getOptions() {
        return options;
    }

    public void setOptions(List<Contestant> options) {
        this.options = options;
    }

    public void addOption( Contestant c ) {
        c.setEvent(this);
        options.add(c);
    }

    @Column(name="STATE") @Enumerated(EnumType.STRING)
    public Progress getStatus() {
        return status;
    }

    public void setStatus(Progress status) {
        this.status = status;
    }
}
