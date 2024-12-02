package com.example.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class CreatingNewContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_creating_new_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void saveClick(View v)
    {
        TextInputLayout firstNameInput = findViewById(R.id.first_name_input);
        TextInputLayout secondNameInput = findViewById(R.id.second_name_input);
        TextInputLayout surnameInput = findViewById(R.id.surname_input);
        TextInputLayout phoneInput = findViewById(R.id.phone_input);
        TextInputLayout emailInput = findViewById(R.id.email_input);

        String firstName = String.valueOf(Objects.requireNonNull(firstNameInput.getEditText()).getText());
        String secondName = String.valueOf(Objects.requireNonNull(secondNameInput.getEditText()).getText());
        String surname = String.valueOf(Objects.requireNonNull(surnameInput.getEditText()).getText());
        String phone = String.valueOf(Objects.requireNonNull(phoneInput.getEditText()).getText());
        String email = String.valueOf(Objects.requireNonNull(emailInput.getEditText()).getText());

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("firstName", firstName);
        intent.putExtra("secondName", secondName);
        intent.putExtra("surname", surname);
        intent.putExtra("phone", phone);
        intent.putExtra("email", email);
        startActivity(intent);
    }

    private void getTextInput()
    {

    }

    public void goMainActivity(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}