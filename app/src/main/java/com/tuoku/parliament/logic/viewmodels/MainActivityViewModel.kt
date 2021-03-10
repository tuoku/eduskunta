package com.tuoku.parliament.logic.viewmodels

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.*
import com.tuoku.parliament.logic.models.ParliamentMember
import com.tuoku.parliament.logic.services.repositories.MembersRepo
import com.tuoku.parliament.views.ui.MemberFragment
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {

    private val mAllMembers = MutableLiveData<List<ParliamentMember>>()
    val allMembers: LiveData<List<ParliamentMember>>
        get() = mAllMembers

    init {
       // fetchMembers()
    }

    fun fetchMembers() {
        viewModelScope.launch {
          mAllMembers.value = MembersRepo.allMembers.value
            }

    }
    suspend fun openSheet(owner:ViewModelStoreOwner, manager:FragmentManager, member:ParliamentMember){
        val sheet = MemberFragment.newInstance(
            member,
            ViewModelProvider(owner).get(
                MemberFragmentViewModel::class.java))
        sheet.show(manager, sheet.tag)
    }

}