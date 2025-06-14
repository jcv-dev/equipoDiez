package com.example.dogapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.dogapp.model.Appointment
import com.example.dogapp.repository.AppointmentRepository
import kotlinx.coroutines.launch
//import com.example.dogapp.model.BreedResponse

class AppointmentViewModel (application: Application) : AndroidViewModel(application) {
    val context = getApplication<Application>()
    private val appointmentRepository = AppointmentRepository(context)

    private val _listAppointment = MutableLiveData<MutableList<Appointment>>()
    val listAppointment: LiveData<MutableList<Appointment>> get() = _listAppointment

    private val _progresState = MutableLiveData(false)
    val progresState: LiveData<Boolean> = _progresState

    fun insertAppointment(appointment: Appointment) {
        viewModelScope.launch {
            try {
                appointmentRepository.insertAppointment(appointment)
            } catch (e: Exception) {
                Log.d("error: ", e.toString())
            }
        }
    }

    fun getAllAppointment() {

        viewModelScope.launch {
            try {
                _listAppointment.value = appointmentRepository.getAllAppointment()
            }  catch (e: Exception) {
                Log.d("error: ", e.toString())
            }
        }
    }

    fun updateAppointment(appointment: Appointment) {
        viewModelScope.launch {
            try {
                appointmentRepository.updateAppointment(appointment)
            } catch (e: Exception) {
                Log.d("error: ", e.toString())
            }
        }
    }

    fun deleteAppointment(appointment: Appointment) {
        viewModelScope.launch {
            try {
                appointmentRepository.deleteAppointment(appointment)
            } catch (e: Exception) {
                Log.d("error: ", e.toString())
            }
        }
    }

}