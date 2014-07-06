package info.androidhive.volleyexamples.volley.utils;

import info.androidhive.volleyexamples.JsonUtil;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;

public class JacksonRequest<T> extends BaseJsonRequest<T> {
	
	private Class<T> mClass;
	private Listener<T> listener;
	private ErrorListener errorListener;
	private Map<String, String> mHeader;

	public JacksonRequest(int method, Class<T> classz, String url,Map<String, String> header,Listener<T> listener, ErrorListener errorListener) {
		super(url, null, listener, errorListener);
		this.mClass = classz;
		this.listener = listener;
		this.mHeader = header;
		this.errorListener = errorListener;
		
	}
	
	public JacksonRequest(int method, Class<T> classz, String url,Listener<T> listener, ErrorListener errorListener) {
		super(url, null, listener, errorListener);
		this.mClass = classz;
		this.listener = listener;
		this.errorListener = errorListener;
		
	}

	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		return mHeader != null ? mHeader : super.getHeaders();
	}
	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {
		try {
            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(
                    JsonUtil.fromString(json, mClass),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
	}

	@Override
	protected void deliverResponse(T response) {
		if (response != null) {
			listener.onResponse(response);
		} else {
			Log.e("JacksonRequest", "response null");
			this.errorListener.onErrorResponse(new VolleyError("response null"));
		}
		
	}

}
