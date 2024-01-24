package lk.mobitel.abcbank.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
//    @NotBlank(message = "ID can't be empty")
    @Pattern(regexp = "^\\d{9}V$|^\\d{11}V$",message = "Invalid ID")
    private String nic;
    @NotBlank(message = "Name can't be empty")
    @Pattern(regexp = "[A-Za-z ]{2,}",message = "Invalid name")
    private String name;
    @NotBlank(message = "Name can't be empty")
    @Pattern(regexp ="[A-Za-z0-9/, ]{3,}",message = "Invalid address")
    private String address;
    @NotBlank(message = "Mobile number can't be empty")
    @Pattern(regexp ="0\\d{9}",message = "Invalid mobile number")
    private String mobileNo;
}
