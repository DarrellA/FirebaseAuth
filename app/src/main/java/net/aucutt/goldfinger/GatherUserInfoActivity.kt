package net.aucutt.goldfinger

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_gather_user_info.*

val EMAIL = "email"
val DISPLAY_NAME = "displayName"

class GatherUserInfoActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gather_user_info)
        findViewById<Button>(R.id.nevermindButton).setOnClickListener { cancel() }
        findViewById<Button>(R.id.saveButton).setOnClickListener { saveInfo() }
    }


    private fun saveInfo()  {
        val data = Intent();
        if(email.text != null) {
            Log.d("Darrell", email!!.text.toString())
        }
        if(displayName.text != null) {
            Log.d("Darrell", displayName!!.text.toString())
        }
        data.putExtra(EMAIL, email.text.toString())
        data.putExtra(DISPLAY_NAME, displayName.text.toString())
        setResult(RESULT_OK, data)
        finish()
    }

    private  fun cancel() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
}
