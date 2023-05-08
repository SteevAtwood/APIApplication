package APIApp.controller;

import APIApp.APIAppApplication;
import APIApp.model.InquirySummary;
import APIApp.repository.MySqlRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;


@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.MOCK,
    classes = APIAppApplication.class)
@TestPropertySource("classpath:application.properties")
public class inquiryControllerTest {

  @Autowired
  public WebApplicationContext wac;
  public MockMvc mockMvc;

  @Autowired
  public MySqlRepository mySqlRepository;

  @BeforeEach
  public void setUp() {
     this.mockMvc = webAppContextSetup(this.wac).build();
   
    
      InquirySummary inquirySummary1 = new InquirySummary("text1", "link1", "password1");
      InquirySummary inquirySummary2 = new InquirySummary("text2", "link2", "password2");
      mySqlRepository.save(inquirySummary1); 
      mySqlRepository.save(inquirySummary2); 
      
  }
 

  @Test
  public void InquiryControllerTest() throws Exception {
    
    this.mockMvc.perform(get("/get-all-summary"))
        .andDo(print()).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$[0].text").value("text1"))
        .andExpect(jsonPath("$[0].link").value("link1"))
        .andExpect(jsonPath("$[0].password").value("password1"))
        .andExpect(jsonPath("$[1].text").value("text2"))
        .andExpect(jsonPath("$[1].link").value("link2"))
        .andExpect(jsonPath("$[1].password").value("password2"));
  }

}


