package innolance.innoblog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class InnoblogView extends FragmentActivity{

	//Overrides the onCreate method to view the blog_view_fragment fragment.
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.blog_view_fragment);
	    
	    
	    //Gets the intent from the MainActivity implemented method onBlogSelected
	    Intent launchingIntent = getIntent();
	    //variable content is equal to a URL set from the onBlogSelected method
	    String content = launchingIntent.getData().toString();
	 
	    
	    //creates an instance of BlogViewFragment and sets it to  blogview_fragment 
	    BlogViewFragment viewer = (BlogViewFragment) getSupportFragmentManager()
	            .findFragmentById(R.id.blogview_fragment);
	     
	    //updates the URL in the blogview_fragment
	    viewer.updateUrl(content);
	}
}
