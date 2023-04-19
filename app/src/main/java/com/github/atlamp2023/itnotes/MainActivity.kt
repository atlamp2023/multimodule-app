package com.github.atlamp2023.itnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.atlamp2023.features.main.view.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launchMainFragment()

    }

    private fun launchMainFragment() {
        val fragment = MainFragment.newInstance()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer, fragment)
            .commit()
    }

}