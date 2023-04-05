package com.example.adv160420031week4.viewmodel

import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.adv160420031week4.model.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.sql.RowId

class DetailViewModel: ViewModel() {
    val studentLD = MutableLiveData<Student>()

    val TAG = "volleyTag"
    private var queue:RequestQueue?=null

    fun fetch(studentId: String){
        queue = Volley.newRequestQueue(getApplication())
        var url = "http://adv.jitusolution.com/student.php?id=$studentId"

        val stringRequest = StringRequest(
            Request.Method.GET, url,{
                val sType = object : TypeToken<Student>(){}.type
                val result = Gson().fromJson<Student>(it,sType)

                Log.d("showdetail", result.toString())

                },{
                   Log.d("showdetail", it.toString())
            })
        stringRequest.tag =TAG
        queue?.add(stringRequest)
            }
    }

   /* fun fetch(id:String,name:String,dob:String,phone:String,url:String) {
        val student1 = Student(id,name,dob,phone,url)
        studentLD.value = student1
    }*/
}