package com.tuoku.parliament.logic.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.tuoku.parliament.logic.models.ParliamentMember
import com.tuoku.parliament.logic.services.repositories.MembersRepo

class MainFragmentViewModel : ViewModel() {

    var favMembers: MutableLiveData<List<ParliamentMember>> = MutableLiveData()
    var allMembers: MutableLiveData<List<ParliamentMember>> = MutableLiveData()

     init {
         MembersRepo.getAll().observeForever { li ->
             favMembers.value = li.filter { it.starred }
             allMembers.value = li
         }
     }


}