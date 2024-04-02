package com.example.student;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class AddUserActivity extends AppCompatActivity {
    private EditText editFirstName, editLastName, editEmail;
    private RadioGroup radioDegreeProgram;
    private CheckBox bcCheckBox, msCheckBox, lciCheckBox, phdCheckBox;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editEmail = findViewById(R.id.editEmail);
        radioDegreeProgram = findViewById(R.id.radioDegreeProgram);
        bcCheckBox = findViewById(R.id.bcCheckBox);
        msCheckBox = findViewById(R.id.msCheckBox);
        lciCheckBox = findViewById(R.id.lciCheckBox);
        phdCheckBox = findViewById(R.id.phdCheckBox);
        context = AddUserActivity.this;

        Button addUserButton = findViewById(R.id.addUserButton);
        addUserButton.setOnClickListener(v -> addUser());
    }

    private void addUser() {
        String firstName = editFirstName.getText().toString().trim();
        String lastName = editLastName.getText().toString().trim();
        String email = editEmail.getText().toString().trim();
        String degreeProgram = getSelectedDegreeProgram();
        List<String> degrees = getSelectedDegrees();

        if (!firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !degreeProgram.isEmpty()) {
            User user = new User(firstName, lastName, email, degreeProgram);
            user.getDegreeList().addAll(degrees);
            UserStorage.getInstance().addUser(user);
            UserStorage.getInstance().saveData(context);
            Toast.makeText(this, "User added successfully", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        }
    }

    private List<String> getSelectedDegrees() {
        List<String> degrees = new ArrayList<>();
        if (phdCheckBox.isChecked()) {
            degrees.add("Doctoral degree");
        }
        if (lciCheckBox.isChecked()) {
            degrees.add("Licenciate");
        }

        if (msCheckBox.isChecked()) {
            degrees.add("M.Sc. degree");
        }

        if (bcCheckBox.isChecked()) {
            degrees.add("B.Sc. degree");
        }



        return degrees;
    }

    private String getSelectedDegreeProgram() {
        int selectedRadioButtonId = radioDegreeProgram.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
        if (selectedRadioButton != null) {
            return selectedRadioButton.getText().toString();
        }
        return "";
    }
}
