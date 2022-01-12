package ge.msda.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var editTextEmail:EditText
    private lateinit var editTextPassword:EditText
    private lateinit var buttonRegister:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        init()

        registerListeners()

    }

    private fun init() {
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonRegister = findViewById(R.id.buttonRegister)
    }

    private fun registerListeners() {
        buttonRegister.setOnClickListener {

            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, password)


            private boolean validateEmail() {
                String emailInput = MainActivityEmail . getText ().toString().trim();
                if (emailInput.isEmpty()) {
                    MainActivityEmailerror.setText("Field can't be empty");
                    return false;

                } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                    MainActivityEmailerror.setText("Please enter a valid email address");
                    return false;
                } else {
                    MainActivityEmailerror.setError(null);
                    return true;
                }
            }
            private boolean validatePassword() {
                String passwordInput = MainActivityPassword . getText ().toString().trim();
                String ConfirmpasswordInput = MainActivityConfirmPassword . getText ().toString()
                    .trim();
                if (passwordInput.isEmpty()) {
                    MainActivityPasswordError.setText("Field can't be empty");
                    return false;
                }  if (passwordInput.length() < 5) {
                MainActivityPasswordError.setText("Password must be at least 5 characters");
                return false;
            }
                if (!passwordInput.equals(ConfitmpasswordInput)) {
                    MainActivityConfirmPassError.setText("Password Would Not be matched");
                    return false;
                } else {
                    MainActivityConfirmPassError.setText("Password Matched");
                    return true;
                }
            }
        }