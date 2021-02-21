package com.tuoku.parliament.logic.services.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import com.tuoku.parliament.logic.models.LikesAPIResponse
import com.tuoku.parliament.logic.models.ParliamentMember
import com.tuoku.parliament.logic.services.api_services.LikesAPI
import com.tuoku.parliament.logic.services.api_services.LikesAPIService
import com.tuoku.parliament.logic.services.api_services.ParliamentAPI
import com.tuoku.parliament.logic.services.database_services.MembersDB
import java.lang.Exception

object MembersRepo {
    private val dao = MembersDB.getInstance().memberDao()
    val allMembers: LiveData<List<ParliamentMember>> = dao.getAll()

    suspend fun addMember(member: ParliamentMember){
        dao.insert(member)
    }

    fun getAll(): LiveData<List<ParliamentMember>> {
        return allMembers
    }

    suspend fun fetchAllFromAPI(): List<ParliamentMember> {
        return try {
            ParliamentAPI.retrofitService.getEverybody()
        } catch (e: Exception) {
            Log.e("fetchAllFromAPI()", e.toString())
            emptyList()
        }
    }

    suspend fun like(id:Int){
        val res = LikesAPI.retrofitService.like(id.toString())
        Log.d("LIKE",res.toString())
    }

    suspend fun dislike(id:Int){
        val res = LikesAPI.retrofitService.dislike(id.toString())
        Log.d("DISLIKE",res.toString())
    }

    suspend fun getLikes(id:Int): LikesAPIResponse {
       return LikesAPI.retrofitService.getLikesById(id.toString())
    }

    suspend fun updateScore(score:Int,id:Int){
        dao.updateScore(score,id)
    }
    fun getById(id: Int): LiveData<ParliamentMember> {
        return dao.getById(id)
    }

   suspend fun favourite(id: Int){
        dao.favourite(id)
    }

    suspend fun unFavourite(id:Int){
        dao.unFavourite(id)
    }

}