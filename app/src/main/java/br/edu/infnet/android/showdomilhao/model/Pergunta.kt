package br.edu.infnet.android.showdomilhao.model

import androidx.core.content.res.ResourcesCompat
import br.edu.infnet.android.showdomilhao.R

class Pergunta (val tipo: Char,
                val questao: String,
                val respostas: MutableList<Resposta>,
                val certa: String,
                val audioIntroducao: Int = R.raw.certa_resposta,
                val audioAjudaPublico: String? = "",
                val audioAjudaMeioAMeio: String?= "",
                val audioAjudaAmigo: String?= "",
                )