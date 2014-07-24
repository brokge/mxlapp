package Adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ViewPagerAdapter extends PagerAdapter {
	

    private ArrayList<View> views;
    
    public ViewPagerAdapter(ArrayList<View> views){
        this.views = views;
    }
       

	@Override
	public int getCount() {
		 if (views != null) {
             return views.size();
         }      
         return 0;
	}

	@Override
	public boolean isViewFromObject(View view, Object arg1) {
		return (view == arg1);
	}

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //return super.instantiateItem(container, position);
        container.addView(views.get(position));
        return views.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }
}
