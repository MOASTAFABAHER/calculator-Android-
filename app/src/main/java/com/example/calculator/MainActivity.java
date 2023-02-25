package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView resultTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView= findViewById(R.id.textResultView_id);
    }
    public void onButtonClick(View view){

        resultTextView.append(( (Button)view).getText());


    }
    String operator="";
    String lhs="";
    public  void onOperatorClick(View view){
        Button clickButtonOPerator=(Button)view ;
      if(operator.isEmpty()){
          lhs =resultTextView.getText().toString();
          operator=clickButtonOPerator.getText().toString();
          resultTextView.setText(null);

      }else{
          String rightHeadSide=resultTextView.getText().toString()  ;
        lhs =  calulate(lhs,operator,rightHeadSide);
          operator=clickButtonOPerator.getText().toString();
          resultTextView.setText(null);


      }


    }
    public String calulate(String lhd,String operator,String rhd){
        double result=0;
    double leftHandSide=Double.parseDouble(lhd);
        double rightHandSide=Double.parseDouble(rhd);
        if(operator.equals("+")){
            result=leftHandSide+rightHandSide;
        }else if(operator.equals("*")){
            result=leftHandSide*rightHandSide;
        }else if(operator.equals("-")){
            result=leftHandSide-rightHandSide;
        }else if(operator.equals("/")){
            result=leftHandSide/rightHandSide;
        }
        return  result+"";
    }
    public   void  onEqualClick(View view){
        String rhs=resultTextView.getText().toString();
        resultTextView.setText(calulate(lhs,operator,rhs));
        operator="";
                lhs="";
    }
}