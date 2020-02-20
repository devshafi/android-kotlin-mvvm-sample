package com.example.mvvmsampleapp.util
import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

// extension function for showing toast
fun Context.toast (message : String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}


// progressbar visibility extension function
fun ProgressBar.show(){
    visibility = View.VISIBLE
}

fun ProgressBar.hide(){
    visibility = View.GONE
}

// snackbar
fun View.snackBar(message: String){
    Snackbar.make(this,message,Snackbar.LENGTH_LONG).also { snackbar ->
        snackbar.setAction("Ok"){
            snackbar.dismiss()
        }.show()
    }
}