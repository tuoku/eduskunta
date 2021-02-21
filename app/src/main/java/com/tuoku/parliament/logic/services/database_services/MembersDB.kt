package com.tuoku.parliament.logic.services.database_services

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tuoku.parliament.logic.models.ParliamentMember
import com.tuoku.parliament.logic.models.ParliamentMemberDAO
import com.tuoku.parliament.views.ui.MainActivity

@Database(entities = [ParliamentMember::class],version = 3, exportSchema = false)
abstract class MembersDB: RoomDatabase() {
    abstract fun memberDao(): ParliamentMemberDAO

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: MembersDB? = null

        fun getInstance(): MembersDB {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    MainActivity.getCon(),
                    MembersDB::class.java,
                    "ParliamentMember"
                )
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}