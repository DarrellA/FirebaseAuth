package net.aucutt.goldfinger

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : Activity() {

    private var TAG = "Darrell"


    // Firebase instance variables
    private var firebaseAuth : FirebaseAuth? = null
    private var firebaseUser: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAuth = FirebaseAuth.getInstance()
        firebaseUser = firebaseAuth!!.getCurrentUser()
        if (firebaseUser == null) run {
            // Not signed in, launch the Sign In activity
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }

    override fun onResume(){
        super.onResume()
        Log.d(TAG, "MainActivity resume")
        firebaseUser = firebaseAuth!!.getCurrentUser()
        if (firebaseUser != null ) {
            findViewById<TextView>(R.id.name).visibility = View.VISIBLE
            findViewById<TextView>(R.id.name).text = "Logged in as : "  + firebaseUser!!.displayName
            Log.d(TAG, "son o f a " + firebaseUser!!.uid  +  " "  +firebaseUser!!.email +  "anonymous " +  firebaseUser!!.isAnonymous  + firebaseUser!!.email)
            findViewById<Button>(R.id.signout).apply{
                visibility= View.VISIBLE; setOnClickListener { firebaseAuth!!.signOut();
                            findViewById<Button>(R.id.signout).visibility = View.GONE
                            finish()}
            }
        } else {
            Log.d(TAG, "Son, you go no current user.")
        }
    }
}
