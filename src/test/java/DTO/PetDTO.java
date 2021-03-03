package DTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class PetDTO {
    private int id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<TagsDTO> tags;
    private String status;
}
