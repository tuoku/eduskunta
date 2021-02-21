package com.tuoku.parliament.views.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuoku.parliament.R
import com.tuoku.parliament.databinding.FragmentMainBinding
import com.tuoku.parliament.logic.models.ParliamentMember
import com.tuoku.parliament.logic.services.repositories.MembersRepo
import com.tuoku.parliament.logic.utils.MemberAdapter
import com.tuoku.parliament.logic.utils.MemberAdapter2
import com.tuoku.parliament.logic.viewmodels.MainActivityViewModel
import com.tuoku.parliament.logic.viewmodels.MainFragmentViewModel

class MainFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: FragmentMainBinding
    lateinit var viewModel: MainFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        viewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        binding.mainFragmentViewModel = viewModel

        viewModel.allMembers.observe(viewLifecycleOwner, {
            binding.rvAll.adapter?.notifyDataSetChanged()
        })
//TODO: notify instead of new adapter; stableIDs
        viewModel.favMembers.observe(viewLifecycleOwner, {
            binding.rvFavs.adapter = MemberAdapter2(it)
        })


        binding.rvAll.layoutManager = LinearLayoutManager(MainActivity.getCon())
        binding.rvAll.adapter = viewModel.allMembers.value?.let { MemberAdapter(it) }


        var glm: GridLayoutManager = GridLayoutManager(MainActivity.getCon(), 1)
        glm.orientation = LinearLayoutManager.HORIZONTAL

        binding.rvFavs.layoutManager = glm
        binding.rvFavs.adapter = viewModel.favMembers.value?.let { MemberAdapter2(it) }
        binding.rvFavs.itemAnimator?.changeDuration=0

        ArrayAdapter
            .createFromResource(this.requireContext(), R.array.sort_options, R.layout.spinner_style)
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spinnerSort.adapter = adapter
            }
        binding.spinnerSort.onItemSelectedListener = this

        return binding.root

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (position) {
            // TODO: null-safety
            0 -> binding.rvAll.adapter =
                MemberAdapter(MembersRepo.allMembers.value!!.sortedBy { it.lastname })
            1 -> binding.rvAll.adapter =
                MemberAdapter(MembersRepo.allMembers.value!!.sortedBy { it.lastname }.reversed())
            2 -> binding.rvAll.adapter =
                MemberAdapter(MembersRepo.allMembers.value!!.sortedBy { it.likes }.reversed())
            3 -> binding.rvAll.adapter =
                MemberAdapter(MembersRepo.allMembers.value!!.sortedBy { it.likes })
        }

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}