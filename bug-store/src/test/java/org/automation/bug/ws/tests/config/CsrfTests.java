package org.automation.bug.ws.tests.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.Filter;
import org.automation.bug.ws.core.ControllerTestBase;
import org.automation.bug.ws.ws.model.UserInfo;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = {})
public abstract class CsrfTests extends ControllerTestBase {

    protected final String authUrl="/auth/user";
    @Autowired
    protected Filter securityFilterChain;
    @BeforeEach
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).addFilter(securityFilterChain).build();
    }

    protected String createUser() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(new UserInfo(randomAlphabetic(6)));
    }

}
