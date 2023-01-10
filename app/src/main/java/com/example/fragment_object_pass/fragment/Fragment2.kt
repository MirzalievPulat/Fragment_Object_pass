package com.example.fragment_object_pass.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragment_object_pass.R
import com.example.fragment_object_pass.model.User

class Fragment2:Fragment() {
    var listener:Fragment2Listener? = null
    lateinit var textView: TextView
    lateinit var button: Button

    interface Fragment2Listener{
        fun input2Sent(user: User)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment2,container,false)
        textView = view.findViewById(R.id.textView)
        button = view.findViewById(R.id.button)
        button.setOnClickListener {
            var user = User("Fayziyev","Mehrob")
            listener?.input2Sent(user)
        }
        return view
    }

    fun updateFragment2(user:User){
        textView.text = user.toString()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Fragment2Listener){
            listener = context
        }else
            throw RuntimeException("$context must implement Fragment2Listener")
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}