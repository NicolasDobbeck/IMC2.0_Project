package br.senai.sp.jandira.imc20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import br.senai.sp.jandira.imc20.databinding.ActivityMainBinding
import br.senai.sp.jandira.imc20.databinding.ActivityResultBinding
import br.senai.sp.jandira.imc20.utils.getBmi
import br.senai.sp.jandira.imc20.utils.getStatusBmi
import java.text.DecimalFormat

class ResultActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar!!.hide()

        //Recuperar os valores que estao na intent
        val peso = intent.getStringExtra("weight").toString().toInt()
        val altura = intent.getDoubleExtra("height", 0.0).toString().toDouble()

        val bmi = getBmi(peso, altura)
        val status = getStatusBmi(bmi, this)

        binding.textViewResult.text = "%.2f".format(bmi)
        binding.textViewStatus.text = status



    }
}