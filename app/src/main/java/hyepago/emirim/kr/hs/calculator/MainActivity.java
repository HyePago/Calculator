package hyepago.emirim.kr.hs.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button btn[] = new Button[10];
    Button btn_plus, btn_minus, btn_multi, btn_division, btn_equal, btn_reset;
    TextView input, operator, result, sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0; i<10; i++){
            btn[i] = (Button)findViewById(R.id.btn_0+i);
        }

        btn_plus = (Button)findViewById(R.id.btn_plus);
        btn_minus = (Button)findViewById(R.id.btn_minus);
        btn_multi = (Button)findViewById(R.id.btn_multi);
        btn_division = (Button)findViewById(R.id.btn_division);
        btn_equal = (Button)findViewById(R.id.btn_equal);
        btn_reset = (Button)findViewById(R.id.btn_reset);

                input = (TextView)findViewById(R.id.input);
        operator = (TextView)findViewById(R.id.operator);
        result = (TextView)findViewById(R.id.result);
        sw = (TextView)findViewById(R.id.sw);

        btn_plus.setOnClickListener(SeparatorListener);
        btn_minus.setOnClickListener(SeparatorListener);
        btn_multi.setOnClickListener(SeparatorListener);
        btn_division.setOnClickListener(SeparatorListener);
        btn_equal.setOnClickListener(Click_btn_equal);
        btn_reset.setOnClickListener(ResetListener);

        for(int i=0; i<10; i++){
            btn[i].setOnClickListener(NumberListener);
        }
    }

    View.OnClickListener SeparatorListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button click_separator = (Button)view;
            int input_number;
            int result_number = Integer.parseInt(result.getText().toString());

            if(input.getText().equals("0")){
                input_number = 0;
            } else {
                input_number = Integer.parseInt(input.getText().toString());
            }

            if(sw.getText().equals("0")) {
                switch (operator.getText().toString()) {
                    case "+":
                        result.setText(String.valueOf(result_number + input_number));
                        break;
                    case "-":
                        result.setText(String.valueOf(result_number - input_number));
                        break;
                    case "/":
                        result.setText(String.valueOf(result_number / input_number));
                        break;
                    case "*":
                        result.setText(String.valueOf(result_number * input_number));
                        break;
                    case "=":
                        break;
                    default:
                        result.setText(String.valueOf(input_number));
                }

                input.setText(result.getText());

                switch (click_separator.getText().toString()) {
                    case "+":
                        operator.setText("+");
                        break;
                    case "-":
                        operator.setText("-");
                        break;
                    case "*":
                        operator.setText("*");
                        break;
                    case "/":
                        operator.setText("/");
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "실패", Toast.LENGTH_SHORT).show();
                }
            }

            sw.setText("1");
        }
    };

    View.OnClickListener NumberListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button btn_number = (Button)view;

            if(sw.getText().toString().equals("1")){
                input.setText("0");
                sw.setText("0");
            }

            if (input.getText().toString().equals("0")) {
                input.setText(btn_number.getText().toString());
            } else {
                input.setText(input.getText().toString() + btn_number.getText().toString());
            }
        }
    };

    View.OnClickListener Click_btn_equal = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int input_number;
            int result_number = Integer.parseInt(result.getText().toString());

            if(input.getText().toString().equals("0")){
                input_number = 0;
            } else {
                input_number = Integer.parseInt(input.getText().toString());
            }

            if(sw.getText().equals("0")) {
                switch (operator.getText().toString()) {
                    case "+":
                        result.setText(String.valueOf(result_number + input_number));
                        break;
                    case "-":
                        result.setText(String.valueOf(result_number - input_number));
                        break;
                    case "/":
                        result.setText(String.valueOf(result_number / input_number));
                        break;
                    case "*":
                        result.setText(String.valueOf(result_number * input_number));
                        break;
                    default:
                        result.setText(String.valueOf(input_number));
                }

                input.setText(result.getText());
                operator.setText("=");
            }
        }
    };

    View.OnClickListener ResetListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            input.setText("0");
            result.setText("0");
            operator.setText("");
            sw.setText("0");
        }
    };

}
