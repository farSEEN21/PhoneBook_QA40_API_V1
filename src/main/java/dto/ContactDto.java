package dto;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
public class ContactDto {

//    id	string
//    name*	string
//    lastName*	string
//    email	string
//    phone	string
//    pattern: ^\d{10,15}$
//    address*	string
//    description	string



String id;
String name;
String lastName;
String email;
String phone;
String address;
String description;


}
