package com.example.mobiletest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.mobiletest.databinding.ActivityHomeBinding;

public class Home extends AppCompatActivity {

    ActivityHomeBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        User user = (User) getIntent().getSerializableExtra("userData");
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment(user) );
        binding.navbottom.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home :
                    replaceFragment(new HomeFragment(user));
                    break ;
                case R.id.money:
                    replaceFragment(new PayFragment(user));
                    break;
                case R.id.search:
                    replaceFragment(new HistoryFragment(user));
                    break;
                case R.id.setting:
                    replaceFragment(new SettingFragment(user));
                    break;
            }

            return true ;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_main,fragment);
        fragmentTransaction.commit();
    }
}