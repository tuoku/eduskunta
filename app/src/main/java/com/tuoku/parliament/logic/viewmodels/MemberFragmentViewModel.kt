package com.tuoku.parliament.logic.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tuoku.parliament.logic.models.ParliamentMember

class MemberFragmentViewModel : ViewModel() {
    lateinit var mMember: LiveData<ParliamentMember>
    var likes = 0
}