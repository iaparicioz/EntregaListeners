package com.example.entregalisteners

import android.annotation.SuppressLint
import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText = findViewById<EditText>(R.id.editTexto)
        val buttonComenzar = findViewById<Button>(R.id.botonComenzar)
        val imagen = findViewById<ImageView>(R.mipmap.logo)

        buttonComenzar.setOnClickListener {
            if(editText.visibility==View.VISIBLE) {
                editText.visibility=View.INVISIBLE
                buttonComenzar.text="FINALIZAR"
            }else{
                buttonComenzar.text="COMENZAR"
                editText.visibility=View.VISIBLE

            }
        }

        editText.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                editText.setText("")

            } else {
               editText.setText("Introduce tu nombre: ")
            }
        }


        editText.addTextChangedListener(object: TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    if (it.contains("Wayne")) {
                        imagen.visibility = View.VISIBLE
                    } else
                        if (it.contains("Joker")) {
                            buttonComenzar.setBackgroundColor(Color.BLUE)
                            editText.setBackgroundColor(Color.YELLOW)
                            buttonComenzar.setTextColor(Color.GRAY)
                            editText.setTextColor(Color.MAGENTA)

                        }

                }
            }
        })
    }
}
