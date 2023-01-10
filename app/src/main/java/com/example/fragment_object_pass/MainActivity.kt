package com.example.fragment_object_pass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragment_object_pass.fragment.Fragment1
import com.example.fragment_object_pass.fragment.Fragment2
import com.example.fragment_object_pass.model.User

class MainActivity : AppCompatActivity(), Fragment1.Fragment1Listener,Fragment2.Fragment2Listener{
    lateinit var fragment1: Fragment1
    lateinit var fragment2: Fragment2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragment1 = Fragment1()
        fragment2 = Fragment2()

        supportFragmentManager.beginTransaction().replace(R.id.firstFrame,fragment1).replace(R.id.secondFrame,fragment2).commit()
    }

    override fun input1Sent(user: User) {
        fragment2.updateFragment2(user)
    }

    override fun input2Sent(user: User) {
        fragment1.updateFragment1(user)
    }
}