package nl.han.spotitube.alt.spotitube.dtos;

public class UserDTO {
  
  private String username;
  private String token;

  public UserDTO(String username, String token) {
    this.username = username;
    this.token = token;
  }

  public String getUsername() {
    return username;
  }

  public String getToken() {
    return token;
  }

  public void setUsername() {
    this.username = username;
  }

  public void setToken() {
    this.token = token;
  }

}
