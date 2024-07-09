package unlam.resicapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.resicappandroid.R
import com.example.resicappandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//
//        // Navigation
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController
//
//
//        // Bottom Navigation
//        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//        NavigationUI.setupWithNavController(bottomNavigationView, navController)
//
//        navController.addOnDestinationChangedListener{_, destination, _ ->
//            when(destination.id){
//                R.id.loginFragment, R.id.productDetailFragment ->
//                    bottomNavigationView.visibility = View.GONE
//
//                else -> bottomNavigationView.visibility = View.VISIBLE
//            }
//
//        }

        setupToolbar()
    }

    private fun setupToolbar() {
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = TOP_LEVEL_DESTINATIONS,
            fallbackOnNavigateUpListener = ::onSupportNavigateUp
        )
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        handleNavComponentsVisibility()
    }

    private fun handleNavComponentsVisibility() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.loginFragment -> {
                    showToolbar()
                    hideBottomNavigation()
                    changeToolbarTitle(getString(R.string.toolbar_title))
                }

                R.id.productDetailFragment ->{
                    hideToolBar()
                    hideBottomNavigation()
                    changeToolbarTitle("Producto")
                }

                R.id.purchaseHistoryFragment->{
                    changeToolbarTitle("Historial De Compra")
                }

                R.id.availableProductsFragment->{
                    changeToolbarTitle("Productos Disponibles")
                }

                else -> {
                    showToolbar()
                    showBottomNavigation()
                    changeToolbarTitle(getString(R.string.toolbar_title))
                }
            }
        }
    }

    private fun changeToolbarTitle(string: String) {
        binding.toolbar.title = title
    }

    private fun showToolbar() {
        binding.toolbar.visibility = View.VISIBLE
    }

    private fun hideToolBar() {
        binding.toolbar.visibility = View.GONE
    }

    private fun showBottomNavigation() {
        binding.bottomNavigationView.visibility = View.VISIBLE
    }

    private fun hideBottomNavigation() {
        binding.bottomNavigationView.visibility = View.GONE
    }

    override fun onSupportNavigateUp(): Boolean {
        navController.navigate(R.id.availableProductsFragment)
        return true
    }

    companion object {
        val TOP_LEVEL_DESTINATIONS = setOf(
            R.id.storeFragment,
            R.id.loginFragment
        )
    }

}