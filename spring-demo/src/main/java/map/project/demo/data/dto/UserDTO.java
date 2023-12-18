package map.project.demo.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Request body for a user
 */
@Data
public class UserDTO {

    /**
     * The name of the user
     */
    @NotBlank
    @Size(min = 3, max = 20)
    String name;
}
