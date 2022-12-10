package Projekt.xt_oc_ti.PEXOCTI.service;

public class Login {
    private final Jwt accessSecret;
    private final Jwt refreshToken;

    private Login(Jwt accessSecret, Jwt refreshToken) {
        this.accessSecret = accessSecret;
        this.refreshToken = refreshToken;
    }

    public static Login of(Long benutzerId, String accesKey, String refreshSecret){
        return new Login(
                Jwt.of(benutzerId, 5L, accesKey),
                Jwt.of(benutzerId, 30L, refreshSecret)
        );
    }

    public static Login of(Long userId, String accessSecret, Jwt refreshToken){
        return new Login(
                Jwt.of(userId, 1L, accessSecret),
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
