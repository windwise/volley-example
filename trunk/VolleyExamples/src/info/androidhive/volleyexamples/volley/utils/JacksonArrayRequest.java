package info.androidhive.volleyexamples.volley.utils;

import java.util.ArrayList;

import org.json.JSONObject;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;

/**
 * @author pc
 *
 * @param <T>
 */
public class JacksonArrayRequest<T> extends BaseJsonRequest<String> {

	private JacksonArrayListener<T> mJacksonArrayListener;
	public JacksonArrayRequest(int method, String url, JSONObject jsonRequest,
			JacksonArrayListener<T> listener, ErrorListener errorListener) {
		super(method, url, jsonRequest, null, errorListener);
		this.mJacksonArrayListener = listener;
	}

	@Override
	protected Response<String> parseNetworkResponse(NetworkResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void deliverResponse(String response) {
//		super.deliverResponse(response);
		
	}

	public interface JacksonArrayListener<T> {
		void onResponse(ArrayList<T> response);
	}

	public JacksonArrayListener<T> getListener() {
		return mJacksonArrayListener;
	}

	public void setListener(JacksonArrayListener<T> mListener) {
		this.mJacksonArrayListener = mListener;
	}
	
	
}
