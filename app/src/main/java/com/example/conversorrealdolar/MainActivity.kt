package com.example.conversorrealdolar

import android.annotation.SuppressLint
import android.os.Bundle
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
            val reais = binding.editBRL.text.toString().toDoubleOrNull()

            if (reais == null) {
                binding.outUSD.text = getString(R.string.aviso_caso_nao_numero)
            } else {
                val dollars = String.format("%.2f", reais * 0.19)
                val conversion = "R$ $reais -> $ $dollars"
                binding.outUSD.text = conversion
            }
        }
    }
}