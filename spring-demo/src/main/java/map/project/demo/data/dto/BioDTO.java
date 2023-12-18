package map.project.demo.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Request body for a bio
 */
@Data
public class BioDTO {

    /**
     * The name of the user
     */
    @NotBlank
    @Size(min = 3, max = 20)
    String name;

    /**
     * The bio of the user
     */
    @NotBlank
    String bio;
}
