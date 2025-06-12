package nl.han.spotitube.alt.spotitube.dtos;

public class CredentialsDTO {
  
  private String user;
  private String password;

  public CredentialsDTO(String user, String password) {
    this.user = user;
    this.password = password;
  }

  public String getUser() {
    return user;
  }

  public String getPassword() {
    return password;
  }
}
