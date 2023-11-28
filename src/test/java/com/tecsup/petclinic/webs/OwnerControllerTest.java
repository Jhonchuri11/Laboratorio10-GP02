package com.tecsup.petclinic.webs;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecsup.petclinic.domain.OwnerTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@Slf4j
public class OwnerControllerTest {

    private static final ObjectMapper om = new ObjectMapper();
    // Instanciando Autowired

    @Autowired
    private MockMvc mockMvc;

    // Prueba de integracion actualizar el owner
    /**
     * @throws Exception
     */
    @Test
    public void testUpdateOwner() throws Exception {

        String FIRST_NAME = "George";
        String LAST_NAME = "Franklin";
        String ADDRESS = "110 W. Liberty St.";
        String CITY = "Madison";
        String TELEPHONE = "6085551023";

        OwnerTO newOwnerTO = new OwnerTO();


        newOwnerTO.setFirst_name(FIRST_NAME);
        newOwnerTO.setLast_name(LAST_NAME);
        newOwnerTO.setAddress(ADDRESS);
        newOwnerTO.setCity(CITY);
        newOwnerTO.setTelephone(TELEPHONE);

        // Este metodo implementado tambien es funcional
      //  String jsonPet = om.writeValueAsString(newOwnerTO);

        // Realizamos la solicituf con el método PUT al OwnerController para ejecutar la actualización de data

        //mockMvc.perform(MockMvcRequestBuilders.put("/owners/{id}", 1)
         //       .content(jsonPet)
           //             .contentType(MediaType.APPLICATION_JSON))
             //   .andExpect(MockMvcResultMatchers.status().isOk())
               // .andExpect(MockMvcResultMatchers.jsonPath("$.first_name").value(FIRST_NAME))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.last_name").value(LAST_NAME))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.address").value(ADDRESS))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.city").value(CITY))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.telephone").value(TELEPHONE));


        mockMvc.perform(put("/owners/{id}", 1)
                        .content(om.writeValueAsString(newOwnerTO))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.first_name", is(FIRST_NAME)))
                .andExpect(jsonPath("$.last_name", is(LAST_NAME)))
                .andExpect(jsonPath("$.address", is(ADDRESS)))
                .andExpect(jsonPath("$.city", is(CITY)))
                .andExpect(jsonPath("$.telephone", is(TELEPHONE)));

    }
}
