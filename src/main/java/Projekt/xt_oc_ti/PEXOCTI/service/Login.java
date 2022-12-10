package Projekt.xt_oc_ti.PEXOCTI.service;

public class Login {
    private final Jwt accessSecret;
    private final Jwt refreshToken;
    private static final Long ACCESS_TOKEN_VALIDITY = 1L;
    private static final Long REFRESH_TOKEN_VALIDITY = 1440L;


    private Login(Jwt accessSecret, Jwt refreshToken) {
        this.accessSecret = accessSecret;
        this.refreshToken = refreshToken;
    }

    public static Login of(Long benutzerId, String accesKey, String refreshSecret){
        return new Login(
                Jwt.of(benutzerId, ACCESS_TOKEN_VALIDITY, accesKey),
                Jwt.of(benutzerId, REFRESH_TOKEN_VALIDITY, refreshSecret)
        );
    }

    public static Login of(Long userId, String accessSecret, Jwt refreshToken){
        return new Login(
                Jwt.of(userId, ACCESS_TOKEN_VALIDITY, accessSecret),
                refreshToken
        );
    }

    public Jwt getAccessSecret() {
        return accessSecret;
    }

    public Jwt getRefreshToken() {
        return refreshToken;
    }
}
