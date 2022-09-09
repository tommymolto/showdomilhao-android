package br.edu.infnet.android.showdomilhao

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import br.edu.infnet.android.showdomilhao.databinding.FragmentPerguntaBinding
import br.edu.infnet.android.showdomilhao.model.Pergunta
import br.edu.infnet.android.showdomilhao.model.Resposta


class PerguntaFragment : Fragment() {
    private lateinit var pergunta: MutableList<Pergunta>
    private var indice: Int = 0
    private lateinit var jogoActivity: GameActivity
    private var _binding: FragmentPerguntaBinding? = null
    private val binding: FragmentPerguntaBinding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         jogoActivity = activity as GameActivity


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //val view = binding.root
        _binding = FragmentPerguntaBinding.inflate(
            inflater,
            container, false)



        return binding.root
    }

    companion object {
        fun newInstance() = PerguntaFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pergunta = jogoActivity!!.perguntas
        pergunta[indice].respostas.shuffle()
        var listaBtn = listOf<Button>(

            binding.bt1Resposta,
            binding.bt2Resposta,
            binding.bt3Resposta,
            binding.bt4Resposta,
        )
        var listaTxt = listOf<TextView>(
            binding.txt1Resposta,
            binding.txt2Resposta,
            binding.txt3Resposta,
            binding.txt4Resposta,

            )
        for(x in pergunta[indice].respostas.indices){
            listaBtn[x].setOnClickListener {
                _ -> validaResposta(
                pergunta[indice].respostas[x].resposta,
                pergunta[indice].certa
                )
            }
            listaTxt[x].text = pergunta[indice].respostas[x].resposta

        }
    }
    fun validaResposta(valClique: String, respostaCerta: String){
        if(valClique == respostaCerta){
            val mediaPlayer = MediaPlayer.create(
                context,
                R.raw.certa_resposta)
            mediaPlayer.start()
            Log.d("CERTO", valClique)
            //certa a resposta
            // muda pra proxima

        }else{
            val mediaPlayer = MediaPlayer.create(
                context,
                R.raw.que_pena_voce_errou)
            mediaPlayer.start()
            Log.d("ERRADO", valClique)

        }

        //errada a resposta
        //pega o resultado atual de ponto de salvamento
        ///exibe tela de fim de jogo
    }

}