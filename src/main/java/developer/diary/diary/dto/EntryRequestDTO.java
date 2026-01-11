package developer.diary.diary.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class EntryRequestDTO {
    private String title;
    private String content;
    private Long categoryId;
    private String status;
    private UUID userId; // In a real app, you'd get this from the Auth token
}
