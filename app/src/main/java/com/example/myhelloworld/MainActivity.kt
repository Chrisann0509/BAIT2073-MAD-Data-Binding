package com.example.myhelloworld
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var diceImg:ImageView
   //var diceImg:ImageView=null  may cause exception eg. null exception
    //var :value changeable
    //val: value unchangeable
    lateinit var numbText:TextView
    lateinit var nameText: EditText
    lateinit var playerNameText:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//     diceImg=findViewById(R.id.diceImg)  - cannot put above setContentView cuz haven't prepare view
        setContentView(R.layout.activity_main)
        diceImg=findViewById(R.id.diceImg)
        numbText=findViewById(R.id.numberTxt)
        nameText=findViewById(R.id.editPlayerNameET)
        playerNameText=findViewById(R.id.playerName)
        val rollButton:Button=findViewById(R.id.rollBtn)
        //val rollButton=findViewById<Button>(R.id.rollBtn)
        rollButton.setOnClickListener{rollDice()}  //prepare layout
        val updateBtn:Button=findViewById(R.id.updateButton)
        updateBtn.setOnClickListener{updateName(it)}
    }

    private fun updateName(view: View){

        playerNameText.text=nameText.text
        nameText.text.clear()
        nameText.clearFocus()

        val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0) //stop keyboard

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