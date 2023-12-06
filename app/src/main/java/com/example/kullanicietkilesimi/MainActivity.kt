package com.example.kullanicietkilesimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonPopup:Button = findViewById(R.id.buttonPopup)
        var popupMenu = PopupMenu(this@MainActivity, buttonPopup)
        popupMenu.menuInflater.inflate(R.menu.menu1, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { item ->

            when(item.itemId){
                R.id.menuItemSil -> {
                    Toast.makeText(applicationContext, "Sil Seçildi", Toast.LENGTH_LONG).show()
                    Log.e("Debug->","Sil Seçildi")
                    true
                }
                R.id.menuItemDuzenle -> {
                    Toast.makeText(applicationContext, "Düzenle Seçildi", Toast.LENGTH_LONG).show()
                    Log.e("Debug->","Düzenlendi Seçildi")
                    true
                }else -> false
            }
        }
        buttonPopup.setOnClickListener {
            popupMenu.show()
        }
    }
}