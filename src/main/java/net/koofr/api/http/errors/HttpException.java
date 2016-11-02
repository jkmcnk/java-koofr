package net.koofr.api.http.errors;

import java.io.IOException;

import net.koofr.api.http.Response;

public class HttpException extends IOException {
  static final long serialVersionUID = 1L;

  int code;
  
  public static class Conflict extends HttpException {
    protected Conflict() {
      super(409, "Conflict");
    }
  }
  
  public static class Unauthorized extends HttpException {
    protected Unauthorized() {
      super(401, "Unauthorized");
    }
  }

  public static class NotFound extends HttpException {
    protected NotFound() {
      super(404, "Not found");
    }
  }
  
  public static class Forbidden extends HttpException {
    protected Forbidden() {
      super(403, "Forbidden");
    }
  }
  
  public static Response checkResponse(Response rs) throws IOException {
    int code = rs.getStatus(); 
    if(code / 100 == 2) {
      return rs;
    }
    switch(code) {
    case 404:
      throw new NotFound();
    case 401:
      throw new Unauthorized();
    case 403:
      throw new Forbidden();
    case 409:
      throw new Conflict();
    default:
      throw new HttpException(code);
    }    
  }
  
  protected HttpException(int code) {
    super("Server responded with: " + code);
    this.code = code;
  }
  
  protected HttpException(int code, String message) {
    super(message);
    this.code = code;
  }
  
}