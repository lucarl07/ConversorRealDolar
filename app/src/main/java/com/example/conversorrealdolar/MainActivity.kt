package com.example.conversorrealdolar

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
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

        enableEdgeToEdge() // Maximiza o espaço da aplicação no dispositivo

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnConverter.setOnClickListener {
            val reais = binding.editBRL.text.toString().trim()

            // Math.round(number * 10.0) / 10.0
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
    }
}