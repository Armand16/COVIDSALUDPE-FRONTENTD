package com.innovati.covidsaludpe.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.innovati.covidsaludpe.R
import com.innovati.covidsaludpe.api.RetrofitClient
import com.innovati.covidsaludpe.models.PatientRequest
import com.innovati.covidsaludpe.models.RegisterRequest
import com.innovati.covidsaludpe.models.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val buttonRegister = findViewById<Button>(R.id.btnRegister)

        buttonRegister.setOnClickListener {

            val editTextDni = findViewById<EditText>(R.id.editTextDNI)
            val editTextName = findViewById<EditText>(R.id.editTextPersonName)
            val editTextNumberYear = findViewById<EditText>(R.id.editTextNumberYear)
            val editTextNumberMonth = findViewById<EditText>(R.id.editTextNumberMonth)
            val editTextNumberDay = findViewById<EditText>(R.id.editTextNumberDay)
            val editTextPhone = findViewById<EditText>(R.id.editTextPhone)
            val editTextAddress = findViewById<EditText>(R.id.editTextAddress)


            if(editTextDni.text.toString().trim().isEmpty()){
                editTextDni.error = "DNI requerido"
                editTextDni.requestFocus()
                return@setOnClickListener
            }


            if(editTextName.text.toString().trim().isEmpty()){
                editTextName.error = "Nombre requerido"
                editTextName.requestFocus()
                return@setOnClickListener
            }

            if(editTextNumberYear.text.toString().trim().isEmpty()){
                editTextNumberYear.error = "Año requerido"
                editTextNumberYear.requestFocus()
                return@setOnClickListener
            }

            if(editTextNumberMonth.text.toString().trim().isEmpty()){
                editTextNumberMonth.error = "Mes requerido"
                editTextNumberMonth.requestFocus()
                return@setOnClickListener
            }

            if(editTextNumberDay.text.toString().trim().isEmpty()){
                editTextNumberDay.error = "Día requerido"
                editTextNumberDay.requestFocus()
                return@setOnClickListener
            }

            if(editTextPhone.text.toString().trim().isEmpty()){
                editTextPhone.error = "Día requerido"
                editTextPhone.requestFocus()
                return@setOnClickListener
            }

            if(editTextAddress.text.toString().trim().isEmpty()){
                editTextAddress.error = "Dirección requerida"
                editTextAddress.requestFocus()
                return@setOnClickListener
            }

            val patient = PatientRequest(1,
                                        1,
                editTextDni.text.toString().trim(),
                editTextName.text.toString().trim(),
                editTextName.text.toString().trim(),
                editTextNumberYear.text.toString().trim() + "-" + editTextNumberMonth.text.toString().trim() + "-" + editTextNumberDay.text.toString().trim(),
                23,
                editTextPhone.text.toString().trim(),
                editTextAddress.text.toString().trim(),
                'M')

            val request = RegisterRequest("armando1231@algo.com", "12345", true, patient)

            RetrofitClient.instance.registerUser(request)
                .enqueue(object: Callback<RegisterResponse> {
                    override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                        Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()
                    }

                })

        }
    }
}