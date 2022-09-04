package br.edu.infnet.android.showdomilhao.model

class Pergunta ( val tipo: Char,
                 val questao: String,
                 val respostas: MutableList<Resposta>,
                 val certa: String )