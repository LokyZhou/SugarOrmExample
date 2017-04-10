package com.example.denzel.sugarormexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.orm.SugarContext;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private EditText mAccountEdit;
    private EditText mPasswordEdit;
    private Button mSave;
    private Button mLoad;
    private Button mUpdate;
    private Button mDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSugar();
        initView();
        initListener();
    }

    private void initSugar() {
        SugarContext.init(this);
    }

    private void initListener() {
        if (mLoad != null) {
            mLoad.setOnClickListener(this);
        }
        if (mSave != null) {
            mSave.setOnClickListener(this);
        }
        if (mUpdate != null) {
            mUpdate.setOnClickListener(this);
        }
        if (mDelete != null) {
            mDelete.setOnClickListener(this);
        }
    }

    private void initView() {
        mAccountEdit = (EditText) findViewById(R.id.editText3);
        mPasswordEdit = (EditText) findViewById(R.id.editText5);
        mSave = (Button) findViewById(R.id.button);
        mLoad = (Button) findViewById(R.id.button2);
        mUpdate = (Button) findViewById(R.id.button3);
        mDelete = (Button) findViewById(R.id.button4);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                save();
                break;
            case R.id.button2:
                load();
                break;
            case R.id.button3:
                update();
                break;
            case R.id.button4:
                delete();
                break;
            default:
                break;
        }
    }

    private void delete() {
        User user = User.findById(User.class, 1);
        if (user != null)
            user.delete();
    }

    private void update() {
        User user = User.findById(User.class, 1);
        if (user != null) {
            user.mAccount = "Maybe";
            user.mPassword = "Burning";
            user.save();
        }
    }

    private void load() {
        User user = User.findById(User.class, 1);
        if (user != null) {
            mAccountEdit.setText(user.mAccount);
            mPasswordEdit.setText(user.mPassword);
        } else {
            mAccountEdit.setText("");
            mPasswordEdit.setText("");
        }
    }

    private void save() {
        User user = new User(mAccountEdit.getText().toString(), mPasswordEdit.getText().toString());
        user.setId((long) 1);//这里指定id，每次保存在相同的地方，避免delete后再也拿不到数据
        user.save();
    }
}
