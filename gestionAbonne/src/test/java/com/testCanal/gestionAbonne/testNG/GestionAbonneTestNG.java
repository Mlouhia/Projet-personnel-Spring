package com.testCanal.gestionAbonne.testNG;

import com.testCanal.gestionAbonne.GestionAbonneApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = GestionAbonneApplication.class)
public class GestionAbonneTestNG extends AbstractTestNGSpringContextTests {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeClass
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    String abonneTest = "{\n" +
            "      \"id\": 1,\n" +
            "      \"nom\": \"Mlouhia\",\n" +
            "      \"prenom\": \"Yassine\",\n" +
            "      \"adressePrincipale\": \"36 rue baudin Courbevoie\"\n" +
            "    }";

    @Test
    public void testGetContrats() throws Exception {
        mockMvc.perform(get("/abonneGetContrat/{id}",1)).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$[0].adresse").value("testAdresse1"))
                .andExpect(jsonPath("$[0].abonne").value(abonneTest))
                .andExpect(jsonPath("$[1].adresse").value("testAdresse2"))
                .andExpect(jsonPath("$[1].abonne").value(abonneTest));

    }

}
