package com.example.dogapp.repository

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.dogapp.data.AppointmentDB
import com.example.dogapp.data.AppointmentDao
import com.example.dogapp.model.Appointment

class AppointmentRepository (val context: Context) {
    private var appointmentDao:AppointmentDao = AppointmentDB.getDatabase(context).appointmentDao()

    suspend fun insertAppointment(appointment: Appointment) {
        withContext(Dispatchers.IO) {
            appointmentDao.insertAppointment(appointment)
        }
    }

    suspend fun getAllAppointment(): MutableList<Appointment> {
        return withContext(Dispatchers.IO) {
            appointmentDao.getAllAppointment()
        }
    }

    suspend fun deleteAppointment(appointment: Appointment){
        withContext(Dispatchers.IO){
            appointmentDao.deleteAppointment(appointment)
        }
    }

    suspend fun updateAppointment(appointment: Appointment){
        withContext(Dispatchers.IO){
            appointmentDao.updateAppointment(appointment)
        }
    }

}