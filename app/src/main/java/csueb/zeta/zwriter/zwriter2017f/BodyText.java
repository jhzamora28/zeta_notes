package csueb.zeta.zwriter.zwriter2017f;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.Spannable;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.EditText;

import org.w3c.dom.Attr;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by kevin on 11/23/17.
 */

/* methods to use
    void setTypeface(Typeface tf)
    void setTypeface(Typeface tf, int style)
    setTextSize(float size)



    int	getOffsetForPosition(float x, float y)

*/

public class BodyText extends android.support.v7.widget.AppCompatEditText {
    // font size
    private static final int SIZE_LARGE = 0;
    private static final int SIZE_MEDIUM = 1;
    private static final int SIZE_NORMAL = 2;

    // Typeface
    public static final int TYPEFACE_NORMAL = 0;
    public static final int TYPEFACE_BOLD = 1;
    public static final int TYPEFACE_ITALICS = 2;
    public static final int TYPEFACE_BOLD_ITALICS = 3;


    private int currentTypeface;
    private int lastCursorPosition;
    private int typefaceID;

    final StyleSpan nSS; // normal StyleSpan
    final StyleSpan bSS; // bold StyleSpan
    final StyleSpan iSS; // italic StyleSpan
    final StyleSpan biSS; // bold_itlalic StyleSpan


    public BodyText(Context context) {
        super(context);
        nSS = new StyleSpan(Typeface.NORMAL);
        bSS = new StyleSpan(Typeface.BOLD);
        iSS = new StyleSpan(Typeface.ITALIC);
        biSS = new StyleSpan(Typeface.BOLD_ITALIC);

        lastCursorPosition = this.getSelectionStart();
    }

    public BodyText(Context context, AttributeSet attrs) {
        super(context, attrs);
        nSS = new StyleSpan(Typeface.NORMAL);
        bSS = new StyleSpan(Typeface.BOLD);
        iSS = new StyleSpan(Typeface.ITALIC);
        biSS = new StyleSpan(Typeface.BOLD_ITALIC);

        lastCursorPosition = this.getSelectionStart();
    }

    public int gettypefaceId() {
        return typefaceID;
    }

    public void settId(int typefaceID) {
        this.typefaceID = typefaceID;
    }

    public void changeTypeface(int typefaceID) {
        currentTypeface = typefaceID;
        lastCursorPosition = this.getSelectionStart();
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        Spannable str = this.getText();
        StyleSpan ss;
        int endLength = text.toString().length();



        switch(currentTypeface) {
            case TYPEFACE_NORMAL:
                ss = new StyleSpan(Typeface.NORMAL);
                break;
            case TYPEFACE_BOLD:
                ss = new StyleSpan(Typeface.BOLD);
                break;
            case TYPEFACE_ITALICS:
                ss = new StyleSpan(Typeface.ITALIC);
                break;
            case TYPEFACE_BOLD_ITALICS:
                ss = new StyleSpan(Typeface.BOLD_ITALIC);
                break;
            default:
                ss = new StyleSpan(Typeface.NORMAL);
        }
        str.setSpan(ss, lastCursorPosition, endLength, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    public void boldSwitch() {
        if ((currentTypeface & 0x01) == 1) {
            currentTypeface = currentTypeface & 0x10;
        } else {
            currentTypeface = currentTypeface | 0x01;
        }
        lastCursorPosition = this.getSelectionStart();
    }

    public void italicsSwitch() {
        int italicsFilter = currentTypeface & 0x10;
        if (italicsFilter == 0x10) {
            currentTypeface = currentTypeface & 0x01;
        } else {
            currentTypeface = currentTypeface | 0x10;
        }
        lastCursorPosition = this.getSelectionStart();
    }
    // Combine BodyText objects
    public void mergeBodyText(BodyText toBeMerged) {
        Editable text = toBeMerged.getEditableText();
        this.append("\n");
//        this.append(text);
        lastCursorPosition = this.getSelectionStart();
    }

    public BodyText SplitBodyText(int offset) {
//        XmlPullParser parser = getResources().getLayout(R.layout.body_text);
//        AttributeSet attrs = Xml.asAttributeSet(parser);
//        BodyText newBodyText = new BodyText(getContext(), attrs);
        BodyText newBodyText = new BodyText(getContext());

//        Editable splitOff = this.getText().subSequence(offset, length());
//        newBodyText.append(splitOff);

        return newBodyText;
    }

    // public onReturnPressed()

    // Put bullet points in text

    // Put numbered list in text

}
