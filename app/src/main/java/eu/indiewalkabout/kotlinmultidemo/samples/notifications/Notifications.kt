package eu.indiewalkabout.kotlinmultidemo.samples.notifications

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.Button
import android.widget.Toast
import eu.indiewalkabout.kotlinmultidemo.R
import kotlinx.android.synthetic.main.activity_main.*

class Notifications : AppCompatActivity() {
    private var basic_btn : Button? = null
    private var bimg_btn  : Button? = null
    private var btxt_btn  : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications_sample)

        val toolbar =  findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle(R.string.notifications_title)

        basic_btn = findViewById(R.id.basic_notif_btn)
        bimg_btn  = findViewById(R.id.bigimg_notif_btn)
        btxt_btn  = findViewById(R.id.bigtxt_notif_btn)

        setClickeListeners()
    }


    fun setClickeListeners(){
        basic_btn!!.setOnClickListener{
            val basicIntent = Intent(this,BasicNotification::class.java)
            startActivity(basicIntent)
        }

        bimg_btn!!.setOnClickListener{
            val basicIntent = Intent(this,BasicNotification::class.java)
            startActivity(basicIntent)

        }


        btxt_btn!!.setOnClickListener{
            val basicIntent = Intent(this,BasicNotification::class.java)
            startActivity(basicIntent)
        }
    }


}
