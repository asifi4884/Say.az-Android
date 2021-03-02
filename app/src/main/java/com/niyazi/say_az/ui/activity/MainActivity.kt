package com.niyazi.say_az.ui.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.niyazi.say_az.HomeNavGraphDirections
import com.niyazi.say_az.R
import com.niyazi.say_az.databinding.ActivityMainBinding
import com.niyazi.say_az.manager.PreferenceManager
import com.niyazi.say_az.manager.setNewLocale
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val navHostFragment: NavHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
    }

    private val navController: NavController by lazy {
        navHostFragment.navController
    }

    private val appBarConfiguration: AppBarConfiguration by lazy {
        AppBarConfiguration(
            setOf(
                R.id.splashFragment,
                R.id.introParentFragment,
                R.id.mainLoginFragment,
                R.id.accountFragment,
                R.id.dashboardFragment,
                R.id.invoiceFragment,
                R.id.reportsFragment,
                R.id.settingsFragment,
                R.id.notificationsFragment
            )
        )
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //PreferenceManager.getInstance(this).getLang().let { setNewLocale(it) }
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        binding.bottomNavView.setupWithNavController(navController)
        setOnDestinationChange()
        setOnClickListener()
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(
            newBase?.setNewLocale(
                PreferenceManager.getInstance(newBase).getLang()
            )
        )
    }

    private fun setOnDestinationChange() {
        navController.addOnDestinationChangedListener { _, destination, _ ->

            binding.toolbar.isVisible =
                destination.id !in arrayOf(R.id.splashFragment, R.id.introParentFragment)

            if (destination.id in arrayOf(
                    R.id.loginFragment,
                    R.id.registerFragment,
                    R.id.registerPersonalInfoFragment,
                    R.id.createAccountFragment,
                    R.id.addAccountFragment,
                    R.id.addAccountFragmentMyBankAccounts,
                    R.id.sendInvoiceFragment,
                    R.id.myBankAccountsFragment,
                    R.id.infoAboutAppFragment,
                    R.id.reportFragment
                )
            ) {
                binding.toolbar.navigationIcon =
                    ContextCompat.getDrawable(this, R.drawable.drawable_back)
            }

            binding.bottomNavView.isVisible = destination.id in arrayOf(
                R.id.accountFragment,
                R.id.dashboardFragment,
                R.id.invoiceFragment,
                R.id.settingsFragment,
                R.id.reportsFragment,
                R.id.notificationsFragment
            )

            binding.includeProfile.root.isVisible = destination.id in arrayOf(
                R.id.accountFragment,
                R.id.dashboardFragment,
                R.id.invoiceFragment,
                R.id.reportsFragment,
                R.id.notificationsFragment
            )

        }
    }

    private fun setOnClickListener() {
        binding.includeProfile.imageViewNotification.setOnClickListener {
            navController.navigate(HomeNavGraphDirections.actionGlobalNotificationsFragment())
        }
    }

}