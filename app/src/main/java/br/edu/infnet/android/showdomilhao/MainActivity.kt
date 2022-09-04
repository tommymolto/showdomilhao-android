package br.edu.infnet.android.showdomilhao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var txtNomeJogador = findViewById<EditText>(R.id.txtNomeJogador)
        var btCOmecarJogo = findViewById<Button>(R.id.btnJogar)
        txtNomeJogador.setOnFocusChangeListener {
                _ , estaFocado ->
            if(estaFocado) {
                txtNomeJogador.setText("")
            }
        }
        btCOmecarJogo.setOnClickListener {
            _ ->
            val profileIntent = Intent(this,
                GameActivity::class.java)
            if(txtNomeJogador.text.trim().toString() != ""){
                profileIntent.putExtra("nomejogador", txtNomeJogador.text.trim().toString())

                startActivity(profileIntent)
            }else{
                txtNomeJogador.error ="Entre com um usuario valido"
            }


        }
    }
}