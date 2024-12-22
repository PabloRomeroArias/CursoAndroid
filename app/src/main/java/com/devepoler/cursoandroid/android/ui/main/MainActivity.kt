package com.devepoler.cursoandroid.android.ui.main

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.devepoler.cursoandroid.R
import com.devepoler.cursoandroid.android.core.extension.gone
import com.devepoler.cursoandroid.android.core.extension.visible
import com.devepoler.cursoandroid.databinding.ActivityMainBinding
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<MainViewModel>()
    private val toggle by lazy { ActionBarDrawerToggle(this, binding.drawerLayout, R.string.dialog_toggle_open, R.string.dialog_toggle_close) }

    private val navHostFragment by lazy { supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment }
    private val navController by lazy { navHostFragment.navController }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setUpToolbar()
        setUpDrawer()
        setUpObserver()
    }

    private fun setUpToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            with(binding.toolbar) {
                if (destination.id == R.id.loginFragment) gone()
                else visible()
            }
        }
    }

    private fun setUpDrawer() {
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        binding.navView.setupWithNavController(navController)
        setNavigationItemSelectedListener()
    }

    private fun setNavigationItemSelectedListener() {
        with(binding) {
            navView.setNavigationItemSelectedListener { item ->
                drawerLayout.close()
                val resTitle = when (item.itemId) {
                    R.id.home_fragment -> R.string.home_fragment_title
                    R.id.dialog_fragment -> R.string.dialog_fragment_title
                    R.id.game_list_fragment -> R.string.recycler_fragment_title
                    R.id.coroutines_fragment -> R.string.coroutines_fragment_title
                    else -> R.string.app_name
                }
                setFragmentTitle(resTitle)
                NavigationUI.onNavDestinationSelected(item, navController)
                true
            }
        }
    }

    private fun setFragmentTitle(@StringRes resTitle : Int) {
        supportActionBar?.setTitle(resTitle)
    }

    private fun setUpObserver() {
        viewModel.getUserLiveData().observe(this) { user ->
            val headerView = binding.navView.getHeaderView(0)
            val welcomeMtv = headerView.findViewById<MaterialTextView>(R.id.mtvWelcome)

            val name = user?.name ?: getString(R.string.guess)
            welcomeMtv.text = getString(R.string.welcome, name)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)

        return super.onOptionsItemSelected(item)
    }
}