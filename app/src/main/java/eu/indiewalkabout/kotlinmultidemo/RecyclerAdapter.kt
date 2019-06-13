package eu.indiewalkabout.kotlinmultidemo

import android.content.Context
import android.content.Intent
import android.drm.DrmStore
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import eu.indiewalkabout.kotlinmultidemo.samples.notifications.BasicNotification
import eu.indiewalkabout.kotlinmultidemo.samples.notifications.Notifications

public class RecyclerAdapter(context:Context) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    val TAG = RecyclerAdapter::class.java!!.getSimpleName()

    private var thisContext: Context? = null

    private val titles = arrayOf(
        "Notifications sample",
        "item 2",
        "item 3",
        "item 4",
        "item 5",
        "item 6",
        "item 7")

    private val images = intArrayOf(
        R.drawable.ic_all_out_black_24dp,
        R.drawable.ic_all_out_black_24dp,
        R.drawable.ic_all_out_black_24dp,
        R.drawable.ic_all_out_black_24dp,
        R.drawable.ic_all_out_black_24dp,
        R.drawable.ic_all_out_black_24dp,
        R.drawable.ic_all_out_black_24dp
        )




    init{
        thisContext = context
    }


    /**
     * -----------------------------------------------------------------------------------------------------------------
     * ViewHolder declaration
     * -----------------------------------------------------------------------------------------------------------------
     */
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView


        init {
            itemImage = itemView.findViewById(R.id.item_img)
            itemTitle = itemView.findViewById(R.id.item_title)

            // check click on items
            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()

                var item_titles : String = titles[position];



                when (position) {
                    0 -> openNotificationsDemo()
                }

                Snackbar.make(v, "Click at card $position with $item_titles", Snackbar.LENGTH_LONG)
                    .setAction("Action",null)
                    .show()

            }
        }


    }


    // Intent for open single activity demos
    fun openNotificationsDemo(){
        val basicIntent = Intent(thisContext, Notifications::class.java)
        if ( thisContext != null) thisContext!!.startActivity(basicIntent)
    }




    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.single_card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }
}
