package com.ahmedwagdy.dialogfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CustomDialog.DataEntryListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.tool_bar)
        setSupportActionBar(toolbar)
        fab.setOnClickListener{
            showCustomDialog()
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
        return when(item.itemId) {
            R.id.info_item -> {
                showDialog()
                true
            }
            else-> {
                super.onOptionsItemSelected(item)
            }
        }

    }

    private fun showCustomDialog(){
        val person = Person("FirstName", "LastName", 25)
        val customDialog = CustomDialog.newInstance(person)
        customDialog.isCancelable = false
        customDialog.show(supportFragmentManager,"DIALOG_FRAGMENT")
    }

    override fun onDataEntryComplete(person: Person) {
        Toast.makeText(this, "${person.firstName} " +
                "${person.lastName}\n age: ${person.age}"
            ,Toast.LENGTH_SHORT).show()
    }

}