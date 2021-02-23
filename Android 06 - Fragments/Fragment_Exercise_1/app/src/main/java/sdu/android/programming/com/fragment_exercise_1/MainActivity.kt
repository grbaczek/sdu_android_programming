package sdu.android.programming.com.fragment_exercise_1

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View?>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val drawer = findViewById<View?>(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        val navigationView = findViewById<View?>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)




        if (savedInstanceState == null) {

            val fragmentTransaction = supportFragmentManager.beginTransaction()

            fragmentTransaction.replace(R.id.main_fragment, WhiteFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

        }
    }

    override fun onBackPressed() {
        val drawer = findViewById<View?>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId
        if (id == R.id.nav_white) {
            currentFragment = WhiteFragment()
        } else if (id == R.id.nav_red) {
            currentFragment = RedFragment()
        } else if (id == R.id.nav_green) {
            currentFragment = GreenFragment()
        } else if (id == R.id.nav_blue) {
            currentFragment = BlueFragment()
        }
        currentFragment?.let { supportFragmentManager.beginTransaction().replace(R.id.main_fragment, it).addToBackStack(null).commit() }
        val drawer = findViewById<View?>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
    }
}