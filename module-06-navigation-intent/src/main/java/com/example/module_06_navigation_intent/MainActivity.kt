package com.example.module_06_navigation_intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.PermissionChecker.PERMISSION_GRANTED

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Intent explicite, destination connue
        val buttonMain = findViewById<Button>(R.id.buttonMain)
        buttonMain.setOnClickListener {
            val intentToTarget = Intent(this, TargetActivity::class.java)
            intentToTarget.putExtra("age", 34)
            startActivity(intentToTarget)
            Toast.makeText(
                this,
                intent.getIntExtra("age", -1).toString(),
                Toast.LENGTH_SHORT
            ).show()
        }
//    Intent implicite, destination inconnue
        val buttonCall = findViewById<Button>(R.id.buttonCall)
        buttonCall.setOnClickListener {
            val uri = Uri.parse("tel:0612345678")
            val intentToCall = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intentToCall)
        }

        //   Permission dangereuse
        val buttonSms = findViewById<Button>(R.id.buttonSMS)
        buttonSms.setOnClickListener {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.SEND_SMS),
                22
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 22 && grantResults[0] == PERMISSION_GRANTED) {
            val intentToSms = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:06123456768"))
            intentToSms.putExtra("sms_body", "Salut Max !")
            startActivity(intentToSms)
        }
    }

}
