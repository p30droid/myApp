package com.androidlearn.digiandroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.androidlearn.digiandroid.config.ConfigApp
import com.androidlearn.digiandroid.databinding.ActivityMainBinding
import com.androidlearn.digiandroid.di.DaggerUserComponent
import com.androidlearn.digiandroid.di.UserComponent
import com.androidlearn.digiandroid.di.UserModule
import com.androidlearn.digiandroid.ui.category.CategoryFragment
import com.androidlearn.digiandroid.ui.help.HelpActivity
import com.androidlearn.digiandroid.ui.home.HomeFragment
import com.androidlearn.digiandroid.ui.login.LoginActivity
import com.androidlearn.digiandroid.ui.main.TabsAdapter
import com.androidlearn.digiandroid.ui.setting.SettingFragment
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

        var app : ConfigApp = ConfigApp()
        app.getContext()
        app.getComponent()?.provideUser()?.addUser("")
        ConfigApp().getContext()
        ConfigApp().getComponent()?.provideUser()?.user


        binding.bottomMenu.setOnItemSelectedListener { it->


            when(it.itemId){

                R.id.item_home-> {
                    binding.pager.currentItem = 0
                    binding.bottomMenu.getMenu().findItem(R.id.item_home).setChecked(true)
                }

                R.id.item_category-> {
                    binding.pager.currentItem = 1
                    binding.bottomMenu.getMenu().findItem(R.id.item_category).setChecked(true)
                }

                R.id.item_setting-> {
                    binding.pager.currentItem = 2
                    binding.bottomMenu.getMenu().findItem(R.id.item_setting).setChecked(true)
                }


            }

            true

        }

        binding.pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                when(position){

                    0 ->{
                        binding.pager.currentItem = 0
                        binding.bottomMenu.getMenu().findItem(R.id.item_home).setChecked(true)
                    }
                    1 ->{
                        binding.pager.currentItem = 1
                        binding.bottomMenu.getMenu().findItem(R.id.item_category).setChecked(true)
                    }
                    2 ->{
                        binding.pager.currentItem = 2
                        binding.bottomMenu.getMenu().findItem(R.id.item_setting).setChecked(true)
                    }


                }

            }

        })


        val map: MutableMap<Int, String> = HashMap()

        map[1] = "Reza"
        map[2] = "Kasra"
        map[3] = "Parsa"

        val it: Iterator<*> = map.entries.iterator()
        while (it.hasNext()) {
            val pair = it.next() as Map.Entry<*, *>
            println(pair.key.toString() + " = " + pair.value)
            // it.remove(); // avoids a ConcurrentModificationException
        }


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
            R.id.item_help -> {

                var intent = Intent(applicationContext , HelpActivity::class.java)
                startActivity(intent)

            }


        }


        return super.onOptionsItemSelected(item)
    }






}