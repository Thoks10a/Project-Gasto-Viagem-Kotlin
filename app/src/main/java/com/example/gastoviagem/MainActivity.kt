package com.example.gastoviagem

import android.app.PendingIntent.getActivity
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gastoviagem.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Hide the status bar.
        //window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        //actionBar?.hide()


        //getSupportActionBar()?.hide()



        var distance = binding.InputTextDistance
        var price = binding.InputTextPrice
        var auto = binding.InputTextAuto
        var real = binding.TextReal

        val decimal = DecimalFormat("0.00")

        //var increment = 0



        binding.ButtonCalculate.setOnClickListener(this)
        binding.ButtonCalculate.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                try{
                //increment++
                //real.setText("deu merda ${increment} vezes")
                var total: Float = calculate()


                real.setText("R$: ${decimal.format(total)}")
                //a.toString()
                //print(a)
                //real.setText(a)
                } catch (e: NumberFormatException) {

                    Toast.makeText(this@MainActivity,"Por favor preencha todos os campos!",Toast.LENGTH_SHORT).show()
                }

            }

        })

    }

    override fun onClick(v: View?) {

    }

    private fun calculate():Float {
        var total: Float = 0f
        var distance = binding.InputTextDistance.text.toString().toFloat()
        var price = binding.InputTextPrice.text.toString().toFloat()
        var auto = binding.InputTextAuto.text.toString().toFloat()
        total = (distance * price) / auto
        Toast.makeText(this,"Valor calculado!",Toast.LENGTH_SHORT).show()
        return total
    }

}