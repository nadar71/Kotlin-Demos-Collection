package eu.indiewalkabout.kotlinmultidemo.samples.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.support.v7.widget.Toolbar
import android.widget.Button
import eu.indiewalkabout.kotlinmultidemo.R
import kotlinx.android.synthetic.main.activity_main.*

class BasicNotification : AppCompatActivity() {

    var CHANNEL_ID_ANDROID = "com.indiewalk.basic.notifications"
    var CHANNEL_NAME       = "basic_notifications"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_notification)
        setSupportActionBar(toolbar)

        val toolbar =  findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle(R.string.notifications_basic_title)

        val NotificationButton = findViewById<Button>(R.id.button)

        NotificationButton.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            {
                val imp = NotificationManager.IMPORTANCE_HIGH
                val mNotificationChannel = NotificationChannel(CHANNEL_ID_ANDROID,CHANNEL_NAME,imp)
                val notificationBuilder : Notification.Builder = Notification.Builder(this@BasicNotification,CHANNEL_ID_ANDROID)
                    .setSmallIcon(R.drawable.ic_android_black_24dp)
                    .setContentTitle("Basic Notification...")
                    .setContentText("This is Simple Notification example!!.....")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)

                val notificationManager : NotificationManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(mNotificationChannel)
                notificationManager.notify(0,notificationBuilder.build())
            }
            else
            {

                val notificationBuilder2 : NotificationCompat.Builder = NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.ic_android_black_24dp)
                    .setContentTitle("Basic Notification...")
                    .setContentText("Basic Notification Sample Msg.")

                val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.notify(0,notificationBuilder2.build())
            }


        }

    }
}
