package com.djunicode.queuingapp.model;

/**
 * Created by DELL_PC on 09-01-2018.
 */

import com.google.gson.annotations.SerializedName;
import java.util.List;


public class Student {

  @SerializedName("user")
  public int user;
  @SerializedName("name")
  public String name;
  @SerializedName("department")
  public String department;
  @SerializedName("year")
  public String year;
  @SerializedName("batch")
  public String batch;
  @SerializedName("sapID")
  public String sapID;
  @SerializedName("teacherNames")
  private List<String> teacherNames;
  @SerializedName("subscription")
  private List<String> subscription;
//  @SerializedName("password")
//  public String password;

  public Student(int user, String name, String department, String year, String batch,

      String sapID, String password, List<String> teacherNames, List<String> subscription)   {
    this.user = user;
    this.name = name;
    this.department = department;
    this.year = year;
    this.batch = batch;
    this.sapID = sapID;
//    this.password = password;
    this.teacherNames = teacherNames;
    this.subscription = subscription;
  }

  public List<String> getTeacherNames() {
    return teacherNames;
  }

  public List<String> getSubscription() {
    return subscription;
  }
}

