package com.androidlearn.digiandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import com.androidlearn.digiandroid.databinding.ActivityMainBinding
import com.androidlearn.digiandroid.di.DaggerUserComponent
import com.androidlearn.digiandroid.di.UserComponent
import com.androidlearn.digiandroid.di.UserModule
import com.androidlearn.digiandroid.ui.category.CategoryFragment
import com.androidlearn.digiandroid.ui.home.HomeFragment
import com.androidlearn.digiandroid.ui.login.LoginActivity
import com.androidlearn.digiandroid.ui.main.TabsAdapter
import com.androidlearn.digiandroid.ui.setting.SettingFragment
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var auth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbar)

       // auth = FirebaseAuth.
        auth = Firebase.auth


       // val fragments: List<Fragment> = listOf()

        val fragments = ArrayList<Fragment>()
        val home: HomeFragment = HomeFragment()
        fragments.add(home)

        val category: CategoryFragment = CategoryFragment()
        fragments.add(category)

        val setting: SettingFragment = SettingFragment()
        fragments.add(setting)


        var adapter = TabsAdapter(fragmentActivity = this, fragments)
        binding.pager.adapter = adapter

       // throw  RuntimeException("Fartash Error"); // Force a crash

        auth.createUserWithEmailAndPassword("Heyranian.reza212@gmail.com" , "asd@#f,G43@" )
            .addOnCompleteListener(this , object : OnCompleteListener<AuthResult> {
                override fun onComplete(p0: Task<AuthResult>) {
                   Log.e("result" , p0.toString())
                }

            })


        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        //googleSignInClient = GoogleSignIn.getClient(this, gso)

        var compoent : UserComponent = DaggerUserComponent.builder()
            .userModule(UserModule()).build()

        compoent.provideUser().addUser("Reza Heyranina")
        compoent.provideUser().user


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu , menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        when(item.itemId){

            R.id.item_login -> {

                var intent = Intent(applicationContext , LoginActivity::class.java)
                startActivity(intent)

            }


        }


        return super.onOptionsItemSelected(item)
    }






}