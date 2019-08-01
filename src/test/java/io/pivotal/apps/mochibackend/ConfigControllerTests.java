package io.pivotal.apps.mochibackend;

import io.pivotal.apps.mochibackend.config.BackendConfig;
import io.pivotal.apps.mochibackend.controller.ConfigController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(ConfigController.class)
public class ConfigControllerTests {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private BackendConfig backendConfig;

  @Test
  public void mochiNextInTodayOverridesMochiOut() throws Exception {
    given(backendConfig.getNextIn()).willReturn(new Date());
    given(backendConfig.isMochiIn()).willReturn(false);

    mvc.perform(MockMvcRequestBuilders.get("/api/config"))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.mochiIn").value(true)
        );
  }

  @Test
  public void mochiNextInEmptyDefaultsToMochiIn() throws Exception {
    given(backendConfig.getNextIn()).willReturn(null);
    given(backendConfig.isMochiIn()).willReturn(false);

    mvc.perform(MockMvcRequestBuilders.get("/api/config"))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.mochiIn").value(false)
        );
  }
}
