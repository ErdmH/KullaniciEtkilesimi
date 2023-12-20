package com.example.kullanicietkilesimi

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.PopupMenu
import com.google.android.material.snackbar.Snackbar

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
        var tasarim = layoutInflater.inflate(R.layout.alertview,null)
        var editTextAlert = tasarim.findViewById(R.id.editTextText) as EditText
        var ad = AlertDialog.Builder(this@MainActivity)
        var buttonAlart:Button = findViewById(R.id.buttonAlert)

        ad.setMessage("Message")
        ad.setTitle("Title")
        ad.setView(tasarim)
        ad.setIcon(com.google.android.material.R.drawable.ic_clock_black_24dp)


        ad.setPositiveButton("Ok") { dialogInterface, i->
            var gelenVeri = editTextAlert.text.toString()
            Toast.makeText(applicationContext,"Pressed Ok      Gelen Veri = $gelenVeri", Toast.LENGTH_LONG).show()
            tasarim?.apply {
                if (parent != null) {
                    (parent as ViewGroup).removeView(this)
                }
            }
        }
        ad.setNegativeButton("Cancel") { dialogInterface, i->
            Toast.makeText(applicationContext,"Pressed Cancel", Toast.LENGTH_LONG).show()
            tasarim?.apply {
                if (parent != null) {
                    (parent as ViewGroup).removeView(this)
                }
            }
        }
        buttonAlart.setOnClickListener {
            ad.create().show()
        }
        var buttonBasitSnackBar:Button = findViewById(R.id.buttonBasitSnackBar)
        var buttonComeBackSnackBar:Button = findViewById(R.id.buttonComeBackSnackBar)
        var buttonSpecialSnackBar:Button = findViewById(R.id.buttonSpecialSnackBar)
        buttonBasitSnackBar.setOnClickListener { view ->
            Snackbar.make(view,"Merhaba",Snackbar.LENGTH_SHORT).show()
        }
        buttonComeBackSnackBar.setOnClickListener {view ->
            Snackbar.make(view,"Mesaj Silinsin mi?",Snackbar.LENGTH_SHORT).setAction("Evet"){view ->
                Snackbar.make(view,"Mesaj Silindi",Snackbar.LENGTH_SHORT).show()
            }.show()
        }
        buttonSpecialSnackBar.setOnClickListener { view ->
            Snackbar.make(view,"İnternet Bağlantısı Yok!",Snackbar.LENGTH_SHORT).setActionTextColor(Color.RED).setTextColor(Color.BLUE).setBackgroundTint(Color.WHITE).setAction("Tekrar Dene"){}.show()
        }
    }
}