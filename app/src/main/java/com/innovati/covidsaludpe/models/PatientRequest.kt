package com.innovati.covidsaludpe.models

data class PatientRequest (val districtId: Int,
                      val docTypeId: Int,
                      val docNumber: String,
                      val firstName: String,
                      val lastName: String,
                      val dateOfBirth: String,
                      val age: Int,
                      val phone: String,
                      val address: String,
                      val genre: Char)