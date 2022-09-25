package br.edu.infnet.android.showdomilhao

import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
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
        tocaAudioDoEstado(pergunta[indice].audioIntroducao)
//        val mediaPlayer = MediaPlayer.create(
//            context,
//            pergunta[indice].audioIntroducao
//        )

        _binding?.txtPergunta?.text = pergunta[indice].questao.toString()
        object : CountDownTimer(60000, 1000) {


            override fun onTick(millisUntilFinished: Long) {
                _binding?.txtCountDown?.text = "segundos faltantes: " + millisUntilFinished / 1000
            }


            override fun onFinish() {
                _binding?.txtCountDown?.text = "done!"
            }
        }.start()


        mediaPlayer.start()
        var listaBtn = listOf<Button>(

            binding.bt1Resposta,
            binding.bt2Resposta,
            binding.bt3Resposta,
            binding.bt4Resposta,
        )

        for(x in pergunta[indice].respostas.indices){
            val y = listaBtn[x]

            y.alpha = 0f;
            y.translationX = 50F;


            y.animate().alpha(1f)
                .translationYBy(-50.0F)
                .setDuration(1500.toLong());
            listaBtn[x].setOnClickListener {
                _ -> validaResposta(
                pergunta[indice].respostas[x].resposta,
                pergunta[indice].certa
                )
            }
            listaBtn[x].text = pergunta[indice].respostas[x].resposta

        }
    }
    fun exibePergunta(){
        // pega pergunta da lista
        // decide audio a ser tocado
        // exibe pergunta e respostas
    }
    fun acertouResposta(){
        //exibe que acertou
        //salva acerto
        //faz o calculo de porto seguro
        //toca audio
        //aguarda para iniciar a proxima pergunta
    }
    fun errouResposta(){
        //exibe que errou
        //calcula o quanto ganhou
        //mostra o erro
        //salva o quanto ganhou
    }
    fun tocaAudioDoEstado(audio: Int){
        val mediaPlayer = MediaPlayer.create(
            context,
            audio //pergunta[indice].audioIntroducao
        )
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