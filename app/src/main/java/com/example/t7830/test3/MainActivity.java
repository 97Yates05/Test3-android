package com.example.t7830.test3;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private RadioGroup sex;
    private CheckBox hot, fish, sour;
    private SeekBar seekBar;
    private Button find;
    private ImageView imageView;
    private ToggleButton toggleButton;
    private List<Food> lists_food;
    private List<Food> lists_get;
    private Person person;
    private RadioGroupListener radioGroupListener;
    private boolean isFish;
    private boolean isHot;
    private boolean isSour;
    private CheckBoxListener checkBoxListener;
    private int price = 30;
    private SeekBarListener seekBarListener;
    private ButtonListener buttonListener;
    private int b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        // 初始化控件
        initView();
        // 初始化数据
        initData();
        // 为控件添加监听器
        setListener();
    }

    private void setListener() {
        radioGroupListener = new RadioGroupListener();
        sex.setOnCheckedChangeListener(radioGroupListener);
        checkBoxListener = new CheckBoxListener();
        fish.setOnCheckedChangeListener(checkBoxListener);
        hot.setOnCheckedChangeListener(checkBoxListener);
        sour.setOnCheckedChangeListener(checkBoxListener);
        seekBarListener = new SeekBarListener();
        seekBar.setOnSeekBarChangeListener(seekBarListener);
        buttonListener = new ButtonListener();
        find.setOnClickListener(buttonListener);
        toggleButton.setOnClickListener(buttonListener);
    }

    private void initData() {
        person = new Person();
        lists_get = new ArrayList<Food>();
        lists_food = new ArrayList<Food>();
        lists_food.add(new Food("麻辣香锅", 55, R.drawable.malaxiangguo, true, false, false));

        lists_food.add(new Food("水煮鱼", 48, R.drawable.shuizhuyu, true, true, false));
        lists_food.add(new Food("麻辣火锅", 80, R.drawable.malahuoguo, true, true, false));

        lists_food.add(new Food("清蒸鲈鱼", 68, R.drawable.qingzhengluyu, false, true, false));

        lists_food.add(new Food("桂林米粉", 15, R.drawable.guilin, false, false, false));
        lists_food.add(new Food("上汤娃娃菜", 28, R.drawable.wawacai, false, false, false));
        lists_food.add(new Food("红烧肉", 60, R.drawable.hongshaorou, false, false, false));
        lists_food.add(new Food("木须肉", 40, R.drawable.muxurou, false, false, false));
        lists_food.add(new Food("酸菜牛肉面", 35, R.drawable.suncainiuroumian, false, false, true));
        lists_food.add(new Food("西芹炒百合", 38, R.drawable.xiqin, false, false, false));

        lists_food.add(new Food("酸辣汤", 40, R.drawable.suanlatang, true, false,
                true));

    }

    private void initView() {
        name = findViewById(R.id.et_name);
        sex = findViewById(R.id.rg_sex);
        hot = findViewById(R.id.cb_hot);
        fish = findViewById(R.id.cb_fish);
        sour = findViewById(R.id.cb_sour);
        seekBar = findViewById(R.id.sb_price);
        seekBar.setProgress(30);
        find = findViewById(R.id.btn_find);
        toggleButton = findViewById(R.id.tb_click);
        toggleButton.setChecked(true);
        imageView = findViewById(R.id.iv_pic);
    }

    class RadioGroupListener implements OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            // 当用户选择当前RadioGroup组的Button时被触发
            switch (checkedId) {
                case R.id.rb_man:
                    person.setSex("男");
                    break;
                case R.id.rb_woman:
                    person.setSex("女");
                    break;
            }
            System.out.println("性别：" + person.getSex());
        }

    }

    class CheckBoxListener implements
            android.widget.CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {
            // 当控件状态改变时被触发
            CheckBox cbBox = (CheckBox) buttonView;
            switch (cbBox.getId()) {
                case R.id.cb_fish:
                    if (isChecked) {
                        isFish = true;
                    } else {
                        isFish = false;
                    }

                    break;
                case R.id.cb_sour:
                    if (isChecked) {
                        isSour = true;
                    } else {
                        isSour = false;
                    }
                    break;
                case R.id.cb_hot:
                    if (isChecked) {
                        isHot = true;
                    } else {
                        isHot = false;
                    }
                    break;

            }
            System.out.println("当前喜好：" + "辣：" + isHot + " 海鲜：" + isFish + " 酸"
                    + isSour);

        }

    }

    class SeekBarListener implements OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub
            price = seekBar.getProgress();
            Toast.makeText(MainActivity.this, "价格：" + price, Toast.LENGTH_LONG).show();
        }

    }

    class ButtonListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_find:
                    b = 0;
                    lists_get.clear();
                    toggleButton.setChecked(true);
                    checkData();
                    if (lists_get.size() == 0) {
                        Toast.makeText(MainActivity.this, "没有找到对应美食", Toast.LENGTH_SHORT).show();
                        imageView.setImageResource(R.drawable.ic_launcher_background);
                    } else {
                        imageView.setImageResource(lists_get.get(b).getPic());
                        break;
                    }
                case R.id.tb_click:
                    if (!(toggleButton.isChecked()) && b < lists_get.size()) {
                        person.setName(String.valueOf(name.getText()));
                        person.setFood(lists_get.get(b));
                        Toast.makeText(MainActivity.this, person.toString(), Toast.LENGTH_LONG).show();
                        b++;
                    } else if (toggleButton.isChecked()) {
                        if (b < lists_get.size()) {
                            imageView.setImageResource(lists_get.get(b).getPic());
                        } else {
                            imageView.setImageResource(R.drawable.ic_launcher_background);
                            Toast.makeText(MainActivity.this, "已经到最后一个", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;
            }

        }

        private void checkData() {
            // 找出菜品
            for (int i = 0; i < lists_food.size(); i++) {
                Food food = lists_food.get(i);
                if ((food.getPrice() <= price)
                        && (food.isFish() == isFish && food.isHot() == isHot && food
                        .isSour() == isSour)) {
                    lists_get.add(food);
                }
            }
            System.out.println("*********" + lists_get.size());

        }

    }

}

