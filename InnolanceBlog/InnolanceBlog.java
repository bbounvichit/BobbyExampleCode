package innolance.innoblog;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.content.Intent;

public class InnolanceBlog extends FragmentActivity implements BlogListFragment.OnBlogSelectedListener{
	
	
	//Override onCreate method to view the blog_list_fragment
	@Override
	public void onCreate(Bundle savedInstanceState){
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.blog_list_fragment);
	}
	
	
	//MainActivity implements onBlogSelected from BlogListFragment.java
	public void onBlogSelected(String innoUrl) {
	    BlogViewFragment viewer;
	    
		//Takes a string as the parameter (should be URL)
	    // creates an instance of BlogViewFragment object and sets it to the blogview_fragment
	    viewer = (BlogViewFragment) getSupportFragmentManager().findFragmentById(R.id.blogview_fragment);
	 
	    //if the BlogViewFragment (details webview) is not yet showing, then a webview will be inflated 
	    //and a URL will be loaded
	    //The intent is used for the InnoblogView file.
	    //If there is already a blog showing, then it will be updated.
	    if (viewer == null || !viewer.isInLayout()) {
	        Intent showContent = new Intent(getApplicationContext(),
	        		InnoblogView.class);
	        showContent.setData(Uri.parse(innoUrl));
	        startActivity(showContent);
	    } else {
	        viewer.updateUrl(innoUrl);
	    } 
	    
	}
    
}
