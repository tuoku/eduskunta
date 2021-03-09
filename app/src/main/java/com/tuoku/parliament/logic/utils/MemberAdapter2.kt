package com.tuoku.parliament.logic.utils

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tuoku.parliament.R
import com.tuoku.parliament.logic.models.ParliamentMember
import com.tuoku.parliament.views.ui.MainActivity


    class MemberAdapter2(private val dataSet: List<ParliamentMember>?) :
        RecyclerView.Adapter<MemberAdapter2.ViewHolder>(){

        class ViewHolder(view: View): RecyclerView.ViewHolder(view){
            val tv: TextView = view.findViewById(R.id.tvFavsName)
            val iv: ImageView = view.findViewById(R.id.ivFavsImg)
            val parent:CardView = view.findViewById(R.id.cvRvFav)
        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            // Create a new view, which defines the UI of the list item
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.li_two, viewGroup, false)

            return ViewHolder(view)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            //viewHolder.parent.animation = android.view.animation.AnimationUtils.loadAnimation(viewHolder.itemView.context,R.anim.rv_favs_anim)
            viewHolder.tv.text = dataSet?.get(position)?.fullname ?: "uh oh"
            Glide.with(MainActivity.getCon()).load("https://avoindata.eduskunta.fi/${dataSet?.get(position)?.pictureUrl}").into(viewHolder.iv)
            viewHolder.iv.setOnClickListener{
                /*
                val sheet = MemberFragment.newInstance(
                    dataSet.value!!.get(position),
                    ViewModelProvider(ownerr).get(
                        MemberFragmentViewModel::class.java))
                sheet.show(managerr, sheet.tag)
                */

                Log.d("TAP",dataSet?.get(position)?.fullname ?: "hmm")
                MainActivity.getNav().navigate(R.id.memberFragment, bundleOf("id" to dataSet?.get(position)!!.hetekaId))

            }
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = dataSet?.size ?: 0

        override fun getItemId(position: Int): Long {
            return dataSet?.get(position)?.hetekaId?.toLong() ?: 0
        }
    }