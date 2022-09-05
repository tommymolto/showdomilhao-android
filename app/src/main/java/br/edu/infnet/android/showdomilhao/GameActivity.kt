package br.edu.infnet.android.showdomilhao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.infnet.android.showdomilhao.model.Pergunta
import br.edu.infnet.android.showdomilhao.repository.PerguntaRepository

class GameActivity : AppCompatActivity() {
    private lateinit var nomejogador: String
    private var totalGanhos: Int = 0
    private var indice: Int = 0
    lateinit var perguntas: MutableList<Pergunta>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_game)
        nomejogador = intent.getStringExtra("nomejogador")!!
        perguntas = PerguntaRepository().selectPerguntas()
    }
}