package cc.somkiat.basicunittesting;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cc.somkiat.basicunittesting.exception.RuleException;
import cc.somkiat.basicunittesting.validation.EmailValidation;
import cc.somkiat.basicunittesting.validation.NameValidation;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.userNameInput)
    TextView name;
    @BindView(R.id.emailInput)
    TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);
    }

    @OnClick(R.id.saveButton)
    public void onSave(){
            try {
                NameValidation nameValidation = new NameValidation(name.getText().toString());
                nameValidation.validate();
                EmailValidation emailValidation = new EmailValidation(email.getText().toString());
                emailValidation.validate();
                validate("Success", "Save Success");
            }catch (RuleException e){
                Log.e("Name error", e.getMessage());
                validate("Error", e.getMessage());
            }
    }

    @OnClick(R.id.revertButton)
    public void onRevert(){
        name.setText("");
        email.setText("");
    }

    private void validate(String title, String error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(error)
                .setPositiveButton("OK", null);
        builder.show();
    }

}
