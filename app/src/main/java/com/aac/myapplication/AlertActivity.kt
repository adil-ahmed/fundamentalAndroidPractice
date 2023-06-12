package com.aac.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.os.IResultReceiver._Parcel
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.aac.myapplication.databinding.ActivityAlertBinding

class AlertActivity : AppCompatActivity() {
    lateinit var binding: ActivityAlertBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlertBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Alert Implementation
        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Want to add new person in your contact list?")
            .setIcon(R.drawable.ic_add)
            .setPositiveButton("Yes") {_,_->
                Toast.makeText(this, "Contact Added!", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") {_,_->
                Toast.makeText(this, "Not added", Toast.LENGTH_SHORT).show()
            }.create()

        binding.btnAlt1.setOnClickListener {
            addContactDialog.show()
        }
        val options = arrayOf("First Item", "Second Item", "Third Item")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one options")
            .setSingleChoiceItems(options, 0) {dialogInterface,i->
                Toast.makeText(this,"You clicked on ${options[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept") {_,_->
                Toast.makeText(this, "You accepted the single choice dialog", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Reject") {_,_->
                Toast.makeText(this, "You rejected the single choice dialog", Toast.LENGTH_SHORT).show()
            }.create()

        binding.btnAlt2.setOnClickListener {
            singleChoiceDialog.show()


        }
    }

    // Menu implementation
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }
    // Menu item implementation
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.misettings -> Toast.makeText(this, "Clicked on settings", Toast.LENGTH_SHORT).show()
            R.id.mifavorite -> Toast.makeText(this, "Clicked on favorite", Toast.LENGTH_SHORT).show()
            R.id.miFeedback -> Toast.makeText(this, "Clicked on feedback", Toast.LENGTH_SHORT).show()
            R.id.miClose -> finish()
        }
        return true
    }
}