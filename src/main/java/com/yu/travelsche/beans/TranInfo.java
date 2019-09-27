package com.yu.travelsche.beans;

import java.util.List;

public class TranInfo {

    private String tranid;
    private String from;
    private String to;
    private String depart;
    private String arri;
    private String deptime;
    private String arritime;
    private String timecost;
    private String date;
    private String noseat;
    private String secondseat;
    private String firstseat;
    private String bussiseat;

    public boolean isG() {
        return this.tranid.contains("G");
    }

    public boolean isD() {
        return this.tranid.contains("D");
    }




    public void setTranid(String tranid) {
        this.tranid = tranid;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public void setArri(String arri) {
        this.arri = arri;
    }

    public void setDeptime(String deptime) {
        this.deptime = deptime;
    }

    public void setArritime(String arritime) {
        this.arritime = arritime;
    }

    public void setTimecost(String timecost) {
        this.timecost = timecost;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNoseat(String noseat) {
        this.noseat = noseat;
    }

    public void setSecondseat(String secondseat) {
        this.secondseat = secondseat;
    }

    public void setFirstseat(String firstseat) {
        this.firstseat = firstseat;
    }

    public void setBussiseat(String bussiseat) {
        this.bussiseat = bussiseat;
    }

    public String getTranid() {
        return tranid;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getDepart() {
        return depart;
    }

    public String getArri() {
        return arri;
    }

    public String getDeptime() {
        return deptime;
    }

    public String getArritime() {
        return arritime;
    }

    public String getTimecost() {
        return timecost;
    }

    public String getDate() {
        return date;
    }

    public String getNoseat() {
        return noseat;
    }

    public String getSecondseat() {
        return secondseat;
    }

    public String getFirstseat() {
        return firstseat;
    }

    public String getBussiseat() {
        return bussiseat;
    }



}
