package com.example.myfinances

import android.content.Context
import android.graphics.PorterDuff
import android.widget.Toast

class Tools {

    /** ATRIBUTOS **/
    final val TAG: String = this.javaClass.name

    /** METODOS **/
    fun alert(alertType: String, message: String, duration: Int, context: Context) {
        val toast = Toast.makeText(context, message, duration)
        val view = toast.view
        val mode = PorterDuff.Mode.SRC_IN

        if(alertType == "success") {
            view?.background?.setColorFilter(context.getColor(R.color.green_dark), mode)

        } else if(alertType == "error") {
            view?.background?.setColorFilter(context.getColor(R.color.red_dark), mode)

        }

        toast.show()

    }

}