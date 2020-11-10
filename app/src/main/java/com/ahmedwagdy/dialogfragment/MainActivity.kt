package com.ahmedwagdy.dialogfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fab.setOnClickListener{

        }
    }

    private fun showDialog() {
        val dialogFragment = AlertDialogFragment()
        with(dialogFragment){
            isCancelable = false
            show(supportFragmentManager,"DIALOG_FRAGMENT")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.example_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.info_item -> {
                showDialog()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}