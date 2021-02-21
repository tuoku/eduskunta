package com.tuoku.parliament.logic.models

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * A model for constructing parliament members
 */
@Entity
data class ParliamentMember(
    @PrimaryKey(autoGenerate = false) val hetekaId: Int,
    val seatNumber: Int = 0,
    var lastname: String,
    var firstname: String,
    var fullname: String = "$firstname $lastname",
    var party: String,
    val minister: Boolean = false,
    val pictureUrl: String = "",
    var likes: Int = 0,
    var likesAsString:String = likes.toString(),
    var starred: Boolean = false
)

/**
 * The DAO responsible for SQL queries to Room DB
 */
@Dao
interface ParliamentMemberDAO {
    @Query("SELECT * FROM ParliamentMember")
    fun getAll():LiveData<List<ParliamentMember>>

    @Query("SELECT * FROM ParliamentMember WHERE hetekaId = :id")
    fun getById(id:Int):LiveData<ParliamentMember>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(member: ParliamentMember)

    @Query("UPDATE ParliamentMember SET likes = :score WHERE hetekaId = :id")
    suspend fun updateScore(score:Int,id: Int)

    @Query("UPDATE ParliamentMember SET starred = 1 WHERE hetekaId = :id")
    suspend fun favourite(id: Int)

    @Query("UPDATE ParliamentMember SET starred = 0 WHERE hetekaId = :id")
    suspend fun unFavourite(id: Int)
}
