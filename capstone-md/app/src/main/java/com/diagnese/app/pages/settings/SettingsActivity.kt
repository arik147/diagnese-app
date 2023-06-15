package com.diagnese.app.pages.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.diagnese.app.databinding.ActivitySettingsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsActivity : AppCompatActivity() {

    private var _binding : ActivitySettingsBinding? = null
    private val binding : ActivitySettingsBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

