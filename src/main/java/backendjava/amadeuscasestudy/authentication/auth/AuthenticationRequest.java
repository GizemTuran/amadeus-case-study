package backendjava.amadeuscasestudy.authentication.auth;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    @NotNull(message = "Email is mandatory.")
    private String email;
    @NotNull(message = "Password is mandatory.")
    private String password;
}
