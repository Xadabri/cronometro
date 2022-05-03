package com.example.cronometro


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View
import android.widget.Chronometer
import android.widget.Toast


        class MainActivity : AppCompatActivity() {

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                // acceso al cronometro del archivo xml
                val meter = findViewById<Chronometer>(R.id.c_meter)

                //acceso al botton usando id
                val btn = findViewById<Button>(R.id.btn)
                btn?.setOnClickListener(object : View.OnClickListener {

                    var corriendo = false

                    override fun onClick(v: View) {
                        if (!corriendo) {
                            meter.start()
                            corriendo = true
                        } else {
                            meter.stop()
                            corriendo = false
                        }

                        btn.setText(if (corriendo) R.string.parar else R.string.empezar)

                        Toast.makeText(this@MainActivity, getString(
                            if (corriendo)
                                R.string.corriendo
                            else
                                R.string.parado),
                            Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }



