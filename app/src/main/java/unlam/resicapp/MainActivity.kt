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

        onItemOfBottomNavClicked()
        setupToolbar()
    }

    private fun onItemOfBottomNavClicked() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.availableProductsFragment -> navigateToAvailableProductFragment()
                R.id.purchaseHistoryFragment -> navigateToPurchaseHistoryFragment()
            }
            true
        }
    }

    private fun navigateToPurchaseHistoryFragment() = navController.navigate(R.id.purchaseHistoryFragment)

    private fun navigateToAvailableProductFragment() = navController.navigate(R.id.availableProductsFragment)

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
                    hideBottomNavigation()
                    changeToolbarTitle("Producto")
                }

                R.id.purchaseHistoryFragment->{
                    showToolbar()
                    showBottomNavigation()
                    changeToolbarTitle("Historial De Compra")
                }

                R.id.availableProductsFragment->{
                    showToolbar()
                    showBottomNavigation()
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

    private fun changeToolbarTitle(title: String) {
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