package calculator.fractions;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class EditedText extends EditText {

	public EditedText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public EditedText(Context context, AttributeSet attrs){
		super(context, attrs);
	}

	public EditedText(Context context){
		super(context);
	}
	
	@Override
	public boolean onCheckIsTextEditor(){
		return false;
	}
}
