package info.androidhive.volleyexamples.volley.utils;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response.ErrorListener;

public abstract class BaseRequest<T> extends Request<T> {

	public BaseRequest(int method, String url, ErrorListener listener) {
		super(method, url, listener);
		setRetryPolicy(new DefaultRetryPolicy(10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
	}

}
