package com.djunicode.queuingapp.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.djunicode.queuingapp.R;
import com.djunicode.queuingapp.activity.StudentScreenActivity;
import com.djunicode.queuingapp.customClasses.QueueDialogClass;
import com.djunicode.queuingapp.model.TeachersList;
import com.djunicode.queuingapp.rest.ApiClient;
import com.djunicode.queuingapp.rest.ApiInterface;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubmissionFragment extends Fragment {

  private Spinner subjectSpinner, teacherNameSpinner;
  private FloatingActionButton fab;
  private List<String> teachers;
  private ArrayAdapter<String> teacherAdapter;
  private ApiInterface apiInterface;

  public SubmissionFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_submission, container, false);

    String[] array = {"Select", "AOA", "COA", "DS"};
    subjectSpinner = (Spinner) view.findViewById(R.id.subjectSpinner);
    teacherNameSpinner = (Spinner) view.findViewById(R.id.teacherNameSpinner);
    fab = (FloatingActionButton) view.findViewById(R.id.submissionFab);
    apiInterface = ApiClient.getClient().create(ApiInterface.class);

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
            android.R.layout.simple_spinner_dropdown_item, array);

    subjectSpinner.setAdapter(adapter);
    teacherNameSpinner.setAdapter(adapter);

    teacherNameSpinner.setEnabled(false);
    teacherNameSpinner.setAlpha(0.4f);

    fab.setEnabled(false);

    subjectSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position != 0) {
          teacherNameSpinner.setEnabled(true);
          teacherNameSpinner.setAlpha(1.0f);

          teachers = new ArrayList<>();
          Call<TeachersList> call = apiInterface
                  .getTeachersList(subjectSpinner.getItemAtPosition(position).toString());
          call.enqueue(new Callback<TeachersList>() {
            @Override
            public void onResponse(Call<TeachersList> call, Response<TeachersList> response) {
              Log.e("queues/subject/", response.body().getTeachers().toString());
              teachers = response.body().getTeachers();
              teacherAdapter = new ArrayAdapter<String>(getContext(),
                      android.R.layout.simple_spinner_dropdown_item, teachers);
              teacherNameSpinner.setAdapter(teacherAdapter);
            }

            @Override
            public void onFailure(Call<TeachersList> call, Throwable t) {

            }
          });
        }
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });

    teacherNameSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position != 0) {
          fab.setEnabled(true);
        }
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });

    fab.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        QueueDialogClass queueDialog = new QueueDialogClass(getActivity());
        queueDialog.show();
      }
    });
    return view;
  }

}
