package Projekt.xt_oc_ti.PEXOCTI;


import Projekt.xt_oc_ti.PEXOCTI.Exceptions.NutzerExistiertBereitsException;
import Projekt.xt_oc_ti.PEXOCTI.api.User;
import Projekt.xt_oc_ti.PEXOCTI.api.UserManipulationRequest;
import Projekt.xt_oc_ti.PEXOCTI.persistence.UserEntity;
import Projekt.xt_oc_ti.PEXOCTI.persistence.UserRepository;
import Projekt.xt_oc_ti.PEXOCTI.service.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(value = UserRestController.class)
public class UserRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("should return 201 http status and Location header when creating a user")
    void should_return_201_http_status_and_location_header_when_creating_a_user() throws Exception {
        //given
        String userToCreateAsJson = "{\"vorname\": \"Testi\", \"nachname\":\"McTestface\", \"benutzername\":\"TESTosteron\", \"passwort\": \"T3S7!\" }";
        var user = new User(7357L,null, null, "Test", null, Collections.emptyList());
        doReturn(user).when(userService).create(any());

        mockMvc.perform(post("/api/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userToCreateAsJson)
        )
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/api/user/"+ user.getId()))));

    }

    @Test()
    @DisplayName("should_return_400_http_status_and_NutzerExistiertBereitsException_when_creating_a_user_where_benutzername_already_exists")
    void should_return_400_http_status_and_NutzerExistiertBereitsException_when_creating_a_user_where_benutzername_already_exists() throws Exception {
        //given
        String userToCreateAsJson = "{\"vorname\": \"Testi\", \"nachname\":\"McTestface\", \"benutzername\":\"TESTosteron\", \"passwort\": \"T3S7!\" }";
        var repo = Mockito.mock(UserRepository.class);
        var user = new User(7357L,null, null, "Test", null, Collections.emptyList());
        String exceptionParam = "Benutzername existiert bereits";

        doThrow(new NutzerExistiertBereitsException()).when(userService).create(any());

        mockMvc.perform(post("/api/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userToCreateAsJson))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {assertTrue(result.getResolvedException() instanceof NutzerExistiertBereitsException);})
                .andExpect(result -> assertEquals("400 BAD_REQUEST \"Benutzername existiert bereits\"", result.getResolvedException().getMessage()));

    }



    @Test
    @DisplayName("should_return_an_authorizationError")
    void  should_return_an_authorizationError() throws Exception {
        // given
        var user = new User(99L, "Testi","McTestface", "TESTosteron", "T3S7!", Collections.emptyList());
        doReturn(user).when(userService).findById(99L);

        // when
        mockMvc.perform(get("/api/user"))
        ///then
                .andExpect(status().isUnauthorized());
    }
}
