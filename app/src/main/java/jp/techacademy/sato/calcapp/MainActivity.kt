package jp.techacademy.sato.calcapp

import android.R.drawable.edit_text
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addBtn.setOnClickListener(this)
        subBtn.setOnClickListener(this)
        mulBtn.setOnClickListener(this)
        divBtn.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        try {

            val value1 = editText1.text.toString().toDouble()
            val value2 = editText2.text.toString().toDouble()
            val intent = Intent(this, SecondActivity::class.java)
            val result:Double =
                when (v?.id) {
                    R.id.addBtn -> value1 + value2
                    R.id.subBtn -> value1 - value2
                    R.id.mulBtn -> value1 * value2
                    R.id.divBtn -> value1 / value2
                    else -> 0.0
                }

            intent.putExtra("RESULT", result)
            startActivity(intent)

        } catch(e: Exception){
            if (v != null) {
                Snackbar.make(v, "整数を入力してください", Snackbar.LENGTH_SHORT).show()
            }
        }

    }
}