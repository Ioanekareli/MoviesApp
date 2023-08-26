package com.example.moviesapp

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding get() = _binding!!
    private var _binding:ActivityMainBinding? = null

//    private lateinit var navController: NavController
//    private lateinit var drawerLayout: DrawerLayout
//    private lateinit var navView:NavigationView

//    private lateinit var listener:NavController.OnDestinationChangedListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        setContentView(binding.root)

//        val drawerLayout = binding.drawerLayout
//        val navigationView = binding.navigationView
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController

//        val menuBtn = binding.appBar.burgerBtn
//        menuBtn.setOnClickListener {
//            drawerLayout.openDrawer(GravityCompat.START)
//        }

    }

//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}