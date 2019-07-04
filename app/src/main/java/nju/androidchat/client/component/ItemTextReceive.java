package nju.androidchat.client.component;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.StyleableRes;

import java.util.UUID;

import nju.androidchat.client.R;

public class ItemTextReceive extends LinearLayout {


    @StyleableRes
    int index0 = 0;

    private TextView textView;
    private Context context;
    private UUID messageId;
    private OnRecallMessageRequested onRecallMessageRequested;


    public ItemTextReceive(Context context, String text, UUID messageId,boolean isImage) {
        super(context);
        this.context = context;
        if(!isImage) {
            inflate(context, R.layout.item_text_receive, this);
            this.textView = findViewById(R.id.chat_item_content_text);
            this.messageId = messageId;
            setText(text);
        }
        else {
            inflate(context, R.layout.item_text_receive, this);
            this.textView = findViewById(R.id.chat_item_content_text);
            String htmlFor02 =  "<img src='" + text+ "'>" ;
            setText(Html.fromHtml(htmlFor02, new Html.ImageGetter(){

                @Override
                public Drawable getDrawable(String source) {
                    int id = Integer.parseInt(source);
                    Drawable drawable = getResources().getDrawable(id, null);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth() ,
                            drawable.getIntrinsicHeight());
                    return drawable;
                }
            },null));
        }
    }



    public void init(Context context) {

    }

    public String getText() {
        return textView.getText().toString();
    }

    public void setText(String text) {
        textView.setText(text);
    }
}
