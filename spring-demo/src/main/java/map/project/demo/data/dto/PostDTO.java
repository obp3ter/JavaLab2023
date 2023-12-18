package map.project.demo.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Request body for a post
 */
@Data
public class PostDTO {

    /**
     * The title of the post
     */
    @NotBlank
    @Size(min = 3, max = 20)
    String author;

    /**
     * The content of the post
     */
    @NotBlank
    String content;
}
