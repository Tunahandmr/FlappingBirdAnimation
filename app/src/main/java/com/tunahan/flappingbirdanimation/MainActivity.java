package com.tunahan.flappingbirdanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.tunahan.flappingbirdanimation.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    int x=0;
    int y=2;
    Runnable runnable;
    Runnable runnable2;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        handler= new Handler();
        if (y==2){ y=3;
            runnable= new Runnable() {

                @Override
                public void run() {
                    if (x==0){
                        binding.imageView.setVisibility(View.VISIBLE);
                        binding.imageView2.setVisibility(View.INVISIBLE);
                        x=1;
                        handler.postDelayed(runnable,400);
                        if (y==3){y=2;
                            runnable2= new Runnable() {
                                @Override
                                public void run() {
                                    if (x==1){
                                        binding.imageView.setVisibility(View.INVISIBLE);
                                        binding.imageView2.setVisibility(View.VISIBLE);
                                        x=0;
                                        handler.postDelayed(runnable2,400);
                                    }
                                }
                            };

                            handler.post(runnable2);
                        }


                    }


                }
            };
            handler.post(runnable);

        }
    }
}