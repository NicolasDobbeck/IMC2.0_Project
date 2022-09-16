package br.senai.sp.jandira.imc20

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.senai.sp.jandira.imc20.databinding.ActivityCalculateBinding
import br.senai.sp.jandira.imc20.databinding.ActivityMainBinding
import br.senai.sp.jandira.imc20.model.User
import br.senai.sp.jandira.imc20.utils.getBmi

class CalculateActivity : AppCompatActivity() {

    lateinit var binding: ActivityCalculateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalculateBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar!!.hide()

        loadProfile()

        binding.buttonCalculate.setOnClickListener {
            bmiCalculate()
        }
        binding.buttonCalculate.setOnClickListener {
            validar()
        }


    }

    private fun validar(): Boolean {
        if(binding.editHeightCalculate.text.isEmpty()){
            binding.editHeightCalculate.error = "Height is required!"
        }
        if (binding.editWeightCalculate.text.isEmpty()){
            binding.editWeightCalculate.error = "Weight is required!"
        }
        return true
    }


    private fun bmiCalculate() {
        val openResult = Intent(this, ResultActivity::class.java)


        //Enviar dados de uma activity para outra
        openResult.putExtra("weight", binding.editWeightCalculate.text.toString())
        openResult.putExtra("height", binding.editHeightCalculate.text.toString().toDouble())

        startActivity(openResult)
    }



    private fun loadProfile() {
        //Abrir o arquivo sharedPreferences
        val dados = getSharedPreferences("dados", MODE_PRIVATE)

        binding.textViewUsername.text = dados.getString("name", "")
        binding.textViewEmail.text = dados.getString("email", "")
        binding.textViewWeight.text = "${resources.getText(R.string.weight)}: ${dados.getInt("weight", 0)} Kg"
        binding.textViewHeight.text = "${resources.getText(R.string.height)}: ${dados.getFloat("height", 0.0F)}"

    }
}