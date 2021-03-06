package com.djunicode.queuingapp.rest;

import com.djunicode.queuingapp.model.LocationTeacher;


import com.djunicode.queuingapp.model.TeacherCreateNew;
import com.djunicode.queuingapp.model.TeacherListModel;
import com.djunicode.queuingapp.model.TeacherModel;


import retrofit2.http.Body;

import com.djunicode.queuingapp.model.Student;
import com.djunicode.queuingapp.model.StudentForId;
import com.djunicode.queuingapp.model.StudentQueue;
import com.djunicode.queuingapp.model.StudentSubscriptions;
import com.djunicode.queuingapp.model.TeachersList;
import com.djunicode.queuingapp.model.UserEmailVerify;
import com.djunicode.queuingapp.model.UserModel;

import java.util.List;
import retrofit2.Call;

import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by DELL_PC on 09-01-2018.
 */

public interface ApiInterface {

  @FormUrlEncoded
  @POST("queues/student/")
  Call<Student> createStudentAccount (@Field("user") int user_id, @Field("name") String username,
      @Field("sapID") String sapId, @Field("department") String department,
      @Field("year") String year, @Field("batch") String batch);

  @FormUrlEncoded
  @PUT("queues/users/{id}/")
  Call<UserModel> updateUserData (@Path("id") int id, @Field("username") String username,
                                  @Field("password") String password);

  @FormUrlEncoded
  @POST("queues/teacher/")
  Call<TeacherModel> createTeacherAccount (@Field("name") String username, @Field
          ("user") int user_id, @Field("location") int location, @Field
          ("subject") String subject, @Field
          ("sapId") String sapId);

  @FormUrlEncoded
  @POST("queues/users/")
  Call<StudentForId> getId (@Field("username") String username, @Field("password") String password);

  @DELETE("queues/{id}/")
  Call<LocationTeacher> deleteTeacherLocation (@Path("id") int id);

  @FormUrlEncoded
  @PUT("queues/queue/{id}/add/")
  Call<StudentQueue> studentJoiningTheQueue (@Path("id") int id, @Field("queueItems") String sapID);

  @FormUrlEncoded
  @PUT("queues/teacher/{id}/" )
  Call<TeacherModel> updateTeachersLocation (@Path("id") int id, @Field("location") int location
          ,@Field("user") int user);

  @GET("queues/teacher/{name}/")
  Call<TeacherModel> getTeacherId (@Path("name") String name);

  @FormUrlEncoded
  @PUT("queues/subject/")
  Call<TeacherListModel> getTeachers(@Field("name") String name);

  @FormUrlEncoded
  @POST("queues/")
  Call<LocationTeacher> sendTeacherLocation(@Field("floor") Integer floor,
      @Field("department") String department, @Field("room") String room);

  @FormUrlEncoded
  @POST("queues/")
  Call<LocationTeacher> sendQueueLocation(@Field("floor") Integer floor, @Field
          ("department") String department, @Field("room") String room);

  @GET("queues/{id}/")
  Call<LocationTeacher> getTeacherLocation(@Path("id") int id);

  @GET("queues/teacher/name/{name}/")
  Call<TeacherModel> getIdForTeacherFromName(@Path("name") String name);

  @GET("queues/teacher/name/")
  Call<TeacherModel> getLocationIntegerForTeacherFromName(@Field("name") String name);

  @FormUrlEncoded
  @POST("queues/users/")
  Call<UserEmailVerify> sendEmail(@Field("username") String name, @Field("email") String email,
      @Field("password") String password);

  @FormUrlEncoded
  @PUT("queues/users/{id}/token/")
  Call<UserEmailVerify> verifyEmail(@Path("id") int id, @Field("token") String token);


  @GET("queues/queue/{id}/")
  Call<StudentQueue> getUpdatedQueue(@Path("id") int id);

  @FormUrlEncoded
  @PUT("queues/student/{id}/")
  Call<StudentSubscriptions> setStudentSubscriptions(@Path("id") int id,
                                                     @Field("teacherNames") String subscriptions);

  @FormUrlEncoded
  @PUT("queues/queue/{id}/index/")
  Call<StudentQueue> getUpdatedStudentLocation(@Path("id") int id, @Field("sapID") String sapID);

  @FormUrlEncoded
  @PUT("queues/queue/{id}/deletespecific/")
  Call<StudentQueue> deleteStudentFromQueue(@Path("id") Integer id, @Field("element") String sapID);

  @FormUrlEncoded
  @POST("queues/queue/{id}/notification/")
  Call<TeacherCreateNew> startTheQueue(@Path("id") Integer id,
                                       @Field("teacherName") String teacherName);

  @DELETE("queues/queue/{id}/")
  Call<TeacherCreateNew> deleteQueue(@Path("id") Integer id);

  @FormUrlEncoded
  @PUT("queues/subject/")
  Call<TeachersList> getTeachersList(@Field("name") String name);

  @FormUrlEncoded
  @POST("queues/queue/")
  Call<TeacherCreateNew> sendSubmissionData(@Field("subject") String subject,
                                            @Field("startTime") String startTime, @Field("endTime") String endTime,
                                            @Field("maxLength") Integer noOfStudents, @Field("queueItems") String queueItems);
  @FormUrlEncoded
  @PUT("queues/teacher/{id}/subject/")
  Call<TeacherModel> addTeacherSubjects(@Path("id") int id, @Field("subject") String subject);

  @FormUrlEncoded
  @PUT("queues/queue/{id}/")
  Call<StudentQueue> editingQueue (@Path("id") int id, @Field("maxLength") int maxLength,
                                   @Field("startTime") String startTime, @Field("endTime") String endTime,
                                   @Field("subject") String subject, @Field("avgTime") String avgTime, @Field("size") int size);

  @FormUrlEncoded
  @PUT("queues/queue/{id}/")
  Call<StudentQueue> editQueueLocation(@Path("id") int id, @Field("maxLength") int maxLength,
                                       @Field("startTime") String startTime, @Field("endTime")
                                               String endTime, @Field("subject") String subject,
                                       @Field("avgTime") String avgTime, @Field("size") int size,
                                       @Field("location") int location);
}
