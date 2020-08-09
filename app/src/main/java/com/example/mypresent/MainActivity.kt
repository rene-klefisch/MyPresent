package com.example.mypresent

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_giftlist, R.id.navigation_shopping, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val bildId = applicationContext.resources.getIdentifier("essen", "drawable", application.packageName)
        val neuenDatensatz = GiftObject(1, "Taschenlampe", false, "Alternate", "Lampe für's Wandern", bildId, "Marius")
        Log.i("Test", "BildId: $bildId")

        val dataId = Gifttablehelper(applicationContext).speichereNeuenEintrag(neuenDatensatz)
        Log.i("Test", "Gespeichert: $dataId")
    }
}