package com.arm.satornjanac.esspressotestsexamples;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A placeholder fragment containing a simple view.
 */
public class FormActivityFragment extends Fragment {

    private Button mSubmitButton;
    private Button mCancelButton;
    private Spinner mOldTeamSpinner;
    private Spinner mNewTeamSpinner;
    private Spinner mTechnologySpinner;
    private Spinner mLevelSpinner;
    private EditText mName;
    private EditText mSurname;
    private RadioButton mMale;
    private RadioButton mFemale;

    public static final String TAG = FormActivityFragment.class.getName();

    public FormActivityFragment() {
    }

    public static FormActivityFragment newInstance(){
        FormActivityFragment f = new FormActivityFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_form, container, false);
        init(contentView);
        return contentView;
    }

    private void init(View contentView){
        mSubmitButton = (Button)contentView.findViewById(R.id.submit);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Form is submitted", Toast.LENGTH_LONG).show();
                ChangeTeamRequest.requests.add(new ChangeTeamRequest(mName.getText().toString(),
                        mSurname.getText().toString(), mOldTeamSpinner.getSelectedItem().toString()
                        ,mNewTeamSpinner.getSelectedItem().toString(),
                        mTechnologySpinner.getSelectedItem().toString(),
                        mLevelSpinner.getSelectedItem().toString(),
                        mMale.isChecked(), mFemale.isChecked()));
                clearForm();
            }
        });

        mCancelButton = (Button)contentView.findViewById(R.id.cancel);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Form is cleared", Toast.LENGTH_LONG).show();
                clearForm();
            }
        });

        mOldTeamSpinner = (Spinner)contentView.findViewById(R.id.current_team);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.team_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mOldTeamSpinner.setAdapter(adapter);

        mNewTeamSpinner = (Spinner)contentView.findViewById(R.id.new_team);
        mNewTeamSpinner.setAdapter(adapter);

        mTechnologySpinner = (Spinner)contentView.findViewById(R.id.technology);
        adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.technology_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mTechnologySpinner.setAdapter(adapter);

        mLevelSpinner = (Spinner)contentView.findViewById(R.id.level);
        adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.level_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mLevelSpinner.setAdapter(adapter);

        mName = (EditText)contentView.findViewById(R.id.name);
        mSurname = (EditText)contentView.findViewById(R.id.surname);
        mMale = (RadioButton)contentView.findViewById(R.id.male);
        mFemale = (RadioButton)contentView.findViewById(R.id.female);
    }

    private void clearForm(){
        mName.getText().clear();
        mSurname.getText().clear();
        mMale.setChecked(false);
        mFemale.setChecked(false);
        mOldTeamSpinner.setSelection(0);
        mNewTeamSpinner.setSelection(0);
        mTechnologySpinner.setSelection(0);
        mLevelSpinner.setSelection(0);
    }

}
