package net.koofr.api.http.impl.basic;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

import net.koofr.api.http.Response;

public class BasicResponse implements Response {

  HttpURLConnection cnx;
  
  protected BasicResponse(HttpURLConnection cnx) {
    this.cnx = cnx;
  }
  
  @Override
  public int getStatus() throws IOException {
    return cnx.getResponseCode();
  }

  @Override
  public InputStream getInputStream() throws IOException {
    return cnx.getInputStream();
  }

  public Map<String, List<String>>getHeaders() {
    return cnx.getHeaderFields();    
  }
  
  public String getHeader(String name) {
    return cnx.getHeaderField(name);
  }
  
}