import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
Button one, two, three, four, five, six, seven, eight,nine,zero;
Button plus, minus, div, mul, clear, equals;
EditText result;
String operatorPressed = " ";
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
result = findViewById(R.id.res); //EditText
one = findViewById(R.id.one) ;
two = findViewById(R.id.two) ;
three = findViewById(R.id.three) ;
four = findViewById(R.id.four) ;
five = findViewById(R.id.five) ;
six = findViewById(R.id.six) ;
seven = findViewById(R.id.seven) ;
eight = findViewById(R.id.eight) ;
nine = findViewById(R.id.nine) ;
zero = findViewById(R.id.zero) ;
plus = findViewById(R.id.plus) ;
minus = findViewById(R.id.minus) ;
mul = findViewById(R.id.multiply) ;
div = findViewById(R.id.divide) ;
equals = findViewById(R.id.equal) ;
clear = findViewById(R.id.clear) ;
one.setOnClickListener(this);
two.setOnClickListener(this);
three.setOnClickListener(this);
four.setOnClickListener(this);
five.setOnClickListener(this);
six.setOnClickListener(this);
seven.setOnClickListener(this);
eight.setOnClickListener(this);
nine.setOnClickListener(this);
// operators
plus.setOnClickListener(this);
minus.setOnClickListener(this);
mul.setOnClickListener(this);
div.setOnClickListener(this);
equals.setOnClickListener(this);
clear.setOnClickListener(this);
}
@Override
public void onClick(View view) {
double finalResult = 0.0;
switch(view.getId())
{
case R.id.one: result.append("1");
break;
case R.id.two: result.append("2");
break;
case R.id.three: result.append("3");
break;
case R.id.four: result.append("4");
break;
case R.id.five: result.append("5");
break;
case R.id.six: result.append("6");
break;
case R.id.seven: result.append("7");
break;
case R.id.eight: result.append("8");
break;
case R.id.nine: result.append("9");
break;
case R.id.zero: result.append("0");
break;
case R.id.plus: result.append("+");
operatorPressed="+";
break;
case R.id.minus: result.append("-");
operatorPressed="-";
break;
case R.id.multiply: result.append("*");
operatorPressed="*";
break;
case R.id.divide: result.append("/");
operatorPressed="/";
break;
case R.id.clear:result.setText(" ");
break;
case R.id.equal: finalResult=
evaluateExpression(result.getText().toString(),operatorPressed);
result.setText(String.valueOf(finalResult));
break;
default: return;
}
}
private double evaluateExpression(String res, String operatorPressed)
{
String[] tokens = res.split("\\+|-|\\*|\\/"); // split for +, -, *,/ operator
// After split tokens[0] = first half of the string, tokens[1] = second hal of the string
double firstOperand = Double.parseDouble(tokens[0]); //convert string to double
double secondOperand = Double.parseDouble(tokens[1]);
switch(operatorPressed) // Switch the operator, compute and returs the result back to
onclick that sets the editeext object to the result
{
case "+": return firstOperand + secondOperand;
case "-": return firstOperand - secondOperand;
case "*": return firstOperand * secondOperand;
case "/": return firstOperand / secondOperand;
default: return 0;
}
}
}
