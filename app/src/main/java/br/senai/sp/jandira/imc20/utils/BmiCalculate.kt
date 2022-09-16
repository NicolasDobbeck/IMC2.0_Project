package br.senai.sp.jandira.imc20.utils

import android.content.Context
import br.senai.sp.jandira.imc20.R
import kotlin.math.pow

fun getBmi(weight: Int, height: Double): Double{
    return weight / height.pow(2)
}

fun getStatusBmi(bmi: Double, context: Context): String {

    if (bmi <= 18.5){
        return context.getString(R.string.under_weight)
    }else if(bmi > 18.5 && bmi < 24.9){
        return  context.getString(R.string.ideal_weight)
    }else if (bmi >= 25 && bmi < 29.9) {
        return context.getString(R.string.over_weight)
    }else if (bmi >= 30 && bmi < 34.9){
        return context.getString(R.string.obesity_grade_I)
    }else if (bmi >= 35 && bmi < 39.9){
        return context.getString(R.string.obesity_grade_II)
    }else{
        return context.getString(R.string.obesity_grade_III)
    }
}