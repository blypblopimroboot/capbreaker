package com.models;

import javax.persistence.*;
import java.security.SecureRandom;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bssid;
    private String essid;
    private TaskStatus status;
    private Integer progress;
    private String wifiPassword;
    private String taskPassword;
    private Handshake handshake;

    public Task() {
        status = TaskStatus.Queued;
        taskPassword = randomPassword();
        wifiPassword = "";
        progress = 0;
    }

    public Task(Task t) {
        id = t.id;
        bssid = t.bssid;
        essid = t.essid;
        status = t.status;
        wifiPassword = t.wifiPassword;
        taskPassword = t.taskPassword;
        handshake = t.handshake;
        progress = t.progress;
    }

    public Task(Handshake hs) {
        bssid = hs.getBssid();
        essid = hs.getEssid();
        status = TaskStatus.Queued;
        handshake = hs;
        wifiPassword = "";
        taskPassword = randomPassword();
        progress = 0;
    }

    private String randomPassword() {
        return String.valueOf(new SecureRandom().nextInt(89999) + 10000);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBssid() {
        return bssid;
    }

    public void setBssid(String bssid) {
        this.bssid = bssid;
    }

    public String getEssid() {
        return essid;
    }

    public void setEssid(String essid) {
        this.essid = essid;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getWifiPassword() {
        return wifiPassword;
    }

    public void setWifiPassword(String wifiPassword) {
        this.wifiPassword = wifiPassword;
    }

    public String getTaskPassword() {
        return taskPassword;
    }

    public void setTaskPassword(String taskPassword) {
        this.taskPassword = taskPassword;
    }

    public Handshake getHandshake() {
        return handshake;
    }

    public void setHandshake(Handshake handshake) {
        this.handshake = handshake;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Task) {
            Task task = (Task) obj;
            return task.id.equals(id) && task.essid.equals(essid) && task.bssid.equals(bssid);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", bssid=" + bssid + ", essid=" + essid + ", status=" + status + ", wifiPassword="
                + wifiPassword + ", taskPassword=" + taskPassword + ", handshake=" + handshake + "]";
    }
}
