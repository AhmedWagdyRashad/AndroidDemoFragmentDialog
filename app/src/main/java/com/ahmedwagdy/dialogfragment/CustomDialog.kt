package com.ahmedwagdy.dialogfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_custom.view.*

class CustomDialog : DialogFragment() {

    lateinit var firstNameEdt:EditText
    lateinit var lastNameEdt:EditText
    lateinit var ageEdt:EditText

    companion object{
        const val PERSON_KEY = "PERSON_KEY"

        fun newInstance(person: Person):CustomDialog{
            /*
            val args = Bundle()
            args.putParcelable(PERSON_KEY,person)
            fragment.arguments = args
            */
            return CustomDialog().apply {
                arguments = Bundle().apply {
                    putParcelable(PERSON_KEY,person)
                }
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflate the custom dialog layout
        val rootView = inflater.inflate(R.layout.dialog_custom, container, false)
        firstNameEdt = rootView.text_first_name
        lastNameEdt = rootView.text_last_name
        ageEdt = rootView.text_age
        //get argument from a fragment
        val bundle = Bundle()
        val person = arguments?.getParcelable<Person>(PERSON_KEY)
        if (person!=null){
            setDialogText(person)
        }
        //hold views to apply some actions on it
        val btnOK = rootView.findViewById<Button>(R.id.ok_button)
        btnOK.setOnClickListener {
            dismiss()
        }
        val btnCancel = rootView.findViewById<Button>(R.id.cancel_button)
        btnCancel.setOnClickListener {
            dismiss()
        }
        return rootView

    }

    fun setDialogText(person: Person){
        firstNameEdt.setText(person.firstName)
        lastNameEdt.setText(person.lastName)
        ageEdt.setText(person.age.toString())

    }
}