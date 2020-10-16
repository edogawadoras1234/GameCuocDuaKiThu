package com.example.cuocduakithu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.text_diem)
    TextView txt_diem;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.checkBox)
    CheckBox checkBox1;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.checkBox2)
    CheckBox checkBox2;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.checkBox3)
    CheckBox checkBox3;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.seekbar_1)
    SeekBar seekBar1;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.seekbar_2)
    SeekBar seekBar2;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.seekbar_3)
    SeekBar seekBar3;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.button_play)
    Button btn_play;
    int soDiem = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        txt_diem.setText(String.valueOf(soDiem));
        CountDownTimer countDownTimer = new CountDownTimer(20000, 300) {
            @Override
            public void onTick(long millisUntilFinished) {
                int number = 10;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);

                seekBar1.setEnabled(false);
                seekBar2.setEnabled(false);
                seekBar3.setEnabled(false);

                if (seekBar1.getProgress() == seekBar1.getMax()) {
                    this.cancel();
                    Toast.makeText(MainActivity.this, "One Win", Toast.LENGTH_SHORT).show();
                    btn_play.setVisibility(View.VISIBLE);
                    if (checkBox1.isChecked()) {
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn Đã Thắng, Quá Dữ!!!", Toast.LENGTH_SHORT).show();
                    } else {
                        soDiem -= 10;
                        Toast.makeText(MainActivity.this, "Bạn Đã Sai Rồi, Thật Đáng Tiếc", Toast.LENGTH_SHORT).show();
                    }
                    txt_diem.setText(String.valueOf(soDiem));
                    setEnableCheckbox();
                }
                if (seekBar2.getProgress() == seekBar2.getMax()) {
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Two Win", Toast.LENGTH_SHORT).show();
                    btn_play.setVisibility(View.VISIBLE);
                    if (checkBox2.isChecked()) {
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn Đã Thắng, Quá Dữ!!!", Toast.LENGTH_SHORT).show();
                    } else {
                        soDiem -= 10;
                        Toast.makeText(MainActivity.this, "Bạn Đã Sai Rồi, Thật Đáng Tiếc", Toast.LENGTH_SHORT).show();
                    }
                    txt_diem.setText(String.valueOf(soDiem));
                    setEnableCheckbox();
                }
                if (seekBar3.getProgress() == seekBar3.getMax()) {
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Three Win", Toast.LENGTH_SHORT).show();
                    btn_play.setVisibility(View.VISIBLE);
                    if (checkBox3.isChecked()) {
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn Đã Thắng, Quá Dữ!!!", Toast.LENGTH_SHORT).show();
                    } else {
                        soDiem -= 10;
                        Toast.makeText(MainActivity.this, "Bạn Đã Sai Rồi, Thật Đáng Tiếc", Toast.LENGTH_SHORT).show();
                    }
                    txt_diem.setText(String.valueOf(soDiem));
                    setEnableCheckbox();
                }
                seekBar1.setProgress(seekBar1.getProgress() + one);
                seekBar2.setProgress(seekBar2.getProgress() + two);
                seekBar3.setProgress(seekBar3.getProgress() + three);
            }

            @Override
            public void onFinish() {
                btn_play.setVisibility(View.VISIBLE);
            }
        };
        btn_play.setOnClickListener(v -> {
            if (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked()) {
                seekBar1.setProgress(0);
                seekBar2.setProgress(0);
                seekBar3.setProgress(0);
                btn_play.setVisibility(View.INVISIBLE);
                countDownTimer.start();
                setDisableCheckbox();
            } else {
                Toast.makeText(this, "Hãy chọn 1 vị tướng trước khi chơi", Toast.LENGTH_SHORT).show();
            }
        });

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                }
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBox1.setChecked(false);
                    checkBox3.setChecked(false);
                }
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                }
            }
        });
    }
    public void setEnableCheckbox(){
        checkBox1.setEnabled(true);
        checkBox2.setEnabled(true);
        checkBox3.setEnabled(true);
    }
    public void setDisableCheckbox(){
        checkBox1.setEnabled(false);
        checkBox2.setEnabled(false);
        checkBox3.setEnabled(false);
    }
}