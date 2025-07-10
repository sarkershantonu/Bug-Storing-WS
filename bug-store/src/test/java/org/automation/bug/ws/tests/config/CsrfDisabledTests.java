package org.automation.bug.ws.tests.config;

import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CsrfDisabledTests extends CsrfTests{
    public void testNoCsrfUnauthorized() throws Exception {
        mockMvc.perform(post(authUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .content(createUser())).andExpect(status().isUnauthorized());
    }

    public void testCsrfCreatedSuccess() throws Exception {
        mockMvc.perform(post(authUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .content(createUser())).andExpect(status().isCreated());

    }
}
