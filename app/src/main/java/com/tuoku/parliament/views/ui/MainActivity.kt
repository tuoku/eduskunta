package com.tuoku.parliament.views.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tuoku.parliament.R
import com.tuoku.parliament.logic.models.ParliamentMember
import com.tuoku.parliament.logic.services.api_services.SharedPreferencesAPI
import com.tuoku.parliament.logic.services.repositories.MembersRepo
import com.tuoku.parliament.logic.utils.MemberAdapter
import com.tuoku.parliament.logic.utils.MemberAdapter2
import com.tuoku.parliament.logic.viewmodels.MainActivityViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        SharedPreferencesAPI.setFile(getSharedPreferences("${packageName}_preferences", Context.MODE_PRIVATE))
        GlobalScope.launch {
            checkAndFetch()
        }

        setCon(this)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        setNav(navController)

        findViewById<BottomNavigationView>(R.id.bottomNav).setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_camera -> {
                    navController.navigate(R.id.action_global_cameraFragment)
                    true
                }
                R.id.navigation_members -> {
                    navController.navigate(R.id.action_global_mainFragment)
                    true
                }
                else -> false
            }
        }

    }


    //TODO: fetching resets favorites
    suspend  fun checkAndFetch(){
        // If members have never been fetched from API, or its been more than a week since last fetch we fetch them again
        Log.d("|||||||||||||||||||||||", SharedPreferencesAPI.getMillis().toString())
        if(System.currentTimeMillis() - SharedPreferencesAPI.getMillis() > (1000 * 60 * 60 * 24 * 7).toLong() || SharedPreferencesAPI.getMillis() == 0.toLong()){
            var mems = MembersRepo.fetchAllFromAPI()
            Log.d("**********************", mems.toString())
            if(mems.isNotEmpty()){
                for(m in mems){
                    MembersRepo.addMember(m)
                }
                SharedPreferencesAPI.setMillis(System.currentTimeMillis())

            }


        }

    }

    companion object{
        private lateinit var context: Context
        private lateinit var nav: NavController

        fun setCon(con: Context){
            context = con
        }
        fun getCon() = context
        fun setNav(navv:NavController) {
            nav = navv
        }
        fun getNav() = nav
    }
}