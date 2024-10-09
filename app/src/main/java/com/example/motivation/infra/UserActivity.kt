package com.example.motivation.infra

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.motivation.ui.MotivationConstants
import com.example.motivation.R
import com.example.motivation.ui.SecurityPreferences
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        verifyUserName()

        binding.buttonSave.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_save) {
            handleSave()
        }
    }

    private fun verifyUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        if (name != "") {
            startActivity(Intent(this, MainActivity::class.java)) //Navigation
        }
    }

    private fun handleSave() {
        val name = binding.editText.text.toString()
        if (name == "") {

            Toast.makeText(this, "Ta de marola, Menó?", Toast.LENGTH_SHORT).show()
        } else {

            SecurityPreferences(this).StoreString(MotivationConstants.KEY.USER_NAME, name)

            startActivity(Intent(this, MainActivity::class.java)) //Navigation
            finish()
        }

    }

}