package com.tuoku.parliament.logic.utils

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tuoku.parliament.R
import com.tuoku.parliament.logic.models.ParliamentMember
import com.tuoku.parliament.views.ui.MainActivity
import java.util.*

class MemberAdapter(private var dataSet: List<ParliamentMember>) :
    RecyclerView.Adapter<MemberAdapter.ViewHolder>(), Filterable {

    var memberFilterList = listOf<ParliamentMember>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv: TextView = view.findViewById(R.id.LItvName)
        val parent: CardView = view.findViewById(R.id.cvRvAll)
        val likes: TextView = view.findViewById(R.id.LItvLikes)
        val imgg: ImageView = view.findViewById(R.id.LIivImg)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.li_one, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        //  viewHolder.parent.animation = android.view.animation.AnimationUtils.loadAnimation(viewHolder.itemView.context,R.anim.rv_all_anim)
        viewHolder.tv.text =
            "${dataSet.get(position).lastname}, ${dataSet.get(position).firstname}"
        Glide.with(MainActivity.getCon())
            .load("https://avoindata.eduskunta.fi/${dataSet.get(position).pictureUrl}")
            .into(viewHolder.imgg)
        viewHolder.likes.text = dataSet.get(position).likes.toString()

//        FaceModels.portraits.put(viewHolder.imgg.drawable.toBitmap(),dataSet?.get(position)?.hetekaId)
        viewHolder.tv.setOnClickListener {
            /*
            val sheet = MemberFragment.newInstance(
                dataSet.value!!.get(position),
                ViewModelProvider(ownerr).get(
                    MemberFragmentViewModel::class.java))
            sheet.show(managerr, sheet.tag)
            */

            Log.d("TAP", dataSet.get(position).fullname)
            MainActivity.getNav()
                .navigate(R.id.memberFragment, bundleOf("id" to dataSet.get(position).hetekaId))

        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    memberFilterList = dataSet
                } else {
                    val resultList = mutableListOf<ParliamentMember>()
                    for (m in dataSet) {
                        if (m.fullname.toLowerCase(Locale.ROOT)
                                .contains(charSearch.toLowerCase(Locale.ROOT))
                        ) {
                            resultList.add(m)
                        }
                    }
                    memberFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = memberFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                memberFilterList = results?.values as List<ParliamentMember>
                notifyDataSetChanged()
            }

        }
    }

}
