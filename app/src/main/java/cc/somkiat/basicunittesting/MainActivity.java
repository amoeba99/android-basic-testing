package cc.somkiat.basicunittesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cc.somkiat.basicunittesting.exception.RuleException;
import cc.somkiat.basicunittesting.validation.NameValidation;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.userNameInput)
    TextView name;
    @BindView(R.id.emailInput)
    TextView email;
    @BindView(R.id.dateOfBirthInput)
    TextView birthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

    }

    @OnClick(R.id.saveButton)
    public void onSave(){



    }
    @OnClick(R.id.revertButton)
    public void onRevert(){
        name.setText("");
        email.setText("");
    }
    }
