package com.tuoku.parliament.views.ui

import android.content.DialogInterface
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.tuoku.parliament.R
import com.tuoku.parliament.databinding.FragmentMemberBinding
import com.tuoku.parliament.logic.models.LikesAPIResponse
import com.tuoku.parliament.logic.models.ParliamentMember
import com.tuoku.parliament.logic.services.database_services.MembersDB
import com.tuoku.parliament.logic.services.repositories.MembersRepo
import com.tuoku.parliament.logic.viewmodels.MemberFragmentViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MemberFragment : BottomSheetDialogFragment() {
    private lateinit var viewModel: MemberFragmentViewModel
    private lateinit var binding: FragmentMemberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.MyBottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_member, container, false
        )
        viewModel = ViewModelProvider(this).get(MemberFragmentViewModel::class.java)
        binding.memberFragmentViewModel = viewModel
        viewModel.mMember = MembersRepo.getById(requireArguments().getInt("id"))

        viewModel.mMember.observe(this,{
            if(it != null) {
                GlobalScope.launch {
                    var l = MembersRepo.getLikes(it.hetekaId)
                    if(l.score.toInt() != MembersRepo.getById(l.hetekaID.toInt()).value?.likes){
                        MembersRepo.updateScore(l.score.toInt(), l.hetekaID.toInt())
                    }

                }
            }
            binding.apply {
                member = it
                member?.likesAsString = member?.likes.toString() ?: "0"
                invalidateAll()
                Glide.with(this@MemberFragment).load("https://avoindata.eduskunta.fi/${it?.pictureUrl}").into(binding.ivProf)
            }
        })





        binding.fabLike.setOnClickListener {
                GlobalScope.launch {
                  viewModel.mMember?.value?.hetekaId?.let { it1 ->  MembersRepo.like(it1).toString() }
                }

        }
        binding.fabDislike.setOnClickListener {
            GlobalScope.launch {
                viewModel.mMember?.value?.hetekaId?.let { it1 ->  MembersRepo.dislike(it1).toString() }
            }
        }
        binding.ibStarred.setOnClickListener{
            if(binding.member?.starred == true){
                //binding.apply{member?.starred = false}
                    GlobalScope.launch {
                        MembersRepo.unFavourite(binding.member!!.hetekaId)
                    }
                binding.ibStarred.setImageResource(R.drawable.ic_baseline_star_outline_24)
            } else {
                binding.ibStarred.setImageResource(R.drawable.ic_outline_star_24)
                GlobalScope.launch {
                    MembersRepo.favourite(binding.member!!.hetekaId)
                }
               // binding.apply { member?.starred = true }

            }
        }

        return binding.root

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (view?.parent as View).setBackgroundColor(Color.TRANSPARENT)
        val resources = resources

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            assert(view != null)
            val parent = view?.parent as View
            val layoutParams = parent.layoutParams as CoordinatorLayout.LayoutParams
            layoutParams.setMargins(
                64, // LEFT 16dp
                0,
                64, // RIGHT 16dp
                0
            )
            layoutParams.height = 1200
            parent.layoutParams = layoutParams
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param: ParliamentMember, vm: MemberFragmentViewModel) =
            MemberFragment().apply {
                viewModel = vm

            }
    }
}