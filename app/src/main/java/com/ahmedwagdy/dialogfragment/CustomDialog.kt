package com.ahmedwagdy.dialogfragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_custom.view.*
import java.lang.Integer.parseInt

class CustomDialog : DialogFragment() {

    private lateinit var firstNameEdt:EditText
    private lateinit var lastNameEdt:EditText
    private lateinit var ageEdt:EditText
    private lateinit var mListener:DataEntryListener

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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = context as DataEntryListener
    }
   /* override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        mListener = activity as DataEntryListener
    }
*/
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
            saveData()
        }
        val btnCancel = rootView.findViewById<Button>(R.id.cancel_button)
        btnCancel.setOnClickListener {
            dismiss()
        }
        return rootView

    }

    private fun saveData() {
        var person = Person()
        person.firstName = firstNameEdt.text.toString()
        person.lastName = lastNameEdt.text.toString()
        person.age = parseInt( ageEdt.text.toString())
        mListener.onDataEntryComplete(person)
        dismiss()
    }

    private fun setDialogText(person: Person){
        firstNameEdt.setText(person.firstName)
        lastNameEdt.setText(person.lastName)
        ageEdt.setText(person.age.toString())

    }

    interface DataEntryListener{
        fun onDataEntryComplete(person: Person)
    }

}