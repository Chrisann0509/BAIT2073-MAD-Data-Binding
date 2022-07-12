package com.example.myhelloworld
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var diceImg:ImageView
   //var diceImg:ImageView=null  may cause exception eg. null exception
    //var :value changeable
    //val: value unchangeable
    lateinit var numbText:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//     diceImg=findViewById(R.id.diceImg)  - cannot put above setContentView cuz haven't prepare view
        setContentView(R.layout.activity_main)
        diceImg=findViewById(R.id.diceImg)
        numbText=findViewById(R.id.numberTxt)
        val rollButton:Button=findViewById(R.id.rollBtn)
        //val rollButton=findViewById<Button>(R.id.rollBtn)
        rollButton.setOnClickListener{rollDice()}  //prepare layout
    }

    private fun rollDice(){
       // Toast.makeText(this, "Roll",
      //  Toast.LENGTH_SHORT).show()

        val randomNum=(1..6).random()
  //      val numberText: TextView =findViewById(R.id.numberTxt)
          numbText.text=randomNum.toString()
//        val diceImg: ImageView =findViewById(R.id.diceImg)
        val imgSrc=when(randomNum){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6

        }

        diceImg.setImageResource(imgSrc)

        Toast.makeText(this,randomNum.toString(),
        Toast.LENGTH_SHORT).show()
    }
}