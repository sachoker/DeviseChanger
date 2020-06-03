package com.example.myapplication

import Converters.Converter
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val valutes: Array<String> = resources.getStringArray(R.array.valutes)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valutes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinentr.adapter = adapter
        spinout.adapter = adapter

        var curse: Double = 1.0
        spinentr.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val converter: Converter = Converter()
                converter.execute(valutes[position], valutes[spinout.selectedItemId.toInt()])
                curse =converter.get()
            }
        }
        spinout.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val converter = Converter()
                converter.execute(valutes[spinentr.selectedItemId.toInt()], valutes[position])
                curse =converter.get()
            }
        }

        input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString() != "") {
                    val ins: Double = s.toString().toDouble()
                    output.text = (ins * curse).toString()
                } else {
                    output.text = ""
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (s.toString() != "") {
                    val ins: Double = s.toString().toDouble()
                    output.text = (ins * curse).toString()
                } else {
                    output.text = ""
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString() != "") {
                    val ins: Double = s.toString().toDouble()
                    output.text = (ins * curse).toString()
                } else {
                    output.text = ""
                }
            }

        })


    }
}