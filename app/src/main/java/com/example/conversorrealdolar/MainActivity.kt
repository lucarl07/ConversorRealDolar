package com.example.conversorrealdolar

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.conversorrealdolar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnDolar.setOnClickListener {
            writeConvertedValue(0.19, '$')
        }
        binding.btnEuro.setOnClickListener {
            writeConvertedValue(0.18, '€')
        }
        binding.btnPesoArg.setOnClickListener {
            writeConvertedValue(170.0, '$')
        }
    }

    private fun writeConvertedValue(rate: Double, symbol: Char) {
        val reais = binding.editBRL.text.toString()

        if (reais.isNotEmpty()) {
            val currency = Math.round((reais.toDouble() * rate) * 100.0) / 100.0
            val result = "O valor corresponde a $symbol $currency"
            binding.textResultado.text = result
        } else {
            Toast.makeText(applicationContext,
                getString(R.string.aviso_caso_vazio),
                Toast.LENGTH_SHORT).show()
        }
    }
}