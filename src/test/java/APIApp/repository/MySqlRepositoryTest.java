// package APIApp.repository;

// import java.util.List;

// import org.assertj.core.api.Assert;
// import org.assertj.core.api.Assertions;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.AutoConfiguration;
// import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
// import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// import APIApp.model.InquirySummary;

// @DataJpaTest
// @AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
// public class MySqlRepositoryTest {


//     @Autowired
//     private MySqlRepository mySqlRepository;
//     InquirySummary inquirySummary;

//     //Junit test for saveSummary
//     @Test
//     public void saveSummary(){
        
//         InquirySummary inquirySummary = InquirySummary.builder()
//               .text("text")
//               .link("link")
//               .password("password")
//               .build();

//         InquirySummary savedSummary = mySqlRepository.save(inquirySummary);

//         Assertions.assertThat(savedSummary).isNotNull();
//         Assertions.assertThat(savedSummary.getId()).isGreaterThan(0);
//     }

//     @Test
//     public void getAllSummary() {

//       InquirySummary inquirySummary = InquirySummary.builder()
//               .text("text")
//               .link("link")
//               .password("password")
//               .build();

//       InquirySummary inquirySummary2 = InquirySummary.builder()
//               .text("text")
//               .link("link")
//               .password("password")
//               .build();  

//       mySqlRepository.save(inquirySummary);
//       mySqlRepository.save(inquirySummary2);

//       List<InquirySummary> summaryList = mySqlRepository.findAll();

//       Assertions.assertThat(summaryList).isNotNull();
//       Assertions.assertThat(summaryList.size()).isEqualTo(2);
//     }

//     @Test
//     public void getSummary() {
//       InquirySummary inquirySummary = InquirySummary.builder()
//               .text("text")
//               .link("link")
//               .password("password")
//               .build();

//        mySqlRepository.save(inquirySummary);

//        InquirySummary summaryList =  mySqlRepository.findById(inquirySummary.getId()).get();
    
//       Assertions.assertThat(summaryList).isNotNull();
//     }

       
//     @Test
//     public void updateSummary() {
//       InquirySummary inquirySummary = mySqlRepository.findById(1).get();
    
//       inquirySummary.setText("textUPDATED");

//       InquirySummary summaryUpdated = mySqlRepository.save(inquirySummary);
//       Assertions.assertThat(summaryUpdated.getText()).isEqualTo("textUPDATED");
//     }

    
   
   
//     // @BeforeEach
//     // void setUp() {
//     //     inquirySummary = new InquirySummary("text", "link", "password");
//     // mySqlRepository.save(inquirySummary); 
//     // }

//     // @AfterEach
//     // void tearDown() {
//     //     inquirySummary = null;
//     //     mySqlRepository.deleteAll();
//     // }

    

// }
