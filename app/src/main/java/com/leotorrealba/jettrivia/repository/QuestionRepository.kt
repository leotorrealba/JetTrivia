package com.leotorrealba.jettrivia.repository

import android.util.Log
import com.leotorrealba.jettrivia.data.DataOrExeption
import com.leotorrealba.jettrivia.model.QuestionItem
import com.leotorrealba.jettrivia.network.QuestionAPI
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionAPI) {
    private val dataOrExeption = DataOrExeption<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestions(): DataOrExeption<ArrayList<QuestionItem>, Boolean, Exception> {
        try {
            dataOrExeption.loading = true
            dataOrExeption.data = api.getAllQuestions()
            if (dataOrExeption.data.toString().isNotEmpty()) dataOrExeption.loading = false
        } catch (exception: Exception) {
            dataOrExeption.e = exception
            Log.d("Exc", "getAllQuestions: ${dataOrExeption.e!!.localizedMessage}")
        }
        return dataOrExeption
    }

}