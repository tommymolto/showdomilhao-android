package br.edu.infnet.android.showdomilhao.repository

import br.edu.infnet.android.showdomilhao.model.Pergunta
import br.edu.infnet.android.showdomilhao.model.Resposta

class PerguntaRepository {
    fun selectPerguntas(): MutableList<Pergunta> {
        return mutableListOf(
            Pergunta(
                'F',
                "Em que estado brasileiro nasceu a apresentadora Xuxa?",
                mutableListOf(
                    Resposta("RIO DE JANEIRO"),
                    Resposta("RIO GRANDE DO SUL"),
                    Resposta("SANTA CATARINA"),
                    Resposta("GOIÁS"),
                ),
                "RIO GRANDE DO SUL"
            ),
            Pergunta(
                'F',
                "Qual é o nome dado ao estado da água em forma de gelo?",
                mutableListOf(
                    Resposta("LÍQUIDO"),
                    Resposta("SÓLIDO"),
                    Resposta("GASOSO"),
                    Resposta("VAPOROSO"),
                ),
                "SÓLIDO"
            )
        )
    }
}