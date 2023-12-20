package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;





    @Setter
    @ToString
    @Getter
    @Builder
    public class AuthRequestDTO {

        String username;
        String password;

    }
