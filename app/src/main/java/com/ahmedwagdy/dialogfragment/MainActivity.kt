package com.ahmedwagdy.dialogfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fab.setOnClickListener{
            showDialog()
        }
    }

    private fun showDialog() {
        val dialogFragment = AlertDialogFragment()
        with(dialogFragment){
            isCancelable = false
            show(supportFragmentManager,"DIALOG_FRAGMENT")
        }
    }
}