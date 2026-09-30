package com.example.kotlincoursemephi

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.os.Debug
import android.util.Log
import java.security.MessageDigest
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.view.isVisible
import com.example.kotlincoursemephi.databinding.MainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: MainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pwSetBtn.setOnClickListener {
            Log.d("CHECK", binding.pwField1.text.toString())
            Log.d("CHECK", binding.pwField2.text.toString())
            if (binding.pwField1.text.toString() == binding.pwField2.text.toString()) {
                val hash = sha256(binding.pwField1.text.toString())
                showHashAndAllowCopy(hash)

                binding.pwField1.text.clear()
                binding.pwField1.clearFocus()
                binding.pwField1.isEnabled = false

                binding.pwField2.text.clear()
                binding.pwField2.clearFocus()
                binding.pwField2.isEnabled = false
            }
            else {
                binding.confirmStatusTv.text = "Passwords don't match. Try again"
            }
            binding.confirmStatusTv.isVisible = true
        }
    }

    private fun sha256(input: String): String {
        val bytes = MessageDigest.getInstance("SHA-256").digest(input.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }

// ... inside your Activity or Fragment ...

    private fun showHashAndAllowCopy(hash: String) {
        binding.confirmStatusTv.text = "Success. Hash: ".plus(hash)

        binding.confirmStatusTv.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("SHA-256 Hash", hash)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, "Hash copied to clipboard!", Toast.LENGTH_SHORT).show()
        }
    }
}