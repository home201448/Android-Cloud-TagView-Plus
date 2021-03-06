package me.kaede.sample;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import me.kaede.tagview.OnTagClickListener;
import me.kaede.tagview.OnTagDeleteListener;
import me.kaede.tagview.Tag;
import me.kaede.tagview.TagView;

import java.util.Random;


public class MainActivity extends ActionBarActivity {
    View.OnClickListener listener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tv_add:
                    String string ="ADD A TAG";
                    if (editText.getText().toString()!=null&&!editText.getText().toString().equals(""))
                        string=editText.getText().toString();
                    Tag tag = new Tag(string);
                    int r = random.nextInt(2);
                    if (r==0)tag.isDeletable=true;
                    r = random.nextInt(5);
                    tag.layoutColor =Color.parseColor(MainActivity.this.getResources().getStringArray(R.array.colors)[r]);
                    tagView.addTag(tag);
                    break;
                case R.id.tv_start_activity:
                    startActivityForResult(new Intent(MainActivity.this,SecondActivity.class),0);
                    break;
            }
        }
    };
    private TagView tagView;
    private EditText editText;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv_add).setOnClickListener(listener);
        findViewById(R.id.tv_start_activity).setOnClickListener(listener);
        editText = (EditText) findViewById(R.id.edit_tag);

        tagView = (TagView) this.findViewById(R.id.tagview);
        //SET LISTENER
        tagView.setOnTagClickListener(new OnTagClickListener() {

            @Override
            public void onTagClick(Tag tag, int position) {
                Toast.makeText(MainActivity.this, "click tag id=" + tag.id + " position=" + position, Toast.LENGTH_SHORT).show();
            }
        });
        tagView.setOnTagDeleteListener(new OnTagDeleteListener() {

            @Override
            public void onTagDeleted(Tag tag, int position) {
                Toast.makeText(MainActivity.this, "delete tag id=" + tag.id + " position=" + position, Toast.LENGTH_SHORT).show();
            }
        });

        //ADD TAG
        String[] tags = getResources().getStringArray(R.array.continents);
        tagView.addTags(tags);
        random = new Random();

	    String[] colors = this.getResources().getStringArray(R.array.colors);

	    for (int i = 1;i<colors.length;i++){
		    Tag tag = new Tag("Colorful Text");
		    tag.tagTextColor = Color.parseColor(colors[i]);
		    tagView.addTag(tag);
	    }

	    for (String item : colors){
		    Tag tag = new Tag("Colorful Background");
		    tag.layoutColor = Color.parseColor(item);
		    tagView.addTag(tag);
	    }

	    Tag tag = new Tag("Border");
	    tag.layoutBorderSize = 1f;
	    tagView.addTag(tag);

	    tag = new Tag("Border");
	    tag.layoutBorderSize = 2f;
	    tag.layoutBorderColor = Color.parseColor(colors[1]);
	    tagView.addTag(tag);

	    tag = new Tag("Border");
	    tag.layoutBorderSize = 3f;
	    tag.layoutBorderColor = Color.parseColor(colors[3]);
	    tagView.addTag(tag);

	    tag = new Tag("Round Corner");
	    tag.radius = 0f;
	    tagView.addTag(tag);

	    tag = new Tag("Round Corner");
	    tag.radius = 20f;
	    tagView.addTag(tag);

	    tag = new Tag("Round Corner");
	    tag.radius = 60f;
	    tagView.addTag(tag);

	    tag = new Tag("Deletable");
	    tag.isDeletable=true;
	    tagView.addTag(tag);

	    tag = new Tag("Custom Background");
	    tag.tagTextColor = Color.parseColor(colors[0]);
	    tag.background = this.getResources().getDrawable(R.drawable.bg_tag);
	    tagView.addTag(tag);

	    tag = new Tag("Detail Tag");
	    tag.tagTextColor = Color.parseColor("#FFFFFF");
	    tag.layoutColor =  Color.parseColor("#DDDDDD");
	    tag.layoutColorPress = Color.parseColor("#555555");
	    //or tag.background = this.getResources().getDrawable(R.drawable.custom_bg);
	    tag.radius = 20f;
	    tag.tagTextSize = 14f;
	    tag.layoutBorderSize = 1f;
	    tag.layoutBorderColor = Color.parseColor("#FFFFFF");
	    tag.isDeletable = true;
	    tagView.addTag(tag);



		/*Tag tag1=new Tag( "TAG1");
        tagView.addTag(tag1);
		Tag tag2=new Tag( "TAG2 TAG2");
		tagView.addTag(tag2);
		Tag tag3=new Tag( "TAG3 TAG3 TAG3");
		tagView.addTag(tag3);
		Tag tag4=new Tag( "TAG4 TAG4 TAG4 TAG4 TAG4 TAG4");
		tagView.addTag(tag4);

		Tag tag5=new Tag( "TAG5");
		tag5.text ="I'm TAG5";
		tag5.layoutColor= Color.parseColor("#BE5CD6");
		tag5.layoutColorPress=Color.parseColor("#4EC6E4");
		tagView.addTag(tag5);

		Tag tag6 =new Tag(123, "TAG6", "#D52B2B");
		tagView.addTag(tag6);

		Tag tag7 =new Tag(123, "TAG7", "#48EBA9");
		tag7.tagTextSize=30;
		tagView.addTag(tag7);

		Tag tag8 =new Tag(123, "TAG8", "#947EB5");
		tag8.tagTextSize=20;
		tag8.radius=100;
		tagView.addTag(tag8);

		Tag tag9 =new Tag(123, "TAG9", "#D65CBE");
		tag9.isDeletable=false;
		tag9.radius=0;
		tag9.tagTextSize=40;
		tagView.addTag(tag9);

		Tag tag10 =new Tag(123, "TAG10", "#48EBA9");
		tag10.tagTextSize=4;
		tagView.addTag(tag10);

		Tag tag11 = new Tag("TAG11", "#FFC125");
		tagView.addTag(tag11);

		Tag tag12 = new Tag("TAG122", "#FFC125");
		tagView.addTag(tag12);

		Tag tag13 = new Tag("TAG1333", "#FFC125");
		tagView.addTag(tag13);

		Tag tag14 = new Tag("TAG14444", "#FFC125");
		tagView.addTag(tag14);

		Tag tag15 = new Tag("TAG155555", "#FFC125");
		tagView.addTag(tag15);

		Tag tag16 = new Tag("TAG1666666", "#FFC125");
		tagView.addTag(tag16);




		//You can also create TagView by
		TagView tagview2 = new TagView(this);
		tagview2.setLineMargin(20f);//dp
		tagview2.setTagMargin(20f);
		tagview2.setTextPaddingLeft(20f);
		tagview2.setTextPaddingTop(20f);
		tagview2.setTextPaddingRight(20f);
		tagview2.setTexPaddingBottom(20f);*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            Tag tag = new Tag("ADD AFTER ACTIVITY RESULT");
            tagView.addTag(tag);
        }
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_github) {
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("https://github.com/kaedea/"));
			startActivity(intent);
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
