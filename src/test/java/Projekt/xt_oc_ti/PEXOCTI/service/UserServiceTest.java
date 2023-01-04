package Projekt.xt_oc_ti.PEXOCTI.service;

import Projekt.xt_oc_ti.PEXOCTI.api.User;
import Projekt.xt_oc_ti.PEXOCTI.persistence.UserEntity;
import Projekt.xt_oc_ti.PEXOCTI.persistence.UserRepository;
import Projekt.xt_oc_ti.PEXOCTI.persistence.ZugangEntity;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest implements WithAssertions {



    @Test
    @DisplayName("should transform UserEntity to User")
    void should_transform_userEntity_to_User() {
        //given
        UserService userService = new UserService(null, null, null, null);
        var userEntity = Mockito.mock(UserEntity.class);
        doReturn(654L).when(userEntity).getId();
        doReturn("Joachim").when(userEntity).getVorname();
        doReturn("Mustermann").when(userEntity).getNachname();
        doReturn("Juchte").when(userEntity).getBenutzername();
        doReturn("Passwort123").when(userEntity).getPasswort();
        doReturn(List.of(new ZugangEntity())).when(userEntity).getKontostand();
        //when
        var result = userService.transformEntity(userEntity);
        //then
        assertThat(result.getId()).isEqualTo(654L);
        assertThat(result.getVorname()).isEqualTo("Joachim");
        assertThat(result.getNachname()).isEqualTo("Mustermann");
        assertThat(result.getBenutzername()).isEqualTo("Juchte");
        assertThat(result.getPasswort()).isEqualTo("Passwort123");
        assertThat(result.getKontostandIDs()).hasSize(1);
    }

    @Mock
    UserRepository repo;

    @InjectMocks
    UserService underTest;

    @Test
    @DisplayName("should return true if delete was successful")
    void testDelete(){
        //given
        Long givenId = 666L;
        doReturn(true).when(repo).existsById(givenId);

        //when
        boolean result = underTest.deleteById(givenId);

        //then
        verify(repo).deleteById(givenId);
        assertThat(result).isTrue();
    }



    @Test
    @DisplayName("should return false if user to delete does not exist")
    void testDelete2(){
        //given
        Long givenId = 666L;
        doReturn(false).when(repo).existsById(givenId);

        // when
        boolean result = underTest.deleteById(givenId);

        // then
        verifyNoMoreInteractions(repo);
        assertThat(result).isFalse();
    }

}
