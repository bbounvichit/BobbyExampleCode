package innolance.innoblog;


import android.app.Activity;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BlogListFragment extends ListFragment{
	
	//instance of OnBlogSelectedListener is created
	private OnBlogSelectedListener blogSelectedListener;

	
	//the onListItemClick method is overrided to present the correct URL when an item on the list is clicekd.
	//
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
	    String[] links = getResources().getStringArray(R.array.blog_links);
	    
	    String content = links[position];
	    //sends the content(string of the URL) as the parameter of onBlogSelected in MainActivity
	    blogSelectedListener.onBlogSelected(content);
	}
	 
	
	//Overrides onCreate method to set the blog_list to view all correct blog titles
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setListAdapter(ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.blog_titles,R.layout.blog_list));
	}
	
	//interface created
	public interface OnBlogSelectedListener {
	    public void onBlogSelected(String blogUri);
	}
	
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
				blogSelectedListener = (OnBlogSelectedListener) activity;
		} catch (ClassCastException e) {
				throw new ClassCastException(activity.toString()
						+ "must implement OnTutSelectedListener" );
		}
	}

}
