package map.project.demo.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Request body for a comment
 */
@Data
public class CommentDTO {

    /**
     * The author of the comment
     */
    @NotBlank
    @Size(min = 3, max = 20)
    String author;

    /**
     * The content of the comment
     */
    @NotBlank
    String content;
}
