package Projekt.xt_oc_ti.PEXOCTI.service;

import java.time.LocalDateTime;

public record Token(String refreshToken, LocalDateTime issueAt, LocalDateTime expiredAt) {
}
