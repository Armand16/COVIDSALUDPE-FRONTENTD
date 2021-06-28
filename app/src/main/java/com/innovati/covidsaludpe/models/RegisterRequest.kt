package com.innovati.covidsaludpe.models

data class RegisterRequest (val email: String, val password: String, val personalDataPolicy: Boolean, val patient: PatientRequest)