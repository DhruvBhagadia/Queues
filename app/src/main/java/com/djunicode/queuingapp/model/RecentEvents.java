package com.djunicode.queuingapp.model;

/**
 * Created by Ruturaj on 20-01-2018.
 */

public class RecentEvents {

  private String subjectName;
  private String batchName;
  private String startTime;
  private String endTime;
  private Integer noOfStudents;
  private String location;
  private Integer serverId;

  public RecentEvents(String subjectName, String batchName, String startTime, String endTime,
                      Integer noOfStudents, String location, Integer serverId){
    this.subjectName = subjectName;
    this.batchName = batchName;
    this.startTime = startTime;
    this.endTime = endTime;
    this.noOfStudents = noOfStudents;
    this.location = location;
    this.serverId = serverId;
  }

  public void setSubjectName(String subjectName){
    this.subjectName = subjectName;
  }

  public String getSubjectName() {
    return subjectName;
  }

  public void setBatchName(String batchName) {
    this.batchName = batchName;
  }

  public String getBatchName() {
    return batchName;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setNoOfStudents(Integer noOfStudents) {
    this.noOfStudents = noOfStudents;
  }

  public Integer getNoOfStudents() {
    return noOfStudents;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getLocation() {
    return location;
  }

  public void setServerId(Integer serverId) {
    this.serverId = serverId;
  }

  public Integer getServerId() {
    return serverId;
  }
}