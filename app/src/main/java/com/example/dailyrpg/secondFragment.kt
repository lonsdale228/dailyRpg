package com.example.dailyrpg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_second.view.*
import android.animation.ObjectAnimator
import android.graphics.Interpolator
import android.graphics.drawable.Icon
import android.view.animation.AccelerateInterpolator
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_second.*
import org.w3c.dom.Text
import kotlin.concurrent.thread


class secondFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View? = null
        view = inflater.inflate(R.layout.fragment_second, container, false)

        val btn = view.findViewById<Button>(R.id.button)
        val lvlProgressBar = view.findViewById<ProgressBar>(R.id.lvlProgressBar)

        lvlProgressBar.scaleY=10f;

        val lvlText=view.findViewById<TextView>(R.id.textLvl)

        var lvlValue = lvlText.text.toString().toIntOrNull() ?: 0


        var pBarCount:Int=0;
        var counter:Int=0;
        var lvlCharacter:Int=0;


        //on btn click
        btn.setOnClickListener{
            when(counter){
                0->btn.setText("Нажми на меня")
                1->btn.setText("О да!!!!")
                2->btn.setText("Я же просто кнопка")
                3->btn.setText("Или нет же нет?")
                4->btn.setText("Перестань на меня кликать!!!")
                5->btn.setText("Ну пожалуйста")
            }
            counter+=1;
            if (counter==6) counter=0
            val animator = ObjectAnimator.ofInt(lvlProgressBar, "progress",pBarCount,pBarCount+10)
            pBarCount+=10;
            if (pBarCount==100)
            {
                pBarCount=0;
                lvlValue+=1;
                lvlText.setText(lvlValue.toString())
            }
            animator.interpolator= LinearInterpolator();
            animator.duration = 100;
            animator.start()
        }
        btn.setOnLongClickListener{
            btn.setText("""¯\_(ツ)_/¯""")
            return@setOnLongClickListener true
        }

        //btn animation
        val animZoomIn = AnimationUtils.loadAnimation(context, R.anim.zoom_in)
        btn.startAnimation(animZoomIn)

        //main character animation
        val animDown = AnimationUtils.loadAnimation(requireContext(), R.anim.move_down_up)
        val imgMC = view.findViewById<ImageView>(R.id.imgMainCharacter)
        imgMC.startAnimation(animDown)




        return view
        //return inflater.inflate(R.layout.fragment_second, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}