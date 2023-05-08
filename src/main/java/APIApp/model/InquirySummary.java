package APIApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "inquiry_summary")
public class InquirySummary {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String text;
    private String link;
    private String password;
  
  public InquirySummary () {

  }

  public InquirySummary (String text, String link, String password) {
    this.text = text;
    this.link = link;
    this.password = password;
  }

//   public InquirySummary(String text, String link) {
// }

  public Integer getId() {
      return id;
    }
  
  public String getText() {
    return text;
  }
  
  public void setText(String text) {
    this.text = text;
  }
  
  public String getLink() {
    return link;
  }
  
  public void setLink(String link) {
    this.link = link;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
}




