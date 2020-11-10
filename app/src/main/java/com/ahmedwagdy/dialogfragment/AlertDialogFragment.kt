package com.ahmedwagdy.dialogfragment

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class AlertDialogFragment() : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val alertDialog = AlertDialog.Builder(activity!!).create()
        with(alertDialog){
            setTitle("Alert")
            setMessage("Here's some important information!")
            setButton(AlertDialog.BUTTON_NEUTRAL,"OK") { dialog, which ->
                dialog.dismiss()
            }
        }
        return alertDialog
    }
}