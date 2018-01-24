package com.example.skadush.smackchatapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.skadush.smackchatapp.Services.AuthService
import kotlinx.android.synthetic.main.activity_create_user.*
import java.util.*

class CreateUserActivity : AppCompatActivity() {

    var userAvatar = "profileDefault"
    var avatarColor = "[0.5, 0.5,0.5,1]"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
    }

    fun createAvatarImageViewClcik(view : View){
        val random = Random()
        val color = random.nextInt(2)
        val avatarNumber = random.nextInt(28)

        if(color == 0){
            userAvatar = "light$avatarNumber"
        }else{
            userAvatar = "dark$avatarNumber"
        }

        val resourceId = resources.getIdentifier(userAvatar, "drawable",packageName)
        createAvatarImageView.setImageResource(resourceId)
    }
    fun createUserButtonClick(view:View){
        AuthService.registerUser(this,"nelzkie.com","1234567"){
            if(it){

            }
        }
    }
    fun generateColorClick(view:View){
        val random = Random()
        val r = random.nextInt(255)
        val g = random.nextInt(255)
        val b = random.nextInt(255)

        createAvatarImageView.setBackgroundColor(Color.rgb(r,g,b))
        val savedR = r.toDouble() / 255  // 0 to 1 scale
        val savedG = g.toDouble() / 255  // 0 to 1 scale
        val savedB = b.toDouble() / 255  // 0 to 1 scale

        avatarColor ="[$savedR,$savedG,$savedB , 1]"
        println(avatarColor )

    }
}
