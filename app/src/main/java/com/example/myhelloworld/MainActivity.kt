package com.example.myhelloworld
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.example.myhelloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var diceImg:ImageView
   //var diceImg:ImageView=null  may cause exception eg. null exception
    //var :value changeable
    //val: value unchangeable
//    lateinit var numbText:TextView
//    lateinit var nameText: EditText
//    lateinit var playerNameText:TextView
    private lateinit var binding:ActivityMainBinding
    private val gameInfo:GameInfo= GameInfo(playerName = "Xuan", totalScore = "0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//     diceImg=findViewById(R.id.diceImg)  - cannot put above setContentView cuz haven't prepare view
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.gameInfo=gameInfo
//        setContentView(R.layout.activity_main)
//        diceImg=binding.diceImg
//        numbText=binding.numberTxt
//        nameText=binding.editPlayerNameET
//        playerNameText=binding.playerName
    //    val rollButton:Button=binding.rollBtn
        //val rollButton=findViewById<Button>(R.id.rollBtn)
        binding.rollBtn.setOnClickListener{rollDice()}  //prepare layout

        binding.updateButton.setOnClickListener{updateName(it)}
    }

    private fun updateName(view: View){
        binding.apply {
            gameInfo?.playerName = binding.editPlayerNameET.text.toString()
            invalidateAll()
            // binding.playerName.text = binding.editPlayerNameET.text.toString()

//            binding.editPlayerNameET.text.clear()
//            binding.editPlayerNameET.clearFocus()
//
//            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//            imm.hideSoftInputFromWindow(view.windowToken, 0) //stop keyboard
        }
    }

    private fun rollDice(){
       // Toast.makeText(this, "Roll",
      //  Toast.LENGTH_SHORT).show()

        val randomNum=(1..6).random()
  //      val numberText: TextView =findViewById(R.id.numberTxt)
          binding.numberTxt.text=randomNum.toString()
//        val diceImg: ImageView =findViewById(R.id.diceImg)
        val imgSrc=when(randomNum){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6

        }

        binding.diceImg.setImageResource(imgSrc)

        Toast.makeText(this,randomNum.toString(),
        Toast.LENGTH_SHORT).show()
    }
}