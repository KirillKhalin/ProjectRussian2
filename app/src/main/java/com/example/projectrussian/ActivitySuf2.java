package com.example.projectrussian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitySuf2 extends AppCompatActivity implements View.OnDragListener, View.OnLongClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suf2);
        //Find all views and set Tag to all draggable views
        TextView txtVw1 = (TextView) findViewById(R.id.txt1);
        txtVw1.setTag("DRAGGABLE TEXTVIEW1");
        txtVw1.setOnLongClickListener(this);
        TextView txtVw2 = (TextView) findViewById(R.id.txt2);
        txtVw2.setTag("DRAGGABLE TEXTVIEW2");
        txtVw2.setOnLongClickListener(this);
        TextView txtVw3 = (TextView) findViewById(R.id.txt3);
        txtVw3.setTag("DRAGGABLE TEXTVIEW3");
        txtVw3.setOnLongClickListener(this);
        TextView txtVw4 = (TextView) findViewById(R.id.txt4);
        txtVw4.setTag("DRAGGABLE TEXTVIEW4");
        txtVw4.setOnLongClickListener(this);
        TextView txtVw5 = (TextView) findViewById(R.id.txt5);
        txtVw5.setTag("DRAGGABLE TEXTVIEW5");
        txtVw5.setOnLongClickListener(this);
        TextView txtVw6 = (TextView) findViewById(R.id.txt6);
        txtVw6.setTag("DRAGGABLE TEXTVIEW6");
        txtVw6.setOnLongClickListener(this);
        TextView txtVw7 = (TextView) findViewById(R.id.txt7);
        txtVw7.setTag("DRAGGABLE TEXTVIEW7");
        txtVw7.setOnLongClickListener(this);
        TextView txtVw8 = (TextView) findViewById(R.id.txt8);
        txtVw8.setTag("DRAGGABLE TEXTVIEW8");
        txtVw8.setOnLongClickListener(this);
        TextView txtVw9 = (TextView) findViewById(R.id.txt9);
        txtVw9.setTag("DRAGGABLE TEXTVIEW9");
        txtVw9.setOnLongClickListener(this);
        TextView txtVw10 = (TextView) findViewById(R.id.txt10);
        txtVw10.setTag("DRAGGABLE TEXTVIEW10");
        txtVw10.setOnLongClickListener(this);
        TextView txtVw11 = (TextView) findViewById(R.id.txt11);
        txtVw11.setTag("DRAGGABLE TEXTVIEW11");
        txtVw11.setOnLongClickListener(this);
        TextView txtVw12 = (TextView) findViewById(R.id.txt12);
        txtVw12.setTag("DRAGGABLE TEXTVIEW12");
        txtVw12.setOnLongClickListener(this);
        //Set Drag Event Listeners for defined layouts
        findViewById(R.id.layout1).setOnDragListener(this);
        findViewById(R.id.layout2).setOnDragListener(this);
        findViewById(R.id.layout3).setOnDragListener(this);
        findViewById(R.id.layout4).setOnDragListener(this);
        findViewById(R.id.layout5).setOnDragListener(this);
        findViewById(R.id.layout6).setOnDragListener(this);
        findViewById(R.id.layout7).setOnDragListener(this);
        findViewById(R.id.layout8).setOnDragListener(this);
    }
    @Override
    public boolean onLongClick(View v) {
        // Create a new ClipData.Item from the ImageView object's tag
        ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
        // Create a new ClipData using the tag as a label, the plain text MIME type, and
        // the already-created item. This will create a new ClipDescription object within the
        // ClipData, and set its MIME type entry to "text/plain"
        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
        ClipData data = new ClipData(v.getTag().toString(), mimeTypes, item);
        // Instantiates the drag shadow builder.
        View.DragShadowBuilder dragshadow = new View.DragShadowBuilder(v);
        // Starts the drag
        v.startDrag(data        // data to be dragged
                , dragshadow   // drag shadow builder
                , v           // local data about the drag and drop operation
                , 0          // flags (not currently used, set to 0)
        );
        return true;
    }
    // This is the method that the system calls when it dispatches a drag event to the listener.
    @Override
    public boolean onDrag(View v, DragEvent event) {
        // Defines a variable to store the action type for the incoming event
        int action = event.getAction();
        // Handles each of the expected events
        switch (action) {

            case DragEvent.ACTION_DRAG_STARTED:
                // Determines if this View can accept the dragged data
                if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    // if you want to apply color when drag started to your view you can uncomment below lines
                    // to give any color tint to the View to indicate that it can accept data.
                    // v.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
                    // Invalidate the view to force a redraw in the new tint
                    //  v.invalidate();
                    // returns true to indicate that the View can accept the dragged data.
                    return true;
                }
                // Returns false. During the current drag and drop operation, this View will
                // not receive events again until ACTION_DRAG_ENDED is sent.
                return false;

            case DragEvent.ACTION_DRAG_ENTERED:
                // Applies a GRAY or any color tint to the View. Return true; the return value is ignored.
                v.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
                // Invalidate the view to force a redraw in the new tint
                v.invalidate();
                return true;

            case DragEvent.ACTION_DRAG_LOCATION:
                // Ignore the event
                return true;

            case DragEvent.ACTION_DRAG_EXITED:
                // Re-sets the color tint to blue. Returns true; the return value is ignored.
                // view.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
                //It will clear a color filter .
                v.getBackground().clearColorFilter();
                // Invalidate the view to force a redraw in the new tint
                v.invalidate();
                return true;

            case DragEvent.ACTION_DROP:
                // Gets the item containing the dragged data
                ClipData.Item item = event.getClipData().getItemAt(0);
                // Gets the text data from the item.
                String dragData = item.getText().toString();
                // Displays a message containing the dragged data.
                Toast.makeText(this, "Dragged data is " + dragData, Toast.LENGTH_SHORT).show();
                // Turns off any color tints
                v.getBackground().clearColorFilter();
                // Invalidates the view to force a redraw
                v.invalidate();

                View vw = (View) event.getLocalState();
                ViewGroup owner = (ViewGroup) vw.getParent();
                owner.removeView(vw); //remove the dragged view
                //caste the view into LinearLayout as our drag acceptable layout is LinearLayout
                LinearLayout container = (LinearLayout) v;
                container.addView(vw);//Add the dragged view
                vw.setVisibility(View.VISIBLE);//finally set Visibility to VISIBLE
                // Returns true. DragEvent.getResult() will return true.
                return true;

            case DragEvent.ACTION_DRAG_ENDED:
                // Turns off any color tinting
                v.getBackground().clearColorFilter();
                // Invalidates the view to force a redraw
                v.invalidate();
                // Does a getResult(), and displays what happened.
                if (event.getResult())
                    Toast.makeText(this, "The drop was handled.", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "The drop didn't work.", Toast.LENGTH_SHORT).show();
                // returns true; the value is ignored.
                return true;
            // An unknown action type was received.
            default:
                Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
                break;
        }
        return false;
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, ActivitySuf.class);
        startActivity(intent);
    }

    public void goMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goAnswer(View view) {
        TextView tView = (TextView) findViewById(R.id.txt1);
        tView.setText(" претерпЕвающий (суфф. ва под удар.) ");
        tView = (TextView) findViewById(R.id.txt2);
        tView.setText(" замшЕвый (суфф. ев без удар.) ");
        tView = (TextView) findViewById(R.id.txt3);
        tView.setText(" каракулЕвый (суфф. ев без удар.)");
        tView = (TextView) findViewById(R.id.txt4);
        tView.setText(" юродИвый (прил. искл.) ");
        tView = (TextView) findViewById(R.id.txt5);
        tView.setText(" маслИце (ср. род, удар. на основу) ");
        tView = (TextView) findViewById(R.id.txt6);
        tView.setText(" извилИна (ин неизм.) ");
        tView = (TextView) findViewById(R.id.txt7);
        tView.setText(" измучЕнный (енн в прич.) ");
        tView = (TextView) findViewById(R.id.txt8);
        tView.setText(" смекалИстый (ист неизм.) ");
        tView = (TextView) findViewById(R.id.txt9);
        tView.setText(" нулЕвой (суфф. ев без удар.)  ");
        tView = (TextView) findViewById(R.id.txt10);
        tView.setText(" книжИца (ж. род) ");
        tView = (TextView) findViewById(R.id.txt11);
        tView.setText(" кроЕтся (1 спр.) ");
        tView = (TextView) findViewById(R.id.txt12);
        tView.setText(" выздоровЕть (самому -> ЕТЬ) ");
    }

    public void goNext(View view) {
        Intent intent = new Intent(this, ActivityNNN2.class);
        startActivity(intent);
    }
}