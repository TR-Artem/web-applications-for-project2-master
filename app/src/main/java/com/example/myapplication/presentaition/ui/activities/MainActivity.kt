package com.example.myapplication.presentaition.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.presentaition.ui.fragments.registration.LogINFragment
import com.example.myapplication.presentaition.ui.fragments.registration.MUserProfileFragment
import com.example.myapplication.presentaition.ui.fragments.settings.FragmentSettings
import com.example.myapplication.presentaition.viewmodels.userviewmodel.GetUserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val getUserViewModel: GetUserViewModel by viewModels()
    private var menuResId: Int = R.menu.menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        setupMenu()
    }

    private fun setupMenu() {
        val menuHost: MenuHost = this
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: android.view.Menu, menuInflater: android.view.MenuInflater) {
                menuInflater.inflate(menuResId, menu)
            }

            override fun onMenuItemSelected(menuItem: android.view.MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.nav_profile_id -> {
                        replaceFragment(MUserProfileFragment::class.java.name)
                        true
                    }
                    R.id.nav_settings_id -> {
                        replaceFragment(FragmentSettings::class.java.name)
                        true
                    }
                    R.id.nav_login_id -> {
                        replaceFragment(LogINFragment::class.java.name)
                        true
                    }
                    R.id.nav_logout_id -> {
                        menuResId = R.menu.second_menu
                        true
                    }
                    else -> false
                }
            }
        }, this, Lifecycle.State.RESUMED)
    }

    private fun replaceFragment(fragmentName: String) {
        val fragment = supportFragmentManager.fragmentFactory.instantiate(classLoader, fragmentName)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_id, fragment)
            .commit()
    }
}