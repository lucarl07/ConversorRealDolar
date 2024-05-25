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

    private fun warnOnEmptyFields() {}

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

        val reais = binding.editBRL.text.toString().trim()

        binding.btnDolar.setOnClickListener {
            if (reais.isNotEmpty()) {
                val dolares = String.format("%.2f", reais.toDouble() * 0.19)
                val resultadoUSD = "O valor corresponde a $ $dolares"
                binding.textUSD.text = resultadoUSD
            } else {
                Toast.makeText(applicationContext,
                    getString(R.string.aviso_caso_vazio),
                    Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnEuro.setOnClickListener {
            if (reais.isNotEmpty()) {
                val euros = String.format("%.2f", reais.toDouble() * 0.18)
                val resultadoEUR = "O valor corresponde a € $euros"
                binding.textUSD.text = resultadoEUR
            } else {
                Toast.makeText(applicationContext,
                    getString(R.string.aviso_caso_vazio),
                    Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnPesoArg.setOnClickListener {
            if (reais.isNotEmpty()) {
                val pesos = String.format("%.2f", reais.toDouble() * 170)
                val resultadoARG = "O valor corresponde a € $pesos"
                binding.textUSD.text = resultadoARG
            } else {
                Toast.makeText(applicationContext,
                    getString(R.string.aviso_caso_vazio),
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}