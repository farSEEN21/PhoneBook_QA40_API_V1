package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter@Setter@ToString@Builder
public class ContactListDTO {
    List<ContactDto> contacts;

}
